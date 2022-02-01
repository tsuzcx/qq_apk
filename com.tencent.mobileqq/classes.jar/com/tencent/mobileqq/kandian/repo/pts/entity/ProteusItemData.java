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
  public int A = -1;
  public TemplateBean a;
  public PTSComposer.IPTSUpdateDataListener a;
  public PTSComposer a;
  public PTSItemData a;
  public String ad;
  public String ae;
  public String af;
  public JSONObject c;
  public boolean g = true;
  public int z = 0;
  
  public ProteusItemData(int paramInt)
  {
    super(paramInt);
    this.jdField_a_of_type_ComTencentPtsCorePTSComposer$IPTSUpdateDataListener = new ProteusItemData.1(this);
  }
  
  public ProteusItemData(Parcel paramParcel)
  {
    super(paramParcel);
    this.jdField_a_of_type_ComTencentPtsCorePTSComposer$IPTSUpdateDataListener = new ProteusItemData.1(this);
  }
  
  public void a(BaseTemplateFactory paramBaseTemplateFactory)
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = ProteusParser.getTemplateBean(paramBaseTemplateFactory, this.c);
      return;
    }
    catch (JSONException paramBaseTemplateFactory)
    {
      QLog.e("ProteusItemData", 1, paramBaseTemplateFactory.getMessage());
    }
  }
  
  protected void a(JSONObject paramJSONObject) {}
  
  public String b()
  {
    if (this.z == 3)
    {
      JSONObject localJSONObject = this.c;
      if (localJSONObject != null) {
        return localJSONObject.optString("mVideoVid");
      }
    }
    return "";
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = null;
  }
  
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
    this.c = paramJSONObject;
  }
  
  public String c()
  {
    if (this.z == 2)
    {
      JSONObject localJSONObject = this.c;
      if (localJSONObject != null) {
        return localJSONObject.optString("articleImageUrl");
      }
    }
    return "";
  }
  
  public void c(String paramString)
  {
    this.ad = paramString;
  }
  
  public String d()
  {
    if (this.z == 4)
    {
      JSONObject localJSONObject = this.c;
      if (localJSONObject != null) {
        return localJSONObject.optString("type");
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData
 * JD-Core Version:    0.7.0.1
 */