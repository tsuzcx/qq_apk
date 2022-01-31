import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qidian.QidianManager;

public class rfv
  extends CardObserver
{
  public rfv(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    Object localObject;
    if ((paramBoolean) && (paramObject != null))
    {
      if (!(paramObject instanceof Card)) {
        break label163;
      }
      localObject = (Card)paramObject;
      if ((((Card)localObject).uin != null) && (((Card)localObject).uin.equals(AddFriendVerifyActivity.a(this.a))))
      {
        paramObject = ProfileCardUtil.a(this.a, ((Card)localObject).shGender, ((Card)localObject).age, ((Card)localObject).strCountry, ((Card)localObject).strProvince, ((Card)localObject).strCity);
        if (this.a.a != null) {
          paramObject = ProfileCardUtil.a(this.a, ((Card)localObject).shGender, 0, "", "", "");
        }
        if (!TextUtils.isEmpty(paramObject))
        {
          this.a.c.setVisibility(0);
          this.a.c.setText(paramObject);
        }
      }
    }
    for (;;)
    {
      if (QidianManager.b(this.a.app, AddFriendVerifyActivity.a(this.a))) {
        this.a.c.setVisibility(8);
      }
      return;
      label163:
      if ((paramObject instanceof ContactCard))
      {
        localObject = (ContactCard)paramObject;
        if ((((ContactCard)localObject).mobileNo != null) && (((ContactCard)localObject).mobileNo.equals(AddFriendVerifyActivity.a(this.a))))
        {
          paramObject = ProfileCardUtil.a(this.a, ((ContactCard)localObject).bSex, ((ContactCard)localObject).bAge, ((ContactCard)localObject).strCountry, ((ContactCard)localObject).strProvince, ((ContactCard)localObject).strCity);
          if (this.a.a != null) {
            paramObject = ProfileCardUtil.a(this.a, ((ContactCard)localObject).bSex, 0, "", "", "");
          }
          if (!TextUtils.isEmpty(paramObject))
          {
            this.a.c.setVisibility(0);
            this.a.c.setText(paramObject);
          }
        }
      }
    }
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if ((ProfileActivity.e(AddFriendVerifyActivity.b(this.a))) && (paramBoolean) && ((paramObject instanceof Card)))
    {
      paramObject = (Card)paramObject;
      if ((!Utils.a(AddFriendVerifyActivity.a(this.a), paramObject.uin)) || (TextUtils.isEmpty(paramObject.strCampusName))) {
        break label119;
      }
      AddFriendVerifyActivity.a(this.a, paramObject.strCampusName);
      this.a.b.setText(AddFriendVerifyActivity.b(this.a));
      if (!TextUtils.isEmpty(AddFriendVerifyActivity.b(this.a))) {
        this.a.b.setSelection(AddFriendVerifyActivity.b(this.a).length());
      }
    }
    label119:
    while (!Utils.a(this.a.app.getCurrentAccountUin(), paramObject.uin)) {
      return;
    }
    this.a.d(paramObject.strCampusName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rfv
 * JD-Core Version:    0.7.0.1
 */