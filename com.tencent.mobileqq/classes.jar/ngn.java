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

public class ngn
  implements View.OnClickListener
{
  private blir jdField_a_of_type_Blir;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  List<Integer> jdField_a_of_type_JavaUtilList = null;
  boolean jdField_a_of_type_Boolean = false;
  
  public ngn(@NonNull BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Blir = null;
    if (this.jdField_a_of_type_Blir == null) {
      this.jdField_a_of_type_Blir = ((blir)blji.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null));
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      mxc localmxc = (mxc)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(373);
      if ((localmxc != null) && (localmxc.a()))
      {
        this.jdField_a_of_type_Blir.a(2131690226, 0);
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1));
      }
      this.jdField_a_of_type_Blir.a(2131690317, 0);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(2));
      this.jdField_a_of_type_Blir.a(2131690318, 0);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(3));
      this.jdField_a_of_type_Blir.c(2131690580);
      this.jdField_a_of_type_Blir.a(new ngo(this));
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  protected void b()
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800B013", "0X800B013", 0, 0, "", "", "", "");
    mxc localmxc = (mxc)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(373);
    if ((localmxc != null) && (!TextUtils.isEmpty(localmxc.a())))
    {
      localmxc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 4, localmxc.a(), null);
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, 2131690356, 0).a();
  }
  
  protected void c()
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800B011", "0X800B011", 0, 0, "", "", "", "");
    mxc localmxc = (mxc)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(373);
    if (localmxc != null)
    {
      localmxc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, 2131690355, 0).a();
  }
  
  protected void d()
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800B012", "0X800B012", 0, 0, "", "", "", "");
    mxc localmxc = (mxc)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(373);
    if ((localmxc != null) && (localmxc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))) {
      return;
    }
    AVGameJoinRoomFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Blir != null) && (!this.jdField_a_of_type_Blir.isShowing())) {
      this.jdField_a_of_type_Boolean = false;
    }
    a();
    this.jdField_a_of_type_Blir.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngn
 * JD-Core Version:    0.7.0.1
 */