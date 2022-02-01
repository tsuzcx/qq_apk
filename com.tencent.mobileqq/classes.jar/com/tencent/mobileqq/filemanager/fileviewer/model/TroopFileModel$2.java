package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.biz.troop.file.protocol.TroopFileGetOneFileInfoObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;

class TroopFileModel$2
  extends TroopFileGetOneFileInfoObserver
{
  TroopFileModel$2(TroopFileModel paramTroopFileModel) {}
  
  public void a(boolean paramBoolean, int paramInt, group_file_common.FileInfo paramFileInfo)
  {
    if (paramFileInfo != null)
    {
      String str = ContactUtils.g(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().TroopUin), paramFileInfo.uint64_uploader_uin.get() + "");
      paramFileInfo = new Date(paramFileInfo.uint32_upload_time.get() * 1000L);
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
      paramFileInfo = " 于" + localSimpleDateFormat.format(paramFileInfo) + "上传";
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener.b(str, paramFileInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.2
 * JD-Core Version:    0.7.0.1
 */