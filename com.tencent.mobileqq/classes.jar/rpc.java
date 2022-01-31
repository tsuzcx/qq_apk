import java.util.Comparator;

final class rpc
  implements Comparator<byte[]>
{
  public int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return paramArrayOfByte1.length - paramArrayOfByte2.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rpc
 * JD-Core Version:    0.7.0.1
 */