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
  protected boolean a = false;
  protected long b = 0L;
  private boolean l = false;
  
  public PreviewVideoSimpleFilePresenter(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    super(paramFileBrowserModelBase, paramActivity);
  }
  
  public void a()
  {
    super.a();
    this.k.c(false);
    if (((!TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext())) || (this.c.t())) && (QLog.isDevelopLevel())) {
      QLog.d("PreviewVideoSimpleFilePresenter", 4, "executeOnNetWorkThread setCanPreview false-------------");
    }
    if ((this.c.b(this)) && (QLog.isColorLevel())) {
      QLog.d("PreviewVideoSimpleFilePresenter", 2, "requestWhitelist 本地信息为空!!!!");
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clickPlay url = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", cookie = ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("PreviewVideoSimpleFilePresenter", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("fileid", this.c.ah());
      ((Intent)localObject).putExtra("url", paramString1);
      ((Intent)localObject).putExtra("cookie", paramString2);
      ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
      PublicFragmentActivity.Launcher.a(this.d, (Intent)localObject, PublicFragmentActivity.class, FileVideoOnlinePlayerFragment.class);
    }
    this.c.b(3);
  }
  
  public void co_()
  {
    this.d.getString(2131889789);
    this.l = true;
    i();
  }
  
  public void cp_()
  {
    if (this.a) {
      return;
    }
    this.a = true;
    this.k.c(true);
    if (QLog.isDevelopLevel()) {
      QLog.d("PreviewVideoSimpleFilePresenter", 4, "executeOnNetWorkThread setCanPreview false-------------");
    }
    this.c.b(4);
  }
  
  public void cq_()
  {
    FMToastUtil.a(2131916628);
  }
  
  protected void i()
  {
    this.k.d(this.l);
    if (FileUtils.fileExistsAndNotEmpty(this.c.y()))
    {
      super.i();
      return;
    }
    if (this.l)
    {
      String str = this.d.getString(2131889789);
      this.k.b(str, this);
      this.k.d(this.l);
    }
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.b < 500L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreviewVideoSimpleFilePresenter", 2, "click online preview video too fast");
      }
    }
    else
    {
      this.b = System.currentTimeMillis();
      if (this.c.t()) {
        QQToast.makeText(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131906196), 0).show(this.c.ap());
      } else if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
        FMToastUtil.a(2131889577);
      } else {
        this.c.a(this);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.PreviewVideoSimpleFilePresenter
 * JD-Core Version:    0.7.0.1
 */