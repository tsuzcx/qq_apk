import com.tencent.tkd.comment.publisher.qq.bridge.QQUrlImageBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQUrlImageBridge.Callback;
import java.net.MalformedURLException;
import java.net.URL;

public class pdb
  implements QQUrlImageBridge
{
  public void loadUrlImage(String paramString, int paramInt1, int paramInt2, QQUrlImageBridge.Callback paramCallback)
  {
    try
    {
      URL localURL2 = uro.a.a(paramString);
      URL localURL1 = localURL2;
      if (localURL2 == null)
      {
        localURL1 = new URL(paramString);
        uro.a.a(localURL1);
      }
      paramString = new tlw();
      qdn.a.a(paramString, localURL1.toString());
      paramString.a = paramInt1;
      paramString.b = paramInt2;
      qdm.a(1, paramString);
      tlv.a().a(paramString, new pdc(this, paramCallback));
      return;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pdb
 * JD-Core Version:    0.7.0.1
 */