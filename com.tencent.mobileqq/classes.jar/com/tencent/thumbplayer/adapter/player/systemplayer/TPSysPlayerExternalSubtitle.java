package com.tencent.thumbplayer.adapter.player.systemplayer;

import android.text.TextUtils;
import com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayerUtils;
import com.tencent.thumbplayer.api.TPSubtitleRenderModel;
import com.tencent.thumbplayer.core.common.TPMediaTrackInfo;
import com.tencent.thumbplayer.core.subtitle.TPNativeSubtitleRenderParams;
import com.tencent.thumbplayer.core.subtitle.TPSubtitleParser;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPThreadUtil;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TPSysPlayerExternalSubtitle
  implements ITPSysPlayerExternalSubtitle
{
  private static final int SUB_POLL_INTV_MS = 200;
  private static final String TAG = "TPSysPlayerExternalSubtitle";
  private String mLastSubText;
  TPNativeSubtitleRenderParams mNativeSubtitleRenderParams;
  private ITPSysPlayerExternalSubtitle.IPlayPositionListener mPlayPosLis;
  private TPSysPlayerExternalSubtitle.SubtitleState mState = TPSysPlayerExternalSubtitle.SubtitleState.IDLE;
  private ITPSysPlayerExternalSubtitle.IOnSubTitleListener mSubLis;
  private Future<?> mSubPoll = null;
  private final Object mSubPollLock = new Object();
  int mSubtitleType = 0;
  private TPSubtitleParser mTpSubParser;
  private ITPSysPlayerExternalSubtitle.IOnTrackSelectListener mTrackSelectLis;
  
  private void handleSubtitleLoadResult(long paramLong)
  {
    if (this.mState != TPSysPlayerExternalSubtitle.SubtitleState.INITED)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("prepare, illegalState, state:");
      ((StringBuilder)???).append(this.mState);
      TPLogUtil.e("TPSysPlayerExternalSubtitle", ((StringBuilder)???).toString());
      return;
    }
    ??? = this.mTpSubParser.getTrackInfo();
    if ((??? != null) && (???.length > 0))
    {
      if (???[0].trackType != 3)
      {
        this.mState = TPSysPlayerExternalSubtitle.SubtitleState.ERROR;
        TPLogUtil.w("TPSysPlayerExternalSubtitle", "prepare, err, track type not match.");
        return;
      }
      this.mTpSubParser.selectTrackAsync(0, paramLong);
      this.mState = TPSysPlayerExternalSubtitle.SubtitleState.PREPARED;
      if (this.mSubtitleType == 0) {
        synchronized (this.mSubPollLock)
        {
          if (this.mSubPoll != null)
          {
            this.mSubPoll.cancel(true);
            this.mSubPoll = null;
          }
          this.mSubPoll = TPThreadUtil.getScheduledExecutorServiceInstance().scheduleAtFixedRate(new TPSysPlayerExternalSubtitle.2(this), 0L, 200L, TimeUnit.MILLISECONDS);
          return;
        }
      }
      return;
    }
    TPLogUtil.w("TPSysPlayerExternalSubtitle", "prepare, err, trackInfos is empty.");
    this.mState = TPSysPlayerExternalSubtitle.SubtitleState.ERROR;
  }
  
  private void subPollFunc(int paramInt)
  {
    Object localObject2 = this.mPlayPosLis;
    Object localObject1 = this.mSubLis;
    if ((localObject2 != null) && (localObject1 != null))
    {
      long l = ((ITPSysPlayerExternalSubtitle.IPlayPositionListener)localObject2).getCurrentPosition();
      if (l < 0L)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("subPollFunc, cur position:");
        ((StringBuilder)localObject1).append(l);
        TPLogUtil.w("TPSysPlayerExternalSubtitle", ((StringBuilder)localObject1).toString());
        return;
      }
      localObject2 = this.mTpSubParser.getSubtitleText(l, paramInt);
      if (TextUtils.equals(this.mLastSubText, (CharSequence)localObject2)) {
        return;
      }
      this.mLastSubText = ((String)localObject2);
      ((ITPSysPlayerExternalSubtitle.IOnSubTitleListener)localObject1).onSubtitleInfo(new ITPSysPlayerExternalSubtitle.SubtitleData((String)localObject2));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("subPollFunc, posLis:");
    localStringBuilder.append(localObject2);
    localStringBuilder.append(", subLis:");
    localStringBuilder.append(localObject1);
    TPLogUtil.w("TPSysPlayerExternalSubtitle", localStringBuilder.toString());
  }
  
  public void pauseAsync()
  {
    if (this.mState != TPSysPlayerExternalSubtitle.SubtitleState.PREPARED)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pauseAsync, illegalState, state:");
      localStringBuilder.append(this.mState);
      TPLogUtil.e("TPSysPlayerExternalSubtitle", localStringBuilder.toString());
      return;
    }
    TPLogUtil.i("TPSysPlayerExternalSubtitle", "pauseAsync");
    this.mTpSubParser.pauseAsync();
  }
  
  public void prepare()
  {
    if (this.mState != TPSysPlayerExternalSubtitle.SubtitleState.INITED)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("prepare, illegalState, state:");
      ((StringBuilder)localObject).append(this.mState);
      TPLogUtil.e("TPSysPlayerExternalSubtitle", ((StringBuilder)localObject).toString());
      return;
    }
    TPLogUtil.i("TPSysPlayerExternalSubtitle", "prepare.");
    this.mTpSubParser.init();
    Object localObject = this.mNativeSubtitleRenderParams;
    if (localObject != null) {
      this.mTpSubParser.setRenderParams((TPNativeSubtitleRenderParams)localObject);
    }
  }
  
  public void release()
  {
    TPLogUtil.i("TPSysPlayerExternalSubtitle", "release.");
    this.mPlayPosLis = null;
    this.mSubLis = null;
  }
  
  public void reset()
  {
    if (this.mState != TPSysPlayerExternalSubtitle.SubtitleState.IDLE)
    {
      TPSubtitleParser localTPSubtitleParser = this.mTpSubParser;
      if (localTPSubtitleParser != null) {
        try
        {
          localTPSubtitleParser.unInit();
        }
        catch (Exception localException)
        {
          TPLogUtil.e("TPSysPlayerExternalSubtitle", localException);
        }
      }
      this.mTpSubParser = null;
    }
    synchronized (this.mSubPollLock)
    {
      if (this.mSubPoll != null)
      {
        this.mSubPoll.cancel(true);
        this.mSubPoll = null;
      }
      this.mState = TPSysPlayerExternalSubtitle.SubtitleState.IDLE;
      return;
    }
  }
  
  public void setDataSource(String paramString, long paramLong)
  {
    if (this.mState != TPSysPlayerExternalSubtitle.SubtitleState.IDLE)
    {
      paramString = new StringBuilder();
      paramString.append("setDataSource, illegalState, state:");
      paramString.append(this.mState);
      TPLogUtil.e("TPSysPlayerExternalSubtitle", paramString.toString());
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDataSource, illegal argument, url:");
      localStringBuilder.append(paramString);
      TPLogUtil.e("TPSysPlayerExternalSubtitle", localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDataSource, url: ");
    localStringBuilder.append(paramString);
    TPLogUtil.i("TPSysPlayerExternalSubtitle", localStringBuilder.toString());
    if (this.mTpSubParser != null)
    {
      TPLogUtil.w("TPSysPlayerExternalSubtitle", "setDataSource, mTpSubParser != null.");
      try
      {
        this.mTpSubParser.unInit();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.mTpSubParser = null;
    }
    this.mTpSubParser = new TPSubtitleParser(paramString, new TPSysPlayerExternalSubtitle.1(this, paramLong), this.mSubtitleType);
    this.mState = TPSysPlayerExternalSubtitle.SubtitleState.INITED;
  }
  
  public void setOnSubTitleListener(ITPSysPlayerExternalSubtitle.IOnSubTitleListener paramIOnSubTitleListener)
  {
    this.mSubLis = paramIOnSubTitleListener;
  }
  
  public void setPlayerPositionListener(ITPSysPlayerExternalSubtitle.IPlayPositionListener paramIPlayPositionListener)
  {
    this.mPlayPosLis = paramIPlayPositionListener;
  }
  
  public void setSubtitleRenderModel(TPSubtitleRenderModel paramTPSubtitleRenderModel)
  {
    this.mNativeSubtitleRenderParams = TPThumbPlayerUtils.convert2TPNativeSubtitleRenderParams(paramTPSubtitleRenderModel);
    paramTPSubtitleRenderModel = this.mTpSubParser;
    if (paramTPSubtitleRenderModel != null) {
      paramTPSubtitleRenderModel.setRenderParams(this.mNativeSubtitleRenderParams);
    }
  }
  
  public void setSubtitleType(int paramInt)
  {
    this.mSubtitleType = paramInt;
  }
  
  public void setTrackSelectListener(ITPSysPlayerExternalSubtitle.IOnTrackSelectListener paramIOnTrackSelectListener)
  {
    this.mTrackSelectLis = paramIOnTrackSelectListener;
  }
  
  public void startAsync()
  {
    if (this.mState != TPSysPlayerExternalSubtitle.SubtitleState.PREPARED)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startAsync, illegalState, state:");
      localStringBuilder.append(this.mState);
      TPLogUtil.e("TPSysPlayerExternalSubtitle", localStringBuilder.toString());
      return;
    }
    TPLogUtil.i("TPSysPlayerExternalSubtitle", "startAsync");
    this.mTpSubParser.startAsync();
  }
  
  public void stop()
  {
    TPLogUtil.i("TPSysPlayerExternalSubtitle", "stop.");
    if ((this.mState == TPSysPlayerExternalSubtitle.SubtitleState.INITED) || (this.mState == TPSysPlayerExternalSubtitle.SubtitleState.PREPARED) || (this.mState == TPSysPlayerExternalSubtitle.SubtitleState.ERROR))
    {
      TPSubtitleParser localTPSubtitleParser = this.mTpSubParser;
      if (localTPSubtitleParser != null) {
        try
        {
          localTPSubtitleParser.stop();
          this.mTpSubParser.unInit();
        }
        catch (Exception localException)
        {
          TPLogUtil.e("TPSysPlayerExternalSubtitle", localException);
        }
      }
      this.mTpSubParser = null;
    }
    if (this.mSubtitleType == 0) {
      synchronized (this.mSubPollLock)
      {
        if (this.mSubPoll != null)
        {
          this.mSubPoll.cancel(true);
          this.mSubPoll = null;
        }
      }
    }
    this.mState = TPSysPlayerExternalSubtitle.SubtitleState.STOPED;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSysPlayerExternalSubtitle
 * JD-Core Version:    0.7.0.1
 */