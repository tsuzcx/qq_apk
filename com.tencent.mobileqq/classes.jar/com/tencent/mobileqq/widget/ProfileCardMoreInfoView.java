package com.tencent.mobileqq.widget;

import QQService.EVIPSPEC;
import QQService.PrivilegeInfo;
import SummaryCard.PhotoInfo;
import aavw;
import aciy;
import ajjj;
import ajjy;
import ajve;
import akbm;
import amko;
import amkp;
import amkq;
import amkr;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.format.DateFormat;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anoe;
import antz;
import apdh;
import atax;
import atmo;
import atmp;
import atmq;
import atuw;
import atvb;
import atvi;
import atwx;
import atxe;
import atxj;
import atxl;
import atxm;
import atxn;
import atxr;
import atyz;
import atza;
import auoc;
import avev;
import avfz;
import avga;
import avgf;
import awnu;
import awqx;
import axkd;
import axkn;
import azlj;
import azuc;
import azvq;
import azwg;
import azwh;
import azyf;
import azyk;
import azzx;
import azzz;
import babh;
import bacm;
import baig;
import bajq;
import baop;
import bbkk;
import bbld;
import bbln;
import bblo;
import bblp;
import bblq;
import bblr;
import bbls;
import bblt;
import bblu;
import bblv;
import bbma;
import bbme;
import bbmg;
import bboi;
import bfpr;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.BaseActivity;
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
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.widget.MiniAppProfileCardGuestView;
import com.tencent.mobileqq.mini.widget.MiniAppProfileCardView;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.profile.view.ProfileQVipDiyView;
import com.tencent.mobileqq.profile.view.ProfileQVipV5View;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.SingleLineTextView;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import cooperation.troop.TroopPluginManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mjg;
import mqq.os.MqqHandler;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.LongNickItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.RspBody;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.TopicItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.UinItem;
import wzm;

