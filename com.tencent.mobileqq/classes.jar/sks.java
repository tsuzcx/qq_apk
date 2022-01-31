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
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity.ViewHolder;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import java.util.List;

public class sks
  extends BaseAdapter
{
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  
  public sks(DiscussionInfoCardActivity paramDiscussionInfoCardActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramDiscussionInfoCardActivity.app.getManager(50));
  }
  
  public int getCount()
  {
    if (DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity) == null) {
      return 1;
    }
    return DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if ((DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity) == null) || (paramInt >= DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).size())) {
      return null;
    }
    return DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    DiscussionInfoCardActivity.ViewHolder localViewHolder;
    TextView localTextView;
    ImageView localImageView;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getLayoutInflater().inflate(2130968771, null);
      localViewHolder = new DiscussionInfoCardActivity.ViewHolder();
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131362719));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131362754));
      paramViewGroup.setTag(localViewHolder);
      paramViewGroup.setVisibility(0);
      paramViewGroup.setFocusable(false);
      localTextView = localViewHolder.jdField_a_of_type_AndroidWidgetTextView;
      localImageView = localViewHolder.jdField_a_of_type_AndroidWidgetImageView;
      if (paramInt != getCount() - 1) {
        break label228;
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getString(2131435225);
      localTextView.setText(paramView);
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getResources().getColor(2131494220));
      localImageView.setBackgroundDrawable(null);
      localImageView.setImageResource(2130838420);
      localImageView.setTag(paramView);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a.isDiscussHrMeeting()) || (!QAVHrMeeting.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a.mSelfRight))) {
        break label219;
      }
      localImageView.setEnabled(false);
    }
    for (;;)
    {
      if (AppSetting.b) {
        ViewCompat.setImportantForAccessibility(localImageView, 2);
      }
      localImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity);
      return paramViewGroup;
      localViewHolder = (DiscussionInfoCardActivity.ViewHolder)paramView.getTag();
      paramViewGroup = paramView;
      break;
      label219:
      localImageView.setEnabled(true);
      continue;
      label228:
      if (paramInt > getCount() - 1)
      {
        localTextView.setText("");
        localImageView.setBackgroundDrawable(null);
        localImageView.setImageDrawable(null);
      }
      else
      {
        localImageView.setImageResource(2130842370);
        localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getResources().getColor(2131494214));
        String str = ((DiscussionMemberInfo)DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).get(paramInt)).memberUin;
        localViewHolder.jdField_a_of_type_JavaLangString = str;
        Object localObject = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity), str);
        if (TextUtils.isEmpty(str))
        {
          paramView = (View)localObject;
          if (localObject == null) {
            paramView = "";
          }
          localTextView.setText(paramView);
          localImageView.setImageDrawable(ImageUtil.b());
        }
        else
        {
          paramView = (View)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            paramView = (View)localObject;
            if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager != null)
            {
              Friends localFriends = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c(str);
              paramView = (View)localObject;
              if (localFriends != null)
              {
                paramView = (View)localObject;
                if (localFriends.isFriend()) {
                  paramView = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, str);
                }
              }
            }
          }
          localObject = paramView;
          if (TextUtils.isEmpty(paramView)) {
            localObject = str;
          }
          localTextView.setText((CharSequence)localObject);
          this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a(localViewHolder, null, true);
          localImageView.setTag(str);
          localImageView.setTag(2131362358, localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sks
 * JD-Core Version:    0.7.0.1
 */