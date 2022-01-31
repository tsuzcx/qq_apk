package com.tencent.mobileqq.flashchat;

import adjt;
import adjv;
import adjw;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.util.MQLruCache;
import android.support.v4.view.ViewPager.OnPageChangeListener;
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
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.hiboom.HiBoomItem;
import com.tencent.mobileqq.hiboom.HiBoomManager;
import com.tencent.mobileqq.hiboom.HiBoomPanelView;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
  implements ViewPager.OnPageChangeListener, View.OnClickListener, OnHolderItemClickListener, TabBarView.OnTabChangeListener, Runnable
{
  public static final int d;
  public static final int e;
  public static int f;
  public static final int g;
  public static final int h = BaseChatItemLayout.g + BaseChatItemLayout.l;
  protected static final int i = BaseChatItemLayout.h + BaseChatItemLayout.m;
  public static final int j = BaseChatItemLayout.i + BaseChatItemLayout.n;
  public static final int k = BaseChatItemLayout.j + BaseChatItemLayout.o;
  int jdField_a_of_type_Int;
  public View a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  public ETTextView a;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  ArkAppLoadLayout jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
  public ArkAppRootLayout a;
  ArkAppView jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
  public MessageForArkFlashChat a;
  public HiBoomTextView a;
  public QQViewPager a;
  TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = null;
  public HashMap a;
  public Random a;
  public boolean a;
  public int[] a;
  public FlashChatTextEffectView[] a;
  int b;
  public View b;
  public HashMap b;
  int c = -1;
  int l = -1;
  public int m;
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    d = AIOUtils.a(400.0F, localResources);
    g = AIOUtils.a(1.0F, localResources);
    e = (localResources.getDisplayMetrics().widthPixels - g * 2) / 3;
    f = AIOUtils.a(100.0F, localResources);
  }
  
  public FlashChatPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView = new FlashChatTextEffectView[2];
    this.jdField_a_of_type_JavaUtilRandom = new Random();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[2];
  }
  
  public FlashChatPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView = new FlashChatTextEffectView[2];
    this.jdField_a_of_type_JavaUtilRandom = new Random();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[2];
  }
  
  public FlashChatPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView = new FlashChatTextEffectView[2];
    this.jdField_a_of_type_JavaUtilRandom = new Random();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[2];
  }
  
  public static float a()
  {
    return 20.0F * MobileQQ.sMobileQQ.getResources().getDisplayMetrics().scaledDensity + BaseChatItemLayout.e;
  }
  
  private void a(QQAppInterface paramQQAppInterface, View paramView, Drawable paramDrawable)
  {
    if ((paramDrawable == null) || (paramView == null)) {
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
    paramView.setPadding(i2 + i3, n + i1, i4 + i5, i7 + i6);
  }
  
  private void a(FlashChatItem paramFlashChatItem)
  {
    String str2 = com.tencent.mobileqq.text.TextUtils.e(HiBoomManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()));
    String str1 = str2;
    if (android.text.TextUtils.isEmpty(str2)) {
      str1 = "乐在沟通";
    }
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.panel", 2, "updateHiBoomPreview item = " + paramFlashChatItem);
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setHiBoom(paramFlashChatItem.jdField_a_of_type_Int, 1, HiBoomManager.a);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setText(str1);
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
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from((Context)localObject2).inflate(2130970340, null));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362868).setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370107);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363528)).setImageDrawable(FaceDrawable.a((AppInterface)localObject1, 1, ((QQAppInterface)localObject1).c()));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363311).setPadding(0, 0, 0, 0);
      Object localObject3 = (ArkAppLoadLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363313);
      Object localObject4 = (RelativeLayout.LayoutParams)((ArkAppLoadLayout)localObject3).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject4).setMargins(5, 5, 5, 5);
      ((ArkAppLoadLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370108));
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(((Context)localObject2).getResources().getColorStateList(2131494227));
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(((Context)localObject2).getResources().getColorStateList(2131494224));
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setSpannableFactory(QQText.a);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setMaxWidth(BaseChatItemLayout.d);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setMovementMethod(LinkMovementMethod.getInstance());
      if ((0 == 0) && (BaseApplicationImpl.sImageCache != null))
      {
        localObject2 = (Drawable.ConstantState)BaseApplicationImpl.sImageCache.get("bubblebg://default_mine");
        if (localObject2 != null)
        {
          if (QLog.isColorLevel()) {}
          ((Drawable.ConstantState)localObject2).newDrawable();
        }
      }
      localObject2 = ((QQAppInterface)localObject1).getApp().getResources();
      localObject3 = ((Resources)localObject2).getDrawable(2130845786);
      localObject4 = ((Resources)localObject2).getDrawable(2130845785);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject3);
      localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject4);
      if (BaseApplicationImpl.sImageCache != null)
      {
        if (QLog.isColorLevel()) {}
        BaseApplicationImpl.sImageCache.put("bubblebg://default_mine", localStateListDrawable.getConstantState());
      }
      a((QQAppInterface)localObject1, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, localStateListDrawable);
      localObject1 = ((Resources)localObject2).getColorStateList(2131494230);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setPadding(j, h, k, i);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor((ColorStateList)localObject1);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout = ((ArkAppRootLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363308));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363312));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363313));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setClipRadius(14.0F);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setBorderType(2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setAlignLeft(false);
      new FlashChatPanel.arkViewOnLongClickAndTouchListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setCallback(new adjv(this));
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = ((HiBoomTextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370109));
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
      if (QLog.isColorLevel()) {
        QLog.i("FlashChat", 2, "recordChoose " + paramInt1 + " " + this.jdField_a_of_type_Int + "" + paramInt2);
      }
    }
    return null;
  }
  
  public Pair a(int paramInt)
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
            if ((FlashChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFlashChatItem) != null) || (localFlashChatItem.jdField_a_of_type_Int == -100000)) {
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
    if (QLog.isColorLevel()) {
      QLog.i("FlashChat", 1, "recordChoose" + this.jdField_b_of_type_Int + " " + localFlashChatItem);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (localFlashChatItem != null)
    {
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(":");
      if (localFlashChatItem != null) {
        break label126;
      }
      localStringBuilder.append(-1);
    }
    for (;;)
    {
      ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216)).a(localStringBuilder.toString());
      return;
      localStringBuilder.append(this.c);
      break;
      label126:
      localStringBuilder.append(localFlashChatItem.jdField_a_of_type_Int);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, false);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int n = 0;
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "selectItem " + paramInt1 + " " + paramInt2);
    }
    Object localObject2 = a(paramInt1, paramInt2);
    Object localObject1;
    if (localObject2 != null) {
      if (((FlashChatItem)localObject2).jdField_a_of_type_Int == -100000)
      {
        localObject1 = a(paramInt1);
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FlashChat", 2, "random empty");
          }
          this.jdField_a_of_type_Int = paramInt2;
          this.jdField_b_of_type_Int = paramInt1;
          paramInt1 = n;
          label111:
          if (paramInt1 >= this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView.length) {
            break label225;
          }
          localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView[paramInt1];
          if (localObject1 != null)
          {
            if (paramInt1 == this.jdField_b_of_type_Int) {
              break label473;
            }
            ((FlashChatTextEffectView)localObject1).a(-1);
          }
        }
      }
    }
    for (;;)
    {
      paramInt1 += 1;
      break label111;
      QLog.d("FlashChat", 2, "random" + ((Pair)localObject1).first + " " + ((Pair)localObject1).second);
      a(((Integer)((Pair)localObject1).first).intValue(), ((Integer)((Pair)localObject1).second).intValue());
      label225:
      return;
      if (paramInt1 == 0)
      {
        localObject1 = FlashChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FlashChatItem)localObject2);
        if (localObject1 != null)
        {
          localObject2 = "mvip.g.a.sl_" + ((FlashChatItem)localObject2).jdField_a_of_type_Int;
          VasH5PayUtil.a(getContext(), (String)localObject2, (String)localObject1, 0, false, false);
          return;
        }
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(this.jdField_b_of_type_Int, false);
        }
        setupArkUI((FlashChatItem)localObject2);
        break;
      }
      if ((paramInt1 != 1) || (!(localObject2 instanceof HiBoomItem))) {
        break;
      }
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(paramInt1, false);
      }
      a((FlashChatItem)localObject2);
      break;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((String)localObject2).trim();
      }
      localObject2 = localObject1;
      if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "乐在沟通";
      }
      if (QLog.isColorLevel()) {
        QLog.d("FlashChat", 2, "cancelChoose");
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText((CharSequence)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      if ((!paramBoolean) || (paramInt1 < 0) || (paramInt1 > 1)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(paramInt1, false);
      break;
      label473:
      ((FlashChatTextEffectView)localObject1).a(paramInt2);
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (AppSetting.b) {}
    try
    {
      FlashChatItem localFlashChatItem = a(paramInt2, paramInt1);
      if (localFlashChatItem != null) {
        AccessibilityUtil.a(paramView, localFlashChatItem.b);
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
      }
    }
    a(paramInt2, paramInt1);
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131363035));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131366451));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131365527);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a("文本动效");
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a("嗨爆字体");
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setTabHeight(getContext().getResources().getDimensionPixelOffset(2131559418));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView[0] = new FlashChatTextEffectView(getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this, 0);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView[1] = new HiBoomPanelView(getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this, 1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(new adjw(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
  }
  
  public void a(boolean paramBoolean)
  {
    int i2 = -1;
    Object localObject1;
    Object localObject3;
    if (paramBoolean)
    {
      com.tencent.widget.XPanelContainer.jdField_a_of_type_Int = (int)(246.0F * getResources().getDisplayMetrics().density);
      localObject1 = a(true);
      if (((RelativeLayout)localObject1).getParent() == null)
      {
        localObject3 = new RelativeLayout.LayoutParams(-1, -1);
        ((FrameLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131363511)).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131363499).setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
        {
          this.m = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight();
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
        }
        ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131363503)).setImageResource(2130842528);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n.setContentDescription("已选定 文字输入 按钮");
        }
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131363502).getLayoutParams()).rightMargin = 0;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(false);
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString();
        localObject1 = localObject3;
        if (localObject3 != null) {
          localObject1 = ((String)localObject3).trim();
        }
        if ((localObject1 != null) && (((String)localObject1).length() != 0) && (((String)localObject1).length() <= 20)) {
          break label471;
        }
        this.jdField_b_of_type_AndroidViewView.setEnabled(false);
        label290:
        localObject1 = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216)).b();
        if (localObject1 == null) {
          break label819;
        }
      }
    }
    for (;;)
    {
      int n;
      int i3;
      for (;;)
      {
        int i1;
        try
        {
          localObject1 = ((String)localObject1).split(":");
          if (localObject1.length != 2) {
            break label819;
          }
          n = Integer.valueOf(localObject1[0]).intValue();
          i1 = n;
        }
        catch (Exception localException1)
        {
          int i4;
          int i5;
          label471:
          n = -1;
          i1 = i2;
        }
        try
        {
          i3 = Integer.valueOf(localObject1[1]).intValue();
          i1 = n;
          localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView[n];
          i1 = i2;
          if (localObject1 != null)
          {
            i2 = -1;
            i1 = 0;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject2;
            n = i1;
            i1 = i2;
          }
        }
        try
        {
          if (i1 >= ((FlashChatTextEffectView)localObject1).a()) {
            break label813;
          }
          localObject3 = ((FlashChatTextEffectView)localObject1).a(i1);
          if (n == 0)
          {
            i4 = i2;
            if (FlashChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FlashChatItem)localObject3) == null)
            {
              i4 = i2;
              if (localObject3 != null)
              {
                i5 = ((FlashChatItem)localObject3).jdField_a_of_type_Int;
                i4 = i2;
                if (i5 == i3) {
                  i4 = i1;
                }
              }
            }
            i1 += 1;
            i2 = i4;
            continue;
            ((RelativeLayout)localObject1).setVisibility(0);
            break;
            this.jdField_b_of_type_AndroidViewView.setEnabled(true);
            break label290;
          }
          i4 = i2;
          if (n == 1)
          {
            i4 = i2;
            if (localObject3 != null)
            {
              i5 = ((FlashChatItem)localObject3).jdField_a_of_type_Int;
              i4 = i2;
              if (i5 != i3) {}
            }
          }
        }
        catch (Exception localException3)
        {
          i1 = i2;
          break label572;
          i1 = i2;
        }
      }
      a(n, i1, true);
      if (n == 0)
      {
        localObject1 = (FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216);
        if (((FlashChatManager)localObject1).a().size() < 3) {
          ((FlashChatManager)localObject1).d();
        }
      }
      return;
      label572:
      localException1.printStackTrace();
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ag();
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131363502).getLayoutParams()).rightMargin = getContext().getResources().getDimensionPixelOffset(2131559416);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(true);
      }
      localObject2 = a(false);
      if (localObject2 != null) {
        ((RelativeLayout)localObject2).setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131363499).setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(this.m);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView != null)
      {
        localObject2 = this.jdField_b_of_type_JavaUtilHashMap.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ArkFlashChatContainerWrapper)((Iterator)localObject2).next();
          if (localObject3 != null) {
            ((ArkFlashChatContainerWrapper)localObject3).doOnEvent(2);
          }
        }
        this.jdField_b_of_type_JavaUtilHashMap.clear();
      }
      if (QLog.isColorLevel())
      {
        QLog.i("FlashChat", 2, "restore layout");
        return;
        label813:
        label819:
        i3 = -1;
        n = -1;
      }
    }
  }
  
  public boolean a()
  {
    if (getVisibility() != 0) {}
    while (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString())) {
      return false;
    }
    a();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ak();
    return true;
  }
  
  public void b()
  {
    a(this.jdField_b_of_type_Int, -1);
    a();
    QQToast.a(getContext(), "取消成功", 0).a();
  }
  
  public void b(View paramView, int paramInt1, int paramInt2) {}
  
  public boolean b()
  {
    RelativeLayout localRelativeLayout = a(false);
    if (localRelativeLayout == null) {}
    while (localRelativeLayout.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public void c()
  {
    a();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ai();
    a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ag();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ar();
    a();
    a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ag();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == paramView) {}
      return;
    case 2131365527: 
      a();
      c();
      return;
    case 2131362868: 
      c();
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    b();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = paramMotionEvent.getAction() & 0xFF;
    if (n == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((n == 1) || (n == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
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
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((View)localObject).getLayoutParams();
    } while (localObject == null);
    ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131363494)).getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    ((ViewGroup.LayoutParams)localObject).height = (this.jdField_a_of_type_ArrayOfInt[1] - ImmersiveUtils.a(getContext()));
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
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    Object localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = ((String)localObject2).trim();
    }
    if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = "乐在沟通";
    }
    for (;;)
    {
      int n;
      if (paramFlashChatItem.jdField_a_of_type_Int == -100000)
      {
        n = this.jdField_a_of_type_JavaUtilRandom.nextInt(2);
        int i1 = this.jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView[n].a());
        if (QLog.isColorLevel()) {
          QLog.d("FlashChat", 2, "setupArkUI  random " + n + " " + i1);
        }
        a(n, i1);
      }
      ArkAppView localArkAppView;
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("FlashChat", 2, "setupArkUI" + paramFlashChatItem);
        }
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.setVisibility(0);
        n = paramFlashChatItem.jdField_a_of_type_Int;
        localArkAppView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
      } while (localArkAppView == null);
      Object localObject3 = (ArkFlashChatContainerWrapper)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(n));
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = new ArkFlashChatContainerWrapper();
        this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(n), localObject2);
      }
      localObject3 = new MessageForArkFlashChat();
      ((MessageForArkFlashChat)localObject3).uniseq = n;
      ((MessageForArkFlashChat)localObject3).ark_app_message = new ArkFlashChatMessage();
      ((MessageForArkFlashChat)localObject3).ark_app_message.promptText = ((String)localObject1);
      ((MessageForArkFlashChat)localObject3).arkContainer = ((ArkFlashChatContainerWrapper)localObject2);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat = ((MessageForArkFlashChat)localObject3);
      ((ArkFlashChatContainerWrapper)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), paramFlashChatItem.jdField_a_of_type_JavaLangString, paramFlashChatItem.d, paramFlashChatItem.e, paramFlashChatItem.jdField_a_of_type_Int, ((MessageForArkFlashChat)localObject3).ark_app_message.getMeta(((MessageForArkFlashChat)localObject3).uniseq, false), getContext().getResources().getDisplayMetrics().scaledDensity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), a(), b(), a(), b(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat);
      localArkAppView.a((ArkAppContainer)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
      localArkAppView.setCallback(new adjt(this, (MessageForArkFlashChat)localObject1, (MessageForArkFlashChat)localObject3));
      localArkAppView.a((ArkAppContainer)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatPanel
 * JD-Core Version:    0.7.0.1
 */