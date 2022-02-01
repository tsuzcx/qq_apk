package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.shortvideo.eglwraper.EglCore;
import com.tencent.mobileqq.shortvideo.eglwraper.EglSurfaceBase;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tracking.skinRegionSdk.SkinRegionManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SkinRegionComputeThread
  implements Handler.Callback
{
  public static final int SKIN_THREAD_COMPUTE = 2;
  public static final int SKIN_THREAD_INIT = 1;
  public static final int SKIN_THREAD_RELEASE = 3;
  private static final String TAG = "SkinRegionComputeThread";
  private GPUBaseFilter baseFilter;
  private int computeCount = 0;
  private int computeInterval = 2;
  private boolean hasInitContext = false;
  private boolean hasInitSize = false;
  private int inputTexHeight;
  private int inputTexWidth;
  private int mComputeHeight;
  private boolean mComputeStart = false;
  private int mComputeWidth;
  private EglCore mEglCore;
  private EglSurfaceBase mEglSurfaceBase;
  private HandlerThread mGlThreadMsg;
  private Handler mHandler;
  private int mMaskHeight;
  private int mMaskWidth;
  private RenderBuffer mRenderBuffer;
  private int mSurfaceHeight;
  private int mSurfaceWidth;
  private Object mTextureLock;
  private byte[] maskData;
  private ByteBuffer pixelBuffer;
  
  public SkinRegionComputeThread()
  {
    SkinRegionManager.newInstance().init();
    createMsgThread();
  }
  
  private void createEglSurfceBase(int paramInt1, int paramInt2)
  {
    this.mEglSurfaceBase = new EglSurfaceBase(this.mEglCore);
    this.mEglSurfaceBase.createOffscreenSurface(paramInt1, paramInt2);
    this.mEglSurfaceBase.makeCurrent();
  }
  
  private void createMsgThread()
  {
    if (this.mGlThreadMsg == null)
    {
      this.mGlThreadMsg = new HandlerThread("skinCompute");
      this.mGlThreadMsg.start();
      this.mHandler = new Handler(this.mGlThreadMsg.getLooper(), this);
    }
  }
  
  private Handler getMsgHandler()
  {
    if (this.mGlThreadMsg != null)
    {
      Handler localHandler = this.mHandler;
      if (localHandler != null) {
        return localHandler;
      }
    }
    return null;
  }
  
  private void initGlContext(int paramInt1, int paramInt2, EGLContext paramEGLContext)
  {
    if ((this.hasInitContext) && (paramInt1 == this.mSurfaceWidth) && (paramInt2 == this.mSurfaceHeight)) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 17) {
      this.mEglCore = new EglCore(paramEGLContext, 1);
    }
    createEglSurfceBase(paramInt1, paramInt2);
  }
  
  private void releaseGLContext()
  {
    Object localObject = this.mRenderBuffer;
    if (localObject != null)
    {
      ((RenderBuffer)localObject).destroy();
      this.mRenderBuffer = null;
    }
    localObject = this.mEglSurfaceBase;
    if (localObject != null)
    {
      ((EglSurfaceBase)localObject).releaseEglSurface();
      this.mEglSurfaceBase = null;
    }
    localObject = this.mEglCore;
    if (localObject != null)
    {
      ((EglCore)localObject).release();
      this.mEglCore = null;
    }
    this.hasInitContext = false;
  }
  
  private void skinRegionComputeAsnyc(int paramInt, float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat.length != 4) {
      return;
    }
    this.mRenderBuffer.bind();
    synchronized (this.mTextureLock)
    {
      this.baseFilter.drawTexture(paramInt, null, null);
      this.pixelBuffer.position(0);
      GLES20.glReadPixels(0, 0, this.inputTexWidth, this.inputTexHeight, 6408, 5121, this.pixelBuffer);
      this.mRenderBuffer.unbind();
      this.pixelBuffer.position(0);
      ??? = this.pixelBuffer.array();
      byte[] arrayOfByte = new byte[this.mMaskWidth * this.mMaskHeight];
      SkinRegionManager.newInstance().skinRegionCompute((byte[])???, this.inputTexWidth, this.inputTexHeight, arrayOfByte, paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3]);
      try
      {
        if ((this.maskData != null) && (arrayOfByte.length == this.maskData.length)) {
          System.arraycopy(arrayOfByte, 0, this.maskData, 0, arrayOfByte.length);
        }
        this.mComputeStart = true;
        return;
      }
      finally {}
    }
  }
  
  public boolean copyMaskData(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = this.maskData;
    if ((arrayOfByte.length > 0) && (paramArrayOfByte.length == arrayOfByte.length) && (this.mComputeStart)) {
      try
      {
        System.arraycopy(this.maskData, 0, paramArrayOfByte, 0, this.maskData.length);
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return true;
        }
        releaseGLContext();
        releaseMsgThread();
        this.mComputeStart = false;
        this.hasInitContext = false;
        return true;
      }
      skinRegionComputeAsnyc(paramMessage.arg1, (float[])paramMessage.obj);
      return true;
    }
    initGlContext(paramMessage.arg1, paramMessage.arg2, (EGLContext)paramMessage.obj);
    this.hasInitContext = true;
    return true;
  }
  
  public void init(int paramInt1, int paramInt2, EGLContext paramEGLContext, Object paramObject)
  {
    this.mSurfaceWidth = paramInt1;
    this.mSurfaceHeight = paramInt2;
    this.hasInitSize = true;
    this.inputTexWidth = this.mComputeWidth;
    this.inputTexHeight = this.mComputeHeight;
    this.pixelBuffer = ByteBuffer.allocate(this.inputTexWidth * this.inputTexHeight * 4);
    this.pixelBuffer.order(ByteOrder.nativeOrder());
    this.pixelBuffer.position(0);
    this.mRenderBuffer = new RenderBuffer(false, this.inputTexWidth, this.inputTexHeight, 33984);
    this.baseFilter = new GPUBaseFilter();
    this.baseFilter.init();
    this.baseFilter.onOutputSizeChanged(this.inputTexWidth, this.inputTexHeight);
    this.mTextureLock = paramObject;
    paramObject = getMsgHandler();
    if (paramObject != null)
    {
      Message localMessage = Message.obtain(paramObject);
      localMessage.what = 1;
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      localMessage.obj = paramEGLContext;
      paramObject.sendMessage(localMessage);
    }
  }
  
  public void initRegionCompute(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this.mComputeWidth = paramInt1;
    this.mComputeHeight = paramInt2;
    this.mMaskWidth = paramInt3;
    this.mMaskHeight = paramInt4;
    SkinRegionManager.newInstance().skinRegionInit(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
    this.maskData = new byte[this.mMaskHeight * this.mMaskWidth];
  }
  
  public void onDestroy()
  {
    Handler localHandler = getMsgHandler();
    if (localHandler != null)
    {
      Message localMessage = Message.obtain(localHandler);
      localMessage.what = 3;
      localHandler.sendMessage(localMessage);
    }
  }
  
  public void releaseMsgThread()
  {
    if (this.mGlThreadMsg != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mGlThreadMsg.quit();
      this.mGlThreadMsg = null;
      this.mHandler = null;
    }
  }
  
  public void skinRegionCompute(int paramInt, float[] paramArrayOfFloat)
  {
    if (this.computeCount % this.computeInterval == 0)
    {
      this.computeCount = 0;
      Handler localHandler = getMsgHandler();
      if (localHandler != null)
      {
        Message localMessage = Message.obtain(localHandler);
        localMessage.what = 2;
        localMessage.arg1 = paramInt;
        localMessage.obj = paramArrayOfFloat;
        localHandler.sendMessage(localMessage);
      }
    }
    this.computeCount += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.SkinRegionComputeThread
 * JD-Core Version:    0.7.0.1
 */