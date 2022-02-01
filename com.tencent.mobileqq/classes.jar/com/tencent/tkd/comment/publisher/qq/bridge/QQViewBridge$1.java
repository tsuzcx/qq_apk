package com.tencent.tkd.comment.publisher.qq.bridge;

import android.app.Activity;
import android.text.Editable;
import android.text.Editable.Factory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.tkd.comment.publisher.qq.util.QQViewCallback;
import org.json.JSONObject;

final class QQViewBridge$1
  implements QQViewBridge
{
  public void bindAt(Activity paramActivity, View paramView) {}
  
  public void bindCallback(QQViewCallback paramQQViewCallback) {}
  
  public void bindInput(EditText paramEditText) {}
  
  public void bindTopic(View paramView) {}
  
  public void deleteGif() {}
  
  public String getCommentString(Editable paramEditable)
  {
    return "";
  }
  
  public Editable.Factory getEditFactory()
  {
    return Editable.Factory.getInstance();
  }
  
  public View getEmotionPanel(Activity paramActivity)
  {
    return null;
  }
  
  public View getGifPanel(Activity paramActivity)
  {
    return null;
  }
  
  public int getTextLength(Editable paramEditable)
  {
    return 0;
  }
  
  public boolean hasGif()
  {
    return false;
  }
  
  public boolean isNightMode()
  {
    return false;
  }
  
  public void onDeleteLink() {}
  
  public void onDeliever(String paramString) {}
  
  public void openLink(ViewGroup paramViewGroup) {}
  
  public void packageDataInfo(JSONObject paramJSONObject, Editable paramEditable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.bridge.QQViewBridge.1
 * JD-Core Version:    0.7.0.1
 */