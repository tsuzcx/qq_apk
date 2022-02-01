package com.tencent.mobileqq.kandian.glue.webplugin;

import android.content.Intent;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.kandian.biz.comment.WebCommentEditorHandler.EditorResultReceiver;
import com.tencent.mobileqq.kandian.biz.comment.base.ReadInJoyCommentEntrance;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyWebviewPlugin$MyEditorResultReceiver
  extends WebCommentEditorHandler.EditorResultReceiver
{
  private final WeakReference<ReadInJoyWebviewPlugin> a;
  
  ReadInJoyWebviewPlugin$MyEditorResultReceiver(ReadInJoyWebviewPlugin paramReadInJoyWebviewPlugin)
  {
    this.a = new WeakReference(paramReadInJoyWebviewPlugin);
  }
  
  private boolean a(String paramString, Intent paramIntent)
  {
    boolean bool = false;
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("errorCode");
      paramString = paramString.optString("comment");
      if (i == -4097) {
        try
        {
          ReadInJoyCommentEntrance.a(new ReadInJoyWebviewPlugin.MyEditorResultReceiver.2(this, paramIntent, paramString));
          return true;
        }
        catch (JSONException paramString)
        {
          bool = true;
        }
      } else {
        return false;
      }
    }
    catch (JSONException paramString)
    {
      QLog.w("ReadInJoyWebviewPlugin", 1, paramString.getMessage(), paramString);
    }
    return bool;
  }
  
  public void a(String paramString, Object paramObject)
  {
    ReadInJoyWebviewPlugin localReadInJoyWebviewPlugin = (ReadInJoyWebviewPlugin)this.a.get();
    if (localReadInJoyWebviewPlugin == null) {
      return;
    }
    localReadInJoyWebviewPlugin.callJs(paramString, new String[] { paramObject.toString() });
  }
  
  public boolean a(@NonNull Intent paramIntent, @NonNull JSONObject paramJSONObject, @Nullable String paramString, Parcelable paramParcelable)
  {
    ReadInJoyWebviewPlugin localReadInJoyWebviewPlugin = (ReadInJoyWebviewPlugin)this.a.get();
    if (localReadInJoyWebviewPlugin == null) {
      return true;
    }
    localReadInJoyWebviewPlugin.c.a(paramJSONObject, paramParcelable, new ReadInJoyWebviewPlugin.MyEditorResultReceiver.1(this, paramIntent, paramString));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.ReadInJoyWebviewPlugin.MyEditorResultReceiver
 * JD-Core Version:    0.7.0.1
 */