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
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInjoyFloatingWindowHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.daily.api.impl.KandianDailyManagerSingleton;
import com.tencent.mobileqq.kandian.biz.fastweb.api.impl.FastWebActivityUtils;
import com.tencent.mobileqq.kandian.biz.feeds.api.impl.ReadInJoyBaseFragmentEntryPath;
import com.tencent.mobileqq.kandian.biz.framework.api.impl.ReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IKandianSubscribeManager;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyManager;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpAction;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJViolaPicDetailConfigSp;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.Foreground;
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
        paramHashMap = ReadInJoyActivityHelper.INSTANCE.getFastWebIntent(paramContext, paramHashMap);
        FastWebActivityUtils.INSTANCE.openNewPage(paramContext, paramHashMap);
      }
      else if ("4".equals(str4))
      {
        if (BaseActivity.sTopActivity != null) {
          paramContext = BaseActivity.sTopActivity;
        }
        ReadInJoyActivityHelper.INSTANCE.startApp(paramContext, paramHashMap);
      }
      else if ("5".equals(str4))
      {
        ReadInJoyActivityHelper.INSTANCE.openFullVideoPlay(paramContext, paramHashMap);
      }
      else if ("6".equals(str4))
      {
        handleReadInJoyOpenTargetViolaPage(paramContext, paramHashMap);
      }
      else if ("7".equals(str4))
      {
        ReadInJoyActivityHelper.INSTANCE.openDailyDynamicChildFeeds(paramContext, paramHashMap);
      }
      else if ("8".equals(str4))
      {
        if ("webview".equals(paramString1)) {
          TroopMemberApiClient.a().f(paramString1);
        } else {
          KandianDailyManagerSingleton.INSTANCE.launchKandianDaily(paramContext);
        }
      }
      else if ("9".equals(str4))
      {
        ReadInjoyFloatingWindowHelper.a(paramContext, paramHashMap);
      }
      else if ("10".equals(str4))
      {
        handleReadInJoySelfCenter(paramContext, paramHashMap);
      }
      else if ("11".equals(str4))
      {
        ReadInJoyActivityHelper.INSTANCE.openFlutterPage(paramContext, paramHashMap);
      }
      else
      {
        if (!"12".equals(str4)) {
          break label350;
        }
        ReadInJoyActivityHelper.INSTANCE.openMXFlutterPage(paramContext, paramHashMap);
      }
    }
    return true;
    label350:
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
          ViolaAccessHelper.a(paramContext, "", paramHashMap, null);
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
      paramContext.startActivity(new Intent(paramContext, ReadInJoyActivityHelper.INSTANCE.getReadInJoySettingActivityClazz()));
      return;
    }
    if ("2".equals(paramHashMap.get("bizType"))) {
      PublicFragmentActivity.a(paramContext, ReadInJoyActivityHelper.INSTANCE.getReadInJoyDraftboxFragmentClazz());
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
      paramString3 = paramContext.getString(2131897917);
    } else {
      paramString3 = paramString4;
    }
    if (TextUtils.equals("1", (CharSequence)paramHashMap.get("from_immersive")))
    {
      jumpToChannelFromImmersiveVideo(paramContext, j, paramString3);
      return Boolean.valueOf(true);
    }
    bool = "1".equalsIgnoreCase((String)paramHashMap.get("ispush"));
    if ((!bool) && (j == 70))
    {
      if ("webview".equals(paramString1)) {
        TroopMemberApiClient.a().o();
      } else {
        ((IKandianSubscribeManager)RIJQQAppInterfaceUtil.b().getRuntimeService(IKandianSubscribeManager.class, "")).lanuchKandianSubscribeActivity(paramContext, 3, 4);
      }
      return Boolean.valueOf(true);
    }
    if (k == 3)
    {
      if (j == 56)
      {
        if (ReadInJoyHelper.w()) {
          ReadInJoyActivityHelper.INSTANCE.launchChannelActivity(paramContext, j, paramString3, k, 4);
        } else {
          ReadInJoyActivityHelper.INSTANCE.launchFeedsActivity(paramContext, 4, 1);
        }
      }
      else {
        ReadInJoyActivityHelper.INSTANCE.launchVideoSubChannelActivity(paramContext, j, paramString3, k, 4);
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
      ReadInJoyBaseFragmentEntryPath.INSTANCE.put(j, 3);
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
      PublicAccountReportUtils.a(RIJQQAppInterfaceUtil.b(), "CliOper", "", "", "0X80067C6", "0X80067C6", 0, 0, "", "1", RIJQQAppInterfaceUtil.b().getCurrentAccountUin(), "", false);
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
    if (RIJShowKanDianTabSp.a())
    {
      try
      {
        paramContext.startActivity(ReadInJoyActivityHelper.INSTANCE.getJumpReadInJoyTabIntent(paramContext, i));
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
      if (ReadInJoyHelper.a((AppInterface)RIJQQAppInterfaceUtil.e()))
      {
        ReadInJoyActivityHelper.INSTANCE.launchFeedsActivity(paramContext, 2, 0);
        return;
      }
      ReadInJoyActivityHelper.INSTANCE.launchFeedsActivity(paramContext, null, -1L, 2);
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
      paramString1 = paramContext.getString(2131897917);
    }
    if (ReadInJoyHelper.w())
    {
      try
      {
        paramContext.startActivity(ReadInJoyActivityHelper.INSTANCE.getJumpReadInJoyTabIntent(paramContext, 12));
        return true;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label153;
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
      ReadInJoyHelper.a((QQAppInterface)RIJQQAppInterfaceUtil.e(), (Activity)paramContext, paramString2);
    }
    label153:
    return true;
  }
  
  private void handleReadInJoyTargetMainVideoTab(Context paramContext, HashMap<String, String> paramHashMap)
  {
    int i = Integer.valueOf((String)paramHashMap.get("from")).intValue();
    if (RIJShowKanDianTabSp.c())
    {
      try
      {
        paramContext.startActivity(ReadInJoyActivityHelper.INSTANCE.getJumpReadInJoyTabIntent(paramContext, i));
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
      if (ReadInJoyHelper.a((AppInterface)RIJQQAppInterfaceUtil.e()))
      {
        ReadInJoyActivityHelper.INSTANCE.launchFeedsActivity(paramContext, i, 0);
        return;
      }
      ReadInJoyActivityHelper.INSTANCE.launchFeedsActivity(paramContext, null, -1L, i);
    }
  }
  
  public static void jumpToChannelFromImmersiveVideo(Context paramContext, int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[jumpToChannelFromImmersiveVideo] channelId = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", channelName = ");
    localStringBuilder.append(paramString);
    QLog.i("RIJJumpActionImpl", 1, localStringBuilder.toString());
    ReadInJoyActivityHelper.INSTANCE.launchChannelActivity(paramContext, paramInt, paramString, 0, 4, null, false, true);
  }
  
  /* Error */
  private boolean jumpToDeliverFragment(Context paramContext, HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: ldc 222
    //   2: astore 7
    //   4: new 43	android/content/Intent
    //   7: dup
    //   8: aload_1
    //   9: getstatic 507	com/tencent/mobileqq/kandian/biz/ugc/api/impl/RIJDeliverUGCUtils:INSTANCE	Lcom/tencent/mobileqq/kandian/biz/ugc/api/impl/RIJDeliverUGCUtils;
    //   12: invokevirtual 510	com/tencent/mobileqq/kandian/biz/ugc/api/impl/RIJDeliverUGCUtils:getReadInJoyDeliverUgcActivityClazz	()Ljava/lang/Class;
    //   15: invokespecial 60	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   18: astore 11
    //   20: aload_2
    //   21: ldc_w 512
    //   24: invokevirtual 216	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   27: ifeq +28 -> 55
    //   30: aload_2
    //   31: ldc_w 512
    //   34: invokevirtual 25	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: ifnull +18 -> 55
    //   40: aload_2
    //   41: ldc_w 512
    //   44: invokevirtual 25	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   47: checkcast 27	java/lang/String
    //   50: astore 4
    //   52: goto +7 -> 59
    //   55: ldc 222
    //   57: astore 4
    //   59: aload_2
    //   60: ldc_w 514
    //   63: invokevirtual 216	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   66: ifeq +39 -> 105
    //   69: aload_2
    //   70: ldc_w 514
    //   73: invokevirtual 25	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   76: ifnull +29 -> 105
    //   79: new 27	java/lang/String
    //   82: dup
    //   83: aload_2
    //   84: ldc_w 514
    //   87: invokevirtual 25	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: checkcast 27	java/lang/String
    //   93: iconst_0
    //   94: invokestatic 520	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   97: invokespecial 523	java/lang/String:<init>	([B)V
    //   100: astore 5
    //   102: goto +7 -> 109
    //   105: ldc 222
    //   107: astore 5
    //   109: aload 7
    //   111: astore 6
    //   113: aload 7
    //   115: astore 8
    //   117: aload_2
    //   118: ldc_w 525
    //   121: invokevirtual 216	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   124: ifeq +37 -> 161
    //   127: aload 7
    //   129: astore 6
    //   131: aload 7
    //   133: astore 8
    //   135: aload_2
    //   136: ldc_w 525
    //   139: invokevirtual 25	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   142: ifnull +19 -> 161
    //   145: aload 7
    //   147: astore 8
    //   149: aload_2
    //   150: ldc_w 525
    //   153: invokevirtual 25	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   156: checkcast 27	java/lang/String
    //   159: astore 6
    //   161: aload 6
    //   163: astore 8
    //   165: aload 4
    //   167: astore 7
    //   169: aload 6
    //   171: astore 9
    //   173: aload 5
    //   175: astore 10
    //   177: aload_2
    //   178: ldc_w 527
    //   181: invokevirtual 216	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   184: ifeq +94 -> 278
    //   187: aload 6
    //   189: astore 8
    //   191: aload 4
    //   193: astore 7
    //   195: aload 6
    //   197: astore 9
    //   199: aload 5
    //   201: astore 10
    //   203: aload_2
    //   204: ldc_w 527
    //   207: invokevirtual 25	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   210: ifnull +68 -> 278
    //   213: aload 6
    //   215: astore 8
    //   217: aload_2
    //   218: ldc_w 527
    //   221: invokevirtual 25	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   224: checkcast 27	java/lang/String
    //   227: invokestatic 350	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   230: invokevirtual 354	java/lang/Integer:intValue	()I
    //   233: istore_3
    //   234: goto +58 -> 292
    //   237: astore_2
    //   238: aload 8
    //   240: astore 7
    //   242: goto +20 -> 262
    //   245: astore_2
    //   246: ldc 222
    //   248: astore 5
    //   250: goto +12 -> 262
    //   253: astore_2
    //   254: ldc 222
    //   256: astore 4
    //   258: aload 4
    //   260: astore 5
    //   262: aload_2
    //   263: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   266: aload 5
    //   268: astore 10
    //   270: aload 7
    //   272: astore 9
    //   274: aload 4
    //   276: astore 7
    //   278: iconst_0
    //   279: istore_3
    //   280: aload 10
    //   282: astore 5
    //   284: aload 9
    //   286: astore 6
    //   288: aload 7
    //   290: astore 4
    //   292: aload 11
    //   294: ldc_w 529
    //   297: aload 4
    //   299: invokevirtual 480	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   302: pop
    //   303: aload 11
    //   305: ldc_w 531
    //   308: iconst_1
    //   309: invokevirtual 534	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   312: pop
    //   313: aload 11
    //   315: ldc_w 536
    //   318: iconst_1
    //   319: invokevirtual 534	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   322: pop
    //   323: aload 11
    //   325: ldc_w 538
    //   328: aload 5
    //   330: invokevirtual 480	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   333: pop
    //   334: aload 11
    //   336: ldc_w 540
    //   339: iload_3
    //   340: invokevirtual 66	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   343: pop
    //   344: aload 11
    //   346: ldc_w 542
    //   349: aload 6
    //   351: invokevirtual 480	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   354: pop
    //   355: aload_1
    //   356: aload 11
    //   358: invokevirtual 265	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   361: iconst_0
    //   362: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	RIJJumpActionImpl
    //   0	363	1	paramContext	Context
    //   0	363	2	paramHashMap	HashMap<String, String>
    //   233	107	3	i	int
    //   50	248	4	localObject1	Object
    //   100	229	5	localObject2	Object
    //   111	239	6	localObject3	Object
    //   2	287	7	localObject4	Object
    //   115	124	8	localObject5	Object
    //   171	114	9	localObject6	Object
    //   175	106	10	localObject7	Object
    //   18	339	11	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   117	127	237	java/lang/Exception
    //   135	145	237	java/lang/Exception
    //   149	161	237	java/lang/Exception
    //   177	187	237	java/lang/Exception
    //   203	213	237	java/lang/Exception
    //   217	234	237	java/lang/Exception
    //   59	102	245	java/lang/Exception
    //   20	52	253	java/lang/Exception
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
    if (Boolean.valueOf(RIJViolaPicDetailConfigSp.a(RIJQQAppInterfaceUtil.e())).booleanValue())
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
      ViolaAccessHelper.a(paramContext, null, paramHashMap.toString(), null);
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.e("RIJJumpActionImpl", 2, "jumpToGallery failed: atlas has undercarriage");
    }
    return false;
  }
  
  private boolean openSelf(Context paramContext)
  {
    ReadInJoyActivityHelper.INSTANCE.launchSelfFromIndependentTab(paramContext, false);
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
      ReadInJoyHelper.a((QQAppInterface)RIJQQAppInterfaceUtil.e(), i, l, j, k);
    }
    catch (Exception paramHashMap)
    {
      label316:
      break label316;
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
    if (Foreground.getTopActivity() != null) {
      paramContext = Foreground.getTopActivity();
    }
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
      paramString1 = ReadInJoyActivityHelper.INSTANCE.getOpenArticleSchemeIntent(paramContext, paramHashMap);
      FastWebActivityUtils.INSTANCE.openNewPage(paramContext, paramString1);
    }
    return false;
  }
  
  public void launchReadInJoyPlugin(@NotNull HashMap<String, String> paramHashMap, @NotNull Intent paramIntent, Context paramContext)
  {
    if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("from")))
    {
      paramIntent.putExtra("readinjoy_launch_source", 4);
      paramIntent.putExtra("readinjoy_launch_style", 0x4 | paramIntent.getIntExtra("readinjoy_launch_style", 1));
      ReadInJoyHelper.a((QQAppInterface)RIJQQAppInterfaceUtil.e(), (Activity)paramContext, paramIntent);
      return;
    }
    PublicAccountReportUtils.a(RIJQQAppInterfaceUtil.b(), "CliOper", "", "", "0X800625F", "0X800625F", 0, 0, "", "", "", "", false);
    VideoVolumeControl.getInstance().setMute(VideoVolumeControl.getInstance().shouldMuteInReadInJoy(), "init", 1);
    paramIntent.putExtra("readinjoy_launch_source", 1);
    paramIntent.putExtra("readinjoy_launch_start_time", System.currentTimeMillis());
    ((IReadInJoyManager)RIJQQAppInterfaceUtil.b().getRuntimeService(IReadInJoyManager.class)).fillExtraPushInfo(paramIntent);
    ReadInJoyHelper.a((QQAppInterface)RIJQQAppInterfaceUtil.e(), (Activity)paramContext, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.router.api.impl.RIJJumpActionImpl
 * JD-Core Version:    0.7.0.1
 */