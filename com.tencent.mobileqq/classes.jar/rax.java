import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class rax
  implements bkhe
{
  private int jdField_a_of_type_Int;
  public long a;
  public ArrayList<rav> a;
  public HashMap<String, Integer> a;
  public boolean a;
  public long b;
  public long c;
  
  public rax(rat paramrat)
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
      Object localObject1 = rat.a(this.jdField_a_of_type_Rat, paramAbsListView, k + i);
      label110:
      Object localObject2;
      if ((localObject1 instanceof BaseArticleInfo))
      {
        localObject1 = (BaseArticleInfo)localObject1;
        String str = rat.a(this.jdField_a_of_type_Rat, (BaseArticleInfo)localObject1);
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
          break label262;
        }
        localObject1 = (rav)this.jdField_a_of_type_JavaUtilArrayList.get(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(str)).intValue());
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          this.jdField_a_of_type_Int += localView.getHeight();
          localObject2 = new rav(this.jdField_a_of_type_Rat);
          ((rav)localObject2).jdField_a_of_type_JavaLangString = str;
          ((rav)localObject2).jdField_a_of_type_Int = localView.getHeight();
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          this.jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size() - 1));
        }
        if (!paramBoolean1) {
          break label268;
        }
        ((rav)localObject2).jdField_b_of_type_Int = localView.getTop();
        ((rav)localObject2).d = localView.getBottom();
        label219:
        localObject1 = rat.a(this.jdField_a_of_type_Rat, localView);
        if ((localObject1 == null) || (((rav)localObject2).jdField_a_of_type_Long != 0L)) {
          break label295;
        }
        ((rav)localObject2).jdField_a_of_type_Long = System.currentTimeMillis();
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
        ((rav)localObject2).c = localView.getTop();
        ((rav)localObject2).e = localView.getBottom();
        break label219;
        label295:
        if (localObject1 != null)
        {
          ((rav)localObject2).jdField_b_of_type_Long = System.currentTimeMillis();
          localObject1 = this.jdField_a_of_type_Rat.a();
          ((rav)localObject2).jdField_a_of_type_Double = ((localObject1[1] - localObject1[0]) * 1.0F / (float)(((rav)localObject2).jdField_b_of_type_Long - ((rav)localObject2).jdField_a_of_type_Long));
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
    if ((paramAbsListView == null) || (this.jdField_a_of_type_Rat.jdField_a_of_type_Long == 0L)) {
      return;
    }
    raw localraw;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a(false, true, paramAbsListView);
      float[] arrayOfFloat = ((ReadInJoyXListView)paramAbsListView).a;
      paramAbsListView = ((ReadInJoyXListView)paramAbsListView).b;
      rat.a(this.jdField_a_of_type_Rat, new int[4]);
      rat.a(this.jdField_a_of_type_Rat)[0] = ((int)arrayOfFloat[0]);
      rat.a(this.jdField_a_of_type_Rat)[1] = ((int)arrayOfFloat[1]);
      rat.a(this.jdField_a_of_type_Rat)[2] = ((int)paramAbsListView[0]);
      rat.a(this.jdField_a_of_type_Rat)[3] = ((int)paramAbsListView[1]);
      localraw = new raw(this.jdField_a_of_type_Rat);
      if (paramAbsListView[1] - arrayOfFloat[1] > 0.0F)
      {
        paramInt = 2;
        localraw.jdField_a_of_type_Int = paramInt;
        localraw.jdField_b_of_type_Long = (this.jdField_a_of_type_Int - this.jdField_a_of_type_Rat.i);
        localraw.c = (System.currentTimeMillis() - this.jdField_b_of_type_Long);
        localraw.jdField_a_of_type_Float = ((float)localraw.jdField_b_of_type_Long * 1.0F / (float)localraw.c);
        if (this.c != 0L) {
          break label443;
        }
      }
      break;
    }
    label443:
    for (long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Rat.jdField_a_of_type_Long;; l = this.jdField_b_of_type_Long - this.c)
    {
      localraw.jdField_a_of_type_Long = l;
      localraw.jdField_a_of_type_JavaLangString = (rat.a(this.jdField_a_of_type_Rat)[0] + "_" + rat.a(this.jdField_a_of_type_Rat)[1] + "_" + rat.a(this.jdField_a_of_type_Rat)[2] + "_" + rat.a(this.jdField_a_of_type_Rat)[3]);
      localraw.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Rat.b.add(localraw);
      this.c = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_Rat.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      }
      rat.a(this.jdField_a_of_type_Rat, paramAbsListView, false);
      a(true, false, paramAbsListView);
      return;
      paramInt = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rax
 * JD-Core Version:    0.7.0.1
 */