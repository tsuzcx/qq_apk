package com.tencent.rmonitor.fd.utils;

import com.tencent.rmonitor.fd.data.FdCountable;
import java.util.Comparator;

final class FdLeakUtil$1
  implements Comparator<FdCountable>
{
  public int a(FdCountable paramFdCountable1, FdCountable paramFdCountable2)
  {
    return paramFdCountable2.getCount() - paramFdCountable1.getCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.utils.FdLeakUtil.1
 * JD-Core Version:    0.7.0.1
 */