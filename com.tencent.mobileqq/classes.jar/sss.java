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

public class sss
  implements spr
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 0;
  @NonNull
  protected Context a;
  @NonNull
  protected ViewGroup a;
  private final String jdField_a_of_type_JavaLangString = "LitePlayer<" + Integer.toHexString(hashCode()) + ">";
  private List<ssw> jdField_a_of_type_JavaUtilList;
  @NonNull
  public spn a;
  private spp jdField_a_of_type_Spp;
  private sst jdField_a_of_type_Sst = new sst(this);
  @Nullable
  private ssu jdField_a_of_type_Ssu;
  private ssv jdField_a_of_type_Ssv = new ssv(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<ssr> jdField_b_of_type_JavaUtilList;
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
  public sss(Context paramContext, String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.l = paramBoolean;
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Spp = new spp();
    this.jdField_a_of_type_Spp.a(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Spn = a();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    paramBoolean = this.jdField_a_of_type_Spp.a();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "LitePlayer: isPluginInstalled=" + paramBoolean);
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_Spp.a();
    }
  }
  
  @UiThread
  private spn a()
  {
    spn localspn = new spn(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_b_of_type_JavaLangString);
    localspn.a(this.jdField_a_of_type_Sst);
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    for (boolean bool = true;; bool = false)
    {
      localspn.a((ViewGroup)localObject, bool, this.l);
      localObject = localspn.a();
      if (localObject != null)
      {
        ((View)localObject).setId(2131376175);
        this.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
      }
      localspn.a(this.k);
      localspn.c(this.j);
      localspn.e(this.h);
      localspn.a(this.jdField_a_of_type_Float);
      localspn.d(this.i);
      localspn.b(this.jdField_a_of_type_Int);
      return localspn;
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
  
  private void a(ssu paramssu)
  {
    if (TextUtils.isEmpty(paramssu.jdField_b_of_type_JavaLangString))
    {
      a(paramssu.jdField_a_of_type_JavaLangString, paramssu.jdField_a_of_type_Int, paramssu.jdField_a_of_type_Long);
      return;
    }
    a(paramssu.jdField_a_of_type_JavaLangString, paramssu.jdField_b_of_type_JavaLangString, paramssu.jdField_a_of_type_Int, paramssu.jdField_a_of_type_Long, paramssu.jdField_b_of_type_Int);
  }
  
  private void a(boolean paramBoolean1, String paramString1, String paramString2, String paramString3, boolean paramBoolean2, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "openByUrl: vid=" + paramString1 + ", url=" + paramString2 + ", playType=" + paramInt1 + ", startPosition=" + paramLong);
    }
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Sst.a(null, 201, 109, 0, "player had destoryed", null);
    }
    do
    {
      return;
      if ((paramBoolean1) && (TextUtils.isEmpty(paramString2)))
      {
        this.jdField_a_of_type_Sst.a(null, 201, 61, 0, "url null", null);
        return;
      }
      if ((!paramBoolean1) && (TextUtils.isEmpty(paramString1)))
      {
        this.jdField_a_of_type_Sst.a(null, 201, 61, 0, "vid null", null);
        return;
      }
    } while (a(paramLong));
    this.jdField_a_of_type_Ssu = new ssu(this, paramString1, paramString2, paramInt1, paramLong, paramInt2);
    if (!this.jdField_a_of_type_Spp.a())
    {
      this.jdField_a_of_type_Spp.a();
      return;
    }
    n();
    b(paramString1, paramString2);
    if (paramBoolean1)
    {
      this.jdField_a_of_type_Spn.a(paramString1, paramString2, paramInt1, paramLong, 0L, paramInt2, paramBoolean2, true, this.g, paramString3);
      return;
    }
    this.jdField_a_of_type_Spn.a(paramString1, paramInt1, paramLong, this.g);
  }
  
  private boolean a(long paramLong)
  {
    if ((this.jdField_a_of_type_Ssu != null) && (this.g) && (this.jdField_a_of_type_Spn.a() == this.jdField_a_of_type_Ssu))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: status=" + this.jdField_a_of_type_Spn.b());
      }
      this.jdField_a_of_type_Ssu.jdField_a_of_type_Long = paramLong;
      Iterator localIterator;
      if ((f()) || (g()) || (i()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: hasPrePlay, just go onVideoPrepared");
        }
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((ssr)localIterator.next()).a(true);
        }
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((ssr)localIterator.next()).b(this.jdField_a_of_type_Spn);
        }
        this.jdField_a_of_type_Spn.k();
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
          ((ssr)localIterator.next()).a(false);
        }
        this.g = false;
        this.jdField_a_of_type_Spn.k();
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Ssv.sendEmptyMessageDelayed(1, 10000L);
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
      ((ssr)localIterator.next()).a(paramString1, paramString2, this.g, this.k);
    }
    paramString1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString1.hasNext()) {
      ((ssw)paramString1.next()).onVideoOpen();
    }
    b(this.jdField_a_of_type_Ssu);
  }
  
  private void b(spn paramspn)
  {
    if (paramspn == null) {}
    do
    {
      return;
      paramspn.n();
    } while ((paramspn.j()) || (paramspn.i()));
    paramspn.j();
    ThreadManager.excute(new LitePlayer.6(this, paramspn), 16, null, true);
  }
  
  private void b(ssu paramssu)
  {
    this.jdField_a_of_type_Spn.a(paramssu);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Ssv.removeMessages(1);
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPlayer: tag=" + this.jdField_a_of_type_Spn.a());
    }
    if ((this.jdField_a_of_type_Spn.a() != null) || (!this.jdField_a_of_type_Spn.j()))
    {
      b(this.jdField_a_of_type_Spn);
      this.jdField_a_of_type_Spn.l();
      this.jdField_a_of_type_Spn = a();
    }
  }
  
  private void o()
  {
    this.g = false;
    this.jdField_a_of_type_Ssv.removeMessages(1);
    if (this.jdField_c_of_type_Boolean)
    {
      c();
      if ((this.jdField_a_of_type_Ssu != null) && (this.jdField_a_of_type_Ssu.jdField_a_of_type_Long / 1000L != this.jdField_a_of_type_Spn.a() / 1000L)) {
        b((int)(this.jdField_a_of_type_Ssu.jdField_a_of_type_Long / 1000L));
      }
      return;
    }
    this.d = true;
  }
  
  private void p()
  {
    Object localObject = this.jdField_a_of_type_Spn;
    if (((spn)localObject).f())
    {
      long l1 = ((spn)localObject).a();
      if (l1 >= ((spn)localObject).b() - 500L) {
        this.f = true;
      }
      while (this.jdField_a_of_type_JavaUtilList != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ssw)((Iterator)localObject).next()).onProgressChanged(l1);
        }
        if ((l1 >= 0L) && (this.f) && (((spn)localObject).m()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onVideoReplayOnLoop: pos=" + l1);
          }
          this.f = false;
          this.jdField_b_of_type_Int += 1;
          ((spn)localObject).m();
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            localObject = this.jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((ssw)((Iterator)localObject).next()).onVideoEnd(this.jdField_b_of_type_Int);
            }
          }
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Spn.b();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Spn.b();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Spn.c();
  }
  
  public Map<String, String> a()
  {
    Map localMap = sug.a(this.jdField_a_of_type_Spn);
    sug.a(localMap);
    return localMap;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "replay: " + this.jdField_a_of_type_Ssu);
    }
    b(this.jdField_a_of_type_Spn);
    if (this.jdField_a_of_type_Ssu != null) {
      a(this.jdField_a_of_type_Ssu);
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Spn.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Spn.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.jdField_a_of_type_Sst.a(null, paramInt1, paramInt2, paramInt3, paramString, null);
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
    this.jdField_a_of_type_Ssv.removeMessages(0);
    this.jdField_a_of_type_Ssv.sendEmptyMessage(0);
    b(new ssu(this, paramString1, paramString2, 0, 0L, 0));
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2)
  {
    a(paramString1, paramString2, null, true, paramInt1, paramLong, paramInt2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    a(new LitePlayer.2(this, paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramLong, paramInt2));
  }
  
  public void a(spn paramspn)
  {
    if (paramspn != null) {
      b(paramspn);
    }
  }
  
  public void a(ssr paramssr)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramssr);
  }
  
  public void a(ssw paramssw)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramssw);
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
      this.jdField_a_of_type_Spn = a();
      if (this.jdField_a_of_type_Ssu != null)
      {
        a(this.jdField_a_of_type_Ssu);
        return;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((ssw)localIterator.next()).onVideoError(123, 99, null);
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
    return this.jdField_a_of_type_Spn.c();
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Spn.a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Spn.a();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Spn.a(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = true;
    this.k = paramBoolean;
    this.jdField_a_of_type_Spn.a(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startPreload: coverFrame=" + paramBoolean);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Ssu != null) && ((d()) || (f()) || (g()) || (h()) || (i()));
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Spn.d();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "start: status=" + a());
    }
    this.jdField_a_of_type_Spn.d();
    this.jdField_a_of_type_Ssv.removeMessages(0);
    this.jdField_a_of_type_Ssv.sendEmptyMessage(0);
    six.a(new LitePlayer.3(this));
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ssr)localIterator.next()).a(this.jdField_a_of_type_Spn);
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.jdField_a_of_type_Spn.e(paramBoolean);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Spn.a();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "pause: status=" + a());
    }
    if ((h()) || (i()))
    {
      this.jdField_a_of_type_Spn.f();
      six.a(new LitePlayer.4(this));
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.i = paramBoolean;
    this.jdField_a_of_type_Spn.d(paramBoolean);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Spn.b();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "restart: status=" + a());
    }
    if ((g()) || (f()))
    {
      this.jdField_a_of_type_Spn.e();
      six.a(new LitePlayer.5(this));
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.j = paramBoolean;
    this.jdField_a_of_type_Spn.c(paramBoolean);
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Spn.c();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "stop: mPlayParam=" + this.jdField_a_of_type_Ssu);
    }
    if (this.jdField_a_of_type_Ssu != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((ssw)localIterator.next()).onVideoStop();
      }
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((ssr)localIterator.next()).a(this.jdField_a_of_type_Spn, this.jdField_b_of_type_Int);
      }
    }
    b(this.jdField_a_of_type_Spn);
    this.g = false;
    this.h = true;
    this.i = false;
    this.j = false;
    this.k = false;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Ssu = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(false);
    this.jdField_a_of_type_Ssv.removeMessages(0);
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Spn.d();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Spn.a();
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_Spn.e();
  }
  
  public void h()
  {
    this.jdField_a_of_type_Spn.b();
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_Spn.f();
  }
  
  public void i()
  {
    this.jdField_a_of_type_Spn.o();
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_Spn.g();
  }
  
  public void j()
  {
    this.jdField_a_of_type_Sst.a(this.jdField_a_of_type_Spn, null);
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
        AppRuntime localAppRuntime = pkh.a();
        if ((localAppRuntime instanceof QQAppInterface)) {}
        for (boolean bool = ((QQAppInterface)localAppRuntime).isVideoChatting();; bool = false)
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
    this.jdField_a_of_type_Spn.l();
    if (this.jdField_a_of_type_Spp != null) {
      this.jdField_a_of_type_Spp.b();
    }
    this.jdField_a_of_type_Ssv.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sss
 * JD-Core Version:    0.7.0.1
 */