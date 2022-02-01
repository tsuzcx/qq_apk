package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.biz.troop.file.protocol.TroopFileGetOneFileInfoObserver;
import com.tencent.common.app.AppInterface;
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
  
  protected void a(boolean paramBoolean, int paramInt, group_file_common.FileInfo paramFileInfo)
  {
    if (paramFileInfo != null)
    {
      Object localObject1 = this.a.a;
      long l = this.a.c.r().TroopUin;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramFileInfo.uint64_uploader_uin.get());
      ((StringBuilder)localObject2).append("");
      localObject1 = ContactUtils.b((AppInterface)localObject1, String.valueOf(l), ((StringBuilder)localObject2).toString());
      paramFileInfo = new Date(paramFileInfo.uint32_upload_time.get() * 1000L);
      localObject2 = new SimpleDateFormat("yyyy.MM.dd");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" 于");
      localStringBuilder.append(((SimpleDateFormat)localObject2).format(paramFileInfo));
      localStringBuilder.append("上传");
      paramFileInfo = localStringBuilder.toString();
      if (this.a.n != null) {
        this.a.n.b((String)localObject1, paramFileInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.2
 * JD-Core Version:    0.7.0.1
 */