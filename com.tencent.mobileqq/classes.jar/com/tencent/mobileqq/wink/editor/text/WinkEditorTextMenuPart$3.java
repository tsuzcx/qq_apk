package com.tencent.mobileqq.wink.editor.text;

import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.edit.util.WinkMapReport;
import com.tencent.mobileqq.wink.editor.sticker.WinkEditorTextPagUtils;
import com.tencent.mobileqq.wink.flow.ApplyMaterialLocalTask;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask.Status;

class WinkEditorTextMenuPart$3
  extends ApplyMaterialLocalTask
{
  WinkEditorTextMenuPart$3(WinkEditorTextMenuPart paramWinkEditorTextMenuPart) {}
  
  public void a(ApplyMaterialTask.Status paramStatus, int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    if (TextMetaMaterialKt.b(paramMetaMaterial))
    {
      super.a(paramStatus, paramInt, paramMetaMaterial, paramMaterialStatusCallback);
      return;
    }
    WinkEditorTextPagUtils.a(paramMetaMaterial, paramMaterialStatusCallback);
  }
  
  public boolean b(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    if ((!"TEXT_DEFAULT_DEFAULT_ID".equals(paramMetaMaterial.id)) && (!"TEXT_PATTERN_NON_ID".equals(paramMetaMaterial.id)) && (!"TEXT_DECOR_NON_ID".equals(paramMetaMaterial.id))) {
      return super.b(paramInt, paramMetaMaterial);
    }
    return true;
  }
  
  public void d(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    WinkEditorTextMenuPart.a(this.a).a(paramMetaMaterial);
    WinkMapReport localWinkMapReport = WinkMapReport.a();
    if (paramMetaMaterial == null) {
      paramMetaMaterial = "";
    } else {
      paramMetaMaterial = paramMetaMaterial.id;
    }
    localWinkMapReport.a(paramMetaMaterial, "video", "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.text.WinkEditorTextMenuPart.3
 * JD-Core Version:    0.7.0.1
 */