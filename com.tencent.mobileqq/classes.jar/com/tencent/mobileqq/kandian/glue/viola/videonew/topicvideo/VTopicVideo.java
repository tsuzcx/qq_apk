package com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.kandian.biz.viola.video.VVideoInit;
import com.tencent.mobileqq.kandian.glue.viola.videonew.VVideo;
import com.tencent.mobileqq.kandian.glue.viola.videonew.VVideoView;
import com.tencent.mobileqq.kandian.glue.viola.videonew.VVideoView.OnVideoViewControlListener;
import com.tencent.mobileqq.kandian.glue.viola.videonew.VVideoView.OnVideoViewLifeCycleChangeListener;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.dispatch.IObserver;
import com.tencent.viola.core.dispatch.ViolaDispatchManager;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class VTopicVideo
  extends VVideo
{
  private static final int TOPIC_VIDEO_CONTROL_PAUSE = 3;
  private static final int TOPIC_VIDEO_CONTROL_PERPLAY = 1;
  private static final int TOPIC_VIDEO_CONTROL_PLAY = 2;
  private static final int TOPIC_VIDEO_CONTROL_REPLAY = 5;
  private static final int TOPIC_VIDEO_CONTROL_STOP = 4;
  private IObserver mVideoAppearEventObserver = new VTopicVideo.1(this);
  
  public VTopicVideo(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  public void destroy()
  {
    super.destroy();
    if (this.mVideoAppearEventObserver != null) {
      ViolaDispatchManager.getInstance().removeObserver("EVENT_NAME_COMPONENT_APPEAR", this.mVideoAppearEventObserver);
    }
  }
  
  public VVideoView.OnVideoViewLifeCycleChangeListener getVideoLifeCycleChangeListener()
  {
    if ((getHostView() != null) && (((VVideoView)getHostView()).a() != null)) {
      return ((VVideoView)getHostView()).a();
    }
    return null;
  }
  
  protected VVideoView initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VVideoView(paramContext, this);
    paramContext.a(this);
    paramContext.a = 2;
    paramContext.a(0, 0, null, true);
    try
    {
      if (getDomObject().getAttributes() != null)
      {
        Iterator localIterator = getDomObject().getAttributes().entrySet().iterator();
        JSONObject localJSONObject = VVideoInit.a();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          String str = (String)localEntry.getKey();
          if ("src".equals(str)) {
            localJSONObject.put("video_info", localEntry.getValue());
          } else if ("timeInterval".equals(str)) {
            localJSONObject.put("timeupdateRate", localEntry.getValue());
          } else if ("autoPlay".equals(str)) {
            localJSONObject.put("autoplay", localEntry.getValue());
          } else {
            localJSONObject.put(str, localEntry.getValue());
          }
        }
        paramContext.a().a(paramContext, localJSONObject);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    ViolaDispatchManager.getInstance().addObserver("EVENT_NAME_COMPONENT_APPEAR", this.mVideoAppearEventObserver);
    return paramContext;
  }
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
    if (this.mVideoAppearEventObserver != null) {
      ViolaDispatchManager.getInstance().removeObserver("EVENT_NAME_COMPONENT_APPEAR", this.mVideoAppearEventObserver);
    }
  }
  
  @VComponentProp(name="controlAction")
  public void setcontrolAction(int paramInt)
  {
    if (getVideoViewControlListener() != null)
    {
      if (paramInt == 1)
      {
        getVideoViewControlListener().a((VVideoView)getHostView());
        return;
      }
      if (paramInt == 2)
      {
        getVideoViewControlListener().b((VVideoView)getHostView());
        return;
      }
      if (paramInt == 3)
      {
        getVideoViewControlListener().c((VVideoView)getHostView());
        return;
      }
      if (paramInt == 4)
      {
        getVideoViewControlListener().d((VVideoView)getHostView());
        return;
      }
      if (paramInt == 5) {
        getVideoViewControlListener().e((VVideoView)getHostView());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo.VTopicVideo
 * JD-Core Version:    0.7.0.1
 */