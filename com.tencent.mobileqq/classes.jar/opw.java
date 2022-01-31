import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.daily.DailyTipsFoldUtils.1;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class opw
{
  private static long jdField_a_of_type_Long = 2000L;
  private static Runnable jdField_a_of_type_JavaLangRunnable;
  private static boolean jdField_a_of_type_Boolean;
  
  public static void a()
  {
    QLog.i("DailyTipsFoldUtils", 2, "[init]");
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, ReadInJoyXListView paramReadInJoyXListView)
  {
    if ((paramBaseArticleInfo == null) || (!oox.c((int)paramBaseArticleInfo.mChannelID))) {
      QLog.i("DailyTipsFoldUtils", 1, "[foldDailyTips], articleInfo is null or not daily channel.");
    }
    do
    {
      do
      {
        return;
        if (paramReadInJoyXListView == null)
        {
          QLog.i("DailyTipsFoldUtils", 1, "[foldDailyTips], listView is null.");
          return;
        }
      } while (!a(paramBaseArticleInfo));
      jdField_a_of_type_JavaLangRunnable = new DailyTipsFoldUtils.1(paramReadInJoyXListView);
    } while (jdField_a_of_type_Boolean);
    paramBaseArticleInfo = Aladdin.getConfig(208);
    if (paramBaseArticleInfo != null)
    {
      jdField_a_of_type_Long = paramBaseArticleInfo.getIntegerFromString("delay_duration", 2000);
      QLog.i("DailyTipsFoldUtils", 2, "[foldDailyTips], delayFoldTime = " + jdField_a_of_type_Long);
    }
    paramReadInJoyXListView.postDelayed(jdField_a_of_type_JavaLangRunnable, jdField_a_of_type_Long);
  }
  
  public static void a(ReadInJoyXListView paramReadInJoyXListView, int paramInt)
  {
    if (paramReadInJoyXListView == null)
    {
      QLog.i("DailyTipsFoldUtils", 1, "[cancelFoldDailyTipsRunnable], listView is null.");
      return;
    }
    if (!oox.c(paramInt))
    {
      QLog.i("DailyTipsFoldUtils", 1, "[cancelFoldDailyTipsRunnable], is not daily feeds, channelID = " + paramInt);
      return;
    }
    if (jdField_a_of_type_JavaLangRunnable != null)
    {
      QLog.i("DailyTipsFoldUtils", 1, "[cancelFoldDailyTipsRunnable], removeCallbacks");
      paramReadInJoyXListView.removeCallbacks(jdField_a_of_type_JavaLangRunnable);
    }
    jdField_a_of_type_JavaLangRunnable = null;
  }
  
  private static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    if ((paramBaseArticleInfo == null) || (!oox.c((int)paramBaseArticleInfo.mChannelID))) {
      return false;
    }
    paramBaseArticleInfo = paramBaseArticleInfo.proteusItemsData;
    bool1 = bool5;
    if (paramBaseArticleInfo != null) {
      bool2 = bool4;
    }
    for (;;)
    {
      try
      {
        paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo);
        bool2 = bool4;
        Object localObject = paramBaseArticleInfo.optString("style_ID");
        bool2 = bool4;
        QLog.i("DailyTipsFoldUtils", 1, "[isFirstCardDailyTips], styleID = " + (String)localObject);
        bool1 = bool5;
        bool2 = bool4;
        if (TextUtils.equals("ReadInjoy_daily_check_card", (CharSequence)localObject))
        {
          bool2 = bool4;
          paramBaseArticleInfo = paramBaseArticleInfo.optJSONArray("datas");
          bool1 = bool3;
          if (paramBaseArticleInfo != null)
          {
            bool1 = bool3;
            bool2 = bool4;
            if (paramBaseArticleInfo.length() == 1)
            {
              bool2 = bool4;
              localObject = paramBaseArticleInfo.getJSONObject(0);
              bool1 = bool3;
              if (localObject != null)
              {
                bool2 = bool4;
                bool1 = TextUtils.equals("1", ((JSONObject)localObject).optString("is_day_tip"));
              }
            }
          }
          bool2 = bool1;
          localObject = new StringBuilder().append("[isFirstCardDailyTips], data length = ");
          if (paramBaseArticleInfo == null) {
            continue;
          }
          bool2 = bool1;
          paramBaseArticleInfo = Integer.valueOf(paramBaseArticleInfo.length());
          bool2 = bool1;
          QLog.i("DailyTipsFoldUtils", 1, paramBaseArticleInfo);
        }
      }
      catch (JSONException paramBaseArticleInfo)
      {
        QLog.e("DailyTipsFoldUtils", 1, "[isFirstCardDailyTips], e = " + paramBaseArticleInfo);
        bool1 = bool2;
        continue;
      }
      QLog.i("DailyTipsFoldUtils", 1, "[isFirstCardDailyTips] res = " + bool1);
      return bool1;
      paramBaseArticleInfo = "0";
    }
  }
  
  public static void b(ReadInJoyXListView paramReadInJoyXListView, int paramInt)
  {
    if (paramReadInJoyXListView == null)
    {
      QLog.i("DailyTipsFoldUtils", 1, "[touchDailyFeeds], listView is null.");
      return;
    }
    if (!oox.c(paramInt))
    {
      QLog.i("DailyTipsFoldUtils", 1, "[touchDailyFeeds], is not daily feeds, channelID = " + paramInt);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("DailyTipsFoldUtils", 2, "[touchDailyFeeds], cancelFoldDailyTipsRunnable.");
    }
    jdField_a_of_type_Boolean = true;
    a(paramReadInJoyXListView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     opw
 * JD-Core Version:    0.7.0.1
 */