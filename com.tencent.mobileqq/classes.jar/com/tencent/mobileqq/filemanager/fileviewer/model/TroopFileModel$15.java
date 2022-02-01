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
    paramByteStringMicro2 = this.a.a.a();
    paramByteStringMicro1 = FileManagerUtil.a(paramByteStringMicro1);
    paramString2 = null;
    paramString1 = paramString2;
    if (paramBoolean)
    {
      paramString1 = paramString2;
      if (!TextUtils.isEmpty(paramByteStringMicro1))
      {
        paramInt1 = paramByteStringMicro2.zipType;
        paramString1 = "http://" + paramString3 + ":" + paramInt3 + "/ftn_compress_getfile/rkey=" + paramByteStringMicro1 + "&filetype=" + paramInt1 + "&path=" + URLUtil.a(paramByteStringMicro2.zipInnerPath) + "&";
      }
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopFileModel<FileAssistant>", 1, "url = " + paramString1 + ", cookies = " + paramString4);
      }
      if (TroopFileModel.a(this.a) != null) {
        TroopFileModel.a(this.a).a(paramString1, paramString4);
      }
      if (this.a.a.a() != null)
      {
        paramString1 = String.valueOf(this.a.a.a().TroopUin);
        if (this.a.a.a() == null) {
          break label291;
        }
        paramString2 = FileManagerUtil.b(this.a.a.a().nFileType);
        label261:
        ReportController.b(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, paramString1, "", paramString2, "1");
      }
    }
    label291:
    do
    {
      return;
      paramString1 = "";
      break;
      paramString2 = "unknow";
      break label261;
      QLog.i("TroopFileModel<FileAssistant>", 1, "requestOnlinePreviewDownloadUrl_onGetFilePreviewResult error, url is null.");
    } while (TroopFileModel.a(this.a) == null);
    TroopFileModel.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.15
 * JD-Core Version:    0.7.0.1
 */