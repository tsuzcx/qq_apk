package com.tencent.mobileqq.search.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.base.util.SearchStatisticsConstants;
import com.tencent.mobileqq.search.base.util.VADHelper;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussion;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelGlobalTroop;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelNewTroop;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelNewTroopMember;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelRecentUser;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.SearchMatchResult;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpelling;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpellingAll;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.URLUtil;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class SearchUtils
  extends BaseSearchUtil
{
  public static int a = 0;
  public static long a = -1L;
  public static Paint a;
  public static HashMap<ISearchResultModel, SearchUtils.ObjectItemInfo> a;
  public static boolean a = false;
  public static char[] a;
  public static int b = 0;
  public static long b = -1L;
  public static final HashMap<IModel, SearchUtils.ObjectItemInfo> b;
  public static boolean b = false;
  private static int jdField_c_of_type_Int = 0;
  public static long c = 0L;
  private static HashMap<String, String> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  private static boolean jdField_c_of_type_Boolean = true;
  public static long d;
  
  static
  {
    jdField_c_of_type_Long = 0L;
    jdField_a_of_type_Int = 11;
    jdField_b_of_type_Int = 2;
    jdField_a_of_type_ArrayOfChar = new char[] { 44, 46, 8230, -244, 12290, -225, -255, -162, 35, -230, 12289, 8220, 8221, 8216, 8217, -248, -247, 45, 8212, -229, 64, 64, 35, 215, 37, 37, 46, 183, 47, 92, 12298, 12299, 12304, 12305, 60, 62 };
    jdField_c_of_type_Int = 0;
    jdField_a_of_type_AndroidGraphicsPaint = null;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static float a(TextView paramTextView, CharSequence paramCharSequence)
  {
    if ((paramTextView != null) && (!TextUtils.isEmpty(paramCharSequence))) {
      return paramTextView.getPaint().measureText(paramCharSequence.toString());
    }
    return 0.0F;
  }
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  public static int a(AppInterface paramAppInterface, String paramString)
  {
    return ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getTroopMask(paramAppInterface, paramString);
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int k = paramString1.length();
    int m = paramString2.length();
    int n = k + 1;
    int i1 = m + 1;
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { n, i1 });
    int i = 0;
    while (i < i1)
    {
      arrayOfInt[0][i] = i;
      i += 1;
    }
    i = 0;
    while (i < n)
    {
      arrayOfInt[i][0] = i;
      i += 1;
    }
    i = 1;
    while (i < n)
    {
      int j = 1;
      while (j < i1)
      {
        int i2 = i - 1;
        int i3 = paramString1.charAt(i2);
        int i4 = j - 1;
        if (i3 == paramString2.charAt(i4)) {
          arrayOfInt[i][j] = arrayOfInt[i2][i4];
        } else {
          arrayOfInt[i][j] = (Math.min(arrayOfInt[i2][i4], Math.min(arrayOfInt[i2][j], arrayOfInt[i][i4])) + 1);
        }
        j += 1;
      }
      i += 1;
    }
    return arrayOfInt[k][m];
  }
  
  private static long a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 == paramInt3)
      {
        if (paramBoolean2) {
          return IContactSearchable.w;
        }
        return IContactSearchable.u;
      }
      if (paramInt1 == 0)
      {
        if (paramBoolean2) {
          return IContactSearchable.w;
        }
        return IContactSearchable.v;
      }
      if (!paramBoolean1) {
        return IContactSearchable.w;
      }
    }
    return -9223372036854775808L;
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
    if (!TextUtils.isEmpty(paramString2))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return -9223372036854775808L;
      }
      paramString1 = paramString1.toLowerCase();
      paramString2 = paramString2.toLowerCase();
      long l = a(paramString1, paramString2, paramBoolean2, paramBoolean3);
      if (l != -9223372036854775808L) {
        return l + IContactSearchable.r + paramLong;
      }
      if (paramBoolean1)
      {
        ChnToSpell.ChnSpelling localChnSpelling = ChnToSpell.a(paramString2, 1);
        if ((true ^ paramString2.equals(localChnSpelling.jdField_a_of_type_JavaLangString)))
        {
          l = a(paramString1, localChnSpelling, paramBoolean3);
          if (l != -9223372036854775808L) {
            return l + IContactSearchable.s + paramLong;
          }
          l = a(paramString1, ChnToSpell.a(paramString2, 2), paramBoolean3);
          if (l != -9223372036854775808L) {
            return l + IContactSearchable.s + paramLong;
          }
        }
      }
    }
    return -9223372036854775808L;
  }
  
  public static long a(String paramString1, String paramString2, ChnToSpell.ChnSpelling paramChnSpelling1, ChnToSpell.ChnSpelling paramChnSpelling2, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return -9223372036854775808L;
      }
      paramString1 = paramString1.toLowerCase();
      paramString2 = paramString2.toLowerCase();
      long l = a(paramString1, paramString2, false, false);
      if (l != -9223372036854775808L) {
        return l + IContactSearchable.r + paramLong;
      }
      if ((paramChnSpelling1 != null) && (paramChnSpelling2 != null) && ((paramString2.equals(paramChnSpelling1.jdField_a_of_type_JavaLangString) ^ true)))
      {
        l = a(paramString1, paramChnSpelling1, false);
        if (l != -9223372036854775808L) {
          return l + IContactSearchable.s + paramLong;
        }
        l = a(paramString1, paramChnSpelling2, false);
        if (l != -9223372036854775808L) {
          return l + IContactSearchable.s + paramLong;
        }
      }
    }
    return -9223372036854775808L;
  }
  
  private static long a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramString2.indexOf(paramString1), paramString1.length(), paramString2.length(), paramBoolean1, paramBoolean2);
  }
  
  public static Drawable a(Bitmap paramBitmap)
  {
    Drawable localDrawable = MobileQQ.sMobileQQ.getResources().getDrawable(2130840412);
    if ((localDrawable instanceof SkinnableBitmapDrawable)) {
      ((SkinnableBitmapDrawable)localDrawable).setGravity(81);
    }
    if ((localDrawable instanceof BitmapDrawable)) {
      ((BitmapDrawable)localDrawable).setGravity(81);
    }
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    return new LayerDrawable(new Drawable[] { new BitmapDrawable(paramBitmap), localDrawable });
  }
  
  public static Drawable a(IFaceDecoder paramIFaceDecoder, IFaceModel paramIFaceModel)
  {
    return a(paramIFaceDecoder, paramIFaceModel.a(), paramIFaceModel.a());
  }
  
  public static Drawable a(IFaceDecoder paramIFaceDecoder, String paramString, int paramInt)
  {
    return ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).getFaceBitmap(paramIFaceDecoder, paramString, paramInt);
  }
  
  public static Friends a(AppInterface paramAppInterface, String paramString)
  {
    return ((IFriendDataService)paramAppInterface.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString, true);
  }
  
  public static TroopInfo a(AppInterface paramAppInterface, String paramString)
  {
    return ((ITroopInfoService)paramAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(paramString);
  }
  
  public static TroopMemberInfo a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    return ((ITroopMemberInfoService)paramAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(paramString1, paramString2);
  }
  
  public static SearchMatchResult a(String paramString1, ChnToSpell.ChnSpellingAll paramChnSpellingAll1, String paramString2, ChnToSpell.ChnSpellingAll paramChnSpellingAll2, long paramLong)
  {
    boolean bool = TextUtils.isEmpty(paramString2);
    String str1 = null;
    Object localObject = str1;
    if (!bool)
    {
      localObject = str1;
      if (!TextUtils.isEmpty(paramString1))
      {
        if (paramString2.contains(paramString1)) {
          return null;
        }
        localObject = str1;
        if (paramChnSpellingAll1 != null)
        {
          if (paramChnSpellingAll2 == null) {
            return null;
          }
          if (SpellTool.a(paramString1) == 0) {
            return null;
          }
          str1 = paramString1.toLowerCase();
          paramString2 = paramString2.toLowerCase();
          if (paramString2.contains(str1)) {
            return null;
          }
          localObject = new SearchMatchResult();
          String str2 = paramChnSpellingAll1.jdField_b_of_type_JavaLangString;
          String str4 = paramChnSpellingAll1.jdField_c_of_type_JavaLangString;
          paramChnSpellingAll1 = paramChnSpellingAll1.jdField_d_of_type_JavaLangString;
          String str3 = paramChnSpellingAll2.jdField_b_of_type_JavaLangString;
          String str5 = paramChnSpellingAll2.jdField_c_of_type_JavaLangString;
          paramString1 = paramChnSpellingAll2.jdField_d_of_type_JavaLangString;
          int j = SpellTool.a(paramString2);
          int i1 = (int)(paramLong >> SearchConfigManager.contactSearchFieldBaseBit);
          VADHelper.a("voice_search_distance_cost");
          int i = a(str2, str3);
          VADHelper.b("voice_search_distance_cost");
          if (j != 0)
          {
            if (j != 1)
            {
              if (j == 2)
              {
                if (str5.contains(str4))
                {
                  n = str5.indexOf(str4);
                  if (n > -1)
                  {
                    k = str1.length();
                    m = ((Integer)paramChnSpellingAll2.jdField_b_of_type_JavaUtilList.get(n)).intValue();
                    if (n + k + 1 < paramChnSpellingAll2.jdField_b_of_type_JavaUtilList.size()) {
                      j = ((Integer)paramChnSpellingAll2.jdField_b_of_type_JavaUtilList.get(str1.length() + n + 1)).intValue();
                    } else {
                      j = str3.length();
                    }
                    paramChnSpellingAll2 = str3.substring(m, j);
                    paramString1 = paramString1.substring(m, j);
                    VADHelper.a("voice_search_distance_cost");
                    j = a(str2, paramChnSpellingAll2);
                    VADHelper.b("voice_search_distance_cost");
                    m = i;
                    if (j < i) {
                      m = j;
                    }
                    j = n;
                    i = k;
                    break label369;
                  }
                }
                k = 0;
                j = 0;
                m = i;
                i = k;
                label369:
                VADHelper.a("voice_search_sy_cost");
                k = b(paramChnSpellingAll1, paramString1);
                VADHelper.b("voice_search_sy_cost");
                break label842;
              }
            }
            else
            {
              if (str3.contains(str2))
              {
                k = str3.indexOf(str2);
                if (paramString2.length() > k)
                {
                  if (SpellTool.a(paramString2.charAt(k)))
                  {
                    if (str1.length() + k > paramString2.length()) {
                      break label568;
                    }
                    m = ((Integer)paramChnSpellingAll2.jdField_b_of_type_JavaUtilList.get(k)).intValue();
                    if (str1.length() + k + 1 < paramChnSpellingAll2.jdField_b_of_type_JavaUtilList.size()) {
                      j = ((Integer)paramChnSpellingAll2.jdField_b_of_type_JavaUtilList.get(str1.length() + k + 1)).intValue();
                    } else {
                      j = str3.length();
                    }
                    if (!str2.equalsIgnoreCase(str3.substring(m, j))) {
                      break label568;
                    }
                    i = str1.length();
                  }
                  else
                  {
                    i = str2.length();
                  }
                  m = 0;
                  j = k;
                  break label582;
                }
                label568:
                k = 0;
                j = 0;
                m = i;
                i = k;
                label582:
                k = 0;
                break label842;
              }
              if (str5.contains(str4))
              {
                k = str5.indexOf(str4);
                if (k > -1)
                {
                  n = str1.length();
                  m = ((Integer)paramChnSpellingAll2.jdField_b_of_type_JavaUtilList.get(k)).intValue();
                  if (k + n + 1 < paramChnSpellingAll2.jdField_b_of_type_JavaUtilList.size()) {
                    j = ((Integer)paramChnSpellingAll2.jdField_b_of_type_JavaUtilList.get(str1.length() + k + 1)).intValue();
                  } else {
                    j = str3.length();
                  }
                  paramChnSpellingAll2 = str3.substring(m, j);
                  paramString1 = paramString1.substring(m, j);
                  VADHelper.a("voice_search_distance_cost");
                  j = a(str2, paramChnSpellingAll2);
                  VADHelper.b("voice_search_distance_cost");
                  m = i;
                  if (j < i) {
                    m = j;
                  }
                  i = b(paramChnSpellingAll1, paramString1);
                  j = k;
                  k = i;
                  i = n;
                  break label842;
                }
              }
            }
          }
          else
          {
            if (str3.contains(str2))
            {
              j = str3.indexOf(str2);
              i = str2.length();
              k = 0;
              m = 0;
              break label842;
            }
            if (i < 1)
            {
              k = paramString2.length();
              break label824;
            }
          }
          int k = 0;
          label824:
          int n = 0;
          j = 0;
          int m = i;
          i = k;
          k = n;
          label842:
          ((SearchMatchResult)localObject).jdField_d_of_type_Int = m;
          ((SearchMatchResult)localObject).jdField_a_of_type_Boolean = true;
          ((SearchMatchResult)localObject).jdField_a_of_type_JavaLangString = str1;
          ((SearchMatchResult)localObject).jdField_b_of_type_JavaLangString = str2;
          ((SearchMatchResult)localObject).jdField_c_of_type_JavaLangString = paramString2;
          ((SearchMatchResult)localObject).jdField_d_of_type_JavaLangString = str3;
          n = j;
          if (paramString2.length() < j) {
            n = 0;
          }
          ((SearchMatchResult)localObject).jdField_a_of_type_Int = n;
          j = i;
          if (paramString2.length() - ((SearchMatchResult)localObject).jdField_a_of_type_Int < i) {
            j = paramString2.length() - ((SearchMatchResult)localObject).jdField_a_of_type_Int;
          }
          ((SearchMatchResult)localObject).jdField_b_of_type_Int = j;
          ((SearchMatchResult)localObject).jdField_c_of_type_Int = ((100 - m << 8) + (k << 4) + i1);
        }
      }
    }
    return localObject;
  }
  
  public static SearchUtils.MatchedResult a(CharSequence paramCharSequence, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getHighLightMatchedMessage");
      ((StringBuilder)localObject).append(paramCharSequence);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Q.uniteSearch.SearchUtils", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(paramCharSequence)) && (!TextUtils.isEmpty(paramString)))
    {
      String str = paramCharSequence.toString().toLowerCase();
      int m = str.indexOf(paramString);
      int k = paramString.length();
      int i = m;
      int j = k;
      localObject = paramString;
      if (m < 0)
      {
        paramString = paramString.toLowerCase();
        m = str.indexOf(paramString);
        i = m;
        j = k;
        localObject = paramString;
        if (m < 0) {
          if (paramBoolean)
          {
            localObject = a(str, paramString, 1);
            if (localObject[0] >= 0)
            {
              i = localObject[0];
              j = localObject[1];
              localObject = paramString;
            }
            else
            {
              localObject = a(str, paramString, 2);
              if (localObject[0] >= 0)
              {
                i = localObject[0];
                j = localObject[1];
                localObject = paramString;
              }
              else
              {
                return new SearchUtils.MatchedResult(paramCharSequence);
              }
            }
          }
          else
          {
            return new SearchUtils.MatchedResult(paramCharSequence);
          }
        }
      }
      paramCharSequence = new SpannableStringBuilder(paramCharSequence);
      for (k = i; (k >= 0) && (k < paramCharSequence.length()); k = str.indexOf((String)localObject, m))
      {
        m = k + j;
        if ((m > paramCharSequence.length()) || (j <= 0)) {
          break;
        }
        paramCharSequence.setSpan(new ForegroundColorSpan(a()), k, m, 17);
      }
      return new SearchUtils.MatchedResult(paramCharSequence, i, j);
    }
    return new SearchUtils.MatchedResult(paramCharSequence);
  }
  
  public static CharSequence a(TextView paramTextView, float paramFloat, int paramInt, CharSequence paramCharSequence, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramTextView, paramFloat, paramInt, paramCharSequence, paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public static CharSequence a(TextView paramTextView, float paramFloat, int paramInt, CharSequence paramCharSequence, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getHighLightMatchedMessageWithWidth");
      ((StringBuilder)localObject).append(paramCharSequence);
      QLog.d("Q.uniteSearch.SearchUtils", 2, ((StringBuilder)localObject).toString());
    }
    float f1 = a(paramTextView, HardCodeUtil.a(2131713594));
    float f2 = paramInt * paramFloat - (paramInt - 1) * f1;
    if ((!TextUtils.isEmpty(paramCharSequence)) && (paramTextView != null))
    {
      f1 = 0.0F;
      if (f2 > 0.0F)
      {
        if ((paramList != null) && (paramList.size() != 0))
        {
          int n = 0;
          int j = -1;
          int i = 0;
          int k;
          int m;
          while (n < paramList.size())
          {
            localObject = (String)paramList.get(n);
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              if ((j >= 0) && (i > 1) && (((String)localObject).length() == 1)) {
                break;
              }
              localObject = a(paramCharSequence, (String)localObject, paramBoolean1);
              paramCharSequence = ((SearchUtils.MatchedResult)localObject).jdField_a_of_type_JavaLangCharSequence;
              k = j;
              m = i;
              if (j == -1)
              {
                k = j;
                m = i;
                if (i == 0)
                {
                  k = j;
                  m = i;
                  if (((SearchUtils.MatchedResult)localObject).jdField_a_of_type_Int != -1)
                  {
                    k = j;
                    m = i;
                    if (((SearchUtils.MatchedResult)localObject).jdField_b_of_type_Int > 0)
                    {
                      k = ((SearchUtils.MatchedResult)localObject).jdField_a_of_type_Int;
                      m = ((SearchUtils.MatchedResult)localObject).jdField_b_of_type_Int;
                    }
                  }
                }
              }
              i = m;
              j = k;
            }
            n += 1;
          }
          if (a(paramTextView, paramCharSequence) <= f2) {
            return paramCharSequence;
          }
          if ((!TextUtils.isEmpty(paramCharSequence)) && (j >= 0))
          {
            m = j + i;
            if (m <= paramCharSequence.length())
            {
              localObject = paramCharSequence.subSequence(0, m);
              paramList = (List<String>)localObject;
              if (m < paramCharSequence.length())
              {
                paramList = new StringBuilder();
                paramList.append(localObject);
                paramList.append("…");
                paramList = paramList.toString();
              }
              if (a(paramTextView, paramList) <= f2)
              {
                if (paramBoolean3) {
                  return a(paramTextView, f2, paramCharSequence);
                }
                return paramCharSequence;
              }
              if ((paramInt != 1) && (paramBoolean2))
              {
                float f3 = paramFloat / 2.0F;
                if (f3 > a(paramTextView, paramCharSequence)) {
                  return paramCharSequence;
                }
                localObject = new StringBuilder();
                paramInt = 0;
                paramFloat = f1;
                for (;;)
                {
                  k = paramInt;
                  if (paramFloat >= f3) {
                    break;
                  }
                  k = paramInt;
                  if (paramInt >= paramCharSequence.length()) {
                    break;
                  }
                  ((StringBuilder)localObject).append(paramCharSequence.charAt(paramInt));
                  paramFloat = a(paramTextView, ((StringBuilder)localObject).toString());
                  if (paramFloat > f3)
                  {
                    ((StringBuilder)localObject).deleteCharAt(paramInt);
                    k = paramInt - 1;
                    break;
                  }
                  if (paramFloat == f3)
                  {
                    k = paramInt;
                    break;
                  }
                  paramInt += 1;
                }
                paramInt = k + 1;
                paramList = new SpannableStringBuilder(paramCharSequence.subSequence(0, paramInt));
                paramFloat = f2 - a(paramTextView, ((StringBuilder)localObject).toString());
                if (paramInt < paramCharSequence.length())
                {
                  paramCharSequence = paramCharSequence.subSequence(paramInt, paramCharSequence.length());
                  if (paramInt >= j)
                  {
                    paramTextView = a(paramTextView, paramFloat, paramCharSequence);
                    if (paramInt < m)
                    {
                      paramInt = Math.min(paramTextView.length(), i - (paramInt - j));
                      paramTextView = new SpannableStringBuilder(paramTextView);
                      paramTextView.setSpan(new ForegroundColorSpan(a()), 0, paramInt, 17);
                      paramList.append(paramTextView);
                      return paramList;
                    }
                    paramList.append(paramTextView);
                    return paramList;
                  }
                  paramList.append(a(paramTextView, paramFloat, paramCharSequence, j - paramInt, i));
                }
                return paramList;
              }
              return a(paramTextView, f2, paramCharSequence, j, i);
            }
          }
          if (paramBoolean3) {
            return a(paramTextView, f2, paramCharSequence);
          }
          return paramCharSequence;
        }
        if (paramBoolean3) {
          return a(paramTextView, f2, paramCharSequence);
        }
        return paramCharSequence;
      }
    }
    return "";
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
    if ((!TextUtils.isEmpty(paramCharSequence)) && (paramTextView != null))
    {
      float f = 0.0F;
      if (paramFloat > 0.0F)
      {
        if (paramFloat > a(paramTextView, paramCharSequence)) {
          return paramCharSequence;
        }
        Object localObject = new StringBuilder();
        int i = 0;
        int j;
        for (;;)
        {
          j = i;
          if (f >= paramFloat) {
            break;
          }
          j = i;
          if (i >= paramCharSequence.length()) {
            break;
          }
          ((StringBuilder)localObject).append(paramCharSequence.charAt(i));
          f = a(paramTextView, ((StringBuilder)localObject).toString());
          if (f > paramFloat)
          {
            ((StringBuilder)localObject).deleteCharAt(i);
            j = i - 1;
            break;
          }
          if (f == paramFloat)
          {
            j = i;
            break;
          }
          i += 1;
        }
        i = j + 1;
        paramTextView = paramCharSequence.subSequence(0, i);
        localObject = new SpannableStringBuilder(paramTextView);
        if (j < paramCharSequence.length() - 1)
        {
          ((SpannableStringBuilder)localObject).delete(j, i);
          ((SpannableStringBuilder)localObject).append("…", 0, 1);
          return localObject;
        }
        return new SpannableStringBuilder(paramTextView);
      }
    }
    return "";
  }
  
  public static CharSequence a(TextView paramTextView, float paramFloat, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (paramTextView != null) && (paramFloat > 0.0F))
    {
      if (paramInt1 >= 0)
      {
        paramInt2 += paramInt1;
        if (paramInt2 <= paramCharSequence.length())
        {
          Object localObject = paramCharSequence.subSequence(paramInt1, paramInt2);
          float f2 = a(paramTextView, ((CharSequence)localObject).toString());
          localObject = new StringBuilder((CharSequence)localObject);
          float f1 = f2;
          int i = paramInt2;
          int j;
          if (f2 < paramFloat)
          {
            int k = 0;
            for (i = paramInt2;; i = j)
            {
              paramInt2 = paramInt1;
              j = i;
              if (f2 >= paramFloat) {
                break;
              }
              if (paramInt1 <= 0)
              {
                paramInt2 = paramInt1;
                j = i;
                if (i >= paramCharSequence.length()) {
                  break;
                }
              }
              int m = k % 2;
              f1 = f2;
              paramInt2 = paramInt1;
              if (m == 0)
              {
                f1 = f2;
                paramInt2 = paramInt1;
                if (paramInt1 > 0)
                {
                  paramInt1 -= 1;
                  ((StringBuilder)localObject).insert(0, paramCharSequence.charAt(paramInt1));
                  f2 = a(paramTextView, ((StringBuilder)localObject).toString());
                  f1 = f2;
                  paramInt2 = paramInt1;
                  if (f2 > paramFloat)
                  {
                    paramInt2 = paramInt1 + 1;
                    ((StringBuilder)localObject).deleteCharAt(0);
                    j = i;
                    break;
                  }
                }
              }
              f2 = f1;
              j = i;
              if (m != 0)
              {
                f2 = f1;
                j = i;
                if (i < paramCharSequence.length())
                {
                  paramInt1 = i + 1;
                  ((StringBuilder)localObject).insert(((StringBuilder)localObject).length(), paramCharSequence.charAt(paramInt1 - 1));
                  f1 = a(paramTextView, ((StringBuilder)localObject).toString());
                  f2 = f1;
                  j = paramInt1;
                  if (f1 > paramFloat)
                  {
                    ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
                    j = paramInt1 - 1;
                    break;
                  }
                }
              }
              k += 1;
              paramInt1 = paramInt2;
            }
          }
          for (;;)
          {
            paramInt2 = paramInt1;
            j = i;
            if (f1 <= paramFloat) {
              break;
            }
            paramInt2 = paramInt1;
            j = i;
            if (i <= paramInt1) {
              break;
            }
            ((StringBuilder)localObject).deleteCharAt(i - paramInt1 - 1);
            i -= 1;
            f1 = a(paramTextView, ((StringBuilder)localObject).toString());
          }
          localObject = new SpannableStringBuilder(paramCharSequence.subSequence(paramInt2, j));
          paramTextView = (TextView)localObject;
          if (paramInt2 > 0)
          {
            paramTextView = (TextView)localObject;
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              ((SpannableStringBuilder)localObject).delete(0, 1);
              paramTextView = new SpannableStringBuilder("…").append((CharSequence)localObject);
            }
          }
          if ((j < paramCharSequence.length()) && (!TextUtils.isEmpty(paramTextView)))
          {
            paramTextView.delete(paramTextView.length() - 1, paramTextView.length());
            paramTextView.append("…");
          }
          return paramTextView;
        }
      }
      return a(paramTextView, paramFloat, paramCharSequence);
    }
    return "";
  }
  
  public static CharSequence a(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt)
  {
    Object localObject = paramString1;
    if (jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      jdField_a_of_type_AndroidGraphicsPaint = ((TextView)LayoutInflater.from(paramAppInterface.getApp()).inflate(2131562789, null).findViewById(2131378784)).getPaint();
      if (jdField_c_of_type_Int == 0) {
        jdField_c_of_type_Int = paramAppInterface.getApp().getResources().getDimensionPixelOffset(2131298456);
      }
    }
    String str = paramString1.toLowerCase();
    paramAppInterface = paramString2;
    int m = str.indexOf(paramAppInterface);
    int k = paramString2.length();
    int i = m;
    int j = k;
    if (m < 0)
    {
      paramString1 = paramString2.toLowerCase();
      m = str.indexOf(paramString1);
      paramAppInterface = paramString1;
      i = m;
      j = k;
      if (m < 0)
      {
        paramAppInterface = a(str, paramString1, 1);
        if (paramAppInterface[0] >= 0) {
          i = paramAppInterface[0];
        }
        for (j = paramAppInterface[1];; j = paramAppInterface[1])
        {
          paramAppInterface = paramString1;
          break label189;
          paramAppInterface = a(str, paramString1, 2);
          if (paramAppInterface[0] < 0) {
            break;
          }
          i = paramAppInterface[0];
        }
        return new SpannableStringBuilder((CharSequence)localObject);
      }
    }
    label189:
    float f1 = jdField_a_of_type_AndroidGraphicsPaint.measureText((String)localObject);
    float f2 = jdField_a_of_type_AndroidGraphicsPaint.measureText(paramAppInterface);
    paramString2 = (String)localObject;
    paramString1 = str;
    k = i;
    if (f1 >= jdField_c_of_type_Int)
    {
      paramString2 = (String)localObject;
      paramString1 = str;
      k = i;
      if (i > 0)
      {
        f1 = Math.min(f2 + jdField_a_of_type_AndroidGraphicsPaint.measureText("…"), f1);
        f2 = jdField_c_of_type_Int - f1;
        paramString1 = ((String)localObject).substring(0, i);
        float[] arrayOfFloat = new float[paramString1.length()];
        jdField_a_of_type_AndroidGraphicsPaint.getTextWidths(paramString1, arrayOfFloat);
        m = arrayOfFloat.length - 1;
        int n = 0;
        f1 = 0.0F;
        for (;;)
        {
          paramString2 = (String)localObject;
          paramString1 = str;
          k = i;
          if (m < 0) {
            break label454;
          }
          n += 1;
          f1 += arrayOfFloat[m];
          if ((f1 > f2) || (n >= paramInt)) {
            break;
          }
          m -= 1;
        }
        if (f2 <= 0.0F) {
          n = 0;
        }
        paramString1 = new StringBuilder();
        paramString1.append("…");
        paramInt = i - n;
        paramString1.append(((String)localObject).substring(paramInt));
        paramString2 = paramString1.toString();
        paramString1 = new StringBuilder();
        paramString1.append("…");
        paramString1.append(str.substring(paramInt));
        paramString1 = paramString1.toString();
        k = n + 1;
      }
    }
    label454:
    paramString2 = new SpannableStringBuilder(paramString2);
    paramInt = a();
    while (k >= 0)
    {
      localObject = new ForegroundColorSpan(paramInt);
      i = j + k;
      paramString2.setSpan(localObject, k, i, 17);
      k = paramString1.indexOf(paramAppInterface, i);
      j = paramAppInterface.length();
    }
    return paramString2;
  }
  
  public static CharSequence a(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt, SearchMatchResult paramSearchMatchResult)
  {
    if (paramSearchMatchResult == null) {
      return new SpannableStringBuilder(paramString1);
    }
    if (jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      jdField_a_of_type_AndroidGraphicsPaint = ((TextView)LayoutInflater.from(paramAppInterface.getApp()).inflate(2131562789, null).findViewById(2131378784)).getPaint();
      if (jdField_c_of_type_Int == 0) {
        jdField_c_of_type_Int = paramAppInterface.getApp().getResources().getDimensionPixelOffset(2131298456);
      }
    }
    String str = paramString1.toLowerCase();
    int m = paramSearchMatchResult.jdField_a_of_type_Int;
    int i1 = paramSearchMatchResult.jdField_b_of_type_Int;
    if ((m >= 0) && (m <= paramString1.length()) && (paramString1.equalsIgnoreCase(paramSearchMatchResult.jdField_c_of_type_JavaLangString)) && (paramSearchMatchResult.jdField_d_of_type_Int <= 1))
    {
      float f1 = jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString1);
      float f2 = jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString2);
      int k = m;
      paramAppInterface = paramString1;
      if (f1 >= jdField_c_of_type_Int)
      {
        k = m;
        paramAppInterface = paramString1;
        if (m >= 0)
        {
          f1 = Math.min(f2 + jdField_a_of_type_AndroidGraphicsPaint.measureText("…"), f1);
          f2 = jdField_c_of_type_Int - f1;
          int n = 0;
          paramAppInterface = paramString1.substring(0, m);
          paramString2 = new float[paramAppInterface.length()];
          jdField_a_of_type_AndroidGraphicsPaint.getTextWidths(paramAppInterface, paramString2);
          int i = paramString2.length - 1;
          int j = 0;
          f1 = 0.0F;
          for (;;)
          {
            k = m;
            paramAppInterface = paramString1;
            if (i < 0) {
              break label385;
            }
            j += 1;
            f1 += paramString2[i];
            if ((f1 > f2) || (j >= paramInt)) {
              break;
            }
            i -= 1;
          }
          if (f2 <= 0.0F) {
            paramInt = n;
          } else {
            paramInt = j;
          }
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("…");
          i = m - paramInt;
          paramAppInterface.append(paramString1.substring(i));
          paramAppInterface = paramAppInterface.toString();
          paramString1 = new StringBuilder();
          paramString1.append("…");
          paramString1.append(str.substring(i));
          paramString1.toString();
          k = paramInt + 1;
        }
      }
      label385:
      paramString1 = new SpannableStringBuilder(paramAppInterface);
      paramInt = i1 + k;
      if (paramInt <= paramAppInterface.length()) {
        paramString1.setSpan(new ForegroundColorSpan(a()), k, paramInt, 17);
      }
      return paramString1;
    }
    return new SpannableStringBuilder(paramString1);
  }
  
  public static CharSequence a(CharSequence paramCharSequence)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append("(").append(paramCharSequence).append(")");
    return localSpannableStringBuilder;
  }
  
  public static CharSequence a(CharSequence paramCharSequence, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getHighLightMatchedMessage");
      ((StringBuilder)localObject).append(paramCharSequence);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Q.uniteSearch.SearchUtils", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (TextUtils.isEmpty(paramString)) {
        return paramCharSequence;
      }
      String str = paramCharSequence.toString().toLowerCase();
      int m = str.indexOf(paramString);
      int k = paramString.length();
      int i = m;
      int j = k;
      localObject = paramString;
      if (m < 0)
      {
        paramString = paramString.toLowerCase();
        m = str.indexOf(paramString);
        i = m;
        j = k;
        localObject = paramString;
        if (m < 0)
        {
          if (paramBoolean)
          {
            localObject = a(str, paramString, 1);
            if (localObject[0] >= 0)
            {
              i = localObject[0];
              j = localObject[1];
              localObject = paramString;
              break label215;
            }
            localObject = a(str, paramString, 2);
            if (localObject[0] >= 0)
            {
              i = localObject[0];
              j = localObject[1];
              localObject = paramString;
              break label215;
            }
          }
          return paramCharSequence;
        }
      }
      label215:
      paramCharSequence = new SpannableStringBuilder(paramCharSequence);
      while ((i >= 0) && (i < paramCharSequence.length()))
      {
        k = i + j;
        if ((k > paramCharSequence.length()) || (j <= 0)) {
          break;
        }
        paramCharSequence.setSpan(new ForegroundColorSpan(b()), i, k, 17);
        i = str.indexOf((String)localObject, k);
      }
      return paramCharSequence;
    }
    return paramCharSequence;
  }
  
  public static CharSequence a(String paramString, int paramInt, ArrayList<String> paramArrayList)
  {
    if (paramString == null) {
      return null;
    }
    if ((paramInt >= 0) && (paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      Object localObject1 = paramString.getBytes();
      if (paramInt >= localObject1.length) {
        return new SpannableStringBuilder(paramString);
      }
      int j = 0;
      Object localObject2;
      if (paramInt > 0)
      {
        localObject2 = new byte[paramInt];
        System.arraycopy(localObject1, 0, localObject2, 0, localObject2.length);
        paramInt = new String((byte[])localObject2).length();
      }
      else
      {
        paramInt = 0;
      }
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
          if (i + paramInt <= 10) {}
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("…");
        ((StringBuilder)localObject1).append(paramString.substring(paramInt - 6));
        localObject1 = ((StringBuilder)localObject1).toString();
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
            ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(a());
            j = paramInt + i;
            paramString.setSpan(localForegroundColorSpan, paramInt, j, 17);
            paramInt = ((String)localObject1).toLowerCase().indexOf(((String)localObject2).toLowerCase(), j);
          }
        }
      }
      return paramString;
    }
    return new SpannableStringBuilder(paramString);
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
    Object localObject1 = paramString2;
    if (m < 0)
    {
      paramString2 = paramString2.toLowerCase();
      m = str.indexOf(paramString2);
      i = m;
      j = k;
      localObject1 = paramString2;
      if (m < 0)
      {
        if (paramBoolean)
        {
          localObject1 = a(str, paramString2, 1);
          if (localObject1[0] >= 0) {
            j = localObject1[0];
          }
          for (i = localObject1[1];; i = localObject1[1])
          {
            k = i;
            i = j;
            j = k;
            localObject1 = paramString2;
            break label164;
            localObject1 = a(str, paramString2, 2);
            if (localObject1[0] < 0) {
              break;
            }
            j = localObject1[0];
          }
          return new SpannableStringBuilder(paramString1);
        }
        return new SpannableStringBuilder(paramString1);
      }
    }
    label164:
    Object localObject2;
    if (i <= paramInt)
    {
      paramString2 = str;
      k = i;
      localObject2 = paramString1;
      if (i > 4)
      {
        paramString2 = str;
        k = i;
        localObject2 = paramString1;
        if (i + j <= paramInt) {}
      }
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append("…");
      paramInt = i - 4;
      paramString2.append(paramString1.substring(paramInt));
      localObject2 = paramString2.toString();
      paramString1 = new StringBuilder();
      paramString1.append("…");
      paramString1.append(str.substring(paramInt));
      paramString2 = paramString1.toString();
      k = 5;
    }
    paramString1 = new SpannableStringBuilder((CharSequence)localObject2);
    while (k >= 0)
    {
      localObject2 = new ForegroundColorSpan(a());
      paramInt = j + k;
      paramString1.setSpan(localObject2, k, paramInt, 17);
      k = paramString2.indexOf((String)localObject1, paramInt);
      j = ((String)localObject1).length();
    }
    return paramString1;
  }
  
  public static CharSequence a(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = paramString1.toLowerCase();
    paramString2 = paramString2.toLowerCase();
    int i = str.indexOf(paramString2);
    int j = paramString2.length();
    int k;
    if (i < 0)
    {
      if (paramBoolean)
      {
        localObject = a(str, paramString2, 1);
        if (localObject[0] >= 0) {
          i = localObject[0];
        }
        for (j = localObject[1];; j = localObject[1])
        {
          break;
          localObject = a(str, paramString2, 2);
          if (localObject[0] < 0) {
            break label98;
          }
          i = localObject[0];
        }
        k = 0;
        break label119;
        label98:
        return new SpannableStringBuilder(paramString1);
      }
      else
      {
        return new SpannableStringBuilder(paramString1);
      }
    }
    else {
      k = 1;
    }
    label119:
    paramString1 = new SpannableStringBuilder(paramString1);
    int m;
    for (;;)
    {
      localObject = new ForegroundColorSpan(a());
      m = i + j;
      paramString1.setSpan(localObject, i, m, 17);
      if (k == 0) {
        break label189;
      }
      i = str.indexOf(paramString2, m);
      j = paramString2.length();
      if (i < 0) {
        break;
      }
      k = 1;
    }
    return paramString1;
    label189:
    Object localObject = a(str.substring(m), paramString2, 1);
    if (localObject[0] >= 0) {
      i = localObject[0] + i + j;
    }
    for (j = localObject[1];; j = localObject[1])
    {
      break;
      localObject = a(str.substring(m), paramString2, 2);
      if (localObject[0] < 0) {
        return paramString1;
      }
      i = localObject[0] + i + j;
    }
    return paramString1;
  }
  
  public static CharSequence a(String paramString, ArrayList<String> paramArrayList, int paramInt)
  {
    Object localObject = paramArrayList.iterator();
    int i = 0;
    int j = 0;
    String str1;
    String str2;
    while (((Iterator)localObject).hasNext())
    {
      str1 = (String)((Iterator)localObject).next();
      str2 = paramString.toLowerCase();
      i = str2.indexOf(str1);
      j = str1.length();
      if (i >= 0) {
        break;
      }
      i = str2.indexOf(str1.toLowerCase());
      if (i >= 0) {
        break;
      }
    }
    if (i < 0) {
      return new SpannableStringBuilder(paramString);
    }
    if (i <= paramInt)
    {
      localObject = paramString;
      if (i > 6)
      {
        localObject = paramString;
        if (j + i <= paramInt) {}
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("…");
      ((StringBuilder)localObject).append(paramString.substring(i - 6));
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = new SpannableStringBuilder((CharSequence)localObject);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      str1 = (String)paramArrayList.next();
      str2 = ((String)localObject).toLowerCase();
      i = str2.indexOf(str1);
      j = str1.length();
      paramInt = i;
      if (i < 0)
      {
        i = str2.indexOf(str1.toLowerCase());
        paramInt = i;
        if (i < 0) {}
      }
      else
      {
        paramString.setSpan(new ForegroundColorSpan(a()), paramInt, j + paramInt, 17);
      }
    }
    return paramString;
  }
  
  public static CharSequence a(JSONArray paramJSONArray)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject1 = paramJSONArray.optJSONObject(i);
        Object localObject2 = ((JSONObject)localObject1).optString("word");
        localObject1 = ((JSONObject)localObject1).optString("color");
        SpannableString localSpannableString;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localSpannableString = new SpannableString((CharSequence)localObject2);
        }
        label135:
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label135;
          }
          localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor((String)localObject1)), 0, ((String)localObject2).length(), 17);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          label98:
          break label98;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" color value is not valid. colorStr = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.e("Q.uniteSearch.SearchUtils", 1, ((StringBuilder)localObject2).toString());
        localSpannableStringBuilder.append(localSpannableString);
        i += 1;
      }
    }
    else
    {
      return localSpannableStringBuilder;
    }
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 1) {
      return "1";
    }
    if (paramInt == 2) {
      return "2";
    }
    if (paramInt == 21) {
      return "3";
    }
    return "-1";
  }
  
  public static String a(Context paramContext, DiscussionInfo paramDiscussionInfo)
  {
    if (paramDiscussionInfo != null) {
      paramDiscussionInfo = paramDiscussionInfo.discussionName;
    } else {
      paramDiscussionInfo = "";
    }
    Object localObject;
    if (paramDiscussionInfo != null)
    {
      localObject = paramDiscussionInfo;
      if (paramDiscussionInfo.length() != 0) {}
    }
    else
    {
      localObject = paramContext.getResources().getString(2131691760);
    }
    return localObject;
  }
  
  public static String a(AppInterface paramAppInterface, String paramString)
  {
    return ((ITroopInfoService)paramAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopUin(paramString);
  }
  
  public static String a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    return ((ITroopMemberNameService)paramAppInterface.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(paramString1, paramString2);
  }
  
  public static String a(Friends paramFriends)
  {
    return paramFriends.getFriendNickWithAlias();
  }
  
  public static String a(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return null;
    }
    return Pattern.compile("[\\s|\\t|\\r|\\n]+").matcher(paramCharSequence).replaceAll("");
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (!paramString.startsWith("https://so.html5.qq.com/page/real/kd_result")) {
      return "";
    }
    paramString = URLUtil.a(paramString);
    if ((paramString != null) && (paramString.containsKey("q")))
    {
      paramString = (String)paramString.get("q");
      if (!TextUtils.isEmpty(paramString)) {
        return paramString;
      }
    }
    return "";
  }
  
  public static String a(String paramString, List<Long> paramList)
  {
    return a(paramString, a(paramList));
  }
  
  public static String a(String paramString, long[] paramArrayOfLong)
  {
    try
    {
      paramArrayOfLong = (String)jdField_c_of_type_JavaUtilHashMap.get(b(paramString, paramArrayOfLong));
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
  
  public static String a(List<Long> paramList)
  {
    return a(a(paramList), "::");
  }
  
  public static String a(long[] paramArrayOfLong)
  {
    return a(paramArrayOfLong, "::");
  }
  
  public static String a(long[] paramArrayOfLong, String paramString)
  {
    if (paramArrayOfLong != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramArrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(paramArrayOfLong[i]);
        localStringBuilder.append(paramString);
        i += 1;
      }
      if (localStringBuilder.length() > 0) {
        return localStringBuilder.substring(0, localStringBuilder.length() - paramString.length());
      }
      return "";
    }
    paramArrayOfLong = new RuntimeException("generateMaskString. masks can not be null.");
    for (;;)
    {
      throw paramArrayOfLong;
    }
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
  
  public static ArrayList<Friends> a(AppInterface paramAppInterface, int paramInt)
  {
    return (ArrayList)((IFriendDataService)paramAppInterface.getRuntimeService(IFriendDataService.class, "")).getFriendList(paramInt);
  }
  
  public static ArrayList<Friends> a(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      paramAppInterface = (ArrayList)((IFriendDataService)paramAppInterface.getRuntimeService(IFriendDataService.class, "")).getFriendList(Integer.parseInt(paramString));
      return paramAppInterface;
    }
    catch (NumberFormatException paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
    return new ArrayList();
  }
  
  public static HashMap<String, String> a(HashMap<String, String> paramHashMap)
  {
    Object localObject = paramHashMap;
    if (paramHashMap == null) {
      localObject = new HashMap();
    }
    ((HashMap)localObject).put("input_type", String.valueOf(jdField_c_of_type_Long));
    ((HashMap)localObject).put("support_sougou_ime", String.valueOf(jdField_b_of_type_Boolean));
    return localObject;
  }
  
  public static List<Groups> a(AppInterface paramAppInterface)
  {
    return ((IFriendDataService)paramAppInterface.getRuntimeService(IFriendDataService.class, "")).getGroupList();
  }
  
  public static List<Long> a(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong != null)
    {
      ArrayList localArrayList = new ArrayList(paramArrayOfLong.length);
      int i = 0;
      while (i < paramArrayOfLong.length)
      {
        localArrayList.add(Long.valueOf(paramArrayOfLong[i]));
        i += 1;
      }
      return localArrayList;
    }
    paramArrayOfLong = new RuntimeException("convertIntArrayToLongList. array can not be null.");
    for (;;)
    {
      throw paramArrayOfLong;
    }
  }
  
  public static void a()
  {
    int i = SearchStatisticsConstants.a(70);
    int j = 1;
    if (i != 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (SearchStatisticsConstants.a(80) == 0) {
      j = 0;
    }
    if ((i != 0) && (j != 0)) {
      i = 90;
    } else if (i != 0) {
      i = 70;
    } else if (j != 0) {
      i = 80;
    } else {
      i = 0;
    }
    if (i != 0) {
      ReportController.b(null, "CliOper", "", "", "0X8005ECF", "0X8005ECF", i, 0, "", "", "", "");
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString1, String paramString2, int paramInt4)
  {
    int i;
    switch (paramInt1)
    {
    default: 
      i = -1;
      break;
    case 80000002: 
      i = 90;
      break;
    case 80000001: 
      i = 80;
      break;
    case 80000000: 
      i = 70;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("moduleType:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" moduleIndex:");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" itemLinePosition:");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(" isGroupSearch:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("searchUtils", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("moduleType", Integer.toString(i));
      ((HashMap)localObject).put("moduleIndex", Integer.toString(paramInt2));
      ((HashMap)localObject).put("itemLinePosition", Integer.toString(paramInt3));
      ((HashMap)localObject).put("toUin", paramString1);
      ((HashMap)localObject).put("keyword", paramString2);
      if (paramInt4 == 12) {
        ((HashMap)localObject).put("isFolder", "1");
      } else {
        ((HashMap)localObject).put("isFolder", "0");
      }
      StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(null, "NetGroupSearchItemClick", true, 0L, 0L, (HashMap)localObject, null);
    }
    else
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("moduleType", Integer.toString(i));
      ((HashMap)localObject).put("itemLinePosition", Integer.toString(paramInt3));
      ((HashMap)localObject).put("toUin", paramString1);
      ((HashMap)localObject).put("keyword", paramString2);
      if (paramInt4 == 12) {
        ((HashMap)localObject).put("isFolder", "1");
      } else {
        ((HashMap)localObject).put("isFolder", "0");
      }
      StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(null, "NetModelSearchItemClick", true, 0L, 0L, (HashMap)localObject, null);
    }
    switch (paramInt1)
    {
    default: 
      paramString1 = "";
    }
    for (;;)
    {
      break;
      if (paramInt3 == 0)
      {
        paramString1 = "0X80061C3";
      }
      else
      {
        paramString1 = "0X80061C2";
        continue;
        if (paramInt3 == 0)
        {
          paramString1 = "0X80061C0";
        }
        else
        {
          paramString1 = "0X80061BF";
          continue;
          if (paramInt3 == 0)
          {
            paramString1 = "0X80061BD";
          }
          else
          {
            paramString1 = "0X80061BC";
            continue;
            if (paramInt3 == 0) {
              paramString1 = "0X80061BA";
            } else {
              paramString1 = "0X80061B9";
            }
          }
        }
      }
    }
    ReportController.b(null, "CliOper", "", "", paramString1, paramString1, 0, 0, String.valueOf(paramInt3), "", "", "");
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).handleFeatureJump(paramContext, paramInt1, paramInt2);
  }
  
  public static void a(View paramView, IContactSearchModel paramIContactSearchModel)
  {
    Activity localActivity = (Activity)paramView.getContext();
    Intent localIntent = new Intent();
    localIntent.putExtra("contactSearchResultUin", paramIContactSearchModel.a());
    localIntent.putExtra("contactSearchResultUinType", paramIContactSearchModel.d());
    localIntent.putExtra("contactSearchResultName", paramIContactSearchModel.c());
    localIntent.putExtra("contactSearchResultNick", paramIContactSearchModel.d());
    if ((!(paramIContactSearchModel instanceof ContactSearchModelDiscussion)) && (!(paramIContactSearchModel instanceof ContactSearchModelTroop)) && (!(paramIContactSearchModel instanceof ContactSearchModelNewTroop)))
    {
      if ((paramIContactSearchModel instanceof ContactSearchModelDiscussionMember)) {
        paramView = ((ContactSearchModelDiscussionMember)paramIContactSearchModel).e();
      } else if ((paramIContactSearchModel instanceof ContactSearchModelNewTroopMember)) {
        paramView = ((ContactSearchModelNewTroopMember)paramIContactSearchModel).jdField_a_of_type_JavaLangString;
      } else if ((paramIContactSearchModel instanceof ContactSearchModelRecentUser)) {
        paramView = ((ContactSearchModelRecentUser)paramIContactSearchModel).e();
      } else {
        paramView = "";
      }
    }
    else {
      paramView = paramIContactSearchModel.a();
    }
    if ((paramIContactSearchModel instanceof ContactSearchModelPhoneContact))
    {
      ContactSearchModelPhoneContact localContactSearchModelPhoneContact = (ContactSearchModelPhoneContact)paramIContactSearchModel;
      localIntent.putExtra("contactSearchResultPhoneContactOriginBinder", localContactSearchModelPhoneContact.a.originBinder);
      String str = localContactSearchModelPhoneContact.a.mobileCode;
      paramIContactSearchModel = str;
      if (TextUtils.isEmpty(str)) {
        paramIContactSearchModel = localContactSearchModelPhoneContact.a.mobileNo;
      }
      localIntent.putExtra("contactSearchResultPhoneContactMobileCode", paramIContactSearchModel);
      localIntent.putExtra("contactSearchResultPhoneContactNationCode", localContactSearchModelPhoneContact.a.nationCode);
      localIntent.putExtra("contactSearchResultPhoneContactAbility", localContactSearchModelPhoneContact.a.ability);
    }
    localIntent.putExtra("contactSearchResultTroopUin", paramView);
    localActivity.setResult(-1, localIntent);
    localActivity.finish();
    localActivity.overridePendingTransition(0, 0);
  }
  
  public static void a(AppInterface paramAppInterface, Activity paramActivity, String paramString, int paramInt)
  {
    AppInterface localAppInterface = paramAppInterface;
    if (paramAppInterface == null) {
      localAppInterface = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
    }
    if ((localAppInterface != null) && (paramActivity != null) && (!TextUtils.isEmpty(paramString)))
    {
      if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
      {
        if (paramString.startsWith("tel://"))
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("tel:");
          paramAppInterface.append(paramString.substring(6));
          paramActivity.startActivityForResult(new Intent("android.intent.action.DIAL", Uri.parse(paramAppInterface.toString())), paramInt);
          return;
        }
        if ((paramActivity instanceof BaseActivity))
        {
          paramAppInterface = JumpParser.a((BaseQQAppInterface)localAppInterface, paramActivity, paramString);
          if (paramAppInterface != null)
          {
            paramAppInterface.a();
            return;
          }
          paramActivity.startActivityForResult(new Intent(paramActivity, JumpActivity.class).setData(Uri.parse(paramString)), paramInt);
          return;
        }
        paramActivity.startActivityForResult(new Intent(paramActivity, JumpActivity.class).setData(Uri.parse(paramString)), paramInt);
        return;
      }
      if (a(paramString))
      {
        ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToNativeSearchResultPage(paramActivity, a(paramString), paramString);
        return;
      }
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).jumpQQBrowserActivity(paramActivity, paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.uniteSearch.SearchUtils", 2, "jumpUtilargument is empty");
    }
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    AppInterface localAppInterface = paramAppInterface;
    if (paramAppInterface == null) {
      localAppInterface = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
    }
    if ((localAppInterface != null) && (paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
      {
        if (paramString.startsWith("tel://"))
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("tel:");
          paramAppInterface.append(paramString.substring(6));
          paramContext.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(paramAppInterface.toString())));
          return;
        }
        if ((paramContext instanceof BaseActivity))
        {
          paramAppInterface = JumpParser.a((BaseQQAppInterface)localAppInterface, paramContext, paramString);
          if (paramAppInterface != null)
          {
            paramAppInterface.a();
            return;
          }
          paramContext.startActivity(new Intent(paramContext, JumpActivity.class).setData(Uri.parse(paramString)));
          return;
        }
        paramContext.startActivity(new Intent(paramContext, JumpActivity.class).setData(Uri.parse(paramString)));
        return;
      }
      if (a(paramString))
      {
        ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToNativeSearchResultPage(paramContext, a(paramString), paramString);
        return;
      }
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).jumpQQBrowserActivity(paramContext, paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.uniteSearch.SearchUtils", 2, "jumpUtilargument is empty");
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).saveSearchHistory(paramAppInterface, paramString1, paramString2, paramString3, paramInt);
  }
  
  public static void a(IContactSearchModel paramIContactSearchModel, View paramView)
  {
    ThreadManager.postImmediately(new SearchUtils.1(paramView, paramIContactSearchModel), null, true);
  }
  
  public static void a(String paramString)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString.split(" ");
      if (localObject != null)
      {
        i = localObject.length;
        break label27;
      }
    }
    int i = 0;
    label27:
    if (i > 1)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("discuss -searchKey:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" count:");
        ((StringBuilder)localObject).append(i);
        QLog.d("searchUtils", 2, ((StringBuilder)localObject).toString());
      }
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(i);
      ReportController.b(null, "CliOper", "", "", "0X8005E0F", "0X8005E0F", 0, 0, paramString.toString(), "", "", "");
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, View paramView)
  {
    boolean bool = a(paramView.getContext());
    paramInt3 += 1;
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("moduleType:");
      paramView.append(paramInt1);
      paramView.append(" itemLinePosition:");
      paramView.append(paramInt3);
      QLog.d("searchUtils", 2, paramView.toString());
    }
    if (bool)
    {
      int i = SearchStatisticsConstants.a(paramInt1);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("moduleIndex:");
        paramView.append(i);
        paramView.append(" searchKey:");
        paramView.append(paramString);
        QLog.d("searchUtils", 2, paramView.toString());
      }
      ReportController.b(null, "CliOper", "", "", "0X8005E10", "0X8005E10", paramInt1, 0, String.valueOf(i), String.valueOf(paramInt3), String.valueOf(paramInt2), "");
      paramView = new HashMap();
      paramView.put("moduleType", Integer.toString(paramInt1));
      paramView.put("moduleIndex", Integer.toString(i));
      paramView.put("moduleChildType", Integer.toString(paramInt2));
      paramView.put("itemLinePosition", Integer.toString(paramInt3));
      paramView.put("keyword", paramString);
      if (jdField_b_of_type_Long != -1L) {
        paramView.put("stay_time", String.valueOf(System.currentTimeMillis() - jdField_b_of_type_Long));
      }
      StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(null, "GroupSearchItemClick", true, 0L, 0L, a(paramView), null);
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005E11", "0X8005E11", paramInt1, 0, "", String.valueOf(paramInt3), String.valueOf(paramInt2), "");
    paramView = new HashMap();
    paramView.put("moduleType", Integer.toString(paramInt1));
    paramView.put("moduleChildType", Integer.toString(paramInt2));
    paramView.put("itemLinePosition", Integer.toString(paramInt3));
    paramView.put("keyword", paramString);
    StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(null, "ModelSearchItemClick", true, 0L, 0L, paramView, null);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, View paramView)
  {
    boolean bool = a(paramView.getContext());
    int i = ((Integer)paramView.getTag(2131380885)).intValue() + 1;
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("moduleType:");
      paramView.append(paramInt1);
      paramView.append(" itemLinePosition:");
      paramView.append(i);
      QLog.d("searchUtils", 2, paramView.toString());
    }
    if (bool)
    {
      int j = SearchStatisticsConstants.a(paramInt1);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("moduleIndex:");
        paramView.append(j);
        paramView.append(" searchKey:");
        paramView.append(paramString);
        QLog.d("searchUtils", 2, paramView.toString());
      }
      ReportController.b(null, "CliOper", "", "", "0X8005E10", "0X8005E10", paramInt1, 0, String.valueOf(j), String.valueOf(i), String.valueOf(paramInt2), "");
      paramView = new HashMap();
      paramView.put("moduleType", Integer.toString(paramInt1));
      paramView.put("moduleIndex", Integer.toString(j));
      paramView.put("moduleChildType", Integer.toString(paramInt2));
      paramView.put("itemLinePosition", Integer.toString(i));
      paramView.put("keyword", paramString);
      if (jdField_b_of_type_Long != -1L) {
        paramView.put("stay_time", String.valueOf(System.currentTimeMillis() - jdField_b_of_type_Long));
      }
      StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(null, "GroupSearchItemClick", true, 0L, 0L, a(paramView), null);
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005E11", "0X8005E11", paramInt1, 0, "", String.valueOf(i), String.valueOf(paramInt2), "");
    paramView = new HashMap();
    paramView.put("moduleType", Integer.toString(paramInt1));
    paramView.put("moduleChildType", Integer.toString(paramInt2));
    paramView.put("itemLinePosition", Integer.toString(i));
    paramView.put("keyword", paramString);
    StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(null, "ModelSearchItemClick", true, 0L, 0L, paramView, null);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, View paramView, String paramString2, boolean paramBoolean, int paramInt3)
  {
    boolean bool = a(paramView.getContext());
    int i = ((Integer)paramView.getTag(2131380885)).intValue() + 1;
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("moduleType:");
      paramView.append(paramInt1);
      paramView.append(" itemLinePosition:");
      paramView.append(i);
      QLog.d("searchUtils", 2, paramView.toString());
    }
    if (bool)
    {
      int j = SearchStatisticsConstants.a(paramInt1);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("moduleIndex:");
        paramView.append(j);
        paramView.append(" searchKey:");
        paramView.append(paramString1);
        QLog.d("searchUtils", 2, paramView.toString());
      }
      ReportController.b(null, "CliOper", "", "", "0X8005E10", "0X8005E10", paramInt1, 0, String.valueOf(j), String.valueOf(i), String.valueOf(paramInt2), "");
      paramView = new HashMap();
      paramView.put("moduleType", Integer.toString(paramInt1));
      paramView.put("moduleIndex", Integer.toString(j));
      paramView.put("moduleChildType", Integer.toString(paramInt2));
      paramView.put("itemLinePosition", Integer.toString(i));
      paramView.put("toUin", paramString2);
      paramView.put("keyword", paramString1);
      if (paramBoolean) {
        paramString1 = "1";
      } else {
        paramString1 = "0";
      }
      paramView.put("sFrom", paramString1);
      if (paramInt3 == 12) {
        paramView.put("isFolder", "1");
      } else {
        paramView.put("isFolder", "0");
      }
      if (jdField_b_of_type_Long != -1L) {
        paramView.put("stay_time", String.valueOf(System.currentTimeMillis() - jdField_b_of_type_Long));
      }
      StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(null, "GroupSearchItemClick", true, 0L, 0L, a(paramView), null);
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005E11", "0X8005E11", paramInt1, 0, "", String.valueOf(i), String.valueOf(paramInt2), "");
    paramView = new HashMap();
    paramView.put("moduleType", Integer.toString(paramInt1));
    paramView.put("moduleChildType", Integer.toString(paramInt2));
    paramView.put("itemLinePosition", Integer.toString(i));
    paramView.put("keyword", paramString1);
    paramView.put("toUin", paramString2);
    if (paramBoolean) {
      paramString1 = "1";
    } else {
      paramString1 = "0";
    }
    paramView.put("sFrom", paramString1);
    if (paramInt3 == 12) {
      paramView.put("isFolder", "1");
    } else {
      paramView.put("isFolder", "0");
    }
    StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(null, "ModelSearchItemClick", true, 0L, 0L, paramView, null);
  }
  
  public static void a(String paramString, int paramInt, View paramView, boolean paramBoolean)
  {
    ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).reportJumpToAIOorProfile(paramString, paramInt, paramView, paramBoolean);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).report(paramString1, paramString2, paramInt1, paramInt2, paramVarArgs);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).report(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramVarArgs);
  }
  
  public static void a(String paramString1, String paramString2, String... paramVarArgs)
  {
    a(paramString1, paramString2, 0, 0, paramVarArgs);
  }
  
  public static void a(String paramString1, long[] paramArrayOfLong, String paramString2)
  {
    try
    {
      jdField_c_of_type_JavaUtilHashMap.put(b(paramString1, paramArrayOfLong), paramString2);
      return;
    }
    catch (RuntimeException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils updateReportVersion", 2, paramString1.toString());
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 10) || (paramInt == 21) || (paramInt == 22);
  }
  
  public static boolean a(long paramLong)
  {
    return ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).isEntityGroup(paramLong);
  }
  
  private static boolean a(Context paramContext)
  {
    return ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).isUniteSearchActivity(paramContext);
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString)
  {
    return ((IFriendDataService)paramAppInterface.getRuntimeService(IFriendDataService.class, "")).isFriend(paramString);
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    return ((IAddFriendServiceApi)paramAppInterface.getRuntimeService(IAddFriendServiceApi.class, "")).hasSendAddFriendReq(paramString, paramBoolean, false);
  }
  
  public static boolean a(ISearchResultModel paramISearchResultModel)
  {
    return ((paramISearchResultModel instanceof ContactSearchModelDiscussion)) || ((paramISearchResultModel instanceof ContactSearchModelGlobalTroop)) || ((paramISearchResultModel instanceof ContactSearchModelNewTroop)) || ((paramISearchResultModel instanceof ContactSearchModelTroop));
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (!paramString.startsWith("https://so.html5.qq.com/page/real/kd_result")) {
      return false;
    }
    paramString = URLUtil.a(paramString);
    return (paramString != null) && (paramString.containsKey("q")) && (!TextUtils.isEmpty((String)paramString.get("q")));
  }
  
  public static int[] a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int[] arrayOfInt = new int[3];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = -1;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    int[] tmp13_9 = tmp9_5;
    tmp13_9[2] = 0;
    tmp13_9;
    if (!TextUtils.isEmpty(paramString2))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return arrayOfInt;
      }
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
        if ((paramString2.equals(((ChnToSpell.ChnSpelling)localObject).jdField_a_of_type_JavaLangString) ^ true))
        {
          localObject = a((ChnToSpell.ChnSpelling)localObject, paramString1);
          arrayOfInt[0] = localObject[0];
          arrayOfInt[1] = localObject[1];
          if (arrayOfInt[0] != -1)
          {
            arrayOfInt[2] = 2;
            return arrayOfInt;
          }
          paramString1 = a(ChnToSpell.a(paramString2, 2), paramString1);
          arrayOfInt[0] = paramString1[0];
          arrayOfInt[1] = paramString1[1];
          if (arrayOfInt[0] != -1) {
            arrayOfInt[2] = 1;
          }
        }
      }
    }
    return arrayOfInt;
  }
  
  public static long[] a(List<Long> paramList)
  {
    if (paramList != null)
    {
      long[] arrayOfLong = new long[paramList.size()];
      int i = 0;
      while (i < paramList.size())
      {
        arrayOfLong[i] = ((Long)paramList.get(i)).longValue();
        i += 1;
      }
      return arrayOfLong;
    }
    paramList = new RuntimeException("convertLongList2longArray. list can not be null.");
    for (;;)
    {
      throw paramList;
    }
  }
  
  public static int b()
  {
    int i = MobileQQ.sMobileQQ.getResources().getColor(2131166970);
    if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, "")) {
      i = MobileQQ.sMobileQQ.getResources().getColor(2131166972);
    }
    return i;
  }
  
  public static int b(String paramString1, String paramString2)
  {
    paramString1 = paramString1.split("#");
    SpellTool.a();
    paramString2 = paramString2.split("#");
    SpellTool.a();
    int j = paramString1.length;
    int k = paramString2.length;
    int i = 0;
    if (j == k)
    {
      float f3 = 14.0F / (paramString1.length * 2);
      i = 0;
      float f1;
      for (float f2 = 0.0F; i < paramString1.length; f2 = f1)
      {
        f1 = f2;
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
    Object localObject1 = paramString2.toLowerCase();
    int k = str.indexOf((String)localObject1);
    int j = ((String)localObject1).length();
    int i = k;
    Object localObject2;
    if (k < 0) {
      if (paramBoolean)
      {
        localObject2 = a(str, (String)localObject1, 1);
        if (localObject2[0] >= 0)
        {
          i = localObject2[0];
          j = localObject2[1];
        }
        else
        {
          localObject1 = a(str, (String)localObject1, 2);
          if (localObject1[0] >= 0)
          {
            i = localObject1[0];
            j = localObject1[1];
          }
          else
          {
            return new SpannableStringBuilder(paramString1);
          }
        }
      }
      else
      {
        return new SpannableStringBuilder(paramString1);
      }
    }
    if (i <= paramInt)
    {
      localObject1 = str;
      k = i;
      localObject2 = paramString1;
      if (i > 6)
      {
        localObject1 = str;
        k = i;
        localObject2 = paramString1;
        if (i + j <= paramInt) {}
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("…");
      paramInt = i - 6;
      ((StringBuilder)localObject1).append(paramString1.substring(paramInt));
      localObject2 = ((StringBuilder)localObject1).toString();
      paramString1 = new StringBuilder();
      paramString1.append("…");
      paramString1.append(str.substring(paramInt));
      localObject1 = paramString1.toString();
      k = 7;
    }
    paramString1 = new SpannableStringBuilder((CharSequence)localObject2);
    while (k >= 0)
    {
      localObject2 = new ForegroundColorSpan(a());
      paramInt = j + k;
      paramString1.setSpan(localObject2, k, paramInt, 17);
      k = ((String)localObject1).indexOf(paramString2, paramInt);
      j = paramString2.length();
    }
    return paramString1;
  }
  
  public static String b(AppInterface paramAppInterface, String paramString)
  {
    return ((ITroopInfoService)paramAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopCodeByTroopUin(paramString);
  }
  
  public static String b(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return paramString;
  }
  
  private static String b(String paramString, long[] paramArrayOfLong)
  {
    String str = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("#");
    localStringBuilder.append(paramString);
    localStringBuilder.append("#");
    localStringBuilder.append(b(paramArrayOfLong));
    return localStringBuilder.toString();
  }
  
  private static String b(long[] paramArrayOfLong)
  {
    return a(paramArrayOfLong, ":");
  }
  
  public static void b()
  {
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_b_of_type_JavaUtilHashMap.clear();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchUtils", 2, "clearCache");
    }
  }
  
  public static void b(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).updateItemUsed(paramAppInterface, paramString1, paramString2, paramString3, paramInt);
  }
  
  public static boolean b(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2)) {
      return paramInt == 3;
    }
    return true;
  }
  
  public static boolean b(long paramLong)
  {
    return ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).isValidGroupMask(paramLong);
  }
  
  public static boolean b(AppInterface paramAppInterface, String paramString)
  {
    return ((IAddFriendServiceApi)paramAppInterface.getRuntimeService(IAddFriendServiceApi.class, "")).hasSendAddFriendReq(paramString, false);
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.trim();
    return Pattern.compile("^#[0-9a-fA-F]{3}|^#[0-9a-fA-F]{6}$|^#[0-9a-fA-F]{8}$").matcher(paramString).matches();
  }
  
  public static CharSequence c(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    Object localObject2 = paramString1.toLowerCase();
    Object localObject1 = paramString2.toLowerCase();
    int k = ((String)localObject2).indexOf((String)localObject1);
    int i = ((String)localObject1).length();
    int j = k;
    if (k < 0)
    {
      if (paramBoolean)
      {
        int[] arrayOfInt = a((String)localObject2, (String)localObject1, 1);
        if (arrayOfInt[0] >= 0) {
          i = arrayOfInt[0];
        }
        for (j = arrayOfInt[1];; j = localObject1[1])
        {
          k = j;
          j = i;
          i = k;
          break label135;
          localObject1 = a((String)localObject2, (String)localObject1, 2);
          if (localObject1[0] < 0) {
            break;
          }
          i = localObject1[0];
        }
        return new SpannableStringBuilder(paramString1);
      }
      return new SpannableStringBuilder(paramString1);
    }
    label135:
    if ((j <= paramInt) && ((j <= 6) || (j + i <= paramInt)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("(");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(")");
      localObject1 = ((StringBuilder)localObject1).toString();
      paramString1 = new StringBuilder();
      paramString1.append("(");
      paramString1.append((String)localObject2);
      paramString1.append(")");
      paramString1 = paramString1.toString();
      paramInt = j + 1;
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("(…");
      paramInt = j - 6;
      ((StringBuilder)localObject1).append(paramString1.substring(paramInt));
      ((StringBuilder)localObject1).append(")");
      localObject1 = ((StringBuilder)localObject1).toString();
      paramString1 = new StringBuilder();
      paramString1.append("(…");
      paramString1.append(((String)localObject2).substring(paramInt));
      paramString1.append(")");
      paramString1 = paramString1.toString();
      paramInt = 8;
    }
    localObject2 = new SpannableStringBuilder((CharSequence)localObject1);
    ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(MobileQQ.sMobileQQ.getResources().getColor(2131167139)), 0, ((String)localObject1).length(), 17);
    while (paramInt >= 0)
    {
      localObject1 = new ForegroundColorSpan(a());
      i += paramInt;
      ((SpannableStringBuilder)localObject2).setSpan(localObject1, paramInt, i, 17);
      paramInt = paramString1.indexOf(paramString2, i);
      i = paramString2.length();
    }
    return localObject2;
  }
  
  public static boolean c(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2)) {
      return paramInt == 21;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchUtils
 * JD-Core Version:    0.7.0.1
 */