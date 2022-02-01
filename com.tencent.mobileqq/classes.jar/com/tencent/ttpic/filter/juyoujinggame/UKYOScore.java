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
    if ((this.mPlayerAudioDefen != null) || (this.mScoreSetting == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.mScoreSetting.audiodefen;
      String str = this.mScoreSetting.dataPath;
      if ((localObject != null) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(((StickerItem)localObject).id)) && (!TextUtils.isEmpty(((StickerItem)localObject).audio)))
      {
        localObject = str + File.separator + ((StickerItem)localObject).id + File.separator + ((StickerItem)localObject).audio;
        if (((String)localObject).startsWith("assets://")) {}
        for (this.mPlayerAudioDefen = PlayerUtil.createPlayerFromAssets(AEModule.getContext(), ((String)localObject).replace("assets://", ""), false); this.mPlayerAudioDefen != null; this.mPlayerAudioDefen = PlayerUtil.createPlayerFromUri(AEModule.getContext(), (String)localObject, false))
        {
          TouchTriggerManager.getInstance().setMusicDuration(this.mPlayerAudioDefen.getDuration());
          return;
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
    Frame localFrame;
    if ((this.filter == null) || (this.mScoreStatus.size() == 0)) {
      localFrame = paramFrame;
    }
    UKYOScoreFilter localUKYOScoreFilter;
    do
    {
      do
      {
        do
        {
          return localFrame;
          localUKYOScoreFilter = (UKYOScoreFilter)this.filter;
          localUKYOScoreFilter.setTriggered(true);
          if ((this.triggerCtrlItem != null) && (!this.triggerCtrlItem.isTriggered())) {
            break;
          }
          localFrame = renderFilter(paramFrame, this.mScoreStatus, localUKYOScoreFilter);
          paramFrame = localFrame;
          if (this.mNeedShowCombo)
          {
            paramFrame = localFrame;
            if (this.mComboStatus.size() > 0) {
              paramFrame = renderFilter(localFrame, this.mComboStatus, localUKYOScoreFilter);
            }
          }
          localFrame = paramFrame;
        } while (this.mScoreEffectStaues == null);
        localFrame = paramFrame;
      } while (!this.mScoreEffectStaues.isAppear());
      this.mScoreEffectStaues.updateFrameIndex(this.mPtInfo.timestamp);
      localFrame = paramFrame;
    } while (!this.mScoreEffectStaues.isAppear());
    localUKYOScoreFilter.setItem(this.mScoreEffectStaues.mStickerItem);
    localUKYOScoreFilter.setImageID(this.mScoreEffectStaues.mImageID);
    localUKYOScoreFilter.setForceFrameIndex(this.mScoreEffectStaues.mCurIndex);
    localUKYOScoreFilter.updatePreview(this.mPtInfo);
    return this.mRenderListener.RenderProcessForFilter(paramFrame, null, localUKYOScoreFilter);
    return paramFrame;
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
    this.mComboItems[0] = paramStickerItem3;
    this.mComboItems[1] = paramStickerItem2;
    this.mComboItems[2] = paramStickerItem1;
    paramStickerItem1 = new UKYOScore.ScoreStatus(this, paramStickerItem3);
    paramStickerItem1.updateImageID(paramStickerItem3.id);
    this.mComboStatus.add(paramStickerItem1);
    this.mComboStatus.add(new UKYOScore.ScoreStatus(this, paramStickerItem2));
  }
  
  public void initScoreEffect(StickerItem paramStickerItem)
  {
    if ((paramStickerItem == null) || (paramStickerItem.id == null)) {
      return;
    }
    this.mScoreEffectStaues = new UKYOScore.ScoreEffectStatus(this, paramStickerItem);
  }
  
  public void initScoreItems(StickerItem paramStickerItem1, StickerItem paramStickerItem2)
  {
    this.mScoreItems[0] = paramStickerItem1;
    this.mScoreItems[1] = paramStickerItem2;
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
    if (this.mScoreEffectStaues != null) {
      this.mScoreEffectStaues.reset();
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
    boolean bool2 = true;
    label107:
    Object localObject;
    StickerItem localStickerItem;
    if ((!this.mIsPlaying) || (paramInt > 0))
    {
      bool1 = true;
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
      int j = 1;
      int i = paramInt;
      paramInt = j;
      if (paramInt >= this.mComboStatus.size()) {
        break label244;
      }
      localObject = (UKYOScore.ScoreStatus)this.mComboStatus.get(paramInt);
      ((UKYOScore.ScoreStatus)localObject).updateImageID(this.mScoreSetting.getScoreImageID(i % 10));
      i /= 10;
      if (((UKYOScore.ScoreStatus)localObject).mStickerItem.positionsUKYO != null)
      {
        localObject = ((UKYOScore.ScoreStatus)this.mComboStatus.get(paramInt)).mStickerItem.positionsUKYO;
        localStickerItem = ((UKYOScore.ScoreStatus)this.mComboStatus.get(paramInt)).mStickerItem;
        if (this.mComboStatus.size() != 2) {
          break label238;
        }
      }
    }
    label238:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((UKYOScorePositions)localObject).updateAnchor(localStickerItem, bool1, this.mIsPlaying);
      paramInt += 1;
      break label107;
      bool1 = false;
      break;
    }
    label244:
    if (((UKYOScore.ScoreStatus)this.mComboStatus.get(0)).mStickerItem.positionsUKYO != null)
    {
      localObject = ((UKYOScore.ScoreStatus)this.mComboStatus.get(0)).mStickerItem.positionsUKYO;
      localStickerItem = ((UKYOScore.ScoreStatus)this.mComboStatus.get(0)).mStickerItem;
      if (this.mComboStatus.size() != 2) {
        break label328;
      }
    }
    label328:
    for (bool1 = bool2;; bool1 = false)
    {
      ((UKYOScorePositions)localObject).updateAnchor(localStickerItem, bool1, this.mIsPlaying);
      return;
    }
  }
  
  protected void updatePlayerDefen(boolean paramBoolean)
  {
    if (!VideoPrefsUtil.getMaterialMute())
    {
      initAudioDefen();
      if (this.mPlayerAudioDefen == null) {
        return;
      }
      PlayerUtil.startPlayer(this.mPlayerAudioDefen, paramBoolean);
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
    if ((paramObject == null) || (!(paramObject instanceof PTDetectInfo))) {
      return;
    }
    this.mPtInfo = ((PTDetectInfo)paramObject);
  }
  
  public void updateScore(int paramInt)
  {
    if ((paramInt > 9) && (this.mScoreStatus.size() < 2)) {
      this.mScoreStatus.add(new UKYOScore.ScoreStatus(this, this.mScoreItems[1]));
    }
    if ((paramInt > 0) && (paramInt % 5 == 0) && (this.mScoreEffectStaues != null) && (this.mScoreEffectStaues.mLastScore != paramInt))
    {
      if (paramInt >= 10)
      {
        this.mScoreEffectStaues.mLastScore = paramInt;
        this.mScoreEffectStaues.needAppear();
      }
      if (paramInt > 0) {
        updatePlayerDefen(false);
      }
    }
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (paramInt < this.mScoreStatus.size())
    {
      Object localObject = (UKYOScore.ScoreStatus)this.mScoreStatus.get(paramInt);
      ((UKYOScore.ScoreStatus)localObject).updateImageID(this.mScoreSetting.getScoreImageID(i % 10));
      i /= 10;
      UKYOScorePositions localUKYOScorePositions;
      if (((UKYOScore.ScoreStatus)localObject).mStickerItem.positionsUKYO != null)
      {
        localUKYOScorePositions = ((UKYOScore.ScoreStatus)localObject).mStickerItem.positionsUKYO;
        localObject = ((UKYOScore.ScoreStatus)localObject).mStickerItem;
        if (this.mScoreStatus.size() != 1) {
          break label210;
        }
      }
      label210:
      for (boolean bool = true;; bool = false)
      {
        localUKYOScorePositions.updateAnchor((StickerItem)localObject, bool, this.mIsPlaying);
        paramInt += 1;
        break;
      }
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