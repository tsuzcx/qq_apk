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

public class sbg
  implements View.OnClickListener
{
  sbg(sbf paramsbf) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "----->onBuddyListClick");
    sbn localsbn = (sbn)paramView.getTag();
    boolean bool;
    Object localObject;
    if ((localsbn != null) && (localsbn.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localsbn.jdField_a_of_type_JavaLangObject != null))
    {
      if (!localsbn.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()) {
        break label291;
      }
      if (localsbn.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label230;
      }
      bool = true;
      localsbn.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if ((localsbn.jdField_a_of_type_JavaLangObject instanceof Friends))
      {
        localObject = (Friends)localsbn.jdField_a_of_type_JavaLangObject;
        localObject = ResultRecord.a(((Friends)localObject).uin, ((Friends)localObject).name, 1);
        if (!bool) {
          break label235;
        }
        this.a.a.add(localObject);
      }
      label116:
      if (AppSetting.c)
      {
        if (!localsbn.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label251;
        }
        paramView.setContentDescription(localsbn.d.getText().toString() + anvx.a(2131713194));
      }
      label169:
      this.a.notifyDataSetChanged();
      if (AppSetting.c) {
        paramView.postDelayed(new SelectMemberBuddyListAdapter.1.1(this, paramView), 2000L);
      }
    }
    for (;;)
    {
      if (sbf.a(this.a) != null) {
        sbf.a(this.a).onClick(paramView);
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
      paramView.setContentDescription(localsbn.d.getText().toString() + anvx.a(2131713204));
      break label169;
      label291:
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbg
 * JD-Core Version:    0.7.0.1
 */