package com.tencent.ttpic.voicechanger.common.audio;

import android.os.AsyncTask;
import com.tencent.ttpic.baseutils.log.LogUtils;

public class VoiceChangeTask
  extends AsyncTask<String, Integer, Integer>
{
  private static final String TAG = VoiceChangeTask.class.getSimpleName();
  private int mEnvironment;
  VoiceChangeTask.VoiceChangeTaskListener mListener;
  private String mOutputPath;
  private String mSrcFile;
  private int mVoiceKind;
  private long timeStarted;
  
  public VoiceChangeTask(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.mSrcFile = paramString1;
    this.mOutputPath = paramString2;
    this.mVoiceKind = paramInt1;
    this.mEnvironment = paramInt2;
  }
  
  protected Integer doInBackground(String... paramVarArgs)
  {
    return Integer.valueOf(VoiceChanger.changeVoice4File(this.mSrcFile, this.mOutputPath, AudioRecorderCompat.AUDIO_SAMPLE_RATE_IN_HZ, this.mVoiceKind, this.mEnvironment));
  }
  
  protected void onCancelled()
  {
    LogUtils.i(TAG, "<<<<<<<<<<【任务】变声：" + this.mSrcFile + " -> 取消");
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    long l = System.currentTimeMillis() - this.timeStarted;
    LogUtils.d(TAG, "<<<<<<<<<<【任务】变声：" + this.mOutputPath + "(" + String.valueOf(l) + ") -> 完成");
    if (this.mListener != null)
    {
      if (paramInteger.intValue() == 1) {
        this.mListener.onVoiceChangeTaskSuccess(l);
      }
    }
    else {
      return;
    }
    this.mListener.onVoiceChangeTaskFailed(paramInteger.intValue());
  }
  
  protected void onPreExecute()
  {
    LogUtils.d(TAG, ">>>>>>>>>>【任务】变声：" + this.mSrcFile + "(" + this.mVoiceKind + ", " + this.mEnvironment + ") -> 开始");
    this.timeStarted = System.currentTimeMillis();
    if (this.mListener != null) {
      this.mListener.onVoiceChangeTaskStart();
    }
  }
  
  protected void onProgressUpdate(Integer... paramVarArgs)
  {
    LogUtils.d(TAG, "onProgressUpdate(" + paramVarArgs + ")");
  }
  
  public void setListener(VoiceChangeTask.VoiceChangeTaskListener paramVoiceChangeTaskListener)
  {
    this.mListener = paramVoiceChangeTaskListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.VoiceChangeTask
 * JD-Core Version:    0.7.0.1
 */