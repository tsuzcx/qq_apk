package com.tencent.mobileqq.gamecenter.view;

import actn;
import adll;
import adlp;
import alta;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import aqsx;
import com.tencent.TMG.utils.QLog;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;

public class ArkHeaderView
  extends ArkAppView
  implements aqsx
{
  private adll jdField_a_of_type_Adll;
  private String jdField_a_of_type_JavaLangString;
  
  public ArkHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Adll != null) {
      this.jdField_a_of_type_Adll.doOnEvent(2);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, Activity paramActivity)
  {
    paramMessageRecord = (MessageForArkApp)paramMessageRecord;
    this.jdField_a_of_type_Adll = new adll();
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_JavaLangString = "2747277822";
    this.jdField_a_of_type_Adll.a(paramMessageRecord.ark_app_message.appName, paramMessageRecord.ark_app_message.appView, paramMessageRecord.ark_app_message.appMinVersion, paramMessageRecord.ark_app_message.metaList, paramActivity.getResources().getDisplayMetrics().scaledDensity, localSessionInfo);
    int i = actn.a(350.0F, paramActivity.getResources());
    int j = alta.d;
    this.jdField_a_of_type_Adll.setMaxSize(j, i);
    setClipRadius(5.0F);
    a(this.jdField_a_of_type_Adll, null);
    setVisibility(0);
    try
    {
      this.jdField_a_of_type_JavaLangString = paramMessageRecord.ark_app_message.mSourceName;
      return;
    }
    catch (Throwable paramMessageRecord)
    {
      QLog.e("ArkHeaderView", 1, "parse meta error =" + paramMessageRecord.toString());
    }
  }
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Activity paramActivity)
  {
    this.jdField_a_of_type_Adll = new adll();
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_JavaLangString = "2747277822";
    this.jdField_a_of_type_Adll.a(paramQQGameMsgInfo.arkAppName, paramQQGameMsgInfo.arkAppView, paramQQGameMsgInfo.arkAppMinVersion, paramQQGameMsgInfo.arkMetaList, paramActivity.getResources().getDisplayMetrics().scaledDensity, localSessionInfo);
    int i = actn.a(350.0F, paramActivity.getResources());
    int j = alta.d;
    this.jdField_a_of_type_Adll.setMaxSize(j, i);
    this.jdField_a_of_type_Adll.setFixSize(j, i);
    setClipRadius(5.0F);
    a(this.jdField_a_of_type_Adll, null);
    setVisibility(0);
    try
    {
      this.jdField_a_of_type_JavaLangString = paramQQGameMsgInfo.gameAppId;
      return;
    }
    catch (Throwable paramQQGameMsgInfo)
    {
      QLog.e("ArkHeaderView", 1, "parse meta error =" + paramQQGameMsgInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.ArkHeaderView
 * JD-Core Version:    0.7.0.1
 */