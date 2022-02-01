package com.tencent.qqmusic.mediaplayer.seektable.mpeg4;

import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;
import com.tencent.qqmusic.mediaplayer.seektable.ParsableInputStreamWrapper;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Co64;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.GhostBox;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.IMpeg4Box;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Mdhd;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stco;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stsc;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stsz;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stts;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Mp4SeekTable
  implements SeekTable
{
  private final Map<String, IMpeg4Box> essentialStblChunkMap = new HashMap();
  private final Mdhd mdhd;
  
  public Mp4SeekTable()
  {
    this.essentialStblChunkMap.put("stco", new Stco());
    this.essentialStblChunkMap.put("co64", new Co64());
    this.essentialStblChunkMap.put("stts", new Stts());
    this.essentialStblChunkMap.put("stsc", new Stsc());
    this.essentialStblChunkMap.put("stsz", new Stsz());
    this.mdhd = new Mdhd();
  }
  
  private static void chunkOfSample(Stsc paramStsc, int paramInt, int[] paramArrayOfInt)
  {
    int i2 = paramStsc.getEntryCount();
    int n = 0;
    int k = 1;
    int j = 0;
    int i = 0;
    for (;;)
    {
      int m = paramStsc.getFirstChunk()[n];
      int i1 = (m - k) * j + i;
      if (paramInt < i1)
      {
        m = 1;
      }
      else
      {
        j = paramStsc.getSamplesPerChunk()[n];
        k = n;
        if (n < i2)
        {
          k = n + 1;
          i = i1;
        }
        if (k < i2) {
          break label141;
        }
        k = m;
        m = 0;
      }
      if (j != 0)
      {
        if (m != 0) {
          paramInt = (paramInt - i) / j + k;
        } else {
          paramInt = k;
        }
      }
      else {
        paramInt = 1;
      }
      paramArrayOfInt[0] = paramInt;
      paramArrayOfInt[1] = (i + (paramInt - k) * j);
      return;
      label141:
      n = k;
      k = m;
    }
  }
  
  private static boolean needMoreChunks(HashSet<String> paramHashSet)
  {
    if (paramHashSet.size() > 2) {
      return true;
    }
    return (paramHashSet.contains("stco")) && (paramHashSet.contains("co64"));
  }
  
  private static long offset64OfChunk(Co64 paramCo64, int paramInt)
  {
    if (paramInt > paramCo64.getEntryCount()) {
      return paramCo64.getChunkOffset()[(paramCo64.getEntryCount() - 1)];
    }
    if (paramCo64.getEntryCount() > 0) {
      return paramCo64.getChunkOffset()[(paramInt - 1)];
    }
    return 8L;
  }
  
  private static int offsetOfChunk(Stco paramStco, int paramInt)
  {
    if (paramInt > paramStco.getEntryCount()) {
      return paramStco.getChunkOffset()[(paramStco.getEntryCount() - 1)];
    }
    if (paramStco.getEntryCount() > 0) {
      return paramStco.getChunkOffset()[(paramInt - 1)];
    }
    return 8;
  }
  
  private static int offsetOfSampleInChunk(Stsz paramStsz, int paramInt1, int paramInt2)
  {
    if (paramStsz.getSampleSize() != 0) {
      return (paramInt1 - paramInt2) * paramStsz.getSampleSize();
    }
    int i = 0;
    int j = Math.min(paramInt1, paramStsz.getSampleCount());
    paramInt1 = i;
    while (paramInt2 < j)
    {
      paramInt1 += paramStsz.getEntrySize()[paramInt2];
      paramInt2 += 1;
    }
    return paramInt1;
  }
  
  private static void parseChunks(Parsable paramParsable, Map<String, IMpeg4Box> paramMap, Mp4SeekTable.Function1<HashSet<String>, Boolean> paramFunction1)
  {
    GhostBox localGhostBox = new GhostBox();
    HashSet localHashSet = new HashSet(paramMap.keySet());
    while (((paramFunction1 == null) || (((Boolean)paramFunction1.call(localHashSet)).booleanValue())) && (localHashSet.size() != 0) && (paramParsable.available() > 0L))
    {
      localGhostBox.parse(paramParsable, null);
      String str = localGhostBox.getType();
      IMpeg4Box localIMpeg4Box = (IMpeg4Box)paramMap.get(str);
      if (localIMpeg4Box == null)
      {
        paramParsable.skip(localGhostBox.getSize() - 8L);
      }
      else
      {
        localIMpeg4Box.parse(paramParsable, localGhostBox);
        localHashSet.remove(str);
      }
    }
    if (paramFunction1 != null)
    {
      if (!((Boolean)paramFunction1.call(localHashSet)).booleanValue()) {
        return;
      }
      throw new InvalidBoxException("invalid box: critical box not found!");
    }
  }
  
  private static int sampleOfTime(Stts paramStts, int paramInt)
  {
    int i1 = paramStts.getEntryCount();
    int n = 0;
    int k = paramInt;
    int j = 0;
    paramInt = 0;
    int i = 0;
    int m;
    for (;;)
    {
      m = n;
      if (j >= i1) {
        break;
      }
      i = paramStts.getSampleDelta()[j];
      m = paramStts.getSampleCount()[j];
      int i2 = m * i;
      if (k < i2)
      {
        m = 1;
        break;
      }
      k -= i2;
      paramInt += m;
      j += 1;
    }
    j = paramInt;
    if (m != 0) {
      j = paramInt + k / i;
    }
    return j;
  }
  
  private long seekInternal(int paramInt)
  {
    int[] arrayOfInt = new int[2];
    paramInt = sampleOfTime((Stts)this.essentialStblChunkMap.get("stts"), paramInt);
    chunkOfSample((Stsc)this.essentialStblChunkMap.get("stsc"), paramInt, arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    long l;
    if (((IMpeg4Box)this.essentialStblChunkMap.get("stco")).getSize() != 0L)
    {
      l = offsetOfChunk((Stco)this.essentialStblChunkMap.get("stco"), i);
    }
    else
    {
      if (((IMpeg4Box)this.essentialStblChunkMap.get("co64")).getSize() == 0L) {
        break label170;
      }
      l = offset64OfChunk((Co64)this.essentialStblChunkMap.get("co64"), i);
    }
    return l + offsetOfSampleInChunk((Stsz)this.essentialStblChunkMap.get("stsz"), paramInt, j);
    label170:
    throw new RuntimeException("invalid stbl: both [stco] nor [co64] was found!");
  }
  
  private static IMpeg4Box seekTo(Parsable paramParsable, String paramString)
  {
    GhostBox localGhostBox = new GhostBox();
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ".");
    paramString = null;
    for (;;)
    {
      if (!localStringTokenizer.hasMoreTokens()) {
        return paramString;
      }
      String str = localStringTokenizer.nextToken();
      int i = 0;
      while ((i == 0) && (paramParsable.available() > 0L))
      {
        localGhostBox.parse(paramParsable, null);
        if (str.equalsIgnoreCase(localGhostBox.getType())) {
          break label90;
        }
        paramParsable.skip(localGhostBox.getSize() - 8L);
      }
      continue;
      label90:
      i = 1;
      if (localStringTokenizer.hasMoreTokens()) {
        break;
      }
      paramString = localGhostBox;
    }
    return paramString;
  }
  
  public void parse(IDataSource paramIDataSource)
  {
    paramIDataSource = new ParsableInputStreamWrapper(paramIDataSource);
    if (seekTo(paramIDataSource, "moov.trak.mdia") != null)
    {
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("mdhd", this.mdhd);
      localHashMap.put("minf", new GhostBox());
      parseChunks(paramIDataSource, localHashMap, null);
      if (seekTo(paramIDataSource, "stbl") != null)
      {
        parseChunks(paramIDataSource, this.essentialStblChunkMap, new Mp4SeekTable.1(this));
        return;
      }
      throw new InvalidBoxException("invalid mp4: no [stbl] was found!");
    }
    throw new InvalidBoxException("invalid mp4: no [mdia] was found!");
  }
  
  public long seek(long paramLong)
  {
    double d = this.mdhd.getTimeScale() * paramLong;
    Double.isNaN(d);
    return seekInternal((int)Math.round(d / 1000.0D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mpeg4.Mp4SeekTable
 * JD-Core Version:    0.7.0.1
 */