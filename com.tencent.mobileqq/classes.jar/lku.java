import com.tencent.mobileqq.pb.CodedInputStreamMicro;
import com.tencent.mobileqq.pb.WireFormatMicro;
import java.io.IOException;

public class lku
{
  public static byte a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 3)) {
      return -1;
    }
    return paramArrayOfByte[2];
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = CodedInputStreamMicro.newInstance(paramArrayOfByte);
    try
    {
      for (;;)
      {
        int i = paramArrayOfByte.readTag();
        if (i == 0) {
          break;
        }
        if (WireFormatMicro.getTagFieldNumber(i) == 2) {
          return true;
        }
        paramArrayOfByte.skipField(i);
      }
      return false;
    }
    catch (IOException paramArrayOfByte)
    {
      if (mwv.c()) {
        mwv.a("AbstractNetChannel", "", paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lku
 * JD-Core Version:    0.7.0.1
 */