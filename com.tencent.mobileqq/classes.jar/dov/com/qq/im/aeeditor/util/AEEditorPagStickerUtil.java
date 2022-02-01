package dov.com.qq.im.aeeditor.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerConfig;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerInfo;
import dov.com.qq.im.aeeditor.module.filter.AEEditorResourceManager;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextBean;

public class AEEditorPagStickerUtil
{
  public static void a(@NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable AEEditorPagStickerUtil.PrepareCallback paramPrepareCallback)
  {
    AEQLog.a("AEEditorPagStickerUtil", "[preparePagSticker] - BEGIN -");
    if (paramPrepareCallback != null) {
      paramPrepareCallback.a(paramAEEditorTextBean, 0);
    }
    if (AEEditorResourceManager.a().a(paramAEEditorTextBean.id))
    {
      AEQLog.a("AEEditorPagStickerUtil", "[preparePagSticker] pag zip file exists");
      ThreadManager.excute(new AEEditorPagStickerUtil.1(paramAEEditorTextBean, paramPrepareCallback), 64, null, false);
    }
    for (;;)
    {
      AEQLog.a("AEEditorPagStickerUtil", "[preparePagSticker] - END -");
      return;
      AEQLog.a("AEEditorPagStickerUtil", "[preparePagSticker] pag zip file not exists");
      AEEditorPagStickerInfo localAEEditorPagStickerInfo = AEEditorResourceManager.a().a(paramAEEditorTextBean.id);
      if (localAEEditorPagStickerInfo == null)
      {
        if (paramPrepareCallback != null) {
          paramPrepareCallback.a(paramAEEditorTextBean, false, "ERROR_PAG_ZIP_INFO_NOT_FOUND");
        }
        AEQLog.a("AEEditorPagStickerUtil", "[preparePagSticker] invalid sticker info");
        AEQLog.a("AEEditorPagStickerUtil", "[preparePagSticker] - END -");
        return;
      }
      ThreadManager.excute(new AEEditorPagStickerUtil.2(AEEditorPagStickerInfo.convert2DownloadBean(localAEEditorPagStickerInfo), paramAEEditorTextBean, paramPrepareCallback), 128, null, false);
    }
  }
  
  private static void b(@NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean, @NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable AEEditorPagStickerUtil.PrepareCallback paramPrepareCallback)
  {
    AEQLog.a("AEEditorPagStickerUtil", "[downloadPagZip] - BEGIN -");
    AEEditorResourceManager.a().a(paramAEEditorDownloadResBean, new AEEditorPagStickerUtil.3(paramAEEditorTextBean, paramPrepareCallback));
    AEQLog.a("AEEditorPagStickerUtil", "[downloadPagZip] - END -");
  }
  
  private static void b(AEEditorTextBean paramAEEditorTextBean, @NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean, @Nullable AEEditorPagStickerUtil.PrepareCallback paramPrepareCallback)
  {
    AEQLog.a("AEEditorPagStickerUtil", "[downloadPagFont] - BEGIN -");
    AEEditorResourceManager.a().a(paramAEEditorDownloadResBean, new AEEditorPagStickerUtil.5(paramPrepareCallback, paramAEEditorTextBean));
    AEQLog.a("AEEditorPagStickerUtil", "[downloadPagFont] - END -");
  }
  
  public static void b(@NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable AEEditorPagStickerUtil.PrepareCallback paramPrepareCallback)
  {
    AEQLog.a("AEEditorPagStickerUtil", "[preparePagFont] - BEGIN -");
    if (paramPrepareCallback != null) {
      paramPrepareCallback.a(paramAEEditorTextBean, 66);
    }
    if (!TextUtils.isEmpty(paramAEEditorTextBean.fontId))
    {
      AEQLog.a("AEEditorPagStickerUtil", "[preparePagFont] font info configured");
      e(paramAEEditorTextBean, paramPrepareCallback);
    }
    for (;;)
    {
      AEQLog.a("AEEditorPagStickerUtil", "[preparePagFont] - END -");
      return;
      AEQLog.a("AEEditorPagStickerUtil", "[preparePagFont] font info not configured");
      if (paramPrepareCallback != null)
      {
        paramPrepareCallback.a(paramAEEditorTextBean, 100);
        paramPrepareCallback.a(paramAEEditorTextBean, true, "SUCCESS_FONT_NOT_CONFIGURED");
      }
    }
  }
  
  private static void d(@NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable AEEditorPagStickerUtil.PrepareCallback paramPrepareCallback)
  {
    boolean bool = false;
    AEQLog.a("AEEditorPagStickerUtil", "[parsePagStickerConfig] - BEGIN -");
    Object localObject = AEEditorResourceManager.a().d(paramAEEditorTextBean.id);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (paramPrepareCallback != null) {
        paramPrepareCallback.a(paramAEEditorTextBean, false, null);
      }
      AEQLog.a("AEEditorPagStickerUtil", "[parsePagStickerConfig] invalid config json path");
      AEQLog.a("AEEditorPagStickerUtil", "[parsePagStickerConfig] - END -");
      return;
    }
    localObject = AEEditorResourceManager.a().a((String)localObject);
    if (paramPrepareCallback != null)
    {
      if (localObject != null) {
        bool = true;
      }
      paramPrepareCallback.a(paramAEEditorTextBean, bool, (AEEditorPagStickerConfig)localObject);
    }
    AEQLog.a("AEEditorPagStickerUtil", "[parsePagStickerConfig] - END -");
  }
  
  private static void e(@NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable AEEditorPagStickerUtil.PrepareCallback paramPrepareCallback)
  {
    AEQLog.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] - BEGIN -");
    AEEditorDownloadResBean localAEEditorDownloadResBean = AEEditorResourceManager.a().a(paramAEEditorTextBean.fontId);
    if (localAEEditorDownloadResBean == null)
    {
      if (paramPrepareCallback != null) {
        paramPrepareCallback.a(paramAEEditorTextBean, false, "ERROR_FONT_INFO_NOT_FOUND");
      }
      AEQLog.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] invalid font info");
      AEQLog.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] - END -");
      return;
    }
    if (AEEditorResourceManager.a().a(localAEEditorDownloadResBean))
    {
      AEQLog.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] font file exists");
      if (paramPrepareCallback != null)
      {
        paramPrepareCallback.a(paramAEEditorTextBean, 100);
        paramPrepareCallback.a(paramAEEditorTextBean, true, "SUCCESS_FONT_EXISTED");
      }
    }
    for (;;)
    {
      AEQLog.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] - END -");
      return;
      AEQLog.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] font file not exists");
      if (AEEditorResourceManager.a().b(localAEEditorDownloadResBean.getId()))
      {
        if (paramPrepareCallback != null) {
          paramPrepareCallback.a(paramAEEditorTextBean, true, "SUCCESS_FONT_LIMIT_EXCEEDED");
        }
        AEQLog.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] used fonts exceeded limit");
        AEQLog.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] - END -");
        return;
      }
      ThreadManager.excute(new AEEditorPagStickerUtil.4(paramAEEditorTextBean, localAEEditorDownloadResBean, paramPrepareCallback), 128, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.util.AEEditorPagStickerUtil
 * JD-Core Version:    0.7.0.1
 */