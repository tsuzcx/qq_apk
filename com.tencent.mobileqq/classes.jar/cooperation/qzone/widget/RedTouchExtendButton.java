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
        this.currentDrawable = getResources().getDrawable(2130850830);
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
        localObject2 = getResources().getDrawable(2130850830);
        ((Drawable)localObject2).getBounds();
        ((Drawable)localObject2).setBounds(j, k, localRect.right, localRect.bottom);
        ((Drawable)localObject2).draw(paramCanvas);
        localPaint.setColor(-1);
        paramCanvas.drawText((String)localObject1, localRect.left + localRect.width() / 2, f1 - f2, localPaint);
      }
      if (this.redType == 3)
      {
        localObject1 = getResources().getDrawable(2130848885);
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
    if ((paramObject1 == null) && (paramObject2 == null)) {}
    while ((paramObject1 != null) && (paramObject1.equals(paramObject2))) {
      return true;
    }
    return false;
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (getDrawableViewHeight() >= this.redImageSizePix)
    {
      bool1 = bool2;
      if (getDrawableViewWidth() >= this.redImageSizePix + dipToPixels(2)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean isSupportRedPoint()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (getDrawableViewHeight() >= this.redPointSizePix)
    {
      bool1 = bool2;
      if (getDrawableViewWidth() + dipToPixels(2) >= this.redPointSizePix) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean isSupportRedText(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return false;
      TextPaint localTextPaint = new TextPaint();
      localTextPaint.setTextSize(dipToPixels(11));
      i = (int)localTextPaint.measureText(paramString);
      paramString = localTextPaint.getFontMetrics();
      i = Math.max(i, (int)(paramString.bottom - paramString.top));
    } while (getDrawableViewWidth() < i + dipToPixels(0) * 2 + dipToPixels(2));
    return true;
  }
  
  private boolean isSupportRedTouch(RedTouchExtendButton.RedInfo paramRedInfo)
  {
    if (paramRedInfo == null) {}
    do
    {
      do
      {
        return false;
      } while (!paramRedInfo.isNew);
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
    } while (paramRedInfo.redType != 0);
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
    //   29: ifnull +9 -> 38
    //   32: aload_2
    //   33: invokevirtual 291	java/io/FileInputStream:close	()V
    //   36: aload_3
    //   37: astore_1
    //   38: aload_1
    //   39: areturn
    //   40: astore_1
    //   41: aload_1
    //   42: invokevirtual 294	java/io/IOException:printStackTrace	()V
    //   45: aload_3
    //   46: areturn
    //   47: astore_3
    //   48: aconst_null
    //   49: astore_2
    //   50: aload_2
    //   51: astore_1
    //   52: aload_3
    //   53: invokevirtual 295	java/io/FileNotFoundException:printStackTrace	()V
    //   56: aload 4
    //   58: astore_1
    //   59: aload_2
    //   60: ifnull -22 -> 38
    //   63: aload_2
    //   64: invokevirtual 291	java/io/FileInputStream:close	()V
    //   67: aconst_null
    //   68: areturn
    //   69: astore_1
    //   70: aload_1
    //   71: invokevirtual 294	java/io/IOException:printStackTrace	()V
    //   74: aconst_null
    //   75: areturn
    //   76: astore_3
    //   77: aconst_null
    //   78: astore_2
    //   79: aload_2
    //   80: astore_1
    //   81: aload_3
    //   82: invokevirtual 296	java/lang/OutOfMemoryError:printStackTrace	()V
    //   85: aload 4
    //   87: astore_1
    //   88: aload_2
    //   89: ifnull -51 -> 38
    //   92: aload_2
    //   93: invokevirtual 291	java/io/FileInputStream:close	()V
    //   96: aconst_null
    //   97: areturn
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 294	java/io/IOException:printStackTrace	()V
    //   103: aconst_null
    //   104: areturn
    //   105: astore_2
    //   106: aconst_null
    //   107: astore_1
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 291	java/io/FileInputStream:close	()V
    //   116: aload_2
    //   117: athrow
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 294	java/io/IOException:printStackTrace	()V
    //   123: goto -7 -> 116
    //   126: astore_2
    //   127: goto -19 -> 108
    //   130: astore_3
    //   131: goto -52 -> 79
    //   134: astore_3
    //   135: goto -85 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	RedTouchExtendButton
    //   0	138	1	paramFile	java.io.File
    //   11	82	2	localFileInputStream	java.io.FileInputStream
    //   105	12	2	localObject1	Object
    //   126	1	2	localObject2	Object
    //   25	21	3	localBitmap	android.graphics.Bitmap
    //   47	6	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   76	6	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   130	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   134	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	85	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   32	36	40	java/io/IOException
    //   3	12	47	java/io/FileNotFoundException
    //   63	67	69	java/io/IOException
    //   3	12	76	java/lang/OutOfMemoryError
    //   92	96	98	java/io/IOException
    //   3	12	105	finally
    //   112	116	118	java/io/IOException
    //   14	26	126	finally
    //   52	56	126	finally
    //   81	85	126	finally
    //   14	26	130	java/lang/OutOfMemoryError
    //   14	26	134	java/io/FileNotFoundException
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
  
  public void onDraw(Canvas paramCanvas)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.widget.RedTouchExtendButton
 * JD-Core Version:    0.7.0.1
 */