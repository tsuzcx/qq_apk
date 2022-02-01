package com.tencent.mobileqq.forward;

import aasr;
import aaua;
import abgm;
import abku;
import abkw;
import absn;
import admh;
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
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import anvx;
import apyl;
import apyp;
import aupn;
import aupp;
import auql;
import auqn;
import aurk;
import aurn;
import autd;
import autq;
import auts;
import autt;
import autu;
import autv;
import autx;
import auty;
import autz;
import auua;
import auub;
import auuc;
import auui;
import auuv;
import azlb;
import bcpt;
import bcsa;
import bdla;
import bdnu;
import bdny;
import bdof;
import bdqa;
import bdqn;
import bhbx;
import bhch;
import bhdj;
import bizc;
import bjgx;
import bjhd;
import bjme;
import bmad;
import bman;
import bmar;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import ntb;
import nwk;
import nwn;
import nwo;
import nwu;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ImageInfo;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ReqBody;
import weg;

public class ForwardSdkShareOption
  extends ForwardSdkBaseOption
{
  private static final String l;
  private auqn jdField_a_of_type_Auqn = new auts(this);
  private aurn jdField_a_of_type_Aurn = new aurn(this.jdField_a_of_type_AndroidOsBundle);
  protected nwk a;
  @SuppressLint({"HandlerLeak"})
  private Handler b;
  protected QQCustomDialog b;
  private long d;
  private boolean n;
  private boolean o;
  
  static
  {
    jdField_l_of_type_JavaLangString = anvx.a(2131704271);
  }
  
  public ForwardSdkShareOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_d_of_type_Long = -1L;
    this.jdField_b_of_type_AndroidOsHandler = new auty(this);
    this.jdField_a_of_type_Nwk = new auua(this);
  }
  
  private void O()
  {
    if (k())
    {
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
      b(str, this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin"), i);
    }
  }
  
  private void P()
  {
    String str2 = String.valueOf(this.jdField_b_of_type_Long);
    int i = 0;
    label150:
    Object localObject;
    if (!this.jdField_i_of_type_Boolean) {
      if ((!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) && (!this.jdField_i_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->preForward--share uin doesn't equal current uin");
        }
        N();
        if ((i != 0) && (this.o))
        {
          this.jdField_a_of_type_AndroidOsBundle.putString("uin", String.valueOf("-1010"));
          this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", -1);
          this.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", jdField_e_of_type_JavaLangInteger.intValue());
          m();
        }
        i = f();
        if (this.jdField_e_of_type_Int != 5) {
          break label414;
        }
        nwo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "connect_sharepic", "pageview", this.jdField_b_of_type_Long, i, "");
        StatisticCollector.getInstance(BaseApplication.getContext()).reportToAds(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sha_pageview", 1, "", "", str2);
        if (this.jdField_e_of_type_Int != 1) {
          break label435;
        }
        localObject = "1";
      }
    }
    for (;;)
    {
      bjgx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_h_of_type_JavaLangString, str2, "10", "11", "0", (String)localObject, "0", "0", false, true);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A0F", "0X8005A0F", 0, 0, "1", "", "", "");
      return;
      if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(str2);
        if (localObject == null)
        {
          a(2131718796);
          this.jdField_a_of_type_AndroidOsHandler = new Handler();
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ForwardSdkShareOption.6(this), 3000L);
        }
        for (;;)
        {
          try
          {
            long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(l1, this.jdField_h_of_type_JavaLangString, this.jdField_b_of_type_Long, new autz(this));
            i = 0;
          }
          catch (Exception localException)
          {
            i = 0;
            continue;
          }
          if (!this.jdField_h_of_type_JavaLangString.equals(localException.openID))
          {
            if (QLog.isColorLevel()) {
              QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->preForward--openid doesn't equal current local openid");
            }
            N();
            i = 0;
          }
          else
          {
            i = 1;
          }
        }
      }
      i = 1;
      break;
      i = 1;
      break;
      label414:
      nwo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "pageview", this.jdField_b_of_type_Long, i, "");
      break label150;
      label435:
      String str1;
      if (this.jdField_e_of_type_Int == 2) {
        str1 = "3";
      } else if (this.jdField_e_of_type_Int == 5) {
        str1 = "2";
      } else {
        str1 = "4";
      }
    }
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
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (bmar.a(str, -1L))
      {
        if (QLog.isColorLevel()) {
          QLog.i("qqfav", 2, "gotoQfavShareMsg|image type.picture too big [" + str + "]");
        }
        bman.a(null, "Net_AddFav", 8, 3, -3);
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
        break label168;
      }
      paramBundle = paramBundle + "\n";
    }
    label168:
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
    a(paramLong, paramString, this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin"), true);
    ForwardUtils.finishRecentActivity(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  private void a(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean)
  {
    QLog.d("ForwardOption.ForwardSdkShareOption", 1, new Object[] { "-->handleMessage--appid = ", Long.valueOf(paramLong), ", pkgNmae = ", paramString1 });
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", -1);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    localIntent.putExtra("k_from_login", true);
    if (i == 11)
    {
      ForwardUtils.backToThirdAppIntent(this.jdField_a_of_type_AndroidAppActivity, paramString1, localIntent, this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id"));
      paramString1 = this.jdField_a_of_type_AndroidOsBundle.getString("video_url");
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        paramString1 = bdny.a((String)localObject);
        if (!TextUtils.isEmpty(paramString1)) {
          bdla.b(null, "CliOper", "", "", "0X8005F53", "0X8005F53", 0, 0, bdny.a(paramInt) + "", "", paramString1, "");
        }
      }
    }
    paramString1 = Long.toString(System.currentTimeMillis());
    Object localObject = bdof.a(this.jdField_a_of_type_AndroidOsBundle);
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (!(localObject instanceof StructMsgForImageShare)) {
        break label447;
      }
      if ((!auui.a()) || (i != 11)) {
        break label423;
      }
      localIntent.putExtra("key_share_image_by_server", paramString1);
      paramString3 = ForwardUtils.toType(paramInt);
      String str = ((AbsShareMsg)localObject).mContentTitle;
      bdla.b(null, "dc00898", "", "", "0X8009C93", "0X8009C93", 0, 0, String.valueOf(paramLong), "4", paramString3, str);
      QLog.d("ForwardOption.ForwardSdkShareOption", 1, new Object[] { "分享大图=0X8009C93, fileType=4 + , toType=", paramString3 });
      ThreadManager.post(new ForwardSdkShareOption.2(this, (AbsStructMsg)localObject, paramString2, paramInt, paramString3, paramString1, str), 8, null, false);
      localIntent.putExtra("stuctmsg_bytes", ((AbsStructMsg)localObject).getBytes());
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("share_from_aio", false)) {
        break label522;
      }
      paramString1 = AIOUtils.setOpenAIOIntent(localIntent, new int[] { 2 });
      this.jdField_a_of_type_AndroidOsBundle.remove("share_from_aio");
    }
    for (;;)
    {
      paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
      }
      return;
      label423:
      ThreadManager.post(new ForwardSdkShareOption.3(this, (AbsStructMsg)localObject, paramString2, paramInt), 8, null, false);
      break;
      label447:
      if (i == 11)
      {
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("share_send_msg_by_server", true);
        localIntent.putExtra("key_b77_sdk_share", paramString1);
        new autd().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (AbsShareMsg)localObject, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, paramString1);
        break;
      }
      a((AbsStructMsg)localObject, paramString2, paramInt, paramString3);
      break;
      label522:
      paramString1 = AIOUtils.setOpenAIOIntent(localIntent, null);
      paramString1.putExtra("share_from_aio", true);
    }
  }
  
  private void a(Bundle paramBundle, azlb paramazlb, String paramString1, String paramString2, String paramString3)
  {
    Object localObject;
    if ((paramazlb.jdField_a_of_type_JavaLangObject instanceof int[]))
    {
      int[] arrayOfInt = (int[])paramazlb.jdField_a_of_type_JavaLangObject;
      if (arrayOfInt.length == 5)
      {
        localObject = new oidb_cmd0xb77.ImageInfo();
        ((oidb_cmd0xb77.ImageInfo)localObject).md5.set(paramazlb.d);
        ((oidb_cmd0xb77.ImageInfo)localObject).uuid.set(paramazlb.c);
        ((oidb_cmd0xb77.ImageInfo)localObject).file_size.set(arrayOfInt[0]);
        ((oidb_cmd0xb77.ImageInfo)localObject).img_type.set(arrayOfInt[1]);
        ((oidb_cmd0xb77.ImageInfo)localObject).width.set(arrayOfInt[2]);
        ((oidb_cmd0xb77.ImageInfo)localObject).height.set(arrayOfInt[3]);
        ((oidb_cmd0xb77.ImageInfo)localObject).original.set(arrayOfInt[4]);
        ((oidb_cmd0xb77.ImageInfo)localObject).file_id.set((int)paramazlb.jdField_b_of_type_Long);
      }
    }
    for (paramazlb = (azlb)localObject;; paramazlb = null)
    {
      paramBundle = auui.a(paramBundle, null, null, paramazlb);
      paramazlb = BaseApplicationImpl.getApplication().getRuntime();
      if (paramazlb == null)
      {
        QLog.e("ForwardOption.ForwardSdkShareOption", 1, "send runtime = null ");
        b(jdField_l_of_type_JavaLangString, paramString2);
        return;
      }
      localObject = new Bundle();
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      ((Bundle)localObject).putLong("0xb77_9_sendTime", this.jdField_d_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardSdkShareOption", 2, "sendOIDBRequest ");
      }
      auuv.a("KEY_STAGE_2_IMAGE_B77");
      ntb.a(paramazlb, new autx(this, paramString2, paramString1, paramString3), paramBundle.toByteArray(), "OidbSvc.0xb77_9", 2935, 9, (Bundle)localObject, 0L);
      return;
    }
  }
  
  private boolean a(AbsStructMsg paramAbsStructMsg)
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
        bdnu localbdnu = (bdnu)paramAbsStructMsg.get(i);
        if (!(localbdnu instanceof bdqn)) {
          break label95;
        }
        paramAbsStructMsg = (bdqn)localbdnu;
        bool1 = bool2;
        if (paramAbsStructMsg.o != 1)
        {
          bool1 = bool2;
          if (paramAbsStructMsg.o != 3) {
            bool1 = true;
          }
        }
      }
      return bool1;
      label95:
      i += 1;
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_notify_aio_activity");
    localIntent.putExtra("key_share_image_by_server", paramString2);
    this.jdField_a_of_type_AndroidAppActivity.sendBroadcast(localIntent);
    aurk.a().a(paramString2, paramString1);
  }
  
  private String f()
  {
    List localList = a();
    if (localList != null) {}
    for (int i = localList.size();; i = 0) {
      return Integer.toString(i);
    }
  }
  
  private boolean v()
  {
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
    auql localauql = ((auuc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SDK_SHARE)).a();
    if (localauql.b())
    {
      QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> isForbid");
      a(localauql.a(), true);
      return true;
    }
    if (localauql.c())
    {
      QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> usedCachedAppInfo");
      this.jdField_a_of_type_Aupn = localauql.a(this.jdField_b_of_type_Long);
      return false;
    }
    if (localauql.a())
    {
      QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> hasValidAppInfo");
      this.jdField_a_of_type_Aupn = localauql.a();
      e();
      return false;
    }
    QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> waiting d55 back");
    localauql.a(this.jdField_a_of_type_Auqn);
    a(2131718186);
    return true;
  }
  
  private boolean w()
  {
    if (this.jdField_e_of_type_Int == 5) {
      return !auui.a();
    }
    return TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote"));
  }
  
  private boolean x()
  {
    return !this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_mini_program_ark_from_sdk");
  }
  
  private boolean y()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      bool = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("mobileQQ", 0).getBoolean("favorites_first_share_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), true);
    }
    return bool;
  }
  
  public void A()
  {
    AbsStructMsg localAbsStructMsg = bdof.a(this.jdField_a_of_type_AndroidOsBundle);
    if (localAbsStructMsg != null) {
      ((abkw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), localAbsStructMsg);
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void B() {}
  
  public void L()
  {
    QQAppInterface localQQAppInterface;
    if ((i()) && (this.jdField_c_of_type_Boolean))
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (b() != null) {
        break label52;
      }
    }
    label52:
    for (int i = 0;; i = b().size())
    {
      ForwardUtils.report(localQQAppInterface, "0X800A739", new String[] { Integer.toString(i) });
      return;
    }
  }
  
  void M()
  {
    super.M();
    if ((i()) && (this.jdField_c_of_type_Boolean)) {
      ForwardUtils.finishRecentActivity(this.jdField_a_of_type_AndroidAppActivity);
    }
  }
  
  public void N()
  {
    QLog.d("ForwardOption.ForwardSdkShareOption", 1, "showAccountConfirm");
    StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", "multi_account", "push_login_window", 0, 1, 0);
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      if (!this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
    }
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      QLog.d("ForwardOption.ForwardSdkShareOption", 1, "showAccountConfirm-->(mActivity == null || mActivity.isFinishing())");
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131694975);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131692056);
    auub localauub = new auub(this);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690697, localauub);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131718634, localauub);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) || (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_system_share", false))) {
      return 2131690697;
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
      if (nwn.a(str2, "UTF-8") > 105) {
        str1 = nwn.a(str2, 105, "UTF-8", "...");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardSdkShareOption", 2, "DialogContent:mForwardText=" + str1);
    }
    return str1;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!bhbx.a(localRecentUser.uin)) && (localRecentUser.getType() != 1020) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 1001) && (localRecentUser.getType() != 10002) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 1022) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && ((localRecentUser.getType() != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.getType() != 1006) || (a(aupp.jdField_h_of_type_JavaLangInteger))) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 0) || (!nwu.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.jdField_b_of_type_Boolean))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (o()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_d_of_type_JavaLangInteger);
    }
    if (p()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_c_of_type_JavaLangInteger);
    }
    if (q()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (n()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_h_of_type_JavaLangInteger);
    }
    if (e()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_e_of_type_JavaLangInteger);
    }
    if (x())
    {
      this.jdField_a_of_type_JavaUtilSet.add(f);
      this.jdField_a_of_type_JavaUtilSet.add(k);
    }
    j();
    if (super.r()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_j_of_type_JavaLangInteger);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("detail_url"))) {
      this.jdField_a_of_type_JavaUtilSet.add(m);
    }
  }
  
  public void a(Intent paramIntent, Bundle paramBundle, String paramString)
  {
    Object localObject;
    if (this.jdField_a_of_type_Aupn != null)
    {
      if (this.jdField_a_of_type_Aupn.b() == null)
      {
        localObject = "";
        paramBundle.putString("struct_share_key_source_url", (String)localObject);
        if (this.jdField_a_of_type_Aupn.a() != null) {
          break label300;
        }
        localObject = "";
        label44:
        paramBundle.putString("struct_share_key_source_icon", (String)localObject);
        if (this.jdField_a_of_type_Aupn.c() != null) {
          break label312;
        }
        localObject = "";
        label67:
        paramBundle.putString("struct_share_key_source_name", (String)localObject);
        if (this.jdField_a_of_type_Aupn.d() != null) {
          break label324;
        }
        localObject = "";
        label90:
        paramBundle.putString("struct_share_key_source_a_action_data", (String)localObject);
      }
    }
    else
    {
      localObject = new Intent();
      ((Intent)localObject).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(this.jdField_b_of_type_Long), "shareToQQ" })));
      ((Intent)localObject).setPackage(paramString);
      paramIntent.putExtra("activity_finish_run_pendingIntent", PendingIntent.getActivity(this.jdField_a_of_type_AndroidAppActivity, 0, (Intent)localObject, 268435456));
      if (((this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity)) && (!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity))) {
        ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).setTitle(null);
      }
      paramIntent.setFlags(67108864);
      paramIntent.addFlags(268435456);
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity)) {
        break label336;
      }
      paramBundle.putBoolean("MigSdkShareNotDone", false);
      paramBundle.putBoolean("isMigSdkShare", true);
      paramString = (LiteActivity)this.jdField_a_of_type_AndroidAppActivity;
      paramIntent.putExtras(paramBundle);
      paramString.e(paramIntent);
    }
    for (;;)
    {
      paramIntent = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      if (!TextUtils.isEmpty(paramIntent)) {
        a(paramBundle, paramIntent, null);
      }
      return;
      localObject = this.jdField_a_of_type_Aupn.b();
      break;
      label300:
      localObject = this.jdField_a_of_type_Aupn.a();
      break label44;
      label312:
      localObject = this.jdField_a_of_type_Aupn.c();
      break label67;
      label324:
      localObject = this.jdField_a_of_type_Aupn.d();
      break label90;
      label336:
      paramIntent.putExtras(paramBundle);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramIntent);
      a(0, "", "");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super.a(paramQQAppInterface, paramActivity);
    this.jdField_a_of_type_Aurn.a(paramQQAppInterface, paramActivity);
  }
  
  public void a(boolean paramBoolean)
  {
    a(this.jdField_a_of_type_AndroidAppActivity, paramBoolean, "shareToQQ", this.jdField_b_of_type_Long);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_AndroidOsBundle.getBoolean("enable_d55", false)) && (v())) {
      return false;
    }
    boolean bool2 = super.a();
    this.n = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_qzone", false);
    boolean bool1;
    if ((this.n) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_send", true))) {
      bool1 = true;
    }
    for (;;)
    {
      this.o = bool1;
      if (w())
      {
        J();
        if (bool2) {
          bjme.a().a(0, "SHARE_CHECK_AGENT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(this.jdField_b_of_type_Long), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
        }
      }
      try
      {
        this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 1);
        P();
        b("KEY_STAGE_1_TOTAL", true);
        return bool2;
        bool1 = false;
        continue;
        QLog.d("ForwardOption.ForwardSdkShareOption", 1, "preloadData skip getQQAccountSkey");
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        for (;;)
        {
          QLog.e("ForwardOption.ForwardSdkShareOption", 1, "preloadData mExtraData.putInt error : ", localArrayIndexOutOfBoundsException);
        }
      }
    }
  }
  
  protected boolean a(AbsStructMsg paramAbsStructMsg, String paramString1, int paramInt, String paramString2)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.curType = paramInt;
    localSessionInfo.curFriendUin = paramString1;
    localSessionInfo.troopUin = paramString2;
    if ((localSessionInfo.curType < 0) || (TextUtils.isEmpty(localSessionInfo.curFriendUin)))
    {
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
        bjgx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false, true);
      }
      return false;
    }
    paramString1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_name");
    paramString2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_view");
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_desc");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_ver");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_prompt");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_meta");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_config");
    String str4 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_compat");
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
        bjgx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false, true);
      }
      return false;
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
      bjgx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "0", false, true);
    }
    localObject1 = new ArkAppMessage(str1, paramString1, (String)localObject1, paramString2, (String)localObject2, str2, str3, str4);
    paramString1 = (ArkAppMessage)apyl.a(2, paramString1, this.jdField_a_of_type_AndroidOsBundle, localObject1);
    if (paramString1 == null) {
      paramString1 = (String)localObject1;
    }
    for (;;)
    {
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
      if (paramAbsStructMsg != null) {
        switch (localSessionInfo.curType)
        {
        }
      }
      for (paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; paramString2 = localSessionInfo.troopUin)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        str2 = localSessionInfo.curFriendUin;
        paramInt = localSessionInfo.curType;
        int i = bcpt.a;
        bcpt.a = i + 1;
        paramString1.containStructMsg = bcsa.a((QQAppInterface)localObject2, str1, str2, paramString2, paramInt, i, paramAbsStructMsg);
        if ((!TextUtils.isEmpty(((ArkAppMessage)localObject1).appName)) && (!TextUtils.isEmpty(((ArkAppMessage)localObject1).appView)) && (!TextUtils.isEmpty(((ArkAppMessage)localObject1).metaList))) {
          apyp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ArkAppMessage)localObject1).appName, "AIOArkSdkSendMessage", 1, 0, 0L, 0L, 0L, ((ArkAppMessage)localObject1).appView, "");
        }
        admh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, paramString1);
        return true;
      }
    }
  }
  
  public boolean a(QQCustomDialog paramQQCustomDialog)
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
      localObject = bdof.a((Bundle)localObject);
      if (!AbsShareMsg.class.isInstance(localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ForwardOption.ForwardSdkShareOption", 2, "-->preloadData--structMsg is not an instance of AbsShareMsg");
        }
        a(-1, anvx.a(2131704268), anvx.a(2131704295));
      }
    }
    try
    {
      bjme.a().a(1, "SHARE_CHECK_AGENT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(this.jdField_b_of_type_Long), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "类型错误");
      label145:
      return false;
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject);
      boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg);
      if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_sdk_share_pure_text"))
      {
        localObject = new LinearLayout.LayoutParams(-1, -2);
        if (!(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForGeneralShare)) {
          break label400;
        }
        if (bool) {
          break label357;
        }
        ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.dp2px(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.dp2px(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.dp2px(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardSdkShareOption", 2, "updateImageView addStructView");
        }
        this.jdField_a_of_type_Autq = new autq(this, this.jdField_a_of_type_AndroidAppActivity);
        if (((this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_ark_display_share")) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_from_sdk"))) || (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_mini_program_ark_from_sdk"))) {
          break label490;
        }
        paramQQCustomDialog.addView(this.jdField_a_of_type_Autq.a(), (LinearLayout.LayoutParams)localObject);
        if ((!(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare)) && (!bool)) {
          a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, paramQQCustomDialog);
        }
      }
      for (;;)
      {
        return true;
        label357:
        ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
        if ((this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_ark_display_share")) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_from_sdk"))) {
          break;
        }
        paramQQCustomDialog.adjustMessageTopBottomMargin(0.0F, 0.0F);
        break;
        label400:
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare))
        {
          ((LinearLayout.LayoutParams)localObject).setMargins(0, AIOUtils.dp2px(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.dp2px(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          break;
        }
        if (!(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare)) {
          break;
        }
        ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.dp2px(-10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.dp2px(-7.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
        break;
        label490:
        if (this.jdField_a_of_type_AndroidOsBundle.getInt("req_type") == 5)
        {
          paramQQCustomDialog.addView(this.jdField_a_of_type_Autq.a(), (LinearLayout.LayoutParams)localObject);
          if ((!(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare)) && (!bool)) {
            a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, paramQQCustomDialog);
          }
        }
      }
    }
    catch (Exception paramQQCustomDialog)
    {
      break label145;
    }
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (abgm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    localObject = new absn();
    int j = paramArrayOfDeviceInfo.length;
    int i = 0;
    while (i < j)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      if (localDeviceInfo != null)
      {
        LightAppSettingInfo localLightAppSettingInfo = ((absn)localObject).a(localDeviceInfo);
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
      return 2131697804;
    }
    return super.b();
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
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity)) {
        break label834;
      }
      switch (this.jdField_a_of_type_AndroidOsBundle.getInt("req_type"))
      {
      case 3: 
      case 4: 
      default: 
        localIntent.putExtra("dataline_forward_type", 102);
        localIntent.putExtra("dataline_forward_text", anvx.a(2131704273));
      }
    }
    for (;;)
    {
      localObject = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
      ((Bundle)localObject).putBoolean("isBack2Root", false);
      ((Bundle)localObject).putBoolean("is_share_flag", true);
      ((Bundle)localObject).putLong("res_share_id", bhch.a(this.jdField_b_of_type_Long));
      ((Bundle)localObject).putString("res_pkg_name", str3);
      ((Bundle)localObject).putString("res_detail_url", str1);
      ((Bundle)localObject).putString("app_name", str4);
      ((Bundle)localObject).putString("image_url_remote", str2);
      ((Bundle)localObject).putString("image_url", str6);
      if (!TextUtils.isEmpty(str5)) {
        ((Bundle)localObject).putString("audio_url", str5);
      }
      a(localIntent, (Bundle)localObject, str3);
      return;
      localIntent.putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
      localIntent.putExtra("device_type", 0);
      break;
      if (bool2)
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
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004931", "0X8004931", 0, 0, "", "", "", "");
        a("qqdataline", "shareFromMigSdk|report send text:0X8004931.");
        continue;
        localIntent.putExtra("dataline_forward_type", 101);
        QLog.d("ForwardOption.ForwardSdkShareOption", 1, "forwardToDataline 1 filePath: " + str6);
        localIntent.putExtra("dataline_forward_path", str6);
        continue;
        localObject = a(this.jdField_a_of_type_AndroidOsBundle, str5);
        localIntent.putExtra("dataline_forward_type", 102);
        localIntent.putExtra("dataline_forward_text", (String)localObject);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
        a("qqdataline", "shareFromMigSdk|report send link:0X800492E.");
        continue;
        if (bool1)
        {
          localIntent.putExtra("dataline_forward_type", 101);
          if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
          {
            localIntent.putExtra("dataline_forward_path", (String)localObject);
            QLog.d("ForwardOption.ForwardSdkShareOption", 1, "forwardToDataline 2 filePath: " + (String)localObject);
          }
          else
          {
            localIntent.putExtra("dataline_forward_path", str6);
            QLog.d("ForwardOption.ForwardSdkShareOption", 1, "forwardToDataline 3 filePath: " + str6);
          }
        }
        else
        {
          localObject = a(this.jdField_a_of_type_AndroidOsBundle, str1);
          localIntent.putExtra("dataline_forward_type", 102);
          localIntent.putExtra("dataline_forward_text", (String)localObject);
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
          a("qqdataline", "shareFromMigSdk|report send link:0X800492E.");
          continue;
          label834:
          if (this.jdField_a_of_type_AndroidOsBundle.getInt("req_type") != 5) {
            break label873;
          }
          localIntent.putExtra("dataline_forward_type", 101);
          localIntent.putExtra("dataline_forward_path", str6);
        }
      }
    }
    label873:
    if (TextUtils.isEmpty(str1))
    {
      if (HttpUtil.isValidUrl(str2)) {
        break label929;
      }
      localObject = anvx.a(2131704265);
    }
    for (;;)
    {
      localIntent.putExtra("dataline_forward_type", 102);
      localIntent.putExtra("dataline_forward_text", (String)localObject);
      break;
      localObject = str1;
      continue;
      label929:
      localObject = str2;
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public int c()
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
    if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) || (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_system_share", false))) {
      return this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131697786);
    }
    if (this.jdField_b_of_type_Long == 55901189L) {
      return null;
    }
    return super.c();
  }
  
  public void c() {}
  
  public boolean c()
  {
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    K();
    int i;
    switch (j)
    {
    default: 
      i = 1;
    }
    try
    {
      bjme.a().a(0, "SHARE_TO_QQ", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(this.jdField_b_of_type_Long), String.valueOf(i), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
      label99:
      String str1;
      label110:
      String str2;
      label122:
      String str4;
      if (this.jdField_e_of_type_Int == 1)
      {
        str1 = "1";
        str2 = "1";
        if (j != 0) {
          break label356;
        }
        str2 = "1";
        bjgx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", this.jdField_b_of_type_Long + "", "10", "12", "0", str1, str3, str2, false, true);
        if ((QSecFramework.a().a(1003).booleanValue()) && (this.jdField_c_of_type_Boolean))
        {
          i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
          str1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
          str2 = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
          str3 = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
          str4 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
          if ((!TextUtils.isEmpty(str2)) && (!bizc.a().a())) {
            bizc.a().a(null, str2);
          }
          if (this.jdField_e_of_type_Int != 1) {
            break label384;
          }
          bizc.a().a(2, str3, i, str1);
        }
      }
      for (;;)
      {
        bizc.a().a();
        return true;
        i = 1;
        break;
        i = 2;
        break;
        i = 3;
        break;
        if (this.jdField_e_of_type_Int == 2)
        {
          str1 = "3";
          break label110;
        }
        if (this.jdField_e_of_type_Int == 5)
        {
          str1 = "2";
          break label110;
        }
        str1 = "4";
        break label110;
        label356:
        if (1 == j)
        {
          str2 = "2";
          break label122;
        }
        if (3000 != j) {
          break label122;
        }
        str2 = "3";
        break label122;
        label384:
        if (this.jdField_e_of_type_Int == 5) {
          bizc.a().a(3, str4, i, str1);
        }
      }
    }
    catch (Exception localException)
    {
      break label99;
    }
  }
  
  public int d()
  {
    k = -1;
    l1 = 0L;
    try
    {
      l2 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).longValue();
      l1 = l2;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        int m;
        localException.printStackTrace();
        String str = "";
        long l2 = l1;
        continue;
        this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title");
        continue;
        boolean bool = false;
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare))
        {
          a("ForwardOption.ForwardSdkShareOption", "-->realShareToQfav--image share");
          localObject3 = bmar.a((StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg);
          m = k;
          ArrayList localArrayList;
          if (localObject3 != null)
          {
            localArrayList = new ArrayList();
            localArrayList.add(((bdqa)localObject3).ac);
            m = a(localArrayList);
            if (m == 0) {
              break label367;
            }
          }
          for (;;)
          {
            j = 1;
            i = 3;
            k = m;
            break;
            m = k;
            if (bmad.a(localArrayList, true, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("qqfav_extra_richmedia_title"), this.jdField_a_of_type_AndroidContentIntent.getStringExtra("qqfav_extra_mixed_msg"), true, this.jdField_b_of_type_Long, (String)localObject2).a(l2, str).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
              m = 0;
            }
          }
        }
        if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_pic_share", false))
        {
          a("ForwardOption.ForwardSdkShareOption", "-->realShareToQfav--extra pic share");
          j = 8;
          localObject3 = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("qqfav_extra_multi_pic_path_list");
          bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_only_pic", true);
          if ((localObject3 == null) || (((ArrayList)localObject3).isEmpty())) {
            break label755;
          }
          i = a((ArrayList)localObject3);
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
            if (1 == ((ArrayList)localObject3).size()) {
              i = 3;
            }
          }
          for (j = ((ArrayList)localObject3).size();; j = 0)
          {
            break;
            if (!bmad.a((ArrayList)localObject3, bool, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("qqfav_extra_richmedia_title"), this.jdField_a_of_type_AndroidContentIntent.getStringExtra("qqfav_extra_mixed_msg"), true, this.jdField_b_of_type_Long, (String)localObject2).a(l2, str).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
              break label761;
            }
            k = 0;
            break label512;
            if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
            {
              a("ForwardOption.ForwardSdkShareOption", "-->realShareToQfav--default share");
              i = 2;
              localObject2 = bmar.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getXmlBytes());
              m = 0;
              if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare))
              {
                m = 2;
                i = 10;
              }
              j = i;
              if (bmad.a(m, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentTitle, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentSummary, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentCover, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentSrc, (byte[])localObject2, true, this.jdField_b_of_type_Long).a(l2, str).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null))
              {
                k = 0;
                j = 0;
                break;
              }
            }
            m = 0;
            i = j;
            j = m;
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
    localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
    j = -1;
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_sdk_share_pure_text"))
    {
      a("ForwardOption.ForwardSdkShareOption", "-->realShareToQfav--pure text share");
      if ((TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title"))) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_mixed_msg")))) {
        break label768;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title")))
      {
        this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_mixed_msg");
        localObject1 = bmad.a(null, false, this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title"), this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_mixed_msg"), true, this.jdField_b_of_type_Long, (String)localObject2).a(l2, (String)localObject1);
        localObject2 = this.jdField_a_of_type_AndroidAppActivity;
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        if (y()) {
          break label279;
        }
        bool = true;
        if (!((bmad)localObject1).a((Activity)localObject2, (String)localObject3, -1, null, bool)) {
          break label763;
        }
        i = 0;
        j = 0;
        m = 1;
        k = i;
        i = m;
        if (k == 0) {
          bman.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", i, 0, 69, j, "", "");
        }
        return k;
      }
    }
  }
  
  public void d()
  {
    G();
    auuv.a("KEY_STAGE_2_TOTAL");
    long l1 = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
    this.jdField_a_of_type_AndroidOsBundle.putLong("res_share_id", l1);
    this.jdField_a_of_type_AndroidOsBundle.putString("res_pkg_name", str);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue();
    this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message_for_server", (String)localObject2);
    this.jdField_a_of_type_AndroidOsBundle.putString("share_msg_input_value", (String)localObject2);
    this.jdField_a_of_type_AndroidOsBundle.putString("res_detail_url", (String)localObject1);
    boolean bool = bdof.a(this.jdField_a_of_type_AndroidOsBundle) instanceof StructMsgForImageShare;
    if (bool)
    {
      this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue());
      this.jdField_a_of_type_AndroidContentIntent.putExtra("req_type", 147);
    }
    int i;
    label247:
    int j;
    if (i()) {
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = "2";
        ForwardUtils.report(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800A735", new String[] { f(), localObject1 });
        if (this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", -1) != 11) {
          break label353;
        }
        if ((!bool) || (!auui.a())) {
          break label325;
        }
        i = 1;
        if (bool) {
          break label330;
        }
        j = 1;
        label254:
        if ((i == 0) && (j == 0)) {
          break label335;
        }
        this.jdField_a_of_type_Aurn.a(b());
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_mini_program_ark_from_sdk", false)) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F7B", "0X8009F7B", 0, 0, "1", "", "", "");
      }
      return;
      localObject1 = "1";
      break;
      label325:
      i = 0;
      break label247;
      label330:
      j = 0;
      break label254;
      label335:
      this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue();
      super.d();
      continue;
      label353:
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_from_sdk"))
      {
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("forward_multi_target").iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ResultRecord)((Iterator)localObject1).next();
          if (k()) {
            b(((ResultRecord)localObject2).uin, ((ResultRecord)localObject2).groupUin, ((ResultRecord)localObject2).getUinType());
          }
          a(l1, str, ((ResultRecord)localObject2).uin, ((ResultRecord)localObject2).getUinType(), ((ResultRecord)localObject2).groupUin, false);
        }
      }
      else
      {
        this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue();
        super.d();
        continue;
        if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_from_sdk"))
        {
          O();
          a(l1, str);
        }
        else
        {
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
          if (this.jdField_d_of_type_Boolean)
          {
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
            this.jdField_d_of_type_Boolean = false;
          }
          this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue();
          super.x();
          if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_mini_program_ark_from_sdk")) {
            O();
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("report_type", "102");
          ((Bundle)localObject1).putString("act_type", "82");
          ((Bundle)localObject1).putString("intext_1", "" + bjhd.a(this.jdField_e_of_type_Int));
          ((Bundle)localObject1).putString("intext_2", "" + bjhd.a(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.jdField_a_of_type_AndroidOsBundle.getString("uin")));
          ((Bundle)localObject1).putString("intext_3", "0");
          bjgx.a().a((Bundle)localObject1, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false, true);
        }
      }
    }
  }
  
  public void d(int paramInt)
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
          bmar.a(this.jdField_a_of_type_AndroidAppActivity, 2131697886, 2);
        }
      }
      while (!bool)
      {
        a(this.jdField_a_of_type_AndroidAppActivity, true, "addToQQFavorites", this.jdField_b_of_type_Long);
        return;
        ((SharedPreferences)localObject).edit().putBoolean(str, false).commit();
        localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131697885);
        str = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
        StringBuilder localStringBuilder = new StringBuilder().append((String)localObject);
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131697877);
        }
        localObject = (String)localObject;
        localObject = bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718788), this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131697879), (String)localObject, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131694451), new autt(this), new autu(this));
        ((QQCustomDialog)localObject).setOnDismissListener(new autv(this));
        if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(null);
          ((QQCustomDialog)localObject).show();
          continue;
          if (2 == paramInt) {
            bmar.a(this.jdField_a_of_type_AndroidAppActivity, 2131694687, 1);
          } else if (3 == paramInt) {
            bmar.a(this.jdField_a_of_type_AndroidAppActivity, 2131697884, 1);
          } else {
            bmar.a(this.jdField_a_of_type_AndroidAppActivity, 2131697878, 1);
          }
        }
      }
    }
  }
  
  public void e(String paramString)
  {
    Object localObject = new Intent();
    ((Intent)localObject).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(this.jdField_b_of_type_Long), "shareToQQ" })));
    ((Intent)localObject).setPackage(this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name"));
    localObject = PendingIntent.getActivity(this.jdField_a_of_type_AndroidAppActivity, 0, (Intent)localObject, 268435456);
    Intent localIntent = new Intent();
    localIntent.putExtra("activity_finish_run_pendingIntent", (Parcelable)localObject);
    localIntent.putExtra("is_from_share", true);
    localIntent.putExtra("struct_share_key_source_name", this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_name"));
    if (weg.a())
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
  
  public boolean e()
  {
    return this.n;
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
    if (i()) {
      ForwardUtils.report(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800A734", new String[] { f() });
    }
  }
  
  public boolean k()
  {
    return false;
  }
  
  public boolean m()
  {
    return false;
  }
  
  public void s()
  {
    super.s();
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("shareArkInfo");
    if (!TextUtils.isEmpty(str1)) {}
    try
    {
      Object localObject = new JSONObject(str1);
      str1 = ((JSONObject)localObject).optString("app");
      String str2 = ((JSONObject)localObject).optString("view");
      localObject = ((JSONObject)localObject).optString("meta");
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        apyp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, "AIOArkSdkSendClosed", 1, 0, 0L, 0L, 0L, str2, "");
      }
      label95:
      if (i()) {
        ForwardUtils.report(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800A736", new String[] { f() });
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_mini_program_ark_from_sdk", false)) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F7B", "0X8009F7B", 0, 0, "2", "", "", "");
      }
      if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) || (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_system_share", false))) {
        a(this.jdField_a_of_type_AndroidAppActivity, false, "addToQQFavorites", this.jdField_b_of_type_Long);
      }
      do
      {
        return;
        super.s();
      } while ((!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity)) || (this.jdField_b_of_type_Long == 0L));
      a(this.jdField_a_of_type_AndroidAppActivity, false, "sendToMyComputer", this.jdField_b_of_type_Long);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label95;
    }
  }
  
  protected boolean u()
  {
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_l_of_type_Boolean)
        {
          QLog.d("ForwardOption.ForwardSdkShareOption", 1, "-->sdk_share, checkAppinfoLocked, getappinfo already executing...");
          try
          {
            jdField_a_of_type_JavaLangObject.wait(20000L);
            if (this.jdField_a_of_type_Aupn == null) {
              QLog.d("ForwardOption.ForwardSdkShareOption", 1, "-->sdk_share, response is null.");
            }
            return true;
          }
          catch (InterruptedException localInterruptedException1)
          {
            QLog.e("ForwardOption.ForwardSdkShareOption", 1, "check app info locked ex", localInterruptedException1);
            continue;
          }
        }
      }
      if (this.jdField_a_of_type_Aupn == null)
      {
        this.jdField_l_of_type_Boolean = true;
        long l1 = System.currentTimeMillis() / 1000L;
        String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
        String str2 = AgentActivity.a(this.jdField_a_of_type_AndroidAppActivity, str1, l1 + "");
        QLog.d("ForwardOption.ForwardSdkShareOption", 1, "-->sdk_share, checkAppinfoLocked, sign: " + str2 + ", appinfo is null.");
        auuv.a("KEY_GET_APP_INFO");
        aasr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long, str2, l1, this.jdField_a_of_type_MqqObserverBusinessObserver, str1);
        try
        {
          jdField_a_of_type_JavaLangObject.wait(20000L);
        }
        catch (InterruptedException localInterruptedException2)
        {
          QLog.e("ForwardOption.ForwardSdkShareOption", 1, "check app info locked ex", localInterruptedException2);
        }
      }
    }
  }
  
  public void y()
  {
    super.y();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Nwk);
    if ((this.jdField_a_of_type_Aaua != null) && (this.jdField_a_of_type_Aaua.isShowing())) {
      this.jdField_a_of_type_Aaua.dismiss();
    }
    if ((this.jdField_b_of_type_Aaua != null) && (this.jdField_b_of_type_Aaua.isShowing())) {
      this.jdField_b_of_type_Aaua.dismiss();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption
 * JD-Core Version:    0.7.0.1
 */