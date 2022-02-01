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
  
  public StoryTextToastView a(String paramString)
  {
    this.a.setText(paramString);
    return this;
  }
  
  protected void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131560942, this, true);
    this.a = ((TextView)findViewById(2131378960));
    this.b = ((TextView)findViewById(2131378961));
  }
  
  public StoryTextToastView b(String paramString)
  {
    this.b.setText(paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.view.StoryTextToastView
 * JD-Core Version:    0.7.0.1
 */