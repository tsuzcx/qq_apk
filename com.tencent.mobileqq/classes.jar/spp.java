import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.campuscircle.CampusCircleHandler;
import com.tencent.mobileqq.campuscircle.CampusCircleHelper;
import com.tencent.mobileqq.campuscircle.CampusConfig;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberCard.MemberGameInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileBusiEntry;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.ProfileSummaryHobbiesEntry;
import com.tencent.mobileqq.profile.ProfileSummaryHobbiesItem;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.profile.view.ProfileShoppingView;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.PstnSwitchConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.troop.utils.TroopLinkManager;
import com.tencent.mobileqq.troop.utils.TroopLinkManager.LinkParams;
import com.tencent.mobileqq.troop.utils.TroopMemberGlobalLevelUtils;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.DynamicFaceDrawable;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import cooperation.qqindividuality.QQIndividualityBridgeActivity;
import cooperation.qqindividuality.QQIndividualityUtils;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopMemberCardProxyActivity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class spp
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  
  public spp(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      break label4;
    }
    for (;;)
    {
      label4:
      return;
      if (!(paramView.getTag() instanceof DataTag)) {
        continue;
      }
      Object localObject1 = (DataTag)paramView.getTag();
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "onClickListener and DataTag type=" + ((DataTag)localObject1).jdField_a_of_type_Int);
      }
      long l = System.currentTimeMillis();
      if ((((DataTag)localObject1).jdField_a_of_type_Int != 10) && (Math.abs(l - this.jdField_a_of_type_Long) < 1000L)) {
        break;
      }
      this.jdField_a_of_type_Long = l;
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.e) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(((DataTag)localObject1).jdField_a_of_type_Int))) {
        break;
      }
      int i;
      label1502:
      label1760:
      Object localObject2;
      label2082:
      label3167:
      label4071:
      int j;
      switch (((DataTag)localObject1).jdField_a_of_type_Int)
      {
      case 9: 
      case 2: 
      case 12: 
      case 14: 
      case 15: 
      case 18: 
      case 25: 
      case 36: 
      case 37: 
      case 38: 
      case 40: 
      case 43: 
      case 48: 
      case 49: 
      case 50: 
      case 51: 
      case 52: 
      case 53: 
      case 54: 
      case 55: 
      case 56: 
      case 60: 
      case 67: 
      case 75: 
      case 76: 
      case 82: 
      default: 
      case 1: 
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
        {
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, AvatarPendantActivity.class);
          paramView.putExtra("AllInOne", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity(paramView);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
          {
            paramView = (View)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
            l = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_Long;
            if ((ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (paramView != null) && (paramView.getVisibility() == 0) && (l != 0L)) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "AvatarClick", "ZhurenInfoHeadClick", 0, 0, "", "", "", "");
            }
          }
        }
      case 17: 
        for (;;)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8004173", "0X8004173", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            break label1760;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A77", "0X8006A77", 0, 0, "", "", "", "");
          return;
          if ((!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null)) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.e();
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X8007EC1", "0X8007EC1", 0, 0, "", "", "", "");
            return;
          }
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, CardPicGalleryActivity.class);
          localObject1 = new ArrayList();
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.b)) {
            paramView.putExtra("extra_default", 2130843018);
          }
          ((ArrayList)localObject1).add(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.b);
          paramView.putExtra("extra_mode", 2);
          paramView.putStringArrayListExtra("business_card_pics", (ArrayList)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity(paramView);
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.overridePendingTransition(2131034389, 0);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A97", "0X8006A97", 0, 0, "", "", "", "");
          return;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80)) {
            break;
          }
          if (!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
          {
            paramView = FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
            if (((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 53) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_Boolean)) && (paramView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null))
            {
              localObject1 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_face");
              if (localObject1 != null) {
                ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, (View)localObject1, paramView);
              }
            }
          }
          else if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
          {
            paramView = (View)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_face");
            localObject1 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
            l = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_Long;
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (localObject1 != null) && (paramView != null) && (((View)localObject1).getVisibility() == 0) && (l != 0L))
            {
              i = 0;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 1) {
                i = 1;
              }
              for (;;)
              {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "AvatarClick", "KerenInfoHeadClick", i, 0, "", "", "", "");
                if (!(paramView instanceof DynamicAvatarView)) {
                  break;
                }
                localObject1 = (DynamicAvatarView)paramView;
                if (((DynamicAvatarView)localObject1).a == null) {
                  break;
                }
                localObject1 = ((DynamicAvatarView)localObject1).a;
                if ((!((DynamicFaceDrawable)localObject1).jdField_a_of_type_Boolean) || (((DynamicFaceDrawable)localObject1).jdField_a_of_type_ComTencentImageURLDrawable == null) || (TextUtils.isEmpty(((DynamicFaceDrawable)localObject1).c))) {
                  break label1502;
                }
                ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramView, ((DynamicFaceDrawable)localObject1).c);
                break;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20) {
                  i = 2;
                } else if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) {
                  i = 3;
                } else if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 45) {
                  i = 4;
                } else if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46) {
                  i = 5;
                } else if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) {
                  i = 6;
                } else if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42) {
                  i = 7;
                }
              }
              localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getAccount(), 1);
              ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, l, i, (ProfileActivity.AllInOne)localObject1);
            }
            else if ((paramView != null) && ((paramView instanceof DynamicAvatarView)))
            {
              localObject1 = (DynamicAvatarView)paramView;
              if (((DynamicAvatarView)localObject1).a != null)
              {
                localObject1 = ((DynamicAvatarView)localObject1).a;
                if ((((DynamicFaceDrawable)localObject1).jdField_a_of_type_Boolean) && (((DynamicFaceDrawable)localObject1).jdField_a_of_type_ComTencentImageURLDrawable != null) && (!TextUtils.isEmpty(((DynamicFaceDrawable)localObject1).c)))
                {
                  ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramView, ((DynamicFaceDrawable)localObject1).c);
                }
                else if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))
                {
                  ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.p, false, false, null);
                }
                else
                {
                  localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getAccount(), 1);
                  ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false, false, (ProfileActivity.AllInOne)localObject1);
                }
              }
            }
          }
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A8B", "0X8006A8B", 0, 0, "", "", "", "");
        return;
      case 31: 
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.q();
        return;
      case 4: 
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo = ((ProfileActivity.CardContactInfo)((DataTag)localObject1).jdField_a_of_type_JavaLangObject);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt = new int[5];
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = new PstnSessionInfo();
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.b != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.c != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.a() == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.a().jdField_b_of_type_Int == 1))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_d_of_type_JavaLangString = FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app);
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[0] = 19;
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[1] = 8;
          if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            break label2082;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[2] = 9;
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[3] = 16;
        }
        for (;;)
        {
          i = 4;
          while (i < 5)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[i] = -1;
            i += 1;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[0] = 7;
          break;
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[2] = 16;
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[3] = -1;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8005AFD", "0X8005AFD", 0, 0, "", "", "", "");
        return;
      case 35: 
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.r();
        return;
      case 6: 
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.u();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "P_prof", "Prof_new_photo", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
      case 72: 
        paramView = ((CampusCircleHandler)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.a(108)).a();
        paramView = String.format(Locale.getDefault(), "%s&uin=%s", new Object[] { paramView.c, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString });
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin());
        ((Intent)localObject1).putExtra("url", paramView);
        ((Intent)localObject1).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
        for (i = 1;; i = 2)
        {
          ReportController.b((QQAppInterface)localObject1, "dc00898", "", "", "0X80081EF", "0X80081EF", i, 0, "", "", "", "");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("CampusCircle", 2, String.format(Locale.getDefault(), "forward campus feed url: %s", new Object[] { paramView }));
          return;
        }
      case 5: 
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.v();
        ThreadManager.post(new spq(this), 8, null, true);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "P_prof", "Pp_clk_qzone", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A7C", "0X8006A7C", 0, 0, "", "", "", "");
        }
        while (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean)
        {
          new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("zone_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString }).a();
          return;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A90", "0X8006A90", 0, 0, "", "", "", "");
        }
      case 63: 
        QQStoryMemoriesActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, 7, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        StoryReportor.a("person_data", "clk_entry", 0, 0, new String[] { "", "", "", "" });
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X8007EB7", "0X8007EB7", 0, 0, "", "", "", "");
        }
        while (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean)
        {
          new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("diary_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString }).a();
          return;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X8007EB8", "0X8007EB8", 0, 0, "", "", "", "");
        }
      case 7: 
        if (QSecFramework.a().a(1001).booleanValue()) {
          QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(6), "addfriend", null }, null);
        }
        FriendProfileCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "P_prof", "Pp_add_frd", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_Int), "", "");
        if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X8008274", "0X8008274", 0, 0, "", "", "", "");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null))
        {
          if (87 == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006F0D", "0X8006F0D", 0, 0, "", "", "", "");
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.o != 1) {
            break label3619;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8007162", "0X8007162", 0, 0, "", "", "", "");
        }
        while (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean)
        {
          new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("addfri_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString }).a();
          return;
          if ((101 == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int) || (102 == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int) || (103 == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int))
          {
            if (((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getManager(10)).g()) {}
            for (paramView = "0X80077D4";; paramView = "0X80077CE")
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
              if (101 != this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int) {
                break label3468;
              }
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", paramView, paramView, 1, 0, "", "", "", "");
              break;
            }
            if (102 == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", paramView, paramView, 2, 0, "", "", "", "");
              break label3167;
            }
            if (103 != this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int) {
              break label3167;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", paramView, paramView, 3, 0, "", "", "", "");
            break label3167;
          }
          if (104 != this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int) {
            break label3167;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X80077D1", "0X80077D1", 0, 0, "", "", "", "");
          break label3167;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.o == 2) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8007163", "0X8007163", 0, 0, "", "", "", "");
          }
        }
      case 8: 
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.t();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "P_prof", "Pp_send_msg", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_Int), "", "");
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean) {
          continue;
        }
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("msg_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString }).a();
        return;
      case 23: 
        localObject1 = paramView.findViewById(2131371310);
        localObject2 = paramView.getParent();
        paramView = (View)localObject1;
        if ((localObject2 instanceof View)) {
          paramView = ((View)localObject2).findViewById(2131371310);
        }
        i = 1;
        if (paramView != null) {
          if (paramView.getVisibility() != 0) {
            break label4071;
          }
        }
        for (i = 0;; i = 1)
        {
          paramView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.i();
          ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin(), "inside.myCardButton", i, 3, 1, "", true);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "card_mall", "0X8006681", 0, 0, "", "", "", "");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X8007EB5", "0X8007EB5", 0, 0, "", "", "", "");
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.j) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.i)) {
            break;
          }
          VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clkcard_owner", "0", 1, 0, 0, HttpUtil.a(), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId));
          return;
        }
      case 24: 
        j = ((Integer)((DataTag)localObject1).jdField_a_of_type_JavaLangObject).intValue();
        if ((j == 101107) || (j == 101108))
        {
          if (j != 101108) {
            break label4194;
          }
          i = 5;
          if (j != 101108) {
            break label4199;
          }
          VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, 3, ProfileCardUtil.a(i));
        }
        for (;;)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "P_CliOper", "Vip_SummaryCard", "", "SummaryCard", "CLICK_TOPBARVIPINVALID", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          i = 2;
          break;
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, 3, ProfileCardUtil.a(i));
        }
      case 10: 
        if ((((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof Card))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a((Card)((DataTag)localObject1).jdField_a_of_type_JavaLangObject);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(null);
        return;
      case 71: 
        if ((!(((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof Card)) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null)) {
          continue;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
        paramView.what = 14;
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(paramView);
        return;
      case 74: 
        if ((!(((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof Card)) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null)) {
          continue;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
        paramView.what = 19;
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(paramView);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X8008641", "0X8008641", 1, 0, "", "", "", "");
        return;
      case 13: 
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.s();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "P_prof", "Pp_clk_myQR", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
      case 81: 
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.e(false);
        if (FriendProfileCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X80081C1", "0X80081C1", 0, 0, "", "", "", "");
        }
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("edit_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString }).a();
        return;
      case 16: 
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean)
        {
          new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("more_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString }).a();
          localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getManager(51);
          localObject2 = ((TroopManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString);
          if (localObject2 == null) {
            continue;
          }
          paramView = new Intent();
          paramView.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString);
          paramView.putExtra("memberUin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
          paramView.putExtra("fromFlag", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Int);
          paramView.putExtra("troopMemberCard", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard);
          paramView.putExtra("troopCode", ((TroopInfo)localObject2).troopcode);
          paramView.putExtra("troopName", ((TroopInfo)localObject2).getTroopName());
          paramView.putExtra("hwCard", ((TroopManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin));
          paramView.putExtra("qidian_private_troop", TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString));
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {
            continue;
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString = ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          }
          paramView.putExtra("AllInOne", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          paramView.putExtra("detailProfileUrl", ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity));
          paramView.putExtra("qidianshowUin", QidianManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
          paramView.putExtra("circleRealName", ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
          localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getManager(50);
          paramView.putExtra("isFriend", ((FriendsManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
          paramView.putExtra("isQidianMaster", ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getManager(164)).f(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
          localObject1 = ((FriendsManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          if (localObject1 != null) {
            paramView.putExtra("specialFlag", ((Friends)localObject1).cSpecialFlag);
          }
          paramView.putExtra("businessCard", BusinessCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo));
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.jdField_a_of_type_JavaUtilList.size() > 0)) {
            paramView.putExtra("SHARE_NICK_NAME", ((MQQName)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName))) {
            paramView.putExtra("cur_add_source", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
            paramView.putExtra("key_nick_name", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (ProfileActivity.AllInOne.i(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
          {
            paramView.putExtra("recommend_campus_name", CampusCircleHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard));
            paramView.putExtra("recommend_campus_info", CampusCircleHelper.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard));
          }
          paramView.putExtra("isMsgShielded", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.c());
          localObject1 = TroopBaseProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
          TroopMemberCardProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "troop_member_card_plugin.apk", "群名片", TroopMemberCardProxyActivity.class, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramView, (Dialog)localObject1, "com.tencent.mobileqq.memcard.plugin.TroopMemberCardMoreInfoActivity", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin(), 8);
          return;
        }
        paramView = BusinessCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        paramView = ProfileCardUtil.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, ProfileCardMoreActivity.class), this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, paramView);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.jdField_a_of_type_JavaUtilList.size() > 0)) {
          paramView.putExtra("SHARE_NICK_NAME", ((MQQName)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName))) {
          paramView.putExtra("cur_add_source", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
          paramView.putExtra("key_nick_name", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (ProfileActivity.AllInOne.i(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
        {
          paramView.putExtra("recommend_campus_name", CampusCircleHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard));
          paramView.putExtra("recommend_campus_info", CampusCircleHelper.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard));
        }
        paramView.addFlags(536870912);
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivityForResult(paramView, 1012);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A8A", "0X8006A8A", 0, 0, "", "", "", "");
        return;
      case 21: 
        if ((((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry))
        {
          paramView = (ProfileBusiEntry)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("portraitOnly", true);
          ((Intent)localObject1).putExtra("url", paramView.jdField_d_of_type_JavaLangString);
        }
      case 19: 
      case 3: 
      case 20: 
      case 59: 
      case 26: 
      case 22: 
      case 27: 
      case 28: 
      case 61: 
      case 62: 
      case 29: 
      case 30: 
      case 47: 
      case 32: 
      case 33: 
      case 34: 
      case 39: 
      case 42: 
      case 64: 
      case 70: 
      case 58: 
      case 41: 
      case 44: 
      case 46: 
      case 45: 
      case 57: 
      case 11: 
      case 65: 
      case 66: 
      case 68: 
      case 69: 
      case 73: 
      case 78: 
      case 79: 
      case 80: 
      case 77: 
      case 83: 
      case 84: 
        try
        {
          label3468:
          label3619:
          label4194:
          label4199:
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8004184", "0X8004184", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          if ((((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof Object[]))
          {
            bool = ((Boolean)((Object[])(Object[])localObject1.jdField_a_of_type_JavaLangObject)[0]).booleanValue();
            paramView = IndividuationUrlHelper.a("vipPersonalCardMyGame");
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(bool, paramView);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8004183", "0X8004183 ", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          if ((((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof String)) {
            paramView = (String)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
          {
            paramView = IndividuationUrlHelper.a("signatureH5Url");
            if ((!TextUtils.isEmpty(paramView)) && (paramView.startsWith("http"))) {
              VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramView, -1L, null, true, 1026);
            }
          }
          while (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A79", "0X8006A79", 0, 0, "", "", "", "");
            return;
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQIndividualityBridgeActivity.class);
            paramView.putExtra("k_source", 4);
            paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
            paramView.putExtra(QQIndividualityUtils.l, 1);
            paramView.putExtra(QQIndividualityUtils.e, "path");
            paramView.putExtra(QQIndividualityUtils.f, "name");
            paramView.putExtra(QQIndividualityUtils.i, 1026);
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivityForResult(paramView, 1026);
            continue;
            localObject1 = IndividuationUrlHelper.a("signatureHistoryH5Url");
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).startsWith("http")))
            {
              paramView = (View)localObject1;
              if (!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin())) {
                paramView = (String)localObject1 + "&fuin=" + this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
              }
              VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramView, -1L, null, true, 1026);
            }
            else
            {
              paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQIndividualityBridgeActivity.class);
              paramView.putExtra("key_uin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
              paramView.putExtra("key__entry_type", 1);
              paramView.putExtra("key_uin_name", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString);
              paramView.putExtra(QQIndividualityUtils.l, 2);
              paramView.putExtra(QQIndividualityUtils.e, "path");
              paramView.putExtra(QQIndividualityUtils.f, "name");
              paramView.putExtra(QQIndividualityUtils.i, 1026);
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivityForResult(paramView, 1026);
            }
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A8D", "0X8006A8D", 0, 0, "", "", "", "");
          return;
          paramView = new int[5];
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = new PstnSessionInfo();
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
          localObject1 = VideoActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
          ((VideoActionSheet)localObject1).a(2131438345);
          ((VideoActionSheet)localObject1).b(2131433828);
          j = 0;
          paramView[0] = 1;
          i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.b != null)
          {
            i = j;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.c != null)
            {
              i = j;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.a() == 1)
              {
                i = j;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.a().jdField_b_of_type_Int == 1)
                {
                  this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_d_of_type_JavaLangString = FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app);
                  if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_call_time <= 0)) {
                    break label7051;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_k_of_type_Int = 1;
                  ((VideoActionSheet)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getResources().getString(2131438343), this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getResources().getDrawable(2130840359), 0);
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 1, 0, "", "", "", "");
                }
              }
            }
          }
          for (;;)
          {
            i = 1;
            paramView[1] = 4;
            paramView[(i + 1)] = 2;
            ((VideoActionSheet)localObject1).b(2131433825);
            ((VideoActionSheet)localObject1).c(2131433015);
            ((VideoActionSheet)localObject1).a(new spr(this));
            ((VideoActionSheet)localObject1).a(new sps(this, paramView, (VideoActionSheet)localObject1));
            ((VideoActionSheet)localObject1).show();
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8008404", "0X8008404", 0, 0, "", "", "", "");
            return;
            label7051:
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.b() == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_try_status == 0))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_k_of_type_Int = 2;
              ((VideoActionSheet)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getResources().getString(2131438343), this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getResources().getDrawable(2130840358), 0);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 3, 0, "", "", "", "");
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_k_of_type_Int = 5;
              ((VideoActionSheet)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getResources().getString(2131438343), this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getResources().getDrawable(2130840357), 0);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 2, 0, "", "", "", "");
            }
          }
          paramView = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getManager(10);
          if (!paramView.f())
          {
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, GuideBindPhoneActivity.class);
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity(paramView);
          }
          while (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.o == 2)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8007164", "0X8007164", 0, 0, "", "", "", "");
            return;
            if (!paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_k_of_type_Boolean = true;
              if (paramView.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
              {
                QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getApplicationContext(), "保存成功", 0).a();
              }
              else
              {
                paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, GuideBindPhoneActivity.class);
                paramView.putExtra("req_write", true);
                this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity(paramView);
              }
            }
            else
            {
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getApplicationContext(), "名片已保存", 0).a();
            }
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.o != 3) {
            continue;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8007165", "0X8007165", 0, 0, "", "", "", "");
          return;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.privilegeJumpUrl;
          paramView = (View)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
              break label7720;
            }
          }
          label7720:
          for (paramView = "http://mc.vip.qq.com/privilegelist/index";; paramView = "http://mc.vip.qq.com/privilegelist/other?friend=" + this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)
          {
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramView);
            ((Intent)localObject1).putExtra("hide_operation_bar", true);
            ((Intent)localObject1).putExtra("hide_more_button", true);
            ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject1);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "P_CliOper", "Pb_account_lifeservice", "", "ziliaoka_qqtequan", "tab-click", 0, 1, 0, "", "", "", "");
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
              break;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A7B", "0X8006A7B", 0, 0, "", "", "", "");
            return;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A8F", "0X8006A8F", 0, 0, "", "", "", "");
          return;
          if (!(((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry)) {
            continue;
          }
          paramView = (ProfileBusiEntry)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(paramView.jdField_d_of_type_JavaLangString);
          return;
          if ((((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry))
          {
            paramView = (ProfileBusiEntry)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
            localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", paramView.jdField_d_of_type_JavaLangString);
            ((Intent)localObject2).putExtra("hide_operation_bar", true);
            ((Intent)localObject2).putExtra("hide_more_button", true);
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject2);
          }
          if (28 != ((DataTag)localObject1).jdField_a_of_type_Int) {
            continue;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8004181", "0X8004181", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          if (!(((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof ProfileSummaryHobbiesEntry)) {
            continue;
          }
          paramView = (ProfileSummaryHobbiesEntry)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
          if (paramView.jdField_a_of_type_Int == 5)
          {
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, ShowExternalTroopListActivity.class);
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_d_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_d_of_type_AndroidWidgetTextView.getText()))) {
              paramView.putExtra("leftViewText", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_d_of_type_AndroidWidgetTextView.getText().toString().trim());
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
            for (bool = true;; bool = false)
            {
              paramView.putExtra("isHost", bool);
              paramView.putExtra("dest_uin_str", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
              paramView.putExtra("from", 0);
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivityForResult(paramView, 1015);
              if (!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean) {
                break;
              }
              new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("grp_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString }).a();
              return;
            }
          }
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", paramView.b);
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject1);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("remilelei", 2, "hobby go to :" + paramView.b);
          return;
          if (!(((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof ProfileSummaryHobbiesItem)) {
            continue;
          }
          paramView = (ProfileSummaryHobbiesItem)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
          switch (paramView.jdField_a_of_type_Int)
          {
          case 3: 
          default: 
            if (paramView.jdField_a_of_type_Int != 5) {
              break label8647;
            }
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, ShowExternalTroopListActivity.class);
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_d_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_d_of_type_AndroidWidgetTextView.getText()))) {
              paramView.putExtra("leftViewText", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_d_of_type_AndroidWidgetTextView.getText().toString().trim());
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
              break;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            paramView.putExtra("isHost", bool);
            paramView.putExtra("dest_uin_str", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            paramView.putExtra("from", 0);
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivityForResult(paramView, 1015);
            return;
            if (paramView.jdField_b_of_type_Int == 0)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X80070B2", "0X80070B2", 0, 0, "", "", "", "");
              break;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X80070AE", "0X80070AE", 0, 0, "", "", "", "");
            break;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X80070B6", "0X80070B6", 0, 0, "", "", "", "");
            break;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X80070AA", "0X80070AA", 0, 0, "", "", "", "");
            break;
          }
          label8647:
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", paramView.c);
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject1);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("remilelei", 2, "hobby go to :" + paramView.c);
          return;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))) {
            continue;
          }
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramView))
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "card_mall", "0X8004435", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), "", "", VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin()));
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == ProfileCardTemplate.j) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == ProfileCardTemplate.i)) {
              VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clkbkgd_owner", "0", 1, 0, 0, HttpUtil.a(), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId));
            }
            ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin(), "inside.myCardBackground", 1, 0, 1, "", true);
            return;
          }
          if ((((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof String))
          {
            paramView = (String)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
            if ("CLICK_HEADER_BG".equals(paramView))
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "card_mall", "0X80047F1", 0, 0, "1", "", "", VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin()));
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == ProfileCardTemplate.j) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == ProfileCardTemplate.i)) {
                VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clkbkgd_visitor", "0", 1, 0, 0, HttpUtil.a(), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId));
              }
            }
            for (;;)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "card_mall", "0X80047F0", 0, 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Long.toString(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), "", VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin()));
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
                break;
              }
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131437490);
              localObject1 = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
              ((ActionSheet)localObject1).a(2131437489, 1);
              ((ActionSheet)localObject1).a((CharSequence)localObject2, 1);
              ((ActionSheet)localObject1).a(2131433015, 1);
              ((ActionSheet)localObject1).a(new spt(this, paramView, (ActionSheet)localObject1));
              try
              {
                ((ActionSheet)localObject1).show();
                this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)localObject1);
                return;
                if ("CLICK_BANNER".equals(paramView)) {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "card_mall", "0X80047F1", 0, 0, "2", "", "", VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin()));
                }
              }
              catch (Exception paramView)
              {
                for (;;)
                {
                  paramView.printStackTrace();
                }
              }
            }
            if (!(((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry)) {
              continue;
            }
            paramView = (ProfileBusiEntry)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, ShowExternalTroopListActivity.class);
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_d_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_d_of_type_AndroidWidgetTextView.getText()))) {
              paramView.putExtra("leftViewText", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_d_of_type_AndroidWidgetTextView.getText().toString().trim());
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
            for (bool = true;; bool = false)
            {
              paramView.putExtra("isHost", bool);
              paramView.putExtra("dest_uin_str", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
              paramView.putExtra("from", 0);
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivityForResult(paramView, 1015);
              if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
                break;
              }
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "P_CliOper", "Grp_join", "", "person_data", "Clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.i, "1", "", "");
              return;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "P_CliOper", "Grp_join", "", "person_data", "Clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.i, "0", "", "");
            return;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "card_mall", "0X80066C6", 0, 0, "2", "", "", "");
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, ProfileLabelEditorActivity.class);
            paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            try
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivityForResult(paramView, 1004);
              return;
            }
            catch (Exception paramView)
            {
              paramView.printStackTrace();
              return;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "card_mall", "0X80066C6", 0, 0, "1", "", "", "");
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, ProfileLabelEditorActivity.class);
            paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            try
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivityForResult(paramView, 1004);
              return;
            }
            catch (Exception paramView)
            {
              paramView.printStackTrace();
              return;
            }
            if (!(((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry)) {
              continue;
            }
            paramView = (ProfileBusiEntry)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramView.jdField_d_of_type_JavaLangString + "&_webviewtype=1");
            ((Intent)localObject1).putExtra("hide_operation_bar", true);
            ((Intent)localObject1).putExtra("hide_more_button", true);
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject1);
            return;
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {
              continue;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "card_mall", "0X8007A48", 0, 0, "0", "", "", "");
            }
            for (;;)
            {
              ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strActiveUrl);
              return;
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "card_mall", "0X8007A48", 0, 0, "1", "", "", "");
            }
            if (!(((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry)) {
              continue;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X80055C9", "0X80055C9", 0, 0, "", "", "", "");
            paramView = (ProfileBusiEntry)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramView.jdField_d_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("hide_operation_bar", true);
            ((Intent)localObject1).putExtra("hide_more_button", true);
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject1);
            return;
            if (!(((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry)) {
              continue;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8005D14", "0X8005D14", 0, 0, "", "", "", "");
            paramView = (ProfileBusiEntry)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramView.jdField_d_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("hide_operation_bar", true);
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject1);
            return;
            if (!(((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry)) {
              continue;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8007DBD", "0X8007DBD", 0, 0, "", "", "", "");
            paramView = (ProfileBusiEntry)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramView.jdField_d_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("hide_operation_bar", true);
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject1);
            return;
            if (!(((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry)) {
              continue;
            }
            paramView = (ProfileBusiEntry)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramView.jdField_d_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("hide_operation_bar", true);
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject1);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X8007FA4", "0X8007FA4", 0, 0, "", "", "", "");
            return;
            if (!(((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry)) {
              continue;
            }
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "0X8006E05", "0X8006E05", 0, 0, new String[0]);
            paramView = (ProfileBusiEntry)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramView.jdField_d_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("hide_operation_bar", true);
            ((Intent)localObject1).putExtra("hide_more_button", true);
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject1);
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.c == null) {
              continue;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "P_CliOper", "Shop_lifeservice", "", "Shop_Ftemplateinto", "0X8005B97", 0, 0, "", "", "", "");
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_h_of_type_Int == 1)
            {
              paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, ChatActivity.class);
              if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.c))
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.w("FriendProfileCardActivity", 2, "onItemClick - uin = null");
                return;
              }
              paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.c);
              paramView.putExtra("uintype", 1008);
              paramView.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_d_of_type_JavaLangString);
              paramView.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131437771));
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity(paramView);
              return;
            }
            paramView = null;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
            {
              paramView = new Intent();
              paramView.putExtra("report_src_param_type", "gouwu_follow");
              if (!(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView)) {
                break label10828;
              }
              paramView.putExtra("report_src_param_name", "0X8005D5A");
            }
            for (;;)
            {
              PublicAccountUtil.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.c, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.g);
              return;
              label10828:
              paramView.putExtra("report_src_param_name", "0X8005D59");
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 32) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 31) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 50) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 51) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 34) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 53)) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.f();
            return;
            if (!(((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof BusinessCard)) {
              continue;
            }
            localObject1 = (BusinessCard)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, BusinessCardEditActivity.class);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
              paramView.putExtra("mode_type", 3);
            }
            for (;;)
            {
              paramView.putExtra("cur_card_body", (Parcelable)localObject1);
              paramView.putExtra("is_edit_mode", true);
              paramView.putExtra("finish_immedia", true);
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList;
              localObject1 = new ArrayList();
              localObject2 = ((ArrayList)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                ((ArrayList)localObject1).add(((ProfileActivity.CardContactInfo)((Iterator)localObject2).next()).c);
              }
              paramView.putExtra("mode_type", 2);
              paramView.putExtra("source_activity", 1);
              ((BusinessCard)localObject1).bindUin = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
            }
            paramView.putExtra("bind_phone_num", (Serializable)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity(paramView);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A7F", "0X8006A7F", 0, 0, "", "", "", "");
              return;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A93", "0X8006A93", 0, 0, "", "", "", "");
            return;
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo = ((ProfileActivity.CardContactInfo)((DataTag)localObject1).jdField_a_of_type_JavaLangObject);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt == null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt = new int[5];
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = new PstnSessionInfo();
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.b != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.c != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.a() == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.a().jdField_b_of_type_Int == 1))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_d_of_type_JavaLangString = FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app);
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[0] = 19;
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[1] = 8;
              if ((!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo.jdField_a_of_type_JavaLangString))) {
                break label11546;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[2] = 9;
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[3] = 16;
            }
            for (;;)
            {
              i = 4;
              while (i < 5)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[i] = -1;
                i += 1;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[0] = 7;
              break;
              label11546:
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[2] = 16;
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[3] = -1;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A7E", "0X8006A7E", 0, 0, "", "", "", "");
              return;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A92", "0X8006A92", 0, 0, "", "", "", "");
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin(), 0).edit().putBoolean("svip_profile_show_newer_guide_flag", true).commit();
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo = ((ProfileActivity.CardContactInfo)((DataTag)localObject1).jdField_a_of_type_JavaLangObject);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt == null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt = new int[5];
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[0] = 20;
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[1] = 21;
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[2] = 16;
            i = 3;
            while (i < 5)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[i] = -1;
              i += 1;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A84", "0X8006A84", 0, 0, "", "", "", "");
            return;
            paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin, 1);
            ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramView);
            return;
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QRDisplayActivity.class);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getResources().getString(2131430000);
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin();
            Object localObject3 = ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, (String)localObject2);
            paramView.putExtra("title", (String)localObject1);
            paramView.putExtra("uin", (String)localObject2);
            paramView.putExtra("nick", (String)localObject3);
            paramView.putExtra("type", 1);
            paramView.putExtra("reportFlag", 1);
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity(paramView);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X8007EBB", "0X8007EBB", 0, 0, "", "", "", "");
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.e(true);
              new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("profile_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString }).a();
              FriendProfileCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
              return;
            }
            ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X8007EBA", "0X8007EBA", 0, 0, "", "", "", "");
            return;
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo = ((ProfileActivity.CardContactInfo)((DataTag)localObject1).jdField_a_of_type_JavaLangObject);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt == null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt = new int[5];
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = new PstnSessionInfo();
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo = PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.b != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.c != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.a() == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.a().jdField_b_of_type_Int == 1))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_d_of_type_JavaLangString = FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app);
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[0] = 19;
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[1] = 8;
              if ((!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo.jdField_a_of_type_JavaLangString))) {
                break label12503;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[2] = 9;
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[3] = 16;
            }
            for (;;)
            {
              i = 4;
              while (i < 5)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[i] = -1;
                i += 1;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[0] = 7;
              break;
              label12503:
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[2] = 16;
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[3] = -1;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A7E", "0X8006A7E", 0, 0, "", "", "", "");
              return;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A92", "0X8006A92", 0, 0, "", "", "", "");
            return;
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.p();
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A7A", "0X8006A7A", 0, 0, "", "", "", "");
              return;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A8E", "0X8006A8E", 0, 0, "", "", "", "");
            return;
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.o();
            if ((((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof View)) {
              ((View)((DataTag)localObject1).jdField_a_of_type_JavaLangObject).setVisibility(8);
            }
            VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008119", "", 1, 0, 0, HttpUtil.a(), "", "");
            return;
            paramView = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("member_uin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
            if ((paramView != null) && (paramView.mIsShielded)) {}
            for (bool = true;; bool = false)
            {
              ((Intent)localObject1).putExtra("member_is_shield", bool);
              TroopMemberCardProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, (Intent)localObject1, "com.tencent.mobileqq.memcard.plugin.RecentSaidActivity", 0);
              new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("recent_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString }).a();
              return;
            }
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
            paramView.putExtra("url", "https://imgcache.qq.com/club/client/flower/release/html/points.html?source=0");
            paramView.putExtra("url", "https://imgcache.qq.com/club/client/flower/release/html/points.html?source=0");
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity(paramView);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00899", "Grp_flower", "", "gift_exch", "entry_clk", 0, 0, "", "", "", "");
            new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("point_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString }).a();
            return;
            paramView = TroopLinkManager.a();
            localObject1 = paramView.a("troop_rank");
            if (TextUtils.isEmpty((CharSequence)localObject1)) {}
            for (paramView = TroopMemberGlobalLevelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString);; paramView = paramView.a((String)localObject1, (TroopLinkManager.LinkParams)localObject2))
            {
              localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
              ((Intent)localObject1).putExtra("url", paramView);
              ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.c());
              ((Intent)localObject1).putExtra("portraitOnly", true);
              ((Intent)localObject1).putExtra("hide_more_button", true);
              ((Intent)localObject1).putExtra("hide_operation_bar", true);
              ((Intent)localObject1).putExtra("isShowAd", false);
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject1);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00899", "Grp_grade", "", "mber_card", "clk_grade", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString, "", "", "");
              new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("grade_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString }).a();
              return;
              localObject2 = new TroopLinkManager.LinkParams();
              ((TroopLinkManager.LinkParams)localObject2).c = "31";
              ((TroopLinkManager.LinkParams)localObject2).b = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
              ((TroopLinkManager.LinkParams)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString;
            }
            paramView = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString, 1, 0);
            TroopGiftUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin, paramView, "profilecard", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app);
            paramView = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString);
            if (paramView == null) {
              continue;
            }
            if (paramView.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin())) {
              i = 0;
            }
            for (;;)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "P_CliOper", "Grp_flower", "", "mber_data", "Clk_send", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString, i + "", "", "");
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_btn", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString, "4", TroopMemberCardUtils.a(TroopMemberCardUtils.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin)), "");
              new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app).a("dc00899").b("Grp_mem_card").c("page").d("flower_clk").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString }).a();
              return;
              if (paramView.isAdmin()) {
                i = 1;
              } else {
                i = 2;
              }
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard != null))
            {
              paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo;
              if (paramView != null)
              {
                localObject2 = paramView.gameUrl;
                localObject3 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
                ((Intent)localObject3).putExtra("url", (String)localObject2);
                this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject3);
                TroopReportor.a("Grp_game", "Mber_data", "game_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString, paramView.gameName });
              }
            }
            if ((((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry))
            {
              paramView = (ProfileBusiEntry)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
              if (!StringUtil.a(paramView.jdField_d_of_type_JavaLangString))
              {
                localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, QQBrowserActivity.class);
                ((Intent)localObject1).putExtra("url", paramView.jdField_d_of_type_JavaLangString);
                ((Intent)localObject1).putExtra("hide_operation_bar", true);
                ((Intent)localObject1).putExtra("hide_more_button", true);
                this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity((Intent)localObject1);
              }
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
            for (i = 1;; i = 2)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X8009300", "0X8009300", i, 0, "", "", "", "");
              return;
            }
          }
        }
        catch (SecurityException paramView)
        {
          for (;;)
          {
            continue;
            paramView = "CLICK_HEADER_BG";
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     spp
 * JD-Core Version:    0.7.0.1
 */