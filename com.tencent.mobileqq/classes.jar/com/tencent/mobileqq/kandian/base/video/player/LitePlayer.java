package com.tencent.mobileqq.kandian.base.video.player;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.ThreadUtil;
import com.tencent.mobileqq.kandian.base.video.VideoPlayUtils;
import com.tencent.mobileqq.kandian.base.video.plugin.OnVideoPluginInstallListener;
import com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class LitePlayer
  implements OnVideoPluginInstallListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  @NonNull
  protected Context a;
  @NonNull
  protected ViewGroup a;
  private LitePlayer.MediaPlayListenerAdapterImpl jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$MediaPlayListenerAdapterImpl;
  @Nullable
  private LitePlayer.PlayParams jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$PlayParams;
  private LitePlayer.UiHandler jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$UiHandler;
  @NonNull
  protected VideoPlayerWrapper a;
  private VideoPluginInstall jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall;
  private final String jdField_a_of_type_JavaLangString;
  private List<PlayerStatusListener> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<IPlayerReporter> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  
  @UiThread
  public LitePlayer(Context paramContext, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LitePlayer<");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    localStringBuilder.append(">");
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.d = false;
    this.e = false;
    this.f = false;
    this.g = false;
    this.h = true;
    this.i = false;
    this.j = false;
    this.k = false;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 100;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$MediaPlayListenerAdapterImpl = new LitePlayer.MediaPlayListenerAdapterImpl(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$UiHandler = new LitePlayer.UiHandler(this);
    this.jdField_b_of_type_JavaLangString = paramString;
    this.l = paramBoolean;
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall = new VideoPluginInstall();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall.a(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper = a();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    paramBoolean = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall.a();
    if (QLog.isColorLevel())
    {
      paramContext = this.jdField_a_of_type_JavaLangString;
      paramString = new StringBuilder();
      paramString.append("LitePlayer: isPluginInstalled=");
      paramString.append(paramBoolean);
      QLog.d(paramContext, 2, paramString.toString());
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall.a();
    }
  }
  
  @UiThread
  private VideoPlayerWrapper a()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = new VideoPlayerWrapper(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_b_of_type_JavaLangString);
    localVideoPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$MediaPlayListenerAdapterImpl);
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    localVideoPlayerWrapper.a(this.jdField_a_of_type_AndroidViewViewGroup, TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString) ^ true, this.l);
    View localView = localVideoPlayerWrapper.a();
    if (localView != null)
    {
      localView.setId(2131376064);
      this.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    }
    localVideoPlayerWrapper.a(this.k);
    localVideoPlayerWrapper.c(this.j);
    localVideoPlayerWrapper.e(this.h);
    localVideoPlayerWrapper.a(this.jdField_a_of_type_Float);
    localVideoPlayerWrapper.d(this.i);
    localVideoPlayerWrapper.b(this.jdField_a_of_type_Int);
    return localVideoPlayerWrapper;
  }
  
  private void a(LitePlayer.PlayParams paramPlayParams)
  {
    if (TextUtils.isEmpty(paramPlayParams.jdField_b_of_type_JavaLangString))
    {
      a(paramPlayParams.jdField_a_of_type_JavaLangString, paramPlayParams.jdField_a_of_type_Int, paramPlayParams.jdField_a_of_type_Long);
      return;
    }
    a(paramPlayParams.jdField_a_of_type_JavaLangString, paramPlayParams.jdField_b_of_type_JavaLangString, paramPlayParams.jdField_a_of_type_Int, paramPlayParams.jdField_a_of_type_Long, paramPlayParams.jdField_b_of_type_Int);
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
  
  private void a(boolean paramBoolean1, String paramString1, String paramString2, String paramString3, boolean paramBoolean2, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openByUrl: vid=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", url=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", playType=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", startPosition=");
      localStringBuilder.append(paramLong);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$MediaPlayListenerAdapterImpl.a(null, 201, 109, 0, "player had destoryed", null);
      return;
    }
    if ((paramBoolean1) && (TextUtils.isEmpty(paramString2)))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$MediaPlayListenerAdapterImpl.a(null, 201, 61, 0, "url null", null);
      return;
    }
    if ((!paramBoolean1) && (TextUtils.isEmpty(paramString1)))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$MediaPlayListenerAdapterImpl.a(null, 201, 61, 0, "vid null", null);
      return;
    }
    if (a(paramLong)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$PlayParams = new LitePlayer.PlayParams(this, paramString1, paramString2, paramInt1, paramLong, paramInt2);
    if (!this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall.a();
      return;
    }
    n();
    b(paramString1, paramString2);
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a(paramString1, paramString2, paramInt1, paramLong, 0L, paramInt2, paramBoolean2, true, this.g, paramString3);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a(paramString1, paramInt1, paramLong, this.g);
  }
  
  private boolean a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$PlayParams != null) && (this.g) && (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a() == this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$PlayParams))
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkPreload: status=");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.b());
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$PlayParams.jdField_a_of_type_Long = paramLong;
      if ((!f()) && (!g()) && (!i()))
      {
        if ((!c()) && (!d()))
        {
          this.g = false;
          if (QLog.isColorLevel())
          {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: checkPreload player was preload but status error");
            return false;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: prePlaying, just do nothing ");
          }
          localObject = this.jdField_b_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((IPlayerReporter)((Iterator)localObject).next()).a(false);
          }
          this.g = false;
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.k();
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.p();
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$UiHandler.sendEmptyMessageDelayed(1, 10000L);
          return true;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: hasPrePlay, just go onVideoPrepared");
        }
        localObject = this.jdField_b_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((IPlayerReporter)((Iterator)localObject).next()).a(true);
        }
        localObject = this.jdField_b_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((IPlayerReporter)((Iterator)localObject).next()).b(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper);
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.k();
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.p();
        o();
        return true;
      }
    }
    return false;
  }
  
  private void b(LitePlayer.PlayParams paramPlayParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a(paramPlayParams);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$UiHandler.removeMessages(1);
  }
  
  private void b(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (paramVideoPlayerWrapper == null) {
      return;
    }
    paramVideoPlayerWrapper.n();
    if (!paramVideoPlayerWrapper.j())
    {
      if (paramVideoPlayerWrapper.i()) {
        return;
      }
      paramVideoPlayerWrapper.j();
      ThreadManager.excute(new LitePlayer.6(this, paramVideoPlayerWrapper), 16, null, true);
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IPlayerReporter)localIterator.next()).a(paramString1, paramString2, this.g, this.k);
    }
    paramString1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString1.hasNext()) {
      ((PlayerStatusListener)paramString1.next()).onVideoOpen();
    }
    b(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$PlayParams);
  }
  
  private void n()
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkPlayer: tag=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a() != null) || (!this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.j()))
    {
      b(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.l();
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper = a();
    }
  }
  
  private void o()
  {
    this.g = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$UiHandler.removeMessages(1);
    if (this.jdField_c_of_type_Boolean)
    {
      c();
      LitePlayer.PlayParams localPlayParams = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$PlayParams;
      if ((localPlayParams != null) && (localPlayParams.jdField_a_of_type_Long / 1000L != this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a() / 1000L)) {
        b((int)(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$PlayParams.jdField_a_of_type_Long / 1000L));
      }
    }
    else
    {
      this.d = true;
    }
  }
  
  private void p()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
    if (((VideoPlayerWrapper)localObject).f())
    {
      long l1 = ((VideoPlayerWrapper)localObject).a();
      if (l1 >= ((VideoPlayerWrapper)localObject).b() - 500L)
      {
        this.f = true;
      }
      else if ((l1 >= 0L) && (this.f) && (((VideoPlayerWrapper)localObject).m()))
      {
        if (QLog.isColorLevel())
        {
          String str = this.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onVideoReplayOnLoop: pos=");
          localStringBuilder.append(l1);
          QLog.d(str, 2, localStringBuilder.toString());
        }
        this.f = false;
        this.jdField_b_of_type_Int += 1;
        ((VideoPlayerWrapper)localObject).m();
        localObject = this.jdField_a_of_type_JavaUtilList;
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            ((PlayerStatusListener)((Iterator)localObject).next()).onVideoEnd(this.jdField_b_of_type_Int);
          }
        }
      }
      localObject = this.jdField_a_of_type_JavaUtilList;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((PlayerStatusListener)((Iterator)localObject).next()).onProgressChanged(l1);
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.b();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.b();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.c();
  }
  
  public Map<String, String> a()
  {
    return VideoPlayUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper);
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("replay: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$PlayParams);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    b(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$PlayParams;
    if (localObject != null) {
      a((LitePlayer.PlayParams)localObject);
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.b(paramInt);
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$MediaPlayListenerAdapterImpl.a(null, paramInt1, paramInt2, paramInt3, paramString, null);
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
  
  public void a(IPlayerReporter paramIPlayerReporter)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramIPlayerReporter);
  }
  
  public void a(PlayerStatusListener paramPlayerStatusListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramPlayerStatusListener);
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (paramVideoPlayerWrapper != null) {
      b(paramVideoPlayerWrapper);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a(paramString);
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$UiHandler.removeMessages(0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$UiHandler.sendEmptyMessage(0);
    b(new LitePlayer.PlayParams(this, paramString1, paramString2, 0, 0L, 0));
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2)
  {
    a(paramString1, paramString2, null, true, paramInt1, paramLong, paramInt2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    a(new LitePlayer.2(this, paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramLong, paramInt2));
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInstallComplete: success=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", mHasDestory=");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper = a();
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$PlayParams;
      if (localObject != null) {
        a((LitePlayer.PlayParams)localObject);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((PlayerStatusListener)((Iterator)localObject).next()).onVideoError(123, 99, null);
      }
    }
  }
  
  public boolean a()
  {
    return this.g;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.c();
  }
  
  public long b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = true;
    this.k = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a(paramBoolean);
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startPreload: coverFrame=");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$PlayParams != null) && ((d()) || (f()) || (g()) || (h()) || (i()));
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.d();
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start: status=");
      localStringBuilder.append(a());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PlayerStatusListener)((Iterator)localObject).next()).beforeVideoStart();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.d();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$UiHandler.removeMessages(0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$UiHandler.sendEmptyMessage(0);
    ThreadUtil.a(new LitePlayer.3(this));
    localObject = this.jdField_b_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IPlayerReporter)((Iterator)localObject).next()).a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper);
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.e(paramBoolean);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a();
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pause: status=");
      localStringBuilder.append(a());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((h()) || (i()))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.f();
      ThreadUtil.a(new LitePlayer.4(this));
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.i = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.d(paramBoolean);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.b();
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("restart: status=");
      localStringBuilder.append(a());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((g()) || (f()))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.e();
      ThreadUtil.a(new LitePlayer.5(this));
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.j = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.c(paramBoolean);
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.c();
  }
  
  public void f()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stop: mPlayParam=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$PlayParams);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$PlayParams != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((PlayerStatusListener)((Iterator)localObject).next()).onVideoStop();
      }
      localObject = this.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IPlayerReporter)((Iterator)localObject).next()).a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper, this.jdField_b_of_type_Int);
      }
    }
    b(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper);
    this.g = false;
    this.h = true;
    this.i = false;
    this.j = false;
    this.k = false;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$PlayParams = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$UiHandler.removeMessages(0);
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.d();
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a();
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.e();
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.b();
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.f();
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.o();
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.g();
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$MediaPlayListenerAdapterImpl.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper, null);
  }
  
  public void k()
  {
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnPause() isPlaying()=");
      localStringBuilder.append(h());
      QLog.d(str, 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onResume: ");
    }
    if ((this.d) && (f()))
    {
      o();
    }
    else if (this.e)
    {
      AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.a();
      boolean bool;
      if ((localAppRuntime instanceof QQAppInterface)) {
        bool = ((QQAppInterface)localAppRuntime).isVideoChatting();
      } else {
        bool = false;
      }
      if (!bool)
      {
        this.jdField_a_of_type_Boolean = true;
        e();
      }
    }
    this.e = false;
    this.d = false;
  }
  
  public void m()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnDestory: ");
    }
    f();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.l();
    VideoPluginInstall localVideoPluginInstall = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall;
    if (localVideoPluginInstall != null) {
      localVideoPluginInstall.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerLitePlayer$UiHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.LitePlayer
 * JD-Core Version:    0.7.0.1
 */