package com.tencent.mobileqq.colornote.data;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.MobileQQ;

public class ColorNoteUtils
{
  private static final List<String> a = new LinkedList();
  private static final List<String> b = new ArrayList();
  private static final List<String> c = new ArrayList();
  
  static
  {
    a.add("buluo.qq.com");
    a.add("null");
    a.add("unregistered service sub type");
    a.add("captcha.qq.com");
    a.add("oauth.youzan.com");
    a.add("https://zb.vip.qq.com/v2/pages/funcallMall");
    a.add("https://ti.qq.com/sportslive/index?_wwv=128&_wv=2&inviteeUin");
    c.add("https://zb.vip.qq.com/v2/pages/funcallMall");
    c.add("https://ti.qq.com/sportslive/index?_wwv=128&_wv=2&inviteeUin");
  }
  
  public static int a(int paramInt)
  {
    return paramInt & 0x7FFFFFFF;
  }
  
  public static int a(String paramString)
  {
    if (StringUtil.a(paramString)) {
      return 0;
    }
    paramString = Uri.parse(paramString);
    int i = 1;
    try
    {
      paramString = paramString.getQueryParameter("_wwv");
      if (StringUtil.a(paramString)) {
        return 0;
      }
      long l = Long.parseLong(paramString);
      if ((0x20000 & l) == 0L) {
        i = 0;
      }
      int j = i;
      if ((l & 0x10000) != 0L) {
        j = i + 2;
      }
      return j;
    }
    catch (Exception paramString)
    {
      QLog.e("ColorNoteUtils", 1, "parse long error: ", paramString);
    }
    return 0;
  }
  
  public static ColorNote a(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {
      return null;
    }
    String str = MobileQQ.getContext().getString(2131690913);
    int i = paramColorNote.getServiceType();
    return new ColorNote.Builder().a(i | 0x80000000).a(paramColorNote.getSubType()).a(paramColorNote.getExtLong()).b(0).b(paramColorNote.getMainTitle()).c(str).d(paramColorNote.getPicUrl()).a(paramColorNote.getReserve()).a();
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    localStringBuilder.append("");
    localStringBuilder.append(arrayOfStackTraceElement[2].getClassName());
    localStringBuilder.append(".");
    localStringBuilder.append(arrayOfStackTraceElement[2].getMethodName());
    localStringBuilder.append(": ");
    localStringBuilder.append(arrayOfStackTraceElement[2].getLineNumber());
    return localStringBuilder.toString();
  }
  
