import com.tencent.component.media.image.ImageManager;
import java.io.File;
import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;

public final class plk
  implements Comparator
{
  public int a(File paramFile1, File paramFile2)
  {
    String str = paramFile1.getName();
    Integer localInteger2 = (Integer)ImageManager.b().get(str);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null)
    {
      localInteger1 = Integer.valueOf((int)(paramFile1.lastModified() / 1000L));
      ImageManager.b().put(str, localInteger1);
    }
    str = paramFile2.getName();
    localInteger2 = (Integer)ImageManager.b().get(str);
    paramFile1 = localInteger2;
    if (localInteger2 == null)
    {
      paramFile1 = Integer.valueOf((int)(paramFile2.lastModified() / 1000L));
      ImageManager.b().put(str, paramFile1);
    }
    if (localInteger1.intValue() > paramFile1.intValue()) {
      return -1;
    }
    if (localInteger1.intValue() < paramFile1.intValue()) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     plk
 * JD-Core Version:    0.7.0.1
 */