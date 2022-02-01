package com.tencent.mobileqq.richstatus;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.signature.SignatureEditManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class SignTextEditFragment$7
  implements IStatusListener
{
  SignTextEditFragment$7(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void a(int paramInt, RichStatus paramRichStatus, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onChangeStatus reslut=%d status=%s", new Object[] { Integer.valueOf(paramInt), paramRichStatus }));
    }
    int i;
    if ((paramRichStatus != null) && (paramRichStatus != RichStatus.getEmptyStatus()))
    {
      i = 1;
    }
    else
    {
      if (paramInt == 100) {
        QQToast.a(BaseApplication.context, 2, HardCodeUtil.a(2131714024), 0).a();
      } else {
        QQToast.a(BaseApplication.context, 1, HardCodeUtil.a(2131714016), 0).a();
      }
      i = 0;
    }
    if ((paramObject instanceof TipsInfo))
    {
      paramRichStatus = (TipsInfo)paramObject;
      SignTextEditFragment.b(this.a, paramRichStatus.errorDesc);
      if (TextUtils.isEmpty(SignTextEditFragment.a(this.a))) {
        SignTextEditFragment.b(this.a, paramRichStatus.wording);
      }
    }
    if (paramInt == 100)
    {
      SignTextEditFragment.a(this.a, false);
      paramRichStatus = this.a;
      paramRichStatus.jdField_a_of_type_Boolean = true;
      paramRichStatus.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
      this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.copyFrom(SignTextEditFragment.a(this.a).a(true));
      paramObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      paramRichStatus = paramObject;
      if (paramObject == null) {
        paramRichStatus = "noLogin";
      }
      paramRichStatus = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(paramRichStatus, 4).edit();
      paramObject = new StringBuilder();
      paramObject.append("sign_location_id_");
      paramObject.append(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramRichStatus.putString(paramObject.toString(), SignTextEditFragment.b(this.a)).commit();
      if (this.a.isAdded()) {
        SignTextEditFragment.a(this.a, false);
      }
      paramRichStatus = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      paramObject = paramRichStatus.edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localStringBuilder.append("edit_signature_version_826");
      paramObject.putBoolean(localStringBuilder.toString(), true);
      int j = i;
      if (3 == this.a.jdField_a_of_type_Int)
      {
        SignatureManagerForTool.a().addObserver(this.a.jdField_a_of_type_JavaUtilObserver);
        paramObject = SignatureManagerForTool.a().a(this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
        if ((Integer.parseInt(paramObject.jdField_a_of_type_JavaLangString) != this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId) && (paramObject.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
        {
          SignTextEditFragment.a(this.a).set(true);
          this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new SignTextEditFragment.7.1(this), 1500L);
          return;
        }
        j = i;
        if (Integer.parseInt(paramObject.jdField_a_of_type_JavaLangString) > 0)
        {
          j = i;
          if (paramObject.f < 2)
          {
            paramObject = new StringBuilder();
            paramObject.append(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            paramObject.append("new_signature_version_826");
            j = i;
            if (paramRichStatus.getBoolean(paramObject.toString(), true))
            {
              SignatureEditManager.a(this.a.getBaseActivity(), this.a.getBaseActivity().app, 0, "signature_chouti");
              j = 0;
            }
          }
        }
      }
      if (j != 0)
      {
        paramRichStatus = this.a;
        paramRichStatus.a(paramInt, SignTextEditFragment.a(paramRichStatus));
      }
      this.a.onBackEvent();
      return;
    }
    if (i != 0)
    {
      paramRichStatus = this.a;
      paramRichStatus.a(paramInt, SignTextEditFragment.a(paramRichStatus));
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignTextEditFragment.7
 * JD-Core Version:    0.7.0.1
 */