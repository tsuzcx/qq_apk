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
  EglHandlerThread a;
  Handler b;
  HandlerThread c;
  Handler d;
  int e = -1;
  Bitmap f;
  int g;
  int h;
  boolean i = false;
  boolean j = false;
  boolean k = false;
  List<AIRect> l = new ArrayList();
  MiniCodeRecog m;
  Context n;
  int o;
  String p;
  String q;
  String r;
  String s;
  private CopyOnWriteArrayList<WeakReference<OnMiniCodeDetectCallback>> t;
  
  public MiniCodeDetector(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.n = paramContext;
    this.h = paramInt3;
    this.g = paramInt2;
    this.o = paramInt1;
    this.c = new HandlerThread("MINICODE_DETECT_THREAD");
    this.c.start();
    this.d = new Handler(this.c.getLooper(), this);
    this.a = new EglHandlerThread("MINICODE_EGLHANDLER_THREAD", null);
    this.a.start();
    paramContext = this.a.getLooper();
    if (paramContext != null) {
      this.b = new Handler(paramContext, this);
    } else {
      QLog.i("MiniRecog.detector", 1, "MiniCodeDetector init eglHandler exception: looper=null");
    }
    this.t = new CopyOnWriteArrayList();
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
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.detector", 2, "processInEGL start **********");
    }
    this.l.clear();
    if (!this.i)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.detector", 2, "processInEGL has not been initialized; Skipped.");
      }
      return false;
    }
    Object localObject1 = this.f;
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      localObject1 = this.f;
      if ((((Bitmap)localObject1).getWidth() == this.g) && (((Bitmap)localObject1).getHeight() == this.h))
      {
        i1 = this.e;
        if (i1 >= 0) {
          try
          {
            a(i1, (Bitmap)localObject1);
          }
          catch (Throwable localThrowable1)
          {
            localThrowable1.printStackTrace();
          }
        }
      }
      this.g = ((Bitmap)localObject1).getWidth();
      this.h = ((Bitmap)localObject1).getHeight();
      int i2 = this.e;
      int i1 = -1;
      if (i2 >= 0)
      {
        GlUtils.a(i2);
        this.e = -1;
      }
      try
      {
        i2 = GlUtils.a(3553, (Bitmap)localObject1);
        i1 = i2;
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
      }
      this.e = i1;
      ((Bitmap)localObject1).recycle();
      Object localObject2 = this.m;
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MiniRecog.detector", 2, "processInEGL MiniCodeRecog is null");
        }
        return false;
      }
      localObject1 = null;
      i1 = this.e;
      if (i1 >= 0)
      {
        localObject2 = ((MiniCodeRecog)localObject2).a(i1, this.g, this.h, paramLong, paramBoolean);
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i("MiniRecog.detector", 2, String.format("minicode_timecost processInEGL end consume=%d **********", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
          localObject1 = localObject2;
        }
      }
      if (localObject1 != null) {
        this.l.addAll((Collection)localObject1);
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.detector", 2, "processInEGL mInBmp invalid");
    }
    return false;
  }
  
  private int b()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.detector", 2, "destroyInEGL()");
    }
    this.i = false;
    int i1 = this.e;
    if (i1 >= 0)
    {
      GlUtils.a(i1);
      this.e = -1;
    }
    MiniCodeRecog localMiniCodeRecog = this.m;
    if (localMiniCodeRecog != null) {
      try
      {
        localMiniCodeRecog.b();
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("destroyInEGL exception:");
        localStringBuilder.append(localException.getLocalizedMessage());
        QLog.i("MiniRecog.detector", 1, localStringBuilder.toString(), localException);
      }
    }
    Handler localHandler = this.d;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(100);
    }
  }
  
  @TargetApi(18)
  private void d()
  {
    try
    {
      this.b.removeCallbacksAndMessages(null);
      this.a.quitSafely();
      this.a = null;
      this.b = null;
    }
    catch (Exception localException1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.detector", 2, localException1.getMessage(), localException1);
      }
    }
    try
    {
      this.d.removeCallbacksAndMessages(null);
      this.c.quitSafely();
      this.c = null;
      this.d = null;
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.detector", 2, localException2.getMessage(), localException2);
      }
    }
    this.j = false;
    this.f = null;
    this.l.clear();
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.detector", 2, "closeLater()");
    }
  }
  
  public void a()
  {
    if (this.k) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.detector", 2, "close()");
    }
    this.k = true;
    if (this.i)
    {
      Handler localHandler = this.b;
      if (localHandler != null) {
        localHandler.sendEmptyMessage(202);
      }
    }
    else
    {
      d();
    }
  }
  
  public void a(OnMiniCodeDetectCallback paramOnMiniCodeDetectCallback)
  {
    Iterator localIterator = this.t.iterator();
    while (localIterator.hasNext())
    {
      OnMiniCodeDetectCallback localOnMiniCodeDetectCallback = (OnMiniCodeDetectCallback)((WeakReference)localIterator.next()).get();
      if ((localOnMiniCodeDetectCallback != null) && (localOnMiniCodeDetectCallback == paramOnMiniCodeDetectCallback)) {
        return;
      }
    }
    this.t.add(new WeakReference(paramOnMiniCodeDetectCallback));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.detector", 2, "initEnv");
    }
    this.p = paramString1;
    this.q = paramString2;
    this.r = paramString3;
    this.s = paramString4;
    paramString1 = this.b;
    if (paramString1 != null) {
      paramString1.sendEmptyMessage(200);
    }
  }
  
  public boolean a(Bitmap paramBitmap, long paramLong)
  {
    try
    {
      if (!this.i)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("MiniRecog.detector", 2, "detector has not been initialized; Skipped.");
          return false;
        }
      }
      else
      {
        if (this.k)
        {
          if (!QLog.isColorLevel()) {
            break label203;
          }
          QLog.i("MiniRecog.detector", 2, "detector has been closed; Skipped.");
          return false;
        }
        if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
        {
          if (this.j)
          {
            if (!QLog.isColorLevel()) {
              break label205;
            }
            QLog.i("MiniRecog.detector", 2, "detect mIsProcessing is true");
            return false;
          }
          localObject = this.b;
          if (localObject == null)
          {
            if (!QLog.isColorLevel()) {
              break label207;
            }
            QLog.i("MiniRecog.detector", 2, "mEglHandler is null");
            return false;
          }
          this.j = true;
          this.f = paramBitmap;
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
    Iterator localIterator = this.t.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      OnMiniCodeDetectCallback localOnMiniCodeDetectCallback = (OnMiniCodeDetectCallback)localWeakReference.get();
      if ((localOnMiniCodeDetectCallback != null) && (localOnMiniCodeDetectCallback == paramOnMiniCodeDetectCallback)) {
        this.t.remove(localWeakReference);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    Object localObject;
    switch (i1)
    {
    default: 
      switch (i1)
      {
      default: 
        return false;
      case 202: 
        c();
        return false;
      case 201: 
        long l1 = ((Long)paramMessage.obj).longValue();
        boolean bool1 = MiniCodeUtil.b;
        boolean bool2 = a(l1, bool1);
        paramMessage = this.d;
        if (paramMessage != null)
        {
          paramMessage = paramMessage.obtainMessage(101, new Object[] { Boolean.valueOf(bool2), Long.valueOf(l1) });
          this.d.sendMessage(paramMessage);
        }
        paramMessage = this.d;
        if ((paramMessage != null) && (bool1))
        {
          paramMessage = paramMessage.obtainMessage(103, new Object[] { Long.valueOf(l1) });
          this.d.sendMessage(paramMessage);
          return false;
        }
        break;
      case 200: 
        i1 = b();
        paramMessage = this.d;
        if (paramMessage != null)
        {
          paramMessage.obtainMessage(102, i1, 0).sendToTarget();
          return false;
        }
        break;
      }
      break;
    case 103: 
      paramMessage = (Object[])paramMessage.obj;
      localObject = this.t.iterator();
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
          i1 = paramMessage.arg1;
          paramMessage = this.t.iterator();
          while (paramMessage.hasNext())
          {
            localObject = (OnMiniCodeDetectCallback)((WeakReference)paramMessage.next()).get();
            if (localObject != null)
            {
              ((OnMiniCodeDetectCallback)localObject).a(i1);
              continue;
              paramMessage = (Object[])paramMessage.obj;
              localObject = this.t.iterator();
              while (((Iterator)localObject).hasNext())
              {
                localOnMiniCodeDetectCallback = (OnMiniCodeDetectCallback)((WeakReference)((Iterator)localObject).next()).get();
                if (localOnMiniCodeDetectCallback != null) {
                  localOnMiniCodeDetectCallback.a(this.l, ((Long)paramMessage[1]).longValue());
                }
              }
              this.j = false;
              return false;
              d();
            }
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.minicode.MiniCodeDetector
 * JD-Core Version:    0.7.0.1
 */