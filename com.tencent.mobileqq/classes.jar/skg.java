import UserGrowth.stReportItem;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import mqq.util.WeakReference;

public class skg
  extends bbgu
{
  private static WeakReference<skg> a;
  
  public skg(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    b();
  }
  
  public static void a()
  {
    if (a != null)
    {
      skg localskg = (skg)a.get();
      if (localskg != null)
      {
        if (skn.b()) {
          snb.c("WeishiDownloadUtil", "关闭qzone弹窗");
        }
        for (;;)
        {
          localskg.dismiss();
          return;
          snb.c("WeishiDownloadUtil", "关闭qq弹窗");
        }
      }
      if (skn.b())
      {
        snb.d("WeishiDownloadUtil", "qzone弹窗 is null");
        return;
      }
      snb.d("WeishiDownloadUtil", "qq弹窗 is null");
      return;
    }
    snb.d("WeishiDownloadUtil", "download弹窗 mWeakRefrence is null");
  }
  
  public static void a(int paramInt, WSDownloadParams paramWSDownloadParams)
  {
    if ((paramWSDownloadParams == null) || (paramWSDownloadParams.mStReportItem == null)) {
      return;
    }
    paramWSDownloadParams.mStReportItem.downloadscene = skn.a(paramWSDownloadParams.mScene, paramWSDownloadParams.mLinkStrategyType, paramWSDownloadParams.mEventId);
    smn.a(paramInt, paramWSDownloadParams.mStReportItem);
  }
  
  public static void a(Activity paramActivity)
  {
    try
    {
      if (skn.b()) {
        snb.d("WeishiDownloadUtil", "弹出qzone弹窗---");
      }
      for (;;)
      {
        if ((a == null) || (a.get() == null))
        {
          paramActivity = new skg(paramActivity, 2131755791);
          paramActivity.setTitle("正在下载腾讯微视APP");
          paramActivity.setMessage("️⬆完成安装即可领取最高188红包⬆");
          paramActivity.setPositiveButton(ajya.a(2131717016), new skh());
          a = new WeakReference(paramActivity);
        }
        ((skg)a.get()).show();
        return;
        snb.d("WeishiDownloadUtil", "弹出qq弹窗");
      }
      return;
    }
    catch (Exception paramActivity)
    {
      snb.d("WeishiDownloadUtil", "showDownloadDialog error:" + paramActivity.getLocalizedMessage());
    }
  }
  
  public static void a(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    if (a(paramActivity, paramWSDownloadParams))
    {
      a(115, paramWSDownloadParams);
      a(paramActivity);
      return;
    }
    Log.e("WeishiDownloadUtil", "QQ download start error");
  }
  
  public static void a(Activity paramActivity, String paramString, WSDownloadParams paramWSDownloadParams, int paramInt)
  {
    skg localskg = new skg(paramActivity, 2131755791);
    localskg.setTitle("来腾讯微视，创造挖掘神评论");
    localskg.setMessage("️⬆完成安装即可领取最高188红包⬆");
    if (paramWSDownloadParams.mStReportItem == null) {}
    for (int i = paramWSDownloadParams.mScene;; i = paramWSDownloadParams.mStReportItem.pagetype)
    {
      localskg.setPositiveButton(ajya.a(2131717018), new ski(paramActivity, paramString, paramWSDownloadParams, i, paramInt));
      localskg.setNegativeButton(ajya.a(2131717017), new skj(i, paramInt));
      localskg.show();
      smp.b(6, 0, 0);
      smn.a(6, i, paramInt, null);
      return;
    }
  }
  
  public static boolean a(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    paramWSDownloadParams.mTestId = smp.b();
    return skn.a(paramActivity, paramWSDownloadParams, true, 3);
  }
  
  private void b()
  {
    setContentView(2131558906);
    setCanceledOnTouchOutside(true);
  }
  
  public static void b(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    if (skn.c())
    {
      a(paramActivity, paramWSDownloadParams);
      return;
    }
    skg localskg = new skg(paramActivity, 2131755791);
    localskg.setTitle(ajya.a(2131717019));
    localskg.setMessage("️⬆完成安装即可领取最高188红包⬆");
    localskg.setPositiveButton(ajya.a(2131717015), new skk(paramActivity, paramWSDownloadParams));
    localskg.setNegativeButton(ajya.a(2131717017), new skl(paramWSDownloadParams));
    localskg.show();
    smp.a(paramWSDownloadParams.mScene, true, false);
    a(124, paramWSDownloadParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     skg
 * JD-Core Version:    0.7.0.1
 */