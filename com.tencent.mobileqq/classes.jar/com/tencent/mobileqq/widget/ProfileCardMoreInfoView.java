package com.tencent.mobileqq.widget;

import QQService.EVIPSPEC;
import QQService.PrivilegeInfo;
import SummaryCard.PhotoInfo;
import akvq;
import akvr;
import akvs;
import akvt;
import akvu;
import akvv;
import akvw;
import akvy;
import akwa;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
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
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberCard.MemberGameInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.dating.MsgBoxUtil;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendResourceUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.PersonalityLabel.OnGetPersonalityLabelsListener;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard.IScroll;
import com.tencent.mobileqq.profile.ProfileBusiEntry;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.ProfileColor;
import com.tencent.mobileqq.profile.ProfileGroupLabel;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.ProfileSummaryHobbiesEntry;
import com.tencent.mobileqq.profile.ProfileSummaryHobbiesItem;
import com.tencent.mobileqq.profile.TroopMemberCardConstants;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedUtils;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopMemberGlobalLevelUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import cooperation.troop.TroopPluginManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ProfileCardMoreInfoView
  extends LinearLayout
  implements PhotoWallView.PhotoWallUpdaterListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  public ColorDrawable a;
  public LayoutInflater a;
  public BaseActivity a;
  public QQAppInterface a;
  public ProfileCardInfo a;
  public ProfileCardTemplate a;
  public ProfileHeaderView a;
  public RichStatus a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new akvq(this);
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  public HashMap a;
  boolean jdField_a_of_type_Boolean;
  private TextView[] jdField_a_of_type_ArrayOfAndroidWidgetTextView;
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "map_key_tag", "map_key_account_base_info", "map_key_troop_mem_gift_entry", "map_key_troop_mem_charm_level", "map_key_troop_mem_recent_said", "map_key_troop_mem_game_info", "map_key_account_level_info", "map_key_nick", "map_key_nick_clickable", "map_key_circlenick", "map_key_remark", "map_key_recommendname", "map_key_troopnick", "map_key_sig", "map_key_lightalk", "map_key_diamond", "map_key_campus_feed", "map_key_qzone", "map_key_qqstory", "map_key_shopping_photo", "map_key_phone", "map_key_photo_wall", "map_key_personality_label_board", "map_key_extend_friend_info", "map_key_favor" };
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  protected boolean b;
  private final String[] jdField_b_of_type_ArrayOfJavaLangString = { "map_key_nick", "map_key_nick_clickable", "map_key_circlenick", "map_key_remark", "map_key_recommendname", "map_key_troopnick" };
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  public boolean c;
  public boolean d;
  public volatile boolean e = false;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u;
  
  public ProfileCardMoreInfoView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    a(paramContext);
  }
  
  public ProfileCardMoreInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    a(paramContext);
  }
  
  private ViewGroup a(ViewGroup paramViewGroup, int paramInt, Card paramCard)
  {
    if ((paramCard == null) || (paramViewGroup == null)) {
      return null;
    }
    int i1;
    if ((paramCard.nCampusStatus == 4) || (ProfileActivity.AllInOne.i(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)) {
      if (paramCard.nCampusStatus == 4) {
        i1 = com.tencent.mobileqq.campuscircle.CampusCircleConstant.a[0];
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramCard.strCampusAcademy)) {
        paramCard = paramCard.strCampusAcademy;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramCard))
        {
          ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970565, null);
          View localView = localViewGroup.findViewById(2131362719);
          SingleLineTextView localSingleLineTextView = (SingleLineTextView)localViewGroup.findViewById(2131364119);
          localView.setBackgroundResource(paramInt);
          localSingleLineTextView.setText(paramCard.trim());
          localSingleLineTextView.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131559410));
          localSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, i1);
          paramViewGroup.addView(localViewGroup);
          a("map_key_account_base_info", null, localSingleLineTextView, null);
          return localViewGroup;
          if ((paramCard.nCampusStatus == 2) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
          {
            i1 = com.tencent.mobileqq.campuscircle.CampusCircleConstant.a[1];
            break;
          }
          if ((paramCard.nCampusStatus != 1) || (paramCard.nCampusSchoolFlag != 1) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) || (!ProfileActivity.AllInOne.i(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
            break label310;
          }
          i1 = com.tencent.mobileqq.campuscircle.CampusCircleConstant.a[2];
          break;
          if (!TextUtils.isEmpty(paramCard.strSchool))
          {
            paramCard = paramCard.strSchool;
            continue;
          }
          if (TextUtils.isEmpty(paramCard.strCampusSchool)) {
            break label305;
          }
          paramCard = paramCard.strCampusSchool;
          continue;
          paramCard = paramCard.strSchool;
          i1 = 0;
          continue;
        }
        return null;
        label305:
        paramCard = null;
      }
      label310:
      i1 = 0;
    }
  }
  
  private ViewGroup a(ViewGroup paramViewGroup, int paramInt, String paramString)
  {
    if ((paramViewGroup != null) && (paramInt > 0) && (!TextUtils.isEmpty(paramString)))
    {
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970542, null);
      View localView = localViewGroup.findViewById(2131362719);
      TextView localTextView = (TextView)localViewGroup.findViewById(2131364119);
      localView.setBackgroundResource(paramInt);
      localTextView.setText(paramString.trim());
      paramViewGroup.addView(localViewGroup);
      a("map_key_account_base_info", null, localTextView, null);
      return localViewGroup;
    }
    return null;
  }
  
  private ViewGroup a(ViewGroup paramViewGroup, ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if ((paramViewGroup == null) || (paramCardContactInfo == null)) {
      return null;
    }
    paramCardContactInfo = paramCardContactInfo.c;
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970546, null);
    TextView localTextView1 = (TextView)localViewGroup.findViewById(2131363378);
    View localView = localViewGroup.findViewById(2131362747);
    TextView localTextView2 = (TextView)localViewGroup.findViewById(2131364119);
    ImageView localImageView = (ImageView)localViewGroup.findViewById(2131363443);
    localTextView1.setVisibility(8);
    localView.setVisibility(0);
    localView.setBackgroundResource(2130843055);
    localTextView2.setText(paramCardContactInfo);
    paramViewGroup.addView(localViewGroup);
    a("map_key_phone", null, localTextView2, localImageView);
    return localViewGroup;
  }
  
  private ViewGroup a(Card paramCard, boolean paramBoolean)
  {
    if (paramCard != null)
    {
      if ((paramBoolean) && (!paramCard.hasCardInfo())) {
        return null;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList;
      paramCard = new ArrayList();
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramCard.add((ProfileActivity.CardContactInfo)((Iterator)localObject).next());
        }
      }
      if (paramCard.size() > 0)
      {
        paramCard = (ProfileActivity.CardContactInfo)paramCard.get(0);
        localObject = String.format("%s %s", new Object[] { paramCard.jdField_a_of_type_JavaLangString, paramCard.c });
        ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970542, null);
        View localView = localViewGroup.findViewById(2131362719);
        TextView localTextView = (TextView)localViewGroup.findViewById(2131364119);
        localViewGroup.setTag(new DataTag(68, paramCard));
        localViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView.setVisibility(0);
        localView.setBackgroundResource(2130843055);
        localTextView.setText((CharSequence)localObject);
        a("map_key_account_base_info", null, localTextView, null);
        return localViewGroup;
      }
    }
    return null;
  }
  
  private String a(TextView paramTextView, String paramString1, String paramString2)
  {
    if ((paramTextView == null) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return null;
    }
    TextPaint localTextPaint = paramTextView.getPaint();
    paramTextView = localTextPaint;
    if (localTextPaint == null)
    {
      paramTextView = new TextPaint(1);
      paramTextView.density = this.jdField_a_of_type_Float;
    }
    float f1 = paramTextView.measureText("...");
    float f2 = this.jdField_a_of_type_Float;
    float f3 = paramTextView.measureText(String.format("(%s)", new Object[] { paramString2 }));
    paramString1 = TextUtils.ellipsize(paramString1, paramTextView, this.jdField_c_of_type_Float - f3 - (f1 + 5.0F * f2), TextUtils.TruncateAt.END);
    paramTextView = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramTextView = "...";
    }
    return String.format("%s(%s)", new Object[] { paramTextView, paramString2 });
  }
  
  private String a(String paramString)
  {
    if (("map_key_nick".equals(paramString)) || ("map_key_nick_clickable".equals(paramString))) {
      return a(2131435735);
    }
    if ("map_key_circlenick".equals(paramString)) {
      return a(2131435737);
    }
    if ("map_key_remark".equals(paramString)) {
      return a(2131435736);
    }
    if ("map_key_recommendname".equals(paramString)) {
      return a(2131435739);
    }
    if ("map_key_troopnick".equals(paramString)) {
      return a(2131435740);
    }
    return null;
  }
  
  private String a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Card paramCard)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      if (!paramBoolean1) {
        break label388;
      }
      localStringBuilder.append("P");
      i1 = 1;
    }
    for (;;)
    {
      int i3;
      int i2;
      if (paramBoolean2)
      {
        i3 = paramCard.getVipLevel(EVIPSPEC.E_SP_SUPERVIP);
        i2 = i3;
        if (i3 < 1) {
          i2 = 1;
        }
        if (paramCard.iQQVipType == 1)
        {
          if (i1 == 0) {}
          for (paramCard = "S";; paramCard = "BS")
          {
            localStringBuilder.append(paramCard);
            this.jdField_a_of_type_JavaLangStringBuilder.append("年费超级会员").append(i2).append("级");
            return localStringBuilder.toString();
            if (!paramBoolean1) {
              break label388;
            }
            localStringBuilder.append("P");
            i1 = 1;
            break;
          }
        }
        if (i1 == 0) {}
        for (paramCard = "s";; paramCard = "Bs")
        {
          localStringBuilder.append(paramCard);
          this.jdField_a_of_type_JavaLangStringBuilder.append("超级会员").append(i2).append("级");
          break;
        }
      }
      if (paramBoolean3)
      {
        i3 = paramCard.getVipLevel(EVIPSPEC.E_SP_QQVIP);
        i2 = i3;
        if (i3 < 1) {
          i2 = 1;
        }
        if (paramCard.iQQVipType == 1)
        {
          if (i1 == 0) {}
          for (paramCard = "V";; paramCard = "BV")
          {
            localStringBuilder.append(paramCard);
            this.jdField_a_of_type_JavaLangStringBuilder.append("年费QQ会员").append(i2).append("级");
            break;
          }
        }
        if (i1 == 0) {}
        for (paramCard = "v";; paramCard = "Bv")
        {
          localStringBuilder.append(paramCard);
          this.jdField_a_of_type_JavaLangStringBuilder.append("QQ会员").append(i2).append("级");
          break;
        }
      }
      if (i1 == 0) {}
      for (paramCard = "N";; paramCard = "BN")
      {
        localStringBuilder.append(paramCard);
        break;
      }
      label388:
      i1 = 0;
    }
  }
  
  private List a(HashMap paramHashMap, String[] paramArrayOfString, int paramInt)
  {
    int i1 = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if ((paramHashMap == null) || (paramArrayOfString == null))
    {
      paramInt = 0;
      if (i1 >= paramInt) {
        break label119;
      }
      localObject = paramArrayOfString[i1];
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap == null) || (!"map_key_sig".equals(localObject)) || (!this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.containsKey("map_key_sign"))) {
        break label92;
      }
    }
    for (;;)
    {
      i1 += 1;
      break;
      paramInt = paramArrayOfString.length;
      break;
      label92:
      localObject = (View)paramHashMap.get(localObject);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    label119:
    return localArrayList;
  }
  
  private List a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    paramList = paramList.iterator();
    ArrayList localArrayList = new ArrayList();
    while (paramList.hasNext())
    {
      ProfileBusiEntry localProfileBusiEntry = (ProfileBusiEntry)paramList.next();
      if (localProfileBusiEntry.jdField_a_of_type_Int != 1024) {
        localArrayList.add(localProfileBusiEntry);
      }
    }
    return localArrayList;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    paramContext = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics();
    this.jdField_a_of_type_Float = paramContext.density;
    this.jdField_b_of_type_Float = Math.min(paramContext.widthPixels, paramContext.heightPixels);
    float f1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131558559);
    float f2 = this.jdField_a_of_type_AndroidContentResResources.getDimension(2131558557);
    float f3 = this.jdField_a_of_type_Float;
    float f4 = this.jdField_a_of_type_AndroidContentResResources.getDimension(2131558557);
    this.jdField_c_of_type_Float = (this.jdField_b_of_type_Float - f1 - f2 * 2.0F - 9.0F * f3 - 2.0F * f4);
    this.jdField_a_of_type_Int = 4;
    for (int i1 = (int)((this.jdField_a_of_type_Int * 44 + (this.jdField_a_of_type_Int - 1) * 10) * this.jdField_a_of_type_Float); (i1 > this.jdField_c_of_type_Float) && (this.jdField_a_of_type_Int >= 1); i1 = (int)((this.jdField_a_of_type_Int * 44 + (this.jdField_a_of_type_Int - 1) * 10) * this.jdField_a_of_type_Float)) {
      this.jdField_a_of_type_Int -= 1;
    }
  }
  
  private void a(View paramView)
  {
    if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    for (int i1 = -1907741;; i1 = -16576993)
    {
      paramView.setBackgroundColor(i1);
      return;
    }
  }
  
  private void a(ViewGroup paramViewGroup, Card paramCard, List paramList)
  {
    paramViewGroup.removeAllViews();
    int i4 = paramList.size();
    int i2 = (int)DeviceInfoUtil.j();
    int i1;
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)))
    {
      i1 = 1;
      if (i4 > 4) {
        break label138;
      }
      i2 /= 4;
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    int i5;
    ProfileBusiEntry localProfileBusiEntry;
    for (;;)
    {
      localObject1 = null;
      i5 = i2 - AIOUtils.a(20.0F, getResources());
      int i3 = 0;
      for (;;)
      {
        if (i3 >= i4) {
          break label1254;
        }
        localProfileBusiEntry = (ProfileBusiEntry)paramList.get(i3);
        if (localProfileBusiEntry != null) {
          break;
        }
        i3 += 1;
      }
      i1 = 0;
      break;
      label138:
      i2 = i2 * 146 / 640;
    }
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970536, null);
    Object localObject4 = (ImageView)localView.findViewById(2131362960);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130843058);
      label196:
      Object localObject3 = localProfileBusiEntry.jdField_a_of_type_JavaLangString;
      String str = localProfileBusiEntry.jdField_b_of_type_JavaLangString;
      localObject1 = localProfileBusiEntry.c;
      if ((localObject1 != null) && (5 < ((String)localObject1).length()))
      {
        localObject1 = ((String)localObject1).substring(0, 4) + "...";
        label259:
        if ((localProfileBusiEntry.jdField_a_of_type_Int == 1024) && (TextUtils.isEmpty((CharSequence)localObject3)))
        {
          localObject3 = "http://s.url.cn/pub/img/qb_group_normal.png";
          try
          {
            label283:
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
            localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
            localURLDrawableOptions.mRequestHeight = i5;
            localURLDrawableOptions.mRequestWidth = i5;
            localObject3 = URLDrawable.getDrawable((String)localObject3, localURLDrawableOptions);
            ((URLDrawable)localObject3).setTag(URLDrawableDecodeHandler.a(i5, i5, (int)(10.0F * DeviceInfoUtil.a())));
            if (localObject3 != null)
            {
              if (localProfileBusiEntry.jdField_a_of_type_Int == 6) {
                ((ImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER_CROP);
              }
              ((ImageView)localObject4).setImageDrawable((Drawable)localObject3);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
            localObject1 = new DataTag(19, new Object[] { Boolean.valueOf(paramCard.isOpenRecentPlayingGamesByNative()), paramCard.strProfileUrl, localProfileBusiEntry });
            if (this.h) {
              break label1289;
            }
          }
          localObject3 = (TextView)localView.findViewById(2131369792);
          ((TextView)localObject3).setText(str);
          localObject4 = (TextView)localView.findViewById(2131367500);
          ((TextView)localObject4).setText((CharSequence)localObject1);
          localView.setContentDescription(str + (String)localObject1);
          ProfileCardTemplate.a((View)localObject3, "color", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTitleColor");
          ProfileCardTemplate.a((View)localObject4, "color", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTitleColor");
          switch (localProfileBusiEntry.jdField_a_of_type_Int)
          {
          default: 
            localObject1 = new DataTag(27, localProfileBusiEntry);
          }
        }
      }
    }
    label1280:
    label1283:
    label1286:
    label1289:
    for (;;)
    {
      label593:
      localView.setTag(localObject1);
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (i1 == 0) {
        localView.setBackgroundResource(2130838625);
      }
      for (;;)
      {
        paramViewGroup.addView(localView, new LinearLayout.LayoutParams(i2, -2));
        localObject1 = localObject2;
        break;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004315 ", "0X8004315 ", 0, 0, "", "", "", "");
        this.h = true;
        break label593;
        localObject1 = new DataTag(22, localProfileBusiEntry);
        if (this.i) {
          break label1286;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004314", "0X8004314", 0, 0, "", "", "", "");
        this.i = true;
        break label593;
        localObject1 = new DataTag(21, localProfileBusiEntry);
        if (this.g) {
          break label1283;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004316", "0X8004316", 0, 0, "", "", "", "");
        this.g = true;
        break label593;
        localObject1 = new DataTag(28, localProfileBusiEntry);
        if (this.f) {
          break label1280;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004300", "0X8004300", 0, 0, "", "", "", "");
        this.f = true;
        break label593;
        localObject1 = new DataTag(33, localProfileBusiEntry);
        break label593;
        localObject1 = new DataTag(30, localProfileBusiEntry);
        break label593;
        localObject1 = new DataTag(39, localProfileBusiEntry);
        if (this.k) {
          break label1277;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80055CB", "0X80055CB", 0, 0, "", "", "", "");
        this.k = true;
        break label593;
        localObject1 = new DataTag(42, localProfileBusiEntry);
        if (this.l) {
          break label1274;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005D15", "0X8005D15", 0, 0, "", "", "", "");
        this.l = true;
        break label593;
        localObject1 = new DataTag(58, localProfileBusiEntry);
        if (this.m) {
          break label1271;
        }
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "0X8006E04", "0X8006E04", 0, 0, new String[0]);
        this.m = true;
        break label593;
        localObject1 = new DataTag(64, localProfileBusiEntry);
        if (this.r) {
          break label1268;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007DBC", "0X8007DBC", 0, 0, "", "", "", "");
        this.r = true;
        break label593;
        localObject1 = new DataTag(70, localProfileBusiEntry);
        break label593;
        localObject1 = new DataTag(84, localProfileBusiEntry);
        break label593;
        localView.setBackgroundResource(0);
      }
      label1254:
      return;
      break label283;
      break label259;
      localObject2 = localObject1;
      break label196;
      label1268:
      continue;
      label1271:
      continue;
      label1274:
      continue;
      label1277:
      continue;
      continue;
      continue;
    }
  }
  
  private void a(TextView paramTextView, String paramString1, String paramString2)
  {
    String str1 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str1 = "";
    }
    Resources localResources = getResources();
    SpannableString localSpannableString = new SpannableString(str1);
    int i2 = str1.lastIndexOf(")");
    int i1 = i2;
    if (i2 == -1) {
      i1 = 0;
    }
    if (i1 < str1.length())
    {
      paramString1 = null;
      String str2 = str1.substring(i1, i1 + 1);
      label119:
      Drawable localDrawable;
      double d1;
      if (("S".equalsIgnoreCase(str2)) && (!TextUtils.isEmpty(paramString2)))
      {
        paramString1 = getResources();
        if (str2.equals("S"))
        {
          i2 = 2130843132;
          localDrawable = paramString1.getDrawable(i2);
          paramString1 = URLDrawable.getDrawable(paramString2, localDrawable, localDrawable);
          i2 = localDrawable.getIntrinsicHeight();
          if (!str2.equals("S")) {
            break label256;
          }
          d1 = 85.0D * (i2 / 27.0D);
          label167:
          paramString1.setBounds(0, 0, (int)d1, i2);
        }
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(str2)) && (paramString1 != null)) {
          localSpannableString.setSpan(new VerticalCenterImageSpan(paramString1, 1), i1, i1 + 1, 33);
        }
        if ((paramString1 != null) && ((paramString1 instanceof URLDrawable))) {
          ((URLDrawable)paramString1).setURLDrawableListener(new akvs(this, paramTextView));
        }
        i1 += 1;
        break;
        i2 = 2130843116;
        break label119;
        label256:
        d1 = 67.0D * (i2 / 27.0D);
        break label167;
        if (("V".equalsIgnoreCase(str2)) && (!TextUtils.isEmpty(paramString2)))
        {
          paramString1 = getResources();
          if (str2.equals("V"))
          {
            i2 = 2130843133;
            label311:
            localDrawable = paramString1.getDrawable(i2);
            paramString1 = URLDrawable.getDrawable(paramString2, localDrawable, localDrawable);
            i2 = localDrawable.getIntrinsicHeight();
            if (!str2.equals("V")) {
              break label381;
            }
          }
          label381:
          for (d1 = 76.0D * (i2 / 26.0D);; d1 = 58.0D * (i2 / 26.0D))
          {
            paramString1.setBounds(0, 0, (int)d1, i2);
            break;
            i2 = 2130843124;
            break label311;
          }
        }
        if ("N".equals(str2))
        {
          paramString1 = localResources.getDrawable(2130843094);
          paramString1.setBounds(0, 0, paramString1.getIntrinsicWidth(), paramString1.getIntrinsicHeight());
        }
        else if ("B".equals(str2))
        {
          paramString1 = localResources.getDrawable(2130843125);
          paramString1.setBounds(0, 0, (int)(10.0F * this.jdField_a_of_type_Float), paramString1.getIntrinsicHeight());
        }
        else if ("P".equalsIgnoreCase(str2))
        {
          paramString1 = getResources().getDrawable(2130843105);
          i2 = paramString1.getIntrinsicHeight();
          paramString1.setBounds(0, 0, paramString1.getIntrinsicWidth(), i2);
        }
        else if ("G".equalsIgnoreCase(str2))
        {
          paramString1 = getResources().getDrawable(2130843104);
          i2 = paramString1.getIntrinsicHeight();
          paramString1.setBounds(0, 0, paramString1.getIntrinsicWidth(), i2);
        }
      }
    }
    paramTextView.setText(localSpannableString);
  }
  
  private void a(Card paramCard, ProfileCardFavorShowView paramProfileCardFavorShowView)
  {
    boolean bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i2;
    Object localObject;
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate != null)
    {
      i2 = 1;
      localObject = paramProfileCardFavorShowView.a(0);
      if (localObject == null) {
        break label445;
      }
      if (i2 == 0) {
        break label321;
      }
      ProfileCardTemplate localProfileCardTemplate = (ProfileCardTemplate)((View)localObject).getTag(2131362408);
      if ((localProfileCardTemplate != null) && (localProfileCardTemplate.equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate))) {
        break label445;
      }
      i1 = 1;
    }
    for (;;)
    {
      label74:
      boolean bool1;
      if ((localObject == null) || (!Boolean.FALSE.equals(((View)localObject).getTag(2131362406))) || (!new Boolean(bool2).equals(((View)localObject).getTag(2131362407))) || (i1 != 0))
      {
        paramProfileCardFavorShowView.removeAllViews();
        paramProfileCardFavorShowView.setFocusable(false);
        paramProfileCardFavorShowView.setClickable(false);
        if (i2 == 0) {
          break label439;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.a.get("commonItemContentColor");
        if (localObject == null) {
          break label434;
        }
        if ((localObject instanceof ColorStateList))
        {
          i1 = ((ColorStateList)localObject).getDefaultColor();
          label179:
          localObject = new float[3];
          Color.colorToHSV(i1, (float[])localObject);
          if (localObject[2] <= 0.5F) {
            break label372;
          }
          bool1 = true;
        }
      }
      for (;;)
      {
        label204:
        if (bool2)
        {
          localObject = new ProfileCardExtendFriendView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, true);
          label224:
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 96) || (this.d)) {
            ((ProfileCardExtendFriendView)localObject).setFold(false);
          }
          ((ProfileCardExtendFriendView)localObject).setClickable(true);
          ((ProfileCardExtendFriendView)localObject).setTag(2131362406, Boolean.valueOf(false));
          ((ProfileCardExtendFriendView)localObject).setTag(2131362407, Boolean.valueOf(bool2));
          ((ProfileCardExtendFriendView)localObject).setTag(2131362408, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate);
          paramProfileCardFavorShowView.addView((View)localObject);
        }
        for (;;)
        {
          ((ProfileCardExtendFriendView)localObject).a(paramCard, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
          i2 = 0;
          break;
          label321:
          if (((View)localObject).getTag(2131362408) == null) {
            break label445;
          }
          i1 = 1;
          break label74;
          if (!(localObject instanceof String)) {
            break label434;
          }
          localObject = (String)localObject;
          if (!((String)localObject).startsWith("#")) {
            break label434;
          }
          i1 = Color.parseColor((String)localObject);
          break label179;
          label372:
          bool1 = false;
          break label204;
          if (i2 != 0)
          {
            localObject = new ProfileCardExtendFriendView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, bool1);
            break label224;
          }
          localObject = new ProfileCardExtendFriendView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          break label224;
          localObject = (ProfileCardExtendFriendView)localObject;
        }
        label434:
        i1 = 0;
        break label179;
        label439:
        bool1 = false;
      }
      label445:
      i1 = 0;
    }
  }
  
  /* Error */
  private void a(PersonalityLabelBoard paramPersonalityLabelBoard, ProfileCardFavorShowView paramProfileCardFavorShowView)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 110
    //   3: aconst_null
    //   4: aload_2
    //   5: getfield 848	com/tencent/mobileqq/widget/ProfileCardFavorShowView:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   8: aconst_null
    //   9: invokevirtual 222	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:a	(Ljava/lang/String;Landroid/widget/TextView;Landroid/view/View;Landroid/widget/ImageView;)V
    //   12: aload_0
    //   13: getfield 623	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate	Lcom/tencent/mobileqq/profile/ProfileCardTemplate;
    //   16: ifnull +265 -> 281
    //   19: aload_0
    //   20: getfield 623	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate	Lcom/tencent/mobileqq/profile/ProfileCardTemplate;
    //   23: getfield 799	com/tencent/mobileqq/profile/ProfileCardTemplate:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   26: ifnull +255 -> 281
    //   29: aload_0
    //   30: getfield 623	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate	Lcom/tencent/mobileqq/profile/ProfileCardTemplate;
    //   33: getfield 799	com/tencent/mobileqq/profile/ProfileCardTemplate:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   36: invokevirtual 849	java/util/concurrent/ConcurrentHashMap:size	()I
    //   39: ifle +242 -> 281
    //   42: aload_0
    //   43: getfield 58	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   46: ldc 110
    //   48: aload_0
    //   49: getfield 623	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate	Lcom/tencent/mobileqq/profile/ProfileCardTemplate;
    //   52: getfield 852	com/tencent/mobileqq/profile/ProfileCardTemplate:l	J
    //   55: invokestatic 855	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   58: invokevirtual 859	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: pop
    //   62: aload_0
    //   63: getfield 623	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate	Lcom/tencent/mobileqq/profile/ProfileCardTemplate;
    //   66: getfield 799	com/tencent/mobileqq/profile/ProfileCardTemplate:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   69: ldc_w 801
    //   72: invokevirtual 804	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: astore 7
    //   77: aload 7
    //   79: ifnull +348 -> 427
    //   82: aload 7
    //   84: instanceof 806
    //   87: ifeq +156 -> 243
    //   90: aload 7
    //   92: checkcast 806	android/content/res/ColorStateList
    //   95: astore 7
    //   97: aload_1
    //   98: getfield 864	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:a	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   101: ifnull +319 -> 420
    //   104: aload_1
    //   105: getfield 864	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:a	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   108: invokevirtual 868	com/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView:a	()I
    //   111: istore_3
    //   112: aload_0
    //   113: getfield 437	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   116: ifnull +248 -> 364
    //   119: aload_0
    //   120: getfield 437	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   123: instanceof 526
    //   126: ifne +238 -> 364
    //   129: iconst_1
    //   130: istore 4
    //   132: iload 4
    //   134: ifeq +22 -> 156
    //   137: aload_2
    //   138: iconst_1
    //   139: invokevirtual 796	com/tencent/mobileqq/widget/ProfileCardFavorShowView:setClickable	(Z)V
    //   142: aload_2
    //   143: ldc_w 870
    //   146: aload_0
    //   147: getfield 623	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate	Lcom/tencent/mobileqq/profile/ProfileCardTemplate;
    //   150: ldc_w 872
    //   153: invokestatic 630	com/tencent/mobileqq/profile/ProfileCardTemplate:a	(Landroid/view/View;Ljava/lang/String;Lcom/tencent/mobileqq/profile/ProfileCardTemplate;Ljava/lang/String;)V
    //   156: aload_0
    //   157: getfield 369	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   160: invokestatic 505	com/tencent/mobileqq/theme/ThemeUtil:isInNightMode	(Lmqq/app/AppRuntime;)Z
    //   163: istore 6
    //   165: aload_0
    //   166: getfield 137	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   169: getfield 770	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate	Lcom/tencent/mobileqq/profile/ProfileCardTemplate;
    //   172: ifnull +198 -> 370
    //   175: iconst_1
    //   176: istore 5
    //   178: iload 6
    //   180: ifne +196 -> 376
    //   183: iload 5
    //   185: ifne +191 -> 376
    //   188: iconst_1
    //   189: istore 6
    //   191: aload_1
    //   192: iload 6
    //   194: invokevirtual 875	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:setIsNormalTheme	(Z)V
    //   197: aload_1
    //   198: getfield 864	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:a	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   201: ifnull +30 -> 231
    //   204: iload 4
    //   206: ifeq +176 -> 382
    //   209: aload_1
    //   210: getfield 864	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:a	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   213: aconst_null
    //   214: invokevirtual 878	com/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   217: aload 7
    //   219: ifnull +176 -> 395
    //   222: aload_1
    //   223: getfield 864	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:a	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   226: aload 7
    //   228: invokevirtual 882	com/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView:setTextColor	(Landroid/content/res/ColorStateList;)V
    //   231: aload 7
    //   233: ifnull +173 -> 406
    //   236: aload_1
    //   237: aload 7
    //   239: invokevirtual 885	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:setTextColors	(Landroid/content/res/ColorStateList;)V
    //   242: return
    //   243: aload 7
    //   245: instanceof 60
    //   248: ifeq +179 -> 427
    //   251: aload 7
    //   253: checkcast 60	java/lang/String
    //   256: astore 7
    //   258: aload 7
    //   260: ldc_w 837
    //   263: invokevirtual 840	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   266: ifeq +161 -> 427
    //   269: aload 7
    //   271: invokestatic 843	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   274: pop
    //   275: aconst_null
    //   276: astore 7
    //   278: goto -181 -> 97
    //   281: aload_0
    //   282: getfield 58	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   285: ldc 110
    //   287: iconst_0
    //   288: invokestatic 887	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   291: invokevirtual 859	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   294: pop
    //   295: aload_0
    //   296: invokevirtual 201	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:getResources	()Landroid/content/res/Resources;
    //   299: ldc_w 888
    //   302: invokevirtual 892	android/content/res/Resources:getColorStateList	(I)Landroid/content/res/ColorStateList;
    //   305: astore 7
    //   307: goto -210 -> 97
    //   310: astore 8
    //   312: aconst_null
    //   313: astore 7
    //   315: invokestatic 897	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   318: ifeq +34 -> 352
    //   321: ldc_w 899
    //   324: iconst_2
    //   325: new 366	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   332: ldc_w 901
    //   335: invokevirtual 381	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload 8
    //   340: invokevirtual 904	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   343: invokevirtual 381	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 408	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 907	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   352: aload 8
    //   354: invokevirtual 639	java/lang/Exception:printStackTrace	()V
    //   357: ldc_w 908
    //   360: istore_3
    //   361: goto -249 -> 112
    //   364: iconst_0
    //   365: istore 4
    //   367: goto -235 -> 132
    //   370: iconst_0
    //   371: istore 5
    //   373: goto -195 -> 178
    //   376: iconst_0
    //   377: istore 6
    //   379: goto -188 -> 191
    //   382: aload_1
    //   383: getfield 864	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:a	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   386: ldc_w 633
    //   389: invokevirtual 909	com/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView:setBackgroundResource	(I)V
    //   392: goto -175 -> 217
    //   395: aload_1
    //   396: getfield 864	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:a	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   399: iload_3
    //   400: invokevirtual 911	com/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView:setTextColor	(I)V
    //   403: goto -172 -> 231
    //   406: aload_1
    //   407: iload_3
    //   408: invokestatic 913	android/content/res/ColorStateList:valueOf	(I)Landroid/content/res/ColorStateList;
    //   411: invokevirtual 885	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:setTextColors	(Landroid/content/res/ColorStateList;)V
    //   414: return
    //   415: astore 8
    //   417: goto -102 -> 315
    //   420: ldc_w 908
    //   423: istore_3
    //   424: goto -312 -> 112
    //   427: aconst_null
    //   428: astore 7
    //   430: goto -333 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	433	0	this	ProfileCardMoreInfoView
    //   0	433	1	paramPersonalityLabelBoard	PersonalityLabelBoard
    //   0	433	2	paramProfileCardFavorShowView	ProfileCardFavorShowView
    //   111	313	3	i1	int
    //   130	236	4	i2	int
    //   176	196	5	i3	int
    //   163	215	6	bool	boolean
    //   75	354	7	localObject	Object
    //   310	43	8	localException1	Exception
    //   415	1	8	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   12	77	310	java/lang/Exception
    //   82	97	310	java/lang/Exception
    //   243	275	310	java/lang/Exception
    //   281	307	310	java/lang/Exception
    //   97	112	415	java/lang/Exception
  }
  
  private void a(ProfileCardFavorShowView paramProfileCardFavorShowView, Card paramCard)
  {
    List localList = paramCard.getBigOrderEntrys();
    if (localList != null)
    {
      paramProfileCardFavorShowView.removeAllViews();
      int i1;
      int i2;
      label54:
      label105:
      int i3;
      label111:
      ProfileSummaryHobbiesEntry localProfileSummaryHobbiesEntry;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)))
      {
        i1 = 1;
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean))
        {
          i2 = 0;
          if (i2 < localList.size())
          {
            paramCard = (ProfileSummaryHobbiesEntry)localList.get(i2);
            if (!TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d)) {
              break label182;
            }
            localList.remove(paramCard);
          }
        }
        i2 = 0;
        i3 = 0;
        if (i2 >= localList.size()) {
          break label1167;
        }
        localProfileSummaryHobbiesEntry = (ProfileSummaryHobbiesEntry)localList.get(i2);
        i4 = i3;
        if (!TextUtils.isEmpty(localProfileSummaryHobbiesEntry.jdField_a_of_type_JavaLangString)) {
          if (localProfileSummaryHobbiesEntry.jdField_a_of_type_JavaUtilArrayList != null) {
            break label219;
          }
        }
      }
      label182:
      label219:
      ProfileCardFavorItemView localProfileCardFavorItemView;
      for (int i4 = i3;; i4 = i3 + 1)
      {
        i2 += 1;
        i3 = i4;
        break label111;
        i1 = 0;
        break;
        if (paramCard.jdField_a_of_type_Int == 5)
        {
          localList.add(0, localList.remove(i2));
          break label105;
        }
        i2 += 1;
        break label54;
        localProfileCardFavorItemView = new ProfileCardFavorItemView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        localProfileCardFavorItemView.setTitle(localProfileSummaryHobbiesEntry.jdField_a_of_type_JavaLangString);
        ProfileSummaryHobbiesItem localProfileSummaryHobbiesItem;
        ProfileCardFavorItemDetailView localProfileCardFavorItemDetailView;
        Drawable localDrawable;
        if (i1 == 0)
        {
          localProfileCardFavorItemView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130838625);
          localProfileCardFavorItemView.b.setBackgroundResource(0);
          i4 = 0;
          if (i4 >= localProfileSummaryHobbiesEntry.jdField_a_of_type_JavaUtilArrayList.size()) {
            break label1052;
          }
          localProfileSummaryHobbiesItem = (ProfileSummaryHobbiesItem)localProfileSummaryHobbiesEntry.jdField_a_of_type_JavaUtilArrayList.get(i4);
          localProfileCardFavorItemDetailView = new ProfileCardFavorItemDetailView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          localProfileCardFavorItemDetailView.setTitle(localProfileSummaryHobbiesItem.jdField_a_of_type_JavaLangString);
          localProfileCardFavorItemDetailView.setContent(localProfileSummaryHobbiesItem.d);
          localProfileCardFavorItemDetailView.setDesc(localProfileSummaryHobbiesItem.e);
          localDrawable = getResources().getDrawable(2131493226);
          if (TextUtils.isEmpty(localProfileSummaryHobbiesItem.jdField_b_of_type_JavaLangString)) {
            break label663;
          }
          paramCard = URLDrawable.URLDrawableOptions.obtain();
          paramCard.mLoadingDrawable = localDrawable;
          paramCard.mRequestWidth = AIOUtils.a(70.0F, getResources());
          paramCard.mRequestHeight = AIOUtils.a(70.0F, getResources());
          paramCard = URLDrawable.getDrawable(localProfileSummaryHobbiesItem.jdField_b_of_type_JavaLangString, paramCard);
        }
        for (;;)
        {
          localProfileCardFavorItemDetailView.setIcon(paramCard);
          if (!TextUtils.isEmpty(localProfileSummaryHobbiesItem.f)) {
            localProfileCardFavorItemDetailView.a(localProfileSummaryHobbiesItem.f, 2);
          }
          if ((localProfileSummaryHobbiesItem.jdField_a_of_type_JavaUtilArrayList == null) || (localProfileSummaryHobbiesItem.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
            break label700;
          }
          int i5 = 0;
          while (i5 < localProfileSummaryHobbiesItem.jdField_a_of_type_JavaUtilArrayList.size())
          {
            ProfileGroupLabel localProfileGroupLabel = (ProfileGroupLabel)localProfileSummaryHobbiesItem.jdField_a_of_type_JavaUtilArrayList.get(i5);
            localDrawable = null;
            paramCard = localDrawable;
            if (i5 == 0)
            {
              paramCard = localDrawable;
              if (localProfileSummaryHobbiesItem.jdField_a_of_type_Int == 5)
              {
                localDrawable = getResources().getDrawable(2130843089);
                paramCard = localDrawable;
                if (!localProfileGroupLabel.jdField_a_of_type_JavaLangString.contains("人"))
                {
                  localProfileGroupLabel.jdField_a_of_type_JavaLangString += "人";
                  paramCard = localDrawable;
                }
              }
            }
            localProfileCardFavorItemDetailView.a(paramCard, localProfileGroupLabel.jdField_a_of_type_JavaLangString, Color.rgb((int)localProfileGroupLabel.b.jdField_a_of_type_Long, (int)localProfileGroupLabel.b.b, (int)localProfileGroupLabel.b.c), 3);
            i5 += 1;
          }
          ProfileCardTemplate.a(localProfileCardFavorItemView.jdField_a_of_type_AndroidWidgetLinearLayout, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTopBorderBackground");
          ProfileCardTemplate.a(localProfileCardFavorItemView.b, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTopBorderBackground");
          break;
          label663:
          paramCard = localDrawable;
          if (localProfileSummaryHobbiesItem.jdField_a_of_type_Int == 5) {
            paramCard = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, String.valueOf(localProfileSummaryHobbiesItem.jdField_a_of_type_Long), 1, localDrawable, localDrawable);
          }
        }
        label700:
        if (i1 != 0)
        {
          a("map_key_favor", localProfileCardFavorItemDetailView.b, localProfileCardFavorItemDetailView.jdField_a_of_type_AndroidWidgetTextView, null);
          a("map_key_favor", localProfileCardFavorItemDetailView.c, null, null);
          ProfileCardTemplate.a(localProfileCardFavorItemDetailView, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTopBorderBackground");
          label749:
          localProfileCardFavorItemDetailView.setTag(new DataTag(62, localProfileSummaryHobbiesItem));
          localProfileCardFavorItemDetailView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          localProfileCardFavorItemView.addView(localProfileCardFavorItemDetailView);
          switch (localProfileSummaryHobbiesItem.jdField_a_of_type_Int)
          {
          }
        }
        for (;;)
        {
          i4 += 1;
          break;
          localProfileCardFavorItemDetailView.setBackgroundResource(2130838625);
          break label749;
          if (localProfileSummaryHobbiesItem.jdField_b_of_type_Int == 0)
          {
            if (!this.n)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070B1", "0X80070B1", 0, 0, "", "", "", "");
              this.n = true;
            }
          }
          else if (!this.o)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070AD", "0X80070AD", 0, 0, "", "", "", "");
            this.o = true;
            continue;
            if (!this.p)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070B5", "0X80070B5", 0, 0, "", "", "", "");
              this.p = true;
              continue;
              if (!this.q)
              {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070A9", "0X80070A9", 0, 0, "", "", "", "");
                this.q = true;
              }
            }
          }
        }
        label1052:
        if (i1 == 0) {
          break label1126;
        }
        a("map_key_favor", null, localProfileCardFavorItemView.jdField_a_of_type_AndroidWidgetTextView, localProfileCardFavorItemView.jdField_a_of_type_AndroidWidgetImageView);
        localProfileCardFavorItemView.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localProfileCardFavorItemView.setTag(new DataTag(61, localProfileSummaryHobbiesEntry));
        localProfileCardFavorItemView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramProfileCardFavorShowView.addView(localProfileCardFavorItemView);
      }
      label1126:
      if (paramProfileCardFavorShowView.a() == 0) {
        localProfileCardFavorItemView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      for (;;)
      {
        a(localProfileCardFavorItemView.jdField_a_of_type_AndroidViewView);
        break;
        localProfileCardFavorItemView.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      label1167:
      this.jdField_b_of_type_Boolean = true;
      paramCard = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_third_part_app_entrance");
      if (paramCard != null)
      {
        paramProfileCardFavorShowView.removeView(paramCard);
        paramProfileCardFavorShowView.addView(paramCard);
      }
      this.jdField_c_of_type_Int = i3;
    }
  }
  
  private void a(StringBuilder paramStringBuilder, List paramList)
  {
    if ((paramStringBuilder == null) || (paramList == null)) {}
    int i1;
    do
    {
      return;
      i1 = 0;
    } while (i1 >= paramList.size());
    switch (((PrivilegeInfo)paramList.get(i1)).iType)
    {
    }
    for (;;)
    {
      i1 += 1;
      break;
      paramStringBuilder.append("会员");
      continue;
      paramStringBuilder.append("超级QQ");
      continue;
      paramStringBuilder.append("好莱坞会员");
      continue;
      paramStringBuilder.append("超级会员");
      continue;
      paramStringBuilder.append("腾讯图书VIP");
      continue;
      paramStringBuilder.append("情侣黄钻");
      continue;
      paramStringBuilder.append("绿钻");
      continue;
      paramStringBuilder.append("红钻");
      continue;
      paramStringBuilder.append("超级星钻");
      continue;
      paramStringBuilder.append("黄钻");
    }
  }
  
  private void a(List paramList, LinearLayout paramLinearLayout)
  {
    float f1 = 24.0F * this.jdField_a_of_type_Float;
    float f2 = this.jdField_a_of_type_Float;
    float f3 = 4.0F * this.jdField_a_of_type_Float;
    if ((paramLinearLayout == null) || (paramList == null) || (paramList.size() < 1)) {}
    ArrayList localArrayList;
    int i1;
    Object localObject1;
    do
    {
      return;
      localArrayList = new ArrayList();
      i1 = 0;
      while (i1 < paramList.size())
      {
        localObject1 = ((PrivilegeInfo)paramList.get(i1)).strDeluxeIconUrl;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
        localObject1 = ((PrivilegeInfo)paramList.get(i1)).strIconUrl;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
        i1 += 1;
      }
    } while (localArrayList.size() < 1);
    int i4 = (int)((this.jdField_c_of_type_Float + f3) / (f1 + f3));
    int i5 = localArrayList.size();
    if (i5 > i4)
    {
      i1 = i5 / i4;
      if (i5 % i4 > 0) {
        i1 += 1;
      }
    }
    for (;;)
    {
      paramList = new ColorDrawable(16777215);
      int i2 = 0;
      label221:
      if (i2 < i1)
      {
        localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        if (i2 != 0) {
          break label351;
        }
      }
      int i3;
      int i6;
      label351:
      for (((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(4.0F * this.jdField_a_of_type_Float));; ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(4.0F * this.jdField_a_of_type_Float)))
      {
        if (i2 == i1 - 1) {
          ((LinearLayout.LayoutParams)localObject2).bottomMargin = ((int)(4.0F * this.jdField_a_of_type_Float));
        }
        ((LinearLayout)localObject1).setOrientation(0);
        ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        i3 = 0;
        if (i3 < i4)
        {
          i6 = i2 * i4 + i3;
          if (i6 != i5) {
            break label368;
          }
        }
        paramLinearLayout.addView((View)localObject1);
        i2 += 1;
        break label221;
        break;
      }
      label368:
      Object localObject2 = (String)localArrayList.get(i6);
      URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      Object localObject3 = new LinearLayout.LayoutParams((int)f1, (int)(24.0F * f2));
      if (i3 == 0) {}
      for (((LinearLayout.LayoutParams)localObject3).leftMargin = 0;; ((LinearLayout.LayoutParams)localObject3).leftMargin = ((int)f3))
      {
        localURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = URLDrawable.getDrawable((String)localObject2, paramList, paramList);
        if (((URLDrawable)localObject3).getStatus() == 2) {
          localURLImageView.setVisibility(8);
        }
        localURLImageView.setBackgroundDrawable((Drawable)localObject3);
        localURLImageView.setURLDrawableDownListener(new akvr(this, (String)localObject2, localURLImageView));
        ((LinearLayout)localObject1).addView(localURLImageView);
        i3 += 1;
        break;
      }
      continue;
      i1 = 1;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i1 = 2;
    if (this.u) {
      return;
    }
    String str2;
    String str1;
    if (paramBoolean)
    {
      str2 = "0X80092DA";
      str1 = str2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.declaration))
      {
        i1 = 1;
        str1 = str2;
      }
    }
    for (;;)
    {
      this.u = true;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str1, str1, i1, 0, "", "", "", "");
      return;
      str2 = "0X80092E1";
      str1 = str2;
      if (this.d)
      {
        i1 = 1;
        str1 = str2;
      }
    }
  }
  
  private boolean a()
  {
    if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d))
    {
      if (QLog.isColorLevel()) {
        QLog.d(ProfileCardMoreInfoView.class.getSimpleName(), 2, "makeOrRefreshTroopGiftEntry, isQidianPrivateTroop");
      }
      return false;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_troop_mem_gift_entry");
      return false;
    }
    Object localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_troop_mem_gift_entry");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130971674, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_troop_mem_gift_entry", localObject1);
    }
    localObject2 = (TextView)((View)localObject1).findViewById(2131375312);
    ImageView localImageView1 = (ImageView)((View)localObject1).findViewById(2131371364);
    ImageView localImageView2 = (ImageView)((View)localObject1).findViewById(2131368535);
    localImageView1.setImageResource(2130846300);
    localImageView2.setVisibility(0);
    ((View)localObject1).setTag(new DataTag(79, null));
    ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
    ((TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112)).a(1402, new akvu(this, (View)localObject1, (TextView)localObject2, localImageView2));
    return true;
  }
  
  private boolean a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    int i1 = getResources().getDisplayMetrics().heightPixels;
    paramView.getLocationInWindow(arrayOfInt);
    QLog.i("remilelei", 2, "y=" + arrayOfInt[1]);
    int i2 = arrayOfInt[1];
    return ((FriendProfileCardActivity)this.jdField_a_of_type_AndroidContentContext).findViewById(2131370078).getHeight() + i2 < i1;
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramCard != null) {
      if (!ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        bool1 = bool2;
        if (!ProfileActivity.AllInOne.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("makeOrRefreshAccountBaseInfoView bShowAccountInfo=%s", new Object[] { Boolean.valueOf(bool1) }));
    }
    int i1;
    if (!bool1)
    {
      if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_account_base_info") != null) {}
      for (i1 = 1;; i1 = 0)
      {
        paramBoolean = 0x0 | i1;
        return paramBoolean;
      }
    }
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_account_base_info");
    if (localObject1 == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970541, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_account_base_info", localObject1);
    }
    for (bool1 = true;; bool1 = false)
    {
      localObject1 = (ViewGroup)localObject1;
      ViewGroup localViewGroup1 = (ViewGroup)((ViewGroup)localObject1).findViewById(2131370258);
      ViewGroup localViewGroup2 = (ViewGroup)((ViewGroup)localObject1).findViewById(2131371103);
      View localView = ((ViewGroup)localObject1).findViewById(2131371104);
      ViewGroup localViewGroup3 = (ViewGroup)localViewGroup1.findViewById(2131370259);
      ImageView localImageView = (ImageView)localViewGroup1.findViewById(2131363443);
      localViewGroup3.removeAllViews();
      label276:
      Object localObject3;
      label381:
      Object localObject2;
      if ((ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)) || (ProfileActivity.AllInOne.j(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (ProfileActivity.AllInOne.k(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
      {
        localObject1 = null;
        localObject1 = a(localViewGroup3, 2130843040, (String)localObject1);
        if (localObject1 != null)
        {
          localObject3 = (TextView)((ViewGroup)localObject1).findViewById(2131364119);
          if (localObject3 != null)
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean) {
              break label707;
            }
            localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d, paramCard.uin);
            if ((localObject1 == null) || (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick)) || (TextUtils.isEmpty(paramCard.strReMark))) {
              break label662;
            }
            localObject1 = paramCard.strNick;
            localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject2 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramCard.uin, false);
            }
            if (!TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d)) {
              break label690;
            }
            localObject1 = localObject2;
            label428:
            ((TextView)localObject3).setText((CharSequence)localObject1);
            ((TextView)localObject3).setTag(new DataTag(67, paramCard.uin));
            ((TextView)localObject3).setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          }
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
        i2 = paramCard.shGender;
        if (!ProfileCardUtil.b()) {
          break label786;
        }
        i1 = 0;
        label485:
        a(localViewGroup3, 2130843047, ProfileCardUtil.a((Context)localObject1, i2, i1, paramCard.constellation, paramCard.strCountry, paramCard.strProvince, paramCard.strCity));
        localObject1 = null;
        if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d)) {
          break label861;
        }
        i1 = localViewGroup3.getChildCount();
        i2 = 0;
        localObject2 = null;
        localObject3 = null;
        label554:
        if (localObject2 == null) {
          break label794;
        }
        if (i1 >= 2) {
          break label799;
        }
      }
      Object localObject5;
      int i3;
      Object localObject4;
      label619:
      label635:
      while (i1 < 3)
      {
        if (i2 >= 4) {
          break label799;
        }
        localObject5 = null;
        i3 = 0;
        switch (i2)
        {
        default: 
          localObject1 = localObject5;
          i1 = i3;
          localObject4 = localObject2;
          if (i2 != 2) {
            break label1370;
          }
          localObject3 = a(localViewGroup3, i1, paramCard);
          i1 = localViewGroup3.getChildCount();
          i2 += 1;
          localObject2 = localObject4;
          break label554;
          localObject1 = " ";
          break label276;
          if (TextUtils.isEmpty(paramCard.strReMark))
          {
            localObject1 = paramCard.strNick;
            break label381;
          }
          localObject1 = paramCard.strReMark;
          break label381;
          localObject1 = a((TextView)localObject3, (String)localObject2, paramCard.uin);
          break label428;
          if ((!TextUtils.isEmpty(paramCard.strReMark)) || ((ProfileActivity.AllInOne.i(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (!TextUtils.isEmpty(paramCard.strCampusName))))
          {
            localObject2 = a((TextView)localObject3, paramCard.strNick, paramCard.uin);
            localObject1 = localObject2;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label428;
            }
            localObject1 = paramCard.uin;
            break label428;
          }
          localObject1 = paramCard.uin;
          break label428;
          i1 = paramCard.age;
          break label485;
        }
      }
      label662:
      label690:
      label707:
      if ((localObject3 == null) && (ProfileActivity.AllInOne.i(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
        a(localViewGroup3, 2130843053, paramCard);
      }
      label786:
      label794:
      label799:
      if (localObject2 != null)
      {
        localViewGroup3.addView((View)localObject2);
        paramCard = ((ViewGroup)localObject2).getLayoutParams();
        paramCard.width = -1;
        ((ViewGroup)localObject2).setLayoutParams(paramCard);
      }
      localObject1 = localObject2;
      label861:
      i1 = 1;
      if (ProfileActivity.AllInOne.j(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        i1 = 0;
      }
      int i2 = i1;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean)
      {
        i2 = i1;
        if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d))
        {
          i2 = i1;
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            i2 = 0;
          }
        }
      }
      if (i2 != 0)
      {
        localViewGroup1.setTag(new DataTag(66, null));
        localViewGroup1.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      i1 = 0;
      if (ProfileActivity.AllInOne.j(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        i1 = 8;
      }
      i2 = i1;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean)
      {
        i2 = i1;
        if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d))
        {
          i2 = i1;
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            i2 = 8;
          }
        }
      }
      if (localImageView.getVisibility() != i2) {
        localImageView.setVisibility(i2);
      }
      a("map_key_account_base_info", null, null, localImageView);
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))) {}
      for (i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          break label1388;
        }
        ProfileCardTemplate.a(localViewGroup1, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTopBorderBackground");
        localViewGroup2.setVisibility(8);
        paramBoolean = bool1;
        if (localObject1 == null) {
          break;
        }
        ProfileCardTemplate.a((View)localObject1, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTopBorderBackground");
        return bool1;
        if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          localObject4 = localObject2;
          i1 = i3;
          localObject1 = localObject5;
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
            break label619;
          }
        }
        localObject4 = localObject2;
        i1 = i3;
        localObject1 = localObject5;
        if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
          break label619;
        }
        localObject4 = a(paramCard, paramBoolean);
        i1 = i3;
        localObject1 = localObject5;
        break label619;
        localObject1 = new StringBuilder();
        if (!TextUtils.isEmpty(paramCard.strCompany)) {
          ((StringBuilder)localObject1).append(paramCard.strCompany);
        }
        localObject4 = NearbyProfileUtil.e(paramCard.iProfession);
        if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.equals((CharSequence)localObject4, NearbyProfileUtil.d[14])))
        {
          if (((StringBuilder)localObject1).length() > 0) {
            ((StringBuilder)localObject1).append(" ");
          }
          ((StringBuilder)localObject1).append((String)localObject4);
        }
        localObject1 = ((StringBuilder)localObject1).toString();
        i1 = 2130843049;
        localObject4 = localObject2;
        break label619;
        localObject1 = "";
        i1 = 2130843053;
        localObject4 = localObject2;
        break label619;
        localObject4 = localObject2;
        i1 = i3;
        localObject1 = localObject5;
        if (TextUtils.isEmpty(paramCard.strHometownDesc)) {
          break label619;
        }
        localObject1 = paramCard.strHometownDesc;
        i1 = 2130843046;
        localObject4 = localObject2;
        break label619;
        label1370:
        a(localViewGroup3, i1, (String)localObject1);
        break label635;
      }
      label1388:
      if (this.jdField_a_of_type_Boolean)
      {
        localViewGroup2.setVisibility(8);
        return bool1;
      }
      localViewGroup1.setBackgroundResource(0);
      localViewGroup2.setVisibility(0);
      a(localView);
      paramBoolean = bool1;
      if (localObject1 == null) {
        break;
      }
      ((ViewGroup)localObject1).setBackgroundResource(2130838625);
      return bool1;
    }
  }
  
  private boolean a(RichStatus paramRichStatus)
  {
    boolean bool2 = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && ((!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramRichStatus == null) || (Arrays.equals(paramRichStatus.encode(), RichStatus.getEmptyStatus().encode())))) {
      return (View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_sig") != null;
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sig");
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970567, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sig", localView);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      TextView localTextView = (TextView)localView.findViewById(2131364119);
      ImageView localImageView = (ImageView)localView.findViewById(2131363443);
      StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      Resources localResources = getResources();
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        ProfileCardUtil.a(localResources, localView, localStatusManager, paramRichStatus, bool2);
        if ((paramRichStatus == null) || (TextUtils.isEmpty(paramRichStatus.actionText))) {
          break label284;
        }
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
        label200:
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))) {
          break label292;
        }
        localImageView.setVisibility(0);
        localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        localView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        a("map_key_sig", null, localTextView, localImageView);
        return bool1;
        bool2 = false;
        break;
        label284:
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
        break label200;
        label292:
        localImageView.setVisibility(8);
      }
    }
  }
  
  private boolean a(String paramString)
  {
    if (("map_key_nick".equals(paramString)) || ("map_key_nick_clickable".equals(paramString))) {}
    while (("map_key_circlenick".equals(paramString)) || ("map_key_remark".equals(paramString)) || ("map_key_recommendname".equals(paramString)) || ("map_key_troopnick".equals(paramString))) {
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (!a(paramString1)) {
      return false;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1) != null) {}
      for (bool = true;; bool = false) {
        return bool;
      }
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970546, null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localView);
    }
    for (boolean bool = true;; bool = false)
    {
      TextView localTextView1 = (TextView)localView.findViewById(2131363378);
      localTextView1.setText(a(paramString1));
      TextView localTextView2 = (TextView)localView.findViewById(2131364119);
      localTextView2.setText(paramString2);
      localView.setTag(new DataTag(11, paramString2));
      localView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      ImageView localImageView = (ImageView)localView.findViewById(2131363443);
      if (localImageView.getVisibility() != 4) {
        localImageView.setVisibility(4);
      }
      if ("map_key_nick_clickable".equals(paramString1))
      {
        localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        localImageView.setVisibility(0);
      }
      localView.setContentDescription(a(paramString1) + ":" + paramString2);
      a(paramString1, localTextView1, localTextView2, localImageView);
      return bool;
    }
  }
  
  private boolean a(ArrayList paramArrayList)
  {
    int i3 = 0;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    if ((ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80)) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((localObject1 == null) || (paramArrayList == null) || (paramArrayList.isEmpty())) {
        i1 = 0;
      }
      boolean bool2;
      if (i1 == 0)
      {
        if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_phone") != null) {}
        for (i1 = 1;; i1 = 0)
        {
          bool2 = 0x0 | i1;
          return bool2;
        }
      }
      ViewGroup localViewGroup1 = (ViewGroup)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_phone");
      if (localViewGroup1 == null)
      {
        localViewGroup1 = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970554, null);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_phone", localViewGroup1);
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a != null) {
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.clear();
        }
        Object localObject2;
        ViewGroup localViewGroup2;
        label268:
        int i2;
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)))
        {
          i1 = 1;
          localViewGroup1.removeAllViews();
          localObject2 = ((ContactCard)localObject1).nickName;
          localViewGroup2 = a(localViewGroup1, 2130843040, (String)localObject2);
          if (localViewGroup2 != null)
          {
            localViewGroup2.setTag(new DataTag(11, localObject2));
            localViewGroup2.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
            if (i1 == 0) {
              break label461;
            }
            ProfileCardTemplate.a(localViewGroup2, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTopBorderBackground");
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext;
          int i4 = ((ContactCard)localObject1).bSex;
          if (!ProfileCardUtil.b()) {
            break label472;
          }
          i2 = 0;
          label289:
          localObject1 = a(localViewGroup1, 2130843047, ProfileCardUtil.a((Context)localObject2, i4, i2, ((ContactCard)localObject1).strCountry, ((ContactCard)localObject1).strProvince, ((ContactCard)localObject1).strCity));
          if (localObject1 != null)
          {
            if (i1 == 0) {
              break label481;
            }
            ProfileCardTemplate.a((View)localObject1, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTopBorderBackground");
          }
          label347:
          i4 = paramArrayList.size();
          i2 = i3;
          label356:
          bool2 = bool1;
          if (i2 >= i4) {
            break;
          }
          localObject1 = (ProfileActivity.CardContactInfo)paramArrayList.get(i2);
          localObject2 = a(localViewGroup1, (ProfileActivity.CardContactInfo)localObject1);
          if (localObject2 != null)
          {
            if (i1 == 0) {
              break label492;
            }
            ProfileCardTemplate.a((View)localObject2, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTopBorderBackground");
          }
        }
        for (;;)
        {
          ((ViewGroup)localObject2).setTag(new DataTag(4, localObject1));
          ((ViewGroup)localObject2).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((ViewGroup)localObject2).setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          i2 += 1;
          break label356;
          i1 = 0;
          break;
          label461:
          localViewGroup2.setBackgroundResource(2130838626);
          break label268;
          label472:
          i2 = ((ContactCard)localObject1).bAge;
          break label289;
          label481:
          ((ViewGroup)localObject1).setBackgroundResource(2130838626);
          break label347;
          label492:
          ((ViewGroup)localObject2).setBackgroundResource(2130838625);
        }
      }
    }
  }
  
  private static void b(View paramView, ProfileCardInfo paramProfileCardInfo)
  {
    paramView.setVisibility(0);
    Context localContext = paramView.getContext();
    TextView localTextView = (TextView)paramView.findViewById(2131375312);
    ImageView localImageView = (ImageView)paramView.findViewById(2131368535);
    if (!TextUtils.isEmpty(paramProfileCardInfo.e))
    {
      localTextView.setText(paramProfileCardInfo.e);
      localTextView.setContentDescription(localContext.getString(2131430208) + paramProfileCardInfo.e);
      localImageView.setVisibility(0);
      paramView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    localTextView.setText(localContext.getString(2131430603));
    localTextView.setContentDescription(localContext.getString(2131430208) + localContext.getString(2131430603));
    localImageView.setVisibility(8);
    paramView.setOnClickListener(null);
  }
  
  private boolean b()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_troop_mem_recent_said");
      return false;
    }
    Object localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_troop_mem_recent_said");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130971674, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_troop_mem_recent_said", localObject1);
    }
    localObject2 = (TextView)((View)localObject1).findViewById(2131375312);
    ImageView localImageView1 = (ImageView)((View)localObject1).findViewById(2131371364);
    ImageView localImageView2 = (ImageView)((View)localObject1).findViewById(2131368535);
    View localView1 = ((View)localObject1).findViewById(2131371103);
    View localView2 = ((View)localObject1).findViewById(2131371104);
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard != null) && ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo.gameName))))
    {
      if (!TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d))
      {
        localView1.setVisibility(0);
        a(localView2);
      }
      localImageView1.setImageResource(2130846301);
      ((View)localObject1).setTag(new DataTag(78, null));
      ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      a("map_key_troop_mem_recent_said", null, (View)localObject2, localImageView2);
      if (this.e) {
        break label302;
      }
      this.e = ((TroopPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(118)).a("troop_member_card_plugin.apk", new akvv(this, (View)localObject1));
      if (!this.e) {
        ((View)localObject1).setVisibility(8);
      }
    }
    for (;;)
    {
      a();
      return true;
      localView1.setVisibility(8);
      a(localView2);
      break;
      label302:
      b((View)localObject1, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    }
  }
  
  private boolean b(Card paramCard)
  {
    boolean bool2;
    if ((paramCard == null) || (!paramCard.showLightalk) || (StringUtil.a(paramCard.lightalkNick)))
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_lightalk");
      bool2 = false;
      return bool2;
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_lightalk");
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970546, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_lightalk", localView);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      TextView localTextView1 = (TextView)localView.findViewById(2131363378);
      TextView localTextView2 = (TextView)localView.findViewById(2131364119);
      ImageView localImageView = (ImageView)localView.findViewById(2131363443);
      localTextView1.setText(2131437807);
      Drawable localDrawable = getContext().getResources().getDrawable(2130843026);
      localView.setClickable(true);
      localView.setContentDescription("来电帐号" + paramCard.lightalkNick + "点击进入");
      localView.setTag(new DataTag(35, null));
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      localImageView.setVisibility(0);
      localTextView2.setVisibility(0);
      localTextView2.setText(paramCard.lightalkNick);
      localTextView2.setSingleLine(true);
      localTextView2.setEllipsize(TextUtils.TruncateAt.END);
      localTextView2.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      localTextView2.setCompoundDrawablePadding(ProfileCardUtil.a(getContext(), 6));
      a("map_key_lightalk", localTextView1, localTextView2, localImageView);
      bool2 = bool1;
      if (this.j) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005109", "0X8005109", 0, 0, "", "", "", "");
      return bool1;
    }
  }
  
  private boolean b(Card paramCard, boolean paramBoolean)
  {
    boolean bool = c(paramCard, paramBoolean);
    if ((d(paramCard, paramBoolean)) || (bool)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if ((!this.s) && (paramBoolean))
      {
        this.s = true;
        StoryReportor.a("person_data", "exp", 0, 0, new String[] { "", "", "", "" });
      }
      return paramBoolean;
    }
  }
  
  private boolean c()
  {
    HashMap localHashMap;
    int i2;
    label40:
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a != null)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.size();
      localHashMap = new HashMap();
      i2 = 0;
      if (i2 >= i1) {
        break label235;
      }
      localObject = (MQQName)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.get(i2);
      if (localObject != null) {
        break label83;
      }
    }
    for (;;)
    {
      i2 += 1;
      break label40;
      i1 = 0;
      break;
      label83:
      switch (((MQQName)localObject).jdField_a_of_type_Int)
      {
      case 3: 
      case 6: 
      default: 
        break;
      case 0: 
        localHashMap.put("map_key_nick", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
        break;
      case 7: 
        localHashMap.put("map_key_nick_clickable", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
        break;
      case 2: 
        localHashMap.put("map_key_circlenick", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
        break;
      case 1: 
        localHashMap.put("map_key_troopnick", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
        break;
      case 5: 
        localHashMap.put("map_key_recommendname", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
        break;
      case 4: 
        localHashMap.put("map_key_remark", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
      }
    }
    label235:
    int i1 = 0;
    boolean bool = false;
    if (i1 < this.jdField_b_of_type_ArrayOfJavaLangString.length)
    {
      localObject = (String)localHashMap.get(this.jdField_b_of_type_ArrayOfJavaLangString[i1]);
      if ((a(this.jdField_b_of_type_ArrayOfJavaLangString[i1], (String)localObject)) || (bool)) {}
      for (bool = true;; bool = false)
      {
        i1 += 1;
        break;
      }
    }
    return bool;
  }
  
  private boolean c(Card paramCard)
  {
    if (paramCard == null) {
      return false;
    }
    if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_diamond");
      return false;
    }
    List localList1 = paramCard.getPrivilegeOpenInfo();
    List localList2 = paramCard.getPrivilegeCloseInfo();
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_diamond");
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970547, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_diamond", localView);
    }
    for (boolean bool = true;; bool = false)
    {
      TextView localTextView = (TextView)localView.findViewById(2131371110);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131371111);
      Object localObject = (ImageView)localView.findViewById(2131363443);
      localLinearLayout.removeAllViews();
      ((ImageView)localObject).setVisibility(0);
      localView.setTag(new DataTag(26, null));
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      a("map_key_diamond", null, localTextView, (ImageView)localObject);
      localObject = new StringBuilder(24);
      ((StringBuilder)localObject).append(getContext().getString(2131435724));
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        localLinearLayout.setVisibility(0);
        localTextView.setVisibility(8);
        paramCard = new ArrayList();
        if ((localList1 != null) && (localList1.size() > 0))
        {
          paramCard.addAll(localList1);
          ((StringBuilder)localObject).append("你已开通");
          a((StringBuilder)localObject, localList1);
          if ((localList2 != null) && (!localList2.isEmpty())) {
            paramCard.addAll(localList2);
          }
          a(paramCard, localLinearLayout);
        }
      }
      for (;;)
      {
        localView.setContentDescription(((StringBuilder)localObject).toString());
        return bool;
        ((StringBuilder)localObject).append("你未开通特权服务，快去开通vip服务吧！");
        break;
        if ((localList1 == null) || (localList1.isEmpty())) {
          break label405;
        }
        localLinearLayout.setVisibility(0);
        localTextView.setVisibility(8);
        a(localList1, localLinearLayout);
        ((StringBuilder)localObject).append("你的好友已开通");
        a((StringBuilder)localObject, localList1);
      }
      label405:
      paramCard = paramCard.privilegePromptStr;
      if (TextUtils.isEmpty(paramCard)) {
        localTextView.setVisibility(4);
      }
      for (;;)
      {
        localLinearLayout.setVisibility(8);
        break;
        localTextView.setText(paramCard);
        localTextView.setVisibility(0);
        ((StringBuilder)localObject).append("TA还未开通任何服务特权");
      }
    }
  }
  
  private boolean c(Card paramCard, boolean paramBoolean)
  {
    if ((!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramCard == null) || (!paramCard.mHasStory))
    {
      if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_qqstory") != null) {}
      for (paramBoolean = true;; paramBoolean = false) {
        return paramBoolean;
      }
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qqstory");
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970561, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qqstory", localView);
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      TextView localTextView = (TextView)localView.findViewById(2131364119);
      ImageView localImageView = (ImageView)localView.findViewById(2131363443);
      String str1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4];
      if ((str1 == null) || (str1.length() == 0)) {
        str1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
      }
      for (;;)
      {
        String str2;
        if (str1 != null)
        {
          str2 = str1;
          if (str1.length() != 0) {}
        }
        else
        {
          str2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        }
        localTextView.setText(str2 + "的" + "日迹");
        if ((!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramCard == null) || (paramCard.mQQStoryData == null)) {
          localTextView.setMaxLines(2);
        }
        for (;;)
        {
          localView.setTag(new DataTag(63, null));
          localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          localView.setContentDescription(a(2131427373));
          a("map_key_qqstory", null, localTextView, localImageView);
          return paramBoolean;
          localTextView.setMaxLines(1);
        }
      }
    }
  }
  
  private boolean d(Card paramCard)
  {
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool6 = false;
    boolean bool2 = false;
    boolean bool4;
    boolean bool1;
    if (paramCard != null)
    {
      bool4 = paramCard.isVipOpen(EVIPSPEC.E_SP_QQVIP);
      bool5 = paramCard.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
      if ((paramCard.lUserFlag & 1L) == 1L)
      {
        bool3 = true;
        if ((paramCard.lUserFlag & 0x400) != 1024L) {
          break label205;
        }
        bool1 = true;
        label66:
        if ((!ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (!ProfileActivity.AllInOne.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int))) {
          break label211;
        }
        bool2 = true;
        label98:
        if (!this.jdField_a_of_type_Boolean) {
          break label1057;
        }
        bool2 = false;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("makeOrRefreshAccountLevelInfoView bQQVipOpen=%s bSuperVipOpen=%s bEnterprise=%s bPrettyNumber=%s bShowAccountInfo=%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      int i1;
      if (!bool2)
      {
        if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_account_level_info") != null) {}
        for (i1 = 1;; i1 = 0)
        {
          return 0x0 | i1;
          bool3 = false;
          break;
          label205:
          bool1 = false;
          break label66;
          label211:
          if ((!bool5) && (!bool4) && (paramCard.iQQLevel < 0)) {
            break label98;
          }
          bool2 = true;
          break label98;
        }
      }
      View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_account_level_info");
      if (localView == null)
      {
        localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970568, null);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_account_level_info", localView);
        localView.setClickable(false);
      }
      for (bool2 = true;; bool2 = false)
      {
        TextView localTextView1 = (TextView)localView.findViewById(2131371178);
        URLImageView localURLImageView = (URLImageView)localView.findViewById(2131371179);
        TextView localTextView2 = (TextView)localView.findViewById(2131371180);
        TextView localTextView3 = (TextView)localView.findViewById(2131371181);
        ImageView localImageView = (ImageView)localView.findViewById(2131363443);
        localImageView.setVisibility(0);
        String str;
        Object localObject2;
        Object localObject1;
        int i2;
        label490:
        label505:
        double d1;
        if (this.jdField_a_of_type_JavaLangStringBuilder == null)
        {
          this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(24);
          str = a(bool1, bool5, bool4, paramCard);
          localObject2 = null;
          if ((!bool5) && (!bool4))
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {}
          }
          else
          {
            if (!bool5) {
              break label764;
            }
            i2 = paramCard.getVipLevel(EVIPSPEC.E_SP_SUPERVIP);
            i1 = i2;
            if (i2 < 1) {
              i1 = 1;
            }
            if (paramCard.iQQVipType != 1) {
              break label732;
            }
            localObject1 = "http://i.gtimg.cn/club/mobile/profile/vipicon2016/android/year_svip_" + i1 + ".png";
          }
          if (!TextUtils.isEmpty(str)) {
            break label867;
          }
          localTextView1.setVisibility(8);
          VipGrayConfigHelper.a().a(localURLImageView, bool5, paramCard.namePlateOfKingLoginTime, paramCard.namePlateOfKingGameId, paramCard.namePlateOfKingDan, paramCard.namePlateOfKingDanDisplatSwitch, paramCard.uin);
          if (paramCard.iQQLevel < 0) {
            break label886;
          }
          localTextView2.setText(ProfileCardUtil.a(getContext(), 8, paramCard.iQQLevel, true));
          this.jdField_a_of_type_JavaLangStringBuilder.append(" 等级 ").append(paramCard.iQQLevel).append("级 ");
          localTextView2.setVisibility(0);
          label591:
          d1 = paramCard.uAccelerateMultiple / 10.0D;
          if (d1 >= 0.0D) {
            break label896;
          }
          if (TextUtils.isEmpty(localTextView3.getText()))
          {
            localTextView3.setText("");
            localTextView3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          }
        }
        label732:
        label764:
        do
        {
          for (;;)
          {
            paramCard = localTextView3.getText().toString();
            this.jdField_a_of_type_JavaLangStringBuilder.append(" ").append(paramCard);
            localView.setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder);
            localView.setTag(new DataTag(69, null));
            localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
            a("map_key_account_level_info", null, null, localImageView);
            return bool2;
            this.jdField_a_of_type_JavaLangStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
            break;
            localObject1 = "http://i.gtimg.cn/club/mobile/profile/vipicon2016/android/svip_" + i1 + ".png";
            break label490;
            localObject1 = localObject2;
            if (!bool4) {
              break label490;
            }
            i2 = paramCard.getVipLevel(EVIPSPEC.E_SP_QQVIP);
            i1 = i2;
            if (i2 < 1) {
              i1 = 1;
            }
            if (paramCard.iQQVipType == 1)
            {
              localObject1 = "http://i.gtimg.cn/club/mobile/profile/vipicon2016/android/year_vip_" + i1 + ".png";
              break label490;
            }
            localObject1 = "http://i.gtimg.cn/club/mobile/profile/vipicon2016/android/vip_" + i1 + ".png";
            break label490;
            localTextView1.setVisibility(0);
            a(localTextView1, str, (String)localObject1);
            break label505;
            localTextView2.setVisibility(8);
            break label591;
            if ((!bool4) && (!bool5))
            {
              localTextView3.setText("慢速中");
              localTextView3.setTextColor(-5855578);
            }
            else
            {
              if ((!bool4) || (bool5)) {
                break label971;
              }
              localTextView3.setText(d1 + "倍加速中");
              localTextView3.setTextColor(-28672);
            }
          }
        } while (!bool5);
        label867:
        label886:
        if (paramCard.getVipType(EVIPSPEC.E_SP_SUPERVIP) == 1) {
          localTextView3.setText(d1 + "倍极速中");
        }
        for (;;)
        {
          label896:
          label971:
          localTextView3.setTextColor(-28672);
          break;
          localTextView3.setText(d1 + "倍高速中");
        }
      }
      label1057:
      continue;
      bool4 = false;
      bool1 = false;
      bool2 = bool6;
    }
  }
  
  private boolean d(Card paramCard, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qqstory");
    if (localView == null) {
      paramBoolean = bool1;
    }
    LinearLayout localLinearLayout;
    do
    {
      do
      {
        return paramBoolean;
        localLinearLayout = (LinearLayout)localView.findViewById(2131371152);
        if ((!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramCard == null) || (paramCard.mQQStoryData == null))
        {
          localLinearLayout.setVisibility(8);
          return false;
        }
        localLinearLayout.removeAllViews();
        paramCard = paramCard.getQQStoryList();
        paramBoolean = bool1;
      } while (paramCard == null);
      paramBoolean = bool1;
    } while (paramCard.size() == 0);
    int i2 = AIOUtils.a(80.0F, getResources());
    int i3 = AIOUtils.a(50.0F, getResources());
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i3, i2);
    localLayoutParams.leftMargin = 2;
    localLayoutParams.rightMargin = 2;
    int i1 = 0;
    paramBoolean = bool2;
    for (;;)
    {
      for (;;)
      {
        bool1 = paramBoolean;
        String str;
        ImageView localImageView;
        if (i1 < paramCard.size())
        {
          str = (String)paramCard.get(i1);
          if (!TextUtils.isEmpty(str))
          {
            localImageView = new ImageView(getContext());
            localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
          }
        }
        else
        {
          try
          {
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
            localURLDrawableOptions.mFailedDrawable = localColorDrawable;
            localURLDrawableOptions.mRequestHeight = i2;
            localURLDrawableOptions.mRequestWidth = i3;
            localImageView.setImageDrawable(URLDrawable.getDrawable(str, localURLDrawableOptions));
            localLinearLayout.addView(localImageView, localLayoutParams);
            paramBoolean = true;
            if (i1 >= 4)
            {
              bool1 = true;
              paramBoolean = bool1;
              if (!bool1) {
                break;
              }
              ((TextView)localView.findViewById(2131364119)).setVisibility(8);
              return bool1;
            }
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
            }
          }
        }
      }
      i1 += 1;
    }
  }
  
  private boolean e(Card paramCard)
  {
    if ((!ProfileActivity.AllInOne.i(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramCard == null) || (TextUtils.isEmpty(paramCard.strLastCampusFeeds)))
    {
      if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_campus_feed") != null) {}
      for (bool = true;; bool = false) {
        return bool;
      }
    }
    View localView1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_campus_feed");
    if (localView1 == null)
    {
      localView1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970546, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_campus_feed", localView1);
    }
    for (boolean bool = true;; bool = false)
    {
      TextView localTextView1 = (TextView)localView1.findViewById(2131363378);
      View localView2 = localView1.findViewById(2131362747);
      TextView localTextView2 = (TextView)localView1.findViewById(2131364119);
      ImageView localImageView1 = (ImageView)localView1.findViewById(2131362719);
      ImageView localImageView2 = (ImageView)localView1.findViewById(2131363443);
      localTextView1.setVisibility(8);
      localView2.setVisibility(0);
      localView2.setBackgroundResource(2130842346);
      localTextView2.setText(new QQText(MsgBoxUtil.b(String.format(Locale.getDefault(), "校园圈新发表：%s", new Object[] { paramCard.strLastCampusFeeds })), 6, 16));
      localTextView2.setMaxLines(1);
      localTextView2.setEllipsize(TextUtils.TruncateAt.END);
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(0);
      localView1.setTag(new DataTag(72, null));
      localView1.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      localView1.setContentDescription("校园圈新发表");
      a("map_key_campus_feed", null, localTextView2, localImageView2);
      return bool;
    }
  }
  
  private boolean e(Card paramCard, boolean paramBoolean)
  {
    return false | a(paramCard) | a() | b() | g(paramCard);
  }
  
  private boolean f(Card paramCard)
  {
    ThreadManager.post(new akvt(this), 8, null, true);
    if ((!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramCard == null) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 96))
    {
      if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_qzone") != null) {}
      for (bool1 = true;; bool1 = false) {
        return bool1;
      }
    }
    View localView1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzone");
    if (localView1 == null)
    {
      localView1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970562, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzone", localView1);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      ViewGroup localViewGroup = (ViewGroup)localView1.findViewById(2131371153);
      TextView localTextView1 = (TextView)localView1.findViewById(2131364119);
      ImageView localImageView = (ImageView)localView1.findViewById(2131363443);
      boolean bool2;
      if ((paramCard.ulShowControl & 0x80) != 0) {
        bool2 = true;
      }
      int i1;
      int i3;
      View localView4;
      View localView5;
      TextView localTextView2;
      label572:
      label620:
      int i2;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("makeOrRefreshQZone card.ulShowControl=%x hasLocked=%s", new Object[] { Integer.valueOf(paramCard.ulShowControl), Boolean.valueOf(bool2) }));
        }
        if ((bool2) || (!paramCard.isShowPhoto()) || (!paramCard.hasGotPhotoUrl())) {
          break label757;
        }
        localViewGroup.removeAllViews();
        localViewGroup.setVisibility(0);
        localTextView1.setVisibility(8);
        List localList = paramCard.getQZonePhotoList();
        Object localObject1;
        int i4;
        int i5;
        int i6;
        View localView2;
        Object localObject3;
        View localView3;
        if ((localList != null) && (!localList.isEmpty()))
        {
          localObject1 = getResources();
          i4 = ((Resources)localObject1).getDimensionPixelSize(2131559165);
          i5 = ((Resources)localObject1).getDimensionPixelSize(2131559166);
          i6 = (int)this.jdField_c_of_type_Float;
          i1 = 0;
          i3 = 0;
          if (i3 < localList.size())
          {
            localObject1 = ((PhotoInfo)localList.get(i3)).strPicUrl;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label946;
            }
            localView2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970563, null);
            localObject3 = (ImageView)localView2.findViewById(2131371154);
            localView3 = localView2.findViewById(2131371156);
            localView4 = localView2.findViewById(2131371155);
            localView5 = localView2.findViewById(2131371157);
            localTextView2 = (TextView)localView2.findViewById(2131371158);
            if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
              this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(getResources().getColor(2131493015));
            }
          }
        }
        try
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mRequestHeight = i4;
          localURLDrawableOptions.mRequestWidth = i4;
          ((ImageView)localObject3).setImageDrawable(URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions));
          localViewGroup.addView(localView2);
          localObject3 = (LinearLayout.LayoutParams)localView2.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject3).rightMargin = i5;
          localView2.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          if (((String)localObject1).contains("video=1")) {
            localView3.setVisibility(0);
          }
          for (;;)
          {
            if (((PhotoInfo)localList.get(i3)).IsOnlySelf != 1) {
              break label723;
            }
            localView5.setVisibility(0);
            i1 = i4 + i5 + i1;
            if (i1 + i4 + i5 + 20 <= i6) {
              break label733;
            }
            if (!TextUtils.isEmpty(paramCard.strQzoneHeader))
            {
              localTextView1.setVisibility(0);
              localTextView1.setText(paramCard.strQzoneHeader);
            }
            localView1.setTag(new DataTag(5, null));
            localView1.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
            localView1.setContentDescription(a(2131427372));
            a("map_key_qzone", null, localTextView1, localImageView);
            return bool1;
            bool2 = false;
            break;
            localView3.setVisibility(8);
          }
          i1 = i2;
        }
        catch (Exception localException1)
        {
          i2 = i1;
        }
      }
      label692:
      if (QLog.isColorLevel())
      {
        QLog.e("Q.profilecard.FrdProfileCard", 2, "makeOrRefreshQZone fail!", localException1);
        i1 = i2;
      }
      label946:
      for (;;)
      {
        i3 += 1;
        break;
        label723:
        localView5.setVisibility(8);
        break label572;
        try
        {
          label733:
          localView4.setVisibility(8);
          localTextView2.setVisibility(8);
        }
        catch (Exception localException2)
        {
          i2 = i1;
        }
        break label692;
        label757:
        if ((!bool2) && (paramCard.isShowFeeds()) && (!TextUtils.isEmpty(paramCard.strQzoneFeedsDesc)))
        {
          localViewGroup.setVisibility(8);
          localTextView1.setVisibility(0);
          localTextView1.setText(QzoneContactsFeedUtils.a(paramCard.strQzoneFeedsDesc, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
          break label620;
        }
        if (!TextUtils.isEmpty(paramCard.strSpaceName))
        {
          localViewGroup.setVisibility(8);
          localTextView1.setVisibility(0);
          localTextView1.setText(paramCard.strSpaceName);
          break label620;
        }
        localViewGroup.setVisibility(8);
        localTextView1.setVisibility(0);
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4];
        paramCard = (Card)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramCard = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
        }
        localObject2 = paramCard;
        if (TextUtils.isEmpty(paramCard)) {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        }
        localTextView1.setText(String.format("%s%s", new Object[] { localObject2, a(2131435788) }));
        break label620;
      }
    }
  }
  
  private boolean f(Card paramCard, boolean paramBoolean)
  {
    if ((!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramCard == null) || (paramCard.lCurrentStyleId == ProfileCardTemplate.h))
    {
      if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_shopping_photo") != null) {}
      for (paramBoolean = true;; paramBoolean = false) {
        return paramBoolean;
      }
    }
    ThreadManager.post(new akvy(this, paramCard), 5, null, true);
    return false;
  }
  
  private boolean g(Card paramCard)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo.gameName)))
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_troop_mem_game_info");
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "not show game info");
      }
      return false;
    }
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_troop_mem_game_info");
    paramCard = (Card)localObject1;
    if (localObject1 == null)
    {
      paramCard = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970552, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_troop_mem_game_info", paramCard);
    }
    Object localObject5 = (TextView)paramCard.findViewById(2131362826);
    Object localObject2 = (TextView)paramCard.findViewById(2131371129);
    ((TextView)localObject2).setBackgroundDrawable(TroopUtils.a(getResources(), Color.parseColor("#3094cf")));
    Object localObject4 = (ImageView)paramCard.findViewById(2131371130);
    TextView localTextView1 = (TextView)paramCard.findViewById(2131371131);
    TextView localTextView2 = (TextView)paramCard.findViewById(2131371132);
    localObject1 = (ImageView)paramCard.findViewById(2131363443);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo;
    if (localObject3 != null)
    {
      ((TextView)localObject5).setText(((TroopMemberCard.MemberGameInfo)localObject3).gameName);
      if ((((TroopMemberCard.MemberGameInfo)localObject3).descInfo != null) && (((TroopMemberCard.MemberGameInfo)localObject3).descInfo.size() > 0) && (!TextUtils.isEmpty((CharSequence)((TroopMemberCard.MemberGameInfo)localObject3).descInfo.get(0))))
      {
        localTextView1.setVisibility(0);
        localTextView1.setText((CharSequence)((TroopMemberCard.MemberGameInfo)localObject3).descInfo.get(0));
      }
      if ((((TroopMemberCard.MemberGameInfo)localObject3).descInfo != null) && (((TroopMemberCard.MemberGameInfo)localObject3).descInfo.size() > 1) && (!TextUtils.isEmpty((CharSequence)((TroopMemberCard.MemberGameInfo)localObject3).descInfo.get(1))))
      {
        localTextView2.setVisibility(0);
        localTextView2.setText((CharSequence)((TroopMemberCard.MemberGameInfo)localObject3).descInfo.get(1));
      }
    }
    for (;;)
    {
      try
      {
        int i1 = AIOUtils.a(18.0F, getResources());
        int i2 = AIOUtils.a(18.0F, getResources());
        if (!TextUtils.isEmpty(((TroopMemberCard.MemberGameInfo)localObject3).levelIcon))
        {
          localObject5 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject5).mRequestHeight = i1;
          ((URLDrawable.URLDrawableOptions)localObject5).mRequestWidth = i2;
          ((ImageView)localObject4).setImageDrawable(URLDrawable.getDrawable(((TroopMemberCard.MemberGameInfo)localObject3).levelIcon, (URLDrawable.URLDrawableOptions)localObject5));
        }
        if (!TextUtils.isEmpty(((TroopMemberCard.MemberGameInfo)localObject3).levelName))
        {
          ((TextView)localObject2).setVisibility(0);
          ((TextView)localObject2).setText(((TroopMemberCard.MemberGameInfo)localObject3).levelName);
          float f1 = AIOUtils.a(2.0F, getResources());
          i1 = AIOUtils.a(4.0F, getResources());
          localObject4 = new GradientDrawable();
          ((GradientDrawable)localObject4).setCornerRadius(f1);
          ((TextView)localObject2).setPadding(i1, 0, i1, 0);
          if (TextUtils.isEmpty(((TroopMemberCard.MemberGameInfo)localObject3).gameBackGroundColor)) {
            continue;
          }
          ((GradientDrawable)localObject4).setColor(Color.parseColor(((TroopMemberCard.MemberGameInfo)localObject3).gameBackGroundColor));
          ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject4);
        }
        if (!TextUtils.isEmpty(((TroopMemberCard.MemberGameInfo)localObject3).gameFontColor)) {
          ((TextView)localObject2).setTextColor(Color.parseColor(((TroopMemberCard.MemberGameInfo)localObject3).gameFontColor));
        }
        this.jdField_c_of_type_Boolean = true;
        TroopReportor.a("Grp_game", "Mber_data", "game_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d, ((TroopMemberCard.MemberGameInfo)localObject3).gameName });
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
        continue;
      }
      localObject2 = paramCard.findViewById(2131371103);
      localObject3 = paramCard.findViewById(2131371104);
      if (!TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d))
      {
        ((View)localObject2).setVisibility(0);
        a((View)localObject3);
      }
      paramCard.setTag(new DataTag(83, null));
      paramCard.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramCard.setVisibility(0);
      a("map_key_troop_mem_game_info", null, null, (ImageView)localObject1);
      return true;
      ((GradientDrawable)localObject4).setColor(Color.parseColor("#FFBA26"));
    }
  }
  
  private boolean g(Card paramCard, boolean paramBoolean)
  {
    if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_favor");
      return false;
    }
    ProfileCardFavorShowView localProfileCardFavorShowView2 = (ProfileCardFavorShowView)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_favor");
    ProfileCardFavorShowView localProfileCardFavorShowView1 = localProfileCardFavorShowView2;
    if (localProfileCardFavorShowView2 == null)
    {
      localProfileCardFavorShowView1 = new ProfileCardFavorShowView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localProfileCardFavorShowView1.setTitle("兴趣爱好");
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_favor", localProfileCardFavorShowView1);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity))
    {
      a(localProfileCardFavorShowView1, paramCard);
      a("map_key_favor", null, localProfileCardFavorShowView1.jdField_a_of_type_AndroidWidgetTextView, null);
    }
    return false;
  }
  
  private boolean h(Card paramCard)
  {
    boolean bool = true;
    Object localObject;
    if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
      if (paramCard == null) {
        localObject = null;
      }
    }
    for (;;)
    {
      List localList = a((List)localObject);
      ProfileCardFavorShowView localProfileCardFavorShowView = (ProfileCardFavorShowView)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_favor");
      if ((localList == null) || (localList.size() == 0))
      {
        if (this.jdField_c_of_type_Int > 0)
        {
          if (localProfileCardFavorShowView.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardFavorItemView != null)
          {
            localProfileCardFavorShowView.removeView(localProfileCardFavorShowView.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardFavorItemView);
            localProfileCardFavorShowView.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardFavorItemView = null;
            return true;
            localObject = paramCard.getBusiEntrys();
          }
        }
        else
        {
          this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_favor");
          return false;
        }
      }
      else
      {
        int i1;
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)))
        {
          i1 = 1;
          if (localProfileCardFavorShowView.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardFavorItemView == null) {
            break label446;
          }
        }
        label279:
        label446:
        for (localObject = localProfileCardFavorShowView.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardFavorItemView.a(0);; localObject = null)
        {
          ProfileCardFavorItemView localProfileCardFavorItemView;
          if (localObject == null)
          {
            localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970553, null);
            localProfileCardFavorItemView = new ProfileCardFavorItemView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
            if (this.jdField_c_of_type_Int > 0)
            {
              localProfileCardFavorItemView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              localProfileCardFavorItemView.setTitle("更多兴趣");
              localProfileCardFavorItemView.setArrowVisiale(false);
              ProfileCardTemplate.a(localProfileCardFavorItemView.jdField_a_of_type_AndroidWidgetTextView, "color", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTitleColor");
              label230:
              if (i1 != 0) {
                break label375;
              }
              localProfileCardFavorItemView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130838625);
              localProfileCardFavorItemView.b.setBackgroundResource(0);
              if (this.jdField_c_of_type_Int > 0) {
                localProfileCardFavorItemView.jdField_a_of_type_AndroidViewView.setVisibility(0);
              }
              a(localProfileCardFavorItemView.jdField_a_of_type_AndroidViewView);
              a("map_key_favor", null, localProfileCardFavorItemView.jdField_a_of_type_AndroidWidgetTextView, null);
              localProfileCardFavorItemView.addView((View)localObject);
              localProfileCardFavorShowView.addView(localProfileCardFavorItemView);
              localProfileCardFavorShowView.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardFavorItemView = localProfileCardFavorItemView;
            }
          }
          for (;;)
          {
            localObject = (HorizontalScrollLayout)((View)localObject).findViewById(2131364073);
            a((ViewGroup)localObject, paramCard, localList);
            if (i1 == 0)
            {
              ((HorizontalScrollLayout)localObject).setBackgroundResource(0);
              return bool;
              i1 = 0;
              break;
              localProfileCardFavorItemView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              localProfileCardFavorItemView.jdField_a_of_type_AndroidViewView.setVisibility(8);
              break label230;
              label375:
              ProfileCardTemplate.a(localProfileCardFavorItemView.jdField_a_of_type_AndroidWidgetLinearLayout, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTopBorderBackground");
              ProfileCardTemplate.a(localProfileCardFavorItemView.b, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTopBorderBackground");
              localProfileCardFavorItemView.jdField_a_of_type_AndroidViewView.setVisibility(8);
              break label279;
            }
            ProfileCardTemplate.a((View)localObject, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTopBorderBackground");
            return bool;
            bool = false;
          }
        }
      }
      return false;
      localObject = null;
    }
  }
  
  private boolean h(Card paramCard, boolean paramBoolean)
  {
    if (paramCard == null) {
      return false;
    }
    paramBoolean = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i1;
    ProfileCardFavorShowView localProfileCardFavorShowView;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate != null)
    {
      i1 = 1;
      localProfileCardFavorShowView = (ProfileCardFavorShowView)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_extend_friend_info");
      if (localProfileCardFavorShowView != null) {
        break label815;
      }
      localProfileCardFavorShowView = new ProfileCardFavorShowView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localProfileCardFavorShowView.setTitle("扩列资料");
      localProfileCardFavorShowView.setVisibility(8);
      localProfileCardFavorShowView.setOnClickListener(null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_extend_friend_info", localProfileCardFavorShowView);
    }
    label551:
    label815:
    for (;;)
    {
      Object localObject1 = (ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263);
      ((ExtendFriendManager)localObject1).a();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(paramCard.uin))
      {
        if ((paramCard.extendFriendEntryAddFriend == 0) || (!((ExtendFriendManager)localObject1).a()) || (!paramCard.isShowCard) || (paramCard.extendFriendFlag != 1))
        {
          this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_extend_friend_info");
          return false;
          i1 = 0;
          break;
        }
        Object localObject3;
        Object localObject4;
        if (TextUtils.isEmpty(paramCard.declaration))
        {
          localObject1 = localProfileCardFavorShowView.getChildAt(0);
          if ((localObject1 == null) || (!Boolean.TRUE.equals(((View)localObject1).getTag(0))) || (!new Boolean(paramBoolean).equals(((View)localObject1).getTag(1))) || (!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.equals(((View)localObject1).getTag(2))))
          {
            localProfileCardFavorShowView.removeAllViews();
            if ((!paramBoolean) && (i1 == 0)) {
              break label551;
            }
            localObject1 = LayoutInflater.from(getContext()).inflate(2130970551, null);
            ((View)localObject1).setTag(2131362406, Boolean.valueOf(true));
            ((View)localObject1).setTag(2131362407, Boolean.valueOf(paramBoolean));
            ((View)localObject1).setTag(2131362408, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate);
            localObject2 = (TextView)((View)localObject1).findViewById(2131371126);
            localObject3 = (TextView)((View)localObject1).findViewById(2131371127);
            if (i1 != 0)
            {
              localObject4 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.a.get("commonItemContentColor");
              if (localObject4 != null)
              {
                if (!(localObject4 instanceof ColorStateList)) {
                  break label502;
                }
                ((TextView)localObject2).setTextColor((ColorStateList)localObject4);
                ((TextView)localObject3).setTextColor((ColorStateList)localObject4);
              }
            }
            ((View)localObject1).setClickable(true);
            ((View)localObject1).findViewById(2131371128).setOnClickListener(new akwa(this, paramCard));
            localProfileCardFavorShowView.addView((View)localObject1);
          }
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) {
            a("map_key_extend_friend_info", null, localProfileCardFavorShowView.jdField_a_of_type_AndroidWidgetTextView, null);
          }
          localProfileCardFavorShowView.getTop();
          if (localProfileCardFavorShowView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable)) {
            QLog.i("remilelei", 2, "cancel job to scroll FriendProfileCardActivity");
          }
          localProfileCardFavorShowView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
          return true;
          label502:
          if (!(localObject4 instanceof String)) {
            break;
          }
          localObject4 = (String)localObject4;
          if (!((String)localObject4).startsWith("#")) {
            break;
          }
          ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject4));
          ((TextView)localObject3).setTextColor(Color.parseColor((String)localObject4));
          break;
          localObject2 = LayoutInflater.from(getContext()).inflate(2130970550, null);
          localObject3 = ((View)localObject2).findViewById(2131371125);
          localObject4 = ExtendFriendResourceUtil.a("expand_summary_default_bg.png");
          localObject1 = localObject2;
          if (!FileUtil.a((String)localObject4)) {
            break;
          }
          localObject1 = ExtendFriendResourceUtil.a((String)localObject4, null);
          float f1 = ((Bitmap)localObject1).getWidth() / ((Bitmap)localObject1).getHeight();
          ((View)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(getResources().getDisplayMetrics().widthPixels / f1)));
          ((View)localObject3).setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject1));
          localObject1 = localObject2;
          break;
          a(paramCard, localProfileCardFavorShowView);
        }
      }
      Object localObject2 = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config");
      int i2 = ((SharedPreferences)localObject2).getInt("sp_extend_friend_entry_add_friend", 0);
      if (((SharedPreferences)localObject2).contains("sp_extend_friend_entry_add_friend")) {}
      for (i1 = ((SharedPreferences)localObject2).getInt("sp_extend_friend_entry_add_friend", 0);; i1 = 1)
      {
        if ((i2 == 0) || (!((ExtendFriendManager)localObject1).a()) || (i1 != 1))
        {
          this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_extend_friend_info");
          return false;
        }
        if ((!TextUtils.isEmpty(paramCard.declaration)) && (paramCard.extendFriendFlag == 1) && (paramCard.isShowCard))
        {
          a(paramCard, localProfileCardFavorShowView);
          break;
        }
        this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_extend_friend_info");
        return false;
      }
    }
  }
  
  private boolean i(Card paramCard)
  {
    if ((paramCard == null) || (paramCard.lCurrentStyleId != ProfileCardTemplate.f)) {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_tag");
    }
    while (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean) {
      return false;
    }
    Object localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tag");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970569, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tag", localObject1);
    }
    localObject2 = (AdaptiveLayout)((View)localObject1).findViewById(2131371182);
    int i2 = getResources().getDimensionPixelSize(2131558983);
    int i1 = 7;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      i1 = 8;
    }
    int i3;
    if (this.jdField_a_of_type_ArrayOfAndroidWidgetTextView == null)
    {
      ((AdaptiveLayout)localObject2).setGap(i2, i2);
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[i1];
      i3 = getResources().getDimensionPixelSize(2131558978);
      int i4 = getResources().getDimensionPixelSize(2131558985);
      int i5 = getResources().getDimensionPixelSize(2131558986);
      i2 = 0;
      if (i2 < i1)
      {
        localObject1 = new TextView(getContext());
        this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i2] = localObject1;
        ((TextView)localObject1).setBackgroundResource(2130843911);
        ((TextView)localObject1).setPadding(i4, i4, i4, i4);
        ((TextView)localObject1).setTextSize(0, i3);
        ((TextView)localObject1).setTextColor(-16777216);
        ((TextView)localObject1).setGravity(17);
        if (7 == i2)
        {
          i3 = getResources().getDimensionPixelSize(2131558980);
          ((TextView)localObject1).setTextSize(0, i3);
          ((TextView)localObject1).setTag(new DataTag(47, null));
          ((TextView)localObject1).setText("+");
          ((TextView)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((TextView)localObject1).setPadding(i5, 0, i5, 0);
        }
        for (;;)
        {
          ((AdaptiveLayout)localObject2).addView((View)localObject1);
          i2 += 1;
          break;
          ((TextView)localObject1).setVisibility(8);
        }
      }
    }
    localObject1 = paramCard.getLabelList();
    if ((localObject2 != null) && (localObject1 != null))
    {
      label390:
      label437:
      Object localObject3;
      if (((List)localObject1).size() > 7)
      {
        i2 = 7;
        i3 = 0;
        if (i3 >= i1) {
          break label564;
        }
        localObject2 = this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i3];
        if (i3 >= i2) {
          break label521;
        }
        ((TextView)localObject2).setText(((ProfileLabelInfo)((List)localObject1).get(i3)).labelName);
        ((TextView)localObject2).setVisibility(0);
        if (((TextView)localObject2).getVisibility() == 0)
        {
          localObject3 = ((TextView)localObject2).getBackground();
          if ((localObject3 instanceof GradientDrawable))
          {
            localObject3 = (GradientDrawable)localObject3;
            if (paramCard.backgroundColor != 1L) {
              break label538;
            }
            ((GradientDrawable)localObject3).setColor(-2130706433);
            ((GradientDrawable)localObject3).setStroke(1, 855638016);
            ((TextView)localObject2).setTextColor(-16777216);
          }
        }
      }
      for (;;)
      {
        i3 += 1;
        break label390;
        i2 = ((List)localObject1).size();
        break;
        label521:
        if (i3 >= 7) {
          break label437;
        }
        ((TextView)localObject2).setVisibility(8);
        break label437;
        label538:
        ((GradientDrawable)localObject3).setColor(-2147483648);
        ((GradientDrawable)localObject3).setStroke(1, 872415231);
        ((TextView)localObject2).setTextColor(-1);
      }
    }
    label564:
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean i(Card paramCard, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))) {}
    for (int i1 = 1; (i1 == 0) || (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)); i1 = 0)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_photo_wall");
      return false;
    }
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_photo_wall");
    paramCard = (Card)localObject;
    if (localObject == null)
    {
      localObject = new PhotoWallView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this);
      paramCard = new ProfileCardFavorShowView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      paramCard.setTitle("精选照片");
      paramCard.setVisibility(8);
      paramCard.addView((View)localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_photo_wall", paramCard);
    }
    if ((paramCard instanceof ProfileCardFavorShowView))
    {
      paramCard = (PhotoWallView)((ProfileCardFavorShowView)paramCard).a(0);
      a("map_key_photo_wall", null, paramCard.b, null);
      a("map_key_photo_wall", null, paramCard.c, null);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) {
        ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a(paramCard);
      }
    }
    return true;
  }
  
  private boolean j(Card paramCard, boolean paramBoolean)
  {
    if (paramCard == null) {
      return false;
    }
    int i1;
    label34:
    label51:
    label77:
    label99:
    Object localObject1;
    label138:
    int i2;
    if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      i1 = 1;
      if ((i1 == 0) && (paramCard.personalityLabel != null)) {
        break label285;
      }
      i1 = 1;
      if ((i1 == 0) && (paramCard.personalityLabel.isCloseByUser != 1)) {
        break label290;
      }
      i1 = 1;
      if ((i1 == 0) && ((paramCard.personalityLabel.getSize() != 0) || (paramCard.personalityLabel.remainCount > 0))) {
        break label295;
      }
      i1 = 1;
      if ((i1 == 0) && (!Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label300;
      }
      i1 = 1;
      if ((i1 == 0) && ((paramCard.personalityLabel.getSize() != 0) || (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))) {
        break label305;
      }
      i1 = 1;
      if ((QLog.isColorLevel()) && (paramCard.personalityLabel != null)) {
        QLog.i("ProfileCardUtil.PROFILE_CARD_TAG", 2, "makeOrRefreshPersonalityLabelBoard isCloseByUser:" + paramCard.personalityLabel.isCloseByUser);
      }
      if ((paramBoolean) && (paramCard.personalityLabel != null))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramCard.personalityLabel.isCloseByUser != 1) {
          break label310;
        }
        i2 = 2;
        label215:
        ReportController.b((QQAppInterface)localObject1, "dc00898", "", "", "0X8008408", "0X8008408", i2, 0, "", "", "", "");
      }
      if (i1 == 0) {
        break label316;
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("map_key_personality_label_board")) {
        break label546;
      }
    }
    label285:
    label546:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_personality_label_board");
      return paramBoolean;
      i1 = 0;
      break;
      i1 = 0;
      break label34;
      label290:
      i1 = 0;
      break label51;
      label295:
      i1 = 0;
      break label77;
      label300:
      i1 = 0;
      break label99;
      label305:
      i1 = 0;
      break label138;
      label310:
      i2 = 1;
      break label215;
      label316:
      localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_personality_label_board");
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = new ProfileCardFavorShowView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        localObject2 = new PersonalityLabelBoard(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, (View)localObject1);
        if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) {
          ((PersonalityLabelBoard)localObject2).setScrollListener((PersonalityLabelBoard.IScroll)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        }
        ((ProfileCardFavorShowView)localObject1).setTitle("个性标签");
        ((ProfileCardFavorShowView)localObject1).setVisibility(8);
        ((ProfileCardFavorShowView)localObject1).addView((View)localObject2);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_personality_label_board", localObject1);
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity))
        {
          localObject2 = (OnGetPersonalityLabelsListener)((ProfileCardFavorShowView)localObject1).a(0);
          ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a((OnGetPersonalityLabelsListener)localObject2);
          ((OnGetPersonalityLabelsListener)localObject2).a(paramCard.personalityLabel, paramBoolean, false);
          a((PersonalityLabelBoard)localObject2, (ProfileCardFavorShowView)localObject1);
          paramCard = (View)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_nick_name");
          if ((paramCard != null) && ((paramCard instanceof TextView))) {
            ((OnGetPersonalityLabelsListener)localObject2).setNick((String)((TextView)paramCard).getText());
          }
        }
        return true;
      }
    }
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_troop_mem_game_info");
  }
  
  public MessageRecord a()
  {
    if ((TroopMemberCardConstants.a != null) && (TroopMemberCardConstants.a.length > 0))
    {
      localObject = new StringBuilder();
      int i1 = 0;
      while (i1 < TroopMemberCardConstants.a.length)
      {
        ((StringBuilder)localObject).append(TroopMemberCardConstants.a[i1]);
        if (i1 < TroopMemberCardConstants.a.length - 1) {
          ((StringBuilder)localObject).append(" , ");
        }
        i1 += 1;
      }
    }
    for (Object localObject = ((StringBuilder)localObject).toString();; localObject = null)
    {
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      String str1 = MessageRecord.getTableName(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d, 1);
      String str2 = String.format("shmsgseq < %d and senderuin = ? and extLong & 3 <> 3 and msgtype in (%s)", new Object[] { Long.valueOf(9223372036854775807L), localObject });
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) {}
      for (localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin;; localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)
      {
        localObject = localEntityManager.a(MessageRecord.class, str1, false, str2, new String[] { localObject }, null, null, "shmsgseq DESC", String.valueOf(1));
        localEntityManager.a();
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          break;
        }
        return null;
      }
      return (MessageRecord)((List)localObject).get(0);
    }
  }
  
  public String a(int paramInt)
  {
    return getResources().getString(paramInt);
  }
  
  protected void a()
  {
    ThreadManager.post(new akvw(this), 8, null, true);
  }
  
  public void a(int paramInt)
  {
    int i2 = 2;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onUpdatePhotoWall size:" + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (int i1 = 1;; i1 = 0)
    {
      View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_photo_wall");
      if ((localView != null) && ((i1 != 0) || (paramInt > 0)))
      {
        localView.setVisibility(0);
        if (i1 == 0) {
          break;
        }
        i1 = i2;
        if (paramInt > 0) {
          i1 = 1;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EBC", "0X8007EBC", i1, 0, "", "", "", "");
      }
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EBD", "0X8007EBD", 0, 0, "", "", "", "");
  }
  
  public void a(Card paramCard)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzone");
    if ((paramCard == null) || (localObject == null) || (!TextUtils.isEmpty(paramCard.strQzoneFeedsDesc)) || (!TextUtils.isEmpty(paramCard.strSpaceName))) {}
    TextView localTextView;
    do
    {
      return;
      localTextView = (TextView)((View)localObject).findViewById(2131364119);
    } while (localTextView.getVisibility() != 0);
    localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4];
    paramCard = (Card)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramCard = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
    }
    localObject = paramCard;
    if (TextUtils.isEmpty(paramCard)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    }
    localTextView.setText(String.format("%s%s", new Object[] { localObject, a(2131435788) }));
  }
  
  public void a(Card paramCard, boolean paramBoolean)
  {
    if (a(paramCard, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList)) {
      b();
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(RichStatus paramRichStatus)
  {
    if (a(paramRichStatus)) {
      b();
    }
  }
  
  public void a(MQQProfileName paramMQQProfileName)
  {
    if (c()) {
      b();
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() <= 0) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (!(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity))) {
      QLog.i("notifyProfileActScrollToMoreInfo", 1, "mMoreInfoMap or mActivity is null");
    }
    int i1;
    do
    {
      do
      {
        return;
        paramString = (View)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      } while (paramString == null);
      i1 = paramString.getTop();
      QLog.i("notifyProfileActScrollToMoreInfo", 1, "scroll offset=" + i1);
    } while (i1 < 0);
    ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).c(i1);
  }
  
  public void a(String paramString, TextView paramTextView, View paramView, ImageView paramImageView)
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.a != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.a.size() > 0))
        {
          this.jdField_b_of_type_JavaUtilHashMap.put(paramString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.l));
          ProfileCardTemplate.a(paramTextView, "color", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTitleColor");
          ProfileCardTemplate.a(paramView, "color", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemContentColor");
          ProfileCardTemplate.a(paramImageView, "src", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemMoreSrc");
          return;
        }
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, String.valueOf(0));
        if (paramTextView != null) {
          paramTextView.setTextColor(getResources().getColorStateList(2131494264));
        }
        if ((paramView instanceof TextView))
        {
          ((TextView)paramView).setTextColor(getResources().getColorStateList(2131494214));
          if (paramImageView == null) {
            break;
          }
          paramImageView.setImageResource(2130838484);
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
      if ((paramView instanceof SingleLineTextView)) {
        ((SingleLineTextView)paramView).setTextColor(getResources().getColorStateList(2131494214));
      }
    }
  }
  
  public boolean a(Card paramCard)
  {
    if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d))
    {
      if (QLog.isColorLevel()) {
        QLog.d(ProfileCardMoreInfoView.class.getSimpleName(), 2, "makeOrRefreshTroopMemCharmLevelInfo, isQidianPrivateTroop");
      }
      return false;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_troop_mem_charm_level");
      return false;
    }
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_troop_mem_charm_level");
    paramCard = (Card)localObject;
    if (localObject == null)
    {
      paramCard = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130971674, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_troop_mem_charm_level", paramCard);
    }
    localObject = (TextView)paramCard.findViewById(2131375312);
    ImageView localImageView = (ImageView)paramCard.findViewById(2131368535);
    ((ImageView)paramCard.findViewById(2131371364)).setImageResource(2130846299);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_c_of_type_Int > -1)
    {
      paramCard.setVisibility(0);
      int i1 = AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      Drawable localDrawable = TroopMemberGlobalLevelUtils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_c_of_type_Int);
      localDrawable.setBounds(0, 0, i1, i1);
      ((TextView)localObject).setCompoundDrawables(null, null, localDrawable, null);
      ((TextView)localObject).setText("群聊等级已达LV" + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_c_of_type_Int + " ");
      localImageView.setVisibility(0);
      paramCard.setTag(new DataTag(80, null));
      paramCard.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramCard.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      a("map_key_troop_mem_gift_entry", null, (View)localObject, localImageView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "charm", "exp_grpname", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_c_of_type_Int), "", "", "");
      return true;
    }
    paramCard.setVisibility(8);
    return false;
  }
  
  public boolean a(Card paramCard, boolean paramBoolean, ArrayList paramArrayList)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "build more info map");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d))) {
      label91:
      try
      {
        bool2 = a(paramCard, paramBoolean);
        if (bool2)
        {
          bool2 = true;
          bool1 = bool2;
        }
      }
      catch (Exception paramCard) {}
    }
    try
    {
      bool4 = c();
      if (bool2) {
        break label711;
      }
      if (!bool4) {
        break label126;
      }
    }
    catch (Exception paramCard)
    {
      for (;;)
      {
        continue;
        bool2 = true;
        break;
        bool2 = true;
        continue;
        bool2 = true;
        continue;
        bool2 = true;
        continue;
        bool2 = true;
        continue;
        if ((bool2) || (bool1))
        {
          bool2 = true;
          continue;
          bool2 = true;
          continue;
          bool2 = true;
          continue;
          bool2 = true;
          continue;
          bool2 = true;
          continue;
          bool2 = true;
          continue;
          bool2 = true;
          continue;
          bool2 = true;
          continue;
          bool2 = true;
          continue;
          bool2 = true;
          continue;
          bool2 = true;
          continue;
          paramBoolean = true;
        }
      }
    }
    bool1 = bool2;
    boolean bool4 = e(paramCard, paramBoolean);
    if (!bool2)
    {
      paramBoolean = bool3;
      if (!bool4) {}
    }
    else
    {
      paramBoolean = true;
    }
    label126:
    do
    {
      return paramBoolean;
      bool2 = false;
      break;
      bool2 = false;
      break label91;
      paramBoolean = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("Q.profilecard.FrdProfileCard", 2, "buildMoreInfoMap fail!", paramCard);
    return bool1;
    label171:
    label196:
    label220:
    label485:
    label616:
    try
    {
      bool1 = i(paramCard);
      if (!bool1) {
        break label824;
      }
      bool2 = true;
      bool1 = bool2;
    }
    catch (Exception paramCard)
    {
      label244:
      label510:
      bool1 = bool2;
      label362:
      label622:
      label628:
      label634:
      paramBoolean = bool1;
    }
    label289:
    label313:
    label460:
    try
    {
      bool4 = a(paramCard, paramBoolean);
      if (bool2) {
        break label717;
      }
      if (!bool4) {
        break label830;
      }
    }
    catch (Exception paramCard)
    {
      label337:
      label610:
      break label680;
    }
    bool1 = bool2;
    bool4 = d(paramCard);
    if (!bool2)
    {
      if (!bool4) {
        break label836;
      }
      break label723;
      bool1 = bool2;
      bool4 = a(paramArrayList);
      if (bool2) {
        break label729;
      }
      if (!bool4) {
        break label842;
      }
      break label729;
      bool1 = bool2;
      bool4 = c();
      if (bool2) {
        break label735;
      }
      if (!bool4) {
        break label848;
      }
      break label735;
    }
    for (;;)
    {
      if (paramCard == null)
      {
        bool1 = bool2;
        bool4 = a(null);
        bool1 = bool4;
        break label741;
        bool1 = bool2;
        bool4 = e(paramCard);
        if (bool2) {
          break label757;
        }
        if (!bool4) {
          break label610;
        }
        break label757;
        bool1 = bool2;
        bool4 = f(paramCard);
        if (bool2) {
          break label763;
        }
        if (!bool4) {
          break label616;
        }
        break label763;
        bool1 = bool2;
        bool4 = b(paramCard, paramBoolean);
        if (bool2) {
          break label769;
        }
        if (!bool4) {
          break label622;
        }
        break label769;
        bool1 = bool2;
        bool4 = e(paramCard, paramBoolean);
        if (bool2) {
          break label775;
        }
        if (!bool4) {
          break label628;
        }
        break label775;
        label387:
        bool1 = bool2;
        bool4 = b(paramCard);
        if (bool2) {
          break label781;
        }
        if (!bool4) {
          break label634;
        }
        break label781;
        label411:
        bool1 = bool2;
        bool4 = c(paramCard);
        if (bool2) {
          break label787;
        }
        if (!bool4) {
          break label640;
        }
        break label787;
        label435:
        bool1 = bool2;
        bool4 = f(paramCard, paramBoolean);
        if (bool2) {
          break label793;
        }
        if (!bool4) {
          break label646;
        }
        break label793;
        bool1 = bool2;
        bool4 = i(paramCard, paramBoolean);
        if (bool2) {
          break label799;
        }
        if (!bool4) {
          break label652;
        }
        break label799;
        bool1 = bool2;
        bool4 = j(paramCard, paramBoolean);
        if (bool2) {
          break label805;
        }
        if (!bool4) {
          break label658;
        }
        break label805;
        bool1 = bool2;
        bool4 = h(paramCard, paramBoolean);
        if (bool2) {
          break label811;
        }
        if (!bool4) {
          break label664;
        }
        break label811;
        label535:
        bool1 = bool2;
        paramBoolean = g(paramCard, paramBoolean);
        if (bool2) {
          break label817;
        }
        if (!paramBoolean) {
          break label670;
        }
        break label817;
      }
      for (;;)
      {
        bool1 = paramBoolean;
        bool2 = h(paramCard);
        if (paramBoolean) {
          break label822;
        }
        paramBoolean = bool3;
        if (!bool2) {
          break;
        }
        break label822;
        bool1 = bool2;
        bool4 = a(paramCard.getRichStatus());
        bool1 = bool4;
        break label741;
        bool2 = false;
        break label289;
        bool2 = false;
        break label313;
        bool2 = false;
        break label337;
        bool2 = false;
        break label362;
        bool2 = false;
        break label387;
        bool2 = false;
        break label411;
        label640:
        bool2 = false;
        break label435;
        label646:
        bool2 = false;
        break label460;
        label652:
        bool2 = false;
        break label485;
        label658:
        bool2 = false;
        break label510;
        label664:
        bool2 = false;
        break label535;
        label670:
        paramBoolean = false;
      }
      label680:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.profilecard.FrdProfileCard", 2, "buildMoreInfoMap fail!", paramCard);
      return bool1;
      label711:
      label717:
      label723:
      label729:
      label735:
      label741:
      label757:
      label763:
      return true;
      label769:
      label775:
      label781:
      label787:
      label793:
      label799:
      label805:
      label811:
      label817:
      label822:
      label824:
      bool2 = false;
      break label171;
      label830:
      bool2 = false;
      break label196;
      label836:
      bool2 = false;
      break label220;
      label842:
      bool2 = false;
      break label244;
      label848:
      bool2 = false;
    }
  }
  
  public boolean a(ProfileCardTemplate paramProfileCardTemplate)
  {
    if (paramProfileCardTemplate == null) {}
    for (paramProfileCardTemplate = "0"; this.jdField_b_of_type_JavaUtilHashMap.size() > 0; paramProfileCardTemplate = String.valueOf(paramProfileCardTemplate.l))
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
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "update more info");
    }
    removeAllViews();
    List localList = a(this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_b_of_type_Int);
    int i1;
    View localView2;
    View localView3;
    View localView5;
    int i2;
    label140:
    int i3;
    label142:
    View localView6;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)))
    {
      i1 = 1;
      View localView1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_account_base_info");
      localView2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_phone");
      localView3 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_photo_wall");
      View localView4 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_personality_label_board");
      localView5 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_favor");
      if (localList == null) {
        break label213;
      }
      i2 = localList.size();
      i3 = 0;
      if (i3 >= i2) {
        return;
      }
      localView6 = (View)localList.get(i3);
      if ((localView6 != localView1) && (localView6 != localView4)) {
        break label218;
      }
    }
    for (;;)
    {
      if ((localView6.getVisibility() != 0) && (localView6 != localView3)) {
        localView6.setVisibility(0);
      }
      addView(localView6);
      i3 += 1;
      break label142;
      i1 = 0;
      break;
      label213:
      i2 = 0;
      break label140;
      label218:
      if (localView6 != localView2) {
        if (i1 != 0) {
          ProfileCardTemplate.a(localView6, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTopBorderBackground");
        } else if ((localView6 != localView3) && (localView6 != localView5)) {
          localView6.setBackgroundResource(2130838625);
        }
      }
    }
  }
  
  public void b(Card paramCard)
  {
    i(paramCard);
  }
  
  /* Error */
  public void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: ifnull +22 -> 28
    //   9: aload_0
    //   10: getfield 56	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   13: invokevirtual 2163	java/util/HashMap:size	()I
    //   16: ifle +12 -> 28
    //   19: aload_0
    //   20: getfield 820	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   23: astore_3
    //   24: aload_3
    //   25: ifnonnull +6 -> 31
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: getfield 56	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   35: aload_1
    //   36: invokevirtual 445	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   39: ifeq -11 -> 28
    //   42: ldc 108
    //   44: aload_1
    //   45: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   48: ifeq -20 -> 28
    //   51: aload_0
    //   52: getfield 56	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   55: aload_1
    //   56: invokevirtual 448	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   59: checkcast 185	android/view/View
    //   62: astore_1
    //   63: aload_0
    //   64: getfield 137	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   67: getfield 142	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   70: getfield 375	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   73: aload_0
    //   74: getfield 369	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   77: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   80: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: istore_2
    //   84: aload_0
    //   85: aload_1
    //   86: invokespecial 2261	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:a	(Landroid/view/View;)Z
    //   89: ifeq +8 -> 97
    //   92: aload_0
    //   93: iload_2
    //   94: invokespecial 2263	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:a	(Z)V
    //   97: iload_2
    //   98: ifne -70 -> 28
    //   101: aload_1
    //   102: instanceof 772
    //   105: ifeq -77 -> 28
    //   108: aload_1
    //   109: checkcast 772	com/tencent/mobileqq/widget/ProfileCardFavorShowView
    //   112: iconst_0
    //   113: invokevirtual 774	com/tencent/mobileqq/widget/ProfileCardFavorShowView:a	(I)Landroid/view/View;
    //   116: astore_1
    //   117: aload_1
    //   118: instanceof 818
    //   121: ifeq -93 -> 28
    //   124: aload_0
    //   125: aload_1
    //   126: checkcast 818	com/tencent/mobileqq/widget/ProfileCardExtendFriendView
    //   129: getfield 2265	com/tencent/mobileqq/widget/ProfileCardExtendFriendView:e	Landroid/widget/TextView;
    //   132: invokespecial 2261	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:a	(Landroid/view/View;)Z
    //   135: ifeq -107 -> 28
    //   138: aload_0
    //   139: getfield 2267	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:t	Z
    //   142: ifne -114 -> 28
    //   145: aload_0
    //   146: getfield 369	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   149: ldc_w 1032
    //   152: ldc_w 657
    //   155: ldc_w 657
    //   158: ldc_w 2269
    //   161: ldc_w 2269
    //   164: iconst_0
    //   165: iconst_0
    //   166: ldc_w 657
    //   169: ldc_w 657
    //   172: ldc_w 657
    //   175: ldc_w 657
    //   178: invokestatic 664	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload_0
    //   182: iconst_1
    //   183: putfield 2267	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:t	Z
    //   186: goto -158 -> 28
    //   189: astore_1
    //   190: aload_0
    //   191: monitorexit
    //   192: aload_1
    //   193: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	ProfileCardMoreInfoView
    //   0	194	1	paramString	String
    //   83	15	2	bool	boolean
    //   23	2	3	localBaseActivity	BaseActivity
    // Exception table:
    //   from	to	target	type
    //   2	24	189	finally
    //   31	97	189	finally
    //   101	186	189	finally
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() <= 0) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (!(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity))) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (ProfileCardFavorShowView)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_extend_friend_info");
      } while ((localObject == null) || (!(((ProfileCardFavorShowView)localObject).a(0) instanceof ProfileCardExtendFriendView)));
      localObject = (ProfileCardExtendFriendView)((ProfileCardFavorShowView)localObject).a(0);
    } while (localObject == null);
    ((ProfileCardExtendFriendView)localObject).a();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    QLog.i("ProfileCardMoreInfoView", 2, "ProfileCardMoreInfoView change=" + paramBoolean + " l=" + paramInt1 + " t=" + paramInt2 + " r=" + paramInt3 + " b=" + paramInt4);
  }
  
  public void setNewSignature(byte[] paramArrayOfByte, long paramLong)
  {
    EntityManager localEntityManager;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (localObject != null) {
        break label105;
      }
      localObject = null;
      if (localObject != null) {
        break label125;
      }
      localObject = new Card();
      ((Card)localObject).uin = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      ((Card)localObject).vRichSign = paramArrayOfByte;
      ((Card)localObject).lSignModifyTime = paramLong;
      localEntityManager.a((Entity)localObject);
    }
    for (;;)
    {
      a(((Card)localObject).getRichStatus());
      return;
      label105:
      localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      break;
      label125:
      ((Card)localObject).vRichSign = paramArrayOfByte;
      ((Card)localObject).lSignModifyTime = paramLong;
      localEntityManager.a((Entity)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardMoreInfoView
 * JD-Core Version:    0.7.0.1
 */