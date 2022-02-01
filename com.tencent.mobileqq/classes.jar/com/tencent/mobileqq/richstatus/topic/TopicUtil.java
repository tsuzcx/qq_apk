package com.tencent.mobileqq.richstatus.topic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.text.Editable;
import android.text.Spannable;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class TopicUtil
{
  private static long a;
  
  public static int a(Editable paramEditable, int paramInt)
  {
    if ((paramEditable.length() >= 0) && (paramInt >= 2))
    {
      if (paramInt > paramEditable.length()) {
        return -1;
      }
      paramInt -= 1;
      while ((paramInt >= 0) && (a(paramEditable, paramInt) == null) && (paramEditable.charAt(paramInt) != ' '))
      {
        if (paramEditable.charAt(paramInt) == '#') {
          return paramInt;
        }
        paramInt -= 1;
      }
      return -1;
    }
    return -1;
  }
  
  public static ColorStateList a(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { { 16842919 }, { 0 } }, new int[] { paramInt2, paramInt1 });
  }
  
  public static ITopic a(Spannable paramSpannable, int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= paramSpannable.length()) {
        return null;
      }
      ITopic[] arrayOfITopic = (ITopic[])paramSpannable.getSpans(paramInt, paramInt, ITopic.class);
      int i = 0;
      while (i < arrayOfITopic.length)
      {
        int j = paramSpannable.getSpanStart(arrayOfITopic[i]);
        int k = paramSpannable.getSpanEnd(arrayOfITopic[i]);
        if ((paramInt >= j) && (paramInt < k)) {
          return arrayOfITopic[i];
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static String a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://ti.qq.com/signature/focustopic?_wv=3&&_wwv=129");
    localStringBuilder.append('&');
    localStringBuilder.append("topic_id=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("&");
    localStringBuilder.append("topic_name=");
    try
    {
      localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.i("TopicUtil", 2, String.format("constructTopicDetailUrl[%d,%s]", new Object[] { Integer.valueOf(paramInt), paramString }));
    }
    return localStringBuilder.toString();
  }
  
  public static String a(Editable paramEditable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramEditable.length())
    {
      if (a(paramEditable, i) == null) {
        localStringBuilder.append(paramEditable.subSequence(i, i + 1));
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TopicUtil", 2, String.format("getPlainText [edit=%s len=%d %s]", new Object[] { paramEditable, Integer.valueOf(paramEditable.length()), localStringBuilder.toString() }));
    }
    return localStringBuilder.toString();
  }
  
  public static String a(List<Pair<Integer, String>> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuilder.append("index = ");
      localStringBuilder.append(i);
      localStringBuilder.append(",");
      localStringBuilder.append("id = ");
      localStringBuilder.append(((Pair)paramList.get(i)).first);
      localStringBuilder.append(",");
      localStringBuilder.append("topic = ");
      localStringBuilder.append((String)((Pair)paramList.get(i)).second);
      localStringBuilder.append(",");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (System.currentTimeMillis() - a < 500L) {
      return;
    }
    a = System.currentTimeMillis();
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Editable paramEditable, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) && (paramInt2 >= 0) && (paramInt3 > 0))
    {
      paramInt1 = -paramInt1;
      if (paramInt3 >= paramInt1)
      {
        paramInt3 = paramInt2 + paramInt3;
        if (paramInt3 > paramEditable.length()) {
          return;
        }
        paramInt2 = 0;
        int i = paramInt3 - paramInt1;
        paramInt1 = paramInt2;
        if (Character.isLowSurrogate(paramEditable.toString().charAt(i)))
        {
          paramInt1 = paramInt2;
          if (i > 0)
          {
            paramInt1 = paramInt2;
            if (i - 1 < paramEditable.length() - 1) {
              paramInt1 = 1;
            }
          }
        }
        paramEditable.delete(i, paramInt3);
        if (paramInt1 != 0) {
          paramEditable.delete(i - 1, i);
        }
      }
    }
  }
  
  public static void a(ETTextView paramETTextView, CharSequence paramCharSequence, int paramInt)
  {
    boolean bool;
    if ((paramETTextView.mFont != null) && (paramETTextView.mFont.getId() != 0) && (9999 != paramETTextView.mFont.getId())) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TopicUtil", 2, String.format("topicSpanCompactETTextView isCustom=%b from=%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) }));
    }
    CharSequence localCharSequence = paramCharSequence;
    if (paramCharSequence == null) {
      localCharSequence = paramETTextView.getText();
    }
    if ((localCharSequence != null) && ((localCharSequence instanceof Spannable)))
    {
      paramETTextView = (Spannable)localCharSequence;
      paramETTextView = (ITopic[])paramETTextView.getSpans(0, paramETTextView.length(), ITopic.class);
      paramInt = 0;
      while (paramInt < paramETTextView.length)
      {
        paramETTextView[0].setCustomFont(bool);
        paramInt += 1;
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.trim().length() >= 3;
  }
  
  public static List<Pair<Integer, String>> b(Editable paramEditable)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = null;
    int i = 0;
    while (i < paramEditable.length())
    {
      Object localObject3 = (ITopic[])paramEditable.getSpans(i, i, ITopic.class);
      Object localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (localObject3.length > 0)
        {
          localObject3 = localObject3[0];
          localObject2 = localObject1;
          if (localObject3 != localObject1)
          {
            localObject1 = ((ITopic)localObject3).getData();
            if ((localObject1 instanceof Pair)) {
              localArrayList.add((Pair)localObject1);
            }
            localObject2 = localObject3;
          }
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("TopicUtil", 2, String.format("getTopics %s", new Object[] { a(localArrayList) }));
    }
    return localArrayList;
  }
  
  public static List<Pair<Integer, Integer>> c(Editable paramEditable)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = null;
    int i = 0;
    while (i < paramEditable.length())
    {
      ITopic[] arrayOfITopic = (ITopic[])paramEditable.getSpans(i, i, ITopic.class);
      Object localObject2 = localObject3;
      if (arrayOfITopic != null)
      {
        localObject2 = localObject3;
        if (arrayOfITopic.length > 0)
        {
          Object localObject1;
          if (arrayOfITopic.length > 1)
          {
            int k = arrayOfITopic.length;
            localObject2 = null;
            int j = 0;
            while (j < k)
            {
              localObject1 = arrayOfITopic[j];
              if (localObject1 != localObject3) {
                localObject2 = localObject1;
              }
              j += 1;
            }
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = arrayOfITopic[(arrayOfITopic.length - 1)];
            }
          }
          else
          {
            localObject1 = arrayOfITopic[0];
          }
          localObject2 = localObject3;
          if (localObject1 != localObject3)
          {
            localObject2 = ((ITopic)localObject1).getData();
            if ((localObject2 instanceof Pair)) {
              localArrayList.add(new Pair(((Pair)localObject2).first, Integer.valueOf(i)));
            }
            localObject2 = localObject1;
          }
        }
      }
      i += 1;
      localObject3 = localObject2;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.topic.TopicUtil
 * JD-Core Version:    0.7.0.1
 */