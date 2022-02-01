import android.content.Context;
import android.content.res.Resources;
import android.widget.CheckBox;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ExpandableListView;
import java.util.List;

public class say
  extends sbf
{
  private sbp a;
  
  public say(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, boolean paramBoolean, sbp paramsbp)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView, paramBoolean);
    this.jdField_a_of_type_Sbp = paramsbp;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Sbp != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size() >= this.jdField_a_of_type_Sbp.b()))
    {
      String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131717864, new Object[] { String.valueOf(this.jdField_a_of_type_Sbp.c()) });
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, str, 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131717858), 0).a();
  }
  
  protected void a(sbn paramsbn, Friends paramFriends)
  {
    if ((paramFriends == null) || (this.jdField_a_of_type_Sbp == null) || (this.jdField_a_of_type_Sbp.a() == null) || (this.jdField_a_of_type_Sbp.a().isEmpty())) {
      return;
    }
    paramsbn.a.setBackgroundResource(2130849413);
    if (this.jdField_a_of_type_Sbp.a().contains(paramFriends.uin))
    {
      paramsbn.a.setEnabled(false);
      return;
    }
    paramsbn.a.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     say
 * JD-Core Version:    0.7.0.1
 */