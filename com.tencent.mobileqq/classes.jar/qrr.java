import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class qrr
  implements blih
{
  private int jdField_a_of_type_Int;
  public long a;
  public ArrayList<qrp> a;
  public HashMap<String, Integer> a;
  public boolean a;
  public long b;
  public long c;
  
  public qrr(qrn paramqrn)
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
      Object localObject1 = qrn.a(this.jdField_a_of_type_Qrn, paramAbsListView, k + i);
      label110:
      Object localObject2;
      if ((localObject1 instanceof BaseArticleInfo))
      {
        localObject1 = (BaseArticleInfo)localObject1;
        String str = qrn.a(this.jdField_a_of_type_Qrn, (BaseArticleInfo)localObject1);
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
          break label262;
        }
        localObject1 = (qrp)this.jdField_a_of_type_JavaUtilArrayList.get(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(str)).intValue());
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          this.jdField_a_of_type_Int += localView.getHeight();
          localObject2 = new qrp(this.jdField_a_of_type_Qrn);
          ((qrp)localObject2).jdField_a_of_type_JavaLangString = str;
          ((qrp)localObject2).jdField_a_of_type_Int = localView.getHeight();
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          this.jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size() - 1));
        }
        if (!paramBoolean1) {
          break label268;
        }
        ((qrp)localObject2).jdField_b_of_type_Int = localView.getTop();
        ((qrp)localObject2).d = localView.getBottom();
        label219:
        localObject1 = qrn.a(this.jdField_a_of_type_Qrn, localView);
        if ((localObject1 == null) || (((qrp)localObject2).jdField_a_of_type_Long != 0L)) {
          break label295;
        }
        ((qrp)localObject2).jdField_a_of_type_Long = System.currentTimeMillis();
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
        ((qrp)localObject2).c = localView.getTop();
        ((qrp)localObject2).e = localView.getBottom();
        break label219;
        label295:
        if (localObject1 != null)
        {
          ((qrp)localObject2).jdField_b_of_type_Long = System.currentTimeMillis();
          localObject1 = this.jdField_a_of_type_Qrn.a();
          ((qrp)localObject2).jdField_a_of_type_Double = ((localObject1[1] - localObject1[0]) * 1.0F / (float)(((qrp)localObject2).jdField_b_of_type_Long - ((qrp)localObject2).jdField_a_of_type_Long));
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
    if ((paramAbsListView == null) || (this.jdField_a_of_type_Qrn.jdField_a_of_type_Long == 0L)) {
      return;
    }
    qrq localqrq;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a(false, true, paramAbsListView);
      float[] arrayOfFloat = ((ReadInJoyXListView)paramAbsListView).a;
      paramAbsListView = ((ReadInJoyXListView)paramAbsListView).b;
      qrn.a(this.jdField_a_of_type_Qrn, new int[4]);
      qrn.a(this.jdField_a_of_type_Qrn)[0] = ((int)arrayOfFloat[0]);
      qrn.a(this.jdField_a_of_type_Qrn)[1] = ((int)arrayOfFloat[1]);
      qrn.a(this.jdField_a_of_type_Qrn)[2] = ((int)paramAbsListView[0]);
      qrn.a(this.jdField_a_of_type_Qrn)[3] = ((int)paramAbsListView[1]);
      localqrq = new qrq(this.jdField_a_of_type_Qrn);
      if (paramAbsListView[1] - arrayOfFloat[1] > 0.0F)
      {
        paramInt = 2;
        localqrq.jdField_a_of_type_Int = paramInt;
        localqrq.jdField_b_of_type_Long = (this.jdField_a_of_type_Int - this.jdField_a_of_type_Qrn.i);
        localqrq.c = (System.currentTimeMillis() - this.jdField_b_of_type_Long);
        localqrq.jdField_a_of_type_Float = ((float)localqrq.jdField_b_of_type_Long * 1.0F / (float)localqrq.c);
        if (this.c != 0L) {
          break label443;
        }
      }
      break;
    }
    label443:
    for (long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Qrn.jdField_a_of_type_Long;; l = this.jdField_b_of_type_Long - this.c)
    {
      localqrq.jdField_a_of_type_Long = l;
      localqrq.jdField_a_of_type_JavaLangString = (qrn.a(this.jdField_a_of_type_Qrn)[0] + "_" + qrn.a(this.jdField_a_of_type_Qrn)[1] + "_" + qrn.a(this.jdField_a_of_type_Qrn)[2] + "_" + qrn.a(this.jdField_a_of_type_Qrn)[3]);
      localqrq.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Qrn.b.add(localqrq);
      this.c = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_Qrn.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      }
      qrn.a(this.jdField_a_of_type_Qrn, paramAbsListView, false);
      a(true, false, paramAbsListView);
      return;
      paramInt = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qrr
 * JD-Core Version:    0.7.0.1
 */