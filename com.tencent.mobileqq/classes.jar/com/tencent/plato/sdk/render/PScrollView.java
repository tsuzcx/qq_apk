package com.tencent.plato.sdk.render;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.JSONWritableMap;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.IWritableMap;
import com.tencent.plato.sdk.render.data.ElementItem;
import com.tencent.plato.sdk.utils.Dimension;
import com.tencent.plato.sdk.widget.PullToRefreshBase;
import com.tencent.plato.sdk.widget.PullToRefreshBase.Mode;
import com.tencent.plato.sdk.widget.PullToRefreshBase.OnRefreshListener;
import java.util.ArrayList;
import java.util.List;

public class PScrollView
  extends PDivView
{
  private static final int MSG_HORIZONTAL_SCROLL_STOP = 0;
  private static final int MSG_VERTICAL_SCROLL_STOP = 1;
  private static final int intervalTime = 100;
  ElementItem element;
  boolean needRefreshEvent = false;
  boolean needScrollChangeEvent = false;
  boolean needScrollStopEvent = false;
  
  private void fireScrollChangeEvent(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    JSONWritableMap localJSONWritableMap = new JSONWritableMap();
    localJSONWritableMap.put("offsetX", -(int)Dimension.devicePx2RemPx(paramInt1));
    localJSONWritableMap.put("offsetY", -(int)Dimension.devicePx2RemPx(paramInt2));
    localJSONWritableMap.put("oldOffsetX", -(int)Dimension.devicePx2RemPx(paramInt3));
    localJSONWritableMap.put("oldOffsetY", -(int)Dimension.devicePx2RemPx(paramInt4));
    fireEvent(getPageId(), this.id, "scrollchange", localJSONWritableMap);
  }
  
  private void fireScrollStopEvent(View paramView, int paramInt1, int paramInt2)
  {
    JSONWritableMap localJSONWritableMap = new JSONWritableMap();
    int j = 0;
    int i = 0;
    if ((paramView instanceof PHScrollView))
    {
      j = ((PHScrollView)paramView).getHorizontalScrollRange();
      i = ((PHScrollView)paramView).getVerticalScrollRange();
    }
    for (;;)
    {
      localJSONWritableMap.put("width", (int)Dimension.devicePx2RemPx(this.element.getLayoutWidth()));
      localJSONWritableMap.put("height", (int)Dimension.devicePx2RemPx(this.element.getLayoutHeight()));
      localJSONWritableMap.put("contentWidth", (int)Dimension.devicePx2RemPx(j));
      localJSONWritableMap.put("contentHeight", (int)Dimension.devicePx2RemPx(i));
      localJSONWritableMap.put("offsetX", -(int)Dimension.devicePx2RemPx(paramInt1));
      localJSONWritableMap.put("offsetY", -(int)Dimension.devicePx2RemPx(paramInt2));
      fireEvent(getPageId(), this.id, "scrollstop", localJSONWritableMap);
      return;
      if ((paramView instanceof verticalScrollView))
      {
        j = ((verticalScrollView)paramView).getHorizontalScrollRange();
        i = ((verticalScrollView)paramView).getVerticalScrollRange();
      }
    }
  }
  
  public void attachEvent(List<String> paramList)
  {
    super.attachEvent(paramList);
    Log.e("PScrollView", "attachEvent");
    if ((paramList != null) && (paramList.contains("pullrefresh")) && ((this.view instanceof PVScrollView)))
    {
      this.needRefreshEvent = true;
      ((PVScrollView)this.view).setUseDefaultRefreshView();
      ((PVScrollView)this.view).setMode(PullToRefreshBase.Mode.PULL_FROM_START);
      ((PVScrollView)this.view).setOnRefreshListener(new PullToRefreshBase.OnRefreshListener()
      {
        public void onRefresh(PullToRefreshBase<ScrollView> paramAnonymousPullToRefreshBase)
        {
          PScrollView.this.fireEvent(PScrollView.this.getPageId(), PScrollView.this.id, "pullrefresh", null);
        }
      });
    }
    if ((paramList != null) && (paramList.contains("scrollstop"))) {
      this.needScrollStopEvent = true;
    }
    if ((paramList != null) && (paramList.contains("scrollchange"))) {
      this.needScrollChangeEvent = true;
    }
    if ((this.needScrollChangeEvent) || (this.needScrollStopEvent))
    {
      if (!(this.view instanceof PHScrollView)) {
        break label167;
      }
      ((PHScrollView)this.view).setScrollViewListener(new PScrollViewListener()
      {
        public void onScrollChanged(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          if (PScrollView.this.needScrollChangeEvent) {
            PScrollView.this.fireScrollChangeEvent(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
          }
        }
        
        public void onScrollStopped(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          if (PScrollView.this.needScrollStopEvent) {
            PScrollView.this.fireScrollStopEvent(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          }
        }
      });
    }
    label167:
    while (!(this.view instanceof PVScrollView)) {
      return;
    }
    ((verticalScrollView)((PVScrollView)this.view).getRefreshableView()).setScrollViewListener(new PScrollViewListener()
    {
      public void onScrollChanged(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        if (PScrollView.this.needScrollChangeEvent) {
          PScrollView.this.fireScrollChangeEvent(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        }
      }
      
      public void onScrollStopped(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (PScrollView.this.needScrollStopEvent) {
          PScrollView.this.fireScrollStopEvent(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        }
      }
    });
  }
  
  public void init(IPlatoRuntime paramIPlatoRuntime, IPView paramIPView, ElementItem paramElementItem)
  {
    super.init(paramIPlatoRuntime, paramIPView, paramElementItem);
    if (paramElementItem != null)
    {
      this.element = paramElementItem;
      if (!paramElementItem.getUIStyles().getBoolean("horizontal", false)) {
        break label76;
      }
    }
    label76:
    for (this.view = new PHScrollView(getPlatoRuntime().getContext());; this.view = new PVScrollView(getPlatoRuntime().getContext()))
    {
      this.id = paramElementItem.getElementId();
      this.needRefreshEvent = false;
      this.needScrollChangeEvent = false;
      this.needScrollStopEvent = false;
      return;
    }
  }
  
  public void setStyles(IReadableMap paramIReadableMap)
  {
    super.setStyles(paramIReadableMap);
    if (!paramIReadableMap.getBoolean("refresingData", true)) {
      ((PVScrollView)this.view).onRefreshComplete();
    }
  }
  
  public void setTopView(IPView paramIPView)
  {
    if ((this.needRefreshEvent) && ((this.view instanceof PVScrollView))) {
      ((PVScrollView)this.view).setRefreshView(getPlatoRuntime().getContext(), paramIPView);
    }
  }
  
  public class PHScrollView
    extends HorizontalScrollView
    implements Handler.Callback
  {
    private Context mContext;
    private Handler mHorizontalHandler;
    private int mInitialPosition;
    private List<PScrollView.PScrollViewListener> mScrollViewListeners = new ArrayList();
    private ViewGroup.LayoutParams params;
    private ViewGroup scrollContainer;
    
    public PHScrollView(Context paramContext)
    {
      super();
      this.mContext = paramContext;
      setOverScrollMode(2);
      setHorizontalScrollBarEnabled(false);
      this.params = new ViewGroup.LayoutParams(-2, -2);
      this.scrollContainer = new FrameLayout(this.mContext);
      super.addView(this.scrollContainer, this.params);
      startScrollerTask();
    }
    
    private void onScrollStopped(View paramView, int paramInt1, int paramInt2)
    {
      if (this.mScrollViewListeners == null) {}
      for (int i = 0;; i = this.mScrollViewListeners.size())
      {
        int j = 0;
        while (j < i)
        {
          ((PScrollView.PScrollViewListener)this.mScrollViewListeners.get(j)).onScrollStopped(paramView, paramInt1, paramInt2);
          j += 1;
        }
      }
    }
    
    private void startScrollerTask()
    {
      if (this.mHorizontalHandler == null) {
        this.mHorizontalHandler = new Handler(Looper.getMainLooper(), this);
      }
      this.mInitialPosition = getScrollY();
      this.mHorizontalHandler.sendEmptyMessageDelayed(0, 100L);
    }
    
    public void addView(View paramView)
    {
      addView(paramView, -1);
    }
    
    public void addView(View paramView, int paramInt)
    {
      this.scrollContainer.addView(paramView, paramInt);
    }
    
    public void fling(int paramInt)
    {
      super.fling(paramInt);
      if (this.mHorizontalHandler != null) {
        this.mHorizontalHandler.removeMessages(0);
      }
      startScrollerTask();
    }
    
    public int getHorizontalScrollRange()
    {
      return computeHorizontalScrollRange();
    }
    
    public int getVerticalScrollRange()
    {
      return computeVerticalScrollRange();
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        return true;
        if (this.mHorizontalHandler != null) {
          this.mHorizontalHandler.removeMessages(0);
        }
        int i = getScrollY();
        if (this.mInitialPosition - i == 0)
        {
          onScrollStopped(this, getScrollX(), getScrollY());
        }
        else
        {
          this.mInitialPosition = getScrollY();
          if (this.mHorizontalHandler != null) {
            this.mHorizontalHandler.sendEmptyMessageDelayed(0, 100L);
          }
        }
      }
    }
    
    protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.mScrollViewListeners == null) {}
      for (int i = 0;; i = this.mScrollViewListeners.size())
      {
        int j = 0;
        while (j < i)
        {
          ((PScrollView.PScrollViewListener)this.mScrollViewListeners.get(j)).onScrollChanged(PScrollView.this.view, paramInt1, paramInt2, paramInt3, paramInt4);
          j += 1;
        }
      }
    }
    
    public void removeAllViews()
    {
      this.scrollContainer.removeAllViews();
      super.removeAllViews();
    }
    
    public void removeScrollViewListener(PScrollView.PScrollViewListener paramPScrollViewListener)
    {
      this.mScrollViewListeners.remove(paramPScrollViewListener);
    }
    
    public void removeView(View paramView)
    {
      this.scrollContainer.removeView(paramView);
    }
    
    public void setScrollViewListener(PScrollView.PScrollViewListener paramPScrollViewListener)
    {
      if (!this.mScrollViewListeners.contains(paramPScrollViewListener)) {
        this.mScrollViewListeners.add(paramPScrollViewListener);
      }
    }
  }
  
  public static abstract interface PScrollViewListener
  {
    public abstract void onScrollChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void onScrollStopped(View paramView, int paramInt1, int paramInt2);
  }
  
  public class PVScrollView
    extends PullToRefreshBase<ScrollView>
  {
    private ViewGroup scrollContainer;
    
    public PVScrollView(Context paramContext)
    {
      super();
      this$1 = new ViewGroup.LayoutParams(-2, -2);
      this.scrollContainer = new FrameLayout(paramContext);
      super.addView(this.scrollContainer, PScrollView.this);
    }
    
    public void addView(View paramView)
    {
      addView(paramView, -1);
    }
    
    public void addView(View paramView, int paramInt)
    {
      this.scrollContainer.addView(paramView, paramInt);
    }
    
    protected ScrollView createRefreshableView(Context paramContext, AttributeSet paramAttributeSet)
    {
      paramContext = new PScrollView.verticalScrollView(PScrollView.this, paramContext, paramAttributeSet);
      paramContext.setOverScrollMode(2);
      paramContext.setVerticalScrollBarEnabled(false);
      return paramContext;
    }
    
    protected boolean isReadyForPullEnd()
    {
      View localView = ((ScrollView)this.mRefreshableView).getChildAt(0);
      if (localView != null) {
        return ((ScrollView)this.mRefreshableView).getScrollY() >= localView.getHeight() - getHeight();
      }
      return false;
    }
    
    protected boolean isReadyForPullStart()
    {
      return ((ScrollView)this.mRefreshableView).getScrollY() == 0;
    }
    
    public void removeAllViews()
    {
      this.scrollContainer.removeAllViews();
      super.removeAllViews();
    }
    
    public void removeView(View paramView)
    {
      this.scrollContainer.removeView(paramView);
    }
  }
  
  public class verticalScrollView
    extends ScrollView
    implements Handler.Callback
  {
    private int mInitialPosition;
    private List<PScrollView.PScrollViewListener> mScrollViewListeners = new ArrayList();
    private Handler mVerticalHandler;
    
    public verticalScrollView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      startScrollerTask();
    }
    
    private void onScrollStopped(View paramView, int paramInt1, int paramInt2)
    {
      if (this.mScrollViewListeners == null) {}
      for (int i = 0;; i = this.mScrollViewListeners.size())
      {
        int j = 0;
        while (j < i)
        {
          ((PScrollView.PScrollViewListener)this.mScrollViewListeners.get(j)).onScrollStopped(paramView, paramInt1, paramInt2);
          j += 1;
        }
      }
    }
    
    private void startScrollerTask()
    {
      if (this.mVerticalHandler == null) {
        this.mVerticalHandler = new Handler(Looper.getMainLooper(), this);
      }
      this.mInitialPosition = getScrollY();
      this.mVerticalHandler.sendEmptyMessageDelayed(1, 100L);
    }
    
    public void fling(int paramInt)
    {
      super.fling(paramInt);
      if (this.mVerticalHandler != null) {
        this.mVerticalHandler.removeMessages(1);
      }
      startScrollerTask();
    }
    
    public int getHorizontalScrollRange()
    {
      return computeHorizontalScrollRange();
    }
    
    public int getVerticalScrollRange()
    {
      return computeVerticalScrollRange();
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        return true;
        if (this.mVerticalHandler != null) {
          this.mVerticalHandler.removeMessages(1);
        }
        int i = getScrollY();
        if (this.mInitialPosition - i == 0)
        {
          onScrollStopped(this, getScrollX(), getScrollY());
          return true;
        }
        this.mInitialPosition = getScrollY();
      } while (this.mVerticalHandler == null);
      this.mVerticalHandler.sendEmptyMessageDelayed(1, 100L);
      return true;
    }
    
    protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.mScrollViewListeners == null) {}
      for (int i = 0;; i = this.mScrollViewListeners.size())
      {
        int j = 0;
        while (j < i)
        {
          ((PScrollView.PScrollViewListener)this.mScrollViewListeners.get(j)).onScrollChanged(PScrollView.this.view, paramInt1, paramInt2, paramInt3, paramInt4);
          j += 1;
        }
      }
    }
    
    public void removeScrollViewListener(PScrollView.PScrollViewListener paramPScrollViewListener)
    {
      this.mScrollViewListeners.remove(paramPScrollViewListener);
    }
    
    public void setScrollViewListener(PScrollView.PScrollViewListener paramPScrollViewListener)
    {
      if (!this.mScrollViewListeners.contains(paramPScrollViewListener)) {
        this.mScrollViewListeners.add(paramPScrollViewListener);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.render.PScrollView
 * JD-Core Version:    0.7.0.1
 */