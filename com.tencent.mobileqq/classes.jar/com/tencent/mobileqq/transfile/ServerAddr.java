package com.tencent.mobileqq.transfile;

public class ServerAddr
{
  public boolean isDomain = false;
  public boolean isIpv6;
  public String mIp;
  public int port = 80;
  
  public String getServerUrl(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramString != null)
    {
      if (this.isDomain)
      {
        if (paramString.startsWith("http://"))
        {
          paramString = new StringBuilder();
          paramString.append("http://");
          paramString.append(this.mIp);
          localObject1 = paramString.toString();
        }
        else if (paramString.startsWith("https://"))
        {
          paramString = new StringBuilder();
          paramString.append("https://");
          paramString.append(this.mIp);
          localObject1 = paramString.toString();
        }
        paramString = new StringBuilder();
        paramString.append((String)localObject1);
        paramString.append("/");
        return paramString.toString();
      }
      if (paramString.startsWith("http://"))
      {
        if ((this.isIpv6) && (!this.mIp.startsWith("[")))
        {
          paramString = new StringBuilder();
          paramString.append("http://[");
          paramString.append(this.mIp);
          paramString.append("]");
          localObject1 = paramString.toString();
        }
        else
        {
          paramString = new StringBuilder();
          paramString.append("http://");
          paramString.append(this.mIp);
          localObject1 = paramString.toString();
        }
      }
      else
      {
        localObject1 = localObject2;
        if (paramString.startsWith("https://")) {
          if ((this.isIpv6) && (!this.mIp.startsWith("[")))
          {
            paramString = new StringBuilder();
            paramString.append("https://[");
            paramString.append(this.mIp);
            paramString.append("]");
            localObject1 = paramString.toString();
          }
          else
          {
            paramString = new StringBuilder();
            paramString.append("https://");
            paramString.append(this.mIp);
            localObject1 = paramString.toString();
          }
        }
      }
      if (this.port != 80)
      {
        paramString = new StringBuilder();
        paramString.append((String)localObject1);
        paramString.append(":");
        paramString.append(this.port);
        paramString.append("/");
        return paramString.toString();
      }
      paramString = new StringBuilder();
      paramString.append((String)localObject1);
      paramString.append("/");
      return paramString.toString();
    }
    return null;
  }
  
  public void onFail() {}
  
  public void onSuccess() {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mIp);
    localStringBuilder.append(":");
    localStringBuilder.append(this.port);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ServerAddr
 * JD-Core Version:    0.7.0.1
 */