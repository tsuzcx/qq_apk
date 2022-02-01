package com.tencent.mobileqq.teamwork.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import java.util.Map;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface ITeamWorkHttpUtils
  extends QRouteApi
{
  public static final String DEFAULT_TENCENT_DOC_IMPORT_FORM = "https://docs.qq.com/cgi-go/imp/import_form_file";
  public static final String DEFAULT_TENCENT_DOC_TEMPLATES_URL = "https://docs.qq.com/desktop/m/templates_list.html?padtype=0&_wv=2&_wwv=512";
  
  public abstract String checkIfExist(String paramString1, String paramString2);
  
  public abstract String exportDocFile(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract String getFileMD5(String paramString);
  
  public abstract String getTencentDocReddot(String paramString1, String paramString2);
  
  public abstract JSONObject ocrExportUploadImage(AppInterface paramAppInterface, String paramString1, String paramString2);
  
  public abstract String sendHttpsGet(String paramString1, String paramString2, String paramString3);
  
  public abstract String sendHttpsGet(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract String sendHttpsPost(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract String sendHttpsPost(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Map<String, String> paramMap, boolean paramBoolean);
  
  public abstract String sendHttpsPost(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3);
  
  public abstract String sendHttpsPost(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract String uploadFile(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString);
  
  public abstract String uploadFileForH5(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString);
  
  public abstract String uploadFileInfo(JSONObject paramJSONObject, String paramString, AppInterface paramAppInterface);
  
  public abstract String uploadFileInfoForH5(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString);
  
  public abstract String uploadFileWithParam(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3);
  
  public abstract String url2Doc(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils
 * JD-Core Version:    0.7.0.1
 */