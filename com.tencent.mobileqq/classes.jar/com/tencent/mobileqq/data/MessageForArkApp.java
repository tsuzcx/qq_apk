package com.tencent.mobileqq.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.ArkViewModelBase.ErrorInfo;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.NativeAd.util.ParseUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkViewExtraInterface;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.app.message.RecordForTest;
import com.tencent.mobileqq.ark.ArkAdapterItemInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter.ItemViewHolder;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.ark.api.IArkMsgReplyMgr;
import com.tencent.mobileqq.ark.temp.api.IArkMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.open.appcommon.AppClient;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class MessageForArkApp
  extends ChatMessage
  implements ArkAdapterItemInterface, IArkMessage
{
  private static final String REPORT_KEY_APP_NAME = "AppName";
  private static final String REPORT_KEY_APP_VIEW = "AppView";
  private static final String REPORT_TAG_ARK_VIEW_FORWARD_ALLOW = "ArkViewForwardAllow";
  private static final String REPORT_TAG_ARK_VIEW_FORWARD_FORBIDDEN = "ArkViewForwardForbidden";
  public static final String SDK_SHARE_APPID = "appid";
  public static final String SDK_SHARE_MUSIC = "music";
  public static final String SDK_SHARE_NEWS = "news";
  public static final String SDK_SHARE_PKG = "com.tencent.structmsg";
  private static final String SDK_SHARE_TITLE = "title";
  private static final String TAG = "MessageForArkApp";
  private static final String T_REPORT_TAIL_DOWNLOAD_THIRD_APP = "0X800A86E";
  private static final String T_REPORT_TAIL_OPEN_THIRD_APP = "0X800A86D";
  public ArkAioContainerWrapper arkContainer;
  @RecordForTest
  public ArkAppMessage ark_app_message;
  public String compatibleMsg;
  public boolean isMultiItemMsg;
  public LinkedList<MessageForArkApp> mExtendMsgArkAppList = new LinkedList();
  public String resIDForLongMsg;
  
  private boolean click2YYB(Activity paramActivity, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = AbsShareMsg.parsePackageNameAndData(paramString2, paramString3)[0];
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("SourceClickHandler click2YYB  appid = ");
      paramString2.append(paramLong);
      paramString2.append("; packageName=");
      paramString2.append(paramString1);
      QLog.d("StructMsg", 2, paramString2.toString());
    }
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    paramString2 = new Bundle();
    paramString2.putString("packageName", paramString1);
    paramString1 = new StringBuilder();
    paramString1.append(paramLong);
    paramString1.append("");
    paramString2.putString("appId", paramString1.toString());
    ArkAppCenter.a(paramString2);
    AppClient.b(paramActivity, paramString2);
    return true;
  }
  
  private boolean clickAppMsg(Context paramContext, String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SourceClickHandler clickAppMsg url = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", actionData = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", actionDataA = ");
      localStringBuilder.append(paramString3);
      QLog.d("MessageForArkApp", 2, localStringBuilder.toString());
    }
    paramString1 = AbsShareMsg.parsePackageNameAndData(paramString2, paramString3);
    paramString2 = paramContext.getPackageManager();
    try
    {
      if (paramString2.getPackageInfo(paramString1[0], 1) != null)
      {
        paramString2 = paramString2.getLaunchIntentForPackage(paramString1[0]);
        if (paramString2 == null) {
          return false;
        }
        paramString2.addFlags(67108864);
        if (!TextUtils.isEmpty(paramString1[1])) {
          paramString2.setData(Uri.parse(paramString1[1]));
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label218:
      if (QLog.isColorLevel()) {
        QLog.d("MessageForArkApp", 2, paramContext.getMessage());
      }
    }
    try
    {
      paramString3 = (StartAppCheckHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.STARTAPPCHECK_HANDLER);
      paramString2.putExtra("report_open_type", "arkmsg_source");
      paramString2.putExtra("report_url", "");
      paramString2.putExtra("report_from", "1");
      paramString2.putExtra("report_click_origin", "AIOTail");
      paramString2.putExtra("report_class_name", paramContext.getClass().getName());
      ArkAppCenter.a(paramString2);
      paramString3.b(paramString1[0].trim(), paramContext, paramString2);
      return true;
    }
    catch (Exception paramString1)
    {
      break label218;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler AbsShareMSG Failed!");
    }
    paramContext.startActivity(paramString2);
    return true;
    return false;
  }
  
  private boolean clickWebMsg(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SourceClickHandler clickWebMsg  url = ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("StructMsg", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(paramString1)) && ((paramString1.startsWith("http://")) || (paramString1.startsWith("https://"))))
    {
      localObject = new Intent(paramContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("key_isReadModeEnabled", true);
      ((Intent)localObject).putExtra("title", paramString2);
      ((Intent)localObject).putExtra("url", paramString1);
      ArkAppCenter.a((Intent)localObject);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(this.ark_app_message.containStructMsg, (Intent)localObject, paramString1);
      paramContext.startActivity((Intent)localObject);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString1, "", "", "");
      return true;
    }
    return false;
  }
  
  public static int dp2px(float paramFloat)
  {
    return dp2px(paramFloat, ArkAppCenterUtil.a());
  }
  
  public static int dp2px(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == 0.0F) {
      return 0;
    }
    return (int)(paramFloat1 * paramFloat2 + 0.5F);
  }
  
  public static String getConfigFromXml(Document paramDocument)
  {
    if (paramDocument == null) {
      return "";
    }
    for (;;)
    {
      int i;
      try
      {
        paramDocument = paramDocument.getElementsByTagName("Config");
        i = 0;
        paramDocument = paramDocument.item(0);
        if ((paramDocument != null) && (paramDocument.getChildNodes() != null) && (paramDocument.getChildNodes().getLength() > 0))
        {
          paramDocument = paramDocument.getChildNodes();
          JSONObject localJSONObject = new JSONObject();
          if (i < paramDocument.getLength())
          {
            Object localObject = paramDocument.item(i);
            String str = ((Node)localObject).getNodeName();
            localObject = ((Node)localObject).getFirstChild();
            if (!(localObject instanceof Text)) {
              break label254;
            }
            localObject = ((Node)localObject).getNodeValue();
            if (isNumber((String)localObject)) {
              if ((!"forward".equals(str)) && (!"autosize".equals(str)) && (!"round".equals(str)) && (!"width".equals(str)))
              {
                boolean bool = "height".equals(str);
                if (!bool) {}
              }
              else
              {
                try
                {
                  localJSONObject.put(str, Integer.valueOf((String)localObject));
                }
                catch (NumberFormatException localNumberFormatException)
                {
                  QLog.i("ArkApp", 1, "getConfigFromXml param error:", localNumberFormatException);
                }
              }
            }
            localJSONObject.put(localNumberFormatException, localObject);
            break label254;
          }
          paramDocument = localJSONObject.toString();
          return paramDocument;
        }
      }
      catch (JSONException paramDocument)
      {
        QLog.i("ArkApp", 1, "parse json error:", paramDocument);
      }
      return "";
      label254:
      i += 1;
    }
  }
  
  public static String getReplySummary(ChatMessage paramChatMessage)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(32);
      if ((paramChatMessage instanceof MessageForArkApp))
      {
        Object localObject1 = (MessageForArkApp)paramChatMessage;
        if (((IArkMsgReplyMgr)QRoute.api(IArkMsgReplyMgr.class)).canReply(((MessageForArkApp)localObject1).ark_app_message.appName, ((MessageForArkApp)localObject1).ark_app_message.appView))
        {
          localObject1 = new JSONObject(((MessageForArkApp)localObject1).ark_app_message.toAppXml());
          Object localObject2 = ((IArkMsgReplyMgr)QRoute.api(IArkMsgReplyMgr.class)).getReplyConfigFromMsg((JSONObject)localObject1);
          localObject1 = (String)((Map)localObject2).get("kArkMsgReplyTag");
          localObject2 = (String)((Map)localObject2).get("kArkMsgReplyTitle");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append((String)localObject2);
        }
      }
      if (localStringBuilder.length() == 0) {
        localStringBuilder.append(paramChatMessage.getSummaryMsg());
      }
      paramChatMessage = localStringBuilder.toString();
      return paramChatMessage;
    }
    catch (Exception paramChatMessage)
    {
      QLog.e("MessageForArkApp", 1, paramChatMessage, new Object[0]);
    }
    return "";
  }
  
  public static boolean isAllowedArkForward(boolean paramBoolean, MessageRecord paramMessageRecord)
  {
    boolean bool2 = paramMessageRecord instanceof MessageForArkApp;
    boolean bool1 = true;
    if (bool2)
    {
      MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramMessageRecord;
      int i = localMessageForArkApp.getProcessState();
      if ((i != 0) && (i != 1002))
      {
        QLog.i("MessageForArkApp", 1, "ArkSafe.canForward AAShare.process not finished and forward is not allowed");
        return false;
      }
      ArkAppMessage localArkAppMessage = localMessageForArkApp.ark_app_message;
      if (localArkAppMessage == null)
      {
        QLog.i("MessageForArkApp", 1, "ArkSafe.canForward ArkMsg is empty and forward is not allowed");
        return false;
      }
      String str = localArkAppMessage.config;
      Object localObject = new ArkAppMessage.Config();
      ((ArkAppMessage.Config)localObject).fromString(str);
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("ArkSafe.canForward appname:");
      localStringBuffer.append(localArkAppMessage.appName);
      localStringBuffer.append(",AIO is:");
      if (paramBoolean) {
        paramMessageRecord = "PublicAccount";
      } else {
        paramMessageRecord = "AIO";
      }
      localStringBuffer.append(paramMessageRecord);
      if (TextUtils.isEmpty(str)) {
        localStringBuffer.append(",Config is empty.");
      }
      localStringBuffer.append(",config.foward:");
      localStringBuffer.append(((ArkAppMessage.Config)localObject).forward);
      if (paramBoolean) {
        if ((((ArkAppMessage.Config)localObject).forward == null) || (((ArkAppMessage.Config)localObject).forward.intValue() <= 0)) {}
      }
      for (;;)
      {
        paramBoolean = true;
        break;
        do
        {
          paramBoolean = false;
          break label397;
          paramMessageRecord = localMessageForArkApp.arkContainer;
          if (paramMessageRecord == null)
          {
            QLog.i("MessageForArkApp", 1, String.format("ArkSafe.canForward forward is not allowed arkContainer == null and appName=%s", new Object[] { localArkAppMessage.appName }));
            return false;
          }
          if (paramMessageRecord.getErrorInfo().retCode == -5) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            QLog.i("MessageForArkApp", 1, String.format("ArkSafe.canForward forward is not allowed and appName=%s,retCode=%d", new Object[] { localArkAppMessage.appName, Integer.valueOf(localMessageForArkApp.arkContainer.getErrorInfo().retCode) }));
            return false;
          }
          paramMessageRecord = (Boolean)ArkAppCenterCheckEvent.a(0, localArkAppMessage.appName, localMessageForArkApp, Boolean.valueOf(true));
          if ((paramMessageRecord != null) && (!paramMessageRecord.booleanValue()))
          {
            QLog.i("MessageForArkApp", 1, "ArkSafe.canForward CheckResult is failed and is not allowed");
            return false;
          }
          if (TextUtils.isEmpty(str)) {
            break;
          }
        } while ((((ArkAppMessage.Config)localObject).forward == null) || (((ArkAppMessage.Config)localObject).forward.intValue() <= 0));
      }
      label397:
      localStringBuffer.append(",-configAllowed:");
      localStringBuffer.append(paramBoolean);
      bool2 = ArkAppConfigMgr.getInstance().canForward(localArkAppMessage.appName, localArkAppMessage.appView);
      localStringBuffer.append(",-canViewForward:");
      localStringBuffer.append(bool2);
      localObject = new HashMap(2);
      boolean bool3 = TextUtils.isEmpty(localArkAppMessage.appName);
      str = "null";
      if (bool3) {
        paramMessageRecord = "null";
      } else {
        paramMessageRecord = localArkAppMessage.appName;
      }
      ((HashMap)localObject).put("AppName", paramMessageRecord);
      if (TextUtils.isEmpty(localArkAppMessage.appView)) {
        paramMessageRecord = str;
      } else {
        paramMessageRecord = localArkAppMessage.appView;
      }
      ((HashMap)localObject).put("AppView", paramMessageRecord);
      if (bool2)
      {
        if (Math.random() < 0.01D) {
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "ArkViewForwardAllow", true, 0L, 0L, (HashMap)localObject, "");
        }
      }
      else {
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "ArkViewForwardForbidden", true, 0L, 0L, (HashMap)localObject, "");
      }
      if ((paramBoolean) && (bool2)) {
        paramBoolean = bool1;
      } else {
        paramBoolean = false;
      }
      localStringBuffer.append(",>>allow forward:");
      localStringBuffer.append(paramBoolean);
      ArkAppCenter.a("MessageForArkApp", localStringBuffer.toString());
      return paramBoolean;
    }
    ArkAppCenter.a("MessageForArkApp", "ArkSafe.canForward is not ArkMsg forward allowed ");
    return true;
  }
  
  public static boolean isNumber(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  public static boolean isRectangleBorder(ArkAppMessage.Config paramConfig)
  {
    boolean bool;
    if ((paramConfig != null) && ("normal".equals(paramConfig.type)) && (paramConfig.round != null) && (paramConfig.round.intValue() == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MessageForArkApp", 2, new Object[] { "ArkApp isRectangleBorder = ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public static boolean isSetHintSizeByConfig(ArkAppMessage.Config paramConfig)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramConfig != null)
    {
      if (!"normal".equals(paramConfig.type)) {
        return false;
      }
      bool1 = bool2;
      if (paramConfig.hintWidth != null)
      {
        bool1 = bool2;
        if (paramConfig.hintWidth.intValue() != 0)
        {
          bool1 = bool2;
          if (paramConfig.hintHeight != null)
          {
            bool1 = bool2;
            if (paramConfig.hintHeight.intValue() != 0) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean isSetSizeByConfig(ArkAppMessage.Config paramConfig)
  {
    int j;
    if ((paramConfig != null) && (("normal".equals(paramConfig.type)) || ("multiple".equals(paramConfig.type)))) {
      j = 1;
    } else {
      j = 0;
    }
    int i;
    if ((j != 0) && (paramConfig.width != null) && (paramConfig.width.intValue() != 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((j != 0) && (paramConfig.height != null) && (paramConfig.height.intValue() != 0)) {
      j = 1;
    } else {
      j = 0;
    }
    return (j != 0) && (i != 0);
  }
  
  public static MessageForArkApp.Size limitToSizeRange(float paramFloat, int paramInt1, int paramInt2)
  {
    return limitToSizeRange(paramFloat, paramInt1, paramInt2, 30, 30, (int)(ArkAppCenterUtil.a / paramFloat), 390);
  }
  
  public static MessageForArkApp.Size limitToSizeRange(float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = paramInt1;
    if (paramInt3 > 0)
    {
      i = paramInt1;
      if (paramInt1 < paramInt3) {
        i = paramInt3;
      }
    }
    paramInt1 = paramInt2;
    if (paramInt4 > 0)
    {
      paramInt1 = paramInt2;
      if (paramInt2 < paramInt4) {
        paramInt1 = paramInt4;
      }
    }
    paramInt2 = i;
    if (paramInt5 > 0)
    {
      paramInt2 = i;
      if (i > paramInt5) {
        paramInt2 = paramInt5;
      }
    }
    paramInt3 = paramInt1;
    if (paramInt6 > 0)
    {
      paramInt3 = paramInt1;
      if (paramInt1 > paramInt6) {
        paramInt3 = paramInt6;
      }
    }
    return new MessageForArkApp.Size(dp2px(paramInt2, paramFloat), dp2px(paramInt3, paramFloat));
  }
  
  private void openThirdApp(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    String str3 = this.ark_app_message.mSourceUrl;
    long l = ParseUtil.a(this.ark_app_message.appId, 0L);
    boolean bool = clickAppMsg(paramContext, str3, this.ark_app_message.mSourceActionData, this.ark_app_message.mSource_A_ActionData, paramQQAppInterface);
    String str1 = "";
    String str2 = "setup";
    if (bool)
    {
      if (isFromSdkShare())
      {
        if (l != 0L) {
          str1 = String.valueOf(l);
        }
        ReportController.b(null, "dc00898", "", "", "0X800A86D", "0X800A86D", 0, 0, str1, "", "", "");
      }
      paramContext = "run";
    }
    for (;;)
    {
      break;
      if (click2YYB(((BaseActivity)paramContext).getActivity(), Long.parseLong(this.ark_app_message.appId), this.ark_app_message.mSourceName, this.ark_app_message.mSourceActionData, this.ark_app_message.mSource_A_ActionData))
      {
        paramContext = str2;
        if (isFromSdkShare())
        {
          if (l != 0L) {
            str1 = String.valueOf(l);
          }
          ReportController.b(null, "dc00898", "", "", "0X800A86E", "0X800A86E", 0, 0, str1, "", "", "");
          paramContext = str2;
        }
      }
      else
      {
        clickWebMsg(paramContext, str3, this.ark_app_message.mSourceName);
        paramContext = str2;
      }
    }
    Util.a(paramQQAppInterface, paramQQAppInterface.getCurrentUin(), "sourceclick", Long.parseLong(this.ark_app_message.appId), 0L, paramContext);
  }
  
  public static float px2dp(int paramInt, float paramFloat)
  {
    if (paramInt == 0) {
      return 0.0F;
    }
    return paramInt / paramFloat;
  }
  
  public void attachArkView(ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, int paramInt)
  {
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130844893);
    if (this.arkContainer == null)
    {
      this.arkContainer = new ArkAioContainerWrapper();
      this.arkContainer.a(paramArkHorizontalListViewAdapter);
      ArkAppDataReport.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "ShowView", this.ark_app_message.appName, null, ArkAppDataReport.f, 0, this.ark_app_message.from);
      if (!TextUtils.isEmpty(this.ark_app_message.appId)) {
        ArkAppDataReport.a(null, "ShowSdkArkView", this.ark_app_message.appName, null, ArkAppDataReport.f, 0, this.ark_app_message.from);
      }
    }
    ArkAppMessage.Config localConfig = new ArkAppMessage.Config();
    localConfig.fromString(this.ark_app_message.config);
    this.arkContainer.a(paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    Object localObject1 = this.arkContainer;
    ((ArkAioContainerWrapper)localObject1).a(this.ark_app_message.appName, this.ark_app_message.appView, this.ark_app_message.appMinVersion, this.ark_app_message.metaList, ArkAppCenterUtil.a(), this, paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if (!this.isMultiItemMsg)
    {
      ((ArkAioContainerWrapper)localObject1).setFixSize(ArkAppCenterUtil.a, ArkAppCenterUtil.a);
      ((ArkAioContainerWrapper)localObject1).setMaxSize(ArkAppCenterUtil.a, ArkAppCenterUtil.a);
      ((ArkAioContainerWrapper)localObject1).setMinSize(ArkAppCenterUtil.a * 7 / 10, ArkAppCenterUtil.a);
    }
    else
    {
      int j;
      int k;
      int m;
      int i;
      if (isSetSizeByConfig(localConfig))
      {
        localObject2 = limitToSizeRange(ArkAppCenterUtil.a(), localConfig.width.intValue(), localConfig.height.intValue());
        this.arkContainer.setFixSize(((MessageForArkApp.Size)localObject2).width, ((MessageForArkApp.Size)localObject2).height);
        j = ((MessageForArkApp.Size)localObject2).height;
        k = ((MessageForArkApp.Size)localObject2).width;
        m = ((MessageForArkApp.Size)localObject2).height;
        i = ((MessageForArkApp.Size)localObject2).width;
      }
      else
      {
        ((ArkAioContainerWrapper)localObject1).setFixSize(ArkAppCenterUtil.a, ArkAppCenterUtil.a);
        j = ArkAppCenterUtil.a;
        k = ArkAppCenterUtil.a;
        i = ArkAppCenterUtil.a;
        m = ArkAppCenterUtil.a;
      }
      this.arkContainer.setMinSize(i, m);
      this.arkContainer.setMaxSize(k, j);
    }
    QLog.d("MessageForArkApp", 1, new Object[] { "ArkFold.MessageForArkApp.attachArkView ArkAppCenterUtil.sChatBubbleMaxWidth=", Integer.valueOf(ArkAppCenterUtil.a), ",app=", this.ark_app_message.appName });
    ArkAppCenterUtil.a("MessageForArkApp.attachArkView", paramArkHorizontalListViewAdapter.jdField_a_of_type_AndroidContentContext);
    localObject1 = new MessageForArkApp.1(this, paramItemViewHolder, (ArkAioContainerWrapper)localObject1, paramArkHorizontalListViewAdapter, paramInt);
    Object localObject2 = paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    ArkAppView localArkAppView = paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    ((ArkViewImplement.ArkViewInterface)localObject2).setClipRadius(16.0F);
    if (isRectangleBorder(localConfig)) {
      ((ArkViewImplement.ArkViewInterface)localObject2).setBorderType(0);
    } else {
      ((ArkViewImplement.ArkViewInterface)localObject2).setBorderType(1);
    }
    localArkAppView.a(this.arkContainer, paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
    ((ArkViewImplement.ArkViewInterface)localObject2).setOnTouchListener(paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    ((ArkViewImplement.ArkViewInterface)localObject2).setOnLongClickListener(paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    ((ArkViewImplement.ArkViewInterface)localObject2).setLoadCallback((ArkViewImplement.LoadCallback)localObject1);
    if (paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout != null)
    {
      paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setOnTouchListener(paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
      paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setOnLongClickListener(paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    }
    paramItemViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  public void clickTail(ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, ArkAppItemBubbleBuilder.Holder paramHolder, Context paramContext)
  {
    if (this.ark_app_message != null)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (paramItemViewHolder != null)
      {
        if (!TextUtils.isEmpty(this.ark_app_message.appId)) {
          paramItemViewHolder.b.setBackgroundResource(2130842703);
        } else {
          paramItemViewHolder.b.setBackgroundResource(2130842702);
        }
        paramItemViewHolder.b.setOnClickListener(new MessageForArkApp.2(this, localQQAppInterface, paramContext));
      }
      if (paramHolder != null)
      {
        if (!TextUtils.isEmpty(this.ark_app_message.appId)) {
          paramHolder.a.setBackgroundResource(2130842703);
        } else {
          paramHolder.a.setBackgroundResource(2130842702);
        }
        paramHolder.a.setOnClickListener(new MessageForArkApp.3(this, localQQAppInterface, paramContext));
      }
    }
  }
  
  public void destroyContainerByRemove()
  {
    doOnEvent(2);
  }
  
  public void doOnEvent(int paramInt)
  {
    Object localObject = this.mExtendMsgArkAppList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      MessageForArkApp localMessageForArkApp = (MessageForArkApp)((Iterator)localObject).next();
      if (localMessageForArkApp != null) {
        localMessageForArkApp.doOnEvent(paramInt);
      }
    }
    localObject = this.arkContainer;
    if (localObject != null)
    {
      ((ArkAioContainerWrapper)localObject).doOnEvent(paramInt);
      if (paramInt == 2) {
        this.arkContainer = null;
      }
    }
  }
  
  public void doParse()
  {
    if (this.ark_app_message == null) {
      this.ark_app_message = new ArkAppMessage();
    }
    Object localObject;
    if (this.msgData != null)
    {
      localObject = new ArkAppMessage();
      ((ArkAppMessage)localObject).fromBytes(this.msgData);
      if (((ArkAppMessage)localObject).appName != null) {
        this.ark_app_message.appName = ((ArkAppMessage)localObject).appName;
      }
      if (((ArkAppMessage)localObject).appView != null) {
        this.ark_app_message.appView = ((ArkAppMessage)localObject).appView;
      }
      if (((ArkAppMessage)localObject).appDesc != null) {
        this.ark_app_message.appDesc = ((ArkAppMessage)localObject).appDesc;
      }
      if (((ArkAppMessage)localObject).promptText != null) {
        this.ark_app_message.promptText = ((ArkAppMessage)localObject).promptText;
      }
      if (((ArkAppMessage)localObject).appMinVersion != null) {
        this.ark_app_message.appMinVersion = ((ArkAppMessage)localObject).appMinVersion;
      }
      if (((ArkAppMessage)localObject).metaList != null) {
        this.ark_app_message.metaList = ((ArkAppMessage)localObject).metaList;
      }
      if (((ArkAppMessage)localObject).config != null) {
        this.ark_app_message.config = ((ArkAppMessage)localObject).config;
      }
      if (((ArkAppMessage)localObject).from != 0) {
        this.ark_app_message.from = ((ArkAppMessage)localObject).from;
      }
      if (((ArkAppMessage)localObject).appId != null) {
        this.ark_app_message.appId = ((ArkAppMessage)localObject).appId;
      }
      if (((ArkAppMessage)localObject).mSourceName != null) {
        this.ark_app_message.mSourceName = ((ArkAppMessage)localObject).mSourceName;
      }
      if (((ArkAppMessage)localObject).mSourceActionData != null) {
        this.ark_app_message.mSourceActionData = ((ArkAppMessage)localObject).mSourceActionData;
      }
      if (((ArkAppMessage)localObject).mSource_A_ActionData != null) {
        this.ark_app_message.mSource_A_ActionData = ((ArkAppMessage)localObject).mSource_A_ActionData;
      }
      if (((ArkAppMessage)localObject).mSourceUrl != null) {
        this.ark_app_message.mSourceUrl = ((ArkAppMessage)localObject).mSourceUrl;
      }
      if ((((ArkAppMessage)localObject).mAppList != null) && (!((ArkAppMessage)localObject).mAppList.isEmpty())) {
        this.ark_app_message.mAppList = ((ArkAppMessage)localObject).mAppList;
      }
      if (((ArkAppMessage)localObject).mText != null) {
        this.ark_app_message.mText = ((ArkAppMessage)localObject).mText;
      }
      if (((ArkAppMessage)localObject).mSourceAd != null) {
        this.ark_app_message.mSourceAd = ((ArkAppMessage)localObject).mSourceAd;
      }
      if (((ArkAppMessage)localObject).mExtra != null) {
        this.ark_app_message.mExtra = ((ArkAppMessage)localObject).mExtra;
      }
    }
    if (this.msg == null) {
      this.msg = this.ark_app_message.getSummery();
    }
    if (TextUtils.isEmpty(this.ark_app_message.appName))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("empty app name, raw-data=");
      ((StringBuilder)localObject).append(ArkAppMessage.msgDataToString(this.msgData));
      QLog.e("MessageForArkApp", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public ArkAdapterItemInterface extendArkCardByOpen(ArkAppContainer paramArkAppContainer, String paramString1, String paramString2)
  {
    if (this.arkContainer == paramArkAppContainer)
    {
      if (getMsgArkAppCount() >= ArkRecommendController.a) {
        return null;
      }
      MessageForArkApp localMessageForArkApp = new MessageForArkApp();
      localMessageForArkApp.compatibleMsg = this.compatibleMsg;
      localMessageForArkApp.ark_app_message = new ArkAppMessage();
      localMessageForArkApp.ark_app_message.appName = paramArkAppContainer.getAppName();
      paramArkAppContainer = localMessageForArkApp.ark_app_message;
      paramArkAppContainer.appView = paramString1;
      paramArkAppContainer.metaList = paramString2;
      localMessageForArkApp.issend = this.issend;
      localMessageForArkApp.isMultiItemMsg = this.isMultiItemMsg;
      this.mExtendMsgArkAppList.add(0, localMessageForArkApp);
      return localMessageForArkApp;
    }
    return null;
  }
  
  public String[] getArkAppNameAndPath()
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = this.ark_app_message.appName;
    arrayOfString[1] = null;
    arrayOfString[2] = null;
    if ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null) {
      return arrayOfString;
    }
    arrayOfString[1] = ArkAppMgr.getInstance().getAppPathFromLocal(this.ark_app_message.appName);
    arrayOfString[2] = this.ark_app_message.appView;
    return arrayOfString;
  }
  
  public byte[] getBytes()
  {
    prewrite();
    return this.msgData;
  }
  
  public String getJumpUrl()
  {
    try
    {
      String str = new JSONObject(this.ark_app_message.metaList).optJSONObject("news").optString("jumpUrl");
      return str;
    }
    catch (Exception localException)
    {
      QLog.e("MessageForArkApp", 1, localException, new Object[0]);
    }
    return "";
  }
  
  public String getMetaList()
  {
    ArkAppMessage localArkAppMessage = this.ark_app_message;
    if (localArkAppMessage != null) {
      return localArkAppMessage.metaList;
    }
    return null;
  }
  
  public MessageForArkApp getMsgArkAppByPosition(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    Iterator localIterator = this.mExtendMsgArkAppList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      MessageForArkApp localMessageForArkApp = (MessageForArkApp)localIterator.next();
      j = localMessageForArkApp.getMsgArkAppCount() + i;
      if (paramInt == j) {
        return localMessageForArkApp;
      }
      if (paramInt < j) {
        return localMessageForArkApp.getMsgArkAppByPosition(paramInt - i - 1);
      }
    }
    return null;
  }
  
  public int getMsgArkAppCount()
  {
    Iterator localIterator = this.mExtendMsgArkAppList.iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += ((MessageForArkApp)localIterator.next()).getMsgArkAppCount();
    }
    return i + 1;
  }
  
  public String getMusicAppid()
  {
    try
    {
      String str = new JSONObject(this.ark_app_message.metaList).optJSONObject("music").optString("appid");
      return str;
    }
    catch (Exception localException)
    {
      QLog.e("MessageForArkApp", 1, localException, new Object[0]);
    }
    return "";
  }
  
  public String getMusicTitle()
  {
    try
    {
      String str = new JSONObject(this.ark_app_message.metaList).optJSONObject("music").optString("title");
      return str;
    }
    catch (Exception localException)
    {
      QLog.e("MessageForArkApp", 1, localException, new Object[0]);
    }
    return "";
  }
  
  public String getNewsAppid()
  {
    try
    {
      String str = new JSONObject(this.ark_app_message.metaList).optJSONObject("news").optString("appid");
      return str;
    }
    catch (Exception localException)
    {
      QLog.e("MessageForArkApp", 1, localException, new Object[0]);
    }
    return "";
  }
  
  public String getPreview()
  {
    try
    {
      String str = new JSONObject(this.ark_app_message.metaList).optJSONObject("news").optString("preview");
      return str;
    }
    catch (Exception localException)
    {
      QLog.e("MessageForArkApp", 1, localException, new Object[0]);
    }
    return "";
  }
  
  public int getProcessState()
  {
    String str = getExtInfoFromExtStr(MessageConstants.v);
    if (!TextUtils.isEmpty(str)) {
      try
      {
        int i = Integer.parseInt(str);
        return i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e("MessageForArkApp", 1, localNumberFormatException, new Object[0]);
      }
    }
    return 0;
  }
  
  public String getSummery()
  {
    ArkAppMessage localArkAppMessage = this.ark_app_message;
    if (localArkAppMessage != null) {
      return localArkAppMessage.getSummery();
    }
    return HardCodeUtil.a(2131706619);
  }
  
  public String getTitle()
  {
    try
    {
      String str = new JSONObject(this.ark_app_message.metaList).optJSONObject("news").optString("title");
      return str;
    }
    catch (Exception localException)
    {
      QLog.e("MessageForArkApp", 1, localException, new Object[0]);
    }
    return "";
  }
  
  public boolean isFromSdkShare()
  {
    String str1 = this.ark_app_message.appName;
    String str2 = this.ark_app_message.appView;
    if ("com.tencent.structmsg".equals(str1))
    {
      if ("music".equals(str2)) {
        return TextUtils.isEmpty(getMusicAppid()) ^ true;
      }
      if ("news".equals(str2)) {
        return TextUtils.isEmpty(getNewsAppid()) ^ true;
      }
    }
    return false;
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    Object localObject = this.ark_app_message;
    if (localObject != null) {
      localObject = ((ArkAppMessage)localObject).toBytes();
    } else {
      localObject = null;
    }
    this.msg = getSummery();
    this.msgData = ((byte[])localObject);
  }
  
  public void saveMsgData(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("MessageForArkApp", 1, "AAShare.saveMsgData app is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MessageForArkApp", 2, new Object[] { "AAShare.saveMsgData uniseq=", Long.valueOf(this.uniseq) });
    }
    prewrite();
    paramQQAppInterface.getMessageFacade().a(this.frienduin, this.istroop, this.uniseq, this.msgData);
  }
  
  public void saveMsgExtStrAndFlag(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("MessageForArkApp", 1, "AAShare.saveMsgExtStrAndFlag app is null");
      return;
    }
    paramQQAppInterface.getMessageFacade().a(this.frienduin, this.istroop, this.uniseq, "extStr", this.extStr);
    paramQQAppInterface.getMessageFacade().a(this.frienduin, this.istroop, this.uniseq, this.extraflag, 0);
    if (QLog.isColorLevel()) {
      QLog.e("MessageForArkApp", 2, new Object[] { "AAShare.saveMsgExtStrAndFlag uniseq=", Long.valueOf(this.uniseq), ", extStr=", this.extStr, ", extraflag=", Integer.valueOf(this.extraflag), String.format(" ,msg=%h", new Object[] { this }) });
    }
  }
  
  public void setParsed()
  {
    try
    {
      this.mIsParsed = true;
      return;
    }
    finally {}
  }
  
  public void updateArkAppMetaData(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("MessageForArkApp", 1, "AAShare.updateArkAppMetaData dataJson is empty");
      return;
    }
    this.ark_app_message.metaList = paramString;
    ArkAioContainerWrapper localArkAioContainerWrapper = this.arkContainer;
    if (localArkAioContainerWrapper != null) {
      localArkAioContainerWrapper.updateMetaData(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.e("MessageForArkApp", 2, new Object[] { "AAShare.updateArkAppMetaData arkContainer=", this.arkContainer, ", meta=", paramString, String.format(" ,msg=%h", new Object[] { this }) });
    }
  }
  
  public void updateArkAppMetaData(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      QLog.e("MessageForArkApp", 1, "AAShare.updateArkAppMetaData dataJson is null");
      return;
    }
    updateArkAppMetaData(paramJSONObject.optString("forward_ark_app_meta"));
  }
  
  public void updateProcessStateAndExtraFlag(int paramInt)
  {
    saveExtInfoToExtStr(MessageConstants.v, String.valueOf(paramInt));
    if (paramInt == 1001) {
      this.extraflag = 32772;
    } else if (paramInt == 1003) {
      this.extraflag = 32768;
    } else if (paramInt == 1002) {
      this.extraflag = 32772;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MessageForArkApp", 2, new Object[] { "AAShare.updateProcessStateAndExtraFlag uniseq=", Long.valueOf(this.uniseq), ", extStr=", this.extStr, ", extraFlag=", Integer.valueOf(this.extraflag), String.format(" ,msg=%h", new Object[] { this }) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForArkApp
 * JD-Core Version:    0.7.0.1
 */