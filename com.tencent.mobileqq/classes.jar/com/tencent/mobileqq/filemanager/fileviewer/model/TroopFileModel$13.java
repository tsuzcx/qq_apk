package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopFileVideoOnlinePlayManager.TroopFileWhiteListCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsVideo;

class TroopFileModel$13
  implements TroopFileVideoOnlinePlayManager.TroopFileWhiteListCallback
{
  TroopFileModel$13(TroopFileModel paramTroopFileModel, FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener, TroopInfo paramTroopInfo, TroopManager paramTroopManager) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnPreviewVideoOnlineListener;
    if (localObject != null) {
      if (paramInt1 != 0) {
        ((FileBrowserModelBase.OnPreviewVideoOnlineListener)localObject).am_();
      } else {
        ((FileBrowserModelBase.OnPreviewVideoOnlineListener)localObject).an_();
      }
    }
    if (paramInt1 != 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnPreviewVideoOnlineListener;
      if (localObject != null) {
        ((FileBrowserModelBase.OnPreviewVideoOnlineListener)localObject).am_();
      }
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "0", "", "", "");
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnPreviewVideoOnlineListener;
      if (localObject != null) {
        ((FileBrowserModelBase.OnPreviewVideoOnlineListener)localObject).an_();
      }
      if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {
        localObject = "0";
      } else {
        localObject = "-1";
      }
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", (String)localObject, "-1", "-1");
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    ((TroopInfo)localObject).mTroopFileVideoIsWhite = paramInt1;
    ((TroopInfo)localObject).mTroopFileVideoReqInterval = (System.currentTimeMillis() + paramInt2 * 1000);
    ThreadManager.post(new TroopFileModel.13.1(this), 5, null, true);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OfflineVideoFileView initVarView() is_white = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", req_interval = ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("zivonchen", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.13
 * JD-Core Version:    0.7.0.1
 */