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
    if (this.maxDynamicTableByteCount < this.dynamicTableByteCount)
    {
      if (this.maxDynamicTableByteCount == 0) {
        clearDynamicTable();
      }
    }
    else {
      return;
    }
    evictToRecoverBytes(this.dynamicTableByteCount - this.maxDynamicTableByteCount);
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
      System.arraycopy(this.dynamicTable, this.nextHeaderIndex + 1, this.dynamicTable, this.nextHeaderIndex + 1 + paramInt, this.headerCount);
      Arrays.fill(this.dynamicTable, this.nextHeaderIndex + 1, this.nextHeaderIndex + 1 + paramInt, null);
      this.nextHeaderIndex += paramInt;
      i = paramInt;
    }
    return i;
  }
  
  private void insertIntoDynamicTable(Header paramHeader)
  {
    int i = paramHeader.hpackSize;
    if (i > this.maxDynamicTableByteCount)
    {
      clearDynamicTable();
      return;
    }
    evictToRecoverBytes(this.dynamicTableByteCount + i - this.maxDynamicTableByteCount);
    if (this.headerCount + 1 > this.dynamicTable.length)
    {
      Header[] arrayOfHeader = new Header[this.dynamicTable.length * 2];
      System.arraycopy(this.dynamicTable, 0, arrayOfHeader, this.dynamicTable.length, this.dynamicTable.length);
      this.nextHeaderIndex = (this.dynamicTable.length - 1);
      this.dynamicTable = arrayOfHeader;
    }
    int j = this.nextHeaderIndex;
    this.nextHeaderIndex = (j - 1);
    this.dynamicTable[j] = paramHeader;
    this.headerCount += 1;
    this.dynamicTableByteCount = (i + this.dynamicTableByteCount);
  }
  
  void setHeaderTableSizeSetting(int paramInt)
  {
    this.headerTableSizeSetting = paramInt;
    paramInt = Math.min(paramInt, 16384);
    if (this.maxDynamicTableByteCount == paramInt) {
      return;
    }
    if (paramInt < this.maxDynamicTableByteCount) {
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
    if (this.emitDynamicTableSizeUpdate)
    {
      if (this.smallestHeaderTableSizeSetting < this.maxDynamicTableByteCount) {
        writeInt(this.smallestHeaderTableSizeSetting, 31, 32);
      }
      this.emitDynamicTableSizeUpdate = false;
      this.smallestHeaderTableSizeSetting = 2147483647;
      writeInt(this.maxDynamicTableByteCount, 31, 32);
    }
    int i2 = paramList.size();
    int k = 0;
    Header localHeader;
    ByteString localByteString1;
    ByteString localByteString2;
    int j;
    int i;
    if (k < i2)
    {
      localHeader = (Header)paramList.get(k);
      localByteString1 = localHeader.name.toAsciiLowercase();
      localByteString2 = localHeader.value;
      Integer localInteger = (Integer)Hpack.NAME_TO_FIRST_INDEX.get(localByteString1);
      if (localInteger == null) {
        break label446;
      }
      j = localInteger.intValue() + 1;
      if ((j <= 1) || (j >= 8)) {
        break label441;
      }
      if (Util.equal(Hpack.STATIC_HEADER_TABLE[(j - 1)].value, localByteString2)) {
        i = j;
      }
    }
    for (;;)
    {
      label160:
      int n = j;
      int i1 = i;
      int m;
      if (i == -1)
      {
        m = this.nextHeaderIndex + 1;
        int i3 = this.dynamicTable.length;
        label186:
        n = j;
        i1 = i;
        if (m < i3)
        {
          n = j;
          if (!Util.equal(this.dynamicTable[m].name, localByteString1)) {
            break label326;
          }
          if (!Util.equal(this.dynamicTable[m].value, localByteString2)) {
            break label304;
          }
          i1 = m - this.nextHeaderIndex + Hpack.STATIC_HEADER_TABLE.length;
          n = j;
        }
      }
      if (i1 != -1) {
        writeInt(i1, 127, 128);
      }
      for (;;)
      {
        k += 1;
        break;
        if (!Util.equal(Hpack.STATIC_HEADER_TABLE[j].value, localByteString2)) {
          break label441;
        }
        i = j + 1;
        break label160;
        label304:
        n = j;
        if (j == -1) {
          n = m - this.nextHeaderIndex + Hpack.STATIC_HEADER_TABLE.length;
        }
        label326:
        m += 1;
        j = n;
        break label186;
        if (n == -1)
        {
          this.out.writeByte(64);
          writeByteString(localByteString1);
          writeByteString(localByteString2);
          insertIntoDynamicTable(localHeader);
        }
        else if ((localByteString1.startsWith(Header.PSEUDO_PREFIX)) && (!Header.TARGET_AUTHORITY.equals(localByteString1)))
        {
          writeInt(n, 15, 0);
          writeByteString(localByteString2);
        }
        else
        {
          writeInt(n, 63, 64);
          writeByteString(localByteString2);
          insertIntoDynamicTable(localHeader);
        }
      }
      return;
      label441:
      i = -1;
      continue;
      label446:
      j = -1;
      i = -1;
    }
  }
  
  void writeInt(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2)
    {
      this.out.writeByte(paramInt3 | paramInt1);
      return;
    }
    this.out.writeByte(paramInt3 | paramInt2);
    paramInt1 -= paramInt2;
    while (paramInt1 >= 128)
    {
      this.out.writeByte(paramInt1 & 0x7F | 0x80);
      paramInt1 >>>= 7;
    }
    this.out.writeByte(paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.internal.http2.Hpack.Writer
 * JD-Core Version:    0.7.0.1
 */