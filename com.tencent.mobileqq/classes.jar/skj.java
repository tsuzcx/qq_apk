import UserGrowth.stReportItem;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import mqq.util.WeakReference;

public class skj
  extends bbgg
{
  private static WeakReference<skj> a;
  
  public skj(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    b();
  }
  
  public static void a()
  {
    if (a != null)
    {
      skj localskj = (skj)a.get();
      if (localskj != null)
      {
        if (skq.b()) {
          sne.c("WeishiDownloadUtil", "关闭qzone弹窗");
        }
        for (;;)
        {
          localskj.dismiss();
          return;
          sne.c("WeishiDownloadUtil", "关闭qq弹窗");
        }
      }
      if (skq.b())
      {
        sne.d("WeishiDownloadUtil", "qzone弹窗 is null");
        return;
      }
      sne.d("WeishiDownloadUtil", "qq弹窗 is null");
      return;
    }
    sne.d("WeishiDownloadUtil", "download弹窗 mWeakRefrence is null");
  }
  
  public static void a(int paramInt, WSDownloadParams paramWSDownloadParams)
  {
    if ((paramWSDownloadParams == null) || (paramWSDownloadParams.mStReportItem == null)) {
      return;
    }
    paramWSDownloadParams.mStReportItem.downloadscene = skq.a(paramWSDownloadParams.mScene, paramWSDownloadParams.mLinkStrategyType, paramWSDownloadParams.mEventId);
    smq.a(paramInt, paramWSDownloadParams.mStReportItem);
  }
  
  public static void a(Activity paramActivity)
  {
    try
    {
      if (skq.b()) {
        sne.d("WeishiDownloadUtil", "弹出qzone弹窗---");
      }
      for (;;)
      {
        if ((a == null) || (a.get() == null))
        {
          paramActivity = new skj(paramActivity, 2131755791);
          paramActivity.setTitle("正在下载腾讯微视APP");
          paramActivity.setMessage("️⬆完成安装即可领取最高188红包⬆");
          paramActivity.setPositiveButton(ajyc.a(2131717005), new skk());
          a = new WeakReference(paramActivity);
        }
        ((skj)a.get()).show();
        return;
        sne.d("WeishiDownloadUtil", "弹出qq弹窗");
      }
      return;
    }
    catch (Exception paramActivity)
    {
      sne.d("WeishiDownloadUtil", "showDownloadDialog error:" + paramActivity.getLocalizedMessage());
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
    skj localskj = new skj(paramActivity, 2131755791);
    localskj.setTitle("来腾讯微视，创造挖掘神评论");
    localskj.setMessage("️⬆完成安装即可领取最高188红包⬆");
    if (paramWSDownloadParams.mStReportItem == null) {}
    for (int i = paramWSDownloadParams.mScene;; i = paramWSDownloadParams.mStReportItem.pagetype)
    {
      localskj.setPositiveButton(ajyc.a(2131717007), new skl(paramActivity, paramString, paramWSDownloadParams, i, paramInt));
      localskj.setNegativeButton(ajyc.a(2131717006), new skm(i, paramInt));
      localskj.show();
      sms.b(6, 0, 0);
      smq.a(6, i, paramInt, null);
      return;
    }
  }
  
  public static boolean a(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    paramWSDownloadParams.mTestId = sms.b();
    return skq.a(paramActivity, paramWSDownloadParams, true, 3);
  }
  
  private void b()
  {
    setContentView(2131558906);
    setCanceledOnTouchOutside(true);
  }
  
  public static void b(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    if (skq.c())
    {
      a(paramActivity, paramWSDownloadParams);
      return;
    }
    skj localskj = new skj(paramActivity, 2131755791);
    localskj.setTitle(ajyc.a(2131717008));
    localskj.setMessage("️⬆完成安装即可领取最高188红包⬆");
    localskj.setPositiveButton(ajyc.a(2131717004), new skn(paramActivity, paramWSDownloadParams));
    localskj.setNegativeButton(ajyc.a(2131717006), new sko(paramWSDownloadParams));
    localskj.show();
    sms.a(paramWSDownloadParams.mScene, true, false);
    a(124, paramWSDownloadParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     skj
 * JD-Core Version:    0.7.0.1
 */