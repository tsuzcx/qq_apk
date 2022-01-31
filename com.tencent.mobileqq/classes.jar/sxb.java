import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityForPtt.2;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityForPtt.3;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class sxb
  implements bdhu
{
  private static double jdField_a_of_type_Double;
  private static int jdField_a_of_type_Int;
  private static String c = "";
  private static String d = "";
  private static String e = "";
  private static String f = "";
  private static String g = "";
  public Activity a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  bdks jdField_a_of_type_Bdks;
  private bdkt jdField_a_of_type_Bdkt = new sxc(this);
  becq jdField_a_of_type_Becq;
  private QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  private File jdField_a_of_type_JavaIoFile;
  private FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  private String jdField_a_of_type_JavaLangString = "PublicAccountH5AbilityForPtt";
  private int jdField_b_of_type_Int = 60000;
  private String jdField_b_of_type_JavaLangString;
  
  public sxb() {}
  
  public sxb(Activity paramActivity, String paramString, becq parambecq)
  {
    this.jdField_a_of_type_Becq = parambecq;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public static String a()
  {
    return c;
  }
  
  public static int b()
  {
    return jdField_a_of_type_Int;
  }
  
  public static String b()
  {
    return d;
  }
  
  public static int c()
  {
    if (jdField_a_of_type_Double != 0.0D) {
      return QQRecorder.a(jdField_a_of_type_Double);
    }
    return 0;
  }
  
  public static String c()
  {
    return e;
  }
  
  public static void c(String paramString)
  {
    c = paramString;
  }
  
  public static void d(String paramString)
  {
    g = paramString;
  }
  
  private void j()
  {
    SpannableString localSpannableString = new SpannableString(this.jdField_a_of_type_AndroidAppActivity.getString(2131698850));
    bdcd.a(this.jdField_a_of_type_AndroidAppActivity, alpo.a(2131709182), localSpannableString, 0, 2131720960, null, null, new sxd(this)).show();
  }
  
  public int a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retCode", 0);
      localJSONObject.put("msg", "startRecord");
      if (this.jdField_a_of_type_Becq.a() != null) {
        this.jdField_a_of_type_Becq.a().callJs(sxe.c, new String[] { localJSONObject.toString() });
      }
      azmj.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, 0, "1", "", "", "");
      i();
      return 0;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = g;
    }
    paramString = str.split("/");
    str = paramString[(paramString.length - 1)];
    paramString = "";
    if (str.length() >= 21) {
      paramString = str.substring(0, str.length() - 4);
    }
    return paramString;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    azmj.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (a(aljq.aX + "c2bPTT/"))
    {
      this.jdField_a_of_type_JavaIoFile = new File(paramString);
      if (this.jdField_a_of_type_JavaIoFile.exists()) {
        this.jdField_a_of_type_JavaIoFile.delete();
      }
      try
      {
        this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(this.jdField_a_of_type_JavaIoFile);
        this.jdField_a_of_type_JavaIoFileOutputStream.write("#!AMR\n".getBytes());
        return;
      }
      catch (FileNotFoundException paramString)
      {
        this.jdField_a_of_type_JavaIoFileOutputStream = null;
        paramString.printStackTrace();
        return;
      }
      catch (IOException paramString)
      {
        this.jdField_a_of_type_JavaIoFileOutputStream = null;
        return;
      }
    }
    paramString = new JSONObject();
    try
    {
      paramString.put("retCode", -1);
      paramString.put("msg", "no sdCard");
      if (this.jdField_a_of_type_Becq.a() != null) {
        this.jdField_a_of_type_Becq.a().callJs(sxe.c, new String[] { paramString.toString() });
      }
      azmj.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
      return;
    }
    catch (JSONException paramRecorderParam)
    {
      for (;;)
      {
        paramRecorderParam.printStackTrace();
      }
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    jdField_a_of_type_Double = paramDouble;
    paramString = new JSONObject();
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_Double == this.jdField_b_of_type_Int)
        {
          paramString.put("retCode", 0);
          paramString.put("msg", alpo.a(2131709162));
          paramString.put("localId", d());
          if (this.jdField_a_of_type_Becq.a() != null) {
            this.jdField_a_of_type_Becq.a().callJs(sxe.g, new String[] { paramString.toString() });
          }
          azmj.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2B", "0X8005D2B", 0, 0, "1", "", "", "");
          return;
        }
        if (this.jdField_a_of_type_JavaIoFile.exists())
        {
          paramString.put("retCode", 0);
          paramString.put("msg", alpo.a(2131709128) + d());
          paramString.put("localId", d());
          azmj.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2A", "0X8005D2A", 0, 0, "1", "", "", "");
          if (this.jdField_a_of_type_Becq.a() == null) {
            break;
          }
          this.jdField_a_of_type_Becq.a().callJs(sxe.d, new String[] { paramString.toString() });
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString.put("retCode", -1);
      paramString.put("msg", alpo.a(2131709188));
      paramString.put("localId", d());
      azmj.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2A", "0X8005D2A", 0, -1, "1", "", "", "");
    }
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("retCode", -1);
      paramString1.put("msg", "onRecorderError");
      if (this.jdField_a_of_type_Becq.a() != null) {
        this.jdField_a_of_type_Becq.a().callJs(sxe.c, new String[] { paramString1.toString() });
      }
      azmj.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
      return;
    }
    catch (JSONException paramRecorderParam)
    {
      for (;;)
      {
        paramRecorderParam.printStackTrace();
      }
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {
        this.jdField_a_of_type_JavaIoFileOutputStream.write(paramArrayOfByte, 0, paramInt1);
      }
      return;
    }
    catch (IOException paramString) {}
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b());
  }
  
  boolean a(String paramString)
  {
    paramString = new File(paramString);
    return (paramString.exists()) || (paramString.mkdirs());
  }
  
  public String b(String paramString)
  {
    return aljq.aX + "c2bPTT/" + paramString + ".amr";
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.jdField_a_of_type_AndroidAppActivity);
    }
    f = aljq.aX + "c2bPTT/" + baoj.a() + ".amr";
    bdaz.a(this.jdField_a_of_type_AndroidAppActivity, true);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b(f);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Bdks == null) || (this.jdField_a_of_type_AndroidOsHandler == null) || ((this.jdField_a_of_type_Bdks != null) && (this.jdField_a_of_type_Bdks.a() != 3)))
      {
        this.jdField_a_of_type_AndroidOsHandler = new Handler();
        this.jdField_a_of_type_Bdks = new bdks(paramString, this.jdField_a_of_type_AndroidOsHandler);
      }
      this.jdField_a_of_type_Bdks.a(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_Bdks.b();
      this.jdField_a_of_type_Bdks.a(this.jdField_a_of_type_Bdkt);
      if (this.jdField_a_of_type_Bdks.a() == 1)
      {
        this.jdField_a_of_type_Bdks.c();
        return;
      }
    } while (this.jdField_a_of_type_Bdks.a() != 3);
    this.jdField_a_of_type_Bdks.d();
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    d(paramString, paramRecorderParam);
    paramString = new JSONObject();
    try
    {
      paramString.put("retCode", -1);
      paramString.put("msg", "onRecorderAbnormal");
      if (this.jdField_a_of_type_Becq.a() != null) {
        this.jdField_a_of_type_Becq.a().callJs(sxe.c, new String[] { paramString.toString() });
      }
      azmj.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
      return;
    }
    catch (JSONException paramRecorderParam)
    {
      for (;;)
      {
        paramRecorderParam.printStackTrace();
      }
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Bdks != null) && (this.jdField_a_of_type_Bdks.a() == 2);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = null;
    }
    d();
    bdaz.a(this.jdField_a_of_type_AndroidAppActivity, false);
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    d(paramString, paramRecorderParam);
    paramString = new JSONObject();
    try
    {
      paramString.put("retCode", -1);
      paramString.put("msg", "onInitFailed");
      if (this.jdField_a_of_type_Becq.a() != null) {
        this.jdField_a_of_type_Becq.a().callJs(sxe.c, new String[] { paramString.toString() });
      }
      azmj.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
      return;
    }
    catch (JSONException paramRecorderParam)
    {
      for (;;)
      {
        paramRecorderParam.printStackTrace();
      }
    }
  }
  
  public String d()
  {
    Object localObject1 = f.split("/");
    Object localObject2 = localObject1[(localObject1.length - 1)];
    localObject1 = "";
    if (localObject2.length() >= 21) {
      localObject1 = localObject2.substring(0, localObject2.length() - 4);
    }
    return localObject1;
  }
  
  public void d()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {
        this.jdField_a_of_type_JavaIoFileOutputStream.close();
      }
      label14:
      this.jdField_a_of_type_JavaIoFileOutputStream = null;
      return;
    }
    catch (IOException localIOException)
    {
      break label14;
    }
  }
  
  public void d(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new PublicAccountH5AbilityForPtt.3(this));
  }
  
  public void e()
  {
    JSONObject localJSONObject;
    if (this.jdField_a_of_type_Bdks != null)
    {
      this.jdField_a_of_type_Bdks.f();
      this.jdField_a_of_type_Bdks = null;
      this.jdField_a_of_type_AndroidOsHandler = null;
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("retCode", 0);
      localJSONObject.put("msg", alpo.a(2131709131) + d() + alpo.a(2131709199));
      localJSONObject.put("localId", d());
      if (this.jdField_a_of_type_Becq.a() != null) {
        this.jdField_a_of_type_Becq.a().callJs(sxe.f, new String[] { localJSONObject.toString() });
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void f()
  {
    if (b()) {
      e();
    }
    c();
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Bdks != null) && (this.jdField_a_of_type_Bdks.a() == 2)) {
      this.jdField_a_of_type_Bdks.e();
    }
  }
  
  public void h()
  {
    try
    {
      File localFile = new File(f);
      if (localFile.exists())
      {
        d = bhli.a(localFile);
        jdField_a_of_type_Int = (int)localFile.length();
        e = d;
      }
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public void i()
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new PublicAccountH5AbilityForPtt.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sxb
 * JD-Core Version:    0.7.0.1
 */