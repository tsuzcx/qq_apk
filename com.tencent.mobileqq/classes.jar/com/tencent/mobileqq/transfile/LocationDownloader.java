package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import mqq.app.AccountNotMatchException;

public class LocationDownloader
  extends HttpDownloader
{
  private float jdField_a_of_type_Float = 2.0F;
  BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  
  public LocationDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
    try
    {
      this.jdField_a_of_type_Float = paramBaseApplicationImpl.getResources().getDisplayMetrics().density;
      return;
    }
    catch (Exception paramBaseApplicationImpl) {}
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    Object localObject1 = paramDownloadParams.url;
    String str = "http://" + ((URL)localObject1).getAuthority() + "/" + ((URL)localObject1).getFile();
    try
    {
      localObject1 = (MessageForText)paramDownloadParams.tag;
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime(((MessageForText)localObject1).selfuin);
          if ((localObject1 != null) && (localQQAppInterface != null)) {
            break;
          }
          throw new FileDownloadFailedException(9366, 0L, "textMsg=" + localObject1 + " app=" + localQQAppInterface, false, false);
          localException = localException;
          localException.printStackTrace();
          localObject2 = null;
        }
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        Object localObject2;
        for (;;)
        {
          localTransFileController = null;
        }
        TransFileController localTransFileController = localTransFileController.a();
        TransferRequest localTransferRequest = new TransferRequest();
        localTransferRequest.jdField_b_of_type_Int = 131076;
        localTransferRequest.jdField_a_of_type_Long = localObject2.uniseq;
        localTransferRequest.jdField_b_of_type_JavaLangString = localObject2.selfuin;
        localTransferRequest.c = localObject2.frienduin;
        localTransferRequest.e = str;
        localTransferRequest.jdField_a_of_type_JavaIoOutputStream = paramOutputStream;
        paramOutputStream = new TransferRequest.PicDownExtraInfo();
        paramOutputStream.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
        paramOutputStream.jdField_a_of_type_Int = ((int)paramDownloadParams.downloaded);
        localTransferRequest.jdField_a_of_type_JavaLangObject = paramOutputStream;
        paramOutputStream = localTransFileController.a(localTransferRequest);
        if (paramOutputStream.jdField_a_of_type_Int == 0) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            if (paramOutputStream.jdField_a_of_type_Long != 9037L) {
              break;
            }
            paramURLDrawableHandler.doCancel();
          }
          return null;
        }
        throw new FileDownloadFailedException((int)paramOutputStream.jdField_a_of_type_Long, 0L, paramOutputStream.jdField_a_of_type_JavaLangString, false, false);
      }
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams = null;
    paramURLDrawableHandler = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), null);
    if (paramURLDrawableHandler == null) {
      paramFile = paramDownloadParams;
    }
    do
    {
      do
      {
        return paramFile;
        int i = paramURLDrawableHandler.getWidth();
        int j = paramURLDrawableHandler.getHeight();
        paramDownloadParams = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        paramDownloadParams.setDensity(160);
        paramFile = new Canvas(paramDownloadParams);
        Paint localPaint = new Paint(1);
        localPaint.setColor(-16777216);
        Rect localRect = new Rect(0, 0, i, j);
        RectF localRectF = new RectF(localRect);
        float f = 11.0F * this.jdField_a_of_type_Float;
        paramFile.drawRoundRect(localRectF, f, f, localPaint);
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paramFile.drawBitmap(paramURLDrawableHandler, localRect, localRect, localPaint);
        paramFile = paramDownloadParams;
      } while (paramURLDrawableHandler == null);
      paramFile = paramDownloadParams;
    } while (paramURLDrawableHandler.isRecycled());
    paramURLDrawableHandler.recycle();
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.LocationDownloader
 * JD-Core Version:    0.7.0.1
 */