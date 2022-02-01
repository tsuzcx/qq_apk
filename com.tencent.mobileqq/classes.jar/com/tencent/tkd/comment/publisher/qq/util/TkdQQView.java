package com.tencent.tkd.comment.publisher.qq.util;

import android.app.Activity;
import android.text.Editable;
import android.text.Editable.Factory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.tkd.comment.publisher.qq.QQPublishCommentManager;
import com.tencent.tkd.comment.publisher.qq.bridge.QQViewBridge;

public class TkdQQView
{
  public static void bindCallback(QQViewCallback paramQQViewCallback)
  {
    QQPublishCommentManager.getInstance().getViewBridge().bindCallback(paramQQViewCallback);
  }
  
  public static void bindInput(EditText paramEditText)
  {
    QQPublishCommentManager.getInstance().getViewBridge().bindInput(paramEditText);
  }
  
  public static void deleteGif()
  {
    QQPublishCommentManager.getInstance().getViewBridge().deleteGif();
  }
  
  public static Editable.Factory getEditFactory()
  {
    return QQPublishCommentManager.getInstance().getViewBridge().getEditFactory();
  }
  
  public static View getEmotionPanel(Activity paramActivity)
  {
    return QQPublishCommentManager.getInstance().getViewBridge().getEmotionPanel(paramActivity);
  }
  
  public static String getEmotionText(String paramString)
  {
    return QQPublishCommentManager.getInstance().getViewBridge().getEmotionText(paramString);
  }
  
  public static View getGifPanel(Activity paramActivity)
  {
    return QQPublishCommentManager.getInstance().getViewBridge().getGifPanel(paramActivity);
  }
  
  public static int getTextLength(Editable paramEditable)
  {
    return QQPublishCommentManager.getInstance().getViewBridge().getTextLength(paramEditable);
  }
  
  public static boolean hasGif()
  {
    return QQPublishCommentManager.getInstance().getViewBridge().hasGif();
  }
  
  public static boolean isNightMode()
  {
    return QQPublishCommentManager.getInstance().getViewBridge().isNightMode();
  }
  
  public static void onDeleteLink()
  {
    QQPublishCommentManager.getInstance().getViewBridge().onDeleteLink();
  }
  
  public static void onDeliever(String paramString)
  {
    QQPublishCommentManager.getInstance().getViewBridge().onDeliever(paramString);
  }
  
  public static void onDelieverBiu(String paramString)
  {
    QQPublishCommentManager.getInstance().getViewBridge().onDelieverBiu(paramString);
  }
  
  public static void openLink(ViewGroup paramViewGroup)
  {
    QQPublishCommentManager.getInstance().getViewBridge().openLink(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.util.TkdQQView
 * JD-Core Version:    0.7.0.1
 */