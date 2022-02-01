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
  private Handler a;
  private QQAppInterface b;
  private SetFontBubble c;
  private SetFontBubble d;
  private long[] e;
  private MessageObserver f = new FontBubbleManager.5(this);
  
  public FontBubbleManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    this.a = new Handler(Looper.getMainLooper(), this);
    this.b.addObserver(this.f);
  }
  
  public static FontBubbleManager a(QQAppInterface paramQQAppInterface)
  {
    return ((VasExtensionManager)paramQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).g;
  }
  
  private void a(Context paramContext)
  {
    QQToast.makeText(paramContext, 0, HardCodeUtil.a(2131902676), 2000).show();
    if (this.d != null)
    {
      paramContext = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      int j = this.d.b.panelType;
      int i;
      if (j == 3) {
        i = this.d.b.fontId;
      } else {
        i = this.d.b.bubbleId;
      }
      VasWebviewUtil.a(paramContext, "aio_iconA", "Send", "", 1, 0, 0, "", Integer.toString(i), FontBubblePanelView.a(j), "1", "", "", "", 0, 0, 0, 0);
    }
    this.d = null;
    this.c = null;
  }
  
  private void a(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontBubbleManager", 2, "sendMsg");
    }
    Object localObject = paramBaseChatPie.Y.getText().toString();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("FontBubbleManager", 1, "sendMsg fail input is empty");
      return;
    }
    ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
    paramBaseChatPie.a(localSendMsgParams);
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)paramBaseChatPie.q(52);
    if (localAIOShortcutBarHelper != null)
    {
      AIOShortcutBarHelper.AIOShortcutBarEvent localAIOShortcutBarEvent = new AIOShortcutBarHelper.AIOShortcutBarEvent(18);
      localAIOShortcutBarEvent.a().putBoolean("isSendToRobotServer", false);
      localAIOShortcutBarHelper.a(localAIOShortcutBarEvent);
      localSendMsgParams.y = localAIOShortcutBarEvent.a().getBoolean("result", false);
    }
    this.e = ChatActivityFacade.a(this.b, paramBaseChatPie.aX(), paramBaseChatPie.aE(), (String)localObject, new ArrayList(), localSendMsgParams);
    paramBaseChatPie.Y.setText("");
    paramBaseChatPie.aF();
    localObject = this.d;
    if (localObject != null)
    {
      int j = ((SetFontBubble)localObject).b.panelType;
      int i;
      if (j == 3) {
        i = this.d.b.fontId;
      } else {
        i = this.d.b.bubbleId;
      }
      VasWebviewUtil.a(paramBaseChatPie.d.getCurrentUin(), "aio_iconA", "Send", "", 1, 0, 0, "", Integer.toString(i), FontBubblePanelView.a(j), "0", "", "", "", 0, 0, 0, 0);
      this.d = null;
    }
  }
  
  private void a(BaseChatPie paramBaseChatPie, long paramLong, int paramInt)
  {
    Object localObject5 = this.d.b;
    Object localObject2 = ((FontBubble)localObject5).title;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = HardCodeUtil.a(2131902677);
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
    DialogUtil.a(paramBaseChatPie.aX(), 230, (String)localObject1, (CharSequence)localObject2, HardCodeUtil.a(2131898212), (String)localObject3, new FontBubbleManager.3(this, paramBaseChatPie, (String)localObject4), new FontBubbleManager.4(this)).show();
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    Object localObject = this.d;
    boolean bool2 = false;
    boolean bool1 = false;
    if (localObject != null)
    {
      if (paramInt1 == 5L)
      {
        if (paramInt2 == ((SetFontBubble)localObject).b.fontId) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool2;
      if (paramInt2 == ((SetFontBubble)localObject).b.bubbleId) {
        bool1 = true;
      }
      return bool1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" is not currentSelect: ");
    localObject = this.d;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((SetFontBubble)localObject).b;
    }
    localStringBuilder.append(localObject);
    QLog.e("FontBubbleManager", 1, localStringBuilder.toString());
    return false;
  }
  
  public void a()
  {
    this.b.removeObserver(this.f);
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (localObject[i] == paramLong)
        {
          this.e = null;
          localObject = this.c;
          if (localObject == null) {
            break;
          }
          ((SetFontBubble)localObject).a(this.b);
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
    paramBundle = this.d;
    if (paramBundle != null)
    {
      i = paramBundle.b.panelType;
      VasWebviewUtil.a(paramBaseChatPie.d.getCurrentUin(), "aio_iconA", "OpenSvip", "", 1, 0, 0, "", "", FontBubblePanelView.a(i));
      this.d = new SetFontBubble(this.d.b);
      this.d.a(this.b);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, boolean paramBoolean, SetFontBubbleRsp paramSetFontBubbleRsp, int paramInt)
  {
    if ((paramBoolean) && (paramSetFontBubbleRsp.stRet != null) && (paramSetFontBubbleRsp.stRet.ret == 0))
    {
      localObject = this.d;
      if ((localObject != null) && (((SetFontBubble)localObject).a == paramInt))
      {
        if (((this.d.b.panelType == 3) && (paramSetFontBubbleRsp.stFontRsp.authRet == 0)) || ((this.d.b.panelType == 4) && (paramSetFontBubbleRsp.stBubbleRsp.authRet == 0)))
        {
          if (QLog.isColorLevel())
          {
            paramSetFontBubbleRsp = new StringBuilder();
            paramSetFontBubbleRsp.append("onSetFontBubble mClick success: ");
            paramSetFontBubbleRsp.append(this.d.b);
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
        ((StringBuilder)localObject).append(this.d.b);
        QLog.e("FontBubbleManager", 1, ((StringBuilder)localObject).toString());
        if ((paramSetFontBubbleRsp.stFontRsp.authRet >= 0) && (paramSetFontBubbleRsp.stBubbleRsp.authRet >= 0))
        {
          if (this.d.b.panelType == 3)
          {
            a(paramBaseChatPie, 5L, paramSetFontBubbleRsp.stFontRsp.fontID);
            return;
          }
          a(paramBaseChatPie, 2L, paramSetFontBubbleRsp.stBubbleRsp.bubbleID);
          return;
        }
        a(paramBaseChatPie.aX());
        return;
      }
      paramBaseChatPie = this.c;
      if ((paramBaseChatPie != null) && (paramBaseChatPie.a == paramInt))
      {
        if ((paramSetFontBubbleRsp.stFontRsp.authRet == 0) && (paramSetFontBubbleRsp.stBubbleRsp.authRet == 0))
        {
          if (QLog.isColorLevel())
          {
            paramBaseChatPie = new StringBuilder();
            paramBaseChatPie.append("onSetFontBubble mRestore success: ");
            paramBaseChatPie.append(this.c.b);
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
          paramBaseChatPie.append(this.c.b);
          QLog.e("FontBubbleManager", 1, paramBaseChatPie.toString());
        }
        this.c = null;
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
    paramSetFontBubbleRsp = this.d;
    if ((paramSetFontBubbleRsp != null) && (paramSetFontBubbleRsp.a == paramInt))
    {
      paramSetFontBubbleRsp = new StringBuilder();
      paramSetFontBubbleRsp.append("click failed: ");
      paramSetFontBubbleRsp.append(this.d.b);
      QLog.e("FontBubbleManager", 1, paramSetFontBubbleRsp.toString());
    }
    paramSetFontBubbleRsp = this.c;
    if ((paramSetFontBubbleRsp != null) && (paramSetFontBubbleRsp.a == paramInt))
    {
      paramSetFontBubbleRsp = new StringBuilder();
      paramSetFontBubbleRsp.append("restore failed: ");
      paramSetFontBubbleRsp.append(this.c.b);
      QLog.e("FontBubbleManager", 1, paramSetFontBubbleRsp.toString());
    }
    a(paramBaseChatPie.aX());
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
    this.c = new SetFontBubble((FontBubble)paramMessage[0]);
    this.d = new SetFontBubble((FontBubble)paramMessage[1]);
    this.d.a(this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubbleManager
 * JD-Core Version:    0.7.0.1
 */