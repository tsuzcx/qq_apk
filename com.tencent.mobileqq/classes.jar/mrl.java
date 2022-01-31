import android.content.Context;
import android.content.Intent;
import com.tencent.biz.huanjiplugin.TranslucentActivty;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;

public class mrl
{
  private static volatile mrl jdField_a_of_type_Mrl;
  int jdField_a_of_type_Int = 0;
  private bfcz jdField_a_of_type_Bfcz;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  OnPluginInstallListener jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new mrm(this);
  String jdField_a_of_type_JavaLangString;
  mrn jdField_a_of_type_Mrn;
  
  public static mrl a()
  {
    if (jdField_a_of_type_Mrl == null) {}
    try
    {
      if (jdField_a_of_type_Mrl == null) {
        jdField_a_of_type_Mrl = new mrl();
      }
      return jdField_a_of_type_Mrl;
    }
    finally {}
  }
  
  public mrk a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HuanjiPlugin", 2, "queryStatuspackageName = " + paramString1 + "pluginId =" + paramString2 + "version = " + paramString3);
    }
    if ((this.jdField_a_of_type_Bfcz == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return null;
    }
    paramString1 = this.jdField_a_of_type_Bfcz.a("qhuanji_plugin.apk");
    if ((paramString1 != null) && (QLog.isColorLevel())) {
      QLog.w("HuanjiPlugin", 2, "queryPluginstate = " + paramString1.mState + "pluginSize =" + paramString1.mLength + "version = " + paramString1.mVersion);
    }
    paramString2 = new mrk();
    if (paramString1 != null)
    {
      if (paramString1.mState == 0) {
        mrk.jdField_a_of_type_Int = 0;
      }
      for (;;)
      {
        mrk.jdField_a_of_type_Long = paramString1.mLength;
        return paramString2;
        if (paramString1.mState == 2) {
          mrk.jdField_a_of_type_Int = 1;
        } else if ((paramString1.mState == 4) && (paramString1.mVersion.equals(paramString3))) {
          mrk.jdField_a_of_type_Int = 2;
        } else if ((paramString1.mState == 4) && (!paramString1.mVersion.equals(paramString3))) {
          mrk.jdField_a_of_type_Int = 3;
        }
      }
    }
    mrk.jdField_a_of_type_Int = 0;
    return paramString2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Mrn != null) {
      this.jdField_a_of_type_Mrn.a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bfcz = ((bfcz)paramQQAppInterface.getManager(27));
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, mrn parammrn)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HuanjiPlugin", 2, "huanjiDownloadstartParam = " + paramString2);
    }
    awrb localawrb = new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_huanji").c("Grp_download");
    String str;
    if (paramInt == 2)
    {
      str = "Clk_start";
      localawrb.d(str).a(new String[] { paramString1 }).a();
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_JavaLangString = paramString2;
      paramString1 = this.jdField_a_of_type_Bfcz.a("qhuanji_plugin.apk");
      this.jdField_a_of_type_Mrn = parammrn;
      if ((paramString1 == null) || (paramString1.mState == 4)) {
        break label163;
      }
      if (QLog.isColorLevel()) {
        QLog.w("HuanjiPlugin", 2, "换机插件还未安装 installPlugin");
      }
      this.jdField_a_of_type_Bfcz.installPlugin("qhuanji_plugin.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener);
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
    } while (this.jdField_a_of_type_Mrn == null);
    this.jdField_a_of_type_Mrn.a(3, 4, 100);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mrl
 * JD-Core Version:    0.7.0.1
 */