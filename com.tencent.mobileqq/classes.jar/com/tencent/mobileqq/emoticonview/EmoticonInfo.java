package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.text.TextUtils;

public class EmoticonInfo
  extends EmotionPanelData
{
  public static final String ADD_ACTION = "add";
  public static final int ADD_LOCAL = 1;
  public static final String CAMERA_EDIT_ACTION = "cameraEdit";
  public static final String CAMERA_JUMP_ACTION = "cameraJump";
  public static final int DEFAULT = 0;
  public static final String DELETE_ACTION = "delete";
  public static final int FAVORITE = 2;
  public static final String FAV_EDIT_ACTION = "favEdit";
  public static final String FUNNY_PIC_ACTION = "funny_pic";
  public static final String PUSH_ACTION = "push";
  public static final int RENCENT = 1;
  public static final String SETTING_ACTION = "setting";
  public static final String SHOW_FAV_MENU_ACTION = "show_fav_menu";
  public String action;
  EmoticonCallback callback;
  public int drawableId;
  public int emoId;
  public boolean isChecked;
  public String longClickAction;
  public int operateType = 0;
  public int src_type;
  public EmojiStickerManager.StickerInfo stickerInfo;
  public int type = -1;
  
  public Drawable getBigDrawable(Context paramContext, float paramFloat)
  {
    return getDrawable(paramContext, paramFloat);
  }
  
  public Drawable getDrawable(Context paramContext, float paramFloat)
  {
    return TextUtils.getResourceDrawableThroughImageCache(paramContext.getResources(), this.drawableId);
  }
  
  public Drawable getZoomDrawable(Context paramContext, float paramFloat, int paramInt1, int paramInt2)
  {
    return TextUtils.getResourceDrawableThroughImageCache(paramContext.getResources(), this.drawableId);
  }
  
  public void send(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo) {}
  
  public void setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    this.callback = paramEmoticonCallback;
  }
  
  @NonNull
  public String toString()
  {
    return "EmoticonInfo[type: " + this.type + "  action: " + this.action + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonInfo
 * JD-Core Version:    0.7.0.1
 */