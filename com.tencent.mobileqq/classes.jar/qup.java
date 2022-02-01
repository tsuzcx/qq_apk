import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import java.io.File;
import java.io.OutputStream;

public class qup
  extends beqz
{
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams = paramDownloadParams.urlStr;
    if (paramDownloadParams.startsWith("readinjoy_skin_gif://")) {
      paramOutputStream = paramDownloadParams.replace("readinjoy_skin_gif://", "");
    }
    for (;;)
    {
      paramOutputStream = new File(paramOutputStream);
      if (!paramOutputStream.exists()) {
        break;
      }
      return paramOutputStream;
      paramOutputStream = paramDownloadParams;
      if (paramDownloadParams.startsWith("readinjoy_skin_gif:")) {
        paramOutputStream = paramDownloadParams.replace("readinjoy_skin_gif:", "");
      }
    }
    return null;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new quq(this, paramFile, false, false, 0, 0, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qup
 * JD-Core Version:    0.7.0.1
 */