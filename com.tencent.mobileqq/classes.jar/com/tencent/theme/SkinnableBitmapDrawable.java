package com.tencent.theme;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SkinnableBitmapDrawable
  extends Drawable
{
  private static final int a = 6;
  private static final int[] k = { 16843033, 16843034, 16843035, 16843036, 16842927, 16843265 };
  private SkinnableBitmapDrawable.a b;
  private Bitmap c;
  private int d;
  private final Rect e = new Rect();
  private boolean f;
  private boolean g;
  private boolean h;
  private int i;
  private int j;
  
  SkinnableBitmapDrawable()
  {
    this.b = new SkinnableBitmapDrawable.a((Bitmap)null);
  }
  
  public SkinnableBitmapDrawable(Resources paramResources)
  {
    this.b = new SkinnableBitmapDrawable.a((Bitmap)null);
    this.b.g = this.d;
  }
  
  public SkinnableBitmapDrawable(Resources paramResources, Bitmap paramBitmap)
  {
    this(new SkinnableBitmapDrawable.a(paramBitmap), paramResources);
    this.b.g = this.d;
  }
  
  public SkinnableBitmapDrawable(Resources paramResources, InputStream paramInputStream)
  {
    this(new SkinnableBitmapDrawable.a(BitmapFactory.decodeStream(paramInputStream)), null);
    this.b.g = this.d;
    if (this.c == null)
    {
      paramResources = new StringBuilder();
      paramResources.append("BitmapDrawable cannot decode ");
      paramResources.append(paramInputStream);
      Log.w("BitmapDrawable", paramResources.toString());
    }
  }
  
  public SkinnableBitmapDrawable(Resources paramResources, String paramString)
  {
    this(new SkinnableBitmapDrawable.a(BitmapFactory.decodeFile(paramString)), null);
    this.b.g = this.d;
    if (this.c == null)
    {
      paramResources = new StringBuilder();
      paramResources.append("BitmapDrawable cannot decode ");
      paramResources.append(paramString);
      Log.w("BitmapDrawable", paramResources.toString());
    }
  }
  
  @Deprecated
  public SkinnableBitmapDrawable(Bitmap paramBitmap)
  {
    this(new SkinnableBitmapDrawable.a(paramBitmap), null);
  }
  
  SkinnableBitmapDrawable(SkinnableBitmapDrawable.a parama, Resources paramResources)
  {
    this.b = parama;
    if (paramResources != null) {
      this.d = paramResources.getDisplayMetrics().densityDpi;
    } else if (parama != null) {
      this.d = parama.g;
    } else {
      this.d = 160;
    }
    a(parama.a);
    if (parama.h)
    {
      this.g = true;
      this.f = true;
    }
  }
  
  @Deprecated
  public SkinnableBitmapDrawable(InputStream paramInputStream)
  {
    this(new SkinnableBitmapDrawable.a(BitmapFactory.decodeStream(paramInputStream)), null);
    if (this.c == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BitmapDrawable cannot decode ");
      localStringBuilder.append(paramInputStream);
      Log.w("BitmapDrawable", localStringBuilder.toString());
    }
  }
  
  @Deprecated
  public SkinnableBitmapDrawable(String paramString)
  {
    this(new SkinnableBitmapDrawable.a(BitmapFactory.decodeFile(paramString)), null);
    if (this.c == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BitmapDrawable cannot decode ");
      localStringBuilder.append(paramString);
      Log.w("BitmapDrawable", localStringBuilder.toString());
    }
  }
  
  static SkinnableBitmapDrawable.a a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet1, AttributeSet paramAttributeSet2, boolean paramBoolean)
  {
    int i1 = paramAttributeSet1.getAttributeCount();
    paramResources = new SkinnableBitmapDrawable.a((Bitmap)null);
    paramResources.h = true;
    Paint localPaint = new Paint();
    int n = 0;
    int m = 0;
    int i2;
    Object localObject1;
    while (m < i1)
    {
      i2 = paramAttributeSet1.getAttributeNameResource(m);
      if (i2 != 16842927)
      {
        if (i2 != 16843265)
        {
          switch (i2)
          {
          default: 
            break;
          case 16843036: 
            localPaint.setDither(paramAttributeSet1.getAttributeBooleanValue(m, localPaint.isDither()));
            break;
          case 16843035: 
            localPaint.setFilterBitmap(paramAttributeSet1.getAttributeBooleanValue(m, localPaint.isFilterBitmap()));
            break;
          case 16843034: 
            localPaint.setAntiAlias(paramAttributeSet1.getAttributeBooleanValue(m, localPaint.isAntiAlias()));
            break;
          case 16843033: 
            i2 = paramAttributeSet1.getAttributeResourceValue(m, 0);
            if (i2 != 0)
            {
              localObject1 = (SkinnableBitmapDrawable.a)SkinEngine.getInstances().loadConstantState(i2);
              paramResources.a = ((SkinnableBitmapDrawable.a)localObject1).a;
              paramResources.mImageSizeWhenOOM = ((SkinnableBitmapDrawable.a)localObject1).mImageSizeWhenOOM;
              break;
            }
            paramResources = new StringBuilder();
            paramResources.append(paramXmlPullParser.getPositionDescription());
            paramResources.append(": <bitmap> requires a valid src attribute");
            throw new XmlPullParserException(paramResources.toString());
          }
        }
        else
        {
          i2 = paramAttributeSet1.getAttributeIntValue(m, -1);
          if (i2 != -1) {
            if (i2 != 0)
            {
              if (i2 != 1)
              {
                if (i2 == 2)
                {
                  paramResources.e = Shader.TileMode.MIRROR;
                  paramResources.f = Shader.TileMode.MIRROR;
                }
              }
              else
              {
                paramResources.e = Shader.TileMode.REPEAT;
                paramResources.f = Shader.TileMode.REPEAT;
              }
            }
            else
            {
              paramResources.e = Shader.TileMode.CLAMP;
              paramResources.f = Shader.TileMode.CLAMP;
            }
          }
        }
      }
      else {
        paramResources.c = paramAttributeSet1.getAttributeIntValue(m, 119);
      }
      m += 1;
    }
    if (paramAttributeSet2 != null)
    {
      if (paramBoolean)
      {
        i1 = paramAttributeSet2.getAttributeCount();
        m = n;
        while (m < i1)
        {
          n = paramAttributeSet2.getAttributeNameResource(m);
          if (n != 16842927) {
            if (n == 16843265) {}
          }
          switch (n)
          {
          default: 
            break;
          case 16843036: 
            localPaint.setDither(paramAttributeSet2.getAttributeBooleanValue(m, localPaint.isDither()));
            break;
          case 16843035: 
            localPaint.setFilterBitmap(paramAttributeSet2.getAttributeBooleanValue(m, localPaint.isFilterBitmap()));
            break;
          case 16843034: 
            localPaint.setAntiAlias(paramAttributeSet2.getAttributeBooleanValue(m, localPaint.isAntiAlias()));
            break;
            n = paramAttributeSet2.getAttributeIntValue(m, -2);
            if (n != -2) {
              if (n != -1)
              {
                if (n != 0)
                {
                  if (n != 1)
                  {
                    if (n == 2)
                    {
                      paramResources.e = Shader.TileMode.MIRROR;
                      paramResources.f = Shader.TileMode.MIRROR;
                    }
                  }
                  else
                  {
                    paramResources.e = Shader.TileMode.REPEAT;
                    paramResources.f = Shader.TileMode.REPEAT;
                  }
                }
                else
                {
                  paramResources.e = Shader.TileMode.CLAMP;
                  paramResources.f = Shader.TileMode.CLAMP;
                }
              }
              else
              {
                paramResources.e = null;
                paramResources.f = null;
                break;
                paramResources.c = paramAttributeSet2.getAttributeIntValue(m, 119);
              }
            }
            break;
          }
          m += 1;
        }
      }
      int i3 = paramAttributeSet2.getAttributeCount();
      n = 0;
      while (n < i3)
      {
        paramAttributeSet1 = paramAttributeSet2.getAttributeName(n);
        if ("antialias".equals(paramAttributeSet1))
        {
          localPaint.setAntiAlias(paramAttributeSet2.getAttributeBooleanValue(n, localPaint.isAntiAlias()));
        }
        else if ("filter".equals(paramAttributeSet1))
        {
          localPaint.setAntiAlias(paramAttributeSet2.getAttributeBooleanValue(n, localPaint.isAntiAlias()));
        }
        else if ("dither".equals(paramAttributeSet1))
        {
          localPaint.setAntiAlias(paramAttributeSet2.getAttributeBooleanValue(n, localPaint.isAntiAlias()));
        }
        else if ("gravity".equals(paramAttributeSet1))
        {
          paramAttributeSet1 = paramAttributeSet2.getAttributeValue(n);
          localObject1 = paramAttributeSet1.split("\\|");
          int i4 = localObject1.length;
          i1 = 0;
          m = 0;
          while (i1 < i4)
          {
            Object localObject2 = localObject1[i1];
            if ("top".equals(localObject2))
            {
              m |= 0x30;
            }
            else if ("bottom".equals(localObject2))
            {
              m |= 0x50;
            }
            else if ("left".equals(localObject2))
            {
              m |= 0x3;
            }
            else if ("right".equals(localObject2))
            {
              m |= 0x5;
            }
            else if ("center_vertical".equals(localObject2))
            {
              m |= 0x10;
            }
            else if ("fill_vertical".equals(localObject2))
            {
              m |= 0x70;
            }
            else if ("center_horizontal".equals(localObject2))
            {
              m |= 0x1;
            }
            else if ("fill_horizontal".equals(localObject2))
            {
              m |= 0x7;
            }
            else if ("center".equals(localObject2))
            {
              m |= 0x11;
            }
            else if ("fill".equals(localObject2))
            {
              m |= 0x77;
            }
            else if ("clip_vertical".equals(localObject2))
            {
              m |= 0x80;
            }
            else if ("clip_horizontal".equals(localObject2))
            {
              m |= 0x8;
            }
            else
            {
              if ("start".equals(localObject2)) {}
              for (i2 = 8388611;; i2 = 8388613)
              {
                m |= i2;
                break;
                if (!"end".equals(localObject2)) {
                  break label1113;
                }
              }
            }
            i1 += 1;
            continue;
            label1113:
            paramResources = new StringBuilder();
            paramResources.append("error attribute value: ");
            paramResources.append(paramAttributeSet1);
            throw new XmlPullParserException(paramResources.toString());
          }
          paramResources.c = m;
        }
        else if ("tileMode".equals(paramAttributeSet1))
        {
          paramAttributeSet1 = paramAttributeSet2.getAttributeValue(n);
          if ("clamp".equals(paramAttributeSet1))
          {
            paramResources.e = Shader.TileMode.CLAMP;
            paramResources.f = Shader.TileMode.CLAMP;
          }
          else if ("repeat".equals(paramAttributeSet1))
          {
            paramResources.e = Shader.TileMode.REPEAT;
            paramResources.f = Shader.TileMode.REPEAT;
          }
          else if ("mirror".equals(paramAttributeSet1))
          {
            paramResources.e = Shader.TileMode.MIRROR;
            paramResources.f = Shader.TileMode.MIRROR;
          }
          else if ("disabled".equals(paramAttributeSet1))
          {
            paramResources.e = null;
            paramResources.f = null;
          }
          else
          {
            paramResources = new StringBuilder();
            paramResources.append("error attribute value: ");
            paramResources.append(paramAttributeSet1);
            throw new XmlPullParserException(paramResources.toString());
          }
        }
        n += 1;
      }
    }
    if (paramResources.a == null)
    {
      if (paramResources.mImageSizeWhenOOM != null) {
        return paramResources;
      }
      paramResources = new StringBuilder();
      paramResources.append(paramXmlPullParser.getPositionDescription());
      paramResources.append(": <bitmap> requires a valid src attribute");
      throw new XmlPullParserException(paramResources.toString());
    }
    return paramResources;
  }
  
  private void a()
  {
    b();
    if (this.b.mImageSizeWhenOOM != null)
    {
      int[] arrayOfInt = this.b.mImageSizeWhenOOM;
      this.i = BaseConstantState.scaleFromDensity(arrayOfInt[0], arrayOfInt[2], this.d);
      this.i = BaseConstantState.scaleFromDensity(arrayOfInt[1], arrayOfInt[2], this.d);
      return;
    }
    this.i = this.c.getScaledWidth(this.d);
    this.j = this.c.getScaledHeight(this.d);
  }
  
  private void a(Bitmap paramBitmap)
  {
    this.c = paramBitmap;
    if (paramBitmap != null)
    {
      a();
      return;
    }
    this.j = -1;
    this.i = -1;
  }
  
  private void b()
  {
    if (this.c != this.b.a)
    {
      this.c = this.b.a;
      if (this.b.h)
      {
        this.g = true;
        this.f = true;
      }
      if (this.b.mImageSizeWhenOOM != null)
      {
        int[] arrayOfInt = this.b.mImageSizeWhenOOM;
        this.i = BaseConstantState.scaleFromDensity(arrayOfInt[0], arrayOfInt[2], this.d);
        this.i = BaseConstantState.scaleFromDensity(arrayOfInt[1], arrayOfInt[2], this.d);
        return;
      }
      this.i = this.c.getScaledWidth(this.d);
      this.j = this.c.getScaledHeight(this.d);
    }
  }
  
  private void b(Bitmap paramBitmap)
  {
    try
    {
      if ((Build.VERSION.SDK_INT >= 17) && (paramBitmap != null) && (!paramBitmap.isPremultiplied()) && (paramBitmap.getConfig() == Bitmap.Config.ARGB_8888) && (paramBitmap.hasAlpha()))
      {
        paramBitmap = getCallback();
        if ((paramBitmap != null) && ((paramBitmap instanceof TextView)))
        {
          paramBitmap = (TextView)paramBitmap;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("errorTextID:");
          localStringBuilder.append(paramBitmap.getId());
          localStringBuilder.append("errorTextString: ");
          localStringBuilder.append(paramBitmap.getText().toString());
          h.d("SkinnableBitmapDrawable", 2, localStringBuilder.toString(), null);
          return;
        }
      }
    }
    catch (Exception paramBitmap)
    {
      h.d("SkinnableBitmapDrawable", 2, paramBitmap.toString(), null);
      return;
    }
    catch (NoSuchMethodError paramBitmap)
    {
      h.d("SkinnableBitmapDrawable", 2, paramBitmap.toString(), null);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    b();
    if (this.b.mImageSizeWhenOOM != null) {
      return;
    }
    Bitmap localBitmap = this.c;
    if (localBitmap != null)
    {
      Object localObject1;
      if (this.b.bitmapType == 1)
      {
        setGravity(48);
        localObject1 = getImageDrawnRect(getBounds());
        if ((((Rect)localObject1).width() > 0) && (((Rect)localObject1).height() > 0))
        {
          b(this.c);
          paramCanvas.drawBitmap(this.c, (Rect)localObject1, getBounds(), this.b.d);
        }
      }
      else
      {
        SkinnableBitmapDrawable.a locala = this.b;
        if (this.g)
        {
          Object localObject2 = locala.e;
          Shader.TileMode localTileMode = locala.f;
          if ((localObject2 == null) && (localTileMode == null))
          {
            locala.d.setShader(null);
          }
          else
          {
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = Shader.TileMode.CLAMP;
            }
            localObject2 = localTileMode;
            if (localTileMode == null) {
              localObject2 = Shader.TileMode.CLAMP;
            }
            localObject1 = new BitmapShader(localBitmap, (Shader.TileMode)localObject1, (Shader.TileMode)localObject2);
            locala.d.setShader((Shader)localObject1);
          }
          this.g = false;
          copyBounds(this.e);
        }
        if (locala.d.getShader() == null)
        {
          if (this.f)
          {
            Gravity.apply(locala.c, this.i, this.j, getBounds(), this.e);
            this.f = false;
          }
          b(localBitmap);
          paramCanvas.drawBitmap(localBitmap, null, this.e, locala.d);
          return;
        }
        if (this.f)
        {
          this.e.set(getBounds());
          this.f = false;
        }
        paramCanvas.drawRect(this.e, locala.d);
      }
    }
  }
  
  public final Bitmap getBitmap()
  {
    b();
    return this.c;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.b.b;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    return this.b;
  }
  
  public int getGravity()
  {
    return this.b.c;
  }
  
  protected Rect getImageDrawnRect(Rect paramRect)
  {
    int m = getBitmap().getHeight();
    int i1 = getBitmap().getWidth();
    if (paramRect == null) {
      return new Rect(0, 0, i1, m);
    }
    Rect localRect = paramRect;
    if (paramRect.width() != 0)
    {
      if (paramRect.height() == 0) {
        return paramRect;
      }
      if (paramRect.height() / paramRect.width() >= m / i1)
      {
        int n = paramRect.width() * m / paramRect.height();
        double d1 = i1 - n;
        Double.isNaN(d1);
        i1 = (int)(d1 * 0.5D);
        return new Rect(i1, 0, n + i1, m);
      }
      localRect = new Rect(0, 0, i1, paramRect.height() * i1 / paramRect.width());
    }
    return localRect;
  }
  
  public int getIntrinsicHeight()
  {
    b();
    return this.j;
  }
  
  public int getIntrinsicWidth()
  {
    b();
    return this.i;
  }
  
  public int getOpacity()
  {
    int m = this.b.c;
    int n = -3;
    if (m != 119) {
      return -3;
    }
    b();
    Bitmap localBitmap = this.c;
    m = n;
    if (localBitmap != null)
    {
      m = n;
      if (!localBitmap.hasAlpha())
      {
        if (this.b.d.getAlpha() < 255) {
          return -3;
        }
        m = -1;
      }
    }
    return m;
  }
  
  public final Paint getPaint()
  {
    return this.b.d;
  }
  
  public Shader.TileMode getTileModeX()
  {
    return this.b.e;
  }
  
  public Shader.TileMode getTileModeY()
  {
    return this.b.f;
  }
  
  public Drawable mutate()
  {
    return this;
  }
  
  public Drawable mutate2()
  {
    return new SkinnableBitmapDrawable.a(this.b).newDrawable();
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.f = true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.b.d.setAlpha(paramInt);
  }
  
  public void setAntiAlias(boolean paramBoolean)
  {
    this.b.d.setAntiAlias(paramBoolean);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.b.d.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.b.d.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.b.d.setFilterBitmap(paramBoolean);
  }
  
  public void setGravity(int paramInt)
  {
    this.b.c = paramInt;
    this.f = true;
  }
  
  public void setTargetDensity(int paramInt)
  {
    int m = paramInt;
    if (paramInt == 0) {
      m = 160;
    }
    this.d = m;
    b();
    if (this.c != null) {
      a();
    }
  }
  
  public void setTargetDensity(Canvas paramCanvas)
  {
    setTargetDensity(paramCanvas.getDensity());
  }
  
  public void setTargetDensity(DisplayMetrics paramDisplayMetrics)
  {
    this.d = paramDisplayMetrics.densityDpi;
    b();
    if (this.c != null) {
      a();
    }
  }
  
  public void setTileModeX(Shader.TileMode paramTileMode)
  {
    setTileModeXY(paramTileMode, this.b.f);
  }
  
  public void setTileModeXY(Shader.TileMode paramTileMode1, Shader.TileMode paramTileMode2)
  {
    SkinnableBitmapDrawable.a locala = this.b;
    if ((locala.d.getShader() == null) || (locala.e != paramTileMode1) || (locala.f != paramTileMode2))
    {
      locala.e = paramTileMode1;
      locala.f = paramTileMode2;
      this.g = true;
    }
  }
  
  public final void setTileModeY(Shader.TileMode paramTileMode)
  {
    setTileModeXY(this.b.e, paramTileMode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.theme.SkinnableBitmapDrawable
 * JD-Core Version:    0.7.0.1
 */