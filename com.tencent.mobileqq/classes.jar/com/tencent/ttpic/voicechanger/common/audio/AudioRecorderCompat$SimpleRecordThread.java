package com.tencent.ttpic.voicechanger.common.audio;

import android.media.AudioRecord;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.AudioUtil;

class AudioRecorderCompat$SimpleRecordThread
  extends Thread
{
  private static final String TAG = "SimpleRecordThread";
  
  public AudioRecorderCompat$SimpleRecordThread(AudioRecorderCompat paramAudioRecorderCompat, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append(getName());
    ((StringBuilder)???).append(" begin");
    LogUtils.i("SimpleRecordThread", ((StringBuilder)???).toString());
    label876:
    Object localObject2;
    synchronized (this.this$0.mCurrentState)
    {
      for (;;)
      {
        StringBuilder localStringBuilder2;
        if (this.this$0.mCurrentState.equalState(new int[] { 4 }))
        {
          LogUtils.d("SimpleRecordThread", "run() - State.STATE_INITIALIZED");
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append(getName());
          localStringBuilder1.append(" wait, ");
          localStringBuilder1.append(this.this$0.mCurrentState);
          LogUtils.i("SimpleRecordThread", localStringBuilder1.toString());
          try
          {
            this.this$0.mCurrentState.wait();
          }
          catch (InterruptedException localInterruptedException1)
          {
            LogUtils.w("SimpleRecordThread", "", localInterruptedException1, new Object[0]);
          }
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(getName());
          localStringBuilder2.append(" continue, ");
          localStringBuilder2.append(this.this$0.mCurrentState);
          LogUtils.i("SimpleRecordThread", localStringBuilder2.toString());
        }
        synchronized (this.this$0.mCurrentState)
        {
          if (this.this$0.mCurrentState.equalState(new int[] { 16 }))
          {
            LogUtils.d("SimpleRecordThread", "run() - State.STATE_PAUSED");
            if (this.this$0.mARecorder.getRecordingState() == 3)
            {
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("AudioRecord.stop, ");
              localStringBuilder2.append(this.this$0.mCurrentState);
              LogUtils.d("SimpleRecordThread", localStringBuilder2.toString());
              this.this$0.mARecorder.stop();
            }
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(getName());
            localStringBuilder2.append(" wait, ");
            localStringBuilder2.append(this.this$0.mCurrentState);
            LogUtils.i("SimpleRecordThread", localStringBuilder2.toString());
            try
            {
              this.this$0.mCurrentState.wait();
            }
            catch (InterruptedException localInterruptedException2)
            {
              LogUtils.w("SimpleRecordThread", "", localInterruptedException2, new Object[0]);
            }
            StringBuilder localStringBuilder3 = new StringBuilder();
            localStringBuilder3.append(getName());
            localStringBuilder3.append(" continue, ");
            localStringBuilder3.append(this.this$0.mCurrentState);
            LogUtils.i("SimpleRecordThread", localStringBuilder3.toString());
          }
          if (this.this$0.mCurrentState.equalState(new int[] { 32, 1 }))
          {
            LogUtils.d("SimpleRecordThread", "run() - State.STATE_STOPPED || State.STATE_ERROR");
            if (this.this$0.mARecorder.getRecordingState() == 3)
            {
              ??? = new StringBuilder();
              ((StringBuilder)???).append("AudioRecord.stop, ");
              ((StringBuilder)???).append(this.this$0.mCurrentState);
              LogUtils.d("SimpleRecordThread", ((StringBuilder)???).toString());
              this.this$0.mARecorder.stop();
            }
            this.this$0.onRecordStop();
            this.this$0.mOnErrorListener = null;
            ??? = new StringBuilder();
            ((StringBuilder)???).append(getName());
            ((StringBuilder)???).append(" exit");
            LogUtils.i("SimpleRecordThread", ((StringBuilder)???).toString());
            return;
          }
          if (this.this$0.mCurrentState.equalState(new int[] { 8 }))
          {
            LogUtils.v("SimpleRecordThread", "run() - State.STATE_STARTED");
            if (this.this$0.mARecorder.getRecordingState() == 1)
            {
              long l = System.currentTimeMillis();
              try
              {
                this.this$0.mARecorder.startRecording();
                ??? = new StringBuilder();
                ((StringBuilder)???).append("AudioRecord.startRecording, ");
                ((StringBuilder)???).append(System.currentTimeMillis() - l);
                ((StringBuilder)???).append(", ");
                ((StringBuilder)???).append(this.this$0.mCurrentState);
                LogUtils.d("SimpleRecordThread", ((StringBuilder)???).toString());
                if (this.this$0.mARecorder.getRecordingState() == 1)
                {
                  LogUtils.e("SimpleRecordThread", "startRecording failed");
                  this.this$0.onRecordError(5);
                  this.this$0.mCurrentState.transfer(1);
                  continue;
                }
                if (this.this$0.mHasDelaySet) {
                  break label876;
                }
                this.this$0.mDelay = ((int)(System.currentTimeMillis() - l));
                ??? = new StringBuilder();
                ((StringBuilder)???).append("AudioRecord, delay: ");
                ((StringBuilder)???).append(this.this$0.mDelay);
                LogUtils.i("SimpleRecordThread", ((StringBuilder)???).toString());
                ??? = this.this$0;
                ((AudioRecorderCompat)???).onDelaySet(((AudioRecorderCompat)???).mDelay);
                this.this$0.mHasDelaySet = true;
              }
              catch (SecurityException localSecurityException)
              {
                LogUtils.w("SimpleRecordThread", "AudioRecord.startRecording failed", localSecurityException, new Object[0]);
                this.this$0.onRecordError(5);
                this.this$0.mCurrentState.transfer(1);
              }
              continue;
            }
            int i = this.this$0.mARecorder.read(this.this$0.mBuffer, 0, AudioRecorderCompat.AUDIO_INPUT_BUFFER_SIZE);
            if (AudioRecorderCompat.access$200(this.this$0))
            {
              localObject2 = this.this$0;
              AudioRecorderCompat.access$302((AudioRecorderCompat)localObject2, AudioUtil.getPcmDB16Bit(((AudioRecorderCompat)localObject2).mBuffer, i));
              localObject2 = this.this$0;
              AudioRecorderCompat.access$402((AudioRecorderCompat)localObject2, AudioUtil.pcm16BitToShort(((AudioRecorderCompat)localObject2).mBuffer, i));
              if (AudioRecorderCompat.access$400(this.this$0) != null) {
                AudioUtil.getPcmFFTFromShortBuffer(AudioRecorderCompat.access$400(this.this$0), AudioRecorderCompat.access$400(this.this$0).length, AudioRecorderCompat.access$500(this.this$0));
              }
            }
            if ((i != -3) && (i != -2) && (i > 0))
            {
              localObject2 = this.this$0;
              ((AudioRecorderCompat)localObject2).mHasRecordLength += i;
              localObject2 = this.this$0;
              ((AudioRecorderCompat)localObject2).onRecording(((AudioRecorderCompat)localObject2).mBuffer, i);
            }
            else
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("AudioRecord read return count = ");
              ((StringBuilder)localObject2).append(i);
              LogUtils.e("SimpleRecordThread", ((StringBuilder)localObject2).toString());
              this.this$0.onRecordError(6);
              this.this$0.mCurrentState.transfer(1);
              continue;
            }
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("run() - currentState = ");
          ((StringBuilder)localObject2).append(this.this$0.mCurrentState);
          LogUtils.v("SimpleRecordThread", ((StringBuilder)localObject2).toString());
        }
      }
    }
    for (;;)
    {
      throw localObject4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat.SimpleRecordThread
 * JD-Core Version:    0.7.0.1
 */