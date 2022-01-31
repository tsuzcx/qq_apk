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
import bafl;
import bafm;
import bafr;
import bafs;
import bafu;
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
  private bafm jdField_a_of_type_Bafm;
  private bafu jdField_a_of_type_Bafu;
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
    LayoutInflater.from(paramContext).inflate(2131562706, this);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131373978));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131377395));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131367658));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364301));
    this.d = ((Button)findViewById(2131365316));
    Button localButton = this.d;
    if (bafm.jdField_b_of_type_Boolean)
    {
      localObject = paramContext.getString(2131690517);
      localButton.setText((CharSequence)localObject);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131375380));
      localButton = this.jdField_c_of_type_AndroidWidgetButton;
      if (!bafm.jdField_c_of_type_Boolean) {
        break label272;
      }
    }
    label272:
    for (Object localObject = paramContext.getString(2131690519);; localObject = paramContext.getString(2131690520))
    {
      localButton.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377397));
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
    this.jdField_a_of_type_AndroidViewView = findViewById(2131375678);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365491));
    this.jdField_a_of_type_Bafm = bafm.a();
    this.jdField_a_of_type_Bafu = new bafu(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Bafu);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer = this;
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemLongClickListener(new bafr(this, paramContext));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new bafs(this));
  }
  
  public int a(bafl parambafl)
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilList.size(); j = k)
    {
      bafl localbafl = (bafl)this.jdField_a_of_type_JavaUtilList.get(i);
      k = j;
      if (parambafl.b.contains(localbafl.a))
      {
        this.jdField_a_of_type_JavaUtilList.set(i, parambafl);
        this.jdField_a_of_type_Bafu.notifyDataSetChanged();
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Bafu.notifyDataSetChanged();
  }
  
  public void a(bafl parambafl)
  {
    this.jdField_a_of_type_JavaUtilList.add(0, parambafl);
    this.jdField_a_of_type_Bafu.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367658: 
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
    case 2131364301: 
      a();
      return;
    case 2131375380: 
      if (bafm.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetButton.setText(getContext().getString(2131690520));
        bafm.jdField_c_of_type_Boolean = false;
        return;
      }
      this.jdField_c_of_type_AndroidWidgetButton.setText(getContext().getString(2131690519));
      bafm.jdField_c_of_type_Boolean = true;
      return;
    }
    if (bafm.jdField_b_of_type_Boolean)
    {
      this.d.setText(getContext().getString(2131690521));
      bafm.jdField_b_of_type_Boolean = false;
      return;
    }
    this.d.setText(getContext().getString(2131690517));
    bafm.jdField_b_of_type_Boolean = true;
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