import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;

public class mly
  extends BaseAdapter
{
  public int a;
  protected TextView a;
  public ArrayList<mlx> a;
  public boolean a;
  public int b;
  public boolean b;
  
  public mly(PoiMapActivity paramPoiMapActivity)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public mlx a(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_Boolean) {
      i = paramInt + 1;
    }
    if ((i >= this.jdField_a_of_type_JavaUtilArrayList.size()) || (i < 0)) {
      return null;
    }
    return (mlx)this.jdField_a_of_type_JavaUtilArrayList.get(i);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {}
    mlx localmlx;
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
      localmlx = a(paramInt);
    } while (localmlx == null);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.l = localmlx.a;
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.m = localmlx.jdField_b_of_type_JavaLangString;
    PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity, localmlx.f);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_JavaLangString = localmlx.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.j = localmlx.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.k = localmlx.jdField_c_of_type_Int;
    com.tencent.mobileqq.widget.QQMapView.jdField_b_of_type_Boolean = true;
    PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity).animateCamera(CameraUpdateFactory.newLatLng(new LatLng(localmlx.jdField_b_of_type_Int / 1000000.0D, localmlx.jdField_c_of_type_Int / 1000000.0D)));
  }
  
  public void a(String paramString)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void a(ArrayList<mlx> paramArrayList, boolean paramBoolean, int paramInt)
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
      paramViewGroup = new mlz(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPoiMapActivity).inflate(2131494190, null);
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131310235);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131310234));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131304994));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296588));
      paramViewGroup.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131310033);
      paramViewGroup.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131304762);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131299498);
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131310233));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131312113));
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131307756));
      paramView.setTag(paramViewGroup);
    }
    while ((paramInt == this.jdField_a_of_type_JavaUtilArrayList.size()) || ((this.jdField_a_of_type_Boolean) && (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size() - 1)))
    {
      paramViewGroup.jdField_d_of_type_AndroidViewView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return paramView;
      paramViewGroup = (mlz)paramView.getTag();
    }
    Object localObject = a(paramInt);
    if ((paramInt == 0) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidWidgetTextView = paramViewGroup.jdField_b_of_type_AndroidWidgetTextView;
    }
    if (localObject == null) {
      return null;
    }
    paramViewGroup.jdField_d_of_type_AndroidViewView.setVisibility(8);
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
    paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
    paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
    paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.jdField_a_of_type_ComTencentBizPoiMapActivity.d);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((mlx)localObject).a);
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(((mlx)localObject).jdField_b_of_type_JavaLangString);
    localObject = ((mlx)localObject).a + ((mlx)localObject).jdField_b_of_type_JavaLangString;
    if (paramInt == this.jdField_a_of_type_Int)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.g);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.g);
      paramViewGroup.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    for (paramViewGroup = (String)localObject + this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131629548);; paramViewGroup = (String)localObject + this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131629549))
    {
      paramView.setContentDescription(paramViewGroup);
      return paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_Int);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_Int);
      paramViewGroup.jdField_c_of_type_AndroidViewView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mly
 * JD-Core Version:    0.7.0.1
 */