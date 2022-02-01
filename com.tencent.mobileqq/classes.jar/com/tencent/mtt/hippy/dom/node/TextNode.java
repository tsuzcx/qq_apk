package com.tencent.mtt.hippy.dom.node;

import android.os.Build.VERSION;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.DomManager;
import com.tencent.mtt.hippy.dom.a.g.a;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import java.util.ArrayList;
import java.util.List;

public class TextNode
  extends StyleNode
{
  public static final int DEFAULT_TEXT_SHADOW_COLOR = 1426063360;
  private static final String ELLIPSIS = "…";
  public static final String PROP_SHADOW_COLOR = "textShadowColor";
  public static final String PROP_SHADOW_OFFSET = "textShadowOffset";
  public static final String PROP_SHADOW_OFFSET_HEIGHT = "height";
  public static final String PROP_SHADOW_OFFSET_WIDTH = "width";
  public static final String PROP_SHADOW_RADIUS = "textShadowRadius";
  private static final g.a TEXT_MEASURE_FUNCTION = new TextNode.1();
  public static final int UNSET = -1;
  private int mBackgroundColor;
  private int mColor = -16777216;
  protected boolean mEnableScale = false;
  private String mFontFamily = null;
  protected HippyFontScaleAdapter mFontScaleAdapter;
  protected int mFontSize = (int)Math.ceil(PixelUtil.dp2px(14.0F));
  private int mFontStyle = -1;
  private int mFontWeight = -1;
  private ArrayList<String> mGestureTypes = null;
  private boolean mIsBackgroundColorSet = false;
  private boolean mIsLineThroughTextDecorationSet = false;
  private boolean mIsUnderlineTextDecorationSet = false;
  private final boolean mIsVirtual;
  private float mLetterSpacing = -1.0F;
  private float mLineHeight = -1.0F;
  protected int mNumberOfLines = -1;
  SpannableStringBuilder mSpanned;
  CharSequence mText;
  protected Layout.Alignment mTextAlign = Layout.Alignment.ALIGN_NORMAL;
  private int mTextShadowColor = 1426063360;
  private float mTextShadowOffsetDx = 0.0F;
  private float mTextShadowOffsetDy = 0.0F;
  private float mTextShadowRadius = 1.0F;
  protected TextUtils.TruncateAt mTruncateAt = TextUtils.TruncateAt.END;
  final TextPaint sTextPaintInstance = new TextPaint(1);
  
  public TextNode(boolean paramBoolean)
  {
    this.mIsVirtual = paramBoolean;
    if (!paramBoolean) {
      setMeasureFunction(TEXT_MEASURE_FUNCTION);
    }
  }
  
  private Layout createLayout(float paramFloat, com.tencent.mtt.hippy.dom.a.f paramf)
  {
    TextPaint localTextPaint = this.sTextPaintInstance;
    Object localObject;
    Spanned localSpanned;
    if (this.mSpanned == null)
    {
      localObject = new SpannedString("");
      localSpanned = (Spanned)localObject;
      localObject = null;
    }
    try
    {
      BoringLayout.Metrics localMetrics = BoringLayout.isBoring(localSpanned, localTextPaint);
      localObject = localMetrics;
    }
    catch (Throwable localThrowable)
    {
      label47:
      float f;
      label60:
      int i;
      label76:
      break label47;
    }
    if (localObject == null)
    {
      f = Layout.getDesiredWidth(localSpanned, localTextPaint);
      if ((paramf != com.tencent.mtt.hippy.dom.a.f.a) && (paramFloat >= 0.0F)) {
        break label238;
      }
      i = 1;
      if ((localObject != null) || ((i == 0) && ((com.tencent.mtt.hippy.dom.a.c.a(f)) || (f > paramFloat)))) {
        break label244;
      }
      paramf = new StaticLayout(localSpanned, localTextPaint, (int)Math.ceil(f), this.mTextAlign, 1.0F, 0.0F, true);
    }
    for (;;)
    {
      localObject = paramf;
      if (this.mNumberOfLines != -1)
      {
        localObject = paramf;
        if (this.mNumberOfLines > 0)
        {
          localObject = paramf;
          if (paramf.getLineCount() > this.mNumberOfLines)
          {
            i = paramf.getLineStart(this.mNumberOfLines - 1);
            int j = paramf.getLineEnd(this.mNumberOfLines - 1);
            localObject = paramf;
            if (i < j) {
              localObject = createLayoutWithNumberOfLine(i, j, paramf.getWidth());
            }
          }
        }
      }
      ((Layout)localObject).getPaint().setTextSize(this.mFontSize);
      return localObject;
      localObject = this.mSpanned;
      break;
      f = (0.0F / 0.0F);
      break label60;
      label238:
      i = 0;
      break label76;
      label244:
      if ((localObject != null) && ((i != 0) || (((BoringLayout.Metrics)localObject).width <= paramFloat))) {
        paramf = BoringLayout.make(localSpanned, localTextPaint, ((BoringLayout.Metrics)localObject).width, this.mTextAlign, 1.0F, 0.0F, (BoringLayout.Metrics)localObject, true);
      } else {
        paramf = new StaticLayout(localSpanned, localTextPaint, (int)paramFloat, this.mTextAlign, 1.0F, 0.0F, true);
      }
    }
  }
  
  private StaticLayout createLayoutWithNumberOfLine(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    if (this.mSpanned == null) {
      return null;
    }
    String str = this.mSpanned.toString();
    SpannableStringBuilder localSpannableStringBuilder = (SpannableStringBuilder)this.mSpanned.subSequence(0, str.length());
    Object localObject1 = str.subSequence(0, paramInt1).toString() + truncate(str.substring(paramInt1, paramInt2), this.sTextPaintInstance, paramInt3, this.mTruncateAt);
    if (((String)localObject1).length() - 1 >= 0) {}
    for (paramInt1 = ((String)localObject1).length() - 1;; paramInt1 = 0)
    {
      localObject1 = (CharacterStyle[])localSpannableStringBuilder.getSpans(paramInt1, str.length(), CharacterStyle.class);
      if ((localObject1 == null) || (localObject1.length <= 0)) {
        break;
      }
      int j = localObject1.length;
      paramInt2 = i;
      while (paramInt2 < j)
      {
        Object localObject2 = localObject1[paramInt2];
        if (localSpannableStringBuilder.getSpanStart(localObject2) >= paramInt1) {
          localSpannableStringBuilder.removeSpan(localObject2);
        }
        paramInt2 += 1;
      }
    }
    return new StaticLayout(localSpannableStringBuilder.replace(paramInt1, str.length(), "…"), this.sTextPaintInstance, paramInt3, this.mTextAlign, 1.0F, 0.0F, true);
  }
  
  private SpannableStringBuilder createSpan(CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramCharSequence != null)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      ArrayList localArrayList = new ArrayList();
      createSpanOperations(localArrayList, localSpannableStringBuilder, this, paramCharSequence, paramBoolean);
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((TextNode.a)localArrayList.get(i)).a(localSpannableStringBuilder);
        i -= 1;
      }
      createCustomSpan(paramCharSequence, localSpannableStringBuilder);
      return localSpannableStringBuilder;
    }
    return new SpannableStringBuilder("");
  }
  
  private void createSpanOperations(List<TextNode.a> paramList, SpannableStringBuilder paramSpannableStringBuilder, TextNode paramTextNode, CharSequence paramCharSequence, boolean paramBoolean)
  {
    int k = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(paramCharSequence);
    int m = paramSpannableStringBuilder.length();
    int i;
    if (k <= m)
    {
      paramList.add(new TextNode.a(k, m, new ForegroundColorSpan(paramTextNode.mColor)));
      if (paramTextNode.mIsBackgroundColorSet) {
        paramList.add(new TextNode.a(k, m, new BackgroundColorSpan(paramTextNode.mBackgroundColor)));
      }
      if ((paramTextNode.mLetterSpacing != -1.0F) && (Build.VERSION.SDK_INT >= 21)) {
        paramList.add(new TextNode.a(k, m, new c(paramTextNode.mLetterSpacing)));
      }
      if (paramTextNode.mFontSize != -1)
      {
        int j = paramTextNode.mFontSize;
        i = j;
        if (paramTextNode.mFontScaleAdapter != null)
        {
          i = j;
          if (paramTextNode.mEnableScale) {
            i = (int)(j * paramTextNode.mFontScaleAdapter.getFontScale());
          }
        }
        paramList.add(new TextNode.a(k, m, new AbsoluteSizeSpan(i)));
      }
      if ((paramTextNode.mFontStyle != -1) || (paramTextNode.mFontWeight != -1) || (paramTextNode.mFontFamily != null)) {
        paramList.add(new TextNode.a(k, m, new g(paramTextNode.mFontStyle, paramTextNode.mFontWeight, paramTextNode.mFontFamily)));
      }
      if (paramTextNode.mIsUnderlineTextDecorationSet) {
        paramList.add(new TextNode.a(k, m, new UnderlineSpan()));
      }
      if (paramTextNode.mIsLineThroughTextDecorationSet) {
        paramList.add(new TextNode.a(k, m, new StrikethroughSpan()));
      }
      if ((paramTextNode.mTextShadowOffsetDx != 0.0F) || (paramTextNode.mTextShadowOffsetDy != 0.0F)) {
        paramList.add(new TextNode.a(k, m, new f(paramTextNode.mTextShadowOffsetDx, paramTextNode.mTextShadowOffsetDy, paramTextNode.mTextShadowRadius, paramTextNode.mTextShadowColor)));
      }
      if (paramTextNode.mLineHeight != -1.0F)
      {
        float f2 = paramTextNode.mLineHeight;
        float f1 = f2;
        if (paramTextNode.mFontScaleAdapter != null)
        {
          f1 = f2;
          if (paramTextNode.mEnableScale) {
            f1 = f2 * paramTextNode.mFontScaleAdapter.getFontScale();
          }
        }
        paramList.add(new TextNode.a(k, m, new d(f1)));
      }
      if ((paramTextNode.mGestureTypes != null) && (paramTextNode.mGestureTypes.size() > 0))
      {
        paramCharSequence = new e(paramTextNode.getId(), isVirtual());
        paramCharSequence.a(paramTextNode.mGestureTypes);
        paramList.add(new TextNode.a(k, m, paramCharSequence));
      }
    }
    if (paramBoolean)
    {
      i = 0;
      while (i < paramTextNode.getChildCount())
      {
        paramCharSequence = paramTextNode.getChildAt(i);
        if ((paramCharSequence instanceof TextNode))
        {
          createSpanOperations(paramList, paramSpannableStringBuilder, (TextNode)paramCharSequence, ((TextNode)paramCharSequence).mText, paramBoolean);
          paramCharSequence.markUpdateSeen();
          i += 1;
        }
        else
        {
          throw new RuntimeException(paramCharSequence.getViewClass() + "is not support in Text");
        }
      }
    }
  }
  
  private static int parseArgument(String paramString)
  {
    if ((paramString.length() == 3) && (paramString.endsWith("00")) && (paramString.charAt(0) <= '9') && (paramString.charAt(0) >= '1')) {
      return (paramString.charAt(0) - '0') * 100;
    }
    return -1;
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onClick")
  public void clickEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mGestureTypes == null) {
        this.mGestureTypes = new ArrayList();
      }
      this.mGestureTypes.add("onClick");
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="color")
  public void color(Integer paramInteger)
  {
    this.mColor = paramInteger.intValue();
    markUpdated();
  }
  
  protected void createCustomSpan(CharSequence paramCharSequence, Spannable paramSpannable) {}
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="enableScale")
  public void enableScale(boolean paramBoolean)
  {
    this.mEnableScale = paramBoolean;
    markUpdated();
  }
  
  public boolean enableScale()
  {
    return this.mEnableScale;
  }
  
  @HippyControllerProps(name="fontFamily")
  public void fontFamily(String paramString)
  {
    this.mFontFamily = paramString;
    markUpdated();
  }
  
  @HippyControllerProps(defaultNumber=14.0D, defaultType="number", name="fontSize")
  public void fontSize(float paramFloat)
  {
    this.mFontSize = ((int)Math.ceil(PixelUtil.dp2px(paramFloat)));
    markUpdated();
  }
  
  @HippyControllerProps(defaultString="normal", defaultType="string", name="fontStyle")
  public void fontStyle(String paramString)
  {
    int i = -1;
    if ("italic".equals(paramString)) {
      i = 2;
    }
    for (;;)
    {
      if (i != this.mFontStyle)
      {
        this.mFontStyle = i;
        markUpdated();
      }
      return;
      if ("normal".equals(paramString)) {
        i = 0;
      }
    }
  }
  
  @HippyControllerProps(name="fontWeight")
  public void fontWeight(String paramString)
  {
    int k = -1;
    int j;
    int i;
    if (paramString != null)
    {
      j = parseArgument(paramString);
      if ((j < 500) && (!"bold".equals(paramString))) {
        break label54;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != this.mFontWeight)
      {
        this.mFontWeight = i;
        markUpdated();
      }
      return;
      j = -1;
      break;
      label54:
      if (!"normal".equals(paramString))
      {
        i = k;
        if (j != -1)
        {
          i = k;
          if (j >= 500) {}
        }
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public Spannable getSpan()
  {
    return this.mSpanned;
  }
  
  public boolean isVirtual()
  {
    return this.mIsVirtual;
  }
  
  public void layoutAfter(HippyEngineContext paramHippyEngineContext)
  {
    if (!isVirtual())
    {
      LogUtils.d("TextNode", "measure:layoutAfter w: " + getLayoutWidth() + " h: " + getLayoutHeight());
      Layout localLayout = createLayout(getLayoutWidth() - getPadding(0) - getPadding(2), com.tencent.mtt.hippy.dom.a.f.b);
      paramHippyEngineContext.getDomManager().a(localLayout);
      setData(localLayout);
    }
  }
  
  public void layoutBefore(HippyEngineContext paramHippyEngineContext)
  {
    super.layoutBefore(paramHippyEngineContext);
    if (this.mFontScaleAdapter == null) {
      this.mFontScaleAdapter = paramHippyEngineContext.getGlobalConfigs().getFontScaleAdapter();
    }
    if (this.mIsVirtual) {
      return;
    }
    if ((this.mFontScaleAdapter != null) && (!TextUtils.isEmpty(this.mText)))
    {
      paramHippyEngineContext = this.mFontScaleAdapter.getEmoticonText(this.mText, this.mFontSize);
      if (paramHippyEngineContext != null) {
        this.mText = paramHippyEngineContext;
      }
    }
    this.mSpanned = createSpan(this.mText, true);
  }
  
  @HippyControllerProps(defaultNumber=-1.0D, defaultType="number", name="letterSpacing")
  public void letterSpacing(float paramFloat)
  {
    if (paramFloat != -1.0F)
    {
      this.mLetterSpacing = PixelUtil.dp2px(paramFloat);
      markUpdated();
    }
  }
  
  @HippyControllerProps(defaultNumber=-1.0D, defaultType="number", name="lineHeight")
  public void lineHeight(int paramInt)
  {
    if (paramInt == -1) {}
    for (float f = -1.0F;; f = PixelUtil.dp2px(paramInt))
    {
      this.mLineHeight = f;
      markUpdated();
      return;
    }
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onLongClick")
  public void longClickEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mGestureTypes == null) {
        this.mGestureTypes = new ArrayList();
      }
      this.mGestureTypes.add("onLongClick");
    }
  }
  
  public void markUpdated()
  {
    super.markUpdated();
    if (!this.mIsVirtual) {
      super.dirty();
    }
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onPressIn")
  public void pressInEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mGestureTypes == null) {
        this.mGestureTypes = new ArrayList();
      }
      this.mGestureTypes.add("onPressIn");
    }
  }
  
  @HippyControllerProps(name="onPressOut")
  public void pressOutEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mGestureTypes == null) {
        this.mGestureTypes = new ArrayList();
      }
      this.mGestureTypes.add("onPressOut");
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="numberOfLines")
  public void setNumberOfLines(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = -1;
    }
    this.mNumberOfLines = i;
    markUpdated();
  }
  
  @HippyControllerProps(defaultString="left", defaultType="string", name="textAlign")
  public void setTextAlign(String paramString)
  {
    if ((paramString == null) || ("auto".equals(paramString))) {
      this.mTextAlign = Layout.Alignment.ALIGN_NORMAL;
    }
    for (;;)
    {
      markUpdated();
      return;
      if ("left".equals(paramString))
      {
        this.mTextAlign = Layout.Alignment.ALIGN_NORMAL;
      }
      else if ("right".equals(paramString))
      {
        this.mTextAlign = Layout.Alignment.ALIGN_OPPOSITE;
      }
      else if ("center".equals(paramString))
      {
        this.mTextAlign = Layout.Alignment.ALIGN_CENTER;
      }
      else
      {
        if (!"justify".equals(paramString)) {
          break;
        }
        this.mTextAlign = Layout.Alignment.ALIGN_NORMAL;
      }
    }
    throw new RuntimeException("Invalid textAlign: " + paramString);
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="textShadowColor")
  public void setTextShadowColor(int paramInt)
  {
    if (paramInt != this.mTextShadowColor)
    {
      this.mTextShadowColor = paramInt;
      markUpdated();
    }
  }
  
  @HippyControllerProps(name="text")
  public void text(String paramString)
  {
    this.mText = paramString;
    markUpdated();
  }
  
  @HippyControllerProps(name="textDecorationLine")
  public void textDecorationLine(String paramString)
  {
    int i = 0;
    this.mIsUnderlineTextDecorationSet = false;
    this.mIsLineThroughTextDecorationSet = false;
    if (paramString != null)
    {
      paramString = paramString.split(" ");
      int j = paramString.length;
      if (i < j)
      {
        Object localObject = paramString[i];
        if ("underline".equals(localObject)) {
          this.mIsUnderlineTextDecorationSet = true;
        }
        for (;;)
        {
          i += 1;
          break;
          if ("line-through".equals(localObject)) {
            this.mIsLineThroughTextDecorationSet = true;
          }
        }
      }
    }
    markUpdated();
  }
  
  @HippyControllerProps(name="textShadowOffset")
  public void textShadowOffset(HippyMap paramHippyMap)
  {
    this.mTextShadowOffsetDx = 0.0F;
    this.mTextShadowOffsetDy = 0.0F;
    if (paramHippyMap != null)
    {
      if (paramHippyMap.get("width") != null) {
        this.mTextShadowOffsetDx = PixelUtil.dp2px(paramHippyMap.getDouble("width"));
      }
      if (paramHippyMap.get("height") != null) {
        this.mTextShadowOffsetDy = PixelUtil.dp2px(paramHippyMap.getDouble("height"));
      }
    }
    markUpdated();
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="textShadowRadius")
  public void textShadowRadius(float paramFloat)
  {
    if (paramFloat != this.mTextShadowRadius)
    {
      this.mTextShadowRadius = paramFloat;
      markUpdated();
    }
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onTouchCancel")
  public void touchCancelable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mGestureTypes == null) {
        this.mGestureTypes = new ArrayList();
      }
      this.mGestureTypes.add("onTouchCancel");
    }
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onTouchDown")
  public void touchDownEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mGestureTypes == null) {
        this.mGestureTypes = new ArrayList();
      }
      this.mGestureTypes.add("onTouchDown");
    }
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onTouchEnd")
  public void touchEndEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mGestureTypes == null) {
        this.mGestureTypes = new ArrayList();
      }
      this.mGestureTypes.add("onTouchEnd");
    }
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onTouchMove")
  public void touchUpEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mGestureTypes == null) {
        this.mGestureTypes = new ArrayList();
      }
      this.mGestureTypes.add("onTouchMove");
    }
  }
  
  public String truncate(String paramString, TextPaint paramTextPaint, int paramInt, TextUtils.TruncateAt paramTruncateAt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.length();
      while (i > 0)
      {
        Object localObject = new StringBuilder(i + 1);
        int j;
        if (paramTruncateAt != null) {
          if (i > 1)
          {
            j = i - 1;
            ((StringBuilder)localObject).append(paramString, 0, j);
            ((StringBuilder)localObject).append("…");
          }
        }
        for (;;)
        {
          localObject = createSpan(((StringBuilder)localObject).toString(), false);
          if (new StaticLayout((CharSequence)localObject, paramTextPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() > 1) {
            break label128;
          }
          return localObject.toString();
          j = i;
          break;
          ((StringBuilder)localObject).append(paramString, 0, i);
        }
        label128:
        i -= 1;
      }
    }
    return "";
  }
  
  public void updateProps(HippyMap paramHippyMap)
  {
    super.updateProps(paramHippyMap);
    paramHippyMap = (HippyMap)paramHippyMap.get("style");
    if ((paramHippyMap != null) && (paramHippyMap.get("color") == null)) {
      paramHippyMap.pushInt("color", -16777216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.TextNode
 * JD-Core Version:    0.7.0.1
 */