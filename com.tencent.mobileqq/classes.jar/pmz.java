import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class pmz
  implements begh
{
  private int jdField_a_of_type_Int;
  public long a;
  public ArrayList<pmx> a;
  public HashMap<String, Integer> a;
  public boolean a;
  public long b;
  public long c;
  
  public pmz(pmv parampmv)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, AbsListView paramAbsListView)
  {
    int j = paramAbsListView.getChildCount();
    int k = paramAbsListView.getFirstVisiblePosition();
    int i = 0;
    if (i < j)
    {
      View localView = paramAbsListView.getChildAt(i);
      Object localObject1 = pmv.a(this.jdField_a_of_type_Pmv, paramAbsListView, k + i);
      label110:
      Object localObject2;
      if ((localObject1 instanceof BaseArticleInfo))
      {
        localObject1 = (BaseArticleInfo)localObject1;
        String str = pmv.a(this.jdField_a_of_type_Pmv, (BaseArticleInfo)localObject1);
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
          break label262;
        }
        localObject1 = (pmx)this.jdField_a_of_type_JavaUtilArrayList.get(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(str)).intValue());
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          this.jdField_a_of_type_Int += localView.getHeight();
          localObject2 = new pmx(this.jdField_a_of_type_Pmv);
          ((pmx)localObject2).jdField_a_of_type_JavaLangString = str;
          ((pmx)localObject2).jdField_a_of_type_Int = localView.getHeight();
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          this.jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size() - 1));
        }
        if (!paramBoolean1) {
          break label268;
        }
        ((pmx)localObject2).jdField_b_of_type_Int = localView.getTop();
        ((pmx)localObject2).d = localView.getBottom();
        label219:
        localObject1 = pmv.a(this.jdField_a_of_type_Pmv, localView);
        if ((localObject1 == null) || (((pmx)localObject2).jdField_a_of_type_Long != 0L)) {
          break label295;
        }
        ((pmx)localObject2).jdField_a_of_type_Long = System.currentTimeMillis();
      }
      for (;;)
      {
        i += 1;
        break;
        label262:
        localObject1 = null;
        break label110;
        label268:
        if (!paramBoolean2) {
          break label219;
        }
        ((pmx)localObject2).c = localView.getTop();
        ((pmx)localObject2).e = localView.getBottom();
        break label219;
        label295:
        if (localObject1 != null)
        {
          ((pmx)localObject2).jdField_b_of_type_Long = System.currentTimeMillis();
          localObject1 = this.jdField_a_of_type_Pmv.a();
          ((pmx)localObject2).jdField_a_of_type_Double = ((localObject1[1] - localObject1[0]) * 1.0F / (float)(((pmx)localObject2).jdField_b_of_type_Long - ((pmx)localObject2).jdField_a_of_type_Long));
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Boolean) {
      a(false, false, paramAbsListView);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView == null) || (this.jdField_a_of_type_Pmv.jdField_a_of_type_Long == 0L)) {
      return;
    }
    pmy localpmy;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a(false, true, paramAbsListView);
      float[] arrayOfFloat = ((ReadInJoyXListView)paramAbsListView).a;
      paramAbsListView = ((ReadInJoyXListView)paramAbsListView).b;
      pmv.a(this.jdField_a_of_type_Pmv, new int[4]);
      pmv.a(this.jdField_a_of_type_Pmv)[0] = ((int)arrayOfFloat[0]);
      pmv.a(this.jdField_a_of_type_Pmv)[1] = ((int)arrayOfFloat[1]);
      pmv.a(this.jdField_a_of_type_Pmv)[2] = ((int)paramAbsListView[0]);
      pmv.a(this.jdField_a_of_type_Pmv)[3] = ((int)paramAbsListView[1]);
      localpmy = new pmy(this.jdField_a_of_type_Pmv);
      if (paramAbsListView[1] - arrayOfFloat[1] > 0.0F)
      {
        paramInt = 2;
        localpmy.jdField_a_of_type_Int = paramInt;
        localpmy.jdField_b_of_type_Long = (this.jdField_a_of_type_Int - this.jdField_a_of_type_Pmv.i);
        localpmy.c = (System.currentTimeMillis() - this.jdField_b_of_type_Long);
        localpmy.jdField_a_of_type_Float = ((float)localpmy.jdField_b_of_type_Long * 1.0F / (float)localpmy.c);
        if (this.c != 0L) {
          break label443;
        }
      }
      break;
    }
    label443:
    for (long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Pmv.jdField_a_of_type_Long;; l = this.jdField_b_of_type_Long - this.c)
    {
      localpmy.jdField_a_of_type_Long = l;
      localpmy.jdField_a_of_type_JavaLangString = (pmv.a(this.jdField_a_of_type_Pmv)[0] + "_" + pmv.a(this.jdField_a_of_type_Pmv)[1] + "_" + pmv.a(this.jdField_a_of_type_Pmv)[2] + "_" + pmv.a(this.jdField_a_of_type_Pmv)[3]);
      localpmy.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Pmv.b.add(localpmy);
      this.c = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_Pmv.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      }
      pmv.a(this.jdField_a_of_type_Pmv, paramAbsListView, false);
      a(true, false, paramAbsListView);
      return;
      paramInt = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pmz
 * JD-Core Version:    0.7.0.1
 */