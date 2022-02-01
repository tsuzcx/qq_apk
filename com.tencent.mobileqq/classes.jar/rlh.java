final class rlh
  extends rlf<rlk, rlj, rli>
{
  public void a(rlk paramrlk, rlj paramrlj, int paramInt, rli paramrli)
  {
    switch (paramInt)
    {
    default: 
      paramrlk.a(paramrlj);
      return;
    case 1: 
      paramrlk.a(paramrlj, paramrli.a, paramrli.b);
      return;
    case 2: 
      paramrlk.b(paramrlj, paramrli.a, paramrli.b);
      return;
    case 3: 
      paramrlk.a(paramrlj, paramrli.a, paramrli.c, paramrli.b);
      return;
    }
    paramrlk.c(paramrlj, paramrli.a, paramrli.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rlh
 * JD-Core Version:    0.7.0.1
 */