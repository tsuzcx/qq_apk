package com.tencent.mobileqq.gamecenter.view;

import afvi;
import afvm;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import atzp;
import com.tencent.TMG.utils.QLog;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;

public class ArkHeaderView
  extends ArkAppView
  implements atzp
{
  private afvi jdField_a_of_type_Afvi;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public ArkHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Afvi != null) {
      this.jdField_a_of_type_Afvi.doOnEvent(1);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, Activity paramActivity)
  {
    paramMessageRecord = (MessageForArkApp)paramMessageRecord;
    this.jdField_a_of_type_Afvi = new afvi();
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.curFriendUin = "2747277822";
    this.b = paramMessageRecord.ark_app_message.appName;
    this.jdField_a_of_type_Afvi.a(paramMessageRecord.ark_app_message.appName, paramMessageRecord.ark_app_message.appView, paramMessageRecord.ark_app_message.appMinVersion, paramMessageRecord.ark_app_message.metaList, paramActivity.getResources().getDisplayMetrics().scaledDensity, localSessionInfo);
    int i = AIOUtils.dp2px(350.0F, paramActivity.getResources());
    int j = ArkAppCenterUtil.sRealDisplayWith;
    this.jdField_a_of_type_Afvi.setMaxSize(j, i);
    setClipRadius(5.0F);
    a(this.jdField_a_of_type_Afvi, null);
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
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_Afvi = new afvi();
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.curFriendUin = "2747277822";
    this.jdField_a_of_type_Afvi.a(paramQQGameMsgInfo.arkAppName, paramQQGameMsgInfo.arkAppView, paramQQGameMsgInfo.arkAppMinVersion, paramQQGameMsgInfo.arkMetaList, paramActivity.getResources().getDisplayMetrics().scaledDensity, localSessionInfo);
    paramInt = AIOUtils.dp2px(350.0F, paramActivity.getResources());
    int i = ArkAppCenterUtil.sRealDisplayWith;
    this.jdField_a_of_type_Afvi.setMaxSize(i, paramInt);
    this.jdField_a_of_type_Afvi.setFixSize(i, paramInt);
    setClipRadius(5.0F);
    a(this.jdField_a_of_type_Afvi, null);
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
  
  public void b()
  {
    if (this.jdField_a_of_type_Afvi != null) {
      this.jdField_a_of_type_Afvi.doOnEvent(0);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Afvi != null) {
      this.jdField_a_of_type_Afvi.doOnEvent(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.ArkHeaderView
 * JD-Core Version:    0.7.0.1
 */