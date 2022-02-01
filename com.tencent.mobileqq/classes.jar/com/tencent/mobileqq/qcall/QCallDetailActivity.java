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
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new QCallDetailActivity.2(this);
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new QCallDetailActivity.1(this);
  private Friends jdField_a_of_type_ComTencentMobileqqDataFriends;
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver = new QCallDetailActivity.3(this);
  private QCallDetailActivity.QCalDetailAdapter jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity$QCalDetailAdapter;
  private QCallFacade jdField_a_of_type_ComTencentMobileqqQcallQCallFacade;
  VipFunCallObserver jdField_a_of_type_ComTencentMobileqqVasVipavVipFunCallObserver = new QCallDetailActivity.10(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  Runnable jdField_a_of_type_JavaLangRunnable = new QCallDetailActivity.4(this);
  private String jdField_a_of_type_JavaLangString;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int = -1;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  private String f;
  private String g;
  
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
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("troop_uin");
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", 0);
    if (this.jdField_a_of_type_Int == 8) {
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("extra_type", 0);
    }
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("uinname");
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("bind_type", 0);
    this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("phonenum");
    if (this.jdField_c_of_type_Int == 2) {
      ReportController.b(this.app, "CliOper", "", "", "0X8004E95", "0X8004E95", 0, 0, "", "", "", "");
    }
    this.rightViewImg.setVisibility(8);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    if ((this.jdField_b_of_type_Int == 0) && (!a(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_b_of_type_Int = 1003;
    }
    this.jdField_d_of_type_Int = paramIntent.getIntExtra("contactID", -1);
    if (this.jdField_d_of_type_Int == -1)
    {
      paramIntent = (IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "");
      int i = this.jdField_a_of_type_Int;
      if (i != 1006)
      {
        if (i != 56938) {
          paramIntent = paramIntent.queryPhoneContactByUin(this.jdField_a_of_type_JavaLangString);
        } else {
          paramIntent = paramIntent.queryPhoneContactByMobile(this.jdField_a_of_type_JavaLangString);
        }
      }
      else {
        paramIntent = paramIntent.queryContactByCodeNumber(this.jdField_a_of_type_JavaLangString);
      }
      if (paramIntent != null) {
        this.jdField_d_of_type_Int = paramIntent.contactID;
      }
    }
  }
  
  private boolean a(String paramString)
  {
    return ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
  }
  
  private void b()
  {
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
  }
  
  private void c()
  {
    Object localObject1 = LayoutInflater.from(this);
    Object localObject3 = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((LayoutInflater)localObject1).inflate(2131561001, null));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368033));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371697));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367802));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371763));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371762));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369833));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369772));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364236));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364857));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131374193);
    int i = getResources().getColor(2131166476);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(i);
    localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131374194);
    ((View)localObject1).setBackgroundColor(i);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    Object localObject4 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368081);
    Object localObject2 = (ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376548);
    i = this.jdField_a_of_type_Int;
    Object localObject5;
    if (i != 25)
    {
      if (i != 26)
      {
        if ((i != 1001) && (i != 1010))
        {
          if (i != 2016) {
            if (i != 3000)
            {
              if ((i == 10002) || (i == 10004)) {
                break label634;
              }
              if (i != 56938)
              {
                this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, this.jdField_a_of_type_JavaLangString));
                break label1019;
              }
            }
            else
            {
              this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 101, this.jdField_a_of_type_JavaLangString));
              localObject4 = (DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
              if (localObject4 != null) {
                i = ((DiscussionManager)localObject4).a(this.jdField_a_of_type_JavaLangString);
              } else {
                i = 0;
              }
              if (i > 0)
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("(");
                ((StringBuilder)localObject4).append(i);
                ((StringBuilder)localObject4).append(")");
                localObject4 = ((StringBuilder)localObject4).toString();
                this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject4);
              }
              localObject4 = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
              if ((localObject4 != null) && (localObject1 != null))
              {
                ((RelativeLayout)localObject4).setVisibility(8);
                ((View)localObject1).setVisibility(8);
              }
              ((ImageView)localObject2).setVisibility(0);
              findViewById(2131374188).setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              break label1019;
            }
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842159);
          ((TextView)localObject4).setVisibility(0);
          localObject5 = ContactUtils.b(this.jdField_c_of_type_JavaLangString);
          ((TextView)localObject4).setText((CharSequence)localObject5);
          if (ContactUtils.a((String)localObject5)) {
            ((TextView)localObject4).setTextSize(0, getResources().getDimension(2131299111));
          } else {
            ((TextView)localObject4).setTextSize(0, getResources().getDimension(2131299112));
          }
          ((ImageView)localObject2).setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(2131699155);
          ((View)localObject1).setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          findViewById(2131374188).setVisibility(8);
          break label1019;
        }
        label634:
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getStrangerFaceDrawable(this.app, 200, this.jdField_a_of_type_JavaLangString, true));
      }
      else
      {
        this.g = null;
        localObject5 = OpenSDKUtils.a(this.app, this.jdField_a_of_type_JavaLangString);
        if (localObject5 != null) {
          this.g = ((PhoneContact)localObject5).uin;
        }
        if (this.g == null)
        {
          ((ImageView)localObject2).setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842159);
          ((TextView)localObject4).setVisibility(0);
          ((TextView)localObject4).setText(ContactUtils.b(this.jdField_c_of_type_JavaLangString));
        }
        else
        {
          ((ImageView)localObject2).setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(OpenSDKUtils.a(this.app, this.jdField_a_of_type_JavaLangString));
        }
        findViewById(2131374188).setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        ((View)localObject1).setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
    else
    {
      localObject4 = (IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "");
      if (localObject4 != null) {
        localObject1 = ((IPhoneContactService)localObject4).queryContactByCodeNumber(this.jdField_d_of_type_JavaLangString);
      } else {
        localObject1 = null;
      }
      localObject2 = localObject1;
      if (localObject4 != null)
      {
        localObject5 = this.jdField_d_of_type_JavaLangString;
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
        localObject1 = FaceDrawable.getMobileFaceDrawable(this.app, this.jdField_d_of_type_JavaLangString, (byte)3);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject2).name);
        if (localObject1 != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        }
      }
      else
      {
        localObject1 = this.app.getFaceBitmap(16, this.jdField_a_of_type_JavaLangString, (byte)3, true, 16);
        localObject2 = ((QCallCardManager)this.app.getManager(QQManagerFactory.QCALLCARD_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
        if ((localObject2 != null) && (((QCallCardInfo)localObject2).nickname != null)) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(((QCallCardInfo)localObject2).nickname);
        }
        if (localObject1 != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
        }
      }
    }
    label1019:
    ThreadManager.post(new QCallDetailActivity.5(this), 8, null, true);
    a(true);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(new QCallDetailActivity.6(this));
    localObject1 = localObject3;
    if (this.jdField_d_of_type_Int != -1)
    {
      localObject1 = this.app.getEntityManagerFactory().createEntityManager();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("contactID = ");
      ((StringBuilder)localObject2).append(this.jdField_d_of_type_Int);
      localObject1 = ((EntityManager)localObject1).query(PhoneContact.class, false, ((StringBuilder)localObject2).toString(), null, null, null, null, null);
      ReportController.b(this.app, "CliOper", "", "", "0X8005AF4", "0X8005AF4", 0, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_Int == 26)
    {
      localObject1 = new ArrayList();
      localObject2 = new PhoneContact();
      ((PhoneContact)localObject2).mobileNo = this.jdField_a_of_type_JavaLangString;
      ((PhoneContact)localObject2).type = 0;
      ((PhoneContact)localObject2).label = HardCodeUtil.a(2131709554);
      ((List)localObject1).add(localObject2);
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131374195).setVisibility(0);
      localObject2 = (NoScrollListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372528);
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
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" , uinType = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("QCallDetailActivity", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = localFriendsManager.e(this.jdField_a_of_type_JavaLangString);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Int == 3000)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends;
    if (localObject != null)
    {
      if ((((Friends)localObject).iTermType != 68104) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType != 65805))
      {
        int i = FriendsUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.eNetwork, this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType, this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("friend.getNetWorkType()：");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", friend.detalStatusFlag：");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag);
          ((StringBuilder)localObject).append(", friend.iTermType：");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType);
          QLog.d("QCallDetailActivity", 2, ((StringBuilder)localObject).toString());
        }
        if (OnlineStatusUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag, this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType) == 0) {
          return;
        }
        if ((i != 2) && (i != 3) && (i != 4) && (i != 5) && (i != 1) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId != 7) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId != 8))
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          return;
        }
        if (i == 2)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698687);
          this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698687));
          return;
        }
        if (i == 3)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698688);
          this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698688));
          return;
        }
        if (i == 4)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698689);
          this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698689));
          return;
        }
        if (i == 5)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698690);
          this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698690));
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 7)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131698693));
          this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698693));
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 8)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131698691));
          this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698691));
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 9)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131698692));
          this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698692));
          return;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845034);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698694);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698694));
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void f()
  {
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131374191);
    Button localButton1 = (Button)localLinearLayout1.findViewById(2131379994);
    localLinearLayout1.setOnClickListener(this);
    localButton1.setTag(Integer.valueOf(2131374191));
    localButton1.setOnClickListener(this);
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131374190);
    Button localButton2 = (Button)localLinearLayout2.findViewById(2131379994);
    localLinearLayout2.setOnClickListener(this);
    localButton2.setTag(Integer.valueOf(2131374190));
    localButton2.setOnClickListener(this);
    LinearLayout localLinearLayout3 = (LinearLayout)findViewById(2131374189);
    Button localButton3 = (Button)localLinearLayout3.findViewById(2131379994);
    localLinearLayout3.setOnClickListener(this);
    localButton3.setTag(Integer.valueOf(2131374189));
    localButton3.setOnClickListener(this);
    localButton1.setText(2131718751);
    int i = this.jdField_a_of_type_Int;
    if (i == 3000)
    {
      localButton1.setContentDescription(HardCodeUtil.a(2131709553));
      localButton3.setText(2131693337);
      localButton3.setContentDescription(localButton3.getResources().getString(2131693304));
      localLinearLayout2.setVisibility(8);
    }
    else if (i == 1008)
    {
      localLinearLayout2.setVisibility(8);
      localLinearLayout1.setVisibility(8);
      localButton3.setText(2131693304);
      localButton3.setContentDescription(getString(2131698683));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    else
    {
      int j = this.jdField_c_of_type_Int;
      if ((j != 2) && (j != 3) && (i != 25))
      {
        localButton1.setContentDescription(HardCodeUtil.a(2131709552));
        localButton3.setText(2131693304);
        localButton3.setContentDescription(localButton3.getResources().getString(2131693304));
        if (!CrmUtils.a(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int))
        {
          localLinearLayout2.setVisibility(0);
          localButton2.setText(2131698685);
          localButton2.setContentDescription(localButton2.getResources().getString(2131698685));
        }
        else
        {
          localLinearLayout2.setVisibility(8);
          i = this.jdField_c_of_type_Int;
          if ((i == 2) || (i == 3) || (this.jdField_a_of_type_Int == 25))
          {
            localLinearLayout2.setVisibility(8);
            localButton3.setContentDescription(getString(2131698684));
          }
        }
      }
      else
      {
        localLinearLayout2.setVisibility(8);
        localLinearLayout1.setVisibility(8);
        localButton3.setText(2131693304);
        localButton3.setContentDescription(getString(2131698683));
      }
    }
    if (this.jdField_a_of_type_Int != 0)
    {
      localLinearLayout3.setVisibility(8);
      localLinearLayout2.setVisibility(8);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131374192));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity$QCalDetailAdapter = new QCallDetailActivity.QCalDetailAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity$QCalDetailAdapter);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Int == 3000)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004068", "0X8004068", 0, 0, "", "", "", "");
      ReportController.b(this.app, "CliOper", "", "", "0X8004F91", "0X8004F91", 0, 0, "", "", "", "");
      ChatActivityUtils.a(this.app, this, this.jdField_a_of_type_Int, this.e, true, true, null, null);
      return;
    }
    ReportController.b(this.app, "CliOper", "", this.jdField_a_of_type_JavaLangString, "Two_video_call", "Tvc_msg_info_launch", 0, 0, "", "", "", "");
    ReportController.b(this.app, "CliOper", "", "", "0X8004F8A", "0X8004F8A", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_Int == 1024)
    {
      CrmUtils.a(this.app, this, this.jdField_c_of_type_JavaLangString, this.e, "IvrCallDetailEngineFalse");
      return;
    }
    ChatActivityUtils.a(this.app, this, this.jdField_a_of_type_Int, this.e, this.jdField_c_of_type_JavaLangString, this.f, true, this.jdField_b_of_type_JavaLangString, true, true, null, "from_internal");
  }
  
  private void i()
  {
    int i = this.jdField_b_of_type_Int;
    if (i == 1024)
    {
      CrmUtils.a(this, null, this.jdField_a_of_type_JavaLangString, false, -1, true, 2000);
      return;
    }
    if (i == 1008)
    {
      localObject = new ActivityURIRequest(this, "/pubaccount/detail");
      ((ActivityURIRequest)localObject).extra().putString("uin", this.jdField_a_of_type_JavaLangString);
      ((ActivityURIRequest)localObject).extra().putInt("uintype", 1008);
      ((ActivityURIRequest)localObject).extra().putInt("source", 113);
      ((ActivityURIRequest)localObject).setRequestCode(2000);
      QRoute.startUri((URIRequest)localObject, null);
      return;
    }
    Object localObject = new AllInOne(this.jdField_a_of_type_JavaLangString, 46);
    ((AllInOne)localObject).pa = 19;
    ((AllInOne)localObject).nickname = ContactUtils.a(this.app, this.jdField_a_of_type_JavaLangString);
    i = this.jdField_b_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 25)
        {
          if (i != 26)
          {
            if (i != 1000)
            {
              if (i != 1001)
              {
                if (i != 1009)
                {
                  if (i != 1010)
                  {
                    if (i != 4000)
                    {
                      if (i != 10002) {
                        if (i == 10010) {}
                      }
                      switch (i)
                      {
                      default: 
                        switch (i)
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
                        ((AllInOne)localObject).discussUin = this.jdField_b_of_type_JavaLangString;
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
              ((AllInOne)localObject).troopUin = this.jdField_b_of_type_JavaLangString;
            }
          }
          else
          {
            if (TextUtils.isEmpty(this.g)) {
              return;
            }
            if (this.g.equals("0"))
            {
              ((AllInOne)localObject).pa = 34;
            }
            else
            {
              ((AllInOne)localObject).pa = 1;
              ((AllInOne)localObject).uin = this.g;
              ((AllInOne)localObject).nickname = ContactUtils.a(this.app, this.g);
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
    i = this.jdField_b_of_type_Int;
    if ((i != 1001) && (i != 10002) && (i != 10004) && (i != 1010))
    {
      ProfileUtils.openProfileCard(this, (AllInOne)localObject);
      return;
    }
    i = this.jdField_b_of_type_Int;
    if ((i != 1001) && (i != 10002))
    {
      if (i == 1010) {
        ((AllInOne)localObject).profileEntryType = 13;
      }
    }
    else {
      ((AllInOne)localObject).profileEntryType = 12;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("AllInOne", (Parcelable)localObject);
    if (Utils.a(this.jdField_a_of_type_JavaLangString, this.app.getCurrentAccountUin())) {
      localIntent.putExtra("param_mode", 2);
    } else {
      localIntent.putExtra("param_mode", 3);
    }
    RouteUtils.a(BaseApplicationImpl.getContext(), localIntent, "/nearby/people/profile");
  }
  
  private void j()
  {
    AllInOne localAllInOne = new AllInOne(this.jdField_a_of_type_JavaLangString, 80);
    QCallCardInfo localQCallCardInfo = ((QCallCardManager)this.app.getManager(QQManagerFactory.QCALLCARD_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
    Object localObject1 = (IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = this.jdField_d_of_type_JavaLangString;
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
        ((StringBuilder)localObject2).append(this.jdField_d_of_type_JavaLangString);
        ((StringBuilder)localObject2).append("mFriendUin = ");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        QLog.i("startQCallProfileCardActivity ", 2, ((StringBuilder)localObject2).toString());
      }
    }
    if (localObject1 != null) {
      localAllInOne.nickname = ((PhoneContact)localObject1).name;
    }
    if (((localObject1 != null) || (localQCallCardInfo != null)) && (this.jdField_d_of_type_JavaLangString != null))
    {
      localAllInOne.pa = 80;
      localObject1 = new ProfileContactInfo(HardCodeUtil.a(2131709551), this.jdField_d_of_type_JavaLangString, "");
      if (localAllInOne.contactArray == null)
      {
        localAllInOne.contactArray = new ArrayList();
        localAllInOne.contactArray.add(localObject1);
      }
      ProfileUtils.openProfileCard(this.app.getApplication().getApplicationContext(), localAllInOne);
      int i = this.jdField_a_of_type_Int;
      if (i == 25)
      {
        ReportController.b(null, "CliOper", "", "", "0X8006251", "0X8006251", 0, 0, "", "", "", "");
        return;
      }
      if (i != 24)
      {
        i = this.jdField_c_of_type_Int;
        if ((i != 2) && (i != 3)) {}
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
    localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_b_of_type_Int);
    startActivityForResult(localIntent, 2000);
  }
  
  public void a(Context paramContext, String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.create(paramContext);
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    arrayOfInt[0] = 2;
    arrayOfInt[1] = 3;
    if (this.jdField_a_of_type_Int == 26)
    {
      OpenSDKUtils.a(this.app, paramContext, paramString);
      return;
    }
    localActionSheet.addButton(2131690720);
    localActionSheet.addCancelButton(2131690728);
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
    DiscussionInfo localDiscussionInfo = localDiscussionManager.a(paramString);
    if ((localDiscussionInfo != null) && (localDiscussionInfo.discussionName != null))
    {
      this.jdField_c_of_type_JavaLangString = localDiscussionInfo.discussionName;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 101, paramString));
      int i = localDiscussionManager.a(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
      if (i > 0)
      {
        paramString = new StringBuilder();
        paramString.append("(");
        paramString.append(i);
        paramString.append(")");
        paramString = paramString.toString();
      }
      else
      {
        paramString = "";
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  void a(boolean paramBoolean)
  {
    int i = VipFunCallUtil.a(this.app, this.jdField_a_of_type_JavaLangString, 6, true, null);
    if ((i == 0) && (paramBoolean) && (this.app != null)) {
      try
      {
        VipSetFunCallHandler localVipSetFunCallHandler = (VipSetFunCallHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER);
        localObject = new Bundle();
        ((Bundle)localObject).putLong("uin", Long.parseLong(this.jdField_a_of_type_JavaLangString));
        ((Bundle)localObject).putString("phone", "");
        this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFunCallObserver, true);
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
    if (i == 0) {
      str = getResources().getString(2131690722);
    } else {
      str = VipFunCallUtil.b(this.app, i, -1, "name");
    }
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = getResources().getString(2131690722);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
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
    super.setContentView(2131561000);
    paramBundle = getString(2131698695);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBundle);
    localStringBuilder.append(getString(2131695914));
    setTitle(paramBundle, localStringBuilder.toString());
    setLeftViewName(2131695431);
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = ((QCallFacade)this.app.getManager(QQManagerFactory.RECENT_CALL_FACADE));
    a(getIntent());
    c();
    f();
    g();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    if ((this.jdField_a_of_type_Int == 0) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.isGetOnlineListRecently()) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.shouldGetOnlineInfo())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getOnlineInfo(this.jdField_a_of_type_JavaLangString, false);
    }
    this.jdField_a_of_type_ArrayOfInt = new int[3];
    int i = this.jdField_a_of_type_Int;
    if (i == 25)
    {
      ReportController.b(null, "CliOper", "", "", "0X800624F", "0X800624F", 0, 0, "", "", "", "");
    }
    else if (i != 24)
    {
      i = this.jdField_c_of_type_Int;
      if ((i != 2) && (i != 3)) {}
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
    this.e = null;
    this.f = null;
    if (this.jdField_a_of_type_Int == 1006) {
      this.f = this.jdField_a_of_type_JavaLangString;
    } else {
      this.e = this.jdField_a_of_type_JavaLangString;
    }
    int j = paramView.getId();
    int i = j;
    if (2131379994 == j) {}
    try
    {
      i = ((Integer)paramView.getTag()).intValue();
      Object localObject;
      switch (i)
      {
      default: 
        break;
      case 2131374191: 
        if (this.jdField_a_of_type_Int == 3000)
        {
          ReportController.b(this.app, "CliOper", "", "", "0X8004069", "0X8004069", 0, 0, "", "", "", "");
          ReportController.b(this.app, "CliOper", "", "", "0X8004F90", "0X8004F90", 0, 0, "", "", "", "");
        }
        else
        {
          ReportController.b(this.app, "CliOper", "", "", "0X8004F89", "0X8004F89", 0, 0, "", "", "", "");
        }
        localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
        ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("uintype", this.jdField_a_of_type_Int);
        ((Intent)localObject).putExtra("uinname", this.jdField_c_of_type_JavaLangString);
        ((Intent)localObject).putExtra("entrance", 0);
        startActivity((Intent)localObject);
        break;
      case 2131374190: 
        ReportController.b(this.app, "CliOper", "", this.jdField_a_of_type_JavaLangString, "Two_call", "Two_call_launch", 0, 0, "15", a(this.jdField_a_of_type_Int), "", "");
        ReportController.b(this.app, "CliOper", "", "", "0X8004F8B", "0X8004F8B", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_Int == 1024)
        {
          if (CrmUtils.a(this.app, this.e, this.jdField_a_of_type_Int))
          {
            CrmUtils.a(this.app, this, this.jdField_c_of_type_JavaLangString, this.e, "IvrCallDetailEngineFalse");
            ReportController.b(this.app, "CliOper", "", "", "0X80049D6", "0X80049D6", 0, 0, "", "", "", "");
          }
          else
          {
            QQToast.a(paramView.getContext(), 2131695706, 1).b(paramView.getContext().getResources().getDimensionPixelSize(2131299168));
            if (QLog.isColorLevel()) {
              QLog.d("QCallDetailActivity", 2, "Don't support ivr");
            }
          }
        }
        else {
          ChatActivityUtils.a(this.app, this, this.jdField_a_of_type_Int, this.e, this.jdField_c_of_type_JavaLangString, this.f, false, this.jdField_b_of_type_JavaLangString, true, true, null, "from_internal");
        }
        break;
      case 2131374189: 
        h();
        break;
      case 2131369833: 
      case 2131371762: 
        i = this.jdField_a_of_type_Int;
        if (i != 2016) {
          if (i != 3000)
          {
            if (i != 56938)
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
      case 2131369772: 
        i = ((ISVIPHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
        if (i == 2) {
          i = 0;
        } else if (i == 3) {
          i = 2;
        }
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("individuation_url_type", 40304);
        VasWebviewUtil.b(this, IndividuationUrlHelper.a(this, "call", "mvip.gongneng.anroid.individuation.web"), 524288L, (Intent)localObject, true, -1);
        localObject = this.app;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i);
        ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8004A1F", "0X8004A1F", 0, 0, localStringBuilder.toString(), "", "", "");
        break;
      case 2131369202: 
        finish();
        break;
      case 2131364236: 
        if (this.jdField_a_of_type_Int == 26) {
          OpenSDKUtils.a(this.app, this, this.jdField_a_of_type_JavaLangString);
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
        i = j;
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
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFunCallObserver);
    }
    ChatActivityUtils.a();
    QCallDetailActivity.QCalDetailAdapter localQCalDetailAdapter = this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity$QCalDetailAdapter;
    if (localQCalDetailAdapter != null)
    {
      localQCalDetailAdapter.a = null;
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity$QCalDetailAdapter = null;
    }
    ThreadManager.remove(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable = null;
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver);
  }
  
  protected void onResume()
  {
    super.onResume();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity
 * JD-Core Version:    0.7.0.1
 */