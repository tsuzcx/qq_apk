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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
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
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter.a();
    }
  }
  
  public View a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559928, null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView = ((MeasureListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368446));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setDivider(null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377620));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365658));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365659));
    paramViewGroup = new AbsListView.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 7.0F));
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramViewGroup);
    paramViewGroup = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562959, null);
    this.c = ((TextView)paramViewGroup.findViewById(2131363848));
    this.d = ((TextView)paramViewGroup.findViewById(2131363849));
    this.e = ((TextView)paramViewGroup.findViewById(2131363850));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.addHeaderView(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.addFooterView(paramViewGroup);
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130850655);
    if (bool) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842509);
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterSearchWordHistoryAdapter = new SearchWordHistoryAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setOnTouchListener(new SearchWordHistoryEntryModel.1(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new SearchWordHistoryEntryModel.2(this, paramContext, paramQQAppInterface));
    paramContext = ((SearchWordHistoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SEARCH_WORD_HISTORY_MANAGER)).a();
    if (!paramContext.isEmpty())
    {
      paramViewGroup = new StringBuilder("");
      int i = 0;
      if (i < paramContext.size())
      {
        if (i != paramContext.size() - 1) {
          paramViewGroup.append((String)paramContext.get(i)).append("::");
        }
        for (;;)
        {
          i += 1;
          break;
          paramViewGroup.append((String)paramContext.get(i));
        }
      }
      UniteSearchReportController.a(null, new ReportModelDC02528().module("search_his").action("exp_search_his").ver2(UniteSearchReportController.a(this.jdField_b_of_type_Int)).ver4(paramViewGroup.toString()).ver7("{experiment_id:" + UniteSearchReportController.b + "}"));
      new UniteSearchHandler(paramQQAppInterface).b(paramQQAppInterface, "exp_search_his", "search_his", UniteSearchReportController.a(this.jdField_b_of_type_Int), "", paramViewGroup.toString(), "{experiment_id:" + UniteSearchReportController.b + "}");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchWordHistoryEntryModel
 * JD-Core Version:    0.7.0.1
 */