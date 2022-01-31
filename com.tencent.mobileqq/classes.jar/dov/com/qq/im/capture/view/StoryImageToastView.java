package dov.com.qq.im.capture.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

public class StoryImageToastView
  extends StoryToastView
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public StoryImageToastView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StoryImageToastView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StoryImageToastView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public StoryImageToastView a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    return this;
  }
  
  public StoryImageToastView a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    return this;
  }
  
  protected void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131494971, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311710));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131311706));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.StoryImageToastView
 * JD-Core Version:    0.7.0.1
 */