package com.tencent.mobileqq.hiboom;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.core.util.EmotionSharedPreUtils;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatPanelView;
import com.tencent.mobileqq.flashchat.OnHolderItemClickListener;
import com.tencent.mobileqq.flashchat.RichTextChatManager;
import com.tencent.mobileqq.hiboom.api.IHiBoomManager;
import com.tencent.mobileqq.hiboom.api.LegalJudgeResultLisener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.AbsSlidingIndicator.OnTabListener;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class RichTextPanel
  extends RelativeLayout
  implements View.OnClickListener, ViewPager.OnPageChangeListener, OnHolderItemClickListener, LegalJudgeResultLisener, AbsSlidingIndicator.OnTabListener
{
  public static int a = 1;
  private BaseChatPie b;
  private QQViewPager c;
  private int d = -1;
  private SimpleSlidingIndicator e;
  private boolean f;
  private ImageView g;
  private Button h;
  private int i;
  private int j;
  private int k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private ArrayList<RichTextPanelView> p = new ArrayList();
  private ArrayList<Integer> q = new ArrayList();
  private ArrayList<RichTextPanelView> r = new ArrayList();
  private RichTextPanelExtendHelper s;
  private PagerAdapter t = new RichTextPanel.2(this);
  
  public RichTextPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public RichTextPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RichTextPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(paramView.getContext(), paramInt);
    localAnimation.setFillAfter(false);
    paramView.startAnimation(localAnimation);
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.q.size()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("had_show_fontbubble_guide_");
      ((StringBuilder)localObject).append(this.q.get(paramInt));
      localObject = ((StringBuilder)localObject).toString();
      SharedPreferences localSharedPreferences = this.b.d.getPreferences();
      boolean bool = localSharedPreferences.getBoolean((String)localObject, false);
      localSharedPreferences.edit().putBoolean((String)localObject, true).commit();
      return bool ^ true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("needShowGuide outofindex: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(this.q.size());
    QLog.e("RichTextPanel", 1, ((StringBuilder)localObject).toString());
    return false;
  }
  
  private void e()
  {
    if (this.e == null) {
      return;
    }
    if (!this.r.isEmpty()) {
      return;
    }
    this.r.clear();
    Object localObject1 = (FlashChatManager)this.b.d.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
    Object localObject2 = RichTextChatManager.a(this.b.d).b(this.b.d);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      i1 = ((Integer)((Iterator)localObject2).next()).intValue();
      if (i1 == 1)
      {
        if (((FlashChatManager)localObject1).g().size() > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RichTextPanel", 2, "flashItem is null, cannot show flashPanel");
          }
          this.r.add(this.p.get(i1));
          this.q.add(Integer.valueOf(1));
          localArrayList1.add(((RichTextPanelView)this.p.get(i1)).getName());
          localArrayList2.add(Integer.valueOf(2131444773));
        }
      }
      else if (i1 == 2)
      {
        if (HiBoomConstants.a(this.b.d).isHiBoomEnable())
        {
          this.r.add(this.p.get(i1));
          this.q.add(Integer.valueOf(2));
          localArrayList1.add(((RichTextPanelView)this.p.get(i1)).getName());
          localArrayList2.add(Integer.valueOf(2131444776));
        }
      }
      else if ((i1 == 0) && (ZhituManager.a(this.b.i()).j()))
      {
        this.r.add(this.p.get(i1));
        this.q.add(Integer.valueOf(0));
        localArrayList1.add(((RichTextPanelView)this.p.get(i1)).getName());
        localArrayList2.add(Integer.valueOf(2131444780));
      }
      else if ((i1 != 3) && (i1 != 4))
      {
        if (i1 == 5)
        {
          this.r.add(this.p.get(i1));
          this.q.add(Integer.valueOf(5));
          localArrayList1.add(((RichTextPanelView)this.p.get(i1)).getName());
          localArrayList2.add(Integer.valueOf(2131444772));
        }
      }
      else
      {
        this.r.add(this.p.get(i1));
        this.q.add(Integer.valueOf(i1));
        localArrayList1.add(((RichTextPanelView)this.p.get(i1)).getName());
        if (i1 == 3) {
          i1 = 2131444774;
        } else {
          i1 = 2131444771;
        }
        localArrayList2.add(Integer.valueOf(i1));
      }
    }
    this.t.notifyDataSetChanged();
    localObject1 = new String[localArrayList1.size()];
    localObject2 = new int[localArrayList2.size()];
    int i1 = 0;
    int i3;
    for (int i2 = -1; i1 < this.r.size(); i2 = i3)
    {
      localObject1[i1] = ((String)localArrayList1.get(i1));
      localObject2[i1] = ((Integer)localArrayList2.get(i1)).intValue();
      RichTextPanelView localRichTextPanelView = (RichTextPanelView)this.r.get(i1);
      i3 = i2;
      if (this.f)
      {
        i3 = i2;
        if ((localRichTextPanelView instanceof HiBoomPanelView)) {
          i3 = i1;
        }
      }
      i1 += 1;
    }
    this.e.setTabData((String[])localObject1, (int[])localObject2);
    if (i2 != -1) {
      this.e.d(i2);
    }
    i1 = RichTextChatManager.a(this.b.d).a(this.b.d, this.q);
    if (i1 < this.r.size())
    {
      this.e.setCurrentPosition(i1, false);
      if (i1 == 0) {
        a(0, false);
      }
    }
    else
    {
      this.e.setCurrentPosition(0, false);
      a(0, false);
    }
  }
  
  private void setIndicatorThemeColor(boolean paramBoolean)
  {
    if (this.e != null)
    {
      boolean bool1 = ThemeUtil.isNowThemeIsDefaultCache(this.b.d, true);
      boolean bool2 = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      boolean bool3 = QQTheme.isNowSimpleUI();
      if ((!paramBoolean) && (this.m == bool1) && (this.n == bool2) && (this.o == bool3)) {
        return;
      }
      int i3 = 25;
      int i1 = 2131165916;
      int i2 = 2131168001;
      int i4 = 2131168122;
      if (bool3)
      {
        if (bool2) {
          i1 = 2131167341;
        } else {
          i1 = 2131167340;
        }
        i3 = 255;
        i2 = i1;
      }
      else
      {
        if (bool2)
        {
          i1 = 2131165915;
          i4 = 2131165914;
          i3 = 30;
          i2 = 2131165913;
          break label159;
        }
        if (bool1) {
          break label155;
        }
      }
      i1 = 2131168001;
      break label159;
      label155:
      i2 = 2131165916;
      label159:
      this.e.c(i3);
      this.e.a(i1, i4, i2);
      Button localButton = this.h;
      if (localButton != null)
      {
        localButton.setBackgroundDrawable(getResources().getDrawable(2130838397));
        this.h.setTextColor(getResources().getColor(2131168212));
      }
      this.m = bool1;
      this.n = bool2;
      this.o = bool3;
    }
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    int i1 = paramInt;
    int i3 = this.d;
    int i2 = 2;
    Object localObject;
    if ((i1 != i3) && (this.r.size() > 0))
    {
      if (this.b == null) {
        return 0;
      }
      if (!paramBoolean) {
        i2 = 1;
      }
      a = i2;
      i2 = this.d;
      if ((i2 >= 0) && (i2 < this.r.size())) {
        ((RichTextPanelView)this.r.get(this.d)).a(false);
      }
      if ((i1 >= 0) && (i1 < this.r.size()))
      {
        RichTextPanelView localRichTextPanelView = (RichTextPanelView)this.r.get(i1);
        if (localRichTextPanelView != null)
        {
          localObject = null;
          localRichTextPanelView.a(true);
          if ((localRichTextPanelView instanceof HiBoomPanelView)) {
            localObject = "0X80094D4";
          }
          for (;;)
          {
            break;
            if ((localRichTextPanelView instanceof ZhituPanelView))
            {
              localObject = "0X80094D2";
            }
            else if ((localRichTextPanelView instanceof FlashChatPanelView))
            {
              localObject = "0X80094D3";
            }
            else if ((localRichTextPanelView instanceof FontBubblePanelView))
            {
              ((FontBubblePanelView)localRichTextPanelView).a();
              localObject = "";
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            ReportController.b(this.b.d, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
          }
          if (((localRichTextPanelView instanceof EmoticonHotPicSearchPanelView)) && (this.b.Y != null))
          {
            localObject = this.b.Y.getText().toString();
            ReportController.b(this.b.d, "dc00898", "", "", "0X800AE34", "0X800AE34", 0, 0, "", "", (String)localObject, "");
            ((EmoticonHotPicSearchPanelView)localRichTextPanelView).b();
          }
        }
        if (((localRichTextPanelView instanceof FontBubblePanelView)) && (a(paramInt))) {
          this.g.setVisibility(0);
        }
        localObject = this.b;
        if (localObject != null) {
          paramInt = RichTextChatManager.a(((BaseChatPie)localObject).i()).e();
        } else {
          paramInt = 0;
        }
        paramBoolean = localRichTextPanelView instanceof ZhituPanelView;
        if ((paramBoolean) && (paramInt == 1)) {
          this.h.setVisibility(8);
        }
        if ((paramBoolean) && (this.h.getVisibility() == 8))
        {
          a(this.h, 2130772028);
          if (paramInt != 1) {
            this.h.setVisibility(0);
          }
        }
        else if (this.h.getVisibility() == 0)
        {
          a(this.h, 2130772030);
          this.h.setVisibility(8);
        }
      }
      if (i1 < 0) {
        i1 = 0;
      }
      this.d = i1;
      if (this.d != this.c.getCurrentItem()) {
        this.c.setCurrentItem(this.d, true);
      }
      if ((this.d < this.r.size()) && (this.f) && ((this.r.get(this.d) instanceof HiBoomPanelView)))
      {
        this.b.d.getPreferences().edit().putBoolean("isHiBoomFirstShow", false).commit();
        this.f = false;
        this.e.e(this.d);
      }
      localObject = this.q;
      if (localObject != null)
      {
        paramInt = this.d;
        if ((paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()))
        {
          paramInt = ((Integer)this.q.get(this.d)).intValue();
          EmotionSharedPreUtils.a(this.b.d.getApp(), this.b.d.getCurrentAccountUin(), paramInt);
        }
      }
      return 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onTabSelected: already at the position: ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(" mShowPages.size: ");
      ((StringBuilder)localObject).append(this.r.size());
      QLog.d("RichTextPanel", 2, ((StringBuilder)localObject).toString());
    }
    return 0;
  }
  
  public void a()
  {
    if (this.r.size() > 0)
    {
      int i1 = this.d;
      if ((i1 > 0) && (i1 < this.r.size()))
      {
        RichTextPanelView localRichTextPanelView = (RichTextPanelView)this.r.get(this.d);
        if ((localRichTextPanelView != null) && ((localRichTextPanelView instanceof FlashChatPanelView))) {
          ((FlashChatPanelView)localRichTextPanelView).b();
        }
      }
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2) {}
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
    this.s = new RichTextPanelExtendHelper(this.b.d, this.b, this);
    Drawable localDrawable = getResources().getDrawable(2130852413);
    if ((localDrawable instanceof BitmapDrawable)) {
      localObject = ((BitmapDrawable)localDrawable).getBitmap();
    } else if ((localDrawable instanceof SkinnableBitmapDrawable)) {
      localObject = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
    } else {
      localObject = null;
    }
    Object localObject = new BitmapDrawable((Bitmap)localObject);
    ((BitmapDrawable)localObject).setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
    ((BitmapDrawable)localObject).setDither(true);
    setBackgroundDrawable((Drawable)localObject);
    setBackgroundDrawable((Drawable)localObject);
    this.k = AIOUtils.b(250.0F, getResources());
    this.f = this.b.d.getPreferences().getBoolean("isHiBoomFirstShow", true);
    localObject = new RichTextPanel.1(this, getContext());
    ((RelativeLayout)localObject).setId(2131444779);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, DisplayUtil.a(getContext(), 40.0F));
    localLayoutParams1.addRule(12, -1);
    ((RelativeLayout)localObject).setBackgroundDrawable(localDrawable);
    this.e = ((SimpleSlidingIndicator)View.inflate(getContext(), 2131624121, null));
    this.e.setId(2131444778);
    setIndicatorThemeColor(true);
    this.e.setOnTabListener(this);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, DisplayUtil.a(getContext(), 40.0F));
    localLayoutParams2.addRule(0, 2131445568);
    ((RelativeLayout)localObject).addView(this.e, localLayoutParams2);
    this.h = new Button(getContext());
    this.h.setId(2131445568);
    this.h.setBackgroundDrawable(getResources().getDrawable(2130838397));
    this.h.setText(getResources().getString(2131918214));
    this.h.setTextColor(getResources().getColor(2131168212));
    this.h.setContentDescription(getResources().getString(2131918214));
    this.h.setTextSize(2, 14.0F);
    this.h.setVisibility(8);
    localLayoutParams2 = new RelativeLayout.LayoutParams(DisplayUtil.a(getContext(), 60.0F), DisplayUtil.a(getContext(), 40.0F));
    localLayoutParams2.addRule(11);
    this.h.setOnClickListener(this);
    ((RelativeLayout)localObject).addView(this.h, localLayoutParams2);
    addView((View)localObject, localLayoutParams1);
    this.c = new QQViewPager(getContext());
    this.c.setId(2131444777);
    this.c.setBackgroundDrawable(localDrawable);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.c.setFocusable(true);
    this.c.setFocusableInTouchMode(true);
    this.c.requestParentDisallowInterecptTouchEvent(true);
    ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131444779);
    addView(this.c, (ViewGroup.LayoutParams)localObject);
    this.c.setAdapter(this.t);
    this.c.setOnPageChangeListener(this);
    this.g = new ImageView(getContext());
    this.g.setId(2131433563);
    this.g.setOnClickListener(this);
    this.g.setVisibility(8);
    this.g.setScaleType(ImageView.ScaleType.FIT_XY);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.g, (ViewGroup.LayoutParams)localObject);
    this.p.add(new ZhituPanelView(getContext(), paramBaseChatPie, this.s, this.h));
    this.p.add(new FlashChatPanelView(getContext(), paramBaseChatPie, this.s));
    this.p.add(new HiBoomPanelView(getContext(), paramBaseChatPie, this.s));
    this.p.add(new FontBubblePanelView(getContext(), paramBaseChatPie, this.s, new FontController()));
    this.p.add(new FontBubblePanelView(getContext(), paramBaseChatPie, this.s, new BubbleController()));
    this.p.add(new EmoticonHotPicSearchPanelView(getContext(), paramBaseChatPie, this.s));
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onPanelStatusChanged show = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("RichTextPanel", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramBoolean)
    {
      e();
      setIndicatorThemeColor(false);
    }
    if (this.d < this.r.size())
    {
      int i1 = this.d;
      if (i1 < 0) {
        return;
      }
      RichTextPanelView localRichTextPanelView = (RichTextPanelView)this.r.get(i1);
      localRichTextPanelView.a(paramBoolean);
      if (paramBoolean)
      {
        ((IApolloExtensionHandler)this.b.d.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).f(HiBoomConstants.a(this.b.Y.getText().toString()));
        HiBoomConstants.a(this.b.d).setLegalJugeResultLisener(this);
        localObject1 = null;
        boolean bool = localRichTextPanelView instanceof HiBoomPanelView;
        Object localObject2 = "";
        if (bool)
        {
          localObject2 = "HighFont";
          localObject1 = "0X80094D4";
        }
        for (;;)
        {
          break;
          if ((localRichTextPanelView instanceof ZhituPanelView))
          {
            localObject2 = "SmartPic";
            localObject1 = "0X80094D2";
          }
          else if ((localRichTextPanelView instanceof FlashChatPanelView))
          {
            localObject2 = "FlashChat";
            localObject1 = "0X80094D3";
          }
          else if ((localRichTextPanelView instanceof FontBubblePanelView))
          {
            ((FontBubblePanelView)localRichTextPanelView).a();
            localObject1 = "";
            localObject2 = localObject1;
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          ReportController.b(this.b.d, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
          VasWebviewUtil.a(this.b.d.getCurrentUin(), "InputFunc", "EnterFunc", "", 1, 0, 0, "", "", (String)localObject2);
        }
      }
      this.l = paramBoolean;
    }
  }
  
  public void b()
  {
    if (this.r.size() > 0)
    {
      int i1 = this.d;
      if ((i1 > 0) && (i1 < this.r.size()))
      {
        RichTextPanelView localRichTextPanelView = (RichTextPanelView)this.r.get(this.d);
        if ((localRichTextPanelView != null) && ((localRichTextPanelView instanceof FlashChatPanelView))) {
          ((FlashChatPanelView)localRichTextPanelView).a();
        }
      }
    }
  }
  
  public void b(View paramView, int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      RichTextPanelView localRichTextPanelView = (RichTextPanelView)this.r.get(this.d);
      if ((localRichTextPanelView instanceof FlashChatPanelView)) {
        ThreadManager.getUIHandler().post(new RichTextPanel.3(this, localRichTextPanelView));
      }
    }
  }
  
  public void c()
  {
    if (this.p.size() > 0)
    {
      Iterator localIterator = this.p.iterator();
      while (localIterator.hasNext())
      {
        RichTextPanelView localRichTextPanelView = (RichTextPanelView)localIterator.next();
        if (localRichTextPanelView != null) {
          localRichTextPanelView.bO_();
        }
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.s.a(paramBoolean);
    ((EmoticonHotPicSearchPanelView)this.p.get(5)).b(paramBoolean);
  }
  
  public void d()
  {
    this.s.a();
    ((EmoticonHotPicSearchPanelView)this.p.get(5)).a();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131433563)
    {
      Object localObject;
      if (i1 != 2131444775)
      {
        if (i1 == 2131445568)
        {
          localObject = ZhituManager.a(this.b.d);
          if ((localObject != null) && (((ZhituManager)localObject).c != null)) {
            ((ZhituManager)localObject).c.b();
          }
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(IndividuationUrlHelper.a(getContext(), "font", "mvip.gexinghua.mobile.font.client_tab_store"));
        ((StringBuilder)localObject).append("&haibao=1");
        localObject = ((StringBuilder)localObject).toString();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("enter hiboom mall url = ");
          localStringBuilder.append((String)localObject);
          QLog.d("RichTextPanel", 2, localStringBuilder.toString());
        }
        VasWebviewUtil.b(getContext(), (String)localObject, 4096L, null, false, -1);
      }
    }
    else
    {
      this.g.setVisibility(8);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.l) {
      this.s.c();
    }
    this.l = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.s.b()) && (this.g.getVisibility() == 0))
    {
      if (this.g.getVisibility() == 0) {
        this.j = ((paramInt3 - paramInt1) * 598 / 750);
      } else {
        this.j = this.k;
      }
      if (this.j != XPanelContainer.a)
      {
        this.i = XPanelContainer.a;
        XPanelContainer.a = this.j;
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("showGuide set mExternalPanelheight: ");
          ((StringBuilder)localObject).append(XPanelContainer.a);
          QLog.d("RichTextPanel", 2, ((StringBuilder)localObject).toString());
        }
        if (this.g.getVisibility() == 0)
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ColorDrawable localColorDrawable = new ColorDrawable(16777215);
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
          localObject = URLDrawable.getDrawable("https://gxh.vip.qq.com/xydata/vipData/app/imageStore/7e2fb795e29a9d0c4bc54f62adf2aa2e.png", (URLDrawable.URLDrawableOptions)localObject);
          this.g.setImageDrawable((Drawable)localObject);
        }
        requestLayout();
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (this.d != paramInt) {
      this.e.setCurrentPosition(paramInt, true);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.RichTextPanel
 * JD-Core Version:    0.7.0.1
 */