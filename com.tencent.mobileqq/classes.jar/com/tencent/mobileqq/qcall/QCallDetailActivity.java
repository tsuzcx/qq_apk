package com.tencent.mobileqq.qcall;

import agud;
import agug;
import aguh;
import aguj;
import aguk;
import aguo;
import agup;
import aguq;
import agur;
import agus;
import agut;
import aguu;
import aguv;
import aguw;
import aguy;
import aguz;
import agva;
import agvb;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.VideoUtils;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.jumplightalk.CLJumpLightalkConfig;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.phone.PhoneNumberInfo;
import com.tencent.mobileqq.phone.PhoneNumberUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.vipav.VipFunCallObserver;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

public class QCallDetailActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private agvb jdField_a_of_type_Agvb;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public PstnSessionInfo a;
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new agus(this);
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new agud(this);
  private Friends jdField_a_of_type_ComTencentMobileqqDataFriends;
  private CLJumpLightalkConfig jdField_a_of_type_ComTencentMobileqqJumplightalkCLJumpLightalkConfig;
  private LightalkShieldHandler jdField_a_of_type_ComTencentMobileqqQcallLightalkShieldHandler;
  private LightalkShieldManager jdField_a_of_type_ComTencentMobileqqQcallLightalkShieldManager;
  private LightalkShieldObserver jdField_a_of_type_ComTencentMobileqqQcallLightalkShieldObserver = new agut(this);
  private LightalkSwitchHanlder jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchHanlder;
  private LightalkSwitchManager jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchManager;
  private PstnCardInfo jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo;
  private PstnManager jdField_a_of_type_ComTencentMobileqqQcallPstnManager;
  private QCallFacade jdField_a_of_type_ComTencentMobileqqQcallQCallFacade;
  VipFunCallObserver jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver = new aguh(this);
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  Runnable jdField_a_of_type_JavaLangRunnable = new aguv(this);
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private PstnManager jdField_b_of_type_ComTencentMobileqqQcallPstnManager;
  private String jdField_b_of_type_JavaLangString;
  private byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  private int jdField_c_of_type_Int;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int = -1;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private String jdField_e_of_type_JavaLangString;
  private int jdField_f_of_type_Int;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString;
  private String g;
  private String h;
  private String i;
  
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
    label169:
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
      this.jdField_d_of_type_Int = paramIntent.getIntExtra("extra_type", 0);
      this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("bind_id");
      this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("phonenum");
      if (this.jdField_c_of_type_Int == 2) {
        ReportController.b(this.app, "CliOper", "", "", "0X8004E95", "0X8004E95", 0, 0, "", "", "", "");
      }
      if (!VideoUtils.a(this.jdField_a_of_type_Int, this.jdField_c_of_type_Int)) {
        break;
      }
      this.rightViewImg.setVisibility(0);
      this.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("sig");
      this.jdField_f_of_type_JavaLangString = paramIntent.getStringExtra("entrance");
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("key_from_lightalk_phone_num", false);
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      if ((this.jdField_b_of_type_Int == 0) && (!a(this.jdField_a_of_type_JavaLangString))) {
        this.jdField_b_of_type_Int = 1003;
      }
      this.jdField_e_of_type_Int = paramIntent.getIntExtra("contactID", -1);
    } while (this.jdField_e_of_type_Int != -1);
    paramIntent = (PhoneContactManager)this.app.getManager(10);
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      paramIntent = paramIntent.a(this.jdField_a_of_type_JavaLangString);
    }
    while (paramIntent != null)
    {
      this.jdField_e_of_type_Int = paramIntent.contactID;
      return;
      this.rightViewImg.setVisibility(8);
      break label169;
      paramIntent = paramIntent.c(this.jdField_a_of_type_JavaLangString);
      continue;
      paramIntent = paramIntent.b(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  private boolean a(String paramString)
  {
    return ((FriendsManager)this.app.getManager(50)).b(paramString);
  }
  
  private void b()
  {
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this).inflate(2130970264, null));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363063));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131362754));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363204));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369885));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369886));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369887));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369888));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369889));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369897));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369883));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369891));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131369880));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369899));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369893));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369896);
    int j = getResources().getColor(2131494150);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(j);
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369890);
    ((View)localObject1).setBackgroundColor(j);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    Object localObject3 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363462);
    Object localObject2 = (ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365686);
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 1, this.jdField_a_of_type_JavaLangString));
      localObject1 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369898);
      ((TextView)localObject1).setContentDescription(getString(2131436957));
      ((TextView)localObject1).setOnClickListener(this);
      ThreadManager.post(new aguw(this), 8, null, true);
      if ((this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 3) || (this.jdField_a_of_type_Int == 25))
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131429231));
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      }
      a(true);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(new aguy(this));
      if (this.jdField_e_of_type_Int != -1)
      {
        localObject1 = this.app.getEntityManagerFactory().createEntityManager().a(PhoneContact.class, false, "contactID = " + this.jdField_e_of_type_Int, null, null, null, null, null);
        ReportController.b(this.app, "CliOper", "", "", "0X8005AF4", "0X8005AF4", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_Int == 26)
        {
          localObject1 = new ArrayList();
          localObject2 = new PhoneContact();
          ((PhoneContact)localObject2).mobileNo = this.jdField_a_of_type_JavaLangString;
          ((PhoneContact)localObject2).type = 0;
          ((PhoneContact)localObject2).label = "电话";
          ((List)localObject1).add(localObject2);
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369894).setVisibility(0);
            localObject2 = (NoScrollListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369895);
            ((NoScrollListView)localObject2).setVisibility(0);
            localObject1 = new PhoneNumberAdapter(this, (List)localObject1);
            ((PhoneNumberAdapter)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqJumplightalkCLJumpLightalkConfig);
            ((NoScrollListView)localObject2).setAdapter((ListAdapter)localObject1);
            ((NoScrollListView)localObject2).setOnItemClickListener(new aguz(this));
          }
          return;
        }
      }
      break;
    case 3000: 
      label693:
      label746:
      if ((this.jdField_a_of_type_ComTencentMobileqqQcallPstnManager == null) || (this.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.a() != 1))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 101, this.jdField_a_of_type_JavaLangString));
        localObject3 = (DiscussionManager)this.app.getManager(52);
        if (localObject3 == null) {
          break label1595;
        }
        j = ((DiscussionManager)localObject3).a(this.jdField_a_of_type_JavaLangString);
      }
      break;
    }
    for (;;)
    {
      if (j > 0)
      {
        localObject3 = "(" + j + ")";
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
      }
      if ((this.jdField_c_of_type_AndroidWidgetRelativeLayout != null) && (localObject1 != null))
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        ((View)localObject1).setVisibility(8);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        ((ImageView)localObject2).setVisibility(8);
        findViewById(2131369879).setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        break;
        localObject3 = FaceDrawable.a(1001, 3);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 1001, this.jdField_a_of_type_JavaLangString, 1, (Drawable)localObject3, (Drawable)localObject3));
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ContactUtils.e(this.app, this.jdField_a_of_type_JavaLangString));
        j = ContactUtils.a(this.app, this.jdField_a_of_type_JavaLangString);
        continue;
      }
      ((ImageView)localObject2).setVisibility(0);
      findViewById(2131369879).setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 200, this.jdField_a_of_type_JavaLangString, true));
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840189);
      ((TextView)localObject3).setVisibility(0);
      Object localObject4 = ContactUtils.c(this.jdField_c_of_type_JavaLangString);
      ((TextView)localObject3).setText((CharSequence)localObject4);
      if (ContactUtils.a((String)localObject4)) {
        ((TextView)localObject3).setTextSize(0, getResources().getDimension(2131558469));
      }
      for (;;)
      {
        ((ImageView)localObject2).setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131436550);
        ((View)localObject1).setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        findViewById(2131369879).setVisibility(8);
        break;
        ((TextView)localObject3).setTextSize(0, getResources().getDimension(2131558470));
      }
      localObject2 = (PhoneContactManager)this.app.getManager(10);
      if (localObject2 != null) {}
      for (localObject1 = ((PhoneContactManager)localObject2).c(this.jdField_e_of_type_JavaLangString);; localObject1 = null)
      {
        if ((localObject2 != null) && (this.jdField_e_of_type_JavaLangString != null)) {
          localObject1 = ((PhoneContactManager)localObject2).c(this.jdField_e_of_type_JavaLangString);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QCallDetailActivity", 2, "getFaceBitmap contact = " + localObject1);
          }
          if (localObject1 != null)
          {
            localObject2 = FaceDrawable.b(this.app, this.jdField_e_of_type_JavaLangString, (byte)3);
            this.jdField_b_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
            if (localObject2 == null) {
              break;
            }
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            break;
          }
          localObject1 = this.app.a(16, this.jdField_a_of_type_JavaLangString, (byte)3, true, 16);
          localObject2 = ((QCallCardManager)this.app.getManager(139)).a(this.jdField_a_of_type_JavaLangString);
          if ((localObject2 != null) && (((QCallCardInfo)localObject2).nickname != null)) {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(((QCallCardInfo)localObject2).nickname);
          }
          if (localObject1 == null) {
            break;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
          break;
          this.i = null;
          localObject4 = OpenSDKUtils.a(this.app, this.jdField_a_of_type_JavaLangString);
          if (localObject4 != null) {
            this.i = ((PhoneContact)localObject4).uin;
          }
          if (this.i == null)
          {
            ((ImageView)localObject2).setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840189);
            ((TextView)localObject3).setVisibility(0);
            ((TextView)localObject3).setText(ContactUtils.c(this.jdField_c_of_type_JavaLangString));
          }
          for (;;)
          {
            findViewById(2131369879).setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            ((View)localObject1).setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            break;
            ((ImageView)localObject2).setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(OpenSDKUtils.a(this.app, this.jdField_a_of_type_JavaLangString));
          }
          break label746;
          localObject1 = null;
          break label693;
        }
      }
      label1595:
      j = 0;
    }
  }
  
  private void d()
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
    if (QLog.isColorLevel()) {
      QLog.d("QCallDetailActivity", 2, "updateOnlineStatus mFriendUin : " + this.jdField_a_of_type_JavaLangString + " , uinType = " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = localFriendsManager.c(this.jdField_a_of_type_JavaLangString);
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
      int j;
      do
      {
        return;
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqDataFriends == null) {
          break;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType == 68104) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType == 65805))
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QCallDetailActivity", 2, "friend.getNetWorkType()：" + this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() + ", friend.detalStatusFlag：" + this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag + ", friend.iTermType：" + this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType);
        }
        j = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag, this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType);
        if ((this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 3) || (this.jdField_a_of_type_Int == 25))
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842435);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(2131429231);
          this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131429231));
          return;
        }
      } while (j == 0);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 2) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 3) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 4) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 1) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 7) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 8))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 2)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(2131436959);
          this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131436959));
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 3)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(2131436960);
          this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131436960));
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 4)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(2131436961);
          this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131436961));
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 7)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131436963));
          this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131436963));
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 8)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131436964));
          this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131436964));
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 9)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131436965));
          this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131436965));
          return;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842422);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131436962);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131436962));
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    } while ((this.jdField_a_of_type_Int != 25) && (this.jdField_a_of_type_Int != 26));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842435);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(2131429231);
    this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131429231));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Int == 3000)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      if (TextUtils.isEmpty(((QCallRecent)localObject2).pstnInfo)) {}
      Object localObject1;
      Object localObject3;
      int j;
      label160:
      do
      {
        do
        {
          return;
          localObject1 = (PhoneContactManager)this.app.getManager(10);
          localObject3 = PstnUtils.a(((QCallRecent)localObject2).pstnInfo);
        } while (localObject3 == null);
        localObject2 = new StringBuilder();
        j = 0;
        if (j < ((ArrayList)localObject3).size())
        {
          PhoneContact localPhoneContact = ((PhoneContactManager)localObject1).b(((AVPhoneUserInfo)((ArrayList)localObject3).get(j)).telInfo.mobile);
          if (localPhoneContact == null) {
            break;
          }
          ((StringBuilder)localObject2).append(localPhoneContact.name).append("、");
          if (j <= 2) {
            break label500;
          }
        }
      } while (((StringBuilder)localObject2).length() <= 0);
      ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
      if (((ArrayList)localObject3).size() > 1)
      {
        localObject1 = getString(2131429267, new Object[] { "" + ((ArrayList)localObject3).size() });
        label234:
        j = getResources().getDisplayMetrics().widthPixels;
        int k = getResources().getDimensionPixelSize(2131559924);
        localObject3 = new Paint(1);
        ((Paint)localObject3).setColor(-1);
        ((Paint)localObject3).setTextSize(getResources().getDimensionPixelSize(2131559920));
        float f1 = ((Paint)localObject3).measureText((String)localObject1);
        this.jdField_f_of_type_AndroidWidgetTextView.setLayoutParams(new LinearLayout.LayoutParams((int)f1 + 1, -2));
        this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        j = j - k - ((int)f1 + 1);
        f1 = ((Paint)localObject3).measureText(((StringBuilder)localObject2).toString());
        if (j <= f1) {
          break label519;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setLayoutParams(new LinearLayout.LayoutParams((int)f1, -2));
      }
      for (;;)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject2).toString());
        return;
        if (TextUtils.isEmpty(((AVPhoneUserInfo)((ArrayList)localObject3).get(j)).telInfo.mobile)) {
          break label160;
        }
        if (((AVPhoneUserInfo)((ArrayList)localObject3).get(j)).telInfo.nationState == 0)
        {
          ((StringBuilder)localObject2).append(((AVPhoneUserInfo)((ArrayList)localObject3).get(j)).telInfo.mobile).append("、");
          break label160;
        }
        ((StringBuilder)localObject2).append(((AVPhoneUserInfo)((ArrayList)localObject3).get(j)).telInfo.nation).append(((AVPhoneUserInfo)((ArrayList)localObject3).get(j)).telInfo.mobile).append("、");
        break label160;
        label500:
        j += 1;
        break;
        localObject1 = getString(2131429268);
        break label234;
        label519:
        this.jdField_e_of_type_AndroidWidgetTextView.setLayoutParams(new LinearLayout.LayoutParams(j, -2));
      }
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void g()
  {
    if ((this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 3) || (this.jdField_a_of_type_Int == 25) || (this.jdField_a_of_type_Int == 26))
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this).inflate(2130970263, null));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setContentDescription(getString(2131429233));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    }
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131369877);
    Button localButton1 = (Button)localLinearLayout1.findViewById(2131365251);
    localLinearLayout1.setOnClickListener(this);
    localButton1.setTag(Integer.valueOf(2131369877));
    localButton1.setOnClickListener(this);
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131369876);
    Button localButton2 = (Button)localLinearLayout2.findViewById(2131365251);
    localLinearLayout2.setOnClickListener(this);
    localButton2.setTag(Integer.valueOf(2131369876));
    localButton2.setOnClickListener(this);
    LinearLayout localLinearLayout3 = (LinearLayout)findViewById(2131369875);
    Button localButton3 = (Button)localLinearLayout3.findViewById(2131365251);
    localLinearLayout3.setOnClickListener(this);
    localButton3.setTag(Integer.valueOf(2131369875));
    localButton3.setOnClickListener(this);
    localButton1.setText(2131433647);
    if (this.jdField_a_of_type_Int == 3000)
    {
      localButton1.setContentDescription("发消息");
      localButton3.setText(2131435798);
      localButton3.setContentDescription("QQ电话");
      localLinearLayout2.setVisibility(8);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 1008)
      {
        localLinearLayout2.setVisibility(8);
        localLinearLayout1.setVisibility(8);
        localButton3.setText("QQ电话");
        localButton3.setContentDescription(getString(2131436976));
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        return;
      }
      if ((this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 3) || (this.jdField_a_of_type_Int == 25))
      {
        localLinearLayout2.setVisibility(8);
        localLinearLayout1.setVisibility(8);
        localButton3.setText(2131435797);
        localButton3.setContentDescription(getString(2131436976));
        return;
      }
      localButton1.setContentDescription("发消息");
      localButton3.setText(2131435797);
      localButton3.setContentDescription("QQ电话");
      if (!CrmUtils.a(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int))
      {
        localLinearLayout2.setVisibility(0);
        localButton2.setText(2131436974);
        localButton2.setContentDescription("视频电话");
        return;
      }
      localLinearLayout2.setVisibility(8);
    } while ((this.jdField_c_of_type_Int != 2) && (this.jdField_c_of_type_Int != 3) && (this.jdField_a_of_type_Int != 25));
    localLinearLayout2.setVisibility(8);
    localButton3.setContentDescription(getString(2131436975));
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131369878));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    if ((this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 3) || (this.jdField_a_of_type_Int == 25) || (this.jdField_a_of_type_Int == 26)) {
      this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_b_of_type_AndroidWidgetLinearLayout);
    }
    this.jdField_a_of_type_Agvb = new agvb(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Agvb);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Int == 3000)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004068", "0X8004068", 0, 0, "", "", "", "");
      ReportController.b(this.app, "CliOper", "", "", "0X8004F91", "0X8004F91", 0, 0, "", "", "", "");
      ChatActivityUtils.a(this.app, this, this.jdField_a_of_type_Int, this.g, true, true, null, null);
      return;
    }
    if ((this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 3) || (this.jdField_a_of_type_Int == 25))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("dstClient", "Lightalk");
      localHashMap.put("bindType", String.valueOf(this.jdField_c_of_type_Int));
      localHashMap.put("bindId", this.jdField_d_of_type_JavaLangString);
      localHashMap.put("extraType", String.valueOf(this.jdField_d_of_type_Int));
      if (this.jdField_a_of_type_ArrayOfByte != null)
      {
        String str = HexUtil.a(this.jdField_a_of_type_ArrayOfByte);
        if (QLog.isColorLevel())
        {
          QLog.d("QCallDetailActivity", 2, "mLightalksig = " + this.jdField_a_of_type_ArrayOfByte);
          QLog.d("QCallDetailActivity", 2, "sig = " + str);
        }
        localHashMap.put("sig", str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QCallDetailActivity", 2, "mBindId = " + this.jdField_d_of_type_JavaLangString + ", mBindType = " + this.jdField_c_of_type_Int + ", mExtraType = " + this.jdField_d_of_type_Int + ", mUinType = " + this.jdField_a_of_type_Int + ", mPhoneNumber = " + this.jdField_e_of_type_JavaLangString);
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8004E96", "0X8004E96", 0, 0, "", "", "", "");
      ChatActivityUtils.a(this.app, this, this.jdField_a_of_type_Int, this.g, this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, true, this.jdField_b_of_type_JavaLangString, true, true, null, "from_internal", localHashMap);
      return;
    }
    ReportController.b(this.app, "CliOper", "", this.jdField_a_of_type_JavaLangString, "Two_video_call", "Tvc_msg_info_launch", 0, 0, "", "", "", "");
    ReportController.b(this.app, "CliOper", "", "", "0X8004F8A", "0X8004F8A", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_Int == 1024)
    {
      CrmUtils.a(this.app, this, this.jdField_c_of_type_JavaLangString, this.g, "IvrCallDetailEngineFalse");
      return;
    }
    ChatActivityUtils.a(this.app, this, this.jdField_a_of_type_Int, this.g, this.jdField_c_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, true, this.jdField_b_of_type_JavaLangString, true, true, null, "from_internal");
  }
  
  private void j()
  {
    if (this.jdField_b_of_type_Int == 1024)
    {
      CrmUtils.a(this, null, this.jdField_a_of_type_JavaLangString, false, -1, true, 2000);
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
    ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = ContactUtils.a(this.app, this.jdField_a_of_type_JavaLangString);
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
        if (!Utils.a(this.jdField_a_of_type_JavaLangString, this.app.getCurrentAccountUin())) {
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
      ((ProfileActivity.AllInOne)localObject).jdField_e_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 2;
      break label292;
      if (TextUtils.isEmpty(this.i)) {
        break;
      }
      if (this.i.equals("0"))
      {
        ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 34;
        break label292;
      }
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 1;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_JavaLangString = this.i;
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = ContactUtils.a(this.app, this.i);
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 34;
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 57;
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 72;
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 93;
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 74;
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 27;
      break label292;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 58;
      break label292;
      k();
      return;
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
  
  private void k()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 80);
    QCallCardInfo localQCallCardInfo = ((QCallCardManager)this.app.getManager(139)).a(this.jdField_a_of_type_JavaLangString);
    Object localObject = (PhoneContactManager)this.app.getManager(10);
    if ((localObject != null) && (this.jdField_e_of_type_JavaLangString != null)) {}
    for (localObject = ((PhoneContactManager)localObject).c(this.jdField_e_of_type_JavaLangString);; localObject = null)
    {
      if (localQCallCardInfo != null)
      {
        localAllInOne.jdField_h_of_type_JavaLangString = localQCallCardInfo.nickname;
        localAllInOne.jdField_a_of_type_Byte = ((byte)localQCallCardInfo.gender);
        if (QLog.isColorLevel()) {
          QLog.i("startQCallProfileCardActivity ", 2, "QCallCardInfo.uin = " + localQCallCardInfo.uin + "QCallCardInfo.nickname = " + localQCallCardInfo.nickname + "mPhoneNumber = " + this.jdField_e_of_type_JavaLangString + "mFriendUin = " + this.jdField_a_of_type_JavaLangString);
        }
      }
      if (localObject != null) {
        localAllInOne.jdField_h_of_type_JavaLangString = ((PhoneContact)localObject).name;
      }
      if (((localObject != null) || (localQCallCardInfo != null)) && (this.jdField_e_of_type_JavaLangString != null))
      {
        localAllInOne.jdField_a_of_type_Int = 80;
        localObject = new ProfileActivity.CardContactInfo("电话", this.jdField_e_of_type_JavaLangString, "");
        if (localAllInOne.jdField_a_of_type_JavaUtilArrayList == null)
        {
          localAllInOne.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          localAllInOne.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        ProfileActivity.b(this.app.getApplication().getApplicationContext(), localAllInOne);
        if (this.jdField_a_of_type_Int != 25) {
          break label293;
        }
        ReportController.b(null, "CliOper", "", "", "0X8006251", "0X8006251", 0, 0, "", "", "", "");
      }
      label293:
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
    ActionSheet localActionSheet = ActionSheet.a(paramContext);
    Object localObject;
    label115:
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqJumplightalkCLJumpLightalkConfig != null) {
      if ((NetworkUtil.d(paramContext)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqJumplightalkCLJumpLightalkConfig.jdField_e_of_type_JavaLangString)))
      {
        localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqJumplightalkCLJumpLightalkConfig.jdField_e_of_type_JavaLangString, 0, 0, null, null, false);
        localActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqJumplightalkCLJumpLightalkConfig.jdField_d_of_type_JavaLangString, (Drawable)localObject, 0);
        this.jdField_a_of_type_ArrayOfInt[0] = 1;
        this.jdField_a_of_type_ArrayOfInt[1] = 2;
        this.jdField_a_of_type_ArrayOfInt[2] = 3;
        ReportController.b(this.app, "CliOper", "", "", "0X8005AF7", "0X8005AF7", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = new PstnSessionInfo();
        QQAppInterface localQQAppInterface = this.app;
        PstnSessionInfo localPstnSessionInfo = this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo;
        if (this.jdField_a_of_type_Int != 56938) {
          break label311;
        }
        localObject = paramString;
        label151:
        this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = PstnUtils.a(localQQAppInterface, localPstnSessionInfo, (String)localObject, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_b_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        if ((this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_b_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_c_of_type_JavaLangString == null) || (this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager.a() != 1)) {
          break label320;
        }
        j = 1;
        label220:
        this.jdField_f_of_type_Int = 0;
        if ((j != 0) && (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo != null))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_call_time <= 0) {
            break label325;
          }
          this.jdField_f_of_type_Int = 1;
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int != 26) {
        break label362;
      }
      OpenSDKUtils.a(this.app, paramContext, paramString, this.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo, 2);
      return;
      localActionSheet.c(this.jdField_a_of_type_ComTencentMobileqqJumplightalkCLJumpLightalkConfig.jdField_d_of_type_JavaLangString);
      break;
      this.jdField_a_of_type_ArrayOfInt[0] = 2;
      this.jdField_a_of_type_ArrayOfInt[1] = 3;
      break label115;
      label311:
      localObject = this.jdField_a_of_type_JavaLangString;
      break label151;
      label320:
      j = 0;
      break label220;
      label325:
      if ((this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager.b() == 1) && (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_try_status == 0)) {
        this.jdField_f_of_type_Int = 2;
      } else {
        this.jdField_f_of_type_Int = 5;
      }
    }
    label362:
    if (j != 0)
    {
      localActionSheet.a(2131438345);
      if (this.jdField_f_of_type_Int == 1)
      {
        localActionSheet.a(getResources().getString(2131438343), getResources().getDrawable(2130840359), 0);
        ReportController.b(this.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 1, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      localActionSheet.c(2131433015);
      localActionSheet.a(new agva(this));
      localActionSheet.a(new agug(this, paramContext, paramString, localActionSheet));
      localActionSheet.show();
      ReportController.b(this.app, "CliOper", "", "", "0X8005AF6", "0X8005AF6", 0, 0, "", "", "", "");
      return;
      if (this.jdField_f_of_type_Int == 2)
      {
        localActionSheet.a(getResources().getString(2131438343), getResources().getDrawable(2130840358), 0);
        ReportController.b(this.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 3, 0, "", "", "", "");
      }
      else
      {
        localActionSheet.a(getResources().getString(2131438343), getResources().getDrawable(2130840357), 0);
        ReportController.b(this.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 2, 0, "", "", "", "");
        continue;
        localActionSheet.b(2131438042);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (isFinishing()) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = (DiscussionManager)this.app.getManager(52);
      } while (localObject1 == null);
      localObject2 = ((DiscussionManager)localObject1).a(paramString);
    } while ((localObject2 == null) || (((DiscussionInfo)localObject2).discussionName == null));
    int j;
    if ((this.jdField_a_of_type_ComTencentMobileqqQcallPstnManager == null) || (this.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.a() != 1))
    {
      this.jdField_c_of_type_JavaLangString = ((DiscussionInfo)localObject2).discussionName;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 101, paramString));
      j = ((DiscussionManager)localObject1).a(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
      if (j <= 0) {
        break label231;
      }
    }
    label231:
    for (paramString = "(" + j + ")";; paramString = "")
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
      return;
      this.jdField_c_of_type_JavaLangString = ContactUtils.e(this.app, paramString);
      j = ContactUtils.a(this.app, paramString);
      localObject2 = FaceDrawable.a(1001, 3);
      localObject1 = FaceDrawable.a(this.app, 1001, this.jdField_a_of_type_JavaLangString, 1, (Drawable)localObject2, null);
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = FaceDrawable.a(this.app, 101, this.jdField_a_of_type_JavaLangString, 1, (Drawable)localObject2, (Drawable)localObject2);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int j = VipFunCallManager.a(this.app, this.jdField_a_of_type_JavaLangString, 6, true, null);
    if ((j == 0) && (paramBoolean) && (this.app != null)) {}
    try
    {
      Object localObject1 = (VipSetFunCallHandler)this.app.a(46);
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putLong("uin", Long.parseLong(this.jdField_a_of_type_JavaLangString));
      ((Bundle)localObject2).putString("phone", "");
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver, true);
      ((VipSetFunCallHandler)localObject1).a(2, localObject2);
      if (j == 0)
      {
        localObject1 = getResources().getString(2131436197);
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = getResources().getString(2131436197);
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
        String str = VipFunCallManager.b(this.app, j, -1, "name");
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    String str;
    do
    {
      do
      {
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
        return;
      } while (paramIntent == null);
      str = paramIntent.getStringExtra("roomId");
    } while (TextUtils.isEmpty(str));
    paramIntent = paramIntent.getStringArrayListExtra("qqPhoneUserList");
    ChatActivityUtils.a(this.app, this, 3000, str, true, true, true, null, paramIntent, 1, 2);
    ReportController.b(this.app, "CliOper", "", "", "0X8006407", "0X8006407", 1, 0, "", "", "", "");
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130970262);
    ThreadManager.post(new aguu(this), 5, null, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    this.rightViewImg.setImageResource(2130839147);
    this.rightViewImg.setOnClickListener(this);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setContentDescription("更多按钮，点击进入");
    paramBundle = getString(2131436948);
    setTitle(paramBundle, paramBundle + getString(2131429526));
    setLeftViewName(2131436949);
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = ((QCallFacade)this.app.getManager(37));
    this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchManager = ((LightalkSwitchManager)this.app.getManager(85));
    this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchHanlder = ((LightalkSwitchHanlder)this.app.a(52));
    this.jdField_a_of_type_ComTencentMobileqqQcallLightalkShieldManager = ((LightalkShieldManager)this.app.getManager(138));
    this.jdField_a_of_type_ComTencentMobileqqQcallPstnManager = ((PstnManager)this.app.getManager(142));
    a(getIntent());
    c();
    g();
    h();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqQcallLightalkShieldObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    if ((this.jdField_a_of_type_Int == 0) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b()) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c(this.jdField_a_of_type_JavaLangString, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqQcallLightalkShieldHandler = ((LightalkShieldHandler)this.app.a(78));
    this.jdField_a_of_type_ComTencentMobileqqQcallLightalkShieldHandler.b();
    this.jdField_a_of_type_ArrayOfInt = new int[3];
    if (this.jdField_a_of_type_Int == 25) {
      ReportController.b(null, "CliOper", "", "", "0X800624F", "0X800624F", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager = ((PstnManager)this.app.getManager(142));
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo = this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager.a(this.app.getCurrentAccountUin());
      return true;
      if ((this.jdField_a_of_type_Int == 24) || (this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 3)) {
        ReportController.b(null, "CliOper", "", "", "0X800624E", "0X800624E", 0, 0, "", "", "", "");
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    try
    {
      f();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onClick(View paramView)
  {
    this.g = null;
    this.jdField_h_of_type_JavaLangString = null;
    int j;
    if (this.jdField_a_of_type_Int == 1006)
    {
      this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      j = paramView.getId();
      if (2131365251 != j) {
        break label2611;
      }
    }
    label297:
    label306:
    label2611:
    for (;;)
    {
      int k;
      try
      {
        k = ((Integer)paramView.getTag()).intValue();
        j = k;
      }
      catch (Exception localException1)
      {
        continue;
        finish();
        return;
      }
      boolean bool4;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      label475:
      Object localObject;
      switch (j)
      {
      default: 
        return;
        this.g = this.jdField_a_of_type_JavaLangString;
        break;
      case 2131363245: 
      case 2131363474: 
        ReportController.b(this.app, "CliOper", "", "", "0X8004E6D", "0X8004E6D", 0, 0, "", "", "", "");
        paramView = (ActionSheet)ActionSheetHelper.a(this, null);
        bool4 = false;
        bool1 = false;
        boolean bool5 = this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchManager.b();
        if (this.jdField_a_of_type_Int == 26)
        {
          PhoneNumberInfo localPhoneNumberInfo = PhoneNumberUtil.a(this.jdField_a_of_type_JavaLangString);
          bool2 = this.jdField_a_of_type_ComTencentMobileqqQcallLightalkShieldManager.a(localPhoneNumberInfo.jdField_a_of_type_JavaLangString + "-" + localPhoneNumberInfo.jdField_c_of_type_JavaLangString);
          j = this.jdField_a_of_type_Int;
          bool3 = false;
          bool1 = false;
        }
        for (;;)
        {
          if (!bool2) {
            break label696;
          }
          k = 2131435297;
          paramView.b(k);
          paramView.b(2131435116);
          paramView.c(2131433015);
          paramView.a(new aguj(this));
          if (QLog.isColorLevel()) {
            QLog.d("QCallDetailActivity", 2, "isFriend:" + bool3 + " isQCallUin:" + bool1 + " isSwitch:" + bool5 + " isSield:" + bool2 + " mFriendUin:" + this.jdField_a_of_type_JavaLangString);
          }
          paramView.a(new aguk(this, bool2, bool3, bool5, j, paramView));
          paramView.show();
          return;
          if ((this.jdField_a_of_type_Int == 0) && (!((FriendsManager)this.app.getManager(50)).b(this.jdField_a_of_type_JavaLangString)))
          {
            j = 1003;
            if ((j != 0) || (!((FriendsManager)this.app.getManager(50)).b(this.jdField_a_of_type_JavaLangString))) {
              break label539;
            }
            bool2 = true;
          }
          try
          {
            for (;;)
            {
              Long.parseLong(this.jdField_a_of_type_JavaLangString);
              if (bool5) {
                break label553;
              }
              bool4 = true;
              bool3 = bool2;
              bool2 = bool4;
              break;
              j = this.jdField_a_of_type_Int;
              break label475;
              bool2 = false;
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              bool1 = true;
            }
          }
        }
        if (bool2)
        {
          localObject = (FriendsManager)this.app.getManager(50);
          if ((localObject == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
            break label2605;
          }
        }
      case 2131369898: 
      case 2131369877: 
      case 2131369876: 
      case 2131369875: 
      case 2131369880: 
      case 2131369891: 
      case 2131369881: 
      case 2131369883: 
      case 2131369886: 
        for (bool3 = ((FriendsManager)localObject).d(this.jdField_a_of_type_JavaLangString);; bool3 = false)
        {
          bool4 = bool2;
          bool2 = bool3;
          bool3 = bool4;
          break label297;
          if (bool1)
          {
            bool4 = this.jdField_a_of_type_ComTencentMobileqqQcallLightalkShieldManager.a(UinUtils.a(this.jdField_a_of_type_JavaLangString));
            bool3 = bool2;
            bool2 = bool4;
            break label297;
          }
          localObject = (ShieldMsgManger)this.app.getManager(15);
          if ((localObject != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
          {
            bool4 = ((ShieldMsgManger)localObject).a(this.jdField_a_of_type_JavaLangString);
            bool3 = bool2;
            bool2 = bool4;
            break label297;
            label696:
            k = 2131435295;
            break label306;
            ReportController.b(this.app, "CliOper", "", this.jdField_a_of_type_JavaLangString, "Two_call", "Tc_msg_dinfo", 0, 0, "", "", "", "");
            if (this.jdField_a_of_type_Int == 3000)
            {
              ReportController.b(this.app, "CliOper", "", "", "0X8004F93", "0X8004F93", 0, 0, "", "", "", "");
              if ((this.jdField_c_of_type_Int != 2) && (this.jdField_c_of_type_Int != 3) && (this.jdField_a_of_type_Int != 25)) {
                break label863;
              }
              this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.b(this.jdField_a_of_type_JavaLangString, 8);
            }
            for (;;)
            {
              this.jdField_a_of_type_Agvb.a.clear();
              this.jdField_a_of_type_Agvb.notifyDataSetChanged();
              return;
              ReportController.b(this.app, "CliOper", "", "", "0X8004F8D", "0X8004F8D", 0, 0, "", "", "", "");
              break;
              label863:
              this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
            }
            if (this.jdField_a_of_type_Int == 3000)
            {
              ReportController.b(this.app, "CliOper", "", "", "0X8004069", "0X8004069", 0, 0, "", "", "", "");
              ReportController.b(this.app, "CliOper", "", "", "0X8004F90", "0X8004F90", 0, 0, "", "", "", "");
            }
            for (;;)
            {
              paramView = AIOUtils.a(new Intent(this, SplashActivity.class), null);
              paramView.putExtra("uin", this.jdField_a_of_type_JavaLangString);
              paramView.putExtra("uintype", this.jdField_a_of_type_Int);
              paramView.putExtra("uinname", this.jdField_c_of_type_JavaLangString);
              paramView.putExtra("entrance", 0);
              startActivity(paramView);
              return;
              ReportController.b(this.app, "CliOper", "", "", "0X8004F89", "0X8004F89", 0, 0, "", "", "", "");
            }
            ReportController.b(this.app, "CliOper", "", this.jdField_a_of_type_JavaLangString, "Two_call", "Two_call_launch", 0, 0, "15", a(this.jdField_a_of_type_Int), "", "");
            ReportController.b(this.app, "CliOper", "", "", "0X8004F8B", "0X8004F8B", 0, 0, "", "", "", "");
            if (this.jdField_a_of_type_Int == 1024)
            {
              if (CrmUtils.a(this.app, this.g, this.jdField_a_of_type_Int))
              {
                CrmUtils.a(this.app, this, this.jdField_c_of_type_JavaLangString, this.g, "IvrCallDetailEngineFalse");
                ReportController.b(this.app, "CliOper", "", "", "0X80049D6", "0X80049D6", 0, 0, "", "", "", "");
                return;
              }
              QQToast.a(paramView.getContext(), 2131429075, 1).b(paramView.getContext().getResources().getDimensionPixelSize(2131558448));
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("QCallDetailActivity", 2, "Don't support ivr");
              return;
            }
            ChatActivityUtils.a(this.app, this, this.jdField_a_of_type_Int, this.g, this.jdField_c_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, false, this.jdField_b_of_type_JavaLangString, true, true, null, "from_internal");
            return;
            if (this.jdField_a_of_type_Int == 3000)
            {
              if (this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager.a() == 1)
              {
                paramView = VideoActionSheet.a(this);
                paramView.a(2131438345);
                paramView.b(2131433828);
                if (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_multi_call_time > 0)
                {
                  this.jdField_f_of_type_Int = 3;
                  paramView.a(getResources().getString(2131438343), getResources().getDrawable(2130840359), 0);
                  ReportController.b(this.app, "CliOper", "", "", "0X80063FE", "0X80063FE", 1, 0, "", "", "", "");
                }
                for (;;)
                {
                  paramView.c(2131433015);
                  paramView.a(new aguo(this));
                  paramView.a(new agup(this, paramView));
                  paramView.show();
                  return;
                  if ((this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager.c() == 1) && (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_multi_try_status == 0))
                  {
                    this.jdField_f_of_type_Int = 4;
                    paramView.a(getResources().getString(2131438343), getResources().getDrawable(2130840358), 0);
                    ReportController.b(this.app, "CliOper", "", "", "0X80063FE", "0X80063FE", 3, 0, "", "", "", "");
                  }
                  else
                  {
                    this.jdField_f_of_type_Int = 5;
                    paramView.a(getResources().getString(2131438343), getResources().getDrawable(2130840357), 0);
                    ReportController.b(this.app, "CliOper", "", "", "0X80063FE", "0X80063FE", 2, 0, "", "", "", "");
                  }
                }
              }
              i();
              return;
            }
            this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = new PstnSessionInfo();
            this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = PstnUtils.a(this.app, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
            if ((this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_b_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_c_of_type_JavaLangString != null) && (this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager.a() == 1))
            {
              j = 1;
              this.jdField_f_of_type_Int = 0;
              if (j != 0)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_call_time <= 0) {
                  break label1802;
                }
                this.jdField_f_of_type_Int = 1;
              }
              label1657:
              if (j == 0) {
                break label1984;
              }
              this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
              paramView = VideoActionSheet.a(this);
              paramView.a(2131438345);
              paramView.b(2131433828);
              if (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_call_time <= 0) {
                break label1839;
              }
              this.jdField_f_of_type_Int = 1;
              paramView.a(getResources().getString(2131438343), getResources().getDrawable(2130840359), 0);
              ReportController.b(this.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 1, 0, "", "", "", "");
            }
            for (;;)
            {
              paramView.c(2131433015);
              paramView.a(new aguq(this));
              paramView.a(new agur(this, paramView));
              paramView.show();
              return;
              j = 0;
              break;
              if ((this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager.b() == 1) && (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_try_status == 0))
              {
                this.jdField_f_of_type_Int = 2;
                break label1657;
              }
              this.jdField_f_of_type_Int = 5;
              break label1657;
              if ((this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager.b() == 1) && (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_try_status == 0))
              {
                this.jdField_f_of_type_Int = 2;
                paramView.a(getResources().getString(2131438343), getResources().getDrawable(2130840358), 0);
                ReportController.b(this.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 3, 0, "", "", "", "");
              }
              else
              {
                this.jdField_f_of_type_Int = 5;
                paramView.a(getResources().getString(2131438343), getResources().getDrawable(2130840357), 0);
                ReportController.b(this.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 2, 0, "", "", "", "");
              }
            }
            label1984:
            i();
            return;
            if (this.jdField_a_of_type_Int == 26)
            {
              this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = new PstnSessionInfo();
              this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = PstnUtils.a(this.app, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
              if ((this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_b_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_c_of_type_JavaLangString != null) && (this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager.a() == 1))
              {
                j = 1;
                this.jdField_f_of_type_Int = 0;
                if (j != 0)
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_call_time <= 0) {
                    break label2116;
                  }
                  this.jdField_f_of_type_Int = 1;
                }
              }
              for (;;)
              {
                OpenSDKUtils.a(this.app, this, this.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo, 2);
                return;
                j = 0;
                break;
                label2116:
                if ((this.jdField_b_of_type_ComTencentMobileqqQcallPstnManager.b() == 1) && (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_try_status == 0)) {
                  this.jdField_f_of_type_Int = 2;
                } else {
                  this.jdField_f_of_type_Int = 5;
                }
              }
            }
            paramView = PstnUtils.a(this.app, this.g, 3000);
            localObject = new ArrayList();
            if (paramView != null)
            {
              j = 0;
              while (j < paramView.size())
              {
                ((ArrayList)localObject).add(((AVPhoneUserInfo)paramView.get(j)).telInfo.mobile);
                j += 1;
              }
            }
            ChatActivityUtils.a(this.app, this, this.jdField_a_of_type_Int, this.g, true, true, true, null, (ArrayList)localObject, 1, 2);
            ReportController.b(this.app, "CliOper", "", "", "0X8006407", "0X8006407", 1, 0, "", "", "", "");
            return;
            j = ((SVIPHandler)this.app.a(13)).j();
            if (j == 2) {
              j = 0;
            }
            for (;;)
            {
              paramView = new Intent(this, QQBrowserActivity.class);
              paramView.putExtra("individuation_url_type", 40304);
              VasWebviewUtil.openQQBrowserWithoutAD(this, IndividuationUrlHelper.a(this, "call", "mvip.gongneng.anroid.individuation.web"), 524288L, paramView, true, -1);
              ReportController.b(this.app, "CliOper", "", "", "0X8004A1F", "0X8004A1F", 0, 0, "" + j, "", "", "");
              return;
              if (j == 3)
              {
                j = 2;
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d("QCallDetailActivity", 2, "qq_call_lightalk_download onclick");
                }
                paramView = new Intent(this, QQBrowserActivity.class);
                paramView.putExtra("url", IndividuationUrlHelper.a("callDownloadUrl"));
                ReportController.b(this.app, "CliOper", "", "", "0X8004E97", "0X8004E97", 0, 0, "", "", "", "");
                startActivity(paramView);
                return;
                switch (this.jdField_a_of_type_Int)
                {
                case 2016: 
                case 56938: 
                default: 
                  j();
                  ReportController.b(this.app, "CliOper", "", "", "0X8004F8C", "0X8004F8C", 0, 0, "", "", "", "");
                  return;
                }
                if (this.jdField_a_of_type_Boolean) {
                  break;
                }
                ReportController.b(this.app, "CliOper", "", "", "0X8004F92", "0X8004F92", 0, 0, "", "", "", "");
                a();
                return;
              }
            }
          }
          bool3 = bool2;
          bool2 = bool4;
          break label297;
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.app != null) {
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver);
    }
    ChatActivityUtils.a();
    if (this.jdField_a_of_type_Agvb != null)
    {
      this.jdField_a_of_type_Agvb.a = null;
      this.jdField_a_of_type_Agvb = null;
    }
    ThreadManager.remove(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable = null;
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqQcallLightalkShieldObserver);
  }
  
  protected void onResume()
  {
    super.onResume();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity
 * JD-Core Version:    0.7.0.1
 */