import com.Vas.ColorFont.FastColorFontHelper;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import java.util.concurrent.atomic.AtomicBoolean;

public class py
  implements Runnable
{
  public py(FontManager paramFontManager) {}
  
  public void run()
  {
    switch (VasUtils.a(VasUtils.a(), "libfounderColorFont_760.so"))
    {
    default: 
      return;
    case 1: 
      ((VasQuickUpdateManager)this.a.a.getManager(183)).a(1004L, "libColorFont_760", "FontManager_initFZEngine");
      return;
    }
    FastColorFontHelper.a().b.set(true);
    VasUtils.a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     py
 * JD-Core Version:    0.7.0.1
 */