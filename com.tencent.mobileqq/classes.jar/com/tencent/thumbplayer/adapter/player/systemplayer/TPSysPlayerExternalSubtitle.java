package com.tencent.thumbplayer.adapter.player.systemplayer;

import android.text.TextUtils;
import com.tencent.thumbplayer.core.common.TPMediaTrackInfo;
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
  private ITPSysPlayerExternalSubtitle.IPlayPositionListener mPlayPosLis;
  private TPSysPlayerExternalSubtitle.SubtitleState mState = TPSysPlayerExternalSubtitle.SubtitleState.IDLE;
  private ITPSysPlayerExternalSubtitle.IOnSubTitleListener mSubLis;
  private Future<?> mSubPoll = null;
  private final Object mSubPollLock = new Object();
  private TPSubtitleParser mTpSubParser;
  
  private void subPollFunc(int paramInt)
  {
    Object localObject = this.mPlayPosLis;
    ITPSysPlayerExternalSubtitle.IOnSubTitleListener localIOnSubTitleListener = this.mSubLis;
    if ((localObject == null) || (localIOnSubTitleListener == null)) {
      TPLogUtil.w("TPSysPlayerExternalSubtitle", "subPollFunc, posLis:" + localObject + ", subLis:" + localIOnSubTitleListener);
    }
    do
    {
      return;
      long l = ((ITPSysPlayerExternalSubtitle.IPlayPositionListener)localObject).getCurrentPosition();
      if (l < 0L)
      {
        TPLogUtil.w("TPSysPlayerExternalSubtitle", "subPollFunc, cur position:" + l);
        return;
      }
      localObject = this.mTpSubParser.getSubtitleText(l, paramInt);
    } while (TextUtils.equals(this.mLastSubText, (CharSequence)localObject));
    this.mLastSubText = ((String)localObject);
    localIOnSubTitleListener.onSubtileInfo(new ITPSysPlayerExternalSubtitle.SubtileData((String)localObject));
  }
  
  public void prepare()
  {
    if (this.mState != TPSysPlayerExternalSubtitle.SubtitleState.INITED)
    {
      TPLogUtil.e("TPSysPlayerExternalSubtitle", "prepare, illegalState, state:" + this.mState);
      return;
    }
    TPLogUtil.i("TPSysPlayerExternalSubtitle", "prepare.");
    this.mTpSubParser.init();
    ??? = this.mTpSubParser.getTrackInfo();
    if ((??? == null) || (???.length <= 0))
    {
      TPLogUtil.w("TPSysPlayerExternalSubtitle", "prepare, err, trackInfos is empty.");
      this.mState = TPSysPlayerExternalSubtitle.SubtitleState.ERROR;
      return;
    }
    if (???[0].trackType != 3)
    {
      this.mState = TPSysPlayerExternalSubtitle.SubtitleState.ERROR;
      TPLogUtil.w("TPSysPlayerExternalSubtitle", "prepare, err, track type not match.");
      return;
    }
    long l = System.currentTimeMillis();
    this.mTpSubParser.selectTrackAsync(0, l);
    this.mState = TPSysPlayerExternalSubtitle.SubtitleState.PREPARED;
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
  
  public void release()
  {
    TPLogUtil.i("TPSysPlayerExternalSubtitle", "release.");
    this.mPlayPosLis = null;
    this.mSubLis = null;
  }
  
  /* Error */
  public void reset()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle:mState	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle$SubtitleState;
    //   4: getstatic 40	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle$SubtitleState:IDLE	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle$SubtitleState;
    //   7: if_acmpeq +22 -> 29
    //   10: aload_0
    //   11: getfield 90	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle:mTpSubParser	Lcom/tencent/thumbplayer/core/subtitle/TPSubtitleParser;
    //   14: ifnull +10 -> 24
    //   17: aload_0
    //   18: getfield 90	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle:mTpSubParser	Lcom/tencent/thumbplayer/core/subtitle/TPSubtitleParser;
    //   21: invokevirtual 200	com/tencent/thumbplayer/core/subtitle/TPSubtitleParser:unInit	()V
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 90	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle:mTpSubParser	Lcom/tencent/thumbplayer/core/subtitle/TPSubtitleParser;
    //   29: aload_0
    //   30: getfield 35	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle:mSubPollLock	Ljava/lang/Object;
    //   33: astore_1
    //   34: aload_1
    //   35: monitorenter
    //   36: aload_0
    //   37: getfield 33	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle:mSubPoll	Ljava/util/concurrent/Future;
    //   40: ifnull +19 -> 59
    //   43: aload_0
    //   44: getfield 33	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle:mSubPoll	Ljava/util/concurrent/Future;
    //   47: iconst_1
    //   48: invokeinterface 166 2 0
    //   53: pop
    //   54: aload_0
    //   55: aconst_null
    //   56: putfield 33	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle:mSubPoll	Ljava/util/concurrent/Future;
    //   59: aload_1
    //   60: monitorexit
    //   61: aload_0
    //   62: getstatic 40	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle$SubtitleState:IDLE	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle$SubtitleState;
    //   65: putfield 42	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle:mState	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle$SubtitleState;
    //   68: return
    //   69: astore_1
    //   70: ldc 13
    //   72: aload_1
    //   73: invokestatic 203	com/tencent/thumbplayer/utils/TPLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   76: goto -52 -> 24
    //   79: astore_2
    //   80: aload_1
    //   81: monitorexit
    //   82: aload_2
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	TPSysPlayerExternalSubtitle
    //   69	12	1	localException	Exception
    //   79	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	69	java/lang/Exception
    //   36	59	79	finally
    //   59	61	79	finally
    //   80	82	79	finally
  }
  
  public void setDataSource(String paramString)
  {
    if (this.mState != TPSysPlayerExternalSubtitle.SubtitleState.IDLE)
    {
      TPLogUtil.e("TPSysPlayerExternalSubtitle", "setDataSource, illegalState, state:" + this.mState);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      TPLogUtil.e("TPSysPlayerExternalSubtitle", "setDataSource, illegal argument, url:" + paramString);
      return;
    }
    TPLogUtil.i("TPSysPlayerExternalSubtitle", "setDataSource, url: " + paramString);
    if (this.mTpSubParser != null) {
      TPLogUtil.w("TPSysPlayerExternalSubtitle", "setDataSource, mTpSubParser != null.");
    }
    try
    {
      this.mTpSubParser.unInit();
      this.mTpSubParser = null;
      this.mTpSubParser = new TPSubtitleParser(paramString, new TPSysPlayerExternalSubtitle.1(this));
      this.mState = TPSysPlayerExternalSubtitle.SubtitleState.INITED;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void setOnSubTitleListener(ITPSysPlayerExternalSubtitle.IOnSubTitleListener paramIOnSubTitleListener)
  {
    this.mSubLis = paramIOnSubTitleListener;
  }
  
  public void setPlayerPostionListener(ITPSysPlayerExternalSubtitle.IPlayPositionListener paramIPlayPositionListener)
  {
    this.mPlayPosLis = paramIPlayPositionListener;
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: ldc 13
    //   2: ldc 232
    //   4: invokestatic 129	com/tencent/thumbplayer/utils/TPLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_0
    //   8: getfield 42	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle:mState	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle$SubtitleState;
    //   11: getstatic 119	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle$SubtitleState:INITED	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle$SubtitleState;
    //   14: if_acmpeq +23 -> 37
    //   17: aload_0
    //   18: getfield 42	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle:mState	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle$SubtitleState;
    //   21: getstatic 160	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle$SubtitleState:PREPARED	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle$SubtitleState;
    //   24: if_acmpeq +13 -> 37
    //   27: aload_0
    //   28: getfield 42	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle:mState	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle$SubtitleState;
    //   31: getstatic 141	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle$SubtitleState:ERROR	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle$SubtitleState;
    //   34: if_acmpne +22 -> 56
    //   37: aload_0
    //   38: getfield 90	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle:mTpSubParser	Lcom/tencent/thumbplayer/core/subtitle/TPSubtitleParser;
    //   41: ifnull +10 -> 51
    //   44: aload_0
    //   45: getfield 90	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle:mTpSubParser	Lcom/tencent/thumbplayer/core/subtitle/TPSubtitleParser;
    //   48: invokevirtual 200	com/tencent/thumbplayer/core/subtitle/TPSubtitleParser:unInit	()V
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 90	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle:mTpSubParser	Lcom/tencent/thumbplayer/core/subtitle/TPSubtitleParser;
    //   56: aload_0
    //   57: getfield 35	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle:mSubPollLock	Ljava/lang/Object;
    //   60: astore_1
    //   61: aload_1
    //   62: monitorenter
    //   63: aload_0
    //   64: getfield 33	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle:mSubPoll	Ljava/util/concurrent/Future;
    //   67: ifnull +19 -> 86
    //   70: aload_0
    //   71: getfield 33	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle:mSubPoll	Ljava/util/concurrent/Future;
    //   74: iconst_1
    //   75: invokeinterface 166 2 0
    //   80: pop
    //   81: aload_0
    //   82: aconst_null
    //   83: putfield 33	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle:mSubPoll	Ljava/util/concurrent/Future;
    //   86: aload_1
    //   87: monitorexit
    //   88: aload_0
    //   89: getstatic 235	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle$SubtitleState:STOPED	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle$SubtitleState;
    //   92: putfield 42	com/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle:mState	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSysPlayerExternalSubtitle$SubtitleState;
    //   95: return
    //   96: astore_1
    //   97: ldc 13
    //   99: aload_1
    //   100: invokestatic 203	com/tencent/thumbplayer/utils/TPLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: goto -52 -> 51
    //   106: astore_2
    //   107: aload_1
    //   108: monitorexit
    //   109: aload_2
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	TPSysPlayerExternalSubtitle
    //   96	12	1	localException	Exception
    //   106	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   44	51	96	java/lang/Exception
    //   63	86	106	finally
    //   86	88	106	finally
    //   107	109	106	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSysPlayerExternalSubtitle
 * JD-Core Version:    0.7.0.1
 */