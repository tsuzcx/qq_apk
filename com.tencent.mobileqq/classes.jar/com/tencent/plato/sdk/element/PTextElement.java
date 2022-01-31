package com.tencent.plato.sdk.element;

import android.graphics.Typeface;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.plato.core.IWritableMap;
import com.tencent.plato.core.utils.AssertUtil;
import com.tencent.plato.layout.LayoutEngine;
import com.tencent.plato.layout.PMeasureFunction;
import com.tencent.plato.layout.PMeasureFunction.MeasureValue;
import com.tencent.plato.layout.PMeasureMode;
import com.tencent.plato.layout.PlatoNode;
import com.tencent.plato.sdk.element.text.StaticLayoutWithMaxLines;
import com.tencent.plato.sdk.render.PTextView;
import com.tencent.plato.sdk.utils.DeviceInfo;
import com.tencent.plato.sdk.utils.Dimension;
import org.json.JSONException;
import org.json.JSONObject;

public class PTextElement
  extends PElement
{
  private static final String TAG = "PTextElement";
  private static final BoringLayout.Metrics UNKNOWN_BORING = new BoringLayout.Metrics();
  private static TextPaint textPaint;
  private String color = "#404040";
  private int fontSize = 12;
  private boolean isBold = false;
  private BoringLayout.Metrics mBoring = null;
  private TextUtils.TruncateAt mEllipsize = null;
  private int mMaxLines = 2147483647;
  private String value = "";
  
  public PTextElement(LayoutEngine paramLayoutEngine, int paramInt)
  {
    super(paramLayoutEngine, paramInt);
    setMeasureFunction(new ViewMeasureFunction());
    if (textPaint == null)
    {
      textPaint = new TextPaint(1);
      textPaint.density = DeviceInfo.mDensity;
    }
  }
  
  public JSONObject dumpNode(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject2 = super.dumpNode(paramJSONObject);
    try
    {
      Object localObject = localJSONObject2.optJSONObject("attributes");
      paramJSONObject = (JSONObject)localObject;
      if (localObject == null)
      {
        paramJSONObject = new JSONObject();
        localJSONObject2.put("attributes", paramJSONObject);
      }
      JSONObject localJSONObject1 = paramJSONObject.optJSONObject("style");
      localObject = localJSONObject1;
      if (localJSONObject1 == null)
      {
        localObject = new JSONObject();
        paramJSONObject.put("style", localObject);
      }
      if (!TextUtils.isEmpty(getUIStyles().getString("text", null))) {
        paramJSONObject.put("value", getUIStyles().getString("text", ""));
      }
      int i = getUIStyles().getInt("fontSize", 12);
      if (i != 12) {
        ((JSONObject)localObject).put("fontSize", Dimension.devicePx2RemPx(Dimension.sp2px(i)) + "px");
      }
      if (getUIStyles().getBoolean("bold", false)) {
        ((JSONObject)localObject).put("fontWeight", "bold");
      }
      paramJSONObject = getUIStyles().getString("color", null);
      if (!"#808080".equals(paramJSONObject)) {
        ((JSONObject)localObject).put("color", paramJSONObject);
      }
      return localJSONObject2;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localJSONObject2;
  }
  
  @Property("ellipsize")
  public void ellipsize(String paramString)
  {
    addUIStyle("ellipsize", paramString);
    if (paramString.equals("start")) {
      this.mEllipsize = TextUtils.TruncateAt.START;
    }
    for (;;)
    {
      this.mNode.dirty();
      return;
      if (paramString.equals("end")) {
        this.mEllipsize = TextUtils.TruncateAt.END;
      } else if (paramString.equals("middle")) {
        this.mEllipsize = TextUtils.TruncateAt.MIDDLE;
      } else {
        this.mEllipsize = TextUtils.TruncateAt.MARQUEE;
      }
    }
  }
  
  @Property("fontSize")
  public void fontSize(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (this.fontSize = 12;; this.fontSize = Dimension.px2sp(this.fontSize))
    {
      addUIStyle("fontSize", this.fontSize);
      this.mNode.dirty();
      return;
      this.fontSize = ((int)Dimension.parse(paramString).px);
    }
  }
  
  @Property("fontWeight")
  public void fontWeight(String paramString)
  {
    if ("bold".equals(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      this.isBold = bool;
      addUIStyle("bold", bool);
      this.mNode.dirty();
      return;
      if (!"normal".equals(paramString)) {
        break;
      }
    }
    if (Dimension.Float(paramString) >= 400.0D) {}
    for (bool = true;; bool = false) {
      break;
    }
  }
  
  public String getElementType()
  {
    return "text";
  }
  
  public boolean isLeafNode()
  {
    return true;
  }
  
  @Property("maxLines")
  public void maxLines(String paramString)
  {
    int i = 10000;
    if (!TextUtils.isEmpty(paramString)) {
      i = Integer.parseInt(paramString);
    }
    if (i > 0) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.Assert(bool, "maxLines num need > 0");
      addUIStyle("maxLines", i);
      this.mMaxLines = i;
      if (this.mEllipsize == null)
      {
        this.mEllipsize = TextUtils.TruncateAt.END;
        addUIStyle("ellipsize", "end");
      }
      this.mNode.dirty();
      return;
    }
  }
  
  @Property("value")
  public void setText(String paramString)
  {
    addUIStyle("text", paramString);
    this.value = paramString;
    this.mNode.dirty();
  }
  
  @Property("color")
  public void set_color(String paramString)
  {
    this.color = paramString;
    addUIStyle("color", this.color);
  }
  
  public static class Provider
    implements IElement.IProvider<PTextElement, PTextView>
  {
    public PTextElement createElement(LayoutEngine paramLayoutEngine, int paramInt)
    {
      return new PTextElement(paramLayoutEngine, paramInt);
    }
    
    public PTextView createView()
    {
      return new PTextView();
    }
    
    public String getName()
    {
      return "text";
    }
  }
  
  public class ViewMeasureFunction
    implements PMeasureFunction
  {
    private boolean mIncludeFontPadding = true;
    private float mLineSpacingAdd = 0.0F;
    private float mLineSpacingMult = 1.0F;
    
    public ViewMeasureFunction() {}
    
    private Layout makeNewLayout(int paramInt1, BoringLayout.Metrics paramMetrics, int paramInt2, boolean paramBoolean)
    {
      int i = paramInt1;
      if (paramInt1 < 0) {
        i = 0;
      }
      if (PTextElement.this.mEllipsize != null) {}
      for (boolean bool = true;; bool = false) {
        return makeSingleLayout(i, paramMetrics, paramInt2, Layout.Alignment.ALIGN_NORMAL, bool, PTextElement.this.mEllipsize, paramBoolean);
      }
    }
    
    private Layout makeSingleLayout(int paramInt1, BoringLayout.Metrics paramMetrics, int paramInt2, Layout.Alignment paramAlignment, boolean paramBoolean1, TextUtils.TruncateAt paramTruncateAt, boolean paramBoolean2)
    {
      BoringLayout.Metrics localMetrics = paramMetrics;
      if (paramMetrics == PTextElement.UNKNOWN_BORING)
      {
        paramMetrics = BoringLayout.isBoring(PTextElement.this.value, PTextElement.textPaint, PTextElement.this.mBoring);
        localMetrics = paramMetrics;
        if (paramMetrics != null)
        {
          PTextElement.access$302(PTextElement.this, paramMetrics);
          localMetrics = paramMetrics;
        }
      }
      if (localMetrics != null)
      {
        if ((localMetrics.width <= paramInt1) && ((paramTruncateAt == null) || (localMetrics.width <= paramInt2))) {
          return BoringLayout.make(PTextElement.this.value, PTextElement.textPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, localMetrics, this.mIncludeFontPadding);
        }
        if ((paramBoolean1) && (localMetrics.width <= paramInt1)) {
          return BoringLayout.make(PTextElement.this.value, PTextElement.textPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, localMetrics, this.mIncludeFontPadding, paramTruncateAt, paramInt2);
        }
        if (paramBoolean1) {
          return StaticLayoutWithMaxLines.create(PTextElement.this.value, 0, PTextElement.this.value.length(), PTextElement.textPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding, paramTruncateAt, paramInt2, PTextElement.this.mMaxLines);
        }
        return new StaticLayout(PTextElement.this.value, PTextElement.textPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding);
      }
      if (paramBoolean1) {
        return StaticLayoutWithMaxLines.create(PTextElement.this.value, 0, PTextElement.this.value.length(), PTextElement.textPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding, paramTruncateAt, paramInt2, PTextElement.this.mMaxLines);
      }
      return new StaticLayout(PTextElement.this.value, PTextElement.textPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding);
    }
    
    public PMeasureFunction.MeasureValue onMeasure(PlatoNode paramPlatoNode, float paramFloat1, PMeasureMode paramPMeasureMode1, float paramFloat2, PMeasureMode paramPMeasureMode2)
    {
      PTextElement.textPaint.setTextSize(PTextElement.this.fontSize * DeviceInfo.mDensity);
      if (PTextElement.this.isBold) {
        PTextElement.textPaint.setTypeface(Typeface.DEFAULT_BOLD);
      }
      int i;
      while (paramPMeasureMode1 == PMeasureMode.EXACTLY)
      {
        i = (int)paramFloat1;
        paramPlatoNode = makeNewLayout(i, PTextElement.this.mBoring, i, false);
        if (paramPMeasureMode2 != PMeasureMode.EXACTLY) {
          break label211;
        }
        j = (int)paramFloat2;
        return new PMeasureFunction.MeasureValue(i, j);
        PTextElement.textPaint.setTypeface(Typeface.DEFAULT);
      }
      PTextElement.access$302(PTextElement.this, BoringLayout.isBoring(PTextElement.this.value, PTextElement.textPaint, PTextElement.UNKNOWN_BORING));
      if ((PTextElement.this.mBoring == null) || (PTextElement.this.mBoring == PTextElement.UNKNOWN_BORING)) {}
      for (int j = (int)Math.ceil(Layout.getDesiredWidth(PTextElement.this.value, PTextElement.textPaint));; j = PTextElement.this.mBoring.width)
      {
        i = j;
        if (paramPMeasureMode1 != PMeasureMode.AT_MOST) {
          break;
        }
        i = Math.min((int)paramFloat1, j);
        break;
      }
      label211:
      if (paramPlatoNode == null) {}
      for (int k = 0;; k = paramPlatoNode.getLineTop(Math.min(PTextElement.this.mMaxLines, paramPlatoNode.getLineCount())))
      {
        j = k;
        if (paramPMeasureMode2 != PMeasureMode.AT_MOST) {
          break;
        }
        j = Math.min((int)paramFloat2, k);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.element.PTextElement
 * JD-Core Version:    0.7.0.1
 */