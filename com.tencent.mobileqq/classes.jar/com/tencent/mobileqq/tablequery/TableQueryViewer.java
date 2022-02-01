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
import bctb;
import bctc;
import bcth;
import bcti;
import bctk;
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
  private bctc jdField_a_of_type_Bctc;
  private bctk jdField_a_of_type_Bctk;
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
    LayoutInflater.from(paramContext).inflate(2131562858, this);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131374602));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131378143));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131368070));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364580));
    this.d = ((Button)findViewById(2131365631));
    Button localButton = this.d;
    if (bctc.jdField_b_of_type_Boolean)
    {
      localObject = paramContext.getString(2131690533);
      localButton.setText((CharSequence)localObject);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131376014));
      localButton = this.jdField_c_of_type_AndroidWidgetButton;
      if (!bctc.jdField_c_of_type_Boolean) {
        break label272;
      }
    }
    label272:
    for (Object localObject = paramContext.getString(2131690535);; localObject = paramContext.getString(2131690536))
    {
      localButton.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131378145));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(getResources().getColor(2131165345));
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
      localObject = paramContext.getString(2131690537);
      break;
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376302);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365802));
    this.jdField_a_of_type_Bctc = bctc.a();
    this.jdField_a_of_type_Bctk = new bctk(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Bctk);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer = this;
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemLongClickListener(new bcth(this, paramContext));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new bcti(this));
  }
  
  public int a(bctb parambctb)
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilList.size(); j = k)
    {
      bctb localbctb = (bctb)this.jdField_a_of_type_JavaUtilList.get(i);
      k = j;
      if (parambctb.b.contains(localbctb.a))
      {
        this.jdField_a_of_type_JavaUtilList.set(i, parambctb);
        this.jdField_a_of_type_Bctk.notifyDataSetChanged();
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Bctk.notifyDataSetChanged();
  }
  
  public void a(bctb parambctb)
  {
    this.jdField_a_of_type_JavaUtilList.add(0, parambctb);
    this.jdField_a_of_type_Bctk.notifyDataSetChanged();
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
        this.jdField_a_of_type_AndroidWidgetButton.setText(getContext().getString(2131690543));
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setEnabled(false);
        this.jdField_b_of_type_Boolean = false;
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setText(getContext().getString(2131690534));
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setEnabled(true);
        this.jdField_b_of_type_Boolean = true;
        continue;
        a();
        continue;
        if (bctc.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_AndroidWidgetButton.setText(getContext().getString(2131690536));
          bctc.jdField_c_of_type_Boolean = false;
        }
        else
        {
          this.jdField_c_of_type_AndroidWidgetButton.setText(getContext().getString(2131690535));
          bctc.jdField_c_of_type_Boolean = true;
          continue;
          if (bctc.jdField_b_of_type_Boolean)
          {
            this.d.setText(getContext().getString(2131690537));
            bctc.jdField_b_of_type_Boolean = false;
          }
          else
          {
            this.d.setText(getContext().getString(2131690533));
            bctc.jdField_b_of_type_Boolean = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.TableQueryViewer
 * JD-Core Version:    0.7.0.1
 */