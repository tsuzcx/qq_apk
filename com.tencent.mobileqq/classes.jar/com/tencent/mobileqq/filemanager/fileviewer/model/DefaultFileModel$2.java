package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol.OnGetZipFileList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.FileData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class DefaultFileModel$2
  implements HttpWebCgiAsyncTask.Callback
{
  DefaultFileModel$2(DefaultFileModel paramDefaultFileModel, List paramList, String paramString1, FileManagerEntity paramFileManagerEntity, boolean paramBoolean1, String paramString2, boolean paramBoolean2, String paramString3, String paramString4, short paramShort, String paramString5, int paramInt, String paramString6, TroopFileProtocol.OnGetZipFileList paramOnGetZipFileList) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.a.clear();
    int i1 = 0;
    if (paramJSONObject != null) {}
    try
    {
      ZipFilePresenter.FileData localFileData;
      if (!paramJSONObject.isNull("dirs"))
      {
        paramBundle = paramJSONObject.getJSONArray("dirs");
        paramInt = 0;
        while (paramInt < paramBundle.length())
        {
          localFileData = new ZipFilePresenter.FileData();
          localFileData.a = true;
          localFileData.c = paramBundle.getString(paramInt);
          this.a.add(localFileData);
          paramInt += 1;
        }
      }
      if ((paramJSONObject == null) || (paramJSONObject.isNull("files"))) {
        break label891;
      }
      paramBundle = paramJSONObject.getJSONArray("files");
      paramInt = i1;
      while (paramInt < paramBundle.length())
      {
        localFileData = new ZipFilePresenter.FileData();
        paramJSONObject = paramBundle.getJSONObject(paramInt);
        localFileData.c = paramJSONObject.getString("filename");
        localFileData.b = paramJSONObject.getLong("size");
        if (this.b.equals("/"))
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("/");
          paramJSONObject.append(localFileData.c);
        }
        for (;;)
        {
          paramJSONObject = paramJSONObject.toString();
          break;
          paramJSONObject = new StringBuilder();
          paramJSONObject.append(this.b);
          paramJSONObject.append("/");
          paramJSONObject.append(localFileData.c);
        }
        FileManagerEntity localFileManagerEntity = new FileManagerEntity();
        localFileManagerEntity.fileName = localFileData.c;
        localFileManagerEntity.fileSize = localFileData.b;
        localFileManagerEntity.nRelatedSessionId = this.c.nSessionId;
        localFileManagerEntity.mContext = this.c.Uuid;
        localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
        if (this.d)
        {
          localFileManagerEntity.WeiYunFileId = this.e;
          localFileManagerEntity.mContext = this.c.WeiYunFileId;
          localFileManagerEntity.nRelatedSessionId = FileManagerUtil.d(this.c.fileSize);
        }
        localFileManagerEntity.zipFileId = this.c.WeiYunFileId;
        StringBuilder localStringBuilder;
        if (localFileManagerEntity.mContext == null)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("zip list file content is empty. zipSessionId[");
          localStringBuilder.append(this.c.nSessionId);
          localStringBuilder.append("] zipIsWeiyunFile[");
          localStringBuilder.append(this.d);
          localStringBuilder.append("] zipCouldType[");
          localStringBuilder.append(this.c.cloudType);
          localStringBuilder.append("] fileSessionId[");
          localStringBuilder.append(localFileManagerEntity.nSessionId);
          localStringBuilder.append("]");
          QLog.i("FileBrowserModelBase", 1, localStringBuilder.toString());
        }
        boolean bool = this.d;
        if ((!bool) && (this.f) && (!TextUtils.isEmpty(this.g)))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("https://");
          localStringBuilder.append(this.h);
          localStringBuilder.append(":");
          localStringBuilder.append(this.i);
          localStringBuilder.append("/ftn_compress_getfile/rkey=");
          localStringBuilder.append(this.j);
          localStringBuilder.append("&filetype=");
          localStringBuilder.append(this.k);
          localStringBuilder.append("&path=");
          localStringBuilder.append(URLUtil.c(paramJSONObject));
          localStringBuilder.append("&");
          localFileManagerEntity.strServerPath = localStringBuilder.toString();
          localFileManagerEntity.httpsDomain = this.g;
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("http://");
          localStringBuilder.append(this.h);
          localStringBuilder.append(":");
          localStringBuilder.append(this.l);
          localStringBuilder.append("/ftn_compress_getfile/rkey=");
          localStringBuilder.append(this.j);
          localStringBuilder.append("&filetype=");
          localStringBuilder.append(this.k);
          localStringBuilder.append("&path=");
          localStringBuilder.append(URLUtil.c(paramJSONObject));
          localStringBuilder.append("&");
          localFileManagerEntity.strServerPath = localStringBuilder.toString();
        }
        localFileManagerEntity.zipInnerPath = paramJSONObject;
        localFileManagerEntity.selfUin = this.c.selfUin;
        localFileManagerEntity.peerUin = this.c.peerUin;
        localFileManagerEntity.peerType = this.c.peerType;
        localFileManagerEntity.busId = this.c.busId;
        localFileManagerEntity.cloudType = 1;
        localFileManagerEntity.isZipInnerFile = true;
        localFileManagerEntity.zipFilePath = this.c.strTroopFilePath;
        localFileManagerEntity.zipType = this.k;
        localFileManagerEntity.TroopUin = this.c.TroopUin;
        localFileData.d = localFileManagerEntity.nSessionId;
        this.n.a.getFileManagerProxy().a(localFileManagerEntity);
        this.a.add(localFileData);
        paramInt += 1;
      }
    }
    catch (JSONException paramJSONObject)
    {
      label887:
      label891:
      break label887;
    }
    paramJSONObject.printStackTrace();
    paramJSONObject = this.m;
    if (paramJSONObject != null) {
      paramJSONObject.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel.2
 * JD-Core Version:    0.7.0.1
 */