package com.tencent.mobileqq.webviewplugin;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class SocialWeeklyWebViewPlugin
  extends WebViewPlugin
{
  private String a;
  
  public SocialWeeklyWebViewPlugin()
  {
    this.mPluginNameSpace = "SocialWeekly";
  }
  
  /* Error */
  private String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 6
    //   8: aload_1
    //   9: iconst_0
    //   10: invokestatic 28	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   13: astore 5
    //   15: goto +43 -> 58
    //   18: astore_3
    //   19: new 30	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   26: astore 4
    //   28: aload 4
    //   30: ldc 33
    //   32: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 4
    //   38: aload_1
    //   39: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: ldc 39
    //   45: iconst_1
    //   46: aload 4
    //   48: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: aload_3
    //   52: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   55: aconst_null
    //   56: astore 5
    //   58: aload 5
    //   60: ifnull +260 -> 320
    //   63: ldc 51
    //   65: invokestatic 56	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   68: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   71: ifeq +17 -> 88
    //   74: new 64	java/io/File
    //   77: dup
    //   78: getstatic 69	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   81: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: astore_1
    //   85: goto +10 -> 95
    //   88: invokestatic 78	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   91: invokevirtual 82	com/tencent/common/app/BaseApplicationImpl:getCacheDir	()Ljava/io/File;
    //   94: astore_1
    //   95: new 64	java/io/File
    //   98: dup
    //   99: aload_1
    //   100: ldc 12
    //   102: invokespecial 85	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   105: astore_1
    //   106: aload_1
    //   107: invokevirtual 89	java/io/File:exists	()Z
    //   110: ifne +8 -> 118
    //   113: aload_1
    //   114: invokevirtual 92	java/io/File:mkdirs	()Z
    //   117: pop
    //   118: new 64	java/io/File
    //   121: dup
    //   122: aload_1
    //   123: aload 5
    //   125: invokestatic 98	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   128: invokespecial 85	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   131: astore 8
    //   133: aload 8
    //   135: invokevirtual 89	java/io/File:exists	()Z
    //   138: ifeq +9 -> 147
    //   141: aload 8
    //   143: invokevirtual 101	java/io/File:delete	()Z
    //   146: pop
    //   147: new 103	java/io/FileOutputStream
    //   150: dup
    //   151: aload 8
    //   153: invokespecial 106	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   156: astore_1
    //   157: new 108	java/io/BufferedOutputStream
    //   160: dup
    //   161: aload_1
    //   162: invokespecial 111	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   165: astore 4
    //   167: aload_1
    //   168: astore_2
    //   169: aload 4
    //   171: astore_3
    //   172: aload 4
    //   174: aload 5
    //   176: invokevirtual 115	java/io/BufferedOutputStream:write	([B)V
    //   179: aload_1
    //   180: astore_2
    //   181: aload 4
    //   183: astore_3
    //   184: aload 8
    //   186: invokevirtual 118	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   189: astore 5
    //   191: aload 5
    //   193: astore_2
    //   194: aload_1
    //   195: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   198: aload 4
    //   200: astore_1
    //   201: aload 5
    //   203: astore_3
    //   204: aload_3
    //   205: astore_2
    //   206: aload_1
    //   207: invokevirtual 122	java/io/BufferedOutputStream:close	()V
    //   210: aload_3
    //   211: areturn
    //   212: astore_2
    //   213: aload_1
    //   214: astore 5
    //   216: aload 4
    //   218: astore_1
    //   219: aload_2
    //   220: astore 4
    //   222: goto +41 -> 263
    //   225: astore 4
    //   227: aconst_null
    //   228: astore_3
    //   229: aload_1
    //   230: astore_2
    //   231: aload 4
    //   233: astore_1
    //   234: goto +68 -> 302
    //   237: astore 4
    //   239: aconst_null
    //   240: astore_2
    //   241: aload_1
    //   242: astore 5
    //   244: aload_2
    //   245: astore_1
    //   246: goto +17 -> 263
    //   249: astore_1
    //   250: aconst_null
    //   251: astore_3
    //   252: goto +50 -> 302
    //   255: astore 4
    //   257: aconst_null
    //   258: astore 5
    //   260: aload 5
    //   262: astore_1
    //   263: aload 5
    //   265: astore_2
    //   266: aload_1
    //   267: astore_3
    //   268: ldc 39
    //   270: iconst_1
    //   271: ldc 124
    //   273: aload 4
    //   275: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   278: aload 5
    //   280: ifnull +11 -> 291
    //   283: aload 7
    //   285: astore_2
    //   286: aload 5
    //   288: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   291: aload_1
    //   292: ifnull +28 -> 320
    //   295: aload 6
    //   297: astore_3
    //   298: goto -94 -> 204
    //   301: astore_1
    //   302: aload_2
    //   303: ifnull +7 -> 310
    //   306: aload_2
    //   307: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   310: aload_3
    //   311: ifnull +7 -> 318
    //   314: aload_3
    //   315: invokevirtual 122	java/io/BufferedOutputStream:close	()V
    //   318: aload_1
    //   319: athrow
    //   320: aconst_null
    //   321: areturn
    //   322: astore_1
    //   323: aload_2
    //   324: areturn
    //   325: astore_2
    //   326: goto -8 -> 318
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	SocialWeeklyWebViewPlugin
    //   0	329	1	paramString	String
    //   1	205	2	localObject1	Object
    //   212	8	2	localException1	Exception
    //   230	94	2	localObject2	Object
    //   325	1	2	localException2	Exception
    //   18	34	3	localException3	Exception
    //   171	144	3	localObject3	Object
    //   26	195	4	localObject4	Object
    //   225	7	4	localObject5	Object
    //   237	1	4	localException4	Exception
    //   255	19	4	localException5	Exception
    //   13	274	5	localObject6	Object
    //   6	290	6	localObject7	Object
    //   3	281	7	localObject8	Object
    //   131	54	8	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   8	15	18	java/lang/Exception
    //   172	179	212	java/lang/Exception
    //   184	191	212	java/lang/Exception
    //   157	167	225	finally
    //   157	167	237	java/lang/Exception
    //   63	85	249	finally
    //   88	95	249	finally
    //   95	118	249	finally
    //   118	147	249	finally
    //   147	157	249	finally
    //   63	85	255	java/lang/Exception
    //   88	95	255	java/lang/Exception
    //   95	118	255	java/lang/Exception
    //   118	147	255	java/lang/Exception
    //   147	157	255	java/lang/Exception
    //   172	179	301	finally
    //   184	191	301	finally
    //   268	278	301	finally
    //   194	198	322	java/lang/Exception
    //   206	210	322	java/lang/Exception
    //   286	291	322	java/lang/Exception
    //   306	310	325	java/lang/Exception
    //   314	318	325	java/lang/Exception
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = false;
    if (bool1) {
      QLog.d("SocialWeeklyWebViewPlugin", 2, String.format("handleJsRequest pkgName=%s method=%s url=%s", new Object[] { paramString2, paramString3, paramString1 }));
    }
    bool1 = bool2;
    if ("SocialWeekly".equals(paramString2))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString3))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString1))
        {
          bool1 = bool2;
          if ("sharePicMessage".equals(paramString3))
          {
            try
            {
              paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
              if (paramJsBridgeListener != null)
              {
                paramJsBridgeListener = paramJsBridgeListener.getString("imageData");
                if (!TextUtils.isEmpty(paramJsBridgeListener))
                {
                  int i = paramJsBridgeListener.indexOf(',');
                  if (i > 0) {
                    postPluginAsyncTask(new SocialWeeklyWebViewPlugin.1(this, paramJsBridgeListener.substring(i)));
                  }
                }
              }
            }
            catch (Exception paramJsBridgeListener)
            {
              QLog.d("SocialWeeklyWebViewPlugin", 1, "handleJsRequest json parse fail!", paramJsBridgeListener);
            }
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected void onPostPluginAsyncTask()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPostPluginAsyncTask mSharePicLocalPath=");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("SocialWeeklyWebViewPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.a))
    {
      localObject = this.mRuntime.a();
      if (localObject != null)
      {
        Intent localIntent = new Intent();
        localIntent.setClass((Context)localObject, ForwardRecentActivity.class);
        localIntent.putExtra("forward_type", 1);
        localIntent.putExtra("forward_filepath", this.a);
        localIntent.putExtra("isFromShare", true);
        ((Context)localObject).startActivity(localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.SocialWeeklyWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */