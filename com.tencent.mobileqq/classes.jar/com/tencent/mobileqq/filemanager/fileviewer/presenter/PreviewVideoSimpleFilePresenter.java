package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.fileviewer.FileVideoOnlinePlayerFragment;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnPreviewVideoOnlineListener;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PreviewVideoSimpleFilePresenter
  extends PreviewSimpleFilePresenter
  implements View.OnClickListener, FileBrowserModelBase.OnPreviewVideoOnlineListener
{
  protected long a;
  protected boolean a;
  private boolean e = false;
  
  public PreviewVideoSimpleFilePresenter(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    super(paramFileBrowserModelBase, paramActivity);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(false);
    if (((!TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext())) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c())) && (QLog.isDevelopLevel())) {
      QLog.d("PreviewVideoSimpleFilePresenter", 4, "executeOnNetWorkThread setCanPreview false-------------");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(this)) && (QLog.isColorLevel())) {
      QLog.d("PreviewVideoSimpleFilePresenter", 2, "requestWhitelist 本地信息为空!!!!");
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreviewVideoSimpleFilePresenter", 2, "clickPlay url = " + paramString1 + ", cookie = " + paramString2);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("fileid", this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.n());
      localIntent.putExtra("url", paramString1);
      localIntent.putExtra("cookie", paramString2);
      localIntent.putExtra("public_fragment_window_feature", 1);
      PublicFragmentActivity.Launcher.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, PublicFragmentActivity.class, FileVideoOnlinePlayerFragment.class);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b(3);
  }
  
  protected void as_()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(this.e);
    if (FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d())) {
      super.as_();
    }
    while (!this.e) {
      return;
    }
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131692761);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(str, this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(this.e);
  }
  
  public void au_()
  {
    this.jdField_a_of_type_AndroidAppActivity.getString(2131692761);
    this.e = true;
    as_();
  }
  
  public void av_()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
    if (QLog.isDevelopLevel()) {
      QLog.d("PreviewVideoSimpleFilePresenter", 4, "executeOnNetWorkThread setCanPreview false-------------");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b(4);
  }
  
  public void c()
  {
    FMToastUtil.a(2131719374);
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
      if (QLog.isColorLevel()) {
        QLog.d("PreviewVideoSimpleFilePresenter", 2, "click online preview video too fast");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()) {
        QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131708402), 0).b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.m());
      } else if (!NetworkUtil.d(BaseApplication.getContext())) {
        FMToastUtil.a(2131692602);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.PreviewVideoSimpleFilePresenter
 * JD-Core Version:    0.7.0.1
 */