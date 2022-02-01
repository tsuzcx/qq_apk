package com.tencent.mobileqq.teamworkforgroup;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.rely.SwipRightMenuBuilder.SwipItemBaseHolder;
import com.tencent.mobileqq.rely.SwipTextViewMenuBuilder;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseMenuCloudFileItemBuilder
  extends CloudFileItemBuilder
{
  public static MenuItem a;
  private static int[] jdField_a_of_type_ArrayOfInt = { BaseApplication.getContext().getResources().getDimensionPixelSize(2131298886), BaseApplication.getContext().getResources().getDimensionPixelSize(2131298887) };
  public static MenuItem b;
  public static MenuItem c;
  protected int a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new BaseMenuCloudFileItemBuilder.1(this);
  protected SwipTextViewMenuBuilder a;
  private BaseMenuCloudFileItemBuilder.OnMenuItemClickListener jdField_a_of_type_ComTencentMobileqqTeamworkforgroupBaseMenuCloudFileItemBuilder$OnMenuItemClickListener;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqTeamworkforgroupMenuItem = new MenuItem(0, 2131364746, 2131690882, 2130839506);
    b = new MenuItem(0, 2131364745, 2131690881, 2130839507);
    c = new MenuItem(0, 2131364747, 2131690883, 2130839508);
  }
  
  public BaseMenuCloudFileItemBuilder(AppInterface paramAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramAppInterface, paramContext, paramBaseAdapter, paramInt);
    this.jdField_a_of_type_Int = 0;
  }
  
  private SwipTextViewMenuBuilder a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRelySwipTextViewMenuBuilder;
    if (localObject != null) {
      return localObject;
    }
    localObject = new ArrayList(a());
    int j = ((List)localObject).size();
    int i = 0;
    if (j > 3) {
      ((List)localObject).add(0, jdField_a_of_type_ComTencentMobileqqTeamworkforgroupMenuItem);
    }
    int[] arrayOfInt1 = new int[((List)localObject).size()];
    int[] arrayOfInt2 = new int[((List)localObject).size()];
    int[] arrayOfInt3 = new int[((List)localObject).size()];
    int[] arrayOfInt4 = new int[((List)localObject).size()];
    while (i < ((List)localObject).size())
    {
      MenuItem localMenuItem = (MenuItem)((List)localObject).get(i);
      arrayOfInt1[i] = localMenuItem.b();
      arrayOfInt2[i] = localMenuItem.c();
      arrayOfInt3[i] = localMenuItem.d();
      arrayOfInt4[i] = localMenuItem.a();
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqRelySwipTextViewMenuBuilder = new BaseMenuCloudFileItemBuilder.2(this, ((List)localObject).size(), 2, jdField_a_of_type_ArrayOfInt, -1, arrayOfInt1, arrayOfInt2, arrayOfInt3, (List)localObject, arrayOfInt4);
    return this.jdField_a_of_type_ComTencentMobileqqRelySwipTextViewMenuBuilder;
  }
  
  private void a(ICloudFile paramICloudFile)
  {
    ActionSheet localActionSheet = (ActionSheet)((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).actionSheetHelperCreateDialog(this.jdField_a_of_type_AndroidContentContext, null);
    List localList = a(paramICloudFile);
    localList = localList.subList(0, localList.size() - 2);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      localActionSheet.addButton(this.jdField_a_of_type_AndroidContentContext.getResources().getString(localMenuItem.c()), 1);
    }
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new BaseMenuCloudFileItemBuilder.3(this, localList, paramICloudFile, localActionSheet));
    localActionSheet.show();
  }
  
  public final View a(int paramInt1, ICloudFile paramICloudFile, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    SwipTextViewMenuBuilder localSwipTextViewMenuBuilder = a();
    SwipRightMenuBuilder.SwipItemBaseHolder localSwipItemBaseHolder;
    if (paramView == null)
    {
      localSwipItemBaseHolder = new SwipRightMenuBuilder.SwipItemBaseHolder();
      paramView = b(paramInt1, paramICloudFile, localSwipItemBaseHolder.a, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramView = localSwipTextViewMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramView, localSwipItemBaseHolder, -1);
      paramView.setTag(localSwipItemBaseHolder);
      paramViewGroup = localSwipItemBaseHolder;
    }
    else
    {
      localSwipItemBaseHolder = (SwipRightMenuBuilder.SwipItemBaseHolder)paramView.getTag();
      b(paramInt1, paramICloudFile, localSwipItemBaseHolder.a, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramViewGroup = localSwipItemBaseHolder;
    }
    localSwipTextViewMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt1, paramICloudFile, paramViewGroup, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramView.setEnabled(false);
    return paramView;
  }
  
  public abstract List<MenuItem> a();
  
  public abstract List<MenuItem> a(ICloudFile paramICloudFile);
  
  public void a(BaseMenuCloudFileItemBuilder.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupBaseMenuCloudFileItemBuilder$OnMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public abstract View b(int paramInt1, ICloudFile paramICloudFile, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.BaseMenuCloudFileItemBuilder
 * JD-Core Version:    0.7.0.1
 */