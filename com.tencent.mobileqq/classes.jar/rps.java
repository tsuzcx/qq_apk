import android.graphics.drawable.BitmapDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.widget.RangeButtonView;
import java.util.ArrayList;
import java.util.List;

public class rps
{
  private int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bhwb jdField_a_of_type_Bhwb;
  private List<bhwf> jdField_a_of_type_JavaUtilList;
  private List<String> b;
  
  public rps(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
  }
  
  public rpq a()
  {
    rpq localrpq = new rpq(null);
    Object localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559086, null);
    rpq.a(localrpq, new PopupWindow((View)localObject, -1, -2));
    rpq.a(localrpq).setBackgroundDrawable(new BitmapDrawable());
    rpq.a(localrpq).setOutsideTouchable(true);
    localObject = (RangeButtonView)((View)localObject).findViewById(2131366672);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(new bhwf(alpo.a(2131705081), TypedValue.applyDimension(1, 15.0F, alnq.a)));
      this.jdField_a_of_type_JavaUtilList.add(new bhwf(alpo.a(2131705078), TypedValue.applyDimension(1, 16.0F, alnq.a)));
      this.jdField_a_of_type_JavaUtilList.add(new bhwf(alpo.a(2131705079), TypedValue.applyDimension(1, 17.0F, alnq.a)));
      this.jdField_a_of_type_JavaUtilList.add(new bhwf(alpo.a(2131705080), TypedValue.applyDimension(1, 18.0F, alnq.a)));
      this.jdField_a_of_type_JavaUtilList.add(new bhwf(alpo.a(2131705082), TypedValue.applyDimension(1, 20.0F, alnq.a)));
    }
    ((RangeButtonView)localObject).setTitleData(this.jdField_a_of_type_JavaUtilList);
    rpq.a(localrpq, this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Bhwb != null) {
      ((RangeButtonView)localObject).setOnChangerListener(this.jdField_a_of_type_Bhwb);
    }
    ((RangeButtonView)localObject).setThumbPosition(this.jdField_a_of_type_Int);
    if ((this.b == null) || (this.b.isEmpty()))
    {
      this.b = new ArrayList();
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691163));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691164));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691165));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691166));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691167));
    }
    ((RangeButtonView)localObject).setContentDescList(this.b);
    return localrpq;
  }
  
  public rps a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public rps a(bhwb parambhwb)
  {
    this.jdField_a_of_type_Bhwb = parambhwb;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rps
 * JD-Core Version:    0.7.0.1
 */