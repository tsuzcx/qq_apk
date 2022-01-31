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
  private static final String TAG = WMTokenizer.class.getSimpleName();
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
    float f = 0.0F;
    int j = 0;
    int i = 0;
    int k;
    if (i < this.mText.length())
    {
      f += this.mTextWidths[i];
      if (f > this.mWidth)
      {
        f -= this.mTextWidths[i];
        k = i - 1;
        label75:
        if (k <= j) {
          break label481;
        }
        if (isDelimiter(this.mText.charAt(k))) {
          i = k + 1;
        }
      }
    }
    label481:
    for (;;)
    {
      Object localObject = this.mText.substring(j, i);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        LogUtils.e(TAG, "ERROR => TextUtils.isEmpty(textRow)");
      }
      WMTokenizer.Token localToken = new WMTokenizer.Token(this);
      localToken.text = ((String)localObject);
      localToken.width = f;
      localToken.height = this.mCharHeight;
      this.mTokens.add(localToken);
      j = i;
      f = 0.0F;
      break;
      f -= this.mTextWidths[k];
      k -= 1;
      break label75;
      f += this.mSpacingPlus;
      i += 1;
      break;
      if (j < this.mText.length())
      {
        localObject = new WMTokenizer.Token(this);
        ((WMTokenizer.Token)localObject).text = this.mText.substring(j);
        ((WMTokenizer.Token)localObject).width = f;
        ((WMTokenizer.Token)localObject).height = this.mCharHeight;
        this.mTokens.add(localObject);
      }
      if ((this.mHeight <= 0) || (this.mTokens.size() * this.mCharHeight <= this.mHeight)) {}
      for (boolean bool = true;; bool = false)
      {
        this.mFitIn = bool;
        if ((this.mHeight <= 0) || (this.mHeight < this.mCharHeight)) {
          break;
        }
        i = (int)(this.mHeight / this.mCharHeight);
        if (this.mTokens.size() > i)
        {
          localObject = (WMTokenizer.Token)this.mTokens.get(i - 1);
          if (((WMTokenizer.Token)localObject).text.length() > 3) {
            ((WMTokenizer.Token)localObject).text = (((WMTokenizer.Token)localObject).text.substring(0, ((WMTokenizer.Token)localObject).text.length() - 3) + "...");
          }
        }
        while (this.mTokens.size() > i) {
          this.mTokens.remove(i);
        }
      }
      LogUtils.d(TAG, "mTokens => " + this.mTokens.toString());
      return;
    }
  }
  
  private void tokenizerHorizontalSingleRow()
  {
    if ((this.mWidth <= 0) || (TextUtils.isEmpty(this.mText))) {
      LogUtils.e(TAG, "ERROR => mWidth <= 0 || TextUtils.isEmpty(mText)");
    }
    float f1 = 0.0F;
    int i = 0;
    int j;
    if (i < this.mText.length())
    {
      f1 += this.mTextWidths[i];
      if (f1 > this.mWidth)
      {
        float f2 = this.mTextWidths[i];
        j = i - 1;
        f1 -= f2;
      }
    }
    for (i = 1;; i = 0)
    {
      boolean bool;
      label104:
      WMTokenizer.Token localToken;
      if (((this.mHeight <= 0) || (this.mHeight >= this.mCharHeight)) && (i == 0))
      {
        bool = true;
        this.mFitIn = bool;
        localToken = new WMTokenizer.Token(this);
        if (j < this.mText.length()) {
          break label218;
        }
        localToken.text = this.mText;
      }
      for (;;)
      {
        localToken.width = f1;
        localToken.height = this.mCharHeight;
        this.mTokens.add(localToken);
        LogUtils.d(TAG, "mTokens => " + this.mTokens.toString());
        return;
        f1 += this.mSpacingPlus;
        i += 1;
        break;
        bool = false;
        break label104;
        label218:
        if (j > 1)
        {
          String str = this.mText.substring(0, j - 1 + 1);
          str = str + "...";
          if (TextUtils.isEmpty(str)) {
            LogUtils.e(TAG, "ERROR => TextUtils.isEmpty(text2Draw)");
          }
          localToken.text = str;
        }
        else
        {
          localToken.text = this.mText;
        }
      }
      j = i;
    }
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
    float f = 0.0F;
    int j = 0;
    int i = 0;
    int k;
    if (i < this.mText.length())
    {
      f += this.mCharHeight;
      if (f > this.mHeight)
      {
        f -= this.mCharHeight;
        k = i - 1;
        label71:
        if (k <= j) {
          break label467;
        }
        if (isDelimiter(this.mText.charAt(k))) {
          i = k + 1;
        }
      }
    }
    label467:
    for (;;)
    {
      Object localObject = this.mText.substring(j, i);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        LogUtils.e(TAG, "ERROR => TextUtils.isEmpty(textColumn)");
      }
      WMTokenizer.Token localToken = new WMTokenizer.Token(this);
      localToken.text = ((String)localObject);
      localToken.width = this.mCharWidth;
      localToken.height = f;
      this.mTokens.add(localToken);
      j = i;
      f = 0.0F;
      break;
      f -= this.mCharHeight;
      k -= 1;
      break label71;
      i += 1;
      break;
      if (j < this.mText.length())
      {
        localObject = new WMTokenizer.Token(this);
        ((WMTokenizer.Token)localObject).text = this.mText.substring(j);
        ((WMTokenizer.Token)localObject).width = this.mCharWidth;
        ((WMTokenizer.Token)localObject).height = f;
        this.mTokens.add(localObject);
      }
      if ((this.mWidth <= 0) || (this.mTokens.size() * this.mCharWidth <= this.mWidth)) {}
      for (boolean bool = true;; bool = false)
      {
        this.mFitIn = bool;
        if ((this.mWidth <= 0) || (this.mWidth < this.mCharWidth)) {
          break;
        }
        i = (int)(this.mWidth / this.mCharWidth);
        if (this.mTokens.size() > i)
        {
          localObject = (WMTokenizer.Token)this.mTokens.get(i - 1);
          if (((WMTokenizer.Token)localObject).text.length() > 3) {
            ((WMTokenizer.Token)localObject).text = (((WMTokenizer.Token)localObject).text.substring(0, ((WMTokenizer.Token)localObject).text.length() - 3) + "...");
          }
        }
        while (this.mTokens.size() > i) {
          this.mTokens.remove(i);
        }
      }
      LogUtils.d(TAG, "mTokens => " + this.mTokens.toString());
      return;
    }
  }
  
  private void tokenizerVerticalSingleColumn()
  {
    if ((this.mHeight <= 0) || (TextUtils.isEmpty(this.mText))) {
      LogUtils.e(TAG, "ERROR => mHeight <= 0 || TextUtils.isEmpty(mText)");
    }
    WMTokenizer.Token localToken = new WMTokenizer.Token(this);
    localToken.text = this.mText;
    int i = (int)(this.mHeight / this.mCharHeight);
    boolean bool;
    if (((this.mWidth <= 0) || (this.mWidth >= this.mCharWidth)) && (i > this.mText.length()))
    {
      bool = true;
      this.mFitIn = bool;
      if (i < this.mText.length())
      {
        String str = this.mText.substring(0, i);
        if (i <= 3) {
          break label242;
        }
        str = str.substring(0, i - 3);
        str = str + "...";
        label149:
        localToken.text = str;
      }
      localToken.width = this.mCharWidth;
      if (i <= this.mText.length()) {
        break label253;
      }
      i = this.mText.length();
    }
    label242:
    label253:
    for (;;)
    {
      localToken.height = (i * this.mCharHeight);
      this.mTokens.add(localToken);
      LogUtils.d(TAG, "mTokens => " + this.mTokens.toString());
      return;
      bool = false;
      break;
      LogUtils.e(TAG, "countColumn <= 3");
      break label149;
    }
  }
  
  public void doLayout()
  {
    this.mTextRect = new RectF();
    if (this.mTokens.isEmpty()) {
      return;
    }
    label88:
    Object localObject2;
    if (this.mVertical)
    {
      f1 = (this.mWidth - this.mTokens.size() * this.mCharWidth) / 2.0F;
      if (this.mAlignMode == 2)
      {
        f1 = this.mWidth - this.mCharWidth * this.mTokens.size();
        localObject1 = this.mTokens.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label455;
        }
        localObject2 = (WMTokenizer.Token)((Iterator)localObject1).next();
        switch (this.mAlignMode)
        {
        }
      }
      for (;;)
      {
        ((WMTokenizer.Token)localObject2).x = f1;
        f1 = ((WMTokenizer.Token)localObject2).width + f1;
        break label88;
        if (this.mAlignMode != 1) {
          break;
        }
        f1 = (this.mWidth - this.mCharWidth * this.mTokens.size()) / 2.0F;
        break;
        ((WMTokenizer.Token)localObject2).y = 0.0F;
        continue;
        ((WMTokenizer.Token)localObject2).y = ((this.mHeight - ((WMTokenizer.Token)localObject2).height) / 2.0F);
        continue;
        ((WMTokenizer.Token)localObject2).y = (this.mHeight - ((WMTokenizer.Token)localObject2).height);
      }
    }
    else
    {
      f1 = (this.mHeight - this.mCharHeight * this.mTokens.size()) / 2.0F;
      if (this.mAlignMode == 4)
      {
        f1 = this.mHeight - this.mCharHeight * this.mTokens.size();
        localObject1 = this.mTokens.iterator();
        label302:
        if (!((Iterator)localObject1).hasNext()) {
          break label455;
        }
        localObject2 = (WMTokenizer.Token)((Iterator)localObject1).next();
        switch (this.mAlignMode)
        {
        }
      }
      for (;;)
      {
        ((WMTokenizer.Token)localObject2).y = f1;
        f1 = ((WMTokenizer.Token)localObject2).height + f1;
        break label302;
        if (this.mAlignMode != 1) {
          break;
        }
        f1 = (this.mHeight - this.mCharHeight * this.mTokens.size()) / 2.0F;
        break;
        ((WMTokenizer.Token)localObject2).x = 0.0F;
        continue;
        ((WMTokenizer.Token)localObject2).x = ((this.mWidth - ((WMTokenizer.Token)localObject2).width) / 2.0F);
        continue;
        ((WMTokenizer.Token)localObject2).x = (this.mWidth - ((WMTokenizer.Token)localObject2).width);
      }
    }
    label455:
    Object localObject1 = (WMTokenizer.Token)this.mTokens.get(0);
    float f1 = ((WMTokenizer.Token)localObject1).x;
    float f2 = ((WMTokenizer.Token)localObject1).y;
    float f3 = ((WMTokenizer.Token)localObject1).x;
    float f4 = ((WMTokenizer.Token)localObject1).width;
    float f5 = ((WMTokenizer.Token)localObject1).y;
    this.mTextRect = new RectF(f1, f2, f3 + f4, ((WMTokenizer.Token)localObject1).height + f5);
    int i = 1;
    label528:
    if (i < this.mTokens.size())
    {
      localObject1 = (WMTokenizer.Token)this.mTokens.get(i);
      localObject2 = this.mTextRect;
      if (this.mTextRect.left > ((WMTokenizer.Token)localObject1).x) {
        break label719;
      }
      f1 = this.mTextRect.left;
      label584:
      ((RectF)localObject2).left = f1;
      localObject2 = this.mTextRect;
      if (this.mTextRect.right < ((WMTokenizer.Token)localObject1).x + ((WMTokenizer.Token)localObject1).width) {
        break label728;
      }
      f1 = this.mTextRect.right;
      label626:
      ((RectF)localObject2).right = f1;
      localObject2 = this.mTextRect;
      if (this.mTextRect.top > ((WMTokenizer.Token)localObject1).y) {
        break label743;
      }
      f1 = this.mTextRect.top;
      label662:
      ((RectF)localObject2).top = f1;
      localObject2 = this.mTextRect;
      if (this.mTextRect.bottom < ((WMTokenizer.Token)localObject1).y + ((WMTokenizer.Token)localObject1).height) {
        break label752;
      }
    }
    for (f1 = this.mTextRect.bottom;; f1 = ((WMTokenizer.Token)localObject1).height + f1)
    {
      ((RectF)localObject2).bottom = f1;
      i += 1;
      break label528;
      break;
      label719:
      f1 = ((WMTokenizer.Token)localObject1).x;
      break label584;
      label728:
      f1 = ((WMTokenizer.Token)localObject1).x + ((WMTokenizer.Token)localObject1).width;
      break label626;
      label743:
      f1 = ((WMTokenizer.Token)localObject1).y;
      break label662;
      label752:
      f1 = ((WMTokenizer.Token)localObject1).y;
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
      if (!paramString.equals("left")) {
        break label24;
      }
      this.mAlignMode = 0;
    }
    label24:
    do
    {
      return this;
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
    } while (!paramString.equals("down"));
    this.mAlignMode = 4;
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
    this.mPaint.getTextBounds(this.mText, 0, this.mText.length(), (Rect)localObject);
    this.mCharHeight = ((Rect)localObject).height();
    if (this.mVertical)
    {
      tokenizerVertical();
      return;
    }
    tokenizeHorizontal();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.util.WMTokenizer
 * JD-Core Version:    0.7.0.1
 */