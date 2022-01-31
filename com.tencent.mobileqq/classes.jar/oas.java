import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.DownloadTask;
import com.tencent.biz.qqstory.base.preload.SimplePreloadListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedVideoPreloader;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedVideoPreloader.CurrentVid;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedVideoPreloader.OnVideoDownloadListener;
import java.io.File;
import java.util.Map;

public class oas
  extends SimplePreloadListener
{
  public oas(FeedVideoPreloader paramFeedVideoPreloader)
  {
    super("Q.qqstory.download.preload.FeedVideoPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, DownloadTask paramDownloadTask)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramDownloadTask);
    a(paramString, paramInt1, paramErrorMessage, paramDownloadTask);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, DownloadTask paramDownloadTask)
  {
    FeedVideoPreloader.CurrentVid localCurrentVid = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader$CurrentVid;
    if (localCurrentVid == null) {}
    label14:
    label168:
    do
    {
      break label14;
      do
      {
        return;
      } while (!TextUtils.equals(paramString, localCurrentVid.jdField_a_of_type_JavaLangString));
      if (paramErrorMessage.isFail()) {
        if (!TextUtils.isEmpty(localCurrentVid.b)) {
          break label135;
        }
      }
      for (paramErrorMessage = paramErrorMessage.errorMsg;; paramErrorMessage = paramErrorMessage.errorMsg + " | " + paramErrorMessage.errorMsg)
      {
        localCurrentVid.b = paramErrorMessage;
        localCurrentVid.jdField_a_of_type_Int = (paramInt + 1000);
        if ((!paramDownloadTask.a.containsKey("handleCallback")) || (localCurrentVid.jdField_a_of_type_Boolean)) {
          break;
        }
        localCurrentVid.jdField_a_of_type_Boolean = true;
        if (!this.a.a(paramString)) {
          break label168;
        }
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader$OnVideoDownloadListener == null) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader$OnVideoDownloadListener.a(paramString, paramDownloadTask.d);
        return;
      }
    } while (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader$OnVideoDownloadListener == null);
    label135:
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader$OnVideoDownloadListener.a(paramString, paramDownloadTask.d, localCurrentVid.a());
  }
  
  public void b(String paramString, int paramInt, DownloadTask paramDownloadTask)
  {
    super.b(paramString, paramInt, paramDownloadTask);
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader$OnVideoDownloadListener != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader$OnVideoDownloadListener.b(paramString, paramDownloadTask.d);
    }
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, DownloadTask paramDownloadTask)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramDownloadTask);
    a(paramString, paramInt1, new ErrorMessage(), paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oas
 * JD-Core Version:    0.7.0.1
 */