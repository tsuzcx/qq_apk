package com.tencent.mobileqq.mini.audiorecorder;

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
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    LameMp3Recorder localLameMp3Recorder;
    if ((this.recorder != null) && (this.recorder.get() != null))
    {
      localLameMp3Recorder = (LameMp3Recorder)this.recorder.get();
      switch (paramMessage.what)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return;
                          paramMessage = (String)paramMessage.obj;
                          if ((!TextUtils.isEmpty(paramMessage)) && (LameMp3Recorder.access$000(localLameMp3Recorder) != null)) {
                            LameMp3Recorder.access$000(localLameMp3Recorder).onErrorInfo(paramMessage);
                          }
                        } while (!hasMessages(4));
                        removeMessages(4);
                        return;
                        paramMessage = (String)paramMessage.obj;
                        if ((!TextUtils.isEmpty(paramMessage)) && (LameMp3Recorder.access$000(localLameMp3Recorder) != null)) {
                          LameMp3Recorder.access$000(localLameMp3Recorder).onErrorInfo(paramMessage);
                        }
                        if (hasMessages(104)) {
                          removeMessages(104);
                        }
                        if ((!TextUtils.isEmpty(paramMessage)) && (LameMp3Recorder.access$000(localLameMp3Recorder) != null)) {
                          LameMp3Recorder.access$000(localLameMp3Recorder).onErrorInfo(paramMessage);
                        }
                      } while (!hasMessages(104));
                      removeMessages(104);
                      return;
                      if (LameMp3Recorder.access$100(localLameMp3Recorder) != null) {
                        LameMp3Recorder.access$100(localLameMp3Recorder).onRecordStart();
                      }
                    } while (hasMessages(4));
                    sendEmptyMessage(4);
                    return;
                    if (LameMp3Recorder.access$100(localLameMp3Recorder) != null) {
                      LameMp3Recorder.access$100(localLameMp3Recorder).onRecordPause();
                    }
                  } while (!hasMessages(4));
                  removeMessages(4);
                  return;
                  if (LameMp3Recorder.access$100(localLameMp3Recorder) != null) {
                    LameMp3Recorder.access$100(localLameMp3Recorder).onRecordResume();
                  }
                } while (LameMp3Recorder.access$200(localLameMp3Recorder).hasMessages(4));
                LameMp3Recorder.access$200(localLameMp3Recorder).sendEmptyMessage(4);
                return;
                if (LameMp3Recorder.access$100(localLameMp3Recorder) != null) {
                  LameMp3Recorder.access$100(localLameMp3Recorder).onRecordStop(localLameMp3Recorder.getRecordFilPath(), localLameMp3Recorder.getRecordDuration(), localLameMp3Recorder.getRecordFileSize());
                }
              } while (!hasMessages(4));
              removeMessages(4);
              return;
            } while (LameMp3Recorder.access$100(localLameMp3Recorder) == null);
            byte[] arrayOfByte = (byte[])paramMessage.obj;
            if (paramMessage.arg1 == 1) {}
            for (;;)
            {
              LameMp3Recorder.access$100(localLameMp3Recorder).onRecordFrame(arrayOfByte, bool);
              return;
              bool = false;
            }
            if (hasMessages(4)) {
              removeMessages(4);
            }
            int i = localLameMp3Recorder.getTime();
            int j = localLameMp3Recorder.getVoiceLevel();
            if (LameMp3Recorder.access$100(localLameMp3Recorder) != null) {
              LameMp3Recorder.access$100(localLameMp3Recorder).onRecordUpdate(j, i);
            }
            if (i == LameMp3Recorder.access$300(localLameMp3Recorder))
            {
              LameMp3Recorder.access$400(localLameMp3Recorder).restoreRecording();
              return;
            }
            sendEmptyMessageDelayed(4, localLameMp3Recorder.getMaxRecordTime());
            return;
            if (hasMessages(104)) {
              removeMessages(104);
            }
            i = (int)(System.currentTimeMillis() - LameMp3Recorder.access$500(localLameMp3Recorder));
            this.level += 1;
            if (this.level > 5) {
              this.level = 1;
            }
            if (LameMp3Recorder.access$600(localLameMp3Recorder) != null) {
              LameMp3Recorder.access$600(localLameMp3Recorder).onPlayUpdate(this.level, i / 1000);
            }
            sendEmptyMessageDelayed(104, localLameMp3Recorder.getMaxRecordTime());
            return;
            if (LameMp3Recorder.access$600(localLameMp3Recorder) != null) {
              LameMp3Recorder.access$600(localLameMp3Recorder).onPlayStart();
            }
            LameMp3Recorder.access$502(localLameMp3Recorder, System.currentTimeMillis());
            sendEmptyMessageDelayed(104, localLameMp3Recorder.getMaxRecordTime());
            return;
            if (LameMp3Recorder.access$600(localLameMp3Recorder) != null) {
              LameMp3Recorder.access$600(localLameMp3Recorder).onPlayPause();
            }
          } while (!hasMessages(104));
          removeMessages(104);
          return;
          if (LameMp3Recorder.access$600(localLameMp3Recorder) != null) {
            LameMp3Recorder.access$600(localLameMp3Recorder).onPlayResume();
          }
        } while (hasMessages(104));
        sendEmptyMessage(104);
        return;
        if (LameMp3Recorder.access$600(localLameMp3Recorder) != null) {
          LameMp3Recorder.access$600(localLameMp3Recorder).onPlayStop();
        }
      } while (!hasMessages(104));
      removeMessages(104);
      return;
      if (LameMp3Recorder.access$600(localLameMp3Recorder) != null) {
        LameMp3Recorder.access$600(localLameMp3Recorder).onPlayFinish();
      }
    } while (!hasMessages(104));
    removeMessages(104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.audiorecorder.LameMp3Recorder.MHandler
 * JD-Core Version:    0.7.0.1
 */