package dov.com.tencent.mobileqq.richmedia;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import dov.com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import java.util.concurrent.ConcurrentHashMap;

public class VideoCompoundController
{
  public ConcurrentHashMap a = new ConcurrentHashMap(10);
  
  public CompoundProcessor a(SVHwEncoder paramSVHwEncoder, SessionInfo paramSessionInfo, int paramInt)
  {
    paramSVHwEncoder = new CompoundProcessor(paramSVHwEncoder, paramSessionInfo, paramInt);
    this.a.put(paramSVHwEncoder.a, paramSVHwEncoder);
    LOG.a("VideoCompoundController", "newProcessor, key = " + paramSVHwEncoder.a);
    return paramSVHwEncoder;
  }
  
  public CompoundProcessor a(String paramString)
  {
    LOG.a("VideoCompoundController", "findProcessor, key = " + paramString);
    if ((!this.a.isEmpty()) && (paramString != null) && (this.a.containsKey(paramString))) {
      return (CompoundProcessor)this.a.get(paramString);
    }
    return null;
  }
  
  public boolean a(String paramString)
  {
    LOG.a("VideoCompoundController", "removeProcessor, key = " + paramString);
    if (paramString == null) {}
    while (this.a.remove(paramString) == null) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.VideoCompoundController
 * JD-Core Version:    0.7.0.1
 */