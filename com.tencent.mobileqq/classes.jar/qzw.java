import android.graphics.drawable.BitmapDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.widget.RangeButtonView;
import java.util.ArrayList;
import java.util.List;

public class qzw
{
  private int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bfve jdField_a_of_type_Bfve;
  private List<bfvi> jdField_a_of_type_JavaUtilList;
  private List<String> b;
  
  public qzw(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
  }
  
  public qzu a()
  {
    qzu localqzu = new qzu(null);
    Object localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559045, null);
    qzu.a(localqzu, new PopupWindow((View)localObject, -1, -2));
    qzu.a(localqzu).setBackgroundDrawable(new BitmapDrawable());
    qzu.a(localqzu).setOutsideTouchable(true);
    localObject = (RangeButtonView)((View)localObject).findViewById(2131366557);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(new bfvi(ajya.a(2131704709), TypedValue.applyDimension(1, 15.0F, ajwc.a)));
      this.jdField_a_of_type_JavaUtilList.add(new bfvi(ajya.a(2131704706), TypedValue.applyDimension(1, 16.0F, ajwc.a)));
      this.jdField_a_of_type_JavaUtilList.add(new bfvi(ajya.a(2131704707), TypedValue.applyDimension(1, 17.0F, ajwc.a)));
      this.jdField_a_of_type_JavaUtilList.add(new bfvi(ajya.a(2131704708), TypedValue.applyDimension(1, 18.0F, ajwc.a)));
      this.jdField_a_of_type_JavaUtilList.add(new bfvi(ajya.a(2131704710), TypedValue.applyDimension(1, 20.0F, ajwc.a)));
    }
    ((RangeButtonView)localObject).setTitleData(this.jdField_a_of_type_JavaUtilList);
    qzu.a(localqzu, this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Bfve != null) {
      ((RangeButtonView)localObject).setOnChangerListener(this.jdField_a_of_type_Bfve);
    }
    ((RangeButtonView)localObject).setThumbPosition(this.jdField_a_of_type_Int);
    if ((this.b == null) || (this.b.isEmpty()))
    {
      this.b = new ArrayList();
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691110));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691111));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691112));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691113));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691114));
    }
    ((RangeButtonView)localObject).setContentDescList(this.b);
    return localqzu;
  }
  
  public qzw a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public qzw a(bfve parambfve)
  {
    this.jdField_a_of_type_Bfve = parambfve;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qzw
 * JD-Core Version:    0.7.0.1
 */