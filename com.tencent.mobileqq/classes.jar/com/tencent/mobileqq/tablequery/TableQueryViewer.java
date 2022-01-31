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
import aydf;
import aydg;
import aydl;
import aydm;
import aydo;
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
  private aydg jdField_a_of_type_Aydg;
  private aydo jdField_a_of_type_Aydo;
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
    LayoutInflater.from(paramContext).inflate(2131562484, this);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131373475));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131376828));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131367520));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364234));
    this.d = ((Button)findViewById(2131365229));
    Button localButton = this.d;
    if (aydg.jdField_b_of_type_Boolean)
    {
      localObject = paramContext.getString(2131690466);
      localButton.setText((CharSequence)localObject);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131374861));
      localButton = this.jdField_c_of_type_AndroidWidgetButton;
      if (!aydg.jdField_c_of_type_Boolean) {
        break label272;
      }
    }
    label272:
    for (Object localObject = paramContext.getString(2131690468);; localObject = paramContext.getString(2131690469))
    {
      localButton.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376830));
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
    this.jdField_a_of_type_AndroidViewView = findViewById(2131375146);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365405));
    this.jdField_a_of_type_Aydg = aydg.a();
    this.jdField_a_of_type_Aydo = new aydo(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Aydo);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer = this;
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemLongClickListener(new aydl(this, paramContext));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new aydm(this));
  }
  
  public int a(aydf paramaydf)
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilList.size(); j = k)
    {
      aydf localaydf = (aydf)this.jdField_a_of_type_JavaUtilList.get(i);
      k = j;
      if (paramaydf.b.contains(localaydf.a))
      {
        this.jdField_a_of_type_JavaUtilList.set(i, paramaydf);
        this.jdField_a_of_type_Aydo.notifyDataSetChanged();
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Aydo.notifyDataSetChanged();
  }
  
  public void a(aydf paramaydf)
  {
    this.jdField_a_of_type_JavaUtilList.add(0, paramaydf);
    this.jdField_a_of_type_Aydo.notifyDataSetChanged();
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
    case 2131364234: 
      a();
      return;
    case 2131374861: 
      if (aydg.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetButton.setText(getContext().getString(2131690469));
        aydg.jdField_c_of_type_Boolean = false;
        return;
      }
      this.jdField_c_of_type_AndroidWidgetButton.setText(getContext().getString(2131690468));
      aydg.jdField_c_of_type_Boolean = true;
      return;
    }
    if (aydg.jdField_b_of_type_Boolean)
    {
      this.d.setText(getContext().getString(2131690470));
      aydg.jdField_b_of_type_Boolean = false;
      return;
    }
    this.d.setText(getContext().getString(2131690466));
    aydg.jdField_b_of_type_Boolean = true;
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