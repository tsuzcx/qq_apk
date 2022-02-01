package com.tencent.qqlive.module.videoreport.page;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.Nullable;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

class ViewActivityMap
{
  private final Map<Context, WeakReference<Activity>> mViewActivityMap = new WeakHashMap();
  
  @Nullable
  private Activity fromContext(Context paramContext)
  {
    while (paramContext != null)
    {
      if ((paramContext instanceof Activity)) {
        return (Activity)paramContext;
      }
      if (!(paramContext instanceof ContextWrapper)) {
        break;
      }
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    }
    return null;
  }
  
  Activity getActivity(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    Context localContext = paramView.getContext();
    if (localContext == null) {
      return null;
    }
    WeakReference localWeakReference = (WeakReference)this.mViewActivityMap.get(localContext);
    paramView = localWeakReference;
    if (localWeakReference == null)
    {
      paramView = new WeakReference(fromContext(localContext));
      this.mViewActivityMap.put(localContext, paramView);
    }
    return (Activity)paramView.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.ViewActivityMap
 * JD-Core Version:    0.7.0.1
 */