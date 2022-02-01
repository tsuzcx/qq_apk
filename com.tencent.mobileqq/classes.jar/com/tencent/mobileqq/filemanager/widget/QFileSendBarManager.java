package com.tencent.mobileqq.filemanager.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardConfig;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardConfig.Item;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardProcessor;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wifi.FreeWifiHelper;

public class QFileSendBarManager
  extends QFileCustomBottomBarManager
{
  private TextView g;
  private TextView h;
  private QQProgressDialog i;
  private int j;
  private String k;
  private int l;
  private String m;
  private View.OnClickListener n = new QFileSendBarManager.1(this);
  
  public QFileSendBarManager(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    super(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    d();
  }
  
  private void a(int paramInt)
  {
    if (this.i != null)
    {
      g();
    }
    else
    {
      this.i = new QQProgressDialog(SplashActivity.sTopActivity, SplashActivity.sTopActivity.getResources().getDimensionPixelSize(2131299920));
      this.i.setCancelable(false);
      this.i.a(HardCodeUtil.a(2131911238));
      this.i.show();
    }
    if (!this.i.isShowing()) {
      this.i.show();
    }
  }
  
  private void d()
  {
    this.g = ((TextView)this.c.a(2131445568));
    this.h = ((TextView)this.c.a(2131439377));
    this.g.setOnClickListener(this.n);
  }
  
  private void e()
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      FMToastUtil.a(2131892074);
      return;
    }
    if ((FileManagerUtil.b()) && (((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedLocalFileSize() > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      FileManagerUtil.a(true, this.a, new QFileSendBarManager.2(this), this.l);
      return;
    }
    c();
  }
  
  private void f()
  {
    if (TroopFileUtils.a(this.a) == 0)
    {
      TroopFileError.a(this.a, this.a.getString(2131895389));
      c();
      return;
    }
    if (FileManagerUtil.b())
    {
      if (FreeWifiHelper.a((Activity)this.a, 2, new QFileSendBarManager.3(this)))
      {
        Object localObject = new QFileSendBarManager.4(this);
        String str = this.a.getString(2131895176);
        localObject = DialogUtil.a(this.a, 230, this.a.getString(2131895386), str, 2131887648, 2131895582, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
        if ((KingCardProcessor.e().b.a) && (!TMSManager.a().d())) {
          ((QQCustomDialog)localObject).setMessageWithoutAutoLink(KingCardProcessor.e().b.a(this.a, str));
        }
        ((QQCustomDialog)localObject).show();
      }
    }
    else {
      c();
    }
  }
  
  private void g()
  {
    try
    {
      if ((this.i != null) && (this.i.isShowing()))
      {
        this.i.cancel();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.a.getString(2131889323));
    ((StringBuilder)localObject1).append(this.a.getString(2131889554));
    ((StringBuilder)localObject1).append(((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedCount());
    ((StringBuilder)localObject1).append(this.a.getString(2131889555));
    String str = ((StringBuilder)localObject1).toString();
    long l1 = ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedFileSize();
    if (l1 > 0L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.a.getString(2131889321));
      ((StringBuilder)localObject1).append(FileUtil.a(l1));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    if (((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedCloudFileSize() > 0L)
    {
      localObject2 = localObject1;
      if (!QQFileManagerUtil.c(this.a))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(this.a.getString(2131889322));
        ((StringBuilder)localObject2).append(FileUtil.a(((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedCloudFileSize()));
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    localObject1 = str;
    if (this.l == 1101)
    {
      localObject1 = this.a.getResources().getString(2131892267);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a.getString(2131889321));
      ((StringBuilder)localObject2).append(this.a.getString(2131889554));
      ((StringBuilder)localObject2).append(((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedCount());
      ((StringBuilder)localObject2).append(this.a.getString(2131889555));
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    this.g.setText((CharSequence)localObject1);
    localObject1 = this.g;
    boolean bool;
    if (((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedCount() > 0L) {
      bool = true;
    } else {
      bool = false;
    }
    ((TextView)localObject1).setEnabled(bool);
    this.h.setText((CharSequence)localObject2);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.e)
    {
      this.j = this.d.getInt("qfile_search_param_exparams_busi_type");
      this.k = this.d.getString("qfile_search_param_ex_params_target_uin");
      this.l = this.d.getInt("qfile_search_param_exparams_peer_type", -1);
      this.m = this.d.getString("qfile_search_param_exparams_send_uin");
    }
    if (paramBundle.getInt("file_choose_extension_handle_type", -1) == 1) {
      this.l = 1101;
    }
  }
  
  public void b()
  {
    super.b();
  }
  
  public void c()
  {
    a(2131892585);
    new Handler().postDelayed(new QFileSendBarManager.5(this), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QFileSendBarManager
 * JD-Core Version:    0.7.0.1
 */