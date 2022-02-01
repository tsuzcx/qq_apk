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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.List;
import java.util.Set;
import mqq.manager.TicketManager;

public class ForwardShareCardOption
  extends ForwardBaseOption
{
  DiscussionHandler jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler;
  private TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new ForwardShareCardOption.2(this);
  AbsShareMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
  AbsStructMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  private QidianBusinessObserver jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new ForwardShareCardOption.3(this);
  private DiscussionObserver b;
  private int e = -1;
  private int f;
  private int g;
  private int jdField_h_of_type_Int;
  private String jdField_h_of_type_JavaLangString;
  private String i;
  private String jdField_j_of_type_JavaLangString;
  boolean jdField_j_of_type_Boolean;
  private String jdField_k_of_type_JavaLangString;
  private boolean jdField_k_of_type_Boolean = false;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  
  public ForwardShareCardOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_b_of_type_ComTencentMobileqqAppDiscussionObserver = new ForwardShareCardOption.4(this);
  }
  
  private void I()
  {
    boolean bool = false;
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692257), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299166));
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardShareCardOption", 2, "tryToGetShareLink: net is not supported");
      }
      this.e = -1;
    }
    a(2131694694);
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (((TroopManager)localObject).n(this.jdField_k_of_type_JavaLangString))
    {
      localObject = ((TroopManager)localObject).c(this.jdField_k_of_type_JavaLangString);
      ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).b(this.jdField_k_of_type_JavaLangString, ((TroopInfo)localObject).troopowneruin);
      return;
    }
    localObject = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    String str = this.jdField_k_of_type_JavaLangString;
    if (this.e == 0) {
      bool = true;
    }
    ((TroopHandler)localObject).a(str, bool);
  }
  
  private View a(String paramString, Drawable paramDrawable)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131559083, null);
    TextView localTextView = (TextView)localView.findViewById(2131380812);
    ImageView localImageView = (ImageView)localView.findViewById(2131368996);
    localTextView.setText(paramString);
    localImageView.setImageDrawable(paramDrawable);
    return localView;
  }
  
  public static final AbsShareMsg a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
    if (paramString2 == null)
    {
      paramQQAppInterface = "";
      Object localObject2 = new StringBuilder().append("mqqapi://card/show_pslcard?src_type=internal_phone&source=sharecard&nickname=").append(URLEncoder.encode(paramQQAppInterface));
      if (!paramBoolean) {
        break label299;
      }
      paramString2 = "";
      label47:
      localObject2 = paramString2 + "&version=1&uin=" + paramString1 + "";
      paramString2 = ((AbsShareMsg.Builder)localObject1).c(84).a(2).a(HardCodeUtil.a(2131704830) + paramQQAppInterface).a("plugin", "", "AppCmd://OpenContactInfo/?uin=", (String)localObject2, (String)localObject2).d(paramActivity.getResources().getString(2131718480)).a();
      localObject1 = new StructMsgItemLayout2();
      ((AbsStructMsgItem)localObject1).b(1);
      ((AbsStructMsgItem)localObject1).a(new StructMsgItemCover((String)localObject2));
      ((AbsStructMsgItem)localObject1).a(new StructMsgItemTitle(paramQQAppInterface));
      if (!paramString1.startsWith("+86")) {
        break label339;
      }
    }
    label299:
    label339:
    for (paramQQAppInterface = paramString1.substring("+86".length(), paramString1.length());; paramQQAppInterface = paramString1)
    {
      if (paramBoolean) {}
      for (paramActivity = HardCodeUtil.a(2131704853);; paramActivity = HardCodeUtil.a(2131704835))
      {
        paramQQAppInterface = new StructMsgItemSummary(paramActivity + paramQQAppInterface);
        paramQQAppInterface.d(paramActivity + paramString1);
        ((AbsStructMsgItem)localObject1).a(paramQQAppInterface);
        paramString2.addItem(a(HardCodeUtil.a(2131704860)));
        paramString2.addItem((AbsStructMsgElement)localObject1);
        return paramString2;
        paramQQAppInterface = paramString2.trim();
        break;
        paramString2 = "&headtext=" + URLEncoder.encode(ContactUtils.a(paramQQAppInterface));
        break label47;
      }
    }
  }
  
  private static AbsStructMsgItem a(String paramString)
  {
    StructMsgItemLayoutDefault localStructMsgItemLayoutDefault = new StructMsgItemLayoutDefault();
    localStructMsgItemLayoutDefault.b(1);
    localStructMsgItemLayoutDefault.a(paramString);
    return localStructMsgItemLayoutDefault;
  }
  
  private void a(CardOCRInfo paramCardOCRInfo)
  {
    if (paramCardOCRInfo == null) {
      return;
    }
    Object localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
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
      localObject2 = ((AbsShareMsg.Builder)localObject2).c(73).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131698595, new Object[] { paramCardOCRInfo.a })).a(2).a("shareBusinessCard", "", (String)localObject3, (String)localObject3, (String)localObject3).d(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719160)).a();
      localObject3 = new StructMsgItemLayoutDefault();
      ((AbsStructMsgItem)localObject3).b(1);
      ((AbsStructMsgItem)localObject3).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131698593));
      StructMsgItemLayout2 localStructMsgItemLayout2 = new StructMsgItemLayout2();
      localStructMsgItemLayout2.b(3);
      localStructMsgItemLayout2.a(new StructMsgItemCover(paramCardOCRInfo.jdField_b_of_type_JavaLangString + "/?02"));
      localStructMsgItemLayout2.a(new StructMsgItemTitle(paramCardOCRInfo.a));
      localStructMsgItemLayout2.a(new StructMsgItemSummary((String)localObject1));
      ((AbsShareMsg)localObject2).addItem((AbsStructMsgElement)localObject3);
      ((AbsShareMsg)localObject2).addItem(localStructMsgItemLayout2);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("req_type", 5);
      ((Bundle)localObject1).putString("image_url", paramCardOCRInfo.jdField_b_of_type_JavaLangString);
      BusinessCardUtils.a(paramCardOCRInfo.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = StructMsgFactory.a(((StructMsgForImageShare)StructMsgFactory.a((Bundle)localObject1)).getBytes());
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
      m();
      return;
      localObject1 = "";
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!QidianManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)) {}
    do
    {
      return;
      localObject1 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString1);
    } while (localObject1 == null);
    Object localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
    String str2 = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=" + paramString1 + "&cspecialflag=" + ((Friends)localObject1).cSpecialFlag;
    String str3 = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + paramString1 + "&version=1&cspecialflag=" + ((Friends)localObject1).cSpecialFlag;
    String str4 = "https://share.mp.qq.com/cgi/share.php?uin=" + paramString1 + "&account_flag=" + -7 + "&jumptype=1&card_type=crm&cspecialflag=" + ((Friends)localObject1).cSpecialFlag;
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    Object localObject1 = QidianManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      localObject1 = ((AbsShareMsg.Builder)localObject2).c(14).a(2).a(1).a(HardCodeUtil.a(2131704850) + paramString2).a("plugin", str4, "", str2, str3).d(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718475)).a();
      localObject2 = new StructMsgItemLayout2();
      ((AbsStructMsgItem)localObject2).b(1);
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemCover(str1));
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemTitle(paramString2));
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemSummary(HardCodeUtil.a(2131704862) + QidianManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)));
      ((AbsShareMsg)localObject1).addItem(a(HardCodeUtil.a(2131704854)));
      ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject2);
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject1);
      m();
      return;
      paramString2 = (String)localObject1;
    }
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = true;
    paramString1 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramString1, paramString2, paramBoolean);
    this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", paramString1.getBytes());
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = paramString1;
    m();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    int i1 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
    localObject = ((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      ThreadManager.post(new ForwardShareCardOption.1(this, i1, paramString, (String)localObject, paramBoolean), 8, null, false);
      return;
    }
    z();
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, -1, HardCodeUtil.a(2131704858), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299166));
  }
  
  private View b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
    {
      new RelativeLayout.LayoutParams(-1, -2).setMargins(AIOUtils.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "updateImageView addStructView");
      }
      return this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null);
    }
    return new View(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  private void b(String paramString1, String paramString2)
  {
    Object localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    String str2 = "AppCmd://OpenContactInfo/?uin=" + paramString1;
    Object localObject1 = ContactUtils.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      localObject1 = ((AbsShareMsg.Builder)localObject2).c(14).a(2).a(1).a(HardCodeUtil.a(2131704848) + paramString2).a("plugin", "", str2, str1, str1).d(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718475)).a();
      localObject2 = new StructMsgItemLayout2();
      ((AbsStructMsgItem)localObject2).b(1);
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemCover(str1));
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemTitle(paramString2));
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemSummary(HardCodeUtil.a(2131704814) + paramString1));
      ((AbsShareMsg)localObject1).addItem(a(HardCodeUtil.a(2131704824)));
      ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject2);
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject1);
      m();
      return;
      paramString2 = (String)localObject1;
    }
  }
  
  private void c(String paramString1, String paramString2)
  {
    AbsShareMsg localAbsShareMsg = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(15).a(HardCodeUtil.a(2131704840) + this.jdField_l_of_type_JavaLangString).e(this.jdField_j_of_type_JavaLangString).a();
    Object localObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if (localObject != null)
    {
      localObject = ((DiscussionManager)localObject).a(paramString1);
      if (localObject == null) {}
    }
    for (paramString1 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, ((DiscussionInfo)localObject).ownerUin);; paramString1 = null)
    {
      localObject = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        localObject = HardCodeUtil.a(2131704836);
      }
      paramString1 = StructMsgElementFactory.a(2);
      paramString1.a(paramString2, this.jdField_l_of_type_JavaLangString, HardCodeUtil.a(2131704859) + (String)localObject, 1);
      localAbsShareMsg.addItem(a(HardCodeUtil.a(2131704820)));
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
      str1 = this.jdField_k_of_type_JavaLangString;
    }
    for (;;)
    {
      Object localObject1 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
      String str2 = ((ITroopAvatarUtilApi)localObject1).getAvatarAddress("", this.jdField_k_of_type_JavaLangString, 0) + "100";
      AbsShareMsg localAbsShareMsg = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(15).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131718482) + str1).e(this.jdField_h_of_type_JavaLangString).a();
      AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2);
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131719324);
      Object localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if ((localObject2 != null) && (this.jdField_k_of_type_JavaLangString != null))
      {
        localObject2 = ((TroopManager)localObject2).b(this.jdField_k_of_type_JavaLangString);
        if (localObject2 != null)
        {
          if (TextUtils.isEmpty(((TroopInfo)localObject2).mRichFingerMemo)) {
            break label412;
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
      label412:
      for (;;)
      {
        localAbsStructMsgItem.a(str2, str1, (String)localObject1, 1);
        localAbsShareMsg.addItem(a(HardCodeUtil.a(2131704822)));
        localAbsShareMsg.addItem(localAbsStructMsgItem);
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
  
  protected View a()
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
        localView1 = a(String.format("[%s]%s", new Object[] { HardCodeUtil.a(2131704838), this.q }), FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.p));
        continue;
        localView1 = a(String.format("[%s]%s", new Object[] { HardCodeUtil.a(2131704863), this.q }), FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 11, this.p));
        continue;
        localView1 = a(String.format("[%s]%s", new Object[] { HardCodeUtil.a(2131704833), this.q }), FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, this.p));
        continue;
        localView1 = a(String.format("[%s]%s", new Object[] { HardCodeUtil.a(2131704847), this.q }), FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 101, this.p));
        continue;
        localView1 = b();
      }
    }
  }
  
  protected void a()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B4", "0X80056B4", 0, 0, "", "", "", "");
    super.a();
    if (this.jdField_j_of_type_Boolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007013", "0X8007013", 0, 0, "", "", "", "");
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (!h()) {
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
      this.jdField_k_of_type_JavaLangString = null;
      this.jdField_l_of_type_JavaLangString = null;
      a(localCardOCRInfo);
      continue;
      this.jdField_k_of_type_JavaLangString = null;
      this.jdField_l_of_type_JavaLangString = null;
      b(this.p, this.q);
      continue;
      this.jdField_k_of_type_JavaLangString = null;
      this.jdField_l_of_type_JavaLangString = null;
      a(this.p, this.q, bool);
      continue;
      this.jdField_k_of_type_JavaLangString = this.p;
      this.jdField_l_of_type_JavaLangString = this.q;
      this.e = 0;
      I();
      continue;
      this.jdField_k_of_type_JavaLangString = this.p;
      this.jdField_l_of_type_JavaLangString = this.q;
      this.jdField_k_of_type_Boolean = true;
      if (!NetworkUtil.d(BaseApplication.getContext()))
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692257), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299166));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.parseLong(this.p), true);
      a(2131694694);
      continue;
      this.jdField_k_of_type_JavaLangString = null;
      this.jdField_l_of_type_JavaLangString = null;
      a(this.p, this.q);
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_ComTencentMobileqqAppDiscussionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER));
    this.m = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("curent_aio_uin");
    this.n = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("curent_aio_uinname");
    this.f = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("curent_aio_uin_type", 0);
    this.o = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("curent_aio_troop_uin");
    this.g = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("forward_type", -1);
    return true;
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
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
        localLayoutParams.setMargins(AIOUtils.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardShareCardOption", 2, "updateImageView addStructView");
        }
        paramQQCustomDialog.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), localLayoutParams);
      }
    }
  }
  
  public String b()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getString(2131719161);
  }
  
  protected void b()
  {
    if (r()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (p()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (q()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    int i1 = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).d();
    if ((i1 >= 9) || ((this.g == 23) && ((i1 == 1) || (i1 == 2) || (i1 == 6) || (i1 == 7) || (i1 == 3)))) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_h_of_type_JavaLangInteger);
    }
    this.jdField_a_of_type_JavaUtilSet.add(jdField_l_of_type_JavaLangInteger);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShareCardOption", 2, "build forward ability in state=" + i1 + ", type=" + this.g);
    }
  }
  
  public String c()
  {
    String str = null;
    if (!TextUtils.isEmpty(this.n)) {
      str = this.n;
    }
    return str;
  }
  
  protected boolean m()
  {
    return true;
  }
  
  protected void s()
  {
    super.s();
    if (this.jdField_j_of_type_Boolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007012", "0X8007012", 0, 0, "", "", "", "");
    }
  }
  
  public void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqAppDiscussionObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppDiscussionObserver);
    }
    if (this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    }
    super.y();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareCardOption
 * JD-Core Version:    0.7.0.1
 */