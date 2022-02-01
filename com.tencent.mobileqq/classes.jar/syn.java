import android.graphics.drawable.BitmapDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.widget.RangeButtonView;
import java.util.ArrayList;
import java.util.List;

public class syn
{
  private int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bles jdField_a_of_type_Bles;
  private List<blew> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private List<String> b;
  
  public syn(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
  }
  
  private float a(float paramFloat)
  {
    float f = TypedValue.applyDimension(1, 16.0F, FontSettingManager.systemMetrics);
    if (paramFloat == 15.0F) {
      f = TypedValue.applyDimension(1, 15.0F, FontSettingManager.systemMetrics);
    }
    do
    {
      return f;
      if (paramFloat == 17.0F) {
        return TypedValue.applyDimension(1, 17.0F, FontSettingManager.systemMetrics);
      }
      if (paramFloat == 18.0F) {
        return TypedValue.applyDimension(1, 18.0F, FontSettingManager.systemMetrics);
      }
    } while (paramFloat != 20.0F);
    return TypedValue.applyDimension(1, 20.0F, FontSettingManager.systemMetrics);
  }
  
  public syl a()
  {
    syl localsyl = new syl(null);
    Object localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559190, null);
    syl.a(localsyl, new PopupWindow((View)localObject, -1, -2));
    syl.a(localsyl).setBackgroundDrawable(new BitmapDrawable());
    syl.a(localsyl).setOutsideTouchable(true);
    localObject = (RangeButtonView)((View)localObject).findViewById(2131367127);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(new blew(anvx.a(2131704177), a(15.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new blew(anvx.a(2131704174), a(16.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new blew("", a(17.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new blew("", a(18.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new blew(anvx.a(2131701919), a(20.0F)));
    }
    ((RangeButtonView)localObject).setTitleData(this.jdField_a_of_type_JavaUtilList);
    syl.a(localsyl, this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Bles != null) {
      ((RangeButtonView)localObject).setOnChangerListener(this.jdField_a_of_type_Bles);
    }
    ((RangeButtonView)localObject).setThumbPosition(this.jdField_a_of_type_Int);
    if ((this.b == null) || (this.b.isEmpty()))
    {
      this.b = new ArrayList();
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691092));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691093));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691094));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691095));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691096));
    }
    ((RangeButtonView)localObject).setContentDescList(this.b);
    syl.a(localsyl, this.jdField_a_of_type_Boolean);
    return localsyl;
  }
  
  public syn a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public syn a(bles parambles)
  {
    this.jdField_a_of_type_Bles = parambles;
    return this;
  }
  
  public syn a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     syn
 * JD-Core Version:    0.7.0.1
 */