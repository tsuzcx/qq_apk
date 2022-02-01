package com.tencent.mobileqq.guild.profilecard.baseprofile.framework.controller;

import android.os.Bundle;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.collector.GuildProfileComponentCollector;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.component.IGuildProfileComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class GuildProfileComponentController
  extends IGuildComponentController
{
  protected IGuildComponentController.IDelegateCallback a;
  private SparseArray<AbsGuildProfileComponent> b = new SparseArray();
  private List<Integer> c = new ArrayList();
  private ViewGroup d;
  private IComponentAction.IDismissCallback e;
  private GuildProfileComponentProducer f = new GuildProfileComponentProducer();
  
  private void a(SparseArray<Integer> paramSparseArray, ViewGroup paramViewGroup, int paramInt)
  {
    paramInt = ((Integer)paramSparseArray.valueAt(paramInt)).intValue();
    paramSparseArray = new LinearLayout.LayoutParams(-1, -2);
    paramSparseArray.bottomMargin = paramInt;
    this.d.addView(paramViewGroup, paramSparseArray);
  }
  
  private void b(GuildProfileData paramGuildProfileData)
  {
    this.c.addAll(GuildProfileComponentCollector.a(paramGuildProfileData));
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      int k = ((Integer)this.c.get(i)).intValue();
      AbsGuildProfileComponent localAbsGuildProfileComponent = this.f.a(k, this, paramGuildProfileData);
      if (localAbsGuildProfileComponent != null) {
        localAbsGuildProfileComponent.attachToComponentController();
      }
      i += 1;
    }
  }
  
  public void a()
  {
    IComponentAction.IDismissCallback localIDismissCallback = this.e;
    if (localIDismissCallback != null) {
      localIDismissCallback.a();
    }
  }
  
  public void a(GuildProfileData paramGuildProfileData)
  {
    SparseArray localSparseArray = this.b.clone();
    int j = localSparseArray.size();
    int i = 0;
    while (i < j)
    {
      ((AbsGuildProfileComponent)localSparseArray.valueAt(i)).onInitData(paramGuildProfileData);
      i += 1;
    }
  }
  
  public void a(IComponentAction.IDismissCallback paramIDismissCallback)
  {
    this.e = paramIDismissCallback;
  }
  
  public void addComponent(AbsGuildProfileComponent paramAbsGuildProfileComponent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildProfileComponentController", 2, String.format("addComponent component=%s", new Object[] { paramAbsGuildProfileComponent }));
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (paramAbsGuildProfileComponent != null)
      {
        int i = paramAbsGuildProfileComponent.getComponentType();
        if (this.b.indexOfKey(i) < 0)
        {
          this.b.put(i, paramAbsGuildProfileComponent);
          return;
        }
        QLog.e("GuildProfileComponentController", 1, String.format("addComponent component exist. component=%s", new Object[] { paramAbsGuildProfileComponent }));
      }
      return;
    }
    throw new RuntimeException("This Method Must Call In Main Thread.");
  }
  
  public AbsGuildProfileComponent createComponent(int paramInt, GuildProfileData paramGuildProfileData)
  {
    return this.f.a(paramInt, this, paramGuildProfileData);
  }
  
  public AbsGuildProfileComponent getComponent(int paramInt)
  {
    return (AbsGuildProfileComponent)this.b.get(paramInt);
  }
  
  public ViewGroup getContentViewContainer()
  {
    return this.d;
  }
  
  public IGuildComponentController.IDelegateCallback getDelegate()
  {
    return this.a;
  }
  
  public void init(Fragment paramFragment, GuildProfileData paramGuildProfileData, IGuildComponentController.IDelegateCallback paramIDelegateCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildProfileComponentController", 2, String.format("init fragment=%s", new Object[] { paramFragment }));
    }
    this.b.clear();
    this.c.clear();
    this.a = paramIDelegateCallback;
    b(paramGuildProfileData);
  }
  
  public void onCreate(Fragment paramFragment, AppInterface paramAppInterface, Bundle paramBundle)
  {
    SparseArray localSparseArray = this.b.clone();
    int j = this.c.size();
    Object localObject1 = this.d;
    if (localObject1 == null)
    {
      QLog.w("GuildProfileComponentController", 1, "onCreate contentViewContainer is null!");
      return;
    }
    ((ViewGroup)localObject1).removeAllViews();
    localObject1 = GuildProfileComponentCollector.b();
    int i = 0;
    while (i < j)
    {
      int k = ((Integer)this.c.get(i)).intValue();
      Object localObject2 = (AbsGuildProfileComponent)localSparseArray.valueAt(localSparseArray.indexOfKey(k));
      ((AbsGuildProfileComponent)localObject2).onCreate(paramFragment, paramAppInterface, paramBundle);
      localObject2 = (ViewGroup)((AbsGuildProfileComponent)localObject2).getContainerView();
      k = ((SparseArray)localObject1).indexOfKey(k);
      if (k >= 0) {
        a((SparseArray)localObject1, (ViewGroup)localObject2, k);
      } else {
        this.d.addView((View)localObject2);
      }
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    this.d = null;
    Object localObject = this.c;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    this.c = null;
    localObject = this.b;
    if (localObject != null)
    {
      localObject = ((SparseArray)localObject).clone();
      int j = ((SparseArray)localObject).size();
      int i = 0;
      while (i < j)
      {
        IGuildProfileComponent localIGuildProfileComponent = (IGuildProfileComponent)((SparseArray)localObject).valueAt(i);
        localIGuildProfileComponent.detachFromComponentController();
        localIGuildProfileComponent.onDestroy();
        i += 1;
      }
    }
  }
  
  public void onPause()
  {
    SparseArray localSparseArray = this.b.clone();
    int j = localSparseArray.size();
    int i = 0;
    while (i < j)
    {
      ((IGuildProfileComponent)localSparseArray.valueAt(i)).onPause();
      i += 1;
    }
  }
  
  public void onResume()
  {
    SparseArray localSparseArray = this.b.clone();
    int j = localSparseArray.size();
    int i = 0;
    while (i < j)
    {
      ((IGuildProfileComponent)localSparseArray.valueAt(i)).onResume();
      i += 1;
    }
  }
  
  public void removeComponent(AbsGuildProfileComponent paramAbsGuildProfileComponent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildProfileComponentController", 2, String.format("removeComponent component=%s", new Object[] { paramAbsGuildProfileComponent }));
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (paramAbsGuildProfileComponent != null)
      {
        int i = paramAbsGuildProfileComponent.getComponentType();
        i = this.b.indexOfKey(i);
        if (i >= 0) {
          this.b.removeAt(i);
        }
      }
      return;
    }
    throw new RuntimeException("This Method Must Call In Main Thread.");
  }
  
  public void setContentViewContainer(ViewGroup paramViewGroup)
  {
    this.d = paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.baseprofile.framework.controller.GuildProfileComponentController
 * JD-Core Version:    0.7.0.1
 */