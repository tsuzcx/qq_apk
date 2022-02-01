package com.tencent.mobileqq.qcall;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.friend.FriendsUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.vipav.VipFunCallObserver;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QCallDetailActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private String A;
  private String B;
  private AvatarObserver C = new QCallDetailActivity.1(this);
  private FriendListObserver D = new QCallDetailActivity.2(this);
  private DiscussionObserver E = new QCallDetailActivity.3(this);
  private int F = -1;
  private int[] G;
  Runnable a = new QCallDetailActivity.4(this);
  VipFunCallObserver b = new QCallDetailActivity.10(this);
  private LinearLayout c;
  private RelativeLayout d;
  private RelativeLayout e;
  private TextView f;
  private ImageView g;
  private TextView h;
  private TextView i;
  private ImageView j;
  private TextView k;
  private View l;
  private XListView m;
  private Button n;
  private QCallDetailActivity.QCalDetailAdapter o;
  private String p;
  private String q;
  private int r;
  private int s;
  private String t;
  private int u;
  private String v;
  private Friends w;
  private QCallFacade x;
  private FriendListHandler y;
  private String z;
  
  private String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 2)
      {
        if (paramInt != 1004)
        {
          if (paramInt != 1006) {
            return "999";
          }
          return "3";
        }
        return "1";
      }
      return "2";
    }
    return "0";
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      finish();
      return;
    }
    this.p = paramIntent.getStringExtra("uin");
    this.q = paramIntent.getStringExtra("troop_uin");
    this.r = paramIntent.getIntExtra("uintype", 0);
    if (this.r == 8) {
      this.r = paramIntent.getIntExtra("extra_type", 0);
    }
    this.t = paramIntent.getStringExtra("uinname");
    this.u = paramIntent.getIntExtra("bind_type", 0);
    this.v = paramIntent.getStringExtra("phonenum");
    if (this.u == 2) {
      ReportController.b(this.app, "CliOper", "", "", "0X8004E95", "0X8004E95", 0, 0, "", "", "", "");
    }
    this.rightViewImg.setVisibility(8);
    this.s = this.r;
    if ((this.s == 0) && (!b(this.p))) {
      this.s = 1003;
    }
    this.F = paramIntent.getIntExtra("contactID", -1);
    if (this.F == -1)
    {
      paramIntent = (IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "");
      int i1 = this.r;
      if (i1 != 1006)
      {
        if (i1 != 56938) {
          paramIntent = paramIntent.queryPhoneContactByUin(this.p);
        } else {
          paramIntent = paramIntent.queryPhoneContactByMobile(this.p);
        }
      }
      else {
        paramIntent = paramIntent.queryContactByCodeNumber(this.p);
      }
      if (paramIntent != null) {
        this.F = paramIntent.contactID;
      }
    }
  }
  
  private void b()
  {
    ThreadManager.post(this.a, 8, null, false);
  }
  
  private boolean b(String paramString)
  {
    return ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(paramString);
  }
  
  private void c()
  {
    Object localObject1 = LayoutInflater.from(this);
    Object localObject3 = null;
    this.c = ((LinearLayout)((LayoutInflater)localObject1).inflate(2131627342, null));
    this.g = ((ImageView)this.c.findViewById(2131434878));
    this.h = ((TextView)this.c.findViewById(2131439121));
    this.i = ((TextView)this.c.findViewById(2131434375));
    this.j = ((ImageView)this.c.findViewById(2131439195));
    this.k = ((TextView)this.c.findViewById(2131439194));
    this.d = ((RelativeLayout)this.c.findViewById(2131436968));
    this.e = ((RelativeLayout)this.c.findViewById(2131436900));
    this.n = ((Button)findViewById(2131430248));
    this.n.setOnClickListener(this);
    this.f = ((TextView)this.c.findViewById(2131430982));
    this.l = this.c.findViewById(2131442288);
    int i1 = getResources().getColor(2131167318);
    this.l.setBackgroundColor(i1);
    localObject1 = this.c.findViewById(2131442289);
    ((View)localObject1).setBackgroundColor(i1);
    this.h.setText(this.t);
    Object localObject4 = (TextView)this.c.findViewById(2131434933);
    Object localObject2 = (ImageView)this.c.findViewById(2131444798);
    i1 = this.r;
    Object localObject5;
    if (i1 != 25)
    {
      if (i1 != 26)
      {
        if ((i1 != 1001) && (i1 != 1010))
        {
          if (i1 != 2016) {
            if (i1 != 3000)
            {
              if ((i1 == 10002) || (i1 == 10004)) {
                break label637;
              }
              if (i1 != 56938)
              {
                this.g.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, this.p));
                break label1022;
              }
            }
            else
            {
              this.g.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 101, this.p));
              localObject4 = (DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
              if (localObject4 != null) {
                i1 = ((DiscussionManager)localObject4).c(this.p);
              } else {
                i1 = 0;
              }
              if (i1 > 0)
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("(");
                ((StringBuilder)localObject4).append(i1);
                ((StringBuilder)localObject4).append(")");
                localObject4 = ((StringBuilder)localObject4).toString();
                this.i.setText((CharSequence)localObject4);
              }
              localObject4 = this.e;
              if ((localObject4 != null) && (localObject1 != null))
              {
                ((RelativeLayout)localObject4).setVisibility(8);
                ((View)localObject1).setVisibility(8);
              }
              ((ImageView)localObject2).setVisibility(0);
              findViewById(2131442283).setVisibility(0);
              this.n.setVisibility(8);
              break label1022;
            }
          }
          this.g.setImageResource(2130843087);
          ((TextView)localObject4).setVisibility(0);
          localObject5 = ContactUtils.c(this.t);
          ((TextView)localObject4).setText((CharSequence)localObject5);
          if (ContactUtils.a((String)localObject5)) {
            ((TextView)localObject4).setTextSize(0, getResources().getDimension(2131299848));
          } else {
            ((TextView)localObject4).setTextSize(0, getResources().getDimension(2131299849));
          }
          ((ImageView)localObject2).setVisibility(8);
          this.k.setText(2131897171);
          ((View)localObject1).setVisibility(8);
          this.e.setVisibility(8);
          findViewById(2131442283).setVisibility(8);
          break label1022;
        }
        label637:
        this.g.setImageDrawable(FaceDrawable.getStrangerFaceDrawable(this.app, 200, this.p, true));
      }
      else
      {
        this.B = null;
        localObject5 = OpenSDKUtils.a(this.app, this.p);
        if (localObject5 != null) {
          this.B = ((PhoneContact)localObject5).uin;
        }
        if (this.B == null)
        {
          ((ImageView)localObject2).setVisibility(8);
          this.g.setImageResource(2130843087);
          ((TextView)localObject4).setVisibility(0);
          ((TextView)localObject4).setText(ContactUtils.c(this.t));
        }
        else
        {
          ((ImageView)localObject2).setVisibility(0);
          this.g.setImageDrawable(OpenSDKUtils.d(this.app, this.p));
        }
        findViewById(2131442283).setVisibility(8);
        this.n.setVisibility(0);
        ((View)localObject1).setVisibility(8);
        this.e.setVisibility(8);
      }
    }
    else
    {
      localObject4 = (IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "");
      if (localObject4 != null) {
        localObject1 = ((IPhoneContactService)localObject4).queryContactByCodeNumber(this.v);
      } else {
        localObject1 = null;
      }
      localObject2 = localObject1;
      if (localObject4 != null)
      {
        localObject5 = this.v;
        localObject2 = localObject1;
        if (localObject5 != null) {
          localObject2 = ((IPhoneContactService)localObject4).queryContactByCodeNumber((String)localObject5);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getFaceBitmap contact = ");
        ((StringBuilder)localObject1).append(localObject2);
        QLog.d("QCallDetailActivity", 2, ((StringBuilder)localObject1).toString());
      }
      if (localObject2 != null)
      {
        localObject1 = FaceDrawable.getMobileFaceDrawable(this.app, this.v, (byte)3);
        this.h.setText(((PhoneContact)localObject2).name);
        if (localObject1 != null) {
          this.g.setImageDrawable((Drawable)localObject1);
        }
      }
      else
      {
        localObject1 = this.app.getFaceBitmap(16, this.p, (byte)3, true, 16);
        localObject2 = ((QCallCardManager)this.app.getManager(QQManagerFactory.QCALLCARD_MANAGER)).a(this.p);
        if ((localObject2 != null) && (((QCallCardInfo)localObject2).nickname != null)) {
          this.h.setText(((QCallCardInfo)localObject2).nickname);
        }
        if (localObject1 != null) {
          this.g.setImageBitmap((Bitmap)localObject1);
        }
      }
    }
    label1022:
    ThreadManager.post(new QCallDetailActivity.5(this), 8, null, true);
    a(true);
    this.e.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.k.setOnTouchListener(new QCallDetailActivity.6(this));
    localObject1 = localObject3;
    if (this.F != -1)
    {
      localObject1 = this.app.getEntityManagerFactory().createEntityManager();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("contactID = ");
      ((StringBuilder)localObject2).append(this.F);
      localObject1 = ((EntityManager)localObject1).query(PhoneContact.class, false, ((StringBuilder)localObject2).toString(), null, null, null, null, null);
      ReportController.b(this.app, "CliOper", "", "", "0X8005AF4", "0X8005AF4", 0, 0, "", "", "", "");
    }
    if (this.r == 26)
    {
      localObject1 = new ArrayList();
      localObject2 = new PhoneContact();
      ((PhoneContact)localObject2).mobileNo = this.p;
      ((PhoneContact)localObject2).type = 0;
      ((PhoneContact)localObject2).label = HardCodeUtil.a(2131907284);
      ((List)localObject1).add(localObject2);
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      this.c.findViewById(2131442290).setVisibility(0);
      localObject2 = (NoScrollListView)this.c.findViewById(2131440056);
      ((NoScrollListView)localObject2).setVisibility(0);
      ((NoScrollListView)localObject2).setAdapter(new PhoneNumberAdapter(this, (List)localObject1));
      ((NoScrollListView)localObject2).setOnItemClickListener(new QCallDetailActivity.7(this));
    }
  }
  
  private void d()
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateOnlineStatus mFriendUin : ");
      localStringBuilder.append(this.p);
      localStringBuilder.append(" , uinType = ");
      localStringBuilder.append(this.r);
      QLog.d("QCallDetailActivity", 2, localStringBuilder.toString());
    }
    this.w = localFriendsManager.m(this.p);
  }
  
  private void e()
  {
    if (this.r == 3000)
    {
      this.j.setVisibility(8);
      this.k.setVisibility(8);
      return;
    }
    Object localObject = this.w;
    if (localObject != null)
    {
      if ((((Friends)localObject).iTermType != 68104) && (this.w.iTermType != 65805))
      {
        int i1 = FriendsUtils.a(this.w.eNetwork, this.w.iTermType, this.w.netTypeIconId);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("friend.getNetWorkType()：");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append(", friend.detalStatusFlag：");
          ((StringBuilder)localObject).append(this.w.detalStatusFlag);
          ((StringBuilder)localObject).append(", friend.iTermType：");
          ((StringBuilder)localObject).append(this.w.iTermType);
          QLog.d("QCallDetailActivity", 2, ((StringBuilder)localObject).toString());
        }
        if (OnlineStatusUtils.a(this.w.detalStatusFlag, this.w.iTermType) == 0) {
          return;
        }
        if ((i1 != 2) && (i1 != 3) && (i1 != 4) && (i1 != 5) && (i1 != 1) && (this.w.netTypeIconId != 7) && (this.w.netTypeIconId != 8))
        {
          this.j.setVisibility(8);
          return;
        }
        if (i1 == 2)
        {
          this.j.setVisibility(8);
          this.k.setText(2131896645);
          this.k.setContentDescription(getString(2131896645));
          return;
        }
        if (i1 == 3)
        {
          this.j.setVisibility(8);
          this.k.setText(2131896646);
          this.k.setContentDescription(getString(2131896646));
          return;
        }
        if (i1 == 4)
        {
          this.j.setVisibility(8);
          this.k.setText(2131896647);
          this.k.setContentDescription(getString(2131896647));
          return;
        }
        if (i1 == 5)
        {
          this.j.setVisibility(8);
          this.k.setText(2131896648);
          this.k.setContentDescription(getString(2131896648));
          return;
        }
        if (this.w.netTypeIconId == 7)
        {
          this.j.setVisibility(8);
          this.k.setText(getString(2131896651));
          this.k.setContentDescription(getString(2131896651));
          return;
        }
        if (this.w.netTypeIconId == 8)
        {
          this.j.setVisibility(8);
          this.k.setText(getString(2131896649));
          this.k.setContentDescription(getString(2131896649));
          return;
        }
        if (this.w.netTypeIconId == 9)
        {
          this.j.setVisibility(8);
          this.k.setText(getString(2131896650));
          this.k.setContentDescription(getString(2131896650));
          return;
        }
        this.j.setVisibility(0);
        this.j.setBackgroundResource(2130846471);
        this.k.setText(2131896652);
        this.k.setContentDescription(getString(2131896652));
        return;
      }
      this.j.setVisibility(8);
      this.k.setVisibility(8);
    }
  }
  
  private void f()
  {
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131442286);
    Button localButton1 = (Button)localLinearLayout1.findViewById(2131448897);
    localLinearLayout1.setOnClickListener(this);
    localButton1.setTag(Integer.valueOf(2131442286));
    localButton1.setOnClickListener(this);
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131442285);
    Button localButton2 = (Button)localLinearLayout2.findViewById(2131448897);
    localLinearLayout2.setOnClickListener(this);
    localButton2.setTag(Integer.valueOf(2131442285));
    localButton2.setOnClickListener(this);
    LinearLayout localLinearLayout3 = (LinearLayout)findViewById(2131442284);
    Button localButton3 = (Button)localLinearLayout3.findViewById(2131448897);
    localLinearLayout3.setOnClickListener(this);
    localButton3.setTag(Integer.valueOf(2131442284));
    localButton3.setOnClickListener(this);
    localButton1.setText(2131916257);
    int i1 = this.r;
    if (i1 == 3000)
    {
      localButton1.setContentDescription(HardCodeUtil.a(2131907283));
      localButton3.setText(2131890886);
      localButton3.setContentDescription(localButton3.getResources().getString(2131890852));
      localLinearLayout2.setVisibility(8);
    }
    else if (i1 == 1008)
    {
      localLinearLayout2.setVisibility(8);
      localLinearLayout1.setVisibility(8);
      localButton3.setText(2131890852);
      localButton3.setContentDescription(getString(2131896641));
      this.e.setVisibility(8);
    }
    else
    {
      int i2 = this.u;
      if ((i2 != 2) && (i2 != 3) && (i1 != 25))
      {
        localButton1.setContentDescription(HardCodeUtil.a(2131907282));
        localButton3.setText(2131890852);
        localButton3.setContentDescription(localButton3.getResources().getString(2131890852));
        if (!CrmUtils.a(this.app, this.p, this.r))
        {
          localLinearLayout2.setVisibility(0);
          localButton2.setText(2131896643);
          localButton2.setContentDescription(localButton2.getResources().getString(2131896643));
        }
        else
        {
          localLinearLayout2.setVisibility(8);
          i1 = this.u;
          if ((i1 == 2) || (i1 == 3) || (this.r == 25))
          {
            localLinearLayout2.setVisibility(8);
            localButton3.setContentDescription(getString(2131896642));
          }
        }
      }
      else
      {
        localLinearLayout2.setVisibility(8);
        localLinearLayout1.setVisibility(8);
        localButton3.setText(2131890852);
        localButton3.setContentDescription(getString(2131896641));
      }
    }
    if (this.r != 0)
    {
      localLinearLayout3.setVisibility(8);
      localLinearLayout2.setVisibility(8);
    }
  }
  
  private void g()
  {
    this.m = ((XListView)findViewById(2131442287));
    this.m.addHeaderView(this.c);
    this.o = new QCallDetailActivity.QCalDetailAdapter(this);
    this.m.setAdapter(this.o);
  }
  
  private void h()
  {
    if (this.r == 3000)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004068", "0X8004068", 0, 0, "", "", "", "");
      ReportController.b(this.app, "CliOper", "", "", "0X8004F91", "0X8004F91", 0, 0, "", "", "", "");
      ChatActivityUtils.a(this.app, this, this.r, this.z, true, true, null, null);
      return;
    }
    ReportController.b(this.app, "CliOper", "", this.p, "Two_video_call", "Tvc_msg_info_launch", 0, 0, "", "", "", "");
    ReportController.b(this.app, "CliOper", "", "", "0X8004F8A", "0X8004F8A", 0, 0, "", "", "", "");
    if (this.r == 1024)
    {
      CrmUtils.a(this.app, this, this.t, this.z, "IvrCallDetailEngineFalse");
      return;
    }
    ChatActivityUtils.a(this.app, this, this.r, this.z, this.t, this.A, true, this.q, true, true, null, "from_internal");
  }
  
  private void i()
  {
    int i1 = this.s;
    if (i1 == 1024)
    {
      CrmUtils.a(this, null, this.p, false, -1, true, 2000);
      return;
    }
    if (i1 == 1008)
    {
      localObject = new ActivityURIRequest(this, "/pubaccount/detail");
      ((ActivityURIRequest)localObject).extra().putString("uin", this.p);
      ((ActivityURIRequest)localObject).extra().putInt("uintype", 1008);
      ((ActivityURIRequest)localObject).extra().putInt("source", 113);
      ((ActivityURIRequest)localObject).setRequestCode(2000);
      QRoute.startUri((URIRequest)localObject, null);
      return;
    }
    Object localObject = new AllInOne(this.p, 46);
    ((AllInOne)localObject).pa = 19;
    ((AllInOne)localObject).nickname = ContactUtils.a(this.app, this.p);
    i1 = this.s;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 25)
        {
          if (i1 != 26)
          {
            if (i1 != 1000)
            {
              if (i1 != 1001)
              {
                if (i1 != 1009)
                {
                  if (i1 != 1010)
                  {
                    if (i1 != 4000)
                    {
                      if (i1 != 10002) {
                        if (i1 == 10010) {}
                      }
                      switch (i1)
                      {
                      default: 
                        switch (i1)
                        {
                        default: 
                          break;
                        case 1023: 
                          ((AllInOne)localObject).pa = 74;
                          break;
                        case 1022: 
                          ((AllInOne)localObject).pa = 27;
                          break;
                        case 1021: 
                          ((AllInOne)localObject).pa = 72;
                          break;
                        case 1020: 
                          ((AllInOne)localObject).pa = 58;
                        }
                        break;
                      case 1005: 
                        ((AllInOne)localObject).pa = 2;
                        break;
                      case 1004: 
                        ((AllInOne)localObject).pa = 47;
                        ((AllInOne)localObject).discussUin = this.q;
                        break;
                      case 1003: 
                        ((AllInOne)localObject).pa = 70;
                        break;
                        ((AllInOne)localObject).pa = 117;
                        break;
                        ((AllInOne)localObject).pa = 86;
                        break;
                      }
                    }
                    else
                    {
                      ((AllInOne)localObject).pa = 34;
                    }
                  }
                  else {
                    ((AllInOne)localObject).pa = 76;
                  }
                }
                else {
                  ((AllInOne)localObject).pa = 57;
                }
              }
              else {
                ((AllInOne)localObject).pa = 42;
              }
            }
            else
            {
              ((AllInOne)localObject).pa = 22;
              ((AllInOne)localObject).troopUin = this.q;
            }
          }
          else
          {
            if (TextUtils.isEmpty(this.B)) {
              return;
            }
            if (this.B.equals("0"))
            {
              ((AllInOne)localObject).pa = 34;
            }
            else
            {
              ((AllInOne)localObject).pa = 1;
              ((AllInOne)localObject).uin = this.B;
              ((AllInOne)localObject).nickname = ContactUtils.a(this.app, this.B);
            }
          }
        }
        else {
          j();
        }
      }
      else {
        ((AllInOne)localObject).pa = 20;
      }
    }
    else {
      ((AllInOne)localObject).pa = 1;
    }
    i1 = this.s;
    if ((i1 != 1001) && (i1 != 10002) && (i1 != 10004) && (i1 != 1010))
    {
      ProfileUtils.openProfileCard(this, (AllInOne)localObject);
      return;
    }
    i1 = this.s;
    if ((i1 != 1001) && (i1 != 10002))
    {
      if (i1 == 1010) {
        ((AllInOne)localObject).profileEntryType = 13;
      }
    }
    else {
      ((AllInOne)localObject).profileEntryType = 12;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("AllInOne", (Parcelable)localObject);
    if (Utils.a(this.p, this.app.getCurrentAccountUin())) {
      localIntent.putExtra("param_mode", 2);
    } else {
      localIntent.putExtra("param_mode", 3);
    }
    RouteUtils.a(BaseApplicationImpl.getContext(), localIntent, "/nearby/people/profile");
  }
  
  private void j()
  {
    AllInOne localAllInOne = new AllInOne(this.p, 80);
    QCallCardInfo localQCallCardInfo = ((QCallCardManager)this.app.getManager(QQManagerFactory.QCALLCARD_MANAGER)).a(this.p);
    Object localObject1 = (IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = this.v;
      if (localObject2 != null)
      {
        localObject1 = ((IPhoneContactService)localObject1).queryContactByCodeNumber((String)localObject2);
        break label80;
      }
    }
    localObject1 = null;
    label80:
    if (localQCallCardInfo != null)
    {
      localAllInOne.nickname = localQCallCardInfo.nickname;
      localAllInOne.gender = ((byte)localQCallCardInfo.gender);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("QCallCardInfo.uin = ");
        ((StringBuilder)localObject2).append(localQCallCardInfo.uin);
        ((StringBuilder)localObject2).append("QCallCardInfo.nickname = ");
        ((StringBuilder)localObject2).append(localQCallCardInfo.nickname);
        ((StringBuilder)localObject2).append("mPhoneNumber = ");
        ((StringBuilder)localObject2).append(this.v);
        ((StringBuilder)localObject2).append("mFriendUin = ");
        ((StringBuilder)localObject2).append(this.p);
        QLog.i("startQCallProfileCardActivity ", 2, ((StringBuilder)localObject2).toString());
      }
    }
    if (localObject1 != null) {
      localAllInOne.nickname = ((PhoneContact)localObject1).name;
    }
    if (((localObject1 != null) || (localQCallCardInfo != null)) && (this.v != null))
    {
      localAllInOne.pa = 80;
      localObject1 = new ProfileContactInfo(HardCodeUtil.a(2131907281), this.v, "");
      if (localAllInOne.contactArray == null)
      {
        localAllInOne.contactArray = new ArrayList();
        localAllInOne.contactArray.add(localObject1);
      }
      ProfileUtils.openProfileCard(this.app.getApplication().getApplicationContext(), localAllInOne);
      int i1 = this.r;
      if (i1 == 25)
      {
        ReportController.b(null, "CliOper", "", "", "0X8006251", "0X8006251", 0, 0, "", "", "", "");
        return;
      }
      if (i1 != 24)
      {
        i1 = this.u;
        if ((i1 != 2) && (i1 != 3)) {}
      }
      else
      {
        ReportController.b(null, "CliOper", "", "", "0X8006250", "0X8006250", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this, DiscussionInfoCardActivity.class);
    localIntent.putExtra("uin", this.p);
    localIntent.putExtra("uinname", this.t);
    localIntent.putExtra("uintype", this.s);
    startActivityForResult(localIntent, 2000);
  }
  
  public void a(Context paramContext, String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.create(paramContext);
    int[] arrayOfInt = this.G;
    arrayOfInt[0] = 2;
    arrayOfInt[1] = 3;
    if (this.r == 26)
    {
      OpenSDKUtils.a(this.app, paramContext, paramString);
      return;
    }
    localActionSheet.addButton(2131887640);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnDismissListener(new QCallDetailActivity.8(this));
    localActionSheet.setOnButtonClickListener(new QCallDetailActivity.9(this, paramString, localActionSheet));
    localActionSheet.show();
    ReportController.b(this.app, "CliOper", "", "", "0X8005AF6", "0X8005AF6", 0, 0, "", "", "", "");
  }
  
  public void a(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    DiscussionManager localDiscussionManager = (DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if (localDiscussionManager == null) {
      return;
    }
    DiscussionInfo localDiscussionInfo = localDiscussionManager.d(paramString);
    if ((localDiscussionInfo != null) && (localDiscussionInfo.discussionName != null))
    {
      this.t = localDiscussionInfo.discussionName;
      this.g.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 101, paramString));
      int i1 = localDiscussionManager.c(paramString);
      this.h.setText(this.t);
      if (i1 > 0)
      {
        paramString = new StringBuilder();
        paramString.append("(");
        paramString.append(i1);
        paramString.append(")");
        paramString = paramString.toString();
      }
      else
      {
        paramString = "";
      }
      this.i.setText(paramString);
    }
  }
  
  void a(boolean paramBoolean)
  {
    int i1 = VipFunCallUtil.a(this.app, this.p, 6, true, null);
    if ((i1 == 0) && (paramBoolean) && (this.app != null)) {
      try
      {
        VipSetFunCallHandler localVipSetFunCallHandler = (VipSetFunCallHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER);
        localObject = new Bundle();
        ((Bundle)localObject).putLong("uin", Long.parseLong(this.p));
        ((Bundle)localObject).putString("phone", "");
        this.app.addObserver(this.b, true);
        localVipSetFunCallHandler.a(2, localObject);
      }
      catch (Exception localException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("VipSetFunCallHandler Error:");
        ((StringBuilder)localObject).append(localException.getMessage());
        QLog.e("QCallDetailActivity", 1, ((StringBuilder)localObject).toString());
      }
    }
    String str;
    if (i1 == 0) {
      str = getResources().getString(2131887642);
    } else {
      str = VipFunCallUtil.b(this.app, i1, -1, "name");
    }
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = getResources().getString(2131887642);
    }
    this.f.setText((CharSequence)localObject);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 2000) {
        return;
      }
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramIntent != null)
      {
        bool1 = bool2;
        if (paramIntent.getExtras() != null) {
          bool1 = paramIntent.getExtras().getBoolean("isNeedFinish");
        }
      }
      if (bool1) {
        finish();
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131627341);
    paramBundle = getString(2131896653);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBundle);
    localStringBuilder.append(getString(2131893675));
    setTitle(paramBundle, localStringBuilder.toString());
    setLeftViewName(2131893178);
    this.x = ((QCallFacade)this.app.getManager(QQManagerFactory.RECENT_CALL_FACADE));
    a(getIntent());
    c();
    f();
    g();
    addObserver(this.D);
    addObserver(this.C);
    addObserver(this.E);
    this.y = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    if ((this.r == 0) && (!this.y.isGetOnlineListRecently()) && (!this.y.shouldGetOnlineInfo())) {
      this.y.getOnlineInfo(this.p, false);
    }
    this.G = new int[3];
    int i1 = this.r;
    if (i1 == 25)
    {
      ReportController.b(null, "CliOper", "", "", "0X800624F", "0X800624F", 0, 0, "", "", "", "");
    }
    else if (i1 != 24)
    {
      i1 = this.u;
      if ((i1 != 2) && (i1 != 3)) {}
    }
    else
    {
      ReportController.b(null, "CliOper", "", "", "0X800624E", "0X800624E", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public void onClick(View paramView)
  {
    this.z = null;
    this.A = null;
    if (this.r == 1006) {
      this.A = this.p;
    } else {
      this.z = this.p;
    }
    int i2 = paramView.getId();
    int i1 = i2;
    if (2131448897 == i2) {}
    try
    {
      i1 = ((Integer)paramView.getTag()).intValue();
      Object localObject;
      switch (i1)
      {
      default: 
        break;
      case 2131442286: 
        if (this.r == 3000)
        {
          ReportController.b(this.app, "CliOper", "", "", "0X8004069", "0X8004069", 0, 0, "", "", "", "");
          ReportController.b(this.app, "CliOper", "", "", "0X8004F90", "0X8004F90", 0, 0, "", "", "", "");
        }
        else
        {
          ReportController.b(this.app, "CliOper", "", "", "0X8004F89", "0X8004F89", 0, 0, "", "", "", "");
        }
        localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
        ((Intent)localObject).putExtra("uin", this.p);
        ((Intent)localObject).putExtra("uintype", this.r);
        ((Intent)localObject).putExtra("uinname", this.t);
        ((Intent)localObject).putExtra("entrance", 0);
        startActivity((Intent)localObject);
        break;
      case 2131442285: 
        ReportController.b(this.app, "CliOper", "", this.p, "Two_call", "Two_call_launch", 0, 0, "15", a(this.r), "", "");
        ReportController.b(this.app, "CliOper", "", "", "0X8004F8B", "0X8004F8B", 0, 0, "", "", "", "");
        if (this.r == 1024)
        {
          if (CrmUtils.a(this.app, this.z, this.r))
          {
            CrmUtils.a(this.app, this, this.t, this.z, "IvrCallDetailEngineFalse");
            ReportController.b(this.app, "CliOper", "", "", "0X80049D6", "0X80049D6", 0, 0, "", "", "", "");
          }
          else
          {
            QQToast.makeText(paramView.getContext(), 2131893465, 1).show(paramView.getContext().getResources().getDimensionPixelSize(2131299920));
            if (QLog.isColorLevel()) {
              QLog.d("QCallDetailActivity", 2, "Don't support ivr");
            }
          }
        }
        else {
          ChatActivityUtils.a(this.app, this, this.r, this.z, this.t, this.A, false, this.q, true, true, null, "from_internal");
        }
        break;
      case 2131442284: 
        h();
        break;
      case 2131436968: 
      case 2131439194: 
        i1 = this.r;
        if (i1 != 2016) {
          if (i1 != 3000)
          {
            if (i1 != 56938)
            {
              i();
              ReportController.b(this.app, "CliOper", "", "", "0X8004F8C", "0X8004F8C", 0, 0, "", "", "", "");
            }
          }
          else
          {
            ReportController.b(this.app, "CliOper", "", "", "0X8004F92", "0X8004F92", 0, 0, "", "", "", "");
            a();
          }
        }
        break;
      case 2131436900: 
        i1 = ((ISVIPHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).j();
        if (i1 == 2) {
          i1 = 0;
        } else if (i1 == 3) {
          i1 = 2;
        }
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("individuation_url_type", 40304);
        VasWebviewUtil.b(this, IndividuationUrlHelper.a(this, "call", "mvip.gongneng.anroid.individuation.web"), 524288L, (Intent)localObject, true, -1);
        localObject = this.app;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i1);
        ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8004A1F", "0X8004A1F", 0, 0, localStringBuilder.toString(), "", "", "");
        break;
      case 2131436180: 
        finish();
        break;
      case 2131430248: 
        if (this.r == 26) {
          OpenSDKUtils.a(this.app, this, this.p);
        }
        break;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i1 = i2;
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.app != null) {
      this.app.removeObserver(this.b);
    }
    ChatActivityUtils.a();
    QCallDetailActivity.QCalDetailAdapter localQCalDetailAdapter = this.o;
    if (localQCalDetailAdapter != null)
    {
      localQCalDetailAdapter.a = null;
      this.o = null;
    }
    ThreadManager.remove(this.a);
    this.a = null;
    removeObserver(this.D);
    removeObserver(this.C);
    removeObserver(this.E);
  }
  
  protected void onResume()
  {
    super.onResume();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity
 * JD-Core Version:    0.7.0.1
 */