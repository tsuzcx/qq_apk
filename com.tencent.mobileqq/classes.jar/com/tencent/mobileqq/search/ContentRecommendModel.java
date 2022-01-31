package com.tencent.mobileqq.search;

import ahcl;
import ahcm;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.model.ContentRecommendDataModel;
import com.tencent.mobileqq.search.model.ContentRecommendDataModel.ContentRecommendItem;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.XListView;
import java.util.List;
import java.util.Map;

public class ContentRecommendModel
  extends BaseSearchEntryModel
{
  public Context a;
  protected QQAppInterface a;
  protected ContentRecommendModel.ContentRecommendListAdapter a;
  protected XListView a;
  
  public ContentRecommendModel(int paramInt)
  {
    super(paramInt);
  }
  
  public View a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramBundle = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      if (!(paramContext instanceof BaseActivity)) {
        break label158;
      }
    }
    label158:
    for (paramViewGroup = ((BaseActivity)paramContext).getAppRuntime();; paramViewGroup = null)
    {
      paramBundle = paramQQAppInterface;
      if ((paramViewGroup instanceof QQAppInterface)) {
        paramBundle = (QQAppInterface)paramViewGroup;
      }
      if (paramBundle == null) {
        return new View(paramContext);
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchContentRecommendModel$ContentRecommendListAdapter = new ContentRecommendModel.ContentRecommendListAdapter(this);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968825, null));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new ahcl(this));
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSearchContentRecommendModel$ContentRecommendListAdapter);
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838576);
      }
      for (;;)
      {
        return this.jdField_a_of_type_ComTencentWidgetXListView;
        this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838575);
      }
    }
  }
  
  public void a()
  {
    ThreadManager.post(new ahcm(this, new ContentRecommendDataModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, this.jdField_a_of_type_Int)), 5, null, true);
  }
  
  public void a(SearchEntryDataModel paramSearchEntryDataModel)
  {
    b(paramSearchEntryDataModel);
  }
  
  public void b()
  {
    super.b();
  }
  
  public void b(SearchEntryDataModel paramSearchEntryDataModel)
  {
    paramSearchEntryDataModel = (ContentRecommendDataModel)paramSearchEntryDataModel;
    if (paramSearchEntryDataModel == null) {}
    do
    {
      return;
      paramSearchEntryDataModel = paramSearchEntryDataModel.a;
    } while ((paramSearchEntryDataModel == null) || (paramSearchEntryDataModel.size() == 0));
    this.jdField_a_of_type_ComTencentMobileqqSearchContentRecommendModel$ContentRecommendListAdapter.a(paramSearchEntryDataModel);
    d();
    Boolean localBoolean = (Boolean)SearchEntryFragment.a.get(Integer.valueOf(4));
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      int i = 0;
      while (i < paramSearchEntryDataModel.size())
      {
        SearchUtils.a("home_page", "exp_content_rec", new String[] { ((ContentRecommendDataModel.ContentRecommendItem)paramSearchEntryDataModel.get(i)).a, String.valueOf(this.jdField_a_of_type_Int) });
        i += 1;
      }
    }
    SearchEntryFragment.a.put(Integer.valueOf(4), Boolean.valueOf(true));
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchContentRecommendModel$ContentRecommendListAdapter == null)) {}
    Object localObject;
    int j;
    do
    {
      return;
      int k = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_ComTencentWidgetXListView.getWidth(), 0);
      localObject = null;
      j = 0;
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqSearchContentRecommendModel$ContentRecommendListAdapter.getCount())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqSearchContentRecommendModel$ContentRecommendListAdapter.getView(i, (View)localObject, this.jdField_a_of_type_ComTencentWidgetXListView);
        if (i == 0) {
          ((View)localObject).setLayoutParams(new ViewGroup.LayoutParams(k, -2));
        }
        ((View)localObject).measure(k, 0);
        j += ((View)localObject).getMeasuredHeight();
        i += 1;
      }
      localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getLayoutParams();
    } while (localObject == null);
    ((ViewGroup.LayoutParams)localObject).height = (this.jdField_a_of_type_ComTencentWidgetXListView.getDividerHeight() * (this.jdField_a_of_type_ComTencentMobileqqSearchContentRecommendModel$ContentRecommendListAdapter.getCount() - 1) + j);
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContentRecommendModel
 * JD-Core Version:    0.7.0.1
 */