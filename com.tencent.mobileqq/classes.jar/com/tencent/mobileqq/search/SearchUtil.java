package com.tencent.mobileqq.search;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.filemanager.data.search.FileManagerSearchEngine;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.base.util.SearchViewUtils;
import com.tencent.mobileqq.search.business.contact.ApproximateSearchEngine;
import com.tencent.mobileqq.search.business.contact.ContactSearchEngine;
import com.tencent.mobileqq.search.business.contact.CreateDiscussionSearchEngine;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussion;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelNewTroop;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelNewTroopMember;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelRecentUser;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.business.contact.model.GroupSearchModelLocalContactApproximate;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFavorite;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFileEntity;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFooter;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFunction;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMessage;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMiniProgram;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMostUsed;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMultiChat;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelPublicAcnt;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.ftsmsg.FTSGroupSearchModelMessage;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModel;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalTroop;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.searchengine.MessageSearchEngine;
import com.tencent.mobileqq.search.searchengine.MiniProgramSearchEngine;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import com.tencent.mobileqq.search.util.ReportUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchUtils.GenerateGifWithTextCallback;
import com.tencent.mobileqq.search.util.SearchUtils.ObjectItemInfo;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.globalsearch.FavoriteSearchEngine;
import cooperation.qqfav.globalsearch.FunctionSearchEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.search.model.ISearchResultGroupModel;>;
import java.util.concurrent.atomic.AtomicInteger;

public class SearchUtil
{
  public static boolean a = false;
  public static boolean b = false;
  protected static final HashMap<String, Integer> c = new HashMap();
  private static AtomicInteger d = new AtomicInteger(1);
  
  public static int a()
  {
    return d.getAndIncrement();
  }
  
  public static int a(IModel paramIModel)
  {
    if (paramIModel == null) {
      return -1;
    }
    if (c.size() == 0)
    {
      c.put(GroupSearchModelLocalContact.class.getSimpleName(), Integer.valueOf(101));
      c.put(GroupSearchModelLocalTroop.class.getSimpleName(), Integer.valueOf(101));
      c.put(GroupSearchModelLocalContactApproximate.class.getSimpleName(), Integer.valueOf(101));
      c.put(FTSGroupSearchModelMessage.class.getSimpleName(), Integer.valueOf(102));
      c.put(GroupSearchModelMessage.class.getSimpleName(), Integer.valueOf(102));
      c.put(GroupSearchModelFavorite.class.getSimpleName(), Integer.valueOf(103));
      c.put(GroupSearchModelFileEntity.class.getSimpleName(), Integer.valueOf(104));
      c.put(GroupSearchModelFunction.class.getSimpleName(), Integer.valueOf(105));
      c.put(SearchResultModelForEntrance.class.getSimpleName(), Integer.valueOf(106));
      c.put(GroupSearchModelPublicAcnt.class.getSimpleName(), Integer.valueOf(107));
      c.put(GroupSearchModelMiniProgram.class.getSimpleName(), Integer.valueOf(108));
      c.put(GroupSearchModelMostUsed.class.getSimpleName(), Integer.valueOf(109));
    }
    Integer localInteger = (Integer)c.get(paramIModel.getClass().getSimpleName());
    if (localInteger == null) {
      return -1;
    }
    if ((paramIModel instanceof SearchResultModelForEntrance))
    {
      if (((SearchResultModelForEntrance)paramIModel).c == -1) {
        return localInteger.intValue();
      }
      return -1;
    }
    return localInteger.intValue();
  }
  
