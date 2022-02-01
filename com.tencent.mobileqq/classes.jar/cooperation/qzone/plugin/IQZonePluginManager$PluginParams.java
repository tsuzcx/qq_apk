package cooperation.qzone.plugin;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import java.util.ArrayList;
import java.util.List;

public class IQZonePluginManager$PluginParams
{
  String mApkFilePath;
  public String mConponentName;
  public Dialog mDialog;
  public boolean mDialogDismissBySDK = true;
  public Intent mIntent;
  public String mPluginID;
  public String mPluginName;
  int mPluginType = 0;
  public String mProgressTips;
  public Class<? extends Activity> mProxyActivityClass;
  public List<RemoteCommand> mRemoteCommands = new ArrayList();
  public int mRequestCode = -1;
  public ServiceConnection mServiceConnection;
  public int mTimeOut = 10000;
  public String mUin;
  
  public IQZonePluginManager$PluginParams(int paramInt)
  {
    this.mPluginType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.plugin.IQZonePluginManager.PluginParams
 * JD-Core Version:    0.7.0.1
 */