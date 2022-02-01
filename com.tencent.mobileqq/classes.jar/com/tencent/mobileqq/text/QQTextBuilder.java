package com.tencent.mobileqq.text;

import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.text.processor.ITextProcessor;
import com.tencent.mobileqq.text.processor.QQEmoticonTextProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class QQTextBuilder
  extends SpannableStringBuilder
{
  public static Editable.Factory EMOCTATION_FACORY = new QQTextBuilder.1();
  public static Editable.Factory EMOTION_INPUT_FACTORY = new QQTextBuilder.2();
  @ConfigInject(configPath="Foundation/QQUI/src/main/resources/Inject_QQTextSpanProcessor.yml", version=1)
  public static ArrayList<Class<? extends ITextProcessor>> ITextProcessorClassList = new ArrayList();
  public static final String TAG = "QQTextBuilder";
  private static ArrayList<ITextProcessor> sTextProcessorList;
  private int mEmoSize;
  private int mflags;
  
  static
  {
    ITextProcessorClassList.add(QQEmoticonTextProcessor.class);
    sTextProcessorList = new ArrayList();
    Iterator localIterator = ITextProcessorClassList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Class)localIterator.next();
      try
      {
        localObject = (ITextProcessor)((Class)localObject).newInstance();
        sTextProcessorList.add(localObject);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        QLog.e("QQTextBuilder", 1, "initTextProcessor error! ", localIllegalAccessException);
      }
      catch (InstantiationException localInstantiationException)
      {
        QLog.e("QQTextBuilder", 1, "initTextProcessor error! ", localInstantiationException);
      }
    }
  }
  
  public QQTextBuilder(int paramInt)
  {
    this(paramInt, 32);
  }
  
  public QQTextBuilder(int paramInt1, int paramInt2)
  {
    this.mflags = paramInt1;
    this.mEmoSize = paramInt2;
  }
  
  public QQTextBuilder(CharSequence paramCharSequence, int paramInt)
  {
    this(paramCharSequence, paramInt, 32);
  }
  
  public QQTextBuilder(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    super(convert(paramCharSequence, paramInt1, paramInt2));
    this.mEmoSize = paramInt2;
    this.mflags = paramInt1;
  }
  
  private static final CharSequence convert(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((paramCharSequence instanceof QQText)) {
      return ((QQText)paramCharSequence).toSpanableString();
    }
    return new QQText(paramCharSequence, paramInt1, paramInt2).toSpanableString();
  }
  
  public static Editable.Factory getCustomSizeEditableFactory(int paramInt)
  {
    return new QQTextBuilder.3(paramInt);
  }
  
  public void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = length();
    paramInt1 = paramInt2;
    if (paramInt2 > j) {
      paramInt1 = j;
    }
    try
    {
      super.getChars(i, paramInt1, paramArrayOfChar, paramInt3);
      return;
    }
    catch (IndexOutOfBoundsException paramArrayOfChar)
    {
      QLog.e("QQTextBuilder", 1, "text:" + toPlainText());
    }
  }
  
  public SpannableStringBuilder replace(int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3, int paramInt4)
  {
    if (paramInt1 < 0) {
      j = 0;
    }
    for (;;)
    {
      try
      {
        k = length();
        if (paramInt2 > k)
        {
          paramInt1 = k;
          paramInt2 = paramInt1;
          if (paramInt1 < 0) {
            i = paramInt1;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        int k;
        Object localObject;
        QLog.e("QQText", 1, "QQTextBuilder.replace caused crash..text:" + toString() + ", replace text:" + paramCharSequence + " , " + j + "-" + paramInt2 + " , " + paramInt3 + "-" + paramInt4, localThrowable1);
        return new SpannableStringBuilder();
      }
      try
      {
        if (!QLog.isColorLevel()) {
          break label259;
        }
        i = paramInt1;
        QLog.w("QQTextBuilder", 2, "selection error, start = " + j + " end = " + paramInt1 + " length = " + k);
      }
      catch (Throwable localThrowable2)
      {
        paramInt2 = i;
        continue;
        continue;
        paramInt2 = 0;
        continue;
      }
      i = paramInt2;
      if (paramCharSequence.length() <= 0) {
        break label256;
      }
      i = paramInt2;
      localObject = new QQText(paramCharSequence, this.mflags, this.mEmoSize).toSpanableString();
      paramCharSequence = (CharSequence)localObject;
      try
      {
        localObject = super.replace(j, paramInt2, paramCharSequence, paramInt3, paramInt4);
        return localObject;
      }
      catch (Throwable localThrowable3)
      {
        continue;
      }
      j = paramInt1;
      continue;
      paramInt1 = paramInt2;
    }
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    if (!QQText.IS_FXXKED_MTK) {
      localObject1 = super.subSequence(paramInt1, paramInt2);
    }
    do
    {
      return localObject1;
      if (paramInt1 != 0) {
        break;
      }
      localObject1 = this;
    } while (paramInt2 == length());
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = length();
    paramInt1 = paramInt2;
    if (paramInt2 > j) {
      paramInt1 = j;
    }
    Object localObject2 = new char[paramInt1 - i];
    getChars(i, paramInt1, (char[])localObject2, 0);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((char[])localObject2);
    localObject2 = sTextProcessorList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ITextProcessor)((Iterator)localObject2).next()).doSubSequence(i, paramInt1, (StringBuilder)localObject1, this);
    }
    return localObject1;
  }
  
  public String toPlainText()
  {
    int i = length();
    Object localObject = new char[i];
    getChars(0, i, (char[])localObject, 0);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append((char[])localObject);
    localObject = sTextProcessorList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ITextProcessor)((Iterator)localObject).next()).doToPlain(i, localStringBuffer, this);
    }
    return localStringBuffer.toString();
  }
  
  public String toString()
  {
    if (!QQText.IS_FXXKED_MTK) {
      return super.toString();
    }
    int i = length();
    Object localObject = new char[i];
    getChars(0, i, (char[])localObject, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((char[])localObject);
    localObject = sTextProcessorList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ITextProcessor)((Iterator)localObject).next()).doToString(i, localStringBuilder, this);
    }
    return localStringBuilder.toString();
  }
  
  public String trim()
  {
    String str = toString();
    char[] arrayOfChar = str.toCharArray();
    int k = str.length() - 1;
    int i = 0;
    while ((i <= k) && (arrayOfChar[i] <= ' ') && (arrayOfChar[i] != '\024')) {
      i += 1;
    }
    for (;;)
    {
      int j;
      if ((j >= i) && (arrayOfChar[j] <= ' ') && ((j == 0) || (arrayOfChar[(j - 1)] != '\024')))
      {
        j -= 1;
      }
      else
      {
        if ((i == 0) && (j == k)) {
          return str;
        }
        return str.substring(i, j + 1);
        j = k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQTextBuilder
 * JD-Core Version:    0.7.0.1
 */