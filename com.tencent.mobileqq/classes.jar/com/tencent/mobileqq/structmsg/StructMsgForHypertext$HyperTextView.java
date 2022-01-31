package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public final class StructMsgForHypertext$HyperTextView
  extends TextView
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  Context jdField_a_of_type_AndroidContentContext = null;
  boolean jdField_a_of_type_Boolean = false;
  
  public StructMsgForHypertext$HyperTextView(Context paramContext, int paramInt)
  {
    super(paramContext);
    setOnClickListener(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Boolean) || (a(this)))
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    return true;
  }
  
  public boolean a(Object paramObject)
  {
    try
    {
      Field localField = Class.forName("android.view.View").getDeclaredField("mHasPerformedLongPress");
      localField.setAccessible(true);
      boolean bool = ((Boolean)localField.get(paramObject)).booleanValue();
      return bool;
    }
    catch (NoSuchFieldException paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, paramObject.getMessage(), paramObject);
      }
      return false;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, paramObject.getMessage(), paramObject);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag(2131361855);
    if ((localObject1 != null) && ((localObject1 instanceof StructMsgForHypertext)))
    {
      localObject1 = (StructMsgForHypertext)localObject1;
      if (((StructMsgForHypertext)localObject1).mHyperClick) {
        ((StructMsgForHypertext)localObject1).mHyperClick = false;
      }
    }
    for (;;)
    {
      return;
      Object localObject3;
      if ("web".equals(((StructMsgForHypertext)localObject1).mMsgAction))
      {
        localObject3 = paramView.getContext();
        Intent localIntent = new Intent((Context)localObject3, QQBrowserActivity.class);
        localIntent.putExtra("url", ((StructMsgForHypertext)localObject1).mMsgUrl);
        PublicAccountUtil.a(((StructMsgForHypertext)localObject1).message, localIntent, ((StructMsgForHypertext)localObject1).mMsgUrl);
        ((Context)localObject3).startActivity(localIntent);
        this.jdField_a_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_Int == 1) {
        continue;
      }
      try
      {
        localObject1 = AIOUtils.a(paramView);
        if ((localObject1 == null) || (((ChatMessage)localObject1).istroop != 1024) || (((MessageForStructing)localObject1).structingMsg.mMsgServiceID != 120)) {
          continue;
        }
        paramView = paramView.getTag(2131361856);
        if ((paramView == null) || (!(paramView instanceof StructMsgForHypertext))) {
          continue;
        }
        paramView = (StructMsgForHypertext)paramView;
        if (paramView.mHpertextArray == null) {
          continue;
        }
        paramView = paramView.mHpertextArray.iterator();
        do
        {
          if (!paramView.hasNext()) {
            break;
          }
          localObject3 = (StructMsgForHypertext.Hypertext)paramView.next();
        } while (TextUtils.isEmpty(((StructMsgForHypertext.Hypertext)localObject3).b));
        paramView = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if (paramView != null)
        {
          paramView = paramView.a();
          if (paramView == null) {
            continue;
          }
          ((QidianManager)paramView.getManager(164)).a(((StructMsgForHypertext.Hypertext)localObject3).b, ((StructMsgForHypertext.Hypertext)localObject3).d, ((StructMsgForHypertext.Hypertext)localObject3).c, ((StructMsgForHypertext.Hypertext)localObject3).a, 1, "");
          ((ChatMessage)localObject1).saveExtInfoToExtStr("qidian_hypertext_click_state", "1");
          ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b(131076);
          return;
        }
      }
      catch (ClassCastException localClassCastException)
      {
        for (;;)
        {
          Object localObject2 = null;
          continue;
          paramView = BaseApplicationImpl.getApplication().getRuntime();
          if ((paramView instanceof QQAppInterface)) {
            paramView = (QQAppInterface)paramView;
          } else {
            paramView = null;
          }
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_a_of_type_Boolean = false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForHypertext.HyperTextView
 * JD-Core Version:    0.7.0.1
 */