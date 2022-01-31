package com.tencent.mobileqq.profile.view;

import aekt;
import android.app.Activity;
import android.content.res.Resources;
import android.support.annotation.NonNull;
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
import aoqo;
import aoqp;
import apek;
import awki;
import awmk;
import awog;
import awrh;
import azmj;
import bcun;
import bcuo;
import bcyw;
import bdwu;
import bdwv;
import bdxa;
import bdxe;
import bkba;
import bkbk;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vip.diy.ETTextViewPlus;
import com.tencent.mobileqq.vip.diy.TemplateLikeView;
import com.tencent.mobileqq.widget.ProfileCardExtendFriendView;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PullToZoomHeaderListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wsv;
import xmh;
import xod;

public class ProfileQVipDiyView
  extends ProfileHeaderView
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new awrh(this);
  private View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private bdwu jdField_a_of_type_Bdwu;
  private bdxa jdField_a_of_type_Bdxa;
  private bkbk jdField_a_of_type_Bkbk;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  private ProfileCardMoreInfoView jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView;
  private PullToZoomHeaderListView jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "map_key_account_base_info", "map_key_tag", "map_key_sig", "map_key_phone", "map_key_account_level_info", "map_key_medal_and_diamond", "map_key_qzone", "map_key_mine_weishi", "map_key_photo_wall", "map_key_personality_label_board", "map_key_extend_friend_info", "map_key_favor" };
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private HashMap<String, View> jdField_b_of_type_JavaUtilHashMap;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString = "";
  private HashMap<String, View> jdField_c_of_type_JavaUtilHashMap;
  private int g;
  
  public ProfileQVipDiyView(@NonNull BaseActivity paramBaseActivity, @NonNull awmk paramawmk, @NonNull PullToZoomHeaderListView paramPullToZoomHeaderListView, @NonNull ViewGroup paramViewGroup, @NonNull FrameLayout paramFrameLayout, @NonNull ProfileCardMoreInfoView paramProfileCardMoreInfoView)
  {
    this(paramBaseActivity, paramawmk, paramPullToZoomHeaderListView, paramViewGroup, paramFrameLayout, paramProfileCardMoreInfoView, false);
  }
  
  public ProfileQVipDiyView(@NonNull BaseActivity paramBaseActivity, @NonNull awmk paramawmk, @NonNull PullToZoomHeaderListView paramPullToZoomHeaderListView, @NonNull ViewGroup paramViewGroup, @NonNull FrameLayout paramFrameLayout, @NonNull ProfileCardMoreInfoView paramProfileCardMoreInfoView, boolean paramBoolean)
  {
    super(paramBaseActivity, paramawmk);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView = paramProfileCardMoreInfoView;
    this.jdField_b_of_type_JavaUtilHashMap = paramProfileCardMoreInfoView.a();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = paramPullToZoomHeaderListView;
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_Apek = new apek(paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 1);
    d(paramawmk);
    a(paramawmk);
  }
  
  private void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    if (!aoqp.c().a) {}
    while (!bcyw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.uin)) {
      return;
    }
    bcyw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)LayoutInflater.from(paramActivity).inflate(2131561804, paramViewGroup, false));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(aekt.a(350.0F, paramActivity.getResources()), aekt.a(44.0F, paramActivity.getResources()));
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(2, 2131372286);
    localLayoutParams.bottomMargin = aekt.a(4.0F, paramActivity.getResources());
    paramViewGroup.addView(this.jdField_a_of_type_AndroidViewViewGroup, localLayoutParams);
    paramActivity = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374113);
    paramViewGroup = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374112);
    paramActivity.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qvip", "0X8009E7A", 0, 0, "", "", "", "");
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
  
  private void a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("body");
    if (localJSONObject == null) {
      throw new JSONException("json have no body!! " + paramJSONObject);
    }
    this.g = localJSONObject.optInt("ts", 0);
    this.jdField_a_of_type_Bdxa = bdxe.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localJSONObject, this.jdField_a_of_type_Awmk, this.jdField_c_of_type_JavaLangString);
  }
  
  private void b(awmk paramawmk, boolean paramBoolean, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if ("map_key_extend_friend_info".equals(paramVarArgs[i])) {
        for (;;)
        {
          try
          {
            paramVarArgs = (ProfileCardExtendFriendView)((ProfileCardFavorShowView)this.jdField_c_of_type_JavaUtilHashMap.get("map_key_extend_friend_info")).a(0);
            if (paramVarArgs.a() == null) {
              break;
            }
            if (paramVarArgs.a().getText() == null) {
              return;
            }
            paramBoolean = paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.declaration.equals(paramVarArgs.a().getText());
            if (paramBoolean) {
              continue;
            }
            paramBoolean = true;
          }
          catch (Exception paramVarArgs)
          {
            wsv.d("DIYProfileTemplate.ProfileQVipDiyView", "update the expand info view, we rebuild it! but occur error:" + paramVarArgs);
            paramBoolean = false;
            continue;
          }
          wsv.d("DIYProfileTemplate.ProfileQVipDiyView", "update the expand info view, we rebuild it :" + paramBoolean);
          if (!paramBoolean) {
            break;
          }
          this.jdField_a_of_type_Bdxa.a(this.jdField_c_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramawmk, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.f);
          return;
          paramBoolean = false;
        }
      }
      i += 1;
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.opt("header");
    if ((localObject instanceof JSONObject))
    {
      this.jdField_a_of_type_Bkbk = bkba.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a((JSONObject)localObject, this.jdField_b_of_type_AndroidWidgetFrameLayout, true, new bdwv(this.jdField_a_of_type_JavaUtilHashMap, this.jdField_c_of_type_JavaLangString));
      return;
    }
    if ((localObject instanceof JSONArray))
    {
      this.jdField_a_of_type_Bkbk = bkba.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a((JSONArray)localObject, this.jdField_b_of_type_AndroidWidgetFrameLayout, true, new bdwv(this.jdField_a_of_type_JavaUtilHashMap, this.jdField_c_of_type_JavaLangString));
      return;
    }
    xmh.a("header is illegal :" + paramJSONObject, new Object[0]);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    if (paramJSONObject == null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130845286);
      return;
    }
    JSONObject localJSONObject = paramJSONObject.optJSONObject("bg");
    if (localJSONObject != null)
    {
      this.jdField_a_of_type_Bdwu = bdwu.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a(this.jdField_a_of_type_AndroidWidgetFrameLayout).a(localJSONObject);
      return;
    }
    paramJSONObject = paramJSONObject.optJSONArray("bg");
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_Bdwu = bdwu.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a(this.jdField_a_of_type_AndroidWidgetFrameLayout).a(paramJSONObject);
      return;
    }
    wsv.e("DIYProfileTemplate.ProfileQVipDiyView", "this json have no background!");
  }
  
  private void f()
  {
    wsv.e("DIYProfileTemplate.ProfileQVipDiyView", "init head UI");
    this.jdField_a_of_type_AndroidViewView = ((View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_diy_nick_container"));
    Object localObject;
    if ((this.jdField_a_of_type_AndroidViewView instanceof FrameLayout))
    {
      AvatarLayout localAvatarLayout = (AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368231);
      localAvatarLayout.setVisibility(0);
      awki localawki = new awki(1, null);
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691238);
        localAvatarLayout.setTag(localawki);
        localAvatarLayout.setOnClickListener(this.jdField_a_of_type_Awmk.jdField_a_of_type_AndroidViewView$OnClickListener);
        localAvatarLayout.setContentDescription((CharSequence)localObject);
        localAvatarLayout.a(0, localAvatarLayout.findViewById(2131363115), false);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", localAvatarLayout);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", this.jdField_a_of_type_AndroidViewView.findViewById(2131368235));
        localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368067);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", localObject);
        ((ImageView)localObject).setVisibility(8);
        ((ImageView)localObject).setTag(localawki);
        ((ImageView)localObject).setOnClickListener(this.jdField_a_of_type_Awmk.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_nick_name"));
      if (!(this.jdField_b_of_type_AndroidViewView instanceof ProfileNameView)) {
        break label342;
      }
      localObject = (ProfileNameView)this.jdField_b_of_type_AndroidViewView;
      ((ProfileNameView)localObject).setVisibility(0);
      ((ProfileNameView)localObject).setClickable(true);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView = ((View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like"));
      if (!(this.jdField_c_of_type_AndroidViewView instanceof TemplateLikeView)) {
        break label389;
      }
      localObject = (TemplateLikeView)this.jdField_c_of_type_AndroidViewView;
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setVisibility(0);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_c_of_type_AndroidViewView);
      ((TemplateLikeView)localObject).setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691237);
      break;
      label342:
      if ((this.jdField_b_of_type_AndroidViewView instanceof ETTextViewPlus))
      {
        localObject = (ETTextViewPlus)this.jdField_b_of_type_AndroidViewView;
        ((ETTextViewPlus)localObject).setTextSize(20.0F);
        this.jdField_a_of_type_Bdxa.a((ETTextView)localObject);
        ((ETTextViewPlus)localObject).setVisibility(0);
        ((ETTextViewPlus)localObject).setClickable(true);
      }
    }
    label389:
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setVisibility(8);
  }
  
  public int a()
  {
    return xod.a(getContext(), 23.0F);
  }
  
  public ProfileCardFavorShowView a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Bdxa != null) {
      return this.jdField_a_of_type_Bdxa.a(paramActivity);
    }
    return new ProfileCardFavorShowView(paramActivity);
  }
  
  public List<View> a(HashMap<String, View> paramHashMap, String[] paramArrayOfString)
  {
    return this.jdField_a_of_type_Bdxa.a(paramHashMap, paramArrayOfString);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Bkbk.f();
  }
  
  public void a(awmk paramawmk)
  {
    this.jdField_b_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    int i = getResources().getDimensionPixelSize(2131296956);
    int j = bcyw.a(getResources());
    j = (int)this.jdField_c_of_type_Float - bcyw.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 18) - i - j;
    i = j;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = j + ImmersiveUtils.getStatusBarHeight(getContext());
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, i);
    addView(this.jdField_b_of_type_AndroidWidgetFrameLayout, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = new HeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, i);
    addView(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setVisibility(8);
    super.a(paramawmk);
  }
  
  public void a(awmk paramawmk, long paramLong, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteViewV2))
    {
      localObject = (VoteViewV2)localObject;
      long l = paramLong;
      if (paramLong == -1L) {
        l = ((VoteViewV2)localObject).e;
      }
      if ((paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0)) {
        ((VoteViewV2)localObject).a();
      }
      ((VoteViewV2)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteViewV2)localObject).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691209), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void a(awmk paramawmk, boolean paramBoolean)
  {
    wsv.d("DIYProfileTemplate.ProfileQVipDiyView", "自定义资料卡update isNetRet=" + paramBoolean);
    if ((this.jdField_b_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      f();
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      wsv.d("DIYProfileTemplate.ProfileQVipDiyView", "自定义资料卡update 头像");
      a(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      b(paramawmk, false);
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      wsv.d("DIYProfileTemplate.ProfileQVipDiyView", "自定义资料卡update 昵称");
      f(paramawmk);
    }
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      wsv.d("DIYProfileTemplate.ProfileQVipDiyView", "自定义资料卡update 点赞");
      e(paramawmk);
    }
  }
  
  public void a(awmk paramawmk, boolean paramBoolean, String... paramVarArgs)
  {
    b(paramawmk, paramBoolean, paramVarArgs);
    paramawmk = this.jdField_c_of_type_JavaUtilHashMap.keySet().iterator();
    while (paramawmk.hasNext())
    {
      paramVarArgs = (String)paramawmk.next();
      this.jdField_b_of_type_JavaUtilHashMap.put(paramVarArgs, this.jdField_c_of_type_JavaUtilHashMap.get(paramVarArgs));
    }
  }
  
  public void a(String paramString, TextView paramTextView, View paramView, ImageView paramImageView)
  {
    this.jdField_a_of_type_Bdxa.a(paramString, paramTextView, paramView, paramImageView);
  }
  
  @NonNull
  public int b()
  {
    if (this.g == 0) {
      return 2131166604;
    }
    return 2131166466;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_Bkbk.e();
  }
  
  public void b(awmk paramawmk, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
    if ((localObject instanceof ImageView))
    {
      localObject = (ImageView)localObject;
      if (!ProfileActivity.AllInOne.g(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        ((ImageView)localObject).setVisibility(4);
        this.jdField_a_of_type_Long = 0L;
      }
    }
    else
    {
      return;
    }
    ThreadManager.post(new ProfileQVipDiyView.1(this, paramawmk, (ImageView)localObject, paramBoolean), 8, null, true);
  }
  
  public void c()
  {
    super.c();
    QLog.e("DIYProfileTemplate.ProfileQVipDiyView", 1, "profileQvipDiyView destroy");
    if (this.jdField_a_of_type_Bdwu != null) {
      this.jdField_a_of_type_Bdwu.a();
    }
    if (this.jdField_a_of_type_Bkbk != null) {
      this.jdField_a_of_type_Bkbk.c();
    }
    if (this.jdField_b_of_type_JavaUtilHashMap != null) {
      this.jdField_b_of_type_JavaUtilHashMap.clear();
    }
    a(this.jdField_b_of_type_AndroidViewViewGroup);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) {
      ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).i(1);
    }
  }
  
  public void d(awmk paramawmk) {}
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.diyComplicatedInfo;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      wsv.e("DIYProfileTemplate.ProfileQVipDiyView", " diy info is null!");
      throw new RuntimeException("diy info is null!");
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("path", "");
      c((JSONObject)localObject);
      b((JSONObject)localObject);
      a((JSONObject)localObject);
      this.jdField_a_of_type_Bdxa.a(this.jdField_c_of_type_JavaUtilHashMap);
      this.jdField_a_of_type_Bdxa.b(this.jdField_c_of_type_JavaUtilHashMap);
      this.jdField_a_of_type_Bdxa.a(this.jdField_c_of_type_JavaUtilHashMap, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard);
      this.jdField_a_of_type_Bdxa.a(this.jdField_c_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Awmk, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView);
      this.jdField_a_of_type_Bdxa.a(this.jdField_c_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Awmk);
      this.jdField_a_of_type_Bdxa.a(this.jdField_c_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Awmk, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.f);
      a(this.jdField_a_of_type_Awmk, false, this.jdField_a_of_type_ArrayOfJavaLangString);
      d();
      f();
      a(this.jdField_a_of_type_Awmk, false);
      if (!this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_AndroidViewViewGroup);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      throw new RuntimeException("diy info is illegal :" + localJSONException);
    }
  }
  
  public void e(awmk paramawmk)
  {
    if ((paramawmk.b) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramawmk.jdField_a_of_type_JavaLangString))) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    } while (!(localObject1 instanceof VoteViewV2));
    VoteViewV2 localVoteViewV2 = (VoteViewV2)localObject1;
    boolean bool1 = a(paramawmk);
    boolean bool2 = TextUtils.equals(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (bool1)
    {
      localVoteViewV2.setVisibility(0);
      Object localObject2;
      int j;
      int i;
      if (paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard == null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691285);
        localObject2 = null;
        j = 0;
        bool1 = false;
        i = 0;
      }
      for (;;)
      {
        localVoteViewV2.a(bool2, bool1, i, j, this.jdField_a_of_type_Apek, false);
        localVoteViewV2.setTag(localObject2);
        localVoteViewV2.setOnClickListener(paramawmk.jdField_a_of_type_AndroidViewView$OnClickListener);
        localVoteViewV2.setContentDescription((CharSequence)localObject1);
        return;
        if (this.jdField_a_of_type_Apek == null) {
          this.jdField_a_of_type_Apek = new apek(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 1);
        }
        i = (int)paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
        j = paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement;
        if (1 == paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {}
        for (bool1 = true;; bool1 = false)
        {
          this.jdField_a_of_type_Apek.a = paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.getLastPraiseInfoList();
          if (j <= this.jdField_a_of_type_Apek.a.size()) {
            this.jdField_a_of_type_Apek.a = this.jdField_a_of_type_Apek.a.subList(0, j);
          }
          this.jdField_a_of_type_Apek.a = awog.a(this.jdField_a_of_type_Apek.a);
          if (!bool2) {
            break label340;
          }
          localObject2 = new awki(10, paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard);
          localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691283), new Object[] { String.valueOf(i) });
          break;
        }
        label340:
        localObject2 = new awki(10, paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard);
        localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691197), new Object[] { String.valueOf(i) });
        if (paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0) {
          localVoteViewV2.a();
        }
      }
    }
    localVoteViewV2.setVisibility(4);
  }
  
  public void f(awmk paramawmk)
  {
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_nick_name");
    Object localObject2;
    ProfileActivity.AllInOne localAllInOne;
    String str;
    if ((localObject1 instanceof ProfileNameView))
    {
      localObject1 = (ProfileNameView)localObject1;
      if (localObject1 != null) {
        ((ProfileNameView)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramawmk);
      }
      if ((((ProfileNameView)localObject1).a() != null) && (((ProfileNameView)localObject1).a().getVisibility() == 0))
      {
        localObject2 = ((ProfileNameView)localObject1).a();
        localAllInOne = paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
        str = paramawmk.jdField_a_of_type_Bcuo.a.jdField_a_of_type_JavaLangString;
        if (str != null)
        {
          localObject1 = str;
          if (str.length() != 0) {}
        }
        else
        {
          if (!ProfileActivity.AllInOne.a(localAllInOne)) {
            break label224;
          }
        }
      }
      label224:
      for (localObject1 = String.valueOf(localAllInOne.jdField_a_of_type_JavaLangString);; localObject1 = " ")
      {
        ((ETTextView)localObject2).setText((CharSequence)localObject1);
        ((ETTextView)localObject2).setTextSize(16.0F);
        str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691215) + ":";
        ((ETTextView)localObject2).setContentDescription(str + (String)localObject1);
        ((ETTextView)localObject2).setTag(new awki(88, ((ETTextView)localObject2).getText().toString()));
        ((ETTextView)localObject2).setOnClickListener(paramawmk.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ETTextView)localObject2).setOnLongClickListener(paramawmk.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        ((ETTextView)localObject2).requestLayout();
        return;
      }
    }
    if ((localObject1 instanceof ETTextView))
    {
      localObject2 = (ETTextView)localObject1;
      localAllInOne = paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
      str = paramawmk.jdField_a_of_type_Bcuo.a.jdField_a_of_type_JavaLangString;
      if (str != null)
      {
        localObject1 = str;
        if (str.length() != 0) {}
      }
      else
      {
        if (!ProfileActivity.AllInOne.a(localAllInOne)) {
          break label406;
        }
      }
      label406:
      for (localObject1 = String.valueOf(localAllInOne.jdField_a_of_type_JavaLangString);; localObject1 = " ")
      {
        ((ETTextView)localObject2).setText((CharSequence)localObject1);
        ((ETTextView)localObject2).setTextSize(16.0F);
        str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691215) + ":";
        ((ETTextView)localObject2).setContentDescription(str + (String)localObject1);
        ((ETTextView)localObject2).setTag(new awki(88, ((ETTextView)localObject2).getText().toString()));
        ((ETTextView)localObject2).setOnClickListener(paramawmk.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ETTextView)localObject2).setOnLongClickListener(paramawmk.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        ((ETTextView)localObject2).requestLayout();
        return;
      }
    }
    super.f(paramawmk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileQVipDiyView
 * JD-Core Version:    0.7.0.1
 */