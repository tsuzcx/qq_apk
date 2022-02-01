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
    boolean bool = true;
    byte[] arrayOfByte;
    if (MiniGameLameMp3Recorder.access$000(paramMiniGameLameMp3Recorder) != null)
    {
      arrayOfByte = (byte[])paramMessage.obj;
      if (paramMessage.arg1 != 1) {
        break label42;
      }
    }
    for (;;)
    {
      MiniGameLameMp3Recorder.access$000(paramMiniGameLameMp3Recorder).onRecordFrame(arrayOfByte, bool);
      return;
      label42:
      bool = false;
    }
  }
  
  private void onMsgRecordPause(MiniGameLameMp3Recorder paramMiniGameLameMp3Recorder)
  {
    if (paramMiniGameLameMp3Recorder.getRecordDuration() < paramMiniGameLameMp3Recorder.getMinRecordTime()) {
      MiniGameLameMp3Recorder.access$100(paramMiniGameLameMp3Recorder).stopRecord();
    }
    for (;;)
    {
      if (hasMessages(7)) {
        removeMessages(7);
      }
      return;
      if (MiniGameLameMp3Recorder.access$000(paramMiniGameLameMp3Recorder) != null) {
        MiniGameLameMp3Recorder.access$000(paramMiniGameLameMp3Recorder).onRecordPause();
      }
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
    if (paramMiniGameLameMp3Recorder.getRecordDuration() < paramMiniGameLameMp3Recorder.getMinRecordTime()) {
      sendErrorMessage(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_game_record_too_short));
    }
    for (;;)
    {
      if (hasMessages(7)) {
        removeMessages(7);
      }
      return;
      if (MiniGameLameMp3Recorder.access$000(paramMiniGameLameMp3Recorder) != null) {
        MiniGameLameMp3Recorder.access$000(paramMiniGameLameMp3Recorder).onRecordStop(paramMiniGameLameMp3Recorder.getRecordFilePath(), paramMiniGameLameMp3Recorder.getRecordDuration(), paramMiniGameLameMp3Recorder.getRecordFileSize());
      }
      MiniGameLameMp3Recorder.access$102(paramMiniGameLameMp3Recorder, null);
    }
  }
  
  private void onMsgRecordUpdate(MiniGameLameMp3Recorder paramMiniGameLameMp3Recorder)
  {
    if (hasMessages(7)) {
      removeMessages(7);
    }
    long l = paramMiniGameLameMp3Recorder.getRecordDuration();
    if ((l >= paramMiniGameLameMp3Recorder.getRecordTime()) || (l >= paramMiniGameLameMp3Recorder.getMaxRecordTime()))
    {
      MiniGameLameMp3Recorder.access$100(paramMiniGameLameMp3Recorder).stopRecord();
      return;
    }
    sendEmptyMessageDelayed(7, 100L);
  }
  
  public void handleMessage(Message paramMessage)
  {
    MiniGameLameMp3Recorder localMiniGameLameMp3Recorder = (MiniGameLameMp3Recorder)this.recorder.get();
    if (localMiniGameLameMp3Recorder != null) {}
    switch (paramMessage.what)
    {
    case 0: 
    case 5: 
    default: 
      return;
    case 1: 
      onMsgRecordStart(localMiniGameLameMp3Recorder);
      return;
    case 3: 
      onMsgRecordPause(localMiniGameLameMp3Recorder);
      return;
    case 2: 
      onMsgRecordResume(localMiniGameLameMp3Recorder);
      return;
    case 4: 
      onMsgRecordStop(localMiniGameLameMp3Recorder);
      return;
    case 6: 
      onMsgRecordFrame(localMiniGameLameMp3Recorder, paramMessage);
      return;
    case 7: 
      onMsgRecordUpdate(localMiniGameLameMp3Recorder);
      return;
    }
    onMsgRecordError(localMiniGameLameMp3Recorder, paramMessage);
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
    Message localMessage;
    if (paramArrayOfByte != null)
    {
      localMessage = Message.obtain();
      localMessage.obj = paramArrayOfByte;
      localMessage.what = 6;
      if (!paramBoolean) {
        break label42;
      }
    }
    label42:
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      sendMessage(localMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3Recorder.RecorderHandler
 * JD-Core Version:    0.7.0.1
 */