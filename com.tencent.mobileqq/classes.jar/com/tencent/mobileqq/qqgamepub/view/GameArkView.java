package com.tencent.mobileqq.qqgamepub.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.ArkView;
import com.tencent.ark.open.ArkView.InitInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class GameArkView
  extends RelativeLayout
  implements ArkViewImplement.LoadCallback, IHeaderView, HippyViewBase
{
  private ArkView a;
  private String b;
  private boolean c = true;
  private long d;
  private int e = 101;
  private QQGameMsgInfo f;
  private String g;
  private boolean h = false;
  private boolean i = true;
  private boolean j = false;
  
  public GameArkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(2131624905, this);
    this.a = ((ArkView)findViewById(2131442586));
    for (;;)
    {
      try
      {
        paramContext = getResources().getDisplayMetrics();
        if (QLog.isColorLevel())
        {
          paramAttributeSet = new StringBuilder();
          paramAttributeSet.append(" density= ");
          paramAttributeSet.append(paramContext);
          if (paramAttributeSet.toString() == null) {
            break label228;
          }
          f1 = paramContext.density;
          QLog.d("QQGamePub_GameArkView", 4, new Object[] { Float.valueOf(f1) });
        }
        f1 = FontSettingManager.systemMetrics.density;
        if (paramContext != null)
        {
          f1 = Math.min(f1, paramContext.density);
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("min density= ");
            paramContext.append(f1);
            QLog.d("QQGamePub_GameArkView", 4, paramContext.toString());
          }
          this.a.setScaleDensity(f1);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        paramAttributeSet = new StringBuilder();
        paramAttributeSet.append("set ark density fail:");
        paramAttributeSet.append(paramContext.getMessage());
        QLog.d("QQGamePub_GameArkView", 4, paramAttributeSet.toString());
      }
      return;
      label228:
      float f1 = -1.0F;
    }
  }
  
  private void g()
  {
    try
    {
      if ((this.a != null) && (GamePubAccountHelper.f(this.b)) && (this.c)) {
        this.a.onPause();
      }
      if (this.h)
      {
        f();
        this.h = false;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->onLoadState init arkview faile:");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.e("QQGamePub_GameArkView", 1, localStringBuilder.toString());
    }
  }
  
  private void h()
  {
    b();
    ThreadManagerV2.getUIHandlerV2().postDelayed(new GameArkView.2(this), 50L);
  }
  
  public void a()
  {
    if (this.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePub_GameArkView", 1, "GameArkView onResume");
      }
      this.e = 101;
      this.a.onResume();
    }
  }
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Context paramContext, int paramInt, String paramString)
  {
    this.g = paramString;
    if (this.a != null)
    {
      this.f = paramQQGameMsgInfo;
      this.b = paramQQGameMsgInfo.arkAppName;
      paramContext = new ArkView.InitInfo();
      paramContext.appID = paramQQGameMsgInfo.arkAppName;
      paramContext.view = paramQQGameMsgInfo.arkAppView;
      paramContext.minVersion = paramQQGameMsgInfo.arkAppMinVersion;
      paramContext.meta = paramQQGameMsgInfo.arkMetaList;
      paramContext.config = paramQQGameMsgInfo.arkAppConfig;
      if (!TextUtils.isEmpty(paramQQGameMsgInfo.loadArkResPath))
      {
        paramString = new StringBuilder();
        paramString.append(paramQQGameMsgInfo.loadArkResPath);
        paramString.append(this.b);
        paramContext.resPath = paramString.toString();
      }
      this.a.load(paramContext, this);
      this.d = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel())
      {
        paramQQGameMsgInfo = new StringBuilder();
        paramQQGameMsgInfo.append("init...mPubType:");
        paramQQGameMsgInfo.append(this.g);
        paramQQGameMsgInfo.append(",appName:");
        paramQQGameMsgInfo.append(this.b);
        paramQQGameMsgInfo.append(",loadArkResPath:");
        paramQQGameMsgInfo.append(paramContext.resPath);
        paramQQGameMsgInfo.append(",process:");
        paramQQGameMsgInfo.append(MobileQQ.processName);
        paramQQGameMsgInfo.append(",mInitStartTime:");
        paramQQGameMsgInfo.append(this.d);
        QLog.i("QQGamePub_GameArkView", 2, paramQQGameMsgInfo.toString());
      }
    }
  }
  
  public void b()
  {
    if (this.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePub_GameArkView", 1, "GameArkView onPause");
      }
      this.e = 102;
      this.a.onPause();
    }
  }
  
  public void c()
  {
    if (this.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePub_GameArkView", 1, "GameArkView onDestory");
      }
      this.a.onDestroy();
    }
  }
  
  public boolean d()
  {
    return this.e == 101;
  }
  
  public void e()
  {
    ArkView localArkView = this.a;
    if (localArkView != null) {
      localArkView.onDestroy();
    }
  }
  
  public void f()
  {
    this.h = true;
    if (!this.j)
    {
      QLog.d("QQGamePub_GameArkView", 1, "not callArKExposure,because ark is not loaded");
      return;
    }
    if (this.i)
    {
      h();
      this.i = false;
    }
  }
  
  public String getAppName()
  {
    return this.b;
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
  }
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onLoadFailed state=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("|errCode=");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append("|errMsg=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("|canRetry=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("QQGamePub_GameArkView", 1, ((StringBuilder)localObject1).toString());
    }
    if (this.f != null)
    {
      long l = SystemClock.elapsedRealtime() - this.d;
      Object localObject2 = GamePubAccountHelper.c(this.g).d("76918").c("207984").a(2, this.f.advId).b(this.f.gameAppId);
      if (l > 0L) {
        localObject1 = String.valueOf(l);
      } else {
        localObject1 = "";
      }
      localObject1 = ((WadlReportBuilder)localObject2).a(17, (String)localObject1).a(18, this.f.arkAppName);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("");
      localObject1 = ((WadlReportBuilder)localObject1).a(19, ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("");
      paramString = ((WadlReportBuilder)localObject1).a(20, ((StringBuilder)localObject2).toString()).a(21, paramString);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append("");
      paramString.a(22, ((StringBuilder)localObject1).toString()).a();
    }
  }
  
  public void onLoadState(int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onLoadState state=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("QQGamePub_GameArkView", 1, ((StringBuilder)localObject1).toString());
    }
    this.j = true;
    ThreadManagerV2.getUIHandlerV2().postDelayed(new GameArkView.1(this), 500L);
    if (this.f != null)
    {
      long l = SystemClock.elapsedRealtime() - this.d;
      Object localObject2 = GamePubAccountHelper.c(this.g).d("76918").c("207984").a(2, this.f.advId).b(this.f.gameAppId);
      if (l > 0L) {
        localObject1 = String.valueOf(l);
      } else {
        localObject1 = "";
      }
      localObject1 = ((WadlReportBuilder)localObject2).a(17, (String)localObject1).a(18, this.f.arkAppName);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("");
      ((WadlReportBuilder)localObject1).a(19, ((StringBuilder)localObject2).toString()).a();
    }
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
  
  public void setPrePause(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GameArkView
 * JD-Core Version:    0.7.0.1
 */