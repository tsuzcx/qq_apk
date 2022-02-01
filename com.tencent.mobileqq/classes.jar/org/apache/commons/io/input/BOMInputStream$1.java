package org.apache.commons.io.input;

import java.util.Comparator;
import org.apache.commons.io.ByteOrderMark;

final class BOMInputStream$1
  implements Comparator<ByteOrderMark>
{
  public int compare(ByteOrderMark paramByteOrderMark1, ByteOrderMark paramByteOrderMark2)
  {
    int i = paramByteOrderMark1.length();
    int j = paramByteOrderMark2.length();
    if (i > j) {
      return -1;
    }
    if (j > i) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.input.BOMInputStream.1
 * JD-Core Version:    0.7.0.1
 */