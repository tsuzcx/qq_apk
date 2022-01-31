package com.tencent.mobileqq.search.fragment;

import ajjy;
import ajoy;
import ajuo;
import ajuq;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import avip;
import avis;
import avit;
import avjb;
import avjc;
import avkj;
import avkm;
import avln;
import avlo;
import avnk;
import avnl;
import avnu;
import avnv;
import avnw;
import avnx;
import avny;
import avnz;
import avob;
import avod;
import avog;
import avol;
import avom;
import avon;
import avow;
import avpb;
import avpc;
import avpd;
import avpr;
import avpt;
import avpw;
import avqd;
import avqe;
import avsv;
import avuz;
import avvn;
import avvo;
import avvx;
import avwf;
import awqx;
import azwg;
import begh;
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
import java.util.List<Lavol;>;
import org.json.JSONException;
import org.json.JSONObject;
import zqk;

public class GroupSearchFragment
  extends BaseSearchFragment
  implements avit, begh
{
  public static volatile String a;
  public volatile int a;
  public long a;
  public avpw a;
  public boolean a;
  byte[] a;
  public int b;
  public long b;
  public Handler b;
  public avpw b;
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
    this.jdField_a_of_type_Avpw = new avpw("", -1, 2130839784, true);
    this.jdField_b_of_type_AndroidOsHandler = new avln(this, Looper.getMainLooper());
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
  
  private int a(List<avol> paramList)
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
      localObject3 = (avol)paramList.get(n);
      if ((localObject3 instanceof avnu))
      {
        localObject2 = ((avnu)localObject3).a();
        if (localObject2 == null)
        {
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            break label540;
          }
          QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "getFuzzyPotision error, groupmodel is null:" + localObject3);
        }
      }
    }
    for (;;)
    {
      n += 1;
      break;
      localObject1 = ((avom)localObject2).a();
      localObject2 = ((avnu)localObject3).a();
      if ((!ajjy.a(2131639592).equals(localObject2)) && (!ajjy.a(2131639589).equals(localObject2)) && (!ajjy.a(2131639574).equals(localObject2)) && (!avod.jdField_a_of_type_JavaLangString.equals(localObject2)))
      {
        if (ajjy.a(2131639570).equals(localObject2))
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
          localObject2 = avis.a();
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(((avnu)localObject3).a()))) {
            m = 1;
          }
          for (;;)
          {
            if (m != 0)
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                break label540;
              }
              if (((List)localObject1).size() == 0)
              {
                break;
                m = 0;
                continue;
              }
              if ((((List)localObject1).get(0) instanceof avnl))
              {
                localObject3 = (avnl)((List)localObject1).get(0);
                localObject2 = ((avnl)localObject3).jdField_c_of_type_JavaLangString;
                localObject3 = ((avnl)localObject3).a();
                if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(localObject3))) {
                  break label376;
                }
                m = 1;
              }
              for (;;)
              {
                if (m != 0)
                {
                  break;
                  label376:
                  m = 0;
                  continue;
                  if ((localObject3 instanceof avnv))
                  {
                    localObject1 = null;
                    break;
                  }
                  if ((localObject3 instanceof avpw))
                  {
                    if (!((avpw)localObject3).b()) {
                      break label538;
                    }
                    localObject1 = null;
                    break;
                  }
                  if (((localObject3 instanceof avod)) || ((localObject3 instanceof avnx)) || ((localObject3 instanceof avob)) || ((localObject3 instanceof avnw)) || ((localObject3 instanceof avny)) || ((localObject3 instanceof avnz)) || ((localObject1 != null) && (((List)localObject1).contains(localObject3)))) {
                    break;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "getFuzzyPotision, break:" + localObject3);
                  }
                }
              }
            }
          }
          label538:
          return n;
        }
        label540:
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
    List localList = new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_i_of_type_Int).a(new avvn(this.jdField_c_of_type_JavaLangString));
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList1 = ((ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a();
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
        avpr localavpr = (avpr)localList.get(m);
        int n = 0;
        while (n < localArrayList1.size())
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localArrayList1.get(n);
          if (TextUtils.equals(String.valueOf(localPublicAccountInfo.uin), String.valueOf(localavpr.a.uin))) {
            localArrayList2.add(Long.valueOf(localPublicAccountInfo.uin));
          }
          n += 1;
        }
        m += 1;
      }
    }
  }
  
  private void a(int paramInt, String paramString, List<avol> paramList)
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
            Object localObject3 = (avol)paramList.next();
            if (!(localObject3 instanceof avnu)) {
              continue;
            }
            localObject3 = ((avnu)localObject3).a();
            if (ajjy.a(2131639590).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(1), Integer.valueOf(1));
              continue;
            }
            if (ajjy.a(2131639577).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(2), Integer.valueOf(2));
              continue;
            }
            if (ajjy.a(2131639571).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(3), Integer.valueOf(3));
              continue;
            }
            if (ajjy.a(2131639569).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(4), Integer.valueOf(4));
              continue;
            }
            if (ajjy.a(2131639601).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(5), Integer.valueOf(5));
              continue;
            }
            if (ajjy.a(2131628059).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(6), Integer.valueOf(6));
              continue;
            }
            if (ajjy.a(2131639581).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(7), Integer.valueOf(7));
              continue;
            }
            if (ajjy.a(2131654130).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(8), Integer.valueOf(8));
              continue;
            }
            if (ajjy.a(2131639582).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(9), Integer.valueOf(9));
              continue;
            }
            if (ajjy.a(2131639586).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(10), Integer.valueOf(10));
              continue;
            }
            ((HashMap)localObject2).put(Integer.valueOf(11), Integer.valueOf(11));
            continue;
          }
        }
        paramList = (List<avol>)localObject1;
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
            awqx.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800973C", "0X800973C", paramInt, 0, "", "", paramString, paramList);
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
  
  private void e(List<avol> paramList)
  {
    avqd.a(paramList, this.jdField_c_of_type_JavaLangString);
    f(paramList);
  }
  
  private void f(List<avol> paramList)
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
        avol localavol1 = (avol)paramList.get(m);
        ArrayList localArrayList1;
        if ((localavol1 instanceof avpt)) {
          if (((avpt)localavol1).c())
          {
            localArrayList1 = localArrayList2;
            if (m > 0)
            {
              avol localavol2 = (avol)paramList.get(m - 1);
              if ((localavol2 instanceof avnu))
              {
                localArrayList1.add(localavol2);
                localArrayList4.remove(localavol2);
              }
            }
            localArrayList1.add(localavol1);
            n = m;
            if (m + 1 > paramList.size())
            {
              localavol1 = (avol)paramList.get(m + 1);
              n = m;
              if ((localavol1 instanceof avnv)) {
                localArrayList1.add(localavol1);
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
          if (((localavol1 instanceof avog)) && (QLog.isColorLevel())) {
            QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "adjustRichNodePosition, error, GroupSearchModelRichNode.");
          }
          localArrayList4.add(localavol1);
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
  
  protected avkj a()
  {
    return new avkm(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Azwg, this, this.jdField_i_of_type_Int);
  }
  
  protected avuz a()
  {
    if (this.jdField_a_of_type_Avuz != null) {
      return this.jdField_a_of_type_Avuz;
    }
    if (this.jdField_c_of_type_Long > 0L)
    {
      Object localObject = avvx.a().a(this.jdField_c_of_type_Long);
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
    ArrayList localArrayList = ((avqe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(318)).a(jdField_a_of_type_JavaLangString);
    return avqd.a(jdField_a_of_type_JavaLangString, localArrayList, paramList);
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
    if ((this.jdField_c_of_type_JavaUtilList.size() != 1) || (!(this.jdField_c_of_type_JavaUtilList.get(0) instanceof avpw)) || (!((avpw)this.jdField_c_of_type_JavaUtilList.get(0)).b()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new avlo(this));
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, List<avol> paramList)
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
        if (!(((List)localObject).get(m) instanceof avnu)) {
          i1 = n + 1;
        }
        m += 1;
        n = i1;
      }
      paramList = new JSONObject();
    }
    try
    {
      paramList.put("project", avsv.a());
      paramList.put("event_src", "client");
      paramList.put("web_num", n);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      avsv.a(localQQAppInterface, new ReportModelDC02528().module("all_result").action("exp_items").ver1(paramString).ver2(avsv.a(this.jdField_i_of_type_Int)).ver7(paramList.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + avjb.jdField_a_of_type_Long));
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
        if ((((List)localObject).get(i1) instanceof avnl))
        {
          if (((avnl)((List)localObject).get(i1)).d() == 1001) {
            m = 1;
          }
          i3 = n;
          i2 = m;
          if (((avnl)((List)localObject).get(i1)).d() == 1001)
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
        awqx.b(null, "CliOper", "", "", "0X8005ECF", "0X8005ECF", m, 0, "", "", "", "");
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
      paramList = (avol)paramArrayOfByte.next();
      if (!(paramList instanceof avom)) {
        break label660;
      }
      if (((avom)paramList).a() == null) {
        break label1077;
      }
      m = ((avom)paramList).a().size() + m;
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
          avwf.a("all_result", "exp_net_result", new String[] { "" + paramString });
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
            avwf.a("all_result", "noresult_net", new String[] { "" + paramString });
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
        h_(true);
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
  
  public void a(List paramList, avvo paramavvo)
  {
    if (paramavvo.a(this.jdField_c_of_type_JavaLangString)) {
      a(paramList, paramavvo.jdField_a_of_type_Int);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.uniteSearch.GroupSearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramavvo.jdField_a_of_type_JavaLangString, " keyword2:", this.jdField_c_of_type_JavaLangString });
  }
  
  public void a(List<avol> paramList, boolean paramBoolean)
  {
    c();
    if (paramList.size() > 0)
    {
      m = avjb.b.size();
      int i1 = 0;
      long l1 = -1L;
      if (i1 < paramList.size())
      {
        avol localavol = (avol)paramList.get(i1);
        Object localObject2;
        Object localObject3;
        long l2;
        Object localObject1;
        if ((localavol instanceof avnk))
        {
          localObject2 = (avnk)localavol;
          int n = m;
          if (((avnk)localObject2).a() != null)
          {
            n = m;
            if (((avnk)localObject2).a().size() > 0)
            {
              n = 0;
              if (n < ((avnk)localObject2).a().size())
              {
                localObject3 = (avol)((avnk)localObject2).a().get(i1);
                l2 = 0L;
                localObject1 = "";
                if ((localObject3 instanceof avow))
                {
                  l2 = ((avow)localObject3).jdField_a_of_type_Long;
                  localObject1 = ((avow)localObject3).d;
                }
                for (;;)
                {
                  avjc localavjc = new avjc();
                  m += 1;
                  localavjc.jdField_a_of_type_Int = m;
                  localavjc.jdField_a_of_type_Long = l2;
                  localavjc.jdField_b_of_type_JavaLangString = ((String)localObject1);
                  localavjc.jdField_a_of_type_JavaLangString = ((avnk)localavol).b();
                  avjb.b.put((avon)localObject3, localavjc);
                  n += 1;
                  break;
                  if ((localObject3 instanceof avnl))
                  {
                    l2 = ((avnl)localObject3).d();
                    localObject1 = ((avnl)localObject3).jdField_b_of_type_JavaLangString;
                  }
                }
              }
              n = m;
            }
          }
          l2 = l1;
          if (l1 == -1L) {
            l2 = ((avnk)localObject2).jdField_a_of_type_Long;
          }
          m = n;
          l1 = l2;
        }
        for (;;)
        {
          i1 += 1;
          break;
          if ((localavol instanceof avpd))
          {
            m += 1;
            localObject1 = ((avpd)localavol).a;
            if (localObject1 != null)
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (avpc)((Iterator)localObject1).next();
                localObject3 = new avjc();
                ((avjc)localObject3).jdField_a_of_type_Int = m;
                ((avjc)localObject3).jdField_a_of_type_JavaLangString = ((avow)localavol).a();
                avjb.b.put(localObject2, localObject3);
              }
            }
          }
          else if ((localavol instanceof avpb))
          {
            m += 1;
            localObject1 = ((avpb)localavol).a;
            if (localObject1 != null)
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (avpc)((Iterator)localObject1).next();
                localObject3 = new avjc();
                ((avjc)localObject3).jdField_a_of_type_Int = m;
                ((avjc)localObject3).jdField_a_of_type_JavaLangString = ((avow)localavol).a();
                avjb.b.put(localObject2, localObject3);
              }
            }
          }
          else if ((localavol instanceof avow))
          {
            localObject1 = new avjc();
            m += 1;
            ((avjc)localObject1).jdField_a_of_type_Int = m;
            ((avjc)localObject1).jdField_a_of_type_Long = ((avow)localavol).jdField_a_of_type_Long;
            ((avjc)localObject1).jdField_b_of_type_JavaLangString = ((avow)localavol).d;
            ((avjc)localObject1).jdField_a_of_type_JavaLangString = ((avow)localavol).a();
            avjb.b.put((avon)localavol, localObject1);
          }
          else if ((localavol instanceof avnl))
          {
            l2 = ((avnl)localavol).d();
            localObject1 = ((avnl)localavol).jdField_b_of_type_JavaLangString;
            localObject2 = new avjc();
            m += 1;
            ((avjc)localObject2).jdField_a_of_type_Int = m;
            ((avjc)localObject2).jdField_a_of_type_Long = l2;
            ((avjc)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1);
            ((avjc)localObject2).jdField_a_of_type_JavaLangString = ((avnl)localavol).a();
            avjb.b.put((avon)localavol, localObject2);
          }
          else if (((localavol instanceof avpw)) && (((avpw)localavol).jdField_a_of_type_Int == -4))
          {
            localObject1 = new avjc();
            m += 1;
            ((avjc)localObject1).jdField_a_of_type_Int = m;
            ((avjc)localObject1).jdField_a_of_type_Long = 2073745984L;
            ((avjc)localObject1).jdField_a_of_type_JavaLangString = ((avpw)localavol).b().toString();
            avjb.b.put((avon)localavol, localObject1);
          }
          else if ((localavol instanceof avnv))
          {
            localObject1 = new avjc();
            ((avjc)localObject1).jdField_a_of_type_Long = ((avnv)localavol).jdField_a_of_type_Long;
            ((avjc)localObject1).jdField_b_of_type_JavaLangString = ((avnv)localavol).jdField_c_of_type_JavaLangString;
            avjb.b.put(localavol, localObject1);
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
      this.jdField_a_of_type_Avkj.a(this.jdField_c_of_type_JavaUtilList, paramBoolean);
      if (m != 0) {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(0);
      }
      return;
    }
    this.jdField_a_of_type_Avkj.a(paramList);
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
    avjb.jdField_a_of_type_Long = System.currentTimeMillis();
    avjb.b.clear();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("project", avsv.a());
      localJSONObject.put("event_src", "client");
      avsv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ReportModelDC02528().module("all_result").action("search_request").ver1(paramString).ver2(avsv.a(this.jdField_i_of_type_Int)).ver7(localJSONObject.toString()).session_id(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + avjb.jdField_a_of_type_Long));
      if ((this.jdField_i_of_type_Int == 21) && (avis.a() == 0))
      {
        avwf.a("all_result", "exp_pure_net_result", new String[] { paramString });
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
      h_(false);
      b();
      this.jdField_a_of_type_Avkj.notifyDataSetChanged();
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
    if (this.jdField_a_of_type_Avkj != null) {
      this.jdField_a_of_type_Avkj.a(this.jdField_c_of_type_JavaUtilList);
    }
  }
  
  public void f()
  {
    c();
    this.jdField_a_of_type_Avkj.a(this.jdField_c_of_type_JavaUtilList);
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
      localObject1 = (ajuq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(111);
      localObject2 = null;
      d1 = 0.0D;
      d2 = 0.0D;
      if ((getActivity() instanceof avip))
      {
        d1 = ((avip)getActivity()).a();
        d2 = ((avip)getActivity()).b();
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
      avwf.a("all_result", "active_net", new String[] { "" + this.jdField_c_of_type_JavaLangString, "" + a(this.jdField_g_of_type_Int) });
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
      localList2 = avwf.a(ajuq.b);
      m = this.jdField_g_of_type_Int;
      if (this.jdField_a_of_type_Int != 2) {
        break label486;
      }
      bool = true;
      label348:
      ((ajuq)localObject1).a((String)localObject2, str, 20, localList2, localList1, m, null, d1, d2, false, bool, this.jdField_i_of_type_Int, localBundle);
    }
    for (;;)
    {
      this.jdField_g_of_type_Int = 0;
      return;
      localObject2 = (ajuo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(152);
      localObject1 = null;
      break;
      label404:
      if (this.jdField_g_of_type_Int == 0) {
        this.jdField_g_of_type_Int = 4;
      }
      avwf.a("all_result", "active_net", new String[] { "" + this.jdField_c_of_type_JavaLangString, "" + b(this.jdField_g_of_type_Int) });
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
        localList2 = avwf.a(ajuo.b);
        m = this.jdField_g_of_type_Int;
        if (this.jdField_a_of_type_Int == 2) {}
        for (bool = true;; bool = false)
        {
          ((ajuo)localObject2).a((String)localObject1, str, 20, localList2, localList1, m, null, d1, d2, false, bool, this.jdField_i_of_type_Int, localBundle);
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
    h_(false);
    Object localObject1;
    Object localObject2;
    if (!UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int))
    {
      localObject1 = (ajuq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(111);
      localObject2 = null;
    }
    for (;;)
    {
      c();
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      double d1 = 0.0D;
      double d2 = 0.0D;
      if ((getActivity() instanceof avip))
      {
        d1 = ((avip)getActivity()).a();
        d2 = ((avip)getActivity()).b();
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
        ((ajuq)localObject1).a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 20, avwf.a(ajuq.b), localList, this.jdField_g_of_type_Int, this.jdField_a_of_type_ArrayOfByte, d1, d2, true, this.jdField_i_of_type_Int, localBundle);
        label276:
        this.jdField_g_of_type_Int = 0;
        localObject1 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject1).put("project", avsv.a());
        ((JSONObject)localObject1).put("event_src", "client");
        ((JSONObject)localObject1).put("get_src", "web");
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        avsv.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("load_more").ver1(this.jdField_c_of_type_JavaLangString).ver2(avsv.a(UniteSearchActivity.jdField_d_of_type_Int)).ver7(((JSONObject)localObject1).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + avjb.jdField_a_of_type_Long));
        return;
        localObject2 = (ajuo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(152);
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
          ((ajuo)localObject2).a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 20, avwf.a(ajuo.b), localList, this.jdField_g_of_type_Int, this.jdField_a_of_type_ArrayOfByte, d1, d2, true, this.jdField_i_of_type_Int, localBundle);
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
    if (this.jdField_a_of_type_Avuz != null)
    {
      this.jdField_a_of_type_Avuz.b();
      this.jdField_a_of_type_Avuz.e();
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
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.d();
    }
    awqx.b(null, "CliOper", "", "", "0X8005ECE", "0X8005ECE", a(), 0, String.valueOf(this.jdField_d_of_type_Int), "", this.jdField_c_of_type_JavaLangString, "");
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
    this.jdField_a_of_type_Avkj.notifyDataSetChanged();
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
    } while ((this.jdField_a_of_type_Avkj == null) || (this.jdField_a_of_type_Avkj.getCount() == 0) || (this.jdField_a_of_type_Int == 0) || (paramInt3 - paramInt1 - paramInt2 >= 10) || (this.jdField_h_of_type_Boolean) || (this.jdField_i_of_type_Boolean));
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      this.jdField_g_of_type_Int = 3;
      if (UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int)) {
        this.jdField_g_of_type_Int = 3;
      }
      g();
      h_(false);
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
    if ((this.jdField_a_of_type_Avkj == null) || (this.jdField_a_of_type_Avkj.getCount() == 0)) {}
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
      h_(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      if (paramInt != 0) {
        break;
      }
      zqk.a().a("list_unite_search", false);
      return;
      label195:
      h();
    }
    zqk.a().a("list_unite_search");
  }
  
  public void onStart()
  {
    super.onStart();
    ((GroupSearchEngine)this.jdField_a_of_type_Avuz).f();
  }
  
  public void onStop()
  {
    super.onStop();
    ((GroupSearchEngine)this.jdField_a_of_type_Avuz).g();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.jdField_a_of_type_Azwg = new azwg(super.getActivity(), super.getActivity().app);
    this.jdField_a_of_type_Avkj = a();
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Avkj);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.GroupSearchFragment
 * JD-Core Version:    0.7.0.1
 */