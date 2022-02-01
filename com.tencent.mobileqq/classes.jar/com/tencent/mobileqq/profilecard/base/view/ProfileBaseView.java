package com.tencent.mobileqq.profilecard.base.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aryq;
import azpb;
import azrb;
import aztg;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.QidCoolTextView;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PullToZoomHeaderListView;
import java.util.HashMap;
import java.util.List;

public class ProfileBaseView
  extends AbsProfileHeaderView
{
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  private QidCoolTextView jdField_a_of_type_ComTencentMobileqqVasQidCoolTextView;
  private AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  private ProfileNameView jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
  private RandomCoverView jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView;
  private VoteViewV2 jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2;
  private PullToZoomHeaderListView jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = true;
  private View c;
  private View d;
  
  public ProfileBaseView(BaseActivity paramBaseActivity, azrb paramazrb)
  {
    super(paramBaseActivity, paramazrb);
    this.jdField_a_of_type_Aryq = new aryq(paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 1);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initHeadUI");
    }
    Object localObject = getContext();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368830));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368826));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(0);
    azpb localazpb = new azpb(1, null);
    if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (localObject = ((Context)localObject).getString(2131691169);; localObject = ((Context)localObject).getString(2131691168))
    {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setTag(localazpb);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setContentDescription((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363426), false);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", this.jdField_a_of_type_AndroidViewView.findViewById(2131368828));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368659));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(localazpb);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131374402);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView = ((ProfileNameView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371965));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376508));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_remark_name", this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2 = ((VoteViewV2)this.jdField_a_of_type_AndroidViewView.findViewById(2131381304));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368178));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131374179);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374177));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_uin_info", this.jdField_b_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_ComTencentMobileqqVasQidCoolTextView = ((QidCoolTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374425));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qid_info", this.jdField_a_of_type_ComTencentMobileqqVasQidCoolTextView);
      this.jdField_a_of_type_ComTencentMobileqqVasQidCoolTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
  }
  
  private void l(azrb paramazrb)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasQidCoolTextView != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqVasQidCoolTextView.a(paramazrb);
      if (i != 0) {
        this.jdField_a_of_type_ComTencentMobileqqVasQidCoolTextView.a(0.0F, i);
      }
    }
  }
  
  public void a(int paramInt, azrb paramazrb)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("onCoverModeChange mode: %s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setTextColor(getResources().getColor(2131167026));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.a(1);
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(10, 1);
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setTag(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setOnClickListener(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setContentDescription(null);
      d(paramInt);
      l(paramazrb);
      return;
    }
    int i;
    label163:
    azpb localazpb;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView != null)
    {
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        i = 2131167026;
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setTextColor(getResources().getColor(i));
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.a(0);
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131368846);
      ((RelativeLayout.LayoutParams)localObject).addRule(10, 0);
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localazpb = new azpb(17, null);
      if (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label309;
      }
    }
    label309:
    for (Object localObject = getContext().getString(2131691164);; localObject = getContext().getString(2131691163))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setTag(localazpb);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setContentDescription((CharSequence)localObject);
      d(paramInt);
      break;
      i = 2131167190;
      break label163;
    }
  }
  
  protected void a(azrb paramazrb)
  {
    boolean bool = false;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131562027, this, true);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368830));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView = ((RandomCoverView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368846));
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setHeaderImage(this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a());
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setHeaderMask(this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a());
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setProfileBaseView(this);
    int i;
    if (ProfileActivity.AllInOne.i(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
      i = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView = ((RandomCoverView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368846));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368823);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzonecover", this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setVisibility(0);
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str1 = paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      String str2 = this.jdField_b_of_type_JavaLangString;
      if (this.jdField_a_of_type_Int == 0) {
        bool = true;
      }
      ((RandomCoverView)localObject1).a((QQAppInterface)localObject2, str1, i, str2, bool, true);
      b(i);
      e();
      a(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      b(paramazrb, true);
      c(paramazrb);
      g(paramazrb);
      h(paramazrb);
      a(paramazrb, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      e(paramazrb);
      super.a(paramazrb);
      a(i, paramazrb);
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        paramazrb = (ImageView)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363426);
        localObject1 = (ImageView)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_face_stoke");
        localObject2 = this.jdField_a_of_type_AndroidWidgetImageView;
        paramazrb.setColorFilter(1996488704);
        ((ImageView)localObject1).setColorFilter(1996488704);
        ((ImageView)localObject2).setColorFilter(1996488704);
      }
      return;
      if (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        localObject1 = paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.getCoverData(this.jdField_a_of_type_Int);
        localObject2 = (String)localObject1[0];
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.jdField_b_of_type_JavaLangString = ((String)localObject2);
          this.jdField_a_of_type_Int = ((Integer)localObject1[1]).intValue();
        }
        if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover())) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label432;
          }
          i = 1;
          break;
        }
      }
      label432:
      i = 0;
    }
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
    k(paramazrb);
    a(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    b(paramazrb, false);
    c(paramazrb);
    g(paramazrb);
    h(paramazrb);
    a(paramazrb, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    e(paramazrb);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a() == 1);
  }
  
  protected void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "loadHeadLayout mode=" + paramInt);
    }
    View localView = LayoutInflater.from(getContext()).inflate(2131562028, this.jdField_a_of_type_AndroidViewViewGroup, false);
    if (localView != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(localView);
    }
  }
  
  public void b(azrb paramazrb, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (!ProfileActivity.AllInOne.g(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_Long = 0L;
      return;
    }
    ThreadManager.post(new ProfileBaseView.1(this, paramazrb, paramBoolean), 8, null, true);
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Azrb != null) {
      b(this.jdField_a_of_type_Azrb, false);
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    invalidate();
  }
  
  public void c(azrb paramazrb)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazrb);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView != null)
    {
      d(this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a());
      l(paramazrb);
    }
  }
  
  public void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView == null) || (this.d == null) || (this.c == null)) {}
    int i;
    int j;
    do
    {
      return;
      if (paramInt == 1)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = ScreenUtil.dip2px(5.0F);
        this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.c() == 2)
        {
          localObject = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
          if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
          {
            ((RelativeLayout.LayoutParams)localObject).bottomMargin = ScreenUtil.dip2px(-2.0F);
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
            localLayoutParams.addRule(3, this.c.getId());
            this.d.setLayoutParams(localLayoutParams);
          }
          ((RelativeLayout.LayoutParams)localObject).addRule(6, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getId());
          ((RelativeLayout.LayoutParams)localObject).addRule(8, 0);
          this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
          return;
        }
        localObject = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(6, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131368082);
        this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      Object localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = ScreenUtil.dip2px(15.0F);
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = getResources();
      i = ((Resources)localObject).getDimensionPixelSize(2131297545);
      j = ((Resources)localObject).getDimensionPixelSize(2131297547);
      localObject = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131368082);
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (ViewGroup.MarginLayoutParams)this.c.getLayoutParams();
      if (((ViewGroup.MarginLayoutParams)localObject).bottomMargin != i)
      {
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = i;
        this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = (ViewGroup.MarginLayoutParams)this.d.getLayoutParams();
      if (((ViewGroup.MarginLayoutParams)localObject).topMargin != j)
      {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = j;
        this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("updateLayoutMargin mode: %s, name:%s, level:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j) }));
  }
  
  public void d(azrb paramazrb) {}
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsRectF == null) {
        this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
      }
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null) {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      }
      this.jdField_a_of_type_AndroidGraphicsRectF.set(getLeft(), this.jdField_b_of_type_Int, getRight(), getBottom());
      paramCanvas.save();
      paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRectF);
      super.dispatchDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void h(azrb paramazrb)
  {
    if ((paramazrb.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazrb.jdField_a_of_type_JavaLangString))) {}
    Object localObject;
    do
    {
      return;
      localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    } while (!(localObject instanceof VoteViewV2));
    VoteViewV2 localVoteViewV2 = (VoteViewV2)localObject;
    boolean bool1 = a(paramazrb);
    if (this.jdField_a_of_type_Boolean) {
      bool1 = false;
    }
    for (;;)
    {
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
              break label346;
            }
            localObject = new azpb(10, paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard);
            paramazrb = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691214), new Object[] { String.valueOf(i) });
            break;
          }
          label346:
          localObject = new azpb(10, paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard);
          String str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691127), new Object[] { String.valueOf(i) });
          if (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0) {
            localVoteViewV2.a();
          }
          paramazrb = str;
        }
      }
      localVoteViewV2.setVisibility(4);
      return;
    }
  }
  
  protected void k(azrb paramazrb)
  {
    int j = 1;
    boolean bool;
    if (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard != null)
    {
      Object localObject = paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.getCoverData(this.jdField_a_of_type_Int);
      String str = (String)localObject[0];
      if ((!TextUtils.isEmpty(str)) && (!str.equals(this.jdField_b_of_type_JavaLangString)))
      {
        this.jdField_b_of_type_JavaLangString = str;
        this.jdField_a_of_type_Int = ((Integer)localObject[1]).intValue();
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView;
        if (this.jdField_a_of_type_Int != 0) {
          break label150;
        }
        bool = true;
        ((RandomCoverView)localObject).a(str, bool);
      }
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover())) {
        break label156;
      }
      i = 1;
      label118:
      if (i == 0) {
        break label161;
      }
    }
    label150:
    label156:
    label161:
    for (int i = j;; i = 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a() != i)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a(i);
        a(i, paramazrb);
      }
      return;
      bool = false;
      break;
      i = 0;
      break label118;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      paramInt1 = this.jdField_b_of_type_AndroidViewView.getLeft();
      paramInt2 = this.jdField_b_of_type_AndroidViewView.getTop();
      paramInt3 = this.jdField_b_of_type_AndroidViewView.getRight();
      this.jdField_b_of_type_AndroidViewView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setClipChildren(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    super.setClipChildren(paramBoolean);
  }
  
  public void setProfileArgs(PullToZoomHeaderListView paramPullToZoomHeaderListView, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = paramPullToZoomHeaderListView;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
 * JD-Core Version:    0.7.0.1
 */