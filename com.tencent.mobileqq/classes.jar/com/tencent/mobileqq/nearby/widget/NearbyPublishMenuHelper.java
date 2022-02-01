package com.tencent.mobileqq.nearby.widget;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationNearby;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.CikeConfigData;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class NearbyPublishMenuHelper
{
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 5
    //   9: aload 5
    //   11: astore_3
    //   12: aload 6
    //   14: astore 4
    //   16: invokestatic 19	java/lang/System:currentTimeMillis	()J
    //   19: lstore_1
    //   20: aload 5
    //   22: astore_3
    //   23: aload 6
    //   25: astore 4
    //   27: new 21	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   34: astore 7
    //   36: aload 5
    //   38: astore_3
    //   39: aload 6
    //   41: astore 4
    //   43: aload 7
    //   45: ldc 24
    //   47: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 5
    //   53: astore_3
    //   54: aload 6
    //   56: astore 4
    //   58: aload 7
    //   60: aload_0
    //   61: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 5
    //   67: astore_3
    //   68: aload 6
    //   70: astore 4
    //   72: aload 7
    //   74: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore_0
    //   78: aload 5
    //   80: astore_3
    //   81: aload 6
    //   83: astore 4
    //   85: new 34	java/io/File
    //   88: dup
    //   89: invokestatic 40	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   92: invokevirtual 44	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   95: aload_0
    //   96: invokespecial 47	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   99: astore 7
    //   101: aload 5
    //   103: astore_3
    //   104: aload 6
    //   106: astore 4
    //   108: aload 7
    //   110: invokevirtual 51	java/io/File:isFile	()Z
    //   113: ifeq +181 -> 294
    //   116: aload 5
    //   118: astore_3
    //   119: aload 6
    //   121: astore 4
    //   123: aload 7
    //   125: invokevirtual 54	java/io/File:length	()J
    //   128: lconst_0
    //   129: lcmp
    //   130: ifne +6 -> 136
    //   133: goto +161 -> 294
    //   136: aload 5
    //   138: astore_3
    //   139: aload 6
    //   141: astore 4
    //   143: invokestatic 40	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   146: aload_0
    //   147: invokevirtual 58	com/tencent/common/app/BaseApplicationImpl:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   150: astore_0
    //   151: aload_0
    //   152: astore_3
    //   153: aload_0
    //   154: astore 4
    //   156: aload 7
    //   158: invokevirtual 54	java/io/File:length	()J
    //   161: l2i
    //   162: newarray byte
    //   164: astore 5
    //   166: aload_0
    //   167: astore_3
    //   168: aload_0
    //   169: astore 4
    //   171: aload_0
    //   172: aload 5
    //   174: invokevirtual 64	java/io/FileInputStream:read	([B)I
    //   177: pop
    //   178: aload_0
    //   179: astore_3
    //   180: aload_0
    //   181: astore 4
    //   183: new 21	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   190: astore 6
    //   192: aload_0
    //   193: astore_3
    //   194: aload_0
    //   195: astore 4
    //   197: aload 6
    //   199: ldc 66
    //   201: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_0
    //   206: astore_3
    //   207: aload_0
    //   208: astore 4
    //   210: aload 6
    //   212: invokestatic 19	java/lang/System:currentTimeMillis	()J
    //   215: lload_1
    //   216: lsub
    //   217: invokevirtual 69	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload_0
    //   222: astore_3
    //   223: aload_0
    //   224: astore 4
    //   226: aload 6
    //   228: ldc 71
    //   230: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload_0
    //   235: astore_3
    //   236: aload_0
    //   237: astore 4
    //   239: aload 6
    //   241: aload 5
    //   243: arraylength
    //   244: invokevirtual 74	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload_0
    //   249: astore_3
    //   250: aload_0
    //   251: astore 4
    //   253: ldc 76
    //   255: iconst_1
    //   256: aload 6
    //   258: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: aload_0
    //   265: astore_3
    //   266: aload_0
    //   267: astore 4
    //   269: new 84	java/lang/String
    //   272: dup
    //   273: aload 5
    //   275: invokespecial 87	java/lang/String:<init>	([B)V
    //   278: astore 5
    //   280: aload_0
    //   281: ifnull +7 -> 288
    //   284: aload_0
    //   285: invokevirtual 90	java/io/FileInputStream:close	()V
    //   288: ldc 2
    //   290: monitorexit
    //   291: aload 5
    //   293: areturn
    //   294: aload 5
    //   296: astore_3
    //   297: aload 6
    //   299: astore 4
    //   301: new 21	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   308: astore_0
    //   309: aload 5
    //   311: astore_3
    //   312: aload 6
    //   314: astore 4
    //   316: aload_0
    //   317: ldc 92
    //   319: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 5
    //   325: astore_3
    //   326: aload 6
    //   328: astore 4
    //   330: aload_0
    //   331: aload 7
    //   333: invokevirtual 95	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   336: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 5
    //   342: astore_3
    //   343: aload 6
    //   345: astore 4
    //   347: ldc 76
    //   349: iconst_1
    //   350: aload_0
    //   351: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: ldc 2
    //   359: monitorexit
    //   360: ldc 97
    //   362: areturn
    //   363: astore_0
    //   364: goto +70 -> 434
    //   367: astore_0
    //   368: aload 4
    //   370: astore_3
    //   371: new 21	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   378: astore 5
    //   380: aload 4
    //   382: astore_3
    //   383: aload 5
    //   385: ldc 99
    //   387: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload 4
    //   393: astore_3
    //   394: aload 5
    //   396: aload_0
    //   397: invokevirtual 100	java/lang/Exception:toString	()Ljava/lang/String;
    //   400: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload 4
    //   406: astore_3
    //   407: ldc 76
    //   409: iconst_1
    //   410: aload 5
    //   412: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 103	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: aload 4
    //   420: ifnull +8 -> 428
    //   423: aload 4
    //   425: invokevirtual 90	java/io/FileInputStream:close	()V
    //   428: ldc 2
    //   430: monitorexit
    //   431: ldc 97
    //   433: areturn
    //   434: aload_3
    //   435: ifnull +7 -> 442
    //   438: aload_3
    //   439: invokevirtual 90	java/io/FileInputStream:close	()V
    //   442: aload_0
    //   443: athrow
    //   444: astore_0
    //   445: ldc 2
    //   447: monitorexit
    //   448: aload_0
    //   449: athrow
    //   450: astore_0
    //   451: goto -163 -> 288
    //   454: astore_0
    //   455: goto -27 -> 428
    //   458: astore_3
    //   459: goto -17 -> 442
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	paramString	String
    //   19	197	1	l	long
    //   11	428	3	localObject1	Object
    //   458	1	3	localException	Exception
    //   14	410	4	localObject2	Object
    //   7	404	5	localObject3	Object
    //   4	340	6	localStringBuilder	StringBuilder
    //   34	298	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   16	20	363	finally
    //   27	36	363	finally
    //   43	51	363	finally
    //   58	65	363	finally
    //   72	78	363	finally
    //   85	101	363	finally
    //   108	116	363	finally
    //   123	133	363	finally
    //   143	151	363	finally
    //   156	166	363	finally
    //   171	178	363	finally
    //   183	192	363	finally
    //   197	205	363	finally
    //   210	221	363	finally
    //   226	234	363	finally
    //   239	248	363	finally
    //   253	264	363	finally
    //   269	280	363	finally
    //   301	309	363	finally
    //   316	323	363	finally
    //   330	340	363	finally
    //   347	357	363	finally
    //   371	380	363	finally
    //   383	391	363	finally
    //   394	404	363	finally
    //   407	418	363	finally
    //   16	20	367	java/lang/Exception
    //   27	36	367	java/lang/Exception
    //   43	51	367	java/lang/Exception
    //   58	65	367	java/lang/Exception
    //   72	78	367	java/lang/Exception
    //   85	101	367	java/lang/Exception
    //   108	116	367	java/lang/Exception
    //   123	133	367	java/lang/Exception
    //   143	151	367	java/lang/Exception
    //   156	166	367	java/lang/Exception
    //   171	178	367	java/lang/Exception
    //   183	192	367	java/lang/Exception
    //   197	205	367	java/lang/Exception
    //   210	221	367	java/lang/Exception
    //   226	234	367	java/lang/Exception
    //   239	248	367	java/lang/Exception
    //   253	264	367	java/lang/Exception
    //   269	280	367	java/lang/Exception
    //   301	309	367	java/lang/Exception
    //   316	323	367	java/lang/Exception
    //   330	340	367	java/lang/Exception
    //   347	357	367	java/lang/Exception
    //   284	288	444	finally
    //   423	428	444	finally
    //   438	442	444	finally
    //   442	444	444	finally
    //   284	288	450	java/lang/Exception
    //   423	428	454	java/lang/Exception
    //   438	442	458	java/lang/Exception
  }
  
  public static ArrayList<MenuItem> a()
  {
    localArrayList = new ArrayList();
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = (String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(((AppRuntime)localObject2).getAccount(), "key_nearby_publish_menu", "");
    boolean bool = TextUtils.isEmpty((String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(((AppRuntime)localObject2).getAccount(), "cike_guide_content", "")) ^ true;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parseMenuItems, menuCfg=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", hasDialogCfg=");
      ((StringBuilder)localObject2).append(bool);
      QLog.d("NearbyPublishMenuHelper", 2, ((StringBuilder)localObject2).toString());
    }
    try
    {
      localObject1 = new JSONArray((String)localObject1);
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        MenuItem localMenuItem2 = new MenuItem();
        localMenuItem2.a = ((JSONObject)localObject2).optInt("id");
        if ((bool) || (localMenuItem2.a == 1) || (localMenuItem2.a == 2))
        {
          localMenuItem2.c = ((JSONObject)localObject2).optString("icon");
          localMenuItem2.d = ((JSONObject)localObject2).optString("title");
          localMenuItem2.e = ((JSONObject)localObject2).optString("subTitle");
          localMenuItem2.f = ((JSONObject)localObject2).optString("jumpUrl");
          localArrayList.add(localMenuItem2);
        }
        i += 1;
      }
      MenuItem localMenuItem1;
      return localArrayList;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleTakePhotoBack, exp=");
        ((StringBuilder)localObject2).append(localException.toString());
        QLog.e("NearbyPublishMenuHelper", 2, ((StringBuilder)localObject2).toString());
      }
      if (localArrayList.size() == 0)
      {
        localMenuItem1 = new MenuItem();
        localMenuItem1.a = 1;
        localMenuItem1.b = 2130842239;
        localMenuItem1.d = HardCodeUtil.a(2131905230);
        localArrayList.add(localMenuItem1);
        localMenuItem1 = new MenuItem();
        localMenuItem1.a = 2;
        localMenuItem1.b = 2130842238;
        localMenuItem1.d = HardCodeUtil.a(2131905231);
        localArrayList.add(localMenuItem1);
      }
    }
  }
  
  protected static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPublishMenuHelper", 2, "selectPic");
    }
    Object localObject = null;
    if ((paramContext instanceof AppActivity)) {
      localObject = (AppActivity)paramContext;
    }
    if (localObject == null) {
      return;
    }
    localObject = new ActivityURIRequest(paramContext, "/base/album/photolist");
    ((ActivityURIRequest)localObject).extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramContext.getClass().getName());
    ((ActivityURIRequest)localObject).extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    ((ActivityURIRequest)localObject).extra().putBoolean("PeakConstants.showGifTypeIcon", true);
    ((ActivityURIRequest)localObject).extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", 1);
    ((ActivityURIRequest)localObject).extra().putBoolean("PhotoConst.IS_SINGLE_MODE", true);
    ((ActivityURIRequest)localObject).extra().putInt("imageSizeLimit", 8388608);
    ((ActivityURIRequest)localObject).extra().putBoolean("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    ((ActivityURIRequest)localObject).extra().putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    ((ActivityURIRequest)localObject).extra().putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    ((ActivityURIRequest)localObject).extra().putInt("enter_from", 30);
    ((ActivityURIRequest)localObject).extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationNearby.a);
    QRoute.startUri((URIRequest)localObject);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResult, reqCode=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", retCode=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("NearbyPublishMenuHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt2 == -1)
    {
      if (paramInt1 == 1001)
      {
        paramIntent = c(paramContext);
        localObject = paramIntent.getString("camera_photo_path", "");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("camera result, path=");
        localStringBuilder.append((String)localObject);
        QLog.d("NearbyPublishMenuHelper", 1, localStringBuilder.toString());
        paramIntent.edit().remove("camera_photo_path").commit();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        b(paramContext, "https://nearby.qq.com/nearby-topic/release.html?_bid=3203&from=3&getImageType=2", (String)localObject);
        return;
      }
      if (paramInt1 == 1000)
      {
        if (paramIntent != null) {
          paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        } else {
          paramIntent = null;
        }
        if ((paramIntent != null) && (paramIntent.size() != 0))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("select photo result, path=");
          ((StringBuilder)localObject).append((String)paramIntent.get(0));
          QLog.d("NearbyPublishMenuHelper", 1, ((StringBuilder)localObject).toString());
          b(paramContext, "https://nearby.qq.com/nearby-topic/release.html?_bid=3203&from=3&getImageType=2", (String)paramIntent.get(0));
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("NearbyPublishMenuHelper", 2, "path is empty return");
        }
      }
    }
  }
  
  public static void a(Context paramContext, MenuItem paramMenuItem, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMenuItemClick：id=");
      localStringBuilder.append(paramMenuItem.a);
      QLog.d("NearbyPublishMenuHelper", 2, localStringBuilder.toString());
    }
    int i = paramMenuItem.a;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              a(paramContext, paramMenuItem.f);
              return;
            }
            a(paramString, "pub_video_clk");
            a(paramContext, paramString, "pub_video_clk");
            return;
          }
          a(paramString, "pub_voice_clk");
          a(paramContext, paramString, "pub_voice_clk");
          return;
        }
        a(paramString, "pub_txt_clk");
        a(paramContext, paramString, "pub_txt_clk");
        return;
      }
      b(paramContext);
      return;
    }
    a(paramContext);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    try
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doJump, url=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("NearbyPublishMenuHelper", 2, ((StringBuilder)localObject).toString());
      }
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramString.startsWith("http"))
        {
          localObject = new Intent(paramContext, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", paramString);
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded((Intent)localObject, paramString);
          paramContext.startActivity((Intent)localObject);
          return;
        }
        if (paramString.startsWith("mqqapi"))
        {
          paramContext.startActivity(new Intent(paramContext, JumpActivity.class).setData(Uri.parse(paramString)));
          return;
        }
        if (paramString.startsWith("tlitenow"))
        {
          paramContext.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(paramString)));
          return;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("doJump exp=");
      paramString.append(paramContext.toString());
      QLog.e("NearbyPublishMenuHelper", 1, paramString.toString());
    }
  }
  
  protected static void a(Context paramContext, String paramString1, String paramString2)
  {
    CikeConfigData localCikeConfigData = CikeConfigData.a(paramContext, BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
    if (localCikeConfigData != null)
    {
      if (CikeConfigData.a(paramContext))
      {
        a(paramContext, localCikeConfigData.d);
        return;
      }
      localCikeConfigData.f = b(paramString1, paramString2);
      paramContext = new NearbyAppDownloadDialog(paramContext);
      paramContext.a(localCikeConfigData);
      paramContext.show();
      return;
    }
    QLog.d("NearbyPublishMenuHelper", 1, "cikeData == null");
  }
  
  protected static void a(String paramString1, String paramString2)
  {
    new ReportTask(null).a("dc00899").b("grp_lbs").c(paramString1).d(paramString2).a();
  }
  
  protected static String b(String paramString1, String paramString2)
  {
    boolean bool = "pub_voice_clk".equals(paramString2);
    int j = 0;
    int i;
    if (bool) {
      i = 1;
    } else if ("pub_txt_clk".equals(paramString2)) {
      i = 2;
    } else if ("pub_video_clk".equals(paramString2)) {
      i = 3;
    } else {
      i = 0;
    }
    if ((i != 0) && (!"home".equals(paramString1)))
    {
      if ("data_card".equals(paramString1)) {
        j = i + 3;
      }
    }
    else {
      j = i;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("getReportD1=");
      paramString1.append(j);
      QLog.d("NearbyPublishMenuHelper", 2, paramString1.toString());
    }
    paramString1 = new StringBuilder();
    paramString1.append(j);
    paramString1.append("");
    return paramString1.toString();
  }
  
  protected static void b(Context paramContext)
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPublishMenuHelper", 2, "Camera used return");
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append("photo/");
    localObject = new File(VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject).toString()));
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
    {
      QQToast.makeText(paramContext, 2131916075, 0).show();
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPublishMenuHelper", 2, "sdcard not exist return");
      }
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append("photo/");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(".jpg");
    String str = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject).toString());
    Intent localIntent = new Intent();
    FileProvider7Helper.setSystemCapture(BaseApplicationImpl.getContext(), new File(str), localIntent);
    localObject = null;
    if ((paramContext instanceof AppActivity)) {
      localObject = (AppActivity)paramContext;
    }
    if (localObject == null) {
      return;
    }
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (((AppActivity)localObject).checkSelfPermission("android.permission.CAMERA") != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPublishMenuHelper", 2, "requestPermissions");
      }
      ((AppActivity)localObject).requestPermissions(new NearbyPublishMenuHelper.1(paramContext, str, (AppActivity)localObject, localIntent), 1, new String[] { "android.permission.CAMERA" });
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (i == 0) {
      try
      {
        c(paramContext).edit().putString("camera_photo_path", str).commit();
        ((AppActivity)localObject).startActivityForResult(localIntent, 1001);
        if (QLog.isColorLevel())
        {
          QLog.d("NearbyPublishMenuHelper", 2, "takePhoto");
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("NearbyPublishMenuHelper", 1, localException, new Object[0]);
        QQToast.makeText(paramContext, 2131887645, 0).show();
      }
    }
  }
  
  protected static void b(Context paramContext, String paramString1, String paramString2)
  {
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(paramContext, paramContext.getResources().getDimensionPixelSize(2131299920));
    localQQProgressDialog.c(2131891516);
    ThreadManager.post(new NearbyPublishMenuHelper.2(localQQProgressDialog, paramString2, paramContext, paramString1), 5, null, true);
  }
  
  public static SharedPreferences c(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getPackageName());
    localStringBuilder.append("_preferences");
    return paramContext.getSharedPreferences(localStringBuilder.toString(), 4);
  }
  
  /* Error */
  public static void c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 6
    //   9: aload 6
    //   11: astore 5
    //   13: aload 7
    //   15: astore 4
    //   17: new 21	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   24: astore 8
    //   26: aload 6
    //   28: astore 5
    //   30: aload 7
    //   32: astore 4
    //   34: aload 8
    //   36: ldc 24
    //   38: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload 6
    //   44: astore 5
    //   46: aload 7
    //   48: astore 4
    //   50: aload 8
    //   52: aload_0
    //   53: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 6
    //   59: astore 5
    //   61: aload 7
    //   63: astore 4
    //   65: aload 8
    //   67: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore_0
    //   71: aload 6
    //   73: astore 5
    //   75: aload 7
    //   77: astore 4
    //   79: aload_1
    //   80: invokestatic 138	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   83: ifeq +23 -> 106
    //   86: aload 6
    //   88: astore 5
    //   90: aload 7
    //   92: astore 4
    //   94: invokestatic 40	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   97: aload_0
    //   98: invokevirtual 593	com/tencent/common/app/BaseApplicationImpl:deleteFile	(Ljava/lang/String;)Z
    //   101: pop
    //   102: ldc 2
    //   104: monitorexit
    //   105: return
    //   106: aload 6
    //   108: astore 5
    //   110: aload 7
    //   112: astore 4
    //   114: invokestatic 19	java/lang/System:currentTimeMillis	()J
    //   117: lstore_2
    //   118: aload 6
    //   120: astore 5
    //   122: aload 7
    //   124: astore 4
    //   126: invokestatic 40	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   129: aload_0
    //   130: iconst_0
    //   131: invokevirtual 597	com/tencent/common/app/BaseApplicationImpl:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   134: astore_0
    //   135: aload_0
    //   136: astore 5
    //   138: aload_0
    //   139: astore 4
    //   141: aload_0
    //   142: aload_1
    //   143: invokevirtual 601	java/lang/String:getBytes	()[B
    //   146: invokevirtual 606	java/io/FileOutputStream:write	([B)V
    //   149: aload_0
    //   150: astore 5
    //   152: aload_0
    //   153: astore 4
    //   155: aload_0
    //   156: invokevirtual 609	java/io/FileOutputStream:flush	()V
    //   159: aload_0
    //   160: astore 5
    //   162: aload_0
    //   163: astore 4
    //   165: new 21	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   172: astore 6
    //   174: aload_0
    //   175: astore 5
    //   177: aload_0
    //   178: astore 4
    //   180: aload 6
    //   182: ldc_w 611
    //   185: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload_0
    //   190: astore 5
    //   192: aload_0
    //   193: astore 4
    //   195: aload 6
    //   197: invokestatic 19	java/lang/System:currentTimeMillis	()J
    //   200: lload_2
    //   201: lsub
    //   202: invokevirtual 69	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_0
    //   207: astore 5
    //   209: aload_0
    //   210: astore 4
    //   212: aload 6
    //   214: ldc 71
    //   216: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_0
    //   221: astore 5
    //   223: aload_0
    //   224: astore 4
    //   226: aload 6
    //   228: aload_1
    //   229: invokevirtual 612	java/lang/String:length	()I
    //   232: invokevirtual 74	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_0
    //   237: astore 5
    //   239: aload_0
    //   240: astore 4
    //   242: ldc 76
    //   244: iconst_1
    //   245: aload 6
    //   247: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload_0
    //   254: ifnull +77 -> 331
    //   257: aload_0
    //   258: invokevirtual 613	java/io/FileOutputStream:close	()V
    //   261: goto +70 -> 331
    //   264: astore_0
    //   265: goto +70 -> 335
    //   268: astore_0
    //   269: aload 4
    //   271: astore 5
    //   273: new 21	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   280: astore_1
    //   281: aload 4
    //   283: astore 5
    //   285: aload_1
    //   286: ldc_w 615
    //   289: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 4
    //   295: astore 5
    //   297: aload_1
    //   298: aload_0
    //   299: invokevirtual 100	java/lang/Exception:toString	()Ljava/lang/String;
    //   302: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 4
    //   308: astore 5
    //   310: ldc 76
    //   312: iconst_1
    //   313: aload_1
    //   314: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 103	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   320: aload 4
    //   322: ifnull +9 -> 331
    //   325: aload 4
    //   327: astore_0
    //   328: goto -71 -> 257
    //   331: ldc 2
    //   333: monitorexit
    //   334: return
    //   335: aload 5
    //   337: ifnull +8 -> 345
    //   340: aload 5
    //   342: invokevirtual 613	java/io/FileOutputStream:close	()V
    //   345: aload_0
    //   346: athrow
    //   347: astore_0
    //   348: ldc 2
    //   350: monitorexit
    //   351: goto +5 -> 356
    //   354: aload_0
    //   355: athrow
    //   356: goto -2 -> 354
    //   359: astore_0
    //   360: goto -29 -> 331
    //   363: astore_1
    //   364: goto -19 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	paramString1	String
    //   0	367	1	paramString2	String
    //   117	84	2	l	long
    //   15	311	4	localObject1	Object
    //   11	330	5	localObject2	Object
    //   7	239	6	localStringBuilder1	StringBuilder
    //   4	119	7	localObject3	Object
    //   24	42	8	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   17	26	264	finally
    //   34	42	264	finally
    //   50	57	264	finally
    //   65	71	264	finally
    //   79	86	264	finally
    //   94	102	264	finally
    //   114	118	264	finally
    //   126	135	264	finally
    //   141	149	264	finally
    //   155	159	264	finally
    //   165	174	264	finally
    //   180	189	264	finally
    //   195	206	264	finally
    //   212	220	264	finally
    //   226	236	264	finally
    //   242	253	264	finally
    //   273	281	264	finally
    //   285	293	264	finally
    //   297	306	264	finally
    //   310	320	264	finally
    //   17	26	268	java/lang/Exception
    //   34	42	268	java/lang/Exception
    //   50	57	268	java/lang/Exception
    //   65	71	268	java/lang/Exception
    //   79	86	268	java/lang/Exception
    //   94	102	268	java/lang/Exception
    //   114	118	268	java/lang/Exception
    //   126	135	268	java/lang/Exception
    //   141	149	268	java/lang/Exception
    //   155	159	268	java/lang/Exception
    //   165	174	268	java/lang/Exception
    //   180	189	268	java/lang/Exception
    //   195	206	268	java/lang/Exception
    //   212	220	268	java/lang/Exception
    //   226	236	268	java/lang/Exception
    //   242	253	268	java/lang/Exception
    //   257	261	347	finally
    //   340	345	347	finally
    //   345	347	347	finally
    //   257	261	359	java/lang/Exception
    //   340	345	363	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper
 * JD-Core Version:    0.7.0.1
 */