import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class sox
  implements qux
{
  public sox(BridgeModule paramBridgeModule) {}
  
  public void a(UgcVideo paramUgcVideo)
  {
    QQAppInterface localQQAppInterface = ors.a();
    QLog.i(BridgeModule.TAG, 1, "onPublish, title =" + paramUgcVideo.title);
    if (localQQAppInterface == null) {}
    String str;
    do
    {
      return;
      str = (String)BridgeModule.access$900(this.a).get(Long.valueOf(0L));
      if ((str != null) && (!str.isEmpty())) {
        qun.a(localQQAppInterface).a(0L, new soy(this, str));
      }
      str = (String)BridgeModule.access$900(this.a).get(Long.valueOf(paramUgcVideo.columnId));
    } while ((str == null) || (str.isEmpty()));
    qun.a(localQQAppInterface).a(paramUgcVideo.columnId, new soz(this, paramUgcVideo, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sox
 * JD-Core Version:    0.7.0.1
 */