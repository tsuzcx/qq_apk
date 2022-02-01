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
  public long A = 0L;
  private TeamWorkExportObserver B;
  private MqqHandler C;
  private int D = 1000;
  private int E = 60000;
  private FileManagerEntity F;
  public long z = 0L;
  
  public DocsExportFileModel(QQAppInterface paramQQAppInterface, Activity paramActivity, List<IFileViewerAdapter> paramList, int paramInt)
  {
    super(paramQQAppInterface, paramActivity);
    a(paramList, paramInt);
    this.F = this.c.r();
    this.C = new MqqHandler(Looper.getMainLooper(), this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if ((localQQAppInterface != null) && (paramString2 != null))
    {
      FileManagerEntity localFileManagerEntity = this.F;
      if (localFileManagerEntity != null) {
        ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009956", "0X8009956", 0, 2, "", "", TeamWorkExportUtil.a(localFileManagerEntity.nFileType), paramString2);
      }
    }
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = HardCodeUtil.a(2131901509);
    }
    QQToast.makeText(this.i, 1, paramString2, 0).show();
    g();
    this.i.finish();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.A = System.currentTimeMillis();
    this.C.removeMessages(8001);
    this.C.removeMessages(8002);
    this.C.post(new DocsExportFileModel.2(this));
    ((ITeamWorkFileExportHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_EXPORT_HANDLER)).fileExportDownloadRequest(paramString1, paramString2, paramString3, paramString4);
  }
  
  public boolean P()
  {
    return true;
  }
  
  public int R()
  {
    int i = super.R();
    if (L() == 10) {
      i = 6;
    }
    return i;
  }
  
  public int a()
  {
    return 10;
  }
  
  public void a(FileBrowserModelBase.OnTransEventListener paramOnTransEventListener)
  {
    super.a(paramOnTransEventListener);
    if ((this.u != null) && (this.u.containsKey("isSuccess")))
    {
      boolean bool = this.u.getBoolean("isSuccess");
      paramOnTransEventListener = this.u.getString("docUrl");
      if (bool) {
        a(this.u.getString("url"), this.u.getString("fileName"), paramOnTransEventListener, this.u.getString("cookie"));
      } else {
        a(HardCodeUtil.a(2131912091), paramOnTransEventListener);
      }
      this.u.remove("isSuccess");
    }
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = this.c.r();
    String str = y();
    boolean bool = FileUtil.b(str);
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
      FileOperaterUtils.a(this.k, localFileManagerEntity, this.i).onClick(null);
      ReportController.b(null, "dc00898", "", "", "0X800A3B8", "0X800A3B8", 0, 0, "", "", "", "");
      return;
    }
    if (i == 27)
    {
      FileOperaterUtils.a(localFileManagerEntity.nSessionId, this.k, str).onClick(null);
      ReportController.b(null, "dc00898", "", "", "0X800A3B9", "0X800A3B9", 0, 0, "", "", "", "");
      return;
    }
    if (i == 6)
    {
      FileOperaterUtils.b(this.k, localFileManagerEntity).onClick(null);
      ReportController.b(null, "dc00898", "", "", "0X800A3BA", "0X800A3BA", 0, 0, "", "", "", "");
      return;
    }
    if (i == 132)
    {
      QbSdk.clearDefaultBrowser(this.i, y());
      FileManagerUtil.a(this.i, y());
      ReportController.b(null, "dc00898", "", "", "0X800AFCB", "0X800AFCB", 0, 0, "", "", "", "");
    }
  }
  
  protected void c()
  {
    if (this.B != null) {
      return;
    }
    this.B = new DocsExportFileModel.1(this);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localQQAppInterface != null)
    {
      TeamWorkExportObserver localTeamWorkExportObserver = this.B;
      if (localTeamWorkExportObserver != null) {
        localQQAppInterface.addObserver(localTeamWorkExportObserver);
      }
    }
  }
  
  protected void d()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    TeamWorkExportObserver localTeamWorkExportObserver = this.B;
    if ((localTeamWorkExportObserver != null) && (localObject != null)) {
      ((QQAppInterface)localObject).removeObserver(localTeamWorkExportObserver);
    }
    localObject = this.C;
    if (localObject != null)
    {
      ((MqqHandler)localObject).removeMessages(8001);
      this.C.removeMessages(8002);
    }
  }
  
  public IUploadController e()
  {
    return null;
  }
  
  public IDownloadController f()
  {
    if (this.o == null) {
      this.o = new DocsExportFileModel.3(this);
    }
    return this.o;
  }
  
  public void g()
  {
    super.g();
  }
  
  public void h()
  {
    this.z = System.currentTimeMillis();
    this.C.sendEmptyMessageDelayed(8001, this.D);
    this.C.sendEmptyMessageDelayed(8002, this.E);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 8001)
    {
      if (i == 8002) {
        a(HardCodeUtil.a(2131901512), "");
      }
    }
    else
    {
      paramMessage = this.F;
      if ((paramMessage != null) && (paramMessage.fProgress <= 45.0F))
      {
        if (this.q != null)
        {
          paramMessage = this.F;
          paramMessage.fProgress += 5.0F;
          this.q.a(this.F.fProgress);
        }
        this.C.sendEmptyMessageDelayed(8001, this.D);
      }
      else
      {
        this.C.removeMessages(8001);
      }
    }
    return true;
  }
  
  public void i()
  {
    super.i();
    FileManagerEntity localFileManagerEntity = this.c.r();
    if (w() == 1)
    {
      if (B() == 3000)
      {
        this.a.getFileManagerDataCenter().a(new DiscOfflinePreviewController(this.a, localFileManagerEntity.Uuid, localFileManagerEntity.peerUin));
        return;
      }
      this.a.getFileManagerDataCenter().a(new OfflinePreviewController(this.a, localFileManagerEntity.Uuid, localFileManagerEntity.fileIdCrc));
    }
  }
  
  public Intent k()
  {
    return null;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] m()
  {
    Object localObject3 = this.c.r();
    String str = y();
    boolean bool1 = FileUtil.b(str);
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
      } else if (w() == 1) {
        localObject3 = QFileUtils.a(27, null);
      }
      localArrayList1.add(localObject3);
    }
    localObject3 = WXShareHelper.a();
    if ((bool1) && (((WXShareHelper)localObject3).b()) && (((WXShareHelper)localObject3).g())) {
      localArrayList1.add(QFileUtils.a(9, FileOperaterUtils.b(this.i, str)));
    }
    if (bool1) {
      localArrayList1.add(QFileUtils.a(64, FileOperaterUtils.a(this.i, str)));
    }
    if (FileManagerUtil.i(localObject2)) {
      localArrayList2.add(QFileUtils.a(6, null));
    }
    boolean bool2 = TencentDocConvertConfigProcessor.a().d();
    long l = FileManagerUtil.v(this.F.fileName);
    Object localObject4 = TencentDocImportFileInfoProcessor.a().d();
    localObject3 = localObject4;
    if (TextUtils.isEmpty((CharSequence)localObject4)) {
      localObject3 = ".doc|.docx|.xls|.xlsx|";
    }
    if ((bool2) && (localObject2 != null) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsSupport(localObject2.getFilePath(), localObject2.fileName, (String)localObject3)) && (localObject2.fileSize <= l))
    {
      localObject3 = QFileUtils.a(119, FileOperaterUtils.a(localObject2, this.i));
      ReportController.b(this.a, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
      localArrayList2.add(localObject3);
    }
    if (LinkUtils.a(localObject2, bool1))
    {
      localArrayList2.add(QFileUtils.a(122, FileOperaterUtils.a(this.i, localObject2, str)));
      localArrayList2.add(QFileUtils.a(123, FileOperaterUtils.b(this.i, localObject2, str)));
    }
    if (bool1)
    {
      if (((DataLineHandler)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).h.c(v()))
      {
        l = 0L;
        if (localObject2 != null) {
          l = localObject2.nSessionId;
        }
        localArrayList2.add(QFileUtils.a(121, FileOperaterUtils.b(l, this.k, y())));
      }
      if (QbSdk.isInDefaultBrowser(this.i, str))
      {
        localArrayList2.add(QFileUtils.a(132, null));
        ReportController.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
      }
    }
    return new ArrayList[] { localArrayList1, localArrayList2 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.model.DocsExportFileModel
 * JD-Core Version:    0.7.0.1
 */