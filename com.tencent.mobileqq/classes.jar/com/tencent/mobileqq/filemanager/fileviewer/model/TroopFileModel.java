package com.tencent.mobileqq.filemanager.fileviewer.model;

import addm;
import addo;
import addq;
import addr;
import adds;
import addt;
import addu;
import addv;
import addw;
import addy;
import android.app.Activity;
import android.content.SharedPreferences;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqDownloadFileObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.DownloadFileConfig;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopFileVideoOnlinePlayManager;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IThumbController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.data.TroopImageInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter.MenuData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.troop.data.TroopFilePreviewController;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorObserver;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopFileModel
  extends DefaultFileModel
{
  private TroopFileProtocol.ReqDownloadFileObserver jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqDownloadFileObserver;
  private BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver;
  private TroopFileError.TroopFileErrorObserver jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver;
  private int b;
  private String f;
  
  public TroopFileModel(Activity paramActivity, List paramList, int paramInt)
  {
    super(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileModel<FileAssistant>", 1, "FileBrowserModel init: type = troop");
    }
    a(paramList, paramInt);
  }
  
  private void a(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new addv(this, paramTroopFileStatusInfo));
  }
  
  public int a()
  {
    int j = 7;
    int k = e();
    int i = super.a();
    if (i != 0) {}
    do
    {
      do
      {
        return i;
        switch (k)
        {
        case 1: 
        case 3: 
        default: 
          return 7;
        case 0: 
          return 6;
        case 4: 
          i = j;
        }
      } while (!FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter));
      i = j;
    } while (!FileManagerUtil.a(this.jdField_a_of_type_AndroidAppActivity, a(), b()));
    return 5;
    return 8;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().TroopUin;
    }
    return super.a();
  }
  
  public IDownloadController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController = new addu(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController;
  }
  
  public IThumbController a()
  {
    return new addr(this);
  }
  
  public IUploadController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIUploadController == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIUploadController = new addt(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIUploadController;
  }
  
  public ArrayList a()
  {
    int i = d();
    if ((i == 5) || (i == 4))
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      if ((localFileManagerEntity == null) || (localFileManagerEntity.isZipInnerFile)) {}
      while (localFileManagerEntity.status == 16) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(HorizontalListViewAdapter.a(2130841599, "存到微云", FileOperaterUtils.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, localFileManagerEntity)));
      localArrayList.add(HorizontalListViewAdapter.a(2130841595, "发给好友", FileOperaterUtils.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, localFileManagerEntity)));
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("tim_convert_teamwork_pre_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 4).getBoolean("tim_convert_teamwork_show_file_viewer_menu", false)) && (TeamWorkUtils.a(localFileManagerEntity.strFilePath, localFileManagerEntity.fileName)))
      {
        HorizontalListViewAdapter.MenuData localMenuData = HorizontalListViewAdapter.a(2130837536, "在线编辑", FileOperaterUtils.a(localFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
        localArrayList.add(localMenuData);
      }
      if (FileManagerUtil.c(localFileManagerEntity)) {
        localArrayList.add(HorizontalListViewAdapter.a(2130841573, "收藏", FileOperaterUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, localFileManagerEntity)));
      }
      return localArrayList;
    }
    return super.a();
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new TroopImageInfo((IFileViewerAdapter)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    Object localObject;
    String str;
    if (paramInt == 6)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      if (localObject != null)
      {
        str = String.valueOf(((FileManagerEntity)localObject).TroopUin);
        if (localObject == null) {
          break label79;
        }
        localObject = FileManagerUtil.b(((FileManagerEntity)localObject).nFileType);
        label45:
        ReportController.b(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, str, "", (String)localObject, "1");
      }
    }
    label79:
    do
    {
      return;
      str = "";
      break;
      localObject = "unknow";
      break label45;
      if (paramInt == 4)
      {
        if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {}
        for (str = "0";; str = "-1")
        {
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", str, "-1", "-1");
          return;
        }
      }
    } while (paramInt != 8);
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "video_file_preview", 0, 0, "", "", "", "");
  }
  
  public void a(FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener)
  {
    if (this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqDownloadFileObserver == null) {
      this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqDownloadFileObserver = new addy(this, paramOnPreviewVideoOnlineListener);
    }
    ThreadManager.post(new addo(this, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a(), paramOnPreviewVideoOnlineListener), 8, null, true);
  }
  
  public boolean a(FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localTroopManager == null) {}
    TroopInfo localTroopInfo;
    do
    {
      return false;
      localTroopInfo = localTroopManager.a(String.valueOf(localFileManagerEntity.TroopUin));
    } while (localTroopInfo == null);
    if (NetConnInfoCenter.getServerTimeMillis() <= localTroopInfo.mTroopFileVideoReqInterval)
    {
      if (localTroopInfo.mTroopFileVideoIsWhite != 0)
      {
        if (paramOnPreviewVideoOnlineListener != null) {
          paramOnPreviewVideoOnlineListener.ac_();
        }
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "0", "", "", "");
        return true;
      }
      if (paramOnPreviewVideoOnlineListener != null) {
        paramOnPreviewVideoOnlineListener.ad_();
      }
      if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {}
      for (paramOnPreviewVideoOnlineListener = "0";; paramOnPreviewVideoOnlineListener = "-1")
      {
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", paramOnPreviewVideoOnlineListener, "-1", "-1");
        break;
      }
    }
    TroopFileVideoOnlinePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, new addw(this, paramOnPreviewVideoOnlineListener, localTroopInfo, localTroopManager));
    return true;
  }
  
  public int b()
  {
    int j = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    int k = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity).b;
    int i;
    if ((k == 3) || (k == 2) || (k == 10) || (k == 9)) {
      i = 3;
    }
    do
    {
      do
      {
        return i;
        if ((k == 8) || (k == 1) || (k == 4)) {
          return 2;
        }
        i = j;
      } while (k == 6);
      i = j;
    } while (k == 11);
    if (k == 12) {
      return 16;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileModel<FileAssistant>", 2, "TroopFileModel getFileStatus : troopFileStatus[" + k + "] can not change troop file status to FMConstants status");
    }
    return super.b();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null) {}
    QQAppInterface localQQAppInterface;
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new adds(this);
        if (QLog.isDevelopLevel()) {
          QLog.i("fobserver<FileAssistant>", 1, "add troopObserver");
        }
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null);
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    } while (localFileManagerEntity == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = new TroopFileError.TroopFileErrorObserver(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity.TroopUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    TroopFileError.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
  }
  
  public String c()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    StringBuilder localStringBuilder = new StringBuilder(FileUtil.a(b()));
    if ((104 == localFileManagerEntity.busId) && (localFileManagerEntity.lastTime > 0L))
    {
      localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131428143));
      localStringBuilder.append(TroopFileUtils.a(BaseApplicationImpl.getContext(), localFileManagerEntity.lastTime));
    }
    return localStringBuilder.toString();
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del troopObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null) {
      TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = null;
    this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqDownloadFileObserver = null;
  }
  
  public void f()
  {
    TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().TroopUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().strTroopFilePath, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().busId, new addm(this));
    TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().TroopUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().busId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().strTroopFilePath, new addq(this));
  }
  
  public int h()
  {
    int i = 2;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    int j = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity).b;
    if ((j == 3) || (j == 2) || (j == 1)) {
      i = 1;
    }
    return i;
  }
  
  public boolean h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      int i;
      do
      {
        return false;
        i = i();
        if ((i != 5) && (i != 2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("TroopFileModel<FileAssistant>", 2, "can not auto download file : [fileStatus] = " + i);
      return false;
    } while (!NetworkUtil.e(BaseApplicationImpl.getContext()));
    TroopManager.DownloadFileConfig localDownloadFileConfig = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(HWTroopUtils.a(a()));
    long l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b();
    if (((NetworkUtil.h(BaseApplicationImpl.getContext())) && (l <= localDownloadFileConfig.a)) || (l <= localDownloadFileConfig.c)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void i()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    super.i();
    if (d() == 4)
    {
      TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new TroopFilePreviewController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, localTroopFileStatusInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel
 * JD-Core Version:    0.7.0.1
 */