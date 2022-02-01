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
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new QFileSendBarManager.1(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  
  public QFileSendBarManager(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    super(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    d();
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      g();
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(SplashActivity.sTopActivity, SplashActivity.sTopActivity.getResources().getDimensionPixelSize(2131299168));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131713695));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131377187));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131371932));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void e()
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      FMToastUtil.a(2131694395);
      return;
    }
    if ((FileManagerUtil.a()) && (((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedLocalFileSize() > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      FileManagerUtil.a(true, this.jdField_a_of_type_AndroidContentContext, new QFileSendBarManager.2(this), this.jdField_b_of_type_Int);
      return;
    }
    c();
  }
  
  private void f()
  {
    if (TroopFileUtils.a(this.jdField_a_of_type_AndroidContentContext) == 0)
    {
      TroopFileError.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697616));
      c();
      return;
    }
    if (FileManagerUtil.a())
    {
      if (FreeWifiHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, 2, new QFileSendBarManager.3(this)))
      {
        Object localObject = new QFileSendBarManager.4(this);
        String str = this.jdField_a_of_type_AndroidContentContext.getString(2131697403);
        localObject = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697613), str, 2131690728, 2131697809, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
        if ((KingCardProcessor.c().b.jdField_a_of_type_Boolean) && (!TMSManager.a().b())) {
          ((QQCustomDialog)localObject).setMessageWithoutAutoLink(KingCardProcessor.c().b.a(this.jdField_a_of_type_AndroidContentContext, str));
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
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
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
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692335));
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692531));
    ((StringBuilder)localObject1).append(((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedCount());
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692532));
    String str = ((StringBuilder)localObject1).toString();
    long l = ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedFileSize();
    if (l > 0L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692333));
      ((StringBuilder)localObject1).append(FileUtil.a(l));
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
      if (!QQFileManagerUtil.a(this.jdField_a_of_type_AndroidContentContext))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692334));
        ((StringBuilder)localObject2).append(FileUtil.a(((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedCloudFileSize()));
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    localObject1 = str;
    if (this.jdField_b_of_type_Int == 1101)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694583);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692333));
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692531));
      ((StringBuilder)localObject2).append(((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedCount());
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692532));
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    boolean bool;
    if (((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedCount() > 0L) {
      bool = true;
    } else {
      bool = false;
    }
    ((TextView)localObject1).setEnabled(bool);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("qfile_search_param_exparams_busi_type");
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("qfile_search_param_ex_params_target_uin");
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("qfile_search_param_exparams_peer_type", -1);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("qfile_search_param_exparams_send_uin");
    }
    if (paramBundle.getInt("file_choose_extension_handle_type", -1) == 1) {
      this.jdField_b_of_type_Int = 1101;
    }
  }
  
  public void b()
  {
    super.b();
  }
  
  public void c()
  {
    a(2131694882);
    new Handler().postDelayed(new QFileSendBarManager.5(this), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QFileSendBarManager
 * JD-Core Version:    0.7.0.1
 */