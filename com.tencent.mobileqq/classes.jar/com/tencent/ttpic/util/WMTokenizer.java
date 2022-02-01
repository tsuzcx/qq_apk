package com.tencent.ttpic.util;

import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class WMTokenizer
{
  private static final int ALIGN_BOTTOM = 4;
  private static final int ALIGN_CENTER = 1;
  private static final int ALIGN_LEFT = 0;
  private static final int ALIGN_RIGHT = 2;
  private static final int ALIGN_TOP = 3;
  private static final String ELLIPSIZE = "...";
  private static final String STRING_EMPTY = "";
  private static final String TAG = "WMTokenizer";
  protected int mAlignMode;
  private float mCharHeight;
  private float mCharWidth;
  private boolean mFitIn;
  protected int mHeight;
  protected TextPaint mPaint;
  protected boolean mSingleLine;
  protected float mSpacingPlus;
  protected String mText;
  private RectF mTextRect;
  private float[] mTextWidths;
  private ArrayList<WMTokenizer.Token> mTokens = new ArrayList();
  protected boolean mVertical;
  protected int mWidth;
  
  public WMTokenizer(String paramString, TextPaint paramTextPaint)
  {
    this.mText = paramString;
    this.mPaint = paramTextPaint;
  }
  
  public static WMTokenizer from(String paramString, TextPaint paramTextPaint)
  {
    return new WMTokenizer(paramString, paramTextPaint);
  }
  
  private boolean isDelimiter(char paramChar)
  {
    return (paramChar == '\n') || (paramChar == '\r') || (paramChar == '\t') || (paramChar == ' ') || (paramChar == ',') || (paramChar == '.') || (paramChar == 65292) || (paramChar == '。');
  }
  
  private void tokenizeHorizontal()
  {
    if (this.mSingleLine)
    {
      tokenizerHorizontalSingleRow();
      return;
    }
    tokenizerHorizontalMultiRow();
  }
  
  private void tokenizerHorizontalMultiRow()
  {
    if ((this.mWidth <= 0) || (TextUtils.isEmpty(this.mText))) {
      LogUtils.e(TAG, "ERROR => mWidth <= 0 || TextUtils.isEmpty(mText)");
    }
    int i = 0;
    int k = 0;
    float f1 = 0.0F;
    int j = i;
    for (;;)
    {
      if (j >= this.mText.length()) {
        break label230;
      }
      localObject1 = this.mTextWidths;
      f1 += localObject1[j];
      if (f1 > this.mWidth)
      {
        f1 -= localObject1[j];
        int m = j - 1;
        for (;;)
        {
          i = j;
          if (m <= k) {
            break;
          }
          if (isDelimiter(this.mText.charAt(m)))
          {
            i = m + 1;
            break;
          }
          f1 -= this.mTextWidths[m];
          m -= 1;
        }
        localObject1 = this.mText.substring(k, i);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          LogUtils.e(TAG, "ERROR => TextUtils.isEmpty(textRow)");
        }
        localObject2 = new WMTokenizer.Token(this);
        ((WMTokenizer.Token)localObject2).text = ((String)localObject1);
        ((WMTokenizer.Token)localObject2).width = f1;
        ((WMTokenizer.Token)localObject2).height = this.mCharHeight;
        this.mTokens.add(localObject2);
        k = i;
        break;
      }
      f1 += this.mSpacingPlus;
      j += 1;
    }
    label230:
    if (k < this.mText.length())
    {
      localObject1 = new WMTokenizer.Token(this);
      ((WMTokenizer.Token)localObject1).text = this.mText.substring(k);
      ((WMTokenizer.Token)localObject1).width = f1;
      ((WMTokenizer.Token)localObject1).height = this.mCharHeight;
      this.mTokens.add(localObject1);
    }
    boolean bool;
    if ((this.mHeight > 0) && (this.mTokens.size() * this.mCharHeight > this.mHeight)) {
      bool = false;
    } else {
      bool = true;
    }
    this.mFitIn = bool;
    i = this.mHeight;
    if (i > 0)
    {
      f1 = i;
      float f2 = this.mCharHeight;
      if (f1 >= f2)
      {
        i = (int)(i / f2);
        if (this.mTokens.size() > i)
        {
          localObject1 = (WMTokenizer.Token)this.mTokens.get(i - 1);
          if (((WMTokenizer.Token)localObject1).text.length() > 3)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((WMTokenizer.Token)localObject1).text.substring(0, ((WMTokenizer.Token)localObject1).text.length() - 3));
            ((StringBuilder)localObject2).append("...");
            ((WMTokenizer.Token)localObject1).text = ((StringBuilder)localObject2).toString();
          }
        }
        while (this.mTokens.size() > i) {
          this.mTokens.remove(i);
        }
      }
    }
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("mTokens => ");
    ((StringBuilder)localObject2).append(this.mTokens.toString());
    LogUtils.d((String)localObject1, ((StringBuilder)localObject2).toString());
  }
  
  private void tokenizerHorizontalSingleRow()
  {
    if ((this.mWidth <= 0) || (TextUtils.isEmpty(this.mText))) {
      LogUtils.e(TAG, "ERROR => mWidth <= 0 || TextUtils.isEmpty(mText)");
    }
    int i = 0;
    float f = 0.0F;
    while (i < this.mText.length())
    {
      localObject1 = this.mTextWidths;
      f += localObject1[i];
      if (f > this.mWidth)
      {
        f -= localObject1[i];
        j = i - 1;
        i = 1;
        break label101;
      }
      f += this.mSpacingPlus;
      i += 1;
    }
    int k = 0;
    int j = i;
    i = k;
    label101:
    k = this.mHeight;
    boolean bool;
    if (((k <= 0) || (k >= this.mCharHeight)) && (i == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    this.mFitIn = bool;
    Object localObject1 = new WMTokenizer.Token(this);
    if (j >= this.mText.length())
    {
      ((WMTokenizer.Token)localObject1).text = this.mText;
    }
    else if (j > 1)
    {
      localObject2 = this.mText.substring(0, j - 1 + 1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("...");
      localObject2 = localStringBuilder.toString();
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        LogUtils.e(TAG, "ERROR => TextUtils.isEmpty(text2Draw)");
      }
      ((WMTokenizer.Token)localObject1).text = ((String)localObject2);
    }
    else
    {
      ((WMTokenizer.Token)localObject1).text = this.mText;
    }
    ((WMTokenizer.Token)localObject1).width = f;
    ((WMTokenizer.Token)localObject1).height = this.mCharHeight;
    this.mTokens.add(localObject1);
    localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("mTokens => ");
    ((StringBuilder)localObject2).append(this.mTokens.toString());
    LogUtils.d((String)localObject1, ((StringBuilder)localObject2).toString());
  }
  
  private void tokenizerVertical()
  {
    if (this.mSingleLine)
    {
      tokenizerVerticalSingleColumn();
      return;
    }
    tokenizerVerticalMultiColumn();
  }
  
  private void tokenizerVerticalMultiColumn()
  {
    if ((this.mHeight <= 0) || (TextUtils.isEmpty(this.mText))) {
      LogUtils.e(TAG, "ERROR => mHeight <= 0 || TextUtils.isEmpty(mText)");
    }
    int i = 0;
    int k = 0;
    float f1 = 0.0F;
    int j = i;
    float f2;
    for (;;)
    {
      if (j >= this.mText.length()) {
        break label211;
      }
      f2 = this.mCharHeight;
      f1 += f2;
      if (f1 > this.mHeight)
      {
        f1 -= f2;
        int m = j - 1;
        for (;;)
        {
          i = j;
          if (m <= k) {
            break;
          }
          if (isDelimiter(this.mText.charAt(m)))
          {
            i = m + 1;
            break;
          }
          f1 -= this.mCharHeight;
          m -= 1;
        }
        localObject1 = this.mText.substring(k, i);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          LogUtils.e(TAG, "ERROR => TextUtils.isEmpty(textColumn)");
        }
        localObject2 = new WMTokenizer.Token(this);
        ((WMTokenizer.Token)localObject2).text = ((String)localObject1);
        ((WMTokenizer.Token)localObject2).width = this.mCharWidth;
        ((WMTokenizer.Token)localObject2).height = f1;
        this.mTokens.add(localObject2);
        k = i;
        break;
      }
      j += 1;
    }
    label211:
    if (k < this.mText.length())
    {
      localObject1 = new WMTokenizer.Token(this);
      ((WMTokenizer.Token)localObject1).text = this.mText.substring(k);
      ((WMTokenizer.Token)localObject1).width = this.mCharWidth;
      ((WMTokenizer.Token)localObject1).height = f1;
      this.mTokens.add(localObject1);
    }
    boolean bool;
    if ((this.mWidth > 0) && (this.mTokens.size() * this.mCharWidth > this.mWidth)) {
      bool = false;
    } else {
      bool = true;
    }
    this.mFitIn = bool;
    i = this.mWidth;
    if (i > 0)
    {
      f1 = i;
      f2 = this.mCharWidth;
      if (f1 >= f2)
      {
        i = (int)(i / f2);
        if (this.mTokens.size() > i)
        {
          localObject1 = (WMTokenizer.Token)this.mTokens.get(i - 1);
          if (((WMTokenizer.Token)localObject1).text.length() > 3)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((WMTokenizer.Token)localObject1).text.substring(0, ((WMTokenizer.Token)localObject1).text.length() - 3));
            ((StringBuilder)localObject2).append("...");
            ((WMTokenizer.Token)localObject1).text = ((StringBuilder)localObject2).toString();
          }
        }
        while (this.mTokens.size() > i) {
          this.mTokens.remove(i);
        }
      }
    }
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("mTokens => ");
    ((StringBuilder)localObject2).append(this.mTokens.toString());
    LogUtils.d((String)localObject1, ((StringBuilder)localObject2).toString());
  }
  
  private void tokenizerVerticalSingleColumn()
  {
    if ((this.mHeight <= 0) || (TextUtils.isEmpty(this.mText))) {
      LogUtils.e(TAG, "ERROR => mHeight <= 0 || TextUtils.isEmpty(mText)");
    }
    Object localObject = new WMTokenizer.Token(this);
    ((WMTokenizer.Token)localObject).text = this.mText;
    int j = (int)(this.mHeight / this.mCharHeight);
    int i = this.mWidth;
    boolean bool;
    if (((i <= 0) || (i >= this.mCharWidth)) && (j > this.mText.length())) {
      bool = true;
    } else {
      bool = false;
    }
    this.mFitIn = bool;
    if (j < this.mText.length())
    {
      str = this.mText.substring(0, j);
      if (j > 3)
      {
        str = str.substring(0, j - 3);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("...");
        str = localStringBuilder.toString();
      }
      else
      {
        LogUtils.e(TAG, "countColumn <= 3");
      }
      ((WMTokenizer.Token)localObject).text = str;
    }
    ((WMTokenizer.Token)localObject).width = this.mCharWidth;
    i = j;
    if (j > this.mText.length()) {
      i = this.mText.length();
    }
    ((WMTokenizer.Token)localObject).height = (i * this.mCharHeight);
    this.mTokens.add(localObject);
    String str = TAG;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mTokens => ");
    ((StringBuilder)localObject).append(this.mTokens.toString());
    LogUtils.d(str, ((StringBuilder)localObject).toString());
  }
  
  public void doLayout()
  {
    this.mTextRect = new RectF();
    if (this.mTokens.isEmpty()) {
      return;
    }
    boolean bool = this.mVertical;
    int i = 1;
    Object localObject2;
    if (bool)
    {
      f1 = this.mWidth;
      float f3 = this.mTokens.size();
      float f2 = this.mCharWidth;
      f1 = (f1 - f3 * f2) / 2.0F;
      j = this.mAlignMode;
      if (j == 2) {
        f1 = this.mWidth - f2 * this.mTokens.size();
      } else if (j == 1) {
        f1 = (this.mWidth - f2 * this.mTokens.size()) / 2.0F;
      }
      localObject1 = this.mTokens.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WMTokenizer.Token)((Iterator)localObject1).next();
        j = this.mAlignMode;
        if (j != 1)
        {
          if (j != 3)
          {
            if (j == 4) {
              ((WMTokenizer.Token)localObject2).y = (this.mHeight - ((WMTokenizer.Token)localObject2).height);
            }
          }
          else {
            ((WMTokenizer.Token)localObject2).y = 0.0F;
          }
        }
        else {
          ((WMTokenizer.Token)localObject2).y = ((this.mHeight - ((WMTokenizer.Token)localObject2).height) / 2.0F);
        }
        ((WMTokenizer.Token)localObject2).x = f1;
        f1 += ((WMTokenizer.Token)localObject2).width;
      }
    }
    float f1 = (this.mHeight - this.mCharHeight * this.mTokens.size()) / 2.0F;
    int j = this.mAlignMode;
    if (j == 4) {
      f1 = this.mHeight - this.mCharHeight * this.mTokens.size();
    } else if (j == 1) {
      f1 = (this.mHeight - this.mCharHeight * this.mTokens.size()) / 2.0F;
    }
    Object localObject1 = this.mTokens.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WMTokenizer.Token)((Iterator)localObject1).next();
      j = this.mAlignMode;
      if (j != 0)
      {
        if (j != 1)
        {
          if (j == 2) {
            ((WMTokenizer.Token)localObject2).x = (this.mWidth - ((WMTokenizer.Token)localObject2).width);
          }
        }
        else {
          ((WMTokenizer.Token)localObject2).x = ((this.mWidth - ((WMTokenizer.Token)localObject2).width) / 2.0F);
        }
      }
      else {
        ((WMTokenizer.Token)localObject2).x = 0.0F;
      }
      ((WMTokenizer.Token)localObject2).y = f1;
      f1 += ((WMTokenizer.Token)localObject2).height;
    }
    localObject1 = (WMTokenizer.Token)this.mTokens.get(0);
    this.mTextRect = new RectF(((WMTokenizer.Token)localObject1).x, ((WMTokenizer.Token)localObject1).y, ((WMTokenizer.Token)localObject1).x + ((WMTokenizer.Token)localObject1).width, ((WMTokenizer.Token)localObject1).y + ((WMTokenizer.Token)localObject1).height);
    while (i < this.mTokens.size())
    {
      localObject1 = (WMTokenizer.Token)this.mTokens.get(i);
      localObject2 = this.mTextRect;
      if (((RectF)localObject2).left <= ((WMTokenizer.Token)localObject1).x) {
        f1 = this.mTextRect.left;
      } else {
        f1 = ((WMTokenizer.Token)localObject1).x;
      }
      ((RectF)localObject2).left = f1;
      localObject2 = this.mTextRect;
      if (((RectF)localObject2).right >= ((WMTokenizer.Token)localObject1).x + ((WMTokenizer.Token)localObject1).width) {
        f1 = this.mTextRect.right;
      } else {
        f1 = ((WMTokenizer.Token)localObject1).x + ((WMTokenizer.Token)localObject1).width;
      }
      ((RectF)localObject2).right = f1;
      localObject2 = this.mTextRect;
      if (((RectF)localObject2).top <= ((WMTokenizer.Token)localObject1).y) {
        f1 = this.mTextRect.top;
      } else {
        f1 = ((WMTokenizer.Token)localObject1).y;
      }
      ((RectF)localObject2).top = f1;
      localObject2 = this.mTextRect;
      if (((RectF)localObject2).bottom >= ((WMTokenizer.Token)localObject1).y + ((WMTokenizer.Token)localObject1).height)
      {
        f1 = this.mTextRect.bottom;
      }
      else
      {
        f1 = ((WMTokenizer.Token)localObject1).y;
        f1 = ((WMTokenizer.Token)localObject1).height + f1;
      }
      ((RectF)localObject2).bottom = f1;
      i += 1;
    }
  }
  
  public float getFontHeight()
  {
    return this.mCharHeight;
  }
  
  public RectF getTextRect()
  {
    return this.mTextRect;
  }
  
  public WMTokenizer.Token getToken(int paramInt)
  {
    if (CollectionUtils.indexOutOfBounds(this.mTokens, paramInt)) {
      return null;
    }
    return (WMTokenizer.Token)this.mTokens.get(paramInt);
  }
  
  public ArrayList<WMTokenizer.Token> getTokens()
  {
    return this.mTokens;
  }
  
  public boolean isFitIn()
  {
    return this.mFitIn;
  }
  
  public WMTokenizer setAlign(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals("left"))
      {
        this.mAlignMode = 0;
        return this;
      }
      if (paramString.equals("center"))
      {
        this.mAlignMode = 1;
        return this;
      }
      if (paramString.equals("right"))
      {
        this.mAlignMode = 2;
        return this;
      }
      if (paramString.equals("up"))
      {
        this.mAlignMode = 3;
        return this;
      }
      if (paramString.equals("down")) {
        this.mAlignMode = 4;
      }
    }
    return this;
  }
  
  public WMTokenizer setHeight(int paramInt)
  {
    this.mHeight = paramInt;
    return this;
  }
  
  public WMTokenizer setSingleLine(boolean paramBoolean)
  {
    this.mSingleLine = paramBoolean;
    return this;
  }
  
  public WMTokenizer setSpacingPlus(float paramFloat)
  {
    this.mSpacingPlus = paramFloat;
    return this;
  }
  
  public WMTokenizer setVertical(boolean paramBoolean)
  {
    this.mVertical = paramBoolean;
    return this;
  }
  
  public WMTokenizer setWidth(int paramInt)
  {
    this.mWidth = paramInt;
    return this;
  }
  
  public void tokenizer()
  {
    this.mTokens.clear();
    this.mCharWidth = 0.0F;
    this.mTextWidths = new float[this.mText.length()];
    this.mPaint.getTextWidths(this.mText, this.mTextWidths);
    Object localObject = this.mTextWidths;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      float f = localObject[i];
      if (f > this.mCharWidth) {
        this.mCharWidth = f;
      }
      i += 1;
    }
    localObject = new Rect();
    TextPaint localTextPaint = this.mPaint;
    String str = this.mText;
    localTextPaint.getTextBounds(str, 0, str.length(), (Rect)localObject);
    this.mCharHeight = ((Rect)localObject).height();
    if (this.mVertical)
    {
      tokenizerVertical();
      return;
    }
    tokenizeHorizontal();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.util.WMTokenizer
 * JD-Core Version:    0.7.0.1
 */