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
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.OnTabListener;
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
import com.tencent.mobileqq.widget.QQViewPager;
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
  implements View.OnClickListener, ViewPager.OnPageChangeListener, SimpleSlidingIndicator.OnTabListener, OnHolderItemClickListener, LegalJudgeResultLisener
{
  public static int a = 1;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PagerAdapter jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter = new RichTextPanel.2(this);
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
  private RichTextPanelExtendHelper jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private ArrayList<RichTextPanelView> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private ArrayList<Integer> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private ArrayList<RichTextPanelView> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  
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
    if ((paramInt >= 0) && (paramInt < this.jdField_b_of_type_JavaUtilArrayList.size()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("had_show_fontbubble_guide_");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaUtilArrayList.get(paramInt));
      localObject = ((StringBuilder)localObject).toString();
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      boolean bool = localSharedPreferences.getBoolean((String)localObject, false);
      localSharedPreferences.edit().putBoolean((String)localObject, true).commit();
      return bool ^ true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("needShowGuide outofindex: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaUtilArrayList.size());
    QLog.e("RichTextPanel", 1, ((StringBuilder)localObject).toString());
    return false;
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator != null)
    {
      boolean bool1 = ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      boolean bool2 = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      boolean bool3 = QQTheme.f();
      if ((!paramBoolean) && (this.jdField_c_of_type_Boolean == bool1) && (this.jdField_d_of_type_Boolean == bool2) && (this.jdField_e_of_type_Boolean == bool3)) {
        return;
      }
      int k = 25;
      int i = 2131165574;
      int j = 2131167063;
      int m = 2131167142;
      if (bool3)
      {
        if (bool2) {
          i = 2131166499;
        } else {
          i = 2131166498;
        }
        k = 255;
        j = i;
      }
      else
      {
        if (bool2)
        {
          i = 2131165573;
          m = 2131165572;
          k = 30;
          j = 2131165571;
          break label149;
        }
        if (bool1) {
          break label146;
        }
      }
      i = 2131167063;
      break label149;
      label146:
      j = 2131165574;
      label149:
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.d(k);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(i, m, j);
      Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
      if (localButton != null)
      {
        localButton.setBackgroundDrawable(getResources().getDrawable(2130838348));
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getResources().getColor(2131167222));
      }
      this.jdField_c_of_type_Boolean = bool1;
      this.jdField_d_of_type_Boolean = bool2;
      this.jdField_e_of_type_Boolean = bool3;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator == null) {
      return;
    }
    if (!this.jdField_c_of_type_JavaUtilArrayList.isEmpty()) {
      return;
    }
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    Object localObject1 = (FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
    Object localObject2 = RichTextChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
          localArrayList2.add(Integer.valueOf(2131376525));
        }
      }
      else if (i == 2)
      {
        if (HiBoomConstants.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).isHiBoomEnable())
        {
          this.jdField_c_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
          this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(2));
          localArrayList1.add(((RichTextPanelView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a());
          localArrayList2.add(Integer.valueOf(2131376528));
        }
      }
      else if ((i == 0) && (ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a()).c()))
      {
        this.jdField_c_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
        this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(0));
        localArrayList1.add(((RichTextPanelView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a());
        localArrayList2.add(Integer.valueOf(2131376532));
      }
      else if ((i != 3) && (i != 4))
      {
        if (i == 5)
        {
          this.jdField_c_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
          this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(5));
          localArrayList1.add(((RichTextPanelView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a());
          localArrayList2.add(Integer.valueOf(2131376524));
        }
      }
      else
      {
        this.jdField_c_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
        this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
        localArrayList1.add(((RichTextPanelView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a());
        if (i == 3) {
          i = 2131376526;
        } else {
          i = 2131376523;
        }
        localArrayList2.add(Integer.valueOf(i));
      }
    }
    this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.notifyDataSetChanged();
    localObject1 = new String[localArrayList1.size()];
    localObject2 = new int[localArrayList2.size()];
    int i = 0;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setTabData((String[])localObject1, (int[])localObject2);
    if (j != -1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.e(j);
    }
    i = RichTextChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaUtilArrayList);
    if (i < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(i, false);
      if (i == 0) {
        a(0, false);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(0, false);
      a(0, false);
    }
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    int i = paramInt;
    int k = this.jdField_b_of_type_Int;
    int j = 2;
    Object localObject;
    if ((i != k) && (this.jdField_c_of_type_JavaUtilArrayList.size() > 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
        return 0;
      }
      if (!paramBoolean) {
        j = 1;
      }
      jdField_a_of_type_Int = j;
      j = this.jdField_b_of_type_Int;
      if ((j >= 0) && (j < this.jdField_c_of_type_JavaUtilArrayList.size())) {
        ((RichTextPanelView)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)).a(false);
      }
      if ((i >= 0) && (i < this.jdField_c_of_type_JavaUtilArrayList.size()))
      {
        RichTextPanelView localRichTextPanelView = (RichTextPanelView)this.jdField_c_of_type_JavaUtilArrayList.get(i);
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
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
          }
          if (((localRichTextPanelView instanceof EmoticonHotPicSearchPanelView)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null))
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AE34", "0X800AE34", 0, 0, "", "", (String)localObject, "");
            ((EmoticonHotPicSearchPanelView)localRichTextPanelView).b();
          }
        }
        if (((localRichTextPanelView instanceof FontBubblePanelView)) && (a(paramInt))) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
        if (localObject != null) {
          paramInt = RichTextChatManager.a(((BaseChatPie)localObject).a()).a();
        } else {
          paramInt = 0;
        }
        paramBoolean = localRichTextPanelView instanceof ZhituPanelView;
        if ((paramBoolean) && (paramInt == 1)) {
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        }
        if ((paramBoolean) && (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 8))
        {
          a(this.jdField_a_of_type_AndroidWidgetButton, 2130772023);
          if (paramInt != 1) {
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          }
        }
        else if (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0)
        {
          a(this.jdField_a_of_type_AndroidWidgetButton, 2130772025);
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        }
      }
      if (i < 0) {
        i = 0;
      }
      this.jdField_b_of_type_Int = i;
      if (this.jdField_b_of_type_Int != this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(this.jdField_b_of_type_Int, true);
      }
      if ((this.jdField_b_of_type_Int < this.jdField_c_of_type_JavaUtilArrayList.size()) && (this.jdField_a_of_type_Boolean) && ((this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int) instanceof HiBoomPanelView)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("isHiBoomFirstShow", false).commit();
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.f(this.jdField_b_of_type_Int);
      }
      localObject = this.jdField_b_of_type_JavaUtilArrayList;
      if (localObject != null)
      {
        paramInt = this.jdField_b_of_type_Int;
        if ((paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()))
        {
          paramInt = ((Integer)this.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)).intValue();
          EmotionSharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt);
        }
      }
      return 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onTabSelected: already at the position: ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" mShowPages.size: ");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaUtilArrayList.size());
      QLog.d("RichTextPanel", 2, ((StringBuilder)localObject).toString());
    }
    return 0;
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_JavaUtilArrayList.size() > 0)
    {
      int i = this.jdField_b_of_type_Int;
      if ((i > 0) && (i < this.jdField_c_of_type_JavaUtilArrayList.size()))
      {
        RichTextPanelView localRichTextPanelView = (RichTextPanelView)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int);
        if ((localRichTextPanelView != null) && ((localRichTextPanelView instanceof FlashChatPanelView))) {
          ((FlashChatPanelView)localRichTextPanelView).b();
        }
      }
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2) {}
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper = new RichTextPanelExtendHelper(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this);
    Drawable localDrawable = getResources().getDrawable(2130850615);
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
    this.jdField_e_of_type_Int = AIOUtils.b(250.0F, getResources());
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("isHiBoomFirstShow", true);
    localObject = new RichTextPanel.1(this, getContext());
    ((RelativeLayout)localObject).setId(2131376531);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, DisplayUtil.a(getContext(), 40.0F));
    localLayoutParams1.addRule(12, -1);
    ((RelativeLayout)localObject).setBackgroundDrawable(localDrawable);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator = ((SimpleSlidingIndicator)View.inflate(getContext(), 2131558564, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setId(2131376530);
    d(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabListener(this);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, DisplayUtil.a(getContext(), 40.0F));
    localLayoutParams2.addRule(0, 2131377187);
    ((RelativeLayout)localObject).addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator, localLayoutParams2);
    this.jdField_a_of_type_AndroidWidgetButton = new Button(getContext());
    this.jdField_a_of_type_AndroidWidgetButton.setId(2131377187);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130838348));
    this.jdField_a_of_type_AndroidWidgetButton.setText(getResources().getString(2131720497));
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getResources().getColor(2131167222));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getResources().getString(2131720497));
    this.jdField_a_of_type_AndroidWidgetButton.setTextSize(2, 14.0F);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    localLayoutParams2 = new RelativeLayout.LayoutParams(DisplayUtil.a(getContext(), 60.0F), DisplayUtil.a(getContext(), 40.0F));
    localLayoutParams2.addRule(11);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetButton, localLayoutParams2);
    addView((View)localObject, localLayoutParams1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = new QQViewPager(getContext());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setId(2131376529);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setBackgroundDrawable(localDrawable);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setFocusable(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setFocusableInTouchMode(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.requestParentDisallowInterecptTouchEvent(true);
    ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131376531);
    addView(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131367109);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_JavaUtilArrayList.add(new ZhituPanelView(getContext(), paramBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper, this.jdField_a_of_type_AndroidWidgetButton));
    this.jdField_a_of_type_JavaUtilArrayList.add(new FlashChatPanelView(getContext(), paramBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper));
    this.jdField_a_of_type_JavaUtilArrayList.add(new HiBoomPanelView(getContext(), paramBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper));
    this.jdField_a_of_type_JavaUtilArrayList.add(new FontBubblePanelView(getContext(), paramBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper, new FontController()));
    this.jdField_a_of_type_JavaUtilArrayList.add(new FontBubblePanelView(getContext(), paramBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper, new BubbleController()));
    this.jdField_a_of_type_JavaUtilArrayList.add(new EmoticonHotPicSearchPanelView(getContext(), paramBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper));
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
      d(false);
    }
    if (this.jdField_b_of_type_Int < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      int i = this.jdField_b_of_type_Int;
      if (i < 0) {
        return;
      }
      RichTextPanelView localRichTextPanelView = (RichTextPanelView)this.jdField_c_of_type_JavaUtilArrayList.get(i);
      localRichTextPanelView.a(paramBoolean);
      if (paramBoolean)
      {
        ((IApolloExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).f(HiBoomConstants.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()));
        HiBoomConstants.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).setLegalJugeResultLisener(this);
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
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
          VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "InputFunc", "EnterFunc", "", 1, 0, 0, "", "", (String)localObject2);
        }
      }
      this.jdField_b_of_type_Boolean = paramBoolean;
    }
  }
  
  public void b()
  {
    if (this.jdField_c_of_type_JavaUtilArrayList.size() > 0)
    {
      int i = this.jdField_b_of_type_Int;
      if ((i > 0) && (i < this.jdField_c_of_type_JavaUtilArrayList.size()))
      {
        RichTextPanelView localRichTextPanelView = (RichTextPanelView)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int);
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
      RichTextPanelView localRichTextPanelView = (RichTextPanelView)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int);
      if ((localRichTextPanelView instanceof FlashChatPanelView)) {
        ThreadManager.getUIHandler().post(new RichTextPanel.3(this, localRichTextPanelView));
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        RichTextPanelView localRichTextPanelView = (RichTextPanelView)localIterator.next();
        if (localRichTextPanelView != null) {
          localRichTextPanelView.c();
        }
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper.a(paramBoolean);
    ((EmoticonHotPicSearchPanelView)this.jdField_a_of_type_JavaUtilArrayList.get(5)).b(paramBoolean);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper.a();
    ((EmoticonHotPicSearchPanelView)this.jdField_a_of_type_JavaUtilArrayList.get(5)).a();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131367109)
    {
      Object localObject;
      if (i != 2131376527)
      {
        if (i == 2131377187)
        {
          localObject = ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if ((localObject != null) && (((ZhituManager)localObject).a != null)) {
            ((ZhituManager)localObject).a.b();
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
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper.b();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper.a()) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0))
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
        this.jdField_d_of_type_Int = ((paramInt3 - paramInt1) * 598 / 750);
      } else {
        this.jdField_d_of_type_Int = this.jdField_e_of_type_Int;
      }
      if (this.jdField_d_of_type_Int != XPanelContainer.jdField_a_of_type_Int)
      {
        this.jdField_c_of_type_Int = XPanelContainer.jdField_a_of_type_Int;
        XPanelContainer.jdField_a_of_type_Int = this.jdField_d_of_type_Int;
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("showGuide set mExternalPanelheight: ");
          ((StringBuilder)localObject).append(XPanelContainer.jdField_a_of_type_Int);
          QLog.d("RichTextPanel", 2, ((StringBuilder)localObject).toString());
        }
        if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ColorDrawable localColorDrawable = new ColorDrawable(16777215);
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
          localObject = URLDrawable.getDrawable("https://gxh.vip.qq.com/xydata/vipData/app/imageStore/7e2fb795e29a9d0c4bc54f62adf2aa2e.png", (URLDrawable.URLDrawableOptions)localObject);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
        requestLayout();
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (this.jdField_b_of_type_Int != paramInt) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(paramInt, true);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.RichTextPanel
 * JD-Core Version:    0.7.0.1
 */