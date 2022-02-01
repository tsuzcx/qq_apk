package com.tencent.mobileqq.ocr;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload;
import com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudReqInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudReqTranslateInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

class TranslateController$ImageTranslateTask
  implements Runnable
{
  String a;
  String b;
  String c;
  boolean d;
  
  private String a()
  {
    return String.format("%s_%s_%05d", new Object[] { TranslateController.a(this.this$0).getCurrentAccountUin(), new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis())), Integer.valueOf(new Random().nextInt(100000)) });
  }
  
  public void run()
  {
    if (!FileUtil.d(this.a))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("picTranslate, file is not exists: ");
      ((StringBuilder)localObject1).append(this.a);
      QLog.d("TranslateController", 1, ((StringBuilder)localObject1).toString());
      localObject1 = new TranslateResult(2);
      ((TranslateResult)localObject1).h = 1001;
      TranslateController.a(this.this$0, false, this.a, (TranslateResult)localObject1);
      return;
    }
    Object localObject1 = this.a;
    if (this.d)
    {
      localObject2 = ((IOCR)QRoute.api(IOCR.class)).getCachePath(this.a);
      localObject1 = localObject2;
      if (!((IOCR)QRoute.api(IOCR.class)).compressImage(this.a, (String)localObject2))
      {
        localObject1 = this.a;
        QLog.d("TranslateController", 1, "compress image failed!");
      }
    }
    Object localObject2 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
    BitmapFactory.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
    int i = ((BitmapFactory.Options)localObject2).outHeight;
    int j = ((BitmapFactory.Options)localObject2).outWidth;
    Object localObject3 = new ARCloudReqFileInfo();
    ((ARCloudReqFileInfo)localObject3).e = this.a;
    ((ARCloudReqFileInfo)localObject3).a = ((String)localObject1);
    ((ARCloudReqFileInfo)localObject3).b = 0;
    ((ARCloudReqFileInfo)localObject3).c = i;
    ((ARCloudReqFileInfo)localObject3).d = j;
    Object localObject4 = new ARCloudReqTranslateInfo();
    ((ARCloudReqTranslateInfo)localObject4).b = this.b;
    ((ARCloudReqTranslateInfo)localObject4).c = this.c;
    ((ARCloudReqTranslateInfo)localObject4).a = a();
    localObject2 = new ARCloudReqInfo();
    ((ARCloudReqInfo)localObject2).a = a();
    ((ARCloudReqInfo)localObject2).b = ((ARCloudReqFileInfo)localObject3);
    ((ARCloudReqInfo)localObject2).n = ((ARCloudReqTranslateInfo)localObject4);
    ((ARCloudReqInfo)localObject2).d = 900000000;
    ((ARCloudReqInfo)localObject2).c = 900000000;
    ((ARCloudReqInfo)localObject2).e = 8192L;
    ((ARCloudReqInfo)localObject2).f = 0;
    ((ARCloudReqInfo)localObject2).o = String.valueOf(TranslateController.a(this.this$0).getAppid());
    ((ARCloudReqInfo)localObject2).p = Long.parseLong(TranslateController.a(this.this$0).getCurrentAccountUin());
    ((ARCloudReqInfo)localObject2).q = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject1 = new File((String)localObject1);
      localObject3 = ((ARCloudReqFileInfo)localObject3).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(((File)localObject1).length() / 1024L);
      ((StringBuilder)localObject4).append("KB");
      QLog.d("TranslateController", 2, String.format("picTranslate, fileInfo:%s, fileSize:%s", new Object[] { localObject3, ((StringBuilder)localObject4).toString() }));
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("picTranslate reqInfo:");
      ((StringBuilder)localObject1).append(localObject2);
      QLog.d("TranslateController", 2, ((StringBuilder)localObject1).toString());
    }
    if (TranslateController.b(this.this$0) == null)
    {
      localObject1 = this.this$0;
      TranslateController.a((TranslateController)localObject1, new ARCloudFileUpload(TranslateController.a((TranslateController)localObject1)));
    }
    TranslateController.b(this.this$0).a((ARCloudReqInfo)localObject2, new TranslateController.ImageTranslateTask.1(this, (ARCloudReqInfo)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateController.ImageTranslateTask
 * JD-Core Version:    0.7.0.1
 */