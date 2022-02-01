package cooperation.qzone.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

public class DinTypeFaceTextView
  extends TextView
{
  private static final String TAG = "DinTypeFaceTextView";
  static Typeface dinTypeface;
  static boolean loadTypeFaced = false;
  
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
    Typeface localTypeface = dinTypeface;
    if (localTypeface != null) {
      setTypeface(localTypeface);
    }
  }
  
  /* Error */
  private void loadTypeFace()
  {
    // Byte code:
    //   0: getstatic 44	cooperation/qzone/widget/DinTypeFaceTextView:loadTypeFaced	Z
    //   3: ifeq +4 -> 7
    //   6: return
    //   7: aload_0
    //   8: invokevirtual 48	cooperation/qzone/widget/DinTypeFaceTextView:getResources	()Landroid/content/res/Resources;
    //   11: invokevirtual 54	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   14: ldc 56
    //   16: invokestatic 62	android/graphics/Typeface:createFromAsset	(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;
    //   19: putstatic 33	cooperation/qzone/widget/DinTypeFaceTextView:dinTypeface	Landroid/graphics/Typeface;
    //   22: goto +17 -> 39
    //   25: astore_1
    //   26: goto +18 -> 44
    //   29: astore_1
    //   30: ldc 8
    //   32: iconst_1
    //   33: ldc 64
    //   35: aload_1
    //   36: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   39: iconst_1
    //   40: putstatic 44	cooperation/qzone/widget/DinTypeFaceTextView:loadTypeFaced	Z
    //   43: return
    //   44: iconst_1
    //   45: putstatic 44	cooperation/qzone/widget/DinTypeFaceTextView:loadTypeFaced	Z
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	DinTypeFaceTextView
    //   25	1	1	localObject	java.lang.Object
    //   29	20	1	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   7	22	25	finally
    //   30	39	25	finally
    //   7	22	29	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.widget.DinTypeFaceTextView
 * JD-Core Version:    0.7.0.1
 */