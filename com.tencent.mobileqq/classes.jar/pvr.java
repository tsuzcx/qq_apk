import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class pvr
  implements IPTSLiteEventListener
{
  pvr(pvq parampvq) {}
  
  public void onExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView) {}
  
  public void onTapEventTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView)
  {
    if ((QLog.isDebugVersion()) || (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("identifier = ").append(paramString).append("\n");
      if (paramHashMap != null)
      {
        Iterator localIterator = paramHashMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localStringBuilder.append("dataSet [ ").append((String)localEntry.getKey()).append(" ] =").append((String)localEntry.getValue()).append("\n");
        }
      }
      QLog.i("PTSLiteItemViewBuilder", 2, "[onTapEventTriggered], " + localStringBuilder.toString());
    }
    if ((paramHashMap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if ((ArticleInfo)pvq.a(this.a).get(paramString) == null)
    {
      QLog.i("PTSLiteItemViewBuilder", 1, "[onTapEventTriggered], articleInfo is null.");
      return;
    }
    pvq.a(this.a).a(paramString, paramHashMap, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pvr
 * JD-Core Version:    0.7.0.1
 */