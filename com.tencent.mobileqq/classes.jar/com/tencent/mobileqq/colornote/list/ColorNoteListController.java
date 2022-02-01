package com.tencent.mobileqq.colornote.list;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import com.tencent.mobileqq.colornote.api.IColorNoteDataService;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class ColorNoteListController
  implements RecyclerView.ItemAnimator.ItemAnimatorFinishedListener, View.OnClickListener, OnListHideListener
{
  private static int jdField_a_of_type_Int = 2131167410;
  private static final List<IColorNoteListListener> jdField_a_of_type_JavaUtilList = new ArrayList();
  private static int jdField_b_of_type_Int = 2131167394;
  private static int jdField_c_of_type_Int = 2130839249;
  private Context jdField_a_of_type_AndroidContentContext;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ColorNoteListAdapter jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter;
  private ColorNoteListLayout jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout;
  private OnListHideListener jdField_a_of_type_ComTencentMobileqqColornoteListOnListHideListener;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean jdField_c_of_type_Boolean = false;
  
  static
  {
    try
    {
      Iterator localIterator = ColorNoteListInjectUtil.a.iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        jdField_a_of_type_JavaUtilList.add(localClass.newInstance());
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ColorNoteListController", 1, "[static] ", localException);
    }
  }
  
  public ColorNoteListController(Context paramContext, OnListHideListener paramOnListHideListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqColornoteListOnListHideListener = paramOnListHideListener;
  }
  
  private void b(List<ColorNote> paramList)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IColorNoteListListener)localIterator.next()).a(paramList);
    }
  }
  
  private void d()
  {
    g();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558886, null);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout = ((ColorNoteListLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364840));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364844));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363783));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131364843));
    Object localObject = new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext);
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ColorNoteListController.1(this));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new ColorNoteListController.2(this));
    localObject = new ColorNoteListController.3(this);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener((View.OnTouchListener)localObject);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363783).setOnTouchListener((View.OnTouchListener)localObject);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext), 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setFocusableInTouchMode(true);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setFocusable(true);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.requestFocus();
  }
  
  private void e()
  {
    this.jdField_c_of_type_Boolean = false;
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getVisibility() == 0) && (this.jdField_b_of_type_AndroidViewView.hasFocus())) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.animate().alpha(0.0F).setDuration(200L).start();
    localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.animate().setInterpolator(new AccelerateInterpolator(3.0F));
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = -this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getWidth();
    } else {
      i = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getWidth();
    }
    ((ViewPropertyAnimator)localObject).translationX(i).setDuration(180L).setListener(new ColorNoteListController.6(this)).start();
    f();
  }
  
  private void f()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IColorNoteListListener)localIterator.next()).a();
    }
  }
  
  private void g()
  {
    if (QQTheme.a())
    {
      jdField_a_of_type_Int = 2131165344;
      jdField_b_of_type_Int = 2131165327;
      jdField_c_of_type_Int = 2130839250;
      return;
    }
    jdField_a_of_type_Int = 2131167410;
    jdField_b_of_type_Int = 2131167394;
    jdField_c_of_type_Int = 2130839249;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter.notifyDataSetChanged();
  }
  
  public void a(List<ColorNote> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter.a(paramList);
    a();
  }
  
  public void a(AppRuntime paramAppRuntime, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = paramBoolean;
    d();
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter = new ColorNoteListAdapter(jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter.a(paramBoolean);
    paramAppRuntime = ((IColorNoteDataService)paramAppRuntime.getRuntimeService(IColorNoteDataService.class, "all")).getVisiableColorNotes();
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter.a(paramAppRuntime);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter.a(new ColorNoteListController.4(this));
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setAnchor(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setHideListener(this);
    this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
    this.jdField_a_of_type_AndroidViewView.animate().alpha(0.9F).setDuration(200L).setListener(new ColorNoteListController.5(this, paramBoolean)).start();
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    } else {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    b(paramAppRuntime);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b()
  {
    e();
  }
  
  public void c()
  {
    g();
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(jdField_c_of_type_Int);
  }
  
  public void onAnimationsFinished()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter.getItemCount() == 0) {
      e();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131364841) || (i == 2131364840) || (i == 2131364848))
    {
      e();
      ReportController.b(null, "dc00898", "", "", "0X800A6CE", "0X800A6CE", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListController
 * JD-Core Version:    0.7.0.1
 */