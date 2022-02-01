package com.tencent.mobileqq.flashchat;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.hiboom.HiBoomConstants;
import com.tencent.mobileqq.hiboom.RichTextPanelExtendHelper;
import com.tencent.mobileqq.hiboom.RichTextPanelView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class FlashChatPanelView
  extends RichTextPanelView
  implements OnHolderItemClickListener
{
  private static final String a = HardCodeUtil.a(2131902621);
  private FlashChatTextEffectView b;
  private BaseChatPie c = null;
  private RichTextPanelExtendHelper d;
  
  public FlashChatPanelView(Context paramContext, BaseChatPie paramBaseChatPie, RichTextPanelExtendHelper paramRichTextPanelExtendHelper)
  {
    super(paramContext);
    this.c = paramBaseChatPie;
    this.d = paramRichTextPanelExtendHelper;
    e();
  }
  
  private void e()
  {
    this.b = new FlashChatTextEffectView(getContext(), this.c, this, 0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.b, localLayoutParams);
    this.b.setPanelExtendHelper(this.d);
  }
  
  public void a()
  {
    this.b.f();
    this.b.h();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (!HiBoomConstants.c.get()) {
      return;
    }
    Object localObject = new StringBuilder();
    FlashChatPanel.PluginData localPluginData = this.b.a(paramInt1);
    if ((localPluginData != null) && (localPluginData.f != null)) {
      paramInt1 = localPluginData.f.id;
    } else {
      paramInt1 = -1;
    }
    paramView = (FlashChatManager)this.c.d.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
    paramView.c(((StringBuilder)localObject).toString());
    if (this.c.Y.getText().toString().isEmpty())
    {
      if (localPluginData == null) {
        return;
      }
      if (localPluginData.f == null) {
        return;
      }
      paramInt1 = localPluginData.f.id;
      return;
    }
    localObject = FlashChatManager.b(this.c.Y.getText().toString()).replaceAll("\\s", "");
    if (((String)localObject).length() <= 20)
    {
      paramView = paramView.a((String)localObject, 0, paramInt1);
      if (paramView != null)
      {
        this.c.Y.setText("");
        this.c.Y.setCompoundDrawables(null, null, null, null);
        this.c.Y.setTag(2131441550, null);
        this.c.Y.setSelection(0);
        ChatActivityFacade.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this.c.aE(), paramView);
        ReportController.b(this.c.d, "CliOper", "", "", "0X80094D6", "0X80094D6", 0, 0, "", "", "", "");
        this.c.aF();
      }
    }
    else
    {
      QQToast.makeText(getContext(), HardCodeUtil.a(2131902620), 0).show();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      FlashChatManager localFlashChatManager = (FlashChatManager)this.c.d.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
      if (localFlashChatManager.g().size() < 3) {
        localFlashChatManager.f();
      }
      this.b.f();
      d();
      return;
    }
    this.b.g.removeMessages(0);
    this.b.g.removeMessages(1);
    this.b.g.removeMessages(2);
    this.b.g.removeMessages(3);
    this.b.g.removeMessages(4);
    this.b.i.clear();
    this.b.c();
    this.b.e();
  }
  
  public void b()
  {
    this.b.g.removeMessages(0);
    this.b.g.removeMessages(1);
    this.b.g.removeMessages(2);
    this.b.g.removeMessages(3);
    this.b.g.removeMessages(4);
    this.b.i.clear();
    this.b.c();
    this.b.e();
  }
  
  public void b(View paramView, int paramInt1, int paramInt2) {}
  
  public void bO_()
  {
    this.b.i.clear();
    this.b.c();
    this.b.g();
    this.b.d();
    if (this.b.g != null) {
      this.b.g.removeCallbacksAndMessages(null);
    }
  }
  
  public void d()
  {
    this.b.h();
  }
  
  public String getName()
  {
    return a;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatPanelView
 * JD-Core Version:    0.7.0.1
 */