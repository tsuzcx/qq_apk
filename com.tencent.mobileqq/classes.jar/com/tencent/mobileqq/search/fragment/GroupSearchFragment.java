package com.tencent.mobileqq.search.fragment;

import abqw;
import alpo;
import aluw;
import aman;
import amap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import aydk;
import aydn;
import aydo;
import aydw;
import aydx;
import ayfe;
import ayfh;
import aygi;
import aygj;
import ayii;
import ayij;
import ayis;
import ayit;
import ayiu;
import ayiv;
import ayiw;
import ayix;
import ayiz;
import ayjb;
import ayje;
import ayjj;
import ayjk;
import ayjl;
import ayju;
import ayjz;
import ayka;
import aykb;
import aykk;
import aykp;
import aykr;
import ayku;
import aylb;
import aylc;
import aynt;
import aypx;
import ayql;
import ayqm;
import ayqv;
import ayrd;
import azmj;
import bcws;
import bhpo;
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
import java.util.List<Layjj;>;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupSearchFragment
  extends BaseSearchFragment
  implements aydo, bhpo
{
  public static volatile String a;
  public volatile int a;
  public long a;
  public ayku a;
  public boolean a;
  byte[] a;
  public int b;
  public long b;
  public Handler b;
  public ayku b;
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
    this.jdField_a_of_type_Ayku = new ayku("", -1, 2130840179, true);
    this.jdField_b_of_type_AndroidOsHandler = new aygi(this, Looper.getMainLooper());
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
  
  private int a(List<ayjj> paramList)
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
      localObject3 = (ayjj)paramList.get(n);
      if ((localObject3 instanceof ayis))
      {
        localObject2 = ((ayis)localObject3).a();
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
      localObject1 = ((ayjk)localObject2).a();
      localObject2 = ((ayis)localObject3).a();
      if ((!alpo.a(2131705760).equals(localObject2)) && (!alpo.a(2131705757).equals(localObject2)) && (!alpo.a(2131705742).equals(localObject2)) && (!ayjb.jdField_a_of_type_JavaLangString.equals(localObject2)))
      {
        if (alpo.a(2131705738).equals(localObject2))
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
          if (((ayis)localObject3).b) {
            continue;
          }
          localObject2 = aydn.a();
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(((ayis)localObject3).a()))) {
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
              if ((((List)localObject1).get(0) instanceof ayij))
              {
                localObject3 = (ayij)((List)localObject1).get(0);
                localObject2 = ((ayij)localObject3).jdField_c_of_type_JavaLangString;
                localObject3 = ((ayij)localObject3).a();
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
                  if ((localObject3 instanceof ayit))
                  {
                    localObject1 = null;
                    break;
                  }
                  if ((localObject3 instanceof ayku))
                  {
                    if (!((ayku)localObject3).b()) {
                      break label574;
                    }
                    localObject1 = null;
                    break;
                  }
                  if (((localObject3 instanceof ayjb)) || ((localObject3 instanceof ayiv)) || ((localObject3 instanceof ayiz)) || ((localObject3 instanceof ayiu)) || ((localObject3 instanceof ayiw)) || ((localObject3 instanceof ayix)) || (((localObject3 instanceof aykk)) && (((aykk)localObject3).jdField_c_of_type_Boolean)) || ((localObject1 != null) && (((List)localObject1).contains(localObject3)))) {
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
    List localList = new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_i_of_type_Int).a(new ayql(this.jdField_c_of_type_JavaLangString));
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList1 = ((aluw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a();
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
        aykp localaykp = (aykp)localList.get(m);
        int n = 0;
        while (n < localArrayList1.size())
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localArrayList1.get(n);
          if (TextUtils.equals(String.valueOf(localPublicAccountInfo.uin), String.valueOf(localaykp.a.uin))) {
            localArrayList2.add(Long.valueOf(localPublicAccountInfo.uin));
          }
          n += 1;
        }
        m += 1;
      }
    }
  }
  
  private void a(int paramInt, String paramString, List<ayjj> paramList)
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
            Object localObject3 = (ayjj)paramList.next();
            if (!(localObject3 instanceof ayis)) {
              continue;
            }
            localObject3 = ((ayis)localObject3).a();
            if (alpo.a(2131705758).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(1), Integer.valueOf(1));
              continue;
            }
            if (alpo.a(2131705745).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(2), Integer.valueOf(2));
              continue;
            }
            if (alpo.a(2131705739).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(3), Integer.valueOf(3));
              continue;
            }
            if (alpo.a(2131705737).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(4), Integer.valueOf(4));
              continue;
            }
            if (alpo.a(2131705769).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(5), Integer.valueOf(5));
              continue;
            }
            if (alpo.a(2131693817).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(6), Integer.valueOf(6));
              continue;
            }
            if (alpo.a(2131705749).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(7), Integer.valueOf(7));
              continue;
            }
            if (alpo.a(2131720567).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(8), Integer.valueOf(8));
              continue;
            }
            if (alpo.a(2131705750).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(9), Integer.valueOf(9));
              continue;
            }
            if (alpo.a(2131705754).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(10), Integer.valueOf(10));
              continue;
            }
            ((HashMap)localObject2).put(Integer.valueOf(11), Integer.valueOf(11));
            continue;
          }
        }
        paramList = (List<ayjj>)localObject1;
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
            azmj.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800973C", "0X800973C", paramInt, 0, "", "", paramString, paramList);
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
  
  private void e(List<ayjj> paramList)
  {
    aylb.a(paramList, this.jdField_c_of_type_JavaLangString);
    f(paramList);
  }
  
  private void f(List<ayjj> paramList)
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
        ayjj localayjj1 = (ayjj)paramList.get(m);
        ArrayList localArrayList1;
        if ((localayjj1 instanceof aykr)) {
          if (((aykr)localayjj1).c())
          {
            localArrayList1 = localArrayList2;
            if (m > 0)
            {
              ayjj localayjj2 = (ayjj)paramList.get(m - 1);
              if ((localayjj2 instanceof ayis))
              {
                localArrayList1.add(localayjj2);
                localArrayList4.remove(localayjj2);
              }
            }
            localArrayList1.add(localayjj1);
            n = m;
            if (m + 1 > paramList.size())
            {
              localayjj1 = (ayjj)paramList.get(m + 1);
              n = m;
              if ((localayjj1 instanceof ayit)) {
                localArrayList1.add(localayjj1);
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
          if (((localayjj1 instanceof ayje)) && (QLog.isColorLevel())) {
            QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "adjustRichNodePosition, error, GroupSearchModelRichNode.");
          }
          localArrayList4.add(localayjj1);
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
  
  protected ayfe a()
  {
    return new ayfh(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Bcws, this, this.jdField_i_of_type_Int);
  }
  
  protected aypx a()
  {
    if (this.jdField_a_of_type_Aypx != null) {
      return this.jdField_a_of_type_Aypx;
    }
    if (this.jdField_c_of_type_Long > 0L)
    {
      Object localObject = ayqv.a().a(this.jdField_c_of_type_Long);
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
    ArrayList localArrayList = ((aylc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(318)).a(jdField_a_of_type_JavaLangString);
    return aylb.a(jdField_a_of_type_JavaLangString, localArrayList, paramList);
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
    if ((this.jdField_c_of_type_JavaUtilList.size() != 1) || (!(this.jdField_c_of_type_JavaUtilList.get(0) instanceof ayku)) || (!((ayku)this.jdField_c_of_type_JavaUtilList.get(0)).b()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new aygj(this));
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, List<ayjj> paramList)
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
        if (!(((List)localObject).get(m) instanceof ayis)) {
          i1 = n + 1;
        }
        m += 1;
        n = i1;
      }
      paramList = new JSONObject();
    }
    try
    {
      paramList.put("project", aynt.a());
      paramList.put("event_src", "client");
      paramList.put("web_num", n);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      aynt.a(localQQAppInterface, new ReportModelDC02528().module("all_result").action("exp_items").ver1(paramString).ver2(aynt.a(this.jdField_i_of_type_Int)).ver7(paramList.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + aydw.jdField_a_of_type_Long));
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
        if ((((List)localObject).get(i1) instanceof ayij))
        {
          if (((ayij)((List)localObject).get(i1)).d() == 1001) {
            m = 1;
          }
          i3 = n;
          i2 = m;
          if (((ayij)((List)localObject).get(i1)).d() == 1001)
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
        azmj.b(null, "CliOper", "", "", "0X8005ECF", "0X8005ECF", m, 0, "", "", "", "");
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
      paramList = (ayjj)paramArrayOfByte.next();
      if (!(paramList instanceof ayjk)) {
        break label660;
      }
      if (((ayjk)paramList).a() == null) {
        break label1077;
      }
      m = ((ayjk)paramList).a().size() + m;
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
          ayrd.a("all_result", "exp_net_result", new String[] { "" + paramString });
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
            ayrd.a("all_result", "noresult_net", new String[] { "" + paramString });
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
  
  public void a(List paramList, ayqm paramayqm)
  {
    if (paramayqm.a(this.jdField_c_of_type_JavaLangString)) {
      a(paramList, paramayqm.jdField_a_of_type_Int);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.uniteSearch.GroupSearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramayqm.jdField_a_of_type_JavaLangString, " keyword2:", this.jdField_c_of_type_JavaLangString });
  }
  
  public void a(List<ayjj> paramList, boolean paramBoolean)
  {
    c();
    if (paramList.size() > 0)
    {
      m = aydw.b.size();
      int i1 = 0;
      long l1 = -1L;
      if (i1 < paramList.size())
      {
        ayjj localayjj = (ayjj)paramList.get(i1);
        Object localObject2;
        Object localObject3;
        long l2;
        Object localObject1;
        if ((localayjj instanceof ayii))
        {
          localObject2 = (ayii)localayjj;
          int n = m;
          if (((ayii)localObject2).a() != null)
          {
            n = m;
            if (((ayii)localObject2).a().size() > 0)
            {
              n = 0;
              if (n < ((ayii)localObject2).a().size())
              {
                localObject3 = (ayjj)((ayii)localObject2).a().get(i1);
                l2 = 0L;
                localObject1 = "";
                if ((localObject3 instanceof ayju))
                {
                  l2 = ((ayju)localObject3).jdField_a_of_type_Long;
                  localObject1 = ((ayju)localObject3).d;
                }
                for (;;)
                {
                  aydx localaydx = new aydx();
                  m += 1;
                  localaydx.jdField_a_of_type_Int = m;
                  localaydx.jdField_a_of_type_Long = l2;
                  localaydx.jdField_b_of_type_JavaLangString = ((String)localObject1);
                  localaydx.jdField_a_of_type_JavaLangString = ((ayii)localayjj).b();
                  aydw.b.put((ayjl)localObject3, localaydx);
                  n += 1;
                  break;
                  if ((localObject3 instanceof ayij))
                  {
                    l2 = ((ayij)localObject3).d();
                    localObject1 = ((ayij)localObject3).jdField_b_of_type_JavaLangString;
                  }
                }
              }
              n = m;
            }
          }
          l2 = l1;
          if (l1 == -1L) {
            l2 = ((ayii)localObject2).jdField_a_of_type_Long;
          }
          m = n;
          l1 = l2;
        }
        for (;;)
        {
          i1 += 1;
          break;
          if ((localayjj instanceof aykb))
          {
            m += 1;
            localObject1 = ((aykb)localayjj).a;
            if (localObject1 != null)
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (ayka)((Iterator)localObject1).next();
                localObject3 = new aydx();
                ((aydx)localObject3).jdField_a_of_type_Int = m;
                ((aydx)localObject3).jdField_a_of_type_JavaLangString = ((ayju)localayjj).a();
                aydw.b.put(localObject2, localObject3);
              }
            }
          }
          else if ((localayjj instanceof ayjz))
          {
            m += 1;
            localObject1 = ((ayjz)localayjj).a;
            if (localObject1 != null)
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (ayka)((Iterator)localObject1).next();
                localObject3 = new aydx();
                ((aydx)localObject3).jdField_a_of_type_Int = m;
                ((aydx)localObject3).jdField_a_of_type_JavaLangString = ((ayju)localayjj).a();
                aydw.b.put(localObject2, localObject3);
              }
            }
          }
          else if ((localayjj instanceof ayju))
          {
            localObject1 = new aydx();
            m += 1;
            ((aydx)localObject1).jdField_a_of_type_Int = m;
            ((aydx)localObject1).jdField_a_of_type_Long = ((ayju)localayjj).jdField_a_of_type_Long;
            ((aydx)localObject1).jdField_b_of_type_JavaLangString = ((ayju)localayjj).d;
            ((aydx)localObject1).jdField_a_of_type_JavaLangString = ((ayju)localayjj).a();
            aydw.b.put((ayjl)localayjj, localObject1);
          }
          else if ((localayjj instanceof ayij))
          {
            l2 = ((ayij)localayjj).d();
            localObject1 = ((ayij)localayjj).jdField_b_of_type_JavaLangString;
            localObject2 = new aydx();
            m += 1;
            ((aydx)localObject2).jdField_a_of_type_Int = m;
            ((aydx)localObject2).jdField_a_of_type_Long = l2;
            ((aydx)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1);
            ((aydx)localObject2).jdField_a_of_type_JavaLangString = ((ayij)localayjj).a();
            aydw.b.put((ayjl)localayjj, localObject2);
          }
          else if (((localayjj instanceof ayku)) && (((ayku)localayjj).jdField_a_of_type_Int == -4))
          {
            localObject1 = new aydx();
            m += 1;
            ((aydx)localObject1).jdField_a_of_type_Int = m;
            ((aydx)localObject1).jdField_a_of_type_Long = 2073745984L;
            ((aydx)localObject1).jdField_a_of_type_JavaLangString = ((ayku)localayjj).b().toString();
            aydw.b.put((ayjl)localayjj, localObject1);
          }
          else if ((localayjj instanceof ayit))
          {
            localObject1 = new aydx();
            ((aydx)localObject1).jdField_a_of_type_Long = ((ayit)localayjj).jdField_a_of_type_Long;
            ((aydx)localObject1).jdField_b_of_type_JavaLangString = ((ayit)localayjj).jdField_c_of_type_JavaLangString;
            aydw.b.put(localayjj, localObject1);
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
      this.jdField_a_of_type_Ayfe.a(this.jdField_c_of_type_JavaUtilList, paramBoolean);
      if (m != 0) {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(0);
      }
      return;
    }
    this.jdField_a_of_type_Ayfe.a(paramList);
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
    aydw.jdField_a_of_type_Long = System.currentTimeMillis();
    aydw.b.clear();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("project", aynt.a());
      localJSONObject.put("event_src", "client");
      aynt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ReportModelDC02528().module("all_result").action("search_request").ver1(paramString).ver2(aynt.a(this.jdField_i_of_type_Int)).ver7(localJSONObject.toString()).session_id(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + aydw.jdField_a_of_type_Long));
      if ((this.jdField_i_of_type_Int == 21) && (aydn.a() == 0))
      {
        ayrd.a("all_result", "exp_pure_net_result", new String[] { paramString });
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
      this.jdField_a_of_type_Ayfe.notifyDataSetChanged();
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
    if (this.jdField_a_of_type_Ayfe != null) {
      this.jdField_a_of_type_Ayfe.a(this.jdField_c_of_type_JavaUtilList);
    }
  }
  
  public void f()
  {
    c();
    this.jdField_a_of_type_Ayfe.a(this.jdField_c_of_type_JavaUtilList);
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
      localObject1 = (amap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(111);
      localObject2 = null;
      d1 = 0.0D;
      d2 = 0.0D;
      if ((getActivity() instanceof aydk))
      {
        d1 = ((aydk)getActivity()).a();
        d2 = ((aydk)getActivity()).b();
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
      ayrd.a("all_result", "active_net", new String[] { "" + this.jdField_c_of_type_JavaLangString, "" + a(this.jdField_g_of_type_Int) });
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
      localList2 = ayrd.a(amap.b);
      m = this.jdField_g_of_type_Int;
      if (this.jdField_a_of_type_Int != 2) {
        break label486;
      }
      bool = true;
      label348:
      ((amap)localObject1).a((String)localObject2, str, 20, localList2, localList1, m, null, d1, d2, false, bool, this.jdField_i_of_type_Int, localBundle);
    }
    for (;;)
    {
      this.jdField_g_of_type_Int = 0;
      return;
      localObject2 = (aman)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(152);
      localObject1 = null;
      break;
      label404:
      if (this.jdField_g_of_type_Int == 0) {
        this.jdField_g_of_type_Int = 4;
      }
      ayrd.a("all_result", "active_net", new String[] { "" + this.jdField_c_of_type_JavaLangString, "" + b(this.jdField_g_of_type_Int) });
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
        localList2 = ayrd.a(aman.b);
        m = this.jdField_g_of_type_Int;
        if (this.jdField_a_of_type_Int == 2) {}
        for (bool = true;; bool = false)
        {
          ((aman)localObject2).a((String)localObject1, str, 20, localList2, localList1, m, null, d1, d2, false, bool, this.jdField_i_of_type_Int, localBundle);
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
      localObject1 = (amap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(111);
      localObject2 = null;
    }
    for (;;)
    {
      c();
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      double d1 = 0.0D;
      double d2 = 0.0D;
      if ((getActivity() instanceof aydk))
      {
        d1 = ((aydk)getActivity()).a();
        d2 = ((aydk)getActivity()).b();
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
        ((amap)localObject1).a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 20, ayrd.a(amap.b), localList, this.jdField_g_of_type_Int, this.jdField_a_of_type_ArrayOfByte, d1, d2, true, this.jdField_i_of_type_Int, localBundle);
        label276:
        this.jdField_g_of_type_Int = 0;
        localObject1 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject1).put("project", aynt.a());
        ((JSONObject)localObject1).put("event_src", "client");
        ((JSONObject)localObject1).put("get_src", "web");
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        aynt.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("load_more").ver1(this.jdField_c_of_type_JavaLangString).ver2(aynt.a(UniteSearchActivity.jdField_d_of_type_Int)).ver7(((JSONObject)localObject1).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + aydw.jdField_a_of_type_Long));
        return;
        localObject2 = (aman)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(152);
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
          ((aman)localObject2).a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 20, ayrd.a(aman.b), localList, this.jdField_g_of_type_Int, this.jdField_a_of_type_ArrayOfByte, d1, d2, true, this.jdField_i_of_type_Int, localBundle);
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
    if (this.jdField_a_of_type_Aypx != null)
    {
      this.jdField_a_of_type_Aypx.b();
      this.jdField_a_of_type_Aypx.e();
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
    if (this.jdField_a_of_type_Bcws != null) {
      this.jdField_a_of_type_Bcws.d();
    }
    azmj.b(null, "CliOper", "", "", "0X8005ECE", "0X8005ECE", a(), 0, String.valueOf(this.jdField_d_of_type_Int), "", this.jdField_c_of_type_JavaLangString, "");
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
    this.jdField_a_of_type_Ayfe.notifyDataSetChanged();
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
    } while ((this.jdField_a_of_type_Ayfe == null) || (this.jdField_a_of_type_Ayfe.getCount() == 0) || (this.jdField_a_of_type_Int == 0) || (paramInt3 - paramInt1 - paramInt2 >= 10) || (this.jdField_h_of_type_Boolean) || (this.jdField_i_of_type_Boolean));
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
    if ((this.jdField_a_of_type_Ayfe == null) || (this.jdField_a_of_type_Ayfe.getCount() == 0)) {}
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
      abqw.a().a("list_unite_search", false);
      return;
      label195:
      h();
    }
    abqw.a().a("list_unite_search");
  }
  
  public void onStart()
  {
    super.onStart();
    ((GroupSearchEngine)this.jdField_a_of_type_Aypx).f();
  }
  
  public void onStop()
  {
    super.onStop();
    ((GroupSearchEngine)this.jdField_a_of_type_Aypx).g();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.jdField_a_of_type_Bcws = new bcws(super.getActivity(), super.getActivity().app);
    this.jdField_a_of_type_Ayfe = a();
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Ayfe);
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