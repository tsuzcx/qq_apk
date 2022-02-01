package com.tencent.mobileqq.teamworkforgroup;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import com.tencent.widget.SwipTextViewMenuBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseMenuCloudFileItemBuilder
  extends CloudFileItemBuilder
{
  public static MenuItem a;
  private static int[] jdField_a_of_type_ArrayOfInt = { BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298882), BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298883) };
  public static MenuItem b;
  public static MenuItem c;
  protected int a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new BaseMenuCloudFileItemBuilder.1(this);
  private BaseMenuCloudFileItemBuilder.OnMenuItemClickListener jdField_a_of_type_ComTencentMobileqqTeamworkforgroupBaseMenuCloudFileItemBuilder$OnMenuItemClickListener;
  protected SwipTextViewMenuBuilder a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqTeamworkforgroupMenuItem = new MenuItem(0, 2131364860, 2131690954, 2130839648);
    b = new MenuItem(0, 2131364859, 2131690953, 2130839649);
    c = new MenuItem(0, 2131364861, 2131690955, 2130839650);
  }
  
  public BaseMenuCloudFileItemBuilder(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
    this.jdField_a_of_type_Int = 0;
  }
  
  private SwipTextViewMenuBuilder a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipTextViewMenuBuilder != null) {
      return this.jdField_a_of_type_ComTencentWidgetSwipTextViewMenuBuilder;
    }
    ArrayList localArrayList = new ArrayList(a());
    if (localArrayList.size() > 3) {
      localArrayList.add(0, jdField_a_of_type_ComTencentMobileqqTeamworkforgroupMenuItem);
    }
    int[] arrayOfInt1 = new int[localArrayList.size()];
    int[] arrayOfInt2 = new int[localArrayList.size()];
    int[] arrayOfInt3 = new int[localArrayList.size()];
    int[] arrayOfInt4 = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      MenuItem localMenuItem = (MenuItem)localArrayList.get(i);
      arrayOfInt1[i] = localMenuItem.b();
      arrayOfInt2[i] = localMenuItem.c();
      arrayOfInt3[i] = localMenuItem.d();
      arrayOfInt4[i] = localMenuItem.a();
      i += 1;
    }
    this.jdField_a_of_type_ComTencentWidgetSwipTextViewMenuBuilder = new BaseMenuCloudFileItemBuilder.2(this, localArrayList.size(), 2, jdField_a_of_type_ArrayOfInt, -1, arrayOfInt1, arrayOfInt2, arrayOfInt3, localArrayList, arrayOfInt4);
    return this.jdField_a_of_type_ComTencentWidgetSwipTextViewMenuBuilder;
  }
  
  private void a(ICloudFile paramICloudFile)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    List localList = a(paramICloudFile);
    localList = localList.subList(0, localList.size() - 2);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      localActionSheet.addButton(this.jdField_a_of_type_AndroidContentContext.getResources().getString(localMenuItem.c()), 1);
    }
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new BaseMenuCloudFileItemBuilder.3(this, localList, paramICloudFile, localActionSheet));
    localActionSheet.show();
  }
  
  public final View a(int paramInt1, ICloudFile paramICloudFile, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    SwipTextViewMenuBuilder localSwipTextViewMenuBuilder = a();
    if (paramView == null)
    {
      paramView = new SwipRightMenuBuilder.SwipItemBaseHolder();
      paramViewGroup = b(paramInt1, paramICloudFile, paramView.g, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramOnClickListener = localSwipTextViewMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, paramView, -1);
      paramOnClickListener.setTag(paramView);
      paramViewGroup = paramView;
      paramView = paramOnClickListener;
    }
    for (;;)
    {
      localSwipTextViewMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt1, paramICloudFile, paramViewGroup, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setEnabled(false);
      return paramView;
      SwipRightMenuBuilder.SwipItemBaseHolder localSwipItemBaseHolder = (SwipRightMenuBuilder.SwipItemBaseHolder)paramView.getTag();
      b(paramInt1, paramICloudFile, localSwipItemBaseHolder.g, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramViewGroup = localSwipItemBaseHolder;
    }
  }
  
  public abstract List<MenuItem> a();
  
  public abstract List<MenuItem> a(ICloudFile paramICloudFile);
  
  public void a(BaseMenuCloudFileItemBuilder.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupBaseMenuCloudFileItemBuilder$OnMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public abstract View b(int paramInt1, ICloudFile paramICloudFile, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.BaseMenuCloudFileItemBuilder
 * JD-Core Version:    0.7.0.1
 */