import android.util.SparseArray;
import com.tencent.smtt.utils.ByteUtils;
import java.nio.ByteBuffer;

public class lpg
{
  public static SparseArray<lpf> a(byte[] paramArrayOfByte)
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
      localSparseArray.put(s, new lpf(s, i, arrayOfByte));
    }
    return localSparseArray;
  }
  
  private static short a(ByteBuffer paramByteBuffer, int paramInt)
  {
    return paramByteBuffer.getShort(paramInt);
  }
  
  public static byte[] a(lpf paramlpf)
  {
    if (paramlpf != null)
    {
      short s1 = paramlpf.a();
      short s2 = paramlpf.b();
      paramlpf = paramlpf.a();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(s2 + 4);
      localByteBuffer.putShort(s1);
      localByteBuffer.putShort(s2);
      localByteBuffer.put(paramlpf);
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
 * Qualified Name:     lpg
 * JD-Core Version:    0.7.0.1
 */