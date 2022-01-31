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

public class qhl
  implements View.OnClickListener
{
  qhl(qhk paramqhk) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "----->onBuddyListClick");
    qhs localqhs = (qhs)paramView.getTag();
    boolean bool;
    Object localObject;
    if ((localqhs != null) && (localqhs.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localqhs.jdField_a_of_type_JavaLangObject != null))
    {
      if (!localqhs.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()) {
        break label284;
      }
      if (localqhs.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label223;
      }
      bool = true;
      localqhs.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if ((localqhs.jdField_a_of_type_JavaLangObject instanceof Friends))
      {
        localObject = (Friends)localqhs.jdField_a_of_type_JavaLangObject;
        localObject = ResultRecord.a(((Friends)localObject).uin, ((Friends)localObject).name, 1);
        if (!bool) {
          break label228;
        }
        this.a.a.add(localObject);
      }
      label116:
      if (AppSetting.d)
      {
        if (!localqhs.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label244;
        }
        paramView.setContentDescription(localqhs.d.getText().toString() + ajya.a(2131713750));
      }
      label169:
      this.a.notifyDataSetChanged();
      if (AppSetting.d) {
        paramView.postDelayed(new SelectMemberBuddyListAdapter.1.1(this, paramView), 2000L);
      }
    }
    for (;;)
    {
      if (qhk.a(this.a) != null) {
        qhk.a(this.a).onClick(paramView);
      }
      return;
      label223:
      bool = false;
      break;
      label228:
      this.a.a.remove(localObject);
      break label116;
      label244:
      paramView.setContentDescription(localqhs.d.getText().toString() + ajya.a(2131713760));
      break label169;
      label284:
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qhl
 * JD-Core Version:    0.7.0.1
 */