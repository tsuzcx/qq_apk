package cooperation.troop;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;

public class TroopManageCmd
  extends RemoteCommand
{
  private QQAppInterface a;
  
  public TroopManageCmd(QQAppInterface paramQQAppInterface)
  {
    super("troop.manage.get_app_interface_data");
    this.a = paramQQAppInterface;
  }
  
  protected Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param_rsp_upgrade_troop_url", IndividuationUrlHelper.a("vipUpGroupLimit"));
    return localBundle;
  }
  
  protected Bundle a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("param_rsp_troop_owmer_field", ((TroopGagMgr)this.a.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(paramBundle.getString("req_troop_uin")));
    return localBundle;
  }
  
  protected Bundle a(Bundle paramBundle, int paramInt)
  {
    String str = null;
    if (paramBundle == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    if (paramInt == 5) {
      str = ContactUtils.b(this.a, paramBundle.getString("req_troop_uin"), paramBundle.getString("memUin"));
    } else if (paramInt == 6) {
      str = ContactUtils.e(this.a, paramBundle.getString("memUin"));
    }
    localBundle.putString("param_rsp_nick", str);
    return localBundle;
  }
  
  protected Bundle b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    paramBundle = new Bundle();
    paramBundle.putInt("rep_unique_title_flag", ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).a());
    return paramBundle;
  }
  
  protected Bundle c(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    int i = paramBundle.getInt("set_unique_title_flag");
    paramBundle = new Bundle();
    ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).a(i);
    return paramBundle;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if (paramBundle != null)
    {
      if (this.a == null) {
        return null;
      }
      try
      {
        paramOnInvokeFinishLinstener = new Bundle();
        i = paramBundle.getInt("req_sub_cmd", 0);
        switch (i)
        {
        case 7: 
          return a();
        }
      }
      catch (Exception paramBundle)
      {
        int i;
        if (!QLog.isColorLevel()) {
          break label193;
        }
        paramOnInvokeFinishLinstener = new StringBuilder();
        paramOnInvokeFinishLinstener.append("invoke Exception hanppend! ExceptionClass = + ");
        paramOnInvokeFinishLinstener.append(paramBundle.getClass().getName());
        paramOnInvokeFinishLinstener.append("msg = ");
        paramOnInvokeFinishLinstener.append(paramBundle.getMessage());
        QLog.d("TroopManageCmd", 2, paramOnInvokeFinishLinstener.toString());
        ReportController.b(this.a, "P_CliOper", "BizTechReport", "", "troop_manage_plugin", "plugin_cmd_exp", 0, 0, paramBundle.getClass().getName(), null, null, null);
      }
      return a(paramBundle, i);
      paramBundle = (TroopInfo)paramBundle.getSerializable("troopInfo");
      ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramBundle);
      return paramOnInvokeFinishLinstener;
      return a(paramBundle);
      return c(paramBundle);
      paramBundle = b(paramBundle);
      return paramBundle;
    }
    label193:
    return null;
    return paramOnInvokeFinishLinstener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop.TroopManageCmd
 * JD-Core Version:    0.7.0.1
 */