import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.ComplementFileStringLoader;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

public class sfr
  implements ComplementFileStringLoader
{
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  private sfy jdField_a_of_type_Sfy;
  
  public sfr(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Sfy = new sfy(paramContext, paramString);
  }
  
  public String loadFileAsString(String paramString)
  {
    AssetManager localAssetManager = this.jdField_a_of_type_AndroidContentContext.getAssets();
    try
    {
      InputStream localInputStream = this.jdField_a_of_type_Sfy.a(paramString);
      Object localObject = localInputStream;
      if (localInputStream == null) {
        localObject = localAssetManager.open(this.jdField_a_of_type_JavaLangString + "/" + paramString);
      }
      localObject = sgi.a((InputStream)localObject);
      return localObject;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("AssetsComplementFileStringLoader", 2, "loadFileAsString: fail to include - " + paramString);
        localIOException.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sfr
 * JD-Core Version:    0.7.0.1
 */