package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.DecodeHintType;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.Reader;
import com.tencent.mobileqq.mini.zxing.ReaderException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class MultiFormatOneDReader
  extends OneDReader
{
  private static final OneDReader[] EMPTY_ONED_ARRAY = new OneDReader[0];
  private final OneDReader[] readers;
  
  public MultiFormatOneDReader(Map<DecodeHintType, ?> paramMap)
  {
    Collection localCollection;
    if (paramMap == null)
    {
      localCollection = null;
      if ((paramMap == null) || (paramMap.get(DecodeHintType.ASSUME_CODE_39_CHECK_DIGIT) == null)) {
        break label376;
      }
    }
    label376:
    for (boolean bool = true;; bool = false)
    {
      ArrayList localArrayList = new ArrayList();
      if (localCollection != null)
      {
        if ((localCollection.contains(BarcodeFormat.EAN_13)) || (localCollection.contains(BarcodeFormat.UPC_A)) || (localCollection.contains(BarcodeFormat.EAN_8)) || (localCollection.contains(BarcodeFormat.UPC_E))) {
          localArrayList.add(new MultiFormatUPCEANReader(paramMap));
        }
        if (localCollection.contains(BarcodeFormat.CODE_39)) {
          localArrayList.add(new Code39Reader(bool));
        }
        if (localCollection.contains(BarcodeFormat.CODE_93)) {
          localArrayList.add(new Code93Reader());
        }
        if (localCollection.contains(BarcodeFormat.CODE_128)) {
          localArrayList.add(new Code128Reader());
        }
        if (localCollection.contains(BarcodeFormat.ITF)) {
          localArrayList.add(new ITFReader());
        }
        if (localCollection.contains(BarcodeFormat.CODABAR)) {
          localArrayList.add(new CodaBarReader());
        }
      }
      if (localArrayList.isEmpty())
      {
        localArrayList.add(new MultiFormatUPCEANReader(paramMap));
        localArrayList.add(new Code39Reader());
        localArrayList.add(new CodaBarReader());
        localArrayList.add(new Code93Reader());
        localArrayList.add(new Code128Reader());
        localArrayList.add(new ITFReader());
      }
      this.readers = ((OneDReader[])localArrayList.toArray(EMPTY_ONED_ARRAY));
      return;
      localCollection = (Collection)paramMap.get(DecodeHintType.POSSIBLE_FORMATS);
      break;
    }
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    OneDReader[] arrayOfOneDReader = this.readers;
    int j = arrayOfOneDReader.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfOneDReader[i];
      try
      {
        localObject = ((OneDReader)localObject).decodeRow(paramInt, paramBitArray, paramMap);
        return localObject;
      }
      catch (ReaderException localReaderException)
      {
        i += 1;
      }
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  public void reset()
  {
    OneDReader[] arrayOfOneDReader = this.readers;
    int j = arrayOfOneDReader.length;
    int i = 0;
    while (i < j)
    {
      arrayOfOneDReader[i].reset();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.MultiFormatOneDReader
 * JD-Core Version:    0.7.0.1
 */