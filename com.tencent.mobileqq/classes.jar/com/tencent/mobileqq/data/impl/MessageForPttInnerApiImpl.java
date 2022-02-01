package com.tencent.mobileqq.data.impl;

import com.tencent.mobileqq.data.IMessageForPttInnerApi;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class MessageForPttInnerApiImpl
  implements IMessageForPttInnerApi
{
  public String getLocalFilePath(int paramInt, String paramString)
  {
    Object localObject = paramString;
    if (paramInt == 1)
    {
      localObject = paramString;
      if (paramString.endsWith(".amr"))
      {
        paramString = paramString.substring(0, paramString.length() - 4);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(".slk");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return RmVFSUtils.getVFSPath((String)localObject, true);
  }
  
  public String getMsgFilePath(int paramInt, String paramString)
  {
    Object localObject = paramString;
    if (paramInt == 1)
    {
      localObject = paramString;
      if (paramString.endsWith(".slk"))
      {
        paramString = paramString.substring(0, paramString.length() - 4);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(".amr");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  public String getSummaryMsg(String paramString, int paramInt)
  {
    if (hasSttTxt(paramString, paramInt))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(BaseApplication.getContext().getString(2131691288));
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    return BaseApplication.getContext().getString(2131691288);
  }
  
  public String getTmpFilePath(String paramString)
  {
    Object localObject = paramString;
    if (paramString.endsWith(".slk"))
    {
      paramString = paramString.substring(0, paramString.length() - 4);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".tmp");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public boolean hasSttTxt(String paramString, int paramInt)
  {
    return (!StringUtil.a(paramString)) && (!BaseApplication.getContext().getString(2131719266).equals(paramString)) && (paramInt != 3);
  }
  
  public boolean isReady(int paramInt)
  {
    return (paramInt > 0) || (paramInt == -3) || (paramInt == -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.impl.MessageForPttInnerApiImpl
 * JD-Core Version:    0.7.0.1
 */