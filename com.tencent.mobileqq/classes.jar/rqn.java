import android.content.Context;
import android.content.res.Resources;
import android.widget.CheckBox;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ExpandableListView;
import java.util.List;

public class rqn
  extends rqu
{
  private rre a;
  
  public rqn(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, boolean paramBoolean, rre paramrre)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView, paramBoolean);
    this.jdField_a_of_type_Rre = paramrre;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Rre != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size() >= this.jdField_a_of_type_Rre.b()))
    {
      String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131717150, new Object[] { String.valueOf(this.jdField_a_of_type_Rre.c()) });
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, str, 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131717144), 0).a();
  }
  
  protected void a(rrc paramrrc, Friends paramFriends)
  {
    if ((paramFriends == null) || (this.jdField_a_of_type_Rre == null) || (this.jdField_a_of_type_Rre.a() == null) || (this.jdField_a_of_type_Rre.a().isEmpty())) {
      return;
    }
    paramrrc.a.setBackgroundResource(2130849390);
    if (this.jdField_a_of_type_Rre.a().contains(paramFriends.uin))
    {
      paramrrc.a.setEnabled(false);
      return;
    }
    paramrrc.a.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rqn
 * JD-Core Version:    0.7.0.1
 */