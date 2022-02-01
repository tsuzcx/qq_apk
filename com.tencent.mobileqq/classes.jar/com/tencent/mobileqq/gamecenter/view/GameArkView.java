package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.ArkView;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;

public class GameArkView
  extends RelativeLayout
  implements ArkViewImplement.LoadCallback, IHeaderView, HippyViewBase
{
  private int jdField_a_of_type_Int = 101;
  private ArkView jdField_a_of_type_ComTencentArkOpenArkView;
  private QQGameMsgInfo jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private String b;
  
  public GameArkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(2131559289, this);
    this.jdField_a_of_type_ComTencentArkOpenArkView = ((ArkView)findViewById(2131374884));
    try
    {
      paramContext = getResources().getDisplayMetrics();
      if (QLog.isColorLevel()) {
        if (" density= " + paramContext == null) {
          break label162;
        }
      }
      label162:
      for (float f = paramContext.density;; f = -1.0F)
      {
        QLog.d("GameArkView", 4, new Object[] { Float.valueOf(f) });
        f = FontSettingManager.systemMetrics.density;
        if (paramContext != null)
        {
          f = Math.min(f, paramContext.density);
          if (QLog.isColorLevel()) {
            QLog.d("GameArkView", 4, "min density= " + f);
          }
          this.jdField_a_of_type_ComTencentArkOpenArkView.setScaleDensity(f);
        }
        return;
      }
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.d("GameArkView", 4, "set ark density fail:" + paramContext.getMessage());
    }
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
        QLog.d("GameArkView", 1, "GameArkView onResume");
      }
      this.jdField_a_of_type_Int = 101;
      this.jdField_a_of_type_ComTencentArkOpenArkView.onResume();
    }
  }
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Context paramContext, int paramInt, String paramString)
  {
    this.b = paramString;
    if (this.jdField_a_of_type_ComTencentArkOpenArkView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo = paramQQGameMsgInfo;
      this.jdField_a_of_type_JavaLangString = paramQQGameMsgInfo.arkAppName;
      this.jdField_a_of_type_ComTencentArkOpenArkView.load(paramQQGameMsgInfo.arkAppName, paramQQGameMsgInfo.arkAppView, paramQQGameMsgInfo.arkAppMinVersion, paramQQGameMsgInfo.arkMetaList, paramQQGameMsgInfo.arkAppConfig, this);
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
        QLog.d("GameArkView", 1, "GameArkView onPause");
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
        QLog.d("GameArkView", 1, "GameArkView onDestory");
      }
      this.jdField_a_of_type_ComTencentArkOpenArkView.onDestroy();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentArkOpenArkView != null) {
      this.jdField_a_of_type_ComTencentArkOpenArkView.onDestroy();
    }
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
  }
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameArkView", 1, "onLoadFailed state=" + paramInt1 + "|errCode=" + paramInt2 + "|errMsg=" + paramString + "|canRetry=" + paramBoolean);
    }
    try
    {
      QQGameHelper.a(this.b).d("76918").c("207984").a(2, this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo.advId).b(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo.gameAppId).a(18, this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo.arkAppName).a(19, paramInt1 + "").a(20, paramInt2 + "").a(21, paramString).a(22, paramBoolean + "").a();
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onLoadState(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameArkView", 1, "onLoadState state=" + paramInt);
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new GameArkView.1(this), 500L);
    try
    {
      QQGameHelper.a(this.b).d("76918").c("207984").a(2, this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo.advId).b(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo.gameAppId).a(18, this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo.arkAppName).a(29, paramInt + "").a();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
  
  public void setPrePause(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameArkView
 * JD-Core Version:    0.7.0.1
 */