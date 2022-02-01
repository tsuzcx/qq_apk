package com.tencent.mobileqq.emoticonview;

import aihd;
import aijc;
import aijm;
import amsx;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import asmg;
import asmr;
import asmu;
import asoa;
import asob;
import asos;
import asqn;
import asre;
import assc;
import assj;
import axfj;
import bdll;
import behh;
import bhtq;
import born;
import borr;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.PropertyValuesHolder;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerFrameLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.qq.im.ae.SessionWrap;
import mqq.app.AppRuntime;

public class EmoticonPanelLinearLayout
  extends LinearLayout
{
  public static int a;
  public static Rect a;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  float jdField_a_of_type_Float;
  volatile long jdField_a_of_type_Long = 0L;
  public Context a;
  View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public asmr a;
  private asmu jdField_a_of_type_Asmu;
  public asob a;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
  private EmojiStickerManager.StickerFrameLayout jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout;
  EmoticonPanelLinearLayout.CheckForLongPress jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$CheckForLongPress;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  boolean jdField_c_of_type_Boolean = false;
  float jdField_d_of_type_Float = 0.0F;
  boolean jdField_d_of_type_Boolean;
  float jdField_e_of_type_Float = 0.0F;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g;
  public int h;
  private boolean h;
  public int i = 0;
  private int j = -1;
  private int k;
  
  static
  {
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    jdField_d_of_type_Int = 3;
    jdField_e_of_type_Int = 4;
    jdField_f_of_type_Int = 5;
    jdField_g_of_type_Int = 6;
    jdField_a_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public EmoticonPanelLinearLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_f_of_type_Boolean = true;
    a(paramContext);
  }
  
  public EmoticonPanelLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_f_of_type_Boolean = true;
    a(paramContext);
  }
  
  public EmoticonPanelLinearLayout(Context paramContext, BaseChatPie paramBaseChatPie, int paramInt)
  {
    super(paramContext);
    this.jdField_f_of_type_Boolean = true;
    a(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.i = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if (!(paramBaseChatPie instanceof aijm)) {
        break label96;
      }
      this.jdField_h_of_type_Int = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c;
      return;
      label96:
      if ((paramBaseChatPie instanceof aihd)) {
        this.jdField_h_of_type_Int = 2;
      } else if ((paramBaseChatPie instanceof aijc)) {
        this.jdField_h_of_type_Int = 3;
      }
    }
  }
  
  private void a(int paramInt, ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    paramMarginLayoutParams.leftMargin = (jdField_a_of_type_AndroidGraphicsRect.left - (paramInt - jdField_a_of_type_AndroidGraphicsRect.width()) / 2);
    if (paramMarginLayoutParams.leftMargin + paramInt >= bhtq.a()) {
      paramMarginLayoutParams.leftMargin = (bhtq.a() - paramInt);
    }
    while (paramMarginLayoutParams.leftMargin > 0) {
      return;
    }
    paramMarginLayoutParams.leftMargin = 0;
  }
  
  private void a(View paramView, float paramFloat, int paramInt1, int paramInt2, ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      paramMarginLayoutParams.topMargin = (jdField_a_of_type_AndroidGraphicsRect.top - paramInt2 - (int)(30.0F * paramFloat));
      paramInt1 = (int)((int)(jdField_a_of_type_AndroidGraphicsRect.left + paramView.getWidth() / 2.0F) - (paramMarginLayoutParams.leftMargin + paramInt1 / 2.0F));
      paramView = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (paramView != null)
      {
        paramView.leftMargin = paramInt1;
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramView);
      }
    }
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_b_of_type_AndroidWidgetImageView.setId(2131362357);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 20.0F), (int)(this.jdField_a_of_type_Float * 20.0F));
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    paramRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130847171));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_c_of_type_AndroidWidgetImageView.setId(2131362358);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 20.0F), (int)(this.jdField_a_of_type_Float * 20.0F));
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(12);
    paramRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130848570));
  }
  
  private void a(asmu paramasmu, float paramFloat)
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getContext());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.addView(localLinearLayout);
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    localLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131378978);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView, (ViewGroup.LayoutParams)localObject);
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetTextView = a(paramasmu);
    paramasmu = new RelativeLayout.LayoutParams(-1, -2);
    paramasmu.addRule(14);
    paramasmu.addRule(12);
    paramasmu.bottomMargin = ((int)(18.0F * paramFloat));
    paramasmu.leftMargin = ((int)(12.0F * paramFloat));
    paramasmu.rightMargin = ((int)(12.0F * paramFloat));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramasmu);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130838007));
    paramasmu = new LinearLayout.LayoutParams(bhtq.a(18.0F), bhtq.a(12.0F));
    paramasmu.topMargin = (-bhtq.a(9.0F));
    paramasmu.gravity = 1;
    localLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramasmu);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4)) > 50.0D;
  }
  
  private boolean a(asmu paramasmu)
  {
    if (("delete".equals(paramasmu.i)) || ("setting".equals(paramasmu.i)) || ("add".equals(paramasmu.i)) || ("cameraJump".equals(paramasmu.i)) || ("cameraEdit".equals(paramasmu.i)) || (this.j == jdField_g_of_type_Int)) {}
    do
    {
      return false;
      if (!(paramasmu instanceof asmg)) {
        break;
      }
      paramasmu = (asmg)paramasmu;
    } while ((paramasmu.h.equals("failed")) || (paramasmu.h.equals("needUpload")) || (paramasmu.h.equals("needDel")));
    return true;
  }
  
  View a(float paramFloat1, float paramFloat2)
  {
    int m = super.getChildCount() - 1;
    while (m >= 0)
    {
      View localView = super.getChildAt(m);
      float f1 = super.getScrollX() + paramFloat1 - localView.getLeft();
      float f2 = super.getScrollY() + paramFloat2 - localView.getTop();
      if ((f1 >= 0.0F) && (f1 <= localView.getWidth()) && (f2 >= 0.0F) && (f2 < localView.getHeight())) {
        return localView;
      }
      m -= 1;
    }
    return null;
  }
  
  protected TextView a(asmu paramasmu)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setText(asos.a(paramasmu));
    localTextView.setId(2131378978);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {}
    for (paramasmu = "#8D8D93";; paramasmu = "#878B99")
    {
      localTextView.setTextColor(Color.parseColor(paramasmu));
      localTextView.setGravity(17);
      localTextView.setSingleLine();
      localTextView.setLines(1);
      localTextView.setTextSize(12.0F);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      return localTextView;
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (!this.jdField_a_of_type_Boolean) && (this.jdField_h_of_type_Boolean) && (EmojiStickerManager.jdField_e_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidViewViewGroup.post(new EmoticonPanelLinearLayout.1(this));
      EmojiStickerManager.jdField_b_of_type_Boolean = false;
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout == null) || (!this.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) || (this.jdField_f_of_type_Boolean)) {
      return;
    }
    this.jdField_f_of_type_Boolean = true;
    ((WindowManager)getContext().getSystemService("window")).removeViewImmediate(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
    }
    if (this.jdField_a_of_type_Asmr != null) {
      this.jdField_a_of_type_Asmr.b(this.jdField_a_of_type_Asmu);
    }
    this.jdField_g_of_type_Boolean = false;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    super.setOrientation(0);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.jdField_b_of_type_Float = paramContext.heightPixels;
    this.jdField_c_of_type_Float = paramContext.widthPixels;
    super.setClickable(true);
    super.setLongClickable(true);
  }
  
  void a(View paramView)
  {
    if (paramView.getAlpha() != 1.0F) {}
    Object localObject3;
    Object localObject2;
    Object localObject1;
    do
    {
      return;
      localObject3 = paramView.getTag();
      localObject2 = null;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if ((localObject3 instanceof asmu)) {
          localObject1 = (asmu)localObject3;
        }
      }
      if (localObject1 == null) {
        break;
      }
    } while ((this.jdField_a_of_type_Asob != null) && (this.jdField_a_of_type_Asob.a(paramView, (asmu)localObject1)));
    super.sendAccessibilityEvent(1);
    super.playSoundEffect(0);
    if ((!"delete".equals(((asmu)localObject1).i)) && (this.jdField_a_of_type_Asmr != null))
    {
      if ("setting".equals(((asmu)localObject1).i)) {
        this.jdField_a_of_type_Asmr.setting();
      }
      for (;;)
      {
        label128:
        if ((paramView instanceof EmoticonImageView))
        {
          paramView = (EmoticonImageView)paramView;
          if (!paramView.a()) {
            break;
          }
          if ((localObject1 instanceof assj)) {
            ApolloUtil.c(((assj)localObject1).jdField_b_of_type_Int);
          }
          paramView.setNewIconVisible(false);
          if (EmoticonImageView.b()) {
            break;
          }
          EmoticonImageView.a(true);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
            break;
          }
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
          if (paramView == null) {
            break;
          }
          paramView.c();
          return;
          if ("add".equals(((asmu)localObject1).i))
          {
            this.jdField_a_of_type_Asmr.d();
            bdll.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "ep_mall", "0X800579C", 0, 0, "", "", "", "");
          }
          else if ("cameraJump".equals(((asmu)localObject1).i))
          {
            long l = System.currentTimeMillis();
            if (l - this.jdField_a_of_type_Long > 1000L)
            {
              this.jdField_a_of_type_Long = l;
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("AECAMERA_MODE", 202);
              ((Bundle)localObject2).putInt("VIDEO_STORY_FROM_TYPE", born.i.a());
              ((Bundle)localObject2).putParcelable("ARG_SESSION_INFO", new SessionWrap(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b));
              borr.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, 120, (Bundle)localObject2);
              bdll.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "dc00898", "", "", "0X800A36E", "0X800A36E", 0, 0, "", "", "", "");
              bdll.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "dc00898", "", "", "0x800a570", "0x800a570", 0, 0, "", "", "", "");
            }
          }
          else if ("cameraEdit".equals(((asmu)localObject1).i))
          {
            localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, FavEmosmManageActivity.class);
            ((Intent)localObject2).putExtra("camera_emo_mode", 1);
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
            bdll.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "dc00898", "", "", "0X800A36F", "0X800A36F", 0, 0, "", "", "", "");
          }
          else if ("favEdit".equals(((asmu)localObject1).i))
          {
            localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, FavEmosmManageActivity.class);
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
            bdll.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "ep_mall", "0X800579E", 0, 0, "", "", "", "");
          }
          else if ("funny_pic".equals(((asmu)localObject1).i))
          {
            if (!"8.4.5".equals("7.3.5")) {
              break label1339;
            }
            localObject2 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("funny_pic_info", 0).edit();
            ((SharedPreferences.Editor)localObject2).putBoolean("group_emo_red_show_sp_key_" + ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getCurrentAccountUin(), false);
            ((SharedPreferences.Editor)localObject2).apply();
            localObject2 = paramView.findViewById(2131366313);
            if ((localObject2 == null) || (((View)localObject2).getVisibility() != 0)) {
              break label1339;
            }
            ((View)localObject2).setVisibility(8);
          }
        }
      }
    }
    label1339:
    for (int m = 1;; m = 0)
    {
      PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, EmoticonGroupStoreFragment.class);
      bdll.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "dc00898", "", "", "0x800a56f", "0x800a56f", 0, 0, "", "", "", "");
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickQLin", "0", 1, 0, m, "", "", "", "", "", "", "", 0, 0, 0, 0);
      break label128;
      if ("push".equals(((asmu)localObject1).i))
      {
        if ((this.jdField_a_of_type_Asmr instanceof BaseChatPie)) {
          ((BaseChatPie)this.jdField_a_of_type_Asmr).q(9);
        }
        bdll.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "dc00898", "", "", "0x800a571", "0x800a571", 0, 0, "", "", "", "");
        bdll.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "ep_mall", "0X800579B", 0, 0, "", "", "", "");
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0);
        localObject3 = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getCurrentAccountUin();
        if (!((SharedPreferences)localObject2).getBoolean("magic_promotion_is_new_content_" + (String)localObject3, false)) {
          break;
        }
        ImageView localImageView = (ImageView)paramView.findViewById(2131365947);
        if (QLog.isColorLevel()) {
          QLog.d("EmotionPanelLinearLayout", 2, "emoticonImg:" + localImageView);
        }
        Object localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847115);
        localObject4 = URLDrawable.getDrawable(((SharedPreferences)localObject2).getString("magic_promotion_imgUrl", ""), (URLDrawable.URLDrawableOptions)localObject4);
        if ((localImageView != null) && (localObject4 != null)) {
          localImageView.setImageDrawable((Drawable)localObject4);
        }
        ((SharedPreferences)localObject2).edit().putBoolean("magic_promotion_is_new_content_" + (String)localObject3, false).apply();
        break label128;
      }
      if ((localObject1 instanceof asre))
      {
        localObject2 = (asre)localObject1;
        ((asre)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo = null;
        localObject3 = ((asre)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticon;
        ((axfj)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(14)).a(((Emoticon)localObject3).epId, this.i, new asoa(this, (Emoticon)localObject3, (asmu)localObject1, (asre)localObject2));
        break label128;
      }
      this.jdField_a_of_type_Asmr.a((asmu)localObject1);
      break label128;
      QLog.e("EmotionPanelLinearLayout", 1, "performclick callback = null");
      break label128;
      break;
      QLog.e("EmotionPanelLinearLayout", 1, "performclick info = null");
      return;
    }
  }
  
  void a(View paramView, asmu paramasmu)
  {
    if ((paramView == null) || (paramasmu == null))
    {
      QLog.e("EmotionPanelLinearLayout", 1, "showpoupemo view or info = null");
      return;
    }
    float f1 = getContext().getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.k = paramasmu.jdField_c_of_type_Int;
    Object localObject1;
    Object localObject2;
    if ((paramasmu instanceof asre))
    {
      localObject1 = (asre)paramasmu;
      localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      if (((localObject2 instanceof QQAppInterface)) && (((asre)localObject1).jdField_a_of_type_ComTencentMobileqqDataEmoticon != null))
      {
        localObject2 = (axfj)((AppRuntime)localObject2).getManager(14);
        if (localObject2 != null)
        {
          localObject2 = ((axfj)localObject2).a(((asre)localObject1).jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
          if (localObject2 != null)
          {
            if (((EmoticonPackage)localObject2).subType != 4) {
              break label251;
            }
            this.jdField_a_of_type_Boolean = true;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmotionPanelLinearLayout", 2, "showPopupEmo, PicEmoticonInfo isDiyEmotion = " + this.jdField_a_of_type_Boolean + " isSoundEmotion = " + this.jdField_c_of_type_Boolean);
      }
      localObject1 = ((asre)localObject1).a("fromAIO", true, false, null, (int)(110.0F * f1), (int)(110.0F * f1));
    }
    for (;;)
    {
      if ((paramasmu instanceof asmg)) {
        this.jdField_b_of_type_Boolean = true;
      }
      if (localObject1 != null) {
        break label330;
      }
      QLog.e("EmotionPanelLinearLayout", 1, "showpoupemo drawable = null");
      return;
      label251:
      if (((EmoticonPackage)localObject2).subType != 1) {
        break;
      }
      this.jdField_c_of_type_Boolean = true;
      break;
      if ((paramasmu instanceof asqn))
      {
        if (QLog.isColorLevel()) {
          QLog.i("EmotionPanelLinearLayout", 2, "showPopupEmo, FavoriteEmoticonInfo");
        }
        localObject1 = ((asqn)paramasmu).b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float, 0, 0);
      }
      else
      {
        localObject1 = paramasmu.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float);
      }
    }
    label330:
    paramView.getGlobalVisibleRect(jdField_a_of_type_AndroidGraphicsRect);
    int m = paramasmu.jdField_c_of_type_Int;
    label490:
    int i1;
    label581:
    int i2;
    int n;
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (EmojiStickerManager.jdField_e_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout = new EmojiStickerManager.StickerFrameLayout(getContext());
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setId(2131374223);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setTag(paramasmu);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setTag(2131374259, Integer.valueOf(this.j));
      this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
      this.jdField_a_of_type_ComTencentImageURLImageView.setId(2131362359);
      this.jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(false);
      this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      ((Drawable)localObject1).setCallback(this.jdField_a_of_type_ComTencentImageURLImageView);
      if (asos.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramasmu))
      {
        a(paramasmu, f1);
        this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout);
        this.jdField_h_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentImageURLImageView != null)
        {
          this.jdField_a_of_type_ComTencentImageURLImageView.setRotation(0.0F);
          this.jdField_a_of_type_ComTencentImageURLImageView.setScaleX(1.0F);
          this.jdField_a_of_type_ComTencentImageURLImageView.setScaleY(1.0F);
        }
        if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        }
        if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
        this.jdField_g_of_type_Boolean = false;
        EmojiStickerManager.jdField_b_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout == null) {
          break label1507;
        }
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        i1 = (int)(5.0F * f1);
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        if ((m != 1) && (m != 2) && (m != 7) && (m != 10)) {
          break label1599;
        }
        if (!asos.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramasmu)) {
          break label1533;
        }
        i1 = (int)(94.0F * f1);
        i2 = (int)(97.0F * f1);
        ((RelativeLayout.LayoutParams)localObject2).width = ((int)(30.0F * f1));
        ((RelativeLayout.LayoutParams)localObject2).height = ((int)(30.0F * f1));
        m = i2;
        n = i1;
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          m = i2;
          n = i1;
          if (this.jdField_a_of_type_AndroidWidgetTextView != null)
          {
            m = i2;
            n = i1;
            if (this.jdField_a_of_type_AndroidWidgetImageView != null)
            {
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838006);
              m = i2;
              n = i1;
              if (QLog.isColorLevel())
              {
                QLog.d("EmotionPanelLinearLayout", 4, "emo title is visible");
                n = i1;
                m = i2;
              }
            }
          }
        }
        label793:
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(6.0F * f1));
        ((RelativeLayout.LayoutParams)localObject2).addRule(14);
        ((RelativeLayout.LayoutParams)localObject2).addRule(15);
        i1 = n;
        n = m;
        m = i1;
        label830:
        if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Boolean) || (!this.jdField_h_of_type_Boolean) || (!EmojiStickerManager.jdField_e_of_type_Boolean)) {
          break label1766;
        }
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLayoutParams();
        i1 = jdField_a_of_type_AndroidGraphicsRect.right - m;
        if (!asos.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramasmu)) {
          break label1704;
        }
        a(m, (ViewGroup.MarginLayoutParams)localObject2);
        label899:
        ((RelativeLayout.LayoutParams)localObject2).topMargin = (jdField_a_of_type_AndroidGraphicsRect.top - n - (int)(15.0F * f1));
        ((RelativeLayout.LayoutParams)localObject2).width = m;
        ((RelativeLayout.LayoutParams)localObject2).height = n;
        a(paramView, f1, m, n, (ViewGroup.MarginLayoutParams)localObject2);
        if (!this.jdField_g_of_type_Boolean) {
          break label1979;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.requestLayout();
      }
    }
    label1186:
    label1507:
    label1509:
    label1533:
    while (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      localObject2 = this.jdField_a_of_type_Asmu;
      this.jdField_a_of_type_Asmu = paramasmu;
      if ((localObject2 != null) && (((asmu)localObject2).jdField_c_of_type_Int == 6) && ((localObject2 instanceof asre)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      }
      Object localObject3;
      if ((paramasmu.jdField_c_of_type_Int == 6) && ((paramasmu instanceof asre)) && ((localObject1 instanceof URLDrawable)))
      {
        paramView = (asre)paramasmu;
        if (paramView.b())
        {
          localObject3 = asos.o.replace("[epId]", paramView.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", paramView.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(getContext(), null);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a((String)localObject3);
          asre.a((URLDrawable)localObject1);
        }
        if (2 == paramView.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType) {
          bdll.b(null, "CliOper", "", "", "MbYulan", "MbChangan", 0, 0, paramView.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, "", "", "");
        }
        if (paramView.c())
        {
          if (paramView.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {
            break label2073;
          }
          paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId;
          axfj.a(null, "0X800A938", -1, paramView);
        }
      }
      if ((paramasmu instanceof assj))
      {
        paramView = (assj)paramasmu;
        localObject3 = BaseApplicationImpl.getApplication();
        if (localObject3 != null)
        {
          localObject3 = ((BaseApplicationImpl)localObject3).getRuntime();
          if ((localObject3 != null) && ((localObject3 instanceof QQAppInterface)))
          {
            localObject3 = (QQAppInterface)localObject3;
            if (behh.a(paramView.jdField_b_of_type_Int))
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
                break label2080;
              }
              m = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "0X800812D", m, 0, new String[] { String.valueOf(paramView.jdField_b_of_type_Int), String.valueOf(amsx.a((QQAppInterface)localObject3)) });
            }
          }
        }
      }
      if (this.jdField_a_of_type_Asmr == null) {
        break;
      }
      this.jdField_a_of_type_Asmr.a((asmu)localObject2, paramasmu, (Drawable)localObject1);
      return;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView);
      a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout);
      this.jdField_a_of_type_AndroidWidgetTextView = null;
      this.jdField_a_of_type_AndroidWidgetImageView = null;
      break label490;
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout = new EmojiStickerManager.StickerFrameLayout(getContext());
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setTag(paramasmu);
        this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
        this.jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(false);
        this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        if (!asos.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramasmu)) {
          break label1509;
        }
        a(paramasmu, f1);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout);
        if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
          break label581;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(asos.a(paramasmu));
        break label581;
        break;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView);
        this.jdField_a_of_type_AndroidWidgetTextView = null;
        this.jdField_a_of_type_AndroidWidgetImageView = null;
      }
      n = (int)(64.0F * f1);
      m = (int)(71.0F * f1);
      ((RelativeLayout.LayoutParams)localObject2).width = ((int)(28.0F * f1));
      ((RelativeLayout.LayoutParams)localObject2).height = ((int)(28.0F * f1));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setPadding(i1, i1, i1, i1);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setBackgroundResource(2130838016);
      break label793;
      m = (int)(110.0F * f1);
      n = (int)(110.0F * f1);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setBackgroundResource(2130838015);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setPadding(i1, i1, i1, i1);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
      ((RelativeLayout.LayoutParams)localObject2).width = ((int)(100.0F * f1));
      ((RelativeLayout.LayoutParams)localObject2).height = ((int)(100.0F * f1));
      bdll.b(null, "CliOper", "", "", "ep_mall", "ep_preview", 0, 0, "", "", "", "");
      break label830;
      if (i1 < 0)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = (jdField_a_of_type_AndroidGraphicsRect.left - (m - jdField_a_of_type_AndroidGraphicsRect.width()) / 2 - i1 / 2);
        break label899;
      }
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = (jdField_a_of_type_AndroidGraphicsRect.left - (m - jdField_a_of_type_AndroidGraphicsRect.width()) / 2);
      break label899;
      localObject2 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject2).gravity = 51;
      i1 = jdField_a_of_type_AndroidGraphicsRect.left + m - getWidth();
      i2 = jdField_a_of_type_AndroidGraphicsRect.right - m;
      if (asos.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramasmu)) {
        a(m, (ViewGroup.MarginLayoutParams)localObject2);
      }
      for (;;)
      {
        ((FrameLayout.LayoutParams)localObject2).topMargin = (jdField_a_of_type_AndroidGraphicsRect.top - n - (int)(15.0F * f1));
        ((FrameLayout.LayoutParams)localObject2).width = m;
        ((FrameLayout.LayoutParams)localObject2).height = n;
        a(paramView, f1, m, n, (ViewGroup.MarginLayoutParams)localObject2);
        break;
        if (i1 > 0) {
          ((FrameLayout.LayoutParams)localObject2).leftMargin = (jdField_a_of_type_AndroidGraphicsRect.left - (m - jdField_a_of_type_AndroidGraphicsRect.width()) / 2 - i1 / 2);
        } else if (i2 < 0) {
          ((FrameLayout.LayoutParams)localObject2).leftMargin = (jdField_a_of_type_AndroidGraphicsRect.left - (m - jdField_a_of_type_AndroidGraphicsRect.width()) / 2 - i2 / 2);
        } else {
          ((FrameLayout.LayoutParams)localObject2).leftMargin = (jdField_a_of_type_AndroidGraphicsRect.left - (m - jdField_a_of_type_AndroidGraphicsRect.width()) / 2);
        }
      }
    }
    label1286:
    label1599:
    label1766:
    paramView = (WindowManager)getContext().getSystemService("window");
    label1704:
    label1979:
    m = 40;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      m = 67108904;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      m |= 0x8000000;
    }
    for (;;)
    {
      localObject2 = new WindowManager.LayoutParams(-1, -1, 2, m, -3);
      paramView.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject2);
      this.jdField_f_of_type_Boolean = false;
      this.jdField_g_of_type_Boolean = true;
      break;
      label2073:
      paramView = "";
      break label1186;
      label2080:
      m = -1;
      break label1286;
    }
  }
  
  boolean a(View paramView, Rect paramRect)
  {
    if (paramView == null) {
      return false;
    }
    paramView.getDrawingRect(paramRect);
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    paramRect.offset(paramView.getLeft() - localViewGroup.getScrollX(), paramView.getTop() - localViewGroup.getScrollY());
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 1: 
    case 0: 
    case 3: 
      for (;;)
      {
        return true;
        if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$CheckForLongPress != null)) {
          removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$CheckForLongPress);
        }
        if ((this.jdField_a_of_type_AndroidViewView != null) && (!this.jdField_d_of_type_Boolean)) {
          a(this.jdField_a_of_type_AndroidViewView);
        }
        if (!this.jdField_e_of_type_Boolean) {
          a();
        }
        this.jdField_a_of_type_AndroidViewView = null;
        if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (!this.jdField_a_of_type_Boolean) && (EmojiStickerManager.jdField_e_of_type_Boolean))
        {
          this.jdField_a_of_type_AndroidViewViewGroup.onTouchEvent(paramMotionEvent);
          continue;
          this.jdField_d_of_type_Float = paramMotionEvent.getRawX();
          this.jdField_e_of_type_Float = paramMotionEvent.getRawY();
          this.jdField_d_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidViewView = a(paramMotionEvent.getX(), paramMotionEvent.getY());
          if (this.jdField_a_of_type_AndroidViewView != null)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$CheckForLongPress == null) {
              this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$CheckForLongPress = new EmoticonPanelLinearLayout.CheckForLongPress(this, paramMotionEvent);
            }
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$CheckForLongPress.a();
            postDelayed(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$CheckForLongPress, ViewConfiguration.getLongPressTimeout());
            continue;
            super.setPressed(false);
            if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$CheckForLongPress != null) {
              removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$CheckForLongPress);
            }
            if (!this.jdField_e_of_type_Boolean) {
              a();
            }
            this.jdField_a_of_type_AndroidViewView = null;
          }
        }
      }
    }
    Object localObject1;
    if (this.jdField_d_of_type_Boolean)
    {
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      if ((EmojiStickerManager.jdField_e_of_type_Boolean) && (a(this.jdField_d_of_type_Float, this.jdField_e_of_type_Float, f1, f2)) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout != null))
      {
        if ((this.jdField_e_of_type_Boolean) || (!this.jdField_h_of_type_Boolean)) {
          break label1022;
        }
        localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLayoutParams();
        if ((this.k == 1) || (this.k == 2) || (this.k == 7) || (this.k == 10))
        {
          ((RelativeLayout.LayoutParams)localObject1).width = ((int)(110.0F * this.jdField_a_of_type_Float));
          ((RelativeLayout.LayoutParams)localObject1).height = ((int)(110.0F * this.jdField_a_of_type_Float));
        }
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)f1 - ((RelativeLayout.LayoutParams)localObject1).width / 2);
        if (((RelativeLayout.LayoutParams)localObject1).leftMargin + ((RelativeLayout.LayoutParams)localObject1).width > this.jdField_c_of_type_Float) {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)this.jdField_c_of_type_Float - ((RelativeLayout.LayoutParams)localObject1).width);
        }
        ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)f2 - ((RelativeLayout.LayoutParams)localObject1).height / 2 - ImmersiveUtils.getStatusBarHeight(getContext()));
        if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (((RelativeLayout.LayoutParams)localObject1).topMargin + ((RelativeLayout.LayoutParams)localObject1).height > this.jdField_a_of_type_AndroidViewViewGroup.getMeasuredHeight()))
        {
          if (ImmersiveUtils.isSupporImmersive() != 1) {
            break label992;
          }
          ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)this.jdField_b_of_type_Float - ((RelativeLayout.LayoutParams)localObject1).height - ImmersiveUtils.getStatusBarHeight(getContext()));
        }
        label526:
        if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)) {
          break label1011;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(0);
        if (QLog.isColorLevel()) {
          QLog.d("EmotionPanelLinearLayout", 4, "emo title is invisible");
        }
        label587:
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.requestLayout();
        if ((this.jdField_a_of_type_AndroidViewViewGroup instanceof TopGestureLayout))
        {
          localObject1 = ((TopGestureLayout)this.jdField_a_of_type_AndroidViewViewGroup).getGestureDetector();
          if ((localObject1 instanceof assc))
          {
            localObject1 = (assc)localObject1;
            ((assc)localObject1).jdField_a_of_type_Float = f1;
            ((assc)localObject1).jdField_b_of_type_Float = f2;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
          if (localObject1 != null) {
            ((AIOAnimationConatiner)localObject1).a();
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
          if (localObject1 != null)
          {
            if (((EmoticonMainPanel)localObject1).jdField_a_of_type_AndroidViewView == null)
            {
              localObject2 = new LinearLayout(getContext());
              ((LinearLayout)localObject2).setBackgroundColor(-1);
              ((LinearLayout)localObject2).getBackground().setAlpha(0);
              ((LinearLayout)localObject2).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
              ((EmoticonMainPanel)localObject1).jdField_a_of_type_AndroidViewView = ((View)localObject2);
            }
            if (((EmoticonMainPanel)localObject1).jdField_a_of_type_AndroidViewView.getParent() != localObject1) {
              ((EmoticonMainPanel)localObject1).addView(((EmoticonMainPanel)localObject1).jdField_a_of_type_AndroidViewView);
            }
            Object localObject2 = PropertyValuesHolder.ofInt("alpha", new int[] { 0, 178 });
            ObjectAnimator.ofPropertyValuesHolder(((EmoticonMainPanel)localObject1).jdField_a_of_type_AndroidViewView.getBackground(), new PropertyValuesHolder[] { localObject2 }).setDuration(500L).start();
          }
        }
        this.jdField_e_of_type_Boolean = true;
      }
    }
    label818:
    label992:
    label1011:
    label1022:
    do
    {
      do
      {
        if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_e_of_type_Boolean) && (!this.jdField_a_of_type_Boolean) && (this.jdField_h_of_type_Boolean) && (EmojiStickerManager.jdField_e_of_type_Boolean)) {
          this.jdField_a_of_type_AndroidViewViewGroup.onTouchEvent(paramMotionEvent);
        }
        if (((this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)) && (EmojiStickerManager.jdField_e_of_type_Boolean)) {
          break;
        }
        if ((!this.jdField_d_of_type_Boolean) || ((a(this.jdField_a_of_type_AndroidViewView, jdField_a_of_type_AndroidGraphicsRect)) && (jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))) {
          break label1218;
        }
        this.jdField_a_of_type_AndroidViewView = a(paramMotionEvent.getX(), paramMotionEvent.getY());
        if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView.getTag() == null)) {
          break label1211;
        }
        if (!a((asmu)this.jdField_a_of_type_AndroidViewView.getTag())) {
          break;
        }
        a(this.jdField_a_of_type_AndroidViewView, (asmu)this.jdField_a_of_type_AndroidViewView.getTag());
        break;
        ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)this.jdField_b_of_type_Float - ((RelativeLayout.LayoutParams)localObject1).height);
        break label526;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setBackgroundResource(0);
        break label587;
      } while (this.jdField_h_of_type_Boolean);
      localObject1 = (asmu)this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTag();
    } while (localObject1 == null);
    int m;
    switch (((asmu)localObject1).jdField_c_of_type_Int)
    {
    case 3: 
    case 8: 
    default: 
      m = 7;
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage("", "Stick", "DragToAIOX", String.valueOf(this.jdField_h_of_type_Int), 0, 0, 0, "", "", String.valueOf(m), "", "", "", "", 0, 0, 0, 0);
      break label818;
      m = 1;
      continue;
      m = 2;
      continue;
      if (this.jdField_a_of_type_Boolean)
      {
        m = 3;
      }
      else
      {
        if (this.jdField_c_of_type_Boolean)
        {
          m = 6;
          continue;
          m = 4;
          continue;
          m = 5;
          continue;
          label1211:
          a();
          break;
          label1218:
          if ((this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_AndroidViewView == null) || ((a(this.jdField_a_of_type_AndroidViewView, jdField_a_of_type_AndroidGraphicsRect)) && (jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))) {
            break;
          }
          this.jdField_a_of_type_AndroidViewView = null;
          break;
        }
        m = -1;
      }
    }
  }
  
  public void setCallBack(asmr paramasmr)
  {
    this.jdField_a_of_type_Asmr = paramasmr;
  }
  
  public void setPanelType(int paramInt)
  {
    this.j = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout
 * JD-Core Version:    0.7.0.1
 */