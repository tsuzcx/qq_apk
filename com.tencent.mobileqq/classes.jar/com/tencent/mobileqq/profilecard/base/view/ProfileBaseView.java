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
import asbe;
import azvr;
import azxr;
import azzw;
import bdep;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
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
  private AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  private ProfileNameView jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
  private RandomCoverView jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView;
  private VoteViewV2 jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2;
  private PullToZoomHeaderListView jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = true;
  private View c;
  private View d;
  
  public ProfileBaseView(BaseActivity paramBaseActivity, azxr paramazxr)
  {
    super(paramBaseActivity, paramazxr);
    this.jdField_a_of_type_Asbe = new asbe(paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 1);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initHeadUI");
    }
    Object localObject = getContext();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368647));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368643));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(0);
    azvr localazvr = new azvr(1, null);
    if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (localObject = ((Context)localObject).getString(2131691044);; localObject = ((Context)localObject).getString(2131691043))
    {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setTag(localazvr);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setContentDescription((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363327), false);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", this.jdField_a_of_type_AndroidViewView.findViewById(2131368645));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368476));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(localazvr);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131374400);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView = ((ProfileNameView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371812));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2 = ((VoteViewV2)this.jdField_a_of_type_AndroidViewView.findViewById(2131381230));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368010));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131374205);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374203));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_uin_info", this.jdField_a_of_type_AndroidWidgetTextView);
      return;
    }
  }
  
  public void a(int paramInt, azxr paramazxr)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("onCoverModeChange mode: %s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setTextColor(getResources().getColor(2131166990));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.a(1);
      }
      paramazxr = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      paramazxr.addRule(3, 0);
      paramazxr.addRule(10, 1);
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramazxr);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setTag(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setOnClickListener(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setContentDescription(null);
      d(paramInt);
      return;
    }
    int i;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView != null)
    {
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        i = 2131166990;
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setTextColor(getResources().getColor(i));
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.a(0);
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131368663);
      ((RelativeLayout.LayoutParams)localObject).addRule(10, 0);
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new azvr(17, null);
      if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label296;
      }
    }
    label296:
    for (paramazxr = getContext().getString(2131691039);; paramazxr = getContext().getString(2131691038))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setTag(localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setContentDescription(paramazxr);
      d(paramInt);
      return;
      i = 2131167153;
      break;
    }
  }
  
  protected void a(azxr paramazxr)
  {
    boolean bool = false;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131562087, this, true);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368647));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView = ((RandomCoverView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368663));
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setHeaderImage(this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a());
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setHeaderMask(this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a());
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setProfileBaseView(this);
    int i;
    if (ProfileActivity.AllInOne.i(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
      i = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView = ((RandomCoverView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368663));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368640);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzonecover", this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setVisibility(0);
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str1 = paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      String str2 = this.jdField_b_of_type_JavaLangString;
      if (this.jdField_a_of_type_Int == 0) {
        bool = true;
      }
      ((RandomCoverView)localObject1).a((QQAppInterface)localObject2, str1, i, str2, bool, true);
      b(i);
      e();
      a(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      b(paramazxr, true);
      c(paramazxr);
      f(paramazxr);
      g(paramazxr);
      a(paramazxr, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      super.a(paramazxr);
      a(i, paramazxr);
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        paramazxr = (ImageView)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363327);
        localObject1 = (ImageView)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_face_stoke");
        localObject2 = this.jdField_a_of_type_AndroidWidgetImageView;
        paramazxr.setColorFilter(1996488704);
        ((ImageView)localObject1).setColorFilter(1996488704);
        ((ImageView)localObject2).setColorFilter(1996488704);
      }
      return;
      if (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        localObject1 = paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.getCoverData(this.jdField_a_of_type_Int);
        localObject2 = (String)localObject1[0];
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.jdField_b_of_type_JavaLangString = ((String)localObject2);
          this.jdField_a_of_type_Int = ((Integer)localObject1[1]).intValue();
        }
        if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover())) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label427;
          }
          i = 1;
          break;
        }
      }
      label427:
      i = 0;
    }
  }
  
  public void a(azxr paramazxr, long paramLong, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteViewV2))
    {
      localObject = (VoteViewV2)localObject;
      long l = paramLong;
      if (paramLong == -1L) {
        l = ((VoteViewV2)localObject).e;
      }
      if ((paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0)) {
        ((VoteViewV2)localObject).a();
      }
      ((VoteViewV2)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteViewV2)localObject).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691014), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void a(azxr paramazxr, boolean paramBoolean)
  {
    j(paramazxr);
    a(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    b(paramazxr, false);
    c(paramazxr);
    f(paramazxr);
    g(paramazxr);
    a(paramazxr, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
    View localView = LayoutInflater.from(getContext()).inflate(2131562088, this.jdField_a_of_type_AndroidViewViewGroup, false);
    if (localView != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(localView);
    }
  }
  
  public void b(azxr paramazxr, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (!ProfileActivity.AllInOne.g(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_Long = 0L;
      return;
    }
    ThreadManager.post(new ProfileBaseView.1(this, paramazxr, paramBoolean), 8, null, true);
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Azxr != null) {
      b(this.jdField_a_of_type_Azxr, false);
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    invalidate();
  }
  
  public void c(azxr paramazxr)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazxr);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView != null) {
      d(this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a());
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
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = bdep.a(5.0F);
        this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      Object localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = bdep.a(15.0F);
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = getResources();
      i = ((Resources)localObject).getDimensionPixelSize(2131297489);
      j = ((Resources)localObject).getDimensionPixelSize(2131297491);
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
  
  public void d(azxr paramazxr) {}
  
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
  
  public void g(azxr paramazxr)
  {
    if ((paramazxr.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazxr.jdField_a_of_type_JavaLangString))) {}
    Object localObject;
    do
    {
      return;
      localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    } while (!(localObject instanceof VoteViewV2));
    VoteViewV2 localVoteViewV2 = (VoteViewV2)localObject;
    boolean bool1 = a(paramazxr);
    if (this.jdField_a_of_type_Boolean) {
      bool1 = false;
    }
    for (;;)
    {
      boolean bool2 = TextUtils.equals(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (bool1)
      {
        localVoteViewV2.setVisibility(0);
        int j;
        int i;
        if (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard == null)
        {
          paramazxr = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691091);
          localObject = null;
          j = 0;
          bool1 = false;
          i = 0;
        }
        for (;;)
        {
          localVoteViewV2.a(bool2, bool1, i, j, this.jdField_a_of_type_Asbe, false);
          localVoteViewV2.setTag(localObject);
          localVoteViewV2.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localVoteViewV2.setContentDescription(paramazxr);
          return;
          if (this.jdField_a_of_type_Asbe == null) {
            this.jdField_a_of_type_Asbe = new asbe(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 1);
          }
          i = (int)paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
          j = paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement;
          if (1 == paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {}
          for (bool1 = true;; bool1 = false)
          {
            this.jdField_a_of_type_Asbe.a = paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.getLastPraiseInfoList();
            if (j <= this.jdField_a_of_type_Asbe.a.size()) {
              this.jdField_a_of_type_Asbe.a = this.jdField_a_of_type_Asbe.a.subList(0, j);
            }
            this.jdField_a_of_type_Asbe.a = azzw.a(this.jdField_a_of_type_Asbe.a);
            if (!bool2) {
              break label346;
            }
            localObject = new azvr(10, paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard);
            paramazxr = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691089), new Object[] { String.valueOf(i) });
            break;
          }
          label346:
          localObject = new azvr(10, paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard);
          String str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691002), new Object[] { String.valueOf(i) });
          if (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0) {
            localVoteViewV2.a();
          }
          paramazxr = str;
        }
      }
      localVoteViewV2.setVisibility(4);
      return;
    }
  }
  
  protected void j(azxr paramazxr)
  {
    int j = 1;
    boolean bool;
    if (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard != null)
    {
      Object localObject = paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.getCoverData(this.jdField_a_of_type_Int);
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
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover())) {
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
        a(i, paramazxr);
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