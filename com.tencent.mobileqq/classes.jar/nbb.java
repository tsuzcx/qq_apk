import android.os.Bundle;
import com.tencent.biz.qqstory.comment.lego.LegoNetworkRequester;
import com.tencent.biz.qqstory.comment.lego.LegoRequestBase;
import com.tencent.biz.qqstory.comment.lego.LegoResponseBase;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import mqq.observer.BusinessObserver;

public class nbb
  implements BusinessObserver
{
  public nbb(LegoNetworkRequester paramLegoNetworkRequester, long paramLong, LegoRequestBase paramLegoRequestBase, String paramString, LegoResponseBase paramLegoResponseBase) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    Object localObject;
    LegoResponseBase localLegoResponseBase;
    String str;
    if (paramBoolean)
    {
      localObject = paramBundle.getByteArray("data");
      if ((localObject != null) && (localObject.length > 0))
      {
        localLegoResponseBase = this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoRequestBase.a((byte[])localObject);
        if (localLegoResponseBase != null)
        {
          paramInt = localLegoResponseBase.jdField_a_of_type_Int;
          str = localLegoResponseBase.jdField_a_of_type_JavaLangString;
          if (paramInt == 0)
          {
            localLegoResponseBase.a();
            SLog.a("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s success take time:%d data length=%d", this.jdField_a_of_type_JavaLangString, Long.valueOf(l), Integer.valueOf(localObject.length));
            StoryReportor.b("story_net", this.jdField_a_of_type_JavaLangString, 0, paramInt, new String[] { str, String.valueOf(l), StoryReportor.a(BaseApplication.getContext()) });
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseBase.a(paramBoolean, paramBundle);
      return;
      localLegoResponseBase.a(paramInt, str);
      SLog.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt), str, Long.valueOf(l), Integer.valueOf(localObject.length) });
      break;
      SLog.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s error. response is null", new Object[] { this.jdField_a_of_type_JavaLangString });
      StoryReportor.b("story_net", this.jdField_a_of_type_JavaLangString, 0, 940002, new String[] { "response is null", String.valueOf(l), StoryReportor.a(BaseApplication.getContext()) });
      continue;
      this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseBase.a(-2, paramBundle);
      SLog.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:" + this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoRequestBase.a() + " channel error:%d, take time:%d", new Object[] { Integer.valueOf(-1), Long.valueOf(l) });
      StoryReportor.b("story_net", this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoRequestBase.a(), 0, 940002, new String[] { "rsp data error", String.valueOf(l), StoryReportor.a(BaseApplication.getContext()) });
      continue;
      paramInt = paramBundle.getInt("data_error_code");
      localObject = paramBundle.getString("data_error_msg");
      this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoResponseBase.a(paramInt, paramBundle);
      SLog.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:" + this.jdField_a_of_type_JavaLangString + " channel error:%d, take time:%d", new Object[] { Integer.valueOf(-1), Long.valueOf(l) });
      StoryReportor.b("story_net", this.jdField_a_of_type_JavaLangString, 0, paramInt, new String[] { localObject, String.valueOf(l), StoryReportor.a(BaseApplication.getContext()) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nbb
 * JD-Core Version:    0.7.0.1
 */