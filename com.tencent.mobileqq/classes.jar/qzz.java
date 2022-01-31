import android.graphics.drawable.BitmapDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.widget.RangeButtonView;
import java.util.ArrayList;
import java.util.List;

public class qzz
{
  private int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bfun jdField_a_of_type_Bfun;
  private List<bfur> jdField_a_of_type_JavaUtilList;
  private List<String> b;
  
  public qzz(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
  }
  
  public qzx a()
  {
    qzx localqzx = new qzx(null);
    Object localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559045, null);
    qzx.a(localqzx, new PopupWindow((View)localObject, -1, -2));
    qzx.a(localqzx).setBackgroundDrawable(new BitmapDrawable());
    qzx.a(localqzx).setOutsideTouchable(true);
    localObject = (RangeButtonView)((View)localObject).findViewById(2131366557);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(new bfur(ajyc.a(2131704698), TypedValue.applyDimension(1, 15.0F, ajwe.a)));
      this.jdField_a_of_type_JavaUtilList.add(new bfur(ajyc.a(2131704695), TypedValue.applyDimension(1, 16.0F, ajwe.a)));
      this.jdField_a_of_type_JavaUtilList.add(new bfur(ajyc.a(2131704696), TypedValue.applyDimension(1, 17.0F, ajwe.a)));
      this.jdField_a_of_type_JavaUtilList.add(new bfur(ajyc.a(2131704697), TypedValue.applyDimension(1, 18.0F, ajwe.a)));
      this.jdField_a_of_type_JavaUtilList.add(new bfur(ajyc.a(2131704699), TypedValue.applyDimension(1, 20.0F, ajwe.a)));
    }
    ((RangeButtonView)localObject).setTitleData(this.jdField_a_of_type_JavaUtilList);
    qzx.a(localqzx, this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Bfun != null) {
      ((RangeButtonView)localObject).setOnChangerListener(this.jdField_a_of_type_Bfun);
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
    return localqzx;
  }
  
  public qzz a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public qzz a(bfun parambfun)
  {
    this.jdField_a_of_type_Bfun = parambfun;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qzz
 * JD-Core Version:    0.7.0.1
 */