import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.Vas.ColorFont.FastColorFontHelper;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.hiboom.HiBoomFont;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class qb
  implements Runnable
{
  public qb(FontManager paramFontManager, int paramInt) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject2;
    switch (this.jdField_a_of_type_Int)
    {
    case 2: 
    case 3: 
    default: 
      localObject1 = null;
      localObject2 = null;
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (VasUtils.a((String)localObject2, VasUtils.a() + File.separator, (String)localObject1)) && (VasUtils.a(VasUtils.a(), (String)localObject1) == 0)) {
        switch (this.jdField_a_of_type_Int)
        {
        }
      }
      break;
    }
    for (;;)
    {
      VasUtils.a(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      localObject2 = FontManager.jdField_a_of_type_JavaLangString + File.separator + "libColorFont.zip";
      localObject1 = "libfounderColorFont_760.so";
      break;
      localObject2 = FontManager.jdField_a_of_type_JavaLangString + File.separator + "libVipFont.zip";
      localObject1 = "libvipfont.so";
      break;
      FastColorFontHelper.a().b.set(true);
      continue;
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.e)) && (this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null))
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("callbackId", this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.e);
        ((Bundle)localObject1).putInt("srcType", 9);
        this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.a(0L, 0, (Bundle)localObject1);
        this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.e = null;
      }
      ETEngine.isSOLoaded.set(true);
      BaseApplication.getContext().getSharedPreferences("early_qq.android.native.vipfont.v5", 0).edit().putBoolean("vip_font_so_downloaded", true).commit();
      HiBoomFont.a().a();
      this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qb
 * JD-Core Version:    0.7.0.1
 */