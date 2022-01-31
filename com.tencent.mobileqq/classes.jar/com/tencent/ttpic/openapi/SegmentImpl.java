package com.tencent.ttpic.openapi;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.baseutils.api.ApiHelper;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.openapi.gles.SegmentDataPipe;
import com.tencent.ttpic.thread.SegmentGLThread;
import com.tencent.ttpic.util.MustRunOnGLThread;

public class SegmentImpl
{
  private static final ThreadLocal<SegmentImpl> INSTANCE = new SegmentImpl.1();
  private static String[] NOT_SUPPORT_DEVICE = { "QIHOO_1503-A01", "XIAOMI_MI_3" };
  private boolean isSegLibInitSuccess = true;
  private volatile SegmentDataPipe mDetDataPipe;
  private Frame mRotateFrame = new Frame();
  private SegmentGLThread mSegGLThread;
  private final Object mSegmentLock = new Object();
  private int segLibInitErrorCode;
  private int segLibInitErrorType;
  
  private PTSegAttr genSegAttr(Frame paramFrame)
  {
    PTSegAttr localPTSegAttr = new PTSegAttr();
    localPTSegAttr.setMaskFrame(paramFrame);
    return localPTSegAttr;
  }
  
  public static SegmentImpl getInstance()
  {
    return (SegmentImpl)INSTANCE.get();
  }
  
  private boolean inBlackList(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = NOT_SUPPORT_DEVICE;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void setDataPipe(SegmentDataPipe paramSegmentDataPipe)
  {
    synchronized (this.mSegmentLock)
    {
      this.mDetDataPipe = paramSegmentDataPipe;
      this.mSegmentLock.notifyAll();
      return;
    }
  }
  
  public void destroy()
  {
    this.mRotateFrame.clear();
    if (this.mSegGLThread != null)
    {
      this.mSegGLThread.destroy();
      this.mSegGLThread = null;
    }
  }
  
  public PTSegAttr detectFrame(Frame arg1, int paramInt, boolean paramBoolean)
  {
    Frame localFrame = null;
    if ((this.mSegGLThread != null) && (this.mSegGLThread.isInitReady()) && (paramBoolean)) {
      this.mSegGLThread.postSegJob(???, paramInt);
    }
    for (;;)
    {
      synchronized (this.mSegmentLock)
      {
        try
        {
          if (this.mDetDataPipe == null)
          {
            this.mSegmentLock.wait();
            continue;
          }
          localFrame = localSegmentDataPipe.mMaskFrame;
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          localSegmentDataPipe = this.mDetDataPipe;
          this.mDetDataPipe = null;
          if (localSegmentDataPipe == null) {
            break label163;
          }
        }
        ??? = localSegmentDataPipe.detectTimes;
        return genSegAttr(localFrame).setDetectTimes(???);
      }
      if ((this.mSegGLThread != null) && (!this.mSegGLThread.isLibInitSuccess()))
      {
        this.isSegLibInitSuccess = this.mSegGLThread.isLibInitSuccess();
        this.segLibInitErrorCode = this.mSegGLThread.initLibErrorCode();
        this.segLibInitErrorType = this.mSegGLThread.initLibErrorType();
      }
      label163:
      SegmentDataPipe localSegmentDataPipe = null;
      ??? = localObject1;
      Object localObject2 = localSegmentDataPipe;
    }
  }
  
  public int getSegLibInitErrorCode()
  {
    return this.segLibInitErrorCode;
  }
  
  public int getSegLibInitErrorType()
  {
    return this.segLibInitErrorType;
  }
  
  @MustRunOnGLThread
  @TargetApi(17)
  public void init(String paramString1, String paramString2)
  {
    if ((ApiHelper.hasJellyBeanMR1()) && (this.mSegGLThread == null) && (!inBlackList(DeviceInstance.getInstance().getDeviceName())))
    {
      this.mSegGLThread = new SegmentGLThread(EGL14.eglGetCurrentContext(), paramString1, paramString2);
      this.mSegGLThread.setOnDataReadyListener(new SegmentImpl.2(this));
    }
  }
  
  public boolean isSegLibInitSuccess()
  {
    return this.isSegLibInitSuccess;
  }
  
  public void postJobInSegmentThread(Runnable paramRunnable)
  {
    if (this.mSegGLThread == null) {
      return;
    }
    this.mSegGLThread.postJob(paramRunnable);
  }
  
  public void resetSegmentor()
  {
    this.mDetDataPipe = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.SegmentImpl
 * JD-Core Version:    0.7.0.1
 */