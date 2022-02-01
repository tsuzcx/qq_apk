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
import com.tencent.mobileqq.hiboom.HiBoomManager;
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
  private static final String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131704638);
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
  private FlashChatTextEffectView jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView;
  private RichTextPanelExtendHelper jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper;
  
  public FlashChatPanelView(Context paramContext, BaseChatPie paramBaseChatPie, RichTextPanelExtendHelper paramRichTextPanelExtendHelper)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper = paramRichTextPanelExtendHelper;
    e();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView = new FlashChatTextEffectView(getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this, 0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.setPanelExtendHelper(this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper);
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.f();
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.h();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (!HiBoomManager.c.get()) {}
    label128:
    do
    {
      return;
      Object localObject = new StringBuilder();
      FlashChatPanel.PluginData localPluginData = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.a(paramInt1);
      if ((localPluginData != null) && (localPluginData.a != null)) {}
      for (paramInt1 = localPluginData.a.id;; paramInt1 = -1)
      {
        paramView = (FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
        paramView.a(((StringBuilder)localObject).toString());
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().isEmpty()) {
          break label128;
        }
        if ((localPluginData == null) || (localPluginData.a == null) || (localPluginData.a.id != -100001)) {
          break;
        }
        return;
      }
      localObject = FlashChatManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()).replaceAll("\\s", "");
      if (((String)localObject).length() > 20) {
        break;
      }
      paramView = paramView.a((String)localObject, 0, paramInt1);
    } while (paramView == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131374320, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(0);
    ChatActivityFacade.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), paramView);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80094D6", "0X80094D6", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.ax();
    return;
    QQToast.a(getContext(), HardCodeUtil.a(2131704637), 0).a();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      FlashChatManager localFlashChatManager = (FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
      if (localFlashChatManager.a().size() < 3) {
        localFlashChatManager.c();
      }
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.f();
      d();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.jdField_a_of_type_MqqOsMqqHandler.removeMessages(4);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.c();
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.e();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.jdField_a_of_type_MqqOsMqqHandler.removeMessages(4);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.c();
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.e();
  }
  
  public void b(View paramView, int paramInt1, int paramInt2) {}
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.c();
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.g();
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.d();
    if (this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.h();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatPanelView
 * JD-Core Version:    0.7.0.1
 */