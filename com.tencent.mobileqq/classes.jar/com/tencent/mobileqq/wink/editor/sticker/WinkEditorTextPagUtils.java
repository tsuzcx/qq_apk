package com.tencent.mobileqq.wink.editor.sticker;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.wink.edit.bean.AEEditorDownloadResBean;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.text.TextMetaMaterialKt;
import com.tencent.mobileqq.wink.editor.text.WinkPagStickerConfig;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask.Status;
import com.tencent.ttpic.util.GsonUtils;

public class WinkEditorTextPagUtils
{
  private static void a(@NonNull MetaMaterial paramMetaMaterial)
  {
    AEQLog.a("AEEditorTextPagUtils", "[parseTextPagConfig] - BEGIN -");
    String str = TextMetaMaterialKt.e(paramMetaMaterial);
    if (TextUtils.isEmpty(str))
    {
      AEQLog.a("AEEditorTextPagUtils", "[parseTextPagConfig] invalid config json path");
      AEQLog.a("AEEditorTextPagUtils", "[parseTextPagConfig] - END -");
      return;
    }
    TextMetaMaterialKt.a(paramMetaMaterial, (WinkPagStickerConfig)GsonUtils.json2Obj(WinkEditorResourceManager.b(str), new WinkEditorTextPagUtils.1().getType()));
    AEQLog.a("AEEditorTextPagUtils", "[parseTextPagConfig] - END -");
  }
  
  public static void a(@NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    AEQLog.a("AEEditorTextPagUtils", "[prepareTextPag] - BEGIN -");
    if (WinkEditorResourceManager.c().b(paramMetaMaterial))
    {
      AEQLog.a("AEEditorTextPagUtils", "[prepareTextPag] pag zip file exists");
      ThreadManager.excute(new -..Lambda.WinkEditorTextPagUtils.3HS69BJ324jYEvYCmEu3p5-meKc(paramMetaMaterial, paramMaterialStatusCallback), 64, null, false);
    }
    else
    {
      paramMaterialStatusCallback.onStatusChanged(ApplyMaterialTask.Status.FAILED, -1);
    }
    AEQLog.a("AEEditorTextPagUtils", "[prepareTextPag] - END -");
  }
  
  private static void b(@NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    AEQLog.a("AEEditorTextPagUtils", "[prepareFontToPag] - BEGIN -");
    if (!TextUtils.isEmpty(TextMetaMaterialKt.f(paramMetaMaterial)))
    {
      AEQLog.a("AEEditorTextPagUtils", "[prepareFontToPag] font info configured");
      c(paramMetaMaterial, paramMaterialStatusCallback);
    }
    else
    {
      AEQLog.a("AEEditorTextPagUtils", "[prepareFontToPag] font info not configured");
      paramMaterialStatusCallback.onStatusChanged(ApplyMaterialTask.Status.SUCCEEDED, 100);
    }
    AEQLog.a("AEEditorTextPagUtils", "[prepareFontToPag] - END -");
  }
  
  private static void b(@NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    AEQLog.a("AEEditorTextPagUtils", "[downloadFont] - BEGIN -");
    WinkEditorResourceManager.c().a(paramAEEditorDownloadResBean, new WinkEditorTextPagUtils.3(paramMaterialStatusCallback));
    AEQLog.a("AEEditorTextPagUtils", "[downloadFont] - END -");
  }
  
  private static void c(@NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    AEQLog.a("AEEditorTextPagUtils", "[preProcessFontInfo] - BEGIN -");
    paramMetaMaterial = WinkEditorResourceManager.c().c(TextMetaMaterialKt.f(paramMetaMaterial));
    if (paramMetaMaterial == null)
    {
      paramMaterialStatusCallback.onStatusChanged(ApplyMaterialTask.Status.FAILED, -1);
      AEQLog.a("AEEditorTextPagUtils", "[preProcessFontInfo] invalid font info");
      AEQLog.a("AEEditorTextPagUtils", "[preProcessFontInfo] - END -");
      return;
    }
    if (WinkEditorResourceManager.c().b(paramMetaMaterial))
    {
      AEQLog.a("AEEditorTextPagUtils", "[preProcessFontInfo] font file exists");
      paramMaterialStatusCallback.onStatusChanged(ApplyMaterialTask.Status.SUCCEEDED, 100);
    }
    else
    {
      AEQLog.a("AEEditorTextPagUtils", "[preProcessFontInfo] font file not exists");
      if (WinkEditorResourceManager.c().e(paramMetaMaterial.getId()))
      {
        paramMaterialStatusCallback.onStatusChanged(ApplyMaterialTask.Status.FAILED, -1);
        AEQLog.a("AEEditorTextPagUtils", "[preProcessFontInfo] used fonts exceeded limit");
        AEQLog.a("AEEditorTextPagUtils", "[preProcessFontInfo] - END -");
        return;
      }
      ThreadManager.excute(new WinkEditorTextPagUtils.2(paramMetaMaterial, paramMaterialStatusCallback), 128, null, false);
    }
    AEQLog.a("AEEditorTextPagUtils", "[preProcessFontInfo] - END -");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.sticker.WinkEditorTextPagUtils
 * JD-Core Version:    0.7.0.1
 */