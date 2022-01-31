package com.tencent.mobileqq.search.util;

import aibi;
import aibj;
import aibk;
import aibl;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.PublicAccountConfigFolder;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.confess.ConfessMsgListFragment;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussion;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.model.ContactSearchModelNewTroop;
import com.tencent.mobileqq.search.model.ContactSearchModelNewTroopMember;
import com.tencent.mobileqq.search.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.model.ContactSearchModelRecentUser;
import com.tencent.mobileqq.search.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.search.model.RelativeWord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpelling;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpellingAll;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
import pb.unite.search.DynamicSearch.SubItem;
import pb.unite.search.DynamicSearch.SubItemMedia;
import pb.unite.search.DynamicSearch.SubItemText;

public class SearchUtils
{
  public static int a;
  public static long a;
  public static Paint a;
  private static HashMap a;
  public static boolean a;
  public static char[] a;
  public static int b;
  public static long b;
  public static boolean b;
  private static int c;
  
  static
  {
    jdField_a_of_type_Long = -1L;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_Long = 0L;
    jdField_a_of_type_Int = 11;
    jdField_b_of_type_Int = 2;
    jdField_a_of_type_ArrayOfChar = new char[] { 44, 46, 8230, -244, 12290, -225, -255, -162, 35, -230, 12289, 8220, 8221, 8216, 8217, -248, -247, 45, 8212, -229, 64, 64, 35, 215, 37, 37, 46, 183, 47, 92, 12298, 12299, 12304, 12305, 60, 62 };
  }
  
