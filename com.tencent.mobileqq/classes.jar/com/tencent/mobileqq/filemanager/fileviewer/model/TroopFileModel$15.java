package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.protocol.TroopFileGetFilePreviewObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;

class TroopFileModel$15
  extends TroopFileGetFilePreviewObserver
{
  TroopFileModel$15(TroopFileModel paramTroopFileModel) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, ByteStringMicro paramByteStringMicro1, String paramString4, ByteStringMicro paramByteStringMicro2, Bundle paramBundle)
  {
    paramString1 = this.a.c.r();
    paramString2 = FileManagerUtil.a(paramByteStringMicro1);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString2)))
    {
      paramInt1 = paramString1.zipType;
      paramByteStringMicro1 = new StringBuilder();
      paramByteStringMicro1.append("http://");
      paramByteStringMicro1.append(paramString3);
      paramByteStringMicro1.append(":");
      paramByteStringMicro1.append(paramInt3);
      paramByteStringMicro1.append("/ftn_compress_getfile/rkey=");
      paramByteStringMicro1.append(paramString2);
      paramByteStringMicro1.append("&filetype=");
      paramByteStringMicro1.append(paramInt1);
      paramByteStringMicro1.append("&path=");
      paramByteStringMicro1.append(URLUtil.c(paramString1.zipInnerPath));
      paramByteStringMicro1.append("&");
      paramString1 = paramByteStringMicro1.toString();
    }
    else
    {
      paramString1 = null;
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("url = ");
        paramString2.append(paramString1);
        paramString2.append(", cookies = ");
        paramString2.append(paramString4);
        QLog.e("TroopFileModel<FileAssistant>", 1, paramString2.toString());
      }
      if (TroopFileModel.e(this.a) != null) {
        TroopFileModel.e(this.a).a(paramString1, paramString4);
      }
      if (this.a.c.r() != null) {
        paramString1 = String.valueOf(this.a.c.r().TroopUin);
      } else {
        paramString1 = "";
      }
      if (this.a.c.r() != null) {
        paramString2 = FileManagerUtil.b(this.a.c.r().nFileType);
      } else {
        paramString2 = "unknow";
      }
      ReportController.b(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, paramString1, "", paramString2, "1");
      return;
    }
    QLog.i("TroopFileModel<FileAssistant>", 1, "requestOnlinePreviewDownloadUrl_onGetFilePreviewResult error, url is null.");
    if (TroopFileModel.e(this.a) != null) {
      TroopFileModel.e(this.a).cq_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.15
 * JD-Core Version:    0.7.0.1
 */