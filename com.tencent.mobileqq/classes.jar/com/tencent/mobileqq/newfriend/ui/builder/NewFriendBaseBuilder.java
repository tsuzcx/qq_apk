package com.tencent.mobileqq.newfriend.ui.builder;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.newfriend.constant.INewFriendConstant.BaseBuilder;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListBaseAdapter;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import com.tencent.widget.ThemeImageView;

public abstract class NewFriendBaseBuilder
{
  protected Context a;
  protected AppInterface a;
  protected NewFriendMessage a;
  protected SystemMsgListBaseAdapter a;
  protected SwipRightMenuBuilder a;
  protected int b;
  
  public NewFriendBaseBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListBaseAdapter paramSystemMsgListBaseAdapter, NewFriendMessage paramNewFriendMessage)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter = paramSystemMsgListBaseAdapter;
    this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage = paramNewFriendMessage;
    this.b = paramContext.getResources().getDimensionPixelSize(2131297482);
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    int i = paramView.getPaddingBottom();
    int j = paramView.getPaddingTop();
    int k = paramView.getPaddingRight();
    int m = paramView.getPaddingLeft();
    if (paramBoolean) {
      paramView.setBackgroundResource(2130839395);
    } else if (ThemeUtil.isDefaultTheme()) {
      paramView.setBackgroundResource(2130839393);
    } else {
      paramView.setBackgroundResource(2130839390);
    }
    paramView.setPadding(m, j, k, i);
  }
  
  public static void b(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    Object localObject = paramView.getLayoutParams();
    if (localObject == null)
    {
      localObject = new AbsListView.LayoutParams(-1, paramInt);
    }
    else
    {
      ((ViewGroup.LayoutParams)localObject).width = -1;
      ((ViewGroup.LayoutParams)localObject).height = paramInt;
    }
    paramView.setMinimumHeight(paramInt);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  protected int a()
  {
    return 0;
  }
  
  public abstract View a(int paramInt, View paramView);
  
  protected View a(Context paramContext, int paramInt, NewFriendBaseBuilder.NewFriendBaseHolder paramNewFriendBaseHolder)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if (this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter != null) {
      return this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.createView(paramContext, localView, paramNewFriendBaseHolder, -1);
    }
    paramNewFriendBaseHolder.leftView = localView;
    paramNewFriendBaseHolder.rightMenuItems = null;
    return localView;
  }
  
  protected SwipRightMenuBuilder a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298886);
    int j = paramContext.getResources().getDimensionPixelSize(2131298887);
    paramContext = INewFriendConstant.BaseBuilder.c;
    int[] arrayOfInt1 = INewFriendConstant.BaseBuilder.a;
    int[] arrayOfInt2 = INewFriendConstant.BaseBuilder.b;
    return new NewFriendBaseBuilder.1(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  protected void a() {}
  
  protected void a(Context paramContext, View paramView, int paramInt, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    SwipRightMenuBuilder localSwipRightMenuBuilder = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder;
    int i;
    if (localSwipRightMenuBuilder != null) {
      i = localSwipRightMenuBuilder.updateRightMenuView(paramContext, paramView, paramInt, paramObject, paramSwipItemBaseHolder, paramOnClickListener);
    } else {
      i = 0;
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter;
    if ((paramContext != null) && (paramContext.a != -1))
    {
      if (paramInt != this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a)
      {
        paramView.scrollTo(0, 0);
        return;
      }
      paramView.scrollTo(i, 0);
    }
  }
  
  protected void a(View paramView)
  {
    if (!Utils.a("tag_swip_icon_menu_item", paramView.getTag())) {
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      paramView = this.jdField_a_of_type_AndroidContentContext;
      QQToast.a(paramView, paramView.getResources().getString(2131692183), 0).b(c());
      return;
    }
    Object localObject1 = paramView.getTag(-1);
    Object localObject2 = paramView.getTag(-2);
    if (((localObject1 instanceof Integer)) && ((localObject2 instanceof Integer)))
    {
      int i = ((Integer)localObject1).intValue();
      int j = ((Integer)localObject2).intValue();
      localObject1 = null;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("SystemMsgListAdpater onClick position = ");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("nMenuStrId = ");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append("v.getId() = ");
        ((StringBuilder)localObject2).append(paramView.getId());
        QLog.i("Q.newfriend", 2, ((StringBuilder)localObject2).toString());
      }
      try
      {
        paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getString(j);
      }
      catch (Exception localException)
      {
        paramView = localObject1;
        if (QLog.isDevelopLevel())
        {
          QLog.i("Q.newfriend", 4, localException.toString());
          paramView = localObject1;
        }
      }
      if (Utils.a(paramView, this.jdField_a_of_type_AndroidContentContext.getResources().getString(INewFriendConstant.BaseBuilder.a[0]))) {
        a();
      }
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.newfriend", 4, "SystemMsgListAdpater onClick tag is not int");
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    View localView = paramView.findViewById(2131376644);
    if ((localView != paramView) && (localView != null))
    {
      paramView = localView.getLayoutParams();
      if (paramView != null)
      {
        paramView.width = -1;
        paramView.height = paramInt;
        localView.setLayoutParams(paramView);
      }
    }
    else
    {
      b(paramView, paramInt);
    }
  }
  
  public void a(NewFriendMessage paramNewFriendMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage = paramNewFriendMessage;
  }
  
  public void b(View paramView)
  {
    if ((paramView instanceof ThemeImageView)) {
      ((ThemeImageView)paramView).setSupportMaskView(false);
    }
  }
  
  public int c()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.NewFriendBaseBuilder
 * JD-Core Version:    0.7.0.1
 */