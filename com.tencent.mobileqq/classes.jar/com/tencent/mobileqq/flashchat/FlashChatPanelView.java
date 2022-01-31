package com.tencent.mobileqq.flashchat;

import aanz;
import ajya;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import apyw;
import apze;
import aqxj;
import axqy;
import bcql;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hiboom.RichTextPanelView;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class FlashChatPanelView
  extends RichTextPanelView
  implements apze
{
  private static final String jdField_a_of_type_JavaLangString = ajya.a(2131704622);
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private FlashChatTextEffectView jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView;
  
  public FlashChatPanelView(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    e();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView = new FlashChatTextEffectView(getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this, 0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView, localLayoutParams);
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
    if (!aqxj.c.get()) {}
    label128:
    do
    {
      return;
      Object localObject = new StringBuilder();
      apyw localapyw = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.a(paramInt1);
      if ((localapyw != null) && (localapyw.a != null)) {}
      for (paramInt1 = localapyw.a.id;; paramInt1 = -1)
      {
        paramView = (FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217);
        paramView.a(((StringBuilder)localObject).toString());
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().isEmpty()) {
          break label128;
        }
        if ((localapyw == null) || (localapyw.a == null) || (localapyw.a.id != -100001)) {
          break;
        }
        return;
      }
      localObject = FlashChatManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()).replaceAll("\\s", "");
      if (((String)localObject).length() > 20) {
        break;
      }
      paramView = paramView.a((String)localObject, 0, paramInt1);
    } while (paramView == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131372739, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(0);
    aanz.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), paramView);
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80094D6", "0X80094D6", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aC();
    return;
    bcql.a(getContext(), ajya.a(2131704621), 0).a();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      FlashChatManager localFlashChatManager = (FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatPanelView
 * JD-Core Version:    0.7.0.1
 */