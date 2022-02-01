package com.tencent.qqlive.module.videoreport.traversal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;

public class ViewTraverser
  implements IViewTraverser
{
  private static final String TAG = "ViewTraverser";
  private OnViewTraverseListener mOnTraverseListener;
  
  private ViewTraverser()
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("ViewTraverser", "ViewTraverser.<init>: ");
    }
  }
  
  @Nullable
  private View fetchChildAt(ViewGroup paramViewGroup, View[] paramArrayOfView, int paramInt)
  {
    if (paramArrayOfView == null) {
      return paramViewGroup.getChildAt(paramInt);
    }
    if (paramInt < paramArrayOfView.length) {
      return paramArrayOfView[paramInt];
    }
    Log.e("ViewTraverser", "Attention: get child errorrrrrrrrr!");
    return null;
  }
  
  public static ViewTraverser getInstance()
  {
    return ViewTraverser.InstanceHolder.INSTANCE;
  }
  
  private void performInternal(@NonNull View paramView, int paramInt, @NonNull IViewTraverseCallback paramIViewTraverseCallback)
  {
    Object localObject = this.mOnTraverseListener;
    if (localObject != null) {
      ((OnViewTraverseListener)localObject).onViewVisited(paramView);
    }
    if ((paramIViewTraverseCallback.onEnter(paramView, paramInt)) && ((paramView instanceof ViewGroup)))
    {
      localObject = (ViewGroup)paramView;
      int i = ((ViewGroup)localObject).getChildCount();
      if (i != 0)
      {
        View[] arrayOfView = ViewGroupDrawingCompat.getChildrenByDrawingOrder((ViewGroup)localObject);
        i -= 1;
        while (i >= 0)
        {
          View localView = fetchChildAt((ViewGroup)localObject, arrayOfView, i);
          if (localView != null) {
            performInternal(localView, paramInt + 1, paramIViewTraverseCallback);
          }
          i -= 1;
        }
      }
    }
    paramIViewTraverseCallback.onLeave(paramView, paramInt);
  }
  
  public void perform(View paramView, IViewTraverseCallback paramIViewTraverseCallback)
  {
    if (paramView != null)
    {
      if (paramIViewTraverseCallback == null) {
        return;
      }
      performInternal(paramView, 1, paramIViewTraverseCallback);
    }
  }
  
  public void setListener(OnViewTraverseListener paramOnViewTraverseListener)
  {
    this.mOnTraverseListener = paramOnViewTraverseListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.traversal.ViewTraverser
 * JD-Core Version:    0.7.0.1
 */