package com.tencent.rmonitor.heapdump;

public class HeapDumperProvider
{
  private static final IHeapDumper[] a = { new ForkJvmHeapDumper(), new StandardHeapDumper() };
  
  public static IHeapDumper a()
  {
    IHeapDumper[] arrayOfIHeapDumper = a;
    int j = arrayOfIHeapDumper.length;
    int i = 0;
    while (i < j)
    {
      IHeapDumper localIHeapDumper = arrayOfIHeapDumper[i];
      if (localIHeapDumper.a()) {
        return localIHeapDumper;
      }
      i += 1;
    }
    return new StandardHeapDumper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.heapdump.HeapDumperProvider
 * JD-Core Version:    0.7.0.1
 */