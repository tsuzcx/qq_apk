package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import sgj;

public final class StructMsgForHypertext$HyperTextView
  extends TextView
  implements View.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext = null;
  boolean jdField_a_of_type_Boolean = false;
  
  public StructMsgForHypertext$HyperTextView(Context paramContext)
  {
    super(paramContext);
    setOnClickListener(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
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
    Object localObject = paramView.getTag(2131376583);
    if ((localObject != null) && ((localObject instanceof StructMsgForHypertext)))
    {
      localObject = (StructMsgForHypertext)localObject;
      if (!((StructMsgForHypertext)localObject).mHyperClick) {
        break label36;
      }
      ((StructMsgForHypertext)localObject).mHyperClick = false;
    }
    label36:
    while (!"web".equals(((StructMsgForHypertext)localObject).mMsgAction)) {
      return;
    }
    paramView = paramView.getContext();
    Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_aio");
    localIntent.putExtra("url", ((StructMsgForHypertext)localObject).mMsgUrl);
    sgj.a(((StructMsgForHypertext)localObject).message, localIntent, ((StructMsgForHypertext)localObject).mMsgUrl);
    paramView.startActivity(localIntent);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_a_of_type_Boolean = false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForHypertext.HyperTextView
 * JD-Core Version:    0.7.0.1
 */