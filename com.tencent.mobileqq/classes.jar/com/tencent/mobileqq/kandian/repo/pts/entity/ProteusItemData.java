package com.tencent.mobileqq.kandian.repo.pts.entity;

import android.os.Parcel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ProteusItemData
  extends BaseData
{
  public JSONObject bb;
  public String bc;
  public TemplateBean bd;
  public int be = 0;
  public int bf = -1;
  public boolean bg = true;
  public String bh;
  public String bi;
  public PTSItemData bj;
  public PTSComposer bk;
  public PTSComposer.IPTSUpdateDataListener bl = new ProteusItemData.1(this);
  
  public ProteusItemData(int paramInt)
  {
    super(paramInt);
  }
  
  public ProteusItemData(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public void a(BaseTemplateFactory paramBaseTemplateFactory)
  {
    try
    {
      this.bd = ProteusParser.getTemplateBean(paramBaseTemplateFactory, this.bb);
      return;
    }
    catch (JSONException paramBaseTemplateFactory)
    {
      QLog.e("ProteusItemData", 1, paramBaseTemplateFactory.getMessage());
    }
  }
  
  protected void a(JSONObject paramJSONObject) {}
  
  public void b(JSONObject paramJSONObject)
  {
    try
    {
      a(paramJSONObject);
    }
    catch (Exception localException)
    {
      QLog.e("ProteusItemData", 2, localException.getMessage());
    }
    this.bb = paramJSONObject;
  }
  
  public void c(String paramString)
  {
    this.bc = paramString;
  }
  
  public String m()
  {
    if (this.be == 3)
    {
      JSONObject localJSONObject = this.bb;
      if (localJSONObject != null) {
        return localJSONObject.optString("mVideoVid");
      }
    }
    return "";
  }
  
  public String n()
  {
    if (this.be == 2)
    {
      JSONObject localJSONObject = this.bb;
      if (localJSONObject != null) {
        return localJSONObject.optString("articleImageUrl");
      }
    }
    return "";
  }
  
  public String o()
  {
    if (this.be == 4)
    {
      JSONObject localJSONObject = this.bb;
      if (localJSONObject != null) {
        return localJSONObject.optString("type");
      }
    }
    return "";
  }
  
  public void p()
  {
    this.bd = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData
 * JD-Core Version:    0.7.0.1
 */