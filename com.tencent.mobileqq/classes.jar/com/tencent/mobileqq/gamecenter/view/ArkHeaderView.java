package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.TMG.utils.QLog;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkViewExtraInterface;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;

public class ArkHeaderView
  extends ArkAppView
  implements IHeaderView
{
  private ArkAppContainer jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer;
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.doOnEvent(1);
    }
  }
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Context paramContext, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer = new ArkAppContainer();
    paramString = new SessionInfo();
    paramString.jdField_a_of_type_JavaLangString = "2747277822";
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.a(paramQQGameMsgInfo.arkAppName, paramQQGameMsgInfo.arkAppView, paramQQGameMsgInfo.arkAppMinVersion, paramQQGameMsgInfo.arkMetaList, paramContext.getResources().getDisplayMetrics().scaledDensity, paramString);
    paramInt = AIOUtils.a(350.0F, paramContext.getResources());
    int i = ArkAppCenterUtil.d;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.setMaxSize(i, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.setFixSize(i, paramInt);
    setClipRadius(5.0F);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer, null);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.doOnEvent(0);
    }
  }
  
  public void c() {}
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.doOnEvent(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.ArkHeaderView
 * JD-Core Version:    0.7.0.1
 */