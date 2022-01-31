import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.jsbridge.GdtAdWebPlugin;
import com.tencent.gdtad.jsbridge.GdtLoadAdJsCallHandler;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public class qkv
  implements GdtAdLoader.Listener
{
  public qkv(GdtLoadAdJsCallHandler paramGdtLoadAdJsCallHandler) {}
  
  public void a(GdtAdLoader.Session paramSession)
  {
    if ((paramSession == null) || (GdtLoadAdJsCallHandler.a(this.a) == null) || (GdtLoadAdJsCallHandler.a(this.a).get() == null)) {
      return;
    }
    String str = (String)GdtLoadAdJsCallHandler.a(this.a).get(paramSession);
    GdtLoadAdJsCallHandler.a(this.a).remove(paramSession);
    Object localObject = GdtJsonPbUtil.a(paramSession.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
    GdtJsonPbUtil.a(paramSession.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp);
    if ((localObject != null) && (localObject != JSONObject.NULL)) {}
    for (paramSession = localObject.toString();; paramSession = null)
    {
      ((GdtAdWebPlugin)GdtLoadAdJsCallHandler.a(this.a).get()).callJs(str, new String[] { paramSession });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qkv
 * JD-Core Version:    0.7.0.1
 */