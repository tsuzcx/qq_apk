package com.tencent.mobileqq.emoticonview;

import android.widget.EditText;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder;

public class EmoticonMainPanelUtils
{
  public static IEmoticonMainPanel initEmojiPanel(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, EditText paramEditText, EmoticonCallback paramEmoticonCallback)
  {
    paramQQAppInterface = ((IEmoticonMainPanelService)paramQQAppInterface.getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(paramBaseActivity, 100002).setCallBack(paramEmoticonCallback).setDisableGuide(true).setDisableMoreEmotionButton(true).setHasBigEmotion(false).setOnlySysAndEmoji(true).setDisableAutoDownload(true).setEmoticonListProvider(new EmoticonMainPanelUtils.1()).create();
    paramQQAppInterface.setTabListOverScrollMode(2);
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanelUtils
 * JD-Core Version:    0.7.0.1
 */