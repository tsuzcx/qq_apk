package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.text.TextUtils;

public class EmoticonInfo
  extends EmotionPanelData
{
  public EmojiStickerManager.StickerInfo a;
  public String a;
  public String b;
  public int c = -1;
  public int d;
  public int e;
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    return TextUtils.a(paramContext.getResources(), this.e);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo) {}
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    return a(paramContext, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonInfo
 * JD-Core Version:    0.7.0.1
 */