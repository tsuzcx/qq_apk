package com.tencent.mobileqq.profile;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.sigtopic.SigTopicConfBean;
import com.tencent.mobileqq.config.business.sigtopic.SigTopicConfBean.SigTopicConfig;
import com.tencent.mobileqq.config.business.sigtopic.SigTopicConfBean.TopicInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.TopicItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.UinItem;

public class SigTopicManager
{
  public static SigTopicManager a()
  {
    return SigTopicManager.SigTopicManagerHolder.a();
  }
  
  private boolean a(List<oidb_0xd9f.UinItem> paramList, oidb_0xd9f.UinItem paramUinItem)
  {
    if (paramUinItem == null) {
      return true;
    }
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return false;
      }
      int i = 0;
      while (i < paramList.size())
      {
        if (((oidb_0xd9f.UinItem)paramList.get(i)).uint64_uin.get() == paramUinItem.uint64_uin.get()) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public int a(TextView paramTextView, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return -2147483648;
    }
    float f2 = paramInt1;
    float f1 = f2;
    if (!TextUtils.isEmpty(paramString2)) {
      f1 = f2 + paramTextView.getPaint().measureText(paramString2);
    }
    f2 = f1;
    if (paramString3 != null)
    {
      f2 = f1;
      if (paramInt2 > 0)
      {
        f2 = f1;
        if (paramString3.length() >= paramInt2) {
          f2 = f1 + paramTextView.getPaint().measureText(paramString3.substring(0, paramInt2));
        }
      }
    }
    f1 = paramTextView.getPaint().measureText(paramString1);
    if (f2 >= paramTextView.getWidth()) {
      return -2147483648;
    }
    if (f1 + f2 >= paramTextView.getWidth()) {
      return -(int)(f2 / 2.0F);
    }
    return paramTextView.getWidth() / 2 - (int)(f2 + f1 / 2.0F);
  }
  
