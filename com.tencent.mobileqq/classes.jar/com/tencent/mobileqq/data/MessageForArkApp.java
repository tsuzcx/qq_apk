package com.tencent.mobileqq.data;

import abnc;
import abnd;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkViewExtraInterface;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.ark.ArkAdapterItemInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkAppHandler;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter.ItemViewHolder;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.open.appcommon.AppClient;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public class MessageForArkApp
  extends ChatMessage
  implements ArkAdapterItemInterface
{
  private static final String TAG = "MessageForArkApp";
  public ArkAioContainerWrapper arkContainer;
  public ArkAppMessage ark_app_message;
  public String compatibleMsg;
  public LinkedList mExtendMsgArkAppList = new LinkedList();
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
    AppClient.b(paramActivity, paramString2);
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
          paramString3 = (StartAppCheckHandler)paramQQAppInterface.a(23);
          paramString2.putExtra("report_open_type", "arkmsg_source");
          paramString2.putExtra("report_url", "");
          paramString2.putExtra("report_from", "1");
          paramString2.putExtra("report_click_origin", "AIOTail");
          paramString2.putExtra("report_class_name", paramContext.getClass().getName());
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
    PublicAccountUtil.a(this.ark_app_message.containStructMsg, localIntent, paramString1);
    paramContext.startActivity(localIntent);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString1, "", "", "");
    return true;
  }
  
  public static boolean getArkMutiForwardConf(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramChatMessage instanceof MessageForArkApp)) {
      try
      {
        paramChatMessage = ((MessageForArkApp)paramChatMessage).ark_app_message.config;
        if (TextUtils.isEmpty(paramChatMessage))
        {
          ArkAppCenter.b("getArkMutiForwardConf", "json is empty and mutiforward is not allowed");
          return false;
        }
        paramChatMessage = new JSONObject(paramChatMessage);
        bool1 = bool2;
        if (!paramChatMessage.has("forward")) {
          return bool1;
        }
        int i = paramChatMessage.getInt("forward");
        ArkAppCenter.b("getArkMutiForwardConf", "config data is " + i);
        bool1 = bool2;
        if (i == 0) {
          return bool1;
        }
        return true;
      }
      catch (Exception paramChatMessage)
      {
        ArkAppCenter.b("getArkMutiForwardConf", "parameter error,mutiforward is not allowed and message " + paramChatMessage.getMessage());
        return false;
      }
    } else {
      bool1 = true;
    }
    return bool1;
  }
  
  private void openThirdApp(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    String str = this.ark_app_message.mSourceUrl;
    if (clickAppMsg(paramContext, str, this.ark_app_message.mSourceActionData, this.ark_app_message.mSource_A_ActionData, paramQQAppInterface)) {
      paramContext = "run";
    }
    for (;;)
    {
      Util.a(paramQQAppInterface, paramQQAppInterface.c(), "sourceclick", Long.parseLong(this.ark_app_message.appId), 0L, paramContext);
      return;
      if (click2YYB(((FragmentActivity)paramContext).getActivity(), Long.parseLong(this.ark_app_message.appId), this.ark_app_message.mSourceName, this.ark_app_message.mSourceActionData, this.ark_app_message.mSource_A_ActionData))
      {
        paramContext = "setup";
      }
      else
      {
        clickWebMsg(paramContext, str, this.ark_app_message.mSourceName);
        paramContext = "setup";
      }
    }
  }
  
  public void attachArkView(ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, int paramInt)
  {
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130842200);
    if (this.arkContainer == null)
    {
      this.arkContainer = new ArkAioContainerWrapper();
      this.arkContainer.a(paramArkHorizontalListViewAdapter);
      localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      ArkAppDataReport.d((QQAppInterface)localObject, this.ark_app_message.appName, ArkAppDataReport.f, this.ark_app_message.from);
      if (localObject != null) {
        ((ArkAppHandler)((QQAppInterface)localObject).a(95)).a(100, 4, 1, null, null, this.ark_app_message.appName, this.ark_app_message.appView, null, 0, 0);
      }
      if (!TextUtils.isEmpty(this.ark_app_message.appId)) {
        ArkAppDataReport.e((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this.ark_app_message.appName, ArkAppDataReport.f, this.ark_app_message.from);
      }
    }
    Object localObject = new ArkAppMessage.Config();
    ((ArkAppMessage.Config)localObject).fromString(this.ark_app_message.config);
    if ((((ArkAppMessage.Config)localObject).autoSize != null) && (((ArkAppMessage.Config)localObject).autoSize.intValue() == 1)) {}
    localObject = this.arkContainer;
    ((ArkAioContainerWrapper)localObject).a(this.ark_app_message.appName, this.ark_app_message.appView, this.ark_app_message.appMinVersion, this.ark_app_message.metaList, paramArkHorizontalListViewAdapter.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity, this, paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    ((ArkAioContainerWrapper)localObject).setFixSize(BaseChatItemLayout.d, BaseChatItemLayout.d);
    ((ArkAioContainerWrapper)localObject).setMaxSize(BaseChatItemLayout.d, BaseChatItemLayout.d);
    ((ArkAioContainerWrapper)localObject).setMinSize(BaseChatItemLayout.d * 7 / 10, BaseChatItemLayout.d);
    localObject = new abnc(this, paramItemViewHolder, paramArkHorizontalListViewAdapter, (ArkAioContainerWrapper)localObject, paramInt);
    ArkAppView localArkAppView1 = paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    ArkAppView localArkAppView2 = paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    localArkAppView1.setClipRadius(15.0F);
    localArkAppView1.setBorderType(1);
    localArkAppView2.a(this.arkContainer, paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
    localArkAppView1.setOnTouchListener(paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    localArkAppView1.setOnLongClickListener(paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    localArkAppView1.setLoadCallback((ArkViewImplement.LoadCallback)localObject);
    if (paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout != null)
    {
      paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setOnTouchListener(paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
      paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setOnLongClickListener(paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    }
    paramItemViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  public void clickTail(ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, Context paramContext)
  {
    QQAppInterface localQQAppInterface;
    if (this.ark_app_message != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (TextUtils.isEmpty(this.ark_app_message.appId)) {
        break label58;
      }
      paramItemViewHolder.b.setBackgroundResource(2130840624);
    }
    for (;;)
    {
      paramItemViewHolder.b.setOnClickListener(new abnd(this, localQQAppInterface, paramContext));
      return;
      label58:
      paramItemViewHolder.b.setBackgroundResource(2130840623);
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
    }
    if (this.msg == null) {
      this.msg = this.ark_app_message.getSummery();
    }
  }
  
  public ArkAdapterItemInterface extendArkCardByOpen(ArkAppContainer paramArkAppContainer, String paramString1, String paramString2)
  {
    if ((this.arkContainer != paramArkAppContainer) || (getMsgArkAppCount() >= ArkRecommendController.a)) {
      return null;
    }
    MessageForArkApp localMessageForArkApp = new MessageForArkApp();
    localMessageForArkApp.compatibleMsg = this.compatibleMsg;
    localMessageForArkApp.ark_app_message = new ArkAppMessage();
    localMessageForArkApp.ark_app_message.appName = paramArkAppContainer.getAppName();
    localMessageForArkApp.ark_app_message.appView = paramString1;
    localMessageForArkApp.ark_app_message.metaList = paramString2;
    localMessageForArkApp.issend = this.issend;
    this.mExtendMsgArkAppList.add(0, localMessageForArkApp);
    return localMessageForArkApp;
  }
  
  public String[] getArkAppNameAndPath()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = this.ark_app_message.appName;
    arrayOfString[1] = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localQQAppInterface == null) {
      return arrayOfString;
    }
    arrayOfString[1] = ((ArkAppCenter)localQQAppInterface.getManager(120)).a().a(this.ark_app_message.appName, null);
    return arrayOfString;
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
  
  public String getSummery()
  {
    if (this.ark_app_message != null) {
      return this.ark_app_message.getSummery();
    }
    return "[轻应用]";
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
    byte[] arrayOfByte = null;
    if (this.ark_app_message != null) {
      arrayOfByte = this.ark_app_message.toBytes();
    }
    this.msg = getSummery();
    this.msgData = arrayOfByte;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForArkApp
 * JD-Core Version:    0.7.0.1
 */