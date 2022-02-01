package com.tencent.mobileqq.kandian.biz.pts.ui;

import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/ui/PTSNodeGif;", "Lcom/tencent/pts/ui/vnode/PTSNodeVirtual;", "appInstance", "Lcom/tencent/pts/core/PTSAppInstance;", "(Lcom/tencent/pts/core/PTSAppInstance;)V", "setAttribute", "", "key", "", "value", "", "Builder", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PTSNodeGif
  extends PTSNodeVirtual
{
  public static final PTSNodeGif.Companion Companion = new PTSNodeGif.Companion(null);
  @NotNull
  public static final String VIDEO_TAG = "PTSNodeGif";
  
  public PTSNodeGif(@Nullable PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance, "view", "qq-rij-gif");
  }
  
  protected boolean setAttribute(@Nullable String paramString, @Nullable Object paramObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",value:");
    ((StringBuilder)localObject).append(paramObject);
    QLog.d("PTSNodeGif", 1, ((StringBuilder)localObject).toString());
    if (paramString != null) {
      switch (paramString.hashCode())
      {
      default: 
        break;
      case 1149179075: 
        if (paramString.equals("pts-gif:need-gif-url"))
        {
          localObject = getView();
          if (localObject != null) {
            ((PTSGifView)localObject).setNeedGifUrl(Intrinsics.areEqual("true", String.valueOf(paramObject)));
          } else {
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.pts.ui.PTSGifView");
          }
        }
        break;
      case -545139630: 
        if (paramString.equals("pts-gif:gif-url"))
        {
          localObject = getView();
          if (localObject != null) {
            ((PTSGifView)localObject).setGifUrl(String.valueOf(paramObject));
          } else {
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.pts.ui.PTSGifView");
          }
        }
        break;
      case -767755323: 
        if (paramString.equals("pts-gif:cover-url"))
        {
          localObject = getView();
          if (localObject != null) {
            ((PTSGifView)localObject).setCoverUrl(String.valueOf(paramObject));
          } else {
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.pts.ui.PTSGifView");
          }
        }
        break;
      case -1654132239: 
        if (paramString.equals("pts-gif:scale-type"))
        {
          localObject = StringsKt.toIntOrNull(String.valueOf(paramObject));
          if (localObject != null)
          {
            int i = ((Number)localObject).intValue();
            localObject = getView();
            if (localObject != null) {
              ((PTSGifView)localObject).setScaleType(i);
            } else {
              throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.pts.ui.PTSGifView");
            }
          }
        }
        break;
      }
    }
    return super.setAttribute(paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeGif
 * JD-Core Version:    0.7.0.1
 */