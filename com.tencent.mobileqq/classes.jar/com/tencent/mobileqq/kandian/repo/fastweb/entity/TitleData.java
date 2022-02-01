package com.tencent.mobileqq.kandian.repo.fastweb.entity;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONObject;

public class TitleData
  extends ProteusItemData
{
  public String a;
  
  public TitleData()
  {
    super(0);
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("style_ID", "ReadInjoy_article_title_cell");
        localJSONObject.put("id_attribute_text", this.a);
        Object localObject1 = this.bc;
        if (localObject1 != null) {
          try
          {
            localObject1 = new JSONObject(this.bc);
            Iterator localIterator = ((JSONObject)localObject1).keys();
            if (localIterator != null) {
              if (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                localJSONObject.put(str, ((JSONObject)localObject1).opt(str));
                continue;
              }
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("merge result: ");
            ((StringBuilder)localObject1).append(localJSONObject.toString());
            QLog.d("TitleData", 2, ((StringBuilder)localObject1).toString());
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
          }
        }
        Object localObject2 = TemplateFactory.a("native_article", true);
        if (localObject2 == null) {
          break label177;
        }
        localObject2 = ((TemplateFactory)localObject2).getTemplateBean(localJSONObject);
        if (localObject2 != null)
        {
          this.bd = ((TemplateBean)localObject2);
          this.bb = localJSONObject;
          return;
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      return;
      label177:
      Object localObject3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.fastweb.entity.TitleData
 * JD-Core Version:    0.7.0.1
 */