package cooperation.plugin.rc;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.utils.ContactUtils;

public class GetQQAppInterfaceDataRemoteCommand
  extends RemoteCommand
{
  private QQAppInterface a;
  
  public GetQQAppInterfaceDataRemoteCommand(QQAppInterface paramQQAppInterface)
  {
    super("common.get_qq_app_interface_data");
    this.a = paramQQAppInterface;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    int i = paramBundle.getInt("param_data_type", 0);
    paramOnInvokeFinishLinstener = new Bundle();
    if (i != 1)
    {
      if (i != 2) {
        return paramOnInvokeFinishLinstener;
      }
      String str = paramBundle.getString("param_uin");
      boolean bool = paramBundle.getBoolean("param_fetch_if_not_exist", false);
      paramOnInvokeFinishLinstener.putString("result_key", ContactUtils.a(this.a, str, bool));
      return paramOnInvokeFinishLinstener;
    }
    paramBundle = paramBundle.getString("param_uin");
    paramOnInvokeFinishLinstener.putString("result_key", ContactUtils.e(this.a, paramBundle));
    return paramOnInvokeFinishLinstener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.rc.GetQQAppInterfaceDataRemoteCommand
 * JD-Core Version:    0.7.0.1
 */