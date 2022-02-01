package com.tencent.mobileqq.wink.editor.sticker;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.editor.model.PointF;
import com.tencent.mobileqq.wink.editor.text.TextMetaMaterialKt;
import com.tencent.tavcut.model.PagEffectData;
import com.tencent.tavcut.model.TextLayerData;
import com.tencent.videocut.model.AnimationMode;
import com.tencent.videocut.model.StickerModel.ActionType;
import com.tencent.videocut.model.TextItem;
import com.tencent.videocut.utils.ColorUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"generateStickerModel", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "Lcom/tencent/tavcut/model/PagEffectData;", "layerIndex", "", "originInView", "Lcom/tencent/mobileqq/wink/editor/model/PointF;", "material", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "duration", "", "Lcom/tencent/videocut/model/StickerModel;", "config", "Lcom/tencent/videocut/render/model/StickerConfig;", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class PagEffectDataExtensionKt
{
  @NotNull
  public static final WinkStickerModel a(@NotNull PagEffectData paramPagEffectData, int paramInt, @NotNull PointF paramPointF, @NotNull MetaMaterial paramMetaMaterial, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramPagEffectData, "$this$generateStickerModel");
    Intrinsics.checkParameterIsNotNull(paramPointF, "originInView");
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "material");
    Object localObject1 = (Iterable)paramPagEffectData.textLayerList;
    Object localObject2 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    Object localObject3 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (TextLayerData)((Iterator)localObject3).next();
      localObject1 = ((TextLayerData)localObject4).layerIndex;
      int k = 0;
      if (localObject1 != null) {
        i = ((Integer)localObject1).intValue();
      } else {
        i = 0;
      }
      str1 = TextMetaMaterialKt.k(paramMetaMaterial);
      String str2 = ColorUtils.a.a(TextMetaMaterialKt.l(paramMetaMaterial));
      Boolean localBoolean1 = ((TextLayerData)localObject4).applyStroke;
      String str3 = ColorUtils.a.a(TextMetaMaterialKt.m(paramMetaMaterial));
      localObject1 = ((TextLayerData)localObject4).backgroundAlpha;
      if (localObject1 != null) {
        j = ((Integer)localObject1).intValue();
      } else {
        j = 0;
      }
      int m = j * 100 / 255;
      localObject1 = ColorUtils.a;
      Object localObject5 = ((TextLayerData)localObject4).strokeColor;
      j = k;
      if (localObject5 != null) {
        j = ((Integer)localObject5).intValue();
      }
      localObject5 = ((ColorUtils)localObject1).a(j);
      localObject1 = ((TextLayerData)localObject4).stokeWidth;
      if (localObject1 != null) {
        f1 = ((Float)localObject1).floatValue();
      } else {
        f1 = 0.0F;
      }
      f1 /= 20;
      localObject1 = TextMetaMaterialKt.g(paramMetaMaterial);
      if (localObject1 == null) {
        localObject1 = "";
      }
      Boolean localBoolean2 = ((TextLayerData)localObject4).fauxBold;
      Boolean localBoolean3 = ((TextLayerData)localObject4).fauxItalic;
      String str4 = TextMetaMaterialKt.h(paramMetaMaterial);
      String str5 = TextMetaMaterialKt.i(paramMetaMaterial);
      ((Collection)localObject2).add(new TextItem(str1, str2, (String)localObject1, (String)localObject5, f1, null, null, null, i, localBoolean2, localBoolean3, str4, localBoolean1, ((TextLayerData)localObject4).leading, ((TextLayerData)localObject4).tracking, str3, m, null, str5, null, 655584, null));
    }
    localObject2 = (List)localObject2;
    localObject3 = UUID.randomUUID().toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "UUID.randomUUID().toString()");
    localObject1 = paramPagEffectData.filePath;
    if (localObject1 == null) {
      localObject1 = "";
    }
    int i = paramPagEffectData.width;
    int j = paramPagEffectData.height;
    float f1 = TextMetaMaterialKt.o(paramMetaMaterial);
    float f2 = TextMetaMaterialKt.p(paramMetaMaterial);
    float f3 = TextMetaMaterialKt.q(paramMetaMaterial);
    float f4 = TextMetaMaterialKt.r(paramMetaMaterial);
    float f5 = TextMetaMaterialKt.s(paramMetaMaterial);
    float f6 = TextMetaMaterialKt.t(paramMetaMaterial);
    Object localObject4 = AnimationMode.LOOP;
    String str1 = paramMetaMaterial.id;
    Intrinsics.checkExpressionValueIsNotNull(str1, "material.id");
    long l = TextMetaMaterialKt.u(paramMetaMaterial);
    paramPagEffectData = TextMetaMaterialKt.v(paramMetaMaterial);
    if ((paramPagEffectData.hashCode() == 430498198) && (paramPagEffectData.equals("replace_all"))) {
      paramPagEffectData = StickerModel.ActionType.REPLACE_ALL;
    } else {
      paramPagEffectData = StickerModel.ActionType.NONE;
    }
    return new WinkStickerModel((String)localObject3, (String)localObject1, 0L, paramLong, paramInt, f1, f2, f3, f4, true, i, j, f5, f6, (List)localObject2, "", 0, (AnimationMode)localObject4, null, str1, null, 0, 0, l, paramPagEffectData, null, null, null, null, TextMetaMaterialKt.o(paramMetaMaterial), 0.0F, paramPointF, null, null, null, null, paramMetaMaterial, 1584660480, 15, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.sticker.PagEffectDataExtensionKt
 * JD-Core Version:    0.7.0.1
 */