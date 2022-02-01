package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mqp.app.sec.SecShareInfoUtil;
import com.tencent.qqprotect.qsec.QSecFramework;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardTextOption
  extends ForwardBaseOption
{
  public ForwardTextOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 3;
  }
  
  protected void B()
  {
    c();
  }
  
  protected View a()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
    localLinearLayout.setOrientation(0);
    AnimationTextView localAnimationTextView = new AnimationTextView(this.jdField_a_of_type_AndroidAppActivity);
    Object localObject2 = a();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localAnimationTextView.setText(new QQText((CharSequence)localObject1, 5, 16));
    localAnimationTextView.setMaxLines(2);
    localAnimationTextView.setEllipsize(TextUtils.TruncateAt.END);
    localAnimationTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131165661));
    localAnimationTextView.setTextSize(14.0F);
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
    ((ImageView)localObject1).setImageResource(2130840133);
    localObject2 = new LinearLayout.LayoutParams(0, -2, 1.0F);
    ((LinearLayout.LayoutParams)localObject2).gravity = 17;
    localLinearLayout.addView(localAnimationTextView, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new LinearLayout.LayoutParams(ViewUtils.a(8.0F), ViewUtils.a(14.0F));
    ((LinearLayout.LayoutParams)localObject2).gravity = 17;
    ((LinearLayout.LayoutParams)localObject2).setMargins(ViewUtils.a(3.0F), 0, 0, 0);
    localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localLinearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    localObject1 = new View(this.jdField_a_of_type_AndroidAppActivity);
    ((View)localObject1).setId(2131367200);
    ((View)localObject1).setBackgroundResource(2130840143);
    ((View)localObject1).setOnClickListener(new ForwardTextOption.1(this));
    localObject2 = new FrameLayout(this.jdField_a_of_type_AndroidAppActivity);
    int i = ViewUtils.a(20.0F);
    ((FrameLayout)localObject2).setPadding(0, i, 0, i);
    ((FrameLayout)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    ((FrameLayout)localObject2).addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1, 16));
    ((FrameLayout)localObject2).addView(localLinearLayout, new FrameLayout.LayoutParams(-1, -2));
    return localObject2;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 6002) && ((localRecentUser.getType() != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.getType() != 1006) || (a(ForwardAbility.ForwardAbilityType.h))) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 0) || (!CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.jdField_b_of_type_Boolean))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  public boolean a()
  {
    super.a();
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      SpannableString localSpannableString = (SpannableString)this.jdField_a_of_type_AndroidOsBundle.get("forward_text");
      if (localSpannableString != null) {
        this.jdField_a_of_type_JavaLangString = localSpannableString.toString();
      }
    }
    return true;
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    int j = paramArrayOfDeviceInfo.length;
    int i = 0;
    while (i < j)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      if (localDeviceInfo != null)
      {
        ProductInfo localProductInfo = localSmartDeviceProxyMgr.a(localDeviceInfo.productId);
        if ((localProductInfo != null) && (localProductInfo.isSupportMainMsgType(1)) && (a(j))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_dataline", true))
    {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
      this.jdField_a_of_type_JavaUtilSet.add(k);
    }
    if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_smartdevice", true)) && (s())) {
      this.jdField_a_of_type_JavaUtilSet.add(j);
    }
  }
  
  protected void b(Intent paramIntent)
  {
    paramIntent.putExtra("dataline_forward_type", 102);
    paramIntent.putExtra("dataline_forward_text", this.jdField_a_of_type_JavaLangString);
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
  }
  
  protected boolean c()
  {
    Intent localIntent;
    boolean bool;
    if (j())
    {
      localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false))
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", HardCodeUtil.a(2131704950));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        this.jdField_a_of_type_AndroidOsBundle.putString("forward_text", this.jdField_a_of_type_JavaLangString);
        localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        bool = a(localIntent);
        if (this.jdField_f_of_type_Boolean)
        {
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
          if (QSecFramework.a().a(1003).booleanValue())
          {
            localObject = b().iterator();
            while (((Iterator)localObject).hasNext())
            {
              ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
              SecShareInfoUtil.a().a(1, this.jdField_a_of_type_JavaLangString, localResultRecord.getUinType(), localResultRecord.uin);
              SecShareInfoUtil.a().a();
            }
          }
        }
        else if (!bool)
        {
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
        }
      }
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      return false;
    }
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    if (i == 1008)
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
      localIntent.putExtra("chat_subType", ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).getPublicAccountAioClass((String)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
    else
    {
      localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
    }
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false))
    {
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", HardCodeUtil.a(2131704945));
      localIntent.addFlags(268435456);
      localIntent.addFlags(67108864);
      this.jdField_a_of_type_AndroidOsBundle.putString("forward_text", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      bool = a(localIntent);
      if (this.jdField_f_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
        if (QSecFramework.a().a(1003).booleanValue())
        {
          SecShareInfoUtil.a().a(1, this.jdField_a_of_type_JavaLangString, i, (String)localObject);
          SecShareInfoUtil.a().a();
        }
      }
      else if (!bool)
      {
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
      }
    }
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    return false;
  }
  
  protected int d()
  {
    QfavBuilder localQfavBuilder = QfavBuilder.a(null, this.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    int i = -1;
    if (localQfavBuilder.b(localActivity, str, -1, null)) {
      i = 0;
    }
    if (i == 0) {
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", -1, 0, 69, 0, "", "");
    }
    return i;
  }
  
  public void l()
  {
    super.l();
    AbstractGifImage.pauseAll();
  }
  
  public void m()
  {
    super.m();
    AbstractGifImage.resumeAll();
  }
  
  protected boolean m()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardTextOption
 * JD-Core Version:    0.7.0.1
 */