package dov.com.qq.im.aeeditor.module.edit.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"dov/com/qq/im/aeeditor/module/edit/widgets/AEEditorCheckGroupView$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AEEditorCheckGroupView$1
  implements ViewTreeObserver.OnPreDrawListener
{
  public boolean onPreDraw()
  {
    int j = this.a.getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject = this.a.getChildAt(i);
      if (localObject != null) {
        ((View)localObject).setOnClickListener((View.OnClickListener)new AEEditorCheckGroupView.1.onPreDraw.1(this, i));
      }
      i += 1;
    }
    Object localObject = this.a.getViewTreeObserver();
    if (localObject != null) {
      ((ViewTreeObserver)localObject).removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.widgets.AEEditorCheckGroupView.1
 * JD-Core Version:    0.7.0.1
 */