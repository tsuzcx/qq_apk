package com.tencent.qapmsdk.memory.memorydump;

public class HeapDumperFactory
{
  public static IHeapDumper produce()
  {
    if (ForkJvmHeapDumper.getInstance().isValid()) {
      return ForkJvmHeapDumper.getInstance();
    }
    if (StandardHeapDumper.getInstance().isValid()) {
      return StandardHeapDumper.getInstance();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.memorydump.HeapDumperFactory
 * JD-Core Version:    0.7.0.1
 */