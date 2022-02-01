package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Intent;
import android.net.Uri;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

public class GiftAppInfo
  extends PlusPanelAppInfo
{
  GiftAppInfo() {}
  
  public GiftAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  private int a(BaseChatPie paramBaseChatPie)
  {
    if ((paramBaseChatPie instanceof TroopChatPie)) {
      return 1;
    }
    if ((paramBaseChatPie instanceof FriendChatPie)) {
      return 2;
    }
    if ((paramBaseChatPie instanceof DiscussChatPie)) {
      return 6;
    }
    if ((paramBaseChatPie instanceof StrangerChatPie)) {
      return 7;
    }
    if ((paramBaseChatPie instanceof NearbyChatPie)) {
      return 3;
    }
    return 0;
  }
  
  private void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    int i = 1;
    try
    {
      Object localObject = QzoneConfig.getInstance().getConfig("H5Url", "C2CPlusGiftJumpUrl", "https://h5.qzone.qq.com/giftv2/sendDialog?_wv=16781315&_wwv=13&_proxy=1&themeMode={themeMode}&uin={uin}");
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {}
      for (;;)
      {
        paramSessionInfo = ((String)localObject).replace("{uin}", paramSessionInfo.jdField_a_of_type_JavaLangString).replace("{themeMode}", i + "");
        localObject = new Intent(paramBaseChatPie.a(), QQTranslucentBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramSessionInfo);
        ((Intent)localObject).setData(Uri.parse(paramSessionInfo));
        ((Intent)localObject).putExtra("flag_show_loading_dialog", true);
        ((Intent)localObject).putExtra("hide_left_button", true);
        paramBaseChatPie.a().startActivity((Intent)localObject);
        return;
        i = 0;
      }
      return;
    }
    catch (Exception paramBaseChatPie)
    {
      QLog.e("GiftAppInfo", 2, paramBaseChatPie, new Object[0]);
    }
  }
  
  private void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, boolean paramBoolean, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if ((paramBaseChatPie instanceof NearbyChatPie))
    {
      paramSessionInfo = paramSessionInfo.jdField_a_of_type_JavaLangString;
      if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002)
      {
        paramBaseChatPie = "3";
        NearbyFlowerManager.a("gift_aio", "clk_icon", paramSessionInfo, paramBaseChatPie, "", "");
      }
    }
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "dc00899", "grp_lbs", "", "qq_gift", "plus_entry_clk", 0, 0, paramInt + "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("GiftAppInfo", 2, "PlusPanel onGiftClick, aioType=" + paramInt);
      }
      return;
      paramBaseChatPie = "0";
      break;
      if (paramInt == 2) {
        ReportController.b(paramQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "gift_clk", 0, 0, "", "", "", "");
      } else if (paramInt == 6) {
        ReportController.b(paramQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "gift_clk", 0, 0, "", "", "", "");
      } else if (paramInt == 7) {
        ReportController.b(paramQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "gift_clk", 0, 0, "", "", "", "");
      } else if (paramInt == 1) {
        if (AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
          ReportController.b(null, "dc00899", "Grp_anon", "", "aio_plus", "clk_send", 1, 0, "" + paramSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        } else {
          ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_plus", 0, 0, "" + paramSessionInfo.jdField_a_of_type_JavaLangString, "" + paramBoolean, "", "");
        }
      }
    }
  }
  
  private boolean a(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface)
  {
    paramBaseChatPie.m(true);
    long l1 = System.currentTimeMillis();
    paramBaseChatPie = paramBaseChatPie.a();
    if (paramBaseChatPie != null)
    {
      long l2 = paramBaseChatPie.jdField_a_of_type_Long;
      if ((paramBaseChatPie.jdField_a_of_type_Boolean) && (l1 >= paramBaseChatPie.jdField_a_of_type_Long) && (l1 <= l2 + 2592000000L) && (!((TroopGiftManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a())) {
        return true;
      }
    }
    return false;
  }
  
  public int defaultDrawableID()
  {
    return 2130851186;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 213;
    }
    return 1104874204;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 518;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130213;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131697298);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("testing", 2, "deliver flowers!");
    }
    boolean bool = false;
    QQAppInterface localQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i = a(paramBaseChatPie);
    if (isC2C())
    {
      a(paramBaseChatPie, paramSessionInfo);
      a(paramBaseChatPie, paramSessionInfo, bool, localQQAppInterface, i);
      if (i != 7) {
        break label96;
      }
    }
    label96:
    for (paramSessionInfo = "chat_tool_gift_stranger_clicked";; paramSessionInfo = "chat_tool_gift_clicked")
    {
      paramPlusPanelViewModel.a(paramSessionInfo, localQQAppInterface.getCurrentAccountUin());
      paramPlusPanelViewModel.b(paramBaseChatPie);
      return;
      bool = a(paramBaseChatPie, localQQAppInterface);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.GiftAppInfo
 * JD-Core Version:    0.7.0.1
 */