package cooperation.qqcircle.beans;

import java.io.Serializable;
import java.util.HashMap;

public class QCircleSchemeBean
  implements Serializable
{
  private static final long serialVersionUID = 322069543369932762L;
  private String mAction;
  private HashMap<String, String> mAttrs;
  private long mEnterTime;
  
  public HashMap<String, String> getAttrs()
  {
    return this.mAttrs;
  }
  
  public long getEnterTime()
  {
    return this.mEnterTime;
  }
  
  public String getSchemeAction()
  {
    return this.mAction;
  }
  
  public QCircleSchemeBean setAttrs(HashMap<String, String> paramHashMap)
  {
    this.mAttrs = paramHashMap;
    return this;
  }
  
  public void setEnterTime(long paramLong)
  {
    this.mEnterTime = paramLong;
  }
  
  public QCircleSchemeBean setSchemeAction(String paramString)
  {
    this.mAction = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.beans.QCircleSchemeBean
 * JD-Core Version:    0.7.0.1
 */