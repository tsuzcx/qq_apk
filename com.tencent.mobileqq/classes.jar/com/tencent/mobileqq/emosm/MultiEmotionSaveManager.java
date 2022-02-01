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
  private BaseQQAppInterface a;
  private Handler b;
  private volatile CopyOnWriteArrayList<EmotionSaveResult> c = new CopyOnWriteArrayList();
  private volatile ConcurrentLinkedQueue<EmotionSaveResult> d = new ConcurrentLinkedQueue();
  private volatile int e = 0;
  private volatile int f = 0;
  private MultiEmotionSaveManager.ISaveCallBack g;
  private boolean h = false;
  private boolean i = false;
  private long j = 0L;
  
  public MultiEmotionSaveManager(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.a = paramBaseQQAppInterface;
    this.b = new Handler(Looper.getMainLooper(), this);
  }
  
  private void a(String paramString1, String paramString2, EmotionSaveResult paramEmotionSaveResult)
  {
    this.e += 1;
    boolean bool = TextUtils.isEmpty(paramString1);
    int m = 0;
    if (bool) {
      k = 10001;
    } else if (TextUtils.isEmpty(paramString2)) {
      k = 10002;
    } else if (!FileUtils.fileExists(paramString1)) {
      k = 10003;
    } else {
      k = 0;
    }
    if (k != 0)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("realSaveEmo failed! errorCode = ");
        paramString1.append(k);
        QLog.d("MultiEmotionSaveManager", 2, paramString1.toString());
      }
      if (paramEmotionSaveResult != null)
      {
        paramEmotionSaveResult.d = -1;
        paramEmotionSaveResult.e = k;
        paramEmotionSaveResult.f = FileSaveErrorInfo.a(k);
        paramString1 = this.b.obtainMessage(2);
        paramString1.obj = paramEmotionSaveResult;
        this.b.sendMessage(paramString1);
      }
      return;
    }
    Object localObject1 = paramString2;
    int k = m;
    Object localObject3;
    do
    {
      if (k > 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(k);
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
      localObject3 = new File(EmotionPathConstants.a, (String)localObject2);
      k += 1;
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
    a(paramEmotionSaveResult.b, (String)localObject, paramEmotionSaveResult);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiEmotionSaveManager", 2, "clearCatch");
    }
    this.d.clear();
    this.c.clear();
    this.j = 0L;
    this.f = 0;
    this.h = false;
    this.i = false;
    this.e = 0;
    this.b.removeCallbacksAndMessages(null);
  }
  
  private void d()
  {
    MultiEmotionSaveManager.ISaveCallBack localISaveCallBack = this.g;
    if (localISaveCallBack != null) {
      localISaveCallBack.b();
    }
  }
  
  private void e()
  {
    if (this.j != 0L)
    {
      if (this.g == null) {
        return;
      }
      double d1 = this.f;
      Double.isNaN(d1);
      double d2 = this.j;
      Double.isNaN(d2);
      int k = (int)(d1 * 100.0D / d2);
      if (this.f == this.j) {
        k = 100;
      }
      MultiEmotionSaveManager.ISaveCallBack localISaveCallBack = this.g;
      if (localISaveCallBack != null) {
        localISaveCallBack.a(k);
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiEmotionSaveManager", 2, "cancelMultiEmoSave");
    }
    c();
    MultiEmotionSaveManager.ISaveCallBack localISaveCallBack = this.g;
    if (localISaveCallBack != null) {
      localISaveCallBack.a();
    }
  }
  
  public void a(EmotionSaveResult paramEmotionSaveResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiEmotionSaveManager", 2, "saveComplete");
    }
    MultiEmotionSaveManager.ISaveCallBack localISaveCallBack = this.g;
    if (localISaveCallBack != null) {
      localISaveCallBack.a(paramEmotionSaveResult);
    }
    c();
  }
  
  public void a(MultiEmotionSaveManager.ISaveCallBack paramISaveCallBack)
  {
    this.g = paramISaveCallBack;
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
          ((EmotionSaveResult)localObject2).a = ((CustomEmoticonInfoBase)localObject1).resID;
          ((EmotionSaveResult)localObject2).b = ((CustomEmoticonInfoBase)localObject1).path;
          this.c.add(localObject2);
        }
        else if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("temp is not CustomEmoticonInfoBase class is ");
          ((StringBuilder)localObject2).append(localObject1.getClass());
          QLog.d("MultiEmotionSaveManager", 2, ((StringBuilder)localObject2).toString());
        }
      }
      if (this.c.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiEmotionSaveManager", 2, "saveMultiRichMedialFile emoReqList is empty!");
        }
        paramList = new EmotionSaveResult();
        paramList.d = -1;
        paramList.e = 10006;
        paramList.f = FileSaveErrorInfo.a(10006);
        a(paramList);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("saveMultiRichMedialFile emoReqList count is :");
        paramList.append(this.c.size());
        QLog.d("MultiEmotionSaveManager", 2, paramList.toString());
      }
      d();
      this.j = this.c.size();
      paramList = this.c.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (EmotionSaveResult)paramList.next();
        if (this.e < 1) {
          b((EmotionSaveResult)localObject1);
        } else {
          this.d.add(localObject1);
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiEmotionSaveManager", 2, "saveMultiRichMedialFile emoSaveReqList is empty!");
    }
    paramList = new EmotionSaveResult();
    paramList.d = -1;
    paramList.e = 10006;
    paramList.f = FileSaveErrorInfo.a(10006);
    a(paramList);
  }
  
  public void b()
  {
    this.g = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof EmotionSaveResult))
    {
      EmotionSaveResult localEmotionSaveResult = (EmotionSaveResult)paramMessage.obj;
      if (localEmotionSaveResult != null)
      {
        int k = paramMessage.what;
        if ((k != 1) && (k != 2)) {
          return false;
        }
        this.e -= 1;
        if (paramMessage.what == 2)
        {
          this.h = true;
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("MSG_TYPE_SAVE_FAIL errorCode = ");
            paramMessage.append(localEmotionSaveResult.e);
            paramMessage.append(", errorMsg = ");
            paramMessage.append(localEmotionSaveResult.f);
            QLog.i("MultiEmotionSaveManager", 2, paramMessage.toString());
          }
        }
        else
        {
          this.i = true;
        }
        this.f += 1;
        e();
        paramMessage = (EmotionSaveResult)this.d.poll();
        if (paramMessage != null)
        {
          b(paramMessage);
          return false;
        }
        if (this.e == 0)
        {
          paramMessage = new EmotionSaveResult();
          if (this.i)
          {
            paramMessage.d = 0;
          }
          else
          {
            paramMessage.d = -1;
            paramMessage.e = localEmotionSaveResult.e;
            paramMessage.f = localEmotionSaveResult.f;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.MultiEmotionSaveManager
 * JD-Core Version:    0.7.0.1
 */