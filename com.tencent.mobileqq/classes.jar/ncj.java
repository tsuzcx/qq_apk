import android.content.Context;
import android.content.Intent;
import com.tencent.biz.huanjiplugin.TranslucentActivty;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;

public class ncj
{
  private static volatile ncj jdField_a_of_type_Ncj;
  int jdField_a_of_type_Int = 0;
  private bglh jdField_a_of_type_Bglh;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  OnPluginInstallListener jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new nck(this);
  String jdField_a_of_type_JavaLangString;
  ncl jdField_a_of_type_Ncl;
  
  public static ncj a()
  {
    if (jdField_a_of_type_Ncj == null) {}
    try
    {
      if (jdField_a_of_type_Ncj == null) {
        jdField_a_of_type_Ncj = new ncj();
      }
      return jdField_a_of_type_Ncj;
    }
    finally {}
  }
  
  public nci a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HuanjiPlugin", 2, "queryStatuspackageName = " + paramString1 + "pluginId =" + paramString2 + "version = " + paramString3);
    }
    if ((this.jdField_a_of_type_Bglh == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return null;
    }
    paramString1 = this.jdField_a_of_type_Bglh.a("qhuanji_plugin.apk");
    if ((paramString1 != null) && (QLog.isColorLevel())) {
      QLog.w("HuanjiPlugin", 2, "queryPluginstate = " + paramString1.mState + "pluginSize =" + paramString1.mLength + "version = " + paramString1.mVersion);
    }
    paramString2 = new nci();
    if (paramString1 != null)
    {
      if (paramString1.mState == 0) {
        nci.jdField_a_of_type_Int = 0;
      }
      for (;;)
      {
        nci.jdField_a_of_type_Long = paramString1.mLength;
        return paramString2;
        if (paramString1.mState == 2) {
          nci.jdField_a_of_type_Int = 1;
        } else if ((paramString1.mState == 4) && (paramString1.mVersion.equals(paramString3))) {
          nci.jdField_a_of_type_Int = 2;
        } else if ((paramString1.mState == 4) && (!paramString1.mVersion.equals(paramString3))) {
          nci.jdField_a_of_type_Int = 3;
        }
      }
    }
    nci.jdField_a_of_type_Int = 0;
    return paramString2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Ncl != null) {
      this.jdField_a_of_type_Ncl.a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bglh = ((bglh)paramQQAppInterface.getManager(27));
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, ncl paramncl)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HuanjiPlugin", 2, "huanjiDownloadstartParam = " + paramString2);
    }
    axrc localaxrc = new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_huanji").c("Grp_download");
    String str;
    if (paramInt == 2)
    {
      str = "Clk_start";
      localaxrc.d(str).a(new String[] { paramString1 }).a();
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_JavaLangString = paramString2;
      paramString1 = this.jdField_a_of_type_Bglh.a("qhuanji_plugin.apk");
      this.jdField_a_of_type_Ncl = paramncl;
      if ((paramString1 == null) || (paramString1.mState == 4)) {
        break label163;
      }
      if (QLog.isColorLevel()) {
        QLog.w("HuanjiPlugin", 2, "换机插件还未安装 installPlugin");
      }
      this.jdField_a_of_type_Bglh.installPlugin("qhuanji_plugin.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener);
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
    } while (this.jdField_a_of_type_Ncl == null);
    this.jdField_a_of_type_Ncl.a(3, 4, 100);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ncj
 * JD-Core Version:    0.7.0.1
 */