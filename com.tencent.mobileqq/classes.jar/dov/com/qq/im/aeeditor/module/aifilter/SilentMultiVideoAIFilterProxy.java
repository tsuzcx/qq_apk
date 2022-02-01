package dov.com.qq.im.aeeditor.module.aifilter;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavcut.session.TAVCutVideoSession;
import java.util.List;
import mqq.os.MqqHandler;

public class SilentMultiVideoAIFilterProxy
  extends SilentVideoAIFilterProxy
{
  public SilentMultiVideoAIFilterProxy(TAVCutVideoSession paramTAVCutVideoSession)
  {
    super(paramTAVCutVideoSession);
  }
  
  protected void a(Context paramContext, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback)
  {
    List localList = a();
    ThreadManager.getSubThreadHandler().post(new SilentMultiVideoAIFilterProxy.1(this, localList, paramContext, paramAIFilterProxyCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.SilentMultiVideoAIFilterProxy
 * JD-Core Version:    0.7.0.1
 */