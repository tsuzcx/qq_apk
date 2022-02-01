package com.tencent.mobileqq.kandian.glue.viola.videonew;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.viola.video.VVideoInit;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.VComponentAdapter.OnVideoViewMethodListener;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VVideo
  extends VComponentContainer<VVideoView>
{
  public static String TAG = "VVideo";
  private String mCurrentVid;
  private String mCurrentVideoUrl;
  private Boolean mIsForNV = Boolean.valueOf(false);
  private VComponentAdapter.OnVideoViewMethodListener mVideoViewMethodListener = new VVideo.1(this);
  
  public VVideo(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  private void dealFullScreen(int paramInt, boolean paramBoolean, String paramString)
  {
    ((VVideoView)getHostView()).a(0);
    getVideoViewControlListener().a(paramInt, (VVideoView)getHostView(), paramBoolean, paramString, this.mVideoViewMethodListener);
  }
  
  private void invokeJS(String paramString, Object paramObject)
  {
    ViolaBridgeManager.getInstance().callbackJavascript(this.mInstance.getInstanceId(), "kd-video", "callback", paramString, paramObject, true);
  }
  
  private boolean tryExitFullScreen()
  {
    Object localObject = getVideoViewControlListener();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (getVideoViewControlListener().a())
      {
        localObject = (VVideoView)getHostView();
        bool1 = true;
        ((VVideoView)localObject).b(1);
        getVideoViewControlListener().b((VVideoView)getHostView(), null, this.mVideoViewMethodListener);
      }
    }
    return bool1;
  }
  
  public void addEvent(String paramString)
  {
    if ((!"stateChange".equals(paramString)) && (!"playTimeChange".equals(paramString)) && (!"volumeChange".equals(paramString)) && (!"didEnterFullScreen".equals(paramString)) && (!"didExitFullScreen".equals(paramString)) && (!"stateVisible".equals(paramString)) && (!"stateHidden".equals(paramString)))
    {
      super.addEvent(paramString);
      return;
    }
    this.mAppendEvents.add(paramString);
  }
  
  public void afterBringToRootByAnim()
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().g((VVideoView)getHostView());
    }
  }
  
  public void beforeBringToRootByAnim()
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().f((VVideoView)getHostView());
    }
    if (getHostView() != null) {
      ((VVideoView)getHostView()).setBringToRootByAnim(Boolean.valueOf(true));
    }
  }
  
  public boolean consumeBackKeyEvent()
  {
    return tryExitFullScreen();
  }
  
  public void destroy()
  {
    super.destroy();
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" video destroy: ");
      localStringBuilder.append(this.mCurrentVid);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.mIsForNV.booleanValue())
    {
      if (getVideoViewControlListener() != null)
      {
        getVideoViewControlListener().g();
        getVideoViewControlListener().f();
      }
    }
    else if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().f();
    }
  }
  
  public void destroyComp()
  {
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("video destroyComp: ");
      localStringBuilder.append(this.mCurrentVid);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().g();
    }
  }
  
  @JSMethod
  public void detachVideoPlayerFromSeamless()
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().g();
    }
  }
  
  @JSMethod
  public void exitFullScreen(String paramString)
  {
    if (getVideoViewControlListener() != null)
    {
      ((VVideoView)getHostView()).b(1);
      getVideoViewControlListener().b((VVideoView)getHostView(), paramString, this.mVideoViewMethodListener);
    }
  }
  
  @JSMethod
  public void fullLandspaceScreen(String paramString)
  {
    if (getVideoViewControlListener() != null) {
      dealFullScreen(0, false, paramString);
    }
  }
  
  @JSMethod
  public void fullLandspaceScreenWithType(int paramInt, String paramString)
  {
    if (getVideoViewControlListener() != null) {
      dealFullScreen(paramInt, false, paramString);
    }
  }
  
  @JSMethod
  public void fullPortraitScreen(String paramString)
  {
    if (getVideoViewControlListener() != null) {
      dealFullScreen(0, true, paramString);
    }
  }
  
  @JSMethod
  public void getPlayInfo(String paramString)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().a((VVideoView)getHostView(), paramString, this.mVideoViewMethodListener);
    }
  }
  
  @JSMethod
  public void getVideoToken(String paramString)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().c((VVideoView)getHostView(), paramString, this.mVideoViewMethodListener);
    }
  }
  
  public VVideoView.OnVideoViewControlListener getVideoViewControlListener()
  {
    if ((getHostView() != null) && (((VVideoView)getHostView()).a() != null)) {
      return ((VVideoView)getHostView()).a();
    }
    return null;
  }
  
  protected VVideoView initComponentHostView(@NonNull Context paramContext)
  {
    VVideoView localVVideoView = new VVideoView(paramContext, this);
    localVVideoView.a(this);
    int i;
    if (getDomObject().getAttributes().containsKey("playerType")) {
      i = ((Integer)getDomObject().getAttributes().get("playerType")).intValue();
    } else {
      i = 0;
    }
    int j;
    if (getDomObject().getAttributes().containsKey("videoScreenType")) {
      j = ((Integer)getDomObject().getAttributes().get("videoScreenType")).intValue();
    } else {
      j = 100;
    }
    paramContext = null;
    if (getDomObject().getAttributes().containsKey("videoToken")) {
      paramContext = (String)getDomObject().getAttributes().get("videoToken");
    }
    boolean bool2 = true;
    Object localObject1 = Boolean.valueOf(true);
    boolean bool1;
    if (getDomObject().getAttributes().containsKey("autoAttachVideoView"))
    {
      if (((Integer)getDomObject().getAttributes().get("autoAttachVideoView")).intValue() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject1 = Boolean.valueOf(bool1);
    }
    Object localObject2 = Boolean.valueOf(false);
    if (getDomObject().getAttributes().containsKey("handAttachVideoView"))
    {
      if (((Integer)getDomObject().getAttributes().get("handAttachVideoView")).intValue() == 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localObject2 = Boolean.valueOf(bool1);
    }
    localVVideoView.a(i, j, paramContext, ((Boolean)localObject1).booleanValue(), ((Boolean)localObject2).booleanValue());
    try
    {
      if (getDomObject().getAttributes() != null)
      {
        paramContext = getDomObject().getAttributes().entrySet().iterator();
        localObject1 = VVideoInit.a();
        while (paramContext.hasNext())
        {
          localObject2 = (Map.Entry)paramContext.next();
          Object localObject3 = (String)((Map.Entry)localObject2).getKey();
          if (QLog.isColorLevel())
          {
            String str = TAG;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("initComponentHostView: key=");
            localStringBuilder.append((String)localObject3);
            localStringBuilder.append(", value=");
            localStringBuilder.append(((Map.Entry)localObject2).getValue());
            QLog.d(str, 2, localStringBuilder.toString());
          }
          if ("src".equals(localObject3))
          {
            bool1 = ((Map.Entry)localObject2).getValue() instanceof String;
            if (bool1)
            {
              localObject3 = new JSONObject();
              this.mCurrentVideoUrl = ((String)((Map.Entry)localObject2).getValue());
              ((JSONObject)localObject3).put("videoUrl", ((Map.Entry)localObject2).getValue());
              ((JSONObject)localObject1).put("video_info", localObject3);
            }
            else
            {
              if (((JSONObject)((Map.Entry)localObject2).getValue()).has("vid")) {
                this.mCurrentVid = ((JSONObject)((Map.Entry)localObject2).getValue()).getString("vid");
              }
              ((JSONObject)localObject1).put("video_info", ((Map.Entry)localObject2).getValue());
            }
          }
          else if ("timeInterval".equals(localObject3))
          {
            ((JSONObject)localObject1).put("timeupdateRate", ((Map.Entry)localObject2).getValue());
          }
          else if ("autoPlay".equals(localObject3))
          {
            ((JSONObject)localObject1).put("autoplay", ((Map.Entry)localObject2).getValue());
          }
          else
          {
            ((JSONObject)localObject1).put((String)localObject3, ((Map.Entry)localObject2).getValue());
          }
        }
        localVVideoView.a().a(localVVideoView, (JSONObject)localObject1);
        return localVVideoView;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return localVVideoView;
  }
  
  public JSONObject initCurrentVideoData()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("muted", false);
      localJSONObject.put("autoplay", true);
      localJSONObject.put("resize", "contain");
      localJSONObject.put("controlType", 0);
      localJSONObject.put("timeupdateRate", 1000);
      localJSONObject.put("disableFullScreen", false);
      if (getDomObject().getAttributes().containsKey("muted")) {
        localJSONObject.put("muted", getDomObject().getAttributes().get("muted"));
      }
      if (getDomObject().getAttributes().containsKey("autoPlay")) {
        localJSONObject.put("autoplay", getDomObject().getAttributes().get("autoPlay"));
      }
      if (getDomObject().getAttributes().containsKey("resize")) {
        localJSONObject.put("resize", getDomObject().getAttributes().get("resize"));
      }
      if (getDomObject().getAttributes().containsKey("controlType")) {
        localJSONObject.put("controlType", getDomObject().getAttributes().get("controlType"));
      }
      if (getDomObject().getAttributes().containsKey("timeInterval")) {
        localJSONObject.put("timeupdateRate", getDomObject().getAttributes().get("timeInterval"));
      }
      if (getDomObject().getAttributes().containsKey("disableFullScreen"))
      {
        localJSONObject.put("disableFullScreen", getDomObject().getAttributes().get("disableFullScreen"));
        return localJSONObject;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public boolean isReuse()
  {
    return false;
  }
  
  @JSMethod
  public void nativeVueFailed()
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().j();
    }
  }
  
  public boolean onActivityBack()
  {
    return tryExitFullScreen();
  }
  
  public void onActivityCreate()
  {
    super.onActivityCreate();
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().a();
    }
  }
  
  public void onActivityDestroy()
  {
    super.destroy();
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("video onActivityDestroy:");
      localStringBuilder.append(this.mCurrentVid);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().f();
    }
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().d();
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().c();
    }
  }
  
  public void onActivityStart()
  {
    super.onActivityStart();
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().b();
    }
  }
  
  public void onActivityStop()
  {
    super.onActivityStop();
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().e();
    }
  }
  
  @JSMethod
  public void pause()
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().c((VVideoView)getHostView());
    }
  }
  
  @JSMethod
  public void play()
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().b((VVideoView)getHostView());
    }
  }
  
  @JSMethod
  public void playFeedbackParamsWithVideoScene(String paramString)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().a(paramString, this.mVideoViewMethodListener);
    }
  }
  
  @JSMethod
  public void preplay()
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().a((VVideoView)getHostView());
    }
  }
  
  public void removedByDiff()
  {
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SuperPlayerPool removedByDiff: ");
      localStringBuilder.append(this.mCurrentVid);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().f();
    }
  }
  
  public void removedByJs()
  {
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SuperPlayerPool removedByJs: ");
      localStringBuilder.append(this.mCurrentVid);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().f();
    }
  }
  
  @JSMethod
  public void replay()
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().e((VVideoView)getHostView());
    }
  }
  
  public void resetComponent()
  {
    View localView = getHostView();
    Boolean localBoolean = Boolean.valueOf(false);
    if (localView != null)
    {
      ((VVideoView)getHostView()).setBringToRootByAnim(localBoolean);
      ((VVideoView)getHostView()).setAutoDestroy(localBoolean);
    }
    this.mIsForNV = localBoolean;
    super.resetComponent();
  }
  
  @JSMethod
  public void resetParentScaleAndRect(int paramInt1, int paramInt2)
  {
    if ((getHostView() != null) && (getInstance() != null) && (getInstance().getActivity() != null))
    {
      VideoFeedsHelper.a(getInstance().getActivity(), paramInt1, paramInt2);
      View localView = getHostView();
      while ((localView != null) && (localView.getScaleY() == 1.0F) && (localView.getScaleX() == 1.0F))
      {
        localView.getLayoutParams().height = -1;
        localView.getLayoutParams().width = -1;
        localView.setLayoutParams(localView.getLayoutParams());
        ViewParent localViewParent = localView.getParent();
        if ((localViewParent instanceof View)) {
          localView = (View)localViewParent;
        }
      }
      if (localView != null)
      {
        localView.setScaleX(1.0F);
        localView.setScaleY(1.0F);
        localView.getLayoutParams().width = -1;
        localView.getLayoutParams().height = -1;
        if ((localView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
        {
          ((ViewGroup.MarginLayoutParams)localView.getLayoutParams()).topMargin = 0;
          ((ViewGroup.MarginLayoutParams)localView.getLayoutParams()).leftMargin = 0;
          ((ViewGroup.MarginLayoutParams)localView.getLayoutParams()).rightMargin = 0;
          ((ViewGroup.MarginLayoutParams)localView.getLayoutParams()).bottomMargin = 0;
        }
        if ((localView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
          ((FrameLayout.LayoutParams)localView.getLayoutParams()).gravity = 17;
        }
        localView.setLayoutParams(localView.getLayoutParams());
        paramInt1 = VideoFeedsHelper.a(getInstance().getActivity(), paramInt1, paramInt2);
        if (paramInt1 == 2)
        {
          getVideoViewControlListener().a((VVideoView)getHostView(), "cover");
          localView.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getPaddingRight(), VideoFeedsHelper.a(getInstance().getActivity()));
          return;
        }
        if (paramInt1 == 0) {
          getVideoViewControlListener().a((VVideoView)getHostView(), "contain");
        }
      }
    }
  }
  
  @JSMethod
  public void resetSrc(Object paramObject)
  {
    if (getVideoViewControlListener() != null)
    {
      Object localObject1 = initCurrentVideoData();
      try
      {
        boolean bool = paramObject instanceof String;
        if ((bool) && (!this.mCurrentVideoUrl.equals(paramObject)))
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("videoUrl", paramObject);
          ((JSONObject)localObject1).put("video_info", localObject2);
          this.mCurrentVideoUrl = ((String)paramObject);
          getVideoViewControlListener().b((VVideoView)getHostView(), (JSONObject)localObject1);
          return;
        }
        if (((paramObject instanceof JSONObject)) && (!this.mCurrentVid.equals(((JSONObject)paramObject).getString("vid"))))
        {
          ((JSONObject)localObject1).put("video_info", paramObject);
          this.mCurrentVid = ((JSONObject)paramObject).getString("vid");
          getVideoViewControlListener().b((VVideoView)getHostView(), (JSONObject)localObject1);
          return;
        }
      }
      catch (Exception paramObject)
      {
        localObject1 = TAG;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("setSrc error :");
        ((StringBuilder)localObject2).append(paramObject.getMessage());
        ViolaLogUtils.e((String)localObject1, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  @JSMethod
  public void seamlessStart()
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().h();
    }
  }
  
  @JSMethod
  public void seek(int paramInt)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().a((VVideoView)getHostView(), paramInt * 1000);
    }
  }
  
  @VComponentProp(name="accurate")
  public void setAccurate(boolean paramBoolean)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().c(paramBoolean);
    }
  }
  
  @VComponentProp(name="autoDestroy")
  public void setAutoDestroy(Boolean paramBoolean)
  {
    if (getHostView() != null) {
      ((VVideoView)getHostView()).setAutoDestroy(paramBoolean);
    }
  }
  
  @VComponentProp(name="autoplay")
  public void setAutoPlay(boolean paramBoolean)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().b((VVideoView)getHostView(), paramBoolean);
    }
  }
  
  @VComponentProp(name="controlType")
  public void setControltype(int paramInt)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().b((VVideoView)getHostView(), paramInt);
    }
  }
  
  @VComponentProp(name="disableFullScreen")
  public void setDisableFullScreen(boolean paramBoolean)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().c((VVideoView)getHostView(), paramBoolean);
    }
  }
  
  @VComponentProp(name="endWithLastFrame")
  public void setEndWithLastFrame(boolean paramBoolean)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().g_(paramBoolean);
    }
  }
  
  public void setHostLayoutParams(VVideoView paramVVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (getHostView() == null)
    {
      super.setHostLayoutParams(paramVVideoView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
      return;
    }
    if ((((VVideoView)getHostView()).a() == 1) || (((VVideoView)getHostView()).a() == 9)) {
      super.setHostLayoutParams(paramVVideoView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    }
  }
  
  @VComponentProp(name="isForNativeVue")
  public void setIsForNativeVue(Boolean paramBoolean)
  {
    this.mIsForNV = paramBoolean;
  }
  
  @JSMethod
  public void setLoopBack(boolean paramBoolean)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().f_(paramBoolean);
    }
  }
  
  @VComponentProp(name="muted")
  public void setMuted(boolean paramBoolean)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().a((VVideoView)getHostView(), paramBoolean);
    }
  }
  
  @VComponentProp(name="rate")
  public void setRate(float paramFloat)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().a(paramFloat);
    }
  }
  
  @VComponentProp(name="resize")
  public void setResize(String paramString)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().a((VVideoView)getHostView(), paramString);
    }
  }
  
  @VComponentProp(name="timeInterval")
  public void setTimeInterval(int paramInt)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().c((VVideoView)getHostView(), paramInt);
    }
  }
  
  @VComponentProp(name="videoToken")
  public void setVideoToken(String paramString)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().a(paramString);
    }
  }
  
  @VComponentProp(name="start_position")
  public void setstartPosition(int paramInt)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().l_(paramInt);
    }
  }
  
  @JSMethod
  public void stop()
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().d((VVideoView)getHostView());
    }
  }
  
  public void videoFireEvent(String paramString, Object paramObject)
  {
    if ((!this.mAppendEvents.contains(paramString)) && (!getDomObject().getEvents().contains(paramString))) {
      return;
    }
    try
    {
      localObject = new JSONArray();
      if (getDomObject() != null)
      {
        String str = getDomObject().getRef();
        if (str != null) {
          ((JSONArray)localObject).put(str);
        }
      }
      ((JSONArray)localObject).put(paramString);
      fireEvent(paramString, localObject, paramObject);
      return;
    }
    catch (Exception paramString)
    {
      paramObject = TAG;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("videoFireEvent error :");
      ((StringBuilder)localObject).append(paramString.getMessage());
      ViolaLogUtils.e(paramObject, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.VVideo
 * JD-Core Version:    0.7.0.1
 */