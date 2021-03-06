package com.tencent.ttpic.voicechanger.common.audio;

import android.os.AsyncTask;
import com.tencent.ttpic.baseutils.log.LogUtils;

public class VoiceChangeTask
  extends AsyncTask<String, Integer, Integer>
{
  private static final String TAG = "VoiceChangeTask";
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
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<<<<<<<<<<【任务】变声：");
    localStringBuilder.append(this.mSrcFile);
    localStringBuilder.append(" -> 取消");
    LogUtils.i(str, localStringBuilder.toString());
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    long l = System.currentTimeMillis() - this.timeStarted;
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<<<<<<<<<<【任务】变声：");
    localStringBuilder.append(this.mOutputPath);
    localStringBuilder.append("(");
    localStringBuilder.append(String.valueOf(l));
    localStringBuilder.append(") -> 完成");
    LogUtils.d(str, localStringBuilder.toString());
    if (this.mListener != null)
    {
      if (paramInteger.intValue() == 1)
      {
        this.mListener.onVoiceChangeTaskSuccess(l);
        return;
      }
      this.mListener.onVoiceChangeTaskFailed(paramInteger.intValue());
    }
  }
  
  protected void onPreExecute()
  {
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">>>>>>>>>>【任务】变声：");
    localStringBuilder.append(this.mSrcFile);
    localStringBuilder.append("(");
    localStringBuilder.append(this.mVoiceKind);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.mEnvironment);
    localStringBuilder.append(") -> 开始");
    LogUtils.d((String)localObject, localStringBuilder.toString());
    this.timeStarted = System.currentTimeMillis();
    localObject = this.mListener;
    if (localObject != null) {
      ((VoiceChangeTask.VoiceChangeTaskListener)localObject).onVoiceChangeTaskStart();
    }
  }
  
  protected void onProgressUpdate(Integer... paramVarArgs)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onProgressUpdate(");
    localStringBuilder.append(paramVarArgs);
    localStringBuilder.append(")");
    LogUtils.d(str, localStringBuilder.toString());
  }
  
  public void setListener(VoiceChangeTask.VoiceChangeTaskListener paramVoiceChangeTaskListener)
  {
    this.mListener = paramVoiceChangeTaskListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.VoiceChangeTask
 * JD-Core Version:    0.7.0.1
 */