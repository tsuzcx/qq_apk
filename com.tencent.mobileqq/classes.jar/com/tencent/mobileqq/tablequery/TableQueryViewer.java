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
import bdzk;
import bdzl;
import bdzq;
import bdzr;
import bdzt;
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
  private bdzl jdField_a_of_type_Bdzl;
  private bdzt jdField_a_of_type_Bdzt;
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
    LayoutInflater.from(paramContext).inflate(2131562979, this);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131374837));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131378376));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131368035));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364559));
    this.d = ((Button)findViewById(2131365598));
    Button localButton = this.d;
    if (bdzl.jdField_b_of_type_Boolean)
    {
      localObject = paramContext.getString(2131690493);
      localButton.setText((CharSequence)localObject);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131376248));
      localButton = this.jdField_c_of_type_AndroidWidgetButton;
      if (!bdzl.jdField_c_of_type_Boolean) {
        break label272;
      }
    }
    label272:
    for (Object localObject = paramContext.getString(2131690495);; localObject = paramContext.getString(2131690496))
    {
      localButton.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131378378));
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
      localObject = paramContext.getString(2131690497);
      break;
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376536);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365770));
    this.jdField_a_of_type_Bdzl = bdzl.a();
    this.jdField_a_of_type_Bdzt = new bdzt(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Bdzt);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer = this;
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemLongClickListener(new bdzq(this, paramContext));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new bdzr(this));
  }
  
  public int a(bdzk parambdzk)
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilList.size(); j = k)
    {
      bdzk localbdzk = (bdzk)this.jdField_a_of_type_JavaUtilList.get(i);
      k = j;
      if (parambdzk.b.contains(localbdzk.a))
      {
        this.jdField_a_of_type_JavaUtilList.set(i, parambdzk);
        this.jdField_a_of_type_Bdzt.notifyDataSetChanged();
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Bdzt.notifyDataSetChanged();
  }
  
  public void a(bdzk parambdzk)
  {
    this.jdField_a_of_type_JavaUtilList.add(0, parambdzk);
    this.jdField_a_of_type_Bdzt.notifyDataSetChanged();
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
        this.jdField_a_of_type_AndroidWidgetButton.setText(getContext().getString(2131690503));
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setEnabled(false);
        this.jdField_b_of_type_Boolean = false;
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setText(getContext().getString(2131690494));
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setEnabled(true);
        this.jdField_b_of_type_Boolean = true;
        continue;
        a();
        continue;
        if (bdzl.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_AndroidWidgetButton.setText(getContext().getString(2131690496));
          bdzl.jdField_c_of_type_Boolean = false;
        }
        else
        {
          this.jdField_c_of_type_AndroidWidgetButton.setText(getContext().getString(2131690495));
          bdzl.jdField_c_of_type_Boolean = true;
          continue;
          if (bdzl.jdField_b_of_type_Boolean)
          {
            this.d.setText(getContext().getString(2131690497));
            bdzl.jdField_b_of_type_Boolean = false;
          }
          else
          {
            this.d.setText(getContext().getString(2131690493));
            bdzl.jdField_b_of_type_Boolean = true;
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