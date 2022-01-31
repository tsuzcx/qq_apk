package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ApkSimpleFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.OnlineSimpleFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.PictureFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.PreviewSimpleFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.PreviewVideoSimpleFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.FileBrowserViewBase;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class FileBrowserManager
{
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private FileBrowserManager.IModelCreater jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager$IModelCreater;
  private IFileBrowser jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser;
  protected IFileViewListener a;
  private FileBrowserModelBase jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
  private FileBrowserPresenterBase jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase;
  private FileBrowserViewBase jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase;
  
  public FileBrowserManager(Activity paramActivity, IFileBrowser paramIFileBrowser, FileBrowserManager.IModelCreater paramIModelCreater)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser = paramIFileBrowser;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager$IModelCreater = paramIModelCreater;
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserManager<FileAssistant>", 1, "refreshFileView. currentType[" + this.jdField_a_of_type_Int + "] fileType[" + i + "]");
      }
      if (this.jdField_a_of_type_Int != i)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.j();
        }
        switch (i)
        {
        default: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new SimpleFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.a();
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.a();
          this.jdField_a_of_type_Int = i;
          return true;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new ApkSimpleFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new MusicFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new PictureFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new VideoFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new ZipFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new PreviewVideoSimpleFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new PreviewSimpleFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new OnlineSimpleFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.a();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserManager<FileAssistant>", 2, "initFileViewer error : model is null");
    }
    return false;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b();
    }
    return 0L;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.a();
    }
    return "";
  }
  
  public ArrayList a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
    }
    return new ArrayList();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.j();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.h();
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.a(paramConfiguration);
    }
  }
  
  public void a(IFileViewListener paramIFileViewListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener = paramIFileViewListener;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.b();
    }
    return false;
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserManager<FileAssistant>", 1, "FileBrowserManager init.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager$IModelCreater.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser);
    }
    boolean bool2 = c();
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserManager<FileAssistant>", 2, "create file view error");
      }
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramViewGroup == null);
      bool1 = bool2;
    } while (paramLayoutParams == null);
    paramViewGroup.removeAllViews();
    paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(), paramLayoutParams);
    return bool2;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.i();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.a();
    }
    return false;
  }
  
  public boolean b(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool = c();
    if ((bool) && (paramViewGroup != null) && (paramLayoutParams != null))
    {
      paramViewGroup.removeAllViews();
      paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(), paramLayoutParams);
    }
    return bool;
  }
  
  public void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileBrowserManager<FileAssistant><FileAssistant>", 1, "FileBrowserManager Finish");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.h();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.j();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileBrowserManager
 * JD-Core Version:    0.7.0.1
 */