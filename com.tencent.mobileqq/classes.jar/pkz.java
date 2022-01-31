import android.content.Context;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.FileUtils.AssetFileComparator;
import java.io.File;

public final class pkz
  implements FileUtils.AssetFileComparator
{
  public boolean a(Context paramContext, String paramString, File paramFile)
  {
    long l = FileUtils.getAssetLength(paramContext, paramString);
    return (l != -1L) && (l == paramFile.length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pkz
 * JD-Core Version:    0.7.0.1
 */