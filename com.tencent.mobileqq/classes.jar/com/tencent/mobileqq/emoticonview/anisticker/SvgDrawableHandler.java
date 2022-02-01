package com.tencent.mobileqq.emoticonview.anisticker;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.core.graphics.PathParser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SvgDrawableHandler
  extends DefaultHandler
{
  private Bitmap bitmap;
  private boolean boundsMode;
  private Canvas canvas;
  private int desiredHeight;
  private int desiredWidth;
  private AniStickerSvgDrawable drawable;
  private HashMap<String, SvgDrawableHandler.StyleSet> globalStyles = new HashMap();
  private Paint paint = new Paint(1);
  boolean pushed = false;
  private RectF rect = new RectF();
  private RectF rectTmp = new RectF();
  private float scale = 1.0F;
  private int showColor = -1;
  private StringBuilder styles;
  
  SvgDrawableHandler(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.desiredWidth = paramInt1;
    this.desiredHeight = paramInt2;
    this.showColor = paramInt3;
    if (paramBoolean) {
      this.drawable = new AniStickerSvgDrawable();
    }
  }
  
  private void doColor(SvgDrawableHandler.Properties paramProperties, Integer paramInteger, boolean paramBoolean)
  {
    int i = this.showColor;
    if (i != -1)
    {
      this.paint.setColor(i);
    }
    else
    {
      i = paramInteger.intValue();
      this.paint.setColor(i & 0xFFFFFF | 0xFF000000);
    }
    Float localFloat = paramProperties.getFloat("opacity");
    paramInteger = localFloat;
    if (localFloat == null)
    {
      if (paramBoolean) {
        paramInteger = "fill-opacity";
      } else {
        paramInteger = "stroke-opacity";
      }
      paramInteger = paramProperties.getFloat(paramInteger);
    }
    if (paramInteger == null)
    {
      this.paint.setAlpha(255);
      return;
    }
    this.paint.setAlpha((int)(paramInteger.floatValue() * 255.0F));
  }
  
  private boolean doFill(SvgDrawableHandler.Properties paramProperties)
  {
    if ("none".equals(paramProperties.getString("display"))) {
      return false;
    }
    Object localObject = paramProperties.getString("fill");
    if ((localObject != null) && (((String)localObject).startsWith("url(#")))
    {
      ((String)localObject).substring(5, ((String)localObject).length() - 1);
      return false;
    }
    localObject = paramProperties.getHex("fill");
    if (localObject != null)
    {
      doColor(paramProperties, (Integer)localObject, true);
      this.paint.setStyle(Paint.Style.FILL);
      return true;
    }
    if ((paramProperties.getString("fill") == null) && (paramProperties.getString("stroke") == null))
    {
      this.paint.setStyle(Paint.Style.FILL);
      int i = this.showColor;
      if (i != -1)
      {
        this.paint.setColor(i);
        return true;
      }
      this.paint.setColor(-16777216);
      return true;
    }
    return false;
  }
  
  private boolean doStroke(SvgDrawableHandler.Properties paramProperties)
  {
    if ("none".equals(paramProperties.getString("display"))) {
      return false;
    }
    Object localObject = paramProperties.getHex("stroke");
    if (localObject != null)
    {
      doColor(paramProperties, (Integer)localObject, false);
      localObject = paramProperties.getFloat("stroke-width");
      if (localObject != null) {
        this.paint.setStrokeWidth(((Float)localObject).floatValue());
      }
      localObject = paramProperties.getString("stroke-linecap");
      if ("round".equals(localObject)) {
        this.paint.setStrokeCap(Paint.Cap.ROUND);
      } else if ("square".equals(localObject)) {
        this.paint.setStrokeCap(Paint.Cap.SQUARE);
      } else if ("butt".equals(localObject)) {
        this.paint.setStrokeCap(Paint.Cap.BUTT);
      }
      paramProperties = paramProperties.getString("stroke-linejoin");
      if ("miter".equals(paramProperties)) {
        this.paint.setStrokeJoin(Paint.Join.MITER);
      } else if ("round".equals(paramProperties)) {
        this.paint.setStrokeJoin(Paint.Join.ROUND);
      } else if ("bevel".equals(paramProperties)) {
        this.paint.setStrokeJoin(Paint.Join.BEVEL);
      }
      this.paint.setStyle(Paint.Style.STROKE);
      return true;
    }
    return false;
  }
  
  private static Integer getColorByName(String paramString)
  {
    paramString = paramString.toLowerCase();
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 828922025: 
      if (paramString.equals("magenta")) {
        i = 7;
      }
      break;
    case 113101865: 
      if (paramString.equals("white")) {
        i = 8;
      }
      break;
    case 98619139: 
      if (paramString.equals("green")) {
        i = 3;
      }
      break;
    case 93818879: 
      if (paramString.equals("black")) {
        i = 0;
      }
      break;
    case 3181155: 
      if (paramString.equals("gray")) {
        i = 1;
      }
      break;
    case 3068707: 
      if (paramString.equals("cyan")) {
        i = 6;
      }
      break;
    case 3027034: 
      if (paramString.equals("blue")) {
        i = 4;
      }
      break;
    case 112785: 
      if (paramString.equals("red")) {
        i = 2;
      }
      break;
    case -734239628: 
      if (paramString.equals("yellow")) {
        i = 5;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      return null;
    case 8: 
      return Integer.valueOf(-1);
    case 7: 
      return Integer.valueOf(-65281);
    case 6: 
      return Integer.valueOf(-16711681);
    case 5: 
      return Integer.valueOf(-256);
    case 4: 
      return Integer.valueOf(-16776961);
    case 3: 
      return Integer.valueOf(-16711936);
    case 2: 
      return Integer.valueOf(-65536);
    case 1: 
      return Integer.valueOf(-7829368);
    }
    return Integer.valueOf(-16777216);
  }
  
  private static Float getFloatAttr(String paramString, Attributes paramAttributes)
  {
    return getFloatAttr(paramString, paramAttributes, null);
  }
  
  private static Float getFloatAttr(String paramString, Attributes paramAttributes, Float paramFloat)
  {
    paramAttributes = getStringAttr(paramString, paramAttributes);
    if (paramAttributes == null) {
      return paramFloat;
    }
    if (paramAttributes.endsWith("px"))
    {
      paramString = paramAttributes.substring(0, paramAttributes.length() - 2);
    }
    else
    {
      paramString = paramAttributes;
      if (paramAttributes.endsWith("mm")) {
        return null;
      }
    }
    return Float.valueOf(Float.parseFloat(paramString));
  }
  
  private static Integer getHexAttr(String paramString, Attributes paramAttributes)
  {
    paramString = getStringAttr(paramString, paramAttributes);
    if (paramString == null) {
      return null;
    }
    try
    {
      int i = Integer.parseInt(paramString.substring(1), 16);
      return Integer.valueOf(i);
    }
    catch (NumberFormatException paramAttributes)
    {
      label28:
      break label28;
    }
    return getColorByName(paramString);
  }
  
  private static SvgDrawableHandler.NumberParse getNumberParseAttr(String paramString, Attributes paramAttributes)
  {
    int j = paramAttributes.getLength();
    int i = 0;
    while (i < j)
    {
      if (paramAttributes.getLocalName(i).equals(paramString)) {
        return parseNumbers(paramAttributes.getValue(i));
      }
      i += 1;
    }
    return null;
  }
  
  private static String getStringAttr(String paramString, Attributes paramAttributes)
  {
    int j = paramAttributes.getLength();
    int i = 0;
    while (i < j)
    {
      if (paramAttributes.getLocalName(i).equals(paramString)) {
        return paramAttributes.getValue(i);
      }
      i += 1;
    }
    return null;
  }
  
  private static SvgDrawableHandler.NumberParse parseNumbers(String paramString)
  {
    int m = paramString.length();
    ArrayList localArrayList = new ArrayList();
    int j = 1;
    int i = 0;
    int k = 0;
    while (j < m)
    {
      if (k != 0)
      {
        k = 0;
      }
      else
      {
        int n = paramString.charAt(j);
        switch (n)
        {
        default: 
          break;
        case 41: 
        case 65: 
        case 67: 
        case 72: 
        case 76: 
        case 77: 
        case 81: 
        case 83: 
        case 84: 
        case 86: 
        case 90: 
        case 97: 
        case 99: 
        case 104: 
        case 108: 
        case 109: 
        case 113: 
        case 115: 
        case 116: 
        case 118: 
        case 122: 
          paramString = paramString.substring(i, j);
          if (paramString.trim().length() > 0) {
            localArrayList.add(Float.valueOf(Float.parseFloat(paramString)));
          }
          return new SvgDrawableHandler.NumberParse(localArrayList, j);
        case 9: 
        case 10: 
        case 32: 
        case 44: 
        case 45: 
          if ((n != 45) || (paramString.charAt(j - 1) != 'e'))
          {
            str = paramString.substring(i, j);
            if (str.trim().length() > 0)
            {
              localArrayList.add(Float.valueOf(Float.parseFloat(str)));
              if (n == 45)
              {
                i = j;
              }
              else
              {
                i = j + 1;
                k = 1;
              }
            }
            else
            {
              i += 1;
            }
          }
          break;
        }
      }
      j += 1;
    }
    String str = paramString.substring(i);
    if (str.length() > 0) {}
    try
    {
      localArrayList.add(Float.valueOf(Float.parseFloat(str)));
      label424:
      i = paramString.length();
      return new SvgDrawableHandler.NumberParse(localArrayList, i);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label424;
    }
  }
  
  private static Matrix parseTransform(String paramString)
  {
    boolean bool = paramString.startsWith("matrix(");
    float f3 = 0.0F;
    float f1 = 0.0F;
    float f2 = 0.0F;
    if (bool)
    {
      paramString = parseNumbers(paramString.substring(7));
      if (SvgDrawableHandler.NumberParse.access$100(paramString).size() == 6)
      {
        Matrix localMatrix = new Matrix();
        localMatrix.setValues(new float[] { ((Float)SvgDrawableHandler.NumberParse.access$100(paramString).get(0)).floatValue(), ((Float)SvgDrawableHandler.NumberParse.access$100(paramString).get(2)).floatValue(), ((Float)SvgDrawableHandler.NumberParse.access$100(paramString).get(4)).floatValue(), ((Float)SvgDrawableHandler.NumberParse.access$100(paramString).get(1)).floatValue(), ((Float)SvgDrawableHandler.NumberParse.access$100(paramString).get(3)).floatValue(), ((Float)SvgDrawableHandler.NumberParse.access$100(paramString).get(5)).floatValue(), 0.0F, 0.0F, 1.0F });
        return localMatrix;
      }
    }
    else if (paramString.startsWith("translate("))
    {
      paramString = parseNumbers(paramString.substring(10));
      if (SvgDrawableHandler.NumberParse.access$100(paramString).size() > 0)
      {
        f3 = ((Float)SvgDrawableHandler.NumberParse.access$100(paramString).get(0)).floatValue();
        f1 = f2;
        if (SvgDrawableHandler.NumberParse.access$100(paramString).size() > 1) {
          f1 = ((Float)SvgDrawableHandler.NumberParse.access$100(paramString).get(1)).floatValue();
        }
        paramString = new Matrix();
        paramString.postTranslate(f3, f1);
        return paramString;
      }
    }
    else if (paramString.startsWith("scale("))
    {
      paramString = parseNumbers(paramString.substring(6));
      if (SvgDrawableHandler.NumberParse.access$100(paramString).size() > 0)
      {
        f2 = ((Float)SvgDrawableHandler.NumberParse.access$100(paramString).get(0)).floatValue();
        f1 = f3;
        if (SvgDrawableHandler.NumberParse.access$100(paramString).size() > 1) {
          f1 = ((Float)SvgDrawableHandler.NumberParse.access$100(paramString).get(1)).floatValue();
        }
        paramString = new Matrix();
        paramString.postScale(f2, f1);
        return paramString;
      }
    }
    else if (paramString.startsWith("skewX("))
    {
      paramString = parseNumbers(paramString.substring(6));
      if (SvgDrawableHandler.NumberParse.access$100(paramString).size() > 0)
      {
        f1 = ((Float)SvgDrawableHandler.NumberParse.access$100(paramString).get(0)).floatValue();
        paramString = new Matrix();
        paramString.postSkew((float)Math.tan(f1), 0.0F);
        return paramString;
      }
    }
    else if (paramString.startsWith("skewY("))
    {
      paramString = parseNumbers(paramString.substring(6));
      if (SvgDrawableHandler.NumberParse.access$100(paramString).size() > 0)
      {
        f1 = ((Float)SvgDrawableHandler.NumberParse.access$100(paramString).get(0)).floatValue();
        paramString = new Matrix();
        paramString.postSkew(0.0F, (float)Math.tan(f1));
        return paramString;
      }
    }
    else if (paramString.startsWith("rotate("))
    {
      paramString = parseNumbers(paramString.substring(7));
      if (SvgDrawableHandler.NumberParse.access$100(paramString).size() > 0)
      {
        f3 = ((Float)SvgDrawableHandler.NumberParse.access$100(paramString).get(0)).floatValue();
        if (SvgDrawableHandler.NumberParse.access$100(paramString).size() > 2)
        {
          f1 = ((Float)SvgDrawableHandler.NumberParse.access$100(paramString).get(1)).floatValue();
          f2 = ((Float)SvgDrawableHandler.NumberParse.access$100(paramString).get(2)).floatValue();
        }
        else
        {
          f2 = 0.0F;
        }
        paramString = new Matrix();
        paramString.postTranslate(f1, f2);
        paramString.postRotate(f3);
        paramString.postTranslate(-f1, -f2);
        return paramString;
      }
    }
    return null;
  }
  
  private void popTransform()
  {
    if (this.pushed)
    {
      AniStickerSvgDrawable localAniStickerSvgDrawable = this.drawable;
      if (localAniStickerSvgDrawable != null)
      {
        localAniStickerSvgDrawable.addCommand(null);
        return;
      }
      this.canvas.restore();
    }
  }
  
  private void pushTransform(Attributes paramAttributes)
  {
    paramAttributes = getStringAttr("transform", paramAttributes);
    boolean bool;
    if (paramAttributes != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.pushed = bool;
    if (this.pushed)
    {
      paramAttributes = parseTransform(paramAttributes);
      AniStickerSvgDrawable localAniStickerSvgDrawable = this.drawable;
      if (localAniStickerSvgDrawable != null)
      {
        localAniStickerSvgDrawable.addCommand(paramAttributes);
        return;
      }
      this.canvas.save();
      this.canvas.concat(paramAttributes);
    }
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = this.styles;
    if (localStringBuilder != null) {
      localStringBuilder.append(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
  
  public void endDocument() {}
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    switch (paramString2.hashCode())
    {
    default: 
      break;
    case 917656469: 
      if (paramString2.equals("clipPath")) {
        i = 4;
      }
      break;
    case 109780401: 
      if (paramString2.equals("style")) {
        i = 0;
      }
      break;
    case 3079438: 
      if (paramString2.equals("defs")) {
        i = 3;
      }
      break;
    case 114276: 
      if (paramString2.equals("svg")) {
        i = 1;
      }
      break;
    case 103: 
      if (paramString2.equals("g")) {
        i = 2;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if (i != 1)
      {
        if ((i != 2) && (i != 3) && (i != 4)) {
          return;
        }
        this.boundsMode = false;
      }
    }
    else
    {
      paramString1 = this.styles;
      if (paramString1 != null)
      {
        paramString1 = paramString1.toString().split("\\}");
        i = 0;
        while (i < paramString1.length)
        {
          paramString1[i] = paramString1[i].trim().replace("\t", "").replace("\n", "");
          if ((paramString1[i].length() != 0) && (paramString1[i].charAt(0) == '.'))
          {
            int j = paramString1[i].indexOf('{');
            if (j >= 0)
            {
              paramString2 = paramString1[i].substring(1, j).trim();
              paramString3 = paramString1[i].substring(j + 1);
              this.globalStyles.put(paramString2, new SvgDrawableHandler.StyleSet(paramString3, null));
            }
          }
          i += 1;
        }
        this.styles = null;
      }
    }
  }
  
  public Bitmap getBitmap()
  {
    return this.bitmap;
  }
  
  public AniStickerSvgDrawable getDrawable()
  {
    return this.drawable;
  }
  
  public void startDocument() {}
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if ((this.boundsMode) && (!paramString2.equals("style"))) {
      return;
    }
    int i = -1;
    int k = paramString2.hashCode();
    int j = 2;
    switch (k)
    {
    default: 
      break;
    case 917656469: 
      if (paramString2.equals("clipPath")) {
        i = 2;
      }
      break;
    case 561938880: 
      if (paramString2.equals("polyline")) {
        i = 10;
      }
      break;
    case 109780401: 
      if (paramString2.equals("style")) {
        i = 3;
      }
      break;
    case 3496420: 
      if (paramString2.equals("rect")) {
        i = 5;
      }
      break;
    case 3433509: 
      if (paramString2.equals("path")) {
        i = 11;
      }
      break;
    case 3321844: 
      if (paramString2.equals("line")) {
        i = 6;
      }
      break;
    case 3079438: 
      if (paramString2.equals("defs")) {
        i = 1;
      }
      break;
    case 114276: 
      if (paramString2.equals("svg")) {
        i = 0;
      }
      break;
    case 103: 
      if (paramString2.equals("g")) {
        i = 4;
      }
      break;
    case -397519558: 
      if (paramString2.equals("polygon")) {
        i = 9;
      }
      break;
    case -1360216880: 
      if (paramString2.equals("circle")) {
        i = 7;
      }
      break;
    case -1656480802: 
      if (paramString2.equals("ellipse")) {
        i = 8;
      }
      break;
    }
    Object localObject;
    switch (i)
    {
    default: 
    case 11: 
      try
      {
        paramString1 = PathParser.createPathFromPathData(getStringAttr("d", paramAttributes));
      }
      catch (Exception paramString1)
      {
        QLog.e("SvgDrawableHandler", 2, paramString1, new Object[0]);
        paramString1 = null;
      }
      if (paramString1 == null) {
        return;
      }
      pushTransform(paramAttributes);
      paramString2 = new SvgDrawableHandler.Properties(paramAttributes, this.globalStyles, null);
      if (doFill(paramString2))
      {
        paramString3 = this.drawable;
        if (paramString3 != null) {
          paramString3.addCommand(paramString1, this.paint);
        } else {
          this.canvas.drawPath(paramString1, this.paint);
        }
      }
      if (doStroke(paramString2))
      {
        paramString2 = this.drawable;
        if (paramString2 != null) {
          paramString2.addCommand(paramString1, this.paint);
        } else {
          this.canvas.drawPath(paramString1, this.paint);
        }
      }
      popTransform();
      return;
    case 9: 
    case 10: 
      paramString3 = getNumberParseAttr("points", paramAttributes);
      if (paramString3 != null)
      {
        paramString1 = new Path();
        paramString3 = SvgDrawableHandler.NumberParse.access$100(paramString3);
        if (paramString3.size() > 1)
        {
          pushTransform(paramAttributes);
          paramAttributes = new SvgDrawableHandler.Properties(paramAttributes, this.globalStyles, null);
          paramString1.moveTo(((Float)paramString3.get(0)).floatValue(), ((Float)paramString3.get(1)).floatValue());
          i = j;
          while (i < paramString3.size())
          {
            paramString1.lineTo(((Float)paramString3.get(i)).floatValue(), ((Float)paramString3.get(i + 1)).floatValue());
            i += 2;
          }
          if (paramString2.equals("polygon")) {
            paramString1.close();
          }
          if (doFill(paramAttributes))
          {
            paramString2 = this.drawable;
            if (paramString2 != null) {
              paramString2.addCommand(paramString1, this.paint);
            } else {
              this.canvas.drawPath(paramString1, this.paint);
            }
          }
          if (doStroke(paramAttributes))
          {
            paramString2 = this.drawable;
            if (paramString2 != null) {
              paramString2.addCommand(paramString1, this.paint);
            } else {
              this.canvas.drawPath(paramString1, this.paint);
            }
          }
          popTransform();
          return;
        }
      }
      break;
    case 8: 
      paramString1 = getFloatAttr("cx", paramAttributes);
      paramString2 = getFloatAttr("cy", paramAttributes);
      paramString3 = getFloatAttr("rx", paramAttributes);
      localObject = getFloatAttr("ry", paramAttributes);
      if ((paramString1 != null) && (paramString2 != null) && (paramString3 != null) && (localObject != null))
      {
        pushTransform(paramAttributes);
        paramAttributes = new SvgDrawableHandler.Properties(paramAttributes, this.globalStyles, null);
        this.rect.set(paramString1.floatValue() - paramString3.floatValue(), paramString2.floatValue() - ((Float)localObject).floatValue(), paramString1.floatValue() + paramString3.floatValue(), paramString2.floatValue() + ((Float)localObject).floatValue());
        if (doFill(paramAttributes))
        {
          paramString1 = this.drawable;
          if (paramString1 != null) {
            paramString1.addCommand(new AniStickerSvgDrawable.Oval(this.rect), this.paint);
          } else {
            this.canvas.drawOval(this.rect, this.paint);
          }
        }
        if (doStroke(paramAttributes))
        {
          paramString1 = this.drawable;
          if (paramString1 != null) {
            paramString1.addCommand(new AniStickerSvgDrawable.Oval(this.rect), this.paint);
          } else {
            this.canvas.drawOval(this.rect, this.paint);
          }
        }
        popTransform();
        return;
      }
      break;
    case 7: 
      paramString1 = getFloatAttr("cx", paramAttributes);
      paramString2 = getFloatAttr("cy", paramAttributes);
      paramString3 = getFloatAttr("r", paramAttributes);
      if ((paramString1 != null) && (paramString2 != null) && (paramString3 != null))
      {
        pushTransform(paramAttributes);
        paramAttributes = new SvgDrawableHandler.Properties(paramAttributes, this.globalStyles, null);
        if (doFill(paramAttributes))
        {
          localObject = this.drawable;
          if (localObject != null) {
            ((AniStickerSvgDrawable)localObject).addCommand(new AniStickerSvgDrawable.Circle(paramString1.floatValue(), paramString2.floatValue(), paramString3.floatValue()), this.paint);
          } else {
            this.canvas.drawCircle(paramString1.floatValue(), paramString2.floatValue(), paramString3.floatValue(), this.paint);
          }
        }
        if (doStroke(paramAttributes))
        {
          paramAttributes = this.drawable;
          if (paramAttributes != null) {
            paramAttributes.addCommand(new AniStickerSvgDrawable.Circle(paramString1.floatValue(), paramString2.floatValue(), paramString3.floatValue()), this.paint);
          } else {
            this.canvas.drawCircle(paramString1.floatValue(), paramString2.floatValue(), paramString3.floatValue(), this.paint);
          }
        }
        popTransform();
        return;
      }
      break;
    case 6: 
      paramString1 = getFloatAttr("x1", paramAttributes);
      paramString2 = getFloatAttr("x2", paramAttributes);
      paramString3 = getFloatAttr("y1", paramAttributes);
      localObject = getFloatAttr("y2", paramAttributes);
      if (doStroke(new SvgDrawableHandler.Properties(paramAttributes, this.globalStyles, null)))
      {
        pushTransform(paramAttributes);
        paramAttributes = this.drawable;
        if (paramAttributes != null) {
          paramAttributes.addCommand(new AniStickerSvgDrawable.Line(paramString1.floatValue(), paramString3.floatValue(), paramString2.floatValue(), ((Float)localObject).floatValue()), this.paint);
        } else {
          this.canvas.drawLine(paramString1.floatValue(), paramString3.floatValue(), paramString2.floatValue(), ((Float)localObject).floatValue(), this.paint);
        }
        popTransform();
        return;
      }
      break;
    case 5: 
      paramString2 = getFloatAttr("x", paramAttributes);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = Float.valueOf(0.0F);
      }
      paramString3 = getFloatAttr("y", paramAttributes);
      paramString2 = paramString3;
      if (paramString3 == null) {
        paramString2 = Float.valueOf(0.0F);
      }
      paramString3 = getFloatAttr("width", paramAttributes);
      localObject = getFloatAttr("height", paramAttributes);
      Float localFloat = getFloatAttr("rx", paramAttributes, null);
      pushTransform(paramAttributes);
      paramAttributes = new SvgDrawableHandler.Properties(paramAttributes, this.globalStyles, null);
      if (doFill(paramAttributes))
      {
        AniStickerSvgDrawable localAniStickerSvgDrawable = this.drawable;
        if (localAniStickerSvgDrawable != null)
        {
          if (localFloat != null) {
            localAniStickerSvgDrawable.addCommand(new AniStickerSvgDrawable.RoundRect(new RectF(paramString1.floatValue(), paramString2.floatValue(), paramString1.floatValue() + paramString3.floatValue(), paramString2.floatValue() + ((Float)localObject).floatValue()), localFloat.floatValue()), this.paint);
          } else {
            localAniStickerSvgDrawable.addCommand(new RectF(paramString1.floatValue(), paramString2.floatValue(), paramString1.floatValue() + paramString3.floatValue(), paramString2.floatValue() + ((Float)localObject).floatValue()), this.paint);
          }
        }
        else if (localFloat != null)
        {
          this.rectTmp.set(paramString1.floatValue(), paramString2.floatValue(), paramString1.floatValue() + paramString3.floatValue(), paramString2.floatValue() + ((Float)localObject).floatValue());
          this.canvas.drawRoundRect(this.rectTmp, localFloat.floatValue(), localFloat.floatValue(), this.paint);
        }
        else
        {
          this.canvas.drawRect(paramString1.floatValue(), paramString2.floatValue(), paramString1.floatValue() + paramString3.floatValue(), paramString2.floatValue() + ((Float)localObject).floatValue(), this.paint);
        }
      }
      if (doStroke(paramAttributes))
      {
        paramAttributes = this.drawable;
        if (paramAttributes != null)
        {
          if (localFloat != null) {
            paramAttributes.addCommand(new AniStickerSvgDrawable.RoundRect(new RectF(paramString1.floatValue(), paramString2.floatValue(), paramString1.floatValue() + paramString3.floatValue(), paramString2.floatValue() + ((Float)localObject).floatValue()), localFloat.floatValue()), this.paint);
          } else {
            paramAttributes.addCommand(new RectF(paramString1.floatValue(), paramString2.floatValue(), paramString1.floatValue() + paramString3.floatValue(), paramString2.floatValue() + ((Float)localObject).floatValue()), this.paint);
          }
        }
        else if (localFloat != null)
        {
          this.rectTmp.set(paramString1.floatValue(), paramString2.floatValue(), paramString1.floatValue() + paramString3.floatValue(), paramString2.floatValue() + ((Float)localObject).floatValue());
          this.canvas.drawRoundRect(this.rectTmp, localFloat.floatValue(), localFloat.floatValue(), this.paint);
        }
        else
        {
          this.canvas.drawRect(paramString1.floatValue(), paramString2.floatValue(), paramString1.floatValue() + paramString3.floatValue(), paramString2.floatValue() + ((Float)localObject).floatValue(), this.paint);
        }
      }
      popTransform();
      return;
    case 4: 
      if ("bounds".equalsIgnoreCase(getStringAttr("id", paramAttributes)))
      {
        this.boundsMode = true;
        return;
      }
      break;
    case 3: 
      this.styles = new StringBuilder();
      return;
    case 1: 
    case 2: 
      this.boundsMode = true;
      return;
    case 0: 
      paramString3 = getFloatAttr("width", paramAttributes);
      localObject = getFloatAttr("height", paramAttributes);
      float f1;
      if (paramString3 != null)
      {
        paramString2 = paramString3;
        paramString1 = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramAttributes = getStringAttr("viewBox", paramAttributes);
        paramString2 = paramString3;
        paramString1 = (String)localObject;
        if (paramAttributes != null)
        {
          paramString1 = paramAttributes.split(" ");
          f1 = Float.parseFloat(paramString1[2]);
          paramString1 = Float.valueOf(Float.parseFloat(paramString1[3]));
          paramString2 = Float.valueOf(f1);
        }
      }
      if (paramString2 != null)
      {
        paramString3 = paramString2;
        paramString2 = paramString1;
        if (paramString1 != null) {}
      }
      else
      {
        paramString3 = Float.valueOf(this.desiredWidth);
        paramString2 = Float.valueOf(this.desiredHeight);
      }
      k = (int)Math.ceil(paramString3.floatValue());
      int m = (int)Math.ceil(paramString2.floatValue());
      if ((k != 0) && (m != 0))
      {
        int n = this.desiredWidth;
        i = k;
        j = m;
        if (n != 0)
        {
          int i1 = this.desiredHeight;
          i = k;
          j = m;
          if (i1 != 0)
          {
            float f2 = n;
            f1 = k;
            float f3 = f2 / f1;
            float f4 = i1;
            f2 = m;
            this.scale = Math.min(f3, f4 / f2);
            f3 = this.scale;
            i = (int)(f1 * f3);
            j = (int)(f2 * f3);
          }
        }
      }
      else
      {
        i = this.desiredWidth;
        j = this.desiredHeight;
      }
      paramString1 = this.drawable;
      if (paramString1 == null)
      {
        this.bitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        this.bitmap.eraseColor(0);
        this.canvas = new Canvas(this.bitmap);
        f1 = this.scale;
        if (f1 != 0.0F) {
          this.canvas.scale(f1, f1);
        }
      }
      else
      {
        paramString1.width = i;
        paramString1.height = j;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.anisticker.SvgDrawableHandler
 * JD-Core Version:    0.7.0.1
 */