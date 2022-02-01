package com.tencent.mobileqq.vashealth;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc00307;
import cooperation.qzone.report.lp.LpReportManager;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

@KeepClassConstructor
public class RunningBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, IBannerLifecycle
{
  public static final int a = BannerTypeCollections.K;
  private boolean b = true;
  
  public RunningBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.g = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RunningBar", 2, "initRunningBar");
    }
    paramBanner = new TipsBar(this.f);
    paramBanner.setTipsText(HardCodeUtil.a(2131899166));
    paramBanner.b(true);
    paramBanner.setTipsIcon(this.f.getResources().getDrawable(2130838367));
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (paramMessage == null)
    {
      if (QLog.isColorLevel())
      {
        paramBanner = new StringBuilder();
        paramBanner.append("updateRunningBar msg ");
        paramBanner.append(paramMessage);
        QLog.d("runningState", 2, paramBanner.toString());
      }
      return;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateRunningBar msg.obj = ");
      ((StringBuilder)localObject1).append(paramMessage.obj);
      QLog.d("RunningBar", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramMessage.obj instanceof JSONObject)) {}
    for (;;)
    {
      try
      {
        Long localLong = Long.valueOf(((JSONObject)paramMessage.obj).getLong("runningState"));
        localObject1 = ((JSONObject)paramMessage.obj).getString("cookieUrl");
        String str = ((JSONObject)paramMessage.obj).optString("title");
        ((JSONObject)paramMessage.obj).optInt("actid");
        int i = ((JSONObject)paramMessage.obj).optInt("appid");
        long l = localLong.longValue();
        localObject2 = null;
        if (l == 1L)
        {
          ((TipsBar)paramBanner.c).setTipsText(HardCodeUtil.a(2131899163));
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("&ADTAG=aio.run.click");
          localObject1 = ((StringBuilder)localObject2).toString();
          break label598;
        }
        if (localLong.longValue() == 2L)
        {
          ((TipsBar)paramBanner.c).setTipsText(HardCodeUtil.a(2131899155));
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("&ADTAG=aio.run.click");
          localObject1 = ((StringBuilder)localObject2).toString();
          break label598;
        }
        if (localLong.longValue() != 3L) {
          break label608;
        }
        ((TipsBar)paramBanner.c).setTipsText(str);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&ADTAG=qqlist.tongzhi.hongbao.click");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = ((JSONObject)paramMessage.obj).optString("icon");
        paramBanner.c.setOnClickListener(new RunningBannerProcessor.1(this, (String)localObject2, localLong, i));
        if (localLong.longValue() == 3L)
        {
          localObject2 = new LpReportInfo_dc00307(LpReportInfo_dc00307.ACTION_TYPE_RED_PACK, LpReportInfo_dc00307.SUB_ACTION_TYPE_RED_PACK_EXPOSURE, i);
          LpReportManager.getInstance().reportToDC00307((LpReportInfo_dc00307)localObject2, false, true);
        }
        if ((paramBanner.c instanceof TipsBar)) {
          ((TipsBar)paramBanner.c).setCloseListener(new RunningBannerProcessor.2(this));
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramBanner = new Bundle();
          paramMessage.obj = paramBanner;
          paramMessage = Message.obtain(paramMessage);
          ImageLoader.a().a((String)localObject1, new RunningBannerProcessor.3(this, paramBanner, paramMessage));
        }
        ReportController.a(this.f.getAppRuntime(), "dc00898", "", "", "0X8009EDF", "0X8009EDF", 9, 0, "", "", "", "");
        return;
      }
      catch (JSONException paramBanner)
      {
        return;
      }
      if ((paramMessage.obj instanceof Bundle))
      {
        paramMessage = (Bundle)paramMessage.obj;
        if (paramMessage.containsKey("icon"))
        {
          paramMessage = (Bitmap)paramMessage.getParcelable("icon");
          ((TipsBar)paramBanner.c).setTipsIcon(new BitmapDrawable(paramMessage));
        }
      }
      return;
      label598:
      Object localObject2 = localObject1;
      localObject1 = null;
      continue;
      label608:
      localObject1 = null;
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.g.removeCallbacksAndMessages(null);
  }
  
  public int b()
  {
    return a;
  }
  
  public void c()
  {
    BannerManager.a().a(a, 0);
  }
  
  public void d() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 3000) {
      BannerManager.a().a(a, 0, paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.RunningBannerProcessor
 * JD-Core Version:    0.7.0.1
 */