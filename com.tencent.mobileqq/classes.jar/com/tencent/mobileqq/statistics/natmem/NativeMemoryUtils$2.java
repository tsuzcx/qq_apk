package com.tencent.mobileqq.statistics.natmem;

import java.util.ArrayList;

final class NativeMemoryUtils$2
  extends ArrayList<String>
{
  NativeMemoryUtils$2()
  {
    add(".*/libssl.so$");
    add("/system/lib/.*$");
    add("^/vendor/lib/.*$");
    add("^/system/.*$");
    add(".*/libjavacore.so$");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.natmem.NativeMemoryUtils.2
 * JD-Core Version:    0.7.0.1
 */