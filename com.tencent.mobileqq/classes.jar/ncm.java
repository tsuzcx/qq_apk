import android.content.Context;
import android.content.Intent;
import com.tencent.biz.huanjiplugin.TranslucentActivty;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;

public class ncm
{
  private static volatile ncm jdField_a_of_type_Ncm;
  int jdField_a_of_type_Int = 0;
  private bgkq jdField_a_of_type_Bgkq;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  OnPluginInstallListener jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new ncn(this);
  String jdField_a_of_type_JavaLangString;
  nco jdField_a_of_type_Nco;
  
  public static ncm a()
  {
    if (jdField_a_of_type_Ncm == null) {}
    try
    {
      if (jdField_a_of_type_Ncm == null) {
        jdField_a_of_type_Ncm = new ncm();
      }
      return jdField_a_of_type_Ncm;
    }
    finally {}
  }
  
  public ncl a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HuanjiPlugin", 2, "queryStatuspackageName = " + paramString1 + "pluginId =" + paramString2 + "version = " + paramString3);
    }
    if ((this.jdField_a_of_type_Bgkq == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return null;
    }
    paramString1 = this.jdField_a_of_type_Bgkq.a("qhuanji_plugin.apk");
    if ((paramString1 != null) && (QLog.isColorLevel())) {
      QLog.w("HuanjiPlugin", 2, "queryPluginstate = " + paramString1.mState + "pluginSize =" + paramString1.mLength + "version = " + paramString1.mVersion);
    }
    paramString2 = new ncl();
    if (paramString1 != null)
    {
      if (paramString1.mState == 0) {
        ncl.jdField_a_of_type_Int = 0;
      }
      for (;;)
      {
        ncl.jdField_a_of_type_Long = paramString1.mLength;
        return paramString2;
        if (paramString1.mState == 2) {
          ncl.jdField_a_of_type_Int = 1;
        } else if ((paramString1.mState == 4) && (paramString1.mVersion.equals(paramString3))) {
          ncl.jdField_a_of_type_Int = 2;
        } else if ((paramString1.mState == 4) && (!paramString1.mVersion.equals(paramString3))) {
          ncl.jdField_a_of_type_Int = 3;
        }
      }
    }
    ncl.jdField_a_of_type_Int = 0;
    return paramString2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Nco != null) {
      this.jdField_a_of_type_Nco.a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bgkq = ((bgkq)paramQQAppInterface.getManager(27));
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, nco paramnco)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HuanjiPlugin", 2, "huanjiDownloadstartParam = " + paramString2);
    }
    axra localaxra = new axra(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_huanji").c("Grp_download");
    String str;
    if (paramInt == 2)
    {
      str = "Clk_start";
      localaxra.d(str).a(new String[] { paramString1 }).a();
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_JavaLangString = paramString2;
      paramString1 = this.jdField_a_of_type_Bgkq.a("qhuanji_plugin.apk");
      this.jdField_a_of_type_Nco = paramnco;
      if ((paramString1 == null) || (paramString1.mState == 4)) {
        break label163;
      }
      if (QLog.isColorLevel()) {
        QLog.w("HuanjiPlugin", 2, "换机插件还未安装 installPlugin");
      }
      this.jdField_a_of_type_Bgkq.installPlugin("qhuanji_plugin.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener);
    }
    label163:
    do
    {
      return true;
      str = "Clk_download";
      break;
      if (paramInt == 2)
      {
        paramString1 = new Intent(BaseApplicationImpl.getApplication().getApplicationContext(), TranslucentActivty.class);
        paramString1.putExtra("startParam", paramString2);
        paramString1.addFlags(268435456);
        paramString1.putExtras(paramString1);
        BaseApplicationImpl.getApplication().getApplicationContext().startActivity(paramString1);
        return true;
      }
    } while (this.jdField_a_of_type_Nco == null);
    this.jdField_a_of_type_Nco.a(3, 4, 100);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ncm
 * JD-Core Version:    0.7.0.1
 */