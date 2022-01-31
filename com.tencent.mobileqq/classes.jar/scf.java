import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity.ViewHolder;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class scf
  extends BaseAdapter
{
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private boolean jdField_a_of_type_Boolean = true;
  
  public scf(ChatSettingForTroop paramChatSettingForTroop)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramChatSettingForTroop.app.getManager(50));
    a();
  }
  
  private void a()
  {
    if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {}
    for (boolean bool = true; ((!this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mMemberInvitingFlag) && (!this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) || ((!this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 3) && (!bool)); bool = false)
    {
      this.jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "隐藏邀请按钮：mMemberInvitingFlag=" + this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mMemberInvitingFlag + ", mTroopInfoData.isOwnerOrAdim() = " + this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim() + ", mTroopInfoData.cGroupOption=" + this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption + ", isPayToJoinTroop=" + bool);
      }
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList.size())
    {
      int j = i;
      if (this.jdField_a_of_type_Boolean)
      {
        j = i;
        if (i != 0) {
          j = i + 1;
        }
      }
      return Math.min(10, j);
    }
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList.size())) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    DiscussionInfoCardActivity.ViewHolder localViewHolder;
    TextView localTextView;
    ImageView localImageView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.getLayoutInflater().inflate(2130968771, null);
      localViewHolder = new DiscussionInfoCardActivity.ViewHolder();
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362701));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362736));
      localView.setTag(localViewHolder);
      localView.setVisibility(0);
      localView.setFocusable(false);
      localTextView = localViewHolder.jdField_a_of_type_AndroidWidgetTextView;
      localImageView = localViewHolder.jdField_a_of_type_AndroidWidgetImageView;
      if ((!this.jdField_a_of_type_Boolean) || (paramInt != getCount() - 1)) {
        break label206;
      }
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.getString(2131435208));
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.getResources().getColor(2131494213));
      localImageView.setBackgroundDrawable(null);
      localImageView.setImageResource(2130838416);
      localImageView.setEnabled(true);
      localImageView.setTag(Integer.valueOf(3));
    }
    label406:
    for (;;)
    {
      if (AppSetting.b) {
        ViewCompat.setImportantForAccessibility(localImageView, 2);
      }
      localImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop);
      return localView;
      localViewHolder = (DiscussionInfoCardActivity.ViewHolder)paramView.getTag();
      localView = paramView;
      break;
      label206:
      if (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList.size())
      {
        localImageView.setImageResource(2130842323);
        localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.getResources().getColor(2131494270));
        String str = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList.get(paramInt) + "";
        localViewHolder.jdField_a_of_type_JavaLangString = str;
        paramView = "";
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, str)) {
          paramView = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, str);
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(str)) {
            break label406;
          }
          paramViewGroup = paramView;
          if (paramView == null) {
            paramViewGroup = "";
          }
          localTextView.setText(paramViewGroup);
          localImageView.setImageDrawable(ImageUtil.b());
          break;
          ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, str, new scg(this, localTextView));
        }
        paramViewGroup = paramView;
        if (TextUtils.isEmpty(paramView))
        {
          paramViewGroup = paramView;
          if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager != null)
          {
            Friends localFriends = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c(str);
            paramViewGroup = paramView;
            if (localFriends != null)
            {
              paramViewGroup = paramView;
              if (localFriends.isFriend()) {
                paramViewGroup = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, str);
              }
            }
          }
        }
        paramView = paramViewGroup;
        if (TextUtils.isEmpty(paramViewGroup)) {
          paramView = str;
        }
        paramViewGroup = paramView;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_Boolean)
        {
          paramViewGroup = paramView;
          if (TextUtils.isDigitsOnly(paramView)) {
            paramViewGroup = "群聊成员";
          }
        }
        localTextView.setText(paramViewGroup);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a(localViewHolder, null, true);
        localImageView.setTag(2131362362, str);
        localImageView.setTag(Integer.valueOf(4));
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     scf
 * JD-Core Version:    0.7.0.1
 */