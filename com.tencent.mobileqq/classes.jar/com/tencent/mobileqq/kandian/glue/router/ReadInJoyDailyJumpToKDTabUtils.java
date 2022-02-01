package com.tencent.mobileqq.kandian.glue.router;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.impl.ReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyDailyJumpToKDTabUtils
{
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_viola_json_data_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, int paramInt)
  {
    if (paramIntent != null)
    {
      if (paramContext == null) {
        return false;
      }
      int i = paramIntent.getIntExtra("arg_channel_id", -1);
      String str1 = paramIntent.getStringExtra("arg_channel_rowkey");
      String str2 = paramIntent.getStringExtra("arg_channel_article_url");
      boolean bool = paramIntent.getBooleanExtra("arg_show_floating_window", false);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[openArticleDetail], channelIdInt = ");
      localStringBuilder.append(i);
      localStringBuilder.append(", rowKey = ");
      localStringBuilder.append(str1);
      localStringBuilder.append(", articleUrl = ");
      localStringBuilder.append(str2);
      localStringBuilder.append(", showFloatingWindow = ");
      localStringBuilder.append(bool);
      localStringBuilder.append(", channelId = ");
      localStringBuilder.append(paramInt);
      QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, localStringBuilder.toString());
      if (i != paramInt) {
        return false;
      }
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        ReadInJoyUtils.a(paramContext, str2);
        paramContext = (RIJTabFrameBase)RIJJumpUtils.a(paramContext);
        if ((paramContext != null) && (bool)) {
          paramContext.b(32);
        }
        QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, "[openArticleDetail] finished.");
        paramIntent.removeExtra("arg_channel_id");
        paramIntent.removeExtra("arg_channel_rowkey");
        paramIntent.removeExtra("arg_channel_article_url");
        paramIntent.removeExtra("arg_show_floating_window");
      }
      return bool;
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    ReadInJoyChannelGuidingManager.a(paramString);
    return b(paramContext, paramString);
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, "[jumpToKdTabAndOpenDetail] scheme is empty.");
      return false;
    }
    RIJDailyJumpParser.RIJDailyScheme localRIJDailyScheme = new RIJDailyJumpParser.RIJDailyScheme(paramString);
    ReadInJoyChannelGuidingManager.a(localRIJDailyScheme.b(), localRIJDailyScheme);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[jumpToKdTabAndOpenDetail], rijDailyScheme = ");
    ((StringBuilder)localObject).append(localRIJDailyScheme);
    QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, ((StringBuilder)localObject).toString());
    RIJSPUtils.a(a(localRIJDailyScheme.b()), localRIJDailyScheme.f());
    if (!"2".equals(localRIJDailyScheme.a())) {
      return false;
    }
    if (!TextUtils.isEmpty(localRIJDailyScheme.c()))
    {
      if (TextUtils.isEmpty(localRIJDailyScheme.d())) {
        return false;
      }
      if (!RIJShowKanDianTabSp.c())
      {
        ReadInJoyUtils.a(paramContext, localRIJDailyScheme.d());
        QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, "[jumpToKdTabAndOpenDetail] do not show kd tab, open it directly.");
        return true;
      }
      if (RIJXTabConfigHandler.INSTANCE.getHomeFeedsStyle() == 3)
      {
        ReadInJoyUtils.a(paramContext, localRIJDailyScheme.d());
        QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, "[jumpToKdTabAndOpenDetail] immersive video, open it directly.");
        return true;
      }
      localObject = ReadInJoyActivityHelper.INSTANCE.getJumpReadInJoyTabIntent(paramContext, 12, localRIJDailyScheme.b());
      ((Intent)localObject).putExtra("arg_channel_id", localRIJDailyScheme.b());
      ((Intent)localObject).putExtra("arg_channel_rowkey", localRIJDailyScheme.c());
      ((Intent)localObject).putExtra("arg_channel_article_url", localRIJDailyScheme.d());
      ((Intent)localObject).putExtra("arg_show_floating_window", localRIJDailyScheme.e());
      paramContext.startActivity((Intent)localObject);
      paramContext = new StringBuilder();
      paramContext.append("[jumpToKdTabAndOpenDetail] jumpToKdTab succeed, scheme = ");
      paramContext.append(paramString);
      QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, paramContext.toString());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.router.ReadInJoyDailyJumpToKDTabUtils
 * JD-Core Version:    0.7.0.1
 */