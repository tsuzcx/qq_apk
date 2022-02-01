package com.tencent.mobileqq.startup.step;

import android.text.TextUtils;
import com.tencent.image.JpegExifReader.JpegExifReaderInterface;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class InitUrlDrawable$JpegExifReaderOperator
  implements JpegExifReader.JpegExifReaderInterface
{
  public void doReport(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3) {}
  
  public boolean readEnableFromDPC()
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_gifplay.name(), null);
        if (QLog.isColorLevel()) {
          QLog.d("JpegExifReader", 2, "isAllowDPC(): parseConfig, aio_gifplay =" + (String)localObject);
        }
        bool1 = bool2;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("\\|");
          bool1 = bool2;
          if (localObject.length >= 9)
          {
            int i = Integer.parseInt(localObject[8]);
            if (i != 1) {
              continue;
            }
            bool1 = true;
          }
        }
      }
      catch (Exception localException)
      {
        boolean bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("JpegExifReader", 2, "read dpc", localException);
      }
      return bool1;
      bool1 = false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitUrlDrawable.JpegExifReaderOperator
 * JD-Core Version:    0.7.0.1
 */