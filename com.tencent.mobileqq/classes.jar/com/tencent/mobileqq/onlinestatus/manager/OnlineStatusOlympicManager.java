package com.tencent.mobileqq.onlinestatus.manager;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.onlinestatus.OlympicStatusResDownloader;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.mobileqq.onlinestatus.olympic.model.OlympicMedalEventInfo;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusSPUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;

public class OnlineStatusOlympicManager
  implements IOnlineStatusOlympicManager
{
  private AppInterface a;
  private OlympicMedalEventInfo b = null;
  private OlympicStatusResDownloader c;
  private LottieDrawable d;
  private long e = -1L;
  private int f = -1;
  private Handler g = new OnlineStatusOlympicManager.1(this, ThreadManagerV2.getSubThreadLooper());
  private D8SafeAnimatorListener h = new OnlineStatusOlympicManager.2(this);
  
  public OnlineStatusOlympicManager(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
  }
  
  private void b(View paramView)
  {
    if (!g())
    {
      QLog.d("OnlineStatusOlympicManager", 1, "version too low not surpport lottie");
      return;
    }
    LottieDrawable localLottieDrawable = this.d;
    if (localLottieDrawable == null)
    {
      c(paramView);
      return;
    }
    if (localLottieDrawable.isRunning()) {
      this.d.stop();
    }
    this.f = this.b.b();
    ((ImageView)paramView).setImageDrawable(this.d);
    this.d.start();
  }
  
  private boolean b(OlympicMedalEventInfo paramOlympicMedalEventInfo)
  {
    if ((paramOlympicMedalEventInfo != null) && (paramOlympicMedalEventInfo.a()) && (c(paramOlympicMedalEventInfo)))
    {
      long l = System.currentTimeMillis() / 1000L;
      if ((l < paramOlympicMedalEventInfo.d()) && ((this.b == null) || (l < paramOlympicMedalEventInfo.d())))
      {
        QLog.d("OnlineStatusOlympicManager", 1, "NeedPlayDynamicImage.");
        return true;
      }
      return false;
    }
    paramOlympicMedalEventInfo = new StringBuilder();
    paramOlympicMedalEventInfo.append("checkIsNeedPlayDynamicImage valid .");
    paramOlympicMedalEventInfo.append(this.b);
    QLog.d("OnlineStatusOlympicManager", 1, paramOlympicMedalEventInfo.toString());
    return false;
  }
  
  private void c(View paramView)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(OlympicStatusResDownloader.b());
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append("aio/animation/data.json");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(OlympicStatusResDownloader.b());
    ((StringBuilder)localObject2).append("/");
    ((StringBuilder)localObject2).append("aio/animation/images/");
    localObject2 = ((StringBuilder)localObject2).toString();
    if ((FileUtils.fileExistsAndNotEmpty((String)localObject1)) && (FileUtils.fileExistsAndNotEmpty((String)localObject2)))
    {
      int i = this.b.b();
      LottieHelper.a(this.a.getApplicationContext(), (String)localObject1, (String)localObject2, paramView.getWidth(), paramView.getHeight(), new OnlineStatusOlympicManager.3(this, i, paramView));
      return;
    }
    paramView = new StringBuilder();
    paramView.append("loadAndPlayOlympicLottie failed. animJsonPath=");
    paramView.append((String)localObject1);
    paramView.append(" animImageDirPath=");
    paramView.append((String)localObject2);
    QLog.e("OnlineStatusOlympicManager", 1, paramView.toString());
  }
  
  private boolean c(OlympicMedalEventInfo paramOlympicMedalEventInfo)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramOlympicMedalEventInfo != null)
    {
      bool1 = bool2;
      if (this.b != null)
      {
        if ((paramOlympicMedalEventInfo.c() >= this.b.c()) && (paramOlympicMedalEventInfo.d() >= this.b.d())) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private void e()
  {
    ((OnlineStatusHandler)this.a.getBusinessHandler(OnlineStatusHandler.class.getName())).notifyUI(8, true, this.b);
  }
  
  private void f()
  {
    LottieDrawable localLottieDrawable = this.d;
    if ((localLottieDrawable != null) && (localLottieDrawable.isRunning())) {
      this.d.stop();
    }
  }
  
  private boolean g()
  {
    return Build.VERSION.SDK_INT > 24;
  }
  
  public void a()
  {
    if (this.c == null) {
      this.c = new OlympicStatusResDownloader();
    }
    this.c.a(this.a);
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
    {
      QLog.d("OnlineStatusOlympicManager", 1, "openH5 fail");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("url", paramString);
    RouteUtils.a(paramActivity, localIntent, "/base/browser");
  }
  
  public void a(OlympicMedalEventInfo paramOlympicMedalEventInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateOlympicMedalEventInfo ");
    ((StringBuilder)localObject).append(paramOlympicMedalEventInfo);
    ((StringBuilder)localObject).append(" curInfo=");
    ((StringBuilder)localObject).append(this.b);
    QLog.d("OnlineStatusOlympicManager", 1, ((StringBuilder)localObject).toString(), new Throwable("打印堆栈"));
    if (paramOlympicMedalEventInfo != null)
    {
      int i = paramOlympicMedalEventInfo.e();
      if (i > 0)
      {
        localObject = this.g.obtainMessage();
        ((Message)localObject).what = 0;
        this.g.removeMessages(0);
        this.g.sendMessageDelayed((Message)localObject, i * 1000);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MSG_GET_OLYMPIC_MEDAL_EVENT  ");
        ((StringBuilder)localObject).append(i);
        QLog.d("OnlineStatusOlympicManager", 1, ((StringBuilder)localObject).toString());
      }
      if ((this.b != null) && (paramOlympicMedalEventInfo.b() == this.b.b())) {
        return;
      }
      boolean bool = b(paramOlympicMedalEventInfo);
      if (!bool)
      {
        localObject = this.b;
        if (localObject != null)
        {
          ((OlympicMedalEventInfo)localObject).a(paramOlympicMedalEventInfo);
          break label263;
        }
      }
      this.b = paramOlympicMedalEventInfo;
      if (bool)
      {
        e();
        localObject = this.g.obtainMessage();
        ((Message)localObject).what = 1;
        this.g.removeMessages(1);
        this.g.sendMessageDelayed((Message)localObject, paramOlympicMedalEventInfo.d() * 1000L - System.currentTimeMillis());
      }
      label263:
      OnLineStatusHelper.a().a(this.b);
    }
  }
  
  public boolean a(View paramView)
  {
    long l = System.currentTimeMillis() / 1000L;
    int i = OnlineStatusSPUtil.c(this.a.getApplicationContext());
    OlympicMedalEventInfo localOlympicMedalEventInfo = this.b;
    boolean bool;
    if ((localOlympicMedalEventInfo != null) && (localOlympicMedalEventInfo.d() > l) && (i != this.b.b()) && (l - this.e >= 5L)) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      b(paramView);
      return bool;
    }
    f();
    return bool;
  }
  
  boolean b()
  {
    String str = ((IMessageFacade)this.a.getRuntimeService(IMessageFacade.class, "")).getCurrChatUin();
    boolean bool;
    if ((str != null) && (!str.equals(this.a.getCurrentAccountUin()))) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMessage getOlympicMedalEvent isAioShown=");
    localStringBuilder.append(bool);
    localStringBuilder.append(" currentChatUin=");
    localStringBuilder.append(str);
    QLog.d("OnlineStatusOlympicManager", 1, localStringBuilder.toString());
    return bool;
  }
  
  public void c()
  {
    this.b = null;
    this.g.removeMessages(0);
    OnLineStatusHelper.a().a(null);
    OlympicStatusResDownloader localOlympicStatusResDownloader = this.c;
    if (localOlympicStatusResDownloader != null) {
      localOlympicStatusResDownloader.a();
    }
  }
  
  public void d()
  {
    LottieDrawable localLottieDrawable = this.d;
    if ((localLottieDrawable != null) && (localLottieDrawable.isRunning())) {
      this.d.cancelAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.OnlineStatusOlympicManager
 * JD-Core Version:    0.7.0.1
 */