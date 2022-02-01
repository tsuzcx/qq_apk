package com.tencent.mobileqq.winkpublish.viewmodel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class PublishViewModel$AEEditorUIBroadcastReceiver
  extends BroadcastReceiver
{
  public PublishViewModel$AEEditorUIBroadcastReceiver(PublishViewModel paramPublishViewModel) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null)
    {
      QLog.e(PublishViewModel.a, 1, "[onReceive] : action is null");
      return;
    }
    if ("AEEDITOR_UPDATE_AI_TEXT".equals(paramContext))
    {
      QLog.d(PublishViewModel.a, 1, "onReceive... AEEDITOR_UPDATE_AI_TEXT");
      PublishViewModel.a(this.a, (HashMap)paramIntent.getSerializableExtra("update_ai_text_map"));
      paramContext = PublishViewModel.a;
      paramIntent = new StringBuilder();
      paramIntent.append("onReceive... mAiTextMap:");
      paramIntent.append(PublishViewModel.a(this.a).toString());
      QLog.d(paramContext, 1, paramIntent.toString());
      if (this.a.h != null)
      {
        paramIntent = this.a.h.entrySet().iterator();
        while (paramIntent.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramIntent.next();
          ArrayList localArrayList = (ArrayList)PublishViewModel.a(this.a).get(localEntry.getKey());
          String str = PublishViewModel.a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("path:");
          localStringBuilder.append((String)localEntry.getKey());
          localStringBuilder.append("\noldTextLabel:");
          localStringBuilder.append(((LocalMediaInfo)localEntry.getValue()).aiTextLabel);
          localStringBuilder.append("\naiTextCache:");
          if (localArrayList != null) {
            paramContext = localArrayList.toString();
          } else {
            paramContext = "null";
          }
          localStringBuilder.append(paramContext);
          QLog.d(str, 1, localStringBuilder.toString());
          if (localArrayList != null) {
            ((LocalMediaInfo)localEntry.getValue()).aiTextLabel = localArrayList;
          }
        }
      }
      this.a.c.postValue(this.a.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.viewmodel.PublishViewModel.AEEditorUIBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */