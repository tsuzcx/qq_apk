package com.tencent.tavcut.render.cover;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.render.IRenderChainManager;
import com.tencent.tavcut.render.builder.IMediaBuilderListener;
import com.tencent.tavcut.render.builder.MediaBuilderOutput;
import com.tencent.tavcut.render.builder.light.LightMediaBuilder;
import com.tencent.tavcut.render.exception.CalledFromWrongThreadException;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.RenderScene;
import com.tencent.tavkit.component.TAVSourceImageGenerator;
import com.tencent.tavkit.composition.TAVComposition;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/cover/CoverProviderAccessor$CoverProvider;", "Lcom/tencent/tavcut/render/cover/ICoverProvider;", "templateDir", "", "renderModel", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "size", "Lcom/tencent/tavcut/composition/model/component/Size;", "(Ljava/lang/String;Lcom/tencent/tavcut/rendermodel/RenderModel;Lcom/tencent/tavcut/composition/model/component/Size;)V", "mediaBuilderOutput", "Lcom/tencent/tavcut/render/builder/MediaBuilderOutput;", "getRenderModel", "()Lcom/tencent/tavcut/rendermodel/RenderModel;", "getSize", "()Lcom/tencent/tavcut/composition/model/component/Size;", "tavSourceImageGenerator", "Lcom/tencent/tavkit/component/TAVSourceImageGenerator;", "getTemplateDir", "()Ljava/lang/String;", "buildRenderChainManager", "buildTavSourceImageGenerator", "tavComposition", "Lcom/tencent/tavkit/composition/TAVComposition;", "getCoverAtTime", "Landroid/graphics/Bitmap;", "atTimeMs", "", "getCoverAtTimeAsync", "", "callback", "Lkotlin/Function1;", "getCoverAtTimesAsync", "", "init", "release", "Companion", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
final class CoverProviderAccessor$CoverProvider
  implements ICoverProvider
{
  public static final CoverProviderAccessor.CoverProvider.Companion a = new CoverProviderAccessor.CoverProvider.Companion(null);
  private MediaBuilderOutput b;
  private TAVSourceImageGenerator c;
  @NotNull
  private final String d;
  @NotNull
  private final RenderModel e;
  @NotNull
  private final Size f;
  
  public CoverProviderAccessor$CoverProvider(@NotNull String paramString, @NotNull RenderModel paramRenderModel, @NotNull Size paramSize)
  {
    this.d = paramString;
    this.e = paramRenderModel;
    this.f = paramSize;
  }
  
  private final TAVSourceImageGenerator a(TAVComposition paramTAVComposition, Size paramSize)
  {
    Integer localInteger = paramSize.width;
    float f2 = 0.0F;
    float f1;
    if (localInteger != null) {
      f1 = localInteger.intValue();
    } else {
      f1 = 0.0F;
    }
    paramSize = paramSize.height;
    if (paramSize != null) {
      f2 = paramSize.intValue();
    }
    paramTAVComposition = new TAVSourceImageGenerator(paramTAVComposition, new CGSize(f1, f2));
    paramTAVComposition.getAssetImageGenerator().setForceUseFbo(true);
    return paramTAVComposition;
  }
  
  private final void b()
  {
    Object localObject1 = Thread.currentThread();
    Object localObject2 = Looper.getMainLooper();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "Looper.getMainLooper()");
    if (!Intrinsics.areEqual(localObject1, ((Looper)localObject2).getThread()))
    {
      localObject1 = this.b;
      if (localObject1 != null) {
        return;
      }
      if (localObject1 == null) {
        localObject1 = c();
      }
      this.b = ((MediaBuilderOutput)localObject1);
      localObject2 = this.b;
      if (localObject2 != null)
      {
        localObject1 = this.c;
        if (localObject1 == null) {
          localObject1 = a(((MediaBuilderOutput)localObject2).c(), this.f);
        }
        this.c = ((TAVSourceImageGenerator)localObject1);
      }
      return;
    }
    throw ((Throwable)new CalledFromWrongThreadException("Only work tread can access cover"));
  }
  
  private final MediaBuilderOutput c()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = ((MediaBuilderOutput)null);
    LightMediaBuilder.a.a(this.d, RenderModel.copy$default(this.e, RenderScene.COVER, null, null, null, null, false, 0, null, null, null, 0L, 0, null, 8190, null), (IMediaBuilderListener)new CoverProviderAccessor.CoverProvider.buildRenderChainManager.1(localObjectRef, localCountDownLatch));
    localCountDownLatch.await(1000L, TimeUnit.MILLISECONDS);
    return (MediaBuilderOutput)localObjectRef.element;
  }
  
  @Nullable
  public Bitmap a(long paramLong)
  {
    b();
    TAVSourceImageGenerator localTAVSourceImageGenerator = this.c;
    if (localTAVSourceImageGenerator != null) {
      return localTAVSourceImageGenerator.generateThumbnailAtTimeSync(CMTime.fromMs(paramLong));
    }
    return null;
  }
  
  public void a()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((MediaBuilderOutput)localObject).a();
      if (localObject != null) {
        ((IRenderChainManager)localObject).a();
      }
    }
    localObject = this.c;
    if (localObject != null)
    {
      localObject = ((TAVSourceImageGenerator)localObject).getAssetImageGenerator();
      if (localObject != null) {
        ((AssetImageGenerator)localObject).release();
      }
    }
    this.b = ((MediaBuilderOutput)null);
    this.c = ((TAVSourceImageGenerator)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.cover.CoverProviderAccessor.CoverProvider
 * JD-Core Version:    0.7.0.1
 */