package com.tencent.mobileqq.kandian.biz.pts.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.gif.GifView;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.view.IView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/ui/PTSGifView;", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/gif/GifView;", "Lcom/tencent/pts/ui/view/IView;", "ptsNodeGif", "Lcom/tencent/mobileqq/kandian/biz/pts/ui/PTSNodeGif;", "(Lcom/tencent/mobileqq/kandian/biz/pts/ui/PTSNodeGif;)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onBindNodeInfo", "", "p0", "Lcom/tencent/pts/ui/PTSNodeInfo;", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PTSGifView
  extends GifView
  implements IView
{
  public static final PTSGifView.Companion Companion = new PTSGifView.Companion(null);
  @NotNull
  public static final String TAG = "PTSGifView";
  
  public PTSGifView(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  public PTSGifView(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PTSGifView(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public PTSGifView(@NotNull PTSNodeGif paramPTSNodeGif)
  {
    this(paramPTSNodeGif);
  }
  
  public void onBindNodeInfo(@Nullable PTSNodeInfo paramPTSNodeInfo)
  {
    QLog.d("PTSGifView", 1, new Object[] { paramPTSNodeInfo });
    displayGif();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.ui.PTSGifView
 * JD-Core Version:    0.7.0.1
 */