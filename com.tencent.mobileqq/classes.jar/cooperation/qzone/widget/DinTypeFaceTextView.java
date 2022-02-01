package cooperation.qzone.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class DinTypeFaceTextView
  extends TextView
{
  static Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  static boolean jdField_a_of_type_Boolean;
  
  public DinTypeFaceTextView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public DinTypeFaceTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public DinTypeFaceTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    if (jdField_a_of_type_AndroidGraphicsTypeface == null) {
      b();
    }
    if (jdField_a_of_type_AndroidGraphicsTypeface != null) {
      setTypeface(jdField_a_of_type_AndroidGraphicsTypeface);
    }
  }
  
  private void b()
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromAsset(getResources().getAssets(), "qzone_din.ttf");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DinTypeFaceTextView", 1, "", localThrowable);
      return;
    }
    finally
    {
      jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.widget.DinTypeFaceTextView
 * JD-Core Version:    0.7.0.1
 */