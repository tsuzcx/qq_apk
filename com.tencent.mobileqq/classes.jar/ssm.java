import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.campuscircle.CampusCircleHelper;
import com.tencent.mobileqq.campuscircle.CampusCircleObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.List;

public class ssm
  extends CampusCircleObserver
{
  public ssm(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, List paramList)
  {
    if (!paramBoolean) {}
    while ((this.a.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.a.jdField_a_of_type_ComTencentMobileqqDataCard.lCampusSchoolID != paramLong) || (paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    if (this.a.jdField_a_of_type_JavaUtilArrayList == null) {
      this.a.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    for (;;)
    {
      this.a.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      return;
      this.a.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle, Card paramCard)
  {
    long l;
    if ((paramBoolean) && (paramBundle != null) && (this.a.i) && (paramBundle.containsKey("campus_school")) && (paramBundle.containsKey("campus_school_id")))
    {
      String str = paramBundle.getString("campus_school");
      l = paramBundle.getLong("campus_school_id");
      if (TextUtils.isEmpty(str))
      {
        i = 3;
        this.a.a("0X8007ECC", i);
        this.a.i = false;
        this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1004, 100L);
      }
    }
    else
    {
      if (!paramBoolean) {
        this.a.runOnUiThread(new ssn(this));
      }
      if (paramCard != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
      }
      if (this.a.jdField_b_of_type_Boolean)
      {
        this.a.app.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleObserver);
        this.a.jdField_b_of_type_Boolean = false;
      }
      if ((this.a.jdField_b_of_type_Int & 0x2) != 2) {
        break label323;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
        break label343;
      }
    }
    label323:
    label343:
    for (int i = CampusCircleHelper.b(this.a.jdField_a_of_type_ComTencentMobileqqDataCard.lCampusSchoolID);; i = 0)
    {
      if ((this.a.j) && (paramBundle != null) && (((i == 4) && (paramBundle.containsKey("campus_college"))) || (paramBundle.containsKey("campus_enroll_year")))) {
        this.a.j = false;
      }
      if ((this.a.k) && (paramBundle != null) && (((i == 4) && (paramBundle.containsKey("campus_enroll_year"))) || (paramBundle.containsKey("campus_class")))) {
        this.a.k = false;
      }
      this.a.b(2);
      do
      {
        return;
        if (l != 0L)
        {
          i = 1;
          break;
        }
        i = 2;
        break;
      } while (!paramBoolean);
      this.a.runOnUiThread(new sso(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ssm
 * JD-Core Version:    0.7.0.1
 */