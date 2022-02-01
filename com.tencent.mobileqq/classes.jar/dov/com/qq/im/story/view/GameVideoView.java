package dov.com.qq.im.story.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.BubbleVideoView;

public class GameVideoView
  extends BubbleVideoView
{
  public Drawable a;
  
  public GameVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GameVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GameVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if (this.a != paramDrawable)
    {
      this.a = paramDrawable;
      super.setImageDrawable(paramDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.story.view.GameVideoView
 * JD-Core Version:    0.7.0.1
 */