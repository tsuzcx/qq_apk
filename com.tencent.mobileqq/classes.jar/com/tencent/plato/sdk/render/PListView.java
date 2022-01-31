package com.tencent.plato.sdk.render;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.JSONWritableMap;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.IWritableMap;
import com.tencent.plato.core.utils.AssertUtil;
import com.tencent.plato.sdk.render.adapter.ItemElementData;
import com.tencent.plato.sdk.render.adapter.ItemEventCallback;
import com.tencent.plato.sdk.render.adapter.ListBaseAdapter;
import com.tencent.plato.sdk.render.data.BlockElementData;
import com.tencent.plato.sdk.render.data.ElementItem;
import com.tencent.plato.sdk.widget.PullToRefreshAdapterViewBase;
import com.tencent.plato.sdk.widget.PullToRefreshBase;
import com.tencent.plato.sdk.widget.PullToRefreshBase.Mode;
import com.tencent.plato.sdk.widget.PullToRefreshBase.OnLastItemVisibleListener;
import com.tencent.plato.sdk.widget.PullToRefreshBase.OnRefreshListener;
import com.tencent.plato.sdk.widget.PullToRefreshBase.State;
import com.tencent.plato.sdk.widget.RefreshStateCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class PListView
  extends PBlockView
  implements ItemEventCallback, RefreshStateCallback
{
  public static final boolean Debug = false;
  public static final int PRELOAD_COUNT = 2;
  public static final String TAG = "PListView";
  ListBaseAdapter adapter;
  ArrayList<ItemElementData> adapterDatas = new ArrayList();
  volatile PullToRefreshBase<ListView> currentRefreshView;
  volatile boolean isLoadingMore = false;
  boolean isOnMeasure = false;
  volatile boolean isRefreshing = false;
  int lastDataSize = -1;
  HashSet<Integer> mItemClickEvent = new HashSet();
  volatile boolean needLoadMore = false;
  volatile boolean needRrfresh = false;
  IPView parentView = null;
  
  private void attachListEvent(ListView paramListView)
  {
    paramListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousInt = ((ItemElementData)PListView.this.adapterDatas.get(paramAnonymousInt)).blockData.getElementId();
        if ((PListView.this.mItemClickEvent != null) && (PListView.this.mItemClickEvent.contains(Integer.valueOf(paramAnonymousInt)))) {
          PListView.this.fireEvent(PListView.this.getPageId(), paramAnonymousInt, "click", null);
        }
      }
    });
  }
  
  private boolean isNeedSetItemClickListener()
  {
    return this.mItemClickEvent.size() > 0;
  }
  
  private void parseData()
  {
    if (this.adapterDatas != null) {
      this.adapterDatas.clear();
    }
    if ((this.mBlockRoot != null) && (this.mBlockRoot.mChildren != null))
    {
      Iterator localIterator = this.mBlockRoot.mChildren.iterator();
      while (localIterator.hasNext())
      {
        BlockElementData localBlockElementData = (BlockElementData)localIterator.next();
        if ((localBlockElementData.getEvents() != null) && (localBlockElementData.getEvents().contains("click"))) {
          this.mItemClickEvent.add(Integer.valueOf(localBlockElementData.getElementId()));
        }
        if ((localBlockElementData != null) && (localBlockElementData.getElementType().equals("item")))
        {
          ItemElementData localItemElementData = new ItemElementData();
          localItemElementData.id = localBlockElementData.getElementId();
          localItemElementData.blockData = localBlockElementData;
          int i;
          if (localBlockElementData.getUIStyles() != null)
          {
            i = localBlockElementData.getUIStyles().getInt("reuseid", -1);
            if (i < 0) {
              break label198;
            }
          }
          label198:
          for (boolean bool = true;; bool = false)
          {
            AssertUtil.Assert(bool, "reuseid error, reuseid need start from 0 ");
            localItemElementData.itemType = i;
            this.adapterDatas.add(localItemElementData);
            break;
          }
        }
      }
    }
    if (this.adapter != null) {
      this.adapter.setData(this.adapterDatas);
    }
    if ((this.lastDataSize == this.adapterDatas.size()) && (!this.isRefreshing)) {
      this.needLoadMore = false;
    }
    this.lastDataSize = this.adapterDatas.size();
  }
  
  private void processingRefresh()
  {
    if ((this.needLoadMore) && (!this.isLoadingMore)) {
      ((PRealListView)this.view).setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener()
      {
        public void onLastItemVisible()
        {
          PListView.this.isLoadingMore = true;
          PListView.this.fireEvent(PListView.this.getPageId(), PListView.this.id, "loadmore", null);
        }
      });
    }
    if (this.needRrfresh)
    {
      BlockElementData localBlockElementData;
      if ((this.mBlockRoot != null) && (this.mBlockRoot.mChildren != null) && (this.mBlockRoot.mChildren.size() > 0))
      {
        localBlockElementData = (BlockElementData)this.mBlockRoot.mChildren.get(0);
        this.isRefreshing = localBlockElementData.getUIStyles().getBoolean("refreshing", false);
        if (!localBlockElementData.getElementType().equals("refreshcontrol")) {
          break label201;
        }
        if (((PRealListView)this.view).getRefreshElement() != null) {
          break label183;
        }
        ((PRealListView)this.view).setRefreshElement(getPlatoRuntime(), localBlockElementData);
        ((PRealListView)this.view).setEventCallBack(this);
      }
      for (;;)
      {
        ((PRealListView)this.view).setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        ((PRealListView)this.view).setOnRefreshListener(new PullToRefreshBase.OnRefreshListener()
        {
          public void onRefresh(PullToRefreshBase<ListView> paramAnonymousPullToRefreshBase)
          {
            PListView.this.fireEvent(PListView.this.getPageId(), PListView.this.id, "pullrefresh", null);
          }
        });
        return;
        label183:
        ((PRealListView)this.view).updateRefreshElement(getPlatoRuntime(), localBlockElementData);
        continue;
        label201:
        ((PRealListView)this.view).setUseDefaultRefreshView();
      }
    }
    ((PRealListView)this.view).setMode(PullToRefreshBase.Mode.DISABLED);
  }
  
  public void attachEvent(List<String> paramList)
  {
    super.attachEvent(paramList);
    if ((paramList != null) && (paramList.contains("loadmore"))) {
      this.needLoadMore = true;
    }
    if ((paramList != null) && (paramList.contains("pullrefresh"))) {
      this.needRrfresh = true;
    }
  }
  
  public void click(int paramInt, String paramString, IReadableMap paramIReadableMap)
  {
    fireEvent(getPageId(), paramInt, paramString, paramIReadableMap);
  }
  
  public void createBlockFinish()
  {
    if (this.isDirty)
    {
      if ((this.mBlockRoot != null) && (this.mBlockRoot.mChildren != null))
      {
        int i = this.mBlockRoot.mChildren.size() - 1;
        while (i > 0)
        {
          BlockElementData localBlockElementData = (BlockElementData)this.mBlockRoot.mChildren.get(i);
          if (localBlockElementData.rc.top == 0) {
            localBlockElementData.needReRect = false;
          }
          if (localBlockElementData.needReRect)
          {
            localBlockElementData.rc.top = (((BlockElementData)this.mBlockRoot.mChildren.get(i)).rect.top - ((BlockElementData)this.mBlockRoot.mChildren.get(i - 1)).rect.top - ((BlockElementData)this.mBlockRoot.mChildren.get(i - 1)).rect.height);
            localBlockElementData.needReRect = false;
          }
          i -= 1;
        }
      }
      parseData();
      processingRefresh();
      this.isLoadingMore = false;
      if (isNeedSetItemClickListener()) {
        attachListEvent((ListView)this.view);
      }
    }
    this.isDirty = false;
    if (!this.isRefreshing) {
      ((PRealListView)this.view).onRefreshComplete();
    }
  }
  
  public void init(IPlatoRuntime paramIPlatoRuntime, IPView paramIPView, ElementItem paramElementItem)
  {
    super.init(paramIPlatoRuntime, paramIPView, paramElementItem);
    this.parentView = paramIPView;
    this.view = new PRealListView(paramIPlatoRuntime.getContext());
    this.id = paramElementItem.getElementId();
    this.adapter = new ListBaseAdapter(paramIPlatoRuntime, this);
    if ((this.view instanceof PRealListView)) {
      ((PRealListView)this.view).setAdapter(this.adapter);
    }
  }
  
  protected void initBlock(int paramInt)
  {
    this.mBlockRoot = createData(null, paramInt, null);
    this.mBlockDatas = new HashMap();
  }
  
  public void refreshState(PullToRefreshBase.State paramState)
  {
    JSONWritableMap localJSONWritableMap = new JSONWritableMap();
    switch (4.$SwitchMap$com$tencent$plato$sdk$widget$PullToRefreshBase$State[paramState.ordinal()])
    {
    }
    for (;;)
    {
      fireEvent(getPageId(), ((BlockElementData)this.mBlockRoot.mChildren.get(0)).getElementId(), "refresh", localJSONWritableMap);
      return;
      localJSONWritableMap.put("refreshingState", "1");
      continue;
      localJSONWritableMap.put("refreshingState", "2");
      continue;
      localJSONWritableMap.put("refreshingState", "3");
    }
  }
  
  public class InternalListView
    extends ListView
  {
    public InternalListView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public boolean getMeasureState()
    {
      return PListView.this.isOnMeasure;
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      PListView.this.isOnMeasure = false;
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      PListView.this.isOnMeasure = true;
      int i = -1;
      if (PListView.this.parentView != null) {
        i = PListView.this.parentView.getHeight();
      }
      int j = View.MeasureSpec.getSize(paramInt2);
      if ((i != -1) && (j > i))
      {
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(Math.min(i, j), -2147483648));
        return;
      }
      super.onMeasure(paramInt1, paramInt2);
    }
  }
  
  public class PRealListView
    extends PullToRefreshAdapterViewBase<ListView>
  {
    public PRealListView(Context paramContext)
    {
      super();
    }
    
    protected ListView createRefreshableView(Context paramContext, AttributeSet paramAttributeSet)
    {
      paramContext = new PListView.InternalListView(PListView.this, paramContext, paramAttributeSet);
      paramContext.setContentDescription("InternalListView");
      paramContext.setDivider(null);
      return paramContext;
    }
  }
  
  class URL
  {
    int h;
    String url;
    int w;
    
    URL() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.render.PListView
 * JD-Core Version:    0.7.0.1
 */