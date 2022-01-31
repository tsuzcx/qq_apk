package cooperation.qqfav.widget;

import ampl;
import ampm;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqfav.QfavReport;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class FavoriteActionSheet
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 1;
  public ActionSheet a;
  public FavoriteActionSheet.Actions a;
  public List a;
  AppRuntime jdField_a_of_type_MqqAppAppRuntime = null;
  public boolean a;
  int b;
  public List b;
  
  public FavoriteActionSheet(Activity paramActivity, FavoriteActionSheet.Actions paramActions, int paramInt1, int paramInt2, AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions = paramActions;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(paramActivity, null));
    if ((this.jdField_a_of_type_Int & 0x10) != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131434552, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(16));
    }
    if ((this.jdField_a_of_type_Int & 0x20) != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131431711, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(32));
    }
    if ((this.jdField_a_of_type_Int & 0x40) != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131431729, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(64));
    }
    if ((this.jdField_a_of_type_Int & 0x1) != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131435083, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1));
    }
    if ((this.jdField_a_of_type_Int & 0x2) != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131430005, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(2));
    }
    if ((this.jdField_a_of_type_Int & 0x4) != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131431563, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(4));
    }
    if ((this.jdField_a_of_type_Int & 0x8) != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131428216, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(8));
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433015);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new ampl(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new ampm(this));
  }
  
  private void b()
  {
    QfavReport.a(this.jdField_a_of_type_MqqAppAppRuntime, "User_Forward", this.jdField_b_of_type_Int, 0, 0);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
    {
      if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
        break label44;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      if (QLog.isDevelopLevel()) {
        QLog.d("qqfav.FavoriteActionSheet", 4, "dismiss|showing");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
      return;
      label44:
      if (QLog.isDevelopLevel()) {
        QLog.d("qqfav.FavoriteActionSheet", 4, "dismiss|not showing");
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramString, 5);
    this.jdField_b_of_type_JavaUtilList.add(paramString);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.widget.FavoriteActionSheet
 * JD-Core Version:    0.7.0.1
 */