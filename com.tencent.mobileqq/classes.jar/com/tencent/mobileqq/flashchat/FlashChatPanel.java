package com.tencent.mobileqq.flashchat;

import actj;
import adlj;
import aitx;
import ajya;
import alsz;
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
import android.text.TextUtils;
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
import apyu;
import apyv;
import apyx;
import apze;
import aqxj;
import aykk;
import aylc;
import baww;
import bayh;
import bbrk;
import bcql;
import bcsc;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.TabBarView;
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
  implements ViewPager.OnPageChangeListener, View.OnClickListener, apze, bcsc, Runnable
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
  public int m;
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    d = actj.a(400.0F, localResources);
    g = actj.a(1.0F, localResources);
    e = (localResources.getDisplayMetrics().widthPixels - g * 2) / 3;
    f = actj.a(100.0F, localResources);
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
  }
  
  public static float a()
  {
    return 20.0F * MobileQQ.sMobileQQ.getResources().getDisplayMetrics().scaledDensity + alsz.jdField_b_of_type_Int;
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
    String str2 = aylc.f(aqxj.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()));
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = ajya.a(2131704627);
    }
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.panel", 2, "updateHiBoomPreview item = " + paramFlashChatItem);
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setHiBoom(paramFlashChatItem.id, 0, aqxj.a);
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
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from((Context)localObject2).inflate(2131560768, null));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364258).setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363854);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364919)).setImageDrawable(bayh.a((AppInterface)localObject1, 1, ((QQAppInterface)localObject1).c()));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362789).setPadding(0, 0, 0, 0);
      Object localObject3 = (ArkAppLoadLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369476);
      Object localObject4 = (RelativeLayout.LayoutParams)((ArkAppLoadLayout)localObject3).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject4).setMargins(5, 5, 5, 5);
      ((ArkAppLoadLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377212));
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(((Context)localObject2).getResources().getColorStateList(2131166872));
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(((Context)localObject2).getResources().getColorStateList(2131166866));
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setSpannableFactory(aykk.a);
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
      localObject3 = ((Resources)localObject2).getDrawable(2130848935);
      localObject4 = ((Resources)localObject2).getDrawable(2130848934);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject3);
      localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject4);
      if (BaseApplicationImpl.sImageCache != null)
      {
        if (QLog.isColorLevel()) {}
        BaseApplicationImpl.sImageCache.put("bubblebg://default_mine", localStateListDrawable.getConstantState());
      }
      a((QQAppInterface)localObject1, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, localStateListDrawable);
      localObject1 = ((Resources)localObject2).getColorStateList(2131166876);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setPadding(j, h, k, i);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor((ColorStateList)localObject1);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout = ((ArkAppRootLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362778));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362768));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369476));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setClipRadius(14.0F);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setBorderType(2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setAlignLeft(false);
      new apyx(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setCallback(new apyv(this));
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = ((HiBoomTextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367512));
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
            if ((FlashChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFlashChatItem) != null) || (localFlashChatItem.id == -100000)) {
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
      ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(localStringBuilder.toString());
      return;
      localStringBuilder.append(this.c);
      break;
      label126:
      localStringBuilder.append(localFlashChatItem.id);
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
      if (((FlashChatItem)localObject2).id == -100000)
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
              break label469;
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
          localObject2 = "mvip.g.a.sl_" + ((FlashChatItem)localObject2).id;
          bbrk.a(getContext(), (String)localObject2, (String)localObject1, 0, false, false);
          return;
        }
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(this.jdField_b_of_type_Int, false);
        }
        setupArkUI((FlashChatItem)localObject2);
        break;
      }
      if (paramInt1 != 1) {
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
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = ajya.a(2131704618);
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
      label469:
      ((FlashChatTextEffectView)localObject1).a(paramInt2);
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (AppSetting.d) {}
    try
    {
      FlashChatItem localFlashChatItem = a(paramInt2, paramInt1);
      if (localFlashChatItem != null) {
        baww.a(paramView, localFlashChatItem.name);
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
        ((FrameLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131371906)).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131366883).setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
        {
          this.m = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight();
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aitx != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aitx.a(false);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.av();
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString();
        localObject1 = localObject3;
        if (localObject3 != null) {
          localObject1 = ((String)localObject3).trim();
        }
        if ((localObject1 != null) && (((String)localObject1).length() != 0) && (((String)localObject1).length() <= 20)) {
          break label410;
        }
        this.jdField_b_of_type_AndroidViewView.setEnabled(false);
        label229:
        localObject1 = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).b();
        if (localObject1 == null) {
          break label723;
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
            break label723;
          }
          n = Integer.valueOf(localObject1[0]).intValue();
          i1 = n;
        }
        catch (Exception localException1)
        {
          int i4;
          int i5;
          label410:
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
            break label717;
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
                i5 = ((FlashChatItem)localObject3).id;
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
            break label229;
          }
          i4 = i2;
          if (n == 1)
          {
            i4 = i2;
            if (localObject3 != null)
            {
              i5 = ((FlashChatItem)localObject3).id;
              i4 = i2;
              if (i5 != i3) {}
            }
          }
        }
        catch (Exception localException3)
        {
          i1 = i2;
          break label511;
          i1 = i2;
        }
      }
      a(n, i1, true);
      if (n == 0)
      {
        localObject1 = (FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217);
        if (((FlashChatManager)localObject1).a().size() < 3) {
          ((FlashChatManager)localObject1).c();
        }
      }
      return;
      label511:
      localException1.printStackTrace();
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aitx != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aitx.a(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.au();
      localObject2 = a(false);
      if (localObject2 != null) {
        ((RelativeLayout)localObject2).setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131366883).setVisibility(0);
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
        label717:
        label723:
        i3 = -1;
        n = -1;
      }
    }
  }
  
  public boolean a()
  {
    if (getVisibility() != 0) {}
    while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString())) {
      return false;
    }
    a();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c();
    return true;
  }
  
  public void b()
  {
    a(this.jdField_b_of_type_Int, -1);
    a();
    bcql.a(getContext(), ajya.a(2131704617), 0).a();
  }
  
  public void b(View paramView, int paramInt1, int paramInt2) {}
  
  public void c()
  {
    a();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ap();
    a(false);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == paramView) {}
      return;
    case 2131375842: 
      a();
      c();
      return;
    case 2131364258: 
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
    ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131368187)).getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    ((ViewGroup.LayoutParams)localObject).height = (this.jdField_a_of_type_ArrayOfInt[1] - ImmersiveUtils.getStatusBarHeight(getContext()));
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
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = ajya.a(2131704619);
    }
    for (;;)
    {
      int n;
      if (paramFlashChatItem.id == -100000)
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
        n = paramFlashChatItem.id;
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
      ((ArkFlashChatContainerWrapper)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), paramFlashChatItem.appName, paramFlashChatItem.mainView, paramFlashChatItem.ver, paramFlashChatItem.id, ((MessageForArkFlashChat)localObject3).ark_app_message.getMeta(((MessageForArkFlashChat)localObject3).uniseq, false), getContext().getResources().getDisplayMetrics().scaledDensity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), a(), b(), a(), b(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat);
      localArkAppView.a((adlj)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
      localArkAppView.setCallback(new apyu(this, paramFlashChatItem, (MessageForArkFlashChat)localObject1, (MessageForArkFlashChat)localObject3));
      localArkAppView.a((adlj)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatPanel
 * JD-Core Version:    0.7.0.1
 */