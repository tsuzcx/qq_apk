package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

public class TavProxyManager
{
  public static BaseTavApiProxy a(String paramString)
  {
    if ("TAVResource".equals(paramString)) {
      return new TavResourceProxy();
    }
    if ("TAVClip".equals(paramString)) {
      return new TavClipProxy();
    }
    if ("TAVVideoConfiguration".equals(paramString)) {
      return new TavVideoConfigurationProxy();
    }
    if ("TAVAudioConfiguration".equals(paramString)) {
      return new TavAudioConfigurationProxy();
    }
    if ("TAVMixerEffect".equals(paramString)) {
      return new TavMixerEffectProxy();
    }
    if ("TAVComposition".equals(paramString)) {
      return new TavCompositionProxy();
    }
    if ("TAVPlayer".equals(paramString)) {
      return new TavPlayerProxy();
    }
    if ("TAVSourceExportSession".equals(paramString)) {
      return new TavExporterProxy();
    }
    if ("TAVPAGFile".equals(paramString)) {
      return new PagFileProxy();
    }
    if ("TAVPAGMixerEffect".equals(paramString)) {
      return new PagMixerEffectProxy();
    }
    if ("TAVPAGFilterEffect".equals(paramString)) {
      return new PagFilterEffectProxy();
    }
    if ("TAVPAGOverlayEffect".equals(paramString)) {
      return new PagOverlayEffectProxy();
    }
    if ("TAVImageGenerator".equals(paramString)) {
      return new TavImageGeneratorProxy();
    }
    if ("TAVLutEffect".equals(paramString)) {
      return new TavLutEffectProxy();
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    if ((!"com.tencent.tavkit.composition.resource.TAVAssetTrackResource".equals(paramString)) && (!"com.tencent.tavkit.composition.resource.TAVImageTrackResource".equals(paramString)) && (!"com.tencent.tavkit.composition.resource.TAVEmptyResource".equals(paramString)))
    {
      if ("com.tencent.tavkit.composition.TAVClip".equals(paramString)) {
        return "TAVClip";
      }
      if ("com.tencent.tavkit.composition.model.TAVVideoConfiguration".equals(paramString)) {
        return "TAVVideoConfiguration";
      }
      if ("com.tencent.tavkit.composition.model.TAVAudioConfiguration".equals(paramString)) {
        return "TAVAudioConfiguration";
      }
      if ("com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.MixEffect".equals(paramString)) {
        return "TAVMixerEffect";
      }
      if ("com.tencent.tavkit.composition.TAVComposition".equals(paramString)) {
        return "TAVComposition";
      }
      if ("com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavPlayer".equals(paramString)) {
        return "TAVPlayer";
      }
      if ("com.tencent.tavkit.component.TAVSourceImageGenerator".equals(paramString)) {
        return "TAVImageGenerator";
      }
      if ("com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavExporter".equals(paramString)) {
        return "TAVSourceExportSession";
      }
      if ("com.tencent.tavsticker.model.TAVSticker".equals(paramString)) {
        return "TAVPAGFile";
      }
      if ("com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.PagMixerEffect".equals(paramString)) {
        return "TAVPAGMixerEffect";
      }
      if ("com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.PagFilterEffect".equals(paramString)) {
        return "TAVPAGFilterEffect";
      }
      if ("com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.PagOverlayEffect".equals(paramString)) {
        return "TAVPAGOverlayEffect";
      }
      if ("com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavMixerEffect".equals(paramString)) {
        return "TAVMixerEffect";
      }
      if ("com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavImageGenerator".equals(paramString)) {
        return "TAVImageGenerator";
      }
      if ("com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavLutEffect".equals(paramString)) {
        return "TAVLutEffect";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("no match class name ! classname = ");
      localStringBuilder.append(paramString);
      throw new RuntimeException(localStringBuilder.toString());
    }
    return "TAVResource";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavProxyManager
 * JD-Core Version:    0.7.0.1
 */