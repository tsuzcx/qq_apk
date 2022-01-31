import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.net.GdtHttp.Listener;
import com.tencent.gdtad.net.GdtHttp.Params;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import tencent.gdt.qq_ad_get.QQAdGetRsp;

public class qpg
  implements GdtHttp.Listener
{
  public qpg(GdtAdLoader paramGdtAdLoader) {}
  
  public void a(GdtHttp.Params paramParams)
  {
    if (paramParams == null) {}
    for (;;)
    {
      GdtAdLoader.a(this.a);
      return;
      if ((paramParams.c == 200) && (paramParams.b != null))
      {
        GdtAdLoader.a(this.a).a = new qq_ad_get.QQAdGetRsp();
        try
        {
          GdtAdLoader.a(this.a).a.mergeFrom(paramParams.b);
        }
        catch (InvalidProtocolBufferMicroException paramParams)
        {
          GdtLog.d("GdtAdLoader", "onResponse", paramParams);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qpg
 * JD-Core Version:    0.7.0.1
 */