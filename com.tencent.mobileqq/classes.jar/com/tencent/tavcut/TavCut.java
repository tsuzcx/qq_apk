package com.tencent.tavcut;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.config.DynamicSoConfig;
import com.tencent.tavcut.creator.ClipSourceCreator;
import com.tencent.tavcut.creator.ComponentCreator;
import com.tencent.tavcut.creator.EntityCreator;
import com.tencent.tavcut.creator.IClipSourceCreator;
import com.tencent.tavcut.creator.IComponentCreator;
import com.tencent.tavcut.creator.IEntityCreator;
import com.tencent.tavcut.creator.IInputSourceCreator;
import com.tencent.tavcut.creator.InputSourceCreator;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.model.LightAssetModel;
import com.tencent.tavcut.model.LightAssetModel.FontAsset;
import com.tencent.tavcut.model.LightAssetModel.MaterialConfig;
import com.tencent.tavcut.model.LightAssetModel.MediaType;
import com.tencent.tavcut.model.PagEffectData;
import com.tencent.tavcut.render.LightAiManager;
import com.tencent.tavcut.render.RenderConfig;
import com.tencent.tavcut.render.RenderPlayerFactory;
import com.tencent.tavcut.render.builder.light.LightSDKUtils;
import com.tencent.tavcut.render.cover.CoverProviderAccessor;
import com.tencent.tavcut.render.cover.ICoverProvider;
import com.tencent.tavcut.render.exporter.IExporter;
import com.tencent.tavcut.render.exporter.MovieExporter;
import com.tencent.tavcut.render.parser.PagEffectParser;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.render.thumb.IThumbProvider;
import com.tencent.tavcut.render.thumb.ThumbProviderAccessor;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import com.tencent.tavcut.resource.TemplateSegmentHelper;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.tavcut.session.TavCutSession;
import com.tencent.tavcut.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.FontAsset;
import org.light.LightAsset;
import org.light.TemplateConfig;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/TavCut;", "", "()V", "DEFAULT_FRAME_RATE", "", "context", "Landroid/content/Context;", "checkLightIsInstalled", "", "createAudioExtractor", "Lcom/tencent/tavcut/render/audio/extractor/IAudioExtractorProcessor;", "createAudioWaveDataCalculator", "Lcom/tencent/tavcut/render/audio/wave/IAudioWaveDataCalculator;", "sampleRate", "", "channelCount", "encodingPcmBit", "perSecondSample", "createCoverProvider", "Lcom/tencent/tavcut/render/cover/ICoverProvider;", "renderModel", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "size", "Lcom/tencent/tavcut/composition/model/component/Size;", "createExporter", "Lcom/tencent/tavcut/render/exporter/IExporter;", "createPlayer", "Lcom/tencent/tavcut/render/player/IPlayer;", "playerContainer", "Landroid/widget/FrameLayout;", "createReverseVideoProcessor", "Lcom/tencent/tavcut/render/video/IReverseVideoProcessor;", "createSession", "Lcom/tencent/tavcut/session/ICutSession;", "createThumbProvider", "Lcom/tencent/tavcut/render/thumb/IThumbProvider;", "clipSource", "Lcom/tencent/tavcut/model/ClipSource;", "exportTemplateJson", "", "model", "fillTemplate", "origin", "getAbilityVersion", "getAudioWaveDataManager", "Lcom/tencent/tavcut/render/audio/wave/IAudioWaveDataManager;", "getClipSourceCreator", "Lcom/tencent/tavcut/creator/IClipSourceCreator;", "getComponentCreator", "Lcom/tencent/tavcut/creator/IComponentCreator;", "getContext", "getContext$lib_tavcut_release", "getEntityCreator", "Lcom/tencent/tavcut/creator/IEntityCreator;", "getInputSourceCreator", "Lcom/tencent/tavcut/creator/IInputSourceCreator;", "getNeedAiAbilities", "", "jsonFilePath", "presetAiAbilities", "init", "installLightAssets", "assetPath", "isLightAssetsInstalled", "", "loadLightAsset", "Lcom/tencent/tavcut/model/LightAssetModel;", "loadOrCreateTemplate", "loadSo", "dynamicSoConfigs", "Lcom/tencent/tavcut/config/DynamicSoConfig;", "loadTemplate", "parsePAGFile", "Lcom/tencent/tavcut/model/PagEffectData;", "filePath", "parsePAGFileFromAsset", "parseTemplateJson", "templateJson", "registerAiPath", "agent", "path", "updateInputSourcePath", "templateDir", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"StaticFieldLeak"})
public final class TavCut
{
  public static final TavCut a = new TavCut();
  private static Context b;
  
