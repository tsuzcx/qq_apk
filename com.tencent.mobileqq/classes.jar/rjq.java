import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class rjq
  implements AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int;
  public long a;
  public ArrayList<rjo> a;
  public HashMap<String, Integer> a;
  public boolean a;
  public long b;
  public long c;
  
  public rjq(rjm paramrjm)
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
      Object localObject1 = rjm.a(this.jdField_a_of_type_Rjm, paramAbsListView, k + i);
      label110:
      Object localObject2;
      if ((localObject1 instanceof BaseArticleInfo))
      {
        localObject1 = (BaseArticleInfo)localObject1;
        String str = rjm.a(this.jdField_a_of_type_Rjm, (BaseArticleInfo)localObject1);
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
          break label262;
        }
        localObject1 = (rjo)this.jdField_a_of_type_JavaUtilArrayList.get(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(str)).intValue());
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          this.jdField_a_of_type_Int += localView.getHeight();
          localObject2 = new rjo(this.jdField_a_of_type_Rjm);
          ((rjo)localObject2).jdField_a_of_type_JavaLangString = str;
          ((rjo)localObject2).jdField_a_of_type_Int = localView.getHeight();
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          this.jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size() - 1));
        }
        if (!paramBoolean1) {
          break label268;
        }
        ((rjo)localObject2).jdField_b_of_type_Int = localView.getTop();
        ((rjo)localObject2).d = localView.getBottom();
        label219:
        localObject1 = rjm.a(this.jdField_a_of_type_Rjm, localView);
        if ((localObject1 == null) || (((rjo)localObject2).jdField_a_of_type_Long != 0L)) {
          break label295;
        }
        ((rjo)localObject2).jdField_a_of_type_Long = System.currentTimeMillis();
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
        ((rjo)localObject2).c = localView.getTop();
        ((rjo)localObject2).e = localView.getBottom();
        break label219;
        label295:
        if (localObject1 != null)
        {
          ((rjo)localObject2).jdField_b_of_type_Long = System.currentTimeMillis();
          localObject1 = this.jdField_a_of_type_Rjm.a();
          ((rjo)localObject2).jdField_a_of_type_Double = ((localObject1[1] - localObject1[0]) * 1.0F / (float)(((rjo)localObject2).jdField_b_of_type_Long - ((rjo)localObject2).jdField_a_of_type_Long));
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
    if ((paramAbsListView == null) || (this.jdField_a_of_type_Rjm.jdField_a_of_type_Long == 0L)) {
      return;
    }
    rjp localrjp;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a(false, true, paramAbsListView);
      float[] arrayOfFloat = ((ReadInJoyXListView)paramAbsListView).a;
      paramAbsListView = ((ReadInJoyXListView)paramAbsListView).b;
      rjm.a(this.jdField_a_of_type_Rjm, new int[4]);
      rjm.a(this.jdField_a_of_type_Rjm)[0] = ((int)arrayOfFloat[0]);
      rjm.a(this.jdField_a_of_type_Rjm)[1] = ((int)arrayOfFloat[1]);
      rjm.a(this.jdField_a_of_type_Rjm)[2] = ((int)paramAbsListView[0]);
      rjm.a(this.jdField_a_of_type_Rjm)[3] = ((int)paramAbsListView[1]);
      localrjp = new rjp(this.jdField_a_of_type_Rjm);
      if (paramAbsListView[1] - arrayOfFloat[1] > 0.0F)
      {
        paramInt = 2;
        localrjp.jdField_a_of_type_Int = paramInt;
        localrjp.jdField_b_of_type_Long = (this.jdField_a_of_type_Int - this.jdField_a_of_type_Rjm.i);
        localrjp.c = (System.currentTimeMillis() - this.jdField_b_of_type_Long);
        localrjp.jdField_a_of_type_Float = ((float)localrjp.jdField_b_of_type_Long * 1.0F / (float)localrjp.c);
        if (this.c != 0L) {
          break label443;
        }
      }
      break;
    }
    label443:
    for (long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Rjm.jdField_a_of_type_Long;; l = this.jdField_b_of_type_Long - this.c)
    {
      localrjp.jdField_a_of_type_Long = l;
      localrjp.jdField_a_of_type_JavaLangString = (rjm.a(this.jdField_a_of_type_Rjm)[0] + "_" + rjm.a(this.jdField_a_of_type_Rjm)[1] + "_" + rjm.a(this.jdField_a_of_type_Rjm)[2] + "_" + rjm.a(this.jdField_a_of_type_Rjm)[3]);
      localrjp.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Rjm.b.add(localrjp);
      this.c = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_Rjm.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      }
      rjm.a(this.jdField_a_of_type_Rjm, paramAbsListView, false);
      a(true, false, paramAbsListView);
      return;
      paramInt = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rjq
 * JD-Core Version:    0.7.0.1
 */