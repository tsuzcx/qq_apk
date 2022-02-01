import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadinjoyJumpUtils.1;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import cooperation.qzone.util.NetworkState;
import java.net.URL;
import java.util.ArrayList;

public class pbi
{
  public static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      throw new NullPointerException("article info is null");
    }
    if (pay.d(paramBaseArticleInfo)) {
      return 3;
    }
    if (pay.a(paramBaseArticleInfo)) {
      return 2;
    }
    return 0;
  }
  
  public static Intent a(Context paramContext, ArticleInfo paramArticleInfo)
  {
    boolean bool = true;
    paramContext = new Intent(paramContext, VideoFeedsPlayActivity.class);
    paramContext.addFlags(536870912);
    paramContext.putExtra("VIDEO_THIRD_ICON", paramArticleInfo.thirdIcon);
    paramContext.putExtra("VIDEO_THIRD_NAME", paramArticleInfo.thirdName);
    paramContext.putExtra("VIDEO_THIRD_ACTION", paramArticleInfo.thirdAction);
    paramContext.putExtra("VIDEO_THIRD_URL", paramArticleInfo.mThirdVideoURL);
    paramContext.putExtra("VIDEO_THRID_URL_EXPIRE_TIME", paramArticleInfo.mThirdVideoURLExpireTime);
    paramContext.putExtra("VIDEO_ARTICLE_ID", paramArticleInfo.innerUniqueID);
    paramContext.putExtra("VIDEO_ARTICLE_BUSITYPE", paramArticleInfo.busiType);
    paramContext.putExtra("VIDEO_VID", paramArticleInfo.mVideoVid);
    paramContext.putExtra("VIDEO_WIDTH", String.valueOf(paramArticleInfo.mVideoJsonWidth));
    paramContext.putExtra("VIDEO_HEIGHT", String.valueOf(paramArticleInfo.mVideoJsonHeight));
    paramContext.putExtra("VIDEO_TIME", String.valueOf(paramArticleInfo.mVideoDuration));
    paramContext.putExtra("VIDEO_TITLE", paramArticleInfo.mTitle);
    paramContext.putExtra("VIDEO_COVER", paramArticleInfo.mVideoCoverUrl.getFile());
    paramContext.putExtra("VIDEO_H5_URL", paramArticleInfo.mArticleContentUrl);
    paramContext.putExtra("VIDEO_PUB_ACCOUNT_NAME", paramArticleInfo.mSubscribeName);
    paramContext.putExtra("VIDEO_PUB_ACCOUNT_UIN", paramArticleInfo.publishUin);
    paramContext.putExtra("VIDEO_SUBS_TEXT", paramArticleInfo.mVideoArticleSubsText);
    paramContext.putExtra("VIDEO_SUBS_COLOR", paramArticleInfo.mVideoArticleSubsColor);
    if (paramArticleInfo.busiType == 1) {}
    for (;;)
    {
      paramContext.putExtra("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
      paramContext.putExtra("video_url_load", false);
      paramContext.putExtra("image_url_remote", paramArticleInfo.getVideoCoverURL().getFile());
      paramContext.putExtra("detail_url", paramArticleInfo.mArticleContentUrl + "&sourcefrom=0");
      paramContext.putExtra("video_url", paramArticleInfo.getVideoVid());
      paramContext.putExtra("title", paramArticleInfo.mTitle);
      paramContext.putExtra("req_create_time", pax.a(paramArticleInfo.mTime));
      paramContext.putExtra("brief_key", paramArticleInfo.mTitle);
      paramContext.putExtra("KEY_VIDEO_JSON_LIST", paramArticleInfo.mJsonVideoList);
      return paramContext;
      bool = false;
    }
  }
  
  /* Error */
  public static void a(Intent paramIntent)
  {
    // Byte code:
    //   0: invokestatic 213	pay:a	()Lmqq/app/AppRuntime;
    //   3: checkcast 215	com/tencent/mobileqq/app/QQAppInterface
    //   6: astore 5
    //   8: aload 5
    //   10: ifnonnull +4 -> 14
    //   13: return
    //   14: aload 5
    //   16: sipush 162
    //   19: invokevirtual 219	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   22: checkcast 221	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager
    //   25: invokevirtual 224	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/struct/KandianRedDotInfo;
    //   28: astore 6
    //   30: aload 6
    //   32: ifnonnull +12 -> 44
    //   35: ldc 226
    //   37: iconst_2
    //   38: ldc 228
    //   40: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: return
    //   44: aload 6
    //   46: invokevirtual 239	com/tencent/biz/pubaccount/readinjoy/struct/KandianRedDotInfo:getMessageRecord	()Lcom/tencent/mobileqq/data/MessageRecord;
    //   49: astore 5
    //   51: aload 5
    //   53: instanceof 241
    //   56: ifeq +267 -> 323
    //   59: aload 5
    //   61: checkcast 241	com/tencent/mobileqq/data/MessageForStructing
    //   64: astore 5
    //   66: aload 5
    //   68: getfield 245	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   71: ifnull +239 -> 310
    //   74: aload 5
    //   76: getfield 245	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   79: getfield 250	com/tencent/mobileqq/structmsg/AbsStructMsg:mExtraData	Ljava/lang/String;
    //   82: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   85: ifne +225 -> 310
    //   88: new 258	org/json/JSONObject
    //   91: dup
    //   92: aload 5
    //   94: getfield 245	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   97: getfield 250	com/tencent/mobileqq/structmsg/AbsStructMsg:mExtraData	Ljava/lang/String;
    //   100: invokespecial 259	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   103: astore 5
    //   105: aload 5
    //   107: ldc_w 261
    //   110: invokevirtual 265	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   113: istore_2
    //   114: aload 5
    //   116: ldc_w 267
    //   119: ldc_w 269
    //   122: invokevirtual 273	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   125: astore 5
    //   127: aload 5
    //   129: invokestatic 278	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   132: invokevirtual 282	java/lang/Integer:intValue	()I
    //   135: istore_1
    //   136: aload_0
    //   137: ldc_w 284
    //   140: iload_1
    //   141: invokevirtual 86	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   144: pop
    //   145: iload_2
    //   146: istore_3
    //   147: iload_1
    //   148: istore 4
    //   150: iload_2
    //   151: ifne +164 -> 315
    //   154: ldc 226
    //   156: iconst_1
    //   157: new 171	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   164: ldc_w 286
    //   167: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 6
    //   172: getfield 290	com/tencent/biz/pubaccount/readinjoy/struct/KandianRedDotInfo:articleIDList	Ljava/util/ArrayList;
    //   175: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: return
    //   185: astore 5
    //   187: aload 5
    //   189: invokevirtual 296	java/lang/Exception:printStackTrace	()V
    //   192: ldc 226
    //   194: iconst_2
    //   195: ldc_w 298
    //   198: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: iload_2
    //   202: istore_3
    //   203: iload_1
    //   204: istore_2
    //   205: iload_3
    //   206: istore_1
    //   207: aload 6
    //   209: getfield 290	com/tencent/biz/pubaccount/readinjoy/struct/KandianRedDotInfo:articleIDList	Ljava/util/ArrayList;
    //   212: astore 5
    //   214: aload 5
    //   216: ifnull +46 -> 262
    //   219: aload 5
    //   221: invokevirtual 303	java/util/ArrayList:size	()I
    //   224: ifle +38 -> 262
    //   227: aload_0
    //   228: ldc_w 305
    //   231: aload 5
    //   233: iconst_0
    //   234: invokevirtual 309	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   237: checkcast 311	java/io/Serializable
    //   240: invokevirtual 314	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   243: pop
    //   244: aload_0
    //   245: ldc_w 316
    //   248: iconst_0
    //   249: invokevirtual 86	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   252: pop
    //   253: aload_0
    //   254: ldc_w 318
    //   257: iload_2
    //   258: invokevirtual 86	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   261: pop
    //   262: ldc 226
    //   264: iconst_1
    //   265: new 171	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   272: ldc_w 320
    //   275: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 5
    //   280: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   283: ldc_w 322
    //   286: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: iload_2
    //   290: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: ldc_w 327
    //   296: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: iload_1
    //   300: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: return
    //   310: iconst_0
    //   311: istore_3
    //   312: iconst_0
    //   313: istore 4
    //   315: iload 4
    //   317: istore_2
    //   318: iload_3
    //   319: istore_1
    //   320: goto -113 -> 207
    //   323: ldc 226
    //   325: iconst_2
    //   326: ldc_w 329
    //   329: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: iconst_0
    //   333: istore_1
    //   334: iconst_0
    //   335: istore_2
    //   336: goto -129 -> 207
    //   339: astore 5
    //   341: iconst_0
    //   342: istore_1
    //   343: iconst_0
    //   344: istore_2
    //   345: goto -158 -> 187
    //   348: astore 5
    //   350: iconst_0
    //   351: istore_1
    //   352: goto -165 -> 187
    //   355: astore 5
    //   357: iconst_0
    //   358: istore_1
    //   359: goto -214 -> 145
    //   362: astore 5
    //   364: goto -219 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	paramIntent	Intent
    //   135	224	1	i	int
    //   113	232	2	j	int
    //   146	173	3	k	int
    //   148	168	4	m	int
    //   6	122	5	localObject	Object
    //   185	3	5	localException1	java.lang.Exception
    //   212	67	5	localArrayList	ArrayList
    //   339	1	5	localException2	java.lang.Exception
    //   348	1	5	localException3	java.lang.Exception
    //   355	1	5	localException4	java.lang.Exception
    //   362	1	5	localException5	java.lang.Exception
    //   28	180	6	localKandianRedDotInfo	com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo
    // Exception table:
    //   from	to	target	type
    //   154	184	185	java/lang/Exception
    //   59	114	339	java/lang/Exception
    //   114	127	348	java/lang/Exception
    //   127	136	355	java/lang/Exception
    //   136	145	362	java/lang/Exception
  }
  
  public static Intent b(Context paramContext, ArticleInfo paramArticleInfo)
  {
    if (pay.a(paramArticleInfo.mArticleContentUrl, paramArticleInfo.mChannelID, paramArticleInfo))
    {
      localObject1 = pkm.a().a();
      if (localObject1 != null) {
        ((pum)localObject1).a(paramArticleInfo.mArticleContentUrl, String.valueOf(paramArticleInfo.innerUniqueID), paramArticleInfo.mSubscribeID, 1, null);
      }
      paramContext = new Intent(paramContext, FastWebActivity.class);
      paramContext.putExtra("fast_web_article_info", paramArticleInfo);
      paramContext.putExtra("fast_web_from_channel_id", paramArticleInfo.mChannelID);
      paramContext.putExtra("is_native_fast_web", true);
      return paramContext;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", null);
    Object localObject2 = paramArticleInfo.mArticleContentUrl;
    Object localObject1 = localObject2;
    if (pgb.h(paramArticleInfo))
    {
      localObject1 = localObject2;
      if (!pgb.l(paramArticleInfo)) {
        localObject1 = ((rgc)paramArticleInfo.mSocialFeedInfo.a.a.get(0)).b;
      }
    }
    localObject2 = localObject1;
    if (!(paramArticleInfo instanceof AdvertisementInfo))
    {
      if (((String)localObject1).contains("?"))
      {
        localObject1 = (String)localObject1 + "&";
        localObject2 = (String)localObject1 + "from=0";
      }
    }
    else
    {
      localObject1 = localObject2;
      if (AdvertisementInfo.isAppAdvertisementInfo(paramArticleInfo))
      {
        localObject1 = localObject2;
        if (NetworkUtil.isWifiConnected(null))
        {
          if (!((String)localObject2).contains("?")) {
            break label716;
          }
          localObject1 = (String)localObject2 + "&";
          label287:
          localObject1 = (String)localObject1 + "acttype=42";
        }
      }
      localBundle.putString("url", (String)localObject1);
      localBundle.putBoolean("hide_operation_bar", true);
      localBundle.putString("from", String.valueOf(53));
      localBundle.putString("subscribename", paramArticleInfo.mSubscribeName);
      localBundle.putLong("articleid", paramArticleInfo.mArticleID);
      localBundle.putLong("recommendSeq", paramArticleInfo.mRecommendSeq);
      localBundle.putInt("channelid", (int)paramArticleInfo.mChannelID);
      localBundle.putInt("strategyid", paramArticleInfo.mStrategyId);
      localBundle.putLong("algorithmid", paramArticleInfo.mAlgorithmID);
      localBundle.putInt("articalChannelId", 9);
      localBundle.putStringArray("insertPluginsArray", new String[] { "pubAccountPreload" });
      localBundle.putBoolean("ip_connect", uex.m);
      long l = System.currentTimeMillis();
      localBundle.putLong("startOpenPageTime", l);
      localBundle.putLong("click_time", l);
      localBundle.putLong("available_memory", DeviceInfoUtil.getSystemAvaialbeMemory());
      localBundle.putBoolean("preload_tool_white_list", pay.h());
      localObject2 = new Intent(paramContext, ReadInJoyArticleDetailActivity.class);
      localObject1 = PreloadManager.a((String)localObject1);
      paramContext = (Context)localObject1;
      if (localObject1 == null) {
        paramContext = "";
      }
      if ((FileUtils.fileExistsAndNotEmpty(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD + paramContext)) && (PreloadManager.a().b(paramContext) != null))
      {
        localBundle.putString("read_in_joy_from_cache", paramContext);
        if (!pkm.a().a(paramArticleInfo.mArticleID))
        {
          paramArticleInfo = PreloadManager.a();
          if ((NetworkState.getNetworkType() != 1) && (NetworkState.getNetworkType() != 4) && (NetworkState.getNetworkType() != 5)) {
            break label754;
          }
          paramContext = paramArticleInfo.a(paramContext);
          if ((paramContext != null) && (paramContext.size() > 0))
          {
            ThreadManager.post(new ReadinjoyJumpUtils.1(paramArticleInfo, (uen)paramContext.get(0)), 5, null, false);
            if (paramContext.size() <= 1) {
              break label742;
            }
            localBundle.putString("preload_iamge_url", ((uen)paramContext.get(1)).a);
          }
        }
      }
    }
    for (;;)
    {
      ((Intent)localObject2).putExtras(localBundle);
      return localObject2;
      localObject1 = (String)localObject1 + "?";
      break;
      label716:
      localObject1 = (String)localObject2 + "?";
      break label287;
      label742:
      localBundle.putString("preload_iamge_url", null);
      continue;
      label754:
      paramContext = paramArticleInfo.a(paramContext);
      if ((paramContext != null) && (paramContext.size() > 0)) {
        localBundle.putString("preload_iamge_url", ((uen)paramContext.get(0)).a);
      } else {
        localBundle.putString("preload_iamge_url", null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pbi
 * JD-Core Version:    0.7.0.1
 */