package com.tencent.ttpic.voicechanger.common.audio;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.qq.wx.voice.recognizer.VoiceRecognizer;
import com.tencent.ttpic.baseutils.log.LogUtils;

public class VoiceTextRecognizer
{
  private static final int STATE_CREATED = 0;
  private static final int STATE_DESTROYED = 3;
  private static final int STATE_ERROR = 4;
  private static final int STATE_INITED = 1;
  private static final int STATE_STARTED = 2;
  private static final String TAG = "VoiceTextRecognizer";
  private static String WX_VOICE_RECOGNIZER_APPID = "WXARS1340SNG1518003481_56355";
  private static final VoiceTextRecognizer sInstance = new VoiceTextRecognizer();
  protected HandlerThread handlerThread;
  private Handler mHandler;
  private VoiceTextRecognizer.VRListener mListener = new VoiceTextRecognizer.VRListener(this);
  private int mState = 0;
  private VoiceTextRecognizer.VRErrorListener mVRErrorListener;
  private VoiceTextRecognizer.VTChangeListener mVTListener;
  
  public static VoiceTextRecognizer getInstance()
  {
    try
    {
      VoiceTextRecognizer localVoiceTextRecognizer = sInstance;
      return localVoiceTextRecognizer;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setWxVoiceRecognizerAppid(String paramString)
  {
    WX_VOICE_RECOGNIZER_APPID = paramString;
  }
  
  public void destroy()
  {
    Handler localHandler = this.mHandler;
    if (localHandler == null) {
      return;
    }
    localHandler.post(new VoiceTextRecognizer.3(this));
  }
  
  public void init(Context paramContext, boolean paramBoolean)
  {
    int i = this.mState;
    if ((i != 1) && (i != 2))
    {
      if (this.mHandler == null)
      {
        if (this.handlerThread == null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("VIDEO_TEXT_RECOGNIZER_");
          ((StringBuilder)localObject).append(System.currentTimeMillis());
          this.handlerThread = new HandlerThread(((StringBuilder)localObject).toString());
          this.handlerThread.start();
        }
        if (this.handlerThread.getLooper() != null) {
          this.mHandler = new Handler(this.handlerThread.getLooper());
        }
      }
      Object localObject = this.mHandler;
      if (localObject != null) {
        ((Handler)localObject).post(new VoiceTextRecognizer.1(this, paramBoolean, paramContext));
      }
      return;
    }
    LogUtils.e(TAG, "mState == STATE_INITED || mState == STATE_STARTED");
  }
  
  public void recognizeFromPCMBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.mState != 2) {
      return;
    }
    VoiceRecognizer.shareInstance().appendData(paramArrayOfByte, 0, paramInt, false);
  }
  
  public void setVRErrorListener(VoiceTextRecognizer.VRErrorListener paramVRErrorListener)
  {
    this.mVRErrorListener = paramVRErrorListener;
  }
  
  public void setVoiceTextListener(VoiceTextRecognizer.VTChangeListener paramVTChangeListener)
  {
    this.mVTListener = paramVTChangeListener;
  }
  
  public void start()
  {
    Handler localHandler = this.mHandler;
    if (localHandler == null) {
      return;
    }
    localHandler.post(new VoiceTextRecognizer.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer
 * JD-Core Version:    0.7.0.1
 */