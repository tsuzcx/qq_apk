import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.jsbridge.GdtAdWebPlugin;
import com.tencent.gdtad.jsbridge.GdtLoadAdJsCallHandler;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class qpm
  implements GdtAdLoader.Listener
{
  public qpm(GdtLoadAdJsCallHandler paramGdtLoadAdJsCallHandler) {}
  
  public void a(GdtAdLoader paramGdtAdLoader)
  {
    if ((paramGdtAdLoader == null) || (paramGdtAdLoader.a() == null) || (GdtLoadAdJsCallHandler.a(this.a) == null) || (GdtLoadAdJsCallHandler.a(this.a).get() == null)) {
      return;
    }
    String str = (String)GdtLoadAdJsCallHandler.a(this.a).get(paramGdtAdLoader);
    GdtLoadAdJsCallHandler.a(this.a).remove(paramGdtAdLoader);
    Object localObject1 = GdtJsonPbUtil.a(paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
    Object localObject2 = GdtJsonPbUtil.a(paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp);
    paramGdtAdLoader = new JSONObject();
    try
    {
      paramGdtAdLoader.put("request", localObject1);
      paramGdtAdLoader.put("response", localObject2);
      ((GdtAdWebPlugin)GdtLoadAdJsCallHandler.a(this.a).get()).callJs(str, new String[] { paramGdtAdLoader.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qpm
 * JD-Core Version:    0.7.0.1
 */