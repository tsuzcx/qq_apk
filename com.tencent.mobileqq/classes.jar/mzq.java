import android.content.Context;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.TabView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class mzq
{
  final int jdField_a_of_type_Int = 1;
  public TextView a;
  public PoiMapActivity.TabView a;
  public XListView a;
  public mzn a;
  final int b;
  final int c = 3;
  final int d = 4;
  public int e;
  public int f;
  public int g;
  
  public mzq(PoiMapActivity paramPoiMapActivity, Context paramContext, String paramString, int paramInt)
  {
    this.jdField_b_of_type_Int = 2;
    this.e = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((PoiMapActivity)paramContext).findViewById(2131372151));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramPoiMapActivity.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView = new PoiMapActivity.TabView(paramPoiMapActivity, paramContext, paramString, paramInt);
    this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(paramContext);
    this.jdField_a_of_type_Mzn = new mzn(paramPoiMapActivity);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Mzn);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new mzr(this, paramPoiMapActivity));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new mzs(this, paramPoiMapActivity));
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131693851));
      return;
    case 2: 
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131695384));
      return;
    case 3: 
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131695387));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPoiMapActivity.c)
    {
      this.jdField_a_of_type_Mzn.a(paramInt, paramBoolean);
      return;
    }
    if (this.e == 0) {
      if ((paramInt > 0) && (!this.jdField_a_of_type_Mzn.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPoiMapActivity.g)) {
        this.jdField_a_of_type_ComTencentBizPoiMapActivity.g = false;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Mzn.a(paramInt, paramBoolean);
      return;
      if (paramInt == -1) {}
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Mzn.a(paramString);
  }
  
  public void a(ArrayList<mzm> paramArrayList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      a(3);
    }
    do
    {
      return;
      if (paramArrayList == null)
      {
        a(1);
        return;
      }
      this.jdField_a_of_type_Mzn.a(paramArrayList, paramBoolean1, paramInt);
    } while (this.jdField_a_of_type_ComTencentBizPoiMapActivity.l != this.e);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    a(4);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_Mzn.getCount() > 0)
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
        a(4);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView.setSelect(paramBoolean);
      return;
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PoiMapActivity", 2, "POI list update isfirst = " + paramBoolean);
    }
    if ((this.f != this.jdField_a_of_type_ComTencentBizPoiMapActivity.h) || (this.g != this.jdField_a_of_type_ComTencentBizPoiMapActivity.i) || (!paramBoolean))
    {
      if (paramBoolean)
      {
        a(2);
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
        this.jdField_a_of_type_Mzn.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_Mzn.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_Mzn.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Mzn.notifyDataSetChanged();
      }
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity.h, this.jdField_a_of_type_ComTencentBizPoiMapActivity.i, "", this.jdField_a_of_type_ComTencentBizPoiMapActivity.b[this.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView.jdField_a_of_type_Int], this.jdField_a_of_type_Mzn.jdField_b_of_type_Int, 20);
      this.f = this.jdField_a_of_type_ComTencentBizPoiMapActivity.h;
      this.g = this.jdField_a_of_type_ComTencentBizPoiMapActivity.i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mzq
 * JD-Core Version:    0.7.0.1
 */