package com.tencent.videocut.render;

import androidx.recyclerview.widget.ListUpdateCallback;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/render/MediaClipProcessor$update$1", "Landroidx/recyclerview/widget/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MediaClipProcessor$update$1
  implements ListUpdateCallback
{
  MediaClipProcessor$update$1(List paramList) {}
  
  public void onChanged(int paramInt1, int paramInt2, @Nullable Object paramObject)
  {
    MediaClipProcessor.a(this.a, paramInt2, paramInt1, paramObject);
  }
  
  public void onInserted(int paramInt1, int paramInt2)
  {
    MediaClipProcessor.a(this.a, paramInt2, paramInt1, this.b);
  }
  
  public void onMoved(int paramInt1, int paramInt2)
  {
    MediaClipProcessor.b(this.a, paramInt1, paramInt2);
  }
  
  public void onRemoved(int paramInt1, int paramInt2)
  {
    MediaClipProcessor.a(this.a, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.MediaClipProcessor.update.1
 * JD-Core Version:    0.7.0.1
 */