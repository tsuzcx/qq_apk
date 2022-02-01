package cooperation.qzone.webviewplugin.personalize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.vip.manager.MonitorManager;
import java.io.File;
import org.json.JSONObject;

public class QZoneFacadeJsHandleLogic
{
  public static final String AVATAR_FILE_CACHE_NAME = "avatar";
  public static final String FACE_SP_KEY = "key_personalize_prefix_19";
  public static final String KEY_PERSONALIZE_PREFIX = "key_personalize_prefix";
  public static final String TAG = "QZoneFacadeJsHandleLogic";
  
  public static String getAvatarFileCacheDir(Context paramContext)
  {
    return getExternalCacheDir("avatar");
  }
  
  public static String getAvatarIdFromFile()
  {
    Object localObject1 = getAvatarFileCacheDir(null);
    if (localObject1 != null)
    {
      ((String)localObject1).substring(0, ((String)localObject1).lastIndexOf("/"));
      localObject1 = new File((String)localObject1);
      if (((File)localObject1).isDirectory())
      {
        File[] arrayOfFile = ((File)localObject1).listFiles();
        int j = arrayOfFile.length;
        localObject1 = "";
        int i = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (i >= j) {
            break;
          }
          File localFile = arrayOfFile[i];
          localObject2 = localObject1;
          if (localFile.isDirectory())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(localFile.getName());
            ((StringBuilder)localObject2).append(",");
            localObject2 = ((StringBuilder)localObject2).toString();
          }
          i += 1;
          localObject1 = localObject2;
        }
      }
      Object localObject2 = "";
      if (((String)localObject2).length() > 0) {
        return ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
      }
    }
    return "";
  }
  
  public static String getExternalCacheDir(String paramString)
  {
    Object localObject = QZoneFacadeJsHandleLogic.InnerEnvironment.getExternalCacheDir();
    if (localObject == null) {
      return null;
    }
    localObject = ((File)localObject).getAbsolutePath();
    if (TextUtils.isEmpty(paramString)) {
      return localObject;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    paramString = new File(localStringBuilder.toString());
    try
    {
      if (paramString.isFile()) {
        FileUtils.delete(paramString);
      }
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return paramString.getAbsolutePath();
    }
    finally {}
  }
  
  public static void handleCheckDownloadedIdList(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneFacadeJsHandleLogic", 2, "handleCheckDownloadedIdList");
    }
    paramVarArgs = getAvatarIdFromFile();
    paramPluginRuntime = paramPluginRuntime.a();
    if (paramPluginRuntime != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("window.QzAvatarDressJSInterface.onReceive({type:\"idlist\",data:\"");
      localStringBuilder.append(paramVarArgs);
      localStringBuilder.append("\"});");
      paramPluginRuntime.callJs(localStringBuilder.toString());
    }
  }
  
  /* Error */
  public static void handleDownloadFacadeFinish(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 17
    //   8: iconst_2
    //   9: ldc 143
    //   11: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: ldc 59
    //   16: astore 4
    //   18: aload_1
    //   19: ifnull +70 -> 89
    //   22: aload_1
    //   23: arraylength
    //   24: ifle +65 -> 89
    //   27: new 145	org/json/JSONObject
    //   30: dup
    //   31: aload_1
    //   32: iconst_0
    //   33: aaload
    //   34: invokespecial 146	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: aload_3
    //   39: ldc 148
    //   41: invokevirtual 151	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore_2
    //   45: aload_3
    //   46: ldc 153
    //   48: invokevirtual 151	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore_1
    //   52: aload_3
    //   53: ldc 155
    //   55: invokevirtual 151	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   58: astore_3
    //   59: goto +38 -> 97
    //   62: astore_3
    //   63: goto +16 -> 79
    //   66: astore_3
    //   67: ldc 59
    //   69: astore_1
    //   70: goto +9 -> 79
    //   73: astore_3
    //   74: ldc 59
    //   76: astore_2
    //   77: aload_2
    //   78: astore_1
    //   79: aload_3
    //   80: invokevirtual 158	org/json/JSONException:printStackTrace	()V
    //   83: aload 4
    //   85: astore_3
    //   86: goto +11 -> 97
    //   89: ldc 59
    //   91: astore_2
    //   92: aload_2
    //   93: astore_1
    //   94: aload 4
    //   96: astore_3
    //   97: aload_1
    //   98: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   101: ifne +124 -> 225
    //   104: aload_0
    //   105: invokevirtual 161	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   108: ifnull +117 -> 225
    //   111: new 163	android/content/Intent
    //   114: dup
    //   115: ldc 165
    //   117: invokespecial 166	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   120: astore 4
    //   122: new 168	android/os/Bundle
    //   125: dup
    //   126: invokespecial 169	android/os/Bundle:<init>	()V
    //   129: astore 5
    //   131: aload 5
    //   133: ldc 171
    //   135: aload_2
    //   136: invokevirtual 175	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload 5
    //   141: ldc 153
    //   143: aload_1
    //   144: invokevirtual 175	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload 5
    //   149: ldc 155
    //   151: aload_3
    //   152: invokevirtual 175	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload 5
    //   157: ldc 177
    //   159: ldc 179
    //   161: invokevirtual 175	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload 4
    //   166: aload 5
    //   168: invokevirtual 183	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   171: pop
    //   172: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +38 -> 213
    //   178: new 61	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   185: astore_1
    //   186: aload_1
    //   187: ldc 185
    //   189: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_1
    //   194: aload 4
    //   196: invokevirtual 188	android/content/Intent:getAction	()Ljava/lang/String;
    //   199: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: ldc 17
    //   205: iconst_2
    //   206: aload_1
    //   207: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: aload_0
    //   214: invokevirtual 161	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   217: invokestatic 194	cooperation/qzone/QZoneHelper$UserInfo:getInstance	()Lcooperation/qzone/QZoneHelper$UserInfo;
    //   220: aload 4
    //   222: invokestatic 200	cooperation/qzone/QZoneHelper:forwardToQzoneTransluentActivity	(Landroid/app/Activity;Lcooperation/qzone/QZoneHelper$UserInfo;Landroid/content/Intent;)V
    //   225: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramPluginRuntime	WebViewPlugin.PluginRuntime
    //   0	226	1	paramVarArgs	String[]
    //   44	92	2	str	String
    //   37	22	3	localObject1	Object
    //   62	1	3	localJSONException1	org.json.JSONException
    //   66	1	3	localJSONException2	org.json.JSONException
    //   73	7	3	localJSONException3	org.json.JSONException
    //   85	67	3	localObject2	Object
    //   16	205	4	localObject3	Object
    //   129	38	5	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   52	59	62	org/json/JSONException
    //   45	52	66	org/json/JSONException
    //   27	45	73	org/json/JSONException
  }
  
  public static void handleSetFacadeFinish(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneFacadeJsHandleLogic", 2, "handleSetFacadeFinish");
    }
    if (paramPluginRuntime.a() != null)
    {
      if (paramPluginRuntime.a() == null) {
        return;
      }
      LocalMultiProcConfig.putInt4Uin("key_personalize_prefix_19", 0, Long.valueOf(paramPluginRuntime.a().getCurrentAccountUin()).longValue());
      Object localObject1 = new Intent("action_facade_js2qzone");
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putString("cmd", "setAvatar");
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("actionString: ");
        ((StringBuilder)localObject2).append(((Intent)localObject1).getAction());
        QLog.d("QZoneFacadeJsHandleLogic", 2, ((StringBuilder)localObject2).toString());
      }
      QZoneHelper.forwardToQzoneTransluentActivity(paramPluginRuntime.a(), QZoneHelper.UserInfo.getInstance(), (Intent)localObject1);
      int j = 1;
      int i = j;
      if (paramVarArgs != null)
      {
        i = j;
        if (paramVarArgs.length >= 1)
        {
          i = j;
          if (!TextUtils.isEmpty(paramVarArgs[0])) {
            try
            {
              i = new JSONObject(paramVarArgs[0]).optInt("need_jump");
              if (i == 1) {
                i = j;
              } else {
                i = 0;
              }
            }
            catch (Exception paramVarArgs)
            {
              QLog.e("QZoneFacadeJsHandleLogic", 1, paramVarArgs.getMessage());
              localObject1 = MonitorManager.a();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(" parse json error ");
              ((StringBuilder)localObject2).append(paramVarArgs.getStackTrace());
              ((MonitorManager)localObject1).a(15, 4, ((StringBuilder)localObject2).toString(), false);
              i = j;
            }
          }
        }
      }
      if (i != 0) {
        paramPluginRuntime.a().finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZoneFacadeJsHandleLogic
 * JD-Core Version:    0.7.0.1
 */