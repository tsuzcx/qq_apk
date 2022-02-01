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
    }
    for (;;)
    {
      TriggerStateManager.getInstance().getTriggerStateItem(this.mRenderID).forceUpdateState(str);
      return;
      if (f >= 0.56F) {
        str = "state002";
      } else if (f >= 0.25F) {
        str = "state003";
      } else {
        str = "state004";
      }
    }
  }
  
  private double getLeft(double paramDouble)
  {
    if (paramDouble < 0.3D) {
      paramDouble = 0.667D * paramDouble;
    }
    double d;
    do
    {
      return paramDouble;
      if (paramDouble <= 0.7D) {
        break;
      }
      d = (paramDouble - 0.7D) * 0.66D + 0.65D;
      paramDouble = d;
    } while (this.mOriginAppleSetting == null);
    return d * this.mOriginAppleSetting.maxWidth;
    return (paramDouble - 0.3D) * 1.5D + 0.2D;
  }
  
  private void initAudioAttack()
  {
    if (this.mPlayerAudioattack != null) {}
    for (;;)
    {
      return;
      Object localObject = this.mOriginAppleSetting.audioattack;
      String str = this.mOriginAppleSetting.dataPath;
      if ((localObject != null) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(((StickerItem)localObject).id)) && (!TextUtils.isEmpty(((StickerItem)localObject).audio)))
      {
        localObject = str + File.separator + ((StickerItem)localObject).id + File.separator + ((StickerItem)localObject).audio;
        if (((String)localObject).startsWith("assets://")) {}
        for (this.mPlayerAudioattack = PlayerUtil.createPlayerFromAssets(AEModule.getContext(), ((String)localObject).replace("assets://", ""), false); this.mPlayerAudioattack != null; this.mPlayerAudioattack = PlayerUtil.createPlayerFromUri(AEModule.getContext(), (String)localObject, false))
        {
          TouchTriggerManager.getInstance().setMusicDuration(this.mPlayerAudioattack.getDuration());
          return;
        }
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
        if (localAppleStatus.frameIndex >= 0) {}
        for (int i = localAppleStatus.frameIndex;; i = 0)
        {
          localUKYOFilter.setFrameIndex(i);
          localUKYOFilter.setPositions(localAppleStatus.mAdjustPoints);
          localUKYOFilter.updatePreview(this.mInfoObjext);
          paramFrame = this.mRenderListener.RenderProcessForFilter(paramFrame, null, localUKYOFilter);
          break;
        }
      }
    }
    return paramFrame;
  }
  
  private Frame rendFlash(Frame paramFrame)
  {
    Object localObject2 = paramFrame;
    if (this.mFlashStatus != null)
    {
      if (this.mFlashStatus.size() == 0) {
        localObject2 = paramFrame;
      }
    }
    else {
      return localObject2;
    }
    UKYOFilter localUKYOFilter = (UKYOFilter)this.filter;
    Iterator localIterator = this.mFlashStatus.keySet().iterator();
    localObject2 = null;
    Object localObject1 = paramFrame;
    paramFrame = (Frame)localObject2;
    label57:
    int i;
    UKYOApple.FlashStatus localFlashStatus;
    if (localIterator.hasNext())
    {
      i = ((Integer)localIterator.next()).intValue();
      localFlashStatus = (UKYOApple.FlashStatus)this.mFlashStatus.get(Integer.valueOf(i));
      if (localFlashStatus == null)
      {
        if (paramFrame != null) {
          break label288;
        }
        paramFrame = new ArrayList();
      }
    }
    label288:
    for (;;)
    {
      paramFrame.add(Integer.valueOf(i));
      break label57;
      localUKYOFilter.setImageID(UKYOApple.FlashStatus.access$000(localFlashStatus).mImageID);
      localUKYOFilter.setFrameIndex(localFlashStatus.frameIndex);
      localUKYOFilter.setPositions(localFlashStatus.mAdjustPoints);
      localUKYOFilter.updatePreview(this.mInfoObjext);
      localObject2 = this.mRenderListener.RenderProcessForFilter((Frame)localObject1, null, localUKYOFilter);
      localObject1 = localObject2;
      if (!UKYOApple.FlashStatus.access$100(localFlashStatus)) {
        break label57;
      }
      localObject1 = paramFrame;
      if (paramFrame == null) {
        localObject1 = new ArrayList();
      }
      ((ArrayList)localObject1).add(Integer.valueOf(i));
      paramFrame = (Frame)localObject1;
      localObject1 = localObject2;
      break label57;
      localObject2 = localObject1;
      if (paramFrame == null) {
        break;
      }
      localObject2 = localObject1;
      if (paramFrame.size() <= 0) {
        break;
      }
      paramFrame = paramFrame.iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!paramFrame.hasNext()) {
          break;
        }
        i = ((Integer)paramFrame.next()).intValue();
        this.mFlashStatus.remove(Integer.valueOf(i));
      }
    }
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    if (this.filter == null) {}
    while ((this.triggerCtrlItem != null) && (!this.triggerCtrlItem.isTriggered())) {
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
    if (this.mAppleList != null) {
      this.mAppleList.clear();
    }
    ((UKYOFilter)this.filter).clear();
    destroyAudio();
  }
  
  public void destroyAudio()
  {
    if (this.mPlayerAudioattack != null)
    {
      PlayerUtil.destroyPlayer(this.mPlayerAudioattack);
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
    if ((this.mOriginAppleSetting == null) || (this.mOriginAppleSetting.mAppleAppearTime == null) || (this.mOriginAppleSetting.mAppleAppearTime.size() == 0)) {
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
  
  public void initFlashSetting(FlashItemSetting paramFlashItemSetting)
  {
    this.mOriginFlashSeting = paramFlashItemSetting;
  }
  
  public boolean isPlaying()
  {
    return !this.mIsAllDisappear;
  }
  
  public void reset()
  {
    if (this.mAppleList != null)
    {
      Iterator localIterator = this.mAppleList.iterator();
      while (localIterator.hasNext()) {
        ((UKYOApple.AppleStatus)localIterator.next()).reset();
      }
    }
    if (this.mFlashStatus != null) {
      this.mFlashStatus.clear();
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
      if (this.mPlayerAudioattack == null) {
        return;
      }
      PlayerUtil.startPlayer(this.mPlayerAudioattack, paramBoolean);
      return;
    }
    PlayerUtil.stopPlayer(this.mPlayerAudioattack);
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof PTDetectInfo))) {
      return;
    }
    this.mCurrentTime = ((PTDetectInfo)paramObject).timestamp;
    if (this.mInitedTime < 0L) {
      this.mInitedTime = this.mCurrentTime;
    }
    int i;
    if ((this.mFlashStatus != null) && (this.mFlashStatus.size() > 0))
    {
      localIterator = this.mFlashStatus.keySet().iterator();
      while (localIterator.hasNext())
      {
        i = ((Integer)localIterator.next()).intValue();
        if (this.mFlashStatus.get(Integer.valueOf(i)) != null) {
          ((UKYOApple.FlashStatus)this.mFlashStatus.get(Integer.valueOf(i))).updateIndex(this.mCurrentTime);
        }
      }
    }
    Iterator localIterator = this.mAppleList.iterator();
    while (localIterator.hasNext())
    {
      UKYOApple.AppleStatus localAppleStatus = (UKYOApple.AppleStatus)localIterator.next();
      if (localAppleStatus != null)
      {
        localAppleStatus.updateAppearStatus(this.mCurrentTime - this.mInitedTime);
        if (localAppleStatus.isAppear())
        {
          localAppleStatus.updatePosition(this.mCurrentTime);
          if (UKYOApple.AppleStatus.access$300(localAppleStatus) == 0) {
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
              i = 0;
              while (i < localAppleStatus.mAdjustPoints.length)
              {
                arrayOfFloat[i] = localAppleStatus.mAdjustPoints[i];
                i += 1;
              }
              if (UKYOApple.FlashStatus.access$000(localFlashStatus) != null) {}
              for (float f = UKYOApple.FlashStatus.access$000(localFlashStatus).audioScaleFactor;; f = 1.0F)
              {
                localFlashStatus.mAdjustPoints = AlgoUtils.adjustPosition(arrayOfFloat, f);
                this.mFlashStatus.put(Integer.valueOf(localAppleStatus.hashCode()), localFlashStatus);
                break;
              }
            }
          }
        }
      }
    }
    ((NormalVideoFilter)this.filter).setTriggered(true);
    this.mInfoObjext = paramObject;
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (this.filter == null) {
      return;
    }
    ((UKYOFilter)this.filter).updateVideoSize(paramInt1, paramInt2, paramDouble);
    if ((this.mOriginAppleSetting != null) && (this.mOriginAppleSetting.mWidth == 0))
    {
      this.mOriginAppleSetting.mWidth = paramInt1;
      this.mOriginAppleSetting.mHeight = paramInt2;
      this.mOriginAppleSetting.updateItemWidth(paramInt1);
    }
    this.mDisapearLine = ((int)(this.mOriginAppleSetting.mDeadY * paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.UKYOApple
 * JD-Core Version:    0.7.0.1
 */