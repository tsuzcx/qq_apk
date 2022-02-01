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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ror
  implements View.OnClickListener
{
  ror(roq paramroq) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "----->onBuddyListClick");
    roy localroy = (roy)paramView.getTag();
    boolean bool;
    Object localObject;
    if ((localroy != null) && (localroy.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localroy.jdField_a_of_type_JavaLangObject != null))
    {
      if (!localroy.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()) {
        break label291;
      }
      if (localroy.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label230;
      }
      bool = true;
      localroy.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if ((localroy.jdField_a_of_type_JavaLangObject instanceof Friends))
      {
        localObject = (Friends)localroy.jdField_a_of_type_JavaLangObject;
        localObject = ResultRecord.a(((Friends)localObject).uin, ((Friends)localObject).name, 1);
        if (!bool) {
          break label235;
        }
        this.a.a.add(localObject);
      }
      label116:
      if (AppSetting.c)
      {
        if (!localroy.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label251;
        }
        paramView.setContentDescription(localroy.d.getText().toString() + amtj.a(2131712847));
      }
      label169:
      this.a.notifyDataSetChanged();
      if (AppSetting.c) {
        paramView.postDelayed(new SelectMemberBuddyListAdapter.1.1(this, paramView), 2000L);
      }
    }
    for (;;)
    {
      if (roq.a(this.a) != null) {
        roq.a(this.a).onClick(paramView);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label230:
      bool = false;
      break;
      label235:
      this.a.a.remove(localObject);
      break label116;
      label251:
      paramView.setContentDescription(localroy.d.getText().toString() + amtj.a(2131712857));
      break label169;
      label291:
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ror
 * JD-Core Version:    0.7.0.1
 */