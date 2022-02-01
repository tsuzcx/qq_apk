package com.tencent.mobileqq.minicode.recog;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import aojx;
import baff;
import com.tencent.mobileqq.minicode.GlUtil;
import com.tencent.mobileqq.minicode.RecogUtil;
import com.tencent.mobileqq.minicode.Utils;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MiniCodeDetector
  implements Handler.Callback
{
  public static final int EGL_DESTROY = 202;
  public static final int EGL_INIT = 200;
  public static final int EGL_PROCESS = 201;
  public static final int IN_HEIGHT = 256;
  public static final int IN_WIDTH = 256;
  public static final int RUNTYPE_CL = 0;
  public static final int RUNTYPE_GL = 1;
  public static final String TAG = "MiniRecog.detector";
  public static final int UI_CLOSE_LATER = 100;
  public static final int UI_ON_READY = 102;
  public static final int UI_ON_RESULT = 101;
  public static final int UI_ON_SAVEIMG = 103;
  String anchorPath;
  Context context;
  String kernalBinPath;
  List<aojx> mBoxes = new ArrayList();
  boolean mClosed = false;
  Handler mEglHandler;
  EglHandlerThread mEglHandlerThread;
  boolean mHasEGLInited = false;
  Bitmap mInBmp;
  int mInTextureId = -1;
  boolean mIsProcessing = false;
  MiniCodeRecog mRecog;
  private CopyOnWriteArrayList<WeakReference<RecogCallback>> mRecogCallbacks;
  int mSrcH;
  int mSrcW;
  Handler mSubHandler;
  HandlerThread mSubThread;
  String modelPath;
  String paramPath;
  int runType;
  
  public MiniCodeDetector(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.context = paramContext;
    this.mSrcH = paramInt3;
    this.mSrcW = paramInt2;
    this.runType = paramInt1;
    this.mSubThread = new HandlerThread("MINICODE_DETECT_THREAD");
    this.mSubThread.start();
    this.mSubHandler = new Handler(this.mSubThread.getLooper(), this);
    this.mEglHandlerThread = new EglHandlerThread("MINICODE_EGLHANDLER_THREAD", null);
    this.mEglHandlerThread.start();
    paramContext = this.mEglHandlerThread.getLooper();
    if (paramContext != null)
    {
      this.mEglHandler = new Handler(paramContext, this);
      this.mEglHandler.sendEmptyMessage(200);
    }
    for (;;)
    {
      this.mRecogCallbacks = new CopyOnWriteArrayList();
      return;
      QLog.i("MiniRecog.detector", 1, "MiniCodeDetector init eglHandler exception: looper=null");
    }
  }
  
  private static void bmp2Texture(int paramInt, Bitmap paramBitmap)
  {
    GLES20.glBindTexture(3553, paramInt);
    GlUtil.checkGlError("glBindTexture");
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GlUtil.checkGlError("glTexParameteri");
    GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    GlUtil.checkGlError("texImage2D");
  }
  
  @TargetApi(18)
  private void closeLater()
  {
    try
    {
      this.mEglHandler.removeCallbacksAndMessages(null);
      this.mEglHandlerThread.quitSafely();
      this.mEglHandlerThread = null;
      this.mEglHandler = null;
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.mSubHandler.removeCallbacksAndMessages(null);
          this.mSubThread.quitSafely();
          this.mSubThread = null;
          this.mSubHandler = null;
          this.mIsProcessing = false;
          this.mInBmp = null;
          this.mBoxes.clear();
          if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.detector", 2, "closeLater()");
          }
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.detector", 2, localException1.getMessage(), localException1);
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.detector", 2, localException2.getMessage(), localException2);
          }
        }
      }
    }
  }
  
  private void destroyInEGL()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.detector", 2, "destroyInEGL()");
    }
    this.mHasEGLInited = false;
    if (this.mInTextureId >= 0)
    {
      baff.b(this.mInTextureId);
      this.mInTextureId = -1;
    }
    if (this.mRecog != null) {}
    try
    {
      this.mRecog.finish();
      if (this.mSubHandler != null) {
        this.mSubHandler.sendEmptyMessage(100);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i("MiniRecog.detector", 1, "destroyInEGL exception:" + localException.getLocalizedMessage(), localException);
      }
    }
  }
  
  private int initInEGL()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.detector", 2, "initInEGL");
    }
    this.mHasEGLInited = true;
    MiniParam localMiniParam = new MiniParam();
    localMiniParam.runType = this.runType;
    localMiniParam.netHeight = 256;
    localMiniParam.netWidth = 256;
    localMiniParam.paramPath = this.paramPath;
    localMiniParam.anchorPath = this.anchorPath;
    localMiniParam.modelString = Utils.readModelFile(this.modelPath);
    localMiniParam.kernelBinaryIndex = this.kernalBinPath;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("runType").append("=").append(localMiniParam.runType).append("\n");
    localStringBuilder.append("netHeight").append("=").append(localMiniParam.netHeight).append("\n");
    localStringBuilder.append("netWidth").append("=").append(localMiniParam.netWidth).append("\n");
    localStringBuilder.append("paramPath").append("=").append(localMiniParam.paramPath).append("\n");
    localStringBuilder.append("anchorPath").append("=").append(localMiniParam.anchorPath).append("\n");
    localStringBuilder.append("kernelBinaryIndex").append("=").append(localMiniParam.kernelBinaryIndex).append("\n");
    localStringBuilder.append("modelString").append("=").append(localMiniParam.modelString).append("\n");
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.detector", 2, localStringBuilder.toString());
    }
    if ((this.mSrcW > 0) && (this.mSrcH > 0)) {
      this.mInTextureId = GlUtil.createTexture31(this.mSrcW, this.mSrcH);
    }
    this.mRecog = new MiniCodeRecog(localMiniParam);
    if (this.mRecog.isInitSuc()) {
      return 1;
    }
    return 0;
  }
  
  private boolean processInEGL(long paramLong, boolean paramBoolean)
  {
    int i = -1;
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.detector", 2, "processInEGL start **********");
    }
    this.mBoxes.clear();
    if (!this.mHasEGLInited)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.detector", 2, "processInEGL has not been initialized; Skipped.");
      }
      return false;
    }
    if ((this.mInBmp == null) || (this.mInBmp.isRecycled()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.detector", 2, "processInEGL mInBmp invalid");
      }
      return false;
    }
    Object localObject = this.mInBmp;
    if ((((Bitmap)localObject).getWidth() != this.mSrcW) || (((Bitmap)localObject).getHeight() != this.mSrcH) || (this.mInTextureId < 0))
    {
      this.mSrcW = ((Bitmap)localObject).getWidth();
      this.mSrcH = ((Bitmap)localObject).getHeight();
      if (this.mInTextureId >= 0)
      {
        baff.b(this.mInTextureId);
        this.mInTextureId = -1;
      }
      try
      {
        int j = baff.a(3553, (Bitmap)localObject);
        i = j;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          localThrowable1.printStackTrace();
        }
      }
      this.mInTextureId = i;
    }
    for (;;)
    {
      ((Bitmap)localObject).recycle();
      if (this.mRecog != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.detector", 2, "processInEGL MiniCodeRecog is null");
      }
      return false;
      try
      {
        bmp2Texture(this.mInTextureId, (Bitmap)localObject);
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
      }
    }
    localObject = null;
    if (this.mInTextureId >= 0)
    {
      List localList = this.mRecog.detect(this.mInTextureId, this.mSrcW, this.mSrcH, paramLong, paramBoolean);
      localObject = localList;
      if (QLog.isColorLevel())
      {
        QLog.i("MiniRecog.detector", 2, String.format("minicode_timecost processInEGL end consume=%d **********", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
        localObject = localList;
      }
    }
    if (localObject != null) {
      this.mBoxes.addAll((Collection)localObject);
    }
    return true;
  }
  
  public void addRecogCallback(RecogCallback paramRecogCallback)
  {
    Iterator localIterator = this.mRecogCallbacks.iterator();
    while (localIterator.hasNext())
    {
      RecogCallback localRecogCallback = (RecogCallback)((WeakReference)localIterator.next()).get();
      if ((localRecogCallback != null) && (localRecogCallback == paramRecogCallback)) {
        return;
      }
    }
    this.mRecogCallbacks.add(new WeakReference(paramRecogCallback));
  }
  
  public void close()
  {
    if (this.mClosed) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.detector", 2, "close()");
      }
      this.mClosed = true;
      if (!this.mHasEGLInited) {
        break;
      }
    } while (this.mEglHandler == null);
    this.mEglHandler.sendEmptyMessage(202);
    return;
    closeLater();
  }
  
  public boolean detect(Bitmap paramBitmap, long paramLong)
  {
    boolean bool = false;
    try
    {
      if (!this.mHasEGLInited)
      {
        if (!QLog.isColorLevel()) {
          break label192;
        }
        QLog.i("MiniRecog.detector", 2, "detector has not been initialized; Skipped.");
        return false;
      }
      if (this.mClosed)
      {
        if (!QLog.isColorLevel()) {
          break label192;
        }
        QLog.i("MiniRecog.detector", 2, "detector has been closed; Skipped.");
        return false;
      }
    }
    catch (Exception paramBitmap)
    {
      QLog.i("MiniRecog.detector", 1, "detect exception: " + paramBitmap.getMessage(), paramBitmap);
      return false;
    }
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      if (QLog.isColorLevel())
      {
        QLog.i("MiniRecog.detector", 2, "detect input bitmap invalid");
        return false;
      }
    }
    else if (this.mIsProcessing)
    {
      if (QLog.isColorLevel())
      {
        QLog.i("MiniRecog.detector", 2, "detect mIsProcessing is true");
        return false;
      }
    }
    else
    {
      Handler localHandler = this.mEglHandler;
      if (localHandler == null)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("MiniRecog.detector", 2, "mEglHandler is null");
          return false;
        }
      }
      else
      {
        this.mIsProcessing = true;
        this.mInBmp = paramBitmap;
        localHandler.obtainMessage(201, Long.valueOf(paramLong)).sendToTarget();
        bool = true;
      }
    }
    label192:
    return bool;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      int i = initInEGL();
      if (this.mSubHandler != null)
      {
        this.mSubHandler.obtainMessage(102, i, 0).sendToTarget();
        return false;
        long l = ((Long)paramMessage.obj).longValue();
        boolean bool1 = RecogUtil.SAVE_DETECT_IMAGE;
        boolean bool2 = processInEGL(l, bool1);
        if (this.mSubHandler != null)
        {
          paramMessage = this.mSubHandler.obtainMessage(101, new Object[] { Boolean.valueOf(bool2), Long.valueOf(l) });
          this.mSubHandler.sendMessage(paramMessage);
        }
        if ((this.mSubHandler != null) && (bool1))
        {
          paramMessage = this.mSubHandler.obtainMessage(103, new Object[] { Long.valueOf(l) });
          this.mSubHandler.sendMessage(paramMessage);
          return false;
          destroyInEGL();
          return false;
          closeLater();
          return false;
          paramMessage = (Object[])paramMessage.obj;
          Object localObject = this.mRecogCallbacks.iterator();
          RecogCallback localRecogCallback;
          while (((Iterator)localObject).hasNext())
          {
            localRecogCallback = (RecogCallback)((WeakReference)((Iterator)localObject).next()).get();
            if (localRecogCallback != null) {
              localRecogCallback.onDetectResult(this.mBoxes, ((Long)paramMessage[1]).longValue());
            }
          }
          this.mIsProcessing = false;
          return false;
          i = paramMessage.arg1;
          paramMessage = this.mRecogCallbacks.iterator();
          while (paramMessage.hasNext())
          {
            localObject = (RecogCallback)((WeakReference)paramMessage.next()).get();
            if (localObject != null) {
              ((RecogCallback)localObject).onDetectReady(i);
            }
          }
          paramMessage = (Object[])paramMessage.obj;
          localObject = this.mRecogCallbacks.iterator();
          while (((Iterator)localObject).hasNext())
          {
            localRecogCallback = (RecogCallback)((WeakReference)((Iterator)localObject).next()).get();
            if (localRecogCallback != null) {
              localRecogCallback.onSaveImg(((Long)paramMessage[0]).longValue());
            }
          }
        }
      }
    }
  }
  
  public void initEnv(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.paramPath = paramString1;
    this.modelPath = paramString2;
    this.anchorPath = paramString3;
    this.kernalBinPath = paramString4;
  }
  
  public void removeRecogCallback(RecogCallback paramRecogCallback)
  {
    Iterator localIterator = this.mRecogCallbacks.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      RecogCallback localRecogCallback = (RecogCallback)localWeakReference.get();
      if ((localRecogCallback != null) && (localRecogCallback == paramRecogCallback)) {
        this.mRecogCallbacks.remove(localWeakReference);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minicode.recog.MiniCodeDetector
 * JD-Core Version:    0.7.0.1
 */