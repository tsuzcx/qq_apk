package com.tencent.mobileqq.search.fragment;

import abvl;
import alud;
import alzl;
import amfc;
import amfe;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import ayht;
import ayhw;
import ayhx;
import ayif;
import ayig;
import ayjn;
import ayjq;
import aykr;
import ayks;
import aymr;
import ayms;
import aynb;
import aync;
import aynd;
import ayne;
import aynf;
import ayng;
import ayni;
import aynk;
import aynn;
import ayns;
import aynt;
import aynu;
import ayod;
import ayoi;
import ayoj;
import ayok;
import ayot;
import ayoy;
import aypa;
import aypd;
import aypk;
import aypl;
import aysc;
import ayug;
import ayuu;
import ayuv;
import ayve;
import ayvm;
import azqs;
import bdbb;
import bhtv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Layns;>;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupSearchFragment
  extends BaseSearchFragment
  implements ayhx, bhtv
{
  public static volatile String a;
  public volatile int a;
  public long a;
  public aypd a;
  public boolean a;
  byte[] a;
  public int b;
  public long b;
  public Handler b;
  public aypd b;
  public String b;
  int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  int e = 0;
  int f;
  public boolean f;
  public volatile int g;
  public boolean g;
  public volatile int h;
  public boolean h;
  private int i;
  public boolean i;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean = true;
  private volatile boolean k;
  
  public GroupSearchFragment()
  {
    this.jdField_i_of_type_Int = -1;
    this.jdField_a_of_type_Aypd = new aypd("", -1, 2130840180, true);
    this.jdField_b_of_type_AndroidOsHandler = new aykr(this, Looper.getMainLooper());
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 6: 
    default: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 5;
  }
  
  private int a(List<ayns> paramList)
  {
    int m = 0;
    if (paramList == null) {
      m = -1;
    }
    while (paramList.size() == 0) {
      return m;
    }
    int n = 0;
    Object localObject1 = null;
    Object localObject3;
    Object localObject2;
    if (n < paramList.size())
    {
      localObject3 = (ayns)paramList.get(n);
      if ((localObject3 instanceof aynb))
      {
        localObject2 = ((aynb)localObject3).a();
        if (localObject2 == null)
        {
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            break label576;
          }
          QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "getFuzzyPotision error, groupmodel is null:" + localObject3);
        }
      }
    }
    for (;;)
    {
      n += 1;
      break;
      localObject1 = ((aynt)localObject2).a();
      localObject2 = ((aynb)localObject3).a();
      if ((!alud.a(2131705772).equals(localObject2)) && (!alud.a(2131705769).equals(localObject2)) && (!alud.a(2131705754).equals(localObject2)) && (!aynk.jdField_a_of_type_JavaLangString.equals(localObject2)))
      {
        if (alud.a(2131705750).equals(localObject2))
        {
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (((List)localObject1).size() != 0) {}
          }
          else
          {
            localObject2 = localObject1;
            if (QLog.isColorLevel()) {
              QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "getFuzzyPotision error, only has title， miniprogram");
            }
          }
        }
        else
        {
          if (((aynb)localObject3).b) {
            continue;
          }
          localObject2 = ayhw.a();
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(((aynb)localObject3).a()))) {
            m = 1;
          }
          for (;;)
          {
            if (m != 0)
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                break label576;
              }
              if (((List)localObject1).size() == 0)
              {
                break;
                m = 0;
                continue;
              }
              if ((((List)localObject1).get(0) instanceof ayms))
              {
                localObject3 = (ayms)((List)localObject1).get(0);
                localObject2 = ((ayms)localObject3).jdField_c_of_type_JavaLangString;
                localObject3 = ((ayms)localObject3).a();
                if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(localObject3))) {
                  break label390;
                }
                m = 1;
              }
              for (;;)
              {
                if (m != 0)
                {
                  break;
                  label390:
                  m = 0;
                  continue;
                  if ((localObject3 instanceof aync))
                  {
                    localObject1 = null;
                    break;
                  }
                  if ((localObject3 instanceof aypd))
                  {
                    if (!((aypd)localObject3).b()) {
                      break label574;
                    }
                    localObject1 = null;
                    break;
                  }
                  if (((localObject3 instanceof aynk)) || ((localObject3 instanceof ayne)) || ((localObject3 instanceof ayni)) || ((localObject3 instanceof aynd)) || ((localObject3 instanceof aynf)) || ((localObject3 instanceof ayng)) || (((localObject3 instanceof ayot)) && (((ayot)localObject3).jdField_c_of_type_Boolean)) || ((localObject1 != null) && (((List)localObject1).contains(localObject3)))) {
                    break;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "getFuzzyPotision, break:" + localObject3);
                  }
                }
              }
            }
          }
          label574:
          return n;
        }
        label576:
        localObject1 = localObject2;
      }
    }
  }
  
  public static GroupSearchFragment a(int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", paramInt1);
    localBundle.putInt("source", paramInt2);
    GroupSearchFragment localGroupSearchFragment = new GroupSearchFragment();
    localGroupSearchFragment.setArguments(localBundle);
    return localGroupSearchFragment;
  }
  
  public static GroupSearchFragment a(int paramInt1, int paramInt2, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", paramInt1);
    localBundle.putInt("source", paramInt2);
    localBundle.putLong("searchEngineKey", paramLong);
    GroupSearchFragment localGroupSearchFragment = new GroupSearchFragment();
    localGroupSearchFragment.setArguments(localBundle);
    return localGroupSearchFragment;
  }
  
  private List<Long> a()
  {
    List localList = new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_i_of_type_Int).a(new ayuu(this.jdField_c_of_type_JavaLangString));
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList1 = ((alzl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a();
    ArrayList localArrayList2 = new ArrayList();
    if ((localArrayList1 == null) || (localArrayList1.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "all publicAccountInfoList is null or empty");
      }
    }
    for (;;)
    {
      return localArrayList2;
      int m = 0;
      while (m < localList.size())
      {
        ayoy localayoy = (ayoy)localList.get(m);
        int n = 0;
        while (n < localArrayList1.size())
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localArrayList1.get(n);
          if (TextUtils.equals(String.valueOf(localPublicAccountInfo.uin), String.valueOf(localayoy.a.uin))) {
            localArrayList2.add(Long.valueOf(localPublicAccountInfo.uin));
          }
          n += 1;
        }
        m += 1;
      }
    }
  }
  
  private void a(int paramInt, String paramString, List<ayns> paramList)
  {
    int m = 1;
    Object localObject1 = "";
    Object localObject2 = new HashMap();
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        if (paramList.size() > 0)
        {
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            Object localObject3 = (ayns)paramList.next();
            if (!(localObject3 instanceof aynb)) {
              continue;
            }
            localObject3 = ((aynb)localObject3).a();
            if (alud.a(2131705770).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(1), Integer.valueOf(1));
              continue;
            }
            if (alud.a(2131705757).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(2), Integer.valueOf(2));
              continue;
            }
            if (alud.a(2131705751).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(3), Integer.valueOf(3));
              continue;
            }
            if (alud.a(2131705749).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(4), Integer.valueOf(4));
              continue;
            }
            if (alud.a(2131705781).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(5), Integer.valueOf(5));
              continue;
            }
            if (alud.a(2131693819).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(6), Integer.valueOf(6));
              continue;
            }
            if (alud.a(2131705761).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(7), Integer.valueOf(7));
              continue;
            }
            if (alud.a(2131720579).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(8), Integer.valueOf(8));
              continue;
            }
            if (alud.a(2131705762).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(9), Integer.valueOf(9));
              continue;
            }
            if (alud.a(2131705766).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(10), Integer.valueOf(10));
              continue;
            }
            ((HashMap)localObject2).put(Integer.valueOf(11), Integer.valueOf(11));
            continue;
          }
        }
        paramList = (List<ayns>)localObject1;
        if (((HashMap)localObject2).size() > 0)
        {
          paramList = new StringBuilder();
          localObject1 = ((HashMap)localObject2).values().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Integer)((Iterator)localObject1).next();
            if (m == 0)
            {
              paramList.append("_");
              paramList.append(localObject2);
            }
          }
          else
          {
            paramList = paramList.toString();
          }
        }
        else
        {
          localObject1 = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject1 instanceof QQAppInterface))
          {
            localObject1 = (QQAppInterface)localObject1;
            azqs.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800973C", "0X800973C", paramInt, 0, "", "", paramString, paramList);
            return;
          }
          localObject1 = null;
          continue;
        }
        m = 0;
      }
      catch (Throwable paramString)
      {
        return;
      }
    }
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 6: 
    default: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 5;
  }
  
  private void e(List<ayns> paramList)
  {
    aypk.a(paramList, this.jdField_c_of_type_JavaLangString);
    f(paramList);
  }
  
  private void f(List<ayns> paramList)
  {
    int i1 = 0;
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      ArrayList localArrayList4 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      int m = 0;
      label91:
      int n;
      if (m < paramList.size())
      {
        ayns localayns1 = (ayns)paramList.get(m);
        ArrayList localArrayList1;
        if ((localayns1 instanceof aypa)) {
          if (((aypa)localayns1).c())
          {
            localArrayList1 = localArrayList2;
            if (m > 0)
            {
              ayns localayns2 = (ayns)paramList.get(m - 1);
              if ((localayns2 instanceof aynb))
              {
                localArrayList1.add(localayns2);
                localArrayList4.remove(localayns2);
              }
            }
            localArrayList1.add(localayns1);
            n = m;
            if (m + 1 > paramList.size())
            {
              localayns1 = (ayns)paramList.get(m + 1);
              n = m;
              if ((localayns1 instanceof aync)) {
                localArrayList1.add(localayns1);
              }
            }
          }
        }
        for (n = m + 1;; n = m)
        {
          m = n + 1;
          break;
          localArrayList1 = localArrayList3;
          break label91;
          if (((localayns1 instanceof aynn)) && (QLog.isColorLevel())) {
            QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "adjustRichNodePosition, error, GroupSearchModelRichNode.");
          }
          localArrayList4.add(localayns1);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "adjustRichNodePosition, total:" + paramList.size() + " exact:" + localArrayList2.size() + " fuzzy:" + localArrayList3.size() + " other:" + localArrayList4.size());
      }
      if ((localArrayList2.size() != 0) || (localArrayList3.size() != 0))
      {
        if (localArrayList3.size() == 0)
        {
          paramList.clear();
          paramList.addAll(localArrayList2);
          paramList.addAll(localArrayList4);
          return;
        }
        paramList.clear();
        paramList.addAll(localArrayList2);
        if (localArrayList4.size() == 0)
        {
          paramList.addAll(localArrayList3);
          return;
        }
        n = a(localArrayList4);
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "adjustRichNodePosition, fuzzy pos:" + n);
        }
        m = i1;
        if (n <= 0)
        {
          paramList.addAll(localArrayList3);
          paramList.addAll(localArrayList4);
          return;
        }
        while (m < n)
        {
          paramList.add(localArrayList4.get(m));
          m += 1;
        }
        paramList.addAll(localArrayList3);
        m = n;
        while (m < localArrayList4.size())
        {
          paramList.add(localArrayList4.get(m));
          m += 1;
        }
      }
    }
  }
  
  protected int a()
  {
    return 0;
  }
  
  protected ayjn a()
  {
    return new ayjq(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Bdbb, this, this.jdField_i_of_type_Int);
  }
  
  protected ayug a()
  {
    if (this.jdField_a_of_type_Ayug != null) {
      return this.jdField_a_of_type_Ayug;
    }
    if (this.jdField_c_of_type_Long > 0L)
    {
      Object localObject = ayve.a().a(this.jdField_c_of_type_Long);
      if ((localObject != null) && ((localObject instanceof GroupSearchEngine)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("GroupSearchFragment", 2, " use VADActivity cache engine...");
        }
        this.jdField_d_of_type_Boolean = true;
        return (GroupSearchEngine)localObject;
      }
    }
    return new GroupSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_i_of_type_Int);
  }
  
  public ArrayList a(List paramList)
  {
    if (paramList == null) {
      return null;
    }
    if (paramList.size() == 0) {
      return new ArrayList(paramList);
    }
    ArrayList localArrayList = ((aypl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(318)).a(jdField_a_of_type_JavaLangString);
    return aypk.a(jdField_a_of_type_JavaLangString, localArrayList, paramList);
  }
  
  public void a(String paramString)
  {
    QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "GroupSearchFragment log for search  startSearch   isLocalSearch");
    VADHelper.a("voice_search_als_cost");
    a(paramString, 1);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search onResultError, keyword = " + paramString1);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    c();
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = true;
    if ((this.jdField_c_of_type_JavaUtilList.size() != 1) || (!(this.jdField_c_of_type_JavaUtilList.get(0) instanceof aypd)) || (!((aypd)this.jdField_c_of_type_JavaUtilList.get(0)).b()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new ayks(this));
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, List<ayns> paramList)
  {
    QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search onResultSuc, keyword = " + paramString + ", isFirstReq = " + paramBoolean1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "onResultSuc, keyword = " + paramString + ", isFirstReq = " + paramBoolean1 + ", cookie = " + paramArrayOfByte + ", isEnd = " + paramBoolean2 + ", netResultItemList = " + paramList);
    }
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    int n;
    int m;
    int i1;
    if (paramBoolean1)
    {
      n = 0;
      m = 0;
      while (m < ((List)localObject).size())
      {
        i1 = n;
        if (!(((List)localObject).get(m) instanceof aynb)) {
          i1 = n + 1;
        }
        m += 1;
        n = i1;
      }
      paramList = new JSONObject();
    }
    try
    {
      paramList.put("project", aysc.a());
      paramList.put("event_src", "client");
      paramList.put("web_num", n);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      aysc.a(localQQAppInterface, new ReportModelDC02528().module("all_result").action("exp_items").ver1(paramString).ver2(aysc.a(this.jdField_i_of_type_Int)).ver7(paramList.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + ayif.jdField_a_of_type_Long));
      if (!paramBoolean1) {
        break label523;
      }
      m = 0;
      n = 0;
      i1 = 0;
      while (i1 < ((List)localObject).size())
      {
        int i3 = n;
        int i2 = m;
        if ((((List)localObject).get(i1) instanceof ayms))
        {
          if (((ayms)((List)localObject).get(i1)).d() == 1001) {
            m = 1;
          }
          i3 = n;
          i2 = m;
          if (((ayms)((List)localObject).get(i1)).d() == 1001)
          {
            i3 = 1;
            i2 = m;
          }
        }
        i1 += 1;
        n = i3;
        m = i2;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "e = " + localJSONException);
      }
      i1 = 0;
      if (m == 0) {
        break label632;
      }
    }
    if (n != 0)
    {
      m = 90;
      if (m != 0) {
        azqs.b(null, "CliOper", "", "", "0X8005ECF", "0X8005ECF", m, 0, "", "", "", "");
      }
      label523:
      this.jdField_h_of_type_Boolean = false;
      a(paramArrayOfByte);
      this.jdField_i_of_type_Boolean = paramBoolean2;
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramArrayOfByte = ((List)localObject).iterator();
      m = 0;
      label568:
      if (!paramArrayOfByte.hasNext()) {
        break label669;
      }
      paramList = (ayns)paramArrayOfByte.next();
      if (!(paramList instanceof aynt)) {
        break label660;
      }
      if (((aynt)paramList).a() == null) {
        break label1077;
      }
      m = ((aynt)paramList).a().size() + m;
    }
    label660:
    label669:
    label944:
    label1077:
    for (;;)
    {
      break label568;
      label632:
      if (m != 0)
      {
        m = 70;
        break;
      }
      m = i1;
      if (n == 0) {
        break;
      }
      m = 80;
      break;
      m += 1;
      continue;
      if (paramBoolean1)
      {
        if (m > 0) {
          ayvm.a("all_result", "exp_net_result", new String[] { "" + paramString });
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "handleTabSearchResult isFirstReq==" + paramBoolean1 + " newSearchDataCount:" + this.e + "   newSearchIndex:" + this.jdField_c_of_type_Int + " result.size():" + m);
        }
        if (this.jdField_i_of_type_Boolean) {
          break label1071;
        }
        this.e += m;
        this.jdField_c_of_type_Int += 1;
        m = 10;
        if (UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int)) {
          m = 20;
        }
        if (this.e <= m) {
          break label944;
        }
        this.jdField_c_of_type_Int = 0;
        this.e = 0;
        this.jdField_c_of_type_Boolean = paramBoolean1;
        m = 0;
      }
      for (;;)
      {
        label859:
        if (m != 0)
        {
          if (this.jdField_d_of_type_JavaUtilList == null)
          {
            this.jdField_c_of_type_Boolean = paramBoolean1;
            this.jdField_d_of_type_JavaUtilList = ((List)localObject);
          }
          for (;;)
          {
            this.jdField_b_of_type_Int += 1;
            a(this.jdField_i_of_type_Int, paramString, this.jdField_c_of_type_JavaUtilList);
            return;
            ayvm.a("all_result", "noresult_net", new String[] { "" + paramString });
            break;
            if (this.jdField_c_of_type_Int >= 3)
            {
              if (QLog.isColorLevel()) {
                QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "handleTabSearchResult 触发限频逻辑");
              }
              this.jdField_i_of_type_Boolean = true;
              m = 0;
              break label859;
            }
            m = 1;
            h();
            break label859;
            this.jdField_d_of_type_JavaUtilList.addAll((Collection)localObject);
          }
        }
        g_(true);
        if ((this.jdField_d_of_type_JavaUtilList != null) && (this.jdField_d_of_type_JavaUtilList.size() > 0)) {
          ((List)localObject).addAll(0, this.jdField_d_of_type_JavaUtilList);
        }
        for (;;)
        {
          a((List)localObject, this.jdField_c_of_type_Boolean);
          this.jdField_d_of_type_JavaUtilList = null;
          this.jdField_c_of_type_Boolean = false;
          break;
          this.jdField_c_of_type_Boolean = paramBoolean1;
        }
        m = 0;
      }
    }
  }
  
  public void a(List paramList)
  {
    if (isDetached()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "onUpdate, resultList = " + paramList);
    }
    paramList = a(paramList);
    paramList = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(13, paramList);
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramList);
  }
  
  public void a(List paramList, int paramInt)
  {
    if (isDetached()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "onFinish, resultList = " + paramList + ", status = " + paramInt);
    }
    if ((paramInt == 4) || (paramInt == 5)) {}
    for (paramList = a(paramList);; paramList = new ArrayList(paramList))
    {
      paramList = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(14, paramList);
      paramList.arg1 = paramInt;
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramList);
      return;
    }
  }
  
  public void a(List paramList, ayuv paramayuv)
  {
    if (paramayuv.a(this.jdField_c_of_type_JavaLangString)) {
      a(paramList, paramayuv.jdField_a_of_type_Int);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.uniteSearch.GroupSearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramayuv.jdField_a_of_type_JavaLangString, " keyword2:", this.jdField_c_of_type_JavaLangString });
  }
  
  public void a(List<ayns> paramList, boolean paramBoolean)
  {
    c();
    if (paramList.size() > 0)
    {
      m = ayif.b.size();
      int i1 = 0;
      long l1 = -1L;
      if (i1 < paramList.size())
      {
        ayns localayns = (ayns)paramList.get(i1);
        Object localObject2;
        Object localObject3;
        long l2;
        Object localObject1;
        if ((localayns instanceof aymr))
        {
          localObject2 = (aymr)localayns;
          int n = m;
          if (((aymr)localObject2).a() != null)
          {
            n = m;
            if (((aymr)localObject2).a().size() > 0)
            {
              n = 0;
              if (n < ((aymr)localObject2).a().size())
              {
                localObject3 = (ayns)((aymr)localObject2).a().get(i1);
                l2 = 0L;
                localObject1 = "";
                if ((localObject3 instanceof ayod))
                {
                  l2 = ((ayod)localObject3).jdField_a_of_type_Long;
                  localObject1 = ((ayod)localObject3).d;
                }
                for (;;)
                {
                  ayig localayig = new ayig();
                  m += 1;
                  localayig.jdField_a_of_type_Int = m;
                  localayig.jdField_a_of_type_Long = l2;
                  localayig.jdField_b_of_type_JavaLangString = ((String)localObject1);
                  localayig.jdField_a_of_type_JavaLangString = ((aymr)localayns).b();
                  ayif.b.put((aynu)localObject3, localayig);
                  n += 1;
                  break;
                  if ((localObject3 instanceof ayms))
                  {
                    l2 = ((ayms)localObject3).d();
                    localObject1 = ((ayms)localObject3).jdField_b_of_type_JavaLangString;
                  }
                }
              }
              n = m;
            }
          }
          l2 = l1;
          if (l1 == -1L) {
            l2 = ((aymr)localObject2).jdField_a_of_type_Long;
          }
          m = n;
          l1 = l2;
        }
        for (;;)
        {
          i1 += 1;
          break;
          if ((localayns instanceof ayok))
          {
            m += 1;
            localObject1 = ((ayok)localayns).a;
            if (localObject1 != null)
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (ayoj)((Iterator)localObject1).next();
                localObject3 = new ayig();
                ((ayig)localObject3).jdField_a_of_type_Int = m;
                ((ayig)localObject3).jdField_a_of_type_JavaLangString = ((ayod)localayns).a();
                ayif.b.put(localObject2, localObject3);
              }
            }
          }
          else if ((localayns instanceof ayoi))
          {
            m += 1;
            localObject1 = ((ayoi)localayns).a;
            if (localObject1 != null)
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (ayoj)((Iterator)localObject1).next();
                localObject3 = new ayig();
                ((ayig)localObject3).jdField_a_of_type_Int = m;
                ((ayig)localObject3).jdField_a_of_type_JavaLangString = ((ayod)localayns).a();
                ayif.b.put(localObject2, localObject3);
              }
            }
          }
          else if ((localayns instanceof ayod))
          {
            localObject1 = new ayig();
            m += 1;
            ((ayig)localObject1).jdField_a_of_type_Int = m;
            ((ayig)localObject1).jdField_a_of_type_Long = ((ayod)localayns).jdField_a_of_type_Long;
            ((ayig)localObject1).jdField_b_of_type_JavaLangString = ((ayod)localayns).d;
            ((ayig)localObject1).jdField_a_of_type_JavaLangString = ((ayod)localayns).a();
            ayif.b.put((aynu)localayns, localObject1);
          }
          else if ((localayns instanceof ayms))
          {
            l2 = ((ayms)localayns).d();
            localObject1 = ((ayms)localayns).jdField_b_of_type_JavaLangString;
            localObject2 = new ayig();
            m += 1;
            ((ayig)localObject2).jdField_a_of_type_Int = m;
            ((ayig)localObject2).jdField_a_of_type_Long = l2;
            ((ayig)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1);
            ((ayig)localObject2).jdField_a_of_type_JavaLangString = ((ayms)localayns).a();
            ayif.b.put((aynu)localayns, localObject2);
          }
          else if (((localayns instanceof aypd)) && (((aypd)localayns).jdField_a_of_type_Int == -4))
          {
            localObject1 = new ayig();
            m += 1;
            ((ayig)localObject1).jdField_a_of_type_Int = m;
            ((ayig)localObject1).jdField_a_of_type_Long = 2073745984L;
            ((ayig)localObject1).jdField_a_of_type_JavaLangString = ((aypd)localayns).b().toString();
            ayif.b.put((aynu)localayns, localObject1);
          }
          else if ((localayns instanceof aync))
          {
            localObject1 = new ayig();
            ((ayig)localObject1).jdField_a_of_type_Long = ((aync)localayns).jdField_a_of_type_Long;
            ((ayig)localObject1).jdField_b_of_type_JavaLangString = ((aync)localayns).jdField_c_of_type_JavaLangString;
            ayif.b.put(localayns, localObject1);
          }
        }
      }
    }
    if ((paramBoolean) && (this.jdField_c_of_type_JavaUtilList.isEmpty())) {}
    for (int m = 1;; m = 0)
    {
      this.jdField_c_of_type_JavaUtilList.addAll(paramList);
      e(this.jdField_c_of_type_JavaUtilList);
      if (this.jdField_c_of_type_JavaUtilList.isEmpty()) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_Ayjn.a(this.jdField_c_of_type_JavaUtilList, paramBoolean);
      if (m != 0) {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(0);
      }
      return;
    }
    this.jdField_a_of_type_Ayjn.a(paramList);
    this.jdField_c_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "GroupSearchFragment isViewCreated " + this.jdField_a_of_type_Boolean + " startSearch:" + paramString + "  forceRequestStatus=" + this.jdField_g_of_type_Int);
    }
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.w("Q.uniteSearch.GroupSearchFragment", 1, "startSearchForHotWord called  isViewCreated == false!! ");
      return;
    }
    ayif.jdField_a_of_type_Long = System.currentTimeMillis();
    ayif.b.clear();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("project", aysc.a());
      localJSONObject.put("event_src", "client");
      aysc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ReportModelDC02528().module("all_result").action("search_request").ver1(paramString).ver2(aysc.a(this.jdField_i_of_type_Int)).ver7(localJSONObject.toString()).session_id(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + ayif.jdField_a_of_type_Long));
      if ((this.jdField_i_of_type_Int == 21) && (ayhw.a() == 0))
      {
        ayvm.a("all_result", "exp_pure_net_result", new String[] { paramString });
        this.jdField_g_of_type_Int = 6;
        b();
        a(new ArrayList(), 4);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "e = " + localJSONException);
      }
      c();
      paramString = new GroupSearchFragment.2(this);
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(100);
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(100);
        return;
      }
      ThreadManager.postImmediately(paramString, null, true);
    }
  }
  
  public boolean b()
  {
    return this.jdField_j_of_type_Boolean;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    a(false);
    if (this.jdField_a_of_type_Boolean)
    {
      g_(false);
      b();
      this.jdField_a_of_type_Ayjn.notifyDataSetChanged();
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_b_of_type_Int = 0;
  }
  
  public void e()
  {
    if (this.jdField_c_of_type_JavaUtilList != null) {
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    if (this.jdField_d_of_type_JavaUtilList != null) {
      this.jdField_d_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_Ayjn != null) {
      this.jdField_a_of_type_Ayjn.a(this.jdField_c_of_type_JavaUtilList);
    }
  }
  
  public void f()
  {
    c();
    this.jdField_a_of_type_Ayjn.a(this.jdField_c_of_type_JavaUtilList);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void g()
  {
    Object localObject1 = "";
    if (this.jdField_c_of_type_JavaLangString != null) {
      localObject1 = this.jdField_c_of_type_JavaLangString;
    }
    QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search startNetSearch " + (String)localObject1);
    Object localObject2;
    double d1;
    double d2;
    label253:
    Bundle localBundle;
    List localList1;
    String str;
    List localList2;
    int m;
    boolean bool;
    if (!UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int))
    {
      localObject1 = (amfe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(111);
      localObject2 = null;
      d1 = 0.0D;
      d2 = 0.0D;
      if ((getActivity() instanceof ayht))
      {
        d1 = ((ayht)getActivity()).a();
        d2 = ((ayht)getActivity()).b();
      }
      this.e = 0;
      this.jdField_c_of_type_Int = 0;
      this.jdField_h_of_type_Boolean = true;
      this.jdField_i_of_type_Boolean = false;
      this.jdField_b_of_type_JavaLangString = (System.currentTimeMillis() + "");
      if (UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int)) {
        break label404;
      }
      if (this.jdField_g_of_type_Int == 0) {
        this.jdField_g_of_type_Int = 4;
      }
      ayvm.a("all_result", "active_net", new String[] { "" + this.jdField_c_of_type_JavaLangString, "" + a(this.jdField_g_of_type_Int) });
      localBundle = new Bundle();
      localBundle.putInt("matchCount", this.jdField_h_of_type_Int);
      localBundle.putInt("source", this.jdField_j_of_type_Int);
      localList1 = a();
      if (localObject1 == null) {
        break label492;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "log for search startNetSearch use old protocl");
      }
      localObject2 = this.jdField_c_of_type_JavaLangString;
      str = this.jdField_b_of_type_JavaLangString;
      localList2 = ayvm.a(amfe.b);
      m = this.jdField_g_of_type_Int;
      if (this.jdField_a_of_type_Int != 2) {
        break label486;
      }
      bool = true;
      label348:
      ((amfe)localObject1).a((String)localObject2, str, 20, localList2, localList1, m, null, d1, d2, false, bool, this.jdField_i_of_type_Int, localBundle);
    }
    for (;;)
    {
      this.jdField_g_of_type_Int = 0;
      return;
      localObject2 = (amfc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(152);
      localObject1 = null;
      break;
      label404:
      if (this.jdField_g_of_type_Int == 0) {
        this.jdField_g_of_type_Int = 4;
      }
      ayvm.a("all_result", "active_net", new String[] { "" + this.jdField_c_of_type_JavaLangString, "" + b(this.jdField_g_of_type_Int) });
      break label253;
      label486:
      bool = false;
      break label348;
      label492:
      if (localObject2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "log for search startNetSearch use new protocl");
        }
        localObject1 = this.jdField_c_of_type_JavaLangString;
        str = this.jdField_b_of_type_JavaLangString;
        localList2 = ayvm.a(amfc.b);
        m = this.jdField_g_of_type_Int;
        if (this.jdField_a_of_type_Int == 2) {}
        for (bool = true;; bool = false)
        {
          ((amfc)localObject2).a((String)localObject1, str, 20, localList2, localList1, m, null, d1, d2, false, bool, this.jdField_i_of_type_Int, localBundle);
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "log for search startNetSearch error");
      }
    }
  }
  
  public void h()
  {
    this.jdField_h_of_type_Boolean = true;
    g_(false);
    Object localObject1;
    Object localObject2;
    if (!UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int))
    {
      localObject1 = (amfe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(111);
      localObject2 = null;
    }
    for (;;)
    {
      c();
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      double d1 = 0.0D;
      double d2 = 0.0D;
      if ((getActivity() instanceof ayht))
      {
        d1 = ((ayht)getActivity()).a();
        d2 = ((ayht)getActivity()).b();
      }
      this.jdField_b_of_type_JavaLangString = (System.currentTimeMillis() + "");
      if (QLog.isColorLevel()) {
        QLog.i("Q.uniteSearch.GroupSearchFragmentGroupSearchFragment", 2, "start search index=" + this.jdField_b_of_type_Int);
      }
      label189:
      Bundle localBundle;
      List localList;
      if (!UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int))
      {
        if (this.jdField_g_of_type_Int == 0) {
          this.jdField_g_of_type_Int = 5;
        }
        localBundle = new Bundle();
        localBundle.putInt("matchCount", this.jdField_h_of_type_Int);
        localList = a();
        if (localObject1 == null) {
          break label449;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "startNetNewSearch use old protocol");
        }
        ((amfe)localObject1).a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 20, ayvm.a(amfe.b), localList, this.jdField_g_of_type_Int, this.jdField_a_of_type_ArrayOfByte, d1, d2, true, this.jdField_i_of_type_Int, localBundle);
        label276:
        this.jdField_g_of_type_Int = 0;
        localObject1 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject1).put("project", aysc.a());
        ((JSONObject)localObject1).put("event_src", "client");
        ((JSONObject)localObject1).put("get_src", "web");
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        aysc.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("load_more").ver1(this.jdField_c_of_type_JavaLangString).ver2(aysc.a(UniteSearchActivity.jdField_d_of_type_Int)).ver7(((JSONObject)localObject1).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + ayif.jdField_a_of_type_Long));
        return;
        localObject2 = (amfc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(152);
        localObject1 = null;
        continue;
        if (this.jdField_g_of_type_Int != 0) {
          break label189;
        }
        this.jdField_g_of_type_Int = 5;
        break label189;
        label449:
        if (localObject2 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "startNetNewSearch use new protocol");
          }
          ((amfc)localObject2).a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 20, ayvm.a(amfc.b), localList, this.jdField_g_of_type_Int, this.jdField_a_of_type_ArrayOfByte, d1, d2, true, this.jdField_i_of_type_Int, localBundle);
          break label276;
        }
        if (!QLog.isColorLevel()) {
          break label276;
        }
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "startNetNewSearch error");
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "e = " + localJSONException);
        }
      }
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Ayug != null)
    {
      this.jdField_a_of_type_Ayug.b();
      this.jdField_a_of_type_Ayug.e();
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.jdField_i_of_type_Int = localBundle.getInt("fromType", -1);
      this.jdField_j_of_type_Int = localBundle.getInt("source", 0);
      this.jdField_c_of_type_Long = localBundle.getLong("searchEngineKey", 0L);
    }
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Bdbb != null) {
      this.jdField_a_of_type_Bdbb.d();
    }
    azqs.b(null, "CliOper", "", "", "0X8005ECE", "0X8005ECE", a(), 0, String.valueOf(this.jdField_d_of_type_Int), "", this.jdField_c_of_type_JavaLangString, "");
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Ayjn.notifyDataSetChanged();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("Q.uniteSearch.GroupSearchFragment arend ", 4, " onScroll" + paramInt1);
    if (this.jdField_f_of_type_Int == 0) {}
    do
    {
      return;
      if ((getActivity() instanceof UniteSearchActivity)) {
        paramAbsListView = (UniteSearchActivity)getActivity();
      }
    } while ((this.jdField_a_of_type_Ayjn == null) || (this.jdField_a_of_type_Ayjn.getCount() == 0) || (this.jdField_a_of_type_Int == 0) || (paramInt3 - paramInt1 - paramInt2 >= 10) || (this.jdField_h_of_type_Boolean) || (this.jdField_i_of_type_Boolean));
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      this.jdField_g_of_type_Int = 3;
      if (UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int)) {
        this.jdField_g_of_type_Int = 3;
      }
      g();
      g_(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
      h();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    QLog.d("Q.uniteSearch.GroupSearchFragment", 4, " onScrollStateChanged" + paramInt);
    if ((getActivity() instanceof UniteSearchActivity)) {
      paramAbsListView = (UniteSearchActivity)getActivity();
    }
    this.jdField_f_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_Ayjn == null) || (this.jdField_a_of_type_Ayjn.getCount() == 0)) {}
    while (this.jdField_a_of_type_Int == 0) {
      return;
    }
    if ((this.jdField_f_of_type_Int != 0) && (this.jdField_a_of_type_Boolean) && (!this.jdField_h_of_type_Boolean) && (!this.jdField_i_of_type_Boolean) && ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.size() < 20)))
    {
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        break label195;
      }
      this.jdField_g_of_type_Int = 3;
      if (UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int)) {
        this.jdField_g_of_type_Int = 3;
      }
      g();
      g_(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      if (paramInt != 0) {
        break;
      }
      abvl.a().a("list_unite_search", false);
      return;
      label195:
      h();
    }
    abvl.a().a("list_unite_search");
  }
  
  public void onStart()
  {
    super.onStart();
    ((GroupSearchEngine)this.jdField_a_of_type_Ayug).f();
  }
  
  public void onStop()
  {
    super.onStop();
    ((GroupSearchEngine)this.jdField_a_of_type_Ayug).g();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.jdField_a_of_type_Bdbb = new bdbb(super.getActivity(), super.getActivity().app);
    this.jdField_a_of_type_Ayjn = a();
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Ayjn);
    b();
    this.jdField_c_of_type_AndroidWidgetTextView.setText("");
    f();
    this.jdField_a_of_type_Boolean = true;
    if ((getActivity() instanceof UniteSearchActivity))
    {
      ((UniteSearchActivity)getActivity()).a(((UniteSearchActivity)getActivity()).f, this.jdField_f_of_type_Boolean, this.jdField_g_of_type_Boolean);
      this.jdField_f_of_type_Boolean = false;
      this.jdField_g_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.GroupSearchFragment
 * JD-Core Version:    0.7.0.1
 */