import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.biz.qqstory.takevideo.dancemachine.VideoSharer;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class oia
  implements Runnable
{
  public oia(VideoSharer paramVideoSharer, int paramInt) {}
  
  public void run()
  {
    int i;
    if (this.jdField_a_of_type_Int == 0)
    {
      i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineVideoSharer.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineVideoSharer.j, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineVideoSharer.i, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineVideoSharer.h);
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachinePKVideoSharer", 2, "[DanceMachine Share]  shareToSinaResult : " + i);
      }
      if (i != 0) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineVideoSharer.a.runOnUiThread(new oib(this, i));
      }
    }
    Bitmap localBitmap;
    do
    {
      for (;;)
      {
        return;
        Object localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineVideoSharer.h, (BitmapFactory.Options)localObject);
        if (((BitmapFactory.Options)localObject).outHeight == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DanceMachinePKVideoSharer", 2, "decode bitmap failed, outHeight == 0");
          }
        }
        else
        {
          i = ((BitmapFactory.Options)localObject).outHeight / 120;
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
          ((BitmapFactory.Options)localObject).inSampleSize = i;
          try
          {
            localObject = BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineVideoSharer.h, (BitmapFactory.Options)localObject);
            if (localObject == null)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("DanceMachinePKVideoSharer", 2, "decode bitmap failed : iconBitmap is null");
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            for (;;)
            {
              localBitmap = null;
            }
            int j = localBitmap.getRowBytes();
            int k = localBitmap.getHeight();
            if (QLog.isColorLevel()) {
              QLog.d("DanceMachinePKVideoSharer", 2, "share to wechat bitmap ratio  : " + i + "   size : " + j * k / 1024 + "KB  fileSize : " + new File(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineVideoSharer.h).length());
            }
            if (VideoSharer.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineVideoSharer) == null) {
              VideoSharer.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineVideoSharer, new oic(this, localBitmap));
            }
            if (this.jdField_a_of_type_Int == 1)
            {
              WXShareHelper.a().d(String.valueOf(System.currentTimeMillis()), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineVideoSharer.j, localBitmap, "今天，我们都是灵魂舞者！", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineVideoSharer.i);
              WXShareHelper.a().a(VideoSharer.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineVideoSharer));
              VideoSharer.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineVideoSharer, 1);
              return;
            }
          }
        }
      }
    } while (this.jdField_a_of_type_Int != 2);
    WXShareHelper.a().c(String.valueOf(System.currentTimeMillis()), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineVideoSharer.j, localBitmap, "今天，我们都是灵魂舞者！", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineVideoSharer.i);
    WXShareHelper.a().a(VideoSharer.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineVideoSharer));
    VideoSharer.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineVideoSharer, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oia
 * JD-Core Version:    0.7.0.1
 */