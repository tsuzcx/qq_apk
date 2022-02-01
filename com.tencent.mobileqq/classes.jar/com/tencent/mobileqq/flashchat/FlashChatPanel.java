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
  public static final int l;
  public static final int m;
  public static int n;
  public static final int o;
  public static final int u = BaseChatItemLayout.k + BaseChatItemLayout.n;
  protected static final int v = BaseChatItemLayout.l + BaseChatItemLayout.o;
  public static final int w = BaseChatItemLayout.getBubblePaddingAlignError() + BaseChatItemLayout.getTextPaddingAlignError();
  BaseChatPie A;
  public int[] B = new int[2];
  public int C = 0;
  public boolean D = false;
  QQViewPager a = null;
  TabBarView b = null;
  int c;
  int d = -1;
  int e = -1;
  RelativeLayout f = null;
  public View g;
  public ArkAppRootLayout h;
  public HiBoomTextView i;
  public ETTextView j;
  public View k;
  public FlashChatTextEffectView[] p = new FlashChatTextEffectView[2];
  public Random q = new Random();
  public HashMap<Integer, ArkFlashChatContainerWrapper> r = new HashMap();
  public MessageForArkFlashChat s;
  public HashMap<Integer, ArkFlashChatContainerWrapper> t = new HashMap();
  int x = -1;
  ArkAppView y;
  ArkAppLoadLayout z;
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    l = AIOUtils.b(400.0F, localResources);
    o = AIOUtils.b(1.0F, localResources);
    m = (localResources.getDisplayMetrics().widthPixels - o * 2) / 3;
    n = AIOUtils.b(100.0F, localResources);
  }
  
  public FlashChatPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public FlashChatPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FlashChatPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
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
      int i1 = paramView.getPaddingTop();
      int i2 = paramQQAppInterface.top;
      int i3 = paramView.getPaddingLeft();
      int i4 = paramQQAppInterface.left;
      int i5 = paramView.getPaddingRight();
      int i6 = paramQQAppInterface.right;
      int i7 = paramView.getPaddingBottom();
      int i8 = paramQQAppInterface.bottom;
      paramView.setBackgroundDrawable(paramDrawable);
      paramView.setPadding(i3 + i4, i1 + i2, i5 + i6, i7 + i8);
    }
  }
  
  private void a(FlashChatItem paramFlashChatItem)
  {
    Object localObject2 = com.tencent.mobileqq.text.TextUtils.getTextWithoutEmoji(HiBoomConstants.a(this.A.Y.getText().toString()));
    Object localObject1 = localObject2;
    if (android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = HardCodeUtil.a(2131902626);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateHiBoomPreview item = ");
      ((StringBuilder)localObject2).append(paramFlashChatItem);
      QLog.d("HiBoomFont.panel", 2, ((StringBuilder)localObject2).toString());
    }
    this.j.setVisibility(8);
    this.h.setVisibility(8);
    this.i.setVisibility(0);
    this.i.setHiBoom(paramFlashChatItem.id, 0, HiBoomConstants.e);
    this.i.setText((CharSequence)localObject1);
  }
  
  public static float getFlashChatHeight()
  {
    return getFlashChatWidth() * 3.0F / 4.0F;
  }
  
  public static float getFlashChatWidth()
  {
    float f1 = MobileQQ.sMobileQQ.getResources().getDisplayMetrics().scaledDensity;
    return ArkAppCenterUtil.b + f1 * 20.0F;
  }
  
  public RelativeLayout a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.f;
    }
    if (this.f == null)
    {
      Object localObject2 = getContext();
      this.f = ((RelativeLayout)LayoutInflater.from((Context)localObject2).inflate(2131627448, null));
      this.f.setOnClickListener(this);
      this.f.findViewById(2131430806).setOnClickListener(this);
      this.g = this.f.findViewById(2131430276);
      this.g.setOnClickListener(this);
      Object localObject1 = this.A.d;
      ((ImageView)this.f.findViewById(2131431625)).setImageDrawable(FaceDrawable.getFaceDrawable((AppInterface)localObject1, 1, ((QQAppInterface)localObject1).getCurrentUin()));
      this.f.findViewById(2131428772).setPadding(0, 0, 0, 0);
      Object localObject3 = (ArkAppLoadLayout)this.f.findViewById(2131437612);
      Object localObject4 = (RelativeLayout.LayoutParams)((ArkAppLoadLayout)localObject3).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject4).setMargins(5, 5, 5, 5);
      ((ArkAppLoadLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      this.j = ((ETTextView)this.f.findViewById(2131447274));
      this.j.setTextColor(((Context)localObject2).getResources().getColorStateList(2131168016));
      this.j.setLinkTextColor(((Context)localObject2).getResources().getColorStateList(2131168008));
      this.j.setSpannableFactory(QQText.SPANNABLE_FACTORY);
      this.j.setMaxWidth(BaseChatItemLayout.e);
      this.j.setMovementMethod(LinkMovementMethod.getInstance());
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
      localObject3 = ((Resources)localObject2).getDrawable(2130852127);
      localObject4 = ((Resources)localObject2).getDrawable(2130852126);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject3);
      localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject4);
      if (GlobalImageCache.a != null)
      {
        QLog.isColorLevel();
        GlobalImageCache.a.put("bubblebg://default_mine", localStateListDrawable.getConstantState());
      }
      a((QQAppInterface)localObject1, this.j, localStateListDrawable);
      localObject1 = ((Resources)localObject2).getColorStateList(2131168020);
      this.j.setPadding(BaseChatItemLayout.getTextBubblePaddingAlignHead(), u, BaseChatItemLayout.getTextBubblePaddingAlignError(), v);
      this.j.setTextColor((ColorStateList)localObject1);
      this.j.setTextSize(0, this.A.ah.r);
      this.h = ((ArkAppRootLayout)this.f.findViewById(2131428759));
      this.y = ((ArkAppView)this.f.findViewById(2131428746));
      this.z = ((ArkAppLoadLayout)this.f.findViewById(2131437612));
      this.y.setClipRadius(14.0F);
      this.y.setBorderType(2);
      this.y.setAlignLeft(false);
      new FlashChatPanel.arkViewOnLongClickAndTouchListener(this);
      this.y.setCallback(new FlashChatPanel.2(this));
      this.i = ((HiBoomTextView)this.f.findViewById(2131435032));
    }
    return this.f;
  }
  
  public Pair<Integer, Integer> a(int paramInt)
  {
    Object localObject = new ArrayList();
    for (;;)
    {
      int i1;
      try
      {
        FlashChatTextEffectView localFlashChatTextEffectView = this.p[paramInt];
        if (localFlashChatTextEffectView != null)
        {
          i1 = 0;
          if (i1 < localFlashChatTextEffectView.getSize())
          {
            FlashChatItem localFlashChatItem = localFlashChatTextEffectView.c(i1);
            if ((FlashChatManager.a(this.A.d, localFlashChatItem) != null) || (localFlashChatItem.id == -100000)) {
              break label152;
            }
            ((ArrayList)localObject).add(new Pair(Integer.valueOf(paramInt), Integer.valueOf(i1)));
            break label152;
          }
        }
        if (((ArrayList)localObject).isEmpty()) {
          return null;
        }
        i1 = this.q.nextInt(((ArrayList)localObject).size());
        paramInt = i1;
        if (this.x == i1) {
          paramInt = (i1 + 1) / ((ArrayList)localObject).size();
        }
        this.x = paramInt;
        localObject = (Pair)((ArrayList)localObject).get(paramInt);
        return localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      label152:
      i1 += 1;
    }
  }
  
  public void a()
  {
    FlashChatItem localFlashChatItem = getSelectedItem();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("recordChoose");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" ");
      localStringBuilder.append(localFlashChatItem);
      QLog.i("FlashChat", 1, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (localFlashChatItem != null) {
      localStringBuilder.append(this.d);
    } else {
      localStringBuilder.append(this.e);
    }
    localStringBuilder.append(":");
    if (localFlashChatItem == null) {
      localStringBuilder.append(-1);
    } else {
      localStringBuilder.append(localFlashChatItem.id);
    }
    ((FlashChatManager)this.A.d.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).c(localStringBuilder.toString());
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
    Object localObject2 = b(paramInt1, paramInt2);
    int i1 = 0;
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
        localObject1 = FlashChatManager.a(this.A.d, (FlashChatItem)localObject2);
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
          this.b.setSelectedTab(this.d, false);
        }
        setupArkUI((FlashChatItem)localObject2);
      }
      else if (paramInt1 == 1)
      {
        if (paramBoolean) {
          this.b.setSelectedTab(paramInt1, false);
        }
        a((FlashChatItem)localObject2);
      }
    }
    else
    {
      localObject2 = this.A.Y.getText().toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((String)localObject2).trim();
      }
      localObject2 = localObject1;
      if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = HardCodeUtil.a(2131902617);
      }
      if (QLog.isColorLevel()) {
        QLog.d("FlashChat", 2, "cancelChoose");
      }
      this.j.setVisibility(0);
      this.j.setText((CharSequence)localObject2);
      this.h.setVisibility(8);
      this.i.setVisibility(8);
      if ((paramBoolean) && (paramInt1 >= 0) && (paramInt1 <= 1)) {
        this.b.setSelectedTab(paramInt1, false);
      }
    }
    this.c = paramInt2;
    this.d = paramInt1;
    paramInt1 = i1;
    for (;;)
    {
      localObject1 = this.p;
      if (paramInt1 >= localObject1.length) {
        break;
      }
      localObject1 = localObject1[paramInt1];
      if (localObject1 != null) {
        if (paramInt1 != this.d) {
          ((FlashChatTextEffectView)localObject1).b(-1);
        } else {
          ((FlashChatTextEffectView)localObject1).b(paramInt2);
        }
      }
      paramInt1 += 1;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (AppSetting.e) {
      try
      {
        FlashChatItem localFlashChatItem = b(paramInt2, paramInt1);
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
  
  public FlashChatItem b(int paramInt1, int paramInt2)
  {
    try
    {
      FlashChatItem localFlashChatItem = this.p[paramInt1].c(paramInt2);
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
        localStringBuilder.append(this.c);
        localStringBuilder.append("");
        localStringBuilder.append(paramInt2);
        QLog.i("FlashChat", 2, localStringBuilder.toString());
      }
    }
    return null;
  }
  
  public void b(View paramView, int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean)
  {
    Object localObject1;
    Object localObject3;
    int i3;
    if (paramBoolean)
    {
      com.tencent.widget.XPanelContainer.a = (int)(getResources().getDisplayMetrics().density * 246.0F);
      localObject1 = a(true);
      localObject3 = ((RelativeLayout)localObject1).getParent();
      i3 = -1;
      if (localObject3 == null)
      {
        localObject3 = new RelativeLayout.LayoutParams(-1, -1);
        ((FrameLayout)this.A.aZ.findViewById(2131440610)).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      }
      else
      {
        ((RelativeLayout)localObject1).setVisibility(0);
      }
      this.A.aZ.findViewById(2131433920).setVisibility(8);
      this.A.p.setVisibility(8);
      if (this.A.W != null)
      {
        this.C = this.A.W.getHeight();
        this.A.W.setCustomHeight(0);
      }
      localObject1 = (IApolloAIOHelper)this.A.q(8);
      if (localObject1 != null) {
        ((IApolloAIOHelper)localObject1).showApolloView(false);
      }
      localObject1 = (AIOShortcutBarHelper)this.A.q(52);
      if (localObject1 != null) {
        ((AIOShortcutBarHelper)localObject1).d(11);
      }
      localObject3 = this.A.Y.getEditableText().toString();
      localObject1 = localObject3;
      if (localObject3 != null) {
        localObject1 = ((String)localObject3).trim();
      }
      if ((localObject1 != null) && (((String)localObject1).length() != 0) && (((String)localObject1).length() <= 20)) {
        this.k.setEnabled(true);
      } else {
        this.k.setEnabled(false);
      }
      localObject1 = ((FlashChatManager)this.A.d.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).b();
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
        i1 = Integer.valueOf(localObject1[0]).intValue();
        i2 = i1;
        try
        {
          i4 = Integer.valueOf(localObject1[1]).intValue();
          i2 = i1;
          localObject1 = this.p[i1];
          i5 = i1;
          i2 = i3;
          if (localObject1 == null) {
            continue;
          }
          i3 = -1;
          i2 = 0;
          try
          {
            if (i2 < ((FlashChatTextEffectView)localObject1).getSize())
            {
              localObject3 = ((FlashChatTextEffectView)localObject1).c(i2);
              if (i1 == 0)
              {
                i5 = i3;
                if (FlashChatManager.a(this.A.d, (FlashChatItem)localObject3) == null)
                {
                  i5 = i3;
                  if (localObject3 != null)
                  {
                    i5 = i3;
                    if (((FlashChatItem)localObject3).id == i4) {
                      i5 = i2;
                    }
                  }
                }
              }
              else
              {
                i5 = i3;
                if (i1 == 1)
                {
                  i5 = i3;
                  if (localObject3 != null)
                  {
                    int i6 = ((FlashChatItem)localObject3).id;
                    i5 = i3;
                    if (i6 == i4)
                    {
                      i5 = i1;
                      continue;
                    }
                  }
                }
              }
              i2 += 1;
              i3 = i5;
            }
            else
            {
              i2 = i3;
              i5 = i1;
            }
          }
          catch (Exception localException1) {}
          localException2.printStackTrace();
        }
        catch (Exception localException2)
        {
          i1 = i2;
        }
      }
      catch (Exception localException3)
      {
        int i2;
        int i5;
        Object localObject2;
        i1 = -1;
        continue;
      }
      i2 = i3;
      i5 = i1;
      a(i5, i2, true);
      if (i5 == 0)
      {
        localObject2 = (FlashChatManager)this.A.d.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
        if (((FlashChatManager)localObject2).g().size() < 3)
        {
          ((FlashChatManager)localObject2).f();
          return;
          this.A.p.setVisibility(0);
          localObject2 = (IApolloAIOHelper)this.A.q(8);
          if (localObject2 != null) {
            ((IApolloAIOHelper)localObject2).showApolloView(true);
          }
          localObject2 = (AIOShortcutBarHelper)this.A.q(52);
          if (localObject2 != null) {
            ((AIOShortcutBarHelper)localObject2).d(12);
          }
          localObject2 = a(false);
          if (localObject2 != null) {
            ((RelativeLayout)localObject2).setVisibility(8);
          }
          this.A.aZ.findViewById(2131433920).setVisibility(0);
          if (this.A.W != null) {
            this.A.W.setCustomHeight(this.C);
          }
          if (this.y != null)
          {
            localObject2 = this.t.values().iterator();
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (ArkFlashChatContainerWrapper)((Iterator)localObject2).next();
              if (localObject3 == null) {
                continue;
              }
              ((ArkFlashChatContainerWrapper)localObject3).doOnEvent(2);
              continue;
            }
            this.t.clear();
          }
          if (QLog.isColorLevel()) {
            QLog.i("FlashChat", 2, "restore layout");
          }
        }
      }
      return;
      label790:
      int i4 = -1;
      int i1 = -1;
    }
  }
  
  public boolean b()
  {
    if (getVisibility() != 0) {
      return false;
    }
    if (android.text.TextUtils.isEmpty(this.A.Y.getText().toString())) {
      return false;
    }
    a();
    this.A.ax();
    return true;
  }
  
  public void c()
  {
    a(this.d, -1);
    a();
    QQToast.makeText(getContext(), HardCodeUtil.a(2131902616), 0).show();
  }
  
  public void d()
  {
    a();
    this.A.aw();
    b(false);
  }
  
  public FlashChatItem getSelectedItem()
  {
    return b(this.d, this.c);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131430276)
    {
      if (i1 != 2131430806)
      {
        if (i1 != 2131445580)
        {
          RelativeLayout localRelativeLayout = this.f;
        }
        else
        {
          b();
          d();
        }
      }
      else
      {
        d();
        this.D = true;
      }
    }
    else {
      c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    } else if ((i1 == 1) || (i1 == 3)) {
      getParent().requestDisallowInterceptTouchEvent(false);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.b.setSelectedTab(paramInt, false);
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    this.a.setCurrentItem(paramInt2, true);
    this.e = paramInt2;
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
      ((ViewGroup)this.A.aZ.findViewById(2131435809)).getLocationInWindow(this.B);
      ((ViewGroup.LayoutParams)localObject).height = (this.B[1] - ImmersiveUtils.getStatusBarHeight(getContext()));
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      b(true);
      return;
    }
    if (!this.D) {
      a();
    }
    b(false);
  }
  
  public void setupArkUI(FlashChatItem paramFlashChatItem)
  {
    Object localObject2 = this.A.Y.getText().toString();
    Object localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = ((String)localObject2).trim();
    }
    localObject2 = localObject1;
    if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = HardCodeUtil.a(2131902618);
    }
    if (paramFlashChatItem.id == -100000)
    {
      i1 = this.q.nextInt(2);
      int i2 = this.q.nextInt(this.p[i1].getSize());
      if (QLog.isColorLevel())
      {
        paramFlashChatItem = new StringBuilder();
        paramFlashChatItem.append("setupArkUI  random ");
        paramFlashChatItem.append(i1);
        paramFlashChatItem.append(" ");
        paramFlashChatItem.append(i2);
        QLog.d("FlashChat", 2, paramFlashChatItem.toString());
      }
      a(i1, i2);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setupArkUI");
      ((StringBuilder)localObject1).append(paramFlashChatItem);
      QLog.d("FlashChat", 2, ((StringBuilder)localObject1).toString());
    }
    this.j.setVisibility(8);
    this.i.setVisibility(8);
    this.h.setVisibility(0);
    int i1 = paramFlashChatItem.id;
    ArkAppView localArkAppView = this.y;
    if (localArkAppView != null)
    {
      Object localObject3 = (ArkFlashChatContainerWrapper)this.t.get(Integer.valueOf(i1));
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = new ArkFlashChatContainerWrapper();
        this.t.put(Integer.valueOf(i1), localObject1);
      }
      localObject3 = new MessageForArkFlashChat();
      ((MessageForArkFlashChat)localObject3).uniseq = i1;
      ((MessageForArkFlashChat)localObject3).ark_app_message = new ArkFlashChatMessage();
      ((MessageForArkFlashChat)localObject3).ark_app_message.promptText = ((String)localObject2);
      ((MessageForArkFlashChat)localObject3).arkContainer = ((ArkFlashChatContainerWrapper)localObject1);
      localObject2 = this.s;
      this.s = ((MessageForArkFlashChat)localObject3);
      ((ArkFlashChatContainerWrapper)localObject1).a(this.A.d, getContext(), paramFlashChatItem.appName, paramFlashChatItem.mainView, paramFlashChatItem.ver, paramFlashChatItem.id, ((MessageForArkFlashChat)localObject3).ark_app_message.getMeta(((MessageForArkFlashChat)localObject3).uniseq, false), getContext().getResources().getDisplayMetrics().scaledDensity, this.A.aE(), getFlashChatWidth(), getFlashChatHeight(), getFlashChatWidth(), getFlashChatHeight(), this.s);
      localArkAppView.a((ArkAppContainer)localObject1, this.z);
      localArkAppView.setCallback(new FlashChatPanel.1(this, paramFlashChatItem, (MessageForArkFlashChat)localObject2, (MessageForArkFlashChat)localObject3));
      localArkAppView.a((ArkAppContainer)localObject1, this.z);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatPanel
 * JD-Core Version:    0.7.0.1
 */