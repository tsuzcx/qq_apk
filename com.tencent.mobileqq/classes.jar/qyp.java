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

public class qyp
  implements TVK_IMediaPlayer.OnDownloadCallbackListener, quf
{
  private int jdField_a_of_type_Int;
  @NonNull
  private Context jdField_a_of_type_AndroidContentContext;
  @NonNull
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private final String jdField_a_of_type_JavaLangString = "LitePlayer<" + Integer.toHexString(hashCode()) + ">";
  private List<qyt> jdField_a_of_type_JavaUtilList;
  @NonNull
  private qub jdField_a_of_type_Qub;
  private qud jdField_a_of_type_Qud;
  private qyq jdField_a_of_type_Qyq = new qyq(this, null);
  @Nullable
  private qyr jdField_a_of_type_Qyr;
  private qys jdField_a_of_type_Qys = new qys(this, null);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 100;
  private List<qyo> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private boolean c = true;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  @UiThread
  public qyp(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Qud = new qud(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Qud.a(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Qub = a(null);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    boolean bool = this.jdField_a_of_type_Qud.a();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "LitePlayer: isPluginInstalled=" + bool);
    }
    if (!bool) {
      this.jdField_a_of_type_Qud.a();
    }
  }
  
  @UiThread
  private qub a(qub paramqub)
  {
    qub localqub = paramqub;
    if (paramqub == null) {
      localqub = new qub(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    }
    localqub.a(this.jdField_a_of_type_Qyq);
    paramqub = localqub.b();
    if (paramqub != null)
    {
      paramqub.setKeepScreenOn(true);
      paramqub.setId(2131374778);
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(paramqub, -1, -1);
      localqub.a((IVideoViewBase)paramqub);
    }
    return localqub;
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
    this.jdField_a_of_type_Qub.a(this.jdField_a_of_type_Qyr);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((qyo)localIterator.next()).a(paramString1, paramString2, this.g, this.h);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(qyr paramqyr)
  {
    if (TextUtils.isEmpty(paramqyr.jdField_b_of_type_JavaLangString))
    {
      a(paramqyr.jdField_a_of_type_JavaLangString, paramqyr.jdField_a_of_type_Int, paramqyr.jdField_a_of_type_Long);
      return;
    }
    a(paramqyr.jdField_a_of_type_JavaLangString, paramqyr.jdField_b_of_type_JavaLangString, paramqyr.jdField_a_of_type_Int, paramqyr.jdField_a_of_type_Long, paramqyr.jdField_b_of_type_Int);
  }
  
  private boolean a(long paramLong)
  {
    if ((this.jdField_a_of_type_Qyr != null) && (this.g) && (this.jdField_a_of_type_Qub.a() == this.jdField_a_of_type_Qyr))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: status=" + this.jdField_a_of_type_Qub.e());
      }
      this.jdField_a_of_type_Qyr.jdField_a_of_type_Long = paramLong;
      Iterator localIterator;
      if ((e()) || (f()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: hasPrePlay, just go onVideoPrepared");
        }
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((qyo)localIterator.next()).a(true);
        }
        this.jdField_a_of_type_Qub.l();
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
          ((qyo)localIterator.next()).a(false);
        }
        this.g = false;
        this.jdField_a_of_type_Qub.l();
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Qys.sendEmptyMessageDelayed(1, 10000L);
        return true;
      }
      this.g = false;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: checkPreload player was preload but status error");
      }
    }
    return false;
  }
  
  private void b(qub paramqub)
  {
    if (paramqub == null) {}
    int i;
    do
    {
      return;
      paramqub.p();
      i = paramqub.e();
    } while ((i == 7) || (i == 8) || (i == 0) || (i == 6));
    paramqub.k();
    ThreadManager.excute(new LitePlayer.3(this, paramqub), 16, null, true);
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPlayer: tag=" + this.jdField_a_of_type_Qub.a());
    }
    if (this.jdField_a_of_type_Qub.a() != null)
    {
      b(this.jdField_a_of_type_Qub);
      this.jdField_a_of_type_Qub = a(null);
    }
  }
  
  private void k()
  {
    this.g = false;
    if (this.c)
    {
      a();
      if ((this.jdField_a_of_type_Qyr != null) && (this.jdField_a_of_type_Qyr.jdField_a_of_type_Long / 1000L != this.jdField_a_of_type_Qub.a() / 1000L)) {
        b((int)(this.jdField_a_of_type_Qyr.jdField_a_of_type_Long / 1000L));
      }
      return;
    }
    this.d = true;
  }
  
  private void l()
  {
    Object localObject = this.jdField_a_of_type_Qub;
    if (((qub)localObject).c())
    {
      long l = ((qub)localObject).a();
      if (l >= ((qub)localObject).b() - 500L) {
        this.f = true;
      }
      for (;;)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((qyt)((Iterator)localObject).next()).a(l);
        }
        if ((l >= 0L) && (this.f) && (((qub)localObject).g()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onVideoReplayOnLoop: pos=" + l);
          }
          this.f = false;
          this.jdField_a_of_type_Int += 1;
          ((qub)localObject).o();
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            localObject = this.jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((qyt)((Iterator)localObject).next()).b(this.jdField_a_of_type_Int);
            }
          }
        }
      }
    }
  }
  
  public void OnDownloadCallback(String paramString) {}
  
  public int a()
  {
    return this.jdField_a_of_type_Qub.e();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Qub.b();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "start: status=" + a());
    }
    this.jdField_a_of_type_Qub.f();
    this.jdField_a_of_type_Qys.removeMessages(0);
    this.jdField_a_of_type_Qys.sendEmptyMessage(0);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((qyt)localIterator.next()).b();
    }
    localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((qyo)localIterator.next()).a(this.jdField_a_of_type_Qub);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Qub.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.jdField_a_of_type_Qyq.a(null, paramInt1, paramInt2, paramInt3, paramString, null);
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
  
  public void a(qub paramqub)
  {
    if (paramqub != null) {
      b(paramqub);
    }
  }
  
  public void a(qyo paramqyo)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramqyo);
  }
  
  public void a(qyt paramqyt)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramqyt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = true;
    this.h = paramBoolean;
    this.jdField_a_of_type_Qub.a(paramBoolean);
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
    return this.jdField_a_of_type_Qub.a();
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Qub.a();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "pause: status=" + a());
    }
    if ((g()) || (h()))
    {
      this.jdField_a_of_type_Qub.h();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((qyt)localIterator.next()).c();
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Qub.a(paramInt);
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "openByVid: vid=" + paramString + ", playType=" + paramInt + ", startPosition=" + paramLong);
    }
    if (TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_Qyq.a(null, 101, 61, 0, "vid error", null);
    }
    if (a(paramLong)) {
      return;
    }
    this.jdField_a_of_type_Qyr = new qyr(this, paramString, null, paramInt, paramLong, 0);
    if (!this.jdField_a_of_type_Qud.a())
    {
      this.jdField_a_of_type_Qud.a();
      return;
    }
    j();
    a(paramString, null);
    this.jdField_a_of_type_Qub.a(paramString, paramInt, paramLong, this.g);
  }
  
  public void b(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "openByUrl: url=" + paramString2 + ", playType=" + paramInt1 + ", startPosition=" + paramLong);
    }
    if (TextUtils.isEmpty(paramString2)) {
      this.jdField_a_of_type_Qyq.a(null, 101, 61, 0, "url error", null);
    }
    if (a(paramLong)) {
      return;
    }
    this.jdField_a_of_type_Qyr = new qyr(this, paramString1, paramString2, paramInt1, paramLong, paramInt2);
    if (!this.jdField_a_of_type_Qud.a())
    {
      this.jdField_a_of_type_Qud.a();
      return;
    }
    j();
    a(paramString1, paramString2);
    this.jdField_a_of_type_Qub.a(paramString1, paramString2, paramInt1, paramLong, 0L, paramInt2, paramBoolean, true, this.g, paramString3);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qub.e(paramBoolean);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Qyr != null) && ((d()) || (e()) || (f()) || (g()) || (h()));
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Qub.b();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "restart: status=" + a());
    }
    if ((f()) || (e()))
    {
      this.jdField_a_of_type_Qub.g();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((qyt)localIterator.next()).d();
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
      this.jdField_a_of_type_Qub = a(this.jdField_a_of_type_Qub);
      if (this.jdField_a_of_type_Qyr != null)
      {
        a(this.jdField_a_of_type_Qyr);
        return;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((qyt)localIterator.next()).a(123, 99, null);
        }
      }
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Qub.e() == 0;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "stop: ");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((qyt)localIterator.next()).e();
    }
    localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((qyo)localIterator.next()).b(this.jdField_a_of_type_Qub);
    }
    b(this.jdField_a_of_type_Qub);
    this.g = false;
    this.jdField_a_of_type_Qyr = null;
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_Qub.a() != null) {
      this.jdField_a_of_type_Qub.a().setKeepScreenOn(false);
    }
    this.jdField_a_of_type_Qys.removeMessages(0);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qub.d(paramBoolean);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Qub.e() == 1;
  }
  
  public void e()
  {
    this.jdField_a_of_type_Qub.c();
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qub.c(paramBoolean);
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Qub.e() == 2;
  }
  
  public void f()
  {
    this.jdField_a_of_type_Qub.d();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Qub.e() == 5;
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
    return this.jdField_a_of_type_Qub.e() == 3;
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
        AppRuntime localAppRuntime = onk.a();
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
    return this.jdField_a_of_type_Qub.e() == 4;
  }
  
  public void i()
  {
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnDestory: ");
    }
    this.jdField_b_of_type_Boolean = true;
    d();
    this.jdField_a_of_type_Qub.m();
    if (this.jdField_a_of_type_Qud != null) {
      this.jdField_a_of_type_Qud.b();
    }
    this.jdField_a_of_type_Qys.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qyp
 * JD-Core Version:    0.7.0.1
 */