  public static String a(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramColorNote.getMainTitle());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramColorNote.getSubTitle());
    localStringBuilder.append(". ");
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    if (StringUtil.a(paramString)) {
      return "";
    }
    try
    {
      paramString = new Uri.Builder().scheme("webcover").authority(paramString).build().toString();
      return paramString;
    }
    catch (RuntimeException paramString)
    {
      QLog.e("ColorNoteUtils", 1, paramString, new Object[0]);
    }
    return "";
  }
  
  public static String a(List<ColorNote> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      Object localObject = new ArrayList(paramList);
      paramList = new StringBuilder();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramList.append(a((ColorNote)((Iterator)localObject).next()));
      }
      return paramList.toString();
    }
    return "";
  }
  
  public static void a(Context paramContext)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(paramContext, 2131756189);
    localQQCustomDialog.setContentView(2131558978);
    localQQCustomDialog.dismissMessage();
    ((RelativeLayout.LayoutParams)localQQCustomDialog.getTitleTextView().getLayoutParams()).bottomMargin = ViewUtils.a(26.0F);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setTitle(paramContext.getString(2131690905));
    localQQCustomDialog.setNegativeButton(paramContext.getString(2131690904), new ColorNoteUtils.1(localQQCustomDialog, paramContext));
    if (localQQCustomDialog.isShowing()) {
      localQQCustomDialog.dismiss();
    }
    localQQCustomDialog.show();
    paramContext = localQQCustomDialog.getTitleTextView();
    paramContext.setClickable(true);
    paramContext.setFocusable(true);
    paramContext.setFocusableInTouchMode(true);
    AccessibilityUtil.a(paramContext, true);
  }
  
  public static void a(Context paramContext, ColorNote paramColorNote)
  {
    Intent localIntent = new Intent(paramContext, ColorNoteSmallScreenService.class);
    localIntent.putExtra("key_upcoming_notify", 2);
    localIntent.putExtra("key_upcoming_color_note", paramColorNote);
    paramContext.startService(localIntent);
  }
  
  public static void a(ColorNote paramColorNote)
  {
    boolean bool = e(paramColorNote.mMainTitle) ^ true;
    if ((e(paramColorNote.mSubTitle) ^ true ^ bool))
    {
      if (bool)
      {
        paramColorNote.mSubTitle = paramColorNote.mMainTitle;
        return;
      }
      paramColorNote.mMainTitle = paramColorNote.mSubTitle;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public static boolean a(ColorNote paramColorNote)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramColorNote != null) {
      if (StringUtil.a(paramColorNote.mMainTitle))
      {
        bool1 = bool2;
        if (StringUtil.a(paramColorNote.mSubTitle)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(ColorNote paramColorNote1, ColorNote paramColorNote2)
  {
    if ((paramColorNote1 != null) && (paramColorNote2 != null)) {
      return (paramColorNote1.mServiceType == paramColorNote2.getServiceType()) && (a(paramColorNote1.mSubType, paramColorNote2.getSubType())) && (a(paramColorNote1.mMainTitle, paramColorNote2.getMainTitle())) && (a(paramColorNote1.mSubTitle, paramColorNote2.getSubTitle()));
    }
    return (paramColorNote1 == null) && (paramColorNote2 == null);
  }
  
  public static boolean a(String paramString)
  {
    Object localObject = a;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      if (StringUtil.a(paramString)) {
        return false;
      }
      int i = 0;
      while (i < a.size())
      {
        localObject = (String)a.get(i);
        if ((((String)localObject).length() <= paramString.length()) && (paramString.contains((CharSequence)localObject))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((StringUtil.a(paramString1) ^ true ^ StringUtil.a(paramString2) ^ true)) {
      return false;
    }
    if (paramString1 == null) {
      return true;
    }
    return paramString1.equals(paramString2);
  }
  
  public static boolean a(List<ColorNote> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return false;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (c((ColorNote)paramList.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(List<ColorNote> paramList1, List<ColorNote> paramList2)
  {
    if ((paramList1 == null) && (paramList2 == null)) {
      return true;
    }
    if (paramList1 != null)
    {
      if (paramList2 == null) {
        return false;
      }
      if (paramList1.size() != paramList2.size()) {
        return false;
      }
      int j = paramList1.size();
      int i = 0;
      while (i < j)
      {
        if (!paramList2.contains((ColorNote)paramList1.get(i))) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static int b(int paramInt)
  {
    if (paramInt != 16908289)
    {
      if (paramInt != 16908292)
      {
        if (paramInt != 17039360)
        {
          if (paramInt != 17104896) {
            return 0;
          }
          return 2;
        }
        return 1;
      }
      return 4;
    }
    return 3;
  }
  
  public static ColorNote b(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {
      return null;
    }
    int i = a(paramColorNote.getServiceType());
    return new ColorNote.Builder().a(i).a(paramColorNote.mExtLong).a(paramColorNote.getSubType()).b(paramColorNote.getMainTitle()).c(paramColorNote.getSubTitle()).a(paramColorNote.getReserve()).a();
  }
  
  public static String b(List<ColorNote> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append(((ColorNote)paramList.next()).toString());
    }
    return localStringBuilder.toString();
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static boolean b(ColorNote paramColorNote)
  {
    boolean bool = false;
    if (paramColorNote == null) {
      return false;
    }
    if ((paramColorNote.getServiceType() & 0x80000000) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean b(String paramString)
  {
    if (b.size() != 0)
    {
      if (StringUtil.a(paramString)) {
        return false;
      }
      int i = 0;
      while (i < b.size())
      {
        String str = (String)b.get(i);
        if ((str.length() <= paramString.length()) && (paramString.contains(str))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static ColorNote c(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {
      return new ColorNote.Builder().a();
    }
    return new ColorNote.Builder().a(paramColorNote.getServiceType()).a(paramColorNote.getSubType()).b(paramColorNote.getMainTitle()).c(paramColorNote.getSubTitle()).d(paramColorNote.getPicUrl()).a(paramColorNote.getReserve()).b(paramColorNote.mExtra).a();
  }
  
  public static boolean c(ColorNote paramColorNote)
  {
    boolean bool2 = false;
    if (paramColorNote == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (d(paramColorNote))
    {
      bool1 = bool2;
      if ((paramColorNote.mExtLong & 1L) == 1L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean c(String paramString)
  {
    if (c.size() != 0)
    {
      if (StringUtil.a(paramString)) {
        return false;
      }
      int i = 0;
      while (i < c.size())
      {
        String str = (String)c.get(i);
        if ((str.length() <= paramString.length()) && (paramString.contains(str))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean d(ColorNote paramColorNote)
  {
    return paramColorNote.getServiceType() == 17235968;
  }
  
  public static boolean d(String paramString)
  {
    if (StringUtil.a(paramString)) {
      return false;
    }
    paramString = Uri.parse(paramString);
    try
    {
      paramString = paramString.getQueryParameter("_wv");
      if (StringUtil.a(paramString)) {
        return false;
      }
      long l = Long.parseLong(paramString);
      return (l & 0x1000) != 0L;
    }
    catch (Exception paramString)
    {
      QLog.e("ColorNoteUtils", 1, "parse long error: ", paramString);
    }
    return false;
  }
  
  public static boolean e(String paramString)
  {
    if (StringUtil.a(paramString)) {
      return true;
    }
    int i = 0;
    while (i < paramString.length())
    {
      if (!Character.isWhitespace(paramString.charAt(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.ColorNoteUtils
 * JD-Core Version:    0.7.0.1
 */