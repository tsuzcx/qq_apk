package com.tencent.mobileqq.teamwork;

import android.os.Bundle;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class TeamWorkFileImportJobForC2C$1
  extends FileTransferObserver
{
  TeamWorkFileImportJobForC2C$1(TeamWorkFileImportJobForC2C paramTeamWorkFileImportJobForC2C) {}
  
  protected void a(boolean paramBoolean1, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle)
  {
    paramByteStringMicro = new JSONObject();
    int i = 0;
    if (paramBoolean1)
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("---onUpdateGetOfflineDownloadInfo retCode: ");
        paramList.append(paramLong1);
        paramList.append(",retMsg: ");
        paramList.append(paramString1);
        paramList.append(",strCookie: ");
        paramList.append(paramString2);
        paramList.append(",strIP: ");
        paramList.append(paramString3);
        paramList.append(",port: ");
        paramList.append(paramShort);
        QLog.i("TeamWorkFileImportJobForC2C", 2, paramList.toString());
      }
      paramString1 = new StringBuilder("http://");
      paramString1.append(paramString3);
      paramString1.append(":");
      paramString1.append(paramShort);
      paramString1.append(paramString4);
      if (paramBoolean2) {
        paramString1.append("&isthumb=0");
      }
      try
      {
        paramString3 = new JSONArray();
        paramString3.put(0, paramString1.toString());
        paramByteStringMicro.put("urls", paramString3);
        paramByteStringMicro.put("filename", paramString5);
        paramByteStringMicro.put("cookie", paramString2);
        paramByteStringMicro.put("bUseMediaPlatform", paramBoolean2);
        paramShort = 1;
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("onUpdateGetOfflineDownloadInfo exception: ");
        paramString2.append(paramString1.toString());
        QLog.e("TeamWorkFileImportJobForC2C", 2, paramString2.toString());
        paramShort = 0;
      }
    }
    else
    {
      paramString1 = new StringBuilder();
      paramString1.append("---onUpdateGetOfflineDownloadInfo retCode: ");
      paramString1.append(paramLong1);
      paramString1.append(",fileName: ");
      paramString1.append(paramString5);
      paramString1.append("----");
      QLog.e("TeamWorkFileImportJobForC2C", 1, paramString1.toString());
      paramShort = 0;
    }
    paramInt = i;
    try
    {
      if (this.a.a != null)
      {
        if (paramShort == 0) {
          paramByteStringMicro.put("filename", this.a.b.c);
        }
        paramByteStringMicro.put("filetype", 1);
        paramByteStringMicro.put("fileid", this.a.a.Uuid);
        paramByteStringMicro.put("md5", this.a.a.strFileMd5);
        paramByteStringMicro.put("sha", this.a.a.strFileSHA);
        paramByteStringMicro.put("filesize", this.a.a.fileSize);
        if (this.a.b.z != null) {
          paramByteStringMicro.put("senderuin", this.a.b.z);
        }
        this.a.b.D = this.a.a.Uuid;
        this.a.b.E = 1;
        paramBoolean1 = this.a.a.bSend;
        if (paramBoolean1) {
          paramByteStringMicro.put("ownertype", 1);
        } else {
          paramByteStringMicro.put("ownertype", 2);
        }
        paramByteStringMicro.put("importoption", this.a.b.B);
        paramInt = 1;
      }
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("put fileid exception: ");
      paramString2.append(paramString1.toString());
      QLog.e("TeamWorkFileImportJobForC2C", 2, paramString2.toString());
      paramInt = i;
    }
    if (((paramInt != 0) || (paramShort != 0)) && (TeamWorkConvertUtils.a(paramByteStringMicro)) && (TeamWorkFileImportJobForC2C.a(this.a, paramByteStringMicro)))
    {
      this.a.c.fileImportFromUrl(paramByteStringMicro, this.a.b, this.a.hashCode());
      return;
    }
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForC2C.1
 * JD-Core Version:    0.7.0.1
 */