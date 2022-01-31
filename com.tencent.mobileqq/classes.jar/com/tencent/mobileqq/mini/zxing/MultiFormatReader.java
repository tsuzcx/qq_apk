package com.tencent.mobileqq.mini.zxing;

import com.tencent.mobileqq.mini.zxing.oned.MultiFormatOneDReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class MultiFormatReader
  implements Reader
{
  private static final Reader[] EMPTY_READER_ARRAY = new Reader[0];
  private Map<DecodeHintType, ?> hints;
  private Reader[] readers;
  
  private Result decodeInternal(BinaryBitmap paramBinaryBitmap)
  {
    if (this.readers != null)
    {
      Reader[] arrayOfReader = this.readers;
      int j = arrayOfReader.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfReader[i];
        try
        {
          localObject = ((Reader)localObject).decode(paramBinaryBitmap, this.hints);
          return localObject;
        }
        catch (ReaderException localReaderException)
        {
          i += 1;
        }
      }
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap)
  {
    setHints(null);
    return decodeInternal(paramBinaryBitmap);
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    setHints(paramMap);
    return decodeInternal(paramBinaryBitmap);
  }
  
  public Result decodeWithState(BinaryBitmap paramBinaryBitmap)
  {
    if (this.readers == null) {
      setHints(null);
    }
    return decodeInternal(paramBinaryBitmap);
  }
  
  public void reset()
  {
    if (this.readers != null)
    {
      Reader[] arrayOfReader = this.readers;
      int j = arrayOfReader.length;
      int i = 0;
      while (i < j)
      {
        arrayOfReader[i].reset();
        i += 1;
      }
    }
  }
  
  public void setHints(Map<DecodeHintType, ?> paramMap)
  {
    this.hints = paramMap;
    int i;
    Collection localCollection;
    label30:
    ArrayList localArrayList;
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.TRY_HARDER)))
    {
      i = 1;
      if (paramMap != null) {
        break label284;
      }
      localCollection = null;
      localArrayList = new ArrayList();
      if (localCollection != null) {
        if ((!localCollection.contains(BarcodeFormat.UPC_A)) && (!localCollection.contains(BarcodeFormat.UPC_E)) && (!localCollection.contains(BarcodeFormat.EAN_13)) && (!localCollection.contains(BarcodeFormat.EAN_8)) && (!localCollection.contains(BarcodeFormat.CODABAR)) && (!localCollection.contains(BarcodeFormat.CODE_39)) && (!localCollection.contains(BarcodeFormat.CODE_93)) && (!localCollection.contains(BarcodeFormat.CODE_128)) && (!localCollection.contains(BarcodeFormat.ITF))) {
          break label301;
        }
      }
    }
    label284:
    label301:
    for (int j = 1;; j = 0)
    {
      if ((j != 0) && (i == 0)) {
        localArrayList.add(new MultiFormatOneDReader(paramMap));
      }
      if ((j != 0) && (i != 0)) {
        localArrayList.add(new MultiFormatOneDReader(paramMap));
      }
      if (localArrayList.isEmpty())
      {
        if (i == 0) {
          localArrayList.add(new MultiFormatOneDReader(paramMap));
        }
        if (i != 0) {
          localArrayList.add(new MultiFormatOneDReader(paramMap));
        }
      }
      this.readers = ((Reader[])localArrayList.toArray(EMPTY_READER_ARRAY));
      return;
      i = 0;
      break;
      localCollection = (Collection)paramMap.get(DecodeHintType.POSSIBLE_FORMATS);
      break label30;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.MultiFormatReader
 * JD-Core Version:    0.7.0.1
 */