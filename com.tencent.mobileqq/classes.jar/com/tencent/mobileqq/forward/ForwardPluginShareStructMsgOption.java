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
import com.tencent.mobileqq.guild.forwardshare.api.IGuildShareForwardApi;
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
import com.tencent.mobileqq.utils.SimpleModeHelper;
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
  private static final int[] aj = { 1020, 1008, 1005, 1009, 1021, 1001, 10002, 10004, 1022, 7000, 6004, 9501 };
  AbsShareMsg a;
  boolean ad = false;
  int ae;
  String af;
  String ag = "";
  int ah;
  private URLDrawableDownListener.Adapter ai = new ForwardPluginShareStructMsgOption.1(this);
  
  public ForwardPluginShareStructMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  private void a(String paramString)
  {
    if ((this.a.mMsgUrl.startsWith("http://article.mp.qq.com")) || (this.a.mMsgUrl.startsWith("https://article.mp.qq.com")) || (this.a.mMsgUrl.startsWith("http://post.mp.qq.com")) || (this.a.mMsgUrl.startsWith("https://post.mp.qq.com")))
    {
      String str = this.t.getString("uin");
      Object localObject1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      Object localObject2 = this.ag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.ah);
      ((IPublicAccountReportUtils)localObject1).publicAccountReportClickEvent(null, "", "0X8007236", "0X8007236", 0, 0, (String)localObject2, localStringBuilder.toString(), str, "");
      localObject1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      localObject2 = this.ag;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.ah);
      ((IPublicAccountReportUtils)localObject1).reportPAinfoToLighthouse("0X8007236", "", (String)localObject2, localStringBuilder.toString(), str, "");
      if ((!TextUtils.isEmpty(paramString)) || (!"".equals(paramString)))
      {
        paramString = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        localObject1 = this.ag;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(this.ah);
        paramString.publicAccountReportClickEvent(null, "", "0X8007237", "0X8007237", 0, 0, (String)localObject1, ((StringBuilder)localObject2).toString(), str, "");
      }
    }
  }
  
  private void au()
  {
    if (!TextUtils.isEmpty(this.a.mMsgUrl))
    {
      String str = this.a.mMsgUrl.trim();
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
        TeamWorkDocEditBrowserActivity.a(this.s, (Bundle)localObject, false);
      }
      else
      {
        localObject = new Intent(this.s, QQBrowserDelegationActivity.class);
        ((Intent)localObject).putExtra("param_force_internal_browser", true);
        ((Intent)localObject).putExtra("reqType", 7);
        ((Intent)localObject).putExtra("hideRightButton", true);
        ((Intent)localObject).putExtra("hide_more_button", true);
        ((Intent)localObject).putExtra("url", str);
        WebAccelerator.a(this.s, (Intent)localObject, str);
      }
      aq();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ForwardOption.ForwardPluginShareStructMsgOption", 2, "empty url");
    }
  }
  
  private void b(int paramInt, Bundle paramBundle)
  {
    if (this.r.getBooleanExtra("isWebCompShare", false))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt);
      localBundle.putString("act_type", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(ReportDef.RepUtil.a(this.ae));
      localBundle.putString("intext_1", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(ReportDef.RepUtil.a(paramBundle.getInt("uintype"), paramBundle.getString("uin")));
      localBundle.putString("intext_2", localStringBuilder.toString());
      localBundle.putString("intext_3", "1");
      ReportCenter.a().a(localBundle, "", this.q.getCurrentAccountUin(), false);
    }
  }
  
  private boolean b(AbsStructMsg paramAbsStructMsg)
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
  
  private void c(QQCustomDialog paramQQCustomDialog)
  {
    paramQQCustomDialog.setBodyLayoutNoMargin();
    Object localObject1 = new URLImageView(this.s);
    Object localObject2 = new LinearLayout.LayoutParams(-1, AIOUtils.b(152.0F, this.s.getResources()));
    if ((this.a.mMsgServiceID == 114) || (this.a.mMsgServiceID == 116))
    {
      ((LinearLayout.LayoutParams)localObject2).leftMargin = AIOUtils.b(24.0F, this.s.getResources());
      ((LinearLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(24.0F, this.s.getResources());
    }
    ((URLImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((URLImageView)localObject1).setBackgroundColor(Color.parseColor("#dcdfe4"));
    Object localObject3 = ChatHistoryStructAdapter.a(this.a, "cover");
    Drawable localDrawable = this.s.getResources().getDrawable(2130852666);
    boolean bool = TextUtils.isEmpty((CharSequence)localObject3);
    int j = 1;
    if (!bool)
    {
      localObject3 = URLDrawable.getDrawable((String)localObject3, (int)this.s.getResources().getDimension(2131297276), AIOUtils.b(165.0F, this.s.getResources()), localDrawable, localDrawable, true);
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
        ((URLImageView)localObject1).setURLDrawableDownListener(this.ai);
      }
      ((URLImageView)localObject1).setImageDrawable((Drawable)localObject3);
    }
    else
    {
      ((URLImageView)localObject1).setImageDrawable(localDrawable);
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
    paramQQCustomDialog.addView((View)localObject1, (LinearLayout.LayoutParams)localObject2);
    localObject1 = ChatHistoryStructAdapter.a(this.a, "title");
    localObject2 = new TextView(this.s);
    ((TextView)localObject2).setText((CharSequence)localObject1);
    ((TextView)localObject2).setTextSize(16.0F);
    ((TextView)localObject2).setIncludeFontPadding(false);
    ((TextView)localObject2).setTextColor(-16777216);
    int i = j;
    if (this.t != null)
    {
      i = j;
      if (this.t.getInt("title_max_line", -1) > 0) {
        i = this.t.getInt("title_max_line", 1);
      }
    }
    ((TextView)localObject2).setMaxLines(i);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setPadding(AIOUtils.b(24.0F, this.s.getResources()), AIOUtils.b(8.0F, this.s.getResources()), AIOUtils.b(24.0F, this.s.getResources()), AIOUtils.b(20.0F, this.s.getResources()));
    paramQQCustomDialog.addView((View)localObject2);
  }
  
  private void d(Intent paramIntent)
  {
    if ("public_account".equals(this.af))
    {
      paramIntent = this.t.getString("pubUin");
      if (paramIntent == null) {
        paramIntent = "";
      }
      int i = -1;
      int j = this.t.getInt("uintype");
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 3000)
          {
            j = 0;
          }
          else
          {
            i = 3;
            j = 1003;
          }
        }
        else
        {
          i = 2;
          j = 1002;
        }
      }
      else
      {
        i = 1;
        j = 1001;
      }
      if (this.r.getBooleanExtra("k_struct_forward", false))
      {
        this.r.getStringExtra("struct_uin");
        String str1 = this.r.getStringExtra("strurt_msgid");
        if (str1 == null) {
          str1 = "";
        }
        String str2 = this.r.getStringExtra("detail_url");
        if (str2 == null) {
          str2 = "";
        }
        String str3 = StructingMsgItemBuilder.h();
        QQAppInterface localQQAppInterface = this.q;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i);
        ReportController.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005456", "0X8005456", 0, 0, str3, str1, str2, localStringBuilder.toString());
      }
      ((IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.q, paramIntent, "Pb_account_lifeservice", "mp_msg_sys_11", "pbshare_success", j);
      return;
    }
    if ("struct_msg_from_h5".equals(this.af))
    {
      paramIntent = this.t.getString("pubUin");
      if (!TextUtils.isEmpty(paramIntent)) {
        ((IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.q, paramIntent, "Pb_account_lifeservice", "mp_msg_sys_31", "share_succ");
      }
    }
    else if (ForwardOptionUtils.a(paramIntent))
    {
      ReportController.b(this.q, "CliOper", "", this.t.getString("uin"), "Music_gene", "Music_gene_send", 0, 1, 0, "", "", "", "");
    }
  }
  
  private void f(String paramString)
  {
    ThreadManager.post(new ForwardPluginShareStructMsgOption.2(this, paramString), 5, null, true);
  }
  
  private static boolean f(int paramInt)
  {
    int[] arrayOfInt = aj;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramInt == arrayOfInt[i]) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void o()
  {
    Object localObject1;
    if (F() != 0) {
      localObject1 = this.A.getInputValue();
    } else {
      localObject1 = "";
    }
    this.r.getAction();
    Object localObject2 = Boolean.valueOf(this.r.getBooleanExtra("key_flag_from_plugin", false));
    Object localObject3 = Boolean.valueOf(this.r.getBooleanExtra("k_back", false));
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("ForwardPluginShareStructMsgOption forwardOnConfirm isFromPlugin=");
      ((StringBuilder)localObject4).append(localObject2);
      ((StringBuilder)localObject4).append("iskeyBack=");
      ((StringBuilder)localObject4).append(localObject3);
      ((StringBuilder)localObject4).append("isNOneedJumpToAIO=");
      ((StringBuilder)localObject4).append(this.J);
      QLog.d("forward", 2, ((StringBuilder)localObject4).toString());
    }
    Object localObject4 = M();
    if (((Boolean)localObject2).booleanValue())
    {
      localObject2 = AIOUtils.a(new Intent(this.s, SplashActivity.class), new int[] { 2 });
      this.t.putString("share_comment_message", (String)localObject1);
      ((Intent)localObject2).putExtras(this.t);
      c((Intent)localObject2);
      if (((Boolean)localObject3).booleanValue())
      {
        localObject3 = StructMsgFactory.a(((Intent)localObject2).getExtras());
        Object localObject5;
        Object localObject6;
        if ((this.ae == 13) && ((localObject3 instanceof StructMsgForGeneralShare)))
        {
          localObject5 = (StructMsgForGeneralShare)localObject3;
          localObject6 = new StringBuilder(((Intent)localObject2).getStringExtra("struct_share_key_content_action_DATA"));
          ((StringBuilder)localObject6).append("&msg=");
          ((StringBuilder)localObject6).append(((Intent)localObject2).getStringExtra("title"));
          ((StringBuilder)localObject6).append("&toUin=");
          ((StringBuilder)localObject6).append(this.t.getString("uin"));
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
          int i = ForwardOrderManager.a().b();
          ((AbsStructMsg)localObject3).forwardID = i;
          ForwardOrderManager.a().a((SessionInfo)localObject6, (String)localObject1, i);
          ShareMsgHelper.a(this.q, ((ResultRecord)localObject5).uin, ((SessionInfo)localObject6).c, ((ResultRecord)localObject5).getUinType(), (AbsStructMsg)localObject3, null);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            AnonymousChatHelper.a().j = true;
          }
        }
      }
      localObject1 = ((List)localObject4).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (ResultRecord)((Iterator)localObject1).next();
        if (this.J)
        {
          localObject3 = ForwardUtils.a((Intent)localObject2, ((ResultRecord)localObject3).uin, ((ResultRecord)localObject3).getUinType(), ((ResultRecord)localObject3).groupUin);
          ForwardUtils.a(this.q, this.I, (SessionInfo)localObject3, (Intent)localObject2);
        }
        else if (ForwardOptionUtils.a((Intent)localObject2))
        {
          localObject3 = ForwardUtils.a((Intent)localObject2, ((ResultRecord)localObject3).uin, ((ResultRecord)localObject3).getUinType(), ((ResultRecord)localObject3).groupUin);
          ForwardUtils.a(this.q, this.I, (SessionInfo)localObject3, (Intent)localObject2);
        }
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtras(this.t);
      this.s.setResult(-1, (Intent)localObject1);
      d((Intent)localObject2);
      this.s.finish();
      return;
    }
    ab();
  }
  
  private View p()
  {
    Object localObject1 = new LinearLayout(this.s);
    ((LinearLayout)localObject1).setOrientation(0);
    ((LinearLayout)localObject1).addView(this.a.getPreDialogView(this.s, null), new LinearLayout.LayoutParams(0, -2, 1.0F));
    int j = this.a.mMsgServiceID;
    int i = 1;
    if (j == 32) {}
    for (;;)
    {
      i = 0;
      break;
      if (!TextUtils.isEmpty(this.a.mMsgUrl))
      {
        if (!((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherArkPageUrl(this.a.mMsgUrl.trim())) {
          break;
        }
        if (this.r != null) {
          this.r.putExtra("k_back", true);
        }
      }
    }
    FrameLayout localFrameLayout = new FrameLayout(this.s);
    localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    if (i != 0)
    {
      Object localObject2 = new ImageView(this.s);
      ((ImageView)localObject2).setImageResource(2130840437);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(8.0F), ViewUtils.dip2px(14.0F));
      localLayoutParams.setMargins(ViewUtils.dip2px(7.0F), 0, 0, 0);
      localLayoutParams.gravity = 16;
      SimpleModeHelper.a(null, (ImageView)localObject2, localLayoutParams);
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localObject2 = new View(this.s);
      ((View)localObject2).setBackgroundResource(2130840448);
      localFrameLayout.addView((View)localObject2, new FrameLayout.LayoutParams(-1, ViewUtils.dip2px(33.0F), 16));
      ((View)localObject2).setOnClickListener(new ForwardPluginShareStructMsgOption.3(this));
      ((View)localObject2).setContentDescription(HardCodeUtil.a(2131902762));
    }
    localFrameLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
    localObject1 = this.r.getStringExtra("key_send_tips");
    if ((localObject1 != null) && ((this.A instanceof ForwardNewVersionDialog))) {
      ((ForwardNewVersionDialog)this.A).a((String)localObject1);
    }
    return localFrameLayout;
  }
  
  protected void W()
  {
    super.W();
    ReportController.b(this.q, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "1", "", "", "");
    if (this.r.getBooleanExtra("k_struct_forward", false)) {
      ReportController.b(this.q, "P_CliOper", "Pb_account_lifeservice", "", "0X8005457", "0X8005457", 0, 0, "", "", "android", "");
    }
    if ((this.a.mMsgUrl.startsWith("http://article.mp.qq.com")) || (this.a.mMsgUrl.startsWith("https://article.mp.qq.com")) || (this.a.mMsgUrl.startsWith("http://post.mp.qq.com")) || (this.a.mMsgUrl.startsWith("https://post.mp.qq.com")))
    {
      String str1 = this.t.getString("uin");
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      String str2 = this.ag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.ah);
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X8007235", "0X8007235", 0, 0, str2, localStringBuilder.toString(), str1, "");
    }
  }
  
  protected View a()
  {
    AbsShareMsg localAbsShareMsg = this.a;
    if (localAbsShareMsg == null) {
      return null;
    }
    if (localAbsShareMsg.mMsgServiceID == 33)
    {
      this.L = 8;
      return p();
    }
    if (this.a.mMsgServiceID == 95)
    {
      this.L = 9;
      return p();
    }
    return p();
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.ae == 13) || ("public_account".equals(this.af)) || ("web_share".equals(this.af)) || ("struct_msg_from_h5".equals(this.af)) || ("struct_favorite".equals(this.af)))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)paramList.next();
        if ((localRecentUser != null) && (!Utils.b(localRecentUser.uin)) && (!f(localRecentUser.getType())) && ((localRecentUser.getType() != 1006) || (a(ForwardAbility.ForwardAbilityType.i))) && ((localRecentUser.getType() != 0) || (!CrmUtils.a(this.q, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() == 0) && (a(c))) || ((localRecentUser.getType() == 1) && (!c(localRecentUser.uin)) && (a(d))) || ((localRecentUser.getType() == 3000) && (a(e)) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.E))))) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
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
        paramAbsStructMsg = paramAbsStructMsg.ax;
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
          localObject1 = paramAbsStructMsg.e();
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            return;
          }
          IEmoticonManagerService localIEmoticonManagerService = (IEmoticonManagerService)this.q.getRuntimeService(IEmoticonManagerService.class);
          StringBuilder localStringBuilder = new StringBuilder((String)localObject1);
          int j;
          for (int i = 0; i < localStringBuilder.length(); i = j + 1)
          {
            j = i;
            if ('ÿ' == localStringBuilder.charAt(i))
            {
              int k = i + 3;
              j = i;
              if (k < localStringBuilder.length())
              {
                localObject1 = new char[4];
                localObject1[0] = localStringBuilder.charAt(k);
                localObject1[1] = localStringBuilder.charAt(i + 2);
                localObject1[2] = localStringBuilder.charAt(i + 1);
                localObject1[3] = localStringBuilder.charAt(i);
                j = 0;
                while (j < 4)
                {
                  if (localObject1[j] == 'ú') {
                    localObject1[j] = 10;
                  } else if (localObject1[j] == 'þ') {
                    localObject1[j] = 13;
                  } else if (localObject1[j] == 'ý') {
                    localObject1[j] = 20;
                  }
                  j += 1;
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
                  f(Integer.toString(arrayOfInt[0]));
                  localObject1 = localObject2;
                }
                localStringBuilder.replace(i, k, (String)localObject1);
                j = i + ((String)localObject1).length();
              }
            }
          }
          if (!TextUtils.isEmpty(localStringBuilder)) {
            paramAbsStructMsg.b(localStringBuilder.toString());
          }
        }
      }
    }
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    Object localObject = this.r.getByteArrayExtra("stuctmsg_bytes");
    if (localObject != null)
    {
      localObject = StructMsgFactory.a((byte[])localObject);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      a((AbsStructMsg)localObject);
      boolean bool = b((AbsStructMsg)localObject);
      if ((localObject instanceof StructMsgForAudioShare))
      {
        localLayoutParams.setMargins(0, AIOUtils.b(5.0F, this.s.getResources()), 0, AIOUtils.b(10.0F, this.s.getResources()));
      }
      else if (bool)
      {
        localLayoutParams.setMargins(0, 0, 0, 0);
        paramQQCustomDialog.adjustMessageTopBottomMargin(0.0F, 0.0F);
      }
      else
      {
        localLayoutParams.setMargins(AIOUtils.b(-15.0F, this.s.getResources()), 0, AIOUtils.b(-15.0F, this.s.getResources()), AIOUtils.b(5.0F, this.s.getResources()));
      }
      if (this.ad)
      {
        c(paramQQCustomDialog);
        return false;
      }
      paramQQCustomDialog.addView(((AbsStructMsg)localObject).getPreDialogView(this.s, null), localLayoutParams);
      if (!bool) {
        a(((AbsStructMsg)localObject).getSourceName(), paramQQCustomDialog);
      }
    }
    return true;
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
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardPluginShareStructMsgOption forwardOnConfirm");
    }
    int i = this.t.getInt("uintype");
    Object localObject1 = "";
    if (i == 10014)
    {
      localObject2 = this.t.getString("uin");
      localObject3 = this.t.getString("guild_id");
      if (F() != 0) {
        localObject1 = this.A.getInputValue();
      }
      this.t.putString("share_leave_message", (String)localObject1);
      ((IGuildShareForwardApi)this.q.getRuntimeService(IGuildShareForwardApi.class)).ShareForwardMsg((String)localObject2, (String)localObject3, this.t);
      return;
    }
    ReportController.b(this.q, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
    ar();
    if (K())
    {
      o();
      return;
    }
    i = this.t.getInt("uintype");
    int j = 0;
    if (i == 1)
    {
      localObject1 = this.t.getString("uin");
      if (((TroopGagMgr)this.q.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a((String)localObject1, this.q.getCurrentUin()))
      {
        QQToast.makeText(this.q.getApp(), 2131895180, 0).show(this.s.getResources().getDimensionPixelSize(2131299920));
        return;
      }
    }
    b(82, this.t);
    if (this.H)
    {
      ReportController.b(this.q, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.H = false;
    }
    if (F() != 0) {
      localObject1 = this.A.getInputValue();
    } else {
      localObject1 = "";
    }
    a((String)localObject1);
    this.r.getAction();
    Object localObject2 = Boolean.valueOf(this.r.getBooleanExtra("key_flag_from_plugin", false));
    Object localObject3 = Boolean.valueOf(this.r.getBooleanExtra("k_back", false));
    Object localObject4;
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("ForwardPluginShareStructMsgOption forwardOnConfirm isFromPlugin=");
      ((StringBuilder)localObject4).append(localObject2);
      ((StringBuilder)localObject4).append("iskeyBack=");
      ((StringBuilder)localObject4).append(localObject3);
      ((StringBuilder)localObject4).append("isNOneedJumpToAIO=");
      ((StringBuilder)localObject4).append(this.J);
      QLog.d("forward", 2, ((StringBuilder)localObject4).toString());
    }
    if (((Boolean)localObject2).booleanValue())
    {
      localObject2 = AIOUtils.a(new Intent(this.s, SplashActivity.class), new int[] { 2 });
      this.t.putString("share_comment_message", (String)localObject1);
      ((Intent)localObject2).putExtras(this.t);
      c((Intent)localObject2);
      if (((Boolean)localObject3).booleanValue())
      {
        localObject3 = StructMsgFactory.a(((Intent)localObject2).getExtras());
        if ((this.ae == 13) && ((localObject3 instanceof StructMsgForGeneralShare)))
        {
          localObject4 = (StructMsgForGeneralShare)localObject3;
          StringBuilder localStringBuilder = new StringBuilder(((Intent)localObject2).getStringExtra("struct_share_key_content_action_DATA"));
          localStringBuilder.append("&msg=");
          localStringBuilder.append(((Intent)localObject2).getStringExtra("title"));
          localStringBuilder.append("&toUin=");
          localStringBuilder.append(this.t.getString("uin"));
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
        i = ForwardOrderManager.a().b();
        ((AbsStructMsg)localObject3).forwardID = i;
        ForwardOrderManager.a().a((SessionInfo)localObject4, (String)localObject1, i);
        ShareMsgHelper.a(this.q, this.t.getString("uin"), ((SessionInfo)localObject4).c, this.t.getInt("uintype"), (AbsStructMsg)localObject3, null);
        i = j;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          AnonymousChatHelper.a().j = true;
          i = j;
        }
      }
      else if (this.J)
      {
        localObject1 = ForwardUtils.a((Intent)localObject2);
        if (!WebShareConfigProcessor.a().a)
        {
          this.r.putExtra("is_need_show_toast", false);
          this.S = true;
          ForwardPluginShareWebViewHelper.a(this.q, this.s, (SessionInfo)localObject1, (Intent)localObject2);
          i = 1;
        }
        else
        {
          ForwardUtils.a(this.q, this.I, (SessionInfo)localObject1, (Intent)localObject2);
          i = j;
        }
      }
      else
      {
        if (ForwardOptionUtils.a((Intent)localObject2))
        {
          localObject1 = ForwardUtils.a((Intent)localObject2);
          ForwardUtils.a(this.q, this.I, (SessionInfo)localObject1, (Intent)localObject2);
        }
        this.s.startActivity((Intent)localObject2);
        i = j;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtras(this.t);
      this.s.setResult(-1, (Intent)localObject1);
      d((Intent)localObject2);
      b(83, this.t);
      if (i == 0) {
        this.s.finish();
      }
    }
    else
    {
      ab();
    }
  }
  
  protected void c()
  {
    int i = this.r.getIntExtra("shareQQType", 13);
    if (((i & 0x8) != 0) && (ag())) {
      this.C.add(e);
    }
    if (((i & 0x4) != 0) && (ah())) {
      this.C.add(d);
    }
    if (((i & 0x1) != 0) && (ai())) {
      this.C.add(c);
    }
    if (super.aj()) {
      this.C.add(k);
    }
  }
  
  public boolean e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardPluginShareStructMsgOption preloadData");
    }
    super.e();
    this.ae = this.r.getIntExtra("req_type", 2147483647);
    this.af = this.t.getString("pluginName");
    this.J = this.r.getBooleanExtra("forward _key_nojump", false);
    Object localObject = StructMsgFactory.a(this.t.getByteArray("stuctmsg_bytes"));
    if ((localObject != null) && ((localObject instanceof AbsShareMsg))) {
      this.a = ((AbsShareMsg)localObject);
    }
    localObject = this.a;
    if (localObject == null) {
      return true;
    }
    if ((((AbsShareMsg)localObject).mMsgServiceID != 83) && (this.a.mMsgServiceID != 108) && (this.a.mMsgServiceID != 114) && (this.a.mMsgServiceID != 116) && (this.a.mMsgServiceID != 151) && (this.a.mMsgServiceID != 156))
    {
      if ((this.a.mMsgUrl.startsWith("http://article.mp.qq.com")) || (this.a.mMsgUrl.startsWith("https://article.mp.qq.com")) || (this.a.mMsgUrl.startsWith("http://post.mp.qq.com")) || (this.a.mMsgUrl.startsWith("https://post.mp.qq.com")))
      {
        this.ah = 1;
        this.t.putInt("emoInputType", 2);
      }
    }
    else
    {
      this.ad = true;
      this.t.putInt("emoInputType", 3);
      this.ah = 2;
    }
    localObject = Uri.parse(this.a.mMsgUrl);
    try
    {
      this.ag = ((Uri)localObject).getQueryParameter("article_id");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (this.ag == null) {
      this.ag = "";
    }
    if (this.r.getBooleanExtra("isWebCompShare", false))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "80");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(ReportDef.RepUtil.a(this.ae));
      localBundle.putString("intext_1", localStringBuilder.toString());
      localBundle.putString("intext_3", "1");
      ReportCenter.a().a(localBundle, "", this.q.getCurrentAccountUin(), false);
    }
    return true;
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
    String str = this.r.getStringExtra("detail_url");
    boolean bool = TextUtils.isEmpty(str);
    int j = -1;
    int i = j;
    if (!bool)
    {
      i = j;
      if (QfavBuilder.a(str).b(this.s, this.q.getAccount(), -1, null)) {
        i = 0;
      }
    }
    if (i == 0) {
      QfavReport.a(this.q, "User_AddFav", -1, 0, 69, 0, "", "");
    }
    return i;
  }
  
  protected boolean k()
  {
    if (this.a == null) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgId = ");
      localStringBuilder.append(this.a.mMsgServiceID);
      QLog.e("ForwardOption.ForwardPluginShareStructMsgOption", 2, localStringBuilder.toString());
    }
    if (this.a.mMsgServiceID == 33)
    {
      this.L = 8;
      return true;
    }
    if (this.a.mMsgServiceID == 95)
    {
      this.L = 9;
      return true;
    }
    if ((this.a.mMsgUrl != null) && (b(this.a)))
    {
      this.L = 8;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption
 * JD-Core Version:    0.7.0.1
 */