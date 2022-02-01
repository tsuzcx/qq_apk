package cooperation.qqcircle.helpers;

import java.util.LinkedHashMap;
import java.util.Map;

public class QCircleIniFile$Section
{
  private String name;
  private Map<String, Object> values = new LinkedHashMap();
  
  public Object get(String paramString)
  {
    return this.values.get(paramString);
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Map<String, Object> getValues()
  {
    return this.values;
  }
  
  public void set(String paramString, Object paramObject)
  {
    this.values.put(paramString, paramObject);
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.helpers.QCircleIniFile.Section
 * JD-Core Version:    0.7.0.1
 */