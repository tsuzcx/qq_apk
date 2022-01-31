import android.content.Context;
import com.tencent.biz.common.offline.AsyncCallBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.util.ILog;

public final class klu
  implements Runnable
{
  public klu(Context paramContext, String paramString, AsyncCallBack paramAsyncCallBack) {}
  
  public void run()
  {
    if (HtmlOffline.a.a()) {
      HtmlOffline.a.a("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,Begin transThread:");
    }
    new kmb(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncCallBack).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     klu
 * JD-Core Version:    0.7.0.1
 */