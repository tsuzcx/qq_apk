package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.google.gson.Gson;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdExposeFreshService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdReqFreshService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyStringUtils;
import com.tencent.mobileqq.kandian.biz.biu.RIJBiuAndCommentMixDataManager;
import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IUiApiPlugin;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentLinkData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.event.AddCommentLinkEvent;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkWrapper;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentRptDataUtil;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper.RIJCreateCommentObserver;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJEntryViewUtils;
import com.tencent.mobileqq.kandian.biz.feeds.UserReadUnReadInfoManager;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.biz.feeds.entity.ExposureArticle;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLikeAnimateManager;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager.Companion;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskConfig;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskLocalRepo;
import com.tencent.mobileqq.kandian.biz.share.ActionItem;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJDeliverUGCUtils;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IVideoPublishCallback;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcEntryExtraInfo;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.RIJUgcVideoPublishManager;
import com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.ViolaVideoUpdateController;
import com.tencent.mobileqq.kandian.biz.video.playfeedback.PlayFeedbackHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.viola.api.IBridgeModule;
import com.tencent.mobileqq.kandian.biz.viola.api.InvokeCallJSCallback;
import com.tencent.mobileqq.kandian.biz.viola.contract.IViolaFragmentCommonContract;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr.VideoPreDownloadParam;
import com.tencent.mobileqq.kandian.glue.video.VideoResumeManager;
import com.tencent.mobileqq.kandian.glue.video.report.VideoPreloadReportData;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout;
import com.tencent.mobileqq.kandian.glue.viola.modules.bridge.BridgeInvokeHandler;
import com.tencent.mobileqq.kandian.glue.viola.modules.bridge.ViolaBridgeApiHelper;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils;
import com.tencent.mobileqq.kandian.glue.viola.videonew.VVideoView;
import com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo.ViolaCommentManager;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.db.struct.ColumnInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType.Companion;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.RIJStudyModeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.share.ShareReport;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.base.MD5;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.commons.Destroyable;
import com.tencent.viola.core.IActivityState;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.module.BaseModule;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class BridgeModule
  extends BaseModule
  implements IBridgeModule, ITroopMemberApiClientApi.Callback, Destroyable, IActivityState
{
  public static final String BRIDGE_EVENT_FULLSCREENSIZECHANGE = "onFullScreenSizeChange";
  public static final String BRIDGE_LOCAL_JS_URL = "https://viola.qq.com/viola_serve/dev";
  public static final String BRIDGE_METHOD_NAME_ONCLICKBUBBLETIPS = "onClickBubbleTips";
  public static final String BRIDGE_METHOD_NAME_REQUESTBUBBLETIPSWORDING = "requestBubbleTipsWording";
  public static final String BRIDGE_PARAMS = "params";
  public static final String BRIDGE_PARAMS_ACCURATE = "accurate";
  public static final String BRIDGE_PARAMS_ACTION = "action";
  public static final String BRIDGE_PARAMS_ANDROIDID = "androidID";
  public static final String BRIDGE_PARAMS_AUTO_DES = "autoDestroy";
  public static final String BRIDGE_PARAMS_BID = "v_bid";
  public static final String BRIDGE_PARAMS_BOTTOM = "bottom";
  public static final String BRIDGE_PARAMS_CHANNELID = "channelId";
  public static final String BRIDGE_PARAMS_DATA_ERROR_CODE = "data_error_code";
  public static final String BRIDGE_PARAMS_FOR_NV = "isForNativeVue";
  public static final String BRIDGE_PARAMS_FROMCALLBACK = "fromCallback";
  public static final String BRIDGE_PARAMS_FROMTYPE = "fromType";
  public static final String BRIDGE_PARAMS_HEIGHT = "height";
  public static final String BRIDGE_PARAMS_IDENTIFIER = "identifier";
  public static final String BRIDGE_PARAMS_IMSI = "imsi";
  public static final String BRIDGE_PARAMS_IS_LAST_INDEX = "is_last_index";
  public static final String BRIDGE_PARAMS_JS = "js";
  public static final String BRIDGE_PARAMS_JUMP_BUNDLE = "jumpBundle";
  public static final String BRIDGE_PARAMS_JUMP_CLIPBOARDINFO = "clipboardInfo";
  public static final String BRIDGE_PARAMS_JUMP_COMMONDATA = "commonData";
  public static final String BRIDGE_PARAMS_JUMP_SCHEMA = "jumpSchema";
  public static final String BRIDGE_PARAMS_JUMP_TYPE = "jumpType";
  public static final String BRIDGE_PARAMS_JUMP_URL = "jumpUrl";
  public static final String BRIDGE_PARAMS_LEFT = "left";
  public static final String BRIDGE_PARAMS_PICURL = "picUrl";
  public static final String BRIDGE_PARAMS_QIMEI = "qimei";
  public static final String BRIDGE_PARAMS_QUA = "qua";
  public static final String BRIDGE_PARAMS_RATE = "rate";
  public static final String BRIDGE_PARAMS_RECOMMEND = "showRecommendReason";
  public static final String BRIDGE_PARAMS_REDPACKET_ID = "redPacketId";
  public static final String BRIDGE_PARAMS_REDPACKET_ID_SM = "redpackid";
  public static final String BRIDGE_PARAMS_RIGHT = "right";
  public static final String BRIDGE_PARAMS_ROWKEY = "rowkey";
  public static final String BRIDGE_PARAMS_SHOULD_SHOW = "shouldShow";
  public static final String BRIDGE_PARAMS_SHOW_NET = "is_show_net_detail";
  public static final String BRIDGE_PARAMS_STATUS = "status";
  public static final String BRIDGE_PARAMS_TID = "v_tid";
  public static final String BRIDGE_PARAMS_TOP = "top";
  public static final String BRIDGE_PARAMS_TYPE = "type";
  public static final String BRIDGE_PARAMS_VID = "vid";
  public static final String BRIDGE_PARAMS_VIDEOFEEDSJS = "VideoFeeds.js";
  public static final String BRIDGE_PARAMS_VIDEO_ATTACH = "autoAttachVideoView";
  public static final String BRIDGE_PARAMS_VIDEO_HANDATTACH = "handAttachVideoView";
  public static final String BRIDGE_PARAMS_VIDEO_TOKEN = "videoToken";
  public static final String BRIDGE_PARAMS_WIDTH = "width";
  public static final String BRIDGE_PARAMS_WORDING = "wording";
  public static final int BRIDGE_TYPE_NORMAL_IN = 100;
  public static final int BRIDGE_TYPE_VIDEO_CLICK = 1;
  public static final int BRIDGE_TYPE_VIDEO_FLAYING = 2;
  public static final String BRIDGE_WX_CIRCLE_SHARE_URL = "wx_circle_share_url";
  public static final String BRIDGE_WX_SHARE_URL = "wx_share_url";
  public static final int CODE_QRCODE = 1;
  public static final byte CODE_SHARE_IMAGE = 18;
  public static final int DOWNLOAD_ACTION_CANCEL = 3;
  public static final int DOWNLOAD_ACTION_PAUSE = 1;
  public static final int DOWNLOAD_ACTION_RESUME = 2;
  public static final int DOWNLOAD_STAET_PAUSE = 5;
  public static final int DOWNLOAD_STATE_CANCEL = 3;
  public static final int DOWNLOAD_STATE_ERROR = 4;
  public static final int DOWNLOAD_STATE_FINISH = 2;
  public static final int DOWNLOAD_STATE_INSTALL_SUCCESS = 6;
  public static final int DOWNLOAD_STATE_UPDATE = 1;
  public static final String ENABLE = "enable";
  public static final String KEY_PREDOWNLOAD_MGR = "predownload";
  public static final String KEY_VIDEO_PLAY_POSITION = "viola_video_play_position";
  public static String MODULE_NAME = "bridge";
  public static final byte OPENCAMERA = 112;
  public static final byte OPENIMG = 111;
  public static final int PHOTO_CLIP_BANNER_H = 200;
  public static final int PHOTO_CLIP_BANNER_W = 360;
  public static final int PHOTO_CLIP_HEAD_SIZE = 360;
  public static final int PHOTO_CLIP_SIZE = 640;
  public static final int PHOTO_TAGGET_BANNER_W = 750;
  public static final int PHOTO_TARGET_BANNER_H = 416;
  public static final int PHOTO_TARGET_HEAD_SIZE = 160;
  public static final byte REQ_CODE_AQ_INVITE_FRIEND = 119;
  public static final byte REQ_CODE_COMMENT_EDITOR = 117;
  public static final byte REQ_CODE_COMMENT_EDITOR_NATIVE = 126;
  public static final byte REQ_CODE_DELIVER = 113;
  public static final byte REQ_CODE_DELIVER_QUESTION = 122;
  public static final byte REQ_CODE_DELIVER_TOPIC_PIC = 121;
  public static final byte REQ_CODE_DELIVER_UGC = 114;
  public static final byte REQ_CODE_SELECT_AND_UPLOAD_AVATAR = 118;
  public static final byte REQ_CODE_SHARE_QZONE = 125;
  public static final byte REQ_CODE_UGC_ADD_VIDEO = 124;
  public static final byte REQ_CODE_UGC_CAMERA_CAPTURE = 116;
  public static final byte REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM = 115;
  public static final byte REQ_CODE_UGC_MANAGE_COLUMN = 123;
  public static final String TAG = "BridgeModule";
  public static GdtAppReceiver mGdtAppReceiver;
  private static HashMap<String, Long> sConsumeCardMap = new HashMap();
  private static WeakReference<Activity> sShareEntryActivity;
  public static String shareCallBackId;
  public static String shareCallBackName;
  public static int shareCallBackType = 0;
  public static String ssoTimeOutRecordStr = "";
  private BridgeInvokeHandler bridgeInvokeHandler = new BridgeInvokeHandler(this);
  private Map<Long, String> columnToUploadCallbackMap = new HashMap();
  private String commentCallbaclId;
  private RIJBiuAndCommentMixDataManager dataManager;
  private InvokeCallJSCallback invokeCallJSCallback = new BridgeModule.1(this);
  private ActionSheetHelper mActionSheetHelper;
  private ViolaBridgeApiHelper mBridgeApiHelper = null;
  private String mCallBack = null;
  private TroopMemberApiClient mClient = null;
  private ViolaCommentManager mCommentManager;
  private int mCommentSeq = -1;
  private DownloadListener mDownloadListener;
  private EventHelper mEventHelper;
  private int mHippySwitchStatus = -1;
  private boolean mIsRightExit;
  private VideoFeedsLikeAnimateManager mLikeAnimateManager;
  private Map<String, Object> mObjectMap = new ArrayMap();
  private SparseArray<BridgeModule.ResultAction> mResultActionMap = new SparseArray();
  protected ShareActionSheetBuilder mShareActionSheet = null;
  public ReadInJoyShareHelperV2 mShareHelper;
  public QShareUtils mShareUtils = new QShareUtils();
  private int mState = -100;
  private String mUploadCallBack;
  private VideoPreDownloadMgr mVideoPreDownloadMgr = new VideoPreDownloadMgr();
  private int maxSize = 204800;
  private int minDuration = 5;
  private INetInfoHandler netInfoHandler;
  private long preTime = 0L;
  public String shareToFriendUin = "";
  public String shareToFriendUinName = "";
  public int shareToFriendUinType = 0;
  private String shareVideoCallBackId;
  private IRIJUgcVideoPublishService.IVideoPublishCallback updateUgcVideoInfoCallback = new BridgeModule.20(this);
  private IRIJUgcVideoPublishService.IVideoPublishCallback videoPublishCallback = new BridgeModule.15(this);
  private ViolaVideoUpdateController violaVideoUpdateController;
  
  public BridgeModule()
  {
    this.mObjectMap.put("predownload", this.mVideoPreDownloadMgr);
    registerActivityResultAction();
  }
  
  @JSMethod
  public static void addRowkeyToConsumeMap(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      sConsumeCardMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
    }
  }
  
  private void arouseReadInJoyNativeCommentView(JSONObject paramJSONObject, int paramInt)
  {
    ViolaBizUtils.a(paramJSONObject, paramInt);
  }
  
  private int bindCommentCallback(String paramString)
  {
    if (this.mClient == null)
    {
      this.mClient = TroopMemberApiClient.a();
      this.mClient.a();
    }
    this.commentCallbaclId = paramString;
    return this.mClient.a(this);
  }
  
  private void callJsDeliverResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    BridgeModuleHelper.a(this, paramInt1, paramInt2, paramIntent);
  }
  
  private AnchorData createAnchorData(JSONObject paramJSONObject)
  {
    return ViolaBizUtils.a(paramJSONObject);
  }
  
  private AbsBaseArticleInfo createArticleInfo(JSONObject paramJSONObject)
  {
    return ViolaBizUtils.a(paramJSONObject);
  }
  
  private static RIJFeedsInsertAction createRIJFeedsInsertAction(int paramInt1, int paramInt2)
  {
    return new RIJFeedsInsertAction(ActionType.Companion.b(paramInt1), paramInt2, 0, 0);
  }
  
  private TopGestureLayout createTopGestureLayout()
  {
    Object localObject = getActivity();
    if (localObject == null) {
      return null;
    }
    localObject = new TopGestureLayout((Context)localObject);
    ((TopGestureLayout)localObject).setOnFlingGesture(new BridgeModule.19(this));
    return localObject;
  }
  
  private void dealBiuResult(int paramInt, Intent paramIntent)
  {
    BridgeModuleHelper.b(this, paramInt, paramIntent);
  }
  
  private void dealForwardResult(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      if ((getViolaInstance() != null) && (getViolaInstance().getActivity() != null))
      {
        ForwardUtils.a((QQAppInterface)ReadInJoyUtils.a(), getViolaInstance().getActivity(), getViolaInstance().getActivity(), paramIntent, null);
        QLog.d("BridgeModule", 2, "share video card to aio success。");
      }
      paramIntent = new JSONObject();
      try
      {
        paramIntent.put("type", shareCallBackType);
        paramIntent.put("action", shareCallBackName);
        paramIntent.put("fromCallback", 1);
        if (!TextUtils.isEmpty(shareCallBackId)) {
          invokeCallJS(shareCallBackId, paramIntent);
        }
      }
      catch (JSONException paramIntent)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("processClick callback error=");
        ((StringBuilder)localObject).append(paramIntent.getMessage());
        QLog.e("BridgeModule", 1, ((StringBuilder)localObject).toString());
      }
      paramIntent = this.shareVideoCallBackId;
      ReadInJoyLogicEngine.a().o();
      Object localObject = ShareReport.a;
      boolean bool;
      if (paramInt == -1) {
        bool = true;
      } else {
        bool = false;
      }
      ((ShareReport)localObject).a(bool);
      if (TextUtils.isEmpty(paramIntent)) {
        return;
      }
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("result", 1);
        invokeCallJS(paramIntent, localObject);
        return;
      }
      catch (Exception paramIntent)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("do call share friend back error:");
        ((StringBuilder)localObject).append(paramIntent.getMessage());
        QLog.e("BridgeModule", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void dealInviteFriendResult(Intent paramIntent)
  {
    BridgeModuleHelper.a(this, paramIntent);
  }
  
  private void dealRedPacketMVResult(int paramInt, Intent paramIntent)
  {
    BridgeModuleHelper.a(this, paramInt, paramIntent);
  }
  
  private void dealShareQzoneResult(int paramInt)
  {
    boolean bool = true;
    if (paramInt == -1)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("type", shareCallBackType);
        localJSONObject.put("action", shareCallBackName);
        localJSONObject.put("fromCallback", 1);
        if (!TextUtils.isEmpty(shareCallBackId)) {
          invokeCallJS(shareCallBackId, localJSONObject);
        }
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("processClick callback error=");
        localStringBuilder.append(localJSONException.getMessage());
        QLog.e("BridgeModule", 1, localStringBuilder.toString());
      }
    }
    ReadInJoyLogicEngine.a().o();
    ShareReport localShareReport = ShareReport.a;
    if (paramInt != -1) {
      bool = false;
    }
    localShareReport.a(bool);
  }
  
  private void dealTopicPicResult(int paramInt, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      if (paramInt == 0) {
        try
        {
          paramIntent = new JSONObject();
          paramIntent.put("retCode", 1);
          paramIntent.put("msg", HardCodeUtil.a(2131701406));
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("selectAndUploadAvatar  result:");
            ((StringBuilder)localObject1).append(((IRIJDeliverUGCUtils)QRoute.api(IRIJDeliverUGCUtils.class)).replaceUrlInLog(paramIntent.toString()));
            QLog.d("BridgeModule", 2, ((StringBuilder)localObject1).toString());
          }
          if (!TextUtils.isEmpty(this.mUploadCallBack))
          {
            invokeCallJS(this.mUploadCallBack, paramIntent);
            return;
          }
        }
        catch (Exception paramIntent)
        {
          if (QLog.isColorLevel()) {
            QLog.e("BridgeModule", 2, QLog.getStackTraceString(paramIntent));
          }
        }
      }
      return;
    }
    Object localObject1 = paramIntent.getStringExtra("callbackId");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    Object localObject2;
    if (paramInt == -1)
    {
      localObject2 = paramIntent.getBundleExtra("Bundle");
      if (localObject2 != null)
      {
        paramInt = ((Bundle)localObject2).getInt("retCode");
        paramIntent = ((Bundle)localObject2).getString("url");
        String str = ((Bundle)localObject2).getString("msg");
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("retCode", paramInt);
          ((JSONObject)localObject2).put("url", paramIntent);
          ((JSONObject)localObject2).put("msg", str);
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("selectAndUploadAvatar  result:");
            paramIntent.append(((IRIJDeliverUGCUtils)QRoute.api(IRIJDeliverUGCUtils.class)).replaceUrlInLog(((JSONObject)localObject2).toString()));
            QLog.d("BridgeModule", 2, paramIntent.toString());
          }
          invokeCallJS((String)localObject1, localObject2);
          return;
        }
        catch (Exception paramIntent)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        QLog.e("BridgeModule", 2, QLog.getStackTraceString(paramIntent));
      }
    }
    else
    {
      try
      {
        paramIntent = new JSONObject();
        paramIntent.put("retCode", -1);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(" selectAndUploadAvatar result:");
          ((StringBuilder)localObject2).append(paramIntent.toString());
          QLog.d("BridgeModule", 2, ((StringBuilder)localObject2).toString());
        }
        invokeCallJS((String)localObject1, paramIntent);
        return;
      }
      catch (Exception paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BridgeModule", 2, QLog.getStackTraceString(paramIntent));
        }
      }
    }
  }
  
  private void doOnVideoPublish(UgcVideo paramUgcVideo)
  {
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPublish, title =");
    ((StringBuilder)localObject).append(paramUgcVideo.title);
    QLog.i("BridgeModule", 1, ((StringBuilder)localObject).toString());
    if (localQQAppInterface == null) {
      return;
    }
    localObject = (String)this.columnToUploadCallbackMap.get(Long.valueOf(0L));
    if ((localObject != null) && (!((String)localObject).isEmpty())) {
      RIJUgcVideoPublishManager.a(localQQAppInterface).a(0L, new BridgeModule.16(this, (String)localObject));
    }
    localObject = (String)this.columnToUploadCallbackMap.get(Long.valueOf(paramUgcVideo.columnId));
    if ((localObject != null) && (!((String)localObject).isEmpty())) {
      RIJUgcVideoPublishManager.a(localQQAppInterface).a(paramUgcVideo.columnId, new BridgeModule.17(this, paramUgcVideo, (String)localObject));
    }
  }
  
  private void doPostShowComment(QBaseActivity paramQBaseActivity, VVideoView paramVVideoView, View paramView, ViewGroup paramViewGroup, JSONObject paramJSONObject, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void ensureEventHelper()
  {
    if (this.mEventHelper == null) {
      this.mEventHelper = new EventHelper(this);
    }
  }
  
  @Nullable
  private Activity getActivity()
  {
    ViolaInstance localViolaInstance = getViolaInstance();
    if (localViolaInstance == null) {
      return null;
    }
    return localViolaInstance.getActivity();
  }
  
  private void getRecentUserFace(String paramString, boolean paramBoolean)
  {
    Object localObject2 = (QQAppInterface)ReadInJoyUtils.a();
    Object localObject1 = getActivity();
    if (localObject1 == null)
    {
      QLog.e("BridgeModule", 1, "getRecentUserFace activity null");
      return;
    }
    localObject1 = VideoFeedsHelper.a((QQAppInterface)localObject2, (Activity)localObject1);
    if (paramBoolean) {
      localObject1 = VideoFeedsHelper.b((List)localObject1);
    } else {
      localObject1 = VideoFeedsHelper.a((List)localObject1);
    }
    localObject2 = ((IQQAvatarService)((QQAppInterface)localObject2).getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface)localObject2);
    if (localObject1 != null)
    {
      localObject2 = ((IFaceDecoder)localObject2).getBitmapFromCache(1, ((RecentUser)localObject1).uin);
      if (localObject2 != null)
      {
        localObject2 = ReadInJoyUtils.a(Bitmap.createScaledBitmap((Bitmap)localObject2, 128, 128, false));
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("uin", ((RecentUser)localObject1).uin);
          localJSONObject.put("imageBase64", localObject2);
          invokeCallJS(paramString, localJSONObject);
          return;
        }
        catch (Throwable paramString)
        {
          QLog.e("BridgeModule", 1, paramString.getMessage());
        }
      }
    }
  }
  
  private void getUploadingVideoList(@NotNull QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    ViolaBizUtils.a(this, paramQQAppInterface, paramLong, paramString);
  }
  
  private IViolaFragmentCommonContract getViolaFragmentContract()
  {
    Object localObject = getViolaInstance();
    if (localObject == null) {
      return null;
    }
    localObject = ((ViolaInstance)localObject).getFragment();
    if ((localObject instanceof IViolaFragmentCommonContract)) {
      return (IViolaFragmentCommonContract)localObject;
    }
    return null;
  }
  
  private void handleCommentEditorNativeResult(int paramInt, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    String str2 = paramIntent.getStringExtra("arg_callback");
    if (paramInt != -1)
    {
      handleCommentEditorNativeResultWhenCancel(str2);
      return;
    }
    String str1 = paramIntent.getStringExtra("arg_result_json");
    Object localObject1 = null;
    try
    {
      localObject2 = new JSONObject(str1);
    }
    catch (JSONException localJSONException)
    {
      Object localObject2;
      label52:
      JSONArray localJSONArray;
      CommentData localCommentData;
      int i;
      boolean bool3;
      boolean bool2;
      boolean bool1;
      break label52;
    }
    QLog.e("BridgeModule", 1, "handleCommentEditorNativeResult result parse error.");
    localObject2 = null;
    if (localObject2 == null) {
      return;
    }
    localJSONArray = ((JSONObject)localObject2).optJSONArray("linkList");
    if (localJSONArray != null)
    {
      localObject1 = new BridgeModule.10(this).getType();
      localObject1 = (List)new Gson().fromJson(localJSONArray.toString(), (Type)localObject1);
    }
    paramInt = ((JSONObject)localObject2).optInt("biuAfterComment");
    localCommentData = new CommentData();
    RIJCommentRptDataUtil.a((JSONObject)localObject2, localCommentData);
    i = ((JSONObject)localObject2).optInt("feedsType");
    localObject2 = new BridgeModule.11(this, (JSONObject)localObject2, localCommentData, localJSONArray, str2);
    paramIntent = paramIntent.getParcelableExtra("comment_create_data");
    bool3 = paramIntent instanceof FirstCommentCreateData;
    bool2 = false;
    bool1 = false;
    if (bool3)
    {
      paramIntent = (FirstCommentCreateData)paramIntent;
      paramIntent.a(localCommentData.commentContent);
      paramIntent.a(localCommentData.commentRptDataList);
      paramIntent.b((List)localObject1);
      localObject1 = RIJCommentNetworkWrapper.INSTANCE;
      if (paramInt == 1) {
        bool1 = true;
      }
      ((RIJCommentNetworkWrapper)localObject1).createFirstComment(paramIntent, (IRIJCommentNetworkHelper.RIJCreateCommentObserver)localObject2, str1, i, false, bool1);
      return;
    }
    if ((paramIntent instanceof SubCommentCreateData))
    {
      paramIntent = (SubCommentCreateData)paramIntent;
      paramIntent.d(localCommentData.commentContent);
      paramIntent.a(localCommentData.commentRptDataList);
      paramIntent.b((List)localObject1);
      localObject1 = RIJCommentNetworkWrapper.INSTANCE;
      bool1 = bool2;
      if (paramInt == 1) {
        bool1 = true;
      }
      ((RIJCommentNetworkWrapper)localObject1).createSubComment(paramIntent, (IRIJCommentNetworkHelper.RIJCreateCommentObserver)localObject2, str1, i, false, bool1);
    }
  }
  
  private void handleCommentEditorNativeResultWhenCancel(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retCode", -1);
      localJSONObject.put("commentId", 0);
    }
    catch (JSONException localJSONException)
    {
      label29:
      break label29;
    }
    QLog.e("BridgeModule", 1, "handleCommentEditorNativeResult put user cancel result error.");
    invokeCallJS(paramString, localJSONObject);
  }
  
  private void handleCommentEditorResult(int paramInt, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    String str = paramIntent.getStringExtra("arg_callback");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    Object localObject;
    if (paramInt == 1699)
    {
      localObject = this.dataManager;
      if (localObject != null) {
        ((RIJBiuAndCommentMixDataManager)localObject).a();
      }
      this.dataManager = new RIJBiuAndCommentMixDataManager();
      ((IUiApiPlugin)QRoute.api(IUiApiPlugin.class)).handleInfoAndRequestForWeb(paramIntent, this.dataManager, str, new BridgeModule.9(this));
      return;
    }
    paramIntent = paramIntent.getStringExtra("arg_result_json");
    try
    {
      if (!TextUtils.isEmpty(paramIntent)) {
        paramIntent = new JSONObject(paramIntent);
      } else {
        paramIntent = new JSONObject();
      }
      if (paramInt == -1) {
        paramIntent.put("retCode", 0);
      } else {
        paramIntent.put("retCode", -1);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ReadInJoyDeliverUGCActivity.replaceUrlInLog result:");
        ((StringBuilder)localObject).append(((IRIJDeliverUGCUtils)QRoute.api(IRIJDeliverUGCUtils.class)).replaceUrlInLog(paramIntent.toString()));
        QLog.d("BridgeModule", 2, ((StringBuilder)localObject).toString());
      }
      invokeCallJS(str, paramIntent);
      return;
    }
    catch (Exception paramIntent)
    {
      label211:
      break label211;
    }
    QLog.e("BridgeModule", 1, "handleCommentEditorResult json put data exception.");
  }
  
  private void handleResultFromAddVideo(int paramInt, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramInt != 3) {
        return;
      }
      Object localObject = paramIntent.getStringExtra("arg_callback");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      try
      {
        paramInt = paramIntent.getIntExtra("key_column_id", 0);
        localJSONObject.put("errorCode", 0);
        localJSONObject.put("errorMsg", "");
        localJSONObject.put("topicId", paramInt);
        invokeJS((String)localObject, localJSONObject);
        return;
      }
      catch (JSONException paramIntent)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ReadInJoyAddUgcVideo fail ! ");
        ((StringBuilder)localObject).append(paramIntent.toString());
        QLog.d("BridgeModule", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void handleResultFromManageColumn(int paramInt, Intent paramIntent)
  {
    Object localObject;
    JSONObject localJSONObject;
    if (paramIntent != null)
    {
      if ((paramInt != 1) && (paramInt != 2)) {
        return;
      }
      localObject = paramIntent.getStringExtra("arg_callback");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      localJSONObject = new JSONObject();
    }
    for (paramInt = 0;; paramInt = -1)
    {
      try
      {
        if (!paramIntent.getBooleanExtra("key_publish_result", false)) {
          continue;
        }
        localJSONObject.put("errCode", paramInt);
        paramIntent = (ColumnInfo)paramIntent.getParcelableExtra("key_column_info");
        if (paramIntent != null) {
          localJSONObject.put("topicId", paramIntent.columnID);
        }
        invokeJS((String)localObject, localJSONObject);
        return;
      }
      catch (JSONException paramIntent)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ReadInJoyManageUgcColumn fail ! ");
        ((StringBuilder)localObject).append(paramIntent.toString());
        QLog.d("BridgeModule", 1, ((StringBuilder)localObject).toString());
      }
      return;
    }
  }
  
  @JSMethod
  public static boolean isRowkeyHasConsume(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return sConsumeCardMap.containsKey(paramString);
  }
  
  private ColumnInfo parseJson2ColumnInfo(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("topicId");
    paramJSONObject = paramJSONObject.optString("title");
    ColumnInfo localColumnInfo = new ColumnInfo();
    localColumnInfo.columnID = i;
    localColumnInfo.title = paramJSONObject;
    return localColumnInfo;
  }
  
  private CommunityInfo parseJson2CommunityInfo(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("kdCommunityInfo");
    if (paramJSONObject != null)
    {
      CommunityInfo localCommunityInfo = new CommunityInfo();
      localCommunityInfo.setTitle(paramJSONObject.optString("communityName"));
      localCommunityInfo.setCommunityId(String.valueOf(paramJSONObject.optInt("communityId")));
      return localCommunityInfo;
    }
    return null;
  }
  
  private UgcEntryExtraInfo parseJson2UgcEntryExtraInfo(JSONObject paramJSONObject)
  {
    UgcEntryExtraInfo localUgcEntryExtraInfo = new UgcEntryExtraInfo();
    localUgcEntryExtraInfo.b(paramJSONObject.optBoolean("showPublishToast", true));
    localUgcEntryExtraInfo.a(paramJSONObject.optBoolean("showKdCommunityEntry", false));
    return localUgcEntryExtraInfo;
  }
  
  private void registerActivityResultAction()
  {
    this.mResultActionMap.put(114, new BridgeModule.DeliverUGCAction(this));
    this.mResultActionMap.put(115, new BridgeModule.DeliverUGCAction(this));
    this.mResultActionMap.put(116, new BridgeModule.DeliverUGCAction(this));
    this.mResultActionMap.put(122, new BridgeModule.DeliverUGCAction(this));
    this.mResultActionMap.put(113, new BridgeModule.BiuAction(this));
    this.mResultActionMap.put(119, new BridgeModule.InviteFriendAction(this));
    this.mResultActionMap.put(118, new BridgeModule.TopicPicAction(this));
    this.mResultActionMap.put(121, new BridgeModule.TopicPicAction(this));
    this.mResultActionMap.put(117, new BridgeModule.CommentEditorAction(this));
    this.mResultActionMap.put(126, new BridgeModule.CommentEditorNativeAction(this));
    this.mResultActionMap.put(21, new BridgeModule.ForwardAction(this));
    this.mResultActionMap.put(123, new BridgeModule.ManageColumnAction(this));
    this.mResultActionMap.put(124, new BridgeModule.AddVideoAction(this));
    this.mResultActionMap.put(101, new BridgeModule.RedPacketMVAction(this));
    this.mResultActionMap.put(125, new BridgeModule.ShareQzoneAction(this));
  }
  
  private void responseUploadingVideoList(long paramLong, @NotNull List<UgcVideo> paramList, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    ViolaBizUtils.a(this, paramLong, paramList, paramString1, paramInt, paramString2, paramBoolean);
  }
  
  public static void saveImageToLocal(String paramString)
  {
    BridgeModuleHelper.b(paramString);
  }
  
  public static void unRegisterReceiver()
  {
    if ((BaseApplicationImpl.getContext() != null) && (mGdtAppReceiver != null))
    {
      BaseApplicationImpl.getContext().unregisterReceiver(mGdtAppReceiver);
      mGdtAppReceiver = null;
    }
  }
  
  @JSMethod
  public void accountInfoPageUploadButtonClick(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.optInt("fromType");
    RIJEntryViewUtils.a.a(QBaseActivity.sTopActivity, RIJEntryViewUtils.a.b(), parseJson2ColumnInfo(paramJSONObject), parseJson2CommunityInfo(paramJSONObject), i, paramString, 124);
  }
  
  @JSMethod
  public void adFreshAddAdId(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      ((IRIJAdReqFreshService)QRoute.api(IRIJAdReqFreshService.class)).addAdId(paramJSONObject.optString("scene"), Long.valueOf(paramJSONObject.optLong("adId")));
      invokeCallJS(paramString, new JSONObject());
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("BridgeModule", 1, paramJSONObject.getMessage());
    }
  }
  
  @JSMethod
  public void adFreshFlushSceneAds(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      ((IRIJAdReqFreshService)QRoute.api(IRIJAdReqFreshService.class)).exitScene(paramJSONObject.optString("scene"));
      ((IRIJAdExposeFreshService)QRoute.api(IRIJAdExposeFreshService.class)).exitScene(paramJSONObject.optString("scene"));
      invokeCallJS(paramString, new JSONObject());
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("BridgeModule", 1, paramJSONObject.getMessage());
    }
  }
  
  @JSMethod
  public void adFreshGetExposeRate(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("value", ((IRIJAdReqFreshService)QRoute.api(IRIJAdReqFreshService.class)).getExposeRate());
      invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("BridgeModule", 1, paramString.getMessage());
    }
  }
  
  @JSMethod
  public void adFreshGetRequestAdIds(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject = ((IRIJAdReqFreshService)QRoute.api(IRIJAdReqFreshService.class)).getRequestAdIds();
      JSONArray localJSONArray = new JSONArray();
      if ((localObject != null) && (((Set)localObject).size() > 0))
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localJSONArray.put((Long)((Iterator)localObject).next());
        }
      }
      localJSONObject.put("value", localJSONArray);
      invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("BridgeModule", 1, paramString.getMessage());
    }
  }
  
  @JSMethod
  public void adFreshIsExposed(JSONObject paramJSONObject, String paramString)
  {
    for (;;)
    {
      try
      {
        boolean bool = ((IRIJAdExposeFreshService)QRoute.api(IRIJAdExposeFreshService.class)).isExposed(paramJSONObject.optLong("adId"));
        paramJSONObject = new JSONObject();
        if (bool)
        {
          i = 1;
          paramJSONObject.put("isExpose", i);
          invokeCallJS(paramString, paramJSONObject);
          return;
        }
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e("BridgeModule", 1, paramJSONObject.getMessage());
        return;
      }
      int i = 0;
    }
  }
  
  @JSMethod
  public void adFreshRemoveAdId(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      ((IRIJAdReqFreshService)QRoute.api(IRIJAdReqFreshService.class)).removeAdFromAllScene(Long.valueOf(paramJSONObject.optLong("adId")));
      invokeCallJS(paramString, new JSONObject());
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("BridgeModule", 1, paramJSONObject.getMessage());
    }
  }
  
  @JSMethod
  public void adGetMemoryCache(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      invokeCallJS(paramString, MemoryCacheManager.a(paramJSONObject.optString("key")));
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("BridgeModule", 1, paramJSONObject.getMessage());
    }
  }
  
  @JSMethod
  public void adSetMemoryCache(JSONObject paramJSONObject, String paramString)
  {
    for (;;)
    {
      try
      {
        boolean bool = MemoryCacheManager.a(paramJSONObject.optString("key"), paramJSONObject.optJSONObject("obj"));
        paramJSONObject = new JSONObject();
        if (bool)
        {
          i = 0;
          paramJSONObject.put("code", i);
          invokeCallJS(paramString, paramJSONObject);
          return;
        }
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e("BridgeModule", 1, paramJSONObject.getMessage());
        return;
      }
      int i = 1;
    }
  }
  
  @JSMethod
  public void addColorBall()
  {
    ViolaFragment localViolaFragment = getViolaFragment();
    if (localViolaFragment == null) {
      return;
    }
    localViolaFragment.addToColorBall();
  }
  
  public void addEventListener(JSONObject paramJSONObject, String paramString)
  {
    ensureEventHelper();
    this.mEventHelper.a(paramJSONObject, paramString);
  }
  
  @JSMethod
  public void addFavorite(JSONObject paramJSONObject)
  {
    ViolaBizUtils.b(this, paramJSONObject);
  }
  
  public void addFriend(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramString = paramJSONObject.optString("uin");
      int i = paramJSONObject.optInt("sourceId");
      int j = paramJSONObject.optInt("subId");
      paramJSONObject = getActivity();
      paramString = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramJSONObject, 1, paramString, null, i, j, null, null, null, paramJSONObject.getString(2131689589), null);
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(paramJSONObject, paramString);
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("BridgeModule", 1, "addFriend exception e = ", paramJSONObject);
    }
  }
  
  @JSMethod
  public void addVideoFeedsUserOperation(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    int i = ViolaUtils.getInt(paramJSONObject.opt("type"));
    float f = ViolaUtils.getFloat(paramJSONObject.opt("progress"));
    paramJSONObject = ViolaUtils.getString(paramJSONObject.opt("rowKey"), "");
    RIJFeedsDynamicInsertController.INSTANCE.requestInsertArticlesAndRecordAction(paramJSONObject, createRIJFeedsInsertAction(i, (int)f), 6);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("operation: ");
      localStringBuilder.append(i);
      localStringBuilder.append(", rowKey: ");
      localStringBuilder.append(paramJSONObject);
      localStringBuilder.append(", watchProgress: ");
      localStringBuilder.append(f);
      QLog.d("BridgeModule", 2, localStringBuilder.toString());
    }
  }
  
  public void addViolaPageByUrl(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.t(this, paramJSONObject, paramString);
  }
  
  public void arouseReadInJoyNativeCommentView(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      arouseReadInJoyNativeCommentView(paramJSONObject, bindCommentCallback(paramString));
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("BridgeModule", 1, "arouseReadInJoyNativeCommentView Exception:", paramJSONObject);
    }
  }
  
  public void batchCheckUpdate(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.A(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void c2sReport(JSONObject paramJSONObject)
  {
    BridgeModuleHelper.g(paramJSONObject);
  }
  
  public void callback(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getString("action");
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("callback: action=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("BridgeModule", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject3;
    if ("onCommentSend".equals(localObject1)) {
      try
      {
        localObject1 = paramBundle.getString("commentId", "");
        localObject2 = paramBundle.getString("rowKey", "");
        localObject3 = paramBundle.getString("commentContent", "");
        int i = paramBundle.getInt("firstLevelComment");
        paramBundle = new JSONObject();
        paramBundle.put("commentId", localObject1);
        paramBundle.put("rowKey", localObject2);
        paramBundle.put("commentContent", localObject3);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(i + 1);
        ((StringBuilder)localObject1).append("");
        paramBundle.put("firstLevelComment", ((StringBuilder)localObject1).toString());
        paramBundle.put("result", "success");
        paramBundle.put("type", "onCommentSend");
        invokeCallJS(this.commentCallbaclId, paramBundle);
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
    if ("onCommentLike".equals(localObject1)) {
      try
      {
        localObject1 = paramBundle.getString("commentId", "");
        localObject2 = paramBundle.getString("rowKey", "");
        paramBundle = paramBundle.getString("likeStatus", "");
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("commentId", localObject1);
        ((JSONObject)localObject3).put("rowKey", localObject2);
        ((JSONObject)localObject3).put("likeStatus", paramBundle);
        ((JSONObject)localObject3).put("result", "success");
        ((JSONObject)localObject3).put("type", "onCommentLike");
        invokeCallJS(this.commentCallbaclId, localObject3);
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
    if ("onCommentDelete".equals(localObject1)) {
      try
      {
        localObject1 = paramBundle.getString("commentId", "");
        paramBundle = paramBundle.getString("rowKey", "");
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("commentId", localObject1);
        ((JSONObject)localObject2).put("rowKey", paramBundle);
        ((JSONObject)localObject2).put("result", "success");
        ((JSONObject)localObject2).put("type", "onCommentDelete");
        invokeJS(this.commentCallbaclId, (JSONObject)localObject2);
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
    if ("onPanelClose".equals(localObject1)) {
      try
      {
        paramBundle = paramBundle.getString("rowKey", "");
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("rowKey", paramBundle);
        ((JSONObject)localObject1).put("result", "success");
        ((JSONObject)localObject1).put("type", "onPanelClose");
        invokeJS(this.commentCallbaclId, (JSONObject)localObject1);
        if (this.mClient != null)
        {
          this.mClient.a(this.mCommentSeq);
          this.mCommentSeq = -1;
        }
        paramBundle = new StringBuilder();
        paramBundle.append("onPanelClose, hashCode: ");
        paramBundle.append(hashCode());
        QLog.d("BridgeModule", 1, paramBundle.toString());
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  public void canOpenPage(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.p(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void cancelColorBall()
  {
    ViolaFragment localViolaFragment = getViolaFragment();
    if (localViolaFragment == null) {
      return;
    }
    localViolaFragment.removeColorBall();
  }
  
  @JSMethod
  public void cancelFavorite(JSONObject paramJSONObject)
  {
    ViolaBizUtils.c(this, paramJSONObject);
  }
  
  @JSMethod
  public void cancelUploadingVideo(JSONObject paramJSONObject, String paramString)
  {
    ViolaBizUtils.b(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void cancelVideoPreDownload()
  {
    VideoPreDownloadMgr localVideoPreDownloadMgr = this.mVideoPreDownloadMgr;
    if (localVideoPreDownloadMgr != null) {
      localVideoPreDownloadMgr.d();
    }
  }
  
  @JSMethod
  public void channelRequestSign(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQ_");
    localStringBuilder.append(RIJQQAppInterfaceUtil.a());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    paramString1 = MD5.a(localStringBuilder.toString()).toLowerCase();
    if (getViolaInstance() != null) {
      ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString2, paramString1, true);
    }
  }
  
  @JSMethod
  public void chooseVideoAddToTopic(JSONObject paramJSONObject, String paramString)
  {
    ViolaBizUtils.e(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void clearMessageBoxData()
  {
    ReadInJoyLogicEngineEventDispatcher.a().f();
  }
  
  @JSMethod
  public void closeTopicVideoComment()
  {
    this.mCommentManager.c();
  }
  
  @JSMethod
  public void colorBallState(String paramString)
  {
    ViolaFragment localViolaFragment = getViolaFragment();
    if (localViolaFragment == null) {
      return;
    }
    int i = localViolaFragment.colorBallState();
    try
    {
      invokeJS(paramString, new JSONObject().put("state", i));
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("BridgeModule", 1, paramString.getMessage());
    }
  }
  
  @JSMethod
  public void deleteArticleByArticleInfos(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    paramJSONObject = paramJSONObject.optJSONArray("articleInfos");
    if (paramJSONObject == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      if (localJSONObject != null) {
        localArrayList.add(new ExposureArticle(ViolaUtils.getString(localJSONObject.opt("rowkey"), ""), ViolaUtils.getBoolean(localJSONObject.opt("isAd"))));
      }
      i += 1;
    }
    RIJFeedsDynamicInsertController.INSTANCE.deleteArticle(localArrayList);
  }
  
  @JSMethod
  public void deleteArticleByRowKeys(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    paramJSONObject = paramJSONObject.optJSONArray("rowKeys");
    if (paramJSONObject == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONObject.length())
    {
      String str = ViolaUtils.getString(paramJSONObject.opt(i), "");
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(new ExposureArticle(str, false));
      }
      i += 1;
    }
    RIJFeedsDynamicInsertController.INSTANCE.deleteArticle(localArrayList);
  }
  
  public void destroy()
  {
    Object localObject = this.mShareHelper;
    if (localObject != null)
    {
      ((ReadInJoyShareHelperV2)localObject).b();
      this.mShareHelper = null;
    }
    localObject = this.mEventHelper;
    if (localObject != null)
    {
      ((EventHelper)localObject).a();
      this.mEventHelper = null;
    }
    localObject = this.mClient;
    if (localObject != null) {
      ((TroopMemberApiClient)localObject).b();
    }
    localObject = this.mShareUtils;
    if (localObject != null) {
      ((QShareUtils)localObject).a();
    }
    localObject = this.mCommentManager;
    if (localObject != null) {
      ((ViolaCommentManager)localObject).d();
    }
    this.mCommentManager = null;
    localObject = this.netInfoHandler;
    if (localObject != null) {
      AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject);
    }
    localObject = this.mVideoPreDownloadMgr;
    if (localObject != null)
    {
      ((VideoPreDownloadMgr)localObject).d();
      this.mVideoPreDownloadMgr.a();
      this.mVideoPreDownloadMgr = null;
    }
    localObject = this.violaVideoUpdateController;
    if (localObject != null) {
      ((ViolaVideoUpdateController)localObject).b();
    }
    localObject = RIJQQAppInterfaceUtil.a();
    if (localObject != null)
    {
      RIJUgcVideoPublishManager.a((AppRuntime)localObject).b(this.videoPublishCallback);
      RIJUgcVideoPublishManager.a((AppRuntime)localObject).b(this.updateUgcVideoInfoCallback);
    }
    if (QLog.isColorLevel()) {
      QLog.d("BridgeModule", 2, "destroy by instance");
    }
    localObject = this.dataManager;
    if (localObject != null) {
      ((RIJBiuAndCommentMixDataManager)localObject).a();
    }
    localObject = this.mLikeAnimateManager;
    if (localObject != null) {
      ((VideoFeedsLikeAnimateManager)localObject).a();
    }
  }
  
  public void detailLog(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.v(this, paramJSONObject, paramString);
  }
  
  public void directSocialShare(JSONObject paramJSONObject, int paramInt)
  {
    Activity localActivity = getActivity();
    if (localActivity == null) {
      return;
    }
    this.mShareUtils.a(paramJSONObject, paramInt, localActivity, "", 0, "");
  }
  
  public void disableSwitcher()
  {
    BridgeModuleHelper.a(this);
  }
  
  @JSMethod
  public void dismissColorBall()
  {
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, false);
  }
  
  public void dispatchEvent(JSONObject paramJSONObject, String paramString)
  {
    ensureEventHelper();
    this.mEventHelper.c(paramJSONObject, paramString);
  }
  
  public void doSelectAndUploadAvatar(JSONObject paramJSONObject, String paramString)
  {
    this.mUploadCallBack = paramString;
    BridgeModuleHelper.a(paramJSONObject, paramString, getViolaInstance().getActivity());
  }
  
  public void doUploadTopicPic(JSONObject paramJSONObject, String paramString)
  {
    this.mUploadCallBack = paramString;
    BridgeModuleHelper.b(paramJSONObject, paramString, getViolaInstance().getActivity());
  }
  
  public void downloadApk(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      DownloadInfo localDownloadInfo = new DownloadInfo();
      String str = paramJSONObject.optString("apkUrl");
      localDownloadInfo.d = str;
      localDownloadInfo.e = paramJSONObject.optString("packageName", null);
      localDownloadInfo.m = "biz_src_feeds_kandianads";
      localDownloadInfo.h = paramJSONObject.optString("via");
      if (this.mDownloadListener == null) {
        this.mDownloadListener = new BridgeModule.DownloadListenerImp(this, str, paramString);
      }
      DownloadManagerV2.a().a(this.mDownloadListener);
      localDownloadInfo.a();
      DownloadManagerV2.a().b(localDownloadInfo);
    }
  }
  
  public void downloadApkAction(JSONObject paramJSONObject)
  {
    BridgeModuleHelper.c(paramJSONObject);
  }
  
  public void downloadApkCancel(JSONObject paramJSONObject)
  {
    BridgeModuleHelper.f(paramJSONObject);
  }
  
  public void downloadApkPause(JSONObject paramJSONObject)
  {
    BridgeModuleHelper.d(paramJSONObject);
  }
  
  public void downloadApkResume(JSONObject paramJSONObject)
  {
    BridgeModuleHelper.e(paramJSONObject);
  }
  
  public void downloadApp(String paramString)
  {
    BridgeModuleHelper.p(this, paramString);
  }
  
  public void downloadForGooglePlay(String paramString)
  {
    BridgeModuleHelper.a(paramString);
  }
  
  @JSMethod
  public void dwellTimeMillisReport(JSONObject paramJSONObject)
  {
    BridgeModuleHelper.h(paramJSONObject);
  }
  
  @JSMethod
  public void enableColorNoteSwipeAndFlingGesture(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    ViolaFragment localViolaFragment = getViolaFragment();
    if (localViolaFragment == null) {
      return;
    }
    localViolaFragment.enableColorNoteSwipeAndFlingGesture(paramJSONObject.optBoolean("enableColorNoteSwipe", true), paramJSONObject.optBoolean("enableFlingRight", true));
  }
  
  @JSMethod
  public void enableColorNoteSwipeRight(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      QLog.e("BridgeModule", 1, "[enableColorNoteSwipeRight]: jsonObject is null");
      return;
    }
    ViolaFragment localViolaFragment = getViolaFragment();
    if (localViolaFragment == null)
    {
      QLog.e("BridgeModule", 1, "[enableColorNoteSwipeRight]: Fragment is null");
      return;
    }
    localViolaFragment.enableColorNoteSwipeRight(paramJSONObject.optBoolean("enable", true));
  }
  
  @JSMethod
  public void enableFlingGesture(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    ViolaFragment localViolaFragment = getViolaFragment();
    if (localViolaFragment == null) {
      return;
    }
    localViolaFragment.enableFlingGesture(paramJSONObject.optBoolean("enable", true));
  }
  
  @JSMethod
  public void exeUGCPrivilegeLike(String paramString)
  {
    if ((getViolaInstance() != null) && (getViolaInstance().getActivity() != null)) {
      RIJUserLevelModule.getInstance().doActionsByUserLevel(getViolaInstance().getActivity(), 3, new BridgeModule.18(this, paramString));
    }
  }
  
  public void feedsRefreshMessage(JSONObject paramJSONObject)
  {
    UserReadUnReadInfoManager.a().a(paramJSONObject);
  }
  
  @JSMethod
  public void fetchReadInJoyAccountInfoList(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.D(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void fetchReadInJoyUserInfo(String paramString)
  {
    ViolaBizUtils.a(this, paramString);
  }
  
  public void fireGetLocation(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.C(this, paramJSONObject, paramString);
  }
  
  @JSMethod(uiThread=false)
  public void getALDConfig(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.l(this, paramJSONObject, paramString);
  }
  
  public void getBiuTriggerType(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.g(this, paramJSONObject, paramString);
  }
  
  public void getCUKingStatus(String paramString)
  {
    BridgeModuleHelper.k(this, paramString);
  }
  
  public void getClientInfo(String paramString)
  {
    BridgeModuleHelper.j(this, paramString);
  }
  
  public void getConsumeTime(JSONObject paramJSONObject, String paramString)
  {
    int i = RIJRewardTaskLocalRepo.b().a(true) / 1000;
    int j = RIJRewardTaskConfig.b();
    int k = RIJRewardTaskConfig.a() / 1000;
    int m = RIJRewardTaskLocalRepo.b().a();
    try
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("currentTotalConsumeTime", m * k + i);
      paramJSONObject.put("redPackTotalTime", k);
      paramJSONObject.put("rewardTotalTaskCount", j);
      invokeCallJS(paramString, paramJSONObject);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("BridgeModule", 1, QLog.getStackTraceString(paramJSONObject));
    }
  }
  
  @JSMethod
  public void getCreateTopicPermission(JSONObject paramJSONObject, String paramString)
  {
    getReadInJoyUgcPermission(paramJSONObject, paramString, 1);
  }
  
  @JSMethod
  public String getCurrentUserEncryptedUin()
  {
    return ReadInJoyUtils.a();
  }
  
  public JSONObject getDeviceInfo()
  {
    return BridgeModuleHelper.b();
  }
  
  @JSMethod(uiThread=false)
  public void getDeviceInfo(String paramString)
  {
    getDeviceInfo(paramString, false);
  }
  
  public void getDeviceInfo(String paramString, boolean paramBoolean)
  {
    BridgeModuleHelper.b(this, paramString, paramBoolean);
  }
  
  public void getDownloadApkState(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.u(this, paramJSONObject, paramString);
  }
  
  public JSONObject getFailInvokeObj(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("code", -1);
      localJSONObject.put("errorText", paramString);
      return localJSONObject;
    }
    catch (JSONException paramString) {}
    return localJSONObject;
  }
  
  @Nullable
  public Object getField(String paramString)
  {
    return this.mObjectMap.get(paramString);
  }
  
  @JSMethod(uiThread=false)
  public void getGdtDeviceInfo(String paramString, JSONObject paramJSONObject)
  {
    getGdtDeviceInfo(paramString, paramJSONObject, true);
  }
  
  public void getGdtDeviceInfo(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    BridgeModuleHelper.a(this, paramString, paramJSONObject, paramBoolean);
  }
  
  public void getGdtInfo(String paramString)
  {
    BridgeModuleHelper.l(this, paramString);
  }
  
  @JSMethod
  public void getMotiveAd(String paramString, JSONObject paramJSONObject)
  {
    BridgeModuleHelper.a(this, paramString, paramJSONObject);
  }
  
  @JSMethod
  public void getNavHeight(String paramString)
  {
    Object localObject1;
    if (SplashActivity.sWeakInstance != null) {
      localObject1 = (Activity)SplashActivity.sWeakInstance.get();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = QBaseActivity.sTopActivity;
    }
    if (localObject2 == null) {
      return;
    }
    try
    {
      int i = ViolaBizUtils.a((ViewGroup)((Activity)localObject2).getWindow().getDecorView());
      localObject1 = new JSONObject();
      localObject2 = BaseApplication.getContext().getResources().getDisplayMetrics();
      ((JSONObject)localObject1).put("navHeight", i / ((DisplayMetrics)localObject2).density);
      invokeJS(paramString, (JSONObject)localObject1);
      return;
    }
    catch (Exception paramString)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getNavHeight: ");
      ((StringBuilder)localObject1).append(paramString.getMessage());
      QLog.e("BridgeModule", 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  @JSMethod(uiThread=false)
  public void getNetType(String paramString)
  {
    getNetType(paramString, false);
  }
  
  public void getNetType(String paramString, boolean paramBoolean)
  {
    int i = HttpUtil.getNetWorkType();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getNetType,netType:");
      ((StringBuilder)localObject).append(i);
      QLog.d("BridgeModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("result", i);
      label65:
      if (paramBoolean) {
        invokeCallJS(paramString, localObject);
      } else {
        ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString, localObject, true);
      }
      vaNetworkChange(paramString);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label65;
    }
  }
  
  public void getNetworkInfo(String paramString, boolean paramBoolean)
  {
    BridgeModuleHelper.c(this, paramString, paramBoolean);
  }
  
  public void getPerformance(String paramString)
  {
    ViolaInstance localViolaInstance = getViolaInstance();
    if (localViolaInstance == null) {
      return;
    }
    invokeCallJS(paramString, localViolaInstance.getMainPerformance());
  }
  
  protected void getReadInJoyUgcPermission(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    ViolaBizUtils.a(this, paramJSONObject, paramString, paramInt);
  }
  
  @JSMethod
  public void getRecentFriendInfo(String paramString)
  {
    getRecentUserFace(paramString, false);
  }
  
  @JSMethod
  public void getRecentGroupInfo(String paramString)
  {
    getRecentUserFace(paramString, true);
  }
  
  public void getRecommendFlag(String paramString)
  {
    BridgeModuleHelper.m(this, paramString);
  }
  
  public JSONObject getSuccInvokeObj(Object paramObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("code", 0);
      localJSONObject.put("errorText", "");
      if (paramObject != null)
      {
        localJSONObject.put("data", paramObject);
        return localJSONObject;
      }
      localJSONObject.put("data", new JSONObject());
      return localJSONObject;
    }
    catch (JSONException paramObject) {}
    return localJSONObject;
  }
  
  @JSMethod
  public void getUploadVideoPermission(JSONObject paramJSONObject, String paramString)
  {
    getReadInJoyUgcPermission(paramJSONObject, paramString, 2);
  }
  
  @JSMethod
  public void getUploadingVideoInfo(JSONObject paramJSONObject, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getUploadingVideoInfo,callback=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", content=");
    localStringBuilder.append(paramJSONObject.toString());
    QLog.i("BridgeModule", 1, localStringBuilder.toString());
    int i = paramJSONObject.optInt("topicId");
    this.columnToUploadCallbackMap.put(Long.valueOf(i), paramString);
    paramJSONObject = RIJQQAppInterfaceUtil.a();
    if (paramJSONObject != null) {
      RIJUgcVideoPublishManager.a(paramJSONObject).a(this.videoPublishCallback);
    }
    if (this.violaVideoUpdateController == null) {
      this.violaVideoUpdateController = new ViolaVideoUpdateController(new BridgeModule.14(this, i, paramString), 500L);
    }
    this.violaVideoUpdateController.a();
  }
  
  public JSONObject getUserInfo()
  {
    return BridgeModuleHelper.a();
  }
  
  @JSMethod(uiThread=false)
  public void getUserInfo(String paramString)
  {
    getUserInfo(paramString, false);
  }
  
  public void getUserInfo(String paramString, boolean paramBoolean)
  {
    BridgeModuleHelper.a(this, paramString, paramBoolean);
  }
  
  @JSMethod
  public void getUserLiveStatus(String paramString1, String paramString2)
  {
    ViolaBizUtils.a(this, paramString1, paramString2);
  }
  
  @JSMethod
  public void getVideoFrameInfo(JSONObject paramJSONObject, String paramString)
  {
    ViolaBizUtils.a(this, paramJSONObject, paramString);
  }
  
  public ViolaFragment getViolaFragment()
  {
    Object localObject = getViolaInstance();
    if (localObject == null) {
      return null;
    }
    localObject = ((ViolaInstance)localObject).getFragment();
    if ((localObject instanceof ViolaFragment)) {
      return (ViolaFragment)localObject;
    }
    return null;
  }
  
  @JSMethod
  public void handleClick(JSONObject paramJSONObject)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    label414:
    for (;;)
    {
      try
      {
        GdtLog.b("BridgeModule", paramJSONObject.toString());
        JSONObject localJSONObject = paramJSONObject.getJSONObject("options");
        boolean bool1 = localJSONObject.getBoolean("reportForClick");
        boolean bool2 = localJSONObject.getBoolean("appAutoDownload");
        boolean bool3 = localJSONObject.optBoolean("videoCeilingSupported", false);
        boolean bool4 = localJSONObject.optBoolean("videoCeilingSupportedIfInstalled", false);
        boolean bool5 = localJSONObject.optBoolean("videoSpliceSupported", false);
        int i = localJSONObject.optInt("clickPosition", 0);
        long l = localJSONObject.optLong("videoStartPositionMillis", 0L);
        Object localObject = localJSONObject.optJSONObject("mediaViewLocationRect");
        Rect localRect = new Rect();
        if (localObject == null) {
          break label414;
        }
        int j = ((JSONObject)localObject).optInt("left", 0);
        try
        {
          int k = ((JSONObject)localObject).optInt("top", 0);
          int m = ((JSONObject)localObject).optInt("right", 0);
          int n = ((JSONObject)localObject).optInt("bottom", 0);
          localRect.left = j;
          localRect.top = k;
          localRect.right = m;
          localRect.bottom = n;
          paramJSONObject = (qq_ad_get.QQAdGetRsp.AdInfo)GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject.getJSONObject("adInfo"));
          localObject = new GdtHandler.Params();
          ((GdtHandler.Params)localObject).jdField_c_of_type_Int = 7;
          ((GdtHandler.Params)localObject).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localQBaseActivity);
          ((GdtHandler.Params)localObject).jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(paramJSONObject);
          ((GdtHandler.Params)localObject).jdField_a_of_type_Boolean = bool1;
          ((GdtHandler.Params)localObject).jdField_b_of_type_Boolean = bool2;
          if (mGdtAppReceiver == null)
          {
            mGdtAppReceiver = new GdtAppReceiver();
            mGdtAppReceiver.register(BaseApplicationImpl.getContext());
          }
          ((GdtHandler.Params)localObject).jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(mGdtAppReceiver);
          ((GdtHandler.Params)localObject).jdField_c_of_type_Boolean = bool3;
          ((GdtHandler.Params)localObject).d = bool4;
          ((GdtHandler.Params)localObject).e = bool5;
          ((GdtHandler.Params)localObject).jdField_a_of_type_AndroidGraphicsRect = localRect;
          ((GdtHandler.Params)localObject).jdField_b_of_type_Int = i;
          ((GdtHandler.Params)localObject).jdField_a_of_type_AndroidOsBundle = new Bundle();
          ((GdtHandler.Params)localObject).jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
          bool1 = localJSONObject.optBoolean("videoPlayForced", false);
          ((GdtHandler.Params)localObject).jdField_a_of_type_Long = l;
          ((GdtHandler.Params)localObject).f = bool1;
          GdtHandler.a((GdtHandler.Params)localObject);
          return;
        }
        catch (Throwable paramJSONObject) {}
        GdtLog.d("BridgeModule", "handleJsCallRequest error", paramJSONObject);
      }
      catch (Throwable paramJSONObject) {}
      return;
    }
  }
  
  @JSMethod
  public void hasApp(String paramString1, String paramString2)
  {
    hasApp(paramString1, paramString2, false);
  }
  
  public void hasApp(String paramString1, String paramString2, boolean paramBoolean)
  {
    BridgeModuleHelper.a(this, paramString1, paramString2, paramBoolean);
  }
  
  public void hasRedPacketSharePermission(String paramString)
  {
    BridgeModuleHelper.b(this, paramString);
  }
  
  @JSMethod
  public void hideFollowAlertView(JSONObject paramJSONObject, String paramString)
  {
    boolean bool = paramJSONObject.optBoolean("animated", true);
    RIJPushNotifyManager.Companion.a().dismiss(bool, "MATCH_ALL_UIN");
  }
  
  @JSMethod
  public void hideNavigationBar()
  {
    Object localObject = getActivity();
    if (localObject == null) {
      return;
    }
    localObject = ((Activity)localObject).getWindow().getDecorView();
    ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() | 0x1B02);
  }
  
  @JSMethod
  public void hideTopicVideoComment(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("ref", "");
    ViolaDomManager localViolaDomManager = ViolaSDKManager.getInstance().getDomManager();
    if (getViolaInstance() != null)
    {
      localViolaDomManager.getDomContext(getViolaInstance().getInstanceId()).getComponent(paramJSONObject);
      this.mCommentManager.c();
    }
  }
  
  @JSMethod
  public void insertCommentLink(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optJSONObject("linkData");
    paramJSONObject = (BaseCommentData.CommentLinkData)new Gson().fromJson(paramJSONObject.toString(), BaseCommentData.CommentLinkData.class);
    getActivity();
    SimpleEventBus.getInstance().dispatchEvent(new AddCommentLinkEvent(paramJSONObject));
    paramJSONObject = new JSONObject();
    try
    {
      paramJSONObject.put("errCode", 0);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    invokeJS(paramString, paramJSONObject);
  }
  
  @JSMethod
  public void invoke(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {
      return;
    }
    String str1 = paramJSONObject.optString("ns");
    String str2 = paramJSONObject.optString("method");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ns: ");
      localStringBuilder.append(str1);
      localStringBuilder.append(" method: ");
      localStringBuilder.append(str2);
      localStringBuilder.append(" params: ");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.d("BridgeModule", 1, localStringBuilder.toString());
      if (!this.bridgeInvokeHandler.a(str1, str2, paramJSONObject, paramString))
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("ns:");
        paramJSONObject.append(str1);
        paramJSONObject.append(HardCodeUtil.a(2131701413));
        paramJSONObject.append(str2);
        paramJSONObject.append(HardCodeUtil.a(2131701408));
        invokeErrorCallJS(paramString, paramJSONObject.toString());
      }
      return;
    }
    invokeErrorCallJS(paramString, HardCodeUtil.a(2131701417));
    QLog.d("BridgeModule", 1, "ns or method not exists");
  }
  
  public final void invokeCallJS(String paramString, Object paramObject)
  {
    InvokeCallJSCallback localInvokeCallJSCallback = this.invokeCallJSCallback;
    if (localInvokeCallJSCallback != null) {
      localInvokeCallJSCallback.invokeCallJS(paramString, paramObject);
    }
  }
  
  public final void invokeErrorCallJS(String paramString1, String paramString2)
  {
    InvokeCallJSCallback localInvokeCallJSCallback = this.invokeCallJSCallback;
    if (localInvokeCallJSCallback != null) {
      localInvokeCallJSCallback.invokeErrorCallJS(paramString1, paramString2);
    }
  }
  
  public final void invokeJS(String paramString, JSONObject paramJSONObject)
  {
    InvokeCallJSCallback localInvokeCallJSCallback = this.invokeCallJSCallback;
    if (localInvokeCallJSCallback != null) {
      localInvokeCallJSCallback.invokeJS(paramString, paramJSONObject);
    }
  }
  
  public void isCached(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.B(this, paramJSONObject, paramString);
  }
  
  public void isInkanDianTab(String paramString)
  {
    BridgeModuleHelper.a(this, paramString);
  }
  
  @JSMethod(uiThread=false)
  public void isKindCard(String paramString)
  {
    BridgeModuleHelper.o(this, paramString);
  }
  
  public void isMobileQQ(String paramString)
  {
    BridgeModuleHelper.n(this, paramString);
  }
  
  public void isNightMode(String paramString)
  {
    BridgeModuleHelper.i(this, paramString);
  }
  
  public boolean onActivityBack()
  {
    ViolaCommentManager localViolaCommentManager = this.mCommentManager;
    if ((localViolaCommentManager != null) && (localViolaCommentManager.b()))
    {
      int i;
      if (this.mIsRightExit) {
        i = 2;
      } else {
        i = 5;
      }
      this.mCommentManager.c(i);
      this.mCommentManager.a();
      return true;
    }
    return super.onActivityBack();
  }
  
  public void onActivityDestroy()
  {
    destroy();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = this.mCommentManager;
    if (localObject != null) {
      ((ViolaCommentManager)localObject).a(paramInt1, paramInt2, paramIntent);
    }
    localObject = (BridgeModule.ResultAction)this.mResultActionMap.get(paramInt1);
    if (localObject != null) {
      ((BridgeModule.ResultAction)localObject).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    AbstractGifImage.resumeAll();
    Activity localActivity = getActivity();
    if ((localActivity != null) && (localActivity.getIntent() != null) && (this.mCommentSeq != -1))
    {
      if (localActivity.getIntent().getBundleExtra("bundle") == null)
      {
        Bundle localBundle = new Bundle();
        localActivity.getIntent().putExtra("bundle", localBundle);
      }
      localActivity.getIntent().getBundleExtra("bundle").putInt("seq", this.mCommentSeq);
    }
  }
  
  @JSMethod
  public void onColumnSubscribeStatusChange(JSONObject paramJSONObject)
  {
    ViolaBizUtils.a(paramJSONObject);
  }
  
  public boolean onFlingLToR()
  {
    ViolaCommentManager localViolaCommentManager = this.mCommentManager;
    if ((localViolaCommentManager != null) && (localViolaCommentManager.b()))
    {
      this.mCommentManager.a();
      return true;
    }
    return false;
  }
  
  public void openAccountPageMore(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.b(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void openAddVideoView(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.optInt("fromType");
    RIJUgcUtils.a(QBaseActivity.sTopActivity, parseJson2ColumnInfo(paramJSONObject), parseJson2CommunityInfo(paramJSONObject), parseJson2UgcEntryExtraInfo(paramJSONObject), i, paramString, 124);
    paramJSONObject = RIJQQAppInterfaceUtil.a();
    if (paramJSONObject != null) {
      RIJUgcVideoPublishManager.a(paramJSONObject).a(this.updateUgcVideoInfoCallback);
    }
  }
  
  @JSMethod
  public void openApp(String paramString)
  {
    openApp(paramString, null, null);
  }
  
  public void openApp(String paramString1, String paramString2, String paramString3)
  {
    BridgeModuleHelper.a(this, paramString1, paramString2, paramString3);
  }
  
  @JSMethod
  public void openCreateTopicView(String paramString)
  {
    RIJUgcUtils.a(QBaseActivity.sTopActivity, paramString, 123);
  }
  
  @JSMethod
  public void openEditTopicView(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.optInt("topicId");
    String str1 = paramJSONObject.optString("iconUrl");
    String str2 = paramJSONObject.optString("title");
    String str3 = paramJSONObject.optString("intro");
    int j = paramJSONObject.optInt("submitPermission");
    RIJUgcUtils.a(QBaseActivity.sTopActivity, i, str1, str2, str3, j, paramString, 123);
  }
  
  @JSMethod
  public void openFrameDropUpload(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    IViolaFragmentCommonContract localIViolaFragmentCommonContract = getViolaFragmentContract();
    if (localIViolaFragmentCommonContract == null) {
      return;
    }
    localIViolaFragmentCommonContract.openFrameDropUpload(paramString);
  }
  
  @JSMethod(uiThread=true)
  public void openLevelDialog(JSONObject paramJSONObject, String paramString)
  {
    Object localObject1 = getViolaInstance();
    if (localObject1 != null) {
      localObject1 = ((ViolaInstance)localObject1).getActivity();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = QBaseActivity.sTopActivity;
    }
    RIJJumpUtils.a((Context)localObject2, paramJSONObject, new BridgeModule.12(this, paramString));
  }
  
  @JSMethod
  public void openMiniApp(String paramString, JSONObject paramJSONObject)
  {
    BridgeModuleHelper.b(this, paramString, paramJSONObject);
  }
  
  public void openPage(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.c(paramJSONObject, paramString);
  }
  
  public void openPrivateLetter()
  {
    BridgeModuleHelper.a(getViolaInstance().getContext());
  }
  
  @JSMethod
  public void openTopicVideoComment(JSONObject paramJSONObject, String paramString)
  {
    Object localObject1 = paramJSONObject.optString("ref", "");
    boolean bool = paramJSONObject.optBoolean("isRaiseBarrage");
    ViolaDomManager localViolaDomManager = ViolaSDKManager.getInstance().getDomManager();
    Object localObject2 = getViolaInstance();
    QBaseActivity localQBaseActivity;
    if ((localObject2 != null) && ((((ViolaInstance)localObject2).getActivity() instanceof QBaseActivity)))
    {
      localObject1 = localViolaDomManager.getDomContext(getViolaInstance().getInstanceId()).getComponent((String)localObject1);
      localQBaseActivity = (QBaseActivity)((ViolaInstance)localObject2).getActivity();
    }
    for (;;)
    {
      try
      {
        this.mCommentSeq = bindCommentCallback(paramString);
        if (localQBaseActivity.getIntent().getBundleExtra("bundle") == null)
        {
          paramString = new Bundle();
          localQBaseActivity.getIntent().putExtra("bundle", paramString);
        }
        localQBaseActivity.getIntent().getBundleExtra("bundle").putInt("seq", this.mCommentSeq);
        localViolaDomManager = null;
        if (localObject1 == null) {
          break label287;
        }
        paramString = ((VComponent)localObject1).getHostView();
        if (paramString == null) {
          break label292;
        }
        localObject1 = paramString.findViewWithTag("VVideoView");
        if (!(localObject1 instanceof VVideoView)) {
          break label298;
        }
        localObject1 = (VVideoView)localObject1;
        localObject2 = localViolaDomManager;
        if (bool)
        {
          localObject2 = localViolaDomManager;
          if (getViolaInstance() != null)
          {
            localObject2 = localViolaDomManager;
            if ((getViolaInstance().getRootView() instanceof ViewGroup)) {
              localObject2 = (ViewGroup)getViolaInstance().getRootView();
            }
          }
        }
        doPostShowComment(localQBaseActivity, (VVideoView)localObject1, paramString, (ViewGroup)localObject2, paramJSONObject, ViolaUtils.getBoolean(paramJSONObject.opt("enableFlingGesture")));
        return;
      }
      catch (Exception paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BridgeModule", 2, paramJSONObject, new Object[0]);
        }
      }
      return;
      label287:
      paramString = null;
      continue;
      label292:
      localObject1 = null;
      continue;
      label298:
      localObject1 = null;
    }
  }
  
  @JSMethod
  public void openUrl(String paramString, Bundle paramBundle)
  {
    BridgeModuleHelper.a(paramString, paramBundle);
  }
  
  public void openUrl(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.n(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void openUrlByJumpInfo(JSONObject paramJSONObject)
  {
    ViolaBizUtils.a(this, paramJSONObject);
  }
  
  @JSMethod
  public void openVideo(JSONObject paramJSONObject)
  {
    BridgeModuleHelper.a(paramJSONObject);
  }
  
  public void pageVisibility(String paramString)
  {
    BridgeModuleHelper.d(this, paramString);
  }
  
  @JSMethod
  public void pauseUploadingVideo(JSONObject paramJSONObject, String paramString)
  {
    ViolaBizUtils.d(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void performLikeAnimation(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    if (this.mLikeAnimateManager == null) {
      this.mLikeAnimateManager = new VideoFeedsLikeAnimateManager(getActivity(), 1);
    }
    float f1 = FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject.opt("pageX"), 750);
    float f2 = FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject.opt("pageY"), 750);
    this.mLikeAnimateManager.a(f1, f2);
  }
  
  public void popBack(String paramString)
  {
    InvokeCallJSCallback localInvokeCallJSCallback = this.invokeCallJSCallback;
    if (localInvokeCallJSCallback != null) {
      localInvokeCallJSCallback.popBack(paramString);
    }
  }
  
  @JSMethod(uiThread=true)
  public void popFromBottomStateChange(String paramString)
  {
    if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment))) {
      ((ViolaFragment)getViolaInstance().getFragment()).setViolaGestureLayoutListener(new BridgeModule.4(this, paramString));
    }
  }
  
  @JSMethod
  public void preLoadAfterAdLoaded(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      GdtLog.a("BridgeModule", paramJSONObject.toString());
      paramJSONObject = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject.getJSONObject("adInfo")));
      GdtPreLoader.a().a(paramJSONObject);
      invokeCallJS(paramString, "sucess");
      return;
    }
    catch (Exception paramJSONObject)
    {
      GdtLog.d("BridgeModule", "handleJsCallRequest", paramJSONObject);
      invokeCallJS(paramString, "error");
    }
  }
  
  public void removeEventListener(JSONObject paramJSONObject, String paramString)
  {
    ensureEventHelper();
    this.mEventHelper.b(paramJSONObject, paramString);
  }
  
  public void reportT(JSONObject paramJSONObject)
  {
    BridgeModuleHelper.b(paramJSONObject);
  }
  
  public void reportVideoShareClick(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, String paramString3, String paramString4, String paramString5)
  {
    BridgeModuleHelper.a(this, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramString3, paramString4, paramString5);
  }
  
  @JSMethod
  public void requestLikeAnimationIconUrls()
  {
    if (this.mLikeAnimateManager == null) {
      this.mLikeAnimateManager = new VideoFeedsLikeAnimateManager(getActivity(), 1);
    }
  }
  
  public void requestRedPacketContentShareToast(String paramString)
  {
    BridgeModuleHelper.c(this, paramString);
  }
  
  public void resetSatusBarBlackStyle()
  {
    Fragment localFragment = getViolaInstance().getFragment();
    if ((localFragment != null) && ((localFragment instanceof ViolaFragment))) {
      ((ViolaFragment)localFragment).setStatusBarFontColor(Boolean.valueOf(false), true);
    }
  }
  
  public void resetSatusBarWhiteStyle()
  {
    Fragment localFragment = getViolaInstance().getFragment();
    if ((localFragment != null) && ((localFragment instanceof ViolaFragment))) {
      ((ViolaFragment)localFragment).setStatusBarFontColor(Boolean.valueOf(false), true);
    }
  }
  
  @JSMethod
  public void resumeUploadingVideo(JSONObject paramJSONObject, String paramString)
  {
    ViolaBizUtils.c(this, paramJSONObject, paramString);
  }
  
  public void saveImage(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.x(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void savePlayPosition(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("videoTimeMap");
    if (paramJSONObject != null)
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        VideoResumeManager.a.a(str, paramJSONObject.optLong(str));
      }
    }
  }
  
  public void selectAndInviteFriend(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.b(paramJSONObject, paramString);
  }
  
  public void sendRequest(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      localObject1 = paramJSONObject.getString("host");
      localJSONObject = paramJSONObject.getJSONObject("data");
      str1 = paramJSONObject.getString("cmd");
      localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
      if ((localJSONObject == null) || (TextUtils.isEmpty((CharSequence)localObject1)) || (localQQAppInterface == null)) {
        break label480;
      }
      if (TextUtils.isEmpty(str1)) {
        return;
      }
      str2 = localJSONObject.toString();
      if (ViolaUtils.getBoolean(paramJSONObject.optString("disableFrequency"))) {
        break label501;
      }
      if (this.preTime != 0L)
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.preTime;
        i = this.minDuration;
        if (l1 - l2 < i * 1000)
        {
          paramJSONObject = new JSONObject();
          paramJSONObject.put("cret", 1);
          invokeCallJS(paramString, paramJSONObject);
          return;
        }
        if (str2.getBytes().length > this.maxSize)
        {
          paramJSONObject = new JSONObject();
          paramJSONObject.put("cret", 2);
          invokeCallJS(paramString, paramJSONObject);
        }
      }
      else
      {
        this.preTime = System.currentTimeMillis();
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        Object localObject1;
        JSONObject localJSONObject;
        String str1;
        QQAppInterface localQQAppInterface;
        String str2;
        int i;
        Object localObject2;
        continue;
        continue;
        i -= 1;
      }
    }
    localObject2 = ((String)localObject1).split("\\.");
    paramJSONObject = "";
    i = localObject2.length - 1;
    if (i >= 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramJSONObject);
      ((StringBuilder)localObject1).append(localObject2[i]);
      localObject1 = ((StringBuilder)localObject1).toString();
      paramJSONObject = (JSONObject)localObject1;
      if (i != 0)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append((String)localObject1);
        paramJSONObject.append("_");
        paramJSONObject = paramJSONObject.toString();
      }
    }
    else
    {
      localObject1 = new NewIntent(localQQAppInterface.getApplication(), ProtoServlet.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("MQUpdateSvc_");
      ((StringBuilder)localObject2).append(paramJSONObject);
      ((StringBuilder)localObject2).append(".web.");
      ((StringBuilder)localObject2).append(str1);
      ((NewIntent)localObject1).putExtra("cmd", ((StringBuilder)localObject2).toString());
      paramJSONObject = new WebSsoBody.WebSsoRequestBody();
      paramJSONObject.type.set(0);
      paramJSONObject.data.set(str2);
      ((NewIntent)localObject1).putExtra("data", paramJSONObject.toByteArray());
      if (str1.equals("JsOidbProxy.oidb_0x6cf_4"))
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("test dataObj dataObj:");
        paramJSONObject.append(localJSONObject.toString());
        ViolaLogUtils.d("BridgeModule", paramJSONObject.toString());
      }
      ((NewIntent)localObject1).setObserver(new BridgeModule.8(this, paramString, str1, localQQAppInterface));
      if (localQQAppInterface != null) {
        localQQAppInterface.startServlet((NewIntent)localObject1);
      }
      label480:
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BridgeModule", 2, "send request error!");
      }
      return;
    }
  }
  
  @JSMethod
  public void setColorBallData(JSONObject paramJSONObject)
  {
    ViolaFragment localViolaFragment = getViolaFragment();
    if (localViolaFragment == null) {
      return;
    }
    localViolaFragment.setColorBallData(paramJSONObject);
  }
  
  public void setInvokeCallJSCallback(@Nullable InvokeCallJSCallback paramInvokeCallJSCallback)
  {
    this.invokeCallJSCallback = paramInvokeCallJSCallback;
  }
  
  public void setNavBar(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.q(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void setNavBtn(JSONObject paramJSONObject, String paramString)
  {
    setNavBtnWithFragment(paramJSONObject, paramString, null);
  }
  
  public void setNavBtnWithFragment(JSONObject paramJSONObject, String paramString, Fragment paramFragment)
  {
    BridgeModuleHelper.a(this, paramJSONObject, paramString, paramFragment);
  }
  
  @JSMethod(uiThread=true)
  public void setPresentPopFromBottom(int paramInt)
  {
    if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment)))
    {
      ViolaFragment localViolaFragment = (ViolaFragment)getViolaInstance().getFragment();
      boolean bool = true;
      if (paramInt != 1) {
        bool = false;
      }
      localViolaFragment.setCanCloseFromBottom(bool);
    }
  }
  
  public void setRightDragToGoBackParams(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.r(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void setStringToPasteboard(String paramString)
  {
    try
    {
      if (getActivity() != null) {
        ((ClipboardManager)getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, paramString));
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  @JSMethod
  public void setTabBlurEnable(JSONObject paramJSONObject)
  {
    if ((getViolaInstance() != null) && (getViolaInstance().getActivity() != null)) {
      RIJAppSetting.b(getViolaInstance().getActivity(), paramJSONObject.optBoolean("blur_enable", true));
    }
  }
  
  public void setTitle(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.o(this, paramJSONObject, paramString);
  }
  
  public void setTitleClickListener(String paramString)
  {
    BridgeModuleHelper.g(this, paramString);
  }
  
  public void sharePicMessage(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.s(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void shareVideoWithFriend(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("do shareVideoWithFriend start data: ");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.d("BridgeModule", 2, localStringBuilder.toString());
    }
    this.shareVideoCallBackId = paramString;
    paramString = new VideoInfo();
    paramString.jdField_c_of_type_JavaLangString = paramJSONObject.optString("article_title", "");
    paramString.jdField_a_of_type_Int = paramJSONObject.optInt("busiType");
    paramString.jdField_a_of_type_JavaLangString = paramJSONObject.optString("vid");
    paramString.f = paramJSONObject.optString("article_url");
    paramString.m = paramJSONObject.optString("aio_share_url");
    paramString.n = paramJSONObject.optString("qzone_share_url");
    paramString.d = paramJSONObject.optInt("duration");
    paramString.g = paramJSONObject.optString("rowkey");
    paramString.jdField_b_of_type_JavaLangString = paramJSONObject.optString("first_page_url");
    paramString.jdField_b_of_type_Int = paramJSONObject.optInt("width");
    paramString.jdField_c_of_type_Int = paramJSONObject.optInt("height");
    paramString.k = paramJSONObject.optString("thridName");
    paramString.o = paramJSONObject.optString("thirdAction");
    paramString.p = paramJSONObject.optString("thirdIcon");
    paramString.j = paramJSONObject.optString("third_uin");
    paramString.q = paramJSONObject.optString("third_uin_name");
    VideoFeedsShareController.a(paramString, getViolaInstance().getActivity(), 1, this.shareToFriendUin, this.shareToFriendUinType, this.shareToFriendUinName);
  }
  
  public void showActionSheet(JSONObject paramJSONObject, String paramString)
  {
    if (this.mActionSheetHelper == null) {
      this.mActionSheetHelper = new ActionSheetHelper(this);
    }
    this.mActionSheetHelper.a(paramJSONObject, paramString);
  }
  
  @JSMethod
  public void showColorBall()
  {
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, true);
  }
  
  public void showCommentEditor(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.i(this, paramJSONObject, paramString);
  }
  
  public void showCommentEditorNative(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.j(this, paramJSONObject, paramString);
  }
  
  public void showDialog(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.a(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void showFollowAlertView(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.k(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void showMotiveAd(String paramString, JSONObject paramJSONObject)
  {
    BridgeModuleHelper.a(paramString, paramJSONObject);
  }
  
  public void showMultiBiuEditPage(JSONObject paramJSONObject, String paramString)
  {
    if ((getViolaInstance() != null) && (getViolaInstance().getActivity() != null)) {
      RIJUserLevelModule.getInstance().doActionsByUserLevel(getViolaInstance().getActivity(), 2, new BridgeModule.5(this, paramJSONObject, paramString));
    }
  }
  
  public void showPicture(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.w(this, paramJSONObject, paramString);
  }
  
  public void showReadinjoyPicture(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.a(this, paramJSONObject, paramString);
  }
  
  public void showShareMenu(JSONObject paramJSONObject, @NonNull String paramString)
  {
    Object localObject = getViolaInstance().getFragment();
    if (localObject != null) {
      localObject = ((Fragment)localObject).getActivity();
    } else {
      localObject = getViolaInstance().getActivity();
    }
    if (localObject == null) {
      return;
    }
    AppInterface localAppInterface = (AppInterface)ReadInJoyUtils.a();
    JSONObject localJSONObject = paramJSONObject.optJSONObject("shareInfo");
    String str = paramJSONObject.optString("menu_title", HardCodeUtil.a(2131701407));
    JSONArray localJSONArray = paramJSONObject.optJSONArray("hide_items");
    int i = 0;
    boolean bool;
    if (paramJSONObject.optInt("show_diandian", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    HashSet localHashSet = new HashSet();
    if (localJSONArray != null) {
      while (i < localJSONArray.length())
      {
        localHashSet.add(localJSONArray.optString(i));
        i += 1;
      }
    }
    this.mShareHelper = new ReadInJoyShareHelperV2((Activity)localObject, localAppInterface, new SheetItemClickProcessor(false, null, null, localJSONObject, new WeakReference(localObject), paramString, this));
    this.mShareHelper.a().setActionSheetTitle(str);
    i = paramJSONObject.optInt("report_from");
    paramJSONObject = paramJSONObject.optString("rowkey");
    this.mShareHelper.a(QShareUtils.a(bool, localHashSet), i, paramJSONObject);
  }
  
  public void showShareReadInJoyMenu(JSONObject paramJSONObject, String paramString, Fragment paramFragment)
  {
    AppInterface localAppInterface = (AppInterface)ReadInJoyUtils.a();
    if (paramFragment == null) {
      paramFragment = getViolaInstance().getFragment();
    }
    if (paramFragment != null) {
      paramFragment = paramFragment.getActivity();
    } else {
      paramFragment = getViolaInstance().getActivity();
    }
    if (paramFragment == null) {
      return;
    }
    Object localObject1 = paramJSONObject.optJSONArray("upline");
    Object localObject2 = paramJSONObject.optJSONArray("belowline");
    String str3 = paramJSONObject.optString("menu_title", "biu出去让更多好友看到");
    if (localObject1 == null) {
      localObject1 = ReadInJoyShareHelperV2.b();
    } else {
      localObject1 = ReadInJoyShareHelperV2.a((JSONArray)localObject1, paramJSONObject);
    }
    if (localObject2 == null) {
      localObject2 = ReadInJoyShareHelperV2.c();
    } else {
      localObject2 = ReadInJoyShareHelperV2.a((JSONArray)localObject2, paramJSONObject);
    }
    ArrayList localArrayList1 = new ArrayList();
    Object localObject3 = ((List)localObject1).iterator();
    while (((Iterator)localObject3).hasNext()) {
      localArrayList1.add(Integer.valueOf(((ActionItem)((Iterator)localObject3).next()).jdField_a_of_type_Int));
    }
    ArrayList localArrayList2 = new ArrayList();
    localObject3 = ((List)localObject2).iterator();
    while (((Iterator)localObject3).hasNext()) {
      localArrayList2.add(Integer.valueOf(((ActionItem)((Iterator)localObject3).next()).jdField_a_of_type_Int));
    }
    Object localObject4;
    if (paramJSONObject.optInt("from") == 1)
    {
      localObject4 = Aladdin.getConfig(273).getString("share_text_channel_list", "");
      str2 = Aladdin.getConfig(273).getString("share_text", "");
      localObject3 = str2;
      try
      {
        if (!TextUtils.isEmpty(str2)) {
          localObject3 = ReadInJoyStringUtils.a(String.format(str2, new Object[] { paramJSONObject.optString("share_url") }), "\\n", '\n');
        }
        paramJSONObject.put("shouldSharePlainTextChannel", localObject4);
        paramJSONObject.put("shareText", localObject3);
      }
      catch (Exception localException)
      {
        QLog.e("BridgeModule", 2, QLog.getStackTraceString(localException));
      }
    }
    sShareEntryActivity = new WeakReference(paramFragment);
    int i = paramJSONObject.optInt("report_from");
    String str1 = paramJSONObject.optString("rowkey", "");
    String str2 = paramJSONObject.optString("share_url");
    if (str2 != null)
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(str2);
      ((StringBuilder)localObject4).append("&rowkey=");
      ((StringBuilder)localObject4).append(str1);
      ((StringBuilder)localObject4).toString();
    }
    this.mShareHelper = new ReadInJoyShareHelperV2(paramFragment, localAppInterface, new SheetItemClickProcessor(true, (List)localObject1, (List)localObject2, paramJSONObject, new WeakReference(paramFragment), paramString, this));
    this.mShareHelper.a(new List[] { localArrayList1, localArrayList2 }, i, str1);
    this.mShareHelper.a().setActionSheetTitle(str3);
    i = paramJSONObject.optInt("source", -1);
    int j = paramJSONObject.optInt("report_from", -1);
    paramFragment = paramJSONObject.optString("vid", "");
    localObject1 = paramJSONObject.optString("algorithmId", "");
    localObject2 = paramJSONObject.optString("articleId", "");
    paramJSONObject = paramJSONObject.optString("topicId", "");
    this.mShareHelper.a().setCancelListener(new BridgeModule.6(this, j, str1, paramFragment, i, (String)localObject1, (String)localObject2, paramJSONObject));
    this.mShareHelper.a().setOnDismissListener(new BridgeModule.7(this, paramString));
  }
  
  public void showTips(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.m(this, paramJSONObject, paramString);
  }
  
  public void showUGCEditPage(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.a(paramJSONObject, paramString);
  }
  
  public void showUGCVideoRecordPage(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.h(this, paramJSONObject, paramString);
  }
  
  public void showVisibleUserList(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.f(this, paramJSONObject, paramString);
  }
  
  public void socailFeedsUpdate(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.c(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void startImagePreDownload(JSONObject paramJSONObject)
  {
    BridgeModuleHelper.i(paramJSONObject);
  }
  
  @JSMethod
  public void startVideoPreDownload(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramJSONObject = (JSONArray)paramJSONObject.get("preload_array");
      int i = 0;
      Object localObject;
      while (i < paramJSONObject.length())
      {
        localObject = (JSONObject)paramJSONObject.get(i);
        localArrayList.add(new VideoPreDownloadMgr.VideoPreDownloadParam(((JSONObject)localObject).optString("videoVid"), ((JSONObject)localObject).optString("articleID"), ((JSONObject)localObject).optInt("busiType"), ((JSONObject)localObject).optInt("duration")));
        i += 1;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startVideoPreDownload error :");
      ((StringBuilder)localObject).append(paramJSONObject.getMessage());
      ViolaLogUtils.e("BridgeModule", ((StringBuilder)localObject).toString());
      if ((this.mVideoPreDownloadMgr != null) && (getViolaInstance() != null) && (getViolaInstance().getActivity() != null))
      {
        this.mVideoPreDownloadMgr.a(getViolaInstance().getActivity().getApplicationContext());
        this.mVideoPreDownloadMgr.a = new VideoPreloadReportData(VideoPreloadReportData.d, VideoPreloadReportData.g);
        this.mVideoPreDownloadMgr.a(new BridgeModule.2(this, localArrayList));
        this.mVideoPreDownloadMgr.a(0, true);
      }
    }
  }
  
  @JSMethod
  public void studyModeSelectGrade(JSONObject paramJSONObject, String paramString)
  {
    RIJStudyModeUtils.a(paramJSONObject.optString("selectedGradeList", ""));
    invokeJS(paramString, new JSONObject());
  }
  
  @JSMethod
  public void supportKeepPosition() {}
  
  @JSMethod
  public void supportScaleTransOpenCommentView()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BridgeModule", 2, "Now it supports ScaleTransOpenCommentView");
    }
  }
  
  @JSMethod
  public void susCommentViewHide()
  {
    if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment)))
    {
      ViolaFragment localViolaFragment = (ViolaFragment)getViolaInstance().getFragment();
      if ((localViolaFragment.isSuspension()) && (localViolaFragment.getCommonSuspensionGestureLayout() != null)) {
        ((CommonSuspensionGestureLayout)((ViolaFragment)getViolaInstance().getFragment()).getCommonSuspensionGestureLayout()).g();
      }
    }
  }
  
  @JSMethod
  public void susCommentViewShow()
  {
    if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment)))
    {
      ViolaFragment localViolaFragment = (ViolaFragment)getViolaInstance().getFragment();
      if ((localViolaFragment.isSuspension()) && (localViolaFragment.getCommonSuspensionGestureLayout() != null)) {
        ((CommonSuspensionGestureLayout)((ViolaFragment)getViolaInstance().getFragment()).getCommonSuspensionGestureLayout()).f();
      }
    }
  }
  
  public void suspensionPopBack(String paramString)
  {
    BridgeModuleHelper.f(this, paramString);
  }
  
  public void updateAccountCardFollowInfo(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.d(this, paramJSONObject, paramString);
  }
  
  @JSMethod
  public void updateColorBallData(JSONObject paramJSONObject, String paramString)
  {
    ViolaFragment localViolaFragment = getViolaFragment();
    if (localViolaFragment == null) {
      return;
    }
    localViolaFragment.updateColorBallData(paramJSONObject);
    invokeJS(paramString, new JSONObject());
  }
  
  public void updateIfNeed(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.z(this, paramJSONObject, paramString);
  }
  
  @JSMethod(uiThread=true)
  public void updateIndepentTabState(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("state")))
    {
      int i = paramJSONObject.optInt("state");
      ReadInJoyLogicEngineEventDispatcher.a().a(i, null);
    }
  }
  
  public void updateRedPacketShareTime() {}
  
  public void updateTopicCardFollowInfo(JSONObject paramJSONObject, String paramString)
  {
    BridgeModuleHelper.e(this, paramJSONObject, paramString);
  }
  
  @JSMethod(uiThread=false)
  public void vaNetworkChange(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    if (localQQAppInterface == null) {
      return;
    }
    if (this.netInfoHandler == null)
    {
      this.netInfoHandler = new BridgeModule.3(this, paramString);
      AppNetConnInfo.registerConnectionChangeReceiver(localQQAppInterface.getApplication(), this.netInfoHandler);
    }
  }
  
  @JSMethod
  public void videoPlayFeedback(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("do videoPlayFeedback start data: ");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.d("BridgeModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = sShareEntryActivity;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (Activity)((WeakReference)localObject).get();
    }
    PlayFeedbackHelper.a((Activity)localObject, paramJSONObject);
    sShareEntryActivity = null;
    paramJSONObject = getViolaInstance();
    if (paramJSONObject != null)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("success", 1);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      ViolaBridgeManager.getInstance().callbackJavascript(paramJSONObject.getInstanceId(), MODULE_NAME, "callback", paramString, localObject, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule
 * JD-Core Version:    0.7.0.1
 */