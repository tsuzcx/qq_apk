import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import cooperation.qzone.util.NetworkState;
import org.json.JSONException;
import org.json.JSONObject;

public class tam
{
  private static DownloadInfo a;
  
  public static DownloadInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    DownloadInfo localDownloadInfo = new DownloadInfo();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localDownloadInfo.jdField_c_of_type_JavaLangString = localJSONObject.getString("appid");
      localDownloadInfo.jdField_d_of_type_JavaLangString = localJSONObject.getString("url");
      localDownloadInfo.e = localJSONObject.getString("packageName");
      localDownloadInfo.h = localJSONObject.getString("via");
      localDownloadInfo.a = true;
      localDownloadInfo.jdField_d_of_type_Boolean = true;
      localDownloadInfo.i = TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE;
      String str = localJSONObject.getString("isAutoInstall");
      if (str != null) {
        localDownloadInfo.a = str.equals("1");
      }
      str = localJSONObject.getString("isAutoInstallBySDK");
      if (str != null) {
        localDownloadInfo.jdField_d_of_type_Boolean = str.equals("1");
      }
      str = localJSONObject.getString("isShowNotification");
      if (str != null) {
        if (!str.equals("1")) {
          break label189;
        }
      }
      label189:
      for (int i = TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE;; i = TMAssistantDownloadConst.SHOW_NOTIFICATION_FALSE)
      {
        localDownloadInfo.i = i;
        localDownloadInfo.jdField_c_of_type_Boolean = true;
        localDownloadInfo.m = ors.f(40677);
        localDownloadInfo.f = localJSONObject.getString("appName");
        return localDownloadInfo;
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("VideoFeedsWeiShiUtils", 4, "json err:" + paramString);
    }
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (paramString.equals("video_type_videocard")) {
        return "https://act.qzone.qq.com/vip/meteor/m/p/3f04eaa353710dd5c996e09588244bf93066";
      }
      if (paramString.equals("video_type_videoguid")) {
        return "https://act.qzone.qq.com/vip/meteor/m/p/01e512f4384e934f8b42e30f9e16f1283064";
      }
    } while (!paramString.equals("video_type_videopublic"));
    return "https://act.qzone.qq.com/vip/meteor/m/p/f644be070eeed9bcba017b43a8c7980a3065";
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    Intent localIntent;
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramString));
      localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.putExtra("big_brother_source_key", ors.f(40677));
      localIntent.putExtra("big_brother_ref_source_key", ors.f(0));
      localIntent.setData(Uri.parse(c(paramString)));
    } while (!rdm.a(paramContext, localIntent));
    paramContext.startActivity(localIntent);
  }
  
  public static DownloadInfo b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      DownloadInfo localDownloadInfo = new DownloadInfo();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (!localJSONObject.optBoolean("isWeb", false))
        {
          localDownloadInfo.jdField_d_of_type_JavaLangString = localJSONObject.optString("url");
          localDownloadInfo.e = localJSONObject.optString("packageName", null);
          localDownloadInfo.m = ors.f(0);
          return localDownloadInfo;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("VideoFeedsWeiShiUtils", 4, "json err:" + paramString);
      }
    }
    return null;
  }
  
  private static String b(String paramString)
  {
    return null;
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!TextUtils.isEmpty(b(paramString))) {
      a = a(b(paramString));
    }
    if (a != null)
    {
      if (NetworkState.getNetworkType() == 1)
      {
        bfok.a().a(a);
        return;
      }
      paramContext = bdgm.a(paramContext, 230);
      paramContext.setTitle(null);
      paramContext.setMessage(alud.a(2131716614));
      paramContext.setNegativeButton(alud.a(2131716602), new tao()).setPositiveButton(alud.a(2131716558), new tan());
      paramContext.show();
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", a(paramString));
    localIntent.putExtra("big_brother_source_key", ors.f(40677));
    paramContext.startActivity(localIntent);
  }
  
  private static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (paramString.equals("video_type_videocard")) {
        return "weishi://main?goto=recommend&logsour=5001";
      }
      if (paramString.equals("video_type_videoguid")) {
        return "weishi://main?goto=recommend&logsour=5002";
      }
    } while (!paramString.equals("video_type_videopublic"));
    return "weishi://main?goto=recommend&logsour=5003";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tam
 * JD-Core Version:    0.7.0.1
 */