import android.util.SparseArray;
import com.tencent.smtt.utils.ByteUtils;
import java.nio.ByteBuffer;

public class lpb
{
  public static SparseArray<lpa> a(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    SparseArray localSparseArray = new SparseArray();
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      short s = a(localByteBuffer, j);
      j += 2;
      int i = b(localByteBuffer, j);
      j += 2;
      byte[] arrayOfByte = a(paramArrayOfByte, j, i);
      j += i;
      localSparseArray.put(s, new lpa(s, i, arrayOfByte));
    }
    return localSparseArray;
  }
  
  private static short a(ByteBuffer paramByteBuffer, int paramInt)
  {
    return paramByteBuffer.getShort(paramInt);
  }
  
  public static byte[] a(lpa paramlpa)
  {
    if (paramlpa != null)
    {
      short s1 = paramlpa.a();
      short s2 = paramlpa.b();
      paramlpa = paramlpa.a();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(s2 + 4);
      localByteBuffer.putShort(s1);
      localByteBuffer.putShort(s2);
      localByteBuffer.put(paramlpa);
      return localByteBuffer.array();
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return ByteUtils.subByte(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private static short b(ByteBuffer paramByteBuffer, int paramInt)
  {
    return paramByteBuffer.getShort(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lpb
 * JD-Core Version:    0.7.0.1
 */