package com.tencent.tkd.comment.publisher.qq.bridge;

import android.app.Activity;
import android.text.Editable;
import android.text.Editable.Factory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.tkd.comment.publisher.qq.util.QQViewCallback;
import org.json.JSONObject;

public abstract interface QQViewBridge
{
  public static final QQViewBridge EMPTY = new QQViewBridge.1();
  
  public abstract void bindAt(Activity paramActivity, View paramView);
  
  public abstract void bindCallback(QQViewCallback paramQQViewCallback);
  
  public abstract void bindInput(EditText paramEditText);
  
  public abstract void bindTopic(View paramView);
  
  public abstract void deleteGif();
  
  public abstract String getCommentString(Editable paramEditable);
  
  public abstract Editable.Factory getEditFactory();
  
  public abstract View getEmotionPanel(Activity paramActivity);
  
  public abstract View getGifPanel(Activity paramActivity);
  
  public abstract int getTextLength(Editable paramEditable);
  
  public abstract boolean hasGif();
  
  public abstract boolean isNightMode();
  
  public abstract void onDeleteLink();
  
  public abstract void onDeliever(String paramString);
  
  public abstract void openLink(ViewGroup paramViewGroup);
  
  public abstract void packageDataInfo(JSONObject paramJSONObject, Editable paramEditable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.bridge.QQViewBridge
 * JD-Core Version:    0.7.0.1
 */