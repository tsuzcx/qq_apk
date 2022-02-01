package com.tencent.mobileqq.kandian.biz.pts.ui;

import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/ui/PTSNodeVideo;", "Lcom/tencent/pts/ui/vnode/PTSNodeVirtual;", "appInstance", "Lcom/tencent/pts/core/PTSAppInstance;", "(Lcom/tencent/pts/core/PTSAppInstance;)V", "setAttribute", "", "key", "", "value", "", "Builder", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PTSNodeVideo
  extends PTSNodeVirtual
{
  public static final PTSNodeVideo.Companion Companion = new PTSNodeVideo.Companion(null);
  @NotNull
  public static final String VIDEO_TAG = "PTSNodeVideo";
  
  public PTSNodeVideo(@Nullable PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance, "view", "qq-rij-video");
  }
  
  protected boolean setAttribute(@Nullable String paramString, @Nullable Object paramObject)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("key:");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(",value:");
    ((StringBuilder)localObject1).append(paramObject);
    QLog.d("PTSNodeVideo", 1, ((StringBuilder)localObject1).toString());
    localObject1 = getView();
    if (localObject1 != null)
    {
      localObject1 = (PTSVideoView)localObject1;
      if (paramString != null)
      {
        Object localObject3;
        Object localObject2;
        switch (paramString.hashCode())
        {
        default: 
          break;
        case 1784527364: 
          if (paramString.equals("pts-video:report-json")) {
            ((PTSVideoView)localObject1).setReportR5(String.valueOf(paramObject));
          }
          break;
        case 1780884992: 
          if (paramString.equals("pts-video:video-url")) {
            ((PTSVideoView)localObject1).setVideoUrl(String.valueOf(paramObject));
          }
          break;
        case 1756581053: 
          if (paramString.equals("pts-video:video-id-type"))
          {
            localObject3 = StringsKt.split$default((CharSequence)String.valueOf(paramObject), new String[] { " " }, false, 0, 6, null);
            if (((List)localObject3).size() == 2)
            {
              localObject2 = (String)((List)localObject3).get(0);
              localObject3 = (String)((List)localObject3).get(1);
              ((PTSVideoView)localObject1).setVideoVid((String)localObject2);
              localObject2 = StringsKt.toIntOrNull((String)localObject3);
              if (localObject2 != null) {
                ((PTSVideoView)localObject1).setVideoBusiType(((Number)localObject2).intValue());
              }
            }
          }
          break;
        case 1491449881: 
          if (paramString.equals("pts-video:will-repeat")) {
            ((PTSVideoView)localObject1).setLoop(Intrinsics.areEqual("true", String.valueOf(paramObject)));
          }
          break;
        case 608867309: 
          if (paramString.equals("pts-video:auto-play-percent")) {
            QLog.d("PTSNodeVideo", 1, "auto-play-percent not supported!");
          }
          break;
        case 585958230: 
          if (paramString.equals("pts-video:mute")) {
            ((PTSVideoView)localObject1).setMute(Intrinsics.areEqual("true", String.valueOf(paramObject)));
          }
          break;
        case -987548232: 
          if (paramString.equals("pts-video:icon-size"))
          {
            localObject2 = StringsKt.split$default((CharSequence)String.valueOf(paramObject), new String[] { " " }, false, 0, 6, null);
            if (((List)localObject2).size() == 2)
            {
              localObject3 = StringsKt.toIntOrNull((String)((List)localObject2).get(0));
              int i;
              if (localObject3 != null) {
                i = ((Number)localObject3).intValue();
              } else {
                i = -1;
              }
              localObject2 = StringsKt.toIntOrNull((String)((List)localObject2).get(1));
              int j;
              if (localObject2 != null) {
                j = ((Number)localObject2).intValue();
              } else {
                j = -1;
              }
              if ((i != -1) && (j != -1))
              {
                ((PTSVideoView)localObject1).setPlayIconSize(i, j);
                ((PTSVideoView)localObject1).setPlayIconVisible(true);
              }
            }
          }
          break;
        case -1278780200: 
          if (paramString.equals("pts-video:icon-url")) {
            ((PTSVideoView)localObject1).setPlayIconUrl(String.valueOf(paramObject));
          }
          break;
        case -1379994278: 
          if (paramString.equals("pts-video:scale-type"))
          {
            localObject2 = StringsKt.toIntOrNull(String.valueOf(paramObject));
            if (localObject2 != null) {
              ((PTSVideoView)localObject1).setScaleType(((Number)localObject2).intValue());
            }
          }
          break;
        case -1474806401: 
          if (paramString.equals("pts-video:play-mode"))
          {
            localObject2 = StringsKt.toIntOrNull(String.valueOf(paramObject));
            if (localObject2 != null) {
              ((PTSVideoView)localObject1).setPlayMode(((Number)localObject2).intValue());
            }
          }
          break;
        case -1867290820: 
          if (paramString.equals("pts-video:cover-url")) {
            ((PTSVideoView)localObject1).setCoverUrl(String.valueOf(paramObject));
          }
          break;
        case -1973458181: 
          if (paramString.equals("pts-video:auto-play-mode"))
          {
            localObject2 = StringsKt.toIntOrNull(String.valueOf(paramObject));
            if (localObject2 != null) {
              ((PTSVideoView)localObject1).setPlayMode(((Number)localObject2).intValue());
            }
          }
          break;
        }
      }
      return super.setAttribute(paramString, paramObject);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.pts.ui.PTSVideoView");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeVideo
 * JD-Core Version:    0.7.0.1
 */