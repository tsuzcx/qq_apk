public class oui
  extends bdod
{
  public oui(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    super(paramCharSequence, paramInt1, paramInt2);
  }
  
  public int a()
  {
    int j = 0;
    bdoa[] arrayOfbdoa = (bdoa[])getSpans(0, super.length(), bdoa.class);
    if ((arrayOfbdoa == null) || (arrayOfbdoa.length <= 0)) {
      return super.length();
    }
    int k = arrayOfbdoa.length;
    int i = 0;
    if (i < k)
    {
      bdoa localbdoa = arrayOfbdoa[i];
      switch (localbdoa.c)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        int m = getSpanStart(localbdoa);
        j += getSpanEnd(localbdoa) - m - 1;
      }
    }
    return super.length() - j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oui
 * JD-Core Version:    0.7.0.1
 */