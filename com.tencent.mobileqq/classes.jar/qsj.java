final class qsj
  extends qsh<qsm, qsl, qsk>
{
  public void a(qsm paramqsm, qsl paramqsl, int paramInt, qsk paramqsk)
  {
    switch (paramInt)
    {
    default: 
      paramqsm.a(paramqsl);
      return;
    case 1: 
      paramqsm.a(paramqsl, paramqsk.a, paramqsk.b);
      return;
    case 2: 
      paramqsm.b(paramqsl, paramqsk.a, paramqsk.b);
      return;
    case 3: 
      paramqsm.a(paramqsl, paramqsk.a, paramqsk.c, paramqsk.b);
      return;
    }
    paramqsm.c(paramqsl, paramqsk.a, paramqsk.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qsj
 * JD-Core Version:    0.7.0.1
 */