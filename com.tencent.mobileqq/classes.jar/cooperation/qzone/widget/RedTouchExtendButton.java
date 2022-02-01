package cooperation.qzone.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
  private int realRedSizePix = dipToPixels(10);
  private int redImageSizePix = dipToPixels(24);
  private int redPointSizePix = dipToPixels(10);
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
        this.currentDrawable = getResources().getDrawable(2130850321);
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
        localObject2 = getResources().getDrawable(2130850321);
        ((Drawable)localObject2).getBounds();
        ((Drawable)localObject2).setBounds(j, k, localRect.right, localRect.bottom);
        ((Drawable)localObject2).draw(paramCanvas);
        localPaint.setColor(-1);
        paramCanvas.drawText((String)localObject1, localRect.left + localRect.width() / 2, f1 - f2, localPaint);
      }
      if (this.redType == 3)
      {
        localObject1 = getResources().getDrawable(2130848413);
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
  
  protected Bitmap getIconFromFile(File paramFile)
  {
    try
    {
      paramFile = new BitmapDrawable(new FileInputStream(paramFile)).getBitmap();
      return paramFile;
    }
    catch (FileNotFoundException paramFile)
    {
      paramFile.printStackTrace();
      return null;
    }
    catch (OutOfMemoryError paramFile)
    {
      paramFile.printStackTrace();
    }
    return null;
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