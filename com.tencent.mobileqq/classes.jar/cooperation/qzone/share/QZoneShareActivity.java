package cooperation.qzone.share;

import Override;
import aasr;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bdla;
import bhdj;
import bisl;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.open.agent.AgentActivity;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.util.QZonePermission;
import eipc.EIPCClient;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import znl;

public class QZoneShareActivity
  extends IphoneTitleBarActivity
{
  public static final String BROADCAST_SHARE_UPDATE = "com.tencent.qq.shareupdate";
  public static final String EXTRA_INPUT_MAX_LEN = "inputmax";
  public static final String EXTRA_INTENT_KEY_PARCELABLE = "extraIntentKeyParcelable";
  public static final String EXTRA_KEY_CONTENT_INTENT = "contentIntentKey";
  public static final String EXTRA_KEY_REQUEST_CODE = "extraRequestCode";
  public static final String KEY_ASK_ANONYMOUSLY_SHARE_TYPE = "askAnonymouslyShareType";
  public static final String KEY_IS_SHARED_FROM_ASK_ANONYMOUSLY = "isSharedFromAskAnonymously";
  public static final String KEY_IS_SHARED_FROM_MINI_PROGRAM = "isSharedFromMiniProgram";
  public static final String KEY_IS_SHARED_FROM_THIRD_PARTY = "isSharedFromThirdParty";
  public static final String KEY_MINI_SHARE_APP_IS_FROM_INNER_BUTTON = "miniShareIsFromInnerButton";
  public static final String KEY_MINI_SHARE_APP_OPEN_ID = "miniShareOpenId";
  public static final String KEY_MINI_SHARE_APP_PKG_NAME = "miniSharePkgName";
  public static final String KEY_MINI_SHARE_APP_RICH_ID = "miniShareAppRichId";
  public static final String KEY_MINI_SHARE_PARAM_APP_ID = "miniShareParamAppId";
  public static final String KEY_MINI_SHARE_PARAM_BUSINESS_TYPE = "miniShareParamBusinessType";
  public static final String KEY_MINI_SHARE_PARAM_DESCRIPTION = "miniShareParamDescription";
  public static final String KEY_MINI_SHARE_PARAM_ICON_URL = "miniShareParamIconUrl";
  public static final String KEY_MINI_SHARE_PARAM_JUMP_URL = "miniShareParamJumpUrl";
  public static final String KEY_MINI_SHARE_PARAM_PIC_URL = "miniShareParamPicUrl";
  public static final String KEY_MINI_SHARE_PARAM_SHARE_SCENE = "miniShareParamShareScene";
  public static final String KEY_MINI_SHARE_PARAM_TEMPLATE_TYPE = "miniShareParamTemplateType";
  public static final String KEY_MINI_SHARE_PARAM_TITLE = "miniShareParamTitle";
  public static final String KEY_MINI_SHARE_PARAM_VERSION_TYPE = "miniShareParamVersionType";
  public static final String KEY_MINI_SHARE_PRRAM_VERSION_ID = "miniShareParamVersionId";
  private static final String SDK_SHARE_CALLBACK_CANCEL = "tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel";
  private static final String SDK_SHARE_CALLBACK_COMPLETE = "tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}";
  public static final String SHOW_AT_ICON = "showaticon";
  public static final String SHOW_EMOTION_ICON = "showemotionicon";
  public static final String TAG = "QZoneShare";
  protected static final Object sAppinfoLock = new Object();
  protected static final String simpleClassname = QZoneShareActivity.class.getSimpleName();
  private int askAnonymouslyShareType;
  private int atEnd = -1;
  private int atStatr = -1;
  protected View desToolbar;
  protected boolean emoShow;
  protected boolean emoShowing;
  protected boolean hintHidden;
  protected InputMethodManager imm;
  private boolean isFromInnerButton;
  protected boolean isInputAt;
  protected boolean isKeyboardHidden;
  public boolean isResemeInited;
  private boolean isSharedFromAskAnonymously;
  private boolean isSharedFromMiniProgram;
  RelativeLayout line;
  protected mqq.observer.BusinessObserver mAppinfoObserver = new QZoneShareActivity.19(this);
  private int mAtMaxLen;
  public List<Friend> mAtUserList;
  private RelativeLayout mConatainer;
  protected GetAppInfoProto.GetAppinfoResponse mGetAppinfoResponse;
  private String mHint;
  private boolean mIsCanShowKeyboard = true;
  protected boolean mIsGettingAppinfo;
  public int mMaxLen;
  private String mOwnUin;
  private bisl mProgressDialog;
  private QZoneShareData mShareData;
  private int mShowAtIcon = 1;
  private int mShowEmoIcon = 1;
  private String mSummary;
  protected long mTempTime;
  private FrameLayout mThumbContainer;
  private String mThumbUrl;
  private URLImageView mThumbView;
  private String mTitle;
  public EditText mViewEdit;
  private TextView mViewForwardSummary;
  private TextView mViewForwardTitle;
  private boolean needShareCallback;
  private TextView preMeasureSummaryTextArea;
  BroadcastReceiver receiver = new QZoneShareActivity.22(this);
  private int rootHeight;
  public boolean showMaxLen = true;
  private String tmpAtCode = "";
  protected View viewAtUser;
  protected View viewDivider;
  protected SystemEmoticonPanel viewEmoView;
  protected ImageView viewSmiley;
  protected TextView viewTextCount;
  
  private void ajustDesToolbar(boolean paramBoolean)
  {
    if ((this.isKeyboardHidden) && (!paramBoolean))
    {
      this.desToolbar.setVisibility(4);
      return;
    }
    this.desToolbar.setVisibility(0);
  }
  
  private void askAnonymouslyReport()
  {
    if ((this.isSharedFromAskAnonymously) && (this.askAnonymouslyShareType == 1)) {
      bdla.b(null, "dc00898", "", "", "0X800B46E", "0X800B46E", 0, 0, "", "", "", "");
    }
  }
  
  private void callbackShareFail()
  {
    Bundle localBundle;
    if (this.isSharedFromMiniProgram)
    {
      localBundle = new Bundle();
      localBundle.putString("key_mini_report_event_action_type", "user_click");
      if (!this.isFromInnerButton) {
        break label104;
      }
      localBundle.putString("key_mini_report_event_sub_action_type", "custom_button");
    }
    for (;;)
    {
      localBundle.putString("key_mini_report_event_reserves", "share_QZ");
      localBundle.putString("key_mini_report_event_reserves2", "fail");
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", localBundle, null);
      if (this.needShareCallback) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_fail", null, null);
      }
      return;
      label104:
      localBundle.putString("key_mini_report_event_sub_action_type", "more_button");
    }
  }
  
  private void callbackShareSuccess()
  {
    Bundle localBundle;
    if (this.isSharedFromMiniProgram)
    {
      localBundle = new Bundle();
      localBundle.putString("key_mini_report_event_action_type", "user_click");
      if (!this.isFromInnerButton) {
        break label104;
      }
      localBundle.putString("key_mini_report_event_sub_action_type", "custom_button");
    }
    for (;;)
    {
      localBundle.putString("key_mini_report_event_reserves", "share_QZ");
      localBundle.putString("key_mini_report_event_reserves2", "success");
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", localBundle, null);
      if (this.needShareCallback) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
      }
      return;
      label104:
      localBundle.putString("key_mini_report_event_sub_action_type", "more_button");
    }
  }
  
  public static String filterText(String paramString)
  {
    paramString = new StringTokenizer(paramString.toString().replace("\r\n", " ").replace("\n", " "), " ");
    StringBuffer localStringBuffer = new StringBuffer();
    while (paramString.hasMoreTokens()) {
      localStringBuffer.append(paramString.nextToken() + ' ');
    }
    return localStringBuffer.toString().trim();
  }
  
  private int findAtSymbol(CharSequence paramCharSequence, int paramInt)
  {
    return InputViewPanelControl.findAtSymbol(paramCharSequence, paramInt, this.mAtMaxLen, this.mAtUserList, this.atStatr, this.atEnd, this.tmpAtCode);
  }
  
  private void getAppinfo(AppInterface paramAppInterface, long paramLong, String paramString)
  {
    this.mTempTime = System.currentTimeMillis();
    this.mIsGettingAppinfo = true;
    long l = System.currentTimeMillis() / 1000L;
    String str = AgentActivity.a(this, paramString, l + "");
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "-->sdk_share, getting appinfo in construct. sign: " + str);
    }
    aasr.a(paramAppInterface, this, paramAppInterface.getCurrentAccountUin(), paramLong, str, l, this.mAppinfoObserver, paramString);
  }
  
  public static String getStringFromEditText(EditText paramEditText)
  {
    if (paramEditText == null) {
      return "";
    }
    paramEditText = paramEditText.getText();
    if ((paramEditText instanceof QQTextBuilder)) {
      return ((QQTextBuilder)paramEditText).toPlainText();
    }
    return paramEditText.toString();
  }
  
  private int getTitleLineCount(String paramString, int paramInt1, int paramInt2)
  {
    TextView localTextView = new TextView(BaseApplication.getContext());
    localTextView.setText(paramString);
    localTextView.setTextSize(2, paramInt1);
    localTextView.setMaxLines(2);
    localTextView.measure(View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
    return localTextView.getLineCount();
  }
  
  private void handleShareData()
  {
    label21:
    Object localObject;
    if (this.mShareData != null)
    {
      if (!this.isSharedFromAskAnonymously) {
        break label243;
      }
      this.mThumbUrl = "https://downv6.qq.com/qq_relation/ask_anonymously/ask_anonymously_invite_icon_to_qzone_v2.png";
      break label277;
      if (!TextUtils.isEmpty(this.mShareData.mTitle)) {
        break label311;
      }
      localObject = null;
      label36:
      this.mTitle = ((String)localObject);
      if (!TextUtils.isEmpty(this.mShareData.mSummary)) {
        break label325;
      }
      localObject = null;
      label56:
      this.mSummary = ((String)localObject);
      if ((!TextUtils.isEmpty(this.mTitle)) && (!TextUtils.isEmpty(this.mSummary)))
      {
        if (!this.mTitle.equals(this.mSummary)) {
          break label339;
        }
        this.mSummary = null;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneShare", 2, "params: " + this.mShareData.toString());
      }
      if (!TextUtils.isEmpty(this.mShareData.mDefaultForwardReason)) {
        this.mViewEdit.setText(this.mShareData.mDefaultForwardReason);
      }
      openIdConfirm(this.mShareData);
      report(this.mShareData);
      if ((this.app != null) && (this.mShareData != null) && (this.mShareData.appid > 0L) && (!TextUtils.isEmpty(this.mShareData.pkgname))) {
        getAppinfo(this.app, this.mShareData.appid, this.mShareData.pkgname);
      }
      return;
      label243:
      if ((this.mShareData.mImageUrls == null) || (this.mShareData.mImageUrls.size() <= 0)) {
        break label21;
      }
      localObject = this.mShareData.mImageUrls.iterator();
      label277:
      if (!((Iterator)localObject).hasNext()) {
        break label21;
      }
      String str = (String)((Iterator)localObject).next();
      if (TextUtils.isEmpty(str)) {
        break;
      }
      this.mThumbUrl = str;
      break label21;
      label311:
      localObject = this.mShareData.mTitle.trim();
      break label36;
      label325:
      localObject = this.mShareData.mSummary.trim();
      break label56;
      label339:
      if (this.mTitle.length() > 20)
      {
        localObject = this.mTitle.substring(0, 20);
        if (this.mSummary.startsWith((String)localObject)) {
          this.mSummary = null;
        }
      }
    }
  }
  
  private void initData()
  {
    Intent localIntent = getIntent();
    this.mShareData = ((QZoneShareData)localIntent.getParcelableExtra("extraIntentKeyParcelable"));
    this.isSharedFromMiniProgram = localIntent.getBooleanExtra("isSharedFromMiniProgram", false);
    this.isSharedFromAskAnonymously = localIntent.getBooleanExtra("isSharedFromAskAnonymously", false);
    this.mOwnUin = localIntent.getStringExtra("qzone_uin");
    if (TextUtils.isEmpty(this.mOwnUin)) {
      this.mOwnUin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }
    if (this.isSharedFromAskAnonymously) {
      this.askAnonymouslyShareType = localIntent.getIntExtra("askAnonymouslyShareType", 0);
    }
    if (this.isSharedFromMiniProgram)
    {
      showProgressDialog(2131718796);
      boolean bool = localIntent.getBooleanExtra("isSharedFromThirdParty", false);
      String str1 = localIntent.getStringExtra("miniShareParamAppId");
      String str2 = localIntent.getStringExtra("miniShareParamTitle");
      String str3 = localIntent.getStringExtra("miniShareParamDescription");
      int i = localIntent.getIntExtra("miniShareParamShareScene", 1);
      int j = localIntent.getIntExtra("miniShareParamTemplateType", 1);
      int k = localIntent.getIntExtra("miniShareParamBusinessType", 0);
      String str4 = localIntent.getStringExtra("miniShareParamPicUrl");
      String str5 = localIntent.getStringExtra("miniShareParamJumpUrl");
      String str6 = localIntent.getStringExtra("miniShareParamIconUrl");
      int m = localIntent.getIntExtra("miniShareParamVersionType", -1);
      String str7 = localIntent.getStringExtra("miniShareParamVersionId");
      String str8 = localIntent.getStringExtra("miniShareAppRichId");
      Object localObject = localIntent.getStringExtra("miniSharePkgName");
      String str9 = localIntent.getStringExtra("miniShareOpenId");
      this.isFromInnerButton = localIntent.getBooleanExtra("miniShareIsFromInnerButton", false);
      this.mShareData = new QZoneShareData();
      this.mShareData.mTitle = str2;
      if (str8 != null) {}
      try
      {
        this.mShareData.appid = Long.parseLong(str8);
        this.mShareData.openId = str9;
        this.mShareData.pkgname = ((String)localObject);
        this.mShareData.mSummary = str3;
        this.mShareData.mImageUrls = new ArrayList();
        if (!StringUtil.isEmpty(str4))
        {
          this.mShareData.mImageUrls.add(str4);
          if (bool) {
            this.mShareData.from = 1;
          }
          this.mShareData.xcxMapEx = new HashMap();
          this.mShareData.xcxMapEx.put("xcxPath", str5);
          this.mShareData.xcxMapEx.put("xcxAppId", str1);
          this.mShareData.xcxMapEx.put("xcxSourceType", String.valueOf(k));
          localObject = new QZoneShareActivity.4(this);
          if (!TextUtils.isEmpty(str6)) {
            break label545;
          }
          MiniAppCmdUtil.getInstance().getAppInfoById(null, str1, str5, String.valueOf(m), new QZoneShareActivity.5(this, str2, str3, str1, i, j, k, str4, str5, m, str8, (MiniAppCmdInterface)localObject));
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("QZoneShare", 1, "Long.parseLong(appRichId) get an Exception", localNumberFormatException);
          continue;
          if (!StringUtil.isEmpty(str6)) {
            this.mShareData.mImageUrls.add(str6);
          }
        }
        label545:
        MiniProgramShareUtils.shareAsQzoneFeeds(str1, str2, str3, i, j, k, str4, null, str5, str6, m, str7, str8, (MiniAppCmdInterface)localObject);
        return;
      }
    }
    handleShareData();
  }
  
  private void initUI()
  {
    setContentView(2131562148);
    setRightButton(2131717466, new QZoneShareActivity.6(this));
    this.mConatainer = ((RelativeLayout)findViewById(2131375570));
    this.mViewEdit = ((EditText)findViewById(2131367226));
    this.mThumbContainer = ((FrameLayout)findViewById(2131367228));
    this.mThumbView = ((URLImageView)findViewById(2131367231));
    this.mViewForwardTitle = ((TextView)findViewById(2131367240));
    this.mViewForwardSummary = ((TextView)findViewById(2131367236));
    addEmoPanel();
    this.viewAtUser = findViewById(2131375086);
    setEventAtUser();
    this.viewSmiley = ((ImageView)findViewById(2131375119));
    setEventSmiley();
    setEventEditView();
    this.viewTextCount = ((TextView)findViewById(2131367238));
    this.imm = ((InputMethodManager)getSystemService("input_method"));
    this.mAtUserList = new ArrayList();
  }
  
  private boolean isMatchAt(String paramString, boolean paramBoolean)
  {
    return InputViewPanelControl.isMatchAt(paramString, paramBoolean, this.mAtUserList, this.atStatr, this.atEnd, this.tmpAtCode);
  }
  
  public static final boolean isValidUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
      return false;
    }
    return true;
  }
  
  private void report(QZoneShareData paramQZoneShareData)
  {
    if ((paramQZoneShareData != null) && (paramQZoneShareData.mShareBeginTime > 0L))
    {
      localHashMap = new HashMap();
      localHashMap.put("url", paramQZoneShareData.targetUrl);
      localHashMap.put("time_cost", String.valueOf(System.currentTimeMillis() - paramQZoneShareData.mShareBeginTime));
      localHashMap.put("time_interval", String.valueOf((System.currentTimeMillis() - paramQZoneShareData.mShareBeginTime) / 100L));
      if (QLog.isColorLevel()) {
        QLog.d("QZoneShare", 2, "timecost:" + (System.currentTimeMillis() - paramQZoneShareData.mShareBeginTime));
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.mOwnUin, "qzonesharetimecost", true, 0L, 0L, localHashMap, null, true);
    }
    while (!QLog.isColorLevel())
    {
      HashMap localHashMap;
      return;
    }
    QLog.d("QZoneShare", 2, "timecost: -1");
  }
  
  private void resetAt()
  {
    this.tmpAtCode = "";
    this.atStatr = -1;
    this.atEnd = -1;
  }
  
  private void startSdkCallback(Activity paramActivity, QZoneShareData paramQZoneShareData, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramQZoneShareData == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramQZoneShareData.action)) {
      paramQZoneShareData.action = "shareToQzone";
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "sdk_share:sdk callback=" + paramBoolean + " appid=" + paramQZoneShareData.appid + " action=" + paramQZoneShareData.action);
    }
    Intent localIntent = new Intent();
    if (paramBoolean) {
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(paramQZoneShareData.appid), paramQZoneShareData.action })));
    }
    for (;;)
    {
      localIntent.setPackage(paramQZoneShareData.pkgname);
      QZoneHelper.addSource(localIntent);
      try
      {
        paramActivity.startActivity(localIntent);
        return;
      }
      catch (ActivityNotFoundException paramActivity)
      {
        QLog.e("QZoneShare", 1, paramActivity.getStackTrace());
        return;
      }
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(paramQZoneShareData.appid), paramQZoneShareData.action })));
    }
  }
  
  private void startShare()
  {
    callbackShareSuccess();
    if (!NetworkUtil.isNetSupport(this))
    {
      znl.a(1, 2131694255);
      return;
    }
    ThreadManager.postImmediately(new QZoneShareActivity.7(this), null, true);
  }
  
  private void updateData()
  {
    int j = 0;
    int k = 1;
    Object localObject2 = null;
    for (;;)
    {
      int i;
      String str3;
      String str4;
      try
      {
        if (this.mShareData == null) {
          this.mShareData = new QZoneShareData();
        }
        i = this.mShareData.from;
        if (i != 2) {
          return;
        }
        String str1 = LocalMultiProcConfig.getString("msharecururl", "");
        if ((TextUtils.isEmpty(str1)) || (!str1.equals(this.mShareData.mWebUrl))) {
          continue;
        }
        str3 = LocalMultiProcConfig.getString("msharetitle", "");
        str1 = LocalMultiProcConfig.getString("msharedesc", "");
        str4 = LocalMultiProcConfig.getString("msharethumb", "");
        String str5 = LocalMultiProcConfig.getString("mshareurl", "");
        int m = LocalMultiProcConfig.getInt("msharefrom", -1);
        if (TextUtils.isEmpty(str3))
        {
          str3 = null;
          if (!TextUtils.isEmpty(str1)) {
            break label396;
          }
          str1 = null;
          if ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str1))) {
            break label458;
          }
          if (!str3.equals(str1)) {
            break label406;
          }
          i = j;
          if (!TextUtils.isEmpty(str3))
          {
            i = j;
            if (!str3.equals(this.mTitle))
            {
              this.mTitle = str3;
              this.mShareData.mTitle = str3;
              i = 1;
            }
          }
          j = i;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            j = i;
            if (!((String)localObject2).equals(this.mSummary))
            {
              this.mSummary = ((String)localObject2);
              this.mShareData.mSummary = ((String)localObject2);
              j = 1;
            }
          }
          if ((TextUtils.isEmpty(str4)) || (str4.equals(this.mThumbUrl))) {
            break label453;
          }
          this.mThumbUrl = str4;
          if (this.mShareData.mImageUrls == null) {
            break label435;
          }
          this.mShareData.mImageUrls.clear();
          this.mShareData.mImageUrls.add(str4);
          i = k;
          if ((!TextUtils.isEmpty(str5)) && (!str5.equals(this.mShareData.targetUrl))) {
            this.mShareData.targetUrl = str5;
          }
          if (i == 0) {
            continue;
          }
          this.mShareData.iUrlInfoFrm = m;
          ThreadManager.getUIHandler().post(new QZoneShareActivity.23(this));
          continue;
        }
        str3 = str3.trim();
      }
      finally {}
      continue;
      label396:
      String str2 = localObject1.trim();
      continue;
      label406:
      if (str3.length() > 20)
      {
        if (str2.startsWith(str3.substring(0, 20))) {
          continue;
        }
        break label458;
        label435:
        new ArrayList().add(str4);
        i = k;
        continue;
        label453:
        i = j;
        continue;
      }
      label458:
      localObject2 = str2;
    }
  }
  
  private void updateForwardTitle()
  {
    String str2 = this.mTitle;
    String str1 = str2;
    if (str2 != null) {
      str1 = this.mTitle.replace("[em]e10086[/em]", "");
    }
    this.mViewForwardTitle.setText(str1);
  }
  
  private void updateImageView()
  {
    Object localObject = getResources().getDrawable(2130847847);
    if (!TextUtils.isEmpty(this.mThumbUrl))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mRequestHeight = ViewUtils.dpToPx(70.0F);
      localURLDrawableOptions.mRequestWidth = ViewUtils.dpToPx(70.0F);
      if (isValidUrl(this.mThumbUrl)) {}
      for (localObject = URLDrawable.getDrawable(this.mThumbUrl, localURLDrawableOptions);; localObject = URLDrawable.getDrawable(new File(this.mThumbUrl), localURLDrawableOptions))
      {
        this.mThumbView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mThumbView.setImageDrawable((Drawable)localObject);
        return;
      }
    }
    this.mThumbView.setBackgroundDrawable((Drawable)localObject);
  }
  
  private void updateLayout()
  {
    Object localObject = getResources().getColorStateList(2131165193);
    ColorStateList localColorStateList = getResources().getColorStateList(2131165195);
    if (TextUtils.isEmpty(this.mTitle))
    {
      this.mViewForwardTitle.setVisibility(8);
      this.mViewForwardSummary.setVisibility(0);
      if ((TextUtils.isEmpty(this.mSummary)) && (this.mShareData != null))
      {
        this.mViewForwardSummary.setText(this.mShareData.targetUrl);
        if (localObject != null) {
          this.mViewForwardSummary.setTextColor((ColorStateList)localObject);
        }
        this.mViewForwardSummary.setMaxLines(2);
      }
    }
    for (;;)
    {
      localObject = getResources().getDrawable(2130847847);
      this.mThumbView.setBackgroundDrawable((Drawable)localObject);
      return;
      this.mViewForwardSummary.setText(this.mSummary);
      break;
      if (TextUtils.isEmpty(this.mSummary))
      {
        this.mViewForwardTitle.setVisibility(0);
        this.mViewForwardSummary.setVisibility(8);
        updateForwardTitle();
        if (localObject != null) {
          this.mViewForwardTitle.setTextColor((ColorStateList)localObject);
        }
        this.mViewForwardTitle.setMaxLines(2);
      }
      else
      {
        int i = ViewUtils.getScreenWidth();
        int j = ViewUtils.dpToPx(24.0F);
        int k = ViewUtils.dpToPx(24.0F);
        int m = ViewUtils.dpToPx(80.0F);
        if (getTitleLineCount(this.mTitle, 14, i - j - k - m) > 1)
        {
          this.mViewForwardTitle.setVisibility(0);
          this.mViewForwardSummary.setVisibility(8);
          updateForwardTitle();
          if (localObject != null) {
            this.mViewForwardTitle.setTextColor((ColorStateList)localObject);
          }
          this.mViewForwardTitle.setMaxLines(2);
        }
        else
        {
          this.mViewForwardTitle.setVisibility(0);
          if (localObject != null) {
            this.mViewForwardTitle.setTextColor((ColorStateList)localObject);
          }
          this.mViewForwardSummary.setVisibility(0);
          if (localObject != null) {
            this.mViewForwardSummary.setTextColor(localColorStateList);
          }
          updateForwardTitle();
          this.mViewForwardTitle.setMaxLines(1);
          this.mViewForwardSummary.setText(this.mSummary);
          this.mViewForwardSummary.setMaxLines(1);
        }
      }
    }
  }
  
  protected void addAtUser(ArrayList<ResultRecord> paramArrayList)
  {
    if (this.mViewEdit == null) {
      return;
    }
    if (this.isInputAt)
    {
      int i = this.mViewEdit.getSelectionStart();
      Editable localEditable = this.mViewEdit.getEditableText();
      if ((localEditable != null) && (!TextUtils.isEmpty(localEditable.toString())) && (localEditable.toString().substring(i - 1, i).equals("@"))) {
        localEditable.delete(i - 1, i);
      }
      this.isInputAt = false;
    }
    this.mAtMaxLen = InputViewPanelControl.addAtUser(this.mViewEdit, paramArrayList, this.mAtUserList, this.mAtMaxLen);
  }
  
  protected final void addEmoPanel()
  {
    this.mViewEdit.setEditableFactory(QzoneTextBuilder.EMOCTATION_FACORY);
    try
    {
      this.viewEmoView = InputViewPanelControl.createEmoPanel(this, this.mViewEdit);
      onAddEmoPanel();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  protected boolean checkAppinfoLocked(AppInterface paramAppInterface, long paramLong, String paramString)
  {
    for (;;)
    {
      synchronized (sAppinfoLock)
      {
        if (this.mIsGettingAppinfo)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QZoneShare", 2, "-->sdk_share, checkAppinfoLocked, getappinfo already executing...");
          }
          try
          {
            showProgressDialog(2131692060);
            sAppinfoLock.wait(5000L);
            if (this.mGetAppinfoResponse != null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QZoneShare", 2, "-->sdk_share, response is null and show result dialog.");
            }
            hideProgressDialog();
            return true;
          }
          catch (InterruptedException paramAppInterface)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("QZoneShare", 2, "check app info locked ex", paramAppInterface);
            continue;
          }
        }
      }
      if (this.mGetAppinfoResponse == null)
      {
        this.mIsGettingAppinfo = true;
        long l = System.currentTimeMillis() / 1000L;
        String str = AgentActivity.a(this, paramString, l + "");
        if (QLog.isColorLevel()) {
          QLog.d("QZoneShare", 2, "-->sdk_share, checkAppinfoLocked, sign: " + str + ", appinfo is null.");
        }
        showProgressDialog(2131692060);
        aasr.a(paramAppInterface, this, paramAppInterface.getCurrentAccountUin(), paramLong, str, l, this.mAppinfoObserver, paramString);
        try
        {
          sAppinfoLock.wait(5000L);
        }
        catch (InterruptedException paramAppInterface) {}
        if (QLog.isColorLevel()) {
          QLog.e("QZoneShare", 2, "check app info locked ex", paramAppInterface);
        }
      }
    }
    int i = this.mGetAppinfoResponse.ret.get();
    if ((i == 110507) || (i == 110401))
    {
      ThreadManager.getUIHandler().post(new QZoneShareActivity.18(this));
      if (QLog.isColorLevel()) {
        QLog.d("QZoneShare", 2, "-->sdk_share, response ret: " + i + " and show result dialog.");
      }
      hideProgressDialog();
      return false;
    }
    hideProgressDialog();
    return true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0)
    {
      this.isInputAt = false;
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    onAtUserResult(paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "doOnCreate()");
    }
    if (getIntent() == null)
    {
      QLog.e("QZoneShare", 1, "onCreate getIntent is null");
      finish();
    }
    getWindow().setSoftInputMode(3);
    initUI();
    initData();
    updateLayout();
    if ((!ImmersiveUtils.c) && (!isInMultiWindow())) {
      getWindow().getDecorView().post(new QZoneShareActivity.1(this));
    }
    if ((!TextUtils.isEmpty(this.mThumbUrl)) && (!isValidUrl(this.mThumbUrl)) && (getIntent().getBooleanExtra("key_require_storage_permission", false)))
    {
      if (QZonePermission.requestStoragePermission(this, new QZoneShareActivity.2(this), 1)) {
        updateImageView();
      }
      return false;
    }
    updateImageView();
    return false;
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.viewEmoView.getVisibility() == 0)
      {
        hideEmoView();
        return true;
      }
      onBack();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    try
    {
      unregisterReceiver(this.receiver);
      hideKeyboard();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QZoneShare", 1, localException, new Object[0]);
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.qq.shareupdate");
    registerReceiver(this.receiver, localIntentFilter);
    if (!this.isResemeInited)
    {
      ThreadManager.postImmediately(new QZoneShareActivity.3(this), null, true);
      this.isResemeInited = true;
      return;
    }
    updateImageView();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.mViewEdit != null))
    {
      this.mViewEdit.setFocusable(true);
      this.mViewEdit.requestFocus();
      ThreadManager.getUIHandler().postDelayed(new QZoneShareActivity.15(this), 300L);
    }
  }
  
  public void finish()
  {
    ForwardRecentActivity.a(getIntent(), this);
    super.finish();
  }
  
  public int getContentWordCount()
  {
    if (this.mViewEdit != null) {
      return filterText(getStringFromEditText(this.mViewEdit)).length();
    }
    return 0;
  }
  
  protected final String getEditText()
  {
    return InputViewPanelControl.getEditText(this.mViewEdit, this.mAtUserList);
  }
  
  protected int getMaxWordCnt()
  {
    if (this.mMaxLen > 0) {
      return this.mMaxLen;
    }
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "maxUgcTextCount", 2000);
  }
  
  protected View getRoot()
  {
    return this.mConatainer;
  }
  
  protected boolean hideEmoView()
  {
    if ((this.viewEmoView == null) || (this.viewDivider == null) || (this.viewSmiley == null)) {}
    while (!this.emoShow) {
      return false;
    }
    this.emoShow = false;
    this.viewEmoView.setVisibility(8);
    this.viewDivider.setVisibility(4);
    ajustDesToolbar(this.emoShow);
    this.viewSmiley.setImageResource(2130849069);
    return true;
  }
  
  protected boolean hideKeyboard()
  {
    return hideKeyboard(true);
  }
  
  protected boolean hideKeyboard(boolean paramBoolean)
  {
    if ((this.imm == null) || (this.mViewEdit == null)) {
      return false;
    }
    if (this.imm.hideSoftInputFromWindow(this.mViewEdit.getWindowToken(), 0))
    {
      if (paramBoolean) {
        this.mViewEdit.clearFocus();
      }
      this.isKeyboardHidden = true;
      return true;
    }
    return false;
  }
  
  protected void hideKeyboardAndEmo()
  {
    hideKeyboardAndEmo(true);
  }
  
  protected void hideKeyboardAndEmo(boolean paramBoolean)
  {
    if (this.mViewEdit == null) {
      return;
    }
    hideKeyboard(paramBoolean);
    hideEmoView();
  }
  
  public void hideProgressDialog()
  {
    ThreadManager.getUIHandler().post(new QZoneShareActivity.21(this));
  }
  
  protected void onAddEmoPanel()
  {
    Object localObject = getRoot();
    if ((localObject instanceof RelativeLayout))
    {
      localObject = (RelativeLayout)localObject;
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams1.addRule(12);
      this.line = new RelativeLayout(this);
      this.desToolbar = LayoutInflater.from(this).inflate(2131562345, null);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams2.addRule(10);
      this.desToolbar.setVisibility(4);
      this.line.addView(this.desToolbar, localLayoutParams2);
      localLayoutParams2 = new RelativeLayout.LayoutParams(-1, 2);
      localLayoutParams2.addRule(3, this.desToolbar.getId());
      this.viewDivider = LayoutInflater.from(this).inflate(2131562238, null);
      this.line.addView(this.viewDivider, localLayoutParams2);
      localLayoutParams2 = new RelativeLayout.LayoutParams(-1, (int)(150.0F * ViewUtils.getDensity()));
      localLayoutParams2.addRule(3, this.viewDivider.getId());
      this.line.addView(this.viewEmoView, localLayoutParams2);
      this.viewEmoView.setVisibility(8);
      this.viewEmoView.setBackgroundColor(getResources().getColor(2131166685));
      ((RelativeLayout)localObject).addView(this.line, localLayoutParams1);
      this.rootHeight = ((RelativeLayout)localObject).getHeight();
      ((RelativeLayout)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new QZoneShareActivity.8(this, (RelativeLayout)localObject));
    }
  }
  
  protected void onAtUserResult(int paramInt, Intent paramIntent)
  {
    addAtUser(paramIntent.getParcelableArrayListExtra("result_set"));
  }
  
  protected void onBack()
  {
    hideKeyboardAndEmo();
    if (this.mShareData.from == 1) {
      startSdkCallback(this, this.mShareData, false);
    }
    setResult(0, getIntent());
    onBackEvent();
  }
  
  public boolean onBackEvent()
  {
    callbackShareFail();
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onTextCountChange()
  {
    ThreadManager.postImmediately(new QZoneShareActivity.14(this), null, true);
  }
  
  public void openIdConfirm(QZoneShareData paramQZoneShareData)
  {
    if (paramQZoneShareData == null) {}
    label4:
    Object localObject;
    String str;
    do
    {
      do
      {
        do
        {
          break label4;
          do
          {
            return;
          } while ((paramQZoneShareData.from != 1) || ("login".equals(paramQZoneShareData.jFrom)));
          localObject = paramQZoneShareData.shareUin;
          str = paramQZoneShareData.openId;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
        } while (((String)localObject).equals(this.mOwnUin));
        showOpenIdConfirmDialog(this, paramQZoneShareData);
        return;
      } while (TextUtils.isEmpty(str));
      localObject = new QZoneShareActivity.16(this, str, paramQZoneShareData);
      localObject = QZoneShareManager.getOpenID(BaseApplicationImpl.getApplication().getRuntime(), String.valueOf(paramQZoneShareData.appid), (com.tencent.mobileqq.app.BusinessObserver)localObject);
    } while ((localObject == null) || (((OpenID)localObject).openID == null) || (((OpenID)localObject).openID.equals(str)));
    showOpenIdConfirmDialog(this, paramQZoneShareData);
  }
  
  protected void setEventAtUser()
  {
    if (this.viewAtUser == null) {
      return;
    }
    this.viewAtUser.setOnClickListener(new QZoneShareActivity.9(this));
  }
  
  protected void setEventEditView()
  {
    if (this.mViewEdit == null) {
      return;
    }
    this.mViewEdit.addTextChangedListener(new QZoneShareActivity.10(this));
    this.mViewEdit.setOnTouchListener(new QZoneShareActivity.11(this));
  }
  
  protected void setEventSmiley()
  {
    if (this.viewSmiley == null) {
      return;
    }
    this.viewSmiley.setOnClickListener(new QZoneShareActivity.12(this));
  }
  
  protected void showEmoView()
  {
    if ((this.viewEmoView == null) || (this.viewDivider == null) || (this.viewSmiley == null)) {}
    while (this.emoShowing) {
      return;
    }
    hideKeyboard();
    this.mViewEdit.requestFocus();
    this.emoShowing = true;
    ThreadManager.getUIHandler().postDelayed(new QZoneShareActivity.13(this), 100L);
  }
  
  protected void showKeyboard()
  {
    if (!this.mIsCanShowKeyboard) {}
    while ((this.imm == null) || (this.mViewEdit == null)) {
      return;
    }
    this.imm.showSoftInput(this.mViewEdit, 2);
    this.isKeyboardHidden = false;
  }
  
  protected final void showOpenIdConfirmDialog(Activity paramActivity, QZoneShareData paramQZoneShareData)
  {
    paramQZoneShareData = new QZoneShareActivity.17(this, paramActivity, paramQZoneShareData);
    QQCustomDialog localQQCustomDialog = bhdj.a(paramActivity, 230);
    localQQCustomDialog.setMessage(2131694975);
    localQQCustomDialog.setTitle(2131692056);
    localQQCustomDialog.setNegativeButton(2131690697, paramQZoneShareData);
    localQQCustomDialog.setPositiveButton(2131718634, paramQZoneShareData);
    localQQCustomDialog.setCancelable(false);
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {}
    try
    {
      localQQCustomDialog.show();
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("QZoneShare", 1, paramActivity.toString());
    }
  }
  
  public void showProgressDialog(int paramInt)
  {
    ThreadManager.getUIHandler().post(new QZoneShareActivity.20(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity
 * JD-Core Version:    0.7.0.1
 */