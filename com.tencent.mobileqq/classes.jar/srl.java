import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.drawer.FriendProfileBubble;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import mqq.os.MqqHandler;

public class srl
  implements View.OnClickListener, ISpriteDrawerInfoCallback
{
  private srl(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void a()
  {
    if (this.a.app == null) {
      return;
    }
    ApolloActionData localApolloActionData = null;
    Object localObject = localApolloActionData;
    if (this.a.a != null)
    {
      localObject = localApolloActionData;
      if (this.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
        localObject = this.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a;
      }
    }
    if ((TextUtils.isEmpty((CharSequence)localObject)) && (this.a.a != null) && (this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
      localObject = this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
    }
    for (;;)
    {
      localApolloActionData = ((ApolloManager)this.a.app.getManager(152)).a(this.a.app, (String)localObject, new int[] { 4 });
      int i = 5;
      if (localApolloActionData == null)
      {
        localApolloActionData = new ApolloActionData();
        localApolloActionData.actionId = -1;
        localApolloActionData.actionType = 0;
      }
      for (;;)
      {
        SpriteUtil.a(FriendProfileCardActivity.a(this.a), i, localApolloActionData);
        new FriendProfileBubble((String)localObject).a(FriendProfileCardActivity.a(this.a), this.a, this.a.app, "这是我的厘米秀，你也来领一个吧");
        return;
        i = 12;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    ThreadManager.getUIHandler().post(new srm(this, paramInt1, paramInt2, paramString));
  }
  
  public void onClick(View paramView)
  {
    this.a.a(1, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     srl
 * JD-Core Version:    0.7.0.1
 */