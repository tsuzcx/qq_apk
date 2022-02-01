package com.tencent.mobileqq.teamwork.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkHttpUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import java.util.Map;
import org.json.JSONObject;

public class TeamWorkHttpUtilsImpl
  implements ITeamWorkHttpUtils
{
  public String checkIfExist(String paramString1, String paramString2)
  {
    return TeamWorkHttpUtils.b(paramString1, paramString2);
  }
  
  public String exportDocFile(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return TeamWorkHttpUtils.a(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public String getFileMD5(String paramString)
  {
    return TeamWorkHttpUtils.a(paramString);
  }
  
  public String getTencentDocReddot(String paramString1, String paramString2)
  {
    return TeamWorkHttpUtils.a(paramString1, paramString2);
  }
  
  public JSONObject ocrExportUploadImage(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    return TeamWorkHttpUtils.a(paramAppInterface, paramString1, paramString2);
  }
  
  public String sendHttpsGet(String paramString1, String paramString2, String paramString3)
  {
    return TeamWorkHttpUtils.a(paramString1, paramString2, paramString3);
  }
  
  public String sendHttpsGet(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return TeamWorkHttpUtils.a(paramString1, paramString2, paramString3, paramString4);
  }
  
  public String sendHttpsPost(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return TeamWorkHttpUtils.b(paramString1, paramString2, paramString3, paramString4);
  }
  
  public String sendHttpsPost(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Map<String, String> paramMap, boolean paramBoolean)
  {
    return TeamWorkHttpUtils.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramMap, paramBoolean);
  }
  
  public String sendHttpsPost(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    return TeamWorkHttpUtils.b(paramJSONObject, paramString1, paramString2, paramString3);
  }
  
  public String sendHttpsPost(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return TeamWorkHttpUtils.a(paramJSONObject, paramString1, paramString2, paramString3, paramString4);
  }
  
  public String uploadFile(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    return TeamWorkHttpUtils.a(paramTeamWorkFileImportInfo, paramString);
  }
  
  public String uploadFileForH5(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    return TeamWorkHttpUtils.c(paramTeamWorkFileImportInfo, paramString);
  }
  
  public String uploadFileInfo(JSONObject paramJSONObject, String paramString, AppInterface paramAppInterface)
  {
    return TeamWorkHttpUtils.a(paramJSONObject, paramString, paramAppInterface);
  }
  
  public String uploadFileInfoForH5(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    return TeamWorkHttpUtils.a(paramJSONObject, paramTeamWorkFileImportInfo, paramString);
  }
  
  public String uploadFileWithParam(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    return TeamWorkHttpUtils.a(paramJSONObject, paramString1, paramString2, paramString3);
  }
  
  public String url2Doc(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    return TeamWorkHttpUtils.b(paramTeamWorkFileImportInfo, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkHttpUtilsImpl
 * JD-Core Version:    0.7.0.1
 */