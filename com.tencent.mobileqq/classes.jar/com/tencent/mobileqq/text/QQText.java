package com.tencent.mobileqq.text;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.GetChars;
import android.text.Layout.Alignment;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.text.processor.ISpanCallback;
import com.tencent.mobileqq.text.processor.ISpanProcessor;
import com.tencent.mobileqq.text.processor.QQEmoticonSpanProcessor;
import com.tencent.mobileqq.text.processor.QQLinkSpanProcessor;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class QQText
  extends AbsQQText
  implements GetChars, Spannable, ISpanCallback, CharSequence, Cloneable
{
  private static final int COLUMNS = 3;
  private static final int END = 1;
  private static final int FLAGS = 2;
  public static final int GRAB_FOR_AIO = 13;
  public static final int GRAB_LINKS = 8;
  public static final boolean IS_FXXKED_MTK;
  @ConfigInject(configPath="Foundation/QQUI/src/main/resources/Inject_QQTextSpanProcessor.yml", version=1)
  public static ArrayList<Class<? extends ISpanProcessor>> ISpanProcessorClassList = new ArrayList();
  public static Spannable.Factory SPANNABLE_FACTORY;
  private static final int START = 0;
  public static final String TAG = "QQText";
  private static ArrayList<ISpanProcessor> sSpanProcessorList;
  private GrabParams mGrabParams;
  public String mSource;
  public int mSpanCount;
  private int[] mSpanData;
  public Object[] mSpans;
  protected String mText;
  
  static
  {
    ISpanProcessorClassList.add(QQLinkSpanProcessor.class);
    ISpanProcessorClassList.add(QQEmoticonSpanProcessor.class);
    SPANNABLE_FACTORY = new QQText.1();
    boolean bool = true;
    try
    {
      StaticLayout.class.getDeclaredMethod("generate2", new Class[] { CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, Float.TYPE, Float.TYPE, Boolean.TYPE, Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label117:
      String str;
      break label117;
    }
    bool = false;
    str = Build.MANUFACTURER;
    IS_FXXKED_MTK = bool;
    initProcessor();
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt)
  {
    this(paramCharSequence, paramInt, 32);
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    this(paramCharSequence, 0, i, paramInt1, paramInt2, -1, null);
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramCharSequence, 0, paramInt3, paramInt1, paramInt2, -1, null);
  }
  
  protected QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Object paramObject)
  {
    if (paramCharSequence == null)
    {
      this.mText = "";
      this.mSource = "";
      return;
    }
    this.mSource = paramCharSequence.toString();
    this.mText = this.mSource;
    this.mGrabParams = new GrabParams(this.mText, paramInt3, paramInt1, paramInt2);
    this.mGrabParams.setEmoSize(paramInt4);
    this.mGrabParams.setUinType(paramInt5);
    if (paramObject != null) {
      this.mGrabParams.setMessage(paramObject);
    }
    SystemClock.uptimeMillis();
    paramInt4 = idealIntArraySize(3);
    try
    {
      this.mSpans = new Object[paramInt4];
      this.mSpanData = new int[paramInt4 * 3];
    }
    catch (OutOfMemoryError paramObject)
    {
      paramObject.printStackTrace();
    }
    paramObject = sSpanProcessorList.iterator();
    while (paramObject.hasNext())
    {
      ISpanProcessor localISpanProcessor = (ISpanProcessor)paramObject.next();
      if (localISpanProcessor.matchGrab(paramInt3)) {
        localISpanProcessor.doGrab(this.mGrabParams, this);
      }
    }
    this.mText = this.mGrabParams.text;
    if (!IS_FXXKED_MTK) {
      this.mSource = this.mText;
    }
    if ((paramCharSequence instanceof Spanned))
    {
      paramCharSequence = (Spanned)paramCharSequence;
      paramObject = paramCharSequence.getSpans(paramInt1, paramInt2, Object.class);
      paramInt3 = 0;
      while (paramInt3 < paramObject.length)
      {
        paramInt5 = paramCharSequence.getSpanStart(paramObject[paramInt3]);
        int i = paramCharSequence.getSpanEnd(paramObject[paramInt3]);
        int j = paramCharSequence.getSpanFlags(paramObject[paramInt3]);
        paramInt4 = paramInt5;
        if (paramInt5 < paramInt1) {
          paramInt4 = paramInt1;
        }
        paramInt5 = i;
        if (i > paramInt2) {
          paramInt5 = paramInt2;
        }
        setSpan(paramObject[paramInt3], paramInt4 - paramInt1, paramInt5 - paramInt1, j);
        paramInt3 += 1;
      }
    }
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2, Object paramObject)
  {
    this(paramCharSequence, 0, i, paramInt1, paramInt2, -1, paramObject);
  }
  
  private void checkRange(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= paramInt1)
    {
      int i = length();
      if ((paramInt1 <= i) && (paramInt2 <= i))
      {
        if ((paramInt1 >= 0) && (paramInt2 >= 0)) {
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(" ");
        localStringBuilder.append(region(paramInt1, paramInt2));
        localStringBuilder.append(" starts before 0");
        throw new IndexOutOfBoundsException(localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      localStringBuilder.append(region(paramInt1, paramInt2));
      localStringBuilder.append(" ends beyond length ");
      localStringBuilder.append(i);
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    localStringBuilder.append(region(paramInt1, paramInt2));
    localStringBuilder.append(" has end before start");
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  private static int idealIntArraySize(int paramInt)
  {
    int j = paramInt * 4;
    paramInt = 4;
    int i;
    for (;;)
    {
      i = j;
      if (paramInt >= 32) {
        break;
      }
      i = (1 << paramInt) - 12;
      if (j <= i) {
        break;
      }
      paramInt += 1;
    }
    return i / 4;
  }
  
  private static void initProcessor()
  {
    sSpanProcessorList = new ArrayList();
    Iterator localIterator = ISpanProcessorClassList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Class)localIterator.next();
      try
      {
        localObject = (ISpanProcessor)((Class)localObject).newInstance();
        sSpanProcessorList.add(localObject);
      }
      catch (InstantiationException localInstantiationException)
      {
        QLog.e("QQText", 1, "initSpanProcessor error! ", localInstantiationException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        QLog.e("QQText", 1, "initSpanProcessor error! ", localIllegalAccessException);
      }
    }
  }
  
  public static final boolean isFxxkingCall()
  {
    StackTraceElement localStackTraceElement = new java.lang.Exception().getStackTrace()[2];
    return (("android.text.StaticLayout".equals(localStackTraceElement.getClassName())) && ("generate2".equals(localStackTraceElement.getMethodName()))) || (("android.text.Layout".equals(localStackTraceElement.getClassName())) && ("expandTab".equals(localStackTraceElement.getMethodName())));
  }
  
  private static String region(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" ... ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  private void sendSpanAdded(Object paramObject, int paramInt1, int paramInt2)
  {
    SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])getSpans(paramInt1, paramInt2, SpanWatcher.class);
    int j = arrayOfSpanWatcher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSpanWatcher[i].onSpanAdded(this, paramObject, paramInt1, paramInt2);
      i += 1;
    }
  }
  
  private void sendSpanChanged(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])getSpans(Math.min(paramInt1, paramInt3), Math.max(paramInt2, paramInt4), SpanWatcher.class);
    int j = arrayOfSpanWatcher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSpanWatcher[i].onSpanChanged(this, paramObject, paramInt1, paramInt2, paramInt3, paramInt4);
      i += 1;
    }
  }
  
  private void sendSpanRemoved(Object paramObject, int paramInt1, int paramInt2)
  {
    SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])getSpans(paramInt1, paramInt2, SpanWatcher.class);
    int j = arrayOfSpanWatcher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSpanWatcher[i].onSpanRemoved(this, paramObject, paramInt1, paramInt2);
      i += 1;
    }
  }
  
  public <T> T[] acquireSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    return getSpans(paramInt1, paramInt2, paramClass);
  }
  
  public void addSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.mSpanCount;
    if (i + 1 >= this.mSpans.length)
    {
      i = idealIntArraySize(i + 1);
      arrayOfObject = new Object[i];
      int[] arrayOfInt = new int[i * 3];
      System.arraycopy(this.mSpans, 0, arrayOfObject, 0, this.mSpanCount);
      System.arraycopy(this.mSpanData, 0, arrayOfInt, 0, this.mSpanCount * 3);
      this.mSpans = arrayOfObject;
      this.mSpanData = arrayOfInt;
    }
    Object[] arrayOfObject = this.mSpans;
    i = this.mSpanCount;
    arrayOfObject[i] = paramObject;
    paramObject = this.mSpanData;
    paramObject[(i * 3 + 0)] = paramInt1;
    paramObject[(i * 3 + 1)] = paramInt2;
    paramObject[(i * 3 + 2)] = paramInt3;
    this.mSpanCount = (i + 1);
  }
  
  public QQText append(String paramString, boolean paramBoolean, int... paramVarArgs)
  {
    QQText localQQText = new QQText("", 0);
    localQQText.mGrabParams = this.mGrabParams;
    localQQText.mSpanCount = this.mSpanCount;
    localQQText.mSpanData = new int[this.mSpanData.length];
    Object localObject = this.mSpanData;
    System.arraycopy(localObject, 0, localQQText.mSpanData, 0, localObject.length);
    localQQText.mSpans = new Object[this.mSpans.length];
    localObject = this.mSpans;
    System.arraycopy(localObject, 0, localQQText.mSpans, 0, localObject.length);
    if (paramVarArgs.length >= 3)
    {
      if (paramVarArgs[2] == 1)
      {
        i = this.mGrabParams.flag;
        break label139;
      }
    }
    else if (paramVarArgs.length >= 2)
    {
      i = paramVarArgs[0];
      break label139;
    }
    int i = 0;
    label139:
    if (paramBoolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(this.mSource);
      localQQText.mSource = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(this.mText);
      localQQText.mText = ((StringBuilder)localObject).toString();
      int k = paramString.length();
      int j = 0;
      while (j < localQQText.mSpans.length)
      {
        localObject = localQQText.mSpanData;
        int m = j * 3;
        int n = m + 0;
        int[] arrayOfInt = this.mSpanData;
        arrayOfInt[n] += k;
        m += 1;
        arrayOfInt[m] += k;
        j += 1;
      }
      if (i != 0)
      {
        this.mGrabParams = new GrabParams(localQQText.mText, i, 0, paramString.length());
        this.mGrabParams.setEmoSize(paramVarArgs[1]);
        paramString = sSpanProcessorList.iterator();
        while (paramString.hasNext())
        {
          paramVarArgs = (ISpanProcessor)paramString.next();
          if (paramVarArgs.matchGrab(i)) {
            paramVarArgs.doGrab(this.mGrabParams, localQQText);
          }
        }
        localQQText.mText = this.mGrabParams.text;
        return localQQText;
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mSource);
      ((StringBuilder)localObject).append(paramString);
      localQQText.mSource = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mText);
      ((StringBuilder)localObject).append(paramString);
      localQQText.mText = ((StringBuilder)localObject).toString();
      if (i != 0)
      {
        this.mGrabParams = new GrabParams(localQQText.mText, i, this.mText.length(), this.mText.length() + paramString.length());
        this.mGrabParams.setEmoSize(paramVarArgs[1]);
        paramString = sSpanProcessorList.iterator();
        while (paramString.hasNext())
        {
          paramVarArgs = (ISpanProcessor)paramString.next();
          if (paramVarArgs.matchGrab(i)) {
            paramVarArgs.doGrab(this.mGrabParams, localQQText);
          }
        }
        localQQText.mText = this.mGrabParams.text;
      }
    }
    return localQQText;
  }
  
  public final char charAt(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= length())) {
      return this.mText.charAt(paramInt);
    }
    return '\000';
  }
  
  protected Object clone()
  {
    QQText localQQText = (QQText)super.clone();
    localQQText.mSpanData = new int[this.mSpanData.length];
    Object localObject = this.mSpanData;
    System.arraycopy(localObject, 0, localQQText.mSpanData, 0, localObject.length);
    localQQText.mSpans = new Object[this.mSpans.length];
    localObject = this.mSpans;
    System.arraycopy(localObject, 0, localQQText.mSpans, 0, localObject.length);
    return localQQText;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof QQText)) {
      return this.mSource.equals(((QQText)paramObject).mSource);
    }
    return false;
  }
  
  public final void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
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
    this.mText.getChars(i, paramInt1, paramArrayOfChar, paramInt3);
  }
  
  public int[] getSpanData()
  {
    return this.mSpanData;
  }
  
  public int getSpanEnd(Object paramObject)
  {
    int i = this.mSpanCount;
    Object[] arrayOfObject = this.mSpans;
    int[] arrayOfInt = this.mSpanData;
    i -= 1;
    while (i >= 0)
    {
      if (arrayOfObject[i] == paramObject) {
        return arrayOfInt[(i * 3 + 1)];
      }
      i -= 1;
    }
    return -1;
  }
  
  public int getSpanFlags(Object paramObject)
  {
    int i = this.mSpanCount;
    Object[] arrayOfObject = this.mSpans;
    int[] arrayOfInt = this.mSpanData;
    i -= 1;
    while (i >= 0)
    {
      if (arrayOfObject[i] == paramObject) {
        return arrayOfInt[(i * 3 + 2)];
      }
      i -= 1;
    }
    return 0;
  }
  
  public int getSpanStart(Object paramObject)
  {
    int i = this.mSpanCount;
    Object[] arrayOfObject = this.mSpans;
    int[] arrayOfInt = this.mSpanData;
    i -= 1;
    while (i >= 0)
    {
      if (arrayOfObject[i] == paramObject) {
        return arrayOfInt[(i * 3 + 0)];
      }
      i -= 1;
    }
    return -1;
  }
  
  public <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    int m = this.mSpanCount;
    Object[] arrayOfObject2 = this.mSpans;
    int[] arrayOfInt = this.mSpanData;
    if (paramClass == null) {
      return null;
    }
    Object[] arrayOfObject1 = null;
    Object localObject = arrayOfObject1;
    int j = 0;
    int i = 0;
    while (j < m)
    {
      if (paramClass.isInstance(arrayOfObject2[j]))
      {
        int k = j * 3;
        int n = arrayOfInt[(k + 0)];
        int i1 = arrayOfInt[(k + 1)];
        if ((n <= paramInt2) && (i1 >= paramInt1) && ((n == i1) || (paramInt1 == paramInt2) || ((n != paramInt2) && (i1 != paramInt1))))
        {
          if (i == 0) {
            localObject = arrayOfObject2[j];
          }
          for (;;)
          {
            i += 1;
            break label288;
            if (i == 1)
            {
              arrayOfObject1 = (Object[])Array.newInstance(paramClass, m - j + 1);
              arrayOfObject1[0] = localObject;
            }
            n = arrayOfInt[(k + 2)] & 0xFF0000;
            if (n == 0) {
              break;
            }
            k = 0;
            while ((k < i) && (n <= (getSpanFlags(arrayOfObject1[k]) & 0xFF0000))) {
              k += 1;
            }
            System.arraycopy(arrayOfObject1, k, arrayOfObject1, k + 1, i - k);
            arrayOfObject1[k] = arrayOfObject2[j];
          }
          arrayOfObject1[i] = arrayOfObject2[j];
          i += 1;
        }
      }
      label288:
      j += 1;
    }
    if (i == 0) {
      return (Object[])Array.newInstance(paramClass, 0);
    }
    if (i == 1)
    {
      arrayOfObject1 = (Object[])Array.newInstance(paramClass, 1);
      if (arrayOfObject1 == null) {
        return (Object[])Array.newInstance(paramClass, 0);
      }
      arrayOfObject1[0] = localObject;
      return (Object[])arrayOfObject1;
    }
    if (i == arrayOfObject1.length) {
      return (Object[])arrayOfObject1;
    }
    paramClass = (Object[])Array.newInstance(paramClass, i);
    System.arraycopy(arrayOfObject1, 0, paramClass, 0, i);
    return (Object[])paramClass;
  }
  
  public final int length()
  {
    String str = this.mText;
    if (str == null) {
      return 0;
    }
    return str.length();
  }
  
  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    int n = this.mSpanCount;
    Object[] arrayOfObject = this.mSpans;
    int[] arrayOfInt = this.mSpanData;
    Object localObject = paramClass;
    if (paramClass == null) {
      localObject = Object.class;
    }
    int j = 0;
    while (j < n)
    {
      int i = j * 3;
      int m = arrayOfInt[(i + 0)];
      int k = arrayOfInt[(i + 1)];
      i = paramInt2;
      if (m > paramInt1)
      {
        i = paramInt2;
        if (m < paramInt2)
        {
          i = paramInt2;
          if (((Class)localObject).isInstance(arrayOfObject[j])) {
            i = m;
          }
        }
      }
      paramInt2 = i;
      if (k > paramInt1)
      {
        paramInt2 = i;
        if (k < i)
        {
          paramInt2 = i;
          if (((Class)localObject).isInstance(arrayOfObject[j])) {
            paramInt2 = k;
          }
        }
      }
      j += 1;
    }
    return paramInt2;
  }
  
  protected void parseLinkSpan() {}
  
  public void removeSpan(Object paramObject)
  {
    int j = this.mSpanCount;
    Object[] arrayOfObject = this.mSpans;
    int[] arrayOfInt = this.mSpanData;
    int i = j - 1;
    while (i >= 0)
    {
      if (arrayOfObject[i] == paramObject)
      {
        int k = i * 3;
        int m = arrayOfInt[(k + 0)];
        int n = arrayOfInt[(k + 1)];
        int i1 = i + 1;
        j -= i1;
        System.arraycopy(arrayOfObject, i1, arrayOfObject, i, j);
        System.arraycopy(arrayOfInt, i1 * 3, arrayOfInt, k, j * 3);
        this.mSpanCount -= 1;
        sendSpanRemoved(paramObject, m, n);
        return;
      }
      i -= 1;
    }
  }
  
  public void setBizSrc(String paramString) {}
  
  public void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    checkRange("setSpan", paramInt1, paramInt2);
    if ((paramInt3 & 0x33) == 51)
    {
      char c;
      if ((paramInt1 != 0) && (paramInt1 != length()))
      {
        c = charAt(paramInt1 - 1);
        if (c != '\n')
        {
          paramObject = new StringBuilder();
          paramObject.append("PARAGRAPH span must start at paragraph boundary (");
          paramObject.append(paramInt1);
          paramObject.append(" follows ");
          paramObject.append(c);
          paramObject.append(")");
          throw new RuntimeException(paramObject.toString());
        }
      }
      if ((paramInt2 != 0) && (paramInt2 != length()))
      {
        c = charAt(paramInt2 - 1);
        if (c != '\n')
        {
          paramObject = new StringBuilder();
          paramObject.append("PARAGRAPH span must end at paragraph boundary (");
          paramObject.append(paramInt2);
          paramObject.append(" follows ");
          paramObject.append(c);
          paramObject.append(")");
          throw new RuntimeException(paramObject.toString());
        }
      }
    }
    int j = this.mSpanCount;
    Object localObject = this.mSpans;
    int[] arrayOfInt = this.mSpanData;
    int i = 0;
    while (i < j)
    {
      if (localObject[i] == paramObject)
      {
        i *= 3;
        j = i + 0;
        int k = arrayOfInt[j];
        int m = i + 1;
        int n = arrayOfInt[m];
        arrayOfInt[j] = paramInt1;
        arrayOfInt[m] = paramInt2;
        arrayOfInt[(i + 2)] = paramInt3;
        sendSpanChanged(paramObject, k, n, paramInt1, paramInt2);
        return;
      }
      i += 1;
    }
    i = this.mSpanCount;
    if (i + 1 >= this.mSpans.length)
    {
      i = idealIntArraySize(i + 1);
      localObject = new Object[i];
      arrayOfInt = new int[i * 3];
      System.arraycopy(this.mSpans, 0, localObject, 0, this.mSpanCount);
      System.arraycopy(this.mSpanData, 0, arrayOfInt, 0, this.mSpanCount * 3);
      this.mSpans = ((Object[])localObject);
      this.mSpanData = arrayOfInt;
    }
    localObject = this.mSpans;
    i = this.mSpanCount;
    localObject[i] = paramObject;
    localObject = this.mSpanData;
    localObject[(i * 3 + 0)] = paramInt1;
    localObject[(i * 3 + 1)] = paramInt2;
    localObject[(i * 3 + 2)] = paramInt3;
    this.mSpanCount = (i + 1);
    if ((this instanceof Spannable)) {
      sendSpanAdded(paramObject, paramInt1, paramInt2);
    }
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    int i = length();
    if (paramInt2 > i) {
      paramInt2 = i;
    }
    if ((IS_FXXKED_MTK) && (isFxxkingCall())) {
      return this.mText.subSequence(paramInt1, paramInt2);
    }
    if ((Build.VERSION.SDK_INT >= 26) && (paramInt1 == 0) && (paramInt2 == length())) {
      return this;
    }
    return new QQText(this.mText, paramInt1, paramInt2, this.mGrabParams.flag, this.mGrabParams.emoSize, this.mGrabParams.uinType, this.mGrabParams.message);
  }
  
  public String toPlainText()
  {
    return toPlainText(true);
  }
  
  public String toPlainText(boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer(this.mText);
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 3;
    }
    int j = 0;
    int m;
    for (int k = 0; j < this.mSpanCount; k = m)
    {
      Object localObject1 = this.mSpans[j];
      Object localObject2 = sSpanProcessorList.iterator();
      ISpanProcessor localISpanProcessor;
      do
      {
        m = k;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localISpanProcessor = (ISpanProcessor)((Iterator)localObject2).next();
      } while (!localISpanProcessor.matchPlain(localObject1));
      localObject2 = this.mSpanData;
      m = j * 3;
      m = k + localISpanProcessor.doPlain(localObject1, localObject2[(m + 0)] + k, localObject2[(m + 1)] + k, i, localStringBuffer);
      j += 1;
    }
    return localStringBuffer.toString();
  }
  
  public String toPurePlainText()
  {
    StringBuffer localStringBuffer = new StringBuffer(this.mText);
    int i = 0;
    int k;
    for (int j = 0; i < this.mSpanCount; j = k)
    {
      Object localObject1 = this.mSpans[i];
      Object localObject2 = sSpanProcessorList.iterator();
      ISpanProcessor localISpanProcessor;
      do
      {
        k = j;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localISpanProcessor = (ISpanProcessor)((Iterator)localObject2).next();
      } while (!localISpanProcessor.matchPlain(localObject1));
      localObject2 = this.mSpanData;
      k = i * 3;
      k = j + localISpanProcessor.doPlain(localObject1, localObject2[(k + 0)] + j, localObject2[(k + 1)] + j, 1, localStringBuffer);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  SpannableString toSpanableString()
  {
    SpannableString localSpannableString = new SpannableString(this.mText);
    TextUtils.copySpansFrom(this, 0, length(), Object.class, localSpannableString, 0);
    return localSpannableString;
  }
  
  public String toString()
  {
    if ((IS_FXXKED_MTK) && (isFxxkingCall())) {
      return this.mText;
    }
    return this.mSource;
  }
  
  public String trim()
  {
    char[] arrayOfChar = this.mSource.toCharArray();
    int k = this.mSource.length() - 1;
    int i = 0;
    while ((i <= k) && (arrayOfChar[i] <= ' ') && (arrayOfChar[i] != '\024')) {
      i += 1;
    }
    int j = k;
    while ((j >= i) && (arrayOfChar[j] <= ' ') && ((j == 0) || (arrayOfChar[(j - 1)] != '\024'))) {
      j -= 1;
    }
    if ((i == 0) && (j == k)) {
      return this.mSource;
    }
    return this.mSource.substring(i, j + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText
 * JD-Core Version:    0.7.0.1
 */