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
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.device.utils.LightAppUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMultiForwardFragment;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.open.sdk.report.SdkShareReporter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppActivity;

public class ForwardStructingMsgOption
  extends ForwardBaseOption
{
  private URLDrawableDownListener.Adapter a = new ForwardStructingMsgOption.1(this);
  AbsShareMsg ad;
  boolean ae = false;
  String af = "";
  
  public ForwardStructingMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  private void a(boolean paramBoolean, String paramString, long paramLong)
  {
    String str2 = B();
    String str1 = str2;
    if (!TextUtils.isEmpty(str2)) {
      if (str2.startsWith(HardCodeUtil.a(2131902825)))
      {
        str1 = str2.substring(4);
      }
      else
      {
        str1 = str2;
        if (str2.startsWith(HardCodeUtil.a(2131902796))) {
          str1 = str2.substring(3);
        }
      }
    }
    str2 = this.t.getString("uin");
    int i = this.t.getInt("uintype", 0);
    Intent localIntent = new Intent();
    localIntent.setClass(this.s, MiniChatActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putExtra("uin", str2);
    localIntent.putExtra("uintype", i);
    localIntent.putExtra("uinname", str1);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("minaio_scaled_ration", a(0.78F));
    localIntent.putExtra("minaio_height_ration", 0.86F);
    localIntent.putExtra("member_dialog_title", str1);
    if (paramBoolean)
    {
      localIntent.putExtra("multi_forward_type", 1);
    }
    else
    {
      localIntent.putExtra("multi_forward_type", 2);
      localIntent.putExtra("multi_forward_title", paramString);
      localIntent.putExtra("structmsg_uniseq", paramLong);
    }
    localIntent.putExtra("key_mini_from", 4);
    PublicFragmentActivity.Launcher.a(this.s, localIntent, MiniChatActivity.class, MiniMultiForwardFragment.class);
  }
  
  private boolean a(AbsShareMsg paramAbsShareMsg)
  {
    boolean bool1 = paramAbsShareMsg instanceof StructMsgForGeneralShare;
    boolean bool2 = false;
    if (bool1)
    {
      paramAbsShareMsg = ((StructMsgForGeneralShare)paramAbsShareMsg).getStructMsgItemLists();
      if (paramAbsShareMsg != null)
      {
        int i = 0;
        while (i < paramAbsShareMsg.size())
        {
          Object localObject = (AbsStructMsgElement)paramAbsShareMsg.get(i);
          if ((localObject instanceof StructMsgItemLayout5))
          {
            localObject = ((StructMsgItemLayout5)localObject).ax;
            if (localObject != null)
            {
              int j = 0;
              while (j < ((List)localObject).size())
              {
                AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((List)localObject).get(j);
                if (((localAbsStructMsgElement instanceof StructMsgItemVideo)) && (!((StructMsgItemVideo)localAbsStructMsgElement).c())) {
                  return true;
                }
                j += 1;
              }
            }
          }
          else if ((localObject instanceof StructMsgItemLayout2))
          {
            paramAbsShareMsg = (StructMsgItemLayout2)localObject;
            bool1 = bool2;
            if (paramAbsShareMsg.au != 1)
            {
              bool1 = bool2;
              if (paramAbsShareMsg.au != 3) {
                bool1 = true;
              }
            }
            return bool1;
          }
          i += 1;
        }
      }
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
  
  private View au()
  {
    Object localObject1 = HardCodeUtil.a(2131902814);
    Object localObject2 = String.format((String)localObject1, new Object[] { Integer.valueOf(this.ad.mTSum) });
    int j = this.t.getInt("forward_msg_from_together", -1);
    if (j == 1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131902813));
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (j != 0)
    {
      localObject3 = localObject1;
      localObject1 = localObject2;
      if (j == -1) {}
    }
    for (;;)
    {
      break;
      localObject3 = (AbsStructMsgElement)this.ad.mStructMsgItemLists.get(0);
      localObject1 = localObject2;
      if ((localObject3 instanceof AbsStructMsgItem))
      {
        localObject3 = (AbsStructMsgElement)((AbsStructMsgItem)localObject3).ax.get(0);
        localObject1 = localObject2;
        if ((localObject3 instanceof StructMsgItemTitle))
        {
          localObject1 = ((StructMsgItemTitle)localObject3).aA;
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (this.ad.hasTSum()) && (((String)localObject1).endsWith(HardCodeUtil.a(2131902794)))) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0) {
            localObject1 = HardCodeUtil.a(2131902791);
          }
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131902783));
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject3 = ((StringBuilder)localObject2).toString();
    }
    localObject2 = new LinearLayout(this.s);
    ((LinearLayout)localObject2).setOrientation(0);
    EllipsizingTextView localEllipsizingTextView = new EllipsizingTextView(this.s, null);
    localEllipsizingTextView.setText(new QQText((CharSequence)localObject3, 3, 16));
    localEllipsizingTextView.setMaxLines(2);
    localEllipsizingTextView.setEllipsize(TextUtils.TruncateAt.END);
    localEllipsizingTextView.setTextColor(this.s.getResources().getColorStateList(2131166121));
    localEllipsizingTextView.setTextSize(14.0F);
    Object localObject3 = new ImageView(this.s);
    ((ImageView)localObject3).setImageResource(2130840437);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2, 1.0F);
    localLayoutParams.gravity = 17;
    ((LinearLayout)localObject2).addView(localEllipsizingTextView, localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(8.0F), ViewUtils.dip2px(14.0F));
    localLayoutParams.gravity = 17;
    localLayoutParams.setMargins(ViewUtils.dip2px(3.0F), 0, 0, 0);
    SimpleModeHelper.a(localEllipsizingTextView, (ImageView)localObject3, localLayoutParams);
    ((LinearLayout)localObject2).addView((View)localObject3, localLayoutParams);
    ((LinearLayout)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    localObject3 = new View(this.s);
    ((View)localObject3).setBackgroundResource(2130840448);
    long l = this.t.getLong("structmsg_uniseq", 0L);
    boolean bool;
    if (j == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((View)localObject3).setOnClickListener(new ForwardStructingMsgOption.3(this, bool, (String)localObject1, l));
    localObject1 = new FrameLayout(this.s);
    int i = ViewUtils.dip2px(20.0F);
    ((FrameLayout)localObject1).setPadding(0, i, 0, i);
    ((FrameLayout)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    ((FrameLayout)localObject1).addView((View)localObject3, new FrameLayout.LayoutParams(-1, -1, 16));
    ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(-1, -2));
    if (j == 1)
    {
      this.L = 2;
      return localObject1;
    }
    if ((j == 0) || (j == -1)) {
      this.L = 1;
    }
    return localObject1;
  }
  
  private void c(QQCustomDialog paramQQCustomDialog)
  {
    paramQQCustomDialog.setBodyLayoutNoMargin();
    Object localObject1 = new URLImageView(this.s);
    Object localObject2 = new LinearLayout.LayoutParams(-1, AIOUtils.b(152.0F, this.s.getResources()));
    if ((this.ad.mMsgServiceID == 114) || (this.ad.mMsgServiceID == 116))
    {
      ((LinearLayout.LayoutParams)localObject2).leftMargin = AIOUtils.b(24.0F, this.s.getResources());
      ((LinearLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(24.0F, this.s.getResources());
    }
    ((URLImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((URLImageView)localObject1).setBackgroundColor(Color.parseColor("#dcdfe4"));
    Object localObject3 = ChatHistoryStructAdapter.a(this.ad, "cover");
    Drawable localDrawable = this.s.getResources().getDrawable(2130852666);
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject3 = URLDrawable.getDrawable((String)localObject3, -1, AIOUtils.b(165.0F, this.s.getResources()), localDrawable, localDrawable, true);
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
        ((URLImageView)localObject1).setURLDrawableDownListener(this.a);
      }
      ((URLImageView)localObject1).setImageDrawable((Drawable)localObject3);
    }
    else
    {
      ((URLImageView)localObject1).setImageDrawable(localDrawable);
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
    paramQQCustomDialog.addView((View)localObject1, (LinearLayout.LayoutParams)localObject2);
    localObject1 = ChatHistoryStructAdapter.a(this.ad, "title");
    localObject2 = new TextView(this.s);
    ((TextView)localObject2).setText((CharSequence)localObject1);
    ((TextView)localObject2).setTextSize(16.0F);
    ((TextView)localObject2).setIncludeFontPadding(false);
    ((TextView)localObject2).setTextColor(-16777216);
    ((TextView)localObject2).setMaxLines(1);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setPadding(AIOUtils.b(24.0F, this.s.getResources()), AIOUtils.b(8.0F, this.s.getResources()), AIOUtils.b(24.0F, this.s.getResources()), AIOUtils.b(20.0F, this.s.getResources()));
    paramQQCustomDialog.addView((View)localObject2);
  }
  
  private View o()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.s);
    localLinearLayout.setOrientation(0);
    localLinearLayout.addView(this.ad.getPreDialogView(this.s, null), new LinearLayout.LayoutParams(0, -2, 1.0F));
    if (this.ad.mMsgServiceID == 32) {}
    while (TextUtils.isEmpty(this.ad.mMsgUrl))
    {
      i = 0;
      break;
    }
    int i = 1;
    FrameLayout localFrameLayout = new FrameLayout(this.s);
    localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    if (i != 0)
    {
      Object localObject = new ImageView(this.s);
      ((ImageView)localObject).setImageResource(2130840437);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(8.0F), ViewUtils.dip2px(14.0F));
      localLayoutParams.setMargins(ViewUtils.dip2px(7.0F), 0, 0, 0);
      localLayoutParams.gravity = 16;
      SimpleModeHelper.a(null, (ImageView)localObject, localLayoutParams);
      localLinearLayout.addView((View)localObject, localLayoutParams);
      localObject = new View(this.s);
      ((View)localObject).setBackgroundResource(2130840448);
      localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, ViewUtils.dip2px(33.0F), 16));
      ((View)localObject).setOnClickListener(new ForwardStructingMsgOption.2(this));
      ((View)localObject).setContentDescription(HardCodeUtil.a(2131902797));
    }
    localFrameLayout.addView(localLinearLayout, new FrameLayout.LayoutParams(-1, -1));
    return localFrameLayout;
  }
  
  private void p()
  {
    if (!TextUtils.isEmpty(this.ad.mMsgUrl))
    {
      String str = this.ad.mMsgUrl.trim();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("gotoWeb ");
        ((StringBuilder)localObject).append(str);
        QLog.e("ForwardOption.ForwardStructingMsgOption", 2, ((StringBuilder)localObject).toString());
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
      QLog.e("ForwardOption.ForwardStructingMsgOption", 2, "empty url");
    }
  }
  
  protected boolean U()
  {
    return false;
  }
  
  protected void W()
  {
    super.W();
    ReportController.b(this.q, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "1", "", "", "");
  }
  
  protected View a()
  {
    AbsShareMsg localAbsShareMsg = this.ad;
    if (localAbsShareMsg == null) {
      return null;
    }
    if (localAbsShareMsg.mMsgServiceID == 35) {
      return au();
    }
    if (this.ad.mMsgServiceID == 33) {
      return o();
    }
    if (this.ad.mMsgServiceID == 95) {
      return o();
    }
    return o();
  }
  
  protected boolean a(LightAppSettingInfo paramLightAppSettingInfo)
  {
    if (paramLightAppSettingInfo == null) {
      return false;
    }
    paramLightAppSettingInfo = paramLightAppSettingInfo.e;
    if (paramLightAppSettingInfo == null) {
      return false;
    }
    AbsShareMsg localAbsShareMsg = this.ad;
    if (localAbsShareMsg == null) {
      return false;
    }
    int i = localAbsShareMsg.mMsgServiceID;
    boolean bool = true;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 32) {
          return bool;
        }
      }
      else if (paramLightAppSettingInfo.contains(Integer.valueOf(11003))) {
        return true;
      }
    }
    else if (paramLightAppSettingInfo.contains(Integer.valueOf(11005))) {
      return true;
    }
    bool = false;
    return bool;
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    Object localObject = this.ad;
    if (localObject != null)
    {
      boolean bool = a((AbsShareMsg)localObject);
      localObject = new LinearLayout.LayoutParams(-1, -2);
      AbsShareMsg localAbsShareMsg = this.ad;
      if ((localAbsShareMsg instanceof StructMsgForGeneralShare))
      {
        if ((!bool) && (localAbsShareMsg.mMsgServiceID != 97)) {
          ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.b(-15.0F, this.s.getResources()), 0, AIOUtils.b(-15.0F, this.s.getResources()), AIOUtils.b(5.0F, this.s.getResources()));
        }
      }
      else if ((localAbsShareMsg instanceof StructMsgForAudioShare)) {
        ((LinearLayout.LayoutParams)localObject).setMargins(0, AIOUtils.b(5.0F, this.s.getResources()), 0, AIOUtils.b(10.0F, this.s.getResources()));
      } else if ((localAbsShareMsg instanceof StructMsgForImageShare)) {
        ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.b(-10.0F, this.s.getResources()), 0, AIOUtils.b(-7.5F, this.s.getResources()), 0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardStructingMsgOption", 2, "updateImageView addStructView");
      }
      if (this.ae)
      {
        c(paramQQCustomDialog);
        return false;
      }
      paramQQCustomDialog.addView(this.ad.getPreDialogView(this.s, null), (LinearLayout.LayoutParams)localObject);
      int i;
      if ((!(this.ad instanceof StructMsgForImageShare)) && (!bool) && (this.r.getBooleanExtra("is_need_show_sources", true))) {
        i = 1;
      } else {
        i = 0;
      }
      if (this.ad.mMsgServiceID == 35) {
        i = 0;
      }
      if (i != 0) {
        a(this.ad.mSourceName, paramQQCustomDialog);
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("settingInfo = ");
          localStringBuilder.append(localLightAppSettingInfo);
          QLog.e("ForwardStructingMsgOption", 2, localStringBuilder.toString());
        }
        if ((a(k)) && (a(localLightAppSettingInfo))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  protected void b()
  {
    int i = this.r.getIntExtra("structmsg_service_id", -1);
    QQAppInterface localQQAppInterface = this.q;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    String str = "";
    localStringBuilder.append("");
    ReportController.b(localQQAppInterface, "CliOper", "", "", "0X800567B", "0X800567B", 0, 0, localStringBuilder.toString(), "", "", "");
    ReportController.b(this.q, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
    SdkShareReporter.a(this.q, this.G, this.r, this.ad);
    if (F() != 0) {
      str = this.A.getInputValue();
    }
    this.t.putString("share_comment_message", str);
    super.b();
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
    if ((this.r.getBooleanExtra("k_smartdevice", true)) && (super.aj())) {
      this.C.add(k);
    }
  }
  
  protected void d()
  {
    super.d();
    this.A.adjustMessageBottomMargin(17.0F);
    this.A.setMessageTextColor(2131166157);
    this.A.setMessageTextSize(14.0F);
    Object localObject = this.ad;
    if ((localObject != null) && (((AbsShareMsg)localObject).mMsgServiceID == 97))
    {
      localObject = ((LinearLayout)this.A.findViewById(2131429603)).getLayoutParams();
      if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)localObject).setMargins(0, 0, 0, 0);
      }
    }
  }
  
  public boolean e()
  {
    super.e();
    Object localObject = StructMsgFactory.a(this.t.getByteArray("stuctmsg_bytes"));
    if ((localObject != null) && ((localObject instanceof AbsShareMsg))) {
      this.ad = ((AbsShareMsg)localObject);
    }
    localObject = this.ad;
    if (localObject != null)
    {
      if ((((AbsShareMsg)localObject).mMsgServiceID != 83) && (this.ad.mMsgServiceID != 108) && (this.ad.mMsgServiceID != 114) && (this.ad.mMsgServiceID != 116) && (this.ad.mMsgServiceID != 151) && (this.ad.mMsgServiceID != 156))
      {
        if ((this.ad.mMsgUrl.startsWith("http://article.mp.qq.com")) || (this.ad.mMsgUrl.startsWith("https://article.mp.qq.com")) || (this.ad.mMsgUrl.startsWith("http://post.mp.qq.com")) || (this.ad.mMsgUrl.startsWith("https://post.mp.qq.com"))) {
          this.t.putInt("emoInputType", 2);
        }
      }
      else
      {
        this.ae = true;
        this.t.putInt("emoInputType", 3);
      }
      localObject = Uri.parse(this.ad.mMsgUrl);
      try
      {
        this.af = ((Uri)localObject).getQueryParameter("article_id");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (this.af == null) {
        this.af = "";
      }
    }
    return true;
  }
  
  protected boolean f()
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(this.t);
    this.t.putBoolean("isBack2Root", false);
    Object localObject1;
    if ((QLog.isColorLevel()) && (this.ad != null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ForwardStructingMsgOption realForwardTo  mShareMsg.mMsgServiceID=");
      ((StringBuilder)localObject1).append(this.ad.mMsgServiceID);
      QLog.d("forward", 2, ((StringBuilder)localObject1).toString());
    }
    if (K())
    {
      localObject1 = M();
      if ((this.ad instanceof StructMsgForImageShare))
      {
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject2).next();
          StructMsgForImageShare.sendAndUploadImageShare(this.q, (StructMsgForImageShare)this.ad, localResultRecord.uin, localResultRecord.getUinType(), null, 0);
        }
        if (!this.t.getBoolean("k_back", true))
        {
          localObject2 = AIOUtils.a(new Intent(this.s, ChatActivity.class), null);
          ((Intent)localObject2).putExtras(this.t);
          this.s.startActivity((Intent)localObject2);
        }
      }
      Object localObject2 = this.ad;
      if ((localObject2 != null) && ((((AbsShareMsg)localObject2).mMsgServiceID == 32) || (this.ad.mMsgServiceID == 97)))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ResultRecord)((Iterator)localObject1).next();
          localObject2 = ForwardUtils.a(localIntent, ((ResultRecord)localObject2).uin, ((ResultRecord)localObject2).getUinType(), ((ResultRecord)localObject2).groupUin);
          ForwardUtils.a(this.q, this.I, (SessionInfo)localObject2, localIntent);
        }
        if (this.ad.mMsgServiceID == 97) {
          return false;
        }
      }
      if ((this.t.getBoolean("forwardDirect", false)) && ((this.s instanceof AppActivity))) {
        ForwardUtils.a((QQAppInterface)((AppActivity)this.s).getAppRuntime(), this.s, this.s.getApplicationContext(), localIntent, null);
      }
    }
    else
    {
      if ((this.ad instanceof StructMsgForImageShare))
      {
        StructMsgForImageShare.sendAndUploadImageShare(this.q, (StructMsgForImageShare)this.ad, this.t.getString("uin"), this.t.getInt("uintype"), null, 0);
        if (!this.t.getBoolean("k_back", true))
        {
          localObject1 = AIOUtils.a(new Intent(this.s, ChatActivity.class), null);
          ((Intent)localObject1).putExtras(this.t);
          this.s.startActivity((Intent)localObject1);
        }
      }
      localObject1 = this.ad;
      if ((localObject1 != null) && ((((AbsShareMsg)localObject1).mMsgServiceID == 32) || (this.ad.mMsgServiceID == 97) || (this.ad.mMsgServiceID == 145) || (this.ad.mMsgServiceID == 155)))
      {
        localObject1 = ForwardUtils.a(localIntent);
        ForwardUtils.a(this.q, this.I, (SessionInfo)localObject1, localIntent);
        if (this.ad.mMsgServiceID == 97) {
          return false;
        }
      }
      if ((this.t.getBoolean("forwardDirect", false)) && ((this.s instanceof AppActivity))) {
        ForwardUtils.a((QQAppInterface)((AppActivity)this.s).getAppRuntime(), this.s, this.s.getApplicationContext(), localIntent, null);
      }
    }
    localIntent.putExtra("uin", this.t.getString("uin", ""));
    localIntent.putExtra("uintype", this.t.getInt("uintype", 0));
    this.s.setResult(-1, localIntent);
    this.s.finish();
    return false;
  }
  
  protected void g()
  {
    ((DeviceMsgHandle)this.q.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).b().a(this.t.getString("uin"), this.ad);
    this.s.finish();
  }
  
  protected int h()
  {
    Object localObject1 = this.ad;
    boolean bool = localObject1 instanceof StructMsgForImageShare;
    int k = -1;
    if (bool)
    {
      localObject1 = QfavUtil.a((StructMsgForImageShare)localObject1);
      j = k;
      if (localObject1 == null) {
        break label555;
      }
      j = k;
      if (!QfavBuilder.b(((StructMsgItemImage)localObject1).au).a(this.q).b(this.s, this.q.getAccount(), -1, null)) {
        break label555;
      }
    }
    else
    {
      int i;
      if (!TextUtils.isEmpty(((AbsShareMsg)localObject1).mMsgActionData))
      {
        String[] arrayOfString1 = this.ad.mMsgActionData.split("&");
        j = arrayOfString1.length;
        Object localObject4 = null;
        localObject1 = localObject4;
        Object localObject2 = localObject1;
        Object localObject3 = localObject2;
        i = 0;
        while (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[i].split("=");
          Object localObject5 = localObject4;
          Object localObject6 = localObject1;
          Object localObject7 = localObject2;
          Object localObject8 = localObject3;
          if (arrayOfString2.length > 1) {
            if (arrayOfString2[0].trim().equals("lat"))
            {
              localObject5 = arrayOfString2[1];
              localObject6 = localObject1;
              localObject7 = localObject2;
              localObject8 = localObject3;
            }
            else if (arrayOfString2[0].trim().equals("lon"))
            {
              localObject6 = arrayOfString2[1];
              localObject5 = localObject4;
              localObject7 = localObject2;
              localObject8 = localObject3;
            }
            else if (arrayOfString2[0].trim().equals("loc"))
            {
              localObject7 = arrayOfString2[1];
              localObject5 = localObject4;
              localObject6 = localObject1;
              localObject8 = localObject3;
            }
            else
            {
              localObject5 = localObject4;
              localObject6 = localObject1;
              localObject7 = localObject2;
              localObject8 = localObject3;
              if (arrayOfString2[0].trim().equals("title"))
              {
                localObject8 = arrayOfString2[1];
                localObject7 = localObject2;
                localObject6 = localObject1;
                localObject5 = localObject4;
              }
            }
          }
          i += 1;
          localObject4 = localObject5;
          localObject1 = localObject6;
          localObject2 = localObject7;
          localObject3 = localObject8;
        }
        j = k;
        if (this.ad.mMsgServiceID != 32) {
          break label555;
        }
        j = k;
        if (TextUtils.isEmpty(localObject4)) {
          break label555;
        }
        j = k;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label555;
        }
        j = k;
        if (TextUtils.isEmpty(localObject2)) {
          break label555;
        }
        j = k;
        if (!QfavBuilder.a(Float.valueOf(localObject4).floatValue(), Float.valueOf((String)localObject1).floatValue(), localObject3, localObject2, null).a(this.q).b(this.s, this.q.getAccount(), -1, null)) {
          break label555;
        }
      }
      else
      {
        localObject1 = QfavUtil.a(this.ad.getXmlBytes());
        if ((this.ad instanceof StructMsgForAudioShare)) {
          i = 2;
        } else {
          i = 0;
        }
        j = k;
        if (!QfavBuilder.a(i, this.ad.mContentTitle, this.ad.mMsgUrl, this.ad.mSourceName, this.ad.mContentSummary, this.ad.mContentCover, this.ad.mContentSrc, (byte[])localObject1, false, 0L).a(this.q).b(this.s, this.q.getAccount(), -1, null)) {
          break label555;
        }
      }
    }
    int j = 0;
    label555:
    if (j == 0) {
      QfavReport.a(this.q, "User_AddFav", -1, 0, 69, 0, "", "");
    }
    return j;
  }
  
  protected boolean k()
  {
    if (this.ad == null) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgId = ");
      localStringBuilder.append(this.ad.mMsgServiceID);
      QLog.e("ForwardOption.ForwardStructingMsgOption", 2, localStringBuilder.toString());
    }
    if (this.ad.mMsgServiceID == 35) {
      return true;
    }
    if (this.ad.mMsgServiceID == 33)
    {
      this.L = 8;
      return true;
    }
    if (this.ad.mMsgServiceID == 95)
    {
      this.L = 9;
      return true;
    }
    if ((this.ad.mMsgUrl != null) && (a(this.ad)))
    {
      this.L = 8;
      return true;
    }
    return false;
  }
  
  public boolean l()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardStructingMsgOption
 * JD-Core Version:    0.7.0.1
 */