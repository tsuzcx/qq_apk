package com.tencent.mobileqq.troop.createNewTroop;

import ainr;
import ains;
import aint;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import java.util.ArrayList;

public class SubCateListView
{
  public final Context a;
  protected final View.OnClickListener a;
  protected View a;
  protected final ViewStub a;
  protected CateListAdapter.SingleItemViewHolder a;
  protected SubCateListAdapter a;
  public final SubCateListView.OnToggleSubListListener a;
  protected boolean a;
  protected View b;
  
  public SubCateListView(ViewStub paramViewStub, Context paramContext, View.OnClickListener paramOnClickListener, SubCateListView.OnToggleSubListListener paramOnToggleSubListListener)
  {
    this.jdField_a_of_type_AndroidViewViewStub = paramViewStub;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopSubCateListView$OnToggleSubListListener = paramOnToggleSubListListener;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, Interpolator paramInterpolator, boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.setDuration(200L);
    localValueAnimator.setInterpolator(paramInterpolator);
    localValueAnimator.addUpdateListener(new ainr(this, paramView));
    localValueAnimator.addListener(new ains(this, paramBoolean, paramView, paramInt2));
    localValueAnimator.start();
  }
  
  private void a(CateListAdapter.SingleItemViewHolder paramSingleItemViewHolder, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 100 });; localValueAnimator = ValueAnimator.ofInt(new int[] { 100, 0 }))
    {
      localValueAnimator.setDuration(200L);
      localValueAnimator.setInterpolator(new LinearInterpolator());
      localValueAnimator.addUpdateListener(new aint(this, paramSingleItemViewHolder));
      localValueAnimator.start();
      return;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
    GridView localGridView = (GridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368281);
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopSubCateListAdapter = new SubCateListAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopSubCateListAdapter);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131368280);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter$SingleItemViewHolder = null;
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public boolean a(CateListAdapter.SingleItemViewHolder paramSingleItemViewHolder, TroopCateListProvider.TroopCateInfo paramTroopCateInfo)
  {
    b();
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter$SingleItemViewHolder != null)
    {
      i = ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).height;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter$SingleItemViewHolder == paramSingleItemViewHolder)
      {
        a(paramSingleItemViewHolder, false);
        a(this.jdField_a_of_type_AndroidViewView, i, 0, new DecelerateInterpolator(), true);
        this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter$SingleItemViewHolder = null;
        return false;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter$SingleItemViewHolder, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopSubCateListAdapter.a(paramTroopCateInfo);
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter$SingleItemViewHolder = paramSingleItemViewHolder;
      int[] arrayOfInt = new int[2];
      paramSingleItemViewHolder.a.getLocationInWindow(arrayOfInt);
      int j = arrayOfInt[0];
      int k = paramSingleItemViewHolder.a.getWidth() / 2;
      int m = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 14.14F);
      this.b.setTranslationX(j + k - m);
      j = (int)Math.ceil(paramTroopCateInfo.a.size() / 3.0F);
      j = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, j * 56 - 13 + 20 + 30 + 30);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      a(paramSingleItemViewHolder, true);
      a(this.jdField_a_of_type_AndroidViewView, i, j, new AccelerateInterpolator(), false);
      return true;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.SubCateListView
 * JD-Core Version:    0.7.0.1
 */