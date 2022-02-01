package com.tencent.mobileqq.flashchat;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.util.MQLruCache;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.apollo.aio.api.IApolloAIOHelper;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.hiboom.HiBoomConstants;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.AccessibilityUtils;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import mqq.app.MobileQQ;

@TargetApi(11)
public class FlashChatPanel
  extends RelativeLayout
  implements View.OnClickListener, ViewPager.OnPageChangeListener, OnHolderItemClickListener, TabBarView.OnTabChangeListener, Runnable
{
  public static final int d;
  public static final int e;
  public static int f;
  public static final int g;
  public static final int h = BaseChatItemLayout.h + BaseChatItemLayout.m;
  protected static final int i = BaseChatItemLayout.i + BaseChatItemLayout.n;
  public static final int j = BaseChatItemLayout.j + BaseChatItemLayout.o;
  public static final int k = BaseChatItemLayout.k + BaseChatItemLayout.p;
  int jdField_a_of_type_Int;
  public View a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  public ETTextView a;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  ArkAppLoadLayout jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
  public ArkAppRootLayout a;
  ArkAppView jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
  public MessageForArkFlashChat a;
  public HiBoomTextView a;
  QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = null;
  TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = null;
  public HashMap<Integer, ArkFlashChatContainerWrapper> a;
  public Random a;
  public boolean a;
  public int[] a;
  public FlashChatTextEffectView[] a;
  int b;
  public View b;
  public HashMap<Integer, ArkFlashChatContainerWrapper> b;
  int c = -1;
  int l = -1;
  public int m = 0;
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    d = AIOUtils.b(400.0F, localResources);
    g = AIOUtils.b(1.0F, localResources);
    e = (localResources.getDisplayMetrics().widthPixels - g * 2) / 3;
    f = AIOUtils.b(100.0F, localResources);
  }
  
  public FlashChatPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView = new FlashChatTextEffectView[2];
    this.jdField_a_of_type_JavaUtilRandom = new Random();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    this.jdField_a_of_type_Boolean = false;
  }
  
  public FlashChatPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView = new FlashChatTextEffectView[2];
    this.jdField_a_of_type_JavaUtilRandom = new Random();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    this.jdField_a_of_type_Boolean = false;
  }
  
  public FlashChatPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView = new FlashChatTextEffectView[2];
    this.jdField_a_of_type_JavaUtilRandom = new Random();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static float a()
  {
    float f1 = MobileQQ.sMobileQQ.getResources().getDisplayMetrics().scaledDensity;
    return ArkAppCenterUtil.jdField_b_of_type_Int + f1 * 20.0F;
  }
  
  private void a(QQAppInterface paramQQAppInterface, View paramView, Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if (paramView == null) {
        return;
      }
      paramQQAppInterface = new Rect();
      paramDrawable.getPadding(paramQQAppInterface);
      int n = paramView.getPaddingTop();
      int i1 = paramQQAppInterface.top;
      int i2 = paramView.getPaddingLeft();
      int i3 = paramQQAppInterface.left;
      int i4 = paramView.getPaddingRight();
      int i5 = paramQQAppInterface.right;
      int i6 = paramView.getPaddingBottom();
      int i7 = paramQQAppInterface.bottom;
      paramView.setBackgroundDrawable(paramDrawable);
      paramView.setPadding(i2 + i3, n + i1, i4 + i5, i6 + i7);
    }
  }
  
  private void a(FlashChatItem paramFlashChatItem)
  {
    Object localObject2 = com.tencent.mobileqq.text.TextUtils.getTextWithoutEmoji(HiBoomConstants.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()));
    Object localObject1 = localObject2;
    if (android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = HardCodeUtil.a(2131704723);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateHiBoomPreview item = ");
      ((StringBuilder)localObject2).append(paramFlashChatItem);
      QLog.d("HiBoomFont.panel", 2, ((StringBuilder)localObject2).toString());
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setHiBoom(paramFlashChatItem.id, 0, HiBoomConstants.b);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setText((CharSequence)localObject1);
  }
  
  public static float b()
  {
    return a() * 3.0F / 4.0F;
  }
  
  public RelativeLayout a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      Object localObject2 = getContext();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from((Context)localObject2).inflate(2131561098, null));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364703).setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364262);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365421)).setImageDrawable(FaceDrawable.getFaceDrawable((AppInterface)localObject1, 1, ((QQAppInterface)localObject1).getCurrentUin()));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362973).setPadding(0, 0, 0, 0);
      Object localObject3 = (ArkAppLoadLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370350);
      Object localObject4 = (RelativeLayout.LayoutParams)((ArkAppLoadLayout)localObject3).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject4).setMargins(5, 5, 5, 5);
      ((ArkAppLoadLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378635));
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(((Context)localObject2).getResources().getColorStateList(2131167075));
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(((Context)localObject2).getResources().getColorStateList(2131167068));
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setMaxWidth(BaseChatItemLayout.e);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setMovementMethod(LinkMovementMethod.getInstance());
      if (GlobalImageCache.a != null)
      {
        localObject2 = (Drawable.ConstantState)GlobalImageCache.a.get("bubblebg://default_mine");
        if (localObject2 != null)
        {
          QLog.isColorLevel();
          ((Drawable.ConstantState)localObject2).newDrawable();
        }
      }
      localObject2 = ((QQAppInterface)localObject1).getApp().getResources();
      localObject3 = ((Resources)localObject2).getDrawable(2130850336);
      localObject4 = ((Resources)localObject2).getDrawable(2130850335);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject3);
      localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject4);
      if (GlobalImageCache.a != null)
      {
        QLog.isColorLevel();
        GlobalImageCache.a.put("bubblebg://default_mine", localStateListDrawable.getConstantState());
      }
      a((QQAppInterface)localObject1, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, localStateListDrawable);
      localObject1 = ((Resources)localObject2).getColorStateList(2131167079);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setPadding(j, h, k, i);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor((ColorStateList)localObject1);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout = ((ArkAppRootLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362960));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362947));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370350));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setClipRadius(14.0F);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setBorderType(2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setAlignLeft(false);
      new FlashChatPanel.arkViewOnLongClickAndTouchListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setCallback(new FlashChatPanel.2(this));
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = ((HiBoomTextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368171));
    }
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public FlashChatItem a()
  {
    return a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
  }
  
  public FlashChatItem a(int paramInt1, int paramInt2)
  {
    try
    {
      FlashChatItem localFlashChatItem = this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView[paramInt1].a(paramInt2);
      return localFlashChatItem;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("recordChoose ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" ");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append("");
        localStringBuilder.append(paramInt2);
        QLog.i("FlashChat", 2, localStringBuilder.toString());
      }
    }
    return null;
  }
  
  public Pair<Integer, Integer> a(int paramInt)
  {
    Object localObject = new ArrayList();
    for (;;)
    {
      int n;
      try
      {
        FlashChatTextEffectView localFlashChatTextEffectView = this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView[paramInt];
        if (localFlashChatTextEffectView != null)
        {
          n = 0;
          if (n < localFlashChatTextEffectView.a())
          {
            FlashChatItem localFlashChatItem = localFlashChatTextEffectView.a(n);
            if ((FlashChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFlashChatItem) != null) || (localFlashChatItem.id == -100000)) {
              break label152;
            }
            ((ArrayList)localObject).add(new Pair(Integer.valueOf(paramInt), Integer.valueOf(n)));
            break label152;
          }
        }
        if (((ArrayList)localObject).isEmpty()) {
          return null;
        }
        n = this.jdField_a_of_type_JavaUtilRandom.nextInt(((ArrayList)localObject).size());
        paramInt = n;
        if (this.l == n) {
          paramInt = (n + 1) / ((ArrayList)localObject).size();
        }
        this.l = paramInt;
        localObject = (Pair)((ArrayList)localObject).get(paramInt);
        return localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      label152:
      n += 1;
    }
  }
  
  public void a()
  {
    FlashChatItem localFlashChatItem = a();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("recordChoose");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(" ");
      localStringBuilder.append(localFlashChatItem);
      QLog.i("FlashChat", 1, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (localFlashChatItem != null) {
      localStringBuilder.append(this.jdField_b_of_type_Int);
    } else {
      localStringBuilder.append(this.c);
    }
    localStringBuilder.append(":");
    if (localFlashChatItem == null) {
      localStringBuilder.append(-1);
    } else {
      localStringBuilder.append(localFlashChatItem.id);
    }
    ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a(localStringBuilder.toString());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, false);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("selectItem ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.d("FlashChat", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = a(paramInt1, paramInt2);
    int n = 0;
    if (localObject2 != null)
    {
      if (((FlashChatItem)localObject2).id == -100000)
      {
        localObject1 = a(paramInt1);
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FlashChat", 2, "random empty");
          }
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("random");
          ((StringBuilder)localObject2).append(((Pair)localObject1).first);
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(((Pair)localObject1).second);
          QLog.d("FlashChat", 2, ((StringBuilder)localObject2).toString());
          a(((Integer)((Pair)localObject1).first).intValue(), ((Integer)((Pair)localObject1).second).intValue());
        }
      }
      else if (paramInt1 == 0)
      {
        localObject1 = FlashChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FlashChatItem)localObject2);
        if (localObject1 != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("mvip.g.a.sl_");
          localStringBuilder.append(((FlashChatItem)localObject2).id);
          localObject2 = localStringBuilder.toString();
          VasH5PayUtil.a(getContext(), (String)localObject2, (String)localObject1, 0, false, false);
          return;
        }
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(this.jdField_b_of_type_Int, false);
        }
        setupArkUI((FlashChatItem)localObject2);
      }
      else if (paramInt1 == 1)
      {
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(paramInt1, false);
        }
        a((FlashChatItem)localObject2);
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((String)localObject2).trim();
      }
      localObject2 = localObject1;
      if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = HardCodeUtil.a(2131704714);
      }
      if (QLog.isColorLevel()) {
        QLog.d("FlashChat", 2, "cancelChoose");
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText((CharSequence)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      if ((paramBoolean) && (paramInt1 >= 0) && (paramInt1 <= 1)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(paramInt1, false);
      }
    }
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt1;
    paramInt1 = n;
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView;
      if (paramInt1 >= localObject1.length) {
        break;
      }
      localObject1 = localObject1[paramInt1];
      if (localObject1 != null) {
        if (paramInt1 != this.jdField_b_of_type_Int) {
          ((FlashChatTextEffectView)localObject1).a(-1);
        } else {
          ((FlashChatTextEffectView)localObject1).a(paramInt2);
        }
      }
      paramInt1 += 1;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (AppSetting.d) {
      try
      {
        FlashChatItem localFlashChatItem = a(paramInt2, paramInt1);
        if (localFlashChatItem != null) {
          AccessibilityUtils.a(paramView, localFlashChatItem.name);
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
    a(paramInt2, paramInt1);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1;
    Object localObject3;
    int i2;
    if (paramBoolean)
    {
      com.tencent.widget.XPanelContainer.jdField_a_of_type_Int = (int)(getResources().getDisplayMetrics().density * 246.0F);
      localObject1 = a(true);
      localObject3 = ((RelativeLayout)localObject1).getParent();
      i2 = -1;
      if (localObject3 == null)
      {
        localObject3 = new RelativeLayout.LayoutParams(-1, -1);
        ((FrameLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131373031)).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      }
      else
      {
        ((RelativeLayout)localObject1).setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131367417).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
      {
        this.m = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
      }
      localObject1 = (IApolloAIOHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(8);
      if (localObject1 != null) {
        ((IApolloAIOHelper)localObject1).showApolloView(false);
      }
      localObject1 = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(52);
      if (localObject1 != null) {
        ((AIOShortcutBarHelper)localObject1).c(11);
      }
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString();
      localObject1 = localObject3;
      if (localObject3 != null) {
        localObject1 = ((String)localObject3).trim();
      }
      if ((localObject1 != null) && (((String)localObject1).length() != 0) && (((String)localObject1).length() <= 20)) {
        this.jdField_b_of_type_AndroidViewView.setEnabled(true);
      } else {
        this.jdField_b_of_type_AndroidViewView.setEnabled(false);
      }
      localObject1 = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).b();
      if (localObject1 == null) {
        break label790;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((String)localObject1).split(":");
        if (localObject1.length != 2) {
          break label790;
        }
        n = Integer.valueOf(localObject1[0]).intValue();
        i1 = n;
        try
        {
          i3 = Integer.valueOf(localObject1[1]).intValue();
          i1 = n;
          localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView[n];
          i4 = n;
          i1 = i2;
          if (localObject1 == null) {
            continue;
          }
          i2 = -1;
          i1 = 0;
          try
          {
            if (i1 < ((FlashChatTextEffectView)localObject1).a())
            {
              localObject3 = ((FlashChatTextEffectView)localObject1).a(i1);
              if (n == 0)
              {
                i4 = i2;
                if (FlashChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FlashChatItem)localObject3) == null)
                {
                  i4 = i2;
                  if (localObject3 != null)
                  {
                    i4 = i2;
                    if (((FlashChatItem)localObject3).id == i3) {
                      i4 = i1;
                    }
                  }
                }
              }
              else
              {
                i4 = i2;
                if (n == 1)
                {
                  i4 = i2;
                  if (localObject3 != null)
                  {
                    int i5 = ((FlashChatItem)localObject3).id;
                    i4 = i2;
                    if (i5 == i3)
                    {
                      i4 = n;
                      continue;
                    }
                  }
                }
              }
              i1 += 1;
              i2 = i4;
            }
            else
            {
              i1 = i2;
              i4 = n;
            }
          }
          catch (Exception localException1) {}
          localException2.printStackTrace();
        }
        catch (Exception localException2)
        {
          n = i1;
        }
      }
      catch (Exception localException3)
      {
        int i1;
        int i4;
        Object localObject2;
        n = -1;
        continue;
      }
      i1 = i2;
      i4 = n;
      a(i4, i1, true);
      if (i4 == 0)
      {
        localObject2 = (FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
        if (((FlashChatManager)localObject2).a().size() < 3)
        {
          ((FlashChatManager)localObject2).c();
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setVisibility(0);
          localObject2 = (IApolloAIOHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(8);
          if (localObject2 != null) {
            ((IApolloAIOHelper)localObject2).showApolloView(true);
          }
          localObject2 = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(52);
          if (localObject2 != null) {
            ((AIOShortcutBarHelper)localObject2).c(12);
          }
          localObject2 = a(false);
          if (localObject2 != null) {
            ((RelativeLayout)localObject2).setVisibility(8);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131367417).setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(this.m);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView != null)
          {
            localObject2 = this.jdField_b_of_type_JavaUtilHashMap.values().iterator();
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (ArkFlashChatContainerWrapper)((Iterator)localObject2).next();
              if (localObject3 == null) {
                continue;
              }
              ((ArkFlashChatContainerWrapper)localObject3).doOnEvent(2);
              continue;
            }
            this.jdField_b_of_type_JavaUtilHashMap.clear();
          }
          if (QLog.isColorLevel()) {
            QLog.i("FlashChat", 2, "restore layout");
          }
        }
      }
      return;
      label790:
      int i3 = -1;
      int n = -1;
    }
  }
  
  public boolean a()
  {
    if (getVisibility() != 0) {
      return false;
    }
    if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString())) {
      return false;
    }
    a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.R();
    return true;
  }
  
  public void b()
  {
    a(this.jdField_b_of_type_Int, -1);
    a();
    QQToast.a(getContext(), HardCodeUtil.a(2131704713), 0).a();
  }
  
  public void b(View paramView, int paramInt1, int paramInt2) {}
  
  public void c()
  {
    a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.Q();
    a(false);
  }
  
  public void onClick(View paramView)
  {
    int n = paramView.getId();
    if (n != 2131364262)
    {
      if (n != 2131364703)
      {
        if (n != 2131377197)
        {
          RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
        }
        else
        {
          a();
          c();
        }
      }
      else
      {
        c();
        this.jdField_a_of_type_Boolean = true;
      }
    }
    else {
      b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = paramMotionEvent.getAction() & 0xFF;
    if (n == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    } else if ((n == 1) || (n == 3)) {
      getParent().requestDisallowInterceptTouchEvent(false);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(paramInt, false);
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt2, true);
    this.c = paramInt2;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void run()
  {
    Object localObject = a(false);
    if (localObject == null) {
      return;
    }
    localObject = ((View)localObject).getLayoutParams();
    if (localObject != null)
    {
      ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131368875)).getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      ((ViewGroup.LayoutParams)localObject).height = (this.jdField_a_of_type_ArrayOfInt[1] - ImmersiveUtils.getStatusBarHeight(getContext()));
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      a(true);
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    a(false);
  }
  
  public void setupArkUI(FlashChatItem paramFlashChatItem)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    Object localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = ((String)localObject2).trim();
    }
    localObject2 = localObject1;
    if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = HardCodeUtil.a(2131704715);
    }
    if (paramFlashChatItem.id == -100000)
    {
      n = this.jdField_a_of_type_JavaUtilRandom.nextInt(2);
      int i1 = this.jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView[n].a());
      if (QLog.isColorLevel())
      {
        paramFlashChatItem = new StringBuilder();
        paramFlashChatItem.append("setupArkUI  random ");
        paramFlashChatItem.append(n);
        paramFlashChatItem.append(" ");
        paramFlashChatItem.append(i1);
        QLog.d("FlashChat", 2, paramFlashChatItem.toString());
      }
      a(n, i1);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setupArkUI");
      ((StringBuilder)localObject1).append(paramFlashChatItem);
      QLog.d("FlashChat", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.setVisibility(0);
    int n = paramFlashChatItem.id;
    ArkAppView localArkAppView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    if (localArkAppView != null)
    {
      Object localObject3 = (ArkFlashChatContainerWrapper)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(n));
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = new ArkFlashChatContainerWrapper();
        this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(n), localObject1);
      }
      localObject3 = new MessageForArkFlashChat();
      ((MessageForArkFlashChat)localObject3).uniseq = n;
      ((MessageForArkFlashChat)localObject3).ark_app_message = new ArkFlashChatMessage();
      ((MessageForArkFlashChat)localObject3).ark_app_message.promptText = ((String)localObject2);
      ((MessageForArkFlashChat)localObject3).arkContainer = ((ArkFlashChatContainerWrapper)localObject1);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat = ((MessageForArkFlashChat)localObject3);
      ((ArkFlashChatContainerWrapper)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), paramFlashChatItem.appName, paramFlashChatItem.mainView, paramFlashChatItem.ver, paramFlashChatItem.id, ((MessageForArkFlashChat)localObject3).ark_app_message.getMeta(((MessageForArkFlashChat)localObject3).uniseq, false), getContext().getResources().getDisplayMetrics().scaledDensity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), a(), b(), a(), b(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat);
      localArkAppView.a((ArkAppContainer)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
      localArkAppView.setCallback(new FlashChatPanel.1(this, paramFlashChatItem, (MessageForArkFlashChat)localObject2, (MessageForArkFlashChat)localObject3));
      localArkAppView.a((ArkAppContainer)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatPanel
 * JD-Core Version:    0.7.0.1
 */