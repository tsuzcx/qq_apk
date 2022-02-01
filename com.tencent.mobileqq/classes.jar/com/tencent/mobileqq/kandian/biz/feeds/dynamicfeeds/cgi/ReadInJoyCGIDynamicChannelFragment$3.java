package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.cgi;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.pts.data.DynamicChannelDataModel;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyCGIDynamicChannelFragment$3
  implements Runnable
{
  ReadInJoyCGIDynamicChannelFragment$3(ReadInJoyCGIDynamicChannelFragment paramReadInJoyCGIDynamicChannelFragment, ConcurrentHashMap paramConcurrentHashMap) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((ConcurrentHashMap)localObject1).size() > 0))
    {
      localObject1 = this.a.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((DynamicChannelDataModel)((Iterator)localObject1).next()).mTemplateBean;
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("channel_id", ReadInJoyCGIDynamicChannelFragment.n(this.this$0));
        }
        catch (JSONException localJSONException1)
        {
          QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "put channelID failed, mChannelID = ", Integer.valueOf(ReadInJoyCGIDynamicChannelFragment.o(this.this$0)), ", e = ", localJSONException1 });
        }
        if (localObject2 != null)
        {
          localObject2 = ((TemplateBean)localObject2).getDataAttribute(null);
          if (localObject2 != null)
          {
            localObject2 = ((Map)localObject2).entrySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
              String str = (String)((Map.Entry)localObject3).getKey();
              localObject3 = ((Map.Entry)localObject3).getValue();
              try
              {
                localJSONObject.put(str, localObject3);
              }
              catch (JSONException localJSONException2)
              {
                QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "reportExposedData, e", localJSONException2);
              }
            }
          }
        }
        QLog.d("ReadInJoyDynamicChannelBaseFragment", 1, new Object[] { "actionName = ", ReadInJoyCGIDynamicChannelFragment.p(this.this$0), ", r5 = ", localJSONObject.toString() });
        PublicAccountReportUtils.a(null, "", ReadInJoyCGIDynamicChannelFragment.q(this.this$0), ReadInJoyCGIDynamicChannelFragment.r(this.this$0), 0, 0, "", "", "", localJSONObject.toString(), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment.3
 * JD-Core Version:    0.7.0.1
 */