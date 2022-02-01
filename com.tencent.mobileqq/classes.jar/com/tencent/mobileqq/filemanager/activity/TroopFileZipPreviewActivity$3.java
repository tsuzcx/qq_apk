package com.tencent.mobileqq.filemanager.activity;

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

class TroopFileZipPreviewActivity$3
  implements HttpWebCgiAsyncTask.Callback
{
  TroopFileZipPreviewActivity$3(TroopFileZipPreviewActivity paramTroopFileZipPreviewActivity, List paramList, String paramString1, FileManagerEntity paramFileManagerEntity, boolean paramBoolean1, String paramString2, boolean paramBoolean2, String paramString3, String paramString4, short paramShort, String paramString5, int paramInt, String paramString6, TroopFileProtocol.OnGetZipFileList paramOnGetZipFileList) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
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
          localFileData.jdField_a_of_type_Boolean = true;
          localFileData.jdField_a_of_type_JavaLangString = paramBundle.getString(paramInt);
          this.jdField_a_of_type_JavaUtilList.add(localFileData);
          paramInt += 1;
        }
      }
      if ((paramJSONObject == null) || (paramJSONObject.isNull("files"))) {
        break label903;
      }
      paramBundle = paramJSONObject.getJSONArray("files");
      paramInt = i;
      while (paramInt < paramBundle.length())
      {
        localFileData = new ZipFilePresenter.FileData();
        paramJSONObject = paramBundle.getJSONObject(paramInt);
        localFileData.jdField_a_of_type_JavaLangString = paramJSONObject.getString("filename");
        localFileData.jdField_a_of_type_Long = paramJSONObject.getLong("size");
        if (this.jdField_a_of_type_JavaLangString.equals("/"))
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("/");
          paramJSONObject.append(localFileData.jdField_a_of_type_JavaLangString);
        }
        for (;;)
        {
          paramJSONObject = paramJSONObject.toString();
          break;
          paramJSONObject = new StringBuilder();
          paramJSONObject.append(this.jdField_a_of_type_JavaLangString);
          paramJSONObject.append("/");
          paramJSONObject.append(localFileData.jdField_a_of_type_JavaLangString);
        }
        FileManagerEntity localFileManagerEntity = new FileManagerEntity();
        localFileManagerEntity.fileName = localFileData.jdField_a_of_type_JavaLangString;
        localFileManagerEntity.nRelatedSessionId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
        localFileManagerEntity.fileSize = localFileData.jdField_a_of_type_Long;
        localFileManagerEntity.mContext = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
        if (this.jdField_a_of_type_Boolean)
        {
          localFileManagerEntity.WeiYunFileId = this.jdField_b_of_type_JavaLangString;
          localFileManagerEntity.mContext = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
          localFileManagerEntity.nRelatedSessionId = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
        }
        localFileManagerEntity.zipFileId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
        StringBuilder localStringBuilder;
        if (localFileManagerEntity.mContext == null)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("zip list file content is empty. zipSessionId[");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
          localStringBuilder.append("] zipIsWeiyunFile[");
          localStringBuilder.append(this.jdField_a_of_type_Boolean);
          localStringBuilder.append("] zipCouldType[");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType);
          localStringBuilder.append("] fileSessionId[");
          localStringBuilder.append(localFileManagerEntity.nSessionId);
          localStringBuilder.append("]");
          QLog.i("IphoneTitleBarActivity", 1, localStringBuilder.toString());
        }
        boolean bool = this.jdField_a_of_type_Boolean;
        if ((!bool) && (this.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(this.c)))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("https://");
          localStringBuilder.append(this.d);
          localStringBuilder.append(":");
          localStringBuilder.append(this.jdField_a_of_type_Short);
          localStringBuilder.append("/ftn_compress_getfile/rkey=");
          localStringBuilder.append(this.e);
          localStringBuilder.append("&filetype=");
          localStringBuilder.append(this.jdField_a_of_type_Int);
          localStringBuilder.append("&path=");
          localStringBuilder.append(URLUtil.a(paramJSONObject));
          localStringBuilder.append("&");
          localFileManagerEntity.strServerPath = localStringBuilder.toString();
          localFileManagerEntity.httpsDomain = this.c;
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("http://");
          localStringBuilder.append(this.d);
          localStringBuilder.append(":");
          localStringBuilder.append(this.f);
          localStringBuilder.append("/ftn_compress_getfile/rkey=");
          localStringBuilder.append(this.e);
          localStringBuilder.append("&filetype=");
          localStringBuilder.append(this.jdField_a_of_type_Int);
          localStringBuilder.append("&path=");
          localStringBuilder.append(URLUtil.a(paramJSONObject));
          localStringBuilder.append("&");
          localFileManagerEntity.strServerPath = localStringBuilder.toString();
        }
        localFileManagerEntity.zipFileId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
        localFileManagerEntity.zipInnerPath = paramJSONObject;
        localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.selfUin;
        localFileManagerEntity.peerUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        localFileManagerEntity.peerType = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType;
        localFileManagerEntity.busId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.busId;
        localFileManagerEntity.cloudType = 1;
        localFileManagerEntity.isZipInnerFile = true;
        localFileManagerEntity.zipFilePath = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath;
        localFileManagerEntity.zipType = this.jdField_a_of_type_Int;
        localFileManagerEntity.TroopUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin;
        localFileData.b = localFileManagerEntity.nSessionId;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.app.getFileManagerProxy().a(localFileManagerEntity);
        this.jdField_a_of_type_JavaUtilList.add(localFileData);
        paramInt += 1;
      }
    }
    catch (JSONException paramJSONObject)
    {
      label899:
      label903:
      break label899;
    }
    paramJSONObject.printStackTrace();
    paramJSONObject = this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$OnGetZipFileList;
    if (paramJSONObject != null) {
      paramJSONObject.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity.3
 * JD-Core Version:    0.7.0.1
 */