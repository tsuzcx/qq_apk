package com.tencent.mobileqq.qcall;

import aepi;
import alrk;
import alrl;
import altm;
import alto;
import alud;
import amca;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aufv;
import awgf;
import awgg;
import awzw;
import awzz;
import axaf;
import axah;
import axai;
import axaj;
import axak;
import axal;
import axam;
import axan;
import axao;
import axap;
import azqs;
import bdbk;
import bdeu;
import bdgc;
import bdtg;
import becr;
import becy;
import bedc;
import bhuf;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import ndv;

public class QCallDetailActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private alrl jdField_a_of_type_Alrl = new axai(this);
  private altm jdField_a_of_type_Altm = new axah(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private axao jdField_a_of_type_Axao;
  private axap jdField_a_of_type_Axap;
  becy jdField_a_of_type_Becy = new axan(this);
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
        azqs.b(this.app, "CliOper", "", "", "0X8004E95", "0X8004E95", 0, 0, "", "", "", "");
      }
      this.rightViewImg.setVisibility(8);
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      if ((this.jdField_b_of_type_Int == 0) && (!a(this.jdField_a_of_type_JavaLangString))) {
        this.jdField_b_of_type_Int = 1003;
      }
      this.jdField_d_of_type_Int = paramIntent.getIntExtra("contactID", -1);
    } while (this.jdField_d_of_type_Int != -1);
    paramIntent = (aufv)this.app.getManager(11);
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
    return ((alto)this.app.getManager(51)).b(paramString);
  }
  
  private void b()
  {
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this).inflate(2131560873, null));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367516));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131370977));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367297));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371050));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371049));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369250));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369181));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363876));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364479));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373489);
    int i = getResources().getColor(2131166353);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(i);
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373490);
    ((View)localObject1).setBackgroundColor(i);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    Object localObject3 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367560);
    Object localObject2 = (ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131375793);
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(bdbk.a(this.app, 1, this.jdField_a_of_type_JavaLangString));
      ThreadManager.post(new QCallDetailActivity.4(this), 8, null, true);
      a(true);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(new axaj(this));
      if (this.jdField_d_of_type_Int != -1)
      {
        localObject1 = this.app.getEntityManagerFactory().createEntityManager().a(PhoneContact.class, false, "contactID = " + this.jdField_d_of_type_Int, null, null, null, null, null);
        azqs.b(this.app, "CliOper", "", "", "0X8005AF4", "0X8005AF4", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_Int == 26)
        {
          localObject1 = new ArrayList();
          localObject2 = new PhoneContact();
          ((PhoneContact)localObject2).mobileNo = this.jdField_a_of_type_JavaLangString;
          ((PhoneContact)localObject2).type = 0;
          ((PhoneContact)localObject2).label = alud.a(2131709965);
          ((List)localObject1).add(localObject2);
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373491).setVisibility(0);
            localObject2 = (NoScrollListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371773);
            ((NoScrollListView)localObject2).setVisibility(0);
            ((NoScrollListView)localObject2).setAdapter(new awzz(this, (List)localObject1));
            ((NoScrollListView)localObject2).setOnItemClickListener(new axak(this));
          }
          return;
        }
      }
      break;
    case 3000: 
      label500:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(bdbk.a(this.app, 101, this.jdField_a_of_type_JavaLangString));
      label556:
      localObject3 = (alrk)this.app.getManager(53);
      if (localObject3 == null) {}
      break;
    }
    for (i = ((alrk)localObject3).a(this.jdField_a_of_type_JavaLangString);; i = 0)
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
      findViewById(2131373484).setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(bdbk.a(this.app, 200, this.jdField_a_of_type_JavaLangString, true));
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841744);
      ((TextView)localObject3).setVisibility(0);
      Object localObject4 = bdgc.b(this.jdField_c_of_type_JavaLangString);
      ((TextView)localObject3).setText((CharSequence)localObject4);
      if (bdgc.a((String)localObject4)) {
        ((TextView)localObject3).setTextSize(0, getResources().getDimension(2131298853));
      }
      for (;;)
      {
        ((ImageView)localObject2).setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131699673);
        ((View)localObject1).setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        findViewById(2131373484).setVisibility(8);
        break;
        ((TextView)localObject3).setTextSize(0, getResources().getDimension(2131298854));
      }
      localObject2 = (aufv)this.app.getManager(11);
      if (localObject2 != null) {}
      for (localObject1 = ((aufv)localObject2).c(this.jdField_d_of_type_JavaLangString);; localObject1 = null)
      {
        if ((localObject2 != null) && (this.jdField_d_of_type_JavaLangString != null)) {
          localObject1 = ((aufv)localObject2).c(this.jdField_d_of_type_JavaLangString);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QCallDetailActivity", 2, "getFaceBitmap contact = " + localObject1);
          }
          if (localObject1 != null)
          {
            localObject2 = bdbk.b(this.app, this.jdField_d_of_type_JavaLangString, (byte)3);
            this.jdField_b_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
            if (localObject2 == null) {
              break;
            }
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            break;
          }
          localObject1 = this.app.a(16, this.jdField_a_of_type_JavaLangString, (byte)3, true, 16);
          localObject2 = ((axaf)this.app.getManager(140)).a(this.jdField_a_of_type_JavaLangString);
          if ((localObject2 != null) && (((QCallCardInfo)localObject2).nickname != null)) {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(((QCallCardInfo)localObject2).nickname);
          }
          if (localObject1 == null) {
            break;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
          break;
          this.g = null;
          localObject4 = awzw.a(this.app, this.jdField_a_of_type_JavaLangString);
          if (localObject4 != null) {
            this.g = ((PhoneContact)localObject4).uin;
          }
          if (this.g == null)
          {
            ((ImageView)localObject2).setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841744);
            ((TextView)localObject3).setVisibility(0);
            ((TextView)localObject3).setText(bdgc.b(this.jdField_c_of_type_JavaLangString));
          }
          for (;;)
          {
            findViewById(2131373484).setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            ((View)localObject1).setVisibility(8);
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            break;
            ((ImageView)localObject2).setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(awzw.a(this.app, this.jdField_a_of_type_JavaLangString));
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
    alto localalto = (alto)this.app.getManager(51);
    if (QLog.isColorLevel()) {
      QLog.d("QCallDetailActivity", 2, "updateOnlineStatus mFriendUin : " + this.jdField_a_of_type_JavaLangString + " , uinType = " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = localalto.e(this.jdField_a_of_type_JavaLangString);
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
    } while (bdgc.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag, this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType) == 0);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 2) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 3) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 4) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 1) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 7) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 8))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 2)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698993);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698993));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 3)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698994);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698994));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 4)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698995);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698995));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 7)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131698998));
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698998));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 8)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131698996));
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698996));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 9)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131698997));
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698997));
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130844633);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131698999);
      this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131698999));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void f()
  {
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131373487);
    Button localButton1 = (Button)localLinearLayout1.findViewById(2131379107);
    localLinearLayout1.setOnClickListener(this);
    localButton1.setTag(Integer.valueOf(2131373487));
    localButton1.setOnClickListener(this);
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131373486);
    Button localButton2 = (Button)localLinearLayout2.findViewById(2131379107);
    localLinearLayout2.setOnClickListener(this);
    localButton2.setTag(Integer.valueOf(2131373486));
    localButton2.setOnClickListener(this);
    LinearLayout localLinearLayout3 = (LinearLayout)findViewById(2131373485);
    Button localButton3 = (Button)localLinearLayout3.findViewById(2131379107);
    localLinearLayout3.setOnClickListener(this);
    localButton3.setTag(Integer.valueOf(2131373485));
    localButton3.setOnClickListener(this);
    localButton1.setText(2131719767);
    if (this.jdField_a_of_type_Int == 3000)
    {
      localButton1.setContentDescription(alud.a(2131709964));
      localButton3.setText(2131693566);
      localButton3.setContentDescription(localButton3.getResources().getString(2131693561));
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
        localButton3.setText(2131693561);
        localButton3.setContentDescription(getString(2131698966));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      else if ((this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 3) || (this.jdField_a_of_type_Int == 25))
      {
        localLinearLayout2.setVisibility(8);
        localLinearLayout1.setVisibility(8);
        localButton3.setText(2131693561);
        localButton3.setContentDescription(getString(2131698966));
      }
      else
      {
        localButton1.setContentDescription(alud.a(2131709963));
        localButton3.setText(2131693561);
        localButton3.setContentDescription(localButton3.getResources().getString(2131693561));
        if (!ndv.a(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int))
        {
          localLinearLayout2.setVisibility(0);
          localButton2.setText(2131698969);
          localButton2.setContentDescription(localButton2.getResources().getString(2131698969));
        }
        else
        {
          localLinearLayout2.setVisibility(8);
          if ((this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 3) || (this.jdField_a_of_type_Int == 25))
          {
            localLinearLayout2.setVisibility(8);
            localButton3.setContentDescription(getString(2131698967));
          }
        }
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131373488));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_Axao = new axao(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Axao);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Int == 3000)
    {
      azqs.b(this.app, "CliOper", "", "", "0X8004068", "0X8004068", 0, 0, "", "", "", "");
      azqs.b(this.app, "CliOper", "", "", "0X8004F91", "0X8004F91", 0, 0, "", "", "", "");
      ChatActivityUtils.a(this.app, this, this.jdField_a_of_type_Int, this.e, true, true, null, null);
      return;
    }
    azqs.b(this.app, "CliOper", "", this.jdField_a_of_type_JavaLangString, "Two_video_call", "Tvc_msg_info_launch", 0, 0, "", "", "", "");
    azqs.b(this.app, "CliOper", "", "", "0X8004F8A", "0X8004F8A", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_Int == 1024)
    {
      ndv.a(this.app, this, this.jdField_c_of_type_JavaLangString, this.e, "IvrCallDetailEngineFalse");
      return;
    }
    ChatActivityUtils.a(this.app, this, this.jdField_a_of_type_Int, this.e, this.jdField_c_of_type_JavaLangString, this.f, true, this.jdField_b_of_type_JavaLangString, true, true, null, "from_internal");
  }
  
  private void i()
  {
    if (this.jdField_b_of_type_Int == 1024)
    {
      ndv.a(this, null, this.jdField_a_of_type_JavaLangString, false, -1, true, 2000);
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
    ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = bdgc.a(this.app, this.jdField_a_of_type_JavaLangString);
    label284:
    label350:
    Intent localIntent;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      if ((this.jdField_b_of_type_Int != 1001) && (this.jdField_b_of_type_Int != 10002) && (this.jdField_b_of_type_Int != 10004) && (this.jdField_b_of_type_Int != 1010)) {
        break label650;
      }
      if ((this.jdField_b_of_type_Int == 1001) || (this.jdField_b_of_type_Int == 10002))
      {
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 12;
        localIntent = new Intent(this, NearbyPeopleProfileActivity.class);
        localIntent.putExtra("AllInOne", (Parcelable)localObject);
        if (!bdeu.a(this.jdField_a_of_type_JavaLangString, this.app.getCurrentAccountUin())) {
          break label638;
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
      break label284;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 20;
      break label284;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 86;
      break label284;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 42;
      break label284;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 76;
      break label284;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 22;
      ((ProfileActivity.AllInOne)localObject).jdField_d_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      break label284;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 70;
      break label284;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 47;
      ((ProfileActivity.AllInOne)localObject).e = this.jdField_b_of_type_JavaLangString;
      break label284;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 2;
      break label284;
      if (TextUtils.isEmpty(this.g)) {
        break;
      }
      if (this.g.equals("0"))
      {
        ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 34;
        break label284;
      }
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 1;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_JavaLangString = this.g;
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = bdgc.a(this.app, this.g);
      break label284;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 34;
      break label284;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 57;
      break label284;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 72;
      break label284;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 74;
      break label284;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 27;
      break label284;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 58;
      break label284;
      j();
      return;
      if (this.jdField_b_of_type_Int != 1010) {
        break label350;
      }
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 13;
      break label350;
      label638:
      localIntent.putExtra("param_mode", 3);
    }
    label650:
    ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject);
  }
  
  private void j()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 80);
    QCallCardInfo localQCallCardInfo = ((axaf)this.app.getManager(140)).a(this.jdField_a_of_type_JavaLangString);
    Object localObject = (aufv)this.app.getManager(11);
    if ((localObject != null) && (this.jdField_d_of_type_JavaLangString != null)) {}
    for (localObject = ((aufv)localObject).c(this.jdField_d_of_type_JavaLangString);; localObject = null)
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
        localObject = new ProfileActivity.CardContactInfo(alud.a(2131709962), this.jdField_d_of_type_JavaLangString, "");
        if (localAllInOne.jdField_a_of_type_JavaUtilArrayList == null)
        {
          localAllInOne.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          localAllInOne.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        ProfileActivity.b(this.app.getApplication().getApplicationContext(), localAllInOne);
        if (this.jdField_a_of_type_Int != 25) {
          break label296;
        }
        azqs.b(null, "CliOper", "", "", "0X8006251", "0X8006251", 0, 0, "", "", "", "");
      }
      label296:
      while ((this.jdField_a_of_type_Int != 24) && (this.jdField_c_of_type_Int != 2) && (this.jdField_c_of_type_Int != 3)) {
        return;
      }
      azqs.b(null, "CliOper", "", "", "0X8006250", "0X8006250", 0, 0, "", "", "", "");
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
    bhuf localbhuf = bhuf.a(paramContext);
    this.jdField_a_of_type_ArrayOfInt[0] = 2;
    this.jdField_a_of_type_ArrayOfInt[1] = 3;
    if (this.jdField_a_of_type_Int == 26)
    {
      awzw.a(this.app, paramContext, paramString);
      return;
    }
    localbhuf.b(2131690635);
    localbhuf.c(2131690648);
    localbhuf.a(new axal(this));
    localbhuf.a(new axam(this, paramString, localbhuf));
    localbhuf.show();
    azqs.b(this.app, "CliOper", "", "", "0X8005AF6", "0X8005AF6", 0, 0, "", "", "", "");
  }
  
  public void a(String paramString)
  {
    if (isFinishing()) {}
    alrk localalrk;
    DiscussionInfo localDiscussionInfo;
    do
    {
      do
      {
        return;
        localalrk = (alrk)this.app.getManager(53);
      } while (localalrk == null);
      localDiscussionInfo = localalrk.a(paramString);
    } while ((localDiscussionInfo == null) || (localDiscussionInfo.discussionName == null));
    this.jdField_c_of_type_JavaLangString = localDiscussionInfo.discussionName;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(bdbk.a(this.app, 101, paramString));
    int i = localalrk.a(paramString);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    paramString = "";
    if (i > 0) {
      paramString = "(" + i + ")";
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  void a(boolean paramBoolean)
  {
    int i = becr.a(this.app, this.jdField_a_of_type_JavaLangString, 6, true, null);
    if ((i == 0) && (paramBoolean) && (this.app != null)) {}
    try
    {
      Object localObject1 = (bedc)this.app.a(46);
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putLong("uin", Long.parseLong(this.jdField_a_of_type_JavaLangString));
      ((Bundle)localObject2).putString("phone", "");
      this.app.addObserver(this.jdField_a_of_type_Becy, true);
      ((bedc)localObject1).a(2, localObject2);
      if (i == 0)
      {
        localObject1 = getResources().getString(2131690639);
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = getResources().getString(2131690639);
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
        String str = becr.b(this.app, i, -1, "name");
      }
    }
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
    super.setContentView(2131560872);
    paramBundle = getString(2131699009);
    setTitle(paramBundle, paramBundle + getString(2131696375));
    setLeftViewName(2131695904);
    this.jdField_a_of_type_Axap = ((axap)this.app.getManager(38));
    a(getIntent());
    c();
    f();
    g();
    addObserver(this.jdField_a_of_type_Altm);
    addObserver(this.jdField_a_of_type_Alrl);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    if ((this.jdField_a_of_type_Int == 0) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b()) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c(this.jdField_a_of_type_JavaLangString, false);
    }
    this.jdField_a_of_type_ArrayOfInt = new int[3];
    if (this.jdField_a_of_type_Int == 25) {
      azqs.b(null, "CliOper", "", "", "0X800624F", "0X800624F", 0, 0, "", "", "", "");
    }
    while ((this.jdField_a_of_type_Int != 24) && (this.jdField_c_of_type_Int != 2) && (this.jdField_c_of_type_Int != 3)) {
      return true;
    }
    azqs.b(null, "CliOper", "", "", "0X800624E", "0X800624E", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void onClick(View paramView)
  {
    this.e = null;
    this.f = null;
    int i;
    if (this.jdField_a_of_type_Int == 1006)
    {
      this.f = this.jdField_a_of_type_JavaLangString;
      i = paramView.getId();
      if (2131379107 != i) {
        break label799;
      }
    }
    label799:
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
        return;
      }
      switch (i)
      {
      default: 
        return;
        this.e = this.jdField_a_of_type_JavaLangString;
        break;
      case 2131368624: 
      case 2131373487: 
        if (this.jdField_a_of_type_Int == 3000)
        {
          azqs.b(this.app, "CliOper", "", "", "0X8004069", "0X8004069", 0, 0, "", "", "", "");
          azqs.b(this.app, "CliOper", "", "", "0X8004F90", "0X8004F90", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          paramView = aepi.a(new Intent(this, SplashActivity.class), null);
          paramView.putExtra("uin", this.jdField_a_of_type_JavaLangString);
          paramView.putExtra("uintype", this.jdField_a_of_type_Int);
          paramView.putExtra("uinname", this.jdField_c_of_type_JavaLangString);
          paramView.putExtra("entrance", 0);
          startActivity(paramView);
          return;
          azqs.b(this.app, "CliOper", "", "", "0X8004F89", "0X8004F89", 0, 0, "", "", "", "");
        }
      case 2131373486: 
        azqs.b(this.app, "CliOper", "", this.jdField_a_of_type_JavaLangString, "Two_call", "Two_call_launch", 0, 0, "15", a(this.jdField_a_of_type_Int), "", "");
        azqs.b(this.app, "CliOper", "", "", "0X8004F8B", "0X8004F8B", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_Int == 1024)
        {
          if (ndv.a(this.app, this.e, this.jdField_a_of_type_Int))
          {
            ndv.a(this.app, this, this.jdField_c_of_type_JavaLangString, this.e, "IvrCallDetailEngineFalse");
            azqs.b(this.app, "CliOper", "", "", "0X80049D6", "0X80049D6", 0, 0, "", "", "", "");
            return;
          }
          QQToast.a(paramView.getContext(), 2131696172, 1).b(paramView.getContext().getResources().getDimensionPixelSize(2131298914));
          if (QLog.isColorLevel()) {
            QLog.d("QCallDetailActivity", 2, "Don't support ivr");
          }
        }
        else
        {
          ChatActivityUtils.a(this.app, this, this.jdField_a_of_type_Int, this.e, this.jdField_c_of_type_JavaLangString, this.f, false, this.jdField_b_of_type_JavaLangString, true, true, null, "from_internal");
          return;
        }
        break;
      case 2131373485: 
        h();
        return;
      case 2131363876: 
        if (this.jdField_a_of_type_Int == 26)
        {
          awzw.a(this.app, this, this.jdField_a_of_type_JavaLangString);
          return;
        }
        break;
      case 2131369181: 
        i = ((amca)this.app.a(13)).g();
        if (i == 2) {
          i = 0;
        }
      case 2131369250: 
      case 2131371049: 
        for (;;)
        {
          paramView = new Intent(this, QQBrowserActivity.class);
          paramView.putExtra("individuation_url_type", 40304);
          VasWebviewUtil.openQQBrowserWithoutAD(this, bdtg.a(this, "call", "mvip.gongneng.anroid.individuation.web"), 524288L, paramView, true, -1);
          azqs.b(this.app, "CliOper", "", "", "0X8004A1F", "0X8004A1F", 0, 0, "" + i, "", "", "");
          return;
          if (i == 3)
          {
            i = 2;
            continue;
            switch (this.jdField_a_of_type_Int)
            {
            case 2016: 
            case 56938: 
            default: 
              i();
              azqs.b(this.app, "CliOper", "", "", "0X8004F8C", "0X8004F8C", 0, 0, "", "", "", "");
              return;
            }
            azqs.b(this.app, "CliOper", "", "", "0X8004F92", "0X8004F92", 0, 0, "", "", "", "");
            a();
            return;
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.app != null) {
      this.app.removeObserver(this.jdField_a_of_type_Becy);
    }
    ChatActivityUtils.a();
    if (this.jdField_a_of_type_Axao != null)
    {
      this.jdField_a_of_type_Axao.a = null;
      this.jdField_a_of_type_Axao = null;
    }
    ThreadManager.remove(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable = null;
    removeObserver(this.jdField_a_of_type_Altm);
    removeObserver(this.jdField_a_of_type_Alrl);
  }
  
  public void onResume()
  {
    super.onResume();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity
 * JD-Core Version:    0.7.0.1
 */