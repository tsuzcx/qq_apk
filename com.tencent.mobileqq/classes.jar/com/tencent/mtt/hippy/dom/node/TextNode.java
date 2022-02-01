package com.tencent.mtt.hippy.dom.node;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.DomManager;
import com.tencent.mtt.hippy.dom.a.g.a;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.text.HippyTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class TextNode
  extends StyleNode
{
  public static final int DEFAULT_TEXT_SHADOW_COLOR = 1426063360;
  private static final String ELLIPSIS = "…";
  public static final String IMAGE_SPAN_TEXT = "[img]";
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
  protected HippyImageLoader mImageAdapter;
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
  private WeakReference<HippyTextView> mTextViewWeakRefrence = null;
  protected TextUtils.TruncateAt mTruncateAt = TextUtils.TruncateAt.END;
  final TextPaint sTextPaintInstance = new TextPaint(1);
  
  public TextNode(boolean paramBoolean)
  {
    this.mIsVirtual = paramBoolean;
    if (!paramBoolean) {
      setMeasureFunction(TEXT_MEASURE_FUNCTION);
    }
  }
  
  private void createImageSpanOperation(List<TextNode.a> paramList, SpannableStringBuilder paramSpannableStringBuilder, ImageNode paramImageNode)
  {
    Object localObject = paramImageNode.getTotalProps();
    if ((localObject != null) && (((HippyMap)localObject).containsKey("src"))) {
      localObject = ((HippyMap)localObject).getString("src");
    } else {
      localObject = null;
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#00000000"));
    localColorDrawable.setBounds(0, 0, Math.round(paramImageNode.getStyleWidth()), Math.round(paramImageNode.getStyleHeight()));
    localObject = new c(localColorDrawable, (String)localObject, paramImageNode, this.mImageAdapter);
    paramImageNode.setImageSpan((c)localObject);
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append("[img]");
    int j = i + 5;
    paramList.add(new TextNode.a(i, j, localObject));
    if ((paramImageNode.getGestureTypes() != null) && (paramImageNode.getGestureTypes().size() > 0))
    {
      paramSpannableStringBuilder = new f(paramImageNode.getId(), true);
      paramSpannableStringBuilder.a(paramImageNode.getGestureTypes());
      paramList.add(new TextNode.a(i, j, paramSpannableStringBuilder));
    }
  }
  
  private Layout createLayout(float paramFloat, com.tencent.mtt.hippy.dom.a.f paramf)
  {
    TextPaint localTextPaint = this.sTextPaintInstance;
    Object localObject2 = this.mSpanned;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new SpannedString("");
    }
    Spanned localSpanned = (Spanned)localObject1;
    localObject1 = null;
    try
    {
      localObject2 = BoringLayout.isBoring(localSpanned, localTextPaint);
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("createLayout: ");
        localStringBuilder.append(localThrowable.getMessage());
        LogUtils.d("TextNode", localStringBuilder.toString());
      }
    }
    float f;
    if (localObject1 == null) {
      f = Layout.getDesiredWidth(localSpanned, localTextPaint);
    } else {
      f = (0.0F / 0.0F);
    }
    if ((paramf != com.tencent.mtt.hippy.dom.a.f.a) && (paramFloat >= 0.0F)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((localObject1 == null) && ((i != 0) || ((!com.tencent.mtt.hippy.dom.a.c.a(f)) && (f <= paramFloat)))) {
      paramf = new StaticLayout(localSpanned, localTextPaint, (int)Math.ceil(f), this.mTextAlign, 1.0F, 0.0F, true);
    } else if ((localObject1 != null) && ((i != 0) || (((BoringLayout.Metrics)localObject1).width <= paramFloat))) {
      paramf = BoringLayout.make(localSpanned, localTextPaint, ((BoringLayout.Metrics)localObject1).width, this.mTextAlign, 1.0F, 0.0F, (BoringLayout.Metrics)localObject1, true);
    } else {
      paramf = new StaticLayout(localSpanned, localTextPaint, (int)Math.ceil(paramFloat), this.mTextAlign, 1.0F, 0.0F, true);
    }
    int i = this.mNumberOfLines;
    localObject1 = paramf;
    if (i != -1)
    {
      localObject1 = paramf;
      if (i > 0)
      {
        i = paramf.getLineCount();
        int j = this.mNumberOfLines;
        localObject1 = paramf;
        if (i > j)
        {
          i = paramf.getLineStart(j - 1);
          j = paramf.getLineEnd(this.mNumberOfLines - 1);
          localObject1 = paramf;
          if (i < j) {
            localObject1 = createLayoutWithNumberOfLine(i, j, paramf.getWidth());
          }
        }
      }
    }
    ((Layout)localObject1).getPaint().setTextSize(this.mFontSize);
    return localObject1;
  }
  
  private StaticLayout createLayoutWithNumberOfLine(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = this.mSpanned;
    if (localObject1 == null) {
      return null;
    }
    localObject1 = ((SpannableStringBuilder)localObject1).toString();
    SpannableStringBuilder localSpannableStringBuilder = this.mSpanned;
    int i = ((String)localObject1).length();
    paramInt2 = 0;
    localSpannableStringBuilder = (SpannableStringBuilder)localSpannableStringBuilder.subSequence(0, i);
    Object localObject2 = (String)TextUtils.ellipsize(((String)localObject1).substring(paramInt1), this.sTextPaintInstance, paramInt3, TextUtils.TruncateAt.END);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((String)localObject1).subSequence(0, paramInt1).toString());
    localStringBuilder.append(truncate((String)localObject2, this.sTextPaintInstance, paramInt3, this.mTruncateAt));
    localObject2 = localStringBuilder.toString();
    if (((String)localObject2).length() - 1 >= 0) {
      paramInt1 = ((String)localObject2).length() - 1;
    } else {
      paramInt1 = 0;
    }
    localObject2 = (CharacterStyle[])localSpannableStringBuilder.getSpans(paramInt1, ((String)localObject1).length(), CharacterStyle.class);
    if ((localObject2 != null) && (localObject2.length > 0))
    {
      i = localObject2.length;
      while (paramInt2 < i)
      {
        localStringBuilder = localObject2[paramInt2];
        if (localSpannableStringBuilder.getSpanStart(localStringBuilder) >= paramInt1) {
          localSpannableStringBuilder.removeSpan(localStringBuilder);
        }
        paramInt2 += 1;
      }
    }
    return new StaticLayout(localSpannableStringBuilder.replace(paramInt1, ((String)localObject1).length(), "…"), this.sTextPaintInstance, paramInt3, this.mTextAlign, 1.0F, 0.0F, true);
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
        paramList.add(new TextNode.a(k, m, new d(paramTextNode.mLetterSpacing)));
      }
      int j = paramTextNode.mFontSize;
      if (j != -1)
      {
        paramCharSequence = paramTextNode.mFontScaleAdapter;
        i = j;
        if (paramCharSequence != null)
        {
          i = j;
          if (paramTextNode.mEnableScale) {
            i = (int)(j * paramCharSequence.getFontScale());
          }
        }
        paramList.add(new TextNode.a(k, m, new AbsoluteSizeSpan(i)));
      }
      if ((paramTextNode.mFontStyle != -1) || (paramTextNode.mFontWeight != -1) || (paramTextNode.mFontFamily != null)) {
        paramList.add(new TextNode.a(k, m, new h(paramTextNode.mFontStyle, paramTextNode.mFontWeight, paramTextNode.mFontFamily)));
      }
      if (paramTextNode.mIsUnderlineTextDecorationSet) {
        paramList.add(new TextNode.a(k, m, new UnderlineSpan()));
      }
      if (paramTextNode.mIsLineThroughTextDecorationSet) {
        paramList.add(new TextNode.a(k, m, new StrikethroughSpan()));
      }
      if ((paramTextNode.mTextShadowOffsetDx != 0.0F) || (paramTextNode.mTextShadowOffsetDy != 0.0F)) {
        paramList.add(new TextNode.a(k, m, new g(paramTextNode.mTextShadowOffsetDx, paramTextNode.mTextShadowOffsetDy, paramTextNode.mTextShadowRadius, paramTextNode.mTextShadowColor)));
      }
      float f2 = paramTextNode.mLineHeight;
      if (f2 != -1.0F)
      {
        paramCharSequence = paramTextNode.mFontScaleAdapter;
        float f1 = f2;
        if (paramCharSequence != null)
        {
          f1 = f2;
          if (paramTextNode.mEnableScale) {
            f1 = f2 * paramCharSequence.getFontScale();
          }
        }
        paramList.add(new TextNode.a(k, m, new e(f1)));
      }
      paramCharSequence = paramTextNode.mGestureTypes;
      if ((paramCharSequence != null) && (paramCharSequence.size() > 0))
      {
        paramCharSequence = new f(paramTextNode.getId(), isVirtual());
        paramCharSequence.a(paramTextNode.mGestureTypes);
        paramList.add(new TextNode.a(k, m, paramCharSequence));
      }
    }
    if (paramBoolean)
    {
      i = 0;
      while (i < paramTextNode.getChildCount())
      {
        b localb = paramTextNode.getChildAt(i);
        if ((localb instanceof TextNode))
        {
          TextNode localTextNode = (TextNode)localb;
          paramCharSequence = localTextNode.mText;
          if ((this.mFontScaleAdapter != null) && (!TextUtils.isEmpty(paramCharSequence)))
          {
            CharSequence localCharSequence = this.mFontScaleAdapter.getEmoticonText(paramCharSequence, localTextNode.mFontSize);
            if (localCharSequence != null) {
              paramCharSequence = localCharSequence;
            }
          }
          createSpanOperations(paramList, paramSpannableStringBuilder, localTextNode, paramCharSequence, paramBoolean);
        }
        else
        {
          if (!(localb instanceof ImageNode)) {
            break label684;
          }
          createImageSpanOperation(paramList, paramSpannableStringBuilder, (ImageNode)localb);
        }
        localb.markUpdateSeen();
        i += 1;
        continue;
        label684:
        paramList = new StringBuilder();
        paramList.append(localb.getViewClass());
        paramList.append("is not support in Text");
        throw new RuntimeException(paramList.toString());
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
    int i;
    if ("italic".equals(paramString)) {
      i = 2;
    } else if ("normal".equals(paramString)) {
      i = 0;
    } else {
      i = -1;
    }
    if (i != this.mFontStyle)
    {
      this.mFontStyle = i;
      markUpdated();
    }
  }
  
  @HippyControllerProps(name="fontWeight")
  public void fontWeight(String paramString)
  {
    int k = -1;
    int j;
    if (paramString != null) {
      j = parseArgument(paramString);
    } else {
      j = -1;
    }
    int i;
    if ((j < 500) && (!"bold".equals(paramString)))
    {
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
    else {
      i = 1;
    }
    if (i != this.mFontWeight)
    {
      this.mFontWeight = i;
      markUpdated();
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("measure:layoutAfter w: ");
      ((StringBuilder)localObject).append(getLayoutWidth());
      ((StringBuilder)localObject).append(" h: ");
      ((StringBuilder)localObject).append(getLayoutHeight());
      LogUtils.d("TextNode", ((StringBuilder)localObject).toString());
      localObject = createLayout(getLayoutWidth() - getPadding(0) - getPadding(2), com.tencent.mtt.hippy.dom.a.f.b);
      paramHippyEngineContext.getDomManager().a((Layout)localObject);
      setData(localObject);
    }
  }
  
  public void layoutBefore(HippyEngineContext paramHippyEngineContext)
  {
    super.layoutBefore(paramHippyEngineContext);
    if (this.mFontScaleAdapter == null) {
      this.mFontScaleAdapter = paramHippyEngineContext.getGlobalConfigs().getFontScaleAdapter();
    }
    if (this.mImageAdapter == null) {
      this.mImageAdapter = paramHippyEngineContext.getGlobalConfigs().getImageLoaderAdapter();
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
    float f;
    if (paramInt == -1) {
      f = -1.0F;
    } else {
      f = PixelUtil.dp2px(paramInt);
    }
    this.mLineHeight = f;
    markUpdated();
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
  
  public void postInvalidateDelayed(long paramLong)
  {
    WeakReference localWeakReference = this.mTextViewWeakRefrence;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((HippyTextView)this.mTextViewWeakRefrence.get()).postInvalidateDelayed(paramLong);
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
    if ((paramString != null) && (!"auto".equals(paramString)) && (!"left".equals(paramString)))
    {
      if ("right".equals(paramString))
      {
        paramString = Layout.Alignment.ALIGN_OPPOSITE;
        break label115;
      }
      if ("center".equals(paramString))
      {
        paramString = Layout.Alignment.ALIGN_CENTER;
        break label115;
      }
      if (!"justify".equals(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Invalid textAlign: ");
        localStringBuilder.append(paramString);
        throw new RuntimeException(localStringBuilder.toString());
      }
    }
    paramString = Layout.Alignment.ALIGN_NORMAL;
    label115:
    this.mTextAlign = paramString;
    markUpdated();
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
  
  public void setTextView(HippyTextView paramHippyTextView)
  {
    this.mTextViewWeakRefrence = new WeakReference(paramHippyTextView);
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
      while (i < j)
      {
        Object localObject = paramString[i];
        if ("underline".equals(localObject)) {
          this.mIsUnderlineTextDecorationSet = true;
        } else if ("line-through".equals(localObject)) {
          this.mIsLineThroughTextDecorationSet = true;
        }
        i += 1;
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
        if (paramTruncateAt != null)
        {
          int j;
          if (i > 1) {
            j = i - 1;
          } else {
            j = i;
          }
          ((StringBuilder)localObject).append(paramString, 0, j);
          ((StringBuilder)localObject).append("…");
        }
        else
        {
          ((StringBuilder)localObject).append(paramString, 0, i);
        }
        localObject = createSpan(((StringBuilder)localObject).toString(), false);
        if (new StaticLayout((CharSequence)localObject, paramTextPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() <= 1) {
          return localObject.toString();
        }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.TextNode
 * JD-Core Version:    0.7.0.1
 */