package com.tencent.mobileqq.forward;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.biz.widgets.ShareResultDialog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.hiboom.HiBoomConstants;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.share.api.IShareReport;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.RegionalThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;
import com.tencent.mobileqq.utils.QQCustomDialogWtihForwardAvatar;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.writetogether.api.IWriteTogetherOidbHandler;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import eipc.EIPCClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ForwardBaseOption
  implements DialogInterface.OnDismissListener, ForwardAbility, ForwardAbility.ForwardAbilityType, ForwardConstants, ForwardDialogBuilder
{
  static int jdField_a_of_type_Int = 0;
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  public static String e = "key_thumb_style_centerinside";
  float jdField_a_of_type_Float;
  protected long a;
  protected Activity a;
  protected Context a;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  protected Intent a;
  protected Bundle a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ShareAioResultDialog jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
  protected ShareResultDialog a;
  protected QQAppInterface a;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver = new ForwardBaseOption.15(this);
  protected QQCustomDialog a;
  protected QQProgressDialog a;
  protected String a;
  private ArrayList<ResultRecord> jdField_a_of_type_JavaUtilArrayList;
  protected List<ForwardBaseOption.EventListener> a;
  protected Set<Integer> a;
  boolean jdField_a_of_type_Boolean;
  private boolean[] jdField_a_of_type_ArrayOfBoolean;
  protected int b;
  DialogInterface.OnClickListener jdField_b_of_type_AndroidContentDialogInterface$OnClickListener;
  protected QQProgressDialog b;
  String jdField_b_of_type_JavaLangString;
  protected ArrayList<ResultRecord> b;
  protected boolean b;
  protected int c;
  DialogInterface.OnClickListener jdField_c_of_type_AndroidContentDialogInterface$OnClickListener;
  private QQProgressDialog jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  String jdField_c_of_type_JavaLangString;
  private ArrayList<ResultRecord> jdField_c_of_type_JavaUtilArrayList;
  protected boolean c;
  protected int d;
  String d;
  public boolean d;
  boolean e;
  protected String f;
  boolean f;
  protected boolean g;
  protected boolean h;
  protected boolean i;
  
  public ForwardBaseOption(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 11;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    if (paramIntent.getExtras() != null) {
      paramIntent = paramIntent.getExtras();
    } else {
      paramIntent = new Bundle();
    }
    this.jdField_a_of_type_AndroidOsBundle = paramIntent;
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication().getApplicationContext();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void I()
  {
    o();
    if ((this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_ark_display_share")) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_from_h5_parse_meta_success")))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtils.a(this.jdField_a_of_type_AndroidAppActivity, c(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427342));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage("");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690728, b());
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131690820, a());
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtils.a(this.jdField_a_of_type_AndroidAppActivity, c(), a(), null, a(), b());
  }
  
  private void J()
  {
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type");
    if ((j != 27) && (j != 39) && (j != 46))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, c(), a(), d(), a(), b(), a(), b());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtils.a(this.jdField_a_of_type_AndroidAppActivity, c(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427342));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage("");
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690728, b());
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131690820, a());
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void K()
  {
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
    if ((j == jdField_g_of_type_JavaLangInteger.intValue()) || (j == j.intValue()) || (j == m.intValue()) || (j == jdField_e_of_type_JavaLangInteger.intValue())) {
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("is_ark_display_share", false);
    }
  }
  
  private void L()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity;
    if ((localObject1 != null) && (!((Activity)localObject1).isFinishing()))
    {
      if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog == null) {
        this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = new ShareAioResultDialog(this.jdField_a_of_type_AndroidAppActivity);
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131718866);
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
      localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(str);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = new ForwardBaseOption.1(this);
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a((String)localObject1, (DialogInterface.OnClickListener)localObject2);
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a((DialogInterface.OnClickListener)localObject2);
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ForwardOption.ForwardBaseOption", 2, " qbShowShareResultDialog error mActivity = null");
    }
  }
  
  private void M()
  {
    Object localObject = this.jdField_c_of_type_JavaUtilArrayList;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
        if (localResultRecord.uinType == 6000) {
          b(jdField_f_of_type_JavaLangInteger.intValue());
        } else if (localResultRecord.uinType == 6003) {
          b(k.intValue());
        }
      }
      localObject = this.jdField_b_of_type_JavaUtilArrayList;
      if ((localObject == null) || (((ArrayList)localObject).isEmpty()))
      {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("NOCANCEL4DATALIN", true);
        this.jdField_a_of_type_AndroidAppActivity.setResult(0, this.jdField_a_of_type_AndroidContentIntent);
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
      this.jdField_a_of_type_AndroidOsBundle.putParcelableArrayList("forward_multi_target", this.jdField_b_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("forward_multi_target", this.jdField_b_of_type_JavaUtilArrayList);
    }
    a();
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("system_share", false))
    {
      if ((1 == this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", 2147483647)) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false))) {
        return;
      }
      ForwardUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    if ((this.jdField_g_of_type_Boolean) && (!this.jdField_h_of_type_Boolean))
    {
      ThreadManager.getUIHandler().postDelayed(new ForwardBaseOption.3(this), 500L);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_need_show_toast", true)) {
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 500L);
    }
  }
  
  private void N()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsBundle;
    boolean bool;
    if (localObject != null) {
      bool = ((Bundle)localObject).getBoolean("from_card", false);
    } else {
      bool = false;
    }
    if (bool)
    {
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("pubUin");
      if (localObject == null) {
        localObject = "";
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", (String)localObject, "0X8005A2C", "0X8005A2C", 0, 0, "", "", "", "", false);
    }
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_shoot_quick", false))
    {
      int j = this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type");
      if (j == 21) {
        localObject = "0X800780B";
      }
      for (;;)
      {
        break;
        if (j == 1) {
          localObject = "0X8007811";
        } else {
          localObject = "";
        }
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
    }
    localObject = this.jdField_a_of_type_AndroidOsBundle;
    if ((localObject != null) && (((Bundle)localObject).getBoolean("forward_report_confirm")))
    {
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("forward_report_confirm_action_name");
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("forward_report_confirm_reverse2");
      if (localObject == null) {
        localObject = "";
      }
      if (str == null) {
        str = "";
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, str, "", "", "");
    }
    if (this.jdField_c_of_type_Boolean) {
      ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", String.valueOf(this.jdField_a_of_type_Long), "1000", "50", "0", false, this.jdField_c_of_type_Boolean);
    }
    localObject = this.jdField_a_of_type_AndroidOsBundle;
    if ((localObject != null) && (((Bundle)localObject).getInt("extra_key_from_apollo") > 0)) {
      VipUtils.a(null, "cmshow", "Apollo", "QQSend", 0, 0, new String[0]);
    }
    localObject = this.jdField_a_of_type_AndroidOsBundle;
    if ((localObject != null) && (((Bundle)localObject).getBoolean("KEY_FROM_OCR", false))) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009C8E", "0X8009C8E", 0, 0, "", "", "", "");
    }
    localObject = this.jdField_a_of_type_AndroidOsBundle;
    if ((localObject != null) && (((Bundle)localObject).getBoolean("KEY_FROM_TRANSLATE", false))) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009C85", "0X8009C85", 0, 0, "", "", "", "");
    }
  }
  
  private void O()
  {
    if (j())
    {
      localObject1 = a().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResultRecord)((Iterator)localObject1).next();
        a(((ResultRecord)localObject2).uin, ((ResultRecord)localObject2).getUinType());
      }
    }
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle;
    if (localObject1 != null) {
      localObject1 = ((Bundle)localObject1).getString("uin");
    } else {
      localObject1 = "";
    }
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle;
    int j = -1;
    if (localObject2 != null) {
      j = ((Bundle)localObject2).getInt("uintype", -1);
    }
    a((String)localObject1, j);
  }
  
  private void P()
  {
    Bundle localBundle = new Bundle();
    if (j())
    {
      localObject = a().iterator();
      while (((Iterator)localObject).hasNext())
      {
        localBundle.putLong("key_receiver_type", ((ResultRecord)((Iterator)localObject).next()).getUinType());
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "ae_camera_get_info_client", "action_get_send_to_info", localBundle, null);
      }
    }
    Object localObject = this.jdField_a_of_type_AndroidOsBundle;
    long l;
    if (localObject != null) {
      l = ((Bundle)localObject).getInt("uintype", -1);
    } else {
      l = -1L;
    }
    localBundle.putLong("key_receiver_type", l);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "ae_camera_get_info_client", "action_get_send_to_info", localBundle, null);
  }
  
  private void Q()
  {
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, 0, 2131561251, 17);
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.setContentView(2131562765);
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在发送");
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    }
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void R()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public static int a(Bundle paramBundle)
  {
    int j = paramBundle.getInt("forward_source_business_type", -1);
    int k;
    if (j == -1)
    {
      int m = paramBundle.getInt("forward_source_uin_type", -1);
      if (m == 0)
      {
        j = 100101;
        k = m;
      }
      else if (m == 1)
      {
        j = 100100;
        k = m;
      }
      else
      {
        k = m;
        if (m == 3000)
        {
          j = 100300;
          k = m;
        }
      }
    }
    else
    {
      k = -11;
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("getForwardSrcBusinessType, srcBusinessType = ");
      paramBundle.append(j);
      paramBundle.append(",sourceUinType = ");
      paramBundle.append(k);
      QLog.d("ForwardOption.ForwardBaseOption", 2, paramBundle.toString());
    }
    return j;
  }
  
  private Drawable a()
  {
    Object localObject1 = this.jdField_d_of_type_JavaLangString;
    if ((localObject1 != null) && (AbsDownloader.hasFile((String)localObject1))) {
      localObject1 = this.jdField_d_of_type_JavaLangString;
    } else {
      localObject1 = this.jdField_c_of_type_JavaLangString;
    }
    if (localObject1 != null)
    {
      Object localObject3 = a((String)localObject1, "file:");
      Object localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (((File)localObject3).exists())
        {
          localObject3 = ((File)localObject3).getAbsolutePath();
          this.jdField_a_of_type_AndroidOsBundle.putString("EditImagePath", (String)localObject3);
          URL localURL = RegionalThumbDownloader.generateURLForNew((String)localObject3, ScreenUtil.dip2px(100.0F), ScreenUtil.dip2px(300.0F));
          localObject2 = localObject1;
          if (localURL != null) {
            localObject2 = localURL.toString();
          }
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = localObject3;
          }
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getURLDrawable updateImageView  fixedUrlString=");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.e("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject2).toString());
            localObject2 = localObject1;
          }
        }
      }
      try
      {
        localObject1 = URLDrawable.getDrawable((String)localObject2);
        return localObject1;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getURLDrawable fixedUrlString url is illegal = ");
          ((StringBuilder)localObject2).append(localException);
          QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject2).toString());
        }
        return null;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("ForwardOption.ForwardBaseOption", 2, "getURLDrawable isURLDrawablFoward is true, but mBigURLDrawableUrl and URLDrawableUrl are null");
    }
    return null;
  }
  
  private Drawable a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject = RegionalThumbDownloader.generateURLForNew(paramString, ScreenUtil.dip2px(100.0F), ScreenUtil.dip2px(300.0F));
    if (localObject == null) {
      return null;
    }
    if (!AbsDownloader.hasFile(((URL)localObject).toString())) {
      return null;
    }
    if (localObject != null) {
      localObject = ((URL)localObject).toString();
    } else {
      localObject = "";
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = (String)localObject;
    }
    try
    {
      localObject = URLDrawable.getDrawable(paramString);
      try
      {
        URLDrawableHelper.decodeLocalImage((URLDrawable)localObject, null, false);
        return localObject;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        return localObject;
      }
    }
    catch (Exception paramString)
    {
      localObject = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getNormalDrawable urlString url is illegal = ");
    localStringBuilder.append(paramString);
    QLog.d("ForwardOption.ForwardBaseOption", 2, localStringBuilder.toString());
    return localObject;
  }
  
  private File a(String paramString1, String paramString2)
  {
    boolean bool1 = paramString1.toLowerCase(Locale.US).startsWith(paramString2);
    Object localObject2 = null;
    if (bool1) {
      localObject1 = localObject2;
    }
    try
    {
      if (!paramString1.substring(0, paramString2.length()).equalsIgnoreCase(paramString2)) {
        break label75;
      }
      localObject1 = new File(paramString1.substring(paramString2.length()));
    }
    catch (IndexOutOfBoundsException paramString1)
    {
      label59:
      boolean bool2;
      break label59;
    }
    Object localObject1 = localObject2;
    break label75;
    localObject1 = AbsDownloader.getFile(AbsDownloader.covertUrlForAioImage(paramString1));
    label75:
    bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
    bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_pre_guide", false);
    if ((bool1) || (bool2)) {
      localObject1 = new File(this.jdField_c_of_type_JavaLangString);
    }
    return localObject1;
  }
  
  @Deprecated
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    a(paramActivity, paramIntent, ForwardRecentActivity.class, paramInt, -1, "");
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt1, int paramInt2)
  {
    a(paramActivity, paramIntent, ForwardRecentActivity.class, paramInt1, paramInt2, "");
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt1, int paramInt2, String paramString)
  {
    a(paramActivity, paramIntent, ForwardRecentActivity.class, paramInt1, paramInt2, paramString);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, String paramString)
  {
    a(paramActivity, paramIntent, ForwardRecentActivity.class, paramInt, paramString);
  }
  
  @Deprecated
  public static void a(Activity paramActivity, Intent paramIntent, Class<?> paramClass, int paramInt)
  {
    a(paramActivity, paramIntent, paramClass, paramInt, -1, "");
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Class<?> paramClass, int paramInt1, int paramInt2, String paramString)
  {
    paramIntent.setClass(paramActivity, paramClass);
    paramIntent.putExtra("caller_name", paramActivity.getClass().getSimpleName());
    paramIntent.putExtra("forward_source_business_type", paramInt2);
    paramIntent.putExtra("forward_source_sub_business_type", paramString);
    paramActivity.startActivityForResult(paramIntent, paramInt1);
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt1, int paramInt2)
  {
    a(paramActivity, paramString, paramIntent, ForwardRecentActivity.class, paramInt1, paramInt2);
  }
  
  private static void a(Activity paramActivity, String paramString, Intent paramIntent, Class<?> paramClass, int paramInt1, int paramInt2)
  {
    paramIntent.setClass(paramActivity, paramClass);
    if (TextUtils.isEmpty(paramString)) {
      paramIntent.putExtra("caller_name", paramActivity.getClass().getSimpleName());
    } else {
      paramIntent.putExtra("caller_name", paramString);
    }
    paramIntent.putExtra("forward_source_business_type", paramInt2);
    paramActivity.startActivityForResult(paramIntent, paramInt1);
  }
  
  @Deprecated
  public static void a(Context paramContext, Intent paramIntent)
  {
    a(paramContext, paramIntent, ForwardRecentActivity.class, -1, "");
  }
  
  @Deprecated
  public static void a(Context paramContext, Intent paramIntent, Class<?> paramClass)
  {
    a(paramContext, paramIntent, paramClass, -1, "");
  }
  
  private static void a(Context paramContext, Intent paramIntent, Class<?> paramClass, int paramInt, String paramString)
  {
    if (paramContext != null)
    {
      paramIntent.setClass(paramContext, paramClass);
      paramIntent.putExtra("forward_source_business_type", paramInt);
      paramIntent.putExtra("forward_source_sub_business_type", paramString);
      paramContext.startActivity(paramIntent);
    }
  }
  
  private void a(Bundle paramBundle, int paramInt, String paramString)
  {
    long l = paramBundle.getLong("req_share_id", 0L);
    Object localObject;
    if (l == 0L)
    {
      paramBundle = paramBundle.getString("forward_ark_app_meta");
      if (TextUtils.isEmpty(paramBundle))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardBaseOption", 2, "reportClickSend arkAppId is empty");
        }
        return;
      }
      localObject = null;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramBundle).optJSONObject("news");
        paramBundle = (Bundle)localObject;
        if (localJSONObject == null) {
          break label126;
        }
        paramBundle = localJSONObject.optString("appid");
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        paramBundle = (Bundle)localObject;
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append(l);
      paramBundle.append("");
      paramBundle = paramBundle.toString();
    }
    label126:
    boolean bool;
    if ((paramInt != 1) && (paramInt != 2)) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportClickSend ,isForwardC2cOrGroup = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    if (("101492711".equals(paramBundle)) && (bool))
    {
      if (paramInt == 1) {
        localObject = "c2c_AIO";
      } else {
        localObject = "Grp_AIO";
      }
      ReportController.b(null, "dc00899", (String)localObject, "", "video_tab", "videoark_share", 0, 0, paramString, paramBundle, "", "");
    }
  }
  
  private void a(AIOImageData paramAIOImageData, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "getImageEditListener from AIOImageData");
    }
    if ((paramAIOImageData.a(4)) && (paramAIOImageData.a(4) != null))
    {
      a(paramAIOImageData, paramString);
      return;
    }
    if ((paramAIOImageData.a(2)) && (paramAIOImageData.a(2) != null))
    {
      a(paramAIOImageData, paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "Edit Forward Image: image does not exist");
    }
  }
  
  private void a(AIORichMediaData paramAIORichMediaData, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startToAioImagePreview: msgId=");
      if (paramAIORichMediaData != null) {
        localObject = Long.valueOf(paramAIORichMediaData.f);
      } else {
        localObject = "";
      }
      localStringBuilder.append(localObject);
      QLog.d("ForwardOption.ForwardBaseOption", 2, localStringBuilder.toString());
    }
    if (paramAIORichMediaData != null)
    {
      paramString = new AIOImageProviderService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramString, 0, null);
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
      a((Bundle)localObject, paramString, paramAIORichMediaData);
      G();
    }
  }
  
  private void a(MessageForPic paramMessageForPic, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startToAioImagePreview: uniseq=");
      if (paramMessageForPic != null) {
        localObject = Long.valueOf(paramMessageForPic.uniseq);
      } else {
        localObject = "";
      }
      localStringBuilder.append(localObject);
      QLog.d("ForwardOption.ForwardBaseOption", 2, localStringBuilder.toString());
    }
    if (paramMessageForPic != null)
    {
      paramString = new AIOImageProviderService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramString, 0, paramMessageForPic);
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
      a((Bundle)localObject, paramString, AIOGalleryUtils.a(paramMessageForPic));
      G();
    }
  }
  
  private void a(MessageForPic paramMessageForPic, String paramString, ForwardBaseOption.IPicDownloadCallback paramIPicDownloadCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "getImageEditListener from MessageForPic");
    }
    paramIPicDownloadCallback = new File(paramMessageForPic.path);
    if (paramIPicDownloadCallback.exists())
    {
      paramIPicDownloadCallback.length();
      long l = paramMessageForPic.size;
    }
    a(paramMessageForPic, paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    Intent localIntent = this.jdField_a_of_type_AndroidContentIntent;
    if ((localIntent != null) && (("ChatActivity".equals(localIntent.getStringExtra("caller_name"))) || ("SplashActivity".equals(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("caller_name")))))
    {
      PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_photo_sender_uin"), this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_photo_md5"), "0X8009F55", paramString);
      return;
    }
    localIntent = this.jdField_a_of_type_AndroidContentIntent;
    if ((localIntent != null) && ("PublicTransFragmentActivity".equals(localIntent.getStringExtra("caller_name")))) {
      PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_photo_sender_uin"), this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_photo_md5"), "0X8009F56", paramString);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startToAioImagePreviewWithPath: path=");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject = new AIOImageData();
      ((AIOImageData)localObject).jdField_a_of_type_JavaLangString = paramString1;
      ((AIOImageData)localObject).jdField_b_of_type_JavaLangString = paramString1;
      ((AIOImageData)localObject).jdField_c_of_type_JavaLangString = paramString1;
      ((AIOImageData)localObject).jdField_e_of_type_Boolean = false;
      paramString1 = new Bundle();
      paramString1.putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
      a(paramString1, new AIOImageProviderService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramString2, 0, null), (AIORichMediaData)localObject);
      G();
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("key_mini_report_event_action_type", paramString1);
    localBundle.putString("key_mini_report_event_sub_action_type", paramString2);
    localBundle.putString("key_mini_report_event_reserves", paramString3);
    localBundle.putString("key_mini_report_event_reserves2", paramString4);
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", localBundle, null);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    boolean bool;
    if ((paramInt != 1) && (paramInt != 2)) {
      bool = false;
    } else {
      bool = true;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportClickSend ,isAudioReqType = ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(",isMusicArkView = ");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append(",isForwardC2cOrGroup = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    if (((paramBoolean1) || (paramBoolean2)) && (bool))
    {
      if (paramInt == 1) {
        localObject = "c2c_AIO";
      } else {
        localObject = "Grp_AIO";
      }
      if (paramInt == 1) {
        paramString = "";
      }
      ReportController.b(null, "dc00899", (String)localObject, "", "music_tab", "musicark_share", 0, 0, paramString, "", "", "");
    }
  }
  
  private void a(int[] paramArrayOfInt, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean[] paramArrayOfBoolean)
  {
    IWriteTogetherOidbHandler localIWriteTogetherOidbHandler = (IWriteTogetherOidbHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.WRITE_TOGETHER_HANDLER);
    int j = 0;
    while (j < paramArrayOfBoolean.length)
    {
      if (paramArrayOfBoolean[j] != 0) {
        localIWriteTogetherOidbHandler.sendForwardWtMessage(paramArrayOfString1[j], paramArrayOfString2[j], paramArrayOfInt[j], paramString);
      }
      j += 1;
    }
    Q();
    paramArrayOfInt = new ForwardBaseOption.4(this, paramArrayOfBoolean, paramArrayOfString1, paramArrayOfString2, paramArrayOfInt, this.jdField_a_of_type_AndroidOsBundle.getInt("forward_write_together_number"));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(paramArrayOfInt);
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 0) && (paramInt != 1006) && (paramInt != 3000))
    {
      if (paramInt == 1000) {
        return true;
      }
      return j();
    }
    return true;
  }
  
  public static boolean a(Bundle paramBundle)
  {
    int j = paramBundle.getInt("forward_source_uin_type", -1);
    return (j == 1004) || (j == 1000);
  }
  
  private boolean a(RecentUser paramRecentUser)
  {
    boolean bool = true;
    if ((paramRecentUser != null) && (!Utils.a(paramRecentUser.uin)) && ((paramRecentUser.getType() != 1006) || (a(ForwardAbility.ForwardAbilityType.jdField_h_of_type_JavaLangInteger))) && (b(paramRecentUser)) && ((paramRecentUser.getType() != 1) || (!a(paramRecentUser.uin))) && ((paramRecentUser.getType() != 0) || (!CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.uin, paramRecentUser.getType()))))
    {
      if ((paramRecentUser.getType() != 1004) && (paramRecentUser.getType() != 1000)) {
        return bool;
      }
      if (this.jdField_b_of_type_Boolean) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  private boolean b(RecentUser paramRecentUser)
  {
    return (paramRecentUser.getType() != 1020) && (paramRecentUser.getType() != 1008) && (paramRecentUser.getType() != 1005) && (paramRecentUser.getType() != 1009) && (paramRecentUser.getType() != 1021) && (paramRecentUser.getType() != 1001) && (paramRecentUser.getType() != 10002) && (paramRecentUser.getType() != 10004) && (paramRecentUser.getType() != 1022) && (paramRecentUser.getType() != 1032) && (paramRecentUser.getType() != 1033) && (paramRecentUser.getType() != 1034) && (paramRecentUser.getType() != 7000) && (paramRecentUser.getType() != 6004) && (paramRecentUser.getType() != 9501);
  }
  
  private boolean b(String paramString)
  {
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    int m = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0);
    if (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(str, true).jdField_a_of_type_Boolean)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697407, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299168));
      return false;
    }
    int k = a().getInt("key_forward_ability_type");
    paramString = new StringBuilder();
    paramString.append("-->getConfirmListener--onClick--type = ");
    paramString.append(k);
    QLog.d("ForwardOption.ForwardBaseOption", 1, paramString.toString());
    int j;
    if ((!QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (k != jdField_f_of_type_JavaLangInteger.intValue()))
    {
      j = k;
      if (k != k.intValue()) {}
    }
    else
    {
      this.jdField_a_of_type_AndroidOsBundle.putString("uin", "3636666661");
      this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", 0);
      this.jdField_a_of_type_AndroidOsBundle.putString("uinname", this.jdField_a_of_type_AndroidContentContext.getString(2131698288));
      this.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", jdField_b_of_type_JavaLangInteger.intValue());
      j = jdField_b_of_type_JavaLangInteger.intValue();
    }
    try
    {
      if ((j != jdField_f_of_type_JavaLangInteger.intValue()) && (j != k.intValue()))
      {
        if (j == jdField_g_of_type_JavaLangInteger.intValue())
        {
          x();
        }
        else if (j == j.intValue())
        {
          B();
        }
        else if (j == m.intValue())
        {
          C();
        }
        else if (j == jdField_e_of_type_JavaLangInteger.intValue())
        {
          paramString = null;
          if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog instanceof QQCustomDialogWtihEmoticonInput)) {
            paramString = ((QQCustomDialogWtihEmoticonInput)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog).a();
          }
          b(paramString);
        }
        else if (!a(str, m))
        {
          a();
        }
      }
      else {
        b(j);
      }
      if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_need_show_toast", true)) && (a(m, str, j))) {
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 300L);
      }
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardBaseOption", 2, "Throwable", paramString);
      }
    }
    f(j);
    N();
    return true;
  }
  
  private void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "getImageEditListener from other");
    }
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
    if (str != null)
    {
      a(str, paramString);
      return;
    }
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "Edit Forward Image: from QZone");
      }
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("FORWARD_IS_QZONE_SHARE", true);
      a(this.jdField_b_of_type_JavaLangString, paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "Edit Forward Image: Unknown source");
    }
  }
  
  private void e()
  {
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("req_type");
    Object localObject1;
    if ((this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_ark_display_share", false)) && (j != 5))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtils.a(this.jdField_a_of_type_AndroidAppActivity, c(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427342));
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("shareArkInfo");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    try
    {
      Object localObject2 = new JSONObject((String)localObject1);
      localObject1 = ((JSONObject)localObject2).optString("app");
      String str = ((JSONObject)localObject2).optString("view");
      localObject2 = ((JSONObject)localObject2).optString("meta");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
        ArkAppDataReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, "AIOArkSdkSelectSend", 1, 0, 0L, 0L, 0L, str, "");
      }
      label160:
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage("");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690728, b());
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131690820, a());
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtils.a(this.jdField_a_of_type_AndroidAppActivity, c(), a(), null, a(), b(), this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427342));
      j = this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
      boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_ability_entrence_show_in_share", false);
      if ((j == jdField_e_of_type_JavaLangInteger.intValue()) && (bool))
      {
        localObject1 = (QQCustomDialogWtihEmoticonInput)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
        ((QQCustomDialogWtihEmoticonInput)localObject1).b();
        ((QQCustomDialogWtihEmoticonInput)localObject1).getEditText().setHint(HardCodeUtil.a(2131704832));
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      break label160;
    }
  }
  
  private void e(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 12: 
      a("user_click", "more_button", "share_QQ", "success");
      return;
    case 11: 
      a("user_click", "custom_button", "share_QQ", "success");
      return;
    }
    a("user_click", "more_about", "share", "success");
  }
  
  private int f()
  {
    if (i()) {
      return 2;
    }
    return 0;
  }
  
  private void f(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle;
    int j = 0;
    Object localObject2;
    String str;
    Object localObject3;
    Object localObject4;
    if (localObject1 != null)
    {
      boolean bool = ((Bundle)localObject1).getBoolean("from_web", false);
      j = bool;
      if (bool)
      {
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_uin");
        if (localObject2 == null) {
          localObject2 = "";
        }
        str = this.jdField_a_of_type_AndroidOsBundle.getString("struct_url");
        localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
        str = this.jdField_a_of_type_AndroidOsBundle.getString("strurt_msgid");
        if (str == null) {
          str = "";
        }
        localObject3 = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId((String)localObject1);
        if (paramInt == jdField_e_of_type_JavaLangInteger.intValue()) {
          paramInt = 1002;
        } else {
          paramInt = 1001;
        }
        localObject4 = this.jdField_a_of_type_AndroidOsBundle.getString("source_puin");
        if ((localObject4 != null) && (!"".equals(localObject4)))
        {
          localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
          if ((localObject2 != null) && (paramInt != 1002)) {
            break label202;
          }
          localObject2 = "";
          label202:
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", (String)localObject2, "0X8005B07", "0X8005B07", paramInt, 0, (String)localObject4, str, (String)localObject1, (String)localObject3, false);
          j = bool;
        }
        else
        {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", paramInt, 0, (String)localObject2, str, (String)localObject1, (String)localObject3, false);
          j = bool;
        }
      }
    }
    localObject1 = this.jdField_a_of_type_AndroidOsBundle;
    if ((localObject1 != null) && (j == 0))
    {
      str = ((Bundle)localObject1).getString("source_puin");
      if (str != null)
      {
        localObject1 = this.jdField_a_of_type_AndroidContentIntent.getByteArrayExtra("stuctmsg_bytes");
        if (localObject1 != null)
        {
          localObject3 = StructMsgFactory.a((byte[])localObject1);
          if (localObject3 != null)
          {
            localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(((AbsStructMsg)localObject3).msgId);
            ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEventForMigrate((AppInterface)localObject4, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005B06", "0X8005B06", 0, 0, str, localStringBuilder.toString(), "", "", false);
            localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("");
            ((StringBuilder)localObject4).append(((AbsStructMsg)localObject3).msgId);
            ((IPublicAccountReportUtils)localObject2).reportPAinfoToLighthouse("0X8005B06", (String)localObject1, str, ((StringBuilder)localObject4).toString(), "", "");
          }
        }
      }
    }
  }
  
  public void A()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected void B() {}
  
  protected void C() {}
  
  public void D()
  {
    int j = e();
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("forward_source_sub_business_type", "");
    int k = a(this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", 2147483647));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportShowForwardRecent srcBusinessType = ");
      localStringBuilder.append(j);
      localStringBuilder.append(",srcSubBusinessType = ");
      localStringBuilder.append(str);
      QLog.d("ForwardOption.ForwardBaseOption", 2, localStringBuilder.toString());
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A7EB", "0X800A7EB", j, 0, "", "", String.valueOf(k), str);
  }
  
  public void E()
  {
    Object localObject3 = this;
    if (((ForwardBaseOption)localObject3).jdField_a_of_type_AndroidOsBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "reportFinalSelectedTargets return, mExtraData is null");
      }
      return;
    }
    if (jdField_a_of_type_JavaTextSimpleDateFormat == null) {
      jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    }
    int k = e();
    String str3 = ((ForwardBaseOption)localObject3).jdField_a_of_type_AndroidOsBundle.getString("forward_source_sub_business_type", "");
    Object localObject1 = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    int m = ((ForwardBaseOption)localObject3).jdField_a_of_type_AndroidOsBundle.getInt("forward_type", 2147483647);
    int j = ((ForwardBaseOption)localObject3).a(m);
    boolean bool = QLog.isColorLevel();
    String str1 = ",srcSubBusinessType = ";
    if (bool)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("reportFinalSelectedTargets srcBusinessType = ");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append(",srcSubBusinessType = ");
      ((StringBuilder)localObject2).append(str3);
      ((StringBuilder)localObject2).append(",forwardType = ");
      ((StringBuilder)localObject2).append(m);
      ((StringBuilder)localObject2).append(",forwardMsgType = ");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(",operateTime = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject4 = ((ForwardBaseOption)localObject3).jdField_a_of_type_JavaUtilArrayList;
    Object localObject2 = ",forwardTargetType = ";
    String str2 = ",targetUinType = ";
    if ((localObject4 != null) && (((ArrayList)localObject4).size() > 0))
    {
      localObject4 = ((ForwardBaseOption)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        localObject3 = this;
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject4).next();
        String str4 = localResultRecord.uin;
        m = localResultRecord.uinType;
        n = ((ForwardBaseOption)localObject3).a(str4, m);
        ReportController.b(((ForwardBaseOption)localObject3).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str4, "0X800A7EC", "0X800A7EC", k, 0, (String)localObject1, String.valueOf(n), String.valueOf(j), str3);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("reportFinalSelectedTargets multi,,targetUin = ");
          ((StringBuilder)localObject3).append(str4);
          ((StringBuilder)localObject3).append(str2);
          ((StringBuilder)localObject3).append(m);
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append(n);
          ((StringBuilder)localObject3).append(str1);
          ((StringBuilder)localObject3).append(str3);
          QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject3).toString());
        }
      }
    }
    m = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    str1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    int n = a(str1, m);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X800A7EC", "0X800A7EC", k, 0, (String)localObject1, String.valueOf(n), String.valueOf(j), str3);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportFinalSelectedTargets single,,targetUin = ");
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append(",targetUinType = ");
      ((StringBuilder)localObject1).append(m);
      ((StringBuilder)localObject1).append(",forwardTargetType = ");
      ((StringBuilder)localObject1).append(n);
      ((StringBuilder)localObject1).append(",srcSubBusinessType = ");
      ((StringBuilder)localObject1).append(str3);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void F()
  {
    ForwardBaseOption localForwardBaseOption = this;
    if (jdField_a_of_type_JavaTextSimpleDateFormat == null) {
      jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    }
    int m = e();
    Object localObject1 = localForwardBaseOption.jdField_a_of_type_AndroidOsBundle;
    String str3 = "";
    String str4 = ((Bundle)localObject1).getString("forward_source_sub_business_type", "");
    String str1 = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    int j = -1;
    int n = localForwardBaseOption.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", 2147483647);
    int k = localForwardBaseOption.a(n);
    localObject1 = localForwardBaseOption.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localObject1 instanceof QQCustomDialogWtihEmoticonInput)) {
      localObject1 = ((QQCustomDialogWtihEmoticonInput)localObject1).getInputValue();
    } else if ((localObject1 instanceof ForwardNewVersionDialog)) {
      localObject1 = ((ForwardNewVersionDialog)localObject1).getInputValue();
    } else {
      localObject1 = "";
    }
    boolean bool1 = TextUtils.isEmpty((CharSequence)localObject1) ^ true;
    boolean bool2 = QLog.isColorLevel();
    Object localObject2 = ",srcSubBusinessType = ";
    Object localObject3 = "ForwardOption.ForwardBaseOption";
    if (bool2)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportClickSend srcBusinessType = ");
      ((StringBuilder)localObject1).append(m);
      ((StringBuilder)localObject1).append(",srcSubBusinessType = ");
      ((StringBuilder)localObject1).append(str4);
      ((StringBuilder)localObject1).append(",forwardType = ");
      ((StringBuilder)localObject1).append(n);
      ((StringBuilder)localObject1).append(",forwardMsgType = ");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append(",hasLeftAMessage = ");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(",operateTime = ");
      ((StringBuilder)localObject1).append(str1);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject4 = localForwardBaseOption.jdField_a_of_type_JavaUtilArrayList;
    String str2 = ",forwardTargetType = ";
    str1 = ",targetUinType = ";
    localObject1 = "1";
    if ((localObject4 != null) && (((ArrayList)localObject4).size() > 0))
    {
      localObject4 = localForwardBaseOption.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (localObject1 = str3; ((Iterator)localObject4).hasNext(); localObject1 = str3)
      {
        localObject1 = (ResultRecord)((Iterator)localObject4).next();
        str3 = ((ResultRecord)localObject1).uin;
        n = ((ResultRecord)localObject1).uinType;
        j = localForwardBaseOption.a(str3, n);
        QQAppInterface localQQAppInterface = localForwardBaseOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (bool1) {
          localObject1 = "1";
        } else {
          localObject1 = "2";
        }
        ReportController.b(localQQAppInterface, "dc00898", "", str3, "0X800A7ED", "0X800A7ED", m, 0, (String)localObject1, String.valueOf(j), String.valueOf(k), str4);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("reportClickSend multi,,targetUin = ");
          ((StringBuilder)localObject1).append(str3);
          ((StringBuilder)localObject1).append(str1);
          ((StringBuilder)localObject1).append(n);
          ((StringBuilder)localObject1).append(str2);
          ((StringBuilder)localObject1).append(j);
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(str4);
          QLog.d((String)localObject3, 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
    else
    {
      localForwardBaseOption.jdField_a_of_type_AndroidOsBundle.getInt("forward_source_uin_type");
      n = localForwardBaseOption.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
      localObject2 = localForwardBaseOption.jdField_a_of_type_AndroidOsBundle.getString("uin");
      j = localForwardBaseOption.a((String)localObject2, n);
      localObject3 = localForwardBaseOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!bool1) {
        localObject1 = "2";
      }
      ReportController.b((AppRuntime)localObject3, "dc00898", "", (String)localObject2, "0X800A7ED", "0X800A7ED", m, 0, (String)localObject1, String.valueOf(j), String.valueOf(k), str4);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("reportClickSend single,,targetUin = ");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(",targetUinType = ");
        ((StringBuilder)localObject1).append(n);
        ((StringBuilder)localObject1).append(",forwardTargetType = ");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(",srcSubBusinessType = ");
        ((StringBuilder)localObject1).append(str4);
        QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = localObject2;
    }
    localObject2 = this;
    if (2 == ((ForwardBaseOption)localObject2).jdField_a_of_type_AndroidOsBundle.getInt("req_type")) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((ForwardBaseOption)localObject2).a(bool1, "music".equals(((ForwardBaseOption)localObject2).jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_view")), j, (String)localObject1);
    ((ForwardBaseOption)localObject2).a(((ForwardBaseOption)localObject2).jdField_a_of_type_AndroidOsBundle, j, (String)localObject1);
  }
  
  public void G()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009BE9", "0X8009BE9", this.jdField_b_of_type_Int, 0, "", "", "", "");
  }
  
  public void H()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009BEA", "0X8009BEA", this.jdField_b_of_type_Int, 0, "", "", "", "");
    F();
  }
  
  public float a(float paramFloat)
  {
    Display localDisplay = this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay();
    float f2 = localDisplay.getWidth();
    float f3 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131296897);
    float f1 = paramFloat;
    if (f3 > f2 * paramFloat)
    {
      f2 = f3 / localDisplay.getWidth();
      f1 = paramFloat;
      if (f2 > paramFloat)
      {
        f1 = paramFloat;
        if (f2 < 1.0D) {
          f1 = f2;
        }
      }
    }
    return f1;
  }
  
  public int a()
  {
    return 2131690728;
  }
  
  int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 100;
    case 27: 
    case 35: 
    case 38: 
    case 39: 
    case 46: 
      return 11;
    case 24: 
      return 9;
    case 21: 
      return 4;
    case 20: 
    case 23: 
      return 8;
    case 14: 
      return 7;
    case 8: 
      return 3;
    case 3: 
      return 5;
    case 1: 
      return 2;
    case -1: 
      return 1;
    case -3: 
    case 1001: 
      return 10;
    }
    return 6;
  }
  
  int a(String paramString, int paramInt)
  {
    boolean bool = AppConstants.DATALINE_PC_UIN.equals(paramString);
    int j = 1;
    if (bool) {
      return 4;
    }
    if ("-1010".equals(paramString)) {
      return 6;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000)
        {
          if (ChatActivityUtils.a(paramInt)) {
            return 3;
          }
          return 100;
        }
        return 7;
      }
      return 2;
    }
    paramInt = j;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString)) {
      paramInt = 5;
    }
    return paramInt;
  }
  
  protected final DialogInterface.OnClickListener a()
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new ForwardBaseOption.2(this);
    }
    return this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  protected View.OnClickListener a(ForwardBaseOption.IPicDownloadCallback paramIPicDownloadCallback)
  {
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = new ForwardBaseOption.7(this, str, paramIPicDownloadCallback);
    }
    return this.jdField_a_of_type_AndroidViewView$OnClickListener;
  }
  
  protected View a()
  {
    return null;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public String a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DialogContent:mForwardText=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("ForwardOption.ForwardBaseOption", 2, localStringBuilder.toString());
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected List<ResultRecord> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    boolean bool = t();
    ArrayList localArrayList = new ArrayList();
    RecentUser localRecentUser;
    if ((bool) && (this.jdField_c_of_type_Int == 2))
    {
      localRecentUser = new RecentUser(AppConstants.DATALINE_PC_UIN, 6000);
      localRecentUser.displayName = HardCodeUtil.a(2131694380);
      localArrayList.add(localRecentUser);
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localRecentUser = (RecentUser)paramList.next();
      if ((bool) && (this.jdField_c_of_type_Int == 1) && (localRecentUser != null) && (TextUtils.equals(localRecentUser.uin, AppConstants.DATALINE_PC_UIN))) {
        localArrayList.add(localRecentUser);
      } else if (a(localRecentUser)) {
        localArrayList.add(localRecentUser);
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("getForwardRecentList result size is: ");
      paramList.append(localArrayList.size());
      QLog.i("ForwardOption.ForwardBaseOption", 2, paramList.toString());
    }
    return localArrayList;
  }
  
  public Set<Integer> a()
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      b();
    }
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  protected void a()
  {
    boolean bool = j();
    int j = 0;
    if (bool)
    {
      List localList = b();
      if ((localList != null) && (!localList.isEmpty()))
      {
        int k = localList.size();
        while (j < k)
        {
          ResultRecord localResultRecord = (ResultRecord)localList.get(j);
          if (l()) {
            b(localResultRecord.uin, localResultRecord.groupUin, localResultRecord.getUinType());
          }
          j += 1;
        }
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
        c();
      }
    }
    else
    {
      H();
      if (this.jdField_d_of_type_Boolean)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
        this.jdField_d_of_type_Boolean = false;
      }
      if (l()) {
        s();
      }
      y();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (!h()) {
      return;
    }
    if (paramInt >= 0) {
      this.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", paramInt);
    }
    if (paramBundle != null)
    {
      this.jdField_g_of_type_Boolean = paramBundle.getBoolean("from_outside_share", false);
      this.jdField_h_of_type_Boolean = paramBundle.getBoolean("from_dataline_aio", false);
      ((IShareReport)QRoute.api(IShareReport.class)).setUinType(String.valueOf(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype")));
      this.jdField_f_of_type_JavaLangString = paramBundle.getString("caller_name", "");
      this.jdField_a_of_type_AndroidOsBundle.putAll(paramBundle);
    }
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("forward_multi_target");
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    paramBundle = this.jdField_a_of_type_JavaUtilArrayList;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)paramBundle.next();
        if ((localResultRecord.uinType != 6000) && (localResultRecord.uinType != 6003)) {
          this.jdField_b_of_type_JavaUtilArrayList.add(localResultRecord);
        } else {
          this.jdField_c_of_type_JavaUtilArrayList.add(localResultRecord);
        }
      }
    }
    n();
  }
  
  protected void a(Intent paramIntent) {}
  
  protected void a(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramBoolean) {
      URLDrawableHelper.decodeLocalImage((URLDrawable)paramDrawable, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
    }
    if (paramDrawable == null) {
      return;
    }
    if (!paramBoolean) {
      paramDrawable.setBounds(ImageUtil.a(paramDrawable, 36, 100, this.jdField_a_of_type_Float));
    }
  }
  
  protected void a(Drawable paramDrawable, boolean paramBoolean, int paramInt)
  {
    a(paramDrawable, paramBoolean, paramInt, false);
  }
  
  protected void a(Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new ForwardBaseOption.10(this, paramDrawable, paramBoolean1, paramInt, paramBoolean2));
  }
  
  public void a(Bundle paramBundle)
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      paramBundle.putBundle("key_forward_base_option_bundle", this.jdField_a_of_type_AndroidOsBundle);
    }
  }
  
  protected void a(Bundle paramBundle, AIOImageProviderService paramAIOImageProviderService, AIORichMediaData paramAIORichMediaData)
  {
    PeakUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramBundle, paramAIOImageProviderService, paramAIORichMediaData, 19001, 4);
  }
  
  protected void a(Bundle paramBundle, String paramString, DirectForwarder.CallBack paramCallBack)
  {
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((paramBundle instanceof QQCustomDialogWtihEmoticonInput)) {
      paramBundle = ((QQCustomDialogWtihEmoticonInput)paramBundle).getInputValue();
    } else if ((paramBundle instanceof ForwardNewVersionDialog)) {
      paramBundle = ((ForwardNewVersionDialog)paramBundle).getInputValue();
    } else {
      paramBundle = "";
    }
    if (QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      a(paramBundle, paramString, paramCallBack);
      return;
    }
    b(paramBundle, paramString, paramCallBack);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density;
  }
  
  public void a(ForwardBaseOption.EventListener paramEventListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramEventListener);
  }
  
  protected void a(QQCustomDialog paramQQCustomDialog) {}
  
  protected void a(QQCustomDialogWtihForwardAvatar paramQQCustomDialogWtihForwardAvatar)
  {
    if (paramQQCustomDialogWtihForwardAvatar == null) {
      return;
    }
    Object localObject = a();
    if (localObject == null)
    {
      String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      int j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0);
      boolean bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("new_create_troop", false);
      String str1 = c();
      if ((a(j)) && (!TextUtils.isEmpty(str1)))
      {
        String str3 = HardCodeUtil.a(2131704838);
        localObject = str1;
        if (str1.startsWith(str3)) {
          localObject = str1.substring(str3.length());
        }
        localObject = ((String)localObject).trim();
        paramQQCustomDialogWtihForwardAvatar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, str2, j, (String)localObject, bool);
      }
    }
    else
    {
      if (((List)localObject).size() == 1)
      {
        localObject = (ResultRecord)((List)localObject).get(0);
        paramQQCustomDialogWtihForwardAvatar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, ((ResultRecord)localObject).uin, ((ResultRecord)localObject).getUinType(), ((ResultRecord)localObject).name, false);
        return;
      }
      paramQQCustomDialogWtihForwardAvatar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (List)localObject, true);
    }
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (localBundle != null) {
      localBundle.remove(paramString);
    }
  }
  
  protected final void a(String paramString, QQCustomDialog paramQQCustomDialog)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addSourceNameView start! sourceName =");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramString != null) && (!"".equals(paramString)))
    {
      if (paramQQCustomDialog == null) {
        return;
      }
      localObject = new TextView(this.jdField_a_of_type_AndroidAppActivity);
      ((TextView)localObject).setText(paramString);
      ((TextView)localObject).setTextSize(12.0F);
      ((TextView)localObject).setPadding(0, 0, 0, 0);
      ((TextView)localObject).setIncludeFontPadding(false);
      ((TextView)localObject).setTextColor(-8355712);
      paramQQCustomDialog.addView((View)localObject);
    }
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    this.jdField_d_of_type_Boolean = true;
    Bundle localBundle = new Bundle();
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    localBundle.putString("uin", paramString1);
    localBundle.putInt("uintype", 1);
    localBundle.putBoolean("new_create_troop", true);
    paramString1 = new StringBuilder();
    paramString1.append(HardCodeUtil.a(2131704837));
    paramString1.append(paramString2);
    localBundle.putString("uinname", paramString1.toString());
    a(ForwardAbility.ForwardAbilityType.jdField_d_of_type_JavaLangInteger.intValue(), localBundle);
  }
  
  protected void a(String paramString1, String paramString2, DirectForwarder.CallBack paramCallBack)
  {
    paramString1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    b(paramString1, this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin"), j);
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_thumb");
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_urldrawable", false);
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_urldrawable_thumb_url");
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_urldrawable_big_url");
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_text");
    this.jdField_f_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_from_jump", false);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("key_share_data_line_support_type", 0);
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (localBundle != null)
    {
      if (localBundle.getInt("forward_type", -1) == 11) {
        this.jdField_c_of_type_Boolean = true;
      }
      this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id", 0L);
    }
    i();
    return true;
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt2 != jdField_f_of_type_JavaLangInteger.intValue())
    {
      if (paramInt2 == k.intValue()) {
        return false;
      }
      if (this.jdField_c_of_type_Boolean) {
        return false;
      }
      if (!(this instanceof ForwardSendHongBaoOption))
      {
        if ((this instanceof ForwardChooseFriendOption)) {
          return false;
        }
        if (this.jdField_a_of_type_AndroidOsBundle.getInt("cmshow_game_id") > 0) {
          return false;
        }
        boolean bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
        boolean bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_pre_guide", false);
        if (!bool1)
        {
          if (bool2) {
            return false;
          }
          if (paramInt1 == 1)
          {
            bool2 = ((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(paramString, true).jdField_a_of_type_Boolean ^ true;
            bool1 = bool2;
            if (bool2)
            {
              bool1 = bool2;
              if ((this instanceof ForwardFileOption))
              {
                paramString = (ForwardFileOption)this;
                bool1 = bool2;
                if (paramString.a != null)
                {
                  bool1 = bool2;
                  if (paramString.a.b() == 10006) {
                    return false;
                  }
                }
              }
            }
          }
          else
          {
            bool1 = true;
          }
          return bool1;
        }
      }
    }
    return false;
  }
  
  protected boolean a(Intent paramIntent)
  {
    boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavorites");
    boolean bool1 = bool2;
    if (!bool2)
    {
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool2;
        if (str.equals(this.jdField_a_of_type_AndroidAppActivity.getString(2131692206))) {
          bool1 = true;
        }
      }
    }
    if (bool1)
    {
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", this.jdField_a_of_type_AndroidAppActivity.getString(2131719442));
      paramIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    }
    bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromAIOPlus");
    return (bool1) && (bool2);
  }
  
  protected boolean a(LightAppSettingInfo paramLightAppSettingInfo)
  {
    if (paramLightAppSettingInfo == null) {
      return false;
    }
    paramLightAppSettingInfo = paramLightAppSettingInfo.jdField_a_of_type_JavaUtilArrayList;
    if (paramLightAppSettingInfo == null) {
      return false;
    }
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (localBundle == null) {
      return false;
    }
    int j = localBundle.getInt("req_type");
    if (j != 1)
    {
      if ((j == 2) && (paramLightAppSettingInfo.contains(Integer.valueOf(11003)))) {
        return true;
      }
    }
    else if (paramLightAppSettingInfo.contains(Integer.valueOf(11005))) {
      return true;
    }
    return false;
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    return true;
  }
  
  public boolean a(Integer paramInteger)
  {
    Set localSet = this.jdField_a_of_type_JavaUtilSet;
    return (localSet != null) && (localSet.contains(paramInteger));
  }
  
  public boolean a(String paramString)
  {
    HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    return (localHotChatManager != null) && (localHotChatManager.b(paramString));
  }
  
  protected boolean a(String paramString, int paramInt)
  {
    boolean[] arrayOfBoolean = this.jdField_a_of_type_AndroidOsBundle.getBooleanArray("forward_is_write_together");
    int[] arrayOfInt = this.jdField_a_of_type_AndroidOsBundle.getIntArray("forward_write_together_base_rev");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("forward_source_uin");
    String[] arrayOfString1 = this.jdField_a_of_type_AndroidOsBundle.getStringArray("forward_write_together_pad_id");
    String[] arrayOfString2 = this.jdField_a_of_type_AndroidOsBundle.getStringArray("forward_write_together_token");
    if (paramInt == 1)
    {
      if (!paramString.equals(str)) {
        return false;
      }
      if ((arrayOfBoolean != null) && (arrayOfInt != null) && (arrayOfString1 != null) && (arrayOfString2 != null))
      {
        this.jdField_a_of_type_ArrayOfBoolean = new boolean[arrayOfBoolean.length];
        int j = arrayOfBoolean.length;
        paramInt = 0;
        while (paramInt < j)
        {
          if (arrayOfBoolean[paramInt] != 0)
          {
            a(arrayOfInt, str, arrayOfString1, arrayOfString2, arrayOfBoolean);
            return true;
          }
          paramInt += 1;
        }
      }
      return false;
    }
    return false;
  }
  
  protected boolean a(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    return false;
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    return null;
  }
  
  public int b()
  {
    return 2131690820;
  }
  
  protected final DialogInterface.OnClickListener b()
  {
    if (this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener == null) {
      this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new ForwardBaseOption.5(this);
    }
    return this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener;
  }
  
  public String b()
  {
    String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("k_forward_title");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = HardCodeUtil.a(2131704840);
    }
    return str1;
  }
  
  protected List<ResultRecord> b()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  protected void b()
  {
    if (r()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (p()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_d_of_type_JavaLangInteger);
    }
    if (q()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_c_of_type_JavaLangInteger);
    }
    if (o()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_h_of_type_JavaLangInteger);
    }
    if (e()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_e_of_type_JavaLangInteger);
    }
    this.jdField_a_of_type_JavaUtilSet.add(jdField_i_of_type_JavaLangInteger);
  }
  
  public void b(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-->forwardToDataLine--type = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isJumpAIO", false);
    boolean bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
    boolean bool3 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_pre_guide", false);
    if ((!bool1) && (!bool2) && (!bool3))
    {
      Bundle localBundle = new Bundle();
      localObject = AppConstants.DATALINE_PC_UIN;
      if (paramInt == k.intValue()) {
        localObject = AppConstants.DATALINE_IPAD_UIN;
      }
      localBundle.putAll(this.jdField_a_of_type_AndroidOsBundle);
      Intent localIntent = new Intent();
      ForwardBaseOption.13 local13 = new ForwardBaseOption.13(this);
      DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false))
      {
        a(localIntent);
        localBundle.putAll(localIntent.getExtras());
        paramInt = localDataLineHandler.a().a((String)localObject, localBundle, local13);
        a(localBundle, (String)localObject, null);
      }
      else
      {
        b(localIntent);
        localBundle.putAll(localIntent.getExtras());
        paramInt = localDataLineHandler.a().b((String)localObject, localBundle, local13);
        a(localBundle, (String)localObject, null);
      }
      if ((!j()) && (paramInt == 0))
      {
        DirectForwarder.b(this.jdField_a_of_type_AndroidAppActivity, paramInt);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("NOCANCEL4DATALIN", true);
        if (e() == 100200) {
          this.jdField_a_of_type_AndroidAppActivity.setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
        } else {
          this.jdField_a_of_type_AndroidAppActivity.setResult(0, this.jdField_a_of_type_AndroidContentIntent);
        }
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
      return;
    }
    if ((bool2) || (bool3))
    {
      this.jdField_a_of_type_AndroidOsBundle.remove("PhotoConst.SEND_FLAG");
      this.jdField_a_of_type_AndroidContentIntent.removeExtra("PhotoConst.SEND_FLAG");
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->forwardToDataLine jumpAIO ");
    }
    c(paramInt);
  }
  
  protected void b(Intent paramIntent) {}
  
  public void b(Bundle paramBundle)
  {
    paramBundle = paramBundle.getBundle("key_forward_base_option_bundle");
    if (paramBundle != null) {
      a(paramBundle.getInt("key_forward_ability_type", ForwardAbility.ForwardAbilityType.a.intValue()), paramBundle);
    }
  }
  
  protected void b(String paramString) {}
  
  protected final void b(String paramString, QQCustomDialog paramQQCustomDialog)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateImageView: filepath=");
      localStringBuilder.append(paramString);
      QLog.d("ForwardOption.ForwardBaseOption", 2, localStringBuilder.toString());
    }
    ThreadManager.post(new ForwardBaseOption.11(this, paramString, paramQQCustomDialog), 8, null, false);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "updateImageView end! ");
    }
  }
  
  protected void b(String paramString1, String paramString2, DirectForwarder.CallBack paramCallBack)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (!TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sendDataLineMessage: invoked.  textAndEmoji: ");
        ((StringBuilder)localObject).append(paramString1);
        QLog.i("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
      }
      b(new Intent());
      Object localObject = new Bundle();
      ((Bundle)localObject).putBoolean("sendMultiple", false);
      ((Bundle)localObject).putInt("dataline_forward_type", 102);
      ((Bundle)localObject).putString("dataline_forward_text", paramString1);
      int j = localDataLineHandler.a().b(paramString2, (Bundle)localObject, paramCallBack);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("sendDataLineMessage: invoked.  noteRet: ");
        paramString1.append(j);
        QLog.i("ForwardOption.ForwardBaseOption", 2, paramString1.toString());
      }
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  protected boolean b(String paramString1, String paramString2, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localObject1 instanceof QQCustomDialogWtihEmoticonInput)) {
      localObject1 = ((QQCustomDialogWtihEmoticonInput)localObject1).getInputValue();
    } else if ((localObject1 instanceof ForwardNewVersionDialog)) {
      localObject1 = ((ForwardNewVersionDialog)localObject1).getInputValue();
    } else {
      localObject1 = "";
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sendMessageOnConfirm: invoked.  textAndEmoji: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject2).toString());
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", (String)localObject1);
      int j = ForwardOrderManager.a().a();
      if (j())
      {
        int[] arrayOfInt = this.jdField_a_of_type_AndroidOsBundle.getIntArray("KEY_MSG_FORWARD_ID_ARRAY");
        this.jdField_a_of_type_AndroidOsBundle.remove("KEY_MSG_FORWARD_ID_ARRAY");
        if (arrayOfInt != null)
        {
          localObject2 = new int[arrayOfInt.length + 1];
          if (arrayOfInt.length > 0) {
            System.arraycopy(arrayOfInt, 0, localObject2, 0, arrayOfInt.length);
          }
          localObject2[arrayOfInt.length] = j;
        }
        else
        {
          localObject2 = new int[1];
          localObject2[0] = j;
        }
        this.jdField_a_of_type_AndroidOsBundle.putIntArray("KEY_MSG_FORWARD_ID_ARRAY", (int[])localObject2);
      }
      else
      {
        this.jdField_a_of_type_AndroidOsBundle.putInt("KEY_MSG_FORWARD_ID", j);
      }
      Object localObject2 = new SessionInfo();
      ((SessionInfo)localObject2).jdField_a_of_type_Int = paramInt;
      ((SessionInfo)localObject2).jdField_a_of_type_JavaLangString = paramString1;
      ((SessionInfo)localObject2).jdField_b_of_type_JavaLangString = paramString2;
      if (!(this instanceof ForwardShareCardOption)) {
        ForwardOrderManager.a().a((SessionInfo)localObject2, (String)localObject1, j);
      }
      return true;
    }
    return false;
  }
  
  protected int c()
  {
    return this.jdField_a_of_type_AndroidOsBundle.getInt("emoInputType", f());
  }
  
  protected final DialogInterface.OnClickListener c()
  {
    if (this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener == null) {
      this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener = new ForwardBaseOption.6(this);
    }
    return this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener;
  }
  
  public String c()
  {
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
    Object localObject1;
    if (j == jdField_e_of_type_JavaLangInteger.intValue()) {
      localObject1 = "QQ空间";
    } else if (j == jdField_f_of_type_JavaLangInteger.intValue()) {
      localObject1 = HardCodeUtil.a(2131694380);
    } else if (j == k.intValue()) {
      localObject1 = "我的iPad";
    } else if (j == jdField_g_of_type_JavaLangInteger.intValue()) {
      localObject1 = HardCodeUtil.a(2131704831);
    } else if (j == m.intValue()) {
      localObject1 = QQStoryConstant.jdField_a_of_type_JavaLangString;
    } else {
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("uinname");
    }
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131704836));
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("dialogTitle=");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject1).toString());
    }
    return localObject2;
  }
  
  protected void c()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageWithEmo(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Float);
  }
  
  protected void c(int paramInt)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, LiteActivity.class);
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
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false))
    {
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", HardCodeUtil.a(2131704830));
      localIntent.addFlags(268435456);
      localIntent.addFlags(67108864);
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
    }
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    localIntent.putExtra("MigSdkShareNotDone", false);
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false)) {
      a(localIntent);
    } else {
      b(localIntent);
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidAppActivity.setResult(0, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  protected void c(String paramString)
  {
    Object localObject1 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    Object localObject2 = ((SmartDeviceProxyMgr)localObject1).a(Long.parseLong(paramString));
    ((SmartDeviceProxyMgr)localObject1).a(this.jdField_a_of_type_AndroidAppActivity, (DeviceInfo)localObject2, false);
    String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_filepath");
    localObject1 = (RouterHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ROUTER_HANDLER);
    localObject2 = new ArrayList();
    try
    {
      ((ArrayList)localObject2).add(new FileInfo(str));
      label81:
      ((RouterHandler)localObject1).a((ArrayList)localObject2, null, null, Long.parseLong(paramString));
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      break label81;
    }
  }
  
  protected boolean c()
  {
    if (j()) {
      return a(false);
    }
    return a(true);
  }
  
  protected int d()
  {
    return -1;
  }
  
  protected String d()
  {
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0);
    int k = this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
    if (a(j)) {
      return HardCodeUtil.a(2131704834);
    }
    if ((k != jdField_f_of_type_JavaLangInteger.intValue()) && (k != k.intValue())) {
      return "";
    }
    return HardCodeUtil.a(2131704839);
  }
  
  public void d()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A0F", "0X8005A0F", 0, 0, "0", "", "", "");
  }
  
  protected void d(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-->showQfavResultDialog--code = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localObject != null) && (((QQCustomDialog)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    A();
    ForwardBaseOption.14 local14 = new ForwardBaseOption.14(this);
    localObject = this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog;
    if (localObject == null) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog = new ShareResultDialog(this.jdField_a_of_type_AndroidAppActivity);
    } else {
      ((ShareResultDialog)localObject).dismiss();
    }
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131690706);
    localObject = str;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("app_name")))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidOsBundle.getString("app_name"));
      localObject = ((StringBuilder)localObject).toString();
    }
    this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a((String)localObject, local14);
    this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a(2131692109);
    localObject = this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog;
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((ShareResultDialog)localObject).a(bool);
    this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a(2131719030);
    this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.b(0);
    this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.c(2131719031);
    this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131694637), local14);
    try
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.show();
      return;
    }
    catch (Exception localException)
    {
      label267:
      break label267;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->showQfavResultDialog--resultDlg.show() failed");
    }
  }
  
  public int e()
  {
    return a(this.jdField_a_of_type_AndroidOsBundle);
  }
  
  protected boolean e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowQZoneAbility--allow = false");
    }
    return false;
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ForwardBaseOption.EventListener)localIterator.next()).a(this);
    }
  }
  
  public boolean f()
  {
    return false;
  }
  
  public void g()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if ((localBundle != null) && (localBundle.getBoolean("k_forward_show_direct_share_tips", false))) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A220", "0X800A220", 0, 0, "0", "", "", "");
    }
    E();
  }
  
  public boolean g()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void h() {}
  
  protected boolean h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localObject != null) && (((QQCustomDialog)localObject).isShowing())) {
      return false;
    }
    localObject = this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog;
    if ((localObject != null) && (((ShareResultDialog)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    A();
    return true;
  }
  
  void i()
  {
    if (jdField_a_of_type_Int <= 0)
    {
      Display localDisplay = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay();
      int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297487);
      int k = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297489);
      jdField_a_of_type_Int = (localDisplay.getWidth() - j * 2 - k * 3) / 4;
    }
  }
  
  protected boolean i()
  {
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0);
    int k = this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
    if (a(j)) {
      return true;
    }
    if (k != jdField_f_of_type_JavaLangInteger.intValue())
    {
      if (k == k.intValue()) {
        return true;
      }
      if (j != 1024) {
        return j == 1025;
      }
    }
    return true;
  }
  
  public void j()
  {
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    b();
  }
  
  protected boolean j()
  {
    List localList = a();
    return (localList != null) && (!localList.isEmpty());
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_favorites", true)) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_g_of_type_JavaLangInteger);
    }
  }
  
  protected boolean k()
  {
    boolean[] arrayOfBoolean = this.jdField_a_of_type_AndroidOsBundle.getBooleanArray("forward_is_write_together");
    int[] arrayOfInt = this.jdField_a_of_type_AndroidOsBundle.getIntArray("forward_write_together_base_rev");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("forward_source_uin");
    String[] arrayOfString1 = this.jdField_a_of_type_AndroidOsBundle.getStringArray("forward_write_together_pad_id");
    String[] arrayOfString2 = this.jdField_a_of_type_AndroidOsBundle.getStringArray("forward_write_together_token");
    if ((arrayOfBoolean != null) && (arrayOfInt != null) && (arrayOfString1 != null) && (arrayOfString2 != null))
    {
      List localList = b();
      this.jdField_a_of_type_ArrayOfBoolean = new boolean[arrayOfBoolean.length];
      boolean bool1 = false;
      int j = 0;
      for (;;)
      {
        bool2 = bool1;
        if (j >= localList.size()) {
          break;
        }
        ResultRecord localResultRecord = (ResultRecord)localList.get(j);
        bool2 = bool1;
        if (localResultRecord.getUinType() == 1) {
          if (!localResultRecord.uin.equals(str))
          {
            bool2 = bool1;
          }
          else
          {
            int m = arrayOfBoolean.length;
            int k = 0;
            for (;;)
            {
              bool2 = bool1;
              if (k >= m) {
                break;
              }
              if (arrayOfBoolean[k] != 0)
              {
                a(arrayOfInt, str, arrayOfString1, arrayOfString2, arrayOfBoolean);
                bool2 = true;
                break;
              }
              k += 1;
            }
          }
        }
        j += 1;
        bool1 = bool2;
      }
    }
    boolean bool2 = false;
    return bool2;
  }
  
  public void l()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog instanceof QQCustomArkDialog)) {
      ((QQCustomArkDialog)localQQCustomDialog).a(0);
    }
  }
  
  protected boolean l()
  {
    return true;
  }
  
  public void m()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localObject instanceof QQCustomArkDialog)) {
      ((QQCustomArkDialog)localObject).a(1);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected boolean m()
  {
    return false;
  }
  
  @TargetApi(11)
  protected final void n()
  {
    if (m())
    {
      w();
      return;
    }
    K();
    int j = c();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("-->buildConfirmDialog--editTextType = ");
      ((StringBuilder)localObject1).append(j);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject1).toString());
    }
    if (j == 0)
    {
      J();
    }
    else if (j == 1)
    {
      I();
    }
    else if (j == 2)
    {
      e();
    }
    else if (j == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtils.a(this.jdField_a_of_type_AndroidAppActivity, c(), a(), null, a(), b(), this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427342), false);
    }
    else
    {
      Object localObject2;
      if (j == 4)
      {
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("choose_friend_content");
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("choose_friend_subcontent");
        ArrayList localArrayList = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("choose_friend_feedbacks");
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtils.a(this.jdField_a_of_type_AndroidAppActivity, c(), (String)localObject1, (String)localObject2, localArrayList, null, a(), b(), this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427342), false);
      }
      else if (j == 5)
      {
        j = this.jdField_a_of_type_AndroidOsBundle.getInt("key_hiboom_id");
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtils.a(this.jdField_a_of_type_AndroidAppActivity, c(), "", null, a(), b(), this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427342), false);
        localObject1 = new HiBoomTextView(this.jdField_a_of_type_AndroidAppActivity);
        ((HiBoomTextView)localObject1).setHiBoom(j, 0, HiBoomConstants.b);
        ((HiBoomTextView)localObject1).setText(this.jdField_a_of_type_JavaLangString);
        ((HiBoomTextView)localObject1).setMaxSize(HiBoomConstants.jdField_a_of_type_Int);
        localObject2 = new LinearLayout.LayoutParams(500, 500);
        ((LinearLayout.LayoutParams)localObject2).gravity = 17;
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.addView((View)localObject1, (LinearLayout.LayoutParams)localObject2);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtils.a(this.jdField_a_of_type_AndroidAppActivity, c(), a(), null, a(), b(), this.jdField_a_of_type_AndroidAppActivity.getResources().getInteger(2131427342), false);
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localObject1 instanceof QQCustomDialogWtihForwardAvatar)) {
      a((QQCustomDialogWtihForwardAvatar)localObject1);
    }
    localObject1 = d();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setEditLint((String)localObject1);
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("miniAppNeedOnlyPreview", false))
    {
      ((QQCustomArkDialog)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog).a(c());
      ((QQCustomArkDialog)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.adjustTitle();
    c();
    boolean bool1 = QQEmojiUtil.containsEmoji(this.jdField_a_of_type_JavaLangString);
    boolean bool2 = QQSysFaceUtil.containsExpression(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMsgMaxLineWithEnd(this.jdField_a_of_type_JavaLangString, 3, bool1, bool2);
    if (a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog)) {
      b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getInt(jdField_e_of_type_JavaLangString, 0) == 1) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPreviewImageScaleType(true);
    }
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  public boolean n()
  {
    return true;
  }
  
  public void o()
  {
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_meta");
    boolean bool3 = TextUtils.isEmpty(str);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3) {
      try
      {
        new JSONObject(str);
        bool1 = true;
      }
      catch (Exception localException)
      {
        ArkAppCenter.a("ForwardOption.ForwardBaseOption", String.format("CheckMetaLegality,appMeta is parse error and msg=%s", new Object[] { localException.getMessage() }));
        bool1 = bool2;
      }
    }
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("forward_ark_from_h5_parse_meta_success", bool1);
  }
  
  protected boolean o()
  {
    boolean bool2 = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    boolean bool1 = true;
    if (bool2)
    {
      QLog.e("ForwardOption.ForwardBaseOption", 1, "-->allowPhoneContactAbility--allow = false, uin is empty");
      return false;
    }
    Object localObject = (IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
    if ((localObject == null) || (!((IPhoneContactService)localObject).isBindContactOk())) {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-->allowPhoneContactAbility--allow = ");
      ((StringBuilder)localObject).append(bool1);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    boolean bool = this.jdField_a_of_type_AndroidAppActivity instanceof DirectForwardActivity;
    int k = 0;
    int j;
    if (((!bool) || (this.jdField_i_of_type_Boolean)) && ((this.jdField_a_of_type_AndroidAppActivity.getIntent() == null) || (!this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("key_share_from_screen_need_finish", false))))
    {
      j = k;
      if (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null)
      {
        j = k;
        if (this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_req", -1) != 1) {}
      }
    }
    else
    {
      j = 1;
    }
    if (j != 0) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog instanceof QQCustomArkDialog)) {
      QLog.d("ForwardOption.ForwardBaseOption", 1, "QQCustomArkDialog dismiss");
    }
  }
  
  protected void p() {}
  
  protected boolean p()
  {
    Object localObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if (localObject != null)
    {
      localObject = ((DiscussionManager)localObject).a();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        bool = true;
        break label41;
      }
    }
    boolean bool = false;
    label41:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-->allowDiscussAbility--allow = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  protected void q() {}
  
  protected boolean q()
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).a();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        bool = true;
        break label41;
      }
    }
    boolean bool = false;
    label41:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-->allowTroopAbility--allow = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public void r()
  {
    a();
  }
  
  protected boolean r()
  {
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject != null)
    {
      localObject = ((FriendsManager)localObject).d();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((Groups)((Iterator)localObject).next()).group_friend_count > 0)
          {
            bool = true;
            break label68;
          }
        }
      }
    }
    boolean bool = false;
    label68:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-->allowFriendAbility--allow = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  protected void s()
  {
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    if (b(str1, str2, j))
    {
      if (j == 0) {
        j = 1;
      } else if (j == 1) {
        j = 2;
      } else if (j == 3000) {
        j = 3;
      } else {
        j = 0;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009AAE", "0X8009AAE", j, 0, "", "", "", "");
    }
  }
  
  protected boolean s()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentIntent;
    boolean bool2 = false;
    boolean bool1 = ((Intent)localObject).getBooleanExtra("sendMultiple", false);
    int j;
    if (MultiMsgManager.a().c() > 1) {
      j = 1;
    } else {
      j = 0;
    }
    int k = this.jdField_a_of_type_AndroidOsBundle.getInt("from_busi_type");
    if ((!bool1) && (j == 0) && (k != 2))
    {
      localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((SmartDeviceProxyMgr)localObject).a())
        {
          localObject = ((SmartDeviceProxyMgr)localObject).a();
          bool1 = bool2;
          if (localObject != null)
          {
            bool1 = bool2;
            if (localObject.length > 0) {
              bool1 = true;
            }
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("-->allowSmartDeviceAbility--allow = ");
        ((StringBuilder)localObject).append(bool1);
        QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
      }
      return bool1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowSmartDeviceAbility--allow = false");
    }
    return false;
  }
  
  protected void t()
  {
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("miniAppNeedOnlyPreview", false)) {
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_direct_share_fail", null, null);
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("avgame_share_callback_key", false)) {
      AVGameShareUtil.a().a(this.jdField_a_of_type_AndroidAppActivity, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "do forwardOnCancel");
    }
  }
  
  public boolean t()
  {
    Intent localIntent = this.jdField_a_of_type_AndroidContentIntent;
    if (localIntent == null) {
      return false;
    }
    int j = localIntent.getIntExtra("key_req", -1);
    if (j != 1) {
      return j == 2;
    }
    return true;
  }
  
  protected void u() {}
  
  protected void v()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setImageOnClickListener(a(new ForwardBaseOption.9(this)));
  }
  
  protected void w()
  {
    ForwardNewVersionDialog localForwardNewVersionDialog = new ForwardNewVersionDialog(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = localForwardNewVersionDialog;
    localForwardNewVersionDialog.a(i() ^ true);
    localForwardNewVersionDialog.c(210);
    localForwardNewVersionDialog.a(a());
    localForwardNewVersionDialog.setCanceledOnTouchOutside(false);
    localForwardNewVersionDialog.a(c(), d(), this.jdField_a_of_type_AndroidAppActivity.getResources().getString(a()), this.jdField_a_of_type_AndroidAppActivity.getResources().getString(b()), a(), b());
    localForwardNewVersionDialog.a(new ForwardBaseOption.12(this));
    a(localForwardNewVersionDialog);
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      localForwardNewVersionDialog.show();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(this);
  }
  
  public void x()
  {
    int j = d();
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    d(j);
  }
  
  protected void y()
  {
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("uintype") == 6002)
    {
      c(this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
      return;
    }
    if (!c()) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004047", "0X8004047", 0, 0, "", "", "", "");
    }
  }
  
  public void z()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption
 * JD-Core Version:    0.7.0.1
 */