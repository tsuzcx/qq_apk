package com.tencent.mobileqq.search.rich;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class ArkRichNode
  extends RichNodeBase
  implements IArkNodeViewEvent
{
  private static ArkAppCallBackHandler jdField_a_of_type_ComTencentMobileqqSearchRichArkAppCallBackHandler = new ArkAppCallBackHandler();
  private int jdField_a_of_type_Int = 0;
  private ArkNodeConfig jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeConfig;
  private ArkNodeContainer jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeContainer;
  
  public ArkRichNode(ArkNodeConfig paramArkNodeConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeConfig = paramArkNodeConfig;
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeConfig != null) && (QLog.isColorLevel()))
    {
      paramArkNodeConfig = new StringBuilder();
      paramArkNodeConfig.append("id:");
      paramArkNodeConfig.append(this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeConfig.a());
      paramArkNodeConfig.append(" appname:");
      paramArkNodeConfig.append(this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeConfig.b());
      paramArkNodeConfig.append(" viewname:");
      paramArkNodeConfig.append(this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeConfig.d());
      paramArkNodeConfig.append(" miniversion:");
      paramArkNodeConfig.append(this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeConfig.c());
      paramArkNodeConfig.append(" path：");
      paramArkNodeConfig.append(this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeConfig.a());
      QLog.d("ArkRichNode", 2, paramArkNodeConfig.toString());
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ArkNodeContainer a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeContainer;
  }
  
  public IRichNodeView a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeConfig == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkRichNode", 2, "onCreate config = null");
      }
      return null;
    }
    ArkNodeView localArkNodeView = new ArkNodeView(this, paramContext);
    localArkNodeView.a(this);
    localArkNodeView.a(paramContext);
    jdField_a_of_type_ComTencentMobileqqSearchRichArkAppCallBackHandler.a(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeContainer = new ArkNodeContainer(jdField_a_of_type_ComTencentMobileqqSearchRichArkAppCallBackHandler);
    String str = a();
    this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeContainer.a(this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeConfig, str, paramContext.getResources().getDisplayMetrics().scaledDensity);
    this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeContainer.setFixSize(-1, -1);
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeContainer.setMaxSize(i, -1);
    this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeContainer.setMinSize(i, -1);
    localArkNodeView.a(this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeContainer);
    this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeContainer.activateView(true);
    return localArkNodeView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkRichNode", 2, "onDestroy");
    }
    Object localObject = jdField_a_of_type_ComTencentMobileqqSearchRichArkAppCallBackHandler;
    if (localObject != null) {
      ((ArkAppCallBackHandler)localObject).b(this);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeContainer;
    if (localObject != null)
    {
      ((ArkNodeContainer)localObject).doOnEvent(2);
      this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeContainer.a();
      this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeContainer = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeConfig = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    e();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSetTalkBackText:");
      localStringBuilder.append(paramString);
      QLog.d("ArkRichNode", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    IRichNodeView localIRichNodeView = a();
    if (localIRichNodeView == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    paramString = localIRichNodeView.a();
    if (paramString != null) {
      paramString.setContentDescription(localStringBuilder);
    }
    if ((localIRichNodeView instanceof ArkNodeView))
    {
      paramString = ((ArkNodeView)localIRichNodeView).b();
      if ((paramString instanceof ArkAppView)) {
        ((ArkAppView)paramString).setContentDescription(localStringBuilder);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNotifyEvent, key:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" value:");
      localStringBuilder.append(paramString2);
      QLog.d("ArkRichNode", 2, localStringBuilder.toString());
    }
    b(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    super.a(paramString1, paramString2, paramString3);
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeContainer;
    if (paramString1 != null) {
      paramString1.updateMetaData(a());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ArkNodeContainer localArkNodeContainer = this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeContainer;
    if (localArkNodeContainer != null) {
      localArkNodeContainer.activateView(paramBoolean);
    }
  }
  
  public int b()
  {
    return 2;
  }
  
  public void b()
  {
    super.b();
    ArkNodeContainer localArkNodeContainer = this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeContainer;
    if (localArkNodeContainer != null) {
      localArkNodeContainer.doOnEvent(0);
    }
  }
  
  public void c()
  {
    super.c();
    ArkNodeContainer localArkNodeContainer = this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeContainer;
    if (localArkNodeContainer != null) {
      localArkNodeContainer.doOnEvent(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.ArkRichNode
 * JD-Core Version:    0.7.0.1
 */