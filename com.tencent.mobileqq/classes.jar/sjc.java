import NS_KING_PUBLIC.stAuth;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.qzone.LocalMultiProcConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class sjc
{
  private static int jdField_a_of_type_Int;
  private static volatile sjc jdField_a_of_type_Sjc;
  private aabl jdField_a_of_type_Aabl;
  private Map<Long, sje> jdField_a_of_type_JavaUtilMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  
  private sjc()
  {
    a();
  }
  
  private Activity a()
  {
    Activity localActivity = null;
    if (SplashActivity.a != null) {
      localActivity = (Activity)SplashActivity.a.get();
    }
    Object localObject = localActivity;
    if (localActivity == null) {
      localObject = BaseActivity.sTopActivity;
    }
    return localObject;
  }
  
  public static sjc a()
  {
    if (jdField_a_of_type_Sjc == null) {}
    try
    {
      if (jdField_a_of_type_Sjc == null) {
        jdField_a_of_type_Sjc = new sjc();
      }
      return jdField_a_of_type_Sjc;
    }
    finally {}
  }
  
  private sje a()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      return (sje)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(snf.a()));
    }
    return null;
  }
  
  private void a(JSONObject paramJSONObject)
  {
    jdField_a_of_type_Int = 0;
    String str = paramJSONObject.optString("openid");
    paramJSONObject = paramJSONObject.optString("access_token");
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramJSONObject))) {
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(snf.a()), new sje(str, paramJSONObject));
    }
    str = bfnt.a(str, snf.a());
    paramJSONObject = bfnt.a(paramJSONObject, snf.a());
    LocalMultiProcConfig.putString4Uin("key_qq_connect_open_id", str, snf.a());
    LocalMultiProcConfig.putString4Uin("key_qq_connect_access_token", paramJSONObject, snf.a());
    LocalMultiProcConfig.putLong4Uin("key_qq_connect_auth_time", System.currentTimeMillis(), snf.a());
  }
  
  private boolean a()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        long l1 = snf.a();
        Object localObject1 = this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(l1));
        if (localObject1 != null) {
          return bool;
        }
        long l2 = System.currentTimeMillis();
        long l3 = LocalMultiProcConfig.getLong4Uin("key_qq_connect_auth_time", 0L, l1);
        snb.b("WSQQConnectAuthManager", "now qq connect auth time diff (sec) = " + (l2 - l3) / 1000L);
        if (l2 - l3 > 1728000000L)
        {
          bool = false;
        }
        else
        {
          localObject1 = LocalMultiProcConfig.getString4Uin("key_qq_connect_open_id", "", l1);
          String str1 = LocalMultiProcConfig.getString4Uin("key_qq_connect_access_token", "", l1);
          String str2 = bfnt.b((String)localObject1, snf.a());
          String str3 = bfnt.b(str1, snf.a());
          snb.b("weishi-828", "use sp openId and accessToken encrypted:" + (String)localObject1 + " , " + str1 + ", decrypt:" + str2 + " , " + str3);
          if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3))) {
            this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(snf.a()), new sje(str2, str3));
          } else {
            bool = false;
          }
        }
      }
      finally {}
    }
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      aabq.a();
      this.jdField_a_of_type_Aabl = aabq.a(a(), 6, String.valueOf(1101083114));
      if (this.jdField_a_of_type_Aabl != null) {
        this.jdField_a_of_type_Aabl.a("loginSilent", null, new sjd(this));
      }
    }
  }
  
  private void d()
  {
    jdField_a_of_type_Int += 1;
    snb.b("WSQQConnectAuthManager", "authRetry: " + jdField_a_of_type_Int);
    if (jdField_a_of_type_Int >= 3)
    {
      jdField_a_of_type_Int = 0;
      return;
    }
    c();
  }
  
  @NotNull
  public stAuth a(String paramString1, String paramString2)
  {
    sje localsje = a();
    if (localsje != null)
    {
      snb.b("weishi-828", "use memory openId and accessToken" + localsje.a + " , " + localsje.b);
      return new stAuth(1, localsje.a, localsje.b);
    }
    if (a())
    {
      localsje = a();
      if (localsje != null)
      {
        snb.b("weishi-828", "use memory openId and accessToken" + localsje.a + " , " + localsje.b);
        return new stAuth(1, localsje.a, localsje.b);
      }
    }
    snb.b("weishi-828", "未获取到openId和accessToken，使用了兜底方案");
    c();
    return new stAuth(2, paramString1, paramString2);
  }
  
  public void a()
  {
    if (!a()) {
      c();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sjc
 * JD-Core Version:    0.7.0.1
 */