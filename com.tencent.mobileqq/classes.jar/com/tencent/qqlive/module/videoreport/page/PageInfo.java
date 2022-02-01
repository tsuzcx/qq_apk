package com.tencent.qqlive.module.videoreport.page;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class PageInfo
{
  private WeakReference<Object> mPage;
  private int mPageHashCode;
  private WeakReference<View> mPageView;
  private PageInfo mParentPage;
  
  PageInfo(@NonNull Object paramObject, @NonNull View paramView)
  {
    this.mPage = new WeakReference(paramObject);
    this.mPageView = new WeakReference(paramView);
    this.mPageHashCode = paramObject.hashCode();
  }
  
  private static Set<PageInfo> getPageLinker(PageInfo paramPageInfo)
  {
    HashSet localHashSet = new HashSet();
    while (paramPageInfo != null)
    {
      localHashSet.add(paramPageInfo);
      paramPageInfo = paramPageInfo.getParentPage();
    }
    return localHashSet;
  }
  
  DataEntity constructDataEntityLink()
  {
    DataEntity localDataEntity1 = DataBinder.getDataEntity(getPage());
    PageInfo localPageInfo = this.mParentPage;
    DataEntity localDataEntity2;
    for (Object localObject = localDataEntity1; (localPageInfo != null) && (localPageInfo.getPage() != null); localObject = localDataEntity2)
    {
      localDataEntity2 = DataBinder.getDataEntity(localPageInfo.getPage());
      DataEntityOperator.setParentEntity((DataEntity)localObject, localDataEntity2);
      localPageInfo = localPageInfo.mParentPage;
    }
    return localDataEntity1;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof PageInfo))
    {
      paramObject = (PageInfo)paramObject;
      return this.mPageHashCode == paramObject.mPageHashCode;
    }
    return super.equals(paramObject);
  }
  
  public Set<PageInfo> findNewInPage(PageInfo paramPageInfo)
  {
    Set localSet = getPageLinker(paramPageInfo);
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    boolean bool = equals(paramPageInfo);
    for (paramPageInfo = this; paramPageInfo != null; paramPageInfo = paramPageInfo.mParentPage) {
      if ((bool) || (!localSet.contains(paramPageInfo))) {
        localLinkedHashSet.add(paramPageInfo);
      }
    }
    return localLinkedHashSet;
  }
  
  public Set<PageInfo> findNewOutPage(PageInfo paramPageInfo)
  {
    Set localSet = getPageLinker(this);
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    int i;
    if (this == paramPageInfo) {
      i = 1;
    }
    while (paramPageInfo != null)
    {
      if ((i != 0) || (!localSet.contains(paramPageInfo))) {
        localLinkedHashSet.add(paramPageInfo);
      }
      paramPageInfo = paramPageInfo.mParentPage;
      continue;
      i = 0;
    }
    return localLinkedHashSet;
  }
  
  @Nullable
  public Object getPage()
  {
    return this.mPage.get();
  }
  
  public int getPageHashCode()
  {
    return this.mPageHashCode;
  }
  
  @Nullable
  public View getPageView()
  {
    return (View)this.mPageView.get();
  }
  
  PageInfo getParentPage()
  {
    return this.mParentPage;
  }
  
  public int hashCode()
  {
    if ((this.mPage != null) && (this.mPageView != null))
    {
      Object localObject = this.mPage.get();
      View localView = (View)this.mPageView.get();
      if ((localObject != null) && (localView != null))
      {
        int i = localObject.hashCode();
        return localView.hashCode() + i;
      }
    }
    return super.hashCode();
  }
  
  void setParentPage(@Nullable PageInfo paramPageInfo)
  {
    this.mParentPage = paramPageInfo;
  }
  
  public String toString()
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\n  size = ").append(getPageLinker(this).size());
      PageInfo localPageInfo = this;
      if (localPageInfo != null)
      {
        Object localObject2 = localPageInfo.getPage();
        String str1;
        label58:
        String str2;
        if (localObject2 == null)
        {
          str1 = "_null_page_";
          if (localObject2 != null) {
            break label158;
          }
          str2 = "_null_page_";
          label66:
          if (localObject2 != null) {
            break label167;
          }
          localObject1 = null;
          label74:
          if (localObject1 != null) {
            break label177;
          }
        }
        label158:
        label167:
        label177:
        for (Object localObject1 = "_null_params_";; localObject1 = localObject1.toString())
        {
          localStringBuilder.append("\n pageId = ").append(str1).append(", contentId = ").append(str2).append(", pageParams = ").append((String)localObject1).append(", page = ").append(localObject2).append(", pageView = ").append(localPageInfo.getPageView()).append("\n");
          localPageInfo = localPageInfo.mParentPage;
          break;
          str1 = DataRWProxy.getPageId(localObject2);
          break label58;
          str2 = DataRWProxy.getContentId(localObject2);
          break label66;
          localObject1 = DataRWProxy.getPageParams(localObject2);
          break label74;
        }
      }
      return localStringBuilder.toString();
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageInfo
 * JD-Core Version:    0.7.0.1
 */