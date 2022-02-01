package com.tencent.mobileqq.richstatus;

import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.signature.SignatureEditManager;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

class SignTextEditFragment$8
  implements Observer
{
  SignTextEditFragment$8(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!SignTextEditFragment.a(this.a).get()) {}
    do
    {
      return;
      SignTextEditFragment.a(this.a).set(false);
    } while (!(paramObject instanceof Integer));
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    case 3: 
      paramObservable = SignatureManagerForTool.a().a(this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
      if ((paramObservable != null) && (!TextUtils.isEmpty(paramObservable.a)) && (Integer.parseInt(paramObservable.a) > 0) && (paramObservable.f < 2)) {
        if (BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getBoolean(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "new_signature_version_826", true)) {
          SignatureEditManager.a(this.a.getActivity(), this.a.getActivity().app, 0, "signature_chouti");
        }
      }
      for (;;)
      {
        SignatureManagerForTool.a().deleteObserver(this.a.jdField_a_of_type_JavaUtilObserver);
        return;
        this.a.a(100, SignTextEditFragment.a(this.a));
      }
    }
    if (BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getBoolean(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "new_signature_version_826", true)) {
      SignatureEditManager.a(this.a.getActivity(), this.a.getActivity().app, 0, "signature_chouti");
    }
    for (;;)
    {
      SignatureManagerForTool.a().deleteObserver(this.a.jdField_a_of_type_JavaUtilObserver);
      return;
      this.a.a(100, SignTextEditFragment.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignTextEditFragment.8
 * JD-Core Version:    0.7.0.1
 */