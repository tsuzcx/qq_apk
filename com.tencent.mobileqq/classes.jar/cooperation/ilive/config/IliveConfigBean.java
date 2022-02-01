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
  public boolean a = false;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public static IliveConfigBean a(String paramString)
  {
    IliveConfigBean localIliveConfigBean = new IliveConfigBean();
    if (TextUtils.isEmpty(paramString)) {
      return localIliveConfigBean;
    }
    try
    {
      paramString = new JSONObject(paramString);
      localIliveConfigBean.a = paramString.optBoolean("mIsUseAnchor");
      localIliveConfigBean.b = paramString.optString("mWatchPluginUrl");
      localIliveConfigBean.c = paramString.optString("mWatchPluginMd5");
      localIliveConfigBean.d = paramString.optString("mAnchorPluginUrl");
      localIliveConfigBean.e = paramString.optString("mAnchorPluginMd5");
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
      localJSONObject.put("mIsUseAnchor", paramIliveConfigBean.a);
      localJSONObject.put("mWatchPluginUrl", paramIliveConfigBean.b);
      localJSONObject.put("mWatchPluginMd5", paramIliveConfigBean.c);
      localJSONObject.put("mAnchorPluginUrl", paramIliveConfigBean.d);
      localJSONObject.put("mAnchorPluginMd5", paramIliveConfigBean.e);
    }
    catch (JSONException paramIliveConfigBean)
    {
      paramIliveConfigBean.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  public static IliveConfigBean d()
  {
    IliveConfigBean localIliveConfigBean = IliveDbManager.getIliveConfigBean(1);
    if ((localIliveConfigBean != null) && (!localIliveConfigBean.a) && (new File(localIliveConfigBean.g()).exists()))
    {
      localIliveConfigBean.a = true;
      if (QLog.isColorLevel()) {
        QLog.i("IliveConfigBean", 2, "IlivePluginDownloadManager getConfig reset mIsUseAnchor = true");
      }
    }
    return localIliveConfigBean;
  }
  
  public static boolean e()
  {
    Object localObject = IliveDbManager.getIliveConfigBean(1);
    int i;
    int j;
    if ((localObject != null) && (!((IliveConfigBean)localObject).a))
    {
      i = -1;
      j = i;
    }
    try
    {
      localObject = Pattern.compile("\\d+").matcher(((IliveConfigBean)localObject).b);
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
  
  private String f()
  {
    if (!TextUtils.isEmpty(this.b))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(IlivePluginDownloadManager.b());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("plugin_watch_manager_");
      localStringBuilder.append(this.b.hashCode());
      localStringBuilder.append(".zip");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(IlivePluginDownloadManager.b());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("plugin_watch_manager.zip");
    return localStringBuilder.toString();
  }
  
  private String g()
  {
    if (!TextUtils.isEmpty(this.d))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(IlivePluginDownloadManager.b());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("plugin_anchor_manager_");
      localStringBuilder.append(this.d.hashCode());
      localStringBuilder.append(".zip");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(IlivePluginDownloadManager.b());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("plugin_anchor_manager.zip");
    return localStringBuilder.toString();
  }
  
  public String a()
  {
    if (this.a) {
      return g();
    }
    return f();
  }
  
  public String b()
  {
    if (this.a) {
      return this.e;
    }
    return this.c;
  }
  
  public String c()
  {
    if (this.a) {
      return this.d;
    }
    return this.b;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsUseAnchor = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" mWatchPluginMd5 =  ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" , mAnchorPluginMd5 = ");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.config.IliveConfigBean
 * JD-Core Version:    0.7.0.1
 */