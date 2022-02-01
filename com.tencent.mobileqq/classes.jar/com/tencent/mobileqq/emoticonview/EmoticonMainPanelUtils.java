package com.tencent.mobileqq.emoticonview;

import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class EmoticonMainPanelUtils
{
  public static EmoticonMainPanel initEmojiPanel(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, EditText paramEditText, EmoticonCallback paramEmoticonCallback)
  {
    paramEditText = (EmoticonMainPanel)View.inflate(paramBaseActivity.getBaseContext(), 2131559158, null);
    paramEditText.setCallBack(paramEmoticonCallback);
    paramEditText.disableGuide = true;
    paramEditText.disableMoreEmotionButton = true;
    paramEditText.hasBigEmotion = false;
    paramEditText.onlySysAndEmoji = true;
    paramEditText.disableAutoDownload = true;
    paramEditText.init(paramQQAppInterface, 100002, paramBaseActivity, paramBaseActivity.getTitleBarHeight(), null, null, false, new EmoticonMainPanelUtils.1());
    paramEditText.mEmoticonTabs.setOverScrollMode(2);
    return paramEditText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanelUtils
 * JD-Core Version:    0.7.0.1
 */