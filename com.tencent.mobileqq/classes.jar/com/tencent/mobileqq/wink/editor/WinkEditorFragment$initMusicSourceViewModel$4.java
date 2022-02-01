package com.tencent.mobileqq.wink.editor;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errMsgResId", "", "onChanged"}, k=3, mv={1, 1, 16})
final class WinkEditorFragment$initMusicSourceViewModel$4<T>
  implements Observer<Integer>
{
  WinkEditorFragment$initMusicSourceViewModel$4(WinkEditorFragment paramWinkEditorFragment) {}
  
  public final void a(int paramInt)
  {
    QQToast.makeText(this.a.getContext(), 1, (CharSequence)this.a.requireContext().getString(paramInt), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.initMusicSourceViewModel.4
 * JD-Core Version:    0.7.0.1
 */