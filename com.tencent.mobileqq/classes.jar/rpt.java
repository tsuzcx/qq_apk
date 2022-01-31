import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.ComplementFileStringLoader;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

public class rpt
  implements ComplementFileStringLoader
{
  private rqa a;
  
  public rpt(rqa paramrqa)
  {
    this.a = paramrqa;
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
    String str = rqj.a(localIOException);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rpt
 * JD-Core Version:    0.7.0.1
 */