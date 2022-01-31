final class puy
  extends puw<pvb, pva, puz>
{
  public void a(pvb parampvb, pva parampva, int paramInt, puz parampuz)
  {
    switch (paramInt)
    {
    default: 
      parampvb.a(parampva);
      return;
    case 1: 
      parampvb.a(parampva, parampuz.a, parampuz.b);
      return;
    case 2: 
      parampvb.b(parampva, parampuz.a, parampuz.b);
      return;
    case 3: 
      parampvb.a(parampva, parampuz.a, parampuz.c, parampuz.b);
      return;
    }
    parampvb.c(parampva, parampuz.a, parampuz.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     puy
 * JD-Core Version:    0.7.0.1
 */