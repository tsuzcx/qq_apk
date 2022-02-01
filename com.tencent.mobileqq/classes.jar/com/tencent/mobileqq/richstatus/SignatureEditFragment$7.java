package com.tencent.mobileqq.richstatus;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;

class SignatureEditFragment$7
  implements Observer
{
  SignatureEditFragment$7(SignatureEditFragment paramSignatureEditFragment) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObservable = new StringBuilder();
      paramObservable.append("mSignatureObserver type = ");
      paramObservable.append(paramObject);
      QLog.d("Signature.Fragment", 2, paramObservable.toString());
    }
    if ((paramObject instanceof ArrayList))
    {
      paramObject = (ArrayList)paramObject;
      int i = ((Integer)paramObject.get(0)).intValue();
      if (i != 5)
      {
        if (i != 6)
        {
          if (i != 7)
          {
            if (i != 8) {
              return;
            }
            i = ((Integer)paramObject.get(1)).intValue();
            paramObservable = SignatureEditFragment.a(this.a).obtainMessage();
            paramObservable.what = 262;
            paramObservable.arg1 = i;
            SignatureEditFragment.a(this.a).sendMessage(paramObservable);
            return;
          }
          ((Integer)paramObject.get(1)).intValue();
          return;
        }
        i = ((Integer)paramObject.get(1)).intValue();
        paramObservable = (HashMap)paramObject.get(2);
        if ((i == 100) || (i == 0))
        {
          SignatureEditFragment localSignatureEditFragment = this.a;
          localSignatureEditFragment.jdField_a_of_type_Boolean = false;
          SignatureEditFragment.a(localSignatureEditFragment, true);
          localSignatureEditFragment = this.a;
          localSignatureEditFragment.jdField_b_of_type_Boolean = false;
          localSignatureEditFragment.getAppRuntime().getAccount();
          if (((Integer)paramObject.get(3)).intValue() == 1)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = RichStatus.getEmptyStatus();
            SignatureManagerForTool.a().b(this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
          }
          else
          {
            SignatureManagerForTool.a().jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
            SignatureManagerForTool.a().jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus = null;
            SignatureEditFragment.c(this.a);
            this.a.c();
          }
        }
        paramObject = new Message();
        paramObject.what = 259;
        paramObject.obj = paramObservable;
        SignatureEditFragment.a(this.a).sendMessage(paramObject);
        return;
      }
      paramObservable = (RichStatus)paramObject.get(1);
      paramObject = this.a;
      paramObject.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramObservable;
      paramObject.jdField_b_of_type_Boolean = false;
      if (paramObject.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText != null)
      {
        paramObject = SignatureManagerForTool.a().jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus;
        if (paramObject != null)
        {
          paramObject.plainText = ((ArrayList)this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.clone());
          paramObject.topics.clear();
          paramObject.topics.addAll(this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics);
        }
      }
      if (paramObservable != null)
      {
        this.a.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus.copyFrom(paramObservable);
        SignatureManagerForTool.a().a(this.a.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
      }
      paramObservable = this.a;
      paramObservable.jdField_a_of_type_Boolean = false;
      if (SignatureEditFragment.a(paramObservable) != null) {
        SignatureEditFragment.a(this.a).sendEmptyMessage(257);
      }
      SignatureEditFragment.b(this.a);
      return;
    }
    if (SignatureEditFragment.a(this.a) != null) {
      SignatureEditFragment.a(this.a).sendEmptyMessage(257);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureEditFragment.7
 * JD-Core Version:    0.7.0.1
 */