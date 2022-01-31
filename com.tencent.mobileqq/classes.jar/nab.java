import com.tencent.biz.qqstory.base.preload.AsyncFileDownloader.InnerBaseDownloader;
import com.tencent.biz.qqstory.base.preload.DownloadTask;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.util.HashMap;

public class nab
  implements INetEngine.IBreakDownFix
{
  public nab(AsyncFileDownloader.InnerBaseDownloader paramInnerBaseDownloader) {}
  
  public void a(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    while (!(paramNetReq instanceof HttpNetReq)) {
      return;
    }
    HttpNetReq localHttpNetReq = (HttpNetReq)paramNetReq;
    localHttpNetReq.jdField_a_of_type_Long += paramNetResp.c;
    paramNetResp.c = 0L;
    paramNetResp = "bytes=" + localHttpNetReq.jdField_a_of_type_Long + "-";
    localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", paramNetResp);
    String str1 = localHttpNetReq.jdField_a_of_type_JavaLangString;
    if (str1.contains("range="))
    {
      String str2 = str1.substring(0, str1.lastIndexOf("range="));
      localHttpNetReq.jdField_a_of_type_JavaLangString = (str2 + "range=" + localHttpNetReq.jdField_a_of_type_Long);
    }
    paramNetReq = paramNetReq.a();
    if ((paramNetReq != null) && ((paramNetReq instanceof DownloadTask))) {
      ((DownloadTask)paramNetReq).b = true;
    }
    SLog.b("AsyncFileDownloader", String.format("breakDown , range = %s , url = %s", new Object[] { paramNetResp, str1 }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nab
 * JD-Core Version:    0.7.0.1
 */