package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class OcrControl$1
  implements Runnable
{
  OcrControl$1(OcrControl paramOcrControl, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    if (((IOCR)QRoute.api(IOCR.class)).checkImageFormat(this.a))
    {
      Object localObject1 = ((IOCR)QRoute.api(IOCR.class)).getImagePath(new File(this.a).getName(), false);
      if ((this.b) && (((IOCR)QRoute.api(IOCR.class)).compressImage(this.a, (String)localObject1)))
      {
        localObject2 = new ARCloudReqFileInfo();
        ((ARCloudReqFileInfo)localObject2).a = ((String)localObject1);
        ((ARCloudReqFileInfo)localObject2).b = 0;
        ((ARCloudReqFileInfo)localObject2).e = this.a;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("upload pic size:");
          localStringBuilder.append(new File((String)localObject1).length() / 1024L);
          localStringBuilder.append("KB");
          QLog.d("Q.ocr.control", 2, localStringBuilder.toString());
        }
        this.this$0.a((ARCloudReqFileInfo)localObject2, this.c);
        return;
      }
      localObject1 = new ARCloudReqFileInfo();
      Object localObject2 = this.a;
      ((ARCloudReqFileInfo)localObject1).a = ((String)localObject2);
      ((ARCloudReqFileInfo)localObject1).b = 0;
      ((ARCloudReqFileInfo)localObject1).e = ((String)localObject2);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("upload pic size:");
        ((StringBuilder)localObject2).append(new File(this.a).length() / 1024L);
        ((StringBuilder)localObject2).append("KB");
        QLog.d("Q.ocr.control", 2, ((StringBuilder)localObject2).toString());
      }
      this.this$0.a((ARCloudReqFileInfo)localObject1, this.c);
      return;
    }
    if (OcrControl.a(this.this$0) != null) {
      OcrControl.a(this.this$0).a(1, null, this.a, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.1
 * JD-Core Version:    0.7.0.1
 */