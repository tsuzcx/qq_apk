package cooperation.qqcircle.report.datong;

import com.tencent.qqlive.module.videoreport.PageParams;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import java.util.HashMap;
import java.util.Map;

public class QCircleDTParamBuilder
{
  public Map<String, Object> buildElementParams()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", "00000QG6YX3X0LZH");
    localHashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
    return localHashMap;
  }
  
  public PageParams buildPageParams(String paramString)
  {
    return buildPageParams(paramString, null);
  }
  
  public PageParams buildPageParams(String paramString, Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    if ((paramMap != null) && (paramMap.size() > 0)) {
      localHashMap.putAll(paramMap);
    }
    localHashMap.put("dt_appkey", "00000QG6YX3X0LZH");
    localHashMap.put("page_subclass", paramString);
    localHashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
    return new PageParams(localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.datong.QCircleDTParamBuilder
 * JD-Core Version:    0.7.0.1
 */