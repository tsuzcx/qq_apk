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
  private int jdField_a_of_type_Int = 101;
  private long jdField_a_of_type_Long;
  private ArkView jdField_a_of_type_ComTencentArkOpenArkView;
  private QQGameMsgInfo jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = true;
  private boolean d = false;
  
  public GameArkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(2131559150, this);
    this.jdField_a_of_type_ComTencentArkOpenArkView = ((ArkView)findViewById(2131374419));
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
          f = paramContext.density;
          QLog.d("QQGamePub_GameArkView", 4, new Object[] { Float.valueOf(f) });
        }
        f = FontSettingManager.systemMetrics.density;
        if (paramContext != null)
        {
          f = Math.min(f, paramContext.density);
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("min density= ");
            paramContext.append(f);
            QLog.d("QQGamePub_GameArkView", 4, paramContext.toString());
          }
          this.jdField_a_of_type_ComTencentArkOpenArkView.setScaleDensity(f);
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
      float f = -1.0F;
    }
  }
  
  private void f()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentArkOpenArkView != null) && (GamePubAccountHelper.a(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentArkOpenArkView.onPause();
      }
      if (this.jdField_b_of_type_Boolean)
      {
        e();
        this.jdField_b_of_type_Boolean = false;
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
  
  private void g()
  {
    b();
    ThreadManagerV2.getUIHandlerV2().postDelayed(new GameArkView.2(this), 50L);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentArkOpenArkView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePub_GameArkView", 1, "GameArkView onResume");
      }
      this.jdField_a_of_type_Int = 101;
      this.jdField_a_of_type_ComTencentArkOpenArkView.onResume();
    }
  }
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Context paramContext, int paramInt, String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_ComTencentArkOpenArkView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo = paramQQGameMsgInfo;
      this.jdField_a_of_type_JavaLangString = paramQQGameMsgInfo.arkAppName;
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
        paramString.append(this.jdField_a_of_type_JavaLangString);
        paramContext.resPath = paramString.toString();
      }
      this.jdField_a_of_type_ComTencentArkOpenArkView.load(paramContext, this);
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel())
      {
        paramQQGameMsgInfo = new StringBuilder();
        paramQQGameMsgInfo.append("init...mPubType:");
        paramQQGameMsgInfo.append(this.jdField_b_of_type_JavaLangString);
        paramQQGameMsgInfo.append(",appName:");
        paramQQGameMsgInfo.append(this.jdField_a_of_type_JavaLangString);
        paramQQGameMsgInfo.append(",loadArkResPath:");
        paramQQGameMsgInfo.append(paramContext.resPath);
        paramQQGameMsgInfo.append(",process:");
        paramQQGameMsgInfo.append(MobileQQ.processName);
        paramQQGameMsgInfo.append(",mInitStartTime:");
        paramQQGameMsgInfo.append(this.jdField_a_of_type_Long);
        QLog.i("QQGamePub_GameArkView", 2, paramQQGameMsgInfo.toString());
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 101;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentArkOpenArkView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePub_GameArkView", 1, "GameArkView onPause");
      }
      this.jdField_a_of_type_Int = 102;
      this.jdField_a_of_type_ComTencentArkOpenArkView.onPause();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentArkOpenArkView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePub_GameArkView", 1, "GameArkView onDestory");
      }
      this.jdField_a_of_type_ComTencentArkOpenArkView.onDestroy();
    }
  }
  
  public void d()
  {
    ArkView localArkView = this.jdField_a_of_type_ComTencentArkOpenArkView;
    if (localArkView != null) {
      localArkView.onDestroy();
    }
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = true;
    if (!this.d)
    {
      QLog.d("QQGamePub_GameArkView", 1, "not callArKExposure,because ark is not loaded");
      return;
    }
    if (this.c)
    {
      g();
      this.c = false;
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo != null)
    {
      long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
      Object localObject2 = GamePubAccountHelper.a(this.jdField_b_of_type_JavaLangString).d("76918").c("207984").a(2, this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo.advId).b(this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo.gameAppId);
      if (l > 0L) {
        localObject1 = String.valueOf(l);
      } else {
        localObject1 = "";
      }
      localObject1 = ((WadlReportBuilder)localObject2).a(17, (String)localObject1).a(18, this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo.arkAppName);
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
    this.d = true;
    ThreadManagerV2.getUIHandlerV2().postDelayed(new GameArkView.1(this), 500L);
    if (this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo != null)
    {
      long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
      Object localObject2 = GamePubAccountHelper.a(this.jdField_b_of_type_JavaLangString).d("76918").c("207984").a(2, this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo.advId).b(this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo.gameAppId);
      if (l > 0L) {
        localObject1 = String.valueOf(l);
      } else {
        localObject1 = "";
      }
      localObject1 = ((WadlReportBuilder)localObject2).a(17, (String)localObject1).a(18, this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo.arkAppName);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("");
      ((WadlReportBuilder)localObject1).a(19, ((StringBuilder)localObject2).toString()).a();
    }
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
  
  public void setPrePause(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GameArkView
 * JD-Core Version:    0.7.0.1
 */