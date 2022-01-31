package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import agcy;
import agcz;
import agda;
import agdb;
import agdc;
import agdd;
import agdf;
import agdg;
import agdh;
import agdi;
import agdj;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.profile.like.PraiseConfigHelper;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.BounceScrollView.MotionEventInterceptor;
import com.tencent.mobileqq.widget.Rotate3dAnimation;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.qzone.model.CoverCacheData;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public abstract class ProfileHeaderView
  extends RelativeLayout
  implements View.OnClickListener, ProfileViewUpdate, BounceScrollView.MotionEventInterceptor
{
  public static int a;
  public static String a;
  public static int b;
  public static int d;
  public static int e = 1001;
  public static int f = 1002;
  public static int g = 1003;
  public long a;
  private Handler.Callback a;
  public BaseActivity a;
  public BusinessObserver a;
  public QQAppInterface a;
  public NewVoteAnimHelper a;
  public ProfileCardInfo a;
  public MqqWeakReferenceHandler a;
  public HashMap a;
  public AtomicBoolean a;
  public boolean a;
  protected float b;
  public ImageView b;
  public String b;
  public AtomicBoolean b;
  protected boolean b;
  protected float c;
  public int c;
  private boolean c;
  protected float d;
  public int h;
  public int i;
  private int j;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.profilecard.FrdProfileCard.ProfileHeaderView";
    jdField_a_of_type_Int = 500;
    jdField_b_of_type_Int = jdField_a_of_type_Int * 2 + 3000;
    jdField_d_of_type_Int = 1000;
  }
  
  public ProfileHeaderView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new agcy(this);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver = new agdj(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    paramBaseActivity = getResources().getDisplayMetrics();
    this.jdField_b_of_type_Float = paramBaseActivity.density;
    this.jdField_c_of_type_Float = Math.min(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
    this.jdField_d_of_type_Float = Math.max(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
  }
  
  private void a(ViewGroup paramViewGroup, TextView paramTextView)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean) || (paramViewGroup == null) || (paramTextView == null)) {
      return;
    }
    if (TroopMemberCardUtils.a(((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard, paramTextView))
    {
      paramViewGroup.setVisibility(0);
      paramTextView.setPadding(10, 2, 10, 2);
      if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d)) {
        TroopRankConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
      }
      label297:
      while (!this.jdField_b_of_type_Boolean)
      {
        TroopRankConfig.a("grp_data", "exp_medal");
        this.jdField_b_of_type_Boolean = true;
        return;
        switch (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole)
        {
        }
        for (;;)
        {
          if ((!TroopRankConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
            break label297;
          }
          this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          if (paramViewGroup == null) {
            break;
          }
          paramTextView = new RelativeLayout.LayoutParams(-2, -2);
          paramTextView.addRule(7, 2131372359);
          paramTextView.setMargins(0, 0, 0, 0);
          this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(paramTextView);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845924);
          paramViewGroup.addView(this.jdField_b_of_type_AndroidWidgetImageView);
          break;
          paramViewGroup.setOnClickListener(new agcz(this));
        }
      }
    }
    paramViewGroup.setVisibility(8);
    paramTextView.setText(null);
    paramTextView.setBackgroundDrawable(null);
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2, String paramString)
  {
    if ((paramTextView1 == null) || (paramTextView2 == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Object localObject2 = paramTextView1.getPaint();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new TextPaint(1);
      ((TextPaint)localObject1).density = this.jdField_b_of_type_Float;
    }
    TextPaint localTextPaint = paramTextView2.getPaint();
    localObject2 = localTextPaint;
    if (localTextPaint == null)
    {
      localObject2 = new TextPaint(1);
      ((TextPaint)localObject2).density = this.jdField_b_of_type_Float;
    }
    float f1 = ((TextPaint)localObject2).measureText(paramTextView2.getText().toString());
    float f2 = ((TextPaint)localObject1).measureText("...");
    float f3 = this.jdField_b_of_type_Float;
    paramString = TextUtils.ellipsize(paramString, (TextPaint)localObject1, ViewUtils.a() - f1 - (f2 + 8.0F * f3) - DisplayUtils.a(paramTextView1.getContext(), 10.0F), TextUtils.TruncateAt.END);
    if (paramString != null)
    {
      paramTextView2 = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      if (!ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break label217;
      }
    }
    label217:
    for (paramTextView2 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);; paramTextView2 = " ")
    {
      paramTextView1.setText(paramTextView2.toString());
      paramTextView1.setContentDescription(paramTextView2.toString());
      return;
    }
  }
  
  private void d()
  {
    if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null) && (!this.jdField_c_of_type_Boolean))
    {
      this.jdField_c_of_type_Boolean = true;
      Message localMessage = this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(jdField_d_of_type_Int);
      if (localMessage != null) {
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendMessage(localMessage);
      }
    }
  }
  
  public CoverCacheData a()
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localObject instanceof QzonePhotoView))
    {
      localObject = (QzonePhotoView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateQzonePhotoView");
      }
      return ((QzonePhotoView)localObject).a();
    }
    if ((localObject instanceof VipPhotoViewForSimple))
    {
      localObject = (VipPhotoViewForSimple)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateVipPhotoViewForSimple");
      }
      return ((VipPhotoViewForSimple)localObject).a();
    }
    return null;
  }
  
  protected String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435782);
    case 1: 
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435783);
    case 4: 
      return String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435785), new Object[] { "4G" });
    case 3: 
      return String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435785), new Object[] { "3G" });
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435786);
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramAllInOne.jdField_a_of_type_Int == 33)
    {
      a(paramAllInOne, 2, paramAllInOne.jdField_a_of_type_JavaLangString, false);
      return;
    }
    String str;
    if (paramAllInOne.jdField_a_of_type_Int == 80)
    {
      str = ProfileCardUtil.a(paramAllInOne);
      if ((str != null) && (str.length() > 0))
      {
        localObject = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        if (localObject == null) {
          break label264;
        }
      }
    }
    label264:
    for (Object localObject = ((PhoneContactManager)localObject).c(str);; localObject = null)
    {
      if (localObject != null)
      {
        a(paramAllInOne, 1, str, false);
        return;
      }
      a(paramAllInOne, 0, paramAllInOne.jdField_a_of_type_JavaLangString, false);
      return;
      a(paramAllInOne, 0, paramAllInOne.jdField_a_of_type_JavaLangString, false);
      return;
      if (ProfileActivity.AllInOne.f(paramAllInOne))
      {
        if (((paramAllInOne.jdField_a_of_type_Int == 41) || (paramAllInOne.jdField_a_of_type_Int == 86)) && (!TextUtils.isEmpty(paramAllInOne.jdField_a_of_type_JavaLangString)) && (paramAllInOne.jdField_a_of_type_JavaLangString.equals("0")) && (!TextUtils.isEmpty(paramAllInOne.p)))
        {
          a(paramAllInOne, 0, paramAllInOne.p, false);
          return;
        }
        a(paramAllInOne, 0, paramAllInOne.jdField_a_of_type_JavaLangString, true);
        return;
      }
      localObject = ProfileCardUtil.a(paramAllInOne);
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        if (paramAllInOne.jdField_a_of_type_Int == 53)
        {
          if (paramAllInOne.jdField_b_of_type_Boolean) {}
          for (int k = 1;; k = 3)
          {
            a(paramAllInOne, k, (String)localObject, false);
            return;
          }
        }
        a(paramAllInOne, 1, (String)localObject, false);
        return;
      }
      a(paramAllInOne, 2, paramAllInOne.jdField_a_of_type_JavaLangString, false);
      return;
    }
  }
  
  public void a(ProfileActivity.AllInOne paramAllInOne, int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "updateAvatar() type = " + paramInt + "key = " + paramString + ",isDynamicMode:" + paramBoolean);
    }
    if ((!paramBoolean) || (paramInt != 0))
    {
      ThreadManager.post(new agdd(this, paramInt, paramAllInOne, paramString), 8, null, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new agdf(this, paramAllInOne, paramInt, paramString));
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView onInit");
    }
    e(paramProfileCardInfo);
    j(paramProfileCardInfo);
    if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("VipPersonalLike", 0);
      if (paramProfileCardInfo.getInt("ProfilePersonalLikeMasterHasShownTip_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1) != 1)
      {
        View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_personal_like_tip");
        if (localView != null)
        {
          localView.setVisibility(0);
          paramProfileCardInfo.edit().putInt("ProfilePersonalLikeMasterHasShownTip_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1).apply();
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, long paramLong, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateLiked");
      }
      long l = paramLong;
      if (paramLong == -1L) {
        l = ((VoteView)localObject).jdField_a_of_type_Int;
      }
      ((VoteView)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteView)localObject).setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((VoteView)localObject).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131427380), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, HashMap paramHashMap)
  {
    paramProfileCardInfo = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.a;
    String str1 = getClass().getName();
    if ((paramProfileCardInfo == null) || (paramProfileCardInfo.size() <= 0)) {
      throw new ProfileTemplateException(str1 + " template templateAttr is null");
    }
    paramHashMap.put("commonBottomBtnBackground", "drawable");
    paramHashMap.put("commonBottomBtnTextColor", "color");
    paramHashMap.put("commonItemTitleColor", "color");
    paramHashMap.put("commonItemContentColor", "color");
    paramHashMap.put("commonItemContentLinkColor", "color");
    paramHashMap.put("commonItemTopBorderBackground", "drawable");
    paramHashMap.put("commonItemBottomBorderBackground", "drawable");
    paramHashMap.put("commonItemBorderBackground", "drawable");
    paramHashMap.put("commonItemMoreSrc", "drawable");
    paramHashMap.put("commonQrCodeSrc", "drawable");
    paramHashMap.put("commonMaskBackground", "color");
    paramHashMap = paramHashMap.entrySet().iterator();
    label435:
    label438:
    for (;;)
    {
      Object localObject1;
      String str2;
      Object localObject2;
      int k;
      String str3;
      if (paramHashMap.hasNext())
      {
        localObject1 = (Map.Entry)paramHashMap.next();
        str2 = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (String)((Map.Entry)localObject1).getValue();
        localObject2 = paramProfileCardInfo.get(str2);
        String[] arrayOfString = ((String)localObject1).split(",");
        int m = arrayOfString.length;
        k = 0;
        if (k >= m) {
          break label435;
        }
        str3 = arrayOfString[k];
        if ((localObject2 != null) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3))) {
          if ((str3.equalsIgnoreCase("color")) && (((localObject2 instanceof ColorStateList)) || ((localObject2 instanceof String)))) {
            k = 1;
          }
        }
      }
      for (;;)
      {
        if (k != 0) {
          break label438;
        }
        throw new ProfileTemplateException(str1 + " template attr " + str2 + " type is not " + (String)localObject1);
        if ((str3.equalsIgnoreCase("drawable")) && ((localObject2 instanceof Drawable)))
        {
          k = 1;
        }
        else if ((str3.equalsIgnoreCase("string")) && ((localObject2 instanceof String)) && (!TextUtils.isEmpty((String)localObject2)))
        {
          k = 1;
        }
        else
        {
          k += 1;
          break;
          return;
          k = 0;
        }
      }
    }
  }
  
  public abstract void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean);
  
  public void a(CoverCacheData paramCoverCacheData)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localObject instanceof QzonePhotoView))
    {
      localObject = (QzonePhotoView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateQzonePhotoView");
      }
      ((QzonePhotoView)localObject).a(paramCoverCacheData);
    }
    while (!(localObject instanceof VipPhotoViewForSimple)) {
      return;
    }
    localObject = (VipPhotoViewForSimple)localObject;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateVipPhotoViewForSimple");
    }
    ((VipPhotoViewForSimple)localObject).a(paramCoverCacheData);
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, int paramInt, List paramList) {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tag_jueban");
    if ((localObject2 != null) && (localObject1 != null)) {
      if (!paramBoolean) {
        break label152;
      }
    }
    for (;;)
    {
      Object localObject3 = new Rotate3dAnimation(0.0F, -90.0F, 1, 0.5F, 0.5F, 0.0F, false);
      Rotate3dAnimation localRotate3dAnimation = new Rotate3dAnimation(-90.0F, 0.0F, 1, 0.5F, 0.5F, 0.0F, false);
      ((Rotate3dAnimation)localObject3).setDuration(jdField_a_of_type_Int);
      ((Rotate3dAnimation)localObject3).setFillAfter(false);
      localRotate3dAnimation.setDuration(jdField_a_of_type_Int);
      localRotate3dAnimation.setFillAfter(false);
      ((Rotate3dAnimation)localObject3).setAnimationListener(new agdb(this, (View)localObject2, (View)localObject1, localRotate3dAnimation));
      localRotate3dAnimation.setAnimationListener(new agdc(this, paramBoolean));
      ((View)localObject2).startAnimation((Animation)localObject3);
      return;
      label152:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localObject instanceof QzonePhotoView))
    {
      localObject = (QzonePhotoView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "QzonePhotoView onGetQZoneCover isSuccess=" + String.valueOf(paramBoolean) + ",uin=" + paramString);
      }
      ((QzonePhotoView)localObject).a(paramBoolean, paramString, parammobile_sub_get_photo_wall_rsp);
    }
    while (!(localObject instanceof VipPhotoViewForSimple)) {
      return;
    }
    localObject = (VipPhotoViewForSimple)localObject;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "VipPhotoViewForSimple onGetQZoneCover isSuccess=" + String.valueOf(paramBoolean) + ",uin=" + paramString);
    }
    ((VipPhotoViewForSimple)localObject).a(paramBoolean, paramString, parammobile_sub_get_photo_wall_rsp);
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b() {}
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
    }
    if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null) {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeCallbacksAndMessages(null);
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localView instanceof QzonePhotoView)) {
      ((QzonePhotoView)localView).a();
    }
  }
  
  public void c(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sex_age_area");
    String str;
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      str = ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramProfileCardInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea strInfo=" + com.tencent.mobileqq.util.Utils.b(str));
      }
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
        break label126;
      }
      paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131436533);
      if (((TextView)localObject).getVisibility() != 0) {
        ((TextView)localObject).setVisibility(0);
      }
      ((TextView)localObject).setPadding(0, 10, 0, 0);
      ((TextView)localObject).setText(paramProfileCardInfo);
      ((TextView)localObject).setContentDescription(paramProfileCardInfo);
    }
    label126:
    do
    {
      return;
      if ((str != null) && (str.length() > 0))
      {
        if (((TextView)localObject).getVisibility() != 0) {
          ((TextView)localObject).setVisibility(0);
        }
        ((TextView)localObject).setPadding(0, 0, 0, 0);
        ((TextView)localObject).setText(str);
        ((TextView)localObject).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131427360) + ":" + str);
        ((TextView)localObject).setClickable(true);
        return;
      }
    } while (((TextView)localObject).getVisibility() == 8);
    ((TextView)localObject).setVisibility(8);
  }
  
  public void c(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
    if ((localObject instanceof ImageView))
    {
      localObject = (ImageView)localObject;
      if (!ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        ((ImageView)localObject).setVisibility(4);
        this.jdField_a_of_type_Long = 0L;
      }
    }
    else
    {
      return;
    }
    ThreadManager.post(new agdh(this, paramProfileCardInfo, paramBoolean), 8, null, true);
  }
  
  public void d(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!ProfileActivity.AllInOne.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))) {}
    label31:
    Object localObject2;
    View localView1;
    View localView2;
    View localView3;
    do
    {
      do
      {
        do
        {
          break label31;
          break label31;
          do
          {
            return;
          } while ((paramProfileCardInfo.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramProfileCardInfo.d)));
          if (SharedPreUtils.al(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) == 1) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(jdField_a_of_type_JavaLangString, 2, "medal config off");
        return;
        localObject2 = (TextView)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_medal_num");
        localView1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_medal_container");
        localView2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_nick_name");
        if (localObject2 != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "medalNum is null");
      return;
      localView3 = (View)localView2.getParent();
      if (localView3.getWidth() != 0) {
        break;
      }
      this.j += 1;
      if (this.j <= 5)
      {
        localView3.requestLayout();
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1004);
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "medal view nick width is zero!!");
    return;
    this.j = 0;
    RedTouch localRedTouch = (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_medal_increment");
    Object localObject1 = null;
    Object localObject3 = (LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    RedTouchItem localRedTouchItem = ((LocalRedTouchManager)localObject3).a(10016);
    int m;
    if (((LocalRedTouchManager)localObject3).a(localRedTouchItem, false))
    {
      m = 1;
      k = m;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "update head icon red point: " + localRedTouchItem.redtouchType);
      }
    }
    boolean bool;
    for (int k = m;; k = 0)
    {
      if ((!paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.medalSwitchDisable) && (!com.tencent.mobileqq.util.Utils.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label469;
      }
      ((TextView)localObject2).setVisibility(8);
      bool = false;
      paramProfileCardInfo = (ProfileCardInfo)localObject1;
      localRedTouch.a(paramProfileCardInfo);
      if ((localView2 instanceof TextView))
      {
        k = AIOUtils.a(4.0F, getResources());
        if (!bool) {
          break label962;
        }
        localView1.measure(-2147483248, localView3.getHeight() | 0x80000000);
        k = localView1.getMeasuredWidth() + k;
        label420:
        localView2.setPadding(0, 0, k, 0);
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 4, String.format(Locale.getDefault(), "updateMedal show: %s", new Object[] { Boolean.valueOf(bool) }));
      return;
    }
    label469:
    ((TextView)localObject2).setVisibility(0);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      localObject1 = String.format(Locale.getDefault(), "%d枚", new Object[] { Integer.valueOf(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iMedalCount - paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iNewCount) });
    }
    for (;;)
    {
      try
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iNewCount > 0)
        {
          k = AIOUtils.a(5.0F, getResources());
          localView1.setPadding(0, AIOUtils.a(10.0F, getResources()), k, 0);
          localRedTouch.b(0).a();
          localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(4);
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.set(String.format(Locale.getDefault(), "+%d", new Object[] { Integer.valueOf(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iNewCount) }));
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_desc.set("{'cn':'#FF0000', 'av':1}");
          localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sex_age_area");
          if ((localObject2 != null) && ((((View)localObject2).getLayoutParams() instanceof RelativeLayout.LayoutParams)) && ((this instanceof ProfilePhotoView)))
          {
            localObject3 = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.a(5.0F, getResources());
            ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          }
          localView1.setContentDescription(String.format(Locale.getDefault(), "勋章%d枚", new Object[] { Integer.valueOf(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iMedalCount - paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iNewCount) }));
          paramProfileCardInfo = (ProfileCardInfo)localObject1;
          bool = true;
        }
      }
      catch (ConcurrentModificationException localConcurrentModificationException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, localConcurrentModificationException.getMessage());
        }
        localObject1 = this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(1005, localObject1);
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendMessage((Message)localObject1);
        continue;
        if (k != 0) {
          break label819;
        }
      }
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iUpgradeCount > 0)
      {
        label819:
        localView1.setPadding(0, 0, AIOUtils.a(4.0F, getResources()), 0);
        localRedTouch.b(15).a();
        localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(0);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.set("");
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_desc.set("");
        continue;
        localConcurrentModificationException.setText(String.format(Locale.getDefault(), "%d枚", new Object[] { Integer.valueOf(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iMedalCount) }));
        localView1.setContentDescription(String.format(Locale.getDefault(), "勋章%d枚", new Object[] { Integer.valueOf(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iMedalCount) }));
        bool = true;
        paramProfileCardInfo = (ProfileCardInfo)localObject1;
        break;
        label962:
        break label420;
      }
      localObject1 = null;
    }
  }
  
  public void e(ProfileCardInfo paramProfileCardInfo)
  {
    this.h &= 0xFFFFFFFE;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_net_voice");
    if (localView == null) {
      localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130970969, null);
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (!paramProfileCardInfo.jdField_b_of_type_Boolean) && (ProfileActivity.AllInOne.c(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
      {
        if (!ProfileActivity.AllInOne.h(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          break label613;
        }
        localObject1 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        if (localObject1 != null)
        {
          if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
            break label1069;
          }
          localObject2 = (ProfileActivity.CardContactInfo)paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
          if (localObject2 == null) {
            break label283;
          }
          paramProfileCardInfo = ((ProfileActivity.CardContactInfo)localObject2).b + ((ProfileActivity.CardContactInfo)localObject2).c;
          if (TextUtils.isEmpty(paramProfileCardInfo)) {
            break label1069;
          }
        }
      }
      label283:
      label294:
      label1069:
      for (paramProfileCardInfo = ((PhoneContactManager)localObject1).c(paramProfileCardInfo);; paramProfileCardInfo = null)
      {
        int k;
        if (paramProfileCardInfo != null)
        {
          k = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          if ((2 != k) && (k != 0)) {
            break label294;
          }
          this.h &= 0xFFFFFFFE;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip not show netvoice tip local network: " + k);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          d();
          this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips_net_voice", localView);
          return;
          paramProfileCardInfo = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          break;
          if ((paramProfileCardInfo.iTermType == 68104) || (paramProfileCardInfo.iTermType == 65805))
          {
            this.h &= 0xFFFFFFFE;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip not show netvoice tip friend iTermType=" + paramProfileCardInfo.iTermType);
            }
          }
          else if ((paramProfileCardInfo.abilityBits & 1L) != 0L)
          {
            k = paramProfileCardInfo.eNetworkType;
            paramProfileCardInfo = (TextView)localView.findViewById(2131372401);
            localObject1 = a(k);
            if (k == 2)
            {
              paramProfileCardInfo.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130842987), null, null, null);
              paramProfileCardInfo.setCompoundDrawablePadding((int)DisplayUtils.a(getContext(), 4.0F));
            }
            if ((paramProfileCardInfo != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
              paramProfileCardInfo.setText((CharSequence)localObject1);
            }
            this.h |= 0x1;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip has ability --> show tip , net " + k + " from contact card");
            }
          }
          else if ((paramProfileCardInfo.ability & 0x2) != 0)
          {
            localObject1 = (TextView)localView.findViewById(2131372401);
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435784);
            if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
              ((TextView)localObject1).setText((CharSequence)localObject2);
            }
            this.h |= 0x1;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip-->show PC has camera,state=" + paramProfileCardInfo.eNetworkType + "from contact card");
            }
          }
        }
        label613:
        localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        if (localObject1 != null)
        {
          paramProfileCardInfo = ((FriendsManager)localObject1).c(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          k = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          if ((2 != k) && (k != 0)) {
            break label721;
          }
          this.h &= 0xFFFFFFFE;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip not show netvoice tip local network: " + k);
          }
        }
        label960:
        for (;;)
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          d();
          break;
          label721:
          if ((paramProfileCardInfo != null) && ((paramProfileCardInfo.iTermType == 68104) || (paramProfileCardInfo.iTermType == 65805)))
          {
            this.h &= 0xFFFFFFFE;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip not show netvoice tip friend iTermType=" + paramProfileCardInfo.iTermType);
            }
          }
          else if ((paramProfileCardInfo != null) && ((paramProfileCardInfo.abilityBits & 1L) != 0L))
          {
            localObject1 = (TextView)localView.findViewById(2131372401);
            k = paramProfileCardInfo.getNetWorkType();
            localObject2 = a(k);
            if ((k == 2) && (localObject1 != null))
            {
              ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130842987), null, null, null);
              ((TextView)localObject1).setCompoundDrawablePadding((int)DisplayUtils.a(getContext(), 4.0F));
            }
            if (ContactUtils.a(paramProfileCardInfo)) {}
            for (this.h = 0;; this.h |= 0x1)
            {
              if (!QLog.isColorLevel()) {
                break label960;
              }
              QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip has ability,show tip.net=" + paramProfileCardInfo.getNetWorkType());
              break;
              if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
                ((TextView)localObject1).setText((CharSequence)localObject2);
              }
            }
          }
          else if ((paramProfileCardInfo != null) && ((paramProfileCardInfo.abilityBits & 0x2) != 0L))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip-->show PC has camera,state=" + paramProfileCardInfo.status);
            }
            paramProfileCardInfo = (TextView)localView.findViewById(2131372401);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435784);
            if ((paramProfileCardInfo != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
              paramProfileCardInfo.setText((CharSequence)localObject1);
            }
            this.h |= 0x1;
          }
        }
      }
    }
  }
  
  public void g(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramProfileCardInfo.d))) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    } while (!(localObject1 instanceof VoteView));
    VoteView localVoteView = (VoteView)localObject1;
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {}
    for (boolean bool1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.isShowZan();; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateLike type isShowVote = " + String.valueOf(bool1));
      }
      if (bool1)
      {
        if ((localVoteView.getVisibility() != 0) && (!this.jdField_a_of_type_Boolean)) {
          localVoteView.setVisibility(0);
        }
        boolean bool2;
        Object localObject2;
        int m;
        int k;
        if ((paramProfileCardInfo != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null))
        {
          bool2 = com.tencent.av.opengl.utils.Utils.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          if ((paramProfileCardInfo != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
            break label248;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131427383);
          localObject2 = null;
          m = 0;
          k = 0;
          bool1 = false;
          label198:
          localVoteView.a(bool2, bool1, k, m, this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper, false);
          localVoteView.setTag(localObject2);
          if (paramProfileCardInfo == null) {
            break label490;
          }
          localVoteView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        for (;;)
        {
          localVoteView.setContentDescription((CharSequence)localObject1);
          return;
          bool2 = false;
          break;
          label248:
          if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper == null) {
            this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper = new NewVoteAnimHelper(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 1);
          }
          m = (int)paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
          k = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement;
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getLastPraiseInfoList();
          if (k <= this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a.size()) {
            this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a = this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a.subList(0, k);
          }
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a = PraiseConfigHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a);
          if (1 == paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {}
          for (bool1 = true;; bool1 = false)
          {
            if (!bool2) {
              break label438;
            }
            localObject2 = new DataTag(10, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
            localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131427382), new Object[] { String.valueOf(m) });
            n = k;
            k = m;
            m = n;
            break;
          }
          label438:
          localObject2 = new DataTag(10, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
          localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131427381), new Object[] { String.valueOf(m) });
          int n = k;
          k = m;
          m = n;
          break label198;
          label490:
          localVoteView.setOnClickListener(null);
        }
      }
      localVoteView.setVisibility(4);
      return;
    }
  }
  
  @TargetApi(16)
  public void h(ProfileCardInfo paramProfileCardInfo)
  {
    View localView1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tag_jueban");
    View localView2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if (((localView1 instanceof TextView)) && (localView2 != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.isShowZan()) && (ProfileCardUtil.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray())))
    {
      String str = "1";
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
        str = "0";
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "card_mall", "0X8007A47", 0, 0, str, "", "", "");
      localView2.getViewTreeObserver().addOnGlobalLayoutListener(new agda(this, localView2, localView1, paramProfileCardInfo));
    }
  }
  
  public void i(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_nick_name");
    TextView localTextView;
    Object localObject2;
    if ((localObject1 instanceof TextView))
    {
      localTextView = (TextView)localObject1;
      localObject1 = null;
      localObject2 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
      if (paramProfileCardInfo.jdField_b_of_type_Boolean)
      {
        localObject2 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramProfileCardInfo.d, ((ProfileActivity.AllInOne)localObject2).jdField_a_of_type_JavaLangString);
        ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_troop_member_rank_title");
        paramProfileCardInfo = (ProfileCardInfo)localObject1;
        if (localViewGroup != null)
        {
          paramProfileCardInfo = (TextView)localViewGroup.findViewById(2131372359);
          a(localViewGroup, paramProfileCardInfo);
        }
        localTextView.setText((CharSequence)localObject2);
        localTextView.setContentDescription((CharSequence)localObject2);
        a(localTextView, paramProfileCardInfo, (String)localObject2);
      }
    }
    else
    {
      return;
    }
    localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "updateHead titleName = " + com.tencent.mobileqq.util.Utils.b((String)localObject1));
    }
    if (localObject1 != null)
    {
      paramProfileCardInfo = (ProfileCardInfo)localObject1;
      if (((String)localObject1).length() != 0) {}
    }
    else
    {
      if (!ProfileActivity.AllInOne.a((ProfileActivity.AllInOne)localObject2)) {
        break label255;
      }
    }
    label255:
    for (paramProfileCardInfo = String.valueOf(((ProfileActivity.AllInOne)localObject2).jdField_a_of_type_JavaLangString);; paramProfileCardInfo = " ")
    {
      localTextView.setText(paramProfileCardInfo);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131427355) + ":";
      localTextView.setContentDescription((String)localObject1 + paramProfileCardInfo);
      return;
    }
  }
  
  public void j(ProfileCardInfo paramProfileCardInfo)
  {
    this.h &= 0xFFFFFFFD;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
    if (localView == null) {
      localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130970956, null);
    }
    for (;;)
    {
      if ((localView == null) || (paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null))
      {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        d();
        return;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips_set_card", localView);
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        long l1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId;
        long l2 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId;
        int k = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet;
        Object localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "updateSetCardBar bgtype = " + localObject1);
        }
        localObject1 = getResources();
        TextView localTextView = (TextView)localView.findViewById(2131362857);
        ImageView localImageView = (ImageView)localView.findViewById(2131370853);
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        boolean bool = false;
        if (localObject2 != null) {
          bool = ((SharedPreferences)localObject2).getBoolean("svip_profile_use_guide_shown_flag", false);
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "isShowTips" + bool + ",templateRet=" + k + ",myTemplateId=" + l1);
        }
        if (((101107 == k) || (101108 == k)) && (!bool) && (localObject2 != null))
        {
          ((SharedPreferences)localObject2).edit().putBoolean("svip_profile_use_guide_shown_flag", true).commit();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
          if (101107 != k) {
            break label460;
          }
        }
        label460:
        for (localObject1 = ((Resources)localObject1).getString(2131436925);; localObject1 = ((Resources)localObject1).getString(2131436926))
        {
          localObject1 = ((BaseActivity)localObject2).getString(2131436924, new Object[] { localObject1 });
          localTextView.setText((CharSequence)localObject1);
          localImageView.setContentDescription((CharSequence)localObject1);
          localView.setTag(new DataTag(24, Integer.valueOf(k)));
          localView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          this.h |= 0x2;
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          d();
          return;
        }
      }
      ThreadManager.post(new ProfileHeaderView.UpdateProfileSetCardTask(this), 5, null, true);
      return;
    }
  }
  
  public void k(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips");
    }
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips");
    LinearLayout localLinearLayout;
    if ((localObject instanceof LinearLayout))
    {
      localLinearLayout = (LinearLayout)localObject;
      if (((this.h & 0x1) == 0) || ((this.h & 0x2) == 0)) {
        break label241;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips netvoice and setcard");
      }
      paramProfileCardInfo = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_net_voice");
      localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
      if ((paramProfileCardInfo != null) && (localObject != null))
      {
        if (localLinearLayout.getChildCount() != 0) {
          break label171;
        }
        localLinearLayout.addView(paramProfileCardInfo);
        localLinearLayout.setVisibility(0);
        if (this.jdField_c_of_type_Int < 4)
        {
          this.jdField_c_of_type_Int += 1;
          paramProfileCardInfo = this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(jdField_d_of_type_Int);
          this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendMessageDelayed(paramProfileCardInfo, 4000L);
        }
      }
    }
    label171:
    label241:
    do
    {
      do
      {
        do
        {
          do
          {
            View localView;
            do
            {
              return;
              localView = localLinearLayout.getChildAt(0);
            } while (localView == null);
            if (localView.getId() == 2131372400) {
              paramProfileCardInfo = (ProfileCardInfo)localObject;
            }
            for (;;)
            {
              localObject = AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131034359);
              ((Animation)localObject).setFillAfter(true);
              ((Animation)localObject).setAnimationListener(new agdg(this, localLinearLayout, paramProfileCardInfo));
              localLinearLayout.setVisibility(0);
              localView.startAnimation((Animation)localObject);
              return;
            }
            if ((this.h & 0x1) == 0) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips netvoice");
            }
            paramProfileCardInfo = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_net_voice");
          } while (paramProfileCardInfo == null);
          localLinearLayout.removeAllViews();
          localLinearLayout.addView(paramProfileCardInfo);
          localLinearLayout.setVisibility(0);
          return;
          if ((this.h & 0x2) == 0) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips setcard");
          }
          paramProfileCardInfo = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
        } while (paramProfileCardInfo == null);
        localLinearLayout.removeAllViews();
        localLinearLayout.addView(paramProfileCardInfo);
        localLinearLayout.setVisibility(0);
        return;
      } while ((paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.h));
      localLinearLayout.setVisibility(8);
      paramProfileCardInfo = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_space_view");
    } while (paramProfileCardInfo == null);
    localObject = (RelativeLayout.LayoutParams)paramProfileCardInfo.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height += ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 18);
    paramProfileCardInfo.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramProfileCardInfo.setFocusable(true);
    paramProfileCardInfo.setFocusableInTouchMode(true);
  }
  
  public void l(ProfileCardInfo paramProfileCardInfo) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
    boolean bool;
    label57:
    int m;
    int k;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      bool = true;
      if (bool) {
        break label204;
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      m = 2;
      k = MedalWallMng.jdField_b_of_type_Int;
    }
    for (;;)
    {
      localIntent.putExtra("url", ((MedalWallMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249)).a(bool, paramView, k));
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 1027);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800738D", "0X800738D", m, 0, "", "", "", "");
      if (!bool) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iNewCount = 0;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iUpgradeCount = 0;
      ThreadManager.post(new agdi(this), 5, null, true);
      return;
      bool = false;
      break label57;
      label204:
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      m = ((LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).a();
      k = MedalWallMng.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iNewCount > 0)
      {
        m = 4;
        k = MedalWallMng.jdField_c_of_type_Int;
      }
    }
  }
  
  public void setShoppingBgBlur(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView
 * JD-Core Version:    0.7.0.1
 */