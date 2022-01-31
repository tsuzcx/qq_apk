import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.widget.Adapter;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class oyd
  implements bhtv
{
  public int a;
  public long a;
  private SparseArray<Integer> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  public ArrayList<Long> a;
  private HashMap<Long, oxq> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private oxy jdField_a_of_type_Oxy;
  public boolean a;
  private int jdField_b_of_type_Int;
  public long b;
  public ArrayList<Long> b;
  private HashMap<Long, Float> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private oxy jdField_b_of_type_Oxy;
  private int jdField_c_of_type_Int;
  public long c;
  private ArrayList<oyc> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private int d;
  public long d;
  private int e;
  public long e;
  private int f;
  
  public oyd(oxp paramoxp)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private Object a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView == null) || (paramInt < 0) || (paramAbsListView.getAdapter() == null)) {}
    do
    {
      return null;
      paramAbsListView = paramAbsListView.getAdapter();
    } while (paramInt >= paramAbsListView.getCount());
    try
    {
      paramAbsListView = paramAbsListView.getItem(paramInt);
      return paramAbsListView;
    }
    catch (Exception paramAbsListView)
    {
      paramAbsListView.printStackTrace();
    }
    return null;
  }
  
  private oxy a(AbsListView paramAbsListView)
  {
    if ((paramAbsListView == null) || (paramAbsListView.getChildCount() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramAbsListView.getFirstVisiblePosition();
    int i = 0;
    if (i < paramAbsListView.getChildCount())
    {
      Object localObject = a(paramAbsListView, k + i);
      if (((localObject instanceof AdvertisementInfo)) || (!(localObject instanceof BaseArticleInfo))) {}
      label173:
      label187:
      for (;;)
      {
        i += 1;
        break;
        View localView = paramAbsListView.getChildAt(i);
        if (localView.getHeight() > 0)
        {
          int j;
          if (localView.getBottom() > paramAbsListView.getHeight())
          {
            j = paramAbsListView.getHeight();
            label105:
            if (localView.getTop() <= 0) {
              break label173;
            }
          }
          for (float f1 = (j - localView.getTop()) * 1.0F / localView.getHeight();; f1 = j * 1.0F / localView.getHeight())
          {
            if (f1 <= 0.0F) {
              break label187;
            }
            localArrayList.add(new Pair((BaseArticleInfo)localObject, Float.valueOf(f1)));
            break;
            j = localView.getBottom();
            break label105;
          }
        }
      }
    }
    paramAbsListView = new oxy(this.jdField_a_of_type_Oxp, null);
    paramAbsListView.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    paramAbsListView.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_Oxy == null) {}
    for (long l = System.currentTimeMillis() - this.jdField_d_of_type_Long;; l = System.currentTimeMillis() - this.jdField_a_of_type_Oxy.jdField_a_of_type_Long)
    {
      paramAbsListView.jdField_b_of_type_Long = l;
      this.jdField_a_of_type_Oxy = paramAbsListView;
      QLog.d("ReadinjoySPEventReport", 2, new Object[] { paramAbsListView });
      return paramAbsListView;
    }
  }
  
  private oyc a(AbsListView paramAbsListView)
  {
    oyc localoyc = new oyc();
    localoyc.jdField_e_of_type_Int = this.jdField_b_of_type_Int;
    localoyc.f = this.jdField_c_of_type_Int;
    if (this.jdField_d_of_type_Int - this.f > 0) {}
    for (int i = this.jdField_d_of_type_Int - this.f;; i = 0)
    {
      localoyc.g = i;
      localoyc.jdField_a_of_type_Int = this.jdField_e_of_type_Int;
      localoyc.jdField_a_of_type_Long = (this.jdField_c_of_type_Long - this.jdField_b_of_type_Long);
      localoyc.h = this.f;
      localoyc.i = paramAbsListView.getWidth();
      localoyc.jdField_a_of_type_ArrayOfFloat = ((float[])((ReadInJoyXListView)paramAbsListView).jdField_a_of_type_ArrayOfFloat.clone());
      localoyc.b = ((float[])((ReadInJoyXListView)paramAbsListView).b.clone());
      return localoyc;
    }
  }
  
  private void b()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
  }
  
  public String a()
  {
    Object localObject = new ArrayList(this.jdField_a_of_type_JavaUtilHashMap.values());
    Collections.sort((List)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localStringBuilder.append((oxq)((Iterator)localObject).next()).append("|");
    }
    if (localStringBuilder.length() == 0) {
      return "nil";
    }
    return localStringBuilder.substring(0, localStringBuilder.length() - 1);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  /* Error */
  public void a(int paramInt, AbsListView paramAbsListView)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 211	java/lang/StringBuilder
    //   5: dup
    //   6: new 211	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   13: ldc 251
    //   15: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: iload_1
    //   19: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc_w 256
    //   25: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokespecial 262	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   34: astore 5
    //   36: aload_2
    //   37: ifnull +21 -> 58
    //   40: aload_2
    //   41: invokevirtual 80	com/tencent/widget/AbsListView:getChildCount	()I
    //   44: ifle +14 -> 58
    //   47: aload_0
    //   48: getfield 138	oyd:jdField_d_of_type_Long	J
    //   51: lstore_3
    //   52: lload_3
    //   53: lconst_0
    //   54: lcmp
    //   55: ifne +6 -> 61
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: aload_0
    //   62: getfield 46	oyd:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   65: invokevirtual 265	java/util/ArrayList:size	()I
    //   68: ifle +12 -> 80
    //   71: aload_0
    //   72: getfield 266	oyd:jdField_a_of_type_Int	I
    //   75: iload_1
    //   76: iand
    //   77: ifne -19 -> 58
    //   80: iload_1
    //   81: iconst_2
    //   82: iand
    //   83: ifeq +15 -> 98
    //   86: aload_0
    //   87: getfield 268	oyd:jdField_a_of_type_Boolean	Z
    //   90: ifeq -32 -> 58
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield 268	oyd:jdField_a_of_type_Boolean	Z
    //   98: aload_0
    //   99: aload_0
    //   100: getfield 266	oyd:jdField_a_of_type_Int	I
    //   103: iload_1
    //   104: ior
    //   105: putfield 266	oyd:jdField_a_of_type_Int	I
    //   108: aload_0
    //   109: aload_2
    //   110: invokespecial 270	oyd:a	(Lcom/tencent/widget/AbsListView;)Loxy;
    //   113: astore_2
    //   114: aload_2
    //   115: ifnull -57 -> 58
    //   118: aload_0
    //   119: aload_2
    //   120: invokevirtual 273	oyd:a	(Loxy;)V
    //   123: aload_0
    //   124: aload_2
    //   125: invokevirtual 276	oxy:a	()Ljava/util/ArrayList;
    //   128: putfield 46	oyd:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   131: ldc 142
    //   133: iconst_2
    //   134: iconst_1
    //   135: anewarray 4	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload 5
    //   142: aload_2
    //   143: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: aastore
    //   147: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   150: goto -92 -> 58
    //   153: astore_2
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_2
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	oyd
    //   0	158	1	paramInt	int
    //   0	158	2	paramAbsListView	AbsListView
    //   51	2	3	l	long
    //   34	107	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	36	153	finally
    //   40	52	153	finally
    //   61	80	153	finally
    //   86	98	153	finally
    //   98	114	153	finally
    //   118	150	153	finally
  }
  
  public void a(View paramView, AbsListView paramAbsListView, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramView == null) || (paramBaseArticleInfo == null) || (paramAbsListView == null)) {
      return;
    }
    float f1 = paramView.getHeight() / 2.0F;
    float f2 = paramView.getTop();
    float f3 = paramAbsListView.getHeight();
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(paramBaseArticleInfo.mArticleID), Float.valueOf((f1 + f2) / f3));
  }
  
  public void a(oxy paramoxy)
  {
    if ((paramoxy == null) || (this.jdField_d_of_type_Long == 0L)) {
      return;
    }
    Iterator localIterator = paramoxy.jdField_a_of_type_JavaUtilArrayList.iterator();
    label23:
    Object localObject;
    long l1;
    float f1;
    long l2;
    if (localIterator.hasNext())
    {
      localObject = (Pair)localIterator.next();
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)((Pair)localObject).first;
      l1 = paramoxy.jdField_b_of_type_Long;
      f1 = ((Float)((Pair)localObject).second).floatValue();
      oxq localoxq = (oxq)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(localBaseArticleInfo.mArticleID));
      localObject = localoxq;
      if (localoxq == null)
      {
        localObject = new oxq(this.jdField_a_of_type_Oxp, null);
        ((oxq)localObject).jdField_a_of_type_Long = localBaseArticleInfo.mRecommendSeq;
        ((oxq)localObject).jdField_b_of_type_Long = localBaseArticleInfo.mArticleID;
        ((oxq)localObject).jdField_a_of_type_JavaLangString = localBaseArticleInfo.mTitle;
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localBaseArticleInfo.mArticleID), localObject);
      }
      l2 = ((oxq)localObject).jdField_c_of_type_Long;
      if (f1 <= 0.8F) {
        break label204;
      }
    }
    for (;;)
    {
      ((oxq)localObject).jdField_c_of_type_Long = (l1 + l2);
      ((oxq)localObject).jdField_a_of_type_Float = Math.max(((oxq)localObject).jdField_a_of_type_Float, f1);
      break label23;
      break;
      label204:
      l1 = 0L;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_d_of_type_Long != 0L) {}
      for (long l = this.jdField_d_of_type_Long;; l = System.currentTimeMillis())
      {
        this.jdField_d_of_type_Long = l;
        return;
      }
    }
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    label70:
    StringBuilder localStringBuilder;
    label96:
    Long localLong;
    oxq localoxq;
    if (this.jdField_a_of_type_Oxy != null)
    {
      localArrayList1 = this.jdField_a_of_type_Oxy.a();
      if (this.jdField_b_of_type_Oxy == null) {
        break label267;
      }
      localArrayList2 = this.jdField_b_of_type_Oxy.a();
      localStringBuilder = new StringBuilder("exposure info : \n");
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localLong = (Long)localIterator.next();
        localoxq = (oxq)this.jdField_a_of_type_JavaUtilHashMap.get(localLong);
      } while (localoxq == null);
      localoxq.jdField_a_of_type_Int = 1;
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(localLong)) {
        break label273;
      }
    }
    for (localoxq.jdField_a_of_type_Int = 0;; localoxq.jdField_a_of_type_Int = 2) {
      label267:
      label273:
      do
      {
        if (this.jdField_b_of_type_JavaUtilArrayList.contains(localLong)) {
          localoxq.jdField_a_of_type_Boolean = true;
        }
        if ((localArrayList2 != null) && (localArrayList2.contains(localLong))) {
          localoxq.jdField_b_of_type_Boolean = true;
        }
        if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(localLong)) {
          localoxq.jdField_b_of_type_JavaLangString = String.format("%.2f", new Object[] { this.jdField_b_of_type_JavaUtilHashMap.get(localLong) });
        }
        localStringBuilder.append(localoxq.toString()).append("\n");
        break label96;
        localArrayList1 = null;
        break;
        localArrayList2 = null;
        break label70;
      } while ((localArrayList1 == null) || (!localArrayList1.contains(localLong)));
    }
    QLog.d("ReadinjoySPEventReport", 2, localStringBuilder.toString());
    this.jdField_a_of_type_Oxp.b = this;
    this.jdField_a_of_type_Oxp.a = new oyd(this.jdField_a_of_type_Oxp);
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      localStringBuilder.append(((oyc)this.jdField_c_of_type_JavaUtilArrayList.get(i)).a()).append("|");
      i += 1;
    }
    if (localStringBuilder.length() == 0) {
      return "nil";
    }
    return localStringBuilder.substring(0, localStringBuilder.length() - 1);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 = paramInt1 + paramInt2 - 1;
    int i = paramAbsListView.getChildCount();
    if (this.jdField_b_of_type_Int == -1)
    {
      this.jdField_b_of_type_Int = (paramInt1 + 1);
      this.jdField_c_of_type_Int = paramInt1;
    }
    int j;
    int k;
    View localView;
    if (paramInt1 < this.jdField_b_of_type_Int)
    {
      this.jdField_e_of_type_Int = 1;
      j = this.jdField_b_of_type_Int;
      paramInt2 = 0;
      if ((paramInt2 < i) && (paramInt2 < j - paramInt1))
      {
        k = paramInt1 + paramInt2;
        if (this.jdField_a_of_type_AndroidUtilSparseArray.get(k) != null)
        {
          int m = this.jdField_d_of_type_Int;
          this.jdField_d_of_type_Int = (((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.get(k)).intValue() + m);
        }
        for (;;)
        {
          paramInt2 += 1;
          break;
          localView = paramAbsListView.getChildAt(paramInt2);
          if (localView != null)
          {
            this.jdField_a_of_type_AndroidUtilSparseArray.put(k, Integer.valueOf(localView.getHeight()));
            this.jdField_d_of_type_Int += localView.getHeight();
          }
        }
      }
      this.jdField_b_of_type_Int = paramInt1;
    }
    if (paramInt3 > this.jdField_c_of_type_Int)
    {
      this.jdField_e_of_type_Int = 0;
      paramInt2 = this.jdField_c_of_type_Int;
      paramInt1 = i - 1;
      if (i - 1 - paramInt1 < paramInt3 - paramInt2)
      {
        j = paramInt3 - (i - 1 - paramInt1);
        if (this.jdField_a_of_type_AndroidUtilSparseArray.get(j) != null)
        {
          k = this.jdField_d_of_type_Int;
          this.jdField_d_of_type_Int = (((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.get(j)).intValue() + k);
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          localView = paramAbsListView.getChildAt(paramInt1);
          if (localView != null)
          {
            this.jdField_a_of_type_AndroidUtilSparseArray.put(j, Integer.valueOf(localView.getHeight()));
            this.jdField_d_of_type_Int += localView.getHeight();
          }
        }
      }
      this.jdField_c_of_type_Int = paramInt3;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    oyc localoyc;
    int i;
    switch (paramInt)
    {
    case 2: 
    case 3: 
    case 4: 
    default: 
      return;
    case 0: 
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      localoyc = a(paramAbsListView);
      this.jdField_c_of_type_JavaUtilArrayList.add(localoyc);
      this.jdField_a_of_type_Oxy = a(paramAbsListView);
      if ((paramAbsListView instanceof ReadInJoyXListView))
      {
        i = ((ReadInJoyXListView)paramAbsListView).g;
        int j = ((ReadInJoyXListView)paramAbsListView).h;
        paramInt = Math.min(i, j);
        i = Math.max(i, j);
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        QLog.d("ReadinjoySPEventReport", 2, "finger touch min :" + paramInt + ", max : " + i);
      }
    case 1: 
      while ((paramInt <= i) && (paramInt < paramAbsListView.getCount()))
      {
        Object localObject = a(paramAbsListView, paramInt);
        if (((localObject instanceof ArticleInfo)) && (!(localObject instanceof AdvertisementInfo))) {
          this.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(((ArticleInfo)localObject).mArticleID));
        }
        paramInt += 1;
        continue;
        b();
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        this.f = paramAbsListView.getHeight();
        if (this.jdField_a_of_type_Long == 0L) {
          this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
        }
        this.jdField_a_of_type_Oxy = a(paramAbsListView);
        this.jdField_b_of_type_Oxy = this.jdField_a_of_type_Oxy;
        a(this.jdField_a_of_type_Oxy);
        return;
      }
      QLog.d("ReadinjoySPEventReport", 2, "one scroll " + localoyc.a());
      return;
    }
    this.jdField_a_of_type_Oxy = a(paramAbsListView);
    a(this.jdField_a_of_type_Oxy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oyd
 * JD-Core Version:    0.7.0.1
 */