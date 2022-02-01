import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils.1;
import com.tencent.biz.pubaccount.PublicAccountReportUtils.2;
import com.tencent.biz.pubaccount.PublicAccountReportUtils.3;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class ocd
{
  public static int a(QQAppInterface paramQQAppInterface, String paramString, AccountDetail paramAccountDetail)
  {
    if ((paramQQAppInterface == null) && (paramAccountDetail == null)) {}
    Object localObject;
    do
    {
      return 1;
      localObject = paramAccountDetail;
      if (paramAccountDetail == null)
      {
        paramQQAppInterface = (aody)paramQQAppInterface.getManager(56);
        localObject = paramAccountDetail;
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.a(paramString);
          localObject = paramQQAppInterface;
          if (QLog.isColorLevel())
          {
            QLog.d("PublicAccountReportUtils", 2, "getReportAccountType--> input accountdetail null");
            localObject = paramQQAppInterface;
          }
        }
      }
    } while (localObject == null);
    int i;
    if (((AccountDetail)localObject).accountFlag < 0)
    {
      i = -9;
      switch (i)
      {
      case -8: 
      case -7: 
      default: 
        i = 1;
      }
    }
    for (;;)
    {
      return i;
      i = tzq.a(((AccountDetail)localObject).accountFlag);
      break;
      i = 3;
      continue;
      i = 4;
      if (tzq.a(((AccountDetail)localObject).accountFlag2) == -8L)
      {
        i = 8;
        continue;
        i = 5;
        continue;
        i = 6;
        continue;
        i = 7;
        continue;
        i = 9;
      }
    }
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      try
      {
        String str = URLEncoder.encode(paramString, "UTF-8");
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        return paramString;
      }
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo)
  {
    Object localObject1 = "";
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("folder_status", ozs.d);
      ((JSONObject)localObject2).put("feeds_source", ozs.d(paramArticleInfo));
      ((JSONObject)localObject2).put("rowkey", paramArticleInfo.innerUniqueID);
      ((JSONObject)localObject2).put("feeds_type", "" + ozs.a(paramArticleInfo));
      ((JSONObject)localObject2).put("kandian_mode", "" + ozs.e());
      ((JSONObject)localObject2).put("tab_source", "" + ozs.d());
      ((JSONObject)localObject2).put("topic_id", "" + paramArticleInfo.businessId);
      ((JSONObject)localObject2).put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
      ((JSONObject)localObject2).put("mark_type", "" + ozs.a(paramArticleInfo));
      ((JSONObject)localObject2).put("channel_id", paramArticleInfo.mChannelID);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject2;
        String str2;
        localJSONException.printStackTrace();
        continue;
        String str1 = paramArticleInfo.mArticleID + "";
      }
    }
    if ((sel.g(paramArticleInfo)) || (sel.i(paramArticleInfo)) || (sel.j(paramArticleInfo)) || (sel.k(paramArticleInfo)))
    {
      localObject2 = "0";
      str2 = "0X8008201";
      if (ubg.a(paramArticleInfo.mChannelID)) {
        str2 = "0X8009362";
      }
      a(null, ozs.d(paramArticleInfo), str2, str2, 0, 0, String.valueOf(paramArticleInfo.mFeedId), (String)localObject2, "" + paramArticleInfo.mStrategyId, (String)localObject1, false);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    int i = a(paramQQAppInterface, String.valueOf(paramString), null);
    if ((i != 2) && (tzq.a(paramQQAppInterface, paramString) != -7)) {
      a(null, paramString, "0X800827B", "0X800827B", 0, 0, "" + paramInt, "" + i, "", "", false);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    b(paramString3, paramString7);
    paramString7 = b(paramString7);
    paramString4 = a(paramString4);
    paramString5 = a(paramString5);
    paramString6 = a(paramString6);
    paramString7 = a(paramString7);
    bdll.b(paramQQAppInterface, "dc01160", "Pb_account_lifeservice", paramString1, paramString2.toUpperCase(), paramString3.toUpperCase(), paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    b(paramString3, paramString7);
    paramString7 = b(paramString7);
    if (paramBoolean)
    {
      a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7);
      return;
    }
    bdll.b(paramQQAppInterface, "dc01160", "Pb_account_lifeservice", paramString1, paramString2.toUpperCase(), paramString3.toUpperCase(), paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    b(paramString5, paramString9);
    paramString9 = b(paramString9);
    paramString6 = a(paramString6);
    paramString7 = a(paramString7);
    paramString8 = a(paramString8);
    paramString9 = a(paramString9);
    bdll.b(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    bdll.b(paramQQAppInterface, "dc01160", "Pb_account_lifeservice", paramString3, paramString4.toUpperCase(), paramString5.toUpperCase(), paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean)
  {
    b(paramString5, paramString9);
    paramString9 = b(paramString9);
    if (paramBoolean)
    {
      a(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
      return;
    }
    bdll.b(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    bdll.b(paramQQAppInterface, "dc01160", "Pb_account_lifeservice", paramString3, paramString4.toUpperCase(), paramString5.toUpperCase(), paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = null;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    a(localQQAppInterface, "", paramString1, paramString1, 0, 0, "", "", "", paramString2, false);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramString1 = "kandian_" + paramString1;
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    HashMap localHashMap = new HashMap();
    localHashMap.put("department", "publicaccount");
    localHashMap.put("fromuin", str);
    localHashMap.put("touin", paramString2);
    localHashMap.put("d1", paramString3);
    localHashMap.put("d2", paramString4);
    localHashMap.put("d3", paramString5);
    localHashMap.put("d4", paramString6);
    bdmc.a(BaseApplication.getContext()).a(str, paramString1, true, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.d("reportPAinfoToLighthouse", 2, new Object[] { "reportPAinfoToLighthouse-->", "kandianT" + paramString1 + ", fromuin:" + str + ", touin:" + paramString2 + ", d1:" + paramString3 + ", d2:" + paramString4 + ", d3:" + paramString5 + ", d4:" + paramString6 });
    }
  }
  
  public static void a(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      long l = System.currentTimeMillis() / 1000L;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if (localMessageRecord.istroop == 1008) {
          if ((!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("public_account_send_flag"))) && (!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("public_account_msg_id"))) && (!TextUtils.equals(localMessageRecord.frienduin, localMessageRecord.selfuin))) {
            ThreadManager.post(new PublicAccountReportUtils.3(localMessageRecord.frienduin, localMessageRecord.selfuin, localMessageRecord.getExtInfoFromExtStr("public_account_msg_id"), localMessageRecord.time, l, localMessageRecord.getExtInfoFromExtStr("public_account_send_flag")), 5, null, false);
          } else if (QLog.isColorLevel()) {
            QLog.d("PublicAccountReportUtils", 2, "reportPubAccMsg exception, public_account_send_flag null || public_account_msg_id null || ");
          }
        }
      }
    }
  }
  
  private static void a(JSONObject paramJSONObject)
  {
    try
    {
      if (bihq.a() == 1) {}
      for (String str = "1";; str = "0")
      {
        paramJSONObject.put("is_kind_card", str);
        return;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("PublicAccountReportUtils", 1, "addKingCard error! msg=" + paramJSONObject);
    }
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      ((JSONObject)localObject).put("version_standard", "8.4.5");
      ((JSONObject)localObject).put("os_standard", "1");
      ((JSONObject)localObject).put("user_mode", ozs.n());
      if (uaf.a.a()) {}
      for (int i = 1;; i = 0)
      {
        ((JSONObject)localObject).put("is_black_white_mode", i);
        b((JSONObject)localObject);
        a((JSONObject)localObject);
        localObject = ((JSONObject)localObject).toString();
        return localObject;
      }
      return paramString;
    }
    catch (Exception localException)
    {
      QLog.e("PublicAccountReportUtils", 1, "addExtraInfo error! msg=" + localException);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      c(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7, paramBoolean);
      return;
    }
    paramQQAppInterface = new Intent("READINJOY_VIDEO_DATA_REPORT_WITH_FANS_INFO");
    paramQQAppInterface.putExtra("VIDEO_REPORT_TOUIN", paramString1);
    paramQQAppInterface.putExtra("VIDEO_REPORT_SUBACTION", paramString2);
    paramQQAppInterface.putExtra("VIDEO_REPORT_ACTION_NAME", paramString3);
    paramQQAppInterface.putExtra("VIDEO_REPORT_FROM_TYPE", paramInt1);
    paramQQAppInterface.putExtra("VIDEO_REPORT_RESULT", paramInt2);
    paramQQAppInterface.putExtra("VIDEO_REPORT_R2", paramString4);
    paramQQAppInterface.putExtra("VIDEO_REPORT_R3", paramString5);
    paramQQAppInterface.putExtra("VIDEO_REPORT_R4", paramString6);
    paramQQAppInterface.putExtra("VIDEO_REPORT_R5", paramString7);
    paramQQAppInterface.putExtra("VIDEO_REPORT_SHOULD_ENCODE", paramBoolean);
    BaseApplicationImpl.getApplication().sendBroadcast(paramQQAppInterface);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if ("0X8007625".equals(paramString1)) {
      ThreadManager.executeOnSubThread(new PublicAccountReportUtils.2(paramString2));
    }
  }
  
  private static void b(JSONObject paramJSONObject) {}
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    ThreadManager.post(new PublicAccountReportUtils.1(paramString7, paramString1, paramQQAppInterface, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramBoolean), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ocd
 * JD-Core Version:    0.7.0.1
 */