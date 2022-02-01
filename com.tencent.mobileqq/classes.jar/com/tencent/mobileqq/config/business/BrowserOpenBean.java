package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.browser.BrowserItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/BrowserOpenBean;", "", "()V", "topBrowsers", "", "Lcom/tencent/mobileqq/browser/BrowserItem;", "blackListApps", "", "(Ljava/util/List;Ljava/util/List;)V", "getBlackListApps", "()Ljava/util/List;", "getTopBrowsers", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class BrowserOpenBean
{
  @NotNull
  private final List<BrowserItem> a;
  @NotNull
  private final List<String> b;
  
  public BrowserOpenBean()
  {
    this((List)new ArrayList(), null, 2, null);
  }
  
  public BrowserOpenBean(@NotNull List<BrowserItem> paramList, @NotNull List<String> paramList1)
  {
    this.a = paramList;
    this.b = paramList1;
  }
  
  @NotNull
  public final List<BrowserItem> a()
  {
    return this.a;
  }
  
  @NotNull
  public final List<String> b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof BrowserOpenBean))
      {
        paramObject = (BrowserOpenBean)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    List localList = this.a;
    int j = 0;
    int i;
    if (localList != null) {
      i = localList.hashCode();
    } else {
      i = 0;
    }
    localList = this.b;
    if (localList != null) {
      j = localList.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BrowserOpenBean(topBrowsers=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", blackListApps=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.BrowserOpenBean
 * JD-Core Version:    0.7.0.1
 */