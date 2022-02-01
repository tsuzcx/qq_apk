package com.tencent.videocut.render;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DiffUtil.Callback;
import androidx.recyclerview.widget.DiffUtil.DiffResult;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.tencent.logger.Logger;
import com.tencent.tavcut.operator.IClipSourceOperator;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.render.extension.MediaClipExtensionKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/MediaClipProcessor;", "Lcom/tencent/videocut/render/IRender;", "tavCutSession", "Lcom/tencent/tavcut/session/ICutSession;", "(Lcom/tencent/tavcut/session/ICutSession;)V", "oldList", "", "Lcom/tencent/videocut/model/MediaClip;", "handleChangedSources", "", "count", "", "position", "payload", "", "handleInsertSource", "newClips", "", "handleMovedSource", "fromPosition", "toPosition", "handleRemoveSource", "update", "mediaModel", "Lcom/tencent/videocut/model/MediaModel;", "Companion", "MediaClipsDiffCallBack", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MediaClipProcessor
  implements IRender
{
  public static final MediaClipProcessor.Companion a = new MediaClipProcessor.Companion(null);
  private List<MediaClip> b;
  private final ICutSession c;
  
  public MediaClipProcessor(@NotNull ICutSession paramICutSession)
  {
    this.c = paramICutSession;
    this.b = ((List)new ArrayList());
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    Object localObject = Logger.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMoved  fromPosition ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", toPosition ");
    localStringBuilder.append(paramInt2);
    ((Logger)localObject).b("MediaClipProcessor", localStringBuilder.toString());
    localObject = (MediaClip)this.b.remove(paramInt1);
    this.b.add(paramInt2, localObject);
    this.c.e().b(paramInt1, paramInt2);
  }
  
  private final void a(int paramInt1, int paramInt2, Object paramObject)
  {
    List localList = (List)new ArrayList();
    Object localObject2 = (Iterable)RangesKt.until(0, paramInt1);
    Object localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(Integer.valueOf(((IntIterator)localObject2).nextInt() + paramInt2));
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      int i = ((Number)((Iterator)localObject1).next()).intValue();
      localObject2 = (MediaClip)this.b.get(i);
      if (paramObject != null)
      {
        MediaClip localMediaClip = (MediaClip)paramObject;
        this.b.set(i, localMediaClip);
        Object localObject3 = MediaClipExtensionKt.c(localMediaClip);
        if (localObject3 != null) {
          localList.add(localObject3);
        }
        localObject3 = Logger.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onChanged  position ");
        localStringBuilder.append(i);
        localStringBuilder.append(", count ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" oldItem ");
        localStringBuilder.append(localObject2);
        localStringBuilder.append(", \n");
        localStringBuilder.append("newItem ");
        localStringBuilder.append(localMediaClip);
        ((Logger)localObject3).b("MediaClipProcessor", localStringBuilder.toString());
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.videocut.model.MediaClip");
      }
    }
    this.c.e().b(paramInt2, localList);
  }
  
  private final void a(int paramInt1, int paramInt2, List<MediaClip> paramList)
  {
    List localList = (List)new ArrayList();
    Object localObject2 = (Iterable)RangesKt.until(0, paramInt1);
    Object localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(Integer.valueOf(((IntIterator)localObject2).nextInt() + paramInt2));
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      int i = ((Number)((Iterator)localObject1).next()).intValue();
      localObject2 = (MediaClip)paramList.get(i);
      this.b.add(i, localObject2);
      Object localObject3 = MediaClipExtensionKt.c((MediaClip)localObject2);
      if (localObject3 != null) {
        localList.add(localObject3);
      }
      localObject3 = Logger.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInserted  position ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", count ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", newItem ");
      localStringBuilder.append(localObject2);
      ((Logger)localObject3).b("MediaClipProcessor", localStringBuilder.toString());
    }
    this.c.e().a(paramInt2, localList);
  }
  
  private final void a(List<MediaClip> paramList)
  {
    DiffUtil.DiffResult localDiffResult = DiffUtil.calculateDiff((DiffUtil.Callback)new MediaClipProcessor.MediaClipsDiffCallBack(this.b, paramList));
    Intrinsics.checkExpressionValueIsNotNull(localDiffResult, "DiffUtil.calculateDiff(M…lBack(oldList, newClips))");
    localDiffResult.dispatchUpdatesTo((ListUpdateCallback)new MediaClipProcessor.update.1(this, paramList));
  }
  
  private final void b(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      this.b.remove(paramInt1);
      i += 1;
    }
    this.c.e().a(paramInt1, paramInt2 + paramInt1);
  }
  
  public void b(@NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "mediaModel");
    a(paramMediaModel.videos);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.MediaClipProcessor
 * JD-Core Version:    0.7.0.1
 */