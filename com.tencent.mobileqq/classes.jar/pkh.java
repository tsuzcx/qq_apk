import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class pkh
{
  public static int a;
  public static String a;
  public static HashMap<Integer, oqu> a;
  public static volatile boolean a;
  
  static
  {
    jdField_a_of_type_Int = -2;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a()
  {
    return pqu.a();
  }
  
  public static int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramInt2 != 0))
    {
      if (paramInt1 + 1 == paramInt2) {
        return 1;
      }
      return 0;
    }
    return -1;
  }
  
  public static int a(Context paramContext)
  {
    int j = NetworkUtil.getSystemNetwork(paramContext);
    int i;
    if (j >= 1)
    {
      i = j;
      if (j <= 4) {}
    }
    else
    {
      i = 5;
    }
    return i;
  }
  
  public static long a()
  {
    return pnn.a();
  }
  
  public static Drawable a(QQAppInterface paramQQAppInterface, Drawable paramDrawable)
  {
    return pqf.a(paramQQAppInterface, paramDrawable);
  }
  
  public static JumpMode a(Context paramContext, String paramString)
  {
    return pqx.a(paramContext, paramString, null);
  }
  
  public static ArticleInfo a(String paramString)
  {
    return pqv.a(paramString);
  }
  
  public static String a()
  {
    return pnn.a();
  }
  
  public static String a(int paramInt)
  {
    return BaseApplication.getContext().getResources().getString(paramInt);
  }
  
  public static String a(String paramString)
  {
    return pqu.a(paramString);
  }
  
  public static AppRuntime a()
  {
    return pnn.a();
  }
  
  public static void a() {}
  
  public static void a(float paramFloat, Resources paramResources)
  {
    pnk.a(paramFloat, paramResources);
  }
  
  public static void a(int paramInt)
  {
    pqf.jdField_a_of_type_Int = paramInt;
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    pqb.a(paramInt1, paramString1, paramString2, paramString3, paramString4, paramInt2);
  }
  
  public static void a(int paramInt, List<TopicInfo> paramList, String paramString)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TopicInfo localTopicInfo = (TopicInfo)paramList.next();
        if (localTopicInfo != null) {
          a("0X8009817", paramInt, localTopicInfo.a(), paramString);
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    pqx.a(paramActivity, paramArticleInfo);
  }
  
  public static void a(Context paramContext, tou paramtou)
  {
    if (paramContext == null)
    {
      QLog.d("ReadInJoyUtils", 1, "showErrorDialog! context is null!");
      return;
    }
    paramContext = new tos(paramContext);
    paramContext.a(paramtou);
    paramContext.show();
  }
  
  public static void a(KandianRedDotInfo paramKandianRedDotInfo)
  {
    prq.a(paramKandianRedDotInfo);
  }
  
  public static void a(QQMessageFacade paramQQMessageFacade, MessageRecord paramMessageRecord, Intent paramIntent)
  {
    prq.a(paramQQMessageFacade, paramMessageRecord, paramIntent);
  }
  
  public static void a(BaseActivity paramBaseActivity)
  {
    pqu.a(paramBaseActivity);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    pqu.a(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    pqc.a(paramQQAppInterface, paramRedTypeInfo);
  }
  
  public static void a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    String str = "-1";
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString1)) {}
      try
      {
        olh.a(null, "", paramString1, paramString1, 0, 0, String.valueOf(paramLong), str, paramString2, "", false);
        return;
      }
      catch (Exception paramString1)
      {
        QLog.e("ReadInJoyUtils", 1, "reportSelectedTopic error:" + paramString1.toString());
      }
      str = "1";
      continue;
      str = "2";
      continue;
      str = "3";
    }
  }
  
  public static void a(String paramString, Object paramObject, boolean paramBoolean)
  {
    prd.a(paramString, paramObject, paramBoolean);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    pqe.a(paramAppRuntime, paramBoolean, paramString, paramInt, paramLong);
  }
  
  public static boolean a()
  {
    return pqu.d();
  }
  
  public static boolean a(Context paramContext)
  {
    return pqu.a(paramContext);
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    return pqw.m(paramArticleInfo);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return pqu.a(paramQQAppInterface);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    return prs.a(paramQQAppInterface, paramMessageRecord);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return prs.a(paramMessageRecord);
  }
  
  public static boolean a(AbsStructMsg paramAbsStructMsg)
  {
    return prr.a(paramAbsStructMsg);
  }
  
  public static boolean a(String paramString)
  {
    return TextUtils.equals(AppConstants.WEISHI_UIN, paramString);
  }
  
  public static boolean a(String paramString, long paramLong, ArticleInfo paramArticleInfo)
  {
    return pqw.a(paramString, paramLong, paramArticleInfo);
  }
  
  public static int b()
  {
    return prr.a();
  }
  
  public static JumpMode b(Context paramContext, String paramString)
  {
    return pqx.a(paramContext, paramString);
  }
  
  public static String b()
  {
    return pqu.b();
  }
  
  public static void b()
  {
    pqf.jdField_a_of_type_Int = -1;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    pqu.c(paramQQAppInterface);
  }
  
  public static boolean b()
  {
    return pip.a();
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return prr.c(paramQQAppInterface);
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    return prq.a(paramMessageRecord);
  }
  
  public static int c()
  {
    return prh.a();
  }
  
  public static String c()
  {
    return pqu.c();
  }
  
  public static void c() {}
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    pqu.c(paramQQAppInterface);
  }
  
  public static boolean c()
  {
    return (((Boolean)bmhv.a("preload_controller", Boolean.valueOf(true))).booleanValue()) && (bmhv.n());
  }
  
  public static boolean c(MessageRecord paramMessageRecord)
  {
    return prr.a(paramMessageRecord);
  }
  
  public static void d() {}
  
  public static boolean d()
  {
    return prs.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pkh
 * JD-Core Version:    0.7.0.1
 */