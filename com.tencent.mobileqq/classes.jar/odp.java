public class odp
  extends ayku
{
  public odp(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    super(paramCharSequence, paramInt1, paramInt2);
  }
  
  public int a()
  {
    int j = 0;
    aykr[] arrayOfaykr = (aykr[])getSpans(0, super.length(), aykr.class);
    if ((arrayOfaykr == null) || (arrayOfaykr.length <= 0)) {
      return super.length();
    }
    int k = arrayOfaykr.length;
    int i = 0;
    if (i < k)
    {
      aykr localaykr = arrayOfaykr[i];
      switch (localaykr.c)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        int m = getSpanStart(localaykr);
        j += getSpanEnd(localaykr) - m - 1;
      }
    }
    return super.length() - j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odp
 * JD-Core Version:    0.7.0.1
 */