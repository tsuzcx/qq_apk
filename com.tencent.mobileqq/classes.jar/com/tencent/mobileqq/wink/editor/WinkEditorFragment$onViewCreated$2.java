package com.tencent.mobileqq.wink.editor;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class WinkEditorFragment$onViewCreated$2
  implements View.OnClickListener
{
  WinkEditorFragment$onViewCreated$2(WinkEditorFragment paramWinkEditorFragment) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = WinkEditorFragment.d(this.a);
    if ((localObject != null) && (((WinkTavCutDelegate)localObject).k() == true))
    {
      this.a.u();
    }
    else
    {
      WinkEditorFragment.c(this.a).a(this.a.getContext());
      localObject = this.a.getActivity();
      if (localObject != null) {
        ((FragmentActivity)localObject).finish();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.onViewCreated.2
 * JD-Core Version:    0.7.0.1
 */