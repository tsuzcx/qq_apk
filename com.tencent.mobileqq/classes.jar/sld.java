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

public class sld
{
  private int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bjtg jdField_a_of_type_Bjtg;
  private List<bjtk> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private List<String> b;
  
  public sld(LayoutInflater paramLayoutInflater)
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
  
  public slb a()
  {
    slb localslb = new slb(null);
    Object localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559161, null);
    slb.a(localslb, new PopupWindow((View)localObject, -1, -2));
    slb.a(localslb).setBackgroundDrawable(new BitmapDrawable());
    slb.a(localslb).setOutsideTouchable(true);
    localObject = (RangeButtonView)((View)localObject).findViewById(2131367009);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(new bjtk(amtj.a(2131703826), a(15.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new bjtk(amtj.a(2131703823), a(16.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new bjtk("", a(17.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new bjtk("", a(18.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new bjtk(amtj.a(2131701568), a(20.0F)));
    }
    ((RangeButtonView)localObject).setTitleData(this.jdField_a_of_type_JavaUtilList);
    slb.a(localslb, this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Bjtg != null) {
      ((RangeButtonView)localObject).setOnChangerListener(this.jdField_a_of_type_Bjtg);
    }
    ((RangeButtonView)localObject).setThumbPosition(this.jdField_a_of_type_Int);
    if ((this.b == null) || (this.b.isEmpty()))
    {
      this.b = new ArrayList();
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691007));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691008));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691009));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691010));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691011));
    }
    ((RangeButtonView)localObject).setContentDescList(this.b);
    slb.a(localslb, this.jdField_a_of_type_Boolean);
    return localslb;
  }
  
  public sld a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public sld a(bjtg parambjtg)
  {
    this.jdField_a_of_type_Bjtg = parambjtg;
    return this;
  }
  
  public sld a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sld
 * JD-Core Version:    0.7.0.1
 */