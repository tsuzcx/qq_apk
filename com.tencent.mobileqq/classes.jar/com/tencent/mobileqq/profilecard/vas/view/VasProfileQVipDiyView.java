package com.tencent.mobileqq.profilecard.vas.view;

import afur;
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
import aqxj;
import aqxk;
import arlo;
import azde;
import azfe;
import azhk;
import azml;
import azph;
import azql;
import bcst;
import bgdf;
import bgdg;
import bghy;
import bhig;
import bmtr;
import bmuf;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.TroopInfo;
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
import yqp;
import zkb;

public class VasProfileQVipDiyView
  extends AbsProfileHeaderView
{
  private View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private bmuf jdField_a_of_type_Bmuf;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  private int jdField_b_of_type_Int = -16777216;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new azql(this);
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  
  public VasProfileQVipDiyView(BaseActivity paramBaseActivity, azfe paramazfe)
  {
    super(paramBaseActivity, paramazfe);
    this.jdField_a_of_type_Arlo = new arlo(paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 1);
  }
  
  private void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    if (!aqxk.c().a) {}
    while (!bghy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqDataCard.uin)) {
      return;
    }
    bghy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)LayoutInflater.from(paramActivity).inflate(2131562062, paramViewGroup, false));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(afur.a(350.0F, paramActivity.getResources()), afur.a(44.0F, paramActivity.getResources()));
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(2, 2131372897);
    localLayoutParams.bottomMargin = afur.a(4.0F, paramActivity.getResources());
    paramViewGroup.addView(this.jdField_a_of_type_AndroidViewViewGroup, localLayoutParams);
    paramActivity = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374892);
    paramViewGroup = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374891);
    paramActivity.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    paramViewGroup.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qvip", "0X8009E7A", 0, 0, "", "", "", "");
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
    yqp.e("DIYProfileTemplate.ProfileQVipDiyView", "init head UI");
    this.jdField_a_of_type_AndroidViewView = ((View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_diy_nick_container"));
    Object localObject;
    if ((this.jdField_a_of_type_AndroidViewView instanceof FrameLayout))
    {
      AvatarLayout localAvatarLayout = (AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368570);
      localAvatarLayout.setVisibility(0);
      azde localazde = new azde(1, null);
      if (this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691044);
        localAvatarLayout.setTag(localazde);
        localAvatarLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localAvatarLayout.setContentDescription((CharSequence)localObject);
        localAvatarLayout.a(0, localAvatarLayout.findViewById(2131363303), false);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", localAvatarLayout);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", this.jdField_a_of_type_AndroidViewView.findViewById(2131368572));
        localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368403);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", localObject);
        ((ImageView)localObject).setVisibility(8);
        ((ImageView)localObject).setTag(localazde);
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691043);
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
  
  public void a(azfe paramazfe)
  {
    this.jdField_b_of_type_Int = paramazfe.jdField_a_of_type_Azph.b();
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    int i = getResources().getDimensionPixelSize(2131297009);
    int j = bghy.a(getResources());
    j = (int)this.jdField_c_of_type_Float - bghy.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 18) - i - j;
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
    super.a(paramazfe);
  }
  
  public void a(azfe paramazfe, long paramLong, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteViewV2))
    {
      localObject = (VoteViewV2)localObject;
      long l = paramLong;
      if (paramLong == -1L) {
        l = ((VoteViewV2)localObject).e;
      }
      if ((paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0)) {
        ((VoteViewV2)localObject).a();
      }
      ((VoteViewV2)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteViewV2)localObject).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691014), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void a(azfe paramazfe, boolean paramBoolean)
  {
    yqp.d("DIYProfileTemplate.ProfileQVipDiyView", "自定义资料卡update isNetRet=" + paramBoolean);
    if ((this.jdField_b_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      f();
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      yqp.d("DIYProfileTemplate.ProfileQVipDiyView", "自定义资料卡update 头像");
      a(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      b(paramazfe, false);
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      yqp.d("DIYProfileTemplate.ProfileQVipDiyView", "自定义资料卡update 昵称");
      c(paramazfe);
    }
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      yqp.d("DIYProfileTemplate.ProfileQVipDiyView", "自定义资料卡update 点赞");
      g(paramazfe);
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_Bmuf.e();
  }
  
  public void b(azfe paramazfe, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
    if ((localObject instanceof ImageView))
    {
      localObject = (ImageView)localObject;
      if (!ProfileActivity.AllInOne.g(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        ((ImageView)localObject).setVisibility(4);
        this.jdField_a_of_type_Long = 0L;
      }
    }
    else
    {
      return;
    }
    ThreadManager.post(new VasProfileQVipDiyView.1(this, paramazfe, (ImageView)localObject, paramBoolean), 8, null, true);
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_Bmuf.f();
  }
  
  public void c(azfe paramazfe)
  {
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_nick_name");
    Object localObject2;
    ProfileActivity.AllInOne localAllInOne;
    if ((localObject1 instanceof ProfileNameView))
    {
      localObject1 = (ProfileNameView)localObject1;
      if (localObject1 != null) {
        ((ProfileNameView)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazfe);
      }
      if ((((ProfileNameView)localObject1).a() != null) && (((ProfileNameView)localObject1).a().getVisibility() == 0))
      {
        localObject2 = ((ProfileNameView)localObject1).a();
        localAllInOne = paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
        localObject1 = paramazfe.jdField_a_of_type_Bgdg.a.jdField_a_of_type_JavaLangString;
        if (localObject1 != null)
        {
          paramazfe = (azfe)localObject1;
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
      for (paramazfe = String.valueOf(localAllInOne.jdField_a_of_type_JavaLangString);; paramazfe = " ")
      {
        ((ETTextView)localObject2).setText(paramazfe);
        ((ETTextView)localObject2).setTextSize(16.0F);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691020) + ":";
        ((ETTextView)localObject2).setContentDescription((String)localObject1 + paramazfe);
        ((ETTextView)localObject2).setTag(new azde(88, ((ETTextView)localObject2).getText().toString()));
        ((ETTextView)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ETTextView)localObject2).requestLayout();
        azml.a((TextView)localObject2);
        return;
      }
    }
    if ((localObject1 instanceof ETTextView))
    {
      localObject2 = (ETTextView)localObject1;
      localAllInOne = paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
      localObject1 = paramazfe.jdField_a_of_type_Bgdg.a.jdField_a_of_type_JavaLangString;
      if (localObject1 != null)
      {
        paramazfe = (azfe)localObject1;
        if (((String)localObject1).length() != 0) {}
      }
      else
      {
        if (!ProfileActivity.AllInOne.a(localAllInOne)) {
          break label382;
        }
      }
      label382:
      for (paramazfe = String.valueOf(localAllInOne.jdField_a_of_type_JavaLangString);; paramazfe = " ")
      {
        ((ETTextView)localObject2).setText(paramazfe);
        ((ETTextView)localObject2).setTextSize(16.0F);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691020) + ":";
        ((ETTextView)localObject2).setContentDescription((String)localObject1 + paramazfe);
        ((ETTextView)localObject2).setTag(new azde(88, ((ETTextView)localObject2).getText().toString()));
        ((ETTextView)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ETTextView)localObject2).requestLayout();
        azml.a((TextView)localObject2);
        return;
      }
    }
    super.c(paramazfe);
  }
  
  public void d()
  {
    super.d();
    QLog.e("DIYProfileTemplate.ProfileQVipDiyView", 1, "profileQvipDiyView destroy");
    if (this.jdField_a_of_type_Bmuf != null) {
      this.jdField_a_of_type_Bmuf.c();
    }
    a(this.jdField_b_of_type_AndroidViewViewGroup);
  }
  
  public void e()
  {
    azph localazph = this.jdField_a_of_type_Azfe.jdField_a_of_type_Azph;
    this.jdField_c_of_type_Int = localazph.a();
    Object localObject = localazph.a();
    if ((localObject instanceof JSONObject)) {
      this.jdField_a_of_type_Bmuf = bmtr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a((JSONObject)localObject, this.jdField_a_of_type_AndroidWidgetFrameLayout, true, new bhig(this.jdField_a_of_type_JavaUtilHashMap, localazph.a()));
    }
    for (;;)
    {
      f();
      a(this.jdField_a_of_type_Azfe, false);
      if (!this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqDataCard.uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_AndroidViewViewGroup);
      }
      return;
      if ((localObject instanceof JSONArray)) {
        this.jdField_a_of_type_Bmuf = bmtr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a((JSONArray)localObject, this.jdField_a_of_type_AndroidWidgetFrameLayout, true, new bhig(this.jdField_a_of_type_JavaUtilHashMap, localazph.a()));
      } else {
        zkb.a("header is illegal", new Object[0]);
      }
    }
  }
  
  public void g(azfe paramazfe)
  {
    if ((paramazfe.b) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazfe.jdField_a_of_type_JavaLangString))) {}
    Object localObject;
    do
    {
      return;
      localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    } while (!(localObject instanceof VoteViewV2));
    VoteViewV2 localVoteViewV2 = (VoteViewV2)localObject;
    boolean bool1 = a(paramazfe);
    boolean bool2 = TextUtils.equals(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (bool1)
    {
      localVoteViewV2.setVisibility(0);
      int j;
      int i;
      if (paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard == null)
      {
        paramazfe = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691091);
        localObject = null;
        j = 0;
        bool1 = false;
        i = 0;
      }
      for (;;)
      {
        localVoteViewV2.a(bool2, bool1, i, j, this.jdField_a_of_type_Arlo, false);
        localVoteViewV2.setTag(localObject);
        localVoteViewV2.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localVoteViewV2.setContentDescription(paramazfe);
        return;
        if (this.jdField_a_of_type_Arlo == null) {
          this.jdField_a_of_type_Arlo = new arlo(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 1);
        }
        i = (int)paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
        j = paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement;
        if (1 == paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {}
        for (bool1 = true;; bool1 = false)
        {
          this.jdField_a_of_type_Arlo.a = paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.getLastPraiseInfoList();
          if (j <= this.jdField_a_of_type_Arlo.a.size()) {
            this.jdField_a_of_type_Arlo.a = this.jdField_a_of_type_Arlo.a.subList(0, j);
          }
          this.jdField_a_of_type_Arlo.a = azhk.a(this.jdField_a_of_type_Arlo.a);
          if (!bool2) {
            break label337;
          }
          localObject = new azde(10, paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard);
          paramazfe = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691089), new Object[] { String.valueOf(i) });
          break;
        }
        label337:
        localObject = new azde(10, paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard);
        String str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691002), new Object[] { String.valueOf(i) });
        if (paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0) {
          localVoteViewV2.a();
        }
        paramazfe = str;
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