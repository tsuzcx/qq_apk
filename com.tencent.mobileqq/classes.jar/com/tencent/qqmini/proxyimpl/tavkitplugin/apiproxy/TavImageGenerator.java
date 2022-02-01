package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;

public class TavImageGenerator
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  @NonNull
  private final TavImageGenerator.ImageGeneratorThread jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavImageGenerator$ImageGeneratorThread;
  protected Asset a;
  private VideoComposition jdField_a_of_type_ComTencentTavCoreCompositionVideoComposition;
  @Nullable
  private CGSize jdField_a_of_type_ComTencentTavCoremediaCGSize;
  private RenderContext jdField_a_of_type_ComTencentTavDecoderRenderContext;
  @Nullable
  private RenderContextParams jdField_a_of_type_ComTencentTavDecoderRenderContextParams;
  private final String jdField_a_of_type_JavaLangString;
  
  public TavImageGenerator(TAVComposition paramTAVComposition, CGSize paramCGSize)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TavImageGenerator@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_Int = -1;
    paramTAVComposition = new TAVCompositionBuilder(paramTAVComposition).buildSource();
    this.jdField_a_of_type_ComTencentTavAssetAsset = paramTAVComposition.getAsset();
    this.jdField_a_of_type_ComTencentTavCoreCompositionVideoComposition = paramTAVComposition.getVideoComposition();
    this.jdField_a_of_type_ComTencentTavCoremediaCGSize = paramCGSize;
    this.jdField_a_of_type_Int = 101;
    this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavImageGenerator$ImageGeneratorThread = new TavImageGenerator.ImageGeneratorThread(this, "image_generator");
    this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavImageGenerator$ImageGeneratorThread.start();
    this.jdField_a_of_type_AndroidOsHandler = TavImageGenerator.ImageGeneratorThread.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavImageGenerator$ImageGeneratorThread);
  }
  
  void a(CMTime paramCMTime, TavImageGenerator.ImageGeneratorListener paramImageGeneratorListener)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = new TavImageGenerator.CoverMsg(this, paramCMTime, paramImageGeneratorListener);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavImageGenerator
 * JD-Core Version:    0.7.0.1
 */