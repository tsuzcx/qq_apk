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
  boolean a;
  DiscussionHandler ad;
  AbsShareMsg ae;
  AbsStructMsg af;
  private int ag = -1;
  private String ah;
  private String ai;
  private boolean aj = false;
  private String ak;
  private String al;
  private String am;
  private int an;
  private String ao;
  private String ap;
  private String aq;
  private int ar;
  private String as;
  private int at;
  private String au;
  private TroopManagerBizObserver av = new ForwardShareCardOption.2(this);
  private QidianBusinessObserver aw = new ForwardShareCardOption.3(this);
  private DiscussionObserver ax = new ForwardShareCardOption.4(this);
  
  public ForwardShareCardOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  private View a(String paramString, Drawable paramDrawable)
  {
    View localView = LayoutInflater.from(this.s).inflate(2131624610, null);
    TextView localTextView = (TextView)localView.findViewById(2131448988);
    ImageView localImageView = (ImageView)localView.findViewById(2131435631);
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
      paramString2.append(URLEncoder.encode(ContactUtils.b(paramQQAppInterface)));
      paramString2 = paramString2.toString();
    }
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append("&version=1&uin=");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    paramString2 = ((AbsShareMsg.Builder)localObject1).c(84).a(2);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131902798));
    ((StringBuilder)localObject1).append(paramQQAppInterface);
    paramActivity = paramString2.a(((StringBuilder)localObject1).toString()).a("plugin", "", "AppCmd://OpenContactInfo/?uin=", (String)localObject2, (String)localObject2).d(paramActivity.getResources().getString(2131915623)).a();
    paramString2 = new StructMsgItemLayout2();
    paramString2.c(1);
    paramString2.a(new StructMsgItemCover((String)localObject2));
    paramString2.a(new StructMsgItemTitle(paramQQAppInterface));
    if (paramString1.startsWith("+86")) {
      paramQQAppInterface = paramString1.substring(3, paramString1.length());
    } else {
      paramQQAppInterface = paramString1;
    }
    int i;
    if (paramBoolean) {
      i = 2131902821;
    } else {
      i = 2131902803;
    }
    localObject1 = HardCodeUtil.a(i);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(paramQQAppInterface);
    paramQQAppInterface = new StructMsgItemSummary(((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(paramString1);
    paramQQAppInterface.e(((StringBuilder)localObject2).toString());
    paramString2.a(paramQQAppInterface);
    paramActivity.addItem(a(HardCodeUtil.a(2131902828)));
    paramActivity.addItem(paramString2);
    return paramActivity;
  }
  
  private static AbsStructMsgItem a(String paramString)
  {
    StructMsgItemLayoutDefault localStructMsgItemLayoutDefault = new StructMsgItemLayoutDefault();
    localStructMsgItemLayoutDefault.c(1);
    localStructMsgItemLayoutDefault.b(paramString);
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
    if ((paramCardOCRInfo.d != null) && (paramCardOCRInfo.d.size() > 0))
    {
      localObject1 = (String)paramCardOCRInfo.d.get(0);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    else
    {
      localObject1 = "";
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("url=");
    ((StringBuilder)localObject3).append(paramCardOCRInfo.b);
    ((StringBuilder)localObject3).append(";name=");
    ((StringBuilder)localObject3).append(paramCardOCRInfo.a);
    ((StringBuilder)localObject3).append(";phone=");
    ((StringBuilder)localObject3).append((String)localObject1);
    localObject3 = ((StringBuilder)localObject3).toString();
    localObject2 = ((AbsShareMsg.Builder)localObject2).c(73).a(this.s.getString(2131896610, new Object[] { paramCardOCRInfo.a })).a(2).a("shareBusinessCard", "", (String)localObject3, (String)localObject3, (String)localObject3).d(this.s.getResources().getString(2131916411)).a();
    localObject3 = new StructMsgItemLayoutDefault();
    ((AbsStructMsgItem)localObject3).c(1);
    ((AbsStructMsgItem)localObject3).b(this.s.getString(2131896608));
    StructMsgItemLayout2 localStructMsgItemLayout2 = new StructMsgItemLayout2();
    localStructMsgItemLayout2.c(3);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramCardOCRInfo.b);
    localStringBuilder.append("/?02");
    localStructMsgItemLayout2.a(new StructMsgItemCover(localStringBuilder.toString()));
    localStructMsgItemLayout2.a(new StructMsgItemTitle(paramCardOCRInfo.a));
    localStructMsgItemLayout2.a(new StructMsgItemSummary((String)localObject1));
    ((AbsShareMsg)localObject2).addItem((AbsStructMsgElement)localObject3);
    ((AbsShareMsg)localObject2).addItem(localStructMsgItemLayout2);
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("req_type", 5);
    ((Bundle)localObject1).putString("image_url", paramCardOCRInfo.b);
    BusinessCardUtils.a(paramCardOCRInfo.b);
    this.af = StructMsgFactory.a(((StructMsgForImageShare)StructMsgFactory.a((Bundle)localObject1)).getBytes());
    this.t.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
    I();
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!QidianManager.a(this.q, paramString1)) {
      return;
    }
    Object localObject1 = ((FriendsManager)this.q.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(paramString1);
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
      localObject1 = QidianManager.c(this.q, paramString1);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramString2 = (String)localObject1;
      }
      localObject1 = ((AbsShareMsg.Builder)localObject3).c(14).a(2).a(1);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131902818));
      ((StringBuilder)localObject3).append(paramString2);
      localObject1 = ((AbsShareMsg.Builder)localObject1).a(((StringBuilder)localObject3).toString()).a("plugin", str, "", (String)localObject2, (String)localObject4).d(this.s.getResources().getString(2131915618)).a();
      localObject2 = new StructMsgItemLayout2();
      ((AbsStructMsgItem)localObject2).c(1);
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemCover((String)localObject5));
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemTitle(paramString2));
      paramString2 = new StringBuilder();
      paramString2.append(HardCodeUtil.a(2131902830));
      paramString2.append(QidianManager.d(this.q, paramString1));
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemSummary(paramString2.toString()));
      ((AbsShareMsg)localObject1).addItem(a(HardCodeUtil.a(2131902822)));
      ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject2);
      this.t.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      this.ae = ((AbsShareMsg)localObject1);
      I();
    }
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.a = true;
    paramString1 = a(this.q, this.s, paramString1, paramString2, paramBoolean);
    this.t.putByteArray("stuctmsg_bytes", paramString1.getBytes());
    this.ae = paramString1;
    I();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    Object localObject = (TicketManager)this.q.getManager(2);
    int i = ((DiscussionManager)this.q.getManager(QQManagerFactory.DISCUSSION_MANAGER)).c(paramString);
    localObject = ((TicketManager)localObject).getSkey(this.q.getAccount());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      ThreadManager.post(new ForwardShareCardOption.1(this, i, paramString, (String)localObject, paramBoolean), 8, null, false);
      return;
    }
    ae();
    QQToast.makeText(this.s, -1, HardCodeUtil.a(2131902826), 0).show(this.s.getResources().getDimensionPixelSize(2131299920));
  }
  
  private View au()
  {
    if (this.ae != null)
    {
      new RelativeLayout.LayoutParams(-1, -2).setMargins(AIOUtils.b(-15.0F, this.s.getResources()), 0, AIOUtils.b(-15.0F, this.s.getResources()), 0);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "updateImageView addStructView");
      }
      return this.ae.getPreDialogView(this.s, null);
    }
    return new View(this.s);
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
    localObject1 = ContactUtils.c(this.q, paramString1);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString2 = (String)localObject1;
    }
    localObject1 = ((AbsShareMsg.Builder)localObject2).c(14).a(2).a(1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131902816));
    ((StringBuilder)localObject2).append(paramString2);
    localObject1 = ((AbsShareMsg.Builder)localObject1).a(((StringBuilder)localObject2).toString()).a("plugin", "", str2, str1, str1).d(this.s.getResources().getString(2131915618)).a();
    localObject2 = new StructMsgItemLayout2();
    ((AbsStructMsgItem)localObject2).c(1);
    ((AbsStructMsgItem)localObject2).a(new StructMsgItemCover(str1));
    ((AbsStructMsgItem)localObject2).a(new StructMsgItemTitle(paramString2));
    paramString2 = new StringBuilder();
    paramString2.append(HardCodeUtil.a(2131902782));
    paramString2.append(paramString1);
    ((AbsStructMsgItem)localObject2).a(new StructMsgItemSummary(paramString2.toString()));
    ((AbsShareMsg)localObject1).addItem(a(HardCodeUtil.a(2131902792)));
    ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject2);
    this.t.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
    this.ae = ((AbsShareMsg)localObject1);
    I();
  }
  
  private void c(String paramString1, String paramString2)
  {
    Object localObject1 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(15);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131902808));
    ((StringBuilder)localObject2).append(this.am);
    localObject2 = ((AbsShareMsg.Builder)localObject1).a(((StringBuilder)localObject2).toString()).e(this.ak).a();
    localObject1 = (DiscussionManager)this.q.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if (localObject1 != null)
    {
      localObject1 = ((DiscussionManager)localObject1).d(paramString1);
      if (localObject1 != null)
      {
        paramString1 = ContactUtils.a(this.q, paramString1, ((DiscussionInfo)localObject1).ownerUin);
        break label113;
      }
    }
    paramString1 = null;
    label113:
    localObject1 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      localObject1 = HardCodeUtil.a(2131902804);
    }
    paramString1 = StructMsgElementFactory.a(2);
    String str = this.am;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131902827));
    localStringBuilder.append((String)localObject1);
    paramString1.a(paramString2, str, localStringBuilder.toString(), 1);
    ((AbsShareMsg)localObject2).addItem(a(HardCodeUtil.a(2131902788)));
    ((AbsShareMsg)localObject2).addItem(paramString1);
    this.t.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
    this.ae = ((AbsShareMsg)localObject2);
  }
  
  private void o()
  {
    Object localObject2 = this.am;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.al;
    }
    localObject2 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((ITroopAvatarUtilApi)localObject2).getAvatarAddress("", this.al, 0));
    ((StringBuilder)localObject3).append("100");
    String str1 = ((StringBuilder)localObject3).toString();
    localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(15);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.s.getString(2131915625));
    ((StringBuilder)localObject3).append((String)localObject1);
    AbsShareMsg localAbsShareMsg = ((AbsShareMsg.Builder)localObject2).a(((StringBuilder)localObject3).toString()).e(this.ah).a();
    AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2);
    localObject3 = this.s.getString(2131916578);
    Object localObject4 = (TroopManager)this.q.getManager(QQManagerFactory.TROOP_MANAGER);
    localObject2 = localObject3;
    if (localObject4 != null)
    {
      String str2 = this.al;
      localObject2 = localObject3;
      if (str2 != null)
      {
        localObject4 = ((TroopManager)localObject4).f(str2);
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
    localAbsShareMsg.addItem(a(HardCodeUtil.a(2131902790)));
    localAbsShareMsg.addItem(localAbsStructMsgItem);
    this.t.putByteArray("stuctmsg_bytes", localAbsShareMsg.getBytes());
    this.ae = localAbsShareMsg;
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
    I();
  }
  
  private void p()
  {
    boolean bool2 = NetworkUtil.isNetSupport(BaseApplication.getContext());
    boolean bool1 = false;
    if (!bool2)
    {
      QQToast.makeText(this.s, this.s.getString(2131889169), 0).show(this.s.getResources().getDimensionPixelSize(2131299920));
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardShareCardOption", 2, "tryToGetShareLink: net is not supported");
      }
      this.ag = -1;
    }
    a(2131892360);
    Object localObject = (TroopManager)this.q.getManager(QQManagerFactory.TROOP_MANAGER);
    if (((TroopManager)localObject).Z(this.al))
    {
      localObject = ((TroopManager)localObject).g(this.al);
      ((QidianHandler)this.q.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).b(this.al, ((TroopInfo)localObject).troopowneruin);
      return;
    }
    localObject = (ITroopManagerBizHandler)this.q.getBusinessHandler(BusinessHandlerFactory.TROOP_MANAGER_BIZ_HANDLER);
    String str = this.al;
    if (this.ag == 0) {
      bool1 = true;
    }
    ((ITroopManagerBizHandler)localObject).d(str, bool1);
  }
  
  public String B()
  {
    if (!TextUtils.isEmpty(this.ap)) {
      return this.ap;
    }
    return null;
  }
  
  protected void W()
  {
    super.W();
    if (this.a) {
      ReportController.b(this.q, "CliOper", "", "", "0X8007012", "0X8007012", 0, 0, "", "", "", "");
    }
  }
  
  protected View a()
  {
    int i = this.at;
    View localView = null;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 30)
        {
          if (i != 1006) {
            if (i != 1024)
            {
              if (i != 3000)
              {
                if (i != 56938)
                {
                  localView = au();
                  break label271;
                }
              }
              else
              {
                localView = a(String.format("[%s]%s", new Object[] { HardCodeUtil.a(2131902815), this.au }), FaceDrawable.getFaceDrawable(this.q, 101, this.as));
                break label271;
              }
            }
            else
            {
              localView = au();
              break label271;
            }
          }
          localView = a(String.format("[%s]%s", new Object[] { HardCodeUtil.a(2131902831), this.au }), FaceDrawable.getFaceDrawable(this.q, 11, this.as));
        }
        else
        {
          localObject = this.af;
          if (localObject != null) {
            localView = ((AbsStructMsg)localObject).getPreDialogView(this.s, null);
          }
        }
      }
      else {
        localView = a(String.format("[%s]%s", new Object[] { HardCodeUtil.a(2131902801), this.au }), FaceDrawable.getFaceDrawable(this.q, 4, this.as));
      }
    }
    else {
      localView = a(String.format("[%s]%s", new Object[] { HardCodeUtil.a(2131902806), this.au }), FaceDrawable.getFaceDrawable(this.q, 1, this.as));
    }
    label271:
    Object localObject = localView;
    if (localView == null) {
      localObject = new View(this.s);
    }
    return localObject;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (!E()) {
      return;
    }
    this.ae = null;
    this.at = paramBundle.getInt("uintype");
    this.as = paramBundle.getString("uin");
    this.au = paramBundle.getString("uinname");
    paramBundle.getString("troop_uin");
    CardOCRInfo localCardOCRInfo = (CardOCRInfo)paramBundle.getParcelable("business_card_ocr");
    boolean bool = paramBundle.getBoolean("bindContact", true);
    this.t.putString("uin", this.ao);
    this.t.putInt("uintype", this.an);
    this.t.putString("troop_uin", this.aq);
    this.t.putString("uinname", this.ap);
    int i = this.at;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 30)
        {
          if (i != 1006) {
            if (i != 1024)
            {
              if (i != 3000)
              {
                if (i != 56938) {
                  break label395;
                }
              }
              else
              {
                this.al = this.as;
                this.am = this.au;
                this.aj = true;
                if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
                {
                  QQToast.makeText(this.s, this.s.getString(2131889169), 0).show(this.s.getResources().getDimensionPixelSize(2131299920));
                  return;
                }
                this.ad.a(Long.parseLong(this.as), true);
                a(2131892360);
                break label395;
              }
            }
            else
            {
              this.al = null;
              this.am = null;
              a(this.as, this.au);
              break label395;
            }
          }
          this.al = null;
          this.am = null;
          a(this.as, this.au, bool);
        }
        else
        {
          this.al = null;
          this.am = null;
          a(localCardOCRInfo);
        }
      }
      else
      {
        this.al = this.as;
        this.am = this.au;
        this.ag = 0;
        p();
      }
    }
    else
    {
      this.al = null;
      this.am = null;
      b(this.as, this.au);
    }
    label395:
    this.t.putInt("key_forward_ability_type", paramInt);
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    Object localObject = this.af;
    if (localObject != null)
    {
      paramQQCustomDialog.addView(((AbsStructMsg)localObject).getPreDialogView(this.s, null));
    }
    else if (this.ae != null)
    {
      localObject = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.b(-15.0F, this.s.getResources()), 0, AIOUtils.b(-15.0F, this.s.getResources()), 0);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "updateImageView addStructView");
      }
      paramQQCustomDialog.addView(this.ae.getPreDialogView(this.s, null), (LinearLayout.LayoutParams)localObject);
    }
    return true;
  }
  
  public void ad()
  {
    if (this.av != null) {
      this.q.removeObserver(this.av);
    }
    if (this.ax != null) {
      this.q.removeObserver(this.ax);
    }
    if (this.aw != null) {
      this.q.removeObserver(this.aw);
    }
    super.ad();
  }
  
  protected void b()
  {
    ReportController.b(this.q, "CliOper", "", "", "0X80056B4", "0X80056B4", 0, 0, "", "", "", "");
    super.b();
    if (this.a) {
      ReportController.b(this.q, "CliOper", "", "", "0X8007013", "0X8007013", 0, 0, "", "", "", "");
    }
  }
  
  protected void c()
  {
    if (ai()) {
      this.C.add(c);
    }
    if (ag()) {
      this.C.add(e);
    }
    if (ah()) {
      this.C.add(d);
    }
    int i = ((IPhoneContactService)this.q.getRuntimeService(IPhoneContactService.class, "")).getSelfBindState();
    if ((i >= 9) || ((this.ar == 23) && ((i == 1) || (i == 2) || (i == 6) || (i == 7) || (i == 3)))) {
      this.C.add(i);
    }
    this.C.add(m);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("build forward ability in state=");
      localStringBuilder.append(i);
      localStringBuilder.append(", type=");
      localStringBuilder.append(this.ar);
      QLog.d("ForwardOption.ForwardShareCardOption", 2, localStringBuilder.toString());
    }
  }
  
  public boolean e()
  {
    this.q.addObserver(this.av);
    this.q.addObserver(this.ax);
    this.q.addObserver(this.aw);
    this.ad = ((DiscussionHandler)this.q.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER));
    this.ao = this.r.getStringExtra("curent_aio_uin");
    this.ap = this.r.getStringExtra("curent_aio_uinname");
    this.an = this.r.getIntExtra("curent_aio_uin_type", 0);
    this.aq = this.r.getStringExtra("curent_aio_troop_uin");
    this.ar = this.r.getIntExtra("forward_type", -1);
    return true;
  }
  
  protected boolean k()
  {
    return true;
  }
  
  public String u()
  {
    return this.s.getString(2131916412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareCardOption
 * JD-Core Version:    0.7.0.1
 */