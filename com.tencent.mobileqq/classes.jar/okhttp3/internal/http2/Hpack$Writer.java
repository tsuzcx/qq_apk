package okhttp3.internal.http2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;

final class Hpack$Writer
{
  private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
  private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
  Header[] dynamicTable = new Header[8];
  int dynamicTableByteCount = 0;
  private boolean emitDynamicTableSizeUpdate;
  int headerCount = 0;
  int headerTableSizeSetting;
  int maxDynamicTableByteCount;
  int nextHeaderIndex = this.dynamicTable.length - 1;
  private final Buffer out;
  private int smallestHeaderTableSizeSetting = 2147483647;
  private final boolean useCompression;
  
  Hpack$Writer(int paramInt, boolean paramBoolean, Buffer paramBuffer)
  {
    this.headerTableSizeSetting = paramInt;
    this.maxDynamicTableByteCount = paramInt;
    this.useCompression = paramBoolean;
    this.out = paramBuffer;
  }
  
  Hpack$Writer(Buffer paramBuffer)
  {
    this(4096, true, paramBuffer);
  }
  
  private void adjustDynamicTableByteCount()
  {
    int i = this.maxDynamicTableByteCount;
    int j = this.dynamicTableByteCount;
    if (i < j)
    {
      if (i == 0)
      {
        clearDynamicTable();
        return;
      }
      evictToRecoverBytes(j - i);
    }
  }
  
  private void clearDynamicTable()
  {
    Arrays.fill(this.dynamicTable, null);
    this.nextHeaderIndex = (this.dynamicTable.length - 1);
    this.headerCount = 0;
    this.dynamicTableByteCount = 0;
  }
  
  private int evictToRecoverBytes(int paramInt)
  {
    int i = 0;
    int k = 0;
    if (paramInt > 0)
    {
      i = this.dynamicTable.length - 1;
      int j = paramInt;
      paramInt = k;
      while ((i >= this.nextHeaderIndex) && (j > 0))
      {
        j -= this.dynamicTable[i].hpackSize;
        this.dynamicTableByteCount -= this.dynamicTable[i].hpackSize;
        this.headerCount -= 1;
        paramInt += 1;
        i -= 1;
      }
      Header[] arrayOfHeader = this.dynamicTable;
      i = this.nextHeaderIndex;
      System.arraycopy(arrayOfHeader, i + 1, arrayOfHeader, i + 1 + paramInt, this.headerCount);
      arrayOfHeader = this.dynamicTable;
      i = this.nextHeaderIndex;
      Arrays.fill(arrayOfHeader, i + 1, i + 1 + paramInt, null);
      this.nextHeaderIndex += paramInt;
      i = paramInt;
    }
    return i;
  }
  
  private void insertIntoDynamicTable(Header paramHeader)
  {
    int i = paramHeader.hpackSize;
    int j = this.maxDynamicTableByteCount;
    if (i > j)
    {
      clearDynamicTable();
      return;
    }
    evictToRecoverBytes(this.dynamicTableByteCount + i - j);
    j = this.headerCount;
    Header[] arrayOfHeader1 = this.dynamicTable;
    if (j + 1 > arrayOfHeader1.length)
    {
      Header[] arrayOfHeader2 = new Header[arrayOfHeader1.length * 2];
      System.arraycopy(arrayOfHeader1, 0, arrayOfHeader2, arrayOfHeader1.length, arrayOfHeader1.length);
      this.nextHeaderIndex = (this.dynamicTable.length - 1);
      this.dynamicTable = arrayOfHeader2;
    }
    j = this.nextHeaderIndex;
    this.nextHeaderIndex = (j - 1);
    this.dynamicTable[j] = paramHeader;
    this.headerCount += 1;
    this.dynamicTableByteCount += i;
  }
  
