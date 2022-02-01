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

public class sgn
  implements sdn
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 0;
  @NonNull
  protected Context a;
  @NonNull
  protected ViewGroup a;
  private final String jdField_a_of_type_JavaLangString = "LitePlayer<" + Integer.toHexString(hashCode()) + ">";
  private List<sgr> jdField_a_of_type_JavaUtilList;
  @NonNull
  public sdj a;
  private sdl jdField_a_of_type_Sdl;
  private sgo jdField_a_of_type_Sgo = new sgo(this);
  @Nullable
  private sgp jdField_a_of_type_Sgp;
  private sgq jdField_a_of_type_Sgq = new sgq(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<sgm> jdField_b_of_type_JavaUtilList;
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
  public sgn(Context paramContext, String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.l = paramBoolean;
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Sdl = new sdl();
    this.jdField_a_of_type_Sdl.a(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Sdj = a();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    paramBoolean = this.jdField_a_of_type_Sdl.a();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "LitePlayer: isPluginInstalled=" + paramBoolean);
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_Sdl.a();
    }
  }
  
  @UiThread
  private sdj a()
  {
    sdj localsdj = new sdj(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_b_of_type_JavaLangString);
    localsdj.a(this.jdField_a_of_type_Sgo);
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    for (boolean bool = true;; bool = false)
    {
      localsdj.a((ViewGroup)localObject, bool, this.l);
      localObject = localsdj.a();
      if (localObject != null)
      {
        ((View)localObject).setId(2131375928);
        this.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
      }
      localsdj.a(this.k);
      localsdj.c(this.j);
      localsdj.e(this.h);
      localsdj.a(this.jdField_a_of_type_Float);
      localsdj.d(this.i);
      localsdj.b(this.jdField_a_of_type_Int);
      return localsdj;
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
  
  private void a(sgp paramsgp)
  {
    if (TextUtils.isEmpty(paramsgp.jdField_b_of_type_JavaLangString))
    {
      a(paramsgp.jdField_a_of_type_JavaLangString, paramsgp.jdField_a_of_type_Int, paramsgp.jdField_a_of_type_Long);
      return;
    }
    a(paramsgp.jdField_a_of_type_JavaLangString, paramsgp.jdField_b_of_type_JavaLangString, paramsgp.jdField_a_of_type_Int, paramsgp.jdField_a_of_type_Long, paramsgp.jdField_b_of_type_Int);
  }
  
  private void a(boolean paramBoolean1, String paramString1, String paramString2, String paramString3, boolean paramBoolean2, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "openByUrl: vid=" + paramString1 + ", url=" + paramString2 + ", playType=" + paramInt1 + ", startPosition=" + paramLong);
    }
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Sgo.a(null, 201, 109, 0, "player had destoryed", null);
    }
    do
    {
      return;
      if ((paramBoolean1) && (TextUtils.isEmpty(paramString2)))
      {
        this.jdField_a_of_type_Sgo.a(null, 201, 61, 0, "url null", null);
        return;
      }
      if ((!paramBoolean1) && (TextUtils.isEmpty(paramString1)))
      {
        this.jdField_a_of_type_Sgo.a(null, 201, 61, 0, "vid null", null);
        return;
      }
    } while (a(paramLong));
    this.jdField_a_of_type_Sgp = new sgp(this, paramString1, paramString2, paramInt1, paramLong, paramInt2);
    if (!this.jdField_a_of_type_Sdl.a())
    {
      this.jdField_a_of_type_Sdl.a();
      return;
    }
    n();
    b(paramString1, paramString2);
    if (paramBoolean1)
    {
      this.jdField_a_of_type_Sdj.a(paramString1, paramString2, paramInt1, paramLong, 0L, paramInt2, paramBoolean2, true, this.g, paramString3);
      return;
    }
    this.jdField_a_of_type_Sdj.a(paramString1, paramInt1, paramLong, this.g);
  }
  
  private boolean a(long paramLong)
  {
    if ((this.jdField_a_of_type_Sgp != null) && (this.g) && (this.jdField_a_of_type_Sdj.a() == this.jdField_a_of_type_Sgp))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: status=" + this.jdField_a_of_type_Sdj.b());
      }
      this.jdField_a_of_type_Sgp.jdField_a_of_type_Long = paramLong;
      Iterator localIterator;
      if ((f()) || (g()) || (i()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: hasPrePlay, just go onVideoPrepared");
        }
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((sgm)localIterator.next()).a(true);
        }
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((sgm)localIterator.next()).b(this.jdField_a_of_type_Sdj);
        }
        this.jdField_a_of_type_Sdj.k();
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
          ((sgm)localIterator.next()).a(false);
        }
        this.g = false;
        this.jdField_a_of_type_Sdj.k();
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Sgq.sendEmptyMessageDelayed(1, 10000L);
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
      ((sgm)localIterator.next()).a(paramString1, paramString2, this.g, this.k);
    }
    paramString1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString1.hasNext()) {
      ((sgr)paramString1.next()).onVideoOpen();
    }
    b(this.jdField_a_of_type_Sgp);
  }
  
  private void b(sdj paramsdj)
  {
    if (paramsdj == null) {}
    do
    {
      return;
      paramsdj.n();
    } while ((paramsdj.j()) || (paramsdj.i()));
    paramsdj.j();
    ThreadManager.excute(new LitePlayer.6(this, paramsdj), 16, null, true);
  }
  
  private void b(sgp paramsgp)
  {
    this.jdField_a_of_type_Sdj.a(paramsgp);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Sgq.removeMessages(1);
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPlayer: tag=" + this.jdField_a_of_type_Sdj.a());
    }
    if ((this.jdField_a_of_type_Sdj.a() != null) || (!this.jdField_a_of_type_Sdj.j()))
    {
      b(this.jdField_a_of_type_Sdj);
      this.jdField_a_of_type_Sdj.l();
      this.jdField_a_of_type_Sdj = a();
    }
  }
  
  private void o()
  {
    this.g = false;
    this.jdField_a_of_type_Sgq.removeMessages(1);
    if (this.jdField_c_of_type_Boolean)
    {
      c();
      if ((this.jdField_a_of_type_Sgp != null) && (this.jdField_a_of_type_Sgp.jdField_a_of_type_Long / 1000L != this.jdField_a_of_type_Sdj.a() / 1000L)) {
        b((int)(this.jdField_a_of_type_Sgp.jdField_a_of_type_Long / 1000L));
      }
      return;
    }
    this.d = true;
  }
  
  private void p()
  {
    Object localObject = this.jdField_a_of_type_Sdj;
    if (((sdj)localObject).f())
    {
      long l1 = ((sdj)localObject).a();
      if (l1 >= ((sdj)localObject).b() - 500L) {
        this.f = true;
      }
      while (this.jdField_a_of_type_JavaUtilList != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((sgr)((Iterator)localObject).next()).onProgressChanged(l1);
        }
        if ((l1 >= 0L) && (this.f) && (((sdj)localObject).m()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onVideoReplayOnLoop: pos=" + l1);
          }
          this.f = false;
          this.jdField_b_of_type_Int += 1;
          ((sdj)localObject).m();
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            localObject = this.jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((sgr)((Iterator)localObject).next()).onVideoEnd(this.jdField_b_of_type_Int);
            }
          }
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Sdj.b();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Sdj.b();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Sdj.c();
  }
  
  public Map<String, String> a()
  {
    Map localMap = shq.a(this.jdField_a_of_type_Sdj);
    shq.a(localMap);
    return localMap;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "replay: " + this.jdField_a_of_type_Sgp);
    }
    b(this.jdField_a_of_type_Sdj);
    if (this.jdField_a_of_type_Sgp != null) {
      a(this.jdField_a_of_type_Sgp);
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Sdj.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Sdj.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.jdField_a_of_type_Sgo.a(null, paramInt1, paramInt2, paramInt3, paramString, null);
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
    this.jdField_a_of_type_Sgq.removeMessages(0);
    this.jdField_a_of_type_Sgq.sendEmptyMessage(0);
    b(new sgp(this, paramString1, paramString2, 0, 0L, 0));
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2)
  {
    a(paramString1, paramString2, null, true, paramInt1, paramLong, paramInt2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    a(new LitePlayer.2(this, paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramLong, paramInt2));
  }
  
  public void a(sdj paramsdj)
  {
    if (paramsdj != null) {
      b(paramsdj);
    }
  }
  
  public void a(sgm paramsgm)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramsgm);
  }
  
  public void a(sgr paramsgr)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramsgr);
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
      this.jdField_a_of_type_Sdj = a();
      if (this.jdField_a_of_type_Sgp != null)
      {
        a(this.jdField_a_of_type_Sgp);
        return;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((sgr)localIterator.next()).onVideoError(123, 99, null);
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
    return this.jdField_a_of_type_Sdj.c();
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Sdj.a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Sdj.a();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Sdj.a(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = true;
    this.k = paramBoolean;
    this.jdField_a_of_type_Sdj.a(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startPreload: coverFrame=" + paramBoolean);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Sgp != null) && ((d()) || (f()) || (g()) || (h()) || (i()));
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Sdj.d();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "start: status=" + a());
    }
    this.jdField_a_of_type_Sdj.d();
    this.jdField_a_of_type_Sgq.removeMessages(0);
    this.jdField_a_of_type_Sgq.sendEmptyMessage(0);
    rwv.a(new LitePlayer.3(this));
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((sgm)localIterator.next()).a(this.jdField_a_of_type_Sdj);
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.jdField_a_of_type_Sdj.e(paramBoolean);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Sdj.a();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "pause: status=" + a());
    }
    if ((h()) || (i()))
    {
      this.jdField_a_of_type_Sdj.f();
      rwv.a(new LitePlayer.4(this));
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.i = paramBoolean;
    this.jdField_a_of_type_Sdj.d(paramBoolean);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Sdj.b();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "restart: status=" + a());
    }
    if ((g()) || (f()))
    {
      this.jdField_a_of_type_Sdj.e();
      rwv.a(new LitePlayer.5(this));
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.j = paramBoolean;
    this.jdField_a_of_type_Sdj.c(paramBoolean);
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Sdj.c();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "stop: mPlayParam=" + this.jdField_a_of_type_Sgp);
    }
    if (this.jdField_a_of_type_Sgp != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((sgr)localIterator.next()).onVideoStop();
      }
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((sgm)localIterator.next()).a(this.jdField_a_of_type_Sdj, this.jdField_b_of_type_Int);
      }
    }
    b(this.jdField_a_of_type_Sdj);
    this.g = false;
    this.h = true;
    this.i = false;
    this.j = false;
    this.k = false;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Sgp = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(false);
    this.jdField_a_of_type_Sgq.removeMessages(0);
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Sdj.d();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Sdj.a();
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_Sdj.e();
  }
  
  public void h()
  {
    this.jdField_a_of_type_Sdj.b();
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_Sdj.f();
  }
  
  public void i()
  {
    this.jdField_a_of_type_Sdj.o();
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_Sdj.g();
  }
  
  public void j()
  {
    this.jdField_a_of_type_Sgo.a(this.jdField_a_of_type_Sdj, null);
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
        AppRuntime localAppRuntime = pay.a();
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
    this.jdField_a_of_type_Sdj.l();
    if (this.jdField_a_of_type_Sdl != null) {
      this.jdField_a_of_type_Sdl.b();
    }
    this.jdField_a_of_type_Sgq.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgn
 * JD-Core Version:    0.7.0.1
 */