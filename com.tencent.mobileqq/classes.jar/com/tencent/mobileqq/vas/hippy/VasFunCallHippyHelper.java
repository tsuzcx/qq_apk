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
  Activity a;
  public Context b;
  VasFunCallHippyHelper.VasFunCallObserver c = new VasFunCallHippyHelper.VasFunCallObserver(this);
  QQProgressDialog d;
  
  public VasFunCallHippyHelper(Context paramContext, Activity paramActivity)
  {
    this.b = paramContext;
    this.a = paramActivity;
  }
  
  public void a(HippyMap paramHippyMap, Promise paramPromise)
  {
    Bundle localBundle = new Bundle();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.c.a(paramPromise);
    paramPromise = (VipSetFunCallHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER);
    int i = paramHippyMap.getInt("callId");
    int j = paramHippyMap.getInt("ringId");
    a(true, 2131917212);
    localBundle.putInt("callId", i);
    localBundle.putInt("ringId", j);
    localBundle.putInt("from", 1);
    localQQAppInterface.addObserver(this.c);
    if (paramPromise != null) {
      paramPromise.a(3, localBundle);
    }
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    Object localObject;
    if (paramBoolean)
    {
      if (this.d == null)
      {
        localObject = this.a;
        if ((localObject instanceof QBaseActivity))
        {
          this.d = new QQProgressDialog(this.b, ((QBaseActivity)localObject).getTitleBarHeight());
          this.d.setCancelable(true);
        }
      }
      localObject = this.d;
      if (localObject != null)
      {
        ((QQProgressDialog)localObject).c(paramInt);
        this.d.show();
      }
    }
    else
    {
      localObject = this.d;
      if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
        this.d.dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.VasFunCallHippyHelper
 * JD-Core Version:    0.7.0.1
 */