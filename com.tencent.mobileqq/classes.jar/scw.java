import java.util.Comparator;

final class scw
  implements Comparator<sdf>
{
  public int a(sdf paramsdf1, sdf paramsdf2)
  {
    if (paramsdf1.a() > paramsdf2.a()) {}
    do
    {
      return 1;
      if (paramsdf1.a() < paramsdf2.a()) {
        return -1;
      }
      if (paramsdf1.d() == paramsdf2.d()) {
        return 0;
      }
    } while (paramsdf1.d() < paramsdf2.d());
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     scw
 * JD-Core Version:    0.7.0.1
 */