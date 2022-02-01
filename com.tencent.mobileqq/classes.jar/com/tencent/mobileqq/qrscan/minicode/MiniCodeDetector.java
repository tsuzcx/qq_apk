package com.tencent.mobileqq.qrscan.minicode;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.qrscan.AIRect;
import com.tencent.mobileqq.qrscan.OnMiniCodeDetectCallback;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglHandlerThread;
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
  int jdField_a_of_type_Int = -1;
  Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Handler jdField_a_of_type_AndroidOsHandler;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  MiniCodeRecog jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeRecog;
  EglHandlerThread jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread;
  String jdField_a_of_type_JavaLangString;
  List<AIRect> jdField_a_of_type_JavaUtilList = new ArrayList();
  private CopyOnWriteArrayList<WeakReference<OnMiniCodeDetectCallback>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  Handler jdField_b_of_type_AndroidOsHandler;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  
  public MiniCodeDetector(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("MINICODE_DETECT_THREAD");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_b_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread = new EglHandlerThread("MINICODE_EGLHANDLER_THREAD", null);
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread.start();
    paramContext = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread.getLooper();
    if (paramContext != null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(paramContext, this);
    } else {
      QLog.i("MiniRecog.detector", 1, "MiniCodeDetector init eglHandler exception: looper=null");
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  private int a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private static void a(int paramInt, Bitmap paramBitmap)
  {
    GLES20.glBindTexture(3553, paramInt);
    GlUtil.a("glBindTexture");
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GlUtil.a("glTexParameteri");
    GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    GlUtil.a("texImage2D");
  }
  
  private boolean a(long paramLong, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.detector", 2, "processInEGL start **********");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.detector", 2, "processInEGL has not been initialized; Skipped.");
      }
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if ((((Bitmap)localObject1).getWidth() == this.jdField_b_of_type_Int) && (((Bitmap)localObject1).getHeight() == this.jdField_c_of_type_Int))
      {
        i = this.jdField_a_of_type_Int;
        if (i >= 0) {
          try
          {
            a(i, (Bitmap)localObject1);
          }
          catch (Throwable localThrowable1)
          {
            localThrowable1.printStackTrace();
          }
        }
      }
      this.jdField_b_of_type_Int = ((Bitmap)localObject1).getWidth();
      this.jdField_c_of_type_Int = ((Bitmap)localObject1).getHeight();
      int j = this.jdField_a_of_type_Int;
      int i = -1;
      if (j >= 0)
      {
        GlUtils.a(j);
        this.jdField_a_of_type_Int = -1;
      }
      try
      {
        j = GlUtils.a(3553, (Bitmap)localObject1);
        i = j;
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
      }
      this.jdField_a_of_type_Int = i;
      ((Bitmap)localObject1).recycle();
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeRecog;
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MiniRecog.detector", 2, "processInEGL MiniCodeRecog is null");
        }
        return false;
      }
      localObject1 = null;
      i = this.jdField_a_of_type_Int;
      if (i >= 0)
      {
        localObject2 = ((MiniCodeRecog)localObject2).a(i, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, paramLong, paramBoolean);
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i("MiniRecog.detector", 2, String.format("minicode_timecost processInEGL end consume=%d **********", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
          localObject1 = localObject2;
        }
      }
      if (localObject1 != null) {
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.detector", 2, "processInEGL mInBmp invalid");
    }
    return false;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.detector", 2, "destroyInEGL()");
    }
    this.jdField_a_of_type_Boolean = false;
    int i = this.jdField_a_of_type_Int;
    if (i >= 0)
    {
      GlUtils.a(i);
      this.jdField_a_of_type_Int = -1;
    }
    MiniCodeRecog localMiniCodeRecog = this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeRecog;
    if (localMiniCodeRecog != null) {
      try
      {
        localMiniCodeRecog.a();
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("destroyInEGL exception:");
        localStringBuilder.append(localException.getLocalizedMessage());
        QLog.i("MiniRecog.detector", 1, localStringBuilder.toString(), localException);
      }
    }
    Handler localHandler = this.jdField_b_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(100);
    }
  }
  
  @TargetApi(18)
  private void c()
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread.quitSafely();
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread = null;
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    catch (Exception localException1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.detector", 2, localException1.getMessage(), localException1);
      }
    }
    try
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      this.jdField_b_of_type_AndroidOsHandler = null;
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.detector", 2, localException2.getMessage(), localException2);
      }
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_JavaUtilList.clear();
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.detector", 2, "closeLater()");
    }
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.detector", 2, "close()");
    }
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Boolean)
    {
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null) {
        localHandler.sendEmptyMessage(202);
      }
    }
    else
    {
      c();
    }
  }
  
  public void a(OnMiniCodeDetectCallback paramOnMiniCodeDetectCallback)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      OnMiniCodeDetectCallback localOnMiniCodeDetectCallback = (OnMiniCodeDetectCallback)((WeakReference)localIterator.next()).get();
      if ((localOnMiniCodeDetectCallback != null) && (localOnMiniCodeDetectCallback == paramOnMiniCodeDetectCallback)) {
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(paramOnMiniCodeDetectCallback));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.detector", 2, "initEnv");
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_d_of_type_JavaLangString = paramString4;
    paramString1 = this.jdField_a_of_type_AndroidOsHandler;
    if (paramString1 != null) {
      paramString1.sendEmptyMessage(200);
    }
  }
  
  public boolean a(Bitmap paramBitmap, long paramLong)
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("MiniRecog.detector", 2, "detector has not been initialized; Skipped.");
          return false;
        }
      }
      else
      {
        if (this.jdField_c_of_type_Boolean)
        {
          if (!QLog.isColorLevel()) {
            break label203;
          }
          QLog.i("MiniRecog.detector", 2, "detector has been closed; Skipped.");
          return false;
        }
        if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
        {
          if (this.jdField_b_of_type_Boolean)
          {
            if (!QLog.isColorLevel()) {
              break label205;
            }
            QLog.i("MiniRecog.detector", 2, "detect mIsProcessing is true");
            return false;
          }
          localObject = this.jdField_a_of_type_AndroidOsHandler;
          if (localObject == null)
          {
            if (!QLog.isColorLevel()) {
              break label207;
            }
            QLog.i("MiniRecog.detector", 2, "mEglHandler is null");
            return false;
          }
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
          ((Handler)localObject).obtainMessage(201, Long.valueOf(paramLong)).sendToTarget();
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.i("MiniRecog.detector", 2, "detect input bitmap invalid");
        }
        return false;
      }
    }
    catch (Exception paramBitmap)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("detect exception: ");
      ((StringBuilder)localObject).append(paramBitmap.getMessage());
      QLog.i("MiniRecog.detector", 1, ((StringBuilder)localObject).toString(), paramBitmap);
      return false;
    }
    return false;
    label203:
    return false;
    label205:
    return false;
    label207:
    return false;
  }
  
  public void b(OnMiniCodeDetectCallback paramOnMiniCodeDetectCallback)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      OnMiniCodeDetectCallback localOnMiniCodeDetectCallback = (OnMiniCodeDetectCallback)localWeakReference.get();
      if ((localOnMiniCodeDetectCallback != null) && (localOnMiniCodeDetectCallback == paramOnMiniCodeDetectCallback)) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localWeakReference);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject;
    switch (i)
    {
    default: 
      switch (i)
      {
      default: 
        return false;
      case 202: 
        b();
        return false;
      case 201: 
        long l = ((Long)paramMessage.obj).longValue();
        boolean bool1 = MiniCodeUtil.jdField_b_of_type_Boolean;
        boolean bool2 = a(l, bool1);
        paramMessage = this.jdField_b_of_type_AndroidOsHandler;
        if (paramMessage != null)
        {
          paramMessage = paramMessage.obtainMessage(101, new Object[] { Boolean.valueOf(bool2), Long.valueOf(l) });
          this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramMessage);
        }
        paramMessage = this.jdField_b_of_type_AndroidOsHandler;
        if ((paramMessage != null) && (bool1))
        {
          paramMessage = paramMessage.obtainMessage(103, new Object[] { Long.valueOf(l) });
          this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramMessage);
          return false;
        }
        break;
      case 200: 
        i = a();
        paramMessage = this.jdField_b_of_type_AndroidOsHandler;
        if (paramMessage != null)
        {
          paramMessage.obtainMessage(102, i, 0).sendToTarget();
          return false;
        }
        break;
      }
      break;
    case 103: 
      paramMessage = (Object[])paramMessage.obj;
      localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    case 102: 
    case 101: 
    case 100: 
      while (((Iterator)localObject).hasNext())
      {
        OnMiniCodeDetectCallback localOnMiniCodeDetectCallback = (OnMiniCodeDetectCallback)((WeakReference)((Iterator)localObject).next()).get();
        if (localOnMiniCodeDetectCallback != null)
        {
          localOnMiniCodeDetectCallback.a(((Long)paramMessage[0]).longValue());
          continue;
          i = paramMessage.arg1;
          paramMessage = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (paramMessage.hasNext())
          {
            localObject = (OnMiniCodeDetectCallback)((WeakReference)paramMessage.next()).get();
            if (localObject != null)
            {
              ((OnMiniCodeDetectCallback)localObject).a(i);
              continue;
              paramMessage = (Object[])paramMessage.obj;
              localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
              while (((Iterator)localObject).hasNext())
              {
                localOnMiniCodeDetectCallback = (OnMiniCodeDetectCallback)((WeakReference)((Iterator)localObject).next()).get();
                if (localOnMiniCodeDetectCallback != null) {
                  localOnMiniCodeDetectCallback.a(this.jdField_a_of_type_JavaUtilList, ((Long)paramMessage[1]).longValue());
                }
              }
              this.jdField_b_of_type_Boolean = false;
              return false;
              c();
            }
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.minicode.MiniCodeDetector
 * JD-Core Version:    0.7.0.1
 */