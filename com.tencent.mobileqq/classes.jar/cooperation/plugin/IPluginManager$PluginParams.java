package cooperation.plugin;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class IPluginManager$PluginParams
{
  int a = 0;
  int b = 0;
  public String c;
  public String d;
  String e;
  String f;
  public String g;
  public String h;
  public Class<? extends Activity> i;
  public Intent j;
  public int k = -1;
  public Dialog l;
  public PreloadProcHitPluginSession m;
  public boolean n = false;
  public ServiceConnection o;
  public boolean p = true;
  public String q;
  public int r = 10000;
  public int s = 0;
  public int t = 0;
  public List<RemoteCommand> u = new ArrayList();
  public int v;
  PluginBaseInfo w;
  
  public IPluginManager$PluginParams(int paramInt)
  {
    this.a = paramInt;
  }
  
  public IPluginManager$PluginParams(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public void a()
  {
    if ((this.j != null) && (this.w != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pluginStartupAttachInfo dex2Oat ");
      ((StringBuilder)localObject).append(this.w.costDex2Oat);
      ((StringBuilder)localObject).append("lib ");
      ((StringBuilder)localObject).append(this.w.costLib);
      ((StringBuilder)localObject).append("download ");
      ((StringBuilder)localObject).append(this.w.costDownload);
      ((StringBuilder)localObject).append("apk ");
      ((StringBuilder)localObject).append(this.w.costApk);
      QLog.d("plugin_tag", 1, ((StringBuilder)localObject).toString());
      if ((this.w.costDex2Oat != 0L) || (this.w.costLib != 0L) || (this.w.costDownload != 0L) || (this.w.costApk != 0L))
      {
        this.j.putExtra("pluginOatCost", this.w.costDex2Oat);
        this.j.putExtra("pluginLibCost", this.w.costLib);
        this.j.putExtra("pluginDownloadCost", this.w.costDownload);
        this.j.putExtra("pluginApkCost", this.w.costApk);
        localObject = this.w;
        ((PluginBaseInfo)localObject).costDex2Oat = 0L;
        ((PluginBaseInfo)localObject).costLib = 0L;
        ((PluginBaseInfo)localObject).costDownload = 0L;
        ((PluginBaseInfo)localObject).costApk = 0L;
      }
    }
    Object localObject = this.w;
    if (localObject != null)
    {
      ((PluginBaseInfo)localObject).downloadDuration = 0L;
      ((PluginBaseInfo)localObject).costDex2Oat = 0L;
      ((PluginBaseInfo)localObject).installCode = 0;
    }
  }
  
  public void a(PluginBaseInfo paramPluginBaseInfo)
  {
    this.w = paramPluginBaseInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.PluginParams
 * JD-Core Version:    0.7.0.1
 */