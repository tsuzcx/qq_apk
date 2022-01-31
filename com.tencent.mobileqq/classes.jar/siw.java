import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class siw
  implements ThreadExcutor.IThreadListener
{
  siw(sis paramsis, skl paramskl) {}
  
  public void onAdded() {}
  
  public void onPostRun() {}
  
  public void onPreRun()
  {
    boolean bool1;
    int i;
    int j;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Skl.b))
    {
      bool1 = this.jdField_a_of_type_Skl.a().getBooleanExtra("landscape_video", false);
      boolean bool2 = this.jdField_a_of_type_Skl.a().isLocalPublish;
      boolean bool3 = this.jdField_a_of_type_Skl.a().getBooleanExtra("is_hw_encode", false);
      if (this.jdField_a_of_type_Skl.a().businessId != 1) {
        break label240;
      }
      i = 1;
      j = this.jdField_a_of_type_Skl.a().getIntExtra("thumb_rotation", 0);
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
        BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(this.jdField_a_of_type_Skl.b));
        if (localBufferedInputStream != null)
        {
          Bitmap localBitmap1 = BitmapFactory.decodeStream(localBufferedInputStream);
          Bitmap localBitmap2 = vlc.a(localBitmap1, j);
          bool1 = vlc.a(localBitmap2, this.jdField_a_of_type_Skl.b);
          if (localBitmap2 != null) {
            localBitmap2.recycle();
          }
          localBitmap1.recycle();
          localBufferedInputStream.close();
          if (bool1) {
            continue;
          }
          urk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "compress file fail, %s", new Object[] { this.jdField_a_of_type_Skl.b });
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        urk.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "FileNotFoundException =", localFileNotFoundException);
        continue;
      }
      catch (IOException localIOException)
      {
        urk.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "IOException =", localIOException);
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        label240:
        label245:
        urk.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "OutOfMemoryError = ", localOutOfMemoryError);
        continue;
      }
      sis.a(this.jdField_a_of_type_Sis);
      urk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "create story %s", new Object[] { this.jdField_a_of_type_Skl });
      return;
      i = 0;
      break;
      j = 360 - j;
      break label91;
      urk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "video local file exist %b, %s", new Object[] { Boolean.valueOf(vlm.b(this.jdField_a_of_type_Skl.b)), this.jdField_a_of_type_Skl.b });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     siw
 * JD-Core Version:    0.7.0.1
 */