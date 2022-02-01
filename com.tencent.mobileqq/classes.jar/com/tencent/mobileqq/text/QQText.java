package com.tencent.mobileqq.text;

import agfb;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.ContactsContract.Contacts;
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
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.View;
import android.webkit.URLUtil;
import anri;
import anvk;
import anvx;
import axdk;
import bbzy;
import bdla;
import becr;
import begs;
import bkyn;
import bkzi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;

public class QQText
  extends AbsQQText
  implements GetChars, Spannable, CharSequence, Cloneable
{
  public static final int AIO_NICK_EMO_SIZE = 13;
  private static final int COLUMNS = 3;
  public static final int DEFAULT_BIG_EMO_SIZE = 32;
  public static final int DEFAULT_EMO_SIZE = 32;
  public static final String EMOJI_SYMBOL = "[emoji]";
  public static final int EMOJI_TYPE_EMOJI = 0;
  public static final int EMOJI_TYPE_SMALL = 2;
  public static final int EMOJI_TYPE_SYSTEM = 1;
  static final Object[] EMPTY;
  private static final int END = 1;
  public static final char ENTER = '\r';
  public static final char ENTER_REPLACE = 'þ';
  private static final int FLAGS = 2;
  public static final int GRAB_ANIM_EMOTCATION = 5;
  public static final int GRAB_EMOJI = 1;
  public static final int GRAB_EMOTCATION = 3;
  public static final int GRAB_EMOTCATION_MASK = 7;
  public static final int GRAB_FOR_AIO = 13;
  public static final int GRAB_LINKS = 8;
  public static final int GRAB_SYS_ANIM_EMOTCATION = 4;
  public static final int GRAB_SYS_EMOTCATION = 2;
  public static final int GRAB_SYS_EMOTCATION_MASK = 6;
  public static final char HEAD_INDEX = '\024';
  public static final char HEAD_INDEX_REPLACE = 'ý';
  public static final boolean IS_FXXKED_MTK;
  public static final boolean IS_MOTO_ME;
  public static final char LF = '\n';
  private static final int LINK_TYPE_EMAIL = 2;
  private static final int LINK_TYPE_MEETING_PHONE = 3;
  private static final int LINK_TYPE_PHONE = 1;
  private static final int LINK_TYPE_QQ_OR_PHONE = 0;
  public static final int MAX_EMOTICON = 512;
  public static final int NO_ACTION = 0;
  public static final char RF = 'ú';
  public static String SMALL_EMOJI_SYMBOL = anvx.a(2131710599);
  public static final int SMALL_EMO_SIZE = 16;
  public static Spannable.Factory SPANNABLE_FACTORY;
  private static final int START = 0;
  public static final int SUB_SEQUENCE_FLAG_PASS_FLAGS = 1;
  private static final String TAG = "QQText";
  public static final int TROOP_NICK_EDIT_EMO_SIZE = 16;
  private static String currUin;
  private static String mTag;
  private String bizSrc;
  private int mEmoSize = 32;
  public int mFlags;
  private MessageRecord mMessage;
  public String mSource;
  public int mSpanCount;
  private int[] mSpanData;
  public Object[] mSpans;
  protected String mText;
  private int mUinType = -1;
  private bbzy searcher;
  
  static
  {
    EMPTY = new Object[0];
    SPANNABLE_FACTORY = new QQText.1();
    try
    {
      StaticLayout.class.getDeclaredMethod("generate2", new Class[] { CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, Float.TYPE, Float.TYPE, Boolean.TYPE, Boolean.TYPE });
      bool = true;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        boolean bool = false;
        continue;
        IS_MOTO_ME = false;
      }
    }
    if ((Build.MANUFACTURER.equals("motorola")) && (Build.VERSION.SDK_INT < 14))
    {
      IS_MOTO_ME = true;
      IS_FXXKED_MTK = bool;
      return;
    }
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt)
  {
    this(paramCharSequence, paramInt, 32);
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    this(paramCharSequence, 0, paramCharSequence.length(), paramInt1, paramInt2, -1);
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mEmoSize = paramInt4;
    long l = SystemClock.uptimeMillis();
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 != null) {
      currUin = ((AppRuntime)localObject1).getAccount();
    }
    if (currUin == null) {
      localObject1 = "";
    }
    for (;;)
    {
      currUin = (String)localObject1;
      this.mUinType = paramInt5;
      paramInt5 = idealIntArraySize(3);
      try
      {
        this.mSpans = new Object[paramInt5];
        this.mSpanData = new int[paramInt5 * 3];
        paramInt4 = (int)(paramInt4 * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
        if (paramCharSequence == null)
        {
          this.mText = "";
          this.mSource = "";
          return;
          localObject1 = currUin;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
        this.mSource = paramCharSequence.toString();
        this.mText = this.mSource;
        this.mFlags = paramInt3;
        if ((paramInt3 & 0x1) == 1) {
          break label190;
        }
      }
    }
    label190:
    Object localObject2;
    if ((paramInt3 & 0x6) > 0)
    {
      localObject2 = new StringBuilder(this.mSource);
      paramInt4 = doGrabEMotcation(0, ((StringBuilder)localObject2).length(), paramInt3, paramInt4, (StringBuilder)localObject2);
      this.mText = ((StringBuilder)localObject2).toString();
      if (!IS_FXXKED_MTK) {
        this.mSource = this.mText;
      }
      if (paramInt4 < QQSysFaceUtil.getAnimEmoCount()) {}
    }
    for (paramInt4 = 1;; paramInt4 = 0)
    {
      Object localObject3;
      if (paramInt4 != 0)
      {
        localObject2 = (QQText.EmoticonSpan[])getSpans(paramInt1, paramInt2, QQText.EmoticonSpan.class);
        if (localObject2 != null)
        {
          paramInt5 = localObject2.length;
          paramInt4 = 0;
          if (paramInt4 < paramInt5)
          {
            localObject3 = localObject2[paramInt4];
            if (((QQText.EmoticonSpan)localObject3).emojiType == 1) {
              ((QQText.EmoticonSpan)localObject3).index &= 0x7FFFFFFF;
            }
            for (;;)
            {
              paramInt4 += 1;
              break;
              if (((QQText.EmoticonSpan)localObject3).emojiType == 2) {
                ((QQText.SmallEmojiSpan)localObject3).mIsAnim = false;
              }
            }
          }
        }
      }
      if (((paramInt3 & 0x8) == 8) && (this.mText != null)) {
        if ((currUin.length() > 3) && (currUin.charAt(currUin.length() - 3) == '0') && (currUin.charAt(currUin.length() - 2) == '1'))
        {
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("length", this.mText.length() + "");
          localObject3 = StatisticCollector.getInstance(BaseApplication.getContext());
          if (this.mText.length() >= 1000) {
            break label652;
          }
        }
      }
      label652:
      for (boolean bool = true;; bool = false)
      {
        ((StatisticCollector)localObject3).collectPerformance(null, "qq_url_length_report", bool, 0L, 0L, (HashMap)localObject2, null);
        if (this.mText.length() < 1000) {
          parseLinkSpan();
        }
        if (!(paramCharSequence instanceof Spanned)) {
          break;
        }
        localObject2 = (Spanned)paramCharSequence;
        localObject3 = ((Spanned)localObject2).getSpans(paramInt1, paramInt2, Object.class);
        paramInt3 = 0;
        while (paramInt3 < localObject3.length)
        {
          paramInt5 = ((Spanned)localObject2).getSpanStart(localObject3[paramInt3]);
          int i = ((Spanned)localObject2).getSpanEnd(localObject3[paramInt3]);
          int j = ((Spanned)localObject2).getSpanFlags(localObject3[paramInt3]);
          paramInt4 = paramInt5;
          if (paramInt5 < paramInt1) {
            paramInt4 = paramInt1;
          }
          paramInt5 = i;
          if (i > paramInt2) {
            paramInt5 = paramInt2;
          }
          setSpan(localObject3[paramInt3], paramInt4 - paramInt1, paramInt5 - paramInt1, j);
          paramInt3 += 1;
        }
      }
      if (SystemClock.uptimeMillis() - l <= 400L) {
        break;
      }
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("time", SystemClock.uptimeMillis() - l + "");
      if (QLog.isColorLevel()) {
        QLog.i("QQText", 2, SystemClock.uptimeMillis() - l + ", " + paramCharSequence.length() + ", " + this.mSpanCount);
      }
      ((HashMap)localObject2).put("length", paramCharSequence.length() + "");
      ((HashMap)localObject2).put("emoji", this.mSpanCount + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "qqTextData", false, 0L, 0L, (HashMap)localObject2, null);
      return;
    }
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2, MessageRecord paramMessageRecord)
  {
    this(paramCharSequence, 0, paramCharSequence.length(), paramInt1, paramInt2, -1);
    this.mMessage = paramMessageRecord;
  }
  
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
  
  public static boolean containsEmoji(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramString.length())
      {
        j = paramString.codePointAt(i);
        if (EmotcationConstants.EMOJI_MAP.get(j, -1) < 0) {
          break label43;
        }
      }
      label43:
      for (int j = 1; j != 0; j = 0)
      {
        bool1 = true;
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean containsExpression(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramString.length())
      {
        if (20 == paramString.codePointAt(i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static void createNewContact(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
    localIntent.putExtra("phone", paramString);
    paramContext.startActivity(localIntent);
    report898("0X800A00B", "0X800A00B");
  }
  
  private int doGrabEMotcation(int paramInt1, int paramInt2, int paramInt3, int paramInt4, StringBuilder paramStringBuilder)
  {
    int i5 = paramStringBuilder.length();
    int j = 0;
    int i = 0;
    float f = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
    int i2 = (int)(22.0F * f + 0.5F);
    int i6 = (int)(f * 32.0F + 0.5F);
    int k = paramInt1;
    paramInt1 = i;
    int i7;
    boolean bool1;
    label82:
    int m;
    if (k < paramInt2)
    {
      i7 = paramStringBuilder.codePointAt(k);
      if ((paramInt3 & 0x4) == 4)
      {
        bool1 = true;
        if (((paramInt3 & 0x6) <= 0) || (i7 != 20) || (k >= i5 - 1)) {
          break label620;
        }
        m = paramStringBuilder.charAt(k + 1);
        if (!QQSysFaceUtil.isValidFaceId(m)) {
          break label252;
        }
        if (!IS_FXXKED_MTK) {
          break label230;
        }
        paramStringBuilder.replace(k, k + 2, "##");
        label145:
        i = m;
        if (bool1) {
          i = m | 0x80000000;
        }
        addSpan(new QQText.EmoticonSpan(i, paramInt4, 1), k, k + 2, 33);
        i = k + 1;
        k = j + 1;
        paramInt1 += 1;
        j = i;
        i = k;
        label210:
        if (i <= 512) {
          break label1104;
        }
      }
    }
    label424:
    label473:
    label1117:
    for (;;)
    {
      if (paramInt1 > 0) {}
      return paramInt1;
      bool1 = false;
      break label82;
      label230:
      if (m != 10) {
        break label145;
      }
      paramStringBuilder.setCharAt(k + 1, 'ú');
      break label145;
      label252:
      if ((m >= 255) && (k + 4 < i5))
      {
        char[] arrayOfChar = new char[4];
        arrayOfChar[0] = paramStringBuilder.charAt(k + 4);
        arrayOfChar[1] = paramStringBuilder.charAt(k + 3);
        arrayOfChar[2] = paramStringBuilder.charAt(k + 2);
        arrayOfChar[3] = paramStringBuilder.charAt(k + 1);
        i = 0;
        if (i < 3)
        {
          if (arrayOfChar[i] == 'ú') {
            arrayOfChar[i] = '\n';
          }
          for (;;)
          {
            i += 1;
            break;
            if (arrayOfChar[i] == 'þ') {
              arrayOfChar[i] = '\r';
            }
          }
        }
        boolean bool2;
        if (m == 511)
        {
          bool2 = true;
          addSpan(new QQText.SmallEmojiSpan(arrayOfChar, paramInt4, bool1, bool2), k, k + 5, 33);
          i = 2;
          if (i >= 5) {
            break label504;
          }
          if (paramStringBuilder.charAt(k + i) != '\n') {
            break label473;
          }
          paramStringBuilder.setCharAt(k + i, 'ú');
        }
        for (;;)
        {
          i += 1;
          break label424;
          bool2 = false;
          break;
          if (paramStringBuilder.charAt(k + i) == '\r') {
            paramStringBuilder.setCharAt(k + i, 'þ');
          }
        }
        k += 4;
        i = j + 1;
        paramInt1 += 1;
        j = k;
        break label210;
      }
      label504:
      int i3;
      label620:
      int n;
      if (m == 250)
      {
        if (IS_FXXKED_MTK) {
          paramStringBuilder.replace(k, k + 2, "##");
        }
        if (bool1) {}
        for (i = -2147483638;; i = 10)
        {
          addSpan(new QQText.EmoticonSpan(i, paramInt4, 1), k, k + 2, 33);
          k += 1;
          i = j + 1;
          paramInt1 += 1;
          j = k;
          break;
        }
        if ((paramInt3 & 0x1) == 1)
        {
          m = EmotcationConstants.getSingleEmoji(i7);
          i = -1;
          i1 = 0;
          i3 = 0;
          if (i7 > 65535)
          {
            n = i3;
            if (i5 > k + 2)
            {
              i = paramStringBuilder.codePointAt(k + 2);
              n = i3;
            }
            if (EmotcationConstants.isSkinEmoji(i)) {
              i1 = 1;
            }
            if ((m != -1) && (i1 == 0)) {
              break label1131;
            }
            i1 = EmotcationConstants.getDoubleEmoji(i7, i);
            if (i1 != -1) {
              break label960;
            }
          }
        }
      }
      label994:
      label1131:
      for (int i1 = 1;; i1 = 0)
      {
        if (m != -1)
        {
          if (i1 != 0) {
            if ((i7 > 65535) && (i5 >= k + 2))
            {
              if (IS_FXXKED_MTK) {
                paramStringBuilder.replace(k, k + 2, "##");
              }
              i1 = 2;
              if ((i <= 65535) || (i5 < k + 2)) {
                break label994;
              }
              if (IS_FXXKED_MTK) {
                paramStringBuilder.replace(k + 2, k + 4, "##");
              }
              i = i1 + 2;
              if (n == 0) {
                break label1117;
              }
              i += 1;
            }
          }
          for (;;)
          {
            if (paramInt4 == i6) {}
            for (n = i2;; n = paramInt4)
            {
              addSpan(new QQText.EmoticonSpan(m, n, 0), k, k + i, 33);
              k += i - 1;
              i = j + 1;
              j = k;
              break;
              n = i3;
              if (i5 <= k + 1) {
                break label679;
              }
              int i4 = paramStringBuilder.codePointAt(k + 1);
              n = i3;
              i = i4;
              if (i4 != 65039) {
                break label679;
              }
              n = i3;
              i = i4;
              if (i5 <= k + 2) {
                break label679;
              }
              i = paramStringBuilder.codePointAt(k + 2);
              n = 1;
              break label679;
              m = i1;
              break label716;
              if (IS_FXXKED_MTK) {
                paramStringBuilder.replace(k, k + 1, "#");
              }
              i1 = 1;
              break label771;
              if (IS_FXXKED_MTK) {
                paramStringBuilder.replace(k + 2, k + 3, "#");
              }
              i = i1 + 1;
              break label817;
              if ((i7 > 65535) && (i5 >= k + 2))
              {
                if (IS_FXXKED_MTK) {
                  paramStringBuilder.replace(k, k + 2, "##");
                }
                i = 2;
                break label828;
              }
              if (IS_FXXKED_MTK) {
                paramStringBuilder.replace(k, k + 1, "#");
              }
              i = 1;
              break label828;
            }
            k = j + 1;
            j = i;
            break;
          }
        }
        i = j;
        j = k;
        break label210;
      }
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
  
  public static final boolean isFxxkingCall()
  {
    StackTraceElement localStackTraceElement = new Exception().getStackTrace()[2];
    return (("android.text.StaticLayout".equals(localStackTraceElement.getClassName())) && ("generate2".equals(localStackTraceElement.getMethodName()))) || (("android.text.Layout".equals(localStackTraceElement.getClassName())) && ("expandTab".equals(localStackTraceElement.getMethodName())));
  }
  
  private static String region(int paramInt1, int paramInt2)
  {
    return "(" + paramInt1 + " ... " + paramInt2 + ")";
  }
  
  private static void report898(String paramString1, String paramString2)
  {
    try
    {
      bdla.b((QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(currUin), "dc00898", "", "", paramString1, paramString2, 0, 0, "", "", "", "");
      return;
    }
    catch (AccountNotMatchException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (ClassCastException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private static void reportLinkClick(String paramString1, String paramString2)
  {
    if (mTag == null) {
      return;
    }
    try
    {
      QQAppInterface localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(currUin);
      if (paramString2 != null)
      {
        bdla.b(localQQAppInterface1, "P_CliOper", "Grp_join", "", "send", "Clk_url", 0, 0, mTag, "" + paramString1, "" + paramString2, "");
        return;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      QQAppInterface localQQAppInterface2;
      for (;;)
      {
        localClassCastException.printStackTrace();
        localQQAppInterface2 = null;
      }
      bdla.b(localQQAppInterface2, "P_CliOper", "Grp_join", "", "send", "Clk_item", 0, 0, mTag, "" + paramString1, "" + paramString1, "");
      return;
    }
    catch (AccountNotMatchException paramString1) {}
  }
  
  private static void saveExistContact(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.INSERT_OR_EDIT");
    localIntent.setType("vnd.android.cursor.item/person");
    localIntent.setType("vnd.android.cursor.item/contact");
    localIntent.setType("vnd.android.cursor.item/raw_contact");
    localIntent.putExtra("phone", paramString);
    paramContext.startActivity(localIntent);
    report898("0X800A00C", "0X800A00C");
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
  
  public static void showAddContactsDialog(Context paramContext, String paramString)
  {
    bkzi localbkzi = bkzi.a(paramContext);
    localbkzi.a(String.format(paramContext.getString(2131694370), new Object[] { paramString }));
    localbkzi.a(2131691274, 1);
    localbkzi.a(2131689611, 1);
    localbkzi.c(2131690697);
    localbkzi.a(new QQText.6(bkyn.a(new QQText.5(paramContext, paramString, localbkzi)).a(1000L)));
    localbkzi.show();
  }
  
  public static void showDialog(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      showDialogOld(paramContext, paramString, i, null);
      return;
    }
  }
  
  public static void showDialogOld(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    bkzi localbkzi = bkzi.a(paramContext);
    if (paramInt == 0)
    {
      localbkzi.a(String.format(paramContext.getString(2131694369), new Object[] { paramString1 }));
      localbkzi.a(2131691565, 1);
      localbkzi.a(2131691264, 1);
      localbkzi.a(2131689605, 1);
      localbkzi.a(2131689570, 1);
      localbkzi.a(2131693410, 1);
    }
    for (;;)
    {
      localbkzi.c(2131690697);
      localbkzi.a(new QQText.2(paramInt, paramString1, paramContext, paramString2, localbkzi));
      localbkzi.show();
      return;
      if (paramInt == 1)
      {
        localbkzi.a(String.format(paramContext.getString(2131694370), new Object[] { paramString1 }));
        localbkzi.a(2131691565, 1);
        localbkzi.a(2131691264, 1);
        localbkzi.a(2131689605, 1);
      }
      else if (paramInt == 2)
      {
        localbkzi.a(String.format(paramContext.getString(2131693746), new Object[] { paramString1 }));
        localbkzi.a(2131718508, 1);
        localbkzi.a(2131691264, 1);
      }
      else if (paramInt == 3)
      {
        localbkzi.a(String.format(paramContext.getString(2131694370), new Object[] { paramString1 }));
        localbkzi.a(2131691565, 1);
        localbkzi.a(2131691264, 1);
        localbkzi.a(2131689605, 1);
      }
    }
  }
  
  protected void addSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
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
    localQQText.mEmoSize = this.mEmoSize;
    localQQText.mUinType = this.mUinType;
    localQQText.mMessage = this.mMessage;
    localQQText.mSpanCount = this.mSpanCount;
    localQQText.mSpanData = new int[this.mSpanData.length];
    System.arraycopy(this.mSpanData, 0, localQQText.mSpanData, 0, this.mSpanData.length);
    localQQText.mSpans = new Object[this.mSpans.length];
    System.arraycopy(this.mSpans, 0, localQQText.mSpans, 0, this.mSpans.length);
    int i = 0;
    int j = 0;
    if (paramVarArgs.length >= 2)
    {
      i = paramVarArgs[0];
      j = (int)(paramVarArgs[1] * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
    }
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder().append(paramString).append(this.mText);
      int m = paramString.length();
      int k = 0;
      while (k < localQQText.mSpans.length)
      {
        this.mSpanData[(k * 3 + 0)] += m;
        this.mSpanData[(k * 3 + 1)] += m;
        k += 1;
      }
      if (i != 0) {
        localQQText.doGrabEMotcation(0, paramString.length(), i, j, localStringBuilder);
      }
      localQQText.mSource = (paramString + this.mSource);
      localQQText.mText = localStringBuilder.toString();
      if (paramVarArgs.length >= 3) {
        if (paramVarArgs[2] != 1) {
          break label442;
        }
      }
    }
    label442:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        localQQText.mFlags = this.mFlags;
      }
      return localQQText;
      localStringBuilder = new StringBuilder().append(paramString).append(this.mText);
      if (i != 0) {
        localQQText.doGrabEMotcation(this.mText.length(), this.mText.length() + paramString.length(), i, j, localStringBuilder);
      }
      this.mSource += paramString;
      localQQText.mText = localStringBuilder.toString();
      break;
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
  
  protected void onURLLinkClicked(View paramView, String paramString)
  {
    int i;
    try
    {
      Object localObject1 = BaseApplicationImpl.getApplication().getAppRuntime(currUin);
      if ((localObject1 instanceof QQAppInterface)) {
        agfb.a((QQAppInterface)localObject1, this.mMessage, 5, paramString);
      }
      localObject2 = null;
      i = paramString.lastIndexOf("#");
      if (i > 0) {
        localObject2 = paramString.substring(i);
      }
      String str2 = URLUtil.guessUrl(paramString);
      localObject1 = str2;
      if (localObject2 != null) {
        localObject1 = str2 + (String)localObject2;
      }
      if (becr.a((String)localObject1))
      {
        localObject2 = paramView.getContext();
        if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("url", (String)localObject1);
          ((Bundle)localObject2).putString("tdsourcetag", "s_qq_aiomsg");
          TeamWorkDocEditBrowserActivity.a(paramView.getContext(), (Bundle)localObject2, false);
          if (this.mMessage != null) {
            break label266;
          }
          bdla.b(null, "CliOper", "", "", "0X80061B1", "0X80061B1", 0, 0, "", "", "", "");
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject2;
        QLog.e("QQText", 1, localThrowable, new Object[0]);
        continue;
        QQToast.a((Context)localObject2, ((Context)localObject2).getResources().getString(2131692125), 0).b(((Context)localObject2).getResources().getDimensionPixelSize(2131299080));
        continue;
        axdk.a(paramView.getContext(), localThrowable, true, true, true, false, this.mMessage, this.bizSrc);
      }
    }
    for (;;)
    {
      try
      {
        label266:
        paramView = this.mMessage;
        String str1 = paramView.frienduin;
        if (paramView.istroop == 1)
        {
          i = 2;
          if ((paramString == null) || (paramString.length() <= 150)) {
            break label399;
          }
          paramView = paramString.substring(0, 150);
          paramString = new URL(paramString).getHost();
          bdla.b(null, "CliOper", "", str1, "0X80061B1", "0X80061B1", i, 0, "", "", paramView, paramString);
          if (!QLog.isDebugVersion()) {
            break;
          }
          QLog.d("QQText", 4, String.format("the report params:%s,%s,%s,%s", new Object[] { "", "", paramView, paramString }));
          return;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      i = 1;
      continue;
      label399:
      paramView = paramString;
    }
  }
  
  protected void parseLinkSpan()
  {
    Object localObject = QQTextParseLinkUtil.parseLinkSpan(this.mText);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        begs localbegs = (begs)((Iterator)localObject).next();
        addSpan(new QQText.LinkSpan(this, localbegs.jdField_a_of_type_JavaLangString), localbegs.jdField_a_of_type_Int, localbegs.b, 33);
      }
    }
  }
  
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
  
  public void setBizSrc(String paramString)
  {
    this.bizSrc = paramString;
  }
  
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
  
  public void showDialog(Context paramContext, String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQText", 2, "msg is null, show old action sheet");
      }
      showDialogOld(paramContext, paramString, paramInt, this.bizSrc);
      return;
    }
    Object localObject1 = null;
    if ((paramContext instanceof BaseActivity)) {
      localObject1 = ((BaseActivity)paramContext).app;
    }
    if (localObject1 == null) {}
    for (;;)
    {
      try
      {
        Object localObject2 = paramMessageRecord.selfuin;
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime((String)localObject2);
        localObject1 = localObject2;
        if (localObject1 != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQText", 2, "app is null, show old action sheet");
        }
        showDialogOld(paramContext, paramString, paramInt, this.bizSrc);
        return;
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        QLog.e("QQText", 1, localAccountNotMatchException, new Object[0]);
      }
    }
    int i;
    bkzi localbkzi;
    Object localObject3;
    if (paramInt == 2)
    {
      i = 5;
      localbkzi = bkzi.a(paramContext);
      localObject3 = (anvk)((QQAppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramInt != 0) {
        break label400;
      }
      if (NetworkUtil.isNetworkAvailable()) {
        break label361;
      }
      localbkzi.a(String.format(paramContext.getString(2131694370), new Object[] { paramString }));
      localbkzi.a(2131691264, 1);
      localbkzi.a(2131692126, 1);
      localbkzi.a(2131691565, 1);
      localbkzi.a(2131689605, 1);
      bdla.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800A923", "0X800A923", bbzy.a((QQAppInterface)localObject1, paramMessageRecord.istroop, paramMessageRecord.frienduin), 0, "", "", "", "");
      bdla.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800B0C0", "0X800B0C0", bbzy.a(paramMessageRecord.istroop), 0, "", "", "", "");
    }
    for (;;)
    {
      localbkzi.c(2131690697);
      localbkzi.a(new QQText.3(this, paramContext, paramString, (QQAppInterface)localObject1, i, paramMessageRecord, paramInt, localbkzi));
      localbkzi.a(new QQText.4(this, (QQAppInterface)localObject1, i));
      localbkzi.show();
      return;
      i = 4;
      break;
      label361:
      if (this.searcher == null) {
        this.searcher = new bbzy(this.bizSrc);
      }
      this.searcher.a((QQAppInterface)localObject1, paramContext, paramString, (ChatMessage)paramMessageRecord);
      return;
      label400:
      if (paramInt == 1)
      {
        if (!NetworkUtil.isNetworkAvailable())
        {
          localbkzi.a(String.format(paramContext.getString(2131694370), new Object[] { paramString }));
          localbkzi.a(2131691264, 1);
          localbkzi.a(2131692126, 1);
          localbkzi.a(2131691565, 1);
          localbkzi.a(2131689605, 1);
          if ((!paramMessageRecord.isSend()) && (((anvk)localObject3).b(paramMessageRecord.senderuin)))
          {
            localObject3 = (anri)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
            if (localObject3 != null) {
              ((anri)localObject3).a(currUin, paramMessageRecord.senderuin, 1, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
            }
            localbkzi.a(2131689614, 1);
          }
          bdla.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800A923", "0X800A923", bbzy.a((QQAppInterface)localObject1, paramMessageRecord.istroop, paramMessageRecord.frienduin), 0, "", "", "", "");
          bdla.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800B0C0", "0X800B0C0", bbzy.a(paramMessageRecord.istroop), 0, "", "", "", "");
        }
        else
        {
          if (this.searcher == null) {
            this.searcher = new bbzy(this.bizSrc);
          }
          this.searcher.a((QQAppInterface)localObject1, paramContext, paramString, (ChatMessage)paramMessageRecord);
        }
      }
      else if (paramInt == 2)
      {
        localbkzi.a(String.format(paramContext.getString(2131693746), new Object[] { paramString }));
        localbkzi.a(2131691264, 1);
        localbkzi.a(2131692126, 1);
        localbkzi.a(2131718508, 1);
        bdla.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800A924", "0X800A924", bbzy.a((QQAppInterface)localObject1, paramMessageRecord.istroop, paramMessageRecord.frienduin), 0, "", "", "", "");
      }
      else if (paramInt == 3)
      {
        localbkzi.a(String.format(paramContext.getString(2131694370), new Object[] { paramString }));
        localbkzi.a(2131691264, 1);
        localbkzi.a(2131692126, 1);
        localbkzi.a(2131691565, 1);
        localbkzi.a(2131689605, 1);
        bdla.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800A923", "0X800A923", bbzy.a((QQAppInterface)localObject1, paramMessageRecord.istroop, paramMessageRecord.frienduin), 0, "", "", "", "");
      }
    }
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
    return new QQText(this.mText, paramInt1, paramInt2, this.mFlags, this.mEmoSize, this.mUinType);
  }
  
  public String toPlainText()
  {
    return toPlainText(true);
  }
  
  public String toPlainText(boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer(this.mText);
    int m = "[emoji]".length();
    int j = 0;
    int k = 0;
    if (j < this.mSpanCount)
    {
      Object localObject = this.mSpans[j];
      int i = k;
      int n;
      int i1;
      if ((localObject instanceof QQText.EmoticonSpan))
      {
        n = this.mSpanData[(j * 3 + 0)];
        i1 = this.mSpanData[(j * 3 + 1)];
        localObject = (QQText.EmoticonSpan)localObject;
        switch (((QQText.EmoticonSpan)localObject).emojiType)
        {
        default: 
          i = k;
        }
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        i = k;
        if (paramBoolean)
        {
          localStringBuffer.replace(n + k, i1 + k, "[emoji]");
          i = k + (m - (i1 - n));
          continue;
          localObject = ((QQText.EmoticonSpan)localObject).getDescription();
          localStringBuffer.replace(n + k, i1 + k, (String)localObject);
          i = k + (((String)localObject).length() - (i1 - n));
          continue;
          localObject = QQSysFaceUtil.getFaceDescription(((QQText.EmoticonSpan)localObject).index & 0x7FFFFFFF);
          localStringBuffer.replace(n + k, i1 + k, (String)localObject);
          i = k + (((String)localObject).length() - (i1 - n));
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public String toPurePlainText()
  {
    StringBuffer localStringBuffer = new StringBuffer(this.mText);
    int j = 0;
    int k = 0;
    if (j < this.mSpanCount)
    {
      Object localObject = this.mSpans[j];
      int i = k;
      int m;
      if ((localObject instanceof QQText.EmoticonSpan))
      {
        i = this.mSpanData[(j * 3 + 0)];
        m = this.mSpanData[(j * 3 + 1)];
        localObject = (QQText.EmoticonSpan)localObject;
        switch (((QQText.EmoticonSpan)localObject).emojiType)
        {
        default: 
          i = k;
        }
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        localStringBuffer.replace(i + k, m + k, "");
        i = k + (0 - (m - i));
        continue;
        localObject = ((QQText.EmoticonSpan)localObject).getDescription();
        localStringBuffer.replace(i + k, m + k, (String)localObject);
        i = k + (((String)localObject).length() - (m - i));
        continue;
        localStringBuffer.replace(i + k, m + k, "");
        i = k + (0 - (m - i));
      }
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