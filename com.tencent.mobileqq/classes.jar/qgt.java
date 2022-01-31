final class qgt
  extends qgr<qgw, qgv, qgu>
{
  public void a(qgw paramqgw, qgv paramqgv, int paramInt, qgu paramqgu)
  {
    switch (paramInt)
    {
    default: 
      paramqgw.a(paramqgv);
      return;
    case 1: 
      paramqgw.a(paramqgv, paramqgu.a, paramqgu.b);
      return;
    case 2: 
      paramqgw.b(paramqgv, paramqgu.a, paramqgu.b);
      return;
    case 3: 
      paramqgw.a(paramqgv, paramqgu.a, paramqgu.c, paramqgu.b);
      return;
    }
    paramqgw.c(paramqgv, paramqgu.a, paramqgu.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qgt
 * JD-Core Version:    0.7.0.1
 */