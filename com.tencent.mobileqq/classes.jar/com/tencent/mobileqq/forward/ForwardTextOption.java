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
import com.tencent.mobileqq.utils.SimpleModeHelper;
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
    this.E = true;
    this.L = 3;
  }
  
  protected View a()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.s);
    localLinearLayout.setOrientation(0);
    AnimationTextView localAnimationTextView = new AnimationTextView(this.s);
    Object localObject2 = n();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localAnimationTextView.setText(new QQText((CharSequence)localObject1, 5, 16));
    localAnimationTextView.setMaxLines(2);
    localAnimationTextView.setEllipsize(TextUtils.TruncateAt.END);
    localAnimationTextView.setTextColor(this.s.getResources().getColorStateList(2131166121));
    localAnimationTextView.setTextSize(14.0F);
    localObject1 = new ImageView(this.s);
    ((ImageView)localObject1).setImageResource(2130840437);
    localObject2 = new LinearLayout.LayoutParams(0, -2, 1.0F);
    ((LinearLayout.LayoutParams)localObject2).gravity = 17;
    localLinearLayout.addView(localAnimationTextView, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new LinearLayout.LayoutParams(ViewUtils.dip2px(8.0F), ViewUtils.dip2px(14.0F));
    ((LinearLayout.LayoutParams)localObject2).gravity = 17;
    ((LinearLayout.LayoutParams)localObject2).setMargins(ViewUtils.dip2px(3.0F), 0, 0, 0);
    SimpleModeHelper.a(localAnimationTextView, (ImageView)localObject1, (ViewGroup.LayoutParams)localObject2);
    localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localLinearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    localObject1 = new View(this.s);
    ((View)localObject1).setId(2131433656);
    ((View)localObject1).setBackgroundResource(2130840448);
    ((View)localObject1).setOnClickListener(new ForwardTextOption.1(this));
    localObject2 = new FrameLayout(this.s);
    int i = ViewUtils.dip2px(20.0F);
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
      if ((localRecentUser != null) && (!Utils.b(localRecentUser.uin)) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 6002) && ((localRecentUser.getType() != 1) || (!c(localRecentUser.uin))) && ((localRecentUser.getType() != 1006) || (a(ForwardAbility.ForwardAbilityType.i))) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 0) || (!CrmUtils.a(this.q, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.E))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.q.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    int j = paramArrayOfDeviceInfo.length;
    int i = 0;
    while (i < j)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      if (localDeviceInfo != null)
      {
        ProductInfo localProductInfo = localSmartDeviceProxyMgr.b(localDeviceInfo.productId);
        if ((localProductInfo != null) && (localProductInfo.isSupportMainMsgType(1)) && (a(k))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  protected void b(Intent paramIntent)
  {
    paramIntent.putExtra("dataline_forward_type", 102);
    paramIntent.putExtra("dataline_forward_text", this.u);
  }
  
  protected void c()
  {
    super.c();
    if (this.r.getBooleanExtra("k_dataline", true))
    {
      this.C.add(g);
      this.C.add(l);
    }
    if ((this.r.getBooleanExtra("k_smartdevice", true)) && (aj())) {
      this.C.add(k);
    }
  }
  
  protected void d()
  {
    super.d();
    this.A.adjustMessageBottomMargin(17.0F);
    this.A.setMessageTextColor(2131166157);
    this.A.setMessageTextSize(14.0F);
  }
  
  public boolean e()
  {
    super.e();
    if (this.u == null)
    {
      SpannableString localSpannableString = (SpannableString)this.t.get("forward_text");
      if (localSpannableString != null) {
        this.u = localSpannableString.toString();
      }
    }
    return true;
  }
  
  protected boolean f()
  {
    Intent localIntent;
    boolean bool;
    if (K())
    {
      localIntent = AIOUtils.a(new Intent(this.s, SplashActivity.class), null);
      if (this.r.getBooleanExtra("isFromShare", false))
      {
        this.t.putString("leftBackText", HardCodeUtil.a(2131902842));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        this.t.putString("forward_text", this.u);
        localIntent.putExtras(this.t);
        bool = c(localIntent);
        if (this.K)
        {
          ForwardUtils.a(this.q, this.s, this.I, localIntent, null);
          if (QSecFramework.c().a(1003).booleanValue())
          {
            localObject = M().iterator();
            while (((Iterator)localObject).hasNext())
            {
              ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
              SecShareInfoUtil.a().a(1, this.u, localResultRecord.getUinType(), localResultRecord.uin);
              SecShareInfoUtil.a().c();
            }
          }
        }
        else if (!bool)
        {
          ForwardUtils.a(this.q, this.s, this.I, localIntent, null);
        }
      }
      this.t.putBoolean("isBack2Root", false);
      localIntent.putExtras(this.t);
      this.s.setResult(-1, localIntent);
      return false;
    }
    int i = this.t.getInt("uintype");
    Object localObject = this.t.getString("uin");
    if (i == 1008)
    {
      localIntent = new Intent(this.s, ChatActivity.class);
      localIntent.putExtra("chat_subType", ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).getPublicAccountAioClass((String)localObject, this.q));
    }
    else
    {
      localIntent = AIOUtils.a(new Intent(this.s, SplashActivity.class), null);
    }
    if (this.r.getBooleanExtra("isFromShare", false))
    {
      this.t.putString("leftBackText", HardCodeUtil.a(2131902837));
      localIntent.addFlags(268435456);
      localIntent.addFlags(67108864);
      this.t.putString("forward_text", this.u);
      localIntent.putExtras(this.t);
      bool = c(localIntent);
      if (this.K)
      {
        this.s.startActivity(localIntent);
        if (QSecFramework.c().a(1003).booleanValue())
        {
          SecShareInfoUtil.a().a(1, this.u, i, (String)localObject);
          SecShareInfoUtil.a().c();
        }
      }
      else if (!bool)
      {
        ForwardUtils.a(this.q, this.s, this.I, localIntent, null);
      }
    }
    this.t.putBoolean("isBack2Root", false);
    localIntent.putExtras(this.t);
    this.s.setResult(-1, localIntent);
    this.s.finish();
    return false;
  }
  
  protected void g()
  {
    f();
  }
  
  protected int h()
  {
    QfavBuilder localQfavBuilder = QfavBuilder.a(null, this.u).a(this.q);
    Activity localActivity = this.s;
    String str = this.q.getAccount();
    int i = -1;
    if (localQfavBuilder.b(localActivity, str, -1, null)) {
      i = 0;
    }
    if (i == 0) {
      QfavReport.a(this.q, "User_AddFav", -1, 0, 69, 0, "", "");
    }
    return i;
  }
  
  public void i()
  {
    super.i();
    AbstractGifImage.resumeAll();
  }
  
  public void j()
  {
    super.j();
    AbstractGifImage.pauseAll();
  }
  
  protected boolean k()
  {
    return true;
  }
  
  public boolean l()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardTextOption
 * JD-Core Version:    0.7.0.1
 */