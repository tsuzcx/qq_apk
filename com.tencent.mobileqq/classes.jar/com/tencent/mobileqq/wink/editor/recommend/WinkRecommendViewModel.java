package com.tencent.mobileqq.wink.editor.recommend;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavcut.TavCut;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.composition.model.component.Size.Builder;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.render.thumb.IThumbProvider;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.render.extension.MediaClipExtensionKt;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/recommend/WinkRecommendViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "()V", "EXTRACT_BITMAP_COMPRESS_QUALITY", "", "EXTRACT_BITMAP_INTERVAL_THRESHOLD", "EXTRACT_BITMAP_MAX_COUNT", "EXTRACT_BITMAP_MAX_HEIGHT", "EXTRACT_BITMAP_MAX_WIDTH", "EXTRACT_BITMAP_PIC_MAX_BYTE", "_extractBitmapsLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "", "extractBitmapsLiveData", "Landroidx/lifecycle/LiveData;", "getExtractBitmapsLiveData", "()Landroidx/lifecycle/LiveData;", "calculateExtractTimestamp", "", "multiCutVideoDurationInMs", "extractBitmapsForImage", "Ljava/util/ArrayList;", "mediaModel", "Lcom/tencent/videocut/model/MediaModel;", "extractBitmapsForVideo", "totalDurationUs", "extractVideoCover", "", "mediaModels", "isAllImage", "", "getLogTag", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class WinkRecommendViewModel
  extends BaseViewModel
{
  private final int a = 1000;
  private final int b = 100;
  private final int c = 100;
  private final int d = 80;
  private final int e = 90000;
  private final int f = 3;
  private final MutableLiveData<List<byte[]>> g = new MutableLiveData();
  
  private final ArrayList<byte[]> a(MediaModel paramMediaModel)
  {
    ArrayList localArrayList = new ArrayList();
    Size.Builder localBuilder = new Size(null, null, null, 7, null).newBuilder();
    localBuilder.height = Integer.valueOf(this.b);
    localBuilder.width = Integer.valueOf(this.c);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramMediaModel = MediaClipExtensionKt.a(paramMediaModel.videos).iterator();
    for (long l1 = 0L; paramMediaModel.hasNext(); l1 = l2)
    {
      for (;;)
      {
        Object localObject = (ClipSource)paramMediaModel.next();
        long l2 = l1;
        try
        {
          localObject = TavCut.a.a((ClipSource)localObject, localBuilder.build()).a(0L);
          if (localObject == null) {
            break;
          }
          l2 = l1;
          ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, this.d, (OutputStream)localByteArrayOutputStream);
          l2 = l1;
          byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
          l2 = l1;
          l1 += arrayOfByte.length;
          l2 = l1;
          if (l1 >= this.e) {
            return localArrayList;
          }
          l2 = l1;
          localArrayList.add(arrayOfByte);
          l2 = l1;
          ((Bitmap)localObject).recycle();
          l2 = l1;
          localByteArrayOutputStream.reset();
        }
        catch (Throwable localThrowable)
        {
          label211:
          break label211;
        }
      }
      localByteArrayOutputStream.reset();
    }
    return localArrayList;
  }
  
  private final ArrayList<byte[]> a(MediaModel paramMediaModel, long paramLong)
  {
    List localList = a(paramLong / 1000);
    Size.Builder localBuilder = new Size(null, null, null, 7, null).newBuilder();
    localBuilder.height = Integer.valueOf(this.b);
    localBuilder.width = Integer.valueOf(this.c);
    ArrayList localArrayList = new ArrayList();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramMediaModel = MediaClipExtensionKt.a(paramMediaModel.videos).iterator();
    int i = 0;
    paramLong = 0L;
    while (paramMediaModel.hasNext())
    {
      ClipSource localClipSource = (ClipSource)paramMediaModel.next();
      Iterator localIterator = localList.iterator();
      label258:
      label263:
      while (localIterator.hasNext())
      {
        long l = ((Number)localIterator.next()).longValue() - i;
        if (l >= 0L) {}
        try
        {
          localBitmap = TavCut.a.a(localClipSource, localBuilder.build()).a(l);
          if (localBitmap != null)
          {
            localBitmap.compress(Bitmap.CompressFormat.JPEG, this.d, (OutputStream)localByteArrayOutputStream);
            arrayOfByte = localByteArrayOutputStream.toByteArray();
            int j = arrayOfByte.length;
            paramLong += j;
          }
        }
        catch (Throwable localThrowable1)
        {
          Bitmap localBitmap;
          byte[] arrayOfByte;
          break label258;
        }
        try
        {
          if (paramLong >= this.e) {
            break;
          }
          localArrayList.add(arrayOfByte);
          localBitmap.recycle();
          localByteArrayOutputStream.reset();
        }
        catch (Throwable localThrowable2)
        {
          break label258;
        }
        break label263;
        localByteArrayOutputStream.reset();
      }
      i += (int)localClipSource.duration;
    }
    return localArrayList;
  }
  
  private final List<Long> a(long paramLong)
  {
    List localList = (List)new LinkedList();
    long l2 = 60000;
    long l1 = paramLong;
    if (paramLong > l2) {
      l1 = l2;
    }
    long l3 = this.f;
    l2 = l1 / l3;
    int i = this.a;
    paramLong = l2;
    if (l2 > i) {
      paramLong = (l1 - i) / l3;
    }
    l2 = 0L;
    i = 0;
    while ((i < l3) && (l2 < l1))
    {
      l2 += paramLong;
      localList.add(Long.valueOf(1000 * l2));
      i += 1;
    }
    return localList;
  }
  
  @NotNull
  public String a()
  {
    return "WinkRecommendViewModel";
  }
  
  public final void a(@NotNull List<MediaModel> paramList, boolean paramBoolean, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "mediaModels");
    ThreadManager.executeOnFileThread((Runnable)new WinkRecommendViewModel.extractVideoCover.1(this, paramBoolean, paramList, paramLong));
  }
  
  @NotNull
  public final LiveData<List<byte[]>> b()
  {
    return (LiveData)this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.recommend.WinkRecommendViewModel
 * JD-Core Version:    0.7.0.1
 */