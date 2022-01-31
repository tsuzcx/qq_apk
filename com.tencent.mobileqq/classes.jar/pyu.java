import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class pyu
  implements bfob
{
  private int jdField_a_of_type_Int;
  public long a;
  public ArrayList<pys> a;
  public HashMap<String, Integer> a;
  public boolean a;
  public long b;
  public long c;
  
  public pyu(pyq parampyq)
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
      Object localObject1 = pyq.a(this.jdField_a_of_type_Pyq, paramAbsListView, k + i);
      label110:
      Object localObject2;
      if ((localObject1 instanceof BaseArticleInfo))
      {
        localObject1 = (BaseArticleInfo)localObject1;
        String str = pyq.a(this.jdField_a_of_type_Pyq, (BaseArticleInfo)localObject1);
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
          break label262;
        }
        localObject1 = (pys)this.jdField_a_of_type_JavaUtilArrayList.get(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(str)).intValue());
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          this.jdField_a_of_type_Int += localView.getHeight();
          localObject2 = new pys(this.jdField_a_of_type_Pyq);
          ((pys)localObject2).jdField_a_of_type_JavaLangString = str;
          ((pys)localObject2).jdField_a_of_type_Int = localView.getHeight();
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          this.jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size() - 1));
        }
        if (!paramBoolean1) {
          break label268;
        }
        ((pys)localObject2).jdField_b_of_type_Int = localView.getTop();
        ((pys)localObject2).d = localView.getBottom();
        label219:
        localObject1 = pyq.a(this.jdField_a_of_type_Pyq, localView);
        if ((localObject1 == null) || (((pys)localObject2).jdField_a_of_type_Long != 0L)) {
          break label295;
        }
        ((pys)localObject2).jdField_a_of_type_Long = System.currentTimeMillis();
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
        ((pys)localObject2).c = localView.getTop();
        ((pys)localObject2).e = localView.getBottom();
        break label219;
        label295:
        if (localObject1 != null)
        {
          ((pys)localObject2).jdField_b_of_type_Long = System.currentTimeMillis();
          localObject1 = this.jdField_a_of_type_Pyq.a();
          ((pys)localObject2).jdField_a_of_type_Double = ((localObject1[1] - localObject1[0]) * 1.0F / (float)(((pys)localObject2).jdField_b_of_type_Long - ((pys)localObject2).jdField_a_of_type_Long));
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
    if ((paramAbsListView == null) || (this.jdField_a_of_type_Pyq.jdField_a_of_type_Long == 0L)) {
      return;
    }
    pyt localpyt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a(false, true, paramAbsListView);
      float[] arrayOfFloat = ((ReadInJoyXListView)paramAbsListView).a;
      paramAbsListView = ((ReadInJoyXListView)paramAbsListView).b;
      pyq.a(this.jdField_a_of_type_Pyq, new int[4]);
      pyq.a(this.jdField_a_of_type_Pyq)[0] = ((int)arrayOfFloat[0]);
      pyq.a(this.jdField_a_of_type_Pyq)[1] = ((int)arrayOfFloat[1]);
      pyq.a(this.jdField_a_of_type_Pyq)[2] = ((int)paramAbsListView[0]);
      pyq.a(this.jdField_a_of_type_Pyq)[3] = ((int)paramAbsListView[1]);
      localpyt = new pyt(this.jdField_a_of_type_Pyq);
      if (paramAbsListView[1] - arrayOfFloat[1] > 0.0F)
      {
        paramInt = 2;
        localpyt.jdField_a_of_type_Int = paramInt;
        localpyt.jdField_b_of_type_Long = (this.jdField_a_of_type_Int - this.jdField_a_of_type_Pyq.i);
        localpyt.c = (System.currentTimeMillis() - this.jdField_b_of_type_Long);
        localpyt.jdField_a_of_type_Float = ((float)localpyt.jdField_b_of_type_Long * 1.0F / (float)localpyt.c);
        if (this.c != 0L) {
          break label443;
        }
      }
      break;
    }
    label443:
    for (long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Pyq.jdField_a_of_type_Long;; l = this.jdField_b_of_type_Long - this.c)
    {
      localpyt.jdField_a_of_type_Long = l;
      localpyt.jdField_a_of_type_JavaLangString = (pyq.a(this.jdField_a_of_type_Pyq)[0] + "_" + pyq.a(this.jdField_a_of_type_Pyq)[1] + "_" + pyq.a(this.jdField_a_of_type_Pyq)[2] + "_" + pyq.a(this.jdField_a_of_type_Pyq)[3]);
      localpyt.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Pyq.b.add(localpyt);
      this.c = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_Pyq.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      }
      pyq.a(this.jdField_a_of_type_Pyq, paramAbsListView, false);
      a(true, false, paramAbsListView);
      return;
      paramInt = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pyu
 * JD-Core Version:    0.7.0.1
 */