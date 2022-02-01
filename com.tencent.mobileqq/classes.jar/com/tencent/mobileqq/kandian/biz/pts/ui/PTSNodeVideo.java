package com.tencent.mobileqq.kandian.biz.pts.ui;

import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/ui/PTSNodeVideo;", "Lcom/tencent/pts/ui/vnode/PTSNodeVirtual;", "Lcom/tencent/mobileqq/kandian/biz/pts/ui/PTSVideoView;", "appInstance", "Lcom/tencent/pts/core/PTSAppInstance;", "(Lcom/tencent/pts/core/PTSAppInstance;)V", "setAttribute", "", "key", "", "value", "", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PTSNodeVideo
  extends PTSNodeVirtual<PTSVideoView>
{
  public static final PTSNodeVideo.Companion Companion = new PTSNodeVideo.Companion(null);
  @NotNull
  public static final String VIDEO_TAG = "PTSNodeVideo";
  
  public PTSNodeVideo(@NotNull PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance);
  }
  
  protected boolean setAttribute(@Nullable String paramString, @Nullable Object paramObject)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("key:");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(",value:");
    ((StringBuilder)localObject1).append(paramObject);
    QLog.d("PTSNodeVideo", 1, ((StringBuilder)localObject1).toString());
    if (paramString != null)
    {
      Object localObject2;
      int i;
      switch (paramString.hashCode())
      {
      default: 
        break;
      case 1784527364: 
        if (paramString.equals("pts-video:report-json")) {
          ((PTSVideoView)getView()).setReportR5(String.valueOf(paramObject));
        }
        break;
      case 1780884992: 
        if (paramString.equals("pts-video:video-url")) {
          ((PTSVideoView)getView()).setVideoUrl(String.valueOf(paramObject));
        }
        break;
      case 1756581053: 
        if (paramString.equals("pts-video:video-id-type"))
        {
          localObject2 = StringsKt.split$default((CharSequence)String.valueOf(paramObject), new String[] { " " }, false, 0, 6, null);
          if (((List)localObject2).size() == 2)
          {
            localObject1 = (String)((List)localObject2).get(0);
            localObject2 = (String)((List)localObject2).get(1);
            PTSVideoView localPTSVideoView = (PTSVideoView)getView();
            Intrinsics.checkExpressionValueIsNotNull(localPTSVideoView, "view");
            localPTSVideoView.setVideoVid((String)localObject1);
            localObject1 = StringsKt.toIntOrNull((String)localObject2);
            if (localObject1 != null)
            {
              i = ((Number)localObject1).intValue();
              ((PTSVideoView)getView()).setVideoBusiType(i);
            }
          }
        }
        break;
      case 1491449881: 
        if (paramString.equals("pts-video:will-repeat")) {
          ((PTSVideoView)getView()).setLoop(Intrinsics.areEqual("true", String.valueOf(paramObject)));
        }
        break;
      case 608867309: 
        if (paramString.equals("pts-video:auto-play-percent")) {
          QLog.d("PTSNodeVideo", 1, "auto-play-percent not supported!");
        }
        break;
      case 585958230: 
        if (paramString.equals("pts-video:mute"))
        {
          localObject1 = (PTSVideoView)getView();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "view");
          ((PTSVideoView)localObject1).setMute(Intrinsics.areEqual("true", String.valueOf(paramObject)));
        }
        break;
      case -987548232: 
        if (paramString.equals("pts-video:icon-size"))
        {
          localObject1 = StringsKt.split$default((CharSequence)String.valueOf(paramObject), new String[] { " " }, false, 0, 6, null);
          if (((List)localObject1).size() == 2)
          {
            localObject2 = StringsKt.toIntOrNull((String)((List)localObject1).get(0));
            if (localObject2 != null) {
              i = ((Number)localObject2).intValue();
            } else {
              i = -1;
            }
            localObject1 = StringsKt.toIntOrNull((String)((List)localObject1).get(1));
            int j;
            if (localObject1 != null) {
              j = ((Number)localObject1).intValue();
            } else {
              j = -1;
            }
            if ((i != -1) && (j != -1))
            {
              ((PTSVideoView)getView()).setPlayIconSize(i, j);
              ((PTSVideoView)getView()).setPlayIconVisible(true);
            }
          }
        }
        break;
      case -1278780200: 
        if (paramString.equals("pts-video:icon-url")) {
          ((PTSVideoView)getView()).setPlayIconUrl(String.valueOf(paramObject));
        }
        break;
      case -1379994278: 
        if (paramString.equals("pts-video:scale-type"))
        {
          localObject1 = StringsKt.toIntOrNull(String.valueOf(paramObject));
          if (localObject1 != null)
          {
            i = ((Number)localObject1).intValue();
            ((PTSVideoView)getView()).setScaleType(i);
          }
        }
        break;
      case -1474806401: 
        if (paramString.equals("pts-video:play-mode"))
        {
          localObject1 = StringsKt.toIntOrNull(String.valueOf(paramObject));
          if (localObject1 != null)
          {
            i = ((Number)localObject1).intValue();
            localObject1 = (PTSVideoView)getView();
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "view");
            ((PTSVideoView)localObject1).setPlayMode(i);
          }
        }
        break;
      case -1867290820: 
        if (paramString.equals("pts-video:cover-url")) {
          ((PTSVideoView)getView()).setCoverUrl(String.valueOf(paramObject));
        }
        break;
      case -1973458181: 
        if (paramString.equals("pts-video:auto-play-mode"))
        {
          localObject1 = StringsKt.toIntOrNull(String.valueOf(paramObject));
          if (localObject1 != null)
          {
            i = ((Number)localObject1).intValue();
            localObject1 = (PTSVideoView)getView();
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "view");
            ((PTSVideoView)localObject1).setPlayMode(i);
          }
        }
        break;
      }
    }
    return super.setAttribute(paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeVideo
 * JD-Core Version:    0.7.0.1
 */