package com.tencent.mobileqq.teamwork.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.teamwork.DocsGrayTipsInfo;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamworkforgroup.GroupPadTemplateInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import tencent.im.oidb.cmd0xae9.online_docs.DocId;

@QAPI(process={"all"})
public abstract interface ITeamWorkUtils
  extends QRouteApi
{
  public static final long DOCS_APPID = 101458937L;
  public static final String DOCS_LIST_KEY = "docs.qq.com/desktop/m";
  public static final String DOCS_LIST_URL = "https://docs.qq.com/desktop/m/index.html?_wv=2097154";
  public static final String DOCS_LIST_WEB_URL = "https://docs.qq.com/desktop/m/index.html?_wv=2";
  public static final String DOCS_SOURCE_ICON_URL = "https://docs.qq.com/desktop/favicon.ico";
  public static final Map<Integer, String> ENTRANCE_TO_AD_TAG_MAP = new HashMap();
  public static final String FILE_BROWSER_PARAMS_KEY_MINI_PROGRAM = "isMiniProgram";
  public static final String FILE_WORD_XLS = ".doc|.docx|.xls|.xlsx|";
  public static final String MESSAGE_RECORD_EXT_ICON = "ten_doc_icon";
  public static final String MESSAGE_RECORD_EXT_IS_TEN_DOC = "ten_doc_is_ten_doc";
  public static final String MESSAGE_RECORD_EXT_TITLE = "ten_doc_title";
  public static final String MESSAGE_RECORD_EXT_URL = "ten_doc_url";
  public static final HashMap<String, String> MINIAPP_CONFIG_TYPE_MAP;
  public static final String TD_READ_ONLY = "m_readonly";
  public static final String TD_SOURCE_QQ_ADTAG = "tdsourcetag";
  public static final String TD_SOURCE_QQ_AIOMSG = "s_qq_aiomsg";
  public static final String TD_SOURCE_QQ_AIO_ARK_H5 = "s_qq_aio_ark_h5";
  public static final String TD_SOURCE_QQ_AIO_EDIT = "s_qq_aio_edit";
  public static final String TD_SOURCE_QQ_AIO_GREY = "s_qq_aio_grey";
  public static final String TD_SOURCE_QQ_DRAWER = "s_qq_drawer";
  public static final String TD_SOURCE_QQ_FILE_EDIT = "s_qq_file_edit";
  public static final String TD_SOURCE_QQ_FILE_SHARE_EDIT = "s_QQ_file_share_edit";
  public static final String TD_SOURCE_QQ_GRPFILE = "s_qq_grpfile";
  public static final String TD_SOURCE_QQ_GRP_SETTOP = "s_qq_grp_settop";
  public static final String TD_SOURCE_QQ_HISTORY_TAB = "s_qq_history_tab";
  public static final String TD_SOURCE_QQ_MINI_IMPORTING = "s_qq_mini_importing";
  public static final String TD_SOURCE_QQ_MYFILE = "s_qq_myfile";
  public static final String TD_SOURCE_QQ_MYFILE_BANNER = "s_qq_myfile_banner";
  public static final String TD_SOURCE_QQ_MYFILE_MENU_CREATE = "s_qq_myfile_menu_create";
  public static final String TD_SOURCE_QQ_MYFILE_YINDAO = "s_qq_myfile_yindao";
  public static final String TD_SOURCE_QQ_OCR_SAVE = "s_qq_ocr_save";
  public static final String TD_SOURCE_QQ_ONLINE_PREVIEW = "s_qq_file_preview";
  public static final String TD_SOURCE_QQ_SEND_FILE = "s_qq_send_file";
  public static final String TD_SOURCE_QQ_URL_2_DOC = "s_qq_url_2_doc";
  public static final String TD_SOURCE_TAB = "tdsourcetab";
  public static final String TD_SOURCE_TYPE = "tdsourcetype";
  public static final String TENCENT_DOC_MIMI_APPID = "1108338344";
  public static final String TROOP_FORM_GREY_NICKNAME = HardCodeUtil.a(2131912063);
  public static final String TROOP_FORM_GREY_PATTERN = "<([^>])+";
  public static final String TROOP_FORM_GREY_TAG_LINK = "isLink";
  public static final String TROOP_FORM_GREY_TAG_TEXT = "text";
  public static final String TROOP_FORM_GREY_TAG_UIN = "uin";
  public static final String TROOP_FORM_MIMI_APPID = "1108961705";
  public static final String TROOP_FORM_MIMI_ENTRY = "pages/detail/detail";
  
  static
  {
    MINIAPP_CONFIG_TYPE_MAP = new HashMap();
  }
  
  public abstract void checkDirectShareChangePolicy(int paramInt1, int paramInt2, Intent paramIntent, TeamWorkFileImportInfo paramTeamWorkFileImportInfo);
  
  public abstract boolean clickWebTDDoc(String paramString, Context paramContext);
  
  public abstract boolean clickWebTDDocAndUpdateTitle(String paramString, Context paramContext, int paramInt, FileManagerEntity paramFileManagerEntity, AppInterface paramAppInterface);
  
  public abstract Bitmap decodeBase64ToBitmap(String paramString);
  
  public abstract String excelColIndexToStr(int paramInt);
  
  public abstract TeamWorkFileImportInfo generateTencentDocImportInfo(FileManagerEntity paramFileManagerEntity, boolean paramBoolean);
  
  public abstract String getCloudFileTime(long paramLong);
  
  public abstract online_docs.DocId getDocId(long paramLong, String paramString);
  
  public abstract String getNoDotExtension(String paramString);
  
  public abstract String getNoParamUrl(String paramString);
  
  public abstract String getPadInfoUrl(String paramString, int paramInt);
  
  public abstract Bitmap getShareBitMapBase64(String paramString);
  
  public abstract String getTDDocFileThumbUrl(String paramString);
  
  public abstract QIPCModule getTDIPCModule();
  
  public abstract String getTDocFileType(String paramString);
  
  public abstract Bitmap getTeamWorkForH5ShareBitMap(int paramInt);
  
  public abstract Bitmap getTeamWorkForShareBitMap(int paramInt);
  
  public abstract String getTencentDocLocalCacheFromFile(Context paramContext, String paramString);
  
  public abstract String getTencentDocSourceAdtagStrUrl(String paramString1, String paramString2);
  
  public abstract String getTencentDocWithEditedUrl(String paramString1, String paramString2);
  
  public abstract String getTencentDocWithReadOnlyParam(String paramString);
  
  public abstract boolean gotoAIOTencentDocListWebH5(AppInterface paramAppInterface, Activity paramActivity, String paramString1, int paramInt, String paramString2);
  
  public abstract boolean gotoTeamWorkListWebH5(AppInterface paramAppInterface, Activity paramActivity);
  
  public abstract boolean gotoTeamWorkWebH5(Context paramContext, String paramString);
  
  public abstract boolean isBase64ImgFormatData(String paramString);
  
  public abstract boolean isCollectionNotEmpty(Collection paramCollection);
  
  public abstract boolean isDocOrXLS(String paramString1, String paramString2);
  
  public abstract boolean isDocsFile(String paramString);
  
  public abstract boolean isDocsFormUrl(String paramString);
  
  public abstract boolean isDocsSupport(String paramString1, String paramString2, String paramString3);
  
  public abstract boolean isDocsUrl(String paramString);
  
  public abstract boolean isDocsUrlForPreLoad(String paramString);
  
  public abstract boolean isFastClick();
  
  public abstract boolean isPushMessageDuplicated(int paramInt);
  
  public abstract void jumpToTencentDocIndex(Activity paramActivity, String paramString, int paramInt);
  
  public abstract void openGroupPadTemplateListUrl(AppInterface paramAppInterface, Activity paramActivity, int paramInt, String paramString, long paramLong1, long paramLong2);
  
  public abstract void openGroupPadTemplatePreviewUrl(AppInterface paramAppInterface, Activity paramActivity, String paramString, long paramLong, GroupPadTemplateInfo paramGroupPadTemplateInfo);
  
  public abstract boolean openTroopFormMiniApp(Context paramContext, String paramString1, String paramString2);
  
  public abstract ArrayList<TencentDocData> parseTencentDocRspJson(String paramString);
  
  public abstract DocsGrayTipsInfo paseDocsGrayTipsInfoFromJson(String paramString1, String paramString2, String paramString3);
  
  public abstract void report(AppInterface paramAppInterface, String paramString);
  
  public abstract void reportClickWithTroopType(AppInterface paramAppInterface, String paramString1, String paramString2);
  
  public abstract void reportOnlinePreview(Bundle paramBundle, String paramString);
  
  public abstract void reportOnlinePreview(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString1, String paramString2);
  
  public abstract void saveTencentDocCacheFile(Context paramContext, String paramString1, String paramString2);
  
  public abstract boolean supportTencentDoc(Map<String, Long> paramMap, String paramString1, String paramString2, long paramLong);
  
  public abstract boolean supportTencentDocForEdit(String paramString1, String paramString2, long paramLong);
  
  public abstract boolean supportTencentDocForLocalCooperation(String paramString1, String paramString2, long paramLong);
  
  public abstract boolean supportTencentDocForPreview(String paramString1, String paramString2, long paramLong);
  
  public abstract boolean targetTencentDocFormKeyWords(String paramString1, String paramString2, long paramLong);
  
  public abstract String toListDate(String paramString);
  
  public abstract void tryOpenWithTencentDoc(AppInterface paramAppInterface, Context paramContext, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo);
  
  public abstract void tryReportHistoryTab(Intent paramIntent, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
 * JD-Core Version:    0.7.0.1
 */