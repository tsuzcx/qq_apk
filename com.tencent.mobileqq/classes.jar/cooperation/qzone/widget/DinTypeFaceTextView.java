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
  private static final String TAG = "DinTypeFaceTextView";
  static Typeface dinTypeface;
  static boolean loadTypeFaced;
  
  public DinTypeFaceTextView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public DinTypeFaceTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public DinTypeFaceTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    if (dinTypeface == null) {
      loadTypeFace();
    }
    if (dinTypeface != null) {
      setTypeface(dinTypeface);
    }
  }
  
  private void loadTypeFace()
  {
    if (loadTypeFaced) {
      return;
    }
    try
    {
      dinTypeface = Typeface.createFromAsset(getResources().getAssets(), "qzone_din.ttf");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DinTypeFaceTextView", 1, "", localThrowable);
      return;
    }
    finally
    {
      loadTypeFaced = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.widget.DinTypeFaceTextView
 * JD-Core Version:    0.7.0.1
 */