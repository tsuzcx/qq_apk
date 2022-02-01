package com.tencent.mobileqq.kandian.glue.router.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionMainActivity;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyFloatingWindowHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.daily.api.IKandianDailyManager;
import com.tencent.mobileqq.kandian.biz.fastweb.api.IFastWebActivityUtils;
import com.tencent.mobileqq.kandian.biz.feeds.api.IReadInJoyBaseFragmentEntryPath;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaAccessHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IKandianSubscribeManager;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyManager;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpAction;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RIJJumpActionImpl
  implements IRIJJumpAction
{
  private static final String TAG = "RIJJumpActionImpl";
  
  private boolean articleImageCollection(Context paramContext, HashMap<String, String> paramHashMap)
  {
    String str = (String)paramHashMap.get("articleid");
    int i = Integer.parseInt((String)paramHashMap.get("uin_type"));
    if (!TextUtils.isEmpty(str))
    {
      paramHashMap = new Intent(paramContext, ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountImageCollectionMainActivity.class));
      paramHashMap.putExtra("source_for_report", i);
      ((IPublicAccountImageCollectionUtils)QRoute.api(IPublicAccountImageCollectionUtils.class)).openPublicAccountImageCollectionMainActivity((Activity)paramContext, paramHashMap, str);
    }
    return false;
  }
  
  private boolean gotoReadInJoyFromSourceTarget(Context paramContext, HashMap<String, String> paramHashMap, String paramString1, String paramString2)
  {
    String str1 = (String)paramHashMap.get("channelid");
    String str2 = (String)paramHashMap.get("channelname");
    String str3 = (String)paramHashMap.get("type");
    String str4 = (String)paramHashMap.get("target");
    if ("1".equals(str4))
    {
      handleReadInJoyTargetFeeds(paramContext, paramHashMap);
    }
    else
    {
      if ("2".equals(str4)) {
        return handleReadInJoyTargetChannel(paramContext, paramHashMap, paramString1, paramString2, str1, str2, str3).booleanValue();
      }
      if ("2001".equals(str4))
      {
        handleReadInJoyTargetMainVideoTab(paramContext, paramHashMap);
      }
      else if ("3".equals(str4))
      {
        paramHashMap = ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getFastWebIntent(paramContext, paramHashMap);
        ((IFastWebActivityUtils)QRoute.api(IFastWebActivityUtils.class)).openNewPage(paramContext, paramHashMap);
      }
      else if ("4".equals(str4))
      {
        if (BaseActivity.sTopActivity != null) {
          paramContext = BaseActivity.sTopActivity;
        }
        ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).startApp(paramContext, paramHashMap);
      }
      else if ("5".equals(str4))
      {
        ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).openFullVideoPlay(paramContext, paramHashMap);
      }
      else if ("6".equals(str4))
      {
        handleReadInJoyOpenTargetViolaPage(paramContext, paramHashMap);
      }
      else if ("7".equals(str4))
      {
        ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).openDailyDynamicChildFeeds(paramContext, paramHashMap);
      }
      else if ("8".equals(str4))
      {
        if ("webview".equals(paramString1)) {
          TroopMemberApiClient.a().f(paramString1);
        } else {
          ((IKandianDailyManager)QRoute.api(IKandianDailyManager.class)).launchKandianDaily(paramContext);
        }
      }
      else if ("9".equals(str4))
      {
        ((IReadInJoyFloatingWindowHelper)QRoute.api(IReadInJoyFloatingWindowHelper.class)).jump2FloatingWindow(paramContext, paramHashMap);
      }
      else if ("10".equals(str4))
      {
        handleReadInJoySelfCenter(paramContext, paramHashMap);
      }
      else if ("11".equals(str4))
      {
        ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).openFlutterPage(paramContext, paramHashMap);
      }
      else
      {
        if (!"12".equals(str4)) {
          break label416;
        }
        ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).openMXFlutterPage(paramContext, paramHashMap);
      }
    }
    return true;
    label416:
    return handleReadInJoyTargetFromQZone(paramContext, str1, str2);
  }
  
  private void handleReadInJoyOpenTargetViolaPage(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap.containsKey("v_url_base64")) {
      try
      {
        paramHashMap = toBase64Decode((String)paramHashMap.get("v_url_base64"));
        if (!TextUtils.isEmpty(paramHashMap))
        {
          ((IViolaAccessHelper)QRoute.api(IViolaAccessHelper.class)).startViolaPage(paramContext, "", paramHashMap, null);
          return;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        paramHashMap = new StringBuilder();
        paramHashMap.append("[gotoReadInJoyFromSourceTarget] openViolaPage, v_url error->");
        paramHashMap.append(paramContext.getMessage());
        QLog.w("RIJJumpActionImpl", 1, paramHashMap.toString());
      }
    }
  }
  
  private void handleReadInJoySelfCenter(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if ("1".equals(paramHashMap.get("bizType")))
    {
      paramContext.startActivity(new Intent(paramContext, ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getReadInJoySettingActivityClazz()));
      return;
    }
    if ("2".equals(paramHashMap.get("bizType"))) {
      PublicFragmentActivity.a(paramContext, ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getReadInJoyDraftboxFragmentClazz());
    }
  }
  
  private Boolean handleReadInJoyTargetChannel(Context paramContext, HashMap<String, String> paramHashMap, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    int i1 = 0;
    Boolean localBoolean = Boolean.valueOf(false);
    if (paramString3 == null) {
      return localBoolean;
    }
    try
    {
      j = Integer.parseInt(paramString3);
    }
    catch (Exception paramString3)
    {
      int j;
      label27:
      label55:
      break label27;
    }
    if (QLog.isDevelopLevel()) {
      QLog.e("RIJJumpActionImpl", 4, "gotoReadInJoy channelId error");
    }
    j = -1;
    try
    {
      k = Integer.parseInt(paramString5);
    }
    catch (Exception paramString3)
    {
      int k;
      boolean bool;
      int i;
      int m;
      int n;
      break label55;
    }
    if (QLog.isDevelopLevel()) {
      QLog.e("RIJJumpActionImpl", 4, "gotoReadInJoy channelType error");
    }
    k = 0;
    if (j == -1) {
      return localBoolean;
    }
    if (TextUtils.isEmpty(paramString4)) {
      paramString3 = paramContext.getString(2131699864);
    } else {
      paramString3 = paramString4;
    }
    bool = "1".equalsIgnoreCase((String)paramHashMap.get("ispush"));
    if ((!bool) && (j == 70))
    {
      if ("webview".equals(paramString1)) {
        TroopMemberApiClient.a().k();
      } else {
        ((IKandianSubscribeManager)RIJQQAppInterfaceUtil.b().getRuntimeService(IKandianSubscribeManager.class, "")).lanuchKandianSubscribeActivity(paramContext, 3, 4);
      }
      return Boolean.valueOf(true);
    }
    if (k == 3)
    {
      if (j == 56)
      {
        if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainRecommendTab()) {
          ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchChannelActivity(paramContext, j, paramString3, k, 4);
        } else {
          ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchFeedsActivity(paramContext, 4, 1);
        }
      }
      else {
        ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchVideoSubChannelActivity(paramContext, j, paramString3, k, 4);
      }
    }
    else
    {
      paramContext = (String)paramHashMap.get("changeChannelOrder");
      paramString1 = (String)paramHashMap.get("moveChannelFromSource");
      try
      {
        i = Integer.valueOf(paramContext).intValue();
        try
        {
          m = Integer.valueOf(paramString1).intValue();
          n = i;
        }
        catch (Exception paramContext) {}
        m = i1;
      }
      catch (Exception paramContext)
      {
        i = 0;
      }
      n = i;
      if (QLog.isDevelopLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("gotoReadInJoy channelOrder error,");
        paramString1.append(paramContext.toString());
        QLog.e("RIJJumpActionImpl", 4, paramString1.toString());
        n = i;
        m = i1;
      }
      ((IReadInJoyBaseFragmentEntryPath)QRoute.api(IReadInJoyBaseFragmentEntryPath.class)).put(j, 3);
      if ((!paramHashMap.containsKey("v_url")) && (!paramHashMap.containsKey("v_url_base64")))
      {
        paramContext = new Bundle();
        paramContext.putInt("key_native_channel_id", j);
        paramContext.putInt("key_native_channel_change_order", n);
        paramContext.putString("key_native_channel_name", paramString3);
        paramContext.putInt("key_native_channel_type", k);
        paramContext.putBoolean("key_native_channel_is_push", bool);
        paramContext.putInt("key_channel_source_from", m);
        paramContext.putString("key_channel_jump_scheme", paramString2);
        QIPCClientHelper.getInstance().callServer("ReadInJoyIPCModule", "action_native_channel_jump", paramContext, null);
      }
      else
      {
        paramContext = new Bundle();
        paramContext.putString("key_viola_fragment_jump_url", paramString2);
        paramContext.putInt("key_native_channel_change_order", n);
        paramContext.putInt("key_native_channel_id", j);
        QIPCClientHelper.getInstance().callServer("ReadInJoyIPCModule", "action_viola_fragment_jump", paramContext, null);
      }
    }
    return Boolean.valueOf(true);
  }
  
  private void handleReadInJoyTargetFeeds(Context paramContext, HashMap<String, String> paramHashMap)
  {
    String str = (String)paramHashMap.get("from");
    if ("qzone".equals(str)) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(RIJQQAppInterfaceUtil.b(), "CliOper", "", "", "0X80067C6", "0X80067C6", 0, 0, "", "1", RIJQQAppInterfaceUtil.b().getCurrentAccountUin(), "", false);
    }
    if ("webview".equals(str))
    {
      TroopMemberApiClient.a().a(str, paramHashMap);
      return;
    }
    int j = 12;
    int i = j;
    if (!TextUtils.isEmpty(str))
    {
      i = j;
      if (TextUtils.isDigitsOnly(str)) {
        i = Integer.valueOf(str).intValue();
      }
    }
    if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowKandianTabNew())
    {
      try
      {
        paramContext.startActivity(((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getJumpReadInJoyTabIntent(paramContext, i));
        return;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.e("JumpAction", 1, "jump activity error1 ", paramContext);
    }
    else
    {
      if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInReadinjoyFolderMergerStyle())
      {
        ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchFeedsActivity(paramContext, 2, 0);
        return;
      }
      ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchFeedsActivity(paramContext, null, -1L, 2);
    }
  }
  
  private boolean handleReadInJoyTargetFromQZone(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    try
    {
      i = Integer.parseInt(paramString1);
    }
    catch (Exception paramString1)
    {
      int i;
      label15:
      break label15;
    }
    if (QLog.isDevelopLevel()) {
      QLog.e("RIJJumpActionImpl", 4, "gotoReadInJoy channelId error");
    }
    i = -1;
    if (i == -1) {
      return false;
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = paramContext.getString(2131699864);
    }
    if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainRecommendTab())
    {
      try
      {
        paramContext.startActivity(((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getJumpReadInJoyTabIntent(paramContext, 12));
        return true;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label176;
        }
      }
      QLog.e("JumpAction", 1, "jump activity error1 ", paramContext);
      return true;
    }
    else
    {
      paramString2 = new Intent("android.intent.action.MAIN");
      paramString2.putExtra("channel_id", i);
      paramString2.putExtra("channel_name", paramString1);
      paramString2.putExtra("readinjoy_launch_source", 7);
      ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).launchReadInJoyPlugin((Activity)paramContext, paramString2);
    }
    label176:
    return true;
  }
  
  private void handleReadInJoyTargetMainVideoTab(Context paramContext, HashMap<String, String> paramHashMap)
  {
    int i = Integer.valueOf((String)paramHashMap.get("from")).intValue();
    if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowKandianTab())
    {
      try
      {
        paramContext.startActivity(((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getJumpReadInJoyTabIntent(paramContext, i));
        return;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.e("JumpAction", 1, "jump activity error1 ", paramContext);
    }
    else
    {
      if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInReadinjoyFolderMergerStyle())
      {
        ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchFeedsActivity(paramContext, i, 0);
        return;
      }
      ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchFeedsActivity(paramContext, null, -1L, i);
    }
  }
  
  /* Error */
  private boolean jumpToDeliverFragment(Context paramContext, HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: ldc 215
    //   2: astore 7
    //   4: new 43	android/content/Intent
    //   7: dup
    //   8: aload_1
    //   9: ldc_w 466
    //   12: invokestatic 51	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   15: checkcast 466	com/tencent/mobileqq/kandian/biz/ugc/api/IRIJDeliverUGCUtils
    //   18: invokeinterface 469 1 0
    //   23: invokespecial 60	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   26: astore 11
    //   28: aload_2
    //   29: ldc_w 471
    //   32: invokevirtual 207	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   35: ifeq +28 -> 63
    //   38: aload_2
    //   39: ldc_w 471
    //   42: invokevirtual 25	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: ifnull +18 -> 63
    //   48: aload_2
    //   49: ldc_w 471
    //   52: invokevirtual 25	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast 27	java/lang/String
    //   58: astore 4
    //   60: goto +7 -> 67
    //   63: ldc 215
    //   65: astore 4
    //   67: aload_2
    //   68: ldc_w 473
    //   71: invokevirtual 207	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   74: ifeq +39 -> 113
    //   77: aload_2
    //   78: ldc_w 473
    //   81: invokevirtual 25	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   84: ifnull +29 -> 113
    //   87: new 27	java/lang/String
    //   90: dup
    //   91: aload_2
    //   92: ldc_w 473
    //   95: invokevirtual 25	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   98: checkcast 27	java/lang/String
    //   101: iconst_0
    //   102: invokestatic 479	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   105: invokespecial 482	java/lang/String:<init>	([B)V
    //   108: astore 5
    //   110: goto +7 -> 117
    //   113: ldc 215
    //   115: astore 5
    //   117: aload 7
    //   119: astore 6
    //   121: aload 7
    //   123: astore 8
    //   125: aload_2
    //   126: ldc_w 484
    //   129: invokevirtual 207	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   132: ifeq +37 -> 169
    //   135: aload 7
    //   137: astore 6
    //   139: aload 7
    //   141: astore 8
    //   143: aload_2
    //   144: ldc_w 484
    //   147: invokevirtual 25	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   150: ifnull +19 -> 169
    //   153: aload 7
    //   155: astore 8
    //   157: aload_2
    //   158: ldc_w 484
    //   161: invokevirtual 25	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   164: checkcast 27	java/lang/String
    //   167: astore 6
    //   169: aload 6
    //   171: astore 8
    //   173: aload 4
    //   175: astore 7
    //   177: aload 6
    //   179: astore 9
    //   181: aload 5
    //   183: astore 10
    //   185: aload_2
    //   186: ldc_w 486
    //   189: invokevirtual 207	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   192: ifeq +94 -> 286
    //   195: aload 6
    //   197: astore 8
    //   199: aload 4
    //   201: astore 7
    //   203: aload 6
    //   205: astore 9
    //   207: aload 5
    //   209: astore 10
    //   211: aload_2
    //   212: ldc_w 486
    //   215: invokevirtual 25	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   218: ifnull +68 -> 286
    //   221: aload 6
    //   223: astore 8
    //   225: aload_2
    //   226: ldc_w 486
    //   229: invokevirtual 25	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   232: checkcast 27	java/lang/String
    //   235: invokestatic 332	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   238: invokevirtual 336	java/lang/Integer:intValue	()I
    //   241: istore_3
    //   242: goto +58 -> 300
    //   245: astore_2
    //   246: aload 8
    //   248: astore 7
    //   250: goto +20 -> 270
    //   253: astore_2
    //   254: ldc 215
    //   256: astore 5
    //   258: goto +12 -> 270
    //   261: astore_2
    //   262: ldc 215
    //   264: astore 4
    //   266: aload 4
    //   268: astore 5
    //   270: aload_2
    //   271: invokevirtual 222	java/lang/Exception:printStackTrace	()V
    //   274: aload 5
    //   276: astore 10
    //   278: aload 7
    //   280: astore 9
    //   282: aload 4
    //   284: astore 7
    //   286: iconst_0
    //   287: istore_3
    //   288: aload 10
    //   290: astore 5
    //   292: aload 9
    //   294: astore 6
    //   296: aload 7
    //   298: astore 4
    //   300: aload 11
    //   302: ldc_w 488
    //   305: aload 4
    //   307: invokevirtual 454	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   310: pop
    //   311: aload 11
    //   313: ldc_w 490
    //   316: iconst_1
    //   317: invokevirtual 493	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   320: pop
    //   321: aload 11
    //   323: ldc_w 495
    //   326: iconst_1
    //   327: invokevirtual 493	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   330: pop
    //   331: aload 11
    //   333: ldc_w 497
    //   336: aload 5
    //   338: invokevirtual 454	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   341: pop
    //   342: aload 11
    //   344: ldc_w 499
    //   347: iload_3
    //   348: invokevirtual 66	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   351: pop
    //   352: aload 11
    //   354: ldc_w 501
    //   357: aload 6
    //   359: invokevirtual 454	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   362: pop
    //   363: aload_1
    //   364: aload 11
    //   366: invokevirtual 257	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   369: iconst_0
    //   370: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	this	RIJJumpActionImpl
    //   0	371	1	paramContext	Context
    //   0	371	2	paramHashMap	HashMap<String, String>
    //   241	107	3	i	int
    //   58	248	4	localObject1	Object
    //   108	229	5	localObject2	Object
    //   119	239	6	localObject3	Object
    //   2	295	7	localObject4	Object
    //   123	124	8	localObject5	Object
    //   179	114	9	localObject6	Object
    //   183	106	10	localObject7	Object
    //   26	339	11	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   125	135	245	java/lang/Exception
    //   143	153	245	java/lang/Exception
    //   157	169	245	java/lang/Exception
    //   185	195	245	java/lang/Exception
    //   211	221	245	java/lang/Exception
    //   225	242	245	java/lang/Exception
    //   67	110	253	java/lang/Exception
    //   28	60	261	java/lang/Exception
  }
  
  private boolean openAtlas(Context paramContext, HashMap<String, String> paramHashMap)
  {
    boolean bool = paramHashMap.containsKey("rowkey");
    String str8 = "";
    String str1;
    if (bool) {
      str1 = (String)paramHashMap.get("rowkey");
    } else {
      str1 = "";
    }
    if (TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("RIJJumpActionImpl", 2, "rowKey is Empty");
      }
      return false;
    }
    bool = paramHashMap.containsKey("picindex");
    String str4 = "0";
    String str2;
    if (bool) {
      str2 = (String)paramHashMap.get("picindex");
    } else {
      str2 = "0";
    }
    String str3;
    if (paramHashMap.containsKey("source")) {
      str3 = (String)paramHashMap.get("source");
    } else {
      str3 = "0";
    }
    if (paramHashMap.containsKey("enteranimationstyle")) {
      str4 = (String)paramHashMap.get("enteranimationstyle");
    }
    String str5;
    if (paramHashMap.containsKey("hideTopic")) {
      str5 = (String)paramHashMap.get("hideTopic");
    }
    if (paramHashMap.containsKey("commentId")) {
      str5 = (String)paramHashMap.get("commentId");
    } else {
      str5 = "";
    }
    String str6;
    if (paramHashMap.containsKey("subCommentId")) {
      str6 = (String)paramHashMap.get("subCommentId");
    } else {
      str6 = "";
    }
    String str7;
    if (paramHashMap.containsKey("albumStyle")) {
      str7 = (String)paramHashMap.get("albumStyle");
    }
    if (paramHashMap.containsKey("jumpCommentType")) {
      str7 = (String)paramHashMap.get("jumpCommentType");
    } else {
      str7 = "";
    }
    if (paramHashMap.containsKey("isAwesome")) {
      str8 = (String)paramHashMap.get("isAwesome");
    }
    try
    {
      Integer.valueOf(str2).intValue();
      i = Integer.valueOf(str3).intValue();
    }
    catch (Exception paramHashMap)
    {
      int i;
      int j;
      label339:
      label342:
      label344:
      break label342;
    }
    try
    {
      Integer.valueOf(str4).intValue();
      j = i;
    }
    catch (Exception paramHashMap)
    {
      break label339;
    }
    break label344;
    i = 0;
    j = i;
    if (QLog.isColorLevel())
    {
      QLog.e("RIJJumpActionImpl", 2, "Parameter error");
      j = i;
    }
    if (Boolean.valueOf(((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getViolaPicDetailConfig()).booleanValue())
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("https://viola.qq.com/js/kd_pic_detail.js?_rij_violaUrl=1&v_tid=15&v_bid=3811&v_bundleName=kd_pic_detail&hideNav=1&v_nav_immer=1&v_minVersion=8.0.8&v_from_native=1&rowkey=");
      paramHashMap.append(str1);
      paramHashMap.append("&album_source=");
      paramHashMap.append(j);
      paramHashMap.append("&isAwesome=");
      paramHashMap.append(str8);
      paramHashMap.append("&commentId=");
      paramHashMap.append(str5);
      paramHashMap.append("&subCommentId=");
      paramHashMap.append(str6);
      paramHashMap.append("&jumpCommentType=");
      paramHashMap.append(str7);
      paramHashMap = paramHashMap.toString();
      ((IViolaAccessHelper)QRoute.api(IViolaAccessHelper.class)).startViolaPage(paramContext, null, paramHashMap, null);
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.e("RIJJumpActionImpl", 2, "jumpToGallery failed: atlas has undercarriage");
    }
    return false;
  }
  
  private boolean openSelf(Context paramContext)
  {
    ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchSelfFromIndependentTab(paramContext, false);
    return false;
  }
  
  private static String toBase64Decode(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (!"".equals(paramString)) {
        if (paramString.length() == 0) {
          return null;
        }
      }
    }
    try
    {
      localObject1 = new String(Base64Util.decode(paramString, 0));
      return localObject1;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private boolean webJumpMultiVideo(Context paramContext, HashMap<String, String> paramHashMap)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean webReportArticleRealTime(HashMap<String, String> paramHashMap)
  {
    if ((paramHashMap.containsKey("source")) && (!TextUtils.isEmpty((CharSequence)paramHashMap.get("source"))) && (paramHashMap.containsKey("source_article_id")) && (!TextUtils.isEmpty((CharSequence)paramHashMap.get("source_article_id"))) && (paramHashMap.containsKey("operation")) && (!TextUtils.isEmpty((CharSequence)paramHashMap.get("operation"))) && (paramHashMap.containsKey("op_source")) && (!TextUtils.isEmpty((CharSequence)paramHashMap.get("op_source")))) {}
    try
    {
      int i = Integer.parseInt((String)paramHashMap.get("source"));
      long l = Integer.parseInt((String)paramHashMap.get("source_article_id"));
      int j = Integer.parseInt((String)paramHashMap.get("operation"));
      int k = Integer.parseInt((String)paramHashMap.get("op_source"));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("webReportArticleRealTime get source[ ");
        localStringBuilder.append((String)paramHashMap.get("source"));
        localStringBuilder.append("] source_article_id[");
        localStringBuilder.append((String)paramHashMap.get("source_article_id"));
        localStringBuilder.append("] operation[");
        localStringBuilder.append((String)paramHashMap.get("operation"));
        localStringBuilder.append("] op_source[");
        localStringBuilder.append((String)paramHashMap.get("op_source"));
        localStringBuilder.append("]");
        QLog.d("RIJJumpActionImpl", 2, localStringBuilder.toString());
      }
      ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).reportArticleByWeb(i, l, j, k);
    }
    catch (Exception paramHashMap)
    {
      label321:
      break label321;
    }
    QLog.d("RIJJumpActionImpl", 2, "webReportArticleRealTime error!");
    return true;
  }
  
  private boolean webReportT(HashMap<String, String> paramHashMap)
  {
    boolean bool = paramHashMap.containsKey("sub_action");
    String str8 = "";
    String str1;
    if (bool) {
      str1 = (String)paramHashMap.get("sub_action");
    } else {
      str1 = "";
    }
    String str2;
    if (paramHashMap.containsKey("action_name")) {
      str2 = (String)paramHashMap.get("action_name");
    } else {
      str2 = "";
    }
    String str3;
    String str4;
    String str5;
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      if (paramHashMap.containsKey("tag")) {
        str3 = (String)paramHashMap.get("tag");
      } else {
        str3 = "";
      }
      if (paramHashMap.containsKey("main_action")) {
        str4 = (String)paramHashMap.get("main_action");
      } else {
        str4 = "";
      }
      if (paramHashMap.containsKey("to_uin")) {
        str5 = (String)paramHashMap.get("to_uin");
      } else {
        str5 = "";
      }
      if ((paramHashMap.containsKey("from_type")) && (!TextUtils.isEmpty((CharSequence)paramHashMap.get("from_type")))) {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("webReportT get from_type: ");
          ((StringBuilder)localObject).append((String)paramHashMap.get("from_type"));
          QLog.d("RIJJumpActionImpl", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    try
    {
      i = Integer.parseInt((String)paramHashMap.get("from_type"));
    }
    catch (Exception localException1)
    {
      int i;
      label266:
      break label266;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("webReportT get from_type: ");
    ((StringBuilder)localObject).append((String)paramHashMap.get("from_type"));
    ((StringBuilder)localObject).append(" error!");
    QLog.d("RIJJumpActionImpl", 2, ((StringBuilder)localObject).toString());
    i = 0;
    if ((paramHashMap.containsKey("result")) && (!TextUtils.isEmpty((CharSequence)paramHashMap.get("result")))) {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("webReportT get result: ");
        ((StringBuilder)localObject).append((String)paramHashMap.get("result"));
        QLog.d("RIJJumpActionImpl", 2, ((StringBuilder)localObject).toString());
      }
    }
    try
    {
      j = Integer.parseInt((String)paramHashMap.get("result"));
    }
    catch (Exception localException2)
    {
      int j;
      label416:
      String str6;
      String str7;
      break label416;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("webReportT get result: ");
    ((StringBuilder)localObject).append((String)paramHashMap.get("result"));
    ((StringBuilder)localObject).append(" error!");
    QLog.d("RIJJumpActionImpl", 2, ((StringBuilder)localObject).toString());
    j = 0;
    if (paramHashMap.containsKey("r2")) {
      localObject = (String)paramHashMap.get("r2");
    } else {
      localObject = "";
    }
    if (paramHashMap.containsKey("r3")) {
      str6 = (String)paramHashMap.get("r3");
    } else {
      str6 = "";
    }
    if (paramHashMap.containsKey("r4")) {
      str7 = (String)paramHashMap.get("r4");
    } else {
      str7 = "";
    }
    if (paramHashMap.containsKey("r5")) {
      str8 = (String)paramHashMap.get("r5");
    }
    ReportController.b(null, str3, str4, str5, str1, str2, i, j, (String)localObject, str6, str7, str8);
    if (QLog.isColorLevel()) {
      QLog.d("RIJJumpActionImpl", 2, "webReportT ");
    }
    return true;
    if (QLog.isColorLevel())
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("subAction[");
      paramHashMap.append(str1);
      paramHashMap.append("] or actionName[");
      paramHashMap.append(str2);
      paramHashMap.append("] null");
      QLog.d("RIJJumpActionImpl", 2, paramHashMap.toString());
    }
    return true;
  }
  
  public boolean handleServerReadInJoy(@NotNull Context paramContext, @Nullable String paramString1, @NotNull HashMap<String, String> paramHashMap, @Nullable String paramString2, @Nullable String paramString3)
  {
    if ("open".equals(paramString1)) {
      return gotoReadInJoyFromSourceTarget(paramContext, paramHashMap, paramString2, paramString3);
    }
    if ("report".equals(paramString1)) {
      return webReportT(paramHashMap);
    }
    if ("reportrealtime".equals(paramString1)) {
      return webReportArticleRealTime(paramHashMap);
    }
    if ("apenalbum".equals(paramString1)) {
      return articleImageCollection(paramContext, paramHashMap);
    }
    if ("multivideo".equals(paramString1)) {
      return webJumpMultiVideo(paramContext, paramHashMap);
    }
    if ("openatlas".equals(paramString1)) {
      return openAtlas(paramContext, paramHashMap);
    }
    if ("selfpage".equals(paramString1)) {
      return openSelf(paramContext);
    }
    if ("showugceditor".equals(paramString1)) {
      return jumpToDeliverFragment(paramContext, paramHashMap);
    }
    if ("openarticle".equals(paramString1))
    {
      paramString1 = ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getOpenArticleSchemeIntent(paramContext, paramHashMap);
      ((IFastWebActivityUtils)QRoute.api(IFastWebActivityUtils.class)).openNewPage(paramContext, paramString1);
    }
    return false;
  }
  
  public void launchReadInJoyPlugin(@NotNull HashMap<String, String> paramHashMap, @NotNull Intent paramIntent, Context paramContext)
  {
    if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("from")))
    {
      paramIntent.putExtra("readinjoy_launch_source", 4);
      paramIntent.putExtra("readinjoy_launch_style", 0x4 | paramIntent.getIntExtra("readinjoy_launch_style", 1));
      ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).launchReadInJoyPlugin((Activity)paramContext, paramIntent);
      return;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(RIJQQAppInterfaceUtil.b(), "CliOper", "", "", "0X800625F", "0X800625F", 0, 0, "", "", "", "", false);
    ((IVideoVolumeControl)QRoute.api(IVideoVolumeControl.class)).setMute(((IVideoVolumeControl)QRoute.api(IVideoVolumeControl.class)).shouldMuteInReadInJoy(), "init", 1);
    paramIntent.putExtra("readinjoy_launch_source", 1);
    paramIntent.putExtra("readinjoy_launch_start_time", System.currentTimeMillis());
    ((IReadInJoyManager)RIJQQAppInterfaceUtil.b().getRuntimeService(IReadInJoyManager.class)).fillExtraPushInfo(paramIntent);
    ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).launchReadInJoyPlugin((Activity)paramContext, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.router.api.impl.RIJJumpActionImpl
 * JD-Core Version:    0.7.0.1
 */