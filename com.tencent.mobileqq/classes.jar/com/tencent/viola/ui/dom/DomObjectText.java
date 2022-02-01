package com.tencent.viola.ui.dom;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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
import android.util.Log;
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
import com.tencent.viola.ui.view.VTextView;
import com.tencent.viola.utils.ColorParseUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.ArrayList;
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
    int k = 0;
    Typeface localTypeface = this.mTextPaint.getTypeface();
    if (localTypeface == null) {}
    for (int j = 0;; j = localTypeface.getStyle())
    {
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
        if ((j & 0x2) != 0)
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
        if (localTypeface == null) {
          break;
        }
        this.mTextPaint.setTypeface(Typeface.create(localTypeface, paramInt2));
      }
      return;
    }
    this.mTextPaint.setTypeface(Typeface.defaultFromStyle(paramInt2));
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
        localSpannableString.setSpan(new DomObjectText.2(this, paramSpanText), 0, localSpannableString.length(), 33);
      }
      if ((localObject1 != null) && (((Style)localObject1).containsKey("fontSize")))
      {
        localSpannableString.setSpan(new AbsoluteSizeSpan(((Style)localObject1).getFontSize(getViewPortWidth())), 0, localSpannableString.length(), 33);
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
        if ((localObject1 == null) || (!((Style)localObject1).containsKey("lineHeight"))) {
          break label324;
        }
        localSpannableString.setSpan(new VLineHeightSpan(((Style)localObject1).getLineHeight(getViewPortWidth())), 0, localSpannableString.length(), 33);
      }
      for (;;)
      {
        if ((localObject1 != null) && (((Style)localObject1).containsKey("fontWeight"))) {
          localSpannableString.setSpan(new StyleSpan(((Style)localObject1).getFontWeight()), 0, localSpannableString.length(), 33);
        }
        ((Style)localObject1).getTextAlignment();
        ((Style)localObject1).getTextOverflow();
        ((Style)localObject1).getTextPaintAlign();
        return localSpannableString;
        if (this.mFontSize == -1) {
          break;
        }
        localSpannableString.setSpan(new AbsoluteSizeSpan(this.mFontSize), 0, localSpannableString.length(), 33);
        break;
        label324:
        if (this.mLineHeight != -1) {
          localSpannableString.setSpan(new VLineHeightSpan(this.mLineHeight), 0, localSpannableString.length(), 33);
        } else if ((localObject1 != null) && (((Style)localObject1).getFontSize(getViewPortWidth()) > 0)) {
          localSpannableString.setSpan(new VLineHeightSpan(((Style)localObject1).getFontSize(getViewPortWidth())), 0, localSpannableString.length(), 33);
        }
      }
    }
    Object localObject1 = Uri.parse(paramSpanText.src);
    Style localStyle = paramSpanText.style;
    try
    {
      Object localObject2 = new ColorDrawable(Color.parseColor("#00000000"));
      ((Drawable)localObject2).setBounds(0, 0, (int)localStyle.getWidth(getViewPortWidth()), (int)localStyle.getHeight(getViewPortWidth()));
      localObject2 = new VImgSpan(this, (Drawable)localObject2, paramSpanText.src, 1);
      this.mVImgSpanArr.add(localObject2);
      localSpannableString.setSpan(localObject2, 0, 1, 33);
      ((VImgSpan)localObject2).loadUrl(paramSpanText.src, (int)localStyle.getWidth(getViewPortWidth()), (int)localStyle.getHeight(getViewPortWidth()));
      return localSpannableString;
    }
    catch (Exception paramSpanText)
    {
      Log.e("DomObjectText", "Failed to loaded content " + localObject1, paramSpanText);
    }
    return localSpannableString;
  }
  
  private void applyTextDecoration()
  {
    switch (DomObjectText.3.$SwitchMap$com$tencent$viola$ui$dom$style$font$TextDecoration[this.mTextDecoration.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.mTextPaint.setUnderlineText(false);
      this.mTextPaint.setStrikeThruText(true);
      return;
    case 2: 
      this.mTextPaint.setUnderlineText(true);
      this.mTextPaint.setStrikeThruText(false);
      return;
    }
    this.mTextPaint.setUnderlineText(false);
    this.mTextPaint.setStrikeThruText(false);
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
    Object localObject;
    if (FloatUtils.floatsEqual(this.previousWidth, paramFloat))
    {
      localObject = paramLayout;
      if (paramLayout != null) {}
    }
    else
    {
      paramLayout = getStyle().get("direction");
      if (paramLayout != null) {
        paramLayout.equals("rtl");
      }
      if (!this.isRichText) {
        break label282;
      }
      paramLayout = this.mSpanned;
      localObject = new StaticLayout(paramLayout, this.mTextPaint, (int)Math.ceil(paramFloat), this.mAlignment, 1.0F, this.mLineSpacing, false);
    }
    if ((this.mNumberOfLines != -1) && (this.mNumberOfLines > 0) && (this.mNumberOfLines < ((Layout)localObject).getLineCount()))
    {
      int i = ((Layout)localObject).getLineStart(this.mNumberOfLines - 1);
      int j = ((Layout)localObject).getLineEnd(this.mNumberOfLines - 1);
      if (i < j)
      {
        if (i > 0) {
          if (this.isRichText)
          {
            paramLayout = new SpannableStringBuilder(this.mSpanned.subSequence(0, j));
            label187:
            if (!this.isRichText) {
              break label324;
            }
            if ((this.mSpanned.length() <= j) || (this.mTextOverflow == null)) {
              break label367;
            }
            paramLayout = new SpannableStringBuilder(this.mSpanned.subSequence(0, j - 1));
            paramLayout.append(richEllipsis("…", this.mEllipsisColor));
          }
        }
        label282:
        label324:
        label367:
        for (;;)
        {
          return new StaticLayout(paramLayout, this.mTextPaint, (int)Math.ceil(paramFloat), this.mAlignment, 1.0F, this.mLineSpacing, false);
          paramLayout = this.mTextSpan;
          break;
          paramLayout = new SpannableStringBuilder(this.mTextSpan.subSequence(0, i));
          break label187;
          paramLayout = new SpannableStringBuilder();
          break label187;
          paramLayout.append(truncate(new SpannableStringBuilder(this.mTextSpan.subSequence(i, j)), this.mTextPaint, (int)Math.ceil(paramFloat), this.mTextOverflow));
        }
      }
    }
    return localObject;
  }
  
  private SpanText genSpanText(JSONObject paramJSONObject, int paramInt)
  {
    int i = 0;
    SpanText localSpanText = new SpanText(this.mRef, paramInt);
    try
    {
      if (paramJSONObject.has("type"))
      {
        localSpanText.spanType = paramJSONObject.getString("type");
        Object localObject1;
        if ("text".equals(localSpanText.spanType))
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
          if (localObject2 != null) {
            localSpanText.text = ((VComponentAdapter)localObject2).setEmoticonText((CharSequence)localObject1, this.mFontSize);
          }
        }
        for (;;)
        {
          if (paramJSONObject.has("style")) {
            localSpanText.style = new Style(paramJSONObject.getJSONObject("style"));
          }
          if (!paramJSONObject.has("events")) {
            break;
          }
          paramJSONObject = paramJSONObject.get("events");
          if ((paramJSONObject == null) || (!(paramJSONObject instanceof JSONArray))) {
            break;
          }
          paramJSONObject = (JSONArray)paramJSONObject;
          int j = paramJSONObject.length();
          paramInt = i;
          while (paramInt < j)
          {
            localObject1 = paramJSONObject.get(paramInt);
            localSpanText.events.add(localObject1.toString());
            paramInt += 1;
          }
          localSpanText.text = ((CharSequence)localObject1);
          continue;
          if ("image".equals(localSpanText.spanType)) {
            localSpanText.src = paramJSONObject.getString("src");
          }
        }
        return localSpanText;
      }
      return null;
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
  
  public static Typeface getOrCreateTypeface(String paramString, int paramInt)
  {
    return Typeface.create(paramString, paramInt);
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
  
  private void updateSpanOrText()
  {
    int j = 0;
    Object localObject2;
    if (this.mAttributes.containsKey("value"))
    {
      localObject2 = this.mAttributes.get("value");
      if (localObject2 == null) {
        break label321;
      }
      if (!(localObject2 instanceof JSONArray)) {
        break label247;
      }
      this.isRichText = true;
    }
    try
    {
      localObject1 = (JSONArray)localObject2;
      localObject2 = new SpannableStringBuilder();
      i = 0;
    }
    catch (JSONException localJSONException2)
    {
      for (;;)
      {
        Object localObject1;
        int i;
        SpanText localSpanText;
        label247:
        continue;
        label321:
        i += 1;
      }
    }
    if (i < ((JSONArray)localObject1).length())
    {
      localSpanText = genSpanText(((JSONArray)localObject1).getJSONObject(i), i);
      if (localSpanText != null)
      {
        this.mSpanArr.add(localSpanText);
        ((SpannableStringBuilder)localObject2).append(applySpanTextStyle(localSpanText));
      }
    }
    else
    {
      ((SpannableStringBuilder)localObject2).append(new SpannableString(" "));
      this.mSpanned = ((Spanned)localObject2);
      for (;;)
      {
        if (this.mAttributes.containsKey("values"))
        {
          localObject1 = this.mAttributes.get("values");
          if ((localObject1 != null) && ((localObject1 instanceof JSONArray))) {
            this.isRichText = true;
          }
        }
        try
        {
          localObject1 = (JSONArray)localObject1;
          localObject2 = new SpannableStringBuilder();
          i = j;
          for (;;)
          {
            if (i < ((JSONArray)localObject1).length())
            {
              localSpanText = genSpanText(((JSONArray)localObject1).getJSONObject(i), i);
              if (localSpanText != null)
              {
                this.mSpanArr.add(localSpanText);
                ((SpannableStringBuilder)localObject2).append(applySpanTextStyle(localSpanText));
              }
              i += 1;
              continue;
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
              break;
              localObject1 = this.mAttributes.get("content");
              if (localObject1 == null) {
                break;
              }
              this.mText = localObject1.toString();
              this.mTextSpan = createSpanned(this.mText);
              break;
            }
          }
          ((SpannableStringBuilder)localObject2).append(new SpannableString(" "));
          this.mSpanned = ((Spanned)localObject2);
          return;
        }
        catch (JSONException localJSONException1) {}
      }
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
      if (localVComponentAdapter != null) {
        localCharSequence = localVComponentAdapter.setEmoticonText(paramCharSequence.toString(), this.mFontSize);
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
    if (this.atomicReference.get() == null) {
      ViolaLogUtils.d("DomObjectText", "getExtra is null and ref:" + getRef());
    }
    return this.atomicReference.get();
  }
  
  public int getLineSpace()
  {
    return this.mLineSpacing;
  }
  
  float getSpanTextWitdh(TextPaint paramTextPaint, float paramFloat, boolean paramBoolean)
  {
    if (this.mSpanned == null) {
      if (!paramBoolean) {}
    }
    float f;
    do
    {
      do
      {
        return paramFloat;
        return 0.0F;
      } while ((paramBoolean) && (getParent().getAlignItems() != FlexAlign.CENTER));
      f = Layout.getDesiredWidth(this.mSpanned, paramTextPaint);
    } while ((!FlexConstants.isUndefined(paramFloat)) && (f >= paramFloat));
    return f;
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
    float f1;
    if (this.isRichText) {
      f1 = getSpanTextWitdh(paramTextPaint, paramFloat, paramBoolean);
    }
    float f2;
    do
    {
      do
      {
        do
        {
          return f1;
          if (this.mText != null) {
            break;
          }
          f1 = paramFloat;
        } while (paramBoolean);
        return 0.0F;
        f1 = paramFloat;
      } while (paramBoolean);
      f2 = Layout.getDesiredWidth(this.mText, paramTextPaint);
      if (FlexConstants.isUndefined(paramFloat)) {
        break;
      }
      f1 = paramFloat;
    } while (f2 >= paramFloat);
    return f2;
  }
  
  public void imgSpanSetTv(VTextView paramVTextView)
  {
    if ((this.mVImgSpanArr != null) && (this.mVImgSpanArr.size() > 0))
    {
      int i = 0;
      while (i < this.mVImgSpanArr.size())
      {
        ((VImgSpan)this.mVImgSpanArr.get(i)).setTv(paramVTextView);
        i += 1;
      }
    }
  }
  
  public boolean isRichText()
  {
    return this.isRichText;
  }
  
  public void layoutAfter()
  {
    if (this.hasBeenMeasured) {
      if ((this.layout != null) && (!FloatUtils.floatsEqual(DomUtils.getContentWidth(this), this.previousWidth))) {
        recalculateLayout();
      }
    }
    for (;;)
    {
      this.hasBeenMeasured = false;
      if ((this.layout != null) && (!this.layout.equals(this.atomicReference.get())) && (Build.VERSION.SDK_INT >= 19) && (Thread.currentThread() != Looper.getMainLooper().getThread())) {
        warmUpTextLayoutCache(this.layout);
      }
      swap();
      super.layoutAfter();
      return;
      updateStyleAndText();
      recalculateLayout();
    }
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
      if ((this.mText != null) || (this.mSpanned != null))
      {
        this.layout = createLayout(f, true, this.layout);
        this.previousWidth = this.layout.getWidth();
      }
    }
    else {
      return;
    }
    this.previousWidth = 0.0F;
  }
  
  public void swap()
  {
    if (this.layout != null)
    {
      this.atomicReference.set(this.layout);
      this.layout = null;
      this.mTextPaint = new TextPaint(this.mTextPaint);
    }
    this.hasBeenMeasured = false;
  }
  
  public String toString()
  {
    String str = "ref:" + getRef() + " ; ";
    if (!TextUtils.isEmpty(this.mText)) {
      str = str + "mText:" + this.mText + " ; ";
    }
    for (;;)
    {
      str = str + "mSpanned :" + this.mSpanned + "; ";
      str = str + "isRichText :" + this.isRichText + "; ";
      return str + "mTextPaint :" + this.mTextPaint + "; ";
      if (!TextUtils.isEmpty(this.mSpanned)) {
        str = str + "mSpanned:" + this.mSpanned + "; ";
      } else {
        str = str + "mSpanned == null  && mText = null ; ";
      }
    }
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
    if (this.mLineHeight != -1) {
      paramSpannable.setSpan(new VLineHeightSpan(this.mLineHeight), 0, paramSpannable.length(), paramInt);
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
    int i;
    boolean bool;
    if (paramMap.containsKey("lines"))
    {
      i = paramMap.getLines();
      if (i > 0) {
        this.mNumberOfLines = i;
      }
    }
    else
    {
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
        if (this.mColor == -2147483648) {
          break label326;
        }
        bool = true;
        label176:
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
      i = paramMap.getLineHeight(j);
      if (i == -1) {
        break label332;
      }
    }
    label326:
    label332:
    for (this.mLineHeight = (i + (int)this.flexStyle.border.get(1) + (int)this.flexStyle.border.get(3));; this.mLineHeight = this.mFontSize)
    {
      i = paramMap.getLineSpacing(j);
      if (i != -1) {
        this.mLineSpacing = i;
      }
      i = paramMap.getLetterSpacing(j);
      if (i != -1) {
        this.mLetterSpacing = i;
      }
      applyTextPaint();
      return;
      i = -1;
      break;
      bool = false;
      break label176;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomObjectText
 * JD-Core Version:    0.7.0.1
 */