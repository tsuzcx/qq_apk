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
  int jdField_a_of_type_Int = 0;
  public Dialog a;
  public Intent a;
  public ServiceConnection a;
  public PreloadProcHitPluginSession a;
  PluginBaseInfo jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo;
  public Class<? extends Activity> a;
  public String a;
  public List<RemoteCommand> a;
  public boolean a;
  int b;
  public String b;
  public boolean b;
  public int c = -1;
  String c;
  public int d = 10000;
  String d;
  public int e = 0;
  public String e;
  public int f = 0;
  public String f;
  public String g;
  
  public IPluginManager$PluginParams(int paramInt)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public IPluginManager$PluginParams(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo != null))
    {
      QLog.d("plugin_tag", 1, "pluginStartupAttachInfo dex2Oat " + this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo.costDex2Oat + "lib " + this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo.costLib + "download " + this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo.costDownload + "apk " + this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo.costApk);
      if ((this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo.costDex2Oat != 0L) || (this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo.costLib != 0L) || (this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo.costDownload != 0L) || (this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo.costApk != 0L))
      {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("pluginOatCost", this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo.costDex2Oat);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("pluginLibCost", this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo.costLib);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("pluginDownloadCost", this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo.costDownload);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("pluginApkCost", this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo.costApk);
        this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo.costDex2Oat = 0L;
        this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo.costLib = 0L;
        this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo.costDownload = 0L;
        this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo.costApk = 0L;
      }
    }
  }
  
  public void a(PluginBaseInfo paramPluginBaseInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo = paramPluginBaseInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.PluginParams
 * JD-Core Version:    0.7.0.1
 */