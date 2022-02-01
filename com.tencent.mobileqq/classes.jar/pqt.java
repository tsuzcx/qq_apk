import android.content.Context;
import android.content.res.Resources;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import org.jetbrains.annotations.NotNull;

public class pqt
{
  public static int a()
  {
    return Aladdin.getConfig(199).getIntegerFromString("no_difference_jump_app_jump_src", 0);
  }
  
  public static String a(@NotNull Context paramContext)
  {
    return Aladdin.getConfig(264).getString("push_title", paramContext.getResources().getString(2131717775));
  }
  
  public static boolean a()
  {
    return Aladdin.getConfig(154).getIntegerFromString("need_show_social_bottom_view", 1) == 1;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = true;
    if ((paramInt != 0) && (!plm.b(paramInt))) {
      return false;
    }
    if (Aladdin.getConfig(256).getIntegerFromString("enable_delete_article_after_refresh", 0) == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 3) {}
    do
    {
      return true;
      if ((Aladdin.getConfig(254).getIntegerFromString("is_fix_below_15min_click_flag", 0) == 1) && (paramInt1 == 0) && (uvs.a())) {
        return false;
      }
    } while (Aladdin.getConfig(251).getIntegerFromString("bt_fix", 0) != 1);
    return false;
  }
  
  public static int b()
  {
    return Aladdin.getConfig(264).getIntegerFromString("show_timing", 1);
  }
  
  public static boolean b()
  {
    return Aladdin.getConfig(176).getIntegerFromString("artical_interact_area", 0) == 1;
  }
  
  public static int c()
  {
    return Aladdin.getConfig(264).getIntegerFromString("open_type", 1);
  }
  
  public static boolean c()
  {
    return Aladdin.getConfig(176).getIntegerFromString("ad_relative_pos", 0) == 1;
  }
  
  public static int d()
  {
    return Aladdin.getConfig(196).getIntegerFromString("artical_interact_type", 0);
  }
  
  public static boolean d()
  {
    return Aladdin.getConfig(190).getIntegerFromString("readinjoy_feeds_overdraw_optimize_switch", 1) == 1;
  }
  
  public static boolean e()
  {
    return Aladdin.getConfig(258).getIntegerFromString("tab_change_report_in_subthread", 0) == 1;
  }
  
  public static boolean f()
  {
    return Aladdin.getConfig(375).getIntegerFromString("aio_kandian_video_preview_autoplay_enable", 1) == 1;
  }
  
  public static boolean g()
  {
    return Aladdin.getConfig(276).getIntegerFromString("supportPreloadWebProcess", 1) == 1;
  }
  
  public static boolean h()
  {
    return Aladdin.getConfig(253).getIntegerFromString("enable_use_exposure_data", 0) == 1;
  }
  
  public static boolean i()
  {
    return Aladdin.getConfig(255).getIntegerFromString("allow_yaobu_icon_click_report", 0) == 1;
  }
  
  public static boolean j()
  {
    return Aladdin.getConfig(245).getIntegerFromString("kandian_feeds_card_style", 0) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pqt
 * JD-Core Version:    0.7.0.1
 */