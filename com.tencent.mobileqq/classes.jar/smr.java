import android.graphics.drawable.BitmapDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.widget.RangeButtonView;
import java.util.ArrayList;
import java.util.List;

public class smr
{
  private int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bknt jdField_a_of_type_Bknt;
  private List<bknx> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private List<String> b;
  
  public smr(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
  }
  
  private float a(float paramFloat)
  {
    float f = TypedValue.applyDimension(1, 16.0F, anll.a);
    if (paramFloat == 15.0F) {
      f = TypedValue.applyDimension(1, 15.0F, anll.a);
    }
    do
    {
      return f;
      if (paramFloat == 17.0F) {
        return TypedValue.applyDimension(1, 17.0F, anll.a);
      }
      if (paramFloat == 18.0F) {
        return TypedValue.applyDimension(1, 18.0F, anll.a);
      }
    } while (paramFloat != 20.0F);
    return TypedValue.applyDimension(1, 20.0F, anll.a);
  }
  
  public smp a()
  {
    smp localsmp = new smp(null);
    Object localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559154, null);
    smp.a(localsmp, new PopupWindow((View)localObject, -1, -2));
    smp.a(localsmp).setBackgroundDrawable(new BitmapDrawable());
    smp.a(localsmp).setOutsideTouchable(true);
    localObject = (RangeButtonView)((View)localObject).findViewById(2131366944);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(new bknx(anni.a(2131703489), a(15.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new bknx(anni.a(2131703486), a(16.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new bknx("", a(17.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new bknx("", a(18.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new bknx(anni.a(2131701226), a(20.0F)));
    }
    ((RangeButtonView)localObject).setTitleData(this.jdField_a_of_type_JavaUtilList);
    smp.a(localsmp, this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Bknt != null) {
      ((RangeButtonView)localObject).setOnChangerListener(this.jdField_a_of_type_Bknt);
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
    smp.a(localsmp, this.jdField_a_of_type_Boolean);
    return localsmp;
  }
  
  public smr a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public smr a(bknt parambknt)
  {
    this.jdField_a_of_type_Bknt = parambknt;
    return this;
  }
  
  public smr a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     smr
 * JD-Core Version:    0.7.0.1
 */