package com.tencent.mobileqq.troop.homework.recite.utils;

import ajrl;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.homework.recite.config.ReciteConfig;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.troop.homework.recite.data.WordInfo;
import com.tencent.mobileqq.troop.homework.recite.ui.PinyinTextView;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ReciteDetectManager
{
  private static final String jdField_b_of_type_JavaLangString = ReciteDetectManager.class.getSimpleName() + "ReciteDetect";
  double jdField_a_of_type_Double = -1.0D;
  public int a;
  protected Handler a;
  protected HandlerThread a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  public ArticleInfo a;
  WordInfo jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo = null;
  protected ReciteDetectManager.DetectHandler a;
  private ReciteDetectManager.ReciteDetectListener jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager$ReciteDetectListener;
  String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  protected boolean a;
  public int b;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  int d = 0;
  int e = 0;
  int f = -1;
  int g = 0;
  int h = 0;
  
  public ReciteDetectManager(ArticleInfo paramArticleInfo, ReciteDetectManager.ReciteDetectListener paramReciteDetectListener, QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler = new ajrl(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51));
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.size())
    {
      ((ParagraphInfo)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.get(i)).resetWordsReciteStatus();
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager$ReciteDetectListener = paramReciteDetectListener;
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("ReciteDetectHandlerThread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager$DetectHandler = new ReciteDetectManager.DetectHandler(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_Boolean = false;
  }
  
  private WordInfo a()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_Boolean)
        {
          this.e += 1;
          this.f = 0;
          this.jdField_b_of_type_Boolean = false;
          if (this.e < this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.size())
          {
            Object localObject1 = ((ParagraphInfo)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.get(this.e)).generateOrGetWordInfoList(this.e);
            if (this.f < ((List)localObject1).size())
            {
              WordInfo localWordInfo = (WordInfo)((List)localObject1).get(this.f);
              localWordInfo.paragraphPos = this.e;
              if (QLog.isColorLevel()) {
                QLog.d(jdField_b_of_type_JavaLangString, 2, String.format("正在检测的文字是：%s", new Object[] { localWordInfo.toString() }));
              }
              if (this.f == ((List)localObject1).size() - 1) {
                this.jdField_b_of_type_Boolean = true;
              }
              localObject1 = localWordInfo;
              if (!PinyinTextView.a(localWordInfo.text))
              {
                this.jdField_a_of_type_Int += 1;
                localObject1 = localWordInfo;
              }
              return localObject1;
            }
          }
        }
        else
        {
          this.f += 1;
          continue;
        }
        Object localObject3 = null;
      }
      finally {}
    }
  }
  
  private void a(WordInfo paramWordInfo)
  {
    label241:
    for (;;)
    {
      try
      {
        Object localObject;
        if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localObject = null;
          if (localObject == null) {
            break label241;
          }
          if ((paramWordInfo.paragraphPos >= ((WordInfo)localObject).paragraphPos) && (paramWordInfo.wordPos > ((WordInfo)localObject).wordPos))
          {
            break label241;
            if ((paramWordInfo != null) && (paramWordInfo.paragraphPos < this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.size()) && (i != 0))
            {
              localObject = ((ParagraphInfo)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.get(paramWordInfo.paragraphPos)).generateOrGetWordInfoList(paramWordInfo.paragraphPos);
              i = paramWordInfo.wordPos + 1;
              if (i < ((List)localObject).size())
              {
                paramWordInfo = (WordInfo)((List)localObject).get(i);
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_b_of_type_JavaLangString, 2, String.format("ifNextWordIsPunctuationThenShow：%s", new Object[] { paramWordInfo.toString() }));
                }
                if (!paramWordInfo.isNormalWord())
                {
                  paramWordInfo.color = WordInfo.COLOR_DEFAULT;
                  this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager$ReciteDetectListener.a(paramWordInfo);
                  this.f += 1;
                  if (i == ((List)localObject).size() - 1) {
                    this.jdField_b_of_type_Boolean = true;
                  }
                }
              }
            }
          }
        }
        else
        {
          localObject = (WordInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
          continue;
        }
        int i = 0;
        continue;
        i = 1;
      }
      finally {}
    }
  }
  
  /* Error */
  private WordInfo b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 81	com/tencent/mobileqq/troop/homework/recite/utils/ReciteDetectManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: invokevirtual 194	java/util/ArrayList:isEmpty	()Z
    //   9: ifne +19 -> 28
    //   12: aload_0
    //   13: getfield 81	com/tencent/mobileqq/troop/homework/recite/utils/ReciteDetectManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   16: iconst_0
    //   17: invokevirtual 225	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   20: checkcast 158	com/tencent/mobileqq/troop/homework/recite/data/WordInfo
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: aconst_null
    //   29: astore_1
    //   30: goto -6 -> 24
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	ReciteDetectManager
    //   23	7	1	localWordInfo	WordInfo
    //   33	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	33	finally
  }
  
  private void b(double paramDouble, String[] paramArrayOfString)
  {
    int j = 0;
    for (;;)
    {
      String str1;
      ArrayList localArrayList;
      try
      {
        str1 = this.jdField_a_of_type_JavaUtilList.toString() + ",mLastSentenceSubLen:" + this.g;
        String str2;
        if (this.jdField_a_of_type_Double != paramDouble)
        {
          this.jdField_a_of_type_Double = paramDouble;
          this.g = 0;
          i = 0;
          localArrayList = new ArrayList(paramArrayOfString.length);
          if (j >= paramArrayOfString.length) {
            break label148;
          }
          str2 = paramArrayOfString[j];
          if (PinyinTextView.a(str2))
          {
            if (!QLog.isColorLevel()) {
              break label300;
            }
            QLog.d(jdField_b_of_type_JavaLangString, 2, "背诵内容是标点符号，跳过");
            break label300;
          }
        }
        else
        {
          if (this.g == 0) {
            break label309;
          }
          j = this.g;
          i = 0;
          continue;
        }
        localArrayList.add(str2);
      }
      finally {}
      label148:
      if ((i != 0) && (this.h >= 0))
      {
        if (this.h != 0) {
          break label261;
        }
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      for (;;)
      {
        if (!localArrayList.isEmpty())
        {
          this.h = this.jdField_a_of_type_JavaUtilList.size();
          this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
        }
        if (QLog.isColorLevel()) {
          QLog.d("yellowye", 2, "recitingPinyinsList, 插入前：" + str1 + "\n插入后：" + this.jdField_a_of_type_JavaUtilList.toString());
        }
        return;
        label261:
        if (this.h <= this.jdField_a_of_type_JavaUtilList.size() - 1) {
          this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList.subList(0, this.h);
        }
      }
      label300:
      j += 1;
      continue;
      label309:
      int i = 1;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.c = 0;
  }
  
  private void d()
  {
    int i;
    label151:
    label200:
    do
    {
      for (;;)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_b_of_type_JavaLangString, 2, "doDetectNextWord, start");
          }
          i = this.jdField_a_of_type_JavaUtilList.size();
          if (i == 0) {
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo == null)
          {
            WordInfo localWordInfo = b();
            if (localWordInfo != null) {
              this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo = localWordInfo;
            }
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo != null) {
              break label151;
            }
            a();
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo = a();
        }
        finally {}
        while ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.isNormalWord()))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.color = WordInfo.COLOR_DEFAULT;
          localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
          ((Message)localObject2).what = 0;
          ((Message)localObject2).obj = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo = a();
        }
        continue;
        if (!QLog.isColorLevel()) {
          break label751;
        }
        QLog.d(jdField_b_of_type_JavaLangString, 2, String.format("背诵内容[%s]\n检测答案[%s]", new Object[] { this.jdField_a_of_type_JavaUtilList.toString(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.pinyin2Detect.toString() }));
        break label751;
        if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label754;
        }
        localObject2 = (String)this.jdField_a_of_type_JavaUtilList.get(i);
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.isPinyinDetectRight((String)localObject2)) {
          break;
        }
        this.d = 0;
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.color = WordInfo.COLOR_DEFAULT;
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.isDetected = true;
        localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        ((Message)localObject2).what = 0;
        ((Message)localObject2).obj = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
        if (i >= this.h)
        {
          this.g += i - this.h;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_b_of_type_JavaLangString, 2, "detected！！！mLastSentenceSubLen:" + this.g);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo = null;
        localObject2 = this.jdField_a_of_type_JavaUtilList.toString();
        this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList.subList(i + 1, this.jdField_a_of_type_JavaUtilList.size());
        str1 = this.jdField_a_of_type_JavaUtilList.toString();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, String.format("识别结果,对 || 对背诵内容进行截断，为下一个字检测所用：\n before[%s], \n after[%s], removeIndex[%d]", new Object[] { localObject2, str1, Integer.valueOf(i) }));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.jdField_b_of_type_Int < 0) {
          d();
        }
      }
      if (i <= this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.c) {
        break label744;
      }
      this.d += 1;
      this.jdField_b_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.color = WordInfo.COLOR_WRONG;
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.isDetected = true;
      localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      ((Message)localObject2).what = 0;
      ((Message)localObject2).obj = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo = null;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, String.format("识别结果,错||mErroCount[%d], continuousWrongNum[%d]", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.d) }));
      }
      if (this.d < this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.d) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "repeatRecite");
      }
      c();
      localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      ((Message)localObject2).what = 1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    String str1 = this.jdField_a_of_type_JavaLangString;
    String str2 = TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo != null) {}
    for (Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.title;; localObject2 = "")
    {
      TroopReportor.a("Grp_edu", "Grp_recite", "Norecognize_Recite_Again_Clk", 0, 0, new String[] { str1, str2, localObject2 });
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.jdField_b_of_type_Int >= 0) {
        break;
      }
      d();
      break;
      label744:
      i += 1;
      break label200;
      label751:
      i = 0;
      break label200;
      label754:
      break;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager$ReciteDetectListener == null) {
        break;
      }
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = 2;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    } while (!QLog.isColorLevel());
    QLog.d(jdField_b_of_type_JavaLangString, 2, String.format("onCompleteRecite, mWordTotalCount[%d], mErroCount[%d], mRemindCount[%d]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.c) }));
    return;
    this.jdField_a_of_type_Int = 0;
    this.c = 0;
  }
  
  public void a(double paramDouble, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager$ReciteDetectListener == null) || (this.jdField_a_of_type_Boolean)) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager$DetectHandler.obtainMessage(2);
    Bundle localBundle = new Bundle();
    localBundle.putDouble("startTime", paramDouble);
    localBundle.putStringArray("pinyins", paramArrayOfString);
    localMessage.setData(localBundle);
    localMessage.sendToTarget();
  }
  
  public void b()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.jdField_a_of_type_Int)
        {
          Object localObject2;
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.isReminded))
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo;
            if (localObject2 != null)
            {
              ((WordInfo)localObject2).color = -7829368;
              ((WordInfo)localObject2).isReminded = true;
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
              this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager$ReciteDetectListener.a((WordInfo)localObject2);
              this.c += 1;
            }
          }
          else
          {
            WordInfo localWordInfo = a();
            localObject2 = localWordInfo;
            if (localWordInfo == null) {
              continue;
            }
            localObject2 = localWordInfo;
            if (localWordInfo.isNormalWord()) {
              continue;
            }
            localWordInfo.color = WordInfo.COLOR_DEFAULT;
            this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager$ReciteDetectListener.a(localWordInfo);
            localWordInfo = a();
            continue;
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.utils.ReciteDetectManager
 * JD-Core Version:    0.7.0.1
 */