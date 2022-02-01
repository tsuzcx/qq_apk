package com.tencent.mobileqq.teamwork.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface ITeamWorkFileImportHandler
  extends QRouteApi
{
  public static final int MSG_FILE_CHECK_ERROR = 8005;
  public static final int MSG_FILE_CHECK_SUCCESS = 8004;
  public static final int MSG_FILE_IMPORTING = 8003;
  public static final int MSG_FILE_IMPORT_ERROR = 8002;
  public static final int MSG_FILE_IMPORT_SUCCESS = 8001;
  public static final int OBSERVER_FILE_IMPORT_FAILED = 2;
  public static final int OBSERVER_FILE_IMPORT_GET_DOT = 3;
  public static final int OBSERVER_FILE_IMPORT_IS_NEW_TENCENT_DOC = 5;
  public static final int OBSERVER_FILE_IMPORT_STARTED = 4;
  public static final int OBSERVER_FILE_IMPORT_SUCCESS = 1;
  public static final int OBSERVER_FILE_IS_IMPORTED = 6;
  public static final int OBSERVER_FILE_IS_NO_CACHE = 7;
  public static final int RETCODE_CGI_NOT_RETURN = -1000;
  public static final int RETCODE_CGI_NO_PUBLIC_CACHE = 20003;
  public static final int RETCODE_CGI_NO_USER_CACHE = 20004;
  public static final int RETCODE_CGI_NO_USER_CACHE_FOR_DISCUSS = 20005;
  public static final String TAG = "TeamWorkFileImportHandler";
  
  public abstract void addFileImportJob(TeamWorkFileImportInfo paramTeamWorkFileImportInfo);
  
  public abstract void addToConvertedMap(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString);
  
  public abstract void addToFileImportingMap(TeamWorkFileImportInfo paramTeamWorkFileImportInfo);
  
  public abstract void checkFormCache(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo);
  
  public abstract void createGrayTips(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString);
  
  public abstract void fileImportFromLocalFile(TeamWorkFileImportInfo paramTeamWorkFileImportInfo);
  
  public abstract void fileImportFromLocalFileForDataLine(TeamWorkFileImportInfo paramTeamWorkFileImportInfo);
  
  public abstract void fileImportFromLocalFileForH5(TeamWorkFileImportInfo paramTeamWorkFileImportInfo);
  
  public abstract void fileImportFromUrl(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, int paramInt);
  
  public abstract void fileImportFromUrl2Doc(TeamWorkFileImportInfo paramTeamWorkFileImportInfo);
  
  public abstract void fileImportFromUrlForH5(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, int paramInt);
  
  public abstract void getTencentDocReddot(String paramString);
  
  public abstract String getUrlFromConvertedMap(TeamWorkFileImportInfo paramTeamWorkFileImportInfo);
  
  public abstract void importFormWithLocalFile(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo);
  
  public abstract void importFormWithUrl(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo);
  
  public abstract boolean isFileImporting(TeamWorkFileImportInfo paramTeamWorkFileImportInfo);
  
  public abstract void notifyUIError(TeamWorkFileImportInfo paramTeamWorkFileImportInfo);
  
  public abstract boolean parseFileImportResultForH5(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo);
  
  public abstract void removeFileImporting(TeamWorkFileImportInfo paramTeamWorkFileImportInfo);
  
  public abstract void removeFromConvertedMap(TeamWorkFileImportInfo paramTeamWorkFileImportInfo);
  
  public abstract void setIsNeedToast(boolean paramBoolean);
  
  public abstract boolean updateFileImporting(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
 * JD-Core Version:    0.7.0.1
 */