package org.xwalk.core;

import com.tencent.xweb.util.h;

class XWalkCoreWrapper$2
  extends XWalkNotifyChannelListener
{
  XWalkCoreWrapper$2(XWalkCoreWrapper paramXWalkCoreWrapper) {}
  
  public void onNotifyCallBackChannel(int paramInt, Object[] paramArrayOfObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("XWalkNotifyChannelListener called  funid = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" para size = ");
    localStringBuilder.append(paramArrayOfObject.length);
    Log.i("XWalkLib", localStringBuilder.toString());
    switch (paramInt)
    {
    default: 
      break;
    }
    try
    {
      h.a(Integer.parseInt((String)paramArrayOfObject[0]), (String)paramArrayOfObject[1]);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      break label160;
    }
    h.a(Long.parseLong((String)paramArrayOfObject[0]), Long.parseLong((String)paramArrayOfObject[1]), Integer.parseInt((String)paramArrayOfObject[2]));
    return;
    paramArrayOfObject = new StringBuilder();
    paramArrayOfObject.append("XWalkNotifyChannelListener called  funid = ");
    paramArrayOfObject.append(paramInt);
    paramArrayOfObject.append(" do not match");
    Log.i("XWalkLib", paramArrayOfObject.toString());
    return;
    label160:
    paramArrayOfObject = new StringBuilder();
    paramArrayOfObject.append("XWalkNotifyChannelListener error:");
    paramArrayOfObject.append(localStringBuilder.getLocalizedMessage());
    Log.e("XWalkLib", paramArrayOfObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkCoreWrapper.2
 * JD-Core Version:    0.7.0.1
 */