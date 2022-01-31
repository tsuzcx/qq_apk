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
import axtq;
import axtu;
import axty;
import axtz;
import axua;
import axub;
import axuc;
import axud;
import axuv;
import axuw;
import axux;
import axuy;
import axuz;
import axvb;
import axve;
import com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder;
import com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;
import wxe;
import wxj;

@TargetApi(18)
public class NeoVideoFilterPlayView
  extends VideoFilterPlayView
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private axua jdField_a_of_type_Axua;
  private axub jdField_a_of_type_Axub;
  private axuy jdField_a_of_type_Axuy = new axux();
  private axuz jdField_a_of_type_Axuz;
  private axve jdField_a_of_type_Axve;
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
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramContext.getLooper(), new axuv(this));
    this.jdField_a_of_type_Axve = new axuw(this);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Axub = new axub();
      setEGLContextFactory(this.jdField_a_of_type_Axub);
      super.a();
      wxj.b("video_edit", "flow_view_create", 0, 0, new String[] { Build.MANUFACTURER, Build.MODEL, String.valueOf(Build.VERSION.SDK_INT) });
    }
    wxe.d("FlowEdit_NeoVideoFilterPlayView", "Model=%s, Manufacture=%s, SDK=%d", new Object[] { Build.MODEL, Build.MANUFACTURER, Integer.valueOf(Build.VERSION.SDK_INT) });
  }
  
  private void a(GL10 paramGL10)
  {
    Object localObject = (axvb)this.jdField_a_of_type_Axty;
    paramGL10 = ((axvb)localObject).b();
    axua localaxua = ((axvb)localObject).c();
    int n;
    int i;
    int i1;
    int m;
    if (paramGL10 != null)
    {
      if ((Math.abs(paramGL10.a()) > this.jdField_a_of_type_Axtu.b * 1000L) || (Math.abs(paramGL10.a()) < this.jdField_a_of_type_Axtu.jdField_a_of_type_Long)) {
        wxe.d("FlowEdit_NeoVideoFilterPlayView", "find invalid frame : %s us, current config start - end : [%d - %d] ms", new Object[] { paramGL10, Long.valueOf(this.jdField_a_of_type_Axtu.jdField_a_of_type_Long), Long.valueOf(this.jdField_a_of_type_Axtu.b) });
      }
      n = 0;
      if ((this.jdField_a_of_type_Axuz == null) || (paramGL10.b() != axuz.a(this.jdField_a_of_type_Axuz)))
      {
        n = 1;
        this.jdField_a_of_type_Axuy.a();
      }
      i = a();
      i1 = 0;
      if ((this.j == -1) || (this.j != i))
      {
        i1 = 1;
        this.jdField_a_of_type_Axuy.a(this.j, i);
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
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)) || (this.jdField_a_of_type_Axuz == null) || (n != 0) || (i1 != 0))
      {
        this.jdField_a_of_type_Axuz = new axuz(SystemClock.uptimeMillis(), paramGL10.a(), paramGL10.b(), null);
        wxe.c("FlowEdit_NeoVideoFilterPlayView", "start render : " + this.jdField_a_of_type_Axuz);
      }
      long l2 = SystemClock.uptimeMillis();
      long l3 = axuz.a(this.jdField_a_of_type_Axuz) + (paramGL10.a() - axuz.b(this.jdField_a_of_type_Axuz)) * m / (i * 1000);
      long l1;
      if ((localaxua != null) && (localaxua.b() == paramGL10.b()))
      {
        l1 = axuz.a(this.jdField_a_of_type_Axuz) + (localaxua.a() - axuz.b(this.jdField_a_of_type_Axuz)) * m / (i * 1000);
        label367:
        if (l2 >= l3 - 5L) {
          break label548;
        }
        paramGL10 = this.jdField_a_of_type_Axua;
        l1 = l3 - l2;
        label391:
        if (paramGL10 != null)
        {
          Trace.beginSection("AVEditor:DrawFrameOnScreen");
          localObject = axuc.a(this.b, this.c, this.b, this.c);
          a(paramGL10.a(), paramGL10.a, (float[])localObject);
          if ((this.jdField_a_of_type_Axua != null) && (this.jdField_a_of_type_Axua != paramGL10)) {
            this.jdField_a_of_type_Axua.b();
          }
          this.jdField_a_of_type_Axua = paramGL10;
          this.jdField_a_of_type_Axuy.a(paramGL10.a());
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
          localObject = ((axvb)localObject).a();
          l2 = l1 - l2;
          l1 = l2;
          paramGL10 = (GL10)localObject;
          if (this.k <= 0) {
            break label391;
          }
          wxe.a("FlowEdit_NeoVideoFilterPlayView", "drawFrameFlow : drop %d frames, decoder is slow", Integer.valueOf(this.k));
          this.k = 0;
          l1 = l2;
          paramGL10 = (GL10)localObject;
          break label391;
        }
        paramGL10 = ((axvb)localObject).a();
        if (localaxua != null)
        {
          if (paramGL10 != null) {
            paramGL10.b();
          }
          for (;;)
          {
            this.k += 1;
            break;
            wxe.d("FlowEdit_NeoVideoFilterPlayView", "drawFrameFlow : peekNextDecodedFrame != null, but pollNextDecodedFrame == null");
          }
        }
        l1 = 0L;
        break label391;
        wxe.b("FlowEdit_NeoVideoFilterPlayView", "drawFrameFlow : waiting ∞ ms ( no frame )");
        paramGL10 = null;
        l1 = -1L;
        break label391;
      }
      label687:
      i = 1;
      m = 1;
    }
  }
  
  public axty a()
  {
    this.jdField_a_of_type_Boolean = axtz.b;
    wxe.d("FlowEdit_NeoVideoFilterPlayView", "NeoVideoFilterPlayView ENABLE = %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (this.jdField_a_of_type_Boolean) {
      return new axvb();
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
      wxe.b("FlowEdit_NeoVideoFilterPlayView", "startPlay: ");
      if (TextUtils.isEmpty(this.jdField_a_of_type_Axtu.jdField_a_of_type_JavaLangString)) {
        throw new RuntimeException("startPlay failed. videoFilePath is empty.");
      }
      this.jdField_a_of_type_Axty.a();
      EGLContext localEGLContext = this.jdField_a_of_type_Axub.a();
      if (localEGLContext != null)
      {
        axud localaxud = new axud(this.jdField_a_of_type_Axtu);
        localaxud.b = true;
        localaxud.a = localEGLContext;
        localaxud.c = 1;
        this.jdField_a_of_type_Axuz = null;
        ((axvb)this.jdField_a_of_type_Axty).a(localaxud, this.jdField_a_of_type_Axve);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Axtq.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.a(this.jdField_a_of_type_Axtq);
        }
        return;
      }
      wxe.c("FlowEdit_NeoVideoFilterPlayView", "eglContext is null, ignore start play", new Throwable());
      return;
    }
    super.b();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      wxe.b("FlowEdit_NeoVideoFilterPlayView", "pausePlay: ");
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
  
  public void setPlayListener(axuy paramaxuy)
  {
    if (paramaxuy != null)
    {
      this.jdField_a_of_type_Axuy = paramaxuy;
      return;
    }
    this.jdField_a_of_type_Axuy = new axux();
  }
  
  public void setSpeedType(int paramInt)
  {
    int m = 0;
    int n = this.jdField_a_of_type_Axtu.jdField_a_of_type_Int;
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