import KQQ.BatchResponse;
import KQQ.RespBatchProcess;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.RspBody;

public class sam
  extends TroopObserver
{
  public sam(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(String paramString1, String paramString2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
      this.a.b(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName());
    }
  }
  
  protected void a(oidb_0xaf4.RspBody paramRspBody, int paramInt)
  {
    if (paramRspBody.group_id.has())
    {
      str = String.valueOf(paramRspBody.group_id.get());
      if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, str))) {
        if (QLog.isColorLevel()) {
          QLog.e("Q.chatopttroop", 2, "onGetNewTroopAppList troopUin not match. rsp uin=" + str + ", current uin=" + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        String str;
        do
        {
          return;
        } while (paramInt != 1);
        if (QLog.isColorLevel()) {
          QLog.d("raymondguo", 2, "game feed service type 1 refresh");
        }
        this.a.a(paramRspBody);
        paramRspBody = this.a.jdField_a_of_type_ArrayOfAndroidViewView[31];
        if ((paramRspBody != null) && (paramRspBody.isShown())) {
          TroopReportor.a("Grp_game", "Grp_data", "rank_exp", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        }
        paramRspBody = this.a.jdField_a_of_type_ArrayOfAndroidViewView[32];
      } while ((paramRspBody == null) || (!paramRspBody.isShown()));
      TroopReportor.a("Grp_game", "Grp_data", "feeds_exp", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      return;
    }
    QLog.e("Q.chatopttroop", 2, "onGetNewTroopAppList group_id lost. current uin=" + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(paramLong)));
        if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))))
        {
          this.a.jdField_a_of_type_JavaUtilList.remove(Integer.valueOf(paramInt));
          if (paramTroopInfo != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
          }
          if (paramBoolean)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(1, this.a.getString(2131433486), 1000);
            return;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, this.a.getString(2131433487), 1000);
          ChatSettingForTroop.b(this.a, paramInt);
          return;
        }
      } while ((!paramBoolean) || (paramTroopInfo == null));
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    } while ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() != 0));
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(paramTroopInfo, this.a.app.getCurrentAccountUin());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    this.a.s();
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      do
      {
        return;
      } while (paramLong != Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin));
      if (!paramBoolean) {
        break label194;
      }
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      }
      if (paramTroopInfo.isOnlyTroopMemberInviteOption())
      {
        this.a.b(2131433653, 0);
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = ((short)(byte)paramTroopInfo.cGroupOption);
      if (this.a.isResume()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("qqBaseActivity", 2, "ChatSettingForTroop onOIDB0X88D_1_Ret return----------------");
    return;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3))
    {
      ChatSettingForTroop.c(this.a, 2);
      return;
    }
    ChatSettingForTroop.a(this.a, null);
    return;
    label194:
    this.a.b(2131434447, 1);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List paramList, long paramLong2, int paramInt2, String paramString)
  {
    super.a(paramBoolean, paramLong1, paramInt1, paramList, paramLong2, paramInt2, paramString);
    if ((!TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(paramLong1))) || (paramInt1 != 5)) {}
    do
    {
      return;
      if (paramBoolean)
      {
        ChatSettingForTroop.a(this.a, paramList);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.chatopttroop", 2, "onOIDB0X899_0_Ret, result = " + paramInt2 + "strErrorMsg = " + paramString);
  }
  
  protected void a(boolean paramBoolean, RespBatchProcess paramRespBatchProcess)
  {
    int i = 0;
    if ((this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.a.jdField_a_of_type_AndroidWidgetTextView != null)) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onBatchGetTroopInfoResp, isSucc=").append(paramBoolean).append(", mTroopInfoData IsNull=");
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)
      {
        paramBoolean = true;
        localObject = ((StringBuilder)localObject).append(paramBoolean).append(", resp IsNull=");
        if (paramRespBatchProcess != null) {
          break label166;
        }
        paramBoolean = true;
        label99:
        QLog.d("Q.chatopttroop", 2, paramBoolean);
      }
    }
    else
    {
      if ((paramRespBatchProcess != null) && (paramRespBatchProcess.batch_response_list != null) && (paramRespBatchProcess.batch_response_list.size() != 0) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)) {
        break label171;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "onBatchGetTroopInfoResp, return");
      }
    }
    label166:
    label171:
    int j;
    do
    {
      return;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label99;
      j = paramRespBatchProcess.batch_response_list.size();
      if (i < j)
      {
        localObject = (BatchResponse)paramRespBatchProcess.batch_response_list.get(i);
        if ((localObject == null) || (((BatchResponse)localObject).result != 0)) {}
        for (;;)
        {
          i += 1;
          break;
          if (((BatchResponse)localObject).type == 1) {
            this.a.a((BatchResponse)localObject);
          }
        }
      }
    } while (j <= 0);
    this.a.u();
    this.a.b(true);
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.e != null)) {
      this.a.a(this.a.e);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (!Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)));
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "onGetTroopInfoResult|uin = " + paramString);
      }
      paramString = ((TroopManager)this.a.app.getManager(51)).a(paramString);
    } while (paramString == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramString;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopChatSetting(paramString, this.a.getResources(), this.a.app.getCurrentAccountUin());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!paramBoolean)
    {
      QQToast.a(this.a, this.a.getString(2131430374), 0).b(this.a.getTitleBarHeight());
      ChatSettingForTroop.f(this.a);
    }
  }
  
  protected void a(boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2)
  {
    ThreadManager.post(new san(this), 8, null, true);
  }
  
  protected boolean a(ArrayList paramArrayList)
  {
    int i = 0;
    Object localObject = null;
    if ((localObject == null) && (i < paramArrayList.size()))
    {
      TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(i);
      if (localTroopMemberCardInfo == null) {
        localObject = localTroopMemberCardInfo;
      }
      for (;;)
      {
        i += 1;
        break;
        if (Utils.a(localTroopMemberCardInfo.troopuin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
        {
          localObject = localTroopMemberCardInfo;
          if (Utils.a(localTroopMemberCardInfo.memberuin, this.a.app.getCurrentAccountUin())) {}
        }
        else
        {
          localObject = null;
        }
      }
    }
    paramArrayList = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard;
    if ((localObject != null) && (!Utils.a(paramArrayList, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard)))
    {
      paramArrayList = localObject.name;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard = localObject.name;
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    }
    return localObject != null;
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = TroopInfo.getTags(paramString);
      ThreadManager.post(new sao(this), 8, null, true);
    }
  }
  
  protected void b(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0));
      localObject = null;
      int i = 0;
      if ((localObject == null) && (i < paramArrayList.size()))
      {
        TroopInfo localTroopInfo = (TroopInfo)paramArrayList.get(i);
        if (localTroopInfo == null) {
          localObject = localTroopInfo;
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = localTroopInfo;
          if (!Utils.a(localTroopInfo.troopuin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
            localObject = null;
          }
        }
      }
    } while (localObject == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localObject;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopChatSetting(localObject, this.a.getResources(), this.a.app.getCurrentAccountUin());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    try
    {
      long l1 = Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      long l2 = Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode);
      TroopNotificationHelper.a(this.a.app, 0, l2, l1, 0L, "", 0, "OidbSvc.0x852_48", (short)23, false, false);
      return;
    }
    catch (Exception paramArrayList) {}
  }
  
  protected void c(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      this.a.l = paramInt;
    }
  }
  
  protected void c(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    boolean bool;
    do
    {
      return;
      if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0)) {}
      for (bool = false;; bool = a(paramArrayList))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
        }
        if ((paramBoolean) || ((this.a.c & 0x1) != 1)) {
          break;
        }
        paramArrayList = this.a;
        paramArrayList.c &= 0xFFFFFFFE;
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131433639, 1000);
        return;
      }
    } while ((!bool) || ((this.a.c & 0x1) != 1));
    paramArrayList = this.a;
    paramArrayList.c &= 0xFFFFFFFE;
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(1, 2131433638, 1000);
  }
  
  protected void d(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    while ((!paramBoolean) || (paramArrayList == null)) {
      return;
    }
    a(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sam
 * JD-Core Version:    0.7.0.1
 */