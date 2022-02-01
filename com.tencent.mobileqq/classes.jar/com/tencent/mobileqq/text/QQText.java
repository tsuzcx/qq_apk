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
  public static ArrayList<Class<? extends ISpanProcessor>> ISpanProcessorClassList;
  public static Spannable.Factory SPANNABLE_FACTORY = new QQText.1();
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
    boolean bool = true;
    ISpanProcessorClassList = new ArrayList();
    ISpanProcessorClassList.add(QQLinkSpanProcessor.class);
    ISpanProcessorClassList.add(QQEmoticonSpanProcessor.class);
    try
    {
      StaticLayout.class.getDeclaredMethod("generate2", new Class[] { CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, Float.TYPE, Float.TYPE, Boolean.TYPE, Boolean.TYPE });
      String str = Build.MANUFACTURER;
      IS_FXXKED_MTK = bool;
      initProcessor();
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        bool = false;
      }
    }
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt)
  {
    this(paramCharSequence, paramInt, 32);
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2) {}
  
  public QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Object paramObject)
  {
    if (paramCharSequence == null)
    {
      this.mText = "";
      this.mSource = "";
    }
    for (;;)
    {
      return;
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
        paramObject = sSpanProcessorList.iterator();
        while (paramObject.hasNext())
        {
          ISpanProcessor localISpanProcessor = (ISpanProcessor)paramObject.next();
          if (localISpanProcessor.matchGrab(paramInt3)) {
            localISpanProcessor.doGrab(this.mGrabParams, this);
          }
        }
      }
      catch (OutOfMemoryError paramObject)
      {
        for (;;)
        {
          paramObject.printStackTrace();
        }
        this.mText = this.mGrabParams.text;
        if (!IS_FXXKED_MTK) {
          this.mSource = this.mText;
        }
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
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2, Object paramObject) {}
  
  private void checkRange(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1) {
      throw new IndexOutOfBoundsException(paramString + " " + region(paramInt1, paramInt2) + " has end before start");
    }
    int i = length();
    if ((paramInt1 > i) || (paramInt2 > i)) {
      throw new IndexOutOfBoundsException(paramString + " " + region(paramInt1, paramInt2) + " ends beyond length " + i);
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IndexOutOfBoundsException(paramString + " " + region(paramInt1, paramInt2) + " starts before 0");
    }
  }
  
  private static int idealIntArraySize(int paramInt)
  {
    int j = paramInt * 4;
    paramInt = 4;
    for (;;)
    {
      int i = j;
      if (paramInt < 32)
      {
        if (j <= (1 << paramInt) - 12) {
          i = (1 << paramInt) - 12;
        }
      }
      else {
        return i / 4;
      }
      paramInt += 1;
    }
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
      catch (IllegalAccessException localIllegalAccessException)
      {
        QLog.e("QQText", 1, "initSpanProcessor error! ", localIllegalAccessException);
      }
      catch (InstantiationException localInstantiationException)
      {
        QLog.e("QQText", 1, "initSpanProcessor error! ", localInstantiationException);
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
    return "(" + paramInt1 + " ... " + paramInt2 + ")";
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
    if (this.mSpanCount + 1 >= this.mSpans.length)
    {
      int i = idealIntArraySize(this.mSpanCount + 1);
      Object[] arrayOfObject = new Object[i];
      int[] arrayOfInt = new int[i * 3];
      System.arraycopy(this.mSpans, 0, arrayOfObject, 0, this.mSpanCount);
      System.arraycopy(this.mSpanData, 0, arrayOfInt, 0, this.mSpanCount * 3);
      this.mSpans = arrayOfObject;
      this.mSpanData = arrayOfInt;
    }
    this.mSpans[this.mSpanCount] = paramObject;
    this.mSpanData[(this.mSpanCount * 3 + 0)] = paramInt1;
    this.mSpanData[(this.mSpanCount * 3 + 1)] = paramInt2;
    this.mSpanData[(this.mSpanCount * 3 + 2)] = paramInt3;
    this.mSpanCount += 1;
  }
  
  public QQText append(String paramString, boolean paramBoolean, int... paramVarArgs)
  {
    QQText localQQText = new QQText("", 0);
    localQQText.mGrabParams = this.mGrabParams;
    localQQText.mSpanCount = this.mSpanCount;
    localQQText.mSpanData = new int[this.mSpanData.length];
    System.arraycopy(this.mSpanData, 0, localQQText.mSpanData, 0, this.mSpanData.length);
    localQQText.mSpans = new Object[this.mSpans.length];
    System.arraycopy(this.mSpans, 0, localQQText.mSpans, 0, this.mSpans.length);
    int i;
    if (paramVarArgs.length >= 3)
    {
      if (paramVarArgs[2] != 1) {
        break label542;
      }
      i = this.mGrabParams.flag;
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localQQText.mSource = (paramString + this.mSource);
        localQQText.mText = (paramString + this.mText);
        int k = paramString.length();
        int j = 0;
        for (;;)
        {
          if (j < localQQText.mSpans.length)
          {
            this.mSpanData[(j * 3 + 0)] += k;
            this.mSpanData[(j * 3 + 1)] += k;
            j += 1;
            continue;
            if (paramVarArgs.length < 2) {
              break label542;
            }
            i = paramVarArgs[0];
            break;
          }
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
        }
      }
      do
      {
        return localQQText;
        this.mSource += paramString;
        this.mText += paramString;
      } while (i == 0);
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
      return localQQText;
      label542:
      i = 0;
    }
  }
  
  public final char charAt(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > length())) {
      return '\000';
    }
    return this.mText.charAt(paramInt);
  }
  
  protected Object clone()
  {
    QQText localQQText = (QQText)super.clone();
    localQQText.mSpanData = new int[this.mSpanData.length];
    System.arraycopy(this.mSpanData, 0, localQQText.mSpanData, 0, this.mSpanData.length);
    localQQText.mSpans = new Object[this.mSpans.length];
    System.arraycopy(this.mSpans, 0, localQQText.mSpans, 0, this.mSpans.length);
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
    Object localObject = null;
    if (paramClass == null) {
      return null;
    }
    int j = 0;
    Object[] arrayOfObject1 = null;
    int i = 0;
    if (j < m)
    {
      if (!paramClass.isInstance(arrayOfObject2[j])) {}
      for (;;)
      {
        j += 1;
        break;
        int k = arrayOfInt[(j * 3 + 0)];
        int n = arrayOfInt[(j * 3 + 1)];
        if ((k <= paramInt2) && (n >= paramInt1) && ((k == n) || (paramInt1 == paramInt2) || ((k != paramInt2) && (n != paramInt1)))) {
          if (i == 0)
          {
            localObject = arrayOfObject2[j];
            i += 1;
          }
          else
          {
            if (i == 1)
            {
              arrayOfObject1 = (Object[])Array.newInstance(paramClass, m - j + 1);
              arrayOfObject1[0] = localObject;
            }
            n = 0xFF0000 & arrayOfInt[(j * 3 + 2)];
            if (n != 0)
            {
              k = 0;
              for (;;)
              {
                if ((k >= i) || (n > (getSpanFlags(arrayOfObject1[k]) & 0xFF0000)))
                {
                  System.arraycopy(arrayOfObject1, k, arrayOfObject1, k + 1, i - k);
                  arrayOfObject1[k] = arrayOfObject2[j];
                  i += 1;
                  break;
                }
                k += 1;
              }
            }
            arrayOfObject1[i] = arrayOfObject2[j];
            i += 1;
          }
        }
      }
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
    if (this.mText == null) {
      return 0;
    }
    return this.mText.length();
  }
  
  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    int m = this.mSpanCount;
    Object[] arrayOfObject = this.mSpans;
    int[] arrayOfInt = this.mSpanData;
    Object localObject = paramClass;
    if (paramClass == null) {
      localObject = Object.class;
    }
    int i = 0;
    int j;
    if (i < m)
    {
      int k = arrayOfInt[(i * 3 + 0)];
      j = arrayOfInt[(i * 3 + 1)];
      if ((k <= paramInt1) || (k >= paramInt2) || (!((Class)localObject).isInstance(arrayOfObject[i]))) {
        break label131;
      }
      paramInt2 = k;
    }
    label131:
    for (;;)
    {
      if ((j > paramInt1) && (j < paramInt2) && (((Class)localObject).isInstance(arrayOfObject[i]))) {
        paramInt2 = j;
      }
      for (;;)
      {
        i += 1;
        break;
        return paramInt2;
      }
    }
  }
  
  protected void parseLinkSpan() {}
  
  public void removeSpan(Object paramObject)
  {
    int j = this.mSpanCount;
    Object[] arrayOfObject = this.mSpans;
    int[] arrayOfInt = this.mSpanData;
    int i = j - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (arrayOfObject[i] == paramObject)
        {
          int k = arrayOfInt[(i * 3 + 0)];
          int m = arrayOfInt[(i * 3 + 1)];
          j -= i + 1;
          System.arraycopy(arrayOfObject, i + 1, arrayOfObject, i, j);
          System.arraycopy(arrayOfInt, (i + 1) * 3, arrayOfInt, i * 3, j * 3);
          this.mSpanCount -= 1;
          sendSpanRemoved(paramObject, k, m);
        }
      }
      else {
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
        if (c != '\n') {
          throw new RuntimeException("PARAGRAPH span must start at paragraph boundary (" + paramInt1 + " follows " + c + ")");
        }
      }
      if ((paramInt2 != 0) && (paramInt2 != length()))
      {
        c = charAt(paramInt2 - 1);
        if (c != '\n') {
          throw new RuntimeException("PARAGRAPH span must end at paragraph boundary (" + paramInt2 + " follows " + c + ")");
        }
      }
    }
    int j = this.mSpanCount;
    Object[] arrayOfObject = this.mSpans;
    int[] arrayOfInt = this.mSpanData;
    int i = 0;
    if (i < j) {
      if (arrayOfObject[i] == paramObject)
      {
        j = arrayOfInt[(i * 3 + 0)];
        int k = arrayOfInt[(i * 3 + 1)];
        arrayOfInt[(i * 3 + 0)] = paramInt1;
        arrayOfInt[(i * 3 + 1)] = paramInt2;
        arrayOfInt[(i * 3 + 2)] = paramInt3;
        sendSpanChanged(paramObject, j, k, paramInt1, paramInt2);
      }
    }
    do
    {
      return;
      i += 1;
      break;
      if (this.mSpanCount + 1 >= this.mSpans.length)
      {
        i = idealIntArraySize(this.mSpanCount + 1);
        arrayOfObject = new Object[i];
        arrayOfInt = new int[i * 3];
        System.arraycopy(this.mSpans, 0, arrayOfObject, 0, this.mSpanCount);
        System.arraycopy(this.mSpanData, 0, arrayOfInt, 0, this.mSpanCount * 3);
        this.mSpans = arrayOfObject;
        this.mSpanData = arrayOfInt;
      }
      this.mSpans[this.mSpanCount] = paramObject;
      this.mSpanData[(this.mSpanCount * 3 + 0)] = paramInt1;
      this.mSpanData[(this.mSpanCount * 3 + 1)] = paramInt2;
      this.mSpanData[(this.mSpanCount * 3 + 2)] = paramInt3;
      this.mSpanCount += 1;
    } while (!(this instanceof Spannable));
    sendSpanAdded(paramObject, paramInt1, paramInt2);
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    label18:
    Object localObject;
    if (paramInt1 < 0)
    {
      paramInt1 = 0;
      int i = length();
      if (paramInt2 <= i) {
        break label47;
      }
      paramInt2 = i;
      if ((!IS_FXXKED_MTK) || (!isFxxkingCall())) {
        break label50;
      }
      localObject = this.mText.subSequence(paramInt1, paramInt2);
    }
    label47:
    label50:
    do
    {
      return localObject;
      break;
      break label18;
      if ((Build.VERSION.SDK_INT < 26) || (paramInt1 != 0)) {
        break label73;
      }
      localObject = this;
    } while (paramInt2 == length());
    label73:
    return new QQText(this.mText, paramInt1, paramInt2, this.mGrabParams.flag, this.mGrabParams.emoSize, this.mGrabParams.uinType, this.mGrabParams.message);
  }
  
  public String toPlainText()
  {
    return toPlainText(true);
  }
  
  public String toPlainText(boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer(this.mText);
    int j;
    int k;
    if (paramBoolean)
    {
      j = 2;
      k = 0;
      int i = 0;
      label24:
      if (k >= this.mSpanCount) {
        break label139;
      }
      Object localObject = this.mSpans[k];
      Iterator localIterator = sSpanProcessorList.iterator();
      while (localIterator.hasNext())
      {
        ISpanProcessor localISpanProcessor = (ISpanProcessor)localIterator.next();
        if (localISpanProcessor.matchPlain(localObject)) {
          i += localISpanProcessor.doPlain(localObject, this.mSpanData[(k * 3 + 0)] + i, this.mSpanData[(k * 3 + 1)] + i, j, localStringBuffer);
        }
      }
    }
    for (;;)
    {
      k += 1;
      break label24;
      j = 3;
      break;
      label139:
      return localStringBuffer.toString();
    }
  }
  
  public String toPurePlainText()
  {
    StringBuffer localStringBuffer = new StringBuffer(this.mText);
    int j = 0;
    int i = 0;
    if (j < this.mSpanCount)
    {
      Object localObject = this.mSpans[j];
      Iterator localIterator = sSpanProcessorList.iterator();
      while (localIterator.hasNext())
      {
        ISpanProcessor localISpanProcessor = (ISpanProcessor)localIterator.next();
        if (localISpanProcessor.matchPlain(localObject)) {
          i += localISpanProcessor.doPlain(localObject, this.mSpanData[(j * 3 + 0)] + i, this.mSpanData[(j * 3 + 1)] + i, 1, localStringBuffer);
        }
      }
    }
    for (;;)
    {
      j += 1;
      break;
      return localStringBuffer.toString();
    }
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
          return this.mSource;
        }
        return this.mSource.substring(i, j + 1);
        j = k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText
 * JD-Core Version:    0.7.0.1
 */