  public static String a(ISearchEngine paramISearchEngine)
  {
    if (paramISearchEngine == null) {
      return "null";
    }
    if ((paramISearchEngine instanceof ContactSearchEngine)) {
      return "ContactSearchEngine";
    }
    if ((paramISearchEngine instanceof ApproximateSearchEngine)) {
      return "ApproximateSearchEngine";
    }
    if ((paramISearchEngine instanceof FavoriteSearchEngine)) {
      return "FavoriteSearchEngine";
    }
    if ((paramISearchEngine instanceof FileManagerSearchEngine)) {
      return "FileManagerSearchEngine";
    }
    if ((paramISearchEngine instanceof MiniProgramSearchEngine)) {
      return "MiniProgramSearchEngine";
    }
    if ((paramISearchEngine instanceof FunctionSearchEngine)) {
      return "FunctionSearchEngine";
    }
    if ((paramISearchEngine instanceof CreateDiscussionSearchEngine)) {
      return "CreateDiscussionSearchEngine";
    }
    if ((paramISearchEngine instanceof FTSMessageSearchEngine)) {
      return "FTSMessageSearchEngine";
    }
    if ((paramISearchEngine instanceof PublicAccountSearchEngine)) {
      return "PublicAccountSearchEngine";
    }
    if ((paramISearchEngine instanceof NetSearchEngine)) {
      return "NetSearchEngine";
    }
    if ((paramISearchEngine instanceof MessageSearchEngine)) {
      return "MessageSearchEngine";
    }
    return paramISearchEngine.getClass().getName();
  }
  
  public static List<IModel> a(List<ISearchResultGroupModel> paramList, boolean paramBoolean)
  {
    return a(paramList, paramBoolean, false, true);
  }
  
