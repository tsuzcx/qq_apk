package com.tencent.mobileqq.ocr.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.Group;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.ResultItem;
import com.tencent.mobileqq.ocr.TabItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class SearchResultAdapter
  extends BaseAdapter
{
  WeakReference<Context> a;
  List<SearchResultAdapter.ListItem> b = new ArrayList();
  SearchResultAdapter.OnResultItemClickedListener c;
  SearchViewBuilderFactory d = new SearchViewBuilderFactory();
  View.OnClickListener e = new SearchResultAdapter.1(this);
  
  public SearchResultAdapter(Context paramContext, SearchResultAdapter.OnResultItemClickedListener paramOnResultItemClickedListener)
  {
    this.a = new WeakReference(paramContext);
    this.c = paramOnResultItemClickedListener;
  }
  
  public void a()
  {
    this.b.clear();
    super.notifyDataSetChanged();
  }
  
  public void a(TabItem paramTabItem, List<OCRTextSearchInfo.Group> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramTabItem, paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public void a(TabItem paramTabItem, List<OCRTextSearchInfo.Group> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1)
    {
      if (this.b.size() > 0)
      {
        localObject1 = this.b;
        localObject1 = (SearchResultAdapter.ListItem)((List)localObject1).get(((List)localObject1).size() - 1);
        if (((SearchResultAdapter.ListItem)localObject1).a == 5) {
          this.b.remove(localObject1);
        }
      }
    }
    else {
      this.b.clear();
    }
    Object localObject1 = null;
    int i = 0;
    while (i < paramList.size())
    {
      OCRTextSearchInfo.Group localGroup = (OCRTextSearchInfo.Group)paramList.get(i);
      Object localObject2;
      if (paramTabItem.a == 0)
      {
        localObject1 = new SearchResultAdapter.ListItem(this);
        ((SearchResultAdapter.ListItem)localObject1).a = 3;
        if (!TextUtils.isEmpty(localGroup.a))
        {
          ((SearchResultAdapter.ListItem)localObject1).b = localGroup.a;
          ((SearchResultAdapter.ListItem)localObject1).c = localGroup.a;
        }
        localObject2 = localObject1;
      }
      else
      {
        localObject2 = null;
      }
      Object localObject3;
      if (localGroup.e.size() != 0)
      {
        if ((paramTabItem.a == 0) && (paramBoolean3))
        {
          if (i != 0)
          {
            localObject3 = new SearchResultAdapter.ListItem(this);
            ((SearchResultAdapter.ListItem)localObject3).a = 2;
            this.b.add(localObject3);
          }
          this.b.add(localObject2);
          localObject2 = new SearchResultAdapter.ListItem(this);
          ((SearchResultAdapter.ListItem)localObject2).a = 1;
          this.b.add(localObject2);
        }
        int j = 0;
        while (j < localGroup.e.size())
        {
          localObject2 = (OCRTextSearchInfo.ResultItem)localGroup.e.get(j);
          localObject3 = new SearchResultAdapter.ListItem(this);
          ((SearchResultAdapter.ListItem)localObject3).a = 0;
          ((SearchResultAdapter.ListItem)localObject3).b = ((OCRTextSearchInfo.ResultItem)localObject2).a;
          ((SearchResultAdapter.ListItem)localObject3).c = localGroup.a;
          ((SearchResultAdapter.ListItem)localObject3).f = localGroup.b;
          ((SearchResultAdapter.ListItem)localObject3).h = j;
          this.b.add(localObject3);
          if (j != localGroup.e.size() - 1)
          {
            localObject2 = new SearchResultAdapter.ListItem(this);
            ((SearchResultAdapter.ListItem)localObject2).a = 1;
            this.b.add(localObject2);
          }
          j += 1;
        }
      }
      if ((!TextUtils.isEmpty(localGroup.c)) && (paramTabItem.a == 0))
      {
        localObject2 = localGroup.c;
        localObject3 = localGroup.d;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = new SearchResultAdapter.ListItem(this);
          ((SearchResultAdapter.ListItem)localObject2).a = 1;
          this.b.add(localObject2);
          localObject2 = new SearchResultAdapter.ListItem(this);
          ((SearchResultAdapter.ListItem)localObject2).a = 4;
          ((SearchResultAdapter.ListItem)localObject2).e = localGroup.c;
          ((SearchResultAdapter.ListItem)localObject2).c = localGroup.a;
          ((SearchResultAdapter.ListItem)localObject2).d = localGroup.d;
          ((SearchResultAdapter.ListItem)localObject2).f = localGroup.b;
          ((SearchResultAdapter.ListItem)localObject2).g = true;
          this.b.add(localObject2);
          if (localObject1 != null)
          {
            ((SearchResultAdapter.ListItem)localObject1).d = localGroup.d;
            ((SearchResultAdapter.ListItem)localObject1).e = localGroup.c;
            ((SearchResultAdapter.ListItem)localObject1).f = localGroup.b;
            ((SearchResultAdapter.ListItem)localObject1).g = true;
          }
        }
      }
      i += 1;
    }
    paramTabItem = new SearchResultAdapter.ListItem(this);
    paramTabItem.a = 1;
    this.b.add(paramTabItem);
    if (paramBoolean2)
    {
      paramTabItem = new SearchResultAdapter.ListItem(this);
      paramTabItem.a = 5;
      this.b.add(paramTabItem);
    }
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getCount())) {
      return this.b.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((SearchResultAdapter.ListItem)this.b.get(paramInt)).a;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if ((Context)this.a.get() == null)
    {
      localObject = null;
    }
    else
    {
      SearchResultAdapter.ListItem localListItem = (SearchResultAdapter.ListItem)this.b.get(paramInt);
      if (localListItem.a == 0)
      {
        localObject = (SearchSougouResultItemBuilder)this.d.a(0);
        ((SearchSougouResultItemBuilder)localObject).a(paramViewGroup);
        localObject = ((SearchSougouResultItemBuilder)localObject).a(paramInt, paramView, paramViewGroup, this, localListItem);
        ((View)localObject).setOnClickListener(this.e);
      }
      else
      {
        localObject = paramView;
        if (localListItem.a == 1) {
          localObject = ((SearchResultLineItemBuilder)this.d.a(1)).a(paramInt, paramView, paramViewGroup, this, localListItem);
        }
      }
      ((View)localObject).setTag(localListItem);
      paramView = (View)localObject;
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */