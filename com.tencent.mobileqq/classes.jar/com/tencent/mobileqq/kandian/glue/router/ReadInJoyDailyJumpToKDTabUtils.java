package com.tencent.mobileqq.kandian.glue.router;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;

public class ReadInJoyDailyJumpToKDTabUtils
{
  public static boolean a(Context paramContext, String paramString)
  {
    ReadInJoyChannelGuidingManager.a(paramString);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("jumpToKDTab, scheme = ");
    ((StringBuilder)localObject1).append(paramString);
    QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, ((StringBuilder)localObject1).toString());
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, "[jumpToKDTab], scheme is empty.");
      return false;
    }
    try
    {
      paramString = Uri.parse(paramString);
      localObject1 = paramString.getQueryParameter("target");
      if (!"2".equals(localObject1))
      {
        paramContext = new StringBuilder();
        paramContext.append("[jumpToKDTab], target = ");
        paramContext.append((String)localObject1);
        paramContext.append(", do not jump to channel.");
        QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, paramContext.toString());
        return false;
      }
      localObject1 = paramString.getQueryParameter("channelid");
      int i = -1;
      try
      {
        int j = Integer.parseInt((String)localObject1);
        i = j;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[jumpToKDTab], e = ");
        ((StringBuilder)localObject2).append(localNumberFormatException);
        QLog.e("ReadInJoyDailyJumpToKDTabUtils", 1, ((StringBuilder)localObject2).toString());
      }
      if (i != 0)
      {
        QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, "[jumpToKDTab], not recommend tab.");
        return false;
      }
      String str1 = paramString.getQueryParameter("rowkey");
      Object localObject2 = paramString.getQueryParameter("algorithmid");
      String str2 = paramString.getQueryParameter("article_url");
      String str3 = URLDecoder.decode(str2, "utf-8");
      boolean bool = TextUtils.equals("1", paramString.getQueryParameter("show_floating_window"));
      paramString = new StringBuilder();
      paramString.append("[jumpToKDTab], articleURLDecoded = ");
      paramString.append(str3);
      QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, paramString.toString());
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
      {
        if (!RIJShowKanDianTabSp.c())
        {
          ReadInJoyUtils.a(paramContext, str3);
          QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, "[jumpToKDTab], open article directly.");
          return true;
        }
        if (bool)
        {
          paramContext.startActivity(((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getJumpReadInJoyTabFloatingWindowIntent(paramContext, 12, str1, str2));
          QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, "[jumpToKDTab], open floating window.");
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("[jumpToKDTab], e = ");
      paramString.append(paramContext);
      QLog.e("ReadInJoyDailyJumpToKDTabUtils", 1, paramString.toString());
      QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, "[jumpToKDTab], do not handle.");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.router.ReadInJoyDailyJumpToKDTabUtils
 * JD-Core Version:    0.7.0.1
 */