package com.tencent.mobileqq.kandian.biz.daily;

import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DailyTipsFoldUtils
{
  private static boolean a = false;
  private static long b = 2000L;
  private static Runnable c;
  
  public static void a()
  {
    QLog.i("DailyTipsFoldUtils", 2, "[init]");
    a = false;
  }
  
  public static void a(ReadInJoyXListView paramReadInJoyXListView, int paramInt)
  {
    if (paramReadInJoyXListView == null) {
      return;
    }
    if (!DailyModeConfigHandler.c(paramInt)) {
      return;
    }
    if (c != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DailyTipsFoldUtils", 1, "[cancelFoldDailyTipsRunnable], removeCallbacks");
      }
      paramReadInJoyXListView.removeCallbacks(c);
    }
    c = null;
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, ReadInJoyXListView paramReadInJoyXListView)
  {
    if ((paramAbsBaseArticleInfo != null) && (DailyModeConfigHandler.c((int)paramAbsBaseArticleInfo.mChannelID)))
    {
      if (paramReadInJoyXListView == null)
      {
        QLog.i("DailyTipsFoldUtils", 1, "[foldDailyTips], listView is null.");
        return;
      }
      if (a(paramAbsBaseArticleInfo))
      {
        c = new DailyTipsFoldUtils.1(paramReadInJoyXListView);
        if (!a)
        {
          paramAbsBaseArticleInfo = Aladdin.getConfig(208);
          if (paramAbsBaseArticleInfo != null)
          {
            b = paramAbsBaseArticleInfo.getIntegerFromString("delay_duration", 2000);
            paramAbsBaseArticleInfo = new StringBuilder();
            paramAbsBaseArticleInfo.append("[foldDailyTips], delayFoldTime = ");
            paramAbsBaseArticleInfo.append(b);
            QLog.i("DailyTipsFoldUtils", 2, paramAbsBaseArticleInfo.toString());
          }
          paramReadInJoyXListView.postDelayed(c, b);
        }
      }
      return;
    }
    QLog.i("DailyTipsFoldUtils", 1, "[foldDailyTips], articleInfo is null or not daily channel.");
  }
  
  private static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2;
    if (paramAbsBaseArticleInfo != null)
    {
      if (!DailyModeConfigHandler.c((int)paramAbsBaseArticleInfo.mChannelID)) {
        return false;
      }
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.proteusItemsData;
      bool1 = bool5;
      if (paramAbsBaseArticleInfo != null) {
        bool2 = bool4;
      }
    }
    for (;;)
    {
      try
      {
        paramAbsBaseArticleInfo = new JSONObject(paramAbsBaseArticleInfo);
        bool2 = bool4;
        localObject = paramAbsBaseArticleInfo.optString("style_ID");
        bool2 = bool4;
        StringBuilder localStringBuilder = new StringBuilder();
        bool2 = bool4;
        localStringBuilder.append("[isFirstCardDailyTips], styleID = ");
        bool2 = bool4;
        localStringBuilder.append((String)localObject);
        bool2 = bool4;
        QLog.i("DailyTipsFoldUtils", 1, localStringBuilder.toString());
        bool2 = bool4;
        bool1 = bool5;
        if (TextUtils.equals("ReadInjoy_daily_check_card", (CharSequence)localObject))
        {
          bool2 = bool4;
          paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.optJSONArray("datas");
          bool1 = bool3;
          if (paramAbsBaseArticleInfo != null)
          {
            bool1 = bool3;
            bool2 = bool4;
            if (paramAbsBaseArticleInfo.length() == 1)
            {
              bool2 = bool4;
              localObject = paramAbsBaseArticleInfo.getJSONObject(0);
              bool1 = bool3;
              if (localObject != null)
              {
                bool2 = bool4;
                bool1 = TextUtils.equals("1", ((JSONObject)localObject).optString("is_day_tip"));
              }
            }
          }
          bool2 = bool1;
          localObject = new StringBuilder();
          bool2 = bool1;
          ((StringBuilder)localObject).append("[isFirstCardDailyTips], data length = ");
          if (paramAbsBaseArticleInfo == null) {
            break label322;
          }
          bool2 = bool1;
          paramAbsBaseArticleInfo = Integer.valueOf(paramAbsBaseArticleInfo.length());
          bool2 = bool1;
          ((StringBuilder)localObject).append(paramAbsBaseArticleInfo);
          bool2 = bool1;
          QLog.i("DailyTipsFoldUtils", 1, ((StringBuilder)localObject).toString());
        }
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[isFirstCardDailyTips], e = ");
        ((StringBuilder)localObject).append(paramAbsBaseArticleInfo);
        QLog.e("DailyTipsFoldUtils", 1, ((StringBuilder)localObject).toString());
        bool1 = bool2;
      }
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("[isFirstCardDailyTips] res = ");
      paramAbsBaseArticleInfo.append(bool1);
      QLog.i("DailyTipsFoldUtils", 1, paramAbsBaseArticleInfo.toString());
      return bool1;
      label322:
      paramAbsBaseArticleInfo = "0";
    }
  }
  
  public static void b(ReadInJoyXListView paramReadInJoyXListView, int paramInt)
  {
    if (paramReadInJoyXListView == null) {
      return;
    }
    if (!DailyModeConfigHandler.c(paramInt)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("DailyTipsFoldUtils", 2, "[touchDailyFeeds], cancelFoldDailyTipsRunnable.");
    }
    a = true;
    a(paramReadInJoyXListView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.DailyTipsFoldUtils
 * JD-Core Version:    0.7.0.1
 */