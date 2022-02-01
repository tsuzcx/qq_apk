package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.model.PublishEventTag;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class QzoneMoodPlugin
  extends QzoneInternalWebViewPlugin
{
  private static final String TAG = "QzoneMoodPlugin";
  private static CopyOnWriteArrayList<QzoneMoodPlugin.FriendNickNames> listFriNickName = new CopyOnWriteArrayList();
  private static final Pattern patternEmo = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);
  private static final String regEmo = "\\[em\\]e\\d{1,}\\[/em\\]";
  private boolean mUseWechatSyncManager = false;
  
  private void deleteTimerShuoShuo()
  {
    RemoteHandleManager.getInstance().getSender().deleteTimerShuoShuo();
  }
  
  private void handleEditMoodSuccess()
  {
    Activity localActivity = this.parentPlugin.mRuntime.a();
    if (localActivity != null)
    {
      Intent localIntent = new Intent("action_personalize_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "refreshFeed");
      localIntent.putExtras(localBundle);
      QZoneHelper.forwardToQzoneTransluentActivity(this.parentPlugin.mRuntime.a(), QZoneHelper.UserInfo.getInstance(), localIntent);
      localActivity.setResult(-1);
      this.parentPlugin.mRuntime.a().finish();
    }
  }
  
  /* Error */
  private QzoneMoodPlugin.FriendNickNames loadFriendListFromQQ()
  {
    // Byte code:
    //   0: new 125	cooperation/qzone/webviewplugin/QzoneMoodPlugin$FriendNickNames
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 128	cooperation/qzone/webviewplugin/QzoneMoodPlugin$FriendNickNames:<init>	(Lcooperation/qzone/webviewplugin/QzoneMoodPlugin;)V
    //   8: astore 8
    //   10: aload 8
    //   12: aload_0
    //   13: getfield 67	cooperation/qzone/webviewplugin/QzoneMoodPlugin:parentPlugin	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   16: getfield 73	com/tencent/mobileqq/webview/swift/WebViewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   19: invokevirtual 131	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   22: invokevirtual 137	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   25: putfield 140	cooperation/qzone/webviewplugin/QzoneMoodPlugin$FriendNickNames:mainUin	Ljava/lang/String;
    //   28: invokestatic 146	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   31: invokevirtual 152	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   34: astore 4
    //   36: new 154	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   43: astore 5
    //   45: aload 5
    //   47: ldc 157
    //   49: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 5
    //   55: aload 8
    //   57: getfield 140	cooperation/qzone/webviewplugin/QzoneMoodPlugin$FriendNickNames:mainUin	Ljava/lang/String;
    //   60: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 4
    //   66: aload 5
    //   68: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 170	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   74: iconst_3
    //   75: anewarray 172	java/lang/String
    //   78: dup
    //   79: iconst_0
    //   80: ldc 174
    //   82: aastore
    //   83: dup
    //   84: iconst_1
    //   85: ldc 176
    //   87: aastore
    //   88: dup
    //   89: iconst_2
    //   90: ldc 178
    //   92: aastore
    //   93: aconst_null
    //   94: aconst_null
    //   95: aconst_null
    //   96: invokevirtual 184	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   99: astore 5
    //   101: aload 5
    //   103: ifnull +345 -> 448
    //   106: aload 5
    //   108: astore 4
    //   110: aload 5
    //   112: invokeinterface 190 1 0
    //   117: ifeq +331 -> 448
    //   120: aload 5
    //   122: astore 4
    //   124: aload 5
    //   126: ldc 174
    //   128: invokeinterface 194 2 0
    //   133: istore_1
    //   134: aload 5
    //   136: astore 4
    //   138: aload 5
    //   140: ldc 176
    //   142: invokeinterface 194 2 0
    //   147: istore_2
    //   148: aload 5
    //   150: astore 4
    //   152: aload 5
    //   154: ldc 178
    //   156: invokeinterface 194 2 0
    //   161: istore_3
    //   162: aload 5
    //   164: astore 4
    //   166: aload 5
    //   168: iload_1
    //   169: invokeinterface 198 2 0
    //   174: astore 6
    //   176: aload 5
    //   178: astore 4
    //   180: aload 6
    //   182: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   185: ifeq +6 -> 191
    //   188: goto +225 -> 413
    //   191: aload 5
    //   193: astore 4
    //   195: new 172	java/lang/String
    //   198: dup
    //   199: aload 6
    //   201: invokevirtual 208	java/lang/String:getBytes	()[B
    //   204: ldc 210
    //   206: invokespecial 213	java/lang/String:<init>	([BLjava/lang/String;)V
    //   209: iconst_0
    //   210: invokestatic 219	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;Z)Ljava/lang/String;
    //   213: astore 9
    //   215: aload 5
    //   217: astore 4
    //   219: aload 5
    //   221: iload_2
    //   222: invokeinterface 198 2 0
    //   227: astore 6
    //   229: aload 5
    //   231: astore 4
    //   233: aload 6
    //   235: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   238: ifne +47 -> 285
    //   241: aload 5
    //   243: astore 4
    //   245: new 172	java/lang/String
    //   248: dup
    //   249: aload 6
    //   251: invokevirtual 208	java/lang/String:getBytes	()[B
    //   254: ldc 210
    //   256: invokespecial 213	java/lang/String:<init>	([BLjava/lang/String;)V
    //   259: iconst_0
    //   260: invokestatic 219	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;Z)Ljava/lang/String;
    //   263: astore 6
    //   265: aload 5
    //   267: astore 4
    //   269: aload 8
    //   271: getfield 223	cooperation/qzone/webviewplugin/QzoneMoodPlugin$FriendNickNames:nickNamesMap	Ljava/util/HashMap;
    //   274: aload 9
    //   276: aload 6
    //   278: invokevirtual 229	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   281: pop
    //   282: goto +131 -> 413
    //   285: aload 5
    //   287: astore 4
    //   289: aload 5
    //   291: iload_3
    //   292: invokeinterface 198 2 0
    //   297: astore 6
    //   299: aload 5
    //   301: astore 4
    //   303: aload 6
    //   305: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   308: ifne +105 -> 413
    //   311: aload 5
    //   313: astore 4
    //   315: new 172	java/lang/String
    //   318: dup
    //   319: aload 6
    //   321: invokevirtual 208	java/lang/String:getBytes	()[B
    //   324: ldc 210
    //   326: invokespecial 213	java/lang/String:<init>	([BLjava/lang/String;)V
    //   329: iconst_0
    //   330: invokestatic 219	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;Z)Ljava/lang/String;
    //   333: astore 7
    //   335: aload 7
    //   337: astore 6
    //   339: aload 5
    //   341: astore 4
    //   343: aload 7
    //   345: invokevirtual 233	java/lang/String:length	()I
    //   348: iconst_1
    //   349: if_icmple +47 -> 396
    //   352: aload 7
    //   354: astore 6
    //   356: aload 5
    //   358: astore 4
    //   360: aload 7
    //   362: aload 7
    //   364: invokevirtual 233	java/lang/String:length	()I
    //   367: iconst_1
    //   368: isub
    //   369: invokevirtual 237	java/lang/String:charAt	(I)C
    //   372: bipush 10
    //   374: if_icmpne +22 -> 396
    //   377: aload 5
    //   379: astore 4
    //   381: aload 7
    //   383: iconst_0
    //   384: aload 7
    //   386: invokevirtual 233	java/lang/String:length	()I
    //   389: iconst_1
    //   390: isub
    //   391: invokevirtual 241	java/lang/String:substring	(II)Ljava/lang/String;
    //   394: astore 6
    //   396: aload 5
    //   398: astore 4
    //   400: aload 8
    //   402: getfield 223	cooperation/qzone/webviewplugin/QzoneMoodPlugin$FriendNickNames:nickNamesMap	Ljava/util/HashMap;
    //   405: aload 9
    //   407: aload 6
    //   409: invokevirtual 229	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   412: pop
    //   413: aload 5
    //   415: astore 4
    //   417: aload 5
    //   419: invokeinterface 244 1 0
    //   424: ifne -262 -> 162
    //   427: aload 5
    //   429: astore 4
    //   431: getstatic 35	cooperation/qzone/webviewplugin/QzoneMoodPlugin:listFriNickName	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   434: aload 8
    //   436: invokevirtual 248	java/util/concurrent/CopyOnWriteArrayList:add	(Ljava/lang/Object;)Z
    //   439: pop
    //   440: goto +8 -> 448
    //   443: astore 6
    //   445: goto +31 -> 476
    //   448: aload 5
    //   450: ifnull +10 -> 460
    //   453: aload 5
    //   455: invokeinterface 251 1 0
    //   460: aload 8
    //   462: areturn
    //   463: astore 4
    //   465: aconst_null
    //   466: astore 5
    //   468: goto +95 -> 563
    //   471: astore 6
    //   473: aconst_null
    //   474: astore 5
    //   476: aload 5
    //   478: astore 4
    //   480: new 154	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   487: astore 7
    //   489: aload 5
    //   491: astore 4
    //   493: aload 7
    //   495: ldc 253
    //   497: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload 5
    //   503: astore 4
    //   505: aload 7
    //   507: aload 6
    //   509: invokestatic 259	cooperation/qzone/util/QZLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   512: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload 5
    //   518: astore 4
    //   520: ldc 8
    //   522: aload 7
    //   524: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokestatic 262	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   530: aload 5
    //   532: astore 4
    //   534: aload 6
    //   536: invokevirtual 265	java/lang/Throwable:printStackTrace	()V
    //   539: aload 5
    //   541: ifnull +10 -> 551
    //   544: aload 5
    //   546: invokeinterface 251 1 0
    //   551: aconst_null
    //   552: areturn
    //   553: astore 6
    //   555: aload 4
    //   557: astore 5
    //   559: aload 6
    //   561: astore 4
    //   563: aload 5
    //   565: ifnull +10 -> 575
    //   568: aload 5
    //   570: invokeinterface 251 1 0
    //   575: goto +6 -> 581
    //   578: aload 4
    //   580: athrow
    //   581: goto -3 -> 578
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	584	0	this	QzoneMoodPlugin
    //   133	36	1	i	int
    //   147	75	2	j	int
    //   161	131	3	k	int
    //   34	396	4	localObject1	Object
    //   463	1	4	localObject2	Object
    //   478	101	4	localObject3	Object
    //   43	526	5	localObject4	Object
    //   174	234	6	localObject5	Object
    //   443	1	6	localThrowable1	Throwable
    //   471	64	6	localThrowable2	Throwable
    //   553	7	6	localObject6	Object
    //   333	190	7	localObject7	Object
    //   8	453	8	localFriendNickNames	QzoneMoodPlugin.FriendNickNames
    //   213	193	9	str	String
    // Exception table:
    //   from	to	target	type
    //   110	120	443	java/lang/Throwable
    //   124	134	443	java/lang/Throwable
    //   138	148	443	java/lang/Throwable
    //   152	162	443	java/lang/Throwable
    //   166	176	443	java/lang/Throwable
    //   180	188	443	java/lang/Throwable
    //   195	215	443	java/lang/Throwable
    //   219	229	443	java/lang/Throwable
    //   233	241	443	java/lang/Throwable
    //   245	265	443	java/lang/Throwable
    //   269	282	443	java/lang/Throwable
    //   289	299	443	java/lang/Throwable
    //   303	311	443	java/lang/Throwable
    //   315	335	443	java/lang/Throwable
    //   343	352	443	java/lang/Throwable
    //   360	377	443	java/lang/Throwable
    //   381	396	443	java/lang/Throwable
    //   400	413	443	java/lang/Throwable
    //   417	427	443	java/lang/Throwable
    //   431	440	443	java/lang/Throwable
    //   28	101	463	finally
    //   28	101	471	java/lang/Throwable
    //   110	120	553	finally
    //   124	134	553	finally
    //   138	148	553	finally
    //   152	162	553	finally
    //   166	176	553	finally
    //   180	188	553	finally
    //   195	215	553	finally
    //   219	229	553	finally
    //   233	241	553	finally
    //   245	265	553	finally
    //   269	282	553	finally
    //   289	299	553	finally
    //   303	311	553	finally
    //   315	335	553	finally
    //   343	352	553	finally
    //   360	377	553	finally
    //   381	396	553	finally
    //   400	413	553	finally
    //   417	427	553	finally
    //   431	440	553	finally
    //   480	489	553	finally
    //   493	501	553	finally
    //   505	516	553	finally
    //   520	530	553	finally
    //   534	539	553	finally
  }
  
  private static String parseAtString(String paramString, ArrayList<ResultRecord> paramArrayList)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList();
    }
    try
    {
      paramString = Pattern.compile("@\\{uin:(\\d+),nick:(.+?)\\}").matcher(paramString);
      while (paramString.find())
      {
        if (QLog.isDevelopLevel())
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append("match:");
          paramArrayList.append(paramString.group());
          paramArrayList.append(" uin=");
          paramArrayList.append(paramString.group(1));
          paramArrayList.append(" nick=");
          paramArrayList.append(paramString.group(2));
          QLog.i("QzoneMoodPlugin", 4, paramArrayList.toString());
        }
        paramArrayList = new ResultRecord();
        paramArrayList.uin = paramString.group(1);
        paramArrayList.name = paramString.group(2);
        ((ArrayList)localObject).add(paramArrayList);
      }
      paramString = paramString.replaceAll("");
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("QzoneMoodPlugin", 1, "parse at string error:", paramString);
    }
    return null;
  }
  
  private boolean writeMood(String paramString)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        Object localObject1 = localJSONObject.getString("text");
        boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
        String str2 = null;
        if (!bool) {
          break label550;
        }
        paramString = localJSONObject.optString("base64UBBText");
        bool = TextUtils.isEmpty(paramString);
        if (bool) {
          break label550;
        }
        try
        {
          paramString = new String(Base64.decode(paramString, 2));
          if (!TextUtils.isEmpty(paramString))
          {
            localObject2 = new ArrayList();
            try
            {
              String str1 = parseAtString(paramString, (ArrayList)localObject2);
              bool = TextUtils.isEmpty(str1);
              paramString = (String)localObject2;
              if (bool) {
                break label547;
              }
              localObject1 = str1;
              paramString = (String)localObject2;
            }
            catch (Throwable localThrowable1)
            {
              paramString = (String)localObject2;
              continue;
            }
          }
          else
          {
            paramString = null;
          }
        }
        catch (Throwable localThrowable2)
        {
          paramString = null;
          QLog.e("QzoneMoodPlugin", 1, "writeMood: parse base64UBBText error:", localThrowable2);
        }
        Object localObject2 = localJSONObject.getJSONArray("photoList");
        ArrayList localArrayList = new ArrayList();
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
        {
          i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            localArrayList.add(((JSONArray)localObject2).getJSONObject(i).getString("url"));
            i += 1;
            continue;
          }
        }
        String str3 = localJSONObject.optString("tagId");
        String str4 = localJSONObject.optString("tagTitle");
        String str5 = localJSONObject.optString("tagUrl");
        String str6 = localJSONObject.optString("tagProtocol");
        String str7 = localJSONObject.optString("desc");
        int i = localJSONObject.optInt("isfromfeedcombine");
        String str8 = localJSONObject.optString("descTruncateNum");
        localObject2 = str2;
        if (!TextUtils.isEmpty(str3))
        {
          localObject2 = str2;
          if (!TextUtils.isEmpty(str4))
          {
            localObject2 = str2;
            if (!TextUtils.isEmpty(str5))
            {
              localObject2 = str2;
              if (!TextUtils.isEmpty(str6))
              {
                localObject3 = new PublishEventTag();
                ((PublishEventTag)localObject3).id = str3;
                ((PublishEventTag)localObject3).title = str4;
                ((PublishEventTag)localObject3).picUrl = str5;
                ((PublishEventTag)localObject3).protocol = str6;
                localObject2 = localObject3;
                if (i == 1)
                {
                  localObject2 = localObject3;
                  if (!TextUtils.isEmpty(str7))
                  {
                    localObject2 = localObject3;
                    if (!TextUtils.isEmpty(str8))
                    {
                      ((PublishEventTag)localObject3).picUrl = "https://qzonestyle.gtimg.cn/aoi/sola/20170323194618_Xgy5reWQh0.png";
                      ((PublishEventTag)localObject3).desc = str7;
                      ((PublishEventTag)localObject3).truncateNum = str8;
                      localObject2 = localObject3;
                    }
                  }
                }
              }
            }
          }
        }
        str2 = localJSONObject.optString("singlePic");
        Object localObject3 = this.parentPlugin.mRuntime.a();
        if ((!TextUtils.isEmpty(str2)) && (localObject3 != null))
        {
          str2 = QzoneUploadInterface.toLocal((Context)localObject3, str2);
          if (!TextUtils.isEmpty(str2)) {
            localArrayList.add(str2);
          }
        }
        if (localObject3 != null)
        {
          str2 = this.parentPlugin.mRuntime.a().getCurrentAccountUin();
          ThreadManager.getSubThreadHandler().post(new QzoneMoodPlugin.1(this, paramString, str2, i, (Activity)localObject3, (String)localObject1, localArrayList, (PublishEventTag)localObject2));
          return true;
        }
        return false;
      }
      catch (Exception paramString)
      {
        QLog.e("QzoneMoodPlugin", 1, paramString.getMessage());
        return false;
      }
      label547:
      continue;
      label550:
      paramString = null;
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("signInSuccess".equals(paramString3))
    {
      try
      {
        paramString3 = new JSONObject(paramVarArgs[0]);
        if (paramString3.optBoolean("shareToWX"))
        {
          paramJsBridgeListener = paramString3.optString("image");
          paramString1 = paramString3.optString("text");
          paramString2 = paramString3.optString("fontId");
          paramString3 = paramString3.optString("fontUrl");
          RemoteHandleManager.getInstance().getSender().syncWithSignIn(paramString1, paramJsBridgeListener, paramString2, paramString3);
          this.mUseWechatSyncManager = true;
        }
        if (this.parentPlugin.mRuntime.a() == null) {
          break label186;
        }
        this.parentPlugin.mRuntime.a().finish();
        return true;
      }
      catch (Throwable paramJsBridgeListener)
      {
        QLog.e("QzoneMoodPlugin", 1, paramJsBridgeListener.getMessage());
        return false;
      }
    }
    else
    {
      if ("editMoodSuccess".equals(paramString3))
      {
        handleEditMoodSuccess();
        return true;
      }
      if (QZoneJsConstants.METHOD_WRITE_MOOD.equals(paramString3)) {
        return writeMood(paramVarArgs[0]);
      }
      if ("deleteUnpublishedShuoShuo".equals(paramString3))
      {
        deleteTimerShuoShuo();
        return true;
      }
    }
    label186:
    return false;
  }
  
  public void onDestroy()
  {
    if (this.mUseWechatSyncManager) {
      RemoteHandleManager.getInstance().destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneMoodPlugin
 * JD-Core Version:    0.7.0.1
 */