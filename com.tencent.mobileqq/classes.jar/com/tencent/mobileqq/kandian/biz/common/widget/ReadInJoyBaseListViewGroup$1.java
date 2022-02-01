package com.tencent.mobileqq.kandian.biz.common.widget;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.base.view.widget.KandianProgressView;
import com.tencent.mobileqq.kandian.biz.ugc.KanDianVideoUploadUtils;
import com.tencent.mobileqq.kandian.biz.ugc.KandianVideoUploadService.ICallBack;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class ReadInJoyBaseListViewGroup$1
  implements KandianVideoUploadService.ICallBack
{
  ReadInJoyBaseListViewGroup$1(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup) {}
  
  public void a(Bundle paramBundle, float paramFloat)
  {
    String str = paramBundle.getString("mTaskID");
    ReadInJoyBaseListViewGroup.a(this.a, paramBundle, "");
    if (this.a.f.get(str) != null) {
      ((KandianProgressView)this.a.f.get(str)).a((int)paramFloat);
    }
  }
  
  public void a(Bundle paramBundle, int paramInt, float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBundle.getString("mTaskID"));
    localStringBuilder.append("service中的状态:");
    localStringBuilder.append(paramInt);
    QLog.d("KandianVideoUpload", 1, localStringBuilder.toString());
    switch (paramInt)
    {
    default: 
      return;
    case 202: 
      ReadInJoyBaseListViewGroup.a(this.a, paramBundle, "failed");
      return;
    case 201: 
      KanDianVideoUploadUtils.b(paramBundle);
      return;
    }
    this.a.h.a(paramBundle, (int)paramFloat);
  }
  
  public void a(Bundle paramBundle, String paramString)
  {
    paramString = paramBundle.getString("mTaskID");
    ReadInJoyBaseListViewGroup.a(this.a, paramBundle, "failed");
    if (this.a.f.get(paramString) != null) {
      ((KandianProgressView)this.a.f.get(paramString)).a();
    }
  }
  
  public void a(String paramString)
  {
    this.a.getCurrentActivity();
    ReadInJoyLogicEngine.a().b(true);
    ReadInJoyBaseListViewGroup.a(this.a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListViewGroup.1
 * JD-Core Version:    0.7.0.1
 */