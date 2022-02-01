package com.tencent.mobileqq.businessCard.activity;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class BusinessCardEditActivity$18
  extends BusinessCardObserver
{
  BusinessCardEditActivity$18(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_observer", 2, String.format("onDelCard isSuccess=%s cardId=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    this.a.c();
    if (paramBoolean)
    {
      QQToast.makeText(this.a.getActivity(), 2, HardCodeUtil.a(2131899498), 0).show(this.a.getTitleBarHeight());
      this.a.finish();
      return;
    }
    QQToast.makeText(this.a.getActivity(), 1, HardCodeUtil.a(2131899493), 0).show(this.a.getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_observer", 2, String.format("onGetCardInfo isSuccess=%s cardId=%s queryType=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) }));
    }
    this.a.c();
    if ((paramBoolean) && (paramString.equals(this.a.B)))
    {
      Object localObject;
      if ((this.a.w) && (this.a.v == 2) && (this.a.H == 1))
      {
        localObject = this.a;
        ((BusinessCardEditActivity)localObject).H = 0;
        ((BusinessCardEditActivity)localObject).A.a(false);
      }
      if ((this.a.w) && (this.a.x) && (!this.a.isFinishing()))
      {
        this.a.A.a(paramString);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("after edit and require : cardId = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("BusinessCard_observer", 4, ((StringBuilder)localObject).toString());
        this.a.finish();
        return;
      }
      paramString = this.a.A.a(paramString);
      if (paramString != null)
      {
        localObject = this.a;
        ((BusinessCardEditActivity)localObject).C = paramString;
        BusinessCardEditActivity.a((BusinessCardEditActivity)localObject, false, true, true);
      }
    }
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_observer", 2, String.format("onModifyCard isSuccess=%s cardId=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    this.a.c();
    if (paramBoolean)
    {
      this.a.b(HardCodeUtil.a(2131899495));
      ReportController.b(this.a.app, "CliOper", "", "", "0X8007748", "0X8007748", this.a.I, 0, "", "", "", "");
      return;
    }
    QQToast.makeText(this.a.getActivity(), 2, HardCodeUtil.a(2131899503), 0).show(this.a.getTitleBarHeight());
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_observer", 2, String.format("onAddCard isSuccess=%s cardId=%s result=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) }));
    }
    this.a.c();
    Object localObject = this.a.getResources();
    if (paramBoolean)
    {
      localObject = ((Resources)localObject).getString(2131896604);
      this.a.b((String)localObject);
      if (TextUtils.isEmpty(this.a.B)) {
        this.a.B = paramString;
      }
    }
    else
    {
      paramString = ((Resources)localObject).getString(2131896602);
      if (paramInt == 66) {
        paramString = ((Resources)localObject).getString(2131896603);
      }
      QQToast.makeText(this.a.getActivity(), 2, paramString, 0).show(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.18
 * JD-Core Version:    0.7.0.1
 */