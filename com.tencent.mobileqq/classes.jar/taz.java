import android.os.Bundle;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import mqq.observer.BusinessObserver;

class taz
  implements BusinessObserver
{
  taz(tay paramtay, long paramLong, tba paramtba, String paramString, tbb paramtbb) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    Object localObject;
    tbb localtbb;
    String str;
    if (paramBoolean)
    {
      localObject = paramBundle.getByteArray("data");
      if ((localObject != null) && (localObject.length > 0))
      {
        localtbb = this.jdField_a_of_type_Tba.a((byte[])localObject);
        if (localtbb != null)
        {
          paramInt = localtbb.jdField_a_of_type_Int;
          str = localtbb.jdField_a_of_type_JavaLangString;
          if (paramInt == 0)
          {
            localtbb.a();
            ved.a("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s success take time:%d data length=%d", this.jdField_a_of_type_JavaLangString, Long.valueOf(l), Integer.valueOf(localObject.length));
            vei.b("story_net", this.jdField_a_of_type_JavaLangString, 0, paramInt, new String[] { str, String.valueOf(l), vei.a(BaseApplication.getContext()) });
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Tbb.a(paramBoolean, paramBundle);
      return;
      localtbb.a(paramInt, str);
      ved.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt), str, Long.valueOf(l), Integer.valueOf(localObject.length) });
      break;
      ved.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s error. response is null", new Object[] { this.jdField_a_of_type_JavaLangString });
      vei.b("story_net", this.jdField_a_of_type_JavaLangString, 0, 940002, new String[] { "response is null", String.valueOf(l), vei.a(BaseApplication.getContext()) });
      continue;
      this.jdField_a_of_type_Tbb.a(-2, paramBundle);
      ved.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:" + this.jdField_a_of_type_Tba.a() + " channel error:%d, take time:%d", new Object[] { Integer.valueOf(-1), Long.valueOf(l) });
      vei.b("story_net", this.jdField_a_of_type_Tba.a(), 0, 940002, new String[] { "rsp data error", String.valueOf(l), vei.a(BaseApplication.getContext()) });
      continue;
      paramInt = paramBundle.getInt("data_error_code");
      localObject = paramBundle.getString("data_error_msg");
      this.jdField_a_of_type_Tbb.a(paramInt, paramBundle);
      ved.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:" + this.jdField_a_of_type_JavaLangString + " channel error:%d, take time:%d", new Object[] { Integer.valueOf(-1), Long.valueOf(l) });
      vei.b("story_net", this.jdField_a_of_type_JavaLangString, 0, paramInt, new String[] { localObject, String.valueOf(l), vei.a(BaseApplication.getContext()) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     taz
 * JD-Core Version:    0.7.0.1
 */