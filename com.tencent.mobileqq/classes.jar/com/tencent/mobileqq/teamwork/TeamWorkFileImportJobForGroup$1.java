package com.tencent.mobileqq.teamwork;

import android.os.Bundle;
import com.tencent.biz.troop.file.protocol.TroopFileReqDownloadFileObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

class TeamWorkFileImportJobForGroup$1
  extends TroopFileReqDownloadFileObserver
{
  TeamWorkFileImportJobForGroup$1(TeamWorkFileImportJobForGroup paramTeamWorkFileImportJobForGroup) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    JSONObject localJSONObject = new JSONObject();
    int i = 0;
    if (paramBoolean) {
      if (paramDownloadFileRspBody != null)
      {
        paramInt = paramDownloadFileRspBody.int32_ret_code.get();
        if (paramInt != 0) {
          break label333;
        }
        String str = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
        paramBundle = str;
        if (str != null) {
          paramBundle = str.toLowerCase();
        }
        str = paramDownloadFileRspBody.str_download_ip.get();
        paramDownloadFileRspBody = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("---onReqDownloadFileResult success ,ip: ");
          localStringBuilder.append(str);
          localStringBuilder.append(",param: ");
          localStringBuilder.append(paramDownloadFileRspBody);
          QLog.i("TeamWorkFileImportJobForGroup", 2, localStringBuilder.toString());
        }
        StringBuilder localStringBuilder = new StringBuilder("http://");
        localStringBuilder.append(str);
        localStringBuilder.append("/ftn_handler/");
        localStringBuilder.append(paramDownloadFileRspBody);
        localStringBuilder.append("/?fname=");
        localStringBuilder.append(HexUtil.string2HexString(this.a.b.g));
        try
        {
          paramDownloadFileRspBody = new JSONArray();
          paramDownloadFileRspBody.put(0, localStringBuilder.toString());
          localJSONObject.put("urls", paramDownloadFileRspBody);
          localJSONObject.put("filename", this.a.b.c);
          paramDownloadFileRspBody = new StringBuilder();
          paramDownloadFileRspBody.append("FTN5K=");
          paramDownloadFileRspBody.append(paramBundle);
          localJSONObject.put("cookie", paramDownloadFileRspBody.toString());
          paramInt = 1;
        }
        catch (Exception paramDownloadFileRspBody)
        {
          paramBundle = new StringBuilder();
          paramBundle.append("onReqDownloadFileResult json exception: ");
          paramBundle.append(paramDownloadFileRspBody.toString());
          QLog.e("TeamWorkFileImportJobForGroup", 1, paramBundle.toString());
        }
      }
    }
    for (;;)
    {
      paramInt = 0;
      break;
      label333:
      paramDownloadFileRspBody = new StringBuilder();
      paramDownloadFileRspBody.append("onReqDownloadFileResult retCode: ");
      paramDownloadFileRspBody.append(paramInt);
      QLog.e("TeamWorkFileImportJobForGroup", 1, paramDownloadFileRspBody.toString());
      continue;
      paramDownloadFileRspBody = new StringBuilder();
      paramDownloadFileRspBody.append("onReqDownloadFileResult errorCode: ");
      paramDownloadFileRspBody.append(paramInt);
      QLog.e("TeamWorkFileImportJobForGroup", 1, paramDownloadFileRspBody.toString());
    }
    if (paramInt == 0) {}
    try
    {
      localJSONObject.put("filename", this.a.b.c);
      localJSONObject.put("filetype", 3);
      localJSONObject.put("fileid", this.a.b.g);
      localJSONObject.put("businesstype", this.a.b.h);
      localJSONObject.put("groupuin", Long.valueOf(this.a.b.b));
      localJSONObject.put("importoption", this.a.b.B);
      if (this.a.a != null)
      {
        localJSONObject.put("md5", this.a.a.strFileMd5);
        localJSONObject.put("sha", this.a.a.strFileSHA);
      }
      localJSONObject.put("filesize", this.a.b.K);
      this.a.b.D = this.a.b.g;
      this.a.b.E = 3;
      i = 1;
    }
    catch (Exception paramDownloadFileRspBody)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("put fileid exception: ");
      paramBundle.append(paramDownloadFileRspBody.toString());
      QLog.e("TeamWorkFileImportJobForGroup", 2, paramBundle.toString());
    }
    if (((i != 0) || (paramInt != 0)) && (TeamWorkConvertUtils.a(localJSONObject)) && (TeamWorkFileImportJobForGroup.a(this.a, localJSONObject)))
    {
      this.a.c.fileImportFromUrl(localJSONObject, this.a.b, this.a.hashCode());
      return;
    }
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForGroup.1
 * JD-Core Version:    0.7.0.1
 */