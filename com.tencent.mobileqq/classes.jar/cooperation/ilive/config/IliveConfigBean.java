package cooperation.ilive.config;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.IlivePluginDownloadManager;
import cooperation.ilive.manager.IliveDbManager;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class IliveConfigBean
{
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  
  public IliveConfigBean()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static IliveConfigBean a()
  {
    IliveConfigBean localIliveConfigBean = IliveDbManager.getIliveConfigBean(1);
    if ((localIliveConfigBean != null) && (!localIliveConfigBean.jdField_a_of_type_Boolean) && (new File(localIliveConfigBean.e()).exists()))
    {
      localIliveConfigBean.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("IliveConfigBean", 2, "IlivePluginDownloadManager getConfig reset mIsUseAnchor = true");
      }
    }
    return localIliveConfigBean;
  }
  
  public static IliveConfigBean a(String paramString)
  {
    IliveConfigBean localIliveConfigBean = new IliveConfigBean();
    if (TextUtils.isEmpty(paramString)) {
      return localIliveConfigBean;
    }
    try
    {
      paramString = new JSONObject(paramString);
      localIliveConfigBean.jdField_a_of_type_Boolean = paramString.optBoolean("mIsUseAnchor");
      localIliveConfigBean.jdField_a_of_type_JavaLangString = paramString.optString("mWatchPluginUrl");
      localIliveConfigBean.b = paramString.optString("mWatchPluginMd5");
      localIliveConfigBean.c = paramString.optString("mAnchorPluginUrl");
      localIliveConfigBean.d = paramString.optString("mAnchorPluginMd5");
      return localIliveConfigBean;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return localIliveConfigBean;
  }
  
  public static String a(IliveConfigBean paramIliveConfigBean)
  {
    if (paramIliveConfigBean == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mIsUseAnchor", paramIliveConfigBean.jdField_a_of_type_Boolean);
      localJSONObject.put("mWatchPluginUrl", paramIliveConfigBean.jdField_a_of_type_JavaLangString);
      localJSONObject.put("mWatchPluginMd5", paramIliveConfigBean.b);
      localJSONObject.put("mAnchorPluginUrl", paramIliveConfigBean.c);
      localJSONObject.put("mAnchorPluginMd5", paramIliveConfigBean.d);
    }
    catch (JSONException paramIliveConfigBean)
    {
      paramIliveConfigBean.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  public static boolean a()
  {
    Object localObject = IliveDbManager.getIliveConfigBean(1);
    int i;
    int j;
    if ((localObject != null) && (!((IliveConfigBean)localObject).jdField_a_of_type_Boolean))
    {
      i = -1;
      j = i;
    }
    try
    {
      localObject = Pattern.compile("\\d+").matcher(((IliveConfigBean)localObject).jdField_a_of_type_JavaLangString);
      for (;;)
      {
        k = i;
        j = i;
        if (!((Matcher)localObject).find()) {
          break;
        }
        j = i;
        i = Integer.parseInt(((Matcher)localObject).group());
      }
    }
    catch (Exception localException)
    {
      int k;
      label57:
      break label57;
    }
    QLog.e("IliveConfigBean", 1, "check need Preload error ");
    k = j;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("number");
    ((StringBuilder)localObject).append(k);
    QLog.e("IliveConfigBean", 1, ((StringBuilder)localObject).toString());
    if (k < 145) {
      return false;
    }
    return true;
  }
  
  private String d()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(IlivePluginDownloadManager.a());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("plugin_watch_manager_");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString.hashCode());
      localStringBuilder.append(".zip");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(IlivePluginDownloadManager.a());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("plugin_watch_manager.zip");
    return localStringBuilder.toString();
  }
  
  private String e()
  {
    if (!TextUtils.isEmpty(this.c))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(IlivePluginDownloadManager.a());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("plugin_anchor_manager_");
      localStringBuilder.append(this.c.hashCode());
      localStringBuilder.append(".zip");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(IlivePluginDownloadManager.a());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("plugin_anchor_manager.zip");
    return localStringBuilder.toString();
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return e();
    }
    return d();
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.d;
    }
    return this.b;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.c;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsUseAnchor = ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" mWatchPluginMd5 =  ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" , mAnchorPluginMd5 = ");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.config.IliveConfigBean
 * JD-Core Version:    0.7.0.1
 */