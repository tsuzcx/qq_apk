package com.tencent.open.agent;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.manager.OpenAgentHandler.AuthItemResult;
import com.tencent.open.manager.OpenAgentObserver;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0xf26.oidb_0xf26.QueryRsp;
import tencent.im.oidb.cmd0xf26.oidb_0xf26.RspBody;

class AuthorityControlAppDetailsFragment$5
  extends OpenAgentObserver
{
  AuthorityControlAppDetailsFragment$5(AuthorityControlAppDetailsFragment paramAuthorityControlAppDetailsFragment) {}
  
  private void a(OpenAgentHandler.AuthItemResult paramAuthItemResult)
  {
    QLog.d("AuthorityControlAppDetailsActivity", 1, new Object[] { "onAuthItemSuccess type=", Integer.valueOf(paramAuthItemResult.a) });
    if (paramAuthItemResult.a == 1) {
      AuthorityControlAppDetailsFragment.b(this.a, paramAuthItemResult.d.query_rsp.auth_item.get());
    }
  }
  
  private void b(OpenAgentHandler.AuthItemResult paramAuthItemResult)
  {
    QLog.d("AuthorityControlAppDetailsActivity", 1, new Object[] { "onAuthItemError errorCode=", Integer.valueOf(paramAuthItemResult.b), ", errorMessage=", paramAuthItemResult.c });
    if (paramAuthItemResult.b == 36004)
    {
      QQToast.makeText(AuthorityControlAppDetailsFragment.c(this.a), 1, 2131887121, 0).show();
      AuthorityControlAppDetailsFragment.c(this.a).finish();
      int i = AuthorityControlAppDetailsFragment.h(this.a).a();
      paramAuthItemResult = AuthorityControlAppDetailsFragment.h(this.a).c();
      AuthorityUtil.a(AuthorityControlAppDetailsFragment.e(this.a), "0X800BAE2", 0, AuthorityControlAppDetailsFragment.g(this.a), new String[] { String.valueOf(i), "", paramAuthItemResult, "" });
      return;
    }
    if ((paramAuthItemResult.b != 0) && (!TextUtils.isEmpty(paramAuthItemResult.c)))
    {
      QQToast.makeText(AuthorityControlAppDetailsFragment.c(this.a), String.format(this.a.getString(2131894269), new Object[] { paramAuthItemResult.c, Integer.valueOf(paramAuthItemResult.b) }), 0).show();
      return;
    }
    QQToast.makeText(AuthorityControlAppDetailsFragment.c(this.a), HardCodeUtil.a(2131892333), 0).show();
  }
  
  protected void a(boolean paramBoolean, OpenAgentHandler.AuthItemResult paramAuthItemResult)
  {
    QLog.d("AuthorityControlAppDetailsActivity", 1, new Object[] { "onAuthItemResult isSuccess=", Boolean.valueOf(paramBoolean), ", mStatus=", Integer.valueOf(AuthorityControlAppDetailsFragment.i(this.a)) });
    if ((AuthorityControlAppDetailsFragment.c(this.a) != null) && (!AuthorityControlAppDetailsFragment.c(this.a).isFinishing()))
    {
      if (AuthorityControlAppDetailsFragment.d(this.a)) {
        return;
      }
      if (paramBoolean)
      {
        a(paramAuthItemResult);
        return;
      }
      b(paramAuthItemResult);
      return;
    }
    QLog.d("AuthorityControlAppDetailsActivity", 1, "onAuthItemResult activity finishing");
  }
  
  protected void a(boolean paramBoolean, List<AppInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDelApp: invoked.  isSuccess: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" infos: ");
      ((StringBuilder)localObject).append(paramList);
      QLog.i("AuthorityControlAppDetailsActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131899048));
      ((StringBuilder)localObject).append(AuthorityControlAppDetailsFragment.h(this.a).c());
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131899046));
      localObject = ((StringBuilder)localObject).toString();
      QQToast.makeText(AuthorityControlAppDetailsFragment.c(this.a), 2, (CharSequence)localObject, 0).show();
      localObject = new Intent();
      if ((paramList != null) && (paramList.size() == 1))
      {
        ((Intent)localObject).putExtra("KEY_DELETED_INFO", (Parcelable)paramList.get(0));
        AuthorityControlAppDetailsFragment.c(this.a).setResult(-1, (Intent)localObject);
      }
      AuthorityControlAppDetailsFragment.a(this.a, paramList);
      AuthorityControlAppDetailsFragment.c(this.a).finish();
    }
    else
    {
      QQToast.makeText(AuthorityControlAppDetailsFragment.c(this.a), 1, HardCodeUtil.a(2131899047), 0).show();
    }
    Object localObject = AuthorityControlAppDetailsFragment.e(this.a);
    if (paramBoolean) {
      paramList = "0";
    } else {
      paramList = "1";
    }
    ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X8009E1C", "0X8009E1C", 0, 0, paramList, "", String.valueOf(AuthorityControlAppDetailsFragment.h(this.a).a()), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlAppDetailsFragment.5
 * JD-Core Version:    0.7.0.1
 */