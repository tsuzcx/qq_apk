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
      catch (InstantiationException localInstantiationException)
      {
        QLog.e("QQTextBuilder", 1, "initTextProcessor error! ", localInstantiationException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        QLog.e("QQTextBuilder", 1, "initTextProcessor error! ", localIllegalAccessException);
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
      label38:
      break label38;
    }
    paramArrayOfChar = new StringBuilder();
    paramArrayOfChar.append("text:");
    paramArrayOfChar.append(toPlainText());
    QLog.e("QQTextBuilder", 1, paramArrayOfChar.toString());
  }
  
  public SpannableStringBuilder replace(int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3, int paramInt4)
  {
    int j = paramInt1;
    if (paramInt1 < 0) {
      j = 0;
    }
    int i = paramInt2;
    Object localObject2 = paramCharSequence;
    for (;;)
    {
      try
      {
        int k = length();
        paramInt1 = paramInt2;
        if (paramInt2 > k) {
          paramInt1 = k;
        }
        paramInt2 = paramInt1;
        if (paramInt1 < 0)
        {
          i = paramInt1;
          localObject2 = paramCharSequence;
          if (QLog.isColorLevel())
          {
            i = paramInt1;
            localObject2 = paramCharSequence;
            localObject1 = new StringBuilder();
            i = paramInt1;
            localObject2 = paramCharSequence;
            ((StringBuilder)localObject1).append("selection error, start = ");
            i = paramInt1;
            localObject2 = paramCharSequence;
            ((StringBuilder)localObject1).append(j);
            i = paramInt1;
            localObject2 = paramCharSequence;
            ((StringBuilder)localObject1).append(" end = ");
            i = paramInt1;
            localObject2 = paramCharSequence;
            ((StringBuilder)localObject1).append(paramInt1);
            i = paramInt1;
            localObject2 = paramCharSequence;
            ((StringBuilder)localObject1).append(" length = ");
            i = paramInt1;
            localObject2 = paramCharSequence;
            ((StringBuilder)localObject1).append(k);
            i = paramInt1;
            localObject2 = paramCharSequence;
            QLog.w("QQTextBuilder", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          localObject1 = paramCharSequence;
          i = paramInt2;
          localObject2 = paramCharSequence;
          if (paramCharSequence.length() > 0)
          {
            i = paramInt2;
            localObject2 = paramCharSequence;
            localObject1 = new QQText(paramCharSequence, this.mflags, this.mEmoSize).toSpanableString();
          }
          i = paramInt2;
          localObject2 = localObject1;
          paramCharSequence = super.replace(j, paramInt2, (CharSequence)localObject1, paramInt3, paramInt4);
          return paramCharSequence;
        }
      }
      catch (Throwable paramCharSequence)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("QQTextBuilder.replace caused crash..text:");
        ((StringBuilder)localObject1).append(toString());
        ((StringBuilder)localObject1).append(", replace text:");
        ((StringBuilder)localObject1).append(localObject2);
        ((StringBuilder)localObject1).append(" , ");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append("-");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(" , ");
        ((StringBuilder)localObject1).append(paramInt3);
        ((StringBuilder)localObject1).append("-");
        ((StringBuilder)localObject1).append(paramInt4);
        QLog.e("QQText", 1, ((StringBuilder)localObject1).toString(), paramCharSequence);
        return new SpannableStringBuilder();
      }
      paramInt2 = 0;
    }
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    if (!QQText.IS_FXXKED_MTK) {
      return super.subSequence(paramInt1, paramInt2);
    }
    if ((paramInt1 == 0) && (paramInt2 == length())) {
      return this;
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = length();
    paramInt1 = paramInt2;
    if (paramInt2 > j) {
      paramInt1 = j;
    }
    Object localObject = new char[paramInt1 - i];
    getChars(i, paramInt1, (char[])localObject, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((char[])localObject);
    localObject = sTextProcessorList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ITextProcessor)((Iterator)localObject).next()).doSubSequence(i, paramInt1, localStringBuilder, this);
    }
    return localStringBuilder;
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
    int j = k;
    while ((j >= i) && (arrayOfChar[j] <= ' ') && ((j == 0) || (arrayOfChar[(j - 1)] != '\024'))) {
      j -= 1;
    }
    if ((i == 0) && (j == k)) {
      return str;
    }
    return str.substring(i, j + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQTextBuilder
 * JD-Core Version:    0.7.0.1
 */