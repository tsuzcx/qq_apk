import android.content.Context;
import android.content.res.Resources;
import android.widget.CheckBox;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.widget.ExpandableListView;
import java.util.List;

public class qhg
  extends qhn
{
  private qhx a;
  
  public qhg(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, boolean paramBoolean, qhx paramqhx)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView, paramBoolean);
    this.jdField_a_of_type_Qhx = paramqhx;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Qhx != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size() >= this.jdField_a_of_type_Qhx.b()))
    {
      String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718554, new Object[] { String.valueOf(this.jdField_a_of_type_Qhx.c()) });
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, str, 0).a();
      return;
    }
    bcpw.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718548), 0).a();
  }
  
  protected void a(qhv paramqhv, Friends paramFriends)
  {
    if ((paramFriends == null) || (this.jdField_a_of_type_Qhx == null) || (this.jdField_a_of_type_Qhx.a() == null) || (this.jdField_a_of_type_Qhx.a().isEmpty())) {
      return;
    }
    paramqhv.a.setBackgroundResource(2130848410);
    if (this.jdField_a_of_type_Qhx.a().contains(paramFriends.uin))
    {
      paramqhv.a.setEnabled(false);
      return;
    }
    paramqhv.a.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qhg
 * JD-Core Version:    0.7.0.1
 */