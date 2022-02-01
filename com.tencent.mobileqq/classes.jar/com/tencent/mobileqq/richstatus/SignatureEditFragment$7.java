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
            paramObservable = SignatureEditFragment.d(this.a).obtainMessage();
            paramObservable.what = 262;
            paramObservable.arg1 = i;
            SignatureEditFragment.d(this.a).sendMessage(paramObservable);
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
          localSignatureEditFragment.c = false;
          SignatureEditFragment.a(localSignatureEditFragment, true);
          localSignatureEditFragment = this.a;
          localSignatureEditFragment.d = false;
          localSignatureEditFragment.getAppRuntime().getAccount();
          if (((Integer)paramObject.get(3)).intValue() == 1)
          {
            this.a.a = RichStatus.getEmptyStatus();
            SignatureManagerForTool.a().b(this.a.a);
          }
          else
          {
            SignatureManagerForTool.a().a = null;
            SignatureManagerForTool.a().b = null;
            SignatureEditFragment.f(this.a);
            this.a.d();
          }
        }
        paramObject = new Message();
        paramObject.what = 259;
        paramObject.obj = paramObservable;
        SignatureEditFragment.d(this.a).sendMessage(paramObject);
        return;
      }
      paramObservable = (RichStatus)paramObject.get(1);
      paramObject = this.a;
      paramObject.a = paramObservable;
      paramObject.d = false;
      if (paramObject.a.plainText != null)
      {
        paramObject = SignatureManagerForTool.a().b;
        if (paramObject != null)
        {
          paramObject.plainText = ((ArrayList)this.a.a.plainText.clone());
          paramObject.topics.clear();
          paramObject.topics.addAll(this.a.a.topics);
        }
      }
      if (paramObservable != null)
      {
        this.a.b.copyFrom(paramObservable);
        SignatureManagerForTool.a().a(this.a.b.tplId);
      }
      paramObservable = this.a;
      paramObservable.c = false;
      if (SignatureEditFragment.d(paramObservable) != null) {
        SignatureEditFragment.d(this.a).sendEmptyMessage(257);
      }
      SignatureEditFragment.e(this.a);
      return;
    }
    if (SignatureEditFragment.d(this.a) != null) {
      SignatureEditFragment.d(this.a).sendEmptyMessage(257);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureEditFragment.7
 * JD-Core Version:    0.7.0.1
 */