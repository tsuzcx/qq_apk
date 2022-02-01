package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class EmojiEmoticonInfo
  extends EmoticonInfo
{
  public static int EMOJI_COUNT = 165;
  public int code;
  
  public static List<EmoticonInfo> getEmoticonList()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < EMOJI_COUNT)
    {
      EmojiEmoticonInfo localEmojiEmoticonInfo = new EmojiEmoticonInfo();
      localEmojiEmoticonInfo.type = 2;
      localEmojiEmoticonInfo.code = i;
      localArrayList.add(localEmojiEmoticonInfo);
      i += 1;
    }
    return localArrayList;
  }
  
  public Drawable getDrawable(Context paramContext, float paramFloat)
  {
    return QQEmojiUtil.getEmojiDrawable(this.code);
  }
  
  public void send(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    int i = paramEditText.getSelectionStart();
    int j = paramEditText.getSelectionEnd();
    paramEditText.getEditableText().replace(i, j, TextUtils.getEmojiString(this.code));
    paramEditText.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmojiEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */