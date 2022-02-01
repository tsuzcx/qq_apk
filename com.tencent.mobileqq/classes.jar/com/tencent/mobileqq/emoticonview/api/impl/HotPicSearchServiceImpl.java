package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelController;
import com.tencent.mobileqq.emoticonview.api.IHotPicSearchService;
import com.tencent.mobileqq.hiboom.RichTextPanel;
import com.tencent.mobileqq.hotpic.HotPicDownLoader;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class HotPicSearchServiceImpl
  implements IHotPicSearchService
{
  private static final String TAG = "HotPicSearchServiceImpl";
  
  public int getFromType(IEmoticonPanelController paramIEmoticonPanelController)
  {
    if ((paramIEmoticonPanelController instanceof EmoticonPanelController)) {
      return ((EmoticonPanelMallHelper)((EmoticonPanelController)paramIEmoticonPanelController).getHelper(5)).getFromType();
    }
    return 0;
  }
  
  public int getReportFromType()
  {
    return RichTextPanel.jdField_a_of_type_Int;
  }
  
  public URL getURL(String paramString)
  {
    return HotPicDownLoader.a(paramString);
  }
  
  public boolean isEmoPanelSearch(IEmoticonPanelController paramIEmoticonPanelController)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramIEmoticonPanelController instanceof EmoticonPanelController))
    {
      bool1 = bool2;
      if (((EmoticonPanelController)paramIEmoticonPanelController).findIndexByPanelType(12) == EmoticonPanelController.sLastSelectedSecondTabIndex) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isRichTextLastTab(Context paramContext, String paramString)
  {
    return SharedPreUtils.aL(paramContext, paramString) == 5;
  }
  
  protected void reportEvent(QQAppInterface paramQQAppInterface, EmotionSearchItem paramEmotionSearchItem, String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      if (!StringUtil.a(paramString)) {
        ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800AE2E", "0X800AE2E", 0, 0, paramInt2 + "", "", paramEmotionSearchItem.getEmoMd5(), "");
      }
      if (StringUtil.a(paramString))
      {
        paramInt1 = 1;
        ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800AE20", "0X800AE20", paramInt1, 0, paramInt2 + "", "", paramEmotionSearchItem.getEmoMd5(), "");
      }
    }
    while (paramInt1 != 2) {
      for (;;)
      {
        return;
        paramInt1 = 2;
      }
    }
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800AE36", "0X800AE36", 0, 0, paramInt2 + "", "", paramEmotionSearchItem.getEmoMd5(), "");
  }
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable1, Parcelable paramParcelable2, String paramString, int paramInt1, int paramInt2)
  {
    if (!(paramAppRuntime instanceof QQAppInterface)) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)paramAppRuntime;
      paramParcelable1 = (SessionInfo)paramParcelable1;
      if (((paramContext instanceof BaseActivity)) && (HotChatUtil.a(paramParcelable1.jdField_a_of_type_Int, paramParcelable1.jdField_a_of_type_JavaLangString)))
      {
        paramAppRuntime = (BaseActivity)paramContext;
        QQToast.a(localQQAppInterface.getApp(), HardCodeUtil.a(2131701383), 0).b(paramAppRuntime.getTitleBarHeight());
        return;
      }
    } while (!(paramContext instanceof BaseActivity));
    paramParcelable2 = (EmotionSearchItem)paramParcelable2;
    int j = 0;
    paramAppRuntime = HotPicDownLoader.a(paramParcelable2.originalUrl);
    int i;
    if ((paramAppRuntime != null) && (FileUtils.b(paramAppRuntime.getAbsolutePath())))
    {
      paramEditText = paramAppRuntime.getAbsolutePath();
      i = 1;
      paramAppRuntime = paramEditText;
      if (!QLog.isColorLevel()) {
        break label274;
      }
      QLog.d("HotPicSearchServiceImpl", 2, "senHotPic, urlHotPicOringinal = " + paramParcelable2.originalUrl + ", paths = " + paramEditText);
      paramAppRuntime = paramEditText;
      i = 1;
    }
    for (;;)
    {
      if ((paramAppRuntime == null) && (paramParcelable1.jdField_a_of_type_Int != 1008))
      {
        QQToast.a(paramContext, 2131698884, 0).a();
        return;
        if (HotPicPageView.a(paramParcelable2) == 0)
        {
          paramEditText = HotPicDownLoader.a(paramParcelable2.url).getAbsolutePath();
          paramAppRuntime = paramEditText;
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("HotPicSearchServiceImpl", 2, "senHotPic, urlHotPic = " + paramParcelable2.url + ", paths = " + paramEditText);
            i = j;
            paramAppRuntime = paramEditText;
          }
        }
      }
      else
      {
        label274:
        reportEvent(localQQAppInterface, paramParcelable2, paramString, paramInt1, paramInt2);
        paramEditText = new Intent();
        paramString = new ArrayList();
        paramString.add(paramAppRuntime);
        paramEditText.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramString);
        paramEditText.putExtra("uin", paramParcelable1.jdField_a_of_type_JavaLangString);
        paramEditText.putExtra("uintype", paramParcelable1.jdField_a_of_type_Int);
        paramEditText.putExtra("troop_uin", paramParcelable1.b);
        paramEditText.putExtra("key_confess_topicid", paramParcelable1.e);
        paramEditText.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        paramEditText.putExtra("send_in_background", true);
        paramEditText.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
        paramEditText.putExtra("PicContants.NEED_COMPRESS", false);
        paramEditText.putExtra("quick_send_is_emo_search", true);
        if (i == 0)
        {
          paramEditText.putExtra("quick_send_original_md5", paramParcelable2.originalMD5);
          paramEditText.putExtra("quick_send_original_size", paramParcelable2.oringinalSize);
          paramEditText.putExtra("quick_send_thumb_md5", paramParcelable2.md5);
          paramEditText.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1042);
        }
        for (;;)
        {
          ThreadManager.post(new SendPhotoTask((BaseActivity)paramContext, paramEditText, null), 8, null, false);
          return;
          paramEditText.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1031);
        }
      }
      paramAppRuntime = null;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.HotPicSearchServiceImpl
 * JD-Core Version:    0.7.0.1
 */