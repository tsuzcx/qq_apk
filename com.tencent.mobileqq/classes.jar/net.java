import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import com.tencent.avgame.ui.AVGameJoinRoomFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class net
  implements View.OnClickListener
{
  private bkho jdField_a_of_type_Bkho;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  List<Integer> jdField_a_of_type_JavaUtilList = null;
  boolean jdField_a_of_type_Boolean = false;
  
  public net(@NonNull BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bkho = null;
    if (this.jdField_a_of_type_Bkho == null) {
      this.jdField_a_of_type_Bkho = ((bkho)bkif.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null));
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      mwd localmwd = (mwd)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(373);
      if ((localmwd != null) && (localmwd.a()))
      {
        this.jdField_a_of_type_Bkho.a(2131690216, 0);
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1));
      }
      this.jdField_a_of_type_Bkho.a(2131690314, 0);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(2));
      this.jdField_a_of_type_Bkho.a(2131690315, 0);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(3));
      this.jdField_a_of_type_Bkho.c(2131690582);
      this.jdField_a_of_type_Bkho.a(new neu(this));
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  protected void b()
  {
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800B013", "0X800B013", 0, 0, "", "", "", "");
    mwd localmwd = (mwd)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(373);
    if ((localmwd != null) && (!TextUtils.isEmpty(localmwd.a())))
    {
      localmwd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 4, localmwd.a(), null);
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, 2131690358, 0).a();
  }
  
  protected void c()
  {
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800B011", "0X800B011", 0, 0, "", "", "", "");
    mwd localmwd = (mwd)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(373);
    if (localmwd != null)
    {
      localmwd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, 2131690357, 0).a();
  }
  
  protected void d()
  {
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800B012", "0X800B012", 0, 0, "", "", "", "");
    mwd localmwd = (mwd)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(373);
    if ((localmwd != null) && (localmwd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))) {
      return;
    }
    AVGameJoinRoomFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Bkho != null) && (!this.jdField_a_of_type_Bkho.isShowing())) {
      this.jdField_a_of_type_Boolean = false;
    }
    a();
    this.jdField_a_of_type_Bkho.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     net
 * JD-Core Version:    0.7.0.1
 */