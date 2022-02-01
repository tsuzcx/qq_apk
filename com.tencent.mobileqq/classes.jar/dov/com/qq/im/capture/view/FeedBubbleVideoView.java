package dov.com.qq.im.capture.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.BubbleImageView;

public class FeedBubbleVideoView
  extends BubbleImageView
{
  URLDrawable a;
  public URLDrawable b;
  
  public FeedBubbleVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FeedBubbleVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FeedBubbleVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable == this.a)
    {
      setURLDrawable(paramURLDrawable);
      return;
    }
    super.onLoadFialed(paramURLDrawable, paramThrowable);
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == this.a) {
      setURLDrawable(paramURLDrawable);
    }
    super.onLoadSuccessed(paramURLDrawable);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.a != null)
    {
      this.a.setURLDrawableListener(null);
      this.a = null;
    }
  }
  
  public void setURLDrawable(URLDrawable paramURLDrawable)
  {
    setImageDrawable(paramURLDrawable);
    if (this.b != paramURLDrawable) {
      this.b = paramURLDrawable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.FeedBubbleVideoView
 * JD-Core Version:    0.7.0.1
 */