  void setHeaderTableSizeSetting(int paramInt)
  {
    this.headerTableSizeSetting = paramInt;
    paramInt = Math.min(paramInt, 16384);
    int i = this.maxDynamicTableByteCount;
    if (i == paramInt) {
      return;
    }
    if (paramInt < i) {
      this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, paramInt);
    }
    this.emitDynamicTableSizeUpdate = true;
    this.maxDynamicTableByteCount = paramInt;
    adjustDynamicTableByteCount();
  }
  
  void writeByteString(ByteString paramByteString)
  {
    if ((this.useCompression) && (Huffman.get().encodedLength(paramByteString) < paramByteString.size()))
    {
      Buffer localBuffer = new Buffer();
      Huffman.get().encode(paramByteString, localBuffer);
      paramByteString = localBuffer.readByteString();
      writeInt(paramByteString.size(), 127, 128);
      this.out.write(paramByteString);
      return;
    }
    writeInt(paramByteString.size(), 127, 0);
    this.out.write(paramByteString);
  }
  
  void writeHeaders(List<Header> paramList)
  {
    int i;
    if (this.emitDynamicTableSizeUpdate)
    {
      i = this.smallestHeaderTableSizeSetting;
      if (i < this.maxDynamicTableByteCount) {
        writeInt(i, 31, 32);
      }
      this.emitDynamicTableSizeUpdate = false;
      this.smallestHeaderTableSizeSetting = 2147483647;
      writeInt(this.maxDynamicTableByteCount, 31, 32);
    }
    int i2 = paramList.size();
    int k = 0;
    while (k < i2)
    {
      Header localHeader = (Header)paramList.get(k);
      ByteString localByteString1 = localHeader.name.toAsciiLowercase();
      ByteString localByteString2 = localHeader.value;
      Integer localInteger = (Integer)Hpack.NAME_TO_FIRST_INDEX.get(localByteString1);
      int j;
      if (localInteger != null)
      {
        j = localInteger.intValue() + 1;
        if ((j > 1) && (j < 8))
        {
          if (Util.equal(Hpack.STATIC_HEADER_TABLE[(j - 1)].value, localByteString2))
          {
            i = j;
            break label198;
          }
          if (Util.equal(Hpack.STATIC_HEADER_TABLE[j].value, localByteString2))
          {
            i = j;
            j += 1;
            break label198;
          }
        }
        i = j;
        j = -1;
      }
      else
      {
        j = -1;
        i = -1;
      }
      label198:
      int n = j;
      int i1 = i;
      if (j == -1)
      {
        int m = this.nextHeaderIndex + 1;
        int i3 = this.dynamicTable.length;
        for (;;)
        {
          n = j;
          i1 = i;
          if (m >= i3) {
            break;
          }
          n = i;
          if (Util.equal(this.dynamicTable[m].name, localByteString1))
          {
            if (Util.equal(this.dynamicTable[m].value, localByteString2))
            {
              j = this.nextHeaderIndex;
              n = Hpack.STATIC_HEADER_TABLE.length + (m - j);
              i1 = i;
              break;
            }
            n = i;
            if (i == -1) {
              n = m - this.nextHeaderIndex + Hpack.STATIC_HEADER_TABLE.length;
            }
          }
          m += 1;
          i = n;
        }
      }
      if (n != -1)
      {
        writeInt(n, 127, 128);
      }
      else if (i1 == -1)
      {
        this.out.writeByte(64);
        writeByteString(localByteString1);
        writeByteString(localByteString2);
        insertIntoDynamicTable(localHeader);
      }
      else if ((localByteString1.startsWith(Header.PSEUDO_PREFIX)) && (!Header.TARGET_AUTHORITY.equals(localByteString1)))
      {
        writeInt(i1, 15, 0);
        writeByteString(localByteString2);
      }
      else
      {
        writeInt(i1, 63, 64);
        writeByteString(localByteString2);
        insertIntoDynamicTable(localHeader);
      }
      k += 1;
    }
  }
  
  void writeInt(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2)
    {
      this.out.writeByte(paramInt1 | paramInt3);
      return;
    }
    this.out.writeByte(paramInt3 | paramInt2);
    paramInt1 -= paramInt2;
    while (paramInt1 >= 128)
    {
      this.out.writeByte(0x80 | paramInt1 & 0x7F);
      paramInt1 >>>= 7;
    }
    this.out.writeByte(paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.http2.Hpack.Writer
 * JD-Core Version:    0.7.0.1
 */