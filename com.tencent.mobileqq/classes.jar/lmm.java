class lmm
{
  static final float[] a;
  
  static
  {
    int k = 0;
    a = new float[16384];
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 16384) {
        break;
      }
      a[i] = ((float)Math.sin((i + 0.5F) / 16384.0F * 6.283186F));
      i += 1;
    }
    while (j < 360)
    {
      a[((int)(j * 45.511112F) & 0x3FFF)] = ((float)Math.sin(j * 0.01745329F));
      j += 90;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lmm
 * JD-Core Version:    0.7.0.1
 */