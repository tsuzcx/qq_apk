package cooperation.qzone.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;

public class DataUtils
{
  public static boolean closeDataObject(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    try
    {
      if ((paramObject instanceof InputStream))
      {
        ((InputStream)paramObject).close();
      }
      else if ((paramObject instanceof OutputStream))
      {
        ((OutputStream)paramObject).close();
      }
      else if ((paramObject instanceof Reader))
      {
        ((Reader)paramObject).close();
      }
      else if ((paramObject instanceof Writer))
      {
        ((Writer)paramObject).close();
      }
      else
      {
        if (!(paramObject instanceof RandomAccessFile)) {
          break label90;
        }
        ((RandomAccessFile)paramObject).close();
      }
      return true;
      label90:
      return false;
    }
    catch (IOException paramObject) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.DataUtils
 * JD-Core Version:    0.7.0.1
 */