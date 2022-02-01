import android.content.Context;
import android.content.res.Resources;
import android.widget.CheckBox;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ExpandableListView;
import java.util.List;

public class roj
  extends roq
{
  private rpa a;
  
  public roj(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, boolean paramBoolean, rpa paramrpa)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView, paramBoolean);
    this.jdField_a_of_type_Rpa = paramrpa;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Rpa != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size() >= this.jdField_a_of_type_Rpa.b()))
    {
      String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131717498, new Object[] { String.valueOf(this.jdField_a_of_type_Rpa.c()) });
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, str, 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131717492), 0).a();
  }
  
  protected void a(roy paramroy, Friends paramFriends)
  {
    if ((paramFriends == null) || (this.jdField_a_of_type_Rpa == null) || (this.jdField_a_of_type_Rpa.a() == null) || (this.jdField_a_of_type_Rpa.a().isEmpty())) {
      return;
    }
    paramroy.a.setBackgroundResource(2130849321);
    if (this.jdField_a_of_type_Rpa.a().contains(paramFriends.uin))
    {
      paramroy.a.setEnabled(false);
      return;
    }
    paramroy.a.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     roj
 * JD-Core Version:    0.7.0.1
 */