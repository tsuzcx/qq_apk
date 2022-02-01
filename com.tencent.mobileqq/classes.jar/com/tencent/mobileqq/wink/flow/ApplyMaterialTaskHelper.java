package com.tencent.mobileqq.wink.flow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.MetaMaterialKt;

public class ApplyMaterialTaskHelper
{
  public static void a(@NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      paramMaterialStatusCallback.onStatusChanged(ApplyMaterialTask.Status.FAILED, -1);
      return;
    }
    WinkEditorResourceManager.c().a(paramMetaMaterial, new ApplyMaterialTaskHelper.1(paramMaterialStatusCallback));
  }
  
  public static void a(@NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    paramMaterialStatusCallback.onStatusChanged(ApplyMaterialTask.Status.SUCCEEDED, 100);
  }
  
  public static void a(String paramString1, MetaMaterial paramMetaMaterial, String paramString2)
  {
    if (paramMetaMaterial == null) {
      paramMetaMaterial = "";
    } else {
      paramMetaMaterial = paramMetaMaterial.id;
    }
    AEQLog.b("[ApplyMaterial]", String.format("[%s] %s ==>> %s", new Object[] { paramString1, paramMetaMaterial, paramString2 }));
  }
  
  public static boolean a(@Nullable MetaMaterial paramMetaMaterial)
  {
    return MetaMaterialKt.f(paramMetaMaterial);
  }
  
  public static void b(@NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    paramMaterialStatusCallback.onStatusChanged(ApplyMaterialTask.Status.SUCCEEDED, 100);
  }
  
  public static boolean b(@NonNull MetaMaterial paramMetaMaterial)
  {
    return WinkEditorResourceManager.c().b(paramMetaMaterial);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.flow.ApplyMaterialTaskHelper
 * JD-Core Version:    0.7.0.1
 */