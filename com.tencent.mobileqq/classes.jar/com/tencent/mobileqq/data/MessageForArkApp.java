package com.tencent.mobileqq.data;

import adai;
import adaj;
import adan;
import adaw;
import ajjy;
import ajsi;
import alcj;
import alej;
import alem;
import alep;
import alfb;
import alff;
import alfn;
import amsh;
import amsi;
import amsj;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import awav;
import awqx;
import bcau;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.ArkViewModelBase.ErrorInfo;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mpw;
import nbj;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import rtr;

public class MessageForArkApp
  extends ChatMessage
  implements alcj
{
  public static final String SDK_SHARE_APPID = "appid";
  private static final String SDK_SHARE_MUSIC = "music";
  public static final String SDK_SHARE_NEWS = "news";
  private static final String SDK_SHARE_PKG = "com.tencent.structmsg";
  private static final String SDK_SHARE_TITLE = "title";
  private static final String TAG = "MessageForArkApp";
  private static final String T_REPORT_TAIL_DOWNLOAD_THIRD_APP = "0X800A86E";
  private static final String T_REPORT_TAIL_OPEN_THIRD_APP = "0X800A86D";
  public adai arkContainer;
  public ArkAppMessage ark_app_message;
  public String compatibleMsg;
  public boolean isMultiItemMsg;
  public LinkedList<MessageForArkApp> mExtendMsgArkAppList = new LinkedList();
  public String resIDForLongMsg;
  
  private boolean click2YYB(Activity paramActivity, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = AbsShareMsg.parsePackageNameAndData(paramString2, paramString3)[0];
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "SourceClickHandler click2YYB  appid = " + paramLong + "; packageName=" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    paramString2 = new Bundle();
    paramString2.putString("packageName", paramString1);
    paramString2.putString("appId", paramLong + "");
    ArkAppCenter.a(paramString2);
    bcau.b(paramActivity, paramString2);
    return true;
  }
  
  private boolean clickAppMsg(Context paramContext, String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageForArkApp", 2, "SourceClickHandler clickAppMsg url = " + paramString1 + ", actionData = " + paramString2 + ", actionDataA = " + paramString3);
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
        try
        {
          paramString3 = (ajsi)paramQQAppInterface.a(23);
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
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler AbsShareMSG Failed!");
            }
            paramContext.startActivity(paramString2);
          }
        }
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MessageForArkApp", 2, paramContext.getMessage());
      }
    }
  }
  
  private boolean clickWebMsg(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "SourceClickHandler clickWebMsg  url = " + paramString1);
    }
    if ((TextUtils.isEmpty(paramString1)) || ((!paramString1.startsWith("http://")) && (!paramString1.startsWith("https://")))) {
      return false;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("title", paramString2);
    localIntent.putExtra("url", paramString1);
    ArkAppCenter.a(localIntent);
    rtr.a(this.ark_app_message.containStructMsg, localIntent, paramString1);
    paramContext.startActivity(localIntent);
    awqx.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString1, "", "", "");
    return true;
  }
  
  public static int dp2px(float paramFloat)
  {
    return dp2px(paramFloat, alem.a());
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
    JSONObject localJSONObject;
    label237:
    for (;;)
    {
      try
      {
        paramDocument = paramDocument.getElementsByTagName("Config").item(0);
        if ((paramDocument == null) || (paramDocument.getChildNodes() == null) || (paramDocument.getChildNodes().getLength() <= 0)) {
          break;
        }
        paramDocument = paramDocument.getChildNodes();
        localJSONObject = new JSONObject();
        int i = 0;
        if (i >= paramDocument.getLength()) {
          break label249;
        }
        Object localObject = paramDocument.item(i);
        String str = ((Node)localObject).getNodeName();
        localObject = ((Node)localObject).getFirstChild();
        if ((localObject instanceof Text))
        {
          localObject = ((Node)localObject).getNodeValue();
          if (!isNumber((String)localObject)) {
            break label237;
          }
          if ((!"forward".equals(str)) && (!"autosize".equals(str)) && (!"round".equals(str)) && (!"width".equals(str)))
          {
            boolean bool = "height".equals(str);
            if (!bool) {
              break label237;
            }
          }
        }
        try
        {
          localJSONObject.put(str, Integer.valueOf((String)localObject));
          i += 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.i("ArkApp", 1, "getConfigFromXml param error:", localNumberFormatException);
          continue;
        }
        localJSONObject.put(localNumberFormatException, localObject);
      }
      catch (JSONException paramDocument)
      {
        QLog.i("ArkApp", 1, "parse json error:", paramDocument);
        return "";
      }
    }
    label249:
    paramDocument = localJSONObject.toString();
    return paramDocument;
  }
  
  public static boolean isAllowedArkForward(boolean paramBoolean, MessageRecord paramMessageRecord)
  {
    boolean bool = true;
    int j = 0;
    if (paramMessageRecord == null) {
      ArkAppCenter.c("AllowedArkForward", "Message is empty and forward is not allowed");
    }
    Object localObject;
    ArkAppMessage localArkAppMessage;
    ArkAppMessage.Config localConfig;
    do
    {
      return false;
      if (!(paramMessageRecord instanceof MessageForArkApp)) {
        break;
      }
      if ((((MessageForArkApp)paramMessageRecord).getProcessState() != 0) && (((MessageForArkApp)paramMessageRecord).getProcessState() != 1002))
      {
        ArkAppCenter.c("AllowedArkForward", "AAShare.process status is not finised, forward is not allowed");
        return false;
      }
      localObject = (MessageForArkApp)paramMessageRecord;
      localArkAppMessage = ((MessageForArkApp)localObject).ark_app_message;
      if (localArkAppMessage == null)
      {
        ArkAppCenter.c("AllowedArkForward", "ArkMsg is empty and forward is not allowed");
        return false;
      }
      paramMessageRecord = localArkAppMessage.config;
      localConfig = new ArkAppMessage.Config();
      localConfig.fromString(paramMessageRecord);
    } while (localConfig == null);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramBoolean) {
      if ((localConfig.forward != null) && (localConfig.forward.intValue() > 0))
      {
        paramBoolean = true;
        localStringBuffer.append("PublicAccount");
        bool = paramBoolean;
        localStringBuffer.append(" and result is ");
        if (!bool) {
          break label471;
        }
      }
    }
    label466:
    label471:
    for (paramMessageRecord = "allowed";; paramMessageRecord = "not allowed")
    {
      localStringBuffer.append(paramMessageRecord);
      int i = j;
      if (localConfig.forward != null) {
        i = localConfig.forward.intValue();
      }
      ArkAppCenter.c("AllowedArkForward", "SupportForward is checked and Current is " + localStringBuffer + " and forward is " + i);
      return bool;
      paramBoolean = false;
      break;
      if (((MessageForArkApp)localObject).arkContainer == null)
      {
        ArkAppCenter.c("AllowedArkForward", String.format("AppState, forward is not allowed arkContainer == null and appName=%s", new Object[] { localArkAppMessage.appName }));
        return false;
      }
      if (((MessageForArkApp)localObject).arkContainer.getErrorInfo().retCode == -5) {}
      for (i = 1; i != 0; i = 0)
      {
        ArkAppCenter.c("AllowedArkForward", String.format("AppState, forward is not allowed and appName=%s,retCode=%d", new Object[] { localArkAppMessage.appName, Integer.valueOf(((MessageForArkApp)localObject).arkContainer.getErrorInfo().retCode) }));
        return false;
      }
      localObject = (Boolean)alej.a(0, localArkAppMessage.appName, localObject, Boolean.valueOf(true));
      if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
      {
        ArkAppCenter.c("AllowedArkForward", "CheckResult is failed and is not allowed");
        return false;
      }
      paramBoolean = bool;
      if (!TextUtils.isEmpty(paramMessageRecord)) {
        if ((localConfig.forward == null) || (localConfig.forward.intValue() <= 0)) {
          break label466;
        }
      }
      for (paramBoolean = bool;; paramBoolean = false)
      {
        localStringBuffer.append("AIO");
        bool = paramBoolean;
        if (!TextUtils.isEmpty(paramMessageRecord)) {
          break;
        }
        localStringBuffer.append(" and Config is empty");
        bool = paramBoolean;
        break;
      }
    }
    return true;
  }
  
  public static boolean isNumber(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  public static boolean isRectangleBorder(ArkAppMessage.Config paramConfig)
  {
    if ((paramConfig != null) && ("normal".equals(paramConfig.type)) && (paramConfig.round != null) && (paramConfig.round.intValue() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MessageForArkApp", 2, new Object[] { "ArkApp isRectangleBorder = ", Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public static boolean isSetSizeByConfig(ArkAppMessage.Config paramConfig)
  {
    int i;
    if ((paramConfig != null) && (("normal".equals(paramConfig.type)) || ("multiple".equals(paramConfig.type))))
    {
      j = 1;
      if ((j == 0) || (paramConfig.width == null) || (paramConfig.width.intValue() == 0)) {
        break label93;
      }
      i = 1;
      label55:
      if ((j == 0) || (paramConfig.height == null) || (paramConfig.height.intValue() == 0)) {
        break label98;
      }
    }
    label93:
    label98:
    for (int j = 1;; j = 0)
    {
      if ((j == 0) || (i == 0)) {
        break label103;
      }
      return true;
      j = 0;
      break;
      i = 0;
      break label55;
    }
    label103:
    return false;
  }
  
  public static MessageForArkApp.Size limitToSizeRange(float paramFloat, int paramInt1, int paramInt2)
  {
    int k = 30;
    int j = (int)(alem.a / paramFloat);
    int i = 390;
    if (paramInt1 < 30) {
      paramInt1 = 30;
    }
    for (;;)
    {
      if (paramInt2 < 30) {
        paramInt2 = k;
      }
      for (;;)
      {
        if ((j > 0) && (paramInt1 > j)) {
          paramInt1 = j;
        }
        for (;;)
        {
          if (paramInt2 > 390) {
            paramInt2 = i;
          }
          for (;;)
          {
            return new MessageForArkApp.Size(dp2px(paramInt1, paramFloat), dp2px(paramInt2, paramFloat));
          }
        }
      }
    }
  }
  
  private void openThirdApp(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    String str = this.ark_app_message.mSourceUrl;
    long l = nbj.a(this.ark_app_message.appId, 0L);
    if (clickAppMsg(paramContext, str, this.ark_app_message.mSourceActionData, this.ark_app_message.mSource_A_ActionData, paramQQAppInterface))
    {
      if (!buildTypeAndTitle().isSdkShare) {
        break label250;
      }
      if (l == 0L)
      {
        paramContext = "";
        awqx.b(null, "dc00898", "", "", "0X800A86D", "0X800A86D", 0, 0, paramContext, "", "", "");
        paramContext = "run";
      }
    }
    for (;;)
    {
      mpw.a(paramQQAppInterface, paramQQAppInterface.c(), "sourceclick", Long.parseLong(this.ark_app_message.appId), 0L, paramContext);
      return;
      paramContext = String.valueOf(l);
      break;
      if (click2YYB(((FragmentActivity)paramContext).getActivity(), Long.parseLong(this.ark_app_message.appId), this.ark_app_message.mSourceName, this.ark_app_message.mSourceActionData, this.ark_app_message.mSource_A_ActionData))
      {
        if (buildTypeAndTitle().isSdkShare) {
          if (l != 0L) {
            break label220;
          }
        }
        label220:
        for (paramContext = "";; paramContext = String.valueOf(l))
        {
          awqx.b(null, "dc00898", "", "", "0X800A86E", "0X800A86E", 0, 0, paramContext, "", "", "");
          paramContext = "setup";
          break;
        }
      }
      clickWebMsg(paramContext, str, this.ark_app_message.mSourceName);
      paramContext = "setup";
      continue;
      label250:
      paramContext = "run";
    }
  }
  
  public static float px2dp(int paramInt, float paramFloat)
  {
    if (paramInt == 0) {
      return 0.0F;
    }
    return paramInt / paramFloat;
  }
  
  public void attachArkView(alfb paramalfb, alff paramalff, int paramInt)
  {
    paramalff.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130843998);
    if (this.arkContainer == null)
    {
      this.arkContainer = new adai();
      this.arkContainer.a(paramalfb);
      alep.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "ShowView", this.ark_app_message.appName, null, alep.f, 0, this.ark_app_message.from);
      if (!TextUtils.isEmpty(this.ark_app_message.appId)) {
        alep.a(null, "ShowSdkArkView", this.ark_app_message.appName, null, alep.f, 0, this.ark_app_message.from);
      }
    }
    ArkAppMessage.Config localConfig = new ArkAppMessage.Config();
    localConfig.fromString(this.ark_app_message.config);
    this.arkContainer.a(paramalfb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    Object localObject1 = this.arkContainer;
    ((adai)localObject1).a(this.ark_app_message.appName, this.ark_app_message.appView, this.ark_app_message.appMinVersion, this.ark_app_message.metaList, alem.a(), this, paramalfb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    Object localObject2;
    ArkAppView localArkAppView;
    if (!this.isMultiItemMsg)
    {
      ((adai)localObject1).setFixSize(alem.a, alem.a);
      ((adai)localObject1).setMaxSize(alem.a, alem.a);
      ((adai)localObject1).setMinSize(alem.a * 7 / 10, alem.a);
      QLog.d("MessageForArkApp", 1, new Object[] { "ArkFold.MessageForArkApp.attachArkView ArkAppCenterUtil.sChatBubbleMaxWidth=", Integer.valueOf(alem.a), ",app=", this.ark_app_message.appName });
      alem.a("MessageForArkApp.attachArkView", paramalfb.jdField_a_of_type_AndroidContentContext);
      localObject1 = new amsh(this, paramalff, (adai)localObject1, paramalfb, paramInt);
      localObject2 = paramalff.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
      localArkAppView = paramalff.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
      ((ArkViewImplement.ArkViewInterface)localObject2).setClipRadius(16.0F);
      if (!isRectangleBorder(localConfig)) {
        break label570;
      }
      ((ArkViewImplement.ArkViewInterface)localObject2).setBorderType(0);
    }
    for (;;)
    {
      localArkAppView.a(this.arkContainer, paramalff.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
      ((ArkViewImplement.ArkViewInterface)localObject2).setOnTouchListener(paramalfb.jdField_a_of_type_Acmv);
      ((ArkViewImplement.ArkViewInterface)localObject2).setOnLongClickListener(paramalfb.jdField_a_of_type_Acmv);
      ((ArkViewImplement.ArkViewInterface)localObject2).setLoadCallback((ArkViewImplement.LoadCallback)localObject1);
      if (paramalff.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout != null)
      {
        paramalff.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setOnTouchListener(paramalfb.jdField_a_of_type_Acmv);
        paramalff.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setOnLongClickListener(paramalfb.jdField_a_of_type_Acmv);
      }
      paramalff.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramalff.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
      int k;
      int m;
      int i;
      int j;
      if (isSetSizeByConfig(localConfig))
      {
        localObject2 = limitToSizeRange(alem.a(), localConfig.width.intValue(), localConfig.height.intValue());
        this.arkContainer.setFixSize(((MessageForArkApp.Size)localObject2).width, ((MessageForArkApp.Size)localObject2).height);
        k = ((MessageForArkApp.Size)localObject2).height;
        m = ((MessageForArkApp.Size)localObject2).width;
        i = ((MessageForArkApp.Size)localObject2).height;
        j = ((MessageForArkApp.Size)localObject2).width;
      }
      for (;;)
      {
        this.arkContainer.setMinSize(j, i);
        this.arkContainer.setMaxSize(m, k);
        break;
        ((adai)localObject1).setFixSize(alem.a, alem.a);
        k = alem.a;
        m = alem.a;
        j = alem.a;
        i = alem.a;
      }
      label570:
      ((ArkViewImplement.ArkViewInterface)localObject2).setBorderType(1);
    }
  }
  
  public MessageForArkApp.ArkReportData buildTypeAndTitle()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    String str1 = this.ark_app_message.appName;
    String str2 = this.ark_app_message.appView;
    MessageForArkApp.ArkReportData localArkReportData = new MessageForArkApp.ArkReportData();
    if ("com.tencent.structmsg".equals(str1)) {
      if ("music".equals(str2))
      {
        localArkReportData.type = "2";
        localArkReportData.title = getMusicTitle();
        if (!TextUtils.isEmpty(getMusicAppid())) {
          localArkReportData.isSdkShare = bool1;
        }
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty(localArkReportData.title)) {
        localArkReportData.title = "";
      }
      return localArkReportData;
      bool1 = false;
      break;
      if ("news".equals(str2))
      {
        localArkReportData.type = "1";
        localArkReportData.title = getTitle();
        if (!TextUtils.isEmpty(getNewsAppid())) {}
        for (bool1 = bool2;; bool1 = false)
        {
          localArkReportData.isSdkShare = bool1;
          break;
        }
        localArkReportData.type = "4";
        localArkReportData.title = this.ark_app_message.promptText;
        localArkReportData.isSdkShare = false;
      }
    }
  }
  
  public void clickTail(alff paramalff, adaw paramadaw, Context paramContext)
  {
    QQAppInterface localQQAppInterface;
    if (this.ark_app_message != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (paramalff != null)
      {
        if (TextUtils.isEmpty(this.ark_app_message.appId)) {
          break label109;
        }
        paramalff.b.setBackgroundResource(2130842000);
        paramalff.b.setOnClickListener(new amsi(this, localQQAppInterface, paramContext));
      }
      if (paramadaw != null)
      {
        if (TextUtils.isEmpty(this.ark_app_message.appId)) {
          break label122;
        }
        paramadaw.a.setBackgroundResource(2130842000);
      }
    }
    for (;;)
    {
      paramadaw.a.setOnClickListener(new amsj(this, localQQAppInterface, paramContext));
      return;
      label109:
      paramalff.b.setBackgroundResource(2130841999);
      break;
      label122:
      paramadaw.a.setBackgroundResource(2130841999);
    }
  }
  
  public void destroyContainerByRemove()
  {
    doOnEvent(2);
  }
  
  public void doOnEvent(int paramInt)
  {
    Iterator localIterator = this.mExtendMsgArkAppList.iterator();
    while (localIterator.hasNext())
    {
      MessageForArkApp localMessageForArkApp = (MessageForArkApp)localIterator.next();
      if (localMessageForArkApp != null) {
        localMessageForArkApp.doOnEvent(paramInt);
      }
    }
    if (this.arkContainer != null)
    {
      this.arkContainer.doOnEvent(paramInt);
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
    if (this.msgData != null)
    {
      ArkAppMessage localArkAppMessage = new ArkAppMessage();
      localArkAppMessage.fromBytes(this.msgData);
      if (localArkAppMessage.appName != null) {
        this.ark_app_message.appName = localArkAppMessage.appName;
      }
      if (localArkAppMessage.appView != null) {
        this.ark_app_message.appView = localArkAppMessage.appView;
      }
      if (localArkAppMessage.appDesc != null) {
        this.ark_app_message.appDesc = localArkAppMessage.appDesc;
      }
      if (localArkAppMessage.promptText != null) {
        this.ark_app_message.promptText = localArkAppMessage.promptText;
      }
      if (localArkAppMessage.appMinVersion != null) {
        this.ark_app_message.appMinVersion = localArkAppMessage.appMinVersion;
      }
      if (localArkAppMessage.metaList != null) {
        this.ark_app_message.metaList = localArkAppMessage.metaList;
      }
      if (localArkAppMessage.config != null) {
        this.ark_app_message.config = localArkAppMessage.config;
      }
      if (localArkAppMessage.from != 0) {
        this.ark_app_message.from = localArkAppMessage.from;
      }
      if (localArkAppMessage.appId != null) {
        this.ark_app_message.appId = localArkAppMessage.appId;
      }
      if (localArkAppMessage.mSourceName != null) {
        this.ark_app_message.mSourceName = localArkAppMessage.mSourceName;
      }
      if (localArkAppMessage.mSourceActionData != null) {
        this.ark_app_message.mSourceActionData = localArkAppMessage.mSourceActionData;
      }
      if (localArkAppMessage.mSource_A_ActionData != null) {
        this.ark_app_message.mSource_A_ActionData = localArkAppMessage.mSource_A_ActionData;
      }
      if (localArkAppMessage.mSourceUrl != null) {
        this.ark_app_message.mSourceUrl = localArkAppMessage.mSourceUrl;
      }
      if ((localArkAppMessage.mAppList != null) && (!localArkAppMessage.mAppList.isEmpty())) {
        this.ark_app_message.mAppList = localArkAppMessage.mAppList;
      }
      if (localArkAppMessage.mText != null) {
        this.ark_app_message.mText = localArkAppMessage.mText;
      }
      if (localArkAppMessage.mSourceAd != null) {
        this.ark_app_message.mSourceAd = localArkAppMessage.mSourceAd;
      }
    }
    if (this.msg == null) {
      this.msg = this.ark_app_message.getSummery();
    }
  }
  
  public alcj extendArkCardByOpen(adaj paramadaj, String paramString1, String paramString2)
  {
    if ((this.arkContainer != paramadaj) || (getMsgArkAppCount() >= alfn.a)) {
      return null;
    }
    MessageForArkApp localMessageForArkApp = new MessageForArkApp();
    localMessageForArkApp.compatibleMsg = this.compatibleMsg;
    localMessageForArkApp.ark_app_message = new ArkAppMessage();
    localMessageForArkApp.ark_app_message.appName = paramadaj.getAppName();
    localMessageForArkApp.ark_app_message.appView = paramString1;
    localMessageForArkApp.ark_app_message.metaList = paramString2;
    localMessageForArkApp.issend = this.issend;
    localMessageForArkApp.isMultiItemMsg = this.isMultiItemMsg;
    this.mExtendMsgArkAppList.add(0, localMessageForArkApp);
    return localMessageForArkApp;
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
    arrayOfString[1] = ArkAppMgr.getInstance().getAppPathByNameFromLocal(this.ark_app_message.appName, this.ark_app_message.appView, null, false);
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
  
  public MessageForArkApp getMsgArkAppByPosition(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    Iterator localIterator = this.mExtendMsgArkAppList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      MessageForArkApp localMessageForArkApp = (MessageForArkApp)localIterator.next();
      int j = localMessageForArkApp.getMsgArkAppCount();
      if (paramInt == i + j) {
        return localMessageForArkApp;
      }
      if (paramInt < i + j) {
        return localMessageForArkApp.getMsgArkAppByPosition(paramInt - i - 1);
      }
      i += j;
    }
    return null;
  }
  
  public int getMsgArkAppCount()
  {
    Iterator localIterator = this.mExtendMsgArkAppList.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((MessageForArkApp)localIterator.next()).getMsgArkAppCount() + i) {}
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
    int i = 0;
    String str = getExtInfoFromExtStr(awav.v);
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e("MessageForArkApp", 1, localNumberFormatException, new Object[0]);
    }
    return 0;
  }
  
  public String getSummery()
  {
    if (this.ark_app_message != null) {
      return this.ark_app_message.getSummery();
    }
    return ajjy.a(2131640798);
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
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public void postRead()
  {
    parse();
  }
  
  public void prewrite()
  {
    byte[] arrayOfByte = null;
    if (this.ark_app_message != null) {
      arrayOfByte = this.ark_app_message.toBytes();
    }
    this.msg = getSummery();
    this.msgData = arrayOfByte;
  }
  
  public void report(int paramInt)
  {
    MessageForArkApp.ArkReportData localArkReportData = buildTypeAndTitle();
    if (!localArkReportData.isSdkShare) {}
    do
    {
      return;
      awqx.b(null, "dc00898", "", "", "0X800A62F", "0X800A62F", 0, 0, localArkReportData.type, ForwardUtils.b(this.istroop), localArkReportData.title, "");
    } while (!QLog.isColorLevel());
    QLog.d("MessageForArkApp", 2, new Object[] { "ARK曝光=0X800A62F, type=", localArkReportData.type, ", uinType=", ForwardUtils.b(this.istroop), ", title=", localArkReportData.title });
  }
  
  public void reportClick()
  {
    MessageForArkApp.ArkReportData localArkReportData = buildTypeAndTitle();
    if (!localArkReportData.isSdkShare) {}
    String str2;
    label139:
    do
    {
      return;
      awqx.b(null, "dc00898", "", "", "0X800A630", "0X800A630", 0, 0, localArkReportData.type, ForwardUtils.b(this.istroop), localArkReportData.title, "");
      if (QLog.isColorLevel()) {
        QLog.d("MessageForArkApp", 2, new Object[] { "ARK点击=0X800A630, type=", localArkReportData.type, ", uinType=", ForwardUtils.b(this.istroop), ", title=", localArkReportData.title });
      }
      if (localArkReportData.type == "2")
      {
        if (this.istroop != 0) {
          break;
        }
        str1 = "c2c_AIO";
        if (this.istroop != 0) {
          break label238;
        }
        str2 = "";
        awqx.b(null, "dc00899", str1, "", "music_tab", "clk_musicark_share", 0, 0, str2, "", "", "");
      }
    } while ((localArkReportData.type != "1") || (!"101492711".equals(getNewsAppid())));
    if (this.istroop == 0) {}
    for (String str1 = "c2c_AIO";; str1 = "Grp_AIO")
    {
      awqx.b(null, "dc00899", str1, "", "video_tab", "clk_videoark_share", 0, 0, this.frienduin, this.ark_app_message.appId, "", "");
      return;
      str1 = "Grp_AIO";
      break;
      label238:
      str2 = this.frienduin;
      break label139;
    }
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
    paramQQAppInterface.a().a(this.frienduin, this.istroop, this.uniseq, this.msgData);
  }
  
  public void saveMsgExtStrAndFlag(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      QLog.e("MessageForArkApp", 1, "AAShare.saveMsgExtStrAndFlag app is null");
    }
    do
    {
      return;
      paramQQAppInterface.a().a(this.frienduin, this.istroop, this.uniseq, "extStr", this.extStr);
      paramQQAppInterface.a().a(this.frienduin, this.istroop, this.uniseq, this.extraflag, 0);
    } while (!QLog.isColorLevel());
    QLog.e("MessageForArkApp", 2, new Object[] { "AAShare.saveMsgExtStrAndFlag uniseq=", Long.valueOf(this.uniseq), ", extStr=", this.extStr, ", extraflag=", Integer.valueOf(this.extraflag), String.format(" ,msg=%h", new Object[] { this }) });
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
  
  public void updateArkAppMetaData(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      QLog.e("MessageForArkApp", 1, "AAShare.updateArkAppMetaData dataJson is null");
    }
    do
    {
      do
      {
        return;
        paramJSONObject = paramJSONObject.optString("forward_ark_app_meta");
      } while (TextUtils.isEmpty(paramJSONObject));
      this.ark_app_message.metaList = paramJSONObject;
      if (this.arkContainer != null) {
        this.arkContainer.updateMetaData(paramJSONObject);
      }
    } while (!QLog.isColorLevel());
    QLog.e("MessageForArkApp", 2, new Object[] { "AAShare.updateArkAppMetaData arkContainer=", this.arkContainer, ", meta=", paramJSONObject, String.format(" ,msg=%h", new Object[] { this }) });
  }
  
  public void updateProcessStateAndExtraFlag(int paramInt)
  {
    saveExtInfoToExtStr(awav.v, String.valueOf(paramInt));
    if (paramInt == 1001) {
      this.extraflag = 32772;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageForArkApp", 2, new Object[] { "AAShare.updateProcessStateAndExtraFlag uniseq=", Long.valueOf(this.uniseq), ", extStr=", this.extStr, ", extraFlag=", Integer.valueOf(this.extraflag), String.format(" ,msg=%h", new Object[] { this }) });
      }
      return;
      if (paramInt == 1003) {
        this.extraflag = 32768;
      } else if (paramInt == 1002) {
        this.extraflag = 32772;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForArkApp
 * JD-Core Version:    0.7.0.1
 */