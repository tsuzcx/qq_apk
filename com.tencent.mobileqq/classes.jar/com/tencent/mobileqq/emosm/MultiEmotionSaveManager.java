package com.tencent.mobileqq.emosm;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.CustomEmoticonInfoBase;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.multimsg.save.FileSaveErrorInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class MultiEmotionSaveManager
  implements Handler.Callback, Manager
{
  private volatile int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  private MultiEmotionSaveManager.ISaveCallBack jdField_a_of_type_ComTencentMobileqqEmosmMultiEmotionSaveManager$ISaveCallBack;
  private volatile ConcurrentLinkedQueue<EmotionSaveResult> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private volatile CopyOnWriteArrayList<EmotionSaveResult> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private volatile int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  
  public MultiEmotionSaveManager(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void a(String paramString1, String paramString2, EmotionSaveResult paramEmotionSaveResult)
  {
    this.jdField_a_of_type_Int += 1;
    boolean bool = TextUtils.isEmpty(paramString1);
    int j = 0;
    if (bool) {
      i = 10001;
    } else if (TextUtils.isEmpty(paramString2)) {
      i = 10002;
    } else if (!FileUtils.fileExists(paramString1)) {
      i = 10003;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("realSaveEmo failed! errorCode = ");
        paramString1.append(i);
        QLog.d("MultiEmotionSaveManager", 2, paramString1.toString());
      }
      if (paramEmotionSaveResult != null)
      {
        paramEmotionSaveResult.jdField_a_of_type_Int = -1;
        paramEmotionSaveResult.jdField_b_of_type_Int = i;
        paramEmotionSaveResult.c = FileSaveErrorInfo.a(i);
        paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
        paramString1.obj = paramEmotionSaveResult;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
      }
      return;
    }
    Object localObject1 = paramString2;
    int i = j;
    Object localObject3;
    do
    {
      if (i > 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(i);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      Object localObject2 = localObject1;
      if (!((String)localObject1).contains("."))
      {
        localObject2 = FileUtils.estimateFileType(paramString1);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(".");
        ((StringBuilder)localObject3).append((String)localObject2);
        localObject2 = ((StringBuilder)localObject3).toString();
      }
      localObject3 = new File(EmotionPathConstants.jdField_a_of_type_JavaLangString, (String)localObject2);
      i += 1;
      localObject1 = localObject2;
    } while (((File)localObject3).exists());
    paramString2 = new File(paramString1);
    ThreadManager.getFileThreadHandler().post(new MultiEmotionSaveManager.1(this, (File)localObject3, paramString2, paramString1, paramEmotionSaveResult));
  }
  
  private void b(EmotionSaveResult paramEmotionSaveResult)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(System.nanoTime());
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    a(paramEmotionSaveResult.jdField_b_of_type_JavaLangString, (String)localObject, paramEmotionSaveResult);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiEmotionSaveManager", 2, "clearCatch");
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  private void d()
  {
    MultiEmotionSaveManager.ISaveCallBack localISaveCallBack = this.jdField_a_of_type_ComTencentMobileqqEmosmMultiEmotionSaveManager$ISaveCallBack;
    if (localISaveCallBack != null) {
      localISaveCallBack.b();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Long != 0L)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmMultiEmotionSaveManager$ISaveCallBack == null) {
        return;
      }
      double d1 = this.jdField_b_of_type_Int;
      Double.isNaN(d1);
      double d2 = this.jdField_a_of_type_Long;
      Double.isNaN(d2);
      int i = (int)(d1 * 100.0D / d2);
      if (this.jdField_b_of_type_Int == this.jdField_a_of_type_Long) {
        i = 100;
      }
      MultiEmotionSaveManager.ISaveCallBack localISaveCallBack = this.jdField_a_of_type_ComTencentMobileqqEmosmMultiEmotionSaveManager$ISaveCallBack;
      if (localISaveCallBack != null) {
        localISaveCallBack.a(i);
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiEmotionSaveManager", 2, "cancelMultiEmoSave");
    }
    c();
    MultiEmotionSaveManager.ISaveCallBack localISaveCallBack = this.jdField_a_of_type_ComTencentMobileqqEmosmMultiEmotionSaveManager$ISaveCallBack;
    if (localISaveCallBack != null) {
      localISaveCallBack.a();
    }
  }
  
  public void a(EmotionSaveResult paramEmotionSaveResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiEmotionSaveManager", 2, "saveComplete");
    }
    MultiEmotionSaveManager.ISaveCallBack localISaveCallBack = this.jdField_a_of_type_ComTencentMobileqqEmosmMultiEmotionSaveManager$ISaveCallBack;
    if (localISaveCallBack != null) {
      localISaveCallBack.a(paramEmotionSaveResult);
    }
    c();
  }
  
  public void a(MultiEmotionSaveManager.ISaveCallBack paramISaveCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmMultiEmotionSaveManager$ISaveCallBack = paramISaveCallBack;
  }
  
  public void a(List<EmoticonInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("saveMultiRichMedialFile emoSaveReqList count is :");
        ((StringBuilder)localObject1).append(paramList.size());
        QLog.d("MultiEmotionSaveManager", 2, ((StringBuilder)localObject1).toString());
      }
      c();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (EmoticonInfo)paramList.next();
        Object localObject2;
        if ((localObject1 instanceof CustomEmoticonInfoBase))
        {
          localObject1 = (CustomEmoticonInfoBase)localObject1;
          localObject2 = new EmotionSaveResult();
          ((EmotionSaveResult)localObject2).jdField_a_of_type_JavaLangString = ((CustomEmoticonInfoBase)localObject1).resID;
          ((EmotionSaveResult)localObject2).jdField_b_of_type_JavaLangString = ((CustomEmoticonInfoBase)localObject1).path;
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject2);
        }
        else if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("temp is not CustomEmoticonInfoBase class is ");
          ((StringBuilder)localObject2).append(localObject1.getClass());
          QLog.d("MultiEmotionSaveManager", 2, ((StringBuilder)localObject2).toString());
        }
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiEmotionSaveManager", 2, "saveMultiRichMedialFile emoReqList is empty!");
        }
        paramList = new EmotionSaveResult();
        paramList.jdField_a_of_type_Int = -1;
        paramList.jdField_b_of_type_Int = 10006;
        paramList.c = FileSaveErrorInfo.a(10006);
        a(paramList);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("saveMultiRichMedialFile emoReqList count is :");
        paramList.append(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
        QLog.d("MultiEmotionSaveManager", 2, paramList.toString());
      }
      d();
      this.jdField_a_of_type_Long = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
      paramList = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (EmotionSaveResult)paramList.next();
        if (this.jdField_a_of_type_Int < 1) {
          b((EmotionSaveResult)localObject1);
        } else {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(localObject1);
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiEmotionSaveManager", 2, "saveMultiRichMedialFile emoSaveReqList is empty!");
    }
    paramList = new EmotionSaveResult();
    paramList.jdField_a_of_type_Int = -1;
    paramList.jdField_b_of_type_Int = 10006;
    paramList.c = FileSaveErrorInfo.a(10006);
    a(paramList);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmMultiEmotionSaveManager$ISaveCallBack = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof EmotionSaveResult))
    {
      EmotionSaveResult localEmotionSaveResult = (EmotionSaveResult)paramMessage.obj;
      if (localEmotionSaveResult != null)
      {
        int i = paramMessage.what;
        if ((i != 1) && (i != 2)) {
          return false;
        }
        this.jdField_a_of_type_Int -= 1;
        if (paramMessage.what == 2)
        {
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("MSG_TYPE_SAVE_FAIL errorCode = ");
            paramMessage.append(localEmotionSaveResult.jdField_b_of_type_Int);
            paramMessage.append(", errorMsg = ");
            paramMessage.append(localEmotionSaveResult.c);
            QLog.i("MultiEmotionSaveManager", 2, paramMessage.toString());
          }
        }
        else
        {
          this.jdField_b_of_type_Boolean = true;
        }
        this.jdField_b_of_type_Int += 1;
        e();
        paramMessage = (EmotionSaveResult)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
        if (paramMessage != null)
        {
          b(paramMessage);
          return false;
        }
        if (this.jdField_a_of_type_Int == 0)
        {
          paramMessage = new EmotionSaveResult();
          if (this.jdField_b_of_type_Boolean)
          {
            paramMessage.jdField_a_of_type_Int = 0;
          }
          else
          {
            paramMessage.jdField_a_of_type_Int = -1;
            paramMessage.jdField_b_of_type_Int = localEmotionSaveResult.jdField_b_of_type_Int;
            paramMessage.c = localEmotionSaveResult.c;
          }
          a(paramMessage);
        }
      }
    }
    return false;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiEmotionSaveManager", 2, "onDestroy");
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.MultiEmotionSaveManager
 * JD-Core Version:    0.7.0.1
 */