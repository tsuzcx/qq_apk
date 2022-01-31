import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class rjw
  extends BaseAdapter
  implements rkl, rkm
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new rjx(this);
  private baxk jdField_a_of_type_Baxk;
  private List<BaseData> jdField_a_of_type_JavaUtilList;
  private rkk[] jdField_a_of_type_ArrayOfRkk;
  private float jdField_b_of_type_Float = 14.0F;
  private int jdField_b_of_type_Int = 16;
  private int c = 18;
  private int d = -1;
  
  public rjw(Context paramContext, List<BaseData> paramList, baxk parambaxk)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Baxk = parambaxk;
    f();
    g();
  }
  
  private int a(int paramInt, View paramView)
  {
    try
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(this.d, -2147483648), 0);
      paramInt = paramView.getMeasuredHeight();
      return paramInt;
    }
    catch (Exception paramView)
    {
      QLog.d("WebFastAdapter", 1, paramView, new Object[] { " getItemMeasureHeight error! msg=" + paramView });
    }
    return 0;
  }
  
  private void f()
  {
    rlv localrlv = new rlv();
    this.jdField_a_of_type_ArrayOfRkk = new rkk[] { new rkn(), new rks(), new rlh(), new nys(), new rld(), new nyw(), new nza(), new nze(), localrlv };
    localrlv.a(this);
    localrlv.a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void g()
  {
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(String.valueOf(bhvh.a("local_kd_native_main_text_style")));
        localIterator = localJSONObject.keys();
        boolean bool = localIterator.hasNext();
        if (!bool) {}
      }
      catch (Exception localException1)
      {
        try
        {
          JSONObject localJSONObject;
          Iterator localIterator;
          String str1 = (String)localIterator.next();
          String str2 = localJSONObject.getString(str1);
          if ("native_main_text_color".equalsIgnoreCase(str1))
          {
            this.jdField_a_of_type_Int = Color.parseColor(str2);
            continue;
          }
          if ("native_main_text_size".equalsIgnoreCase(str1))
          {
            this.jdField_a_of_type_Float = Integer.valueOf(str2).intValue();
            this.jdField_a_of_type_Float = Utils.dp2px(Double.valueOf(this.jdField_a_of_type_Float).doubleValue());
            continue;
          }
          if ("native_main_text_row_space".equalsIgnoreCase(str1))
          {
            this.jdField_b_of_type_Float = Integer.valueOf(str2).intValue();
            continue;
          }
          if ("native_main_text_segment_space".equalsIgnoreCase(str1))
          {
            this.jdField_b_of_type_Int = Integer.valueOf(str2).intValue();
            continue;
          }
          if (!"native_main_text_margin_side".equalsIgnoreCase(str1)) {
            continue;
          }
          this.c = Integer.valueOf(str2).intValue();
        }
        catch (Exception localException2) {}
        localException1 = localException1;
      }
      return;
    }
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localBaseData == null)
    {
      actn.a("Q.readinjoy.fast_web", "", new NullPointerException());
      paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
    }
    do
    {
      do
      {
        do
        {
          return paramViewGroup;
          try
          {
            localBaseData.q = paramInt;
            if (paramView != null) {
              break label261;
            }
            paramView = a(localBaseData);
            if (paramView == null) {
              break;
            }
            paramView = paramView.a(this.jdField_a_of_type_AndroidContentContext, localBaseData, paramViewGroup);
            paramView.a(this);
            paramViewGroup = paramView.jdField_a_of_type_AndroidViewView;
            paramViewGroup.setTag(paramView);
            localObject = paramView;
            paramView = paramViewGroup;
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              QLog.d("WebFastAdapter", 1, "getView error,msg:" + paramView.toString());
              paramView = new View(this.jdField_a_of_type_AndroidContentContext);
              paramView.setVisibility(8);
              continue;
              paramViewGroup = (rkj)paramView.getTag();
              Object localObject = paramViewGroup;
            }
          }
          ((rkj)localObject).jdField_a_of_type_Float = this.jdField_a_of_type_Float;
          ((rkj)localObject).jdField_b_of_type_Float = this.jdField_b_of_type_Float;
          ((rkj)localObject).c = this.jdField_b_of_type_Int;
          ((rkj)localObject).d = this.c;
          ((rkj)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_Int;
          ((rkj)localObject).b(((rkj)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, localBaseData, paramBoolean);
          paramViewGroup = paramView;
        } while (this.d <= 0);
        paramViewGroup = paramView;
      } while (localBaseData.r > 0);
      paramInt = a(paramInt, paramView);
      paramViewGroup = paramView;
    } while (paramInt <= 0);
    localBaseData.r = paramInt;
    return paramView;
    throw new NullPointerException();
  }
  
  public List<BaseData> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public rkk a(BaseData paramBaseData)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfRkk.length)
    {
      if (this.jdField_a_of_type_ArrayOfRkk[i].a(paramBaseData)) {
        return this.jdField_a_of_type_ArrayOfRkk[i];
      }
      i += 1;
    }
    throw new IllegalArgumentException("no suitable creator: " + paramBaseData.p);
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfRkk.length)
    {
      if ((this.jdField_a_of_type_ArrayOfRkk[i] instanceof rkm)) {
        ((rkm)this.jdField_a_of_type_ArrayOfRkk[i]).a();
      }
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(BaseData paramBaseData) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfRkk.length)
    {
      if ((this.jdField_a_of_type_ArrayOfRkk[i] instanceof rkm)) {
        ((rkm)this.jdField_a_of_type_ArrayOfRkk[i]).a(paramAbsListView, paramInt);
      }
      i += 1;
    }
  }
  
  public void b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfRkk.length)
    {
      if ((this.jdField_a_of_type_ArrayOfRkk[i] instanceof rkm)) {
        ((rkm)this.jdField_a_of_type_ArrayOfRkk[i]).b();
      }
      i += 1;
    }
  }
  
  public void c()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfRkk.length)
    {
      if ((this.jdField_a_of_type_ArrayOfRkk[i] instanceof rkm)) {
        ((rkm)this.jdField_a_of_type_ArrayOfRkk[i]).c();
      }
      i += 1;
    }
  }
  
  public void d()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfRkk.length)
    {
      if ((this.jdField_a_of_type_ArrayOfRkk[i] instanceof rkm)) {
        ((rkm)this.jdField_a_of_type_ArrayOfRkk[i]).d();
      }
      i += 1;
    }
  }
  
  public void e()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfRkk.length)
    {
      if ((this.jdField_a_of_type_ArrayOfRkk[i] instanceof rkm)) {
        ((rkm)this.jdField_a_of_type_ArrayOfRkk[i]).e();
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return (BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return -1;
    }
    BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    return a(localBaseData).a(localBaseData);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return a(paramInt, paramView, paramViewGroup, false);
  }
  
  public int getViewTypeCount()
  {
    return rkj.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rjw
 * JD-Core Version:    0.7.0.1
 */