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
import bdgp;
import bdgq;
import bdgv;
import bdgw;
import bdgy;
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
  private bdgq jdField_a_of_type_Bdgq;
  private bdgy jdField_a_of_type_Bdgy;
  private TableQueryViewer jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer;
  private List jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean = true;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private boolean jdField_b_of_type_Boolean = true;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private boolean jdField_c_of_type_Boolean;
  private Button d;
  
  public TableQueryViewer(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2131562945, this);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131374700));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131378219));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131367965));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364515));
    this.d = ((Button)findViewById(2131365556));
    Button localButton = this.d;
    if (bdgq.jdField_b_of_type_Boolean)
    {
      localObject = paramContext.getString(2131690498);
      localButton.setText((CharSequence)localObject);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131376108));
      localButton = this.jdField_c_of_type_AndroidWidgetButton;
      if (!bdgq.jdField_c_of_type_Boolean) {
        break label272;
      }
    }
    label272:
    for (Object localObject = paramContext.getString(2131690500);; localObject = paramContext.getString(2131690501))
    {
      localButton.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131378221));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(getResources().getColor(2131165337));
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        if ((localObject instanceof TextView))
        {
          ((TextView)localObject).setTextColor(-1);
          ((TextView)localObject).setTypeface(Typeface.defaultFromStyle(1));
        }
        i += 1;
      }
      localObject = paramContext.getString(2131690502);
      break;
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376404);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365727));
    this.jdField_a_of_type_Bdgq = bdgq.a();
    this.jdField_a_of_type_Bdgy = new bdgy(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Bdgy);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer = this;
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemLongClickListener(new bdgv(this, paramContext));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new bdgw(this));
  }
  
  public int a(bdgp parambdgp)
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilList.size(); j = k)
    {
      bdgp localbdgp = (bdgp)this.jdField_a_of_type_JavaUtilList.get(i);
      k = j;
      if (parambdgp.b.contains(localbdgp.a))
      {
        this.jdField_a_of_type_JavaUtilList.set(i, parambdgp);
        this.jdField_a_of_type_Bdgy.notifyDataSetChanged();
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Bdgy.notifyDataSetChanged();
  }
  
  public void a(bdgp parambdgp)
  {
    this.jdField_a_of_type_JavaUtilList.add(0, parambdgp);
    this.jdField_a_of_type_Bdgy.notifyDataSetChanged();
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
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setText(getContext().getString(2131690508));
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setEnabled(false);
        this.jdField_b_of_type_Boolean = false;
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setText(getContext().getString(2131690499));
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setEnabled(true);
        this.jdField_b_of_type_Boolean = true;
        continue;
        a();
        continue;
        if (bdgq.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_AndroidWidgetButton.setText(getContext().getString(2131690501));
          bdgq.jdField_c_of_type_Boolean = false;
        }
        else
        {
          this.jdField_c_of_type_AndroidWidgetButton.setText(getContext().getString(2131690500));
          bdgq.jdField_c_of_type_Boolean = true;
          continue;
          if (bdgq.jdField_b_of_type_Boolean)
          {
            this.d.setText(getContext().getString(2131690502));
            bdgq.jdField_b_of_type_Boolean = false;
          }
          else
          {
            this.d.setText(getContext().getString(2131690498));
            bdgq.jdField_b_of_type_Boolean = true;
          }
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.TableQueryViewer
 * JD-Core Version:    0.7.0.1
 */