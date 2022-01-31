import android.content.Context;
import android.content.res.Resources;
import android.widget.CheckBox;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.widget.ExpandableListView;
import java.util.List;

public class pvi
  extends pvp
{
  private pvz a;
  
  public pvi(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, boolean paramBoolean, pvz parampvz)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView, paramBoolean);
    this.jdField_a_of_type_Pvz = parampvz;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Pvz != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size() >= this.jdField_a_of_type_Pvz.b()))
    {
      String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131652730, new Object[] { String.valueOf(this.jdField_a_of_type_Pvz.c()) });
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, str, 0).a();
      return;
    }
    bbmy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131652724), 0).a();
  }
  
  protected void a(pvx parampvx, Friends paramFriends)
  {
    if ((paramFriends == null) || (this.jdField_a_of_type_Pvz == null) || (this.jdField_a_of_type_Pvz.a() == null) || (this.jdField_a_of_type_Pvz.a().isEmpty())) {
      return;
    }
    parampvx.a.setBackgroundResource(2130848180);
    if (this.jdField_a_of_type_Pvz.a().contains(paramFriends.uin))
    {
      parampvx.a.setEnabled(false);
      return;
    }
    parampvx.a.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pvi
 * JD-Core Version:    0.7.0.1
 */