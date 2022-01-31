package com.tencent.ttpic.filter;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.AIActionCounter.AI_TYPE;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.facedetect.FaceActionCounterListener;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.gameplaysdk.GamePlaySDK;
import com.tencent.ttpic.gameplaysdk.model.GameParams;
import com.tencent.ttpic.gameplaysdk.model.NodeParameter;
import com.tencent.ttpic.gameplaysdk.model.Range;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTDetectInfo.Builder;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.filter.VideoFilterList;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.openapi.util.TriggerUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameFilter
{
  private static final String TAG = GameFilter.class.getSimpleName();
  private AIAttr aiAttr;
  private String dataPath;
  private String gameName;
  private GameParams gameParams;
  private int height;
  private boolean isAnimoji = false;
  private boolean isFirstFrame = true;
  private List<StickerItem3D> itemList3D;
  private BaseFilter mFlipFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame mFlipFrame = new Frame();
  private int maxFaceCount;
  private int orderMode;
  private int width;
  
  public GameFilter(List<StickerItem3D> paramList, int paramInt1, int paramInt2)
  {
    this.itemList3D = paramList;
    this.orderMode = paramInt1;
    this.maxFaceCount = paramInt2;
  }
  
  private void adjustExpressionWeights(float[] paramArrayOfFloat)
  {
    float f2 = 1.1F;
    float f4;
    float f3;
    if (this.gameParams.expressionAdjustFactorMap != null)
    {
      f4 = paramArrayOfFloat[24];
      f1 = f2;
      if (this.gameParams.expressionAdjustFactorMap.containsKey("disableeyeblinkwhenopenjaw"))
      {
        f3 = ((Range)this.gameParams.expressionAdjustFactorMap.get("disableeyeblinkwhenopenjaw")).min;
        f1 = f2;
        if (f3 > 0.0F) {
          if (f3 <= 1.0F) {
            break label262;
          }
        }
      }
    }
    label262:
    for (float f1 = f2;; f1 = f3)
    {
      int i = 0;
      if (i < paramArrayOfFloat.length)
      {
        if (VideoMaterialUtil.blendshapeIndex2Name.containsKey(Integer.valueOf(i)))
        {
          Object localObject = (String)VideoMaterialUtil.blendshapeIndex2Name.get(Integer.valueOf(i));
          if (this.gameParams.expressionAdjustFactorMap.containsKey(localObject))
          {
            if ((f4 > f1) && ((((String)localObject).equalsIgnoreCase("eyeBlinkLeft")) || (((String)localObject).equalsIgnoreCase("eyeBlinkRight")))) {
              paramArrayOfFloat[i] = 0.0F;
            }
            localObject = (Range)this.gameParams.expressionAdjustFactorMap.get(localObject);
            f2 = ((Range)localObject).min;
            f3 = ((Range)localObject).max;
            if (paramArrayOfFloat[i] >= f2) {
              break label218;
            }
            paramArrayOfFloat[i] = 0.0F;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label218:
          if (paramArrayOfFloat[i] > f3) {
            paramArrayOfFloat[i] = 1.0F;
          } else if (f3 > f2) {
            paramArrayOfFloat[i] = ((paramArrayOfFloat[i] - f2) / (f3 - f2));
          }
        }
      }
      return;
    }
  }
  
  private void updateTrigger3DItem(PTDetectInfo paramPTDetectInfo)
  {
    Map localMap2 = paramPTDetectInfo.faceActionCounter;
    Map localMap3 = paramPTDetectInfo.handActionCounter;
    Set localSet = paramPTDetectInfo.triggeredExpression;
    PTHandAttr localPTHandAttr;
    long l;
    label51:
    StickerItem3D localStickerItem3D;
    label124:
    boolean bool3;
    Map localMap1;
    label143:
    int i;
    label175:
    boolean bool2;
    label214:
    boolean bool1;
    if (this.aiAttr == null)
    {
      localPTHandAttr = null;
      if (this.itemList3D == null) {
        return;
      }
      l = paramPTDetectInfo.timestamp;
      Iterator localIterator = this.itemList3D.iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      localStickerItem3D = (StickerItem3D)localIterator.next();
      if (localStickerItem3D.activateTriggerTotalCount == 0) {
        break label533;
      }
      if (localStickerItem3D.preTriggerType != PTFaceAttr.PTExpression.ALWAYS.value)
      {
        if (!VideoMaterialUtil.isFaceTriggerType(localStickerItem3D.preTriggerType)) {
          break label406;
        }
        if (!localSet.contains(Integer.valueOf(localStickerItem3D.preTriggerType))) {
          break label419;
        }
      }
      bool3 = VideoMaterialUtil.isFaceTriggerType(localStickerItem3D.countTriggerType);
      if (!bool3) {
        break label425;
      }
      localMap1 = localMap2;
      if (localMap1 == null) {
        break label419;
      }
      if (!bool3) {
        break label432;
      }
      i = ((FaceActionCounter)localMap2.get(Integer.valueOf(localStickerItem3D.countTriggerType))).count;
      if (i % localStickerItem3D.activateTriggerTotalCount != localStickerItem3D.activateTriggerCount) {
        break label419;
      }
      if ((localStickerItem3D.playCount != 0) && (localStickerItem3D.curPlayCount >= localStickerItem3D.playCount)) {
        break label457;
      }
      bool2 = true;
      bool1 = bool2;
      if (!VideoFilterList.sIsUseFreezeFrame)
      {
        if (localStickerItem3D.curPlayCount >= localStickerItem3D.playCount) {
          break label476;
        }
        if (!bool3) {
          break label463;
        }
        bool1 = bool2;
        if (paramPTDetectInfo.faceDetector != null)
        {
          paramPTDetectInfo.faceDetector.lockActionCounter();
          bool1 = bool2;
        }
      }
      label266:
      if (!bool1) {
        break label610;
      }
      if (!localStickerItem3D.triggered)
      {
        localStickerItem3D.frameStartTime = l;
        Log.e("gameFilter", " updateTrigger3DItem item.id = " + localStickerItem3D.id);
        Log.e("gameFilter", " updateTrigger3DItem triggered = " + localStickerItem3D.triggered + "frameStartTime = " + localStickerItem3D.frameStartTime + ", curPlayCount = " + localStickerItem3D.curPlayCount);
      }
    }
    label533:
    for (localStickerItem3D.triggered = true;; localStickerItem3D.triggered = false) {
      label406:
      label419:
      label425:
      label432:
      label457:
      label463:
      label476:
      label610:
      do
      {
        localStickerItem3D.calFrameIndex(l);
        break label51;
        localPTHandAttr = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
        break;
        if (TriggerUtil.isGestureTriggered(localPTHandAttr, localStickerItem3D.preTriggerType)) {
          break label124;
        }
        bool1 = false;
        break label266;
        localMap1 = localMap3;
        break label143;
        i = ((Integer)localMap3.get(Integer.valueOf(localStickerItem3D.countTriggerType))).intValue();
        break label175;
        bool2 = false;
        break label214;
        AIActionCounter.lockAction(AIActionCounter.AI_TYPE.HAND);
        bool1 = bool2;
        break label266;
        bool1 = bool2;
        if (localStickerItem3D.playCount <= 0) {
          break label266;
        }
        if (bool3)
        {
          bool1 = bool2;
          if (paramPTDetectInfo.faceDetector == null) {
            break label266;
          }
          paramPTDetectInfo.faceDetector.clearActionCounter();
          bool1 = bool2;
          break label266;
        }
        AIActionCounter.clearAction(AIActionCounter.AI_TYPE.HAND);
        bool1 = bool2;
        break label266;
        if (VideoMaterialUtil.isFaceTriggerType(localStickerItem3D.getTriggerTypeInt()))
        {
          bool1 = localSet.contains(Integer.valueOf(localStickerItem3D.getTriggerTypeInt()));
          break label266;
        }
        if (VideoMaterialUtil.isTouchTriggerType(localStickerItem3D.getTriggerTypeInt()))
        {
          bool1 = localSet.contains(Integer.valueOf(localStickerItem3D.getTriggerTypeInt()));
          break label266;
        }
        bool1 = TriggerUtil.isGestureTriggered(localPTHandAttr, localStickerItem3D.getTriggerTypeInt());
        break label266;
      } while ((!localStickerItem3D.alwaysTriggered) && (localStickerItem3D.curPlayCount < localStickerItem3D.playCount));
    }
  }
  
  public void applyGLSLFilter()
  {
    this.mFlipFilter.apply();
    GamePlaySDK localGamePlaySDK = GamePlaySDK.getInstance();
    AssetManager localAssetManager = AEModule.getContext().getAssets();
    if (this.isAnimoji) {}
    for (int i = 1;; i = 0)
    {
      localGamePlaySDK.init(localAssetManager, i, this.dataPath, this.gameParams, this.width, this.height);
      reset();
      return;
    }
  }
  
  public void clear()
  {
    this.mFlipFilter.ClearGLSL();
    this.mFlipFrame.clear();
    GamePlaySDK.getInstance().clear();
  }
  
  public int getGameRefTextureHeight()
  {
    return GamePlaySDK.getInstance().getGameRefTextureHeight();
  }
  
  public int getGameRefTextureID()
  {
    return GamePlaySDK.getInstance().getGameRefTextureID();
  }
  
  public int getGameRefTextureWidth()
  {
    return GamePlaySDK.getInstance().getGameRefTextureWidth();
  }
  
  public NodeParameter[] getNodeParameters()
  {
    if (this.itemList3D != null)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = this.itemList3D.iterator();
      while (((Iterator)localObject).hasNext())
      {
        StickerItem3D localStickerItem3D = (StickerItem3D)((Iterator)localObject).next();
        if (localStickerItem3D.nodeParameter != null) {
          localArrayList.add(localStickerItem3D.nodeParameter);
        }
      }
      if (localArrayList.isEmpty()) {
        return null;
      }
      localObject = new NodeParameter[localArrayList.size()];
      int i = 0;
      while (i < localArrayList.size())
      {
        localObject[i] = ((NodeParameter)localArrayList.get(i));
        i += 1;
      }
      return localObject;
    }
    return null;
  }
  
  public int getOrderMode()
  {
    return this.orderMode;
  }
  
  public void init() {}
  
  public boolean isAnimoji()
  {
    return this.isAnimoji;
  }
  
  public void reset()
  {
    if (this.itemList3D != null)
    {
      Iterator localIterator = this.itemList3D.iterator();
      while (localIterator.hasNext()) {
        ((StickerItem3D)localIterator.next()).reset();
      }
    }
  }
  
  public void setGameParams(GameParams paramGameParams, String paramString)
  {
    this.gameParams = paramGameParams;
    this.dataPath = (paramString + File.separator);
    if (!TextUtils.isEmpty(paramGameParams.animojiBaseNodeId)) {}
    for (boolean bool = true;; bool = false)
    {
      this.isAnimoji = bool;
      return;
    }
  }
  
  protected void updateActionTriggered(PTDetectInfo paramPTDetectInfo)
  {
    Object localObject1 = paramPTDetectInfo.faceActionCounter;
    localObject1 = paramPTDetectInfo.handActionCounter;
    paramPTDetectInfo = paramPTDetectInfo.triggeredExpression;
    if (this.aiAttr == null) {}
    while (this.itemList3D != null)
    {
      localObject1 = new ArrayList();
      paramPTDetectInfo = this.itemList3D.iterator();
      for (;;)
      {
        if (paramPTDetectInfo.hasNext())
        {
          localObject2 = (StickerItem3D)paramPTDetectInfo.next();
          if (((StickerItem3D)localObject2).triggered)
          {
            ((List)localObject1).add(localObject2);
            continue;
            paramPTDetectInfo = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
            break;
          }
        }
      }
      Object localObject2 = new StickerItem3D[((List)localObject1).size()];
      int i = 0;
      if (i < ((List)localObject1).size())
      {
        localObject2[i] = new StickerItem3D();
        localObject2[i].id = ((StickerItem3D)localObject1.get(i)).id.split(":")[0];
        Object localObject3 = localObject2[i];
        if (((StickerItem3D)((List)localObject1).get(i)).curFrameImagePath == null) {}
        for (paramPTDetectInfo = "";; paramPTDetectInfo = ((StickerItem3D)((List)localObject1).get(i)).curFrameImagePath)
        {
          localObject3.curFrameImagePath = paramPTDetectInfo;
          i += 1;
          break;
        }
      }
      GamePlaySDK.getInstance().updateTriggerInfo((StickerItem3D[])localObject2);
    }
  }
  
  public Frame updateAndRender(Frame paramFrame, AIAttr paramAIAttr, PTFaceAttr paramPTFaceAttr)
  {
    this.aiAttr = paramAIAttr;
    List localList = paramPTFaceAttr.getFaceStatusList();
    Map localMap1 = paramPTFaceAttr.getFaceActionCounter();
    Map localMap2 = AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND);
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    PTHandAttr localPTHandAttr = (PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value);
    if (localPTHandAttr != null) {
      localSet.add(Integer.valueOf(localPTHandAttr.getHandType()));
    }
    paramAIAttr = new PTDetectInfo.Builder().faceActionCounter(localMap1).timestamp(paramPTFaceAttr.getTimeStamp()).handActionCounter(localMap2).triggeredExpression(localSet).aiAttr(paramAIAttr).faceDetector(paramPTFaceAttr.getFaceDetector()).faceDetector(paramPTFaceAttr.getFaceDetector()).build();
    updateTrigger3DItem(paramAIAttr);
    if (paramPTFaceAttr.isPhoneFlatHorizontal()) {}
    for (int i = paramPTFaceAttr.getLastFaceDetectedPhoneRotation(); (localList == null) || (localList.size() <= 0) || (((FaceStatus)localList.get(0)).denseFaceModel == null) || (((FaceStatus)localList.get(0)).denseFaceModel[0] == 0.0F) || (((FaceStatus)localList.get(0)).transform[15] < 1.0F); i = paramPTFaceAttr.getRotation()) {
      return paramFrame;
    }
    if (GamePlaySDK.getInstance().isInited())
    {
      updateActionTriggered(paramAIAttr);
      if (this.itemList3D != null)
      {
        paramAIAttr = this.itemList3D.iterator();
        while (paramAIAttr.hasNext())
        {
          paramPTFaceAttr = (StickerItem3D)paramAIAttr.next();
          if ((paramPTFaceAttr.alignFacePoints != null) && (paramPTFaceAttr.alignFacePoints.length >= 1)) {
            GamePlaySDK.getInstance().setNodeAlignedHeadPointIndex(paramPTFaceAttr.id, paramPTFaceAttr.alignFacePoints[0]);
          }
        }
      }
      this.mFlipFilter.setRotationAndFlip(i, 0, 1);
      int m = Math.min(this.maxFaceCount, localList.size());
      int j = 0;
      if (j < m)
      {
        paramAIAttr = (FaceStatus)localList.get(j);
        if (paramAIAttr.denseFaceModel != null)
        {
          if ((!this.isAnimoji) || (paramAIAttr.expressionWeights == null) || (j != 0)) {
            break label531;
          }
          adjustExpressionWeights(paramAIAttr.expressionWeights);
          BenchUtil.benchStart("updateExpressionWeights");
          GamePlaySDK.getInstance().updateExpressionWeights(paramAIAttr.expressionWeights);
          BenchUtil.benchEnd("updateExpressionWeights");
          GamePlaySDK.getInstance().updateEyeRollWeights(paramAIAttr.eyeRollWeights);
        }
        for (;;)
        {
          GamePlaySDK.getInstance().updateEyeEulerAngle(paramAIAttr.eyeEulerAngle);
          GamePlaySDK.getInstance().updateHeadData(paramAIAttr.denseFaceModel, paramAIAttr.transform);
          GamePlaySDK.getInstance().onDrawFrame();
          this.mFlipFilter.setRotationAndFlip(-i, 0, 1);
          if (!this.isFirstFrame)
          {
            GlUtil.setBlendMode(true);
            if (paramAIAttr.transform[11] > 2.5D) {
              this.mFlipFilter.RenderProcess(GamePlaySDK.getInstance().getGameTexture(), this.width, this.height, -1, 0.0D, paramFrame);
            }
            GlUtil.setBlendMode(false);
          }
          j += 1;
          break;
          label531:
          if (paramAIAttr.expressionWeights == null)
          {
            paramAIAttr.expressionWeights = new float[52];
            int k = 0;
            while (k < 52)
            {
              paramAIAttr.expressionWeights[k] = 0.0F;
              k += 1;
            }
            GamePlaySDK.getInstance().updateExpressionWeights(paramAIAttr.expressionWeights);
          }
        }
      }
    }
    this.isFirstFrame = false;
    return paramFrame;
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    int j;
    int i;
    if (paramInt3 != 90)
    {
      j = paramInt1;
      i = paramInt2;
      if (paramInt3 != 270) {}
    }
    else
    {
      i = paramInt1;
      j = paramInt2;
    }
    GamePlaySDK.getInstance().onSurfaceChanged(j, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.GameFilter
 * JD-Core Version:    0.7.0.1
 */