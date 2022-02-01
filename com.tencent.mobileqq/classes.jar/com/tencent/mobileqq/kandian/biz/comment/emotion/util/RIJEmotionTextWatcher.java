package com.tencent.mobileqq.kandian.biz.comment.emotion.util;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.kandian.biz.comment.emotion.cache.RIJEmotionCacheManager;
import com.tencent.mobileqq.kandian.biz.comment.emotion.data.RIJBaseEmotionInfo;
import com.tencent.mobileqq.kandian.biz.comment.emotion.span.IEmotionSpan;
import com.tencent.mobileqq.kandian.biz.comment.emotion.span.RIJEmotionTextSpan;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentSpanComparator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RIJEmotionTextWatcher
  implements TextWatcher
{
  private String a;
  
  public RIJEmotionTextWatcher(EditText paramEditText) {}
  
  private static List<RIJEmotionTextWatcher.EmotionBin> a(Editable paramEditable)
  {
    LinkedList localLinkedList = new LinkedList();
    int j = paramEditable.length();
    int i = 0;
    IEmotionSpan[] arrayOfIEmotionSpan = (IEmotionSpan[])paramEditable.getSpans(0, j, IEmotionSpan.class);
    if ((arrayOfIEmotionSpan != null) && (arrayOfIEmotionSpan.length > 0))
    {
      Arrays.sort(arrayOfIEmotionSpan, new RIJCommentSpanComparator(paramEditable));
      int m = arrayOfIEmotionSpan.length;
      int k;
      for (j = 0; i < m; j = k)
      {
        IEmotionSpan localIEmotionSpan = arrayOfIEmotionSpan[i];
        int n = paramEditable.getSpanStart(localIEmotionSpan);
        k = paramEditable.getSpanEnd(localIEmotionSpan);
        a(paramEditable, j, n, localLinkedList);
        i += 1;
      }
      a(paramEditable, j, paramEditable.length(), localLinkedList);
      return localLinkedList;
    }
    a(paramEditable, 0, paramEditable.length(), localLinkedList);
    return localLinkedList;
  }
  
  private static void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, Collection<RIJEmotionTextWatcher.EmotionBin> paramCollection)
  {
    if (!a(paramCharSequence, paramInt1, paramInt2)) {
      return;
    }
    paramCharSequence = RIJEmotionUtil.a.matcher(paramCharSequence.subSequence(paramInt1, paramInt2));
    while (paramCharSequence.find())
    {
      paramInt2 = paramCharSequence.start();
      int i = paramCharSequence.end();
      RIJBaseEmotionInfo localRIJBaseEmotionInfo = RIJEmotionCacheManager.b(paramCharSequence.group());
      if (localRIJBaseEmotionInfo != null) {
        paramCollection.add(new RIJEmotionTextWatcher.EmotionBin(paramInt2 + paramInt1, i + paramInt1, localRIJBaseEmotionInfo));
      }
    }
  }
  
  private static boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    boolean bool1 = b(paramCharSequence, paramInt1, paramInt2);
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2).toString();
    bool1 = bool2;
    if (paramCharSequence.indexOf('[') >= 0)
    {
      bool1 = bool2;
      if (paramCharSequence.indexOf(']') >= 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean b(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return (paramInt2 > paramInt1) && (paramInt1 >= 0) && (paramInt2 <= paramCharSequence.length());
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    Object localObject1 = paramEditable.toString();
    if (TextUtils.equals(this.a, (CharSequence)localObject1)) {
      return;
    }
    Object localObject2 = a(paramEditable);
    if (!((List)localObject2).isEmpty())
    {
      localObject1 = new StringBuilder();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        RIJEmotionTextWatcher.EmotionBin localEmotionBin = (RIJEmotionTextWatcher.EmotionBin)((Iterator)localObject2).next();
        paramEditable.setSpan(new RIJEmotionTextSpan(localEmotionBin.c), localEmotionBin.a, localEmotionBin.b, 33);
        ((StringBuilder)localObject1).append(localEmotionBin.c.a);
        ((StringBuilder)localObject1).append(',');
      }
      RIJEmotionUtil.a(2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramCharSequence.toString();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.util.RIJEmotionTextWatcher
 * JD-Core Version:    0.7.0.1
 */