package com.tencent.mobileqq.kandian.biz.skin.entity;

import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="id,uin")
public abstract class BaseResData<T extends MessageMicro>
  extends Entity
{
  public int beginTime;
  public String business = "";
  public int endTime;
  public String id;
  public boolean isReady;
  public String name;
  public byte[] resData;
  public long seq;
  public int showTime;
  public String uin;
  public String url;
  
  public BaseResData() {}
  
  public BaseResData(T paramT)
  {
    paramT = new StringBuilder();
    paramT.append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
    paramT.append("");
    this.uin = paramT.toString();
  }
  
  public BaseResData(JSONObject paramJSONObject)
  {
    paramJSONObject = new StringBuilder();
    paramJSONObject.append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
    paramJSONObject.append("");
    this.uin = paramJSONObject.toString();
  }
  
  protected void postRead() {}
  
  protected void postwrite() {}
  
  public abstract T toBody();
  
  public JSONObject toJson()
  {
    return new JSONObject();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaseResData{id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", seq=");
    localStringBuilder.append(this.seq);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.entity.BaseResData
 * JD-Core Version:    0.7.0.1
 */