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
import android.support.annotation.NonNull;
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
import java.net.URL;
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
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class SearchUtils
  extends BaseSearchUtil
{
  public static boolean a = false;
  public static boolean b = false;
  public static long c = -1L;
  public static long d = -1L;
  public static long e = 0L;
  public static int f = 0;
  public static int g = 0;
  public static char[] h;
  public static Paint i = null;
  public static long j = 0L;
  public static HashMap<ISearchResultModel, SearchUtils.ObjectItemInfo> k = new HashMap();
  public static final HashMap<IModel, SearchUtils.ObjectItemInfo> l = new HashMap();
  private static boolean m = true;
  private static HashMap<String, String> n = new HashMap();
  private static int o;
  
  static
  {
    e = 0L;
    f = 11;
    g = 2;
    h = new char[] { 44, 46, 8230, -244, 12290, -225, -255, -162, 35, -230, 12289, 8220, 8221, 8216, 8217, -248, -247, 45, 8212, -229, 64, 64, 35, 215, 37, 37, 46, 183, 47, 92, 12298, 12299, 12304, 12305, 60, 62 };
    o = 0;
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
  
  private static long a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 == paramInt3)
      {
        if (paramBoolean2) {
          return IContactSearchable.A;
        }
        return IContactSearchable.y;
      }
      if (paramInt1 == 0)
      {
        if (paramBoolean2) {
          return IContactSearchable.A;
        }
        return IContactSearchable.z;
      }
      if (!paramBoolean1) {
        return IContactSearchable.A;
      }
    }
    return -9223372036854775808L;
  }
  
  private static long a(String paramString, ChnToSpell.ChnSpelling paramChnSpelling, boolean paramBoolean)
  {
    paramString = a(paramChnSpelling, paramString);
    return a(paramString[0], paramString[1], paramChnSpelling.c.size(), false, paramBoolean);
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
      long l1 = a(paramString1, paramString2, paramBoolean2, paramBoolean3);
      if (l1 != -9223372036854775808L) {
        return l1 + IContactSearchable.v + paramLong;
      }
      if (paramBoolean1)
      {
        ChnToSpell.ChnSpelling localChnSpelling = ChnToSpell.a(paramString2, 1);
        if ((true ^ paramString2.equals(localChnSpelling.b)))
        {
          l1 = a(paramString1, localChnSpelling, paramBoolean3);
          if (l1 != -9223372036854775808L) {
            return l1 + IContactSearchable.w + paramLong;
          }
          l1 = a(paramString1, ChnToSpell.a(paramString2, 2), paramBoolean3);
          if (l1 != -9223372036854775808L) {
            return l1 + IContactSearchable.w + paramLong;
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
      long l1 = a(paramString1, paramString2, false, false);
      if (l1 != -9223372036854775808L) {
        return l1 + IContactSearchable.v + paramLong;
      }
      if ((paramChnSpelling1 != null) && (paramChnSpelling2 != null) && ((paramString2.equals(paramChnSpelling1.b) ^ true)))
      {
        l1 = a(paramString1, paramChnSpelling1, false);
        if (l1 != -9223372036854775808L) {
          return l1 + IContactSearchable.w + paramLong;
        }
        l1 = a(paramString1, paramChnSpelling2, false);
        if (l1 != -9223372036854775808L) {
          return l1 + IContactSearchable.w + paramLong;
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
    Drawable localDrawable = MobileQQ.sMobileQQ.getResources().getDrawable(2130841165);
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
    return a(paramIFaceDecoder, paramIFaceModel.c(), paramIFaceModel.b());
  }
  
  public static Drawable a(IFaceDecoder paramIFaceDecoder, String paramString, int paramInt)
  {
    return ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).getFaceBitmap(paramIFaceDecoder, paramString, paramInt);
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
          String str2 = paramChnSpellingAll1.d;
          String str4 = paramChnSpellingAll1.e;
          paramChnSpellingAll1 = paramChnSpellingAll1.f;
          String str3 = paramChnSpellingAll2.d;
          String str5 = paramChnSpellingAll2.e;
          paramString1 = paramChnSpellingAll2.f;
          int i2 = SpellTool.a(paramString2);
          int i6 = (int)(paramLong >> SearchConfigManager.contactSearchFieldBaseBit);
          VADHelper.a("voice_search_distance_cost");
          int i1 = b(str2, str3);
          VADHelper.b("voice_search_distance_cost");
          if (i2 != 0)
          {
            if (i2 != 1)
            {
              if (i2 == 2)
              {
                if (str5.contains(str4))
                {
                  i5 = str5.indexOf(str4);
                  if (i5 > -1)
                  {
                    i3 = str1.length();
                    i4 = ((Integer)paramChnSpellingAll2.g.get(i5)).intValue();
                    if (i5 + i3 + 1 < paramChnSpellingAll2.g.size()) {
                      i2 = ((Integer)paramChnSpellingAll2.g.get(str1.length() + i5 + 1)).intValue();
                    } else {
                      i2 = str3.length();
                    }
                    paramChnSpellingAll2 = str3.substring(i4, i2);
                    paramString1 = paramString1.substring(i4, i2);
                    VADHelper.a("voice_search_distance_cost");
                    i2 = b(str2, paramChnSpellingAll2);
                    VADHelper.b("voice_search_distance_cost");
                    i4 = i1;
                    if (i2 < i1) {
                      i4 = i2;
                    }
                    i2 = i5;
                    i1 = i3;
                    break label369;
                  }
                }
                i3 = 0;
                i2 = 0;
                i4 = i1;
                i1 = i3;
                label369:
                VADHelper.a("voice_search_sy_cost");
                i3 = c(paramChnSpellingAll1, paramString1);
                VADHelper.b("voice_search_sy_cost");
                break label842;
              }
            }
            else
            {
              if (str3.contains(str2))
              {
                i3 = str3.indexOf(str2);
                if (paramString2.length() > i3)
                {
                  if (SpellTool.a(paramString2.charAt(i3)))
                  {
                    if (str1.length() + i3 > paramString2.length()) {
                      break label568;
                    }
                    i4 = ((Integer)paramChnSpellingAll2.g.get(i3)).intValue();
                    if (str1.length() + i3 + 1 < paramChnSpellingAll2.g.size()) {
                      i2 = ((Integer)paramChnSpellingAll2.g.get(str1.length() + i3 + 1)).intValue();
                    } else {
                      i2 = str3.length();
                    }
                    if (!str2.equalsIgnoreCase(str3.substring(i4, i2))) {
                      break label568;
                    }
                    i1 = str1.length();
                  }
                  else
                  {
                    i1 = str2.length();
                  }
                  i4 = 0;
                  i2 = i3;
                  break label582;
                }
                label568:
                i3 = 0;
                i2 = 0;
                i4 = i1;
                i1 = i3;
                label582:
                i3 = 0;
                break label842;
              }
              if (str5.contains(str4))
              {
                i3 = str5.indexOf(str4);
                if (i3 > -1)
                {
                  i5 = str1.length();
                  i4 = ((Integer)paramChnSpellingAll2.g.get(i3)).intValue();
                  if (i3 + i5 + 1 < paramChnSpellingAll2.g.size()) {
                    i2 = ((Integer)paramChnSpellingAll2.g.get(str1.length() + i3 + 1)).intValue();
                  } else {
                    i2 = str3.length();
                  }
                  paramChnSpellingAll2 = str3.substring(i4, i2);
                  paramString1 = paramString1.substring(i4, i2);
                  VADHelper.a("voice_search_distance_cost");
                  i2 = b(str2, paramChnSpellingAll2);
                  VADHelper.b("voice_search_distance_cost");
                  i4 = i1;
                  if (i2 < i1) {
                    i4 = i2;
                  }
                  i1 = c(paramChnSpellingAll1, paramString1);
                  i2 = i3;
                  i3 = i1;
                  i1 = i5;
                  break label842;
                }
              }
            }
          }
          else
          {
            if (str3.contains(str2))
            {
              i2 = str3.indexOf(str2);
              i1 = str2.length();
              i3 = 0;
              i4 = 0;
              break label842;
            }
            if (i1 < 1)
            {
              i3 = paramString2.length();
              break label824;
            }
          }
          int i3 = 0;
          label824:
          int i5 = 0;
          i2 = 0;
          int i4 = i1;
          i1 = i3;
          i3 = i5;
          label842:
          ((SearchMatchResult)localObject).i = i4;
          ((SearchMatchResult)localObject).a = true;
          ((SearchMatchResult)localObject).b = str1;
          ((SearchMatchResult)localObject).c = str2;
          ((SearchMatchResult)localObject).d = paramString2;
          ((SearchMatchResult)localObject).e = str3;
          i5 = i2;
          if (paramString2.length() < i2) {
            i5 = 0;
          }
          ((SearchMatchResult)localObject).f = i5;
          i2 = i1;
          if (paramString2.length() - ((SearchMatchResult)localObject).f < i1) {
            i2 = paramString2.length() - ((SearchMatchResult)localObject).f;
          }
          ((SearchMatchResult)localObject).g = i2;
          ((SearchMatchResult)localObject).h = ((100 - i4 << 8) + (i3 << 4) + i6);
        }
      }
    }
    return localObject;
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
    float f1 = a(paramTextView, HardCodeUtil.a(2131911139));
    float f2 = paramInt * paramFloat - (paramInt - 1) * f1;
    if ((!TextUtils.isEmpty(paramCharSequence)) && (paramTextView != null))
    {
      f1 = 0.0F;
      if (f2 > 0.0F)
      {
        if ((paramList != null) && (paramList.size() != 0))
        {
          int i5 = 0;
          int i2 = -1;
          int i1 = 0;
          int i3;
          int i4;
          while (i5 < paramList.size())
          {
            localObject = (String)paramList.get(i5);
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              if ((i2 >= 0) && (i1 > 1) && (((String)localObject).length() == 1)) {
                break;
              }
              localObject = b(paramCharSequence, (String)localObject, paramBoolean1);
              paramCharSequence = ((SearchUtils.MatchedResult)localObject).a;
              i3 = i2;
              i4 = i1;
              if (i2 == -1)
              {
                i3 = i2;
                i4 = i1;
                if (i1 == 0)
                {
                  i3 = i2;
                  i4 = i1;
                  if (((SearchUtils.MatchedResult)localObject).b != -1)
                  {
                    i3 = i2;
                    i4 = i1;
                    if (((SearchUtils.MatchedResult)localObject).c > 0)
                    {
                      i3 = ((SearchUtils.MatchedResult)localObject).b;
                      i4 = ((SearchUtils.MatchedResult)localObject).c;
                    }
                  }
                }
              }
              i1 = i4;
              i2 = i3;
            }
            i5 += 1;
          }
          if (a(paramTextView, paramCharSequence) <= f2) {
            return paramCharSequence;
          }
          if ((!TextUtils.isEmpty(paramCharSequence)) && (i2 >= 0))
          {
            i4 = i2 + i1;
            if (i4 <= paramCharSequence.length())
            {
              localObject = paramCharSequence.subSequence(0, i4);
              paramList = (List<String>)localObject;
              if (i4 < paramCharSequence.length())
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
                  i3 = paramInt;
                  if (paramFloat >= f3) {
                    break;
                  }
                  i3 = paramInt;
                  if (paramInt >= paramCharSequence.length()) {
                    break;
                  }
                  ((StringBuilder)localObject).append(paramCharSequence.charAt(paramInt));
                  paramFloat = a(paramTextView, ((StringBuilder)localObject).toString());
                  if (paramFloat > f3)
                  {
                    ((StringBuilder)localObject).deleteCharAt(paramInt);
                    i3 = paramInt - 1;
                    break;
                  }
                  if (paramFloat == f3)
                  {
                    i3 = paramInt;
                    break;
                  }
                  paramInt += 1;
                }
                paramInt = i3 + 1;
                paramList = new SpannableStringBuilder(paramCharSequence.subSequence(0, paramInt));
                paramFloat = f2 - a(paramTextView, ((StringBuilder)localObject).toString());
                if (paramInt < paramCharSequence.length())
                {
                  paramCharSequence = paramCharSequence.subSequence(paramInt, paramCharSequence.length());
                  if (paramInt >= i2)
                  {
                    paramTextView = a(paramTextView, paramFloat, paramCharSequence);
                    if (paramInt < i4)
                    {
                      paramInt = Math.min(paramTextView.length(), i1 - (paramInt - i2));
                      paramTextView = new SpannableStringBuilder(paramTextView);
                      paramTextView.setSpan(new ForegroundColorSpan(a()), 0, paramInt, 17);
                      paramList.append(paramTextView);
                      return paramList;
                    }
                    paramList.append(paramTextView);
                    return paramList;
                  }
                  paramList.append(a(paramTextView, paramFloat, paramCharSequence, i2 - paramInt, i1));
                }
                return paramList;
              }
              return a(paramTextView, f2, paramCharSequence, i2, i1);
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
      float f1 = 0.0F;
      if (paramFloat > 0.0F)
      {
        if (paramFloat > a(paramTextView, paramCharSequence)) {
          return paramCharSequence;
        }
        Object localObject = new StringBuilder();
        int i1 = 0;
        int i2;
        for (;;)
        {
          i2 = i1;
          if (f1 >= paramFloat) {
            break;
          }
          i2 = i1;
          if (i1 >= paramCharSequence.length()) {
            break;
          }
          ((StringBuilder)localObject).append(paramCharSequence.charAt(i1));
          f1 = a(paramTextView, ((StringBuilder)localObject).toString());
          if (f1 > paramFloat)
          {
            ((StringBuilder)localObject).deleteCharAt(i1);
            i2 = i1 - 1;
            break;
          }
          if (f1 == paramFloat)
          {
            i2 = i1;
            break;
          }
          i1 += 1;
        }
        i1 = i2 + 1;
        paramTextView = paramCharSequence.subSequence(0, i1);
        localObject = new SpannableStringBuilder(paramTextView);
        if (i2 < paramCharSequence.length() - 1)
        {
          ((SpannableStringBuilder)localObject).delete(i2, i1);
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
          int i1 = paramInt2;
          int i2;
          if (f2 < paramFloat)
          {
            int i3 = 0;
            for (i1 = paramInt2;; i1 = i2)
            {
              paramInt2 = paramInt1;
              i2 = i1;
              if (f2 >= paramFloat) {
                break;
              }
              if (paramInt1 <= 0)
              {
                paramInt2 = paramInt1;
                i2 = i1;
                if (i1 >= paramCharSequence.length()) {
                  break;
                }
              }
              int i4 = i3 % 2;
              f1 = f2;
              paramInt2 = paramInt1;
              if (i4 == 0)
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
                    i2 = i1;
                    break;
                  }
                }
              }
              f2 = f1;
              i2 = i1;
              if (i4 != 0)
              {
                f2 = f1;
                i2 = i1;
                if (i1 < paramCharSequence.length())
                {
                  paramInt1 = i1 + 1;
                  ((StringBuilder)localObject).insert(((StringBuilder)localObject).length(), paramCharSequence.charAt(paramInt1 - 1));
                  f1 = a(paramTextView, ((StringBuilder)localObject).toString());
                  f2 = f1;
                  i2 = paramInt1;
                  if (f1 > paramFloat)
                  {
                    ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
                    i2 = paramInt1 - 1;
                    break;
                  }
                }
              }
              i3 += 1;
              paramInt1 = paramInt2;
            }
          }
          for (;;)
          {
            paramInt2 = paramInt1;
            i2 = i1;
            if (f1 <= paramFloat) {
              break;
            }
            paramInt2 = paramInt1;
            i2 = i1;
            if (i1 <= paramInt1) {
              break;
            }
            ((StringBuilder)localObject).deleteCharAt(i1 - paramInt1 - 1);
            i1 -= 1;
            f1 = a(paramTextView, ((StringBuilder)localObject).toString());
          }
          localObject = new SpannableStringBuilder(paramCharSequence.subSequence(paramInt2, i2));
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
          if ((i2 < paramCharSequence.length()) && (!TextUtils.isEmpty(paramTextView)))
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
    if (i == null)
    {
      i = ((TextView)LayoutInflater.from(paramAppInterface.getApp()).inflate(2131629234, null).findViewById(2131447463)).getPaint();
      if (o == 0) {
        o = paramAppInterface.getApp().getResources().getDimensionPixelOffset(2131299170);
      }
    }
    String str = paramString1.toLowerCase();
    paramAppInterface = paramString2;
    int i4 = str.indexOf(paramAppInterface);
    int i3 = paramString2.length();
    int i1 = i4;
    int i2 = i3;
    if (i4 < 0)
    {
      paramString1 = paramString2.toLowerCase();
      i4 = str.indexOf(paramString1);
      paramAppInterface = paramString1;
      i1 = i4;
      i2 = i3;
      if (i4 < 0)
      {
        paramAppInterface = a(str, paramString1, 1);
        if (paramAppInterface[0] >= 0) {
          i1 = paramAppInterface[0];
        }
        for (i2 = paramAppInterface[1];; i2 = paramAppInterface[1])
        {
          paramAppInterface = paramString1;
          break label189;
          paramAppInterface = a(str, paramString1, 2);
          if (paramAppInterface[0] < 0) {
            break;
          }
          i1 = paramAppInterface[0];
        }
        return new SpannableStringBuilder((CharSequence)localObject);
      }
    }
    label189:
    float f1 = i.measureText((String)localObject);
    float f2 = i.measureText(paramAppInterface);
    paramString2 = (String)localObject;
    paramString1 = str;
    i3 = i1;
    if (f1 >= o)
    {
      paramString2 = (String)localObject;
      paramString1 = str;
      i3 = i1;
      if (i1 > 0)
      {
        f1 = Math.min(f2 + i.measureText("…"), f1);
        f2 = o - f1;
        paramString1 = ((String)localObject).substring(0, i1);
        float[] arrayOfFloat = new float[paramString1.length()];
        i.getTextWidths(paramString1, arrayOfFloat);
        i4 = arrayOfFloat.length - 1;
        int i5 = 0;
        f1 = 0.0F;
        for (;;)
        {
          paramString2 = (String)localObject;
          paramString1 = str;
          i3 = i1;
          if (i4 < 0) {
            break label454;
          }
          i5 += 1;
          f1 += arrayOfFloat[i4];
          if ((f1 > f2) || (i5 >= paramInt)) {
            break;
          }
          i4 -= 1;
        }
        if (f2 <= 0.0F) {
          i5 = 0;
        }
        paramString1 = new StringBuilder();
        paramString1.append("…");
        paramInt = i1 - i5;
        paramString1.append(((String)localObject).substring(paramInt));
        paramString2 = paramString1.toString();
        paramString1 = new StringBuilder();
        paramString1.append("…");
        paramString1.append(str.substring(paramInt));
        paramString1 = paramString1.toString();
        i3 = i5 + 1;
      }
    }
    label454:
    paramString2 = new SpannableStringBuilder(paramString2);
    paramInt = a();
    while (i3 >= 0)
    {
      localObject = new ForegroundColorSpan(paramInt);
      i1 = i2 + i3;
      paramString2.setSpan(localObject, i3, i1, 17);
      i3 = paramString1.indexOf(paramAppInterface, i1);
      i2 = paramAppInterface.length();
    }
    return paramString2;
  }
  
  public static CharSequence a(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt, SearchMatchResult paramSearchMatchResult)
  {
    if (paramSearchMatchResult == null) {
      return new SpannableStringBuilder(paramString1);
    }
    if (i == null)
    {
      i = ((TextView)LayoutInflater.from(paramAppInterface.getApp()).inflate(2131629234, null).findViewById(2131447463)).getPaint();
      if (o == 0) {
        o = paramAppInterface.getApp().getResources().getDimensionPixelOffset(2131299170);
      }
    }
    String str = paramString1.toLowerCase();
    int i4 = paramSearchMatchResult.f;
    int i6 = paramSearchMatchResult.g;
    if ((i4 >= 0) && (i4 <= paramString1.length()) && (paramString1.equalsIgnoreCase(paramSearchMatchResult.d)) && (paramSearchMatchResult.i <= 1))
    {
      float f1 = i.measureText(paramString1);
      float f2 = i.measureText(paramString2);
      int i3 = i4;
      paramAppInterface = paramString1;
      if (f1 >= o)
      {
        i3 = i4;
        paramAppInterface = paramString1;
        if (i4 >= 0)
        {
          f1 = Math.min(f2 + i.measureText("…"), f1);
          f2 = o - f1;
          int i5 = 0;
          paramAppInterface = paramString1.substring(0, i4);
          paramString2 = new float[paramAppInterface.length()];
          i.getTextWidths(paramAppInterface, paramString2);
          int i1 = paramString2.length - 1;
          int i2 = 0;
          f1 = 0.0F;
          for (;;)
          {
            i3 = i4;
            paramAppInterface = paramString1;
            if (i1 < 0) {
              break label385;
            }
            i2 += 1;
            f1 += paramString2[i1];
            if ((f1 > f2) || (i2 >= paramInt)) {
              break;
            }
            i1 -= 1;
          }
          if (f2 <= 0.0F) {
            paramInt = i5;
          } else {
            paramInt = i2;
          }
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("…");
          i1 = i4 - paramInt;
          paramAppInterface.append(paramString1.substring(i1));
          paramAppInterface = paramAppInterface.toString();
          paramString1 = new StringBuilder();
          paramString1.append("…");
          paramString1.append(str.substring(i1));
          paramString1.toString();
          i3 = paramInt + 1;
        }
      }
      label385:
      paramString1 = new SpannableStringBuilder(paramAppInterface);
      paramInt = i6 + i3;
      if (paramInt <= paramAppInterface.length()) {
        paramString1.setSpan(new ForegroundColorSpan(a()), i3, paramInt, 17);
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
      int i4 = str.indexOf(paramString);
      int i3 = paramString.length();
      int i1 = i4;
      int i2 = i3;
      localObject = paramString;
      if (i4 < 0)
      {
        paramString = paramString.toLowerCase();
        i4 = str.indexOf(paramString);
        i1 = i4;
        i2 = i3;
        localObject = paramString;
        if (i4 < 0)
        {
          if (paramBoolean)
          {
            localObject = a(str, paramString, 1);
            if (localObject[0] >= 0)
            {
              i1 = localObject[0];
              i2 = localObject[1];
              localObject = paramString;
              break label215;
            }
            localObject = a(str, paramString, 2);
            if (localObject[0] >= 0)
            {
              i1 = localObject[0];
              i2 = localObject[1];
              localObject = paramString;
              break label215;
            }
          }
          return paramCharSequence;
        }
      }
      label215:
      paramCharSequence = new SpannableStringBuilder(paramCharSequence);
      while ((i1 >= 0) && (i1 < paramCharSequence.length()))
      {
        i3 = i1 + i2;
        if ((i3 > paramCharSequence.length()) || (i2 <= 0)) {
          break;
        }
        paramCharSequence.setSpan(new ForegroundColorSpan(b()), i1, i3, 17);
        i1 = str.indexOf((String)localObject, i3);
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
      int i2 = 0;
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
        i1 = i2;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (String)((Iterator)localObject1).next();
      } while (paramString.toLowerCase().indexOf(((String)localObject2).toLowerCase()) != paramInt);
      int i1 = ((String)localObject2).length();
      if (paramInt <= 10)
      {
        localObject1 = paramString;
        if (paramInt > 6)
        {
          localObject1 = paramString;
          if (i1 + paramInt <= 10) {}
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
          i1 = ((String)localObject2).length();
          while (paramInt >= 0)
          {
            ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(a());
            i2 = paramInt + i1;
            paramString.setSpan(localForegroundColorSpan, paramInt, i2, 17);
            paramInt = ((String)localObject1).toLowerCase().indexOf(((String)localObject2).toLowerCase(), i2);
          }
        }
      }
      return paramString;
    }
    return new SpannableStringBuilder(paramString);
  }
  
  public static CharSequence a(String paramString1, String paramString2)
  {
    return b(paramString1, paramString2, 10);
  }
  
  public static CharSequence a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    String str = paramString1.toLowerCase();
    int i4 = str.indexOf(paramString2);
    int i3 = paramString2.length();
    int i1 = i4;
    int i2 = i3;
    Object localObject1 = paramString2;
    if (i4 < 0)
    {
      paramString2 = paramString2.toLowerCase();
      i4 = str.indexOf(paramString2);
      i1 = i4;
      i2 = i3;
      localObject1 = paramString2;
      if (i4 < 0)
      {
        if (paramBoolean)
        {
          localObject1 = a(str, paramString2, 1);
          if (localObject1[0] >= 0) {
            i2 = localObject1[0];
          }
          for (i1 = localObject1[1];; i1 = localObject1[1])
          {
            i3 = i1;
            i1 = i2;
            i2 = i3;
            localObject1 = paramString2;
            break label164;
            localObject1 = a(str, paramString2, 2);
            if (localObject1[0] < 0) {
              break;
            }
            i2 = localObject1[0];
          }
          return new SpannableStringBuilder(paramString1);
        }
        return new SpannableStringBuilder(paramString1);
      }
    }
    label164:
    Object localObject2;
    if (i1 <= paramInt)
    {
      paramString2 = str;
      i3 = i1;
      localObject2 = paramString1;
      if (i1 > 4)
      {
        paramString2 = str;
        i3 = i1;
        localObject2 = paramString1;
        if (i1 + i2 <= paramInt) {}
      }
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append("…");
      paramInt = i1 - 4;
      paramString2.append(paramString1.substring(paramInt));
      localObject2 = paramString2.toString();
      paramString1 = new StringBuilder();
      paramString1.append("…");
      paramString1.append(str.substring(paramInt));
      paramString2 = paramString1.toString();
      i3 = 5;
    }
    paramString1 = new SpannableStringBuilder((CharSequence)localObject2);
    while (i3 >= 0)
    {
      localObject2 = new ForegroundColorSpan(a());
      paramInt = i2 + i3;
      paramString1.setSpan(localObject2, i3, paramInt, 17);
      i3 = paramString2.indexOf((String)localObject1, paramInt);
      i2 = ((String)localObject1).length();
    }
    return paramString1;
  }
  
  public static CharSequence a(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = paramString1.toLowerCase();
    paramString2 = paramString2.toLowerCase();
    int i1 = str.indexOf(paramString2);
    int i2 = paramString2.length();
    int i3;
    if (i1 < 0)
    {
      if (paramBoolean)
      {
        localObject = a(str, paramString2, 1);
        if (localObject[0] >= 0) {
          i1 = localObject[0];
        }
        for (i2 = localObject[1];; i2 = localObject[1])
        {
          break;
          localObject = a(str, paramString2, 2);
          if (localObject[0] < 0) {
            break label98;
          }
          i1 = localObject[0];
        }
        i3 = 0;
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
      i3 = 1;
    }
    label119:
    paramString1 = new SpannableStringBuilder(paramString1);
    int i4;
    for (;;)
    {
      localObject = new ForegroundColorSpan(a());
      i4 = i1 + i2;
      paramString1.setSpan(localObject, i1, i4, 17);
      if (i3 == 0) {
        break label189;
      }
      i1 = str.indexOf(paramString2, i4);
      i2 = paramString2.length();
      if (i1 < 0) {
        break;
      }
      i3 = 1;
    }
    return paramString1;
    label189:
    Object localObject = a(str.substring(i4), paramString2, 1);
    if (localObject[0] >= 0) {
      i1 = localObject[0] + i1 + i2;
    }
    for (i2 = localObject[1];; i2 = localObject[1])
    {
      break;
      localObject = a(str.substring(i4), paramString2, 2);
      if (localObject[0] < 0) {
        return paramString1;
      }
      i1 = localObject[0] + i1 + i2;
    }
    return paramString1;
  }
  
  public static CharSequence a(String paramString, ArrayList<String> paramArrayList, int paramInt)
  {
    Object localObject = paramArrayList.iterator();
    int i1 = 0;
    int i2 = 0;
    String str1;
    String str2;
    while (((Iterator)localObject).hasNext())
    {
      str1 = (String)((Iterator)localObject).next();
      str2 = paramString.toLowerCase();
      i1 = str2.indexOf(str1);
      i2 = str1.length();
      if (i1 >= 0) {
        break;
      }
      i1 = str2.indexOf(str1.toLowerCase());
      if (i1 >= 0) {
        break;
      }
    }
    if (i1 < 0) {
      return new SpannableStringBuilder(paramString);
    }
    if (i1 <= paramInt)
    {
      localObject = paramString;
      if (i1 > 6)
      {
        localObject = paramString;
        if (i2 + i1 <= paramInt) {}
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("…");
      ((StringBuilder)localObject).append(paramString.substring(i1 - 6));
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = new SpannableStringBuilder((CharSequence)localObject);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      str1 = (String)paramArrayList.next();
      str2 = ((String)localObject).toLowerCase();
      i1 = str2.indexOf(str1);
      i2 = str1.length();
      paramInt = i1;
      if (i1 < 0)
      {
        i1 = str2.indexOf(str1.toLowerCase());
        paramInt = i1;
        if (i1 < 0) {}
      }
      else
      {
        paramString.setSpan(new ForegroundColorSpan(a()), paramInt, i2 + paramInt, 17);
      }
    }
    return paramString;
  }
  
  public static CharSequence a(JSONArray paramJSONArray)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (paramJSONArray != null)
    {
      int i1 = 0;
      while (i1 < paramJSONArray.length())
      {
        Object localObject1 = paramJSONArray.optJSONObject(i1);
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
        i1 += 1;
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
      localObject = paramContext.getResources().getString(2131888722);
    }
    return localObject;
  }
  
  public static String a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    return ((ITroopMemberNameService)paramAppInterface.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(paramString1, paramString2);
  }
  
  public static String a(Friends paramFriends)
  {
    return paramFriends.getFriendNickWithAlias();
  }
  
  public static String a(String paramString, List<Long> paramList)
  {
    return a(paramString, b(paramList));
  }
  
  public static String a(String paramString, long[] paramArrayOfLong)
  {
    try
    {
      paramArrayOfLong = (String)n.get(b(paramString, paramArrayOfLong));
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
    return a(b(paramList), "::");
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
      int i2 = paramArrayOfLong.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localStringBuilder.append(paramArrayOfLong[i1]);
        localStringBuilder.append(paramString);
        i1 += 1;
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
    int i1 = 0;
    while (i1 < paramVarArgs.length)
    {
      if (!TextUtils.isEmpty(paramVarArgs[i1])) {
        return paramVarArgs[i1];
      }
      i1 += 1;
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
    ((HashMap)localObject).put("input_type", String.valueOf(e));
    ((HashMap)localObject).put("support_sougou_ime", String.valueOf(b));
    return localObject;
  }
  
  public static List<Groups> a(AppInterface paramAppInterface)
  {
    return ((IFriendDataService)paramAppInterface.getRuntimeService(IFriendDataService.class, "")).getGroupList();
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString1, String paramString2, int paramInt4)
  {
    int i1;
    switch (paramInt1)
    {
    default: 
      i1 = -1;
      break;
    case 80000002: 
      i1 = 90;
      break;
    case 80000001: 
      i1 = 80;
      break;
    case 80000000: 
      i1 = 70;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("moduleType:");
      ((StringBuilder)localObject).append(i1);
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
      ((HashMap)localObject).put("moduleType", Integer.toString(i1));
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
      ((HashMap)localObject).put("moduleType", Integer.toString(i1));
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
    localIntent.putExtra("contactSearchResultUin", paramIContactSearchModel.c());
    localIntent.putExtra("contactSearchResultUinType", paramIContactSearchModel.j());
    localIntent.putExtra("contactSearchResultName", paramIContactSearchModel.m());
    localIntent.putExtra("contactSearchResultNick", paramIContactSearchModel.n());
    if ((!(paramIContactSearchModel instanceof ContactSearchModelDiscussion)) && (!(paramIContactSearchModel instanceof ContactSearchModelTroop)) && (!(paramIContactSearchModel instanceof ContactSearchModelNewTroop)))
    {
      if ((paramIContactSearchModel instanceof ContactSearchModelDiscussionMember)) {
        paramView = ((ContactSearchModelDiscussionMember)paramIContactSearchModel).s();
      } else if ((paramIContactSearchModel instanceof ContactSearchModelNewTroopMember)) {
        paramView = ((ContactSearchModelNewTroopMember)paramIContactSearchModel).a;
      } else if ((paramIContactSearchModel instanceof ContactSearchModelRecentUser)) {
        paramView = ((ContactSearchModelRecentUser)paramIContactSearchModel).s();
      } else {
        paramView = "";
      }
    }
    else {
      paramView = paramIContactSearchModel.c();
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
      if (c(paramString))
      {
        ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToNativeSearchResultPage(paramActivity, d(paramString), paramString);
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
      if (c(paramString))
      {
        ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToNativeSearchResultPage(paramContext, d(paramString), paramString);
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
    ThreadManager.postImmediately(new SearchUtils.2(paramView, paramIContactSearchModel), null, true);
  }
  
  public static void a(String paramString)
  {
    ThreadManager.getUIHandler().post(new SearchUtils.1(paramString));
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
      int i1 = SearchStatisticsConstants.a(paramInt1);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("moduleIndex:");
        paramView.append(i1);
        paramView.append(" searchKey:");
        paramView.append(paramString);
        QLog.d("searchUtils", 2, paramView.toString());
      }
      ReportController.b(null, "CliOper", "", "", "0X8005E10", "0X8005E10", paramInt1, 0, String.valueOf(i1), String.valueOf(paramInt3), String.valueOf(paramInt2), "");
      paramView = new HashMap();
      paramView.put("moduleType", Integer.toString(paramInt1));
      paramView.put("moduleIndex", Integer.toString(i1));
      paramView.put("moduleChildType", Integer.toString(paramInt2));
      paramView.put("itemLinePosition", Integer.toString(paramInt3));
      paramView.put("keyword", paramString);
      if (d != -1L) {
        paramView.put("stay_time", String.valueOf(System.currentTimeMillis() - d));
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
    int i1 = ((Integer)paramView.getTag(2131449868)).intValue() + 1;
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("moduleType:");
      paramView.append(paramInt1);
      paramView.append(" itemLinePosition:");
      paramView.append(i1);
      QLog.d("searchUtils", 2, paramView.toString());
    }
    if (bool)
    {
      int i2 = SearchStatisticsConstants.a(paramInt1);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("moduleIndex:");
        paramView.append(i2);
        paramView.append(" searchKey:");
        paramView.append(paramString);
        QLog.d("searchUtils", 2, paramView.toString());
      }
      ReportController.b(null, "CliOper", "", "", "0X8005E10", "0X8005E10", paramInt1, 0, String.valueOf(i2), String.valueOf(i1), String.valueOf(paramInt2), "");
      paramView = new HashMap();
      paramView.put("moduleType", Integer.toString(paramInt1));
      paramView.put("moduleIndex", Integer.toString(i2));
      paramView.put("moduleChildType", Integer.toString(paramInt2));
      paramView.put("itemLinePosition", Integer.toString(i1));
      paramView.put("keyword", paramString);
      if (d != -1L) {
        paramView.put("stay_time", String.valueOf(System.currentTimeMillis() - d));
      }
      StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(null, "GroupSearchItemClick", true, 0L, 0L, a(paramView), null);
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005E11", "0X8005E11", paramInt1, 0, "", String.valueOf(i1), String.valueOf(paramInt2), "");
    paramView = new HashMap();
    paramView.put("moduleType", Integer.toString(paramInt1));
    paramView.put("moduleChildType", Integer.toString(paramInt2));
    paramView.put("itemLinePosition", Integer.toString(i1));
    paramView.put("keyword", paramString);
    StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(null, "ModelSearchItemClick", true, 0L, 0L, paramView, null);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, View paramView, String paramString2, boolean paramBoolean, int paramInt3)
  {
    boolean bool = a(paramView.getContext());
    int i1 = ((Integer)paramView.getTag(2131449868)).intValue() + 1;
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("moduleType:");
      paramView.append(paramInt1);
      paramView.append(" itemLinePosition:");
      paramView.append(i1);
      QLog.d("searchUtils", 2, paramView.toString());
    }
    if (bool)
    {
      int i2 = SearchStatisticsConstants.a(paramInt1);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("moduleIndex:");
        paramView.append(i2);
        paramView.append(" searchKey:");
        paramView.append(paramString1);
        QLog.d("searchUtils", 2, paramView.toString());
      }
      ReportController.b(null, "CliOper", "", "", "0X8005E10", "0X8005E10", paramInt1, 0, String.valueOf(i2), String.valueOf(i1), String.valueOf(paramInt2), "");
      paramView = new HashMap();
      paramView.put("moduleType", Integer.toString(paramInt1));
      paramView.put("moduleIndex", Integer.toString(i2));
      paramView.put("moduleChildType", Integer.toString(paramInt2));
      paramView.put("itemLinePosition", Integer.toString(i1));
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
      if (d != -1L) {
        paramView.put("stay_time", String.valueOf(System.currentTimeMillis() - d));
      }
      StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(null, "GroupSearchItemClick", true, 0L, 0L, a(paramView), null);
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005E11", "0X8005E11", paramInt1, 0, "", String.valueOf(i1), String.valueOf(paramInt2), "");
    paramView = new HashMap();
    paramView.put("moduleType", Integer.toString(paramInt1));
    paramView.put("moduleChildType", Integer.toString(paramInt2));
    paramView.put("itemLinePosition", Integer.toString(i1));
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
      n.put(b(paramString1, paramArrayOfLong), paramString2);
      return;
    }
    catch (RuntimeException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils updateReportVersion", 2, paramString1.toString());
      }
    }
  }
  
  public static boolean a(long paramLong)
  {
    return ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).isEntityGroup(paramLong);
  }
  
  private static boolean a(Context paramContext)
  {
    return ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).isUniteSearchActivity(paramContext);
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    return ((IAddFriendServiceApi)paramAppInterface.getRuntimeService(IAddFriendServiceApi.class, "")).hasSendAddFriendReq(paramString, paramBoolean, false);
  }
  
  public static boolean a(ISearchResultModel paramISearchResultModel)
  {
    return ((paramISearchResultModel instanceof ContactSearchModelDiscussion)) || ((paramISearchResultModel instanceof ContactSearchModelGlobalTroop)) || ((paramISearchResultModel instanceof ContactSearchModelNewTroop)) || ((paramISearchResultModel instanceof ContactSearchModelTroop));
  }
  
  public static int b()
  {
    int i1 = MobileQQ.sMobileQQ.getResources().getColor(2131167904);
    if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, "")) {
      i1 = MobileQQ.sMobileQQ.getResources().getColor(2131167906);
    }
    return i1;
  }
  
  public static int b(String paramString1, String paramString2)
  {
    int i3 = paramString1.length();
    int i4 = paramString2.length();
    int i5 = i3 + 1;
    int i6 = i4 + 1;
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i5, i6 });
    int i1 = 0;
    while (i1 < i6)
    {
      arrayOfInt[0][i1] = i1;
      i1 += 1;
    }
    i1 = 0;
    while (i1 < i5)
    {
      arrayOfInt[i1][0] = i1;
      i1 += 1;
    }
    i1 = 1;
    while (i1 < i5)
    {
      int i2 = 1;
      while (i2 < i6)
      {
        int i7 = i1 - 1;
        int i8 = paramString1.charAt(i7);
        int i9 = i2 - 1;
        if (i8 == paramString2.charAt(i9)) {
          arrayOfInt[i1][i2] = arrayOfInt[i7][i9];
        } else {
          arrayOfInt[i1][i2] = (Math.min(arrayOfInt[i7][i9], Math.min(arrayOfInt[i7][i2], arrayOfInt[i1][i9])) + 1);
        }
        i2 += 1;
      }
      i1 += 1;
    }
    return arrayOfInt[i3][i4];
  }
  
  public static long b(String paramString1, String paramString2, long paramLong)
  {
    return a(paramString1, paramString2, paramLong, true);
  }
  
  public static TroopMemberInfo b(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    return ((ITroopMemberInfoService)paramAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(paramString1, paramString2);
  }
  
  public static SearchUtils.MatchedResult b(CharSequence paramCharSequence, String paramString, boolean paramBoolean)
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
      int i4 = str.indexOf(paramString);
      int i3 = paramString.length();
      int i1 = i4;
      int i2 = i3;
      localObject = paramString;
      if (i4 < 0)
      {
        paramString = paramString.toLowerCase();
        i4 = str.indexOf(paramString);
        i1 = i4;
        i2 = i3;
        localObject = paramString;
        if (i4 < 0) {
          if (paramBoolean)
          {
            localObject = a(str, paramString, 1);
            if (localObject[0] >= 0)
            {
              i1 = localObject[0];
              i2 = localObject[1];
              localObject = paramString;
            }
            else
            {
              localObject = a(str, paramString, 2);
              if (localObject[0] >= 0)
              {
                i1 = localObject[0];
                i2 = localObject[1];
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
      for (i3 = i1; (i3 >= 0) && (i3 < paramCharSequence.length()); i3 = str.indexOf((String)localObject, i4))
      {
        i4 = i3 + i2;
        if ((i4 > paramCharSequence.length()) || (i2 <= 0)) {
          break;
        }
        paramCharSequence.setSpan(new ForegroundColorSpan(a()), i3, i4, 17);
      }
      return new SearchUtils.MatchedResult(paramCharSequence, i1, i2);
    }
    return new SearchUtils.MatchedResult(paramCharSequence);
  }
  
  public static CharSequence b(String paramString1, String paramString2, int paramInt)
  {
    return a(paramString1, paramString2, paramInt, true);
  }
  
  public static CharSequence b(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    String str = paramString1.toLowerCase();
    Object localObject1 = paramString2.toLowerCase();
    int i3 = str.indexOf((String)localObject1);
    int i2 = ((String)localObject1).length();
    int i1 = i3;
    Object localObject2;
    if (i3 < 0) {
      if (paramBoolean)
      {
        localObject2 = a(str, (String)localObject1, 1);
        if (localObject2[0] >= 0)
        {
          i1 = localObject2[0];
          i2 = localObject2[1];
        }
        else
        {
          localObject1 = a(str, (String)localObject1, 2);
          if (localObject1[0] >= 0)
          {
            i1 = localObject1[0];
            i2 = localObject1[1];
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
    if (i1 <= paramInt)
    {
      localObject1 = str;
      i3 = i1;
      localObject2 = paramString1;
      if (i1 > 6)
      {
        localObject1 = str;
        i3 = i1;
        localObject2 = paramString1;
        if (i1 + i2 <= paramInt) {}
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("…");
      paramInt = i1 - 6;
      ((StringBuilder)localObject1).append(paramString1.substring(paramInt));
      localObject2 = ((StringBuilder)localObject1).toString();
      paramString1 = new StringBuilder();
      paramString1.append("…");
      paramString1.append(str.substring(paramInt));
      localObject1 = paramString1.toString();
      i3 = 7;
    }
    paramString1 = new SpannableStringBuilder((CharSequence)localObject2);
    while (i3 >= 0)
    {
      localObject2 = new ForegroundColorSpan(a());
      paramInt = i2 + i3;
      paramString1.setSpan(localObject2, i3, paramInt, 17);
      i3 = ((String)localObject1).indexOf(paramString2, paramInt);
      i2 = paramString2.length();
    }
    return paramString1;
  }
  
  public static String b(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return null;
    }
    return Pattern.compile("[\\s|\\t|\\r|\\n]+").matcher(paramCharSequence).replaceAll("");
  }
  
  private static String b(String paramString, long[] paramArrayOfLong)
  {
    String str = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("#");
    localStringBuilder.append(paramString);
    localStringBuilder.append("#");
    localStringBuilder.append(c(paramArrayOfLong));
    return localStringBuilder.toString();
  }
  
  public static List<Long> b(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong != null)
    {
      ArrayList localArrayList = new ArrayList(paramArrayOfLong.length);
      int i1 = 0;
      while (i1 < paramArrayOfLong.length)
      {
        localArrayList.add(Long.valueOf(paramArrayOfLong[i1]));
        i1 += 1;
      }
      return localArrayList;
    }
    paramArrayOfLong = new RuntimeException("convertIntArrayToLongList. array can not be null.");
    for (;;)
    {
      throw paramArrayOfLong;
    }
  }
  
  public static void b(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).updateItemUsed(paramAppInterface, paramString1, paramString2, paramString3, paramInt);
  }
  
  public static void b(String paramString)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString.split(" ");
      if (localObject != null)
      {
        i1 = localObject.length;
        break label27;
      }
    }
    int i1 = 0;
    label27:
    if (i1 > 1)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("discuss -searchKey:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" count:");
        ((StringBuilder)localObject).append(i1);
        QLog.d("searchUtils", 2, ((StringBuilder)localObject).toString());
      }
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(i1);
      ReportController.b(null, "CliOper", "", "", "0X8005E0F", "0X8005E0F", 0, 0, paramString.toString(), "", "", "");
    }
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 10) || (paramInt == 21) || (paramInt == 22);
  }
  
  public static boolean b(long paramLong)
  {
    return ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).isValidGroupMask(paramLong);
  }
  
  public static boolean b(AppInterface paramAppInterface, String paramString)
  {
    return ((IFriendDataService)paramAppInterface.getRuntimeService(IFriendDataService.class, "")).isFriend(paramString);
  }
  
  public static boolean b(ISearchResultModel paramISearchResultModel)
  {
    return ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).isGuildModel(paramISearchResultModel);
  }
  
  public static int[] b(String paramString1, String paramString2, boolean paramBoolean)
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
        if ((paramString2.equals(((ChnToSpell.ChnSpelling)localObject).b) ^ true))
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
  
  public static long[] b(List<Long> paramList)
  {
    if (paramList != null)
    {
      long[] arrayOfLong = new long[paramList.size()];
      int i1 = 0;
      while (i1 < paramList.size())
      {
        arrayOfLong[i1] = ((Long)paramList.get(i1)).longValue();
        i1 += 1;
      }
      return arrayOfLong;
    }
    paramList = new RuntimeException("convertLongList2longArray. list can not be null.");
    for (;;)
    {
      throw paramList;
    }
  }
  
  public static int c(String paramString1, String paramString2)
  {
    paramString1 = paramString1.split("#");
    SpellTool.a();
    paramString2 = paramString2.split("#");
    SpellTool.a();
    int i2 = paramString1.length;
    int i3 = paramString2.length;
    int i1 = 0;
    if (i2 == i3)
    {
      float f3 = 14.0F / (paramString1.length * 2);
      i1 = 0;
      float f1;
      for (float f2 = 0.0F; i1 < paramString1.length; f2 = f1)
      {
        f1 = f2;
        if (!paramString1[i1].equalsIgnoreCase(paramString2[i1]))
        {
          String[] arrayOfString1 = paramString1[i1].split("-");
          String[] arrayOfString2 = paramString2[i1].split("-");
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
        i1 += 1;
      }
      i1 = (int)f2;
    }
    return i1;
  }
  
  public static CharSequence c(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    Object localObject2 = paramString1.toLowerCase();
    Object localObject1 = paramString2.toLowerCase();
    int i3 = ((String)localObject2).indexOf((String)localObject1);
    int i1 = ((String)localObject1).length();
    int i2 = i3;
    if (i3 < 0)
    {
      if (paramBoolean)
      {
        int[] arrayOfInt = a((String)localObject2, (String)localObject1, 1);
        if (arrayOfInt[0] >= 0) {
          i1 = arrayOfInt[0];
        }
        for (i2 = arrayOfInt[1];; i2 = localObject1[1])
        {
          i3 = i2;
          i2 = i1;
          i1 = i3;
          break label135;
          localObject1 = a((String)localObject2, (String)localObject1, 2);
          if (localObject1[0] < 0) {
            break;
          }
          i1 = localObject1[0];
        }
        return new SpannableStringBuilder(paramString1);
      }
      return new SpannableStringBuilder(paramString1);
    }
    label135:
    if ((i2 <= paramInt) && ((i2 <= 6) || (i2 + i1 <= paramInt)))
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
      paramInt = i2 + 1;
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("(…");
      paramInt = i2 - 6;
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
    ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(MobileQQ.sMobileQQ.getResources().getColor(2131168119)), 0, ((String)localObject1).length(), 17);
    while (paramInt >= 0)
    {
      localObject1 = new ForegroundColorSpan(a());
      i1 += paramInt;
      ((SpannableStringBuilder)localObject2).setSpan(localObject1, paramInt, i1, 17);
      paramInt = paramString1.indexOf(paramString2, i1);
      i1 = paramString2.length();
    }
    return localObject2;
  }
  
  private static String c(long[] paramArrayOfLong)
  {
    return a(paramArrayOfLong, ":");
  }
  
  public static void c()
  {
    int i1 = SearchStatisticsConstants.a(70);
    int i2 = 1;
    if (i1 != 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (SearchStatisticsConstants.a(80) == 0) {
      i2 = 0;
    }
    if ((i1 != 0) && (i2 != 0)) {
      i1 = 90;
    } else if (i1 != 0) {
      i1 = 70;
    } else if (i2 != 0) {
      i1 = 80;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      ReportController.b(null, "CliOper", "", "", "0X8005ECF", "0X8005ECF", i1, 0, "", "", "", "");
    }
  }
  
  public static boolean c(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2)) {
      return paramInt == 3;
    }
    return true;
  }
  
  public static boolean c(AppInterface paramAppInterface, String paramString)
  {
    return ((IAddFriendServiceApi)paramAppInterface.getRuntimeService(IAddFriendServiceApi.class, "")).hasSendAddFriendReq(paramString, false);
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (!paramString.startsWith(f())) {
      return false;
    }
    paramString = URLUtil.a(paramString);
    return (paramString != null) && (paramString.containsKey(d())) && (!TextUtils.isEmpty((String)paramString.get(d())));
  }
  
  public static Friends d(AppInterface paramAppInterface, String paramString)
  {
    return ((IFriendDataService)paramAppInterface.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString, true);
  }
  
  public static String d()
  {
    String str2 = HuichuanConfigManager.a().c();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "q";
    }
    return str1;
  }
  
  public static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (!paramString.startsWith(f())) {
      return "";
    }
    paramString = URLUtil.a(paramString);
    if ((paramString != null) && (paramString.containsKey(d())))
    {
      paramString = (String)paramString.get(d());
      if (!TextUtils.isEmpty(paramString)) {
        return paramString;
      }
    }
    return "";
  }
  
  public static boolean d(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2)) {
      return paramInt == 21;
    }
    return true;
  }
  
  public static String e(AppInterface paramAppInterface, String paramString)
  {
    return ((ITroopInfoService)paramAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopUin(paramString);
  }
  
  public static String e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    String str2 = d();
    Map localMap = URLUtil.b(paramString);
    String str1 = paramString;
    if (localMap != null)
    {
      str1 = paramString;
      if (!TextUtils.isEmpty((CharSequence)localMap.get(str2)))
      {
        str1 = (String)localMap.get(str2);
        str1 = URLUtil.a(URLUtil.a(paramString, str2), str2, str1);
      }
    }
    return str1;
  }
  
  public static void e()
  {
    k.clear();
    l.clear();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchUtils", 2, "clearCache");
    }
  }
  
  private static String f()
  {
    String str2 = HuichuanConfigManager.a().b();
    if (TextUtils.isEmpty(str2)) {
      return "https://so.html5.qq.com/page/real/kd_result";
    }
    int i1 = str2.indexOf('?');
    String str1 = str2;
    if (i1 > 0) {
      str1 = str2.substring(0, i1);
    }
    return str1;
  }
  
  public static String f(AppInterface paramAppInterface, String paramString)
  {
    return ((ITroopInfoService)paramAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopCodeByTroopUin(paramString);
  }
  
  public static boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return i(paramString).endsWith("qq.com");
  }
  
  public static TroopInfo g(AppInterface paramAppInterface, String paramString)
  {
    return ((ITroopInfoService)paramAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(paramString);
  }
  
  public static boolean g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.trim();
    return Pattern.compile("^#[0-9a-fA-F]{3}|^#[0-9a-fA-F]{6}$|^#[0-9a-fA-F]{8}$").matcher(paramString).matches();
  }
  
  public static int h(AppInterface paramAppInterface, String paramString)
  {
    return ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getTroopMask(paramAppInterface, paramString);
  }
  
  public static String h(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return paramString;
  }
  
  @NonNull
  private static String i(String paramString)
  {
    try
    {
      paramString = new URL(paramString).getHost();
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramString = "";
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchUtils
 * JD-Core Version:    0.7.0.1
 */