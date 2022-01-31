import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.troop.activity.troopactivity.GroupInfoCardResp;

public class sah
  extends Handler
{
  public sah(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.jdField_c_of_type_Boolean) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {}
    Object localObject3;
    Object localObject4;
    do
    {
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          case 12: 
          case 14: 
          case 2: 
          case 3: 
          case 4: 
          case 7: 
          case 8: 
          case 9: 
          case 11: 
          case 13: 
          case 17: 
          default: 
            return;
          case 1: 
            this.a.d();
            return;
          case 6: 
            if (QLog.isColorLevel()) {
              QLog.i("Q.chatopttroop", 2, "MSG_UPDATE_TROOP_MEMBER_CARD");
            }
            break;
          }
        } while (this.a.jdField_a_of_type_ArrayOfAndroidViewView == null);
        localObject1 = (FormSimpleItem)this.a.jdField_a_of_type_ArrayOfAndroidViewView[6];
      } while (localObject1 == null);
      if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard)) {}
      for (paramMessage = this.a.getString(2131430580);; paramMessage = new QQText(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard, 3))
      {
        ((FormSimpleItem)localObject1).setRightText(paramMessage);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "MSG_UPDATE_INFO");
      }
      if (this.a.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.a.jdField_c_of_type_AndroidWidgetTextView.setText("共" + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "人");
      }
      this.a.A();
      this.a.b(true);
      this.a.f();
      this.a.y();
      this.a.a(this.a.e);
      return;
      paramMessage = paramMessage.getData();
      localObject2 = paramMessage.getStringArrayList("AVATAR_WALL_LIST");
      boolean bool = paramMessage.getBoolean("IS_DEFAULT_AVATAR");
      localObject1 = paramMessage.getStringArray("VERIFYING_PICTURE_LIST");
      paramMessage = (Message)localObject1;
      if (localObject1 == null) {
        paramMessage = new String[0];
      }
      paramMessage = new HashSet(Arrays.asList(paramMessage));
      localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject4 = new AvatarWallAdapter.AvatarInfo();
          ((AvatarWallAdapter.AvatarInfo)localObject4).c = ((String)localObject3);
          ((AvatarWallAdapter.AvatarInfo)localObject4).d = "AVATAR_URL_STR";
          ((AvatarWallAdapter.AvatarInfo)localObject4).b = paramMessage.contains(localObject3);
          ((List)localObject1).add(localObject4);
        }
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a((List)localObject1, bool);
      }
    } while (this.a.j);
    this.a.j = true;
    return;
    ChatSettingForTroop.a(this.a, (troopactivity.GroupInfoCardResp)paramMessage.obj);
    return;
    Object localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags;
    Object localObject1 = new Intent(this.a, TroopTagViewActivity.class);
    ((Intent)localObject1).putExtra("troopuin", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    ((Intent)localObject1).putExtra("isAdmin", false);
    paramMessage = "";
    int i;
    if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText))
    {
      paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText;
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        ((Intent)localObject1).putExtra("subclass", paramMessage);
      }
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        paramMessage = new StringBuffer();
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            paramMessage.append((String)localObject3 + "\n");
            continue;
            if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.a))) {
              break label1542;
            }
            if ("其他".equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.a))
            {
              i = 0;
              break;
            }
            paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.a;
            i = 1;
            break;
          }
        }
        paramMessage.deleteCharAt(paramMessage.length() - 1);
        ((Intent)localObject1).putExtra("tags", paramMessage.toString());
      }
      ((Intent)localObject1).putExtra("act_type", 1);
      ((Intent)localObject1).putExtra("uin", this.a.app.getCurrentAccountUin());
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        this.a.startActivityForResult((Intent)localObject1, 11);
        return;
      }
      this.a.startActivity((Intent)localObject1);
      return;
      localObject4 = this.a.jdField_a_of_type_ArrayOfAndroidViewView[10];
      View localView = this.a.jdField_a_of_type_ArrayOfAndroidViewView[11];
      Switch localSwitch;
      if ((localView != null) && (localObject4 != null) && ((localObject4 instanceof FormSwitchItem)))
      {
        localObject2 = (FormSimpleItem)localView.findViewById(2131371414);
        localSwitch = ((FormSwitchItem)localObject4).a();
        localObject3 = (TextView)localView.findViewById(2131371415);
        ((TextView)localObject3).setBackgroundResource(2130838621);
        localObject1 = "";
        paramMessage = "";
        Boolean localBoolean = (Boolean)this.a.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController.c.get(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        if ((localBoolean != null) && (localBoolean.booleanValue())) {
          break label1336;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
          break;
        }
        i = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopmask;
        if (i != 1) {
          break label1174;
        }
        ((View)localObject4).setBackgroundResource(2130838626);
        ((View)localObject4).getBackground().setAlpha(255);
        if (localSwitch.isChecked())
        {
          localSwitch.setTag(Boolean.TRUE);
          localSwitch.setChecked(false);
        }
        localView.setVisibility(8);
        paramMessage = "";
        localObject1 = "";
        this.a.b.setVisibility(8);
      }
      for (;;)
      {
        ((FormSimpleItem)localObject2).setRightText(new QQText((CharSequence)localObject1, 3));
        ((FormSimpleItem)localObject2).a().setTextColor(this.a.getResources().getColor(2131492891));
        ((TextView)localObject3).setText(paramMessage);
        TroopAssistantManager.a().c(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        return;
        label1174:
        ((View)localObject4).setBackgroundResource(2130838629);
        ((View)localObject4).getBackground().setAlpha(255);
        if (!localSwitch.isChecked())
        {
          localSwitch.setTag(Boolean.TRUE);
          localSwitch.setChecked(true);
        }
        localView.setVisibility(0);
        switch (i)
        {
        default: 
          paramMessage = "";
          localObject1 = "";
          break;
        case 2: 
          localObject1 = this.a.getString(2131430231);
          paramMessage = this.a.getString(2131430239);
          break;
        case 3: 
          localObject1 = this.a.getString(2131435687);
          paramMessage = this.a.getString(2131430240);
          break;
        case 4: 
          localObject1 = this.a.getString(2131430230);
          paramMessage = this.a.getString(2131430238);
          break;
          label1336:
          localView.setVisibility(0);
          ((View)localObject4).setBackgroundResource(2130838629);
          ((View)localObject4).getBackground().setAlpha(255);
          this.a.b.setVisibility(0);
        }
      }
      paramMessage = this.a.jdField_a_of_type_ArrayOfAndroidViewView[28];
      if (paramMessage != null)
      {
        localObject1 = (TextView)paramMessage.findViewById(2131363360);
        if (localObject1 != null)
        {
          ((TextView)localObject1).setTextColor(Color.parseColor("#00b6f9"));
          if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
            ((TextView)localObject1).setAlpha(0.5F);
          }
        }
        paramMessage = (ProgressBar)paramMessage.findViewById(2131364769);
        if (paramMessage != null) {
          paramMessage.setVisibility(8);
        }
      }
      QQToast.a(this.a, 2, this.a.getString(2131434468), 0).a();
      return;
      i = paramMessage.arg1;
      paramMessage = this.a.jdField_a_of_type_ArrayOfAndroidViewView[32];
      if (!(paramMessage instanceof FormSimpleItem)) {
        break;
      }
      localObject1 = (FormSimpleItem)paramMessage;
      if (i == 0) {}
      for (paramMessage = null;; paramMessage = this.a.getResources().getDrawable(2130845923))
      {
        ((FormSimpleItem)localObject1).setRightIcon(paramMessage);
        return;
      }
      label1542:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sah
 * JD-Core Version:    0.7.0.1
 */