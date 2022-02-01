package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;
import com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteEventTypeHandler;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.ProteusRecommendItemData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.DefaultPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class WebPtsLiteViewCreator$2
  extends DefaultPTSLiteEventListener
{
  WebPtsLiteViewCreator$2(WebPtsLiteViewCreator paramWebPtsLiteViewCreator) {}
  
  public void onTapEventTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("identifier = ");
      paramView.append(paramString);
      paramView.append("\n");
      if (paramHashMap != null)
      {
        localObject = paramHashMap.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          paramView.append("dataSet [ ");
          paramView.append((String)localEntry.getKey());
          paramView.append(" ] = ");
          paramView.append((String)localEntry.getValue());
          paramView.append("\n");
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onTapEventTriggered], ");
      ((StringBuilder)localObject).append(paramView.toString());
      QLog.i("WebPtsLiteViewCreator", 2, ((StringBuilder)localObject).toString());
    }
    PTSLiteEventTypeHandler.a.a(paramPTSComposer, paramHashMap);
    if (paramHashMap != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramString = (BaseData)WebPtsLiteViewCreator.c(this.a).get(paramString);
      if (!(paramString instanceof ProteusRecommendItemData)) {
        return;
      }
      paramString = (ProteusRecommendItemData)paramString;
      ReportUtil.a("id_native_recommend_small_container", paramString, null);
      if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("jumpUrl")))
      {
        paramString = RIJJumpUtils.a((String)paramHashMap.get("jumpUrl"), paramString.bb);
        RIJJumpUtils.c(WebPtsLiteViewCreator.d(this.a), paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebPtsLiteViewCreator.2
 * JD-Core Version:    0.7.0.1
 */