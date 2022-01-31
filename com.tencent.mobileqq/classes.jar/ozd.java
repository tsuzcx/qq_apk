import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

public class ozd
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap;
  private ArrayList<String> b;
  private ArrayList<String> c;
  private ArrayList<String> d;
  private ArrayList<String> e;
  private ArrayList<String> f;
  private ArrayList<String> g;
  private ArrayList<HashMap<String, String>> h;
  
  private long a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      return 0L;
      localObject = bhvh.a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    return ((SharedPreferences)localObject).getLong("event_simple_p_info_f_num2", 0L);
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return bfkp.a(paramString);
  }
  
  private String a(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append(a((String)paramList.next())).append('^');
    }
    return b(localStringBuilder.toString());
  }
  
  private void a()
  {
    this.h = new ArrayList();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put(b("p_time_stamp"), b(this.jdField_a_of_type_Long + ""));
    localHashMap.put(b("p_flag"), b("1"));
    a("p_sp_care", this.jdField_a_of_type_JavaUtilArrayList, localHashMap);
    a("p_common_g", this.b, localHashMap);
    a("p_common_d", this.c, localHashMap);
    a("p_top_q", this.d, localHashMap);
    a("p_top_g", this.e, localHashMap);
    a("p_top_d", this.f, localHashMap);
    this.h.add(localHashMap);
    if ((this.jdField_a_of_type_Int != a()) || (ozb.a().a))
    {
      a(this.jdField_a_of_type_JavaUtilHashMap);
      int k = this.g.size();
      int i = 0;
      while (i < k)
      {
        localHashMap = new HashMap();
        localHashMap.put(b("p_time_stamp"), b(this.jdField_a_of_type_Long + ""));
        int j = 0;
        while ((j < 8) && (i + j < k))
        {
          int m = j + i;
          localHashMap.put(b("p_f_r" + m), b((String)this.g.get(m)));
          j += 1;
        }
        this.h.add(localHashMap);
        i += j;
      }
      a(this.jdField_a_of_type_Int);
    }
  }
  
  private void a(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      return;
      localObject = bhvh.a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("event_simple_p_info_f_num2", paramInt);
    bhvh.a((SharedPreferences.Editor)localObject, true);
  }
  
  private void a(String paramString, List<String> paramList, HashMap<String, String> paramHashMap)
  {
    if ((paramList == null) || (paramHashMap == null)) {}
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      while (paramList.size() > 8)
      {
        List localList = paramList.subList(0, 8);
        paramList = paramList.subList(8, paramList.size());
        localArrayList.add(a(localList));
      }
      localArrayList.add(a(paramList));
      int k = localArrayList.size();
      int i = 0;
      while (i < k)
      {
        int j = 0;
        if ((j < 8) && (i + j < k))
        {
          int m = j + i;
          if (m == 0) {}
          for (paramList = paramString;; paramList = String.format("%s%d", new Object[] { paramString, Integer.valueOf(m) }))
          {
            paramHashMap.put(b(paramList), localArrayList.get(m));
            j += 1;
            break;
          }
        }
        i += j;
      }
    }
  }
  
  private void a(HashMap<String, ArrayList<String>> paramHashMap)
  {
    Iterator localIterator1 = paramHashMap.keySet().iterator();
    StringBuilder localStringBuilder;
    int i;
    label69:
    String str2;
    if (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1).append(':');
      Iterator localIterator2 = ((ArrayList)paramHashMap.get(str1)).iterator();
      i = 0;
      if (localIterator2.hasNext())
      {
        str2 = (String)localIterator2.next();
        if (i < 8) {
          break label169;
        }
        this.g.add(localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1).append(':');
        i = 0;
      }
    }
    label169:
    for (;;)
    {
      localStringBuilder.append(a(str2)).append('^');
      i += 1;
      break label69;
      this.g.add(localStringBuilder.toString());
      break;
      return;
    }
  }
  
  private String b(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return Base64.encodeToString(paramString.getBytes(), 3);
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.b = new ArrayList();
    this.c = new ArrayList();
    this.d = new ArrayList();
    this.e = new ArrayList();
    this.f = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.g = new ArrayList();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
  }
  
  private void b(int paramInt)
  {
    if (paramInt < this.h.size())
    {
      HashMap localHashMap = (HashMap)this.h.get(paramInt);
      axrl.a(null).a(this.jdField_a_of_type_JavaLangString, "event_simple_p_info", false, 1000L, 1000L, localHashMap, null);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.g = null;
    this.jdField_a_of_type_Int = 0;
  }
  
  private void d()
  {
    b();
    i();
    f();
    e();
    a();
    c();
  }
  
  private void e()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      localObject1 = ((aktg)localObject1).a(false);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (RecentUser)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = ahnn.a(((RecentUser)localObject2).uin, ((RecentUser)localObject2).getType());
            localObject2 = ahnn.a().a((String)localObject2);
            if ((localObject2 != null) && ((((RecentBaseData)localObject2).mMenuFlag & 0xF0) == 32)) {
              if (((RecentBaseData)localObject2).a() == 1) {
                this.e.add(((RecentBaseData)localObject2).a());
              } else if (((RecentBaseData)localObject2).a() == 3000) {
                this.f.add(((RecentBaseData)localObject2).a());
              } else if (((RecentBaseData)localObject2).a() == 0) {
                this.d.add(((RecentBaseData)localObject2).a());
              }
            }
          }
        }
      }
    }
  }
  
  private void f()
  {
    g();
    h();
  }
  
  private void g()
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localTroopManager == null) {}
    for (;;)
    {
      return;
      Object localObject1 = localTroopManager.a();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (CommonlyUsedTroop)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = localTroopManager.b(((CommonlyUsedTroop)localObject2).troopUin);
            if (localObject2 != null) {
              this.b.add(((TroopInfo)localObject2).troopuin);
            }
          }
        }
      }
    }
  }
  
  private void h()
  {
    Object localObject1 = (ajvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      localObject1 = (List)((ajvk)localObject1).a().clone();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (aukm)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = (DiscussionInfo)localObject2;
            if (((DiscussionInfo)localObject2).hasCollect) {
              this.c.add(((DiscussionInfo)localObject2).uin);
            }
          }
        }
      }
    }
  }
  
  private void i()
  {
    ajxn localajxn = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localajxn != null)
    {
      localObject1 = localajxn.c();
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {}
    }
    else
    {
      return;
    }
    Object localObject1 = ((List)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (aukm)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = (Groups)localObject2;
        ArrayList localArrayList = localajxn.a(String.valueOf(((Groups)localObject2).group_id));
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          Object localObject3 = new ArrayList(localArrayList);
          int j = ((List)localObject3).size();
          localArrayList = new ArrayList(((List)localObject3).size());
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            aukm localaukm = (aukm)((Iterator)localObject3).next();
            if (localaukm != null)
            {
              Friends localFriends = (Friends)localaukm;
              localArrayList.add(((Friends)localaukm).uin);
              if (localajxn.a(localFriends.uin) != null) {
                this.jdField_a_of_type_JavaUtilArrayList.add(localFriends.uin);
              }
            }
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(((Groups)localObject2).group_name, localArrayList);
          i += j;
        }
      }
    }
    this.jdField_a_of_type_Int = i;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    d();
    if (this.h != null)
    {
      int i = 0;
      for (;;)
      {
        if (i < this.h.size())
        {
          b(i);
          try
          {
            Thread.sleep(1000L);
            i += 1;
          }
          catch (Exception paramQQAppInterface)
          {
            for (;;)
            {
              paramQQAppInterface.printStackTrace();
            }
          }
        }
      }
    }
    this.h = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_JavaLangString = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ozd
 * JD-Core Version:    0.7.0.1
 */