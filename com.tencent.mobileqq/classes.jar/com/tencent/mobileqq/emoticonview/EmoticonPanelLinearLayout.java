package com.tencent.mobileqq.emoticonview;

import ahxp;
import ahzo;
import ahzy;
import amhd;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import arws;
import arxd;
import arxg;
import arym;
import aryn;
import arze;
import asaz;
import asbq;
import asco;
import ascv;
import awmr;
import bcst;
import bdol;
import bnqb;
import bnqf;
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
  public arxd a;
  private arxg jdField_a_of_type_Arxg;
  public aryn a;
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
      if (!(paramBaseChatPie instanceof ahzy)) {
        break label96;
      }
      this.jdField_h_of_type_Int = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c;
      return;
      label96:
      if ((paramBaseChatPie instanceof ahxp)) {
        this.jdField_h_of_type_Int = 2;
      } else if ((paramBaseChatPie instanceof ahzo)) {
        this.jdField_h_of_type_Int = 3;
      }
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4)) > 50.0D;
  }
  
  private boolean a(arxg paramarxg)
  {
    if (("delete".equals(paramarxg.i)) || ("setting".equals(paramarxg.i)) || ("add".equals(paramarxg.i)) || ("cameraJump".equals(paramarxg.i)) || ("cameraEdit".equals(paramarxg.i)) || (this.j == jdField_g_of_type_Int)) {}
    do
    {
      return false;
      if (!(paramarxg instanceof arws)) {
        break;
      }
      paramarxg = (arws)paramarxg;
    } while ((paramarxg.h.equals("failed")) || (paramarxg.h.equals("needUpload")) || (paramarxg.h.equals("needDel")));
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
    if (this.jdField_a_of_type_Arxd != null) {
      this.jdField_a_of_type_Arxd.b(this.jdField_a_of_type_Arxg);
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
        if ((localObject3 instanceof arxg)) {
          localObject1 = (arxg)localObject3;
        }
      }
      if (localObject1 == null) {
        break;
      }
    } while ((this.jdField_a_of_type_Aryn != null) && (this.jdField_a_of_type_Aryn.a(paramView, (arxg)localObject1)));
    super.sendAccessibilityEvent(1);
    super.playSoundEffect(0);
    if ((!"delete".equals(((arxg)localObject1).i)) && (this.jdField_a_of_type_Arxd != null))
    {
      if ("setting".equals(((arxg)localObject1).i)) {
        this.jdField_a_of_type_Arxd.setting();
      }
      for (;;)
      {
        label126:
        if ((paramView instanceof EmoticonImageView))
        {
          paramView = (EmoticonImageView)paramView;
          if (!paramView.a()) {
            break;
          }
          if ((localObject1 instanceof ascv)) {
            ApolloUtil.c(((ascv)localObject1).jdField_b_of_type_Int);
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
          if ("add".equals(((arxg)localObject1).i))
          {
            this.jdField_a_of_type_Arxd.d();
            bcst.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "ep_mall", "0X800579C", 0, 0, "", "", "", "");
          }
          else if ("cameraJump".equals(((arxg)localObject1).i))
          {
            long l = System.currentTimeMillis();
            if (l - this.jdField_a_of_type_Long > 1000L)
            {
              this.jdField_a_of_type_Long = l;
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("AECAMERA_MODE", 202);
              ((Bundle)localObject2).putInt("VIDEO_STORY_FROM_TYPE", bnqb.i.a());
              ((Bundle)localObject2).putParcelable("ARG_SESSION_INFO", new SessionWrap(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.d, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.b));
              bnqf.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, 120, (Bundle)localObject2);
              bcst.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "dc00898", "", "", "0X800A36E", "0X800A36E", 0, 0, "", "", "", "");
              bcst.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "dc00898", "", "", "0x800a570", "0x800a570", 0, 0, "", "", "", "");
            }
          }
          else if ("cameraEdit".equals(((arxg)localObject1).i))
          {
            localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, FavEmosmManageActivity.class);
            ((Intent)localObject2).putExtra("camera_emo_mode", 1);
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
            bcst.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "dc00898", "", "", "0X800A36F", "0X800A36F", 0, 0, "", "", "", "");
          }
          else if ("favEdit".equals(((arxg)localObject1).i))
          {
            localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, FavEmosmManageActivity.class);
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
            bcst.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "ep_mall", "0X800579E", 0, 0, "", "", "", "");
          }
          else if ("funny_pic".equals(((arxg)localObject1).i))
          {
            if (!"8.4.1".equals("7.3.5")) {
              break label1334;
            }
            localObject2 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("funny_pic_info", 0).edit();
            ((SharedPreferences.Editor)localObject2).putBoolean("group_emo_red_show_sp_key_" + ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getCurrentAccountUin(), false);
            ((SharedPreferences.Editor)localObject2).apply();
            localObject2 = paramView.findViewById(2131366264);
            if ((localObject2 == null) || (((View)localObject2).getVisibility() != 0)) {
              break label1334;
            }
            ((View)localObject2).setVisibility(8);
          }
        }
      }
    }
    label1334:
    for (int m = 1;; m = 0)
    {
      PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, EmoticonGroupStoreFragment.class);
      bcst.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "dc00898", "", "", "0x800a56f", "0x800a56f", 0, 0, "", "", "", "");
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickQLin", "0", 1, 0, m, "", "", "", "", "", "", "", 0, 0, 0, 0);
      break label126;
      if ("push".equals(((arxg)localObject1).i))
      {
        if ((this.jdField_a_of_type_Arxd instanceof BaseChatPie)) {
          ((BaseChatPie)this.jdField_a_of_type_Arxd).q(9);
        }
        bcst.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "dc00898", "", "", "0x800a571", "0x800a571", 0, 0, "", "", "", "");
        bcst.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "ep_mall", "0X800579B", 0, 0, "", "", "", "");
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0);
        localObject3 = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getCurrentAccountUin();
        if (!((SharedPreferences)localObject2).getBoolean("magic_promotion_is_new_content_" + (String)localObject3, false)) {
          break;
        }
        ImageView localImageView = (ImageView)paramView.findViewById(2131365902);
        if (QLog.isColorLevel()) {
          QLog.d("EmotionPanelLinearLayout", 2, "emoticonImg:" + localImageView);
        }
        Object localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847098);
        localObject4 = URLDrawable.getDrawable(((SharedPreferences)localObject2).getString("magic_promotion_imgUrl", ""), (URLDrawable.URLDrawableOptions)localObject4);
        if ((localImageView != null) && (localObject4 != null)) {
          localImageView.setImageDrawable((Drawable)localObject4);
        }
        ((SharedPreferences)localObject2).edit().putBoolean("magic_promotion_is_new_content_" + (String)localObject3, false).apply();
        break label126;
      }
      if ((localObject1 instanceof asbq))
      {
        localObject2 = (asbq)localObject1;
        ((asbq)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo = null;
        localObject3 = ((asbq)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticon;
        ((awmr)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(14)).a(((Emoticon)localObject3).epId, this.i, new arym(this, (Emoticon)localObject3, (arxg)localObject1, (asbq)localObject2));
        break label126;
      }
      this.jdField_a_of_type_Arxd.a((arxg)localObject1);
      break label126;
      QLog.e("EmotionPanelLinearLayout", 1, "performclick callback = null");
      break label126;
      break;
      QLog.e("EmotionPanelLinearLayout", 1, "performclick info = null");
      return;
    }
  }
  
  void a(View paramView, arxg paramarxg)
  {
    if ((paramView == null) || (paramarxg == null))
    {
      QLog.e("EmotionPanelLinearLayout", 1, "showpoupemo view or info = null");
      return;
    }
    float f1 = getContext().getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.k = paramarxg.jdField_c_of_type_Int;
    Object localObject1;
    Object localObject2;
    if ((paramarxg instanceof asbq))
    {
      localObject1 = (asbq)paramarxg;
      localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      if (((localObject2 instanceof QQAppInterface)) && (((asbq)localObject1).jdField_a_of_type_ComTencentMobileqqDataEmoticon != null))
      {
        localObject2 = (awmr)((AppRuntime)localObject2).getManager(14);
        if (localObject2 != null)
        {
          localObject2 = ((awmr)localObject2).a(((asbq)localObject1).jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
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
      localObject1 = ((asbq)localObject1).a("fromAIO", true, false, null, (int)(110.0F * f1), (int)(110.0F * f1));
    }
    for (;;)
    {
      if ((paramarxg instanceof arws)) {
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
      if ((paramarxg instanceof asaz))
      {
        if (QLog.isColorLevel()) {
          QLog.i("EmotionPanelLinearLayout", 2, "showPopupEmo, FavoriteEmoticonInfo");
        }
        localObject1 = ((asaz)paramarxg).b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float, 0, 0);
      }
      else
      {
        localObject1 = paramarxg.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float);
      }
    }
    label330:
    paramView.getGlobalVisibleRect(jdField_a_of_type_AndroidGraphicsRect);
    int m = paramarxg.jdField_c_of_type_Int;
    label745:
    int i1;
    int n;
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (EmojiStickerManager.jdField_e_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout = new EmojiStickerManager.StickerFrameLayout(getContext());
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setId(2131374084);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setTag(paramarxg);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setTag(2131374120, Integer.valueOf(this.j));
      this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
      this.jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(false);
      this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      ((Drawable)localObject1).setCallback(this.jdField_a_of_type_ComTencentImageURLImageView);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      paramView = new RelativeLayout.LayoutParams((int)(20.0F * this.jdField_a_of_type_Float), (int)(20.0F * this.jdField_a_of_type_Float));
      paramView.addRule(11);
      paramView.addRule(10);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramView);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130847154));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getContext());
      paramView = new RelativeLayout.LayoutParams((int)(20.0F * this.jdField_a_of_type_Float), (int)(20.0F * this.jdField_a_of_type_Float));
      paramView.addRule(11);
      paramView.addRule(12);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, paramView);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130848551));
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout);
      this.jdField_h_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentImageURLImageView != null)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setRotation(0.0F);
        this.jdField_a_of_type_ComTencentImageURLImageView.setScaleX(1.0F);
        this.jdField_a_of_type_ComTencentImageURLImageView.setScaleY(1.0F);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
      this.jdField_g_of_type_Boolean = false;
      EmojiStickerManager.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout == null) {
        break label1507;
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      i1 = (int)(5.0F * f1);
      paramView = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      if ((m != 1) && (m != 2) && (m != 7) && (m != 10)) {
        break label1509;
      }
      n = (int)(64.0F * f1);
      m = (int)(71.0F * f1);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setBackgroundResource(2130838007);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setPadding(i1, i1, i1, i1);
      paramView.width = ((int)(28.0F * f1));
      paramView.height = ((int)(28.0F * f1));
      paramView.bottomMargin = ((int)(6.0F * f1));
      paramView.addRule(14);
      paramView.addRule(15);
      label889:
      if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Boolean) || (!this.jdField_h_of_type_Boolean) || (!EmojiStickerManager.jdField_e_of_type_Boolean)) {
        break label1636;
      }
      paramView = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLayoutParams();
      i1 = jdField_a_of_type_AndroidGraphicsRect.right - n;
      if (i1 >= 0) {
        break label1611;
      }
      paramView.leftMargin = (jdField_a_of_type_AndroidGraphicsRect.left - (n - jdField_a_of_type_AndroidGraphicsRect.width()) / 2 - i1 / 2);
      label970:
      paramView.topMargin = (jdField_a_of_type_AndroidGraphicsRect.top - m - (int)(15.0F * f1));
      paramView.width = n;
      paramView.height = m;
      if (!this.jdField_g_of_type_Boolean) {
        break label1807;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.requestLayout();
    }
    label1242:
    label1507:
    label1509:
    while (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      localObject2 = this.jdField_a_of_type_Arxg;
      this.jdField_a_of_type_Arxg = paramarxg;
      if ((localObject2 != null) && (((arxg)localObject2).jdField_c_of_type_Int == 6) && ((localObject2 instanceof asbq)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      }
      Object localObject3;
      if ((paramarxg.jdField_c_of_type_Int == 6) && ((paramarxg instanceof asbq)) && ((localObject1 instanceof URLDrawable)))
      {
        paramView = (asbq)paramarxg;
        if (paramView.b())
        {
          localObject3 = arze.o.replace("[epId]", paramView.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", paramView.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(getContext(), null);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a((String)localObject3);
          asbq.a((URLDrawable)localObject1);
        }
        if (2 == paramView.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType) {
          bcst.b(null, "CliOper", "", "", "MbYulan", "MbChangan", 0, 0, paramView.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, "", "", "");
        }
        if (paramView.c())
        {
          if (paramView.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {
            break label1900;
          }
          paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId;
          awmr.a(null, "0X800A938", -1, paramView);
        }
      }
      if ((paramarxg instanceof ascv))
      {
        paramView = (ascv)paramarxg;
        localObject3 = BaseApplicationImpl.getApplication();
        if (localObject3 != null)
        {
          localObject3 = ((BaseApplicationImpl)localObject3).getRuntime();
          if ((localObject3 != null) && ((localObject3 instanceof QQAppInterface)))
          {
            localObject3 = (QQAppInterface)localObject3;
            if (bdol.a(paramView.jdField_b_of_type_Int))
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a == null)) {
                break label1907;
              }
              m = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Int);
              VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "0X800812D", m, 0, new String[] { String.valueOf(paramView.jdField_b_of_type_Int), String.valueOf(amhd.a((QQAppInterface)localObject3)) });
            }
          }
        }
      }
      if (this.jdField_a_of_type_Arxd == null) {
        break;
      }
      this.jdField_a_of_type_Arxd.a((arxg)localObject2, paramarxg, (Drawable)localObject1);
      return;
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        break label745;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout = new EmojiStickerManager.StickerFrameLayout(getContext());
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setTag(paramarxg);
      this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
      this.jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(false);
      this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout);
      break label745;
      break;
      n = (int)(110.0F * f1);
      m = (int)(110.0F * f1);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setBackgroundResource(2130838006);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setPadding(i1, i1, i1, i1);
      paramView.bottomMargin = 0;
      paramView.width = ((int)(100.0F * f1));
      paramView.height = ((int)(100.0F * f1));
      bcst.b(null, "CliOper", "", "", "ep_mall", "ep_preview", 0, 0, "", "", "", "");
      break label889;
      paramView.leftMargin = (jdField_a_of_type_AndroidGraphicsRect.left - (n - jdField_a_of_type_AndroidGraphicsRect.width()) / 2);
      break label970;
      paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLayoutParams();
      paramView.gravity = 51;
      i1 = jdField_a_of_type_AndroidGraphicsRect.left + n - getWidth();
      int i2 = jdField_a_of_type_AndroidGraphicsRect.right - n;
      if (i1 > 0) {
        paramView.leftMargin = (jdField_a_of_type_AndroidGraphicsRect.left - (n - jdField_a_of_type_AndroidGraphicsRect.width()) / 2 - i1 / 2);
      }
      for (;;)
      {
        paramView.topMargin = (jdField_a_of_type_AndroidGraphicsRect.top - m - (int)(15.0F * f1));
        paramView.width = n;
        paramView.height = m;
        break;
        if (i2 < 0) {
          paramView.leftMargin = (jdField_a_of_type_AndroidGraphicsRect.left - (n - jdField_a_of_type_AndroidGraphicsRect.width()) / 2 - i2 / 2);
        } else {
          paramView.leftMargin = (jdField_a_of_type_AndroidGraphicsRect.left - (n - jdField_a_of_type_AndroidGraphicsRect.width()) / 2);
        }
      }
    }
    label1342:
    label1611:
    label1636:
    paramView = (WindowManager)getContext().getSystemService("window");
    label1807:
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
      label1900:
      paramView = "";
      break label1242;
      label1907:
      m = -1;
      break label1342;
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
          break label958;
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
            break label939;
          }
          ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)this.jdField_b_of_type_Float - ((RelativeLayout.LayoutParams)localObject1).height - ImmersiveUtils.getStatusBarHeight(getContext()));
        }
        label526:
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setBackgroundResource(0);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.requestLayout();
        if ((this.jdField_a_of_type_AndroidViewViewGroup instanceof TopGestureLayout))
        {
          localObject1 = ((TopGestureLayout)this.jdField_a_of_type_AndroidViewViewGroup).getGestureDetector();
          if ((localObject1 instanceof asco))
          {
            localObject1 = (asco)localObject1;
            ((asco)localObject1).jdField_a_of_type_Float = f1;
            ((asco)localObject1).jdField_b_of_type_Float = f2;
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
    label765:
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
          break label1154;
        }
        this.jdField_a_of_type_AndroidViewView = a(paramMotionEvent.getX(), paramMotionEvent.getY());
        if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView.getTag() == null)) {
          break label1147;
        }
        if (!a((arxg)this.jdField_a_of_type_AndroidViewView.getTag())) {
          break;
        }
        a(this.jdField_a_of_type_AndroidViewView, (arxg)this.jdField_a_of_type_AndroidViewView.getTag());
        break;
        ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)this.jdField_b_of_type_Float - ((RelativeLayout.LayoutParams)localObject1).height);
        break label526;
      } while (this.jdField_h_of_type_Boolean);
      localObject1 = (arxg)this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTag();
    } while (localObject1 == null);
    label939:
    label958:
    int m;
    switch (((arxg)localObject1).jdField_c_of_type_Int)
    {
    case 3: 
    case 8: 
    default: 
      m = 7;
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage("", "Stick", "DragToAIOX", String.valueOf(this.jdField_h_of_type_Int), 0, 0, 0, "", "", String.valueOf(m), "", "", "", "", 0, 0, 0, 0);
      break label765;
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
          label1147:
          a();
          break;
          label1154:
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
  
  public void setCallBack(arxd paramarxd)
  {
    this.jdField_a_of_type_Arxd = paramarxd;
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