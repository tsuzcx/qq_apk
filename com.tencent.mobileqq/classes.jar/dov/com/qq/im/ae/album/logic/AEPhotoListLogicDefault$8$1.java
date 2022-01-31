package dov.com.qq.im.ae.album.logic;

import android.os.Handler;
import android.os.Message;
import bdhb;
import bkqs;
import bkrk;
import bkrp;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Map;
import mqq.util.WeakReference;

public class AEPhotoListLogicDefault$8$1
  implements Runnable
{
  public AEPhotoListLogicDefault$8$1(bkrp parambkrp) {}
  
  public void run()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = this.a.jdField_a_of_type_JavaLangString;
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    try
    {
      localLocalMediaInfo.path = this.a.jdField_a_of_type_JavaLangString;
      localLocalMediaInfo.mMimeType = "video/mp4";
      localLocalMediaInfo.addedDate = System.currentTimeMillis();
      localLocalMediaInfo.modifiedDate = System.currentTimeMillis();
      localLocalMediaInfo.thumbnailPath = this.a.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
      localLocalMediaInfo.mDuration = this.a.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDuration;
      localLocalMediaInfo.fileSize = new File(this.a.jdField_a_of_type_JavaLangString).length();
      localLocalMediaInfo.isSystemMeidaStore = false;
      PhotoListBaseData.newCaptureMediaInfo.put(this.a.jdField_a_of_type_JavaLangString, localLocalMediaInfo);
      ((bkqs)this.a.jdField_a_of_type_Bkrk.a.get()).a.sendMessage(localMessage);
      bdhb.a(this.a.b);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QZLog.e("PhotoListActivity", 2, new Object[] { "get new video info exception", localException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicDefault.8.1
 * JD-Core Version:    0.7.0.1
 */