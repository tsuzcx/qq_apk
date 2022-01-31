package com.tencent.mobileqq.hiboom;

import aciy;
import aeor;
import afhm;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
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
import apgz;
import apha;
import aqck;
import aqcw;
import aqdf;
import aqdm;
import aqdw;
import awnu;
import awqx;
import azvv;
import baig;
import bant;
import baot;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView;
import com.tencent.mobileqq.activity.contacts.view.SimpleSlidingIndicator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatPanelView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class RichTextPanel
  extends RelativeLayout
  implements afhm, ViewPager.OnPageChangeListener, View.OnClickListener, apgz, aqdm
{
  private int jdField_a_of_type_Int = -1;
  private PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = new aqdw(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private ArrayList<RichTextPanelView> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ArrayList<Integer> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private ArrayList<RichTextPanelView> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
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
    boolean bool1 = true;
    if ((paramInt < 0) || (paramInt >= this.jdField_b_of_type_JavaUtilArrayList.size()))
    {
      QLog.e("RichTextPanel", 1, "needShowGuide outofindex: " + paramInt + "," + this.jdField_b_of_type_JavaUtilArrayList.size());
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      String str = "had_show_fontbubble_guide_" + this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      bool2 = localSharedPreferences.getBoolean(str, false);
      localSharedPreferences.edit().putBoolean(str, true).commit();
    } while (!bool2);
    return false;
  }
  
  private void c(boolean paramBoolean)
  {
    int m = 2131101267;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator != null)
    {
      bool1 = ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      bool2 = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      bool3 = awnu.a();
      if ((paramBoolean) || (this.jdField_c_of_type_Boolean != bool1) || (this.jdField_d_of_type_Boolean != bool2) || (this.e != bool3)) {}
    }
    else
    {
      return;
    }
    int k = 25;
    int i;
    int j;
    if (bool3) {
      if (bool2)
      {
        i = 2131100734;
        k = 2131101336;
        int n = 255;
        j = i;
        i = k;
        k = n;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.d(k);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.a(m, i, j);
      if (this.jdField_a_of_type_AndroidWidgetButton != null)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130838196));
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getResources().getColor(2131101411));
      }
      this.jdField_c_of_type_Boolean = bool1;
      this.jdField_d_of_type_Boolean = bool2;
      this.e = bool3;
      return;
      i = 2131100733;
      break;
      if (bool2)
      {
        m = 2131099922;
        i = 2131099921;
        j = 2131099920;
        k = 30;
      }
      else if (!bool1)
      {
        i = 2131101336;
        j = 2131101267;
      }
      else
      {
        m = 2131099923;
        i = 2131101336;
        j = 2131099923;
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator == null) {}
    int i;
    do
    {
      do
      {
        return;
      } while (!this.jdField_c_of_type_JavaUtilArrayList.isEmpty());
      this.jdField_c_of_type_JavaUtilArrayList.clear();
      Object localObject1 = (FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217);
      Object localObject2 = apha.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        i = ((Integer)((Iterator)localObject2).next()).intValue();
        if (i == 1)
        {
          if (((FlashChatManager)localObject1).a().size() > 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("RichTextPanel", 2, "flashItem is null, cannot show flashPanel");
            }
            this.jdField_c_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
            this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(1));
            localArrayList1.add(((RichTextPanelView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a());
            localArrayList2.add(Integer.valueOf(2131309488));
          }
        }
        else if (i == 2)
        {
          if (aqdf.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a())
          {
            this.jdField_c_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
            this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(2));
            localArrayList1.add(((RichTextPanelView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a());
            localArrayList2.add(Integer.valueOf(2131309491));
          }
        }
        else if ((i == 0) && (aeor.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a()).c()))
        {
          this.jdField_c_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
          this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(0));
          localArrayList1.add(((RichTextPanelView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a());
          localArrayList2.add(Integer.valueOf(2131309495));
        }
        else if ((i == 3) || (i == 4))
        {
          this.jdField_c_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
          this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
          localArrayList1.add(((RichTextPanelView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a());
          if (i == 3) {}
          for (i = 2131309489;; i = 2131309487)
          {
            localArrayList2.add(Integer.valueOf(i));
            break;
          }
        }
      }
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.notifyDataSetChanged();
      localObject1 = new String[localArrayList1.size()];
      localObject2 = new int[localArrayList2.size()];
      i = 0;
      int k;
      for (int j = -1; i < this.jdField_c_of_type_JavaUtilArrayList.size(); j = k)
      {
        localObject1[i] = ((String)localArrayList1.get(i));
        localObject2[i] = ((Integer)localArrayList2.get(i)).intValue();
        RichTextPanelView localRichTextPanelView = (RichTextPanelView)this.jdField_c_of_type_JavaUtilArrayList.get(i);
        k = j;
        if (this.jdField_a_of_type_Boolean)
        {
          k = j;
          if ((localRichTextPanelView instanceof HiBoomPanelView)) {
            k = i;
          }
        }
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setTabData((String[])localObject1, (int[])localObject2);
      if (j != -1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.e(j);
      }
      i = apha.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaUtilArrayList);
      if (i >= this.jdField_c_of_type_JavaUtilArrayList.size()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setCurrentPosition(i, false);
    } while (i != 0);
    a(0, false);
    return;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setCurrentPosition(0, false);
    a(0, false);
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == this.jdField_a_of_type_Int) || (this.jdField_c_of_type_JavaUtilArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichTextPanel", 2, "onTabSelected: already at the position: " + paramInt + " mShowPages.size: " + this.jdField_c_of_type_JavaUtilArrayList.size());
      }
      return 0;
    }
    if ((this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_Int < this.jdField_c_of_type_JavaUtilArrayList.size())) {
      ((RichTextPanelView)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a(false);
    }
    RichTextPanelView localRichTextPanelView;
    String str;
    if ((paramInt >= 0) && (paramInt < this.jdField_c_of_type_JavaUtilArrayList.size()))
    {
      localRichTextPanelView = (RichTextPanelView)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt);
      if (localRichTextPanelView != null)
      {
        str = null;
        localRichTextPanelView.a(true);
        if (!(localRichTextPanelView instanceof HiBoomPanelView)) {
          break label456;
        }
        str = "0X80094D4";
        if (!TextUtils.isEmpty(str)) {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
        }
      }
      if (((localRichTextPanelView instanceof FontBubblePanelView)) && (a(paramInt))) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if ((!(localRichTextPanelView instanceof ZhituPanelView)) || (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() != 8)) {
        break label509;
      }
      a(this.jdField_a_of_type_AndroidWidgetButton, 2130772010);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    else
    {
      label265:
      if (paramInt < 0) {
        break label542;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Int != this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(this.jdField_a_of_type_Int, true);
      }
      if ((this.jdField_a_of_type_Int < this.jdField_c_of_type_JavaUtilArrayList.size()) && (this.jdField_a_of_type_Boolean) && ((this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int) instanceof HiBoomPanelView)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("isHiBoomFirstShow", false).commit();
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.f(this.jdField_a_of_type_Int);
      }
      if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_Int < this.jdField_b_of_type_JavaUtilArrayList.size()))
      {
        paramInt = ((Integer)this.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).intValue();
        baig.Z(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt);
      }
      return 0;
      label456:
      if ((localRichTextPanelView instanceof ZhituPanelView))
      {
        str = "0X80094D2";
        break;
      }
      if ((localRichTextPanelView instanceof FlashChatPanelView))
      {
        str = "0X80094D3";
        break;
      }
      if (!(localRichTextPanelView instanceof FontBubblePanelView)) {
        break;
      }
      str = "";
      ((FontBubblePanelView)localRichTextPanelView).a();
      break;
      label509:
      if (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() != 0) {
        break label265;
      }
      a(this.jdField_a_of_type_AndroidWidgetButton, 2130772011);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      break label265;
      label542:
      paramInt = 0;
    }
  }
  
  public void a()
  {
    if ((this.jdField_c_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_Int < this.jdField_c_of_type_JavaUtilArrayList.size()))
    {
      RichTextPanelView localRichTextPanelView = (RichTextPanelView)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      if ((localRichTextPanelView != null) && ((localRichTextPanelView instanceof FlashChatPanelView))) {
        ((FlashChatPanelView)localRichTextPanelView).b();
      }
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2) {}
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    Drawable localDrawable = getResources().getDrawable(2130848939);
    Object localObject = null;
    if ((localDrawable instanceof BitmapDrawable))
    {
      localObject = ((BitmapDrawable)localDrawable).getBitmap();
      localObject = new BitmapDrawable((Bitmap)localObject);
      if (localObject == null) {
        break label723;
      }
      ((BitmapDrawable)localObject).setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      ((BitmapDrawable)localObject).setDither(true);
      setBackgroundDrawable((Drawable)localObject);
    }
    for (;;)
    {
      setBackgroundDrawable((Drawable)localObject);
      this.jdField_d_of_type_Int = aciy.a(250.0F, getResources());
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("isHiBoomFirstShow", true);
      localObject = new RelativeLayout(getContext());
      ((RelativeLayout)localObject).setId(2131309494);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, azvv.a(getContext(), 40.0F));
      localLayoutParams1.addRule(12, -1);
      ((RelativeLayout)localObject).setBackgroundDrawable(localDrawable);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator = ((SimpleSlidingIndicator)View.inflate(getContext(), 2131493015, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setId(2131309493);
      c(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setOnTabListener(this);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, azvv.a(getContext(), 40.0F));
      localLayoutParams2.addRule(0, 2131310066);
      ((RelativeLayout)localObject).addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator, localLayoutParams2);
      this.jdField_a_of_type_AndroidWidgetButton = new Button(getContext());
      this.jdField_a_of_type_AndroidWidgetButton.setId(2131310066);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130838196));
      this.jdField_a_of_type_AndroidWidgetButton.setText(getResources().getString(2131655028));
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getResources().getColor(2131101411));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getResources().getString(2131655028));
      this.jdField_a_of_type_AndroidWidgetButton.setTextSize(2, 14.0F);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      localLayoutParams2 = new RelativeLayout.LayoutParams(azvv.a(getContext(), 60.0F), azvv.a(getContext(), 40.0F));
      localLayoutParams2.addRule(11);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetButton, localLayoutParams2);
      addView((View)localObject, localLayoutParams1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = new QQViewPager(getContext());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setId(2131309492);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setBackgroundDrawable(localDrawable);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setFocusable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setFocusableInTouchMode(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.a(true);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131309494);
      addView(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_a_of_type_AndroidWidgetImageView.setId(2131300956);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_JavaUtilArrayList.add(new ZhituPanelView(getContext(), paramBaseChatPie, this.jdField_a_of_type_AndroidWidgetButton));
      this.jdField_a_of_type_JavaUtilArrayList.add(new FlashChatPanelView(getContext(), paramBaseChatPie));
      this.jdField_a_of_type_JavaUtilArrayList.add(new HiBoomPanelView(getContext(), paramBaseChatPie));
      this.jdField_a_of_type_JavaUtilArrayList.add(new FontBubblePanelView(getContext(), paramBaseChatPie, new aqcw()));
      this.jdField_a_of_type_JavaUtilArrayList.add(new FontBubblePanelView(getContext(), paramBaseChatPie, new aqck()));
      return;
      if (!(localDrawable instanceof SkinnableBitmapDrawable)) {
        break;
      }
      localObject = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
      break;
      label723:
      if (QLog.isColorLevel()) {
        QLog.d("RichTextPanel", 2, "PokePanel background is null:");
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      RichTextPanelView localRichTextPanelView = (RichTextPanelView)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      if ((localRichTextPanelView instanceof FlashChatPanelView)) {
        ThreadManager.getUIHandler().post(new RichTextPanel.2(this, localRichTextPanelView));
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_c_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_Int < this.jdField_c_of_type_JavaUtilArrayList.size()))
    {
      RichTextPanelView localRichTextPanelView = (RichTextPanelView)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      if ((localRichTextPanelView != null) && ((localRichTextPanelView instanceof FlashChatPanelView))) {
        ((FlashChatPanelView)localRichTextPanelView).a();
      }
    }
  }
  
  public void b(View paramView, int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichTextPanel", 2, "onPanelStatusChanged show = " + paramBoolean);
    }
    if (paramBoolean)
    {
      d();
      c(false);
    }
    if ((this.jdField_a_of_type_Int >= this.jdField_c_of_type_JavaUtilArrayList.size()) || (this.jdField_a_of_type_Int < 0)) {
      return;
    }
    Object localObject = (RichTextPanelView)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
    ((RichTextPanelView)localObject).a(paramBoolean);
    String str;
    if (paramBoolean)
    {
      ((baot)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).f(aqdf.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()));
      aqdf.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this);
      str = null;
      if (!(localObject instanceof HiBoomPanelView)) {
        break label305;
      }
      str = "0X80094D4";
      localObject = "HighFont";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str))
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
        VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "InputFunc", "EnterFunc", "", 1, 0, 0, "", "", (String)localObject);
      }
      if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a() != 1) && (XPanelContainer.jdField_a_of_type_Int == this.jdField_c_of_type_Int))
      {
        XPanelContainer.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("RichTextPanel", 2, "hide set mExternalPanelheight: " + XPanelContainer.jdField_a_of_type_Int);
        }
      }
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
      label305:
      if ((localObject instanceof ZhituPanelView))
      {
        str = "0X80094D2";
        localObject = "SmartPic";
      }
      else if ((localObject instanceof FlashChatPanelView))
      {
        str = "0X80094D3";
        localObject = "FlashChat";
      }
      else
      {
        if ((localObject instanceof FontBubblePanelView))
        {
          str = "";
          ((FontBubblePanelView)localObject).a();
        }
        localObject = "";
      }
    }
  }
  
  public void c()
  {
    if ((this.jdField_c_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_Int < this.jdField_c_of_type_JavaUtilArrayList.size()))
    {
      RichTextPanelView localRichTextPanelView = (RichTextPanelView)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      if ((localRichTextPanelView != null) && ((localRichTextPanelView instanceof FlashChatPanelView))) {
        ((FlashChatPanelView)localRichTextPanelView).c();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      paramView = bant.a(getContext(), "font", "mvip.gexinghua.mobile.font.client_tab_store") + "&haibao=1";
      if (QLog.isColorLevel()) {
        QLog.d("RichTextPanel", 2, "enter hiboom mall url = " + paramView);
      }
      VasWebviewUtil.openQQBrowserWithoutAD(getContext(), paramView, 4096L, null, false, -1);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      paramView = aeor.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while ((paramView == null) || (paramView.a == null));
    paramView.a.b();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.jdField_b_of_type_Boolean) && (XPanelContainer.jdField_a_of_type_Int == this.jdField_c_of_type_Int))
    {
      XPanelContainer.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("RichTextPanel", 2, "onDetachedFromWindow set mExternalPanelheight: " + XPanelContainer.jdField_a_of_type_Int);
      }
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((XPanelContainer.jdField_d_of_type_Int == 0) || (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break label176;
      }
    }
    label176:
    for (this.jdField_c_of_type_Int = ((paramInt3 - paramInt1) * 598 / 750);; this.jdField_c_of_type_Int = this.jdField_d_of_type_Int)
    {
      if (this.jdField_c_of_type_Int != XPanelContainer.jdField_a_of_type_Int)
      {
        this.jdField_b_of_type_Int = XPanelContainer.jdField_a_of_type_Int;
        XPanelContainer.jdField_a_of_type_Int = this.jdField_c_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("RichTextPanel", 2, "showGuide set mExternalPanelheight: " + XPanelContainer.jdField_a_of_type_Int);
        }
        if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
        {
          Object localObject = URLDrawable.URLDrawableOptions.obtain();
          ColorDrawable localColorDrawable = new ColorDrawable(16777215);
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
          localObject = URLDrawable.getDrawable("https://gxh.vip.qq.com/xydata/vipData/app/imageStore/7e2fb795e29a9d0c4bc54f62adf2aa2e.png", (URLDrawable.URLDrawableOptions)localObject);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
        requestLayout();
      }
      return;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setCurrentPosition(paramInt, true);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.RichTextPanel
 * JD-Core Version:    0.7.0.1
 */