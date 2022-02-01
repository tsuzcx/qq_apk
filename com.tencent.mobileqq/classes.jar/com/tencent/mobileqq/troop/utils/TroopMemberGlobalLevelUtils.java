package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TroopMemberGlobalLevelUtils
{
  private static long a;
  private static final Drawable b = new ColorDrawable(-5658199);
  
  protected static void a()
  {
    int i = 0;
    while (i < 20)
    {
      Object localObject = String.format("https://pub.idqqimg.com/pc/misc/groupgift/global_troop_level_%d.png", new Object[] { Integer.valueOf(i) });
      URLDrawable.removeMemoryCacheByUrl((String)localObject);
      localObject = AbsDownloader.getFile((String)localObject);
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
  
  public static String b()
  {
    return "https://qun.qq.com/interactive/userhonor?gc=<$GC>&uin=<$UIN>&_wv=3&&_wwv=128";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopMemberGlobalLevelUtils
 * JD-Core Version:    0.7.0.1
 */