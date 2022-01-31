import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.biz.qqstory.base.download.DownloadProgressListener;
import com.tencent.biz.qqstory.base.download.Downloader;
import com.tencent.biz.qqstory.base.download.DownloaderImp;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiDownloadEvent;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.io.File;

public class ohl
  extends SimpleJob
  implements DownloadProgressListener
{
  protected long a;
  private final Downloader jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader;
  private final DoodleEmojiItem jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem;
  private long b;
  
  public ohl(DoodleEmojiItem paramDoodleEmojiItem)
  {
    if (paramDoodleEmojiItem == null) {
      throw new IllegalArgumentException("doodleEmojiItem should not be null");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader = new DownloaderImp();
    this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem = paramDoodleEmojiItem;
  }
  
  protected DoodleEmojiItem a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.e, DoodleEmojiManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.a), 0L);
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem;
  }
  
  public void a(String paramString, int paramInt)
  {
    DoodleEmojiItem localDoodleEmojiItem1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem;
    if (paramInt == 0)
    {
      paramString = DoodleEmojiManager.a(localDoodleEmojiItem1.a);
      String str = DoodleEmojiManager.b(localDoodleEmojiItem1.a);
      SLog.b("DoodleEmojiManager", "DownloadListener onDownloadFinish zip = " + paramString);
      SLog.b("DoodleEmojiManager", "DownloadListener onDownloadFinish folder = " + str);
      for (;;)
      {
        int i;
        try
        {
          FileUtils.d(str);
          i = ZipUtils.a(paramString, str);
          if (i == 0)
          {
            long l1 = SystemClock.uptimeMillis();
            long l2 = this.jdField_a_of_type_Long;
            StoryReportor.b("edit_video", "face_download_timecost", 0, 0, new String[] { localDoodleEmojiItem1.a, l1 - l2 + "" });
            StoryReportor.b("edit_video", "face_download_success", 0, 0, new String[] { localDoodleEmojiItem1.a });
            SLog.c("DoodleEmojiManager", "DownloadListener onDownloadFinish success, unZip success");
            localDoodleEmojiItem1.a(str);
            new File(str).setLastModified(System.currentTimeMillis());
            Dispatchers.get().dispatch(new DoodleEmojiManager.DoodleEmojiDownloadEvent(localDoodleEmojiItem1, paramInt, true, 0L, 0L));
            return;
          }
        }
        catch (Exception localException)
        {
          SLog.d("DoodleEmojiManager", "DownloadListener remove folderPath : %s ,error : %s ", new Object[] { str, localException });
          continue;
        }
        finally
        {
          new File(paramString).delete();
        }
        SLog.d("DoodleEmojiManager", "DownloadListener onDownloadFinish unZip failed, treat it as download failed");
        Dispatchers.get().dispatch(new DoodleEmojiManager.DoodleEmojiDownloadEvent(localDoodleEmojiItem2, i, false, 0L, 0L));
        StoryReportor.b("edit_video", "face_download_success", 0, i, new String[] { localDoodleEmojiItem2.a });
      }
    }
    SLog.e("DoodleEmojiManager", "DownloadListener onDownloadFinish error = " + paramInt + ", url = " + paramString);
    Dispatchers.get().dispatch(new DoodleEmojiManager.DoodleEmojiDownloadEvent(localDoodleEmojiItem2, paramInt, true, 0L, 0L));
    StoryReportor.b("edit_video", "face_download_success", 0, paramInt, new String[] { localDoodleEmojiItem2.a });
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    DoodleEmojiItem localDoodleEmojiItem = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem;
    if (!TextUtils.equals(localDoodleEmojiItem.e, paramString))
    {
      SLog.d("DoodleEmojiManager", "DownloadListener onProgress error : " + localDoodleEmojiItem);
      SLog.d("DoodleEmojiManager", "DownloadListener onProgress error : call back url = " + paramString);
    }
    while (paramLong1 <= paramLong2 / 10L + this.b) {
      return;
    }
    SLog.a("DoodleEmojiManager", "DownloadListener onProgress " + paramLong1 + " / " + paramLong2);
    Dispatchers.get().dispatch(new DoodleEmojiManager.DoodleEmojiDownloadEvent(localDoodleEmojiItem, 0, false, paramLong2, paramLong1));
    this.b = paramLong1;
  }
  
  public void a(String paramString1, String paramString2)
  {
    SLog.b("DoodleEmojiManager", "onDownloadStart : url = " + paramString1 + ", path = " + paramString2);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ohl
 * JD-Core Version:    0.7.0.1
 */