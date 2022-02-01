package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class KanDianVideoUploadBrocast
  extends BroadcastReceiver
{
  ArrayList<String> a = new ArrayList();
  
  private void a(Context paramContext, int paramInt, CharSequence paramCharSequence)
  {
    if (paramContext == null) {
      return;
    }
    QQToast.makeText(paramContext, paramInt, paramCharSequence, 0).show(paramContext.getResources().getDimensionPixelSize(2131299920));
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("mTaskID");
    int i;
    try
    {
      i = Integer.valueOf(paramIntent.getStringExtra("mState")).intValue();
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("解析广播状态异常");
      localStringBuilder2.append(localException.toString());
      Log.d("KandianVideoUpload", localStringBuilder2.toString());
      i = 0;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("收到广播taskID  ");
    localStringBuilder1.append(str);
    localStringBuilder1.append("  state:");
    localStringBuilder1.append(i);
    localStringBuilder1.append(" 当前的taskiD list大小");
    localStringBuilder1.append(this.a.size());
    Log.d("KandianVideoUpload", localStringBuilder1.toString());
    if ((!this.a.isEmpty()) && (!this.a.contains(str))) {
      return;
    }
    if (i != 204)
    {
      if (i != 205) {
        return;
      }
      str = paramIntent.getStringExtra("mfaileMessage");
      paramIntent = str;
      if (TextUtils.isEmpty(str)) {
        paramIntent = paramContext.getString(2131915349);
      }
      a(paramContext, 1, paramIntent);
      return;
    }
    a(paramContext, 2, paramContext.getString(2131915567));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.KanDianVideoUploadBrocast
 * JD-Core Version:    0.7.0.1
 */