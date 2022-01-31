package okhttp3.internal.http2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

final class Hpack$Reader
{
  Header[] dynamicTable = new Header[8];
  int dynamicTableByteCount = 0;
  int headerCount = 0;
  private final List<Header> headerList = new ArrayList();
  private final int headerTableSizeSetting;
  private int maxDynamicTableByteCount;
  int nextHeaderIndex = this.dynamicTable.length - 1;
  private final BufferedSource source;
  
  Hpack$Reader(int paramInt1, int paramInt2, Source paramSource)
  {
    this.headerTableSizeSetting = paramInt1;
    this.maxDynamicTableByteCount = paramInt2;
    this.source = Okio.buffer(paramSource);
  }
  
  Hpack$Reader(int paramInt, Source paramSource)
  {
    this(paramInt, paramInt, paramSource);
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
  
  private int dynamicTableIndex(int paramInt)
  {
    return this.nextHeaderIndex + 1 + paramInt;
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
      this.nextHeaderIndex += paramInt;
      i = paramInt;
    }
    return i;
  }
  
  private ByteString getName(int paramInt)
  {
    if (isStaticHeader(paramInt)) {
      return Hpack.STATIC_HEADER_TABLE[paramInt].name;
    }
    int i = dynamicTableIndex(paramInt - Hpack.STATIC_HEADER_TABLE.length);
    if ((i < 0) || (i >= this.dynamicTable.length)) {
      throw new IOException("Header index too large " + (paramInt + 1));
    }
    return this.dynamicTable[i].name;
  }
  
  private void insertIntoDynamicTable(int paramInt, Header paramHeader)
  {
    this.headerList.add(paramHeader);
    int j = paramHeader.hpackSize;
    int i = j;
    if (paramInt != -1) {
      i = j - this.dynamicTable[dynamicTableIndex(paramInt)].hpackSize;
    }
    if (i > this.maxDynamicTableByteCount)
    {
      clearDynamicTable();
      return;
    }
    j = evictToRecoverBytes(this.dynamicTableByteCount + i - this.maxDynamicTableByteCount);
    if (paramInt == -1)
    {
      if (this.headerCount + 1 > this.dynamicTable.length)
      {
        Header[] arrayOfHeader = new Header[this.dynamicTable.length * 2];
        System.arraycopy(this.dynamicTable, 0, arrayOfHeader, this.dynamicTable.length, this.dynamicTable.length);
        this.nextHeaderIndex = (this.dynamicTable.length - 1);
        this.dynamicTable = arrayOfHeader;
      }
      paramInt = this.nextHeaderIndex;
      this.nextHeaderIndex = (paramInt - 1);
      this.dynamicTable[paramInt] = paramHeader;
      this.headerCount += 1;
    }
    for (;;)
    {
      this.dynamicTableByteCount = (i + this.dynamicTableByteCount);
      return;
      int k = dynamicTableIndex(paramInt);
      this.dynamicTable[(j + k + paramInt)] = paramHeader;
    }
  }
  
  private boolean isStaticHeader(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= Hpack.STATIC_HEADER_TABLE.length - 1);
  }
  
  private int readByte()
  {
    return this.source.readByte() & 0xFF;
  }
  
  private void readIndexedHeader(int paramInt)
  {
    if (isStaticHeader(paramInt))
    {
      Header localHeader = Hpack.STATIC_HEADER_TABLE[paramInt];
      this.headerList.add(localHeader);
      return;
    }
    int i = dynamicTableIndex(paramInt - Hpack.STATIC_HEADER_TABLE.length);
    if ((i < 0) || (i >= this.dynamicTable.length)) {
      throw new IOException("Header index too large " + (paramInt + 1));
    }
    this.headerList.add(this.dynamicTable[i]);
  }
  
  private void readLiteralHeaderWithIncrementalIndexingIndexedName(int paramInt)
  {
    insertIntoDynamicTable(-1, new Header(getName(paramInt), readByteString()));
  }
  
  private void readLiteralHeaderWithIncrementalIndexingNewName()
  {
    insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
  }
  
  private void readLiteralHeaderWithoutIndexingIndexedName(int paramInt)
  {
    ByteString localByteString1 = getName(paramInt);
    ByteString localByteString2 = readByteString();
    this.headerList.add(new Header(localByteString1, localByteString2));
  }
  
  private void readLiteralHeaderWithoutIndexingNewName()
  {
    ByteString localByteString1 = Hpack.checkLowercase(readByteString());
    ByteString localByteString2 = readByteString();
    this.headerList.add(new Header(localByteString1, localByteString2));
  }
  
  public List<Header> getAndResetHeaderList()
  {
    ArrayList localArrayList = new ArrayList(this.headerList);
    this.headerList.clear();
    return localArrayList;
  }
  
  int maxDynamicTableByteCount()
  {
    return this.maxDynamicTableByteCount;
  }
  
  ByteString readByteString()
  {
    int j = readByte();
    if ((j & 0x80) == 128) {}
    for (int i = 1;; i = 0)
    {
      j = readInt(j, 127);
      if (i == 0) {
        break;
      }
      return ByteString.of(Huffman.get().decode(this.source.readByteArray(j)));
    }
    return this.source.readByteString(j);
  }
  
  void readHeaders()
  {
    while (!this.source.exhausted())
    {
      int i = this.source.readByte() & 0xFF;
      if (i == 128) {
        throw new IOException("index == 0");
      }
      if ((i & 0x80) == 128)
      {
        readIndexedHeader(readInt(i, 127) - 1);
      }
      else if (i == 64)
      {
        readLiteralHeaderWithIncrementalIndexingNewName();
      }
      else if ((i & 0x40) == 64)
      {
        readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(i, 63) - 1);
      }
      else if ((i & 0x20) == 32)
      {
        this.maxDynamicTableByteCount = readInt(i, 31);
        if ((this.maxDynamicTableByteCount < 0) || (this.maxDynamicTableByteCount > this.headerTableSizeSetting)) {
          throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
        }
        adjustDynamicTableByteCount();
      }
      else if ((i == 16) || (i == 0))
      {
        readLiteralHeaderWithoutIndexingNewName();
      }
      else
      {
        readLiteralHeaderWithoutIndexingIndexedName(readInt(i, 15) - 1);
      }
    }
  }
  
  int readInt(int paramInt1, int paramInt2)
  {
    paramInt1 &= paramInt2;
    if (paramInt1 < paramInt2) {
      return paramInt1;
    }
    paramInt1 = 0;
    int i;
    for (;;)
    {
      i = readByte();
      if ((i & 0x80) == 0) {
        break;
      }
      paramInt2 += ((i & 0x7F) << paramInt1);
      paramInt1 += 7;
    }
    return (i << paramInt1) + paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.internal.http2.Hpack.Reader
 * JD-Core Version:    0.7.0.1
 */