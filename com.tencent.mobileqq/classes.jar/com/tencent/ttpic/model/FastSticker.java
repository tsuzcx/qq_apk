package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.AIActionCounter.AI_TYPE;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.HotAreaActionCounter;
import com.tencent.aekit.plugin.core.IAIDataClassifier;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.ttpic.baseutils.audio.PlayerUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil.Player;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.facedetect.FaceActionCounterListener;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.filter.VideoFilterList;
import com.tencent.ttpic.openapi.manager.TriggerStateManager;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.openapi.model.RedPacketPosition;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.StickerItem.ValueRange;
import com.tencent.ttpic.openapi.model.TriggerStateItem;
import com.tencent.ttpic.openapi.recorder.ActVideoDecoder;
import com.tencent.ttpic.openapi.ttpicmodule.AETriggerAnalyzer;
import com.tencent.ttpic.openapi.util.TriggerUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.util.PersonParam;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class FastSticker
{
  private AIAttr aiAttr = null;
  protected String dataPath;
  protected long frameStartTime;
  protected int height;
  private ArrayList<RedPacketPosition> hotAreaPositions;
  protected boolean isImageReady;
  private boolean isItemTriggerCountOnce = false;
  protected StickerItem item;
  private int lastImageIndex = -1;
  private boolean mAudioPause;
  private boolean mHasBodyDetected = false;
  private boolean mHasSeenValid = false;
  protected boolean mIsRenderForBitmap = false;
  private PlayerUtil.Player mPlayer;
  public List<PointF> mPreviousBodyPoints = null;
  private long mPreviousLostTime = System.currentTimeMillis();
  protected double mScreenScale;
  private long mTimesForLostProtect = 2000L;
  protected ActVideoDecoder mVideoDecoder;
  protected int playCount = 0;
  private int renderID = 0;
  protected RenderParam renderParam = new RenderParam();
  private int[] tex = new int[1];
  protected TriggerCtrlItem triggerCtrlItem;
  private ArrayList<String> triggerState;
  private StickerItem.ValueRange triggerStateRange;
  protected boolean triggered = false;
  protected int width;
  
  FastSticker(StickerItem paramStickerItem, String paramString)
  {
    this.item = paramStickerItem;
    this.dataPath = paramString;
    this.renderParam.id = paramStickerItem.id;
    this.triggerState = paramStickerItem.triggerState;
    this.renderID = paramStickerItem.renderId;
    this.triggerStateRange = paramStickerItem.triggerStateRange;
    this.triggerCtrlItem = new TriggerCtrlItem(paramStickerItem);
    initAudio();
  }
  
  private void avoidBodyPointsShake(PTDetectInfo paramPTDetectInfo)
  {
    if ((paramPTDetectInfo.bodyPoints == null) || (paramPTDetectInfo.bodyPoints.isEmpty()))
    {
      this.mHasBodyDetected = false;
      if (this.mHasSeenValid)
      {
        if (System.currentTimeMillis() - this.mPreviousLostTime < this.mTimesForLostProtect) {
          paramPTDetectInfo.bodyPoints = this.mPreviousBodyPoints;
        }
        return;
      }
      this.mHasSeenValid = false;
      return;
    }
    this.mHasBodyDetected = true;
    this.mHasSeenValid = true;
    this.mPreviousLostTime = System.currentTimeMillis();
    this.mPreviousBodyPoints = paramPTDetectInfo.bodyPoints;
  }
  
  private int getFrameIndex(long paramLong)
  {
    if (!this.triggered) {
      this.frameStartTime = paramLong;
    }
    int i = (int)((paramLong - this.frameStartTime) / Math.max(this.item.frameDuration, 1.0D));
    if (i >= this.item.frames * (this.playCount + 1)) {
      this.playCount += 1;
    }
    return i % Math.max(this.item.frames, 1);
  }
  
  private int getNextFrame(int paramInt)
  {
    if ((this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE) && (this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.PAG) && (this.mVideoDecoder != null))
    {
      this.mVideoDecoder.decodeFrame(paramInt);
      this.mVideoDecoder.updateFrame();
      this.isImageReady = true;
      this.lastImageIndex = paramInt;
    }
    label321:
    for (;;)
    {
      return this.tex[0];
      if (this.tex[0] != 0) {
        if ((this.item.sourceType == VideoMaterialUtil.ITEM_SOURCE_TYPE.PAG) && (!VideoMemoryManager.getInstance().isExtraStickerBitmap(this.item.id)))
        {
          if (VideoMemoryManager.getInstance().loadExtraStickerTxt(this.item.id, paramInt, this.tex[0]) >= 0) {
            this.isImageReady = true;
          }
          this.lastImageIndex = paramInt;
        }
        else
        {
          Object localObject = VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
          if ((localObject == null) && ((VideoMemoryManager.getInstance().isForceLoadFromSdCard()) || (!this.isImageReady) || (this.mIsRenderForBitmap)))
          {
            localObject = this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + "_" + paramInt + ".png";
            localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
          }
          for (int i = 1;; i = 0)
          {
            if (!BitmapUtils.isLegal((Bitmap)localObject)) {
              break label321;
            }
            GlUtil.loadTexture(this.tex[0], (Bitmap)localObject);
            if (i != 0) {
              ((Bitmap)localObject).recycle();
            }
            for (;;)
            {
              this.isImageReady = true;
              this.lastImageIndex = paramInt;
              break;
              VideoMemoryManager.getInstance().recycleBitmap(this.item.id, (Bitmap)localObject);
            }
          }
        }
      }
    }
  }
  
  private void initAudio()
  {
    if (this.mPlayer != null) {}
    while ((this.item == null) || (TextUtils.isEmpty(this.dataPath)) || (TextUtils.isEmpty(this.item.id)) || (TextUtils.isEmpty(this.item.audio))) {
      return;
    }
    String str = this.dataPath + File.separator + this.item.id + File.separator + this.item.audio;
    if (str.startsWith("assets://"))
    {
      this.mPlayer = PlayerUtil.createPlayerFromAssets(AEModule.getContext(), str.replace("assets://", ""), false);
      return;
    }
    this.mPlayer = PlayerUtil.createPlayerFromUri(AEModule.getContext(), str, false);
  }
  
  private boolean isFullScreenRender(AttributeParam paramAttributeParam)
  {
    if (paramAttributeParam == null) {
      return false;
    }
    paramAttributeParam = paramAttributeParam.vertices;
    int j = paramAttributeParam.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label52;
      }
      float f = paramAttributeParam[i];
      if ((Float.compare(-1.0F, f) != 0) && (Float.compare(1.0F, f) != 0)) {
        break;
      }
      i += 1;
    }
    label52:
    return true;
  }
  
  private boolean isRangeValueHit()
  {
    return ((this.item.charmRange == null) || (this.item.charmRange.isHit())) && ((this.item.ageRange == null) || (this.item.ageRange.isHit())) && ((this.item.genderRange == null) || (this.item.genderRange.isHit())) && ((this.item.popularRange == null) || (this.item.popularRange.isHit())) && ((this.item.cpRange == null) || (this.item.cpRange.isHit()));
  }
  
  private boolean isStateTriggered()
  {
    boolean bool2 = false;
    TriggerStateItem localTriggerStateItem = TriggerStateManager.getInstance().getTriggerStateItem(this.renderID);
    boolean bool1 = bool2;
    if (localTriggerStateItem != null)
    {
      bool1 = localTriggerStateItem.isTriggerState(this.triggerState);
      if ((!bool1) || (this.triggerStateRange == null) || (this.triggerStateRange.min >= this.triggerStateRange.max)) {
        return bool1;
      }
      double d = localTriggerStateItem.getRandomValue();
      bool1 = bool2;
      if (d >= this.triggerStateRange.min)
      {
        bool1 = bool2;
        if (d < this.triggerStateRange.max) {
          bool1 = true;
        }
      }
    }
    return bool1;
    return bool1;
  }
  
  private void updateHotArea(int paramInt)
  {
    if ((this.triggered) && (this.item != null) && (this.item.hotArea != null) && (this.item.hotArea.length > 0) && (paramInt >= this.item.redPacketStartFrame) && (paramInt <= this.item.redPacketEndFrame))
    {
      int i = this.item.hotArea.length / 4;
      ArrayList localArrayList = new ArrayList();
      paramInt = 0;
      while (paramInt < i)
      {
        RedPacketPosition localRedPacketPosition = new RedPacketPosition();
        localRedPacketPosition.x = this.item.hotArea[(paramInt * 4)];
        localRedPacketPosition.y = this.item.hotArea[(paramInt * 4 + 1)];
        localRedPacketPosition.width = this.item.hotArea[(paramInt * 4 + 2)];
        localRedPacketPosition.height = this.item.hotArea[(paramInt * 4 + 3)];
        localArrayList.add(localRedPacketPosition);
        paramInt += 1;
      }
      if (this.hotAreaPositions != null) {
        this.hotAreaPositions.addAll(localArrayList);
      }
    }
  }
  
  public void ApplyGLSLFilter()
  {
    GLES20.glGenTextures(this.tex.length, this.tex, 0);
    if ((this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE) && (this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.PAG)) {
      this.mVideoDecoder = new ActVideoDecoder(this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + ".mp4", this.tex[0]);
    }
  }
  
  public boolean canUseBlendMode()
  {
    return (this.item.blendMode < 2) || (this.item.blendMode > 12);
  }
  
  public void clearGLSLSelf()
  {
    int i = 0;
    GLES20.glDeleteTextures(this.tex.length, this.tex, 0);
    try
    {
      while (i < this.tex.length)
      {
        this.tex[i] = 0;
        i += 1;
      }
      if (this.mVideoDecoder != null)
      {
        this.mVideoDecoder.release();
        this.mVideoDecoder = null;
      }
      return;
    }
    finally {}
  }
  
  protected void clearTextureParam()
  {
    this.renderParam.position = GlUtil.EMPTY_POSITIONS_TRIANGLES;
  }
  
  public void destroy()
  {
    clearGLSLSelf();
    PlayerUtil.destroyPlayer(this.mPlayer);
  }
  
  public void destroyAudio()
  {
    PlayerUtil.destroyPlayer(this.mPlayer);
    this.mPlayer = null;
  }
  
  public float getFrameDuration(long paramLong)
  {
    if (!this.triggered) {
      return 0.0F;
    }
    return (float)((paramLong - this.frameStartTime) / 1000.0D);
  }
  
  public int getLastFrameIndex()
  {
    return this.lastImageIndex;
  }
  
  public RenderParam getRenderParam()
  {
    return this.renderParam;
  }
  
  public int getTexture()
  {
    return this.tex[0];
  }
  
  public boolean isMatchGender(PersonParam paramPersonParam)
  {
    if (this.item.genderType == 0) {
      return true;
    }
    if (paramPersonParam == null) {
      return false;
    }
    return paramPersonParam.isGenderMatch(this.item.genderType);
  }
  
  public boolean isRenderReady()
  {
    return (this.triggered) && (this.isImageReady);
  }
  
  public boolean needCopyTex()
  {
    if (this.item == null) {}
    while ((this.item.blendMode < 2) || (this.item.blendMode > 12)) {
      return false;
    }
    return true;
  }
  
  public boolean needRender(int paramInt)
  {
    if ((this.item.personID != -1) && (this.item.personID != paramInt)) {}
    while ((!this.triggered) || (!this.isImageReady)) {
      return false;
    }
    return true;
  }
  
  public boolean needRenderTexture()
  {
    return this.triggered;
  }
  
  public void reset()
  {
    this.triggered = false;
    this.playCount = 0;
    this.mHasBodyDetected = false;
    this.mHasSeenValid = false;
    this.mPreviousBodyPoints = null;
    if (this.triggerCtrlItem != null) {
      this.triggerCtrlItem.reset();
    }
  }
  
  public void setAudioPause(boolean paramBoolean)
  {
    this.mAudioPause = paramBoolean;
  }
  
  public void setBitmapDrawable(BitmapDrawable paramBitmapDrawable) {}
  
  public void setHotAreaPosition(ArrayList<RedPacketPosition> paramArrayList)
  {
    this.hotAreaPositions = paramArrayList;
  }
  
  public void setStickerItem(StickerItem paramStickerItem)
  {
    this.item = paramStickerItem;
  }
  
  protected void updateActionTriggered(PTDetectInfo paramPTDetectInfo)
  {
    boolean bool3 = false;
    boolean bool4 = false;
    if (this.item == null) {
      return;
    }
    Object localObject1 = paramPTDetectInfo.faceActionCounter;
    Map localMap = paramPTDetectInfo.handActionCounter;
    Object localObject2 = paramPTDetectInfo.triggeredExpression;
    List localList = paramPTDetectInfo.bodyPoints;
    PTHandAttr localPTHandAttr = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
    this.triggerCtrlItem.getTriggeredStatus(paramPTDetectInfo);
    label124:
    int i;
    label154:
    label168:
    label217:
    boolean bool2;
    boolean bool1;
    if (this.item.activateTriggerTotalCount != 0)
    {
      boolean bool5;
      boolean bool6;
      if (this.item.preTriggerType != PTFaceAttr.PTExpression.ALWAYS.value)
      {
        if (VideoMaterialUtil.isFaceTriggerType(this.item.preTriggerType)) {
          if (!((Set)localObject2).contains(Integer.valueOf(this.item.preTriggerType))) {
            break label605;
          }
        }
      }
      else
      {
        bool5 = VideoMaterialUtil.isFaceTriggerType(this.item.countTriggerType);
        bool6 = VideoMaterialUtil.isHotAreaTriggerItem(this.item);
        if (!bool5) {
          break label611;
        }
        localObject2 = localObject1;
        if (localObject2 == null) {
          break label605;
        }
        if (!bool5) {
          break label618;
        }
        localObject2 = localObject1;
        if (!((Map)localObject2).containsKey(Integer.valueOf(this.item.countTriggerType))) {
          break label623;
        }
        if (!bool5) {
          break label625;
        }
        i = ((FaceActionCounter)((Map)localObject1).get(Integer.valueOf(this.item.countTriggerType))).count;
        if (i % this.item.activateTriggerTotalCount != this.item.activateTriggerCount) {
          break label605;
        }
        if (!bool6) {
          break label664;
        }
        bool2 = TriggerUtil.isGestureTriggered(localPTHandAttr, this.item.preTriggerType, this.item.triggerHandPoint, this.item.triggerArea, paramPTDetectInfo.aiAttr);
        bool1 = bool2;
        if (this.item.activateTriggerCountOnce == 1)
        {
          bool1 = bool2;
          if (!this.isItemTriggerCountOnce)
          {
            HotAreaActionCounter.updateCount();
            this.isItemTriggerCountOnce = true;
            bool1 = bool2;
          }
        }
        label311:
        bool2 = bool1;
        if (!VideoFilterList.sIsUseFreezeFrame)
        {
          if (this.playCount >= this.item.playCount) {
            break label728;
          }
          if (!bool5) {
            break label700;
          }
          bool2 = bool1;
          if (paramPTDetectInfo.faceDetector != null)
          {
            paramPTDetectInfo.faceDetector.lockActionCounter();
            bool2 = bool1;
          }
        }
      }
      for (;;)
      {
        label364:
        if ((!bool2) || (!isRangeValueHit())) {
          break label1161;
        }
        bool1 = true;
        label379:
        if (this.triggerCtrlItem.isTimeTriggered(paramPTDetectInfo)) {
          bool1 = true;
        }
        bool2 = bool1;
        if (this.triggerState != null)
        {
          bool2 = bool1;
          if (this.triggerState.size() > 0) {
            bool2 = isStateTriggered();
          }
        }
        if (!bool2) {
          break label1167;
        }
        bool1 = bool4;
        if (!this.triggered)
        {
          this.frameStartTime = paramPTDetectInfo.timestamp;
          Log.i("fastfilter", " updateActionTriggered item.id = " + this.item.id);
          Log.i("fastfilter", " updateActionTriggered triggered = " + this.triggered + "frameStartTime = " + this.frameStartTime + ", curPlayCount = " + this.playCount);
          bool1 = true;
        }
        this.triggered = true;
        label545:
        this.triggerCtrlItem.updateTriggerTime(paramPTDetectInfo.timestamp, this.triggered);
        if (this.triggered) {
          break label1207;
        }
        destroyAudio();
        return;
        if (TriggerUtil.isGestureTriggered(localPTHandAttr, this.item.preTriggerType, this.item.triggerHandPoint, this.item.triggerArea, paramPTDetectInfo.aiAttr)) {
          break label124;
        }
        label605:
        bool2 = false;
        continue;
        label611:
        localObject2 = localMap;
        break label154;
        label618:
        localObject2 = localMap;
        break label168;
        label623:
        break;
        label625:
        if (bool6)
        {
          i = HotAreaActionCounter.getCount();
          break label217;
        }
        i = ((Integer)localMap.get(Integer.valueOf(this.item.countTriggerType))).intValue();
        break label217;
        label664:
        if ((this.item.playCount == 0) || (this.playCount < this.item.playCount))
        {
          bool1 = true;
          break label311;
        }
        bool1 = false;
        break label311;
        label700:
        if (bool6)
        {
          HotAreaActionCounter.lockUpdate();
          bool2 = bool1;
        }
        else
        {
          AIActionCounter.lockAction(AIActionCounter.AI_TYPE.HAND);
          bool2 = bool1;
          continue;
          label728:
          bool2 = bool1;
          if (this.item.playCount > 0) {
            if (bool5)
            {
              bool2 = bool1;
              if (paramPTDetectInfo.faceDetector != null)
              {
                paramPTDetectInfo.faceDetector.clearActionCounter();
                bool2 = bool1;
              }
            }
            else if (bool6)
            {
              HotAreaActionCounter.lockUpdate();
              bool2 = bool1;
            }
            else
            {
              AIActionCounter.clearAction(AIActionCounter.AI_TYPE.HAND);
              bool2 = bool1;
            }
          }
        }
      }
    }
    if (AETriggerAnalyzer.getInstance().isInteger(this.item.getTriggerTypeString())) {
      if (VideoMaterialUtil.isFaceTriggerType(this.item.getTriggerTypeInt())) {
        bool1 = ((Set)localObject2).contains(Integer.valueOf(this.item.getTriggerTypeInt()));
      }
    }
    for (;;)
    {
      if ((bool1) || (this.mIsRenderForBitmap))
      {
        bool2 = true;
        break label364;
        if (VideoMaterialUtil.isTouchTriggerType(this.item.getTriggerTypeInt()))
        {
          bool1 = ((Set)localObject2).contains(Integer.valueOf(this.item.getTriggerTypeInt()));
          continue;
        }
        if (VideoMaterialUtil.isBodyDetectType(this.item.getTriggerTypeInt()))
        {
          if (localList == null)
          {
            bool1 = true;
            continue;
          }
          if (localList.isEmpty()) {
            break label1266;
          }
          bool1 = true;
          continue;
        }
        if (VideoMaterialUtil.isAllFreezeFrameTriggerType(this.item.getTriggerTypeInt()))
        {
          bool1 = ((Set)localObject2).contains(Integer.valueOf(this.item.getTriggerTypeInt()));
          continue;
        }
        if (paramPTDetectInfo.isFreezeInfo)
        {
          if (this.item.getTriggerTypeInt() == paramPTDetectInfo.gestureTrigger)
          {
            bool1 = true;
            continue;
          }
          bool1 = false;
          continue;
        }
        bool1 = TriggerUtil.isGestureTriggered(localPTHandAttr, this.item.getTriggerTypeInt(), this.item.triggerHandPoint, this.item.triggerArea, paramPTDetectInfo.aiAttr);
        continue;
        localObject1 = this.item.getTriggerTypeString().split("-");
        if (localObject1.length != 2) {
          break label1266;
        }
        localMap = localObject1[0];
        try
        {
          i = Integer.parseInt(localObject1[1]);
          localObject1 = AETriggerAnalyzer.getInstance().getClassifier(localMap);
          if (localObject1 == null) {
            break label1266;
          }
          int j = ((IAIDataClassifier)localObject1).classifyData2Type(paramPTDetectInfo.aiAttr);
          bool1 = ((IAIDataClassifier)localObject1).getClassifierTypeMap().containsValue(Integer.valueOf(j));
          if ((bool1) && (i == j))
          {
            bool1 = true;
            continue;
          }
          bool1 = false;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          bool1 = false;
        }
        continue;
      }
      bool2 = false;
      break label364;
      label1161:
      bool1 = false;
      break label379;
      label1167:
      if (!this.item.alwaysTriggered)
      {
        bool1 = bool3;
        if (this.playCount < this.item.playCount) {
          break label545;
        }
      }
      this.triggered = false;
      bool1 = bool3;
      break label545;
      label1207:
      if ((!VideoPrefsUtil.getMaterialMute()) && (!this.mAudioPause))
      {
        initAudio();
        if (this.item.audioLoopCount > 0)
        {
          if (!bool1) {
            break;
          }
          PlayerUtil.startPlayer(this.mPlayer, true);
          return;
        }
        PlayerUtil.startPlayer(this.mPlayer, bool1);
        return;
      }
      PlayerUtil.stopPlayer(this.mPlayer);
      return;
      label1266:
      bool1 = false;
    }
  }
  
  protected abstract void updatePositions(List<PointF> paramList);
  
  protected abstract void updatePositions(List<PointF> paramList, int paramInt);
  
  protected abstract void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat);
  
  protected abstract void updatePositionsForMultiAnchor(List<PointF> paramList, int paramInt);
  
  public void updatePreview(Object paramObject)
  {
    int i;
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      if (VideoMaterialUtil.isBodyDetectItem(this.item)) {
        avoidBodyPointsShake(paramObject);
      }
      this.aiAttr = paramObject.aiAttr;
      i = getFrameIndex(paramObject.timestamp);
      updateActionTriggered(paramObject);
      updateHotArea(i);
      if (!needRenderTexture())
      {
        clearTextureParam();
        this.playCount = 0;
        VideoMemoryManager.getInstance().reset(this.item.id);
        updateTextureParam(0);
      }
    }
    else
    {
      return;
    }
    if (VideoMaterialUtil.isFaceItem(this.item)) {
      updatePositions(paramObject.facePoints, paramObject.faceAngles);
    }
    for (;;)
    {
      updateTextureParam(i);
      return;
      if (VideoMaterialUtil.isBodyDetectItem(this.item))
      {
        if (VideoMaterialUtil.isBody4AnchorItem(this.item)) {
          updatePositionsForMultiAnchor(paramObject.bodyPoints, 4);
        }
        for (;;)
        {
          if (this.mHasBodyDetected) {
            break label192;
          }
          paramObject.bodyPoints = null;
          break;
          if (VideoMaterialUtil.isBody2AnchorItem(this.item)) {
            updatePositionsForMultiAnchor(paramObject.bodyPoints, 2);
          } else {
            updatePositions(paramObject.bodyPoints);
          }
        }
      }
      else
      {
        label192:
        if (VideoMaterialUtil.isGestureItem(this.item)) {
          updatePositions(paramObject.handPoints, 0);
        }
      }
    }
  }
  
  protected void updateTextureParam(int paramInt)
  {
    if (paramInt == this.lastImageIndex) {
      return;
    }
    if ((this.lastImageIndex > paramInt) && (this.mVideoDecoder != null)) {
      this.mVideoDecoder.reset();
    }
    this.renderParam.texture = getNextFrame(paramInt);
  }
  
  public void updateTextureParam(long paramLong)
  {
    int i = getFrameIndex(paramLong);
    try
    {
      updateTextureParam(i);
      return;
    }
    finally {}
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.mScreenScale = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.model.FastSticker
 * JD-Core Version:    0.7.0.1
 */