  private final RenderModel a(RenderModel paramRenderModel, String paramString)
  {
    if (paramRenderModel == null) {
      return paramRenderModel;
    }
    Map localMap = (Map)new LinkedHashMap();
    localMap = MapsKt.toMutableMap(paramRenderModel.getInputSources());
    Iterator localIterator = ((Iterable)paramRenderModel.getInputSources().entrySet()).iterator();
    for (int i = 0; localIterator.hasNext(); i = 1)
    {
      label48:
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = ((InputSource)localEntry.getValue()).path;
      if ((localObject == null) || (StringsKt.startsWith$default((String)localObject, "/", false, 2, null))) {
        break label48;
      }
      localObject = localEntry.getKey();
      InputSource localInputSource = (InputSource)localEntry.getValue();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(((InputSource)localEntry.getValue()).path);
      localMap.put(localObject, InputSource.copy$default(localInputSource, null, null, localStringBuilder.toString(), null, null, null, null, null, null, null, 1019, null));
    }
    if (i != 0) {
      return RenderModel.copy$default(paramRenderModel, null, null, localMap, null, null, false, 0, null, null, null, 0L, 0, null, 8187, null);
    }
    return paramRenderModel;
  }
  
  @JvmStatic
  public static final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    b = paramContext.getApplicationContext();
  }
  
  @JvmStatic
  public static final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "assetPath");
    RenderConfig.a.a(paramString);
  }
  
  @JvmStatic
  public static final boolean a()
  {
    if (LightSDKUtils.a.a())
    {
      int i;
      if (((CharSequence)RenderConfig.a.a()).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return true;
      }
    }
    return false;
  }
  
  @JvmStatic
  public static final boolean a(@NotNull List<DynamicSoConfig> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "dynamicSoConfigs");
    return LightSDKUtils.a.a(paramList);
  }
  
  private final void g()
  {
    if (a()) {
      return;
    }
    throw ((Throwable)new IllegalStateException("You maybe forgot involve installLightAssets first!!!"));
  }
  
  @NotNull
  public final ICoverProvider a(@NotNull RenderModel paramRenderModel, @NotNull Size paramSize)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderModel, "renderModel");
    Intrinsics.checkParameterIsNotNull(paramSize, "size");
    return CoverProviderAccessor.a("/", paramRenderModel, paramSize);
  }
  
  @NotNull
  public final IExporter a(@NotNull RenderModel paramRenderModel)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderModel, "renderModel");
    return (IExporter)new MovieExporter(paramRenderModel);
  }
  
  @NotNull
  public final IPlayer a(@Nullable FrameLayout paramFrameLayout)
  {
    return RenderPlayerFactory.a.a(paramFrameLayout, 1);
  }
  
  @NotNull
  public final IThumbProvider a(@NotNull ClipSource paramClipSource, @NotNull Size paramSize)
  {
    Intrinsics.checkParameterIsNotNull(paramClipSource, "clipSource");
    Intrinsics.checkParameterIsNotNull(paramSize, "size");
    return ThumbProviderAccessor.a(paramClipSource, paramSize);
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "agent");
    Intrinsics.checkParameterIsNotNull(paramString2, "path");
    g();
    LightAiManager.a.a(paramString1, paramString2);
  }
  
  @Nullable
  public final LightAssetModel b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "jsonFilePath");
    g();
    int i = 0;
    Object localObject1 = LightAsset.Load(paramString, 0);
    if (localObject1 != null)
    {
      int j = ((LightAsset)localObject1).templateConfig().type;
      if (j != 0) {
        if (j != 1) {
          if (j != 2) {
            paramString = LightAssetModel.MediaType.MULTI_MEDIA;
          }
        }
      }
      for (;;)
      {
        break;
        paramString = LightAssetModel.MediaType.MULTI_MEDIA;
        continue;
        paramString = LightAssetModel.MediaType.PHOTO_ONLY;
        continue;
        paramString = LightAssetModel.MediaType.VIDEO_ONLY;
      }
      LightAssetModel.MaterialConfig localMaterialConfig = new LightAssetModel.MaterialConfig(paramString, ((LightAsset)localObject1).templateConfig().minClipAssetCount, ((LightAsset)localObject1).templateConfig().maxClipAssetCount, ((LightAsset)localObject1).templateConfig().minVideoDuration, ((LightAsset)localObject1).templateConfig().minImageDuration, ((LightAsset)localObject1).templateConfig().maxImageDuration, null, 64, null);
      paramString = ((LightAsset)localObject1).getFontAssets();
      if (paramString != null)
      {
        Collection localCollection = (Collection)new ArrayList(paramString.length);
        j = paramString.length;
        while (i < j)
        {
          Object localObject2 = paramString[i];
          localCollection.add(new LightAssetModel.FontAsset(localObject2.fontFamily, localObject2.fontStyle, null, 4, null));
          i += 1;
        }
        paramString = (List)localCollection;
      }
      else
      {
        paramString = CollectionsKt.emptyList();
      }
      localObject1 = ((LightAsset)localObject1).getBgmMusicIDs();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "lightAsset.bgmMusicIDs");
      localObject1 = ArraysKt.toList((Object[])localObject1);
      if (localObject1 == null) {
        localObject1 = CollectionsKt.emptyList();
      }
      return new LightAssetModel(paramString, (List)localObject1, localMaterialConfig, null, 8, null);
    }
    return null;
  }
  
  @Nullable
  public final RenderModel b(@Nullable RenderModel paramRenderModel)
  {
    g();
    return TemplateSegmentHelper.a.a(paramRenderModel);
  }
  
  @NotNull
  public final ICutSession b()
  {
    return (ICutSession)new TavCutSession();
  }
  
  @NotNull
  public final IClipSourceCreator c()
  {
    return (IClipSourceCreator)ClipSourceCreator.a;
  }
  
  @Nullable
  public final RenderModel c(@Nullable String paramString)
  {
    Object localObject = b;
    if (localObject != null)
    {
      RenderModel localRenderModel;
      if (!TextUtils.isEmpty((CharSequence)paramString)) {
        localRenderModel = TemplateParser.INSTANCE.fromFile(new File(paramString));
      } else {
        localRenderModel = null;
      }
      if (localRenderModel != null)
      {
        localObject = a;
        paramString = new File(paramString).getParent();
        Intrinsics.checkExpressionValueIsNotNull(paramString, "File(jsonFilePath).parent");
        return ((TavCut)localObject).a(localRenderModel, paramString);
      }
      paramString = FileUtils.a.a((Context)localObject, "empty_template.json");
      return TemplateParser.INSTANCE.fromJson(paramString);
    }
    throw ((Throwable)new IllegalStateException("Are you forgot init TavCut?"));
  }
  
  @NotNull
  public final IEntityCreator d()
  {
    return (IEntityCreator)EntityCreator.a;
  }
  
  @Nullable
  public final PagEffectData d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    return PagEffectParser.a.a(paramString);
  }
  
  @NotNull
  public final IComponentCreator e()
  {
    return (IComponentCreator)ComponentCreator.a;
  }
  
  @NotNull
  public final IInputSourceCreator f()
  {
    return (IInputSourceCreator)InputSourceCreator.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.TavCut
 * JD-Core Version:    0.7.0.1
 */