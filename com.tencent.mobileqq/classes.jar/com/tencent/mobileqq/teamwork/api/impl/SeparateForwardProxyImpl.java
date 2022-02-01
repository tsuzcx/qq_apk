package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.chathistory.SeparateForward;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.teamwork.api.ISeparateForwardProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SeparateForwardProxyImpl
  implements ISeparateForwardProxy
{
  private SeparateForward forwardManager;
  
  public void createSeparateForward(Activity paramActivity, int paramInt)
  {
    if ((paramActivity instanceof QBaseActivity)) {
      this.forwardManager = new SeparateForward((QBaseActivity)paramActivity, 109);
    }
  }
  
  public void forward(Object paramObject)
  {
    if ((this.forwardManager != null) && ((paramObject instanceof List)))
    {
      Object localObject1 = (List)paramObject;
      paramObject = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof ChatMessage)) {
          paramObject.add((ChatMessage)localObject2);
        }
      }
      this.forwardManager.a(paramObject);
    }
  }
  
  public void onCreate()
  {
    SeparateForward localSeparateForward = this.forwardManager;
    if (localSeparateForward != null) {
      localSeparateForward.a();
    }
  }
  
  public void onDestroy()
  {
    SeparateForward localSeparateForward = this.forwardManager;
    if (localSeparateForward != null) {
      localSeparateForward.b();
    }
  }
  
  public void onFowardActivityResult(Intent paramIntent)
  {
    SeparateForward localSeparateForward = this.forwardManager;
    if (localSeparateForward != null) {
      localSeparateForward.a(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.SeparateForwardProxyImpl
 * JD-Core Version:    0.7.0.1
 */