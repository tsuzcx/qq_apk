import java.util.Comparator;

public class sso
  implements Comparator<ssm>
{
  public int a(ssm paramssm1, ssm paramssm2)
  {
    if (paramssm1.c < paramssm2.c) {
      return 1;
    }
    if (paramssm1.c > paramssm2.c) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sso
 * JD-Core Version:    0.7.0.1
 */