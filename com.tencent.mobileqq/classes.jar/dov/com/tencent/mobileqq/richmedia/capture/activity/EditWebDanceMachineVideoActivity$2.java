package dov.com.tencent.mobileqq.richmedia.capture.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import bjdo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EditWebDanceMachineVideoActivity$2
  implements Runnable
{
  EditWebDanceMachineVideoActivity$2(EditWebDanceMachineVideoActivity paramEditWebDanceMachineVideoActivity, int paramInt) {}
  
  public void run()
  {
    String str = EditWebDanceMachineVideoActivity.a(this.this$0, EditWebDanceMachineVideoActivity.a(this.this$0), EditWebDanceMachineVideoActivity.a(this.this$0), this.this$0.getAppInterface().getCurrentNickname(), this.a);
    int i;
    if (this.a == 0)
    {
      i = EditWebDanceMachineVideoActivity.a(this.this$0, str, EditWebDanceMachineVideoActivity.b(this.this$0), EditWebDanceMachineVideoActivity.c(this.this$0));
      if (QLog.isColorLevel()) {
        QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "[DanceMachine Share]  shareToSinaResult : " + i);
      }
      if (i != 0) {
        this.this$0.runOnUiThread(new EditWebDanceMachineVideoActivity.2.1(this, i));
      }
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          BitmapFactory.decodeFile(EditWebDanceMachineVideoActivity.c(this.this$0), (BitmapFactory.Options)localObject);
          if (((BitmapFactory.Options)localObject).outHeight != 0) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "decode bitmap failed, outHeight == 0");
        return;
        i = ((BitmapFactory.Options)localObject).outHeight / 120;
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        ((BitmapFactory.Options)localObject).inSampleSize = i;
        localObject = BitmapFactory.decodeFile(EditWebDanceMachineVideoActivity.c(this.this$0), (BitmapFactory.Options)localObject);
        if (localObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "decode bitmap failed : iconBitmap is null");
      return;
      int j = ((Bitmap)localObject).getRowBytes();
      int k = ((Bitmap)localObject).getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "share to wechat bitmap ratio  : " + i + "   size : " + j * k / 1024 + "KB  fileSize : " + new File(EditWebDanceMachineVideoActivity.c(this.this$0)).length());
      }
      if (EditWebDanceMachineVideoActivity.a(this.this$0) == null) {
        EditWebDanceMachineVideoActivity.a(this.this$0, new bjdo(this, (Bitmap)localObject));
      }
      if (this.a == 1)
      {
        WXShareHelper.a().d(String.valueOf(System.currentTimeMillis()), str, (Bitmap)localObject, EditWebDanceMachineVideoActivity.d(this.this$0), EditWebDanceMachineVideoActivity.b(this.this$0));
        WXShareHelper.a().a(EditWebDanceMachineVideoActivity.a(this.this$0));
        EditWebDanceMachineVideoActivity.b(this.this$0, 1);
        return;
      }
    } while (this.a != 2);
    WXShareHelper.a().c(String.valueOf(System.currentTimeMillis()), str, (Bitmap)localObject, EditWebDanceMachineVideoActivity.d(this.this$0), EditWebDanceMachineVideoActivity.b(this.this$0));
    WXShareHelper.a().a(EditWebDanceMachineVideoActivity.a(this.this$0));
    EditWebDanceMachineVideoActivity.b(this.this$0, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.activity.EditWebDanceMachineVideoActivity.2
 * JD-Core Version:    0.7.0.1
 */