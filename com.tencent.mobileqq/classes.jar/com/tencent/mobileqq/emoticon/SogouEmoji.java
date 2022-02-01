package com.tencent.mobileqq.emoticon;

import android.app.Activity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class SogouEmoji
  implements ISogouEmoji
{
  public static String a = "taskId";
  public static String b = "exprId";
  int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  private BaseAIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext;
  EmoticonHandler jdField_a_of_type_ComTencentMobileqqAppEmoticonHandler;
  EmoticonObserver jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver = new SogouEmoji.SogouEmoticonObserver(this);
  IEmoticonManagerService jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonManagerService;
  EmotionJsonDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmotionJsonDownloadListener = new SogouEmoji.1(this);
  SogouEmojiTaskController jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController;
  IEmojiManagerService jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService;
  int b;
  
  public SogouEmoji(BaseAIOContext paramBaseAIOContext, Activity paramActivity, BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func SogouEmoji constructor begins");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext = paramBaseAIOContext;
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonManagerService = ((IEmoticonManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IEmoticonManagerService.class));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService = ((IEmojiManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IEmojiManagerService.class));
    this.jdField_a_of_type_ComTencentMobileqqAppEmoticonHandler = ((EmoticonHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getBusinessHandler(EmoticonHandler.a));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController = new SogouEmojiTaskController(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func SogouEmoji constructor ends");
    }
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
  }
  
  private boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext != null) && (this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface != null)) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("func");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ends, maybe chatActivity is finished.");
      QLog.d("SogouEmoji", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  ArrayList<Emoticon> a(ArrayList<Emoticon> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func getInvalidKeyEmoticon begins");
    }
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return localArrayList;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Emoticon localEmoticon = (Emoticon)paramArrayList.next();
        if (!localEmoticon.hasEncryptKey()) {
          localArrayList.add(localEmoticon);
        }
      }
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("func getInvalidKeyEmoticon ends, size:");
        paramArrayList.append(localArrayList.size());
        QLog.d("SogouEmoji", 2, paramArrayList.toString());
      }
    }
    return localArrayList;
  }
  
  void a(Emoticon paramEmoticon)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func sendEmoji begins, mCurTaskId:");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(",emoticon:");
      ((StringBuilder)localObject).append(paramEmoticon);
      QLog.d("SogouEmoji", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController.c();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController.a(this.b);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController.b();
    if (!a("sendEmoji")) {
      return;
    }
    Object localObject = new PicEmoticonInfo(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin());
    ((PicEmoticonInfo)localObject).type = 6;
    ((PicEmoticonInfo)localObject).emoticon = paramEmoticon;
    this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonManagerService.asyncFindEmoticonPackage(paramEmoticon.epId, new SogouEmoji.5(this, (PicEmoticonInfo)localObject));
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = new SogouEmoji.3(this, paramString1, paramString2, paramBoolean);
    ThreadManager.getFileThreadHandler().post(paramString1);
  }
  
  void a(String paramString, ArrayList<Emoticon> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func getPackEmojiKey begins, packId:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("SogouEmoji", 2, ((StringBuilder)localObject).toString());
    }
    if (!a("getPackEmojiKey")) {
      return;
    }
    Object localObject = Integer.toString(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int += 1;
    if (EmosmUtils.a(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqAppEmoticonHandler.a(Integer.parseInt(paramString), paramArrayList, (String)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func getPackEmojiKey ends");
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func SogouEmoji destructor begins");
    }
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
    if (localObject != null) {
      ((BaseQQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController;
    if (localObject != null) {
      ((SogouEmojiTaskController)localObject).a();
    }
    EmojiListenerManager.a().removeEmotionJsonDownloadListener(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmotionJsonDownloadListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext = null;
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func SogouEmoji destructor ends");
    }
  }
  
  public void pullMultipleEmojiKey(List<String> paramList)
  {
    paramList = new SogouEmoji.4(this, paramList);
    ThreadManager.getFileThreadHandler().post(paramList);
  }
  
  public void trySend(int paramInt, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func trySend begins, packId:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",exprId:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("SogouEmoji", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext != null)
    {
      localObject = this.jdField_a_of_type_AndroidAppActivity;
      if ((localObject != null) && (!NetworkUtil.isNetSupport(((Activity)localObject).getApplicationContext())))
      {
        QQToast.a(MobileQQ.getContext(), 2131694422, 0).a();
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonManagerService.asyncFindEmoticon(Integer.toString(paramInt), paramString, new SogouEmoji.2(this, paramInt, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.SogouEmoji
 * JD-Core Version:    0.7.0.1
 */