package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.List;

public class ProfileShoppingView
  extends ProfileHeaderView
{
  View a;
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  public PhotoViewForShopping a;
  public VoteView a;
  public View b;
  public RelativeLayout b;
  public TextView b;
  public View c;
  public ImageView c;
  public TextView c;
  public boolean c;
  public View d;
  public ImageView d;
  public TextView d;
  public TextView e;
  public TextView f;
  public TextView g;
  public int j = -1;
  public int k = -1;
  public int l = -1;
  public int m = -1;
  public int n = -1;
  
  public ProfileShoppingView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity, paramProfileCardInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    b(paramProfileCardInfo);
    a(paramProfileCardInfo);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) {
      super.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, false);
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject2 = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)localObject2).inflate(2130970964, this, true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370867));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372388));
    Object localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if (localObject1 != null) {}
    for (localObject1 = ((FriendsManager)localObject1).a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);; localObject1 = null)
    {
      if ((localObject1 != null) && (((ExtensionInfo)localObject1).isPendantValid()))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369034));
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370868));
        this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364641));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        ProfileCardTemplate.a(this.jdField_c_of_type_AndroidWidgetImageView, "src", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonFaceBackground");
        Object localObject3 = new DataTag(1, null);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(localObject3);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label1487;
        }
        localObject1 = ((Context)localObject2).getString(2131427397);
        label238:
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject1);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_AndroidWidgetImageView);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", this.jdField_a_of_type_AndroidViewView.findViewById(2131370868));
        super.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_d_of_type_AndroidWidgetImageView.setTag(localObject3);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_d_of_type_AndroidWidgetImageView);
        super.c(paramProfileCardInfo, true);
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372385));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372386));
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sign", this.jdField_b_of_type_AndroidWidgetTextView);
        ProfileCardTemplate.a(this.jdField_b_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemContentColor");
        f(paramProfileCardInfo);
        localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372384);
        ProfileCardTemplate.a((View)localObject1, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "shoppingInfoMaskBackground");
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_space_sign", localObject1);
        ProfileCardTemplate.a((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372387), "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "shoppingUserInfoBackground");
        ProfileCardTemplate.a(this.jdField_d_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "shoppingShopnameText");
        ProfileCardTemplate.a(this.jdField_b_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "shoppingSignColor");
        this.m = getResources().getDimensionPixelSize(2131558669);
        this.n = ProfileCardUtil.a(getResources());
        this.k = getResources().getDimensionPixelSize(2131560774);
        this.j = getResources().getDimensionPixelSize(2131560778);
        this.l = getResources().getDimensionPixelSize(2131560775);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372382);
        int i = (int)((int)(this.jdField_c_of_type_Float / 1.35F) / 1.6F);
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).height = ((int)this.jdField_d_of_type_Float - this.j - ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 28) - this.k - this.l - this.m - this.n - i);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          ((RelativeLayout.LayoutParams)localObject2).height += ImmersiveUtils.a(getContext());
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "rl.height: " + ((RelativeLayout.LayoutParams)localObject2).height);
        }
        if (((RelativeLayout.LayoutParams)localObject2).height <= ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 110))
        {
          int i1 = ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 110);
          int i2 = ((RelativeLayout.LayoutParams)localObject2).height;
          i1 = ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 10) + (i1 - i2);
          localObject3 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject3).topMargin -= i1;
          ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((RelativeLayout.LayoutParams)localObject2).height += i1;
        }
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_b_of_type_AndroidViewView.setFocusable(true);
        this.jdField_b_of_type_AndroidViewView.setFocusableInTouchMode(true);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_space_view", this.jdField_b_of_type_AndroidViewView);
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370146));
        ProfileCardTemplate.a(this.jdField_c_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "shoppingSignColor");
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setClickable(true);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_c_of_type_AndroidWidgetTextView);
        super.i(paramProfileCardInfo);
        this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370872));
        this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370871));
        this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370873));
        this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372392);
        this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372391);
        m(paramProfileCardInfo);
        ProfileCardTemplate.a(this.e, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "shoppingSignColor");
        ProfileCardTemplate.a(this.g, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "shoppingSignColor");
        ProfileCardTemplate.a(this.f, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "shoppingSignColor");
        ProfileCardTemplate.a(this.jdField_d_of_type_AndroidViewView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "shoppingSignColor");
        ProfileCardTemplate.a(this.jdField_c_of_type_AndroidViewView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "shoppingSignColor");
        this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370395));
        localObject1 = (HeartLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370566);
        ((HeartLayout)localObject1).setEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (HeartLayout)localObject1);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView);
        super.g(paramProfileCardInfo);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_personal_like_tip", this.jdField_a_of_type_AndroidViewView.findViewById(2131372362));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372367));
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tag_jueban", this.jdField_a_of_type_AndroidWidgetTextView);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping = ((PhotoViewForShopping)this.jdField_a_of_type_AndroidViewView.findViewById(2131372383));
        this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramProfileCardInfo, i, this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372363));
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", this.jdField_a_of_type_AndroidWidgetLinearLayout);
        localObject1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372353);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_num", localObject1);
        ((TextView)localObject1).setOnClickListener(this);
        localObject1 = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewView.findViewById(2131372350)).a(53).a(true).c(1).e(10).a();
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_increment", localObject1);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_container", this.jdField_a_of_type_AndroidViewView.findViewById(2131372350));
        d(paramProfileCardInfo);
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label1500;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "ProfileShopping", "", "Shop_Ftemplate", "0X8005B9A", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        super.a(paramProfileCardInfo);
        this.jdField_c_of_type_Boolean = true;
        return;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372390));
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372389));
        break;
        label1487:
        localObject1 = ((Context)localObject2).getString(2131427396);
        break label238;
        label1500:
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "ProfileShopping", "", "Shop_Mtemplate", "0X8005B96", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.g(paramProfileCardInfo);
    super.i(paramProfileCardInfo);
    m(paramProfileCardInfo);
    super.e(paramProfileCardInfo);
    super.c(paramProfileCardInfo, false);
    f(paramProfileCardInfo);
  }
  
  public void a(String paramString, int paramInt, List paramList)
  {
    if ((paramString == null) || (paramList == null)) {
      return;
    }
    b(paramString, paramInt);
    a(paramList);
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping.a(true, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramList);
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return true;
    }
    return super.a(paramView, paramMotionEvent);
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "checkTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("shoppingUserInfoBackground", "color");
    localHashMap.put("shoppingInfoMaskBackground", "color");
    localHashMap.put("shoppingShopnameText", "color");
    localHashMap.put("shoppingSignColor", "color");
    super.a(paramProfileCardInfo, localHashMap);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileShoppingView", 2, "shop name:" + paramString);
    }
    if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
      if (paramInt == 0) {
        break label89;
      }
      paramString = getContext().getResources().getDrawable(2130844076);
      if (paramString != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramString, null);
      }
    }
    return;
    label89:
    this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public void f(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sign");
    TextView localTextView;
    if ((localObject1 instanceof TextView))
    {
      localTextView = (TextView)localObject1;
      if ((paramProfileCardInfo != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)) {
        break label51;
      }
      localTextView.setVisibility(4);
    }
    label51:
    SpannableString localSpannableString;
    SpannableStringBuilder localSpannableStringBuilder;
    do
    {
      return;
      localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getRichStatus();
      if ((!ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (localObject1 == null))
      {
        localTextView.setVisibility(4);
        return;
      }
      localSpannableString = ((RichStatus)localObject1).toSpannableString("");
      if (TextUtils.isEmpty(((RichStatus)localObject1).actionText)) {
        break;
      }
      localSpannableStringBuilder = new SpannableStringBuilder(localSpannableString);
    } while (TextUtils.isEmpty(localSpannableStringBuilder));
    localSpannableStringBuilder.insert(0, "[S] ");
    StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    if (localStatusManager != null)
    {
      localObject1 = localStatusManager.a(((RichStatus)localObject1).actionId, 200);
      localObject1 = new StatableBitmapDrawable(getResources(), (Bitmap)localObject1, false, false);
      int i = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
      ((BitmapDrawable)localObject1).setBounds(0, 0, i, i);
      localObject1 = new OffsetableImageSpan((Drawable)localObject1, 0);
      ((OffsetableImageSpan)localObject1).a(-0.1F);
      localSpannableStringBuilder.setSpan(localObject1, 0, "[S]".length(), 17);
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor != 1L) {
        break label534;
      }
      localObject1 = "#686c6f";
      label247:
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor((String)localObject1)), "[S]".length(), localSpannableStringBuilder.toString().indexOf(" ", "[S]".length() + 1), 33);
      localTextView.setText(localSpannableStringBuilder);
      localTextView.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "sign ssb= " + localSpannableStringBuilder + ",textColor = " + localTextView.getCurrentTextColor() + ",indexof=" + localSpannableStringBuilder.toString().indexOf(" ", "[S]".length() + 1));
      }
      label379:
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (ProfileActivity.AllInOne.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
        localTextView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      if (TextUtils.isEmpty(localSpannableString)) {
        break label557;
      }
      localObject1 = localSpannableString.toString();
      label422:
      localTextView.setTag(new DataTag(3, localObject1));
      localTextView.setOnLongClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      localObject1 = new StringBuilder().append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131427367)).append(":");
      if (TextUtils.isEmpty(localSpannableString)) {
        break label564;
      }
    }
    label534:
    label557:
    label564:
    for (paramProfileCardInfo = localSpannableString.toString();; paramProfileCardInfo = "")
    {
      for (;;)
      {
        localTextView.setContentDescription(paramProfileCardInfo);
        return;
        try
        {
          localObject1 = BitmapFactory.decodeResource(getResources(), 2130845328);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
          Object localObject2 = null;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          str = null;
        }
      }
      break;
      String str = "#ffffff";
      break label247;
      localTextView.setText(localSpannableString);
      localTextView.setVisibility(0);
      break label379;
      str = "";
      break label422;
    }
  }
  
  public void m(ProfileCardInfo paramProfileCardInfo)
  {
    int i1 = -1;
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131436533);
      this.g.setVisibility(0);
      this.e.setVisibility(8);
      this.f.setVisibility(8);
      this.g.setPadding(0, 10, 0, 0);
      this.g.setText(paramProfileCardInfo);
      this.g.setContentDescription(paramProfileCardInfo);
      return;
    }
    Object localObject = "";
    Card localCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
    ContactCard localContactCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    int i;
    if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 0) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 1)) {
      i = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte;
    }
    for (;;)
    {
      if (i == 0)
      {
        paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433924);
        label141:
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea sex=" + paramProfileCardInfo);
        }
        if (TextUtils.isEmpty(paramProfileCardInfo)) {
          break label693;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.e.setVisibility(0);
        this.e.setText(paramProfileCardInfo);
        this.e.setContentDescription(paramProfileCardInfo);
        label213:
        localObject = "";
        if (localCard == null) {
          break label721;
        }
        i = localCard.age;
        label229:
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (i > 0)
        {
          paramProfileCardInfo = (ProfileCardInfo)localObject;
          if (!ProfileCardUtil.b()) {
            paramProfileCardInfo = i + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433926);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea age=" + paramProfileCardInfo);
        }
        if (TextUtils.isEmpty(paramProfileCardInfo)) {
          break label737;
        }
        this.g.setVisibility(0);
        this.g.setText(paramProfileCardInfo);
        this.g.setContentDescription(paramProfileCardInfo);
        label337:
        localObject = "";
        if (localCard == null) {
          break label765;
        }
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (!TextUtils.isEmpty(localCard.strCountry))
        {
          paramProfileCardInfo = (ProfileCardInfo)localObject;
          if (!"中国".equals(localCard.strCountry)) {
            paramProfileCardInfo = "" + localCard.strCountry;
          }
        }
        localObject = paramProfileCardInfo;
        if (!TextUtils.isEmpty(localCard.strProvince))
        {
          localObject = paramProfileCardInfo;
          if (!TextUtils.isEmpty(paramProfileCardInfo)) {
            localObject = paramProfileCardInfo + "，";
          }
          localObject = (String)localObject + localCard.strProvince;
        }
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (!TextUtils.isEmpty(localCard.strCity))
        {
          paramProfileCardInfo = (ProfileCardInfo)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramProfileCardInfo = (String)localObject + "，";
          }
          paramProfileCardInfo = paramProfileCardInfo + localCard.strCity;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea place=" + paramProfileCardInfo);
        }
        if (TextUtils.isEmpty(paramProfileCardInfo)) {
          break label973;
        }
        this.f.setVisibility(0);
        this.f.setText(paramProfileCardInfo);
        this.f.setContentDescription(paramProfileCardInfo);
        return;
        if ((localCard != null) && ((localCard.shGender == 0) || (localCard.shGender == 1)))
        {
          i = localCard.shGender;
          break;
        }
        if ((localContactCard == null) || ((localContactCard.bSex != 0) && (localContactCard.bSex != 1))) {
          break label999;
        }
        i = localContactCard.bSex;
        break;
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (i != 1) {
          break label141;
        }
        paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433925);
        break label141;
        label693:
        this.e.setVisibility(8);
        if (this.jdField_c_of_type_AndroidViewView == null) {
          break label213;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        break label213;
        label721:
        i = i1;
        if (localContactCard == null) {
          break label229;
        }
        i = localContactCard.bAge;
        break label229;
        label737:
        this.g.setVisibility(8);
        if (this.jdField_c_of_type_AndroidViewView == null) {
          break label337;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        break label337;
        label765:
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (localContactCard != null)
        {
          paramProfileCardInfo = (ProfileCardInfo)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCountry))
          {
            paramProfileCardInfo = (ProfileCardInfo)localObject;
            if (!"中国".equals(localContactCard.strCountry)) {
              paramProfileCardInfo = "" + localContactCard.strCountry;
            }
          }
          localObject = paramProfileCardInfo;
          if (!TextUtils.isEmpty(localContactCard.strProvince))
          {
            localObject = paramProfileCardInfo;
            if (!TextUtils.isEmpty(paramProfileCardInfo)) {
              localObject = paramProfileCardInfo + "，";
            }
            localObject = (String)localObject + localContactCard.strProvince;
          }
          paramProfileCardInfo = (ProfileCardInfo)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCity))
          {
            paramProfileCardInfo = (ProfileCardInfo)localObject;
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              paramProfileCardInfo = (String)localObject + "，";
            }
            paramProfileCardInfo = paramProfileCardInfo + localContactCard.strCity;
          }
        }
      }
      label973:
      this.f.setVisibility(8);
      if (this.jdField_d_of_type_AndroidViewView == null) {
        break;
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      return;
      label999:
      i = -1;
    }
  }
  
  public void setShoppingBgBlur(boolean paramBoolean)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject = (FrameLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(16908290);
      if ((localObject != null) && (((FrameLayout)localObject).getChildCount() > 0))
      {
        localObject = ((FrameLayout)localObject).getChildAt(0);
        if (localObject != null)
        {
          localObject = ((View)localObject).getBackground();
          if (!paramBoolean) {
            break label66;
          }
        }
      }
    }
    label66:
    for (int i = 255;; i = 0)
    {
      if (localObject != null) {
        ((Drawable)localObject).setAlpha(i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileShoppingView
 * JD-Core Version:    0.7.0.1
 */