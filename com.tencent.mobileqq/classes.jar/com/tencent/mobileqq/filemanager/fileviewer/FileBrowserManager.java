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
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase != null) {
      return localFileBrowserModelBase.e();
    }
    return -1;
  }
  
  public long a()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase != null) {
      return localFileBrowserModelBase.c();
    }
    return 0L;
  }
  
  public IServiceInfo a()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase != null) {
      return localFileBrowserModelBase.a();
    }
    return null;
  }
  
  public String a()
  {
    FileBrowserPresenterBase localFileBrowserPresenterBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase;
    if (localFileBrowserPresenterBase != null) {
      return localFileBrowserPresenterBase.a();
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null)
    {
      localParam = new ShareActionSheetV2.Param();
      localParam.context = this.jdField_a_of_type_AndroidAppActivity;
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create(localParam);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOnDismissListener(new FileBrowserManager.1(this));
    Object localObject = a();
    ShareActionSheetV2.Param localParam = null;
    if (localObject != null)
    {
      if (localObject.length == 1)
      {
        localParam = localObject[0];
        localList = null;
        break label105;
      }
      if (localObject.length == 2)
      {
        localParam = localObject[0];
        localList = localObject[1];
        break label105;
      }
    }
    List localList = null;
    label105:
    if (((localParam != null) && (!localParam.isEmpty())) || ((localList != null) && (!localList.isEmpty())))
    {
      a((ArrayList[])localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(FileUtil.a(a()));
      ((StringBuilder)localObject).append(")");
      localObject = ((StringBuilder)localObject).toString();
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle((CharSequence)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
      String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", str);
      if ((localObject != null) && (!TextUtils.isEmpty(str))) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity((Intent)localObject);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(8, 0, 0);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localParam, localList);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new FileBrowserManager.2(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    FileBrowserPresenterBase localFileBrowserPresenterBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase;
    if (localFileBrowserPresenterBase != null) {
      localFileBrowserPresenterBase.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    FileBrowserPresenterBase localFileBrowserPresenterBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase;
    if (localFileBrowserPresenterBase != null) {
      localFileBrowserPresenterBase.a(paramConfiguration);
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
      FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
      if (localFileBrowserModelBase == null)
      {
        QLog.e("FileBrowserManager<FileAssistant>", 1, "create FileBrowser failed, mFileModel = null");
        return false;
      }
      localFileBrowserModelBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.e(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(paramBundle);
    }
    boolean bool2 = e();
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase != null))
    {
      bool1 = bool2;
      if (paramViewGroup != null)
      {
        bool1 = bool2;
        if (paramLayoutParams != null)
        {
          paramViewGroup.removeAllViews();
          paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase.a(), paramLayoutParams);
          return bool2;
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserManager<FileAssistant>", 2, "create file view error");
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if ((localFileBrowserModelBase != null) && (localFileBrowserModelBase.l())) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
    }
    return null;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase;
    if ((localObject != null) && ((localObject instanceof VideoFilePresenter)))
    {
      ((FileBrowserPresenterBase)localObject).p();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null)
    {
      localObject = a();
      List localList = null;
      if (localObject != null)
      {
        if (localObject.length == 1)
        {
          localList = localObject[0];
          localObject = null;
          break label73;
        }
        if (localObject.length == 2)
        {
          localList = localObject[0];
          localObject = localObject[1];
          break label73;
        }
      }
      localObject = null;
      label73:
      if (((localList != null) && (!localList.isEmpty())) || ((localObject != null) && (!((ArrayList)localObject).isEmpty()))) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localList, (List)localObject);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.refresh();
      }
    }
  }
  
  public boolean b()
  {
    FileBrowserPresenterBase localFileBrowserPresenterBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase;
    if (localFileBrowserPresenterBase != null) {
      return localFileBrowserPresenterBase.b();
    }
    return false;
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localObject != null) {
      ((FileBrowserModelBase)localObject).m();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase;
    if (localObject != null) {
      ((FileBrowserPresenterBase)localObject).l();
    }
  }
  
  public boolean c()
  {
    FileBrowserPresenterBase localFileBrowserPresenterBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase;
    if (localFileBrowserPresenterBase != null) {
      return localFileBrowserPresenterBase.a();
    }
    return false;
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localObject != null) {
      ((FileBrowserModelBase)localObject).k();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase;
    if (localObject != null) {
      ((FileBrowserPresenterBase)localObject).j();
    }
  }
  
  public boolean d()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    return (localFileBrowserModelBase != null) && (localFileBrowserModelBase.j() != 0);
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localObject != null) {
      ((FileBrowserModelBase)localObject).j();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase;
    if (localObject != null) {
      ((FileBrowserPresenterBase)localObject).k();
    }
  }
  
  protected boolean e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localObject != null)
    {
      int j = ((FileBrowserModelBase)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refreshFileView. currentType[");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append("] fileType[");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("]");
        QLog.i("FileBrowserManager<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      }
      if (this.jdField_a_of_type_Int != j)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase;
        if (localObject != null) {
          ((FileBrowserPresenterBase)localObject).i();
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d();
        int i = j;
        if (localObject != null)
        {
          i = j;
          if (((String)localObject).contains("/chatpic/chatimg/")) {
            i = 6;
          }
        }
        switch (i)
        {
        default: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new SimpleFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
          break;
        case 11: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new ApkForAppStoreFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
          break;
        case 10: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new DocExportFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
          break;
        case 9: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new OnlineSimpleFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
          break;
        case 8: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new PreviewVideoSimpleFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
          break;
        case 7: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new PreviewSimpleFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
          break;
        case 6: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new PictureFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
          break;
        case 5: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new ZipFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
          break;
        case 4: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new MusicFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
          break;
        case 3: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new ApkSimpleFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
          break;
        case 2: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = new VideoFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase, this.jdField_a_of_type_AndroidAppActivity);
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.a(this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.a();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase.a();
        this.jdField_a_of_type_Int = i;
        return true;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localObject != null)
    {
      ((FileBrowserModelBase)localObject).c();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase;
    if (localObject != null)
    {
      ((FileBrowserPresenterBase)localObject).i();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterFileBrowserPresenterBase = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase = null;
    }
  }
  
  public boolean f()
  {
    Object localObject1 = a();
    Object localObject2 = null;
    if (localObject1 != null)
    {
      if (localObject1.length == 1)
      {
        localObject2 = localObject1[0];
        localObject1 = null;
        break label45;
      }
      if (localObject1.length == 2)
      {
        localObject2 = localObject1[0];
        localObject1 = localObject1[1];
        break label45;
      }
    }
    localObject1 = null;
    label45:
    return ((localObject2 != null) && (!localObject2.isEmpty())) || ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileBrowserManager
 * JD-Core Version:    0.7.0.1
 */