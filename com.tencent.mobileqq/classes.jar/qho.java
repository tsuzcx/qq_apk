import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ResultRecord;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.SelectMemberBuddyListAdapter.1.1;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;

public class qho
  implements View.OnClickListener
{
  qho(qhn paramqhn) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "----->onBuddyListClick");
    qhv localqhv = (qhv)paramView.getTag();
    boolean bool;
    Object localObject;
    if ((localqhv != null) && (localqhv.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localqhv.jdField_a_of_type_JavaLangObject != null))
    {
      if (!localqhv.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()) {
        break label284;
      }
      if (localqhv.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label223;
      }
      bool = true;
      localqhv.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if ((localqhv.jdField_a_of_type_JavaLangObject instanceof Friends))
      {
        localObject = (Friends)localqhv.jdField_a_of_type_JavaLangObject;
        localObject = ResultRecord.a(((Friends)localObject).uin, ((Friends)localObject).name, 1);
        if (!bool) {
          break label228;
        }
        this.a.a.add(localObject);
      }
      label116:
      if (AppSetting.d)
      {
        if (!localqhv.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label244;
        }
        paramView.setContentDescription(localqhv.d.getText().toString() + ajyc.a(2131713739));
      }
      label169:
      this.a.notifyDataSetChanged();
      if (AppSetting.d) {
        paramView.postDelayed(new SelectMemberBuddyListAdapter.1.1(this, paramView), 2000L);
      }
    }
    for (;;)
    {
      if (qhn.a(this.a) != null) {
        qhn.a(this.a).onClick(paramView);
      }
      return;
      label223:
      bool = false;
      break;
      label228:
      this.a.a.remove(localObject);
      break label116;
      label244:
      paramView.setContentDescription(localqhv.d.getText().toString() + ajyc.a(2131713749));
      break label169;
      label284:
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qho
 * JD-Core Version:    0.7.0.1
 */