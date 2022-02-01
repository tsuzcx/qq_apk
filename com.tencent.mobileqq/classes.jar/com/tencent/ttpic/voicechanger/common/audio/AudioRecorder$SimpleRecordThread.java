package com.tencent.ttpic.voicechanger.common.audio;

import android.media.AudioRecord;
import com.tencent.ttpic.baseutils.log.LogUtils;

class AudioRecorder$SimpleRecordThread
  extends Thread
{
  private static final String TAG = "SimpleRecordThread";
  
  public AudioRecorder$SimpleRecordThread(AudioRecorder paramAudioRecorder, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append(getName());
    ((StringBuilder)???).append(" begin");
    LogUtils.i("SimpleRecordThread", ((StringBuilder)???).toString());
    label850:
    Object localObject2;
    synchronized (AudioRecorder.access$100(this.this$0))
    {
      for (;;)
      {
        StringBuilder localStringBuilder2;
        if (AudioRecorder.access$100(this.this$0).equalState(new int[] { 2 }))
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append(getName());
          localStringBuilder1.append(" wait, ");
          localStringBuilder1.append(AudioRecorder.access$100(this.this$0));
          LogUtils.i("SimpleRecordThread", localStringBuilder1.toString());
          try
          {
            AudioRecorder.access$100(this.this$0).wait();
          }
          catch (InterruptedException localInterruptedException1)
          {
            LogUtils.w("SimpleRecordThread", "", localInterruptedException1, new Object[0]);
          }
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(getName());
          localStringBuilder2.append(" continue, ");
          localStringBuilder2.append(AudioRecorder.access$100(this.this$0));
          LogUtils.i("SimpleRecordThread", localStringBuilder2.toString());
        }
        synchronized (AudioRecorder.access$100(this.this$0))
        {
          if (AudioRecorder.access$100(this.this$0).equalState(new int[] { 8 }))
          {
            if (AudioRecorder.access$600(this.this$0).getRecordingState() == 3)
            {
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("AudioRecord.stop, ");
              localStringBuilder2.append(AudioRecorder.access$100(this.this$0));
              LogUtils.d("SimpleRecordThread", localStringBuilder2.toString());
              AudioRecorder.access$600(this.this$0).stop();
            }
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(getName());
            localStringBuilder2.append(" wait, ");
            localStringBuilder2.append(AudioRecorder.access$100(this.this$0));
            LogUtils.i("SimpleRecordThread", localStringBuilder2.toString());
            try
            {
              AudioRecorder.access$100(this.this$0).wait();
            }
            catch (InterruptedException localInterruptedException2)
            {
              LogUtils.w("SimpleRecordThread", "", localInterruptedException2, new Object[0]);
            }
            StringBuilder localStringBuilder3 = new StringBuilder();
            localStringBuilder3.append(getName());
            localStringBuilder3.append(" continue, ");
            localStringBuilder3.append(AudioRecorder.access$100(this.this$0));
            LogUtils.i("SimpleRecordThread", localStringBuilder3.toString());
          }
          if (AudioRecorder.access$100(this.this$0).equalState(new int[] { 16, 0 }))
          {
            if (AudioRecorder.access$600(this.this$0).getRecordingState() == 3)
            {
              ??? = new StringBuilder();
              ((StringBuilder)???).append("AudioRecord.stop, ");
              ((StringBuilder)???).append(AudioRecorder.access$100(this.this$0));
              LogUtils.d("SimpleRecordThread", ((StringBuilder)???).toString());
              AudioRecorder.access$600(this.this$0).stop();
            }
            this.this$0.onRecordStop();
            AudioRecorder.access$702(this.this$0, null);
            ??? = new StringBuilder();
            ((StringBuilder)???).append(getName());
            ((StringBuilder)???).append(" exit");
            LogUtils.i("SimpleRecordThread", ((StringBuilder)???).toString());
            return;
          }
          if (AudioRecorder.access$100(this.this$0).equalState(new int[] { 4 })) {
            if (AudioRecorder.access$600(this.this$0).getRecordingState() == 1)
            {
              long l = System.currentTimeMillis();
              try
              {
                AudioRecorder.access$600(this.this$0).startRecording();
                ??? = new StringBuilder();
                ((StringBuilder)???).append("AudioRecord.startRecording, ");
                ((StringBuilder)???).append(System.currentTimeMillis() - l);
                ((StringBuilder)???).append(", ");
                ((StringBuilder)???).append(AudioRecorder.access$100(this.this$0));
                LogUtils.d("SimpleRecordThread", ((StringBuilder)???).toString());
                if (AudioRecorder.access$600(this.this$0).getRecordingState() == 1)
                {
                  LogUtils.e("SimpleRecordThread", "startRecording failed");
                  this.this$0.onRecordError(5);
                  AudioRecorder.access$100(this.this$0).transfer(0);
                  continue;
                }
                if (AudioRecorder.access$800(this.this$0)) {
                  break label850;
                }
                AudioRecorder.access$902(this.this$0, (int)(System.currentTimeMillis() - l));
                ??? = new StringBuilder();
                ((StringBuilder)???).append("AudioRecord, delay: ");
                ((StringBuilder)???).append(AudioRecorder.access$900(this.this$0));
                LogUtils.i("SimpleRecordThread", ((StringBuilder)???).toString());
                ??? = this.this$0;
                ((AudioRecorder)???).onDelaySet(AudioRecorder.access$900((AudioRecorder)???));
                AudioRecorder.access$802(this.this$0, true);
              }
              catch (SecurityException localSecurityException)
              {
                LogUtils.w("SimpleRecordThread", "AudioRecord.startRecording failed", localSecurityException, new Object[0]);
                this.this$0.onRecordError(5);
                AudioRecorder.access$100(this.this$0).transfer(0);
              }
            }
            else
            {
              int i = AudioRecorder.access$600(this.this$0).read(AudioRecorder.access$1000(this.this$0), 0, AudioRecorderCompat.AUDIO_INPUT_BUFFER_SIZE);
              if ((i != -3) && (i != -2) && (i > 0))
              {
                localObject2 = this.this$0;
                AudioRecorder.access$1102((AudioRecorder)localObject2, AudioRecorder.access$1100((AudioRecorder)localObject2) + i);
                localObject2 = this.this$0;
                ((AudioRecorder)localObject2).onRecording(AudioRecorder.access$1000((AudioRecorder)localObject2), i);
              }
              else
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("AudioRecord read return count = ");
                ((StringBuilder)localObject2).append(i);
                LogUtils.e("SimpleRecordThread", ((StringBuilder)localObject2).toString());
                this.this$0.onRecordError(6);
                AudioRecorder.access$100(this.this$0).transfer(0);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      throw localObject4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorder.SimpleRecordThread
 * JD-Core Version:    0.7.0.1
 */