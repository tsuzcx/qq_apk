import android.content.Context;
import android.content.res.Resources;
import android.widget.CheckBox;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ExpandableListView;
import java.util.List;

public class qvi
  extends qvp
{
  private qvz a;
  
  public qvi(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, boolean paramBoolean, qvz paramqvz)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView, paramBoolean);
    this.jdField_a_of_type_Qvz = paramqvz;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Qvz != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size() >= this.jdField_a_of_type_Qvz.b()))
    {
      String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719026, new Object[] { String.valueOf(this.jdField_a_of_type_Qvz.c()) });
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, str, 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719020), 0).a();
  }
  
  protected void a(qvx paramqvx, Friends paramFriends)
  {
    if ((paramFriends == null) || (this.jdField_a_of_type_Qvz == null) || (this.jdField_a_of_type_Qvz.a() == null) || (this.jdField_a_of_type_Qvz.a().isEmpty())) {
      return;
    }
    paramqvx.a.setBackgroundResource(2130848902);
    if (this.jdField_a_of_type_Qvz.a().contains(paramFriends.uin))
    {
      paramqvx.a.setEnabled(false);
      return;
    }
    paramqvx.a.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qvi
 * JD-Core Version:    0.7.0.1
 */