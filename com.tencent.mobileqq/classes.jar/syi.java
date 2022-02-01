import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ListAdExposeManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class syi
{
  private int jdField_a_of_type_Int = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private ArrayList<syh> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashSet<syh> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private HashSet<syh> b = new HashSet();
  private HashSet<syh> c = new HashSet();
  private HashSet<syh> d = new HashSet();
  
  public syi(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private syh a(int paramInt)
  {
    int j = 0;
    for (;;)
    {
      int i;
      int k;
      int m;
      try
      {
        i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        syh localsyh;
        if (j <= i)
        {
          k = j + i >>> 1;
          localsyh = (syh)this.jdField_a_of_type_JavaUtilArrayList.get(k);
          m = localsyh.jdField_a_of_type_Int - paramInt;
          if (m >= 0) {
            break label116;
          }
          j = k + 1;
        }
        else
        {
          paramInt = -(j + 1);
          if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
          {
            localsyh = (syh)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
            return localsyh;
          }
          localsyh = null;
          continue;
        }
        continue;
      }
      finally {}
      label116:
      while (m > 0) {
        i = k - 1;
      }
    }
  }
  
  private void a(syh paramsyh)
  {
    if (this.c.contains(paramsyh)) {}
    do
    {
      return;
      this.c.add(paramsyh);
    } while ((!this.d.contains(paramsyh)) || (this.jdField_a_of_type_JavaUtilHashSet.contains(paramsyh)));
    this.jdField_a_of_type_JavaUtilHashSet.add(paramsyh);
    d(paramsyh);
  }
  
  private void a(syh paramsyh, View paramView)
  {
    if (paramsyh == null) {}
    do
    {
      return;
      paramView.getLocalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
      int i = this.jdField_a_of_type_AndroidGraphicsRect.height();
      long l = System.currentTimeMillis();
      if ((paramsyh.jdField_a_of_type_Long == 0L) && (i > 0))
      {
        paramsyh.jdField_a_of_type_Long = l;
        ThreadManager.getUIHandler().postDelayed(new ListAdExposeManager.1(this, paramsyh), 1000L);
      }
      int j;
      for (;;)
      {
        j = paramView.getHeight();
        if ((i > 0) && (j > 0)) {
          break;
        }
        paramsyh.jdField_a_of_type_Float = 0.0F;
        return;
        if (l > paramsyh.jdField_a_of_type_Long + 1L)
        {
          paramsyh.b = l;
          b(paramsyh);
        }
      }
      paramsyh.jdField_a_of_type_Float = (i / j);
    } while (paramsyh.jdField_a_of_type_Float <= 0.5F);
    a(paramsyh);
  }
  
  private void b(syh paramsyh)
  {
    if (this.d.contains(paramsyh)) {}
    do
    {
      return;
      this.d.add(paramsyh);
    } while ((!this.c.contains(paramsyh)) || (this.jdField_a_of_type_JavaUtilHashSet.contains(paramsyh)));
    this.jdField_a_of_type_JavaUtilHashSet.add(paramsyh);
    d(paramsyh);
  }
  
  private void c(syh paramsyh)
  {
    if (this.b.contains(paramsyh)) {
      return;
    }
    this.b.add(paramsyh);
    e(paramsyh);
  }
  
  private void d(syh paramsyh)
  {
    float f = paramsyh.jdField_a_of_type_Float;
    long l = paramsyh.b;
    paramsyh = paramsyh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if (paramsyh == null) {
      return;
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject1.put("article_id", String.valueOf(paramsyh.mArticleID));
      localJSONObject1.put("rowkey", String.valueOf(paramsyh.mRowKey));
      paramsyh.mBusiJson = localJSONObject1;
      localJSONObject2.put("exposureArea", f);
      localJSONObject2.put("exposureTime", l);
      paramsyh.mReportDataJson = localJSONObject2;
      olm.a(false, this.jdField_a_of_type_AndroidContentContext, paramsyh, nxw.aq, nxw.b, 2);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        oqh.a("ListAdExposeManager", localException.getMessage());
      }
    }
  }
  
  private void e(syh paramsyh) {}
  
  public void a()
  {
    oqh.a("ListAdExposeManager", "clearCache");
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.b.clear();
    this.c.clear();
    this.d.clear();
  }
  
  public void a(AbsListView paramAbsListView)
  {
    if (paramAbsListView.getVisibility() != 0) {}
    int j;
    int k;
    do
    {
      return;
      j = paramAbsListView.getFirstVisiblePosition();
      k = paramAbsListView.getChildCount();
    } while (k <= 0);
    int i = 0;
    label26:
    View localView;
    syh localsyh;
    if (i < k)
    {
      localView = paramAbsListView.getChildAt(i);
      localsyh = a(j + i);
      if (this.jdField_a_of_type_Int != 2) {
        break label69;
      }
      c(localsyh);
    }
    for (;;)
    {
      i += 1;
      break label26;
      break;
      label69:
      a(localsyh, localView);
    }
  }
  
  public void a(ArrayList<syh> paramArrayList)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      Collections.sort(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     syi
 * JD-Core Version:    0.7.0.1
 */