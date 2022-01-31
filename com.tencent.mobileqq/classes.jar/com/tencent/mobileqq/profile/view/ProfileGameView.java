package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ProfileGameView
  extends ProfileHeaderView
{
  private float jdField_a_of_type_Float;
  View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public TextView a;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  private VoteView jdField_a_of_type_ComTencentMobileqqWidgetVoteView;
  private TextView b;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private float e;
  private float f;
  
  public ProfileGameView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
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
    Object localObject = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)localObject).inflate(2130971020, this, true);
    ProfileCardTemplate.a((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372548), "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "gameHeadInfoBackground");
    getResources().getDisplayMetrics();
    int i = getResources().getDimensionPixelSize(2131558565);
    int j = getResources().getDimensionPixelSize(2131558575);
    this.e = (this.jdField_c_of_type_Float - (i + j * 3));
    this.jdField_a_of_type_Float = (70.0F * this.jdField_b_of_type_Float);
    this.f = (this.jdField_c_of_type_Float - 103.0F * this.jdField_b_of_type_Float - j * 2);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369101));
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371013));
    ProfileCardTemplate.a(this.jdField_d_of_type_AndroidWidgetImageView, "src", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonFaceBackground");
    DataTag localDataTag = new DataTag(1, null);
    this.jdField_c_of_type_AndroidWidgetImageView.setTag(localDataTag);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {}
    for (localObject = ((Context)localObject).getString(2131427397);; localObject = ((Context)localObject).getString(2131427396))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_c_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", this.jdField_a_of_type_AndroidViewView.findViewById(2131371013));
      super.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364689));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(localDataTag);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_a_of_type_AndroidWidgetImageView);
      super.c(paramProfileCardInfo, true);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370266));
      ProfileCardTemplate.a(this.jdField_b_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "gameNickNameColor");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_b_of_type_AndroidWidgetTextView);
      super.i(paramProfileCardInfo);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372550));
      ProfileCardTemplate.a(this.jdField_c_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "gameAddressColor");
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", this.jdField_c_of_type_AndroidWidgetTextView);
      super.c(paramProfileCardInfo);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372545));
      ProfileCardTemplate.a(this.jdField_d_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "gameSignColor");
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sign", this.jdField_d_of_type_AndroidWidgetTextView);
      f(paramProfileCardInfo);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370545));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370086));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView);
      super.g(paramProfileCardInfo);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_personal_like_tip", this.jdField_a_of_type_AndroidViewView.findViewById(2131372546));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372551));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tag_jueban", this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372547));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", this.jdField_a_of_type_AndroidWidgetLinearLayout);
      localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372537);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_num", localObject);
      ((TextView)localObject).setOnClickListener(this);
      localObject = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewView.findViewById(2131372534)).a(53).a(true).c(1).e(10).a();
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_increment", localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_container", this.jdField_a_of_type_AndroidViewView.findViewById(2131372534));
      d(paramProfileCardInfo);
      super.a(paramProfileCardInfo);
      super.h(paramProfileCardInfo);
      return;
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.g(paramProfileCardInfo);
    super.i(paramProfileCardInfo);
    super.c(paramProfileCardInfo);
    super.e(paramProfileCardInfo);
    f(paramProfileCardInfo);
    super.c(paramProfileCardInfo, false);
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "checkTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("commonFaceBackground", "drawable");
    localHashMap.put("gameHeadInfoBackground", "color");
    localHashMap.put("gameNickNameColor", "color");
    localHashMap.put("gameAddressColor", "color");
    localHashMap.put("gameSignColor", "color");
    localHashMap.put("gamePlayNowColor", "color");
    localHashMap.put("gameMoreColor", "color");
    localHashMap.put("gameMoreGameDrawableRight", "drawable");
    localHashMap.put("gamePlayTitleColor", "color");
    localHashMap.put("gameIconBorder", "drawable");
    super.a(paramProfileCardInfo, localHashMap);
  }
  
  public void f(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sign");
    TextView localTextView;
    if (((localObject1 instanceof TextView)) && (paramProfileCardInfo != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null))
    {
      localTextView = (TextView)localObject1;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
        localTextView.setVisibility(4);
      }
    }
    else
    {
      return;
    }
    localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getRichStatus();
    if ((!ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (localObject1 == null))
    {
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130843146, 0);
        localTextView.setText("编辑个性签名 ");
        localTextView.setVisibility(0);
        localTextView.setTag(new DataTag(3, ""));
        localTextView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        localTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131427367));
        return;
      }
      localTextView.setVisibility(4);
      return;
    }
    SpannableString localSpannableString = ((RichStatus)localObject1).toSpannableString("");
    if (!TextUtils.isEmpty(((RichStatus)localObject1).actionText))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localSpannableString);
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
        localTextView.setText(localSpannableStringBuilder + " ");
        localTextView.setVisibility(0);
        label331:
        if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) || (ProfileActivity.AllInOne.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
          localTextView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a != 0) {
          break label542;
        }
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130843146, 0);
        label381:
        if (TextUtils.isEmpty(localSpannableString)) {
          break label566;
        }
        localObject1 = localSpannableString.toString();
        label395:
        localTextView.setTag(new DataTag(3, localObject1));
        localTextView.setOnLongClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        localObject1 = new StringBuilder().append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131427367)).append(":");
        if (TextUtils.isEmpty(localSpannableString)) {
          break label573;
        }
      }
    }
    label542:
    label566:
    label573:
    for (paramProfileCardInfo = localSpannableString.toString();; paramProfileCardInfo = "")
    {
      for (;;)
      {
        localTextView.setContentDescription(paramProfileCardInfo);
        return;
        try
        {
          localObject1 = BitmapFactory.decodeResource(getResources(), 2130845537);
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
      localTextView.setText(localSpannableString + " ");
      localTextView.setVisibility(0);
      break label331;
      if (!ProfileActivity.AllInOne.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break label381;
      }
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130843147, 0);
      break label381;
      String str = "";
      break label395;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileGameView
 * JD-Core Version:    0.7.0.1
 */