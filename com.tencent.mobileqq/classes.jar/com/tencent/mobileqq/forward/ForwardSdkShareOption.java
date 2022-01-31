package com.tencent.mobileqq.forward;

import adls;
import adlt;
import adlu;
import adlv;
import adlw;
import adlx;
import adly;
import adlz;
import adma;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.biz.common.util.ShareToQZoneBack;
import com.tencent.biz.common.util.SubString;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.biz.widgets.ShareResultDialog;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.device.utils.LightAppUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.CGILoader;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.AgentActivity;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef.RepUtil;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ForwardSdkShareOption
  extends ForwardSdkBaseOption
  implements ShareToQZoneBack
{
  protected OpenIdObserver a;
  @SuppressLint({"HandlerLeak"})
  private Handler b;
  protected QQCustomDialog b;
  private boolean m;
  private boolean n;
  
  public ForwardSdkShareOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_b_of_type_AndroidOsHandler = new adlu(this);
    this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver = new adlw(this);
  }
  
  private int a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return 1;
    }
    if (paramArrayList.size() > 5)
    {
      if (QLog.isColorLevel()) {
        QLog.e("qqfav", 2, "gotoQfavShareMsg|image type.more than 5");
      }
      return 3;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (QfavUtil.a(str, -1L))
      {
        if (QLog.isColorLevel()) {
          QLog.i("qqfav", 2, "gotoQfavShareMsg|image type.picture too big [" + str + "]");
        }
        QfavReport.a(null, "Net_AddFav", 8, 3, -3);
        return 2;
      }
    }
    return 0;
  }
  
  private String a(Bundle paramBundle, String paramString)
  {
    Object localObject = "";
    String str2 = paramBundle.getString("title");
    String str1 = paramBundle.getString("desc");
    paramBundle = (Bundle)localObject;
    if (!TextUtils.isEmpty(str2)) {
      paramBundle = "" + str2;
    }
    localObject = paramBundle;
    if (!TextUtils.isEmpty(str1))
    {
      if (TextUtils.isEmpty(paramBundle)) {
        break label164;
      }
      paramBundle = paramBundle + "\n";
    }
    label164:
    for (localObject = paramBundle + str1; !TextUtils.isEmpty(paramString); localObject = str1)
    {
      paramBundle = paramString;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramBundle = (String)localObject + "\n";
        paramBundle = paramBundle + paramString;
      }
      return paramBundle;
    }
    return localObject;
  }
  
  private void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->handleMessage--appid = " + paramLong + ", pkgNmae = " + paramString);
    }
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", -1);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    localIntent.putExtra("k_from_login", true);
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    paramLong = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
    if (i == 11)
    {
      Object localObject = new Intent();
      ((Intent)localObject).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(paramLong), "shareToQQ" })));
      ((Intent)localObject).setPackage(paramString);
      localIntent.putExtra("activity_finish_run_pendingIntent", PendingIntent.getActivity(this.jdField_a_of_type_AndroidAppActivity, 0, (Intent)localObject, 268435456));
      paramString = this.jdField_a_of_type_AndroidOsBundle.getString("video_url");
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        paramString = CGILoader.a((String)localObject);
        if (!TextUtils.isEmpty(paramString)) {
          ReportController.b(null, "CliOper", "", "", "0X8005F53", "0X8005F53", 0, 0, CGILoader.a(j) + "", "", paramString, "");
        }
      }
    }
    paramString = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
    if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (!(paramString instanceof StructMsgForImageShare)) {
        break label395;
      }
      ThreadManager.post(new adlt(this, paramString, str, j), 8, null, false);
      localIntent.putExtra("stuctmsg_bytes", paramString.getBytes());
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("share_from_aio", false)) {
        break label404;
      }
      paramString = AIOUtils.a(localIntent, new int[] { 2 });
      this.jdField_a_of_type_AndroidOsBundle.remove("share_from_aio");
    }
    for (;;)
    {
      paramString.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
      label395:
      a(paramString);
      break;
      label404:
      paramString = AIOUtils.a(localIntent, null);
      paramString.putExtra("share_from_aio", true);
    }
  }
  
  private boolean b(AbsStructMsg paramAbsStructMsg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).getStructMsgItemLists();
      bool1 = bool2;
      if (paramAbsStructMsg != null) {
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramAbsStructMsg.size())
      {
        AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)paramAbsStructMsg.get(i);
        if (!(localAbsStructMsgElement instanceof StructMsgItemLayout2)) {
          break label95;
        }
        paramAbsStructMsg = (StructMsgItemLayout2)localAbsStructMsgElement;
        bool1 = bool2;
        if (paramAbsStructMsg.e != 1)
        {
          bool1 = bool2;
          if (paramAbsStructMsg.e != 3) {
            bool1 = true;
          }
        }
      }
      return bool1;
      label95:
      i += 1;
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) || (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_system_share", false))) {
      return 2131433015;
    }
    return super.a();
  }
  
  public String a()
  {
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (SubString.a(str2, "UTF-8") > 105) {
        str1 = SubString.a(str2, 105, "UTF-8", "...");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardSdkShareOption", 2, "DialogContent:mForwardText=" + str1);
    }
    return str1;
  }
  
  public List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.type != 1020) && (localRecentUser.type != 1008) && (localRecentUser.type != 1005) && (localRecentUser.type != 1009) && (localRecentUser.type != 1021) && (localRecentUser.type != 1029) && (localRecentUser.type != 1001) && (localRecentUser.type != 10002) && (localRecentUser.type != 10004) && (localRecentUser.type != 1022) && (localRecentUser.type != 1029) && (localRecentUser.type != 7000) && (localRecentUser.type != 6004) && (localRecentUser.type != 1025) && (localRecentUser.type != 1024) && ((localRecentUser.type != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.type != 1006) || (a(ForwardAbility.ForwardAbilityType.jdField_h_of_type_JavaLangInteger))) && (localRecentUser.type != 9501) && ((localRecentUser.type != 0) || (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.type))) && (((localRecentUser.type != 1004) && (localRecentUser.type != 1000)) || (this.jdField_b_of_type_Boolean))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (h()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_d_of_type_JavaLangInteger);
    }
    if (i()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (j()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (g()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_h_of_type_JavaLangInteger);
    }
    if (k()) {
      this.jdField_a_of_type_JavaUtilSet.add(e);
    }
    this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
    this.jdField_a_of_type_JavaUtilSet.add(k);
    g();
    if (super.l()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_j_of_type_JavaLangInteger);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(this.jdField_a_of_type_AndroidAppActivity, paramBoolean, "shareToQQ", this.jdField_b_of_type_Long);
  }
  
  public boolean a()
  {
    boolean bool2 = super.a();
    this.m = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_qzone", false);
    if ((this.m) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_send", true))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.n = bool1;
      x();
      if (bool2) {
        OpenSdkStatic.a().a(0, "SHARE_CHECK_AGENT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(this.jdField_b_of_type_Long), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
      }
      this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 1);
      return bool2;
    }
  }
  
  protected boolean a(AbsStructMsg paramAbsStructMsg)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    localSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    localSessionInfo.b = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    if ((localSessionInfo.jdField_a_of_type_Int < 0) || (TextUtils.isEmpty(localSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
        ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false);
      }
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_name");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_view");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_desc");
    Object localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_ver");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_prompt");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_meta");
    String str4 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_config");
    String str5 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_compat");
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1)))
    {
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
        ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false);
      }
      return false;
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
      ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "0", false);
    }
    localObject2 = new ArkAppMessage(str2, (String)localObject1, (String)localObject2, str1, (String)localObject3, str3, str4, str5);
    localObject1 = (ArkAppMessage)ArkAppCenterCheckEvent.a(2, (String)localObject1, this.jdField_a_of_type_AndroidOsBundle, localObject2);
    if (localObject1 == null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      str1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_appId_ark_from_sdk");
      localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_name");
      str2 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_action_data");
      str3 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_a_action_data");
      str4 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_url");
      if (!TextUtils.isEmpty(str1))
      {
        ((ArkAppMessage)localObject1).appId = str1;
        ((ArkAppMessage)localObject1).mSourceName = ((String)localObject3);
        ((ArkAppMessage)localObject1).mSourceActionData = str2;
        ((ArkAppMessage)localObject1).mSource_A_ActionData = str3;
        ((ArkAppMessage)localObject1).mSourceUrl = str4;
        ((ArkAppMessage)localObject1).from = 1;
      }
      if (paramAbsStructMsg != null) {
        switch (localSessionInfo.jdField_a_of_type_Int)
        {
        }
      }
      for (str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; str1 = localSessionInfo.b)
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        str3 = localSessionInfo.jdField_a_of_type_JavaLangString;
        int i = localSessionInfo.jdField_a_of_type_Int;
        int j = MobileQQService.jdField_a_of_type_Int;
        MobileQQService.jdField_a_of_type_Int = j + 1;
        ((ArkAppMessage)localObject1).containStructMsg = MessageRecordFactory.a((QQAppInterface)localObject3, str2, str3, str1, i, j, paramAbsStructMsg);
        if ((!TextUtils.isEmpty(((ArkAppMessage)localObject2).appName)) && (!TextUtils.isEmpty(((ArkAppMessage)localObject2).appView)) && (!TextUtils.isEmpty(((ArkAppMessage)localObject2).metaList))) {
          ArkAppDataReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ArkAppMessage)localObject2).appName, "AIOArkSdkSendMessage", 1, 0, 0L, 0L, 0L, ((ArkAppMessage)localObject2).appView, "");
        }
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, (ArkAppMessage)localObject1);
        return true;
      }
    }
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null)
    {
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity)) {
        w();
      }
      localObject = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
      if (!TextUtils.isEmpty(str)) {
        ((Bundle)localObject).putString("image_url_remote", str);
      }
      localObject = StructMsgFactory.a((Bundle)localObject);
      if (!AbsShareMsg.class.isInstance(localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ForwardOption.ForwardSdkShareOption", 2, "-->preloadData--structMsg is not an instance of AbsShareMsg");
        }
        a(-1, "分享类型错误", "类型错误");
      }
    }
    try
    {
      OpenSdkStatic.a().a(1, "SHARE_CHECK_AGENT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(this.jdField_b_of_type_Long), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "类型错误");
      label139:
      return false;
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject);
      boolean bool = b(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg);
      if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_sdk_share_pure_text"))
      {
        localObject = new LinearLayout.LayoutParams(-1, -2);
        if (!(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForGeneralShare)) {
          break label349;
        }
        if (bool) {
          break label338;
        }
        ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardSdkShareOption", 2, "updateImageView addStructView");
        }
        this.jdField_a_of_type_Adls = new adls(this, this.jdField_a_of_type_AndroidAppActivity);
        if ((!this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_ark_display_share")) || (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_from_sdk")))
        {
          paramQQCustomDialog.addView(this.jdField_a_of_type_Adls.a(), (LinearLayout.LayoutParams)localObject);
          if ((!(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare)) && (!bool)) {
            a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, paramQQCustomDialog);
          }
        }
        return true;
        label338:
        ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
        continue;
        label349:
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare)) {
          ((LinearLayout.LayoutParams)localObject).setMargins(0, AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        } else if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare)) {
          ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.a(-10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(-7.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
        }
      }
    }
    catch (Exception paramQQCustomDialog)
    {
      break label139;
    }
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    localObject = new LightAppUtil();
    int j = paramArrayOfDeviceInfo.length;
    int i = 0;
    while (i < j)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      if (localDeviceInfo != null)
      {
        LightAppSettingInfo localLightAppSettingInfo = ((LightAppUtil)localObject).a(localDeviceInfo);
        if ((a(jdField_j_of_type_JavaLangInteger)) && (super.a(localLightAppSettingInfo))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) || (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_system_share", false))) {
      return 2131431677;
    }
    return super.b();
  }
  
  public void b(int paramInt)
  {
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
    String str4 = this.jdField_a_of_type_AndroidOsBundle.getString("audio_url");
    String str5 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote");
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, LiteActivity.class);
    boolean bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("qqfav_extra_multi_pic");
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_multi_pic_path_list");
    boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("qdshare_file");
    if (paramInt == k.intValue())
    {
      localIntent.putExtra("targetUin", AppConstants.z);
      localIntent.putExtra("device_type", 1);
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity)) {
        break label1134;
      }
      switch (this.jdField_a_of_type_AndroidOsBundle.getInt("req_type"))
      {
      case 3: 
      case 4: 
      default: 
        localIntent.putExtra("dataline_forward_type", 102);
        localIntent.putExtra("dataline_forward_text", "无效的图片链接");
      }
    }
    Bundle localBundle;
    for (;;)
    {
      localBundle = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
      localBundle.putBoolean("isBack2Root", false);
      localBundle.putBoolean("is_share_flag", true);
      localBundle.putLong("res_share_id", AppShareIDUtil.a(this.jdField_b_of_type_Long));
      localBundle.putString("res_pkg_name", str2);
      localBundle.putString("res_detail_url", str1);
      localBundle.putString("app_name", str3);
      localBundle.putString("image_url_remote", (String)localObject2);
      localBundle.putString("image_url", str5);
      if (!TextUtils.isEmpty(str4)) {
        localBundle.putString("audio_url", str4);
      }
      if ((this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) && (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo != null))
      {
        localObject2 = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
        str1 = Share.a(this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.iconsURL, 16);
        if (((GetAppInfoProto.AndroidInfo)localObject2).sourceUrl != null) {
          break label1226;
        }
        localObject1 = "";
        label401:
        localBundle.putString("struct_share_key_source_url", (String)localObject1);
        if (str1 != null) {
          break label1239;
        }
        localObject1 = "";
        label420:
        localBundle.putString("struct_share_key_source_icon", (String)localObject1);
        if (((GetAppInfoProto.AndroidInfo)localObject2).messagetail != null) {
          break label1246;
        }
        localObject1 = "";
        label442:
        localBundle.putString("struct_share_key_source_name", (String)localObject1);
        if (((GetAppInfoProto.AndroidInfo)localObject2).packName != null) {
          break label1259;
        }
        localObject1 = "";
        label464:
        localBundle.putString("struct_share_key_source_a_action_data", (String)localObject1);
      }
      localObject1 = new Intent();
      ((Intent)localObject1).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(this.jdField_b_of_type_Long), "shareToQQ" })));
      ((Intent)localObject1).setPackage(str2);
      localIntent.putExtra("activity_finish_run_pendingIntent", PendingIntent.getActivity(this.jdField_a_of_type_AndroidAppActivity, 0, (Intent)localObject1, 268435456));
      if (((this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity)) && (!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity))) {
        ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).setTitle(null);
      }
      localIntent.setFlags(67108864);
      localIntent.addFlags(268435456);
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity)) {
        break label1272;
      }
      localBundle.putBoolean("MigSdkShareNotDone", false);
      localBundle.putBoolean("isMigSdkShare", true);
      localObject1 = (LiteActivity)this.jdField_a_of_type_AndroidAppActivity;
      localIntent.putExtras(localBundle);
      ((LiteActivity)localObject1).e(localIntent);
      return;
      localIntent.putExtra("targetUin", AppConstants.y);
      localIntent.putExtra("device_type", 0);
      break;
      if (bool2)
      {
        localIntent.putExtra("dataline_forward_type", 100);
        if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
          localIntent.putExtra("dataline_forward_path", (String)localObject1);
        } else {
          localIntent.putExtra("dataline_forward_path", str5);
        }
      }
      else
      {
        localObject1 = a(this.jdField_a_of_type_AndroidOsBundle, "");
        localIntent.putExtra("dataline_forward_type", 102);
        localIntent.putExtra("dataline_forward_text", (String)localObject1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004931", "0X8004931", 0, 0, "", "", "", "");
        if (QLog.isColorLevel())
        {
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send text:0X8004931.");
          continue;
          localIntent.putExtra("dataline_forward_type", 101);
          QLog.d("ForwardOption.ForwardSdkShareOption", 1, "forwardToDataline 1 filePath: " + str5);
          localIntent.putExtra("dataline_forward_path", str5);
          continue;
          localObject1 = a(this.jdField_a_of_type_AndroidOsBundle, str4);
          localIntent.putExtra("dataline_forward_type", 102);
          localIntent.putExtra("dataline_forward_text", (String)localObject1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
          if (QLog.isColorLevel())
          {
            QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
            continue;
            if (bool1)
            {
              localIntent.putExtra("dataline_forward_type", 101);
              if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
              {
                localIntent.putExtra("dataline_forward_path", (String)localObject1);
                QLog.d("ForwardOption.ForwardSdkShareOption", 1, "forwardToDataline 2 filePath: " + (String)localObject1);
              }
              else
              {
                localIntent.putExtra("dataline_forward_path", str5);
                QLog.d("ForwardOption.ForwardSdkShareOption", 1, "forwardToDataline 3 filePath: " + str5);
              }
            }
            else
            {
              localObject1 = a(this.jdField_a_of_type_AndroidOsBundle, str1);
              localIntent.putExtra("dataline_forward_type", 102);
              localIntent.putExtra("dataline_forward_text", (String)localObject1);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
              if (QLog.isColorLevel())
              {
                QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
                continue;
                label1134:
                if (this.jdField_a_of_type_AndroidOsBundle.getInt("req_type") != 5) {
                  break label1173;
                }
                localIntent.putExtra("dataline_forward_type", 101);
                localIntent.putExtra("dataline_forward_path", str5);
              }
            }
          }
        }
      }
    }
    label1173:
    if (TextUtils.isEmpty(str1))
    {
      if (HttpUtil.a((String)localObject2)) {
        break label1299;
      }
      localObject1 = "无效的图片链接";
    }
    for (;;)
    {
      localIntent.putExtra("dataline_forward_type", 102);
      localIntent.putExtra("dataline_forward_text", (String)localObject1);
      break;
      localObject1 = str1;
      continue;
      label1226:
      localObject1 = ((GetAppInfoProto.AndroidInfo)localObject2).sourceUrl.get();
      break label401;
      label1239:
      localObject1 = str1;
      break label420;
      label1246:
      localObject1 = ((GetAppInfoProto.AndroidInfo)localObject2).messagetail.get();
      break label442;
      label1259:
      localObject1 = ((GetAppInfoProto.AndroidInfo)localObject2).packName.get();
      break label464;
      label1272:
      localIntent.putExtras(localBundle);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      a(0, "", "");
      return;
      label1299:
      localObject1 = localObject2;
    }
  }
  
  protected boolean b()
  {
    int i;
    do
    {
      for (;;)
      {
        synchronized (jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_j_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->sdk_share, checkAppinfoLocked, getappinfo already executing...");
            }
            try
            {
              jdField_a_of_type_JavaLangObject.wait(20000L);
              if (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->sdk_share, response is null.");
              }
              return true;
            }
            catch (InterruptedException localInterruptedException1)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("ForwardOption.ForwardSdkShareOption", 2, "check app info locked ex", localInterruptedException1);
              continue;
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse == null)
        {
          this.jdField_j_of_type_Boolean = true;
          long l = System.currentTimeMillis() / 1000L;
          String str = AgentActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name"), l + "");
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->sdk_share, checkAppinfoLocked, sign: " + str + ", appinfo is null.");
          }
          Share.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long, str, l, this.jdField_a_of_type_MqqObserverBusinessObserver);
          try
          {
            jdField_a_of_type_JavaLangObject.wait(20000L);
          }
          catch (InterruptedException localInterruptedException2) {}
          if (QLog.isColorLevel()) {
            QLog.e("ForwardOption.ForwardSdkShareOption", 2, "check app info locked ex", localInterruptedException2);
          }
        }
      }
      i = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.ret.get();
    } while (((i != 110507) && (i != 110401)) || (!QLog.isColorLevel()));
    QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->sdk_share, response ret: " + i);
    return true;
  }
  
  protected int c()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
    if ((i == jdField_g_of_type_JavaLangInteger.intValue()) || (i == jdField_f_of_type_JavaLangInteger.intValue()) || (i == k.intValue())) {
      return 0;
    }
    if (i == e.intValue()) {
      return 1;
    }
    return 2;
  }
  
  public String c()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) || (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_system_share", false))) {
      return this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131431676);
    }
    if (this.jdField_b_of_type_Long == 55901189L) {
      return null;
    }
    return super.c();
  }
  
  public void c()
  {
    String str = String.valueOf(this.jdField_b_of_type_Long);
    int i = 0;
    label154:
    Object localObject;
    if (!this.jdField_g_of_type_Boolean) {
      if ((!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) && (!this.jdField_g_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->preForward--share uin doesn't equal current uin");
        }
        z();
        if ((i != 0) && (this.n))
        {
          this.jdField_a_of_type_AndroidOsBundle.putString("uin", String.valueOf("-1010"));
          this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", -1);
          this.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", e.intValue());
          j();
        }
        i = e();
        if (this.jdField_b_of_type_Int != 5) {
          break label393;
        }
        Util.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "connect_sharepic", "pageview", this.jdField_b_of_type_Long, i, "");
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sha_pageview", 1, "", "", str);
        if (this.jdField_b_of_type_Int != 1) {
          break label415;
        }
        localObject = "1";
      }
    }
    for (;;)
    {
      ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_f_of_type_JavaLangString, str, "10", "11", "0", (String)localObject, "0", "0", false);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A0F", "0X8005A0F", 0, 0, "1", "", "", "");
      return;
      if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str);
        if (localObject == null)
        {
          a(2131430160);
          this.jdField_a_of_type_AndroidOsHandler = new Handler();
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new adlv(this), 3000L);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(str);
          break;
        }
        if (!this.jdField_f_of_type_JavaLangString.equals(((OpenID)localObject).openID))
        {
          if (QLog.isColorLevel()) {
            QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->preForward--openid doesn't equal current local openid");
          }
          z();
          break;
        }
        i = 1;
        break;
      }
      i = 1;
      break;
      i = 1;
      break;
      label393:
      Util.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "pageview", this.jdField_b_of_type_Long, i, "");
      break label154;
      label415:
      if (this.jdField_b_of_type_Int == 2) {
        localObject = "3";
      } else if (this.jdField_b_of_type_Int == 5) {
        localObject = "2";
      } else {
        localObject = "4";
      }
    }
  }
  
  protected boolean c()
  {
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    y();
    int i;
    switch (j)
    {
    default: 
      i = 1;
    }
    try
    {
      OpenSdkStatic.a().a(0, "SHARE_TO_QQ", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(this.jdField_b_of_type_Long), String.valueOf(i), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
      label99:
      String str1;
      label111:
      String str2;
      if (this.jdField_b_of_type_Int == 1)
      {
        str1 = "1";
        str2 = "1";
        if (j != 0) {
          break label231;
        }
        str2 = "1";
      }
      for (;;)
      {
        ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", this.jdField_b_of_type_Long + "", "10", "12", "0", str1, str3, str2, false);
        return true;
        i = 1;
        break;
        i = 2;
        break;
        i = 3;
        break;
        if (this.jdField_b_of_type_Int == 2)
        {
          str1 = "3";
          break label111;
        }
        if (this.jdField_b_of_type_Int == 5)
        {
          str1 = "2";
          break label111;
        }
        str1 = "4";
        break label111;
        label231:
        if (1 == j) {
          str2 = "2";
        } else if (3000 == j) {
          str2 = "3";
        }
      }
    }
    catch (Exception localException)
    {
      break label99;
    }
  }
  
  protected int d()
  {
    k = -1;
    l1 = 0L;
    try
    {
      l2 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).longValue();
      l1 = l2;
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        Object localObject1;
        int i1;
        localException.printStackTrace();
        String str2 = "";
        long l2 = l1;
        continue;
        this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title");
        continue;
        Object localObject2;
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->realShareToQfav--image share");
          }
          localObject2 = QfavUtil.a((StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg);
          i1 = k;
          ArrayList localArrayList;
          if (localObject2 != null)
          {
            localArrayList = new ArrayList();
            localArrayList.add(((StructMsgItemImage)localObject2).u);
            i1 = a(localArrayList);
            if (i1 == 0) {
              break label357;
            }
          }
          for (;;)
          {
            j = 1;
            i = 3;
            k = i1;
            break;
            i1 = k;
            if (QfavBuilder.a(localArrayList, true, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("qqfav_extra_richmedia_title"), this.jdField_a_of_type_AndroidContentIntent.getStringExtra("qqfav_extra_mixed_msg"), true, this.jdField_b_of_type_Long, (String)localObject1).a(l2, str2).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
              i1 = 0;
            }
          }
        }
        boolean bool;
        if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_pic_share", false))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->realShareToQfav--extra pic share");
          }
          j = 8;
          localObject2 = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("qqfav_extra_multi_pic_path_list");
          bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_only_pic", true);
          if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {
            break label757;
          }
          i = a((ArrayList)localObject2);
          if (i != 0) {
            k = i;
          }
        }
        for (;;)
        {
          i = j;
          if (bool)
          {
            i = j;
            if (1 == ((ArrayList)localObject2).size()) {
              i = 3;
            }
          }
          for (j = ((ArrayList)localObject2).size();; j = 0)
          {
            break;
            if (!QfavBuilder.a((ArrayList)localObject2, bool, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("qqfav_extra_richmedia_title"), this.jdField_a_of_type_AndroidContentIntent.getStringExtra("qqfav_extra_mixed_msg"), true, this.jdField_b_of_type_Long, (String)localObject1).a(l2, str2).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
              break label763;
            }
            k = 0;
            break label508;
            if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->realShareToQfav--default share");
              }
              i = 2;
              localObject1 = QfavUtil.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getXmlBytes());
              i1 = 0;
              if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare))
              {
                i1 = 2;
                i = 10;
              }
              j = i;
              if (QfavBuilder.a(i1, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentTitle, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentSummary, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentCover, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentSrc, (byte[])localObject1, true, this.jdField_b_of_type_Long).a(l2, str2).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null))
              {
                k = 0;
                j = 0;
                break;
              }
            }
            i1 = 0;
            i = j;
            j = i1;
            break;
            i = 8;
          }
        }
        int i = -1;
        continue;
        int j = 0;
        i = 1;
      }
    }
    localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    j = -1;
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_sdk_share_pure_text"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->realShareToQfav--pure text share");
      }
      if ((TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title"))) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_mixed_msg")))) {
        break label770;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title")))
      {
        this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_mixed_msg");
        if (!QfavBuilder.a(null, false, this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title"), this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_mixed_msg"), true, this.jdField_b_of_type_Long, (String)localObject1).a(l2, str1).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
          break label765;
        }
        i = 0;
        j = 0;
        i1 = 1;
        k = i;
        i = i1;
        if (k == 0) {
          QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", i, 0, 69, j, "", "");
        }
        return k;
      }
    }
  }
  
  protected void d(int paramInt)
  {
    boolean bool = false;
    if ((!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) && (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_system_share", false))) {
      super.d(paramInt);
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->showQfavResultDialog--ret = " + paramInt);
      }
      Object localObject;
      String str;
      if (paramInt == 0)
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("mobileQQ", 0);
        str = "favorites_first_share_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        bool = ((SharedPreferences)localObject).getBoolean(str, true);
        if (!bool) {
          QfavUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131431680, 2);
        }
      }
      while (!bool)
      {
        a(this.jdField_a_of_type_AndroidAppActivity, true, "addToQQFavorites", this.jdField_b_of_type_Long);
        return;
        ((SharedPreferences)localObject).edit().putBoolean(str, false).commit();
        localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131431683);
        str = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
        StringBuilder localStringBuilder = new StringBuilder().append((String)localObject);
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131431684);
        }
        localObject = (String)localObject;
        localObject = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131431601), this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131431681), (String)localObject, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131431605), new adly(this), new adlz(this));
        ((QQCustomDialog)localObject).setOnDismissListener(new adma(this));
        if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(null);
          ((QQCustomDialog)localObject).show();
          continue;
          if (2 == paramInt) {
            QfavUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131431643, 1);
          } else if (3 == paramInt) {
            QfavUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131431682, 1);
          } else {
            QfavUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131431679, 1);
          }
        }
      }
    }
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) {
      return this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID;
    }
    return 0;
  }
  
  protected boolean k()
  {
    return this.m;
  }
  
  protected void m()
  {
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
    this.jdField_a_of_type_AndroidOsBundle.putLong("res_share_id", l);
    this.jdField_a_of_type_AndroidOsBundle.putString("res_pkg_name", (String)localObject);
    this.jdField_a_of_type_AndroidOsBundle.putString("res_detail_url", str);
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_from_sdk"))
    {
      a(l, (String)localObject);
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
    if (this.jdField_d_of_type_Boolean)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.jdField_d_of_type_Boolean = false;
    }
    this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue();
    super.r();
    localObject = new Bundle();
    ((Bundle)localObject).putString("report_type", "102");
    ((Bundle)localObject).putString("act_type", "82");
    ((Bundle)localObject).putString("intext_1", "" + ReportDef.RepUtil.a(this.jdField_b_of_type_Int));
    ((Bundle)localObject).putString("intext_2", "" + ReportDef.RepUtil.a(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.jdField_a_of_type_AndroidOsBundle.getString("uin")));
    ((Bundle)localObject).putString("intext_3", "0");
    ReportCenter.a().a((Bundle)localObject, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
  }
  
  protected void n()
  {
    super.n();
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("shareArkInfo");
    if (!TextUtils.isEmpty(str1)) {}
    try
    {
      Object localObject = new JSONObject(str1);
      str1 = ((JSONObject)localObject).optString("app");
      String str2 = ((JSONObject)localObject).optString("view");
      localObject = ((JSONObject)localObject).optString("meta");
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        ArkAppDataReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, "AIOArkSdkSendClosed", 1, 0, 0L, 0L, 0L, str2, "");
      }
      label95:
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
      if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) || (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_system_share", false))) {
        a(this.jdField_a_of_type_AndroidAppActivity, false, "addToQQFavorites", this.jdField_b_of_type_Long);
      }
      do
      {
        return;
        super.n();
      } while ((!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity)) || (this.jdField_b_of_type_Long == 0L));
      a(this.jdField_a_of_type_AndroidAppActivity, false, "sendToMyComputer", this.jdField_b_of_type_Long);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label95;
    }
  }
  
  protected void r()
  {
    super.r();
  }
  
  public void s()
  {
    super.s();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
    if ((this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    if ((this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
      this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_b_of_type_AndroidOsHandler = null;
    }
  }
  
  protected void u()
  {
    AbsStructMsg localAbsStructMsg = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
    if (localAbsStructMsg != null) {
      ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), localAbsStructMsg);
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void z()
  {
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", "multi_account", "push_login_window", 0, 1, 0);
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      if (!this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131430025);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131430159);
    adlx localadlx = new adlx(this);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131433015, localadlx);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131430027, localadlx);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption
 * JD-Core Version:    0.7.0.1
 */