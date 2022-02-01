package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class ChatHistoryMenuItemView
  extends LinearLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ArrayList<ChatHistoryMenuItemView.CategoryItemColumnView> jdField_a_of_type_JavaUtilArrayList;
  private int jdField_b_of_type_Int;
  private ArrayList<ChatHistoryMenuItemView.SeparatorColumnView> jdField_b_of_type_JavaUtilArrayList;
  private int jdField_c_of_type_Int;
  private ArrayList<TextView> jdField_c_of_type_JavaUtilArrayList;
  private int jdField_d_of_type_Int;
  private ArrayList<ChatHistoryMenuItemView.OnCategoryClickListener> jdField_d_of_type_JavaUtilArrayList;
  
  public ChatHistoryMenuItemView(Context paramContext, int paramInt, String paramString, int[] paramArrayOfInt)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = paramArrayOfInt.length;
    a(paramContext, paramString, a(paramArrayOfInt));
  }
  
  private ArrayList<String> a(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      localArrayList.add(getResources().getString(k));
      i += 1;
    }
    return localArrayList;
  }
  
  private void a()
  {
    if (QQTheme.a())
    {
      this.jdField_c_of_type_Int = getResources().getColor(2131167291);
      this.jdField_d_of_type_Int = getResources().getColor(2131167006);
      return;
    }
    this.jdField_c_of_type_Int = getResources().getColor(2131165563);
    this.jdField_d_of_type_Int = getResources().getColor(2131165605);
  }
  
  private void a(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_c_of_type_Int);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.setMargins(0, ViewUtils.a(28.0F), 0, ViewUtils.a(32.0F));
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramContext);
    addView(this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  private void a(Context paramContext, String paramString, ArrayList<String> paramArrayList)
  {
    setOrientation(1);
    a();
    a(paramContext, paramString);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    paramString = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    int j = 0;
    paramString.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(1);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_JavaUtilArrayList = ChatHistoryMenuItemView.CategoryItemColumnView.a(paramContext, this.jdField_a_of_type_Int);
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList(this.jdField_b_of_type_Int);
    int i = 0;
    while (i < this.jdField_b_of_type_Int)
    {
      paramString = new ChatHistoryMenuItemView.CategoryItem(paramContext, (String)paramArrayList.get(i), this);
      this.jdField_c_of_type_JavaUtilArrayList.add(paramString);
      ((ChatHistoryMenuItemView.CategoryItemColumnView)this.jdField_a_of_type_JavaUtilArrayList.get(i % this.jdField_a_of_type_Int)).addView(paramString);
      i += 1;
    }
    this.jdField_b_of_type_JavaUtilArrayList = ChatHistoryMenuItemView.SeparatorColumnView.a(paramContext, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_d_of_type_Int);
    i = j;
    for (;;)
    {
      j = this.jdField_a_of_type_Int;
      if (i >= j - 1) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)this.jdField_a_of_type_JavaUtilArrayList.get(i));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)this.jdField_b_of_type_JavaUtilArrayList.get(i));
      i += 1;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)this.jdField_a_of_type_JavaUtilArrayList.get(j - 1));
  }
  
  public void a(ChatHistoryMenuItemView.OnCategoryClickListener paramOnCategoryClickListener)
  {
    if (this.jdField_d_of_type_JavaUtilArrayList == null) {
      this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_d_of_type_JavaUtilArrayList.add(paramOnCategoryClickListener);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_d_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ChatHistoryMenuItemView.OnCategoryClickListener)((Iterator)localObject).next()).a(this.jdField_c_of_type_JavaUtilArrayList.indexOf(paramView));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ChatHistoryMenuItemView
 * JD-Core Version:    0.7.0.1
 */