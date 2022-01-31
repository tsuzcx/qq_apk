class pwv
  implements pwp
{
  pwv(pwu parampwu) {}
  
  public void a() {}
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      pwu.a(this.a, paramString1);
      pwu.b(this.a, paramString2);
      pwu.a(this.a, 3);
      return;
    case 1001: 
      pwu.b(this.a, 10);
      return;
    case 1002: 
      pwu.b(this.a, 9);
      return;
    case 1003: 
      pwu.b(this.a, 11);
      return;
    }
    pwu.b(this.a, 13);
    pwu.c(this.a, 1002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pwv
 * JD-Core Version:    0.7.0.1
 */