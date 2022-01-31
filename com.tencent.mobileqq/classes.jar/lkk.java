import com.tencent.ttpic.util.Coffee;
import com.tencent.ttpic.util.DecryptListener;

final class lkk
  implements DecryptListener
{
  public byte[] decrypt(byte[] paramArrayOfByte)
  {
    return Coffee.drink(paramArrayOfByte, Coffee.getDefaultSign());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lkk
 * JD-Core Version:    0.7.0.1
 */