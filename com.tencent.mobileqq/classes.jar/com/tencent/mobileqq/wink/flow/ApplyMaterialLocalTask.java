package com.tencent.mobileqq.wink.flow;

import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;

public abstract class ApplyMaterialLocalTask
  implements ApplyMaterialTask
{
  public void a(int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    ApplyMaterialTaskHelper.a(paramMaterialStatusCallback);
  }
  
  public void a(ApplyMaterialTask.Status paramStatus, int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    ApplyMaterialTaskHelper.b(paramMaterialStatusCallback);
  }
  
  public boolean a(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    return ApplyMaterialTaskHelper.a(paramMetaMaterial);
  }
  
  public boolean b(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    return ApplyMaterialTaskHelper.b(paramMetaMaterial);
  }
  
  public void c(int paramInt, @NonNull MetaMaterial paramMetaMaterial) {}
  
  public final void e(int paramInt, @NonNull MetaMaterial paramMetaMaterial) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.flow.ApplyMaterialLocalTask
 * JD-Core Version:    0.7.0.1
 */