  public static float a(TextView paramTextView, CharSequence paramCharSequence)
  {
    if ((paramTextView == null) || (TextUtils.isEmpty(paramCharSequence))) {
      return 0.0F;
    }
    return paramTextView.getPaint().measureText(paramCharSequence.toString());
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int k = paramString1.length();
    int m = paramString2.length();
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { k + 1, m + 1 });
    int i = 0;
    while (i < m + 1)
    {
      arrayOfInt[0][i] = i;
      i += 1;
    }
    i = 0;
    while (i < k + 1)
    {
      arrayOfInt[i][0] = i;
      i += 1;
    }
    i = 1;
    while (i < k + 1)
    {
      int j = 1;
      if (j < m + 1)
      {
        if (paramString1.charAt(i - 1) == paramString2.charAt(j - 1)) {
          arrayOfInt[i][j] = arrayOfInt[(i - 1)][(j - 1)];
        }
        for (;;)
        {
          j += 1;
          break;
          arrayOfInt[i][j] = (Math.min(arrayOfInt[(i - 1)][(j - 1)], Math.min(arrayOfInt[(i - 1)][j], arrayOfInt[i][(j - 1)])) + 1);
        }
      }
      i += 1;
    }
    return arrayOfInt[k][m];
  }
  
  private static long a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l2 = -9223372036854775808L;
    long l1 = l2;
    if (paramInt1 >= 0)
    {
      if (paramInt2 != paramInt3) {
        break label35;
      }
      if (!paramBoolean2) {
        break label31;
      }
      l1 = IContactSearchable.w;
    }
    label31:
    label35:
    do
    {
      return l1;
      return IContactSearchable.u;
      if (paramInt1 == 0)
      {
        if (paramBoolean2) {
          return IContactSearchable.w;
        }
        return IContactSearchable.v;
      }
      l1 = l2;
    } while (paramBoolean1);
    return IContactSearchable.w;
  }
  
  private static long a(String paramString, ChnToSpell.ChnSpelling paramChnSpelling, boolean paramBoolean)
  {
    paramString = a(paramChnSpelling, paramString);
    return a(paramString[0], paramString[1], paramChnSpelling.jdField_a_of_type_JavaUtilList.size(), false, paramBoolean);
  }
  
  public static long a(String paramString1, String paramString2, long paramLong)
  {
    return a(paramString1, paramString2, paramLong, true, false, true);
  }
  
  public static long a(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    return a(paramString1, paramString2, paramLong, paramBoolean, false, false);
  }
  
  public static long a(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 1;
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    long l;
    label123:
    do
    {
      for (;;)
      {
        return -9223372036854775808L;
        paramString1 = paramString1.toLowerCase();
        paramString2 = paramString2.toLowerCase();
        l = a(paramString1, paramString2, paramBoolean2, paramBoolean3);
        if (l != -9223372036854775808L) {
          return IContactSearchable.r + l + paramLong;
        }
        if (paramBoolean1)
        {
          ChnToSpell.ChnSpelling localChnSpelling = ChnToSpell.a(paramString2, 1);
          if (!paramString2.equals(localChnSpelling.jdField_a_of_type_JavaLangString)) {}
          while (i != 0)
          {
            l = a(paramString1, localChnSpelling, paramBoolean3);
            if (l == -9223372036854775808L) {
              break label123;
            }
            return IContactSearchable.s + l + paramLong;
            i = 0;
          }
        }
      }
      l = a(paramString1, ChnToSpell.a(paramString2, 2), paramBoolean3);
    } while (l == -9223372036854775808L);
    return IContactSearchable.s + l + paramLong;
  }
  
  public static long a(String paramString1, String paramString2, ChnToSpell.ChnSpelling paramChnSpelling1, ChnToSpell.ChnSpelling paramChnSpelling2, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    long l;
    label116:
    do
    {
      for (;;)
      {
        return -9223372036854775808L;
        paramString1 = paramString1.toLowerCase();
        paramString2 = paramString2.toLowerCase();
        l = a(paramString1, paramString2, false, false);
        if (l != -9223372036854775808L) {
          return IContactSearchable.r + l + paramLong;
        }
        if ((paramChnSpelling1 != null) && (paramChnSpelling2 != null))
        {
          if (!paramString2.equals(paramChnSpelling1.jdField_a_of_type_JavaLangString)) {}
          for (int i = 1; i != 0; i = 0)
          {
            l = a(paramString1, paramChnSpelling1, false);
            if (l == -9223372036854775808L) {
              break label116;
            }
            return IContactSearchable.s + l + paramLong;
          }
        }
      }
      l = a(paramString1, paramChnSpelling2, false);
    } while (l == -9223372036854775808L);
    return IContactSearchable.s + l + paramLong;
  }
  
  private static long a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramString2.indexOf(paramString1), paramString1.length(), paramString2.length(), paramBoolean1, paramBoolean2);
  }
  
  public static aibl a(CharSequence paramCharSequence, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchUtils", 2, "getHighLightMatchedMessage" + paramCharSequence + "|" + paramString);
    }
    if ((TextUtils.isEmpty(paramCharSequence)) || (TextUtils.isEmpty(paramString))) {
      return new aibl(paramCharSequence);
    }
    String str = paramCharSequence.toString().toLowerCase();
    int m = str.indexOf(paramString);
    int k = paramString.length();
    int j = k;
    int i = m;
    Object localObject = paramString;
    if (m < 0)
    {
      paramString = paramString.toLowerCase();
      m = str.indexOf(paramString);
      j = k;
      i = m;
      localObject = paramString;
      if (m < 0)
      {
        if (!paramBoolean) {
          break label298;
        }
        localObject = a(str, paramString, 1);
        if (localObject[0] < 0) {
          break label256;
        }
        i = localObject[0];
        j = localObject[1];
      }
    }
    for (localObject = paramString;; localObject = paramString)
    {
      paramCharSequence = new SpannableStringBuilder(paramCharSequence);
      for (k = i; (k >= 0) && (k < paramCharSequence.length()) && (k + j <= paramCharSequence.length()) && (j > 0); k = str.indexOf((String)localObject, k + j)) {
        paramCharSequence.setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131492951)), k, k + j, 17);
      }
      label256:
      localObject = a(str, paramString, 2);
      if (localObject[0] < 0) {
        break;
      }
      i = localObject[0];
      j = localObject[1];
    }
    return new aibl(paramCharSequence);
    label298:
    return new aibl(paramCharSequence);
    return new aibl(paramCharSequence, i, j);
  }
  
  public static Drawable a(Bitmap paramBitmap)
  {
    Drawable localDrawable = BaseApplicationImpl.sApplication.getResources().getDrawable(2130839213);
    if ((localDrawable instanceof SkinnableBitmapDrawable)) {
      ((SkinnableBitmapDrawable)localDrawable).setGravity(81);
    }
    if ((localDrawable instanceof BitmapDrawable)) {
      ((BitmapDrawable)localDrawable).setGravity(81);
    }
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    return new LayerDrawable(new Drawable[] { new BitmapDrawable(paramBitmap), localDrawable });
  }
  
  public static Drawable a(FaceDecoder paramFaceDecoder, IFaceModel paramIFaceModel)
  {
    return a(paramFaceDecoder, paramIFaceModel.a(), paramIFaceModel.a());
  }
  
  public static Drawable a(FaceDecoder paramFaceDecoder, String paramString, int paramInt)
  {
    if (paramInt == 103) {}
    for (int i = 1;; i = paramInt)
    {
      Bitmap localBitmap = paramFaceDecoder.a(i, paramString);
      if (localBitmap != null)
      {
        if (paramInt == 103) {
          return a(localBitmap);
        }
        return new BitmapDrawable(localBitmap);
      }
      if (!paramFaceDecoder.a()) {
        paramFaceDecoder.a(paramString, i, true, (byte)1);
      }
      if (paramInt == 1) {
        return ImageUtil.b();
      }
      if (paramInt == 101) {
        return ImageUtil.e();
      }
      if (paramInt == 4) {
        return ImageUtil.c();
      }
      if (paramInt == 11) {
        return new BitmapDrawable(ImageUtil.b());
      }
      if (paramInt == 102) {
        return BaseApplicationImpl.sApplication.getResources().getDrawable(2130841615);
      }
      if (paramInt == 106) {
        return BaseApplicationImpl.sApplication.getResources().getDrawable(2130843974);
      }
      if (paramInt == 105)
      {
        paramFaceDecoder = PublicAccountConfigUtil.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext(), 1);
        if ((paramFaceDecoder != null) && (paramFaceDecoder.a() != null)) {
          return paramFaceDecoder.a();
        }
        return PublicAccountConfigUtil.a(BaseApplicationImpl.sApplication, 1);
      }
      if (String.valueOf(9999L).equals(paramString)) {
        return BaseApplicationImpl.sApplication.getResources().getDrawable(2130839220);
      }
      if (String.valueOf(9994L).equals(paramString)) {
        return BaseApplicationImpl.sApplication.getResources().getDrawable(2130839227);
      }
      if (String.valueOf(9992L).equals(paramString)) {
        return BaseApplicationImpl.sApplication.getResources().getDrawable(2130839225);
      }
      if (AppConstants.au.equals(paramString)) {
        return ServiceAccountFolderManager.a();
      }
      if (String.valueOf(9980L).equals(paramString)) {
        return BaseApplicationImpl.sApplication.getResources().getDrawable(2130839226);
      }
      if (String.valueOf(9973L).equals(paramString)) {
        return BaseApplicationImpl.sApplication.getResources().getDrawable(2130842185);
      }
      if (paramInt == 9889987) {
        return BaseApplicationImpl.sApplication.getResources().getDrawable(2130840600);
      }
      if (paramInt == 108)
      {
        paramFaceDecoder = BaseApplicationImpl.sApplication.getRuntime();
        if (paramFaceDecoder != null) {
          return ((BlessManager)paramFaceDecoder.getManager(137)).a();
        }
      }
      else
      {
        if (String.valueOf(AppConstants.C).equals(paramString)) {
          return BaseApplicationImpl.sApplication.getResources().getDrawable(2130839217);
        }
        if (paramInt == 110)
        {
          paramFaceDecoder = PublicAccountConfigUtil.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), BaseApplicationImpl.sApplication, 2);
          if ((paramFaceDecoder != null) && (paramFaceDecoder.a() != null)) {
            return paramFaceDecoder.a().getConstantState().newDrawable();
          }
          return PublicAccountConfigUtil.a(BaseApplicationImpl.sApplication, 2).getConstantState().newDrawable();
        }
        if (paramInt == 111)
        {
          paramFaceDecoder = PublicAccountConfigUtil.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), BaseApplicationImpl.sApplication, 3);
          if ((paramFaceDecoder != null) && (paramFaceDecoder.a() != null)) {
            return paramFaceDecoder.a().getConstantState().newDrawable();
          }
          return PublicAccountConfigUtil.a(BaseApplicationImpl.sApplication, 3).getConstantState().newDrawable();
        }
      }
      return ImageUtil.b();
    }
  }
  
  public static SearchMatchResult a(String paramString1, ChnToSpell.ChnSpellingAll paramChnSpellingAll1, String paramString2, ChnToSpell.ChnSpellingAll paramChnSpellingAll2, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (paramString2.contains(paramString1))) {
      return null;
    }
    if ((paramChnSpellingAll1 == null) || (paramChnSpellingAll2 == null)) {
      return null;
    }
    if (SpellTool.a(paramString1) == 0) {
      return null;
    }
    String str1 = paramString1.toLowerCase();
    paramString2 = paramString2.toLowerCase();
    if (paramString2.contains(str1)) {
      return null;
    }
    SearchMatchResult localSearchMatchResult = new SearchMatchResult();
    String str2 = paramChnSpellingAll1.jdField_b_of_type_JavaLangString;
    String str4 = paramChnSpellingAll1.jdField_c_of_type_JavaLangString;
    paramChnSpellingAll1 = paramChnSpellingAll1.jdField_d_of_type_JavaLangString;
    String str3 = paramChnSpellingAll2.jdField_b_of_type_JavaLangString;
    String str5 = paramChnSpellingAll2.jdField_c_of_type_JavaLangString;
    paramString1 = paramChnSpellingAll2.jdField_d_of_type_JavaLangString;
    int i5 = SpellTool.a(paramString2);
    int i1 = 0;
    int i4 = (int)(paramLong >> SearchConfigManager.contactSearchFieldBaseBit);
    VADHelper.a("voice_search_distance_cost");
    int k = a(str2, str3);
    VADHelper.b("voice_search_distance_cost");
    int i2 = 0;
    int m = 0;
    int j = 0;
    int i3 = 0;
    int n = 0;
    int i = 0;
    switch (i5)
    {
    default: 
      n = i1;
      m = k;
    case 0: 
      for (;;)
      {
        localSearchMatchResult.jdField_d_of_type_Int = m;
        localSearchMatchResult.jdField_a_of_type_Boolean = true;
        localSearchMatchResult.jdField_a_of_type_JavaLangString = str1;
        localSearchMatchResult.jdField_b_of_type_JavaLangString = str2;
        localSearchMatchResult.jdField_c_of_type_JavaLangString = paramString2;
        localSearchMatchResult.jdField_d_of_type_JavaLangString = str3;
        k = j;
        if (paramString2.length() < j) {
          k = 0;
        }
        localSearchMatchResult.jdField_a_of_type_Int = k;
        j = i;
        if (paramString2.length() - localSearchMatchResult.jdField_a_of_type_Int < i) {
          j = paramString2.length() - localSearchMatchResult.jdField_a_of_type_Int;
        }
        localSearchMatchResult.jdField_b_of_type_Int = j;
        localSearchMatchResult.jdField_c_of_type_Int = ((100 - m << 8) + (n << 4) + i4);
        return localSearchMatchResult;
        if (str3.contains(str2))
        {
          j = str3.indexOf(str2);
          i = str2.length();
          m = 0;
          n = i1;
        }
        else
        {
          m = k;
          n = i1;
          if (k < 1)
          {
            j = 0;
            i = paramString2.length();
            m = k;
            n = i1;
          }
        }
      }
    case 1: 
      if (str3.contains(str2))
      {
        i = str3.indexOf(str2);
        if (paramString2.length() <= i) {
          break label1021;
        }
        if (SpellTool.a(paramString2.charAt(i)))
        {
          if (str1.length() + i > paramString2.length()) {
            break label1021;
          }
          m = ((Integer)paramChnSpellingAll2.jdField_b_of_type_JavaUtilList.get(i)).intValue();
          if (str1.length() + i + 1 < paramChnSpellingAll2.jdField_b_of_type_JavaUtilList.size())
          {
            j = ((Integer)paramChnSpellingAll2.jdField_b_of_type_JavaUtilList.get(str1.length() + i + 1)).intValue();
            label518:
            if (!str2.equalsIgnoreCase(str3.substring(m, j))) {
              break label1021;
            }
            m = str1.length();
            k = 0;
            j = i;
            i = m;
          }
        }
      }
      break;
    }
    for (;;)
    {
      m = k;
      n = i1;
      break;
      j = str3.length();
      break label518;
      m = str2.length();
      j = i;
      k = 0;
      i = m;
      continue;
      m = k;
      n = i1;
      if (!str5.contains(str4)) {
        break;
      }
      j = str5.indexOf(str4);
      if (j > -1)
      {
        m = str1.length();
        n = ((Integer)paramChnSpellingAll2.jdField_b_of_type_JavaUtilList.get(j)).intValue();
        if (j + m + 1 < paramChnSpellingAll2.jdField_b_of_type_JavaUtilList.size())
        {
          i = ((Integer)paramChnSpellingAll2.jdField_b_of_type_JavaUtilList.get(str1.length() + j + 1)).intValue();
          label700:
          paramChnSpellingAll2 = str3.substring(n, i);
          paramString1 = paramString1.substring(n, i);
          VADHelper.a("voice_search_distance_cost");
          n = a(str2, paramChnSpellingAll2);
          VADHelper.b("voice_search_distance_cost");
          i = k;
          if (n < k) {
            i = n;
          }
          n = b(paramChnSpellingAll1, paramString1);
          k = i;
          i = m;
          m = n;
        }
      }
      for (;;)
      {
        n = m;
        m = k;
        break;
        i = str3.length();
        break label700;
        if (str5.contains(str4))
        {
          i = str5.indexOf(str4);
          if (i > -1)
          {
            m = str1.length();
            n = ((Integer)paramChnSpellingAll2.jdField_b_of_type_JavaUtilList.get(i)).intValue();
            if (i + m + 1 < paramChnSpellingAll2.jdField_b_of_type_JavaUtilList.size())
            {
              j = ((Integer)paramChnSpellingAll2.jdField_b_of_type_JavaUtilList.get(str1.length() + i + 1)).intValue();
              label891:
              paramChnSpellingAll2 = str3.substring(n, j);
              paramString1 = paramString1.substring(n, j);
              VADHelper.a("voice_search_distance_cost");
              j = a(str2, paramChnSpellingAll2);
              VADHelper.b("voice_search_distance_cost");
              if (j >= k) {
                break label985;
              }
              k = j;
              j = i;
              i = m;
            }
          }
        }
        for (;;)
        {
          VADHelper.a("voice_search_sy_cost");
          n = b(paramChnSpellingAll1, paramString1);
          VADHelper.b("voice_search_sy_cost");
          m = k;
          break;
          j = str3.length();
          break label891;
          label985:
          j = i;
          i = m;
          continue;
          i = n;
          j = m;
        }
        m = 0;
        i = i3;
        j = i2;
      }
      label1021:
      i = 0;
      j = 0;
    }
  }
  
  public static CharSequence a(TextView paramTextView, float paramFloat, int paramInt, CharSequence paramCharSequence, List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramTextView, paramFloat, paramInt, paramCharSequence, paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public static CharSequence a(TextView paramTextView, float paramFloat, int paramInt, CharSequence paramCharSequence, List paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchUtils", 2, "getHighLightMatchedMessageWithWidth" + paramCharSequence);
    }
    float f1 = a(paramTextView, "测");
    f1 = paramInt * paramFloat - f1 * (paramInt - 1);
    if ((TextUtils.isEmpty(paramCharSequence)) || (paramTextView == null) || (f1 <= 0.0F)) {
      paramList = "";
    }
    int i;
    int j;
    label121:
    float f2;
    label365:
    do
    {
      do
      {
        do
        {
          return paramList;
          if ((paramList != null) && (paramList.size() != 0)) {
            break;
          }
          paramList = paramCharSequence;
        } while (!paramBoolean3);
        return a(paramTextView, f1, paramCharSequence);
        i = -1;
        j = 0;
        k = 0;
        int n;
        int m;
        if (k < paramList.size())
        {
          localObject = (String)paramList.get(k);
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            n = i;
            m = j;
          }
        }
        for (;;)
        {
          k += 1;
          j = m;
          i = n;
          break label121;
          if ((i >= 0) && (j > 1) && (((String)localObject).length() == 1))
          {
            paramList = paramCharSequence;
            if (a(paramTextView, paramCharSequence) <= f1) {
              break;
            }
            if ((!TextUtils.isEmpty(paramCharSequence)) && (i >= 0) && (i + j <= paramCharSequence.length())) {
              break label365;
            }
            paramList = paramCharSequence;
            if (!paramBoolean3) {
              break;
            }
            return a(paramTextView, f1, paramCharSequence);
          }
          aibl localaibl = a(paramCharSequence, (String)localObject, paramBoolean1);
          localObject = localaibl.jdField_a_of_type_JavaLangCharSequence;
          m = j;
          n = i;
          paramCharSequence = (CharSequence)localObject;
          if (i == -1)
          {
            m = j;
            n = i;
            paramCharSequence = (CharSequence)localObject;
            if (j == 0)
            {
              m = j;
              n = i;
              paramCharSequence = (CharSequence)localObject;
              if (localaibl.jdField_a_of_type_Int != -1)
              {
                m = j;
                n = i;
                paramCharSequence = (CharSequence)localObject;
                if (localaibl.jdField_b_of_type_Int > 0)
                {
                  n = localaibl.jdField_a_of_type_Int;
                  m = localaibl.jdField_b_of_type_Int;
                  paramCharSequence = (CharSequence)localObject;
                }
              }
            }
          }
        }
        localObject = paramCharSequence.subSequence(0, i + j);
        paramList = (List)localObject;
        if (i + j < paramCharSequence.length()) {
          paramList = localObject + "…";
        }
        if (a(paramTextView, paramList) > f1) {
          break;
        }
        paramList = paramCharSequence;
      } while (!paramBoolean3);
      return a(paramTextView, f1, paramCharSequence);
      if ((paramInt == 1) || (!paramBoolean2)) {
        return a(paramTextView, f1, paramCharSequence, i, j);
      }
      f2 = paramFloat / 2.0F;
      paramList = paramCharSequence;
    } while (f2 > a(paramTextView, paramCharSequence));
    Object localObject = new StringBuilder();
    paramInt = 0;
    paramFloat = 0.0F;
    int k = paramInt;
    if (paramFloat < f2)
    {
      k = paramInt;
      if (paramInt < paramCharSequence.length())
      {
        ((StringBuilder)localObject).append(paramCharSequence.charAt(paramInt));
        paramFloat = a(paramTextView, ((StringBuilder)localObject).toString());
        if (paramFloat <= f2) {
          break label713;
        }
        ((StringBuilder)localObject).deleteCharAt(paramInt);
        k = paramInt - 1;
      }
    }
    label567:
    paramList = new SpannableStringBuilder(paramCharSequence.subSequence(0, k + 1));
    paramInt = k + 1;
    paramFloat = f1 - a(paramTextView, ((StringBuilder)localObject).toString());
    if (paramInt < paramCharSequence.length())
    {
      paramCharSequence = paramCharSequence.subSequence(paramInt, paramCharSequence.length());
      if (paramInt < i) {
        break label740;
      }
      paramTextView = a(paramTextView, paramFloat, paramCharSequence);
      if (paramInt >= i + j) {
        break label730;
      }
      paramInt = Math.min(paramTextView.length(), j - (paramInt - i));
      paramTextView = new SpannableStringBuilder(paramTextView);
      paramTextView.setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131492951)), 0, paramInt, 17);
      paramList.append(paramTextView);
    }
    for (;;)
    {
      return paramList;
      label713:
      k = paramInt;
      if (paramFloat == f2) {
        break label567;
      }
      paramInt += 1;
      break;
      label730:
      paramList.append(paramTextView);
      continue;
      label740:
      paramList.append(a(paramTextView, paramFloat, paramCharSequence, i - paramInt, j));
    }
  }
  
  public static CharSequence a(TextView paramTextView, float paramFloat, int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString2)) {
      localArrayList.add(paramString2);
    }
    return a(paramTextView, paramFloat, paramInt, paramString1, localArrayList, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public static CharSequence a(TextView paramTextView, float paramFloat, CharSequence paramCharSequence)
  {
    if ((TextUtils.isEmpty(paramCharSequence)) || (paramTextView == null) || (paramFloat <= 0.0F)) {
      localObject = "";
    }
    do
    {
      return localObject;
      localObject = paramCharSequence;
    } while (paramFloat > a(paramTextView, paramCharSequence));
    Object localObject = new StringBuilder();
    float f = 0.0F;
    int i = 0;
    int j = i;
    if (f < paramFloat)
    {
      j = i;
      if (i < paramCharSequence.length())
      {
        ((StringBuilder)localObject).append(paramCharSequence.charAt(i));
        f = a(paramTextView, ((StringBuilder)localObject).toString());
        if (f <= paramFloat) {
          break label180;
        }
        ((StringBuilder)localObject).deleteCharAt(i);
        j = i - 1;
      }
    }
    label121:
    localObject = paramCharSequence.subSequence(0, j + 1);
    paramTextView = new SpannableStringBuilder((CharSequence)localObject);
    if (j < paramCharSequence.length() - 1)
    {
      paramTextView.delete(j, j + 1);
      paramTextView.append("…", 0, 1);
    }
    for (;;)
    {
      return paramTextView;
      label180:
      j = i;
      if (f == paramFloat) {
        break label121;
      }
      i += 1;
      break;
      paramTextView = new SpannableStringBuilder((CharSequence)localObject);
    }
  }
  
  public static CharSequence a(TextView paramTextView, float paramFloat, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramCharSequence)) || (paramTextView == null) || (paramFloat <= 0.0F))
    {
      localObject = "";
      return localObject;
    }
    if ((paramInt1 < 0) || (paramInt1 + paramInt2 > paramCharSequence.length())) {
      return a(paramTextView, paramFloat, paramCharSequence);
    }
    Object localObject = paramCharSequence.subSequence(paramInt1, paramInt1 + paramInt2);
    float f1 = a(paramTextView, ((CharSequence)localObject).toString());
    paramInt2 = paramInt1 + paramInt2;
    localObject = new StringBuilder((CharSequence)localObject);
    float f2 = f1;
    int j = paramInt2;
    int k;
    int i;
    if (f1 < paramFloat)
    {
      k = 0;
      i = paramInt1;
      paramInt1 = paramInt2;
      f2 = f1;
      label120:
      paramInt2 = i;
      j = paramInt1;
      if (f2 < paramFloat) {
        if (i <= 0)
        {
          paramInt2 = i;
          j = paramInt1;
          if (paramInt1 >= paramCharSequence.length()) {}
        }
        else
        {
          paramInt2 = i;
          f1 = f2;
          if (k % 2 != 0) {
            break label348;
          }
          paramInt2 = i;
          f1 = f2;
          if (i <= 0) {
            break label348;
          }
          i -= 1;
          ((StringBuilder)localObject).insert(0, paramCharSequence.charAt(i));
          f2 = a(paramTextView, ((StringBuilder)localObject).toString());
          paramInt2 = i;
          f1 = f2;
          if (f2 <= paramFloat) {
            break label348;
          }
          paramInt2 = i + 1;
          ((StringBuilder)localObject).deleteCharAt(0);
          j = paramInt1;
        }
      }
    }
    for (;;)
    {
      label247:
      paramTextView = new SpannableStringBuilder(paramCharSequence.subSequence(paramInt2, j));
      if ((paramInt2 > 0) && (!TextUtils.isEmpty(paramTextView)))
      {
        paramTextView.delete(0, 1);
        paramTextView = new SpannableStringBuilder("…").append(paramTextView);
      }
      for (;;)
      {
        localObject = paramTextView;
        if (j >= paramCharSequence.length()) {
          break;
        }
        localObject = paramTextView;
        if (TextUtils.isEmpty(paramTextView)) {
          break;
        }
        paramTextView.delete(paramTextView.length() - 1, paramTextView.length());
        paramTextView.append("…");
        return paramTextView;
        label348:
        if ((k % 2 != 0) && (paramInt1 < paramCharSequence.length()))
        {
          i = paramInt1 + 1;
          ((StringBuilder)localObject).insert(((StringBuilder)localObject).length(), paramCharSequence.charAt(i - 1));
          f2 = a(paramTextView, ((StringBuilder)localObject).toString());
          paramInt1 = i;
          f1 = f2;
          if (f2 > paramFloat)
          {
            ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
            j = i - 1;
            break label247;
          }
        }
        k += 1;
        i = paramInt2;
        f2 = f1;
        break label120;
        while ((f2 > paramFloat) && (j > paramInt1))
        {
          ((StringBuilder)localObject).deleteCharAt(j - paramInt1 - 1);
          j -= 1;
          f2 = a(paramTextView, ((StringBuilder)localObject).toString());
        }
      }
      paramInt2 = paramInt1;
    }
  }
  
  public static CharSequence a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    int n = 0;
    if (jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      jdField_a_of_type_AndroidGraphicsPaint = ((TextView)LayoutInflater.from(paramQQAppInterface.getApp()).inflate(2130971558, null).findViewById(2131363397)).getPaint();
      if (jdField_c_of_type_Int == 0) {
        jdField_c_of_type_Int = paramQQAppInterface.getApp().getResources().getDimensionPixelOffset(2131559126);
      }
    }
    String str = paramString1.toLowerCase();
    int m = str.indexOf(paramString2);
    int k = paramString2.length();
    int j = k;
    int i = m;
    paramQQAppInterface = paramString2;
    if (m < 0)
    {
      paramString2 = paramString2.toLowerCase();
      m = str.indexOf(paramString2);
      j = k;
      i = m;
      paramQQAppInterface = paramString2;
      if (m < 0)
      {
        paramQQAppInterface = a(str, paramString2, 1);
        if (paramQQAppInterface[0] < 0) {
          break label422;
        }
        i = paramQQAppInterface[0];
        j = paramQQAppInterface[1];
        paramQQAppInterface = paramString2;
      }
    }
    float f1 = jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString1);
    float f2 = jdField_a_of_type_AndroidGraphicsPaint.measureText(paramQQAppInterface);
    label294:
    if ((f1 >= jdField_c_of_type_Int) && (i > 0))
    {
      f1 = Math.min(f2 + jdField_a_of_type_AndroidGraphicsPaint.measureText("…"), f1);
      f2 = jdField_c_of_type_Int - f1;
      paramString2 = paramString1.substring(0, i);
      float[] arrayOfFloat = new float[paramString2.length()];
      jdField_a_of_type_AndroidGraphicsPaint.getTextWidths(paramString2, arrayOfFloat);
      k = arrayOfFloat.length - 1;
      f1 = 0.0F;
      m = 0;
      label249:
      if (k >= 0)
      {
        m += 1;
        f1 += arrayOfFloat[k];
        if ((f1 > f2) || (m >= paramInt))
        {
          if (f2 > 0.0F) {
            break label471;
          }
          paramInt = n;
          paramString1 = "…" + paramString1.substring(i - paramInt);
          paramString2 = "…" + str.substring(i - paramInt);
          i = paramInt + 1;
        }
      }
    }
    for (;;)
    {
      paramString1 = new SpannableStringBuilder(paramString1);
      for (;;)
      {
        if (i >= 0)
        {
          paramString1.setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131492951)), i, i + j, 17);
          i = paramString2.indexOf(paramQQAppInterface, j + i);
          j = paramQQAppInterface.length();
          continue;
          label422:
          paramQQAppInterface = a(str, paramString2, 2);
          if (paramQQAppInterface[0] >= 0)
          {
            i = paramQQAppInterface[0];
            j = paramQQAppInterface[1];
            paramQQAppInterface = paramString2;
            break;
          }
          return new SpannableStringBuilder(paramString1);
          k -= 1;
          break label249;
        }
      }
      return paramString1;
      label471:
      paramInt = m;
      break label294;
      paramString2 = str;
    }
  }
  
  public static CharSequence a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, SearchMatchResult paramSearchMatchResult)
  {
    if (paramSearchMatchResult == null) {
      return new SpannableStringBuilder(paramString1);
    }
    if (jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      jdField_a_of_type_AndroidGraphicsPaint = ((TextView)LayoutInflater.from(paramQQAppInterface.getApp()).inflate(2130971558, null).findViewById(2131363397)).getPaint();
      if (jdField_c_of_type_Int == 0) {
        jdField_c_of_type_Int = paramQQAppInterface.getApp().getResources().getDimensionPixelOffset(2131559126);
      }
    }
    paramQQAppInterface = paramString1.toLowerCase();
    int k = paramSearchMatchResult.jdField_a_of_type_Int;
    int m = paramSearchMatchResult.jdField_b_of_type_Int;
    if ((k < 0) || (k > paramString1.length()) || (!paramString1.equalsIgnoreCase(paramSearchMatchResult.jdField_c_of_type_JavaLangString)) || (paramSearchMatchResult.jdField_d_of_type_Int > 1)) {
      return new SpannableStringBuilder(paramString1);
    }
    float f1 = jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString1);
    float f2 = jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString2);
    int i;
    int j;
    if ((f1 >= jdField_c_of_type_Int) && (k >= 0))
    {
      f1 = Math.min(f2 + jdField_a_of_type_AndroidGraphicsPaint.measureText("…"), f1);
      f2 = jdField_c_of_type_Int - f1;
      paramString2 = paramString1.substring(0, k);
      paramSearchMatchResult = new float[paramString2.length()];
      jdField_a_of_type_AndroidGraphicsPaint.getTextWidths(paramString2, paramSearchMatchResult);
      i = paramSearchMatchResult.length - 1;
      f1 = 0.0F;
      j = 0;
      if (i >= 0)
      {
        j += 1;
        f1 += paramSearchMatchResult[i];
        if ((f1 > f2) || (j >= paramInt))
        {
          if (f2 <= 0.0F) {
            j = 0;
          }
          paramString1 = "…" + paramString1.substring(k - j);
          new StringBuilder().append("…").append(paramQQAppInterface.substring(k - j)).toString();
        }
      }
    }
    for (paramInt = j + 1;; paramInt = k)
    {
      paramQQAppInterface = new SpannableStringBuilder(paramString1);
      if (paramInt + m <= paramString1.length()) {
        paramQQAppInterface.setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131492951)), paramInt, paramInt + m, 17);
      }
      return paramQQAppInterface;
      i -= 1;
      break;
    }
  }
  
  public static CharSequence a(CharSequence paramCharSequence)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append("(").append(paramCharSequence).append(")");
    return localSpannableStringBuilder;
  }
  
  public static CharSequence a(String paramString, int paramInt, ArrayList paramArrayList)
  {
    int j = 0;
    if (paramString == null) {
      return null;
    }
    if ((paramInt < 0) || (paramArrayList == null) || (paramArrayList.isEmpty())) {
      return new SpannableStringBuilder(paramString);
    }
    Object localObject1 = paramString.getBytes();
    if (paramInt >= localObject1.length) {
      return new SpannableStringBuilder(paramString);
    }
    Object localObject2;
    if (paramInt > 0)
    {
      localObject2 = new byte[paramInt];
      System.arraycopy(localObject1, 0, localObject2, 0, localObject2.length);
    }
    for (paramInt = new String((byte[])localObject2).length();; paramInt = 0)
    {
      localObject1 = paramArrayList.iterator();
      do
      {
        i = j;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (String)((Iterator)localObject1).next();
      } while (paramString.toLowerCase().indexOf(((String)localObject2).toLowerCase()) != paramInt);
      int i = ((String)localObject2).length();
      if (paramInt <= 10)
      {
        localObject1 = paramString;
        if (paramInt > 6)
        {
          localObject1 = paramString;
          if (paramInt + i <= 10) {}
        }
      }
      else
      {
        localObject1 = "…" + paramString.substring(paramInt - 6);
      }
      paramString = new SpannableStringBuilder((CharSequence)localObject1);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (String)paramArrayList.next();
        paramInt = ((String)localObject1).toLowerCase().indexOf(((String)localObject2).toLowerCase());
        if (paramInt >= 0)
        {
          i = ((String)localObject2).length();
          while (paramInt >= 0)
          {
            paramString.setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131492951)), paramInt, paramInt + i, 17);
            paramInt = ((String)localObject1).toLowerCase().indexOf(((String)localObject2).toLowerCase(), paramInt + i);
          }
        }
      }
      return paramString;
    }
  }
  
  public static CharSequence a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, 10);
  }
  
  public static CharSequence a(String paramString1, String paramString2, int paramInt)
  {
    return a(paramString1, paramString2, paramInt, true);
  }
  
  public static CharSequence a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    String str = paramString1.toLowerCase();
    int m = str.indexOf(paramString2);
    int k = paramString2.length();
    int i = m;
    int j = k;
    Object localObject = paramString2;
    if (m < 0)
    {
      paramString2 = paramString2.toLowerCase();
      m = str.indexOf(paramString2);
      i = m;
      j = k;
      localObject = paramString2;
      if (m < 0)
      {
        if (!paramBoolean) {
          break label289;
        }
        localObject = a(str, paramString2, 1);
        if (localObject[0] < 0) {
          break label249;
        }
        i = localObject[0];
        j = localObject[1];
        localObject = paramString2;
      }
    }
    if ((i > paramInt) || ((i > 4) && (i + j > paramInt)))
    {
      paramString1 = "…" + paramString1.substring(i - 4);
      paramString2 = "…" + str.substring(i - 4);
      i = 5;
    }
    for (;;)
    {
      paramString1 = new SpannableStringBuilder(paramString1);
      for (;;)
      {
        if (i >= 0)
        {
          paramString1.setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131492951)), i, i + j, 17);
          i = paramString2.indexOf((String)localObject, i + j);
          j = ((String)localObject).length();
          continue;
          label249:
          localObject = a(str, paramString2, 2);
          if (localObject[0] >= 0)
          {
            i = localObject[0];
            j = localObject[1];
            break;
          }
          return new SpannableStringBuilder(paramString1);
          label289:
          return new SpannableStringBuilder(paramString1);
        }
      }
      return paramString1;
      paramString2 = str;
    }
  }
  
  public static CharSequence a(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = paramString1.toLowerCase();
    paramString2 = paramString2.toLowerCase();
    int j = str.indexOf(paramString2);
    int i = paramString2.length();
    int[] arrayOfInt;
    int k;
    if (j < 0) {
      if (paramBoolean)
      {
        arrayOfInt = a(str, paramString2, 1);
        if (arrayOfInt[0] >= 0)
        {
          j = arrayOfInt[0];
          i = arrayOfInt[1];
          k = 0;
          label63:
          paramString1 = new SpannableStringBuilder(paramString1);
        }
      }
    }
    for (;;)
    {
      paramString1.setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131492951)), j, j + i, 17);
      if (k != 0)
      {
        j = str.indexOf(paramString2, j + i);
        i = paramString2.length();
        if (j >= 0)
        {
          k = 1;
          continue;
          arrayOfInt = a(str, paramString2, 2);
          if (arrayOfInt[0] >= 0)
          {
            j = arrayOfInt[0];
            i = arrayOfInt[1];
            break;
          }
          return new SpannableStringBuilder(paramString1);
          return new SpannableStringBuilder(paramString1);
          k = 1;
          break label63;
        }
        return paramString1;
      }
      arrayOfInt = a(str.substring(j + i), paramString2, 1);
      if (arrayOfInt[0] >= 0)
      {
        j = j + arrayOfInt[0] + i;
        i = arrayOfInt[1];
      }
      else
      {
        arrayOfInt = a(str.substring(j + i), paramString2, 2);
        if (arrayOfInt[0] < 0) {
          return paramString1;
        }
        j = j + arrayOfInt[0] + i;
        i = arrayOfInt[1];
      }
    }
    return paramString1;
  }
  
  public static CharSequence a(String paramString, ArrayList paramArrayList, int paramInt)
  {
    int i = 0;
    Object localObject = paramArrayList.iterator();
    int j = 0;
    String str1;
    String str2;
    int k;
    if (((Iterator)localObject).hasNext())
    {
      str1 = (String)((Iterator)localObject).next();
      str2 = paramString.toLowerCase();
      i = str2.indexOf(str1);
      j = str1.length();
      if (i >= 0) {
        k = j;
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        return new SpannableStringBuilder(paramString);
        int m = str2.indexOf(str1.toLowerCase());
        i = m;
        k = j;
        if (m >= 0) {
          continue;
        }
        i = j;
        j = m;
        break;
      }
      if (i <= paramInt)
      {
        localObject = paramString;
        if (i > 6)
        {
          localObject = paramString;
          if (k + i <= paramInt) {}
        }
      }
      else
      {
        localObject = "…" + paramString.substring(i - 6);
      }
      paramString = new SpannableStringBuilder((CharSequence)localObject);
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
        str1 = (String)paramArrayList.next();
        str2 = ((String)localObject).toLowerCase();
        paramInt = str2.indexOf(str1);
        i = str1.length();
        if (paramInt >= 0) {
          break label271;
        }
        paramInt = str2.indexOf(str1.toLowerCase());
      } while (paramInt < 0);
      label271:
      for (;;)
      {
        paramString.setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131492951)), paramInt, paramInt + i, 17);
        break;
        return paramString;
      }
      k = i;
      i = j;
    }
  }
  
  public static CharSequence a(JSONArray paramJSONArray)
  {
    int i = 0;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    for (;;)
    {
      if ((paramJSONArray != null) && (i < paramJSONArray.length()))
      {
        Object localObject = paramJSONArray.optJSONObject(i);
        String str = ((JSONObject)localObject).optString("word");
        localObject = ((JSONObject)localObject).optString("color");
        SpannableString localSpannableString;
        if (!TextUtils.isEmpty(str)) {
          localSpannableString = new SpannableString(str);
        }
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor((String)localObject)), 0, str.length(), 17);
          }
          localSpannableStringBuilder.append(localSpannableString);
          i += 1;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.SearchUtils", 1, " color value is not valid. colorStr = " + (String)localObject);
          }
        }
      }
    }
    return localSpannableStringBuilder;
  }
  
  public static String a(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return null;
    }
    return Pattern.compile("[\\s|\\t|\\r|\\n]+").matcher(paramCharSequence).replaceAll("");
  }
  
  public static String a(String paramString, List paramList)
  {
    return a(paramString, a(paramList));
  }
  
  public static String a(String paramString, long[] paramArrayOfLong)
  {
    try
    {
      paramArrayOfLong = (String)jdField_a_of_type_JavaUtilHashMap.get(b(paramString, paramArrayOfLong));
      paramString = paramArrayOfLong;
      if (paramArrayOfLong == null) {
        paramString = "";
      }
      return paramString;
    }
    catch (RuntimeException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils getReportVersion", 2, paramString.toString());
      }
    }
    return "";
  }
  
  public static String a(List paramList)
  {
    return a(a(paramList), "::");
  }
  
  public static String a(long[] paramArrayOfLong)
  {
    return a(paramArrayOfLong, "::");
  }
  
  public static String a(long[] paramArrayOfLong, String paramString)
  {
    if (paramArrayOfLong == null) {
      throw new RuntimeException("generateMaskString. masks can not be null.");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramArrayOfLong[i]).append(paramString);
      i += 1;
    }
    if (localStringBuilder.length() > 0) {
      return localStringBuilder.substring(0, localStringBuilder.length() - paramString.length());
    }
    return "";
  }
  
  public static String a(String... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return null;
    }
    int i = 0;
    while (i < paramVarArgs.length)
    {
      if (!TextUtils.isEmpty(paramVarArgs[i])) {
        return paramVarArgs[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static HashMap a(HashMap paramHashMap)
  {
    HashMap localHashMap = paramHashMap;
    if (paramHashMap == null) {
      localHashMap = new HashMap();
    }
    localHashMap.put("input_type", String.valueOf(jdField_b_of_type_Long));
    localHashMap.put("support_sougou_ime", String.valueOf(jdField_b_of_type_Boolean));
    return localHashMap;
  }
  
  public static List a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.optJSONObject(i);
        localObject = new RelativeWord(((JSONObject)localObject).optString("word"), ((JSONObject)localObject).optString("url"));
        if (((RelativeWord)localObject).a()) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static List a(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null) {
      throw new RuntimeException("convertIntArrayToLongList. array can not be null.");
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfLong.length);
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      localArrayList.add(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a()
  {
    int i = 70;
    int k = 1;
    int j;
    if (SearchStatisticsConstants.a(70) != 0)
    {
      j = 1;
      if (SearchStatisticsConstants.a(80) == 0) {
        break label77;
      }
      label23:
      if ((j == 0) || (k == 0)) {
        break label82;
      }
      i = 90;
    }
    for (;;)
    {
      if (i != 0) {
        ReportController.b(null, "CliOper", "", "", "0X8005ECF", "0X8005ECF", i, 0, "", "", "", "");
      }
      return;
      j = 0;
      break;
      label77:
      k = 0;
      break label23;
      label82:
      if (j == 0) {
        if (k != 0) {
          i = 80;
        } else {
          i = 0;
        }
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString1, String paramString2, int paramInt4)
  {
    int i = -1;
    HashMap localHashMap;
    switch (paramInt1)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "moduleType:" + i + " moduleIndex:" + paramInt2 + " itemLinePosition:" + paramInt3 + " isGroupSearch:" + paramBoolean);
      }
      if (paramBoolean)
      {
        localHashMap = new HashMap();
        localHashMap.put("moduleType", Integer.toString(i));
        localHashMap.put("moduleIndex", Integer.toString(paramInt2));
        localHashMap.put("itemLinePosition", Integer.toString(paramInt3));
        localHashMap.put("toUin", paramString1);
        localHashMap.put("keyword", paramString2);
        if (paramInt4 == 12)
        {
          localHashMap.put("isFolder", "1");
          label190:
          StatisticCollector.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "NetGroupSearchItemClick", true, 0L, 0L, localHashMap, null);
          paramString1 = "";
          switch (paramInt1)
          {
          }
        }
      }
      break;
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", paramString1, paramString1, 0, 0, String.valueOf(paramInt3), "", "", "");
      return;
      i = 70;
      break;
      i = 80;
      break;
      i = 90;
      break;
      localHashMap.put("isFolder", "0");
      break label190;
      localHashMap = new HashMap();
      localHashMap.put("moduleType", Integer.toString(i));
      localHashMap.put("itemLinePosition", Integer.toString(paramInt3));
      localHashMap.put("toUin", paramString1);
      localHashMap.put("keyword", paramString2);
      if (paramInt4 == 12) {
        localHashMap.put("isFolder", "1");
      }
      for (;;)
      {
        StatisticCollector.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "NetModelSearchItemClick", true, 0L, 0L, localHashMap, null);
        break;
        localHashMap.put("isFolder", "0");
      }
      if (paramInt3 == 0)
      {
        paramString1 = "0X80061BA";
      }
      else
      {
        paramString1 = "0X80061B9";
        continue;
        if (paramInt3 == 0)
        {
          paramString1 = "0X80061BD";
        }
        else
        {
          paramString1 = "0X80061BC";
          continue;
          if (paramInt3 == 0)
          {
            paramString1 = "0X80061C0";
          }
          else
          {
            paramString1 = "0X80061BF";
            continue;
            if (paramInt3 == 0) {
              paramString1 = "0X80061C3";
            } else {
              paramString1 = "0X80061C2";
            }
          }
        }
      }
    }
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    Object localObject2 = new HashMap();
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    switch (paramInt1)
    {
    case 3: 
    case 7: 
    case 11: 
    case 12: 
    case 13: 
    case 16: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 29: 
    case 34: 
    case 39: 
    case 45: 
    case 46: 
    case 47: 
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
    case 58: 
    default: 
    case 2: 
    case 4: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 14: 
    case 15: 
    case 17: 
    case 18: 
    case 27: 
    case 28: 
    case 31: 
    case 32: 
    case 33: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 30: 
    case 40: 
    case 41: 
    case 42: 
    case 43: 
    case 44: 
      do
      {
        do
        {
          return;
          ((HashMap)localObject2).put("newtask", Boolean.valueOf(false));
          ((HashMap)localObject2).put("fid", Integer.valueOf(paramInt1));
          Utils.gotoFunctionActivity(paramContext, (HashMap)localObject2);
          return;
          Utils.gotoFaceToFaceSend(paramContext, (HashMap)localObject2);
          return;
          SubAccountAssistantForward.a((QQAppInterface)localObject1, paramContext, String.valueOf(9992L));
          ((QQAppInterface)localObject1).a().c(String.valueOf(9992L), 7000);
          return;
          localObject1 = new Intent(paramContext, NewFriendActivity.class);
          ((Intent)localObject1).setFlags(67108864);
          paramContext.startActivity((Intent)localObject1);
          return;
          MsgBoxListActivity.a(paramContext, 1001, String.valueOf(9999L));
          return;
          localObject1 = new Intent(paramContext, ServiceAccountFolderActivity.class);
          ((Intent)localObject1).putExtra("from_source", "from_search");
          ((Intent)localObject1).setFlags(67108864);
          paramContext.startActivity((Intent)localObject1);
        } while (!QLog.isColorLevel());
        QLog.d("ContactSearchModelTool", 2, "enterServiceAccountFolderActivityFromSearch");
        return;
        localObject2 = new Intent(paramContext, ActivateFriendActivity.class);
        ((Intent)localObject2).putExtra("af_key_from", 5);
        paramContext.startActivity((Intent)localObject2);
      } while ((paramInt2 != 2) && (paramInt2 != 1));
      ReportController.b((QQAppInterface)localObject1, "CliOper", "", "", "0X8006477", "0X8006477", paramInt2, 0, "", "", "", "");
      return;
    }
    ConfessMsgListFragment.a(paramContext, 2);
  }
  
  public static void a(Intent paramIntent, ForwardBaseOption paramForwardBaseOption)
  {
    int j = 1006;
    boolean bool2 = false;
    String str1;
    String str2;
    int k;
    String str3;
    int i;
    int m;
    boolean bool1;
    if ((paramIntent != null) && (paramForwardBaseOption != null))
    {
      str1 = paramIntent.getStringExtra("contactSearchResultUin");
      str2 = paramIntent.getStringExtra("contactSearchResultTroopUin");
      k = paramIntent.getIntExtra("contactSearchResultUinType", 0);
      str3 = paramIntent.getStringExtra("contactSearchResultName");
      i = ForwardAbility.ForwardAbilityType.a.intValue();
      m = paramIntent.getIntExtra("chooseFriendFrom", 0);
      if (k == 56938) {
        break label329;
      }
      bool1 = true;
      if ((!(paramForwardBaseOption instanceof ForwardShareCardOption)) || (!paramIntent.hasExtra("contactSearchResultPhoneContactMobileCode")) || (k == 1006)) {
        break label395;
      }
      str1 = paramIntent.getStringExtra("contactSearchResultPhoneContactMobileCode");
    }
    for (;;)
    {
      switch (j)
      {
      }
      for (;;)
      {
        if (!StringUtil.a(str1))
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("uin", str1);
          localBundle.putInt("uintype", j);
          localBundle.putString("uinname", str3);
          localBundle.putString("troop_uin", str2);
          localBundle.putInt("chooseFriendFrom", m);
          localBundle.putBoolean("bindContact", bool1);
          bool1 = bool2;
          if (paramIntent != null) {
            bool1 = paramIntent.getBooleanExtra("choose_friend_needConfirm", false);
          }
          if (bool1)
          {
            str1 = paramIntent.getStringExtra("choose_friend_confirmTitle");
            paramIntent = paramIntent.getStringExtra("choose_friend_confirmContent");
            localBundle.putBoolean("choose_friend_needConfirm", bool1);
            localBundle.putString("choose_friend_confirmTitle", str1);
            localBundle.putString("choose_friend_confirmContent", paramIntent);
          }
          paramForwardBaseOption.a(i, localBundle);
          paramForwardBaseOption.e();
        }
        return;
        label329:
        bool1 = false;
        break;
        i = ForwardAbility.ForwardAbilityType.b.intValue();
        continue;
        i = ForwardAbility.ForwardAbilityType.c.intValue();
        continue;
        i = ForwardAbility.ForwardAbilityType.d.intValue();
        continue;
        i = ForwardAbility.ForwardAbilityType.h.intValue();
        continue;
        i = ForwardAbility.ForwardAbilityType.h.intValue();
        continue;
        i = ForwardAbility.ForwardAbilityType.i.intValue();
      }
      label395:
      j = k;
    }
  }
  
  public static void a(View paramView, IContactSearchModel paramIContactSearchModel)
  {
    Activity localActivity = (Activity)paramView.getContext();
    Intent localIntent = new Intent();
    localIntent.putExtra("contactSearchResultUin", paramIContactSearchModel.a());
    localIntent.putExtra("contactSearchResultUinType", paramIContactSearchModel.b());
    localIntent.putExtra("contactSearchResultName", paramIContactSearchModel.c());
    localIntent.putExtra("contactSearchResultNick", paramIContactSearchModel.d());
    if (((paramIContactSearchModel instanceof ContactSearchModelDiscussion)) || ((paramIContactSearchModel instanceof ContactSearchModelTroop)) || ((paramIContactSearchModel instanceof ContactSearchModelNewTroop))) {
      paramView = paramIContactSearchModel.a();
    }
    for (;;)
    {
      String str;
      if ((paramIContactSearchModel instanceof ContactSearchModelPhoneContact))
      {
        localIntent.putExtra("contactSearchResultPhoneContactOriginBinder", ((ContactSearchModelPhoneContact)paramIContactSearchModel).a.originBinder);
        ContactSearchModelPhoneContact localContactSearchModelPhoneContact = (ContactSearchModelPhoneContact)paramIContactSearchModel;
        str = localContactSearchModelPhoneContact.a.mobileCode;
        if (!TextUtils.isEmpty(str)) {
          break label282;
        }
        str = localContactSearchModelPhoneContact.a.mobileNo;
      }
      label282:
      for (;;)
      {
        localIntent.putExtra("contactSearchResultPhoneContactMobileCode", str);
        localIntent.putExtra("contactSearchResultPhoneContactNationCode", ((ContactSearchModelPhoneContact)paramIContactSearchModel).a.nationCode);
        localIntent.putExtra("contactSearchResultPhoneContactAbility", ((ContactSearchModelPhoneContact)paramIContactSearchModel).a.ability);
        localIntent.putExtra("contactSearchResultTroopUin", paramView);
        localActivity.setResult(-1, localIntent);
        localActivity.finish();
        localActivity.overridePendingTransition(0, 0);
        return;
        if ((paramIContactSearchModel instanceof ContactSearchModelDiscussionMember))
        {
          paramView = ((ContactSearchModelDiscussionMember)paramIContactSearchModel).e();
          break;
        }
        if ((paramIContactSearchModel instanceof ContactSearchModelNewTroopMember))
        {
          paramView = ((ContactSearchModelNewTroopMember)paramIContactSearchModel).jdField_a_of_type_JavaLangString;
          break;
        }
        if (!(paramIContactSearchModel instanceof ContactSearchModelRecentUser)) {
          break label285;
        }
        paramView = ((ContactSearchModelRecentUser)paramIContactSearchModel).e();
        break;
      }
      label285:
      paramView = "";
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, List paramList, String paramString3, Rect paramRect, SearchUtils.GenerateGifWithTextCallback paramGenerateGifWithTextCallback)
  {
    ThreadManager.post(new aibk(paramString1, paramString2, paramList, paramString3, paramRect, paramAppInterface, paramGenerateGifWithTextCallback), 8, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (paramQQAppInterface == null) {
      paramQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    for (;;)
    {
      if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.uniteSearch.SearchUtils", 2, "jumpUtilargument is empty");
        }
        return;
      }
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
        paramQQAppInterface.putExtra("url", paramString);
        paramContext.startActivity(paramQQAppInterface);
        return;
      }
      if ((paramContext instanceof BaseActivity))
      {
        paramQQAppInterface = JumpParser.a(paramQQAppInterface, paramContext, paramString);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface.b();
          return;
        }
        paramContext.startActivity(new Intent(paramContext, JumpActivity.class).setData(Uri.parse(paramString)));
        return;
      }
      paramContext.startActivity(new Intent(paramContext, JumpActivity.class).setData(Uri.parse(paramString)));
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ThreadManager.postImmediately(new aibi(paramInt, paramString2, paramString3, paramString1, paramQQAppInterface), null, false);
  }
  
  public static void a(IContactSearchModel paramIContactSearchModel, View paramView)
  {
    ThreadManager.postImmediately(new aibj(paramView, paramIContactSearchModel), null, true);
  }
  
  public static void a(String paramString)
  {
    String[] arrayOfString;
    if (!TextUtils.isEmpty(paramString))
    {
      arrayOfString = paramString.split(" ");
      if (arrayOfString == null) {}
    }
    for (int i = arrayOfString.length;; i = 0)
    {
      if (i > 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("searchUtils", 2, "discuss -searchKey:" + paramString + " count:" + i);
        }
        ReportController.b(null, "CliOper", "", "", "0X8005E0F", "0X8005E0F", 0, 0, "" + i, "", "", "");
      }
      return;
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, View paramView)
  {
    boolean bool = a(paramView.getContext());
    paramInt3 += 1;
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "moduleType:" + paramInt1 + " itemLinePosition:" + paramInt3);
    }
    if (bool)
    {
      int i = SearchStatisticsConstants.a(paramInt1);
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "moduleIndex:" + i + " searchKey:" + paramString);
      }
      ReportController.b(null, "CliOper", "", "", "0X8005E10", "0X8005E10", paramInt1, 0, String.valueOf(i), String.valueOf(paramInt3), String.valueOf(paramInt2), "");
      paramView = new HashMap();
      paramView.put("moduleType", Integer.toString(paramInt1));
      paramView.put("moduleIndex", Integer.toString(i));
      paramView.put("moduleChildType", Integer.toString(paramInt2));
      paramView.put("itemLinePosition", Integer.toString(paramInt3));
      paramView.put("keyword", paramString);
      if (UniteSearchActivity.jdField_b_of_type_Long != -1L) {
        paramView.put("stay_time", String.valueOf(System.currentTimeMillis() - UniteSearchActivity.jdField_b_of_type_Long));
      }
      StatisticCollector.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "GroupSearchItemClick", true, 0L, 0L, a(paramView), null);
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005E11", "0X8005E11", paramInt1, 0, "", String.valueOf(paramInt3), String.valueOf(paramInt2), "");
    paramView = new HashMap();
    paramView.put("moduleType", Integer.toString(paramInt1));
    paramView.put("moduleChildType", Integer.toString(paramInt2));
    paramView.put("itemLinePosition", Integer.toString(paramInt3));
    paramView.put("keyword", paramString);
    StatisticCollector.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "ModelSearchItemClick", true, 0L, 0L, paramView, null);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, View paramView)
  {
    boolean bool = a(paramView.getContext());
    int i = ((Integer)paramView.getTag(2131362080)).intValue() + 1;
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "moduleType:" + paramInt1 + " itemLinePosition:" + i);
    }
    if (bool)
    {
      int j = SearchStatisticsConstants.a(paramInt1);
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "moduleIndex:" + j + " searchKey:" + paramString);
      }
      ReportController.b(null, "CliOper", "", "", "0X8005E10", "0X8005E10", paramInt1, 0, String.valueOf(j), String.valueOf(i), String.valueOf(paramInt2), "");
      paramView = new HashMap();
      paramView.put("moduleType", Integer.toString(paramInt1));
      paramView.put("moduleIndex", Integer.toString(j));
      paramView.put("moduleChildType", Integer.toString(paramInt2));
      paramView.put("itemLinePosition", Integer.toString(i));
      paramView.put("keyword", paramString);
      if (UniteSearchActivity.jdField_b_of_type_Long != -1L) {
        paramView.put("stay_time", String.valueOf(System.currentTimeMillis() - UniteSearchActivity.jdField_b_of_type_Long));
      }
      StatisticCollector.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "GroupSearchItemClick", true, 0L, 0L, a(paramView), null);
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005E11", "0X8005E11", paramInt1, 0, "", String.valueOf(i), String.valueOf(paramInt2), "");
    paramView = new HashMap();
    paramView.put("moduleType", Integer.toString(paramInt1));
    paramView.put("moduleChildType", Integer.toString(paramInt2));
    paramView.put("itemLinePosition", Integer.toString(i));
    paramView.put("keyword", paramString);
    StatisticCollector.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "ModelSearchItemClick", true, 0L, 0L, paramView, null);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, View paramView, String paramString2, boolean paramBoolean, int paramInt3)
  {
    boolean bool = a(paramView.getContext());
    int i = ((Integer)paramView.getTag(2131362080)).intValue() + 1;
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "moduleType:" + paramInt1 + " itemLinePosition:" + i);
    }
    if (bool)
    {
      int j = SearchStatisticsConstants.a(paramInt1);
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "moduleIndex:" + j + " searchKey:" + paramString1);
      }
      ReportController.b(null, "CliOper", "", "", "0X8005E10", "0X8005E10", paramInt1, 0, String.valueOf(j), String.valueOf(i), String.valueOf(paramInt2), "");
      paramView = new HashMap();
      paramView.put("moduleType", Integer.toString(paramInt1));
      paramView.put("moduleIndex", Integer.toString(j));
      paramView.put("moduleChildType", Integer.toString(paramInt2));
      paramView.put("itemLinePosition", Integer.toString(i));
      paramView.put("toUin", paramString2);
      paramView.put("keyword", paramString1);
      if (paramBoolean)
      {
        paramString1 = "1";
        paramView.put("sFrom", paramString1);
        if (paramInt3 != 12) {
          break label333;
        }
        paramView.put("isFolder", "1");
      }
      for (;;)
      {
        if (UniteSearchActivity.jdField_b_of_type_Long != -1L) {
          paramView.put("stay_time", String.valueOf(System.currentTimeMillis() - UniteSearchActivity.jdField_b_of_type_Long));
        }
        StatisticCollector.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "GroupSearchItemClick", true, 0L, 0L, a(paramView), null);
        return;
        paramString1 = "0";
        break;
        label333:
        paramView.put("isFolder", "0");
      }
    }
    ReportController.b(null, "CliOper", "", "", "0X8005E11", "0X8005E11", paramInt1, 0, "", String.valueOf(i), String.valueOf(paramInt2), "");
    paramView = new HashMap();
    paramView.put("moduleType", Integer.toString(paramInt1));
    paramView.put("moduleChildType", Integer.toString(paramInt2));
    paramView.put("itemLinePosition", Integer.toString(i));
    paramView.put("keyword", paramString1);
    paramView.put("toUin", paramString2);
    if (paramBoolean)
    {
      paramString1 = "1";
      paramView.put("sFrom", paramString1);
      if (paramInt3 != 12) {
        break label509;
      }
      paramView.put("isFolder", "1");
    }
    for (;;)
    {
      StatisticCollector.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "ModelSearchItemClick", true, 0L, 0L, paramView, null);
      return;
      paramString1 = "0";
      break;
      label509:
      paramView.put("isFolder", "0");
    }
  }
  
  public static void a(String paramString, int paramInt, View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "moduleType:40 -3 searchKey:" + "");
      }
      ReportController.b(null, "CliOper", "", "", "0X8005E12", "0X8005E12", 40, 0, "3", "", "", "");
    }
    do
    {
      return;
      if (!a(paramView.getContext())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "moduleType:" + paramInt + " -1 searchKey:" + "");
      }
      ReportController.b(null, "CliOper", "", "", "0X8005E12", "0X8005E12", paramInt, 0, "1", "", "", "");
    } while (!UniteSearchActivity.jdField_a_of_type_Boolean);
    if (UniteSearchActivity.e == -1)
    {
      ReportController.b(null, "CliOper", "", "", "0X8007E2E", "0X8007E2E", 2, 0, "", "" + UniteSearchActivity.jdField_b_of_type_Int, UniteSearchActivity.jdField_a_of_type_JavaLangString, "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8007E2E", "0X8007E2E", 1, 0, "", "" + UniteSearchActivity.jdField_b_of_type_Int, UniteSearchActivity.jdField_a_of_type_JavaLangString, "");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "moduleType:" + paramInt + " -2 searchKey:" + "");
    }
    ReportController.b(null, "CliOper", "", "", "0X8005E12", "0X8005E12", paramInt, 0, "2", "", "", "");
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    new ReportTask(null).a("dc00899").b("Grp_all_search").c(paramString1).d(paramString2).a(paramInt1).b(paramInt2).a(paramVarArgs).a();
  }
  
  public static void a(String paramString1, String paramString2, String... paramVarArgs)
  {
    a(paramString1, paramString2, 0, 0, paramVarArgs);
  }
  
  public static void a(String paramString1, long[] paramArrayOfLong, String paramString2)
  {
    try
    {
      jdField_a_of_type_JavaUtilHashMap.put(b(paramString1, paramArrayOfLong), paramString2);
      return;
    }
    catch (RuntimeException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("searchUtils updateReportVersion", 2, paramString1.toString());
    }
  }
  
  public static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean a(long paramLong)
  {
    if (paramLong <= 0L) {}
    while ((paramLong == 1073745984L) || (paramLong == 2049L) || (paramLong == 1004L) || (paramLong == 64L) || (paramLong == 4097L)) {
      return false;
    }
    return true;
  }
  
  private static boolean a(Context paramContext)
  {
    return ((Activity)paramContext instanceof UniteSearchActivity);
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return false;
      paramString = paramString.trim();
      i = paramString.length();
    } while ((i < 5) || (i > 15));
    try
    {
      Long.parseLong(paramString);
      return true;
    }
    catch (NumberFormatException paramString) {}
    return false;
  }
  
  private static boolean a(List paramList)
  {
    if (paramList != null)
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        if (!TextUtils.isEmpty(((DynamicSearch.SubItemText)paramList.get(i)).text.get().toStringUtf8())) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean a(DynamicSearch.SubItem paramSubItem)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    switch (paramSubItem.layout_id.get())
    {
    default: 
      bool1 = false;
    case 1: 
    case 2: 
    case 3: 
      do
      {
        do
        {
          return bool1;
          return a(paramSubItem.title.get());
        } while ((a(paramSubItem.title.get())) && (b(paramSubItem.media_list.get())));
        return false;
      } while ((a(paramSubItem.title.get())) && (b(paramSubItem.media_list.get())));
      return false;
    }
    if (!a(paramSubItem.title.get()))
    {
      bool1 = bool2;
      if (!a(paramSubItem.summary.get())) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public static int[] a(ChnToSpell.ChnSpelling paramChnSpelling, String paramString)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp7_5 = arrayOfInt;
    tmp7_5[0] = -1;
    int[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 0;
    tmp11_7;
    int j = paramChnSpelling.jdField_a_of_type_JavaLangString.indexOf(paramString);
    if (j < 0) {
      return arrayOfInt;
    }
    int i = 0;
    int k;
    if (i < paramChnSpelling.jdField_a_of_type_JavaUtilList.size())
    {
      if (j == ((Integer)paramChnSpelling.jdField_a_of_type_JavaUtilList.get(i)).intValue())
      {
        arrayOfInt[0] = i;
        k = i + 1;
        for (;;)
        {
          if ((k >= paramChnSpelling.jdField_a_of_type_JavaUtilList.size()) || (j + paramString.length() <= ((Integer)paramChnSpelling.jdField_a_of_type_JavaUtilList.get(k)).intValue()))
          {
            arrayOfInt[1] = (k - i);
            return arrayOfInt;
          }
          k += 1;
        }
      }
      if (j >= ((Integer)paramChnSpelling.jdField_a_of_type_JavaUtilList.get(i)).intValue()) {
        break label214;
      }
      k = paramChnSpelling.jdField_a_of_type_JavaLangString.indexOf(paramString, ((Integer)paramChnSpelling.jdField_a_of_type_JavaUtilList.get(i)).intValue());
      if (k < 0) {
        return arrayOfInt;
      }
      j = i - 1;
    }
    for (i = k;; i = k)
    {
      k = i;
      i = j + 1;
      j = k;
      break;
      return arrayOfInt;
      label214:
      k = j;
      j = i;
    }
  }
  
  public static int[] a(String paramString1, String paramString2, int paramInt)
  {
    return a(ChnToSpell.a(paramString1, paramInt), paramString2);
  }
  
  public static int[] a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = -1;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    label154:
    do
    {
      for (;;)
      {
        return arrayOfInt;
        paramString1 = paramString1.toLowerCase();
        paramString2 = paramString2.toLowerCase();
        arrayOfInt[0] = paramString2.indexOf(paramString1);
        if (arrayOfInt[0] != -1)
        {
          arrayOfInt[1] = paramString1.length();
          arrayOfInt[2] = 3;
          return arrayOfInt;
        }
        if (paramBoolean)
        {
          Object localObject = ChnToSpell.a(paramString2, 1);
          if (!paramString2.equals(((ChnToSpell.ChnSpelling)localObject).jdField_a_of_type_JavaLangString)) {}
          for (int i = 1; i != 0; i = 0)
          {
            localObject = a((ChnToSpell.ChnSpelling)localObject, paramString1);
            arrayOfInt[0] = localObject[0];
            arrayOfInt[1] = localObject[1];
            if (arrayOfInt[0] == -1) {
              break label154;
            }
            arrayOfInt[2] = 2;
            return arrayOfInt;
          }
        }
      }
      paramString1 = a(ChnToSpell.a(paramString2, 2), paramString1);
      arrayOfInt[0] = paramString1[0];
      arrayOfInt[1] = paramString1[1];
    } while (arrayOfInt[0] == -1);
    arrayOfInt[2] = 1;
    return arrayOfInt;
  }
  
  public static long[] a(List paramList)
  {
    if (paramList == null) {
      throw new RuntimeException("convertLongList2longArray. list can not be null.");
    }
    long[] arrayOfLong = new long[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfLong[i] = ((Long)paramList.get(i)).longValue();
      i += 1;
    }
    return arrayOfLong;
  }
  
  public static int b(String paramString1, String paramString2)
  {
    int i = 0;
    paramString1 = paramString1.split("#");
    SpellTool.a();
    paramString2 = paramString2.split("#");
    SpellTool.a();
    if (paramString1.length == paramString2.length)
    {
      float f3 = 14.0F / (paramString1.length * 2);
      float f2 = 0.0F;
      i = 0;
      while (i < paramString1.length)
      {
        float f1 = f2;
        if (!paramString1[i].equalsIgnoreCase(paramString2[i]))
        {
          String[] arrayOfString1 = paramString1[i].split("-");
          String[] arrayOfString2 = paramString2[i].split("-");
          f1 = f2;
          if (arrayOfString1 != null)
          {
            f1 = f2;
            if (arrayOfString1.length == arrayOfString2.length)
            {
              f1 = f2;
              if (SpellTool.a(arrayOfString1[0], arrayOfString2[0]))
              {
                f1 = f2;
                if (arrayOfString1.length > 1)
                {
                  f2 += f3;
                  f1 = f2;
                  if (SpellTool.b(arrayOfString1[1], arrayOfString2[1])) {
                    f1 = f2 + f3;
                  }
                }
              }
            }
          }
        }
        i += 1;
        f2 = f1;
      }
      i = (int)f2;
    }
    return i;
  }
  
  public static long b(String paramString1, String paramString2, long paramLong)
  {
    return a(paramString1, paramString2, paramLong, true);
  }
  
  public static CharSequence b(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    String str = paramString1.toLowerCase();
    Object localObject = paramString2.toLowerCase();
    int k = str.indexOf((String)localObject);
    int i = ((String)localObject).length();
    int j = k;
    if (k < 0)
    {
      if (!paramBoolean) {
        break label276;
      }
      int[] arrayOfInt = a(str, (String)localObject, 1);
      if (arrayOfInt[0] >= 0)
      {
        i = arrayOfInt[0];
        j = arrayOfInt[1];
        k = i;
        i = j;
        j = k;
      }
    }
    else
    {
      if ((j <= paramInt) && ((j <= 6) || (j + i <= paramInt))) {
        break label287;
      }
      paramString1 = "…" + paramString1.substring(j - 6);
      str = "…" + str.substring(j - 6);
      j = 7;
    }
    label276:
    label287:
    for (;;)
    {
      paramString1 = new SpannableStringBuilder(paramString1);
      for (;;)
      {
        if (j >= 0)
        {
          paramString1.setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131492951)), j, j + i, 17);
          j = str.indexOf(paramString2, j + i);
          i = paramString2.length();
          continue;
          localObject = a(str, (String)localObject, 2);
          if (localObject[0] >= 0)
          {
            i = localObject[0];
            j = localObject[1];
            break;
          }
          return new SpannableStringBuilder(paramString1);
          return new SpannableStringBuilder(paramString1);
        }
      }
      return paramString1;
    }
  }
  
  private static String b(String paramString, long[] paramArrayOfLong)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return str + "#" + paramString + "#" + b(paramArrayOfLong);
  }
  
  private static String b(long[] paramArrayOfLong)
  {
    return a(paramArrayOfLong, ":");
  }
  
  public static boolean b(long paramLong)
  {
    boolean bool2 = false;
    long[] arrayOfLong = UniteSearchHandler.c;
    int j = arrayOfLong.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfLong[i] == paramLong) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.trim();
    int i = 0;
    for (;;)
    {
      if (i >= paramString.length()) {
        break label51;
      }
      if ((paramString.charAt(i) < '0') && (paramString.charAt(i) > '9')) {
        break;
      }
      i += 1;
    }
    label51:
    return true;
  }
  
  private static boolean b(List paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (!TextUtils.isEmpty(((DynamicSearch.SubItemMedia)paramList.next()).coverUrl.get().toStringUtf8())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static CharSequence c(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    Object localObject2 = paramString1.toLowerCase();
    Object localObject1 = paramString2.toLowerCase();
    int k = ((String)localObject2).indexOf((String)localObject1);
    int i = ((String)localObject1).length();
    int j;
    if (k < 0) {
      if (paramBoolean)
      {
        int[] arrayOfInt = a((String)localObject2, (String)localObject1, 1);
        if (arrayOfInt[0] >= 0)
        {
          i = arrayOfInt[0];
          j = arrayOfInt[1];
          k = i;
          i = j;
        }
      }
    }
    for (;;)
    {
      if ((k > paramInt) || ((k > 6) && (k + i > paramInt)))
      {
        localObject1 = "(…" + paramString1.substring(k - 6) + ")";
        paramString1 = "(…" + ((String)localObject2).substring(k - 6) + ")";
      }
      for (paramInt = 8;; paramInt = k + 1)
      {
        localObject2 = new SpannableStringBuilder((CharSequence)localObject1);
        ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131494271)), 0, ((String)localObject1).length(), 17);
        while (paramInt >= 0)
        {
          ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131492951)), paramInt, paramInt + i, 17);
          paramInt = paramString1.indexOf(paramString2, paramInt + i);
          i = paramString2.length();
        }
        localObject1 = a((String)localObject2, (String)localObject1, 2);
        if (localObject1[0] >= 0)
        {
          i = localObject1[0];
          j = localObject1[1];
          break;
        }
        return new SpannableStringBuilder(paramString1);
        return new SpannableStringBuilder(paramString1);
        localObject1 = "(" + paramString1 + ")";
        paramString1 = "(" + (String)localObject2 + ")";
      }
      return localObject2;
    }
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.toLowerCase().trim();
    int i = 0;
    for (;;)
    {
      if (i >= paramString.length()) {
        break label54;
      }
      if ((paramString.charAt(i) < 'a') && (paramString.charAt(i) > 'z')) {
        break;
      }
      i += 1;
    }
    label54:
    return true;
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = paramString.split(" ");
    } while ((paramString == null) || (paramString.length <= 1));
    return true;
  }
  
  public static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = paramString.trim();
    } while (!Pattern.compile("^#[0-9a-fA-F]{3}|^#[0-9a-fA-F]{6}$|^#[0-9a-fA-F]{8}$").matcher(paramString).matches());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchUtils
 * JD-Core Version:    0.7.0.1
 */