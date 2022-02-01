package com.tencent.mobileqq.tribe;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mobileqq.tribe.view.TribeTitlePrefixPanelView;
import com.tencent.mobileqq.tribe.view.TribeTitlePrefixPanelView.TitlePrefixItem;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class TribePostTitlePrefixPanelController
{
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator = null;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private TribeTitlePrefixPanelView jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator = null;
  private boolean jdField_b_of_type_Boolean = false;
  
  public TribePostTitlePrefixPanelController(ListView paramListView, TribeTitlePrefixPanelView paramTribeTitlePrefixPanelView, List<TribeTitlePrefixPanelView.TitlePrefixItem> paramList)
  {
    this.jdField_a_of_type_AndroidWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView = paramTribeTitlePrefixPanelView;
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView.a(paramList);
    a(this.jdField_a_of_type_AndroidWidgetListView);
    paramTribeTitlePrefixPanelView = this.jdField_a_of_type_AndroidWidgetListView.getLayoutParams();
    paramTribeTitlePrefixPanelView.height = this.jdField_a_of_type_Int;
    paramTribeTitlePrefixPanelView.width = this.jdField_b_of_type_Int;
    paramListView.setLayoutParams(paramTribeTitlePrefixPanelView);
    this.jdField_a_of_type_AndroidWidgetListView.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidWidgetListView.getContext(), 8.0F), -this.jdField_a_of_type_Int, 0, 0);
  }
  
  public static List<TribeTitlePrefixPanelView.TitlePrefixItem> a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TribePostTitlePrefixPanelController", 2, "prefixJArray is null");
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        TribeTitlePrefixPanelView.TitlePrefixItem localTitlePrefixItem = new TribeTitlePrefixPanelView.TitlePrefixItem();
        try
        {
          localTitlePrefixItem.a(localJSONObject);
          if (localTitlePrefixItem.a()) {
            localArrayList.add(localTitlePrefixItem);
          }
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("TribePostTitlePrefixPanelController", 2, "analyze error , " + localException);
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { -this.jdField_a_of_type_Int, 0 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(100L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new TribePostTitlePrefixPanelController.1(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new TribePostTitlePrefixPanelController.2(this));
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, -this.jdField_a_of_type_Int });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(100L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new TribePostTitlePrefixPanelController.3(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new TribePostTitlePrefixPanelController.4(this));
  }
  
  public void a()
  {
    if ((!a()) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null) {
        d();
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new BounceInterpolator());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  public void a(ListView paramListView)
  {
    ListAdapter localListAdapter = paramListView.getAdapter();
    if (localListAdapter == null) {
      return;
    }
    int k = localListAdapter.getCount();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      View localView = localListAdapter.getView(i, null, paramListView);
      localView.measure(0, 0);
      j += localView.getMeasuredHeight();
      int m = localView.getMeasuredWidth();
      if (m > this.jdField_b_of_type_Int) {
        this.jdField_b_of_type_Int = m;
      }
      i += 1;
    }
    this.jdField_a_of_type_Int = (paramListView.getDividerHeight() * (localListAdapter.getCount() - 1) + j);
    this.jdField_b_of_type_Int += DisplayUtil.a(this.jdField_a_of_type_AndroidWidgetListView.getContext(), 8.0F);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetListView.getVisibility() == 0;
  }
  
  public void b()
  {
    if ((a()) && (!this.jdField_a_of_type_Boolean))
    {
      if (this.jdField_b_of_type_AndroidAnimationValueAnimator == null) {
        e();
      }
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_AndroidWidgetListView.getVisibility() != 0) || (this.jdField_b_of_type_Boolean);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.TribePostTitlePrefixPanelController
 * JD-Core Version:    0.7.0.1
 */