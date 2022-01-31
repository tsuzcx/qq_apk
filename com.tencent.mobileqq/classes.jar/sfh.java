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

public class sfh
  implements bbiy
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
  bbly jdField_a_of_type_Bbly;
  private bblz jdField_a_of_type_Bblz = new sfi(this);
  bcdp jdField_a_of_type_Bcdp;
  private QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  private File jdField_a_of_type_JavaIoFile;
  private FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  private String jdField_a_of_type_JavaLangString = "PublicAccountH5AbilityForPtt";
  private int jdField_b_of_type_Int = 60000;
  private String jdField_b_of_type_JavaLangString;
  
  public sfh() {}
  
  public sfh(Activity paramActivity, String paramString, bcdp parambcdp)
  {
    this.jdField_a_of_type_Bcdp = parambcdp;
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
    SpannableString localSpannableString = new SpannableString(this.jdField_a_of_type_AndroidAppActivity.getString(2131698555));
    bbdj.a(this.jdField_a_of_type_AndroidAppActivity, ajya.a(2131708810), localSpannableString, 0, 2131720422, null, null, new sfj(this)).show();
  }
  
  public int a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retCode", 0);
      localJSONObject.put("msg", "startRecord");
      if (this.jdField_a_of_type_Bcdp.a() != null) {
        this.jdField_a_of_type_Bcdp.a().callJs(sfk.c, new String[] { localJSONObject.toString() });
      }
      axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, 0, "1", "", "", "");
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
    axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (a(ajsd.aW + "c2bPTT/"))
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
      if (this.jdField_a_of_type_Bcdp.a() != null) {
        this.jdField_a_of_type_Bcdp.a().callJs(sfk.c, new String[] { paramString.toString() });
      }
      axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
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
          paramString.put("msg", ajya.a(2131708790));
          paramString.put("localId", d());
          if (this.jdField_a_of_type_Bcdp.a() != null) {
            this.jdField_a_of_type_Bcdp.a().callJs(sfk.g, new String[] { paramString.toString() });
          }
          axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2B", "0X8005D2B", 0, 0, "1", "", "", "");
          return;
        }
        if (this.jdField_a_of_type_JavaIoFile.exists())
        {
          paramString.put("retCode", 0);
          paramString.put("msg", ajya.a(2131708756) + d());
          paramString.put("localId", d());
          axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2A", "0X8005D2A", 0, 0, "1", "", "", "");
          if (this.jdField_a_of_type_Bcdp.a() == null) {
            break;
          }
          this.jdField_a_of_type_Bcdp.a().callJs(sfk.d, new String[] { paramString.toString() });
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString.put("retCode", -1);
      paramString.put("msg", ajya.a(2131708816));
      paramString.put("localId", d());
      axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2A", "0X8005D2A", 0, -1, "1", "", "", "");
    }
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("retCode", -1);
      paramString1.put("msg", "onRecorderError");
      if (this.jdField_a_of_type_Bcdp.a() != null) {
        this.jdField_a_of_type_Bcdp.a().callJs(sfk.c, new String[] { paramString1.toString() });
      }
      axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
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
    return ajsd.aW + "c2bPTT/" + paramString + ".amr";
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.jdField_a_of_type_AndroidAppActivity);
    }
    f = ajsd.aW + "c2bPTT/" + ayqo.a() + ".amr";
    bbcf.a(this.jdField_a_of_type_AndroidAppActivity, true);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b(f);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Bbly == null) || (this.jdField_a_of_type_AndroidOsHandler == null) || ((this.jdField_a_of_type_Bbly != null) && (this.jdField_a_of_type_Bbly.a() != 3)))
      {
        this.jdField_a_of_type_AndroidOsHandler = new Handler();
        this.jdField_a_of_type_Bbly = new bbly(paramString, this.jdField_a_of_type_AndroidOsHandler);
      }
      this.jdField_a_of_type_Bbly.a(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_Bbly.b();
      this.jdField_a_of_type_Bbly.a(this.jdField_a_of_type_Bblz);
      if (this.jdField_a_of_type_Bbly.a() == 1)
      {
        this.jdField_a_of_type_Bbly.c();
        return;
      }
    } while (this.jdField_a_of_type_Bbly.a() != 3);
    this.jdField_a_of_type_Bbly.d();
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    d(paramString, paramRecorderParam);
    paramString = new JSONObject();
    try
    {
      paramString.put("retCode", -1);
      paramString.put("msg", "onRecorderAbnormal");
      if (this.jdField_a_of_type_Bcdp.a() != null) {
        this.jdField_a_of_type_Bcdp.a().callJs(sfk.c, new String[] { paramString.toString() });
      }
      axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
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
    return (this.jdField_a_of_type_Bbly != null) && (this.jdField_a_of_type_Bbly.a() == 2);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = null;
    }
    d();
    bbcf.a(this.jdField_a_of_type_AndroidAppActivity, false);
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    d(paramString, paramRecorderParam);
    paramString = new JSONObject();
    try
    {
      paramString.put("retCode", -1);
      paramString.put("msg", "onInitFailed");
      if (this.jdField_a_of_type_Bcdp.a() != null) {
        this.jdField_a_of_type_Bcdp.a().callJs(sfk.c, new String[] { paramString.toString() });
      }
      axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
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
    if (this.jdField_a_of_type_Bbly != null)
    {
      this.jdField_a_of_type_Bbly.f();
      this.jdField_a_of_type_Bbly = null;
      this.jdField_a_of_type_AndroidOsHandler = null;
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("retCode", 0);
      localJSONObject.put("msg", ajya.a(2131708759) + d() + ajya.a(2131708827));
      localJSONObject.put("localId", d());
      if (this.jdField_a_of_type_Bcdp.a() != null) {
        this.jdField_a_of_type_Bcdp.a().callJs(sfk.f, new String[] { localJSONObject.toString() });
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
    if ((this.jdField_a_of_type_Bbly != null) && (this.jdField_a_of_type_Bbly.a() == 2)) {
      this.jdField_a_of_type_Bbly.e();
    }
  }
  
  public void h()
  {
    try
    {
      File localFile = new File(f);
      if (localFile.exists())
      {
        d = bfko.a(localFile);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sfh
 * JD-Core Version:    0.7.0.1
 */