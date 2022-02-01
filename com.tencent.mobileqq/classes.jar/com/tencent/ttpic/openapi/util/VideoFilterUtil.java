package com.tencent.ttpic.openapi.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.GLCapabilities;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.camerasdk.avreport.AEKitBean;
import com.tencent.camerasdk.avreport.AEKitReportEvent;
import com.tencent.camerasdk.avreport.AVReportCenter;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.ttpic.GPUImageLookupFilter;
import com.tencent.ttpic.ar.filter.ARParticleFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.face.FaceRangeStatus;
import com.tencent.ttpic.face.FaceStatusChecker;
import com.tencent.ttpic.factory.FabbyFilterFactory;
import com.tencent.ttpic.filament.FilamentFilter;
import com.tencent.ttpic.filament.FilamentParticleFilter;
import com.tencent.ttpic.filter.ActFilters;
import com.tencent.ttpic.filter.AllVideoFilters;
import com.tencent.ttpic.filter.CrazyFaceFilters;
import com.tencent.ttpic.filter.CustomVertexFilter;
import com.tencent.ttpic.filter.CustomVideoFilter;
import com.tencent.ttpic.filter.DoodleFilter;
import com.tencent.ttpic.filter.EffectTriggerFilter;
import com.tencent.ttpic.filter.FabbyFilters;
import com.tencent.ttpic.filter.FabbyMvFilter;
import com.tencent.ttpic.filter.FaceCopyFilter;
import com.tencent.ttpic.filter.FaceCropFilter;
import com.tencent.ttpic.filter.FaceMoveFilter;
import com.tencent.ttpic.filter.FaceOffByImageFilter;
import com.tencent.ttpic.filter.FaceOffFilter;
import com.tencent.ttpic.filter.FacialFeatureFilter;
import com.tencent.ttpic.filter.FastStickerFilter;
import com.tencent.ttpic.filter.FrozenFrameFilter;
import com.tencent.ttpic.filter.HairCos;
import com.tencent.ttpic.filter.HeadCropFilter;
import com.tencent.ttpic.filter.LutItemsFilter;
import com.tencent.ttpic.filter.MultiViewerFilter;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.filter.ParticleXFilter;
import com.tencent.ttpic.filter.PhantomFilter;
import com.tencent.ttpic.filter.SimpleEffectVideoFilter;
import com.tencent.ttpic.filter.SkyboxItemsFilter;
import com.tencent.ttpic.filter.SnakeFaceFilter;
import com.tencent.ttpic.filter.StaticCountFilter;
import com.tencent.ttpic.filter.SwitchFaceFilter;
import com.tencent.ttpic.filter.ThreeDimFilter;
import com.tencent.ttpic.filter.VideoFilterInputFreeze;
import com.tencent.ttpic.filter.VoiceTextFilter;
import com.tencent.ttpic.filter.blurmaskfilter.BlurMaskFilter;
import com.tencent.ttpic.model.Audio2Text;
import com.tencent.ttpic.model.FaceBeautyItem;
import com.tencent.ttpic.model.FaceFeatureItem;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.GridSettingModel;
import com.tencent.ttpic.model.MultiViewerItem;
import com.tencent.ttpic.model.VideoFilterEffect;
import com.tencent.ttpic.offlineset.beans.StyleFilterSettingJsonBean;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.filter.BeautyParam;
import com.tencent.ttpic.openapi.filter.BeautyParam.MeshType;
import com.tencent.ttpic.openapi.filter.BeautyTransformList;
import com.tencent.ttpic.openapi.filter.BuckleFaceFilter;
import com.tencent.ttpic.openapi.filter.ComicEffectFilter;
import com.tencent.ttpic.openapi.filter.CosFunFilterGroup;
import com.tencent.ttpic.openapi.filter.CustomFilterItem;
import com.tencent.ttpic.openapi.filter.CyberpunkFilter;
import com.tencent.ttpic.openapi.filter.FabbyMvPart;
import com.tencent.ttpic.openapi.filter.FabbyParts;
import com.tencent.ttpic.openapi.filter.FaceOff3DFilter;
import com.tencent.ttpic.openapi.filter.MaskStickerFilter.BrushMaskFilter;
import com.tencent.ttpic.openapi.filter.MaskStickerFilter.DynamicMaskFilter;
import com.tencent.ttpic.openapi.filter.MaskStickerFilter.StaticMaskFilter;
import com.tencent.ttpic.openapi.filter.RapidNetFilter;
import com.tencent.ttpic.openapi.filter.RemodelFilter;
import com.tencent.ttpic.openapi.filter.RenderItem;
import com.tencent.ttpic.openapi.filter.StaticStickerFilter;
import com.tencent.ttpic.openapi.filter.StyleChildFilter;
import com.tencent.ttpic.openapi.filter.TransformFilter;
import com.tencent.ttpic.openapi.filter.VideoFilterList;
import com.tencent.ttpic.openapi.filter.VideoFilterListExtension;
import com.tencent.ttpic.openapi.filter.VideoFilterListExtension.CreateExternalFiltersListener;
import com.tencent.ttpic.openapi.filter.stylizefilter.IStlylizeFilterIniter;
import com.tencent.ttpic.openapi.filter.stylizefilter.TTMoonaPencilFilter;
import com.tencent.ttpic.openapi.filter.stylizefilter.TTPencilFilterGroup;
import com.tencent.ttpic.openapi.filter.stylizefilter.TTSelfInnovSketchFilter;
import com.tencent.ttpic.openapi.filter.stylizefilter.TTWeseeSketchFilter;
import com.tencent.ttpic.openapi.filter.stylizefilter.cartoonfilter.TTCartoonFilterGroup;
import com.tencent.ttpic.openapi.filter.stylizefilter.customFilter.StyleCustomFilterGroup;
import com.tencent.ttpic.openapi.filter.stylizefilter.toonFilter.TTToonFilterGroup;
import com.tencent.ttpic.openapi.filter.zoomfilter.ZoomFilter;
import com.tencent.ttpic.openapi.initializer.Ace3DEngineInitializer;
import com.tencent.ttpic.openapi.initializer.GpuParticleInitializer;
import com.tencent.ttpic.openapi.initializer.TNNGenderSwitchInitializer;
import com.tencent.ttpic.openapi.initializer.TNNStyleChildInitializer;
import com.tencent.ttpic.openapi.manager.FaceOffFilterManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.manager.TriggerStateManager;
import com.tencent.ttpic.openapi.model.AnimationItem;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.model.FaceStyleItem;
import com.tencent.ttpic.openapi.model.FaceStyleItem.STYLE_CHANGE_TYPE;
import com.tencent.ttpic.openapi.model.GLBItemJava;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.StickerItem.ValueRange;
import com.tencent.ttpic.openapi.model.TNNMaterialReportInfo;
import com.tencent.ttpic.openapi.model.TriggerStateItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.model.cosfun.CosFun;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.CosFunGroupItem;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.CosFunItem;
import com.tencent.ttpic.openapi.offlineset.OfflineConfig;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory;
import com.tencent.ttpic.particle.GPUParticleFilter;
import com.tencent.ttpic.particle.ParticleFilter;
import com.tencent.ttpic.particle.ParticleFilter3D;
import com.tencent.ttpic.particlesystemx.ParticleSystemX;
import com.tencent.ttpic.renderitem.FrozenFrameRender;
import com.tencent.ttpic.renderitem.StyleFilterRender;
import com.tencent.ttpic.trigger.AETriggerI;
import com.tencent.ttpic.trigger.FabbyFiltersTriggerCtrlItem;
import com.tencent.ttpic.trigger.FilamentTriggerCtrlItem;
import com.tencent.ttpic.trigger.HairCosTriggerCtrlItem;
import com.tencent.ttpic.trigger.StyleChildTriggerCtrlItem;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import com.tencent.ttpic.trigger.TriggerManager;
import com.tencent.ttpic.trigger.VoiceToTextTriggerCtrlItem;
import com.tencent.ttpic.trigger.ZoomTriggerCtrlItem;
import com.tencent.ttpic.trigger.triggerctrlitem.DetectorSettingTrigerCtrlItem;
import com.tencent.ttpic.trigger.triggerctrlitem.FrozenFrameTrigerCtrlItem;
import com.tencent.ttpic.trigger.triggerctrlitem.StyleFilterTriggerCtrlItem;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoFilterFactory;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import com.tencent.ttpic.util.VideoFilterFactory.STICKER_TYPE;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class VideoFilterUtil
{
  public static final int IMAGE_HEIGHT = 960;
  public static final int IMAGE_WIDTH = 720;
  public static final double SCREEN_RATIO = 0.75D;
  public static final int SHOW_ONCE_TEX_COUNT = 2;
  public static final String SIMPLE_FRAGMENT_SHADER = " precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n \n void main(void) {\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n }";
  public static final String SIMPLE_VERTEX_SHADER = "precision mediump float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}";
  private static VideoFilterUtil.EffectFilterProvider effectFilterProvider;
  private static boolean isTNNAvailable = false;
  private static final HashSet<BeautyRealConfig.TYPE> jsonType = new HashSet(Arrays.asList(new BeautyRealConfig.TYPE[] { BeautyRealConfig.TYPE.BASIC4, BeautyRealConfig.TYPE.BASIC3, BeautyRealConfig.TYPE.FACE_SHORTEN, BeautyRealConfig.TYPE.NOSE }));
  private static final HashSet<BeautyRealConfig.TYPE> remodelType = new HashSet(Arrays.asList(new BeautyRealConfig.TYPE[] { BeautyRealConfig.TYPE.FOREHEAD, BeautyRealConfig.TYPE.EYE, BeautyRealConfig.TYPE.EYE_DISTANCE, BeautyRealConfig.TYPE.EYE_ANGLE, BeautyRealConfig.TYPE.MOUTH_SHAPE, BeautyRealConfig.TYPE.CHIN, BeautyRealConfig.TYPE.FACE_THIN, BeautyRealConfig.TYPE.FACE_V, BeautyRealConfig.TYPE.NOSE_WING, BeautyRealConfig.TYPE.NOSE_POSITION, BeautyRealConfig.TYPE.LIPS_THICKNESS, BeautyRealConfig.TYPE.LIPS_WIDTH, BeautyRealConfig.TYPE.CHEEKBONE_THIN }));
  private static TNNMaterialReportInfo tnnMaterialReportInfo = new TNNMaterialReportInfo();
  
  public static boolean actionTriggered(List<PointF> paramList, List<StickerItem> paramList1, Set<Integer> paramSet)
  {
    if (paramList == null) {
      return false;
    }
    if ((paramList1 == null) || (paramList1.size() == 0) || (paramSet == null)) {
      return true;
    }
    paramList = paramList1.iterator();
    while (paramList.hasNext())
    {
      paramList1 = (StickerItem)paramList.next();
      if ((paramList1 != null) && (paramSet.contains(Integer.valueOf(paramList1.getTriggerTypeInt())))) {
        return true;
      }
    }
    return false;
  }
  
  private static void adjustRenderOrder(List<String> paramList)
  {
    if (paramList.contains("Bighead"))
    {
      paramList.remove("Bighead");
      paramList.add(0, "Bighead");
    }
  }
  
  public static boolean canUseBlendMode(VideoFilterBase paramVideoFilterBase)
  {
    if (paramVideoFilterBase == null) {}
    do
    {
      do
      {
        do
        {
          return false;
          if (!(paramVideoFilterBase instanceof NormalVideoFilter)) {
            break;
          }
        } while ((!((NormalVideoFilter)paramVideoFilterBase).canUseBlendMode()) && (!GLCapabilities.isSupportFramebufferFetch()));
        return true;
        if (((paramVideoFilterBase instanceof FaceOffByImageFilter)) || ((paramVideoFilterBase instanceof ThreeDimFilter)) || ((paramVideoFilterBase instanceof ARParticleFilter)) || ((paramVideoFilterBase instanceof HeadCropFilter))) {
          return true;
        }
        if (!(paramVideoFilterBase instanceof FaceOffFilter)) {
          break;
        }
      } while ((!((FaceOffFilter)paramVideoFilterBase).canUseBlendMode()) && (!GLCapabilities.isSupportFramebufferFetch()));
      return true;
      if (!(paramVideoFilterBase instanceof FaceOff3DFilter)) {
        break;
      }
    } while ((!((FaceOff3DFilter)paramVideoFilterBase).canUseBlendMode()) && (!GLCapabilities.isSupportFramebufferFetch()));
    return true;
    if ((paramVideoFilterBase instanceof VoiceTextFilter)) {
      return true;
    }
    if ((paramVideoFilterBase instanceof ParticleFilter)) {
      return true;
    }
    if ((paramVideoFilterBase instanceof ParticleFilter3D)) {
      return true;
    }
    return paramVideoFilterBase.canUseBlendMode();
  }
  
  @Deprecated
  private static VideoFilterInputFreeze creatFreezeFrameFilter(VideoMaterial paramVideoMaterial)
  {
    paramVideoMaterial = paramVideoMaterial.getItemList();
    if ((paramVideoMaterial != null) && (!paramVideoMaterial.isEmpty()))
    {
      paramVideoMaterial = paramVideoMaterial.iterator();
      while (paramVideoMaterial.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)paramVideoMaterial.next();
        if (localStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.FREEZE_FRAME.type) {
          return createFreezeFilter(localStickerItem);
        }
      }
    }
    return null;
  }
  
  private static ZoomFilter creatZoomFilter(VideoMaterial paramVideoMaterial)
  {
    Iterator localIterator = null;
    StickerItem localStickerItem = null;
    paramVideoMaterial = paramVideoMaterial.getItemList();
    Object localObject = localIterator;
    if (paramVideoMaterial != null)
    {
      localObject = localIterator;
      if (!paramVideoMaterial.isEmpty())
      {
        localIterator = paramVideoMaterial.iterator();
        paramVideoMaterial = localStickerItem;
        for (;;)
        {
          localObject = paramVideoMaterial;
          if (!localIterator.hasNext()) {
            break;
          }
          localStickerItem = (StickerItem)localIterator.next();
          if (localStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.ZOOM_SETTING.type)
          {
            localObject = paramVideoMaterial;
            if (paramVideoMaterial == null) {
              localObject = new ZoomFilter();
            }
            ((ZoomFilter)localObject).addItem(localStickerItem);
            paramVideoMaterial = (VideoMaterial)localObject;
          }
        }
      }
    }
    return localObject;
  }
  
  private static RenderItem creatZoomRenderItem(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    Object localObject2 = null;
    ZoomTriggerCtrlItem localZoomTriggerCtrlItem = new ZoomTriggerCtrlItem();
    paramVideoMaterial = paramVideoMaterial.getItemList();
    Object localObject1 = localObject2;
    if (paramVideoMaterial != null)
    {
      localObject1 = localObject2;
      if (!paramVideoMaterial.isEmpty())
      {
        localObject1 = localObject2;
        if (paramTriggerManager != null)
        {
          Iterator localIterator = paramVideoMaterial.iterator();
          paramVideoMaterial = null;
          while (localIterator.hasNext())
          {
            StickerItem localStickerItem = (StickerItem)localIterator.next();
            if (localStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.ZOOM_SETTING.type)
            {
              localObject1 = paramVideoMaterial;
              if (paramVideoMaterial == null) {
                localObject1 = new ZoomFilter();
              }
              ((ZoomFilter)localObject1).addItem(localStickerItem);
              localZoomTriggerCtrlItem.addItem(localStickerItem);
              paramVideoMaterial = (VideoMaterial)localObject1;
            }
          }
          localObject1 = localObject2;
          if (paramVideoMaterial != null)
          {
            paramTriggerManager.addTriggers(localZoomTriggerCtrlItem);
            localObject1 = new RenderItem(paramVideoMaterial, localZoomTriggerCtrlItem);
          }
        }
      }
    }
    return localObject1;
  }
  
  private static RenderItem create360FabbyMvBGRenderItem(StickerItem paramStickerItem, String paramString, TriggerManager paramTriggerManager)
  {
    if (VideoFilterListExtension.getCreateExternalFiltersListener() == null) {
      return null;
    }
    StaticStickerFilter localStaticStickerFilter = VideoFilterListExtension.getCreateExternalFiltersListener().createPanoramicFilter(paramStickerItem, paramString);
    TriggerCtrlItem localTriggerCtrlItem = new TriggerCtrlItem(paramStickerItem);
    paramTriggerManager.addTriggers(localTriggerCtrlItem);
    LogUtils.d("timweiliu log", "new PanoramicVideoFilter end");
    if (GLCapabilities.isSupportFramebufferFetch())
    {
      paramString = "mee3843x1954047267x1769172581x1193307759x1480941388x1752391508x1919247457x1634887263x1969382765x1919247974x1952802399x975202403x1902473760x1701996917x1919945226x1936286565x544108393x1751607656x1818632304x997482863x1918989834x1735289209x1667593760x1633886258x1935767150x1919905603x1634625892x171664756x2037539190x543649385x845374838x2019914784x1701999988x1919905603x1634625892x171664756x2037539190x543649385x845374838x1886150944x1866686824x1768190575x1702125934x1963592251x1868982638x1931505010x1819307361x1144156773x1886284064x1833530485x1415931745x1970567269x171664754x1718185589x544043631x1886216563x846357868x1852383300x1232369008x1701273965x1954047316x845509237x1853164091x1919903337x1852383341x1818370164x1298427493x996500591x1981811210x540304229x1852140642x1819231076x1982362223x540304229x1131963764x1919904879x1702240300x1663054947x1635151457x1819231091x170488431x537557792x538976288x862152054x1850701344x540876901x862152054x808333608x774971436x824192048x992555054x538976266x1702240288x1981821795x1869768026x1981824288x674456421x741355056x808333344x774905900x171649328x538976266x1702240288x1914712931x1819636581x1919895156x540876901x1131963764x1919904879x1650946606x538970683x1763713056x1646796902x1684956524x1701080909x540884000x2088509489x1701601824x1867342958x1042310500x691155232x791617659x1634100580x745827445x1852404512x1965057379x543450483x1953722221x1970282540x1852776564x1886352416x538970634x2099257376x1936483616x1718165605x1818372128x1298427493x543515759x840973629x544940073x1831808800x1769237621x175729776x538976288x538976288x1936028192x1182035061x543519343x1633886269x1935767150x1869377347x1735536242x539631714x1131963764x1919904879x1650946606x538970683x2099257376x1936483616x1718165605x1818372128x1298427493x543515759x857750845x538999593x791617568x1701995379x537554533x538976288x538976288x1970496882x1866888300x1025533298x1850701344x539828325x1850701352x539828325x1986945379x1866691425x779251564x694314866x673196576x1701728118x1948265760x1866692709x779251564x694314866x538970683x2099257376x1936483616x1718165605x1818372128x1298427493x543515759x874528061x538999593x791617568x1919252079x175726956x538976288x538976288x1936028192x1182035061x543519343x775036989x539631664x1986945379x1866691425x779251564x543319922x1702109226x1819231096x1915646575x171663975x538976288x538976288x543582496x1851876136x1131635062x1919904879x1042313774x774905917x2065705269x538976266x538976288x538976288x1701978144x1953265011x1701998406x1025536558x808333600x840969504x706752558x774973472x539828272x1986945379x1866691425x779251564x706750834x774973472x539828272x1131963764x1919904879x992571950x538976266x538976288x175972384x538976288x538976288x543582496x1851876136x1131635062x1919904879x1042310958x774905917x2065705269x538976266x538976288x538976288x1701978144x1953265011x1701998406x1025533742x808333600x840969504x706752558x774973472x539828272x1986945379x1866691425x779251564x706750823x774973472x539828272x1131963764x1919904879x992569134x538976266x538976288x175972384x538976288x538976288x543582496x1851876136x1131635062x1919904879x1042309678x774905917x2065705269x538976266x538976288x538976288x1701978144x1953265011x1701998406x1025532462x808333600x840969504x706752558x774973472x539828272x1986945379x1866691425x779251564x706750818x774973472x539828272x1131963764x1919904879x992567854x538976266x538976288x175972384x538976288x1696628000x543519596x673212009x1852140642x1685015908x1027416165x2066298144x538976288x1634217775x1768711282x175401063x538976288x538976288x1936028192x1182035061x543519343x775036989x539631664x1986945379x1866691425x779251564x543319922x1702109226x1819231096x1915646575x171663975x538976288x538976288x543582496x2019914792x1869377347x544353906x807419198x539571502x538970747x538976288x538976288x1914708000x1819636581x1919895156x544353893x774971453x539828272x540028466x824713258x757084206x1851876128x1131635062x1919904879x539587118x824713258x757084206x2019914784x1869377347x695348850x538970683x538976288x2099257376x538976266x538976288x1718165536x1702111264x1819231096x1731097199x540884512x691351088x537557792x538976288x538976288x538976288x1970496882x1866888300x1731093874x824196384x757084206x808333856x673196576x540028465x1633886253x1935767150x1869377347x694627954x673196576x540028465x1702109229x1819231096x1731097199x537541417x538976288x538976288x538970749x538976288x1763713056x1948786790x1866692709x779251564x1027481698x892219424x175841321x538976288x538976288x538976288x1936028192x1182035061x778400367x540876898x540028465x775036973x539631664x808333608x1663053088x1635151457x1819231091x1647211119x539631657x808333608x1948265760x1866692709x779251564x171649378x538976288x538976288x537558304x538976288x1818566781x1763730803x1646796902x1684956524x1701080909x540884256x544942390x790634528x1718580015x1734962292x537556072x538976288x538976288x1970496882x1866888300x1025533298x808333856x1663052320x1635151457x1819231091x1915646575x706765415x2019914784x1869377347x1735536242x539697250x1986945379x1866691425x779251564x543319922x1633886250x1935767150x1869377347x1735536242x539631714x1850701352x539828325x540028466x1702109226x1819231096x1915646575x992567911x538976266x538976288x1718165536x1702111264x1819231096x1915646575x540884512x691351088x537557792x538976288x538976288x538976288x1970496882x1866888300x1915643250x840973600x706752558x1851876128x1131635062x1919904879x706769454x774973472x539828272x1131963764x1919904879x539587118x841490475x706752558x2019914784x1869377347x544353906x774971437x706750768x1920037664x1633888372x1935767150x1869377347x695348850x538970683x538976288x2099257376x538976266x538976288x1718165536x1702111264x1819231096x1731097199x540884512x691351088x537557792x538976288x538976288x538976288x1970496882x1866888300x1731093874x840973600x706752558x1851876128x1131635062x1919904879x706766638x774973472x539828272x1131963764x1919904879x539584302x841490475x706752558x2019914784x1869377347x543633010x774971437x706750768x1920037664x1633888372x1935767150x1869377347x694627954x538970683x538976288x2099257376x538976266x538976288x1718165536x1702111264x1819231096x1647211119x540884512x691351088x537557792x538976288x538976288x538976288x1970496882x1866888300x1647207794x840973600x706752558x1851876128x1131635062x1919904879x706765358x774973472x539828272x1131963764x1919904879x539583022x841490475x706752558x2019914784x1869377347x543305330x774971437x706750768x1920037664x1633888372x1935767150x1869377347x694300274x538970683x538976288x2099257376x538976266x545071136x1702063205x543582496x1701601832x1867342958x1025533284x691478589x538976379x1680813856x1684633193x538970725x538976288x1914708000x1819636581x1919895156x540876901x1701728118x538970683x538976288x1763713056x1948786790x1866692709x779251564x540942450x691023408x537557792x538976288x538976288x538976288x1970496882x1866888300x1915643250x1663057184x1635151457x1819231091x1915646575x1948266272x1866692709x779251564x537541490x538976288x538976288x538970749x538976288x1763713056x1948786790x1866692709x779251564x540942439x691023408x537557792x538976288x538976288x538976288x1970496882x1866888300x1731093874x1663057184x1635151457x1819231091x1731097199x1948266272x1866692709x779251564x537541479x538976288x538976288x538970749x538976288x1763713056x1948786790x1866692709x779251564x540942434x691023408x537557792x538976288x538976288x538976288x1970496882x1866888300x1647207794x1663057184x1635151457x1819231091x1647211119x1948266272x1866692709x779251564x537541474x538976288x538976288x538970749x538976288x1914708000x1819636581x1919895156x540876901x678324589x1701728118x1701978156x1953265011x1701998406x537541417x538976288x1818566781x1763730803x1646796902x1684956524x1701080909x540884256x544942392x790634528x1684300079x538976266x538976288x1701978144x1953265011x1701998406x1663057184x1635151457x1819231091x1915646575x723542631x2019914784x1869377347x1735536242x537541474x538976288x538976288x1970496882x1866888300x1025533298x1852402976x1850701352x1914711141x1819636581x1919895156x171649381x538976288x1696628000x543519596x673212009x1852140642x1685015908x1027416165x2066299168x538976288x1970482991x1920234338x175399777x538976288x538976288x1936028192x1182035061x543519343x1633886269x1935767150x1869377347x1735536242x539828322x1131963764x1919904879x1650946606x538970683x538976288x1914708000x1819636581x1919895156x540876901x678977901x1919244918x1914711151x1819636581x1919895156x171649381x538976288x1696628000x543519596x673212009x1852140642x1685015908x1027416165x691024160x538976379x1768173359x537552486x538976288x538976288x1970496882x1866888300x1025533298x1935827232x1851876136x1131635062x1919904879x1650946606x1948265760x1866692709x779251564x694314866x538970683x2099257376x1936483616x1718165605x1818372128x1298427493x543515759x824196413x544942385x791617568x1802658148x537554533x538976288x538976288x1970496882x1866888300x1025533298x1852402976x1851876136x1131635062x1919904879x1650946606x1702109228x1819231096x1915646575x992567911x538976266x545071136x1702063205x543582496x1701601832x1867342958x1025533284x842080317x538999593x1815031584x1952999273x537554533x538976288x538976288x1970496882x1866888300x1025533298x2019650848x1851876136x1131635062x1919904879x1650946606x1702109228x1819231096x1915646575x992567911x538976266x175972384x538976288x1882140448x1830839666x1769237621x544828528x544370534x1816292455x1180986981x174288501x538976288x1667593760x1701978164x1953265011x1869377347x540876914x878929270x1936028200x1182035061x543519343x1702109226x1819231096x1630433903x1702109228x1819231096x1630433903x537541417x538976288x1970562418x1914728050x1819636581x1819231092x171668079x168459552x1684631414x1767992608x1870014574x170484841x538970747x1702240288x1663054947x1635151457x1819231091x1025536623x1600939808x1953718604x1734439494x1635017028x995962971x538976266x1667593760x1702109236x1819231096x1025536623x2019914784x1701999988x1764246578x1953853550x1734438217x2019906661x1701999988x1948265522x1970567269x1866687858x1768190575x1702125934x537541417x1981816864x540304229x1752198241x540876897x1954047348x845509237x1764237380x1953853550x1734438217x2019906661x1701999988x1629498418x1634234476x1919905603x1634625892x992568692x538976266x2019914784x1869377347x543239794x1818304573x778135664x537541490x1730158624x1917214572x1866688353x544370540x1818370109x1130655333x1919904879x2019914792x1869377347x1663052914x1635151457x1819231091x992572015x687370x";
      if (paramStickerItem.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_UP_DOWN) {
        break label119;
      }
      localStaticStickerFilter.updateFilterShader("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvarying vec2 alphaCoordinate;\n\nuniform int texNeedTransform;\nuniform vec2 canvasSize;\nuniform vec2 texAnchor;\nuniform float texScale;\nuniform vec3 texRotate;\n\nconst float PI = 3.14159;\n\nuniform mat4 u_MVPMatrix;\n\nmat4 texMatTranslateBefore = mat4(1.0, 0.0, 0.0, 0.0,\n                                  0.0, 1.0, 0.0, 0.0,\n                                  0.0, 0.0, 1.0, 0.0,\n                                  0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatScale = mat4(1.0, 0.0, 0.0, 0.0,\n                        0.0, 1.0, 0.0, 0.0,\n                        0.0, 0.0, 1.0, 0.0,\n                        0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatRotate = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatRotateXY = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatTranslateAfter = mat4(1.0, 0.0, 0.0, 0.0,\n                                 0.0, 1.0, 0.0, 0.0,\n                                 0.0, 0.0, 1.0, 0.0,\n                                 0.0, 0.0, 0.0, 1.0);\n\nmat4 mat4RotationYXZ(mat4 m, float xRadians, float yRadians, float zRadians) {\n    /*\n     |  cycz + sxsysz   czsxsy - cysz   cxsy  0 |\n M = |  cxsz            cxcz           -sx    0 |\n     |  cysxsz - czsy   cyczsx + sysz   cxcy  0 |\n     |  0               0               0     1 |\n\n     where cA = cos(A), sA = sin(A) for A = x,y,z\n     */\n\n    float cx = cos(xRadians);\n    float sx = sin(xRadians);\n    float cy = cos(yRadians);\n    float sy = sin(yRadians);\n    float cz = cos(zRadians);\n    float sz = sin(zRadians);\n\n    m[0][0] = (cy * cz) + (sx * sy * sz);\n    m[0][1] = cx * sz;\n    m[0][2] = (cy * sx * sz) - (cz * sy);\n    m[0][3] = 0.0;\n\n    m[1][0] = (cz * sx * sy) - (cy * sz);\n    m[1][1] = cx * cz;\n    m[1][2] = (cy * cz * sx) + (sy * sz);\n    m[1][3] = 0.0;\n\n    m[2][0] = cx * sy;\n    m[2][1] = -sx;\n    m[2][2] = cx * cy;\n    m[2][3] = 0.0;\n\n    m[3][0] = 0.0;\n    m[3][1] = 0.0;\n    m[3][2] = 0.0;\n    m[3][3] = 1.0;\n\n    return m;\n}\n\nvoid main(){\n    vec4 framePos = position;\n    if (texNeedTransform > 0) {\n        framePos.x = framePos.x * canvasSize.x * 0.5;\n        framePos.y = framePos.y * canvasSize.y * 0.5;\n\n        texMatTranslateBefore[3][0] = -texAnchor.x;\n        texMatTranslateBefore[3][1] = -texAnchor.y;\n\n        texMatScale[0][0] = texScale;\n        texMatScale[1][1] = texScale;\n\n        texMatRotate = mat4RotationYXZ(texMatRotate, 0.0, 0.0, texRotate.z);\n        texMatRotateXY = mat4RotationYXZ(texMatRotateXY, texRotate.x, texRotate.y, 0.0);\n\n        texMatTranslateAfter[3][0] = texAnchor.x;\n        texMatTranslateAfter[3][1] = texAnchor.y;\n\n        framePos = texMatRotate * texMatScale * texMatTranslateBefore * framePos;\n\n        framePos.x = framePos.x * 2.0 / canvasSize.x;\n        framePos.y = framePos.y * 2.0 / canvasSize.y;\n\n        framePos = texMatRotateXY * framePos;\n\n        framePos.x = framePos.x * canvasSize.x * 0.5;\n        framePos.y = framePos.y * canvasSize.y * 0.5;\n\n        framePos = texMatTranslateAfter * framePos;\n\n        framePos.x = framePos.x * 2.0 / canvasSize.x;\n        framePos.y = framePos.y * 2.0 / canvasSize.y;\n\n        framePos.x = framePos.x * 1.5 ;\n        framePos.y = framePos.y * 1.5 ;\n\n        framePos = u_MVPMatrix * framePos;\n\n    }\n    gl_Position = framePos;\n    textureCoordinate = vec2(inputTextureCoordinate.x, inputTextureCoordinate.y / 2.);\n    alphaCoordinate = vec2(inputTextureCoordinate.x, inputTextureCoordinate.y / 2. + 0.5);\n}", paramString);
    }
    for (;;)
    {
      LogUtils.d("timweiliu log", "return PanoramicVideoFilter item.sourceType = " + paramStickerItem.sourceType);
      return new RenderItem(localStaticStickerFilter, localTriggerCtrlItem);
      paramString = "precision highp float;\nvarying vec2 textureCoordinate;\nvarying vec2 alphaCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform int blendMode;\nuniform vec2 canvasSize;\n\n vec4 blendColor(vec4 texColor, vec4 canvasColor)\n {\n     vec3 vOne = vec3(1.0, 1.0, 1.0);\n     vec3 vZero = vec3(0.0, 0.0, 0.0);\n\n     vec3 resultFore = texColor.rgb;\n     if (blendMode <= 1 || blendMode > 12){ //default, since used most, put on top\n\n     } else if (blendMode == 2) {  //multiply\n         resultFore = canvasColor.rgb * texColor.rgb;\n     } else if (blendMode == 3){    //screen\n         resultFore = vOne - (vOne - canvasColor.rgb) * (vOne - texColor.rgb);\n     } else if (blendMode == 4){    //overlay\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n         if (canvasColor.r >= 0.5) {\n             resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n         }\n         if (canvasColor.g >= 0.5) {\n             resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n         }\n         if (canvasColor.b >= 0.5) {\n             resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n         }\n     } else if (blendMode == 5){    //hardlight\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n         if (texColor.r >= 0.5) {\n             resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n         }\n         if (texColor.g >= 0.5) {\n             resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n         }\n         if (texColor.b >= 0.5) {\n             resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n         }\n     } else if (blendMode == 6){    //softlight\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n         if (texColor.r >= 0.5) {\n             resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n         }\n         if (texColor.g >= 0.5) {\n             resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n         }\n         if (texColor.b >= 0.5) {\n             resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n         }\n     } else if (blendMode == 7){    //divide\n         resultFore = vOne;\n         if (texColor.r > 0.0) {\n             resultFore.r = canvasColor.r / texColor.r;\n         }\n         if (texColor.g > 0.0) {\n             resultFore.g = canvasColor.g / texColor.g;\n         }\n         if (texColor.b > 0.0) {\n             resultFore.b = canvasColor.b / texColor.b;\n         }\n         resultFore = min(vOne, resultFore);\n     } else if (blendMode == 8){    //add\n         resultFore = canvasColor.rgb + texColor.rgb;\n         resultFore = min(vOne, resultFore);\n     } else if (blendMode == 9){    //substract\n         resultFore = canvasColor.rgb - texColor.rgb;\n         resultFore = max(vZero, resultFore);\n     } else if (blendMode == 10){   //diff\n         resultFore = abs(canvasColor.rgb - texColor.rgb);\n     } else if (blendMode == 11){   //darken\n         resultFore = min(canvasColor.rgb, texColor.rgb);\n     } else if (blendMode == 12){   //lighten\n         resultFore = max(canvasColor.rgb, texColor.rgb);\n     }\n     //pre multiply for glBlendFunc\n     vec4 resultColor = vec4(resultFore * texColor.a, texColor.a);\n     return resultColor;\n }\n\nvoid main(void)\n{\n    vec4 canvasColor = texture2D(inputImageTexture, vec2(gl_FragCoord.x / canvasSize.x, gl_FragCoord.y / canvasSize.y));\n    vec4 texColor = texture2D(inputImageTexture2, textureCoordinate);\n    vec4 alpha = texture2D (inputImageTexture2, alphaCoordinate);\n    texColor.a = alpha.r;\n    gl_FragColor = blendColor(texColor, canvasColor);\n}";
      break;
      label119:
      if (paramStickerItem.sourceType == VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_LEFT_RIGHT) {
        localStaticStickerFilter.updateFilterShader("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvarying vec2 alphaCoordinate;\n\nuniform int texNeedTransform;\nuniform vec2 canvasSize;\nuniform vec2 texAnchor;\nuniform float texScale;\nuniform vec3 texRotate;\n\nconst float PI = 3.14159;\n\nuniform mat4 u_MVPMatrix;\n\nmat4 texMatTranslateBefore = mat4(1.0, 0.0, 0.0, 0.0,\n                                  0.0, 1.0, 0.0, 0.0,\n                                  0.0, 0.0, 1.0, 0.0,\n                                  0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatScale = mat4(1.0, 0.0, 0.0, 0.0,\n                        0.0, 1.0, 0.0, 0.0,\n                        0.0, 0.0, 1.0, 0.0,\n                        0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatRotate = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatRotateXY = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatTranslateAfter = mat4(1.0, 0.0, 0.0, 0.0,\n                                 0.0, 1.0, 0.0, 0.0,\n                                 0.0, 0.0, 1.0, 0.0,\n                                 0.0, 0.0, 0.0, 1.0);\n\nmat4 mat4RotationYXZ(mat4 m, float xRadians, float yRadians, float zRadians) {\n    /*\n     |  cycz + sxsysz   czsxsy - cysz   cxsy  0 |\n M = |  cxsz            cxcz           -sx    0 |\n     |  cysxsz - czsy   cyczsx + sysz   cxcy  0 |\n     |  0               0               0     1 |\n\n     where cA = cos(A), sA = sin(A) for A = x,y,z\n     */\n\n    float cx = cos(xRadians);\n    float sx = sin(xRadians);\n    float cy = cos(yRadians);\n    float sy = sin(yRadians);\n    float cz = cos(zRadians);\n    float sz = sin(zRadians);\n\n    m[0][0] = (cy * cz) + (sx * sy * sz);\n    m[0][1] = cx * sz;\n    m[0][2] = (cy * sx * sz) - (cz * sy);\n    m[0][3] = 0.0;\n\n    m[1][0] = (cz * sx * sy) - (cy * sz);\n    m[1][1] = cx * cz;\n    m[1][2] = (cy * cz * sx) + (sy * sz);\n    m[1][3] = 0.0;\n\n    m[2][0] = cx * sy;\n    m[2][1] = -sx;\n    m[2][2] = cx * cy;\n    m[2][3] = 0.0;\n\n    m[3][0] = 0.0;\n    m[3][1] = 0.0;\n    m[3][2] = 0.0;\n    m[3][3] = 1.0;\n\n    return m;\n}\n\nvoid main(){\n    vec4 framePos = position;\n    if (texNeedTransform > 0) {\n        framePos.x = framePos.x * canvasSize.x * 0.5;\n        framePos.y = framePos.y * canvasSize.y * 0.5;\n\n        texMatTranslateBefore[3][0] = -texAnchor.x;\n        texMatTranslateBefore[3][1] = -texAnchor.y;\n\n        texMatScale[0][0] = texScale;\n        texMatScale[1][1] = texScale;\n\n        texMatRotate = mat4RotationYXZ(texMatRotate, 0.0, 0.0, texRotate.z);\n        texMatRotateXY = mat4RotationYXZ(texMatRotateXY, texRotate.x, texRotate.y, 0.0);\n\n        texMatTranslateAfter[3][0] = texAnchor.x;\n        texMatTranslateAfter[3][1] = texAnchor.y;\n\n        framePos = texMatRotate * texMatScale * texMatTranslateBefore * framePos;\n\n        framePos.x = framePos.x * 2.0 / canvasSize.x;\n        framePos.y = framePos.y * 2.0 / canvasSize.y;\n\n        framePos = texMatRotateXY * framePos;\n\n        framePos.x = framePos.x * canvasSize.x * 0.5;\n        framePos.y = framePos.y * canvasSize.y * 0.5;\n\n        framePos = texMatTranslateAfter * framePos;\n\n        framePos.x = framePos.x * 2.0 / canvasSize.x;\n        framePos.y = framePos.y * 2.0 / canvasSize.y;\n\n        framePos.x = framePos.x * 1.5 ;\n        framePos.y = framePos.y * 1.5 ;\n\n        framePos = u_MVPMatrix * framePos;\n\n    }\n    gl_Position = framePos;\n    textureCoordinate = vec2(inputTextureCoordinate.x / 2., inputTextureCoordinate.y);\n    alphaCoordinate = vec2(inputTextureCoordinate.x / 2. + 0.5, inputTextureCoordinate.y);\n}", paramString);
      }
    }
  }
  
  private static ARParticleFilter createARParticleFilter(VideoMaterial paramVideoMaterial)
  {
    ARParticleFilter localARParticleFilter = null;
    if (VideoMaterialUtil.isARMaterial(paramVideoMaterial)) {
      localARParticleFilter = new ARParticleFilter(paramVideoMaterial.getArParticleList(), paramVideoMaterial.getDataPath());
    }
    return localARParticleFilter;
  }
  
  private static ActFilters createActFilter(VideoMaterial paramVideoMaterial)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.MAI_MENG.value)
    {
      localObject1 = localObject2;
      if (paramVideoMaterial.getFaceExpression() != null) {
        localObject1 = new ActFilters(paramVideoMaterial.getFaceExpression(), paramVideoMaterial.getDataPath());
      }
    }
    return localObject1;
  }
  
  private static List<RenderItem> createBeautyTransformListRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = new ArrayList();
    if ((Build.BRAND.equals("Xiaomi")) && (Build.MODEL.equals("MI 9"))) {
      return localArrayList;
    }
    paramVideoMaterial = paramVideoMaterial.getFaceBeautyItemList();
    if (!CollectionUtils.isEmpty(paramVideoMaterial))
    {
      Iterator localIterator1 = paramVideoMaterial.iterator();
      while (localIterator1.hasNext())
      {
        FaceBeautyItem localFaceBeautyItem = (FaceBeautyItem)localIterator1.next();
        BeautyParam localBeautyParam = new BeautyParam(BeautyParam.MeshType.PITU, true);
        paramVideoMaterial = null;
        Iterator localIterator2 = localFaceBeautyItem.beautyValues.entrySet().iterator();
        Object localObject;
        while (localIterator2.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator2.next();
          if (jsonType.contains(localEntry.getKey()))
          {
            localObject = paramVideoMaterial;
            if (paramVideoMaterial == null)
            {
              localObject = new BeautyTransformList();
              ((BeautyTransformList)localObject).setFaceBeautyItem(localFaceBeautyItem);
            }
            ((BeautyTransformList)localObject).setBeautyParamValue(((BeautyRealConfig.TYPE)localEntry.getKey()).value, ((Integer)localEntry.getValue()).intValue());
            paramVideoMaterial = BeautyRealUtil.getDistortParam(localBeautyParam.getDistortList((BeautyRealConfig.TYPE)localEntry.getKey()), ((Integer)localEntry.getValue()).intValue(), ((BeautyRealConfig.TYPE)localEntry.getKey()).value);
            ((BeautyTransformList)localObject).setBeautyParam(((BeautyRealConfig.TYPE)localEntry.getKey()).value, paramVideoMaterial);
            paramVideoMaterial = (VideoMaterial)localObject;
          }
        }
        if (paramVideoMaterial != null)
        {
          localObject = new TriggerCtrlItem(localFaceBeautyItem);
          paramTriggerManager.addTriggers((AETriggerI)localObject);
          localArrayList.add(new RenderItem(paramVideoMaterial, (TriggerCtrlItem)localObject));
        }
      }
    }
    return localArrayList;
  }
  
  private static VideoFilterBase createBigHeadFilter(VideoMaterial paramVideoMaterial)
  {
    if (VideoFilterListExtension.getCreateExternalFiltersListener() != null) {
      return VideoFilterListExtension.getCreateExternalFiltersListener().createBigHeadFilter(paramVideoMaterial);
    }
    return null;
  }
  
  private static List<RenderItem> createBodyGpuParticleRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramVideoMaterial.getItemList();
    if (!FeatureManager.Features.GPU_PARTICLE.isFunctionReady()) {
      return localArrayList;
    }
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        Object localObject = (StickerItem)localList.get(i);
        if ((((StickerItem)localObject).gpuParticleConfig != null) && (VideoMaterialUtil.isBodyDetectItem((StickerItem)localObject)))
        {
          GPUParticleFilter localGPUParticleFilter = new GPUParticleFilter(paramVideoMaterial.getDataPath() + File.separator + ((StickerItem)localObject).id, (StickerItem)localObject);
          localObject = new TriggerCtrlItem((StickerItem)localObject);
          paramTriggerManager.addTriggers((AETriggerI)localObject);
          localArrayList.add(new RenderItem(localGPUParticleFilter, (TriggerCtrlItem)localObject));
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private static List<RenderItem> createBodyParticleRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramVideoMaterial.getItemList();
    if (localList != null)
    {
      int i = 0;
      if (i < localList.size())
      {
        Object localObject1 = (StickerItem)localList.get(i);
        Object localObject2;
        if ((((StickerItem)localObject1).particleConfig != null) && (VideoMaterialUtil.isBodyDetectItem((StickerItem)localObject1)))
        {
          if (!((StickerItem)localObject1).dexName.endsWith("json")) {
            break label159;
          }
          localObject2 = new ParticleFilter3D(paramVideoMaterial.getDataPath() + File.separator + ((StickerItem)localObject1).id, (StickerItem)localObject1);
          localObject1 = new TriggerCtrlItem((StickerItem)localObject1);
          paramTriggerManager.addTriggers((AETriggerI)localObject1);
          localArrayList.add(new RenderItem((AEFilterI)localObject2, (TriggerCtrlItem)localObject1));
        }
        for (;;)
        {
          i += 1;
          break;
          label159:
          localObject2 = new ParticleFilter(paramVideoMaterial.getDataPath() + File.separator + ((StickerItem)localObject1).id, (StickerItem)localObject1);
          localObject1 = new TriggerCtrlItem((StickerItem)localObject1);
          paramTriggerManager.addTriggers((AETriggerI)localObject1);
          localArrayList.add(new RenderItem((AEFilterI)localObject2, (TriggerCtrlItem)localObject1));
        }
      }
    }
    return localArrayList;
  }
  
  private static List<RenderItem> createBodyRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramVideoMaterial.getItemList() != null)
    {
      boolean bool = VideoMaterialUtil.canMaterialUseFastRender(paramVideoMaterial);
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (StickerItem)localIterator.next();
        if ((VideoMaterialUtil.isBodyDetectItem((StickerItem)localObject)) && (((StickerItem)localObject).particleConfig == null) && (((StickerItem)localObject).gpuParticleConfig == null) && ((!bool) || (!VideoMaterialUtil.canStickerItemUseFastRender((StickerItem)localObject)) || (!VideoMaterialUtil.canStickerItemUseFastBodyRender((StickerItem)localObject))))
        {
          NormalVideoFilter localNormalVideoFilter = VideoFilterFactory.createFilter((StickerItem)localObject, paramVideoMaterial.getDataPath());
          if (localNormalVideoFilter != null)
          {
            localObject = new TriggerCtrlItem((StickerItem)localObject);
            paramTriggerManager.addTriggers((AETriggerI)localObject);
            localArrayList.add(new RenderItem(localNormalVideoFilter, (TriggerCtrlItem)localObject));
          }
        }
      }
    }
    return localArrayList;
  }
  
  private static List<NormalVideoFilter> createBodyVideoFilterList(VideoMaterial paramVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramVideoMaterial.getItemList() != null)
    {
      boolean bool = VideoMaterialUtil.canMaterialUseFastRender(paramVideoMaterial);
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (StickerItem)localIterator.next();
        if ((VideoMaterialUtil.isBodyDetectItem((StickerItem)localObject)) && (((StickerItem)localObject).particleConfig == null) && (((StickerItem)localObject).gpuParticleConfig == null) && ((!bool) || (!VideoMaterialUtil.canStickerItemUseFastRender((StickerItem)localObject)) || (!VideoMaterialUtil.canStickerItemUseFastBodyRender((StickerItem)localObject))))
        {
          localObject = VideoFilterFactory.createFilter((StickerItem)localObject, paramVideoMaterial.getDataPath());
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
    }
    return localArrayList;
  }
  
  private static RenderItem createBuckleFaceRenderItem(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    if (VideoFilterListExtension.getCreateExternalFiltersListener() != null) {}
    for (paramVideoMaterial = VideoFilterListExtension.getCreateExternalFiltersListener().createBuckleFaceFilter(paramVideoMaterial);; paramVideoMaterial = null) {
      return new RenderItem(paramVideoMaterial, null);
    }
  }
  
  private static List<RenderItem> createCatRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramVideoMaterial.getItemList() != null)
    {
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (StickerItem)localIterator.next();
        if ((VideoMaterialUtil.isCatItem((StickerItem)localObject)) && (((StickerItem)localObject).particleConfig == null) && (((StickerItem)localObject).gpuParticleConfig == null))
        {
          NormalVideoFilter localNormalVideoFilter = VideoFilterFactory.createFilter((StickerItem)localObject, paramVideoMaterial.getDataPath());
          if (localNormalVideoFilter != null)
          {
            localObject = new TriggerCtrlItem((StickerItem)localObject);
            paramTriggerManager.addTriggers((AETriggerI)localObject);
            localArrayList.add(new RenderItem(localNormalVideoFilter, (TriggerCtrlItem)localObject));
          }
        }
      }
    }
    return localArrayList;
  }
  
  private static List<RenderItem> createComicEffectFilterRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramVideoMaterial.getItemList();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        Object localObject = (StickerItem)localList.get(i);
        if ((((StickerItem)localObject).comicLutFilter != null) && (!((StickerItem)localObject).comicLutFilter.equals("")))
        {
          ComicEffectFilter localComicEffectFilter = new ComicEffectFilter((StickerItem)localObject, paramVideoMaterial.getDataPath());
          localObject = new TriggerCtrlItem((StickerItem)localObject);
          paramTriggerManager.addTriggers((AETriggerI)localObject);
          localArrayList.add(new RenderItem(localComicEffectFilter, (TriggerCtrlItem)localObject));
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private static List<StyleCustomFilterGroup> createCosFunCustomFilterGroup(CosFun paramCosFun)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramCosFun != null)
    {
      paramCosFun = paramCosFun.getCosFunGroupItem();
      if (paramCosFun != null)
      {
        paramCosFun = paramCosFun.iterator();
        while (paramCosFun.hasNext())
        {
          Object localObject = ((CosFun.CosFunGroupItem)paramCosFun.next()).getCosFunItems();
          if (localObject != null)
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              StyleCustomFilterGroup localStyleCustomFilterGroup = createCustomFilterGroup(((CosFun.CosFunItem)((Iterator)localObject).next()).getCustomFilterItemList());
              if (localStyleCustomFilterGroup != null) {
                localArrayList.add(localStyleCustomFilterGroup);
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  private static CosFunFilterGroup createCosFunFilterGroup(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager, List<RenderItem> paramList, boolean paramBoolean)
  {
    CosFun localCosFun = paramVideoMaterial.getCosFun();
    if ((localCosFun != null) && (paramTriggerManager != null)) {
      return new CosFunFilterGroup(paramVideoMaterial, paramTriggerManager, paramList, createCosFunCustomFilterGroup(localCosFun), paramBoolean);
    }
    return null;
  }
  
  private static CustomVideoFilter createCustomEffectVideoFilter(VideoMaterial paramVideoMaterial)
  {
    Object localObject2 = VideoMaterialUtil.loadVideoCustomEffectFilterVertexShader(paramVideoMaterial.getDataPath());
    String str = VideoMaterialUtil.loadVideoCustomEffectFilterFragmentShader(paramVideoMaterial.getDataPath());
    if ((TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty(str))) {
      return null;
    }
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "mee3725x1667592816x1869181801x1768431726x544237671x1634692198x1628060532x1769108596x1702131042x1667593760x1869619252x1769236851x171667055x1920234593x1953849961x1702240357x1763717731x1953853550x1954047316x1130721909x1685221231x1952542313x1980382053x1769566817x1981835118x540173157x1986945379x1866691425x1768190575x1702125934x1635125819x1852406130x1702240359x1948267107x1970567269x1866687858x1768190575x1702125934x1963592251x1868982638x1763732850x1948284014x1699641445x1918133349x1718840929x997028463x1768846602x1836216166x1667593760x1633886258x1935767150x1702521171x1853164091x1919903337x1702240365x1948267107x1849784421x1919903843x1853164091x1919903337x1818632301x544498031x1400399220x1701601635x1853164091x1919903337x1702240365x1948267363x1867675749x1702125940x1661602363x1953721967x1869375008x1344304225x540876873x875638323x993604913x1853164042x1919903337x1634541677x1965044852x1347833183x1920229709x171669609x1952541962x1702109236x1952533880x1851880020x1952541811x1717912165x543519343x1634541629x824718452x539766830x741355056x808333344x774905900x537537584x538976288x538976288x538976288x538976288x538976288x538976288x538976288x538976288x808333344x774971436x807414832x539766830x741355056x538976266x538976288x538976288x538976288x538976288x538976288x538976288x538976288x807411744x539766830x741355056x808333600x774905900x537537584x538976288x538976288x538976288x538976288x538976288x538976288x538976288x538976288x808333344x774905900x807414832x539766830x691023409x1829374523x540308577x1299735924x1666413665x543517793x1634541629x824718452x539766830x741355056x808333344x774905900x537537584x538976288x538976288x538976288x538976288x538976288x807411744x539766830x741355057x808333344x774905900x537537584x538976288x538976288x538976288x538976288x538976288x807411744x539766830x741355056x808333600x774905900x537537584x538976288x538976288x538976288x538976288x538976288x807411744x539766830x741355056x808333344x774971436x171649328x1952541962x1702109236x1952533880x1635020626x1025533300x1952541984x774973492x807414832x539766830x741355056x808333344x538970668x538976288x538976288x538976288x538976288x538976288x807411744x539766830x741355057x808333344x774905900x537537584x538976288x538976288x538976288x538976288x538976288x538976288x741355056x808333344x774971436x807414832x170668078x538976288x538976288x538976288x538976288x538976288x538976288x808333344x774905900x807414832x539766830x691023409x1829374523x540308577x1299735924x1867674721x1702125940x1025530200x1952541984x774973492x807414832x539766830x741355056x808333344x538970668x538976288x538976288x538976288x538976288x538976288x807411744x539766830x741355057x808333344x774905900x537537584x538976288x538976288x538976288x538976288x538976288x538976288x741355056x808333344x774971436x807414832x170668078x538976288x538976288x538976288x538976288x538976288x538976288x808333344x774905900x807414832x539766830x691023409x1829374523x540308577x1299735924x1918137441x1819504225x1097167969x1919251558x1830829344x674526305x741355057x808333344x774905900x807414832x170668078x538976288x538976288x538976288x538976288x538976288x538976288x538976288x538976288x808333344x774971436x807414832x539766830x741355056x538976266x538976288x538976288x538976288x538976288x538976288x538976288x538976288x774905888x807414832x539766830x741355057x808333344x538970668x538976288x538976288x538976288x538976288x538976288x538976288x538976288x807411744x539766830x741355056x808333344x774971436x171649328x1952541962x1634541620x1867658356x1769234804x1482255983x1634543706x1830827124x1818632236x544498031x1684099704x1936613737x1818632236x544498031x1684099705x1936613737x1818632236x544498031x1684099706x1936613737x175841321x538976288x537537071x538976288x1663049852x544891769x2020810795x2054388083x1663049760x1937273722x539828345x2054388067x1663049760x544830328x2082484256x541925386x545005629x1937269536x538976378x538976288x538976288x1668834080x538976378x538976288x538976288x544764717x807411744x537558048x538976288x1663049852x1937273721x539828346x2037611107x1663049760x1937400697x539697272x2054388083x1663049760x544826232x2082484256x538976266x545005600x538980384x538976288x538976288x538976288x538980384x538976288x538976288x538976288x538980384x824188960x168459296x538976288x1701345056x1663067506x540876865x678653795x539765057x1025524083x1852404512x539574568x544370534x540876865x746138744x538970746x706748448x537528879x1713381408x1952542572x544760608x1868767293x1383606387x1634296929x992572270x538976266x1869375008x1931506785x540876920x678324595x1684099704x1936613737x537541417x1713381408x1952542572x544826144x1868767293x1383671923x1634296929x992572270x538976266x1869375008x1931506785x540876921x678324595x1684099705x1936613737x537541417x1713381408x1952542572x544891680x1868767293x1383737459x1634296929x992572270x538976266x1869375008x1931506785x540876922x678324595x1684099706x1936613737x168442665x538976288x1563450221x542978139x1663574077x539631737x539589219x1932009515x539631736x706771315x695890720x538970683x1533878304x828071216x540876893x706771043x997880608x538976266x811298080x1563581277x673201440x706771299x544764704x2054365226x539828265x544891688x2037588010x537541417x1830821920x1532833883x1025531187x808333344x537528891x1830821920x1532834139x1025531184x2053318688x1931487776x539631736x539588979x1663574061x539631737x992574067x538976266x828075296x1563515741x1663057184x539631736x171670115x538976288x1563515757x542978651x1663574077x539631737x706771555x695759648x673196832x706771315x695890720x538970683x1533878304x861625649x540876893x993013296x538970634x1533878304x811294002x540876893x706771043x997815072x538976266x844852512x1563515741x757087520x171669619x538976288x1563581293x542978651x2019762237x1663052320x537541497x1830821920x1532834395x1025531187x808333344x537528891x1830821920x1532834651x1025531184x808333344x538970683x1533878304x828071219x540876893x993013296x538976266x861629728x1563581277x807419168x171651118x538976288x1563646829x542978907x774971453x168442672x538976288x1970562418x1830841970x175966779x1768912394x1634541668x690515561x538970747x1702240288x1713386595x1701667186x544436048x1869619261x1769236851x171667055x538976288x673212009x1316513140x1415865701x1936613746x1836216166x807419424x175841321x538976288x538976288x1835102822x1936674917x1025538094x1634887200x1867539821x544747123x1633886250x1935767150x1702521171x706770990x892219424x538970683x538976288x1919295520x1348824417x2033087343x1713388832x1701667186x779317072x539631737x1986945379x1767076705x2033083770x807414304x171652398x538976266x538976288x2019914784x1416913229x1936613746x1702125932x1868981570x861627762x1563450205x757087520x1098409332x1869112174x997731954x538976266x538976288x2019914784x1416913229x1936613746x1702125932x1868981570x861627762x1563515741x757087520x1098409332x1869112174x997797490x538970634x538976288x1702109216x1952533880x1818321747x1563450213x542978139x1702109245x1633899384x171664748x538976288x538976288x1299735924x1666413665x1533373537x828071217x540876893x1400399220x1701601635x537528891x538976288x1948262432x1632467045x1953452660x543519841x1634541629x1867658356x1769234804x1482255983x1702111322x1952533880x1635020626x539780468x741355056x808333344x1702109228x1953452664x778400865x171649402x538976288x538976288x1299735924x1867674721x1702125940x1025530200x1952541984x1953452596x1869182049x1515739502x2019914792x1383358797x1952543855x744052837x2019914784x1635020626x2016306548x1702109228x1953452664x778400865x807414905x992555054x538970634x538976288x1702109216x1952533880x1851880020x1952541811x1952858469x861631077x1563450205x1948269856x1849784421x1919903843x171669550x538976288x538976288x1299735924x1918137441x1819504225x1097167969x1919251558x1532834651x1025531185x2019914784x1751346753x2033087087x537528891x538976288x1713381408x1701667186x544436048x1702109245x1952533880x1635020626x706766196x2019914784x1400136013x1701601635x1948264992x1632467045x1634882676x1634497390x1698850164x1701998438x1713383968x1701667186x997420880x538970634x538976288x1919295520x1348824417x2016310127x1713388832x1701667186x779317072x539631736x540028466x1633886255x1935767150x1702521171x171669550x538976288x538976288x1835102822x1936674917x1025538350x1634887200x1867539821x544812659x775036970x539959344x1986945379x1767076705x2033083770x537528891x538976288x1713381408x1701667186x544436048x1702109245x1952533880x1635020626x1498965364x1713383968x1701667186x997420880x538970634x538976288x1919295520x1348824417x2016310127x1713388832x1701667186x779317072x539631736x1986945379x1767076705x2016306554x807414304x171652398x538976288x538976288x1835102822x1936674917x1025538350x1634887200x1867539821x544812659x1633886250x1935767150x1702521171x706771246x892219424x537528891x538976288x1713381408x1701667186x544436048x1702109245x1952533880x1851880020x1952541811x1952858469x706769509x1634887200x1867539821x168442739x538976288x538976288x1835102822x1936674917x1025538094x1634887200x1867539821x544747123x775036970x539959344x1986945379x1767076705x2016306554x538970683x538976288x1919295520x1348824417x2033087343x1713388832x1701667186x779317072x539631737x540028466x1633886255x1935767150x1702521171x171669806x538976266x538976288x1634887200x1867539821x544747123x1919295549x1348824417x2016310127x824191520x991966510x538976266x538976288x1634887200x1867539821x544812659x1919295549x1348824417x2033087343x824191520x991966510x538970634x538976288x1919295520x1348824417x1025536879x1298101536x1632456790x2020176500x1713383968x1701667186x997420880x538970634x175972384x538976288x1348430951x1953067887x544108393x1919295549x1348824417x171668335x538976288x1986945379x1866691425x1768190575x1702125934x1981824288x674390885x1835102822x1936674917x790657070x1634887200x1867539821x544681587x774905898x539697205x741682736x1634887200x1867539821x544812659x1919295535x1348824417x1999532911x807414304x723531054x892219424x537541417x1948262432x1970567269x1866687858x1768190575x1702125934x1763720480x1953853550x1954047316x1130721909x1685221231x1952542313x2097822565x10x";
    }
    localObject2 = str;
    if (TextUtils.isEmpty(str)) {
      localObject2 = ShaderCreateFactory.getFragmentShaderImageFile();
    }
    return new CustomVideoFilter((String)localObject1, (String)localObject2, paramVideoMaterial.getResourceList(), getCustomFilterTriggerType(paramVideoMaterial.getItemList()), paramVideoMaterial.getDataPath());
  }
  
  private static StyleCustomFilterGroup createCustomFilterGroup(List<CustomFilterItem> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    return new StyleCustomFilterGroup(paramList);
  }
  
  private static RenderItem createCustomRenderItem(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    Object localObject;
    if ((paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_BEFORE_COMMON.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.COMMON_BEFORE_CUSTOM.value))
    {
      localObject = VideoMaterialUtil.loadVertexShader(paramVideoMaterial.getDataPath());
      String str = VideoMaterialUtil.loadFragmentShader(paramVideoMaterial.getDataPath());
      if ((TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isEmpty(str))) {
        return null;
      }
      paramTriggerManager = (TriggerManager)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramTriggerManager = "mee3725x1667592816x1869181801x1768431726x544237671x1634692198x1628060532x1769108596x1702131042x1667593760x1869619252x1769236851x171667055x1920234593x1953849961x1702240357x1763717731x1953853550x1954047316x1130721909x1685221231x1952542313x1980382053x1769566817x1981835118x540173157x1986945379x1866691425x1768190575x1702125934x1635125819x1852406130x1702240359x1948267107x1970567269x1866687858x1768190575x1702125934x1963592251x1868982638x1763732850x1948284014x1699641445x1918133349x1718840929x997028463x1768846602x1836216166x1667593760x1633886258x1935767150x1702521171x1853164091x1919903337x1702240365x1948267107x1849784421x1919903843x1853164091x1919903337x1818632301x544498031x1400399220x1701601635x1853164091x1919903337x1702240365x1948267363x1867675749x1702125940x1661602363x1953721967x1869375008x1344304225x540876873x875638323x993604913x1853164042x1919903337x1634541677x1965044852x1347833183x1920229709x171669609x1952541962x1702109236x1952533880x1851880020x1952541811x1717912165x543519343x1634541629x824718452x539766830x741355056x808333344x774905900x537537584x538976288x538976288x538976288x538976288x538976288x538976288x538976288x538976288x808333344x774971436x807414832x539766830x741355056x538976266x538976288x538976288x538976288x538976288x538976288x538976288x538976288x807411744x539766830x741355056x808333600x774905900x537537584x538976288x538976288x538976288x538976288x538976288x538976288x538976288x538976288x808333344x774905900x807414832x539766830x691023409x1829374523x540308577x1299735924x1666413665x543517793x1634541629x824718452x539766830x741355056x808333344x774905900x537537584x538976288x538976288x538976288x538976288x538976288x807411744x539766830x741355057x808333344x774905900x537537584x538976288x538976288x538976288x538976288x538976288x807411744x539766830x741355056x808333600x774905900x537537584x538976288x538976288x538976288x538976288x538976288x807411744x539766830x741355056x808333344x774971436x171649328x1952541962x1702109236x1952533880x1635020626x1025533300x1952541984x774973492x807414832x539766830x741355056x808333344x538970668x538976288x538976288x538976288x538976288x538976288x807411744x539766830x741355057x808333344x774905900x537537584x538976288x538976288x538976288x538976288x538976288x538976288x741355056x808333344x774971436x807414832x170668078x538976288x538976288x538976288x538976288x538976288x538976288x808333344x774905900x807414832x539766830x691023409x1829374523x540308577x1299735924x1867674721x1702125940x1025530200x1952541984x774973492x807414832x539766830x741355056x808333344x538970668x538976288x538976288x538976288x538976288x538976288x807411744x539766830x741355057x808333344x774905900x537537584x538976288x538976288x538976288x538976288x538976288x538976288x741355056x808333344x774971436x807414832x170668078x538976288x538976288x538976288x538976288x538976288x538976288x808333344x774905900x807414832x539766830x691023409x1829374523x540308577x1299735924x1918137441x1819504225x1097167969x1919251558x1830829344x674526305x741355057x808333344x774905900x807414832x170668078x538976288x538976288x538976288x538976288x538976288x538976288x538976288x538976288x808333344x774971436x807414832x539766830x741355056x538976266x538976288x538976288x538976288x538976288x538976288x538976288x538976288x774905888x807414832x539766830x741355057x808333344x538970668x538976288x538976288x538976288x538976288x538976288x538976288x538976288x807411744x539766830x741355056x808333344x774971436x171649328x1952541962x1634541620x1867658356x1769234804x1482255983x1634543706x1830827124x1818632236x544498031x1684099704x1936613737x1818632236x544498031x1684099705x1936613737x1818632236x544498031x1684099706x1936613737x175841321x538976288x537537071x538976288x1663049852x544891769x2020810795x2054388083x1663049760x1937273722x539828345x2054388067x1663049760x544830328x2082484256x541925386x545005629x1937269536x538976378x538976288x538976288x1668834080x538976378x538976288x538976288x544764717x807411744x537558048x538976288x1663049852x1937273721x539828346x2037611107x1663049760x1937400697x539697272x2054388083x1663049760x544826232x2082484256x538976266x545005600x538980384x538976288x538976288x538976288x538980384x538976288x538976288x538976288x538980384x824188960x168459296x538976288x1701345056x1663067506x540876865x678653795x539765057x1025524083x1852404512x539574568x544370534x540876865x746138744x538970746x706748448x537528879x1713381408x1952542572x544760608x1868767293x1383606387x1634296929x992572270x538976266x1869375008x1931506785x540876920x678324595x1684099704x1936613737x537541417x1713381408x1952542572x544826144x1868767293x1383671923x1634296929x992572270x538976266x1869375008x1931506785x540876921x678324595x1684099705x1936613737x537541417x1713381408x1952542572x544891680x1868767293x1383737459x1634296929x992572270x538976266x1869375008x1931506785x540876922x678324595x1684099706x1936613737x168442665x538976288x1563450221x542978139x1663574077x539631737x539589219x1932009515x539631736x706771315x695890720x538970683x1533878304x828071216x540876893x706771043x997880608x538976266x811298080x1563581277x673201440x706771299x544764704x2054365226x539828265x544891688x2037588010x537541417x1830821920x1532833883x1025531187x808333344x537528891x1830821920x1532834139x1025531184x2053318688x1931487776x539631736x539588979x1663574061x539631737x992574067x538976266x828075296x1563515741x1663057184x539631736x171670115x538976288x1563515757x542978651x1663574077x539631737x706771555x695759648x673196832x706771315x695890720x538970683x1533878304x861625649x540876893x993013296x538970634x1533878304x811294002x540876893x706771043x997815072x538976266x844852512x1563515741x757087520x171669619x538976288x1563581293x542978651x2019762237x1663052320x537541497x1830821920x1532834395x1025531187x808333344x537528891x1830821920x1532834651x1025531184x808333344x538970683x1533878304x828071219x540876893x993013296x538976266x861629728x1563581277x807419168x171651118x538976288x1563646829x542978907x774971453x168442672x538976288x1970562418x1830841970x175966779x1768912394x1634541668x690515561x538970747x1702240288x1713386595x1701667186x544436048x1869619261x1769236851x171667055x538976288x673212009x1316513140x1415865701x1936613746x1836216166x807419424x175841321x538976288x538976288x1835102822x1936674917x1025538094x1634887200x1867539821x544747123x1633886250x1935767150x1702521171x706770990x892219424x538970683x538976288x1919295520x1348824417x2033087343x1713388832x1701667186x779317072x539631737x1986945379x1767076705x2033083770x807414304x171652398x538976266x538976288x2019914784x1416913229x1936613746x1702125932x1868981570x861627762x1563450205x757087520x1098409332x1869112174x997731954x538976266x538976288x2019914784x1416913229x1936613746x1702125932x1868981570x861627762x1563515741x757087520x1098409332x1869112174x997797490x538970634x538976288x1702109216x1952533880x1818321747x1563450213x542978139x1702109245x1633899384x171664748x538976288x538976288x1299735924x1666413665x1533373537x828071217x540876893x1400399220x1701601635x537528891x538976288x1948262432x1632467045x1953452660x543519841x1634541629x1867658356x1769234804x1482255983x1702111322x1952533880x1635020626x539780468x741355056x808333344x1702109228x1953452664x778400865x171649402x538976288x538976288x1299735924x1867674721x1702125940x1025530200x1952541984x1953452596x1869182049x1515739502x2019914792x1383358797x1952543855x744052837x2019914784x1635020626x2016306548x1702109228x1953452664x778400865x807414905x992555054x538970634x538976288x1702109216x1952533880x1851880020x1952541811x1952858469x861631077x1563450205x1948269856x1849784421x1919903843x171669550x538976288x538976288x1299735924x1918137441x1819504225x1097167969x1919251558x1532834651x1025531185x2019914784x1751346753x2033087087x537528891x538976288x1713381408x1701667186x544436048x1702109245x1952533880x1635020626x706766196x2019914784x1400136013x1701601635x1948264992x1632467045x1634882676x1634497390x1698850164x1701998438x1713383968x1701667186x997420880x538970634x538976288x1919295520x1348824417x2016310127x1713388832x1701667186x779317072x539631736x540028466x1633886255x1935767150x1702521171x171669550x538976288x538976288x1835102822x1936674917x1025538350x1634887200x1867539821x544812659x775036970x539959344x1986945379x1767076705x2033083770x537528891x538976288x1713381408x1701667186x544436048x1702109245x1952533880x1635020626x1498965364x1713383968x1701667186x997420880x538970634x538976288x1919295520x1348824417x2016310127x1713388832x1701667186x779317072x539631736x1986945379x1767076705x2016306554x807414304x171652398x538976288x538976288x1835102822x1936674917x1025538350x1634887200x1867539821x544812659x1633886250x1935767150x1702521171x706771246x892219424x537528891x538976288x1713381408x1701667186x544436048x1702109245x1952533880x1851880020x1952541811x1952858469x706769509x1634887200x1867539821x168442739x538976288x538976288x1835102822x1936674917x1025538094x1634887200x1867539821x544747123x775036970x539959344x1986945379x1767076705x2016306554x538970683x538976288x1919295520x1348824417x2033087343x1713388832x1701667186x779317072x539631737x540028466x1633886255x1935767150x1702521171x171669806x538976266x538976288x1634887200x1867539821x544747123x1919295549x1348824417x2016310127x824191520x991966510x538976266x538976288x1634887200x1867539821x544812659x1919295549x1348824417x2033087343x824191520x991966510x538970634x538976288x1919295520x1348824417x1025536879x1298101536x1632456790x2020176500x1713383968x1701667186x997420880x538970634x175972384x538976288x1348430951x1953067887x544108393x1919295549x1348824417x171668335x538976288x1986945379x1866691425x1768190575x1702125934x1981824288x674390885x1835102822x1936674917x790657070x1634887200x1867539821x544681587x774905898x539697205x741682736x1634887200x1867539821x544812659x1919295535x1348824417x1999532911x807414304x723531054x892219424x537541417x1948262432x1970567269x1866687858x1768190575x1702125934x1763720480x1953853550x1954047316x1130721909x1685221231x1952542313x2097822565x10x";
      }
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = ShaderCreateFactory.getFragmentShaderImageFile();
      }
    }
    for (paramVideoMaterial = new RenderItem(new CustomVideoFilter(paramTriggerManager, (String)localObject, paramVideoMaterial.getResourceList(), getCustomFilterTriggerType(paramVideoMaterial.getItemList()), paramVideoMaterial.getDataPath()), null);; paramVideoMaterial = null) {
      return paramVideoMaterial;
    }
  }
  
  private static RenderItem createCustomVertexRenderItem(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    Object localObject;
    if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_VERTEX_SHADER.value)
    {
      localObject = VideoMaterialUtil.loadVertexShader(paramVideoMaterial.getDataPath());
      String str = VideoMaterialUtil.loadFragmentShader(paramVideoMaterial.getDataPath());
      if ((TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isEmpty(str))) {
        return null;
      }
      paramTriggerManager = (TriggerManager)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramTriggerManager = "precision mediump float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}";
      }
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = " precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n \n void main(void) {\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n }";
      }
      if (CollectionUtils.isEmpty(paramVideoMaterial.getItemList())) {}
    }
    for (paramVideoMaterial = new CustomVertexFilter(paramTriggerManager, (String)localObject);; paramVideoMaterial = null) {
      return new RenderItem(paramVideoMaterial, null);
    }
  }
  
  private static void createDetectConfigTrigger(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    if ((paramVideoMaterial == null) || (paramVideoMaterial.getItemList() == null) || (paramTriggerManager == null)) {}
    for (;;)
    {
      return;
      paramVideoMaterial = paramVideoMaterial.getItemList().iterator();
      while (paramVideoMaterial.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)paramVideoMaterial.next();
        if ((localStickerItem != null) && (localStickerItem.disableDetectors != null)) {
          paramTriggerManager.addTriggers(new DetectorSettingTrigerCtrlItem(localStickerItem));
        }
      }
    }
  }
  
  private static RenderItem createDoodleRenderItem(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.DOODLE.value) {}
    for (paramVideoMaterial = new DoodleFilter();; paramVideoMaterial = null) {
      return new RenderItem(paramVideoMaterial, null);
    }
  }
  
  private static VideoFilterBase createEffectFilter(VideoMaterial paramVideoMaterial)
  {
    VideoFilterEffect localVideoFilterEffect;
    if (paramVideoMaterial != null)
    {
      localVideoFilterEffect = paramVideoMaterial.getVideoFilterEffect();
      if (localVideoFilterEffect == null) {}
    }
    switch (localVideoFilterEffect.type)
    {
    default: 
      return null;
    case 1: 
      return createSimpleEffectVideoFilter(paramVideoMaterial);
    }
    return createCustomEffectVideoFilter(paramVideoMaterial);
  }
  
  private static List<RenderItem> createEffectTriggerRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramVideoMaterial.getItemList();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        Object localObject = (StickerItem)localList.get(i);
        if ((((StickerItem)localObject).lutFilterName != null) && (!((StickerItem)localObject).lutFilterName.equals("")))
        {
          EffectTriggerFilter localEffectTriggerFilter = new EffectTriggerFilter((StickerItem)localObject, paramVideoMaterial.getDataPath());
          localObject = new TriggerCtrlItem((StickerItem)localObject);
          paramTriggerManager.addTriggers((AETriggerI)localObject);
          localArrayList.add(new RenderItem(localEffectTriggerFilter, (TriggerCtrlItem)localObject));
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private static RenderItem createFabbyMvFiltersRenderItem(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = null;
    HashMap localHashMap = new HashMap();
    Object localObject1 = localArrayList;
    Object localObject2;
    FabbyMvFilter localFabbyMvFilter;
    if (paramVideoMaterial.getFabbyParts() != null)
    {
      localObject1 = localArrayList;
      if (paramTriggerManager != null)
      {
        localArrayList = new ArrayList();
        Iterator localIterator = paramVideoMaterial.getFabbyParts().getParts().iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (FabbyMvPart)localIterator.next();
          localFabbyMvFilter = new FabbyMvFilter();
          if (((FabbyMvPart)localObject2).bgItem != null)
          {
            localFabbyMvFilter.bgRenderItem = VideoFilterFactory.createRenderItem(((FabbyMvPart)localObject2).bgItem, paramVideoMaterial.getDataPath(), paramTriggerManager);
            if ((((FabbyMvPart)localObject2).bgItem.name != null) && (((FabbyMvPart)localObject2).bgItem.name.endsWith("_360"))) {
              localFabbyMvFilter.bgRenderItem = create360FabbyMvBGRenderItem(((FabbyMvPart)localObject2).bgItem, paramVideoMaterial.getDataPath(), paramTriggerManager);
            }
          }
          if (((FabbyMvPart)localObject2).fgItem != null) {
            localFabbyMvFilter.fgRenderItem = VideoFilterFactory.createRenderItem(((FabbyMvPart)localObject2).fgItem, paramVideoMaterial.getDataPath(), paramTriggerManager);
          }
          if (((FabbyMvPart)localObject2).coverItem != null) {
            localFabbyMvFilter.coverRenderItem = VideoFilterFactory.createRenderItem(((FabbyMvPart)localObject2).coverItem, paramVideoMaterial.getDataPath(), paramTriggerManager);
          }
          if (!TextUtils.isEmpty(((FabbyMvPart)localObject2).lutFile))
          {
            localFabbyMvFilter.mEffectFilter = new GPUImageLookupFilter();
            localObject1 = BitmapUtils.decodeSampledBitmapFromFile(paramVideoMaterial.getDataPath() + File.separator + ((FabbyMvPart)localObject2).lutFile, 1);
            localFabbyMvFilter.mEffectFilter.addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", (Bitmap)localObject1, 33986, true));
            localFabbyMvFilter.mEffectFilter.setAdjustParam(1.0F - ((FabbyMvPart)localObject2).filterAlpha);
          }
        }
      }
    }
    label403:
    label806:
    label977:
    label978:
    for (;;)
    {
      if (!TextUtils.isEmpty(((FabbyMvPart)localObject2).bgLutFile))
      {
        localFabbyMvFilter.bgEffectFilter = new GPUImageLookupFilter();
        localObject1 = BitmapUtils.decodeSampledBitmapFromFile(paramVideoMaterial.getDataPath() + File.separator + ((FabbyMvPart)localObject2).bgLutFile, 1);
        localFabbyMvFilter.bgEffectFilter.addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", (Bitmap)localObject1, 33986, true));
        localFabbyMvFilter.bgEffectFilter.setAdjustParam(1.0F - ((FabbyMvPart)localObject2).bgFilterAlpha);
        if (TextUtils.isEmpty(((FabbyMvPart)localObject2).fgLutFile)) {
          break label731;
        }
        localFabbyMvFilter.cameraEffectFilter = new GPUImageLookupFilter();
        localObject1 = BitmapUtils.decodeSampledBitmapFromFile(paramVideoMaterial.getDataPath() + File.separator + ((FabbyMvPart)localObject2).fgLutFile, 1);
        localFabbyMvFilter.cameraEffectFilter.addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", (Bitmap)localObject1, 33986, true));
        localFabbyMvFilter.cameraEffectFilter.setAdjustParam(1.0F - ((FabbyMvPart)localObject2).fgFilterAlpha);
        label501:
        localFabbyMvFilter.mvPart = ((FabbyMvPart)localObject2);
        localObject1 = ((FabbyMvPart)localObject2).gridSettingMap.iterator();
        int i = 0;
        if (!((Iterator)localObject1).hasNext()) {
          break label806;
        }
        localObject2 = (Pair)((Iterator)localObject1).next();
        if (((GridSettingModel)((Pair)localObject2).second).canvasRectList.size() <= i) {
          break label977;
        }
        i = ((GridSettingModel)((Pair)localObject2).second).canvasRectList.size();
      }
      for (;;)
      {
        break label521;
        if (TextUtils.isEmpty(((FabbyMvPart)localObject2).filterId)) {
          break label978;
        }
        if (effectFilterProvider != null) {}
        for (localObject1 = effectFilterProvider.getFilter(((FabbyMvPart)localObject2).filterId);; localObject1 = FabbyFilterFactory.createFilter(((FabbyMvPart)localObject2).filterId))
        {
          localFabbyMvFilter.mEffectFilter = ((BaseFilter)localObject1);
          if (localFabbyMvFilter.mEffectFilter == null) {
            break;
          }
          localFabbyMvFilter.mEffectFilter.setAdjustParam(1.0F - ((FabbyMvPart)localObject2).filterAlpha);
          break;
        }
        if (TextUtils.isEmpty(((FabbyMvPart)localObject2).bgFilterId)) {
          break label403;
        }
        if (effectFilterProvider != null) {}
        for (localObject1 = effectFilterProvider.getFilter(((FabbyMvPart)localObject2).filterId);; localObject1 = FabbyFilterFactory.createFilter(((FabbyMvPart)localObject2).bgFilterId))
        {
          localFabbyMvFilter.bgEffectFilter = ((BaseFilter)localObject1);
          if (localFabbyMvFilter.bgEffectFilter == null) {
            break;
          }
          localFabbyMvFilter.bgEffectFilter.setAdjustParam(1.0F - ((FabbyMvPart)localObject2).bgFilterAlpha);
          break;
        }
        label731:
        if (TextUtils.isEmpty(((FabbyMvPart)localObject2).fgFilterId)) {
          break label501;
        }
        if (effectFilterProvider != null) {}
        for (localObject1 = effectFilterProvider.getFilter(((FabbyMvPart)localObject2).filterId);; localObject1 = FabbyFilterFactory.createFilter(((FabbyMvPart)localObject2).fgFilterId))
        {
          localFabbyMvFilter.cameraEffectFilter = ((BaseFilter)localObject1);
          if (localFabbyMvFilter.cameraEffectFilter == null) {
            break;
          }
          localFabbyMvFilter.cameraEffectFilter.setAdjustParam(1.0F - ((FabbyMvPart)localObject2).fgFilterAlpha);
          break;
        }
        localArrayList.add(localFabbyMvFilter);
        if (localFabbyMvFilter.mvPart.transitionItem == null) {
          break;
        }
        localObject1 = new TriggerCtrlItem(localFabbyMvFilter.mvPart.transitionItem);
        localHashMap.put(Integer.valueOf(localFabbyMvFilter.mvPart.partIndex), localObject1);
        break;
        localObject1 = new FabbyFilters(localArrayList, paramVideoMaterial.getDataPath(), paramVideoMaterial.getFabbyParts().getAudioFile());
        paramTriggerManager.addTriggersMvMap(localHashMap);
        if ((localObject1 != null) && (paramVideoMaterial.getMaskPaintType() != 0))
        {
          ((FabbyFilters)localObject1).setDoodlerMaskFilter(new BrushMaskFilter(paramVideoMaterial.getMaskPaintType(), paramVideoMaterial.getMaskPaintSize(), paramVideoMaterial.getDataPath() + File.separator + paramVideoMaterial.getMaskPaintImage()));
          ((FabbyFilters)localObject1).setDoodlerMaskRenderId(paramVideoMaterial.getMaskPaintRenderId());
        }
        return new RenderItem((AEFilterI)localObject1, new FabbyFiltersTriggerCtrlItem(localHashMap));
      }
    }
  }
  
  private static RenderItem createFaceCopyRenderItem(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    if (VideoMaterialUtil.isFaceCopyMaterial(paramVideoMaterial)) {}
    for (paramVideoMaterial = new FaceCopyFilter();; paramVideoMaterial = null) {
      return new RenderItem(paramVideoMaterial, null);
    }
  }
  
  private static RenderItem createFaceCropRenderItem(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    if ((paramVideoMaterial != null) && (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_CROP.value)) {}
    for (paramVideoMaterial = new FaceCropFilter(paramVideoMaterial);; paramVideoMaterial = null) {
      return new RenderItem(paramVideoMaterial, null);
    }
  }
  
  private static List<NormalVideoFilter> createFaceFilterList(VideoMaterial paramVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramVideoMaterial.getItemList() != null)
    {
      boolean bool = VideoMaterialUtil.canMaterialUseFastRender(paramVideoMaterial);
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      label135:
      while (localIterator.hasNext())
      {
        Object localObject = (StickerItem)localIterator.next();
        if ((VideoMaterialUtil.isFaceItem((StickerItem)localObject)) && (((StickerItem)localObject).particleConfig == null) && (((StickerItem)localObject).gpuParticleConfig == null) && ((!bool) || (!VideoMaterialUtil.canStickerItemUseFastRender((StickerItem)localObject))))
        {
          if (((StickerItem)localObject).type == VideoMaterialUtil.SHADER_TYPE.NORMAL_STATIC_COUNT_FILTER.value) {}
          for (localObject = new StaticCountFilter((StickerItem)localObject, paramVideoMaterial.getDataPath());; localObject = VideoFilterFactory.createFilter((StickerItem)localObject, paramVideoMaterial.getDataPath()))
          {
            if (localObject == null) {
              break label135;
            }
            localArrayList.add(localObject);
            break;
          }
        }
      }
    }
    return localArrayList;
  }
  
  private static List<RenderItem> createFaceGpuParticleRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramVideoMaterial.getItemList();
    if (!FeatureManager.Features.GPU_PARTICLE.isFunctionReady()) {
      return localArrayList;
    }
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        Object localObject = (StickerItem)localList.get(i);
        if ((((StickerItem)localObject).gpuParticleConfig != null) && (VideoMaterialUtil.isFaceItem((StickerItem)localObject)))
        {
          GPUParticleFilter localGPUParticleFilter = new GPUParticleFilter(paramVideoMaterial.getDataPath() + File.separator + ((StickerItem)localObject).id, (StickerItem)localObject);
          localObject = new TriggerCtrlItem((StickerItem)localObject);
          paramTriggerManager.addTriggers((AETriggerI)localObject);
          localArrayList.add(new RenderItem(localGPUParticleFilter, (TriggerCtrlItem)localObject));
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private static List<VideoFilterBase> createFaceOffFilter(VideoMaterial paramVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramVideoMaterial.getFaceOffItemList();
    if (localList == null) {
      return localArrayList;
    }
    int i = 0;
    if (i < localList.size())
    {
      Object localObject1 = (FaceItem)localList.get(i);
      if (paramVideoMaterial.getFaceoffType() == VideoMaterialUtil.FACE_OFF_TYPE.BY_IMAGE.value) {
        localObject1 = new FaceOffByImageFilter((FaceItem)localObject1);
      }
      for (;;)
      {
        localArrayList.add(localObject1);
        i += 1;
        break;
        if (((FaceItem)localObject1).is3DCos)
        {
          localObject1 = new FaceOff3DFilter((FaceItem)localObject1, paramVideoMaterial.getDataPath());
        }
        else
        {
          if (i == 0)
          {
            FaceOffFilterManager.getInstance().reset();
            FaceOffFilterManager.getInstance().setCosmeticChangeMode(paramVideoMaterial.getCosmeticChangeMode());
            FaceOffFilterManager.getInstance().setSwitch(paramVideoMaterial.getCosmeticShelterSwitchClose(), paramVideoMaterial.getCosmeticChangeSwitch());
          }
          FaceOffFilter localFaceOffFilter = new FaceOffFilter((FaceItem)localObject1, paramVideoMaterial.getDataPath());
          Object localObject2 = VideoMaterialUtil.loadFaceOffVertexShader(paramVideoMaterial.getDataPath());
          String str = VideoMaterialUtil.loadFaceOffFragmentShader(paramVideoMaterial.getDataPath());
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (!TextUtils.isEmpty(str)))
          {
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nattribute vec2 inputGrayTextureCoordinate;\nattribute vec2 inputModelTextureCoordinate;\nattribute float pointsVisValue;\nattribute float opacity;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvarying vec2 modelTextureCoordinate;\nvarying float pointVisValue;\nvarying float opacityValue;\n\nuniform vec2 canvasSize;\nuniform float positionRotate;\n\nvoid main(){\n    vec4 framePos = position;\n\n    gl_Position = framePos;\n    canvasCoordinate = vec2(framePos.x * 0.5 + 0.5, framePos.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n    grayTextureCoordinate = inputGrayTextureCoordinate;\n    modelTextureCoordinate = inputModelTextureCoordinate;\n    pointVisValue = pointsVisValue;\n    opacityValue = opacity;\n}\n";
            }
            localObject2 = str;
            if (TextUtils.isEmpty(str)) {
              localObject2 = "//Need Sync FaceOffFragmentShaderExt.dat\n\nprecision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvarying vec2 modelTextureCoordinate;\nvarying float pointVisValue;\nvarying float opacityValue;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\nuniform sampler2D inputImageTexture5;\nuniform sampler2D inputImageTexture6;\nuniform sampler2D inputImageTexture7;\n\nuniform float alpha;\nuniform int enableFaceOff;\nuniform float enableNoseOcclusion;\nuniform float enableAlphaFromGray;\nuniform float enableAlphaFromGrayNew;\nuniform int blendMode;\nuniform int blendIris;\nuniform float level1;\nuniform float level2;\n\nuniform vec2 size;\nuniform vec2 center1;\nuniform vec2 center2;\nuniform float radius1;\nuniform float radius2;\n\nuniform int leftEyeClosed; // deprecated\nuniform int rightEyeClosed; // deprecated\nuniform float leftEyeCloseAlpha;\nuniform float rightEyeCloseAlpha;\nuniform float useMaterialLipsMask;\nuniform float useLipsRGBA;\nuniform vec4 lipsRGBA; \n\nvec3 blendColorWithMode(vec4 texColor, vec4 canvasColor, int colorBlendMode)\n{\n    vec3 vOne = vec3(1.0, 1.0, 1.0);\n    vec3 vZero = vec3(0.0, 0.0, 0.0);\n    vec3 resultFore = texColor.rgb;\n    if (colorBlendMode <= 1){ //default, since used most, put on top\n\n    } else if (colorBlendMode == 2) {  //multiply\n        resultFore = canvasColor.rgb * texColor.rgb;\n    } else if (colorBlendMode == 3){    //screen\n        resultFore = vOne - (vOne - canvasColor.rgb) * (vOne - texColor.rgb);\n    } else if (colorBlendMode == 4){    //overlay\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n        if (canvasColor.r >= 0.5) {\n            resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n        }\n        if (canvasColor.g >= 0.5) {\n            resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n        }\n        if (canvasColor.b >= 0.5) {\n            resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n        }\n    } else if (colorBlendMode == 5){    //hardlight\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n        if (texColor.r >= 0.5) {\n            resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n        }\n        if (texColor.g >= 0.5) {\n            resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n        }\n        if (texColor.b >= 0.5) {\n            resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n        }\n    } else if (colorBlendMode == 6){    //softlight\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n        if (texColor.r >= 0.5) {\n            resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n        }\n        if (texColor.g >= 0.5) {\n            resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n        }\n        if (texColor.b >= 0.5) {\n            resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n        }\n    } else if (colorBlendMode == 7){    //divide\n        resultFore = vOne;\n        if (texColor.r > 0.0) {\n            resultFore.r = canvasColor.r / texColor.r;\n        }\n        if (texColor.g > 0.0) {\n            resultFore.g = canvasColor.g / texColor.g;\n        }\n        if (texColor.b > 0.0) {\n            resultFore.b = canvasColor.b / texColor.b;\n        }\n        resultFore = min(vOne, resultFore);\n    } else if (colorBlendMode == 8){    //add\n        resultFore = canvasColor.rgb + texColor.rgb;\n        resultFore = min(vOne, resultFore);\n    } else if (colorBlendMode == 9){    //substract\n        resultFore = canvasColor.rgb - texColor.rgb;\n        resultFore = max(vZero, resultFore);\n    } else if (colorBlendMode == 10){   //diff\n        resultFore = abs(canvasColor.rgb - texColor.rgb);\n    } else if (colorBlendMode == 11){   //darken\n        resultFore = min(canvasColor.rgb, texColor.rgb);\n    } else if (blendMode == 12){   //lighten\n        resultFore = max(canvasColor.rgb, texColor.rgb);\n    }\n    return resultFore;\n}\n\nvec4 blendColor(vec4 texColor, vec4 canvasColor) {\n    vec3 vOne = vec3(1.0, 1.0, 1.0);\n    vec3 vZero = vec3(0.0, 0.0, 0.0);\n    //revert pre multiply\n    if(texColor.a > 0.0){\n       texColor.rgb = texColor.rgb / texColor.a;\n    }\n    vec3 resultFore = texColor.rgb;\n    if (blendMode <= 12) {\n        resultFore = blendColorWithMode(texColor, canvasColor, blendMode);\n    } else if (blendMode == 13){   //highlight for lips\n        if (texColor.a > 0.0001) {\n            if(canvasColor.r >= level1) {\n                texColor.rgb = vec3(1.0, 1.0, 1.0);\n                //if(canvasColor.r < 0.6) {\n                   canvasColor.rgb = canvasColor.rgb + (vOne - canvasColor.rgb) * 0.05;\n                //}\n            } else if (canvasColor.r >= level2) {\n               if (level1 > level2) {\n                   float f = (canvasColor.r - level2) / (level1 - level2);\n                   texColor.rgb = texColor.rgb + (vOne - texColor.rgb) * f;\n                   canvasColor.rgb = canvasColor.rgb + (vOne - canvasColor.rgb) * 0.05 * f;\n               }\n            }\n        }\n        resultFore = canvasColor.rgb * texColor.rgb;\n        resultFore = clamp(resultFore, 0.0001, 0.9999);\n    } else if (blendMode == 14){   // iris\n         vec2 curPos = vec2(canvasCoordinate.x * size.x, canvasCoordinate.y * size.y);\n         float dist1 = sqrt((curPos.x - center1.x) * (curPos.x - center1.x) + (curPos.y - center1.y) * (curPos.y - center1.y));\n         float dist2 = sqrt((curPos.x - center2.x) * (curPos.x - center2.x) + (curPos.y - center2.y) * (curPos.y - center2.y));\n         if (dist1 < radius1 && leftEyeCloseAlpha >= 0.01) {\n             float _x = (curPos.x - center1.x) / radius1 / 2.0;\n             float _y = (curPos.y - center1.y) / radius1 / 2.0;\n             vec4 irisColor = texture2D(inputImageTexture4, vec2(_x * 0.72 + 0.5, _y * 0.72 + 0.5));\n             if (irisColor.a > 0.0) {\n                 irisColor = irisColor / vec4(irisColor.a, irisColor.a, irisColor.a, 1.0);\n             }\n             resultFore = blendColorWithMode(irisColor, canvasColor, blendIris);\n             texColor.a = texColor.a * irisColor.a * leftEyeCloseAlpha;\n         } else if (dist2 < radius2 && rightEyeCloseAlpha >= 0.01) {\n             float _x = (curPos.x - center2.x) / radius2 / 2.0;\n             float _y = (curPos.y - center2.y) / radius2 / 2.0;\n             vec4 irisColor = texture2D(inputImageTexture4, vec2(_x * 0.72 + 0.5, _y * 0.72 + 0.5));\n             if (irisColor.a > 0.0) {\n                 irisColor = irisColor / vec4(irisColor.a, irisColor.a, irisColor.a, 1.0);\n             }\n             resultFore = blendColorWithMode(irisColor, canvasColor, blendIris);\n             texColor.a = texColor.a * irisColor.a * rightEyeCloseAlpha;\n         } else {\n            texColor.a = 0.0;\n         }\n         //resultFore = texColor.rgb;\n         //texColor.a = 1.0;\n    }\n    //pre multiply for glBlendFunc\n    vec4 resultColor = vec4(resultFore * texColor.a, texColor.a);\n    return resultColor;\n}\n\nvoid main(void) {\n    vec4 canvasColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 texColor = texture2D(inputImageTexture2, textureCoordinate);\n\n    float grayAlpha = 1.0; \n    if (texColor.a > 0.0) {\n        texColor = texColor / vec4(texColor.a, texColor.a, texColor.a, 1.0);\n    }\n    if(enableAlphaFromGray > 0.0){\n        vec4 grayColor = texture2D(inputImageTexture3, grayTextureCoordinate);\n        grayAlpha = 1.0 - grayColor.g;\n    }\n    if (useMaterialLipsMask > 0.0) { \n        vec4 lipsColor = texture2D(inputImageTexture5, modelTextureCoordinate);\n        if (lipsColor.g > 0.01) { \n           texColor = mix(texColor, lipsRGBA, useLipsRGBA); \n           grayAlpha = mix(lipsColor.g, lipsColor.r, enableAlphaFromGrayNew); \n        } \n    } \n    texColor.a = texColor.a * alpha * grayAlpha; \n\n    float confidence = smoothstep(0.7, 1.0, pointVisValue) * opacityValue;\n\n    texColor.a = texColor.a * confidence;\n\n        vec4 screenNoseColor = texture2D(inputImageTexture7, canvasCoordinate);\n        texColor.a = texColor.a * mix(1.0, screenNoseColor.a, enableNoseOcclusion); \n\n//    if(confidence >= 0.0){\n//            texColor.a = texColor.a * confidence;\n//    }\n\n    texColor.rgb = texColor.rgb * texColor.a;\n\n    gl_FragColor = blendColor(texColor, canvasColor);\n    //gl_FragColor = vec4(canvasColor.rgb * opacityValue, 1.0);\n }\n";
            }
            localFaceOffFilter.updateFilterShader((String)localObject1, (String)localObject2);
          }
          localObject1 = localFaceOffFilter;
        }
      }
    }
    return localArrayList;
  }
  
  private static List<RenderItem> createFaceOffRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramVideoMaterial.getFaceOffItemList();
    if (localList == null) {
      return localArrayList;
    }
    int i = 0;
    if (i < localList.size())
    {
      Object localObject1 = (FaceItem)localList.get(i);
      Object localObject2;
      if (paramVideoMaterial.getFaceoffType() == VideoMaterialUtil.FACE_OFF_TYPE.BY_IMAGE.value)
      {
        localObject2 = new FaceOffByImageFilter((FaceItem)localObject1);
        localObject1 = null;
      }
      for (;;)
      {
        paramTriggerManager.addTriggers((AETriggerI)localObject1);
        localArrayList.add(new RenderItem((AEFilterI)localObject2, (TriggerCtrlItem)localObject1));
        i += 1;
        break;
        if (((FaceItem)localObject1).is3DCos)
        {
          localObject2 = new FaceOff3DFilter((FaceItem)localObject1, paramVideoMaterial.getDataPath());
          localObject1 = new TriggerCtrlItem((FaceItem)localObject1);
        }
        else
        {
          if (i == 0)
          {
            FaceOffFilterManager.getInstance().reset();
            FaceOffFilterManager.getInstance().setCosmeticChangeMode(paramVideoMaterial.getCosmeticChangeMode());
            FaceOffFilterManager.getInstance().setSwitch(paramVideoMaterial.getCosmeticShelterSwitchClose(), paramVideoMaterial.getCosmeticChangeSwitch());
          }
          FaceOffFilter localFaceOffFilter = new FaceOffFilter((FaceItem)localObject1, paramVideoMaterial.getDataPath());
          TriggerCtrlItem localTriggerCtrlItem = new TriggerCtrlItem((FaceItem)localObject1);
          localObject2 = VideoMaterialUtil.loadFaceOffVertexShader(paramVideoMaterial.getDataPath());
          String str = VideoMaterialUtil.loadFaceOffFragmentShader(paramVideoMaterial.getDataPath());
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (!TextUtils.isEmpty(str)))
          {
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nattribute vec2 inputGrayTextureCoordinate;\nattribute vec2 inputModelTextureCoordinate;\nattribute float pointsVisValue;\nattribute float opacity;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvarying vec2 modelTextureCoordinate;\nvarying float pointVisValue;\nvarying float opacityValue;\n\nuniform vec2 canvasSize;\nuniform float positionRotate;\n\nvoid main(){\n    vec4 framePos = position;\n\n    gl_Position = framePos;\n    canvasCoordinate = vec2(framePos.x * 0.5 + 0.5, framePos.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n    grayTextureCoordinate = inputGrayTextureCoordinate;\n    modelTextureCoordinate = inputModelTextureCoordinate;\n    pointVisValue = pointsVisValue;\n    opacityValue = opacity;\n}\n";
            }
            localObject2 = str;
            if (TextUtils.isEmpty(str)) {
              localObject2 = "//Need Sync FaceOffFragmentShaderExt.dat\n\nprecision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvarying vec2 modelTextureCoordinate;\nvarying float pointVisValue;\nvarying float opacityValue;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\nuniform sampler2D inputImageTexture5;\nuniform sampler2D inputImageTexture6;\nuniform sampler2D inputImageTexture7;\n\nuniform float alpha;\nuniform int enableFaceOff;\nuniform float enableNoseOcclusion;\nuniform float enableAlphaFromGray;\nuniform float enableAlphaFromGrayNew;\nuniform int blendMode;\nuniform int blendIris;\nuniform float level1;\nuniform float level2;\n\nuniform vec2 size;\nuniform vec2 center1;\nuniform vec2 center2;\nuniform float radius1;\nuniform float radius2;\n\nuniform int leftEyeClosed; // deprecated\nuniform int rightEyeClosed; // deprecated\nuniform float leftEyeCloseAlpha;\nuniform float rightEyeCloseAlpha;\nuniform float useMaterialLipsMask;\nuniform float useLipsRGBA;\nuniform vec4 lipsRGBA; \n\nvec3 blendColorWithMode(vec4 texColor, vec4 canvasColor, int colorBlendMode)\n{\n    vec3 vOne = vec3(1.0, 1.0, 1.0);\n    vec3 vZero = vec3(0.0, 0.0, 0.0);\n    vec3 resultFore = texColor.rgb;\n    if (colorBlendMode <= 1){ //default, since used most, put on top\n\n    } else if (colorBlendMode == 2) {  //multiply\n        resultFore = canvasColor.rgb * texColor.rgb;\n    } else if (colorBlendMode == 3){    //screen\n        resultFore = vOne - (vOne - canvasColor.rgb) * (vOne - texColor.rgb);\n    } else if (colorBlendMode == 4){    //overlay\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n        if (canvasColor.r >= 0.5) {\n            resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n        }\n        if (canvasColor.g >= 0.5) {\n            resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n        }\n        if (canvasColor.b >= 0.5) {\n            resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n        }\n    } else if (colorBlendMode == 5){    //hardlight\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n        if (texColor.r >= 0.5) {\n            resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n        }\n        if (texColor.g >= 0.5) {\n            resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n        }\n        if (texColor.b >= 0.5) {\n            resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n        }\n    } else if (colorBlendMode == 6){    //softlight\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n        if (texColor.r >= 0.5) {\n            resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n        }\n        if (texColor.g >= 0.5) {\n            resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n        }\n        if (texColor.b >= 0.5) {\n            resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n        }\n    } else if (colorBlendMode == 7){    //divide\n        resultFore = vOne;\n        if (texColor.r > 0.0) {\n            resultFore.r = canvasColor.r / texColor.r;\n        }\n        if (texColor.g > 0.0) {\n            resultFore.g = canvasColor.g / texColor.g;\n        }\n        if (texColor.b > 0.0) {\n            resultFore.b = canvasColor.b / texColor.b;\n        }\n        resultFore = min(vOne, resultFore);\n    } else if (colorBlendMode == 8){    //add\n        resultFore = canvasColor.rgb + texColor.rgb;\n        resultFore = min(vOne, resultFore);\n    } else if (colorBlendMode == 9){    //substract\n        resultFore = canvasColor.rgb - texColor.rgb;\n        resultFore = max(vZero, resultFore);\n    } else if (colorBlendMode == 10){   //diff\n        resultFore = abs(canvasColor.rgb - texColor.rgb);\n    } else if (colorBlendMode == 11){   //darken\n        resultFore = min(canvasColor.rgb, texColor.rgb);\n    } else if (blendMode == 12){   //lighten\n        resultFore = max(canvasColor.rgb, texColor.rgb);\n    }\n    return resultFore;\n}\n\nvec4 blendColor(vec4 texColor, vec4 canvasColor) {\n    vec3 vOne = vec3(1.0, 1.0, 1.0);\n    vec3 vZero = vec3(0.0, 0.0, 0.0);\n    //revert pre multiply\n    if(texColor.a > 0.0){\n       texColor.rgb = texColor.rgb / texColor.a;\n    }\n    vec3 resultFore = texColor.rgb;\n    if (blendMode <= 12) {\n        resultFore = blendColorWithMode(texColor, canvasColor, blendMode);\n    } else if (blendMode == 13){   //highlight for lips\n        if (texColor.a > 0.0001) {\n            if(canvasColor.r >= level1) {\n                texColor.rgb = vec3(1.0, 1.0, 1.0);\n                //if(canvasColor.r < 0.6) {\n                   canvasColor.rgb = canvasColor.rgb + (vOne - canvasColor.rgb) * 0.05;\n                //}\n            } else if (canvasColor.r >= level2) {\n               if (level1 > level2) {\n                   float f = (canvasColor.r - level2) / (level1 - level2);\n                   texColor.rgb = texColor.rgb + (vOne - texColor.rgb) * f;\n                   canvasColor.rgb = canvasColor.rgb + (vOne - canvasColor.rgb) * 0.05 * f;\n               }\n            }\n        }\n        resultFore = canvasColor.rgb * texColor.rgb;\n        resultFore = clamp(resultFore, 0.0001, 0.9999);\n    } else if (blendMode == 14){   // iris\n         vec2 curPos = vec2(canvasCoordinate.x * size.x, canvasCoordinate.y * size.y);\n         float dist1 = sqrt((curPos.x - center1.x) * (curPos.x - center1.x) + (curPos.y - center1.y) * (curPos.y - center1.y));\n         float dist2 = sqrt((curPos.x - center2.x) * (curPos.x - center2.x) + (curPos.y - center2.y) * (curPos.y - center2.y));\n         if (dist1 < radius1 && leftEyeCloseAlpha >= 0.01) {\n             float _x = (curPos.x - center1.x) / radius1 / 2.0;\n             float _y = (curPos.y - center1.y) / radius1 / 2.0;\n             vec4 irisColor = texture2D(inputImageTexture4, vec2(_x * 0.72 + 0.5, _y * 0.72 + 0.5));\n             if (irisColor.a > 0.0) {\n                 irisColor = irisColor / vec4(irisColor.a, irisColor.a, irisColor.a, 1.0);\n             }\n             resultFore = blendColorWithMode(irisColor, canvasColor, blendIris);\n             texColor.a = texColor.a * irisColor.a * leftEyeCloseAlpha;\n         } else if (dist2 < radius2 && rightEyeCloseAlpha >= 0.01) {\n             float _x = (curPos.x - center2.x) / radius2 / 2.0;\n             float _y = (curPos.y - center2.y) / radius2 / 2.0;\n             vec4 irisColor = texture2D(inputImageTexture4, vec2(_x * 0.72 + 0.5, _y * 0.72 + 0.5));\n             if (irisColor.a > 0.0) {\n                 irisColor = irisColor / vec4(irisColor.a, irisColor.a, irisColor.a, 1.0);\n             }\n             resultFore = blendColorWithMode(irisColor, canvasColor, blendIris);\n             texColor.a = texColor.a * irisColor.a * rightEyeCloseAlpha;\n         } else {\n            texColor.a = 0.0;\n         }\n         //resultFore = texColor.rgb;\n         //texColor.a = 1.0;\n    }\n    //pre multiply for glBlendFunc\n    vec4 resultColor = vec4(resultFore * texColor.a, texColor.a);\n    return resultColor;\n}\n\nvoid main(void) {\n    vec4 canvasColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 texColor = texture2D(inputImageTexture2, textureCoordinate);\n\n    float grayAlpha = 1.0; \n    if (texColor.a > 0.0) {\n        texColor = texColor / vec4(texColor.a, texColor.a, texColor.a, 1.0);\n    }\n    if(enableAlphaFromGray > 0.0){\n        vec4 grayColor = texture2D(inputImageTexture3, grayTextureCoordinate);\n        grayAlpha = 1.0 - grayColor.g;\n    }\n    if (useMaterialLipsMask > 0.0) { \n        vec4 lipsColor = texture2D(inputImageTexture5, modelTextureCoordinate);\n        if (lipsColor.g > 0.01) { \n           texColor = mix(texColor, lipsRGBA, useLipsRGBA); \n           grayAlpha = mix(lipsColor.g, lipsColor.r, enableAlphaFromGrayNew); \n        } \n    } \n    texColor.a = texColor.a * alpha * grayAlpha; \n\n    float confidence = smoothstep(0.7, 1.0, pointVisValue) * opacityValue;\n\n    texColor.a = texColor.a * confidence;\n\n        vec4 screenNoseColor = texture2D(inputImageTexture7, canvasCoordinate);\n        texColor.a = texColor.a * mix(1.0, screenNoseColor.a, enableNoseOcclusion); \n\n//    if(confidence >= 0.0){\n//            texColor.a = texColor.a * confidence;\n//    }\n\n    texColor.rgb = texColor.rgb * texColor.a;\n\n    gl_FragColor = blendColor(texColor, canvasColor);\n    //gl_FragColor = vec4(canvasColor.rgb * opacityValue, 1.0);\n }\n";
            }
            localFaceOffFilter.updateFilterShader((String)localObject1, (String)localObject2);
          }
          localObject1 = localTriggerCtrlItem;
          localObject2 = localFaceOffFilter;
        }
      }
    }
    return localArrayList;
  }
  
  private static List<RenderItem> createFaceParticleRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramVideoMaterial.getItemList();
    if (localList != null)
    {
      int i = 0;
      if (i < localList.size())
      {
        Object localObject1 = (StickerItem)localList.get(i);
        Object localObject2;
        if ((((StickerItem)localObject1).particleConfig != null) && (VideoMaterialUtil.isFaceItem((StickerItem)localObject1)))
        {
          if (!((StickerItem)localObject1).dexName.endsWith("json")) {
            break label159;
          }
          localObject2 = new ParticleFilter3D(paramVideoMaterial.getDataPath() + File.separator + ((StickerItem)localObject1).id, (StickerItem)localObject1);
          localObject1 = new TriggerCtrlItem((StickerItem)localObject1);
          paramTriggerManager.addTriggers((AETriggerI)localObject1);
          localArrayList.add(new RenderItem((AEFilterI)localObject2, (TriggerCtrlItem)localObject1));
        }
        for (;;)
        {
          i += 1;
          break;
          label159:
          localObject2 = new ParticleFilter(paramVideoMaterial.getDataPath() + File.separator + ((StickerItem)localObject1).id, (StickerItem)localObject1);
          localObject1 = new TriggerCtrlItem((StickerItem)localObject1);
          paramTriggerManager.addTriggers((AETriggerI)localObject1);
          localArrayList.add(new RenderItem((AEFilterI)localObject2, (TriggerCtrlItem)localObject1));
        }
      }
    }
    return localArrayList;
  }
  
  private static List<RenderItem> createFaceRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramVideoMaterial.getItemList() != null)
    {
      boolean bool = VideoMaterialUtil.canMaterialUseFastRender(paramVideoMaterial);
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      label171:
      while (localIterator.hasNext())
      {
        Object localObject2 = (StickerItem)localIterator.next();
        if ((VideoMaterialUtil.isFaceItem((StickerItem)localObject2)) && (((StickerItem)localObject2).particleConfig == null) && (((StickerItem)localObject2).gpuParticleConfig == null) && ((!bool) || (!VideoMaterialUtil.canStickerItemUseFastRender((StickerItem)localObject2))))
        {
          if (((StickerItem)localObject2).type == VideoMaterialUtil.SHADER_TYPE.NORMAL_STATIC_COUNT_FILTER.value) {}
          for (Object localObject1 = new StaticCountFilter((StickerItem)localObject2, paramVideoMaterial.getDataPath());; localObject1 = VideoFilterFactory.createFilter((StickerItem)localObject2, paramVideoMaterial.getDataPath()))
          {
            if (localObject1 == null) {
              break label171;
            }
            localObject2 = new TriggerCtrlItem((StickerItem)localObject2);
            paramTriggerManager.addTriggers((AETriggerI)localObject2);
            localArrayList.add(new RenderItem((AEFilterI)localObject1, (TriggerCtrlItem)localObject2));
            break;
          }
        }
      }
    }
    return localArrayList;
  }
  
  private static RenderItem createFaceSwitchRenderItem(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    if (VideoMaterialUtil.isFaceSwitchMaterial(paramVideoMaterial)) {}
    for (paramVideoMaterial = new SwitchFaceFilter();; paramVideoMaterial = null) {
      return new RenderItem(paramVideoMaterial, null);
    }
  }
  
  private static List<FacialFeatureFilter> createFacialFeatureFilters(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList1 = new ArrayList();
    if ((paramVideoMaterial == null) || (paramVideoMaterial.getFaceFeatureItemList() == null)) {
      return null;
    }
    Iterator localIterator = paramVideoMaterial.getFaceFeatureItemList().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (FaceFeatureItem)localIterator.next();
      if ((((FaceFeatureItem)localObject1).getFaceOffItemList() != null) && (!((FaceFeatureItem)localObject1).getFaceOffItemList().isEmpty()))
      {
        Object localObject2 = ((FaceFeatureItem)localObject1).getStickerItems();
        localObject1 = new FacialFeatureFilter((FaceItem)((FaceFeatureItem)localObject1).getFaceOffItemList().get(0), ((FaceFeatureItem)localObject1).getDistortionItemList(), (FaceFeatureItem)localObject1);
        ArrayList localArrayList2 = new ArrayList();
        if (!CollectionUtils.isEmpty((Collection)localObject2))
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            StickerItem localStickerItem = (StickerItem)((Iterator)localObject2).next();
            if (localStickerItem != null)
            {
              NormalVideoFilter localNormalVideoFilter = VideoFilterFactory.createFilter(localStickerItem, paramVideoMaterial.getDataPath());
              TriggerCtrlItem localTriggerCtrlItem = new TriggerCtrlItem(localStickerItem);
              paramTriggerManager.addTriggers(localTriggerCtrlItem);
              if (localNormalVideoFilter != null) {
                localArrayList2.add(new RenderItem(localNormalVideoFilter, localTriggerCtrlItem));
              }
              if (localStickerItem.charmRange != null) {
                if ((localStickerItem.type == VideoFilterFactory.POSITION_TYPE.GESTURE.type) || (VideoMaterialUtil.isGestureTriggerType(localStickerItem.getTriggerTypeInt())))
                {
                  paramVideoMaterial.setHandCharmRangeMaterial(true);
                  ((FacialFeatureFilter)localObject1).addCharmGesttureType(localStickerItem.getTriggerTypeInt());
                }
                else
                {
                  paramVideoMaterial.setFaceCharmRangeMaterial(true);
                }
              }
            }
          }
        }
        ((FacialFeatureFilter)localObject1).setStickerRenderItems(localArrayList2);
        localArrayList1.add(localObject1);
      }
    }
    return localArrayList1;
  }
  
  private static FastStickerFilter createFastBodyStickerFilter(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial.getItemList() != null)
    {
      if (!VideoMaterialUtil.canMaterialUseFastRender(paramVideoMaterial)) {
        return null;
      }
      FastStickerFilter localFastStickerFilter = new FastStickerFilter();
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)localIterator.next();
        if ((VideoMaterialUtil.isBodyDetectItem(localStickerItem)) && (VideoMaterialUtil.canStickerItemUseFastBodyRender(localStickerItem))) {
          localFastStickerFilter.addSticker(localStickerItem, paramVideoMaterial.getDataPath());
        }
      }
      if (localFastStickerFilter.getStickerListSize() > 0) {
        return localFastStickerFilter;
      }
    }
    return null;
  }
  
  private static RenderItem createFastBodyStickerRenderItem(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    if ((paramVideoMaterial.getItemList() != null) && (paramTriggerManager != null))
    {
      if (!VideoMaterialUtil.canMaterialUseFastRender(paramVideoMaterial)) {
        return null;
      }
      FastStickerFilter localFastStickerFilter = new FastStickerFilter();
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)localIterator.next();
        if ((VideoMaterialUtil.isBodyDetectItem(localStickerItem)) && (VideoMaterialUtil.canStickerItemUseFastBodyRender(localStickerItem)))
        {
          TriggerCtrlItem localTriggerCtrlItem = new TriggerCtrlItem(localStickerItem);
          localHashMap.put(localStickerItem.id + localStickerItem.hashCode(), localTriggerCtrlItem);
          localFastStickerFilter.addSticker(localStickerItem, paramVideoMaterial.getDataPath());
        }
      }
      if (localFastStickerFilter.getStickerListSize() > 0)
      {
        localFastStickerFilter.setTriggerCtrlItemMap(localHashMap);
        paramTriggerManager.addTriggersMap(localHashMap);
        return new RenderItem(localFastStickerFilter, null);
      }
    }
    return null;
  }
  
  private static FastStickerFilter createFastFaceStickerFilter(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial.getItemList() != null)
    {
      if (!VideoMaterialUtil.canMaterialUseFastRender(paramVideoMaterial)) {
        return null;
      }
      FastStickerFilter localFastStickerFilter = new FastStickerFilter();
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)localIterator.next();
        if ((VideoMaterialUtil.isFaceItem(localStickerItem)) && (VideoMaterialUtil.canStickerItemUseFastFaceRender(localStickerItem))) {
          localFastStickerFilter.addSticker(localStickerItem, paramVideoMaterial.getDataPath());
        }
      }
      if (localFastStickerFilter.getStickerListSize() > 0) {
        return localFastStickerFilter;
      }
    }
    return null;
  }
  
  private static RenderItem createFastFaceStickerRenderItem(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    if ((paramVideoMaterial.getItemList() != null) && (paramTriggerManager != null))
    {
      if (!VideoMaterialUtil.canMaterialUseFastRender(paramVideoMaterial)) {
        return null;
      }
      FastStickerFilter localFastStickerFilter = new FastStickerFilter();
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)localIterator.next();
        if ((VideoMaterialUtil.isFaceItem(localStickerItem)) && (VideoMaterialUtil.canStickerItemUseFastFaceRender(localStickerItem)))
        {
          TriggerCtrlItem localTriggerCtrlItem = new TriggerCtrlItem(localStickerItem);
          localHashMap.put(localStickerItem.id + localStickerItem.hashCode(), localTriggerCtrlItem);
          localFastStickerFilter.addSticker(localStickerItem, paramVideoMaterial.getDataPath());
        }
      }
      if (localFastStickerFilter.getStickerListSize() > 0)
      {
        localFastStickerFilter.setTriggerCtrlItemMap(localHashMap);
        paramTriggerManager.addTriggersMap(localHashMap);
        return new RenderItem(localFastStickerFilter, null);
      }
    }
    return null;
  }
  
  private static FilamentParticleFilter createFilamentParticleFilter(VideoMaterial paramVideoMaterial)
  {
    FilamentParticleFilter localFilamentParticleFilter = null;
    if (VideoMaterialUtil.isFilamentParticleMaterial(paramVideoMaterial)) {
      localFilamentParticleFilter = new FilamentParticleFilter(paramVideoMaterial.getFilamentParticleList(), paramVideoMaterial.getDataPath());
    }
    return localFilamentParticleFilter;
  }
  
  private static RenderItem createFilamentRenderItem(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    if ((!VideoMaterialUtil.isFilamentMaterial(paramVideoMaterial)) || (!FeatureManager.Features.ACE_3D_ENGINE.isFunctionReady()) || (paramTriggerManager == null))
    {
      LogUtils.d("glb", "glb test stage 4");
      return null;
    }
    FilamentFilter localFilamentFilter = new FilamentFilter(paramVideoMaterial, paramTriggerManager);
    FilamentTriggerCtrlItem localFilamentTriggerCtrlItem = new FilamentTriggerCtrlItem();
    ArrayList localArrayList = new ArrayList();
    paramVideoMaterial = paramVideoMaterial.getGlbList().iterator();
    while (paramVideoMaterial.hasNext())
    {
      Object localObject = ((GLBItemJava)paramVideoMaterial.next()).animationList;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          AnimationItem localAnimationItem = (AnimationItem)((Iterator)localObject).next();
          localArrayList.add(localAnimationItem.name);
          TriggerCtrlItem localTriggerCtrlItem = new TriggerCtrlItem(localAnimationItem);
          localFilamentTriggerCtrlItem.addTriggerCtrlItems(localTriggerCtrlItem);
          paramTriggerManager.addTriggers(localTriggerCtrlItem);
          if (localAnimationItem.isDefault == 1) {
            localFilamentFilter.setDefaultAnimation(localAnimationItem.name, localAnimationItem.playCount);
          }
        }
      }
    }
    localFilamentFilter.setAnimationItemNames(localArrayList);
    return new RenderItem(localFilamentFilter, localFilamentTriggerCtrlItem);
  }
  
  public static VideoFilterList createFilters(VideoMaterial paramVideoMaterial)
  {
    tnnMaterialReportInfo.reset();
    paramVideoMaterial = doMaterialDownGrade(paramVideoMaterial);
    if (paramVideoMaterial != null)
    {
      if (paramVideoMaterial.hasFilterList()) {}
      for (paramVideoMaterial = createFiltersForQQ(paramVideoMaterial);; paramVideoMaterial = createFiltersForPitu(paramVideoMaterial))
      {
        if (paramVideoMaterial != null) {
          reportTNNInfo();
        }
        return paramVideoMaterial;
      }
    }
    return null;
  }
  
  public static VideoFilterList createFiltersForPitu(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {
      return null;
    }
    TriggerManager localTriggerManager = new TriggerManager();
    List localList1 = createStyleChildRenderItems(paramVideoMaterial, localTriggerManager);
    RenderItem localRenderItem1 = createLutRenderItem(paramVideoMaterial, localTriggerManager);
    RenderItem localRenderItem2 = createSkyboxRenderItem(paramVideoMaterial, localTriggerManager);
    RenderItem localRenderItem3 = createCustomRenderItem(paramVideoMaterial, localTriggerManager);
    RenderItem localRenderItem4 = createCustomVertexRenderItem(paramVideoMaterial, localTriggerManager);
    RenderItem localRenderItem5 = createSnakeFaceRenderItem(paramVideoMaterial, localTriggerManager);
    Object localObject2 = createFaceOffRenderItems(paramVideoMaterial, localTriggerManager);
    List localList2 = createTransformRenderItems(paramVideoMaterial, localTriggerManager);
    List localList3 = createBeautyTransformListRenderItems(paramVideoMaterial, localTriggerManager);
    List localList4 = createRemodelRenderItems(paramVideoMaterial, localTriggerManager);
    RenderItem localRenderItem6 = createFaceSwitchRenderItem(paramVideoMaterial, localTriggerManager);
    RenderItem localRenderItem7 = createFaceCopyRenderItem(paramVideoMaterial, localTriggerManager);
    RenderItem localRenderItem8 = createDoodleRenderItem(paramVideoMaterial, localTriggerManager);
    List localList5 = createThreeDimRenderItem(paramVideoMaterial, localTriggerManager);
    RenderItem localRenderItem9 = createBuckleFaceRenderItem(paramVideoMaterial, localTriggerManager);
    if ((localRenderItem9 == null) || (localRenderItem9.filter == null)) {}
    for (Object localObject1 = createFaceCropRenderItem(paramVideoMaterial, localTriggerManager);; localObject1 = null)
    {
      RenderItem localRenderItem12 = createHeadCropRenderItem(paramVideoMaterial, localTriggerManager);
      List localList18 = createHeadCropRenderItems(paramVideoMaterial, localTriggerManager);
      List localList19 = createFaceRenderItems(paramVideoMaterial, localTriggerManager);
      List localList6 = createGestureRenderItems(paramVideoMaterial, localTriggerManager);
      List localList7 = createCatRenderItems(paramVideoMaterial, localTriggerManager);
      List localList8 = createBodyRenderItems(paramVideoMaterial, localTriggerManager);
      List localList9 = createMultiViewerFilters(paramVideoMaterial);
      List localList10 = createFacialFeatureFilters(paramVideoMaterial, localTriggerManager);
      RenderItem localRenderItem10 = createFilamentRenderItem(paramVideoMaterial, localTriggerManager);
      List localList20 = createVoiceTextRenderItem(paramVideoMaterial, localTriggerManager);
      List localList21 = createParticleXRenderItems(paramVideoMaterial, localTriggerManager);
      List localList11 = createFaceParticleRenderItems(paramVideoMaterial, localTriggerManager);
      List localList12 = createGestureParticleRenderItems(paramVideoMaterial, localTriggerManager);
      List localList13 = createBodyParticleRenderItems(paramVideoMaterial, localTriggerManager);
      List localList14 = createStarParticleRenderItems(paramVideoMaterial, localTriggerManager);
      List localList15 = createFaceGpuParticleRenderItems(paramVideoMaterial, localTriggerManager);
      List localList16 = createGestureGpuParticleRenderItems(paramVideoMaterial, localTriggerManager);
      createBodyGpuParticleRenderItems(paramVideoMaterial, localTriggerManager);
      createStarGpuParticleRenderItems(paramVideoMaterial, localTriggerManager);
      FilamentParticleFilter localFilamentParticleFilter = createFilamentParticleFilter(paramVideoMaterial);
      createDetectConfigTrigger(paramVideoMaterial, localTriggerManager);
      PhantomFilter localPhantomFilter = createPhantomFilter(paramVideoMaterial);
      creatFreezeFrameFilter(paramVideoMaterial);
      FrozenFrameRender localFrozenFrameRender = createFrozenRender(paramVideoMaterial, localTriggerManager);
      RenderItem localRenderItem11 = creatZoomRenderItem(paramVideoMaterial, localTriggerManager);
      List localList17 = createMaskStickerRenderItems(paramVideoMaterial, localTriggerManager);
      List localList22 = createRapidRenderItems(paramVideoMaterial, localTriggerManager);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      createQQGestureVideoFilterList(paramVideoMaterial, localArrayList1, localArrayList2);
      if ((localRenderItem3 != null) && (localRenderItem3.filter != null) && ((localRenderItem3.filter instanceof CustomVideoFilter))) {
        ((CustomVideoFilter)localRenderItem3.filter).setNormalRenderItems(localList19);
      }
      VideoFilterList localVideoFilterList = new VideoFilterList();
      localVideoFilterList.setCosFunEnableGAN(isCosFunEnableGAN(paramVideoMaterial));
      AllVideoFilters localAllVideoFilters = new AllVideoFilters();
      if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.NORMAL.value) {
        localAllVideoFilters.addRenderItems(localList19);
      }
      for (;;)
      {
        if (paramVideoMaterial.getBlurEffectItem() != null) {
          localVideoFilterList.setBlurMaskFilter(new BlurMaskFilter(paramVideoMaterial.getBlurEffectItem()));
        }
        localVideoFilterList.setLut(localRenderItem1);
        localVideoFilterList.setSkyBox(localRenderItem2);
        localVideoFilterList.setHairCosRenderItem(createHairCosRenderItem(paramVideoMaterial, localTriggerManager));
        if (localPhantomFilter != null) {
          localVideoFilterList.setPhantomFilter(localPhantomFilter);
        }
        localVideoFilterList.setRapidNetRenderItems(localList22);
        localVideoFilterList.setStyleChildRenderItems(localList1);
        localAllVideoFilters.addRenderItems(localList20);
        localAllVideoFilters.addRenderItems(localList21);
        localObject1 = createEffectFilter(paramVideoMaterial);
        if (localObject1 != null)
        {
          localVideoFilterList.setVideoEffectFilter((VideoFilterBase)localObject1);
          localVideoFilterList.setVideoEffectOrder(paramVideoMaterial.getVideoFilterEffect().order);
        }
        localVideoFilterList.setStyleCustomFilterGroup(createCustomFilterGroup(paramVideoMaterial.getCustomFilterGroupList()));
        localVideoFilterList.setCosFunInnerStyleCustomFilterGroup(createCustomFilterGroup(paramVideoMaterial.getCustomCosFunInnerFilterGroupList()));
        localVideoFilterList.setFabbyMvFiltersRenderItem(createFabbyMvFiltersRenderItem(paramVideoMaterial, localTriggerManager));
        localVideoFilterList.setRenderItems(localAllVideoFilters.getRenderItems(), (List)localObject2, localList2);
        localVideoFilterList.setBeautyTransformListRenderItems(localList3);
        localVideoFilterList.setRemodelRenderItems(localList4);
        localVideoFilterList.setQQGestureFilters(localArrayList2, localArrayList1);
        localVideoFilterList.setFastFaceStickerRenderItems(createFastFaceStickerRenderItem(paramVideoMaterial, localTriggerManager));
        localVideoFilterList.setFastBodyStickerRenderItems(createFastBodyStickerRenderItem(paramVideoMaterial, localTriggerManager));
        localVideoFilterList.setFaceParticleRenderItems(localList11);
        localVideoFilterList.setGestureParticleRenderItems(localList12);
        localVideoFilterList.setBodyParticleRenderItems(localList13);
        localVideoFilterList.setStarParticleRenderItems(localList14);
        localVideoFilterList.setFaceGpuParticleRenderItems(localList15);
        localVideoFilterList.setGestureGpuParticleRenderItems(localList16);
        localVideoFilterList.setFilamentParticleFilter(localFilamentParticleFilter);
        localVideoFilterList.setmEffectTriggerRenderItems(createEffectTriggerRenderItems(paramVideoMaterial, localTriggerManager));
        localVideoFilterList.setComicEffectRenderItems(createComicEffectFilterRenderItems(paramVideoMaterial, localTriggerManager));
        localVideoFilterList.setStyleFilterRenderItems(createStylizeFilterRenderItems(paramVideoMaterial, localTriggerManager));
        localVideoFilterList.setGestureRenderItems(localList6);
        localVideoFilterList.setBodyRenderItems(localList8);
        localVideoFilterList.setCatRenderItems(localList7);
        localVideoFilterList.setFilamentRenderItem(localRenderItem10);
        localVideoFilterList.setMultiViewerFilters(localList9);
        localVideoFilterList.setNeedDetectGesture(VideoMaterialUtil.isGestureDetectMaterial(paramVideoMaterial));
        localVideoFilterList.setNeedDetectGestureBonePoint(VideoMaterialUtil.isNeedHandBonePoint(paramVideoMaterial));
        localVideoFilterList.setOnlyDetectOneGesture(VideoMaterialUtil.getOnlyOneGestureDetectMaterial(paramVideoMaterial));
        if (VideoMaterialUtil.isEmotionDectectMaterial(paramVideoMaterial)) {
          localVideoFilterList.setNeedDetectEmotion(VideoMaterialUtil.isEmotionDectectMaterial(paramVideoMaterial));
        }
        localVideoFilterList.setNeedDetectGender(VideoMaterialUtil.isGenderDetect(paramVideoMaterial));
        localVideoFilterList.setMaterial(paramVideoMaterial);
        localVideoFilterList.setFacialFeatureFilterList(localList10);
        if (paramVideoMaterial.getAudio2Text() != null) {
          localVideoFilterList.setTriggerWords(paramVideoMaterial.getAudio2Text().triggerWords);
        }
        if (localFrozenFrameRender != null) {
          localVideoFilterList.setFrozenFrameRender(localFrozenFrameRender);
        }
        if (localRenderItem11 != null) {
          localVideoFilterList.setZoomRenderItem(localRenderItem11);
        }
        if (localList17 != null) {
          localVideoFilterList.setMaskStickerRenderItems(localList17);
        }
        if (!TriggerStateManager.getInstance().getTriggerStateItemMap().containsKey(Integer.valueOf(0)))
        {
          localObject1 = new TriggerStateItem(paramVideoMaterial.getTriggerStateEdgeItemList(), paramVideoMaterial.getTriggerActionItemList());
          if ((localObject1 != null) && (((TriggerStateItem)localObject1).isValid()))
          {
            ((TriggerStateItem)localObject1).setStateVersion(paramVideoMaterial.getStateVersion());
            TriggerStateManager.getInstance().putTriggerStateItem(0, (TriggerStateItem)localObject1);
          }
        }
        if (paramVideoMaterial.getAudio2Text() == null) {
          break;
        }
        localObject1 = localTriggerManager.getTriggers().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AETriggerI)((Iterator)localObject1).next();
          if ((localObject2 instanceof TriggerCtrlItem)) {
            ((TriggerCtrlItem)localObject2).setTriggerWords(paramVideoMaterial.getAudio2Text().triggerWords);
          }
        }
        if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.COMMON_BEFORE_CUSTOM.value)
        {
          localAllVideoFilters.addRenderItems(localList19);
          if ((localRenderItem3 != null) && (localRenderItem3.filter != null)) {
            localAllVideoFilters.add(localRenderItem3);
          }
        }
        else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_BEFORE_COMMON.value)
        {
          if ((localRenderItem3 != null) && (localRenderItem3.filter != null)) {
            localAllVideoFilters.add(localRenderItem3);
          }
          localAllVideoFilters.addRenderItems(localList19);
        }
        else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.SNAKE_FACE_BEFORE_COMMON.value)
        {
          localAllVideoFilters.add(localRenderItem5);
          localAllVideoFilters.addRenderItems(localList19);
        }
        else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_VERTEX_SHADER.value)
        {
          localAllVideoFilters.add(localRenderItem4);
          localAllVideoFilters.addRenderItems(localList19);
        }
        else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_OFF.value)
        {
          localAllVideoFilters.addRenderItems(localList19);
        }
        else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.TRANSFORM.value)
        {
          localAllVideoFilters.addRenderItems(localList19);
        }
        else if ((paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_OFF_TRANSFORM.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.GAMEPLAY_3D.value))
        {
          localAllVideoFilters.addRenderItems(localList19);
        }
        else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.THREE_DIM.value)
        {
          localAllVideoFilters.addRenderItems(localList5);
        }
        else if (VideoMaterialUtil.isFaceCopyMaterial(paramVideoMaterial))
        {
          localAllVideoFilters.add(localRenderItem7);
        }
        else if (VideoMaterialUtil.isFaceSwitchMaterial(paramVideoMaterial))
        {
          localAllVideoFilters.add(localRenderItem6);
        }
        else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.DOODLE.value)
        {
          localAllVideoFilters.add(localRenderItem8);
        }
        else if (VideoMaterialUtil.isFaceMorphingMaterial(paramVideoMaterial))
        {
          localVideoFilterList.setCrazyFaceFilters(new CrazyFaceFilters(paramVideoMaterial));
          localAllVideoFilters.addRenderItems(localList19);
        }
        else if (VideoMaterialUtil.isARMaterial(paramVideoMaterial))
        {
          localVideoFilterList.setARParticleFilter(createARParticleFilter(paramVideoMaterial));
          if (localList19 != null) {
            localAllVideoFilters.addRenderItems(localList19);
          }
        }
        else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.MAI_MENG.value)
        {
          localVideoFilterList.setActFilter(createActFilter(paramVideoMaterial));
          localAllVideoFilters.addRenderItems(localList19);
        }
        else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_CROP.value)
        {
          if ((localRenderItem9 != null) && (localRenderItem9.filter != null)) {
            localAllVideoFilters.add(localRenderItem9);
          }
          for (;;)
          {
            if (localList19 == null) {
              break label1494;
            }
            localAllVideoFilters.addRenderItems(localList19);
            if ((localObject1 != null) && (((RenderItem)localObject1).filter != null)) {
              ((FaceCropFilter)((RenderItem)localObject1).filter).setNormalRenderItems(localList19);
            }
            if ((localRenderItem9 == null) || (localRenderItem9.filter == null)) {
              break;
            }
            ((BuckleFaceFilter)localRenderItem9.filter).setNormalRenderItems(localList19);
            break;
            localAllVideoFilters.add((RenderItem)localObject1);
          }
        }
        else
        {
          label1494:
          if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_HEAD_CROP.value)
          {
            localVideoFilterList.setHeadCropRenderItem(localRenderItem12);
            localAllVideoFilters.add(localRenderItem12);
            localAllVideoFilters.addRenderItems(localList19);
            localVideoFilterList.setHeadCropRenderItems(localList18);
          }
        }
      }
      localVideoFilterList.setCosFunFilterGroup(createCosFunFilterGroup(paramVideoMaterial, localTriggerManager, localList1, isCosFunEnableGAN(paramVideoMaterial)));
      localVideoFilterList.setTriggerManager(localTriggerManager);
      return localVideoFilterList;
    }
  }
  
  private static VideoFilterList createFiltersForQQ(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {
      return null;
    }
    Object localObject1 = new TriggerManager();
    AllVideoFilters localAllVideoFilters = new AllVideoFilters();
    Object localObject2 = createCustomRenderItem(paramVideoMaterial, (TriggerManager)localObject1);
    createCustomVertexRenderItem(paramVideoMaterial, (TriggerManager)localObject1);
    RenderItem localRenderItem1 = createSnakeFaceRenderItem(paramVideoMaterial, (TriggerManager)localObject1);
    List localList1 = createFaceOffRenderItems(paramVideoMaterial, (TriggerManager)localObject1);
    List localList2 = createTransformRenderItems(paramVideoMaterial, (TriggerManager)localObject1);
    RenderItem localRenderItem2 = createFaceSwitchRenderItem(paramVideoMaterial, (TriggerManager)localObject1);
    RenderItem localRenderItem3 = createFaceCopyRenderItem(paramVideoMaterial, (TriggerManager)localObject1);
    List localList3 = createThreeDimRenderItem(paramVideoMaterial, (TriggerManager)localObject1);
    List localList4 = createFaceRenderItems(paramVideoMaterial, (TriggerManager)localObject1);
    VideoFilterBase localVideoFilterBase1 = createNonFit2DFilter(paramVideoMaterial);
    localObject1 = createBuckleFaceRenderItem(paramVideoMaterial, (TriggerManager)localObject1);
    VideoFilterBase localVideoFilterBase2 = createBigHeadFilter(paramVideoMaterial);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    createQQGestureVideoFilterList(paramVideoMaterial, localArrayList1, localArrayList2);
    if (!paramVideoMaterial.isNeedDecodeFaceFilter) {
      localList1 = null;
    }
    for (;;)
    {
      if ((localObject2 != null) && (((RenderItem)localObject2).filter != null) && ((((RenderItem)localObject2).filter instanceof CustomVideoFilter))) {
        ((CustomVideoFilter)((RenderItem)localObject2).filter).setNormalRenderItems(localList4);
      }
      new StringBuffer();
      localObject2 = new VideoFilterList();
      adjustRenderOrder(paramVideoMaterial.getFilterList());
      Iterator localIterator = paramVideoMaterial.getFilterList().iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        if ("FaceOff".equals(localObject3))
        {
          if (localList1 != null) {
            localAllVideoFilters.addRenderItems(localList1);
          }
        }
        else if ("MeshDistortion".equals(localObject3))
        {
          if (paramVideoMaterial.getOrderMode() <= 1)
          {
            if (localList2 != null) {
              localAllVideoFilters.addRenderItems(localList2);
            }
          }
          else if ((paramVideoMaterial.getOrderMode() == 2) && (localList2 != null)) {
            localAllVideoFilters.addRenderItems(localList2);
          }
        }
        else if ("Sticker".equals(localObject3)) {
          localAllVideoFilters.addRenderItems(localList4);
        } else if (!"Graffiti".equals(localObject3)) {
          if ("SnakeFace".equals(localObject3))
          {
            if (localRenderItem1 != null) {
              localAllVideoFilters.add(localRenderItem1);
            }
          }
          else if ("ThreeDim".equals(localObject3))
          {
            localAllVideoFilters.addRenderItems(localList3);
          }
          else if ("FaceCopy".equals(localObject3))
          {
            if (localRenderItem3 != null) {
              localAllVideoFilters.add(localRenderItem3);
            }
          }
          else if ("FaceSwitch".equals(localObject3))
          {
            if (localRenderItem2 != null) {
              localAllVideoFilters.add(localRenderItem2);
            }
          }
          else if ("ARParticle".equals(localObject3))
          {
            localObject3 = createARParticleFilter(paramVideoMaterial);
            if (localObject3 != null) {
              localAllVideoFilters.add((VideoFilterBase)localObject3);
            }
          }
          else if (!"3DAccessory".equals(localObject3))
          {
            if ("Model2dAnimation".equals(localObject3))
            {
              if (localVideoFilterBase1 != null) {
                localAllVideoFilters.add(localVideoFilterBase1);
              }
            }
            else if ("BuckleFace".equals(localObject3))
            {
              if (localObject1 != null) {
                localAllVideoFilters.add((RenderItem)localObject1);
              }
            }
            else if (("Bighead".equals(localObject3)) && (localVideoFilterBase2 != null)) {
              localAllVideoFilters.add(localVideoFilterBase2);
            }
          }
        }
      }
      ((VideoFilterList)localObject2).setRenderItems(localAllVideoFilters.getRenderItems(), localList1, localList2);
      ((VideoFilterList)localObject2).setQQGestureFilters(localArrayList2, localArrayList1);
      ((VideoFilterList)localObject2).setMaterial(paramVideoMaterial);
      return localObject2;
    }
  }
  
  @Deprecated
  private static VideoFilterInputFreeze createFreezeFilter(StickerItem paramStickerItem)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramStickerItem != null)
    {
      localObject1 = localObject2;
      if (paramStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.FREEZE_FRAME.type)
      {
        localObject1 = new VideoFilterInputFreeze();
        if (PTFaceAttr.PTExpression.TIME_TRIGGER.value != paramStickerItem.getTriggerTypeInt()) {
          break label165;
        }
        ((VideoFilterInputFreeze)localObject1).setFreezeFrameStartTime((paramStickerItem.triggerFrameStartTime * paramStickerItem.frameDuration), (paramStickerItem.triggerFrameDurationTime * paramStickerItem.frameDuration), paramStickerItem.alwaysTriggered);
        ((VideoFilterInputFreeze)localObject1).setTriggerTimeUpdater(paramStickerItem.triggerTimeUpdater);
      }
    }
    for (;;)
    {
      if ((paramStickerItem.triggerState != null) && (paramStickerItem.triggerState.size() > 0))
      {
        ((VideoFilterInputFreeze)localObject1).setIsStateTrigger(true);
        ((VideoFilterInputFreeze)localObject1).setStateTriggerParam(paramStickerItem.renderId, paramStickerItem.triggerState, paramStickerItem.triggerStateRange);
      }
      ((VideoFilterInputFreeze)localObject1).setFramesAndCount((paramStickerItem.frames * paramStickerItem.playCount * paramStickerItem.frameDuration));
      ((VideoFilterInputFreeze)localObject1).setPlayTimes(paramStickerItem.triggedTimes);
      ((VideoFilterInputFreeze)localObject1).setDelayTriggerTime((paramStickerItem.frameDuration * paramStickerItem.delayedTriggedTime));
      return localObject1;
      label165:
      ((VideoFilterInputFreeze)localObject1).setFreezeFrameTriggleType(paramStickerItem.getTriggerTypeInt(), paramStickerItem.alwaysTriggered, paramStickerItem.activateTriggerCount, paramStickerItem.activateTriggerTotalCount);
    }
  }
  
  private static FrozenFrameRender createFrozenRender(StickerItem paramStickerItem, TriggerManager paramTriggerManager)
  {
    paramStickerItem = new FrozenFrameTrigerCtrlItem(paramStickerItem);
    paramTriggerManager.addTriggers(paramStickerItem);
    return new FrozenFrameRender(new FrozenFrameFilter(), paramStickerItem);
  }
  
  private static FrozenFrameRender createFrozenRender(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    paramVideoMaterial = paramVideoMaterial.getItemList();
    if ((paramVideoMaterial != null) && (!paramVideoMaterial.isEmpty()))
    {
      paramVideoMaterial = paramVideoMaterial.iterator();
      while (paramVideoMaterial.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)paramVideoMaterial.next();
        if (localStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.FREEZE_FRAME.type) {
          return createFrozenRender(localStickerItem, paramTriggerManager);
        }
      }
    }
    return null;
  }
  
  private static List<RenderItem> createGestureGpuParticleRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramVideoMaterial.getItemList();
    if (!FeatureManager.Features.GPU_PARTICLE.isFunctionReady()) {
      return localArrayList;
    }
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        Object localObject = (StickerItem)localList.get(i);
        if ((((StickerItem)localObject).gpuParticleConfig != null) && (VideoMaterialUtil.isGestureItem((StickerItem)localObject)))
        {
          GPUParticleFilter localGPUParticleFilter = new GPUParticleFilter(paramVideoMaterial.getDataPath() + File.separator + ((StickerItem)localObject).id, (StickerItem)localObject);
          localObject = new TriggerCtrlItem((StickerItem)localObject);
          paramTriggerManager.addTriggers((AETriggerI)localObject);
          localArrayList.add(new RenderItem(localGPUParticleFilter, (TriggerCtrlItem)localObject));
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private static List<RenderItem> createGestureParticleRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramVideoMaterial.getItemList();
    if (localList != null)
    {
      int i = 0;
      if (i < localList.size())
      {
        Object localObject1 = (StickerItem)localList.get(i);
        Object localObject2;
        if ((((StickerItem)localObject1).particleConfig != null) && (VideoMaterialUtil.isGestureItem((StickerItem)localObject1)))
        {
          if (!((StickerItem)localObject1).dexName.endsWith("json")) {
            break label159;
          }
          localObject2 = new ParticleFilter3D(paramVideoMaterial.getDataPath() + File.separator + ((StickerItem)localObject1).id, (StickerItem)localObject1);
          localObject1 = new TriggerCtrlItem((StickerItem)localObject1);
          paramTriggerManager.addTriggers((AETriggerI)localObject1);
          localArrayList.add(new RenderItem((AEFilterI)localObject2, (TriggerCtrlItem)localObject1));
        }
        for (;;)
        {
          i += 1;
          break;
          label159:
          localObject2 = new ParticleFilter(paramVideoMaterial.getDataPath() + File.separator + ((StickerItem)localObject1).id, (StickerItem)localObject1);
          localObject1 = new TriggerCtrlItem((StickerItem)localObject1);
          paramTriggerManager.addTriggers((AETriggerI)localObject1);
          localArrayList.add(new RenderItem((AEFilterI)localObject2, (TriggerCtrlItem)localObject1));
        }
      }
    }
    return localArrayList;
  }
  
  private static List<RenderItem> createGestureRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramVideoMaterial.getItemList() != null)
    {
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (StickerItem)localIterator.next();
        if ((VideoMaterialUtil.isGestureItem((StickerItem)localObject)) && (((StickerItem)localObject).particleConfig == null) && (((StickerItem)localObject).gpuParticleConfig == null))
        {
          NormalVideoFilter localNormalVideoFilter = VideoFilterFactory.createFilter((StickerItem)localObject, paramVideoMaterial.getDataPath());
          if (localNormalVideoFilter != null)
          {
            localObject = new TriggerCtrlItem((StickerItem)localObject);
            paramTriggerManager.addTriggers((AETriggerI)localObject);
            localArrayList.add(new RenderItem(localNormalVideoFilter, (TriggerCtrlItem)localObject));
          }
        }
      }
    }
    return localArrayList;
  }
  
  private static HairCos createHairCos(VideoMaterial paramVideoMaterial)
  {
    if ((paramVideoMaterial != null) && (paramVideoMaterial.getItemList() != null))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)localIterator.next();
        if (localStickerItem.type == VideoFilterFactory.POSITION_TYPE.HAIR.type) {
          localArrayList.add(localStickerItem);
        }
      }
      if (localArrayList.size() > 0) {
        return new HairCos(localArrayList, paramVideoMaterial.getDataPath());
      }
    }
    return null;
  }
  
  private static RenderItem createHairCosRenderItem(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    if ((paramVideoMaterial != null) && (paramVideoMaterial.getItemList() != null) && (paramTriggerManager != null))
    {
      Object localObject = new ArrayList();
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)localIterator.next();
        if (localStickerItem.type == VideoFilterFactory.POSITION_TYPE.HAIR.type) {
          ((List)localObject).add(localStickerItem);
        }
      }
      if (((List)localObject).size() > 0)
      {
        paramVideoMaterial = new HairCos((List)localObject, paramVideoMaterial.getDataPath());
        localObject = new HairCosTriggerCtrlItem((List)localObject);
        paramTriggerManager.addTriggers((AETriggerI)localObject);
        return new RenderItem(paramVideoMaterial, (TriggerCtrlItem)localObject);
      }
    }
    return null;
  }
  
  private static List<NormalVideoFilter> createHeadCropFilterList(VideoMaterial paramVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramVideoMaterial.getHeadCropItemList() != null)
    {
      Iterator localIterator = paramVideoMaterial.getHeadCropItemList().iterator();
      while (localIterator.hasNext())
      {
        NormalVideoFilter localNormalVideoFilter = VideoFilterFactory.createFilter((StickerItem)localIterator.next(), paramVideoMaterial.getDataPath());
        if (localNormalVideoFilter != null) {
          localArrayList.add(localNormalVideoFilter);
        }
      }
    }
    return localArrayList;
  }
  
  private static RenderItem createHeadCropRenderItem(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    if ((paramVideoMaterial != null) && (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_HEAD_CROP.value)) {}
    for (paramVideoMaterial = new HeadCropFilter();; paramVideoMaterial = null) {
      return new RenderItem(paramVideoMaterial, null);
    }
  }
  
  private static List<RenderItem> createHeadCropRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramVideoMaterial.getHeadCropItemList() != null)
    {
      Iterator localIterator = paramVideoMaterial.getHeadCropItemList().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (StickerItem)localIterator.next();
        NormalVideoFilter localNormalVideoFilter = VideoFilterFactory.createFilter((StickerItem)localObject, paramVideoMaterial.getDataPath());
        if (localNormalVideoFilter != null)
        {
          localObject = new TriggerCtrlItem((StickerItem)localObject);
          paramTriggerManager.addTriggers((AETriggerI)localObject);
          localArrayList.add(new RenderItem(localNormalVideoFilter, (TriggerCtrlItem)localObject));
        }
      }
    }
    return localArrayList;
  }
  
  private static RenderItem createLutRenderItem(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    if ((paramVideoMaterial == null) || (paramVideoMaterial.getItemList() == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramVideoMaterial.getItemList().iterator();
    while (((Iterator)localObject).hasNext())
    {
      StickerItem localStickerItem = (StickerItem)((Iterator)localObject).next();
      if (localStickerItem.type == VideoFilterFactory.POSITION_TYPE.LUT.type) {
        localArrayList.add(localStickerItem);
      }
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    localObject = new TriggerCtrlItem((StickerItem)localArrayList.get(0));
    paramTriggerManager.addTriggers((AETriggerI)localObject);
    return new RenderItem(new LutItemsFilter(localArrayList, paramVideoMaterial.getDataPath()), (TriggerCtrlItem)localObject);
  }
  
  private static List<RenderItem> createMaskStickerRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramVideoMaterial.getItemList();
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      Iterator localIterator = ((List)localObject1).iterator();
      label220:
      while (localIterator.hasNext())
      {
        Object localObject2 = (StickerItem)localIterator.next();
        if (((StickerItem)localObject2).stickerType == VideoFilterFactory.STICKER_TYPE.MASK_SETTING.type)
        {
          localObject1 = null;
          if ((((StickerItem)localObject2).type == VideoFilterFactory.POSITION_TYPE.STATIC.type) || (((StickerItem)localObject2).type == VideoFilterFactory.POSITION_TYPE.RELATIVE.type)) {}
          for (localObject1 = new StaticMaskFilter((StickerItem)localObject2, paramVideoMaterial.getDataPath(), paramVideoMaterial.getMaskType());; localObject1 = new DynamicMaskFilter((StickerItem)localObject2, paramVideoMaterial.getDataPath(), paramVideoMaterial.getMaskType())) {
            do
            {
              if (localObject1 == null) {
                break label220;
              }
              localObject2 = new TriggerCtrlItem((StickerItem)localObject2);
              paramTriggerManager.addTriggers((AETriggerI)localObject2);
              localArrayList.add(new RenderItem((AEFilterI)localObject1, (TriggerCtrlItem)localObject2));
              break;
            } while ((((StickerItem)localObject2).type != VideoFilterFactory.POSITION_TYPE.DYNAMIC.type) && (((StickerItem)localObject2).type != VideoFilterFactory.POSITION_TYPE.GESTURE.type) && (((StickerItem)localObject2).type != VideoFilterFactory.POSITION_TYPE.BODY.type));
          }
        }
      }
    }
    return localArrayList;
  }
  
  private static List<MultiViewerFilter> createMultiViewerFilters(VideoMaterial paramVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramVideoMaterial.getMultiViewerItemList().iterator();
    MultiViewerFilter localMultiViewerFilter;
    Object localObject;
    String str1;
    String str2;
    float f;
    int i;
    while (localIterator.hasNext())
    {
      MultiViewerItem localMultiViewerItem = (MultiViewerItem)localIterator.next();
      if ((localMultiViewerItem != null) && (localMultiViewerItem.videoMaterial != null))
      {
        localMultiViewerFilter = new MultiViewerFilter();
        localMultiViewerFilter.setVideoFilterList(createFilters(localMultiViewerItem.videoMaterial));
        localMultiViewerFilter.setStickersMap(localMultiViewerItem.videoMaterial.getRenderOrderList());
        if (localMultiViewerItem.videoMaterial.isNeedFreezeFrame()) {
          paramVideoMaterial.setNeedFreezeFrame(true);
        }
        if (localMultiViewerItem.videoMaterial.isDetectGender()) {
          paramVideoMaterial.setDetectGender(true);
        }
        localMultiViewerFilter.setActiveParts(localMultiViewerItem.activeParts);
        localMultiViewerFilter.setRenderId(localMultiViewerItem.renderId);
        if (localMultiViewerItem.videoMaterial != null)
        {
          localMultiViewerItem.videoMaterial.setAllRenderID(localMultiViewerItem.renderId);
          localObject = new TriggerStateItem(localMultiViewerItem.videoMaterial.getTriggerStateEdgeItemList(), localMultiViewerItem.videoMaterial.getTriggerActionItemList());
          if ((localObject != null) && (((TriggerStateItem)localObject).isValid()))
          {
            ((TriggerStateItem)localObject).setStateVersion(localMultiViewerItem.videoMaterial.getStateVersion());
            TriggerStateManager.getInstance().putTriggerStateItem(localMultiViewerItem.renderId, (TriggerStateItem)localObject);
          }
        }
        localMultiViewerFilter.setNeedOriginFrame(localMultiViewerItem.needOriginFrame);
        str1 = localMultiViewerItem.videoMaterial.getFilterId();
        str2 = localMultiViewerItem.videoMaterial.getDataPath();
        if (localMultiViewerItem.videoMaterial.getVideoFilterEffect() == null) {
          break label386;
        }
        localObject = localMultiViewerItem.videoMaterial.getVideoFilterEffect().lutName;
        f = localMultiViewerItem.videoMaterial.getVideoFilterEffect().alpha;
        i = localMultiViewerItem.videoMaterial.getVideoFilterEffect().type;
      }
    }
    for (;;)
    {
      if ((i != 0) && (localObject != null) && (!((String)localObject).equals(""))) {
        if (effectFilterProvider == null) {
          break label353;
        }
      }
      label353:
      for (localObject = effectFilterProvider.getFilter(str1);; localObject = FabbyFilterFactory.createFilter(FileUtils.genSeperateFileDir(str2) + (String)localObject, f))
      {
        localMultiViewerFilter.setEffectFilter((BaseFilter)localObject);
        localArrayList.add(localMultiViewerFilter);
        break;
      }
      return localArrayList;
      label386:
      i = 0;
      f = 0.0F;
      localObject = null;
    }
  }
  
  private static VideoFilterBase createNonFit2DFilter(VideoMaterial paramVideoMaterial)
  {
    if (VideoFilterListExtension.getCreateExternalFiltersListener() != null) {
      return VideoFilterListExtension.getCreateExternalFiltersListener().createNonFit2DFilter(paramVideoMaterial);
    }
    return null;
  }
  
  private static List<RenderItem> createParticleXRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    List localList = paramVideoMaterial.getItemList();
    StickerItem localStickerItem;
    if (localList != null)
    {
      i = 0;
      if (i >= localList.size()) {
        break label207;
      }
      localStickerItem = (StickerItem)localList.get(i);
      if ((localStickerItem.transition == null) || (localStickerItem.wmGroupConfigCopies != null)) {}
    }
    label207:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ParticleSystemX.getInstance().init(AEModule.getContext());
        i = j;
        for (;;)
        {
          if (i < localList.size())
          {
            localStickerItem = (StickerItem)localList.get(i);
            if ((localStickerItem.transition != null) && (localStickerItem.wmGroupConfigCopies == null))
            {
              ParticleXFilter localParticleXFilter = new ParticleXFilter(localStickerItem, paramVideoMaterial.getDataPath(), i);
              TriggerCtrlItem localTriggerCtrlItem = new TriggerCtrlItem(localStickerItem);
              paramTriggerManager.addTriggers(localTriggerCtrlItem);
              localArrayList.add(new RenderItem(localParticleXFilter, localTriggerCtrlItem));
              ParticleSystemX.getInstance().addParticle(localStickerItem.transition);
            }
            i += 1;
            continue;
            i += 1;
            break;
          }
        }
        ParticleSystemX.getInstance().registerTemplate();
      }
      return localArrayList;
    }
  }
  
  private static PhantomFilter createPhantomFilter(VideoMaterial paramVideoMaterial)
  {
    Object localObject = null;
    List localList = paramVideoMaterial.getPhantomItemList();
    paramVideoMaterial = localObject;
    if (localList != null)
    {
      paramVideoMaterial = localObject;
      if (localList.size() > 0) {
        paramVideoMaterial = new PhantomFilter(localList);
      }
    }
    return paramVideoMaterial;
  }
  
  private static void createQQGestureVideoFilterList(VideoMaterial paramVideoMaterial, List<VideoFilterBase> paramList1, List<VideoFilterBase> paramList2)
  {
    if (VideoFilterListExtension.getCreateExternalFiltersListener() == null) {
      return;
    }
    VideoFilterListExtension.getCreateExternalFiltersListener().createQQGestureVideoFilterList(paramVideoMaterial, paramList1, paramList2);
  }
  
  private static List<RenderItem> createRapidRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    if ((!OfflineConfig.isNeedSkipRapidnet()) && (paramVideoMaterial != null) && (paramVideoMaterial.getFaceStyleItemList() != null) && (paramVideoMaterial.getFaceStyleItemList().size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = (FaceStyleItem)paramVideoMaterial.getFaceStyleItemList().get(0);
      if ((((FaceStyleItem)localObject).styleChangeType == FaceStyleItem.STYLE_CHANGE_TYPE.GENDER_SWITCH.value) && (FeatureManager.Features.RAPID_NET_GENDER_SWITCH.loadRapidModelFrom(((FaceStyleItem)localObject).dataPath, ((FaceStyleItem)localObject).modelName, false, true, 1, 1, 0)))
      {
        paramVideoMaterial = new RapidNetFilter((FaceStyleItem)localObject);
        localObject = new TriggerCtrlItem((FaceStyleItem)localObject);
        paramTriggerManager.addTriggers((AETriggerI)localObject);
        localArrayList.add(new RenderItem(paramVideoMaterial, (TriggerCtrlItem)localObject));
        return localArrayList;
      }
    }
    return null;
  }
  
  private static List<RenderItem> createRemodelRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = new ArrayList();
    if ((Build.BRAND.equals("Xiaomi")) && (Build.MODEL.equals("MI 9"))) {
      return localArrayList;
    }
    paramVideoMaterial = paramVideoMaterial.getFaceBeautyItemList();
    if (!CollectionUtils.isEmpty(paramVideoMaterial))
    {
      Iterator localIterator1 = paramVideoMaterial.iterator();
      while (localIterator1.hasNext())
      {
        FaceBeautyItem localFaceBeautyItem = (FaceBeautyItem)localIterator1.next();
        paramVideoMaterial = null;
        Iterator localIterator2 = localFaceBeautyItem.beautyValues.entrySet().iterator();
        Object localObject;
        while (localIterator2.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator2.next();
          if (remodelType.contains(localEntry.getKey()))
          {
            localObject = paramVideoMaterial;
            if (paramVideoMaterial == null)
            {
              localObject = new RemodelFilter();
              ((RemodelFilter)localObject).setFaceBeautyItem(localFaceBeautyItem);
            }
            ((RemodelFilter)localObject).setParam((BeautyRealConfig.TYPE)localEntry.getKey(), ((Integer)localEntry.getValue()).intValue());
            paramVideoMaterial = (VideoMaterial)localObject;
          }
        }
        if (paramVideoMaterial != null)
        {
          localObject = new TriggerCtrlItem(localFaceBeautyItem);
          paramTriggerManager.addTriggers((AETriggerI)localObject);
          localArrayList.add(new RenderItem(paramVideoMaterial, (TriggerCtrlItem)localObject));
        }
      }
    }
    return localArrayList;
  }
  
  private static VideoFilterBase createSimpleEffectVideoFilter(VideoMaterial paramVideoMaterial)
  {
    VideoFilterEffect localVideoFilterEffect = paramVideoMaterial.getVideoFilterEffect();
    String str = "filterEffect.lut";
    float f = 1.0F;
    if (localVideoFilterEffect != null)
    {
      str = localVideoFilterEffect.lutName;
      f = localVideoFilterEffect.alpha;
    }
    return new SimpleEffectVideoFilter(paramVideoMaterial.getDataPath(), str, f);
  }
  
  private static RenderItem createSkyboxRenderItem(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    if ((paramVideoMaterial == null) || (paramVideoMaterial.getItemList() == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramVideoMaterial.getItemList().iterator();
    while (localIterator.hasNext())
    {
      StickerItem localStickerItem = (StickerItem)localIterator.next();
      if (localStickerItem.type == VideoFilterFactory.POSITION_TYPE.SKYBOX.type)
      {
        TriggerCtrlItem localTriggerCtrlItem = new TriggerCtrlItem(localStickerItem);
        localHashMap.put(localStickerItem.id, localTriggerCtrlItem);
        localArrayList.add(localStickerItem);
      }
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    paramVideoMaterial = new SkyboxItemsFilter(localArrayList, paramVideoMaterial.getDataPath());
    paramVideoMaterial.setTriggerCtrlItemMap(localHashMap);
    paramTriggerManager.addTriggersMap(localHashMap);
    return new RenderItem(paramVideoMaterial, null);
  }
  
  private static RenderItem createSnakeFaceRenderItem(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.SNAKE_FACE_BEFORE_COMMON.value) {}
    for (paramVideoMaterial = new SnakeFaceFilter();; paramVideoMaterial = null) {
      return new RenderItem(paramVideoMaterial, null);
    }
  }
  
  private static List<RenderItem> createStarGpuParticleRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramVideoMaterial.getItemList();
    if (!FeatureManager.Features.GPU_PARTICLE.isFunctionReady()) {
      return localArrayList;
    }
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        Object localObject = (StickerItem)localList.get(i);
        if ((((StickerItem)localObject).gpuParticleConfig != null) && (VideoMaterialUtil.isStarItem((StickerItem)localObject)))
        {
          GPUParticleFilter localGPUParticleFilter = new GPUParticleFilter(paramVideoMaterial.getDataPath() + File.separator + ((StickerItem)localObject).id, (StickerItem)localObject);
          localObject = new TriggerCtrlItem((StickerItem)localObject);
          paramTriggerManager.addTriggers((AETriggerI)localObject);
          localArrayList.add(new RenderItem(localGPUParticleFilter, (TriggerCtrlItem)localObject));
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private static List<RenderItem> createStarParticleRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramVideoMaterial.getItemList();
    if (localList != null)
    {
      int i = 0;
      if (i < localList.size())
      {
        Object localObject1 = (StickerItem)localList.get(i);
        Object localObject2;
        if ((((StickerItem)localObject1).particleConfig != null) && (VideoMaterialUtil.isStarItem((StickerItem)localObject1)))
        {
          if (!((StickerItem)localObject1).dexName.endsWith("json")) {
            break label159;
          }
          localObject2 = new ParticleFilter3D(paramVideoMaterial.getDataPath() + File.separator + ((StickerItem)localObject1).id, (StickerItem)localObject1);
          localObject1 = new TriggerCtrlItem((StickerItem)localObject1);
          paramTriggerManager.addTriggers((AETriggerI)localObject1);
          localArrayList.add(new RenderItem((AEFilterI)localObject2, (TriggerCtrlItem)localObject1));
        }
        for (;;)
        {
          i += 1;
          break;
          label159:
          localObject2 = new ParticleFilter(paramVideoMaterial.getDataPath() + File.separator + ((StickerItem)localObject1).id, (StickerItem)localObject1);
          localObject1 = new TriggerCtrlItem((StickerItem)localObject1);
          paramTriggerManager.addTriggers((AETriggerI)localObject1);
          localArrayList.add(new RenderItem((AEFilterI)localObject2, (TriggerCtrlItem)localObject1));
        }
      }
    }
    return localArrayList;
  }
  
  private static List<RenderItem> createStyleChildRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    if ((paramVideoMaterial != null) && (paramVideoMaterial.getFaceStyleItemList() != null) && (paramVideoMaterial.getFaceStyleItemList().size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      FaceStyleItem localFaceStyleItem = (FaceStyleItem)paramVideoMaterial.getFaceStyleItemList().get(0);
      Object localObject = paramVideoMaterial.getCustomFilterList();
      if ((localFaceStyleItem.styleChangeType != FaceStyleItem.STYLE_CHANGE_TYPE.GENDER_SWITCH.value) && (isTNNAvailable(localFaceStyleItem)))
      {
        tnnMaterialReportInfo.modelName = localFaceStyleItem.modelName;
        tnnMaterialReportInfo.netSize = localFaceStyleItem.imageSize;
        if (!FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.isModelLoaded(6)) {
          loadTNNModel(localFaceStyleItem, 6);
        }
        localObject = new StyleChildFilter(localFaceStyleItem, (List)localObject);
        ((StyleChildFilter)localObject).setSegmentMode(paramVideoMaterial.isSegmentRequired());
        if ((localFaceStyleItem.stickerItemList != null) && (localFaceStyleItem.stickerItemList.size() > 0))
        {
          paramVideoMaterial = new StyleChildTriggerCtrlItem();
          paramVideoMaterial.addItem(localFaceStyleItem);
          paramTriggerManager.addTriggers(paramVideoMaterial);
          localArrayList.add(new RenderItem((AEFilterI)localObject, paramVideoMaterial));
        }
        for (;;)
        {
          return localArrayList;
          paramVideoMaterial = new TriggerCtrlItem(localFaceStyleItem);
          paramTriggerManager.addTriggers(paramVideoMaterial);
          localArrayList.add(new RenderItem((AEFilterI)localObject, paramVideoMaterial));
        }
      }
    }
    return null;
  }
  
  public static RenderItem createStyleRenderItem(StyleFilterSettingJsonBean paramStyleFilterSettingJsonBean)
  {
    StyleFilterTriggerCtrlItem localStyleFilterTriggerCtrlItem = null;
    if (paramStyleFilterSettingJsonBean == null) {
      return null;
    }
    if (paramStyleFilterSettingJsonBean.isDenoise > 0.0F) {
      localStyleFilterTriggerCtrlItem = new StyleFilterTriggerCtrlItem(paramStyleFilterSettingJsonBean.isDenoise);
    }
    return createStyleRenderItem(paramStyleFilterSettingJsonBean, false, 0, localStyleFilterTriggerCtrlItem);
  }
  
  private static RenderItem createStyleRenderItem(StyleFilterSettingJsonBean paramStyleFilterSettingJsonBean, boolean paramBoolean, int paramInt, TriggerCtrlItem paramTriggerCtrlItem)
  {
    Object localObject;
    switch (paramStyleFilterSettingJsonBean.type)
    {
    default: 
      localObject = null;
    }
    while (localObject != null)
    {
      if ((localObject instanceof IStlylizeFilterIniter))
      {
        IStlylizeFilterIniter localIStlylizeFilterIniter = (IStlylizeFilterIniter)localObject;
        localIStlylizeFilterIniter.updateLutPaths(paramStyleFilterSettingJsonBean.lutPaths);
        localIStlylizeFilterIniter.updateMateriaPaths(paramStyleFilterSettingJsonBean.materialPaths);
        localIStlylizeFilterIniter.updateThresholdValue(paramStyleFilterSettingJsonBean.faceThreshold, paramStyleFilterSettingJsonBean.typeThreshold, paramStyleFilterSettingJsonBean.highlightThreshold);
      }
      if (paramBoolean)
      {
        int i = paramInt;
        if (paramInt == 0) {
          i = 1;
        }
        return new StyleFilterRender((AEFilterI)localObject, paramTriggerCtrlItem, i);
        localObject = new TTWeseeSketchFilter();
        continue;
        localObject = new TTSelfInnovSketchFilter();
        continue;
        localObject = new TTMoonaPencilFilter();
        ((TTMoonaPencilFilter)localObject).updateSaturationPercent(paramStyleFilterSettingJsonBean.styleParams);
        continue;
        localObject = new TTPencilFilterGroup();
        continue;
        localObject = new TTCartoonFilterGroup();
        continue;
        localObject = new CyberpunkFilter();
        continue;
        localObject = new TTToonFilterGroup();
      }
      else
      {
        return new StyleFilterRender((AEFilterI)localObject, paramTriggerCtrlItem);
      }
    }
    return null;
  }
  
  private static List<RenderItem> createStylizeFilterRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    Object localObject1 = null;
    List localList = paramVideoMaterial.getItemList();
    Map localMap = paramVideoMaterial.getStyleFilterList();
    paramVideoMaterial = (VideoMaterial)localObject1;
    Object localObject2;
    StyleFilterSettingJsonBean localStyleFilterSettingJsonBean;
    if (localMap != null)
    {
      paramVideoMaterial = (VideoMaterial)localObject1;
      if (localList != null)
      {
        int i = 0;
        paramVideoMaterial = null;
        while (i < localList.size())
        {
          localObject2 = (StickerItem)localList.get(i);
          localObject1 = paramVideoMaterial;
          if (!TextUtils.isEmpty(((StickerItem)localObject2).styleFilter))
          {
            localObject1 = paramVideoMaterial;
            if (localMap.containsKey(((StickerItem)localObject2).styleFilter))
            {
              localStyleFilterSettingJsonBean = (StyleFilterSettingJsonBean)localMap.get(((StickerItem)localObject2).styleFilter);
              if (localStyleFilterSettingJsonBean != null) {
                break label119;
              }
              localObject1 = paramVideoMaterial;
            }
          }
          i += 1;
          paramVideoMaterial = (VideoMaterial)localObject1;
          continue;
          label119:
          if (paramTriggerManager == null) {
            break label195;
          }
          localObject1 = new StyleFilterTriggerCtrlItem((StickerItem)localObject2, localStyleFilterSettingJsonBean.isDenoise);
          paramTriggerManager.addTriggers((AETriggerI)localObject1);
        }
      }
    }
    for (;;)
    {
      localObject2 = createStyleRenderItem(localStyleFilterSettingJsonBean, true, ((StickerItem)localObject2).filterOrderMode, (TriggerCtrlItem)localObject1);
      localObject1 = paramVideoMaterial;
      if (localObject2 == null) {
        break;
      }
      if (paramVideoMaterial == null) {
        paramVideoMaterial = new ArrayList();
      }
      for (;;)
      {
        paramVideoMaterial.add(localObject2);
        localObject1 = paramVideoMaterial;
        break;
        return paramVideoMaterial;
      }
      label195:
      localObject1 = null;
    }
  }
  
  private static List<RenderItem> createThreeDimRenderItem(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    paramTriggerManager = new ArrayList();
    if ((paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.THREE_DIM.value) && (paramVideoMaterial.getItemList() != null))
    {
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        ThreeDimFilter localThreeDimFilter = new ThreeDimFilter((StickerItem)localIterator.next(), paramVideoMaterial.getDataPath());
        if (localThreeDimFilter != null) {
          paramTriggerManager.add(new RenderItem(localThreeDimFilter, null));
        }
      }
    }
    return paramTriggerManager;
  }
  
  private static List<VideoFilterBase> createTransformFilter(VideoMaterial paramVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    if ((Build.BRAND.equals("Xiaomi")) && (Build.MODEL.equals("MI 9"))) {
      return localArrayList;
    }
    List localList = paramVideoMaterial.getFaceMeshItemList();
    int i;
    if (!CollectionUtils.isEmpty(localList))
    {
      i = 0;
      while (i < localList.size())
      {
        localArrayList.add(new TransformFilter((FaceMeshItem)localList.get(i), paramVideoMaterial.getDataPath()));
        i += 1;
      }
    }
    if (!CollectionUtils.isEmpty(paramVideoMaterial.getDistortionItemList())) {
      if (paramVideoMaterial.isUseMesh())
      {
        int j = paramVideoMaterial.getDistortionItemList().size();
        i = j;
        while (i > 60)
        {
          localArrayList.add(new TransformFilter(paramVideoMaterial.getDistortionItemList().subList(j - i, j - i + 60), paramVideoMaterial.getItemList()));
          i -= 60;
        }
        if (i > 0) {
          localArrayList.add(new TransformFilter(paramVideoMaterial.getDistortionItemList().subList(j - i, j), paramVideoMaterial.getItemList()));
        }
      }
    }
    for (;;)
    {
      return localArrayList;
      if (!CollectionUtils.isEmpty(paramVideoMaterial.getFaceMoveItemList())) {
        localArrayList.add(new FaceMoveFilter(paramVideoMaterial.getFaceMoveItemList(), paramVideoMaterial.getItemList(), paramVideoMaterial.getFaceMoveTriangles()));
      }
    }
  }
  
  private static List<RenderItem> createTransformRenderItems(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = new ArrayList();
    if ((Build.BRAND.equals("Xiaomi")) && (Build.MODEL.equals("MI 9"))) {
      return localArrayList;
    }
    Object localObject1 = paramVideoMaterial.getFaceMeshItemList();
    int i;
    Object localObject2;
    if (!CollectionUtils.isEmpty((Collection)localObject1))
    {
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = new TransformFilter((FaceMeshItem)((List)localObject1).get(i), paramVideoMaterial.getDataPath());
        TriggerCtrlItem localTriggerCtrlItem = new TriggerCtrlItem((FaceMeshItem)((List)localObject1).get(i));
        paramTriggerManager.addTriggers(localTriggerCtrlItem);
        localArrayList.add(new RenderItem((AEFilterI)localObject2, localTriggerCtrlItem));
        i += 1;
      }
    }
    if (!CollectionUtils.isEmpty(paramVideoMaterial.getDistortionItemList())) {
      if (paramVideoMaterial.isUseMesh())
      {
        int j = paramVideoMaterial.getDistortionItemList().size();
        i = j;
        while (i > 60)
        {
          localObject1 = new TransformFilter(paramVideoMaterial.getDistortionItemList().subList(j - i, j - i + 60), paramVideoMaterial.getItemList());
          localObject2 = new TriggerCtrlItem();
          paramTriggerManager.addTriggers((AETriggerI)localObject2);
          localArrayList.add(new RenderItem((AEFilterI)localObject1, (TriggerCtrlItem)localObject2));
          i -= 60;
        }
        if (i > 0)
        {
          paramVideoMaterial = new TransformFilter(paramVideoMaterial.getDistortionItemList().subList(j - i, j), paramVideoMaterial.getItemList());
          localObject1 = new TriggerCtrlItem();
          paramTriggerManager.addTriggers((AETriggerI)localObject1);
          localArrayList.add(new RenderItem(paramVideoMaterial, (TriggerCtrlItem)localObject1));
        }
      }
    }
    for (;;)
    {
      return localArrayList;
      if (!CollectionUtils.isEmpty(paramVideoMaterial.getFaceMoveItemList())) {
        localArrayList.add(new RenderItem(new FaceMoveFilter(paramVideoMaterial.getFaceMoveItemList(), paramVideoMaterial.getItemList(), paramVideoMaterial.getFaceMoveTriangles()), null));
      }
    }
  }
  
  private static List<RenderItem> createVoiceTextRenderItem(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramVideoMaterial.getItemList();
    Object localObject1 = new ArrayList();
    paramVideoMaterial = new ArrayList();
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (StickerItem)((Iterator)localObject2).next();
        if ((((StickerItem)localObject3).transition != null) && (((StickerItem)localObject3).wmGroupConfigCopies != null)) {
          if (((StickerItem)localObject3).zIndex >= 0) {
            ((List)localObject1).add(localObject3);
          } else {
            paramVideoMaterial.add(localObject3);
          }
        }
      }
      if (!((List)localObject1).isEmpty())
      {
        localObject2 = new VoiceToTextTriggerCtrlItem();
        localObject3 = ((List)localObject1).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((VoiceToTextTriggerCtrlItem)localObject2).addItem((StickerItem)((Iterator)localObject3).next());
        }
        localArrayList.add(new RenderItem(new VoiceTextFilter(((StickerItem)((List)localObject1).get(0)).zIndex, (List)localObject1), (TriggerCtrlItem)localObject2));
        paramTriggerManager.addTriggers((AETriggerI)localObject2);
      }
      if (!paramVideoMaterial.isEmpty())
      {
        localObject1 = new VoiceToTextTriggerCtrlItem();
        localObject2 = paramVideoMaterial.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((VoiceToTextTriggerCtrlItem)localObject1).addItem((StickerItem)((Iterator)localObject2).next());
        }
        localArrayList.add(new RenderItem(new VoiceTextFilter(((StickerItem)paramVideoMaterial.get(0)).zIndex, paramVideoMaterial), (TriggerCtrlItem)localObject1));
        paramTriggerManager.addTriggers((AETriggerI)localObject1);
      }
    }
    return localArrayList;
  }
  
  private static VideoMaterial doMaterialDownGrade(VideoMaterial paramVideoMaterial)
  {
    VideoMaterial localVideoMaterial = paramVideoMaterial;
    if (paramVideoMaterial != null)
    {
      tnnMaterialReportInfo.materialID = paramVideoMaterial.getId();
      tnnMaterialReportInfo.deviceLevel = OfflineConfig.getPhonePerfLevel();
      localVideoMaterial = paramVideoMaterial;
      if (!TextUtils.isEmpty(paramVideoMaterial.getSubstitue()))
      {
        localVideoMaterial = paramVideoMaterial;
        if (paramVideoMaterial.getFaceStyleItemList() != null)
        {
          localVideoMaterial = paramVideoMaterial;
          if (paramVideoMaterial.getFaceStyleItemList().size() > 0)
          {
            FaceStyleItem localFaceStyleItem = (FaceStyleItem)paramVideoMaterial.getFaceStyleItemList().get(0);
            localVideoMaterial = paramVideoMaterial;
            if (localFaceStyleItem.styleChangeType != FaceStyleItem.STYLE_CHANGE_TYPE.GENDER_SWITCH.value) {
              if (isTNNAvailable(localFaceStyleItem))
              {
                localVideoMaterial = paramVideoMaterial;
                if (!needDowngrade(localFaceStyleItem)) {}
              }
              else
              {
                localVideoMaterial = paramVideoMaterial.getSubstituteMaterial();
              }
            }
          }
        }
      }
    }
    return localVideoMaterial;
  }
  
  public static int get4DirectionAngle(double paramDouble)
  {
    double d = paramDouble;
    if (paramDouble > 3.141592653589793D) {
      d = paramDouble - 6.283185307179586D;
    }
    if ((d >= -0.7853981633974483D) && (d <= 0.7853981633974483D)) {
      return 0;
    }
    if ((d >= 0.7853981633974483D) && (d <= 2.356194490192345D)) {
      return 90;
    }
    if ((d >= -2.356194490192345D) && (d <= -0.7853981633974483D)) {
      return 270;
    }
    return 180;
  }
  
  public static double get8DirectionAngle(double paramDouble)
  {
    if ((paramDouble >= -0.3926990816987241D) && (paramDouble <= 0.3926990816987241D)) {
      return 0.0D;
    }
    if ((paramDouble >= 0.3926990816987241D) && (paramDouble <= 1.178097245096172D)) {
      return 0.7853981633974483D;
    }
    if ((paramDouble >= 1.178097245096172D) && (paramDouble <= 1.963495408493621D)) {
      return 1.570796326794897D;
    }
    if ((paramDouble >= 1.963495408493621D) && (paramDouble <= 2.748893571891069D)) {
      return 2.356194490192345D;
    }
    if ((paramDouble >= -1.178097245096172D) && (paramDouble <= -0.3926990816987241D)) {
      return -0.7853981633974483D;
    }
    if ((paramDouble >= -1.963495408493621D) && (paramDouble <= -1.178097245096172D)) {
      return -1.570796326794897D;
    }
    if ((paramDouble >= -2.748893571891069D) && (paramDouble <= -1.963495408493621D)) {
      return -2.356194490192345D;
    }
    return -3.141592653589793D;
  }
  
  public static List<String> getAllPngFileNames(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString == null) {}
    do
    {
      for (;;)
      {
        return localArrayList;
        if (paramString.startsWith("assets://")) {
          try
          {
            paramString = AEModule.getContext().getAssets().list(FileUtils.getRealPath(paramString));
            if (paramString != null)
            {
              int j = paramString.length;
              int i = 0;
              while (i < j)
              {
                Object localObject = paramString[i];
                if (localObject.endsWith(".png")) {
                  localArrayList.add(localObject);
                }
                i += 1;
              }
              paramString = new File(paramString).list(VideoMaterialUtil.mPngFilter);
            }
          }
          catch (IOException paramString)
          {
            paramString.printStackTrace();
            return localArrayList;
          }
        }
      }
    } while (paramString == null);
    localArrayList.addAll(Arrays.asList(paramString));
    return localArrayList;
  }
  
  private static PTFaceAttr.PTExpression getCustomFilterTriggerType(List<StickerItem> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return PTFaceAttr.PTExpression.UNKNOW;
    }
    int i = PTFaceAttr.PTExpression.UNKNOW.value;
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      StickerItem localStickerItem = (StickerItem)paramList.next();
      if (localStickerItem.getTriggerTypeInt() <= i) {
        break label65;
      }
      i = localStickerItem.getTriggerTypeInt();
    }
    label65:
    for (;;)
    {
      break;
      return VideoMaterialUtil.getTriggerType(i);
    }
  }
  
  public static VideoFilterUtil.EffectFilterProvider getEffectFilterProvider()
  {
    return effectFilterProvider;
  }
  
  public static float getFaceStatus(FaceRangeStatus paramFaceRangeStatus, int paramInt, StickerItem.ValueRange paramValueRange)
  {
    if (paramFaceRangeStatus == null) {}
    for (;;)
    {
      return -1.0F;
      VideoMaterialUtil.RANGE_TRIGGER_TYPE[] arrayOfRANGE_TRIGGER_TYPE = VideoMaterialUtil.RANGE_TRIGGER_TYPE.values();
      int j = arrayOfRANGE_TRIGGER_TYPE.length;
      int i = 0;
      while (i < j)
      {
        VideoMaterialUtil.RANGE_TRIGGER_TYPE localRANGE_TRIGGER_TYPE = arrayOfRANGE_TRIGGER_TYPE[i];
        if (localRANGE_TRIGGER_TYPE.value == paramInt) {
          return localRANGE_TRIGGER_TYPE.checker.getLevel(paramFaceRangeStatus, paramValueRange);
        }
        i += 1;
      }
    }
  }
  
  public static Frame getSecondLastFrame(Frame paramFrame)
  {
    Frame localFrame;
    if (FrameUtil.isValid(paramFrame))
    {
      localFrame = paramFrame;
      if (FrameUtil.isValid(paramFrame.nextFrame)) {}
    }
    else
    {
      paramFrame = null;
      return paramFrame;
    }
    for (;;)
    {
      paramFrame = localFrame;
      if (!FrameUtil.isValid(localFrame.nextFrame)) {
        break;
      }
      paramFrame = localFrame;
      if (!FrameUtil.isValid(localFrame.nextFrame.nextFrame)) {
        break;
      }
      localFrame = localFrame.nextFrame;
    }
  }
  
  public static List<VideoFilterBase> getSimpleNormalVideoFilter(List<VideoFilterBase> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramList.next();
      if (canUseBlendMode(localVideoFilterBase)) {
        localArrayList.add(localVideoFilterBase);
      }
    }
    return localArrayList;
  }
  
  public static boolean hasBlendMode(VideoFilterBase paramVideoFilterBase)
  {
    boolean bool = true;
    if (paramVideoFilterBase == null) {
      bool = false;
    }
    do
    {
      do
      {
        do
        {
          return bool;
          if (!(paramVideoFilterBase instanceof NormalVideoFilter)) {
            break;
          }
        } while (!((NormalVideoFilter)paramVideoFilterBase).canUseBlendMode());
        return false;
        if (!(paramVideoFilterBase instanceof FaceOffFilter)) {
          break;
        }
      } while (!((FaceOffFilter)paramVideoFilterBase).canUseBlendMode());
      return false;
      if (!(paramVideoFilterBase instanceof FaceOff3DFilter)) {
        break;
      }
    } while (!((FaceOff3DFilter)paramVideoFilterBase).canUseBlendMode());
    return false;
    return false;
  }
  
  private static boolean isCosFunEnableGAN(VideoMaterial paramVideoMaterial)
  {
    CosFun localCosFun = paramVideoMaterial.getCosFun();
    List localList = paramVideoMaterial.getFaceStyleItemList();
    paramVideoMaterial = paramVideoMaterial.getCustomCosFunInnerFilterGroupList();
    return (localCosFun != null) && (localCosFun.isEnableGAN()) && (localList != null) && (paramVideoMaterial != null);
  }
  
  public static boolean isStatusTriggered(FaceRangeStatus paramFaceRangeStatus, int paramInt, StickerItem.ValueRange paramValueRange)
  {
    if (paramFaceRangeStatus == null) {}
    for (;;)
    {
      return false;
      VideoMaterialUtil.RANGE_TRIGGER_TYPE[] arrayOfRANGE_TRIGGER_TYPE = VideoMaterialUtil.RANGE_TRIGGER_TYPE.values();
      int j = arrayOfRANGE_TRIGGER_TYPE.length;
      int i = 0;
      while (i < j)
      {
        VideoMaterialUtil.RANGE_TRIGGER_TYPE localRANGE_TRIGGER_TYPE = arrayOfRANGE_TRIGGER_TYPE[i];
        if (localRANGE_TRIGGER_TYPE.value == paramInt) {
          return localRANGE_TRIGGER_TYPE.checker.isInRange(paramFaceRangeStatus, paramValueRange);
        }
        i += 1;
      }
    }
  }
  
  private static boolean isTNNAvailable(FaceStyleItem paramFaceStyleItem)
  {
    if (isTNNAvailable) {
      return isTNNAvailable;
    }
    isTNNAvailable = loadTNNModel(paramFaceStyleItem, 6);
    tnnMaterialReportInfo.isTNNAvailable = isTNNAvailable;
    return isTNNAvailable;
  }
  
  private static boolean loadTNNModel(FaceStyleItem paramFaceStyleItem, int paramInt)
  {
    return FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.loadRapidModelFrom(paramFaceStyleItem.dataPath, paramFaceStyleItem.modelName, false, true, paramInt, 1, paramInt);
  }
  
  public static boolean maybeTransformFilter(VideoFilterBase paramVideoFilterBase)
  {
    return (paramVideoFilterBase != null) && (((paramVideoFilterBase instanceof TransformFilter)) || ((paramVideoFilterBase instanceof CustomVideoFilter)));
  }
  
  public static boolean needBlendMode(List<VideoFilterBase> paramList)
  {
    if (paramList == null) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((VideoFilterBase)paramList.next() instanceof NormalVideoFilter)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean needCopy(VideoFilterBase paramVideoFilterBase)
  {
    if (paramVideoFilterBase == null) {}
    do
    {
      return false;
      if ((paramVideoFilterBase instanceof NormalVideoFilter)) {
        return ((NormalVideoFilter)paramVideoFilterBase).needCopyTex();
      }
    } while ((!(paramVideoFilterBase instanceof FaceOffFilter)) && (!(paramVideoFilterBase instanceof FaceOff3DFilter)));
    return true;
  }
  
  public static boolean needDepthBuffer(VideoFilterBase paramVideoFilterBase)
  {
    return (paramVideoFilterBase != null) && ((paramVideoFilterBase instanceof ThreeDimFilter));
  }
  
  private static boolean needDowngrade(FaceStyleItem paramFaceStyleItem)
  {
    int i;
    if (paramFaceStyleItem.limitDeviceLevel == 0)
    {
      i = 3;
      paramFaceStyleItem = tnnMaterialReportInfo;
      if (OfflineConfig.getPhonePerfLevel() >= i) {
        break label42;
      }
    }
    label42:
    for (boolean bool = true;; bool = false)
    {
      paramFaceStyleItem.isDeviceDowngrade = bool;
      return tnnMaterialReportInfo.isDeviceDowngrade;
      i = paramFaceStyleItem.limitDeviceLevel;
      break;
    }
  }
  
  public static boolean needMaskRecordTouchPoint(VideoFilterList paramVideoFilterList)
  {
    return (paramVideoFilterList != null) && (VideoMaterialUtil.isDoodlerMaskMaterial(paramVideoFilterList.getMaterial())) && (!VideoMaterialUtil.isTouchTriggerEvent(paramVideoFilterList.getMaterial()));
  }
  
  public static boolean needRecordTouchPoint(VideoFilterList paramVideoFilterList)
  {
    return (paramVideoFilterList != null) && (VideoMaterialUtil.isARMaterial(paramVideoFilterList.getMaterial())) && (!VideoMaterialUtil.isTouchTriggerEvent(paramVideoFilterList.getMaterial()));
  }
  
  public static boolean needTouchTriggerEvent(VideoFilterList paramVideoFilterList)
  {
    return (paramVideoFilterList != null) && (VideoMaterialUtil.isTouchTriggerEvent(paramVideoFilterList.getMaterial()));
  }
  
  public static void removeEmptyFilters(List<VideoFilterBase> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (paramList.next() == null) {
          paramList.remove();
        }
      }
    }
  }
  
  public static void removeEmptyRenderItems(List<RenderItem> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RenderItem localRenderItem = (RenderItem)paramList.next();
        if ((localRenderItem == null) || (localRenderItem.filter == null)) {
          paramList.remove();
        }
      }
    }
  }
  
  private static void reportTNNInfo()
  {
    AEKitBean localAEKitBean = new AEKitBean(AEKitReportEvent.PREVIEW_TNN_MATERIAL.value);
    if ((tnnMaterialReportInfo != null) && (!TextUtils.isEmpty(tnnMaterialReportInfo.materialID)))
    {
      localAEKitBean.ext_str1 = tnnMaterialReportInfo.materialID;
      localAEKitBean.ext_str2 = Boolean.valueOf(tnnMaterialReportInfo.isTNNAvailable).toString();
      localAEKitBean.ext_str3 = Integer.valueOf(tnnMaterialReportInfo.deviceLevel).toString();
      localAEKitBean.ext_str4 = Boolean.valueOf(tnnMaterialReportInfo.isDeviceDowngrade).toString();
      localAEKitBean.ext_str5 = tnnMaterialReportInfo.modelName;
      localAEKitBean.ext_str6 = tnnMaterialReportInfo.netSize.toString();
      AVReportCenter.getInstance().commit(localAEKitBean, Boolean.valueOf(true));
    }
  }
  
  public static void setEffectFilterProvider(VideoFilterUtil.EffectFilterProvider paramEffectFilterProvider)
  {
    effectFilterProvider = paramEffectFilterProvider;
  }
  
  public static void setRenderMode(VideoFilterBase paramVideoFilterBase, int paramInt)
  {
    if (paramVideoFilterBase != null) {
      paramVideoFilterBase.setRenderMode(paramInt);
    }
  }
  
  public static void setRenderMode(BaseFilter paramBaseFilter, int paramInt)
  {
    while (paramBaseFilter != null)
    {
      paramBaseFilter.setRenderMode(paramInt);
      paramBaseFilter = paramBaseFilter.getmNextFilter();
    }
  }
  
  public static void setRenderMode(List<? extends VideoFilterBase> paramList, int paramInt)
  {
    if (CollectionUtils.isEmpty(paramList)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((VideoFilterBase)paramList.next()).setRenderMode(paramInt);
      }
    }
  }
  
  public static void setRenderModes(List<RenderItem> paramList, int paramInt)
  {
    if (CollectionUtils.isEmpty(paramList)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RenderItem localRenderItem = (RenderItem)paramList.next();
        if ((localRenderItem.filter instanceof VideoFilterBase)) {
          ((VideoFilterBase)localRenderItem.filter).setRenderMode(paramInt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.VideoFilterUtil
 * JD-Core Version:    0.7.0.1
 */