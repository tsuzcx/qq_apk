import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;
import java.util.List;

public class sck
  extends BaseAdapter
  implements baxz
{
  Activity jdField_a_of_type_AndroidAppActivity;
  public baxy a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  protected List<scj> a;
  private scf jdField_a_of_type_Scf;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public sck(Activity paramActivity, QQAppInterface paramQQAppInterface, scf paramscf)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(11);
    this.jdField_a_of_type_Baxy = new baxy(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_Baxy.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Scf = paramscf;
    this.jdField_a_of_type_Boolean = ThemeUtil.isInNightMode(paramQQAppInterface);
    if (Build.MANUFACTURER.toUpperCase().equals("XIAOMI")) {
      this.b = true;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(List<scj> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() >= 10) {}
      for (int i = 10;; i = paramList.size())
      {
        int j = 0;
        while (j < i)
        {
          a((scj)paramList.get(j));
          j += 1;
        }
      }
      paramList = new scj();
      paramList.a = -1L;
      a(paramList);
    }
  }
  
  public void a(scj paramscj)
  {
    if (paramscj != null) {
      this.jdField_a_of_type_JavaUtilList.add(paramscj);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Baxy.a(null);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt > getCount()) || (paramInt < 0)) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2131560113, null);
      paramView = new scl(this, localView, this.jdField_a_of_type_Boolean);
      localView.setVisibility(0);
      localView.setFocusable(false);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a((scj)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
      return localView;
      paramViewGroup = (scl)paramView.getTag();
      localView = paramView;
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sck
 * JD-Core Version:    0.7.0.1
 */