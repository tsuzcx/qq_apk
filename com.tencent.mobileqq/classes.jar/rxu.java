final class rxu
  extends rxs<rxx, rxw, rxv>
{
  public void a(rxx paramrxx, rxw paramrxw, int paramInt, rxv paramrxv)
  {
    switch (paramInt)
    {
    default: 
      paramrxx.a(paramrxw);
      return;
    case 1: 
      paramrxx.a(paramrxw, paramrxv.a, paramrxv.b);
      return;
    case 2: 
      paramrxx.b(paramrxw, paramrxv.a, paramrxv.b);
      return;
    case 3: 
      paramrxx.a(paramrxw, paramrxv.a, paramrxv.c, paramrxv.b);
      return;
    }
    paramrxx.c(paramrxw, paramrxv.a, paramrxv.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxu
 * JD-Core Version:    0.7.0.1
 */