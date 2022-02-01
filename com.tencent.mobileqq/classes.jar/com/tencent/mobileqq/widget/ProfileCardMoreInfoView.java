package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.base.container.ProfileContentContainer;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.utils.ProfileAccountInfoUtils;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.mobileqq.profilecard.vas.misc.DiyMoreInfoViewHelper;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.PrettyAccountUtil;
import com.tencent.mobileqq.vas.QidCoolTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ProfileCardMoreInfoView
  extends LinearLayout
{
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Handler jdField_a_of_type_AndroidOsHandler;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ProfileCardInfo jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo;
  private ProfileContentContainer jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileContentContainer;
  public AbsProfileHeaderView a;
  public DiyMoreInfoViewHelper a;
  private ProfileConfigHelper jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper;
  private final ProfileViewOnClickListener jdField_a_of_type_ComTencentMobileqqWidgetProfileViewOnClickListener = new ProfileViewOnClickListener(this);
  private HashMap<String, View> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean;
  private TextView[] jdField_a_of_type_ArrayOfAndroidWidgetTextView;
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "map_key_guide", "map_key_account_base_info", "map_key_account_info_v2", "map_key_tag", "map_key_sig", "map_key_phone", "map_key_troop_mem_info", "map_key_account_level_info", "map_key_diamond", "map_key_qqcircle", "map_key_qzone", "map_key_troop_mem_game_info", "map_key_fans_info", "map_key_present", "map_key_music_box", "map_key_mine_weishi", "map_key_photo_wall", "map_key_personality_label", "map_key_anonymous", "map_key_life_achievement", "map_key_extend_friend", "map_key_favor", "map_key_mini_playing", "map_key_sticky_note" };
  private float jdField_b_of_type_Float;
  private HashMap<String, String> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  public boolean b;
  private final String[] jdField_b_of_type_ArrayOfJavaLangString = { "map_key_diamond", "map_key_troop_mem_info" };
  private float jdField_c_of_type_Float;
  public boolean c;
  private final String[] jdField_c_of_type_ArrayOfJavaLangString = { "map_key_troop_mem_info", "map_key_account_level_info", "map_key_sig", "map_key_diamond", "map_key_qzone", "map_key_present", "map_key_music_box", "map_key_mine_weishi", "map_key_photo_wall" };
  private float d;
  private float e;
  
  public ProfileCardMoreInfoView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqProfilecardVasMiscDiyMoreInfoViewHelper = new DiyMoreInfoViewHelper();
    a(paramContext);
  }
  
  public ProfileCardMoreInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqProfilecardVasMiscDiyMoreInfoViewHelper = new DiyMoreInfoViewHelper();
    a(paramContext);
  }
  
  private ViewGroup a(ViewGroup paramViewGroup, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    if ((paramViewGroup != null) && (paramInt1 > 0) && (!TextUtils.isEmpty(paramCharSequence)))
    {
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561498, null);
      Object localObject = localViewGroup.findViewById(2131368603);
      TextView localTextView = (TextView)localViewGroup.findViewById(2131369051);
      ((View)localObject).setBackgroundResource(paramInt1);
      if (a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo))
      {
        paramInt1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lhLevel;
        if (!a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo)) {
          break label274;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
        label102:
        if (!(paramCharSequence instanceof String)) {
          break label281;
        }
      }
      label274:
      label281:
      for (paramCharSequence = PrettyAccountUtil.a(PrettyAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard), paramInt1, ((String)paramCharSequence).trim(), (String)localObject);; paramCharSequence = PrettyAccountUtil.a(PrettyAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard), paramInt1, paramCharSequence, (String)localObject))
      {
        localTextView.setText(paramCharSequence);
        PrettyAccountUtil.a(localTextView, PrettyAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard), paramInt1);
        paramViewGroup.addView(localViewGroup);
        if (paramInt2 == 1) {
          LongClickCopyAction.attachCopyAction(localTextView);
        }
        if (PrettyAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard) != 1) {
          a("map_key_phone", null, localTextView, null);
        }
        paramViewGroup = (QidCoolTextView)localViewGroup.findViewById(2131374422);
        paramViewGroup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        paramViewGroup.setTag(new DataTag(105, null));
        paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        if (!paramViewGroup.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo)) {
          a("map_key_phone", null, paramViewGroup, null);
        }
        return localViewGroup;
        paramInt1 = -1;
        break;
        localObject = "";
        break label102;
      }
    }
    return null;
  }
  
  private ViewGroup a(ViewGroup paramViewGroup, ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if ((paramViewGroup == null) || (paramCardContactInfo == null)) {
      return null;
    }
    String str = paramCardContactInfo.c;
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561499, null);
    View localView = localViewGroup.findViewById(2131369351);
    TextView localTextView = (TextView)localViewGroup.findViewById(2131369051);
    ImageView localImageView = (ImageView)localViewGroup.findViewById(2131363027);
    localView.setVisibility(0);
    localView.setBackgroundResource(2130846102);
    localTextView.setText(str);
    paramViewGroup.addView(localViewGroup);
    str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691372);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) {}
    for (paramViewGroup = paramCardContactInfo.c;; paramViewGroup = paramCardContactInfo.jdField_a_of_type_JavaLangString + " " + paramCardContactInfo.c)
    {
      LongClickCopyAction.attachCopyAction(localTextView, str, paramViewGroup);
      a("map_key_phone", null, localTextView, localImageView);
      return localViewGroup;
    }
  }
  
  private String a(TextView paramTextView1, TextView paramTextView2, Card paramCard)
  {
    if ((paramTextView1 == null) || (paramTextView2 == null) || (TextUtils.isEmpty(paramCard.uin)) || (TextUtils.isEmpty(paramCard.strNick))) {
      return null;
    }
    Object localObject = paramTextView1.getPaint();
    paramTextView1 = (TextView)localObject;
    if (localObject == null)
    {
      paramTextView1 = new TextPaint(1);
      paramTextView1.density = this.jdField_a_of_type_Float;
    }
    localObject = paramTextView2.getPaint();
    paramTextView2 = (TextView)localObject;
    if (localObject == null)
    {
      paramTextView2 = new TextPaint(1);
      paramTextView2.density = this.jdField_a_of_type_Float;
    }
    float f2 = paramTextView1.measureText("...");
    float f3 = this.jdField_a_of_type_Float;
    float f4 = paramTextView1.measureText(String.format("(%s)", new Object[] { paramCard.uin }));
    float f5;
    float f6;
    if (TextUtils.isEmpty(paramCard.qid))
    {
      localObject = "";
      f5 = paramTextView2.measureText((String)localObject);
      f6 = this.e;
      if (!d()) {
        break label252;
      }
    }
    label252:
    for (float f1 = 40.0F * this.jdField_a_of_type_Float;; f1 = 0.0F)
    {
      paramTextView2 = TextUtils.ellipsize(paramCard.strNick, paramTextView1, f6 - f4 - (5.0F * f3 + f2) - f5 - f1, TextUtils.TruncateAt.END);
      paramTextView1 = paramTextView2;
      if (TextUtils.isEmpty(paramTextView2)) {
        paramTextView1 = "...";
      }
      return String.format("%s(%s)", new Object[] { paramTextView1, paramCard.uin });
      localObject = paramCard.qid;
      break;
    }
  }
  
  public static String a(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject2 = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4];
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    }
    return localObject2;
  }
  
  private List<View> a(HashMap<String, View> paramHashMap, String[] paramArrayOfString)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i;
    Object localObject;
    if ((paramHashMap == null) || (paramArrayOfString == null))
    {
      i = 0;
      if (j >= i) {
        break label145;
      }
      localObject = paramArrayOfString[j];
      if (!this.jdField_a_of_type_ComTencentMobileqqProfilecardVasMiscDiyMoreInfoViewHelper.isNotNeedAdd((String)localObject)) {
        break label61;
      }
    }
    for (;;)
    {
      j += 1;
      break;
      i = paramArrayOfString.length;
      break;
      label61:
      this.jdField_a_of_type_ComTencentMobileqqProfilecardVasMiscDiyMoreInfoViewHelper.updateDiyView((String)localObject, paramHashMap);
      if (((!"map_key_sig".equals(localObject)) || (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView == null) || (!this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.containChildView("map_key_sign"))) && ((!"map_key_account_base_info".equals(localObject)) || (!a())))
      {
        localObject = (View)paramHashMap.get(localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    label145:
    return localArrayList;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    paramContext = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics();
    this.jdField_a_of_type_Float = paramContext.density;
    this.jdField_b_of_type_Float = Math.min(paramContext.widthPixels, paramContext.heightPixels);
    this.jdField_c_of_type_Float = (this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297257) + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297606) + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297607));
    float f = this.jdField_a_of_type_Float;
    int i = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297603);
    int j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297604);
    this.d = (7.0F * f + i + j);
    this.e = (this.jdField_b_of_type_Float - this.jdField_c_of_type_Float - this.d);
    this.jdField_a_of_type_ComTencentMobileqqProfilecardVasMiscDiyMoreInfoViewHelper.setProfileArgs(this);
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_Long == ProfileCardTemplate.jdField_a_of_type_Long) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean a(int paramInt, View paramView)
  {
    int j = 1;
    Object localObject1 = this.jdField_c_of_type_ArrayOfJavaLangString;
    int k = localObject1.length;
    int i = 0;
    Object localObject2;
    if (i < k)
    {
      localObject2 = localObject1[i];
      if (paramView != this.jdField_a_of_type_JavaUtilHashMap.get(localObject2)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (QQTheme.e()) {
        bool = false;
      }
      if ((bool) && (getChildCount() == 0)) {
        bool = false;
      }
      for (;;)
      {
        if (bool)
        {
          localObject2 = String.format("%s_%s", new Object[] { "map_key_divider", Integer.valueOf(paramInt) });
          localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
          if (localObject1 != null)
          {
            paramView = (View)localObject1;
            if (((View)localObject1).getParent() == null) {}
          }
          else
          {
            if (localObject1 != null) {
              QLog.e("ProfileCardMoreInfoView", 1, String.format("checkAndAddDivider dividerView=%s viewParent=%s", new Object[] { localObject1, ((View)localObject1).getParent() }));
            }
            paramInt = (int)(this.jdField_a_of_type_Float * 0.75F);
            if (paramInt >= 1) {
              break label281;
            }
            paramInt = j;
          }
        }
        label281:
        for (;;)
        {
          localObject1 = new LinearLayout.LayoutParams(-1, paramInt);
          ((LinearLayout.LayoutParams)localObject1).leftMargin = ((int)this.jdField_c_of_type_Float);
          ((LinearLayout.LayoutParams)localObject1).topMargin = ((int)(this.jdField_a_of_type_Float * 6.0F));
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = ((int)(this.jdField_a_of_type_Float * 6.0F));
          paramView = new View(getContext());
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          paramView.setBackgroundResource(2130850492);
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, paramView);
          addView(paramView);
          return bool;
          i += 1;
          break;
        }
      }
    }
  }
  
  public static boolean a(View paramView)
  {
    if (paramView == null) {}
    while (!paramView.isShown()) {
      return false;
    }
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    return localRect.intersect(new Rect(0, 0, ViewUtils.a(), ViewUtils.b()));
  }
  
  private boolean a(Card paramCard)
  {
    boolean bool1 = false;
    if (!b()) {
      return this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_tag") != null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_tag") != null;
    }
    Object localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tag");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561532, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tag", localObject1);
      bool1 = true;
    }
    localObject2 = (AdaptiveLayout)((View)localObject1).findViewById(2131378903);
    int j = getResources().getDimensionPixelSize(2131298635);
    int i = 7;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      i = 8;
    }
    int k;
    if (this.jdField_a_of_type_ArrayOfAndroidWidgetTextView == null)
    {
      ((AdaptiveLayout)localObject2).setGap(j, j);
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[i];
      k = getResources().getDimensionPixelSize(2131298633);
      int m = getResources().getDimensionPixelSize(2131298636);
      int n = getResources().getDimensionPixelSize(2131298639);
      j = 0;
      if (j < i)
      {
        localObject1 = new TextView(getContext());
        this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[j] = localObject1;
        ((TextView)localObject1).setBackgroundResource(2130847405);
        ((TextView)localObject1).setPadding(m, m, m, m);
        ((TextView)localObject1).setTextSize(0, k);
        ((TextView)localObject1).setTextColor(-16777216);
        ((TextView)localObject1).setGravity(17);
        if (7 == j)
        {
          k = getResources().getDimensionPixelSize(2131298640);
          ((TextView)localObject1).setTextSize(0, k);
          ((TextView)localObject1).setTag(new DataTag(47, null));
          ((TextView)localObject1).setText("+");
          ((TextView)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((TextView)localObject1).setPadding(n, 0, n, 0);
        }
        for (;;)
        {
          ((AdaptiveLayout)localObject2).addView((View)localObject1);
          j += 1;
          break;
          ((TextView)localObject1).setVisibility(8);
        }
      }
    }
    localObject1 = paramCard.getLabelList();
    boolean bool2 = bool1;
    if (localObject2 != null)
    {
      bool2 = bool1;
      if (localObject1 != null)
      {
        label416:
        label463:
        Object localObject3;
        if (((List)localObject1).size() > 7)
        {
          j = 7;
          k = 0;
          if (k >= i) {
            break label590;
          }
          localObject2 = this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[k];
          if (k >= j) {
            break label547;
          }
          ((TextView)localObject2).setText(((ProfileLabelInfo)((List)localObject1).get(k)).labelName);
          ((TextView)localObject2).setVisibility(0);
          if (((TextView)localObject2).getVisibility() == 0)
          {
            localObject3 = ((TextView)localObject2).getBackground();
            if ((localObject3 instanceof GradientDrawable))
            {
              localObject3 = (GradientDrawable)localObject3;
              if (paramCard.backgroundColor != 1L) {
                break label564;
              }
              ((GradientDrawable)localObject3).setColor(-2130706433);
              ((GradientDrawable)localObject3).setStroke(1, 855638016);
              ((TextView)localObject2).setTextColor(-16777216);
            }
          }
        }
        for (;;)
        {
          k += 1;
          break label416;
          j = ((List)localObject1).size();
          break;
          label547:
          if (k >= 7) {
            break label463;
          }
          ((TextView)localObject2).setVisibility(8);
          break label463;
          label564:
          ((GradientDrawable)localObject3).setColor(-2147483648);
          ((GradientDrawable)localObject3).setStroke(1, 872415231);
          ((TextView)localObject2).setTextColor(-1);
        }
        label590:
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    if ((paramCard != null) && (ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if ((a()) || (c())) {
        paramBoolean = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("makeOrRefreshAccountBaseInfoView bShowAccountInfo=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
      if (!paramBoolean) {
        return this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_account_base_info") != null;
      }
      Object localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_account_base_info");
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfilecardVasMiscDiyMoreInfoViewHelper.getDiyView("map_key_account_base_info");
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put("map_key_account_base_info", localObject2);
          paramBoolean = true;
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561494, null);
          this.jdField_a_of_type_JavaUtilHashMap.put("map_key_account_base_info", localObject1);
          paramBoolean = true;
        }
        for (;;)
        {
          localObject1 = (ViewGroup)localObject1;
          ViewGroup localViewGroup1 = (ViewGroup)((ViewGroup)localObject1).findViewById(2131361868);
          localViewGroup1.removeAllViews();
          ViewGroup localViewGroup2 = (ViewGroup)((ViewGroup)localObject1).findViewById(2131361871);
          TextView localTextView;
          Object localObject3;
          Object localObject4;
          if ((ProfileActivity.AllInOne.j(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (ProfileActivity.AllInOne.k(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
          {
            localObject1 = null;
            localObject1 = a(localViewGroup1, 2130846078, (CharSequence)localObject1, 0);
            if (localObject1 != null)
            {
              localTextView = (TextView)((ViewGroup)localObject1).findViewById(2131369051);
              localObject3 = (QidCoolTextView)((ViewGroup)localObject1).findViewById(2131374422);
              if (localTextView != null)
              {
                if (!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean) {
                  break label664;
                }
                localObject4 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                localObject1 = ((TroopManager)localObject4).b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_JavaLangString, paramCard.uin);
                if ((localObject1 == null) || (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick)) || (TextUtils.isEmpty(paramCard.strReMark))) {
                  break label622;
                }
                localObject1 = paramCard.strNick;
                label368:
                localObject2 = localObject1;
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  localObject2 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramCard.uin, false);
                }
                if (!((TroopManager)localObject4).n(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_JavaLangString)) {
                  break label650;
                }
              }
            }
          }
          label650:
          for (localObject1 = localObject2;; localObject1 = a(localTextView, (TextView)localObject3, paramCard))
          {
            localTextView.setText(PrettyAccountUtil.a(PrettyAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lhLevel, (CharSequence)localObject1, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin));
            PrettyAccountUtil.a(localTextView, PrettyAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lhLevel);
            ProfileCardUtil.a(localTextView, paramCard.uin, (String)localObject2);
            if (d()) {
              b(localViewGroup1, 2130846089, ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo), 1);
            }
            if ((((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).n(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_JavaLangString)) || (d())) {
              break label993;
            }
            int j = localViewGroup1.getChildCount();
            i = 0;
            while ((j < 4) && (i < 3)) {
              switch (i)
              {
              default: 
                label600:
                j = localViewGroup1.getChildCount();
                i += 1;
              }
            }
            localObject1 = " ";
            break;
            label622:
            if (TextUtils.isEmpty(paramCard.strReMark))
            {
              localObject1 = paramCard.strNick;
              break label368;
            }
            localObject1 = paramCard.strReMark;
            break label368;
          }
          label664:
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[5])) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[5], paramCard.strNick))) {}
          for (int i = 1;; i = 0)
          {
            if ((!TextUtils.isEmpty(paramCard.strReMark)) || (i != 0))
            {
              localObject4 = a(localTextView, (TextView)localObject3, paramCard);
              localObject3 = paramCard.strNick;
              localObject1 = localObject4;
              localObject2 = localObject3;
              if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                break;
              }
              localObject1 = paramCard.uin;
              localObject2 = localObject3;
              break;
            }
            localObject1 = paramCard.uin;
            localObject2 = null;
            break;
            localObject2 = ProfileAccountInfoUtils.getCompanyWithPrivacy(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label600;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            localObject2 = ProfileAccountInfoUtils.getProfessionTagWithPrivacy(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
            if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.equals((CharSequence)localObject2, com.tencent.mobileqq.util.NearbyProfileUtil.d[14])))
            {
              if (((StringBuilder)localObject1).length() > 0) {
                ((StringBuilder)localObject1).append(" ");
              }
              ((StringBuilder)localObject1).append((String)localObject2);
            }
            b(localViewGroup1, 2130846093, ((StringBuilder)localObject1).toString(), 1);
            break label600;
            localObject2 = ProfileAccountInfoUtils.getSchoolWithPrivacy(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label600;
            }
            localObject1 = localObject2;
            if (paramCard.schoolVerifiedFlag) {
              localObject1 = ProfileCardUtil.a((String)localObject2, true, 2130845301, 2131298265, 2131298264, getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            b(localViewGroup1, 2130846098, (CharSequence)localObject1, 1);
            break label600;
            localObject1 = ProfileAccountInfoUtils.getHometownWithPrivacy(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label600;
            }
            b(localViewGroup1, 2130846088, (CharSequence)localObject1, 1);
            break label600;
            label993:
            localViewGroup2.setTag(new DataTag(66, paramCard.uin));
            localViewGroup2.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileViewOnClickListener);
            a("map_key_account_base_info", (TextView)localViewGroup2.findViewById(2131361872), (ImageView)localViewGroup2.findViewById(2131363027), null);
            return paramBoolean;
          }
        }
        paramBoolean = false;
      }
    }
  }
  
  private boolean a(ArrayList<ProfileActivity.CardContactInfo> paramArrayList)
  {
    int k = 0;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    if ((ProfileActivity.AllInOne.i(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80)) {}
    for (int i = 1;; i = 0)
    {
      if ((localObject1 == null) || (paramArrayList == null) || (paramArrayList.isEmpty())) {
        i = 0;
      }
      if (i == 0) {
        return this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_phone") != null;
      }
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_phone");
      if (localViewGroup == null)
      {
        localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561512, null);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_phone", localViewGroup);
      }
      for (boolean bool = true;; bool = false)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a != null) {
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.clear();
        }
        Object localObject2;
        label226:
        int j;
        if ((this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null) && (!(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView instanceof ProfileBaseView)))
        {
          i = 1;
          localViewGroup.removeAllViews();
          localObject2 = a(localViewGroup, 2130846078, ((ContactCard)localObject1).nickName, 1);
          if (localObject2 != null)
          {
            if (i == 0) {
              break label410;
            }
            ProfileCardTemplate.a((View)localObject2, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTopBorderBackground");
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext;
          int m = ((ContactCard)localObject1).bSex;
          if (!ProfileCardUtil.a()) {
            break label421;
          }
          j = 0;
          label247:
          localObject1 = b(localViewGroup, 2130846089, ProfileCardUtil.a((Context)localObject2, m, j, ((ContactCard)localObject1).strCountry, ((ContactCard)localObject1).strProvince, ((ContactCard)localObject1).strCity), 1);
          if (localObject1 != null)
          {
            if (i == 0) {
              break label430;
            }
            ProfileCardTemplate.a((View)localObject1, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTopBorderBackground");
          }
          label309:
          m = paramArrayList.size();
          j = k;
          label318:
          if (j >= m) {
            break label452;
          }
          localObject1 = (ProfileActivity.CardContactInfo)paramArrayList.get(j);
          localObject2 = a(localViewGroup, (ProfileActivity.CardContactInfo)localObject1);
          if (localObject2 != null)
          {
            if (i == 0) {
              break label441;
            }
            ProfileCardTemplate.a((View)localObject2, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTopBorderBackground");
          }
        }
        for (;;)
        {
          ((ViewGroup)localObject2).setTag(new DataTag(4, localObject1));
          ((ViewGroup)localObject2).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          j += 1;
          break label318;
          i = 0;
          break;
          label410:
          ((ViewGroup)localObject2).setBackgroundResource(2130839578);
          break label226;
          label421:
          j = ((ContactCard)localObject1).bAge;
          break label247;
          label430:
          ((ViewGroup)localObject1).setBackgroundResource(2130839578);
          break label309;
          label441:
          ((ViewGroup)localObject2).setBackgroundResource(2130839577);
        }
        label452:
        return bool;
      }
    }
  }
  
  private ViewGroup b(ViewGroup paramViewGroup, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    if ((paramViewGroup != null) && (paramInt1 > 0) && (!TextUtils.isEmpty(paramCharSequence)))
    {
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561495, null);
      View localView = localViewGroup.findViewById(2131368603);
      TextView localTextView = (TextView)localViewGroup.findViewById(2131369051);
      localView.setBackgroundResource(paramInt1);
      if ((paramCharSequence instanceof String)) {
        localTextView.setText(((String)paramCharSequence).trim());
      }
      for (;;)
      {
        paramViewGroup.addView(localViewGroup);
        if (paramInt2 == 1) {
          LongClickCopyAction.attachCopyAction(localTextView);
        }
        a("map_key_phone", null, localTextView, null);
        return localViewGroup;
        localTextView.setText(paramCharSequence);
      }
    }
    return null;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "update more info");
    }
    removeAllViews();
    List localList = a(this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ArrayOfJavaLangString);
    int i;
    View localView1;
    View localView2;
    View localView3;
    int m;
    int j;
    label101:
    int k;
    if (!a())
    {
      i = 1;
      localView1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_phone");
      localView2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_photo_wall");
      localView3 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sticky_note");
      m = 0;
      if (localList == null) {
        break label302;
      }
      j = localList.size();
      k = 0;
    }
    for (;;)
    {
      if (k >= j) {
        return;
      }
      View localView4 = (View)localList.get(k);
      if (localView4 == localView1) {}
      int n;
      for (;;)
      {
        if ((localView4.getVisibility() != 0) && (localView4 != localView2) && (localView4 != localView3)) {
          localView4.setVisibility(0);
        }
        n = m;
        if (i == 0)
        {
          n = m;
          if (a(m, localView4)) {
            n = m + 1;
          }
        }
        Object localObject = localView4.getParent();
        if (localObject == null) {
          break label467;
        }
        QLog.e("ProfileCardMoreInfoView", 1, String.format("updateMoreInfo itemView=%s viewParent=%s", new Object[] { localView4, localObject }));
        localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          QLog.e("ProfileCardMoreInfoView", 1, String.format("updateMoreInfo key=%s view=%s", new Object[] { str, this.jdField_a_of_type_JavaUtilHashMap.get(str) }));
        }
        i = 0;
        break;
        label302:
        j = 0;
        break label101;
        if ((!(localView4 instanceof ProfileContentTitleView)) && ((!(localView4 instanceof ViewGroup)) || (localView4.getTag(2131367599) != Boolean.TRUE))) {
          if ((localView4 instanceof ProfileCardFavorShowView))
          {
            localObject = (ProfileCardFavorShowView)localView4;
            if ((i != 0) && (!d())) {
              ProfileCardTemplate.a(((ProfileCardFavorShowView)localObject).b, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTopBorderBackground");
            } else {
              ((ProfileCardFavorShowView)localObject).b.setBackgroundResource(2130839577);
            }
          }
          else if (i != 0)
          {
            if (!d()) {
              ProfileCardTemplate.a(localView4, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTopBorderBackground");
            }
          }
          else
          {
            localObject = localView4.findViewById(2131374760);
            if (localObject != null) {
              ((View)localObject).setBackgroundResource(2130839577);
            }
            localView4.setBackgroundResource(2130839577);
          }
        }
      }
      label467:
      addView(localView4);
      k += 1;
      m = n;
    }
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_Long == ProfileCardTemplate.f) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean b(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = false;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileContentContainer != null) {
        bool = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileContentContainer.onDataUpdate(paramProfileCardInfo);
      }
      return bool;
    }
    catch (Exception paramProfileCardInfo)
    {
      QLog.e("ProfileCardMoreInfoView", 1, "notifyContainerDataUpdate fail.", paramProfileCardInfo);
    }
    return false;
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_Long == ProfileCardTemplate.k) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean d()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) {
      bool = ProfileCardTemplate.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_Long);
    }
    return bool;
  }
  
  public int a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      if ((paramArrayOfString1 != null) && (i < paramArrayOfString1.length)) {
        if (TextUtils.isEmpty(paramArrayOfString1[i]))
        {
          i += 1;
        }
        else
        {
          int m = paramArrayOfString2.length;
          k = 0;
          label38:
          if (k >= m) {
            break label124;
          }
          if (!paramArrayOfString2[k].equals(paramArrayOfString1[i])) {
            break;
          }
        }
      }
    }
    label124:
    for (int k = 1;; k = 0)
    {
      if (k == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ProfileCardMoreInfoView", 2, String.format("checkTagsForTroop invalid tag for specail troop tag: %s", new Object[] { paramArrayOfString1[i] }));
        }
        paramArrayOfString1[i] = "";
        break;
        k += 1;
        break label38;
      }
      j += 1;
      break;
      return j;
    }
  }
  
  public HashMap<String, View> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    QLog.d("ProfileCardMoreInfoView", 4, "onResume");
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, boolean paramBoolean, ProfileConfigHelper paramProfileConfigHelper)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper = paramProfileConfigHelper;
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean, String... paramVarArgs)
  {
    if (paramProfileCardInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCardMoreInfoView", 2, "update info is null");
      }
      return;
    }
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      if ((paramProfileCardInfo.jdField_b_of_type_Boolean) && (((TroopManager)localObject).n(paramProfileCardInfo.jdField_a_of_type_JavaLangString)))
      {
        paramVarArgs = this.jdField_b_of_type_ArrayOfJavaLangString;
        label69:
        i = paramVarArgs.length;
      }
    }
    for (;;)
    {
      if (i != 0) {
        break label156;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ProfileCardMoreInfoView", 2, "update no validate tags");
      return;
      paramVarArgs = this.jdField_a_of_type_ArrayOfJavaLangString;
      break label69;
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView == null) {
        i = 0;
      } else if ((paramProfileCardInfo.jdField_b_of_type_Boolean) && (((TroopManager)localObject).n(paramProfileCardInfo.jdField_a_of_type_JavaLangString))) {
        i = a(paramVarArgs, this.jdField_b_of_type_ArrayOfJavaLangString);
      } else {
        i = paramVarArgs.length;
      }
    }
    label156:
    this.jdField_a_of_type_ComTencentMobileqqProfilecardVasMiscDiyMoreInfoViewHelper.initDiyTemplate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramProfileCardInfo, new ProfileCardMoreInfoView.1(this));
    int j = paramVarArgs.length;
    int i = 0;
    boolean bool2 = false;
    label186:
    boolean bool1;
    if (i < j)
    {
      localObject = paramVarArgs[i];
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        bool1 = bool2;
      }
    }
    for (;;)
    {
      i += 1;
      bool2 = bool1;
      break label186;
      try
      {
        if ("map_key_tag".equals(localObject))
        {
          bool1 = a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
          if (bool2) {
            break label467;
          }
          if (!bool1) {
            break label473;
          }
          break label467;
        }
        if ("map_key_phone".equals(localObject))
        {
          bool1 = a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList);
          if (bool2) {
            break label479;
          }
          if (!bool1) {
            break label485;
          }
          break label479;
        }
        if ("map_key_account_base_info".equals(localObject))
        {
          bool1 = a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, paramBoolean);
          if (bool2) {
            break label491;
          }
          if (!bool1) {
            break label497;
          }
          break label491;
        }
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ProfileCardMoreInfoView", 2, String.format("update invalid tag: %s", new Object[] { localObject }));
        bool1 = bool2;
      }
      catch (Throwable localThrowable)
      {
        QLog.w("ProfileCardMoreInfoView", 1, String.format("update crash tag: %s", new Object[] { localObject }), localThrowable);
        bool1 = bool2;
      }
      continue;
      paramBoolean = b(paramProfileCardInfo);
      if ((bool2) || (paramBoolean)) {
        b();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ProfileCardMoreInfoView", 2, String.format("update bRet=%s containerUpdate=%s tags=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean), TextUtils.join(",", paramVarArgs) }));
      return;
      label467:
      bool1 = true;
      continue;
      label473:
      bool1 = false;
      continue;
      label479:
      bool1 = true;
      continue;
      label485:
      bool1 = false;
      continue;
      label491:
      bool1 = true;
      continue;
      label497:
      bool1 = false;
    }
  }
  
  void a(String paramString, TextView paramTextView, View paramView, ImageView paramImageView)
  {
    try
    {
      ProfileCardTemplate localProfileCardTemplate = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
      if ((localProfileCardTemplate != null) && (localProfileCardTemplate.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (localProfileCardTemplate.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0))
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.o));
        ProfileCardTemplate.a(paramTextView, "color", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTitleColor");
        ProfileCardTemplate.a(paramView, "color", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemContentColor");
        ProfileCardTemplate.a(paramImageView, "src", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemMoreSrc");
        return;
      }
      if (d())
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId));
        this.jdField_a_of_type_ComTencentMobileqqProfilecardVasMiscDiyMoreInfoViewHelper.updateModuleTitleView(paramString, paramTextView, paramView, paramImageView);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateItemTheme exception msg=" + paramString.getMessage());
      }
      paramString.printStackTrace();
      return;
    }
    this.jdField_b_of_type_JavaUtilHashMap.put(paramString, String.valueOf(0));
    if (paramTextView != null) {
      paramTextView.setTextColor(getResources().getColorStateList(2131167113));
    }
    if ((paramView instanceof TextView)) {
      ((TextView)paramView).setTextColor(getResources().getColorStateList(2131167033));
    }
    while (paramImageView != null)
    {
      paramImageView.setImageResource(2130839414);
      return;
      if ((paramView instanceof SingleLineTextView)) {
        ((SingleLineTextView)paramView).setTextColor(getResources().getColorStateList(2131167033));
      }
    }
  }
  
  public boolean a(ProfileCardInfo paramProfileCardInfo)
  {
    return (paramProfileCardInfo != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null);
  }
  
  public boolean a(ProfileCardTemplate paramProfileCardTemplate)
  {
    if (paramProfileCardTemplate == null) {}
    for (paramProfileCardTemplate = "0"; this.jdField_b_of_type_JavaUtilHashMap.size() > 0; paramProfileCardTemplate = String.valueOf(paramProfileCardTemplate.o))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
      String str;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
      } while (((String)this.jdField_b_of_type_JavaUtilHashMap.get(str)).equals(paramProfileCardTemplate));
      return false;
    }
    return true;
  }
  
  public void setContentContainer(ProfileContentContainer paramProfileContentContainer)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseContainerProfileContentContainer = paramProfileContentContainer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardMoreInfoView
 * JD-Core Version:    0.7.0.1
 */