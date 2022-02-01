import android.util.SparseArray;
import com.tencent.smtt.utils.ByteUtils;
import java.nio.ByteBuffer;

public class lop
{
  public static SparseArray<loo> a(byte[] paramArrayOfByte)
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
      localSparseArray.put(s, new loo(s, i, arrayOfByte));
    }
    return localSparseArray;
  }
  
  private static short a(ByteBuffer paramByteBuffer, int paramInt)
  {
    return paramByteBuffer.getShort(paramInt);
  }
  
  public static byte[] a(loo paramloo)
  {
    if (paramloo != null)
    {
      short s1 = paramloo.a();
      short s2 = paramloo.b();
      paramloo = paramloo.a();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(s2 + 4);
      localByteBuffer.putShort(s1);
      localByteBuffer.putShort(s2);
      localByteBuffer.put(paramloo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lop
 * JD-Core Version:    0.7.0.1
 */