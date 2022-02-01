package com.tencent.mobileqq.qwallet.hb.emoji.impl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qwallet.temp.IQwTemp;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.emoji.ConvertParam;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class EmojiGifHelper
{
  private static volatile EmojiGifHelper jdField_a_of_type_ComTencentMobileqqQwalletHbEmojiImplEmojiGifHelper;
  private SparseArray<EmojiGifHelper.EmojiInfo> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  public static EmojiGifHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqQwalletHbEmojiImplEmojiGifHelper == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqQwalletHbEmojiImplEmojiGifHelper == null) {
          jdField_a_of_type_ComTencentMobileqqQwalletHbEmojiImplEmojiGifHelper = new EmojiGifHelper();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqQwalletHbEmojiImplEmojiGifHelper;
  }
  
  private void a(EmojiGifHelper.EmojiInfo paramEmojiInfo)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if (localQBaseActivity == null) {
      return;
    }
    if ((paramEmojiInfo != null) && (paramEmojiInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo != null))
    {
      if (TextUtils.isEmpty(paramEmojiInfo.jdField_a_of_type_JavaLangString)) {
        return;
      }
      Intent localIntent = new Intent(localQBaseActivity, ((IQwTemp)QRoute.api(IQwTemp.class)).getSendPhotoActivity());
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramEmojiInfo.jdField_a_of_type_JavaLangString);
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      localIntent.putExtra("PhotoConst.PHOTO_COUNT", localArrayList.size());
      localIntent.putExtra("uin", paramEmojiInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uintype", paramEmojiInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int);
      localIntent.putExtra("troop_uin", paramEmojiInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.b);
      localIntent.putExtra("key_confess_topicid", paramEmojiInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.e);
      localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      localIntent.putExtra("entrance", paramEmojiInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.c);
      if (localArrayList.size() == 1) {
        localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
      }
      localQBaseActivity.startActivity(localIntent);
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramEmojiInfo.jdField_a_of_type_Int);
    }
  }
  
  public void a(int paramInt)
  {
    EmojiGifHelper.EmojiInfo localEmojiInfo = (EmojiGifHelper.EmojiInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localEmojiInfo != null) {
      localEmojiInfo.a();
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public void a(BaseSessionInfo paramBaseSessionInfo, int paramInt)
  {
    EmojiGifHelper.EmojiInfo localEmojiInfo = new EmojiGifHelper.EmojiInfo();
    localEmojiInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseSessionInfo;
    localEmojiInfo.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localEmojiInfo);
  }
  
  public void a(ConvertParam arg1, EmojiGifHelper.CompositeTask paramCompositeTask)
  {
    if (??? != null)
    {
      if (paramCompositeTask == null) {
        return;
      }
      EmojiGifHelper.EmojiInfo localEmojiInfo = (EmojiGifHelper.EmojiInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(???.tag);
      if (localEmojiInfo != null) {
        synchronized (localEmojiInfo.jdField_a_of_type_ArrayOfByte)
        {
          if (localEmojiInfo.jdField_a_of_type_ComTencentMobileqqQwalletHbEmojiImplEmojiGifHelper$CompositeTask != null) {
            localEmojiInfo.jdField_a_of_type_ComTencentMobileqqQwalletHbEmojiImplEmojiGifHelper$CompositeTask.a();
          }
          localEmojiInfo.jdField_a_of_type_ComTencentMobileqqQwalletHbEmojiImplEmojiGifHelper$CompositeTask = paramCompositeTask;
          paramCompositeTask.a = localEmojiInfo;
          return;
        }
      }
    }
  }
  
  public void a(ConvertParam paramConvertParam, EmojiGifHelper.OnConvertListener paramOnConvertListener)
  {
    if (paramConvertParam == null)
    {
      if (paramOnConvertListener != null) {
        paramOnConvertListener.a(false, null);
      }
      return;
    }
    paramOnConvertListener = new EmojiGifHelper.CompositeTask(this, paramConvertParam, paramOnConvertListener);
    a(paramConvertParam, paramOnConvertListener);
    paramOnConvertListener.run();
  }
  
  public void b(int paramInt)
  {
    EmojiGifHelper.EmojiInfo localEmojiInfo = (EmojiGifHelper.EmojiInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localEmojiInfo != null) {
      localEmojiInfo.b();
    }
  }
  
  public void c(int paramInt)
  {
    EmojiGifHelper.EmojiInfo localEmojiInfo = (EmojiGifHelper.EmojiInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localEmojiInfo == null) {
      return;
    }
    byte[] arrayOfByte = localEmojiInfo.jdField_a_of_type_ArrayOfByte;
    if (localEmojiInfo != null) {}
    try
    {
      if (TextUtils.isEmpty(localEmojiInfo.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.i("EmojiGifHelper", 2, "trySendPicToAIO waiting to send");
        }
        localEmojiInfo.jdField_a_of_type_Boolean = true;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmojiGifHelper", 2, "trySendPicToAIO immediately send");
      }
      if ((localEmojiInfo != null) && (!TextUtils.isEmpty(localEmojiInfo.jdField_a_of_type_JavaLangString))) {
        a(localEmojiInfo);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.emoji.impl.EmojiGifHelper
 * JD-Core Version:    0.7.0.1
 */