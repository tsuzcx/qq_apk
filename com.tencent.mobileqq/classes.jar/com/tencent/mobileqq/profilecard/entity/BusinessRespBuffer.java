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
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      Object localObject1 = null;
      int i = 0;
      while (i < paramArrayList.size())
      {
        Object localObject4 = (byte[])paramArrayList.get(i);
        int j;
        if (localObject4 == null) {
          j = 0;
        } else {
          j = localObject4.length;
        }
        Object localObject2;
        Object localObject3;
        if (j <= 10)
        {
          localObject2 = localObject1;
        }
        else
        {
          int k = (int)PkgTools.getLongData((byte[])localObject4, 1);
          int m = (int)PkgTools.getLongData((byte[])localObject4, 5);
          localObject2 = localObject1;
          if (k > 0)
          {
            int n = 9 + k;
            if (n >= j)
            {
              localObject2 = localObject1;
            }
            else
            {
              localObject2 = new byte[k];
              PkgTools.copyData((byte[])localObject2, 0, (byte[])localObject4, 9, k);
              if (m > 0)
              {
                localObject1 = new byte[m];
                PkgTools.copyData((byte[])localObject1, 0, (byte[])localObject4, n, m);
              }
              try
              {
                localObject4 = new SummaryCardBusiEntry.comm();
                ((SummaryCardBusiEntry.comm)localObject4).mergeFrom((byte[])localObject2);
                localObject2 = localObject1;
                if (((SummaryCardBusiEntry.comm)localObject4).result.get() == 0)
                {
                  localSparseArray.put(((SummaryCardBusiEntry.comm)localObject4).service.get(), new BusinessRespBuffer((SummaryCardBusiEntry.comm)localObject4, (byte[])localObject1));
                  localObject2 = localObject1;
                }
              }
              catch (Exception localException)
              {
                QLog.e("BusinessRespBuffer", 1, "", localException);
                localObject3 = localObject1;
              }
            }
          }
        }
        i += 1;
        localObject1 = localObject3;
      }
    }
    return localSparseArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.entity.BusinessRespBuffer
 * JD-Core Version:    0.7.0.1
 */