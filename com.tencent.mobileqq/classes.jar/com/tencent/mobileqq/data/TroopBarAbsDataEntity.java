package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import java.io.Externalizable;
import org.json.JSONObject;

public abstract class TroopBarAbsDataEntity
  extends Entity
  implements Externalizable
{
  public String id;
  
  public TroopBarAbsDataEntity() {}
  
  public TroopBarAbsDataEntity(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopBarAbsDataEntity
 * JD-Core Version:    0.7.0.1
 */