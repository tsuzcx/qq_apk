package com.tencent.mobileqq.kandian.biz.pts.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.view.IView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/ui/PTSVideoView;", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoView;", "Lcom/tencent/pts/ui/view/IView;", "ptsNodeVideo", "Lcom/tencent/mobileqq/kandian/biz/pts/ui/PTSNodeVideo;", "(Lcom/tencent/mobileqq/kandian/biz/pts/ui/PTSNodeVideo;)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onBindNodeInfo", "", "p0", "Lcom/tencent/pts/ui/PTSNodeInfo;", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PTSVideoView
  extends VideoView
  implements IView
{
  public static final PTSVideoView.Companion Companion = new PTSVideoView.Companion(null);
  @NotNull
  public static final String TAG = "PTSVideoView";
  
  public PTSVideoView(@Nullable Context paramContext)
  {
    super(paramContext);
  }
  
  public PTSVideoView(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PTSVideoView(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public PTSVideoView(@NotNull PTSNodeVideo paramPTSNodeVideo)
  {
    this(paramPTSNodeVideo.getContext());
  }
  
  public void onBindNodeInfo(@Nullable PTSNodeInfo paramPTSNodeInfo)
  {
    QLog.d("PTSVideoView", 1, new Object[] { paramPTSNodeInfo });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.ui.PTSVideoView
 * JD-Core Version:    0.7.0.1
 */