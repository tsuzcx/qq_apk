import android.content.Context;
import android.content.res.Resources;
import android.widget.CheckBox;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.widget.ExpandableListView;
import java.util.List;

public class qhd
  extends qhk
{
  private qhu a;
  
  public qhd(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, boolean paramBoolean, qhu paramqhu)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView, paramBoolean);
    this.jdField_a_of_type_Qhu = paramqhu;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Qhu != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size() >= this.jdField_a_of_type_Qhu.b()))
    {
      String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718565, new Object[] { String.valueOf(this.jdField_a_of_type_Qhu.c()) });
      bcql.a(this.jdField_a_of_type_AndroidContentContext, str, 0).a();
      return;
    }
    bcql.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718559), 0).a();
  }
  
  protected void a(qhs paramqhs, Friends paramFriends)
  {
    if ((paramFriends == null) || (this.jdField_a_of_type_Qhu == null) || (this.jdField_a_of_type_Qhu.a() == null) || (this.jdField_a_of_type_Qhu.a().isEmpty())) {
      return;
    }
    paramqhs.a.setBackgroundResource(2130848416);
    if (this.jdField_a_of_type_Qhu.a().contains(paramFriends.uin))
    {
      paramqhs.a.setEnabled(false);
      return;
    }
    paramqhs.a.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qhd
 * JD-Core Version:    0.7.0.1
 */