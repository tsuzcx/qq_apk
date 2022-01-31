import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseVideoArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.1;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.14;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.15;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.16;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.17;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.18;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.19;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.2;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.20;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.21;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.22;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.23;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.applets.PublicAccountIntent;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.UinPair;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.ConfigGroupInfo;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.ConfigInfo;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.RetInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class sgj
{
  private static volatile int jdField_a_of_type_Int = -1;
  static bbgg jdField_a_of_type_Bbgg;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static String jdField_a_of_type_JavaLangString = "tag_delete_oldkandian_flag";
  private static WeakReference<Handler> jdField_a_of_type_JavaLangRefWeakReference;
  public static MqqHandler a;
  public static boolean a;
  
  public static int a(int paramInt)
  {
    if (paramInt < 0) {
      return paramInt;
    }
    if ((0x200000 & paramInt) != 0) {
      return -2;
    }
    if ((0x4000000 & paramInt) != 0) {
      return -3;
    }
    if ((0x2000000 & paramInt) != 0) {
      return -4;
    }
    if ((0x800000 & paramInt) != 0) {
      return -5;
    }
    if ((0x8000000 & paramInt) != 0) {
      return -6;
    }
    if ((0x80000000 & paramInt) != 0) {
      return -9;
    }
    return -1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = -1;
    int k = j;
    if (paramQQAppInterface != null)
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label22;
      }
      k = j;
    }
    label22:
    do
    {
      int i;
      do
      {
        do
        {
          return k;
          localObject = (akdi)paramQQAppInterface.getManager(56);
          k = j;
        } while (localObject == null);
        Object localObject = ((akdi)localObject).b(paramString);
        if (localObject != null)
        {
          if (((PublicAccountInfo)localObject).extendType == 2) {
            return -7;
          }
          return a(((PublicAccountInfo)localObject).accountFlag);
        }
        localObject = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramString);
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((TroopInfo)localObject).associatePubAccount != 0L) {
            i = -4;
          }
        }
        paramQQAppInterface = (ajvt)paramQQAppInterface.getManager(69);
        k = i;
      } while (paramQQAppInterface == null);
      k = i;
    } while (paramQQAppInterface.a(paramString) == null);
    return -7;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    int j = a(paramQQAppInterface, paramString);
    int i = j;
    if (j == -1) {
      i = a(paramInt);
    }
    return i;
  }
  
  public static int a(String paramString)
  {
    Object localObject1 = ahnn.a().a;
    int j;
    if (localObject1 == null)
    {
      j = 2147483647;
      return j;
    }
    localObject1 = new ArrayList((Collection)localObject1);
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      RecentUserBaseData localRecentUserBaseData = (RecentUserBaseData)((Iterator)localObject2).next();
      if ((localRecentUserBaseData == null) || (localRecentUserBaseData.mUser == null)) {
        ((Iterator)localObject2).remove();
      } else if ((localRecentUserBaseData.mUser.getType() == 1008) && (sbc.b((QQAppInterface)onk.a(), localRecentUserBaseData.mUser.uin))) {
        ((Iterator)localObject2).remove();
      }
    }
    int i = 0;
    for (;;)
    {
      if (i >= ((List)localObject1).size()) {
        break label184;
      }
      localObject2 = (RecentUserBaseData)((List)localObject1).get(i);
      if (((RecentUserBaseData)localObject2).mUser.getType() == 1008)
      {
        j = i;
        if (TextUtils.equals(((RecentUserBaseData)localObject2).mUser.uin, paramString)) {
          break;
        }
      }
      i += 1;
    }
    label184:
    return -1;
  }
  
  public static long a(long paramLong)
  {
    long l = -1L;
    if ((0x200 & paramLong) != 0L) {
      l = -8L;
    }
    while ((0x100000 & paramLong) == 0L) {
      return l;
    }
    return -10L;
  }
  
  public static AccountDetail a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString = (AccountDetail)paramQQAppInterface.a(AccountDetail.class, paramString);
    paramQQAppInterface.a();
    return paramString;
  }
  
  public static String a()
  {
    return "8.2.8,3,4440";
  }
  
  public static String a(ArticleInfo paramArticleInfo, pbj parampbj)
  {
    Object localObject2 = null;
    if (paramArticleInfo == null)
    {
      QLog.d("PublicAccountUtil", 2, "create msg brief for fail, article info is null");
      return "";
    }
    QLog.d("PublicAccountUtil", 2, "createStructingMsgBrief article : " + paramArticleInfo + ", briefPrefix : " + paramArticleInfo.msgBoxBriefPreFix + ", briefContent : " + paramArticleInfo.msgBoxBriefContent);
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramArticleInfo.msgBoxBriefPreFix))
    {
      localObject1 = localObject2;
      if (paramArticleInfo.msgBoxBriefPreFixType > 0)
      {
        if (paramArticleInfo.msgBoxBriefPreFixType != 1) {
          break label145;
        }
        localObject1 = paramArticleInfo.msgBoxBriefPreFix + ": ";
      }
    }
    if (!TextUtils.isEmpty(paramArticleInfo.msgBoxBriefContent))
    {
      paramArticleInfo = paramArticleInfo.msgBoxBriefContent;
      label133:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label245;
      }
    }
    for (;;)
    {
      return axas.b(paramArticleInfo);
      label145:
      localObject1 = localObject2;
      if (paramArticleInfo.msgBoxBriefPreFixType != 2) {
        break;
      }
      localObject1 = localObject2;
      if (!TextUtils.isDigitsOnly(paramArticleInfo.msgBoxBriefPreFix)) {
        break;
      }
      parampbj = ReadInJoyUserInfoModule.a(Long.valueOf(paramArticleInfo.msgBoxBriefPreFix).longValue(), parampbj);
      if (parampbj == null)
      {
        localObject1 = ReadInJoyUserInfoModule.a() + ": ";
        break;
      }
      localObject1 = parampbj.nick + ": ";
      break;
      paramArticleInfo = paramArticleInfo.mTitle;
      break label133;
      label245:
      paramArticleInfo = (String)localObject1 + paramArticleInfo;
    }
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject;
    if (paramBaseArticleInfo == null)
    {
      localObject = "";
      return localObject;
    }
    for (;;)
    {
      try
      {
        for (;;)
        {
          if ((paramBaseArticleInfo.mFeedType != 17) && (paramBaseArticleInfo.mFeedType != 16) && (paramBaseArticleInfo.mFeedType != 19) && (paramBaseArticleInfo.mFeedType != 18)) {
            break label215;
          }
          String str2 = "";
          String str3 = "";
          String str1 = str3;
          localObject = str2;
          if (paramBaseArticleInfo.mTopicRecommendFeedsInfo != null)
          {
            str1 = str3;
            localObject = str2;
            if (paramBaseArticleInfo.mTopicRecommendFeedsInfo.a != null)
            {
              str1 = str3;
              localObject = str2;
              if (paramBaseArticleInfo.mTopicRecommendFeedsInfo.a.size() > 0)
              {
                localObject = ((qdv)paramBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).c;
                str1 = ((qdv)paramBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).jdField_a_of_type_JavaLangString;
              }
            }
          }
          paramBaseArticleInfo = (String)localObject + str1 + (String)localObject + " " + paramBaseArticleInfo.mTitle;
          localObject = paramBaseArticleInfo;
          try
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("PublicAccountUtil", 2, new Object[] { "createStructingMsgBriefSuffix suffix = ", paramBaseArticleInfo });
            return paramBaseArticleInfo;
          }
          catch (Throwable localThrowable1) {}
        }
      }
      catch (Throwable localThrowable2)
      {
        label215:
        paramBaseArticleInfo = "";
        continue;
      }
      localThrowable1.printStackTrace();
      QLog.d("PublicAccountUtil", 1, "createStructingMsgBriefSuffix throw Throwable, create failed.");
      return paramBaseArticleInfo;
      if ((TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) && (paramBaseArticleInfo.isSocialFeed())) {
        paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString;
      } else {
        paramBaseArticleInfo = paramBaseArticleInfo.mTitle;
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      paramQQAppInterface = "";
    }
    String str;
    do
    {
      return paramQQAppInterface;
      str = b(paramQQAppInterface, paramBaseArticleInfo);
      paramBaseArticleInfo = a(paramBaseArticleInfo);
      paramQQAppInterface = paramBaseArticleInfo;
    } while (TextUtils.isEmpty(str));
    return str + ": " + paramBaseArticleInfo;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, BaseVideoArticleInfo paramBaseVideoArticleInfo)
  {
    if (paramBaseVideoArticleInfo == null) {
      paramQQAppInterface = "";
    }
    String str;
    do
    {
      return paramQQAppInterface;
      str = paramBaseVideoArticleInfo.subscribeName;
      paramBaseVideoArticleInfo = paramBaseVideoArticleInfo.title;
      paramQQAppInterface = paramBaseVideoArticleInfo;
    } while (TextUtils.isEmpty(str));
    return str + ": " + paramBaseVideoArticleInfo;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface = (akdi)paramQQAppInterface.getManager(56);
      str = paramString;
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.c(paramString);
        str = paramString;
        if (paramQQAppInterface != null) {
          str = paramQQAppInterface.name;
        }
      }
    }
    return str;
  }
  
  public static String a(String paramString)
  {
    SkinData localSkinData = null;
    Object localObject1 = paramString;
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject1 = bbjn.p(BaseApplicationImpl.getApplication(), str);
      if (localObject1 == null) {
        break label123;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (localObject1 != null) {
          localSkinData = new SkinData((JSONObject)localObject1);
        }
        localObject1 = paramString;
        if (localSkinData != null)
        {
          paramString = mze.a(paramString, "_kdSkinID=" + localSkinData.id);
          if (bbjn.u(BaseApplicationImpl.getApplication(), str)) {
            localObject1 = mze.a(paramString, "_kdSkinVoice=1");
          }
        }
        else
        {
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        localObject2 = null;
        continue;
      }
      return mze.a(paramString, "_kdSkinVoice=0");
      label123:
      Object localObject2 = null;
    }
  }
  
  /* Error */
  public static NewIntent a(QQAppInterface paramQQAppInterface, Context paramContext, MqqHandler paramMqqHandler, String paramString)
  {
    // Byte code:
    //   0: invokestatic 301	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 195
    //   8: iconst_2
    //   9: new 207	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 397
    //   19: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_3
    //   23: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: ldc 2
    //   34: monitorenter
    //   35: aload_2
    //   36: ifnull +7 -> 43
    //   39: aload_2
    //   40: putstatic 399	sgj:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   43: ldc 2
    //   45: monitorexit
    //   46: new 401	mqq/app/NewIntent
    //   49: dup
    //   50: aload_1
    //   51: ldc_w 403
    //   54: invokespecial 406	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   57: astore_1
    //   58: aload_1
    //   59: ldc_w 408
    //   62: ldc_w 410
    //   65: invokevirtual 414	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   68: pop
    //   69: new 416	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest
    //   72: dup
    //   73: invokespecial 417	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:<init>	()V
    //   76: astore_2
    //   77: aload_2
    //   78: getfield 421	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:seqno	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   81: iconst_0
    //   82: invokevirtual 427	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   85: aload_2
    //   86: getfield 430	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   89: iconst_1
    //   90: invokevirtual 427	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   93: aload_2
    //   94: getfield 434	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:versionInfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   97: ldc 192
    //   99: invokevirtual 438	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   102: aload_2
    //   103: getfield 440	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:uin	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   106: aload_3
    //   107: invokestatic 444	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   110: l2i
    //   111: invokevirtual 427	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   114: aload_1
    //   115: ldc_w 446
    //   118: aload_2
    //   119: invokevirtual 450	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:toByteArray	()[B
    //   122: invokevirtual 453	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   125: pop
    //   126: aload_1
    //   127: new 455	sgk
    //   130: dup
    //   131: aload_0
    //   132: invokespecial 458	sgk:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   135: invokevirtual 462	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   138: aload_0
    //   139: aload_1
    //   140: invokevirtual 466	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   143: invokestatic 301	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +12 -> 158
    //   149: ldc 195
    //   151: iconst_2
    //   152: ldc_w 468
    //   155: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload_1
    //   159: areturn
    //   160: astore_0
    //   161: ldc 2
    //   163: monitorexit
    //   164: aload_0
    //   165: athrow
    //   166: astore_3
    //   167: goto -53 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramQQAppInterface	QQAppInterface
    //   0	170	1	paramContext	Context
    //   0	170	2	paramMqqHandler	MqqHandler
    //   0	170	3	paramString	String
    // Exception table:
    //   from	to	target	type
    //   39	43	160	finally
    //   43	46	160	finally
    //   161	164	160	finally
    //   102	114	166	java/lang/Exception
  }
  
  public static JSONObject a(String paramString)
  {
    try
    {
      paramString = (JSONObject)new JSONTokener(paramString).nextValue();
      return paramString;
    }
    catch (JSONException paramString)
    {
      return null;
    }
    catch (NullPointerException paramString)
    {
      return null;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static void a()
  {
    try
    {
      jdField_a_of_type_MqqOsMqqHandler = null;
      return;
    }
    finally {}
  }
  
  public static void a(int paramInt1, int paramInt2, List<oidb_cmd0x80a.AttributeList> paramList)
  {
    ThreadManager.executeOnSubThread(new PublicAccountUtil.21(paramList, paramInt1, paramInt2));
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Uri localUri;
    String str;
    do
    {
      do
      {
        return;
        localUri = Uri.parse(paramString);
      } while (localUri == null);
      str = localUri.getHost();
    } while ((TextUtils.isEmpty(str)) || ((!"article.mp.qq.com".equalsIgnoreCase(str)) && (!"post.mp.qq.com".equalsIgnoreCase(str))));
    ThreadManager.post(new PublicAccountUtil.16(localUri, paramInt2, paramInt1, paramString), 5, null, false);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return;
      try
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          i = Integer.parseInt(paramString2);
          paramString2 = Uri.parse(paramString1);
          if (paramString2 == null) {
            continue;
          }
          String str = paramString2.getHost();
          if ((TextUtils.isEmpty(str)) || ((!"article.mp.qq.com".equalsIgnoreCase(str)) && (!"post.mp.qq.com".equalsIgnoreCase(str)))) {
            continue;
          }
          ThreadManager.post(new PublicAccountUtil.17(paramString2, i, paramString3, paramString4, paramInt, paramString1), 5, null, false);
          return;
        }
      }
      catch (NumberFormatException paramString2)
      {
        for (;;)
        {
          int i = 0;
          continue;
          i = 0;
        }
      }
    }
  }
  
  public static void a(int paramInt, List<oidb_cmd0x80a.AttributeList> paramList)
  {
    ThreadManager.executeOnSubThread(new PublicAccountUtil.20(paramList, paramInt));
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    Object localObject = paramProfileParams.a;
    if ((TextUtils.isEmpty(((ProfileParams.CurLoginUsr)localObject).jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(((ProfileParams.CurLoginUsr)localObject).b))) {
      b(paramActivity, paramQQAppInterface, paramProfileParams);
    }
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(((ProfileParams.CurLoginUsr)localObject).b))
      {
        String str = paramQQAppInterface.getCurrentAccountUin();
        if (!((ProfileParams.CurLoginUsr)localObject).b.equals(str))
        {
          c(paramActivity, paramQQAppInterface, paramProfileParams);
          return;
        }
        b(paramActivity, paramQQAppInterface, paramProfileParams);
        return;
      }
      localObject = new sgl(paramActivity, paramQQAppInterface, paramProfileParams);
      localObject = bgyu.a(paramQQAppInterface, paramProfileParams.a(), (ajtg)localObject);
      if (localObject != null)
      {
        if (!a(paramActivity, (OpenID)localObject, paramQQAppInterface, paramProfileParams)) {}
        for (int i = 1; i != 0; i = 0)
        {
          b(paramActivity, paramQQAppInterface, paramProfileParams);
          return;
        }
      }
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    Toast.makeText(paramContext, paramInt, 0).show();
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    boolean bool = ((Boolean)bbjn.a(paramContext, paramQQAppInterface.getCurrentAccountUin(), "config_tim_team_is_web", Boolean.valueOf(false))).booleanValue();
    String str = (String)bbjn.a(paramContext, paramQQAppInterface.getCurrentAccountUin(), "config_tim_team_url", "https://m.q.qq.com/a/p/1109953074?s=pages%2Fnotification%2Findex%3FenterType%3DqqMiniHelper");
    if ((!bool) && (MiniAppLauncher.isMiniAppUrl(str))) {
      MiniAppLauncher.startMiniApp(paramContext, str, 1043, null);
    }
    for (;;)
    {
      paramQQAppInterface.a().a(ajsf.aU, 1008, true, true);
      return;
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("webStyle", "noBottomBar");
      paramContext.startActivity(localIntent);
    }
  }
  
  private static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt, Intent paramIntent)
  {
    switch (a(paramQQAppInterface, paramString, paramInt))
    {
    default: 
      a(paramIntent, paramContext, paramString);
    case -6: 
      return;
    }
    nbc.a(paramContext, paramIntent, paramString, false, -1, true, -1);
  }
  
  private static void a(Intent paramIntent, Activity paramActivity, String paramString, int paramInt1, int paramInt2)
  {
    if (paramIntent == null) {
      paramIntent = new Intent(paramActivity, QidianProfileCardActivity.class);
    }
    for (;;)
    {
      paramIntent.putExtra("AllInOne", new ProfileActivity.AllInOne(paramString, 104));
      paramIntent.putExtra("uin", paramString);
      paramActivity.startActivityForResult(paramIntent, paramInt1);
      return;
      paramIntent.setClassName(paramActivity, QidianProfileCardActivity.class.getName());
    }
  }
  
  public static void a(Intent paramIntent, Context paramContext, String paramString)
  {
    if (paramIntent == null) {
      paramIntent = new Intent(paramContext, AccountDetailActivity.class);
    }
    for (;;)
    {
      paramIntent.putExtra("uin", paramString);
      paramIntent.addFlags(67108864);
      paramContext.startActivity(paramIntent);
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(2130771992, 2130771993);
      }
      return;
      paramIntent.setClassName(paramContext, AccountDetailActivity.class.getName());
    }
  }
  
  public static void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "gotoProfileForResult app: " + paramQQAppInterface + " | activity: " + paramActivity + " | uin: " + paramString + " | accountFlag: " + paramInt1 + " | requestCode: " + paramInt2 + " | source: " + paramInt3);
    }
    if ((paramQQAppInterface == null) || (paramActivity == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      switch (a(paramQQAppInterface, paramString, paramInt1))
      {
      default: 
        a(paramIntent, paramQQAppInterface, paramActivity, paramString, paramInt2, paramInt3, paramBoolean);
        return;
      }
    } while (!myy.a(paramActivity, paramString));
    a(paramIntent, paramActivity, paramString, paramInt2, paramInt3);
    return;
    nbc.a(paramActivity, paramIntent, paramString, false, 5, true, paramInt2);
  }
  
  private static void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = omm.k + bbca.encodeToString(paramString.getBytes(), 0);
      paramIntent = new Intent(paramActivity, PublicAccountBrowser.class);
      paramIntent.putExtra("url", str);
      paramActivity.startActivityForResult(paramIntent, paramInt1);
    }
    switch (paramInt2)
    {
    default: 
      return;
      if (paramIntent == null) {
        paramIntent = new Intent(paramActivity, AccountDetailActivity.class);
      }
      for (;;)
      {
        paramIntent.putExtra("uin", paramString);
        paramIntent.putExtra("source", 5);
        paramIntent.addFlags(67108864);
        break;
        paramIntent.setClassName(paramActivity, AccountDetailActivity.class.getName());
      }
    }
    PublicAccountHandler.a(paramQQAppInterface, paramString, "Pb_account_lifeservice", "mp_msg_sys_2", "detail");
  }
  
  public static void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "gotoProfile app: " + paramQQAppInterface + " | context: " + paramContext + " | uin: " + paramString + " | accountFlag: " + paramInt);
    }
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (ajsf.aQ.equals(paramString))
    {
      KandianSubscribeManager.a(paramContext, 3);
      return;
    }
    paramInt = a(paramQQAppInterface, paramString, paramInt);
    if ((paramInt == -2) || (paramInt == -3) || (paramInt == -4))
    {
      if (paramIntent != null) {
        break label237;
      }
      paramIntent = new Intent();
      paramIntent.putExtra("source", 105);
    }
    label237:
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        a(paramIntent, paramContext, paramString);
        return;
        if ((paramInt == -1) && (paramIntent == null))
        {
          paramIntent = new Intent();
          paramIntent.putExtra("source", 104);
        }
        break;
      case -6: 
        if (!myy.a(paramContext, paramString)) {
          break;
        }
        b(paramIntent, paramContext, paramString);
        return;
      case -7: 
        nbc.a(paramContext, paramIntent, paramString, false, -1, true, -1);
        return;
      }
    }
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    a(null, paramIntent, paramString);
  }
  
  public static void a(Handler paramHandler)
  {
    if (paramHandler != null) {}
    for (;;)
    {
      try
      {
        jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHandler);
        return;
      }
      finally {}
      jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    b(paramAppInterface, paramContext, paramString, -1);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString, akdo paramakdo)
  {
    a(paramAppInterface, paramContext, paramString, paramakdo, true, 0);
  }
  
  @Deprecated
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString, akdo paramakdo, int paramInt)
  {
    if ((paramAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)paramAppInterface;
    localQQAppInterface.addObserver(new akws(new sgu(paramakdo, paramString, paramAppInterface, paramContext), localQQAppInterface));
    akwx.a(localQQAppInterface, true, paramString, 0);
    if ((paramAppInterface instanceof QQAppInterface)) {
      paramAppInterface = (QQAppInterface)paramAppInterface;
    }
    for (;;)
    {
      noo.a(paramAppInterface, paramString, 0);
      return;
      paramAppInterface = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((paramAppInterface != null) && ((paramAppInterface instanceof QQAppInterface))) {
        paramAppInterface = (QQAppInterface)paramAppInterface;
      } else {
        paramAppInterface = null;
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString, akdo paramakdo, boolean paramBoolean)
  {
    a(paramAppInterface, paramContext, paramString, paramakdo, paramBoolean, 0);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString, akdo paramakdo, boolean paramBoolean, int paramInt)
  {
    a(paramAppInterface, paramContext, paramString, paramakdo, paramBoolean, paramInt, false);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString, akdo paramakdo, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if ((paramAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramContext = BaseApplicationImpl.getContext();
    if (paramBoolean2) {
      paramBoolean2 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountUtil", 2, "followUin() uin: " + paramString + "  useNewProtocol: " + paramBoolean2);
      }
      Object localObject;
      if ((!(paramAppInterface instanceof QQAppInterface)) || (paramBoolean2))
      {
        paramakdo = new akws(new sgq(paramakdo, paramString, paramAppInterface, paramContext, paramInt, paramBoolean1));
        paramContext = new PublicAccountIntent(paramContext.getApplicationContext(), akwu.class);
        paramContext.a(paramakdo);
        paramContext.putExtra("BUNDLE_PUBLIC_ACCOUNT_CMD", "newFollow");
        paramContext.putExtra("BUNDLE_PUBLIC_ACCOUNT_UIN", paramString);
        paramContext.putExtra("BUNDLE_PUBLIC_ACCOUNT_IS_FOLLOW", true);
        paramContext.putExtra("BUNDLE_PUBLIC_ACCOUNT_SOURCE", paramInt);
        paramAppInterface.startServlet(paramContext);
        return;
        localObject = (akdi)paramAppInterface.getManager(56);
        if (localObject != null)
        {
          localObject = ((akdi)localObject).a(paramString);
          if ((localObject == null) || (a(((AccountDetail)localObject).accountFlag) == -4))
          {
            paramBoolean2 = false;
            continue;
          }
          paramBoolean2 = true;
        }
      }
      else
      {
        localObject = new NewIntent(paramContext.getApplicationContext(), nou.class);
        ((NewIntent)localObject).putExtra("cmd", "follow");
        mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
        localFollowRequest.ext.set("" + paramInt);
        try
        {
          localFollowRequest.uin.set((int)Long.parseLong(paramString));
          ((NewIntent)localObject).setObserver(new sgr(paramakdo, paramString, paramBoolean1, paramContext, paramAppInterface, paramInt));
          ((NewIntent)localObject).putExtra("data", localFollowRequest.toByteArray());
          paramAppInterface.startServlet((NewIntent)localObject);
          return;
        }
        catch (NumberFormatException paramAppInterface) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("PublicAccountUtil", 2, "Follow Request got wrong uin:" + paramString);
        return;
      }
      paramBoolean2 = false;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = paramQQAppInterface.getLongAccountUin();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramLong;
    localReportInfo.mAlgorithmId = paramInt1;
    localReportInfo.mOperation = paramInt3;
    localReportInfo.mOpSource = 3;
    localReportInfo.mStrategyId = paramInt2;
    localArrayList.add(localReportInfo);
    new pbx(paramQQAppInterface, null, null, pou.a(), null).a(localArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, int paramInt, RecentBaseData paramRecentBaseData)
  {
    paramRecentUser = new Intent();
    if (paramRecentBaseData != null) {
      paramRecentUser.putExtra("serviceUnReadNumber", paramRecentBaseData.mUnreadNum);
    }
    wiv.a(paramActivity, 9004, paramRecentUser);
    if (QLog.isColorLevel()) {
      QLog.d("RecentUtil", 2, "enterServiceAccountFolderActivityFromMsgTab");
    }
    if (paramRecentBaseData == null) {}
    for (paramInt = -1;; paramInt = paramRecentBaseData.mPosition)
    {
      ThreadManager.executeOnSubThread(new PublicAccountUtil.23(paramQQAppInterface, paramInt));
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new PublicAccountUtil.1(paramQQAppInterface, paramContext, paramString));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    bfol localbfol = (bfol)bfoy.a(paramContext, null);
    localbfol.a(paramContext.getResources().getString(2131696395));
    localbfol.a(2131691507, 3);
    if (paramString.equals("2010741172")) {
      localbfol.b(2131695533);
    }
    localbfol.c(2131690596);
    localbfol.a(new sgp(paramQQAppInterface, paramString, paramInt, paramLong, paramBoolean, paramContext, localbfol));
    localbfol.show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean, akdo paramakdo)
  {
    a(paramQQAppInterface, paramContext, paramString, paramBoolean, paramakdo, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean1, akdo paramakdo, boolean paramBoolean2)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    paramContext = null;
    NewIntent localNewIntent = null;
    Object localObject3 = (akdi)paramQQAppInterface.getManager(56);
    Object localObject1 = localNewIntent;
    Object localObject2;
    if (localObject3 != null)
    {
      localObject2 = ((akdi)localObject3).a(paramString);
      ((akdi)localObject3).b(paramString);
      paramContext = (Context)localObject2;
      localObject1 = localNewIntent;
      if (localObject2 == null)
      {
        localObject3 = (ajvt)paramQQAppInterface.getManager(69);
        paramContext = (Context)localObject2;
        localObject1 = localNewIntent;
        if (localObject3 != null)
        {
          localObject1 = ((ajvt)localObject3).a(paramString);
          paramContext = (Context)localObject2;
        }
      }
    }
    boolean bool;
    if ((paramBoolean2) || (paramContext == null) || (a(paramContext.accountFlag) != -4))
    {
      bool = true;
      label131:
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountUtil", 2, "unFollowUin() uin: " + paramString + "  useNewProtocol: " + bool);
      }
      if ((!paramBoolean2) && (paramContext != null) && (a(paramContext.accountFlag) == -4))
      {
        localNewIntent = new NewIntent(paramQQAppInterface.getApp().getApplicationContext(), nou.class);
        localNewIntent.putExtra("cmd", "unfollow");
        localObject2 = new mobileqq_mp.UnFollowRequest();
      }
    }
    else
    {
      for (;;)
      {
        try
        {
          ((mobileqq_mp.UnFollowRequest)localObject2).uin.set((int)Long.parseLong(paramString));
          if (localObject1 != null) {
            break label337;
          }
          paramContext = new sgs(paramakdo, paramString, paramBoolean1, localBaseApplication, localObject1, paramQQAppInterface);
          localNewIntent.putExtra("data", ((mobileqq_mp.UnFollowRequest)localObject2).toByteArray());
          localNewIntent.setObserver(paramContext);
          paramQQAppInterface.startServlet(localNewIntent);
          return;
        }
        catch (NumberFormatException paramQQAppInterface) {}
        bool = false;
        break label131;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("PublicAccountUtil", 2, "Unfollow Request got wrong uin:" + paramString);
        return;
        label337:
        localObject1 = paramContext;
      }
    }
    if (localObject1 == null) {}
    for (;;)
    {
      paramContext = new akws(new sgt(localObject1, paramQQAppInterface, paramString, paramakdo, paramBoolean1, localBaseApplication), paramQQAppInterface);
      paramContext.a(paramQQAppInterface);
      paramQQAppInterface.removeObserver(paramContext);
      paramQQAppInterface.addObserver(paramContext);
      akwx.a(paramQQAppInterface, false, paramString, 0);
      return;
      localObject1 = paramContext;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramQQAppInterface == null) || (paramChatMessage == null)) {
      return;
    }
    String str = "";
    if (paramChatMessage.mExJsonObject != null) {
      str = paramChatMessage.mExJsonObject.optString("report_key_bytes_oac_msg_extend");
    }
    akwv.a(paramQQAppInterface, paramChatMessage.senderuin, 0, 6, paramChatMessage.msgId, str);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing, int paramInt)
  {
    if (paramMessageForStructing == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int j;
    int i;
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mAlgorithmIds))
    {
      localObject = paramMessageForStructing.structingMsg.mAlgorithmIds.split("\\|");
      j = localObject.length;
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          String str1 = localObject[i];
          try
          {
            localArrayList.add(Integer.valueOf(Integer.parseInt(str1)));
            i += 1;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              localException1.printStackTrace();
            }
          }
        }
      }
    }
    Object localObject = new ArrayList();
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mStrategyIds))
    {
      String[] arrayOfString = paramMessageForStructing.structingMsg.mStrategyIds.split("\\|");
      j = arrayOfString.length;
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          String str2 = arrayOfString[i];
          try
          {
            ((ArrayList)localObject).add(Integer.valueOf(Integer.parseInt(str2)));
            i += 1;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localException2.printStackTrace();
            }
          }
        }
      }
    }
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mMsgActionData))
    {
      paramMessageForStructing = a(paramMessageForStructing.structingMsg.mMsgActionData);
      if (paramMessageForStructing == null) {}
    }
    for (;;)
    {
      try
      {
        l = Long.parseLong(paramMessageForStructing.getString("id"));
        if ((l == -1L) || (localArrayList.size() <= 0) || (((ArrayList)localObject).size() <= 0)) {
          break;
        }
        a(paramQQAppInterface, l, ((Integer)localArrayList.get(0)).intValue(), ((Integer)((ArrayList)localObject).get(0)).intValue(), paramInt);
        return;
      }
      catch (Exception paramMessageForStructing)
      {
        paramMessageForStructing.printStackTrace();
      }
      long l = -1L;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramString = new UinPair(paramQQAppInterface.getCurrentAccountUin(), paramString);
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)paramQQAppInterface.a(11);
    if ((localPublicAccountHandler.a != null) && (localPublicAccountHandler.a.contains(paramString))) {
      localPublicAccountHandler.a.remove(paramString);
    }
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramQQAppInterface.b(paramString);
    paramQQAppInterface.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (bhvh.a(paramQQAppInterface))
    {
      localObject = (KandianMergeManager)paramQQAppInterface.getManager(162);
      paramQQAppInterface = paramString1;
      if (!TextUtils.isEmpty(paramString3)) {
        paramQQAppInterface = paramString3 + ": " + paramString1;
      }
      ((KandianMergeManager)localObject).a(paramQQAppInterface, paramString2, paramInt, paramBoolean);
    }
    do
    {
      return;
      localObject = paramQQAppInterface.a();
    } while (localObject == null);
    ThreadManager.post(new PublicAccountUtil.18((QQMessageFacade)localObject, paramString3, paramString1, paramString2, paramQQAppInterface), 10, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramString3, 0, paramBoolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    int i = 1;
    Object localObject2 = paramQQAppInterface.getApplication().getSharedPreferences("mobileQQ", 0);
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_Int == -1) {
          jdField_a_of_type_Int = ((SharedPreferences)localObject2).getInt(jdField_a_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin(), 0);
        }
        boolean bool;
        if (jdField_a_of_type_Int == 0)
        {
          bool = true;
          break label297;
          jdField_a_of_type_Int = i;
          ((SharedPreferences)localObject2).edit().putInt(jdField_a_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin(), jdField_a_of_type_Int).commit();
          if ((bool) && (paramBoolean))
          {
            ??? = paramQQAppInterface.a().a();
            if (??? != null)
            {
              localObject2 = ((aktg)???).b(ajsf.ay, 1008);
              if (localObject2 != null)
              {
                ((aktg)???).b((RecentUser)localObject2);
                ??? = paramQQAppInterface.getHandler(Conversation.class);
                if (??? != null) {
                  ((MqqHandler)???).sendEmptyMessage(1009);
                }
              }
            }
            ??? = (akdi)paramQQAppInterface.getManager(56);
            if (??? != null)
            {
              ((akdi)???).c(ajsf.ay);
              paramQQAppInterface = paramQQAppInterface.getHandler(PublicAccountFragment.class);
              if (paramQQAppInterface != null) {
                paramQQAppInterface.sendEmptyMessage(0);
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("PublicAccountUtil", 2, "updateDeleteOldKandian notDeleteState = " + bool + ", isDelete = " + paramBoolean);
          }
        }
        else
        {
          bool = false;
          break label297;
          i = 0;
        }
      }
      label297:
      if (!paramBoolean) {}
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, Intent paramIntent, String paramString)
  {
    if (paramMessageRecord != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramMessageRecord.istroop == 1)
        {
          paramIntent.putExtra("groupUin", paramMessageRecord.frienduin);
          Object localObject = (TroopManager)BaseApplicationImpl.getApplication().getRuntime().getManager(52);
          if (localObject != null)
          {
            localObject = ((TroopManager)localObject).b(paramMessageRecord.frienduin);
            if (localObject != null) {
              paramIntent.putExtra("isAdmin", ((TroopInfo)localObject).isAdmin());
            }
          }
        }
        if (paramMessageRecord.istroop == 3000) {
          paramIntent.putExtra("dicussgroup_uin", paramMessageRecord.frienduin);
        }
        paramIntent.putExtra("friend_uin", paramMessageRecord.frienduin);
        paramIntent.putExtra("friendUin", paramMessageRecord.senderuin);
        paramIntent.putExtra("uinType", paramMessageRecord.istroop);
        paramIntent.putExtra("is_send", paramMessageRecord.isSend());
        paramIntent.putExtra("fromAio", true);
        paramMessageRecord = paramIntent.getComponent();
        if (paramMessageRecord == null) {
          break;
        }
        if (TextUtils.isEmpty(paramString)) {
          return;
        }
        i = paramString.indexOf("?");
        if (i == -1) {
          break;
        }
        paramString = paramString.substring(i + 1).split("&");
        i = 0;
        if (i >= paramString.length) {
          break;
        }
        if (paramString[i].startsWith("_webviewtype="))
        {
          paramString = paramString[i].split("=");
          if (paramString.length != 2) {
            break;
          }
          boolean bool = TextUtils.isEmpty(paramString[1]);
          if (bool) {
            break;
          }
          try
          {
            switch (Integer.parseInt(paramString[1]))
            {
            case 1: 
              paramIntent.setComponent(new ComponentName(paramMessageRecord.getPackageName(), CouponActivity.class.getName()));
              return;
            }
          }
          catch (NumberFormatException paramMessageRecord)
          {
            return;
          }
        }
        if (paramString[i].startsWith("url="))
        {
          paramMessageRecord = paramString[i].split("=");
          if ((paramMessageRecord.length != 2) || (TextUtils.isEmpty(paramMessageRecord[1]))) {
            break;
          }
          a(paramIntent, URLDecoder.decode(paramMessageRecord[1]));
          return;
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        return;
      }
      i += 1;
    }
    return;
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Uri localUri;
    String str;
    do
    {
      do
      {
        return;
        localUri = Uri.parse(paramString);
      } while (localUri == null);
      str = localUri.getHost();
    } while ((TextUtils.isEmpty(str)) || ((!"article.mp.qq.com".equalsIgnoreCase(str)) && (!"post.mp.qq.com".equalsIgnoreCase(str))));
    ThreadManager.post(new PublicAccountUtil.15(localUri, paramString), 5, null, false);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountUtil", 2, "videoPlayRealtimeReport aid=" + paramString1 + ", vid=" + paramString2 + ", rtype=" + paramInt1 + ", rcode=" + paramInt2);
    }
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && ((localObject instanceof QQAppInterface)))
    {
      b(paramString1, paramString2, paramInt1, paramInt2);
      return;
    }
    localObject = new Intent("readInJoy_video_play_real_time_report");
    ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_AID", paramString1);
    ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_VID", paramString2);
    ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_RTYPE", paramInt1);
    ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_RCODE", paramInt2);
    BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
  }
  
  public static boolean a()
  {
    return false;
  }
  
  public static boolean a(int paramInt, long paramLong)
  {
    paramInt = a(paramInt);
    if ((paramInt == -2) || (paramInt == -3) || (paramInt == -4)) {}
    while (a(paramLong) == -8L) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Activity paramActivity, OpenID paramOpenID, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    if ((paramOpenID != null) && (!TextUtils.isEmpty(paramOpenID.openID)))
    {
      if (!paramOpenID.openID.equals(paramProfileParams.a().jdField_a_of_type_JavaLangString)) {}
      for (int i = 1; i != 0; i = 0)
      {
        c(paramActivity, paramQQAppInterface, paramProfileParams);
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(Context paramContext, ProfileParams paramProfileParams)
  {
    return (paramContext == null) || (paramProfileParams == null) || (paramProfileParams.a == null) || (TextUtils.isEmpty(paramProfileParams.a()));
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramAppInterface = paramAppInterface.getEntityManagerFactory(paramAppInterface.getAccount()).createEntityManager();
    if ((PublicAccountInfo)paramAppInterface.a(PublicAccountInfo.class, paramString) != null)
    {
      paramAppInterface.a();
      return true;
    }
    paramString = (AccountDetail)paramAppInterface.a(AccountDetail.class, paramString);
    paramAppInterface.a();
    try
    {
      paramAppInterface = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
      paramAppInterface.mergeFrom(paramString.accountData);
      int i = paramAppInterface.follow_type.get();
      if (i == 1) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (Exception paramAppInterface) {}
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = false;
    int i = a(paramQQAppInterface, paramString);
    if ((i == -3) || (i == -4)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool = false;
    if (bhvh.e(paramQQAppInterface)) {
      if ((paramInt == -2000) || (paramInt == -1000)) {
        bool = true;
      }
    }
    while ((!b(paramQQAppInterface, paramString)) && (paramInt != -2000) && (paramInt != -1000)) {
      return bool;
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    return ("3046055438".equals(paramString)) || ("3026775809".equals(paramString)) || ("2711679534".equals(paramString));
  }
  
  public static boolean a(String paramString1, int paramInt, String paramString2)
  {
    if (paramInt == 0) {}
    do
    {
      return false;
      paramString1 = Uri.parse(paramString1);
    } while ((paramString1 == null) || (TextUtils.isEmpty(paramString1.getHost())) || ((!"article.mp.qq.com".equalsIgnoreCase(paramString1.getHost())) && (!"post.mp.qq.com".equalsIgnoreCase(paramString1.getHost()))));
    ThreadManager.post(new PublicAccountUtil.14(paramString1, paramInt, paramString2), 5, null, false);
    return true;
  }
  
  public static boolean a(byte[] paramArrayOfByte, oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse, mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse1)
  {
    if (paramGetPublicAccountDetailInfoResponse == null) {
      return false;
    }
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    Object localObject2;
    ArrayList localArrayList;
    oidb_cmd0xcf8.ConfigInfo localConfigInfo;
    mobileqq_mp.ConfigInfo localConfigInfo1;
    for (;;)
    {
      try
      {
        paramArrayOfByte = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom(paramArrayOfByte);
        int i = -1;
        if (paramArrayOfByte.uint32_result.has())
        {
          int j = paramArrayOfByte.uint32_result.get();
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.i("PublicAccountUtil", 2, "handle OidbSvc.0xcf8|OIDBSSOPke.result=" + j);
            i = j;
          }
        }
        if ((i == 0) && (paramArrayOfByte.bytes_bodybuffer.has()) && (paramArrayOfByte.bytes_bodybuffer.get() != null))
        {
          paramGetPublicAccountDetailInfoResponse.mergeFrom(paramArrayOfByte.bytes_bodybuffer.get().toByteArray());
          if (paramGetPublicAccountDetailInfoResponse.ret_info.has())
          {
            paramArrayOfByte = new mobileqq_mp.RetInfo();
            paramArrayOfByte.ret_code.set(((oidb_cmd0xcf8.RetInfo)paramGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.get());
            paramArrayOfByte.err_info.set(((oidb_cmd0xcf8.RetInfo)paramGetPublicAccountDetailInfoResponse.ret_info.get()).err_info.get());
            paramGetPublicAccountDetailInfoResponse1.ret_info.set(paramArrayOfByte);
          }
          paramGetPublicAccountDetailInfoResponse1.seqno.set(paramGetPublicAccountDetailInfoResponse.seqno.get());
          paramGetPublicAccountDetailInfoResponse1.uin.set((int)paramGetPublicAccountDetailInfoResponse.luin.get());
          paramGetPublicAccountDetailInfoResponse1.name.set(paramGetPublicAccountDetailInfoResponse.name.get());
          paramGetPublicAccountDetailInfoResponse1.display_number.set(paramGetPublicAccountDetailInfoResponse.display_number.get());
          paramGetPublicAccountDetailInfoResponse1.summary.set(paramGetPublicAccountDetailInfoResponse.summary.get());
          paramGetPublicAccountDetailInfoResponse1.is_recv_msg.set(paramGetPublicAccountDetailInfoResponse.is_recv_msg.get());
          paramGetPublicAccountDetailInfoResponse1.is_recv_push.set(paramGetPublicAccountDetailInfoResponse.is_recv_push.get());
          paramGetPublicAccountDetailInfoResponse1.certified_grade.set(paramGetPublicAccountDetailInfoResponse.certified_grade.get());
          if (!paramGetPublicAccountDetailInfoResponse.config_group_info.has()) {
            break label660;
          }
          paramArrayOfByte = new ArrayList();
          localObject1 = paramGetPublicAccountDetailInfoResponse.config_group_info.get().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (oidb_cmd0xcf8.ConfigGroupInfo)((Iterator)localObject1).next();
          localArrayList = new ArrayList();
          localObject2 = ((oidb_cmd0xcf8.ConfigGroupInfo)localObject2).config_info.get().iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localConfigInfo = (oidb_cmd0xcf8.ConfigInfo)((Iterator)localObject2).next();
            localConfigInfo1 = new mobileqq_mp.ConfigInfo();
            localConfigInfo1.type.set(localConfigInfo.type.get());
            localConfigInfo1.title.set(localConfigInfo.title.get());
            localConfigInfo1.content.set(localConfigInfo.content.get());
            localConfigInfo1.event_id.set(localConfigInfo.event_id.get());
            localConfigInfo1.url.set(localConfigInfo.url.get());
            localConfigInfo1.auth_type.set(localConfigInfo.auth_type.get());
            localConfigInfo1.state.set(localConfigInfo.state.get());
            localConfigInfo1.confirm_flag.set(localConfigInfo.confirm_flag.get());
            localConfigInfo1.confirm_tips.set(localConfigInfo.confirm_tips.get());
            localConfigInfo1.state_id.set(localConfigInfo.state_id.get());
            localArrayList.add(localConfigInfo1);
            continue;
          }
        }
        else
        {
          return false;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.w("PublicAccountUtil", 4, paramArrayOfByte.getMessage(), paramArrayOfByte);
        return false;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.w("PublicAccountUtil", 4, paramArrayOfByte.getMessage(), paramArrayOfByte);
        return false;
      }
      localObject2 = new mobileqq_mp.ConfigGroupInfo();
      ((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.set(localArrayList);
      paramArrayOfByte.add(localObject2);
    }
    paramGetPublicAccountDetailInfoResponse1.config_group_info.set(paramArrayOfByte);
    label660:
    paramGetPublicAccountDetailInfoResponse1.is_show_share_button.set(paramGetPublicAccountDetailInfoResponse.is_show_share_button.get());
    paramGetPublicAccountDetailInfoResponse1.is_show_follow_button.set(paramGetPublicAccountDetailInfoResponse.is_show_follow_button.get());
    paramGetPublicAccountDetailInfoResponse1.follow_type.set(paramGetPublicAccountDetailInfoResponse.follow_type.get());
    paramGetPublicAccountDetailInfoResponse1.is_sync_lbs.set(paramGetPublicAccountDetailInfoResponse.is_sync_lbs.get());
    paramGetPublicAccountDetailInfoResponse1.group_id.set(paramGetPublicAccountDetailInfoResponse.group_id.get());
    paramGetPublicAccountDetailInfoResponse1.show_flag.set(paramGetPublicAccountDetailInfoResponse.show_flag.get());
    paramGetPublicAccountDetailInfoResponse1.account_flag.set(paramGetPublicAccountDetailInfoResponse.account_flag.get());
    paramGetPublicAccountDetailInfoResponse1.luin.set(paramGetPublicAccountDetailInfoResponse.luin.get());
    paramGetPublicAccountDetailInfoResponse1.config_background_color.set(paramGetPublicAccountDetailInfoResponse.config_background_color.get());
    paramGetPublicAccountDetailInfoResponse1.config_background_img.set(paramGetPublicAccountDetailInfoResponse.config_background_img.get());
    if (paramGetPublicAccountDetailInfoResponse.config_group_info_new.has())
    {
      paramArrayOfByte = new ArrayList();
      localObject1 = paramGetPublicAccountDetailInfoResponse.config_group_info_new.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (oidb_cmd0xcf8.ConfigGroupInfo)((Iterator)localObject1).next();
        localArrayList = new ArrayList();
        localObject2 = ((oidb_cmd0xcf8.ConfigGroupInfo)localObject2).config_info.get().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localConfigInfo = (oidb_cmd0xcf8.ConfigInfo)((Iterator)localObject2).next();
          localConfigInfo1 = new mobileqq_mp.ConfigInfo();
          localConfigInfo1.type.set(localConfigInfo.type.get());
          localConfigInfo1.title.set(localConfigInfo.title.get());
          localConfigInfo1.content.set(localConfigInfo.content.get());
          localConfigInfo1.event_id.set(localConfigInfo.event_id.get());
          localConfigInfo1.url.set(localConfigInfo.url.get());
          localConfigInfo1.auth_type.set(localConfigInfo.auth_type.get());
          localConfigInfo1.state.set(localConfigInfo.state.get());
          localConfigInfo1.confirm_flag.set(localConfigInfo.confirm_flag.get());
          localConfigInfo1.confirm_tips.set(localConfigInfo.confirm_tips.get());
          localConfigInfo1.state_id.set(localConfigInfo.state_id.get());
          localArrayList.add(localConfigInfo1);
        }
        localObject2 = new mobileqq_mp.ConfigGroupInfo();
        ((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.set(localArrayList);
        paramArrayOfByte.add(localObject2);
      }
      paramGetPublicAccountDetailInfoResponse1.config_group_info_new.set(paramArrayOfByte);
    }
    paramGetPublicAccountDetailInfoResponse1.certified_description.set(paramGetPublicAccountDetailInfoResponse.certified_description.get());
    paramGetPublicAccountDetailInfoResponse1.unified_account_descrpition.set(paramGetPublicAccountDetailInfoResponse.unified_account_descrpition.get());
    paramGetPublicAccountDetailInfoResponse1.account_flag2.set(paramGetPublicAccountDetailInfoResponse.account_flag2.get());
    return true;
  }
  
  public static int b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (akdi)paramQQAppInterface.getManager(56);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b(paramString);
      if (paramQQAppInterface != null)
      {
        if (paramQQAppInterface.extendType == 2) {
          return 1024;
        }
        return 1008;
      }
    }
    return 1008;
  }
  
  public static int b(String paramString)
  {
    int i = 0;
    int k = 0;
    Object localObject1 = ahnn.a().a;
    if (localObject1 == null) {}
    int j;
    do
    {
      return k;
      localObject1 = new ArrayList((Collection)localObject1);
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        RecentUserBaseData localRecentUserBaseData = (RecentUserBaseData)((Iterator)localObject2).next();
        if ((localRecentUserBaseData == null) || (localRecentUserBaseData.mUser == null)) {
          ((Iterator)localObject2).remove();
        } else if ((localRecentUserBaseData.mUser.getType() == 1008) && (sbc.b((QQAppInterface)onk.a(), localRecentUserBaseData.mUser.uin))) {
          ((Iterator)localObject2).remove();
        }
      }
      j = 0;
      k = i;
    } while (j >= ((List)localObject1).size());
    Object localObject2 = (RecentUserBaseData)((List)localObject1).get(j);
    if (((RecentUserBaseData)localObject2).mUser.getType() == 1008)
    {
      k = i;
      if (!TextUtils.equals(((RecentUserBaseData)localObject2).mUser.uin, paramString))
      {
        if (!TextUtils.equals(((RecentUserBaseData)localObject2).mUser.uin, ajsf.C)) {
          break label215;
        }
        k = i;
      }
    }
    for (;;)
    {
      j += 1;
      i = k;
      break;
      label215:
      k = i;
      if (((RecentUserBaseData)localObject2).b() > 0) {
        k = i + ((RecentUserBaseData)localObject2).b();
      }
    }
  }
  
  private static MessageForStructing b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    MessageForStructing localMessageForStructing = (MessageForStructing)axaq.a(-2011);
    localMessageForStructing.structingMsg = axuy.a();
    localMessageForStructing.structingMsg.mMsgServiceID = 142;
    localMessageForStructing.selfuin = paramQQAppInterface.c();
    localMessageForStructing.frienduin = ajsf.az;
    localMessageForStructing.senderuin = ajsf.az;
    localMessageForStructing.istroop = 1008;
    localMessageForStructing.issend = 1;
    localMessageForStructing.isread = true;
    if (!TextUtils.isEmpty(paramString1))
    {
      localMessageForStructing.structingMsg.mMsgBrief = paramString1;
      localMessageForStructing.doPrewrite();
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localMessageForStructing.structingMsg.mArticleIds = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localMessageForStructing.structingMsg.mOrangeWord = paramString3;
    }
    if (!TextUtils.isEmpty(paramString4)) {}
    try
    {
      localMessageForStructing.time = Long.parseLong(paramString4);
      localMessageForStructing.extInt = 0;
      localMessageForStructing.extLong = 0;
      return localMessageForStructing;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  private static MessageForStructing b(MessageForStructing paramMessageForStructing, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramMessageForStructing == null) || (!(paramMessageForStructing instanceof MessageForStructing)) || (!paramMessageForStructing.isread)) {
      return null;
    }
    MessageForStructing localMessageForStructing = (MessageForStructing)axaq.a(paramMessageForStructing.msgtype);
    localMessageForStructing.copyStructingMsg(paramMessageForStructing);
    localMessageForStructing.issend = 1;
    localMessageForStructing.isread = true;
    if (!TextUtils.isEmpty(paramString1))
    {
      localMessageForStructing.structingMsg.mMsgBrief = paramString1;
      localMessageForStructing.doPrewrite();
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localMessageForStructing.structingMsg.mArticleIds = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localMessageForStructing.structingMsg.mOrangeWord = paramString3;
    }
    if (!TextUtils.isEmpty(paramString4)) {}
    try
    {
      localMessageForStructing.time = Long.parseLong(paramString4);
      localMessageForStructing.extInt = 0;
      localMessageForStructing.extLong = 0;
      return localMessageForStructing;
    }
    catch (Exception paramMessageForStructing)
    {
      for (;;)
      {
        paramMessageForStructing.printStackTrace();
      }
    }
  }
  
  public static String b()
  {
    String str1 = akug.b();
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localObject1 = onk.f();
        localObject2 = bbct.d(BaseApplication.getContext());
        if (localObject1 == null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        String str2;
        int i;
        localException.printStackTrace();
        continue;
      }
      localJSONObject.put("adcode", str1);
      localJSONObject.put("deviceCode", localObject1);
      localJSONObject.put("macAddress", localObject2);
      str2 = bbct.f();
      if ((!TextUtils.isEmpty(str2)) && (str2.length() == 16)) {
        localJSONObject.put("android_id", str2);
      }
      osq.a(localJSONObject);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountUtil", 2, "constructAttributeL,adCode:" + str1 + ",deviceID:" + (String)localObject1 + ",macAddress:" + (String)localObject2 + ",androidID : " + str2);
      }
      localObject1 = localJSONObject.toString().getBytes();
      Object localObject2 = new byte[localObject1.length];
      i = 0;
      if (i < localObject1.length)
      {
        localObject2[i] = ((byte)(localObject1[i] ^ 0xB6));
        i += 1;
        continue;
        localObject1 = "";
        break label225;
        localObject2 = "";
      }
      else
      {
        return bbca.encodeToString((byte[])localObject2, 2);
      }
      label225:
      if (localObject2 == null) {}
    }
  }
  
  public static String b(QQAppInterface paramQQAppInterface, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return "";
    }
    paramQQAppInterface = new StringBuilder();
    if ((paramBaseArticleInfo.mFeedType != 17) && (paramBaseArticleInfo.mFeedType != 16) && (paramBaseArticleInfo.mFeedType != 19)) {
      if (paramBaseArticleInfo.mFeedType != 18) {}
    }
    label311:
    for (;;)
    {
      return paramQQAppInterface.toString();
      if ((paramBaseArticleInfo.mFeedType == 4) || (paramBaseArticleInfo.mFeedType == 5))
      {
        if (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountUtil", 2, "articleInfo.mTitle is null");
          }
        }
        else
        {
          paramBaseArticleInfo = ReadInJoyUserInfoModule.a(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl.a, null);
          if (paramBaseArticleInfo != null) {}
          for (paramBaseArticleInfo = paramBaseArticleInfo.nick;; paramBaseArticleInfo = ReadInJoyUserInfoModule.a())
          {
            paramQQAppInterface.append(paramBaseArticleInfo);
            break;
          }
        }
      }
      else
      {
        if (rap.f((ArticleInfo)paramBaseArticleInfo))
        {
          paramBaseArticleInfo = ReadInJoyUserInfoModule.a(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl.a, null);
          if (paramBaseArticleInfo != null) {}
          for (paramBaseArticleInfo = paramBaseArticleInfo.nick;; paramBaseArticleInfo = ReadInJoyUserInfoModule.a())
          {
            paramQQAppInterface.append(paramBaseArticleInfo).append(" Biu了");
            break;
          }
        }
        if (paramBaseArticleInfo.mFeedType == 28)
        {
          paramQQAppInterface = new StringBuilder(ajyc.a(2131708757));
          if (paramBaseArticleInfo.hotWordInfo.a == null) {
            break label311;
          }
          int i = 0;
          while (i < paramBaseArticleInfo.hotWordInfo.a.size())
          {
            paramQQAppInterface.append(i + 1).append(".").append(((qbg)paramBaseArticleInfo.hotWordInfo.a.get(i)).jdField_a_of_type_JavaLangString).append("  ");
            i += 1;
          }
          continue;
        }
        paramQQAppInterface.append(paramBaseArticleInfo.mSubscribeName);
      }
    }
  }
  
  public static String b(String paramString)
  {
    String str = "biz_src_gzh";
    if ("2105640434".equals(paramString)) {
      str = "biz_src_gzh_bodong";
    }
    do
    {
      return str;
      if ("2747277822".equals(paramString)) {
        return "biz_src_gzh_games";
      }
      if ("2080578142".equals(paramString)) {
        return "biz_src_gwh";
      }
      if ("3046055438".equals(paramString)) {
        return "biz_src_gzh_qqgw";
      }
      if ("2993250418".equals(paramString)) {
        return "biz_src_gzh_qqmusic";
      }
      if ("2909288299".equals(paramString)) {
        return "biz_src_gzh_news";
      }
      if ("2711679534".equals(paramString)) {
        return "biz_src_gzh_qianbao";
      }
      if ("2632129500".equals(paramString)) {
        return "biz_src_gzh_chwl";
      }
      if ("1816533856".equals(paramString)) {
        return "biz_src_gzh_qqzb";
      }
      if ("3288261892".equals(paramString)) {
        return "biz_src_gzh_ketang";
      }
      if ("3383393803".equals(paramString)) {
        return "biz_src_gzh_fudao";
      }
      if ("3026775809".equals(paramString)) {
        return "biz_src_gzh_sport";
      }
    } while (!"2658655094".equals(paramString));
    return "biz_src_gzh_weather";
  }
  
  public static void b()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_Int = -1;
      return;
    }
  }
  
  public static void b(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    d(paramActivity, paramQQAppInterface, paramProfileParams);
    paramActivity.finish();
  }
  
  private static void b(Intent paramIntent, Context paramContext, String paramString)
  {
    if (paramIntent == null) {
      paramIntent = new Intent(paramContext, QidianProfileCardActivity.class);
    }
    for (;;)
    {
      paramIntent.putExtra("AllInOne", new ProfileActivity.AllInOne(paramString, 104));
      paramIntent.putExtra("uin", paramString);
      paramContext.startActivity(paramIntent);
      return;
      paramIntent.setClassName(paramContext, QidianProfileCardActivity.class.getName());
    }
  }
  
  private static void b(AppInterface paramAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "sendDetailInfoRequest");
    }
    NewIntent localNewIntent = new NewIntent(paramContext, nou.class);
    localNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.2.8,3,4440");
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.version.set(1);
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(paramString));
      label90:
      localNewIntent.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      localNewIntent.setObserver(new sgv(paramContext, paramAppInterface, paramInt, paramString));
      paramAppInterface.startServlet(localNewIntent);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountUtil", 2, "sendDetailInfoRequest exit");
      }
      return;
    }
    catch (Exception localException)
    {
      break label90;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {}
    label40:
    label301:
    label307:
    for (;;)
    {
      return;
      int i = paramString.indexOf("?");
      if (i != -1)
      {
        paramString = paramString.substring(i + 1).split("&");
        i = 0;
        if (i < paramString.length) {
          if (!paramString[i].startsWith("url=")) {}
        }
        for (paramString = URLDecoder.decode(paramString[i].split("=")[1]);; paramString = "")
        {
          if (TextUtils.isEmpty(paramString)) {
            break label307;
          }
          i = paramString.indexOf("?");
          if (i == -1) {
            break;
          }
          paramString = paramString.substring(i + 1).split("&");
          paramQQAppInterface.getCurrentAccountUin();
          i = 0;
          label114:
          if (i < paramString.length) {
            if (!paramString[i].startsWith("mailid=")) {}
          }
          for (paramString = paramString[i].split("=")[1];; paramString = "")
          {
            if (TextUtils.isEmpty(paramString)) {
              break label301;
            }
            paramQQAppInterface = String.format("https://w.mail.qq.com/cgi-bin/login?mailid=%1$s&target=mobileqqdel&fwd=mq&uin=%2$s&fun=from3g", new Object[] { paramString, paramQQAppInterface.getCurrentAccountUin() });
            try
            {
              paramQQAppInterface = HttpBaseUtil.a(paramQQAppInterface, "GET", new Bundle(), null).a;
              i = j;
              if (paramQQAppInterface.getStatusLine().getStatusCode() == 200)
              {
                paramQQAppInterface = new JSONObject(HttpBaseUtil.a(paramQQAppInterface));
                i = j;
                if (paramQQAppInterface.has("ret"))
                {
                  int k = paramQQAppInterface.getInt("ret");
                  i = j;
                  if (k == 0) {
                    i = 1;
                  }
                }
              }
            }
            catch (Exception paramQQAppInterface)
            {
              for (;;)
              {
                i = j;
              }
            }
            if (i != 0) {
              break;
            }
            ThreadManager.getUIHandler().post(new PublicAccountUtil.2(paramContext));
            return;
            i += 1;
            break label40;
            i += 1;
            break label114;
          }
          break;
        }
      }
    }
  }
  
  public static void b(String paramString)
  {
    ThreadManager.executeOnSubThread(new PublicAccountUtil.22(paramString));
  }
  
  public static void b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountUtil", 2, "doVideoPlayRealtimeReport aid=" + paramString1 + ", vid=" + paramString2 + ", rtype=" + paramInt1 + ", rcode=" + paramInt2);
    }
    ThreadManager.post(new PublicAccountUtil.19(paramString2, paramString1, paramInt1, paramInt2), 5, null, true);
  }
  
  public static boolean b()
  {
    if ((BaseActivity.sTopActivity == null) || (!(BaseActivity.sTopActivity instanceof SplashActivity))) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return false;
          localObject = FrameHelperActivity.a(BaseActivity.sTopActivity);
        } while (localObject == null);
        localObject = (Conversation)((FrameHelperActivity)localObject).a(Conversation.class);
      } while (localObject == null);
      localObject = ((Conversation)localObject).a();
    } while (localObject == null);
    if (((thy)localObject).getMode() != 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("mobileQQ", 0);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int == -1) {
        jdField_a_of_type_Int = localSharedPreferences.getInt(jdField_a_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin(), 0);
      }
      if (jdField_a_of_type_Int != 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    return a(paramQQAppInterface, paramString) == -2;
  }
  
  public static boolean b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getHost();
        if ((paramString != null) && (("article.mp.qq.com".equalsIgnoreCase(paramString)) || ("post.mp.qq.com".equalsIgnoreCase(paramString)))) {
          return true;
        }
      }
    }
    return false;
  }
  
  protected static final void c(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    if (jdField_a_of_type_Bbgg != null)
    {
      jdField_a_of_type_Bbgg.dismiss();
      jdField_a_of_type_Bbgg = null;
    }
    paramQQAppInterface = new sgm(paramActivity, paramProfileParams, paramQQAppInterface);
    paramProfileParams = new sgn(paramActivity, paramProfileParams);
    jdField_a_of_type_Bbgg = bbcv.a(paramActivity, 230);
    jdField_a_of_type_Bbgg.setMessage(2131695561);
    jdField_a_of_type_Bbgg.setTitle(2131692234);
    jdField_a_of_type_Bbgg.setNegativeButton(2131690596, paramQQAppInterface);
    jdField_a_of_type_Bbgg.setPositiveButton(2131719420, paramQQAppInterface);
    jdField_a_of_type_Bbgg.setOnCancelListener(paramProfileParams);
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {}
    try
    {
      jdField_a_of_type_Bbgg.show();
      return;
    }
    catch (Exception paramActivity) {}
    jdField_a_of_type_Bbgg.dismiss();
    jdField_a_of_type_Bbgg = null;
    return;
  }
  
  public static void c(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)onk.a();
    if (localQQAppInterface == null) {}
    MessageRecord localMessageRecord;
    String str;
    do
    {
      do
      {
        return;
        localMessageRecord = localQQAppInterface.a().b(paramString, 1008);
      } while ((localMessageRecord == null) || (localMessageRecord.isread));
      str = localMessageRecord.getExtInfoFromExtStr("has_report");
    } while ((!TextUtils.isEmpty(str)) && ("1".equals(str)));
    localMessageRecord.saveExtInfoToExtStr("has_report", "1");
    localQQAppInterface.a().a(localMessageRecord.frienduin, 1008, localMessageRecord.uniseq, "extStr", localMessageRecord.extStr);
    noo.a(null, "CliOper", "", "", "0X8009A7C", "0X8009A7C", 0, 0, paramString, "", "", "", false);
  }
  
  public static boolean c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null) {
        return d(paramString.getHost());
      }
    }
    return false;
  }
  
  public static void d(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    if (a(paramActivity, paramProfileParams)) {
      return;
    }
    Intent localIntent = new Intent(paramActivity, AccountDetailActivity.class);
    localIntent.addFlags(268435456);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("profile_params", paramProfileParams);
    localBundle.putString("pkg_name", paramActivity.getIntent().getStringExtra("pkg_name"));
    localIntent.putExtras(localBundle);
    a(paramActivity, paramQQAppInterface, paramProfileParams.b(), paramProfileParams.a(), localIntent);
  }
  
  public static boolean d(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (("article.mp.qq.com".equalsIgnoreCase(paramString)) || ("post.mp.qq.com".equalsIgnoreCase(paramString)) || ("kandian.qq.com".equalsIgnoreCase(paramString)) || ("sqimg.qq.com".equalsIgnoreCase(paramString)));
  }
  
  public static boolean e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getHost();
        if ((paramString != null) && (("kandian.qq.com".equalsIgnoreCase(paramString)) || ("post.mp.qq.com".equalsIgnoreCase(paramString)) || ("act.kandian.qq.com".equalsIgnoreCase(paramString)) || ("node.kandian.qq.com".equalsIgnoreCase(paramString)))) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sgj
 * JD-Core Version:    0.7.0.1
 */