package com.tencent.qqmini.minigame.audiorecorder;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qqmini.minigame.R.string;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import java.lang.ref.WeakReference;

class MiniGameLameMp3Recorder$RecorderHandler
  extends Handler
{
  public static final int MSG_RECORD_ERROR = -1;
  public static final int MSG_RECORD_FRAME = 6;
  public static final int MSG_RECORD_PAUSE = 3;
  public static final int MSG_RECORD_RESUME = 2;
  public static final int MSG_RECORD_START = 1;
  public static final int MSG_RECORD_STOP = 4;
  public static final int MSG_RECORD_UPDATE = 7;
  private final long UPDATE_INTERVAL = 100L;
  private final WeakReference<MiniGameLameMp3Recorder> recorder;
  
  public MiniGameLameMp3Recorder$RecorderHandler(MiniGameLameMp3Recorder paramMiniGameLameMp3Recorder)
  {
    super(Looper.getMainLooper());
    this.recorder = new WeakReference(paramMiniGameLameMp3Recorder);
  }
  
  private void onMsgRecordError(MiniGameLameMp3Recorder paramMiniGameLameMp3Recorder, Message paramMessage)
  {
    paramMessage = (String)paramMessage.obj;
    if ((!TextUtils.isEmpty(paramMessage)) && (MiniGameLameMp3Recorder.access$000(paramMiniGameLameMp3Recorder) != null)) {
      MiniGameLameMp3Recorder.access$000(paramMiniGameLameMp3Recorder).onRecordError(paramMessage);
    }
    MiniGameLameMp3Recorder.access$100(paramMiniGameLameMp3Recorder).deleteTmpFile();
    MiniGameLameMp3Recorder.access$102(paramMiniGameLameMp3Recorder, null);
    if (hasMessages(7)) {
      removeMessages(7);
    }
  }
  
  private void onMsgRecordFrame(MiniGameLameMp3Recorder paramMiniGameLameMp3Recorder, Message paramMessage)
  {
    if (MiniGameLameMp3Recorder.access$000(paramMiniGameLameMp3Recorder) != null)
    {
      byte[] arrayOfByte = (byte[])paramMessage.obj;
      int i = paramMessage.arg1;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      MiniGameLameMp3Recorder.access$000(paramMiniGameLameMp3Recorder).onRecordFrame(arrayOfByte, bool);
    }
  }
  
  private void onMsgRecordPause(MiniGameLameMp3Recorder paramMiniGameLameMp3Recorder)
  {
    if (paramMiniGameLameMp3Recorder.getRecordDuration() < paramMiniGameLameMp3Recorder.getMinRecordTime()) {
      MiniGameLameMp3Recorder.access$100(paramMiniGameLameMp3Recorder).stopRecord();
    } else if (MiniGameLameMp3Recorder.access$000(paramMiniGameLameMp3Recorder) != null) {
      MiniGameLameMp3Recorder.access$000(paramMiniGameLameMp3Recorder).onRecordPause();
    }
    if (hasMessages(7)) {
      removeMessages(7);
    }
  }
  
  private void onMsgRecordResume(MiniGameLameMp3Recorder paramMiniGameLameMp3Recorder)
  {
    if (MiniGameLameMp3Recorder.access$000(paramMiniGameLameMp3Recorder) != null) {
      MiniGameLameMp3Recorder.access$000(paramMiniGameLameMp3Recorder).onRecordResume();
    }
    if (!hasMessages(7)) {
      sendEmptyMessage(7);
    }
  }
  
  private void onMsgRecordStart(MiniGameLameMp3Recorder paramMiniGameLameMp3Recorder)
  {
    if (MiniGameLameMp3Recorder.access$000(paramMiniGameLameMp3Recorder) != null) {
      MiniGameLameMp3Recorder.access$000(paramMiniGameLameMp3Recorder).onRecordStart();
    }
    if (!hasMessages(7)) {
      sendEmptyMessage(7);
    }
  }
  
  private void onMsgRecordStop(MiniGameLameMp3Recorder paramMiniGameLameMp3Recorder)
  {
    if (paramMiniGameLameMp3Recorder.getRecordDuration() < paramMiniGameLameMp3Recorder.getMinRecordTime())
    {
      sendErrorMessage(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_game_record_too_short));
    }
    else
    {
      if (MiniGameLameMp3Recorder.access$000(paramMiniGameLameMp3Recorder) != null) {
        MiniGameLameMp3Recorder.access$000(paramMiniGameLameMp3Recorder).onRecordStop(paramMiniGameLameMp3Recorder.getRecordFilePath(), paramMiniGameLameMp3Recorder.getRecordDuration(), paramMiniGameLameMp3Recorder.getRecordFileSize());
      }
      MiniGameLameMp3Recorder.access$102(paramMiniGameLameMp3Recorder, null);
    }
    if (hasMessages(7)) {
      removeMessages(7);
    }
  }
  
  private void onMsgRecordUpdate(MiniGameLameMp3Recorder paramMiniGameLameMp3Recorder)
  {
    if (hasMessages(7)) {
      removeMessages(7);
    }
    long l = paramMiniGameLameMp3Recorder.getRecordDuration();
    if ((l < paramMiniGameLameMp3Recorder.getRecordTime()) && (l < paramMiniGameLameMp3Recorder.getMaxRecordTime()))
    {
      sendEmptyMessageDelayed(7, 100L);
      return;
    }
    MiniGameLameMp3Recorder.access$100(paramMiniGameLameMp3Recorder).stopRecord();
  }
  
  public void handleMessage(Message paramMessage)
  {
    MiniGameLameMp3Recorder localMiniGameLameMp3Recorder = (MiniGameLameMp3Recorder)this.recorder.get();
    if (localMiniGameLameMp3Recorder != null)
    {
      int i = paramMessage.what;
      if (i != -1)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i != 6)
                {
                  if (i != 7) {
                    return;
                  }
                  onMsgRecordUpdate(localMiniGameLameMp3Recorder);
                  return;
                }
                onMsgRecordFrame(localMiniGameLameMp3Recorder, paramMessage);
                return;
              }
              onMsgRecordStop(localMiniGameLameMp3Recorder);
              return;
            }
            onMsgRecordPause(localMiniGameLameMp3Recorder);
            return;
          }
          onMsgRecordResume(localMiniGameLameMp3Recorder);
          return;
        }
        onMsgRecordStart(localMiniGameLameMp3Recorder);
        return;
      }
      onMsgRecordError(localMiniGameLameMp3Recorder, paramMessage);
    }
  }
  
  public void sendErrorMessage(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = -1;
    localMessage.obj = paramString;
    sendMessage(localMessage);
  }
  
  public void sendFrameRecordMessage(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3Recorder.RecorderHandler
 * JD-Core Version:    0.7.0.1
 */