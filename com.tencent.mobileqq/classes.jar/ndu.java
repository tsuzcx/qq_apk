import com.tencent.biz.common.util.ZipUtils;
import com.tencent.biz.qqstory.base.download.Downloader;
import com.tencent.biz.qqstory.model.filter.VideoFilterManager;
import com.tencent.biz.qqstory.model.pendant.FileDownloadTask;
import com.tencent.biz.qqstory.model.pendant.FileDownloadTask.Input;
import com.tencent.biz.qqstory.model.pendant.FileDownloadTask.Output;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import java.io.File;
import java.util.Map;

public class ndu
  extends FileDownloadTask
{
  public ndu(VideoFilterManager paramVideoFilterManager, Downloader paramDownloader)
  {
    super(paramDownloader);
  }
  
  protected FileDownloadTask.Output a(FileDownloadTask.Input... paramVarArgs)
  {
    FileDownloadTask.Output localOutput = super.a(paramVarArgs);
    paramVarArgs = paramVarArgs[0];
    String str;
    if (localOutput.jdField_a_of_type_Int == 0) {
      str = paramVarArgs.b.substring(0, paramVarArgs.b.length() - 4);
    }
    try
    {
      FileUtils.d(str);
      label42:
      int i = ZipUtils.a(paramVarArgs.b, str);
      if (i == 0)
      {
        if (VideoFilterManager.a(str, false)) {
          try
          {
            paramVarArgs = this.a.a(new File(str, "config.json"));
            if (paramVarArgs != null)
            {
              SLog.d("FileDownloadTask", "parse config file success !");
              this.a.a.put(str, paramVarArgs);
              return localOutput;
            }
          }
          catch (Exception paramVarArgs)
          {
            for (;;)
            {
              SLog.c("FileDownloadTask", "parse config failed", paramVarArgs);
              paramVarArgs = null;
            }
            SLog.e("FileDownloadTask", "parse config failed : %s, %s", new Object[] { str, "config.json" });
            return new FileDownloadTask.Output(localOutput.jdField_a_of_type_ComTencentBizQqstoryModelPendantFileDownloadTask$Input, -1, "illegal config file");
          }
        }
        SLog.e("FileDownloadTask", "unzip success, but this is an illegal filter folder : %s", new Object[] { str });
        return new FileDownloadTask.Output(localOutput.jdField_a_of_type_ComTencentBizQqstoryModelPendantFileDownloadTask$Input, -1, "illegal folder");
      }
      SLog.e("FileDownloadTask", "download success, but unzip failed : %d", new Object[] { Integer.valueOf(i) });
      return new FileDownloadTask.Output(localOutput.jdField_a_of_type_ComTencentBizQqstoryModelPendantFileDownloadTask$Input, i, "unzip failed");
    }
    catch (Exception localException)
    {
      break label42;
    }
  }
  
  protected void a(FileDownloadTask.Output arg1)
  {
    SLog.a("FileDownloadTask", "downloadConfigFile onPostExecute : %s", ???);
    if (???.jdField_a_of_type_Int == 0) {
      SLog.d("FileDownloadTask", "get filter resource success : %s", new Object[] { ???.jdField_a_of_type_ComTencentBizQqstoryModelPendantFileDownloadTask$Input.jdField_a_of_type_JavaLangString });
    }
    synchronized (this.a.b)
    {
      VideoFilterManager.a(this.a, null);
      this.a.d();
      return;
      SLog.d("FileDownloadTask", "get filter resource failed : %d : %s : %s", new Object[] { Integer.valueOf(???.jdField_a_of_type_Int), ???.jdField_a_of_type_JavaLangString, ???.jdField_a_of_type_ComTencentBizQqstoryModelPendantFileDownloadTask$Input.jdField_a_of_type_JavaLangString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ndu
 * JD-Core Version:    0.7.0.1
 */