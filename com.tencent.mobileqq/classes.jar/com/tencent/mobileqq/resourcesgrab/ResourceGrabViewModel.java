package com.tencent.mobileqq.resourcesgrab;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.resourcesgrab.strategy.CommonResourceNameGrabStrategy;
import com.tencent.mobileqq.resourcesgrab.strategy.GrabMainTabResourceNameGrabStrategy;
import com.tencent.mobileqq.resourcesgrab.strategy.ResourceNameGrabStrategy;
import com.tencent.mobileqq.resourcesgrab.strategy.SingleLineTextViewResourceNameGrabStrategy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.BaseConstantState;
import com.tencent.theme.SkinData;
import com.tencent.theme.SkinEngine;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class ResourceGrabViewModel
  extends BaseViewModel<ResourceGrabRepository>
{
  static ViewModelProvider.Factory jdField_a_of_type_AndroidxLifecycleViewModelProvider$Factory = new ResourceGrabViewModel.2();
  private final ResourceNameGrabStrategy[] jdField_a_of_type_ArrayOfComTencentMobileqqResourcesgrabStrategyResourceNameGrabStrategy = { new CommonResourceNameGrabStrategy(), new GrabMainTabResourceNameGrabStrategy(), new SingleLineTextViewResourceNameGrabStrategy() };
  
  ResourceGrabViewModel(ResourceGrabRepository paramResourceGrabRepository)
  {
    super(paramResourceGrabRepository);
    paramResourceGrabRepository.a();
  }
  
  private View.OnClickListener a(View paramView)
  {
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
      return paramView;
    }
    catch (Throwable paramView)
    {
      QLog.d("ResourceGrabViewModel", 1, paramView, new Object[0]);
    }
    return null;
  }
  
  private List<ResourceGrabSkinData> a(List<ResourceGrabSkinData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      HashSet localHashSet = new HashSet();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ResourceGrabSkinData localResourceGrabSkinData = (ResourceGrabSkinData)paramList.next();
        if (!localHashSet.contains(localResourceGrabSkinData.jdField_a_of_type_ComTencentThemeSkinData.mFileName)) {
          localArrayList.add(localResourceGrabSkinData);
        }
        localHashSet.add(localResourceGrabSkinData.jdField_a_of_type_ComTencentThemeSkinData.mFileName);
      }
    }
    return localArrayList;
  }
  
  private void a(Drawable paramDrawable, List<ResourceGrabSkinData> paramList, int paramInt)
  {
    if ((paramDrawable != null) && (paramDrawable.getConstantState() != null) && (paramList != null))
    {
      paramDrawable = paramDrawable.getConstantState();
      if ((paramDrawable instanceof BaseConstantState))
      {
        paramList.add(new ResourceGrabSkinData(paramInt, ((BaseConstantState)paramDrawable).skinData));
        if (QLog.isColorLevel())
        {
          paramDrawable = new StringBuilder();
          paramDrawable.append("getFileNameByConstantState BaseConstantState resourceNames -> ");
          paramDrawable.append(paramList);
          QLog.d("ResourceGrabViewModel", 2, paramDrawable.toString());
        }
      }
      else if ((paramDrawable instanceof DrawableContainer.DrawableContainerState))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ResourceGrabViewModel", 2, "getFileNameByConstantState DrawableContainerState");
        }
        paramDrawable = ((DrawableContainer.DrawableContainerState)paramDrawable).getChildren();
        int j = paramDrawable.length;
        int i = 0;
        while (i < j)
        {
          Drawable localDrawable = paramDrawable[i];
          if (localDrawable != null) {
            a(localDrawable, paramList, paramInt);
          }
          i += 1;
        }
      }
    }
  }
  
  private void a(View paramView, View.OnClickListener paramOnClickListener)
  {
    if ((paramOnClickListener instanceof ResourceNameOnClickListener))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ResourceGrabViewModel", 2, "recovery onClick listener");
      }
      paramOnClickListener = (ResourceNameOnClickListener)paramOnClickListener;
      paramView.setOnClickListener(paramOnClickListener.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setClickable(paramOnClickListener.jdField_a_of_type_Boolean);
    }
  }
  
  private void a(View paramView, List<ResourceGrabSkinData> paramList)
  {
    Object localObject = paramView.getBackground();
    int i = 0;
    a((Drawable)localObject, paramList, 0);
    localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqResourcesgrabStrategyResourceNameGrabStrategy;
    int j = localObject.length;
    while (i < j)
    {
      List localList = localObject[i];
      if (localList != null)
      {
        localList = localList.a(paramView);
        if ((localList != null) && (localList.size() > 0)) {
          paramList.addAll(localList);
        }
      }
      i += 1;
    }
  }
  
  private void a(View paramView, List<ResourceGrabSkinData> paramList, View.OnClickListener paramOnClickListener)
  {
    if (!(paramOnClickListener instanceof ResourceNameOnClickListener))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ResourceGrabViewModel", 2, "doReplace onClick listener");
      }
      paramView.setOnClickListener(new ResourceNameOnClickListener(paramList, paramOnClickListener, paramView.isClickable()));
      paramView.setClickable(true);
    }
  }
  
  private void a(HashSet<String> paramHashSet)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramHashSet = paramHashSet.iterator();
      while (paramHashSet.hasNext()) {
        localArrayList.add(new FileInfo((String)paramHashSet.next()));
      }
      ((DataLineHandler)BaseActivity.sTopActivity.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(localArrayList);
      return;
    }
    catch (Exception paramHashSet)
    {
      QLog.d("ResourceGrabViewModel", 2, paramHashSet, new Object[0]);
    }
  }
  
  String a(List<ResourceGrabSkinData> paramList)
  {
    paramList = a(paramList);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rootPath: ");
    localStringBuilder.append(SkinEngine.getInstances().getSkinRootPath());
    localStringBuilder.append("\n");
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      ResourceGrabSkinData localResourceGrabSkinData = (ResourceGrabSkinData)paramList.get(i);
      if (localResourceGrabSkinData != null)
      {
        localStringBuilder.append(((ResourceGrabRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a(localResourceGrabSkinData.jdField_a_of_type_Int));
        localStringBuilder.append(":");
        localStringBuilder.append(localResourceGrabSkinData.jdField_a_of_type_ComTencentThemeSkinData.mFileName);
        if (i != j - 1) {
          localStringBuilder.append("\n");
        }
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabViewModel", 2, localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  void a(View paramView, boolean paramBoolean)
  {
    Object localObject1;
    if ((paramView instanceof ViewGroup))
    {
      localObject1 = (ViewGroup)paramView;
      int j = ((ViewGroup)localObject1).getChildCount();
      int i = 0;
      while (i < j)
      {
        a(((ViewGroup)localObject1).getChildAt(i), paramBoolean);
        i += 1;
      }
    }
    try
    {
      localObject1 = new ArrayList();
      a(paramView, (List)localObject1);
      if (((List)localObject1).isEmpty()) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("doReplaceOnclickListener success fileName: ");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append(", view: ");
        ((StringBuilder)localObject2).append(paramView);
        QLog.d("ResourceGrabViewModel", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = a(paramView);
      if (!paramBoolean)
      {
        a(paramView, (View.OnClickListener)localObject2);
        return;
      }
      a(paramView, (List)localObject1, (View.OnClickListener)localObject2);
      return;
    }
    catch (Throwable paramView)
    {
      QLog.d("ResourceGrabViewModel", 1, paramView, new Object[0]);
    }
  }
  
  void a(List<ResourceGrabSkinData> paramList)
  {
    ((ResourceGrabRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a(paramList, new ResourceGrabViewModel.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.resourcesgrab.ResourceGrabViewModel
 * JD-Core Version:    0.7.0.1
 */