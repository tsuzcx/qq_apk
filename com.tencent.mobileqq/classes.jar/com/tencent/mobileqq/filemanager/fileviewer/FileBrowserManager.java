package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ApkForAppStoreFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ApkSimpleFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.DocExportFilePresenter;
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
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileBrowserManager
{
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private FileBrowserManager.IModelCreater jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager$IModelCreater;
  private IFileBrowser jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser;
  protected IFileViewListener a;
  private FileBrowserModelBase jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
  private FileBrowserPresenterBase jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase;
  private FileBrowserViewBase jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase;
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  
  public FileBrowserManager(Activity paramActivity, IFileBrowser paramIFileBrowser, FileBrowserManager.IModelCreater paramIModelCreater)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser = paramIFileBrowser;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager$IModelCreater = paramIModelCreater;
  }
  
  private void a(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfArrayList)
  {
    if ((paramArrayOfArrayList != null) && (paramArrayOfArrayList.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfArrayList.length)
      {
        Object localObject = paramArrayOfArrayList[i];
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject).next()).action == 26) {
              ReportController.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.e();
    }
    return -1;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c();
    }
    return 0L;
  }
  
  public IServiceInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.a();
    }
    return "";
  }
  
  public void a()
  {
    List localList = null;
    ShareActionSheetV2.Param localParam;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null)
    {
      localParam = new ShareActionSheetV2.Param();
      localParam.context = this.jdField_a_of_type_AndroidAppActivity;
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create(localParam);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOnDismissListener(new FileBrowserManager.1(this));
    Object localObject = a();
    if (localObject != null) {
      if (localObject.length == 1) {
        localParam = localObject[0];
      }
    }
    for (;;)
    {
      if (((localParam != null) && (!localParam.isEmpty())) || ((localList != null) && (!localList.isEmpty())))
      {
        a((ArrayList[])localObject);
        localObject = a() + "(" + FileUtil.a(a()) + ")";
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle((CharSequence)localObject);
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
        String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
        this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", str);
        if ((localObject != null) && (!TextUtils.isEmpty(str))) {
          break label268;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(8, 0, 0);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localParam, localList);
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new FileBrowserManager.2(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
        return;
        if (localObject.length != 2) {
          break label281;
        }
        localParam = localObject[0];
        localList = localObject[1];
        break;
        label268:
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity((Intent)localObject);
      }
      label281:
      localParam = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.a(paramInt1, paramInt2, paramIntent);
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
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.e();
    return (i == 3) || (i == 9) || (i == 7) || (i == 10) || (i == 6);
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool = e();
    if ((bool) && (paramViewGroup != null) && (paramLayoutParams != null))
    {
      paramViewGroup.removeAllViews();
      paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(), paramLayoutParams);
    }
    return bool;
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserManager<FileAssistant>", 1, "FileBrowserManager init.");
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager$IModelCreater.a();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase == null)
      {
        QLog.e("FileBrowserManager<FileAssistant>", 1, "create FileBrowser failed, mFileModel = null");
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.e(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(paramBundle);
    }
    boolean bool2 = e();
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserManager<FileAssistant>", 2, "create file view error");
      }
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramViewGroup != null)
      {
        bool1 = bool2;
        if (paramLayoutParams != null)
        {
          paramViewGroup.removeAllViews();
          paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(), paramLayoutParams);
          bool1 = bool2;
        }
      }
    }
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.l())) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
    }
    return null;
  }
  
  public void b()
  {
    List localList = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase != null) && ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase instanceof VideoFilePresenter))) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.p();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null) {
      return;
    }
    ArrayList[] arrayOfArrayList = a();
    ArrayList localArrayList;
    if (arrayOfArrayList != null) {
      if (arrayOfArrayList.length == 1) {
        localArrayList = arrayOfArrayList[0];
      }
    }
    for (;;)
    {
      if (((localArrayList != null) && (!localArrayList.isEmpty())) || ((localList != null) && (!localList.isEmpty()))) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localArrayList, localList);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.refresh();
      return;
      if (arrayOfArrayList.length == 2)
      {
        localArrayList = arrayOfArrayList[0];
        localList = arrayOfArrayList[1];
      }
      else
      {
        localArrayList = null;
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.b();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.l();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.l();
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.a();
    }
    return false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.j();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.j();
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.j() != 0);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.k();
    }
  }
  
  protected boolean e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase != null)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d();
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserManager<FileAssistant>", 1, "refreshFileView. currentType[" + this.jdField_a_of_type_Int + "] fileType[" + j + "]");
      }
      if (this.jdField_a_of_type_Int != j)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.i();
        }
        String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d();
        int i = j;
        if (str != null)
        {
          i = j;
          if (str.contains("/chatpic/chatimg/")) {
            i = 6;
          }
        }
        switch (i)
        {
        default: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new SimpleFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.a(this.jdField_a_of_type_AndroidOsBundle);
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
          continue;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new DocExportFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new ApkForAppStoreFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
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
  
  public void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileBrowserManager<FileAssistant><FileAssistant>", 1, "FileBrowserManager Finish");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.k_();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.i();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase = null;
    }
  }
  
  public boolean f()
  {
    Object localObject = null;
    ArrayList[] arrayOfArrayList = a();
    ArrayList localArrayList;
    if (arrayOfArrayList != null) {
      if (arrayOfArrayList.length == 1) {
        localArrayList = arrayOfArrayList[0];
      }
    }
    for (;;)
    {
      if (((localArrayList != null) && (!localArrayList.isEmpty())) || ((localObject != null) && (!localObject.isEmpty())))
      {
        return true;
        if (arrayOfArrayList.length == 2)
        {
          localArrayList = arrayOfArrayList[0];
          localObject = arrayOfArrayList[1];
        }
      }
      else
      {
        return false;
      }
      localArrayList = null;
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase != null) && ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase instanceof SimpleFileViewer))) {
      ((SimpleFileViewer)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase).h(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileBrowserManager
 * JD-Core Version:    0.7.0.1
 */