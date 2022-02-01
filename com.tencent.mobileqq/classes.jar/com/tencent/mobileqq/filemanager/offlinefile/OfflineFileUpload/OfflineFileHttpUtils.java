package com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload;

import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import com.tencent.wstt.SSCM.Utils;

public class OfflineFileHttpUtils
{
  public static int a(SSCM paramSSCM, long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong3 == 0L)
    {
      if (paramLong1 < paramSSCM.a(BaseApplication.getContext(), paramLong1, paramLong3, 1024)) {
        paramLong3 = paramLong1;
      } else {
        paramLong3 = 1024L;
      }
    }
    else
    {
      long l = paramSSCM.a(BaseApplication.getContext(), paramLong1, paramLong2, 131072);
      paramLong3 = l;
      if (paramLong1 < paramLong2 + l) {
        paramLong3 = paramLong1 - paramLong2;
      }
    }
    int j = (int)paramLong3;
    int k = Utils.a(BaseApplication.getContext());
    if (k != 1)
    {
      i = j;
      if (k != 2) {}
    }
    else
    {
      i = j;
      if (j > 16384) {
        i = 16384;
      }
    }
    int i = Math.min(i, 1048576);
    if (QLog.isColorLevel())
    {
      paramSSCM = new StringBuilder();
      paramSSCM.append("sendFilePakage transferedSize[");
      paramSSCM.append(paramLong2);
      paramSSCM.append("], size[");
      paramSSCM.append(i);
      paramSSCM.append("]");
      QLog.d("OfflineFileHttpUtils<FileAssistant>", 2, paramSSCM.toString());
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileHttpUtils
 * JD-Core Version:    0.7.0.1
 */