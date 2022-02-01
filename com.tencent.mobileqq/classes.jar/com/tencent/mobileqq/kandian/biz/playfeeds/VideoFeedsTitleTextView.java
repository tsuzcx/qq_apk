package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsTitleTextView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsTitleTextView
  extends TextView
{
  public static final VideoFeedsTitleTextView.Companion a = new VideoFeedsTitleTextView.Companion(null);
  
  @JvmOverloads
  public VideoFeedsTitleTextView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public VideoFeedsTitleTextView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public VideoFeedsTitleTextView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMeasure: text=");
      ((StringBuilder)localObject).append(getText());
      ((StringBuilder)localObject).append(", type=");
      ((StringBuilder)localObject).append(getText().getClass());
      QLog.d("VideoFeedsTitleTextView", 2, ((StringBuilder)localObject).toString());
    }
    paramInt1 = TextViewCompat.getMaxLines((TextView)this);
    if (getLineCount() > paramInt1)
    {
      paramInt1 = getLayout().getLineVisibleEnd(paramInt1 - 1);
      localObject = getText();
      if ((localObject instanceof SpannableStringBuilder))
      {
        SpannableStringBuilder localSpannableStringBuilder = (SpannableStringBuilder)localObject;
        localSpannableStringBuilder.delete(paramInt1 - 1, ((CharSequence)localObject).length());
        setText((CharSequence)localSpannableStringBuilder.append((CharSequence)"…"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsTitleTextView
 * JD-Core Version:    0.7.0.1
 */