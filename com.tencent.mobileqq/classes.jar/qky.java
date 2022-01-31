import com.tencent.hotpatch.config.BasePatchConfig;
import java.util.Comparator;

public final class qky
  implements Comparator
{
  public int a(BasePatchConfig paramBasePatchConfig1, BasePatchConfig paramBasePatchConfig2)
  {
    if ((paramBasePatchConfig1 == null) && (paramBasePatchConfig2 == null)) {}
    do
    {
      return 0;
      if ((paramBasePatchConfig1 == null) && (paramBasePatchConfig2 != null)) {
        return 1;
      }
      if ((paramBasePatchConfig1 != null) && (paramBasePatchConfig2 == null)) {
        return -1;
      }
      if (paramBasePatchConfig1.a > paramBasePatchConfig2.a) {
        return -1;
      }
    } while (paramBasePatchConfig1.a >= paramBasePatchConfig2.a);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     qky
 * JD-Core Version:    0.7.0.1
 */