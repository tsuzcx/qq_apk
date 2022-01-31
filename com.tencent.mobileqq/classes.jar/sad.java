import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class sad
  implements rzu
{
  private final XListView jdField_a_of_type_ComTencentWidgetXListView;
  private final List<BaseData> jdField_a_of_type_JavaUtilList;
  
  public sad(XListView paramXListView, List<BaseData> paramList, rzr paramrzr)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramrzr.a(this);
  }
  
  private rzr a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() instanceof bhxm))
    {
      bhxm localbhxm = (bhxm)this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter();
      if ((localbhxm.getWrappedAdapter() instanceof rzr)) {
        return (rzr)localbhxm.getWrappedAdapter();
      }
    }
    return null;
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (paramInt < 0)) {
      return true;
    }
    if ((BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt) == null)
    {
      aepi.a("ItemHeightHelper", "", new IllegalArgumentException(" data == null index: " + paramInt + "   itemArrayList.size() :" + this.jdField_a_of_type_JavaUtilList.size()));
      return true;
    }
    return false;
  }
  
  private int b(int paramInt)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getWidth();
    int i = Utils.dp2px(300.0D);
    j = View.MeasureSpec.makeMeasureSpec(j, -2147483648);
    if ((Build.VERSION.SDK_INT <= 19) && (paramInt == 0)) {}
    Object localObject;
    do
    {
      return i;
      localObject = a();
    } while (localObject == null);
    try
    {
      localObject = ((rzr)localObject).a(paramInt, null, this.jdField_a_of_type_ComTencentWidgetXListView, true);
      ((View)localObject).measure(j, 0);
      j = ((View)localObject).getMeasuredHeight();
      QLog.d("ItemHeightHelper", 2, "getItemMeasureHeight index : " + paramInt + " height : " + j);
      return j;
    }
    catch (Exception localException)
    {
      QLog.d("ItemHeightHelper", 2, localException, new Object[] { " index : " + paramInt });
    }
    return i;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int a(int paramInt)
  {
    if (a(paramInt)) {
      return -1;
    }
    BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localBaseData.u > 0) {
      return localBaseData.u;
    }
    localBaseData.u = b(paramInt);
    return localBaseData.u;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (a(paramInt1)) {
      return;
    }
    ((BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).u = paramInt2;
    QLog.d("ItemHeightHelper", 2, " index : " + paramInt1 + "   height: " + paramInt2);
  }
  
  public void a(int paramInt, View paramView)
  {
    if (a(paramInt)) {}
    while (((BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt)).u > 0) {
      return;
    }
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(new sae(this, paramInt, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sad
 * JD-Core Version:    0.7.0.1
 */