import android.content.Context;
import android.content.res.Resources;
import android.widget.CheckBox;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ExpandableListView;
import java.util.List;

public class rhj
  extends rhq
{
  private ria a;
  
  public rhj(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, boolean paramBoolean, ria paramria)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView, paramBoolean);
    this.jdField_a_of_type_Ria = paramria;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Ria != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size() >= this.jdField_a_of_type_Ria.b()))
    {
      String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131717267, new Object[] { String.valueOf(this.jdField_a_of_type_Ria.c()) });
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, str, 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131717261), 0).a();
  }
  
  protected void a(rhy paramrhy, Friends paramFriends)
  {
    if ((paramFriends == null) || (this.jdField_a_of_type_Ria == null) || (this.jdField_a_of_type_Ria.a() == null) || (this.jdField_a_of_type_Ria.a().isEmpty())) {
      return;
    }
    paramrhy.a.setBackgroundResource(2130849409);
    if (this.jdField_a_of_type_Ria.a().contains(paramFriends.uin))
    {
      paramrhy.a.setEnabled(false);
      return;
    }
    paramrhy.a.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rhj
 * JD-Core Version:    0.7.0.1
 */