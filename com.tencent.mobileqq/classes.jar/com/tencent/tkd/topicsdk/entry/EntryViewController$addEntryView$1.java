package com.tencent.tkd.topicsdk.entry;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.debug.DebugHelper;
import com.tencent.tkd.topicsdk.framework.StorageManager;
import com.tencent.tkd.topicsdk.interfaces.IFloatViewManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class EntryViewController$addEntryView$1
  extends Lambda
  implements Function0<Unit>
{
  EntryViewController$addEntryView$1(EntryViewController paramEntryViewController, int paramInt1, int paramInt2, EntryView paramEntryView, boolean paramBoolean1, boolean paramBoolean2, Function1 paramFunction1, String paramString)
  {
    super(0);
  }
  
  public final void invoke()
  {
    boolean bool2 = true;
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).bottomMargin = this.$bottomMargin;
    ((FrameLayout.LayoutParams)localObject).rightMargin = (this.$rightMargin - DisplayUtils.a.a(EntryViewController.a(this.this$0), 8.0F));
    ((FrameLayout.LayoutParams)localObject).gravity = 8388693;
    EntryView localEntryView = this.$entryView;
    localEntryView.setVisibility(0);
    boolean bool1;
    if (DebugHelper.a.a()) {
      if (!StorageManager.a.a("closeCreateTopicEntry", false))
      {
        bool1 = true;
        localEntryView.setNeedShowCreateTopicEntry(bool1);
        if (!DebugHelper.a.a()) {
          break label182;
        }
        if (StorageManager.a.a("closePublishEntryView", false)) {
          break label177;
        }
        bool1 = bool2;
      }
    }
    for (;;)
    {
      localEntryView.setNeedShowPublishArticleEntry(bool1);
      EntryViewController.a(this.this$0).a((View)localEntryView, (FrameLayout.LayoutParams)localObject);
      localObject = this.$callback;
      if (localObject != null) {
        localObject = (Unit)((Function1)localObject).invoke(this.$viewId);
      }
      return;
      bool1 = false;
      break;
      bool1 = this.$needShowCreateTopicEntry;
      break;
      label177:
      bool1 = false;
      continue;
      label182:
      bool1 = this.$needShowPublishArticleEntry;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.EntryViewController.addEntryView.1
 * JD-Core Version:    0.7.0.1
 */