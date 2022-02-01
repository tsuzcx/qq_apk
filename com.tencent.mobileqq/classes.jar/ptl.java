import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

class ptl
{
  public int a;
  HashMap<Integer, ArrayList<Integer>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private puu jdField_a_of_type_Puu = new ptm(this);
  HashMap<Integer, ArrayList<Integer>> b = new HashMap();
  HashMap<Integer, ArrayList<BaseArticleInfo>> c = new HashMap();
  
  ptl(ptk paramptk, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private put a()
  {
    AppRuntime localAppRuntime = pay.a();
    if (localAppRuntime != null) {
      return ((pks)localAppRuntime.getManager(163)).a().a();
    }
    return null;
  }
  
  public BaseArticleInfo a(int paramInt1, int paramInt2)
  {
    Object localObject = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      int i = ((ArrayList)localObject).indexOf(Integer.valueOf(paramInt2));
      if (i != -1)
      {
        if ((this.c.containsKey(Integer.valueOf(paramInt1))) && (i < ((ArrayList)this.c.get(Integer.valueOf(paramInt1))).size()))
        {
          localObject = (BaseArticleInfo)((ArrayList)this.c.get(Integer.valueOf(paramInt1))).get(i);
          if (localObject != null) {
            ((BaseArticleInfo)localObject).mRecommendSeq = ptk.a(1, paramInt2);
          }
          return localObject;
        }
        QLog.d("ReadinjoyFixPosArticleManager", 1, "article isn't exist ! positon : " + paramInt2);
      }
    }
    for (;;)
    {
      return null;
      QLog.d("ReadinjoyFixPosArticleManager", 1, "positons is null !");
    }
  }
  
  void a(int paramInt)
  {
    int j = 0;
    b(paramInt);
    Object localObject2 = a();
    if (localObject2 == null)
    {
      QLog.d("ReadinjoyFixPosArticleManager", 1, "adinterface is null !");
      return;
    }
    Object localObject3 = ((put)localObject2).a(paramInt);
    if ((localObject3 == null) || (localObject3.length <= 0))
    {
      QLog.d("ReadinjoyFixPosArticleManager", 1, "get ad position fail ~ return data is null !");
      return;
    }
    Object localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < localObject3.length)
    {
      ((ArrayList)localObject1).add(Integer.valueOf(localObject3[i]));
      localArrayList.add(Integer.valueOf(0));
      i += 1;
    }
    Collections.sort((List)localObject1, new ptn(this));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localObject1);
    this.b.put(Integer.valueOf(paramInt), localArrayList);
    localObject2 = ((put)localObject2).a(paramInt);
    if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
    {
      localObject3 = new ArrayList((Collection)localObject2);
      this.c.put(Integer.valueOf(paramInt), localObject3);
    }
    localObject1 = new StringBuilder().append("ad pos : ").append(localObject1).append(", channelID : ").append(paramInt).append(", articleSize : ");
    paramInt = j;
    if (localObject2 != null) {
      paramInt = ((ArrayList)localObject2).size();
    }
    QLog.d("ReadinjoyFixPosArticleManager", 1, paramInt);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if (localArrayList != null)
    {
      int i = localArrayList.indexOf(Integer.valueOf(paramInt2));
      if (i != -1)
      {
        ((ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1))).remove(i);
        ((ArrayList)this.b.get(Integer.valueOf(paramInt1))).remove(i);
        ((ArrayList)this.c.get(Integer.valueOf(paramInt1))).remove(i);
        QLog.d("ReadinjoyFixPosArticleManager", 1, "delete ad article , position : " + paramInt2);
      }
    }
  }
  
  boolean a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)) != null) && (((ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).size() > 0) && (this.c.get(Integer.valueOf(paramInt)) != null) && (((ArrayList)this.c.get(Integer.valueOf(paramInt))).size() > 0))
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
      this.c.remove(Integer.valueOf(paramInt));
      this.b.remove(Integer.valueOf(paramInt));
      return;
    }
    finally {}
  }
  
  void c(int paramInt)
  {
    put localput = a();
    if (localput != null) {
      localput.a(paramInt, this.jdField_a_of_type_Puu);
    }
  }
  
  void d(int paramInt)
  {
    put localput = a();
    if (localput != null) {
      localput.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ptl
 * JD-Core Version:    0.7.0.1
 */