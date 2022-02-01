import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.ComplementFileStringLoader;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

public class svb
  implements ComplementFileStringLoader
{
  private svi a;
  
  public svb(svi paramsvi)
  {
    this.a = paramsvi;
  }
  
  public String loadFileAsString(String paramString)
  {
    try
    {
      InputStream localInputStream = this.a.a(paramString);
      if (localInputStream == null) {
        throw new IllegalStateException(paramString + " not found");
      }
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("OfflineComplementFileStringLoader", 2, "loadFileAsString: fail to include - " + paramString);
        localIOException.printStackTrace();
      }
      return null;
    }
    String str = svr.a(localIOException);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     svb
 * JD-Core Version:    0.7.0.1
 */