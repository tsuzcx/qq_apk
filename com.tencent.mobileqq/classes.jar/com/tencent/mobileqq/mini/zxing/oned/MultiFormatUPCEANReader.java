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

public final class MultiFormatUPCEANReader
  extends OneDReader
{
  private static final UPCEANReader[] EMPTY_READER_ARRAY = new UPCEANReader[0];
  private final UPCEANReader[] readers;
  
  public MultiFormatUPCEANReader(Map<DecodeHintType, ?> paramMap)
  {
    ArrayList localArrayList;
    if (paramMap == null)
    {
      paramMap = null;
      localArrayList = new ArrayList();
      if (paramMap != null)
      {
        if (!paramMap.contains(BarcodeFormat.EAN_13)) {
          break label184;
        }
        localArrayList.add(new EAN13Reader());
      }
    }
    for (;;)
    {
      if (paramMap.contains(BarcodeFormat.EAN_8)) {
        localArrayList.add(new EAN8Reader());
      }
      if (paramMap.contains(BarcodeFormat.UPC_E)) {
        localArrayList.add(new UPCEReader());
      }
      if (localArrayList.isEmpty())
      {
        localArrayList.add(new EAN13Reader());
        localArrayList.add(new EAN8Reader());
        localArrayList.add(new UPCEReader());
      }
      this.readers = ((UPCEANReader[])localArrayList.toArray(EMPTY_READER_ARRAY));
      return;
      paramMap = (Collection)paramMap.get(DecodeHintType.POSSIBLE_FORMATS);
      break;
      label184:
      if (paramMap.contains(BarcodeFormat.UPC_A)) {
        localArrayList.add(new UPCAReader());
      }
    }
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    int[] arrayOfInt = UPCEANReader.findStartGuardPattern(paramBitArray);
    UPCEANReader[] arrayOfUPCEANReader = this.readers;
    int m = arrayOfUPCEANReader.length;
    int i = 0;
    Object localObject1;
    int j;
    label77:
    label98:
    int k;
    if (i < m)
    {
      localObject1 = arrayOfUPCEANReader[i];
      try
      {
        localResult = ((UPCEANReader)localObject1).decodeRow(paramInt, paramBitArray, arrayOfInt, paramMap);
        if ((localResult.getBarcodeFormat() != BarcodeFormat.EAN_13) || (localResult.getText().charAt(0) != '0')) {
          break label209;
        }
        j = 1;
      }
      catch (ReaderException localReaderException)
      {
        Result localResult;
        i += 1;
      }
      if (localObject1 == null) {
        break label203;
      }
      if (((Collection)localObject1).contains(BarcodeFormat.UPC_A))
      {
        break label203;
        if ((j == 0) || (k == 0)) {
          break label175;
        }
        localObject1 = new Result(localResult.getText().substring(1), localResult.getRawBytes(), localResult.getResultPoints(), BarcodeFormat.UPC_A);
        ((Result)localObject1).putAllMetadata(localResult.getResultMetadata());
        return localObject1;
      }
    }
    label175:
    label203:
    label209:
    label213:
    for (;;)
    {
      localObject1 = (Collection)paramMap.get(DecodeHintType.POSSIBLE_FORMATS);
      break label77;
      k = 0;
      break label98;
      return localResult;
      break;
      throw NotFoundException.getNotFoundInstance();
      for (;;)
      {
        if (paramMap != null) {
          break label213;
        }
        Object localObject2 = null;
        break;
        k = 1;
        break label98;
        j = 0;
      }
    }
  }
  
  public void reset()
  {
    UPCEANReader[] arrayOfUPCEANReader = this.readers;
    int j = arrayOfUPCEANReader.length;
    int i = 0;
    while (i < j)
    {
      arrayOfUPCEANReader[i].reset();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.MultiFormatUPCEANReader
 * JD-Core Version:    0.7.0.1
 */