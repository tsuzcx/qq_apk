package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.ImageFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnThumbEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnTransEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.PictureFileViewer;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import java.util.List;

public class PictureFilePresenter
  extends FileBrowserPresenterBase
  implements FileBrowserModelBase.OnThumbEventListener, FileBrowserModelBase.OnTransEventListener
{
  private int jdField_a_of_type_Int = 0;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new PictureFilePresenter.2(this);
  protected PictureFileViewer a;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new PictureFilePresenter.3(this);
  private AdapterView.OnItemSelectedListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = new PictureFilePresenter.4(this);
  private List<FileBrowserModelBase.ImageFileInfo> jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
  boolean jdField_a_of_type_Boolean = false;
  private int b = 0;
  private boolean d = false;
  
  public PictureFilePresenter(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    super(paramFileBrowserModelBase, paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer = new PictureFileViewer(paramActivity);
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer);
  }
  
  private boolean a(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  private String b()
  {
    FileBrowserModelBase.ImageFileInfo localImageFileInfo = (FileBrowserModelBase.ImageFileInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c());
    if (localImageFileInfo == null) {
      return null;
    }
    String str2 = localImageFileInfo.a();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = localImageFileInfo.b();
    }
    return str1;
  }
  
  private void b()
  {
    Object localObject = b();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.i("PictureFilePresenter<QFile>", 1, "startEditPicture. but file path is null.");
      return;
    }
    localObject = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(this.jdField_a_of_type_AndroidAppActivity, (String)localObject, true, true, true, true, true, 2, 130, 7);
    ((Intent)localObject).putExtra("open_chatfragment", true);
    ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1041);
    ((Intent)localObject).putExtra("key_enable_edit_title_bar", true);
    ((Intent)localObject).putExtra("key_help_forward_pic", true);
    ((Intent)localObject).putExtra("key_allow_multiple_forward_from_limit", false);
    this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.l();
    if ((i != 3) && (i != 4))
    {
      if ((i != 7) && (i != 8) && (i != 9))
      {
        if (i != 11) {
          i = 0;
        } else {
          i = 2;
        }
      }
      else {
        i = 1;
      }
    }
    else {
      i = 3;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A1E2", "0X800A1E2", i, 0, "", "", "", "");
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772065, 2130772067);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c();
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.w("PictureFilePresenter<QFile>", 1, "FileBrowserPresenter init: type = picture");
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.get(this.jdField_a_of_type_Int) != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.e()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.c(a(b()));
      FMToastUtil.b(BaseApplicationImpl.getContext().getString(2131692353));
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.a(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.a(new PictureFilePresenter.1(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.a(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.b(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c());
    h();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c(paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i()) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.b(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.a(false);
      b(0.0F);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a().a();
    }
    h();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload error : picture fileid is null!");
      }
      return;
    }
    FileBrowserModelBase.ImageFileInfo localImageFileInfo = (FileBrowserModelBase.ImageFileInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c());
    if (!localImageFileInfo.a(paramString1)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload error : picture thumbPath is null!");
      }
      localImageFileInfo.a(3);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PictureFilePresenter onThumbDownload suc : fileId[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("] thumbPath[");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("]");
      QLog.e("PictureFilePresenter<QFile>", 1, localStringBuilder.toString());
    }
    localImageFileInfo.a(paramString2);
    localImageFileInfo.a(2);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.c();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.a(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.b(true);
    b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a());
  }
  
  public void e()
  {
    h();
  }
  
  public void f()
  {
    h();
    ((FileBrowserModelBase.ImageFileInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c())).b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.c();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.d();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.c();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.a(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.b(false);
    h();
  }
  
  protected void h()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i();
    if ((i != 2) && (i != 5))
    {
      if (i == 6)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.a(true);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.b(false);
      }
      super.h();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.f() == 9501) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.b();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.a(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerPictureFileViewer.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.PictureFilePresenter
 * JD-Core Version:    0.7.0.1
 */