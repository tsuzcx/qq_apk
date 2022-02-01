import com.tencent.ttpic.util.Coffee;
import com.tencent.ttpic.util.DecryptListener;

final class lht
  implements DecryptListener
{
  public byte[] decrypt(byte[] paramArrayOfByte)
  {
    return Coffee.drink(paramArrayOfByte, Coffee.getDefaultSign());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lht
 * JD-Core Version:    0.7.0.1
 */