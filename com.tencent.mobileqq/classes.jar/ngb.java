import android.graphics.Bitmap;
import com.tencent.biz.qqstory.newshare.job.DownloadPic2FileJob;
import com.tencent.biz.qqstory.shareGroup.icon.UrlBitmapDownloader.Listener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.utils.ImageUtil;

public class ngb
  implements UrlBitmapDownloader.Listener
{
  public ngb(DownloadPic2FileJob paramDownloadPic2FileJob, String paramString) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (DownloadPic2FileJob.a(this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobDownloadPic2FileJob))
    {
      paramString = ImageUtil.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
      paramBitmap.recycle();
      bool = BitmapUtils.a(paramString, DownloadPic2FileJob.a(this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobDownloadPic2FileJob));
      paramString.recycle();
      DownloadPic2FileJob.a(this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobDownloadPic2FileJob, bool);
      return;
    }
    boolean bool = BitmapUtils.a(paramBitmap, DownloadPic2FileJob.a(this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobDownloadPic2FileJob));
    DownloadPic2FileJob.b(this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobDownloadPic2FileJob, bool);
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    SLog.e("DownloadPic2FileJob", "Download url failed url=%s", new Object[] { this.jdField_a_of_type_JavaLangString });
    DownloadPic2FileJob.c(this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobDownloadPic2FileJob, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngb
 * JD-Core Version:    0.7.0.1
 */