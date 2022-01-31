package com.tencent.mobileqq.leba;

import aehr;
import aehs;
import aehu;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.leba.header.LebaGridShowManager;
import com.tencent.mobileqq.leba.view.LebaFPSXListView.Listener;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LebaTitleBar
  extends RelativeLayout
  implements View.OnClickListener, Animation.AnimationListener
{
  private float jdField_a_of_type_Float;
  private View jdField_a_of_type_AndroidViewView;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  UniteSearchObserver jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver = new aehu(this);
  protected LebaFPSXListView.Listener a;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  protected List a;
  public boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  
  public LebaTitleBar(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(paramContext);
  }
  
  public LebaTitleBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(paramContext);
  }
  
  public LebaTitleBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    inflate(paramContext, 2130970407, this);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private void f()
  {
    ThreadManager.post(new aehs(this, new HotWordSearchEntryDataModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 4)), 5, null, true);
  }
  
  public void a()
  {
    LebaGridShowManager.a().a();
    if (LebaGridShowManager.a().a())
    {
      SearchProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 10800000L, "Leba");
      SearchProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      f();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Float == 0.0F) {
      this.jdField_a_of_type_Float = getHeight();
    }
    if (paramInt > this.jdField_a_of_type_Float) {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = FrameHelperActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a();
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
        this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
      }
    }
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = FrameHelperActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).b();
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
    this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)findViewById(2131363398));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131364897);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363447));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370352);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131368324));
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368738));
    this.jdField_b_of_type_Boolean = BaseApplicationImpl.sApplication.getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("has_search_bar", false);
    paramBaseActivity = this.jdField_a_of_type_AndroidViewView;
    if (this.jdField_b_of_type_Boolean) {}
    for (int i = 0;; i = 8)
    {
      paramBaseActivity.setVisibility(i);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new aehr(this));
      paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
      d();
      return;
    }
  }
  
  public void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba_with_feeds_search", 2, "SearchProtocol.sCurHomeHotWordIndex = " + SearchProtocol.a + ", hotSearchItems = " + paramList);
    }
    if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume())) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if ((paramList != null) && (paramList.size() > 0)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.lebatab.leba_with_feeds_search", 2, "updateHomeHotWord, hotSearchItems is null or empty");
        return;
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((HotWordSearchEntryDataModel.HotSearchItem)((Iterator)localObject).next()).showType == 2) {
            ((Iterator)localObject).remove();
          }
        }
        this.jdField_a_of_type_JavaUtilList = paramList;
      } while (this.jdField_a_of_type_JavaUtilList.size() == 0);
      if (SearchProtocol.a >= paramList.size()) {
        SearchProtocol.a = 0;
      }
      localObject = (HotWordSearchEntryDataModel.HotSearchItem)paramList.get(SearchProtocol.a);
    } while (this.jdField_a_of_type_AndroidWidgetTextView == null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("大家都在搜:%s", new Object[] { ((HotWordSearchEntryDataModel.HotSearchItem)localObject).title }));
    this.jdField_a_of_type_AndroidWidgetTextView.setTag(paramList.get(SearchProtocol.a));
    new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_all_search").c("home_page").d("exp_wording").a(new String[] { ((HotWordSearchEntryDataModel.HotSearchItem)localObject).title }).a();
  }
  
  public void b()
  {
    SearchProtocol.a += 1;
    a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 != null)
    {
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        break label99;
      }
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundResource(2130845952);
    }
    for (;;)
    {
      ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime(), false, null);
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131494261));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130842708), null, null, null);
      this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundDrawable(getResources().getDrawable(2130842713));
      return;
      label99:
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(getResources().getColor(2131494260));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131494286));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130846075), null, null, null);
    this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundDrawable(getResources().getDrawable(2130846077));
  }
  
  public void e()
  {
    if (LebaGridShowManager.a() == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(SearchEntryConfigManager.b());
      }
      boolean bool = LebaGridShowManager.a().a();
      if (bool)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        SearchProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 10800000L, "Leba");
      }
      while (bool != this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = bool;
        BaseApplicationImpl.sApplication.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("has_search_bar", bool).commit();
        return;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramAnimation = FrameHelperActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      paramAnimation.b(8);
      paramAnimation.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    while (paramAnimation != this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation) {
      return;
    }
    paramAnimation = FrameHelperActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    paramAnimation.b(0);
    paramAnimation.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_tt_right", 0, 0, "", "", "", "");
    LebaShowListManager.a().jdField_a_of_type_Boolean = true;
    ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b("100600");
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, LebaListMgrActivity.class);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView$Listener != null) {
      return (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView$Listener.a(paramMotionEvent)) || (super.onInterceptTouchEvent(paramMotionEvent));
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setListener(LebaFPSXListView.Listener paramListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView$Listener = paramListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.LebaTitleBar
 * JD-Core Version:    0.7.0.1
 */