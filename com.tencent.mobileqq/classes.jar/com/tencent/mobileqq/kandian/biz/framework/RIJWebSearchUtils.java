package com.tencent.mobileqq.kandian.biz.framework;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class RIJWebSearchUtils
{
  public static Intent a(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, SplashActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("tab_index", FrameControllerUtil.a);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("banner_activityName", FastWebActivity.class.getName());
    localIntent.putExtra("banner_webViewUrl", paramAbsBaseArticleInfo.mArticleContentUrl);
    localIntent.putExtra("banner_wording", String.format(HardCodeUtil.a(2131910616), new Object[] { paramAbsBaseArticleInfo.mTitle }));
    paramActivity = paramAbsBaseArticleInfo.mArticleContentUrl;
    if (!TextUtils.isEmpty(paramActivity))
    {
      paramActivity = Uri.parse(paramActivity);
      if (paramActivity.isHierarchical())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("WebView_");
        localStringBuilder.append(paramActivity.getHost());
        localIntent.putExtra("banner_businessCategory", localStringBuilder.toString());
      }
    }
    paramActivity = new Bundle();
    paramActivity.putParcelable("fast_web_article_info", paramAbsBaseArticleInfo);
    paramActivity.putInt("fast_web_banner_from_channel_id", (int)paramAbsBaseArticleInfo.mChannelID);
    paramActivity.putBoolean("fast_web_from_article_recommend", paramBoolean);
    localIntent.putExtra("banner_webview_extra", paramActivity);
    return localIntent;
  }
  
  public static void a(Activity paramActivity)
  {
    a(paramActivity, null);
  }
  
  public static void a(Activity paramActivity, HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem)
  {
    UniteSearchActivity.a(paramActivity, "", 25, 0L, paramHotSearchItem, 0);
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80067D3", "0X80067D3", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
  }
  
  public static boolean a()
  {
    if (!TextUtils.isEmpty(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).readInJoyPreloadToolConfig())) {
      try
      {
        boolean bool = new JSONObject(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).readInJoyPreloadToolConfig()).optBoolean("useNewLogic", false);
        return bool;
      }
      catch (Exception localException)
      {
        QLog.e("RIJWebSearchUtils", 2, localException.getMessage());
      }
    }
    return false;
  }
  
  /* Error */
  public static int b()
  {
    // Byte code:
    //   0: ldc 167
    //   2: invokestatic 173	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   5: checkcast 167	com/tencent/biz/pubaccount/util/api/IPublicAccountConfigUtil
    //   8: invokeinterface 176 1 0
    //   13: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: istore 6
    //   18: sipush 1000
    //   21: istore 5
    //   23: bipush 100
    //   25: istore_1
    //   26: sipush 1024
    //   29: istore_3
    //   30: iload 6
    //   32: ifne +140 -> 172
    //   35: new 178	org/json/JSONObject
    //   38: dup
    //   39: ldc 167
    //   41: invokestatic 173	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   44: checkcast 167	com/tencent/biz/pubaccount/util/api/IPublicAccountConfigUtil
    //   47: invokeinterface 176 1 0
    //   52: invokespecial 181	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   55: astore 13
    //   57: aload 13
    //   59: ldc 183
    //   61: iconst_0
    //   62: invokevirtual 187	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   65: istore 6
    //   67: iload_1
    //   68: istore_2
    //   69: aload 13
    //   71: ldc 202
    //   73: sipush 1024
    //   76: invokevirtual 206	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   79: istore_0
    //   80: iload_1
    //   81: istore_2
    //   82: iload_0
    //   83: istore_3
    //   84: aload 13
    //   86: ldc 208
    //   88: bipush 100
    //   90: invokevirtual 206	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   93: istore_1
    //   94: iload_1
    //   95: istore_2
    //   96: iload_0
    //   97: istore_3
    //   98: aload 13
    //   100: ldc 210
    //   102: iconst_2
    //   103: invokevirtual 206	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   106: istore 4
    //   108: aload 13
    //   110: ldc 212
    //   112: sipush 1000
    //   115: invokevirtual 206	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   118: istore_3
    //   119: iload_0
    //   120: istore_2
    //   121: iload 4
    //   123: istore_0
    //   124: goto +58 -> 182
    //   127: astore 13
    //   129: iload_0
    //   130: istore_2
    //   131: iload 4
    //   133: istore_0
    //   134: goto +21 -> 155
    //   137: astore 13
    //   139: iload_2
    //   140: istore_1
    //   141: iload_3
    //   142: istore_2
    //   143: goto +10 -> 153
    //   146: astore 13
    //   148: iconst_0
    //   149: istore 6
    //   151: iload_3
    //   152: istore_2
    //   153: iconst_2
    //   154: istore_0
    //   155: ldc 189
    //   157: iconst_2
    //   158: aload 13
    //   160: invokevirtual 192	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   163: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: iload 5
    //   168: istore_3
    //   169: goto +13 -> 182
    //   172: iconst_0
    //   173: istore 6
    //   175: iconst_2
    //   176: istore_0
    //   177: iload_3
    //   178: istore_2
    //   179: iload 5
    //   181: istore_3
    //   182: iload 6
    //   184: ifeq +75 -> 259
    //   187: invokestatic 217	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()J
    //   190: lstore 7
    //   192: invokestatic 220	com/tencent/mobileqq/utils/DeviceInfoUtil:r	()J
    //   195: lstore 9
    //   197: invokestatic 223	com/tencent/mobileqq/utils/DeviceInfoUtil:h	()I
    //   200: istore 4
    //   202: invokestatic 226	com/tencent/mobileqq/utils/DeviceInfoUtil:k	()J
    //   205: lstore 11
    //   207: lload 7
    //   209: bipush 20
    //   211: lushr
    //   212: iload_2
    //   213: i2l
    //   214: lcmp
    //   215: iflt +19 -> 234
    //   218: iload 4
    //   220: iload_0
    //   221: if_icmplt +13 -> 234
    //   224: lload 11
    //   226: iload_3
    //   227: i2l
    //   228: lcmp
    //   229: iflt +5 -> 234
    //   232: iconst_1
    //   233: ireturn
    //   234: lload 9
    //   236: bipush 20
    //   238: lushr
    //   239: iload_1
    //   240: i2l
    //   241: lcmp
    //   242: iflt +5 -> 247
    //   245: iconst_2
    //   246: ireturn
    //   247: getstatic 231	android/os/Build$VERSION:SDK_INT	I
    //   250: bipush 19
    //   252: if_icmplt +5 -> 257
    //   255: iconst_1
    //   256: ireturn
    //   257: iconst_0
    //   258: ireturn
    //   259: getstatic 231	android/os/Build$VERSION:SDK_INT	I
    //   262: bipush 19
    //   264: if_icmplt +5 -> 269
    //   267: iconst_1
    //   268: ireturn
    //   269: iconst_0
    //   270: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   79	143	0	i	int
    //   25	215	1	j	int
    //   68	145	2	k	int
    //   29	198	3	m	int
    //   106	116	4	n	int
    //   21	159	5	i1	int
    //   16	167	6	bool	boolean
    //   190	18	7	l1	long
    //   195	40	9	l2	long
    //   205	20	11	l3	long
    //   55	54	13	localJSONObject	JSONObject
    //   127	1	13	localException1	Exception
    //   137	1	13	localException2	Exception
    //   146	13	13	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   108	119	127	java/lang/Exception
    //   69	80	137	java/lang/Exception
    //   84	94	137	java/lang/Exception
    //   98	108	137	java/lang/Exception
    //   35	67	146	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJWebSearchUtils
 * JD-Core Version:    0.7.0.1
 */