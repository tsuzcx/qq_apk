package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.tencent.mobileqq.hiboom.HiBoomConstants;
import com.tencent.mobileqq.hiboom.HiBoomFont;
import com.tencent.mobileqq.hiboom.HiBoomFontDrawer;
import com.tencent.mobileqq.hiboom.api.IHiBoomManager;
import com.tencent.mobileqq.profile.diy.VipDiyCardConstants;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.callback.TagItemInfo;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class FontUpdateBusiness
  extends BaseUpdateCallback
{
  private static final String TAG = "FontUpdateBusiness";
  public static FontUpdateBusiness sInstance = new FontUpdateBusiness();
  
  private boolean deleteFont(String paramString)
  {
    if (paramString.startsWith("font.diycard.android.")) {
      return deleteHiboomFont(paramString, "font.diycard.android.", VipDiyCardConstants.jdField_a_of_type_JavaLangString, "deleteFiles: font diy card path = ");
    }
    if (paramString.startsWith("font.hifont.android.")) {
      return deleteHiboomFont(paramString, "font.hifont.android.", HiBoomFont.b, "deleteFiles: font hiboom path = ");
    }
    if (paramString.startsWith("font.hiFontQQ.json.")) {
      return deleteHiboomFont(paramString, "font.hiFontQQ.json.", HiBoomFont.c, "deleteFiles: font hiboom config path = ");
    }
    boolean bool;
    if (paramString.startsWith("font.hiFontQQ.tags"))
    {
      bool = VasUpdateUtil.a(new File(HiBoomFont.d));
      paramString = new StringBuilder();
      paramString.append("deleteFiles: font hiboom tag result = ");
      paramString.append(bool);
      QLog.d("FontUpdateBusiness", 2, paramString.toString());
      return bool;
    }
    StringBuilder localStringBuilder;
    if (paramString.startsWith("font.main.android."))
    {
      paramString = paramString.substring(18, paramString.length());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FontManagerConstants.FONT_DOWN_LOAD_PATH);
      localStringBuilder.append(File.separatorChar);
      localStringBuilder.append(paramString);
      localStringBuilder.append(File.separatorChar);
      localStringBuilder.append(paramString);
      localStringBuilder.append(".ttf");
      paramString = localStringBuilder.toString();
      bool = VasUpdateUtil.a(new File(paramString));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteFiles: font font path = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" result = ");
      localStringBuilder.append(bool);
      QLog.d("FontUpdateBusiness", 2, localStringBuilder.toString());
      return bool;
    }
    if (paramString.startsWith("font.fzfont.android."))
    {
      paramString = paramString.substring(20, paramString.length());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FontManagerConstants.FONT_FZ_COMPATIBLE_DIR);
      localStringBuilder.append(paramString);
      localStringBuilder.append(File.separatorChar);
      localStringBuilder.append(paramString);
      localStringBuilder.append(".ttf");
      paramString = localStringBuilder.toString();
      bool = VasUpdateUtil.a(new File(paramString));
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("deleteFiles: font font fz path = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" result = ");
        localStringBuilder.append(bool);
        QLog.d("FontUpdateBusiness", 2, localStringBuilder.toString());
      }
      return bool;
    }
    if (paramString.equals("magicFontConfig.json"))
    {
      bool = VasUpdateUtil.a(new File(FontManagerConstants.FONT_EFFECT_CFG));
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("deleteFiles: fontEffect json path = ");
        paramString.append(FontManagerConstants.FONT_EFFECT_CFG);
        paramString.append(" result = ");
        paramString.append(bool);
        QLog.d("FontUpdateBusiness", 2, paramString.toString());
      }
      return bool;
    }
    return false;
  }
  
  private boolean deleteHiboomFont(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = paramString1.substring(paramString2.length(), paramString1.length());
    paramString2 = new StringBuilder();
    paramString2.append(paramString3);
    paramString2.append(paramString1);
    paramString1 = paramString2.toString();
    boolean bool = VasUpdateUtil.a(new File(paramString1));
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString4);
      paramString2.append(paramString1);
      paramString2.append(" result = ");
      paramString2.append(bool);
      QLog.d("FontUpdateBusiness", 2, paramString2.toString());
    }
    return bool;
  }
  
  private boolean diyCardFontExist(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = paramString1.substring(paramString2.length(), paramString1.length());
    paramString2 = new StringBuilder();
    paramString2.append(paramString3);
    paramString2.append(paramString1);
    paramString2 = paramString2.toString();
    paramString3 = new File(paramString2);
    if (paramString3.exists()) {
      paramString1 = paramString3.list();
    } else {
      paramString1 = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString4);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" exist = ");
    localStringBuilder.append(paramString3.exists());
    localStringBuilder.append(" file count = ");
    boolean bool2 = false;
    int i;
    if (paramString1 != null) {
      i = paramString1.length;
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    QLog.d("FontUpdateBusiness", 2, localStringBuilder.toString());
    boolean bool1 = bool2;
    if (paramString3.exists())
    {
      bool1 = bool2;
      if (paramString1 != null)
      {
        bool1 = bool2;
        if (paramString1.length > 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void diyHiBoomCardFontInit(String paramString, int paramInt)
  {
    if (paramInt == 0)
    {
      paramString = paramString.substring(21, paramString.length());
      if (TextUtils.isDigitsOnly(paramString))
      {
        paramInt = Integer.parseInt(paramString);
        HiBoomFont.a().a(paramInt, 1, HiBoomConstants.a).a(false);
      }
    }
  }
  
  private void fontDownloadComplete(String paramString1, String paramString2, int paramInt, AppRuntime paramAppRuntime, String paramString3)
  {
    int i = Integer.parseInt(paramString1.substring(paramString3.length(), paramString1.length()));
    paramString1 = (IFontManagerService)paramAppRuntime.getRuntimeService(IFontManagerService.class, "");
    if (paramString1 != null) {
      paramString1.onDownloadComplete(i, paramInt, paramString2);
    }
  }
  
  private TagItemInfo getBidFontInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    StringBuilder localStringBuilder;
    if (paramString.startsWith("font.diycard.android."))
    {
      paramTagItemInfo.jdField_a_of_type_Boolean = false;
      paramTagItemInfo.b = true;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(VipDiyCardConstants.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(paramString.substring(21, paramString.length()));
      paramTagItemInfo.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      return paramTagItemInfo;
    }
    if (paramString.startsWith("font.hifont.android."))
    {
      paramTagItemInfo.jdField_a_of_type_Boolean = false;
      paramTagItemInfo.b = true;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HiBoomFont.b);
      localStringBuilder.append(paramString.substring(20, paramString.length()));
      paramTagItemInfo.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      return paramTagItemInfo;
    }
    if (paramString.startsWith("font.hiFontQQ.json."))
    {
      paramTagItemInfo.jdField_a_of_type_Boolean = false;
      paramTagItemInfo.b = true;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HiBoomFont.c);
      localStringBuilder.append(paramString.substring(19, paramString.length()));
      paramTagItemInfo.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      return paramTagItemInfo;
    }
    if (paramString.startsWith("font.hiFontQQ.tags"))
    {
      paramTagItemInfo.jdField_a_of_type_Boolean = false;
      paramTagItemInfo.b = true;
      paramTagItemInfo.jdField_a_of_type_JavaLangString = HiBoomFont.d;
      return paramTagItemInfo;
    }
    if (paramString.startsWith("font.main.android."))
    {
      paramTagItemInfo.jdField_a_of_type_Boolean = false;
      paramTagItemInfo.b = true;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FontManagerConstants.FONT_DOWN_LOAD_PATH);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString.substring(18, paramString.length()));
      paramTagItemInfo.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      return paramTagItemInfo;
    }
    if (paramString.startsWith("font.fzfont.android."))
    {
      paramTagItemInfo.jdField_a_of_type_Boolean = false;
      paramTagItemInfo.b = true;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FontManagerConstants.FONT_FZ_COMPATIBLE_DIR);
      localStringBuilder.append(paramString.substring(20, paramString.length()));
      paramTagItemInfo.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      return paramTagItemInfo;
    }
    if (paramString.equals("magicFontConfig.json"))
    {
      paramTagItemInfo.jdField_a_of_type_Boolean = false;
      paramTagItemInfo.b = false;
      paramTagItemInfo.jdField_a_of_type_JavaLangString = FontManagerConstants.FONT_EFFECT_CFG;
    }
    return paramTagItemInfo;
  }
  
  private void hiBoomFontOnCompleted(String paramString, int paramInt, AppRuntime paramAppRuntime)
  {
    paramString = paramString.substring(20, paramString.length());
    if (TextUtils.isDigitsOnly(paramString))
    {
      int i = Integer.parseInt(paramString);
      if (paramInt == 0) {
        HiBoomFont.a().a(i, 0, HiBoomConstants.b).a(false);
      } else {
        HiBoomFont.a().a(i, 0, HiBoomConstants.b).a();
      }
      paramString = ((IVasService)paramAppRuntime.getRuntimeService(IVasService.class, "")).getHiBoomManager();
      if (paramString != null) {
        paramString.onHiBoomItemDownloaded(i, paramInt);
      }
    }
  }
  
  private void hiboomConfig(String paramString, int paramInt, AppRuntime paramAppRuntime)
  {
    paramString = paramString.substring(19, paramString.length());
    if (TextUtils.isDigitsOnly(paramString))
    {
      int i = Integer.parseInt(paramString);
      if (paramInt == 0)
      {
        paramString = ((IVasService)paramAppRuntime.getRuntimeService(IVasService.class, "")).getHiBoomManager();
        if (paramString != null) {
          paramString.loadHiBoomConfig(i, false, true, true);
        }
      }
      else
      {
        VasWebviewUtil.a(paramAppRuntime.getCurrentUin(), "HighFont", "DownCoverFail", "", 1, 0, 0, "", paramString, "");
      }
    }
  }
  
  private void hiboomInvalidatePanel(int paramInt, AppRuntime paramAppRuntime)
  {
    if (paramInt == 0)
    {
      paramAppRuntime = ((IVasService)paramAppRuntime.getRuntimeService(IVasService.class, "")).getHiBoomManager();
      if (paramAppRuntime != null) {
        paramAppRuntime.invalidateHiBoomPanel();
      }
    }
  }
  
  private boolean isFontExists(String paramString)
  {
    if (paramString.startsWith("font.diycard.android.")) {
      return diyCardFontExist(paramString, "font.diycard.android.", VipDiyCardConstants.jdField_a_of_type_JavaLangString, "isFileExists hiboomfont path = ");
    }
    if (paramString.startsWith("font.hifont.android.")) {
      return diyCardFontExist(paramString, "font.hifont.android.", HiBoomFont.b, "isFileExists hiboomfont path = ");
    }
    if (paramString.startsWith("font.hiFontQQ.json.")) {
      return diyCardFontExist(paramString, "font.hiFontQQ.json.", HiBoomFont.c, "isFileExists hiboomconfig path = ");
    }
    boolean bool1 = paramString.startsWith("font.hiFontQQ.tags");
    boolean bool2 = false;
    if (bool1)
    {
      paramString = new File(HiBoomFont.d);
      if (paramString.exists()) {
        paramString = paramString.list();
      } else {
        paramString = null;
      }
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.length > 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    Object localObject;
    StringBuilder localStringBuilder;
    if (paramString.startsWith("font.main.android."))
    {
      paramString = paramString.substring(18, paramString.length());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FontManagerConstants.FONT_DOWN_LOAD_PATH);
      ((StringBuilder)localObject).append(File.separatorChar);
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(File.separatorChar);
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".ttf");
      paramString = ((StringBuilder)localObject).toString();
      localObject = new File(paramString);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isFileExists font path = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" result = ");
      localStringBuilder.append(((File)localObject).exists());
      QLog.d("FontUpdateBusiness", 2, localStringBuilder.toString());
      return ((File)localObject).exists();
    }
    if (paramString.startsWith("font.fzfont.android."))
    {
      paramString = paramString.substring(20, paramString.length());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FontManagerConstants.FONT_FZ_COMPATIBLE_DIR);
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(File.separatorChar);
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".ttf");
      paramString = ((StringBuilder)localObject).toString();
      localObject = new File(paramString);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isFileExists font path = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" result = ");
      localStringBuilder.append(((File)localObject).exists());
      QLog.d("FontUpdateBusiness", 2, localStringBuilder.toString());
      return ((File)localObject).exists();
    }
    if (paramString.equals("magicFontConfig.json"))
    {
      paramString = new File(FontManagerConstants.FONT_EFFECT_CFG);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isFileExists fontEffectJson path = ");
      ((StringBuilder)localObject).append(FontManagerConstants.FONT_EFFECT_CFG);
      ((StringBuilder)localObject).append(" result = ");
      ((StringBuilder)localObject).append(paramString.exists());
      QLog.d("FontUpdateBusiness", 2, ((StringBuilder)localObject).toString());
      return paramString.exists();
    }
    return false;
  }
  
  public boolean canUpdate(long paramLong, String paramString1, String paramString2)
  {
    paramString2 = new StringBuilder();
    paramString2.append("canUpdate bid = ");
    paramString2.append(paramLong);
    paramString2.append(" scid = ");
    paramString2.append(paramString1);
    QLog.i("FontUpdateBusiness", 1, paramString2.toString());
    if ((paramLong == 5L) && (paramString1.startsWith("font.main.android.")))
    {
      paramString1 = paramString1.substring(18, paramString1.length());
      boolean bool1 = TextUtils.isEmpty(paramString1);
      boolean bool2 = false;
      if (bool1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FontUpdateBusiness", 2, "canUpdate error: font id is empty");
        }
        return false;
      }
      int i = Integer.parseInt(paramString1);
      paramString1 = (IFontManagerService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFontManagerService.class, "");
      bool1 = bool2;
      if (paramString1 != null)
      {
        bool1 = bool2;
        if (!paramString1.isFontLoaded(i)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return true;
  }
  
  public boolean deleteFiles(long paramLong, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("deleteFiles bid = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" scid = ");
    localStringBuilder.append(paramString);
    QLog.i("FontUpdateBusiness", 1, localStringBuilder.toString());
    return deleteFont(paramString);
  }
  
  public void doOnCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    paramString2 = new StringBuilder();
    paramString2.append("doOnCompleted bid = ");
    paramString2.append(paramLong);
    paramString2.append(" scid = ");
    paramString2.append(paramString1);
    paramString2.append(" errorCode = ");
    paramString2.append(paramInt1);
    paramString2.append(" httpCode = ");
    paramString2.append(paramInt2);
    QLog.i("FontUpdateBusiness", 1, paramString2.toString());
    paramString2 = MobileQQ.sMobileQQ.peekAppRuntime();
    if (paramString1.startsWith("font.diycard.android."))
    {
      diyHiBoomCardFontInit(paramString1, paramInt1);
      return;
    }
    if (paramString1.startsWith("font.hifont.android."))
    {
      hiBoomFontOnCompleted(paramString1, paramInt1, paramString2);
      return;
    }
    if (paramString1.startsWith("font.hiFontQQ.json."))
    {
      hiboomConfig(paramString1, paramInt1, paramString2);
      return;
    }
    if (paramString1.startsWith("font.hiFontQQ.tags"))
    {
      hiboomInvalidatePanel(paramInt1, paramString2);
      return;
    }
    if (paramString1.startsWith("font.main.android."))
    {
      fontDownloadComplete(paramString1, paramString3, paramInt1, paramString2, "font.main.android.");
      return;
    }
    if (paramString1.startsWith("font.fzfont.android."))
    {
      fontDownloadComplete(paramString1, paramString3, paramInt1, paramString2, "font.fzfont.android.");
      return;
    }
    if (paramString1.equals("magicFontConfig.json"))
    {
      paramString1 = (IFontManagerService)paramString2.getRuntimeService(IFontManagerService.class, "");
      paramString2 = new File(FontManagerConstants.FONT_EFFECT_CFG);
      if (paramString1 != null) {
        paramString1.parseFontEffectJSON(paramString2);
      }
    }
  }
  
  public void doOnProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    paramString2 = MobileQQ.sMobileQQ.peekAppRuntime();
    if (paramLong1 == 5L)
    {
      int i;
      if (paramString1.startsWith("font.main.android."))
      {
        i = Integer.parseInt(paramString1.substring(18, paramString1.length()));
        paramString1 = (IFontManagerService)paramString2.getRuntimeService(IFontManagerService.class, "");
        if (paramString1 != null) {
          paramString1.onProgress(i, (float)paramLong2 / (float)paramLong3);
        }
      }
      else if (paramString1.startsWith("font.hifont.android."))
      {
        paramString1 = paramString1.substring(20, paramString1.length());
        if ((!TextUtils.isEmpty(paramString1)) && (TextUtils.isDigitsOnly(paramString1)))
        {
          i = Integer.parseInt(paramString1);
          paramString1 = ((IVasService)paramString2.getRuntimeService(IVasService.class, "")).getHiBoomManager();
          if (paramString1 != null) {
            paramString1.updateHiBoomItemProgress(i, (int)(paramLong2 * 100L / paramLong3));
          }
        }
      }
    }
  }
  
  public long getBID()
  {
    return 5L;
  }
  
  public TagItemInfo getItemInfo(long paramLong, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getItemInfo bid = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" scid = ");
    localStringBuilder.append(paramString);
    QLog.i("FontUpdateBusiness", 1, localStringBuilder.toString());
    return getBidFontInfo(paramString, new TagItemInfo());
  }
  
  public boolean isFileExists(long paramLong, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isFileExists bid = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" scid = ");
    localStringBuilder.append(paramString);
    QLog.i("FontUpdateBusiness", 1, localStringBuilder.toString());
    return isFontExists(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.FontUpdateBusiness
 * JD-Core Version:    0.7.0.1
 */