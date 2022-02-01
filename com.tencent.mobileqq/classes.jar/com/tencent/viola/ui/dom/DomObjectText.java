package com.tencent.viola.ui.dom;

import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.BidiFormatter;
import android.text.Editable;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.tencent.viola.adapter.VComponentAdapter;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.dom.style.FlexAlign;
import com.tencent.viola.ui.dom.style.FlexConstants;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.dom.style.FlexNode;
import com.tencent.viola.ui.dom.style.FlexNode.MeasureFunction;
import com.tencent.viola.ui.dom.style.FlexStyle;
import com.tencent.viola.ui.dom.style.FloatUtils;
import com.tencent.viola.ui.dom.style.StyleSpace;
import com.tencent.viola.ui.dom.style.font.TextDecoration;
import com.tencent.viola.utils.ColorParseUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DomObjectText
  extends DomObject
{
  private static final Canvas DUMMY_CANVAS = new Canvas();
  private static final String ELLIPSIS = "…";
  public static final String TAG = "DomObjectText";
  public FlexNode.MeasureFunction TEXT_MEASURE_FUNCTION = new DomObjectText.1(this);
  private AtomicReference<Layout> atomicReference = new AtomicReference();
  private boolean hasBeenMeasured = false;
  private ImageSpanLoadListener imageSpanLoadListener;
  public boolean isRichClickable = false;
  private boolean isRichText = false;
  @Nullable
  private Layout layout;
  private Layout.Alignment mAlignment;
  private int mColor = -16777216;
  private int mEllipsisColor = -16777216;
  private String mFontFamily;
  private int mFontSize = -1;
  private int mFontStyle = -1;
  private int mFontWeight = -1;
  private boolean mIsColorSet = false;
  private int mLetterSpacing = -1;
  private int mLineHeight = -1;
  private int mLineSpacing = FlexConvertUtils.dip2px(2);
  private int mNumberOfLines = -1;
  private List<SpanText> mSpanArr = new ArrayList();
  private Spanned mSpanned;
  private CharSequence mText;
  private TextDecoration mTextDecoration = TextDecoration.NONE;
  private TextUtils.TruncateAt mTextOverflow;
  private TextPaint mTextPaint = new TextPaint();
  private Paint.Align mTextPaintAlign;
  private Spanned mTextSpan;
  private List<VImgSpan> mVImgSpanArr = new ArrayList();
  private float previousWidth = (0.0F / 0.0F);
  
  public DomObjectText()
  {
    this.mTextPaint.setFlags(1);
    setMeasureFunction(this.TEXT_MEASURE_FUNCTION);
  }
  
  private void applyFontStyle(int paramInt1, int paramInt2, String paramString)
  {
    Typeface localTypeface = this.mTextPaint.getTypeface();
    int k = 0;
    int j;
    if (localTypeface == null) {
      j = 0;
    } else {
      j = localTypeface.getStyle();
    }
    int i;
    if (paramInt2 != 1)
    {
      i = k;
      if ((j & 0x1) != 0)
      {
        i = k;
        if (paramInt2 != -1) {}
      }
    }
    else
    {
      i = 1;
    }
    if (paramInt1 != 2)
    {
      paramInt2 = i;
      if ((0x2 & j) != 0)
      {
        paramInt2 = i;
        if (paramInt1 != -1) {}
      }
    }
    else
    {
      paramInt2 = i | 0x2;
    }
    VComponentAdapter localVComponentAdapter = ViolaSDKManager.getInstance().getComponentAdapter();
    if ((localVComponentAdapter == null) || (!localVComponentAdapter.useCustomFont(this.mTextPaint, paramString, paramInt2)))
    {
      if (paramString != null) {
        localTypeface = getOrCreateTypeface(paramString, paramInt2);
      }
      if (localTypeface != null)
      {
        this.mTextPaint.setTypeface(Typeface.create(localTypeface, paramInt2));
        return;
      }
      this.mTextPaint.setTypeface(Typeface.defaultFromStyle(paramInt2));
    }
  }
  
  private SpannableString applySpanTextStyle(SpanText paramSpanText)
  {
    SpannableString localSpannableString = new SpannableString(" ");
    if ("text".equals(paramSpanText.spanType))
    {
      localSpannableString = new SpannableString(paramSpanText.text);
      localObject1 = paramSpanText.style;
      if (paramSpanText.events.contains("click"))
      {
        this.isRichClickable = true;
        localSpannableString.setSpan(new ClickableSpanText(paramSpanText), 0, localSpannableString.length(), 33);
      }
      if ((localObject1 != null) && (((Style)localObject1).containsKey("fontSize")))
      {
        localSpannableString.setSpan(new AbsoluteSizeSpan(((Style)localObject1).getFontSize(getViewPortWidth())), 0, localSpannableString.length(), 33);
      }
      else
      {
        i = this.mFontSize;
        if (i != -1) {
          localSpannableString.setSpan(new AbsoluteSizeSpan(i), 0, localSpannableString.length(), 33);
        }
      }
      int j = this.mColor;
      int i = j;
      if (localObject1 != null)
      {
        i = j;
        if (((Style)localObject1).containsKey("color")) {
          i = ColorParseUtils.parseColor(((Style)localObject1).getTextColor());
        }
      }
      localSpannableString.setSpan(new ForegroundColorSpan(i), 0, localSpannableString.length(), 33);
      if ((localObject1 != null) && (((Style)localObject1).containsKey("lineHeight")))
      {
        localSpannableString.setSpan(new VLineHeightSpan(((Style)localObject1).getLineHeight(getViewPortWidth())), 0, localSpannableString.length(), 33);
      }
      else
      {
        i = this.mLineHeight;
        if (i != -1) {
          localSpannableString.setSpan(new VLineHeightSpan(i), 0, localSpannableString.length(), 33);
        } else if ((localObject1 != null) && (((Style)localObject1).getFontSize(getViewPortWidth()) > 0)) {
          localSpannableString.setSpan(new VLineHeightSpan(((Style)localObject1).getFontSize(getViewPortWidth())), 0, localSpannableString.length(), 33);
        }
      }
      if ((localObject1 != null) && (((Style)localObject1).containsKey("fontWeight"))) {
        localSpannableString.setSpan(new StyleSpan(((Style)localObject1).getFontWeight()), 0, localSpannableString.length(), 33);
      }
      ((Style)localObject1).getTextAlignment();
      ((Style)localObject1).getTextOverflow();
      ((Style)localObject1).getTextPaintAlign();
      return localSpannableString;
    }
    Object localObject1 = paramSpanText.style;
    try
    {
      localObject2 = getImgSpanSize((Style)localObject1);
      localObject1 = new VImgSpan(1, localObject2[0], localObject2[1], paramSpanText.resize, (Style)localObject1, this.imageSpanLoadListener);
      this.mVImgSpanArr.add(localObject1);
      localSpannableString.setSpan(localObject1, 0, localSpannableString.length(), 33);
      ((VImgSpan)localObject1).loadImageSpan(paramSpanText.src);
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Failed to loaded content ");
      ((StringBuilder)localObject2).append(paramSpanText.src);
      ((StringBuilder)localObject2).append(", e: ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      ViolaLogUtils.e("DomObjectText", ((StringBuilder)localObject2).toString());
    }
    if (paramSpanText.events.contains("click"))
    {
      this.isRichClickable = true;
      localSpannableString.setSpan(new ClickableSpanText(paramSpanText), 0, localSpannableString.length(), 33);
    }
    return localSpannableString;
  }
  
  private void applyTextDecoration()
  {
    int i = DomObjectText.2.$SwitchMap$com$tencent$viola$ui$dom$style$font$TextDecoration[this.mTextDecoration.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        this.mTextPaint.setUnderlineText(false);
        this.mTextPaint.setStrikeThruText(false);
        return;
      }
      this.mTextPaint.setUnderlineText(true);
      this.mTextPaint.setStrikeThruText(false);
      return;
    }
    this.mTextPaint.setUnderlineText(false);
    this.mTextPaint.setStrikeThruText(true);
  }
  
  private void applyTextPaint()
  {
    if (this.mFontSize == -1) {
      this.mFontSize = ((int)FlexConvertUtils.converPxByViewportToRealPx("12dp", getViewPortWidth()));
    }
    this.mTextPaint.setTextSize(this.mFontSize);
    this.mTextPaint.setColor(this.mColor);
    if ((this.mLetterSpacing != -1) && (Build.VERSION.SDK_INT >= 21)) {
      this.mTextPaint.setLetterSpacing(this.mLetterSpacing / this.mFontSize);
    }
    applyTextDecoration();
    applyFontStyle(this.mFontStyle, this.mFontWeight, this.mFontFamily);
  }
  
  @NonNull
  private Layout createLayout(float paramFloat, boolean paramBoolean, @Nullable Layout paramLayout)
  {
    paramFloat = getTextWidth(this.mTextPaint, paramFloat, paramBoolean);
    if ((FloatUtils.floatsEqual(this.previousWidth, paramFloat)) && (paramLayout != null)) {
      break label105;
    }
    paramLayout = getStyle().get("direction");
    if (paramLayout != null) {
      paramLayout.equals("rtl");
    }
    if (this.isRichText) {
      paramLayout = this.mSpanned;
    } else {
      paramLayout = this.mTextSpan;
    }
    paramLayout = new StaticLayout(paramLayout, this.mTextPaint, (int)Math.ceil(paramFloat), this.mAlignment, 1.0F, this.mLineSpacing, false);
    label105:
    int i = this.mNumberOfLines;
    if ((i != -1) && (i > 0) && (i < paramLayout.getLineCount()))
    {
      i = paramLayout.getLineStart(this.mNumberOfLines - 1);
      int j = paramLayout.getLineEnd(this.mNumberOfLines - 1);
      if (i < j)
      {
        if (getStyle().containsKey("lineBreakMargin"))
        {
          paramLayout = ellipsizeWithMargin(paramFloat);
          tryFireLineBreakChange(true);
        }
        else
        {
          paramLayout = innerCreateStaticLayout(i, j, paramFloat);
        }
        return paramLayout;
      }
    }
    else
    {
      tryFireLineBreakChange(false);
    }
    return paramLayout;
  }
  
  private StaticLayout ellipsizeWithMargin(float paramFloat)
  {
    Spanned localSpanned;
    if (this.isRichText) {
      localSpanned = this.mSpanned;
    } else {
      localSpanned = this.mTextSpan;
    }
    float f1 = 0.0F;
    if (!this.isRichText)
    {
      Rect localRect = new Rect();
      this.mTextPaint.getTextBounds("…", 0, 1, localRect);
      f1 = localRect.width();
    }
    float f2 = ViolaUtils.getFloat(getStyle().get("lineBreakMargin"));
    return new StaticLayout(new SpannableStringBuilder(TextUtils.ellipsize(localSpanned, this.mTextPaint, this.mNumberOfLines * paramFloat - f1 - f2, TextUtils.TruncateAt.END)), this.mTextPaint, (int)Math.ceil(paramFloat), this.mAlignment, 1.0F, this.mLineSpacing, false);
  }
  
  private SpanText genSpanText(JSONObject paramJSONObject, int paramInt)
  {
    SpanText localSpanText = new SpanText(this.mRef, paramInt);
    try
    {
      if (paramJSONObject.has("type"))
      {
        localSpanText.spanType = paramJSONObject.getString("type");
        boolean bool = "text".equals(localSpanText.spanType);
        paramInt = 0;
        Object localObject1;
        int i;
        if (bool)
        {
          Object localObject2 = paramJSONObject.getString("value");
          localObject1 = localObject2;
          if (Build.VERSION.SDK_INT > 18)
          {
            localObject1 = localObject2;
            if (TextDirectionHeuristics.FIRSTSTRONG_RTL.isRtl((CharSequence)localObject2, 0, ((CharSequence)localObject2).length())) {
              localObject1 = BidiFormatter.getInstance().unicodeWrap(((CharSequence)localObject2).toString(), TextDirectionHeuristics.LTR);
            }
          }
          localObject2 = ViolaSDKManager.getInstance().getComponentAdapter();
          if (localObject2 != null)
          {
            i = (int)ViolaUtils.getFaceSize(getStyle().get("emojiSize"), -1.0F);
            localSpanText.text = ((VComponentAdapter)localObject2).setEmoticonText((CharSequence)localObject1, this.mFontSize, i);
          }
          else
          {
            localSpanText.text = ((CharSequence)localObject1);
          }
        }
        else if ("image".equals(localSpanText.spanType))
        {
          localSpanText.src = paramJSONObject.getString("src");
          localSpanText.resize = ViolaUtils.getString(paramJSONObject.opt("resize"), "");
        }
        if (paramJSONObject.has("style")) {
          localSpanText.style = new Style(paramJSONObject.getJSONObject("style"));
        }
        if (paramJSONObject.has("events"))
        {
          paramJSONObject = paramJSONObject.get("events");
          if ((paramJSONObject != null) && ((paramJSONObject instanceof JSONArray)))
          {
            paramJSONObject = (JSONArray)paramJSONObject;
            i = paramJSONObject.length();
            while (paramInt < i)
            {
              localObject1 = paramJSONObject.get(paramInt);
              localSpanText.events.add(localObject1.toString());
              paramInt += 1;
            }
          }
        }
        return localSpanText;
      }
      return null;
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
  
  private int[] getImgSpanSize(Style paramStyle)
  {
    int j = (int)paramStyle.getWidth(getViewPortWidth());
    int k = (int)paramStyle.getHeight(getViewPortWidth());
    int i = j;
    if (j <= 0) {
      i = getStyle().getFontSize(getViewPortWidth());
    }
    j = k;
    if (k <= 0) {
      j = getStyle().getFontSize(getViewPortWidth());
    }
    return new int[] { i, j };
  }
  
  public static Typeface getOrCreateTypeface(String paramString, int paramInt)
  {
    return Typeface.create(paramString, paramInt);
  }
  
  private StaticLayout innerCreateStaticLayout(int paramInt1, int paramInt2, float paramFloat)
  {
    SpannableStringBuilder localSpannableStringBuilder1;
    if (paramInt1 > 0)
    {
      if (this.isRichText) {
        localSpannableStringBuilder1 = new SpannableStringBuilder(this.mSpanned.subSequence(0, paramInt2));
      } else {
        localSpannableStringBuilder1 = new SpannableStringBuilder(this.mTextSpan.subSequence(0, paramInt1));
      }
    }
    else {
      localSpannableStringBuilder1 = new SpannableStringBuilder();
    }
    SpannableStringBuilder localSpannableStringBuilder2;
    if (this.isRichText)
    {
      localSpannableStringBuilder2 = localSpannableStringBuilder1;
      if (this.mSpanned.length() > paramInt2)
      {
        localSpannableStringBuilder2 = localSpannableStringBuilder1;
        if (this.mTextOverflow != null)
        {
          localSpannableStringBuilder2 = new SpannableStringBuilder(this.mSpanned.subSequence(0, paramInt2 - 1));
          localSpannableStringBuilder2.append(richEllipsis("…", this.mEllipsisColor));
        }
      }
    }
    else
    {
      localSpannableStringBuilder1.append(truncate(new SpannableStringBuilder(this.mTextSpan.subSequence(paramInt1, paramInt2)), this.mTextPaint, (int)Math.ceil(paramFloat), TextUtils.TruncateAt.END));
      localSpannableStringBuilder2 = localSpannableStringBuilder1;
    }
    return new StaticLayout(localSpannableStringBuilder2, this.mTextPaint, (int)Math.ceil(paramFloat), this.mAlignment, 1.0F, this.mLineSpacing, false);
  }
  
  private SpannableString richEllipsis(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new SpannableString(paramString);
      paramString.setSpan(new ForegroundColorSpan(paramInt), 0, paramString.length(), 33);
      return paramString;
    }
    return new SpannableString("…");
  }
  
  @NonNull
  private Spanned truncate(@Nullable Editable paramEditable, @NonNull TextPaint paramTextPaint, int paramInt, @Nullable TextUtils.TruncateAt paramTruncateAt)
  {
    SpannedString localSpannedString = new SpannedString("");
    if ((!TextUtils.isEmpty(paramEditable)) && (paramEditable.length() > 0))
    {
      int j;
      int i;
      if (paramTruncateAt != null)
      {
        paramEditable.append("…");
        Object[] arrayOfObject = paramEditable.getSpans(0, paramEditable.length(), Object.class);
        j = arrayOfObject.length;
        i = 0;
        while (i < j)
        {
          Object localObject = arrayOfObject[i];
          int k = paramEditable.getSpanStart(localObject);
          int m = paramEditable.getSpanEnd(localObject);
          if ((k == 0) && (m == paramEditable.length() - 1))
          {
            paramEditable.removeSpan(localObject);
            paramEditable.setSpan(localObject, 0, paramEditable.length(), paramEditable.getSpanFlags(localObject));
          }
          i += 1;
        }
      }
      while (paramEditable.length() > 1)
      {
        j = paramEditable.length() - 1;
        i = j;
        if (paramTruncateAt != null) {
          i = j - 1;
        }
        paramEditable.delete(i, i + 1);
        if (new StaticLayout(paramEditable, paramTextPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, this.mLineSpacing, false).getLineCount() <= 1) {
          return paramEditable;
        }
      }
    }
    return localSpannedString;
  }
  
  private void tryFireLineBreakChange(boolean paramBoolean)
  {
    if (!getEvents().contains("lineBreakChange")) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    int i;
    if (paramBoolean) {
      i = 1;
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("isLineBreak", i);
        fireEvent("lineBreakChange", localJSONObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        ViolaLogUtils.e("DomObjectText", localJSONException.getMessage());
        return;
      }
      i = 0;
    }
  }
  
  private void updateSpanOrText()
  {
    boolean bool = this.mAttributes.containsKey("value");
    int j = 0;
    Object localObject2;
    if (bool)
    {
      localObject2 = this.mAttributes.get("value");
      if (localObject2 != null) {
        if ((localObject2 instanceof JSONArray)) {
          this.isRichText = true;
        }
      }
    }
    int i;
    try
    {
      localObject1 = (JSONArray)localObject2;
      localObject2 = new SpannableStringBuilder();
      i = 0;
      if (i < ((JSONArray)localObject1).length())
      {
        localSpanText = genSpanText(((JSONArray)localObject1).getJSONObject(i), i);
        if (localSpanText == null) {
          break label408;
        }
        this.mSpanArr.add(localSpanText);
        ((SpannableStringBuilder)localObject2).append(applySpanTextStyle(localSpanText));
        break label408;
      }
      ((SpannableStringBuilder)localObject2).append(new SpannableString(" "));
      this.mSpanned = ((Spanned)localObject2);
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        try
        {
          SpanText localSpanText;
          Object localObject1 = (JSONArray)localObject1;
          localObject2 = new SpannableStringBuilder();
          i = j;
          if (i < ((JSONArray)localObject1).length())
          {
            localSpanText = genSpanText(((JSONArray)localObject1).getJSONObject(i), i);
            if (localSpanText == null) {
              break;
            }
            this.mSpanArr.add(localSpanText);
            ((SpannableStringBuilder)localObject2).append(applySpanTextStyle(localSpanText));
            break;
          }
          ((SpannableStringBuilder)localObject2).append(new SpannableString(" "));
          this.mSpanned = ((Spanned)localObject2);
          return;
        }
        catch (JSONException localJSONException2)
        {
          return;
        }
        localJSONException1 = localJSONException1;
      }
    }
    break label263;
    localObject1 = localObject2;
    if (Build.VERSION.SDK_INT > 18)
    {
      localObject1 = localObject2;
      if (TextDirectionHeuristics.FIRSTSTRONG_RTL.isRtl(localObject2.toString(), 0, localObject2.toString().length())) {
        localObject1 = BidiFormatter.getInstance().unicodeWrap(localObject2.toString());
      }
    }
    this.mText = localObject1.toString();
    this.mTextSpan = createSpanned(localObject1.toString());
    break label263;
    localObject1 = this.mAttributes.get("content");
    if (localObject1 != null)
    {
      this.mText = localObject1.toString();
      this.mTextSpan = createSpanned(this.mText);
    }
    label263:
    if (this.mAttributes.containsKey("values"))
    {
      localObject1 = this.mAttributes.get("values");
      if ((localObject1 != null) && ((localObject1 instanceof JSONArray))) {
        this.isRichText = true;
      }
    }
    for (;;)
    {
      label408:
      i += 1;
      break;
      i += 1;
    }
  }
  
  private boolean warmUpTextLayoutCache(Layout paramLayout)
  {
    try
    {
      paramLayout.draw(DUMMY_CANVAS);
      return true;
    }
    catch (Exception paramLayout)
    {
      ViolaLogUtils.e("DomObjectText", paramLayout.getMessage());
    }
    return false;
  }
  
  @NonNull
  protected Spanned createSpanned(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      VComponentAdapter localVComponentAdapter = ViolaSDKManager.getInstance().getComponentAdapter();
      CharSequence localCharSequence = paramCharSequence;
      if (localVComponentAdapter != null)
      {
        int i = (int)ViolaUtils.getFaceSize(getStyle().get("emojiSize"), -1.0F);
        localCharSequence = localVComponentAdapter.setEmoticonText(paramCharSequence.toString(), this.mFontSize, i);
      }
      paramCharSequence = new SpannableString(localCharSequence);
      updateSpannable(paramCharSequence, 17);
      return paramCharSequence;
    }
    return new SpannableString("");
  }
  
  public void destroy()
  {
    super.destroy();
  }
  
  public Object getExtra()
  {
    if (this.atomicReference.get() == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getExtra is null and ref:");
      localStringBuilder.append(getRef());
      ViolaLogUtils.d("DomObjectText", localStringBuilder.toString());
    }
    return this.atomicReference.get();
  }
  
  public int getLineSpace()
  {
    return this.mLineSpacing;
  }
  
  float getSpanTextWitdh(TextPaint paramTextPaint, float paramFloat, boolean paramBoolean)
  {
    if (this.mSpanned == null)
    {
      if (paramBoolean) {
        return paramFloat;
      }
      return 0.0F;
    }
    if ((!paramBoolean) || (getParent().getAlignItems() == FlexAlign.CENTER))
    {
      float f2 = Layout.getDesiredWidth(this.mSpanned, paramTextPaint);
      f1 = f2;
      if (FlexConstants.isUndefined(paramFloat)) {
        break label69;
      }
      if (f2 < paramFloat) {
        return f2;
      }
    }
    float f1 = paramFloat;
    label69:
    return f1;
  }
  
  public Layout getTextLayout()
  {
    return this.layout;
  }
  
  public TextPaint getTextPaint()
  {
    return this.mTextPaint;
  }
  
  float getTextWidth(TextPaint paramTextPaint, float paramFloat, boolean paramBoolean)
  {
    if (this.isRichText) {
      return getSpanTextWitdh(paramTextPaint, paramFloat, paramBoolean);
    }
    CharSequence localCharSequence = this.mText;
    if (localCharSequence == null)
    {
      if (paramBoolean) {
        return paramFloat;
      }
      return 0.0F;
    }
    if (!paramBoolean)
    {
      float f2 = Layout.getDesiredWidth(localCharSequence, paramTextPaint);
      f1 = f2;
      if (FlexConstants.isUndefined(paramFloat)) {
        break label73;
      }
      if (f2 < paramFloat) {
        return f2;
      }
    }
    float f1 = paramFloat;
    label73:
    return f1;
  }
  
  public boolean isRichText()
  {
    return this.isRichText;
  }
  
  public void layoutAfter()
  {
    if (this.hasBeenMeasured)
    {
      if ((this.layout != null) && (!FloatUtils.floatsEqual(DomUtils.getContentWidth(this), this.previousWidth))) {
        recalculateLayout();
      }
    }
    else
    {
      updateStyleAndText();
      recalculateLayout();
    }
    this.hasBeenMeasured = false;
    Layout localLayout = this.layout;
    if ((localLayout != null) && (!localLayout.equals(this.atomicReference.get())) && (Build.VERSION.SDK_INT >= 19) && (Thread.currentThread() != Looper.getMainLooper().getThread())) {
      warmUpTextLayoutCache(this.layout);
    }
    swap();
    super.layoutAfter();
  }
  
  public void layoutBefore()
  {
    young();
    this.hasBeenMeasured = false;
    updateStyleAndText();
    if (hasNewLayout())
    {
      ViolaLogUtils.d("DomObjectText", "Previous csslayout was ignored! markLayoutSeen() never called");
      markUpdateSeen();
    }
    super.dirty();
    super.layoutBefore();
  }
  
  public void recalculateLayout()
  {
    float f = DomUtils.getContentWidth(this);
    if (f > 0.0F)
    {
      if ((this.mText == null) && (this.mSpanned == null))
      {
        this.previousWidth = 0.0F;
        return;
      }
      this.layout = createLayout(f, true, this.layout);
      this.previousWidth = this.layout.getWidth();
    }
  }
  
  public void setImageSpanLoadListener(ImageSpanLoadListener paramImageSpanLoadListener)
  {
    this.imageSpanLoadListener = paramImageSpanLoadListener;
    Iterator localIterator = this.mVImgSpanArr.iterator();
    while (localIterator.hasNext()) {
      ((VImgSpan)localIterator.next()).setImageSpanListener(paramImageSpanLoadListener);
    }
    this.mVImgSpanArr.clear();
  }
  
  public void swap()
  {
    Layout localLayout = this.layout;
    if (localLayout != null)
    {
      this.atomicReference.set(localLayout);
      this.layout = null;
      this.mTextPaint = new TextPaint(this.mTextPaint);
    }
    this.hasBeenMeasured = false;
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ref:");
    ((StringBuilder)localObject).append(getRef());
    ((StringBuilder)localObject).append(" ; ");
    localObject = ((StringBuilder)localObject).toString();
    if (!TextUtils.isEmpty(this.mText))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("mText:");
      localStringBuilder.append(this.mText);
      localStringBuilder.append(" ; ");
      localObject = localStringBuilder.toString();
    }
    else if (!TextUtils.isEmpty(this.mSpanned))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("mSpanned:");
      localStringBuilder.append(this.mSpanned);
      localStringBuilder.append("; ");
      localObject = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("mSpanned == null  && mText = null ; ");
      localObject = localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("mSpanned :");
    localStringBuilder.append(this.mSpanned);
    localStringBuilder.append("; ");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("isRichText :");
    localStringBuilder.append(this.isRichText);
    localStringBuilder.append("; ");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("mTextPaint :");
    localStringBuilder.append(this.mTextPaint);
    localStringBuilder.append("; ");
    return localStringBuilder.toString();
  }
  
  public void updateAttr(Map<String, Object> paramMap)
  {
    super.updateAttr(paramMap);
    if ((paramMap != null) && ((paramMap.containsKey("value")) || (paramMap.containsKey("values"))))
    {
      updateSpanOrText();
      recalculateLayout();
    }
    swap();
  }
  
  protected void updateSpannable(Spannable paramSpannable, int paramInt)
  {
    int i = this.mLineHeight;
    if (i != -1) {
      paramSpannable.setSpan(new VLineHeightSpan(i), 0, paramSpannable.length(), paramInt);
    }
  }
  
  public void updateStyle(Map<String, Object> paramMap)
  {
    swap();
    super.updateStyle(paramMap);
  }
  
  public void updateStyleAndText()
  {
    updateStyleImpl(getStyle());
    updateSpanOrText();
  }
  
  public void updateStyleImpl(Map<String, Object> paramMap)
  {
    super.updateStyleImpl(paramMap);
    if (paramMap.size() == 0)
    {
      applyTextPaint();
      return;
    }
    paramMap = getStyle();
    int j = getViewPortWidth();
    if (paramMap.containsKey("lines"))
    {
      i = paramMap.getLines();
      if (i <= 0) {
        i = -1;
      }
      this.mNumberOfLines = i;
    }
    this.mFontSize = paramMap.getFontSize(getViewPortWidth());
    if ((paramMap.containsKey("ellipsisColor")) && (!TextUtils.isEmpty(paramMap.getEllipsisColor()))) {
      this.mEllipsisColor = ColorParseUtils.parseColor(paramMap.getEllipsisColor());
    }
    if (paramMap.containsKey("fontWeight")) {
      this.mFontWeight = paramMap.getFontWeight();
    }
    if (paramMap.containsKey("fontStyle")) {
      this.mFontStyle = paramMap.getFontStyle();
    }
    if ((paramMap.containsKey("color")) && (!TextUtils.isEmpty(paramMap.getTextColor())))
    {
      this.mColor = ColorParseUtils.parseColor(paramMap.getTextColor());
      boolean bool;
      if (this.mColor != -2147483648) {
        bool = true;
      } else {
        bool = false;
      }
      this.mIsColorSet = bool;
    }
    if (paramMap.containsKey("textDecoration")) {
      this.mTextDecoration = paramMap.getTextDecoration();
    }
    if (paramMap.containsKey("fontFamily")) {
      this.mFontFamily = paramMap.getFontFamily();
    }
    this.mAlignment = paramMap.getTextAlignment();
    this.mTextOverflow = paramMap.getTextOverflow();
    this.mTextPaintAlign = paramMap.getTextPaintAlign();
    int i = paramMap.getLineHeight(j);
    if (i != -1) {
      this.mLineHeight = (i + (int)this.flexStyle.border.get(1) + (int)this.flexStyle.border.get(3));
    } else {
      this.mLineHeight = this.mFontSize;
    }
    i = paramMap.getLineSpacing(j);
    if (i != -1) {
      this.mLineSpacing = i;
    }
    i = paramMap.getLetterSpacing(j);
    if (i != -1) {
      this.mLetterSpacing = i;
    }
    applyTextPaint();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomObjectText
 * JD-Core Version:    0.7.0.1
 */