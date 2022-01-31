import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ssz
  extends CardObserver
{
  public ssz(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileMoreInfoActivity", 2, String.format("onSetDetailInfo success=%s resultCode=%s mDelayRemoveCardObserver=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Boolean.valueOf(this.a.jdField_a_of_type_Boolean) }));
    }
    if ((!paramBoolean) || (paramInt != 0)) {
      this.a.a(2131437525, 1);
    }
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.a.jdField_a_of_type_Boolean = false;
    }
    if ((this.a.jdField_b_of_type_Int & 0x1) == 1)
    {
      if (paramBoolean)
      {
        ReportController.b(this.a.app, "dc00898", "", "", "0X8007EC3", "0X8007EC3", 0, 0, "", "", "", "");
        String str;
        if (this.a.jdField_a_of_type_Stn.b)
        {
          str = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(str.trim()))) {
            break label578;
          }
        }
        if (this.a.jdField_c_of_type_Boolean) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007EC8", "0X8007EC8", 0, 0, "", "", "", "");
        }
        if (this.a.d) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007EC9", "0X8007EC9", 0, 0, "", "", "", "");
        }
        if (this.a.e) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007ECA", "0X8007ECA", 0, 0, "", "", "", "");
        }
        if (this.a.jdField_b_of_type_Stn.b) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007ECB", "0X8007ECB", 0, 0, "", "", "", "");
        }
        if (this.a.f) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007ECD", "0X8007ECD", 0, 0, "", "", "", "");
        }
        if (this.a.g) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007ECE", "0X8007ECE", 0, 0, "", "", "", "");
        }
        if (this.a.jdField_c_of_type_Stn.b)
        {
          str = this.a.jdField_c_of_type_AndroidWidgetEditText.getText().toString();
          Matcher localMatcher = SearchBaseActivity.a.matcher(str);
          if ((TextUtils.isEmpty(str)) || (localMatcher.matches())) {
            break label611;
          }
        }
      }
      for (;;)
      {
        if (this.a.h) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007ED0", "0X8007ED0", 0, 0, "", "", "", "");
        }
        if (this.a.jdField_a_of_type_AndroidOsBundle == null) {
          this.a.jdField_a_of_type_AndroidOsBundle = new Bundle();
        }
        this.a.jdField_a_of_type_AndroidOsBundle.putShort("key_personality_label_switch", paramCard.switch_disable_personality_label);
        this.a.b(1);
        return;
        label578:
        ReportController.b(this.a.app, "dc00898", "", "", "0X8007EC7", "0X8007EC7", 0, 0, "", "", "", "");
        break;
        label611:
        ReportController.b(this.a.app, "dc00898", "", "", "0X8007ECF", "0X8007ECF", 0, 0, "", "", "", "");
      }
    }
    FriendProfileMoreInfoActivity.a(this.a, paramCard, true);
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Card)) && (Utils.a(this.a.app.getCurrentAccountUin(), ((Card)paramObject).uin))) {
      FriendProfileMoreInfoActivity.a(this.a, (Card)paramObject, true);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp, String paramString2)
  {
    if ((paramBoolean) && (parammobile_sub_get_photo_wall_rsp != null))
    {
      paramString1 = new ArrayList();
      this.a.a(parammobile_sub_get_photo_wall_rsp.total_pic, parammobile_sub_get_photo_wall_rsp.iHasMore, parammobile_sub_get_photo_wall_rsp.attachInfo, parammobile_sub_get_photo_wall_rsp.vecUrls, paramString1);
      parammobile_sub_get_photo_wall_rsp = this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1002);
      parammobile_sub_get_photo_wall_rsp.obj = paramString1;
      this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(parammobile_sub_get_photo_wall_rsp);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (Utils.a(this.a.app.getCurrentAccountUin(), paramCard.uin))) {
      FriendProfileMoreInfoActivity.a(this.a, paramCard, true);
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "onGetCampusInfo isSuc: %b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    Card localCard;
    int i;
    if ((paramBoolean) && ((paramObject instanceof Card)) && (Utils.a(this.a.app.getCurrentAccountUin(), ((Card)paramObject).uin))) {
      if ((this.a.l) && (this.a.n))
      {
        this.a.n = false;
        localCard = null;
        if ((paramObject instanceof Card)) {
          localCard = (Card)paramObject;
        }
        if ((localCard != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
          break label155;
        }
        i = 0;
      }
    }
    for (;;)
    {
      if (i != 0) {
        this.a.a("0X80081E8", i);
      }
      FriendProfileMoreInfoActivity.a(this.a, (Card)paramObject, true);
      return;
      label155:
      if ((localCard.nCampusStatus != this.a.jdField_a_of_type_ComTencentMobileqqDataCard.nCampusStatus) || (!Utils.a(localCard.strCampusName, this.a.jdField_a_of_type_ComTencentMobileqqDataCard.strCampusName)) || (!Utils.a(localCard.strCampusSchool, this.a.jdField_a_of_type_ComTencentMobileqqDataCard.strCampusSchool))) {
        i = 1;
      } else if ((localCard.nCampusEnrolYear != this.a.jdField_a_of_type_ComTencentMobileqqDataCard.nCampusEnrolYear) || (!Utils.a(localCard.strCampusCollege, this.a.jdField_a_of_type_ComTencentMobileqqDataCard.strCampusCollege)) || (!Utils.a(localCard.strCampusClass, this.a.jdField_a_of_type_ComTencentMobileqqDataCard.strCampusClass))) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  protected void c(boolean paramBoolean, String paramString, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (Utils.a(this.a.app.getCurrentAccountUin(), paramCard.uin))) {
      FriendProfileMoreInfoActivity.a(this.a, paramCard, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ssz
 * JD-Core Version:    0.7.0.1
 */