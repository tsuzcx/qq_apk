package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import anvx;
import aoan;
import aogg;
import aogi;
import bbze;
import bbzh;
import bbzi;
import bbzq;
import bbzr;
import bcbc;
import bcbf;
import bccg;
import bcch;
import bceg;
import bceh;
import bceq;
import bcer;
import bces;
import bcet;
import bceu;
import bcev;
import bcex;
import bcez;
import bcfc;
import bcfh;
import bcfi;
import bcfo;
import bcfs;
import bcfx;
import bcfy;
import bcfz;
import bcgb;
import bcgi;
import bcgn;
import bcgp;
import bcgs;
import bcgz;
import bcha;
import bcjs;
import bclw;
import bcmk;
import bcml;
import bcmu;
import bcnc;
import bdla;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lbcfh;>;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupSearchFragment
  extends BaseSearchFragment
  implements bbzi, AbsListView.OnScrollListener
{
  public static volatile String a;
  public volatile int a;
  public long a;
  public bcgs a;
  public boolean a;
  byte[] a;
  public int b;
  public long b;
  public Handler b;
  public bcgs b;
  public String b;
  public volatile int c;
  private long c;
  public volatile int e;
  int f;
  public boolean f;
  int g;
  public boolean g;
  int h;
  public boolean h;
  private int i;
  public boolean i;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean = true;
  private volatile boolean k;
  
  public GroupSearchFragment()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bcgs = new bcgs("", -1, 2130840445, true);
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_i_of_type_Int = -1;
    this.jdField_b_of_type_AndroidOsHandler = new bccg(this, Looper.getMainLooper());
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
  
  private int a(List<bcfh> paramList)
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
      localObject3 = (bcfh)paramList.get(n);
      if ((localObject3 instanceof bceq))
      {
        localObject2 = ((bceq)localObject3).a();
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
      localObject1 = ((bcfi)localObject2).a();
      localObject2 = ((bceq)localObject3).a();
      if ((!anvx.a(2131704861).equals(localObject2)) && (!anvx.a(2131704858).equals(localObject2)) && (!anvx.a(2131704843).equals(localObject2)) && (!bcez.jdField_a_of_type_JavaLangString.equals(localObject2)))
      {
        if (anvx.a(2131704839).equals(localObject2))
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
          if (((bceq)localObject3).b) {
            continue;
          }
          localObject2 = bbzh.a();
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(((bceq)localObject3).a()))) {
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
              if ((((List)localObject1).get(0) instanceof bceh))
              {
                localObject3 = (bceh)((List)localObject1).get(0);
                localObject2 = ((bceh)localObject3).jdField_c_of_type_JavaLangString;
                localObject3 = ((bceh)localObject3).a();
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
                  if ((localObject3 instanceof bcer))
                  {
                    localObject1 = null;
                    break;
                  }
                  if ((localObject3 instanceof bcgs))
                  {
                    if (!((bcgs)localObject3).b()) {
                      break label574;
                    }
                    localObject1 = null;
                    break;
                  }
                  if (((localObject3 instanceof bcez)) || ((localObject3 instanceof bcet)) || ((localObject3 instanceof bcex)) || ((localObject3 instanceof bces)) || ((localObject3 instanceof bceu)) || ((localObject3 instanceof bcev)) || (((localObject3 instanceof bcgi)) && (((bcgi)localObject3).jdField_c_of_type_Boolean)) || ((localObject1 != null) && (((List)localObject1).contains(localObject3)))) {
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
    List localList = new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_i_of_type_Int).a(new bcmk(this.jdField_c_of_type_JavaLangString));
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList1 = ((aoan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a();
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
        bcgn localbcgn = (bcgn)localList.get(m);
        int n = 0;
        while (n < localArrayList1.size())
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localArrayList1.get(n);
          if (TextUtils.equals(String.valueOf(localPublicAccountInfo.uin), String.valueOf(localbcgn.a.uin))) {
            localArrayList2.add(Long.valueOf(localPublicAccountInfo.uin));
          }
          n += 1;
        }
        m += 1;
      }
    }
  }
  
  private void a(int paramInt, String paramString, List<bcfh> paramList)
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
            Object localObject3 = (bcfh)paramList.next();
            if (!(localObject3 instanceof bceq)) {
              continue;
            }
            localObject3 = ((bceq)localObject3).a();
            if (anvx.a(2131704859).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(1), Integer.valueOf(1));
              continue;
            }
            if (anvx.a(2131704846).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(2), Integer.valueOf(2));
              continue;
            }
            if (anvx.a(2131704840).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(3), Integer.valueOf(3));
              continue;
            }
            if (anvx.a(2131704838).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(4), Integer.valueOf(4));
              continue;
            }
            if (anvx.a(2131704870).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(5), Integer.valueOf(5));
              continue;
            }
            if (anvx.a(2131693417).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(6), Integer.valueOf(6));
              continue;
            }
            if (anvx.a(2131704850).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(7), Integer.valueOf(7));
              continue;
            }
            if (anvx.a(2131719159).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(8), Integer.valueOf(8));
              continue;
            }
            if (anvx.a(2131704851).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(9), Integer.valueOf(9));
              continue;
            }
            if (anvx.a(2131704855).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(10), Integer.valueOf(10));
              continue;
            }
            ((HashMap)localObject2).put(Integer.valueOf(11), Integer.valueOf(11));
            continue;
          }
        }
        paramList = (List<bcfh>)localObject1;
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
            bdla.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800973C", "0X800973C", paramInt, 0, "", "", paramString, paramList);
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
  
  private void b(List<bcfh> paramList, int paramInt)
  {
    if ((paramList != null) && (paramInt == 1)) {
      paramList.remove(this.jdField_a_of_type_Bcgs);
    }
  }
  
  private void e(List<bcfh> paramList)
  {
    bcgz.a(paramList, this.jdField_c_of_type_JavaLangString);
    f(paramList);
  }
  
  private void f(List<bcfh> paramList)
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
        bcfh localbcfh1 = (bcfh)paramList.get(m);
        ArrayList localArrayList1;
        if ((localbcfh1 instanceof bcgp)) {
          if (((bcgp)localbcfh1).c())
          {
            localArrayList1 = localArrayList2;
            if (m > 0)
            {
              bcfh localbcfh2 = (bcfh)paramList.get(m - 1);
              if ((localbcfh2 instanceof bceq))
              {
                localArrayList1.add(localbcfh2);
                localArrayList4.remove(localbcfh2);
              }
            }
            localArrayList1.add(localbcfh1);
            n = m;
            if (m + 1 > paramList.size())
            {
              localbcfh1 = (bcfh)paramList.get(m + 1);
              n = m;
              if ((localbcfh1 instanceof bcer)) {
                localArrayList1.add(localbcfh1);
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
          if (((localbcfh1 instanceof bcfc)) && (QLog.isColorLevel())) {
            QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "adjustRichNodePosition, error, GroupSearchModelRichNode.");
          }
          localArrayList4.add(localbcfh1);
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
  
  protected bcbc a()
  {
    return new bcbf(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, this, this.jdField_i_of_type_Int);
  }
  
  protected bclw a()
  {
    if (this.jdField_a_of_type_Bclw != null) {
      return this.jdField_a_of_type_Bclw;
    }
    if (this.jdField_c_of_type_Long > 0L)
    {
      Object localObject = bcmu.a().a(this.jdField_c_of_type_Long);
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
    ArrayList localArrayList = ((bcha)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MOST_USE_SEARCH_MANAGER)).a(jdField_a_of_type_JavaLangString);
    return bcgz.a(jdField_a_of_type_JavaLangString, localArrayList, paramList);
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
    if ((this.jdField_c_of_type_JavaUtilList.size() != 1) || (!(this.jdField_c_of_type_JavaUtilList.get(0) instanceof bcgs)) || (!((bcgs)this.jdField_c_of_type_JavaUtilList.get(0)).b()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new bcch(this));
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, List<bcfh> paramList, int paramInt)
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
        if (!(((List)localObject).get(m) instanceof bceq)) {
          i1 = n + 1;
        }
        m += 1;
        n = i1;
      }
      paramList = new JSONObject();
    }
    try
    {
      paramList.put("project", bcjs.a());
      paramList.put("event_src", "client");
      paramList.put("web_num", n);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      bcjs.a(localQQAppInterface, new ReportModelDC02528().module("all_result").action("exp_items").ver1(paramString).ver2(bcjs.a(this.jdField_i_of_type_Int)).ver7(paramList.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + bbzq.jdField_a_of_type_Long));
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
        if ((((List)localObject).get(i1) instanceof bceh))
        {
          if (((bceh)((List)localObject).get(i1)).d() == 1001) {
            m = 1;
          }
          i3 = n;
          i2 = m;
          if (((bceh)((List)localObject).get(i1)).d() == 1001)
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
        bdla.b(null, "CliOper", "", "", "0X8005ECF", "0X8005ECF", m, 0, "", "", "", "");
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
      paramList = (bcfh)paramArrayOfByte.next();
      if (!(paramList instanceof bcfi)) {
        break label660;
      }
      if (((bcfi)paramList).a() == null) {
        break label1089;
      }
      m = ((bcfi)paramList).a().size() + m;
    }
    label660:
    label669:
    label944:
    label1083:
    label1089:
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
          bcnc.a("all_result", "exp_net_result", new String[] { "" + paramString });
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "handleTabSearchResult isFirstReq==" + paramBoolean1 + " newSearchDataCount:" + this.jdField_g_of_type_Int + "   newSearchIndex:" + this.jdField_f_of_type_Int + " result.size():" + m);
        }
        if (this.jdField_i_of_type_Boolean) {
          break label1083;
        }
        this.jdField_g_of_type_Int += m;
        this.jdField_f_of_type_Int += 1;
        m = 10;
        if (UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int)) {
          m = 20;
        }
        if (this.jdField_g_of_type_Int <= m) {
          break label944;
        }
        this.jdField_f_of_type_Int = 0;
        this.jdField_g_of_type_Int = 0;
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
            bcnc.a("all_result", "noresult_net", new String[] { "" + paramString });
            break;
            if (this.jdField_f_of_type_Int >= 3)
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
            b(this.jdField_d_of_type_JavaUtilList, paramInt);
            this.jdField_d_of_type_JavaUtilList.addAll((Collection)localObject);
          }
        }
        f_(true);
        if ((this.jdField_d_of_type_JavaUtilList != null) && (this.jdField_d_of_type_JavaUtilList.size() > 0)) {
          ((List)localObject).addAll(0, this.jdField_d_of_type_JavaUtilList);
        }
        for (;;)
        {
          a((List)localObject, this.jdField_c_of_type_Boolean, paramInt);
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
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    if (isDetached()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "onFinish, resultList = " + localObject + ", status = " + paramInt);
    }
    if ((paramInt == 4) || (paramInt == 5)) {
      paramList = a((List)localObject);
    }
    for (;;)
    {
      paramList = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(14, paramList);
      paramList.arg1 = paramInt;
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramList);
      return;
      if (localObject != null) {
        paramList = new ArrayList((Collection)localObject);
      } else {
        paramList = new ArrayList();
      }
    }
  }
  
  public void a(List paramList, bcml parambcml)
  {
    if (parambcml.a(this.jdField_c_of_type_JavaLangString)) {
      a(paramList, parambcml.jdField_a_of_type_Int);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.uniteSearch.GroupSearchFragment", 2, new Object[] { "onFinish not match keyword1:", parambcml.jdField_a_of_type_JavaLangString, " keyword2:", this.jdField_c_of_type_JavaLangString });
  }
  
  public void a(List<bcfh> paramList, boolean paramBoolean, int paramInt)
  {
    c();
    int m;
    Object localObject2;
    int n;
    if (paramList.size() > 0)
    {
      m = bbzq.b.size();
      int i1 = 0;
      long l1 = -1L;
      if (i1 < paramList.size())
      {
        localObject2 = (bcfh)paramList.get(i1);
        Object localObject3;
        Object localObject4;
        long l2;
        if ((localObject2 instanceof bceg))
        {
          localObject3 = (bceg)localObject2;
          n = m;
          if (((bceg)localObject3).a() != null)
          {
            n = m;
            if (((bceg)localObject3).a().size() > 0)
            {
              n = 0;
              if (n < ((bceg)localObject3).a().size())
              {
                localObject4 = (bcfh)((bceg)localObject3).a().get(i1);
                l2 = 0L;
                localObject1 = "";
                if ((localObject4 instanceof bcfs))
                {
                  l2 = ((bcfs)localObject4).jdField_a_of_type_Long;
                  localObject1 = ((bcfs)localObject4).d;
                }
                for (;;)
                {
                  bbzr localbbzr = new bbzr();
                  m += 1;
                  localbbzr.jdField_a_of_type_Int = m;
                  localbbzr.jdField_a_of_type_Long = l2;
                  localbbzr.jdField_b_of_type_JavaLangString = ((String)localObject1);
                  localbbzr.jdField_a_of_type_JavaLangString = ((bceg)localObject2).b();
                  bbzq.b.put(localObject4, localbbzr);
                  n += 1;
                  break;
                  if ((localObject4 instanceof bceh))
                  {
                    l2 = ((bceh)localObject4).d();
                    localObject1 = ((bceh)localObject4).jdField_b_of_type_JavaLangString;
                  }
                }
              }
              n = m;
            }
          }
          l2 = l1;
          if (l1 == -1L) {
            l2 = ((bceg)localObject3).jdField_a_of_type_Long;
          }
          m = n;
          l1 = l2;
        }
        for (;;)
        {
          i1 += 1;
          break;
          if ((localObject2 instanceof bcfz))
          {
            m += 1;
            localObject1 = ((bcfz)localObject2).a;
            if (localObject1 != null)
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (bcfy)((Iterator)localObject1).next();
                localObject4 = new bbzr();
                ((bbzr)localObject4).jdField_a_of_type_Int = m;
                ((bbzr)localObject4).jdField_a_of_type_JavaLangString = ((bcfs)localObject2).a();
                bbzq.b.put(localObject3, localObject4);
              }
            }
          }
          else if ((localObject2 instanceof bcfx))
          {
            m += 1;
            localObject1 = ((bcfx)localObject2).a;
            if (localObject1 != null)
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (bcfy)((Iterator)localObject1).next();
                localObject4 = new bbzr();
                ((bbzr)localObject4).jdField_a_of_type_Int = m;
                ((bbzr)localObject4).jdField_a_of_type_JavaLangString = ((bcfs)localObject2).a();
                bbzq.b.put(localObject3, localObject4);
              }
            }
          }
          else if ((localObject2 instanceof bcfs))
          {
            localObject1 = new bbzr();
            m += 1;
            ((bbzr)localObject1).jdField_a_of_type_Int = m;
            ((bbzr)localObject1).jdField_a_of_type_Long = ((bcfs)localObject2).jdField_a_of_type_Long;
            ((bbzr)localObject1).jdField_b_of_type_JavaLangString = ((bcfs)localObject2).d;
            ((bbzr)localObject1).jdField_a_of_type_JavaLangString = ((bcfs)localObject2).a();
            bbzq.b.put(localObject2, localObject1);
          }
          else if ((localObject2 instanceof bceh))
          {
            l2 = ((bceh)localObject2).d();
            localObject1 = ((bceh)localObject2).jdField_b_of_type_JavaLangString;
            localObject3 = new bbzr();
            m += 1;
            ((bbzr)localObject3).jdField_a_of_type_Int = m;
            ((bbzr)localObject3).jdField_a_of_type_Long = l2;
            ((bbzr)localObject3).jdField_b_of_type_JavaLangString = ((String)localObject1);
            ((bbzr)localObject3).jdField_a_of_type_JavaLangString = ((bceh)localObject2).a();
            bbzq.b.put(localObject2, localObject3);
          }
          else if (((localObject2 instanceof bcgs)) && (((bcgs)localObject2).jdField_a_of_type_Int == -4))
          {
            localObject1 = new bbzr();
            m += 1;
            ((bbzr)localObject1).jdField_a_of_type_Int = m;
            ((bbzr)localObject1).jdField_a_of_type_Long = 2073745984L;
            ((bbzr)localObject1).jdField_a_of_type_JavaLangString = ((bcgs)localObject2).b().toString();
            bbzq.b.put(localObject2, localObject1);
          }
          else if ((localObject2 instanceof bcer))
          {
            localObject1 = new bbzr();
            ((bbzr)localObject1).jdField_a_of_type_Long = ((bcer)localObject2).jdField_a_of_type_Long;
            ((bbzr)localObject1).jdField_b_of_type_JavaLangString = ((bcer)localObject2).jdField_c_of_type_JavaLangString;
            bbzq.b.put(localObject2, localObject1);
          }
        }
      }
    }
    if ((paramBoolean) && (this.jdField_c_of_type_JavaUtilList.isEmpty()))
    {
      m = 1;
      this.jdField_c_of_type_JavaUtilList.addAll(paramList);
      e(this.jdField_c_of_type_JavaUtilList);
      n = 0;
      label873:
      if (n >= this.jdField_c_of_type_JavaUtilList.size()) {
        break label1024;
      }
      if ((this.jdField_c_of_type_JavaUtilList.get(n) instanceof bcgb))
      {
        localObject1 = new MiniAppInfo();
        ((MiniAppInfo)localObject1).appId = ((bcgb)this.jdField_c_of_type_JavaUtilList.get(n)).a.a.appId;
        localObject2 = new MiniAppConfig((MiniAppInfo)localObject1);
        if (((bcgb)this.jdField_c_of_type_JavaUtilList.get(n)).a.a.showMask != 1) {
          break label1016;
        }
      }
    }
    label1016:
    for (Object localObject1 = "used";; localObject1 = "unused")
    {
      MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject2, "search", "click_button", (String)localObject1, this.jdField_c_of_type_JavaLangString);
      n += 1;
      break label873;
      m = 0;
      break;
    }
    label1024:
    if (!this.jdField_c_of_type_JavaUtilList.isEmpty())
    {
      b(this.jdField_c_of_type_JavaUtilList, paramInt);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_Bcbc.a(this.jdField_c_of_type_JavaUtilList, paramBoolean);
      if (m != 0) {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(0);
      }
      return;
    }
    this.jdField_a_of_type_Bcbc.a(paramList);
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
      QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "GroupSearchFragment isViewCreated " + this.jdField_a_of_type_Boolean + " startSearch:" + paramString + "  forceRequestStatus=" + this.jdField_c_of_type_Int);
    }
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.w("Q.uniteSearch.GroupSearchFragment", 1, "startSearchForHotWord called  isViewCreated == false!! ");
      return;
    }
    bbzq.jdField_a_of_type_Long = System.currentTimeMillis();
    bbzq.b.clear();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("project", bcjs.a());
      localJSONObject.put("event_src", "client");
      bcjs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ReportModelDC02528().module("all_result").action("search_request").ver1(paramString).ver2(bcjs.a(this.jdField_i_of_type_Int)).ver7(localJSONObject.toString()).session_id(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + bbzq.jdField_a_of_type_Long));
      if ((this.jdField_i_of_type_Int == 21) && (bbzh.a() == 0))
      {
        bcnc.a("all_result", "exp_pure_net_result", new String[] { paramString });
        this.jdField_c_of_type_Int = 6;
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
      f_(false);
      b();
      this.jdField_a_of_type_Bcbc.notifyDataSetChanged();
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
    if (this.jdField_a_of_type_Bcbc != null) {
      this.jdField_a_of_type_Bcbc.a(this.jdField_c_of_type_JavaUtilList);
    }
  }
  
  public void f()
  {
    c();
    this.jdField_a_of_type_Bcbc.a(this.jdField_c_of_type_JavaUtilList);
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
    label254:
    Bundle localBundle;
    List localList1;
    String str;
    List localList2;
    int m;
    boolean bool;
    if (!UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int))
    {
      localObject1 = (aogi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER);
      localObject2 = null;
      d1 = 0.0D;
      d2 = 0.0D;
      if ((getActivity() instanceof bbze))
      {
        d1 = ((bbze)getActivity()).a();
        d2 = ((bbze)getActivity()).b();
      }
      this.jdField_g_of_type_Int = 0;
      this.jdField_f_of_type_Int = 0;
      this.jdField_h_of_type_Boolean = true;
      this.jdField_i_of_type_Boolean = false;
      this.jdField_b_of_type_JavaLangString = (System.currentTimeMillis() + "");
      if (UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int)) {
        break label405;
      }
      if (this.jdField_c_of_type_Int == 0) {
        this.jdField_c_of_type_Int = 4;
      }
      bcnc.a("all_result", "active_net", new String[] { "" + this.jdField_c_of_type_JavaLangString, "" + a(this.jdField_c_of_type_Int) });
      localBundle = new Bundle();
      localBundle.putInt("matchCount", this.e);
      localBundle.putInt("source", this.jdField_j_of_type_Int);
      localList1 = a();
      if (localObject1 == null) {
        break label493;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "log for search startNetSearch use old protocl");
      }
      localObject2 = this.jdField_c_of_type_JavaLangString;
      str = this.jdField_b_of_type_JavaLangString;
      localList2 = bcnc.a(aogi.b);
      m = this.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Int != 2) {
        break label487;
      }
      bool = true;
      label349:
      ((aogi)localObject1).a((String)localObject2, str, 20, localList2, localList1, m, null, d1, d2, false, bool, this.jdField_i_of_type_Int, localBundle);
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = 0;
      return;
      localObject2 = (aogg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER);
      localObject1 = null;
      break;
      label405:
      if (this.jdField_c_of_type_Int == 0) {
        this.jdField_c_of_type_Int = 4;
      }
      bcnc.a("all_result", "active_net", new String[] { "" + this.jdField_c_of_type_JavaLangString, "" + b(this.jdField_c_of_type_Int) });
      break label254;
      label487:
      bool = false;
      break label349;
      label493:
      if (localObject2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "log for search startNetSearch use new protocl");
        }
        localObject1 = this.jdField_c_of_type_JavaLangString;
        str = this.jdField_b_of_type_JavaLangString;
        localList2 = bcnc.a(aogg.b);
        m = this.jdField_c_of_type_Int;
        if (this.jdField_a_of_type_Int == 2) {}
        for (bool = true;; bool = false)
        {
          ((aogg)localObject2).a((String)localObject1, str, 20, localList2, localList1, m, null, d1, d2, false, bool, this.jdField_i_of_type_Int, localBundle);
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
    f_(false);
    Object localObject1;
    Object localObject2;
    if (!UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int))
    {
      localObject1 = (aogi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER);
      localObject2 = null;
    }
    for (;;)
    {
      c();
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      double d1 = 0.0D;
      double d2 = 0.0D;
      if ((getActivity() instanceof bbze))
      {
        d1 = ((bbze)getActivity()).a();
        d2 = ((bbze)getActivity()).b();
      }
      this.jdField_b_of_type_JavaLangString = (System.currentTimeMillis() + "");
      if (QLog.isColorLevel()) {
        QLog.i("Q.uniteSearch.GroupSearchFragmentGroupSearchFragment", 2, "start search index=" + this.jdField_b_of_type_Int);
      }
      label190:
      Bundle localBundle;
      List localList;
      if (!UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int))
      {
        if (this.jdField_c_of_type_Int == 0) {
          this.jdField_c_of_type_Int = 5;
        }
        localBundle = new Bundle();
        localBundle.putInt("matchCount", this.e);
        localList = a();
        if (localObject1 == null) {
          break label450;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "startNetNewSearch use old protocol");
        }
        ((aogi)localObject1).a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 20, bcnc.a(aogi.b), localList, this.jdField_c_of_type_Int, this.jdField_a_of_type_ArrayOfByte, d1, d2, true, this.jdField_i_of_type_Int, localBundle);
        label277:
        this.jdField_c_of_type_Int = 0;
        localObject1 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject1).put("project", bcjs.a());
        ((JSONObject)localObject1).put("event_src", "client");
        ((JSONObject)localObject1).put("get_src", "web");
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        bcjs.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("load_more").ver1(this.jdField_c_of_type_JavaLangString).ver2(bcjs.a(UniteSearchActivity.jdField_d_of_type_Int)).ver7(((JSONObject)localObject1).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + bbzq.jdField_a_of_type_Long));
        return;
        localObject2 = (aogg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER);
        localObject1 = null;
        continue;
        if (this.jdField_c_of_type_Int != 0) {
          break label190;
        }
        this.jdField_c_of_type_Int = 5;
        break label190;
        label450:
        if (localObject2 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "startNetNewSearch use new protocol");
          }
          ((aogg)localObject2).a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 20, bcnc.a(aogg.b), localList, this.jdField_c_of_type_Int, this.jdField_a_of_type_ArrayOfByte, d1, d2, true, this.jdField_i_of_type_Int, localBundle);
          break label277;
        }
        if (!QLog.isColorLevel()) {
          break label277;
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
    if (this.jdField_a_of_type_Bclw != null)
    {
      this.jdField_a_of_type_Bclw.b();
      this.jdField_a_of_type_Bclw.e();
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
    bdla.b(null, "CliOper", "", "", "0X8005ECE", "0X8005ECE", a(), 0, String.valueOf(this.jdField_d_of_type_Int), "", this.jdField_c_of_type_JavaLangString, "");
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
    this.jdField_a_of_type_Bcbc.notifyDataSetChanged();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("Q.uniteSearch.GroupSearchFragment arend ", 4, " onScroll" + paramInt1);
    if (this.jdField_h_of_type_Int == 0) {}
    do
    {
      return;
      if ((getActivity() instanceof UniteSearchActivity)) {
        paramAbsListView = (UniteSearchActivity)getActivity();
      }
    } while ((this.jdField_a_of_type_Bcbc == null) || (this.jdField_a_of_type_Bcbc.getCount() == 0) || (this.jdField_a_of_type_Int == 0) || (paramInt3 - paramInt1 - paramInt2 >= 10) || (this.jdField_h_of_type_Boolean) || (this.jdField_i_of_type_Boolean));
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      this.jdField_c_of_type_Int = 3;
      if (UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int)) {
        this.jdField_c_of_type_Int = 3;
      }
      g();
      f_(false);
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
    this.jdField_h_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_Bcbc == null) || (this.jdField_a_of_type_Bcbc.getCount() == 0)) {}
    while (this.jdField_a_of_type_Int == 0) {
      return;
    }
    if ((this.jdField_h_of_type_Int != 0) && (this.jdField_a_of_type_Boolean) && (!this.jdField_h_of_type_Boolean) && (!this.jdField_i_of_type_Boolean) && ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.size() < 20)))
    {
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        break label195;
      }
      this.jdField_c_of_type_Int = 3;
      if (UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int)) {
        this.jdField_c_of_type_Int = 3;
      }
      g();
      f_(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      if (paramInt != 0) {
        break;
      }
      DropFrameMonitor.getInstance().stopMonitorScene("list_unite_search", false);
      return;
      label195:
      h();
    }
    DropFrameMonitor.getInstance().startMonitorScene("list_unite_search");
  }
  
  public void onStart()
  {
    super.onStart();
    ((GroupSearchEngine)this.jdField_a_of_type_Bclw).f();
  }
  
  public void onStop()
  {
    super.onStop();
    ((GroupSearchEngine)this.jdField_a_of_type_Bclw).g();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(super.getActivity(), super.getActivity().app);
    this.jdField_a_of_type_Bcbc = a();
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Bcbc);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.GroupSearchFragment
 * JD-Core Version:    0.7.0.1
 */