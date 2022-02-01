package com.tencent.ttpic.filter.juyoujinggame;

import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.baseutils.audio.PlayerUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil.Player;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.filter.RenderItem;
import com.tencent.ttpic.openapi.manager.TouchTriggerManager;
import com.tencent.ttpic.openapi.manager.TriggerStateManager;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.TriggerStateItem;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import com.tencent.ttpic.util.AlgoUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class UKYOApple
  extends RenderItem
{
  private ArrayList<IHittingStatus> mAppleList = new ArrayList();
  private int mComboCount = 0;
  private long mCurrentTime = 0L;
  private int mDisapearCount = 0;
  private int mDisapearLine = 800;
  private HashMap<Integer, UKYOApple.FlashStatus> mFlashStatus;
  private int mHittingScore = 0;
  private Object mInfoObjext;
  private long mInitedTime = -1L;
  private boolean mIsAllDisappear = false;
  private AppleItemSetting mOriginAppleSetting = null;
  private FlashItemSetting mOriginFlashSeting = null;
  private PlayerUtil.Player mPlayerAudioattack;
  private int mRenderID = 0;
  private UKYOGame.RenderListener mRenderListener = null;
  
  public UKYOApple(AEFilterI paramAEFilterI, TriggerCtrlItem paramTriggerCtrlItem)
  {
    super(paramAEFilterI, paramTriggerCtrlItem);
  }
  
  private void allDisappear()
  {
    this.mIsAllDisappear = true;
    float f = this.mHittingScore * 1.0F / this.mAppleList.size();
    String str;
    if (f >= 0.83F) {
      str = "state001";
    } else if (f >= 0.56F) {
      str = "state002";
    } else if (f >= 0.25F) {
      str = "state003";
    } else {
      str = "state004";
    }
    TriggerStateManager.getInstance().getTriggerStateItem(this.mRenderID).forceUpdateState(str);
  }
  
  private double getLeft(double paramDouble)
  {
    if (paramDouble < 0.3D) {
      d = 0.667D;
    }
    for (;;)
    {
      return paramDouble * d;
      if (paramDouble <= 0.7D) {
        break;
      }
      paramDouble = (paramDouble - 0.7D) * 0.66D + 0.65D;
      AppleItemSetting localAppleItemSetting = this.mOriginAppleSetting;
      d = paramDouble;
      if (localAppleItemSetting == null) {
        return d;
      }
      d = localAppleItemSetting.maxWidth;
      Double.isNaN(d);
    }
    double d = (paramDouble - 0.3D) * 1.5D + 0.2D;
    return d;
  }
  
  private void initAudioAttack()
  {
    if (this.mPlayerAudioattack != null) {
      return;
    }
    Object localObject = this.mOriginAppleSetting.audioattack;
    String str = this.mOriginAppleSetting.dataPath;
    if ((localObject != null) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(((StickerItem)localObject).id)) && (!TextUtils.isEmpty(((StickerItem)localObject).audio)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(((StickerItem)localObject).id);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(((StickerItem)localObject).audio);
      localObject = localStringBuilder.toString();
      if (((String)localObject).startsWith("assets://")) {
        this.mPlayerAudioattack = PlayerUtil.createPlayerFromAssets(AEModule.getContext(), ((String)localObject).replace("assets://", ""), false);
      } else {
        this.mPlayerAudioattack = PlayerUtil.createPlayerFromUri(AEModule.getContext(), (String)localObject, false);
      }
      if (this.mPlayerAudioattack != null) {
        TouchTriggerManager.getInstance().setMusicDuration(this.mPlayerAudioattack.getDuration());
      }
    }
  }
  
  private Frame rendApples(Frame paramFrame)
  {
    UKYOFilter localUKYOFilter = (UKYOFilter)this.filter;
    Iterator localIterator = this.mAppleList.iterator();
    while (localIterator.hasNext())
    {
      UKYOApple.AppleStatus localAppleStatus = (UKYOApple.AppleStatus)localIterator.next();
      if (localAppleStatus.isAppear())
      {
        localUKYOFilter.setImageID(UKYOApple.AppleStatus.access$200(localAppleStatus));
        int i;
        if (localAppleStatus.frameIndex >= 0) {
          i = localAppleStatus.frameIndex;
        } else {
          i = 0;
        }
        localUKYOFilter.setFrameIndex(i);
        localUKYOFilter.setPositions(localAppleStatus.mAdjustPoints);
        localUKYOFilter.updatePreview(this.mInfoObjext);
        paramFrame = this.mRenderListener.RenderProcessForFilter(paramFrame, null, localUKYOFilter);
      }
    }
    return paramFrame;
  }
  
  private Frame rendFlash(Frame paramFrame)
  {
    Object localObject1 = this.mFlashStatus;
    if (localObject1 != null)
    {
      if (((HashMap)localObject1).size() == 0) {
        return paramFrame;
      }
      UKYOFilter localUKYOFilter = (UKYOFilter)this.filter;
      Iterator localIterator = this.mFlashStatus.keySet().iterator();
      localObject1 = paramFrame;
      paramFrame = null;
      int i;
      while (localIterator.hasNext())
      {
        i = ((Integer)localIterator.next()).intValue();
        Object localObject2 = (UKYOApple.FlashStatus)this.mFlashStatus.get(Integer.valueOf(i));
        if (localObject2 == null)
        {
          localObject2 = paramFrame;
          if (paramFrame == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add(Integer.valueOf(i));
          paramFrame = (Frame)localObject2;
        }
        else
        {
          localUKYOFilter.setImageID(UKYOApple.FlashStatus.access$000((UKYOApple.FlashStatus)localObject2).mImageID);
          localUKYOFilter.setFrameIndex(((UKYOApple.FlashStatus)localObject2).frameIndex);
          localUKYOFilter.setPositions(((UKYOApple.FlashStatus)localObject2).mAdjustPoints);
          localUKYOFilter.updatePreview(this.mInfoObjext);
          Frame localFrame = this.mRenderListener.RenderProcessForFilter((Frame)localObject1, null, localUKYOFilter);
          localObject1 = localFrame;
          if (UKYOApple.FlashStatus.access$100((UKYOApple.FlashStatus)localObject2))
          {
            localObject2 = paramFrame;
            if (paramFrame == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(Integer.valueOf(i));
            localObject1 = localFrame;
            paramFrame = (Frame)localObject2;
          }
        }
      }
      if ((paramFrame != null) && (paramFrame.size() > 0))
      {
        paramFrame = paramFrame.iterator();
        while (paramFrame.hasNext())
        {
          i = ((Integer)paramFrame.next()).intValue();
          this.mFlashStatus.remove(Integer.valueOf(i));
        }
      }
      return localObject1;
    }
    return paramFrame;
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    if (this.filter == null) {
      return paramFrame;
    }
    if ((this.triggerCtrlItem != null) && (!this.triggerCtrlItem.isTriggered())) {
      return paramFrame;
    }
    Frame localFrame = rendApples(paramFrame);
    if (localFrame != paramFrame) {
      paramFrame.unlock();
    }
    return rendFlash(localFrame);
  }
  
  public void apply()
  {
    ((UKYOFilter)this.filter).applyChain();
  }
  
  public void clear()
  {
    reset();
    ArrayList localArrayList = this.mAppleList;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    ((UKYOFilter)this.filter).clear();
    destroyAudio();
  }
  
  public void destroyAudio()
  {
    PlayerUtil.Player localPlayer = this.mPlayerAudioattack;
    if (localPlayer != null)
    {
      PlayerUtil.destroyPlayer(localPlayer);
      this.mPlayerAudioattack = null;
    }
  }
  
  public ArrayList<IHittingStatus> getAppleStauts()
  {
    return this.mAppleList;
  }
  
  public int getComboScore()
  {
    int i = this.mComboCount - this.mOriginFlashSeting.COMBO_FLASH_COUNT;
    if (i > 0) {
      return i;
    }
    return 0;
  }
  
  public int getHittingScore()
  {
    return this.mHittingScore;
  }
  
  public void initAppStatus(AppleItemSetting paramAppleItemSetting)
  {
    this.mOriginAppleSetting = paramAppleItemSetting;
    paramAppleItemSetting = this.mOriginAppleSetting;
    if ((paramAppleItemSetting != null) && (paramAppleItemSetting.mAppleAppearTime != null))
    {
      if (this.mOriginAppleSetting.mAppleAppearTime.size() == 0) {
        return;
      }
      if (this.mAppleList == null) {
        this.mAppleList = new ArrayList();
      }
      paramAppleItemSetting = this.mOriginAppleSetting.mAppleAppearTime.iterator();
      while (paramAppleItemSetting.hasNext())
      {
        float f = ((Float)paramAppleItemSetting.next()).floatValue();
        UKYOApple.AppleStatus localAppleStatus = new UKYOApple.AppleStatus(this, this.mOriginAppleSetting, (int)(f * 1000.0F));
        this.mAppleList.add(localAppleStatus);
      }
      initAudioAttack();
    }
  }
  
  public void initFlashSetting(FlashItemSetting paramFlashItemSetting)
  {
    this.mOriginFlashSeting = paramFlashItemSetting;
  }
  
  public boolean isPlaying()
  {
    return this.mIsAllDisappear ^ true;
  }
  
  public void reset()
  {
    Object localObject = this.mAppleList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((UKYOApple.AppleStatus)((Iterator)localObject).next()).reset();
      }
    }
    localObject = this.mFlashStatus;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    this.mInitedTime = -1L;
    this.mDisapearCount = 0;
    this.mIsAllDisappear = false;
    this.mHittingScore = 0;
    this.mComboCount = 0;
  }
  
  public void setListener(UKYOGame.RenderListener paramRenderListener)
  {
    this.mRenderListener = paramRenderListener;
  }
  
  public void setRenderID(int paramInt)
  {
    this.mRenderID = paramInt;
  }
  
  public void setRenderMode(int paramInt)
  {
    if (this.filter != null) {
      ((UKYOFilter)this.filter).setRenderMode(paramInt);
    }
  }
  
  protected void updatePlayerAAttack(boolean paramBoolean)
  {
    if (!VideoPrefsUtil.getMaterialMute())
    {
      initAudioAttack();
      PlayerUtil.Player localPlayer = this.mPlayerAudioattack;
      if (localPlayer == null) {
        return;
      }
      PlayerUtil.startPlayer(localPlayer, paramBoolean);
      return;
    }
    PlayerUtil.stopPlayer(this.mPlayerAudioattack);
  }
  
  public void updatePreview(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof PTDetectInfo)) {
        return;
      }
      this.mCurrentTime = ((PTDetectInfo)paramObject).timestamp;
      if (this.mInitedTime < 0L) {
        this.mInitedTime = this.mCurrentTime;
      }
      Object localObject = this.mFlashStatus;
      int i;
      if ((localObject != null) && (((HashMap)localObject).size() > 0))
      {
        localObject = this.mFlashStatus.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          i = ((Integer)((Iterator)localObject).next()).intValue();
          if (this.mFlashStatus.get(Integer.valueOf(i)) != null) {
            ((UKYOApple.FlashStatus)this.mFlashStatus.get(Integer.valueOf(i))).updateIndex(this.mCurrentTime);
          }
        }
      }
      localObject = this.mAppleList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        UKYOApple.AppleStatus localAppleStatus = (UKYOApple.AppleStatus)((Iterator)localObject).next();
        if (localAppleStatus != null)
        {
          localAppleStatus.updateAppearStatus(this.mCurrentTime - this.mInitedTime);
          if (localAppleStatus.isAppear())
          {
            localAppleStatus.updatePosition(this.mCurrentTime);
            int j = UKYOApple.AppleStatus.access$300(localAppleStatus);
            i = 0;
            if (j == 0) {
              this.mComboCount = 0;
            }
            if (UKYOApple.AppleStatus.access$300(localAppleStatus) >= 0)
            {
              this.mDisapearCount += 1;
              if (this.mDisapearCount == this.mAppleList.size()) {
                allDisappear();
              }
            }
            if ((localAppleStatus.isHitting()) && (this.mComboCount > this.mOriginFlashSeting.COMBO_FLASH_COUNT))
            {
              if (this.mFlashStatus == null) {
                this.mFlashStatus = new HashMap();
              }
              if (this.mFlashStatus.get(Integer.valueOf(localAppleStatus.hashCode())) == null)
              {
                UKYOApple.FlashStatus localFlashStatus = new UKYOApple.FlashStatus(this, this.mOriginFlashSeting, this.mCurrentTime);
                float[] arrayOfFloat = new float[8];
                while (i < localAppleStatus.mAdjustPoints.length)
                {
                  arrayOfFloat[i] = localAppleStatus.mAdjustPoints[i];
                  i += 1;
                }
                float f;
                if (UKYOApple.FlashStatus.access$000(localFlashStatus) != null) {
                  f = UKYOApple.FlashStatus.access$000(localFlashStatus).audioScaleFactor;
                } else {
                  f = 1.0F;
                }
                localFlashStatus.mAdjustPoints = AlgoUtils.adjustPosition(arrayOfFloat, f);
                this.mFlashStatus.put(Integer.valueOf(localAppleStatus.hashCode()), localFlashStatus);
              }
            }
          }
        }
      }
      ((NormalVideoFilter)this.filter).setTriggered(true);
      this.mInfoObjext = paramObject;
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (this.filter == null) {
      return;
    }
    ((UKYOFilter)this.filter).updateVideoSize(paramInt1, paramInt2, paramDouble);
    AppleItemSetting localAppleItemSetting = this.mOriginAppleSetting;
    if ((localAppleItemSetting != null) && (localAppleItemSetting.mWidth == 0))
    {
      localAppleItemSetting = this.mOriginAppleSetting;
      localAppleItemSetting.mWidth = paramInt1;
      localAppleItemSetting.mHeight = paramInt2;
      localAppleItemSetting.updateItemWidth(paramInt1);
    }
    this.mDisapearLine = ((int)(this.mOriginAppleSetting.mDeadY * paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.UKYOApple
 * JD-Core Version:    0.7.0.1
 */