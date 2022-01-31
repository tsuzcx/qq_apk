package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.os.Trace;
import android.text.TextUtils;
import android.util.AttributeSet;
import axph;
import axpl;
import axpp;
import axpq;
import axpr;
import axps;
import axpt;
import axpu;
import axqm;
import axqn;
import axqo;
import axqp;
import axqq;
import axqs;
import axqv;
import com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder;
import com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;
import wsv;
import wta;

@TargetApi(18)
public class NeoVideoFilterPlayView
  extends VideoFilterPlayView
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private axpr jdField_a_of_type_Axpr;
  private axps jdField_a_of_type_Axps;
  private axqp jdField_a_of_type_Axqp = new axqo();
  private axqq jdField_a_of_type_Axqq;
  private axqv jdField_a_of_type_Axqv;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  private boolean d;
  private int j = -1;
  private int k;
  
  public NeoVideoFilterPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NeoVideoFilterPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new HandlerThread("NeoVideoFilterPlayView");
    paramContext.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramContext.getLooper(), new axqm(this));
    this.jdField_a_of_type_Axqv = new axqn(this);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Axps = new axps();
      setEGLContextFactory(this.jdField_a_of_type_Axps);
      super.a();
      wta.b("video_edit", "flow_view_create", 0, 0, new String[] { Build.MANUFACTURER, Build.MODEL, String.valueOf(Build.VERSION.SDK_INT) });
    }
    wsv.d("FlowEdit_NeoVideoFilterPlayView", "Model=%s, Manufacture=%s, SDK=%d", new Object[] { Build.MODEL, Build.MANUFACTURER, Integer.valueOf(Build.VERSION.SDK_INT) });
  }
  
  private void a(GL10 paramGL10)
  {
    Object localObject = (axqs)this.jdField_a_of_type_Axpp;
    paramGL10 = ((axqs)localObject).b();
    axpr localaxpr = ((axqs)localObject).c();
    int n;
    int i;
    int i1;
    int m;
    if (paramGL10 != null)
    {
      if ((Math.abs(paramGL10.a()) > this.jdField_a_of_type_Axpl.b * 1000L) || (Math.abs(paramGL10.a()) < this.jdField_a_of_type_Axpl.jdField_a_of_type_Long)) {
        wsv.d("FlowEdit_NeoVideoFilterPlayView", "find invalid frame : %s us, current config start - end : [%d - %d] ms", new Object[] { paramGL10, Long.valueOf(this.jdField_a_of_type_Axpl.jdField_a_of_type_Long), Long.valueOf(this.jdField_a_of_type_Axpl.b) });
      }
      n = 0;
      if ((this.jdField_a_of_type_Axqq == null) || (paramGL10.b() != axqq.a(this.jdField_a_of_type_Axqq)))
      {
        n = 1;
        this.jdField_a_of_type_Axqp.a();
      }
      i = a();
      i1 = 0;
      if ((this.j == -1) || (this.j != i))
      {
        i1 = 1;
        this.jdField_a_of_type_Axqp.a(this.j, i);
      }
      this.j = i;
      if (a() == 1)
      {
        i = 2;
        m = 1;
      }
    }
    for (;;)
    {
      label201:
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)) || (this.jdField_a_of_type_Axqq == null) || (n != 0) || (i1 != 0))
      {
        this.jdField_a_of_type_Axqq = new axqq(SystemClock.uptimeMillis(), paramGL10.a(), paramGL10.b(), null);
        wsv.c("FlowEdit_NeoVideoFilterPlayView", "start render : " + this.jdField_a_of_type_Axqq);
      }
      long l2 = SystemClock.uptimeMillis();
      long l3 = axqq.a(this.jdField_a_of_type_Axqq) + (paramGL10.a() - axqq.b(this.jdField_a_of_type_Axqq)) * m / (i * 1000);
      long l1;
      if ((localaxpr != null) && (localaxpr.b() == paramGL10.b()))
      {
        l1 = axqq.a(this.jdField_a_of_type_Axqq) + (localaxpr.a() - axqq.b(this.jdField_a_of_type_Axqq)) * m / (i * 1000);
        label367:
        if (l2 >= l3 - 5L) {
          break label548;
        }
        paramGL10 = this.jdField_a_of_type_Axpr;
        l1 = l3 - l2;
        label391:
        if (paramGL10 != null)
        {
          Trace.beginSection("AVEditor:DrawFrameOnScreen");
          localObject = axpt.a(this.b, this.c, this.b, this.c);
          a(paramGL10.a(), paramGL10.a, (float[])localObject);
          if ((this.jdField_a_of_type_Axpr != null) && (this.jdField_a_of_type_Axpr != paramGL10)) {
            this.jdField_a_of_type_Axpr.b();
          }
          this.jdField_a_of_type_Axpr = paramGL10;
          this.jdField_a_of_type_Axqp.a(paramGL10.a());
          Trace.endSection();
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        if (l1 >= 0L) {
          if (l1 <= 5L) {
            break label681;
          }
        }
      }
      label548:
      label681:
      for (l1 -= 5L;; l1 = 0L)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, l1);
        return;
        if (a() != 2) {
          break label687;
        }
        i = 1;
        m = 2;
        break label201;
        l1 = 30L + l3;
        break label367;
        if (l2 < l1)
        {
          localObject = ((axqs)localObject).a();
          l2 = l1 - l2;
          l1 = l2;
          paramGL10 = (GL10)localObject;
          if (this.k <= 0) {
            break label391;
          }
          wsv.a("FlowEdit_NeoVideoFilterPlayView", "drawFrameFlow : drop %d frames, decoder is slow", Integer.valueOf(this.k));
          this.k = 0;
          l1 = l2;
          paramGL10 = (GL10)localObject;
          break label391;
        }
        paramGL10 = ((axqs)localObject).a();
        if (localaxpr != null)
        {
          if (paramGL10 != null) {
            paramGL10.b();
          }
          for (;;)
          {
            this.k += 1;
            break;
            wsv.d("FlowEdit_NeoVideoFilterPlayView", "drawFrameFlow : peekNextDecodedFrame != null, but pollNextDecodedFrame == null");
          }
        }
        l1 = 0L;
        break label391;
        wsv.b("FlowEdit_NeoVideoFilterPlayView", "drawFrameFlow : waiting ∞ ms ( no frame )");
        paramGL10 = null;
        l1 = -1L;
        break label391;
      }
      label687:
      i = 1;
      m = 1;
    }
  }
  
  public axpp a()
  {
    this.jdField_a_of_type_Boolean = axpq.b;
    wsv.d("FlowEdit_NeoVideoFilterPlayView", "NeoVideoFilterPlayView ENABLE = %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (this.jdField_a_of_type_Boolean) {
      return new axqs();
    }
    return super.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    super.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      wsv.b("FlowEdit_NeoVideoFilterPlayView", "startPlay: ");
      if (TextUtils.isEmpty(this.jdField_a_of_type_Axpl.jdField_a_of_type_JavaLangString)) {
        throw new RuntimeException("startPlay failed. videoFilePath is empty.");
      }
      this.jdField_a_of_type_Axpp.a();
      EGLContext localEGLContext = this.jdField_a_of_type_Axps.a();
      if (localEGLContext != null)
      {
        axpu localaxpu = new axpu(this.jdField_a_of_type_Axpl);
        localaxpu.b = true;
        localaxpu.a = localEGLContext;
        localaxpu.c = 1;
        this.jdField_a_of_type_Axqq = null;
        ((axqs)this.jdField_a_of_type_Axpp).a(localaxpu, this.jdField_a_of_type_Axqv);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Axph.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.a(this.jdField_a_of_type_Axph);
        }
        return;
      }
      wsv.c("FlowEdit_NeoVideoFilterPlayView", "eglContext is null, ignore start play", new Throwable());
      return;
    }
    super.b();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      wsv.b("FlowEdit_NeoVideoFilterPlayView", "pausePlay: ");
      this.d = true;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.c();
      return;
    }
    super.c();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.d = false;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.d();
      return;
    }
    super.d();
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      a(this.jdField_a_of_type_JavaUtilLinkedList);
      a(paramGL10);
      return;
    }
    super.onDrawFrame(paramGL10);
  }
  
  public void setPlayListener(axqp paramaxqp)
  {
    if (paramaxqp != null)
    {
      this.jdField_a_of_type_Axqp = paramaxqp;
      return;
    }
    this.jdField_a_of_type_Axqp = new axqo();
  }
  
  public void setSpeedType(int paramInt)
  {
    int m = 0;
    int n = this.jdField_a_of_type_Axpl.jdField_a_of_type_Int;
    super.setSpeedType(paramInt);
    if ((n == 3) && (paramInt != 3)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        i = m;
        if (n != 3)
        {
          i = m;
          if (paramInt != 3) {}
        }
      }
      else
      {
        i = 1;
      }
      if (i != 0) {
        e();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.NeoVideoFilterPlayView
 * JD-Core Version:    0.7.0.1
 */