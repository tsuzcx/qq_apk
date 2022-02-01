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
  private URLDrawableDownListener.Adapter jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new ForwardStructingMsgOption.1(this);
  AbsShareMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
  String h = "";
  boolean j;
  
  public ForwardStructingMsgOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_j_of_type_Boolean = false;
  }
  
  private void a(boolean paramBoolean, String paramString, long paramLong)
  {
    String str2 = c();
    String str1 = str2;
    if (!TextUtils.isEmpty(str2)) {
      if (str2.startsWith(HardCodeUtil.a(2131704933)))
      {
        str1 = str2.substring(4);
      }
      else
      {
        str1 = str2;
        if (str2.startsWith(HardCodeUtil.a(2131704904))) {
          str1 = str2.substring(3);
        }
      }
    }
    str2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0);
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, MiniChatActivity.class);
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
    PublicFragmentActivity.Launcher.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, MiniChatActivity.class, MiniMultiForwardFragment.class);
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
            localObject = ((StructMsgItemLayout5)localObject).a;
            if (localObject != null)
            {
              int k = 0;
              while (k < ((List)localObject).size())
              {
                AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((List)localObject).get(k);
                if (((localAbsStructMsgElement instanceof StructMsgItemVideo)) && (!((StructMsgItemVideo)localAbsStructMsgElement).a())) {
                  return true;
                }
                k += 1;
              }
            }
          }
          else if ((localObject instanceof StructMsgItemLayout2))
          {
            paramAbsShareMsg = (StructMsgItemLayout2)localObject;
            bool1 = bool2;
            if (paramAbsShareMsg.o != 1)
            {
              bool1 = bool2;
              if (paramAbsShareMsg.o != 3) {
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
            return (paramAbsStructMsg.o != 1) && (paramAbsStructMsg.o != 3);
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  private View b()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
    localLinearLayout.setOrientation(0);
    localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), new LinearLayout.LayoutParams(0, -2, 1.0F));
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 32) {}
    while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl))
    {
      i = 0;
      break;
    }
    int i = 1;
    FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidAppActivity);
    localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    if (i != 0)
    {
      Object localObject = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
      ((ImageView)localObject).setImageResource(2130840133);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.a(8.0F), ViewUtils.a(14.0F));
      localLayoutParams.setMargins(ViewUtils.a(7.0F), 0, 0, 0);
      localLayoutParams.gravity = 16;
      localLinearLayout.addView((View)localObject, localLayoutParams);
      localObject = new View(this.jdField_a_of_type_AndroidAppActivity);
      ((View)localObject).setBackgroundResource(2130840143);
      localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, ViewUtils.a(33.0F), 16));
      ((View)localObject).setOnClickListener(new ForwardStructingMsgOption.2(this));
      ((View)localObject).setContentDescription(HardCodeUtil.a(2131704905));
    }
    localFrameLayout.addView(localLinearLayout, new FrameLayout.LayoutParams(-1, -1));
    return localFrameLayout;
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
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject3 = URLDrawable.getDrawable((String)localObject3, -1, AIOUtils.b(165.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), localDrawable, localDrawable, true);
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
    ((TextView)localObject2).setMaxLines(1);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setPadding(AIOUtils.b(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.b(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.b(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.b(20.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    paramQQCustomDialog.addView((View)localObject2);
  }
  
  private View c()
  {
    Object localObject1 = HardCodeUtil.a(2131704922);
    Object localObject2 = String.format((String)localObject1, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mTSum) });
    int k = this.jdField_a_of_type_AndroidOsBundle.getInt("forward_msg_from_together", -1);
    if (k == 1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131704921));
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (k != 0)
    {
      localObject3 = localObject1;
      localObject1 = localObject2;
      if (k == -1) {}
    }
    for (;;)
    {
      break;
      localObject3 = (AbsStructMsgElement)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mStructMsgItemLists.get(0);
      localObject1 = localObject2;
      if ((localObject3 instanceof AbsStructMsgItem))
      {
        localObject3 = (AbsStructMsgElement)((AbsStructMsgItem)localObject3).a.get(0);
        localObject1 = localObject2;
        if ((localObject3 instanceof StructMsgItemTitle))
        {
          localObject1 = ((StructMsgItemTitle)localObject3).ai;
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.hasTSum()) && (((String)localObject1).endsWith(HardCodeUtil.a(2131704902)))) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0) {
            localObject1 = HardCodeUtil.a(2131704899);
          }
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131704891));
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject3 = ((StringBuilder)localObject2).toString();
    }
    localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
    ((LinearLayout)localObject2).setOrientation(0);
    Object localObject4 = new EllipsizingTextView(this.jdField_a_of_type_AndroidAppActivity, null);
    ((EllipsizingTextView)localObject4).setText(new QQText((CharSequence)localObject3, 3, 16));
    ((EllipsizingTextView)localObject4).setMaxLines(2);
    ((EllipsizingTextView)localObject4).setEllipsize(TextUtils.TruncateAt.END);
    ((EllipsizingTextView)localObject4).setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131165661));
    ((EllipsizingTextView)localObject4).setTextSize(14.0F);
    Object localObject3 = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
    ((ImageView)localObject3).setImageResource(2130840133);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2, 1.0F);
    localLayoutParams.gravity = 17;
    ((LinearLayout)localObject2).addView((View)localObject4, localLayoutParams);
    localObject4 = new LinearLayout.LayoutParams(ViewUtils.a(8.0F), ViewUtils.a(14.0F));
    ((LinearLayout.LayoutParams)localObject4).gravity = 17;
    ((LinearLayout.LayoutParams)localObject4).setMargins(ViewUtils.a(3.0F), 0, 0, 0);
    ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    ((LinearLayout)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    localObject3 = new View(this.jdField_a_of_type_AndroidAppActivity);
    ((View)localObject3).setBackgroundResource(2130840143);
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("structmsg_uniseq", 0L);
    boolean bool;
    if (k == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((View)localObject3).setOnClickListener(new ForwardStructingMsgOption.3(this, bool, (String)localObject1, l));
    localObject1 = new FrameLayout(this.jdField_a_of_type_AndroidAppActivity);
    int i = ViewUtils.a(20.0F);
    ((FrameLayout)localObject1).setPadding(0, i, 0, i);
    ((FrameLayout)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    ((FrameLayout)localObject1).addView((View)localObject3, new FrameLayout.LayoutParams(-1, -1, 16));
    ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(-1, -2));
    if (k == 1)
    {
      this.jdField_b_of_type_Int = 2;
      return localObject1;
    }
    if ((k == 0) || (k == -1)) {
      this.jdField_b_of_type_Int = 1;
    }
    return localObject1;
  }
  
  private void e()
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
        QLog.e("ForwardOption.ForwardStructingMsgOption", 2, ((StringBuilder)localObject).toString());
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
      QLog.e("ForwardOption.ForwardStructingMsgOption", 2, "empty url");
    }
  }
  
  protected void B()
  {
    ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  protected View a()
  {
    AbsShareMsg localAbsShareMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
    if (localAbsShareMsg == null) {
      return null;
    }
    if (localAbsShareMsg.mMsgServiceID == 35) {
      return c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 33) {
      return b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 95) {
      return b();
    }
    return b();
  }
  
  protected void a()
  {
    int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("structmsg_service_id", -1);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    String str = "";
    localStringBuilder.append("");
    ReportController.b(localQQAppInterface, "CliOper", "", "", "0X800567B", "0X800567B", 0, 0, localStringBuilder.toString(), "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
    SdkShareReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg);
    if (c() != 0) {
      str = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue();
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", str);
    super.a();
  }
  
  public boolean a()
  {
    super.a();
    Object localObject = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle.getByteArray("stuctmsg_bytes"));
    if ((localObject != null) && ((localObject instanceof AbsShareMsg))) {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
    if (localObject != null)
    {
      if ((((AbsShareMsg)localObject).mMsgServiceID != 83) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 108) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 114) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 116) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 151) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 156))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://article.mp.qq.com")) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("https://article.mp.qq.com")) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://post.mp.qq.com")) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("https://post.mp.qq.com"))) {
          this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 2);
        }
      }
      else
      {
        this.jdField_j_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 3);
      }
      localObject = Uri.parse(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl);
      try
      {
        this.h = ((Uri)localObject).getQueryParameter("article_id");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (this.h == null) {
        this.h = "";
      }
    }
    return true;
  }
  
  protected boolean a(LightAppSettingInfo paramLightAppSettingInfo)
  {
    if (paramLightAppSettingInfo == null) {
      return false;
    }
    paramLightAppSettingInfo = paramLightAppSettingInfo.a;
    if (paramLightAppSettingInfo == null) {
      return false;
    }
    AbsShareMsg localAbsShareMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
    if (localObject != null)
    {
      boolean bool = a((AbsShareMsg)localObject);
      localObject = new LinearLayout.LayoutParams(-1, -2);
      AbsShareMsg localAbsShareMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
      if ((localAbsShareMsg instanceof StructMsgForGeneralShare))
      {
        if ((!bool) && (localAbsShareMsg.mMsgServiceID != 97)) {
          ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.b(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.b(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        }
      }
      else if ((localAbsShareMsg instanceof StructMsgForAudioShare)) {
        ((LinearLayout.LayoutParams)localObject).setMargins(0, AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.b(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      } else if ((localAbsShareMsg instanceof StructMsgForImageShare)) {
        ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.b(-10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.b(-7.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardStructingMsgOption", 2, "updateImageView addStructView");
      }
      if (this.jdField_j_of_type_Boolean)
      {
        b(paramQQCustomDialog);
        return false;
      }
      paramQQCustomDialog.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), (LinearLayout.LayoutParams)localObject);
      int i;
      if ((!(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare)) && (!bool) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_need_show_sources", true))) {
        i = 1;
      } else {
        i = 0;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 35) {
        i = 0;
      }
      if (i != 0) {
        a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, paramQQCustomDialog);
      }
    }
    return true;
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    localObject = new LightAppUtil();
    int k = paramArrayOfDeviceInfo.length;
    int i = 0;
    while (i < k)
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
        if ((a(jdField_j_of_type_JavaLangInteger)) && (a(localLightAppSettingInfo))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  protected void b()
  {
    if (p()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (q()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (r()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_smartdevice", true)) && (super.s())) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_j_of_type_JavaLangInteger);
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  protected void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.adjustMessageBottomMargin(17.0F);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageTextColor(2131165694);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageTextSize(14.0F);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
    if ((localObject != null) && (((AbsShareMsg)localObject).mMsgServiceID == 97))
    {
      localObject = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131363688)).getLayoutParams();
      if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)localObject).setMargins(0, 0, 0, 0);
      }
    }
  }
  
  protected boolean c()
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
    Object localObject1;
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ForwardStructingMsgOption realForwardTo  mShareMsg.mMsgServiceID=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID);
      QLog.d("forward", 2, ((StringBuilder)localObject1).toString());
    }
    if (j())
    {
      localObject1 = b();
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare))
      {
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject2).next();
          StructMsgForImageShare.sendAndUploadImageShare(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, localResultRecord.uin, localResultRecord.getUinType(), null, 0);
        }
        if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("k_back", true))
        {
          localObject2 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class), null);
          ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
          this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
        }
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
      if ((localObject2 != null) && ((((AbsShareMsg)localObject2).mMsgServiceID == 32) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 97)))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ResultRecord)((Iterator)localObject1).next();
          localObject2 = ForwardUtils.a(localIntent, ((ResultRecord)localObject2).uin, ((ResultRecord)localObject2).getUinType(), ((ResultRecord)localObject2).groupUin);
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (SessionInfo)localObject2, localIntent);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 97) {
          return false;
        }
      }
      if ((this.jdField_a_of_type_AndroidOsBundle.getBoolean("forwardDirect", false)) && ((this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity))) {
        ForwardUtils.a((QQAppInterface)((AppActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime(), this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), localIntent, null);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare))
      {
        StructMsgForImageShare.sendAndUploadImageShare(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), null, 0);
        if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("k_back", true))
        {
          localObject1 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class), null);
          ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
          this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
      if ((localObject1 != null) && ((((AbsShareMsg)localObject1).mMsgServiceID == 32) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 97) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 145) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 155)))
      {
        localObject1 = ForwardUtils.a(localIntent);
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (SessionInfo)localObject1, localIntent);
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 97) {
          return false;
        }
      }
      if ((this.jdField_a_of_type_AndroidOsBundle.getBoolean("forwardDirect", false)) && ((this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity))) {
        ForwardUtils.a((QQAppInterface)((AppActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime(), this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), localIntent, null);
      }
    }
    localIntent.putExtra("uin", this.jdField_a_of_type_AndroidOsBundle.getString("uin", ""));
    localIntent.putExtra("uintype", this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0));
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    return false;
  }
  
  protected int d()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
    boolean bool = localObject1 instanceof StructMsgForImageShare;
    int m = -1;
    if (bool)
    {
      localObject1 = QfavUtil.a((StructMsgForImageShare)localObject1);
      k = m;
      if (localObject1 == null) {
        break label555;
      }
      k = m;
      if (!QfavBuilder.b(((StructMsgItemImage)localObject1).ac).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
        break label555;
      }
    }
    else
    {
      int i;
      if (!TextUtils.isEmpty(((AbsShareMsg)localObject1).mMsgActionData))
      {
        String[] arrayOfString1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData.split("&");
        k = arrayOfString1.length;
        Object localObject4 = null;
        localObject1 = localObject4;
        Object localObject2 = localObject1;
        Object localObject3 = localObject2;
        i = 0;
        while (i < k)
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
        k = m;
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 32) {
          break label555;
        }
        k = m;
        if (TextUtils.isEmpty(localObject4)) {
          break label555;
        }
        k = m;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label555;
        }
        k = m;
        if (TextUtils.isEmpty(localObject2)) {
          break label555;
        }
        k = m;
        if (!QfavBuilder.a(Float.valueOf(localObject4).floatValue(), Float.valueOf((String)localObject1).floatValue(), localObject3, localObject2, null).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
          break label555;
        }
      }
      else
      {
        localObject1 = QfavUtil.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getXmlBytes());
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare)) {
          i = 2;
        } else {
          i = 0;
        }
        k = m;
        if (!QfavBuilder.a(i, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentTitle, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentSummary, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentCover, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentSrc, (byte[])localObject1, false, 0L).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
          break label555;
        }
      }
    }
    int k = 0;
    label555:
    if (k == 0) {
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", -1, 0, 69, 0, "", "");
    }
    return k;
  }
  
  protected boolean l()
  {
    return false;
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
      QLog.e("ForwardOption.ForwardStructingMsgOption", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 35) {
      return true;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardStructingMsgOption
 * JD-Core Version:    0.7.0.1
 */