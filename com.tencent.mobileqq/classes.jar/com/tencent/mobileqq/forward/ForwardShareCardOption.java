package com.tencent.mobileqq.forward;

import adcg;
import adci;
import adcj;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.PhoneContactManager;
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
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
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
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new adci(this);
  AbsShareMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
  AbsStructMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  private int jdField_b_of_type_Int = -1;
  private DiscussionObserver jdField_b_of_type_ComTencentMobileqqAppDiscussionObserver = new adcj(this);
  private int c;
  private int d;
  private String f;
  private String jdField_g_of_type_JavaLangString;
  boolean jdField_g_of_type_Boolean;
  private String jdField_h_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  
  public ForwardShareCardOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public static final AbsShareMsg a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
    if (paramString2 == null)
    {
      paramQQAppInterface = "";
      Object localObject2 = new StringBuilder().append("mqqapi://card/show_pslcard?src_type=internal_phone&source=sharecard&nickname=").append(URLEncoder.encode(paramQQAppInterface));
      if (!paramBoolean) {
        break label286;
      }
      paramString2 = "";
      label47:
      localObject2 = paramString2 + "&version=1&uin=" + paramString1 + "";
      paramString2 = ((AbsShareMsg.Builder)localObject1).b(84).a(2).a("推荐了联系人" + paramQQAppInterface).a("plugin", "", "AppCmd://OpenContactInfo/?uin=", (String)localObject2, (String)localObject2).b(paramActivity.getResources().getString(2131433752)).a();
      localObject1 = new StructMsgItemLayout2();
      ((AbsStructMsgItem)localObject1).b(1);
      ((AbsStructMsgItem)localObject1).a(new StructMsgItemCover((String)localObject2));
      ((AbsStructMsgItem)localObject1).a(new StructMsgItemTitle(paramQQAppInterface));
      if (!paramString1.startsWith("+86")) {
        break label321;
      }
    }
    label286:
    label321:
    for (paramQQAppInterface = paramString1.substring("+86".length(), paramString1.length());; paramQQAppInterface = paramString1)
    {
      if (paramBoolean) {}
      for (paramActivity = "手机: ";; paramActivity = "电话: ")
      {
        paramQQAppInterface = new StructMsgItemSummary(paramActivity + paramQQAppInterface);
        paramQQAppInterface.d(paramActivity + paramString1);
        ((AbsStructMsgItem)localObject1).a(paramQQAppInterface);
        paramString2.addItem(a("推荐通讯录联系人"));
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
      localObject2 = ((AbsShareMsg.Builder)localObject2).b(73).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131437101, new Object[] { paramCardOCRInfo.a })).a(2).a("shareBusinessCard", "", (String)localObject3, (String)localObject3, (String)localObject3).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131437102)).a();
      localObject3 = new StructMsgItemLayoutDefault();
      ((AbsStructMsgItem)localObject3).b(1);
      ((AbsStructMsgItem)localObject3).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131437100));
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
      j();
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
      localObject1 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(paramString1);
    } while (localObject1 == null);
    Object localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
    String str2 = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1 + "&cspecialflag=" + ((Friends)localObject1).cSpecialFlag;
    String str3 = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + paramString1 + "&version=1&cspecialflag=" + ((Friends)localObject1).cSpecialFlag;
    String str4 = "http://share.mp.qq.com/cgi/share.php?uin=" + paramString1 + "&account_flag=" + -7 + "&jumptype=1&card_type=crm&cspecialflag=" + ((Friends)localObject1).cSpecialFlag;
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    Object localObject1 = QidianManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      localObject1 = ((AbsShareMsg.Builder)localObject2).b(14).a(2).a("推荐了" + paramString2).a("plugin", str4, "", str2, str3).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131433751)).a();
      localObject2 = new StructMsgItemLayout2();
      ((AbsStructMsgItem)localObject2).b(1);
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemCover(str1));
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemTitle(paramString2));
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemSummary("帐号: " + QidianManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)));
      ((AbsShareMsg)localObject1).addItem(a("推荐好友"));
      ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject2);
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject1);
      j();
      return;
      paramString2 = (String)localObject1;
    }
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = true;
    paramString1 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramString1, paramString2, paramBoolean);
    this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", paramString1.getBytes());
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = paramString1;
    j();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    int n = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(paramString);
    localObject = ((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      ThreadManager.post(new adcg(this, n, paramString, (String)localObject, paramBoolean), 8, null, false);
      return;
    }
    t();
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, -1, "拉取多人聊天链接失败，请重试！", 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131558448));
  }
  
  private void b(String paramString1, String paramString2)
  {
    Object localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    String str2 = "AppCmd://OpenContactInfo/?uin=" + paramString1;
    Object localObject1 = ContactUtils.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      localObject1 = ((AbsShareMsg.Builder)localObject2).b(14).a(2).a("推荐了" + paramString2).a("plugin", "", str2, str1, str1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131433751)).a();
      localObject2 = new StructMsgItemLayout2();
      ((AbsStructMsgItem)localObject2).b(1);
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemCover(str1));
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemTitle(paramString2));
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemSummary("帐号: " + paramString1));
      ((AbsShareMsg)localObject1).addItem(a("推荐好友"));
      ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject2);
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject1);
      j();
      return;
      paramString2 = (String)localObject1;
    }
  }
  
  private void c(String paramString1, String paramString2)
  {
    AbsShareMsg localAbsShareMsg = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(15).a("推荐多人聊天：" + this.j).c(this.jdField_h_of_type_JavaLangString).a();
    Object localObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localObject != null)
    {
      localObject = ((DiscussionManager)localObject).a(paramString1);
      if (localObject == null) {}
    }
    for (paramString1 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, ((DiscussionInfo)localObject).ownerUin);; paramString1 = null)
    {
      localObject = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        localObject = "创建者信息获取失败";
      }
      paramString1 = StructMsgElementFactory.a(2);
      paramString1.a(paramString2, this.j, "创建人：" + (String)localObject, 1);
      localAbsShareMsg.addItem(a("推荐多人聊天"));
      localAbsShareMsg.addItem(paramString1);
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", localAbsShareMsg.getBytes());
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = localAbsShareMsg;
      return;
    }
  }
  
  private void w()
  {
    String str1 = this.j;
    if (TextUtils.isEmpty(str1)) {
      str1 = this.i;
    }
    for (;;)
    {
      String str2 = AvatarTroopUtil.a("", this.i, 0) + "100";
      AbsShareMsg localAbsShareMsg = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(15).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131435304) + str1).c(this.f).a();
      AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2);
      Object localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131435308);
      Object localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localObject2 != null) && (this.i != null))
      {
        localObject2 = ((TroopManager)localObject2).a(this.i);
        if (localObject2 != null)
        {
          if (TextUtils.isEmpty(((TroopInfo)localObject2).mRichFingerMemo)) {
            break label398;
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
      label398:
      for (;;)
      {
        localAbsStructMsgItem.a(str2, str1, (String)localObject1, 1);
        localAbsShareMsg.addItem(a("推荐群"));
        localAbsShareMsg.addItem(localAbsStructMsgItem);
        this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", localAbsShareMsg.getBytes());
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = localAbsShareMsg;
        if (QLog.isColorLevel()) {
          QLog.i("ForwardOption.ForwardShareCardOption", 2, "createTroopCardMsg.mMsgServiceID:" + localAbsShareMsg.mMsgServiceID + " mMsgBrief:" + localAbsShareMsg.mMsgBrief + " mContentTitle:" + localAbsShareMsg.mContentTitle + " mContentSummary:" + localAbsShareMsg.mContentSummary + " mMsgUrl:" + localAbsShareMsg.mMsgUrl + " coverUrl:" + str2 + " mSourceName:" + localAbsShareMsg.mSourceName);
        }
        j();
        return;
        if (QLog.isColorLevel()) {
          QLog.e("ForwardOption.ForwardShareCardOption", 2, "can't find troop info! summary use default");
        }
      }
    }
  }
  
  private void x()
  {
    boolean bool = false;
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131432992), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131558448));
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardShareCardOption", 2, "tryToGetShareLink: net is not supported");
      }
      this.jdField_b_of_type_Int = -1;
    }
    a(2131435053);
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    String str = this.i;
    if (this.jdField_b_of_type_Int == 0) {
      bool = true;
    }
    localTroopHandler.a(str, bool);
  }
  
  protected void a()
  {
    if (j()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (h()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_d_of_type_JavaLangInteger);
    }
    if (i()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_c_of_type_JavaLangInteger);
    }
    int n = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).c();
    if ((n >= 9) || ((this.jdField_d_of_type_Int == 23) && ((n == 1) || (n == 2) || (n == 6) || (n == 7) || (n == 3)))) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_h_of_type_JavaLangInteger);
    }
    this.jdField_a_of_type_JavaUtilSet.add(jdField_l_of_type_JavaLangInteger);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShareCardOption", 2, "build forward ability in state=" + n + ", type=" + this.jdField_d_of_type_Int);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (!e()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = null;
    int n = paramBundle.getInt("uintype");
    String str1 = paramBundle.getString("uin");
    String str2 = paramBundle.getString("uinname");
    paramBundle.getString("troop_uin");
    CardOCRInfo localCardOCRInfo = (CardOCRInfo)paramBundle.getParcelable("business_card_ocr");
    boolean bool = paramBundle.getBoolean("bindContact", true);
    this.jdField_a_of_type_AndroidOsBundle.putString("uin", this.k);
    this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidOsBundle.putString("troop_uin", this.m);
    this.jdField_a_of_type_AndroidOsBundle.putString("uinname", this.jdField_l_of_type_JavaLangString);
    switch (n)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", paramInt);
      return;
      this.i = null;
      this.j = null;
      a(localCardOCRInfo);
      continue;
      this.i = null;
      this.j = null;
      b(str1, str2);
      continue;
      this.i = null;
      this.j = null;
      a(str1, str2, bool);
      continue;
      this.i = str1;
      this.j = str2;
      this.jdField_b_of_type_Int = 0;
      x();
      continue;
      this.i = str1;
      this.j = str2;
      this.jdField_h_of_type_Boolean = true;
      if (!NetworkUtil.d(BaseApplication.getContext()))
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131432992), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131558448));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.parseLong(str1), true);
      a(2131435053);
      continue;
      this.i = null;
      this.j = null;
      a(str1, str2);
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_ComTencentMobileqqAppDiscussionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6));
    this.k = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("curent_aio_uin");
    this.jdField_l_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("curent_aio_uinname");
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("curent_aio_uin_type", 0);
    this.m = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("curent_aio_troop_uin");
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("forward_type", -1);
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
    return this.jdField_a_of_type_AndroidAppActivity.getString(2131434955);
  }
  
  public String c()
  {
    String str = null;
    if (!TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) {
      str = "发送到 " + this.jdField_l_of_type_JavaLangString;
    }
    return str;
  }
  
  protected void m()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B4", "0X80056B4", 0, 0, "", "", "", "");
    super.m();
    if (this.jdField_g_of_type_Boolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007013", "0X8007013", 0, 0, "", "", "", "");
    }
  }
  
  protected void n()
  {
    super.n();
    if (this.jdField_g_of_type_Boolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007012", "0X8007012", 0, 0, "", "", "", "");
    }
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqAppDiscussionObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppDiscussionObserver);
    }
    super.s();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareCardOption
 * JD-Core Version:    0.7.0.1
 */