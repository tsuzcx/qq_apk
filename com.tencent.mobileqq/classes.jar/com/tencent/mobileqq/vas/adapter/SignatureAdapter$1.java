package com.tencent.mobileqq.vas.adapter;

import android.os.Handler;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureManagerForTool;
import com.tencent.mobileqq.vas.VasResEngine.VasResController;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

class SignatureAdapter$1
  implements Observer
{
  SignatureAdapter$1(SignatureAdapter paramSignatureAdapter) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof ArrayList))
    {
      paramObservable = (ArrayList)paramObject;
      if (((Integer)paramObservable.get(0)).intValue() != 5) {
        return;
      }
      paramObservable = (RichStatus)paramObservable.get(1);
      SignatureAdapter.a(this.a, paramObservable);
      if (SignatureAdapter.a(this.a).plainText != null)
      {
        paramObject = SignatureManagerForTool.a().b;
        if (paramObject != null)
        {
          paramObject.plainText = ((ArrayList)SignatureAdapter.a(this.a).plainText.clone());
          paramObject.topics.clear();
          paramObject.topics.addAll(SignatureAdapter.a(this.a).topics);
        }
      }
      if (paramObservable != null) {
        SignatureAdapter.b(this.a).copyFrom(paramObservable);
      }
      SignatureAdapter.a(this.a).a().sendEmptyMessage(10003);
      SignatureManagerForTool.a().deleteObserver(SignatureAdapter.a(this.a));
      return;
    }
    SignatureAdapter.a(this.a).a().sendEmptyMessage(10003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.SignatureAdapter.1
 * JD-Core Version:    0.7.0.1
 */