  public CharSequence a(SigTopicConfBean paramSigTopicConfBean)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = paramSigTopicConfBean.a().b;
    localSpannableStringBuilder.append(paramSigTopicConfBean.a().a);
    int i = 0;
    while (i < ((ArrayList)localObject).size()) {
      if (TextUtils.isEmpty(((SigTopicConfBean.TopicInfo)((ArrayList)localObject).get(i)).b))
      {
        i += 1;
      }
      else
      {
        int j = localSpannableStringBuilder.length();
        paramSigTopicConfBean = ((SigTopicConfBean.TopicInfo)((ArrayList)localObject).get(i)).b;
        localObject = new ForegroundColorSpan(Color.parseColor("#4D94FF"));
        localSpannableStringBuilder.append(paramSigTopicConfBean);
        localSpannableStringBuilder.setSpan(localObject, j, paramSigTopicConfBean.length() + j, 33);
      }
    }
    return localSpannableStringBuilder;
  }
  
  public List<oidb_0xd9f.UinItem> a(List<oidb_0xd9f.TopicItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      while (i < paramList.size())
      {
        if ((paramList.get(i) != null) && (((oidb_0xd9f.TopicItem)paramList.get(i)).rpt_frd_item.get() != null))
        {
          List localList = ((oidb_0xd9f.TopicItem)paramList.get(i)).rpt_frd_item.get();
          if (localList != null)
          {
            int j = 0;
            while (j < localList.size())
            {
              if (!a(localArrayList, (oidb_0xd9f.UinItem)localList.get(j)))
              {
                localArrayList.add(localList.get(j));
                if (localArrayList.size() >= 3) {
                  return localArrayList;
                }
              }
              j += 1;
            }
          }
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit().putLong("common_topic_refresh_time", paramLong).apply();
  }
  
  public void a(QQAppInterface paramQQAppInterface, RichStatus paramRichStatus)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    String str = paramQQAppInterface.getString("sig_feed_id", "");
    if ((paramRichStatus != null) && (paramRichStatus.feedsId != null))
    {
      if (a().a(str, paramRichStatus.feedsId))
      {
        paramQQAppInterface.edit().putString("sig_feed_id", paramRichStatus.feedsId).apply();
        paramQQAppInterface.edit().putBoolean("common_topic_friend_list_should_show", true).apply();
      }
    }
    else if (a().a(str, ""))
    {
      paramQQAppInterface.edit().putString("sig_feed_id", "").apply();
      paramQQAppInterface.edit().putBoolean("common_topic_friend_list_should_show", true).apply();
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("has_shown_sig_with_topic_bubble", false);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return true;
      }
      return paramString1.equals(paramString2) ^ true;
    }
    return true;
  }
  
  public Pair<Integer, String> b(List<oidb_0xd9f.TopicItem> paramList)
  {
    int i = -1;
    String str1 = "";
    int m = i;
    String str2 = str1;
    if (paramList != null)
    {
      m = i;
      str2 = str1;
      if (paramList.size() > 0)
      {
        int j = 0;
        for (int k = -1;; k = m)
        {
          m = i;
          str2 = str1;
          if (j >= paramList.size()) {
            break;
          }
          m = k;
          if (((oidb_0xd9f.TopicItem)paramList.get(j)).uint32_frd_num.get() >= k)
          {
            i = ((oidb_0xd9f.TopicItem)paramList.get(j)).uint32_topic_id.get();
            str1 = ((oidb_0xd9f.TopicItem)paramList.get(j)).str_topic.get();
            m = ((oidb_0xd9f.TopicItem)paramList.get(j)).uint32_frd_num.get();
          }
          j += 1;
        }
      }
    }
    return new Pair(Integer.valueOf(m), str2);
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("has_shown_sig_with_topic_bubble", true).apply();
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramLong > paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getLong("common_topic_refresh_time", -1L))
    {
      a(paramQQAppInterface, paramLong);
      return true;
    }
    return false;
  }
  
  public int c(List<oidb_0xd9f.TopicItem> paramList)
  {
    int i = 0;
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return 0;
      }
      int j = 0;
      while (i < paramList.size())
      {
        j += ((oidb_0xd9f.TopicItem)paramList.get(i)).uint32_frd_num.get();
        i += 1;
      }
      return j;
    }
    return 0;
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("common_topic_friend_list_should_show", false).apply();
  }
  
  public long d(List<oidb_0xd9f.TopicItem> paramList)
  {
    long l2 = -1L;
    long l1 = l2;
    if (paramList != null)
    {
      l1 = l2;
      if (paramList.size() > 0)
      {
        l1 = -1L;
        int i = 0;
        while (i < paramList.size())
        {
          l2 = l1;
          if (paramList.get(i) != null)
          {
            l2 = l1;
            if (((oidb_0xd9f.TopicItem)paramList.get(i)).rpt_frd_item.get() != null)
            {
              List localList = ((oidb_0xd9f.TopicItem)paramList.get(i)).rpt_frd_item.get();
              l2 = l1;
              if (localList != null)
              {
                int j = 0;
                while (j < localList.size())
                {
                  l2 = l1;
                  if (((oidb_0xd9f.UinItem)localList.get(j)).uint64_time.get() > l1) {
                    l2 = ((oidb_0xd9f.UinItem)localList.get(j)).uint64_time.get();
                  }
                  j += 1;
                  l1 = l2;
                }
                l2 = l1;
              }
            }
          }
          i += 1;
          l1 = l2;
        }
      }
    }
    return l1;
  }
  
  public boolean d(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("common_topic_friend_list_should_show", true);
  }
  
  public boolean e(QQAppInterface paramQQAppInterface)
  {
    long l = QConfigManager.b().a(529, paramQQAppInterface.getCurrentAccountUin());
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    boolean bool = false;
    if (l > localBaseApplication.getSharedPreferences(paramQQAppInterface, 0).getLong("recommend_topic_version", -1L)) {
      bool = true;
    }
    return bool;
  }
  
  public void f(QQAppInterface paramQQAppInterface)
  {
    long l = QConfigManager.b().a(529, paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit().putLong("recommend_topic_version", l).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.SigTopicManager
 * JD-Core Version:    0.7.0.1
 */