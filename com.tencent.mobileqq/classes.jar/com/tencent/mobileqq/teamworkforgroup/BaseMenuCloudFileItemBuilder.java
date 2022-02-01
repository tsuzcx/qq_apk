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
  public static MenuItem b = new MenuItem(0, 2131430854, 2131887820, 2130839697);
  public static MenuItem c = new MenuItem(0, 2131430853, 2131887819, 2130839698);
  public static MenuItem d = new MenuItem(0, 2131430855, 2131887821, 2130839699);
  private static int[] k = { BaseApplication.getContext().getResources().getDimensionPixelSize(2131299607), BaseApplication.getContext().getResources().getDimensionPixelSize(2131299608) };
  protected SwipTextViewMenuBuilder a;
  protected int e = 0;
  private View.OnClickListener j = new BaseMenuCloudFileItemBuilder.1(this);
  private BaseMenuCloudFileItemBuilder.OnMenuItemClickListener l;
  
  public BaseMenuCloudFileItemBuilder(AppInterface paramAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramAppInterface, paramContext, paramBaseAdapter, paramInt);
  }
  
  private SwipTextViewMenuBuilder b()
  {
    Object localObject = this.a;
    if (localObject != null) {
      return localObject;
    }
    localObject = new ArrayList(a());
    int m = ((List)localObject).size();
    int i = 0;
    if (m > 3) {
      ((List)localObject).add(0, b);
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
    this.a = new BaseMenuCloudFileItemBuilder.2(this, ((List)localObject).size(), 2, k, -1, arrayOfInt1, arrayOfInt2, arrayOfInt3, (List)localObject, arrayOfInt4);
    return this.a;
  }
  
  private void b(ICloudFile paramICloudFile)
  {
    ActionSheet localActionSheet = (ActionSheet)((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).actionSheetHelperCreateDialog(this.g, null);
    List localList = a(paramICloudFile);
    localList = localList.subList(0, localList.size() - 2);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      localActionSheet.addButton(this.g.getResources().getString(localMenuItem.c()), 1);
    }
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new BaseMenuCloudFileItemBuilder.3(this, localList, paramICloudFile, localActionSheet));
    localActionSheet.show();
  }
  
  public final View a(int paramInt1, ICloudFile paramICloudFile, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    SwipTextViewMenuBuilder localSwipTextViewMenuBuilder = b();
    SwipRightMenuBuilder.SwipItemBaseHolder localSwipItemBaseHolder;
    if (paramView == null)
    {
      localSwipItemBaseHolder = new SwipRightMenuBuilder.SwipItemBaseHolder();
      paramView = b(paramInt1, paramICloudFile, localSwipItemBaseHolder.a, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramView = localSwipTextViewMenuBuilder.a(this.g, paramView, localSwipItemBaseHolder, -1);
      paramView.setTag(localSwipItemBaseHolder);
      paramViewGroup = localSwipItemBaseHolder;
    }
    else
    {
      localSwipItemBaseHolder = (SwipRightMenuBuilder.SwipItemBaseHolder)paramView.getTag();
      b(paramInt1, paramICloudFile, localSwipItemBaseHolder.a, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramViewGroup = localSwipItemBaseHolder;
    }
    localSwipTextViewMenuBuilder.a(this.g, paramView, paramInt1, paramICloudFile, paramViewGroup, this.j);
    paramView.setEnabled(false);
    return paramView;
  }
  
  public abstract List<MenuItem> a();
  
  public abstract List<MenuItem> a(ICloudFile paramICloudFile);
  
  public void a(BaseMenuCloudFileItemBuilder.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.l = paramOnMenuItemClickListener;
  }
  
  public abstract View b(int paramInt1, ICloudFile paramICloudFile, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.BaseMenuCloudFileItemBuilder
 * JD-Core Version:    0.7.0.1
 */