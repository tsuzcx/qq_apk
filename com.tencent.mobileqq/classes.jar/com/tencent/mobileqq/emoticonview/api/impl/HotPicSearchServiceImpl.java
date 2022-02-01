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
import com.tencent.mobileqq.core.util.EmotionSharedPreUtils;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticonview.api.IHotPicSearchService;
import com.tencent.mobileqq.hiboom.RichTextPanel;
import com.tencent.mobileqq.hotpic.HotPicDownLoader;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
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
  
  public int getReportFromType()
  {
    return RichTextPanel.a;
  }
  
  public URL getURL(String paramString)
  {
    return HotPicDownLoader.b(paramString);
  }
  
  public boolean isRichTextLastTab(Context paramContext, String paramString)
  {
    return EmotionSharedPreUtils.b(paramContext, paramString) == 5;
  }
  
  protected void reportEvent(QQAppInterface paramQQAppInterface, EmotionSearchItem paramEmotionSearchItem, String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      if (!StringUtil.isEmpty(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("");
        ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800AE2E", "0X800AE2E", 0, 0, localStringBuilder.toString(), "", paramEmotionSearchItem.getEmoMd5(), "");
      }
      if (StringUtil.isEmpty(paramString)) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
      paramString = new StringBuilder();
      paramString.append(paramInt2);
      paramString.append("");
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800AE20", "0X800AE20", paramInt1, 0, paramString.toString(), "", paramEmotionSearchItem.getEmoMd5(), "");
      return;
    }
    if (paramInt1 == 2)
    {
      paramString = new StringBuilder();
      paramString.append(paramInt2);
      paramString.append("");
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800AE36", "0X800AE36", 0, 0, paramString.toString(), "", paramEmotionSearchItem.getEmoMd5(), "");
    }
  }
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable1, Parcelable paramParcelable2, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      if (paramParcelable1 == null) {
        return;
      }
      paramEditText = (QQAppInterface)paramAppRuntime;
      paramParcelable1 = (SessionInfo)paramParcelable1;
      boolean bool = paramContext instanceof BaseActivity;
      if ((bool) && (((IHotChatUtil)QRoute.api(IHotChatUtil.class)).isHotChatMsg(paramParcelable1.a, paramParcelable1.b)))
      {
        paramAppRuntime = (BaseActivity)paramContext;
        QQToast.makeText(paramEditText.getApp(), HardCodeUtil.a(2131899546), 0).show(paramAppRuntime.getTitleBarHeight());
        return;
      }
      if (!bool) {
        return;
      }
      paramParcelable2 = (EmotionSearchItem)paramParcelable2;
      paramAppRuntime = HotPicDownLoader.a(paramParcelable2.originalUrl);
      StringBuilder localStringBuilder;
      int i;
      if ((paramAppRuntime != null) && (FileUtils.fileExistsAndNotEmpty(paramAppRuntime.getAbsolutePath())))
      {
        paramAppRuntime = paramAppRuntime.getAbsolutePath();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("senHotPic, urlHotPicOringinal = ");
          localStringBuilder.append(paramParcelable2.originalUrl);
          localStringBuilder.append(", paths = ");
          localStringBuilder.append(paramAppRuntime);
          QLog.d("HotPicSearchServiceImpl", 2, localStringBuilder.toString());
        }
        i = 1;
      }
      else
      {
        if (HotPicPageView.b(paramParcelable2) == 0)
        {
          paramAppRuntime = HotPicDownLoader.a(paramParcelable2.url).getAbsolutePath();
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("senHotPic, urlHotPic = ");
            localStringBuilder.append(paramParcelable2.url);
            localStringBuilder.append(", paths = ");
            localStringBuilder.append(paramAppRuntime);
            QLog.d("HotPicSearchServiceImpl", 2, localStringBuilder.toString());
          }
        }
        else
        {
          paramAppRuntime = null;
        }
        i = 0;
      }
      if ((paramAppRuntime == null) && (paramParcelable1.a != 1008))
      {
        QQToast.makeText(paramContext, 2131896955, 0).show();
        return;
      }
      reportEvent(paramEditText, paramParcelable2, paramString, paramInt1, paramInt2);
      paramEditText = new Intent();
      paramString = new ArrayList();
      paramString.add(paramAppRuntime);
      paramEditText.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramString);
      paramEditText.putExtra("uin", paramParcelable1.b);
      paramEditText.putExtra("uintype", paramParcelable1.a);
      paramEditText.putExtra("troop_uin", paramParcelable1.c);
      paramEditText.putExtra("key_confess_topicid", paramParcelable1.v);
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
      else
      {
        paramEditText.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1031);
      }
      ThreadManager.post(new SendPhotoTask((BaseActivity)paramContext, paramEditText, null), 8, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.HotPicSearchServiceImpl
 * JD-Core Version:    0.7.0.1
 */