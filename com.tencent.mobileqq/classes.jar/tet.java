import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class tet
  implements rgy
{
  public tet(BridgeModule paramBridgeModule) {}
  
  public void a(UgcVideo paramUgcVideo)
  {
    QQAppInterface localQQAppInterface = ozs.a();
    QLog.i(BridgeModule.TAG, 1, "onPublish, title =" + paramUgcVideo.title);
    if (localQQAppInterface == null) {}
    String str;
    do
    {
      return;
      str = (String)BridgeModule.access$1600(this.a).get(Long.valueOf(0L));
      if ((str != null) && (!str.isEmpty())) {
        rgo.a(localQQAppInterface).a(0L, new teu(this, str));
      }
      str = (String)BridgeModule.access$1600(this.a).get(Long.valueOf(paramUgcVideo.columnId));
    } while ((str == null) || (str.isEmpty()));
    rgo.a(localQQAppInterface).a(paramUgcVideo.columnId, new tev(this, paramUgcVideo, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tet
 * JD-Core Version:    0.7.0.1
 */