package com.tencent.mtt.hippy.views.refresh;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.uimanager.b;
import com.tencent.mtt.hippy.views.view.HippyViewGroupController;

@HippyController(name="RefreshWrapperItemView")
public class RefreshWrapperItemController
  extends HippyViewGroupController
{
  public View createViewImpl(Context paramContext)
  {
    return new RefreshWrapperItemView(paramContext);
  }
  
  public void updateLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, b paramb)
  {
    super.updateLayout(paramInt1, paramInt2, paramInt3 - paramInt5, paramInt4, paramInt5, paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.refresh.RefreshWrapperItemController
 * JD-Core Version:    0.7.0.1
 */