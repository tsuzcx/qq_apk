package com.tencent.mobileqq.nearby;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadUtil;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class NearbyTribeAppController
{
  protected QQAppInterface a;
  private String b = "NearbyTribeAppController";
  private Context c;
  private Handler d;
  private boolean e;
  private boolean f = true;
  private int g;
  private String h;
  private String[] i = { HardCodeUtil.a(2131905243), HardCodeUtil.a(2131905242), "好看的人都在用兴趣部落APP", HardCodeUtil.a(2131905241), HardCodeUtil.a(2131905239), "看看好友在兴趣部落APP玩什么？" };
  private String[] j = { HardCodeUtil.a(2131905232), HardCodeUtil.a(2131905235), "好看的人都在用兴趣部落APP", HardCodeUtil.a(2131905238), HardCodeUtil.a(2131905237) };
  private IUniformDownloaderListener k = new NearbyTribeAppController.3(this);
  
  public NearbyTribeAppController(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.c = paramContext;
    this.d = new Handler(Looper.getMainLooper());
    this.a = paramQQAppInterface;
  }
  
  public void a()
  {
    Context localContext;
    if (!NetworkUtil.isNetworkAvailable(this.c))
    {
      localContext = this.c;
      QQToast.makeText(localContext, 1, localContext.getString(2131892105), 0).show();
      return;
    }
    if (!"0".equals(PackageUtil.b(this.c, "com.tencent.tribe")))
    {
      localContext = this.c;
      if ((localContext instanceof Activity))
      {
        TroopBarPublishUtils.a((Activity)localContext);
        ReportController.b(this.a, "dc00899", "Grp_tribe", "", "user_profile", "Clk_app_call", 0, 0, String.valueOf(this.g), "", "", "");
      }
      return;
    }
    if (!this.f)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.b, 2, "invokeTribeOpenOrDownload,isActivate=false");
      }
      return;
    }
    ThreadManager.post(new NearbyTribeAppController.1(this), 8, null, true);
    ReportController.b(this.a, "dc00899", "Grp_tribe", "", "user_profile", "Clk_app_download", 0, 0, String.valueOf(this.g), "", "", "");
  }
  
  public void a(TextView paramTextView)
  {
    String str = PackageUtil.b(this.c, "com.tencent.tribe");
    Random localRandom = new Random();
    int m;
    if (!"0".equals(str))
    {
      m = localRandom.nextInt(this.j.length);
      this.g = (m + 1);
      this.h = this.j[m];
      paramTextView.setText(this.h);
      paramTextView = "exp_app_call";
    }
    else
    {
      m = localRandom.nextInt(this.i.length);
      this.g = (m + 1);
      this.h = this.i[m];
      paramTextView.setText(this.h);
      paramTextView = "exp_app_download";
    }
    ReportController.b(this.a, "dc00899", "Grp_tribe", "", "user_profile", paramTextView, 0, 0, String.valueOf(this.g), "", "", "");
  }
  
  protected void a(String paramString)
  {
    try
    {
      this.f = true;
      QLog.e(this.b, 1, "这里已经下架，如果依然发现该log，异常case");
      ((IUniformDownloadUtil)QRoute.api(IUniformDownloadUtil.class)).getFileInfoOfUrlAsync("https://pub.idqqimg.com/pc/misc/files/20170706/c221bf304be44e5a9e0441768beacff0.apk", new NearbyTribeAppController.2(this));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QQToast.makeText(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131905240), 0).show(50);
    }
  }
  
  public void b()
  {
    this.e = true;
    this.d.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyTribeAppController
 * JD-Core Version:    0.7.0.1
 */