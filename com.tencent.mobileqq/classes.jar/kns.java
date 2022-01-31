import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.util.ILog;
import com.tencent.biz.common.util.NetworkUtil;

class kns
  implements AsyncBack
{
  kns(knr paramknr) {}
  
  public void loaded(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis() - this.a.jdField_a_of_type_Long;
    if (HtmlOffline.a.a()) {
      HtmlOffline.a.a("HtmlCheckUpdate", 2, "js call downloadUpdate callback:" + paramInt + ", time:" + l);
    }
    if (paramInt == 0) {
      if (HtmlOffline.b(this.a.b)) {
        this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.loaded(null, 0);
      }
    }
    for (;;)
    {
      BidDownloader.b(this.a.b);
      HtmlOffline.a(this.a.b, paramInt, l, NetworkUtil.a(this.a.jdField_a_of_type_AndroidContentContext));
      return;
      this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.loaded(null, 6);
      continue;
      this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.loaded(null, 2);
    }
  }
  
  public void progress(int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.progress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kns
 * JD-Core Version:    0.7.0.1
 */