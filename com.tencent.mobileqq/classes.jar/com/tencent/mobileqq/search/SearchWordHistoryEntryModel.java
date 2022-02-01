package com.tencent.mobileqq.search;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.adapter.SearchWordHistoryAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SearchWordHistoryManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.MeasureListView;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class SearchWordHistoryEntryModel
  extends BaseSearchEntryModel<View>
{
  private Context jdField_a_of_type_AndroidContentContext;
  protected View a;
  protected ImageView a;
  protected RelativeLayout a;
  protected TextView a;
  protected SearchWordHistoryAdapter a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected MeasureListView a;
  protected int b;
  private TextView b;
  private TextView c = null;
  private TextView d = null;
  private TextView e = null;
  
  public SearchWordHistoryEntryModel(int paramInt)
  {
    super(paramInt);
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void d()
  {
    SearchWordHistoryAdapter localSearchWordHistoryAdapter = this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter;
    if (localSearchWordHistoryAdapter != null) {
      localSearchWordHistoryAdapter.a();
    }
  }
  
  public View a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559798, null);
    paramViewGroup = this.jdField_a_of_type_AndroidViewView;
    int i = 0;
    paramViewGroup.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView = ((MeasureListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368196));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setDivider(null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377061));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365502));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365503));
    paramViewGroup = new AbsListView.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 7.0F));
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramViewGroup);
    paramViewGroup = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562778, null);
    this.c = ((TextView)paramViewGroup.findViewById(2131363776));
    this.d = ((TextView)paramViewGroup.findViewById(2131363777));
    this.e = ((TextView)paramViewGroup.findViewById(2131363778));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.addHeaderView(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.addFooterView(paramViewGroup);
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130850581);
    if (bool) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842408);
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter = new SearchWordHistoryAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setOnTouchListener(new SearchWordHistoryEntryModel.1(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new SearchWordHistoryEntryModel.2(this, paramContext, paramQQAppInterface));
    paramViewGroup = ((SearchWordHistoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SEARCH_WORD_HISTORY_MANAGER)).a();
    if (!paramViewGroup.isEmpty())
    {
      paramContext = new StringBuilder("");
      while (i < paramViewGroup.size())
      {
        if (i != paramViewGroup.size() - 1)
        {
          paramContext.append((String)paramViewGroup.get(i));
          paramContext.append("::");
        }
        else
        {
          paramContext.append((String)paramViewGroup.get(i));
        }
        i += 1;
      }
      paramViewGroup = new ReportModelDC02528().module("search_his").action("exp_search_his").ver2(UniteSearchReportController.a(this.jdField_b_of_type_Int)).ver4(paramContext.toString());
      paramBundle = new StringBuilder();
      paramBundle.append("{experiment_id:");
      paramBundle.append(UniteSearchReportController.b);
      paramBundle.append("}");
      UniteSearchReportController.a(null, paramViewGroup.ver7(paramBundle.toString()));
      paramViewGroup = new UniteSearchHandler(paramQQAppInterface);
      paramBundle = UniteSearchReportController.a(this.jdField_b_of_type_Int);
      paramContext = paramContext.toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{experiment_id:");
      localStringBuilder.append(UniteSearchReportController.b);
      localStringBuilder.append("}");
      paramViewGroup.b(paramQQAppInterface, "exp_search_his", "search_his", paramBundle, "", paramContext, localStringBuilder.toString());
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter);
    d();
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter = null;
    }
  }
  
  public void c()
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchWordHistoryEntryModel
 * JD-Core Version:    0.7.0.1
 */