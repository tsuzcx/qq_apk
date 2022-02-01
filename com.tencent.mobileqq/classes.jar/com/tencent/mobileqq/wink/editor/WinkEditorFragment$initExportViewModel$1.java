package com.tencent.mobileqq.wink.editor;

import android.content.DialogInterface.OnDismissListener;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.wink.editor.export.WinkExportState;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.session.ICutSession;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/wink/editor/export/WinkExportState;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class WinkEditorFragment$initExportViewModel$1<T>
  implements Observer<WinkExportState>
{
  WinkEditorFragment$initExportViewModel$1(WinkEditorFragment paramWinkEditorFragment) {}
  
  public final void a(WinkExportState paramWinkExportState)
  {
    if ((paramWinkExportState != WinkExportState.f) && (paramWinkExportState != WinkExportState.e))
    {
      if (paramWinkExportState == WinkExportState.a)
      {
        paramWinkExportState = WinkEditorFragment.d(this.a);
        if (paramWinkExportState != null)
        {
          paramWinkExportState = paramWinkExportState.a();
          if (paramWinkExportState != null) {
            paramWinkExportState.b();
          }
        }
        this.a.a((CharSequence)HardCodeUtil.a(2131886351), true, 0L, (DialogInterface.OnDismissListener)WinkEditorFragment.initExportViewModel.1.1.a);
        return;
      }
      if (paramWinkExportState == WinkExportState.b)
      {
        this.a.o();
        return;
      }
      if (paramWinkExportState == WinkExportState.c)
      {
        this.a.o();
        return;
      }
      if (paramWinkExportState == WinkExportState.g) {
        this.a.a((CharSequence)HardCodeUtil.a(2131886350), true, 0L, (DialogInterface.OnDismissListener)WinkEditorFragment.initExportViewModel.1.2.a);
      }
    }
    else
    {
      paramWinkExportState = WinkEditorFragment.d(this.a);
      if (paramWinkExportState != null)
      {
        paramWinkExportState = paramWinkExportState.b();
        if (paramWinkExportState != null) {
          paramWinkExportState.g();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.initExportViewModel.1
 * JD-Core Version:    0.7.0.1
 */