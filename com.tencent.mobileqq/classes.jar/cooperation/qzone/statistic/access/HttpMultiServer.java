package cooperation.qzone.statistic.access;

public abstract class HttpMultiServer
{
  protected String defaultServer = null;
  protected boolean optionalEnabled = false;
  
  public HttpMultiServer()
  {
    this(null);
  }
  
  public HttpMultiServer(String paramString)
  {
    this(paramString, false);
  }
  
  public HttpMultiServer(String paramString, boolean paramBoolean)
  {
    setDefaultServer(paramString);
    setOptionalEnabled(paramBoolean);
  }
  
  public abstract String acquireOptionalServer();
  
  public String getDefaultServer()
  {
    return this.defaultServer;
  }
  
  public String getOptionalRedirectHost()
  {
    return null;
  }
  
  public String getOptionalServer()
  {
    if (isOptionalEnabled()) {
      return acquireOptionalServer();
    }
    return null;
  }
  
  public boolean isOptionalEnabled()
  {
    return this.optionalEnabled;
  }
  
  public void setDefaultServer(String paramString)
  {
    this.defaultServer = paramString;
  }
  
  public void setOptionalEnabled(boolean paramBoolean)
  {
    this.optionalEnabled = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.statistic.access.HttpMultiServer
 * JD-Core Version:    0.7.0.1
 */