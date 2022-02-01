public class omv
  extends begz
{
  public omv(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    super(paramCharSequence, paramInt1, paramInt2);
  }
  
  public int a()
  {
    int j = 0;
    begw[] arrayOfbegw = (begw[])getSpans(0, super.length(), begw.class);
    if ((arrayOfbegw == null) || (arrayOfbegw.length <= 0)) {
      return super.length();
    }
    int k = arrayOfbegw.length;
    int i = 0;
    if (i < k)
    {
      begw localbegw = arrayOfbegw[i];
      switch (localbegw.c)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        int m = getSpanStart(localbegw);
        j += getSpanEnd(localbegw) - m - 1;
      }
    }
    return super.length() - j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     omv
 * JD-Core Version:    0.7.0.1
 */