  public static List<IModel> a(List<ISearchResultGroupModel> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public static List<IModel> a(List<ISearchResultGroupModel> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramList == null)
    {
      QLog.d("Q.uniteSearch.SearchUtil", 2, "getItemListFromGroupResult  result is null.");
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    Object localObject2 = new HashMap();
    Object localObject3 = paramList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = ((Iterator)localObject3).next();
      if ((localObject1 instanceof GroupBaseNetSearchModel))
      {
        localObject4 = (GroupBaseNetSearchModel)localObject1;
        localObject1 = (Integer)((HashMap)localObject2).get(Long.valueOf(((GroupBaseNetSearchModel)localObject4).a));
        if (localObject1 == null) {
          localObject1 = Integer.valueOf(1);
        } else {
          localObject1 = Integer.valueOf(((Integer)localObject1).intValue() + 1);
        }
        ((HashMap)localObject2).put(Long.valueOf(((GroupBaseNetSearchModel)localObject4).a), localObject1);
      }
    }
    ((HashMap)localObject2).size();
    Object localObject4 = new ArrayList();
    ((List)localObject4).addAll(((HashMap)localObject2).keySet());
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    localObject1 = new ArrayList();
    SearchUtils.k.clear();
    Iterator localIterator = paramList.iterator();
    localObject2 = "";
    paramList = (List<ISearchResultGroupModel>)localObject1;
    int i;
    while (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if ((localObject1 instanceof GroupBaseNetSearchModel))
      {
        GroupBaseNetSearchModel localGroupBaseNetSearchModel = (GroupBaseNetSearchModel)localObject1;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = localGroupBaseNetSearchModel.c();
        }
        localObject2 = paramList;
        boolean bool1;
        if (paramBoolean3) {
          if (paramBoolean1)
          {
            if (SearchUtils.a(localGroupBaseNetSearchModel.a))
            {
              localArrayList2.add(Long.valueOf(localGroupBaseNetSearchModel.a));
              localObject2 = paramList;
              if (localGroupBaseNetSearchModel.b() != null)
              {
                i = 0;
                for (;;)
                {
                  localObject2 = paramList;
                  if (i >= localGroupBaseNetSearchModel.b().size()) {
                    break;
                  }
                  localObject3 = (ISearchResultModel)localGroupBaseNetSearchModel.b().get(i);
                  localObject5 = new SearchUtils.ObjectItemInfo();
                  ((SearchUtils.ObjectItemInfo)localObject5).a = ((String)localObject1);
                  paramBoolean2 = localObject3 instanceof NetSearchTemplateBaseItem;
                  if (paramBoolean2) {
                    ((SearchUtils.ObjectItemInfo)localObject5).b = ((NetSearchTemplateBaseItem)localObject3).i;
                  } else if ((localObject3 instanceof GroupBaseNetSearchModelItem)) {
                    ((SearchUtils.ObjectItemInfo)localObject5).b = ((GroupBaseNetSearchModelItem)localObject3).j();
                  } else {
                    ((SearchUtils.ObjectItemInfo)localObject5).b = localGroupBaseNetSearchModel.a;
                  }
                  i += 1;
                  ((SearchUtils.ObjectItemInfo)localObject5).c = i;
                  ((SearchUtils.ObjectItemInfo)localObject5).d = false;
                  bool1 = localObject3 instanceof GroupBaseNetSearchModelItem;
                  if (bool1) {
                    localObject2 = ((GroupBaseNetSearchModelItem)localObject3).b;
                  } else if (paramBoolean2) {
                    localObject2 = ((NetSearchTemplateBaseItem)localObject3).h;
                  } else {
                    localObject2 = "";
                  }
                  ((SearchUtils.ObjectItemInfo)localObject5).e = ((String)localObject2);
                  ((SearchUtils.ObjectItemInfo)localObject5).f = a;
                  SearchUtils.k.put(localObject3, localObject5);
                  if (bool1) {
                    ((GroupBaseNetSearchModelItem)localObject3).N = localGroupBaseNetSearchModel.o;
                  }
                }
              }
            }
            else
            {
              b = a;
              localArrayList3.add(Long.valueOf(localGroupBaseNetSearchModel.a));
              break label603;
            }
          }
          else
          {
            long l = localGroupBaseNetSearchModel.a;
            paramList.add(Long.valueOf(l));
            break label603;
          }
        }
        paramList = (List<ISearchResultGroupModel>)localObject2;
        label603:
        Object localObject5 = localGroupBaseNetSearchModel.b();
        localObject2 = paramList;
        localObject3 = localObject1;
        if (((List)localObject5).size() > 0)
        {
          int j = a();
          paramBoolean2 = TextUtils.isEmpty(localGroupBaseNetSearchModel.g());
          bool1 = localGroupBaseNetSearchModel.n;
          boolean bool2 = TextUtils.isEmpty(localGroupBaseNetSearchModel.j);
          localGroupBaseNetSearchModel.d(j);
          localObject2 = new GroupSearchModeTitle(localGroupBaseNetSearchModel, paramBoolean2 ^ true, bool1);
          ((GroupSearchModeTitle)localObject2).a(localGroupBaseNetSearchModel.m ^ true);
          ((GroupSearchModeTitle)localObject2).d(j);
          localArrayList1.add(localObject2);
          int k = ((List)localObject5).size();
          i = 0;
          while (i < k)
          {
            localObject2 = (ISearchResultModel)((List)localObject5).get(i);
            ((ISearchResultModel)localObject2).d(j);
            if ((localObject2 instanceof GroupBaseNetSearchModelItem))
            {
              localObject2 = (GroupBaseNetSearchModelItem)localObject2;
              SearchViewUtils.a((ISearchResultModel)localObject2, k, i);
              localArrayList1.add(localObject2);
            }
            else if ((localObject2 instanceof NetSearchTemplateBaseItem))
            {
              localObject2 = (NetSearchTemplateBaseItem)localObject2;
              SearchViewUtils.a((ISearchResultModel)localObject2, k, i);
              localArrayList1.add(localObject2);
            }
            else if ((localObject2 instanceof SearchResultModelForEntrance))
            {
              localArrayList1.add((SearchResultModelForEntrance)localObject2);
            }
            else if ((localObject2 instanceof ISearchResultModel))
            {
              localArrayList1.add(localObject2);
            }
            i += 1;
          }
          localObject2 = paramList;
          localObject3 = localObject1;
          if (!TextUtils.isEmpty(localGroupBaseNetSearchModel.j))
          {
            localObject2 = new GroupSearchModelFooter(localGroupBaseNetSearchModel.j, localGroupBaseNetSearchModel.k, localGroupBaseNetSearchModel.a);
            ((GroupSearchModelFooter)localObject2).a(bool2 ^ true);
            ((GroupSearchModelFooter)localObject2).d(j);
            localArrayList1.add(localObject2);
            localObject2 = paramList;
            localObject3 = localObject1;
          }
        }
      }
      else
      {
        localObject3 = localObject2;
        localObject2 = paramList;
      }
      paramList = (List<ISearchResultGroupModel>)localObject2;
      localObject2 = localObject3;
    }
    if (localArrayList3.size() > 0)
    {
      if (b) {
        i = 2;
      } else {
        i = 1;
      }
      SearchUtils.a("all_result", "exp_content", i, 0, new String[] { localObject2, SearchUtils.a(localArrayList3), "", SearchUtils.a("dynamic_unite_search.1", (List)localObject4) });
    }
    if (paramList.size() > 0) {
      SearchUtils.a("all_result", "load_content", new String[] { localObject2, SearchUtils.a(paramList), "", SearchUtils.a("dynamic_unite_search.1", (List)localObject4) });
    }
    a = false;
    return localArrayList1;
  }
  
  public static List<Long> a(long[] paramArrayOfLong)
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
  
  public static void a(int paramInt1, int paramInt2, GroupSearchModeTitle paramGroupSearchModeTitle)
  {
    if (paramGroupSearchModeTitle != null)
    {
      if (paramGroupSearchModeTitle.a() == null) {
        return;
      }
      if (!paramGroupSearchModeTitle.f()) {
        return;
      }
      if (paramGroupSearchModeTitle.a().equals(GroupSearchModelMessage.a)) {
        UniteSearchReportController.a(null, 0, paramInt2, "0X8009D4E", 0, 0, null, null);
      }
      if (paramGroupSearchModeTitle.a().equals(GroupSearchModelLocalContact.b)) {
        UniteSearchReportController.a(null, 0, paramInt2, "0X8009D38", 0, 0, null, null);
      }
      if (paramGroupSearchModeTitle.a().equals(GroupSearchModelLocalTroop.b)) {
        UniteSearchReportController.a(null, 0, paramInt2, "0X8009D3C", 0, 0, null, null);
      }
      if (paramGroupSearchModeTitle.a().equals(HardCodeUtil.a(2131913140))) {
        UniteSearchReportController.a(null, 0, paramInt2, "0X8009D52", 0, 0, null, null);
      }
    }
  }
  
  public static void a(Intent paramIntent, ForwardBaseOption paramForwardBaseOption)
  {
    if ((paramIntent != null) && (paramForwardBaseOption != null))
    {
      Object localObject2 = paramIntent.getStringExtra("contactSearchResultUin");
      String str1 = paramIntent.getStringExtra("contactSearchResultTroopUin");
      boolean bool2 = false;
      int k = paramIntent.getIntExtra("contactSearchResultUinType", 0);
      String str2 = paramIntent.getStringExtra("contactSearchResultName");
      int i = ForwardAbility.ForwardAbilityType.b.intValue();
      int m = paramIntent.getIntExtra("chooseFriendFrom", 0);
      boolean bool1;
      if (k != 56938) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Object localObject1 = localObject2;
      int j = k;
      if ((paramForwardBaseOption instanceof ForwardShareCardOption))
      {
        localObject1 = localObject2;
        j = k;
        if (paramIntent.hasExtra("contactSearchResultPhoneContactMobileCode"))
        {
          localObject1 = localObject2;
          j = k;
          if (k != 1006)
          {
            localObject1 = paramIntent.getStringExtra("contactSearchResultPhoneContactMobileCode");
            j = 1006;
          }
        }
      }
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 1004)
          {
            if (j != 1006)
            {
              if (j != 3000)
              {
                if (j == 56938) {
                  i = ForwardAbility.ForwardAbilityType.i.intValue();
                }
              }
              else {
                i = ForwardAbility.ForwardAbilityType.e.intValue();
              }
            }
            else {
              i = ForwardAbility.ForwardAbilityType.i.intValue();
            }
          }
          else {
            i = ForwardAbility.ForwardAbilityType.j.intValue();
          }
        }
        else {
          i = ForwardAbility.ForwardAbilityType.d.intValue();
        }
      }
      else {
        i = ForwardAbility.ForwardAbilityType.c.intValue();
      }
      if (!StringUtil.isEmpty((String)localObject1))
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("uin", (String)localObject1);
        ((Bundle)localObject2).putInt("uintype", j);
        ((Bundle)localObject2).putString("uinname", str2);
        ((Bundle)localObject2).putString("troop_uin", str1);
        ((Bundle)localObject2).putInt("chooseFriendFrom", m);
        ((Bundle)localObject2).putBoolean("bindContact", bool1);
        bool1 = bool2;
        if (paramIntent != null) {
          bool1 = paramIntent.getBooleanExtra("choose_friend_needConfirm", false);
        }
        if (bool1)
        {
          localObject1 = paramIntent.getStringExtra("choose_friend_confirmTitle");
          paramIntent = paramIntent.getStringExtra("choose_friend_confirmContent");
          ((Bundle)localObject2).putBoolean("choose_friend_needConfirm", bool1);
          ((Bundle)localObject2).putString("choose_friend_confirmTitle", (String)localObject1);
          ((Bundle)localObject2).putString("choose_friend_confirmContent", paramIntent);
        }
        paramForwardBaseOption.a(i, (Bundle)localObject2);
        paramForwardBaseOption.w();
      }
    }
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
  
  public static void a(TextView paramTextView)
  {
    float f = paramTextView.getResources().getDimensionPixelSize(2131299170) / paramTextView.getResources().getDisplayMetrics().densityDpi * FontSettingManager.systemMetrics.densityDpi;
    if (f > 0.0F) {
      paramTextView.setMaxWidth((int)f);
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, List<String> paramList, String paramString3, Rect paramRect, SearchUtils.GenerateGifWithTextCallback paramGenerateGifWithTextCallback)
  {
    ThreadManager.post(new SearchUtil.2(paramString1, paramString2, paramList, paramString3, paramRect, paramAppInterface, paramGenerateGifWithTextCallback), 8, null, true);
  }
  
  public static void a(IContactSearchModel paramIContactSearchModel, View paramView)
  {
    ThreadManager.postImmediately(new SearchUtil.1(paramView, paramIContactSearchModel), null, true);
  }
  
  public static void a(ISearchResultGroupModel paramISearchResultGroupModel, List<IModel> paramList)
  {
    int i = a();
    GroupSearchModeTitle localGroupSearchModeTitle = new GroupSearchModeTitle(paramISearchResultGroupModel);
    paramISearchResultGroupModel.d(i);
    localGroupSearchModeTitle.d(i);
    paramList.add(localGroupSearchModeTitle);
    paramList.add(paramISearchResultGroupModel);
  }
  
  public static void a(Object paramObject, String paramString, int paramInt)
  {
    if ((paramObject instanceof GroupSearchModeTitle)) {
      a(0, paramInt, (GroupSearchModeTitle)paramObject);
    }
    if ((paramObject instanceof GroupSearchModelMostUsed)) {
      UniteSearchReportController.a(null, 0, paramInt, "0X8009D30", 0, 0, null, null);
    }
    Object localObject;
    int j;
    int i;
    StringBuilder localStringBuilder;
    if ((paramObject instanceof GroupSearchModelLocalContact))
    {
      localObject = (GroupSearchModelLocalContact)paramObject;
      if (((GroupSearchModelLocalContact)localObject).b() != null)
      {
        j = ((GroupSearchModelLocalContact)localObject).b().size();
        i = j;
        if (j > ((GroupSearchModelLocalContact)localObject).d()) {
          i = ((GroupSearchModelLocalContact)localObject).d();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i);
        SearchUtils.a("all_result", "exp_contact", new String[] { localObject, localStringBuilder.toString() });
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramString);
        SearchUtils.a("all_result", "exp_contact", new String[] { ((StringBuilder)localObject).toString(), "0" });
      }
      UniteSearchReportController.a(null, 0, paramInt, "0X8009D36", 0, 0, null, null);
    }
    if ((paramObject instanceof GroupSearchModelLocalTroop)) {
      UniteSearchReportController.a(null, 0, paramInt, "0X8009D3A", 0, 0, null, null);
    }
    if ((paramObject instanceof FTSGroupSearchModelMessage))
    {
      localObject = (FTSGroupSearchModelMessage)paramObject;
      if (((FTSGroupSearchModelMessage)localObject).b() != null)
      {
        j = ((FTSGroupSearchModelMessage)localObject).b().size();
        i = j;
        if (j > ((FTSGroupSearchModelMessage)localObject).d()) {
          i = ((FTSGroupSearchModelMessage)localObject).d();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i);
        SearchUtils.a("all_result", "exp_talk", new String[] { localObject, localStringBuilder.toString() });
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramString);
        SearchUtils.a("all_result", "exp_talk", new String[] { ((StringBuilder)localObject).toString(), "0" });
      }
      UniteSearchReportController.a(null, 0, paramInt, "0X8009D4C", 0, 0, null, null);
    }
    if ((paramObject instanceof GroupSearchModelFavorite))
    {
      localObject = (GroupSearchModelFavorite)paramObject;
      if (((GroupSearchModelFavorite)localObject).b() != null)
      {
        j = ((GroupSearchModelFavorite)localObject).b().size();
        i = j;
        if (j > ((GroupSearchModelFavorite)localObject).d()) {
          i = ((GroupSearchModelFavorite)localObject).d();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i);
        SearchUtils.a("all_result", "exp_collect", new String[] { localObject, localStringBuilder.toString() });
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramString);
        SearchUtils.a("all_result", "exp_collect", new String[] { ((StringBuilder)localObject).toString(), "0" });
      }
      UniteSearchReportController.a(null, 0, paramInt, "0X8009D54", 0, 0, null, null);
    }
    if ((paramObject instanceof GroupSearchModelFileEntity))
    {
      localObject = (GroupSearchModelFileEntity)paramObject;
      if (((GroupSearchModelFileEntity)localObject).b() != null)
      {
        j = ((GroupSearchModelFileEntity)localObject).b().size();
        i = j;
        if (j > ((GroupSearchModelFileEntity)localObject).d()) {
          i = ((GroupSearchModelFileEntity)localObject).d();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i);
        SearchUtils.a("all_result", "exp_file", new String[] { localObject, localStringBuilder.toString() });
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramString);
        SearchUtils.a("all_result", "exp_file", new String[] { ((StringBuilder)localObject).toString(), "0" });
      }
      UniteSearchReportController.a(null, 0, paramInt, "0X8009D58", 0, 0, null, null);
    }
    if ((paramObject instanceof GroupSearchModelMultiChat))
    {
      localObject = (GroupSearchModelMultiChat)paramObject;
      if (((GroupSearchModelMultiChat)localObject).b() != null)
      {
        j = ((GroupSearchModelMultiChat)localObject).b().size();
        i = j;
        if (j > ((GroupSearchModelMultiChat)localObject).d()) {
          i = ((GroupSearchModelMultiChat)localObject).d();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramString);
        paramString = ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(i);
        SearchUtils.a("all_result", "exp_discuss", new String[] { paramString, ((StringBuilder)localObject).toString() });
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramString);
        SearchUtils.a("all_result", "exp_discuss", new String[] { ((StringBuilder)localObject).toString(), "0" });
      }
      UniteSearchReportController.a(null, 0, paramInt, "0X800BDC0", 0, 0, null, null);
    }
    if ((paramObject instanceof GroupSearchModelPublicAcnt))
    {
      paramObject = (GroupSearchModelPublicAcnt)paramObject;
      UniteSearchReportController.a(null, 0, paramInt, "0X8009D50", 0, 0, ReportUtil.a(paramObject.b(), paramObject.d()), null);
    }
  }
  
  public static boolean a(String paramString)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return (localAppInterface != null) && (!TextUtils.isEmpty(paramString)) && (((ITroopRobotService)localAppInterface.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(paramString));
  }
  
  public static long[] a(List<Long> paramList)
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
  
  public static void b()
  {
    d.set(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchUtil
 * JD-Core Version:    0.7.0.1
 */