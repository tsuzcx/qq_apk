package com.tencent.mobileqq.teamwork.api;

import android.util.SparseIntArray;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.teamwork.DocsGrayTipsInfo;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.List;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface ITeamWorkHandler
  extends QRouteApi
{
  public static final String CMD_BATCH_GET_PAD_INFO = "TimDocSvc.BatchGetPadInfo";
  public static final String CMD_CANCEL_PIN_BROWSE_PAD = "TimDocSvc.CancelPinBrowsePad";
  public static final String CMD_CANCEL_PIN_CREATED_PAD = "TimDocSvc.CancelPinCreatedPad";
  public static final String CMD_CANCEL_PIN_ITEM_OF_ALL_PAD = "TimDocSvc.CancelPinAllDocListPad";
  public static final String CMD_CANCEL_PIN_SHARED_PAD = "TimDocSvc.CancelPinSharedPad";
  public static final String CMD_DELETE_BROWSE_PAD = "TimDocSvc.DeleteBrowseHistory";
  public static final String CMD_DELETE_CREATED_PAD = "TimDocSvc.DeletePad";
  public static final String CMD_DELETE_ITEM_OF_ALL_PAD = "TimDocSvc.DeleteAllDocListPad";
  public static final String CMD_DELETE_SHARED_PAD = "TimDocSvc.DeleteSharedPad";
  public static final String CMD_GET_BROWSE_LIST = "TimDocSvc.GetBrowseList";
  public static final String CMD_GET_CREATED_LIST = "TimDocSvc.GetCreatedList";
  public static final String CMD_GET_GROUP_AUTH_DOCS_TIPS_INFO = "OidbSvc.0xbab_3";
  public static final String CMD_GET_PAD_RIGHT_INFO = "TimDocSvc.GetPadRightInfo";
  public static final String CMD_GET_PIN_LIST_IN_ALL_LIST = "TimDocSvc.GetAllDocList";
  public static final String CMD_GET_SHARED_LIST = "TimDocSvc.GetSharedPadList";
  public static final String CMD_GET_TIP_FLAG = "TimDocSvc.GetTipFlag";
  public static final String CMD_GET_USER_AUTH_DOCS_TIPS_INFO = "OidbSvc.0xbab_1";
  public static final String CMD_PIN_BROWSE_PAD = "TimDocSvc.PinBrowsePad";
  public static final String CMD_PIN_CREATED_PAD = "TimDocSvc.PinCreatedPad";
  public static final String CMD_PIN_ITEM_OF_ALL_PAD = "TimDocSvc.PinAllDocListPad";
  public static final String CMD_PIN_SHARED_PAD = "TimDocSvc.PinSharedPad";
  public static final String CMD_SET_GROUP_AUTH_DOCS_TIPS_INFO = "OidbSvc.0xbab_4";
  public static final String CMD_SET_PAD_RIGHT_INFO = "TimDocSvc.SetPadRightInfo";
  public static final String CMD_SET_TIP_FLAG = "TimDocSvc.SetTipFlag";
  public static final String CMD_SET_USER_AUTH_DOCS_TIPS_INFO = "OidbSvc.0xbab_2";
  public static final String DOCS_DOMAIN = "docs.qq.com";
  public static final String KEY_RESEND_CMD = "key_resend_cmd";
  public static final String KEY_TIP_FLAG = "key_tip_flag";
  public static final String KEY_TIP_FLAG_TYPE = "key_tip_flag_type";
  public static final String KEY_TYPE_LIST = "key_type_list";
  public static final int OBERSER_TYPE_CANCEL_PIN_PAD = 4;
  public static final int OBERSER_TYPE_GET_NEWPAD_RIGHTS_INFO = 7;
  public static final int OBERSER_TYPE_GET_PAD_RIGHTS_INFO = 5;
  public static final int OBERSER_TYPE_SET_PAD_RIGHTS_INFO = 6;
  public static final int OBSERVER_TYPE_DELETE_PAD = 2;
  public static final int OBSERVER_TYPE_GET_DOCS_GRAY_TIPS_INFO = 8;
  public static final int OBSERVER_TYPE_GET_GROUP_DOCS_GRAY_TIPS_INFO = 10;
  public static final int OBSERVER_TYPE_GET_PAD_LIST = 1;
  public static final int OBSERVER_TYPE_GET_TIP_FLAG = 13;
  public static final int OBSERVER_TYPE_PIN_PAD = 3;
  public static final int OBSERVER_TYPE_PUSH = 12;
  public static final int OBSERVER_TYPE_SET_DOCS_GRAY_TIPS_INFO = 9;
  public static final int OBSERVER_TYPE_SET_GROUP_DOCS_GRAY_TIPS_INFO = 11;
  public static final int OBSERVER_TYPE_SET_TIP_FLAG = 14;
  public static final int PUB_FLAG_ALL_READ = 2;
  public static final int PUB_FLAG_ALL_WRITE = 3;
  public static final int PUB_FLAG_ASSIGN = 1;
  public static final int PUB_FLAG_SELF = 0;
  public static final String TAG = "TeamWorkHandlerImpl";
  public static final int TYPE_OPERATION_ALL_LIST = 4;
  public static final int TYPE_OPERATION_BROWSE_LIST = 2;
  public static final int TYPE_OPERATION_CREATED_LIST = 1;
  public static final int TYPE_OPERATION_PIN_LIST_IN_ALL_LIST = 5;
  public static final int TYPE_OPERATION_SHAREDE_LIST = 3;
  public static final int TYPE_TIP_FLAG_GUIDE = 1;
  public static final String URL_BASE_URL = "https://docs.qq.com/cgi-bin/online_docs/doc_content";
  public static final String URL_CONVERT_UIN = "https://docs.qq.com/cgi-bin/online_docs/tool_decryptuin";
  public static final String URL_DELETE_DOC = "https://docs.qq.com/cgi-bin/online_docs/doc_delete";
  public static final String URL_DEL_RECENT_FILES = "https://docs.qq.com/docsqqfile/recentfilesdel";
  public static final String URL_DOC_FILE_INFO = "https://docs.qq.com/cgi-bin/online_docs/doc_info";
  public static final String URL_DOC_FILE_INFO_GUEST = "https://docs.qq.com/cgi-bin/online_docs/doc_infoguest";
  public static final String URL_FORM_RECORDCNT = "https://docs.qq.com/form/collect/recordcnt";
  public static final String URL_GET_FORM_CACHE = "https://docs.qq.com/cgi-go/imp/import_form_cache";
  public static final String URL_GET_RECENT_FILES = "https://docs.qq.com/docsqqfile/recentfiles";
  public static final String URL_GET_TEMPLATE_LIST = "https://docs.qq.com/cgi-bin/template/template_list";
  public static final String URL_GET_USER_LIST_INFO = "https://docs.qq.com/cgi-go/users/roomInfo";
  public static final String URL_GET_WX_QRCODE = "https://docs.qq.com/cgi-bin/online_docs/wxqrcode";
  public static final String URL_IMPORT_FORM = "https://docs.qq.com/cgi-go/imp/import_form_url";
  public static final String URL_PUSH_NOTIFY = "https://docs.qq.com/cgi-go/users/pushNotify";
  public static final String URL_SET_PAD_INFO = "https://docs.qq.com/cgi-bin/redirect/%s/ep/api/setpadinfo";
  public static final String URL_TEAM_WORK_CREATE = "https://%s.docs.qq.com/ep/pad/newpaddirect?type=%s&title=%s";
  public static final String URL_TEAM_WORK_GET_REDDOT = "https://docs.qq.com/cgi-go/discuss/get_unread_reddot";
  public static final String URL_WECHAT_SHARE_TIPS = "https://docs.qq.com/cgi-bin/api/wechatshare/shareTips";
  public static final SparseIntArray responseReTryCount = new SparseIntArray();
  
  public abstract String convertCryptoUinToTrueUin(String paramString1, String paramString2, String paramString3);
  
  public abstract JSONObject delRecentFilesByHttp(JSONObject paramJSONObject);
  
  public abstract boolean getEnableTencentDocsAssistant();
  
  public abstract void getGroupAuthDocsGrayTips(DocsGrayTipsInfo paramDocsGrayTipsInfo, long paramLong);
  
  public abstract void getPadRightsInfo(int paramInt, String paramString);
  
  public abstract boolean getPreloadToolProcess();
  
  public abstract JSONObject getRecentFilesByHttp(String paramString);
  
  public abstract JSONObject getTemplateListByHttp();
  
  public abstract void getUserAuthDocsGrayTips(DocsGrayTipsInfo paramDocsGrayTipsInfo, long paramLong);
  
  public abstract void handleGetPadRightsInfo(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject);
  
  public abstract void setEnableTencentDocsAssistant(boolean paramBoolean);
  
  public abstract void setGroupAuthDocsGrayTips(DocsGrayTipsInfo paramDocsGrayTipsInfo, int paramInt, long paramLong);
  
  public abstract void setPadRightsInfo(int paramInt1, String paramString, int paramInt2, List<TimDocSSOMsg.UinRightInfo> paramList);
  
  public abstract void setPreloadToolProcess(boolean paramBoolean);
  
  public abstract void setUserAuthDocsGrayTips(DocsGrayTipsInfo paramDocsGrayTipsInfo, int paramInt, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.ITeamWorkHandler
 * JD-Core Version:    0.7.0.1
 */