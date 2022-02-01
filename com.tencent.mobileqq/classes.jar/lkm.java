import com.tencent.av.core.VcControllerImpl;
import com.tencent.mobileqq.pb.CodedInputStreamMicro;
import com.tencent.mobileqq.pb.WireFormatMicro;
import java.io.IOException;

public abstract class lkm
{
  private VcControllerImpl a;
  
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
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public final byte a(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte b2 = 1;
    byte b1;
    if (this.a == null) {
      b1 = 3;
    }
    for (;;)
    {
      return b1;
      b1 = b2;
      if (paramArrayOfByte1 != null) {
        try
        {
          int i = this.a.onRecvVideoCallBytesForSharp(paramArrayOfByte1);
          b1 = b2;
          if (i >= 0) {
            return 0;
          }
        }
        catch (Throwable paramArrayOfByte1) {}
      }
    }
    return 1;
  }
  
  public final void a(VcControllerImpl paramVcControllerImpl)
  {
    this.a = paramVcControllerImpl;
  }
  
  public abstract void a(byte[] paramArrayOfByte);
  
  public abstract void a(byte[] paramArrayOfByte, long paramLong);
  
  public final byte b(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte b2 = 1;
    byte b1;
    if (this.a == null) {
      b1 = 3;
    }
    for (;;)
    {
      return b1;
      b1 = b2;
      if (paramArrayOfByte1 != null) {
        try
        {
          int i = this.a.onRecvVideoCallBytesForSharpC2SACK(paramArrayOfByte1);
          b1 = b2;
          if (i >= 0) {
            return 0;
          }
        }
        catch (Throwable paramArrayOfByte1) {}
      }
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lkm
 * JD-Core Version:    0.7.0.1
 */