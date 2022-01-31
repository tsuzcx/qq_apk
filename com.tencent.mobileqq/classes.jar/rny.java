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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class rny
  implements TVK_IMediaPlayer.OnDownloadCallbackListener, rjr
{
  private int jdField_a_of_type_Int;
  @NonNull
  private Context jdField_a_of_type_AndroidContentContext;
  @NonNull
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private final String jdField_a_of_type_JavaLangString = "LitePlayer<" + Integer.toHexString(hashCode()) + ">";
  private List<roc> jdField_a_of_type_JavaUtilList;
  @NonNull
  private rjn jdField_a_of_type_Rjn;
  private rjp jdField_a_of_type_Rjp;
  private rnz jdField_a_of_type_Rnz = new rnz(this, null);
  @Nullable
  private roa jdField_a_of_type_Roa;
  private rob jdField_a_of_type_Rob = new rob(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 100;
  private List<rnx> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private boolean c = true;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  @UiThread
  public rny(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Rjp = new rjp(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Rjp.a(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Rjn = a(null);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    boolean bool = this.jdField_a_of_type_Rjp.a();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "LitePlayer: isPluginInstalled=" + bool);
    }
    if (!bool) {
      this.jdField_a_of_type_Rjp.a();
    }
  }
  
  @UiThread
  private rjn a(rjn paramrjn)
  {
    rjn localrjn = paramrjn;
    if (paramrjn == null)
    {
      localrjn = new rjn(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      localrjn.c(false);
    }
    localrjn.a(this.jdField_a_of_type_Rnz);
    paramrjn = localrjn.b();
    if (paramrjn != null)
    {
      paramrjn.setKeepScreenOn(true);
      paramrjn.setId(2131375294);
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(paramrjn, -1, -1);
      localrjn.a((IVideoViewBase)paramrjn);
    }
    return localrjn;
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
  
  private void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Rjn.a(this.jdField_a_of_type_Roa);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((rnx)localIterator.next()).a(paramString1, paramString2, this.g, this.h);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Rob.removeMessages(1);
  }
  
  private void a(roa paramroa)
  {
    if (TextUtils.isEmpty(paramroa.jdField_b_of_type_JavaLangString))
    {
      a(paramroa.jdField_a_of_type_JavaLangString, paramroa.jdField_a_of_type_Int, paramroa.jdField_a_of_type_Long);
      return;
    }
    a(paramroa.jdField_a_of_type_JavaLangString, paramroa.jdField_b_of_type_JavaLangString, paramroa.jdField_a_of_type_Int, paramroa.jdField_a_of_type_Long, paramroa.jdField_b_of_type_Int);
  }
  
  private boolean a(long paramLong)
  {
    if ((this.jdField_a_of_type_Roa != null) && (this.g) && (this.jdField_a_of_type_Rjn.a() == this.jdField_a_of_type_Roa))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: status=" + this.jdField_a_of_type_Rjn.e());
      }
      this.jdField_a_of_type_Roa.jdField_a_of_type_Long = paramLong;
      Iterator localIterator;
      if ((e()) || (f()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: hasPrePlay, just go onVideoPrepared");
        }
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((rnx)localIterator.next()).a(true);
        }
        this.jdField_a_of_type_Rjn.l();
        k();
        return true;
      }
      if ((c()) || (d()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: prePlaying, just do nothing ");
        }
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((rnx)localIterator.next()).a(false);
        }
        this.g = false;
        this.jdField_a_of_type_Rjn.l();
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Rob.sendEmptyMessageDelayed(1, 10000L);
        return true;
      }
      this.g = false;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: checkPreload player was preload but status error");
      }
    }
    return false;
  }
  
  private void b(rjn paramrjn)
  {
    if (paramrjn == null) {}
    int i;
    do
    {
      return;
      paramrjn.p();
      i = paramrjn.e();
    } while ((i == 7) || (i == 8) || (i == 0) || (i == 6));
    paramrjn.k();
    ThreadManager.excute(new LitePlayer.3(this, paramrjn), 16, null, true);
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPlayer: tag=" + this.jdField_a_of_type_Rjn.a());
    }
    if (this.jdField_a_of_type_Rjn.a() != null)
    {
      b(this.jdField_a_of_type_Rjn);
      this.jdField_a_of_type_Rjn = a(null);
    }
  }
  
  private void k()
  {
    this.g = false;
    this.jdField_a_of_type_Rob.removeMessages(1);
    if (this.c)
    {
      a();
      if ((this.jdField_a_of_type_Roa != null) && (this.jdField_a_of_type_Roa.jdField_a_of_type_Long / 1000L != this.jdField_a_of_type_Rjn.a() / 1000L)) {
        b((int)(this.jdField_a_of_type_Roa.jdField_a_of_type_Long / 1000L));
      }
      return;
    }
    this.d = true;
  }
  
  private void l()
  {
    Object localObject = this.jdField_a_of_type_Rjn;
    if (((rjn)localObject).c())
    {
      long l = ((rjn)localObject).a();
      if (l >= ((rjn)localObject).b() - 500L) {
        this.f = true;
      }
      for (;;)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((roc)((Iterator)localObject).next()).a(l);
        }
        if ((l >= 0L) && (this.f) && (((rjn)localObject).g()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onVideoReplayOnLoop: pos=" + l);
          }
          this.f = false;
          this.jdField_a_of_type_Int += 1;
          ((rjn)localObject).o();
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            localObject = this.jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((roc)((Iterator)localObject).next()).f_(this.jdField_a_of_type_Int);
            }
          }
        }
      }
    }
  }
  
  public void OnDownloadCallback(String paramString) {}
  
  public int a()
  {
    return this.jdField_a_of_type_Rjn.e();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Rjn.b();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "start: status=" + a());
    }
    this.jdField_a_of_type_Rjn.f();
    this.jdField_a_of_type_Rob.removeMessages(0);
    this.jdField_a_of_type_Rob.sendEmptyMessage(0);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((roc)localIterator.next()).e();
    }
    localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((rnx)localIterator.next()).a(this.jdField_a_of_type_Rjn);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Rjn.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.jdField_a_of_type_Rnz.a(null, paramInt1, paramInt2, paramInt3, paramString, null);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    e();
    if ((this.jdField_a_of_type_AndroidViewViewGroup.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    f();
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
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2)
  {
    a(paramString1, paramString2, null, true, paramInt1, paramLong, paramInt2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    a(new LitePlayer.2(this, paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramLong, paramInt2));
  }
  
  public void a(rjn paramrjn)
  {
    if (paramrjn != null) {
      b(paramrjn);
    }
  }
  
  public void a(rnx paramrnx)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramrnx);
  }
  
  public void a(roc paramroc)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramroc);
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = true;
    this.h = paramBoolean;
    this.jdField_a_of_type_Rjn.a(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startPreload: coverFrame=" + paramBoolean);
    }
  }
  
  public boolean a()
  {
    return this.g;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Rjn.a();
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Rjn.a();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "pause: status=" + a());
    }
    if ((g()) || (h()))
    {
      this.jdField_a_of_type_Rjn.h();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((roc)localIterator.next()).f();
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Rjn.a(paramInt);
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "openByVid: vid=" + paramString + ", playType=" + paramInt + ", startPosition=" + paramLong);
    }
    if (TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_Rnz.a(null, 101, 61, 0, "vid error", null);
    }
    if (a(paramLong)) {
      return;
    }
    this.jdField_a_of_type_Roa = new roa(this, paramString, null, paramInt, paramLong, 0);
    if (!this.jdField_a_of_type_Rjp.a())
    {
      this.jdField_a_of_type_Rjp.a();
      return;
    }
    j();
    a(paramString, null);
    this.jdField_a_of_type_Rjn.a(paramString, paramInt, paramLong, this.g);
  }
  
  public void b(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "openByUrl: url=" + paramString2 + ", playType=" + paramInt1 + ", startPosition=" + paramLong);
    }
    if (TextUtils.isEmpty(paramString2)) {
      this.jdField_a_of_type_Rnz.a(null, 101, 61, 0, "url error", null);
    }
    if (a(paramLong)) {
      return;
    }
    this.jdField_a_of_type_Roa = new roa(this, paramString1, paramString2, paramInt1, paramLong, paramInt2);
    if (!this.jdField_a_of_type_Rjp.a())
    {
      this.jdField_a_of_type_Rjp.a();
      return;
    }
    j();
    a(paramString1, paramString2);
    this.jdField_a_of_type_Rjn.a(paramString1, paramString2, paramInt1, paramLong, 0L, paramInt2, paramBoolean, true, this.g, paramString3);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Rjn.e(paramBoolean);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Roa != null) && ((d()) || (e()) || (f()) || (g()) || (h()));
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Rjn.b();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "restart: status=" + a());
    }
    if ((f()) || (e()))
    {
      this.jdField_a_of_type_Rjn.g();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((roc)localIterator.next()).L_();
      }
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void c(boolean paramBoolean)
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
      this.jdField_a_of_type_Rjn = a(this.jdField_a_of_type_Rjn);
      if (this.jdField_a_of_type_Roa != null)
      {
        a(this.jdField_a_of_type_Roa);
        return;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((roc)localIterator.next()).a(123, 99, null);
        }
      }
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Rjn.e() == 0;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "stop: ");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((roc)localIterator.next()).h();
    }
    localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((rnx)localIterator.next()).b(this.jdField_a_of_type_Rjn);
    }
    b(this.jdField_a_of_type_Rjn);
    this.g = false;
    this.jdField_a_of_type_Roa = null;
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_Rjn.a() != null) {
      this.jdField_a_of_type_Rjn.a().setKeepScreenOn(false);
    }
    this.jdField_a_of_type_Rob.removeMessages(0);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Rjn.d(paramBoolean);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Rjn.e() == 1;
  }
  
  public void e()
  {
    this.jdField_a_of_type_Rjn.c();
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Rjn.c(paramBoolean);
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Rjn.e() == 2;
  }
  
  public void f()
  {
    this.jdField_a_of_type_Rjn.d();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Rjn.e() == 5;
  }
  
  public void g()
  {
    this.c = false;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnPause() isPlaying()=" + g());
    }
    if ((g()) || (h()))
    {
      this.e = true;
      this.jdField_a_of_type_Boolean = false;
      b();
    }
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_Rjn.e() == 3;
  }
  
  public void h()
  {
    this.c = true;
    if ((this.d) && (e())) {
      k();
    }
    label79:
    for (;;)
    {
      this.e = false;
      this.d = false;
      return;
      if (this.e)
      {
        AppRuntime localAppRuntime = ors.a();
        if ((localAppRuntime instanceof QQAppInterface)) {}
        for (boolean bool = ((QQAppInterface)localAppRuntime).c();; bool = false)
        {
          if (bool) {
            break label79;
          }
          this.jdField_a_of_type_Boolean = true;
          c();
          break;
        }
      }
    }
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_Rjn.e() == 4;
  }
  
  public void i()
  {
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnDestory: ");
    }
    this.jdField_b_of_type_Boolean = true;
    d();
    this.jdField_a_of_type_Rjn.m();
    if (this.jdField_a_of_type_Rjp != null) {
      this.jdField_a_of_type_Rjp.b();
    }
    this.jdField_a_of_type_Rob.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_Rjn.e() == 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rny
 * JD-Core Version:    0.7.0.1
 */