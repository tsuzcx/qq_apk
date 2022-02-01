package com.tencent.tkd.topicsdk.widget.videocrop;

import android.graphics.Bitmap;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameAdapter;", "", "mListener", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameAdapter$DataSetChangeListener;", "(Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameAdapter$DataSetChangeListener;)V", "count", "", "getCount", "()I", "frames", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FramesProcessor$Frame;", "isEmpty", "", "()Z", "addFrame", "", "frame", "destroy", "getFrame", "index", "isExist", "Companion", "DataSetChangeListener", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class FrameAdapter
{
  public static final FrameAdapter.Companion a = new FrameAdapter.Companion(null);
  private final ConcurrentHashMap<Integer, FramesProcessor.Frame> b;
  private final FrameAdapter.DataSetChangeListener c;
  
  public FrameAdapter(@Nullable FrameAdapter.DataSetChangeListener paramDataSetChangeListener)
  {
    this.c = paramDataSetChangeListener;
    this.b = new ConcurrentHashMap();
  }
  
  @Nullable
  public final FramesProcessor.Frame a(int paramInt)
  {
    return (FramesProcessor.Frame)this.b.get(Integer.valueOf(paramInt));
  }
  
  public final void a(@NotNull FramesProcessor.Frame paramFrame)
  {
    Intrinsics.checkParameterIsNotNull(paramFrame, "frame");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addFrame, index=");
    localStringBuilder.append(paramFrame.b());
    TLog.b("FrameAdapter", localStringBuilder.toString());
    this.b.putIfAbsent(Integer.valueOf(paramFrame.b()), paramFrame);
    paramFrame = this.c;
    if (paramFrame != null) {
      paramFrame.a();
    }
  }
  
  public final boolean a()
  {
    return this.b.size() == 0;
  }
  
  public final void b()
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      FramesProcessor.Frame localFrame = (FramesProcessor.Frame)localIterator.next();
      if (localFrame != null)
      {
        Bitmap localBitmap = localFrame.a();
        if (localBitmap != null) {
          localBitmap.recycle();
        }
      }
      if (localFrame != null) {
        localFrame.a((Bitmap)null);
      }
    }
  }
  
  public final boolean b(int paramInt)
  {
    return this.b.containsKey(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.FrameAdapter
 * JD-Core Version:    0.7.0.1
 */