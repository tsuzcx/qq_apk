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
    Reader[] arrayOfReader = this.readers;
    if (arrayOfReader != null)
    {
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
          label45:
          break label45;
        }
        i += 1;
      }
    }
    else
    {
      paramBinaryBitmap = NotFoundException.getNotFoundInstance();
      for (;;)
      {
        throw paramBinaryBitmap;
      }
    }
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
    Reader[] arrayOfReader = this.readers;
    if (arrayOfReader != null)
    {
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
    int k = 1;
    int i;
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.TRY_HARDER))) {
      i = 1;
    } else {
      i = 0;
    }
    Collection localCollection;
    if (paramMap == null) {
      localCollection = null;
    } else {
      localCollection = (Collection)paramMap.get(DecodeHintType.POSSIBLE_FORMATS);
    }
    ArrayList localArrayList = new ArrayList();
    if (localCollection != null)
    {
      int j = k;
      if (!localCollection.contains(BarcodeFormat.UPC_A))
      {
        j = k;
        if (!localCollection.contains(BarcodeFormat.UPC_E))
        {
          j = k;
          if (!localCollection.contains(BarcodeFormat.EAN_13))
          {
            j = k;
            if (!localCollection.contains(BarcodeFormat.EAN_8))
            {
              j = k;
              if (!localCollection.contains(BarcodeFormat.CODABAR))
              {
                j = k;
                if (!localCollection.contains(BarcodeFormat.CODE_39))
                {
                  j = k;
                  if (!localCollection.contains(BarcodeFormat.CODE_93))
                  {
                    j = k;
                    if (!localCollection.contains(BarcodeFormat.CODE_128)) {
                      if (localCollection.contains(BarcodeFormat.ITF)) {
                        j = k;
                      } else {
                        j = 0;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      if ((j != 0) && (i == 0)) {
        localArrayList.add(new MultiFormatOneDReader(paramMap));
      }
      if ((j != 0) && (i != 0)) {
        localArrayList.add(new MultiFormatOneDReader(paramMap));
      }
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.MultiFormatReader
 * JD-Core Version:    0.7.0.1
 */