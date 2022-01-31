import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.DownloadTask;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader.CurrentVid;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader.OnVideoDownloadListener;
import com.tencent.biz.qqstory.base.preload.SimplePreloadListener;
import java.io.File;
import java.util.Map;

public class nae
  extends SimplePreloadListener
{
  public nae(PlayingListPreloader paramPlayingListPreloader)
  {
    super("Q.qqstory.download.preload.PlayingListPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, DownloadTask paramDownloadTask)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramDownloadTask);
    a(paramString, paramInt1, paramErrorMessage, paramDownloadTask);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, DownloadTask paramDownloadTask)
  {
    PlayingListPreloader.CurrentVid localCurrentVid = this.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$CurrentVid;
    if (localCurrentVid == null) {}
    label14:
    label169:
    do
    {
      break label14;
      do
      {
        return;
      } while (!TextUtils.equals(paramString, localCurrentVid.jdField_a_of_type_JavaLangString));
      if (paramErrorMessage.isFail()) {
        if (!TextUtils.isEmpty(localCurrentVid.b)) {
          break label136;
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
          break label169;
        }
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnVideoDownloadListener == null) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnVideoDownloadListener.a(paramString, paramDownloadTask.d, paramInt);
        return;
      }
    } while (this.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnVideoDownloadListener == null);
    label136:
    this.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnVideoDownloadListener.a(paramString, paramDownloadTask.d, localCurrentVid.a(), paramInt);
  }
  
  public void b(String paramString, int paramInt, DownloadTask paramDownloadTask)
  {
    super.b(paramString, paramInt, paramDownloadTask);
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnVideoDownloadListener != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnVideoDownloadListener.b(paramString, paramDownloadTask.d, paramInt);
    }
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, DownloadTask paramDownloadTask)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramDownloadTask);
    a(paramString, paramInt1, new ErrorMessage(), paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nae
 * JD-Core Version:    0.7.0.1
 */