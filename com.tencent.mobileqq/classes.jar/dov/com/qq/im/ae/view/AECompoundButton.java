package dov.com.qq.im.ae.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.R.styleable;

public class AECompoundButton
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private int b;
  
  public AECompoundButton(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AECompoundButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AECompoundButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    b(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2131558503, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369664));
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  private void b(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {}
    do
    {
      return;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AECompoundButton);
    } while (paramContext == null);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(1);
    this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(2, 0);
    this.b = paramContext.getDimensionPixelSize(0, 0);
    paramContext.recycle();
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_Int != 0) && (this.b != 0))
    {
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.width = this.jdField_a_of_type_Int;
      localLayoutParams.height = this.b;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setForegroundAndBackgroundResource(@DrawableRes int paramInt1, @DrawableRes int paramInt2)
  {
    setForegroundResource(paramInt1);
    setBackgroundResource(paramInt2);
  }
  
  public void setForegroundResource(@DrawableRes int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    }
  }
  
  public void setForegroundSize(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.view.AECompoundButton
 * JD-Core Version:    0.7.0.1
 */