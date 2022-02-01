package com.tencent.mobileqq.profile;

import android.view.View.OnClickListener;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.profilecard.bussiness.guide.bean.ProfileGuide;
import com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.TroopFansInfo;
import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import com.tencent.mobileqq.profilecard.vas.VasDiyData;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
import java.util.HashMap;
import java.util.Map;

public class ProfileCardInfo
{
  public int a;
  public long a;
  public View.OnClickListener a;
  public ProfileActivity.AllInOne a;
  public Card a;
  public ContactCard a;
  public TroopMemberCard a;
  public ProfileCardTemplate a;
  public ProfileGuide a;
  public TroopFansInfo a;
  @Nullable
  public VasDiyData a;
  public RichStatus a;
  public MQQProfileName a;
  public ProfileConfigHelper a;
  public String a;
  private Map<Class<? extends IProfileBusinessInfo>, IProfileBusinessInfo> a;
  public boolean a;
  public String[] a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public boolean c = false;
  public boolean d;
  
  public ProfileCardInfo()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
  }
  
  public <T extends IProfileBusinessInfo> T a(Class<? extends IProfileBusinessInfo> paramClass)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {}
    for (IProfileBusinessInfo localIProfileBusinessInfo1 = (IProfileBusinessInfo)this.jdField_a_of_type_JavaUtilMap.get(paramClass);; localIProfileBusinessInfo1 = null)
    {
      IProfileBusinessInfo localIProfileBusinessInfo2 = localIProfileBusinessInfo1;
      if (localIProfileBusinessInfo1 == null)
      {
        localIProfileBusinessInfo2 = localIProfileBusinessInfo1;
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
          localIProfileBusinessInfo2 = this.jdField_a_of_type_ComTencentMobileqqDataCard.getBusinessInfo(paramClass);
        }
      }
      if (localIProfileBusinessInfo2 != null) {
        return localIProfileBusinessInfo2;
      }
      return null;
    }
  }
  
  public void a(IProfileBusinessInfo paramIProfileBusinessInfo)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramIProfileBusinessInfo.getClass(), paramIProfileBusinessInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardInfo
 * JD-Core Version:    0.7.0.1
 */