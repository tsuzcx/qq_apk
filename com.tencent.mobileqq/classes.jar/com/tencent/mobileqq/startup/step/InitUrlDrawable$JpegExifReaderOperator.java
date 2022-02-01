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
    try
    {
      Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_gifplay.name(), null);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isAllowDPC(): parseConfig, aio_gifplay =");
        localStringBuilder.append((String)localObject);
        QLog.d("JpegExifReader", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 9)
        {
          int i = Integer.parseInt(localObject[8]);
          return i == 1;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("JpegExifReader", 2, "read dpc", localException);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitUrlDrawable.JpegExifReaderOperator
 * JD-Core Version:    0.7.0.1
 */