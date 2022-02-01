package com.tencent.xaction.view;

import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorView;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.style.Style;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/xaction/view/XATextView$decor$1", "Lcom/tencent/xaction/api/base/DecorView;", "bindData", "", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class XATextView$decor$1
  extends DecorView
{
  XATextView$decor$1(IView paramIView)
  {
    super(localIView);
  }
  
  public void a()
  {
    super.a();
    Object localObject = getStyle();
    if (localObject != null)
    {
      localObject = ((ViewData)localObject).getExts();
      if (localObject == null) {}
    }
    for (localObject = ((HashMap)localObject).get("text");; localObject = null)
    {
      if (localObject != null) {
        this.a.setText((CharSequence)localObject);
      }
      localObject = getStyle();
      if (localObject != null)
      {
        localObject = ((ViewData)localObject).getSt();
        if (localObject != null)
        {
          this.a.setTextSize(0, ((Style)localObject).getFs());
          XATextView.a(this.a, (Style)localObject);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.view.XATextView.decor.1
 * JD-Core Version:    0.7.0.1
 */