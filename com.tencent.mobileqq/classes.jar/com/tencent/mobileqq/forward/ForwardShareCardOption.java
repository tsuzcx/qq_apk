package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import antl;
import antp;
import antq;
import anvk;
import anvx;
import aoep;
import aofu;
import aqkw;
import aupt;
import auuq;
import auur;
import auus;
import awyz;
import bdla;
import bdnr;
import bdnu;
import bdnv;
import bdoe;
import bdof;
import bdpx;
import bdqn;
import bdry;
import bdsv;
import bghb;
import bjxa;
import bjyh;
import bjyi;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.List;
import java.util.Set;
import mqq.manager.TicketManager;

public class ForwardShareCardOption
  extends aupt
{
  antl jdField_a_of_type_Antl;
  private aofu jdField_a_of_type_Aofu = new auuq(this);
  private bjyh jdField_a_of_type_Bjyh = new auur(this);
  AbsShareMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
  AbsStructMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  private antq b;
  private int e = -1;
  private int f;
  private int g;
  private int jdField_h_of_type_Int;
  private String jdField_h_of_type_JavaLangString;
  private String jdField_i_of_type_JavaLangString;
  boolean jdField_i_of_type_Boolean;
  private String jdField_j_of_type_JavaLangString;
  private boolean jdField_j_of_type_Boolean;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  
  public ForwardShareCardOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_b_of_type_Antq = new auus(this);
  }
  
  private void I()
  {
    boolean bool = false;
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692125), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299080));
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardShareCardOption", 2, "tryToGetShareLink: net is not supported");
      }
      this.e = -1;
    }
    a(2131694477);
    if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.k))
    {
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.k);
      ((bjyi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).b(this.k, ((TroopInfo)localObject).troopowneruin);
      return;
    }
    Object localObject = (aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    String str = this.k;
    if (this.e == 0) {
      bool = true;
    }
    ((aoep)localObject).a(str, bool);
  }
  
  private View a(String paramString, Drawable paramDrawable)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131559042, null);
    TextView localTextView = (TextView)localView.findViewById(2131380369);
    ImageView localImageView = (ImageView)localView.findViewById(2131368764);
    localTextView.setText(paramString);
    localImageView.setImageDrawable(paramDrawable);
    return localView;
  }
  
  private static bdnv a(String paramString)
  {
    bdry localbdry = new bdry();
    localbdry.b(1);
    localbdry.a(paramString);
    return localbdry;
  }
  
  public static final AbsShareMsg a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = new bdnr(StructMsgForGeneralShare.class);
    if (paramString2 == null)
    {
      paramQQAppInterface = "";
      Object localObject2 = new StringBuilder().append("mqqapi://card/show_pslcard?src_type=internal_phone&source=sharecard&nickname=").append(URLEncoder.encode(paramQQAppInterface));
      if (!paramBoolean) {
        break label302;
      }
      paramString2 = "";
      label47:
      localObject2 = paramString2 + "&version=1&uin=" + paramString1 + "";
      paramString2 = ((bdnr)localObject1).c(84).a(2).a(anvx.a(2131704282) + paramQQAppInterface).a("plugin", "", "AppCmd://OpenContactInfo/?uin=", (String)localObject2, (String)localObject2).d(paramActivity.getResources().getString(2131717989)).a();
      localObject1 = new bdqn();
      ((bdnv)localObject1).b(1);
      ((bdnv)localObject1).a(new bdpx((String)localObject2));
      ((bdnv)localObject1).a(new StructMsgItemTitle(paramQQAppInterface));
      if (!paramString1.startsWith("+86")) {
        break label342;
      }
    }
    label302:
    label342:
    for (paramQQAppInterface = paramString1.substring("+86".length(), paramString1.length());; paramQQAppInterface = paramString1)
    {
      if (paramBoolean) {}
      for (paramActivity = anvx.a(2131704305);; paramActivity = anvx.a(2131704287))
      {
        paramQQAppInterface = new bdsv(paramActivity + paramQQAppInterface);
        paramQQAppInterface.d(paramActivity + paramString1);
        ((bdnv)localObject1).a(paramQQAppInterface);
        paramString2.addItem(a(anvx.a(2131704312)));
        paramString2.addItem((bdnu)localObject1);
        return paramString2;
        paramQQAppInterface = paramString2.trim();
        break;
        paramString2 = "&headtext=" + URLEncoder.encode(ContactUtils.getHeaderText(paramQQAppInterface));
        break label47;
      }
    }
  }
  
  private void a(CardOCRInfo paramCardOCRInfo)
  {
    if (paramCardOCRInfo == null) {
      return;
    }
    Object localObject2 = new bdnr(StructMsgForGeneralShare.class);
    if (paramCardOCRInfo.a == null) {
      paramCardOCRInfo.a = "";
    }
    Object localObject1;
    if ((paramCardOCRInfo.jdField_b_of_type_JavaUtilList != null) && (paramCardOCRInfo.jdField_b_of_type_JavaUtilList.size() > 0))
    {
      localObject1 = (String)paramCardOCRInfo.jdField_b_of_type_JavaUtilList.get(0);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    for (;;)
    {
      Object localObject3 = "url=" + paramCardOCRInfo.jdField_b_of_type_JavaLangString + ";name=" + paramCardOCRInfo.a + ";phone=" + (String)localObject1;
      localObject2 = ((bdnr)localObject2).c(73).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131698315, new Object[] { paramCardOCRInfo.a })).a(2).a("shareBusinessCard", "", (String)localObject3, (String)localObject3, (String)localObject3).d(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718636)).a();
      localObject3 = new bdry();
      ((bdnv)localObject3).b(1);
      ((bdnv)localObject3).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131698313));
      bdqn localbdqn = new bdqn();
      localbdqn.b(3);
      localbdqn.a(new bdpx(paramCardOCRInfo.jdField_b_of_type_JavaLangString + "/?02"));
      localbdqn.a(new StructMsgItemTitle(paramCardOCRInfo.a));
      localbdqn.a(new bdsv((String)localObject1));
      ((AbsShareMsg)localObject2).addItem((bdnu)localObject3);
      ((AbsShareMsg)localObject2).addItem(localbdqn);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("req_type", 5);
      ((Bundle)localObject1).putString("image_url", paramCardOCRInfo.jdField_b_of_type_JavaLangString);
      aqkw.a(paramCardOCRInfo.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = bdof.a(((StructMsgForImageShare)bdof.a((Bundle)localObject1)).getBytes());
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
      m();
      return;
      localObject1 = "";
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!bjxa.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)) {}
    do
    {
      return;
      localObject1 = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString1);
    } while (localObject1 == null);
    Object localObject2 = new bdnr(StructMsgForGeneralShare.class);
    String str2 = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1 + "&cspecialflag=" + ((Friends)localObject1).cSpecialFlag;
    String str3 = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + paramString1 + "&version=1&cspecialflag=" + ((Friends)localObject1).cSpecialFlag;
    String str4 = "https://share.mp.qq.com/cgi/share.php?uin=" + paramString1 + "&account_flag=" + -7 + "&jumptype=1&card_type=crm&cspecialflag=" + ((Friends)localObject1).cSpecialFlag;
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    Object localObject1 = bjxa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      localObject1 = ((bdnr)localObject2).c(14).a(2).a(1).a(anvx.a(2131704302) + paramString2).a("plugin", str4, "", str2, str3).d(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717984)).a();
      localObject2 = new bdqn();
      ((bdnv)localObject2).b(1);
      ((bdnv)localObject2).a(new bdpx(str1));
      ((bdnv)localObject2).a(new StructMsgItemTitle(paramString2));
      ((bdnv)localObject2).a(new bdsv(anvx.a(2131704314) + bjxa.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)));
      ((AbsShareMsg)localObject1).addItem(a(anvx.a(2131704306)));
      ((AbsShareMsg)localObject1).addItem((bdnu)localObject2);
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject1);
      m();
      return;
      paramString2 = (String)localObject1;
    }
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = true;
    paramString1 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramString1, paramString2, paramBoolean);
    this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", paramString1.getBytes());
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = paramString1;
    m();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    int i1 = ((antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
    localObject = ((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      ThreadManager.post(new ForwardShareCardOption.1(this, i1, paramString, (String)localObject, paramBoolean), 8, null, false);
      return;
    }
    z();
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, -1, anvx.a(2131704310), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299080));
  }
  
  private View b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
    {
      new RelativeLayout.LayoutParams(-1, -2).setMargins(AIOUtils.dp2px(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.dp2px(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "updateImageView addStructView");
      }
      return this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null);
    }
    return new View(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  private void b(String paramString1, String paramString2)
  {
    Object localObject2 = new bdnr(StructMsgForGeneralShare.class);
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    String str2 = "AppCmd://OpenContactInfo/?uin=" + paramString1;
    Object localObject1 = ContactUtils.getFriendNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      localObject1 = ((bdnr)localObject2).c(14).a(2).a(1).a(anvx.a(2131704300) + paramString2).a("plugin", "", str2, str1, str1).d(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717984)).a();
      localObject2 = new bdqn();
      ((bdnv)localObject2).b(1);
      ((bdnv)localObject2).a(new bdpx(str1));
      ((bdnv)localObject2).a(new StructMsgItemTitle(paramString2));
      ((bdnv)localObject2).a(new bdsv(anvx.a(2131704266) + paramString1));
      ((AbsShareMsg)localObject1).addItem(a(anvx.a(2131704276)));
      ((AbsShareMsg)localObject1).addItem((bdnu)localObject2);
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject1);
      m();
      return;
      paramString2 = (String)localObject1;
    }
  }
  
  private void c(String paramString1, String paramString2)
  {
    AbsShareMsg localAbsShareMsg = new bdnr(StructMsgForGeneralShare.class).c(15).a(anvx.a(2131704292) + this.jdField_l_of_type_JavaLangString).e(this.jdField_j_of_type_JavaLangString).a();
    Object localObject = (antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if (localObject != null)
    {
      localObject = ((antp)localObject).a(paramString1);
      if (localObject == null) {}
    }
    for (paramString1 = ContactUtils.getDiscussionMemberShowName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, ((DiscussionInfo)localObject).ownerUin);; paramString1 = null)
    {
      localObject = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        localObject = anvx.a(2131704288);
      }
      paramString1 = bdoe.a(2);
      paramString1.a(paramString2, this.jdField_l_of_type_JavaLangString, anvx.a(2131704311) + (String)localObject, 1);
      localAbsShareMsg.addItem(a(anvx.a(2131704272)));
      localAbsShareMsg.addItem(paramString1);
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", localAbsShareMsg.getBytes());
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = localAbsShareMsg;
      return;
    }
  }
  
  private void e()
  {
    String str1 = this.jdField_l_of_type_JavaLangString;
    if (TextUtils.isEmpty(str1)) {
      str1 = this.k;
    }
    for (;;)
    {
      String str2 = bghb.a("", this.k, 0) + "100";
      AbsShareMsg localAbsShareMsg = new bdnr(StructMsgForGeneralShare.class).c(15).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131717991) + str1).e(this.jdField_h_of_type_JavaLangString).a();
      bdnv localbdnv = bdoe.a(2);
      Object localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131718799);
      Object localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if ((localObject2 != null) && (this.k != null))
      {
        localObject2 = ((TroopManager)localObject2).b(this.k);
        if (localObject2 != null)
        {
          if (TextUtils.isEmpty(((TroopInfo)localObject2).mRichFingerMemo)) {
            break label399;
          }
          localObject2 = ((TroopInfo)localObject2).mRichFingerMemo;
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.e("ForwardOption.ForwardShareCardOption", 2, "summary=" + (String)localObject2);
            localObject1 = localObject2;
          }
        }
      }
      label399:
      for (;;)
      {
        localbdnv.a(str2, str1, (String)localObject1, 1);
        localAbsShareMsg.addItem(a(anvx.a(2131704274)));
        localAbsShareMsg.addItem(localbdnv);
        this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", localAbsShareMsg.getBytes());
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = localAbsShareMsg;
        if (QLog.isColorLevel()) {
          QLog.i("ForwardOption.ForwardShareCardOption", 2, "createTroopCardMsg.mMsgServiceID:" + localAbsShareMsg.mMsgServiceID + " mMsgBrief:" + localAbsShareMsg.mMsgBrief + " mContentTitle:" + localAbsShareMsg.mContentTitle + " mContentSummary:" + localAbsShareMsg.mContentSummary + " mMsgUrl:" + localAbsShareMsg.mMsgUrl + " coverUrl:" + str2 + " mSourceName:" + localAbsShareMsg.mSourceName);
        }
        m();
        return;
        if (QLog.isColorLevel()) {
          QLog.e("ForwardOption.ForwardShareCardOption", 2, "can't find troop info! summary use default");
        }
      }
    }
  }
  
  public View a()
  {
    View localView1 = null;
    switch (this.jdField_h_of_type_Int)
    {
    default: 
      localView1 = b();
    }
    for (;;)
    {
      View localView2 = localView1;
      if (localView1 == null) {
        localView2 = new View(this.jdField_a_of_type_AndroidAppActivity);
      }
      return localView2;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null)
      {
        localView1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null);
        continue;
        localView1 = a(String.format("[%s]%s", new Object[] { anvx.a(2131704290), this.q }), FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.p));
        continue;
        localView1 = a(String.format("[%s]%s", new Object[] { anvx.a(2131704315), this.q }), FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 11, this.p));
        continue;
        localView1 = a(String.format("[%s]%s", new Object[] { anvx.a(2131704285), this.q }), FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, this.p));
        continue;
        localView1 = a(String.format("[%s]%s", new Object[] { anvx.a(2131704299), this.q }), FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 101, this.p));
        continue;
        localView1 = b();
      }
    }
  }
  
  public void a()
  {
    if (q()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (o()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (p()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    int i1 = ((awyz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).d();
    if ((i1 >= 9) || ((this.g == 23) && ((i1 == 1) || (i1 == 2) || (i1 == 6) || (i1 == 7) || (i1 == 3)))) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_h_of_type_JavaLangInteger);
    }
    this.jdField_a_of_type_JavaUtilSet.add(jdField_l_of_type_JavaLangInteger);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShareCardOption", 2, "build forward ability in state=" + i1 + ", type=" + this.g);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (!g()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = null;
    this.jdField_h_of_type_Int = paramBundle.getInt("uintype");
    this.p = paramBundle.getString("uin");
    this.q = paramBundle.getString("uinname");
    paramBundle.getString("troop_uin");
    CardOCRInfo localCardOCRInfo = (CardOCRInfo)paramBundle.getParcelable("business_card_ocr");
    boolean bool = paramBundle.getBoolean("bindContact", true);
    this.jdField_a_of_type_AndroidOsBundle.putString("uin", this.m);
    this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", this.f);
    this.jdField_a_of_type_AndroidOsBundle.putString("troop_uin", this.o);
    this.jdField_a_of_type_AndroidOsBundle.putString("uinname", this.n);
    switch (this.jdField_h_of_type_Int)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", paramInt);
      return;
      this.k = null;
      this.jdField_l_of_type_JavaLangString = null;
      a(localCardOCRInfo);
      continue;
      this.k = null;
      this.jdField_l_of_type_JavaLangString = null;
      b(this.p, this.q);
      continue;
      this.k = null;
      this.jdField_l_of_type_JavaLangString = null;
      a(this.p, this.q, bool);
      continue;
      this.k = this.p;
      this.jdField_l_of_type_JavaLangString = this.q;
      this.e = 0;
      I();
      continue;
      this.k = this.p;
      this.jdField_l_of_type_JavaLangString = this.q;
      this.jdField_j_of_type_Boolean = true;
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692125), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299080));
        return;
      }
      this.jdField_a_of_type_Antl.a(Long.parseLong(this.p), true);
      a(2131694477);
      continue;
      this.k = null;
      this.jdField_l_of_type_JavaLangString = null;
      a(this.p, this.q);
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_Antq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bjyh);
    this.jdField_a_of_type_Antl = ((antl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER));
    this.m = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("curent_aio_uin");
    this.n = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("curent_aio_uinname");
    this.f = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("curent_aio_uin_type", 0);
    this.o = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("curent_aio_troop_uin");
    this.g = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("forward_type", -1);
    return true;
  }
  
  public boolean a(QQCustomDialog paramQQCustomDialog)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
      paramQQCustomDialog.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null));
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.setMargins(AIOUtils.dp2px(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.dp2px(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardShareCardOption", 2, "updateImageView addStructView");
        }
        paramQQCustomDialog.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), localLayoutParams);
      }
    }
  }
  
  public String b()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getString(2131718637);
  }
  
  public String c()
  {
    String str = null;
    if (!TextUtils.isEmpty(this.n)) {
      str = this.n;
    }
    return str;
  }
  
  public void d()
  {
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B4", "0X80056B4", 0, 0, "", "", "", "");
    super.d();
    if (this.jdField_i_of_type_Boolean) {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007013", "0X8007013", 0, 0, "", "", "", "");
    }
  }
  
  public boolean l()
  {
    return true;
  }
  
  public void s()
  {
    super.s();
    if (this.jdField_i_of_type_Boolean) {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007012", "0X8007012", 0, 0, "", "", "", "");
    }
  }
  
  public void y()
  {
    if (this.jdField_a_of_type_Aofu != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
    }
    if (this.jdField_b_of_type_Antq != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_Antq);
    }
    if (this.jdField_a_of_type_Bjyh != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bjyh);
    }
    super.y();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareCardOption
 * JD-Core Version:    0.7.0.1
 */