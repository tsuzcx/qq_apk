package cooperation.qwallet.plugin;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import org.json.JSONObject;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IFakeUrl
  extends QRouteApi
{
  public abstract void gotoH5(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void gotoMqq(Context paramContext, String paramString);
  
  public abstract void gotoResultH5(Activity paramActivity, String paramString, boolean paramBoolean, int paramInt);
  
  public abstract void init(Context paramContext);
  
  public abstract boolean onFakePros(String paramString1, String paramString2, IFakeUrl.FakeListener paramFakeListener);
  
  public abstract boolean onFakePros(String paramString, JSONObject paramJSONObject, IFakeUrl.FakeListener paramFakeListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.IFakeUrl
 * JD-Core Version:    0.7.0.1
 */