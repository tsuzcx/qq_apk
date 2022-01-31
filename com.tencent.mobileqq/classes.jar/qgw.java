final class qgw
  extends qgu<qgz, qgy, qgx>
{
  public void a(qgz paramqgz, qgy paramqgy, int paramInt, qgx paramqgx)
  {
    switch (paramInt)
    {
    default: 
      paramqgz.a(paramqgy);
      return;
    case 1: 
      paramqgz.a(paramqgy, paramqgx.a, paramqgx.b);
      return;
    case 2: 
      paramqgz.b(paramqgy, paramqgx.a, paramqgx.b);
      return;
    case 3: 
      paramqgz.a(paramqgy, paramqgx.a, paramqgx.c, paramqgx.b);
      return;
    }
    paramqgz.c(paramqgy, paramqgx.a, paramqgx.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qgw
 * JD-Core Version:    0.7.0.1
 */