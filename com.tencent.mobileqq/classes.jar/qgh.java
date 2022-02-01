import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.DefaultPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class qgh
  extends DefaultPTSLiteEventListener
{
  qgh(qgg paramqgg) {}
  
  public void onExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    qgg.a(this.a, paramString, paramHashMap, paramView, "[onExposureTriggered]");
  }
  
  public void onSwiperDragTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    qgg.a(this.a, paramString, paramHashMap, paramView, "[onSwiperItemExposureTriggered]");
    if (qgg.a(this.a) == null)
    {
      QLog.e("PTSLiteItemViewBuilder", 1, "[onSwiperDragTriggered], ptsLiteSwiperEventDispatcher is null.");
      return;
    }
    qgg.a(this.a).a(paramString, paramHashMap, paramView);
  }
  
  public void onSwiperItemExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    qgg.a(this.a, paramString, paramHashMap, paramView, "[onSwiperItemExposureTriggered]");
    if (qgg.a(this.a) == null)
    {
      QLog.e("PTSLiteItemViewBuilder", 1, "[onSwiperItemExposureTriggered], ptsLiteSwiperEventDispatcher is null.");
      return;
    }
    qgg.a(this.a).a(paramString, paramHashMap, paramView, ozs.e(qgg.a(this.a).a()));
  }
  
  public void onTapEventTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    qgg.a(this.a, paramString, paramHashMap, paramView, "[onTapEventTriggered]");
    if ((paramHashMap == null) || (TextUtils.isEmpty(paramString)) || (qgg.a(this.a) == null)) {
      return;
    }
    if ((ArticleInfo)qgg.a(this.a).get(paramString) == null)
    {
      QLog.i("PTSLiteItemViewBuilder", 1, "[onTapEventTriggered], articleInfo is null.");
      return;
    }
    if (qgg.a(this.a) == null)
    {
      QLog.i("PTSLiteItemViewBuilder", 1, "[onTapEventTriggered], ptsLiteTapEventDispatcher is null.");
      return;
    }
    qgg.a(this.a).a(paramString, paramHashMap, paramView, paramPTSComposer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qgh
 * JD-Core Version:    0.7.0.1
 */