public class ohr
  extends baiq
{
  public ohr(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    super(paramCharSequence, paramInt1, paramInt2);
  }
  
  public int a()
  {
    int j = 0;
    bain[] arrayOfbain = (bain[])getSpans(0, super.length(), bain.class);
    if ((arrayOfbain == null) || (arrayOfbain.length <= 0)) {
      return super.length();
    }
    int k = arrayOfbain.length;
    int i = 0;
    if (i < k)
    {
      bain localbain = arrayOfbain[i];
      switch (localbain.c)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        int m = getSpanStart(localbain);
        j += getSpanEnd(localbain) - m - 1;
      }
    }
    return super.length() - j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ohr
 * JD-Core Version:    0.7.0.1
 */