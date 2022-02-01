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
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnPreviewVideoOnlineListener != null)
    {
      if (paramInt1 == 0) {
        break label144;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnPreviewVideoOnlineListener.au_();
    }
    while (paramInt1 != 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnPreviewVideoOnlineListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnPreviewVideoOnlineListener.au_();
      }
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "0", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mTroopFileVideoIsWhite = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mTroopFileVideoReqInterval = (System.currentTimeMillis() + paramInt2 * 1000);
      ThreadManager.post(new TroopFileModel.13.1(this), 5, null, true);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "OfflineVideoFileView initVarView() is_white = " + paramInt1 + ", req_interval = " + paramInt2);
      }
      return;
      label144:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnPreviewVideoOnlineListener.av_();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnPreviewVideoOnlineListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnPreviewVideoOnlineListener.av_();
    }
    if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {}
    for (String str = "0";; str = "-1")
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", str, "-1", "-1");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.13
 * JD-Core Version:    0.7.0.1
 */