package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public abstract class EmoticonPanelViewBinder
  extends EmoticonViewBinder
{
  private static final String LOG_TAG = "EmoticonPanelViewBinder";
  private static EmoticonPanelViewPool sViewPool;
  protected Context context;
  public int initPage;
  protected int sessionType;
  protected SparseArray<View> usingViews;
  
  public EmoticonPanelViewBinder(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramInt1);
    if (paramContext == null) {
      throw new IllegalArgumentException("Context MUST NOT be null!!!");
    }
    this.context = paramContext;
    this.initPage = paramInt2;
    this.usingViews = new SparseArray();
  }
  
  public static void destroyViewPool()
  {
    if (sViewPool != null)
    {
      sViewPool.destroy();
      sViewPool = null;
    }
  }
  
  private boolean isPanelViewReuseable(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  protected View createEmoticonPanelView(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelViewBinder", 2, " createEmoticonPanelView, type=" + paramInt);
    }
    long l = System.currentTimeMillis();
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelViewBinder", 2, "[Performance] createEmoticonPanelView, type=" + paramInt + ",duration=" + (System.currentTimeMillis() - l));
      }
      return localObject;
      localObject = new EmoticonLinearLayout(this.context, null);
      ((EmoticonLinearLayout)localObject).setPanelViewType(paramInt);
    }
  }
  
  public void destroy()
  {
    this.context = null;
    if (this.usingViews != null) {
      this.usingViews.clear();
    }
  }
  
  public void destroyEmoticonPanelView(int paramInt)
  {
    if (this.usingViews == null) {}
    View localView;
    do
    {
      do
      {
        do
        {
          return;
          localView = (View)this.usingViews.get(paramInt);
        } while (localView == null);
        this.usingViews.remove(paramInt);
        paramInt = getEmoticonPanelViewType(paramInt);
      } while (!isPanelViewReuseable(paramInt));
      if (sViewPool == null) {
        sViewPool = new EmoticonPanelViewPool();
      }
    } while (sViewPool.addRecyleView(paramInt, localView));
  }
  
  protected View getEmoticonPanelView(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelViewBinder", 2, "getEmoticonPanelView, pageIndex=" + paramInt + ",viewBinder=" + this);
    }
    int i = getEmoticonPanelViewType(paramInt);
    View localView1 = null;
    if (sViewPool != null) {
      localView1 = sViewPool.getRecyleView(i);
    }
    View localView2 = localView1;
    if (localView1 == null) {
      localView2 = createEmoticonPanelView(i);
    }
    if (localView2 != null)
    {
      if (this.usingViews == null) {
        this.usingViews = new SparseArray();
      }
      this.usingViews.put(paramInt, localView2);
      updatePanelView(localView2, paramInt);
    }
    return localView2;
  }
  
  protected abstract int getEmoticonPanelViewType(int paramInt);
  
  public int getIndicatorSize()
  {
    return getPanelPageCount();
  }
  
  protected View getUsingEmoticonPanelView(int paramInt)
  {
    if (this.usingViews == null) {
      return null;
    }
    return (View)this.usingViews.get(paramInt);
  }
  
  protected abstract void updatePanelView(View paramView, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder
 * JD-Core Version:    0.7.0.1
 */