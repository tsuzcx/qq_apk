package com.tencent.mobileqq.kandian.biz.pts.lite;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.DefaultPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class PTSLiteItemViewBuilder$1
  extends DefaultPTSLiteEventListener
{
  PTSLiteItemViewBuilder$1(PTSLiteItemViewBuilder paramPTSLiteItemViewBuilder) {}
  
  public void onExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    PTSLiteItemViewBuilder.a(this.a, paramString, paramHashMap, paramView, "[onExposureTriggered]");
  }
  
  public void onSwiperDragTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    PTSLiteItemViewBuilder.a(this.a, paramString, paramHashMap, paramView, "[onSwiperItemExposureTriggered]");
    if (PTSLiteItemViewBuilder.c(this.a) == null)
    {
      QLog.e("PTSLiteItemViewBuilder", 1, "[onSwiperDragTriggered], ptsLiteSwiperEventDispatcher is null.");
      return;
    }
    PTSLiteItemViewBuilder.c(this.a).a(paramString, paramHashMap, paramView);
  }
  
  public void onSwiperItemExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    PTSLiteItemViewBuilder.a(this.a, paramString, paramHashMap, paramView, "[onSwiperItemExposureTriggered]");
    if (PTSLiteItemViewBuilder.c(this.a) == null)
    {
      QLog.e("PTSLiteItemViewBuilder", 1, "[onSwiperItemExposureTriggered], ptsLiteSwiperEventDispatcher is null.");
      return;
    }
    PTSLiteItemViewBuilder.c(this.a).a(paramString, paramHashMap, paramView, RIJKanDianFolderStatus.getFolderStatus(PTSLiteItemViewBuilder.d(this.a).c()));
  }
  
  public void onTapEventTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    PTSLiteItemViewBuilder.a(this.a, paramString, paramHashMap, paramView, "[onTapEventTriggered]");
    if ((paramHashMap != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (PTSLiteItemViewBuilder.a(this.a) == null) {
        return;
      }
      if (PTSLiteItemViewBuilder.b(this.a) == null)
      {
        QLog.i("PTSLiteItemViewBuilder", 1, "[onTapEventTriggered], ptsLiteTapEventDispatcher is null.");
        return;
      }
      PTSLiteItemViewBuilder.b(this.a).a(paramString, paramHashMap, paramView, paramPTSComposer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteItemViewBuilder.1
 * JD-Core Version:    0.7.0.1
 */