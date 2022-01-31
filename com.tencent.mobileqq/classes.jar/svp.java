import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class svp
  implements ThreadExcutor.IThreadListener
{
  svp(svl paramsvl, sxe paramsxe) {}
  
  public void onAdded() {}
  
  public void onPostRun() {}
  
  public void onPreRun()
  {
    boolean bool1;
    int i;
    int j;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Sxe.b))
    {
      bool1 = this.jdField_a_of_type_Sxe.a().getBooleanExtra("landscape_video", false);
      boolean bool2 = this.jdField_a_of_type_Sxe.a().isLocalPublish;
      boolean bool3 = this.jdField_a_of_type_Sxe.a().getBooleanExtra("is_hw_encode", false);
      if (this.jdField_a_of_type_Sxe.a().businessId != 1) {
        break label240;
      }
      i = 1;
      j = this.jdField_a_of_type_Sxe.a().getIntExtra("thumb_rotation", 0);
      if (!bool2) {
        break label245;
      }
      j = 0;
      label91:
      if ((i == 0) || (!bool3) || ((bool2) && (!bool1)) || (j == 0)) {}
    }
    for (;;)
    {
      try
      {
        BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(this.jdField_a_of_type_Sxe.b));
        if (localBufferedInputStream != null)
        {
          Bitmap localBitmap1 = BitmapFactory.decodeStream(localBufferedInputStream);
          Bitmap localBitmap2 = vxv.a(localBitmap1, j);
          bool1 = vxv.a(localBitmap2, this.jdField_a_of_type_Sxe.b);
          if (localBitmap2 != null) {
            localBitmap2.recycle();
          }
          localBitmap1.recycle();
          localBufferedInputStream.close();
          if (bool1) {
            continue;
          }
          ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "compress file fail, %s", new Object[] { this.jdField_a_of_type_Sxe.b });
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        ved.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "FileNotFoundException =", localFileNotFoundException);
        continue;
      }
      catch (IOException localIOException)
      {
        ved.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "IOException =", localIOException);
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        label240:
        label245:
        ved.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "OutOfMemoryError = ", localOutOfMemoryError);
        continue;
      }
      svl.a(this.jdField_a_of_type_Svl);
      ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "create story %s", new Object[] { this.jdField_a_of_type_Sxe });
      return;
      i = 0;
      break;
      j = 360 - j;
      break label91;
      ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "video local file exist %b, %s", new Object[] { Boolean.valueOf(vyf.b(this.jdField_a_of_type_Sxe.b)), this.jdField_a_of_type_Sxe.b });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svp
 * JD-Core Version:    0.7.0.1
 */