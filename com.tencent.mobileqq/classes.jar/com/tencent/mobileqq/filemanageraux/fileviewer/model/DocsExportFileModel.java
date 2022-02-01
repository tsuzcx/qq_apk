package com.tencent.mobileqq.filemanageraux.fileviewer.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.dataline.data.PrinterManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.OfflinePreviewController;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnTransEventListener;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanageraux.core.DiscOfflinePreviewController;
import com.tencent.mobileqq.filemanageraux.link.LinkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkExportObserver;
import com.tencent.mobileqq.teamwork.TeamWorkExportUtil;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileExportHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.smtt.sdk.QbSdk;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class DocsExportFileModel
  extends DefaultFileModel
  implements Handler.Callback
{
  public long a;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private TeamWorkExportObserver jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkExportObserver;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public long b = 0L;
  private int c = 1000;
  private int d = 60000;
  
  public DocsExportFileModel(QQAppInterface paramQQAppInterface, Activity paramActivity, List<IFileViewerAdapter> paramList, int paramInt)
  {
    super(paramQQAppInterface, paramActivity);
    this.jdField_a_of_type_Long = 0L;
    a(paramList, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if ((localQQAppInterface != null) && (paramString2 != null))
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (localFileManagerEntity != null) {
        ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009956", "0X8009956", 0, 2, "", "", TeamWorkExportUtil.a(localFileManagerEntity.nFileType), paramString2);
      }
    }
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = HardCodeUtil.a(2131703558);
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, paramString2, 0).a();
    c();
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b = System.currentTimeMillis();
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(8001);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(8002);
    this.jdField_a_of_type_MqqOsMqqHandler.post(new DocsExportFileModel.2(this));
    ((ITeamWorkFileExportHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_EXPORT_HANDLER)).fileExportDownloadRequest(paramString1, paramString2, paramString3, paramString4);
  }
  
  public int a()
  {
    return 10;
  }
  
  public Intent a()
  {
    return null;
  }
  
  public IDownloadController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController = new DocsExportFileModel.3(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController;
  }
  
  public IUploadController a()
  {
    return null;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkExportObserver != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkExportObserver = new DocsExportFileModel.1(this);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localQQAppInterface != null)
    {
      TeamWorkExportObserver localTeamWorkExportObserver = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkExportObserver;
      if (localTeamWorkExportObserver != null) {
        localQQAppInterface.addObserver(localTeamWorkExportObserver);
      }
    }
  }
  
  public void a(FileBrowserModelBase.OnTransEventListener paramOnTransEventListener)
  {
    super.a(paramOnTransEventListener);
    if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("isSuccess")))
    {
      boolean bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isSuccess");
      paramOnTransEventListener = this.jdField_a_of_type_AndroidOsBundle.getString("docUrl");
      if (bool) {
        a(this.jdField_a_of_type_AndroidOsBundle.getString("url"), this.jdField_a_of_type_AndroidOsBundle.getString("fileName"), paramOnTransEventListener, this.jdField_a_of_type_AndroidOsBundle.getString("cookie"));
      } else {
        a(HardCodeUtil.a(2131714582), paramOnTransEventListener);
      }
      this.jdField_a_of_type_AndroidOsBundle.remove("isSuccess");
    }
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    String str = d();
    boolean bool = FileUtil.a(str);
    if ((localFileManagerEntity == null) && (TextUtils.isEmpty(str))) {
      return;
    }
    if (b() == 16) {
      return;
    }
    if ((!bool) && (localFileManagerEntity != null) && (localFileManagerEntity.isZipInnerFile)) {
      return;
    }
    int i = paramActionSheetItem.action;
    if (i == 2)
    {
      FileOperaterUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, localFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity).onClick(null);
      ReportController.b(null, "dc00898", "", "", "0X800A3B8", "0X800A3B8", 0, 0, "", "", "", "");
      return;
    }
    if (i == 27)
    {
      FileOperaterUtils.a(localFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, str).onClick(null);
      ReportController.b(null, "dc00898", "", "", "0X800A3B9", "0X800A3B9", 0, 0, "", "", "", "");
      return;
    }
    if (i == 6)
    {
      FileOperaterUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, localFileManagerEntity).onClick(null);
      ReportController.b(null, "dc00898", "", "", "0X800A3BA", "0X800A3BA", 0, 0, "", "", "", "");
      return;
    }
    if (i == 132)
    {
      QbSdk.clearDefaultBrowser(this.jdField_a_of_type_AndroidAppActivity, d());
      FileManagerUtil.a(this.jdField_a_of_type_AndroidAppActivity, d());
      ReportController.b(null, "dc00898", "", "", "0X800AFCB", "0X800AFCB", 0, 0, "", "", "", "");
    }
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    String str = d();
    boolean bool1 = FileUtil.a(str);
    if ((localObject3 == null) && (TextUtils.isEmpty(str))) {
      return null;
    }
    if (b() == 16) {
      return null;
    }
    if ((!bool1) && (localObject3 != null) && (((FileManagerEntity)localObject3).isZipInnerFile)) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2;
    if (bool1)
    {
      Object localObject1 = localObject3;
      if (localObject3 == null) {
        try
        {
          localObject1 = FileManagerUtil.a(new FileInfo(str));
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          localFileNotFoundException.printStackTrace();
          localObject2 = localObject3;
        }
      }
      localObject3 = QFileUtils.a(2, null);
    }
    else
    {
      localObject4 = QFileUtils.a(2, null);
      localObject2 = localObject3;
      localObject3 = localObject4;
    }
    localArrayList1.add(localObject3);
    int i;
    if ((localObject2 != null) && (!TextUtils.isEmpty(localObject2.WeiYunFileId)) && (!TextUtils.isEmpty(localObject2.WeiYunDirKey))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      if (bool1) {
        localObject3 = QFileUtils.a(27, null);
      } else if (d() == 1) {
        localObject3 = QFileUtils.a(27, null);
      }
      localArrayList1.add(localObject3);
    }
    localObject3 = WXShareHelper.a();
    if ((bool1) && (((WXShareHelper)localObject3).a()) && (((WXShareHelper)localObject3).d())) {
      localArrayList1.add(QFileUtils.a(9, FileOperaterUtils.b(this.jdField_a_of_type_AndroidAppActivity, str)));
    }
    if (bool1) {
      localArrayList1.add(QFileUtils.a(64, FileOperaterUtils.a(this.jdField_a_of_type_AndroidAppActivity, str)));
    }
    if (FileManagerUtil.d(localObject2)) {
      localArrayList2.add(QFileUtils.a(6, null));
    }
    boolean bool2 = TencentDocConvertConfigProcessor.a().d();
    long l = FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    Object localObject4 = TencentDocImportFileInfoProcessor.a().c();
    localObject3 = localObject4;
    if (TextUtils.isEmpty((CharSequence)localObject4)) {
      localObject3 = ".doc|.docx|.xls|.xlsx|";
    }
    if ((bool2) && (localObject2 != null) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsSupport(localObject2.getFilePath(), localObject2.fileName, (String)localObject3)) && (localObject2.fileSize <= l))
    {
      localObject3 = QFileUtils.a(119, FileOperaterUtils.a(localObject2, this.jdField_a_of_type_AndroidAppActivity));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
      localArrayList2.add(localObject3);
    }
    if (LinkUtils.a(localObject2, bool1))
    {
      localArrayList2.add(QFileUtils.a(122, FileOperaterUtils.a(this.jdField_a_of_type_AndroidAppActivity, localObject2, str)));
      localArrayList2.add(QFileUtils.a(123, FileOperaterUtils.b(this.jdField_a_of_type_AndroidAppActivity, localObject2, str)));
    }
    if (bool1)
    {
      if (((DataLineHandler)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a.a(c()))
      {
        l = 0L;
        if (localObject2 != null) {
          l = localObject2.nSessionId;
        }
        localArrayList2.add(QFileUtils.a(121, FileOperaterUtils.b(l, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, d())));
      }
      if (QbSdk.isInDefaultBrowser(this.jdField_a_of_type_AndroidAppActivity, str))
      {
        localArrayList2.add(QFileUtils.a(132, null));
        ReportController.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
      }
    }
    return new ArrayList[] { localArrayList1, localArrayList2 };
  }
  
  protected void b()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    TeamWorkExportObserver localTeamWorkExportObserver = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkExportObserver;
    if ((localTeamWorkExportObserver != null) && (localObject != null)) {
      ((QQAppInterface)localObject).removeObserver(localTeamWorkExportObserver);
    }
    localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localObject != null)
    {
      ((MqqHandler)localObject).removeMessages(8001);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(8002);
    }
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(8001, this.c);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(8002, this.d);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 8001)
    {
      if (i == 8002) {
        a(HardCodeUtil.a(2131703561), "");
      }
    }
    else
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if ((paramMessage != null) && (paramMessage.fProgress <= 45.0F))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null)
        {
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
          paramMessage.fProgress += 5.0F;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress);
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(8001, this.c);
      }
      else
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(8001);
      }
    }
    return true;
  }
  
  public int i()
  {
    int i = super.i();
    if (g() == 10) {
      i = 6;
    }
    return i;
  }
  
  public void i()
  {
    super.i();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (d() == 1)
    {
      if (f() == 3000)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new DiscOfflinePreviewController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.Uuid, localFileManagerEntity.peerUin));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new OfflinePreviewController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.Uuid, localFileManagerEntity.fileIdCrc));
    }
  }
  
  public boolean i()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.model.DocsExportFileModel
 * JD-Core Version:    0.7.0.1
 */