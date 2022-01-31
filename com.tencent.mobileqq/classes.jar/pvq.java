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

public class pvq
  implements View.OnClickListener
{
  pvq(pvp parampvp) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "----->onBuddyListClick");
    pvx localpvx = (pvx)paramView.getTag();
    boolean bool;
    Object localObject;
    if ((localpvx != null) && (localpvx.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localpvx.jdField_a_of_type_JavaLangObject != null))
    {
      if (!localpvx.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()) {
        break label284;
      }
      if (localpvx.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label223;
      }
      bool = true;
      localpvx.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if ((localpvx.jdField_a_of_type_JavaLangObject instanceof Friends))
      {
        localObject = (Friends)localpvx.jdField_a_of_type_JavaLangObject;
        localObject = ResultRecord.a(((Friends)localObject).uin, ((Friends)localObject).name, 1);
        if (!bool) {
          break label228;
        }
        this.a.a.add(localObject);
      }
      label116:
      if (AppSetting.c)
      {
        if (!localpvx.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label244;
        }
        paramView.setContentDescription(localpvx.d.getText().toString() + ajjy.a(2131647952));
      }
      label169:
      this.a.notifyDataSetChanged();
      if (AppSetting.c) {
        paramView.postDelayed(new SelectMemberBuddyListAdapter.1.1(this, paramView), 2000L);
      }
    }
    for (;;)
    {
      if (pvp.a(this.a) != null) {
        pvp.a(this.a).onClick(paramView);
      }
      return;
      label223:
      bool = false;
      break;
      label228:
      this.a.a.remove(localObject);
      break label116;
      label244:
      paramView.setContentDescription(localpvx.d.getText().toString() + ajjy.a(2131647962));
      break label169;
      label284:
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pvq
 * JD-Core Version:    0.7.0.1
 */