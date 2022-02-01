package com.tencent.open.agent.auth.presenter;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.open.agent.auth.INewAuthorityContract.View;
import com.tencent.open.agent.authority.AuthResponse;
import com.tencent.open.agent.entity.AppInfoResponse;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;

class NewAuthorityPresenter$1
  implements Handler.Callback
{
  NewAuthorityPresenter$1(NewAuthorityPresenter paramNewAuthorityPresenter) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      break;
    case 6: 
      this.a.b((AuthResponse)paramMessage.obj);
      break;
    case 5: 
      NewAuthorityPresenter.a(this.a, (AppInfoResponse)paramMessage.obj);
      break;
    case 4: 
      NewAuthorityPresenter.a(this.a, (preAuth.PreAuthResponse)paramMessage.obj);
      break;
    case 3: 
      NewAuthorityPresenter.a(this.a, (GetVirtualListResult)paramMessage.obj);
      break;
    case 2: 
      NewAuthorityPresenter.b(this.a).a(this.a.w.a);
      break;
    case 1: 
      NewAuthorityPresenter.a(this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.NewAuthorityPresenter.1
 * JD-Core Version:    0.7.0.1
 */