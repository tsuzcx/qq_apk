import UserGrowth.stReportItem;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import mqq.util.WeakReference;

public class rxn
  extends bafb
{
  private static WeakReference<rxn> a;
  
  public rxn(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    b();
  }
  
  public static void a()
  {
    if (a != null)
    {
      rxn localrxn = (rxn)a.get();
      if (localrxn != null)
      {
        if (rxu.b()) {
          sai.c("WeishiDownloadUtil", "关闭qzone弹窗");
        }
        for (;;)
        {
          localrxn.dismiss();
          return;
          sai.c("WeishiDownloadUtil", "关闭qq弹窗");
        }
      }
      if (rxu.b())
      {
        sai.d("WeishiDownloadUtil", "qzone弹窗 is null");
        return;
      }
      sai.d("WeishiDownloadUtil", "qq弹窗 is null");
      return;
    }
    sai.d("WeishiDownloadUtil", "download弹窗 mWeakRefrence is null");
  }
  
  public static void a(int paramInt, WSDownloadParams paramWSDownloadParams)
  {
    if ((paramWSDownloadParams == null) || (paramWSDownloadParams.mStReportItem == null)) {
      return;
    }
    paramWSDownloadParams.mStReportItem.downloadscene = rxu.a(paramWSDownloadParams.mScene, paramWSDownloadParams.mLinkStrategyType, paramWSDownloadParams.mEventId);
    rzu.a(paramInt, paramWSDownloadParams.mStReportItem);
  }
  
  public static void a(Activity paramActivity)
  {
    try
    {
      if (rxu.b()) {
        sai.d("WeishiDownloadUtil", "弹出qzone弹窗---");
      }
      for (;;)
      {
        if (a == null)
        {
          paramActivity = new rxn(paramActivity, 2131690181);
          paramActivity.setTitle("正在下载腾讯微视APP");
          paramActivity.setMessage("️⬆完成安装即可领取最高188红包⬆");
          paramActivity.setPositiveButton(ajjy.a(2131651214), new rxo());
          a = new WeakReference(paramActivity);
        }
        if (a.get() == null) {
          break;
        }
        ((rxn)a.get()).show();
        return;
        sai.d("WeishiDownloadUtil", "弹出qq弹窗");
      }
      return;
    }
    catch (Exception paramActivity)
    {
      sai.d("WeishiDownloadUtil", "showDownloadDialog error:" + paramActivity.getLocalizedMessage());
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
    rxn localrxn = new rxn(paramActivity, 2131690181);
    localrxn.setTitle("来腾讯微视，创造挖掘神评论");
    localrxn.setMessage("️⬆完成安装即可领取最高188红包⬆");
    if (paramWSDownloadParams.mStReportItem == null) {}
    for (int i = paramWSDownloadParams.mScene;; i = paramWSDownloadParams.mStReportItem.pagetype)
    {
      localrxn.setPositiveButton(ajjy.a(2131651216), new rxp(paramActivity, paramString, paramWSDownloadParams, i, paramInt));
      localrxn.setNegativeButton(ajjy.a(2131651215), new rxq(i, paramInt));
      localrxn.show();
      rzw.b(6, 0, 0);
      rzu.a(6, i, paramInt, null);
      return;
    }
  }
  
  public static boolean a(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    paramWSDownloadParams.mTestId = rzw.b();
    return rxu.a(paramActivity, paramWSDownloadParams, true, 3);
  }
  
  private void b()
  {
    setContentView(2131493345);
    setCanceledOnTouchOutside(true);
  }
  
  public static void b(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    if (rxu.c())
    {
      a(paramActivity, paramWSDownloadParams);
      return;
    }
    rxn localrxn = new rxn(paramActivity, 2131690181);
    localrxn.setTitle(ajjy.a(2131651217));
    localrxn.setMessage("️⬆完成安装即可领取最高188红包⬆");
    localrxn.setPositiveButton(ajjy.a(2131651213), new rxr(paramActivity, paramWSDownloadParams));
    localrxn.setNegativeButton(ajjy.a(2131651215), new rxs(paramWSDownloadParams));
    localrxn.show();
    rzw.a(paramWSDownloadParams.mScene, true, false);
    a(124, paramWSDownloadParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rxn
 * JD-Core Version:    0.7.0.1
 */