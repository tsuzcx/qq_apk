public class ohr
  extends bamz
{
  public ohr(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    super(paramCharSequence, paramInt1, paramInt2);
  }
  
  public int a()
  {
    int j = 0;
    bamw[] arrayOfbamw = (bamw[])getSpans(0, super.length(), bamw.class);
    if ((arrayOfbamw == null) || (arrayOfbamw.length <= 0)) {
      return super.length();
    }
    int k = arrayOfbamw.length;
    int i = 0;
    if (i < k)
    {
      bamw localbamw = arrayOfbamw[i];
      switch (localbamw.c)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        int m = getSpanStart(localbamw);
        j += getSpanEnd(localbamw) - m - 1;
      }
    }
    return super.length() - j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ohr
 * JD-Core Version:    0.7.0.1
 */