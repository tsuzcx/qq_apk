package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class AIOEmotionFragment$EmoticonDetailJsonDownloader
  extends EmotionJsonDownloadListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IPicEmoticonInfo jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  
  public AIOEmotionFragment$EmoticonDetailJsonDownloader(AIOEmotionFragment paramAIOEmotionFragment) {}
  
  public void a(int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, IPicEmoticonInfo paramIPicEmoticonInfo, SessionInfo paramSessionInfo, QQProgressDialog paramQQProgressDialog)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo = paramIPicEmoticonInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = paramQQProgressDialog;
  }
  
  public void onJsonComplete(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onJsonComplete:");
      paramBundle.append(paramEmoticonPackage.epId);
      paramBundle.append(" ,currEpid:");
      paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId);
      QLog.d("AIOEmotionFragment", 2, paramBundle.toString());
    }
    int i = this.jdField_a_of_type_Int;
    if (i == 32)
    {
      boolean bool;
      if ((paramInt == 0) && (Long.parseLong(paramEmoticonPackage.epId) != Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId))) {
        bool = true;
      } else {
        bool = false;
      }
      AIOEmotionFragment.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment, bool);
      return;
    }
    if (paramInt == 0)
    {
      if (Long.parseLong(paramEmoticonPackage.epId) != Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("emosm_json_last_download_timestamp", (int)(System.currentTimeMillis() / 1000L)).commit();
      MarketFaceItemBuilder.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog, true);
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.a.obtainMessage(1000);
      paramBundle.obj = paramEmoticonPackage.name;
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.a.sendMessage(paramBundle);
      return;
    }
    MarketFaceItemBuilder.a(1000 + i, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.EmoticonDetailJsonDownloader
 * JD-Core Version:    0.7.0.1
 */