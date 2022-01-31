import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.util.ILog;
import com.tencent.biz.common.util.NetworkUtil;

class kll
  implements AsyncBack
{
  kll(klk paramklk) {}
  
  public void a(int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a(paramInt);
  }
  
  public void a(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis() - this.a.jdField_a_of_type_Long;
    if (HtmlOffline.a.a()) {
      HtmlOffline.a.a("HtmlCheckUpdate", 2, "js call downloadUpdate callback:" + paramInt + ", time:" + l);
    }
    if (paramInt == 0) {
      if (HtmlOffline.b(this.a.b)) {
        this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a(null, 0);
      }
    }
    for (;;)
    {
      BidDownloader.b(this.a.b);
      HtmlOffline.a(this.a.b, paramInt, l, NetworkUtil.a(this.a.jdField_a_of_type_AndroidContentContext));
      return;
      this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a(null, 6);
      continue;
      this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a(null, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kll
 * JD-Core Version:    0.7.0.1
 */