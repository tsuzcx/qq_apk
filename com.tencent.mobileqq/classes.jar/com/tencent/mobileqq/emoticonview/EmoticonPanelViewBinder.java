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
    if (paramContext != null)
    {
      this.context = paramContext;
      this.initPage = paramInt2;
      this.usingViews = new SparseArray();
      return;
    }
    throw new IllegalArgumentException("Context MUST NOT be null!!!");
  }
  
  public static void destroyViewPool()
  {
    EmoticonPanelViewPool localEmoticonPanelViewPool = sViewPool;
    if (localEmoticonPanelViewPool != null)
    {
      localEmoticonPanelViewPool.destroy();
      sViewPool = null;
    }
  }
  
  private boolean isPanelViewReuseable(int paramInt)
  {
    return paramInt == 2007;
  }
  
  protected View createEmoticonPanelView(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" createEmoticonPanelView, type=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("EmoticonPanelViewBinder", 2, ((StringBuilder)localObject).toString());
    }
    long l = System.currentTimeMillis();
    if (paramInt != 2007)
    {
      localObject = null;
    }
    else
    {
      localObject = new EmoticonLinearLayout(this.context, null);
      ((EmoticonLinearLayout)localObject).setPanelViewType(paramInt);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Performance] createEmoticonPanelView, type=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",duration=");
      localStringBuilder.append(System.currentTimeMillis() - l);
      QLog.d("EmoticonPanelViewBinder", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public void destroy()
  {
    this.context = null;
    SparseArray localSparseArray = this.usingViews;
    if (localSparseArray != null) {
      localSparseArray.clear();
    }
  }
  
  public void destroyEmoticonPanelView(int paramInt)
  {
    Object localObject = this.usingViews;
    if (localObject == null) {
      return;
    }
    localObject = (View)((SparseArray)localObject).get(paramInt);
    if (localObject != null)
    {
      this.usingViews.remove(paramInt);
      paramInt = getEmoticonPanelViewType(paramInt);
      if (!isPanelViewReuseable(paramInt)) {
        return;
      }
      if (sViewPool == null) {
        sViewPool = new EmoticonPanelViewPool();
      }
      sViewPool.addRecyleView(paramInt, (View)localObject);
    }
  }
  
  protected View getEmoticonPanelView(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getEmoticonPanelView, pageIndex=");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(",viewBinder=");
      ((StringBuilder)localObject1).append(this);
      QLog.d("EmoticonPanelViewBinder", 2, ((StringBuilder)localObject1).toString());
    }
    int i = getEmoticonPanelViewType(paramInt);
    Object localObject1 = null;
    Object localObject2 = sViewPool;
    if (localObject2 != null) {
      localObject1 = ((EmoticonPanelViewPool)localObject2).getRecyleView(i);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = createEmoticonPanelView(i);
    }
    if (localObject2 != null)
    {
      if (this.usingViews == null) {
        this.usingViews = new SparseArray();
      }
      this.usingViews.put(paramInt, localObject2);
      updatePanelView((View)localObject2, paramInt);
    }
    return localObject2;
  }
  
  protected abstract int getEmoticonPanelViewType(int paramInt);
  
  public int getIndicatorSize()
  {
    return getPanelPageCount();
  }
  
  protected View getUsingEmoticonPanelView(int paramInt)
  {
    SparseArray localSparseArray = this.usingViews;
    if (localSparseArray == null) {
      return null;
    }
    return (View)localSparseArray.get(paramInt);
  }
  
  protected abstract void updatePanelView(View paramView, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder
 * JD-Core Version:    0.7.0.1
 */