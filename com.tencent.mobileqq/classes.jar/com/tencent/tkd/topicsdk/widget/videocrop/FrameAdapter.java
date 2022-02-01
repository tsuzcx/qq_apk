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
  public static final FrameAdapter.Companion a;
  private final FrameAdapter.DataSetChangeListener jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameAdapter$DataSetChangeListener;
  private final ConcurrentHashMap<Integer, FramesProcessor.Frame> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameAdapter$Companion = new FrameAdapter.Companion(null);
  }
  
  public FrameAdapter(@Nullable FrameAdapter.DataSetChangeListener paramDataSetChangeListener)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameAdapter$DataSetChangeListener = paramDataSetChangeListener;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  @Nullable
  public final FramesProcessor.Frame a(int paramInt)
  {
    return (FramesProcessor.Frame)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public final void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
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
  
  public final void a(@NotNull FramesProcessor.Frame paramFrame)
  {
    Intrinsics.checkParameterIsNotNull(paramFrame, "frame");
    TLog.b("FrameAdapter", "addFrame, index=" + paramFrame.a());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(paramFrame.a()), paramFrame);
    paramFrame = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameAdapter$DataSetChangeListener;
    if (paramFrame != null) {
      paramFrame.a();
    }
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0;
  }
  
  public final boolean a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.FrameAdapter
 * JD-Core Version:    0.7.0.1
 */