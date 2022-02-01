package com.tencent.videocut.render.extension;

import com.tencent.tavcut.TavCut;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.PAGAsset.PagScaleMode;
import com.tencent.tavcut.composition.model.component.PAGAsset.Replacement;
import com.tencent.tavcut.composition.model.component.PAGAsset.Replacement.ReplaceType;
import com.tencent.tavcut.composition.model.component.TextReplaceItem;
import com.tencent.tavcut.composition.model.component.TimeStretchMode;
import com.tencent.tavcut.creator.IComponentCreator;
import com.tencent.tavcut.creator.IEntityCreator;
import com.tencent.tavcut.creator.IInputSourceCreator;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.videocut.model.AnimationMode;
import com.tencent.videocut.model.StickerModel;
import com.tencent.videocut.model.TextItem;
import com.tencent.videocut.render.StickerRenderHelper.RenderData;
import com.tencent.videocut.utils.ColorUtils;
import com.tencent.videocut.utils.MD5Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getBgKey", "", "bgPath", "getFontFamily", "Lcom/tencent/videocut/model/StickerModel;", "getFontStyle", "toEntity", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "inputSource", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "toImageReplacement", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement;", "toPagReplacement", "", "Lcom/tencent/videocut/model/TextItem;", "toRenderData", "Lcom/tencent/videocut/render/StickerRenderHelper$RenderData;", "toTimeStretchMode", "Lcom/tencent/tavcut/composition/model/component/TimeStretchMode;", "Lcom/tencent/videocut/model/AnimationMode;", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class StickerExtensionsKt
{
  @NotNull
  public static final TimeStretchMode a(@NotNull AnimationMode paramAnimationMode)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimationMode, "$this$toTimeStretchMode");
    int i = StickerExtensionsKt.WhenMappings.$EnumSwitchMapping$1[paramAnimationMode.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return TimeStretchMode.REPEAT;
      }
      return TimeStretchMode.SCALE;
    }
    return TimeStretchMode.NONE;
  }
  
  @NotNull
  public static final Entity a(@NotNull StickerModel paramStickerModel, @NotNull InputSource paramInputSource)
  {
    Intrinsics.checkParameterIsNotNull(paramStickerModel, "$this$toEntity");
    Intrinsics.checkParameterIsNotNull(paramInputSource, "inputSource");
    IComponentCreator localIComponentCreator = TavCut.a.e();
    List localList2 = a(paramStickerModel.textItems);
    PAGAsset.Replacement localReplacement = b(paramStickerModel);
    List localList1 = localList2;
    if (localReplacement != null) {
      localList1 = CollectionExtKt.a(localList2, localReplacement);
    }
    localList2 = (List)new ArrayList();
    localList2.add(new IdentifyComponent(localIComponentCreator.a(paramStickerModel.centerX, paramStickerModel.centerY, paramStickerModel.width, paramStickerModel.height, paramStickerModel.scale, paramStickerModel.rotate)));
    localList2.add(new IdentifyComponent(localIComponentCreator.a("sticker")));
    paramInputSource = paramInputSource.key;
    if (paramInputSource == null) {
      paramInputSource = "";
    }
    localList2.add(new IdentifyComponent(localIComponentCreator.a(paramInputSource, 0, localList1, PAGAsset.PagScaleMode.LETTERBOX)));
    localList2.add(new IdentifyComponent(localIComponentCreator.a(paramStickerModel.startTime, paramStickerModel.duration)));
    localList2.add(new IdentifyComponent(localIComponentCreator.b(1000)));
    return TavCut.a.d().a("sticker", localList2);
  }
  
  @NotNull
  public static final StickerRenderHelper.RenderData a(@NotNull StickerModel paramStickerModel)
  {
    Intrinsics.checkParameterIsNotNull(paramStickerModel, "$this$toRenderData");
    Object localObject1 = TavCut.a.f();
    Object localObject2 = paramStickerModel.animationMode;
    int i = StickerExtensionsKt.WhenMappings.$EnumSwitchMapping$0[localObject2.ordinal()];
    int j = 0;
    if (i != 1) {
      i = 0;
    } else {
      i = -1;
    }
    localObject2 = a(paramStickerModel.animationMode);
    localObject2 = ((IInputSourceCreator)localObject1).a(paramStickerModel.filePath, i, paramStickerModel.id, (TimeStretchMode)localObject2);
    i = j;
    if (((CharSequence)paramStickerModel.bgPath).length() > 0) {
      i = 1;
    }
    if (i != 0) {
      localObject1 = ((IInputSourceCreator)localObject1).c(a(paramStickerModel.bgPath), paramStickerModel.bgPath);
    } else {
      localObject1 = null;
    }
    return new StickerRenderHelper.RenderData(a(paramStickerModel, (InputSource)localObject2), (InputSource)localObject2, (InputSource)localObject1, null, 8, null);
  }
  
  @NotNull
  public static final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "bgPath");
    String str = MD5Utils.a.a(paramString);
    if (str != null) {
      paramString = str;
    }
    return paramString;
  }
  
  @NotNull
  public static final List<PAGAsset.Replacement> a(@NotNull List<TextItem> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$toPagReplacement");
    if (paramList.isEmpty()) {
      return CollectionsKt.emptyList();
    }
    paramList = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramList, 10));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TextItem localTextItem = (TextItem)paramList.next();
      int i = localTextItem.index;
      String str1 = localTextItem.text;
      Boolean localBoolean1 = localTextItem.fauxBold;
      Boolean localBoolean2 = localTextItem.fauxItalic;
      String str2 = localTextItem.fontFamily;
      Boolean localBoolean3 = localTextItem.applyStroke;
      float f2 = localTextItem.strokeWidth;
      float f3 = 20;
      float f1 = 100;
      f2 = f2 * f3 / f1;
      localCollection.add(new PAGAsset.Replacement(Integer.valueOf(i), str1, Integer.valueOf(1), null, null, Boolean.valueOf(true), new TextReplaceItem(localBoolean1, localBoolean2, str2, null, localBoolean3, ColorUtils.a.a(localTextItem.strokeColor), Float.valueOf(f2), localTextItem.leading, localTextItem.tracking, ColorUtils.a.a(localTextItem.backgroundColor), Integer.valueOf((int)(localTextItem.backgroundAlpha / f1 * 'ÿ')), ColorUtils.a.a(localTextItem.textColor), null, 4104, null), null, 152, null));
    }
    return (List)localCollection;
  }
  
  @Nullable
  public static final PAGAsset.Replacement b(@NotNull StickerModel paramStickerModel)
  {
    Intrinsics.checkParameterIsNotNull(paramStickerModel, "$this$toImageReplacement");
    if ((((Collection)paramStickerModel.bgConfig).isEmpty() ^ true))
    {
      int i = PAGAsset.Replacement.ReplaceType.IMAGE.getValue();
      return new PAGAsset.Replacement(Integer.valueOf(0), a(paramStickerModel.bgPath), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(PAGAsset.PagScaleMode.LETTERBOX.getValue()), null, null, null, 224, null);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.extension.StickerExtensionsKt
 * JD-Core Version:    0.7.0.1
 */