final class reh
  extends ref<rek, rej, rei>
{
  public void a(rek paramrek, rej paramrej, int paramInt, rei paramrei)
  {
    switch (paramInt)
    {
    default: 
      paramrek.a(paramrej);
      return;
    case 1: 
      paramrek.a(paramrej, paramrei.a, paramrei.b);
      return;
    case 2: 
      paramrek.b(paramrej, paramrei.a, paramrei.b);
      return;
    case 3: 
      paramrek.a(paramrej, paramrei.a, paramrei.c, paramrei.b);
      return;
    }
    paramrek.c(paramrej, paramrei.a, paramrei.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     reh
 * JD-Core Version:    0.7.0.1
 */