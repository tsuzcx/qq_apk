package cooperation.troop_homework;

import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter.Processor;
import com.tencent.richmedia.videocompress.VideoConverterConfig;

public class TroopHomeworkHelper$HWCompressProcessor
  implements VideoConverter.Processor
{
  final int jdField_a_of_type_Int;
  final String jdField_a_of_type_JavaLangString;
  final int b;
  
  TroopHomeworkHelper$HWCompressProcessor(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    if (paramInt2 > 0) {}
    for (this.b = paramInt2; paramString == null; this.b = 30) {
      throw new IllegalArgumentException("null == outputFilePath");
    }
  }
  
  public VideoConverterConfig getEncodeConfig(int paramInt1, int paramInt2)
  {
    int i = 0;
    VideoConverterConfig localVideoConverterConfig = new VideoConverterConfig();
    int k;
    Object localObject;
    if (paramInt1 <= paramInt2)
    {
      k = paramInt2;
      localVideoConverterConfig.output = this.jdField_a_of_type_JavaLangString;
      localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.lvcc.name(), "640|640|384|768|30");
      if ((localObject == null) || (((String)localObject).length() <= 0)) {
        break label404;
      }
      localObject = ((String)localObject).split("\\|");
      if ((localObject == null) || (localObject.length <= 4)) {
        break label404;
      }
    }
    label404:
    for (;;)
    {
      try
      {
        i = Integer.valueOf(localObject[1]).intValue();
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        paramInt1 = 0;
        paramInt2 = 0;
        i = 0;
      }
      try
      {
        paramInt2 = Integer.valueOf(localObject[2]).intValue();
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        for (;;)
        {
          label317:
          int n;
          paramInt1 = 0;
          paramInt2 = 0;
        }
      }
      try
      {
        paramInt1 = Integer.valueOf(localObject[3]).intValue();
      }
      catch (NumberFormatException localNumberFormatException3)
      {
        paramInt1 = 0;
        break label317;
      }
      try
      {
        m = Integer.valueOf(localObject[4]).intValue();
        j = i;
        i = paramInt2;
        paramInt2 = m;
        m = j;
        if (j <= 0) {
          m = 640;
        }
        j = i;
        if (i <= 0) {
          j = 384;
        }
        i = paramInt1;
        if (paramInt1 <= 0) {
          i = 768;
        }
        paramInt1 = paramInt2;
        if (paramInt2 <= 0) {
          paramInt1 = 30;
        }
        localVideoConverterConfig.scaleRate = (m / k);
        localVideoConverterConfig.videoBitRate = ((int)(this.jdField_a_of_type_Int * localVideoConverterConfig.scaleRate * localVideoConverterConfig.scaleRate + 0.5F));
        if (localVideoConverterConfig.videoBitRate <= i * 1024) {
          break label355;
        }
        localVideoConverterConfig.videoBitRate = (i * 1024);
        paramInt2 = paramInt1;
        if (this.b <= paramInt1) {
          paramInt2 = this.b;
        }
        localVideoConverterConfig.videoFrameRate = paramInt2;
        if (QLog.isColorLevel()) {
          QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: getEncodeConfig() config.setRotation = " + localVideoConverterConfig.setRotation);
        }
        return localVideoConverterConfig;
      }
      catch (NumberFormatException localNumberFormatException4)
      {
        break label317;
      }
      k = paramInt1;
      break;
      if (QLog.isColorLevel()) {
        QLog.e("TroopHomeworkHelper", 2, "getEncodeConfig -> get DpcConfig Erro", localNumberFormatException1);
      }
      n = 0;
      int j = paramInt2;
      int m = i;
      paramInt2 = n;
      i = j;
      j = m;
      continue;
      label355:
      if (localVideoConverterConfig.videoBitRate < j * 1024)
      {
        localVideoConverterConfig.videoBitRate = (j * 1024);
        continue;
        paramInt2 = 0;
        paramInt1 = 0;
        j = 0;
      }
    }
  }
  
  public void onCancel() {}
  
  public void onFail(Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TroopHomeworkHelper", 2, "CompressTask, step: HWCompressProcessor onFailed");
    }
  }
  
  public void onProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: HWCompressProcessor onProgress:" + paramInt);
    }
  }
  
  public void onSuccess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: HWCompressProcessor onSuccessed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.troop_homework.TroopHomeworkHelper.HWCompressProcessor
 * JD-Core Version:    0.7.0.1
 */