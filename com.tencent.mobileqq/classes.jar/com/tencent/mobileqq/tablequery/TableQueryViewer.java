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
import aydd;
import ayde;
import aydj;
import aydk;
import aydm;
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
  private ayde jdField_a_of_type_Ayde;
  private aydm jdField_a_of_type_Aydm;
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
    LayoutInflater.from(paramContext).inflate(2131562485, this);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131373473));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131376826));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131367520));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364235));
    this.d = ((Button)findViewById(2131365230));
    Button localButton = this.d;
    if (ayde.jdField_b_of_type_Boolean)
    {
      localObject = paramContext.getString(2131690466);
      localButton.setText((CharSequence)localObject);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131374859));
      localButton = this.jdField_c_of_type_AndroidWidgetButton;
      if (!ayde.jdField_c_of_type_Boolean) {
        break label272;
      }
    }
    label272:
    for (Object localObject = paramContext.getString(2131690468);; localObject = paramContext.getString(2131690469))
    {
      localButton.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376828));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(getResources().getColor(2131165272));
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
      localObject = paramContext.getString(2131690470);
      break;
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131375144);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365406));
    this.jdField_a_of_type_Ayde = ayde.a();
    this.jdField_a_of_type_Aydm = new aydm(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Aydm);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer = this;
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemLongClickListener(new aydj(this, paramContext));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new aydk(this));
  }
  
  public int a(aydd paramaydd)
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilList.size(); j = k)
    {
      aydd localaydd = (aydd)this.jdField_a_of_type_JavaUtilList.get(i);
      k = j;
      if (paramaydd.b.contains(localaydd.a))
      {
        this.jdField_a_of_type_JavaUtilList.set(i, paramaydd);
        this.jdField_a_of_type_Aydm.notifyDataSetChanged();
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Aydm.notifyDataSetChanged();
  }
  
  public void a(aydd paramaydd)
  {
    this.jdField_a_of_type_JavaUtilList.add(0, paramaydd);
    this.jdField_a_of_type_Aydm.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367520: 
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setText(getContext().getString(2131690476));
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setEnabled(false);
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(getContext().getString(2131690467));
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setEnabled(true);
      this.jdField_b_of_type_Boolean = true;
      return;
    case 2131364235: 
      a();
      return;
    case 2131374859: 
      if (ayde.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetButton.setText(getContext().getString(2131690469));
        ayde.jdField_c_of_type_Boolean = false;
        return;
      }
      this.jdField_c_of_type_AndroidWidgetButton.setText(getContext().getString(2131690468));
      ayde.jdField_c_of_type_Boolean = true;
      return;
    }
    if (ayde.jdField_b_of_type_Boolean)
    {
      this.d.setText(getContext().getString(2131690470));
      ayde.jdField_b_of_type_Boolean = false;
      return;
    }
    this.d.setText(getContext().getString(2131690466));
    ayde.jdField_b_of_type_Boolean = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.TableQueryViewer
 * JD-Core Version:    0.7.0.1
 */