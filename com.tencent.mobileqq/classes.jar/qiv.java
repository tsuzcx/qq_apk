import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.aditem.GdtHttpPost.Listener;
import com.tencent.gdtad.aditem.GdtHttpPost.Params;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import tencent.gdt.qq_ad_get.QQAdGetRsp;

class qiv
  implements GdtHttpPost.Listener
{
  qiv(qiu paramqiu) {}
  
  public void a(GdtHttpPost.Params paramParams)
  {
    if (paramParams == null) {}
    for (;;)
    {
      this.a.a();
      return;
      if ((paramParams.a == 200) && (paramParams.b != null))
      {
        qiu.a(this.a).a = new qq_ad_get.QQAdGetRsp();
        try
        {
          qiu.a(this.a).a.mergeFrom(paramParams.b);
        }
        catch (InvalidProtocolBufferMicroException paramParams)
        {
          GdtLog.d("GdtAdLoader", "onResponse", paramParams);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     qiv
 * JD-Core Version:    0.7.0.1
 */