package com.tencent.mobileqq.widget;

import QQService.EVIPSPEC;
import QQService.PrivilegeInfo;
import SummaryCard.PhotoInfo;
import abfs;
import actn;
import ajxn;
import ajyc;
import akjo;
import akpy;
import anas;
import anat;
import anau;
import anav;
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
import aoep;
import aokl;
import apvb;
import atxb;
import aukm;
import aukn;
import auko;
import ausu;
import ausz;
import autg;
import auuw;
import auvd;
import auvi;
import auvk;
import auvl;
import auvm;
import auvq;
import auwy;
import auwz;
import avnk;
import aweo;
import awfs;
import awft;
import awfy;
import axmt;
import axqw;
import ayki;
import ayks;
import bamn;
import bavg;
import bawu;
import baxk;
import baxl;
import bazj;
import bazo;
import bbbb;
import bbbd;
import bbcl;
import bbdr;
import bbjn;
import bbkx;
import bbql;
import bcni;
import bcob;
import bcol;
import bcom;
import bcon;
import bcoo;
import bcop;
import bcoq;
import bcor;
import bcos;
import bcot;
import bcoy;
import bcpc;
import bcpe;
import bcrj;
import bfob;
import bgxy;
import bhbh;
import bhna;
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
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
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
import mqq.os.MqqHandler;
import muf;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.LongNickItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.RspBody;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.TopicItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.UinItem;
import xim;

