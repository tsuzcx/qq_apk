package com.tencent.mobileqq.qcall;

import Override;
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
import antp;
import antq;
import anvi;
import anvk;
import anvx;
import aocy;
import awyz;
import baor;
import baou;
import bapa;
import bapc;
import bapd;
import bape;
import bapf;
import bapg;
import baph;
import bapi;
import bapj;
import bapk;
import bdla;
import bhbx;
import bhnp;
import bibh;
import bibo;
import bibs;
import bkzi;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import nwu;

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
  private antq jdField_a_of_type_Antq = new bapd(this);
  private anvi jdField_a_of_type_Anvi = new bapc(this);
  private bapj jdField_a_of_type_Bapj;
  private bapk jdField_a_of_type_Bapk;
  bibo jdField_a_of_type_Bibo = new bapi(this);
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private Friends jdField_a_of_type_ComTencentMobileqqDataFriends;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  Runnable jdField_a_of_type_JavaLangRunnable = new QCallDetailActivity.3(this);
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
        bdla.b(this.app, "CliOper", "", "", "0X8004E95", "0X8004E95", 0, 0, "", "", "", "");
      }
      this.rightViewImg.setVisibility(8);
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      if ((this.jdField_b_of_type_Int == 0) && (!a(this.jdField_a_of_type_JavaLangString))) {
        this.jdField_b_of_type_Int = 1003;
      }
      this.jdField_d_of_type_Int = paramIntent.getIntExtra("contactID", -1);
    } while (this.jdField_d_of_type_Int != -1);
    paramIntent = (awyz)this.app.getManager(QQManagerFactory.CONTACT_MANAGER);
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
    return ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
  }
  
  private void b()
  {
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this).inflate(2131561049, null));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368063));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371803));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367842));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371875));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371874));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369892));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369824));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364217));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364849));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131374335);
    int i = getResources().getColor(2131166462);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(i);
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131374336);
    ((View)localObject1).setBackgroundColor(i);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    Object localObject3 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368110);
    Object localObject2 = (ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376675);
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, this.jdField_a_of_type_JavaLangString));
      ThreadManager.post(new QCallDetailActivity.4(this), 8, null, true);
      a(true);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(new bape(this));
      if (this.jdField_d_of_type_Int != -1)
      {
        localObject1 = this.app.getEntityManagerFactory().createEntityManager().query(PhoneContact.class, false, "contactID = " + this.jdField_d_of_type_Int, null, null, null, null, null);
        bdla.b(this.app, "CliOper", "", "", "0X8005AF4", "0X8005AF4", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_Int == 26)
        {
          localObject1 = new ArrayList();
          localObject2 = new PhoneContact();
          ((PhoneContact)localObject2).mobileNo = this.jdField_a_of_type_JavaLangString;
          ((PhoneContact)localObject2).type = 0;
          ((PhoneContact)localObject2).label = anvx.a(2131709029);
          ((List)localObject1).add(localObject2);
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131374337).setVisibility(0);
            localObject2 = (NoScrollListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372621);
            ((NoScrollListView)localObject2).setVisibility(0);
            ((NoScrollListView)localObject2).setAdapter(new baou(this, (List)localObject1));
            ((NoScrollListView)localObject2).setOnItemClickListener(new bapf(this));
          }
          return;
        }
      }
      break;
    case 3000: 
      label500:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 101, this.jdField_a_of_type_JavaLangString));
      label556:
      localObject3 = (antp)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      if (localObject3 == null) {}
      break;
    }
    for (i = ((antp)localObject3).a(this.jdField_a_of_type_JavaLangString);; i = 0)
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
      findViewById(2131374330).setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getStrangerFaceDrawable(this.app, 200, this.jdField_a_of_type_JavaLangString, true));
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842118);
      ((TextView)localObject3).setVisibility(0);
      Object localObject4 = ContactUtils.getPhoneContactFaceText(this.jdField_c_of_type_JavaLangString);
      ((TextView)localObject3).setText((CharSequence)localObject4);
      if (ContactUtils.isContainChinese((String)localObject4)) {
        ((TextView)localObject3).setTextSize(0, getResources().getDimension(2131299018));
      }
      for (;;)
      {
        ((ImageView)localObject2).setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698748);
        ((View)localObject1).setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        findViewById(2131374330).setVisibility(8);
        break;
        ((TextView)localObject3).setTextSize(0, getResources().getDimension(2131299019));
      }
      localObject2 = (awyz)this.app.getManager(QQManagerFactory.CONTACT_MANAGER);
      if (localObject2 != null) {}
      for (localObject1 = ((awyz)localObject2).c(this.jdField_d_of_type_JavaLangString);; localObject1 = null)
      {
        if ((localObject2 != null) && (this.jdField_d_of_type_JavaLangString != null)) {
          localObject1 = ((awyz)localObject2).c(this.jdField_d_of_type_JavaLangString);
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
          localObject2 = ((bapa)this.app.getManager(QQManagerFactory.QCALLCARD_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
          if ((localObject2 != null) && (((QCallCardInfo)localObject2).nickname != null)) {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(((QCallCardInfo)localObject2).nickname);
          }
          if (localObject1 == null) {
            break;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
          break;
          this.g = null;
          localObject4 = baor.a(this.app, this.jdField_a_of_type_JavaLangString);
          if (localObject4 != null) {
            this.g = ((PhoneContact)localObject4).uin;
          }
          if (this.g == null)
          {
            ((ImageView)localObject2).setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842118);
            ((TextView)localObject3).setVisibility(0);
            ((TextView)localObject3).setText(ContactUtils.getPhoneContactFaceText(this.jdField_c_of_type_JavaLangString));
          }
          for (;;)
          {
            findViewById(2131374330).setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            ((View)localObject1).setVisibility(8);
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            break;
            ((ImageView)localObject2).setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(baor.a(this.app, this.jdField_a_of_type_JavaLangString));
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
    anvk localanvk = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (QLog.isColorLevel()) {
      QLog.d("QCallDetailActivity", 2, "updateOnlineStatus mFriendUin : " + this.jdField_a_of_type_JavaLangString + " , uinType = " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = localanvk.e(this.jdField_a_of_type_JavaLangString);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Int == 3000)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
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
      if (QLog.isColorLevel()) {
        QLog.d("QCallDetailActivity", 2, "friend.getNetWorkType()：" + this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() + ", friend.detalStatusFlag：" + this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag + ", friend.iTermType：" + this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType);
      }
    } while (ContactUtils.getFriendStatus(this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag, this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType) == 0);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 2) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 3) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 4) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 5) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 1) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 7) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 8))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 2)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698341);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698341));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 3)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698342);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698342));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 4)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698343);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698343));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 5)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698344);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698344));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 7)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131698347));
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698347));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 8)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131698345));
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698345));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 9)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131698346));
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698346));
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130844997);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698348);
      this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698348));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void f()
  {
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131374333);
    Button localButton1 = (Button)localLinearLayout1.findViewById(2131380283);
    localLinearLayout1.setOnClickListener(this);
    localButton1.setTag(Integer.valueOf(2131374333));
    localButton1.setOnClickListener(this);
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131374332);
    Button localButton2 = (Button)localLinearLayout2.findViewById(2131380283);
    localLinearLayout2.setOnClickListener(this);
    localButton2.setTag(Integer.valueOf(2131374332));
    localButton2.setOnClickListener(this);
    LinearLayout localLinearLayout3 = (LinearLayout)findViewById(2131374331);
    Button localButton3 = (Button)localLinearLayout3.findViewById(2131380283);
    localLinearLayout3.setOnClickListener(this);
    localButton3.setTag(Integer.valueOf(2131374331));
    localButton3.setOnClickListener(this);
    localButton1.setText(2131718512);
    if (this.jdField_a_of_type_Int == 3000)
    {
      localButton1.setContentDescription(anvx.a(2131709028));
      localButton3.setText(2131693232);
      localButton3.setContentDescription(localButton3.getResources().getString(2131693199));
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
        localButton3.setText(2131693199);
        localButton3.setContentDescription(getString(2131698337));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      else if ((this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 3) || (this.jdField_a_of_type_Int == 25))
      {
        localLinearLayout2.setVisibility(8);
        localLinearLayout1.setVisibility(8);
        localButton3.setText(2131693199);
        localButton3.setContentDescription(getString(2131698337));
      }
      else
      {
        localButton1.setContentDescription(anvx.a(2131709027));
        localButton3.setText(2131693199);
        localButton3.setContentDescription(localButton3.getResources().getString(2131693199));
        if (!nwu.a(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int))
        {
          localLinearLayout2.setVisibility(0);
          localButton2.setText(2131698339);
          localButton2.setContentDescription(localButton2.getResources().getString(2131698339));
        }
        else
        {
          localLinearLayout2.setVisibility(8);
          if ((this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 3) || (this.jdField_a_of_type_Int == 25))
          {
            localLinearLayout2.setVisibility(8);
            localButton3.setContentDescription(getString(2131698338));
          }
        }
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131374334));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_Bapj = new bapj(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bapj);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Int == 3000)
    {
      bdla.b(this.app, "CliOper", "", "", "0X8004068", "0X8004068", 0, 0, "", "", "", "");
      bdla.b(this.app, "CliOper", "", "", "0X8004F91", "0X8004F91", 0, 0, "", "", "", "");
      ChatActivityUtils.a(this.app, this, this.jdField_a_of_type_Int, this.e, true, true, null, null);
      return;
    }
    bdla.b(this.app, "CliOper", "", this.jdField_a_of_type_JavaLangString, "Two_video_call", "Tvc_msg_info_launch", 0, 0, "", "", "", "");
    bdla.b(this.app, "CliOper", "", "", "0X8004F8A", "0X8004F8A", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_Int == 1024)
    {
      nwu.a(this.app, this, this.jdField_c_of_type_JavaLangString, this.e, "IvrCallDetailEngineFalse");
      return;
    }
    ChatActivityUtils.a(this.app, this, this.jdField_a_of_type_Int, this.e, this.jdField_c_of_type_JavaLangString, this.f, true, this.jdField_b_of_type_JavaLangString, true, true, null, "from_internal");
  }
  
  private void i()
  {
    if (this.jdField_b_of_type_Int == 1024)
    {
      nwu.a(this, null, this.jdField_a_of_type_JavaLangString, false, -1, true, 2000);
      return;
    }
    if (this.jdField_b_of_type_Int == 1008)
    {
      localObject = new Intent(this, AccountDetailActivity.class);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", 1008);
      ((Intent)localObject).putExtra("source", 113);
      startActivityForResult((Intent)localObject, 2000);
      return;
    }
    Object localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 46);
    ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 19;
    ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = ContactUtils.getFriendNick(this.app, this.jdField_a_of_type_JavaLangString);
    label292:
    label358:
    Intent localIntent;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      if ((this.jdField_b_of_type_Int != 1001) && (this.jdField_b_of_type_Int != 10002) && (this.jdField_b_of_type_Int != 10004) && (this.jdField_b_of_type_Int != 1010)) {
        break label667;
      }
      if ((this.jdField_b_of_type_Int == 1001) || (this.jdField_b_of_type_Int == 10002))
      {
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 12;
        localIntent = new Intent(this, NearbyPeopleProfileActivity.class);
        localIntent.putExtra("AllInOne", (Parcelable)localObject);
        if (!bhbx.a(this.jdField_a_of_type_JavaLangString, this.app.getCurrentAccountUin())) {
          break label655;
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
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 20;
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 86;
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 42;
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 76;
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 22;
      ((ProfileActivity.AllInOne)localObject).jdField_d_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 70;
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 47;
      ((ProfileActivity.AllInOne)localObject).e = this.jdField_b_of_type_JavaLangString;
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 2;
      break label292;
      if (TextUtils.isEmpty(this.g)) {
        break;
      }
      if (this.g.equals("0"))
      {
        ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 34;
        break label292;
      }
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 1;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_JavaLangString = this.g;
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = ContactUtils.getFriendNick(this.app, this.g);
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 34;
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 57;
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 72;
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 74;
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 27;
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 58;
      break label292;
      j();
      return;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 117;
      break label292;
      if (this.jdField_b_of_type_Int != 1010) {
        break label358;
      }
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 13;
      break label358;
      label655:
      localIntent.putExtra("param_mode", 3);
    }
    label667:
    ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject);
  }
  
  private void j()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 80);
    QCallCardInfo localQCallCardInfo = ((bapa)this.app.getManager(QQManagerFactory.QCALLCARD_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
    Object localObject = (awyz)this.app.getManager(QQManagerFactory.CONTACT_MANAGER);
    if ((localObject != null) && (this.jdField_d_of_type_JavaLangString != null)) {}
    for (localObject = ((awyz)localObject).c(this.jdField_d_of_type_JavaLangString);; localObject = null)
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
        localObject = new ProfileActivity.CardContactInfo(anvx.a(2131709026), this.jdField_d_of_type_JavaLangString, "");
        if (localAllInOne.jdField_a_of_type_JavaUtilArrayList == null)
        {
          localAllInOne.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          localAllInOne.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        ProfileActivity.b(this.app.getApplication().getApplicationContext(), localAllInOne);
        if (this.jdField_a_of_type_Int != 25) {
          break label297;
        }
        bdla.b(null, "CliOper", "", "", "0X8006251", "0X8006251", 0, 0, "", "", "", "");
      }
      label297:
      while ((this.jdField_a_of_type_Int != 24) && (this.jdField_c_of_type_Int != 2) && (this.jdField_c_of_type_Int != 3)) {
        return;
      }
      bdla.b(null, "CliOper", "", "", "0X8006250", "0X8006250", 0, 0, "", "", "", "");
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
    bkzi localbkzi = bkzi.a(paramContext);
    this.jdField_a_of_type_ArrayOfInt[0] = 2;
    this.jdField_a_of_type_ArrayOfInt[1] = 3;
    if (this.jdField_a_of_type_Int == 26)
    {
      baor.a(this.app, paramContext, paramString);
      return;
    }
    localbkzi.b(2131690689);
    localbkzi.c(2131690697);
    localbkzi.a(new bapg(this));
    localbkzi.a(new baph(this, paramString, localbkzi));
    localbkzi.show();
    bdla.b(this.app, "CliOper", "", "", "0X8005AF6", "0X8005AF6", 0, 0, "", "", "", "");
  }
  
  public void a(String paramString)
  {
    if (isFinishing()) {}
    antp localantp;
    DiscussionInfo localDiscussionInfo;
    do
    {
      do
      {
        return;
        localantp = (antp)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      } while (localantp == null);
      localDiscussionInfo = localantp.a(paramString);
    } while ((localDiscussionInfo == null) || (localDiscussionInfo.discussionName == null));
    this.jdField_c_of_type_JavaLangString = localDiscussionInfo.discussionName;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 101, paramString));
    int i = localantp.a(paramString);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    paramString = "";
    if (i > 0) {
      paramString = "(" + i + ")";
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  void a(boolean paramBoolean)
  {
    int i = bibh.a(this.app, this.jdField_a_of_type_JavaLangString, 6, true, null);
    if ((i == 0) && (paramBoolean) && (this.app != null)) {}
    try
    {
      Object localObject1 = (bibs)this.app.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER);
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putLong("uin", Long.parseLong(this.jdField_a_of_type_JavaLangString));
      ((Bundle)localObject2).putString("phone", "");
      this.app.addObserver(this.jdField_a_of_type_Bibo, true);
      ((bibs)localObject1).a(2, localObject2);
      if (i == 0)
      {
        localObject1 = getResources().getString(2131690691);
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = getResources().getString(2131690691);
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
        String str = bibh.b(this.app, i, -1, "name");
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
    super.setContentView(2131561048);
    paramBundle = getString(2131698349);
    setTitle(paramBundle, paramBundle + getString(2131695656));
    setLeftViewName(2131695178);
    this.jdField_a_of_type_Bapk = ((bapk)this.app.getManager(QQManagerFactory.RECENT_CALL_FACADE));
    a(getIntent());
    c();
    f();
    g();
    addObserver(this.jdField_a_of_type_Anvi);
    addObserver(this.jdField_a_of_type_Antq);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    if ((this.jdField_a_of_type_Int == 0) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.isGetOnlineListRecently()) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.shouldGetOnlineInfo())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getOnlineInfo(this.jdField_a_of_type_JavaLangString, false);
    }
    this.jdField_a_of_type_ArrayOfInt = new int[3];
    if (this.jdField_a_of_type_Int == 25) {
      bdla.b(null, "CliOper", "", "", "0X800624F", "0X800624F", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      return true;
      if ((this.jdField_a_of_type_Int == 24) || (this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 3)) {
        bdla.b(null, "CliOper", "", "", "0X800624E", "0X800624E", 0, 0, "", "", "", "");
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
      if (2131380283 != i) {
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
        bdla.b(this.app, "CliOper", "", "", "0X8004069", "0X8004069", 0, 0, "", "", "", "");
        bdla.b(this.app, "CliOper", "", "", "0X8004F90", "0X8004F90", 0, 0, "", "", "", "");
        Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(this, SplashActivity.class), null);
        localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("uintype", this.jdField_a_of_type_Int);
        localIntent.putExtra("uinname", this.jdField_c_of_type_JavaLangString);
        localIntent.putExtra("entrance", 0);
        startActivity(localIntent);
        continue;
        bdla.b(this.app, "CliOper", "", "", "0X8004F89", "0X8004F89", 0, 0, "", "", "", "");
        continue;
        bdla.b(this.app, "CliOper", "", this.jdField_a_of_type_JavaLangString, "Two_call", "Two_call_launch", 0, 0, "15", a(this.jdField_a_of_type_Int), "", "");
        bdla.b(this.app, "CliOper", "", "", "0X8004F8B", "0X8004F8B", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_Int != 1024) {
          continue;
        }
        if (!nwu.a(this.app, this.e, this.jdField_a_of_type_Int)) {
          continue;
        }
        nwu.a(this.app, this, this.jdField_c_of_type_JavaLangString, this.e, "IvrCallDetailEngineFalse");
        bdla.b(this.app, "CliOper", "", "", "0X80049D6", "0X80049D6", 0, 0, "", "", "", "");
        continue;
        QQToast.a(paramView.getContext(), 2131695451, 1).b(paramView.getContext().getResources().getDimensionPixelSize(2131299080));
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
        baor.a(this.app, this, this.jdField_a_of_type_JavaLangString);
        continue;
        i = ((aocy)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
        if (i != 2) {
          continue;
        }
        i = 0;
        localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("individuation_url_type", 40304);
        VasWebviewUtil.openQQBrowserWithoutAD(this, bhnp.a(this, "call", "mvip.gongneng.anroid.individuation.web"), 524288L, localIntent, true, -1);
        bdla.b(this.app, "CliOper", "", "", "0X8004A1F", "0X8004A1F", 0, 0, "" + i, "", "", "");
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
          bdla.b(this.app, "CliOper", "", "", "0X8004F8C", "0X8004F8C", 0, 0, "", "", "", "");
          break;
        case 3000: 
          bdla.b(this.app, "CliOper", "", "", "0X8004F92", "0X8004F92", 0, 0, "", "", "", "");
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
      this.app.removeObserver(this.jdField_a_of_type_Bibo);
    }
    ChatActivityUtils.a();
    if (this.jdField_a_of_type_Bapj != null)
    {
      this.jdField_a_of_type_Bapj.a = null;
      this.jdField_a_of_type_Bapj = null;
    }
    ThreadManager.remove(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable = null;
    removeObserver(this.jdField_a_of_type_Anvi);
    removeObserver(this.jdField_a_of_type_Antq);
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