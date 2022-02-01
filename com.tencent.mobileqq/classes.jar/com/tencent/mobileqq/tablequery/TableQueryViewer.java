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
import beaa;
import beab;
import beag;
import beah;
import beaj;
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
  private beab jdField_a_of_type_Beab;
  private beaj jdField_a_of_type_Beaj;
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
    LayoutInflater.from(paramContext).inflate(2131562929, this);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131374842));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131378431));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131368205));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364663));
    this.d = ((Button)findViewById(2131365724));
    Button localButton = this.d;
    if (beab.jdField_b_of_type_Boolean)
    {
      localObject = paramContext.getString(2131690608);
      localButton.setText((CharSequence)localObject);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131376261));
      localButton = this.jdField_c_of_type_AndroidWidgetButton;
      if (!beab.jdField_c_of_type_Boolean) {
        break label272;
      }
    }
    label272:
    for (Object localObject = paramContext.getString(2131690610);; localObject = paramContext.getString(2131690611))
    {
      localButton.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131378433));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(getResources().getColor(2131165351));
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
      localObject = paramContext.getString(2131690612);
      break;
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376557);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365900));
    this.jdField_a_of_type_Beab = beab.a();
    this.jdField_a_of_type_Beaj = new beaj(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Beaj);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer = this;
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemLongClickListener(new beag(this, paramContext));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new beah(this));
  }
  
  public int a(beaa parambeaa)
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilList.size(); j = k)
    {
      beaa localbeaa = (beaa)this.jdField_a_of_type_JavaUtilList.get(i);
      k = j;
      if (parambeaa.b.contains(localbeaa.a))
      {
        this.jdField_a_of_type_JavaUtilList.set(i, parambeaa);
        this.jdField_a_of_type_Beaj.notifyDataSetChanged();
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Beaj.notifyDataSetChanged();
  }
  
  public void a(beaa parambeaa)
  {
    this.jdField_a_of_type_JavaUtilList.add(0, parambeaa);
    this.jdField_a_of_type_Beaj.notifyDataSetChanged();
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
        this.jdField_a_of_type_AndroidWidgetButton.setText(getContext().getString(2131690618));
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setEnabled(false);
        this.jdField_b_of_type_Boolean = false;
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setText(getContext().getString(2131690609));
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setEnabled(true);
        this.jdField_b_of_type_Boolean = true;
        continue;
        a();
        continue;
        if (beab.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_AndroidWidgetButton.setText(getContext().getString(2131690611));
          beab.jdField_c_of_type_Boolean = false;
        }
        else
        {
          this.jdField_c_of_type_AndroidWidgetButton.setText(getContext().getString(2131690610));
          beab.jdField_c_of_type_Boolean = true;
          continue;
          if (beab.jdField_b_of_type_Boolean)
          {
            this.d.setText(getContext().getString(2131690612));
            beab.jdField_b_of_type_Boolean = false;
          }
          else
          {
            this.d.setText(getContext().getString(2131690608));
            beab.jdField_b_of_type_Boolean = true;
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