public class ProfileCardMoreInfoView
  extends LinearLayout
  implements aavw, avga, azwh, bbld
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public atwx a;
  public atxe a;
  private azwg jdField_a_of_type_Azwg;
  public bblv a;
  private bbma jdField_a_of_type_Bbma;
  private final bbmg jdField_a_of_type_Bbmg = new bbmg(this);
  public BaseActivity a;
  public QQAppInterface a;
  public ProfileHeaderView a;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ProfileCardMoreInfoView.1(this);
  private String jdField_a_of_type_JavaLangString;
  HashMap<String, View> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map<String, CircleBoarderImageView> jdField_a_of_type_JavaUtilMap;
  private wzm jdField_a_of_type_Wzm;
  boolean jdField_a_of_type_Boolean;
  private TextView[] jdField_a_of_type_ArrayOfAndroidWidgetTextView;
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "map_key_account_base_info", "map_key_tag", "map_key_sig", "map_key_phone", "map_key_troop_mem_add_time", "map_key_troop_mem_charm_level", "map_key_troop_mem_recent_said", "map_key_troop_mem_game_info", "map_key_account_level_info", "map_key_medal_and_diamond", "map_key_qzone", "map_key_present", "map_key_music_box", "map_key_mine_weishi", "map_key_photo_wall", "map_key_personality_label_board", "map_key_extend_friend_info", "map_key_favor", "map_key_mini_playing" };
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private HashMap<String, String> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_b_of_type_Boolean = false;
  private final String[] jdField_b_of_type_ArrayOfJavaLangString = { "map_key_medal_and_diamond", "map_key_troop_mem_add_time", "map_key_troop_mem_charm_level", "map_key_troop_mem_recent_said", "map_key_troop_mem_game_info" };
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  protected boolean c;
  private final String[] jdField_c_of_type_ArrayOfJavaLangString = { "map_key_troop_mem_add_time", "map_key_account_level_info", "map_key_medal_and_diamond", "map_key_qzone", "map_key_present", "map_key_mine_weishi" };
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  public boolean d;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  public boolean e;
  public boolean f;
  public volatile boolean g = false;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  
  public ProfileCardMoreInfoView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ProfileCardMoreInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private int a(Card paramCard)
  {
    if ((paramCard != null) && (paramCard.enlargeQzonePic == 1)) {
      return 3;
    }
    return 4;
  }
  
  private int a(List<PrivilegeInfo> paramList, LinearLayout paramLinearLayout, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, Drawable paramDrawable, boolean paramBoolean)
  {
    int i2 = 0;
    int n = 0;
    if (i2 < paramList.size())
    {
      PrivilegeInfo localPrivilegeInfo = (PrivilegeInfo)paramList.get(i2);
      int i1 = n;
      if (!TextUtils.isEmpty(localPrivilegeInfo.strDeluxeIconUrl))
      {
        if (n == 0) {}
        for (i1 = 0;; i1 = paramInt1)
        {
          n += 1;
          paramArrayOfInt[0] = (paramArrayOfInt[0] - paramInt2 - i1);
          if (paramArrayOfInt[0] >= 0) {
            break;
          }
          paramInt1 = n;
          if (QLog.isColorLevel())
          {
            QLog.d("ProfileCardMoreInfoView", 1, "medal list layout is big =" + localPrivilegeInfo.iIsBig + " icon index=" + n);
            paramInt1 = n;
          }
          return paramInt1;
        }
        a(localPrivilegeInfo, localPrivilegeInfo.strDeluxeIconUrl, paramLinearLayout, paramInt2, paramInt3, i1, paramDrawable, paramBoolean);
        i1 = n;
      }
      if (!TextUtils.isEmpty(localPrivilegeInfo.strIconUrl))
      {
        if (i1 == 0) {}
        for (n = 0;; n = paramInt1)
        {
          i1 += 1;
          paramArrayOfInt[0] = (paramArrayOfInt[0] - paramInt2 - n);
          if (paramArrayOfInt[0] >= 0) {
            break label268;
          }
          paramInt1 = i1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ProfileCardMoreInfoView", 1, "medal list layout is big =" + localPrivilegeInfo.iIsBig + " icon index=" + i1);
          return i1;
        }
        label268:
        a(localPrivilegeInfo, localPrivilegeInfo.strIconUrl, paramLinearLayout, paramInt2, paramInt3, n, paramDrawable, paramBoolean);
      }
      for (n = i1;; n = i1)
      {
        i2 += 1;
        break;
      }
    }
    return n;
  }
  
  private ViewGroup a(ViewGroup paramViewGroup, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramViewGroup != null) && (paramInt1 > 0) && (!TextUtils.isEmpty(paramString)))
    {
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495402, null);
      View localView = localViewGroup.findViewById(2131302061);
      TextView localTextView = (TextView)localViewGroup.findViewById(2131302466);
      localView.setBackgroundResource(paramInt1);
      localTextView.setText(paramString.trim());
      paramViewGroup.addView(localViewGroup);
      if (paramInt2 == 1) {
        azyk.a(localTextView, null, null, this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      }
      a("map_key_phone", null, localTextView, null);
      return localViewGroup;
    }
    return null;
  }
  
  private ViewGroup a(ViewGroup paramViewGroup, ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if ((paramViewGroup == null) || (paramCardContactInfo == null)) {
      return null;
    }
    paramCardContactInfo = paramCardContactInfo.jdField_c_of_type_JavaLangString;
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495404, null);
    View localView = localViewGroup.findViewById(2131302713);
    TextView localTextView = (TextView)localViewGroup.findViewById(2131302466);
    ImageView localImageView = (ImageView)localViewGroup.findViewById(2131297252);
    localView.setVisibility(0);
    localView.setBackgroundResource(2130844862);
    localTextView.setText(paramCardContactInfo);
    paramViewGroup.addView(localViewGroup);
    a("map_key_phone", null, localTextView, localImageView);
    return localViewGroup;
  }
  
  private ImageView a(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, Drawable paramDrawable)
  {
    URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)paramFloat1, (int)paramFloat2);
    localLayoutParams.leftMargin = ((int)paramFloat3);
    localLayoutParams.gravity = 16;
    localURLImageView.setLayoutParams(localLayoutParams);
    paramDrawable = baop.a(paramString, baop.b, paramDrawable);
    if (paramDrawable != null)
    {
      ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), localURLImageView);
      if (paramDrawable.getStatus() == 2)
      {
        localURLImageView.setVisibility(8);
        paramDrawable.restartDownload();
      }
      localURLImageView.setImageDrawable(paramDrawable);
      localURLImageView.setURLDrawableDownListener(new bbme(localURLImageView, paramString, "showDiamondImage onLoadFailed iconUrl = "));
      return localURLImageView;
    }
    QLog.e("QVipSettingMe.ProfileCardMoreInfoView", 1, "apn drawable get null!iconUrl:" + paramString);
    return localURLImageView;
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
    paramString1 = TextUtils.ellipsize(paramString1, paramTextView, this.jdField_e_of_type_Float - f3 - (f1 + 5.0F * f2), TextUtils.TruncateAt.END);
    paramTextView = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramTextView = "...";
    }
    return String.format("%s(%s)", new Object[] { paramTextView, paramString2 });
  }
  
  public static String a(atwx paramatwx)
  {
    Object localObject2 = paramatwx.jdField_a_of_type_ArrayOfJavaLangString[4];
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramatwx.jdField_a_of_type_ArrayOfJavaLangString[0];
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    }
    return localObject2;
  }
  
  private List<View> a(HashMap<String, View> paramHashMap, String[] paramArrayOfString)
  {
    return ((ProfileQVipDiyView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).a(paramHashMap, paramArrayOfString);
  }
  
  private void a(PrivilegeInfo paramPrivilegeInfo, String paramString, LinearLayout paramLinearLayout, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, boolean paramBoolean)
  {
    paramString = a(paramString, paramInt1, paramInt2, paramInt3, paramDrawable);
    paramLinearLayout.addView(paramString);
    if (!TextUtils.isEmpty(paramPrivilegeInfo.strJumpUrl))
    {
      paramString.setClickable(true);
      paramString.setTag(new atuw(93, paramPrivilegeInfo));
      paramString.setOnClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramLinearLayout = new StringBuilder();
      a(paramLinearLayout, paramPrivilegeInfo);
      paramLinearLayout.append("徽章");
      paramString.setContentDescription(paramLinearLayout);
      paramString = "";
      switch (paramPrivilegeInfo.iType)
      {
      default: 
        if ((this.jdField_d_of_type_Int & 0x8) == 0)
        {
          if (paramBoolean)
          {
            paramString = "0X800A136";
            label151:
            this.jdField_d_of_type_Int |= 0x8;
          }
        }
        else {
          label162:
          if (!TextUtils.isEmpty(paramString))
          {
            if (paramPrivilegeInfo.iIsBig != 1) {
              break label407;
            }
            if (!paramPrivilegeInfo.isOpen) {
              break label401;
            }
            paramInt1 = 1;
          }
        }
        break;
      }
    }
    for (;;)
    {
      paramLinearLayout = "";
      if (paramPrivilegeInfo.iType != 1)
      {
        paramPrivilegeInfo = paramLinearLayout;
        if (!paramString.equals("0X800A136")) {}
      }
      else
      {
        paramPrivilegeInfo = String.valueOf(ajve.b(ajve.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())));
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qvip", paramString, paramInt1, 0, paramPrivilegeInfo, "", "", "");
      return;
      paramString.setTag(null);
      paramString.setOnClickListener(null);
      paramString.setClickable(false);
      break;
      if ((this.jdField_d_of_type_Int & 0x1) != 0) {
        break label162;
      }
      if (paramBoolean) {}
      for (paramString = "0X800A132";; paramString = "0X800A12A")
      {
        this.jdField_d_of_type_Int |= 0x1;
        break;
      }
      if ((this.jdField_d_of_type_Int & 0x2) != 0) {
        break label162;
      }
      if (paramBoolean) {}
      for (paramString = "0X800A134";; paramString = "0X800A12C")
      {
        this.jdField_d_of_type_Int |= 0x2;
        break;
      }
      if ((this.jdField_d_of_type_Int & 0x4) != 0) {
        break label162;
      }
      if (paramBoolean) {}
      for (paramString = "0X800A130";; paramString = "0X800A128")
      {
        this.jdField_d_of_type_Int |= 0x4;
        break;
      }
      paramString = "0X800A12E";
      break label151;
      label401:
      paramInt1 = 2;
      continue;
      label407:
      if (paramPrivilegeInfo.isOpen) {
        paramInt1 = 3;
      } else {
        paramInt1 = 4;
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_JavaLangString = ThemeUtil.getCurrentThemeId();
    paramContext = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics();
    this.jdField_a_of_type_Float = paramContext.density;
    this.jdField_b_of_type_Float = Math.min(paramContext.widthPixels, paramContext.heightPixels);
    this.jdField_c_of_type_Float = (this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131166019) + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131166292) + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131166293));
    float f1 = this.jdField_a_of_type_Float;
    int n = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131166289);
    int i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131166290);
    this.jdField_d_of_type_Float = (7.0F * f1 + n + i1);
    this.jdField_e_of_type_Float = (this.jdField_b_of_type_Float - this.jdField_c_of_type_Float - this.jdField_d_of_type_Float);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private void a(LinearLayout paramLinearLayout, Card paramCard)
  {
    List localList = paramCard.getBigOrderEntrys();
    int i2 = 0;
    if (localList != null)
    {
      paramLinearLayout.removeAllViews();
      int n;
      int i1;
      label40:
      atxm localatxm;
      int i3;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)))
      {
        n = 1;
        i1 = 0;
        if (i1 >= localList.size()) {
          break label863;
        }
        localatxm = (atxm)localList.get(i1);
        i3 = i2;
        if (!TextUtils.isEmpty(localatxm.jdField_a_of_type_JavaLangString))
        {
          if (localatxm.jdField_a_of_type_JavaUtilArrayList != null) {
            break label111;
          }
          i3 = i2;
        }
      }
      for (;;)
      {
        i1 += 1;
        i2 = i3;
        break label40;
        n = 0;
        break;
        label111:
        i3 = i2;
        if (localatxm.jdField_a_of_type_Int != 5) {
          if ((localatxm.jdField_a_of_type_Int == 4) && (this.jdField_a_of_type_Bbma != null))
          {
            i3 = i2;
            if (!this.jdField_a_of_type_Bbma.a(5)) {}
          }
          else if ((localatxm.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Bbma != null))
          {
            i3 = i2;
            if (!this.jdField_a_of_type_Bbma.a(4)) {}
          }
          else
          {
            ProfileCardFavorShowView localProfileCardFavorShowView = a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
            localProfileCardFavorShowView.setTitle(localatxm.jdField_a_of_type_JavaLangString);
            i3 = 0;
            if (i3 < localatxm.jdField_a_of_type_JavaUtilArrayList.size())
            {
              atxn localatxn = (atxn)localatxm.jdField_a_of_type_JavaUtilArrayList.get(i3);
              ProfileCardFavorItemDetailView localProfileCardFavorItemDetailView = new ProfileCardFavorItemDetailView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
              localProfileCardFavorItemDetailView.setTitle(localatxn.jdField_a_of_type_JavaLangString);
              localProfileCardFavorItemDetailView.setContent(localatxn.jdField_d_of_type_JavaLangString);
              localProfileCardFavorItemDetailView.setDesc(localatxn.e);
              Drawable localDrawable = getResources().getDrawable(2131100636);
              paramCard = localDrawable;
              if (!TextUtils.isEmpty(localatxn.jdField_b_of_type_JavaLangString))
              {
                paramCard = URLDrawable.URLDrawableOptions.obtain();
                paramCard.mLoadingDrawable = localDrawable;
                paramCard.mRequestWidth = aciy.a(70.0F, getResources());
                paramCard.mRequestHeight = aciy.a(70.0F, getResources());
                paramCard = URLDrawable.getDrawable(localatxn.jdField_b_of_type_JavaLangString, paramCard);
              }
              localProfileCardFavorItemDetailView.setIcon(paramCard);
              if (!TextUtils.isEmpty(localatxn.f)) {
                localProfileCardFavorItemDetailView.a(localatxn.f, 2);
              }
              if ((localatxn.jdField_a_of_type_JavaUtilArrayList != null) && (localatxn.jdField_a_of_type_JavaUtilArrayList.size() > 0))
              {
                int i4 = 0;
                while (i4 < localatxn.jdField_a_of_type_JavaUtilArrayList.size())
                {
                  paramCard = (atxl)localatxn.jdField_a_of_type_JavaUtilArrayList.get(i4);
                  localProfileCardFavorItemDetailView.a(null, paramCard.jdField_a_of_type_JavaLangString, Color.rgb((int)paramCard.b.a, (int)paramCard.b.b, (int)paramCard.b.c), 3);
                  i4 += 1;
                }
              }
              label527:
              boolean bool;
              if (n != 0)
              {
                a("map_key_favor", localProfileCardFavorItemDetailView.b, localProfileCardFavorItemDetailView.jdField_a_of_type_AndroidWidgetTextView, null);
                a("map_key_favor", localProfileCardFavorItemDetailView.c, null, null);
                atxe.a(localProfileCardFavorItemDetailView, "background", this.jdField_a_of_type_Atxe, "commonItemTopBorderBackground");
                localProfileCardFavorItemDetailView.setTag(new atuw(62, localatxn));
                localProfileCardFavorItemDetailView.setOnClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
                localProfileCardFavorShowView.addView(localProfileCardFavorItemDetailView);
                if (i3 == 0) {
                  break label628;
                }
                bool = true;
                label570:
                localProfileCardFavorItemDetailView.setNeedTopMargin(bool);
                switch (localatxn.jdField_a_of_type_Int)
                {
                }
              }
              for (;;)
              {
                i3 += 1;
                break;
                localProfileCardFavorItemDetailView.setBackgroundResource(2130839146);
                break label527;
                label628:
                bool = false;
                break label570;
                if (localatxn.jdField_b_of_type_Int == 0)
                {
                  if (!this.i)
                  {
                    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070B1", "0X80070B1", 0, 0, "", "", "", "");
                    this.i = true;
                  }
                }
                else if (!this.j)
                {
                  awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070AD", "0X80070AD", 0, 0, "", "", "", "");
                  this.j = true;
                  continue;
                  if (!this.k)
                  {
                    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070A9", "0X80070A9", 0, 0, "", "", "", "");
                    this.k = true;
                  }
                }
              }
            }
            a("map_key_favor", null, localProfileCardFavorShowView.jdField_a_of_type_AndroidWidgetTextView, localProfileCardFavorShowView.jdField_a_of_type_AndroidWidgetImageView);
            paramCard = new atuw(61, localatxm);
            localProfileCardFavorShowView.jdField_a_of_type_AndroidViewViewGroup.setTag(paramCard);
            localProfileCardFavorShowView.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramLinearLayout.addView(localProfileCardFavorShowView);
            i3 = i2 + 1;
          }
        }
      }
      label863:
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Int = i2;
    }
  }
  
  private void a(Card paramCard, ProfileCardFavorShowView paramProfileCardFavorShowView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCardMoreInfoView", 2, "fillUpExtendFriendInfo");
    }
    boolean bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i1;
    Object localObject;
    int n;
    if (this.jdField_a_of_type_Atwx.jdField_a_of_type_Atxe != null)
    {
      i1 = 1;
      localObject = paramProfileCardFavorShowView.a(0);
      if (localObject == null) {
        break label469;
      }
      if (i1 == 0) {
        break label345;
      }
      atxe localatxe = (atxe)((View)localObject).getTag(2131306274);
      if ((localatxe != null) && (localatxe.equals(this.jdField_a_of_type_Atwx.jdField_a_of_type_Atxe))) {
        break label469;
      }
      n = 1;
    }
    for (;;)
    {
      label89:
      boolean bool1;
      if ((localObject == null) || (!Boolean.FALSE.equals(((View)localObject).getTag(2131306275))) || (!new Boolean(bool2).equals(((View)localObject).getTag(2131306276))) || (n != 0))
      {
        paramProfileCardFavorShowView.removeAllViews();
        paramProfileCardFavorShowView.setFocusable(false);
        paramProfileCardFavorShowView.setClickable(false);
        if (i1 == 0) {
          break label463;
        }
        localObject = this.jdField_a_of_type_Atxe.a.get("commonItemContentColor");
        if (localObject == null) {
          break label458;
        }
        if ((localObject instanceof ColorStateList))
        {
          n = ((ColorStateList)localObject).getDefaultColor();
          label194:
          localObject = new float[3];
          Color.colorToHSV(n, (float[])localObject);
          if (localObject[2] <= 0.5F) {
            break label396;
          }
          bool1 = true;
        }
      }
      for (;;)
      {
        label219:
        if (bool2)
        {
          localObject = new ProfileCardExtendFriendView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, true);
          label239:
          if ((this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 96) || (this.jdField_e_of_type_Boolean)) {
            ((ProfileCardExtendFriendView)localObject).setFold(false);
          }
          ((ProfileCardExtendFriendView)localObject).setClickable(true);
          ((ProfileCardExtendFriendView)localObject).setTag(2131306275, Boolean.valueOf(false));
          ((ProfileCardExtendFriendView)localObject).setTag(2131306276, Boolean.valueOf(bool2));
          ((ProfileCardExtendFriendView)localObject).setTag(2131306274, this.jdField_a_of_type_Atwx.jdField_a_of_type_Atxe);
          paramProfileCardFavorShowView.addView((View)localObject);
        }
        for (;;)
        {
          ((ProfileCardExtendFriendView)localObject).setIsFromLimitChat(this.f);
          ((ProfileCardExtendFriendView)localObject).a(paramCard, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
          i1 = 0;
          break;
          label345:
          if (((View)localObject).getTag(2131306274) == null) {
            break label469;
          }
          n = 1;
          break label89;
          if (!(localObject instanceof String)) {
            break label458;
          }
          localObject = (String)localObject;
          if (!((String)localObject).startsWith("#")) {
            break label458;
          }
          n = Color.parseColor((String)localObject);
          break label194;
          label396:
          bool1 = false;
          break label219;
          if (i1 != 0)
          {
            localObject = new ProfileCardExtendFriendView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Atwx.jdField_a_of_type_Atxe, bool1);
            break label239;
          }
          localObject = new ProfileCardExtendFriendView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          break label239;
          localObject = (ProfileCardExtendFriendView)localObject;
        }
        label458:
        n = 0;
        break label194;
        label463:
        bool1 = false;
      }
      label469:
      n = 0;
    }
  }
  
  private void a(MiniAppProfileCardGuestView paramMiniAppProfileCardGuestView)
  {
    Object localObject = this.jdField_a_of_type_Atxe.a.get("commonItemContentColor");
    if (localObject != null)
    {
      if (!(localObject instanceof ColorStateList)) {
        break label34;
      }
      paramMiniAppProfileCardGuestView.setTextColor((ColorStateList)localObject);
    }
    label34:
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof String));
      localObject = (String)localObject;
    } while (!((String)localObject).startsWith("#"));
    paramMiniAppProfileCardGuestView.setTextColor(Color.parseColor((String)localObject));
  }
  
  private void a(MiniAppProfileCardView paramMiniAppProfileCardView)
  {
    Object localObject = this.jdField_a_of_type_Atxe.a.get("commonItemContentColor");
    if (localObject != null)
    {
      if (!(localObject instanceof ColorStateList)) {
        break label34;
      }
      paramMiniAppProfileCardView.setTextColor((ColorStateList)localObject);
    }
    label34:
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof String));
      localObject = (String)localObject;
    } while (!((String)localObject).startsWith("#"));
    paramMiniAppProfileCardView.setTextColor(Color.parseColor((String)localObject));
  }
  
  /* Error */
  private void a(PersonalityLabelBoard paramPersonalityLabelBoard, ProfileCardFavorShowView paramProfileCardFavorShowView)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 113
    //   3: aconst_null
    //   4: aload_2
    //   5: getfield 728	com/tencent/mobileqq/widget/ProfileCardFavorShowView:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   8: aconst_null
    //   9: invokevirtual 257	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:a	(Ljava/lang/String;Landroid/widget/TextView;Landroid/view/View;Landroid/widget/ImageView;)V
    //   12: aload_0
    //   13: getfield 697	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Atxe	Latxe;
    //   16: ifnull +276 -> 292
    //   19: aload_0
    //   20: getfield 697	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Atxe	Latxe;
    //   23: getfield 775	atxe:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   26: ifnull +266 -> 292
    //   29: aload_0
    //   30: getfield 697	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Atxe	Latxe;
    //   33: getfield 775	atxe:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   36: invokevirtual 846	java/util/concurrent/ConcurrentHashMap:size	()I
    //   39: ifle +253 -> 292
    //   42: aload_0
    //   43: getfield 68	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   46: ldc 113
    //   48: aload_0
    //   49: getfield 697	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Atxe	Latxe;
    //   52: getfield 849	atxe:o	J
    //   55: invokestatic 852	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   58: invokevirtual 856	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: pop
    //   62: aload_0
    //   63: getfield 697	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Atxe	Latxe;
    //   66: getfield 775	atxe:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   69: ldc_w 777
    //   72: invokevirtual 782	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: astore 8
    //   77: aload 8
    //   79: ifnull +359 -> 438
    //   82: aload 8
    //   84: instanceof 784
    //   87: ifeq +167 -> 254
    //   90: aload 8
    //   92: checkcast 784	android/content/res/ColorStateList
    //   95: astore 8
    //   97: aload_1
    //   98: getfield 861	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   101: ifnull +330 -> 431
    //   104: aload_1
    //   105: getfield 861	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   108: invokevirtual 865	com/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView:a	()I
    //   111: istore_3
    //   112: aload_0
    //   113: getfield 408	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   116: ifnull +259 -> 375
    //   119: aload_0
    //   120: getfield 408	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   123: instanceof 576
    //   126: ifne +249 -> 375
    //   129: iconst_1
    //   130: istore 4
    //   132: iload 4
    //   134: ifeq +8 -> 142
    //   137: aload_2
    //   138: iconst_1
    //   139: invokevirtual 772	com/tencent/mobileqq/widget/ProfileCardFavorShowView:setClickable	(Z)V
    //   142: aload_0
    //   143: getfield 465	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   146: invokestatic 748	com/tencent/mobileqq/theme/ThemeUtil:isInNightMode	(Lmqq/app/AppRuntime;)Z
    //   149: istore 7
    //   151: aload_0
    //   152: getfield 244	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Atwx	Latwx;
    //   155: getfield 749	atwx:jdField_a_of_type_Atxe	Latxe;
    //   158: ifnull +223 -> 381
    //   161: iconst_1
    //   162: istore 5
    //   164: iload 7
    //   166: ifne +221 -> 387
    //   169: iload 5
    //   171: ifne +216 -> 387
    //   174: iconst_1
    //   175: istore 6
    //   177: aload_1
    //   178: iload 6
    //   180: invokevirtual 868	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:setIsNormalTheme	(Z)V
    //   183: aload_1
    //   184: getfield 861	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   187: ifnull +30 -> 217
    //   190: iload 4
    //   192: ifeq +201 -> 393
    //   195: aload_1
    //   196: getfield 861	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   199: aconst_null
    //   200: invokevirtual 871	com/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   203: aload 8
    //   205: ifnull +201 -> 406
    //   208: aload_1
    //   209: getfield 861	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   212: aload 8
    //   214: invokevirtual 872	com/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView:setTextColor	(Landroid/content/res/ColorStateList;)V
    //   217: iload 7
    //   219: ifeq +23 -> 242
    //   222: iload 4
    //   224: ifeq +18 -> 242
    //   227: aload_0
    //   228: ldc 113
    //   230: aload_1
    //   231: getfield 873	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   234: aload_1
    //   235: getfield 876	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   238: aconst_null
    //   239: invokevirtual 257	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:a	(Ljava/lang/String;Landroid/widget/TextView;Landroid/view/View;Landroid/widget/ImageView;)V
    //   242: aload 8
    //   244: ifnull +173 -> 417
    //   247: aload_1
    //   248: aload 8
    //   250: invokevirtual 879	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:setTextColors	(Landroid/content/res/ColorStateList;)V
    //   253: return
    //   254: aload 8
    //   256: instanceof 77
    //   259: ifeq +179 -> 438
    //   262: aload 8
    //   264: checkcast 77	java/lang/String
    //   267: astore 8
    //   269: aload 8
    //   271: ldc_w 819
    //   274: invokevirtual 823	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   277: ifeq +161 -> 438
    //   280: aload 8
    //   282: invokestatic 827	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   285: pop
    //   286: aconst_null
    //   287: astore 8
    //   289: goto -192 -> 97
    //   292: aload_0
    //   293: getfield 68	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   296: ldc 113
    //   298: iconst_0
    //   299: invokestatic 481	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   302: invokevirtual 856	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   305: pop
    //   306: aload_0
    //   307: invokevirtual 623	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:getResources	()Landroid/content/res/Resources;
    //   310: ldc_w 880
    //   313: invokevirtual 884	android/content/res/Resources:getColorStateList	(I)Landroid/content/res/ColorStateList;
    //   316: astore 8
    //   318: goto -221 -> 97
    //   321: astore 9
    //   323: aconst_null
    //   324: astore 8
    //   326: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq +34 -> 363
    //   332: ldc_w 886
    //   335: iconst_2
    //   336: new 175	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   343: ldc_w 888
    //   346: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload 9
    //   351: invokevirtual 891	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   354: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: aload 9
    //   365: invokevirtual 894	java/lang/Exception:printStackTrace	()V
    //   368: ldc_w 895
    //   371: istore_3
    //   372: goto -260 -> 112
    //   375: iconst_0
    //   376: istore 4
    //   378: goto -246 -> 132
    //   381: iconst_0
    //   382: istore 5
    //   384: goto -220 -> 164
    //   387: iconst_0
    //   388: istore 6
    //   390: goto -213 -> 177
    //   393: aload_1
    //   394: getfield 861	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   397: ldc_w 712
    //   400: invokevirtual 896	com/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView:setBackgroundResource	(I)V
    //   403: goto -200 -> 203
    //   406: aload_1
    //   407: getfield 861	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   410: iload_3
    //   411: invokevirtual 897	com/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView:setTextColor	(I)V
    //   414: goto -197 -> 217
    //   417: aload_1
    //   418: iload_3
    //   419: invokestatic 899	android/content/res/ColorStateList:valueOf	(I)Landroid/content/res/ColorStateList;
    //   422: invokevirtual 879	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:setTextColors	(Landroid/content/res/ColorStateList;)V
    //   425: return
    //   426: astore 9
    //   428: goto -102 -> 326
    //   431: ldc_w 895
    //   434: istore_3
    //   435: goto -323 -> 112
    //   438: aconst_null
    //   439: astore 8
    //   441: goto -344 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	444	0	this	ProfileCardMoreInfoView
    //   0	444	1	paramPersonalityLabelBoard	PersonalityLabelBoard
    //   0	444	2	paramProfileCardFavorShowView	ProfileCardFavorShowView
    //   111	324	3	n	int
    //   130	247	4	i1	int
    //   162	221	5	i2	int
    //   175	214	6	bool1	boolean
    //   149	69	7	bool2	boolean
    //   75	365	8	localObject	Object
    //   321	43	9	localException1	Exception
    //   426	1	9	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   12	77	321	java/lang/Exception
    //   82	97	321	java/lang/Exception
    //   254	286	321	java/lang/Exception
    //   292	318	321	java/lang/Exception
    //   97	112	426	java/lang/Exception
  }
  
  private void a(String paramString, CircleBoarderImageView paramCircleBoarderImageView)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_Azwg != null)
    {
      Bitmap localBitmap = this.jdField_a_of_type_Azwg.a(1, paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        localObject = localBitmap;
        if (!this.jdField_a_of_type_Azwg.a())
        {
          this.jdField_a_of_type_Azwg.a(paramString, 1, true);
          this.jdField_a_of_type_JavaUtilMap.put(paramString, paramCircleBoarderImageView);
          localObject = localBitmap;
        }
      }
    }
    paramString = localObject;
    if (localObject == null) {
      paramString = bacm.a();
    }
    paramString = new BitmapDrawable(paramString);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      paramString.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    paramCircleBoarderImageView.setImageDrawable(paramString);
  }
  
  private void a(StringBuilder paramStringBuilder, PrivilegeInfo paramPrivilegeInfo)
  {
    if (paramPrivilegeInfo == null) {
      return;
    }
    switch (paramPrivilegeInfo.iType)
    {
    default: 
      return;
    case 1: 
      paramStringBuilder.append("会员");
      return;
    case 2: 
      paramStringBuilder.append("超级QQ");
      return;
    case 4: 
      paramStringBuilder.append("好莱坞会员");
      return;
    case 3: 
      paramStringBuilder.append("超级会员");
      return;
    case 5: 
      paramStringBuilder.append("腾讯图书VIP");
      return;
    case 104: 
      paramStringBuilder.append("情侣黄钻");
      return;
    case 103: 
      paramStringBuilder.append("绿钻");
      return;
    case 101: 
      paramStringBuilder.append("红钻");
      return;
    case 105: 
      paramStringBuilder.append("超级星钻");
      return;
    case 102: 
      paramStringBuilder.append("黄钻");
      return;
    }
    paramStringBuilder.append("大会员");
  }
  
  private void a(StringBuilder paramStringBuilder, List<PrivilegeInfo> paramList)
  {
    if ((paramStringBuilder == null) || (paramList == null)) {}
    for (;;)
    {
      return;
      int n = 0;
      while (n < paramList.size())
      {
        a(paramStringBuilder, (PrivilegeInfo)paramList.get(n));
        n += 1;
      }
    }
  }
  
  private void a(List<PrivilegeInfo> paramList, LinearLayout paramLinearLayout, boolean paramBoolean)
  {
    float f1 = 20.0F * this.jdField_a_of_type_Float;
    float f2 = 20.0F * this.jdField_a_of_type_Float;
    float f3 = 2.0F * this.jdField_a_of_type_Float;
    float f4 = this.jdField_a_of_type_Float;
    f4 = 5.0F * this.jdField_a_of_type_Float;
    float f5 = 6.0F * this.jdField_a_of_type_Float;
    float f6 = 8.0F * this.jdField_a_of_type_Float;
    float f7 = this.jdField_a_of_type_Float;
    f7 = this.jdField_a_of_type_Float;
    float f8 = 36.0F * this.jdField_a_of_type_Float;
    if ((paramLinearLayout == null) || (paramList == null) || (paramList.size() < 1)) {}
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    int n;
    Object localObject;
    int i1;
    label162:
    label192:
    LinearLayout localLinearLayout;
    LinearLayout.LayoutParams localLayoutParams1;
    LinearLayout.LayoutParams localLayoutParams2;
    int[] arrayOfInt;
    int i2;
    label385:
    do
    {
      return;
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      n = 0;
      if (n < paramList.size())
      {
        localObject = (PrivilegeInfo)paramList.get(n);
        if (((PrivilegeInfo)localObject).iIsBig == 1)
        {
          i1 = 1;
          if (i1 == 0) {
            break label192;
          }
          localArrayList1.add(localObject);
        }
        for (;;)
        {
          n += 1;
          break;
          i1 = 0;
          break label162;
          localArrayList2.add(localObject);
        }
      }
      paramList = new ColorDrawable(16777215);
      localObject = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout)localObject).setOrientation(0);
      ((LinearLayout)localObject).setLayoutParams(localLayoutParams1);
      localLinearLayout.setOrientation(0);
      localLinearLayout.setLayoutParams(localLayoutParams2);
      arrayOfInt = new int[1];
      if (QzoneConfig.getInstance().getConfig("qqsetting", "usersummarycardmedalicon", 0) != 0) {
        break;
      }
      n = 1;
      if (n == 0) {
        break label500;
      }
      arrayOfInt[0] = ((int)(this.jdField_e_of_type_Float - f3));
      i2 = a(localArrayList1, localLinearLayout, (int)f3, arrayOfInt, (int)f8, (int)f8, paramList, paramBoolean);
      if (i2 > 0) {
        arrayOfInt[0] -= (int)f5;
      }
      if (i2 <= 0) {
        break label492;
      }
      i1 = (int)f6;
      i1 = a(localArrayList2, (LinearLayout)localObject, i1, arrayOfInt, (int)f1, (int)f2, paramList, paramBoolean);
      paramLinearLayout.setOrientation(0);
      if (i2 > 0) {
        paramLinearLayout.addView(localLinearLayout);
      }
    } while (i1 <= 0);
    if (i2 > 0)
    {
      if (n != 0) {
        localLayoutParams1.leftMargin = ((int)f5);
      }
    }
    else
    {
      label446:
      if (n == 0) {
        break label611;
      }
      localLayoutParams2.gravity = 16;
      localLayoutParams1.gravity = 16;
    }
    for (;;)
    {
      localLinearLayout.setLayoutParams(localLayoutParams2);
      ((LinearLayout)localObject).setLayoutParams(localLayoutParams1);
      paramLinearLayout.addView((View)localObject);
      return;
      n = 0;
      break;
      label492:
      i1 = (int)f4;
      break label385;
      label500:
      arrayOfInt[0] = ((int)(this.jdField_e_of_type_Float - f3));
      i2 = a(localArrayList1, localLinearLayout, 0, arrayOfInt, (int)f8, (int)f8, paramList, paramBoolean);
      arrayOfInt[0] = ((int)(this.jdField_e_of_type_Float - f6 - f3));
      if (i2 > 0) {}
      for (i1 = (int)(16.0F * f7);; i1 = (int)f4)
      {
        i1 = a(localArrayList2, (LinearLayout)localObject, i1, arrayOfInt, (int)f1, (int)f2, paramList, paramBoolean);
        paramLinearLayout.setOrientation(1);
        break;
      }
      localLayoutParams1.leftMargin = ((int)f6);
      break label446;
      label611:
      localLayoutParams1.topMargin = ((int)f3);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int n = 2;
    if (this.m) {
      return;
    }
    String str2;
    String str1;
    if (paramBoolean)
    {
      str2 = "0X80092DA";
      str1 = str2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.declaration))
      {
        n = 1;
        str1 = str2;
      }
    }
    for (;;)
    {
      this.m = true;
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str1, str1, n, 0, "", "", "", "");
      return;
      str2 = "0X80092E1";
      str1 = str2;
      if (this.jdField_e_of_type_Boolean)
      {
        n = 1;
        str1 = str2;
      }
    }
  }
  
  private boolean a(int paramInt, View paramView)
  {
    int i1 = 1;
    Object localObject1 = this.jdField_c_of_type_ArrayOfJavaLangString;
    int i2 = localObject1.length;
    int n = 0;
    Object localObject2;
    if (n < i2)
    {
      localObject2 = localObject1[n];
      if (paramView != this.jdField_a_of_type_JavaUtilHashMap.get(localObject2)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (awnu.a()) {
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
          paramView = (View)localObject1;
          if (localObject1 == null)
          {
            paramInt = (int)(this.jdField_a_of_type_Float * 0.75F);
            if (paramInt >= 1) {
              break label238;
            }
            paramInt = i1;
          }
        }
        label238:
        for (;;)
        {
          paramView = new View(getContext());
          localObject1 = new LinearLayout.LayoutParams(-1, paramInt);
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          ((LinearLayout.LayoutParams)localObject1).leftMargin = ((int)this.jdField_c_of_type_Float);
          ((LinearLayout.LayoutParams)localObject1).topMargin = ((int)(this.jdField_a_of_type_Float * 6.0F));
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = ((int)(this.jdField_a_of_type_Float * 6.0F));
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, paramView);
          paramView.setBackgroundResource(2130848786);
          addView(paramView);
          return bool;
          n += 1;
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
    return localRect.intersect(new Rect(0, 0, bajq.a(), bajq.b()));
  }
  
  private boolean a(RichStatus paramRichStatus)
  {
    if ((this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && ((!ProfileActivity.AllInOne.g(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramRichStatus == null) || (Arrays.equals(paramRichStatus.encode(), RichStatus.getEmptyStatus().encode())))) {
      return this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_sig") != null;
    }
    boolean bool1;
    Resources localResources;
    int n;
    int i1;
    label109:
    Object localObject1;
    if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      bool1 = true;
      localResources = getResources();
      if (!b()) {
        break label183;
      }
      n = localResources.getColor(2131101260);
      i1 = localResources.getColor(2131101260);
      localObject1 = null;
      if (paramRichStatus != null) {
        localObject1 = new SpannableString(paramRichStatus.toSpannableStringWithTopic(null, n, i1, this));
      }
      if (localObject1 != null) {
        break label1574;
      }
      localObject1 = new SpannableString("");
    }
    label522:
    label1184:
    label1574:
    for (;;)
    {
      if ((!bool1) && (((SpannableString)localObject1).length() == 0))
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_sig") != null)
        {
          return true;
          bool1 = false;
          break;
          label183:
          i1 = localResources.getColor(2131099738);
          n = -8947849;
          break label109;
        }
        return false;
      }
      Object localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sig");
      if (localObject2 == null)
      {
        localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495430, null);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sig", localObject2);
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        View localView = ((View)localObject2).findViewById(2131307374);
        TextView localTextView = (TextView)((View)localObject2).findViewById(2131302466);
        LinearLayout localLinearLayout = (LinearLayout)((View)localObject2).findViewById(2131303773);
        ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131297252);
        avev localavev = (avev)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
        localTextView.setTextColor(n);
        Object localObject3;
        label476:
        label638:
        boolean bool3;
        if ((paramRichStatus != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
        {
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject1);
          localSpannableStringBuilder.insert(0, "[S] ");
          if (localavev != null)
          {
            localObject3 = localavev.a(paramRichStatus.actionId, 200);
            localObject3 = new bboi(localResources, (Bitmap)localObject3, false, false);
            n = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
            ((BitmapDrawable)localObject3).setBounds(0, 0, n, n);
            localObject3 = new bbkk((Drawable)localObject3, 0);
            ((bbkk)localObject3).a(-0.1F);
            localSpannableStringBuilder.setSpan(localObject3, 0, "[S]".length(), 17);
            this.jdField_c_of_type_Int = n;
            localTextView.setText(new axkd(localSpannableStringBuilder, 1, 20));
            localTextView.setMovementMethod(LinkMovementMethod.getInstance());
            if (((SpannableString)localObject1).length() != 0)
            {
              if ((paramRichStatus != null) && (paramRichStatus.topics != null) && (paramRichStatus.topics.size() > 0))
              {
                if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
                  break label1128;
                }
                n = 1;
                awqx.b(null, "dc00898", "", "", "0X800A4D2", "0X800A4D2", n, 0, "0" + n, "0", "", "");
              }
              if ((!atxr.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (paramRichStatus != null) && (paramRichStatus.topics != null) && (paramRichStatus.topics.size() > 0) && (!this.jdField_e_of_type_Boolean))
              {
                if (paramRichStatus.plainText.size() <= 0) {
                  break label1133;
                }
                localObject1 = (String)paramRichStatus.plainText.get(0);
                this.jdField_d_of_type_JavaLangString = ((String)localObject1);
                paramRichStatus.sortTopicPos();
                if ((paramRichStatus.topicsPos == null) || (paramRichStatus.topicsPos.size() <= 0)) {
                  break label1139;
                }
                n = ((Integer)((Pair)paramRichStatus.topicsPos.get(0)).second).intValue();
                label690:
                this.jdField_b_of_type_Int = n;
                if (!a(localTextView)) {
                  break label1144;
                }
                localTextView.post(new ProfileCardMoreInfoView.7(this, localTextView, paramRichStatus));
              }
              label720:
              atxr.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRichStatus);
              bool3 = atxr.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              localObject2 = (ImageView)((View)localObject2).findViewById(2131311641);
              localObject1 = new oidb_0xd9f.RspBody();
              if ((this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo == null)) {
                break label1235;
              }
            }
          }
        }
        try
        {
          ((oidb_0xd9f.RspBody)localObject1).mergeFrom(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo);
          localObject1 = (oidb_0xd9f.LongNickItem)((oidb_0xd9f.RspBody)localObject1).longnick_item.get();
          if (localObject1 == null) {
            break label1184;
          }
          localObject1 = ((oidb_0xd9f.LongNickItem)localObject1).rpt_topic_item.get();
          label832:
          if ((!bool3) && (!atxr.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, atxr.a().a((List)localObject1)))) {
            break label1224;
          }
          if ((localObject1 == null) || (((List)localObject1).size() <= 0) || (atxr.a().a((List)localObject1) <= 0)) {
            break label1190;
          }
          localLinearLayout.setTag(new atuw(97, atxr.a().a((List)localObject1)));
          localLinearLayout.setOnClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
          a(localLinearLayout, (List)localObject1);
          ((ImageView)localObject2).setOnTouchListener(mjg.a);
          ((ImageView)localObject2).setOnClickListener(new bblt(this, localLinearLayout));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            label949:
            if (QLog.isColorLevel())
            {
              QLog.i("Q.profilecard.SummaryCard", 2, localException.toString());
              continue;
              a(localLinearLayout, bool1);
            }
          }
        }
        localObject1 = new StringBuilder();
        if (paramRichStatus != null)
        {
          if (paramRichStatus.actionText != null) {
            ((StringBuilder)localObject1).append(paramRichStatus.actionText);
          }
          if (paramRichStatus.dataText != null) {
            ((StringBuilder)localObject1).append(paramRichStatus.dataText);
          }
          label1128:
          label1133:
          if (paramRichStatus.topics != null)
          {
            n = 0;
            label1005:
            if (n < paramRichStatus.topics.size())
            {
              if (TextUtils.isEmpty((CharSequence)((Pair)paramRichStatus.topics.get(n)).second)) {}
              for (;;)
              {
                n += 1;
                break label1005;
                localObject3 = azvq.a(localResources, 2130848301);
                break;
                this.jdField_c_of_type_Int = 0;
                if ((((SpannableString)localObject1).length() == 0) && (bool1))
                {
                  localTextView.setText(2131633620);
                  a(localLinearLayout, bool1);
                  break label476;
                }
                localTextView.setText(new axkd((CharSequence)localObject1, 1, 20));
                localTextView.setMovementMethod(LinkMovementMethod.getInstance());
                break label476;
                n = 2;
                break label522;
                localObject1 = null;
                break label638;
                label1139:
                n = 0;
                break label690;
                label1144:
                this.jdField_a_of_type_AndroidWidgetTextView = localTextView;
                this.jdField_b_of_type_JavaLangString = ((String)((Pair)paramRichStatus.topics.get(0)).second);
                this.jdField_c_of_type_JavaLangString = paramRichStatus.actionText;
                break label720;
                localObject1 = null;
                break label832;
                a(localLinearLayout, bool1);
                break label949;
                a(localLinearLayout, bool1);
                break label949;
                localException.append((String)((Pair)paramRichStatus.topics.get(n)).second);
              }
            }
          }
          label1190:
          label1224:
          label1235:
          if (paramRichStatus.plainText != null) {}
          for (n = paramRichStatus.plainText.size();; n = 0)
          {
            i1 = 0;
            while (i1 < n)
            {
              localObject2 = (String)paramRichStatus.plainText.get(i1);
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                localException.append((String)localObject2);
              }
              i1 += 1;
            }
          }
        }
        localView.setContentDescription(ajjy.a(2131642694) + localException);
        if ((paramRichStatus != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
        {
          this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
          if ((this.jdField_a_of_type_Bblv == null) && (localavev != null))
          {
            this.jdField_a_of_type_Bblv = new bblv(this);
            localavev.a(this.jdField_a_of_type_Bblv);
          }
          localView.setTag(new atuw(3, localException));
          if ((this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || ((this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))) {
            break label1545;
          }
          localImageView.setVisibility(0);
          localView.setOnClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
          label1490:
          if (!bool1) {
            break label1554;
          }
          a("map_key_sig", null, null, localImageView);
        }
        for (;;)
        {
          return bool2;
          this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
          if ((this.jdField_a_of_type_Bblv == null) || (localavev == null)) {
            break;
          }
          localavev.b(this.jdField_a_of_type_Bblv);
          this.jdField_a_of_type_Bblv = null;
          break;
          localImageView.setVisibility(4);
          break label1490;
          a("map_key_sig", null, localTextView, localImageView);
        }
      }
    }
  }
  
  private boolean a(ArrayList<ProfileActivity.CardContactInfo> paramArrayList)
  {
    int i2 = 0;
    Object localObject1 = this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    if ((ProfileActivity.AllInOne.i(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80)) {}
    for (int n = 1;; n = 0)
    {
      if ((localObject1 == null) || (paramArrayList == null) || (paramArrayList.isEmpty())) {
        n = 0;
      }
      if (n == 0) {
        return this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_phone") != null;
      }
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_phone");
      if (localViewGroup == null)
      {
        localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495415, null);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_phone", localViewGroup);
      }
      for (boolean bool = true;; bool = false)
      {
        if (this.jdField_a_of_type_Atwx.jdField_a_of_type_Azuc.a != null) {
          this.jdField_a_of_type_Atwx.jdField_a_of_type_Azuc.a.clear();
        }
        Object localObject2;
        label223:
        int i1;
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)))
        {
          n = 1;
          localViewGroup.removeAllViews();
          localObject2 = a(localViewGroup, 2130844841, ((ContactCard)localObject1).nickName, 1);
          if (localObject2 != null)
          {
            if (n == 0) {
              break label413;
            }
            atxe.a((View)localObject2, "background", this.jdField_a_of_type_Atxe, "commonItemTopBorderBackground");
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext;
          int i3 = ((ContactCard)localObject1).bSex;
          if (!azyk.b()) {
            break label424;
          }
          i1 = 0;
          label244:
          localObject1 = a(localViewGroup, 2130844850, azyk.a((Context)localObject2, i3, i1, ((ContactCard)localObject1).strCountry, ((ContactCard)localObject1).strProvince, ((ContactCard)localObject1).strCity), 1);
          if (localObject1 != null)
          {
            if (n == 0) {
              break label433;
            }
            atxe.a((View)localObject1, "background", this.jdField_a_of_type_Atxe, "commonItemTopBorderBackground");
          }
          label303:
          i3 = paramArrayList.size();
          i1 = i2;
          label312:
          if (i1 >= i3) {
            break label455;
          }
          localObject1 = (ProfileActivity.CardContactInfo)paramArrayList.get(i1);
          localObject2 = a(localViewGroup, (ProfileActivity.CardContactInfo)localObject1);
          if (localObject2 != null)
          {
            if (n == 0) {
              break label444;
            }
            atxe.a((View)localObject2, "background", this.jdField_a_of_type_Atxe, "commonItemTopBorderBackground");
          }
        }
        for (;;)
        {
          ((ViewGroup)localObject2).setTag(new atuw(4, localObject1));
          ((ViewGroup)localObject2).setOnClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((ViewGroup)localObject2).setOnLongClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          i1 += 1;
          break label312;
          n = 0;
          break;
          label413:
          ((ViewGroup)localObject2).setBackgroundResource(2130839147);
          break label223;
          label424:
          i1 = ((ContactCard)localObject1).bAge;
          break label244;
          label433:
          ((ViewGroup)localObject1).setBackgroundResource(2130839147);
          break label303;
          label444:
          ((ViewGroup)localObject2).setBackgroundResource(2130839146);
        }
        label455:
        return bool;
      }
    }
  }
  
  private int b(Card paramCard)
  {
    if ((paramCard != null) && (paramCard.enlargeQzonePic == 1)) {
      return 4;
    }
    return 3;
  }
  
  private List<View> b(HashMap<String, View> paramHashMap, String[] paramArrayOfString)
  {
    int i1 = 0;
    ArrayList localArrayList = new ArrayList();
    int n;
    Object localObject;
    if ((paramHashMap == null) || (paramArrayOfString == null))
    {
      n = 0;
      if (i1 >= n) {
        break label136;
      }
      localObject = paramArrayOfString[i1];
      if ((!"map_key_sig".equals(localObject)) || (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap == null) || (!this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.containsKey("map_key_sign"))) {
        break label92;
      }
    }
    for (;;)
    {
      i1 += 1;
      break;
      n = paramArrayOfString.length;
      break;
      label92:
      if ((!"map_key_account_base_info".equals(localObject)) || (!b()))
      {
        localObject = (View)paramHashMap.get(localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    label136:
    return localArrayList;
  }
  
  private static void b(View paramView, atwx paramatwx)
  {
    paramView.setVisibility(0);
    Context localContext = paramView.getContext();
    TextView localTextView = (TextView)paramView.findViewById(2131302720);
    ImageView localImageView = (ImageView)paramView.findViewById(2131297252);
    if (!TextUtils.isEmpty(paramatwx.jdField_b_of_type_JavaLangString))
    {
      localTextView.setText(paramatwx.jdField_b_of_type_JavaLangString);
      localTextView.setContentDescription(paramatwx.jdField_b_of_type_JavaLangString);
      localImageView.setVisibility(0);
      paramView.setOnClickListener(paramatwx.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    localTextView.setText(localContext.getString(2131632106));
    localTextView.setContentDescription(localContext.getString(2131632106));
    localImageView.setVisibility(0);
    paramView.setOnClickListener(paramatwx.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private boolean b(View paramView)
  {
    int[] arrayOfInt = new int[2];
    int n = getResources().getDisplayMetrics().heightPixels;
    paramView.getLocationInWindow(arrayOfInt);
    int i1 = arrayOfInt[1];
    return ((FriendProfileCardActivity)this.jdField_a_of_type_AndroidContentContext).findViewById(2131306278).getHeight() + i1 < n;
  }
  
  private boolean b(Card paramCard)
  {
    boolean bool5 = false;
    boolean bool7 = a(this.jdField_a_of_type_Atwx);
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    if (this.jdField_a_of_type_Boolean)
    {
      bool1 = false;
      bool2 = false;
      bool3 = false;
      bool4 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("makeOrRefreshAccountLevelInfoView bQQVipOpen=%s bSuperVipOpen=%s bEnterprise=%s bPrettyNumber=%s bShowAccountInfo=%s bShowMedal=%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Boolean.valueOf(bool7) }));
      }
      boolean bool6;
      if ((!bool1) && (!bool7))
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_account_level_info") != null)
        {
          return true;
          if (paramCard == null) {
            break label653;
          }
          bool4 = paramCard.isVipOpen(EVIPSPEC.E_SP_QQVIP);
          bool6 = paramCard.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
          if ((paramCard.lUserFlag & 1L) == 1L)
          {
            bool1 = true;
            label160:
            if ((paramCard.lUserFlag & 0x400) != 1024L) {
              break label216;
            }
          }
          label216:
          for (bool2 = true;; bool2 = false)
          {
            if (!ProfileActivity.AllInOne.a(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
              break label222;
            }
            bool3 = bool1;
            bool1 = true;
            bool5 = bool2;
            bool2 = bool3;
            bool3 = bool6;
            break;
            bool1 = false;
            break label160;
          }
          label222:
          if ((bool6) || (bool4) || (paramCard.iQQLevel >= 0))
          {
            bool3 = bool1;
            bool1 = true;
            bool5 = bool2;
            bool2 = bool3;
            bool3 = bool6;
          }
        }
        else
        {
          return false;
        }
      }
      else
      {
        paramCard = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_account_level_info");
        if (paramCard == null)
        {
          paramCard = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495433, null);
          this.jdField_a_of_type_JavaUtilHashMap.put("map_key_account_level_info", paramCard);
          paramCard.setClickable(false);
          int n = ajve.b(ajve.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C6", "0X800A8C6", n, 0, String.valueOf(n), "", "", "");
          if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C7", "0X800A8C7", n, 0, String.valueOf(n), "", "", "");
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          ImageView localImageView = (ImageView)paramCard.findViewById(2131297252);
          ProfileQQLevelView localProfileQQLevelView = (ProfileQQLevelView)paramCard.findViewById(2131307340);
          localProfileQQLevelView.a(this.jdField_a_of_type_Atwx, this.jdField_a_of_type_Boolean);
          View localView = localProfileQQLevelView.findViewById(2131304169);
          if (bool7)
          {
            b(this.jdField_a_of_type_Atwx, localView);
            this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal", localView);
            localView.setBackgroundResource(2130844859);
            localView.setTag(new atuw(91, null));
            localView.setOnClickListener(this.jdField_a_of_type_Bbmg);
          }
          for (;;)
          {
            localProfileQQLevelView.setClickable(false);
            paramCard.setTag(new atuw(69, null));
            paramCard.setOnClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramCard = (FrameLayout)localProfileQQLevelView.findViewById(2131299332);
            if (paramCard != null)
            {
              paramCard.setOnClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
              paramCard.setTag(new atuw(100, null));
            }
            a("map_key_account_level_info", null, null, localImageView);
            return bool1;
            localView.setVisibility(8);
            localView.setBackgroundResource(0);
            localView.setTag(null);
            localView.setOnClickListener(null);
          }
        }
      }
      bool3 = bool1;
      bool1 = false;
      bool5 = bool2;
      bool2 = bool3;
      bool3 = bool6;
      continue;
      label653:
      bool1 = false;
      bool2 = false;
      bool3 = false;
      bool4 = false;
    }
  }
  
  private boolean b(Card paramCard, boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_Atwx.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null) || (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo.gameName)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "not show game info");
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_troop_mem_game_info") != null) {}
      for (paramBoolean = true;; paramBoolean = false) {
        return paramBoolean;
      }
    }
    paramCard = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_troop_mem_game_info");
    if (paramCard == null)
    {
      paramCard = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495411, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_troop_mem_game_info", paramCard);
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      Object localObject2 = (TextView)paramCard.findViewById(2131301313);
      TextView localTextView1 = (TextView)paramCard.findViewById(2131301315);
      localTextView1.setBackgroundDrawable(azlj.a(getResources(), Color.parseColor("#3094cf")));
      Object localObject1 = (ImageView)paramCard.findViewById(2131308949);
      TextView localTextView2 = (TextView)paramCard.findViewById(2131301316);
      TextView localTextView3 = (TextView)paramCard.findViewById(2131301317);
      ImageView localImageView = (ImageView)paramCard.findViewById(2131297252);
      TroopMemberCard.MemberGameInfo localMemberGameInfo = this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo;
      if (localMemberGameInfo != null)
      {
        ((TextView)localObject2).setText(localMemberGameInfo.gameName);
        if ((localMemberGameInfo.descInfo != null) && (localMemberGameInfo.descInfo.size() > 0) && (!TextUtils.isEmpty((CharSequence)localMemberGameInfo.descInfo.get(0))))
        {
          localTextView2.setVisibility(0);
          localTextView2.setText((CharSequence)localMemberGameInfo.descInfo.get(0));
        }
        if ((localMemberGameInfo.descInfo != null) && (localMemberGameInfo.descInfo.size() > 1) && (!TextUtils.isEmpty((CharSequence)localMemberGameInfo.descInfo.get(1))))
        {
          localTextView3.setVisibility(0);
          localTextView3.setText((CharSequence)localMemberGameInfo.descInfo.get(1));
        }
      }
      for (;;)
      {
        try
        {
          int n = aciy.a(18.0F, getResources());
          int i1 = aciy.a(18.0F, getResources());
          if (!TextUtils.isEmpty(localMemberGameInfo.levelIcon))
          {
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = n;
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = i1;
            ((ImageView)localObject1).setImageDrawable(URLDrawable.getDrawable(localMemberGameInfo.levelIcon, (URLDrawable.URLDrawableOptions)localObject2));
          }
          if (!TextUtils.isEmpty(localMemberGameInfo.levelName))
          {
            localTextView1.setVisibility(0);
            localTextView1.setText(localMemberGameInfo.levelName);
            float f1 = aciy.a(2.0F, getResources());
            n = aciy.a(4.0F, getResources());
            localObject1 = new GradientDrawable();
            ((GradientDrawable)localObject1).setCornerRadius(f1);
            localTextView1.setPadding(n, 0, n, 0);
            if (TextUtils.isEmpty(localMemberGameInfo.gameBackGroundColor)) {
              continue;
            }
            ((GradientDrawable)localObject1).setColor(Color.parseColor(localMemberGameInfo.gameBackGroundColor));
            localTextView1.setBackgroundDrawable((Drawable)localObject1);
          }
          if (!TextUtils.isEmpty(localMemberGameInfo.gameFontColor)) {
            localTextView1.setTextColor(Color.parseColor(localMemberGameInfo.gameFontColor));
          }
          this.jdField_d_of_type_Boolean = true;
          azzx.a("Grp_game", "Mber_data", "game_exp", 0, 0, new String[] { this.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString, localMemberGameInfo.gameName });
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
          continue;
        }
        paramCard.setTag(new atuw(83, null));
        paramCard.setOnClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramCard.setVisibility(0);
        a("map_key_troop_mem_game_info", null, null, localImageView);
        return paramBoolean;
        ((GradientDrawable)localObject1).setColor(Color.parseColor("#FFBA26"));
      }
    }
  }
  
  private boolean c(Card paramCard)
  {
    int n = 1;
    QLog.i("ProfileCardMoreInfoView", 2, "makeOrRefreshWeiShiFeedList");
    if (this.jdField_a_of_type_Wzm == null) {
      return false;
    }
    if (!this.h) {
      return this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_mine_weishi") != null;
    }
    Object localObject;
    if ((View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_mine_weishi") == null)
    {
      localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493835, null);
      this.jdField_a_of_type_Wzm.a((View)localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_mine_weishi", localObject);
    }
    for (boolean bool = true;; bool = false)
    {
      if (!b())
      {
        localObject = this.jdField_a_of_type_Wzm.a();
        this.jdField_a_of_type_Wzm.a();
        if ((n == 0) || (paramCard == null)) {
          break label176;
        }
        atxe.a((View)localObject, "color", this.jdField_a_of_type_Atxe, "commonItemContentColor");
      }
      for (;;)
      {
        this.jdField_a_of_type_Wzm.b();
        a("map_key_mine_weishi", null, this.jdField_a_of_type_Wzm.a(), this.jdField_a_of_type_Wzm.a());
        return bool;
        n = 0;
        break;
        label176:
        ((TextView)localObject).setBackgroundResource(2130839146);
      }
    }
  }
  
  private boolean c(Card paramCard, boolean paramBoolean)
  {
    if ((paramCard != null) && (ProfileActivity.AllInOne.a(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      boolean bool;
      if ((!b()) && (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileQVipV5View)))
      {
        bool = paramBoolean;
        if (this.jdField_a_of_type_Atwx.jdField_b_of_type_Boolean)
        {
          bool = paramBoolean;
          if (atxe.a(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId)) {}
        }
      }
      else
      {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("makeOrRefreshAccountBaseInfoView bShowAccountInfo=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      if (!bool) {
        return this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_account_base_info") != null;
      }
      Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_account_base_info");
      if (localObject1 == null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495401, null);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_account_base_info", localObject1);
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        localObject1 = (ViewGroup)localObject1;
        ViewGroup localViewGroup1 = (ViewGroup)((ViewGroup)localObject1).findViewById(2131296297);
        localViewGroup1.removeAllViews();
        ViewGroup localViewGroup2 = (ViewGroup)((ViewGroup)localObject1).findViewById(2131296300);
        TextView localTextView;
        label342:
        Object localObject2;
        if ((ProfileActivity.AllInOne.j(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (ProfileActivity.AllInOne.k(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
        {
          localObject1 = null;
          localObject1 = a(localViewGroup1, 2130844841, (String)localObject1, 0);
          if (localObject1 != null)
          {
            localTextView = (TextView)((ViewGroup)localObject1).findViewById(2131302466);
            if (localTextView != null)
            {
              if (!this.jdField_a_of_type_Atwx.jdField_b_of_type_Boolean) {
                break label632;
              }
              localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString, paramCard.uin);
              if ((localObject1 == null) || (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick)) || (TextUtils.isEmpty(paramCard.strReMark))) {
                break label587;
              }
              localObject1 = paramCard.strNick;
              localObject2 = localObject1;
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                localObject2 = babh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramCard.uin, false);
              }
              if (!TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString)) {
                break label615;
              }
            }
          }
        }
        label441:
        label587:
        label615:
        for (localObject1 = localObject2;; localObject1 = a(localTextView, (String)localObject2, paramCard.uin))
        {
          localTextView.setText((CharSequence)localObject1);
          azyk.a(localTextView, paramCard.uin, (String)localObject2, this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          if (c())
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
            i1 = paramCard.shGender;
            if (!azyk.b()) {
              break label755;
            }
            n = 0;
            a(localViewGroup1, 2130844850, azyk.a((Context)localObject1, i1, n, paramCard.constellation, paramCard.strCountry, paramCard.strProvince, paramCard.strCity), 1);
          }
          if ((TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString)) || (c())) {
            break label908;
          }
          n = localViewGroup1.getChildCount();
          int i1 = 0;
          while ((n < 4) && (i1 < 3)) {
            switch (i1)
            {
            default: 
              n = 0;
              localObject1 = null;
              a(localViewGroup1, n, (String)localObject1, 1);
              n = localViewGroup1.getChildCount();
              i1 += 1;
            }
          }
          localObject1 = " ";
          break;
          if (TextUtils.isEmpty(paramCard.strReMark))
          {
            localObject1 = paramCard.strNick;
            break label342;
          }
          localObject1 = paramCard.strReMark;
          break label342;
        }
        label548:
        label553:
        label632:
        if ((this.jdField_a_of_type_Atwx.jdField_a_of_type_ArrayOfJavaLangString != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Atwx.jdField_a_of_type_ArrayOfJavaLangString[5])) && (!TextUtils.equals(this.jdField_a_of_type_Atwx.jdField_a_of_type_ArrayOfJavaLangString[5], paramCard.strNick))) {}
        for (int n = 1;; n = 0)
        {
          if ((!TextUtils.isEmpty(paramCard.strReMark)) || (n != 0))
          {
            String str2 = a(localTextView, paramCard.strNick, paramCard.uin);
            String str1 = paramCard.strNick;
            localObject2 = str1;
            localObject1 = str2;
            if (!TextUtils.isEmpty(str2)) {
              break;
            }
            localObject1 = paramCard.uin;
            localObject2 = str1;
            break;
          }
          localObject1 = paramCard.uin;
          localObject2 = null;
          break;
          label755:
          n = paramCard.age;
          break label441;
          localObject1 = new StringBuilder();
          if (!TextUtils.isEmpty(paramCard.strCompany)) {
            ((StringBuilder)localObject1).append(paramCard.strCompany);
          }
          localObject2 = azyf.e(paramCard.iProfession);
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.equals((CharSequence)localObject2, azyf.d[14])))
          {
            if (((StringBuilder)localObject1).length() > 0) {
              ((StringBuilder)localObject1).append(" ");
            }
            ((StringBuilder)localObject1).append((String)localObject2);
          }
          localObject1 = ((StringBuilder)localObject1).toString();
          n = 2130844854;
          break label553;
          if (TextUtils.isEmpty(paramCard.strSchool)) {
            break label548;
          }
          localObject1 = paramCard.strSchool;
          n = 2130844858;
          break label553;
          if (TextUtils.isEmpty(paramCard.strHometownDesc)) {
            break label548;
          }
          localObject1 = paramCard.strHometownDesc;
          n = 2130844849;
          break label553;
          label908:
          localViewGroup2.setTag(new atuw(66, paramCard.uin));
          localViewGroup2.setOnClickListener(this.jdField_a_of_type_Bbmg);
          a("map_key_account_base_info", (TextView)localViewGroup2.findViewById(2131296301), (ImageView)localViewGroup2.findViewById(2131297252), null);
          return paramBoolean;
        }
      }
    }
  }
  
  private boolean d()
  {
    if (!this.jdField_a_of_type_Atwx.jdField_b_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_troop_mem_recent_said") != null;
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_troop_mem_recent_said");
    Object localObject;
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131496944, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_troop_mem_recent_said", localView);
      localObject = (ImageView)localView.findViewById(2131302061);
      ((ImageView)localObject).setImageResource(2130844861);
      ((ImageView)localObject).clearColorFilter();
      ((ImageView)localObject).setColorFilter(10067634);
    }
    for (boolean bool = true;; bool = false)
    {
      localObject = (TextView)localView.findViewById(2131302720);
      ImageView localImageView = (ImageView)localView.findViewById(2131297252);
      localView.setTag(new atuw(78, null));
      localView.setOnClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
      a("map_key_troop_mem_recent_said", null, (View)localObject, localImageView);
      if (!this.g)
      {
        this.g = ((TroopPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(119)).a("troop_member_card_plugin.apk", new bbls(this));
        if (!this.g) {
          localView.setVisibility(8);
        }
      }
      for (;;)
      {
        a();
        return bool;
        b(localView, this.jdField_a_of_type_Atwx);
      }
    }
  }
  
  private boolean d(Card paramCard)
  {
    boolean bool1;
    boolean bool2;
    if ((!ProfileActivity.AllInOne.g(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramCard == null) || (this.jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_qzone") != null) {}
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        return bool2;
      }
    }
    ThreadManager.post(new ProfileCardMoreInfoView.2(this), 8, null, true);
    View localView1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzone");
    label114:
    ViewGroup localViewGroup;
    Object localObject3;
    Object localObject4;
    ImageView localImageView1;
    label194:
    List localList;
    Object localObject1;
    int i3;
    int n;
    int i1;
    int i4;
    int i5;
    label652:
    int i2;
    label655:
    String str;
    View localView3;
    ImageView localImageView2;
    View localView4;
    View localView2;
    View localView5;
    TextView localTextView;
    if (localView1 == null)
    {
      localView1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495424, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzone", localView1);
      bool1 = true;
      localViewGroup = (ViewGroup)localView1.findViewById(2131302507);
      localObject3 = (ViewGroup)localView1.findViewById(2131302508);
      localObject4 = (TextView)localView1.findViewById(2131311372);
      localImageView1 = (ImageView)localView1.findViewById(2131302196);
      ((TextView)localObject4).setSingleLine(true);
      ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      if ((paramCard.ulShowControl & 0x80) != 0)
      {
        bool2 = true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("makeOrRefreshQZone card.ulShowControl=%x hasLocked=%s", new Object[] { Integer.valueOf(paramCard.ulShowControl), Boolean.valueOf(bool2) }));
        }
        if ((bool2) || ((!paramCard.isShowPhoto()) && (!paramCard.hasFakeData)) || (!paramCard.hasGotPhotoUrl())) {
          break label1833;
        }
        localList = paramCard.getQZonePhotoList();
        if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
        {
          if ((localList == null) || (localList.size() < this.jdField_e_of_type_Int)) {
            break label958;
          }
          this.jdField_e_of_type_Int = localList.size();
        }
        localViewGroup.removeAllViews();
        localViewGroup.setVisibility(0);
        if ((localObject3 != null) && (((ViewGroup)localObject3).getVisibility() != 8))
        {
          ((ViewGroup)localObject3).removeAllViews();
          ((ViewGroup)localObject3).setVisibility(8);
        }
        ((TextView)localObject4).setVisibility(8);
        if ((localList == null) || (localList.isEmpty())) {
          break label1469;
        }
        localObject1 = getResources();
        i3 = ((Resources)localObject1).getDimensionPixelSize(2131167062);
        n = ((Resources)localObject1).getDimensionPixelSize(2131166291);
        i1 = bajq.b(30.0F);
        i4 = (int)(this.jdField_b_of_type_Float - n - i1);
        n = a(paramCard);
        i5 = (int)((i4 - (n - 1) * i3) * 1.0F) / n;
        if (QLog.isColorLevel()) {
          QLog.e("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "makeOrRefreshQZone count:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(localList.size()), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i4) }));
        }
        if ((this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) || ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) & 0x4000) == 0)) {
          break label2152;
        }
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495427, null);
        if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          ((View)localObject1).setBackgroundColor(Color.parseColor("#77F5F6FA"));
        }
        localViewGroup.addView((View)localObject1);
        localObject3 = ((View)localObject1).getLayoutParams();
        if ((localObject3 instanceof LinearLayout.LayoutParams))
        {
          localObject3 = (LinearLayout.LayoutParams)localObject3;
          ((LinearLayout.LayoutParams)localObject3).width = i5;
          ((LinearLayout.LayoutParams)localObject3).height = i5;
          ((LinearLayout.LayoutParams)localObject3).rightMargin = i3;
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        }
        n = 0 + i5;
        ((View)localObject1).setOnClickListener(new bblq(this));
        LpReportInfo_pf00064.allReport(699, 7);
        i2 = 0;
        if (i2 >= localList.size()) {
          break label1469;
        }
        PhotoInfo localPhotoInfo = (PhotoInfo)localList.get(i2);
        str = localPhotoInfo.strPicUrl;
        localView3 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495425, null);
        localImageView2 = (ImageView)localView3.findViewById(2131302510);
        localView4 = localView3.findViewById(2131302515);
        localView2 = localView3.findViewById(2131302509);
        localView5 = localView3.findViewById(2131302514);
        localTextView = (TextView)localView3.findViewById(2131302506);
        UnderlineTextView localUnderlineTextView = (UnderlineTextView)localView3.findViewById(2131302505);
        localUnderlineTextView.setEditableFactory(axkn.a);
        localObject3 = "";
        if (localPhotoInfo.mapEx == null) {
          break label2141;
        }
        localObject1 = (String)localPhotoInfo.mapEx.get("info_type");
        localObject3 = (String)localPhotoInfo.mapEx.get("feeds_content");
        bool2 = "1".equals(localPhotoInfo.mapEx.get("isVideo"));
        label848:
        if ((!TextUtils.equals((CharSequence)localObject1, "1")) || (TextUtils.isEmpty((CharSequence)localObject3))) {
          break label994;
        }
        localUnderlineTextView.setText((CharSequence)localObject3);
        localUnderlineTextView.setVisibility(0);
        localImageView2.setVisibility(8);
        localObject1 = localUnderlineTextView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = i5;
        ((ViewGroup.LayoutParams)localObject1).height = i5;
        i1 = localUnderlineTextView.getLineHeight();
        if (i1 <= 0) {
          break label965;
        }
        localUnderlineTextView.setMaxLines(b(paramCard));
        label928:
        i1 = 1;
      }
    }
    for (;;)
    {
      if (i1 == 0)
      {
        QLog.w("ProfileCardMoreInfoView", 1, "makeOrRefreshQZone: needUpdateUI=false,skip this one");
        label943:
        i2 += 1;
        break label655;
        bool2 = false;
        break label194;
        label958:
        paramCard.hasFakeData = false;
        return true;
        label965:
        QLog.w("ProfileCardMoreInfoView", 1, "makeOrRefreshQZone: invalid lineHeight:" + i1);
        break label928;
        label994:
        if (TextUtils.isEmpty(str)) {
          break label2136;
        }
        if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          localImageView2.setColorFilter(1996488704);
        }
        if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(getResources().getColor(2131100052));
        }
        for (;;)
        {
          try
          {
            localObject1 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i5;
            ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i5;
            if ((str.startsWith("http://")) || (str.startsWith("https://")))
            {
              localImageView2.setImageDrawable(URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions)localObject1));
              if ((!str.contains("video=1")) && (!bool2)) {
                break label1255;
              }
              localView4.setVisibility(0);
              if (((PhotoInfo)localList.get(i2)).IsOnlySelf != 1) {
                break label1265;
              }
              localView5.setVisibility(0);
              break label2163;
            }
            if (!bool2) {
              break label1240;
            }
            localObject1 = ShortVideoUtils.a(this.jdField_a_of_type_AndroidContentContext, str, i5, 0L);
            if (localObject1 != null)
            {
              localImageView2.setImageBitmap((Bitmap)localObject1);
              continue;
            }
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.profilecard.FrdProfileCard", 2, "makeOrRefreshQZone fail!", localException);
            }
            i1 = 1;
          }
          localImageView2.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
          continue;
          label1240:
          localImageView2.setImageDrawable(URLDrawable.getFileDrawable(str, localException));
          continue;
          label1255:
          localView4.setVisibility(8);
        }
        label1265:
        localView5.setVisibility(8);
        break label2163;
      }
      localViewGroup.addView(localView3);
      Object localObject2 = localView3.getLayoutParams();
      if ((localObject2 instanceof LinearLayout.LayoutParams))
      {
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        ((LinearLayout.LayoutParams)localObject2).rightMargin = i3;
        localView3.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      localObject2 = localImageView2.getLayoutParams();
      if (c())
      {
        ((ViewGroup.LayoutParams)localObject2).width = -1;
        ((ViewGroup.LayoutParams)localObject2).height = -1;
        label1344:
        localImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = localView2.getLayoutParams();
        if (!c()) {
          break label1799;
        }
        ((ViewGroup.LayoutParams)localObject2).width = -1;
        ((ViewGroup.LayoutParams)localObject2).height = -1;
        label1377:
        localView2.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        i1 = n;
        if (n > 0) {
          i1 = n + i3;
        }
        n = i1 + i5;
        if (n + i5 + i3 <= i4) {
          break label1816;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "makeOrRefreshQZone cur:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(n), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i4) }));
        }
        label1469:
        if (!TextUtils.isEmpty(paramCard.strQzoneHeader))
        {
          ((TextView)localObject4).setVisibility(0);
          ((TextView)localObject4).setText(paramCard.strQzoneHeader);
        }
        if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          ((TextView)localObject4).setText(ajjy.a(2131642654));
        }
        label1518:
        if (((TextView)localObject4).getText() != null) {
          break label2111;
        }
        localObject2 = "";
        label1531:
        if ((!((String)localObject2).contains(ajjy.a(2131642689))) || (!((String)localObject2).endsWith(ajjy.a(2131642650)))) {
          break label2124;
        }
        ((TextView)localObject4).setCompoundDrawablePadding((int)(3.0F * this.jdField_a_of_type_Float));
        ((TextView)localObject4).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130841636, 0);
      }
      for (;;)
      {
        localView1.setTag(new atuw(5, null));
        localView1.setOnClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView1.setContentDescription(a(2131625628));
        a("map_key_qzone", null, (View)localObject4, localImageView1);
        localObject4 = (ViewGroup.MarginLayoutParams)localView1.getLayoutParams();
        localObject3 = localObject4;
        if (localObject4 == null) {
          localObject3 = new LinearLayout.LayoutParams(-1, -2);
        }
        ((ViewGroup.MarginLayoutParams)localObject3).bottomMargin = getResources().getDimensionPixelSize(2131166286);
        if (localViewGroup.getVisibility() == 8) {
          ((ViewGroup.MarginLayoutParams)localObject3).bottomMargin = 0;
        }
        localView1.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ProfileCardMoreInfoView", 2, String.format("makeOrRefreshQZone, [h:%s, des: %s, space: %s, remark: %s, nick: %s, info: %s]", new Object[] { paramCard.strQzoneHeader, paramCard.strQzoneFeedsDesc, paramCard.strSpaceName, this.jdField_a_of_type_Atwx.jdField_a_of_type_ArrayOfJavaLangString[4], this.jdField_a_of_type_Atwx.jdField_a_of_type_ArrayOfJavaLangString[0], localObject2 }));
        return bool1;
        ((ViewGroup.LayoutParams)localObject2).width = i5;
        ((ViewGroup.LayoutParams)localObject2).height = i5;
        break label1344;
        label1799:
        ((ViewGroup.LayoutParams)localObject2).width = i5;
        ((ViewGroup.LayoutParams)localObject2).height = i5;
        break label1377;
        label1816:
        localView2.setVisibility(8);
        localTextView.setVisibility(8);
        break label943;
        label1833:
        if ((!bool2) && (paramCard.isShowFeeds()) && (!TextUtils.isEmpty(paramCard.strQzoneFeedsDesc)))
        {
          localViewGroup.setVisibility(8);
          ((TextView)localObject4).setVisibility(0);
          ((TextView)localObject4).setText(auoc.a(paramCard.strQzoneFeedsDesc, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
          break label1518;
        }
        if (!TextUtils.isEmpty(paramCard.strSpaceName))
        {
          localViewGroup.setVisibility(8);
          ((TextView)localObject4).setVisibility(0);
          ((TextView)localObject4).setText(paramCard.strSpaceName);
          break label1518;
        }
        localViewGroup.setVisibility(8);
        ((TextView)localObject4).setVisibility(0);
        localObject2 = a(this.jdField_a_of_type_Atwx);
        if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          localObject2 = ajjy.a(2131642693);
        }
        ((TextView)localObject4).setText(String.format("%s%s", new Object[] { localObject2, a(2131627902) }));
        if ((this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) || (!paramCard.showPublishButton) || (localObject3 == null) || ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) & 0x4000) == 0)) {
          break label1518;
        }
        ((ViewGroup)localObject3).removeAllViews();
        ((ViewGroup)localObject3).setVisibility(0);
        if (QLog.isColorLevel()) {
          QLog.i("ProfileCardMoreInfoView", 2, "no photo, show writeMoodContainer view.");
        }
        localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495428, null);
        ((ViewGroup)localObject3).addView((View)localObject2);
        ((View)localObject2).setOnClickListener(new bblr(this));
        LpReportInfo_pf00064.allReport(699, 7);
        break label1518;
        label2111:
        localObject2 = (String)((TextView)localObject4).getText();
        break label1531;
        label2124:
        ((TextView)localObject4).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
      label2136:
      i1 = 0;
      continue;
      label2141:
      bool2 = false;
      localObject2 = "";
      break label848;
      label2152:
      n = 0;
      break label652;
      bool1 = false;
      break label114;
      label2163:
      i1 = 1;
    }
  }
  
  private boolean d(Card paramCard, boolean paramBoolean)
  {
    paramBoolean = false;
    boolean bool;
    if ((paramCard == null) || (ProfileActivity.AllInOne.i(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
      if (this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_favor") != null)
      {
        paramBoolean = true;
        bool = paramBoolean;
      }
    }
    LinearLayout localLinearLayout1;
    do
    {
      return bool;
      paramBoolean = false;
      break;
      LinearLayout localLinearLayout2 = (LinearLayout)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_favor");
      localLinearLayout1 = localLinearLayout2;
      if (localLinearLayout2 == null)
      {
        localLinearLayout1 = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131495384, null, false);
        localLinearLayout1.setTag(2131301207, Boolean.TRUE);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_favor", localLinearLayout1);
        paramBoolean = true;
      }
      bool = paramBoolean;
    } while (!(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity));
    a(localLinearLayout1, paramCard);
    if (this.jdField_a_of_type_Int > 0) {
      return true;
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_favor");
    return paramBoolean;
  }
  
  private boolean e(Card paramCard)
  {
    boolean bool1 = false;
    if ((paramCard == null) || (paramCard.lCurrentStyleId != atxe.f)) {
      return this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_tag") != null;
    }
    if (this.jdField_a_of_type_Atwx.jdField_b_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_tag") != null;
    }
    Object localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tag");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495434, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tag", localObject1);
      bool1 = true;
    }
    localObject2 = (AdaptiveLayout)((View)localObject1).findViewById(2131311052);
    int i1 = getResources().getDimensionPixelSize(2131167264);
    int n = 7;
    if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      n = 8;
    }
    int i2;
    if (this.jdField_a_of_type_ArrayOfAndroidWidgetTextView == null)
    {
      ((AdaptiveLayout)localObject2).setGap(i1, i1);
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[n];
      i2 = getResources().getDimensionPixelSize(2131167262);
      int i3 = getResources().getDimensionPixelSize(2131167265);
      int i4 = getResources().getDimensionPixelSize(2131167268);
      i1 = 0;
      if (i1 < n)
      {
        localObject1 = new TextView(getContext());
        this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i1] = localObject1;
        ((TextView)localObject1).setBackgroundResource(2130845949);
        ((TextView)localObject1).setPadding(i3, i3, i3, i3);
        ((TextView)localObject1).setTextSize(0, i2);
        ((TextView)localObject1).setTextColor(-16777216);
        ((TextView)localObject1).setGravity(17);
        if (7 == i1)
        {
          i2 = getResources().getDimensionPixelSize(2131167269);
          ((TextView)localObject1).setTextSize(0, i2);
          ((TextView)localObject1).setTag(new atuw(47, null));
          ((TextView)localObject1).setText("+");
          ((TextView)localObject1).setOnClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((TextView)localObject1).setPadding(i4, 0, i4, 0);
        }
        for (;;)
        {
          ((AdaptiveLayout)localObject2).addView((View)localObject1);
          i1 += 1;
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
        label424:
        label471:
        Object localObject3;
        if (((List)localObject1).size() > 7)
        {
          i1 = 7;
          i2 = 0;
          if (i2 >= n) {
            break label598;
          }
          localObject2 = this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i2];
          if (i2 >= i1) {
            break label555;
          }
          ((TextView)localObject2).setText(((ProfileLabelInfo)((List)localObject1).get(i2)).labelName);
          ((TextView)localObject2).setVisibility(0);
          if (((TextView)localObject2).getVisibility() == 0)
          {
            localObject3 = ((TextView)localObject2).getBackground();
            if ((localObject3 instanceof GradientDrawable))
            {
              localObject3 = (GradientDrawable)localObject3;
              if (paramCard.backgroundColor != 1L) {
                break label572;
              }
              ((GradientDrawable)localObject3).setColor(-2130706433);
              ((GradientDrawable)localObject3).setStroke(1, 855638016);
              ((TextView)localObject2).setTextColor(-16777216);
            }
          }
        }
        for (;;)
        {
          i2 += 1;
          break label424;
          i1 = ((List)localObject1).size();
          break;
          label555:
          if (i2 >= 7) {
            break label471;
          }
          ((TextView)localObject2).setVisibility(8);
          break label471;
          label572:
          ((GradientDrawable)localObject3).setColor(-2147483648);
          ((GradientDrawable)localObject3).setStroke(1, 872415231);
          ((TextView)localObject2).setTextColor(-1);
        }
        label598:
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private boolean e(Card paramCard, boolean paramBoolean)
  {
    paramBoolean = true;
    boolean bool1 = true;
    Object localObject1;
    if ((paramCard == null) || (!paramCard.isShowCard) || (paramCard.extendFriendFlag != 1))
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_extend_friend_info") != null)
      {
        paramBoolean = true;
        if (QLog.isDevelopLevel())
        {
          if (paramCard != null) {
            break label93;
          }
          localObject1 = "null";
          label53:
          if (paramCard != null) {
            break label105;
          }
        }
      }
      label93:
      label105:
      for (paramCard = "null";; paramCard = Integer.valueOf(paramCard.extendFriendFlag))
      {
        QLog.i("ProfileCardMoreInfoView", 4, String.format("extend friend [%s, %s]", new Object[] { localObject1, paramCard }));
        return paramBoolean;
        paramBoolean = false;
        break;
        localObject1 = Boolean.valueOf(paramCard.isShowCard);
        break label53;
      }
    }
    boolean bool2 = TextUtils.equals(paramCard.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    int i1;
    if (bool2)
    {
      if (paramCard.extendFriendEntryAddFriend == 0)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_extend_friend_info") != null) {}
        for (;;)
        {
          paramBoolean = bool1;
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.i("ProfileCardMoreInfoView", 4, "extend friend self add friend flag is zero");
          return bool1;
          bool1 = false;
        }
      }
    }
    else
    {
      localObject1 = baig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785");
      i1 = ((SharedPreferences)localObject1).getInt("sp_extend_friend_entry_add_friend", 0);
      if (!((SharedPreferences)localObject1).contains("sp_extend_friend_entry_add_friend")) {
        break label1078;
      }
    }
    label770:
    label937:
    label1073:
    label1078:
    for (int n = ((SharedPreferences)localObject1).getInt("sp_extend_friend_entry_add_friend", 0);; n = 1)
    {
      if ((i1 == 0) || (n != 1) || (TextUtils.isEmpty(paramCard.declaration)))
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_extend_friend_info") != null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("ProfileCardMoreInfoView", 4, String.format("extend friend guest [%s, %s, %s]", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), paramCard.declaration }));
          }
          return paramBoolean;
        }
      }
      if (!((anoe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).b())
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_extend_friend_info") != null) {}
        for (bool1 = paramBoolean;; bool1 = false)
        {
          paramBoolean = bool1;
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.i("ProfileCardMoreInfoView", 4, "extend friend resource is not ready");
          return bool1;
        }
      }
      bool1 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_Atwx.jdField_a_of_type_Atxe != null)
      {
        n = 1;
        localObject1 = (ProfileCardFavorShowView)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_extend_friend_info");
        if (localObject1 != null) {
          break label1073;
        }
        localObject1 = new ProfileCardFavorShowView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        ((ProfileCardFavorShowView)localObject1).setTitle(a(2131625579));
        ((ProfileCardFavorShowView)localObject1).setVisibility(8);
        ((ProfileCardFavorShowView)localObject1).setOnClickListener(null);
        if (this.f) {
          ((ProfileCardFavorShowView)localObject1).setShowArrow(false);
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_extend_friend_info", localObject1);
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        Object localObject2 = ((ProfileCardFavorShowView)localObject1).jdField_a_of_type_AndroidViewViewGroup;
        ((View)localObject2).setTag(new atuw(87, null));
        ((View)localObject2).setOnClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((View)localObject2).setContentDescription(a(2131625579));
        Object localObject3;
        Object localObject4;
        Object localObject5;
        if (bool2) {
          if (TextUtils.isEmpty(paramCard.declaration))
          {
            localObject2 = ((ProfileCardFavorShowView)localObject1).getChildAt(0);
            if ((localObject2 == null) || (!Boolean.TRUE.equals(((View)localObject2).getTag(0))) || (!new Boolean(bool1).equals(((View)localObject2).getTag(1))) || (!this.jdField_a_of_type_Atwx.jdField_a_of_type_Atxe.equals(((View)localObject2).getTag(2))))
            {
              ((ProfileCardFavorShowView)localObject1).removeAllViews();
              if ((!bool1) && (n == 0)) {
                break label937;
              }
              localObject2 = LayoutInflater.from(getContext()).inflate(2131495410, null);
              ((View)localObject2).setTag(2131306275, Boolean.valueOf(true));
              ((View)localObject2).setTag(2131306276, Boolean.valueOf(bool1));
              ((View)localObject2).setTag(2131306274, this.jdField_a_of_type_Atwx.jdField_a_of_type_Atxe);
              localObject3 = (TextView)((View)localObject2).findViewById(2131312190);
              localObject4 = (TextView)((View)localObject2).findViewById(2131312191);
              if (n != 0)
              {
                localObject5 = this.jdField_a_of_type_Atxe.a.get("commonItemContentColor");
                if (localObject5 != null)
                {
                  if (!(localObject5 instanceof ColorStateList)) {
                    break label888;
                  }
                  ((TextView)localObject3).setTextColor((ColorStateList)localObject5);
                  ((TextView)localObject4).setTextColor((ColorStateList)localObject5);
                }
              }
              ((View)localObject2).setClickable(true);
              localObject3 = ((View)localObject2).findViewById(2131312189);
              ((View)localObject3).setOnClickListener(new bblu(this, paramCard));
              ((ProfileCardFavorShowView)localObject1).addView((View)localObject2);
              if (bool1) {
                a("map_key_extend_friend_info", null, (View)localObject3, null);
              }
            }
          }
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) {
            a("map_key_extend_friend_info", null, ((ProfileCardFavorShowView)localObject1).jdField_a_of_type_AndroidWidgetTextView, null);
          }
          if (((ProfileCardFavorShowView)localObject1).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable)) {
            QLog.i("remilelei", 2, "cancel job to scroll FriendProfileCardActivity");
          }
          ((ProfileCardFavorShowView)localObject1).postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
          return paramBoolean;
          n = 0;
          break;
          label888:
          if (!(localObject5 instanceof String)) {
            break label770;
          }
          localObject5 = (String)localObject5;
          if (!((String)localObject5).startsWith("#")) {
            break label770;
          }
          ((TextView)localObject3).setTextColor(Color.parseColor((String)localObject5));
          ((TextView)localObject4).setTextColor(Color.parseColor((String)localObject5));
          break label770;
          localObject3 = LayoutInflater.from(getContext()).inflate(2131495409, null);
          localObject4 = ((View)localObject3).findViewById(2131309651);
          localObject5 = antz.a("expand_summary_default_bg.png");
          localObject2 = localObject3;
          if (!apdh.a((String)localObject5)) {
            break label770;
          }
          localObject2 = antz.a((String)localObject5, null);
          float f1 = ((Bitmap)localObject2).getWidth() / ((Bitmap)localObject2).getHeight();
          ((View)localObject4).setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(getResources().getDisplayMetrics().widthPixels / f1)));
          ((View)localObject4).setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject2));
          localObject2 = localObject3;
          break label770;
          a(paramCard, (ProfileCardFavorShowView)localObject1);
          continue;
          a(paramCard, (ProfileCardFavorShowView)localObject1);
        }
      }
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().putExtra("writeMoodFromProfileCard", true);
    bfpr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1037);
    LpReportInfo_pf00064.allReport(699, 8);
    LpReportInfo_pf00064.allReport(586, 1, 6);
  }
  
  private boolean f(Card paramCard)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    if (paramCard == null) {
      bool2 = bool1;
    }
    boolean bool6;
    int n;
    label74:
    Object localObject2;
    do
    {
      do
      {
        return bool2;
        bool6 = paramCard.uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_mini_playing");
        ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (this.jdField_a_of_type_Atwx.jdField_a_of_type_Atxe == null) {
          break;
        }
        n = 1;
        if (!paramCard.isShowMiniPlaying) {
          break label752;
        }
        if (localObject1 != null) {
          break label417;
        }
        localObject2 = new ProfileCardFavorShowView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        if (!bool6) {
          break label285;
        }
        bool2 = bool1;
      } while (paramCard.miniAppInfoArrayList == null);
      bool2 = bool1;
    } while (paramCard.miniAppInfoArrayList.size() <= 0);
    ((ProfileCardFavorShowView)localObject2).setTitle(QzoneConfig.getInstance().getConfig("QZoneSetting", "ProfileCardMiniPlayingName", "最近在玩"));
    bool1 = bool3;
    if (paramCard.miniAppInfoArrayList.size() > 1) {
      bool1 = true;
    }
    ((ProfileCardFavorShowView)localObject2).setShowArrow(bool1);
    Object localObject1 = new MiniAppProfileCardView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    ((MiniAppProfileCardView)localObject1).setData(paramCard.miniAppInfoArrayList);
    ((ProfileCardFavorShowView)localObject2).setVisibility(8);
    ((ProfileCardFavorShowView)localObject2).addView((View)localObject1);
    if (n != 0) {
      a((MiniAppProfileCardView)localObject1);
    }
    label221:
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_mini_playing", localObject2);
    bool1 = true;
    label235:
    MiniAppUtils.reportProfileCardExposed(paramCard, bool6);
    paramCard = (Card)localObject2;
    for (;;)
    {
      bool2 = bool1;
      if (paramCard == null) {
        break;
      }
      a("map_key_mini_playing", null, (TextView)paramCard.findViewById(2131311372), (ImageView)paramCard.findViewById(2131302196));
      return bool1;
      n = 0;
      break label74;
      label285:
      bool2 = bool1;
      if (paramCard.appPlayingInfos == null) {
        break;
      }
      bool2 = bool1;
      if (paramCard.appPlayingInfos.size() <= 0) {
        break;
      }
      ((ProfileCardFavorShowView)localObject2).setTitle(QzoneConfig.getInstance().getConfig("QZoneSetting", "ProfileCardMiniPlayingNameGuestDefault", "一起在玩"));
      bool1 = bool4;
      if (paramCard.appPlayingInfos.size() > 1) {
        bool1 = true;
      }
      ((ProfileCardFavorShowView)localObject2).setShowArrow(bool1);
      localObject1 = new MiniAppProfileCardGuestView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((MiniAppProfileCardGuestView)localObject1).setData(paramCard.appPlayingInfos, paramCard.guestJumpUrl, paramCard.uin);
      ((ProfileCardFavorShowView)localObject2).setVisibility(8);
      ((ProfileCardFavorShowView)localObject2).addView((View)localObject1);
      if (n == 0) {
        break label221;
      }
      a((MiniAppProfileCardGuestView)localObject1);
      break label221;
      label417:
      if (bool6)
      {
        localObject2 = localObject1;
        bool1 = bool2;
        if (!(localObject1 instanceof ProfileCardFavorShowView)) {
          break label235;
        }
        localProfileCardFavorShowView = (ProfileCardFavorShowView)localObject1;
        if (paramCard.miniAppInfoArrayList.size() > 1) {}
        for (bool1 = true;; bool1 = false)
        {
          localProfileCardFavorShowView.setShowArrow(bool1);
          localObject2 = (MiniAppProfileCardView)localProfileCardFavorShowView.a(0);
          ((MiniAppProfileCardView)localObject2).setData(paramCard.miniAppInfoArrayList);
          if (n != 0) {
            a((MiniAppProfileCardView)localObject2);
          }
          localObject2 = localObject1;
          bool1 = bool2;
          if (paramCard.miniAppInfoArrayList.size() <= 1) {
            break;
          }
          localObject2 = localProfileCardFavorShowView.jdField_a_of_type_AndroidViewViewGroup;
          ((View)localObject2).setTag(new atuw(96, Boolean.valueOf(true)));
          ((View)localObject2).setOnClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
          localObject2 = localObject1;
          bool1 = bool2;
          break;
        }
      }
      localObject2 = localObject1;
      bool1 = bool2;
      if (!(localObject1 instanceof ProfileCardFavorShowView)) {
        break label235;
      }
      ProfileCardFavorShowView localProfileCardFavorShowView = (ProfileCardFavorShowView)localObject1;
      localProfileCardFavorShowView.setTitle(paramCard.guestAppTotal + QzoneConfig.getInstance().getConfig("QZoneSetting", "ProfileCardMiniPlayingNameGuest", "个一起在玩的小游戏"));
      if (paramCard.guestAppTotal > 1) {}
      for (bool1 = true;; bool1 = false)
      {
        localProfileCardFavorShowView.setShowArrow(bool1);
        localObject2 = (MiniAppProfileCardGuestView)localProfileCardFavorShowView.a(0);
        ((MiniAppProfileCardGuestView)localObject2).setData(paramCard.appPlayingInfos, paramCard.guestJumpUrl, paramCard.uin);
        if (n != 0) {
          a((MiniAppProfileCardGuestView)localObject2);
        }
        localObject2 = localObject1;
        bool1 = bool2;
        if (paramCard.guestAppTotal <= 1) {
          break;
        }
        localObject2 = localProfileCardFavorShowView.jdField_a_of_type_AndroidViewViewGroup;
        ((View)localObject2).setTag(new atuw(96, Boolean.valueOf(false)));
        ((View)localObject2).setOnClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
        localObject2 = localObject1;
        bool1 = bool2;
        break;
      }
      label752:
      if (localObject1 != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_mini_playing");
        paramCard = (Card)localObject1;
        bool1 = true;
      }
      else
      {
        paramCard = (Card)localObject1;
        bool1 = bool5;
      }
    }
  }
  
  private boolean f(Card paramCard, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) || ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileQVipV5View)) || (c()))) {}
    for (int n = 1; (n == 0) || (ProfileActivity.AllInOne.i(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (azzz.b(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || ((this.jdField_a_of_type_Bbma != null) && (!this.jdField_a_of_type_Bbma.a(2))); n = 0)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_photo_wall");
      return false;
    }
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_photo_wall");
    paramCard = (Card)localObject;
    if (localObject == null)
    {
      localObject = new PhotoWallView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this);
      paramCard = new ProfileCardFavorShowView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      paramCard.setTitle(ajjy.a(2131642677));
      paramCard.setVisibility(8);
      paramCard.addView((View)localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_photo_wall", paramCard);
    }
    if ((paramCard instanceof ProfileCardFavorShowView))
    {
      localObject = (ProfileCardFavorShowView)paramCard;
      paramCard = (PhotoWallView)((ProfileCardFavorShowView)localObject).a(0);
      a("map_key_photo_wall", null, paramCard.b, null);
      a("map_key_photo_wall", null, paramCard.c, null);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) {
        ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a(paramCard);
      }
      localObject = ((ProfileCardFavorShowView)localObject).jdField_a_of_type_AndroidViewViewGroup;
      ((View)localObject).setTag(new atuw(85, paramCard));
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject).setContentDescription(a(2131625606));
    }
    return true;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "update more info");
    }
    removeAllViews();
    List localList;
    int i1;
    label50:
    int i2;
    label93:
    int i3;
    label96:
    View localView3;
    if (c())
    {
      localList = a(this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ArrayOfJavaLangString);
      if (b()) {
        break label194;
      }
      i1 = 1;
      View localView1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_phone");
      View localView2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_photo_wall");
      int n = 0;
      if (localList == null) {
        break label199;
      }
      i2 = localList.size();
      i3 = 0;
      if (i3 >= i2) {
        break label468;
      }
      localView3 = (View)localList.get(i3);
      if (localView3 != localView1) {
        break label204;
      }
      label123:
      if ((localView3.getVisibility() != 0) && (localView3 != localView2)) {
        localView3.setVisibility(0);
      }
      if ((i1 != 0) || (!a(n, localView3))) {
        break label469;
      }
      n += 1;
    }
    label194:
    label199:
    label204:
    label468:
    label469:
    for (;;)
    {
      addView(localView3);
      i3 += 1;
      break label96;
      localList = b(this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ArrayOfJavaLangString);
      break;
      i1 = 0;
      break label50;
      i2 = 0;
      break label93;
      if ((localView3 instanceof ProfileCardFavorShowView))
      {
        localObject = (ProfileCardFavorShowView)localView3;
        if ((i1 != 0) && (!c()))
        {
          atxe.a(((ProfileCardFavorShowView)localObject).jdField_a_of_type_AndroidViewViewGroup, "background", this.jdField_a_of_type_Atxe, "commonItemTopBorderBackground");
          break label123;
        }
        ((ProfileCardFavorShowView)localObject).jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130839146);
        break label123;
      }
      if (((localView3 instanceof ViewGroup)) && (localView3.getTag(2131301207) == Boolean.TRUE))
      {
        localObject = (ViewGroup)localView3;
        int i5 = ((ViewGroup)localObject).getChildCount();
        int i4 = 0;
        View localView4;
        if (i4 < i5)
        {
          localView4 = ((ViewGroup)localObject).getChildAt(i4);
          if ((localView4 != null) && ((localView4 instanceof ProfileCardFavorShowView)) && (localView4.getTag(2131301208) != Boolean.TRUE))
          {
            if (i1 == 0) {
              break label388;
            }
            if (!c()) {
              atxe.a(((ProfileCardFavorShowView)localView4).jdField_a_of_type_AndroidViewViewGroup, "background", this.jdField_a_of_type_Atxe, "commonItemTopBorderBackground");
            }
          }
        }
        for (;;)
        {
          i4 += 1;
          break label304;
          break;
          ((ProfileCardFavorShowView)localView4).jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130839146);
        }
      }
      if (i1 != 0)
      {
        if (c()) {
          break label123;
        }
        atxe.a(localView3, "background", this.jdField_a_of_type_Atxe, "commonItemTopBorderBackground");
        break label123;
      }
      Object localObject = localView3.findViewById(2131307374);
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(2130839146);
      }
      localView3.setBackgroundResource(2130839146);
      break label123;
      return;
    }
  }
  
  private boolean g(Card paramCard, boolean paramBoolean)
  {
    if (paramCard == null) {
      return false;
    }
    if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", "", "0X800A1C6", "0X800A1C6", 0, 0, "", "", "", "");
      QZLog.d("cardInfo.allinone.pa", 2, new Object[] { Integer.valueOf(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int) });
      if ((paramCard.presentSwitch) && (!ProfileActivity.AllInOne.f(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
        break label162;
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_present") == null) {
        break label157;
      }
    }
    label157:
    for (paramBoolean = true;; paramBoolean = false)
    {
      return paramBoolean;
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", "", "0X800A1C8", "0X800A1C8", 0, 0, "", "", "", "");
      break;
    }
    label162:
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_present");
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495420, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_present", localView);
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      Object localObject2 = (ViewGroup)localView.findViewById(2131302498);
      TextView localTextView = (TextView)localView.findViewById(2131311372);
      ImageView localImageView1 = (ImageView)localView.findViewById(2131302196);
      Object localObject3 = (ImageView)localView.findViewById(2131302499);
      Object localObject4 = (ImageView)localView.findViewById(2131302500);
      ImageView localImageView2 = (ImageView)localView.findViewById(2131302501);
      ImageView localImageView3 = (ImageView)localView.findViewById(2131302502);
      Object localObject1 = new ArrayList();
      ((List)localObject1).add(localObject3);
      ((List)localObject1).add(localObject4);
      ((List)localObject1).add(localImageView2);
      ((List)localObject1).add(localImageView3);
      localTextView.setSingleLine(true);
      localTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      if ((paramCard.showPresent) && (paramCard.presentUrl != null))
      {
        ((ViewGroup)localObject2).setVisibility(0);
        localObject2 = paramCard.presentUrl;
        localObject3 = getResources();
        int n = ((Resources)localObject3).getDimensionPixelSize(2131167062);
        int i1 = ((Resources)localObject3).getDimensionPixelSize(2131166291);
        int i2 = ((Resources)localObject3).getDimensionPixelSize(2131166288);
        i1 = (int)(this.jdField_b_of_type_Float - i1 - i2);
        i2 = (int)((i1 - n * 3 * 1.0F) / 3.0F);
        if (QLog.isColorLevel()) {
          QLog.e("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "makeOrRefreshQZone count:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(((List)localObject1).size()), Integer.valueOf(i2), Integer.valueOf(n), Integer.valueOf(i1) }));
        }
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          if (((List)localObject2).size() > 4) {
            n = 4;
          }
          for (;;)
          {
            i1 = 0;
            label548:
            if (i1 < n)
            {
              localObject3 = (String)((List)localObject2).get(i1);
              if (!TextUtils.isEmpty((CharSequence)localObject3))
              {
                if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
                  ((ImageView)((List)localObject1).get(i1)).setColorFilter(1996488704);
                }
                if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
                  this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(getResources().getColor(2131100052));
                }
              }
              try
              {
                localObject4 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = i2;
                ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = i2;
                localObject3 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
                ((ImageView)((List)localObject1).get(i1)).setImageDrawable((Drawable)localObject3);
                i1 += 1;
                break label548;
                n = ((List)localObject2).size();
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("Q.profilecard.FrdProfileCard", 2, "makeOrRefreshPresent fail!", localException);
                  }
                }
              }
            }
          }
        }
      }
      if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        localObject1 = ajjy.a(2131642678);
        if (TextUtils.isEmpty(paramCard.presentDesc)) {
          break label909;
        }
      }
      label909:
      for (paramCard = ": " + paramCard.presentDesc;; paramCard = "")
      {
        localTextView.setText((String)localObject1 + ajjy.a(2131642685) + paramCard);
        ThreadManager.getFileThreadHandler().post(new ProfileCardMoreInfoView.10(this, localTextView));
        localView.setTag(new atuw(94, null));
        localView.setOnClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView.setContentDescription(a(2131625593));
        a("map_key_present", null, localTextView, localImageView1);
        return paramBoolean;
        localObject1 = this.jdField_a_of_type_Atwx.jdField_a_of_type_ArrayOfJavaLangString[0];
        break;
      }
    }
  }
  
  private boolean h(Card paramCard, boolean paramBoolean)
  {
    if (paramCard == null) {
      return false;
    }
    int n;
    label34:
    label51:
    label77:
    label99:
    int i1;
    if (ProfileActivity.AllInOne.i(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      n = 1;
      if ((n == 0) && (paramCard.personalityLabel != null)) {
        break label299;
      }
      n = 1;
      if ((n == 0) && (paramCard.personalityLabel.isCloseByUser != 1)) {
        break label304;
      }
      n = 1;
      if ((n == 0) && ((paramCard.personalityLabel.getSize() != 0) || (paramCard.personalityLabel.remainCount > 0))) {
        break label309;
      }
      n = 1;
      if ((n == 0) && (!azzz.b(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label314;
      }
      n = 1;
      if ((n == 0) && ((paramCard.personalityLabel.getSize() != 0) || (azzz.a(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))) {
        break label319;
      }
      n = 1;
      label138:
      if ((n == 0) && ((this.jdField_a_of_type_Bbma == null) || (this.jdField_a_of_type_Bbma.a(3)))) {
        break label324;
      }
      n = 1;
      label162:
      if ((QLog.isColorLevel()) && (paramCard.personalityLabel != null)) {
        QLog.i("ProfileCardUtil.PROFILE_CARD_TAG", 2, "makeOrRefreshPersonalityLabelBoard isCloseByUser:" + paramCard.personalityLabel.isCloseByUser);
      }
      if ((paramBoolean) && (paramCard.personalityLabel != null))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramCard.personalityLabel.isCloseByUser != 1) {
          break label329;
        }
        i1 = 2;
        label239:
        awqx.b((QQAppInterface)localObject1, "dc00898", "", "", "0X8008408", "0X8008408", i1, 0, "", "", "", "");
      }
      if (n == 0) {
        break label340;
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_personality_label_board") == null) {
        break label335;
      }
    }
    label299:
    label304:
    label309:
    label314:
    label319:
    label324:
    label329:
    label335:
    for (paramBoolean = true;; paramBoolean = false)
    {
      return paramBoolean;
      n = 0;
      break;
      n = 0;
      break label34;
      n = 0;
      break label51;
      n = 0;
      break label77;
      n = 0;
      break label99;
      n = 0;
      break label138;
      n = 0;
      break label162;
      i1 = 1;
      break label239;
    }
    label340:
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_personality_label_board");
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = new ProfileCardFavorShowView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localObject2 = new PersonalityLabelBoard(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, (View)localObject1);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) {
        ((PersonalityLabelBoard)localObject2).setScrollListener((atvi)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      }
      ((ProfileCardFavorShowView)localObject1).setTitle(ajjy.a(2131642642));
      ((ProfileCardFavorShowView)localObject1).setVisibility(8);
      ((ProfileCardFavorShowView)localObject1).addView((View)localObject2);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_personality_label_board", localObject1);
    }
    for (boolean bool = true;; bool = false)
    {
      atvb localatvb;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity))
      {
        localObject2 = (ProfileCardFavorShowView)localObject1;
        localatvb = (atvb)((ProfileCardFavorShowView)localObject2).a(0);
        ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a(localatvb);
        localatvb.a(paramCard.personalityLabel, paramBoolean, false);
        a((PersonalityLabelBoard)localatvb, (ProfileCardFavorShowView)localObject1);
        paramCard = a(this.jdField_a_of_type_Atwx);
        if (paramCard == null) {
          break label600;
        }
        localatvb.setNick(paramCard);
      }
      for (;;)
      {
        paramCard = ((ProfileCardFavorShowView)localObject2).jdField_a_of_type_AndroidViewViewGroup;
        paramCard.setTag(new atuw(86, ((ProfileCardFavorShowView)localObject2).a(0)));
        paramCard.setOnClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramCard.setContentDescription(a(2131625605));
        return bool;
        label600:
        localatvb.setNick("");
      }
    }
  }
  
  public int a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    int n = 0;
    int i1 = 0;
    for (;;)
    {
      if ((paramArrayOfString1 != null) && (n < paramArrayOfString1.length)) {
        if (TextUtils.isEmpty(paramArrayOfString1[n]))
        {
          n += 1;
        }
        else
        {
          int i3 = paramArrayOfString2.length;
          i2 = 0;
          label38:
          if (i2 >= i3) {
            break label124;
          }
          if (!paramArrayOfString2[i2].equals(paramArrayOfString1[n])) {
            break;
          }
        }
      }
    }
    label124:
    for (int i2 = 1;; i2 = 0)
    {
      if (i2 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ProfileCardMoreInfoView", 2, String.format("checkTagsForTroop invalid tag for specail troop tag: %s", new Object[] { paramArrayOfString1[n] }));
        }
        paramArrayOfString1[n] = "";
        break;
        i2 += 1;
        break label38;
      }
      i1 += 1;
      break;
      return i1;
    }
  }
  
  public View a(String paramString)
  {
    if ("map_key_tag".equals(paramString))
    {
      paramString = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_medal_and_diamond");
      if (paramString != null) {
        return paramString.findViewById(2131304169);
      }
    }
    else
    {
      return (View)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  protected MessageRecord a()
  {
    Object localObject = akbm.b();
    atmp localatmp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    String str1 = MessageRecord.getTableName(this.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString, 1);
    String str2 = String.format("shmsgseq < %d and senderuin = ? and extLong & 3 <> 3 and msgtype %s and isValid=1", new Object[] { Long.valueOf(9223372036854775807L), localObject });
    if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard != null) {}
    for (localObject = this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.uin;; localObject = this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)
    {
      localObject = localatmp.a(MessageRecord.class, str1, false, str2, new String[] { localObject }, null, null, "shmsgseq DESC", String.valueOf(1));
      localatmp.a();
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        break;
      }
      return null;
    }
    return (MessageRecord)((List)localObject).get(0);
  }
  
  public ProfileCardFavorShowView a(Activity paramActivity)
  {
    if (c()) {
      return ((ProfileQVipDiyView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).a(paramActivity);
    }
    return new ProfileCardFavorShowView(paramActivity);
  }
  
  protected String a(int paramInt)
  {
    return getResources().getString(paramInt);
  }
  
  public HashMap<String, View> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  protected void a()
  {
    ThreadManager.post(new ProfileCardMoreInfoView.6(this), 8, null, true);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt == 0) && (!atxr.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (a(this.jdField_a_of_type_AndroidWidgetTextView))) {
      this.jdField_a_of_type_AndroidWidgetTextView.post(new ProfileCardMoreInfoView.14(this));
    }
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131300717);
      CircleBoarderImageView localCircleBoarderImageView1 = (CircleBoarderImageView)paramView.findViewById(2131298662);
      CircleBoarderImageView localCircleBoarderImageView2 = (CircleBoarderImageView)paramView.findViewById(2131298663);
      paramView = (CircleBoarderImageView)paramView.findViewById(2131298664);
      if (localRelativeLayout != null) {
        localRelativeLayout.setVisibility(8);
      }
      if (localCircleBoarderImageView1 != null) {
        localCircleBoarderImageView1.setVisibility(8);
      }
      if (localCircleBoarderImageView2 != null) {
        localCircleBoarderImageView2.setVisibility(8);
      }
    } while (paramView == null);
    paramView.setVisibility(8);
  }
  
  public void a(View paramView, List<oidb_0xd9f.TopicItem> paramList)
  {
    if (paramView == null) {
      return;
    }
    if ((paramList == null) || (paramList.size() <= 0))
    {
      paramView.setVisibility(8);
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131300717);
    Object localObject = (CircleBoarderImageView)paramView.findViewById(2131298662);
    CircleBoarderImageView localCircleBoarderImageView1 = (CircleBoarderImageView)paramView.findViewById(2131298663);
    CircleBoarderImageView localCircleBoarderImageView2 = (CircleBoarderImageView)paramView.findViewById(2131298664);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localArrayList.add(localCircleBoarderImageView1);
    localArrayList.add(localCircleBoarderImageView2);
    localObject = (TextView)paramView.findViewById(2131312287);
    Collections.sort(paramList, new bbln(this));
    int i1 = atxr.a().a(paramList);
    paramList = atxr.a().a(paramList);
    paramView.setVisibility(0);
    localRelativeLayout.setVisibility(0);
    if (paramList.size() > localArrayList.size())
    {
      n = 0;
      while (n < localArrayList.size())
      {
        ((CircleBoarderImageView)localArrayList.get(n)).setVisibility(0);
        a(String.valueOf(((oidb_0xd9f.UinItem)paramList.get(n)).uint64_uin.get()), (CircleBoarderImageView)localArrayList.get(n));
        n += 1;
      }
    }
    int n = 0;
    if (n < localArrayList.size())
    {
      if (n < paramList.size())
      {
        new azwg(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(1, String.valueOf(((oidb_0xd9f.UinItem)paramList.get(n)).uint64_uin.get()));
        ((CircleBoarderImageView)localArrayList.get(n)).setVisibility(0);
        a(String.valueOf(((oidb_0xd9f.UinItem)paramList.get(n)).uint64_uin.get()), (CircleBoarderImageView)localArrayList.get(n));
      }
      for (;;)
      {
        n += 1;
        break;
        ((CircleBoarderImageView)localArrayList.get(n)).setVisibility(8);
      }
    }
    if (i1 <= 3)
    {
      paramList = i1 + ajjy.a(2131642691);
      ((TextView)localObject).setText(paramList);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label511;
      }
      paramView.setBackgroundDrawable(null);
    }
    for (;;)
    {
      awqx.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "1", "0", "", "");
      return;
      paramList = ajjy.a(2131642661) + i1 + ajjy.a(2131642640);
      break;
      label511:
      if (!b()) {
        paramView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844926));
      } else {
        paramView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844925));
      }
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (!paramBoolean)
    {
      paramView.setVisibility(8);
      return;
    }
    if (!atxr.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      paramView.setVisibility(8);
      return;
    }
    Object localObject = amkr.a();
    if ((localObject == null) || (((amko)localObject).a()))
    {
      paramView.setVisibility(8);
      return;
    }
    a(paramView);
    paramView.setVisibility(0);
    ArrayList localArrayList = ((amko)localObject).a().jdField_a_of_type_JavaUtilArrayList;
    TextView localTextView = (TextView)paramView.findViewById(2131312287);
    ImageView localImageView = (ImageView)paramView.findViewById(2131311641);
    localTextView.setText(atxr.a().a((amko)localObject));
    int n = 0;
    int i1;
    while (n < ((amko)localObject).a().jdField_a_of_type_JavaUtilArrayList.size()) {
      if (TextUtils.isEmpty(((amkq)localArrayList.get(n)).jdField_a_of_type_JavaLangString))
      {
        n += 1;
      }
      else
      {
        i1 = ((amkq)localArrayList.get(n)).jdField_a_of_type_Int;
        localObject = ((amkq)localArrayList.get(n)).jdField_a_of_type_JavaLangString;
      }
    }
    for (n = i1;; n = -1)
    {
      if (paramBoolean) {
        paramView.setOnClickListener(new bblo(this, (String)localObject, n, paramView));
      }
      localImageView.setOnTouchListener(mjg.a);
      localImageView.setOnClickListener(new bblp(this, paramView));
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        paramView.setBackgroundDrawable(null);
      }
      for (;;)
      {
        awqx.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "2", "0", "", "");
        return;
        if (!b()) {
          paramView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844926));
        } else {
          paramView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844925));
        }
      }
      localObject = "";
    }
  }
  
  public void a(atwx paramatwx, View paramView)
  {
    if ((paramatwx == null) || (paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (paramView == null)) {
      return;
    }
    paramView.setVisibility(0);
    Object localObject3 = paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard;
    Object localObject1 = ((Card)localObject3).getPrivilegeOpenInfo();
    Object localObject2 = ((Card)localObject3).getPrivilegeCloseInfo();
    TextView localTextView = (TextView)paramView.findViewById(2131306340);
    paramView = (LinearLayout)paramView.findViewById(2131299623);
    paramView.removeAllViews();
    StringBuilder localStringBuilder = new StringBuilder(24);
    localStringBuilder.append(getContext().getString(2131627839));
    if ((paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      paramatwx = new ArrayList();
      localObject3 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        paramView.setVisibility(0);
        localTextView.setVisibility(8);
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          PrivilegeInfo localPrivilegeInfo = (PrivilegeInfo)localIterator.next();
          if (localPrivilegeInfo.iIsBig == 1) {
            ((List)localObject3).add(localPrivilegeInfo);
          }
          for (;;)
          {
            localPrivilegeInfo.isOpen = true;
            break;
            localArrayList.add(localPrivilegeInfo);
          }
        }
        localStringBuilder.append("你已开通");
        a(localStringBuilder, (List)localObject1);
        if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
          break label385;
        }
        localObject1 = ((List)localObject2).iterator();
        label289:
        if (!((Iterator)localObject1).hasNext()) {
          break label385;
        }
        localObject2 = (PrivilegeInfo)((Iterator)localObject1).next();
        if (((PrivilegeInfo)localObject2).iIsBig != 1) {
          break label372;
        }
        ((List)localObject3).add(localObject2);
      }
      for (;;)
      {
        ((PrivilegeInfo)localObject2).isOpen = false;
        break label289;
        paramView.setVisibility(8);
        localTextView.setVisibility(0);
        localTextView.setText(ajjy.a(2131642682));
        localStringBuilder.append("你未开通特权服务，快去开通vip服务吧！");
        break;
        label372:
        localArrayList.add(localObject2);
      }
      label385:
      paramatwx.addAll((Collection)localObject3);
      paramatwx.addAll(localArrayList);
      a(paramatwx, paramView, false);
    }
    for (;;)
    {
      paramView.setContentDescription(localStringBuilder);
      a("map_key_medal_and_diamond", null, localTextView, null);
      return;
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        break;
      }
      paramView.setVisibility(0);
      localTextView.setVisibility(8);
      a((List)localObject1, paramView, true);
      localStringBuilder.append("你的好友已开通");
      a(localStringBuilder, (List)localObject1);
    }
    paramatwx = ((Card)localObject3).privilegePromptStr;
    if (TextUtils.isEmpty(paramatwx)) {
      localTextView.setVisibility(4);
    }
    for (;;)
    {
      paramView.setVisibility(8);
      break;
      localTextView.setText(paramatwx);
      localTextView.setVisibility(0);
      localStringBuilder.append("TA还未开通任何服务特权");
    }
  }
  
  public void a(atwx paramatwx, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, boolean paramBoolean, bbma parambbma)
  {
    this.jdField_a_of_type_Atwx = paramatwx;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Bbma = parambbma;
    this.jdField_a_of_type_Azwg = new azwg(this.jdField_a_of_type_AndroidContentContext, paramQQAppInterface);
    this.jdField_a_of_type_Azwg.a(this);
    ((FriendProfileCardActivity)paramBaseActivity).a(this);
  }
  
  public void a(atwx paramatwx, boolean paramBoolean, String... paramVarArgs)
  {
    if (paramatwx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCardMoreInfoView", 2, "update info is null");
      }
      return;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      if ((paramatwx.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramatwx.jdField_a_of_type_JavaLangString)))
      {
        paramVarArgs = this.jdField_b_of_type_ArrayOfJavaLangString;
        label55:
        n = paramVarArgs.length;
      }
    }
    for (;;)
    {
      if (n != 0) {
        break label143;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ProfileCardMoreInfoView", 2, "update no validate tags");
      return;
      paramVarArgs = this.jdField_a_of_type_ArrayOfJavaLangString;
      break label55;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
        n = 0;
      } else if ((paramatwx.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramatwx.jdField_a_of_type_JavaLangString))) {
        n = a(paramVarArgs, this.jdField_b_of_type_ArrayOfJavaLangString);
      } else {
        n = paramVarArgs.length;
      }
    }
    label143:
    if (c()) {
      ((ProfileQVipDiyView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).a(paramatwx, paramBoolean, paramVarArgs);
    }
    int i1 = paramVarArgs.length;
    int n = 0;
    boolean bool2 = false;
    label173:
    String str;
    boolean bool1;
    if (n < i1)
    {
      str = paramVarArgs[n];
      if (TextUtils.isEmpty(str)) {
        bool1 = bool2;
      }
    }
    for (;;)
    {
      n += 1;
      bool2 = bool1;
      break label173;
      try
      {
        if ("map_key_sig".equals(str))
        {
          RichStatus localRichStatus = paramatwx.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
          localObject = localRichStatus;
          if (localRichStatus == null)
          {
            localObject = localRichStatus;
            if (paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
              localObject = paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.getRichStatus();
            }
          }
          bool1 = a((RichStatus)localObject);
          if (bool2) {
            break label1069;
          }
          if (!bool1) {
            break label1075;
          }
          break label1069;
        }
        if ("map_key_qzone".equals(str))
        {
          bool1 = d(paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard);
          if (bool2) {
            break label1081;
          }
          if (!bool1) {
            break label1087;
          }
          break label1081;
        }
        if ("map_key_medal_and_diamond".equals(str))
        {
          bool1 = a(paramatwx, paramBoolean);
          if (bool2) {
            break label1093;
          }
          if (!bool1) {
            break label1099;
          }
          break label1093;
        }
        if (!"map_key_medal".equals(str)) {
          break label435;
        }
        Object localObject = a(str);
        if (localObject == null) {
          break label414;
        }
        b(paramatwx, (View)localObject);
        bool1 = bool2;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        QLog.i("ProfileCardMoreInfoView", 1, String.format("update crash tag: %s", new Object[] { str }));
        bool1 = bool2;
      }
      continue;
      label414:
      bool1 = a(paramatwx, true);
      if (!bool2)
      {
        if (!bool1) {
          break label1111;
        }
        break label1105;
        label435:
        if ("map_key_troop_mem_game_info".equals(str))
        {
          bool1 = b(paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard, paramBoolean);
          if (bool2) {
            break label1117;
          }
          if (!bool1) {
            break label1123;
          }
          break label1117;
        }
        if ("map_key_troop_mem_add_time".equals(str))
        {
          bool1 = a();
          if (bool2) {
            break label1129;
          }
          if (!bool1) {
            break label1135;
          }
          break label1129;
        }
        if ("map_key_troop_mem_charm_level".equals(str))
        {
          bool1 = a(paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard, paramBoolean);
          if (bool2) {
            break label1141;
          }
          if (!bool1) {
            break label1147;
          }
          break label1141;
        }
        if ("map_key_troop_mem_recent_said".equals(str))
        {
          bool1 = d();
          if (bool2) {
            break label1153;
          }
          if (!bool1) {
            break label1159;
          }
          break label1153;
        }
        if ("map_key_tag".equals(str))
        {
          bool1 = e(paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard);
          if (bool2) {
            break label1165;
          }
          if (!bool1) {
            break label1171;
          }
          break label1165;
        }
        if ("map_key_account_level_info".equals(str))
        {
          bool1 = b(paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard);
          if (bool2) {
            break label1177;
          }
          if (!bool1) {
            break label1183;
          }
          break label1177;
        }
        if ("map_key_phone".equals(str))
        {
          bool1 = a(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList);
          if (bool2) {
            break label1189;
          }
          if (!bool1) {
            break label1195;
          }
          break label1189;
        }
        if ("map_key_mine_weishi".equals(str))
        {
          bool1 = c(paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard);
          if (bool2) {
            break label1201;
          }
          if (!bool1) {
            break label1207;
          }
          break label1201;
        }
        if ("map_key_photo_wall".equals(str))
        {
          bool1 = f(paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard, paramBoolean);
          if (bool2) {
            break label1213;
          }
          if (!bool1) {
            break label1219;
          }
          break label1213;
        }
        if ("map_key_personality_label_board".equals(str))
        {
          bool1 = h(paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard, paramBoolean);
          if (bool2) {
            break label1225;
          }
          if (!bool1) {
            break label1231;
          }
          break label1225;
        }
        if ("map_key_extend_friend_info".equals(str))
        {
          bool1 = e(paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard, paramBoolean);
          if (bool2) {
            break label1237;
          }
          if (!bool1) {
            break label1243;
          }
          break label1237;
        }
        if ("map_key_favor".equals(str))
        {
          bool1 = d(paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard, paramBoolean);
          if (bool2) {
            break label1249;
          }
          if (!bool1) {
            break label1255;
          }
          break label1249;
        }
        if ("map_key_account_base_info".equals(str))
        {
          bool1 = c(paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard, paramBoolean);
          if (bool2) {
            break label1261;
          }
          if (!bool1) {
            break label1267;
          }
          break label1261;
        }
        if ("map_key_present".equals(str))
        {
          bool1 = g(paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard, paramBoolean);
          if (bool2) {
            break label1273;
          }
          if (!bool1) {
            break label1279;
          }
          break label1273;
        }
        if ("map_key_mini_playing".equals(str))
        {
          bool1 = f(paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard);
          if (bool2) {
            break label1285;
          }
          if (!bool1) {
            break label1291;
          }
          break label1285;
        }
        if ("map_key_music_box".equals(str))
        {
          if (atyz.a(paramatwx))
          {
            bool1 = a(paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard);
            break label1297;
          }
          if (this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_music_box") == null) {
            break label1313;
          }
          bool1 = true;
          break label1297;
        }
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ProfileCardMoreInfoView", 2, String.format("update invalid tag: %s", new Object[] { str }));
        bool1 = bool2;
        continue;
        if (bool2) {
          g();
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ProfileCardMoreInfoView", 2, String.format("update ret: %s tags: %s", new Object[] { Boolean.valueOf(bool2), TextUtils.join(",", paramVarArgs) }));
        return;
        label1069:
        bool1 = true;
        continue;
        label1075:
        bool1 = false;
        continue;
        label1081:
        bool1 = true;
        continue;
        label1087:
        bool1 = false;
        continue;
        label1093:
        bool1 = true;
        continue;
        label1099:
        bool1 = false;
        continue;
      }
      label1105:
      bool1 = true;
      continue;
      label1111:
      bool1 = false;
      continue;
      label1117:
      bool1 = true;
      continue;
      label1123:
      bool1 = false;
      continue;
      label1129:
      bool1 = true;
      continue;
      label1135:
      bool1 = false;
      continue;
      label1141:
      bool1 = true;
      continue;
      label1147:
      bool1 = false;
      continue;
      label1153:
      bool1 = true;
      continue;
      label1159:
      bool1 = false;
      continue;
      label1165:
      bool1 = true;
      continue;
      label1171:
      bool1 = false;
      continue;
      label1177:
      bool1 = true;
      continue;
      label1183:
      bool1 = false;
      continue;
      label1189:
      bool1 = true;
      continue;
      label1195:
      bool1 = false;
      continue;
      label1201:
      bool1 = true;
      continue;
      label1207:
      bool1 = false;
      continue;
      label1213:
      bool1 = true;
      continue;
      label1219:
      bool1 = false;
      continue;
      label1225:
      bool1 = true;
      continue;
      label1231:
      bool1 = false;
      continue;
      label1237:
      bool1 = true;
      continue;
      label1243:
      bool1 = false;
      continue;
      label1249:
      bool1 = true;
      continue;
      label1255:
      bool1 = false;
      continue;
      label1261:
      bool1 = true;
      continue;
      label1267:
      bool1 = false;
      continue;
      label1273:
      bool1 = true;
      continue;
      label1279:
      bool1 = false;
      continue;
      label1285:
      bool1 = true;
      continue;
      label1291:
      bool1 = false;
      continue;
      for (;;)
      {
        label1297:
        if ((!bool2) && (!bool1)) {
          break label1319;
        }
        bool1 = true;
        break;
        label1313:
        bool1 = false;
      }
      label1319:
      bool1 = false;
    }
  }
  
  public void a(avfz paramavfz, View paramView)
  {
    paramavfz = paramavfz.a();
    if ((paramavfz instanceof Pair))
    {
      paramavfz = (Pair)paramavfz;
      avgf.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, avgf.a(((Integer)paramavfz.first).intValue(), (String)paramavfz.second), -1);
      if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label113;
      }
    }
    label113:
    for (int n = 1;; n = 2)
    {
      awqx.b(null, "dc00898", "", "", "0X800A4D3", "0X800A4D3", n, 0, "" + n, "0", "", "");
      return;
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() <= 0) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (!(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity))) {
      QLog.i("notifyProfileActScrollToMoreInfo", 1, "mMoreInfoMap or mActivity is null");
    }
    int n;
    do
    {
      do
      {
        return;
        paramString = (View)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      } while (paramString == null);
      n = paramString.getTop();
      QLog.i("notifyProfileActScrollToMoreInfo", 1, "scroll offset=" + n);
    } while (n < 0);
    ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).d(n);
  }
  
  void a(String paramString, TextView paramTextView, View paramView, ImageView paramImageView)
  {
    try
    {
      if ((this.jdField_a_of_type_Atxe != null) && (this.jdField_a_of_type_Atxe.a != null) && (this.jdField_a_of_type_Atxe.a.size() > 0))
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, String.valueOf(this.jdField_a_of_type_Atxe.o));
        atxe.a(paramTextView, "color", this.jdField_a_of_type_Atxe, "commonItemTitleColor");
        atxe.a(paramView, "color", this.jdField_a_of_type_Atxe, "commonItemContentColor");
        atxe.a(paramImageView, "src", this.jdField_a_of_type_Atxe, "commonItemMoreSrc");
        return;
      }
      if (c())
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, String.valueOf(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId));
        atxe.a((ProfileQVipDiyView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, paramString, paramTextView, paramView, paramImageView);
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
      paramTextView.setTextColor(getResources().getColorStateList(2131101333));
    }
    if ((paramView instanceof TextView)) {
      ((TextView)paramView).setTextColor(getResources().getColorStateList(2131101260));
    }
    while (paramImageView != null)
    {
      paramImageView.setImageResource(2130838988);
      return;
      if ((paramView instanceof SingleLineTextView)) {
        ((SingleLineTextView)paramView).setTextColor(getResources().getColorStateList(2131101260));
      }
    }
  }
  
  public boolean a()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (!this.jdField_a_of_type_Atwx.jdField_b_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_troop_mem_add_time") != null;
    }
    String str1 = "";
    String str2 = str1;
    long l1;
    if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard != null)
    {
      str2 = str1;
      if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.joinTime > 0L)
      {
        l1 = this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.joinTime;
        if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.joinTime == 1L) {}
      }
    }
    try
    {
      str1 = DateFormat.format(a(2131627900), 1000L * l1).toString();
      str2 = str1;
      if (QLog.isColorLevel())
      {
        QLog.d("ProfileCardMoreInfoView", 2, String.format("makeOrRefreshTroopMemJoinTime, timeStamp: %s, joinTime: %s", new Object[] { Long.valueOf(l1), str1 }));
        str2 = str1;
      }
      if (TextUtils.isEmpty(str2)) {
        if (this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_troop_mem_add_time") != null) {
          return bool1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = "";
        continue;
        bool1 = false;
      }
      localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_troop_mem_add_time");
      if (localObject1 != null) {
        break label337;
      }
    }
    Object localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131496944, null);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_troop_mem_add_time", localObject1);
    Object localObject2 = (ImageView)((View)localObject1).findViewById(2131302061);
    ((ImageView)localObject2).setImageResource(2130844848);
    ((ImageView)localObject2).clearColorFilter();
    ((ImageView)localObject2).setColorFilter(10067634);
    label337:
    for (bool1 = true;; bool1 = bool2)
    {
      localObject2 = (TextView)((View)localObject1).findViewById(2131302720);
      localObject1 = (ImageView)((View)localObject1).findViewById(2131297252);
      ((ImageView)localObject1).setVisibility(8);
      ((TextView)localObject2).setText(str2);
      QLog.d("tagckb", 2, "makeOrRefreshTroopMemJoinTime 05");
      a("map_key_troop_mem_add_time", null, (View)localObject2, (ImageView)localObject1);
      return bool1;
    }
  }
  
  public boolean a(atwx paramatwx)
  {
    if ((paramatwx == null) || (paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!ProfileActivity.AllInOne.b(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while ((paramatwx.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramatwx.jdField_a_of_type_JavaLangString)));
        if (baig.W(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) == 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ProfileCardMoreInfoView", 2, "medal config off");
      return false;
    } while ((paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.medalSwitchDisable) || (azzz.b(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)));
    return true;
  }
  
  public boolean a(atwx paramatwx, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramatwx == null) {
      localObject = null;
    }
    while (localObject == null) {
      if (this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_medal_and_diamond") != null)
      {
        return true;
        localObject = paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard;
      }
      else
      {
        return false;
      }
    }
    if (!azzz.b(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      paramBoolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("makeAccountLineThree, , diamond: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
      if (paramBoolean) {
        break label114;
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_medal_and_diamond") == null) {
        break label109;
      }
    }
    label109:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      return paramBoolean;
      paramBoolean = false;
      break;
    }
    label114:
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_medal_and_diamond");
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495406, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_and_diamond", localObject);
    }
    for (bool = true;; bool = false)
    {
      ImageView localImageView = (ImageView)((View)localObject).findViewById(2131297252);
      View localView = ((View)localObject).findViewById(2131299622);
      if (paramBoolean)
      {
        a(paramatwx, localView);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        localMarginLayoutParams.leftMargin = 0;
        localView.setLayoutParams(localMarginLayoutParams);
        if (!paramBoolean) {
          break label273;
        }
        ((View)localObject).setTag(new atuw(26, null));
        ((View)localObject).setOnClickListener(paramatwx.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        a("map_key_medal_and_diamond", null, null, localImageView);
        return bool;
        localView.setVisibility(8);
        ((View)localObject).setTag(null);
        break;
        label273:
        ((View)localObject).setTag(new atuw(91, null));
        ((View)localObject).setOnClickListener(this.jdField_a_of_type_Bbmg);
      }
    }
  }
  
  public boolean a(atxe paramatxe)
  {
    if (paramatxe == null) {}
    for (paramatxe = "0"; this.jdField_b_of_type_JavaUtilHashMap.size() > 0; paramatxe = String.valueOf(paramatxe.o))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
      String str;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
      } while (((String)this.jdField_b_of_type_JavaUtilHashMap.get(str)).equals(paramatxe));
      return false;
    }
    return true;
  }
  
  public boolean a(Card paramCard)
  {
    boolean bool = false;
    if (atxe.a(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId)) {
      return true;
    }
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_music_box");
    if (localObject == null)
    {
      localObject = new atyz(false);
      paramCard = ((atyz)localObject).a(this.jdField_a_of_type_AndroidContentContext, paramCard.uin);
      paramCard.setTag(2131496029, localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_music_box", paramCard);
      bool = true;
    }
    for (;;)
    {
      if (paramCard.getTag(2131496029) != null) {
        ((atyz)paramCard.getTag(2131496029)).a(this.jdField_a_of_type_Atwx);
      }
      a("map_key_music_box", null, (TextView)paramCard.findViewById(2131311372), (ImageView)paramCard.findViewById(2131302196));
      return bool;
      paramCard = (Card)localObject;
    }
  }
  
  public boolean a(Card paramCard, boolean paramBoolean)
  {
    paramBoolean = false;
    if ((!this.jdField_a_of_type_Atwx.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Atwx.jdField_b_of_type_Int < 0) || (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atwx.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(ProfileCardMoreInfoView.class.getSimpleName(), 2, "makeOrRefreshTroopMemCharmLevelInfo, isQidianPrivateTroop");
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_troop_mem_charm_level") != null) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
    paramCard = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_troop_mem_charm_level");
    Object localObject;
    if (paramCard == null)
    {
      paramCard = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131496944, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_troop_mem_charm_level", paramCard);
      localObject = (ImageView)paramCard.findViewById(2131302061);
      ((ImageView)localObject).setImageResource(2130844846);
      ((ImageView)localObject).clearColorFilter();
      ((ImageView)localObject).setColorFilter(10067634);
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      localObject = (TextView)paramCard.findViewById(2131302720);
      ImageView localImageView = (ImageView)paramCard.findViewById(2131297252);
      ((TextView)localObject).setText("群聊等级已达LV" + this.jdField_a_of_type_Atwx.jdField_b_of_type_Int + " ");
      paramCard.setTag(new atuw(80, null));
      paramCard.setOnClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramCard.setOnLongClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      a("map_key_troop_mem_charm_level", null, (View)localObject, localImageView);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "charm", "exp_grpname", 0, 0, String.valueOf(this.jdField_a_of_type_Atwx.jdField_b_of_type_Int), "", "", "");
      return paramBoolean;
    }
  }
  
  public boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() <= 0) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null)) {}
    while (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      return false;
    }
    paramString = (View)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((paramString != null) && (b(paramString))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() <= 0) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (!(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity))) {}
    Object localObject;
    do
    {
      do
      {
        return;
        this.jdField_d_of_type_Int = 0;
        localObject = (ProfileCardFavorShowView)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_extend_friend_info");
      } while ((localObject == null) || (!(((ProfileCardFavorShowView)localObject).a(0) instanceof ProfileCardExtendFriendView)));
      localObject = (ProfileCardExtendFriendView)((ProfileCardFavorShowView)localObject).a(0);
    } while (localObject == null);
    ((ProfileCardExtendFriendView)localObject).a();
  }
  
  public void b(int paramInt)
  {
    int i1 = 2;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onUpdatePhotoWall size:" + paramInt);
    }
    if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (int n = 1;; n = 0)
    {
      View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_photo_wall");
      if ((localView != null) && ((n != 0) || (paramInt > 0)))
      {
        localView.setVisibility(0);
        if (n == 0) {
          break;
        }
        n = i1;
        if (paramInt > 0) {
          n = 1;
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EBC", "0X8007EBC", n, 0, "", "", "", "");
      }
      return;
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EBD", "0X8007EBD", 0, 0, "", "", "", "");
  }
  
  public void b(atwx paramatwx, View paramView)
  {
    if ((paramatwx == null) || (paramView == null) || (paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {
      return;
    }
    paramView.setVisibility(0);
    Object localObject1 = (TextView)paramView.findViewById(2131304172);
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView).a(53).a(true).c(1).e(10).a();
    }
    RedTouch localRedTouch = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
    Object localObject2 = (atax)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160);
    RedTouchItem localRedTouchItem = ((atax)localObject2).a(10016);
    int n;
    if (((atax)localObject2).a(localRedTouchItem, false))
    {
      if (!QLog.isColorLevel()) {
        break label571;
      }
      QLog.d("ProfileCardMoreInfoView", 2, "update head icon red point: " + localRedTouchItem.redtouchType);
      n = 1;
    }
    for (;;)
    {
      localObject2 = getResources().getDrawable(2130844863);
      ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Drawable)localObject2);
      ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
      ((TextView)localObject1).setVisibility(0);
      if (paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        ((TextView)localObject1).setText(String.format(Locale.getDefault(), "%d枚", new Object[] { Integer.valueOf(paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.iMedalCount - paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.iNewCount) }));
        if (paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.iNewCount > 0)
        {
          n = aciy.a(5.0F, getResources());
          paramView.setPadding(0, aciy.a(10.0F, getResources()), n, 0);
          localRedTouch.b(0).a();
          localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(4);
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.set(String.format(Locale.getDefault(), "+%d", new Object[] { Integer.valueOf(paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.iNewCount) }));
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_desc.set("{'cn':'#FF0000', 'av':1}");
        }
      }
      for (;;)
      {
        label356:
        paramView.setContentDescription(String.format(Locale.getDefault(), ajjy.a(2131642683), new Object[] { Integer.valueOf(paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.iMedalCount - paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.iNewCount) }));
        for (;;)
        {
          localRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
          return;
          n = 0;
          break;
          if ((n == 0) && (paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.iUpgradeCount <= 0)) {
            break label565;
          }
          paramView.setPadding(0, 0, aciy.a(4.0F, getResources()), 0);
          localRedTouch.b(15).a();
          localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(0);
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.set("");
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_desc.set("");
          break label356;
          ((TextView)localObject1).setText(String.format(Locale.getDefault(), "%d枚", new Object[] { Integer.valueOf(paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.iMedalCount) }));
          paramView.setContentDescription(String.format(Locale.getDefault(), ajjy.a(2131642675), new Object[] { Integer.valueOf(paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.iMedalCount) }));
          localObject1 = null;
        }
        label565:
        localObject1 = null;
      }
      label571:
      n = 1;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bblv != null)
    {
      localObject = (avev)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
      if (localObject != null)
      {
        ((avev)localObject).b(this.jdField_a_of_type_Bblv);
        this.jdField_a_of_type_Bblv = null;
      }
    }
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.d();
    }
    Object localObject = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if (localObject != null) {
      ((atza)localObject).a(null);
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileQVipDiyView;
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 66	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: ldc 111
    //   8: invokevirtual 1019	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11: checkcast 227	android/view/View
    //   14: astore_2
    //   15: aload_2
    //   16: ifnonnull +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 244	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Atwx	Latwx;
    //   26: getfield 398	atwx:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   29: getfield 402	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   32: aload_0
    //   33: getfield 465	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   36: invokevirtual 2045	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   39: invokevirtual 463	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: istore_1
    //   43: aload_0
    //   44: iload_1
    //   45: invokespecial 2822	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:a	(Z)V
    //   48: iload_1
    //   49: ifne -30 -> 19
    //   52: aload_2
    //   53: instanceof 598
    //   56: ifeq -37 -> 19
    //   59: aload_2
    //   60: checkcast 598	com/tencent/mobileqq/widget/ProfileCardFavorShowView
    //   63: iconst_0
    //   64: invokevirtual 751	com/tencent/mobileqq/widget/ProfileCardFavorShowView:a	(I)Landroid/view/View;
    //   67: astore_2
    //   68: aload_2
    //   69: instanceof 794
    //   72: ifeq -53 -> 19
    //   75: aload_0
    //   76: aload_2
    //   77: checkcast 794	com/tencent/mobileqq/widget/ProfileCardExtendFriendView
    //   80: getfield 2824	com/tencent/mobileqq/widget/ProfileCardExtendFriendView:e	Landroid/widget/TextView;
    //   83: invokespecial 2711	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:b	(Landroid/view/View;)Z
    //   86: ifeq -67 -> 19
    //   89: aload_0
    //   90: getfield 2826	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:l	Z
    //   93: ifne -74 -> 19
    //   96: aload_0
    //   97: getfield 465	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   100: ldc_w 483
    //   103: ldc_w 449
    //   106: ldc_w 449
    //   109: ldc_w 2828
    //   112: ldc_w 2828
    //   115: iconst_0
    //   116: iconst_0
    //   117: ldc_w 449
    //   120: ldc_w 449
    //   123: ldc_w 449
    //   126: ldc_w 449
    //   129: invokestatic 490	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_0
    //   133: iconst_1
    //   134: putfield 2826	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:l	Z
    //   137: goto -118 -> 19
    //   140: astore_2
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_2
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	ProfileCardMoreInfoView
    //   42	7	1	bool	boolean
    //   14	63	2	localView	View
    //   140	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	140	finally
    //   22	48	140	finally
    //   52	137	140	finally
  }
  
  public void e()
  {
    float f1 = this.jdField_c_of_type_Float;
    float f2 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a();
    float f3 = this.jdField_d_of_type_Float;
    float f4 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a();
    this.jdField_e_of_type_Float = (this.jdField_b_of_type_Float - (f1 + f2) - (f3 + f4));
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = (CircleBoarderImageView)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      paramString.setImageBitmap(paramBitmap);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    QLog.i("ProfileCardMoreInfoView", 2, "ProfileCardMoreInfoView change=" + paramBoolean + " l=" + paramInt1 + " t=" + paramInt2 + " r=" + paramInt3 + " b=" + paramInt4);
  }
  
  public void setMineWeiShiPanelInfo(wzm paramwzm, boolean paramBoolean)
  {
    QLog.i("ProfileCardMoreInfoView", 2, "setMineWeiShiPanelInfo");
    this.jdField_a_of_type_Wzm = paramwzm;
    this.h = paramBoolean;
  }
  
  public void setNewSignature(byte[] paramArrayOfByte, long paramLong)
  {
    atmp localatmp;
    Object localObject;
    if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localatmp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localObject != null) {
        break label126;
      }
      localObject = null;
      if (localObject != null) {
        break label146;
      }
      localObject = new Card();
      ((Card)localObject).uin = this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      ((Card)localObject).vRichSign = paramArrayOfByte;
      ((Card)localObject).lSignModifyTime = paramLong;
      localatmp.a((atmo)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = ((Card)localObject).getRichStatus();
      a(this.jdField_a_of_type_Atwx, true, new String[] { "map_key_sig" });
      return;
      label126:
      localObject = ((ajjj)localObject).b(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      break;
      label146:
      ((Card)localObject).vRichSign = paramArrayOfByte;
      ((Card)localObject).lSignModifyTime = paramLong;
      localatmp.a((atmo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardMoreInfoView
 * JD-Core Version:    0.7.0.1
 */