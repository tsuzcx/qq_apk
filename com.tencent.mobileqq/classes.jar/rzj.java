import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.video.player.LitePlayer.1;
import com.tencent.biz.pubaccount.readinjoy.video.player.LitePlayer.2;
import com.tencent.biz.pubaccount.readinjoy.video.player.LitePlayer.3;
import com.tencent.biz.pubaccount.readinjoy.video.player.LitePlayer.4;
import com.tencent.biz.pubaccount.readinjoy.video.player.LitePlayer.5;
import com.tencent.biz.pubaccount.readinjoy.video.player.LitePlayer.6;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class rzj
  implements rwj
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 0;
  @NonNull
  protected Context a;
  @NonNull
  protected ViewGroup a;
  private final String jdField_a_of_type_JavaLangString = "LitePlayer<" + Integer.toHexString(hashCode()) + ">";
  private List<rzn> jdField_a_of_type_JavaUtilList;
  @NonNull
  public rwf a;
  private rwh jdField_a_of_type_Rwh;
  private rzk jdField_a_of_type_Rzk = new rzk(this);
  @Nullable
  private rzl jdField_a_of_type_Rzl;
  private rzm jdField_a_of_type_Rzm = new rzm(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<rzi> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 100;
  private boolean jdField_c_of_type_Boolean = true;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h = true;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  
  @UiThread
  public rzj(Context paramContext, String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.l = paramBoolean;
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Rwh = new rwh();
    this.jdField_a_of_type_Rwh.a(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Rwf = a();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    paramBoolean = this.jdField_a_of_type_Rwh.a();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "LitePlayer: isPluginInstalled=" + paramBoolean);
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_Rwh.a();
    }
  }
  
  @UiThread
  private rwf a()
  {
    rwf localrwf = new rwf(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_b_of_type_JavaLangString);
    localrwf.a(this.jdField_a_of_type_Rzk);
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    for (boolean bool = true;; bool = false)
    {
      localrwf.a((ViewGroup)localObject, bool, this.l);
      localObject = localrwf.a();
      if (localObject != null)
      {
        ((View)localObject).setId(2131376164);
        this.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
      }
      localrwf.a(this.k);
      localrwf.c(this.j);
      localrwf.e(this.h);
      localrwf.a(this.jdField_a_of_type_Float);
      localrwf.d(this.i);
      localrwf.b(this.jdField_a_of_type_Int);
      return localrwf;
    }
  }
  
  static void a(Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      return;
    }
    ThreadManager.getUIHandler().post(paramRunnable);
  }
  
  private void a(rzl paramrzl)
  {
    if (TextUtils.isEmpty(paramrzl.jdField_b_of_type_JavaLangString))
    {
      a(paramrzl.jdField_a_of_type_JavaLangString, paramrzl.jdField_a_of_type_Int, paramrzl.jdField_a_of_type_Long);
      return;
    }
    a(paramrzl.jdField_a_of_type_JavaLangString, paramrzl.jdField_b_of_type_JavaLangString, paramrzl.jdField_a_of_type_Int, paramrzl.jdField_a_of_type_Long, paramrzl.jdField_b_of_type_Int);
  }
  
  private void a(boolean paramBoolean1, String paramString1, String paramString2, String paramString3, boolean paramBoolean2, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "openByUrl: vid=" + paramString1 + ", url=" + paramString2 + ", playType=" + paramInt1 + ", startPosition=" + paramLong);
    }
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Rzk.a(null, 201, 109, 0, "player had destoryed", null);
    }
    do
    {
      return;
      if ((paramBoolean1) && (TextUtils.isEmpty(paramString2)))
      {
        this.jdField_a_of_type_Rzk.a(null, 201, 61, 0, "url null", null);
        return;
      }
      if ((!paramBoolean1) && (TextUtils.isEmpty(paramString1)))
      {
        this.jdField_a_of_type_Rzk.a(null, 201, 61, 0, "vid null", null);
        return;
      }
    } while (a(paramLong));
    this.jdField_a_of_type_Rzl = new rzl(this, paramString1, paramString2, paramInt1, paramLong, paramInt2);
    if (!this.jdField_a_of_type_Rwh.a())
    {
      this.jdField_a_of_type_Rwh.a();
      return;
    }
    n();
    b(paramString1, paramString2);
    if (paramBoolean1)
    {
      this.jdField_a_of_type_Rwf.a(paramString1, paramString2, paramInt1, paramLong, 0L, paramInt2, paramBoolean2, true, this.g, paramString3);
      return;
    }
    this.jdField_a_of_type_Rwf.a(paramString1, paramInt1, paramLong, this.g);
  }
  
  private boolean a(long paramLong)
  {
    if ((this.jdField_a_of_type_Rzl != null) && (this.g) && (this.jdField_a_of_type_Rwf.a() == this.jdField_a_of_type_Rzl))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: status=" + this.jdField_a_of_type_Rwf.b());
      }
      this.jdField_a_of_type_Rzl.jdField_a_of_type_Long = paramLong;
      Iterator localIterator;
      if ((f()) || (g()) || (i()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: hasPrePlay, just go onVideoPrepared");
        }
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((rzi)localIterator.next()).a(true);
        }
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((rzi)localIterator.next()).b(this.jdField_a_of_type_Rwf);
        }
        this.jdField_a_of_type_Rwf.k();
        o();
        return true;
      }
      if ((c()) || (d()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: prePlaying, just do nothing ");
        }
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((rzi)localIterator.next()).a(false);
        }
        this.g = false;
        this.jdField_a_of_type_Rwf.k();
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Rzm.sendEmptyMessageDelayed(1, 10000L);
        return true;
      }
      this.g = false;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: checkPreload player was preload but status error");
      }
    }
    return false;
  }
  
  private void b(String paramString1, String paramString2)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((rzi)localIterator.next()).a(paramString1, paramString2, this.g, this.k);
    }
    paramString1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString1.hasNext()) {
      ((rzn)paramString1.next()).onVideoOpen();
    }
    b(this.jdField_a_of_type_Rzl);
  }
  
  private void b(rwf paramrwf)
  {
    if (paramrwf == null) {}
    do
    {
      return;
      paramrwf.n();
    } while ((paramrwf.j()) || (paramrwf.i()));
    paramrwf.j();
    ThreadManager.excute(new LitePlayer.6(this, paramrwf), 16, null, true);
  }
  
  private void b(rzl paramrzl)
  {
    this.jdField_a_of_type_Rwf.a(paramrzl);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Rzm.removeMessages(1);
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPlayer: tag=" + this.jdField_a_of_type_Rwf.a());
    }
    if ((this.jdField_a_of_type_Rwf.a() != null) || (!this.jdField_a_of_type_Rwf.j()))
    {
      b(this.jdField_a_of_type_Rwf);
      this.jdField_a_of_type_Rwf.l();
      this.jdField_a_of_type_Rwf = a();
    }
  }
  
  private void o()
  {
    this.g = false;
    this.jdField_a_of_type_Rzm.removeMessages(1);
    if (this.jdField_c_of_type_Boolean)
    {
      c();
      if ((this.jdField_a_of_type_Rzl != null) && (this.jdField_a_of_type_Rzl.jdField_a_of_type_Long / 1000L != this.jdField_a_of_type_Rwf.a() / 1000L)) {
        b((int)(this.jdField_a_of_type_Rzl.jdField_a_of_type_Long / 1000L));
      }
      return;
    }
    this.d = true;
  }
  
  private void p()
  {
    Object localObject = this.jdField_a_of_type_Rwf;
    if (((rwf)localObject).f())
    {
      long l1 = ((rwf)localObject).a();
      if (l1 >= ((rwf)localObject).b() - 500L) {
        this.f = true;
      }
      for (;;)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((rzn)((Iterator)localObject).next()).onProgressChanged(l1);
        }
        if ((l1 >= 0L) && (this.f) && (((rwf)localObject).m()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onVideoReplayOnLoop: pos=" + l1);
          }
          this.f = false;
          this.jdField_b_of_type_Int += 1;
          ((rwf)localObject).m();
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            localObject = this.jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((rzn)((Iterator)localObject).next()).onVideoEnd(this.jdField_b_of_type_Int);
            }
          }
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Rwf.b();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Rwf.b();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Rwf.c();
  }
  
  public Map<String, String> a()
  {
    Map localMap = sas.a(this.jdField_a_of_type_Rwf);
    sas.a(localMap);
    return localMap;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "replay: " + this.jdField_a_of_type_Rzl);
    }
    b(this.jdField_a_of_type_Rwf);
    if (this.jdField_a_of_type_Rzl != null) {
      a(this.jdField_a_of_type_Rzl);
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Rwf.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Rwf.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.jdField_a_of_type_Rzk.a(null, paramInt1, paramInt2, paramInt3, paramString, null);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    g();
    if ((this.jdField_a_of_type_AndroidViewViewGroup.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    h();
    paramViewGroup.addView(this.jdField_a_of_type_AndroidViewViewGroup, -1, -1);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    a(new LitePlayer.1(this, paramString, paramInt, paramLong));
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    a("", paramString, null, true, paramInt1, paramLong, paramInt2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Rzm.removeMessages(0);
    this.jdField_a_of_type_Rzm.sendEmptyMessage(0);
    b(new rzl(this, paramString1, paramString2, 0, 0L, 0));
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2)
  {
    a(paramString1, paramString2, null, true, paramInt1, paramLong, paramInt2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    a(new LitePlayer.2(this, paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramLong, paramInt2));
  }
  
  public void a(rwf paramrwf)
  {
    if (paramrwf != null) {
      b(paramrwf);
    }
  }
  
  public void a(rzi paramrzi)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramrzi);
  }
  
  public void a(rzn paramrzn)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramrzn);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onInstallComplete: success=" + paramBoolean + ", mHasDestory=" + this.jdField_b_of_type_Boolean);
    }
    if (paramBoolean) {
      if (!this.jdField_b_of_type_Boolean) {}
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_Rwf = a();
      if (this.jdField_a_of_type_Rzl != null)
      {
        a(this.jdField_a_of_type_Rzl);
        return;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((rzn)localIterator.next()).onVideoError(123, 99, null);
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.g;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Rwf.c();
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Rwf.a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Rwf.a();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Rwf.a(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = true;
    this.k = paramBoolean;
    this.jdField_a_of_type_Rwf.a(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startPreload: coverFrame=" + paramBoolean);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Rzl != null) && ((d()) || (f()) || (g()) || (h()) || (i()));
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Rwf.d();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "start: status=" + a());
    }
    this.jdField_a_of_type_Rwf.d();
    this.jdField_a_of_type_Rzm.removeMessages(0);
    this.jdField_a_of_type_Rzm.sendEmptyMessage(0);
    rpt.a(new LitePlayer.3(this));
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((rzi)localIterator.next()).a(this.jdField_a_of_type_Rwf);
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.jdField_a_of_type_Rwf.e(paramBoolean);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Rwf.a();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "pause: status=" + a());
    }
    if ((h()) || (i()))
    {
      this.jdField_a_of_type_Rwf.f();
      rpt.a(new LitePlayer.4(this));
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.i = paramBoolean;
    this.jdField_a_of_type_Rwf.d(paramBoolean);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Rwf.b();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "restart: status=" + a());
    }
    if ((g()) || (f()))
    {
      this.jdField_a_of_type_Rwf.e();
      rpt.a(new LitePlayer.5(this));
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.j = paramBoolean;
    this.jdField_a_of_type_Rwf.c(paramBoolean);
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Rwf.c();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "stop: mPlayParam=" + this.jdField_a_of_type_Rzl);
    }
    if (this.jdField_a_of_type_Rzl != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((rzn)localIterator.next()).onVideoStop();
      }
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((rzi)localIterator.next()).a(this.jdField_a_of_type_Rwf, this.jdField_b_of_type_Int);
      }
    }
    b(this.jdField_a_of_type_Rwf);
    this.g = false;
    this.h = true;
    this.i = false;
    this.j = false;
    this.k = false;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Rzl = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(false);
    this.jdField_a_of_type_Rzm.removeMessages(0);
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Rwf.d();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Rwf.a();
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_Rwf.e();
  }
  
  public void h()
  {
    this.jdField_a_of_type_Rwf.b();
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_Rwf.f();
  }
  
  public void i()
  {
    this.jdField_a_of_type_Rwf.o();
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_Rwf.g();
  }
  
  public void j()
  {
    this.jdField_a_of_type_Rzk.a(this.jdField_a_of_type_Rwf, null);
  }
  
  public void k()
  {
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnPause() isPlaying()=" + h());
    }
    if ((h()) || (i()))
    {
      this.e = true;
      this.jdField_a_of_type_Boolean = false;
      d();
    }
  }
  
  public void l()
  {
    this.jdField_c_of_type_Boolean = true;
    if ((this.d) && (f())) {
      o();
    }
    label79:
    for (;;)
    {
      this.e = false;
      this.d = false;
      return;
      if (this.e)
      {
        AppRuntime localAppRuntime = ozs.a();
        if ((localAppRuntime instanceof QQAppInterface)) {}
        for (boolean bool = ((QQAppInterface)localAppRuntime).d();; bool = false)
        {
          if (bool) {
            break label79;
          }
          this.jdField_a_of_type_Boolean = true;
          e();
          break;
        }
      }
    }
  }
  
  public void m()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnDestory: ");
    }
    f();
    this.jdField_a_of_type_Rwf.l();
    if (this.jdField_a_of_type_Rwh != null) {
      this.jdField_a_of_type_Rwh.b();
    }
    this.jdField_a_of_type_Rzm.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rzj
 * JD-Core Version:    0.7.0.1
 */