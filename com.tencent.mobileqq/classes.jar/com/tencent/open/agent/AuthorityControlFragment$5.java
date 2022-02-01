package com.tencent.open.agent;

import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.authority.AuthorityControlAdapter;
import com.tencent.open.manager.OpenAgentObserver;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

class AuthorityControlFragment$5
  extends OpenAgentObserver
{
  AuthorityControlFragment$5(AuthorityControlFragment paramAuthorityControlFragment) {}
  
  protected void a(boolean paramBoolean, List<AppInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDelApp: invoked.  isSuccess: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" infos: ");
      ((StringBuilder)localObject).append(paramList);
      QLog.i("AuthorityControlActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0))
    {
      AuthorityControlFragment.a(this.a, paramList);
      int i = paramList.size();
      paramList = String.format(HardCodeUtil.a(2131701020), new Object[] { Integer.valueOf(i) });
      QQToast.a(AuthorityControlFragment.a(this.a), 2, paramList, 0).a();
    }
    else
    {
      QQToast.a(AuthorityControlFragment.a(this.a), 1, HardCodeUtil.a(2131701024), 0).a();
    }
    Object localObject = AuthorityControlFragment.a(this.a);
    if (paramBoolean) {
      paramList = "0";
    } else {
      paramList = "1";
    }
    ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X8009E1D", "0X8009E1D", 0, 0, paramList, "", "", "");
  }
  
  protected void a(boolean paramBoolean, List<AppInfo> paramList, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onGetAuthorizeAppList: invoked.  isSuccess: ");
      paramString.append(paramBoolean);
      paramString.append(" infos: ");
      paramString.append(paramList);
      QLog.i("AuthorityControlActivity", 2, paramString.toString());
    }
    if (paramBoolean)
    {
      paramString = paramList;
      if (paramList == null) {
        paramString = new ArrayList();
      }
      AuthorityControlFragment.a(this.a).a(paramString);
      AuthorityControlFragment.a(this.a, new ArrayList(paramString));
      if (AuthorityControlFragment.a(this.a).getCount() == 0)
      {
        AuthorityControlFragment.a(this.a);
      }
      else
      {
        AuthorityControlFragment.a(this.a).setVisibility(0);
        paramList = this.a;
        paramList.setRightButton(2131690225, paramList);
      }
      AuthorityControlFragment.a(this.a).notifyDataSetChanged();
    }
    else
    {
      AuthorityControlFragment.a(this.a);
    }
    if ((AuthorityControlFragment.a(this.a).isShowing()) && (!this.a.isRemoving())) {}
    try
    {
      AuthorityControlFragment.a(this.a).dismiss();
      label194:
      AuthorityControlFragment.a(this.a, paramBoolean);
      return;
    }
    catch (Throwable paramList)
    {
      break label194;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlFragment.5
 * JD-Core Version:    0.7.0.1
 */