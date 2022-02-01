package com.tencent.mobileqq.wink.editor.sticker;

import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.util.WinkMapReport;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkTavCutDelegate;
import com.tencent.mobileqq.wink.editor.model.PointF;
import com.tencent.mobileqq.wink.editor.text.TextMetaMaterialKt;
import com.tencent.mobileqq.wink.flow.ApplyMaterialLocalTask;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask.Status;
import com.tencent.tavcut.TavCut;
import com.tencent.tavcut.model.PagEffectData;

class WinkEditorStickerMenuPart$4
  extends ApplyMaterialLocalTask
{
  WinkEditorStickerMenuPart$4(WinkEditorStickerMenuPart paramWinkEditorStickerMenuPart) {}
  
  public void a(ApplyMaterialTask.Status paramStatus, int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    if (TextMetaMaterialKt.b(paramMetaMaterial))
    {
      super.a(paramStatus, paramInt, paramMetaMaterial, paramMaterialStatusCallback);
      return;
    }
    WinkEditorTextPagUtils.a(paramMetaMaterial, paramMaterialStatusCallback);
  }
  
  public void d(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    WinkEditorStickerMenuPart.d(this.a).a(-1);
    this.a.n();
    Object localObject = WinkEditorResourceManager.c().f(paramMetaMaterial);
    localObject = TavCut.a.d((String)localObject);
    if (localObject != null)
    {
      PointF localPointF = StickerUtilsKt.a(WinkEditorStickerMenuPart.i(this.a).h(), WinkEditorStickerMenuPart.j(this.a).g());
      localObject = PagEffectDataExtensionKt.a((PagEffectData)localObject, StickerLayerIndexManager.a.a(), localPointF, paramMetaMaterial, WinkEditorStickerMenuPart.k(this.a).e());
      ((WinkStickerModel)localObject).updatePositionInView(WinkEditorStickerMenuPart.l(this.a).k(), WinkEditorStickerMenuPart.m(this.a).l(), WinkEditorStickerMenuPart.n(this.a).m());
      WinkEditorStickerMenuPart.o(this.a).a((WinkStickerModel)localObject);
    }
    localObject = WinkMapReport.a();
    if (paramMetaMaterial == null) {
      paramMetaMaterial = "";
    } else {
      paramMetaMaterial = paramMetaMaterial.id;
    }
    ((WinkMapReport)localObject).a(paramMetaMaterial, "video", "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.sticker.WinkEditorStickerMenuPart.4
 * JD-Core Version:    0.7.0.1
 */