package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qqmini.proxyimpl.tavkitplugin.ITAVReleaseAble;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;

public class TavImageGenerator
  implements ITAVReleaseAble
{
  protected Asset a;
  private final String b;
  @Nullable
  private CGSize c;
  private int d;
  private VideoComposition e;
  @NonNull
  private final TavImageGenerator.ImageGeneratorThread f;
  private RenderContext g;
  @Nullable
  private RenderContextParams h;
  private Handler i;
  
  public TavImageGenerator(TAVComposition paramTAVComposition, CGSize paramCGSize)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TavImageGenerator@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.b = localStringBuilder.toString();
    this.d = -1;
    paramTAVComposition = new TAVCompositionBuilder(paramTAVComposition).buildSource();
    this.a = paramTAVComposition.getAsset();
    this.e = paramTAVComposition.getVideoComposition();
    this.c = paramCGSize;
    this.d = 101;
    this.f = new TavImageGenerator.ImageGeneratorThread(this, "image_generator");
    this.f.start();
    this.i = TavImageGenerator.ImageGeneratorThread.a(this.f);
  }
  
  public void a()
  {
    Logger.d(this.b, "release() called");
    a(false);
  }
  
  void a(CMTime paramCMTime, TavImageGenerator.ImageGeneratorListener paramImageGeneratorListener)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = new TavImageGenerator.CoverMsg(this, paramCMTime, paramImageGeneratorListener);
    this.i.sendMessage(localMessage);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = null;
    TavImageGenerator.ImageGeneratorThread.a(this.f, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavImageGenerator
 * JD-Core Version:    0.7.0.1
 */