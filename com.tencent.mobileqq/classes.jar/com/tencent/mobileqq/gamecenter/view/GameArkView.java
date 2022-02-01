package com.tencent.mobileqq.gamecenter.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import avfh;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.ArkView;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.qphone.base.util.QLog;

public class GameArkView
  extends RelativeLayout
  implements avfh, ArkViewImplement.LoadCallback
{
  private int jdField_a_of_type_Int = 101;
  private ArkView jdField_a_of_type_ComTencentArkOpenArkView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  
  public GameArkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(2131559252, this);
    this.jdField_a_of_type_ComTencentArkOpenArkView = ((ArkView)findViewById(2131374514));
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
  
  public void a(MessageRecord paramMessageRecord, Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentArkOpenArkView != null)
    {
      paramMessageRecord = (MessageForArkApp)paramMessageRecord;
      if (paramMessageRecord != null)
      {
        this.jdField_a_of_type_JavaLangString = paramMessageRecord.ark_app_message.appName;
        this.jdField_a_of_type_ComTencentArkOpenArkView.load(paramMessageRecord.ark_app_message.appName, paramMessageRecord.ark_app_message.appView, paramMessageRecord.ark_app_message.appMinVersion, paramMessageRecord.ark_app_message.metaList, paramMessageRecord.ark_app_message.config, this);
      }
    }
  }
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Activity paramActivity, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentArkOpenArkView != null)
    {
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
    if (this.jdField_a_of_type_ComTencentArkOpenArkView != null) {
      this.jdField_a_of_type_ComTencentArkOpenArkView.onDestroy();
    }
  }
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameArkView", 4, "onLoadFailed() called with: i = [" + paramInt1 + "], i1 = [" + paramInt2 + "], s = [" + paramString + "], b = [" + paramBoolean + "]");
    }
  }
  
  public void onLoadState(int paramInt)
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new GameArkView.1(this), 500L);
  }
  
  public void setCurArkState(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setPrePause(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameArkView
 * JD-Core Version:    0.7.0.1
 */