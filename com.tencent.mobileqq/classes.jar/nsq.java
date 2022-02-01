import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;

public class nsq
  extends BaseAdapter
{
  public int a;
  protected TextView a;
  public ArrayList<nsp> a;
  public boolean a;
  public int b;
  public boolean b;
  
  public nsq(PoiMapActivity paramPoiMapActivity)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public nsp a(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_Boolean) {
      i = paramInt + 1;
    }
    if ((i >= this.jdField_a_of_type_JavaUtilArrayList.size()) || (i < 0)) {
      return null;
    }
    return (nsp)this.jdField_a_of_type_JavaUtilArrayList.get(i);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {}
    nsp localnsp;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt == this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Int = paramInt;
        notifyDataSetChanged();
      } while ((paramInt == -1) || (!paramBoolean));
      localnsp = a(paramInt);
    } while (localnsp == null);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.l = localnsp.a;
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.m = localnsp.jdField_b_of_type_JavaLangString;
    PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity, localnsp.f);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_JavaLangString = localnsp.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.j = localnsp.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.k = localnsp.jdField_c_of_type_Int;
    PoiMapActivity.g(this.jdField_a_of_type_ComTencentBizPoiMapActivity).b();
    PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity).animateCamera(CameraUpdateFactory.newLatLng(new LatLng(localnsp.jdField_b_of_type_Int / 1000000.0D, localnsp.jdField_c_of_type_Int / 1000000.0D)));
  }
  
  public void a(String paramString)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void a(ArrayList<nsp> paramArrayList, boolean paramBoolean, int paramInt)
  {
    if (paramInt == this.jdField_b_of_type_Int)
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_b_of_type_Int += 1;
      notifyDataSetChanged();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    int j = 1;
    int i = 1;
    if (this.jdField_a_of_type_Boolean)
    {
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (this.jdField_b_of_type_Boolean) {}
      for (;;)
      {
        return i + (j - 1);
        i = 0;
      }
    }
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (this.jdField_b_of_type_Boolean) {}
    for (i = j;; i = 0) {
      return i + k;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      localObject1 = new nsr(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPoiMapActivity).inflate(2131560013, null);
      ((nsr)localObject1).jdField_b_of_type_AndroidViewView = paramView.findViewById(2131377524);
      ((nsr)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377523));
      ((nsr)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371815));
      ((nsr)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362211));
      ((nsr)localObject1).jdField_c_of_type_AndroidViewView = paramView.findViewById(2131377301);
      ((nsr)localObject1).jdField_d_of_type_AndroidViewView = paramView.findViewById(2131371562);
      ((nsr)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365562);
      ((nsr)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377522));
      ((nsr)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379645));
      ((nsr)localObject1).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131374839));
      paramView.setTag(localObject1);
      if ((paramInt != this.jdField_a_of_type_JavaUtilArrayList.size()) && ((!this.jdField_a_of_type_Boolean) || (paramInt != this.jdField_a_of_type_JavaUtilArrayList.size() - 1))) {
        break label247;
      }
      ((nsr)localObject1).jdField_d_of_type_AndroidViewView.setVisibility(0);
      ((nsr)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (Object localObject1 = paramView;; localObject1 = null)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject1 = (nsr)paramView.getTag();
      break;
      label247:
      localObject2 = a(paramInt);
      if ((paramInt == 0) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetTextView = ((nsr)localObject1).jdField_b_of_type_AndroidWidgetTextView;
      }
      if (localObject2 != null) {
        break label285;
      }
    }
    label285:
    ((nsr)localObject1).jdField_d_of_type_AndroidViewView.setVisibility(8);
    ((nsr)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    ((nsr)localObject1).jdField_b_of_type_AndroidViewView.setVisibility(8);
    ((nsr)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
    ((nsr)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
    ((nsr)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(this.jdField_a_of_type_ComTencentBizPoiMapActivity.d);
    ((nsr)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((nsp)localObject2).a);
    ((nsr)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((nsp)localObject2).jdField_b_of_type_JavaLangString);
    Object localObject2 = ((nsp)localObject2).a + ((nsp)localObject2).jdField_b_of_type_JavaLangString;
    if (paramInt == this.jdField_a_of_type_Int)
    {
      ((nsr)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.g);
      ((nsr)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.g);
      ((nsr)localObject1).jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    for (localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131694715);; localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131694716))
    {
      paramView.setContentDescription((CharSequence)localObject1);
      localObject1 = paramView;
      break;
      ((nsr)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_Int);
      ((nsr)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_Int);
      ((nsr)localObject1).jdField_c_of_type_AndroidViewView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nsq
 * JD-Core Version:    0.7.0.1
 */