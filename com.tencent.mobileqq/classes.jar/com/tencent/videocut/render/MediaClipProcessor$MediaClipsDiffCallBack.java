package com.tencent.videocut.render;

import androidx.recyclerview.widget.DiffUtil.Callback;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/MediaClipProcessor$MediaClipsDiffCallBack;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldClips", "", "Lcom/tencent/videocut/model/MediaClip;", "newClips", "(Ljava/util/List;Ljava/util/List;)V", "getNewClips", "()Ljava/util/List;", "getOldClips", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getChangePayload", "", "getNewListSize", "getOldListSize", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
final class MediaClipProcessor$MediaClipsDiffCallBack
  extends DiffUtil.Callback
{
  @NotNull
  private final List<MediaClip> a;
  @NotNull
  private final List<MediaClip> b;
  
  public MediaClipProcessor$MediaClipsDiffCallBack(@NotNull List<MediaClip> paramList1, @NotNull List<MediaClip> paramList2)
  {
    this.a = paramList1;
    this.b = paramList2;
  }
  
  public boolean areContentsTheSame(int paramInt1, int paramInt2)
  {
    return Intrinsics.areEqual(((MediaClip)this.a.get(paramInt1)).resource, ((MediaClip)this.b.get(paramInt2)).resource);
  }
  
  public boolean areItemsTheSame(int paramInt1, int paramInt2)
  {
    Object localObject = ((MediaClip)this.a.get(paramInt1)).resource;
    String str = null;
    if (localObject != null) {
      localObject = ((ResourceModel)localObject).id;
    } else {
      localObject = null;
    }
    ResourceModel localResourceModel = ((MediaClip)this.b.get(paramInt2)).resource;
    if (localResourceModel != null) {
      str = localResourceModel.id;
    }
    return Intrinsics.areEqual(localObject, str);
  }
  
  @Nullable
  public Object getChangePayload(int paramInt1, int paramInt2)
  {
    return this.b.get(paramInt2);
  }
  
  public int getNewListSize()
  {
    return this.b.size();
  }
  
  public int getOldListSize()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.MediaClipProcessor.MediaClipsDiffCallBack
 * JD-Core Version:    0.7.0.1
 */