import android.text.TextUtils;
import android.view.View;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.DefaultPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class qyn
  extends DefaultPTSLiteEventListener
{
  qyn(qym paramqym) {}
  
  public void onExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    qym.a(this.a, paramString, paramHashMap, paramView, "[onExposureTriggered]");
  }
  
  public void onSwiperDragTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    qym.a(this.a, paramString, paramHashMap, paramView, "[onSwiperItemExposureTriggered]");
    if (qym.a(this.a) == null)
    {
      QLog.e("PTSLiteItemViewBuilder", 1, "[onSwiperDragTriggered], ptsLiteSwiperEventDispatcher is null.");
      return;
    }
    qym.a(this.a).a(paramString, paramHashMap, paramView);
  }
  
  public void onSwiperItemExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    qym.a(this.a, paramString, paramHashMap, paramView, "[onSwiperItemExposureTriggered]");
    if (qym.a(this.a) == null)
    {
      QLog.e("PTSLiteItemViewBuilder", 1, "[onSwiperItemExposureTriggered], ptsLiteSwiperEventDispatcher is null.");
      return;
    }
    qym.a(this.a).a(paramString, paramHashMap, paramView, prp.a(qym.a(this.a).a()));
  }
  
  public void onTapEventTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    qym.a(this.a, paramString, paramHashMap, paramView, "[onTapEventTriggered]");
    if ((paramHashMap == null) || (TextUtils.isEmpty(paramString)) || (qym.a(this.a) == null)) {
      return;
    }
    if (qym.a(this.a) == null)
    {
      QLog.i("PTSLiteItemViewBuilder", 1, "[onTapEventTriggered], ptsLiteTapEventDispatcher is null.");
      return;
    }
    qym.a(this.a).a(paramString, paramHashMap, paramView, paramPTSComposer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qyn
 * JD-Core Version:    0.7.0.1
 */