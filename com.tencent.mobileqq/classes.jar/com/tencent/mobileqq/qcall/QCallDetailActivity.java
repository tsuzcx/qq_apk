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
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.friend.FriendsUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.vipav.VipFunCallObserver;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
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
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new QCallDetailActivity.3(this);
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new QCallDetailActivity.2(this);
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new QCallDetailActivity.1(this);
  private Friends jdField_a_of_type_ComTencentMobileqqDataFriends;
  private QCallDetailActivity.QCalDetailAdapter jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity$QCalDetailAdapter;
  private QCallFacade jdField_a_of_type_ComTencentMobileqqQcallQCallFacade;
  VipFunCallObserver jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver = new QCallDetailActivity.10(this);
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
    switch (paramInt)
    {
    default: 
      return "999";
    case 0: 
      return "0";
    case 1004: 
      return "1";
    case 2: 
      return "2";
    }
    return "3";
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      finish();
    }
    do
    {
      return;
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
    } while (this.jdField_d_of_type_Int != -1);
    paramIntent = (PhoneContactManager)this.app.getManager(QQManagerFactory.CONTACT_MANAGER);
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      paramIntent = paramIntent.a(this.jdField_a_of_type_JavaLangString);
    }
    while (paramIntent != null)
    {
      this.jdField_d_of_type_Int = paramIntent.contactID;
      return;
      paramIntent = paramIntent.c(this.jdField_a_of_type_JavaLangString);
      continue;
      paramIntent = paramIntent.b(this.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this).inflate(2131561137, null));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368281));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372115));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368050));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372181));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372180));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131370162));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131370094));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364324));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364973));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131374655);
    int i = getResources().getColor(2131166465);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(i);
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131374656);
    ((View)localObject1).setBackgroundColor(i);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    Object localObject3 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368330);
    Object localObject2 = (ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377070);
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, this.jdField_a_of_type_JavaLangString));
      ThreadManager.post(new QCallDetailActivity.5(this), 8, null, true);
      a(true);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(new QCallDetailActivity.6(this));
      if (this.jdField_d_of_type_Int != -1)
      {
        localObject1 = this.app.getEntityManagerFactory().createEntityManager().query(PhoneContact.class, false, "contactID = " + this.jdField_d_of_type_Int, null, null, null, null, null);
        ReportController.b(this.app, "CliOper", "", "", "0X8005AF4", "0X8005AF4", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_Int == 26)
        {
          localObject1 = new ArrayList();
          localObject2 = new PhoneContact();
          ((PhoneContact)localObject2).mobileNo = this.jdField_a_of_type_JavaLangString;
          ((PhoneContact)localObject2).type = 0;
          ((PhoneContact)localObject2).label = HardCodeUtil.a(2131709545);
          ((List)localObject1).add(localObject2);
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131374657).setVisibility(0);
            localObject2 = (NoScrollListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372941);
            ((NoScrollListView)localObject2).setVisibility(0);
            ((NoScrollListView)localObject2).setAdapter(new PhoneNumberAdapter(this, (List)localObject1));
            ((NoScrollListView)localObject2).setOnItemClickListener(new QCallDetailActivity.7(this));
          }
          return;
        }
      }
      break;
    case 3000: 
      label500:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 101, this.jdField_a_of_type_JavaLangString));
      label556:
      localObject3 = (DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      if (localObject3 == null) {}
      break;
    }
    for (i = ((DiscussionManager)localObject3).a(this.jdField_a_of_type_JavaLangString);; i = 0)
    {
      if (i > 0)
      {
        localObject3 = "(" + i + ")";
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
      }
      if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (localObject1 != null))
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        ((View)localObject1).setVisibility(8);
      }
      ((ImageView)localObject2).setVisibility(0);
      findViewById(2131374650).setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getStrangerFaceDrawable(this.app, 200, this.jdField_a_of_type_JavaLangString, true));
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842261);
      ((TextView)localObject3).setVisibility(0);
      Object localObject4 = ContactUtils.b(this.jdField_c_of_type_JavaLangString);
      ((TextView)localObject3).setText((CharSequence)localObject4);
      if (ContactUtils.a((String)localObject4)) {
        ((TextView)localObject3).setTextSize(0, getResources().getDimension(2131299106));
      }
      for (;;)
      {
        ((ImageView)localObject2).setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131699051);
        ((View)localObject1).setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        findViewById(2131374650).setVisibility(8);
        break;
        ((TextView)localObject3).setTextSize(0, getResources().getDimension(2131299107));
      }
      localObject2 = (PhoneContactManager)this.app.getManager(QQManagerFactory.CONTACT_MANAGER);
      if (localObject2 != null) {}
      for (localObject1 = ((PhoneContactManager)localObject2).c(this.jdField_d_of_type_JavaLangString);; localObject1 = null)
      {
        if ((localObject2 != null) && (this.jdField_d_of_type_JavaLangString != null)) {
          localObject1 = ((PhoneContactManager)localObject2).c(this.jdField_d_of_type_JavaLangString);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QCallDetailActivity", 2, "getFaceBitmap contact = " + localObject1);
          }
          if (localObject1 != null)
          {
            localObject2 = FaceDrawable.getMobileFaceDrawable(this.app, this.jdField_d_of_type_JavaLangString, (byte)3);
            this.jdField_b_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
            if (localObject2 == null) {
              break;
            }
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            break;
          }
          localObject1 = this.app.getFaceBitmap(16, this.jdField_a_of_type_JavaLangString, (byte)3, true, 16);
          localObject2 = ((QCallCardManager)this.app.getManager(QQManagerFactory.QCALLCARD_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
          if ((localObject2 != null) && (((QCallCardInfo)localObject2).nickname != null)) {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(((QCallCardInfo)localObject2).nickname);
          }
          if (localObject1 == null) {
            break;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
          break;
          this.g = null;
          localObject4 = OpenSDKUtils.a(this.app, this.jdField_a_of_type_JavaLangString);
          if (localObject4 != null) {
            this.g = ((PhoneContact)localObject4).uin;
          }
          if (this.g == null)
          {
            ((ImageView)localObject2).setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842261);
            ((TextView)localObject3).setVisibility(0);
            ((TextView)localObject3).setText(ContactUtils.b(this.jdField_c_of_type_JavaLangString));
          }
          for (;;)
          {
            findViewById(2131374650).setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            ((View)localObject1).setVisibility(8);
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            break;
            ((ImageView)localObject2).setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(OpenSDKUtils.a(this.app, this.jdField_a_of_type_JavaLangString));
          }
          break label556;
          localObject1 = null;
          break label500;
        }
      }
    }
  }
  
  private void d()
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (QLog.isColorLevel()) {
      QLog.d("QCallDetailActivity", 2, "updateOnlineStatus mFriendUin : " + this.jdField_a_of_type_JavaLangString + " , uinType = " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = localFriendsManager.e(this.jdField_a_of_type_JavaLangString);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Int == 3000)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    int i;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqDataFriends == null);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType == 68104) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType == 65805))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      i = FriendsUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.eNetwork, this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType, this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId);
      if (QLog.isColorLevel()) {
        QLog.d("QCallDetailActivity", 2, "friend.getNetWorkType()：" + i + ", friend.detalStatusFlag：" + this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag + ", friend.iTermType：" + this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType);
      }
    } while (ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag, this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType) == 0);
    if ((i == 2) || (i == 3) || (i == 4) || (i == 5) || (i == 1) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 7) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 8))
    {
      if (i == 2)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698621);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698621));
        return;
      }
      if (i == 3)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698622);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698622));
        return;
      }
      if (i == 4)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698623);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698623));
        return;
      }
      if (i == 5)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698624);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698624));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 7)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131698627));
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698627));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 8)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131698625));
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698625));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 9)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131698626));
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698626));
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845157);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698628);
      this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698628));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void f()
  {
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131374653);
    Button localButton1 = (Button)localLinearLayout1.findViewById(2131380726);
    localLinearLayout1.setOnClickListener(this);
    localButton1.setTag(Integer.valueOf(2131374653));
    localButton1.setOnClickListener(this);
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131374652);
    Button localButton2 = (Button)localLinearLayout2.findViewById(2131380726);
    localLinearLayout2.setOnClickListener(this);
    localButton2.setTag(Integer.valueOf(2131374652));
    localButton2.setOnClickListener(this);
    LinearLayout localLinearLayout3 = (LinearLayout)findViewById(2131374651);
    Button localButton3 = (Button)localLinearLayout3.findViewById(2131380726);
    localLinearLayout3.setOnClickListener(this);
    localButton3.setTag(Integer.valueOf(2131374651));
    localButton3.setOnClickListener(this);
    localButton1.setText(2131719035);
    if (this.jdField_a_of_type_Int == 3000)
    {
      localButton1.setContentDescription(HardCodeUtil.a(2131709544));
      localButton3.setText(2131693382);
      localButton3.setContentDescription(localButton3.getResources().getString(2131693349));
      localLinearLayout2.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int != 0)
      {
        localLinearLayout3.setVisibility(8);
        localLinearLayout2.setVisibility(8);
      }
      return;
      if (this.jdField_a_of_type_Int == 1008)
      {
        localLinearLayout2.setVisibility(8);
        localLinearLayout1.setVisibility(8);
        localButton3.setText(2131693349);
        localButton3.setContentDescription(getString(2131698617));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      else if ((this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 3) || (this.jdField_a_of_type_Int == 25))
      {
        localLinearLayout2.setVisibility(8);
        localLinearLayout1.setVisibility(8);
        localButton3.setText(2131693349);
        localButton3.setContentDescription(getString(2131698617));
      }
      else
      {
        localButton1.setContentDescription(HardCodeUtil.a(2131709543));
        localButton3.setText(2131693349);
        localButton3.setContentDescription(localButton3.getResources().getString(2131693349));
        if (!CrmUtils.a(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int))
        {
          localLinearLayout2.setVisibility(0);
          localButton2.setText(2131698619);
          localButton2.setContentDescription(localButton2.getResources().getString(2131698619));
        }
        else
        {
          localLinearLayout2.setVisibility(8);
          if ((this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 3) || (this.jdField_a_of_type_Int == 25))
          {
            localLinearLayout2.setVisibility(8);
            localButton3.setContentDescription(getString(2131698618));
          }
        }
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131374654));
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
    if (this.jdField_b_of_type_Int == 1024)
    {
      CrmUtils.a(this, null, this.jdField_a_of_type_JavaLangString, false, -1, true, 2000);
      return;
    }
    if (this.jdField_b_of_type_Int == 1008)
    {
      localObject = new ActivityURIRequest(this, "/pubaccount/detail");
      ((ActivityURIRequest)localObject).extra().putString("uin", this.jdField_a_of_type_JavaLangString);
      ((ActivityURIRequest)localObject).extra().putInt("uintype", 1008);
      ((ActivityURIRequest)localObject).extra().putInt("source", 113);
      ((ActivityURIRequest)localObject).setRequestCode(2000);
      QRoute.startUri((URIRequest)localObject, null);
      return;
    }
    Object localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 46);
    ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 19;
    ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = ContactUtils.a(this.app, this.jdField_a_of_type_JavaLangString);
    label300:
    label366:
    Intent localIntent;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      if ((this.jdField_b_of_type_Int != 1001) && (this.jdField_b_of_type_Int != 10002) && (this.jdField_b_of_type_Int != 10004) && (this.jdField_b_of_type_Int != 1010)) {
        break label675;
      }
      if ((this.jdField_b_of_type_Int == 1001) || (this.jdField_b_of_type_Int == 10002))
      {
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 12;
        localIntent = new Intent(this, NearbyPeopleProfileActivity.class);
        localIntent.putExtra("AllInOne", (Parcelable)localObject);
        if (!Utils.a(this.jdField_a_of_type_JavaLangString, this.app.getCurrentAccountUin())) {
          break label663;
        }
        localIntent.putExtra("param_mode", 2);
      }
      break;
    }
    for (;;)
    {
      startActivity(localIntent);
      return;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 1;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 20;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 86;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 42;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 76;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 22;
      ((ProfileActivity.AllInOne)localObject).jdField_d_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 70;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 47;
      ((ProfileActivity.AllInOne)localObject).e = this.jdField_b_of_type_JavaLangString;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 2;
      break label300;
      if (TextUtils.isEmpty(this.g)) {
        break;
      }
      if (this.g.equals("0"))
      {
        ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 34;
        break label300;
      }
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 1;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_JavaLangString = this.g;
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = ContactUtils.a(this.app, this.g);
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 34;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 57;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 72;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 74;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 27;
      break label300;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 58;
      break label300;
      j();
      return;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 117;
      break label300;
      if (this.jdField_b_of_type_Int != 1010) {
        break label366;
      }
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 13;
      break label366;
      label663:
      localIntent.putExtra("param_mode", 3);
    }
    label675:
    ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject);
  }
  
  private void j()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 80);
    QCallCardInfo localQCallCardInfo = ((QCallCardManager)this.app.getManager(QQManagerFactory.QCALLCARD_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
    Object localObject = (PhoneContactManager)this.app.getManager(QQManagerFactory.CONTACT_MANAGER);
    if ((localObject != null) && (this.jdField_d_of_type_JavaLangString != null)) {}
    for (localObject = ((PhoneContactManager)localObject).c(this.jdField_d_of_type_JavaLangString);; localObject = null)
    {
      if (localQCallCardInfo != null)
      {
        localAllInOne.jdField_h_of_type_JavaLangString = localQCallCardInfo.nickname;
        localAllInOne.jdField_a_of_type_Byte = ((byte)localQCallCardInfo.gender);
        if (QLog.isColorLevel()) {
          QLog.i("startQCallProfileCardActivity ", 2, "QCallCardInfo.uin = " + localQCallCardInfo.uin + "QCallCardInfo.nickname = " + localQCallCardInfo.nickname + "mPhoneNumber = " + this.jdField_d_of_type_JavaLangString + "mFriendUin = " + this.jdField_a_of_type_JavaLangString);
        }
      }
      if (localObject != null) {
        localAllInOne.jdField_h_of_type_JavaLangString = ((PhoneContact)localObject).name;
      }
      if (((localObject != null) || (localQCallCardInfo != null)) && (this.jdField_d_of_type_JavaLangString != null))
      {
        localAllInOne.jdField_a_of_type_Int = 80;
        localObject = new ProfileActivity.CardContactInfo(HardCodeUtil.a(2131709542), this.jdField_d_of_type_JavaLangString, "");
        if (localAllInOne.jdField_a_of_type_JavaUtilArrayList == null)
        {
          localAllInOne.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          localAllInOne.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        ProfileActivity.b(this.app.getApplication().getApplicationContext(), localAllInOne);
        if (this.jdField_a_of_type_Int != 25) {
          break label297;
        }
        ReportController.b(null, "CliOper", "", "", "0X8006251", "0X8006251", 0, 0, "", "", "", "");
      }
      label297:
      while ((this.jdField_a_of_type_Int != 24) && (this.jdField_c_of_type_Int != 2) && (this.jdField_c_of_type_Int != 3)) {
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X8006250", "0X8006250", 0, 0, "", "", "", "");
      return;
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
    this.jdField_a_of_type_ArrayOfInt[0] = 2;
    this.jdField_a_of_type_ArrayOfInt[1] = 3;
    if (this.jdField_a_of_type_Int == 26)
    {
      OpenSDKUtils.a(this.app, paramContext, paramString);
      return;
    }
    localActionSheet.addButton(2131690791);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnDismissListener(new QCallDetailActivity.8(this));
    localActionSheet.setOnButtonClickListener(new QCallDetailActivity.9(this, paramString, localActionSheet));
    localActionSheet.show();
    ReportController.b(this.app, "CliOper", "", "", "0X8005AF6", "0X8005AF6", 0, 0, "", "", "", "");
  }
  
  public void a(String paramString)
  {
    if (isFinishing()) {}
    DiscussionManager localDiscussionManager;
    DiscussionInfo localDiscussionInfo;
    do
    {
      do
      {
        return;
        localDiscussionManager = (DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      } while (localDiscussionManager == null);
      localDiscussionInfo = localDiscussionManager.a(paramString);
    } while ((localDiscussionInfo == null) || (localDiscussionInfo.discussionName == null));
    this.jdField_c_of_type_JavaLangString = localDiscussionInfo.discussionName;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 101, paramString));
    int i = localDiscussionManager.a(paramString);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    paramString = "";
    if (i > 0) {
      paramString = "(" + i + ")";
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  void a(boolean paramBoolean)
  {
    int i = VipFunCallManager.a(this.app, this.jdField_a_of_type_JavaLangString, 6, true, null);
    if ((i == 0) && (paramBoolean) && (this.app != null)) {}
    try
    {
      Object localObject1 = (VipSetFunCallHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER);
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putLong("uin", Long.parseLong(this.jdField_a_of_type_JavaLangString));
      ((Bundle)localObject2).putString("phone", "");
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver, true);
      ((VipSetFunCallHandler)localObject1).a(2, localObject2);
      if (i == 0)
      {
        localObject1 = getResources().getString(2131690793);
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = getResources().getString(2131690793);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QCallDetailActivity", 1, "VipSetFunCallHandler Error:" + localException.getMessage());
        continue;
        String str = VipFunCallManager.b(this.app, i, -1, "name");
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    boolean bool1;
    do
    {
      return;
      boolean bool2 = false;
      bool1 = bool2;
      if (paramIntent != null)
      {
        bool1 = bool2;
        if (paramIntent.getExtras() != null) {
          bool1 = paramIntent.getExtras().getBoolean("isNeedFinish");
        }
      }
    } while (!bool1);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561136);
    paramBundle = getString(2131698629);
    setTitle(paramBundle, paramBundle + getString(2131695899));
    setLeftViewName(2131695421);
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = ((QCallFacade)this.app.getManager(QQManagerFactory.RECENT_CALL_FACADE));
    a(getIntent());
    c();
    f();
    g();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    if ((this.jdField_a_of_type_Int == 0) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.isGetOnlineListRecently()) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.shouldGetOnlineInfo())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getOnlineInfo(this.jdField_a_of_type_JavaLangString, false);
    }
    this.jdField_a_of_type_ArrayOfInt = new int[3];
    if (this.jdField_a_of_type_Int == 25) {
      ReportController.b(null, "CliOper", "", "", "0X800624F", "0X800624F", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      return true;
      if ((this.jdField_a_of_type_Int == 24) || (this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 3)) {
        ReportController.b(null, "CliOper", "", "", "0X800624E", "0X800624E", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void onClick(View paramView)
  {
    this.e = null;
    this.f = null;
    label28:
    int i;
    if (this.jdField_a_of_type_Int == 1006)
    {
      this.f = this.jdField_a_of_type_JavaLangString;
      i = paramView.getId();
      if (2131380726 != i) {
        break label835;
      }
    }
    label835:
    for (;;)
    {
      try
      {
        int j = ((Integer)paramView.getTag()).intValue();
        i = j;
      }
      catch (Exception localException)
      {
        continue;
        finish();
        continue;
        if (this.jdField_a_of_type_Int != 3000) {
          continue;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8004069", "0X8004069", 0, 0, "", "", "", "");
        ReportController.b(this.app, "CliOper", "", "", "0X8004F90", "0X8004F90", 0, 0, "", "", "", "");
        Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
        localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("uintype", this.jdField_a_of_type_Int);
        localIntent.putExtra("uinname", this.jdField_c_of_type_JavaLangString);
        localIntent.putExtra("entrance", 0);
        startActivity(localIntent);
        continue;
        ReportController.b(this.app, "CliOper", "", "", "0X8004F89", "0X8004F89", 0, 0, "", "", "", "");
        continue;
        ReportController.b(this.app, "CliOper", "", this.jdField_a_of_type_JavaLangString, "Two_call", "Two_call_launch", 0, 0, "15", a(this.jdField_a_of_type_Int), "", "");
        ReportController.b(this.app, "CliOper", "", "", "0X8004F8B", "0X8004F8B", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_Int != 1024) {
          continue;
        }
        if (!CrmUtils.a(this.app, this.e, this.jdField_a_of_type_Int)) {
          continue;
        }
        CrmUtils.a(this.app, this, this.jdField_c_of_type_JavaLangString, this.e, "IvrCallDetailEngineFalse");
        ReportController.b(this.app, "CliOper", "", "", "0X80049D6", "0X80049D6", 0, 0, "", "", "", "");
        continue;
        QQToast.a(paramView.getContext(), 2131695692, 1).b(paramView.getContext().getResources().getDimensionPixelSize(2131299166));
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QCallDetailActivity", 2, "Don't support ivr");
        continue;
        ChatActivityUtils.a(this.app, this, this.jdField_a_of_type_Int, this.e, this.jdField_c_of_type_JavaLangString, this.f, false, this.jdField_b_of_type_JavaLangString, true, true, null, "from_internal");
        continue;
        h();
        continue;
        if (this.jdField_a_of_type_Int != 26) {
          continue;
        }
        OpenSDKUtils.a(this.app, this, this.jdField_a_of_type_JavaLangString);
        continue;
        i = ((SVIPHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
        if (i != 2) {
          continue;
        }
        i = 0;
        localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("individuation_url_type", 40304);
        VasWebviewUtil.openQQBrowserWithoutAD(this, IndividuationUrlHelper.a(this, "call", "mvip.gongneng.anroid.individuation.web"), 524288L, localIntent, true, -1);
        ReportController.b(this.app, "CliOper", "", "", "0X8004A1F", "0X8004A1F", 0, 0, "" + i, "", "", "");
        continue;
        if (i != 3) {
          continue;
        }
        i = 2;
        continue;
        switch (this.jdField_a_of_type_Int)
        {
        case 2016: 
        case 56938: 
        default: 
          i();
          ReportController.b(this.app, "CliOper", "", "", "0X8004F8C", "0X8004F8C", 0, 0, "", "", "", "");
          break;
        case 3000: 
          ReportController.b(this.app, "CliOper", "", "", "0X8004F92", "0X8004F92", 0, 0, "", "", "", "");
          a();
          break;
        }
        continue;
      }
      switch (i)
      {
      default: 
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.e = this.jdField_a_of_type_JavaLangString;
        break label28;
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.app != null) {
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver);
    }
    ChatActivityUtils.a();
    if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity$QCalDetailAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity$QCalDetailAdapter.a = null;
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity$QCalDetailAdapter = null;
    }
    ThreadManager.remove(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable = null;
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
  }
  
  public void onResume()
  {
    super.onResume();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity
 * JD-Core Version:    0.7.0.1
 */