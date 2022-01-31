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
import babc;
import babd;
import babi;
import babj;
import babl;
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
  private babd jdField_a_of_type_Babd;
  private babl jdField_a_of_type_Babl;
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
    LayoutInflater.from(paramContext).inflate(2131562688, this);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131373927));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131377341));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131367648));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364299));
    this.d = ((Button)findViewById(2131365314));
    Button localButton = this.d;
    if (babd.jdField_b_of_type_Boolean)
    {
      localObject = paramContext.getString(2131690517);
      localButton.setText((CharSequence)localObject);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131375329));
      localButton = this.jdField_c_of_type_AndroidWidgetButton;
      if (!babd.jdField_c_of_type_Boolean) {
        break label272;
      }
    }
    label272:
    for (Object localObject = paramContext.getString(2131690519);; localObject = paramContext.getString(2131690520))
    {
      localButton.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377343));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(getResources().getColor(2131165304));
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
      localObject = paramContext.getString(2131690521);
      break;
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131375627);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365489));
    this.jdField_a_of_type_Babd = babd.a();
    this.jdField_a_of_type_Babl = new babl(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Babl);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer = this;
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemLongClickListener(new babi(this, paramContext));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new babj(this));
  }
  
  public int a(babc parambabc)
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilList.size(); j = k)
    {
      babc localbabc = (babc)this.jdField_a_of_type_JavaUtilList.get(i);
      k = j;
      if (parambabc.b.contains(localbabc.a))
      {
        this.jdField_a_of_type_JavaUtilList.set(i, parambabc);
        this.jdField_a_of_type_Babl.notifyDataSetChanged();
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Babl.notifyDataSetChanged();
  }
  
  public void a(babc parambabc)
  {
    this.jdField_a_of_type_JavaUtilList.add(0, parambabc);
    this.jdField_a_of_type_Babl.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367648: 
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setText(getContext().getString(2131690527));
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setEnabled(false);
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(getContext().getString(2131690518));
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setEnabled(true);
      this.jdField_b_of_type_Boolean = true;
      return;
    case 2131364299: 
      a();
      return;
    case 2131375329: 
      if (babd.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetButton.setText(getContext().getString(2131690520));
        babd.jdField_c_of_type_Boolean = false;
        return;
      }
      this.jdField_c_of_type_AndroidWidgetButton.setText(getContext().getString(2131690519));
      babd.jdField_c_of_type_Boolean = true;
      return;
    }
    if (babd.jdField_b_of_type_Boolean)
    {
      this.d.setText(getContext().getString(2131690521));
      babd.jdField_b_of_type_Boolean = false;
      return;
    }
    this.d.setText(getContext().getString(2131690517));
    babd.jdField_b_of_type_Boolean = true;
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