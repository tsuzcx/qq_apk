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
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.qroute.QRoute;
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
  private static final String aB = HardCodeUtil.a(2131902787);
  private long aA = -1L;
  private ForwardMultServerShare aC = new ForwardMultServerShare(this.t);
  private ForwardD55Manager.D55ResultListener aD = new ForwardSdkShareOption.1(this);
  @SuppressLint({"HandlerLeak"})
  private Handler aE = new ForwardSdkShareOption.5(this);
  protected OpenIdObserver aw = new ForwardSdkShareOption.8(this);
  protected QQCustomDialog ax = null;
  private boolean ay;
  private boolean az;
  
  public ForwardSdkShareOption(Intent paramIntent)
  {
    super(paramIntent);
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
    a(paramLong, paramString, this.t.getString("uin"), this.t.getInt("uintype"), this.t.getString("troop_uin"), true);
    ForwardUtils.a(this.s);
  }
  
  private void a(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean)
  {
    QLog.d("ForwardOption.ForwardSdkShareOption", 1, new Object[] { "-->handleMessage--appid = ", Long.valueOf(paramLong), ", pkgNmae = ", paramString1 });
    int i = this.t.getInt("forward_type", -1);
    Intent localIntent;
    if (paramInt == 10014) {
      localIntent = aF();
    } else {
      localIntent = aE();
    }
    localIntent.putExtra("k_from_login", true);
    if (i == 11)
    {
      ForwardUtils.a(this.s, paramString1, localIntent, this.t.getLong("req_share_id"));
      paramString1 = this.t.getString("video_url");
      localObject = this.t.getString("detail_url");
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        paramString1 = CGILoader.b((String)localObject);
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
    Object localObject = StructMsgFactory.a(this.t);
    if ((localObject != null) && (this.q != null))
    {
      if ((localObject instanceof StructMsgForImageShare))
      {
        if ((ForwardShareByServerHelper.e()) && (i == 11))
        {
          localIntent.putExtra("key_share_image_by_server", paramString1);
          paramString3 = SdkShareReporter.c(paramInt);
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
        this.t.putBoolean("share_send_msg_by_server", true);
        localIntent.putExtra("key_b77_sdk_share", paramString1);
        new ForwardSDKB77Sender().a(this.q, (AbsShareMsg)localObject, this.s, this.t, paramString1);
      }
      else
      {
        a((AbsStructMsg)localObject, paramString2, paramInt, paramString3);
      }
      localIntent.putExtra("stuctmsg_bytes", ((AbsStructMsg)localObject).getBytes());
      ForwardUtils.a(paramInt, localIntent, this.t);
      if (paramBoolean)
      {
        ForwardUtils.c(localIntent.getExtras());
        this.s.startActivity(localIntent);
      }
    }
  }
  
  private void a(Bundle paramBundle, UpCallBack.SendResult paramSendResult, String paramString1, String paramString2, String paramString3)
  {
    if ((paramSendResult.l instanceof int[]))
    {
      int[] arrayOfInt = (int[])paramSendResult.l;
      if (arrayOfInt.length == 5)
      {
        localObject = new oidb_cmd0xb77.ImageInfo();
        ((oidb_cmd0xb77.ImageInfo)localObject).md5.set(paramSendResult.g);
        ((oidb_cmd0xb77.ImageInfo)localObject).uuid.set(paramSendResult.f);
        ((oidb_cmd0xb77.ImageInfo)localObject).file_size.set(arrayOfInt[0]);
        ((oidb_cmd0xb77.ImageInfo)localObject).img_type.set(arrayOfInt[1]);
        ((oidb_cmd0xb77.ImageInfo)localObject).width.set(arrayOfInt[2]);
        ((oidb_cmd0xb77.ImageInfo)localObject).height.set(arrayOfInt[3]);
        ((oidb_cmd0xb77.ImageInfo)localObject).original.set(arrayOfInt[4]);
        ((oidb_cmd0xb77.ImageInfo)localObject).file_id.set((int)paramSendResult.h);
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
      c(aB, paramString2);
      return;
    }
    Object localObject = new Bundle();
    this.aA = System.currentTimeMillis();
    ((Bundle)localObject).putLong("0xb77_9_sendTime", this.aA);
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
            return (paramAbsStructMsg.au != 1) && (paramAbsStructMsg.au != 3);
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  private boolean aI()
  {
    this.a = this.t.getLong("req_share_id");
    ForwardD55Manager localForwardD55Manager = ((ForwardSdkStatusManager)this.q.getManager(QQManagerFactory.SDK_SHARE)).a();
    if (localForwardD55Manager.b())
    {
      QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> isForbid");
      a(localForwardD55Manager.d(), true);
      return true;
    }
    if (localForwardD55Manager.c())
    {
      QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> usedCachedAppInfo");
      this.aq = localForwardD55Manager.a(this.a);
      return false;
    }
    if (localForwardD55Manager.a())
    {
      QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> hasValidAppInfo");
      this.aq = localForwardD55Manager.e();
      av();
      return false;
    }
    QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> waiting d55 back");
    localForwardD55Manager.a(this.aD);
    a(2131915900);
    return true;
  }
  
  private boolean aJ()
  {
    if (this.ar == 5) {
      return ForwardShareByServerHelper.e() ^ true;
    }
    return TextUtils.isEmpty(this.t.getString("image_url_remote"));
  }
  
  private void aK()
  {
    if (U())
    {
      String str = this.t.getString("uin");
      int i = this.t.getInt("uintype");
      b(str, this.t.getString("troop_uin"), i);
    }
  }
  
  private boolean aL()
  {
    return this.t.getBoolean("forward_mini_program_ark_from_sdk") ^ true;
  }
  
  private void aM()
  {
    String str = String.valueOf(this.a);
    boolean bool = this.af;
    int i = 0;
    Object localObject;
    if (!bool)
    {
      if ((!TextUtils.isEmpty(this.ae)) && (!this.ae.equals(this.q.getAccount())))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->preForward--share uin doesn't equal current uin");
        }
        aG();
        break label218;
      }
      if (!TextUtils.isEmpty(this.ad))
      {
        localObject = this.q.getMsgHandler().e(str);
        if (localObject == null)
        {
          a(2131916575);
          this.ag = new Handler();
          this.ag.postDelayed(new ForwardSdkShareOption.6(this), 3000L);
        }
      }
    }
    try
    {
      long l = Long.parseLong(this.q.getCurrentAccountUin());
      this.q.getMsgHandler().a(l, this.ad, this.a, new ForwardSdkShareOption.7(this));
    }
    catch (Exception localException)
    {
      label176:
      break label176;
    }
    break label218;
    if (!this.ad.equals(((OpenID)localObject).openID))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->preForward--openid doesn't equal current local openid");
      }
      aG();
    }
    else
    {
      i = 1;
    }
    label218:
    if ((i != 0) && (this.az))
    {
      this.t.putString("uin", "-1010");
      this.t.putInt("uintype", -1);
      this.t.putInt("key_forward_ability_type", f.intValue());
      I();
    }
    i = ay();
    if (this.ar == 5) {
      Util.a(this.q, null, "connect_sharepic", "pageview", this.a, i, "");
    } else {
      Util.a(this.q, null, "pageview", this.a, i, "");
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).reportToAds(this.q, "sha_pageview", 1, "", "", str);
    if (this.ar == 1) {
      localObject = "1";
    }
    for (;;)
    {
      break;
      if (this.ar == 2) {
        localObject = "3";
      } else if (this.ar == 5) {
        localObject = "2";
      } else {
        localObject = "4";
      }
    }
    ReportCenter.a().a(this.q.getAccount(), this.ad, str, "10", "11", "0", (String)localObject, "0", "0", false, true);
    ReportController.b(this.q, "CliOper", "", "", "0X8005A0F", "0X8005A0F", 0, 0, "1", "", "", "");
  }
  
  private boolean aN()
  {
    Object localObject = this.s;
    boolean bool = false;
    if (localObject != null)
    {
      localObject = this.s.getSharedPreferences("mobileQQ", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("favorites_first_share_");
      localStringBuilder.append(this.q.getAccount());
      bool = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), true);
    }
    return bool;
  }
  
  private boolean aO()
  {
    Object localObject1 = this.t.getString("uin");
    int i = this.t.getInt("uintype");
    if ((QFileAssistantUtils.a((String)localObject1)) && (i == 0)) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject2 = aP();
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
  
  private Intent aP()
  {
    Intent localIntent = new Intent();
    String str1 = this.t.getString("image_url");
    String str2 = this.t.getString("qqfav_extra_multi_pic_path_list");
    boolean bool1 = this.t.getBoolean("qqfav_extra_multi_pic");
    boolean bool2 = this.t.getBoolean("qdshare_file");
    int i = this.t.getInt("req_type");
    if ((this.s instanceof LiteActivity))
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
  
  private String aQ()
  {
    List localList = L();
    int i;
    if (localList != null) {
      i = localList.size();
    } else {
      i = 0;
    }
    return Integer.toString(i);
  }
  
  private void c(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_notify_aio_activity");
    localIntent.putExtra("key_share_image_by_server", paramString2);
    this.s.sendBroadcast(localIntent);
    ForwardImageDownUpMgr.a().a(paramString2, paramString1);
  }
  
  public String B()
  {
    if ((!this.r.getBooleanExtra("qqfav_extra_from_sdk_share", false)) && (!this.r.getBooleanExtra("qqfav_extra_from_system_share", false)))
    {
      if (this.a == 55901189L) {
        return null;
      }
      return super.B();
    }
    return this.s.getResources().getString(2131895951);
  }
  
  public int C()
  {
    if ((!this.r.getBooleanExtra("qqfav_extra_from_sdk_share", false)) && (!this.r.getBooleanExtra("qqfav_extra_from_system_share", false))) {
      return super.C();
    }
    return 2131887648;
  }
  
  public int D()
  {
    if ((!this.r.getBooleanExtra("qqfav_extra_from_sdk_share", false)) && (!this.r.getBooleanExtra("qqfav_extra_from_system_share", false))) {
      return super.D();
    }
    return 2131895969;
  }
  
  protected int F()
  {
    int i = this.t.getInt("key_forward_ability_type");
    if (i == h.intValue()) {
      return 0;
    }
    if (i == f.intValue()) {
      return 1;
    }
    return 2;
  }
  
  protected boolean U()
  {
    return false;
  }
  
  protected void W()
  {
    super.W();
    String str1 = this.t.getString("shareArkInfo");
    if (!TextUtils.isEmpty(str1)) {}
    try
    {
      Object localObject = new JSONObject(str1);
      str1 = ((JSONObject)localObject).optString("app");
      String str2 = ((JSONObject)localObject).optString("view");
      localObject = ((JSONObject)localObject).optString("meta");
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        ArkAppDataReport.a(this.q, str1, "AIOArkSdkSendClosed", 1, 0, 0L, 0L, 0L, str2, "");
      }
    }
    catch (JSONException localJSONException)
    {
      label98:
      break label98;
    }
    if (K()) {
      ForwardUtils.a(this.q, "0X800A736", new String[] { aQ() });
    }
    ReportController.b(this.q, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
    if (this.r.getBooleanExtra("forward_mini_program_ark_from_sdk", false)) {
      ReportController.b(this.q, "dc00898", "", "", "0X8009F7B", "0X8009F7B", 0, 0, "2", "", "", "");
    }
    if ((!this.r.getBooleanExtra("qqfav_extra_from_sdk_share", false)) && (!this.r.getBooleanExtra("qqfav_extra_from_system_share", false)))
    {
      super.W();
      if (((this.s instanceof LiteActivity)) && (this.a != 0L)) {
        a(this.s, false, "sendToMyComputer", this.a);
      }
    }
    else
    {
      a(this.s, false, "addToQQFavorites", this.a);
    }
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.b(localRecentUser.uin)) && (localRecentUser.getType() != 1020) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 1001) && (localRecentUser.getType() != 10002) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 1022) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && ((localRecentUser.getType() != 1) || (!c(localRecentUser.uin))) && ((localRecentUser.getType() != 1006) || (a(ForwardAbility.ForwardAbilityType.i))) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 0) || (!CrmUtils.a(this.q, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.E))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  public void a(Intent paramIntent, Bundle paramBundle, String paramString)
  {
    if (this.aq != null)
    {
      if (this.aq.c() == null) {
        localObject = "";
      } else {
        localObject = this.aq.c();
      }
      paramBundle.putString("struct_share_key_source_url", (String)localObject);
      if (this.aq.b() == null) {
        localObject = "";
      } else {
        localObject = this.aq.b();
      }
      paramBundle.putString("struct_share_key_source_icon", (String)localObject);
      if (this.aq.d() == null) {
        localObject = "";
      } else {
        localObject = this.aq.d();
      }
      paramBundle.putString("struct_share_key_source_name", (String)localObject);
      if (this.aq.e() == null) {
        localObject = "";
      } else {
        localObject = this.aq.e();
      }
      paramBundle.putString("struct_share_key_source_a_action_data", (String)localObject);
    }
    Object localObject = new Intent();
    ((Intent)localObject).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(this.a), "shareToQQ" })));
    ((Intent)localObject).setPackage(paramString);
    paramIntent.putExtra("activity_finish_run_pendingIntent", PendingIntent.getActivity(this.s, 0, (Intent)localObject, 268435456));
    if (((this.s instanceof IphoneTitleBarActivity)) && (!(this.s instanceof LiteActivity))) {
      ((IphoneTitleBarActivity)this.s).setTitle(null);
    }
    if (QFileAssistantUtils.a(this.q))
    {
      a(paramBundle, this.t.getString("uin"), null);
      paramIntent.putExtras(this.t);
      QFileAssistantUtils.a(this.s, paramIntent);
      a(0, "", "");
    }
    else
    {
      paramIntent.setFlags(67108864);
      paramIntent.addFlags(268435456);
      if ((this.s instanceof LiteActivity))
      {
        paramBundle.putBoolean("MigSdkShareNotDone", false);
        paramBundle.putBoolean("isMigSdkShare", true);
        paramIntent.putExtras(paramBundle);
        ((LiteActivity)this.s).e(paramIntent);
      }
      else
      {
        paramIntent.putExtras(paramBundle);
        this.s.startActivity(paramIntent);
        a(0, "", "");
      }
    }
    paramIntent = this.t.getString("uin");
    if (!TextUtils.isEmpty(paramIntent)) {
      a(paramBundle, paramIntent, null);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super.a(paramQQAppInterface, paramActivity);
    this.aC.a(paramQQAppInterface, paramActivity);
  }
  
  public void a(String paramString)
  {
    Object localObject = new Intent();
    ((Intent)localObject).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(this.a), "shareToQQ" })));
    ((Intent)localObject).setPackage(this.t.getString("pkg_name"));
    localObject = PendingIntent.getActivity(this.s, 0, (Intent)localObject, 268435456);
    Intent localIntent = new Intent();
    localIntent.putExtra("activity_finish_run_pendingIntent", (Parcelable)localObject);
    localIntent.putExtra("is_from_share", true);
    localIntent.putExtra("struct_share_key_source_name", this.t.getString("struct_share_key_source_name"));
    if (StoryApi.a())
    {
      localIntent.setClass(this.s, SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("main_tab_id", 6);
      localIntent.putExtra("open_now_tab_fragment", true);
      localIntent.putExtra("extra_from_share", true);
      localIntent.putExtra("new_video_extra_info", paramString);
      localIntent.setFlags(335544320);
      this.s.startActivity(localIntent);
      return;
    }
    localIntent.setClass(this.s, QQStoryMainActivity.class);
    localIntent.putExtra("new_video_extra_info", paramString);
    this.s.startActivity(localIntent);
  }
  
  protected boolean a(AbsStructMsg paramAbsStructMsg, String paramString1, int paramInt, String paramString2)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.a = paramInt;
    localSessionInfo.b = paramString1;
    localSessionInfo.c = paramString2;
    if ((localSessionInfo.a >= 0) && (!TextUtils.isEmpty(localSessionInfo.b)))
    {
      paramString1 = this.t.getString("forward_ark_app_name");
      paramString2 = this.t.getString("forward_ark_app_view");
      Object localObject1 = this.t.getString("forward_ark_app_desc");
      Object localObject2 = this.t.getString("forward_ark_app_ver");
      String str1 = this.t.getString("forward_ark_app_prompt");
      String str2 = this.t.getString("forward_ark_app_meta");
      String str3 = this.t.getString("forward_ark_app_config");
      String str4 = this.t.getString("forward_ark_app_compat");
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        if (this.t.getBoolean("forward_ark_app_direct")) {
          ReportCenter.a().a(this.q.getCurrentAccountUin(), "", "0", "2000", "2006", "0", false, true);
        }
        localObject1 = new ArkAppMessage(str1, paramString1, (String)localObject1, paramString2, (String)localObject2, str2, str3, str4);
        paramString2 = (ArkAppMessage)ArkAppCenterCheckEvent.a(2, paramString1, this.t, localObject1);
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = (String)localObject1;
        }
        paramString2 = this.t.getString("forward_appId_ark_from_sdk");
        localObject2 = this.t.getString("struct_share_key_source_name");
        str1 = this.t.getString("struct_share_key_source_action_data");
        str2 = this.t.getString("struct_share_key_source_a_action_data");
        str3 = this.t.getString("struct_share_key_source_url");
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
          paramInt = localSessionInfo.a;
          if ((paramInt != 1000) && (paramInt != 1004) && (paramInt != 1020)) {}
          for (paramString2 = this.q.getCurrentAccountUin();; paramString2 = localSessionInfo.c) {
            break;
          }
          localObject2 = this.q;
          str1 = this.q.getCurrentAccountUin();
          str2 = localSessionInfo.b;
          paramInt = localSessionInfo.a;
          int i = MobileQQService.seq;
          MobileQQService.seq = i + 1;
          paramString1.containStructMsg = MessageRecordFactory.c((QQAppInterface)localObject2, str1, str2, paramString2, paramInt, i, paramAbsStructMsg);
        }
        if ((!TextUtils.isEmpty(((ArkAppMessage)localObject1).appName)) && (!TextUtils.isEmpty(((ArkAppMessage)localObject1).appView)) && (!TextUtils.isEmpty(((ArkAppMessage)localObject1).metaList))) {
          ArkAppDataReport.a(this.q, ((ArkAppMessage)localObject1).appName, "AIOArkSdkSendMessage", 1, 0, 0L, 0L, 0L, ((ArkAppMessage)localObject1).appView, "");
        }
        ChatActivityFacade.a(this.q, localSessionInfo, paramString1);
        return true;
      }
      if (this.t.getBoolean("forward_ark_app_direct")) {
        ReportCenter.a().a(this.q.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false, true);
      }
      return false;
    }
    if (this.t.getBoolean("forward_ark_app_direct")) {
      ReportCenter.a().a(this.q.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false, true);
    }
    return false;
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    Object localObject;
    if (this.am == null)
    {
      if (!(this.s instanceof LiteActivity)) {
        aw();
      }
      localObject = new Bundle(this.t);
      String str = this.t.getString("image_url");
      if (!TextUtils.isEmpty(str)) {
        ((Bundle)localObject).putString("image_url_remote", str);
      }
      localObject = StructMsgFactory.a((Bundle)localObject);
      if (!AbsShareMsg.class.isInstance(localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ForwardOption.ForwardSdkShareOption", 2, "-->preloadData--structMsg is not an instance of AbsShareMsg");
        }
        a(-1, HardCodeUtil.a(2131902784), HardCodeUtil.a(2131902811));
      }
    }
    try
    {
      OpenSdkStatic.a().a(1, "SHARE_CHECK_AGENT", this.q.getCurrentAccountUin(), String.valueOf(this.a), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "类型错误");
      return false;
    }
    catch (Exception paramQQCustomDialog) {}
    this.am = ((AbsShareMsg)localObject);
    boolean bool = a(this.am);
    if (!this.t.getBoolean("key_sdk_share_pure_text"))
    {
      localObject = new LinearLayout.LayoutParams(-1, -2);
      if ((this.am instanceof StructMsgForGeneralShare))
      {
        if (!bool)
        {
          ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.b(-15.0F, this.s.getResources()), 0, AIOUtils.b(-15.0F, this.s.getResources()), AIOUtils.b(5.0F, this.s.getResources()));
        }
        else
        {
          ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
          if ((!this.t.getBoolean("is_ark_display_share")) || (!this.t.getBoolean("forward_ark_from_sdk"))) {
            paramQQCustomDialog.adjustMessageTopBottomMargin(0.0F, 0.0F);
          }
        }
      }
      else if ((this.am instanceof StructMsgForAudioShare)) {
        ((LinearLayout.LayoutParams)localObject).setMargins(0, AIOUtils.b(5.0F, this.s.getResources()), 0, AIOUtils.b(10.0F, this.s.getResources()));
      } else if ((this.am instanceof StructMsgForImageShare)) {
        ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.b(-10.0F, this.s.getResources()), 0, AIOUtils.b(-7.5F, this.s.getResources()), 0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkShareOption", 2, "updateImageView addStructView");
      }
      this.al = new ForwardSdkBaseOption.PreStructViewHolder(this, this.s);
      if (((!this.t.getBoolean("is_ark_display_share")) || (!this.t.getBoolean("forward_ark_from_sdk"))) && (!this.t.getBoolean("forward_mini_program_ark_from_sdk")))
      {
        paramQQCustomDialog.addView(this.al.a(), (LinearLayout.LayoutParams)localObject);
        if ((!(this.am instanceof StructMsgForImageShare)) && (!bool)) {
          a(this.am.mSourceName, paramQQCustomDialog);
        }
      }
      else if (this.t.getInt("req_type") == 5)
      {
        paramQQCustomDialog.addView(this.al.a(), (LinearLayout.LayoutParams)localObject);
        if ((!(this.am instanceof StructMsgForImageShare)) && (!bool)) {
          a(this.am.mSourceName, paramQQCustomDialog);
        }
      }
    }
    return true;
    return false;
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (SmartDeviceProxyMgr)this.q.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    localObject = new LightAppUtil();
    int j = paramArrayOfDeviceInfo.length;
    int i = 0;
    while (i < j)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      if (localDeviceInfo != null)
      {
        LightAppSettingInfo localLightAppSettingInfo = ((LightAppUtil)localObject).a(localDeviceInfo);
        if ((a(k)) && (super.a(localLightAppSettingInfo))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  public void aC()
  {
    if ((K()) && (this.F))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      int i;
      if (M() == null) {
        i = 0;
      } else {
        i = M().size();
      }
      ForwardUtils.a(localQQAppInterface, "0X800A739", new String[] { Integer.toString(i) });
    }
  }
  
  void aD()
  {
    super.aD();
    if ((K()) && (this.F)) {
      ForwardUtils.a(this.s);
    }
  }
  
  protected Intent aE()
  {
    Intent localIntent = new Intent(this.s, SplashActivity.class);
    if (!this.t.getBoolean("share_from_aio", false))
    {
      localIntent = AIOUtils.a(localIntent, new int[] { 2 });
      this.t.remove("share_from_aio");
      return localIntent;
    }
    localIntent = AIOUtils.a(localIntent, null);
    localIntent.putExtra("share_from_aio", true);
    return localIntent;
  }
  
  protected Intent aF()
  {
    if (!this.t.getBoolean("share_from_aio", false)) {
      this.t.remove("share_from_aio");
    } else {
      this.t.putBoolean("share_from_aio", true);
    }
    LaunchGuildChatPieParam localLaunchGuildChatPieParam = new LaunchGuildChatPieParam().a(this.t.getString("guild_id", "")).b(this.t.getString("uin", "")).a(null).b(false).c(false).d(true).b();
    return ((ILaunchGuildChatPieApi)QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatPieIntent(this.s, localLaunchGuildChatPieParam);
  }
  
  protected void aG()
  {
    QLog.d("ForwardOption.ForwardSdkShareOption", 1, "showAccountConfirm");
    StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCountCliOper(this.q, this.q.getAccount(), "", "multi_account", "push_login_window", 0, 1, 0);
    Object localObject = this.ax;
    if (localObject != null)
    {
      if (!((QQCustomDialog)localObject).isShowing()) {
        this.ax.show();
      }
      return;
    }
    if ((this.s != null) && (!this.s.isFinishing()))
    {
      this.ax = DialogUtil.a(this.s, 230);
      this.ax.setMessage(2131892939);
      this.ax.setTitle(2131889094);
      localObject = new ForwardSdkShareOption.9(this);
      this.ax.setNegativeButton(2131887648, (DialogInterface.OnClickListener)localObject);
      this.ax.setPositiveButton(2131916409, (DialogInterface.OnClickListener)localObject);
      this.ax.show();
      return;
    }
    QLog.d("ForwardOption.ForwardSdkShareOption", 1, "showAccountConfirm-->(mActivity == null || mActivity.isFinishing())");
  }
  
  public boolean ac()
  {
    return false;
  }
  
  public void ad()
  {
    super.ad();
    this.q.removeObserver(this.aw);
    if ((this.B != null) && (this.B.isShowing())) {
      this.B.dismiss();
    }
    if ((this.aj != null) && (this.aj.isShowing())) {
      this.aj.dismiss();
    }
    if (this.ag != null) {
      this.ag.removeCallbacksAndMessages(null);
    }
    Handler localHandler = this.aE;
    if (localHandler != null)
    {
      localHandler.removeMessages(0);
      this.aE = null;
    }
  }
  
  public void ak() {}
  
  public int ay()
  {
    if (this.am != null) {
      return this.am.mMsgServiceID;
    }
    return 0;
  }
  
  protected boolean az()
  {
    synchronized (ap)
    {
      if (this.ao)
      {
        QLog.d("ForwardOption.ForwardSdkShareOption", 1, "-->sdk_share, checkAppinfoLocked, getappinfo already executing...");
        try
        {
          ap.wait(20000L);
        }
        catch (InterruptedException localInterruptedException1)
        {
          QLog.e("ForwardOption.ForwardSdkShareOption", 1, "check app info locked ex", localInterruptedException1);
        }
      }
      else if (this.aq == null)
      {
        this.ao = true;
        long l = System.currentTimeMillis() / 1000L;
        String str = this.t.getString("pkg_name");
        Object localObject3 = this.s;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(l);
        localStringBuilder.append("");
        localObject3 = AuthorityUtil.a((Context)localObject3, str, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("-->sdk_share, checkAppinfoLocked, sign: ");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(", appinfo is null.");
        QLog.d("ForwardOption.ForwardSdkShareOption", 1, localStringBuilder.toString());
        ForwardStatisticsReporter.a("KEY_GET_APP_INFO");
        Share.a(this.q, this.s, this.q.getCurrentAccountUin(), this.a, (String)localObject3, l, this.au, str);
        try
        {
          ap.wait(20000L);
        }
        catch (InterruptedException localInterruptedException2)
        {
          QLog.e("ForwardOption.ForwardSdkShareOption", 1, "check app info locked ex", localInterruptedException2);
        }
      }
      if (this.aq == null) {
        QLog.d("ForwardOption.ForwardSdkShareOption", 1, "-->sdk_share, response is null.");
      }
      return true;
    }
  }
  
  protected void b()
  {
    if ((!K()) && (aO()))
    {
      b(g.intValue());
      return;
    }
    ar();
    ForwardStatisticsReporter.a("KEY_STAGE_2_TOTAL");
    long l = this.t.getLong("req_share_id");
    Object localObject2 = this.t.getString("pkg_name");
    Object localObject1 = this.t.getString("detail_url");
    this.t.putBoolean("isBack2Root", false);
    this.t.putLong("res_share_id", l);
    this.t.putString("res_pkg_name", (String)localObject2);
    Object localObject3 = this.A.getInputValue();
    this.t.putString("share_comment_message_for_server", (String)localObject3);
    this.t.putString("share_msg_input_value", (String)localObject3);
    this.t.putString("res_detail_url", (String)localObject1);
    boolean bool1 = StructMsgFactory.a(this.t) instanceof StructMsgForImageShare;
    if (bool1)
    {
      this.t.putString("share_comment_message", this.A.getInputValue());
      this.r.putExtra("req_type", 147);
    }
    boolean bool2 = K();
    int j = 1;
    if (bool2)
    {
      this.t.putInt("sdk_share_type", 2);
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = "2";
      } else {
        localObject1 = "1";
      }
      ForwardUtils.a(this.q, "0X800A735", new String[] { aQ(), localObject1 });
      if (this.t.getInt("forward_type", -1) == 11)
      {
        int i;
        if ((bool1) && (ForwardShareByServerHelper.e())) {
          i = 1;
        } else {
          i = 0;
        }
        if (bool1) {
          j = 0;
        }
        if ((i == 0) && (j == 0))
        {
          this.ai = this.A.getInputValue();
          super.b();
        }
        else
        {
          this.aC.a(M());
        }
      }
      else
      {
        if (this.t.getBoolean("forward_ark_from_sdk"))
        {
          localObject1 = this.t.getParcelableArrayList("forward_multi_target").iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (ResultRecord)((Iterator)localObject1).next();
            if (U()) {
              b(((ResultRecord)localObject3).uin, ((ResultRecord)localObject3).groupUin, ((ResultRecord)localObject3).getUinType());
            }
            a(l, (String)localObject2, ((ResultRecord)localObject3).uin, ((ResultRecord)localObject3).getUinType(), ((ResultRecord)localObject3).groupUin, false);
          }
        }
        this.ai = this.A.getInputValue();
        super.b();
      }
    }
    else
    {
      this.t.putInt("sdk_share_type", 1);
      if (this.t.getBoolean("forward_ark_from_sdk"))
      {
        aK();
        a(l, (String)localObject2);
      }
      else
      {
        ReportController.b(this.q, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
        if (this.H)
        {
          ReportController.b(this.q, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
          this.H = false;
        }
        this.ai = this.A.getInputValue();
        super.ab();
        if (this.t.getBoolean("forward_mini_program_ark_from_sdk")) {
          aK();
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("report_type", "102");
        ((Bundle)localObject1).putString("act_type", "82");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(ReportDef.RepUtil.a(this.ar));
        ((Bundle)localObject1).putString("intext_1", ((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(ReportDef.RepUtil.a(this.t.getInt("uintype"), this.t.getString("uin")));
        ((Bundle)localObject1).putString("intext_2", ((StringBuilder)localObject2).toString());
        ((Bundle)localObject1).putString("intext_3", "0");
        ReportCenter.a().a((Bundle)localObject1, "", this.q.getCurrentAccountUin(), false, true);
      }
    }
    if (this.r.getBooleanExtra("forward_mini_program_ark_from_sdk", false)) {
      ReportController.b(this.q, "dc00898", "", "", "0X8009F7B", "0X8009F7B", 0, 0, "1", "", "", "");
    }
  }
  
  public void b(int paramInt)
  {
    String str1 = this.t.getString("detail_url");
    String str3 = this.t.getString("pkg_name");
    String str4 = this.t.getString("app_name");
    String str5 = this.t.getString("audio_url");
    String str6 = this.t.getString("image_url");
    String str2 = this.t.getString("image_url_remote");
    Intent localIntent = new Intent(this.s, LiteActivity.class);
    boolean bool1 = this.t.getBoolean("qqfav_extra_multi_pic");
    Object localObject = this.t.getString("qqfav_extra_multi_pic_path_list");
    boolean bool2 = this.t.getBoolean("qdshare_file");
    if (paramInt == l.intValue())
    {
      localIntent.putExtra("targetUin", AppConstants.DATALINE_IPAD_UIN);
      localIntent.putExtra("device_type", 1);
    }
    else
    {
      localIntent.putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
      localIntent.putExtra("device_type", 0);
    }
    if ((this.s instanceof LiteActivity))
    {
      paramInt = this.t.getInt("req_type");
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6)
            {
              localIntent.putExtra("dataline_forward_type", 102);
              localIntent.putExtra("dataline_forward_text", HardCodeUtil.a(2131902789));
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
              localObject = a(this.t, "");
              localIntent.putExtra("dataline_forward_type", 102);
              localIntent.putExtra("dataline_forward_text", (String)localObject);
              ReportController.b(this.q, "CliOper", "", "", "0X8004931", "0X8004931", 0, 0, "", "", "", "");
              b("qqdataline", "shareFromMigSdk|report send text:0X8004931.");
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
          localObject = a(this.t, str5);
          localIntent.putExtra("dataline_forward_type", 102);
          localIntent.putExtra("dataline_forward_text", (String)localObject);
          ReportController.b(this.q, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
          b("qqdataline", "shareFromMigSdk|report send link:0X800492E.");
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
        localObject = a(this.t, str1);
        localIntent.putExtra("dataline_forward_type", 102);
        localIntent.putExtra("dataline_forward_text", (String)localObject);
        ReportController.b(this.q, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
        b("qqdataline", "shareFromMigSdk|report send link:0X800492E.");
      }
    }
    else if (this.t.getInt("req_type") == 5)
    {
      localIntent.putExtra("dataline_forward_type", 101);
      localIntent.putExtra("dataline_forward_path", str6);
    }
    else
    {
      if (TextUtils.isEmpty(str1))
      {
        if (!HttpUtil.isValidUrl(str2)) {
          localObject = HardCodeUtil.a(2131902781);
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
    localObject = new Bundle(this.t);
    ((Bundle)localObject).putBoolean("isBack2Root", false);
    ((Bundle)localObject).putBoolean("is_share_flag", true);
    ((Bundle)localObject).putLong("res_share_id", AppShareIDUtil.c(this.a));
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
  
  public void b(boolean paramBoolean)
  {
    a(this.s, paramBoolean, "shareToQQ", this.a);
  }
  
  protected void c()
  {
    if (ag()) {
      this.C.add(e);
    }
    if (ah()) {
      this.C.add(d);
    }
    if (ai()) {
      this.C.add(c);
    }
    if (af()) {
      this.C.add(i);
    }
    if (q()) {
      this.C.add(f);
    }
    if (aL())
    {
      this.C.add(g);
      this.C.add(l);
    }
    A();
    if (super.aj()) {
      this.C.add(k);
    }
    if (!TextUtils.isEmpty(this.t.getString("detail_url"))) {
      this.C.add(n);
    }
  }
  
  protected void d(int paramInt)
  {
    Object localObject1 = this.r;
    boolean bool = false;
    if ((!((Intent)localObject1).getBooleanExtra("qqfav_extra_from_sdk_share", false)) && (!this.r.getBooleanExtra("qqfav_extra_from_system_share", false)))
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
      localObject1 = this.s.getSharedPreferences("mobileQQ", 0);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("favorites_first_share_");
      ((StringBuilder)localObject2).append(this.q.getAccount());
      localObject2 = ((StringBuilder)localObject2).toString();
      bool = ((SharedPreferences)localObject1).getBoolean((String)localObject2, true);
      if (!bool)
      {
        QfavUtil.a(this.s, 2131896051, 2);
      }
      else
      {
        ((SharedPreferences)localObject1).edit().putBoolean((String)localObject2, false).commit();
        localObject1 = this.s.getString(2131896050);
        localObject2 = this.t.getString("app_name");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = this.s.getString(2131896042);
        }
        localStringBuilder.append((String)localObject1);
        localObject1 = localStringBuilder.toString();
        localObject1 = DialogUtil.a(this.s, 230, this.s.getResources().getString(2131916567), this.s.getResources().getString(2131896044), (String)localObject1, this.s.getResources().getString(2131892321), new ForwardSdkShareOption.10(this), new ForwardSdkShareOption.11(this));
        ((QQCustomDialog)localObject1).setOnDismissListener(new ForwardSdkShareOption.12(this));
        if (!this.s.isFinishing())
        {
          this.A.setOnDismissListener(null);
          ((QQCustomDialog)localObject1).show();
        }
      }
    }
    else if (2 == paramInt)
    {
      QfavUtil.a(this.s, 2131892640, 1);
    }
    else if (3 == paramInt)
    {
      QfavUtil.a(this.s, 2131896049, 1);
    }
    else
    {
      QfavUtil.a(this.s, 2131896043, 1);
    }
    if (!bool) {
      a(this.s, true, "addToQQFavorites", this.a);
    }
  }
  
  public boolean e()
  {
    Bundle localBundle = this.t;
    boolean bool2 = false;
    if ((localBundle.getBoolean("enable_d55", false)) && (aI())) {
      return false;
    }
    boolean bool3 = super.e();
    this.ay = this.r.getBooleanExtra("k_qzone", false);
    boolean bool1 = bool2;
    if (this.ay)
    {
      bool1 = bool2;
      if (this.r.getBooleanExtra("k_send", true)) {
        bool1 = true;
      }
    }
    this.az = bool1;
    if (aJ()) {
      ax();
    } else {
      QLog.d("ForwardOption.ForwardSdkShareOption", 1, "preloadData skip getQQAccountSkey");
    }
    if (bool3) {
      OpenSdkStatic.a().a(0, "SHARE_CHECK_AGENT", this.q.getCurrentAccountUin(), String.valueOf(this.a), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
    }
    try
    {
      this.t.putInt("emoInputType", 1);
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      QLog.e("ForwardOption.ForwardSdkShareOption", 1, "preloadData mExtraData.putInt error : ", localArrayIndexOutOfBoundsException);
    }
    aM();
    b("KEY_STAGE_1_TOTAL", true);
    return bool3;
  }
  
  protected boolean f()
  {
    int j = this.t.getInt("uintype");
    String str3 = this.t.getString("uin");
    aA();
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
      OpenSdkStatic.a().a(0, "SHARE_TO_QQ", this.q.getCurrentAccountUin(), String.valueOf(this.a), String.valueOf(i), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
      label90:
      String str1;
      if (this.ar == 1) {
        str1 = "1";
      } else if (this.ar == 2) {
        str1 = "3";
      } else if (this.ar == 5) {
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
      String str4 = this.q.getAccount();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("");
      ((ReportCenter)localObject).a(str4, "", localStringBuilder.toString(), "10", "12", "0", str1, str3, str2, false, true);
      if ((QSecFramework.c().a(1003).booleanValue()) && (this.F))
      {
        i = this.t.getInt("uintype");
        str1 = this.t.getString("uin");
        str2 = this.t.getString("pkg_name");
        str3 = this.t.getString("detail_url");
        localObject = this.t.getString("image_url");
        if ((!TextUtils.isEmpty(str2)) && (!SecShareInfoUtil.a().b())) {
          SecShareInfoUtil.a().a(null, str2);
        }
        if (this.ar == 1) {
          SecShareInfoUtil.a().a(2, str3, i, str1);
        } else if (this.ar == 5) {
          SecShareInfoUtil.a().a(3, (String)localObject, i, str1);
        }
        SecShareInfoUtil.a().c();
      }
      return true;
    }
    catch (Exception localException)
    {
      break label90;
    }
  }
  
  protected void g()
  {
    AbsStructMsg localAbsStructMsg = StructMsgFactory.a(this.t);
    if (localAbsStructMsg != null) {
      ((DeviceMsgHandle)this.q.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).b().a(this.t.getString("uin"), localAbsStructMsg);
    }
    this.s.finish();
  }
  
  protected int h()
  {
    long l1 = 0L;
    String str2;
    try
    {
      long l2 = Long.valueOf(this.q.getAccount()).longValue();
      l1 = l2;
      String str1 = this.q.getCurrentNickname();
      l1 = l2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str2 = "";
    }
    String str3 = this.t.getString("app_name");
    boolean bool = this.t.getBoolean("key_sdk_share_pure_text");
    int i = -1;
    int k;
    int j;
    if (bool)
    {
      b("ForwardOption.ForwardSdkShareOption", "-->realShareToQfav--pure text share");
      if (TextUtils.isEmpty(this.t.getString("qqfav_extra_richmedia_title")))
      {
        k = i;
        if (TextUtils.isEmpty(this.t.getString("qqfav_extra_mixed_msg"))) {
          j = 1;
        }
      }
    }
    for (;;)
    {
      int m = 0;
      i = j;
      j = m;
      break label734;
      if (TextUtils.isEmpty(this.t.getString("qqfav_extra_richmedia_title"))) {
        this.t.getString("qqfav_extra_mixed_msg");
      } else {
        this.t.getString("qqfav_extra_richmedia_title");
      }
      k = i;
      if (!QfavBuilder.a(null, false, this.t.getString("qqfav_extra_richmedia_title"), this.t.getString("qqfav_extra_mixed_msg"), true, this.a, str3).a(l1, str2).a(this.s, this.q.getAccount(), -1, null, aN() ^ true)) {
        break;
      }
      k = 0;
      break;
      Object localObject;
      if ((this.am instanceof StructMsgForImageShare))
      {
        b("ForwardOption.ForwardSdkShareOption", "-->realShareToQfav--image share");
        localObject = QfavUtil.a((StructMsgForImageShare)this.am);
        k = i;
        if (localObject != null)
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(((StructMsgItemImage)localObject).au);
          k = a(localArrayList);
          if (k == 0)
          {
            k = i;
            if (QfavBuilder.a(localArrayList, true, this.r.getStringExtra("qqfav_extra_richmedia_title"), this.r.getStringExtra("qqfav_extra_mixed_msg"), true, this.a, str3).a(l1, str2).b(this.s, this.q.getAccount(), -1, null)) {
              k = 0;
            }
          }
        }
        i = 3;
        j = 1;
        break label734;
      }
      if (this.r.getBooleanExtra("qqfav_extra_pic_share", false))
      {
        b("ForwardOption.ForwardSdkShareOption", "-->realShareToQfav--extra pic share");
        localObject = this.t.getStringArrayList("qqfav_extra_multi_pic_path_list");
        bool = this.r.getBooleanExtra("qqfav_extra_only_pic", true);
        if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
        {
          j = a((ArrayList)localObject);
          if (j != 0) {
            i = j;
          } else if (QfavBuilder.a((ArrayList)localObject, bool, this.r.getStringExtra("qqfav_extra_richmedia_title"), this.r.getStringExtra("qqfav_extra_mixed_msg"), true, this.a, str3).a(l1, str2).b(this.s, this.q.getAccount(), -1, null)) {
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
        break label734;
      }
      if (this.am != null)
      {
        b("ForwardOption.ForwardSdkShareOption", "-->realShareToQfav--default share");
        localObject = QfavUtil.a(this.am.getXmlBytes());
        if ((this.am instanceof StructMsgForAudioShare))
        {
          j = 10;
          k = 2;
        }
        else
        {
          j = 2;
          k = 0;
        }
        if (QfavBuilder.a(k, this.am.mContentTitle, this.am.mMsgUrl, this.am.mSourceName, this.am.mContentSummary, this.am.mContentCover, this.am.mContentSrc, (byte[])localObject, true, this.a).a(l1, str2).b(this.s, this.q.getAccount(), -1, null))
        {
          i = j;
          j = 0;
          k = 0;
          break label734;
        }
        k = i;
      }
      else
      {
        j = -1;
        k = i;
      }
    }
    label734:
    if (k == 0) {
      QfavReport.a(this.q, "User_AddFav", i, 0, 69, j, "", "");
    }
    return k;
  }
  
  public boolean l()
  {
    return true;
  }
  
  public void m() {}
  
  public String n()
  {
    Object localObject2 = this.u;
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
  
  protected boolean q()
  {
    return this.ay;
  }
  
  public void s()
  {
    super.s();
    if (this.F) {
      SdkShareReporter.a(this.q);
    }
  }
  
  public void v()
  {
    super.v();
    if (K()) {
      ForwardUtils.a(this.q, "0X800A734", new String[] { aQ() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption
 * JD-Core Version:    0.7.0.1
 */