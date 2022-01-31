public class nsi
  extends axkn
{
  public nsi(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    super(paramCharSequence, paramInt1, paramInt2);
  }
  
  public int a()
  {
    int j = 0;
    axkk[] arrayOfaxkk = (axkk[])getSpans(0, super.length(), axkk.class);
    if ((arrayOfaxkk == null) || (arrayOfaxkk.length <= 0)) {
      return super.length();
    }
    int k = arrayOfaxkk.length;
    int i = 0;
    if (i < k)
    {
      axkk localaxkk = arrayOfaxkk[i];
      switch (localaxkk.c)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        int m = getSpanStart(localaxkk);
        j += getSpanEnd(localaxkk) - m - 1;
      }
    }
    return super.length() - j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsi
 * JD-Core Version:    0.7.0.1
 */