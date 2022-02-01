package com.tencent.tavcut.render.thumb;

import android.graphics.Bitmap;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.core.AssetImageGenerator.ApertureMode;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.model.ClipSource.ClipType;
import com.tencent.tavcut.render.util.CMTimeUtil;
import com.tencent.tavcut.utils.BitmapUtil;
import com.tencent.tavcut.utils.TavAssetCreatorKt;
import com.tencent.tavkit.component.TAVSourceImageGenerator;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/thumb/ThumbProviderAccessor$ThumbProvider;", "Lcom/tencent/tavcut/render/thumb/IThumbProvider;", "clipSource", "Lcom/tencent/tavcut/model/ClipSource;", "size", "Lcom/tencent/tavcut/composition/model/component/Size;", "(Lcom/tencent/tavcut/model/ClipSource;Lcom/tencent/tavcut/composition/model/component/Size;)V", "getClipSource", "()Lcom/tencent/tavcut/model/ClipSource;", "imageThumb", "Landroid/graphics/Bitmap;", "getSize", "()Lcom/tencent/tavcut/composition/model/component/Size;", "tavSourceImageGenerator", "Lcom/tencent/tavkit/component/TAVSourceImageGenerator;", "getThumbAtTime", "atTimeUs", "", "getThumbAtTimeAsync", "", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "bitmap", "actualTime", "getThumbAtTimesAsync", "", "init", "release", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
final class ThumbProviderAccessor$ThumbProvider
  implements IThumbProvider
{
  private TAVSourceImageGenerator a;
  private Bitmap b;
  @NotNull
  private final ClipSource c;
  @NotNull
  private final com.tencent.tavcut.composition.model.component.Size d;
  
  public ThumbProviderAccessor$ThumbProvider(@NotNull ClipSource paramClipSource, @NotNull com.tencent.tavcut.composition.model.component.Size paramSize)
  {
    this.c = paramClipSource;
    this.d = paramSize;
  }
  
  private final void b()
  {
    Object localObject1 = this.c.path;
    if (localObject1 != null)
    {
      Object localObject2 = this.c.type;
      Object localObject3 = ClipSource.ClipType.VIDEO;
      int j = 0;
      if (localObject2 == localObject3)
      {
        if (this.a != null) {
          return;
        }
        localObject1 = this.c.path;
        if (localObject1 == null) {
          localObject1 = "";
        }
        localObject1 = TavAssetCreatorKt.a((String)localObject1);
        if (localObject1 != null)
        {
          localObject1 = new TAVAssetTrackResource((Asset)localObject1);
          localObject2 = CMTimeUtil.a;
          localObject3 = this.c.startOffset;
          long l;
          if (localObject3 != null) {
            l = ((Long)localObject3).longValue();
          } else {
            l = 0L;
          }
          ((TAVAssetTrackResource)localObject1).setSourceTimeRange(CMTimeUtil.a((CMTimeUtil)localObject2, l, this.c.duration, 0, 4, null));
          localObject2 = CMTimeUtil.a;
          float f2 = (float)this.c.duration;
          localObject3 = this.c.speed;
          float f1;
          if (localObject3 != null) {
            f1 = ((Float)localObject3).floatValue();
          } else {
            f1 = 1.0F;
          }
          ((TAVAssetTrackResource)localObject1).setScaledDuration(CMTimeUtil.a((CMTimeUtil)localObject2, MathKt.roundToLong(f2 / f1), 0, 2, null));
          localObject1 = new TAVClip((TAVResource)localObject1);
          localObject2 = new TAVComposition();
          ((TAVComposition)localObject2).addVideoChannel((List)CollectionsKt.arrayListOf(new TAVClip[] { localObject1 }));
          localObject1 = new TAVCompositionBuilder((TAVComposition)localObject2).buildSource();
          localObject2 = this.d.width;
          f2 = 0.0F;
          if (localObject2 != null) {
            f1 = ((Integer)localObject2).intValue();
          } else {
            f1 = 0.0F;
          }
          localObject2 = this.d.height;
          if (localObject2 != null) {
            f2 = ((Integer)localObject2).intValue();
          }
          this.a = new TAVSourceImageGenerator((TAVSource)localObject1, new CGSize(f1, f2));
          localObject1 = this.a;
          if (localObject1 != null)
          {
            localObject1 = ((TAVSourceImageGenerator)localObject1).getAssetImageGenerator();
            if (localObject1 != null) {
              ((AssetImageGenerator)localObject1).setApertureMode(AssetImageGenerator.ApertureMode.aspectFill);
            }
          }
          localObject1 = this.a;
          if (localObject1 == null) {
            return;
          }
          localObject1 = ((TAVSourceImageGenerator)localObject1).getAssetImageGenerator();
          if (localObject1 == null) {
            return;
          }
          ((AssetImageGenerator)localObject1).setForceUseFbo(true);
        }
      }
      else
      {
        localObject2 = this.b;
        if ((localObject2 == null) || ((localObject2 != null) && (((Bitmap)localObject2).isRecycled() == true)))
        {
          localObject2 = BitmapUtil.a;
          localObject3 = this.d.width;
          int i;
          if (localObject3 != null) {
            i = ((Integer)localObject3).intValue();
          } else {
            i = 0;
          }
          localObject3 = this.d.height;
          if (localObject3 != null) {
            j = ((Integer)localObject3).intValue();
          }
          this.b = ((BitmapUtil)localObject2).a((String)localObject1, new android.util.Size(i, j));
        }
      }
    }
  }
  
  @Nullable
  public Bitmap a(long paramLong)
  {
    b();
    if (this.c.type == ClipSource.ClipType.VIDEO)
    {
      TAVSourceImageGenerator localTAVSourceImageGenerator = this.a;
      if (localTAVSourceImageGenerator != null) {
        return localTAVSourceImageGenerator.generateThumbnailAtTimeSync(CMTimeUtil.a(CMTimeUtil.a, paramLong, 0, 2, null));
      }
      return null;
    }
    return this.b;
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((TAVSourceImageGenerator)localObject).getAssetImageGenerator();
      if (localObject != null) {
        ((AssetImageGenerator)localObject).release();
      }
    }
    this.a = ((TAVSourceImageGenerator)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.thumb.ThumbProviderAccessor.ThumbProvider
 * JD-Core Version:    0.7.0.1
 */