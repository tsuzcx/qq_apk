package dov.com.qq.im.capture.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

public class StoryTextToastView
  extends StoryToastView
{
  private TextView a;
  private TextView b;
  
  public StoryTextToastView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StoryTextToastView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StoryTextToastView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131560999, this, true);
    this.a = ((TextView)findViewById(2131379619));
    this.b = ((TextView)findViewById(2131379620));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.capture.view.StoryTextToastView
 * JD-Core Version:    0.7.0.1
 */