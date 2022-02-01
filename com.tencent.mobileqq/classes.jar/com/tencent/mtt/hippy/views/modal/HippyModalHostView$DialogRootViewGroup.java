package com.tencent.mtt.hippy.views.modal;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.ThreadExecutor;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;

class HippyModalHostView$DialogRootViewGroup
  extends HippyViewGroup
{
  public HippyModalHostView$DialogRootViewGroup(Context paramContext)
  {
    super(paramContext);
    setFitsSystemWindows(false);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (getChildCount() > 0)
    {
      if (Build.VERSION.SDK_INT < 21) {
        getChildAt(0).layout(getChildAt(0).getLeft(), getChildAt(0).getTop(), getChildAt(0).getLeft() + paramInt1, getChildAt(0).getTop() + paramInt2);
      }
      Object localObject = (HippyInstanceContext)getContext();
      if ((localObject != null) && (((HippyInstanceContext)localObject).getEngineContext() != null))
      {
        localObject = ((HippyInstanceContext)localObject).getEngineContext();
        if (((HippyEngineContext)localObject).getThreadExecutor() != null)
        {
          paramInt3 = getChildAt(0).getId();
          ((HippyEngineContext)localObject).getThreadExecutor().postOnDomThread(new HippyModalHostView.DialogRootViewGroup.1(this, (HippyEngineContext)localObject, paramInt3, paramInt1, paramInt2));
        }
      }
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.modal.HippyModalHostView.DialogRootViewGroup
 * JD-Core Version:    0.7.0.1
 */