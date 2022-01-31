import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.video.player.LitePlayer.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class qmk
  implements TVK_IMediaPlayer.OnDownloadCallbackListener, qia
{
  private int jdField_a_of_type_Int;
  @NonNull
  private Context jdField_a_of_type_AndroidContentContext;
  @NonNull
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private final String jdField_a_of_type_JavaLangString = "LitePlayer<" + Integer.toHexString(hashCode()) + ">";
  private List<qmo> jdField_a_of_type_JavaUtilList;
  @NonNull
  private qhw jdField_a_of_type_Qhw;
  private qhy jdField_a_of_type_Qhy;
  private qml jdField_a_of_type_Qml = new qml(this, null);
  @Nullable
  private qmm jdField_a_of_type_Qmm;
  private qmn jdField_a_of_type_Qmn = new qmn(this, null);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 100;
  private List<qmj> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private boolean c = true;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public qmk(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Qhy = new qhy(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Qhy.a(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Qhw = a(null);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    boolean bool = this.jdField_a_of_type_Qhy.a();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "LitePlayer: isPluginInstalled=" + bool);
    }
    if (!bool) {
      this.jdField_a_of_type_Qhy.a();
    }
  }
  
  private qhw a(qhw paramqhw)
  {
    qhw localqhw = paramqhw;
    if (paramqhw == null) {
      localqhw = new qhw(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    }
    localqhw.a(this.jdField_a_of_type_Qml);
    paramqhw = localqhw.b();
    if (paramqhw != null)
    {
      paramqhw.setKeepScreenOn(true);
      paramqhw.setId(2131309037);
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(paramqhw, -1, -1);
      localqhw.a((IVideoViewBase)paramqhw);
    }
    return localqhw;
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Qhw.a(this.jdField_a_of_type_Qmm);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((qmj)localIterator.next()).a(paramString1, paramString2, this.g, this.h);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(qmm paramqmm)
  {
    if (TextUtils.isEmpty(paramqmm.jdField_b_of_type_JavaLangString))
    {
      a(paramqmm.jdField_a_of_type_JavaLangString, paramqmm.jdField_a_of_type_Int, paramqmm.jdField_a_of_type_Long);
      return;
    }
    a(paramqmm.jdField_a_of_type_JavaLangString, paramqmm.jdField_b_of_type_JavaLangString, paramqmm.jdField_a_of_type_Int, paramqmm.jdField_a_of_type_Long, paramqmm.jdField_b_of_type_Int);
  }
  
  private void b(qhw paramqhw)
  {
    if (paramqhw == null) {}
    int i;
    do
    {
      return;
      paramqhw.p();
      i = paramqhw.e();
    } while ((i == 7) || (i == 8) || (i == 0) || (i == 6));
    paramqhw.k();
    ThreadManager.excute(new LitePlayer.1(this, paramqhw), 16, null, true);
  }
  
  private boolean i()
  {
    if ((this.jdField_a_of_type_Qmm != null) && (this.g) && (this.jdField_a_of_type_Qhw.a() == this.jdField_a_of_type_Qmm))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: status=" + this.jdField_a_of_type_Qhw.e());
      }
      Iterator localIterator;
      if ((e()) || (f()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: hasPrePlay, just go onVideoPrepared");
        }
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((qmj)localIterator.next()).a(true);
        }
        this.jdField_a_of_type_Qhw.l();
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
          ((qmj)localIterator.next()).a(false);
        }
        this.jdField_a_of_type_Qhw.l();
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Qmn.sendEmptyMessageDelayed(1, 10000L);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: checkPreload player was preload but status error");
      }
    }
    return false;
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPlayer: tag=" + this.jdField_a_of_type_Qhw.a());
    }
    if (this.jdField_a_of_type_Qhw.a() != null)
    {
      b(this.jdField_a_of_type_Qhw);
      this.jdField_a_of_type_Qhw = a(null);
    }
  }
  
  private void k()
  {
    this.g = false;
    if (this.c)
    {
      a();
      return;
    }
    this.d = true;
  }
  
  private void l()
  {
    Object localObject = this.jdField_a_of_type_Qhw;
    if (((qhw)localObject).b())
    {
      long l = ((qhw)localObject).a();
      if (l >= ((qhw)localObject).b() - 500L) {
        this.f = true;
      }
      for (;;)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((qmo)((Iterator)localObject).next()).a(l);
        }
        if ((l >= 0L) && (this.f) && (((qhw)localObject).f()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onVideoReplayOnLoop: pos=" + l);
          }
          this.f = false;
          this.jdField_a_of_type_Int += 1;
          ((qhw)localObject).o();
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            localObject = this.jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((qmo)((Iterator)localObject).next()).b(this.jdField_a_of_type_Int);
            }
          }
        }
      }
    }
  }
  
  public void OnDownloadCallback(String paramString) {}
  
  public int a()
  {
    return this.jdField_a_of_type_Qhw.e();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Qhw.b();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "start: status=" + a());
    }
    this.jdField_a_of_type_Qhw.f();
    this.jdField_a_of_type_Qmn.removeMessages(0);
    this.jdField_a_of_type_Qmn.sendEmptyMessage(0);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((qmo)localIterator.next()).b();
    }
    localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((qmj)localIterator.next()).a(this.jdField_a_of_type_Qhw);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Qhw.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.jdField_a_of_type_Qml.a(null, paramInt1, paramInt2, paramInt3, paramString, null);
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
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "openByVid: vid=" + paramString + ", playType=" + paramInt + ", startPosition=" + paramLong);
    }
    if (TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_Qml.a(null, 101, 61, 0, "vid error", null);
    }
    if (i()) {
      return;
    }
    this.jdField_a_of_type_Qmm = new qmm(this, paramString, null, paramInt, paramLong, 0);
    if (!this.jdField_a_of_type_Qhy.a())
    {
      this.jdField_a_of_type_Qhy.a();
      return;
    }
    j();
    a(paramString, null);
    this.jdField_a_of_type_Qhw.a(paramString, paramInt, paramLong, this.g);
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
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "openByUrl: url=" + paramString2 + ", playType=" + paramInt1 + ", startPosition=" + paramLong);
    }
    if (TextUtils.isEmpty(paramString2)) {
      this.jdField_a_of_type_Qml.a(null, 101, 61, 0, "url error", null);
    }
    if (i()) {
      return;
    }
    this.jdField_a_of_type_Qmm = new qmm(this, paramString1, paramString2, paramInt1, paramLong, paramInt2);
    if (!this.jdField_a_of_type_Qhy.a())
    {
      this.jdField_a_of_type_Qhy.a();
      return;
    }
    j();
    a(paramString1, paramString2);
    this.jdField_a_of_type_Qhw.a(paramString1, paramString2, paramInt1, paramLong, 0L, paramInt2, paramBoolean, true, this.g, paramString3);
  }
  
  public void a(qhw paramqhw)
  {
    if (paramqhw != null) {
      b(paramqhw);
    }
  }
  
  public void a(qmj paramqmj)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramqmj);
  }
  
  public void a(qmo paramqmo)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramqmo);
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = true;
    this.h = paramBoolean;
    this.jdField_a_of_type_Qhw.a(paramBoolean);
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
    return this.jdField_a_of_type_Qhw.a();
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Qhw.a();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "pause: status=" + a());
    }
    if ((g()) || (h()))
    {
      this.jdField_a_of_type_Qhw.h();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((qmo)localIterator.next()).c();
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Qhw.a(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qhw.e(paramBoolean);
  }
  
  public boolean b()
  {
    return (d()) || (e()) || (f()) || (g()) || (h());
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Qhw.b();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "restart: status=" + a());
    }
    if ((f()) || (e()))
    {
      this.jdField_a_of_type_Qhw.g();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((qmo)localIterator.next()).d();
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
      this.jdField_a_of_type_Qhw = a(this.jdField_a_of_type_Qhw);
      if (this.jdField_a_of_type_Qmm != null)
      {
        a(this.jdField_a_of_type_Qmm);
        return;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((qmo)localIterator.next()).a(123, 99, null);
        }
      }
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Qhw.e() == 0;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "stop: ");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((qmo)localIterator.next()).e();
    }
    localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((qmj)localIterator.next()).b(this.jdField_a_of_type_Qhw);
    }
    b(this.jdField_a_of_type_Qhw);
    this.g = false;
    this.jdField_a_of_type_Qmm = null;
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_Qhw.a() != null) {
      this.jdField_a_of_type_Qhw.a().setKeepScreenOn(false);
    }
    this.jdField_a_of_type_Qmn.removeMessages(0);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qhw.d(paramBoolean);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Qhw.e() == 1;
  }
  
  public void e()
  {
    this.jdField_a_of_type_Qhw.c();
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qhw.c(paramBoolean);
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Qhw.e() == 2;
  }
  
  public void f()
  {
    this.jdField_a_of_type_Qhw.d();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Qhw.e() == 5;
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
    return this.jdField_a_of_type_Qhw.e() == 3;
  }
  
  public void h()
  {
    this.c = true;
    if ((this.d) && (e())) {
      a();
    }
    label79:
    for (;;)
    {
      this.e = false;
      this.d = false;
      return;
      if (this.e)
      {
        AppRuntime localAppRuntime = obz.a();
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
    return this.jdField_a_of_type_Qhw.e() == 4;
  }
  
  public void i()
  {
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnDestory: ");
    }
    this.jdField_b_of_type_Boolean = true;
    d();
    this.jdField_a_of_type_Qhw.m();
    if (this.jdField_a_of_type_Qhy != null) {
      this.jdField_a_of_type_Qhy.b();
    }
    this.jdField_a_of_type_Qmn.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qmk
 * JD-Core Version:    0.7.0.1
 */