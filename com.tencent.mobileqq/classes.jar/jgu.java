import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.ttpic.util.Coffee;
import com.tencent.ttpic.util.DecryptListener;

public class jgu
  implements DecryptListener
{
  public jgu(EffectPendantTools paramEffectPendantTools) {}
  
  public byte[] decrypt(byte[] paramArrayOfByte)
  {
    return Coffee.drink(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jgu
 * JD-Core Version:    0.7.0.1
 */