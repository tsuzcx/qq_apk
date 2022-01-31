import android.graphics.Typeface;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class qd
  implements Runnable
{
  public qd(FontManager paramFontManager, int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean) {}
  
  public void run()
  {
    if (FontManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int)) != null) {
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "asyncLoadFont font " + this.jdField_a_of_type_Int + " has loaded");
      }
    }
    label291:
    label372:
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            return;
            localObject = FontManager.a(this.jdField_a_of_type_Int, this.b);
            if (!new File((String)localObject).exists()) {
              break label486;
            }
            localObject = new FontInfo(this.jdField_a_of_type_Int, (String)localObject);
            ((FontInfo)localObject).b = this.b;
            if (this.b == 0) {
              ((FontInfo)localObject).b = 1;
            }
            switch (this.b)
            {
            default: 
              return;
            case 1: 
              if (!ETEngine.getInstance().isEngineInited.get())
              {
                if (QLog.isColorLevel()) {
                  QLog.e("VasFont", 2, "doGetUserFont and fontEngine not init");
                }
                this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.b();
              }
              if (!ETEngine.getInstance().isEngineReady.get()) {
                break label372;
              }
              if (this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null) {
                break label291;
              }
            }
          } while (!QLog.isColorLevel());
          QLog.e("VasFont", 2, "doGetUserFont mEngine = null");
          return;
          try
          {
            ((FontInfo)localObject).jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(((FontInfo)localObject).jdField_a_of_type_JavaLangString);
            FontManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), localObject);
            VasUtils.a(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            return;
          }
          catch (Exception localException)
          {
            QLog.e("VasFont", 1, "getFontInfo createTypeface error: " + localException.getMessage());
            ((FontInfo)localObject).jdField_a_of_type_AndroidGraphicsTypeface = null;
            return;
          }
          if ((this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_isFontLoaded(this.jdField_a_of_type_Int)) || (this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a((FontInfo)localObject, this.jdField_a_of_type_JavaLangString, this.c))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("VasFont", 2, "doGetUserFont setActiveFont fail");
        return;
        FontManager.c = true;
        FontManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), localObject);
        VasUtils.a(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      } while (!QLog.isColorLevel());
      QLog.e("VasFont", 2, "doGetUserFont fontEngine not init mIsFontEngineReady = " + ETEngine.getInstance().isEngineReady.get() + " mIsFontEngineInited = " + ETEngine.getInstance().isEngineInited.get());
      return;
      FontManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), localObject);
      VasUtils.a(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      ((FontInfo)localObject).b = 4;
      FontManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), localObject);
      VasUtils.a(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      if ((this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_Boolean) || (NetworkUtil.h(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) || (NetworkUtil.c(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()))) {
        break;
      }
    } while (!QLog.isColorLevel());
    label486:
    QLog.e("VasFont", 2, "getFontInfo isTroopOrDiscussion but no wifi or 3G 4G.");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "getFontInfo startDownload no cache");
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(this.jdField_a_of_type_Int, null, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qd
 * JD-Core Version:    0.7.0.1
 */