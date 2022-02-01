package com.tencent.mobileqq.vas.hippy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;

public class VasFunCallHippyHelper
{
  Activity jdField_a_of_type_AndroidAppActivity;
  public Context a;
  VasFunCallHippyHelper.VasFunCallObserver jdField_a_of_type_ComTencentMobileqqVasHippyVasFunCallHippyHelper$VasFunCallObserver = new VasFunCallHippyHelper.VasFunCallObserver(this);
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  
  public VasFunCallHippyHelper(Context paramContext, Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(HippyMap paramHippyMap, Promise paramPromise)
  {
    Bundle localBundle = new Bundle();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_ComTencentMobileqqVasHippyVasFunCallHippyHelper$VasFunCallObserver.a(paramPromise);
    paramPromise = (VipSetFunCallHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER);
    int i = paramHippyMap.getInt("callId");
    int j = paramHippyMap.getInt("ringId");
    a(true, 2131719616);
    localBundle.putInt("callId", i);
    localBundle.putInt("ringId", j);
    localBundle.putInt("from", 1);
    localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqVasHippyVasFunCallHippyHelper$VasFunCallObserver);
    if (paramPromise != null) {
      paramPromise.a(3, localBundle);
    }
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    Object localObject;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity;
        if ((localObject instanceof QBaseActivity))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, ((QBaseActivity)localObject).getTitleBarHeight());
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      if (localObject != null)
      {
        ((QQProgressDialog)localObject).c(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.VasFunCallHippyHelper
 * JD-Core Version:    0.7.0.1
 */