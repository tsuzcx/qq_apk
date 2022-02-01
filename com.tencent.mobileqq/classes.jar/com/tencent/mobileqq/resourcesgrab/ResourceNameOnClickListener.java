package com.tencent.mobileqq.resourcesgrab;

import android.app.Activity;
import android.graphics.Rect;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mvvm.LifeCycleExtKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ResourceNameOnClickListener
  implements View.OnClickListener
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private List<ResourceGrabSkinData> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean;
  
  ResourceNameOnClickListener(List<ResourceGrabSkinData> paramList, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private List<ResourceGrabSkinData> a(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject = View.class.getDeclaredMethod("getListenerInfo", new Class[0]);
      if (!((Method)localObject).isAccessible()) {
        ((Method)localObject).setAccessible(true);
      }
      paramView = ((Method)localObject).invoke(paramView, new Object[0]);
      localObject = paramView.getClass().getDeclaredField("mOnClickListener");
      ((Field)localObject).setAccessible(true);
      paramView = (View.OnClickListener)((Field)localObject).get(paramView);
      if ((paramView instanceof ResourceNameOnClickListener))
      {
        paramView = ((ResourceNameOnClickListener)paramView).jdField_a_of_type_JavaUtilList;
        if ((paramView != null) && (paramView.size() > 0)) {
          localArrayList.addAll(paramView);
        }
      }
      return localArrayList;
    }
    catch (Exception paramView)
    {
      QLog.d("ResourceNameOnClickListener", 1, paramView, new Object[0]);
    }
    return localArrayList;
  }
  
  private void a(View paramView, FragmentActivity paramFragmentActivity, List<ResourceGrabSkinData> paramList)
  {
    Rect localRect;
    int i;
    if ((paramView instanceof ViewGroup))
    {
      localRect = new Rect();
      i = 0;
    }
    for (;;)
    {
      if (i < ((ViewGroup)paramView).getChildCount())
      {
        View localView = ((ViewGroup)paramView).getChildAt(i);
        localView.getGlobalVisibleRect(localRect);
        if (localRect.contains(paramFragmentActivity.clickX, paramFragmentActivity.clickY))
        {
          paramView = a(localView);
          if (paramView.size() > 0) {
            paramList.addAll(paramView);
          }
          a(localView, paramFragmentActivity, paramList);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void a(View paramView, List<ResourceGrabSkinData> paramList, Rect paramRect)
  {
    if (paramView.getParent() != null)
    {
      paramView = (View)paramView.getParent();
      Object localObject = new Rect();
      paramView.getGlobalVisibleRect((Rect)localObject);
      if ((((Rect)localObject).left - paramRect.left <= 20) && (((Rect)localObject).top - paramRect.top <= 20) && (((Rect)localObject).right - paramRect.right <= 20) && (((Rect)localObject).bottom - paramRect.bottom <= 20))
      {
        localObject = a(paramView);
        if (((List)localObject).size() > 0) {
          paramList.addAll((Collection)localObject);
        }
        a(paramView, paramList, paramRect);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ResourceNameOnClickListener", 2, "ResourceNameOnClickListener onLongClick");
    }
    Object localObject1 = null;
    if ((paramView.getContext() instanceof Activity)) {
      localObject1 = (Activity)paramView.getContext();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = BaseActivity.sTopActivity;
    }
    ResourceGrabViewModel localResourceGrabViewModel;
    ArrayList localArrayList;
    if ((localObject2 instanceof FragmentActivity))
    {
      localObject1 = ((FragmentActivity)localObject2).getSupportFragmentManager().findFragmentByTag("ResourceGrabFragment");
      if ((localObject1 instanceof ResourceGrabFragment))
      {
        localObject1 = (ResourceGrabFragment)localObject1;
        localResourceGrabViewModel = (ResourceGrabViewModel)LifeCycleExtKt.a((ViewModelStoreOwner)localObject1, ResourceGrabViewModel.a).get(ResourceGrabViewModel.class);
        localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
      }
    }
    try
    {
      a(paramView, (FragmentActivity)localObject2, localArrayList);
      localObject2 = new Rect();
      paramView.getGlobalVisibleRect((Rect)localObject2);
      a(paramView, localArrayList, (Rect)localObject2);
      ((ResourceGrabFragment)localObject1).a(localArrayList);
      if (((ResourceGrabFragment)localObject1).a()) {
        localResourceGrabViewModel.a(localArrayList);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("ResourceNameOnClickListener", 1, localException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.resourcesgrab.ResourceNameOnClickListener
 * JD-Core Version:    0.7.0.1
 */