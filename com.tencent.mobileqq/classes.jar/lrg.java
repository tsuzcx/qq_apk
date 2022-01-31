import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyFixPosArticleManager;
import com.tencent.biz.pubaccount.readinjoy.model.FixPosArticleInterface;
import com.tencent.biz.pubaccount.readinjoy.model.FixPosArticleInterface.FixPosArticleAsyncListener;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

public class lrg
{
  public int a;
  private FixPosArticleInterface.FixPosArticleAsyncListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFixPosArticleInterface$FixPosArticleAsyncListener = new lrh(this);
  public HashMap a;
  public HashMap b = new HashMap();
  public HashMap c = new HashMap();
  
  public lrg(ReadinjoyFixPosArticleManager paramReadinjoyFixPosArticleManager, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private FixPosArticleInterface a()
  {
    AppRuntime localAppRuntime = ReadInJoyUtils.a();
    if (localAppRuntime != null) {
      return ((ReadInJoyLogicManager)localAppRuntime.getManager(162)).a().a();
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
            ((BaseArticleInfo)localObject).mRecommendSeq = ReadinjoyFixPosArticleManager.a(1, paramInt2);
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
  
  public void a(int paramInt)
  {
    int j = 0;
    b(paramInt);
    Object localObject2 = a();
    if (localObject2 == null)
    {
      QLog.d("ReadinjoyFixPosArticleManager", 1, "adinterface is null !");
      return;
    }
    Object localObject3 = ((FixPosArticleInterface)localObject2).a(paramInt);
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
    Collections.sort((List)localObject1, new lri(this));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localObject1);
    this.b.put(Integer.valueOf(paramInt), localArrayList);
    localObject2 = ((FixPosArticleInterface)localObject2).a(paramInt);
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
  
  public void a(int paramInt1, int paramInt2)
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
  
  public boolean a(int paramInt)
  {
    return (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)) != null) && (((ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).size() > 0) && (this.c.get(Integer.valueOf(paramInt)) != null) && (((ArrayList)this.c.get(Integer.valueOf(paramInt))).size() > 0);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    this.c.remove(Integer.valueOf(paramInt));
    this.b.remove(Integer.valueOf(paramInt));
  }
  
  public void c(int paramInt)
  {
    FixPosArticleInterface localFixPosArticleInterface = a();
    if (localFixPosArticleInterface != null) {
      localFixPosArticleInterface.a(paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFixPosArticleInterface$FixPosArticleAsyncListener);
    }
  }
  
  public void d(int paramInt)
  {
    FixPosArticleInterface localFixPosArticleInterface = a();
    if (localFixPosArticleInterface != null) {
      localFixPosArticleInterface.b(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lrg
 * JD-Core Version:    0.7.0.1
 */