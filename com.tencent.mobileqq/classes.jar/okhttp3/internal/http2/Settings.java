package okhttp3.internal.http2;

import java.util.Arrays;

public final class Settings
{
  static final int COUNT = 10;
  static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
  static final int ENABLE_PUSH = 2;
  static final int HEADER_TABLE_SIZE = 1;
  static final int INITIAL_WINDOW_SIZE = 7;
  static final int MAX_CONCURRENT_STREAMS = 4;
  static final int MAX_FRAME_SIZE = 5;
  static final int MAX_HEADER_LIST_SIZE = 6;
  private int set;
  private final int[] values = new int[10];
  
  void clear()
  {
    this.set = 0;
    Arrays.fill(this.values, 0);
  }
  
  int get(int paramInt)
  {
    return this.values[paramInt];
  }
  
  boolean getEnablePush(boolean paramBoolean)
  {
    int i = this.set;
    boolean bool = false;
    if ((i & 0x4) != 0) {
      i = this.values[2];
    } else if (paramBoolean) {
      i = 1;
    } else {
      i = 0;
    }
    paramBoolean = bool;
    if (i == 1) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  int getHeaderTableSize()
  {
    if ((this.set & 0x2) != 0) {
      return this.values[1];
    }
    return -1;
  }
  
  int getInitialWindowSize()
  {
    if ((this.set & 0x80) != 0) {
      return this.values[7];
    }
    return 65535;
  }
  
  int getMaxConcurrentStreams(int paramInt)
  {
    if ((this.set & 0x10) != 0) {
      paramInt = this.values[4];
    }
    return paramInt;
  }
  
  int getMaxFrameSize(int paramInt)
  {
    if ((this.set & 0x20) != 0) {
      paramInt = this.values[5];
    }
    return paramInt;
  }
  
  int getMaxHeaderListSize(int paramInt)
  {
    if ((this.set & 0x40) != 0) {
      paramInt = this.values[6];
    }
    return paramInt;
  }
  
  boolean isSet(int paramInt)
  {
    return (1 << paramInt & this.set) != 0;
  }
  
  void merge(Settings paramSettings)
  {
    int i = 0;
    while (i < 10)
    {
      if (paramSettings.isSet(i)) {
        set(i, paramSettings.get(i));
      }
      i += 1;
    }
  }
  
  Settings set(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      int[] arrayOfInt = this.values;
      if (paramInt1 >= arrayOfInt.length) {
        return this;
      }
      this.set = (1 << paramInt1 | this.set);
      arrayOfInt[paramInt1] = paramInt2;
    }
    return this;
  }
  
  int size()
  {
    return Integer.bitCount(this.set);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.http2.Settings
 * JD-Core Version:    0.7.0.1
 */