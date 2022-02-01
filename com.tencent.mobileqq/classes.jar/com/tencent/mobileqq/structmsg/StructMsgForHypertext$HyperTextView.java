package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Field;

public final class StructMsgForHypertext$HyperTextView
  extends TextView
  implements View.OnClickListener
{
  boolean a = false;
  Context b = null;
  
  public StructMsgForHypertext$HyperTextView(Context paramContext)
  {
    super(paramContext);
    setOnClickListener(this);
    this.b = paramContext;
  }
  
  public boolean a()
  {
    if ((!this.a) && (!a(this))) {
      return true;
    }
    this.a = false;
    return false;
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
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, paramObject.getMessage(), paramObject);
      }
    }
    catch (NoSuchFieldException paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, paramObject.getMessage(), paramObject);
      }
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag(2131446476);
    if ((localObject != null) && ((localObject instanceof StructMsgForHypertext)))
    {
      localObject = (StructMsgForHypertext)localObject;
      if (((StructMsgForHypertext)localObject).mHyperClick)
      {
        ((StructMsgForHypertext)localObject).mHyperClick = false;
      }
      else if ("web".equals(((StructMsgForHypertext)localObject).mMsgAction))
      {
        Context localContext = paramView.getContext();
        Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_aio");
        localIntent.putExtra("url", ((StructMsgForHypertext)localObject).mMsgUrl);
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(((StructMsgForHypertext)localObject).message, localIntent, ((StructMsgForHypertext)localObject).mMsgUrl);
        localContext.startActivity(localIntent);
        this.a = true;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.a = false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForHypertext.HyperTextView
 * JD-Core Version:    0.7.0.1
 */