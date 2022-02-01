package cooperation.qqcircle.report.datong;

import com.tencent.qqlive.module.videoreport.PageParams;
import java.util.HashMap;
import java.util.Map;

public class QCircleDTParamBuilder
{
  private Map<String, Object> params = new HashMap();
  
  public Map<String, Object> buildElementParams()
  {
    this.params.put("dt_appkey", "00000QG6YX3X0LZH");
    return this.params;
  }
  
  public PageParams buildPageParams()
  {
    this.params.put("dt_appkey", "00000QG6YX3X0LZH");
    return new PageParams(this.params);
  }
  
  public Map<String, Object> buildPageParamsMap()
  {
    this.params.put("dt_appkey", "00000QG6YX3X0LZH");
    return this.params;
  }
  
  public QCircleDTParamBuilder setPageSubclass(String paramString)
  {
    this.params.put("page_subclass", paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.datong.QCircleDTParamBuilder
 * JD-Core Version:    0.7.0.1
 */