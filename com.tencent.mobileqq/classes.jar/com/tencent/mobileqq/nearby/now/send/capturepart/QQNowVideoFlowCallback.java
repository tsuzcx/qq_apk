package com.tencent.mobileqq.nearby.now.send.capturepart;

import aeva;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;

public class QQNowVideoFlowCallback
{
  public static float a;
  public static int a;
  public static float b;
  public static int b;
  public static int c = 180000;
  public static int d = 10002200;
  public static int e = 10485760;
  public static int f = 240;
  
  static
  {
    jdField_a_of_type_Int = 419430400;
    jdField_b_of_type_Int = 240;
  }
  
  public static void a(Activity paramActivity, @NonNull EditVideoParams.EditSource paramEditSource)
  {
    if (paramActivity != null)
    {
      Object localObject = new Bundle();
      int i = 365;
      if ((paramEditSource instanceof EditLocalPhotoSource)) {
        i = 320;
      }
      paramEditSource = new EditVideoParams(9, i, paramEditSource, (Bundle)localObject);
      SLog.d("QQNowVideoFlowCallback", "launchEditActivity, %s", new Object[] { paramEditSource });
      localObject = new Intent(paramActivity, EditVideoActivity.class);
      ((Intent)localObject).putExtra(EditVideoParams.class.getName(), paramEditSource);
      ((Intent)localObject).putExtra("op_department", "grp_now");
      ((Intent)localObject).putExtra("op_type", "now_smallvideo_edit");
      paramActivity.startActivityForResult((Intent)localObject, 10002);
    }
  }
  
  public static void a(Activity paramActivity, String paramString, LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramLocalMediaInfo.mMimeType.contains("video")) {}
    for (paramString = new EditLocalVideoSource(paramString, paramLocalMediaInfo, paramInt1, paramInt2);; paramString = new EditLocalPhotoSource(paramString, paramLocalMediaInfo))
    {
      a(paramActivity, paramString);
      return;
    }
  }
  
  public static boolean a(@NonNull Activity paramActivity, @NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    jdField_a_of_type_Float = d / 10000 / 1000.0F;
    jdField_b_of_type_Float = d % 10000 / 1000.0F;
    float f2 = paramLocalMediaInfo.mediaHeight * 1.0F / paramLocalMediaInfo.mediaWidth;
    QQToast localQQToast;
    int i;
    if (paramLocalMediaInfo.mMimeType.contains("video")) {
      if (paramLocalMediaInfo.fileSize > jdField_a_of_type_Int)
      {
        localQQToast = QQToast.a(paramActivity, 1, "你选择的视频过大", 0);
        SLog.c("QQNowVideoFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
        i = 1;
      }
    }
    for (;;)
    {
      if (paramLocalMediaInfo.addedDate == 0L) {
        paramLocalMediaInfo.addedDate = (new File(paramLocalMediaInfo.path).lastModified() / 1000L);
      }
      if (localQQToast != null) {
        paramActivity.runOnUiThread(new aeva(localQQToast));
      }
      if (i == 0)
      {
        return true;
        if (Math.min(paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mediaWidth) < jdField_b_of_type_Int)
        {
          localQQToast = QQToast.a(paramActivity, 1, "你选择的视频分辨率过低", 0);
          SLog.c("QQNowVideoFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          i = 2;
          continue;
        }
        float f1 = f2;
        if (f2 < 1.0F) {
          f1 = 1.0F / f2;
        }
        if ((f1 < jdField_a_of_type_Float) || (f1 > jdField_b_of_type_Float))
        {
          localQQToast = QQToast.a(paramActivity, 1, "你选择的视频比例不符合要求", 0);
          SLog.c("QQNowVideoFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          i = 3;
          continue;
        }
        if (paramLocalMediaInfo.mDuration > c)
        {
          localQQToast = QQToast.a(paramActivity, 1, "请上传不超过3分钟的视频", 0);
          SLog.c("QQNowVideoFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          i = 4;
          continue;
          if (paramLocalMediaInfo.fileSize > e)
          {
            localQQToast = QQToast.a(paramActivity, 1, "你选择的图片过大", 0);
            SLog.c("QQNowVideoFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
            i = 1;
            continue;
          }
          if (Math.min(paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mediaWidth) < f)
          {
            localQQToast = QQToast.a(paramActivity, 1, "你选择的图片分辨率过低", 0);
            SLog.c("QQNowVideoFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
            i = 2;
            continue;
          }
          if ((f2 < 0.45D) || (f2 > 2.2D))
          {
            localQQToast = QQToast.a(paramActivity, 1, "你选择的图片比例不符合要求", 0);
            SLog.c("QQNowVideoFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
            i = 3;
          }
        }
      }
      else
      {
        return false;
      }
      localQQToast = null;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.send.capturepart.QQNowVideoFlowCallback
 * JD-Core Version:    0.7.0.1
 */