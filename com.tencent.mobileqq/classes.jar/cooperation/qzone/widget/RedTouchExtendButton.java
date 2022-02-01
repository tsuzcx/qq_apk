package cooperation.qzone.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;

public class RedTouchExtendButton
  extends ExtendButton
{
  public static final int leftInterval = 2;
  public static final int redImageSizeDp = 24;
  public static final int redPointSizeDp = 10;
  public static final int redTextBgIntervalDp = 0;
  public static final int redTextSizeDp = 11;
  public static final int rightInterval = 0;
  private RedTouchExtendButton.RedInfo appInfo;
  public Drawable currentDrawable;
  public String imgUrl = "";
  private Rect mTextBounds = new Rect();
  private Handler mUiHandler;
  private int realRedSizePix = 0;
  private int redImageSizePix = 0;
  private int redPointSizePix = 0;
  private String redText = "";
  private int redType = 100;
  
  public RedTouchExtendButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedTouchExtendButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RedTouchExtendButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean checkIsEqual(RedTouchExtendButton.RedInfo paramRedInfo1, RedTouchExtendButton.RedInfo paramRedInfo2)
  {
    return equals(paramRedInfo1, paramRedInfo2);
  }
  
  private void drawRed(Canvas paramCanvas)
  {
    if (isSupportRedTouch(this.appInfo)) {}
    try
    {
      int j = getStartY() - dipToPixels(4);
      int i = getStartX() - dipToPixels(2);
      if (this.redType == 0)
      {
        this.currentDrawable = getResources().getDrawable(2130850766);
        this.currentDrawable.setBounds(i, j, this.realRedSizePix + i, this.realRedSizePix + j);
        this.currentDrawable.draw(paramCanvas);
      }
      Object localObject1;
      if (this.redType == 4)
      {
        localObject1 = this.appInfo.redText;
        Paint localPaint = new Paint(1);
        localPaint.setTextSize(dipToPixels(11));
        localPaint.setTextAlign(Paint.Align.CENTER);
        Object localObject2 = localPaint.getFontMetrics();
        j = dipToPixels(2) + i;
        int k = getHeight() / 2 - (this.realRedSizePix + dipToPixels(0) * 2) / 2;
        Rect localRect = new Rect();
        localRect.left = j;
        localRect.top = k;
        int m = this.realRedSizePix + dipToPixels(0) * 2;
        localRect.bottom = (k + m);
        localRect.right = (m + j);
        float f1 = dipToPixels(0) + k;
        float f2 = ((Paint.FontMetrics)localObject2).top;
        localObject2 = getResources().getDrawable(2130850766);
        ((Drawable)localObject2).getBounds();
        ((Drawable)localObject2).setBounds(j, k, localRect.right, localRect.bottom);
        ((Drawable)localObject2).draw(paramCanvas);
        localPaint.setColor(-1);
        paramCanvas.drawText((String)localObject1, localRect.left + localRect.width() / 2, f1 - f2, localPaint);
      }
      if (this.redType == 3)
      {
        localObject1 = getResources().getDrawable(2130848765);
        i += dipToPixels(2);
        j = getHeight() / 2 - ((Drawable)localObject1).getIntrinsicHeight() / 2;
        ((Drawable)localObject1).setBounds(i, j, ((Drawable)localObject1).getIntrinsicWidth() + i, ((Drawable)localObject1).getIntrinsicHeight() + j);
        ((Drawable)localObject1).draw(paramCanvas);
      }
      return;
    }
    catch (Exception paramCanvas) {}
  }
  
  private boolean equals(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) && (paramObject2 == null)) {
      return true;
    }
    return (paramObject1 != null) && (paramObject1.equals(paramObject2));
  }
  
  private int getDrawableViewHeight()
  {
    return getHeight();
  }
  
  private int getDrawableViewWidth()
  {
    int i = getStartX();
    return getWidth() - i - dipToPixels(0);
  }
  
  private int getStartX()
  {
    return (int)getLayout().getLineRight(0);
  }
  
  private int getStartY()
  {
    Rect localRect = new Rect();
    getLineBounds(0, localRect);
    int i = localRect.top;
    if (i > 0) {
      return i;
    }
    return 0;
  }
  
  private boolean isSupportRedImage()
  {
    return (getDrawableViewHeight() >= this.redImageSizePix) && (getDrawableViewWidth() >= this.redImageSizePix + dipToPixels(2));
  }
  
  private boolean isSupportRedPoint()
  {
    return (getDrawableViewHeight() >= this.redPointSizePix) && (getDrawableViewWidth() + dipToPixels(2) >= this.redPointSizePix);
  }
  
  private boolean isSupportRedText(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(dipToPixels(11));
    int i = (int)localTextPaint.measureText(paramString);
    paramString = localTextPaint.getFontMetrics();
    i = Math.max(i, (int)(paramString.bottom - paramString.top));
    if (getDrawableViewWidth() >= i + dipToPixels(0) * 2 + dipToPixels(2)) {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean isSupportRedTouch(RedTouchExtendButton.RedInfo paramRedInfo)
  {
    if (paramRedInfo == null) {
      return false;
    }
    if (!paramRedInfo.isNew) {
      return false;
    }
    checkIsEqual(getAppInfo(), paramRedInfo);
    if (paramRedInfo.redType == 3)
    {
      if (isSupportRedImage())
      {
        this.realRedSizePix = this.redImageSizePix;
        this.imgUrl = paramRedInfo.resUrl;
        this.redType = 3;
        return true;
      }
      if (isSupportRedPoint())
      {
        this.realRedSizePix = this.redPointSizePix;
        this.redType = 0;
        return true;
      }
      this.realRedSizePix = 0;
      this.redType = 100;
      return false;
    }
    if (paramRedInfo.redType == 4)
    {
      this.redText = paramRedInfo.redText;
      if (isSupportRedText(this.redText))
      {
        paramRedInfo = new TextPaint();
        paramRedInfo.setTextSize(dipToPixels(11));
        int i = (int)paramRedInfo.measureText(this.redText);
        paramRedInfo = paramRedInfo.getFontMetrics();
        this.realRedSizePix = Math.max(i, (int)(paramRedInfo.bottom - paramRedInfo.top));
        this.redType = 4;
        return true;
      }
      if (isSupportRedPoint())
      {
        this.realRedSizePix = this.redPointSizePix;
        this.redType = 0;
        return true;
      }
      this.realRedSizePix = 0;
      this.redType = 100;
      return false;
    }
    if (paramRedInfo.redType == 0)
    {
      if (isSupportRedPoint())
      {
        this.realRedSizePix = this.redPointSizePix;
        this.redType = 0;
        return true;
      }
      this.realRedSizePix = 0;
      this.redType = 100;
    }
    return false;
  }
  
  protected int dipToPixels(int paramInt)
  {
    Resources localResources = getResources();
    return (int)TypedValue.applyDimension(1, paramInt, localResources.getDisplayMetrics());
  }
  
  public RedTouchExtendButton.RedInfo getAppInfo()
  {
    return this.appInfo;
  }
  
  /* Error */
  protected android.graphics.Bitmap getIconFromFile(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 276	java/io/FileInputStream
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 279	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore_2
    //   12: aload_2
    //   13: astore_1
    //   14: new 281	android/graphics/drawable/BitmapDrawable
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 284	android/graphics/drawable/BitmapDrawable:<init>	(Ljava/io/InputStream;)V
    //   22: invokevirtual 288	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   25: astore_3
    //   26: aload_3
    //   27: astore_1
    //   28: aload_2
    //   29: invokevirtual 291	java/io/FileInputStream:close	()V
    //   32: aload_3
    //   33: areturn
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 294	java/io/IOException:printStackTrace	()V
    //   39: aload_1
    //   40: areturn
    //   41: astore_3
    //   42: goto +16 -> 58
    //   45: astore_3
    //   46: goto +34 -> 80
    //   49: astore_2
    //   50: aconst_null
    //   51: astore_1
    //   52: goto +48 -> 100
    //   55: astore_3
    //   56: aconst_null
    //   57: astore_2
    //   58: aload_2
    //   59: astore_1
    //   60: aload_3
    //   61: invokevirtual 295	java/lang/OutOfMemoryError:printStackTrace	()V
    //   64: aload_2
    //   65: ifnull +32 -> 97
    //   68: aload 4
    //   70: astore_1
    //   71: aload_2
    //   72: invokevirtual 291	java/io/FileInputStream:close	()V
    //   75: aconst_null
    //   76: areturn
    //   77: astore_3
    //   78: aconst_null
    //   79: astore_2
    //   80: aload_2
    //   81: astore_1
    //   82: aload_3
    //   83: invokevirtual 296	java/io/FileNotFoundException:printStackTrace	()V
    //   86: aload_2
    //   87: ifnull +10 -> 97
    //   90: aload 4
    //   92: astore_1
    //   93: aload_2
    //   94: invokevirtual 291	java/io/FileInputStream:close	()V
    //   97: aconst_null
    //   98: areturn
    //   99: astore_2
    //   100: aload_1
    //   101: ifnull +15 -> 116
    //   104: aload_1
    //   105: invokevirtual 291	java/io/FileInputStream:close	()V
    //   108: goto +8 -> 116
    //   111: astore_1
    //   112: aload_1
    //   113: invokevirtual 294	java/io/IOException:printStackTrace	()V
    //   116: aload_2
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	RedTouchExtendButton
    //   0	118	1	paramFile	java.io.File
    //   11	18	2	localFileInputStream	java.io.FileInputStream
    //   34	2	2	localIOException	java.io.IOException
    //   49	1	2	localObject1	Object
    //   57	37	2	localObject2	Object
    //   99	18	2	localObject3	Object
    //   25	8	3	localBitmap	android.graphics.Bitmap
    //   41	1	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   45	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   55	6	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   77	6	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	90	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   28	32	34	java/io/IOException
    //   71	75	34	java/io/IOException
    //   93	97	34	java/io/IOException
    //   14	26	41	java/lang/OutOfMemoryError
    //   14	26	45	java/io/FileNotFoundException
    //   3	12	49	finally
    //   3	12	55	java/lang/OutOfMemoryError
    //   3	12	77	java/io/FileNotFoundException
    //   14	26	99	finally
    //   60	64	99	finally
    //   82	86	99	finally
    //   104	108	111	java/io/IOException
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    this.currentDrawable = paramDrawable;
    invalidateOnUiThread();
  }
  
  public void invalidateOnUiThread()
  {
    if (this.mUiHandler == null) {
      this.mUiHandler = new Handler(Looper.getMainLooper());
    }
    this.mUiHandler.post(new RedTouchExtendButton.1(this));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    drawRed(paramCanvas);
    paramCanvas.restore();
  }
  
  public void setAppInfo(RedTouchExtendButton.RedInfo paramRedInfo)
  {
    this.appInfo = paramRedInfo;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.widget.RedTouchExtendButton
 * JD-Core Version:    0.7.0.1
 */