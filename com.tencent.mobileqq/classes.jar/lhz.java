import com.tencent.ttpic.util.Coffee;
import com.tencent.ttpic.util.DecryptListener;

final class lhz
  implements DecryptListener
{
  public byte[] decrypt(byte[] paramArrayOfByte)
  {
    return Coffee.drink(paramArrayOfByte, Coffee.getDefaultSign());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lhz
 * JD-Core Version:    0.7.0.1
 */