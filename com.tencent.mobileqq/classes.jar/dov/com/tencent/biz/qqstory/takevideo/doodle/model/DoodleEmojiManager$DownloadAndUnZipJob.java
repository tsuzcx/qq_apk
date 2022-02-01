package dov.com.tencent.biz.qqstory.takevideo.doodle.model;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.base.download.DownloadProgressListener;
import com.tencent.biz.qqstory.base.download.Downloader;
import com.tencent.biz.qqstory.base.download.DownloaderImp;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;

class DoodleEmojiManager$DownloadAndUnZipJob
  extends SimpleJob<DoodleEmojiItem>
  implements DownloadProgressListener
{
  protected long a;
  private final Downloader jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader;
  private final DoodleEmojiItem jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem;
  private long b = 0L;
  
  public DoodleEmojiManager$DownloadAndUnZipJob(DoodleEmojiItem paramDoodleEmojiItem)
  {
    super("DownloadAndUnZipJob");
    if (paramDoodleEmojiItem == null) {
      throw new IllegalArgumentException("doodleEmojiItem should not be null");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader = new DownloaderImp();
    this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader.a(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem = paramDoodleEmojiItem;
  }
  
  protected DoodleEmojiItem a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.download_url, DoodleEmojiManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id), 0L);
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem;
  }
  
  public void a(String paramString, int paramInt)
  {
    DoodleEmojiItem localDoodleEmojiItem1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem;
    if (paramInt == 0)
    {
      paramString = DoodleEmojiManager.a(localDoodleEmojiItem1.pack_id);
      String str = DoodleEmojiManager.b(localDoodleEmojiItem1.pack_id);
      SLog.b("DoodleEmojiManager", "DownloadListener onDownloadFinish zip = " + paramString);
      SLog.b("DoodleEmojiManager", "DownloadListener onDownloadFinish folder = " + str);
      for (;;)
      {
        int i;
        try
        {
          FileUtils.d(str);
          i = ZipUtils.unZipFolder(paramString, str);
          if (i == 0)
          {
            long l1 = SystemClock.uptimeMillis();
            long l2 = this.jdField_a_of_type_Long;
            StoryReportor.b("edit_video", "face_download_timecost", 0, 0, new String[] { localDoodleEmojiItem1.pack_id, l1 - l2 + "" });
            StoryReportor.b("edit_video", "face_download_success", 0, 0, new String[] { localDoodleEmojiItem1.pack_id });
            SLog.c("DoodleEmojiManager", "DownloadListener onDownloadFinish success, unZip success");
            localDoodleEmojiItem1.setLocalEmojiFolderPath(str);
            new File(str).setLastModified(System.currentTimeMillis());
            StoryDispatcher.a().dispatch(new DoodleEmojiManager.DoodleEmojiDownloadEvent(localDoodleEmojiItem1, paramInt, true, 0L, 0L));
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
        StoryDispatcher.a().dispatch(new DoodleEmojiManager.DoodleEmojiDownloadEvent(localDoodleEmojiItem2, i, false, 0L, 0L));
        StoryReportor.b("edit_video", "face_download_success", 0, i, new String[] { localDoodleEmojiItem2.pack_id });
      }
    }
    SLog.e("DoodleEmojiManager", "DownloadListener onDownloadFinish error = " + paramInt + ", url = " + paramString);
    StoryDispatcher.a().dispatch(new DoodleEmojiManager.DoodleEmojiDownloadEvent(localDoodleEmojiItem2, paramInt, true, 0L, 0L));
    StoryReportor.b("edit_video", "face_download_success", 0, paramInt, new String[] { localDoodleEmojiItem2.pack_id });
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    DoodleEmojiItem localDoodleEmojiItem = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem;
    if (!TextUtils.equals(localDoodleEmojiItem.download_url, paramString))
    {
      SLog.d("DoodleEmojiManager", "DownloadListener onProgress error : " + localDoodleEmojiItem);
      SLog.d("DoodleEmojiManager", "DownloadListener onProgress error : call back url = " + paramString);
    }
    while (paramLong1 <= paramLong2 / 10L + this.b) {
      return;
    }
    SLog.a("DoodleEmojiManager", "DownloadListener onProgress " + paramLong1 + " / " + paramLong2);
    StoryDispatcher.a().dispatch(new DoodleEmojiManager.DoodleEmojiDownloadEvent(localDoodleEmojiItem, 0, false, paramLong2, paramLong1));
    this.b = paramLong1;
  }
  
  public void a(String paramString1, String paramString2)
  {
    SLog.b("DoodleEmojiManager", "onDownloadStart : url = " + paramString1 + ", path = " + paramString2);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DownloadAndUnZipJob
 * JD-Core Version:    0.7.0.1
 */