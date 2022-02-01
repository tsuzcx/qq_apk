package com.tencent.ttpic.filter.juyoujinggame;

import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.baseutils.audio.PlayerUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil.Player;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.filter.RenderItem;
import com.tencent.ttpic.openapi.manager.TouchTriggerManager;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import java.io.File;
import java.util.Iterator;
import java.util.Vector;

public class UKYOScore
  extends RenderItem
{
  private StickerItem[] mComboItems = new StickerItem[3];
  private Vector<UKYOScore.ScoreStatus> mComboStatus = new Vector();
  private boolean mIsPlaying = true;
  private int mMaxCombo = 0;
  private boolean mNeedShowCombo = false;
  private PlayerUtil.Player mPlayerAudioDefen;
  private PTDetectInfo mPtInfo;
  private UKYOGame.RenderListener mRenderListener = null;
  private UKYOScore.ScoreEffectStatus mScoreEffectStaues;
  private StickerItem[] mScoreItems = new StickerItem[2];
  private ScoreItemSetting mScoreSetting;
  private Vector<UKYOScore.ScoreStatus> mScoreStatus = new Vector();
  
  public UKYOScore(AEFilterI paramAEFilterI, TriggerCtrlItem paramTriggerCtrlItem)
  {
    super(paramAEFilterI, paramTriggerCtrlItem);
  }
  
  private void initAudioDefen()
  {
    if (this.mPlayerAudioDefen == null)
    {
      Object localObject = this.mScoreSetting;
      if (localObject == null) {
        return;
      }
      localObject = ((ScoreItemSetting)localObject).audiodefen;
      String str = this.mScoreSetting.dataPath;
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
          this.mPlayerAudioDefen = PlayerUtil.createPlayerFromAssets(AEModule.getContext(), ((String)localObject).replace("assets://", ""), false);
        } else {
          this.mPlayerAudioDefen = PlayerUtil.createPlayerFromUri(AEModule.getContext(), (String)localObject, false);
        }
        if (this.mPlayerAudioDefen != null) {
          TouchTriggerManager.getInstance().setMusicDuration(this.mPlayerAudioDefen.getDuration());
        }
      }
    }
  }
  
  private Frame renderFilter(Frame paramFrame, Vector<UKYOScore.ScoreStatus> paramVector, UKYOScoreFilter paramUKYOScoreFilter)
  {
    paramVector = paramVector.iterator();
    while (paramVector.hasNext())
    {
      UKYOScore.ScoreStatus localScoreStatus = (UKYOScore.ScoreStatus)paramVector.next();
      if ((localScoreStatus != null) && (localScoreStatus.mStickerItem != null))
      {
        localScoreStatus.updateFrameIndex();
        paramUKYOScoreFilter.setItem(localScoreStatus.mStickerItem);
        paramUKYOScoreFilter.setImageID(localScoreStatus.mImageID);
        paramUKYOScoreFilter.setFrameIndex(0);
        paramUKYOScoreFilter.updatePreview(this.mPtInfo);
        paramFrame = this.mRenderListener.RenderProcessForFilter(paramFrame, null, paramUKYOScoreFilter);
      }
    }
    return this.mRenderListener.RenderProcessForFilter(paramFrame, null, paramUKYOScoreFilter);
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (this.filter != null)
    {
      if (this.mScoreStatus.size() == 0) {
        return paramFrame;
      }
      UKYOScoreFilter localUKYOScoreFilter = (UKYOScoreFilter)this.filter;
      localUKYOScoreFilter.setTriggered(true);
      if (this.triggerCtrlItem != null)
      {
        localFrame = paramFrame;
        if (!this.triggerCtrlItem.isTriggered()) {}
      }
      else
      {
        localFrame = renderFilter(paramFrame, this.mScoreStatus, localUKYOScoreFilter);
        paramFrame = localFrame;
        if (this.mNeedShowCombo)
        {
          paramFrame = localFrame;
          if (this.mComboStatus.size() > 0) {
            paramFrame = renderFilter(localFrame, this.mComboStatus, localUKYOScoreFilter);
          }
        }
        UKYOScore.ScoreEffectStatus localScoreEffectStatus = this.mScoreEffectStaues;
        localFrame = paramFrame;
        if (localScoreEffectStatus != null)
        {
          localFrame = paramFrame;
          if (localScoreEffectStatus.isAppear())
          {
            this.mScoreEffectStaues.updateFrameIndex(this.mPtInfo.timestamp);
            localFrame = paramFrame;
            if (this.mScoreEffectStaues.isAppear())
            {
              localUKYOScoreFilter.setItem(this.mScoreEffectStaues.mStickerItem);
              localUKYOScoreFilter.setImageID(this.mScoreEffectStaues.mImageID);
              localUKYOScoreFilter.setForceFrameIndex(this.mScoreEffectStaues.mCurIndex);
              localUKYOScoreFilter.updatePreview(this.mPtInfo);
              localFrame = this.mRenderListener.RenderProcessForFilter(paramFrame, null, localUKYOScoreFilter);
            }
          }
        }
      }
    }
    return localFrame;
  }
  
  public void apply()
  {
    if (this.filter != null) {
      ((UKYOScoreFilter)this.filter).applyChain();
    }
  }
  
  public void clear()
  {
    if (this.filter != null) {
      ((UKYOScoreFilter)this.filter).clear();
    }
  }
  
  public int getMaxComboCount()
  {
    return this.mMaxCombo;
  }
  
  public void initComboItems(StickerItem paramStickerItem1, StickerItem paramStickerItem2, StickerItem paramStickerItem3)
  {
    StickerItem[] arrayOfStickerItem = this.mComboItems;
    arrayOfStickerItem[0] = paramStickerItem3;
    arrayOfStickerItem[1] = paramStickerItem2;
    arrayOfStickerItem[2] = paramStickerItem1;
    paramStickerItem1 = new UKYOScore.ScoreStatus(this, paramStickerItem3);
    paramStickerItem1.updateImageID(paramStickerItem3.id);
    this.mComboStatus.add(paramStickerItem1);
    this.mComboStatus.add(new UKYOScore.ScoreStatus(this, paramStickerItem2));
  }
  
  public void initScoreEffect(StickerItem paramStickerItem)
  {
    if (paramStickerItem != null)
    {
      if (paramStickerItem.id == null) {
        return;
      }
      this.mScoreEffectStaues = new UKYOScore.ScoreEffectStatus(this, paramStickerItem);
    }
  }
  
  public void initScoreItems(StickerItem paramStickerItem1, StickerItem paramStickerItem2)
  {
    StickerItem[] arrayOfStickerItem = this.mScoreItems;
    arrayOfStickerItem[0] = paramStickerItem1;
    arrayOfStickerItem[1] = paramStickerItem2;
    this.mScoreStatus.clear();
    this.mScoreStatus.add(new UKYOScore.ScoreStatus(this, this.mScoreItems[0]));
  }
  
  public void initScoreSetting(ScoreItemSetting paramScoreItemSetting)
  {
    this.mScoreSetting = paramScoreItemSetting;
    initAudioDefen();
  }
  
  public void reset()
  {
    this.mScoreStatus.clear();
    this.mScoreStatus.add(new UKYOScore.ScoreStatus(this, this.mScoreItems[0]));
    this.mMaxCombo = 0;
    this.mIsPlaying = true;
    if (this.mComboStatus.size() > 2) {
      this.mComboStatus.remove(2);
    }
    UKYOScore.ScoreEffectStatus localScoreEffectStatus = this.mScoreEffectStaues;
    if (localScoreEffectStatus != null) {
      localScoreEffectStatus.reset();
    }
  }
  
  public void setListener(UKYOGame.RenderListener paramRenderListener)
  {
    this.mRenderListener = paramRenderListener;
  }
  
  public void setRenderMode(int paramInt)
  {
    if (this.filter != null) {
      ((UKYOScoreFilter)this.filter).setRenderMode(paramInt);
    }
  }
  
  public void updateCombo(int paramInt)
  {
    boolean bool1 = this.mIsPlaying;
    boolean bool2 = false;
    if ((bool1) && (paramInt <= 0)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    this.mNeedShowCombo = bool1;
    if (paramInt > this.mMaxCombo) {
      this.mMaxCombo = paramInt;
    }
    if ((paramInt > 9) && (this.mComboStatus.size() < 3)) {
      this.mComboStatus.add(1, new UKYOScore.ScoreStatus(this, this.mComboItems[2]));
    }
    if ((paramInt < 10) && (this.mComboStatus.size() == 3)) {
      this.mComboStatus.remove(1);
    }
    int i = paramInt;
    paramInt = 1;
    Object localObject;
    StickerItem localStickerItem;
    while (paramInt < this.mComboStatus.size())
    {
      localObject = (UKYOScore.ScoreStatus)this.mComboStatus.get(paramInt);
      ((UKYOScore.ScoreStatus)localObject).updateImageID(this.mScoreSetting.getScoreImageID(i % 10));
      i /= 10;
      if (((UKYOScore.ScoreStatus)localObject).mStickerItem.positionsUKYO != null)
      {
        localObject = ((UKYOScore.ScoreStatus)this.mComboStatus.get(paramInt)).mStickerItem.positionsUKYO;
        localStickerItem = ((UKYOScore.ScoreStatus)this.mComboStatus.get(paramInt)).mStickerItem;
        if (this.mComboStatus.size() == 2) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((UKYOScorePositions)localObject).updateAnchor(localStickerItem, bool1, this.mIsPlaying);
      }
      paramInt += 1;
    }
    if (((UKYOScore.ScoreStatus)this.mComboStatus.get(0)).mStickerItem.positionsUKYO != null)
    {
      localObject = ((UKYOScore.ScoreStatus)this.mComboStatus.get(0)).mStickerItem.positionsUKYO;
      localStickerItem = ((UKYOScore.ScoreStatus)this.mComboStatus.get(0)).mStickerItem;
      bool1 = bool2;
      if (this.mComboStatus.size() == 2) {
        bool1 = true;
      }
      ((UKYOScorePositions)localObject).updateAnchor(localStickerItem, bool1, this.mIsPlaying);
    }
  }
  
  protected void updatePlayerDefen(boolean paramBoolean)
  {
    if (!VideoPrefsUtil.getMaterialMute())
    {
      initAudioDefen();
      PlayerUtil.Player localPlayer = this.mPlayerAudioDefen;
      if (localPlayer == null) {
        return;
      }
      PlayerUtil.startPlayer(localPlayer, paramBoolean);
      return;
    }
    PlayerUtil.stopPlayer(this.mPlayerAudioDefen);
  }
  
  public void updatePlayingState(boolean paramBoolean)
  {
    this.mIsPlaying = paramBoolean;
  }
  
  public void updatePreview(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof PTDetectInfo)) {
        return;
      }
      this.mPtInfo = ((PTDetectInfo)paramObject);
    }
  }
  
  public void updateScore(int paramInt)
  {
    if ((paramInt > 9) && (this.mScoreStatus.size() < 2)) {
      this.mScoreStatus.add(new UKYOScore.ScoreStatus(this, this.mScoreItems[1]));
    }
    Object localObject1;
    if ((paramInt > 0) && (paramInt % 5 == 0))
    {
      localObject1 = this.mScoreEffectStaues;
      if ((localObject1 != null) && (((UKYOScore.ScoreEffectStatus)localObject1).mLastScore != paramInt))
      {
        if (paramInt >= 10)
        {
          localObject1 = this.mScoreEffectStaues;
          ((UKYOScore.ScoreEffectStatus)localObject1).mLastScore = paramInt;
          ((UKYOScore.ScoreEffectStatus)localObject1).needAppear();
        }
        if (paramInt > 0) {
          updatePlayerDefen(false);
        }
      }
    }
    int i = paramInt;
    paramInt = 0;
    while (paramInt < this.mScoreStatus.size())
    {
      Object localObject2 = (UKYOScore.ScoreStatus)this.mScoreStatus.get(paramInt);
      ((UKYOScore.ScoreStatus)localObject2).updateImageID(this.mScoreSetting.getScoreImageID(i % 10));
      i /= 10;
      if (((UKYOScore.ScoreStatus)localObject2).mStickerItem.positionsUKYO != null)
      {
        localObject1 = ((UKYOScore.ScoreStatus)localObject2).mStickerItem.positionsUKYO;
        localObject2 = ((UKYOScore.ScoreStatus)localObject2).mStickerItem;
        boolean bool;
        if (this.mScoreStatus.size() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((UKYOScorePositions)localObject1).updateAnchor((StickerItem)localObject2, bool, this.mIsPlaying);
      }
      paramInt += 1;
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (this.filter == null) {
      return;
    }
    ((UKYOScoreFilter)this.filter).updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.UKYOScore
 * JD-Core Version:    0.7.0.1
 */