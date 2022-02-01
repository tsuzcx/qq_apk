package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.device.utils.LightAppUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.GeneralDataBean;
import com.tencent.mobileqq.config.business.WebShareConfigProcessor;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef.RepUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardPluginShareStructMsgOption
  extends ForwardBaseOption
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 1020, 1008, 1005, 1009, 1021, 1001, 10002, 10004, 1022, 7000, 6004, 9501 };
  private URLDrawableDownListener.Adapter jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new ForwardPluginShareStructMsgOption.1(this);
  AbsShareMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
  int e;
  int f;
  String h;
  String i;
  boolean j;
  
  public ForwardPluginShareStructMsgOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_j_of_type_Boolean = false;
    this.jdField_i_of_type_JavaLangString = "";
  }
  
  private void I()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.trim();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("gotoWeb ");
        ((StringBuilder)localObject).append(str);
        QLog.e("ForwardOption.ForwardPluginShareStructMsgOption", 2, ((StringBuilder)localObject).toString());
      }
      if (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsUrl(str))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("url", str);
        ((Bundle)localObject).putBoolean("doc_from_forward_dialog", true);
        TeamWorkDocEditBrowserActivity.a(this.jdField_a_of_type_AndroidAppActivity, (Bundle)localObject, false);
      }
      else
      {
        localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserDelegationActivity.class);
        ((Intent)localObject).putExtra("param_force_internal_browser", true);
        ((Intent)localObject).putExtra("reqType", 7);
        ((Intent)localObject).putExtra("hideRightButton", true);
        ((Intent)localObject).putExtra("hide_more_button", true);
        ((Intent)localObject).putExtra("url", str);
        WebAccelerator.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject, str);
      }
      G();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ForwardOption.ForwardPluginShareStructMsgOption", 2, "empty url");
    }
  }
  
  private static boolean a(int paramInt)
  {
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int m = arrayOfInt.length;
    int k = 0;
    while (k < m)
    {
      if (paramInt == arrayOfInt[k]) {
        return true;
      }
      k += 1;
    }
    return false;
  }
  
  private boolean a(AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).getStructMsgItemLists();
      if (paramAbsStructMsg != null)
      {
        int k = 0;
        while (k < paramAbsStructMsg.size())
        {
          AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)paramAbsStructMsg.get(k);
          if ((localAbsStructMsgElement instanceof StructMsgItemLayout2))
          {
            paramAbsStructMsg = (StructMsgItemLayout2)localAbsStructMsgElement;
            return (paramAbsStructMsg.o != 1) && (paramAbsStructMsg.o != 3);
          }
          k += 1;
        }
      }
    }
    return false;
  }
  
  private View b()
  {
    Object localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
    ((LinearLayout)localObject1).setOrientation(0);
    ((LinearLayout)localObject1).addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), new LinearLayout.LayoutParams(0, -2, 1.0F));
    int m = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID;
    int k = 1;
    if (m == 32) {}
    for (;;)
    {
      k = 0;
      break;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl))
      {
        if (!((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherArkPageUrl(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.trim())) {
          break;
        }
        if (this.jdField_a_of_type_AndroidContentIntent != null) {
          this.jdField_a_of_type_AndroidContentIntent.putExtra("k_back", true);
        }
      }
    }
    FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidAppActivity);
    localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    if (k != 0)
    {
      Object localObject2 = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
      ((ImageView)localObject2).setImageResource(2130840133);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.a(8.0F), ViewUtils.a(14.0F));
      localLayoutParams.setMargins(ViewUtils.a(7.0F), 0, 0, 0);
      localLayoutParams.gravity = 16;
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localObject2 = new View(this.jdField_a_of_type_AndroidAppActivity);
      ((View)localObject2).setBackgroundResource(2130840143);
      localFrameLayout.addView((View)localObject2, new FrameLayout.LayoutParams(-1, ViewUtils.a(33.0F), 16));
      ((View)localObject2).setOnClickListener(new ForwardPluginShareStructMsgOption.3(this));
      ((View)localObject2).setContentDescription(HardCodeUtil.a(2131704866));
    }
    localFrameLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
    localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_send_tips");
    if ((localObject1 != null) && ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog instanceof ForwardNewVersionDialog))) {
      ((ForwardNewVersionDialog)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog).a((String)localObject1);
    }
    return localFrameLayout;
  }
  
  private void b(int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isWebCompShare", false))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt);
      localBundle.putString("act_type", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(ReportDef.RepUtil.a(this.jdField_e_of_type_Int));
      localBundle.putString("intext_1", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(ReportDef.RepUtil.a(paramBundle.getInt("uintype"), paramBundle.getString("uin")));
      localBundle.putString("intext_2", localStringBuilder.toString());
      localBundle.putString("intext_3", "1");
      ReportCenter.a().a(localBundle, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    }
  }
  
  private void b(QQCustomDialog paramQQCustomDialog)
  {
    paramQQCustomDialog.setBodyLayoutNoMargin();
    Object localObject1 = new URLImageView(this.jdField_a_of_type_AndroidAppActivity);
    Object localObject2 = new LinearLayout.LayoutParams(-1, AIOUtils.b(152.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 114) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 116))
    {
      ((LinearLayout.LayoutParams)localObject2).leftMargin = AIOUtils.b(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      ((LinearLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    ((URLImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((URLImageView)localObject1).setBackgroundColor(Color.parseColor("#dcdfe4"));
    Object localObject3 = ChatHistoryStructAdapter.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, "cover");
    Drawable localDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130850831);
    boolean bool = TextUtils.isEmpty((CharSequence)localObject3);
    int m = 1;
    if (!bool)
    {
      localObject3 = URLDrawable.getDrawable((String)localObject3, (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131296897), AIOUtils.b(165.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), localDrawable, localDrawable, true);
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      if ((localObject3 != null) && (((URLDrawable)localObject3).getStatus() == 2)) {
        ((URLDrawable)localObject3).restartDownload();
      }
      if ((localObject3 != null) && (((URLDrawable)localObject3).getStatus() == 1))
      {
        ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((URLImageView)localObject1).setBackgroundDrawable(null);
      }
      else
      {
        ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ((URLImageView)localObject1).setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      }
      ((URLImageView)localObject1).setImageDrawable((Drawable)localObject3);
    }
    else
    {
      ((URLImageView)localObject1).setImageDrawable(localDrawable);
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
    paramQQCustomDialog.addView((View)localObject1, (LinearLayout.LayoutParams)localObject2);
    localObject1 = ChatHistoryStructAdapter.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, "title");
    localObject2 = new TextView(this.jdField_a_of_type_AndroidAppActivity);
    ((TextView)localObject2).setText((CharSequence)localObject1);
    ((TextView)localObject2).setTextSize(16.0F);
    ((TextView)localObject2).setIncludeFontPadding(false);
    ((TextView)localObject2).setTextColor(-16777216);
    int k = m;
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      k = m;
      if (this.jdField_a_of_type_AndroidOsBundle.getInt("title_max_line", -1) > 0) {
        k = this.jdField_a_of_type_AndroidOsBundle.getInt("title_max_line", 1);
      }
    }
    ((TextView)localObject2).setMaxLines(k);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setPadding(AIOUtils.b(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.b(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.b(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.b(20.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    paramQQCustomDialog.addView((View)localObject2);
  }
  
  private void c(Intent paramIntent)
  {
    if ("public_account".equals(this.h))
    {
      paramIntent = this.jdField_a_of_type_AndroidOsBundle.getString("pubUin");
      if (paramIntent == null) {
        paramIntent = "";
      }
      int k = -1;
      int m = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
      if (m != 0)
      {
        if (m != 1)
        {
          if (m != 3000)
          {
            m = 0;
          }
          else
          {
            k = 3;
            m = 1003;
          }
        }
        else
        {
          k = 2;
          m = 1002;
        }
      }
      else
      {
        k = 1;
        m = 1001;
      }
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_struct_forward", false))
      {
        this.jdField_a_of_type_AndroidContentIntent.getStringExtra("struct_uin");
        String str1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("strurt_msgid");
        if (str1 == null) {
          str1 = "";
        }
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("detail_url");
        if (str2 == null) {
          str2 = "";
        }
        String str3 = StructingMsgItemBuilder.a();
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(k);
        ReportController.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005456", "0X8005456", 0, 0, str3, str1, str2, localStringBuilder.toString());
      }
      ((IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent, "Pb_account_lifeservice", "mp_msg_sys_11", "pbshare_success", m);
      return;
    }
    if ("struct_msg_from_h5".equals(this.h))
    {
      paramIntent = this.jdField_a_of_type_AndroidOsBundle.getString("pubUin");
      if (!TextUtils.isEmpty(paramIntent)) {
        ((IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent, "Pb_account_lifeservice", "mp_msg_sys_31", "share_succ");
      }
    }
    else if (ForwardOptionUtils.a(paramIntent))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_AndroidOsBundle.getString("uin"), "Music_gene", "Music_gene_send", 0, 1, 0, "", "", "", "");
    }
  }
  
  private void d(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://article.mp.qq.com")) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("https://article.mp.qq.com")) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://post.mp.qq.com")) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("https://post.mp.qq.com")))
    {
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      Object localObject1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      Object localObject2 = this.jdField_i_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.f);
      ((IPublicAccountReportUtils)localObject1).publicAccountReportClickEvent(null, "", "0X8007236", "0X8007236", 0, 0, (String)localObject2, localStringBuilder.toString(), str, "");
      localObject1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      localObject2 = this.jdField_i_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.f);
      ((IPublicAccountReportUtils)localObject1).reportPAinfoToLighthouse("0X8007236", "", (String)localObject2, localStringBuilder.toString(), str, "");
      if ((!TextUtils.isEmpty(paramString)) || (!"".equals(paramString)))
      {
        paramString = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        localObject1 = this.jdField_i_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(this.f);
        paramString.publicAccountReportClickEvent(null, "", "0X8007237", "0X8007237", 0, 0, (String)localObject1, ((StringBuilder)localObject2).toString(), str, "");
      }
    }
  }
  
  private void e()
  {
    Object localObject1;
    if (c() != 0) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue();
    } else {
      localObject1 = "";
    }
    this.jdField_a_of_type_AndroidContentIntent.getAction();
    Object localObject2 = Boolean.valueOf(this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false));
    Object localObject3 = Boolean.valueOf(this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_back", false));
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("ForwardPluginShareStructMsgOption forwardOnConfirm isFromPlugin=");
      ((StringBuilder)localObject4).append(localObject2);
      ((StringBuilder)localObject4).append("iskeyBack=");
      ((StringBuilder)localObject4).append(localObject3);
      ((StringBuilder)localObject4).append("isNOneedJumpToAIO=");
      ((StringBuilder)localObject4).append(this.jdField_e_of_type_Boolean);
      QLog.d("forward", 2, ((StringBuilder)localObject4).toString());
    }
    Object localObject4 = b();
    if (((Boolean)localObject2).booleanValue())
    {
      localObject2 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), new int[] { 2 });
      this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", (String)localObject1);
      ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      a((Intent)localObject2);
      if (((Boolean)localObject3).booleanValue())
      {
        localObject3 = StructMsgFactory.a(((Intent)localObject2).getExtras());
        Object localObject5;
        Object localObject6;
        if ((this.jdField_e_of_type_Int == 13) && ((localObject3 instanceof StructMsgForGeneralShare)))
        {
          localObject5 = (StructMsgForGeneralShare)localObject3;
          localObject6 = new StringBuilder(((Intent)localObject2).getStringExtra("struct_share_key_content_action_DATA"));
          ((StringBuilder)localObject6).append("&msg=");
          ((StringBuilder)localObject6).append(((Intent)localObject2).getStringExtra("title"));
          ((StringBuilder)localObject6).append("&toUin=");
          ((StringBuilder)localObject6).append(this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
          ((StructMsgForGeneralShare)localObject5).mMsgActionData = ((StringBuilder)localObject6).toString();
        }
        if (((AbsStructMsg)localObject3).mMsgServiceID == 83) {
          ((AbsStructMsg)localObject3).mMsgActionData = "";
        }
        if ((((AbsStructMsg)localObject3).mMsgServiceID == 108) || (((AbsStructMsg)localObject3).mMsgServiceID == 114) || (((AbsStructMsg)localObject3).mMsgServiceID == 116)) {
          ((AbsStructMsg)localObject3).mMsgActionData = "";
        }
        localObject4 = ((List)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (ResultRecord)((Iterator)localObject4).next();
          localObject6 = ForwardUtils.a((Intent)localObject2, ((ResultRecord)localObject5).uin, ((ResultRecord)localObject5).getUinType(), ((ResultRecord)localObject5).groupUin);
          int k = ForwardOrderManager.a().a();
          ((AbsStructMsg)localObject3).forwardID = k;
          ForwardOrderManager.a().a((SessionInfo)localObject6, (String)localObject1, k);
          ShareMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ResultRecord)localObject5).uin, ((SessionInfo)localObject6).b, ((ResultRecord)localObject5).getUinType(), (AbsStructMsg)localObject3, null);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            AnonymousChatHelper.a().a = true;
          }
        }
      }
      localObject1 = ((List)localObject4).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (ResultRecord)((Iterator)localObject1).next();
        if (this.jdField_e_of_type_Boolean)
        {
          localObject3 = ForwardUtils.a((Intent)localObject2, ((ResultRecord)localObject3).uin, ((ResultRecord)localObject3).getUinType(), ((ResultRecord)localObject3).groupUin);
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (SessionInfo)localObject3, (Intent)localObject2);
        }
        else if (ForwardOptionUtils.a((Intent)localObject2))
        {
          localObject3 = ForwardUtils.a((Intent)localObject2, ((ResultRecord)localObject3).uin, ((ResultRecord)localObject3).getUinType(), ((ResultRecord)localObject3).groupUin);
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (SessionInfo)localObject3, (Intent)localObject2);
        }
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject1);
      c((Intent)localObject2);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    y();
  }
  
  private void e(String paramString)
  {
    ThreadManager.post(new ForwardPluginShareStructMsgOption.2(this, paramString), 5, null, true);
  }
  
  protected void B()
  {
    AbsStructMsg localAbsStructMsg = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
    if (localAbsStructMsg != null) {
      ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), localAbsStructMsg);
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  protected View a()
  {
    AbsShareMsg localAbsShareMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
    if (localAbsShareMsg == null) {
      return null;
    }
    if (localAbsShareMsg.mMsgServiceID == 33)
    {
      this.jdField_b_of_type_Int = 8;
      return b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 95)
    {
      this.jdField_b_of_type_Int = 9;
      return b();
    }
    return b();
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_e_of_type_Int == 13) || ("public_account".equals(this.h)) || ("web_share".equals(this.h)) || ("struct_msg_from_h5".equals(this.h)) || ("struct_favorite".equals(this.h)))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)paramList.next();
        if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (!a(localRecentUser.getType())) && ((localRecentUser.getType() != 1006) || (a(ForwardAbility.ForwardAbilityType.h))) && ((localRecentUser.getType() != 0) || (!CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() == 0) && (a(jdField_b_of_type_JavaLangInteger))) || ((localRecentUser.getType() == 1) && (!a(localRecentUser.uin)) && (a(c))) || ((localRecentUser.getType() == 3000) && (a(jdField_d_of_type_JavaLangInteger)) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.jdField_b_of_type_Boolean))))) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardPluginShareStructMsgOption forwardOnConfirm");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
    H();
    if (j())
    {
      e();
      return;
    }
    int k = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    int m = 0;
    Object localObject1;
    if (k == 1)
    {
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      if (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697407, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299168));
        return;
      }
    }
    b(82, this.jdField_a_of_type_AndroidOsBundle);
    if (this.jdField_d_of_type_Boolean)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.jdField_d_of_type_Boolean = false;
    }
    if (c() != 0) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue();
    } else {
      localObject1 = "";
    }
    d((String)localObject1);
    this.jdField_a_of_type_AndroidContentIntent.getAction();
    Object localObject2 = Boolean.valueOf(this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false));
    Object localObject3 = Boolean.valueOf(this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_back", false));
    Object localObject4;
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("ForwardPluginShareStructMsgOption forwardOnConfirm isFromPlugin=");
      ((StringBuilder)localObject4).append(localObject2);
      ((StringBuilder)localObject4).append("iskeyBack=");
      ((StringBuilder)localObject4).append(localObject3);
      ((StringBuilder)localObject4).append("isNOneedJumpToAIO=");
      ((StringBuilder)localObject4).append(this.jdField_e_of_type_Boolean);
      QLog.d("forward", 2, ((StringBuilder)localObject4).toString());
    }
    if (((Boolean)localObject2).booleanValue())
    {
      localObject2 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), new int[] { 2 });
      this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", (String)localObject1);
      ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      a((Intent)localObject2);
      if (((Boolean)localObject3).booleanValue())
      {
        localObject3 = StructMsgFactory.a(((Intent)localObject2).getExtras());
        if ((this.jdField_e_of_type_Int == 13) && ((localObject3 instanceof StructMsgForGeneralShare)))
        {
          localObject4 = (StructMsgForGeneralShare)localObject3;
          StringBuilder localStringBuilder = new StringBuilder(((Intent)localObject2).getStringExtra("struct_share_key_content_action_DATA"));
          localStringBuilder.append("&msg=");
          localStringBuilder.append(((Intent)localObject2).getStringExtra("title"));
          localStringBuilder.append("&toUin=");
          localStringBuilder.append(this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
          ((StructMsgForGeneralShare)localObject4).mMsgActionData = localStringBuilder.toString();
        }
        if (((AbsStructMsg)localObject3).mMsgServiceID == 83) {
          ((AbsStructMsg)localObject3).mMsgActionData = "";
        }
        if ((((AbsStructMsg)localObject3).mMsgServiceID == 108) || (((AbsStructMsg)localObject3).mMsgServiceID == 114) || (((AbsStructMsg)localObject3).mMsgServiceID == 116))
        {
          if (((AbsStructMsg)localObject3).getSourceName().equals("QQ动漫")) {
            ((AbsStructMsg)localObject3).mMsg_A_ActionData = ((AbsStructMsg)localObject3).mMsgActionData;
          }
          ((AbsStructMsg)localObject3).mMsgActionData = "";
        }
        localObject4 = ForwardUtils.a((Intent)localObject2);
        k = ForwardOrderManager.a().a();
        ((AbsStructMsg)localObject3).forwardID = k;
        ForwardOrderManager.a().a((SessionInfo)localObject4, (String)localObject1, k);
        ShareMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsBundle.getString("uin"), ((SessionInfo)localObject4).b, this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), (AbsStructMsg)localObject3, null);
        k = m;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          AnonymousChatHelper.a().a = true;
          k = m;
        }
      }
      else if (this.jdField_e_of_type_Boolean)
      {
        localObject1 = ForwardUtils.a((Intent)localObject2);
        if (!WebShareConfigProcessor.a().a)
        {
          this.jdField_a_of_type_AndroidContentIntent.putExtra("is_need_show_toast", false);
          this.jdField_i_of_type_Boolean = true;
          ForwardPluginShareWebViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (SessionInfo)localObject1, (Intent)localObject2);
          k = 1;
        }
        else
        {
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (SessionInfo)localObject1, (Intent)localObject2);
          k = m;
        }
      }
      else
      {
        if (ForwardOptionUtils.a((Intent)localObject2))
        {
          localObject1 = ForwardUtils.a((Intent)localObject2);
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (SessionInfo)localObject1, (Intent)localObject2);
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
        k = m;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject1);
      c((Intent)localObject2);
      b(83, this.jdField_a_of_type_AndroidOsBundle);
      if (k == 0) {
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
    }
    else
    {
      y();
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    b(81, paramBundle);
    super.a(paramInt, paramBundle);
  }
  
  public void a(AbsStructMsg paramAbsStructMsg)
  {
    if (paramAbsStructMsg != null)
    {
      if (!(paramAbsStructMsg instanceof StructMsgForGeneralShare)) {
        return;
      }
      paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).getStructMsgItemLists();
      if (paramAbsStructMsg != null)
      {
        if (paramAbsStructMsg.size() == 0) {
          return;
        }
        paramAbsStructMsg = paramAbsStructMsg.iterator();
        Object localObject1;
        while (paramAbsStructMsg.hasNext())
        {
          localObject1 = (AbsStructMsgElement)paramAbsStructMsg.next();
          if ((localObject1 instanceof StructMsgItemLayout2))
          {
            paramAbsStructMsg = (StructMsgItemLayout2)localObject1;
            break label80;
          }
        }
        paramAbsStructMsg = null;
        label80:
        if (paramAbsStructMsg == null) {
          return;
        }
        paramAbsStructMsg = paramAbsStructMsg.a;
        if (paramAbsStructMsg != null)
        {
          if (paramAbsStructMsg.size() == 0) {
            return;
          }
          localObject1 = paramAbsStructMsg.iterator();
          paramAbsStructMsg = null;
          Object localObject2;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
            if ((localObject2 instanceof StructMsgItemSummary)) {
              paramAbsStructMsg = (StructMsgItemSummary)localObject2;
            }
          }
          if (paramAbsStructMsg == null) {
            return;
          }
          localObject1 = paramAbsStructMsg.b();
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            return;
          }
          IEmoticonManagerService localIEmoticonManagerService = (IEmoticonManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonManagerService.class);
          StringBuilder localStringBuilder = new StringBuilder((String)localObject1);
          int m;
          for (int k = 0; k < localStringBuilder.length(); k = m + 1)
          {
            m = k;
            if ('ÿ' == localStringBuilder.charAt(k))
            {
              int n = k + 3;
              m = k;
              if (n < localStringBuilder.length())
              {
                localObject1 = new char[4];
                localObject1[0] = localStringBuilder.charAt(n);
                localObject1[1] = localStringBuilder.charAt(k + 2);
                localObject1[2] = localStringBuilder.charAt(k + 1);
                localObject1[3] = localStringBuilder.charAt(k);
                m = 0;
                while (m < 4)
                {
                  if (localObject1[m] == 'ú') {
                    localObject1[m] = 10;
                  } else if (localObject1[m] == 'þ') {
                    localObject1[m] = 13;
                  } else if (localObject1[m] == 'ý') {
                    localObject1[m] = 20;
                  }
                  m += 1;
                }
                int[] arrayOfInt = EmosmUtils.a((char[])localObject1);
                localObject2 = QQText.SMALL_EMOJI_SYMBOL;
                if (localIEmoticonManagerService != null) {
                  localObject1 = localIEmoticonManagerService.syncFindEmoticonById(Integer.toString(arrayOfInt[0]), Integer.toString(arrayOfInt[1]));
                } else {
                  localObject1 = null;
                }
                if (localObject1 != null)
                {
                  localObject1 = ((Emoticon)localObject1).character;
                }
                else
                {
                  e(Integer.toString(arrayOfInt[0]));
                  localObject1 = localObject2;
                }
                localStringBuilder.replace(k, n, (String)localObject1);
                m = k + ((String)localObject1).length();
              }
            }
          }
          if (!TextUtils.isEmpty(localStringBuilder)) {
            paramAbsStructMsg.a(localStringBuilder.toString());
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardPluginShareStructMsgOption preloadData");
    }
    super.a();
    this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("req_type", 2147483647);
    this.h = this.jdField_a_of_type_AndroidOsBundle.getString("pluginName");
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward _key_nojump", false);
    Object localObject = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle.getByteArray("stuctmsg_bytes"));
    if ((localObject != null) && ((localObject instanceof AbsShareMsg))) {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
    if (localObject == null) {
      return true;
    }
    if ((((AbsShareMsg)localObject).mMsgServiceID != 83) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 108) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 114) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 116) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 151) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 156))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://article.mp.qq.com")) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("https://article.mp.qq.com")) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://post.mp.qq.com")) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("https://post.mp.qq.com")))
      {
        this.f = 1;
        this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 2);
      }
    }
    else
    {
      this.jdField_j_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 3);
      this.f = 2;
    }
    localObject = Uri.parse(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl);
    try
    {
      this.jdField_i_of_type_JavaLangString = ((Uri)localObject).getQueryParameter("article_id");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (this.jdField_i_of_type_JavaLangString == null) {
      this.jdField_i_of_type_JavaLangString = "";
    }
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isWebCompShare", false))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "80");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(ReportDef.RepUtil.a(this.jdField_e_of_type_Int));
      localBundle.putString("intext_1", localStringBuilder.toString());
      localBundle.putString("intext_3", "1");
      ReportCenter.a().a(localBundle, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    }
    return true;
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentIntent.getByteArrayExtra("stuctmsg_bytes");
    if (localObject != null)
    {
      localObject = StructMsgFactory.a((byte[])localObject);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      a((AbsStructMsg)localObject);
      boolean bool = a((AbsStructMsg)localObject);
      if ((localObject instanceof StructMsgForAudioShare))
      {
        localLayoutParams.setMargins(0, AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.b(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      }
      else if (bool)
      {
        localLayoutParams.setMargins(0, 0, 0, 0);
        paramQQCustomDialog.adjustMessageTopBottomMargin(0.0F, 0.0F);
      }
      else
      {
        localLayoutParams.setMargins(AIOUtils.b(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.b(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      }
      if (this.jdField_j_of_type_Boolean)
      {
        b(paramQQCustomDialog);
        return false;
      }
      paramQQCustomDialog.addView(((AbsStructMsg)localObject).getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), localLayoutParams);
      if (!bool) {
        a(((AbsStructMsg)localObject).getSourceName(), paramQQCustomDialog);
      }
    }
    return true;
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    localObject = new LightAppUtil();
    int m = paramArrayOfDeviceInfo.length;
    int k = 0;
    while (k < m)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[k];
      if (localDeviceInfo != null)
      {
        LightAppSettingInfo localLightAppSettingInfo = ((LightAppUtil)localObject).a(localDeviceInfo);
        if ((a(jdField_j_of_type_JavaLangInteger)) && (super.a(localLightAppSettingInfo))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      k += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  protected void b()
  {
    int k = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("shareQQType", 13);
    if (((k & 0x8) != 0) && (p())) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_d_of_type_JavaLangInteger);
    }
    if (((k & 0x4) != 0) && (q())) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (((k & 0x1) != 0) && (r())) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (super.s()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_j_of_type_JavaLangInteger);
    }
  }
  
  protected int d()
  {
    String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("detail_url");
    boolean bool = TextUtils.isEmpty(str);
    int m = -1;
    int k = m;
    if (!bool)
    {
      k = m;
      if (QfavBuilder.a(str).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
        k = 0;
      }
    }
    if (k == 0) {
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", -1, 0, 69, 0, "", "");
    }
    return k;
  }
  
  protected boolean m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgId = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID);
      QLog.e("ForwardOption.ForwardPluginShareStructMsgOption", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 33)
    {
      this.jdField_b_of_type_Int = 8;
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 95)
    {
      this.jdField_b_of_type_Int = 9;
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl != null) && (a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg)))
    {
      this.jdField_b_of_type_Int = 8;
      return true;
    }
    return false;
  }
  
  protected void t()
  {
    super.t();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "1", "", "", "");
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_struct_forward", false)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005457", "0X8005457", 0, 0, "", "", "android", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://article.mp.qq.com")) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("https://article.mp.qq.com")) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://post.mp.qq.com")) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("https://post.mp.qq.com")))
    {
      String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      String str2 = this.jdField_i_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.f);
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X8007235", "0X8007235", 0, 0, str2, localStringBuilder.toString(), str1, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption
 * JD-Core Version:    0.7.0.1
 */