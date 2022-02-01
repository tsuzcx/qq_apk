package com.tencent.mobileqq.tablequery;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedList;
import java.util.List;

public class TableQueryViewer
  extends RelativeLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TableQueryController jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryController;
  private TableQueryViewer.TableQueryAdapter jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer$TableQueryAdapter;
  private TableQueryViewer jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = true;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private boolean jdField_b_of_type_Boolean = true;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private boolean jdField_c_of_type_Boolean;
  private Button d;
  
  public TableQueryViewer(Context paramContext)
  {
    super(paramContext);
    int i = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    LayoutInflater.from(paramContext).inflate(2131562907, this);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131374734));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131378249));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131368179));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364665));
    this.d = ((Button)findViewById(2131365725));
    Button localButton = this.d;
    Object localObject;
    if (TableQueryController.jdField_b_of_type_Boolean) {
      localObject = paramContext.getString(2131690638);
    } else {
      localObject = paramContext.getString(2131690642);
    }
    localButton.setText((CharSequence)localObject);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131376160));
    localButton = this.jdField_c_of_type_AndroidWidgetButton;
    if (TableQueryController.jdField_c_of_type_Boolean) {
      localObject = paramContext.getString(2131690640);
    } else {
      localObject = paramContext.getString(2131690641);
    }
    localButton.setText((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131378251));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(getResources().getColor(2131165321));
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localObject instanceof TextView))
      {
        localObject = (TextView)localObject;
        ((TextView)localObject).setTextColor(-1);
        ((TextView)localObject).setTypeface(Typeface.defaultFromStyle(1));
      }
      i += 1;
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376440);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365894));
    this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryController = TableQueryController.a();
    this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer$TableQueryAdapter = new TableQueryViewer.TableQueryAdapter(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer$TableQueryAdapter);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer = this;
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemLongClickListener(new TableQueryViewer.1(this, paramContext));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new TableQueryViewer.2(this));
  }
  
  public int a(QueryData paramQueryData)
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilList.size(); j = k)
    {
      QueryData localQueryData = (QueryData)this.jdField_a_of_type_JavaUtilList.get(i);
      k = j;
      if (paramQueryData.b.contains(localQueryData.a))
      {
        this.jdField_a_of_type_JavaUtilList.set(i, paramQueryData);
        this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer$TableQueryAdapter.notifyDataSetChanged();
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer$TableQueryAdapter.notifyDataSetChanged();
  }
  
  public void a(QueryData paramQueryData)
  {
    this.jdField_a_of_type_JavaUtilList.add(0, paramQueryData);
    this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer$TableQueryAdapter.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131376160: 
      if (TableQueryController.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetButton.setText(getContext().getString(2131690641));
        TableQueryController.jdField_c_of_type_Boolean = false;
      }
      else
      {
        this.jdField_c_of_type_AndroidWidgetButton.setText(getContext().getString(2131690640));
        TableQueryController.jdField_c_of_type_Boolean = true;
      }
      break;
    case 2131368179: 
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setText(getContext().getString(2131690648));
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setEnabled(false);
        this.jdField_b_of_type_Boolean = false;
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setText(getContext().getString(2131690639));
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setEnabled(true);
        this.jdField_b_of_type_Boolean = true;
      }
      break;
    case 2131365725: 
      if (TableQueryController.jdField_b_of_type_Boolean)
      {
        this.d.setText(getContext().getString(2131690642));
        TableQueryController.jdField_b_of_type_Boolean = false;
      }
      else
      {
        this.d.setText(getContext().getString(2131690638));
        TableQueryController.jdField_b_of_type_Boolean = true;
      }
      break;
    case 2131364665: 
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.TableQueryViewer
 * JD-Core Version:    0.7.0.1
 */