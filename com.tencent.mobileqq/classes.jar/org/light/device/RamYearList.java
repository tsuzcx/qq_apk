package org.light.device;

class RamYearList
{
  private static final long GB = 1000000000L;
  private static final long MB = 1000000L;
  private static final long[] SRamSize = { 500000000L, 1500000000L, 2500000000L, 3500000000L, 3500000000L, 5500000000L, 7500000000L };
  private static final int START_YEAR = 2012;
  
  public static int getRamYear(long paramLong)
  {
    int i = SRamSize.length - 1;
    while (i >= 0)
    {
      if (SRamSize[i] < paramLong) {
        return i + 2012;
      }
      i -= 1;
    }
    return 2012;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.device.RamYearList
 * JD-Core Version:    0.7.0.1
 */