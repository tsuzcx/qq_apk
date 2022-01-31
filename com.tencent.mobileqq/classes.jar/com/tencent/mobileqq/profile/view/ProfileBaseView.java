package com.tencent.mobileqq.profile.view;

import agvl;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.like.PraiseConfigHelper;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PullToZoomHeaderListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class ProfileBaseView
  extends ProfileHeaderView
{
  public float a;
  View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  private RandomCoverView jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView;
  private VoteViewV2 jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2;
  private PullToZoomHeaderListView jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private View jdField_g_of_type_AndroidViewView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private View jdField_h_of_type_AndroidViewView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  
  public ProfileBaseView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo, PullToZoomHeaderListView paramPullToZoomHeaderListView, TextView paramTextView, boolean paramBoolean)
  {
    super(paramBaseActivity, paramProfileCardInfo);
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = paramPullToZoomHeaderListView;
    this.jdField_h_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper = new NewVoteAnimHelper(paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 1);
    a(paramProfileCardInfo);
  }
  
  private void m(ProfileCardInfo paramProfileCardInfo)
  {
    if (Utils.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      this.jdField_h_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_h_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) {
      c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, false);
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo)
  {
    Context localContext = getContext();
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(localContext).inflate(2130971018, this, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView = ((RandomCoverView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370261));
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setHeaderImage(this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a());
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setHeaderMask(this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a());
    Object localObject2 = new DataTag(17, null);
    boolean bool;
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localObject1 = localContext.getString(2131427400);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setTag(localObject2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setContentDescription((CharSequence)localObject1);
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getCoverData(this.i);
        localObject2 = (String)localObject1[0];
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.jdField_b_of_type_JavaLangString = ((String)localObject2);
          this.i = ((Integer)localObject1[1]).intValue();
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      String str2 = this.jdField_b_of_type_JavaLangString;
      if (this.i != 0) {
        break label992;
      }
      bool = true;
      label221:
      ((RandomCoverView)localObject1).a((QQAppInterface)localObject2, str1, str2, bool, true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzonecover", this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView);
      this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131372530);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369101));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject2 = new DataTag(1, null);
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label997;
      }
    }
    label992:
    label997:
    for (Object localObject1 = localContext.getString(2131427397);; localObject1 = localContext.getString(2131427396))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setTag(localObject2);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_c_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", this.jdField_b_of_type_AndroidViewView.findViewById(2131370264));
      a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_personal_like_tip", this.jdField_b_of_type_AndroidViewView.findViewById(2131372546));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131364689));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(localObject2);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_a_of_type_AndroidWidgetImageView);
      c(paramProfileCardInfo, true);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370266));
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_f_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131372542);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetTextView.setClickable(true);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_troop_member_rank_title", this.jdField_a_of_type_AndroidViewView);
      }
      i(paramProfileCardInfo);
      this.jdField_h_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131365229);
      m(paramProfileCardInfo);
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372545));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sign", this.jdField_g_of_type_AndroidWidgetTextView);
      b(paramProfileCardInfo);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2 = ((VoteViewV2)this.jdField_b_of_type_AndroidViewView.findViewById(2131370545));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370086));
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2);
      g(paramProfileCardInfo);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131372531));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372533));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372532));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372541));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372544));
      b(paramProfileCardInfo, true);
      this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131372534);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372537));
      this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131372535);
      this.jdField_f_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131372538);
      this.jdField_g_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131372539);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372540));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_num", this.jdField_d_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_container", this.jdField_d_of_type_AndroidViewView);
      localObject1 = new StateListDrawable();
      ((StateListDrawable)localObject1).addState(View.PRESSED_ENABLED_STATE_SET, new ColorDrawable(419430400));
      ((StateListDrawable)localObject1).addState(View.EMPTY_STATE_SET, new ColorDrawable(201326592));
      this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject1);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      d(paramProfileCardInfo);
      super.a(paramProfileCardInfo);
      return;
      localObject1 = localContext.getString(2131427399);
      break;
      bool = false;
      break label221;
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, long paramLong, boolean paramBoolean)
  {
    paramProfileCardInfo = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((paramProfileCardInfo instanceof VoteViewV2))
    {
      paramProfileCardInfo = (VoteViewV2)paramProfileCardInfo;
      long l = paramLong;
      if (paramLong == -1L) {
        l = paramProfileCardInfo.jdField_a_of_type_Int;
      }
      paramProfileCardInfo.a(false, true, (int)l, 0, null, paramBoolean);
      paramProfileCardInfo.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131427380), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    f(paramProfileCardInfo);
    a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    c(paramProfileCardInfo, false);
    i(paramProfileCardInfo);
    m(paramProfileCardInfo);
    b(paramProfileCardInfo);
    g(paramProfileCardInfo);
    d(paramProfileCardInfo);
    b(paramProfileCardInfo, paramBoolean);
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramProfileCardInfo.d))) {}
    do
    {
      return;
      localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sign");
    } while ((!(localObject1 instanceof TextView)) || (paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null));
    TextView localTextView = (TextView)localObject1;
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null)
    {
      localTextView.setVisibility(8);
      return;
    }
    Object localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getRichStatus();
    if ((!ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (localObject1 == null))
    {
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130843146, 0);
        localTextView.setText("编辑个性签名");
        localTextView.setVisibility(0);
        localTextView.setTag(new DataTag(3, ""));
        localTextView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        localTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131427367));
        return;
      }
      localTextView.setVisibility(8);
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
        localTextView.setText(localSpannableStringBuilder);
        localTextView.setVisibility(0);
        label341:
        if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (ProfileActivity.AllInOne.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
          localTextView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label533;
        }
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130843146, 0);
        label391:
        if (TextUtils.isEmpty(localSpannableString)) {
          break label557;
        }
        localObject1 = localSpannableString.toString();
        label405:
        localTextView.setTag(new DataTag(3, localObject1));
        localTextView.setOnLongClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        localObject1 = new StringBuilder().append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131427367)).append(":");
        if (TextUtils.isEmpty(localSpannableString)) {
          break label564;
        }
      }
    }
    label533:
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
      localTextView.setText(localSpannableString);
      localTextView.setVisibility(0);
      break label341;
      if (!ProfileActivity.AllInOne.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break label391;
      }
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130843147, 0);
      break label391;
      String str = "";
      break label405;
    }
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!ProfileActivity.AllInOne.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))) {}
    label35:
    do
    {
      do
      {
        do
        {
          break label35;
          do
          {
            return;
          } while ((paramProfileCardInfo.jdField_b_of_type_Boolean) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_a_of_type_Long));
          if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || ((paramProfileCardInfo.jdField_a_of_type_Int != 10) && (paramProfileCardInfo.jdField_a_of_type_Int != 11)) || (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramProfileCardInfo.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(paramProfileCardInfo.c))) {
            break label447;
          }
          if (paramProfileCardInfo.jdField_a_of_type_Int != 10) {
            break;
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setText(paramProfileCardInfo.jdField_a_of_type_JavaLangString);
          localObject = URLDrawable.getDrawable(paramProfileCardInfo.jdField_b_of_type_JavaLangString, null, null);
          i = getResources().getDimensionPixelSize(2131559464);
          ((Drawable)localObject).setBounds(0, 0, i, i);
          this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
          localObject = new DataTag(71, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
          this.jdField_c_of_type_AndroidWidgetTextView.setTag(localObject);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        } while (!AppSetting.jdField_b_of_type_Boolean);
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(paramProfileCardInfo.jdField_a_of_type_JavaLangString + ",按钮");
        return;
      } while (paramProfileCardInfo.jdField_a_of_type_Int != 11);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008640", "0X8008640", 1, 0, "", "", "", "");
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramProfileCardInfo.jdField_a_of_type_JavaLangString);
      Object localObject = URLDrawable.getDrawable(paramProfileCardInfo.jdField_b_of_type_JavaLangString, null, null);
      int i = getResources().getDimensionPixelSize(2131559464);
      ((Drawable)localObject).setBounds(0, 0, i, i);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
      localObject = new DataTag(74, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(localObject);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
    } while (!AppSetting.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(paramProfileCardInfo.jdField_a_of_type_JavaLangString + ",按钮");
    return;
    label447:
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void c(ProfileCardInfo paramProfileCardInfo) {}
  
  public void c(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (!ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_Long = 0L;
      return;
    }
    ThreadManager.post(new agvl(this, paramProfileCardInfo, paramBoolean), 8, null, true);
  }
  
  public void d(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!ProfileActivity.AllInOne.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))) {
      if (QLog.isColorLevel()) {
        QLog.d("MedalWallMng", 2, "updateMedal invalidate params!!");
      }
    }
    do
    {
      do
      {
        return;
        if (SharedPreUtils.aj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) == 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MedalWallMng", 2, "updateMedal medal config off");
      return;
    } while ((paramProfileCardInfo.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramProfileCardInfo.d)));
    label141:
    Object localObject;
    int i;
    if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.medalSwitchDisable) || (Utils.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      f1 = 1.0F;
      if (QLog.isColorLevel()) {
        QLog.d("MedalWallMng", 2, String.format(Locale.getDefault(), "updateMedal switch: %s medalAlpha: %s curAlpha: %s", new Object[] { Boolean.valueOf(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.medalSwitchDisable), Float.valueOf(this.jdField_a_of_type_Float), Float.valueOf(f1) }));
      }
    }
    else
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label489;
      }
      localObject = (LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
      if (!((LocalRedTouchManager)localObject).a(((LocalRedTouchManager)localObject).a(10016), false)) {
        break label423;
      }
      i = 1;
      label250:
      int j = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iMedalCount - paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iNewCount;
      localObject = String.format(Locale.getDefault(), "%d枚", new Object[] { Integer.valueOf(j) });
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      localObject = String.format(Locale.getDefault(), "勋章%d枚", new Object[] { Integer.valueOf(j) });
      this.jdField_d_of_type_AndroidViewView.setContentDescription((CharSequence)localObject);
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iNewCount <= 0) {
        break label428;
      }
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(String.format(Locale.getDefault(), "+%d", new Object[] { Integer.valueOf(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iNewCount) }));
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
    }
    for (float f1 = this.jdField_a_of_type_Float;; f1 = this.jdField_a_of_type_Float)
    {
      this.jdField_f_of_type_AndroidViewView.setAlpha(f1);
      this.jdField_e_of_type_AndroidViewView.setAlpha(f1);
      break label141;
      break;
      label423:
      i = 0;
      break label250;
      label428:
      if ((i == 0) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iUpgradeCount <= 0)) {
        break label475;
      }
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      this.jdField_g_of_type_AndroidViewView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label475:
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    for (;;)
    {
      f1 = 1.0F;
      break;
      label489:
      localObject = String.format(Locale.getDefault(), "%d枚", new Object[] { Integer.valueOf(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iMedalCount) });
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      localObject = String.format(Locale.getDefault(), "勋章%d枚", new Object[] { Integer.valueOf(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iMedalCount) });
      this.jdField_d_of_type_AndroidViewView.setContentDescription((CharSequence)localObject);
    }
  }
  
  public void e(ProfileCardInfo paramProfileCardInfo)
  {
    this.jdField_h_of_type_Int &= 0xFFFFFFFE;
    Object localObject;
    if ((this.jdField_h_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (!paramProfileCardInfo.jdField_b_of_type_Boolean)) {
      if (ProfileActivity.AllInOne.c(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        if (!ProfileActivity.AllInOne.h(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          break label405;
        }
        localObject = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        if (localObject != null)
        {
          if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
            break label702;
          }
          ProfileActivity.CardContactInfo localCardContactInfo = (ProfileActivity.CardContactInfo)paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
          if (localCardContactInfo == null) {
            break label205;
          }
          paramProfileCardInfo = localCardContactInfo.jdField_b_of_type_JavaLangString + localCardContactInfo.c;
          if (TextUtils.isEmpty(paramProfileCardInfo)) {
            break label702;
          }
        }
      }
    }
    label405:
    label692:
    label702:
    for (paramProfileCardInfo = ((PhoneContactManager)localObject).c(paramProfileCardInfo);; paramProfileCardInfo = null)
    {
      int i;
      if (paramProfileCardInfo != null)
      {
        i = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        if ((2 != i) && (i != 0)) {
          break label216;
        }
        this.jdField_h_of_type_Int &= 0xFFFFFFFE;
      }
      for (;;)
      {
        if ((this.jdField_h_of_type_Int & 0x1) == 0) {
          break label692;
        }
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        label205:
        paramProfileCardInfo = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        break;
        label216:
        if ((paramProfileCardInfo.iTermType == 68104) || (paramProfileCardInfo.iTermType == 65805))
        {
          this.jdField_h_of_type_Int &= 0xFFFFFFFE;
        }
        else if ((paramProfileCardInfo.abilityBits & 1L) != 0L)
        {
          i = paramProfileCardInfo.eNetworkType;
          paramProfileCardInfo = a(i);
          if (i == 2)
          {
            this.jdField_h_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130843118), null, null, null);
            this.jdField_h_of_type_AndroidWidgetTextView.setCompoundDrawablePadding((int)DisplayUtils.a(getContext(), 4.0F));
          }
          if ((this.jdField_h_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramProfileCardInfo))) {
            this.jdField_h_of_type_AndroidWidgetTextView.setText(paramProfileCardInfo);
          }
          this.jdField_h_of_type_Int |= 0x1;
        }
        else if ((paramProfileCardInfo.ability & 0x2) != 0)
        {
          paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435817);
          if ((this.jdField_h_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramProfileCardInfo))) {
            this.jdField_h_of_type_AndroidWidgetTextView.setText(paramProfileCardInfo);
          }
          this.jdField_h_of_type_Int |= 0x1;
          continue;
          localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          if (localObject != null)
          {
            paramProfileCardInfo = ((FriendsManager)localObject).c(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            i = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
            if ((2 == i) || (i == 0))
            {
              this.jdField_h_of_type_Int &= 0xFFFFFFFE;
            }
            else if ((paramProfileCardInfo != null) && ((paramProfileCardInfo.iTermType == 68104) || (paramProfileCardInfo.iTermType == 65805)))
            {
              this.jdField_h_of_type_Int &= 0xFFFFFFFE;
            }
            else if ((paramProfileCardInfo != null) && ((paramProfileCardInfo.abilityBits & 1L) != 0L))
            {
              i = paramProfileCardInfo.getNetWorkType();
              localObject = a(i);
              if ((i == 2) && (this.jdField_h_of_type_AndroidWidgetTextView != null))
              {
                this.jdField_h_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130843118), null, null, null);
                this.jdField_h_of_type_AndroidWidgetTextView.setCompoundDrawablePadding((int)DisplayUtils.a(getContext(), 4.0F));
              }
              if (ContactUtils.a(paramProfileCardInfo))
              {
                this.jdField_h_of_type_Int = 0;
              }
              else
              {
                if ((this.jdField_h_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
                  this.jdField_h_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
                }
                this.jdField_h_of_type_Int |= 0x1;
              }
            }
            else if ((paramProfileCardInfo != null) && ((paramProfileCardInfo.abilityBits & 0x2) != 0L))
            {
              paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435817);
              if ((this.jdField_h_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramProfileCardInfo))) {
                this.jdField_h_of_type_AndroidWidgetTextView.setText(paramProfileCardInfo);
              }
              this.jdField_h_of_type_Int |= 0x1;
            }
          }
        }
      }
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  protected void f(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject;
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
    {
      localObject = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getCoverData(this.i);
      paramProfileCardInfo = (String)localObject[0];
      Integer localInteger = (Integer)localObject[1];
      if ((TextUtils.isEmpty(paramProfileCardInfo)) || (paramProfileCardInfo.equals(this.jdField_b_of_type_JavaLangString))) {
        break label122;
      }
      if ((localInteger.intValue() != 0) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (this.i != 0)) {
        break label78;
      }
    }
    label78:
    label122:
    while (!QLog.isColorLevel())
    {
      return;
      this.jdField_b_of_type_JavaLangString = paramProfileCardInfo;
      this.i = ((Integer)localObject[1]).intValue();
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView;
      if (this.i == 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((RandomCoverView)localObject).a(paramProfileCardInfo, bool);
        return;
      }
    }
    QLog.i("Q.profilecard.", 2, "same cover " + paramProfileCardInfo);
  }
  
  public void g(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramProfileCardInfo.d))) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    } while (!(localObject1 instanceof VoteViewV2));
    VoteViewV2 localVoteViewV2 = (VoteViewV2)localObject1;
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {}
    for (boolean bool1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.isShowZan();; bool1 = false)
    {
      if (this.jdField_c_of_type_Boolean) {
        bool1 = false;
      }
      if (bool1)
      {
        localVoteViewV2.setVisibility(0);
        boolean bool2;
        Object localObject2;
        int j;
        int i;
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
        {
          bool2 = TextUtils.equals(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
            break label194;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131427383);
          localObject2 = null;
          j = 0;
          bool1 = false;
          i = 0;
        }
        for (;;)
        {
          localVoteViewV2.a(bool2, bool1, i, j, this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper, false);
          localVoteViewV2.setTag(localObject2);
          localVoteViewV2.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          localVoteViewV2.setContentDescription((CharSequence)localObject1);
          return;
          bool2 = false;
          break;
          label194:
          if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper == null) {
            this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper = new NewVoteAnimHelper(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 1);
          }
          i = (int)paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
          j = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement;
          if (1 == paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {}
          for (bool1 = true;; bool1 = false)
          {
            this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getLastPraiseInfoList();
            if (j <= this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a.size()) {
              this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a = this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a.subList(0, j);
            }
            this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a = PraiseConfigHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a);
            if (!bool2) {
              break label376;
            }
            localObject2 = new DataTag(10, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
            localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131427382), new Object[] { String.valueOf(i) });
            break;
          }
          label376:
          localObject2 = new DataTag(10, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
          localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131427381), new Object[] { String.valueOf(i) });
        }
      }
      localVoteViewV2.setVisibility(4);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
      return;
    }
    super.onClick(this.jdField_d_of_type_AndroidWidgetTextView);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      paramInt1 = this.jdField_c_of_type_AndroidViewView.getLeft();
      paramInt2 = this.jdField_c_of_type_AndroidViewView.getTop();
      paramInt3 = this.jdField_c_of_type_AndroidViewView.getRight();
      this.jdField_c_of_type_AndroidViewView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileBaseView
 * JD-Core Version:    0.7.0.1
 */