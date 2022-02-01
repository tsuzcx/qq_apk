package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.hiboom.HiBoomFont;
import com.tencent.mobileqq.hiboom.HiBoomFontDrawer;
import com.tencent.mobileqq.hiboom.HiBoomManager;
import com.tencent.mobileqq.profile.diy.VipDiyCardConstants;
import com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.callback.TagItemInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
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
    boolean bool2;
    boolean bool1;
    if (paramString.startsWith("font.diycard.android."))
    {
      paramString = paramString.substring("font.diycard.android.".length(), paramString.length());
      paramString = VipDiyCardConstants.jdField_a_of_type_JavaLangString + paramString;
      bool2 = VasUpdateUtil.a(new File(paramString));
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("FontUpdateBusiness", 2, "deleteFiles: font diy card path = " + paramString + " result = " + bool2);
        bool1 = bool2;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                if (!paramString.startsWith("font.hifont.android.")) {
                  break;
                }
                paramString = paramString.substring("font.hifont.android.".length(), paramString.length());
                paramString = HiBoomFont.b + paramString;
                bool2 = VasUpdateUtil.a(new File(paramString));
                bool1 = bool2;
              } while (!QLog.isColorLevel());
              QLog.d("FontUpdateBusiness", 2, "deleteFiles: font hiboom path = " + paramString + " result = " + bool2);
              return bool2;
              if (!paramString.startsWith("font.hiFontQQ.json.")) {
                break;
              }
              paramString = paramString.substring("font.hiFontQQ.json.".length(), paramString.length());
              paramString = HiBoomFont.c + paramString;
              bool2 = VasUpdateUtil.a(new File(paramString));
              bool1 = bool2;
            } while (!QLog.isColorLevel());
            QLog.d("FontUpdateBusiness", 2, "deleteFiles: font hiboom config path = " + paramString + " result = " + bool2);
            return bool2;
            if (!paramString.startsWith("font.hiFontQQ.tags")) {
              break;
            }
            bool2 = VasUpdateUtil.a(new File(HiBoomFont.d));
            bool1 = bool2;
          } while (!QLog.isColorLevel());
          QLog.d("FontUpdateBusiness", 2, "deleteFiles: font hiboom tag result = " + bool2);
          return bool2;
          if (!paramString.startsWith("font.main.android.")) {
            break;
          }
          paramString = paramString.substring("font.main.android.".length(), paramString.length());
          paramString = FontManager.jdField_a_of_type_JavaLangString + File.separatorChar + paramString + File.separatorChar + paramString + ".ttf";
          bool2 = VasUpdateUtil.a(new File(paramString));
          bool1 = bool2;
        } while (!QLog.isColorLevel());
        QLog.d("FontUpdateBusiness", 2, "deleteFiles: font font path = " + paramString + " result = " + bool2);
        return bool2;
        if (!paramString.startsWith("font.fzfont.android.")) {
          break;
        }
        paramString = paramString.substring("font.fzfont.android.".length(), paramString.length());
        paramString = FontManager.b + paramString + File.separatorChar + paramString + ".ttf";
        bool2 = VasUpdateUtil.a(new File(paramString));
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("FontUpdateBusiness", 2, "deleteFiles: font font fz path = " + paramString + " result = " + bool2);
      return bool2;
      if (!paramString.equals("magicFontConfig.json")) {
        break;
      }
      bool2 = VasUpdateUtil.a(new File(FontManager.g));
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("FontUpdateBusiness", 2, "deleteFiles: fontEffect json path = " + FontManager.g + " result = " + bool2);
    return bool2;
    return false;
  }
  
  private TagItemInfo getBidFontInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    if (paramString.startsWith("font.diycard.android."))
    {
      paramTagItemInfo.jdField_a_of_type_Boolean = false;
      paramTagItemInfo.b = true;
      paramTagItemInfo.jdField_a_of_type_JavaLangString = (VipDiyCardConstants.jdField_a_of_type_JavaLangString + paramString.substring("font.diycard.android.".length(), paramString.length()));
    }
    do
    {
      return paramTagItemInfo;
      if (paramString.startsWith("font.hifont.android."))
      {
        paramTagItemInfo.jdField_a_of_type_Boolean = false;
        paramTagItemInfo.b = true;
        paramTagItemInfo.jdField_a_of_type_JavaLangString = (HiBoomFont.b + paramString.substring("font.hifont.android.".length(), paramString.length()));
        return paramTagItemInfo;
      }
      if (paramString.startsWith("font.hiFontQQ.json."))
      {
        paramTagItemInfo.jdField_a_of_type_Boolean = false;
        paramTagItemInfo.b = true;
        paramTagItemInfo.jdField_a_of_type_JavaLangString = (HiBoomFont.c + paramString.substring("font.hiFontQQ.json.".length(), paramString.length()));
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
        paramTagItemInfo.jdField_a_of_type_JavaLangString = (FontManager.jdField_a_of_type_JavaLangString + File.separator + paramString.substring("font.main.android.".length(), paramString.length()));
        return paramTagItemInfo;
      }
      if (paramString.startsWith("font.fzfont.android."))
      {
        paramTagItemInfo.jdField_a_of_type_Boolean = false;
        paramTagItemInfo.b = true;
        paramTagItemInfo.jdField_a_of_type_JavaLangString = (FontManager.b + paramString.substring("font.fzfont.android.".length(), paramString.length()));
        return paramTagItemInfo;
      }
    } while (!paramString.equals("magicFontConfig.json"));
    paramTagItemInfo.jdField_a_of_type_Boolean = false;
    paramTagItemInfo.b = false;
    paramTagItemInfo.jdField_a_of_type_JavaLangString = FontManager.g;
    return paramTagItemInfo;
  }
  
  private boolean isFontExists(String paramString)
  {
    Object localObject2 = null;
    String str = null;
    Object localObject3 = null;
    Object localObject1 = null;
    boolean bool1 = true;
    boolean bool2 = false;
    int i;
    if (paramString.startsWith("font.diycard.android."))
    {
      paramString = paramString.substring("font.diycard.android.".length(), paramString.length());
      str = VipDiyCardConstants.jdField_a_of_type_JavaLangString + paramString;
      localObject2 = new File(str);
      paramString = (String)localObject1;
      if (((File)localObject2).exists()) {
        paramString = ((File)localObject2).list();
      }
      localObject1 = new StringBuilder().append("isFileExists hiboomfont path = ").append(str).append(" exist = ").append(((File)localObject2).exists()).append(" file count = ");
      if (paramString != null)
      {
        i = paramString.length;
        QLog.d("FontUpdateBusiness", 2, i);
        bool1 = bool2;
        if (((File)localObject2).exists())
        {
          bool1 = bool2;
          if (paramString != null)
          {
            bool1 = bool2;
            if (paramString.length > 0) {
              bool1 = true;
            }
          }
        }
      }
    }
    do
    {
      return bool1;
      i = 0;
      break;
      if (paramString.startsWith("font.hifont.android."))
      {
        paramString = paramString.substring("font.hifont.android.".length(), paramString.length());
        str = HiBoomFont.b + paramString;
        localObject1 = new File(str);
        paramString = (String)localObject2;
        if (((File)localObject1).exists()) {
          paramString = ((File)localObject1).list();
        }
        localObject2 = new StringBuilder().append("isFileExists hiboomfont path = ").append(str).append(" exist = ").append(((File)localObject1).exists()).append(" file count = ");
        if (paramString != null) {}
        for (i = paramString.length;; i = 0)
        {
          QLog.d("FontUpdateBusiness", 2, i);
          if ((((File)localObject1).exists()) && (paramString != null) && (paramString.length > 0)) {
            break;
          }
          return false;
        }
      }
      if (paramString.startsWith("font.hiFontQQ.json."))
      {
        paramString = paramString.substring("font.hiFontQQ.json.".length(), paramString.length());
        localObject2 = HiBoomFont.c + paramString;
        localObject1 = new File((String)localObject2);
        paramString = str;
        if (((File)localObject1).exists()) {
          paramString = ((File)localObject1).list();
        }
        localObject2 = new StringBuilder().append("isFileExists hiboomconfig path = ").append((String)localObject2).append(" exist = ").append(((File)localObject1).exists()).append(" file count = ");
        if (paramString != null) {}
        for (i = paramString.length;; i = 0)
        {
          QLog.d("FontUpdateBusiness", 2, i);
          if ((((File)localObject1).exists()) && (paramString != null) && (paramString.length > 0)) {
            break;
          }
          return false;
        }
      }
      if (!paramString.startsWith("font.hiFontQQ.tags")) {
        break label545;
      }
      localObject1 = new File(HiBoomFont.d);
      paramString = localObject3;
      if (((File)localObject1).exists()) {
        paramString = ((File)localObject1).list();
      }
    } while ((paramString != null) && (paramString.length > 0));
    return false;
    label545:
    if (paramString.startsWith("font.main.android."))
    {
      paramString = paramString.substring("font.main.android.".length(), paramString.length());
      paramString = FontManager.jdField_a_of_type_JavaLangString + File.separatorChar + paramString + File.separatorChar + paramString + ".ttf";
      localObject1 = new File(paramString);
      QLog.d("FontUpdateBusiness", 2, "isFileExists font path = " + paramString + " result = " + ((File)localObject1).exists());
      return ((File)localObject1).exists();
    }
    if (paramString.startsWith("font.fzfont.android."))
    {
      paramString = paramString.substring("font.fzfont.android.".length(), paramString.length());
      paramString = FontManager.b + paramString + File.separatorChar + paramString + ".ttf";
      localObject1 = new File(paramString);
      QLog.d("FontUpdateBusiness", 2, "isFileExists font path = " + paramString + " result = " + ((File)localObject1).exists());
      return ((File)localObject1).exists();
    }
    if (paramString.equals("magicFontConfig.json"))
    {
      paramString = new File(FontManager.g);
      QLog.d("FontUpdateBusiness", 2, "isFileExists fontEffectJson path = " + FontManager.g + " result = " + paramString.exists());
      return paramString.exists();
    }
    return false;
  }
  
  public boolean canUpdate(long paramLong, String paramString1, String paramString2)
  {
    QLog.i("FontUpdateBusiness", 1, "canUpdate bid = " + paramLong + " scid = " + paramString1);
    if ((paramLong == 5L) && (paramString1.startsWith("font.main.android.")))
    {
      paramString1 = paramString1.substring("font.main.android.".length(), paramString1.length());
      if (TextUtils.isEmpty(paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.e("FontUpdateBusiness", 2, "canUpdate error: font id is empty");
        }
        return false;
      }
      int i = Integer.parseInt(paramString1);
      paramString1 = (FontManager)MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.CHAT_FONT_MANAGER);
      if ((paramString1 != null) && (!paramString1.a(i))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return true;
  }
  
  public boolean deleteFiles(long paramLong, String paramString)
  {
    QLog.i("FontUpdateBusiness", 1, "deleteFiles bid = " + paramLong + " scid = " + paramString);
    return deleteFont(paramString);
  }
  
  public void doOnCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    QLog.i("FontUpdateBusiness", 1, "doOnCompleted bid = " + paramLong + " scid = " + paramString1 + " errorCode = " + paramInt1 + " httpCode = " + paramInt2);
    paramString2 = MobileQQ.sMobileQQ.peekAppRuntime();
    if (paramString1.startsWith("font.diycard.android.")) {
      if (paramInt1 == 0)
      {
        paramString1 = paramString1.substring("font.diycard.android.".length(), paramString1.length());
        if (TextUtils.isDigitsOnly(paramString1))
        {
          paramInt1 = Integer.parseInt(paramString1);
          HiBoomFont.a().a(paramInt1, 1, HiBoomManager.b).a(false);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      if (!paramString1.startsWith("font.hifont.android.")) {
                        break;
                      }
                      paramString1 = paramString1.substring("font.hifont.android.".length(), paramString1.length());
                    } while (!TextUtils.isDigitsOnly(paramString1));
                    paramInt2 = Integer.parseInt(paramString1);
                    if (paramInt1 == 0) {
                      HiBoomFont.a().a(paramInt2, 0, HiBoomManager.a).a(false);
                    }
                    for (;;)
                    {
                      paramString1 = (HiBoomManager)paramString2.getManager(QQManagerFactory.HIBOOM_MANAGER);
                      if (paramString1 == null) {
                        break;
                      }
                      paramString1.b(paramInt2, paramInt1);
                      return;
                      HiBoomFont.a().a(paramInt2, 0, HiBoomManager.a).a();
                    }
                    if (!paramString1.startsWith("font.hiFontQQ.json.")) {
                      break;
                    }
                    paramString1 = paramString1.substring("font.hiFontQQ.json.".length(), paramString1.length());
                  } while (!TextUtils.isDigitsOnly(paramString1));
                  paramInt2 = Integer.parseInt(paramString1);
                  if (paramInt1 != 0) {
                    break;
                  }
                  paramString1 = (HiBoomManager)paramString2.getManager(QQManagerFactory.HIBOOM_MANAGER);
                } while (paramString1 == null);
                paramString1.a(paramInt2, false, true, true);
                return;
                VasWebviewUtil.reportCommercialDrainage(paramString2.getCurrentUin(), "HighFont", "DownCoverFail", "", 1, 0, 0, "", paramString1, "");
                return;
                if (!paramString1.startsWith("font.hiFontQQ.tags")) {
                  break;
                }
              } while (paramInt1 != 0);
              paramString1 = (HiBoomManager)paramString2.getManager(QQManagerFactory.HIBOOM_MANAGER);
            } while (paramString1 == null);
            paramString1.a();
            return;
            if (!paramString1.startsWith("font.main.android.")) {
              break;
            }
            paramInt2 = Integer.parseInt(paramString1.substring("font.main.android.".length(), paramString1.length()));
            paramString1 = (FontManager)paramString2.getManager(QQManagerFactory.CHAT_FONT_MANAGER);
          } while (paramString1 == null);
          paramString1.a(paramInt2, paramInt1, paramString3);
          return;
          if (!paramString1.startsWith("font.fzfont.android.")) {
            break;
          }
          paramInt2 = Integer.parseInt(paramString1.substring("font.fzfont.android.".length(), paramString1.length()));
          paramString1 = (FontManager)paramString2.getManager(QQManagerFactory.CHAT_FONT_MANAGER);
        } while (paramString1 == null);
        paramString1.a(paramInt2, paramInt1, paramString3);
        return;
      } while (!paramString1.equals("magicFontConfig.json"));
      paramString1 = (FontManager)paramString2.getManager(QQManagerFactory.CHAT_FONT_MANAGER);
      paramString2 = new File(FontManager.g);
    } while (paramString1 == null);
    paramString1.a(paramString2);
  }
  
  public void doOnProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    paramString2 = MobileQQ.sMobileQQ.peekAppRuntime();
    int i;
    if (paramLong1 == 5L)
    {
      if (!paramString1.startsWith("font.main.android.")) {
        break label73;
      }
      i = Integer.parseInt(paramString1.substring("font.main.android.".length(), paramString1.length()));
      paramString1 = (FontManager)paramString2.getManager(QQManagerFactory.CHAT_FONT_MANAGER);
      if (paramString1 != null) {
        paramString1.a(i, (float)paramLong2 / (float)paramLong3);
      }
    }
    label73:
    do
    {
      do
      {
        do
        {
          return;
        } while (!paramString1.startsWith("font.hifont.android."));
        paramString1 = paramString1.substring("font.hifont.android.".length(), paramString1.length());
      } while ((TextUtils.isEmpty(paramString1)) || (!TextUtils.isDigitsOnly(paramString1)));
      i = Integer.parseInt(paramString1);
      paramString1 = (HiBoomManager)paramString2.getManager(QQManagerFactory.HIBOOM_MANAGER);
    } while (paramString1 == null);
    paramString1.a(i, (int)(100L * paramLong2 / paramLong3));
  }
  
  public long getBID()
  {
    return 5L;
  }
  
  public TagItemInfo getItemInfo(long paramLong, String paramString)
  {
    QLog.i("FontUpdateBusiness", 1, "getItemInfo bid = " + paramLong + " scid = " + paramString);
    return getBidFontInfo(paramString, new TagItemInfo());
  }
  
  public boolean isFileExists(long paramLong, String paramString)
  {
    QLog.i("FontUpdateBusiness", 1, "isFileExists bid = " + paramLong + " scid = " + paramString);
    return isFontExists(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.FontUpdateBusiness
 * JD-Core Version:    0.7.0.1
 */