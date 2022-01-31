import com.tencent.component.network.utils.FileUtils.FileComparator;
import java.io.File;

public final class pky
  implements FileUtils.FileComparator
{
  public boolean a(File paramFile1, File paramFile2)
  {
    return (paramFile1.length() == paramFile2.length()) && (paramFile1.lastModified() == paramFile2.lastModified());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pky
 * JD-Core Version:    0.7.0.1
 */