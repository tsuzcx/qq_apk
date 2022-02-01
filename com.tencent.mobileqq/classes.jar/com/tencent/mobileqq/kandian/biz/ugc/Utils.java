package com.tencent.mobileqq.kandian.biz.ugc;

import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyStringUtils;
import com.tencent.mobileqq.kandian.base.view.widget.text.ISpan;
import com.tencent.mobileqq.kandian.biz.biu.AtFriendsSpan;
import com.tencent.mobileqq.kandian.biz.biu.BiuNicknameSpan;
import com.tencent.mobileqq.kandian.glue.text.JumpSpan;
import com.tencent.mobileqq.kandian.glue.text.PlainUrlSpan;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.JumpInfo;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils
{
  private static Pattern a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Patterns.c.pattern());
    localStringBuilder.append("|");
    localStringBuilder.append(Patterns.d.pattern());
    a = Pattern.compile(localStringBuilder.toString(), 2);
  }
  
  private static int a(Spannable paramSpannable, int paramInt1, int paramInt2)
  {
    Matcher localMatcher = a.matcher(paramSpannable.subSequence(paramInt1, paramInt2));
    paramInt2 = 0;
    while (localMatcher.find())
    {
      int i = localMatcher.start() + paramInt1;
      int j = localMatcher.end() + paramInt1;
      String str = paramSpannable.subSequence(i, j).toString();
      paramInt2 += 1;
      paramSpannable.setSpan(new PlainUrlSpan(str), i, j, 0);
    }
    return paramInt2;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("beforeXml:");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("readinjoy.ugc.Utils", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    if (Character.codePointCount(paramString1, 0, paramString1.length()) == paramString1.length()) {
      if (!paramString1.contains(new String(new char[] { '\024' }))) {
        return paramString1;
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder("[emoji:0x%05x");
    StringBuilder localStringBuilder2 = new StringBuilder("[sysEmo:%03d");
    if (!TextUtils.isEmpty(paramString2))
    {
      localStringBuilder1.append(paramString2);
      localStringBuilder2.append(paramString2);
    }
    localStringBuilder1.append(']');
    localStringBuilder2.append(']');
    paramString2 = null;
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder(1024);
      paramString2.append("beforeXml start");
    }
    int m = paramString1.length();
    int i = 0;
    for (Object localObject = paramString1; i < m; localObject = paramString1)
    {
      int n = ((String)localObject).codePointAt(i);
      String str;
      int k;
      int j;
      if (n > 65535)
      {
        paramString1 = ((String)localObject).substring(i, i + 2);
        str = String.format(localStringBuilder1.toString(), new Object[] { Integer.valueOf(n) });
        paramString1 = ((String)localObject).replace(paramString1, str);
        k = i + (str.length() - 1);
        j = paramString1.length();
        if (QLog.isColorLevel())
        {
          paramString2.append("\n");
          paramString2.append("unicode");
          paramString2.append(":");
          paramString2.append(n);
        }
      }
      else
      {
        j = m;
        paramString1 = (String)localObject;
        k = i;
        if (n == 20)
        {
          n = i + 1;
          j = m;
          paramString1 = (String)localObject;
          k = i;
          if (n < m)
          {
            j = ((String)localObject).charAt(n);
            paramString1 = ((String)localObject).substring(i, i + 2);
            str = String.format(localStringBuilder2.toString(), new Object[] { Integer.valueOf(j) });
            paramString1 = ((String)localObject).replace(paramString1, str);
            k = i + (str.length() - 1);
            j = paramString1.length();
          }
        }
      }
      i = k + 1;
      m = j;
    }
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy.ugc.Utils", 2, paramString2.toString());
    }
    return localObject;
  }
  
  public static void a(QPublicBaseFragment paramQPublicBaseFragment)
  {
    Object localObject = paramQPublicBaseFragment.getQBaseActivity();
    if ((localObject != null) && ((localObject instanceof PublicFragmentActivity)))
    {
      localObject = (PublicFragmentActivity)localObject;
      SystemBarCompact localSystemBarCompact = ((PublicFragmentActivity)localObject).mSystemBarComp;
      if ((localSystemBarCompact != null) && (paramQPublicBaseFragment.needImmersive()) && (paramQPublicBaseFragment.needStatusTrans()) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        if (ThemeUtil.isInNightMode(((PublicFragmentActivity)localObject).getAppRuntime()))
        {
          if ((!SystemUtil.b()) && (!SystemUtil.d()))
          {
            localSystemBarCompact.setStatusBarColor(-7829368);
            return;
          }
          localSystemBarCompact.setStatusBarColor(-7829368);
          localSystemBarCompact.setStatusBarDarkMode(true);
          return;
        }
        if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
        {
          ((PublicFragmentActivity)localObject).getWindow().getDecorView().setSystemUiVisibility(9216);
          localSystemBarCompact.setStatusBarColor(-1);
          return;
        }
        if (!SystemUtil.d())
        {
          localSystemBarCompact.setStatusBarColor(-2368549);
          return;
        }
        localSystemBarCompact.setStatusBarColor(-1);
        localSystemBarCompact.setStatusBarDarkMode(true);
      }
    }
  }
  
  public static boolean a(Spannable paramSpannable)
  {
    int m = paramSpannable.length();
    boolean bool = false;
    if (m <= 0) {
      return false;
    }
    if (!Patterns.b.matcher(paramSpannable).find()) {
      return false;
    }
    Object localObject = (PlainUrlSpan[])paramSpannable.getSpans(0, m, PlainUrlSpan.class);
    int j;
    int i;
    if ((localObject != null) && (localObject.length > 0))
    {
      j = localObject.length;
      n = localObject.length;
      i = 0;
      for (;;)
      {
        k = j;
        if (i >= n) {
          break;
        }
        paramSpannable.removeSpan(localObject[i]);
        i += 1;
      }
    }
    int k = 0;
    localObject = (ISpan[])paramSpannable.getSpans(0, m, ISpan.class);
    if ((localObject != null) && (localObject.length > 0))
    {
      Arrays.sort((Object[])localObject, new Utils.SpanComparator(paramSpannable));
      int i2 = localObject.length;
      m = 0;
      j = 0;
      for (i = 0;; i = n)
      {
        i1 = j;
        n = i;
        if (m >= i2) {
          break;
        }
        int i3 = paramSpannable.getSpanStart(localObject[m]);
        i1 = paramSpannable.getSpanEnd(localObject[m]);
        n = i;
        if (j < i3) {
          n = i + a(paramSpannable, j, i3);
        }
        m += 1;
        j = i1;
      }
    }
    int i1 = 0;
    int n = 0;
    if (n + a(paramSpannable, i1, paramSpannable.length()) > k) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(EditText paramEditText, String paramString, boolean paramBoolean, List<BiuCommentInfo> paramList)
  {
    return a(paramEditText, paramString, paramBoolean, false, paramList);
  }
  
  public static boolean a(EditText paramEditText, String paramString, boolean paramBoolean1, boolean paramBoolean2, List<BiuCommentInfo> paramList)
  {
    if (paramEditText == null) {
      return true;
    }
    Object localObject2 = "";
    Object localObject1;
    if (paramBoolean2) {
      localObject1 = "：";
    } else {
      localObject1 = "";
    }
    Editable localEditable = paramEditText.getText();
    if ((localEditable != null) && (!TextUtils.isEmpty(localEditable.toString())))
    {
      String str1 = UUID.randomUUID().toString();
      Object localObject4 = ReadInJoyStringUtils.a(a(localEditable.toString(), str1));
      if (TextUtils.isEmpty((CharSequence)localObject4))
      {
        paramList.add(new BiuCommentInfo(paramString, Long.valueOf(0L), ""));
        return true;
      }
      Object localObject3 = (ISpan[])localEditable.getSpans(0, localEditable.length(), ISpan.class);
      if ((localObject3 != null) && (localObject3.length > 0))
      {
        int i = localObject3.length;
        Arrays.sort((Object[])localObject3, new Utils.SpanComparator(localEditable));
        paramEditText = EmotionCodecUtils.a(b(localEditable.subSequence(0, localEditable.getSpanStart(localObject3[0])).toString(), str1));
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject1);
        ((StringBuilder)localObject4).append(paramEditText.replaceAll("^\\s+", ""));
        paramList.add(new BiuCommentInfo(paramString, Long.valueOf(0L), ((StringBuilder)localObject4).toString(), 0));
        int m = localEditable.length();
        int j = 0;
        paramEditText = (EditText)localObject2;
        localObject1 = localObject3;
        while (j < i)
        {
          localObject3 = localObject1[j];
          int n = localEditable.getSpanEnd(localObject3);
          int k;
          if (j == i - 1) {
            k = m;
          } else {
            k = localEditable.getSpanStart(localObject1[(j + 1)]);
          }
          if (k - n > 0) {
            localObject2 = EmotionCodecUtils.a(b(localEditable.subSequence(n, k).toString(), str1));
          } else {
            localObject2 = paramEditText;
          }
          if ((localObject3 instanceof AtFriendsSpan))
          {
            try
            {
              localObject3 = (AtFriendsSpan)localObject3;
              localObject4 = new JumpInfo(Long.parseLong(((AtFriendsSpan)localObject3).jdField_a_of_type_JavaLangString), ((AtFriendsSpan)localObject3).a(), paramEditText);
              String str2 = ((AtFriendsSpan)localObject3).jdField_a_of_type_JavaLangString;
              try
              {
                paramList.add(new BiuCommentInfo(str2, Long.valueOf(((AtFriendsSpan)localObject3).jdField_a_of_type_Long), (String)localObject2, 1, (JumpInfo)localObject4));
              }
              catch (NumberFormatException localNumberFormatException1) {}
              localObject3 = new StringBuilder();
            }
            catch (NumberFormatException localNumberFormatException2) {}
            ((StringBuilder)localObject3).append("uin is not Long Type: ");
            ((StringBuilder)localObject3).append(localNumberFormatException2.getMessage());
            QLog.e("readinjoy.ugc.Utils", 1, ((StringBuilder)localObject3).toString());
          }
          else
          {
            if (!(localObject3 instanceof BiuNicknameSpan)) {
              break label549;
            }
            localObject3 = (BiuNicknameSpan)localObject3;
            paramList.add(new BiuCommentInfo(((BiuNicknameSpan)localObject3).jdField_a_of_type_JavaLangString, Long.valueOf(((BiuNicknameSpan)localObject3).jdField_a_of_type_Long), localNumberFormatException2, 0));
          }
          break label668;
          label549:
          if ((localObject3 instanceof TopicSpan))
          {
            localObject3 = ((TopicSpan)localObject3).a();
            paramList.add(new BiuCommentInfo(paramString, Long.valueOf(0L), localNumberFormatException2, 2, new JumpInfo(((TopicInfo)localObject3).a(), ((TopicInfo)localObject3).a(), ((TopicInfo)localObject3).d())));
          }
          else if ((localObject3 instanceof JumpSpan))
          {
            paramList.add(new BiuCommentInfo(paramString, Long.valueOf(0L), localNumberFormatException2, 3, new JumpInfo(0L, HardCodeUtil.a(2131715777), ((JumpSpan)localObject3).a())));
          }
          label668:
          j += 1;
        }
        return false;
      }
      paramEditText = (EditText)localObject4;
      if (!paramBoolean1) {
        paramEditText = ((String)localObject4).replaceAll("\n|\r\n", "");
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(paramEditText);
      paramList.add(new BiuCommentInfo(paramString, Long.valueOf(0L), EmotionCodecUtils.a(b(localStringBuilder.toString(), str1))));
      return true;
    }
    paramList.add(new BiuCommentInfo(paramString, Long.valueOf(0L), ""));
    return true;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    Object localObject2 = new StringBuilder("\\[emoji:0x[a-fA-F0-9]{5}");
    Object localObject1 = new StringBuilder("\\[sysEmo:[0-9]{3}");
    int j;
    if (!TextUtils.isEmpty(paramString2))
    {
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject1).append(paramString2);
      j = paramString2.length();
    }
    else
    {
      j = 0;
    }
    ((StringBuilder)localObject2).append("\\]");
    ((StringBuilder)localObject1).append("\\]");
    localObject2 = Pattern.compile(((StringBuilder)localObject2).toString()).matcher(paramString1);
    Object localObject3 = new StringBuffer();
    paramString2 = null;
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder(1024);
      paramString2.append("afterXml start");
    }
    for (int i = 0; ((Matcher)localObject2).find(); i = 1)
    {
      i = Integer.valueOf(paramString1.substring(((Matcher)localObject2).start() + 9, ((Matcher)localObject2).end() - 1 - j), 16).intValue();
      if (i > 65535) {
        ((Matcher)localObject2).appendReplacement((StringBuffer)localObject3, new String(new int[] { i }, 0, 1));
      }
      if (QLog.isColorLevel())
      {
        paramString2.append("\n");
        paramString2.append("unicode");
        paramString2.append(":");
        paramString2.append(i);
      }
    }
    ((Matcher)localObject2).appendTail((StringBuffer)localObject3);
    localObject2 = ((StringBuffer)localObject3).toString();
    localObject3 = Pattern.compile(((StringBuilder)localObject1).toString()).matcher((CharSequence)localObject2);
    localObject1 = new StringBuffer();
    while (((Matcher)localObject3).find())
    {
      i = Integer.valueOf(((String)localObject2).substring(((Matcher)localObject3).start() + 8, ((Matcher)localObject3).end() - 1 - j), 10).intValue();
      ((Matcher)localObject3).appendReplacement((StringBuffer)localObject1, new String(new char[] { '\024' }));
      ((StringBuffer)localObject1).append((char)i);
      i = 1;
    }
    ((Matcher)localObject3).appendTail((StringBuffer)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy.ugc.Utils", 2, paramString2.toString());
    }
    if (i != 0) {
      paramString1 = ((StringBuffer)localObject1).toString();
    }
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.Utils
 * JD-Core Version:    0.7.0.1
 */