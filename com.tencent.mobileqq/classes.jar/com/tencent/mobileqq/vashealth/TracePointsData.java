package com.tencent.mobileqq.vashealth;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import org.json.JSONObject;

public class TracePointsData
  extends Entity
{
  public static final String TABLE_NAME = "TracePointsData";
  public int accuracy;
  public double altitude;
  public float latitude;
  public float longitude;
  public float speed;
  public long startTime;
  public int steps;
  @unique
  public long time;
  
  public JSONObject toJson()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("startTime", this.startTime);
      localJSONObject.put("time", this.time);
      localJSONObject.put("latitude", Double.parseDouble(Float.toString(this.latitude)));
      localJSONObject.put("longitude", Double.parseDouble(Float.toString(this.longitude)));
      localJSONObject.put("speed", this.speed);
      localJSONObject.put("accuracy", this.accuracy);
      localJSONObject.put("steps", this.steps);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lat: ").append(Float.toString(this.latitude)).append(",lon: ").append(Float.toString(this.longitude)).append(",time: ").append(this.time).append(",speed: ").append(this.speed).append(",accuracy: ").append(this.accuracy).append(",steps: ").append(this.steps);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.TracePointsData
 * JD-Core Version:    0.7.0.1
 */