import com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyFixPosArticleManager.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class poc
{
  private static volatile poc jdField_a_of_type_Poc;
  private HashMap<Integer, WeakReference<sel>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private pod jdField_a_of_type_Pod = new pod(this, 1);
  
  private int a(int paramInt1, List<BaseArticleInfo> paramList, int paramInt2)
  {
    paramInt1 = 0;
    while (paramInt1 < paramList.size())
    {
      if (paramInt2 == 0)
      {
        paramList = (BaseArticleInfo)paramList.get(paramInt1);
        paramInt2 = paramInt1;
        if (paramList != null)
        {
          paramInt2 = paramInt1;
          if (paramList.mGroupId != -1L)
          {
            paramInt2 = paramInt1;
            if (paramList.mGroupCount != 1L)
            {
              QLog.d("ReadinjoyFixPosArticleManager", 2, "position " + paramInt1 + " is group article , groupCount : " + paramList.mGroupCount + ", nowGroupIndex : " + paramList.mFeedIndexInGroup + ", groupID : " + paramList.mGroupId);
              paramInt2 = paramInt1 + (int)(paramList.mGroupCount - paramList.mFeedIndexInGroup);
            }
          }
        }
        return paramInt2;
      }
      paramInt2 -= 1;
      paramInt1 += 1;
    }
    return -1;
  }
  
  private static int a(long paramLong)
  {
    return (int)(-paramLong & 0xFFFFFFFF);
  }
  
  public static poc a()
  {
    if (jdField_a_of_type_Poc == null) {}
    try
    {
      if (jdField_a_of_type_Poc == null) {
        jdField_a_of_type_Poc = new poc();
      }
      return jdField_a_of_type_Poc;
    }
    finally {}
  }
  
  public static boolean a(long paramLong)
  {
    return paramLong <= 0L;
  }
  
  private boolean a(List<BaseArticleInfo> paramList1, List<BaseArticleInfo> paramList2)
  {
    if (paramList1 == null) {}
    for (;;)
    {
      return false;
      if (paramList2 == null) {
        return true;
      }
      if (paramList1.size() != paramList2.size()) {
        return true;
      }
      int i = 0;
      while (i < paramList1.size())
      {
        BaseArticleInfo localBaseArticleInfo1 = (BaseArticleInfo)paramList1.get(i);
        BaseArticleInfo localBaseArticleInfo2 = (BaseArticleInfo)paramList2.get(i);
        if (localBaseArticleInfo1.mArticleID != localBaseArticleInfo2.mArticleID) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private static long b(int paramInt1, int paramInt2)
  {
    return -(paramInt1 << 32 | paramInt2);
  }
  
  private void c(int paramInt)
  {
    tpx.a("AdDataLink", "on async data refresh , channelID  : " + paramInt);
    Object localObject = (WeakReference)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localObject == null) {}
    do
    {
      return;
      localObject = (sel)((WeakReference)localObject).get();
    } while ((localObject == null) || (((sel)localObject).isEmpty()));
    ThreadManager.getUIHandler().post(new ReadinjoyFixPosArticleManager.1(this, (sel)localObject, paramInt));
  }
  
  public ArticleInfo a(int paramInt, long paramLong)
  {
    return (ArticleInfo)this.jdField_a_of_type_Pod.a(paramInt, a(paramLong));
  }
  
  public List<BaseArticleInfo> a(int paramInt1, List<BaseArticleInfo> paramList1, List<BaseArticleInfo> paramList2, int paramInt2)
  {
    if (paramList1 == null) {
      return null;
    }
    this.jdField_a_of_type_Pod.a(paramInt1);
    if (!this.jdField_a_of_type_Pod.a(paramInt1))
    {
      QLog.d("ReadinjoyFixPosArticleManager", 1, "has no fix article , give up insert !");
      return paramList1;
    }
    QLog.d("ReadinjoyFixPosArticleManager", 1, "insertFixPosArticles type : " + paramInt2 + ", channelID : " + paramInt1);
    long l;
    int j;
    if (paramInt2 == 2)
    {
      paramInt2 = 0;
      if (paramInt2 < paramList2.size())
      {
        l = ((BaseArticleInfo)paramList2.get(paramInt2)).mRecommendSeq;
        if (!a(l)) {}
        for (;;)
        {
          paramInt2 += 1;
          break;
          i = a(l);
          j = paramInt2 - i;
          localArrayList1 = (ArrayList)this.jdField_a_of_type_Pod.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
          localArrayList2 = (ArrayList)this.jdField_a_of_type_Pod.b.get(Integer.valueOf(paramInt1));
          if ((localArrayList1 != null) && (localArrayList2 != null))
          {
            int k = localArrayList1.indexOf(Integer.valueOf(i));
            if (k >= 0)
            {
              localArrayList2.set(k, Integer.valueOf(j));
              QLog.d("ReadinjoyFixPosArticleManager", 1, "fix offset when loadMore, expect : " + i + ", now : " + paramInt2 + ", offset : " + j);
            }
          }
        }
      }
    }
    paramList2 = (ArrayList)this.jdField_a_of_type_Pod.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    ArrayList localArrayList1 = (ArrayList)this.jdField_a_of_type_Pod.b.get(Integer.valueOf(paramInt1));
    Object localObject = (ArrayList)this.jdField_a_of_type_Pod.c.get(Integer.valueOf(paramInt1));
    if ((paramList2 == null) || (localArrayList1 == null) || (localObject == null))
    {
      QLog.d("ReadinjoyFixPosArticleManager", 1, "ad article or positions is empty ! return ori data ");
      return paramList1;
    }
    ArrayList localArrayList2 = new ArrayList(paramList1);
    int i = Math.min(paramList2.size(), ((ArrayList)localObject).size());
    paramInt2 = 0;
    if (paramInt2 < i)
    {
      j = ((Integer)paramList2.get(paramInt2)).intValue();
      j = ((Integer)localArrayList1.get(paramInt2)).intValue() + j;
      if (paramList1.size() + paramList2.size() < j + 1) {
        tpx.a("ReadinjoyFixPosArticleManager", "expect insert into " + j + ", but article size is not enougharticle size:" + paramList1.size() + " sp size: " + paramList2.size());
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        j = a(paramInt1, localArrayList2, j);
        if (j == -1)
        {
          QLog.d("ReadinjoyFixPosArticleManager", 1, "find real position is error ! ");
        }
        else
        {
          l = b(1, ((Integer)paramList2.get(paramInt2)).intValue());
          QLog.d("ReadinjoyFixPosArticleManager", 1, "insert article , position : " + j + ", expectIndex : " + paramList2.get(paramInt2) + ", fakeSeq : " + l);
          localObject = pfa.a().a(paramInt1, l);
          if (localObject != null) {
            localArrayList2.add(j, localObject);
          }
        }
      }
    }
    return localArrayList2;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyFixPosArticleManager", 2, " registerReommendADListener " + paramInt);
    }
    this.jdField_a_of_type_Pod.c(paramInt);
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (!a(paramLong)) {
      return;
    }
    int i = a(paramLong);
    this.jdField_a_of_type_Pod.a(paramInt, i);
  }
  
  public void a(int paramInt, sel paramsel)
  {
    if (paramsel == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new WeakReference(paramsel));
    this.jdField_a_of_type_Pod.c(paramInt);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    this.jdField_a_of_type_Pod.d(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     poc
 * JD-Core Version:    0.7.0.1
 */