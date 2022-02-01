import android.graphics.drawable.BitmapDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.widget.RangeButtonView;
import java.util.ArrayList;
import java.util.List;

public class sdv
{
  private int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private blow jdField_a_of_type_Blow;
  private List<blpa> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private List<String> b;
  
  public sdv(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
  }
  
  private float a(float paramFloat)
  {
    float f = TypedValue.applyDimension(1, 16.0F, anxh.a);
    if (paramFloat == 15.0F) {
      f = TypedValue.applyDimension(1, 15.0F, anxh.a);
    }
    do
    {
      return f;
      if (paramFloat == 17.0F) {
        return TypedValue.applyDimension(1, 17.0F, anxh.a);
      }
      if (paramFloat == 18.0F) {
        return TypedValue.applyDimension(1, 18.0F, anxh.a);
      }
    } while (paramFloat != 20.0F);
    return TypedValue.applyDimension(1, 20.0F, anxh.a);
  }
  
  public sdt a()
  {
    sdt localsdt = new sdt(null);
    Object localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559154, null);
    sdt.a(localsdt, new PopupWindow((View)localObject, -1, -2));
    sdt.a(localsdt).setBackgroundDrawable(new BitmapDrawable());
    sdt.a(localsdt).setOutsideTouchable(true);
    localObject = (RangeButtonView)((View)localObject).findViewById(2131366995);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(new blpa(anzj.a(2131703596), a(15.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new blpa(anzj.a(2131703593), a(16.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new blpa("", a(17.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new blpa("", a(18.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new blpa(anzj.a(2131701333), a(20.0F)));
    }
    ((RangeButtonView)localObject).setTitleData(this.jdField_a_of_type_JavaUtilList);
    sdt.a(localsdt, this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Blow != null) {
      ((RangeButtonView)localObject).setOnChangerListener(this.jdField_a_of_type_Blow);
    }
    ((RangeButtonView)localObject).setThumbPosition(this.jdField_a_of_type_Int);
    if ((this.b == null) || (this.b.isEmpty()))
    {
      this.b = new ArrayList();
      this.b.add(BaseApplicationImpl.getApplication().getString(2131690967));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131690968));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131690969));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131690970));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131690971));
    }
    ((RangeButtonView)localObject).setContentDescList(this.b);
    sdt.a(localsdt, this.jdField_a_of_type_Boolean);
    return localsdt;
  }
  
  public sdv a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public sdv a(blow paramblow)
  {
    this.jdField_a_of_type_Blow = paramblow;
    return this;
  }
  
  public sdv a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sdv
 * JD-Core Version:    0.7.0.1
 */