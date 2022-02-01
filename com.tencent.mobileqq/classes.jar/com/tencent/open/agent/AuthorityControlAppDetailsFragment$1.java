package com.tencent.open.agent;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.manager.OpenAgentHandler.AuthItemResult;
import com.tencent.open.manager.OpenAgentObserver;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0xf26.oidb_0xf26.QueryRsp;
import tencent.im.oidb.cmd0xf26.oidb_0xf26.RspBody;

class AuthorityControlAppDetailsFragment$1
  extends OpenAgentObserver
{
  AuthorityControlAppDetailsFragment$1(AuthorityControlAppDetailsFragment paramAuthorityControlAppDetailsFragment) {}
  
  private void a(OpenAgentHandler.AuthItemResult paramAuthItemResult)
  {
    QLog.d("AuthorityControlAppDetailsActivity", 1, new Object[] { "onAuthItemSuccess type=", Integer.valueOf(paramAuthItemResult.jdField_a_of_type_Int) });
    if (paramAuthItemResult.jdField_a_of_type_Int == 1) {
      AuthorityControlAppDetailsFragment.a(this.a, paramAuthItemResult.jdField_a_of_type_TencentImOidbCmd0xf26Oidb_0xf26$RspBody.query_rsp.auth_item.get());
    }
  }
  
  private void b(OpenAgentHandler.AuthItemResult paramAuthItemResult)
  {
    QLog.d("AuthorityControlAppDetailsActivity", 1, new Object[] { "onAuthItemError errorCode=", Integer.valueOf(paramAuthItemResult.b), ", errorMessage=", paramAuthItemResult.jdField_a_of_type_JavaLangString });
    if ((paramAuthItemResult.b != 0) && (!TextUtils.isEmpty(paramAuthItemResult.jdField_a_of_type_JavaLangString)))
    {
      QQToast.a(this.a.getActivity(), String.format(this.a.getActivity().getString(2131696476), new Object[] { paramAuthItemResult.jdField_a_of_type_JavaLangString, Integer.valueOf(paramAuthItemResult.b) }), 0).a();
      return;
    }
    QQToast.a(this.a.getActivity(), HardCodeUtil.a(2131694678), 0).a();
  }
  
  public void a(boolean paramBoolean, OpenAgentHandler.AuthItemResult paramAuthItemResult)
  {
    int i = 1;
    QLog.d("AuthorityControlAppDetailsActivity", 1, new Object[] { "onAuthItemResult isSuccess=", Boolean.valueOf(paramBoolean), ", mStatus=", Integer.valueOf(AuthorityControlAppDetailsFragment.a(this.a)) });
    if ((this.a.getActivity() == null) || (this.a.getActivity().isFinishing()))
    {
      QLog.d("AuthorityControlAppDetailsActivity", 1, "onAuthItemResult activity finishing");
      return;
    }
    if (AuthorityControlAppDetailsFragment.a(this.a) == 2) {}
    for (;;)
    {
      AuthorityControlAppDetailsFragment.a(this.a);
      if (i != 0) {
        break;
      }
      if (!paramBoolean) {
        break label111;
      }
      a(paramAuthItemResult);
      return;
      i = 0;
    }
    label111:
    b(paramAuthItemResult);
  }
  
  public void a(boolean paramBoolean, List<AppInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityControlAppDetailsActivity", 2, "onDelApp: invoked.  isSuccess: " + paramBoolean + " infos: " + paramList);
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = HardCodeUtil.a(2131700884) + AuthorityControlAppDetailsFragment.a(this.a).b() + HardCodeUtil.a(2131700882);
      QQToast.a(AuthorityControlAppDetailsFragment.a(this.a), 2, (CharSequence)localObject, 0).a();
      localObject = new Intent();
      if ((paramList != null) && (paramList.size() == 1))
      {
        ((Intent)localObject).putExtra("KEY_DELETED_INFO", (Parcelable)paramList.get(0));
        AuthorityControlAppDetailsFragment.a(this.a).setResult(-1, (Intent)localObject);
      }
      AuthorityControlAppDetailsFragment.a(this.a).finish();
      localObject = AuthorityControlAppDetailsFragment.a(this.a);
      if (!paramBoolean) {
        break label236;
      }
    }
    label236:
    for (paramList = "0";; paramList = "1")
    {
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X8009E1C", "0X8009E1C", 0, 0, paramList, "", String.valueOf(AuthorityControlAppDetailsFragment.a(this.a).a()), "");
      return;
      QQToast.a(AuthorityControlAppDetailsFragment.a(this.a), 1, HardCodeUtil.a(2131700883), 0).a();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlAppDetailsFragment.1
 * JD-Core Version:    0.7.0.1
 */