package com.tencent.mobileqq.resourcesgrab;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
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
  View.OnClickListener a;
  boolean b;
  private List<ResourceGrabSkinData> c;
  
  ResourceNameOnClickListener(List<ResourceGrabSkinData> paramList, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    this.c = paramList;
    this.a = paramOnClickListener;
    this.b = paramBoolean;
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
        paramView = ((ResourceNameOnClickListener)paramView).c;
        if ((paramView != null) && (paramView.size() > 0))
        {
          localArrayList.addAll(paramView);
          return localArrayList;
        }
      }
    }
    catch (Exception paramView)
    {
      QLog.d("ResourceNameOnClickListener", 1, paramView, new Object[0]);
    }
    return localArrayList;
  }
  
  private void a(View paramView, BaseActivity paramBaseActivity, List<ResourceGrabSkinData> paramList)
  {
    if ((paramView instanceof ViewGroup))
    {
      Rect localRect = new Rect();
      int i = 0;
      for (;;)
      {
        Object localObject = (ViewGroup)paramView;
        if (i >= ((ViewGroup)localObject).getChildCount()) {
          break;
        }
        localObject = ((ViewGroup)localObject).getChildAt(i);
        ((View)localObject).getGlobalVisibleRect(localRect);
        if (localRect.contains(paramBaseActivity.clickX, paramBaseActivity.clickY))
        {
          paramView = a((View)localObject);
          if (paramView.size() > 0) {
            paramList.addAll(paramView);
          }
          a((View)localObject, paramBaseActivity, paramList);
          return;
        }
        i += 1;
      }
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
    if ((localObject2 instanceof BaseActivity))
    {
      localObject1 = ((BaseActivity)localObject2).getSupportFragmentManager().findFragmentByTag("ResourceGrabFragment");
      if ((localObject1 instanceof ResourceGrabFragment))
      {
        localObject1 = (ResourceGrabFragment)localObject1;
        ResourceGrabViewModel localResourceGrabViewModel = (ResourceGrabViewModel)ViewModelProviderHelper.a((ViewModelStoreOwner)localObject1, ResourceGrabViewModel.a).get(ResourceGrabViewModel.class);
        ArrayList localArrayList = new ArrayList(this.c);
        try
        {
          a(paramView, (BaseActivity)localObject2, localArrayList);
          localObject2 = new Rect();
          paramView.getGlobalVisibleRect((Rect)localObject2);
          a(paramView, localArrayList, (Rect)localObject2);
        }
        catch (Exception localException)
        {
          QLog.d("ResourceNameOnClickListener", 1, localException, new Object[0]);
        }
        ((ResourceGrabFragment)localObject1).a(localArrayList);
        if (((ResourceGrabFragment)localObject1).b()) {
          localResourceGrabViewModel.a(localArrayList);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.resourcesgrab.ResourceNameOnClickListener
 * JD-Core Version:    0.7.0.1
 */