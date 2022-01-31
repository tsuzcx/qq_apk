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

public class qym
  implements TVK_IMediaPlayer.OnDownloadCallbackListener, quc
{
  private int jdField_a_of_type_Int;
  @NonNull
  private Context jdField_a_of_type_AndroidContentContext;
  @NonNull
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private final String jdField_a_of_type_JavaLangString = "LitePlayer<" + Integer.toHexString(hashCode()) + ">";
  private List<qyq> jdField_a_of_type_JavaUtilList;
  @NonNull
  private qty jdField_a_of_type_Qty;
  private qua jdField_a_of_type_Qua;
  private qyn jdField_a_of_type_Qyn = new qyn(this, null);
  @Nullable
  private qyo jdField_a_of_type_Qyo;
  private qyp jdField_a_of_type_Qyp = new qyp(this, null);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 100;
  private List<qyl> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private boolean c = true;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  @UiThread
  public qym(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Qua = new qua(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Qua.a(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Qty = a(null);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    boolean bool = this.jdField_a_of_type_Qua.a();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "LitePlayer: isPluginInstalled=" + bool);
    }
    if (!bool) {
      this.jdField_a_of_type_Qua.a();
    }
  }
  
  @UiThread
  private qty a(qty paramqty)
  {
    qty localqty = paramqty;
    if (paramqty == null) {
      localqty = new qty(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    }
    localqty.a(this.jdField_a_of_type_Qyn);
    paramqty = localqty.b();
    if (paramqty != null)
    {
      paramqty.setKeepScreenOn(true);
      paramqty.setId(2131374780);
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(paramqty, -1, -1);
      localqty.a((IVideoViewBase)paramqty);
    }
    return localqty;
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
    this.jdField_a_of_type_Qty.a(this.jdField_a_of_type_Qyo);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((qyl)localIterator.next()).a(paramString1, paramString2, this.g, this.h);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(qyo paramqyo)
  {
    if (TextUtils.isEmpty(paramqyo.jdField_b_of_type_JavaLangString))
    {
      a(paramqyo.jdField_a_of_type_JavaLangString, paramqyo.jdField_a_of_type_Int, paramqyo.jdField_a_of_type_Long);
      return;
    }
    a(paramqyo.jdField_a_of_type_JavaLangString, paramqyo.jdField_b_of_type_JavaLangString, paramqyo.jdField_a_of_type_Int, paramqyo.jdField_a_of_type_Long, paramqyo.jdField_b_of_type_Int);
  }
  
  private boolean a(long paramLong)
  {
    if ((this.jdField_a_of_type_Qyo != null) && (this.g) && (this.jdField_a_of_type_Qty.a() == this.jdField_a_of_type_Qyo))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: status=" + this.jdField_a_of_type_Qty.e());
      }
      this.jdField_a_of_type_Qyo.jdField_a_of_type_Long = paramLong;
      Iterator localIterator;
      if ((e()) || (f()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: hasPrePlay, just go onVideoPrepared");
        }
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((qyl)localIterator.next()).a(true);
        }
        this.jdField_a_of_type_Qty.l();
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
          ((qyl)localIterator.next()).a(false);
        }
        this.g = false;
        this.jdField_a_of_type_Qty.l();
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Qyp.sendEmptyMessageDelayed(1, 10000L);
        return true;
      }
      this.g = false;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: checkPreload player was preload but status error");
      }
    }
    return false;
  }
  
  private void b(qty paramqty)
  {
    if (paramqty == null) {}
    int i;
    do
    {
      return;
      paramqty.p();
      i = paramqty.e();
    } while ((i == 7) || (i == 8) || (i == 0) || (i == 6));
    paramqty.k();
    ThreadManager.excute(new LitePlayer.3(this, paramqty), 16, null, true);
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPlayer: tag=" + this.jdField_a_of_type_Qty.a());
    }
    if (this.jdField_a_of_type_Qty.a() != null)
    {
      b(this.jdField_a_of_type_Qty);
      this.jdField_a_of_type_Qty = a(null);
    }
  }
  
  private void k()
  {
    this.g = false;
    if (this.c)
    {
      a();
      if ((this.jdField_a_of_type_Qyo != null) && (this.jdField_a_of_type_Qyo.jdField_a_of_type_Long / 1000L != this.jdField_a_of_type_Qty.a() / 1000L)) {
        b((int)(this.jdField_a_of_type_Qyo.jdField_a_of_type_Long / 1000L));
      }
      return;
    }
    this.d = true;
  }
  
  private void l()
  {
    Object localObject = this.jdField_a_of_type_Qty;
    if (((qty)localObject).c())
    {
      long l = ((qty)localObject).a();
      if (l >= ((qty)localObject).b() - 500L) {
        this.f = true;
      }
      for (;;)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((qyq)((Iterator)localObject).next()).a(l);
        }
        if ((l >= 0L) && (this.f) && (((qty)localObject).g()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onVideoReplayOnLoop: pos=" + l);
          }
          this.f = false;
          this.jdField_a_of_type_Int += 1;
          ((qty)localObject).o();
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            localObject = this.jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((qyq)((Iterator)localObject).next()).b(this.jdField_a_of_type_Int);
            }
          }
        }
      }
    }
  }
  
  public void OnDownloadCallback(String paramString) {}
  
  public int a()
  {
    return this.jdField_a_of_type_Qty.e();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Qty.b();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "start: status=" + a());
    }
    this.jdField_a_of_type_Qty.f();
    this.jdField_a_of_type_Qyp.removeMessages(0);
    this.jdField_a_of_type_Qyp.sendEmptyMessage(0);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((qyq)localIterator.next()).b();
    }
    localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((qyl)localIterator.next()).a(this.jdField_a_of_type_Qty);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Qty.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.jdField_a_of_type_Qyn.a(null, paramInt1, paramInt2, paramInt3, paramString, null);
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
  
  public void a(qty paramqty)
  {
    if (paramqty != null) {
      b(paramqty);
    }
  }
  
  public void a(qyl paramqyl)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramqyl);
  }
  
  public void a(qyq paramqyq)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramqyq);
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = true;
    this.h = paramBoolean;
    this.jdField_a_of_type_Qty.a(paramBoolean);
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
    return this.jdField_a_of_type_Qty.a();
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Qty.a();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "pause: status=" + a());
    }
    if ((g()) || (h()))
    {
      this.jdField_a_of_type_Qty.h();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((qyq)localIterator.next()).c();
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Qty.a(paramInt);
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "openByVid: vid=" + paramString + ", playType=" + paramInt + ", startPosition=" + paramLong);
    }
    if (TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_Qyn.a(null, 101, 61, 0, "vid error", null);
    }
    if (a(paramLong)) {
      return;
    }
    this.jdField_a_of_type_Qyo = new qyo(this, paramString, null, paramInt, paramLong, 0);
    if (!this.jdField_a_of_type_Qua.a())
    {
      this.jdField_a_of_type_Qua.a();
      return;
    }
    j();
    a(paramString, null);
    this.jdField_a_of_type_Qty.a(paramString, paramInt, paramLong, this.g);
  }
  
  public void b(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "openByUrl: url=" + paramString2 + ", playType=" + paramInt1 + ", startPosition=" + paramLong);
    }
    if (TextUtils.isEmpty(paramString2)) {
      this.jdField_a_of_type_Qyn.a(null, 101, 61, 0, "url error", null);
    }
    if (a(paramLong)) {
      return;
    }
    this.jdField_a_of_type_Qyo = new qyo(this, paramString1, paramString2, paramInt1, paramLong, paramInt2);
    if (!this.jdField_a_of_type_Qua.a())
    {
      this.jdField_a_of_type_Qua.a();
      return;
    }
    j();
    a(paramString1, paramString2);
    this.jdField_a_of_type_Qty.a(paramString1, paramString2, paramInt1, paramLong, 0L, paramInt2, paramBoolean, true, this.g, paramString3);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qty.e(paramBoolean);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Qyo != null) && ((d()) || (e()) || (f()) || (g()) || (h()));
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Qty.b();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "restart: status=" + a());
    }
    if ((f()) || (e()))
    {
      this.jdField_a_of_type_Qty.g();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((qyq)localIterator.next()).d();
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
      this.jdField_a_of_type_Qty = a(this.jdField_a_of_type_Qty);
      if (this.jdField_a_of_type_Qyo != null)
      {
        a(this.jdField_a_of_type_Qyo);
        return;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((qyq)localIterator.next()).a(123, 99, null);
        }
      }
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Qty.e() == 0;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "stop: ");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((qyq)localIterator.next()).e();
    }
    localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((qyl)localIterator.next()).b(this.jdField_a_of_type_Qty);
    }
    b(this.jdField_a_of_type_Qty);
    this.g = false;
    this.jdField_a_of_type_Qyo = null;
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_Qty.a() != null) {
      this.jdField_a_of_type_Qty.a().setKeepScreenOn(false);
    }
    this.jdField_a_of_type_Qyp.removeMessages(0);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qty.d(paramBoolean);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Qty.e() == 1;
  }
  
  public void e()
  {
    this.jdField_a_of_type_Qty.c();
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qty.c(paramBoolean);
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Qty.e() == 2;
  }
  
  public void f()
  {
    this.jdField_a_of_type_Qty.d();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Qty.e() == 5;
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
    return this.jdField_a_of_type_Qty.e() == 3;
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
        AppRuntime localAppRuntime = onh.a();
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
    return this.jdField_a_of_type_Qty.e() == 4;
  }
  
  public void i()
  {
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnDestory: ");
    }
    this.jdField_b_of_type_Boolean = true;
    d();
    this.jdField_a_of_type_Qty.m();
    if (this.jdField_a_of_type_Qua != null) {
      this.jdField_a_of_type_Qua.b();
    }
    this.jdField_a_of_type_Qyp.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qym
 * JD-Core Version:    0.7.0.1
 */