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
    this.a.b();
    if (paramBoolean)
    {
      QQToast.a(this.a.getActivity(), 2, HardCodeUtil.a(2131701474), 0).b(this.a.getTitleBarHeight());
      this.a.finish();
      return;
    }
    QQToast.a(this.a.getActivity(), 1, HardCodeUtil.a(2131701469), 0).b(this.a.getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_observer", 2, String.format("onGetCardInfo isSuccess=%s cardId=%s queryType=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) }));
    }
    this.a.b();
    if ((paramBoolean) && (paramString.equals(this.a.jdField_a_of_type_JavaLangString)))
    {
      Object localObject;
      if ((this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_Int == 2) && (this.a.c == 1))
      {
        localObject = this.a;
        ((BusinessCardEditActivity)localObject).c = 0;
        ((BusinessCardEditActivity)localObject).jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a(false);
      }
      if ((this.a.jdField_a_of_type_Boolean) && (this.a.b) && (!this.a.isFinishing()))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a(paramString);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("after edit and require : cardId = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("BusinessCard_observer", 4, ((StringBuilder)localObject).toString());
        this.a.finish();
        return;
      }
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a(paramString);
      if (paramString != null)
      {
        localObject = this.a;
        ((BusinessCardEditActivity)localObject).jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = paramString;
        BusinessCardEditActivity.a((BusinessCardEditActivity)localObject, false, true, true);
      }
    }
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_observer", 2, String.format("onModifyCard isSuccess=%s cardId=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    this.a.b();
    if (paramBoolean)
    {
      this.a.b(HardCodeUtil.a(2131701471));
      ReportController.b(this.a.app, "CliOper", "", "", "0X8007748", "0X8007748", this.a.d, 0, "", "", "", "");
      return;
    }
    QQToast.a(this.a.getActivity(), 2, HardCodeUtil.a(2131701479), 0).b(this.a.getTitleBarHeight());
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_observer", 2, String.format("onAddCard isSuccess=%s cardId=%s result=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) }));
    }
    this.a.b();
    Object localObject = this.a.getResources();
    if (paramBoolean)
    {
      localObject = ((Resources)localObject).getString(2131698655);
      this.a.b((String)localObject);
      if (TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
        this.a.jdField_a_of_type_JavaLangString = paramString;
      }
    }
    else
    {
      paramString = ((Resources)localObject).getString(2131698653);
      if (paramInt == 66) {
        paramString = ((Resources)localObject).getString(2131698654);
      }
      QQToast.a(this.a.getActivity(), 2, paramString, 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.18
 * JD-Core Version:    0.7.0.1
 */