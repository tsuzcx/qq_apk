package com.tencent.mobileqq.colornote.list;

import android.content.Context;
import android.support.v4.util.ArrayMap;
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
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgModel;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.ColorNoteConstants;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteProxy;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ColorNoteListController
  implements RecyclerView.ItemAnimator.ItemAnimatorFinishedListener, View.OnClickListener, OnListHideListener
{
  private static int jdField_a_of_type_Int = 2131167390;
  private static int jdField_b_of_type_Int = 2131167374;
  private static int jdField_c_of_type_Int = 2130839392;
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
  
  public ColorNoteListController(Context paramContext, OnListHideListener paramOnListHideListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqColornoteListOnListHideListener = paramOnListHideListener;
  }
  
  private void d()
  {
    f();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558991, null);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout = ((ColorNoteListLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364956));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364960));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363855));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131364959));
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
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363855).setOnTouchListener((View.OnTouchListener)localObject);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext), 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setFocusableInTouchMode(true);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setFocusable(true);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.requestFocus();
  }
  
  private void e()
  {
    this.jdField_c_of_type_Boolean = false;
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_b_of_type_AndroidViewView.hasFocus())) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.animate().alpha(0.0F).setDuration(200L).start();
    ViewPropertyAnimator localViewPropertyAnimator = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.animate().setInterpolator(new AccelerateInterpolator(3.0F));
    if (this.jdField_a_of_type_Boolean) {}
    for (float f = -this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getWidth();; f = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getWidth())
    {
      localViewPropertyAnimator.translationX(f).setDuration(180L).setListener(new ColorNoteListController.6(this)).start();
      return;
    }
  }
  
  private void f()
  {
    if (ThemeUtil.isNowThemeIsNight(null, false, null))
    {
      jdField_a_of_type_Int = 2131165376;
      jdField_b_of_type_Int = 2131165357;
      jdField_c_of_type_Int = 2130839393;
      return;
    }
    jdField_a_of_type_Int = 2131167390;
    jdField_b_of_type_Int = 2131167374;
    jdField_c_of_type_Int = 2130839392;
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
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = paramBoolean;
    d();
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter = new ColorNoteListAdapter();
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter.a(paramBoolean);
    Object localObject1 = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getProxyManager().a().a();
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter.a((List)localObject1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter.a(new ColorNoteListController.4(this));
    Object localObject2;
    int i;
    if (((List)localObject1).size() > 0)
    {
      localObject2 = (ColorNote)((List)localObject1).get(0);
      if (ColorNoteUtils.b((ColorNote)localObject2))
      {
        i = ColorNoteUtils.a(((ColorNote)localObject2).getServiceType());
        localObject2 = ReportUtil.a((ColorNote)localObject2);
        ReportController.b(null, "dc00898", "", "", "0X800A8AA", "0X800A8AA", ColorNoteConstants.b(i), 0, "", "", "", (String)localObject2);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setAnchor(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setHideListener(this);
    this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
    this.jdField_a_of_type_AndroidViewView.animate().alpha(0.9F).setDuration(200L).setListener(new ColorNoteListController.5(this, paramBoolean)).start();
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject2 = new ArrayMap();
      localObject3 = ((List)localObject1).iterator();
      label281:
      if (!((Iterator)localObject3).hasNext()) {
        break label365;
      }
      paramInt2 = ((ColorNote)((Iterator)localObject3).next()).getServiceType();
      if (!((ArrayMap)localObject2).containsValue(Integer.valueOf(paramInt2))) {
        break label360;
      }
    }
    label360:
    for (paramInt1 = ((Integer)((ArrayMap)localObject2).valueAt(paramInt2)).intValue() + 1;; paramInt1 = 1)
    {
      ((ArrayMap)localObject2).put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      break label281;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break;
    }
    label365:
    Object localObject3 = ((ArrayMap)localObject2).keySet().iterator();
    paramInt1 = 0;
    paramInt2 = 0;
    if (((Iterator)localObject3).hasNext())
    {
      i = ((Integer)((Iterator)localObject3).next()).intValue();
      if (((Integer)((ArrayMap)localObject2).get(Integer.valueOf(i))).intValue() <= paramInt2) {
        break label635;
      }
      paramInt1 = ((Integer)((ArrayMap)localObject2).get(Integer.valueOf(i))).intValue();
    }
    for (paramInt2 = i;; paramInt2 = i)
    {
      i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
      break;
      ReportController.b(null, "dc00898", "", "", "0X800A6CD", "0X800A6CD", 0, 0, ((List)localObject1).size() + "", ColorNoteConstants.a(paramInt1) + "", "", "");
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ColorNote)((Iterator)localObject1).next();
        if (ColorNoteUtils.d((ColorNote)localObject2))
        {
          localObject3 = UpComingMsgUtil.a((ColorNote)localObject2);
          if (ColorNoteUtils.c((ColorNote)localObject2)) {}
          for (paramInt1 = 1;; paramInt1 = 2)
          {
            ReportController.b(null, "dc00898", "", "", "0X800AE8E", "0X800AE8E", paramInt1, ((UpComingMsgModel)localObject3).reportType, "", "", "", "");
            break;
          }
        }
      }
      return;
      label635:
      i = paramInt1;
      paramInt1 = paramInt2;
    }
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
    f();
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
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      e();
      ReportController.b(null, "dc00898", "", "", "0X800A6CE", "0X800A6CE", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListController
 * JD-Core Version:    0.7.0.1
 */