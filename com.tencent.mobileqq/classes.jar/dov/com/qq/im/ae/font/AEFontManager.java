package dov.com.qq.im.ae.font;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import java.io.File;
import java.util.HashMap;

public class AEFontManager
{
  private static volatile boolean jdField_a_of_type_Boolean = false;
  private final HashMap<String, Typeface> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static AEFontManager a()
  {
    return AEFontManager.Holder.a;
  }
  
  private void a(AEEditorDownloadResBean paramAEEditorDownloadResBean)
  {
    String str = paramAEEditorDownloadResBean.getId();
    paramAEEditorDownloadResBean = paramAEEditorDownloadResBean.getFontFamily();
    if (a().a(str) == Typeface.DEFAULT) {
      ThreadManager.excute(new AEFontManager.2(this, str, paramAEEditorDownloadResBean), 64, null, false);
    }
  }
  
  @NonNull
  public Typeface a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = Typeface.DEFAULT;
    }
    Typeface localTypeface;
    do
    {
      return paramString;
      localTypeface = (Typeface)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      paramString = localTypeface;
    } while (localTypeface != null);
    return Typeface.DEFAULT;
  }
  
  public void a()
  {
    if (jdField_a_of_type_Boolean)
    {
      AEQLog.b("AEFontManager", "[preDownloadAndRegisterGifFonts] already triggered");
      return;
    }
    jdField_a_of_type_Boolean = true;
    ThreadManager.excute(new AEFontManager.1(this), 128, null, false);
  }
  
  public void a(String paramString, Typeface paramTypeface)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramTypeface == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramTypeface);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return;
      if (a(paramString1) == Typeface.DEFAULT)
      {
        paramString2 = new File(paramString2);
        if (!paramString2.exists())
        {
          AEQLog.d("AEFontManager", "[cacheTypeface], fontFile not exists, path=" + paramString2.getAbsolutePath());
          return;
        }
        try
        {
          paramString2 = Typeface.createFromFile(paramString2);
          if (paramString2 != null)
          {
            a(paramString1, paramString2);
            return;
          }
        }
        catch (Throwable paramString1)
        {
          AEQLog.a("AEFontManager", "[cacheTypeface], create typeface raised exception, e=", paramString1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.font.AEFontManager
 * JD-Core Version:    0.7.0.1
 */