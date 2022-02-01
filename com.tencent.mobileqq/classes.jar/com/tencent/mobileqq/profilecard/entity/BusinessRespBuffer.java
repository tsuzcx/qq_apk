package com.tencent.mobileqq.profilecard.entity;

import android.util.SparseArray;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.comm;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class BusinessRespBuffer
{
  private static final String TAG = "BusinessRespBuffer";
  public byte[] buffer;
  public SummaryCardBusiEntry.comm comm;
  
  public BusinessRespBuffer(SummaryCardBusiEntry.comm paramcomm, byte[] paramArrayOfByte)
  {
    this.comm = paramcomm;
    this.buffer = paramArrayOfByte;
  }
  
  public static SparseArray<BusinessRespBuffer> parseBusinessRespBuffer(ArrayList<byte[]> paramArrayList)
  {
    SparseArray localSparseArray = new SparseArray();
    Object localObject1;
    int i;
    Object localObject3;
    int j;
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      localObject1 = null;
      i = 0;
      if (i < paramArrayList.size())
      {
        localObject3 = (byte[])paramArrayList.get(i);
        if (localObject3 == null)
        {
          j = 0;
          label50:
          if (j > 10) {
            break label70;
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      j = localObject3.length;
      break label50;
      label70:
      int k = (int)PkgTools.getLongData((byte[])localObject3, 1);
      int m = (int)PkgTools.getLongData((byte[])localObject3, 5);
      if (k > 0) {
        if (k + 9 < j)
        {
          byte[] arrayOfByte = new byte[k];
          PkgTools.copyData(arrayOfByte, 0, (byte[])localObject3, 9, k);
          if (m > 0)
          {
            localObject1 = new byte[m];
            PkgTools.copyData((byte[])localObject1, 0, (byte[])localObject3, k + 9, m);
          }
          localObject3 = localObject1;
          try
          {
            SummaryCardBusiEntry.comm localcomm = new SummaryCardBusiEntry.comm();
            localcomm.mergeFrom(arrayOfByte);
            localObject1 = localObject3;
            if (localcomm.result.get() != 0) {
              continue;
            }
            localSparseArray.put(localcomm.service.get(), new BusinessRespBuffer(localcomm, (byte[])localObject3));
            localObject1 = localObject3;
          }
          catch (Exception localException)
          {
            QLog.e("BusinessRespBuffer", 1, "", localException);
            Object localObject2 = localObject3;
          }
          continue;
          return localSparseArray;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.entity.BusinessRespBuffer
 * JD-Core Version:    0.7.0.1
 */