public class ProfileCardMoreInfoView
  extends LinearLayout
  implements abfs, awft, baxl, bcob, bfob
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public auuw a;
  public auvd a;
  private baxk jdField_a_of_type_Baxk;
  public bcot a;
  private bcoy jdField_a_of_type_Bcoy;
  private final bcpe jdField_a_of_type_Bcpe = new bcpe(this);
  private bhna jdField_a_of_type_Bhna;
  public BaseActivity a;
  public QQAppInterface a;
  public ProfileHeaderView a;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ProfileCardMoreInfoView.1(this);
  private String jdField_a_of_type_JavaLangString;
  HashMap<String, View> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map<String, CircleBoarderImageView> jdField_a_of_type_JavaUtilMap;
  private xim jdField_a_of_type_Xim;
  boolean jdField_a_of_type_Boolean;
  private TextView[] jdField_a_of_type_ArrayOfAndroidWidgetTextView;
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "map_key_account_base_info", "map_key_tag", "map_key_sig", "map_key_phone", "map_key_troop_mem_add_time", "map_key_troop_mem_charm_level", "map_key_troop_mem_recent_said", "map_key_troop_mem_game_info", "map_key_account_level_info", "map_key_medal_and_diamond", "map_key_qzone", "map_key_present", "map_key_music_box", "map_key_mine_weishi", "map_key_photo_wall", "map_key_personality_label_board", "map_key_extend_friend_info", "map_key_favor", "map_key_mini_playing", "map_key_sticky_note" };
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
  private final String[] jdField_c_of_type_ArrayOfJavaLangString = { "map_key_troop_mem_add_time", "map_key_account_level_info", "map_key_medal_and_diamond", "map_key_qzone", "map_key_present", "map_key_music_box", "map_key_mine_weishi", "map_key_photo_wall" };
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
  private boolean n;
  
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
    int i3 = 0;
    int i1 = 0;
    if (i3 < paramList.size())
    {
      PrivilegeInfo localPrivilegeInfo = (PrivilegeInfo)paramList.get(i3);
      int i2 = i1;
      if (!TextUtils.isEmpty(localPrivilegeInfo.strDeluxeIconUrl))
      {
        if (i1 == 0) {}
        for (i2 = 0;; i2 = paramInt1)
        {
          i1 += 1;
          paramArrayOfInt[0] = (paramArrayOfInt[0] - paramInt2 - i2);
          if (paramArrayOfInt[0] >= 0) {
            break;
          }
          paramInt1 = i1;
          if (QLog.isColorLevel())
          {
            QLog.d("ProfileCardMoreInfoView", 1, "medal list layout is big =" + localPrivilegeInfo.iIsBig + " icon index=" + i1);
            paramInt1 = i1;
          }
          return paramInt1;
        }
        a(localPrivilegeInfo, localPrivilegeInfo.strDeluxeIconUrl, paramLinearLayout, paramInt2, paramInt3, i2, paramDrawable, paramBoolean);
        i2 = i1;
      }
      if (!TextUtils.isEmpty(localPrivilegeInfo.strIconUrl))
      {
        if (i2 == 0) {}
        for (i1 = 0;; i1 = paramInt1)
        {
          i2 += 1;
          paramArrayOfInt[0] = (paramArrayOfInt[0] - paramInt2 - i1);
          if (paramArrayOfInt[0] >= 0) {
            break label268;
          }
          paramInt1 = i2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ProfileCardMoreInfoView", 1, "medal list layout is big =" + localPrivilegeInfo.iIsBig + " icon index=" + i2);
          return i2;
        }
        label268:
        a(localPrivilegeInfo, localPrivilegeInfo.strIconUrl, paramLinearLayout, paramInt2, paramInt3, i1, paramDrawable, paramBoolean);
      }
      for (i1 = i2;; i1 = i2)
      {
        i3 += 1;
        break;
      }
    }
    return i1;
  }
  
  private ViewGroup a(ViewGroup paramViewGroup, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramViewGroup != null) && (paramInt1 > 0) && (!TextUtils.isEmpty(paramString)))
    {
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560980, null);
      View localView = localViewGroup.findViewById(2131367679);
      TextView localTextView = (TextView)localViewGroup.findViewById(2131368086);
      localView.setBackgroundResource(paramInt1);
      localTextView.setText(paramString.trim());
      paramViewGroup.addView(localViewGroup);
      if (paramInt2 == 1) {
        bazo.a(localTextView, null, null, this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnLongClickListener);
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
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560982, null);
    View localView = localViewGroup.findViewById(2131368335);
    TextView localTextView = (TextView)localViewGroup.findViewById(2131368086);
    ImageView localImageView = (ImageView)localViewGroup.findViewById(2131362792);
    localView.setVisibility(0);
    localView.setBackgroundResource(2130844943);
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
    paramDrawable = bbql.a(paramString, bbql.b, paramDrawable);
    if (paramDrawable != null)
    {
      ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), localURLImageView);
      if (paramDrawable.getStatus() == 2)
      {
        localURLImageView.setVisibility(8);
        paramDrawable.restartDownload();
      }
      localURLImageView.setImageDrawable(paramDrawable);
      localURLImageView.setURLDrawableDownListener(new bcpc(localURLImageView, paramString, "showDiamondImage onLoadFailed iconUrl = "));
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
  
  public static String a(auuw paramauuw)
  {
    Object localObject2 = paramauuw.jdField_a_of_type_ArrayOfJavaLangString[4];
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramauuw.jdField_a_of_type_ArrayOfJavaLangString[0];
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
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
      paramString.setTag(new ausu(93, paramPrivilegeInfo));
      paramString.setOnClickListener(this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnClickListener);
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
              break label409;
            }
            if (!paramPrivilegeInfo.isOpen) {
              break label403;
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
        paramPrivilegeInfo = String.valueOf(akjo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false));
      }
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qvip", paramString, paramInt1, 0, paramPrivilegeInfo, "", "", "");
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
      label403:
      paramInt1 = 2;
      continue;
      label409:
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
    this.jdField_c_of_type_Float = (this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297094) + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297373) + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297374));
    float f1 = this.jdField_a_of_type_Float;
    int i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297370);
    int i2 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297371);
    this.jdField_d_of_type_Float = (7.0F * f1 + i1 + i2);
    this.jdField_e_of_type_Float = (this.jdField_b_of_type_Float - this.jdField_c_of_type_Float - this.jdField_d_of_type_Float);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private void a(LinearLayout paramLinearLayout, Card paramCard)
  {
    List localList = paramCard.getBigOrderEntrys();
    int i3 = 0;
    if (localList != null)
    {
      paramLinearLayout.removeAllViews();
      int i1;
      int i2;
      label40:
      auvl localauvl;
      int i4;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)))
      {
        i1 = 1;
        i2 = 0;
        if (i2 >= localList.size()) {
          break label863;
        }
        localauvl = (auvl)localList.get(i2);
        i4 = i3;
        if (!TextUtils.isEmpty(localauvl.jdField_a_of_type_JavaLangString))
        {
          if (localauvl.jdField_a_of_type_JavaUtilArrayList != null) {
            break label111;
          }
          i4 = i3;
        }
      }
      for (;;)
      {
        i2 += 1;
        i3 = i4;
        break label40;
        i1 = 0;
        break;
        label111:
        i4 = i3;
        if (localauvl.jdField_a_of_type_Int != 5) {
          if ((localauvl.jdField_a_of_type_Int == 4) && (this.jdField_a_of_type_Bcoy != null))
          {
            i4 = i3;
            if (!this.jdField_a_of_type_Bcoy.a(5)) {}
          }
          else if ((localauvl.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Bcoy != null))
          {
            i4 = i3;
            if (!this.jdField_a_of_type_Bcoy.a(4)) {}
          }
          else
          {
            ProfileCardFavorShowView localProfileCardFavorShowView = a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
            localProfileCardFavorShowView.setTitle(localauvl.jdField_a_of_type_JavaLangString);
            i4 = 0;
            if (i4 < localauvl.jdField_a_of_type_JavaUtilArrayList.size())
            {
              auvm localauvm = (auvm)localauvl.jdField_a_of_type_JavaUtilArrayList.get(i4);
              ProfileCardFavorItemDetailView localProfileCardFavorItemDetailView = new ProfileCardFavorItemDetailView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
              localProfileCardFavorItemDetailView.setTitle(localauvm.jdField_a_of_type_JavaLangString);
              localProfileCardFavorItemDetailView.setContent(localauvm.jdField_d_of_type_JavaLangString);
              localProfileCardFavorItemDetailView.setDesc(localauvm.e);
              Drawable localDrawable = getResources().getDrawable(2131166226);
              paramCard = localDrawable;
              if (!TextUtils.isEmpty(localauvm.jdField_b_of_type_JavaLangString))
              {
                paramCard = URLDrawable.URLDrawableOptions.obtain();
                paramCard.mLoadingDrawable = localDrawable;
                paramCard.mRequestWidth = actn.a(70.0F, getResources());
                paramCard.mRequestHeight = actn.a(70.0F, getResources());
                paramCard = URLDrawable.getDrawable(localauvm.jdField_b_of_type_JavaLangString, paramCard);
              }
              localProfileCardFavorItemDetailView.setIcon(paramCard);
              if (!TextUtils.isEmpty(localauvm.f)) {
                localProfileCardFavorItemDetailView.a(localauvm.f, 2);
              }
              if ((localauvm.jdField_a_of_type_JavaUtilArrayList != null) && (localauvm.jdField_a_of_type_JavaUtilArrayList.size() > 0))
              {
                int i5 = 0;
                while (i5 < localauvm.jdField_a_of_type_JavaUtilArrayList.size())
                {
                  paramCard = (auvk)localauvm.jdField_a_of_type_JavaUtilArrayList.get(i5);
                  localProfileCardFavorItemDetailView.a(null, paramCard.jdField_a_of_type_JavaLangString, Color.rgb((int)paramCard.b.a, (int)paramCard.b.b, (int)paramCard.b.c), 3);
                  i5 += 1;
                }
              }
              label527:
              boolean bool;
              if (i1 != 0)
              {
                a("map_key_favor", localProfileCardFavorItemDetailView.b, localProfileCardFavorItemDetailView.jdField_a_of_type_AndroidWidgetTextView, null);
                a("map_key_favor", localProfileCardFavorItemDetailView.c, null, null);
                auvd.a(localProfileCardFavorItemDetailView, "background", this.jdField_a_of_type_Auvd, "commonItemTopBorderBackground");
                localProfileCardFavorItemDetailView.setTag(new ausu(62, localauvm));
                localProfileCardFavorItemDetailView.setOnClickListener(this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnClickListener);
                localProfileCardFavorShowView.addView(localProfileCardFavorItemDetailView);
                if (i4 == 0) {
                  break label628;
                }
                bool = true;
                label570:
                localProfileCardFavorItemDetailView.setNeedTopMargin(bool);
                switch (localauvm.jdField_a_of_type_Int)
                {
                }
              }
              for (;;)
              {
                i4 += 1;
                break;
                localProfileCardFavorItemDetailView.setBackgroundResource(2130839171);
                break label527;
                label628:
                bool = false;
                break label570;
                if (localauvm.jdField_b_of_type_Int == 0)
                {
                  if (!this.i)
                  {
                    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070B1", "0X80070B1", 0, 0, "", "", "", "");
                    this.i = true;
                  }
                }
                else if (!this.j)
                {
                  axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070AD", "0X80070AD", 0, 0, "", "", "", "");
                  this.j = true;
                  continue;
                  if (!this.k)
                  {
                    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070A9", "0X80070A9", 0, 0, "", "", "", "");
                    this.k = true;
                  }
                }
              }
            }
            a("map_key_favor", null, localProfileCardFavorShowView.jdField_a_of_type_AndroidWidgetTextView, localProfileCardFavorShowView.jdField_a_of_type_AndroidWidgetImageView);
            paramCard = new ausu(61, localauvl);
            localProfileCardFavorShowView.b.setTag(paramCard);
            localProfileCardFavorShowView.b.setOnClickListener(this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramLinearLayout.addView(localProfileCardFavorShowView);
            i4 = i3 + 1;
          }
        }
      }
      label863:
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Int = i3;
    }
  }
  
  private void a(Card paramCard, ProfileCardFavorShowView paramProfileCardFavorShowView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCardMoreInfoView", 2, "fillUpExtendFriendInfo");
    }
    boolean bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i2;
    Object localObject;
    int i1;
    if (this.jdField_a_of_type_Auuw.jdField_a_of_type_Auvd != null)
    {
      i2 = 1;
      localObject = paramProfileCardFavorShowView.a(0);
      if (localObject == null) {
        break label469;
      }
      if (i2 == 0) {
        break label345;
      }
      auvd localauvd = (auvd)((View)localObject).getTag(2131371971);
      if ((localauvd != null) && (localauvd.equals(this.jdField_a_of_type_Auuw.jdField_a_of_type_Auvd))) {
        break label469;
      }
      i1 = 1;
    }
    for (;;)
    {
      label89:
      boolean bool1;
      if ((localObject == null) || (!Boolean.FALSE.equals(((View)localObject).getTag(2131371972))) || (!new Boolean(bool2).equals(((View)localObject).getTag(2131371973))) || (i1 != 0))
      {
        paramProfileCardFavorShowView.removeAllViews();
        paramProfileCardFavorShowView.setFocusable(false);
        paramProfileCardFavorShowView.setClickable(false);
        if (i2 == 0) {
          break label463;
        }
        localObject = this.jdField_a_of_type_Auvd.a.get("commonItemContentColor");
        if (localObject == null) {
          break label458;
        }
        if ((localObject instanceof ColorStateList))
        {
          i1 = ((ColorStateList)localObject).getDefaultColor();
          label194:
          localObject = new float[3];
          Color.colorToHSV(i1, (float[])localObject);
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
          if ((this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 96) || (this.jdField_e_of_type_Boolean)) {
            ((ProfileCardExtendFriendView)localObject).setFold(false);
          }
          ((ProfileCardExtendFriendView)localObject).setClickable(true);
          ((ProfileCardExtendFriendView)localObject).setTag(2131371972, Boolean.valueOf(false));
          ((ProfileCardExtendFriendView)localObject).setTag(2131371973, Boolean.valueOf(bool2));
          ((ProfileCardExtendFriendView)localObject).setTag(2131371971, this.jdField_a_of_type_Auuw.jdField_a_of_type_Auvd);
          paramProfileCardFavorShowView.addView((View)localObject);
        }
        for (;;)
        {
          ((ProfileCardExtendFriendView)localObject).setIsFromLimitChat(this.f);
          ((ProfileCardExtendFriendView)localObject).a(paramCard, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
          i2 = 0;
          break;
          label345:
          if (((View)localObject).getTag(2131371971) == null) {
            break label469;
          }
          i1 = 1;
          break label89;
          if (!(localObject instanceof String)) {
            break label458;
          }
          localObject = (String)localObject;
          if (!((String)localObject).startsWith("#")) {
            break label458;
          }
          i1 = Color.parseColor((String)localObject);
          break label194;
          label396:
          bool1 = false;
          break label219;
          if (i2 != 0)
          {
            localObject = new ProfileCardExtendFriendView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Auuw.jdField_a_of_type_Auvd, bool1);
            break label239;
          }
          localObject = new ProfileCardExtendFriendView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          break label239;
          localObject = (ProfileCardExtendFriendView)localObject;
        }
        label458:
        i1 = 0;
        break label194;
        label463:
        bool1 = false;
      }
      label469:
      i1 = 0;
    }
  }
  
  private void a(MiniAppProfileCardGuestView paramMiniAppProfileCardGuestView)
  {
    Object localObject = this.jdField_a_of_type_Auvd.a.get("commonItemContentColor");
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
    Object localObject = this.jdField_a_of_type_Auvd.a.get("commonItemContentColor");
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
    //   1: ldc 118
    //   3: aconst_null
    //   4: aload_2
    //   5: getfield 732	com/tencent/mobileqq/widget/ProfileCardFavorShowView:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   8: aconst_null
    //   9: invokevirtual 264	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:a	(Ljava/lang/String;Landroid/widget/TextView;Landroid/view/View;Landroid/widget/ImageView;)V
    //   12: aload_0
    //   13: getfield 701	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Auvd	Lauvd;
    //   16: ifnull +276 -> 292
    //   19: aload_0
    //   20: getfield 701	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Auvd	Lauvd;
    //   23: getfield 779	auvd:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   26: ifnull +266 -> 292
    //   29: aload_0
    //   30: getfield 701	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Auvd	Lauvd;
    //   33: getfield 779	auvd:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   36: invokevirtual 850	java/util/concurrent/ConcurrentHashMap:size	()I
    //   39: ifle +253 -> 292
    //   42: aload_0
    //   43: getfield 73	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   46: ldc 118
    //   48: aload_0
    //   49: getfield 701	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Auvd	Lauvd;
    //   52: getfield 853	auvd:o	J
    //   55: invokestatic 856	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   58: invokevirtual 860	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: pop
    //   62: aload_0
    //   63: getfield 701	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Auvd	Lauvd;
    //   66: getfield 779	auvd:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   69: ldc_w 781
    //   72: invokevirtual 786	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: astore 8
    //   77: aload 8
    //   79: ifnull +359 -> 438
    //   82: aload 8
    //   84: instanceof 788
    //   87: ifeq +167 -> 254
    //   90: aload 8
    //   92: checkcast 788	android/content/res/ColorStateList
    //   95: astore 8
    //   97: aload_1
    //   98: getfield 865	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   101: ifnull +330 -> 431
    //   104: aload_1
    //   105: getfield 865	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   108: invokevirtual 869	com/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView:a	()I
    //   111: istore_3
    //   112: aload_0
    //   113: getfield 415	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   116: ifnull +259 -> 375
    //   119: aload_0
    //   120: getfield 415	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   123: instanceof 580
    //   126: ifne +249 -> 375
    //   129: iconst_1
    //   130: istore 4
    //   132: iload 4
    //   134: ifeq +8 -> 142
    //   137: aload_2
    //   138: iconst_1
    //   139: invokevirtual 776	com/tencent/mobileqq/widget/ProfileCardFavorShowView:setClickable	(Z)V
    //   142: aload_0
    //   143: getfield 472	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   146: invokestatic 752	com/tencent/mobileqq/theme/ThemeUtil:isInNightMode	(Lmqq/app/AppRuntime;)Z
    //   149: istore 7
    //   151: aload_0
    //   152: getfield 251	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Auuw	Lauuw;
    //   155: getfield 753	auuw:jdField_a_of_type_Auvd	Lauvd;
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
    //   180: invokevirtual 872	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:setIsNormalTheme	(Z)V
    //   183: aload_1
    //   184: getfield 865	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   187: ifnull +30 -> 217
    //   190: iload 4
    //   192: ifeq +201 -> 393
    //   195: aload_1
    //   196: getfield 865	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   199: aconst_null
    //   200: invokevirtual 875	com/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   203: aload 8
    //   205: ifnull +201 -> 406
    //   208: aload_1
    //   209: getfield 865	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   212: aload 8
    //   214: invokevirtual 876	com/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView:setTextColor	(Landroid/content/res/ColorStateList;)V
    //   217: iload 7
    //   219: ifeq +23 -> 242
    //   222: iload 4
    //   224: ifeq +18 -> 242
    //   227: aload_0
    //   228: ldc 118
    //   230: aload_1
    //   231: getfield 877	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   234: aload_1
    //   235: getfield 880	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   238: aconst_null
    //   239: invokevirtual 264	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:a	(Ljava/lang/String;Landroid/widget/TextView;Landroid/view/View;Landroid/widget/ImageView;)V
    //   242: aload 8
    //   244: ifnull +173 -> 417
    //   247: aload_1
    //   248: aload 8
    //   250: invokevirtual 883	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:setTextColors	(Landroid/content/res/ColorStateList;)V
    //   253: return
    //   254: aload 8
    //   256: instanceof 82
    //   259: ifeq +179 -> 438
    //   262: aload 8
    //   264: checkcast 82	java/lang/String
    //   267: astore 8
    //   269: aload 8
    //   271: ldc_w 823
    //   274: invokevirtual 827	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   277: ifeq +161 -> 438
    //   280: aload 8
    //   282: invokestatic 831	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   285: pop
    //   286: aconst_null
    //   287: astore 8
    //   289: goto -192 -> 97
    //   292: aload_0
    //   293: getfield 73	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   296: ldc 118
    //   298: iconst_0
    //   299: invokestatic 485	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   302: invokevirtual 860	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   305: pop
    //   306: aload_0
    //   307: invokevirtual 627	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:getResources	()Landroid/content/res/Resources;
    //   310: ldc_w 884
    //   313: invokevirtual 888	android/content/res/Resources:getColorStateList	(I)Landroid/content/res/ColorStateList;
    //   316: astore 8
    //   318: goto -221 -> 97
    //   321: astore 9
    //   323: aconst_null
    //   324: astore 8
    //   326: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq +34 -> 363
    //   332: ldc_w 890
    //   335: iconst_2
    //   336: new 182	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   343: ldc_w 892
    //   346: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload 9
    //   351: invokevirtual 895	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   354: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 204	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: aload 9
    //   365: invokevirtual 898	java/lang/Exception:printStackTrace	()V
    //   368: ldc_w 899
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
    //   394: getfield 865	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   397: ldc_w 716
    //   400: invokevirtual 900	com/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView:setBackgroundResource	(I)V
    //   403: goto -200 -> 203
    //   406: aload_1
    //   407: getfield 865	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   410: iload_3
    //   411: invokevirtual 901	com/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView:setTextColor	(I)V
    //   414: goto -197 -> 217
    //   417: aload_1
    //   418: iload_3
    //   419: invokestatic 903	android/content/res/ColorStateList:valueOf	(I)Landroid/content/res/ColorStateList;
    //   422: invokevirtual 883	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelBoard:setTextColors	(Landroid/content/res/ColorStateList;)V
    //   425: return
    //   426: astore 9
    //   428: goto -102 -> 326
    //   431: ldc_w 899
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
    //   111	324	3	i1	int
    //   130	247	4	i2	int
    //   162	221	5	i3	int
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
    if (this.jdField_a_of_type_Baxk != null)
    {
      Bitmap localBitmap = this.jdField_a_of_type_Baxk.a(1, paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        localObject = localBitmap;
        if (!this.jdField_a_of_type_Baxk.a())
        {
          this.jdField_a_of_type_Baxk.a(paramString, 1, true);
          this.jdField_a_of_type_JavaUtilMap.put(paramString, paramCircleBoarderImageView);
          localObject = localBitmap;
        }
      }
    }
    paramString = localObject;
    if (localObject == null) {
      paramString = bbdr.a();
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
      int i1 = 0;
      while (i1 < paramList.size())
      {
        a(paramStringBuilder, (PrivilegeInfo)paramList.get(i1));
        i1 += 1;
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
    int i1;
    Object localObject;
    int i2;
    label162:
    label192:
    LinearLayout localLinearLayout;
    LinearLayout.LayoutParams localLayoutParams1;
    LinearLayout.LayoutParams localLayoutParams2;
    int[] arrayOfInt;
    int i3;
    label385:
    do
    {
      return;
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      i1 = 0;
      if (i1 < paramList.size())
      {
        localObject = (PrivilegeInfo)paramList.get(i1);
        if (((PrivilegeInfo)localObject).iIsBig == 1)
        {
          i2 = 1;
          if (i2 == 0) {
            break label192;
          }
          localArrayList1.add(localObject);
        }
        for (;;)
        {
          i1 += 1;
          break;
          i2 = 0;
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
      i1 = 1;
      if (i1 == 0) {
        break label500;
      }
      arrayOfInt[0] = ((int)(this.jdField_e_of_type_Float - f3));
      i3 = a(localArrayList1, localLinearLayout, (int)f3, arrayOfInt, (int)f8, (int)f8, paramList, paramBoolean);
      if (i3 > 0) {
        arrayOfInt[0] -= (int)f5;
      }
      if (i3 <= 0) {
        break label492;
      }
      i2 = (int)f6;
      i2 = a(localArrayList2, (LinearLayout)localObject, i2, arrayOfInt, (int)f1, (int)f2, paramList, paramBoolean);
      paramLinearLayout.setOrientation(0);
      if (i3 > 0) {
        paramLinearLayout.addView(localLinearLayout);
      }
    } while (i2 <= 0);
    if (i3 > 0)
    {
      if (i1 != 0) {
        localLayoutParams1.leftMargin = ((int)f5);
      }
    }
    else
    {
      label446:
      if (i1 == 0) {
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
      i1 = 0;
      break;
      label492:
      i2 = (int)f4;
      break label385;
      label500:
      arrayOfInt[0] = ((int)(this.jdField_e_of_type_Float - f3));
      i3 = a(localArrayList1, localLinearLayout, 0, arrayOfInt, (int)f8, (int)f8, paramList, paramBoolean);
      arrayOfInt[0] = ((int)(this.jdField_e_of_type_Float - f6 - f3));
      if (i3 > 0) {}
      for (i2 = (int)(16.0F * f7);; i2 = (int)f4)
      {
        i2 = a(localArrayList2, (LinearLayout)localObject, i2, arrayOfInt, (int)f1, (int)f2, paramList, paramBoolean);
        paramLinearLayout.setOrientation(1);
        break;
      }
      localLayoutParams1.leftMargin = ((int)f6);
      break label446;
      label611:
      localLayoutParams1.topMargin = ((int)f3);
    }
  }
  
  private boolean a(int paramInt, View paramView)
  {
    int i2 = 1;
    Object localObject1 = this.jdField_c_of_type_ArrayOfJavaLangString;
    int i3 = localObject1.length;
    int i1 = 0;
    Object localObject2;
    if (i1 < i3)
    {
      localObject2 = localObject1[i1];
      if (paramView != this.jdField_a_of_type_JavaUtilHashMap.get(localObject2)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (axmt.a()) {
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
            paramInt = i2;
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
          paramView.setBackgroundResource(2130849011);
          addView(paramView);
          return bool;
          i1 += 1;
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
    return localRect.intersect(new Rect(0, 0, bbkx.a(), bbkx.b()));
  }
  
  private boolean a(RichStatus paramRichStatus)
  {
    if ((this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && ((!ProfileActivity.AllInOne.g(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramRichStatus == null) || (Arrays.equals(paramRichStatus.encode(), RichStatus.getEmptyStatus().encode())))) {
      return this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_sig") != null;
    }
    boolean bool1;
    Resources localResources;
    int i1;
    int i2;
    label109:
    Object localObject1;
    if (this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      bool1 = true;
      localResources = getResources();
      if (!b()) {
        break label183;
      }
      i1 = localResources.getColor(2131166854);
      i2 = localResources.getColor(2131166854);
      localObject1 = null;
      if (paramRichStatus != null) {
        localObject1 = new SpannableString(paramRichStatus.toSpannableStringWithTopic(null, i1, i2, this));
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
          i2 = localResources.getColor(2131165275);
          i1 = -8947849;
          break label109;
        }
        return false;
      }
      Object localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sig");
      if (localObject2 == null)
      {
        localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561008, null);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sig", localObject2);
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        View localView = ((View)localObject2).findViewById(2131373084);
        TextView localTextView = (TextView)((View)localObject2).findViewById(2131368086);
        LinearLayout localLinearLayout = (LinearLayout)((View)localObject2).findViewById(2131369447);
        ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131362792);
        aweo localaweo = (aweo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
        localTextView.setTextColor(i1);
        Object localObject3;
        label476:
        label638:
        boolean bool3;
        if ((paramRichStatus != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
        {
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject1);
          localSpannableStringBuilder.insert(0, "[S] ");
          if (localaweo != null)
          {
            localObject3 = localaweo.a(paramRichStatus.actionId, 200);
            localObject3 = new bcrj(localResources, (Bitmap)localObject3, false, false);
            i1 = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
            ((BitmapDrawable)localObject3).setBounds(0, 0, i1, i1);
            localObject3 = new bcni((Drawable)localObject3, 0);
            ((bcni)localObject3).a(-0.1F);
            localSpannableStringBuilder.setSpan(localObject3, 0, "[S]".length(), 17);
            this.jdField_c_of_type_Int = i1;
            localTextView.setText(new ayki(localSpannableStringBuilder, 1, 20));
            localTextView.setMovementMethod(LinkMovementMethod.getInstance());
            if (((SpannableString)localObject1).length() != 0)
            {
              if ((paramRichStatus != null) && (paramRichStatus.topics != null) && (paramRichStatus.topics.size() > 0))
              {
                if (this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
                  break label1128;
                }
                i1 = 1;
                axqw.b(null, "dc00898", "", "", "0X800A4D2", "0X800A4D2", i1, 0, "0" + i1, "0", "", "");
              }
              if ((!auvq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (paramRichStatus != null) && (paramRichStatus.topics != null) && (paramRichStatus.topics.size() > 0) && (!this.jdField_e_of_type_Boolean))
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
                i1 = ((Integer)((Pair)paramRichStatus.topicsPos.get(0)).second).intValue();
                label690:
                this.jdField_b_of_type_Int = i1;
                if (!a(localTextView)) {
                  break label1144;
                }
                localTextView.post(new ProfileCardMoreInfoView.7(this, localTextView, paramRichStatus));
              }
              label720:
              auvq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRichStatus);
              bool3 = auvq.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              localObject2 = (ImageView)((View)localObject2).findViewById(2131377455);
              localObject1 = new oidb_0xd9f.RspBody();
              if ((this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo == null)) {
                break label1235;
              }
            }
          }
        }
        try
        {
          ((oidb_0xd9f.RspBody)localObject1).mergeFrom(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo);
          localObject1 = (oidb_0xd9f.LongNickItem)((oidb_0xd9f.RspBody)localObject1).longnick_item.get();
          if (localObject1 == null) {
            break label1184;
          }
          localObject1 = ((oidb_0xd9f.LongNickItem)localObject1).rpt_topic_item.get();
          label832:
          if ((!bool3) && (!auvq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, auvq.a().a((List)localObject1)))) {
            break label1224;
          }
          if ((localObject1 == null) || (((List)localObject1).size() <= 0) || (auvq.a().a((List)localObject1) <= 0)) {
            break label1190;
          }
          localLinearLayout.setTag(new ausu(97, auvq.a().a((List)localObject1)));
          localLinearLayout.setOnClickListener(this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnClickListener);
          a(localLinearLayout, (List)localObject1);
          ((ImageView)localObject2).setOnTouchListener(muf.a);
          ((ImageView)localObject2).setOnClickListener(new bcor(this, localLinearLayout));
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
            i1 = 0;
            label1005:
            if (i1 < paramRichStatus.topics.size())
            {
              if (TextUtils.isEmpty((CharSequence)((Pair)paramRichStatus.topics.get(i1)).second)) {}
              for (;;)
              {
                i1 += 1;
                break label1005;
                localObject3 = bawu.a(localResources, 2130848533);
                break;
                this.jdField_c_of_type_Int = 0;
                if ((((SpannableString)localObject1).length() == 0) && (bool1))
                {
                  localTextView.setText(2131699388);
                  a(localLinearLayout, bool1);
                  break label476;
                }
                localTextView.setText(new ayki((CharSequence)localObject1, 1, 20));
                localTextView.setMovementMethod(LinkMovementMethod.getInstance());
                break label476;
                i1 = 2;
                break label522;
                localObject1 = null;
                break label638;
                label1139:
                i1 = 0;
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
                localException.append((String)((Pair)paramRichStatus.topics.get(i1)).second);
              }
            }
          }
          label1190:
          label1224:
          label1235:
          if (paramRichStatus.plainText != null) {}
          for (i1 = paramRichStatus.plainText.size();; i1 = 0)
          {
            i2 = 0;
            while (i2 < i1)
            {
              localObject2 = (String)paramRichStatus.plainText.get(i2);
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                localException.append((String)localObject2);
              }
              i2 += 1;
            }
          }
        }
        localView.setContentDescription(ajyc.a(2131708479) + localException);
        if ((paramRichStatus != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
        {
          this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
          if ((this.jdField_a_of_type_Bcot == null) && (localaweo != null))
          {
            this.jdField_a_of_type_Bcot = new bcot(this);
            localaweo.a(this.jdField_a_of_type_Bcot);
          }
          localView.setTag(new ausu(3, localException));
          if ((this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || ((this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))) {
            break label1545;
          }
          localImageView.setVisibility(0);
          localView.setOnClickListener(this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnClickListener);
          label1490:
          if (!bool1) {
            break label1554;
          }
          a("map_key_sig", null, null, localImageView);
        }
        for (;;)
        {
          return bool2;
          this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
          if ((this.jdField_a_of_type_Bcot == null) || (localaweo == null)) {
            break;
          }
          localaweo.b(this.jdField_a_of_type_Bcot);
          this.jdField_a_of_type_Bcot = null;
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
    int i3 = 0;
    Object localObject1 = this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    if ((ProfileActivity.AllInOne.i(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80)) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((localObject1 == null) || (paramArrayList == null) || (paramArrayList.isEmpty())) {
        i1 = 0;
      }
      if (i1 == 0) {
        return this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_phone") != null;
      }
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_phone");
      if (localViewGroup == null)
      {
        localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560993, null);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_phone", localViewGroup);
      }
      for (boolean bool = true;; bool = false)
      {
        if (this.jdField_a_of_type_Auuw.jdField_a_of_type_Bavg.a != null) {
          this.jdField_a_of_type_Auuw.jdField_a_of_type_Bavg.a.clear();
        }
        Object localObject2;
        label223:
        int i2;
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)))
        {
          i1 = 1;
          localViewGroup.removeAllViews();
          localObject2 = a(localViewGroup, 2130844922, ((ContactCard)localObject1).nickName, 1);
          if (localObject2 != null)
          {
            if (i1 == 0) {
              break label413;
            }
            auvd.a((View)localObject2, "background", this.jdField_a_of_type_Auvd, "commonItemTopBorderBackground");
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext;
          int i4 = ((ContactCard)localObject1).bSex;
          if (!bazo.b()) {
            break label424;
          }
          i2 = 0;
          label244:
          localObject1 = a(localViewGroup, 2130844931, bazo.a((Context)localObject2, i4, i2, ((ContactCard)localObject1).strCountry, ((ContactCard)localObject1).strProvince, ((ContactCard)localObject1).strCity), 1);
          if (localObject1 != null)
          {
            if (i1 == 0) {
              break label433;
            }
            auvd.a((View)localObject1, "background", this.jdField_a_of_type_Auvd, "commonItemTopBorderBackground");
          }
          label303:
          i4 = paramArrayList.size();
          i2 = i3;
          label312:
          if (i2 >= i4) {
            break label455;
          }
          localObject1 = (ProfileActivity.CardContactInfo)paramArrayList.get(i2);
          localObject2 = a(localViewGroup, (ProfileActivity.CardContactInfo)localObject1);
          if (localObject2 != null)
          {
            if (i1 == 0) {
              break label444;
            }
            auvd.a((View)localObject2, "background", this.jdField_a_of_type_Auvd, "commonItemTopBorderBackground");
          }
        }
        for (;;)
        {
          ((ViewGroup)localObject2).setTag(new ausu(4, localObject1));
          ((ViewGroup)localObject2).setOnClickListener(this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((ViewGroup)localObject2).setOnLongClickListener(this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          i2 += 1;
          break label312;
          i1 = 0;
          break;
          label413:
          ((ViewGroup)localObject2).setBackgroundResource(2130839172);
          break label223;
          label424:
          i2 = ((ContactCard)localObject1).bAge;
          break label244;
          label433:
          ((ViewGroup)localObject1).setBackgroundResource(2130839172);
          break label303;
          label444:
          ((ViewGroup)localObject2).setBackgroundResource(2130839171);
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
    int i2 = 0;
    ArrayList localArrayList = new ArrayList();
    int i1;
    Object localObject;
    if ((paramHashMap == null) || (paramArrayOfString == null))
    {
      i1 = 0;
      if (i2 >= i1) {
        break label136;
      }
      localObject = paramArrayOfString[i2];
      if ((!"map_key_sig".equals(localObject)) || (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap == null) || (!this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.containsKey("map_key_sign"))) {
        break label92;
      }
    }
    for (;;)
    {
      i2 += 1;
      break;
      i1 = paramArrayOfString.length;
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
  
  private static void b(View paramView, auuw paramauuw)
  {
    paramView.setVisibility(0);
    Context localContext = paramView.getContext();
    TextView localTextView = (TextView)paramView.findViewById(2131368342);
    ImageView localImageView = (ImageView)paramView.findViewById(2131362792);
    if (!TextUtils.isEmpty(paramauuw.jdField_b_of_type_JavaLangString))
    {
      localTextView.setText(paramauuw.jdField_b_of_type_JavaLangString);
      localTextView.setContentDescription(paramauuw.jdField_b_of_type_JavaLangString);
      localImageView.setVisibility(0);
      paramView.setOnClickListener(paramauuw.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    localTextView.setText(localContext.getString(2131697826));
    localTextView.setContentDescription(localContext.getString(2131697826));
    localImageView.setVisibility(0);
    paramView.setOnClickListener(paramauuw.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void b(boolean paramBoolean)
  {
    int i1 = 2;
    if (this.m) {
      return;
    }
    String str2;
    String str1;
    if (paramBoolean)
    {
      str2 = "0X80092DA";
      str1 = str2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqDataCard.declaration))
      {
        i1 = 1;
        str1 = str2;
      }
    }
    for (;;)
    {
      this.m = true;
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str1, str1, i1, 0, "", "", "", "");
      return;
      str2 = "0X80092E1";
      str1 = str2;
      if (this.jdField_e_of_type_Boolean)
      {
        i1 = 1;
        str1 = str2;
      }
    }
  }
  
  private boolean b(View paramView)
  {
    int[] arrayOfInt = new int[2];
    int i1 = getResources().getDisplayMetrics().heightPixels;
    paramView.getLocationInWindow(arrayOfInt);
    int i2 = arrayOfInt[1];
    return ((FriendProfileCardActivity)this.jdField_a_of_type_AndroidContentContext).findViewById(2131371975).getHeight() + i2 < i1;
  }
  
  private boolean b(Card paramCard)
  {
    boolean bool5 = false;
    boolean bool7 = a(this.jdField_a_of_type_Auuw);
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
            break label705;
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
            if (!ProfileActivity.AllInOne.a(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
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
          paramCard = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561011, null);
          this.jdField_a_of_type_JavaUtilHashMap.put("map_key_account_level_info", paramCard);
          paramCard.setClickable(false);
          int i1 = akjo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C6", "0X800A8C6", i1, 0, String.valueOf(i1), "", "", "");
          if (this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C7", "0X800A8C7", i1, 0, String.valueOf(i1), "", "", "");
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          ImageView localImageView = (ImageView)paramCard.findViewById(2131362792);
          ProfileQQLevelView localProfileQQLevelView = (ProfileQQLevelView)paramCard.findViewById(2131373050);
          localProfileQQLevelView.a(this.jdField_a_of_type_Auuw, this.jdField_a_of_type_Boolean);
          View localView = localProfileQQLevelView.findViewById(2131369847);
          if (bool7)
          {
            b(this.jdField_a_of_type_Auuw, localView);
            this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal", localView);
            localView.setBackgroundResource(2130844940);
            localView.setTag(new ausu(91, null));
            localView.setOnClickListener(this.jdField_a_of_type_Bcpe);
            localProfileQQLevelView.setClickable(false);
            paramCard.setTag(new ausu(69, null));
            paramCard.setOnClickListener(this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramCard = (FrameLayout)localProfileQQLevelView.findViewById(2131364896);
            if (paramCard != null)
            {
              paramCard.setOnClickListener(this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnClickListener);
              paramCard.setTag(new ausu(100, null));
              if (!this.n) {
                break label671;
              }
              paramCard.setVisibility(0);
            }
          }
          for (;;)
          {
            QLog.d("ProfileCardMoreInfoView", 2, " update makeOrRefreshAccountLevelInfoView ALLOW" + this.n);
            a("map_key_account_level_info", null, null, localImageView);
            return bool1;
            localView.setVisibility(8);
            localView.setBackgroundResource(0);
            localView.setTag(null);
            localView.setOnClickListener(null);
            break;
            label671:
            paramCard.setVisibility(8);
          }
        }
      }
      bool3 = bool1;
      bool1 = false;
      bool5 = bool2;
      bool2 = bool3;
      bool3 = bool6;
      continue;
      label705:
      bool1 = false;
      bool2 = false;
      bool3 = false;
      bool4 = false;
    }
  }
  
  private boolean b(Card paramCard, boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_Auuw.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null) || (this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo.gameName)))
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
      paramCard = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560989, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_troop_mem_game_info", paramCard);
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      Object localObject2 = (TextView)paramCard.findViewById(2131366923);
      TextView localTextView1 = (TextView)paramCard.findViewById(2131366925);
      localTextView1.setBackgroundDrawable(bamn.a(getResources(), Color.parseColor("#3094cf")));
      Object localObject1 = (ImageView)paramCard.findViewById(2131374689);
      TextView localTextView2 = (TextView)paramCard.findViewById(2131366926);
      TextView localTextView3 = (TextView)paramCard.findViewById(2131366927);
      ImageView localImageView = (ImageView)paramCard.findViewById(2131362792);
      TroopMemberCard.MemberGameInfo localMemberGameInfo = this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo;
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
          int i1 = actn.a(18.0F, getResources());
          int i2 = actn.a(18.0F, getResources());
          if (!TextUtils.isEmpty(localMemberGameInfo.levelIcon))
          {
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i1;
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = i2;
            ((ImageView)localObject1).setImageDrawable(URLDrawable.getDrawable(localMemberGameInfo.levelIcon, (URLDrawable.URLDrawableOptions)localObject2));
          }
          if (!TextUtils.isEmpty(localMemberGameInfo.levelName))
          {
            localTextView1.setVisibility(0);
            localTextView1.setText(localMemberGameInfo.levelName);
            float f1 = actn.a(2.0F, getResources());
            i1 = actn.a(4.0F, getResources());
            localObject1 = new GradientDrawable();
            ((GradientDrawable)localObject1).setCornerRadius(f1);
            localTextView1.setPadding(i1, 0, i1, 0);
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
          bbbb.a("Grp_game", "Mber_data", "game_exp", 0, 0, new String[] { this.jdField_a_of_type_Auuw.jdField_a_of_type_JavaLangString, localMemberGameInfo.gameName });
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
          continue;
        }
        paramCard.setTag(new ausu(83, null));
        paramCard.setOnClickListener(this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramCard.setVisibility(0);
        a("map_key_troop_mem_game_info", null, null, localImageView);
        return paramBoolean;
        ((GradientDrawable)localObject1).setColor(Color.parseColor("#FFBA26"));
      }
    }
  }
  
  private boolean c(Card paramCard)
  {
    int i1 = 1;
    QLog.i("ProfileCardMoreInfoView", 2, "makeOrRefreshWeiShiFeedList");
    if (this.jdField_a_of_type_Xim == null) {
      return false;
    }
    if (!this.h) {
      return this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_mine_weishi") != null;
    }
    Object localObject;
    if ((View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_mine_weishi") == null)
    {
      localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559403, null);
      this.jdField_a_of_type_Xim.a((View)localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_mine_weishi", localObject);
    }
    for (boolean bool = true;; bool = false)
    {
      if (!b())
      {
        localObject = this.jdField_a_of_type_Xim.a();
        this.jdField_a_of_type_Xim.a();
        if ((i1 == 0) || (paramCard == null)) {
          break label176;
        }
        auvd.a((View)localObject, "color", this.jdField_a_of_type_Auvd, "commonItemContentColor");
      }
      for (;;)
      {
        this.jdField_a_of_type_Xim.b();
        a("map_key_mine_weishi", null, this.jdField_a_of_type_Xim.a(), this.jdField_a_of_type_Xim.a());
        return bool;
        i1 = 0;
        break;
        label176:
        ((TextView)localObject).setBackgroundResource(2130839171);
      }
    }
  }
  
  private boolean c(Card paramCard, boolean paramBoolean)
  {
    if ((paramCard != null) && (ProfileActivity.AllInOne.a(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if ((b()) || ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileQVipV5View))) {
        paramBoolean = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("makeOrRefreshAccountBaseInfoView bShowAccountInfo=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
      if (!paramBoolean) {
        return this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_account_base_info") != null;
      }
      Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_account_base_info");
      if (localObject1 == null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560979, null);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_account_base_info", localObject1);
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        localObject1 = (ViewGroup)localObject1;
        ViewGroup localViewGroup1 = (ViewGroup)((ViewGroup)localObject1).findViewById(2131361833);
        localViewGroup1.removeAllViews();
        ViewGroup localViewGroup2 = (ViewGroup)((ViewGroup)localObject1).findViewById(2131361836);
        TextView localTextView;
        label307:
        Object localObject2;
        if ((ProfileActivity.AllInOne.j(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (ProfileActivity.AllInOne.k(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
        {
          localObject1 = null;
          localObject1 = a(localViewGroup1, 2130844922, (String)localObject1, 0);
          if (localObject1 != null)
          {
            localTextView = (TextView)((ViewGroup)localObject1).findViewById(2131368086);
            if (localTextView != null)
            {
              if (!this.jdField_a_of_type_Auuw.jdField_b_of_type_Boolean) {
                break label596;
              }
              localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_Auuw.jdField_a_of_type_JavaLangString, paramCard.uin);
              if ((localObject1 == null) || (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick)) || (TextUtils.isEmpty(paramCard.strReMark))) {
                break label551;
              }
              localObject1 = paramCard.strNick;
              localObject2 = localObject1;
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                localObject2 = bbcl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramCard.uin, false);
              }
              if (!TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Auuw.jdField_a_of_type_JavaLangString)) {
                break label579;
              }
            }
          }
        }
        label406:
        label551:
        label579:
        for (localObject1 = localObject2;; localObject1 = a(localTextView, (String)localObject2, paramCard.uin))
        {
          localTextView.setText((CharSequence)localObject1);
          bazo.a(localTextView, paramCard.uin, (String)localObject2, this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          if (c())
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
            i2 = paramCard.shGender;
            if (!bazo.b()) {
              break label719;
            }
            i1 = 0;
            a(localViewGroup1, 2130844931, bazo.a((Context)localObject1, i2, i1, paramCard.constellation, paramCard.strCountry, paramCard.strProvince, paramCard.strCity), 1);
          }
          if ((TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Auuw.jdField_a_of_type_JavaLangString)) || (c())) {
            break label872;
          }
          i1 = localViewGroup1.getChildCount();
          int i2 = 0;
          while ((i1 < 4) && (i2 < 3)) {
            switch (i2)
            {
            default: 
              i1 = 0;
              localObject1 = null;
              a(localViewGroup1, i1, (String)localObject1, 1);
              i1 = localViewGroup1.getChildCount();
              i2 += 1;
            }
          }
          localObject1 = " ";
          break;
          if (TextUtils.isEmpty(paramCard.strReMark))
          {
            localObject1 = paramCard.strNick;
            break label307;
          }
          localObject1 = paramCard.strReMark;
          break label307;
        }
        label512:
        label517:
        label596:
        if ((this.jdField_a_of_type_Auuw.jdField_a_of_type_ArrayOfJavaLangString != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Auuw.jdField_a_of_type_ArrayOfJavaLangString[5])) && (!TextUtils.equals(this.jdField_a_of_type_Auuw.jdField_a_of_type_ArrayOfJavaLangString[5], paramCard.strNick))) {}
        for (int i1 = 1;; i1 = 0)
        {
          if ((!TextUtils.isEmpty(paramCard.strReMark)) || (i1 != 0))
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
          label719:
          i1 = paramCard.age;
          break label406;
          localObject1 = new StringBuilder();
          if (!TextUtils.isEmpty(paramCard.strCompany)) {
            ((StringBuilder)localObject1).append(paramCard.strCompany);
          }
          localObject2 = bazj.e(paramCard.iProfession);
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.equals((CharSequence)localObject2, bazj.d[14])))
          {
            if (((StringBuilder)localObject1).length() > 0) {
              ((StringBuilder)localObject1).append(" ");
            }
            ((StringBuilder)localObject1).append((String)localObject2);
          }
          localObject1 = ((StringBuilder)localObject1).toString();
          i1 = 2130844935;
          break label517;
          if (TextUtils.isEmpty(paramCard.strSchool)) {
            break label512;
          }
          localObject1 = paramCard.strSchool;
          i1 = 2130844939;
          break label517;
          if (TextUtils.isEmpty(paramCard.strHometownDesc)) {
            break label512;
          }
          localObject1 = paramCard.strHometownDesc;
          i1 = 2130844930;
          break label517;
          label872:
          localViewGroup2.setTag(new ausu(66, paramCard.uin));
          localViewGroup2.setOnClickListener(this.jdField_a_of_type_Bcpe);
          a("map_key_account_base_info", (TextView)localViewGroup2.findViewById(2131361837), (ImageView)localViewGroup2.findViewById(2131362792), null);
          return paramBoolean;
        }
      }
    }
  }
  
  private boolean d()
  {
    if (!this.jdField_a_of_type_Auuw.jdField_b_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_troop_mem_recent_said") != null;
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_troop_mem_recent_said");
    Object localObject;
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562544, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_troop_mem_recent_said", localView);
      localObject = (ImageView)localView.findViewById(2131367679);
      ((ImageView)localObject).setImageResource(2130844942);
      ((ImageView)localObject).clearColorFilter();
      ((ImageView)localObject).setColorFilter(10067634);
    }
    for (boolean bool = true;; bool = false)
    {
      localObject = (TextView)localView.findViewById(2131368342);
      ImageView localImageView = (ImageView)localView.findViewById(2131362792);
      localView.setTag(new ausu(78, null));
      localView.setOnClickListener(this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnClickListener);
      a("map_key_troop_mem_recent_said", null, (View)localObject, localImageView);
      if (!this.g)
      {
        this.g = ((TroopPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(119)).a("troop_member_card_plugin.apk", new bcoq(this));
        if (!this.g) {
          localView.setVisibility(8);
        }
      }
      for (;;)
      {
        a();
        return bool;
        b(localView, this.jdField_a_of_type_Auuw);
      }
    }
  }
  
  private boolean d(Card paramCard)
  {
    boolean bool1;
    boolean bool2;
    if ((!ProfileActivity.AllInOne.g(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramCard == null) || (this.jdField_a_of_type_Boolean))
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
    TextView localTextView1;
    ImageView localImageView1;
    label194:
    List localList;
    Object localObject1;
    int i4;
    int i1;
    int i2;
    int i5;
    int i6;
    label652:
    int i3;
    label655:
    String str;
    View localView3;
    ImageView localImageView2;
    View localView4;
    View localView2;
    View localView5;
    TextView localTextView2;
    if (localView1 == null)
    {
      localView1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561002, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzone", localView1);
      bool1 = true;
      localViewGroup = (ViewGroup)localView1.findViewById(2131368127);
      localObject3 = (ViewGroup)localView1.findViewById(2131368128);
      localTextView1 = (TextView)localView1.findViewById(2131377183);
      localImageView1 = (ImageView)localView1.findViewById(2131367815);
      localTextView1.setSingleLine(true);
      localTextView1.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      if ((paramCard.ulShowControl & 0x80) != 0)
      {
        bool2 = true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("makeOrRefreshQZone card.ulShowControl=%x hasLocked=%s", new Object[] { Integer.valueOf(paramCard.ulShowControl), Boolean.valueOf(bool2) }));
        }
        if ((bool2) || ((!paramCard.isShowPhoto()) && (!paramCard.hasFakeData)) || (!paramCard.hasGotPhotoUrl())) {
          break label1764;
        }
        localList = paramCard.getQZonePhotoList();
        if (this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
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
        localTextView1.setVisibility(8);
        if ((localList == null) || (localList.isEmpty())) {
          break label1469;
        }
        localObject1 = getResources();
        i4 = ((Resources)localObject1).getDimensionPixelSize(2131298154);
        i1 = ((Resources)localObject1).getDimensionPixelSize(2131297372);
        i2 = bbkx.b(30.0F);
        i5 = (int)(this.jdField_b_of_type_Float - i1 - i2);
        i1 = a(paramCard);
        i6 = (int)((i5 - (i1 - 1) * i4) * 1.0F) / i1;
        if (QLog.isColorLevel()) {
          QLog.e("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "makeOrRefreshQZone count:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(localList.size()), Integer.valueOf(i6), Integer.valueOf(i4), Integer.valueOf(i5) }));
        }
        if ((this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) || ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) & 0x4000) == 0)) {
          break label2083;
        }
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561005, null);
        if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          ((View)localObject1).setBackgroundColor(Color.parseColor("#77F5F6FA"));
        }
        localViewGroup.addView((View)localObject1);
        localObject3 = ((View)localObject1).getLayoutParams();
        if ((localObject3 instanceof LinearLayout.LayoutParams))
        {
          localObject3 = (LinearLayout.LayoutParams)localObject3;
          ((LinearLayout.LayoutParams)localObject3).width = i6;
          ((LinearLayout.LayoutParams)localObject3).height = i6;
          ((LinearLayout.LayoutParams)localObject3).rightMargin = i4;
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        }
        i1 = 0 + i6;
        ((View)localObject1).setOnClickListener(new bcoo(this));
        LpReportInfo_pf00064.allReport(699, 7);
        i3 = 0;
        if (i3 >= localList.size()) {
          break label1469;
        }
        PhotoInfo localPhotoInfo = (PhotoInfo)localList.get(i3);
        str = localPhotoInfo.strPicUrl;
        localView3 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561003, null);
        localImageView2 = (ImageView)localView3.findViewById(2131368130);
        localView4 = localView3.findViewById(2131368135);
        localView2 = localView3.findViewById(2131368129);
        localView5 = localView3.findViewById(2131368134);
        localTextView2 = (TextView)localView3.findViewById(2131368126);
        UnderlineTextView localUnderlineTextView = (UnderlineTextView)localView3.findViewById(2131368125);
        localUnderlineTextView.setEditableFactory(ayks.a);
        localObject3 = "";
        if (localPhotoInfo.mapEx == null) {
          break label2072;
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
        ((ViewGroup.LayoutParams)localObject1).width = i6;
        ((ViewGroup.LayoutParams)localObject1).height = i6;
        i2 = localUnderlineTextView.getLineHeight();
        if (i2 <= 0) {
          break label965;
        }
        localUnderlineTextView.setMaxLines(b(paramCard));
        label928:
        i2 = 1;
      }
    }
    for (;;)
    {
      if (i2 == 0)
      {
        QLog.w("ProfileCardMoreInfoView", 1, "makeOrRefreshQZone: needUpdateUI=false,skip this one");
        label943:
        i3 += 1;
        break label655;
        bool2 = false;
        break label194;
        label958:
        paramCard.hasFakeData = false;
        return true;
        label965:
        QLog.w("ProfileCardMoreInfoView", 1, "makeOrRefreshQZone: invalid lineHeight:" + i2);
        break label928;
        label994:
        if (TextUtils.isEmpty(str)) {
          break label2067;
        }
        if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          localImageView2.setColorFilter(1996488704);
        }
        if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(getResources().getColor(2131165638));
        }
        for (;;)
        {
          try
          {
            localObject1 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i6;
            ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i6;
            if ((str.startsWith("http://")) || (str.startsWith("https://")))
            {
              localImageView2.setImageDrawable(URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions)localObject1));
              if ((!str.contains("video=1")) && (!bool2)) {
                break label1255;
              }
              localView4.setVisibility(0);
              if (((PhotoInfo)localList.get(i3)).IsOnlySelf != 1) {
                break label1265;
              }
              localView5.setVisibility(0);
              break label2094;
            }
            if (!bool2) {
              break label1240;
            }
            localObject1 = ShortVideoUtils.a(this.jdField_a_of_type_AndroidContentContext, str, i6, 0L);
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
            i2 = 1;
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
        break label2094;
      }
      localViewGroup.addView(localView3);
      Object localObject2 = localView3.getLayoutParams();
      if ((localObject2 instanceof LinearLayout.LayoutParams))
      {
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        ((LinearLayout.LayoutParams)localObject2).rightMargin = i4;
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
          break label1730;
        }
        ((ViewGroup.LayoutParams)localObject2).width = -1;
        ((ViewGroup.LayoutParams)localObject2).height = -1;
        label1377:
        localView2.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        i2 = i1;
        if (i1 > 0) {
          i2 = i1 + i4;
        }
        i1 = i2 + i6;
        if (i1 + i6 + i4 <= i5) {
          break label1747;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "makeOrRefreshQZone cur:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(i6), Integer.valueOf(i4), Integer.valueOf(i5) }));
        }
        label1469:
        if (!TextUtils.isEmpty(paramCard.strQzoneHeader))
        {
          localTextView1.setVisibility(0);
          localTextView1.setText(paramCard.strQzoneHeader);
        }
        if (this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          localTextView1.setText(ajyc.a(2131708439));
        }
        label1518:
        if (localTextView1.getText() != null) {
          break label2042;
        }
        localObject2 = "";
        label1531:
        if ((!((String)localObject2).contains(ajyc.a(2131708474))) || (!((String)localObject2).endsWith(ajyc.a(2131708435)))) {
          break label2055;
        }
        localTextView1.setCompoundDrawablePadding((int)(3.0F * this.jdField_a_of_type_Float));
        localTextView1.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130841728, 0);
      }
      for (;;)
      {
        localView1.setTag(new ausu(5, null));
        localView1.setOnClickListener(this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView1.setContentDescription(a(2131691203));
        a("map_key_qzone", null, localTextView1, localImageView1);
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ProfileCardMoreInfoView", 2, String.format("makeOrRefreshQZone, [h:%s, des: %s, space: %s, remark: %s, nick: %s, info: %s]", new Object[] { paramCard.strQzoneHeader, paramCard.strQzoneFeedsDesc, paramCard.strSpaceName, this.jdField_a_of_type_Auuw.jdField_a_of_type_ArrayOfJavaLangString[4], this.jdField_a_of_type_Auuw.jdField_a_of_type_ArrayOfJavaLangString[0], localObject2 }));
        return bool1;
        ((ViewGroup.LayoutParams)localObject2).width = i6;
        ((ViewGroup.LayoutParams)localObject2).height = i6;
        break label1344;
        label1730:
        ((ViewGroup.LayoutParams)localObject2).width = i6;
        ((ViewGroup.LayoutParams)localObject2).height = i6;
        break label1377;
        label1747:
        localView2.setVisibility(8);
        localTextView2.setVisibility(8);
        break label943;
        label1764:
        if ((!bool2) && (paramCard.isShowFeeds()) && (!TextUtils.isEmpty(paramCard.strQzoneFeedsDesc)))
        {
          localViewGroup.setVisibility(8);
          localTextView1.setVisibility(0);
          localTextView1.setText(avnk.a(paramCard.strQzoneFeedsDesc, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
          break label1518;
        }
        if (!TextUtils.isEmpty(paramCard.strSpaceName))
        {
          localViewGroup.setVisibility(8);
          localTextView1.setVisibility(0);
          localTextView1.setText(paramCard.strSpaceName);
          break label1518;
        }
        localViewGroup.setVisibility(8);
        localTextView1.setVisibility(0);
        localObject2 = a(this.jdField_a_of_type_Auuw);
        if (this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          localObject2 = ajyc.a(2131708478);
        }
        localTextView1.setText(String.format("%s%s", new Object[] { localObject2, a(2131693543) }));
        if ((this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) || (!paramCard.showPublishButton) || (localObject3 == null) || ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) & 0x4000) == 0)) {
          break label1518;
        }
        ((ViewGroup)localObject3).removeAllViews();
        ((ViewGroup)localObject3).setVisibility(0);
        if (QLog.isColorLevel()) {
          QLog.i("ProfileCardMoreInfoView", 2, "no photo, show writeMoodContainer view.");
        }
        localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561006, null);
        ((ViewGroup)localObject3).addView((View)localObject2);
        ((View)localObject2).setOnClickListener(new bcop(this));
        LpReportInfo_pf00064.allReport(699, 7);
        break label1518;
        label2042:
        localObject2 = (String)localTextView1.getText();
        break label1531;
        label2055:
        localTextView1.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
      label2067:
      i2 = 0;
      continue;
      label2072:
      bool2 = false;
      localObject2 = "";
      break label848;
      label2083:
      i1 = 0;
      break label652;
      bool1 = false;
      break label114;
      label2094:
      i2 = 1;
    }
  }
  
  private boolean d(Card paramCard, boolean paramBoolean)
  {
    paramBoolean = false;
    boolean bool;
    if ((paramCard == null) || (ProfileActivity.AllInOne.i(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
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
        localLinearLayout1 = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131560963, null, false);
        localLinearLayout1.setTag(2131366817, Boolean.TRUE);
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
    if ((paramCard == null) || (paramCard.lCurrentStyleId != auvd.f)) {
      return this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_tag") != null;
    }
    if (this.jdField_a_of_type_Auuw.jdField_b_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_tag") != null;
    }
    Object localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tag");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561012, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tag", localObject1);
      bool1 = true;
    }
    localObject2 = (AdaptiveLayout)((View)localObject1).findViewById(2131376861);
    int i2 = getResources().getDimensionPixelSize(2131298357);
    int i1 = 7;
    if (this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      i1 = 8;
    }
    int i3;
    if (this.jdField_a_of_type_ArrayOfAndroidWidgetTextView == null)
    {
      ((AdaptiveLayout)localObject2).setGap(i2, i2);
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[i1];
      i3 = getResources().getDimensionPixelSize(2131298355);
      int i4 = getResources().getDimensionPixelSize(2131298358);
      int i5 = getResources().getDimensionPixelSize(2131298361);
      i2 = 0;
      if (i2 < i1)
      {
        localObject1 = new TextView(getContext());
        this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i2] = localObject1;
        ((TextView)localObject1).setBackgroundResource(2130846130);
        ((TextView)localObject1).setPadding(i4, i4, i4, i4);
        ((TextView)localObject1).setTextSize(0, i3);
        ((TextView)localObject1).setTextColor(-16777216);
        ((TextView)localObject1).setGravity(17);
        if (7 == i2)
        {
          i3 = getResources().getDimensionPixelSize(2131298362);
          ((TextView)localObject1).setTextSize(0, i3);
          ((TextView)localObject1).setTag(new ausu(47, null));
          ((TextView)localObject1).setText("+");
          ((TextView)localObject1).setOnClickListener(this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnClickListener);
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
          i2 = 7;
          i3 = 0;
          if (i3 >= i1) {
            break label598;
          }
          localObject2 = this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i3];
          if (i3 >= i2) {
            break label555;
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
          i3 += 1;
          break label424;
          i2 = ((List)localObject1).size();
          break;
          label555:
          if (i3 >= 7) {
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
    int i2;
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
      localObject1 = bbjn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785");
      i2 = ((SharedPreferences)localObject1).getInt("sp_extend_friend_entry_add_friend", 0);
      if (!((SharedPreferences)localObject1).contains("sp_extend_friend_entry_add_friend")) {
        break label1078;
      }
    }
    label770:
    label937:
    label1073:
    label1078:
    for (int i1 = ((SharedPreferences)localObject1).getInt("sp_extend_friend_entry_add_friend", 0);; i1 = 1)
    {
      if ((i2 == 0) || (i1 != 1) || (TextUtils.isEmpty(paramCard.declaration)))
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_extend_friend_info") != null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("ProfileCardMoreInfoView", 4, String.format("extend friend guest [%s, %s, %s]", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), paramCard.declaration }));
          }
          return paramBoolean;
        }
      }
      if (!((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).b())
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
      if (this.jdField_a_of_type_Auuw.jdField_a_of_type_Auvd != null)
      {
        i1 = 1;
        localObject1 = (ProfileCardFavorShowView)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_extend_friend_info");
        if (localObject1 != null) {
          break label1073;
        }
        localObject1 = new ProfileCardFavorShowView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        ((ProfileCardFavorShowView)localObject1).setTitle(a(2131691151));
        ((ProfileCardFavorShowView)localObject1).setVisibility(8);
        ((ProfileCardFavorShowView)localObject1).setOnClickListener(null);
        if (this.f) {
          ((ProfileCardFavorShowView)localObject1).setShowArrow(false);
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_extend_friend_info", localObject1);
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        Object localObject2 = ((ProfileCardFavorShowView)localObject1).b;
        ((View)localObject2).setTag(new ausu(87, null));
        ((View)localObject2).setOnClickListener(this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((View)localObject2).setContentDescription(a(2131691151));
        Object localObject3;
        Object localObject4;
        Object localObject5;
        if (bool2) {
          if (TextUtils.isEmpty(paramCard.declaration))
          {
            localObject2 = ((ProfileCardFavorShowView)localObject1).getChildAt(0);
            if ((localObject2 == null) || (!Boolean.TRUE.equals(((View)localObject2).getTag(0))) || (!new Boolean(bool1).equals(((View)localObject2).getTag(1))) || (!this.jdField_a_of_type_Auuw.jdField_a_of_type_Auvd.equals(((View)localObject2).getTag(2))))
            {
              ((ProfileCardFavorShowView)localObject1).removeAllViews();
              if ((!bool1) && (i1 == 0)) {
                break label937;
              }
              localObject2 = LayoutInflater.from(getContext()).inflate(2131560988, null);
              ((View)localObject2).setTag(2131371972, Boolean.valueOf(true));
              ((View)localObject2).setTag(2131371973, Boolean.valueOf(bool1));
              ((View)localObject2).setTag(2131371971, this.jdField_a_of_type_Auuw.jdField_a_of_type_Auvd);
              localObject3 = (TextView)((View)localObject2).findViewById(2131378013);
              localObject4 = (TextView)((View)localObject2).findViewById(2131378014);
              if (i1 != 0)
              {
                localObject5 = this.jdField_a_of_type_Auvd.a.get("commonItemContentColor");
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
              localObject3 = ((View)localObject2).findViewById(2131378012);
              ((View)localObject3).setOnClickListener(new bcos(this, paramCard));
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
          i1 = 0;
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
          localObject3 = LayoutInflater.from(getContext()).inflate(2131560987, null);
          localObject4 = ((View)localObject3).findViewById(2131375404);
          localObject5 = aokl.a("expand_summary_default_bg.png");
          localObject2 = localObject3;
          if (!apvb.a((String)localObject5)) {
            break label770;
          }
          localObject2 = aokl.a((String)localObject5, null);
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
    int i1;
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
        if (this.jdField_a_of_type_Auuw.jdField_a_of_type_Auvd == null) {
          break;
        }
        i1 = 1;
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
    if (i1 != 0) {
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
      a("map_key_mini_playing", null, (TextView)paramCard.findViewById(2131377183), (ImageView)paramCard.findViewById(2131367815));
      return bool1;
      i1 = 0;
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
      if (i1 == 0) {
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
          if (i1 != 0) {
            a((MiniAppProfileCardView)localObject2);
          }
          localObject2 = localObject1;
          bool1 = bool2;
          if (paramCard.miniAppInfoArrayList.size() <= 1) {
            break;
          }
          localObject2 = localProfileCardFavorShowView.b;
          ((View)localObject2).setTag(new ausu(96, Boolean.valueOf(true)));
          ((View)localObject2).setOnClickListener(this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnClickListener);
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
        if (i1 != 0) {
          a((MiniAppProfileCardGuestView)localObject2);
        }
        localObject2 = localObject1;
        bool1 = bool2;
        if (paramCard.guestAppTotal <= 1) {
          break;
        }
        localObject2 = localProfileCardFavorShowView.b;
        ((View)localObject2).setTag(new ausu(96, Boolean.valueOf(false)));
        ((View)localObject2).setOnClickListener(this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnClickListener);
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
    for (int i1 = 1; (i1 == 0) || (ProfileActivity.AllInOne.i(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (bbbd.b(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || ((this.jdField_a_of_type_Bcoy != null) && (!this.jdField_a_of_type_Bcoy.a(2))); i1 = 0)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_photo_wall");
      return false;
    }
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_photo_wall");
    paramCard = (Card)localObject;
    if (localObject == null)
    {
      localObject = new PhotoWallView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this);
      paramCard = new ProfileCardFavorShowView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      paramCard.setTitle(ajyc.a(2131708462));
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
      localObject = ((ProfileCardFavorShowView)localObject).b;
      ((View)localObject).setTag(new ausu(85, paramCard));
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject).setContentDescription(a(2131691178));
    }
    return true;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().putExtra("writeMoodFromProfileCard", true);
    bgxy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1037);
    LpReportInfo_pf00064.allReport(699, 8);
    LpReportInfo_pf00064.allReport(586, 1, 6);
  }
  
  private boolean g(Card paramCard)
  {
    boolean bool5 = true;
    boolean bool4 = true;
    boolean bool1;
    boolean bool2;
    label41:
    boolean bool3;
    if ((this.jdField_a_of_type_Bcoy == null) || (this.jdField_a_of_type_Bcoy.a(8)))
    {
      bool1 = true;
      if ((paramCard == null) || (paramCard.switch_sticky_note == 1)) {
        break label191;
      }
      bool2 = true;
      boolean bool6 = ProfileActivity.AllInOne.b(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      bool3 = bhbh.a();
      if ((!bool1) || (!bool2) || (!bool6) || (!bool3)) {
        break label196;
      }
      bool3 = true;
      label79:
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardMoreInfoView", 2, String.format("makeOrRefreshStickyNote showStickyNote=%s configEnable=%s switchEnable=%s isFriend=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool6) }));
      }
      if ((paramCard != null) && (bool3)) {
        break label207;
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_sticky_note") == null) {
        break label202;
      }
      bool1 = bool4;
      label155:
      bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (this.jdField_a_of_type_Bhna != null)
        {
          this.jdField_a_of_type_Bhna.a();
          this.jdField_a_of_type_Bhna = null;
          bool2 = bool1;
        }
      }
    }
    label191:
    label196:
    label202:
    label207:
    ProfileCardFavorShowView localProfileCardFavorShowView;
    do
    {
      return bool2;
      bool1 = false;
      break;
      bool2 = false;
      break label41;
      bool3 = false;
      break label79;
      bool1 = false;
      break label155;
      if ((ProfileCardFavorShowView)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sticky_note") != null) {
        break label323;
      }
      localProfileCardFavorShowView = new ProfileCardFavorShowView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localProfileCardFavorShowView.setTitle(a(2131691181));
      localProfileCardFavorShowView.setShowArrow(false);
      localProfileCardFavorShowView.setMarginBottomEnable(false);
      localProfileCardFavorShowView.setVisibility(8);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sticky_note", localProfileCardFavorShowView);
      bool2 = bool5;
    } while (this.jdField_a_of_type_Bhna != null);
    this.jdField_a_of_type_Bhna = new bhna();
    this.jdField_a_of_type_Bhna.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramCard, this.jdField_a_of_type_ComTencentWidgetListView, localProfileCardFavorShowView);
    return true;
    label323:
    return false;
  }
  
  private boolean g(Card paramCard, boolean paramBoolean)
  {
    if (paramCard == null) {
      return false;
    }
    if (this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", "", "0X800A1C6", "0X800A1C6", 0, 0, "", "", "", "");
      QZLog.d("cardInfo.allinone.pa", 2, new Object[] { Integer.valueOf(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int) });
      if ((paramCard.presentSwitch) && (!ProfileActivity.AllInOne.f(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
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
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", "", "0X800A1C8", "0X800A1C8", 0, 0, "", "", "", "");
      break;
    }
    label162:
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_present");
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560998, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_present", localView);
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      Object localObject2 = (ViewGroup)localView.findViewById(2131368118);
      TextView localTextView = (TextView)localView.findViewById(2131377183);
      ImageView localImageView1 = (ImageView)localView.findViewById(2131367815);
      Object localObject3 = (ImageView)localView.findViewById(2131368119);
      Object localObject4 = (ImageView)localView.findViewById(2131368120);
      ImageView localImageView2 = (ImageView)localView.findViewById(2131368121);
      ImageView localImageView3 = (ImageView)localView.findViewById(2131368122);
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
        int i1 = ((Resources)localObject3).getDimensionPixelSize(2131298154);
        int i2 = ((Resources)localObject3).getDimensionPixelSize(2131297372);
        int i3 = ((Resources)localObject3).getDimensionPixelSize(2131297369);
        i2 = (int)(this.jdField_b_of_type_Float - i2 - i3);
        i3 = (int)((i2 - i1 * 3 * 1.0F) / 3.0F);
        if (QLog.isColorLevel()) {
          QLog.e("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "makeOrRefreshQZone count:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(((List)localObject1).size()), Integer.valueOf(i3), Integer.valueOf(i1), Integer.valueOf(i2) }));
        }
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          if (((List)localObject2).size() > 4) {
            i1 = 4;
          }
          for (;;)
          {
            i2 = 0;
            label548:
            if (i2 < i1)
            {
              localObject3 = (String)((List)localObject2).get(i2);
              if (!TextUtils.isEmpty((CharSequence)localObject3))
              {
                if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
                  ((ImageView)((List)localObject1).get(i2)).setColorFilter(1996488704);
                }
                if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
                  this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(getResources().getColor(2131165638));
                }
              }
              try
              {
                localObject4 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = i3;
                ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = i3;
                localObject3 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
                ((ImageView)((List)localObject1).get(i2)).setImageDrawable((Drawable)localObject3);
                i2 += 1;
                break label548;
                i1 = ((List)localObject2).size();
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
      if (this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        localObject1 = ajyc.a(2131708463);
        if (TextUtils.isEmpty(paramCard.presentDesc)) {
          break label909;
        }
      }
      label909:
      for (paramCard = ": " + paramCard.presentDesc;; paramCard = "")
      {
        localTextView.setText((String)localObject1 + ajyc.a(2131708470) + paramCard);
        ThreadManager.getFileThreadHandler().post(new ProfileCardMoreInfoView.10(this, localTextView));
        localView.setTag(new ausu(94, null));
        localView.setOnClickListener(this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView.setContentDescription(a(2131691165));
        a("map_key_present", null, localTextView, localImageView1);
        return paramBoolean;
        localObject1 = this.jdField_a_of_type_Auuw.jdField_a_of_type_ArrayOfJavaLangString[0];
        break;
      }
    }
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "update more info");
    }
    removeAllViews();
    List localList;
    int i2;
    label50:
    int i3;
    label107:
    int i4;
    label110:
    View localView4;
    if (c())
    {
      localList = a(this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ArrayOfJavaLangString);
      if (b()) {
        break label215;
      }
      i2 = 1;
      View localView1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_phone");
      View localView2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_photo_wall");
      View localView3 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sticky_note");
      int i1 = 0;
      if (localList == null) {
        break label220;
      }
      i3 = localList.size();
      i4 = 0;
      if (i4 >= i3) {
        break label489;
      }
      localView4 = (View)localList.get(i4);
      if (localView4 != localView1) {
        break label225;
      }
      label137:
      if ((localView4.getVisibility() != 0) && (localView4 != localView2) && (localView4 != localView3)) {
        localView4.setVisibility(0);
      }
      if ((i2 != 0) || (!a(i1, localView4))) {
        break label490;
      }
      i1 += 1;
    }
    label215:
    label220:
    label225:
    label489:
    label490:
    for (;;)
    {
      addView(localView4);
      i4 += 1;
      break label110;
      localList = b(this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ArrayOfJavaLangString);
      break;
      i2 = 0;
      break label50;
      i3 = 0;
      break label107;
      if ((localView4 instanceof ProfileCardFavorShowView))
      {
        localObject = (ProfileCardFavorShowView)localView4;
        if ((i2 != 0) && (!c()))
        {
          auvd.a(((ProfileCardFavorShowView)localObject).b, "background", this.jdField_a_of_type_Auvd, "commonItemTopBorderBackground");
          break label137;
        }
        ((ProfileCardFavorShowView)localObject).b.setBackgroundResource(2130839171);
        break label137;
      }
      if (((localView4 instanceof ViewGroup)) && (localView4.getTag(2131366817) == Boolean.TRUE))
      {
        localObject = (ViewGroup)localView4;
        int i6 = ((ViewGroup)localObject).getChildCount();
        int i5 = 0;
        View localView5;
        if (i5 < i6)
        {
          localView5 = ((ViewGroup)localObject).getChildAt(i5);
          if ((localView5 != null) && ((localView5 instanceof ProfileCardFavorShowView)) && (localView5.getTag(2131366818) != Boolean.TRUE))
          {
            if (i2 == 0) {
              break label409;
            }
            if (!c()) {
              auvd.a(((ProfileCardFavorShowView)localView5).b, "background", this.jdField_a_of_type_Auvd, "commonItemTopBorderBackground");
            }
          }
        }
        for (;;)
        {
          i5 += 1;
          break label325;
          break;
          ((ProfileCardFavorShowView)localView5).b.setBackgroundResource(2130839171);
        }
      }
      if (i2 != 0)
      {
        if (c()) {
          break label137;
        }
        auvd.a(localView4, "background", this.jdField_a_of_type_Auvd, "commonItemTopBorderBackground");
        break label137;
      }
      Object localObject = localView4.findViewById(2131373084);
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(2130839171);
      }
      localView4.setBackgroundResource(2130839171);
      break label137;
      return;
    }
  }
  
  private boolean h(Card paramCard, boolean paramBoolean)
  {
    if (paramCard == null) {
      return false;
    }
    int i1;
    label34:
    label51:
    label77:
    label99:
    int i2;
    if (ProfileActivity.AllInOne.i(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      i1 = 1;
      if ((i1 == 0) && (paramCard.personalityLabel != null)) {
        break label299;
      }
      i1 = 1;
      if ((i1 == 0) && (paramCard.personalityLabel.isCloseByUser != 1)) {
        break label304;
      }
      i1 = 1;
      if ((i1 == 0) && ((paramCard.personalityLabel.getSize() != 0) || (paramCard.personalityLabel.remainCount > 0))) {
        break label309;
      }
      i1 = 1;
      if ((i1 == 0) && (!bbbd.b(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label314;
      }
      i1 = 1;
      if ((i1 == 0) && ((paramCard.personalityLabel.getSize() != 0) || (bbbd.a(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))) {
        break label319;
      }
      i1 = 1;
      label138:
      if ((i1 == 0) && ((this.jdField_a_of_type_Bcoy == null) || (this.jdField_a_of_type_Bcoy.a(3)))) {
        break label324;
      }
      i1 = 1;
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
        i2 = 2;
        label239:
        axqw.b((QQAppInterface)localObject1, "dc00898", "", "", "0X8008408", "0X8008408", i2, 0, "", "", "", "");
      }
      if (i1 == 0) {
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
      i1 = 0;
      break;
      i1 = 0;
      break label34;
      i1 = 0;
      break label51;
      i1 = 0;
      break label77;
      i1 = 0;
      break label99;
      i1 = 0;
      break label138;
      i1 = 0;
      break label162;
      i2 = 1;
      break label239;
    }
    label340:
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_personality_label_board");
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = new ProfileCardFavorShowView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localObject2 = new PersonalityLabelBoard(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, (View)localObject1);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) {
        ((PersonalityLabelBoard)localObject2).setScrollListener((autg)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      }
      ((ProfileCardFavorShowView)localObject1).setTitle(ajyc.a(2131708427));
      ((ProfileCardFavorShowView)localObject1).setVisibility(8);
      ((ProfileCardFavorShowView)localObject1).addView((View)localObject2);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_personality_label_board", localObject1);
    }
    for (boolean bool = true;; bool = false)
    {
      ausz localausz;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity))
      {
        localObject2 = (ProfileCardFavorShowView)localObject1;
        localausz = (ausz)((ProfileCardFavorShowView)localObject2).a(0);
        ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a(localausz);
        localausz.a(paramCard.personalityLabel, paramBoolean, false);
        a((PersonalityLabelBoard)localausz, (ProfileCardFavorShowView)localObject1);
        paramCard = a(this.jdField_a_of_type_Auuw);
        if (paramCard == null) {
          break label600;
        }
        localausz.setNick(paramCard);
      }
      for (;;)
      {
        paramCard = ((ProfileCardFavorShowView)localObject2).b;
        paramCard.setTag(new ausu(86, ((ProfileCardFavorShowView)localObject2).a(0)));
        paramCard.setOnClickListener(this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramCard.setContentDescription(a(2131691177));
        return bool;
        label600:
        localausz.setNick("");
      }
    }
  }
  
  public int a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    int i1 = 0;
    int i2 = 0;
    for (;;)
    {
      if ((paramArrayOfString1 != null) && (i1 < paramArrayOfString1.length)) {
        if (TextUtils.isEmpty(paramArrayOfString1[i1]))
        {
          i1 += 1;
        }
        else
        {
          int i4 = paramArrayOfString2.length;
          i3 = 0;
          label38:
          if (i3 >= i4) {
            break label124;
          }
          if (!paramArrayOfString2[i3].equals(paramArrayOfString1[i1])) {
            break;
          }
        }
      }
    }
    label124:
    for (int i3 = 1;; i3 = 0)
    {
      if (i3 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ProfileCardMoreInfoView", 2, String.format("checkTagsForTroop invalid tag for specail troop tag: %s", new Object[] { paramArrayOfString1[i1] }));
        }
        paramArrayOfString1[i1] = "";
        break;
        i3 += 1;
        break label38;
      }
      i2 += 1;
      break;
      return i2;
    }
  }
  
  public View a(String paramString)
  {
    if ("map_key_tag".equals(paramString))
    {
      paramString = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_medal_and_diamond");
      if (paramString != null) {
        return paramString.findViewById(2131369847);
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
    Object localObject = akpy.b();
    aukn localaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    String str1 = MessageRecord.getTableName(this.jdField_a_of_type_Auuw.jdField_a_of_type_JavaLangString, 1);
    String str2 = String.format("shmsgseq < %d and senderuin = ? and extLong & 3 <> 3 and msgtype %s and isValid=1", new Object[] { Long.valueOf(9223372036854775807L), localObject });
    if (this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqDataCard != null) {}
    for (localObject = this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqDataCard.uin;; localObject = this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)
    {
      localObject = localaukn.a(MessageRecord.class, str1, false, str2, new String[] { localObject }, null, null, "shmsgseq DESC", String.valueOf(1));
      localaukn.a();
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
    if ((paramInt == 0) && (!auvq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (a(this.jdField_a_of_type_AndroidWidgetTextView))) {
      this.jdField_a_of_type_AndroidWidgetTextView.post(new ProfileCardMoreInfoView.14(this));
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Bhna != null) {
      this.jdField_a_of_type_Bhna.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131366325);
      CircleBoarderImageView localCircleBoarderImageView1 = (CircleBoarderImageView)paramView.findViewById(2131364220);
      CircleBoarderImageView localCircleBoarderImageView2 = (CircleBoarderImageView)paramView.findViewById(2131364221);
      paramView = (CircleBoarderImageView)paramView.findViewById(2131364222);
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
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131366325);
    Object localObject = (CircleBoarderImageView)paramView.findViewById(2131364220);
    CircleBoarderImageView localCircleBoarderImageView1 = (CircleBoarderImageView)paramView.findViewById(2131364221);
    CircleBoarderImageView localCircleBoarderImageView2 = (CircleBoarderImageView)paramView.findViewById(2131364222);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localArrayList.add(localCircleBoarderImageView1);
    localArrayList.add(localCircleBoarderImageView2);
    localObject = (TextView)paramView.findViewById(2131378107);
    Collections.sort(paramList, new bcol(this));
    int i2 = auvq.a().a(paramList);
    paramList = auvq.a().a(paramList);
    paramView.setVisibility(0);
    localRelativeLayout.setVisibility(0);
    if (paramList.size() > localArrayList.size())
    {
      i1 = 0;
      while (i1 < localArrayList.size())
      {
        ((CircleBoarderImageView)localArrayList.get(i1)).setVisibility(0);
        a(String.valueOf(((oidb_0xd9f.UinItem)paramList.get(i1)).uint64_uin.get()), (CircleBoarderImageView)localArrayList.get(i1));
        i1 += 1;
      }
    }
    int i1 = 0;
    if (i1 < localArrayList.size())
    {
      if (i1 < paramList.size())
      {
        new baxk(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(1, String.valueOf(((oidb_0xd9f.UinItem)paramList.get(i1)).uint64_uin.get()));
        ((CircleBoarderImageView)localArrayList.get(i1)).setVisibility(0);
        a(String.valueOf(((oidb_0xd9f.UinItem)paramList.get(i1)).uint64_uin.get()), (CircleBoarderImageView)localArrayList.get(i1));
      }
      for (;;)
      {
        i1 += 1;
        break;
        ((CircleBoarderImageView)localArrayList.get(i1)).setVisibility(8);
      }
    }
    if (i2 <= 3)
    {
      paramList = i2 + ajyc.a(2131708476);
      ((TextView)localObject).setText(paramList);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label511;
      }
      paramView.setBackgroundDrawable(null);
    }
    for (;;)
    {
      axqw.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "1", "0", "", "");
      return;
      paramList = ajyc.a(2131708446) + i2 + ajyc.a(2131708425);
      break;
      label511:
      if (!b()) {
        paramView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845008));
      } else {
        paramView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845007));
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
    if (!auvq.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      paramView.setVisibility(8);
      return;
    }
    Object localObject = anav.a();
    if ((localObject == null) || (((anas)localObject).a()))
    {
      paramView.setVisibility(8);
      return;
    }
    a(paramView);
    paramView.setVisibility(0);
    ArrayList localArrayList = ((anas)localObject).a().jdField_a_of_type_JavaUtilArrayList;
    TextView localTextView = (TextView)paramView.findViewById(2131378107);
    ImageView localImageView = (ImageView)paramView.findViewById(2131377455);
    localTextView.setText(auvq.a().a((anas)localObject));
    int i1 = 0;
    int i2;
    while (i1 < ((anas)localObject).a().jdField_a_of_type_JavaUtilArrayList.size()) {
      if (TextUtils.isEmpty(((anau)localArrayList.get(i1)).jdField_a_of_type_JavaLangString))
      {
        i1 += 1;
      }
      else
      {
        i2 = ((anau)localArrayList.get(i1)).jdField_a_of_type_Int;
        localObject = ((anau)localArrayList.get(i1)).jdField_a_of_type_JavaLangString;
      }
    }
    for (i1 = i2;; i1 = -1)
    {
      if (paramBoolean) {
        paramView.setOnClickListener(new bcom(this, (String)localObject, i1, paramView));
      }
      localImageView.setOnTouchListener(muf.a);
      localImageView.setOnClickListener(new bcon(this, paramView));
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        paramView.setBackgroundDrawable(null);
      }
      for (;;)
      {
        axqw.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "2", "0", "", "");
        return;
        if (!b()) {
          paramView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845008));
        } else {
          paramView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845007));
        }
      }
      localObject = "";
    }
  }
  
  public void a(auuw paramauuw, View paramView)
  {
    if ((paramauuw == null) || (paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (paramView == null)) {
      return;
    }
    paramView.setVisibility(0);
    Object localObject3 = paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard;
    Object localObject1 = ((Card)localObject3).getPrivilegeOpenInfo();
    Object localObject2 = ((Card)localObject3).getPrivilegeCloseInfo();
    TextView localTextView = (TextView)paramView.findViewById(2131372037);
    paramView = (LinearLayout)paramView.findViewById(2131365191);
    paramView.removeAllViews();
    StringBuilder localStringBuilder = new StringBuilder(24);
    localStringBuilder.append(getContext().getString(2131693480));
    if ((paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      paramauuw = new ArrayList();
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
        localTextView.setText(ajyc.a(2131708467));
        localStringBuilder.append("你未开通特权服务，快去开通vip服务吧！");
        break;
        label372:
        localArrayList.add(localObject2);
      }
      label385:
      paramauuw.addAll((Collection)localObject3);
      paramauuw.addAll(localArrayList);
      a(paramauuw, paramView, false);
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
    paramauuw = ((Card)localObject3).privilegePromptStr;
    if (TextUtils.isEmpty(paramauuw)) {
      localTextView.setVisibility(4);
    }
    for (;;)
    {
      paramView.setVisibility(8);
      break;
      localTextView.setText(paramauuw);
      localTextView.setVisibility(0);
      localStringBuilder.append("TA还未开通任何服务特权");
    }
  }
  
  public void a(auuw paramauuw, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, boolean paramBoolean, bcoy parambcoy, ListView paramListView)
  {
    this.jdField_a_of_type_Auuw = paramauuw;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Bcoy = parambcoy;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_Baxk = new baxk(this.jdField_a_of_type_AndroidContentContext, paramQQAppInterface);
    this.jdField_a_of_type_Baxk.a(this);
    ((FriendProfileCardActivity)paramBaseActivity).a(this);
  }
  
  public void a(auuw paramauuw, boolean paramBoolean, String... paramVarArgs)
  {
    if (paramauuw == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCardMoreInfoView", 2, "update info is null");
      }
      return;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      if ((paramauuw.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramauuw.jdField_a_of_type_JavaLangString)))
      {
        paramVarArgs = this.jdField_b_of_type_ArrayOfJavaLangString;
        label55:
        i1 = paramVarArgs.length;
      }
    }
    for (;;)
    {
      if (i1 != 0) {
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
        i1 = 0;
      } else if ((paramauuw.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramauuw.jdField_a_of_type_JavaLangString))) {
        i1 = a(paramVarArgs, this.jdField_b_of_type_ArrayOfJavaLangString);
      } else {
        i1 = paramVarArgs.length;
      }
    }
    label143:
    if (c()) {
      ((ProfileQVipDiyView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).a(paramauuw, paramBoolean, paramVarArgs);
    }
    int i2 = paramVarArgs.length;
    int i1 = 0;
    boolean bool2 = false;
    label173:
    String str;
    boolean bool1;
    if (i1 < i2)
    {
      str = paramVarArgs[i1];
      if (TextUtils.isEmpty(str)) {
        bool1 = bool2;
      }
    }
    for (;;)
    {
      i1 += 1;
      bool2 = bool1;
      break label173;
      try
      {
        if ("map_key_sig".equals(str))
        {
          RichStatus localRichStatus = paramauuw.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
          localObject = localRichStatus;
          if (localRichStatus == null)
          {
            localObject = localRichStatus;
            if (paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
              localObject = paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard.getRichStatus();
            }
          }
          bool1 = a((RichStatus)localObject);
          if (bool2) {
            break label1099;
          }
          if (!bool1) {
            break label1105;
          }
          break label1099;
        }
        if ("map_key_qzone".equals(str))
        {
          bool1 = d(paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard);
          if (bool2) {
            break label1111;
          }
          if (!bool1) {
            break label1117;
          }
          break label1111;
        }
        if ("map_key_medal_and_diamond".equals(str))
        {
          bool1 = a(paramauuw, paramBoolean);
          if (bool2) {
            break label1123;
          }
          if (!bool1) {
            break label1129;
          }
          break label1123;
        }
        if (!"map_key_medal".equals(str)) {
          break label432;
        }
        Object localObject = a(str);
        if (localObject == null) {
          break label411;
        }
        b(paramauuw, (View)localObject);
        bool1 = bool2;
      }
      catch (Throwable localThrowable)
      {
        QLog.w("ProfileCardMoreInfoView", 1, String.format("update crash tag: %s", new Object[] { str }), localThrowable);
        bool1 = bool2;
      }
      continue;
      label411:
      bool1 = a(paramauuw, true);
      if (!bool2)
      {
        if (!bool1) {
          break label1141;
        }
        break label1135;
        label432:
        if ("map_key_troop_mem_game_info".equals(str))
        {
          bool1 = b(paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard, paramBoolean);
          if (bool2) {
            break label1147;
          }
          if (!bool1) {
            break label1153;
          }
          break label1147;
        }
        if ("map_key_troop_mem_add_time".equals(str))
        {
          bool1 = a();
          if (bool2) {
            break label1159;
          }
          if (!bool1) {
            break label1165;
          }
          break label1159;
        }
        if ("map_key_troop_mem_charm_level".equals(str))
        {
          bool1 = a(paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard, paramBoolean);
          if (bool2) {
            break label1171;
          }
          if (!bool1) {
            break label1177;
          }
          break label1171;
        }
        if ("map_key_troop_mem_recent_said".equals(str))
        {
          bool1 = d();
          if (bool2) {
            break label1183;
          }
          if (!bool1) {
            break label1189;
          }
          break label1183;
        }
        if ("map_key_tag".equals(str))
        {
          bool1 = e(paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard);
          if (bool2) {
            break label1195;
          }
          if (!bool1) {
            break label1201;
          }
          break label1195;
        }
        if ("map_key_account_level_info".equals(str))
        {
          bool1 = b(paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard);
          if (bool2) {
            break label1207;
          }
          if (!bool1) {
            break label1213;
          }
          break label1207;
        }
        if ("map_key_phone".equals(str))
        {
          bool1 = a(paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList);
          if (bool2) {
            break label1219;
          }
          if (!bool1) {
            break label1225;
          }
          break label1219;
        }
        if ("map_key_mine_weishi".equals(str))
        {
          bool1 = c(paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard);
          if (bool2) {
            break label1231;
          }
          if (!bool1) {
            break label1237;
          }
          break label1231;
        }
        if ("map_key_photo_wall".equals(str))
        {
          bool1 = f(paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard, paramBoolean);
          if (bool2) {
            break label1243;
          }
          if (!bool1) {
            break label1249;
          }
          break label1243;
        }
        if ("map_key_personality_label_board".equals(str))
        {
          bool1 = h(paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard, paramBoolean);
          if (bool2) {
            break label1255;
          }
          if (!bool1) {
            break label1261;
          }
          break label1255;
        }
        if ("map_key_extend_friend_info".equals(str))
        {
          bool1 = e(paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard, paramBoolean);
          if (bool2) {
            break label1267;
          }
          if (!bool1) {
            break label1273;
          }
          break label1267;
        }
        if ("map_key_favor".equals(str))
        {
          bool1 = d(paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard, paramBoolean);
          if (bool2) {
            break label1279;
          }
          if (!bool1) {
            break label1285;
          }
          break label1279;
        }
        if ("map_key_account_base_info".equals(str))
        {
          bool1 = c(paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard, paramBoolean);
          if (bool2) {
            break label1291;
          }
          if (!bool1) {
            break label1297;
          }
          break label1291;
        }
        if ("map_key_present".equals(str))
        {
          bool1 = g(paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard, paramBoolean);
          if (bool2) {
            break label1303;
          }
          if (!bool1) {
            break label1309;
          }
          break label1303;
        }
        if ("map_key_mini_playing".equals(str))
        {
          bool1 = f(paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard);
          if (bool2) {
            break label1315;
          }
          if (!bool1) {
            break label1321;
          }
          break label1315;
        }
        if ("map_key_music_box".equals(str))
        {
          if (auwy.a(paramauuw))
          {
            bool1 = a(paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard);
            break label1327;
          }
          if (this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_music_box") == null) {
            break label1343;
          }
          bool1 = true;
          break label1327;
        }
        if ("map_key_sticky_note".equals(str))
        {
          bool1 = g(paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard);
          if (bool2) {
            break label1355;
          }
          if (!bool1) {
            break label1361;
          }
          break label1355;
        }
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ProfileCardMoreInfoView", 2, String.format("update invalid tag: %s", new Object[] { str }));
        bool1 = bool2;
        continue;
        if (bool2) {
          h();
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ProfileCardMoreInfoView", 2, String.format("update ret: %s tags: %s", new Object[] { Boolean.valueOf(bool2), TextUtils.join(",", paramVarArgs) }));
        return;
        label1099:
        bool1 = true;
        continue;
        label1105:
        bool1 = false;
        continue;
        label1111:
        bool1 = true;
        continue;
        label1117:
        bool1 = false;
        continue;
        label1123:
        bool1 = true;
        continue;
        label1129:
        bool1 = false;
        continue;
      }
      label1135:
      bool1 = true;
      continue;
      label1141:
      bool1 = false;
      continue;
      label1147:
      bool1 = true;
      continue;
      label1153:
      bool1 = false;
      continue;
      label1159:
      bool1 = true;
      continue;
      label1165:
      bool1 = false;
      continue;
      label1171:
      bool1 = true;
      continue;
      label1177:
      bool1 = false;
      continue;
      label1183:
      bool1 = true;
      continue;
      label1189:
      bool1 = false;
      continue;
      label1195:
      bool1 = true;
      continue;
      label1201:
      bool1 = false;
      continue;
      label1207:
      bool1 = true;
      continue;
      label1213:
      bool1 = false;
      continue;
      label1219:
      bool1 = true;
      continue;
      label1225:
      bool1 = false;
      continue;
      label1231:
      bool1 = true;
      continue;
      label1237:
      bool1 = false;
      continue;
      label1243:
      bool1 = true;
      continue;
      label1249:
      bool1 = false;
      continue;
      label1255:
      bool1 = true;
      continue;
      label1261:
      bool1 = false;
      continue;
      label1267:
      bool1 = true;
      continue;
      label1273:
      bool1 = false;
      continue;
      label1279:
      bool1 = true;
      continue;
      label1285:
      bool1 = false;
      continue;
      label1291:
      bool1 = true;
      continue;
      label1297:
      bool1 = false;
      continue;
      label1303:
      bool1 = true;
      continue;
      label1309:
      bool1 = false;
      continue;
      label1315:
      bool1 = true;
      continue;
      label1321:
      bool1 = false;
      continue;
      for (;;)
      {
        label1327:
        if ((!bool2) && (!bool1)) {
          break label1349;
        }
        bool1 = true;
        break;
        label1343:
        bool1 = false;
      }
      label1349:
      bool1 = false;
      continue;
      label1355:
      bool1 = true;
      continue;
      label1361:
      bool1 = false;
    }
  }
  
  public void a(awfs paramawfs, View paramView)
  {
    paramawfs = paramawfs.a();
    if ((paramawfs instanceof Pair))
    {
      paramawfs = (Pair)paramawfs;
      awfy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, awfy.a(((Integer)paramawfs.first).intValue(), (String)paramawfs.second), -1);
      if (this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label113;
      }
    }
    label113:
    for (int i1 = 1;; i1 = 2)
    {
      axqw.b(null, "dc00898", "", "", "0X800A4D3", "0X800A4D3", i1, 0, "" + i1, "0", "", "");
      return;
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
    ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).d(i1);
  }
  
  void a(String paramString, TextView paramTextView, View paramView, ImageView paramImageView)
  {
    try
    {
      if ((this.jdField_a_of_type_Auvd != null) && (this.jdField_a_of_type_Auvd.a != null) && (this.jdField_a_of_type_Auvd.a.size() > 0))
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, String.valueOf(this.jdField_a_of_type_Auvd.o));
        auvd.a(paramTextView, "color", this.jdField_a_of_type_Auvd, "commonItemTitleColor");
        auvd.a(paramView, "color", this.jdField_a_of_type_Auvd, "commonItemContentColor");
        auvd.a(paramImageView, "src", this.jdField_a_of_type_Auvd, "commonItemMoreSrc");
        return;
      }
      if (c())
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, String.valueOf(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId));
        auvd.a((ProfileQVipDiyView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, paramString, paramTextView, paramView, paramImageView);
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
      paramTextView.setTextColor(getResources().getColorStateList(2131166928));
    }
    if ((paramView instanceof TextView)) {
      ((TextView)paramView).setTextColor(getResources().getColorStateList(2131166854));
    }
    while (paramImageView != null)
    {
      paramImageView.setImageResource(2130839016);
      return;
      if ((paramView instanceof SingleLineTextView)) {
        ((SingleLineTextView)paramView).setTextColor(getResources().getColorStateList(2131166854));
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_account_level_info");
    if (localObject != null)
    {
      localObject = (FrameLayout)((ProfileQQLevelView)((View)localObject).findViewById(2131373050)).findViewById(2131364896);
      if (localObject != null)
      {
        if (!this.n) {
          break label88;
        }
        ((FrameLayout)localObject).setVisibility(0);
      }
      for (;;)
      {
        QLog.d("ProfileCardMoreInfoView", 2, " update mAllowPeopleSee" + this.n);
        return;
        label88:
        ((FrameLayout)localObject).setVisibility(8);
      }
    }
    QLog.d("ProfileCardMoreInfoView", 2, " accountInfoView not init mAllowPeopleSee" + this.n);
  }
  
  public boolean a()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (!this.jdField_a_of_type_Auuw.jdField_b_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_troop_mem_add_time") != null;
    }
    String str1 = "";
    String str2 = str1;
    long l1;
    if (this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard != null)
    {
      str2 = str1;
      if (this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.joinTime > 0L)
      {
        l1 = this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.joinTime;
        if (this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.joinTime == 1L) {}
      }
    }
    try
    {
      str1 = DateFormat.format(a(2131693541), 1000L * l1).toString();
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
    Object localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562544, null);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_troop_mem_add_time", localObject1);
    Object localObject2 = (ImageView)((View)localObject1).findViewById(2131367679);
    ((ImageView)localObject2).setImageResource(2130844929);
    ((ImageView)localObject2).clearColorFilter();
    ((ImageView)localObject2).setColorFilter(10067634);
    label337:
    for (bool1 = true;; bool1 = bool2)
    {
      localObject2 = (TextView)((View)localObject1).findViewById(2131368342);
      localObject1 = (ImageView)((View)localObject1).findViewById(2131362792);
      ((ImageView)localObject1).setVisibility(8);
      ((TextView)localObject2).setText(str2);
      QLog.d("tagckb", 2, "makeOrRefreshTroopMemJoinTime 05");
      a("map_key_troop_mem_add_time", null, (View)localObject2, (ImageView)localObject1);
      return bool1;
    }
  }
  
  public boolean a(auuw paramauuw)
  {
    if ((paramauuw == null) || (paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!ProfileActivity.AllInOne.b(paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while ((paramauuw.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramauuw.jdField_a_of_type_JavaLangString)));
        if (bbjn.W(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) == 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ProfileCardMoreInfoView", 2, "medal config off");
      return false;
    } while ((paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard.medalSwitchDisable) || (bbbd.b(paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)));
    return true;
  }
  
  public boolean a(auuw paramauuw, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramauuw == null) {
      localObject = null;
    }
    while (localObject == null) {
      if (this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_medal_and_diamond") != null)
      {
        return true;
        localObject = paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard;
      }
      else
      {
        return false;
      }
    }
    if (!bbbd.b(paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
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
      localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560984, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_and_diamond", localObject);
    }
    for (bool = true;; bool = false)
    {
      ImageView localImageView = (ImageView)((View)localObject).findViewById(2131362792);
      View localView = ((View)localObject).findViewById(2131365190);
      if (paramBoolean)
      {
        a(paramauuw, localView);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        localMarginLayoutParams.leftMargin = 0;
        localView.setLayoutParams(localMarginLayoutParams);
        if (!paramBoolean) {
          break label273;
        }
        ((View)localObject).setTag(new ausu(26, null));
        ((View)localObject).setOnClickListener(paramauuw.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        a("map_key_medal_and_diamond", null, null, localImageView);
        return bool;
        localView.setVisibility(8);
        ((View)localObject).setTag(null);
        break;
        label273:
        ((View)localObject).setTag(new ausu(91, null));
        ((View)localObject).setOnClickListener(this.jdField_a_of_type_Bcpe);
      }
    }
  }
  
  public boolean a(auvd paramauvd)
  {
    if (paramauvd == null) {}
    for (paramauvd = "0"; this.jdField_b_of_type_JavaUtilHashMap.size() > 0; paramauvd = String.valueOf(paramauvd.o))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
      String str;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
      } while (((String)this.jdField_b_of_type_JavaUtilHashMap.get(str)).equals(paramauvd));
      return false;
    }
    return true;
  }
  
  public boolean a(Card paramCard)
  {
    boolean bool = false;
    if (auvd.a(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId)) {
      return true;
    }
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_music_box");
    if (localObject == null)
    {
      localObject = new auwy(false);
      paramCard = ((auwy)localObject).a(this.jdField_a_of_type_AndroidContentContext, paramCard.uin);
      paramCard.setTag(2131561621, localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_music_box", paramCard);
      bool = true;
    }
    for (;;)
    {
      if (paramCard.getTag(2131561621) != null) {
        ((auwy)paramCard.getTag(2131561621)).a(this.jdField_a_of_type_Auuw);
      }
      a("map_key_music_box", null, (TextView)paramCard.findViewById(2131377183), (ImageView)paramCard.findViewById(2131367815));
      return bool;
      paramCard = (Card)localObject;
    }
  }
  
  public boolean a(Card paramCard, boolean paramBoolean)
  {
    paramBoolean = false;
    if ((!this.jdField_a_of_type_Auuw.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Auuw.jdField_b_of_type_Int < 0) || (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Auuw.jdField_a_of_type_JavaLangString)))
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
      paramCard = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562544, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_troop_mem_charm_level", paramCard);
      localObject = (ImageView)paramCard.findViewById(2131367679);
      ((ImageView)localObject).setImageResource(2130844927);
      ((ImageView)localObject).clearColorFilter();
      ((ImageView)localObject).setColorFilter(10067634);
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      localObject = (TextView)paramCard.findViewById(2131368342);
      ImageView localImageView = (ImageView)paramCard.findViewById(2131362792);
      ((TextView)localObject).setText("群聊等级已达LV" + this.jdField_a_of_type_Auuw.jdField_b_of_type_Int + " ");
      paramCard.setTag(new ausu(80, null));
      paramCard.setOnClickListener(this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramCard.setOnLongClickListener(this.jdField_a_of_type_Auuw.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      a("map_key_troop_mem_charm_level", null, (View)localObject, localImageView);
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "charm", "exp_grpname", 0, 0, String.valueOf(this.jdField_a_of_type_Auuw.jdField_b_of_type_Int), "", "", "");
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
    int i2 = 2;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onUpdatePhotoWall size:" + paramInt);
    }
    if (this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
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
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EBC", "0X8007EBC", i1, 0, "", "", "", "");
      }
      return;
    }
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EBD", "0X8007EBD", 0, 0, "", "", "", "");
  }
  
  public void b(auuw paramauuw, View paramView)
  {
    if ((paramauuw == null) || (paramView == null) || (paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {
      return;
    }
    paramView.setVisibility(0);
    Object localObject1 = (TextView)paramView.findViewById(2131369850);
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView).a(53).a(true).c(1).e(10).a();
    }
    RedTouch localRedTouch = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
    Object localObject2 = (atxb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160);
    RedTouchItem localRedTouchItem = ((atxb)localObject2).a(10016);
    int i1;
    if (((atxb)localObject2).a(localRedTouchItem, false))
    {
      if (!QLog.isColorLevel()) {
        break label571;
      }
      QLog.d("ProfileCardMoreInfoView", 2, "update head icon red point: " + localRedTouchItem.redtouchType);
      i1 = 1;
    }
    for (;;)
    {
      localObject2 = getResources().getDrawable(2130844944);
      ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Drawable)localObject2);
      ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
      ((TextView)localObject1).setVisibility(0);
      if (paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        ((TextView)localObject1).setText(String.format(Locale.getDefault(), "%d枚", new Object[] { Integer.valueOf(paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard.iMedalCount - paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard.iNewCount) }));
        if (paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard.iNewCount > 0)
        {
          i1 = actn.a(5.0F, getResources());
          paramView.setPadding(0, actn.a(10.0F, getResources()), i1, 0);
          localRedTouch.b(0).a();
          localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(4);
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.set(String.format(Locale.getDefault(), "+%d", new Object[] { Integer.valueOf(paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard.iNewCount) }));
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_desc.set("{'cn':'#FF0000', 'av':1}");
        }
      }
      for (;;)
      {
        label356:
        paramView.setContentDescription(String.format(Locale.getDefault(), ajyc.a(2131708468), new Object[] { Integer.valueOf(paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard.iMedalCount - paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard.iNewCount) }));
        for (;;)
        {
          localRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
          return;
          i1 = 0;
          break;
          if ((i1 == 0) && (paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard.iUpgradeCount <= 0)) {
            break label565;
          }
          paramView.setPadding(0, 0, actn.a(4.0F, getResources()), 0);
          localRedTouch.b(15).a();
          localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(0);
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.set("");
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_desc.set("");
          break label356;
          ((TextView)localObject1).setText(String.format(Locale.getDefault(), "%d枚", new Object[] { Integer.valueOf(paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard.iMedalCount) }));
          paramView.setContentDescription(String.format(Locale.getDefault(), ajyc.a(2131708460), new Object[] { Integer.valueOf(paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard.iMedalCount) }));
          localObject1 = null;
        }
        label565:
        localObject1 = null;
      }
      label571:
      i1 = 1;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bcot != null)
    {
      localObject = (aweo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
      if (localObject != null)
      {
        ((aweo)localObject).b(this.jdField_a_of_type_Bcot);
        this.jdField_a_of_type_Bcot = null;
      }
    }
    if (this.jdField_a_of_type_Baxk != null) {
      this.jdField_a_of_type_Baxk.d();
    }
    Object localObject = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if (localObject != null) {
      ((auwz)localObject).a(null);
    }
    if (this.jdField_a_of_type_Bhna != null) {
      this.jdField_a_of_type_Bhna.c();
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
    //   3: getfield 71	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: ldc 116
    //   8: invokevirtual 1011	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11: checkcast 234	android/view/View
    //   14: astore_2
    //   15: aload_2
    //   16: ifnonnull +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 251	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Auuw	Lauuw;
    //   26: getfield 405	auuw:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   29: getfield 409	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   32: aload_0
    //   33: getfield 472	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   36: invokevirtual 2050	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   39: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: istore_1
    //   43: aload_0
    //   44: iload_1
    //   45: invokespecial 2867	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:b	(Z)V
    //   48: iload_1
    //   49: ifne -30 -> 19
    //   52: aload_2
    //   53: instanceof 602
    //   56: ifeq -37 -> 19
    //   59: aload_2
    //   60: checkcast 602	com/tencent/mobileqq/widget/ProfileCardFavorShowView
    //   63: iconst_0
    //   64: invokevirtual 755	com/tencent/mobileqq/widget/ProfileCardFavorShowView:a	(I)Landroid/view/View;
    //   67: astore_2
    //   68: aload_2
    //   69: instanceof 798
    //   72: ifeq -53 -> 19
    //   75: aload_0
    //   76: aload_2
    //   77: checkcast 798	com/tencent/mobileqq/widget/ProfileCardExtendFriendView
    //   80: getfield 2869	com/tencent/mobileqq/widget/ProfileCardExtendFriendView:e	Landroid/widget/TextView;
    //   83: invokespecial 2754	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:b	(Landroid/view/View;)Z
    //   86: ifeq -67 -> 19
    //   89: aload_0
    //   90: getfield 2871	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:l	Z
    //   93: ifne -74 -> 19
    //   96: aload_0
    //   97: getfield 472	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   100: ldc_w 487
    //   103: ldc_w 456
    //   106: ldc_w 456
    //   109: ldc_w 2873
    //   112: ldc_w 2873
    //   115: iconst_0
    //   116: iconst_0
    //   117: ldc_w 456
    //   120: ldc_w 456
    //   123: ldc_w 456
    //   126: ldc_w 456
    //   129: invokestatic 494	axqw:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_0
    //   133: iconst_1
    //   134: putfield 2871	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:l	Z
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
  
  public void f()
  {
    if (this.jdField_a_of_type_Bhna != null) {
      this.jdField_a_of_type_Bhna.b();
    }
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
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (a("map_key_extend_friend_info")) {
      d();
    }
    if (this.jdField_a_of_type_Bhna != null) {
      this.jdField_a_of_type_Bhna.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Bhna != null) {
      this.jdField_a_of_type_Bhna.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void setMineWeiShiPanelInfo(xim paramxim, boolean paramBoolean)
  {
    QLog.i("ProfileCardMoreInfoView", 2, "setMineWeiShiPanelInfo");
    this.jdField_a_of_type_Xim = paramxim;
    this.h = paramBoolean;
  }
  
  public void setNewSignature(byte[] paramArrayOfByte, long paramLong)
  {
    aukn localaukn;
    Object localObject;
    if (this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localObject != null) {
        break label126;
      }
      localObject = null;
      if (localObject != null) {
        break label146;
      }
      localObject = new Card();
      ((Card)localObject).uin = this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      ((Card)localObject).vRichSign = paramArrayOfByte;
      ((Card)localObject).lSignModifyTime = paramLong;
      localaukn.a((aukm)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = ((Card)localObject).getRichStatus();
      a(this.jdField_a_of_type_Auuw, true, new String[] { "map_key_sig" });
      return;
      label126:
      localObject = ((ajxn)localObject).b(this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      break;
      label146:
      ((Card)localObject).vRichSign = paramArrayOfByte;
      ((Card)localObject).lSignModifyTime = paramLong;
      localaukn.a((aukm)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardMoreInfoView
 * JD-Core Version:    0.7.0.1
 */