package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TroopMemberGlobalLevelUtils
{
  public static Drawable a(int paramInt)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    return URLDrawable.getDrawable(String.format("http://pub.idqqimg.com/pc/misc/groupgift/global_troop_level_%d.png", new Object[] { Integer.valueOf(paramInt) }), localURLDrawableOptions);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return "https://qun.qq.com/qqweb/m/qun/rank/rank.html?from=31&_wv=1031&_bid=2468&uin=" + paramString1 + "&gc=" + paramString2;
  }
  
  protected static void a()
  {
    int i = 0;
    while (i < 20)
    {
      Object localObject = String.format("http://pub.idqqimg.com/pc/misc/groupgift/global_troop_level_%d.png", new Object[] { Integer.valueOf(i) });
      URLDrawable.removeMemoryCacheByUrl((String)localObject);
      localObject = AbsDownloader.a((String)localObject);
      if ((localObject != null) && (((File)localObject).exists()) && (((File)localObject).isFile())) {
        ((File)localObject).delete();
      }
      i += 1;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    String str = new SimpleDateFormat("yyyy年MM月dd日").format(localCalendar.getTime());
    if ((!TextUtils.isEmpty(str)) && (str.equals(SharePreferenceUtils.a(paramContext, "glamour_has_update_today")))) {
      return false;
    }
    if (localCalendar.get(11) >= 4)
    {
      a();
      SharePreferenceUtils.a(paramContext, "glamour_has_update_today", str);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopMemberGlobalLevelUtils
 * JD-Core Version:    0.7.0.1
 */