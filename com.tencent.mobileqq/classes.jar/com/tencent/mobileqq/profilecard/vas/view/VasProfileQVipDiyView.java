package com.tencent.mobileqq.profilecard.vas.view;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import arkb;
import arkc;
import aryq;
import azpb;
import azrb;
import aztg;
import azyi;
import bacz;
import baed;
import bdla;
import bgvj;
import bgvk;
import bhaa;
import bhzq;
import bmmr;
import bmnd;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vip.diy.ETTextViewPlus;
import com.tencent.mobileqq.vip.diy.TemplateLikeView;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import ykq;
import zdl;

public class VasProfileQVipDiyView
  extends AbsProfileHeaderView
{
  private View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private bmnd jdField_a_of_type_Bmnd;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  private int jdField_b_of_type_Int = -16777216;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new baed(this);
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  
  public VasProfileQVipDiyView(BaseActivity paramBaseActivity, azrb paramazrb)
  {
    super(paramBaseActivity, paramazrb);
    this.jdField_a_of_type_Aryq = new aryq(paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 1);
  }
  
  private void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    if (!arkc.c().a) {}
    while (!bhaa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard.uin)) {
      return;
    }
    bhaa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)LayoutInflater.from(paramActivity).inflate(2131562042, paramViewGroup, false));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.dp2px(350.0F, paramActivity.getResources()), AIOUtils.dp2px(44.0F, paramActivity.getResources()));
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(2, 2131373191);
    localLayoutParams.bottomMargin = AIOUtils.dp2px(4.0F, paramActivity.getResources());
    paramViewGroup.addView(this.jdField_a_of_type_AndroidViewViewGroup, localLayoutParams);
    paramActivity = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375035);
    paramViewGroup = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375034);
    paramActivity.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    paramViewGroup.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qvip", "0X8009E7A", 0, 0, "", "", "", "");
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      paramViewGroup.removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
  }
  
  private void a(ExtensionInfo paramExtensionInfo)
  {
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_diy_avatar_sticker");
    if (localView == null) {
      return;
    }
    if ((paramExtensionInfo != null) && (paramExtensionInfo.isPendantValid()))
    {
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(0);
  }
  
  private void f()
  {
    ykq.e("DIYProfileTemplate.ProfileQVipDiyView", "init head UI");
    this.jdField_a_of_type_AndroidViewView = ((View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_diy_nick_container"));
    Object localObject;
    if ((this.jdField_a_of_type_AndroidViewView instanceof FrameLayout))
    {
      AvatarLayout localAvatarLayout = (AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368826);
      localAvatarLayout.setVisibility(0);
      azpb localazpb = new azpb(1, null);
      if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691169);
        localAvatarLayout.setTag(localazpb);
        localAvatarLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localAvatarLayout.setContentDescription((CharSequence)localObject);
        localAvatarLayout.a(0, localAvatarLayout.findViewById(2131363426), false);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", localAvatarLayout);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", this.jdField_a_of_type_AndroidViewView.findViewById(2131368828));
        localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368659);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", localObject);
        ((ImageView)localObject).setVisibility(8);
        ((ImageView)localObject).setTag(localazpb);
        ((ImageView)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_nick_name"));
      if (!(this.jdField_b_of_type_AndroidViewView instanceof ProfileNameView)) {
        break label331;
      }
      localObject = (ProfileNameView)this.jdField_b_of_type_AndroidViewView;
      ((ProfileNameView)localObject).setVisibility(0);
      ((ProfileNameView)localObject).setClickable(true);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView = ((View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like"));
      if (!(this.jdField_c_of_type_AndroidViewView instanceof TemplateLikeView)) {
        break label377;
      }
      localObject = (TemplateLikeView)this.jdField_c_of_type_AndroidViewView;
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setVisibility(0);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_c_of_type_AndroidViewView);
      ((TemplateLikeView)localObject).setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691168);
      break;
      label331:
      if ((this.jdField_b_of_type_AndroidViewView instanceof ETTextViewPlus))
      {
        localObject = (ETTextViewPlus)this.jdField_b_of_type_AndroidViewView;
        ((ETTextViewPlus)localObject).setTextSize(20.0F);
        ((ETTextViewPlus)localObject).setTextColor(this.jdField_b_of_type_Int);
        ((ETTextViewPlus)localObject).setVisibility(0);
        ((ETTextViewPlus)localObject).setClickable(true);
      }
    }
    label377:
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setVisibility(8);
  }
  
  public void a(azrb paramazrb)
  {
    this.jdField_b_of_type_Int = paramazrb.jdField_a_of_type_Bacz.b();
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    int i = getResources().getDimensionPixelSize(2131297077);
    int j = bhaa.a(getResources());
    j = (int)this.jdField_c_of_type_Float - bhaa.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 18) - i - j;
    i = j;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = j + ImmersiveUtils.getStatusBarHeight(getContext());
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, i);
    addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = new HeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, i);
    addView(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setVisibility(8);
    super.a(paramazrb);
  }
  
  public void a(azrb paramazrb, long paramLong, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteViewV2))
    {
      localObject = (VoteViewV2)localObject;
      long l = paramLong;
      if (paramLong == -1L) {
        l = ((VoteViewV2)localObject).e;
      }
      if ((paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0)) {
        ((VoteViewV2)localObject).a();
      }
      ((VoteViewV2)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteViewV2)localObject).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691139), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void a(azrb paramazrb, boolean paramBoolean)
  {
    ykq.d("DIYProfileTemplate.ProfileQVipDiyView", "自定义资料卡update isNetRet=" + paramBoolean);
    if ((this.jdField_b_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      f();
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      ykq.d("DIYProfileTemplate.ProfileQVipDiyView", "自定义资料卡update 头像");
      a(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      b(paramazrb, false);
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      ykq.d("DIYProfileTemplate.ProfileQVipDiyView", "自定义资料卡update 昵称");
      c(paramazrb);
    }
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      ykq.d("DIYProfileTemplate.ProfileQVipDiyView", "自定义资料卡update 点赞");
      h(paramazrb);
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_Bmnd.e();
  }
  
  public void b(azrb paramazrb, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
    if ((localObject instanceof ImageView))
    {
      localObject = (ImageView)localObject;
      if (!ProfileActivity.AllInOne.g(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        ((ImageView)localObject).setVisibility(4);
        this.jdField_a_of_type_Long = 0L;
      }
    }
    else
    {
      return;
    }
    ThreadManager.post(new VasProfileQVipDiyView.1(this, paramazrb, (ImageView)localObject, paramBoolean), 8, null, true);
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_Bmnd.f();
  }
  
  public void c(azrb paramazrb)
  {
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_nick_name");
    Object localObject2;
    ProfileActivity.AllInOne localAllInOne;
    if ((localObject1 instanceof ProfileNameView))
    {
      localObject1 = (ProfileNameView)localObject1;
      if (localObject1 != null) {
        ((ProfileNameView)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazrb);
      }
      if ((((ProfileNameView)localObject1).a() != null) && (((ProfileNameView)localObject1).a().getVisibility() == 0))
      {
        localObject2 = ((ProfileNameView)localObject1).a();
        localAllInOne = paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
        localObject1 = paramazrb.jdField_a_of_type_Bgvk.a.jdField_a_of_type_JavaLangString;
        if (localObject1 != null)
        {
          paramazrb = (azrb)localObject1;
          if (((String)localObject1).length() != 0) {}
        }
        else
        {
          if (!ProfileActivity.AllInOne.a(localAllInOne)) {
            break label212;
          }
        }
      }
      label212:
      for (paramazrb = String.valueOf(localAllInOne.jdField_a_of_type_JavaLangString);; paramazrb = " ")
      {
        ((ETTextView)localObject2).setText(paramazrb);
        ((ETTextView)localObject2).setTextSize(16.0F);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691145) + ":";
        ((ETTextView)localObject2).setContentDescription((String)localObject1 + paramazrb);
        ((ETTextView)localObject2).setTag(new azpb(88, ((ETTextView)localObject2).getText().toString()));
        ((ETTextView)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ETTextView)localObject2).requestLayout();
        azyi.a((TextView)localObject2);
        return;
      }
    }
    if ((localObject1 instanceof ETTextView))
    {
      localObject2 = (ETTextView)localObject1;
      localAllInOne = paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
      localObject1 = paramazrb.jdField_a_of_type_Bgvk.a.jdField_a_of_type_JavaLangString;
      if (localObject1 != null)
      {
        paramazrb = (azrb)localObject1;
        if (((String)localObject1).length() != 0) {}
      }
      else
      {
        if (!ProfileActivity.AllInOne.a(localAllInOne)) {
          break label382;
        }
      }
      label382:
      for (paramazrb = String.valueOf(localAllInOne.jdField_a_of_type_JavaLangString);; paramazrb = " ")
      {
        ((ETTextView)localObject2).setText(paramazrb);
        ((ETTextView)localObject2).setTextSize(16.0F);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691145) + ":";
        ((ETTextView)localObject2).setContentDescription((String)localObject1 + paramazrb);
        ((ETTextView)localObject2).setTag(new azpb(88, ((ETTextView)localObject2).getText().toString()));
        ((ETTextView)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ETTextView)localObject2).requestLayout();
        azyi.a((TextView)localObject2);
        return;
      }
    }
    super.c(paramazrb);
  }
  
  public void d()
  {
    super.d();
    QLog.e("DIYProfileTemplate.ProfileQVipDiyView", 1, "profileQvipDiyView destroy");
    if (this.jdField_a_of_type_Bmnd != null) {
      this.jdField_a_of_type_Bmnd.c();
    }
    a(this.jdField_b_of_type_AndroidViewViewGroup);
  }
  
  public void e()
  {
    bacz localbacz = this.jdField_a_of_type_Azrb.jdField_a_of_type_Bacz;
    this.jdField_c_of_type_Int = localbacz.a();
    Object localObject = localbacz.a();
    if ((localObject instanceof JSONObject)) {
      this.jdField_a_of_type_Bmnd = bmmr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a((JSONObject)localObject, this.jdField_a_of_type_AndroidWidgetFrameLayout, true, new bhzq(this.jdField_a_of_type_JavaUtilHashMap, localbacz.a()));
    }
    for (;;)
    {
      f();
      a(this.jdField_a_of_type_Azrb, false);
      if (!this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard.uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_AndroidViewViewGroup);
      }
      return;
      if ((localObject instanceof JSONArray)) {
        this.jdField_a_of_type_Bmnd = bmmr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a((JSONArray)localObject, this.jdField_a_of_type_AndroidWidgetFrameLayout, true, new bhzq(this.jdField_a_of_type_JavaUtilHashMap, localbacz.a()));
      } else {
        zdl.a("header is illegal", new Object[0]);
      }
    }
  }
  
  public void h(azrb paramazrb)
  {
    if ((paramazrb.b) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazrb.jdField_a_of_type_JavaLangString))) {}
    Object localObject;
    do
    {
      return;
      localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    } while (!(localObject instanceof VoteViewV2));
    VoteViewV2 localVoteViewV2 = (VoteViewV2)localObject;
    boolean bool1 = a(paramazrb);
    boolean bool2 = TextUtils.equals(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (bool1)
    {
      localVoteViewV2.setVisibility(0);
      int j;
      int i;
      if (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard == null)
      {
        paramazrb = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691216);
        localObject = null;
        j = 0;
        bool1 = false;
        i = 0;
      }
      for (;;)
      {
        localVoteViewV2.a(bool2, bool1, i, j, this.jdField_a_of_type_Aryq, false);
        localVoteViewV2.setTag(localObject);
        localVoteViewV2.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localVoteViewV2.setContentDescription(paramazrb);
        return;
        if (this.jdField_a_of_type_Aryq == null) {
          this.jdField_a_of_type_Aryq = new aryq(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 1);
        }
        i = (int)paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
        j = paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement;
        if (1 == paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {}
        for (bool1 = true;; bool1 = false)
        {
          this.jdField_a_of_type_Aryq.a = paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.getLastPraiseInfoList();
          if (j <= this.jdField_a_of_type_Aryq.a.size()) {
            this.jdField_a_of_type_Aryq.a = this.jdField_a_of_type_Aryq.a.subList(0, j);
          }
          this.jdField_a_of_type_Aryq.a = aztg.a(this.jdField_a_of_type_Aryq.a);
          if (!bool2) {
            break label337;
          }
          localObject = new azpb(10, paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard);
          paramazrb = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691214), new Object[] { String.valueOf(i) });
          break;
        }
        label337:
        localObject = new azpb(10, paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard);
        String str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691127), new Object[] { String.valueOf(i) });
        if (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0) {
          localVoteViewV2.a();
        }
        paramazrb = str;
      }
    }
    localVoteViewV2.setVisibility(4);
  }
  
  public void setProfileArgs(ViewGroup paramViewGroup)
  {
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipDiyView
 * JD-Core Version:    0.7.0.1
 */