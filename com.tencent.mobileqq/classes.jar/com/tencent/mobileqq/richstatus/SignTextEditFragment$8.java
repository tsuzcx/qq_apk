package com.tencent.mobileqq.richstatus;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
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
    if (!SignTextEditFragment.e(this.a).get()) {
      return;
    }
    SignTextEditFragment.e(this.a).set(false);
    if ((paramObject instanceof Integer))
    {
      int i = ((Integer)paramObject).intValue();
      if (i != 3)
      {
        if (i != 9) {
          return;
        }
        paramObservable = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
        paramObject = new StringBuilder();
        paramObject.append(this.a.r.getCurrentAccountUin());
        paramObject.append("new_signature_version_826");
        if (paramObservable.getBoolean(paramObject.toString(), true))
        {
          SignatureEditManager.a(this.a.getBaseActivity(), this.a.getBaseActivity().app, 0, "signature_chouti");
        }
        else
        {
          paramObservable = this.a;
          paramObservable.a(100, SignTextEditFragment.b(paramObservable));
        }
        SignatureManagerForTool.a().deleteObserver(this.a.z);
        return;
      }
      paramObservable = SignatureManagerForTool.a().a(this.a.p.tplId);
      if ((paramObservable != null) && (!TextUtils.isEmpty(paramObservable.b)) && (Integer.parseInt(paramObservable.b) > 0) && (paramObservable.B < 2))
      {
        paramObservable = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
        paramObject = new StringBuilder();
        paramObject.append(this.a.r.getCurrentAccountUin());
        paramObject.append("new_signature_version_826");
        if (paramObservable.getBoolean(paramObject.toString(), true)) {
          SignatureEditManager.a(this.a.getBaseActivity(), this.a.getBaseActivity().app, 0, "signature_chouti");
        }
      }
      else
      {
        paramObservable = this.a;
        paramObservable.a(100, SignTextEditFragment.b(paramObservable));
      }
      SignatureManagerForTool.a().deleteObserver(this.a.z);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignTextEditFragment.8
 * JD-Core Version:    0.7.0.1
 */