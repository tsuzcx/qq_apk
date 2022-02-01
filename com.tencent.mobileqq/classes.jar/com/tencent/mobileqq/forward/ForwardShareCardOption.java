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
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
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
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerBizHandler;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
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
  AbsShareMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
  AbsStructMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  private TroopManagerBizObserver jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver = new ForwardShareCardOption.2(this);
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
    this.jdField_b_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver = new ForwardShareCardOption.4(this);
  }
  
  private void I()
  {
    boolean bool2 = NetworkUtil.isNetSupport(BaseApplication.getContext());
    boolean bool1 = false;
    if (!bool2)
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692183), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299168));
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardShareCardOption", 2, "tryToGetShareLink: net is not supported");
      }
      this.e = -1;
    }
    a(2131694668);
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (((TroopManager)localObject).m(this.jdField_k_of_type_JavaLangString))
    {
      localObject = ((TroopManager)localObject).c(this.jdField_k_of_type_JavaLangString);
      ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).b(this.jdField_k_of_type_JavaLangString, ((TroopInfo)localObject).troopowneruin);
      return;
    }
    localObject = (ITroopManagerBizHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MANAGER_BIZ_HANDLER);
    String str = this.jdField_k_of_type_JavaLangString;
    if (this.e == 0) {
      bool1 = true;
    }
    ((ITroopManagerBizHandler)localObject).d(str, bool1);
  }
  
  private View a(String paramString, Drawable paramDrawable)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558977, null);
    TextView localTextView = (TextView)localView.findViewById(2131380075);
    ImageView localImageView = (ImageView)localView.findViewById(2131368718);
    localTextView.setText(paramString);
    localImageView.setImageDrawable(paramDrawable);
    return localView;
  }
  
  public static final AbsShareMsg a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
    if (paramString2 == null) {
      paramQQAppInterface = "";
    } else {
      paramQQAppInterface = paramString2.trim();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("mqqapi://card/show_pslcard?src_type=internal_phone&source=sharecard&nickname=");
    ((StringBuilder)localObject2).append(URLEncoder.encode(paramQQAppInterface));
    if (paramBoolean)
    {
      paramString2 = "";
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append("&headtext=");
      paramString2.append(URLEncoder.encode(ContactUtils.a(paramQQAppInterface)));
      paramString2 = paramString2.toString();
    }
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append("&version=1&uin=");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    paramString2 = ((AbsShareMsg.Builder)localObject1).c(84).a(2);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131704906));
    ((StringBuilder)localObject1).append(paramQQAppInterface);
    paramActivity = paramString2.a(((StringBuilder)localObject1).toString()).a("plugin", "", "AppCmd://OpenContactInfo/?uin=", (String)localObject2, (String)localObject2).d(paramActivity.getResources().getString(2131718145)).a();
    paramString2 = new StructMsgItemLayout2();
    paramString2.b(1);
    paramString2.a(new StructMsgItemCover((String)localObject2));
    paramString2.a(new StructMsgItemTitle(paramQQAppInterface));
    if (paramString1.startsWith("+86")) {
      paramQQAppInterface = paramString1.substring(3, paramString1.length());
    } else {
      paramQQAppInterface = paramString1;
    }
    int i1;
    if (paramBoolean) {
      i1 = 2131704929;
    } else {
      i1 = 2131704911;
    }
    localObject1 = HardCodeUtil.a(i1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(paramQQAppInterface);
    paramQQAppInterface = new StructMsgItemSummary(((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(paramString1);
    paramQQAppInterface.d(((StringBuilder)localObject2).toString());
    paramString2.a(paramQQAppInterface);
    paramActivity.addItem(a(HardCodeUtil.a(2131704936)));
    paramActivity.addItem(paramString2);
    return paramActivity;
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
    if ((paramCardOCRInfo.jdField_b_of_type_JavaUtilList != null) && (paramCardOCRInfo.jdField_b_of_type_JavaUtilList.size() > 0))
    {
      localObject1 = (String)paramCardOCRInfo.jdField_b_of_type_JavaUtilList.get(0);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    else
    {
      localObject1 = "";
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("url=");
    ((StringBuilder)localObject3).append(paramCardOCRInfo.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject3).append(";name=");
    ((StringBuilder)localObject3).append(paramCardOCRInfo.a);
    ((StringBuilder)localObject3).append(";phone=");
    ((StringBuilder)localObject3).append((String)localObject1);
    localObject3 = ((StringBuilder)localObject3).toString();
    localObject2 = ((AbsShareMsg.Builder)localObject2).c(73).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131698661, new Object[] { paramCardOCRInfo.a })).a(2).a("shareBusinessCard", "", (String)localObject3, (String)localObject3, (String)localObject3).d(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718878)).a();
    localObject3 = new StructMsgItemLayoutDefault();
    ((AbsStructMsgItem)localObject3).b(1);
    ((AbsStructMsgItem)localObject3).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131698659));
    StructMsgItemLayout2 localStructMsgItemLayout2 = new StructMsgItemLayout2();
    localStructMsgItemLayout2.b(3);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramCardOCRInfo.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("/?02");
    localStructMsgItemLayout2.a(new StructMsgItemCover(localStringBuilder.toString()));
    localStructMsgItemLayout2.a(new StructMsgItemTitle(paramCardOCRInfo.a));
    localStructMsgItemLayout2.a(new StructMsgItemSummary((String)localObject1));
    ((AbsShareMsg)localObject2).addItem((AbsStructMsgElement)localObject3);
    ((AbsShareMsg)localObject2).addItem(localStructMsgItemLayout2);
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("req_type", 5);
    ((Bundle)localObject1).putString("image_url", paramCardOCRInfo.jdField_b_of_type_JavaLangString);
    BusinessCardUtils.a(paramCardOCRInfo.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = StructMsgFactory.a(((StructMsgForImageShare)StructMsgFactory.a((Bundle)localObject1)).getBytes());
    this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
    n();
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!QidianManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)) {
      return;
    }
    Object localObject1 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString1);
    if (localObject1 != null)
    {
      Object localObject3 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("&cspecialflag=");
      ((StringBuilder)localObject2).append(((Friends)localObject1).cSpecialFlag);
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=");
      ((StringBuilder)localObject4).append(paramString1);
      ((StringBuilder)localObject4).append("&version=1&cspecialflag=");
      ((StringBuilder)localObject4).append(((Friends)localObject1).cSpecialFlag);
      localObject4 = ((StringBuilder)localObject4).toString();
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("https://share.mp.qq.com/cgi/share.php?uin=");
      ((StringBuilder)localObject5).append(paramString1);
      ((StringBuilder)localObject5).append("&account_flag=");
      ((StringBuilder)localObject5).append(-7);
      ((StringBuilder)localObject5).append("&jumptype=1&card_type=crm&cspecialflag=");
      ((StringBuilder)localObject5).append(((Friends)localObject1).cSpecialFlag);
      String str = ((StringBuilder)localObject5).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=");
      ((StringBuilder)localObject1).append(paramString1);
      localObject5 = ((StringBuilder)localObject1).toString();
      localObject1 = QidianManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramString2 = (String)localObject1;
      }
      localObject1 = ((AbsShareMsg.Builder)localObject3).c(14).a(2).a(1);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131704926));
      ((StringBuilder)localObject3).append(paramString2);
      localObject1 = ((AbsShareMsg.Builder)localObject1).a(((StringBuilder)localObject3).toString()).a("plugin", str, "", (String)localObject2, (String)localObject4).d(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718140)).a();
      localObject2 = new StructMsgItemLayout2();
      ((AbsStructMsgItem)localObject2).b(1);
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemCover((String)localObject5));
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemTitle(paramString2));
      paramString2 = new StringBuilder();
      paramString2.append(HardCodeUtil.a(2131704938));
      paramString2.append(QidianManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1));
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemSummary(paramString2.toString()));
      ((AbsShareMsg)localObject1).addItem(a(HardCodeUtil.a(2131704930)));
      ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject2);
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject1);
      n();
    }
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = true;
    paramString1 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramString1, paramString2, paramBoolean);
    this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", paramString1.getBytes());
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = paramString1;
    n();
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
    A();
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, -1, HardCodeUtil.a(2131704934), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299168));
  }
  
  private View b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
    {
      new RelativeLayout.LayoutParams(-1, -2).setMargins(AIOUtils.b(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.b(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=");
    ((StringBuilder)localObject1).append(paramString1);
    String str1 = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("AppCmd://OpenContactInfo/?uin=");
    ((StringBuilder)localObject1).append(paramString1);
    String str2 = ((StringBuilder)localObject1).toString();
    localObject1 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString2 = (String)localObject1;
    }
    localObject1 = ((AbsShareMsg.Builder)localObject2).c(14).a(2).a(1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131704924));
    ((StringBuilder)localObject2).append(paramString2);
    localObject1 = ((AbsShareMsg.Builder)localObject1).a(((StringBuilder)localObject2).toString()).a("plugin", "", str2, str1, str1).d(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718140)).a();
    localObject2 = new StructMsgItemLayout2();
    ((AbsStructMsgItem)localObject2).b(1);
    ((AbsStructMsgItem)localObject2).a(new StructMsgItemCover(str1));
    ((AbsStructMsgItem)localObject2).a(new StructMsgItemTitle(paramString2));
    paramString2 = new StringBuilder();
    paramString2.append(HardCodeUtil.a(2131704890));
    paramString2.append(paramString1);
    ((AbsStructMsgItem)localObject2).a(new StructMsgItemSummary(paramString2.toString()));
    ((AbsShareMsg)localObject1).addItem(a(HardCodeUtil.a(2131704900)));
    ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject2);
    this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject1);
    n();
  }
  
  private void c(String paramString1, String paramString2)
  {
    Object localObject1 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(15);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131704916));
    ((StringBuilder)localObject2).append(this.jdField_l_of_type_JavaLangString);
    localObject2 = ((AbsShareMsg.Builder)localObject1).a(((StringBuilder)localObject2).toString()).e(this.jdField_j_of_type_JavaLangString).a();
    localObject1 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if (localObject1 != null)
    {
      localObject1 = ((DiscussionManager)localObject1).a(paramString1);
      if (localObject1 != null)
      {
        paramString1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, ((DiscussionInfo)localObject1).ownerUin);
        break label113;
      }
    }
    paramString1 = null;
    label113:
    localObject1 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      localObject1 = HardCodeUtil.a(2131704912);
    }
    paramString1 = StructMsgElementFactory.a(2);
    String str = this.jdField_l_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131704935));
    localStringBuilder.append((String)localObject1);
    paramString1.a(paramString2, str, localStringBuilder.toString(), 1);
    ((AbsShareMsg)localObject2).addItem(a(HardCodeUtil.a(2131704896)));
    ((AbsShareMsg)localObject2).addItem(paramString1);
    this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject2);
  }
  
  private void e()
  {
    Object localObject2 = this.jdField_l_of_type_JavaLangString;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.jdField_k_of_type_JavaLangString;
    }
    localObject2 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((ITroopAvatarUtilApi)localObject2).getAvatarAddress("", this.jdField_k_of_type_JavaLangString, 0));
    ((StringBuilder)localObject3).append("100");
    String str1 = ((StringBuilder)localObject3).toString();
    localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(15);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_AndroidAppActivity.getString(2131718147));
    ((StringBuilder)localObject3).append((String)localObject1);
    AbsShareMsg localAbsShareMsg = ((AbsShareMsg.Builder)localObject2).a(((StringBuilder)localObject3).toString()).e(this.jdField_h_of_type_JavaLangString).a();
    AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2);
    localObject3 = this.jdField_a_of_type_AndroidAppActivity.getString(2131719042);
    Object localObject4 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    localObject2 = localObject3;
    if (localObject4 != null)
    {
      String str2 = this.jdField_k_of_type_JavaLangString;
      localObject2 = localObject3;
      if (str2 != null)
      {
        localObject4 = ((TroopManager)localObject4).b(str2);
        if (localObject4 != null)
        {
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(((TroopInfo)localObject4).mRichFingerMemo))
          {
            localObject3 = ((TroopInfo)localObject4).mRichFingerMemo;
            localObject2 = localObject3;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("summary=");
              ((StringBuilder)localObject2).append((String)localObject3);
              QLog.e("ForwardOption.ForwardShareCardOption", 2, ((StringBuilder)localObject2).toString());
              localObject2 = localObject3;
            }
          }
        }
        else
        {
          localObject2 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.e("ForwardOption.ForwardShareCardOption", 2, "can't find troop info! summary use default");
            localObject2 = localObject3;
          }
        }
      }
    }
    localAbsStructMsgItem.a(str1, (String)localObject1, (String)localObject2, 1);
    localAbsShareMsg.addItem(a(HardCodeUtil.a(2131704898)));
    localAbsShareMsg.addItem(localAbsStructMsgItem);
    this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", localAbsShareMsg.getBytes());
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = localAbsShareMsg;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("createTroopCardMsg.mMsgServiceID:");
      ((StringBuilder)localObject1).append(localAbsShareMsg.mMsgServiceID);
      ((StringBuilder)localObject1).append(" mMsgBrief:");
      ((StringBuilder)localObject1).append(localAbsShareMsg.mMsgBrief);
      ((StringBuilder)localObject1).append(" mContentTitle:");
      ((StringBuilder)localObject1).append(localAbsShareMsg.mContentTitle);
      ((StringBuilder)localObject1).append(" mContentSummary:");
      ((StringBuilder)localObject1).append(localAbsShareMsg.mContentSummary);
      ((StringBuilder)localObject1).append(" mMsgUrl:");
      ((StringBuilder)localObject1).append(localAbsShareMsg.mMsgUrl);
      ((StringBuilder)localObject1).append(" coverUrl:");
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append(" mSourceName:");
      ((StringBuilder)localObject1).append(localAbsShareMsg.mSourceName);
      QLog.i("ForwardOption.ForwardShareCardOption", 2, ((StringBuilder)localObject1).toString());
    }
    n();
  }
  
  protected View a()
  {
    int i1 = this.jdField_h_of_type_Int;
    View localView = null;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 30)
        {
          if (i1 != 1006) {
            if (i1 != 1024)
            {
              if (i1 != 3000)
              {
                if (i1 != 56938)
                {
                  localView = b();
                  break label271;
                }
              }
              else
              {
                localView = a(String.format("[%s]%s", new Object[] { HardCodeUtil.a(2131704923), this.q }), FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 101, this.p));
                break label271;
              }
            }
            else
            {
              localView = b();
              break label271;
            }
          }
          localView = a(String.format("[%s]%s", new Object[] { HardCodeUtil.a(2131704939), this.q }), FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 11, this.p));
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
          if (localObject != null) {
            localView = ((AbsStructMsg)localObject).getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null);
          }
        }
      }
      else {
        localView = a(String.format("[%s]%s", new Object[] { HardCodeUtil.a(2131704909), this.q }), FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, this.p));
      }
    }
    else {
      localView = a(String.format("[%s]%s", new Object[] { HardCodeUtil.a(2131704914), this.q }), FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.p));
    }
    label271:
    Object localObject = localView;
    if (localView == null) {
      localObject = new View(this.jdField_a_of_type_AndroidAppActivity);
    }
    return localObject;
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
    int i1 = this.jdField_h_of_type_Int;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 30)
        {
          if (i1 != 1006) {
            if (i1 != 1024)
            {
              if (i1 != 3000)
              {
                if (i1 != 56938) {
                  break label392;
                }
              }
              else
              {
                this.jdField_k_of_type_JavaLangString = this.p;
                this.jdField_l_of_type_JavaLangString = this.q;
                this.jdField_k_of_type_Boolean = true;
                if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
                {
                  QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692183), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299168));
                  return;
                }
                this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.parseLong(this.p), true);
                a(2131694668);
                break label392;
              }
            }
            else
            {
              this.jdField_k_of_type_JavaLangString = null;
              this.jdField_l_of_type_JavaLangString = null;
              a(this.p, this.q);
              break label392;
            }
          }
          this.jdField_k_of_type_JavaLangString = null;
          this.jdField_l_of_type_JavaLangString = null;
          a(this.p, this.q, bool);
        }
        else
        {
          this.jdField_k_of_type_JavaLangString = null;
          this.jdField_l_of_type_JavaLangString = null;
          a(localCardOCRInfo);
        }
      }
      else
      {
        this.jdField_k_of_type_JavaLangString = this.p;
        this.jdField_l_of_type_JavaLangString = this.q;
        this.e = 0;
        I();
      }
    }
    else
    {
      this.jdField_k_of_type_JavaLangString = null;
      this.jdField_l_of_type_JavaLangString = null;
      b(this.p, this.q);
    }
    label392:
    this.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", paramInt);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
    if (localObject != null)
    {
      paramQQCustomDialog.addView(((AbsStructMsg)localObject).getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null));
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
    {
      localObject = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.b(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.b(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "updateImageView addStructView");
      }
      paramQQCustomDialog.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), (LinearLayout.LayoutParams)localObject);
    }
    return true;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getString(2131718879);
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
    int i1 = ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).getSelfBindState();
    if ((i1 >= 9) || ((this.g == 23) && ((i1 == 1) || (i1 == 2) || (i1 == 6) || (i1 == 7) || (i1 == 3)))) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_h_of_type_JavaLangInteger);
    }
    this.jdField_a_of_type_JavaUtilSet.add(jdField_l_of_type_JavaLangInteger);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("build forward ability in state=");
      localStringBuilder.append(i1);
      localStringBuilder.append(", type=");
      localStringBuilder.append(this.g);
      QLog.d("ForwardOption.ForwardShareCardOption", 2, localStringBuilder.toString());
    }
  }
  
  public String c()
  {
    if (!TextUtils.isEmpty(this.n)) {
      return this.n;
    }
    return null;
  }
  
  protected boolean m()
  {
    return true;
  }
  
  protected void t()
  {
    super.t();
    if (this.jdField_j_of_type_Boolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007012", "0X8007012", 0, 0, "", "", "", "");
    }
  }
  
  public void z()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver);
    }
    if (this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    }
    super.z();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareCardOption
 * JD-Core Version:    0.7.0.1
 */