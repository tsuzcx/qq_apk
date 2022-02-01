package com.tencent.mobileqq.hiboom;

import QC.BubbleRsp;
import QC.CommonRsp;
import QC.FontRsp;
import QC.SetFontBubbleRsp;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper.AIOShortcutBarEvent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.net.URLEncoder;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class FontBubbleManager
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new FontBubbleManager.5(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SetFontBubble jdField_a_of_type_ComTencentMobileqqHiboomSetFontBubble;
  private long[] jdField_a_of_type_ArrayOfLong;
  private SetFontBubble b;
  
  public FontBubbleManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  public static FontBubbleManager a(QQAppInterface paramQQAppInterface)
  {
    return ((VasExtensionManager)paramQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a;
  }
  
  private void a(Context paramContext)
  {
    QQToast.a(paramContext, 0, HardCodeUtil.a(2131704774), 2000).a();
    if (this.b != null)
    {
      paramContext = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      int j = this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.panelType;
      int i;
      if (j == 3) {
        i = this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.fontId;
      } else {
        i = this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.bubbleId;
      }
      VasWebviewUtil.a(paramContext, "aio_iconA", "Send", "", 1, 0, 0, "", Integer.toString(i), FontBubblePanelView.a(j), "1", "", "", "", 0, 0, 0, 0);
    }
    this.b = null;
    this.jdField_a_of_type_ComTencentMobileqqHiboomSetFontBubble = null;
  }
  
  private void a(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontBubbleManager", 2, "sendMsg");
    }
    Object localObject = paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("FontBubbleManager", 1, "sendMsg fail input is empty");
      return;
    }
    ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
    paramBaseChatPie.a(localSendMsgParams);
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)paramBaseChatPie.a(52);
    if (localAIOShortcutBarHelper != null)
    {
      AIOShortcutBarHelper.AIOShortcutBarEvent localAIOShortcutBarEvent = new AIOShortcutBarHelper.AIOShortcutBarEvent(18);
      localAIOShortcutBarEvent.a().putBoolean("isSendToRobotServer", false);
      localAIOShortcutBarHelper.a(localAIOShortcutBarEvent);
      localSendMsgParams.i = localAIOShortcutBarEvent.a().getBoolean("result", false);
    }
    this.jdField_a_of_type_ArrayOfLong = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.a(), paramBaseChatPie.a(), (String)localObject, new ArrayList(), localSendMsgParams);
    paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    paramBaseChatPie.Y();
    localObject = this.b;
    if (localObject != null)
    {
      int j = ((SetFontBubble)localObject).jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.panelType;
      int i;
      if (j == 3) {
        i = this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.fontId;
      } else {
        i = this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.bubbleId;
      }
      VasWebviewUtil.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "aio_iconA", "Send", "", 1, 0, 0, "", Integer.toString(i), FontBubblePanelView.a(j), "0", "", "", "", 0, 0, 0, 0);
      this.b = null;
    }
  }
  
  private void a(BaseChatPie paramBaseChatPie, long paramLong, int paramInt)
  {
    Object localObject5 = this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble;
    Object localObject2 = ((FontBubble)localObject5).title;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = HardCodeUtil.a(2131704775);
    }
    Object localObject3 = ((FontBubble)localObject5).msg;
    localObject2 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject2 = "开通QQ会员即可使用该气泡";
    }
    Object localObject4 = ((FontBubble)localObject5).btn;
    localObject3 = localObject4;
    if (TextUtils.isEmpty((CharSequence)localObject4)) {
      localObject3 = "开通QQ会员";
    }
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("jsbridge://font/fontBubblePaySuccess?p={\"sid\":");
    ((StringBuilder)localObject4).append(paramLong);
    ((StringBuilder)localObject4).append(",\"id\":");
    ((StringBuilder)localObject4).append(paramInt);
    ((StringBuilder)localObject4).append("}");
    localObject4 = URLEncoder.encode(((StringBuilder)localObject4).toString());
    StringBuilder localStringBuilder = AIOUtils.a();
    localStringBuilder.append(((FontBubble)localObject5).payUrl);
    localStringBuilder.append("&return_url=");
    localStringBuilder.append((String)localObject4);
    localObject4 = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("url: ");
      ((StringBuilder)localObject5).append((String)localObject4);
      QLog.d("FontBubbleManager", 2, ((StringBuilder)localObject5).toString());
    }
    DialogUtil.a(paramBaseChatPie.a(), 230, (String)localObject1, (CharSequence)localObject2, HardCodeUtil.a(2131704776), (String)localObject3, new FontBubbleManager.3(this, paramBaseChatPie, (String)localObject4), new FontBubbleManager.4(this)).show();
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    Object localObject = this.b;
    boolean bool2 = false;
    boolean bool1 = false;
    if (localObject != null)
    {
      if (paramInt1 == 5L)
      {
        if (paramInt2 == ((SetFontBubble)localObject).jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.fontId) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool2;
      if (paramInt2 == ((SetFontBubble)localObject).jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.bubbleId) {
        bool1 = true;
      }
      return bool1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" is not currentSelect: ");
    localObject = this.b;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((SetFontBubble)localObject).jdField_a_of_type_ComTencentMobileqqHiboomFontBubble;
    }
    localStringBuilder.append(localObject);
    QLog.e("FontBubbleManager", 1, localStringBuilder.toString());
    return false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfLong;
    if (localObject != null)
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (localObject[i] == paramLong)
        {
          this.jdField_a_of_type_ArrayOfLong = null;
          localObject = this.jdField_a_of_type_ComTencentMobileqqHiboomSetFontBubble;
          if (localObject == null) {
            break;
          }
          ((SetFontBubble)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, Bundle paramBundle)
  {
    int i = paramBundle.getInt("sid");
    int j = paramBundle.getInt("id");
    boolean bool = a(i, j);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onFontBubblePaySuccess: ");
      paramBundle.append(i);
      paramBundle.append(",");
      paramBundle.append(j);
      paramBundle.append(",");
      paramBundle.append(bool);
      QLog.d("FontBubbleManager", 2, paramBundle.toString());
    }
    paramBundle = this.b;
    if (paramBundle != null)
    {
      i = paramBundle.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.panelType;
      VasWebviewUtil.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "aio_iconA", "OpenSvip", "", 1, 0, 0, "", "", FontBubblePanelView.a(i));
      this.b = new SetFontBubble(this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble);
      this.b.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, boolean paramBoolean, SetFontBubbleRsp paramSetFontBubbleRsp, int paramInt)
  {
    if ((paramBoolean) && (paramSetFontBubbleRsp.stRet != null) && (paramSetFontBubbleRsp.stRet.ret == 0))
    {
      localObject = this.b;
      if ((localObject != null) && (((SetFontBubble)localObject).jdField_a_of_type_Int == paramInt))
      {
        if (((this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.panelType == 3) && (paramSetFontBubbleRsp.stFontRsp.authRet == 0)) || ((this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.panelType == 4) && (paramSetFontBubbleRsp.stBubbleRsp.authRet == 0)))
        {
          if (QLog.isColorLevel())
          {
            paramSetFontBubbleRsp = new StringBuilder();
            paramSetFontBubbleRsp.append("onSetFontBubble mClick success: ");
            paramSetFontBubbleRsp.append(this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble);
            QLog.d("FontBubbleManager", 2, paramSetFontBubbleRsp.toString());
          }
          ThreadManagerV2.excute(new FontBubbleManager.2(this, paramBaseChatPie), 32, null, true);
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onSetFontBubble mClick fail: ");
        ((StringBuilder)localObject).append(paramSetFontBubbleRsp.stFontRsp.authRet);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(paramSetFontBubbleRsp.stBubbleRsp.authRet);
        ((StringBuilder)localObject).append(this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble);
        QLog.e("FontBubbleManager", 1, ((StringBuilder)localObject).toString());
        if ((paramSetFontBubbleRsp.stFontRsp.authRet >= 0) && (paramSetFontBubbleRsp.stBubbleRsp.authRet >= 0))
        {
          if (this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.panelType == 3)
          {
            a(paramBaseChatPie, 5L, paramSetFontBubbleRsp.stFontRsp.fontID);
            return;
          }
          a(paramBaseChatPie, 2L, paramSetFontBubbleRsp.stBubbleRsp.bubbleID);
          return;
        }
        a(paramBaseChatPie.a());
        return;
      }
      paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqHiboomSetFontBubble;
      if ((paramBaseChatPie != null) && (paramBaseChatPie.jdField_a_of_type_Int == paramInt))
      {
        if ((paramSetFontBubbleRsp.stFontRsp.authRet == 0) && (paramSetFontBubbleRsp.stBubbleRsp.authRet == 0))
        {
          if (QLog.isColorLevel())
          {
            paramBaseChatPie = new StringBuilder();
            paramBaseChatPie.append("onSetFontBubble mRestore success: ");
            paramBaseChatPie.append(this.jdField_a_of_type_ComTencentMobileqqHiboomSetFontBubble.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble);
            QLog.d("FontBubbleManager", 2, paramBaseChatPie.toString());
          }
        }
        else
        {
          paramBaseChatPie = AIOUtils.a();
          paramBaseChatPie.append("onSetFontBubble failed,");
          paramBaseChatPie.append(" fontAuth:");
          paramBaseChatPie.append(paramSetFontBubbleRsp.stFontRsp.authRet);
          paramBaseChatPie.append(" bubbleAuth:");
          paramBaseChatPie.append(paramSetFontBubbleRsp.stBubbleRsp.authRet);
          paramBaseChatPie.append(this.jdField_a_of_type_ComTencentMobileqqHiboomSetFontBubble.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble);
          QLog.e("FontBubbleManager", 1, paramBaseChatPie.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqHiboomSetFontBubble = null;
        return;
      }
      paramBaseChatPie = AIOUtils.a();
      paramBaseChatPie.append("onSetFontBubble seq out of date,");
      paramBaseChatPie.append(paramSetFontBubbleRsp.stFontRsp.fontID);
      paramBaseChatPie.append(",");
      paramBaseChatPie.append(paramSetFontBubbleRsp.stBubbleRsp.bubbleID);
      paramBaseChatPie.append(" fontAuth:");
      paramBaseChatPie.append(paramSetFontBubbleRsp.stFontRsp.authRet);
      paramBaseChatPie.append(" bubbleAuth:");
      paramBaseChatPie.append(paramSetFontBubbleRsp.stBubbleRsp.authRet);
      QLog.e("FontBubbleManager", 1, paramBaseChatPie.toString());
      return;
    }
    Object localObject = AIOUtils.a();
    ((StringBuilder)localObject).append("onSetFontBubble failed,");
    if ((paramSetFontBubbleRsp != null) && (paramSetFontBubbleRsp.stRet != null))
    {
      ((StringBuilder)localObject).append(paramSetFontBubbleRsp.stFontRsp.fontID);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramSetFontBubbleRsp.stBubbleRsp.bubbleID);
      ((StringBuilder)localObject).append(" ret:");
      ((StringBuilder)localObject).append(paramSetFontBubbleRsp.stRet.ret);
      ((StringBuilder)localObject).append("err:");
      ((StringBuilder)localObject).append(paramSetFontBubbleRsp.stRet.err);
    }
    QLog.e("FontBubbleManager", 1, ((StringBuilder)localObject).toString());
    paramSetFontBubbleRsp = this.b;
    if ((paramSetFontBubbleRsp != null) && (paramSetFontBubbleRsp.jdField_a_of_type_Int == paramInt))
    {
      paramSetFontBubbleRsp = new StringBuilder();
      paramSetFontBubbleRsp.append("click failed: ");
      paramSetFontBubbleRsp.append(this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble);
      QLog.e("FontBubbleManager", 1, paramSetFontBubbleRsp.toString());
    }
    paramSetFontBubbleRsp = this.jdField_a_of_type_ComTencentMobileqqHiboomSetFontBubble;
    if ((paramSetFontBubbleRsp != null) && (paramSetFontBubbleRsp.jdField_a_of_type_Int == paramInt))
    {
      paramSetFontBubbleRsp = new StringBuilder();
      paramSetFontBubbleRsp.append("restore failed: ");
      paramSetFontBubbleRsp.append(this.jdField_a_of_type_ComTencentMobileqqHiboomSetFontBubble.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble);
      QLog.e("FontBubbleManager", 1, paramSetFontBubbleRsp.toString());
    }
    a(paramBaseChatPie.a());
  }
  
  public void a(FontBubble paramFontBubble)
  {
    ThreadManagerV2.excute(new FontBubbleManager.1(this, paramFontBubble), 32, null, true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1000)
    {
      if (i != 1001) {
        return false;
      }
      a((BaseChatPie)paramMessage.obj);
      return true;
    }
    paramMessage = (Object[])paramMessage.obj;
    this.jdField_a_of_type_ComTencentMobileqqHiboomSetFontBubble = new SetFontBubble((FontBubble)paramMessage[0]);
    this.b = new SetFontBubble((FontBubble)paramMessage[1]);
    this.b.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubbleManager
 * JD-Core Version:    0.7.0.1
 */