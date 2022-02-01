package com.tencent.mobileqq.teamwork;

import android.os.Bundle;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class TeamWorkFileImportJobForDisc$1
  extends FileTransferObserver
{
  TeamWorkFileImportJobForDisc$1(TeamWorkFileImportJobForDisc paramTeamWorkFileImportJobForDisc) {}
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    paramString2 = new JSONObject();
    int i = 0;
    if (paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("---OnDiscDownloadInfo retCode: ");
        paramBundle.append(paramLong1);
        paramBundle.append(",retMsg: ");
        paramBundle.append(paramString1);
        paramBundle.append(",strCookie: ");
        paramBundle.append(paramString5);
        paramBundle.append(",host: ");
        paramBundle.append(paramString3);
        paramBundle.append(",port: ");
        paramBundle.append(paramInt1);
        QLog.i("TeamWorkFileImportJobForDisc", 2, paramBundle.toString());
      }
      paramString1 = new StringBuilder("http://");
      paramString1.append(paramString3);
      paramString1.append(":");
      paramString1.append(paramInt1);
      paramString1.append("/ftn_handler/");
      paramString1.append(paramString4);
      try
      {
        paramString3 = new JSONArray();
        paramString3.put(0, paramString1.toString());
        paramString2.put("urls", paramString3);
        paramString2.put("filename", this.a.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.b);
        paramString2.put("cookie", paramString5);
        paramInt1 = 1;
      }
      catch (Exception paramString1)
      {
        paramString3 = new StringBuilder();
        paramString3.append("OnDiscDownloadInfo exception: ");
        paramString3.append(paramString1.toString());
        QLog.e("TeamWorkFileImportJobForDisc", 2, paramString3.toString());
      }
    }
    else
    {
      for (;;)
      {
        paramInt1 = 0;
        break;
        paramString1 = new StringBuilder();
        paramString1.append("---OnDiscDownloadInfo retCode: ");
        paramString1.append(paramLong1);
        paramString1.append(",fileName: ");
        paramString1.append(this.a.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.b);
        paramString1.append("----");
        QLog.e("TeamWorkFileImportJobForDisc", 1, paramString1.toString());
      }
    }
    paramInt2 = i;
    try
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
      {
        if (paramInt1 == 0) {
          paramString2.put("filename", this.a.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.b);
        }
        paramString2.put("filetype", 2);
        paramString2.put("fileid", this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid);
        paramString2.put("discussuin", Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin));
        paramString2.put("md5", this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5);
        paramString2.put("sha", this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA);
        paramString2.put("importoption", this.a.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.g);
        paramString2.put("filesize", this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
        this.a.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.l = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        this.a.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.i = 2;
        paramInt2 = 1;
      }
    }
    catch (Exception paramString1)
    {
      paramString3 = new StringBuilder();
      paramString3.append("put fileid exception: ");
      paramString3.append(paramString1.toString());
      QLog.e("TeamWorkFileImportJobForDisc", 2, paramString3.toString());
      paramInt2 = i;
    }
    if (((paramInt2 != 0) || (paramInt1 != 0)) && (TeamWorkConvertUtils.a(paramString2)) && (TeamWorkFileImportJobForDisc.a(this.a, paramString2)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkFileImportHandler.fileImportFromUrl(paramString2, this.a.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo, this.a.hashCode());
      return;
    }
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForDisc.1
 * JD-Core Version:    0.7.0.1
 */