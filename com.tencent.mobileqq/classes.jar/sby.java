import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusRecommendItemData;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class sby
  implements IPTSLiteEventListener
{
  sby(sbx paramsbx) {}
  
  public void onExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView) {}
  
  public void onTapEventTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("identifier = ").append(paramString).append("\n");
      if (paramHashMap != null)
      {
        Iterator localIterator = paramHashMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          paramView.append("dataSet [ ").append((String)localEntry.getKey()).append(" ] = ").append((String)localEntry.getValue()).append("\n");
        }
      }
      QLog.i("WebPtsLiteViewCreator", 2, "[onTapEventTriggered], " + paramView.toString());
    }
    if ((paramHashMap == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        return;
        paramString = (BaseData)sbx.a(this.a).get(paramString);
      } while (!(paramString instanceof ProteusRecommendItemData));
      paramString = (ProteusRecommendItemData)paramString;
      sdn.a("id_native_recommend_small_container", paramString, null);
    } while (TextUtils.isEmpty((CharSequence)paramHashMap.get("jumpUrl")));
    paramString = ors.a((String)paramHashMap.get("jumpUrl"), paramString.c);
    ors.d(sbx.a(this.a), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sby
 * JD-Core Version:    0.7.0.1
 */