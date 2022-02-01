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

public class sph
{
  private int jdField_a_of_type_Int = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private ArrayList<spg> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashSet<spg> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private HashSet<spg> b = new HashSet();
  private HashSet<spg> c = new HashSet();
  private HashSet<spg> d = new HashSet();
  
  public sph(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private spg a(int paramInt)
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
        spg localspg;
        if (j <= i)
        {
          k = j + i >>> 1;
          localspg = (spg)this.jdField_a_of_type_JavaUtilArrayList.get(k);
          m = localspg.jdField_a_of_type_Int - paramInt;
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
            localspg = (spg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
            return localspg;
          }
          localspg = null;
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
  
  private void a(spg paramspg)
  {
    if (this.c.contains(paramspg)) {}
    do
    {
      return;
      this.c.add(paramspg);
    } while ((!this.d.contains(paramspg)) || (this.jdField_a_of_type_JavaUtilHashSet.contains(paramspg)));
    this.jdField_a_of_type_JavaUtilHashSet.add(paramspg);
    d(paramspg);
  }
  
  private void a(spg paramspg, View paramView)
  {
    if (paramspg == null) {}
    do
    {
      return;
      paramView.getLocalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
      int i = this.jdField_a_of_type_AndroidGraphicsRect.height();
      long l = System.currentTimeMillis();
      if ((paramspg.jdField_a_of_type_Long == 0L) && (i > 0))
      {
        paramspg.jdField_a_of_type_Long = l;
        ThreadManager.getUIHandler().postDelayed(new ListAdExposeManager.1(this, paramspg), 1000L);
      }
      int j;
      for (;;)
      {
        j = paramView.getHeight();
        if ((i > 0) && (j > 0)) {
          break;
        }
        paramspg.jdField_a_of_type_Float = 0.0F;
        return;
        if (l > paramspg.jdField_a_of_type_Long + 1L)
        {
          paramspg.b = l;
          b(paramspg);
        }
      }
      paramspg.jdField_a_of_type_Float = (i / j);
    } while (paramspg.jdField_a_of_type_Float <= 0.5F);
    a(paramspg);
  }
  
  private void b(spg paramspg)
  {
    if (this.d.contains(paramspg)) {}
    do
    {
      return;
      this.d.add(paramspg);
    } while ((!this.c.contains(paramspg)) || (this.jdField_a_of_type_JavaUtilHashSet.contains(paramspg)));
    this.jdField_a_of_type_JavaUtilHashSet.add(paramspg);
    d(paramspg);
  }
  
  private void c(spg paramspg)
  {
    if (this.b.contains(paramspg)) {
      return;
    }
    this.b.add(paramspg);
    e(paramspg);
  }
  
  private void d(spg paramspg)
  {
    float f = paramspg.jdField_a_of_type_Float;
    long l = paramspg.b;
    paramspg = paramspg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if (paramspg == null) {
      return;
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject1.put("article_id", String.valueOf(paramspg.mArticleID));
      localJSONObject1.put("rowkey", String.valueOf(paramspg.mRowKey));
      paramspg.mBusiJson = localJSONObject1;
      localJSONObject2.put("exposureArea", f);
      localJSONObject2.put("exposureTime", l);
      paramspg.mReportDataJson = localJSONObject2;
      tku.a(false, this.jdField_a_of_type_AndroidContentContext, paramspg, nzq.aq, nzq.b, 2);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        tpx.a("ListAdExposeManager", localException.getMessage());
      }
    }
  }
  
  private void e(spg paramspg) {}
  
  public void a()
  {
    tpx.a("ListAdExposeManager", "clearCache");
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
    spg localspg;
    if (i < k)
    {
      localView = paramAbsListView.getChildAt(i);
      localspg = a(j + i);
      if (this.jdField_a_of_type_Int != 2) {
        break label69;
      }
      c(localspg);
    }
    for (;;)
    {
      i += 1;
      break label26;
      break;
      label69:
      a(localspg, localView);
    }
  }
  
  public void a(ArrayList<spg> paramArrayList)
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
 * Qualified Name:     sph
 * JD-Core Version:    0.7.0.1
 */