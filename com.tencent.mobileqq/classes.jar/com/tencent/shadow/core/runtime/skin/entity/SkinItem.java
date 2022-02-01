package com.tencent.shadow.core.runtime.skin.entity;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SkinItem
{
  private List<SkinAttr> mAttrs = new ArrayList();
  private View mView;
  
  public SkinItem(View paramView, List<SkinAttr> paramList)
  {
    this.mView = paramView;
    this.mAttrs.clear();
    this.mAttrs.addAll(paramList);
  }
  
  private void removeAttr(Class paramClass)
  {
    Iterator localIterator = this.mAttrs.iterator();
    while (localIterator.hasNext()) {
      if (((SkinAttr)localIterator.next()).getClass() == paramClass) {
        localIterator.remove();
      }
    }
  }
  
  public void addItem(List<SkinAttr> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SkinAttr localSkinAttr = (SkinAttr)paramList.next();
      removeAttr(localSkinAttr.getClass());
      this.mAttrs.add(localSkinAttr);
    }
  }
  
  public void apply()
  {
    if (this.mView != null)
    {
      Object localObject = this.mAttrs;
      if (localObject != null)
      {
        if (((List)localObject).isEmpty()) {
          return;
        }
        localObject = this.mAttrs.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((SkinAttr)((Iterator)localObject).next()).apply(this.mView);
        }
      }
    }
  }
  
  public void clean()
  {
    this.mView = null;
    List localList = this.mAttrs;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public void removeItem(List<Class> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      removeAttr((Class)paramList.next());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SkinItem [mView=");
    localStringBuilder.append(this.mView.getClass().getSimpleName());
    localStringBuilder.append(", mAttrs=");
    localStringBuilder.append(this.mAttrs);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.skin.entity.SkinItem
 * JD-Core Version:    0.7.0.1
 */