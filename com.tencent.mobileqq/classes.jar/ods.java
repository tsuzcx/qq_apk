public class ods
  extends ayks
{
  public ods(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    super(paramCharSequence, paramInt1, paramInt2);
  }
  
  public int a()
  {
    int j = 0;
    aykp[] arrayOfaykp = (aykp[])getSpans(0, super.length(), aykp.class);
    if ((arrayOfaykp == null) || (arrayOfaykp.length <= 0)) {
      return super.length();
    }
    int k = arrayOfaykp.length;
    int i = 0;
    if (i < k)
    {
      aykp localaykp = arrayOfaykp[i];
      switch (localaykp.c)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        int m = getSpanStart(localaykp);
        j += getSpanEnd(localaykp) - m - 1;
      }
    }
    return super.length() - j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ods
 * JD-Core Version:    0.7.0.1
 */