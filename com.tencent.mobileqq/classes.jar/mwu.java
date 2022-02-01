import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.LocaleFileDownloader;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableParams;

public class mwu
  extends URLDrawableParams
{
  private ProtocolDownloader jdField_a_of_type_ComTencentImageProtocolDownloader;
  
  public mwu(AVGameAppInterface paramAVGameAppInterface, Context paramContext)
  {
    super(paramContext);
  }
  
  public ProtocolDownloader doGetDownloader(String paramString, Object paramObject)
  {
    if ("fileassistantimage".equals(paramString)) {
      return new betb(BaseApplicationImpl.getApplication());
    }
    if ("file".equalsIgnoreCase(paramString)) {
      return new LocaleFileDownloader();
    }
    if (this.jdField_a_of_type_ComTencentImageProtocolDownloader == null) {
      this.jdField_a_of_type_ComTencentImageProtocolDownloader = new beuf();
    }
    return this.jdField_a_of_type_ComTencentImageProtocolDownloader;
  }
  
  public String doGetLocalFilePath(String paramString)
  {
    return null;
  }
  
  public ApngSoLoader getApngSoLoader()
  {
    return bhzi.a();
  }
  
  public Drawable getDefaultLoadingDrawable()
  {
    return null;
  }
  
  public Drawable getDefualtFailedDrawable()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mwu
 * JD-Core Version:    0.7.0.1
 */