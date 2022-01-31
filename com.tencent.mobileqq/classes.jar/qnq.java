import android.graphics.drawable.BitmapDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.widget.RangeButtonView;
import java.util.ArrayList;
import java.util.List;

public class qnq
{
  private int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bemt jdField_a_of_type_Bemt;
  private List<bemx> jdField_a_of_type_JavaUtilList;
  private List<String> b;
  
  public qnq(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
  }
  
  public qno a()
  {
    qno localqno = new qno(null);
    Object localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493482, null);
    qno.a(localqno, new PopupWindow((View)localObject, -1, -2));
    qno.a(localqno).setBackgroundDrawable(new BitmapDrawable());
    qno.a(localqno).setOutsideTouchable(true);
    localObject = (RangeButtonView)((View)localObject).findViewById(2131300948);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(new bemx(ajjy.a(2131638913), TypedValue.applyDimension(1, 15.0F, ajia.a)));
      this.jdField_a_of_type_JavaUtilList.add(new bemx(ajjy.a(2131638910), TypedValue.applyDimension(1, 16.0F, ajia.a)));
      this.jdField_a_of_type_JavaUtilList.add(new bemx(ajjy.a(2131638911), TypedValue.applyDimension(1, 17.0F, ajia.a)));
      this.jdField_a_of_type_JavaUtilList.add(new bemx(ajjy.a(2131638912), TypedValue.applyDimension(1, 18.0F, ajia.a)));
      this.jdField_a_of_type_JavaUtilList.add(new bemx(ajjy.a(2131638914), TypedValue.applyDimension(1, 20.0F, ajia.a)));
    }
    ((RangeButtonView)localObject).setTitleData(this.jdField_a_of_type_JavaUtilList);
    qno.a(localqno, this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Bemt != null) {
      ((RangeButtonView)localObject).setOnChangerListener(this.jdField_a_of_type_Bemt);
    }
    ((RangeButtonView)localObject).setThumbPosition(this.jdField_a_of_type_Int);
    if ((this.b == null) || (this.b.isEmpty()))
    {
      this.b = new ArrayList();
      this.b.add(BaseApplicationImpl.getApplication().getString(2131625538));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131625539));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131625540));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131625541));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131625542));
    }
    ((RangeButtonView)localObject).setContentDescList(this.b);
    return localqno;
  }
  
  public qnq a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public qnq a(bemt parambemt)
  {
    this.jdField_a_of_type_Bemt = parambemt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qnq
 * JD-Core Version:    0.7.0.1
 */