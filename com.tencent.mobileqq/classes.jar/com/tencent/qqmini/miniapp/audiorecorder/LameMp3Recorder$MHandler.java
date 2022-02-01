package com.tencent.qqmini.miniapp.audiorecorder;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

class LameMp3Recorder$MHandler
  extends Handler
{
  int level = 1;
  private final WeakReference<LameMp3Recorder> recorder;
  
  public LameMp3Recorder$MHandler(LameMp3Recorder paramLameMp3Recorder)
  {
    this.recorder = new WeakReference(paramLameMp3Recorder);
  }
  
  private void onMsgError(Message paramMessage, LameMp3Recorder paramLameMp3Recorder, int paramInt)
  {
    paramMessage = (String)paramMessage.obj;
    if ((!TextUtils.isEmpty(paramMessage)) && (LameMp3Recorder.access$700(paramLameMp3Recorder) != null)) {
      LameMp3Recorder.access$700(paramLameMp3Recorder).onErrorInfo(paramMessage);
    }
    if (hasMessages(paramInt)) {
      removeMessages(paramInt);
    }
  }
  
  private void onMsgPlayFinish(LameMp3Recorder paramLameMp3Recorder)
  {
    if (LameMp3Recorder.access$200(paramLameMp3Recorder) != null) {
      LameMp3Recorder.access$200(paramLameMp3Recorder).onPlayFinish();
    }
    if (hasMessages(104)) {
      removeMessages(104);
    }
  }
  
  private void onMsgPlayPause(LameMp3Recorder paramLameMp3Recorder)
  {
    if (LameMp3Recorder.access$200(paramLameMp3Recorder) != null) {
      LameMp3Recorder.access$200(paramLameMp3Recorder).onPlayPause();
    }
    if (hasMessages(104)) {
      removeMessages(104);
    }
  }
  
  private void onMsgPlayResume(LameMp3Recorder paramLameMp3Recorder)
  {
    if (LameMp3Recorder.access$200(paramLameMp3Recorder) != null) {
      LameMp3Recorder.access$200(paramLameMp3Recorder).onPlayResume();
    }
    if (!hasMessages(104)) {
      sendEmptyMessage(104);
    }
  }
  
  private void onMsgPlayStart(LameMp3Recorder paramLameMp3Recorder)
  {
    if (LameMp3Recorder.access$200(paramLameMp3Recorder) != null) {
      LameMp3Recorder.access$200(paramLameMp3Recorder).onPlayStart();
    }
    LameMp3Recorder.access$302(paramLameMp3Recorder, System.currentTimeMillis());
    sendEmptyMessageDelayed(104, paramLameMp3Recorder.getMaxRecordTime());
  }
  
  private void onMsgPlayStop(LameMp3Recorder paramLameMp3Recorder)
  {
    if (LameMp3Recorder.access$200(paramLameMp3Recorder) != null) {
      LameMp3Recorder.access$200(paramLameMp3Recorder).onPlayStop();
    }
    if (hasMessages(104)) {
      removeMessages(104);
    }
  }
  
  private void onMsgPlayUpdate(LameMp3Recorder paramLameMp3Recorder)
  {
    if (hasMessages(104)) {
      removeMessages(104);
    }
    int i = (int)(System.currentTimeMillis() - LameMp3Recorder.access$300(paramLameMp3Recorder));
    this.level += 1;
    if (this.level > 5) {
      this.level = 1;
    }
    if (LameMp3Recorder.access$200(paramLameMp3Recorder) != null) {
      LameMp3Recorder.access$200(paramLameMp3Recorder).onPlayUpdate(this.level, i / 1000);
    }
    sendEmptyMessageDelayed(104, paramLameMp3Recorder.getMaxRecordTime());
  }
  
  private void onMsgRecordPause(LameMp3Recorder paramLameMp3Recorder)
  {
    if (LameMp3Recorder.access$400(paramLameMp3Recorder) != null) {
      LameMp3Recorder.access$400(paramLameMp3Recorder).onRecordPause();
    }
    if (hasMessages(4)) {
      removeMessages(4);
    }
  }
  
  private void onMsgRecordStart(LameMp3Recorder paramLameMp3Recorder)
  {
    if (LameMp3Recorder.access$400(paramLameMp3Recorder) != null) {
      LameMp3Recorder.access$400(paramLameMp3Recorder).onRecordStart();
    }
    if (!hasMessages(4)) {
      sendEmptyMessage(4);
    }
  }
  
  private void onMsgRecordStop(LameMp3Recorder paramLameMp3Recorder)
  {
    if (LameMp3Recorder.access$400(paramLameMp3Recorder) != null) {
      LameMp3Recorder.access$400(paramLameMp3Recorder).onRecordStop(paramLameMp3Recorder.getRecordFilPath(), paramLameMp3Recorder.getRecordDuration(), paramLameMp3Recorder.getRecordFileSize());
    }
    if (hasMessages(4)) {
      removeMessages(4);
    }
  }
  
  private void onMsgRecordUpdate(LameMp3Recorder paramLameMp3Recorder)
  {
    if (hasMessages(4)) {
      removeMessages(4);
    }
    int i = paramLameMp3Recorder.getTime();
    int j = paramLameMp3Recorder.getVoiceLevel();
    if (LameMp3Recorder.access$400(paramLameMp3Recorder) != null) {
      LameMp3Recorder.access$400(paramLameMp3Recorder).onRecordUpdate(j, i);
    }
    if (i == LameMp3Recorder.access$500(paramLameMp3Recorder))
    {
      LameMp3Recorder.access$600(paramLameMp3Recorder).restoreRecording();
      return;
    }
    sendEmptyMessageDelayed(4, paramLameMp3Recorder.getMaxRecordTime());
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = this.recorder;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = (LameMp3Recorder)this.recorder.get();
      int i = paramMessage.what;
      if (i != -11)
      {
        if (i != -10)
        {
          switch (i)
          {
          default: 
            switch (i)
            {
            default: 
              return;
            case 106: 
              onMsgPlayFinish((LameMp3Recorder)localObject);
              return;
            case 105: 
              onMsgPlayStop((LameMp3Recorder)localObject);
              return;
            case 104: 
              onMsgPlayUpdate((LameMp3Recorder)localObject);
              return;
            case 103: 
              onMsgPlayResume((LameMp3Recorder)localObject);
              return;
            case 102: 
              onMsgPlayPause((LameMp3Recorder)localObject);
              return;
            }
            onMsgPlayStart((LameMp3Recorder)localObject);
            return;
          case 6: 
            LameMp3Recorder.access$100(paramMessage, (LameMp3Recorder)localObject);
            return;
          case 5: 
            onMsgRecordStop((LameMp3Recorder)localObject);
            return;
          case 4: 
            onMsgRecordUpdate((LameMp3Recorder)localObject);
            return;
          case 3: 
            LameMp3Recorder.access$000((LameMp3Recorder)localObject);
            return;
          case 2: 
            onMsgRecordPause((LameMp3Recorder)localObject);
            return;
          }
          onMsgRecordStart((LameMp3Recorder)localObject);
          return;
        }
        onMsgError(paramMessage, (LameMp3Recorder)localObject, 4);
        return;
      }
      onMsgError(paramMessage, (LameMp3Recorder)localObject, 104);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder.MHandler
 * JD-Core Version:    0.7.0.1
 */