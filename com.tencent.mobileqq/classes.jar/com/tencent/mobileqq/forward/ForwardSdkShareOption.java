package com.tencent.mobileqq.forward;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.biz.common.util.ShareToQZoneBack;
import com.tencent.biz.common.util.SubString;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.biz.widgets.ShareResultDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.device.utils.LightAppUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.selectmember.ResultRecord;
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
import com.tencent.mqp.app.sec.SecShareInfoUtil;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef.RepUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.open.sdk.report.SdkShareReporter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ImageInfo;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ReqBody;

public class ForwardSdkShareOption
  extends ForwardSdkBaseOption
  implements ShareToQZoneBack
{
  private static final String l = HardCodeUtil.a(2131704895);
  protected OpenIdObserver a;
  private ForwardD55Manager.D55ResultListener jdField_a_of_type_ComTencentMobileqqForwardForwardD55Manager$D55ResultListener = new ForwardSdkShareOption.1(this);
  private ForwardMultServerShare jdField_a_of_type_ComTencentMobileqqForwardForwardMultServerShare = new ForwardMultServerShare(this.jdField_a_of_type_AndroidOsBundle);
  @SuppressLint({"HandlerLeak"})
  private Handler b;
  protected QQCustomDialog b;
  private long d;
  private boolean o;
  private boolean p;
  
  public ForwardSdkShareOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_d_of_type_Long = -1L;
    this.jdField_b_of_type_AndroidOsHandler = new ForwardSdkShareOption.5(this);
    this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver = new ForwardSdkShareOption.8(this);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  }
  
  private boolean A()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity;
    boolean bool = false;
    if (localObject != null)
    {
      localObject = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("mobileQQ", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("favorites_first_share_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bool = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), true);
    }
    return bool;
  }
  
  private boolean B()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    if ((QFileAssistantUtils.a((String)localObject1)) && (i == 0)) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject2 = a();
    int j = ((Intent)localObject2).getIntExtra("dataline_forward_type", -1);
    localObject1 = ((Intent)localObject2).getParcelableArrayListExtra("fileinfo_array");
    localObject2 = ((Intent)localObject2).getStringArrayListExtra("dataline_forward_pathlist");
    if ((j == -1) && (localObject2 == null) && (localObject1 == null)) {
      j = 0;
    } else {
      j = 1;
    }
    return (i != 0) && (j != 0);
  }
  
  private void O()
  {
    if (l())
    {
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
      b(str, this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin"), i);
    }
  }
  
  private void P()
  {
    String str = String.valueOf(this.jdField_b_of_type_Long);
    boolean bool = this.jdField_j_of_type_Boolean;
    int i = 0;
    Object localObject;
    if (!bool)
    {
      if ((!TextUtils.isEmpty(this.i)) && (!this.i.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->preForward--share uin doesn't equal current uin");
        }
        N();
        break label216;
      }
      if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(str);
        if (localObject == null)
        {
          a(2131719039);
          this.jdField_a_of_type_AndroidOsHandler = new Handler();
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ForwardSdkShareOption.6(this), 3000L);
        }
      }
    }
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(l1, this.jdField_h_of_type_JavaLangString, this.jdField_b_of_type_Long, new ForwardSdkShareOption.7(this));
    }
    catch (Exception localException)
    {
      label174:
      break label174;
    }
    break label216;
    if (!this.jdField_h_of_type_JavaLangString.equals(((OpenID)localObject).openID))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->preForward--openid doesn't equal current local openid");
      }
      N();
    }
    else
    {
      i = 1;
    }
    label216:
    if ((i != 0) && (this.p))
    {
      this.jdField_a_of_type_AndroidOsBundle.putString("uin", "-1010");
      this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", -1);
      this.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", jdField_e_of_type_JavaLangInteger.intValue());
      n();
    }
    i = f();
    if (this.jdField_e_of_type_Int == 5) {
      Util.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "connect_sharepic", "pageview", this.jdField_b_of_type_Long, i, "");
    } else {
      Util.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "pageview", this.jdField_b_of_type_Long, i, "");
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).reportToAds(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sha_pageview", 1, "", "", str);
    if (this.jdField_e_of_type_Int == 1) {
      localObject = "1";
    }
    for (;;)
    {
      break;
      if (this.jdField_e_of_type_Int == 2) {
        localObject = "3";
      } else if (this.jdField_e_of_type_Int == 5) {
        localObject = "2";
      } else {
        localObject = "4";
      }
    }
    ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_h_of_type_JavaLangString, str, "10", "11", "0", (String)localObject, "0", "0", false, true);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A0F", "0X8005A0F", 0, 0, "1", "", "", "");
  }
  
  private int a(ArrayList<String> paramArrayList)
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
    Object localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramArrayList = (String)((Iterator)localObject).next();
      if (QfavUtil.a(paramArrayList, -1L))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("gotoQfavShareMsg|image type.picture too big [");
          ((StringBuilder)localObject).append(paramArrayList);
          ((StringBuilder)localObject).append("]");
          QLog.i("qqfav", 2, ((StringBuilder)localObject).toString());
        }
        QfavReport.a(null, "Net_AddFav", 8, 3, -3);
        return 2;
      }
    }
    return 0;
  }
  
  private Intent a()
  {
    Intent localIntent = new Intent();
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_multi_pic_path_list");
    boolean bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("qqfav_extra_multi_pic");
    boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("qdshare_file");
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("req_type");
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity))
    {
      if (i != 1)
      {
        if (i != 5)
        {
          if (i != 6) {
            return localIntent;
          }
          if (bool2)
          {
            localIntent.putExtra("dataline_forward_type", 100);
            if ((str2 != null) && (!TextUtils.isEmpty(str2)))
            {
              localIntent.putExtra("dataline_forward_path", str2);
              return localIntent;
            }
            localIntent.putExtra("dataline_forward_path", str1);
            return localIntent;
          }
        }
        else
        {
          localIntent.putExtra("dataline_forward_type", 101);
          localIntent.putExtra("dataline_forward_path", str1);
          return localIntent;
        }
      }
      else if (bool1)
      {
        localIntent.putExtra("dataline_forward_type", 101);
        if ((str2 != null) && (!TextUtils.isEmpty(str2)))
        {
          localIntent.putExtra("dataline_forward_path", str2);
          return localIntent;
        }
        localIntent.putExtra("dataline_forward_path", str1);
        return localIntent;
      }
    }
    else if (i == 5)
    {
      localIntent.putExtra("dataline_forward_type", 101);
      localIntent.putExtra("dataline_forward_path", str1);
    }
    return localIntent;
  }
  
  private String a(Bundle paramBundle, String paramString)
  {
    String str2 = paramBundle.getString("title");
    String str1 = paramBundle.getString("desc");
    boolean bool = TextUtils.isEmpty(str2);
    Object localObject = "";
    if (!bool)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("");
      paramBundle.append(str2);
      localObject = paramBundle.toString();
    }
    if (!TextUtils.isEmpty(str1))
    {
      paramBundle = str1;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramBundle = new StringBuilder();
        paramBundle.append((String)localObject);
        paramBundle.append("\n");
        paramBundle = paramBundle.toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramBundle);
        ((StringBuilder)localObject).append(str1);
        paramBundle = ((StringBuilder)localObject).toString();
      }
    }
    else
    {
      paramBundle = (Bundle)localObject;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString;
      if (!TextUtils.isEmpty(paramBundle))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramBundle);
        ((StringBuilder)localObject).append("\n");
        paramBundle = ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramBundle);
        ((StringBuilder)localObject).append(paramString);
        return ((StringBuilder)localObject).toString();
      }
    }
    else
    {
      localObject = paramBundle;
    }
    return localObject;
  }
  
  private void a(long paramLong, String paramString)
  {
    a(paramLong, paramString, this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin"), true);
    ForwardUtils.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  private void a(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean)
  {
    QLog.d("ForwardOption.ForwardSdkShareOption", 1, new Object[] { "-->handleMessage--appid = ", Long.valueOf(paramLong), ", pkgNmae = ", paramString1 });
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", -1);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    localIntent.putExtra("k_from_login", true);
    if (i == 11)
    {
      ForwardUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramString1, localIntent, this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id"));
      paramString1 = this.jdField_a_of_type_AndroidOsBundle.getString("video_url");
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        paramString1 = CGILoader.a((String)localObject);
        if (!TextUtils.isEmpty(paramString1))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(CGILoader.a(paramInt));
          ((StringBuilder)localObject).append("");
          ReportController.b(null, "CliOper", "", "", "0X8005F53", "0X8005F53", 0, 0, ((StringBuilder)localObject).toString(), "", paramString1, "");
        }
      }
    }
    paramString1 = Long.toString(System.currentTimeMillis());
    Object localObject = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if ((localObject instanceof StructMsgForImageShare))
      {
        if ((ForwardShareByServerHelper.a()) && (i == 11))
        {
          localIntent.putExtra("key_share_image_by_server", paramString1);
          paramString3 = SdkShareReporter.b(paramInt);
          String str = ((AbsShareMsg)localObject).mContentTitle;
          SdkShareReporter.a((AbsStructMsg)localObject, paramInt, paramLong);
          ThreadManager.post(new ForwardSdkShareOption.2(this, (AbsStructMsg)localObject, paramString2, paramInt, paramString3, paramString1, str), 8, null, false);
        }
        else
        {
          ThreadManager.post(new ForwardSdkShareOption.3(this, (AbsStructMsg)localObject, paramString2, paramInt), 8, null, false);
        }
      }
      else if (i == 11)
      {
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("share_send_msg_by_server", true);
        localIntent.putExtra("key_b77_sdk_share", paramString1);
        new ForwardSDKB77Sender().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (AbsShareMsg)localObject, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, paramString1);
      }
      else
      {
        a((AbsStructMsg)localObject, paramString2, paramInt, paramString3);
      }
      localIntent.putExtra("stuctmsg_bytes", ((AbsStructMsg)localObject).getBytes());
      if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("share_from_aio", false))
      {
        paramString1 = AIOUtils.a(localIntent, new int[] { 2 });
        this.jdField_a_of_type_AndroidOsBundle.remove("share_from_aio");
      }
      else
      {
        paramString1 = AIOUtils.a(localIntent, null);
        paramString1.putExtra("share_from_aio", true);
      }
      paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
      }
    }
  }
  
  private void a(Bundle paramBundle, UpCallBack.SendResult paramSendResult, String paramString1, String paramString2, String paramString3)
  {
    if ((paramSendResult.jdField_a_of_type_JavaLangObject instanceof int[]))
    {
      int[] arrayOfInt = (int[])paramSendResult.jdField_a_of_type_JavaLangObject;
      if (arrayOfInt.length == 5)
      {
        localObject = new oidb_cmd0xb77.ImageInfo();
        ((oidb_cmd0xb77.ImageInfo)localObject).md5.set(paramSendResult.d);
        ((oidb_cmd0xb77.ImageInfo)localObject).uuid.set(paramSendResult.c);
        ((oidb_cmd0xb77.ImageInfo)localObject).file_size.set(arrayOfInt[0]);
        ((oidb_cmd0xb77.ImageInfo)localObject).img_type.set(arrayOfInt[1]);
        ((oidb_cmd0xb77.ImageInfo)localObject).width.set(arrayOfInt[2]);
        ((oidb_cmd0xb77.ImageInfo)localObject).height.set(arrayOfInt[3]);
        ((oidb_cmd0xb77.ImageInfo)localObject).original.set(arrayOfInt[4]);
        ((oidb_cmd0xb77.ImageInfo)localObject).file_id.set((int)paramSendResult.jdField_b_of_type_Long);
        paramSendResult = (UpCallBack.SendResult)localObject;
        break label143;
      }
    }
    paramSendResult = null;
    label143:
    paramBundle = ForwardShareByServerHelper.a(paramBundle, null, null, paramSendResult);
    paramSendResult = BaseApplicationImpl.getApplication().getRuntime();
    if (paramSendResult == null)
    {
      QLog.e("ForwardOption.ForwardSdkShareOption", 1, "send runtime = null ");
      b(l, paramString2);
      return;
    }
    Object localObject = new Bundle();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    ((Bundle)localObject).putLong("0xb77_9_sendTime", this.jdField_d_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardSdkShareOption", 2, "sendOIDBRequest ");
    }
    ForwardStatisticsReporter.a("KEY_STAGE_2_IMAGE_B77");
    ProtoUtils.a(paramSendResult, new ForwardSdkShareOption.4(this, paramString2, paramString1, paramString3), paramBundle.toByteArray(), "OidbSvc.0xb77_9", 2935, 9, (Bundle)localObject, 0L);
  }
  
  private boolean a(AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).getStructMsgItemLists();
      if (paramAbsStructMsg != null)
      {
        int i = 0;
        while (i < paramAbsStructMsg.size())
        {
          AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)paramAbsStructMsg.get(i);
          if ((localAbsStructMsgElement instanceof StructMsgItemLayout2))
          {
            paramAbsStructMsg = (StructMsgItemLayout2)localAbsStructMsgElement;
            return (paramAbsStructMsg.o != 1) && (paramAbsStructMsg.o != 3);
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  private void b(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_notify_aio_activity");
    localIntent.putExtra("key_share_image_by_server", paramString2);
    this.jdField_a_of_type_AndroidAppActivity.sendBroadcast(localIntent);
    ForwardImageDownUpMgr.a().a(paramString2, paramString1);
  }
  
  private String f()
  {
    List localList = a();
    int i;
    if (localList != null) {
      i = localList.size();
    } else {
      i = 0;
    }
    return Integer.toString(i);
  }
  
  private boolean x()
  {
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
    ForwardD55Manager localForwardD55Manager = ((ForwardSdkStatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SDK_SHARE)).a();
    if (localForwardD55Manager.b())
    {
      QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> isForbid");
      a(localForwardD55Manager.a(), true);
      return true;
    }
    if (localForwardD55Manager.c())
    {
      QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> usedCachedAppInfo");
      this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo = localForwardD55Manager.a(this.jdField_b_of_type_Long);
      return false;
    }
    if (localForwardD55Manager.a())
    {
      QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> hasValidAppInfo");
      this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo = localForwardD55Manager.a();
      e();
      return false;
    }
    QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> waiting d55 back");
    localForwardD55Manager.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardD55Manager$D55ResultListener);
    a(2131718408);
    return true;
  }
  
  private boolean y()
  {
    if (this.jdField_e_of_type_Int == 5) {
      return ForwardShareByServerHelper.a() ^ true;
    }
    return TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote"));
  }
  
  private boolean z()
  {
    return this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_mini_program_ark_from_sdk") ^ true;
  }
  
  protected void B()
  {
    AbsStructMsg localAbsStructMsg = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
    if (localAbsStructMsg != null) {
      ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), localAbsStructMsg);
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void C() {}
  
  public void L()
  {
    if ((j()) && (this.jdField_c_of_type_Boolean))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      int i;
      if (b() == null) {
        i = 0;
      } else {
        i = b().size();
      }
      ForwardUtils.a(localQQAppInterface, "0X800A739", new String[] { Integer.toString(i) });
    }
  }
  
  void M()
  {
    super.M();
    if ((j()) && (this.jdField_c_of_type_Boolean)) {
      ForwardUtils.a(this.jdField_a_of_type_AndroidAppActivity);
    }
  }
  
  protected void N()
  {
    QLog.d("ForwardOption.ForwardSdkShareOption", 1, "showAccountConfirm");
    StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", "multi_account", "push_login_window", 0, 1, 0);
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localObject != null)
    {
      if (!((QQCustomDialog)localObject).isShowing()) {
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
    }
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131695206);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131692113);
      localObject = new ForwardSdkShareOption.9(this);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690728, (DialogInterface.OnClickListener)localObject);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131718876, (DialogInterface.OnClickListener)localObject);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    QLog.d("ForwardOption.ForwardSdkShareOption", 1, "showAccountConfirm-->(mActivity == null || mActivity.isFinishing())");
  }
  
  public int a()
  {
    if ((!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) && (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_system_share", false))) {
      return super.a();
    }
    return 2131690728;
  }
  
  public String a()
  {
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (SubString.a((String)localObject2, "UTF-8") > 105) {
        localObject1 = SubString.a((String)localObject2, 105, "UTF-8", "...");
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("DialogContent:mForwardText=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ForwardOption.ForwardSdkShareOption", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.getType() != 1020) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 1001) && (localRecentUser.getType() != 10002) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 1022) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && ((localRecentUser.getType() != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.getType() != 1006) || (a(ForwardAbility.ForwardAbilityType.jdField_h_of_type_JavaLangInteger))) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 0) || (!CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.jdField_b_of_type_Boolean))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if ((!j()) && (B()))
    {
      b(f.intValue());
      return;
    }
    H();
    ForwardStatisticsReporter.a("KEY_STAGE_2_TOTAL");
    long l1 = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
    this.jdField_a_of_type_AndroidOsBundle.putLong("res_share_id", l1);
    this.jdField_a_of_type_AndroidOsBundle.putString("res_pkg_name", (String)localObject2);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue();
    this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message_for_server", (String)localObject3);
    this.jdField_a_of_type_AndroidOsBundle.putString("share_msg_input_value", (String)localObject3);
    this.jdField_a_of_type_AndroidOsBundle.putString("res_detail_url", (String)localObject1);
    boolean bool = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle) instanceof StructMsgForImageShare;
    if (bool)
    {
      this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue());
      this.jdField_a_of_type_AndroidContentIntent.putExtra("req_type", 147);
    }
    if (j())
    {
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = "2";
      } else {
        localObject1 = "1";
      }
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str = f();
      int j = 1;
      ForwardUtils.a((QQAppInterface)localObject3, "0X800A735", new String[] { str, localObject1 });
      if (this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", -1) == 11)
      {
        int i;
        if ((bool) && (ForwardShareByServerHelper.a())) {
          i = 1;
        } else {
          i = 0;
        }
        if (bool) {
          j = 0;
        }
        if ((i == 0) && (j == 0))
        {
          this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue();
          super.a();
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqForwardForwardMultServerShare.a(b());
        }
      }
      else
      {
        if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_from_sdk"))
        {
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("forward_multi_target").iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (ResultRecord)((Iterator)localObject1).next();
            if (l()) {
              b(((ResultRecord)localObject3).uin, ((ResultRecord)localObject3).groupUin, ((ResultRecord)localObject3).getUinType());
            }
            a(l1, (String)localObject2, ((ResultRecord)localObject3).uin, ((ResultRecord)localObject3).getUinType(), ((ResultRecord)localObject3).groupUin, false);
          }
        }
        this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue();
        super.a();
      }
    }
    else if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_from_sdk"))
    {
      O();
      a(l1, (String)localObject2);
    }
    else
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
      if (this.jdField_d_of_type_Boolean)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
        this.jdField_d_of_type_Boolean = false;
      }
      this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue();
      super.y();
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_mini_program_ark_from_sdk")) {
        O();
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("report_type", "102");
      ((Bundle)localObject1).putString("act_type", "82");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(ReportDef.RepUtil.a(this.jdField_e_of_type_Int));
      ((Bundle)localObject1).putString("intext_1", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(ReportDef.RepUtil.a(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.jdField_a_of_type_AndroidOsBundle.getString("uin")));
      ((Bundle)localObject1).putString("intext_2", ((StringBuilder)localObject2).toString());
      ((Bundle)localObject1).putString("intext_3", "0");
      ReportCenter.a().a((Bundle)localObject1, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false, true);
    }
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_mini_program_ark_from_sdk", false)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F7B", "0X8009F7B", 0, 0, "1", "", "", "");
    }
  }
  
  public void a(Intent paramIntent, Bundle paramBundle, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.b() == null) {
        localObject = "";
      } else {
        localObject = this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.b();
      }
      paramBundle.putString("struct_share_key_source_url", (String)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.a() == null) {
        localObject = "";
      } else {
        localObject = this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.a();
      }
      paramBundle.putString("struct_share_key_source_icon", (String)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.c() == null) {
        localObject = "";
      } else {
        localObject = this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.c();
      }
      paramBundle.putString("struct_share_key_source_name", (String)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.d() == null) {
        localObject = "";
      } else {
        localObject = this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.d();
      }
      paramBundle.putString("struct_share_key_source_a_action_data", (String)localObject);
    }
    Object localObject = new Intent();
    ((Intent)localObject).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(this.jdField_b_of_type_Long), "shareToQQ" })));
    ((Intent)localObject).setPackage(paramString);
    paramIntent.putExtra("activity_finish_run_pendingIntent", PendingIntent.getActivity(this.jdField_a_of_type_AndroidAppActivity, 0, (Intent)localObject, 268435456));
    if (((this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity)) && (!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity))) {
      ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).setTitle(null);
    }
    if (QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      a(paramBundle, this.jdField_a_of_type_AndroidOsBundle.getString("uin"), null);
      paramIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      QFileAssistantUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramIntent);
      a(0, "", "");
    }
    else
    {
      paramIntent.setFlags(67108864);
      paramIntent.addFlags(268435456);
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity))
      {
        paramBundle.putBoolean("MigSdkShareNotDone", false);
        paramBundle.putBoolean("isMigSdkShare", true);
        paramIntent.putExtras(paramBundle);
        ((LiteActivity)this.jdField_a_of_type_AndroidAppActivity).e(paramIntent);
      }
      else
      {
        paramIntent.putExtras(paramBundle);
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramIntent);
        a(0, "", "");
      }
    }
    paramIntent = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    if (!TextUtils.isEmpty(paramIntent)) {
      a(paramBundle, paramIntent, null);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super.a(paramQQAppInterface, paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardMultServerShare.a(paramQQAppInterface, paramActivity);
  }
  
  public void a(boolean paramBoolean)
  {
    a(this.jdField_a_of_type_AndroidAppActivity, paramBoolean, "shareToQQ", this.jdField_b_of_type_Long);
  }
  
  public boolean a()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    boolean bool2 = false;
    if ((localBundle.getBoolean("enable_d55", false)) && (x())) {
      return false;
    }
    boolean bool3 = super.a();
    this.o = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_qzone", false);
    boolean bool1 = bool2;
    if (this.o)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_send", true)) {
        bool1 = true;
      }
    }
    this.p = bool1;
    if (y()) {
      J();
    } else {
      QLog.d("ForwardOption.ForwardSdkShareOption", 1, "preloadData skip getQQAccountSkey");
    }
    if (bool3) {
      OpenSdkStatic.a().a(0, "SHARE_CHECK_AGENT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(this.jdField_b_of_type_Long), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
    }
    try
    {
      this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 1);
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      QLog.e("ForwardOption.ForwardSdkShareOption", 1, "preloadData mExtraData.putInt error : ", localArrayIndexOutOfBoundsException);
    }
    P();
    b("KEY_STAGE_1_TOTAL", true);
    return bool3;
  }
  
  protected boolean a(AbsStructMsg paramAbsStructMsg, String paramString1, int paramInt, String paramString2)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = paramInt;
    localSessionInfo.jdField_a_of_type_JavaLangString = paramString1;
    localSessionInfo.b = paramString2;
    if ((localSessionInfo.jdField_a_of_type_Int >= 0) && (!TextUtils.isEmpty(localSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramString1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_name");
      paramString2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_view");
      Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_desc");
      Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_ver");
      String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_prompt");
      String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_meta");
      String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_config");
      String str4 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_compat");
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
          ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "0", false, true);
        }
        localObject1 = new ArkAppMessage(str1, paramString1, (String)localObject1, paramString2, (String)localObject2, str2, str3, str4);
        paramString2 = (ArkAppMessage)ArkAppCenterCheckEvent.a(2, paramString1, this.jdField_a_of_type_AndroidOsBundle, localObject1);
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = (String)localObject1;
        }
        paramString2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_appId_ark_from_sdk");
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_name");
        str1 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_action_data");
        str2 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_a_action_data");
        str3 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_url");
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1.appId = paramString2;
          paramString1.mSourceName = ((String)localObject2);
          paramString1.mSourceActionData = str1;
          paramString1.mSource_A_ActionData = str2;
          paramString1.mSourceUrl = str3;
        }
        if (paramAbsStructMsg != null)
        {
          paramInt = localSessionInfo.jdField_a_of_type_Int;
          if ((paramInt != 1000) && (paramInt != 1004) && (paramInt != 1020)) {}
          for (paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; paramString2 = localSessionInfo.b) {
            break;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          str2 = localSessionInfo.jdField_a_of_type_JavaLangString;
          paramInt = localSessionInfo.jdField_a_of_type_Int;
          int i = MobileQQService.seq;
          MobileQQService.seq = i + 1;
          paramString1.containStructMsg = MessageRecordFactory.a((QQAppInterface)localObject2, str1, str2, paramString2, paramInt, i, paramAbsStructMsg);
        }
        if ((!TextUtils.isEmpty(((ArkAppMessage)localObject1).appName)) && (!TextUtils.isEmpty(((ArkAppMessage)localObject1).appView)) && (!TextUtils.isEmpty(((ArkAppMessage)localObject1).metaList))) {
          ArkAppDataReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ArkAppMessage)localObject1).appName, "AIOArkSdkSendMessage", 1, 0, 0L, 0L, 0L, ((ArkAppMessage)localObject1).appView, "");
        }
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, paramString1);
        return true;
      }
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
        ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false, true);
      }
      return false;
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
      ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false, true);
    }
    return false;
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null)
    {
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity)) {
        I();
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
        a(-1, HardCodeUtil.a(2131704892), HardCodeUtil.a(2131704919));
      }
    }
    try
    {
      OpenSdkStatic.a().a(1, "SHARE_CHECK_AGENT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(this.jdField_b_of_type_Long), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "类型错误");
      return false;
    }
    catch (Exception paramQQCustomDialog) {}
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject);
    boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg);
    if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_sdk_share_pure_text"))
    {
      localObject = new LinearLayout.LayoutParams(-1, -2);
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForGeneralShare))
      {
        if (!bool)
        {
          ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.b(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.b(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        }
        else
        {
          ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
          if ((!this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_ark_display_share")) || (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_from_sdk"))) {
            paramQQCustomDialog.adjustMessageTopBottomMargin(0.0F, 0.0F);
          }
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare)) {
        ((LinearLayout.LayoutParams)localObject).setMargins(0, AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.b(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      } else if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare)) {
        ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.b(-10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.b(-7.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkShareOption", 2, "updateImageView addStructView");
      }
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption$PreStructViewHolder = new ForwardSdkBaseOption.PreStructViewHolder(this, this.jdField_a_of_type_AndroidAppActivity);
      if (((!this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_ark_display_share")) || (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_from_sdk"))) && (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_mini_program_ark_from_sdk")))
      {
        paramQQCustomDialog.addView(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption$PreStructViewHolder.a(), (LinearLayout.LayoutParams)localObject);
        if ((!(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare)) && (!bool)) {
          a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, paramQQCustomDialog);
        }
      }
      else if (this.jdField_a_of_type_AndroidOsBundle.getInt("req_type") == 5)
      {
        paramQQCustomDialog.addView(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption$PreStructViewHolder.a(), (LinearLayout.LayoutParams)localObject);
        if ((!(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare)) && (!bool)) {
          a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, paramQQCustomDialog);
        }
      }
    }
    return true;
    return false;
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
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
    if ((!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) && (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_system_share", false))) {
      return super.b();
    }
    return 2131698068;
  }
  
  protected void b()
  {
    if (p()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_d_of_type_JavaLangInteger);
    }
    if (q()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_c_of_type_JavaLangInteger);
    }
    if (r()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (o()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_h_of_type_JavaLangInteger);
    }
    if (e()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_e_of_type_JavaLangInteger);
    }
    if (z())
    {
      this.jdField_a_of_type_JavaUtilSet.add(f);
      this.jdField_a_of_type_JavaUtilSet.add(k);
    }
    k();
    if (super.s()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_j_of_type_JavaLangInteger);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("detail_url"))) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_m_of_type_JavaLangInteger);
    }
  }
  
  public void b(int paramInt)
  {
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
    String str4 = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
    String str5 = this.jdField_a_of_type_AndroidOsBundle.getString("audio_url");
    String str6 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote");
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, LiteActivity.class);
    boolean bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("qqfav_extra_multi_pic");
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_multi_pic_path_list");
    boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("qdshare_file");
    if (paramInt == k.intValue())
    {
      localIntent.putExtra("targetUin", AppConstants.DATALINE_IPAD_UIN);
      localIntent.putExtra("device_type", 1);
    }
    else
    {
      localIntent.putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
      localIntent.putExtra("device_type", 0);
    }
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity))
    {
      paramInt = this.jdField_a_of_type_AndroidOsBundle.getInt("req_type");
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6)
            {
              localIntent.putExtra("dataline_forward_type", 102);
              localIntent.putExtra("dataline_forward_text", HardCodeUtil.a(2131704897));
            }
            else if (bool2)
            {
              localIntent.putExtra("dataline_forward_type", 100);
              if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
                localIntent.putExtra("dataline_forward_path", (String)localObject);
              } else {
                localIntent.putExtra("dataline_forward_path", str6);
              }
            }
            else
            {
              localObject = a(this.jdField_a_of_type_AndroidOsBundle, "");
              localIntent.putExtra("dataline_forward_type", 102);
              localIntent.putExtra("dataline_forward_text", (String)localObject);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004931", "0X8004931", 0, 0, "", "", "", "");
              a("qqdataline", "shareFromMigSdk|report send text:0X8004931.");
            }
          }
          else
          {
            localIntent.putExtra("dataline_forward_type", 101);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("forwardToDataline 1 filePath: ");
            ((StringBuilder)localObject).append(str6);
            QLog.d("ForwardOption.ForwardSdkShareOption", 1, ((StringBuilder)localObject).toString());
            localIntent.putExtra("dataline_forward_path", str6);
          }
        }
        else
        {
          localObject = a(this.jdField_a_of_type_AndroidOsBundle, str5);
          localIntent.putExtra("dataline_forward_type", 102);
          localIntent.putExtra("dataline_forward_text", (String)localObject);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
          a("qqdataline", "shareFromMigSdk|report send link:0X800492E.");
        }
      }
      else if (bool1)
      {
        localIntent.putExtra("dataline_forward_type", 101);
        if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          localIntent.putExtra("dataline_forward_path", (String)localObject);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("forwardToDataline 2 filePath: ");
          localStringBuilder.append((String)localObject);
          QLog.d("ForwardOption.ForwardSdkShareOption", 1, localStringBuilder.toString());
        }
        else
        {
          localIntent.putExtra("dataline_forward_path", str6);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("forwardToDataline 3 filePath: ");
          ((StringBuilder)localObject).append(str6);
          QLog.d("ForwardOption.ForwardSdkShareOption", 1, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        localObject = a(this.jdField_a_of_type_AndroidOsBundle, str1);
        localIntent.putExtra("dataline_forward_type", 102);
        localIntent.putExtra("dataline_forward_text", (String)localObject);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
        a("qqdataline", "shareFromMigSdk|report send link:0X800492E.");
      }
    }
    else if (this.jdField_a_of_type_AndroidOsBundle.getInt("req_type") == 5)
    {
      localIntent.putExtra("dataline_forward_type", 101);
      localIntent.putExtra("dataline_forward_path", str6);
    }
    else
    {
      if (TextUtils.isEmpty(str1))
      {
        if (!HttpUtil.isValidUrl(str2)) {
          localObject = HardCodeUtil.a(2131704889);
        } else {
          localObject = str2;
        }
      }
      else {
        localObject = str1;
      }
      localIntent.putExtra("dataline_forward_type", 102);
      localIntent.putExtra("dataline_forward_text", (String)localObject);
    }
    localObject = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
    ((Bundle)localObject).putBoolean("isBack2Root", false);
    ((Bundle)localObject).putBoolean("is_share_flag", true);
    ((Bundle)localObject).putLong("res_share_id", AppShareIDUtil.a(this.jdField_b_of_type_Long));
    ((Bundle)localObject).putString("res_pkg_name", str3);
    ((Bundle)localObject).putString("res_detail_url", str1);
    ((Bundle)localObject).putString("app_name", str4);
    ((Bundle)localObject).putString("image_url_remote", str2);
    ((Bundle)localObject).putString("image_url", str6);
    if (!TextUtils.isEmpty(str5)) {
      ((Bundle)localObject).putString("audio_url", str5);
    }
    a(localIntent, (Bundle)localObject, str3);
  }
  
  public boolean b()
  {
    return true;
  }
  
  protected int c()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
    if (i == g.intValue()) {
      return 0;
    }
    if (i == jdField_e_of_type_JavaLangInteger.intValue()) {
      return 1;
    }
    return 2;
  }
  
  public String c()
  {
    if ((!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) && (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_system_share", false)))
    {
      if (this.jdField_b_of_type_Long == 55901189L) {
        return null;
      }
      return super.c();
    }
    return this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131698050);
  }
  
  protected boolean c()
  {
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    K();
    if (j != 0)
    {
      if (j == 1) {
        break label51;
      }
      if (j == 3000) {}
    }
    else
    {
      i = 1;
      break label53;
    }
    int i = 3;
    break label53;
    label51:
    i = 2;
    try
    {
      label53:
      OpenSdkStatic.a().a(0, "SHARE_TO_QQ", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(this.jdField_b_of_type_Long), String.valueOf(i), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
      label90:
      String str1;
      if (this.jdField_e_of_type_Int == 1) {
        str1 = "1";
      } else if (this.jdField_e_of_type_Int == 2) {
        str1 = "3";
      } else if (this.jdField_e_of_type_Int == 5) {
        str1 = "2";
      } else {
        str1 = "4";
      }
      if (j == 0) {}
      do
      {
        str2 = "1";
        break;
        if (1 == j)
        {
          str2 = "2";
          break;
        }
      } while (3000 != j);
      String str2 = "3";
      Object localObject = ReportCenter.a();
      String str4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_Long);
      localStringBuilder.append("");
      ((ReportCenter)localObject).a(str4, "", localStringBuilder.toString(), "10", "12", "0", str1, str3, str2, false, true);
      if ((QSecFramework.a().a(1003).booleanValue()) && (this.jdField_c_of_type_Boolean))
      {
        i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
        str1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
        str2 = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
        str3 = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
        localObject = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
        if ((!TextUtils.isEmpty(str2)) && (!SecShareInfoUtil.a().a())) {
          SecShareInfoUtil.a().a(null, str2);
        }
        if (this.jdField_e_of_type_Int == 1) {
          SecShareInfoUtil.a().a(2, str3, i, str1);
        } else if (this.jdField_e_of_type_Int == 5) {
          SecShareInfoUtil.a().a(3, (String)localObject, i, str1);
        }
        SecShareInfoUtil.a().a();
      }
      return true;
    }
    catch (Exception localException)
    {
      break label90;
    }
  }
  
  protected int d()
  {
    long l1 = 0L;
    String str2;
    try
    {
      long l2 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).longValue();
      l1 = l2;
      String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
      l1 = l2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str2 = "";
    }
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
    boolean bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_sdk_share_pure_text");
    int i = -1;
    int k;
    int j;
    if (bool)
    {
      a("ForwardOption.ForwardSdkShareOption", "-->realShareToQfav--pure text share");
      if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title")))
      {
        k = i;
        if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_mixed_msg"))) {
          j = 1;
        }
      }
    }
    for (;;)
    {
      int m = 0;
      i = j;
      j = m;
      break label735;
      if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title"))) {
        this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_mixed_msg");
      } else {
        this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title");
      }
      k = i;
      if (!QfavBuilder.a(null, false, this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title"), this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_mixed_msg"), true, this.jdField_b_of_type_Long, str3).a(l1, str2).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null, A() ^ true)) {
        break;
      }
      k = 0;
      break;
      Object localObject;
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare))
      {
        a("ForwardOption.ForwardSdkShareOption", "-->realShareToQfav--image share");
        localObject = QfavUtil.a((StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg);
        k = i;
        if (localObject != null)
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(((StructMsgItemImage)localObject).ac);
          k = a(localArrayList);
          if (k == 0)
          {
            k = i;
            if (QfavBuilder.a(localArrayList, true, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("qqfav_extra_richmedia_title"), this.jdField_a_of_type_AndroidContentIntent.getStringExtra("qqfav_extra_mixed_msg"), true, this.jdField_b_of_type_Long, str3).a(l1, str2).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
              k = 0;
            }
          }
        }
        i = 3;
        j = 1;
        break label735;
      }
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_pic_share", false))
      {
        a("ForwardOption.ForwardSdkShareOption", "-->realShareToQfav--extra pic share");
        localObject = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("qqfav_extra_multi_pic_path_list");
        bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_only_pic", true);
        if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
        {
          j = a((ArrayList)localObject);
          if (j != 0) {
            i = j;
          } else if (QfavBuilder.a((ArrayList)localObject, bool, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("qqfav_extra_richmedia_title"), this.jdField_a_of_type_AndroidContentIntent.getStringExtra("qqfav_extra_mixed_msg"), true, this.jdField_b_of_type_Long, str3).a(l1, str2).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
            i = 0;
          }
          if ((bool) && (1 == ((ArrayList)localObject).size())) {
            j = 3;
          } else {
            j = 8;
          }
          k = ((ArrayList)localObject).size();
          m = j;
          j = k;
          k = i;
        }
        else
        {
          m = 8;
          j = 0;
          k = i;
        }
        i = m;
        break label735;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
      {
        a("ForwardOption.ForwardSdkShareOption", "-->realShareToQfav--default share");
        localObject = QfavUtil.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getXmlBytes());
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare))
        {
          j = 10;
          k = 2;
        }
        else
        {
          j = 2;
          k = 0;
        }
        if (QfavBuilder.a(k, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentTitle, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentSummary, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentCover, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentSrc, (byte[])localObject, true, this.jdField_b_of_type_Long).a(l1, str2).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null))
        {
          i = j;
          j = 0;
          k = 0;
          break label735;
        }
        k = i;
      }
      else
      {
        j = -1;
        k = i;
      }
    }
    label735:
    if (k == 0) {
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", i, 0, 69, j, "", "");
    }
    return k;
  }
  
  public void d() {}
  
  protected void d(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentIntent;
    boolean bool = false;
    if ((!((Intent)localObject1).getBooleanExtra("qqfav_extra_from_sdk_share", false)) && (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_system_share", false)))
    {
      super.d(paramInt);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("-->showQfavResultDialog--ret = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("ForwardOption.ForwardSdkShareOption", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramInt == 0)
    {
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("mobileQQ", 0);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("favorites_first_share_");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      localObject2 = ((StringBuilder)localObject2).toString();
      bool = ((SharedPreferences)localObject1).getBoolean((String)localObject2, true);
      if (!bool)
      {
        QfavUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131698150, 2);
      }
      else
      {
        ((SharedPreferences)localObject1).edit().putBoolean((String)localObject2, false).commit();
        localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131698149);
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131698141);
        }
        localStringBuilder.append((String)localObject1);
        localObject1 = localStringBuilder.toString();
        localObject1 = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719031), this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131698143), (String)localObject1, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131694637), new ForwardSdkShareOption.10(this), new ForwardSdkShareOption.11(this));
        ((QQCustomDialog)localObject1).setOnDismissListener(new ForwardSdkShareOption.12(this));
        if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(null);
          ((QQCustomDialog)localObject1).show();
        }
      }
    }
    else if (2 == paramInt)
    {
      QfavUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131694914, 1);
    }
    else if (3 == paramInt)
    {
      QfavUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131698148, 1);
    }
    else
    {
      QfavUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131698142, 1);
    }
    if (!bool) {
      a(this.jdField_a_of_type_AndroidAppActivity, true, "addToQQFavorites", this.jdField_b_of_type_Long);
    }
  }
  
  public void d(String paramString)
  {
    Object localObject = new Intent();
    ((Intent)localObject).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(this.jdField_b_of_type_Long), "shareToQQ" })));
    ((Intent)localObject).setPackage(this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name"));
    localObject = PendingIntent.getActivity(this.jdField_a_of_type_AndroidAppActivity, 0, (Intent)localObject, 268435456);
    Intent localIntent = new Intent();
    localIntent.putExtra("activity_finish_run_pendingIntent", (Parcelable)localObject);
    localIntent.putExtra("is_from_share", true);
    localIntent.putExtra("struct_share_key_source_name", this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_name"));
    if (StoryApi.a())
    {
      localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("main_tab_id", 6);
      localIntent.putExtra("open_now_tab_fragment", true);
      localIntent.putExtra("extra_from_share", true);
      localIntent.putExtra("new_video_extra_info", paramString);
      localIntent.setFlags(335544320);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      return;
    }
    localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, QQStoryMainActivity.class);
    localIntent.putExtra("new_video_extra_info", paramString);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
  
  protected boolean e()
  {
    return this.o;
  }
  
  public int f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) {
      return this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID;
    }
    return 0;
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_c_of_type_Boolean) {
      SdkShareReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void g()
  {
    super.g();
    if (j()) {
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800A734", new String[] { f() });
    }
  }
  
  protected boolean l()
  {
    return false;
  }
  
  public boolean n()
  {
    return false;
  }
  
  protected void t()
  {
    super.t();
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
    }
    catch (JSONException localJSONException)
    {
      label99:
      break label99;
    }
    if (j()) {
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800A736", new String[] { f() });
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_mini_program_ark_from_sdk", false)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F7B", "0X8009F7B", 0, 0, "2", "", "", "");
    }
    if ((!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) && (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_system_share", false)))
    {
      super.t();
      if (((this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity)) && (this.jdField_b_of_type_Long != 0L)) {
        a(this.jdField_a_of_type_AndroidAppActivity, false, "sendToMyComputer", this.jdField_b_of_type_Long);
      }
    }
    else
    {
      a(this.jdField_a_of_type_AndroidAppActivity, false, "addToQQFavorites", this.jdField_b_of_type_Long);
    }
  }
  
  protected boolean w()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_m_of_type_Boolean)
      {
        QLog.d("ForwardOption.ForwardSdkShareOption", 1, "-->sdk_share, checkAppinfoLocked, getappinfo already executing...");
        try
        {
          jdField_a_of_type_JavaLangObject.wait(20000L);
        }
        catch (InterruptedException localInterruptedException1)
        {
          QLog.e("ForwardOption.ForwardSdkShareOption", 1, "check app info locked ex", localInterruptedException1);
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo == null)
      {
        this.jdField_m_of_type_Boolean = true;
        long l1 = System.currentTimeMillis() / 1000L;
        String str = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
        Object localObject3 = this.jdField_a_of_type_AndroidAppActivity;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(l1);
        localStringBuilder.append("");
        localObject3 = AuthorityUtil.a((Context)localObject3, str, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("-->sdk_share, checkAppinfoLocked, sign: ");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(", appinfo is null.");
        QLog.d("ForwardOption.ForwardSdkShareOption", 1, localStringBuilder.toString());
        ForwardStatisticsReporter.a("KEY_GET_APP_INFO");
        Share.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long, (String)localObject3, l1, this.jdField_a_of_type_ComTencentOpenAppcommonOpensdkBusinessObserver, str);
        try
        {
          jdField_a_of_type_JavaLangObject.wait(20000L);
        }
        catch (InterruptedException localInterruptedException2)
        {
          QLog.e("ForwardOption.ForwardSdkShareOption", 1, "check app info locked ex", localInterruptedException2);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo == null) {
        QLog.d("ForwardOption.ForwardSdkShareOption", 1, "-->sdk_share, response is null.");
      }
      return true;
    }
  }
  
  public void z()
  {
    super.z();
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
    Handler localHandler = this.jdField_b_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeMessages(0);
      this.jdField_b_of_type_AndroidOsHandler = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption
 * JD-Core Version:    0.7.0.1
 */