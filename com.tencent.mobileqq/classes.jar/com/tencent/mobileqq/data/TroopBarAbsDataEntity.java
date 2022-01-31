package com.tencent.mobileqq.data;

import auko;
import java.io.Externalizable;
import org.json.JSONObject;

public abstract class TroopBarAbsDataEntity
  extends auko
  implements Externalizable
{
  public String id;
  
  public TroopBarAbsDataEntity() {}
  
  public TroopBarAbsDataEntity(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopBarAbsDataEntity
 * JD-Core Version:    0.7.0.1
 */