import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/BridgeInvokeHandler;", "", "bridgeModule", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;)V", "nsHandlerList", "Ljava/util/ArrayList;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/AbsBridgeInvokeHandler;", "Lkotlin/collections/ArrayList;", "invoke", "", "ns", "", "method", "jsonObject", "Lorg/json/JSONObject;", "callback", "nonStandardFormat", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tgr
{
  private final ArrayList<tgo> a = new ArrayList(16);
  
  public tgr(@NotNull BridgeModule paramBridgeModule)
  {
    ArrayList localArrayList = this.a;
    localArrayList.add(new thn(paramBridgeModule));
    localArrayList.add(new tgs(paramBridgeModule));
    localArrayList.add(new tht(paramBridgeModule));
    localArrayList.add(new tgp(paramBridgeModule));
    localArrayList.add(new tgx(paramBridgeModule));
    localArrayList.add(new tgv(paramBridgeModule));
    localArrayList.add(new thd(paramBridgeModule));
    localArrayList.add(new thh(paramBridgeModule));
    localArrayList.add(new tgz(paramBridgeModule));
    localArrayList.add(new thp(paramBridgeModule));
    localArrayList.add(new thb(paramBridgeModule));
    localArrayList.add(new thf(paramBridgeModule));
    localArrayList.add(new thj(paramBridgeModule));
    localArrayList.add(new thr(paramBridgeModule));
  }
  
  private final boolean a(String paramString1, String paramString2)
  {
    return (("downloadApp".equals(paramString2)) && ("app".equals(paramString1))) || (("openRoom".equals(paramString2)) && ("nowlive".equals(paramString1)));
  }
  
  public final boolean a(@NotNull String paramString1, @NotNull String paramString2, @NotNull JSONObject paramJSONObject, @Nullable String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "ns");
    Intrinsics.checkParameterIsNotNull(paramString2, "method");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "jsonObject");
    if (a(paramString1, paramString2)) {}
    for (;;)
    {
      Iterator localIterator = this.a.iterator();
      tgo localtgo;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localtgo = (tgo)localIterator.next();
      } while (!localtgo.a(paramString1));
      return localtgo.a(paramString2, paramJSONObject, paramString3);
      paramJSONObject = paramJSONObject.optJSONObject("params");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tgr
 * JD-Core Version:    0.7.0.1
 */