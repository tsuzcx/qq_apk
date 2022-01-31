import com.tencent.biz.qqstory.base.download.DownloadProgressListener;
import com.tencent.biz.qqstory.model.pendant.FileDownloadTask;
import com.tencent.biz.qqstory.model.pendant.FileDownloadTask.Input;
import com.tencent.biz.qqstory.model.pendant.FileDownloadTask.Progress;

public class nco
  implements DownloadProgressListener
{
  public nco(FileDownloadTask paramFileDownloadTask, FileDownloadTask.Input paramInput) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    FileDownloadTask.a(this.jdField_a_of_type_ComTencentBizQqstoryModelPendantFileDownloadTask, new FileDownloadTask.Progress[] { new FileDownloadTask.Progress(this.jdField_a_of_type_ComTencentBizQqstoryModelPendantFileDownloadTask$Input, paramLong1, paramLong2) });
  }
  
  public void a(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nco
 * JD-Core Version:    0.7.0.1
 */