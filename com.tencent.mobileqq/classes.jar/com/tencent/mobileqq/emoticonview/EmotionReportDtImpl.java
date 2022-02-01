package com.tencent.mobileqq.emoticonview;

import android.view.View;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTReport;
import java.util.HashMap;
import java.util.Map;

public class EmotionReportDtImpl
  implements IDTReport
{
  public static final String AIO_YELLOW_STICKERS_ID = "aio_yellow_stickers_id";
  public static final String EM_AIO_ALBUM_STICKERS = "em_aio_album_stickers";
  public static final String EM_AIO_ALBUM_STICKERS_TAB = "em_aio_album_stickers_tab";
  public static final String EM_AIO_FAVORITES_STICKERS = "em_aio_favorites_stickers";
  public static final String EM_AIO_FAVORITES_STICKERS_TAB = "em_aio_favorites_stickers_tab";
  public static final String EM_AIO_SETTING_BELOW_TEXTBOX = "em_aio_setting_below_textbox";
  public static final String EM_AIO_STICKERS_MALL_BELOW_TEXTBOX = "em_aio_stickers_mall_below_textbox";
  public static final String EM_AIO_STICKERS_PANEL = "em_aio_stickers_panel";
  public static final String EM_AIO_TEXTBOX_STICKERS_RECOMMEND_BAR = "em_aio_textbox_stickers_recommend_bar";
  public static final String EM_AIO_YELLOW_STICKERS = "em_aio_yellow_stickers";
  public static final String EM_AIO_YELLOW_STICKERS_TAB = "em_aio_yellow_stickers_tab";
  public static final String ID_STICKERS_A_SET = "id_stickers_a_set";
  public static final String IS_RED_TIPS_BEFORE = "is_red_tips_before";
  public static final String KEY_TYPE_AIO_STICKERS_TAB_ENTRY = "type_aio_stickers_tab_entry";
  public static final String LOG_TAG = "EmotionReportDtImpl";
  public static final String ORDER_IN_ALBUM_STICKERS = "order_in_album_stickers";
  public static final String ORDER_IN_FAVORITES_STICKERS = "order_in_favorites_stickers";
  public static final String ORDER_IN_YELLOW_STICKERS = "order_in_yellow_stickers";
  public static final String ORDER_TAB_IN_STICKERS_PANEL = "order_tab_in_stickers_panel";
  public static final String TEXT_IN_TEXTBOX = "text_in_textbox";
  public static final String TYPE_YELLOW_STICKERS = "type_yellow_stickers";
  
  public static void bindSystemAndEmojiFaceView(View paramView, SystemAndEmojiEmoticonInfo paramSystemAndEmojiEmoticonInfo, int paramInt1, int paramInt2)
  {
    if ((paramView != null) && (paramSystemAndEmojiEmoticonInfo != null) && (paramInt1 >= 0))
    {
      if (paramSystemAndEmojiEmoticonInfo.emotionType == 3)
      {
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("bindSystemAndEmojiFaceView, ignore type title:");
          paramView.append(paramSystemAndEmojiEmoticonInfo.emotionType);
          QLog.i("EmotionReportDtImpl", 2, paramView.toString());
        }
        return;
      }
      Object localObject = getSystemAndEmojiFaceIndexResult(paramSystemAndEmojiEmoticonInfo, paramInt2);
      paramInt2 = localObject[0];
      int i = localObject[1];
      VideoReport.setElementId(paramView, "em_aio_yellow_stickers");
      VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
      VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_NONE);
      localObject = new HashMap();
      ((Map)localObject).put("order_in_yellow_stickers", String.valueOf(paramInt1 - i));
      ((Map)localObject).put("type_yellow_stickers", String.valueOf(paramInt2));
      ((Map)localObject).put("aio_yellow_stickers_id", String.valueOf(getSystemAndEmojiFaceSvrId(paramSystemAndEmojiEmoticonInfo)));
      VideoReport.setElementParams(paramView, (Map)localObject);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("bindSystemAndEmojiFaceView params:");
        paramView.append(localObject.toString());
        paramView.append(", orderIdx:");
        paramView.append(i);
        QLog.i("EmotionReportDtImpl", 2, paramView.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("bindSystemAndEmojiFaceView, input params error, emotionOrder:");
      paramView.append(paramInt1);
      QLog.i("EmotionReportDtImpl", 2, paramView.toString());
    }
  }
  
  public static int[] getSystemAndEmojiFaceIndexResult(SystemAndEmojiEmoticonInfo paramSystemAndEmojiEmoticonInfo, int paramInt)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    if (paramSystemAndEmojiEmoticonInfo == null) {
      return arrayOfInt;
    }
    if (paramSystemAndEmojiEmoticonInfo.isCommonUsed)
    {
      arrayOfInt[0] = 0;
      arrayOfInt[1] = (paramInt * 1);
      return arrayOfInt;
    }
    if (paramSystemAndEmojiEmoticonInfo.emotionType == 1)
    {
      arrayOfInt[0] = 1;
      arrayOfInt[1] = (paramInt * 2);
      return arrayOfInt;
    }
    if (paramSystemAndEmojiEmoticonInfo.emotionType == 2)
    {
      arrayOfInt[0] = 2;
      arrayOfInt[1] = (paramInt * 3);
    }
    return arrayOfInt;
  }
  
  public static int getSystemAndEmojiFaceSvrId(SystemAndEmojiEmoticonInfo paramSystemAndEmojiEmoticonInfo)
  {
    if (paramSystemAndEmojiEmoticonInfo == null) {
      return -1;
    }
    if (paramSystemAndEmojiEmoticonInfo.emotionType == 2) {
      return QQSysAndEmojiResMgr.getInstance().getResImpl(2).getServerId(paramSystemAndEmojiEmoticonInfo.code);
    }
    if (paramSystemAndEmojiEmoticonInfo.emotionType == 1) {
      return QQSysFaceUtil.convertToServer(paramSystemAndEmojiEmoticonInfo.code);
    }
    return -1;
  }
  
  public boolean dtEvent(Object paramObject, String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean dtEvent(Object paramObject, String paramString1, Map<String, String> paramMap, boolean paramBoolean, String paramString2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionReportDtImpl
 * JD-Core Version:    0.7.0.1
 */