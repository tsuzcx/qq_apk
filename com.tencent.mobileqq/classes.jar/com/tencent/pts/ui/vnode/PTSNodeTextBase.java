package com.tencent.pts.ui.vnode;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.PTSNodeStyle;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSValueConvertUtil;

public abstract class PTSNodeTextBase
  extends PTSNodeVirtual
{
  public static final String STYLE_ITALIC = "italic";
  public static final String TAG = "PTSNodeTextBase";
  public static final String TEXT_ALIGN_CENTER = "center";
  public static final String TEXT_ALIGN_JUSTIFY = "justify";
  public static final String TEXT_ALIGN_LEFT = "left";
  public static final String TEXT_ALIGN_RIGHT = "right";
  public static final String WEIGHT_BOLD = "bold";
  public static final String WEIGHT_LIGHTER = "lighter";
  public static final String WEIGHT_NORMAL = "normal";
  private String content;
  private float fontSizePx = PTSDeviceUtil.dp2px(16.0F);
  private String fontStyle = "";
  private String fontWeight = "normal";
  private float lineSpacing = PTSDeviceUtil.dp2px(3.2F);
  private int maxLines = 2147483647;
  private String textAlign = "left";
  private int textColor = -16777216;
  
  public PTSNodeTextBase(PTSAppInstance paramPTSAppInstance, String paramString1, String paramString2)
  {
    super(paramPTSAppInstance, paramString1, paramString2);
  }
  
  public static float getHeightOffset(float paramFloat, int paramInt)
  {
    return PTSDeviceUtil.getTextHeightOffsetPerLine() * paramInt * paramFloat;
  }
  
  public static float getLineSpacing(float paramFloat1, float paramFloat2, TextPaint paramTextPaint)
  {
    TextPaint localTextPaint = paramTextPaint;
    if (paramTextPaint == null)
    {
      PTSLog.e("PTSNodeTextBase", "[getLineSpacing] error, textPaint is null.");
      localTextPaint = new TextPaint();
    }
    localTextPaint.setTextSize(PTSDeviceUtil.dp2px(paramFloat2));
    return PTSDeviceUtil.dp2px(paramFloat1) - localTextPaint.getFontMetricsInt(null);
  }
  
  public static float getWidthOffset(float paramFloat, int paramInt)
  {
    float f2 = PTSDeviceUtil.getTextWidthOffsetPerLength();
    float f3 = paramInt;
    float f1;
    if (paramInt > 0) {
      f1 = 9.0F / f3;
    } else {
      f1 = 0.0F;
    }
    return f2 * paramFloat * (f3 + f1);
  }
  
  private void updatePtsOnPressColor()
  {
    Object localObject = getPtsOnPressColor();
    if (localObject == null) {
      return;
    }
    int i = ((Integer)localObject).intValue();
    int j = this.textColor;
    localObject = new ColorStateList(new int[][] { { 16842919 }, new int[0] }, new int[] { i, j });
    ((TextView)getView()).setTextColor((ColorStateList)localObject);
  }
  
  @SuppressLint({"WrongConstant"})
  private void updateTextAlign(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    TextView localTextView = (TextView)getView();
    if (paramString.equalsIgnoreCase("left"))
    {
      localTextView.setGravity(19);
      return;
    }
    if (paramString.equalsIgnoreCase("right"))
    {
      localTextView.setGravity(21);
      return;
    }
    if (paramString.equalsIgnoreCase("center"))
    {
      localTextView.setGravity(17);
      return;
    }
    if ((paramString.equalsIgnoreCase("justify")) && (Build.VERSION.SDK_INT >= 26)) {
      localTextView.setJustificationMode(1);
    }
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    TextView localTextView = (TextView)getView();
    localTextView.setText(this.content);
    float f = this.fontSizePx;
    int i = 0;
    localTextView.setTextSize(0, f);
    localTextView.setTextColor(this.textColor);
    localTextView.setMaxLines(this.maxLines);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setLineSpacing(this.lineSpacing, 1.0F);
    boolean bool1 = TextUtils.equals(this.fontWeight, "bold");
    boolean bool2 = TextUtils.equals(this.fontStyle, "italic");
    Typeface localTypeface;
    if (bool1)
    {
      localTypeface = Typeface.DEFAULT_BOLD;
      if (bool2) {
        i = 3;
      } else {
        i = 1;
      }
      localTextView.setTypeface(localTypeface, i);
    }
    else
    {
      localTypeface = Typeface.DEFAULT;
      if (bool2) {
        i = 2;
      }
      localTextView.setTypeface(localTypeface, i);
    }
    updateTextAlign(this.textAlign);
    updatePtsOnPressColor();
  }
  
  public void resetAll()
  {
    super.resetAll();
    TextView localTextView = (TextView)getView();
    localTextView.setText("");
    localTextView.setTextSize(16.0F);
    localTextView.setTypeface(null, 0);
    localTextView.setMaxLines(2147483647);
    localTextView.setGravity(16);
    localTextView.setLineSpacing(PTSDeviceUtil.dp2px(3.2F), 1.0F);
  }
  
  protected boolean setContent(String paramString)
  {
    this.content = paramString;
    return true;
  }
  
  protected boolean setStyle(String paramString, Object paramObject)
  {
    boolean bool = super.setStyle(paramString, paramObject);
    if (bool) {
      return true;
    }
    if ("font-size".equalsIgnoreCase(paramString))
    {
      this.fontSizePx = PTSDeviceUtil.dp2px(getNodeInfo().getStyle().getFontSize());
      return true;
    }
    if ("color".equalsIgnoreCase(paramString))
    {
      this.textColor = PTSValueConvertUtil.getColor(paramObject);
      return true;
    }
    if ("font-style".equalsIgnoreCase(paramString))
    {
      this.fontStyle = PTSValueConvertUtil.getString(paramObject);
      return true;
    }
    if ("font-weight".equalsIgnoreCase(paramString))
    {
      this.fontWeight = PTSValueConvertUtil.getString(paramObject);
      return true;
    }
    if ("-webkit-line-clamp".equalsIgnoreCase(paramString))
    {
      int j = PTSValueConvertUtil.getInt(paramObject);
      int i = j;
      if (j <= 0) {
        i = 1;
      }
      this.maxLines = i;
      return true;
    }
    if ("line-height".equalsIgnoreCase(paramString))
    {
      this.lineSpacing = getNodeInfo().getStyle().getLineSpacing(((TextView)getView()).getPaint());
      return true;
    }
    if ("text-align".equalsIgnoreCase(paramString))
    {
      this.textAlign = PTSValueConvertUtil.getString(paramObject);
      return true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeTextBase
 * JD-Core Version:    0.7.0.1
 */