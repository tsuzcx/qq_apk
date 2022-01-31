package com.tencent.mobileqq.emoticonview;

import acnh;
import acni;
import acnj;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
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
import com.tencent.mobileqq.activity.aio.rebuild.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerFrameLayout;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
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
  float jdField_a_of_type_Float;
  acnj jdField_a_of_type_Acnj;
  public Context a;
  public View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
  private EmojiStickerManager.StickerFrameLayout jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout;
  public EmoticonCallback a;
  private EmoticonInfo jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo;
  public EmoticonPanelLinearLayout.OnClickListener a;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  boolean jdField_b_of_type_Boolean = false;
  float c;
  public boolean c;
  float jdField_d_of_type_Float = 0.0F;
  private boolean jdField_d_of_type_Boolean;
  float jdField_e_of_type_Float = 0.0F;
  private boolean jdField_e_of_type_Boolean = true;
  public int f;
  private boolean f;
  public int g;
  private boolean g;
  private int h = -1;
  private int i;
  
  static
  {
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    jdField_d_of_type_Int = 3;
    jdField_e_of_type_Int = 4;
    jdField_a_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public EmoticonPanelLinearLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_g_of_type_Int = 0;
    a(paramContext);
  }
  
  public EmoticonPanelLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_g_of_type_Int = 0;
    a(paramContext);
  }
  
  public EmoticonPanelLinearLayout(Context paramContext, BaseChatPie paramBaseChatPie, int paramInt)
  {
    super(paramContext);
    this.jdField_g_of_type_Int = 0;
    a(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_g_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if (!(paramBaseChatPie instanceof FriendChatPie)) {
        break label86;
      }
      this.jdField_f_of_type_Int = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c;
      return;
      label86:
      if ((paramBaseChatPie instanceof BaseTroopChatPie)) {
        this.jdField_f_of_type_Int = 2;
      } else if ((paramBaseChatPie instanceof DiscussChatPie)) {
        this.jdField_f_of_type_Int = 3;
      }
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4)) > 50.0D;
  }
  
  View a(float paramFloat1, float paramFloat2)
  {
    int j = super.getChildCount() - 1;
    while (j >= 0)
    {
      View localView = super.getChildAt(j);
      float f1 = super.getScrollX() + paramFloat1 - localView.getLeft();
      float f2 = super.getScrollY() + paramFloat2 - localView.getTop();
      if ((f1 >= 0.0F) && (f1 <= localView.getWidth()) && (f2 >= 0.0F) && (f2 < localView.getHeight())) {
        return localView;
      }
      j -= 1;
    }
    return null;
  }
  
  public void a()
  {
    SessionInfo localSessionInfo;
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (!this.jdField_a_of_type_Boolean)) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a;
        if ((GoldMsgChatHelper.a(localSessionInfo)) || (!this.jdField_g_of_type_Boolean) || (!EmojiStickerManager.jdField_e_of_type_Boolean)) {
          break label75;
        }
        this.jdField_a_of_type_AndroidViewViewGroup.post(new acnh(this));
        EmojiStickerManager.jdField_b_of_type_Boolean = false;
      }
    }
    label75:
    while ((this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout == null) || (!this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) || (this.jdField_e_of_type_Boolean))
    {
      return;
      localSessionInfo = null;
      break;
    }
    this.jdField_e_of_type_Boolean = true;
    ((WindowManager)getContext().getSystemService("window")).removeViewImmediate(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo);
    }
    this.jdField_f_of_type_Boolean = false;
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
    Object localObject3 = paramView.getTag();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if ((localObject3 instanceof EmoticonInfo)) {
        localObject1 = (EmoticonInfo)localObject3;
      }
    }
    if (localObject1 != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$OnClickListener != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$OnClickListener.a(paramView, (EmoticonInfo)localObject1))) {}
      do
      {
        return;
        super.sendAccessibilityEvent(1);
        super.playSoundEffect(0);
        if (("delete".equals(((EmoticonInfo)localObject1).a)) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback == null)) {
          break label808;
        }
        if ("setting".equals(((EmoticonInfo)localObject1).a))
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.setting();
          return;
        }
        if ("add".equals(((EmoticonInfo)localObject1).a))
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.c();
          ReportController.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "ep_mall", "0X800579C", 0, 0, "", "", "", "");
          return;
        }
        if ("favEdit".equals(((EmoticonInfo)localObject1).a))
        {
          paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, FavEmosmManageActivity.class);
          this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
          ReportController.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "ep_mall", "0X800579E", 0, 0, "", "", "", "");
          return;
        }
        if ("funny_pic".equals(((EmoticonInfo)localObject1).a))
        {
          int k = 0;
          int j = k;
          if ("7.6.8".equals("7.3.5"))
          {
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("funny_pic_info", 0).edit();
            ((SharedPreferences.Editor)localObject1).putBoolean("group_emo_red_show_sp_key_" + ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getCurrentAccountUin(), false);
            ((SharedPreferences.Editor)localObject1).apply();
            paramView = paramView.findViewById(2131362075);
            j = k;
            if (paramView != null)
            {
              j = k;
              if (paramView.getVisibility() == 0)
              {
                j = 1;
                paramView.setVisibility(8);
              }
            }
          }
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickQLin", "0", 1, 0, j, "", "", "", "", "", "", "", 0, 0, 0, 0);
          PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, EmoticonGroupStoreFragment.class);
          return;
        }
        if (!"push".equals(((EmoticonInfo)localObject1).a)) {
          break;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback instanceof BaseChatPie)) {
          ((BaseChatPie)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback).l(9);
        }
        ReportController.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "ep_mall", "0X800579B", 0, 0, "", "", "", "");
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0);
        localObject2 = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getCurrentAccountUin();
      } while (!((SharedPreferences)localObject1).getBoolean("magic_promotion_is_new_content_" + (String)localObject2, false));
      paramView = (ImageView)paramView.findViewById(2131361968);
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelLinearLayout", 2, "emoticonImg:" + paramView);
      }
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844025);
      localObject3 = URLDrawable.getDrawable(((SharedPreferences)localObject1).getString("magic_promotion_imgUrl", ""), (URLDrawable.URLDrawableOptions)localObject3);
      if ((paramView != null) && (localObject3 != null)) {
        paramView.setImageDrawable((Drawable)localObject3);
      }
      ((SharedPreferences)localObject1).edit().putBoolean("magic_promotion_is_new_content_" + (String)localObject2, false).apply();
      return;
      if ((localObject1 instanceof PicEmoticonInfo))
      {
        paramView = (PicEmoticonInfo)localObject1;
        paramView.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo = null;
        localObject2 = paramView.jdField_a_of_type_ComTencentMobileqqDataEmoticon;
        ((EmoticonManager)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(13)).a(((Emoticon)localObject2).epId, this.jdField_g_of_type_Int, new acni(this, (Emoticon)localObject2, (EmoticonInfo)localObject1, paramView));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.a((EmoticonInfo)localObject1);
      return;
      label808:
      QLog.e("EmotionPanelLinearLayout", 1, "performclick callback = null");
      return;
    }
    QLog.e("EmotionPanelLinearLayout", 1, "performclick info = null");
  }
  
  public void a(View paramView, EmoticonInfo paramEmoticonInfo)
  {
    if ((paramView == null) || (paramEmoticonInfo == null))
    {
      QLog.e("EmotionPanelLinearLayout", 1, "showpoupemo view or info = null");
      return;
    }
    float f1 = getContext().getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.i = paramEmoticonInfo.jdField_c_of_type_Int;
    Object localObject1;
    Object localObject2;
    if ((paramEmoticonInfo instanceof PicEmoticonInfo))
    {
      localObject1 = (PicEmoticonInfo)paramEmoticonInfo;
      localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      if (((localObject2 instanceof QQAppInterface)) && (((PicEmoticonInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataEmoticon != null))
      {
        localObject2 = (EmoticonManager)((AppRuntime)localObject2).getManager(13);
        if (localObject2 != null)
        {
          localObject2 = ((EmoticonManager)localObject2).a(((PicEmoticonInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
          if (localObject2 != null)
          {
            if (((EmoticonPackage)localObject2).subType != 4) {
              break label239;
            }
            this.jdField_a_of_type_Boolean = true;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmotionPanelLinearLayout", 2, "showPopupEmo, PicEmoticonInfo isDiyEmotion = " + this.jdField_a_of_type_Boolean + " isSoundEmotion = " + this.jdField_b_of_type_Boolean);
      }
      localObject1 = ((PicEmoticonInfo)localObject1).a("fromAIO", true, false, null, (int)(110.0F * f1), (int)(110.0F * f1));
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label318;
      }
      QLog.e("EmotionPanelLinearLayout", 1, "showpoupemo drawable = null");
      return;
      label239:
      if (((EmoticonPackage)localObject2).subType != 1) {
        break;
      }
      this.jdField_b_of_type_Boolean = true;
      break;
      if ((paramEmoticonInfo instanceof FavoriteEmoticonInfo))
      {
        if (QLog.isColorLevel()) {
          QLog.i("EmotionPanelLinearLayout", 2, "showPopupEmo, FavoriteEmoticonInfo");
        }
        localObject1 = ((FavoriteEmoticonInfo)paramEmoticonInfo).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float, 0, 0);
      }
      else
      {
        localObject1 = paramEmoticonInfo.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float);
      }
    }
    label318:
    paramView.getGlobalVisibleRect(jdField_a_of_type_AndroidGraphicsRect);
    int j = paramEmoticonInfo.jdField_c_of_type_Int;
    label361:
    label748:
    int m;
    int k;
    label892:
    Object localObject3;
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (!this.jdField_a_of_type_Boolean)) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a;
        if ((GoldMsgChatHelper.a(paramView)) || (!EmojiStickerManager.jdField_e_of_type_Boolean)) {
          break label1393;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout = new EmojiStickerManager.StickerFrameLayout(getContext());
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setId(2131362314);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setTag(paramEmoticonInfo);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setTag(2131362320, Integer.valueOf(this.h));
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
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130844060));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getContext());
        paramView = new RelativeLayout.LayoutParams((int)(20.0F * this.jdField_a_of_type_Float), (int)(20.0F * this.jdField_a_of_type_Float));
        paramView.addRule(11);
        paramView.addRule(12);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, paramView);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130845026));
        this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout);
        this.jdField_g_of_type_Boolean = true;
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
        this.jdField_f_of_type_Boolean = false;
        EmojiStickerManager.jdField_b_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout == null) {
          break label1494;
        }
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        m = (int)(5.0F * f1);
        paramView = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        if ((j != 1) && (j != 2) && (j != 7) && (j != 10)) {
          break label1496;
        }
        k = (int)(64.0F * f1);
        j = (int)(71.0F * f1);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setBackgroundResource(2130837577);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setPadding(m, m, m, m);
        paramView.width = ((int)(28.0F * f1));
        paramView.height = ((int)(28.0F * f1));
        paramView.bottomMargin = ((int)(6.0F * f1));
        paramView.addRule(14);
        paramView.addRule(15);
        if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Boolean)) {
          break label1603;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
          break label1598;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a;
        label921:
        if ((GoldMsgChatHelper.a(paramView)) || (!this.jdField_g_of_type_Boolean) || (!EmojiStickerManager.jdField_e_of_type_Boolean)) {
          break label1603;
        }
        paramView = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLayoutParams();
        paramView.leftMargin = (jdField_a_of_type_AndroidGraphicsRect.left - (k - jdField_a_of_type_AndroidGraphicsRect.width()) / 2);
        paramView.topMargin = (jdField_a_of_type_AndroidGraphicsRect.top - j - (int)(15.0F * f1));
        paramView.width = k;
        paramView.height = j;
        label1006:
        if (!this.jdField_f_of_type_Boolean) {
          break label1677;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.requestLayout();
        label1020:
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo = paramEmoticonInfo;
        if ((localObject2 != null) && (((EmoticonInfo)localObject2).jdField_c_of_type_Int == 6) && ((localObject2 instanceof PicEmoticonInfo)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
        }
        if ((paramEmoticonInfo.jdField_c_of_type_Int == 6) && ((paramEmoticonInfo instanceof PicEmoticonInfo)) && ((localObject1 instanceof URLDrawable)))
        {
          paramView = (PicEmoticonInfo)paramEmoticonInfo;
          if (paramView.a())
          {
            localObject3 = EmoticonUtils.o.replace("[epId]", paramView.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", paramView.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(getContext(), null);
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a((String)localObject3);
            PicEmoticonInfo.a((URLDrawable)localObject1);
          }
          if (2 == paramView.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType) {
            ReportController.b(null, "CliOper", "", "", "MbYulan", "MbChangan", 0, 0, paramView.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, "", "", "");
          }
        }
        if ((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo))
        {
          paramView = (SystemAndEmojiEmoticonInfo)paramEmoticonInfo;
          localObject3 = BaseApplicationImpl.getApplication();
          if (localObject3 != null)
          {
            localObject3 = ((BaseApplicationImpl)localObject3).getRuntime();
            if ((localObject3 != null) && ((localObject3 instanceof QQAppInterface)))
            {
              localObject3 = (QQAppInterface)localObject3;
              if (TextUtils.a(paramView.jdField_b_of_type_Int))
              {
                if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a == null)) {
                  break label1754;
                }
                j = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.a);
                label1315:
                k = paramView.jdField_b_of_type_Int;
                if (!ApolloGameUtil.a((QQAppInterface)localObject3)) {
                  break label1760;
                }
              }
            }
          }
        }
      }
    }
    label1494:
    label1496:
    label1754:
    label1760:
    for (paramView = "1";; paramView = "0")
    {
      VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "0X800812D", j, 0, new String[] { String.valueOf(k), paramView });
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.a((EmoticonInfo)localObject2, paramEmoticonInfo, (Drawable)localObject1);
      return;
      paramView = null;
      break label361;
      label1393:
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        break label748;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout = new EmojiStickerManager.StickerFrameLayout(getContext());
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setTag(paramEmoticonInfo);
      this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
      this.jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(false);
      this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout);
      break label748;
      break;
      k = (int)(110.0F * f1);
      j = (int)(110.0F * f1);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setBackgroundResource(2130837576);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setPadding(m, m, m, m);
      paramView.bottomMargin = 0;
      paramView.width = ((int)(100.0F * f1));
      paramView.height = ((int)(100.0F * f1));
      ReportController.b(null, "CliOper", "", "", "ep_mall", "ep_preview", 0, 0, "", "", "", "");
      break label892;
      paramView = null;
      break label921;
      paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLayoutParams();
      paramView.gravity = 51;
      paramView.leftMargin = (jdField_a_of_type_AndroidGraphicsRect.left - (k - jdField_a_of_type_AndroidGraphicsRect.width()) / 2);
      paramView.topMargin = (jdField_a_of_type_AndroidGraphicsRect.top - j - (int)(15.0F * f1));
      paramView.width = k;
      paramView.height = j;
      break label1006;
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
        break label1020;
      }
      paramView = (WindowManager)getContext().getSystemService("window");
      j = 40;
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        j = 67108904;
      }
      localObject2 = new WindowManager.LayoutParams(-1, -1, 2, j, -3);
      paramView.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject2);
      this.jdField_e_of_type_Boolean = false;
      this.jdField_f_of_type_Boolean = true;
      break label1020;
      j = -1;
      break label1315;
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
    Object localObject1;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 1: 
    case 0: 
    case 3: 
      for (;;)
      {
        return true;
        if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Acnj != null)) {
          removeCallbacks(this.jdField_a_of_type_Acnj);
        }
        if ((this.jdField_a_of_type_AndroidViewView != null) && (!this.jdField_c_of_type_Boolean)) {
          a(this.jdField_a_of_type_AndroidViewView);
        }
        if (!this.jdField_d_of_type_Boolean) {
          a();
        }
        this.jdField_a_of_type_AndroidViewView = null;
        if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (!this.jdField_a_of_type_Boolean))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
          for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a; (!GoldMsgChatHelper.a((SessionInfo)localObject1)) && (EmojiStickerManager.jdField_e_of_type_Boolean); localObject1 = null)
          {
            this.jdField_a_of_type_AndroidViewViewGroup.onTouchEvent(paramMotionEvent);
            break;
          }
          this.jdField_d_of_type_Float = paramMotionEvent.getRawX();
          this.jdField_e_of_type_Float = paramMotionEvent.getRawY();
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidViewView = a(paramMotionEvent.getX(), paramMotionEvent.getY());
          if (this.jdField_a_of_type_AndroidViewView != null)
          {
            if (this.jdField_a_of_type_Acnj == null) {
              this.jdField_a_of_type_Acnj = new acnj(this, paramMotionEvent);
            }
            this.jdField_a_of_type_Acnj.a();
            postDelayed(this.jdField_a_of_type_Acnj, ViewConfiguration.getLongPressTimeout());
            continue;
            super.setPressed(false);
            if (this.jdField_a_of_type_Acnj != null) {
              removeCallbacks(this.jdField_a_of_type_Acnj);
            }
            if (!this.jdField_d_of_type_Boolean) {
              a();
            }
            this.jdField_a_of_type_AndroidViewView = null;
          }
        }
      }
    }
    if (this.jdField_c_of_type_Boolean)
    {
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      if ((EmojiStickerManager.jdField_e_of_type_Boolean) && (a(this.jdField_d_of_type_Float, this.jdField_e_of_type_Float, f1, f2)) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout != null))
      {
        if ((this.jdField_d_of_type_Boolean) || (!this.jdField_g_of_type_Boolean)) {
          break label1049;
        }
        localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLayoutParams();
        if ((this.i == 1) || (this.i == 2) || (this.i == 7) || (this.i == 10))
        {
          ((RelativeLayout.LayoutParams)localObject1).width = ((int)(110.0F * this.jdField_a_of_type_Float));
          ((RelativeLayout.LayoutParams)localObject1).height = ((int)(110.0F * this.jdField_a_of_type_Float));
        }
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)f1 - ((RelativeLayout.LayoutParams)localObject1).width / 2);
        if (((RelativeLayout.LayoutParams)localObject1).leftMargin + ((RelativeLayout.LayoutParams)localObject1).width > this.jdField_c_of_type_Float) {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)this.jdField_c_of_type_Float - ((RelativeLayout.LayoutParams)localObject1).width);
        }
        ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)f2 - ((RelativeLayout.LayoutParams)localObject1).height / 2 - ImmersiveUtils.a(getContext()));
        if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (((RelativeLayout.LayoutParams)localObject1).topMargin + ((RelativeLayout.LayoutParams)localObject1).height > this.jdField_a_of_type_AndroidViewViewGroup.getMeasuredHeight()))
        {
          if (ImmersiveUtils.isSupporImmersive() != 1) {
            break label1030;
          }
          ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)this.jdField_b_of_type_Float - ((RelativeLayout.LayoutParams)localObject1).height - ImmersiveUtils.a(getContext()));
        }
        label556:
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setBackgroundResource(0);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.requestLayout();
        if ((this.jdField_a_of_type_AndroidViewViewGroup instanceof TopGestureLayout))
        {
          localObject1 = ((TopGestureLayout)this.jdField_a_of_type_AndroidViewViewGroup).getGestureDetector();
          if ((localObject1 instanceof StickerGestureDetector))
          {
            localObject1 = (StickerGestureDetector)localObject1;
            ((StickerGestureDetector)localObject1).jdField_a_of_type_Float = f1;
            ((StickerGestureDetector)localObject1).jdField_b_of_type_Float = f2;
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
            if (((EmoticonMainPanel)localObject1).b == null)
            {
              localObject2 = new LinearLayout(getContext());
              ((LinearLayout)localObject2).setBackgroundColor(-1);
              ((LinearLayout)localObject2).getBackground().setAlpha(0);
              ((LinearLayout)localObject2).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
              ((EmoticonMainPanel)localObject1).b = ((View)localObject2);
            }
            if (((EmoticonMainPanel)localObject1).b.getParent() != localObject1) {
              ((EmoticonMainPanel)localObject1).addView(((EmoticonMainPanel)localObject1).b);
            }
            Object localObject2 = PropertyValuesHolder.ofInt("alpha", new int[] { 0, 178 });
            ObjectAnimator.ofPropertyValuesHolder(((EmoticonMainPanel)localObject1).b.getBackground(), new PropertyValuesHolder[] { localObject2 }).setDuration(500L).start();
          }
        }
        this.jdField_d_of_type_Boolean = true;
      }
    }
    label795:
    label832:
    do
    {
      do
      {
        if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
            break label1239;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a;
          if ((!GoldMsgChatHelper.a((SessionInfo)localObject1)) && (this.jdField_g_of_type_Boolean) && (EmojiStickerManager.jdField_e_of_type_Boolean)) {
            this.jdField_a_of_type_AndroidViewViewGroup.onTouchEvent(paramMotionEvent);
          }
        }
        if (((this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)) && (EmojiStickerManager.jdField_e_of_type_Boolean)) {
          break;
        }
        if ((!this.jdField_c_of_type_Boolean) || ((a(this.jdField_a_of_type_AndroidViewView, jdField_a_of_type_AndroidGraphicsRect)) && (jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))) {
          break label1252;
        }
        this.jdField_a_of_type_AndroidViewView = a(paramMotionEvent.getX(), paramMotionEvent.getY());
        if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView.getTag() == null)) {
          break label1245;
        }
        paramMotionEvent = (EmoticonInfo)this.jdField_a_of_type_AndroidViewView.getTag();
        if ((paramMotionEvent == null) || ("delete".equals(paramMotionEvent.a)) || ("add".equals(paramMotionEvent.a)) || ("setting".equals(paramMotionEvent.a))) {
          break;
        }
        a(this.jdField_a_of_type_AndroidViewView, (EmoticonInfo)this.jdField_a_of_type_AndroidViewView.getTag());
        break;
        ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)this.jdField_b_of_type_Float - ((RelativeLayout.LayoutParams)localObject1).height);
        break label556;
      } while (this.jdField_g_of_type_Boolean);
      localObject1 = (EmoticonInfo)this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTag();
    } while (localObject1 == null);
    label1030:
    label1049:
    int j;
    switch (((EmoticonInfo)localObject1).jdField_c_of_type_Int)
    {
    case 3: 
    case 8: 
    default: 
      j = 7;
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage("", "Stick", "DragToAIOX", String.valueOf(this.jdField_f_of_type_Int), 0, 0, 0, "", "", String.valueOf(j), "", "", "", "", 0, 0, 0, 0);
      break label795;
      j = 1;
      continue;
      j = 2;
      continue;
      if (this.jdField_a_of_type_Boolean)
      {
        j = 3;
      }
      else
      {
        if (this.jdField_b_of_type_Boolean)
        {
          j = 6;
          continue;
          j = 4;
          continue;
          j = 5;
          continue;
          label1239:
          localObject1 = null;
          break label832;
          label1245:
          a();
          break;
          label1252:
          if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_AndroidViewView == null) || ((a(this.jdField_a_of_type_AndroidViewView, jdField_a_of_type_AndroidGraphicsRect)) && (jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))) {
            break;
          }
          this.jdField_a_of_type_AndroidViewView = null;
          break;
        }
        j = -1;
      }
    }
  }
  
  public void setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
  }
  
  public void setPanelType(int paramInt)
  {
    this.h = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout
 * JD-Core Version:    0.7.0.1
 */