import UserGrowth.stReportItem;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import mqq.util.WeakReference;

public class tet
  extends bdfq
{
  private static WeakReference<tet> a;
  
  public tet(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    b();
  }
  
  public static void a()
  {
    if (a != null)
    {
      tet localtet = (tet)a.get();
      if (localtet != null)
      {
        if (tfa.b()) {
          tlo.c("WeishiDownloadUtil", "关闭qzone弹窗");
        }
        for (;;)
        {
          localtet.dismiss();
          return;
          tlo.c("WeishiDownloadUtil", "关闭qq弹窗");
        }
      }
      if (tfa.b())
      {
        tlo.d("WeishiDownloadUtil", "qzone弹窗 is null");
        return;
      }
      tlo.d("WeishiDownloadUtil", "qq弹窗 is null");
      return;
    }
    tlo.d("WeishiDownloadUtil", "download弹窗 mWeakRefrence is null");
  }
  
  public static void a(int paramInt, WSDownloadParams paramWSDownloadParams)
  {
    if ((paramWSDownloadParams == null) || (paramWSDownloadParams.mStReportItem == null)) {
      return;
    }
    paramWSDownloadParams.mStReportItem.downloadscene = tfa.a(paramWSDownloadParams.mScene, paramWSDownloadParams.mLinkStrategyType, paramWSDownloadParams.mEventId);
    tjr.a(paramInt, paramWSDownloadParams.mStReportItem);
  }
  
  public static void a(Activity paramActivity)
  {
    try
    {
      if (tfa.b()) {
        tlo.d("WeishiDownloadUtil", "弹出qzone弹窗---");
      }
      for (;;)
      {
        if ((a == null) || (a.get() == null))
        {
          paramActivity = new tet(paramActivity, 2131755801);
          paramActivity.setTitle("正在下载腾讯微视APP");
          paramActivity.setMessage("️⬆完成安装即可领取最高188红包⬆");
          paramActivity.setPositiveButton(alpo.a(2131717388), new teu());
          a = new WeakReference(paramActivity);
        }
        ((tet)a.get()).show();
        return;
        tlo.d("WeishiDownloadUtil", "弹出qq弹窗");
      }
      return;
    }
    catch (Exception paramActivity)
    {
      tlo.d("WeishiDownloadUtil", "showDownloadDialog error:" + paramActivity.getLocalizedMessage());
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
    tet localtet = new tet(paramActivity, 2131755801);
    localtet.setTitle("来腾讯微视，创造挖掘神评论");
    localtet.setMessage("️⬆完成安装即可领取最高188红包⬆");
    if (paramWSDownloadParams.mStReportItem == null) {}
    for (int i = paramWSDownloadParams.mScene;; i = paramWSDownloadParams.mStReportItem.pagetype)
    {
      localtet.setPositiveButton(alpo.a(2131717390), new tev(paramActivity, paramString, paramWSDownloadParams, i, paramInt));
      localtet.setNegativeButton(alpo.a(2131717389), new tew(i, paramInt));
      localtet.show();
      tju.b(6, 0, 0);
      tjr.a(6, i, paramInt, null);
      return;
    }
  }
  
  public static boolean a(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    paramWSDownloadParams.mTestId = tju.b();
    return tfa.a(paramActivity, paramWSDownloadParams, true, 3);
  }
  
  private void b()
  {
    setContentView(2131558943);
    setCanceledOnTouchOutside(true);
  }
  
  public static void b(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    if (tfa.c())
    {
      a(paramActivity, paramWSDownloadParams);
      return;
    }
    tet localtet = new tet(paramActivity, 2131755801);
    localtet.setTitle(alpo.a(2131717391));
    localtet.setMessage("️⬆完成安装即可领取最高188红包⬆");
    localtet.setPositiveButton(alpo.a(2131717387), new tex(paramActivity, paramWSDownloadParams));
    localtet.setNegativeButton(alpo.a(2131717389), new tey(paramWSDownloadParams));
    localtet.show();
    tju.a(paramWSDownloadParams.mScene, true, false);
    a(124, paramWSDownloadParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tet
 * JD-Core Version:    0.7.0.1
 */