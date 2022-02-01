package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FileSaveReq
{
  public int a;
  public QFileMultiSaveReq a;
  public PicReq a;
  public ShortVideoReq a;
  public CopyOnWriteArrayList<ISingleFileSaveCallBack> a;
  
  public FileSaveReq()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  public static FileSaveReq a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    FileSaveReq localFileSaveReq = new FileSaveReq();
    localFileSaveReq.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq = new QFileMultiSaveReq(paramQQAppInterface, paramChatMessage);
    return localFileSaveReq;
  }
  
  public static FileSaveReq a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    FileSaveReq localFileSaveReq = new FileSaveReq();
    localFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq = ShortVideoBusiManager.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localFileSaveReq.jdField_a_of_type_Int = 2;
    return localFileSaveReq;
  }
  
  public static FileSaveReq a(MessageForPic paramMessageForPic)
  {
    int i = 6;
    if (paramMessageForPic.fileSizeFlag == 1) {
      i = 7;
    }
    FileSaveReq localFileSaveReq = new FileSaveReq();
    PicReq localPicReq = PicBusiManager.a(i, 1);
    localPicReq.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
    localFileSaveReq.jdField_a_of_type_ComTencentMobileqqPicPicReq = localPicReq;
    localFileSaveReq.jdField_a_of_type_Int = 1;
    return localFileSaveReq;
  }
  
  public static List<FileSaveReq> a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, ItemBuilderFactory paramItemBuilderFactory, ISingleFileSaveCallBack paramISingleFileSaveCallBack)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramItemBuilderFactory == null)) {
      return null;
    }
    paramItemBuilderFactory = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (ChatMessage)localIterator.next();
      switch (ItemBuilderFactory.a(paramQQAppInterface, paramList))
      {
      default: 
        paramList = null;
      }
    }
    while (paramList != null)
    {
      paramList.a(paramISingleFileSaveCallBack);
      paramItemBuilderFactory.add(paramList);
      break;
      if (((paramList instanceof MessageForPic)) && (!ZhituManager.a((MessageForPic)paramList)))
      {
        paramList = a((MessageForPic)paramList);
        continue;
        if ((paramList instanceof MessageForShortVideo))
        {
          paramList = a(paramQQAppInterface, (MessageForShortVideo)paramList);
          continue;
          if ((paramList instanceof MessageForShortVideo))
          {
            paramList = b(paramQQAppInterface, (MessageForShortVideo)paramList);
            continue;
            if ((paramList instanceof MessageForFile))
            {
              paramList = a(paramQQAppInterface, paramList);
              paramList.jdField_a_of_type_Int = 4;
              continue;
            }
            if ((paramList instanceof MessageForTroopFile))
            {
              paramList = a(paramQQAppInterface, paramList);
              paramList.jdField_a_of_type_Int = 6;
              continue;
              if ((paramList instanceof MessageForFile))
              {
                paramList = a(paramQQAppInterface, paramList);
                paramList.jdField_a_of_type_Int = 5;
                continue;
              }
              if ((paramList instanceof MessageForTroopFile))
              {
                paramList = a(paramQQAppInterface, paramList);
                paramList.jdField_a_of_type_Int = 7;
                continue;
                if ((paramList instanceof MessageForDLFile))
                {
                  paramList = a(paramQQAppInterface, paramList);
                  paramList.jdField_a_of_type_Int = 9;
                  continue;
                  if ((paramList instanceof MessageForDLFile))
                  {
                    paramList = a(paramQQAppInterface, paramList);
                    paramList.jdField_a_of_type_Int = 8;
                    continue;
                    return paramItemBuilderFactory;
                  }
                }
              }
            }
          }
        }
      }
      paramList = null;
    }
  }
  
  public static FileSaveReq b(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    FileSaveReq localFileSaveReq = new FileSaveReq();
    localFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq = ShortVideoBusiManager.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localFileSaveReq.jdField_a_of_type_Int = 3;
    return localFileSaveReq;
  }
  
  public void a(ISingleFileSaveCallBack paramISingleFileSaveCallBack)
  {
    if ((paramISingleFileSaveCallBack != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramISingleFileSaveCallBack))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramISingleFileSaveCallBack);
    }
  }
  
  public void b(ISingleFileSaveCallBack paramISingleFileSaveCallBack)
  {
    if ((paramISingleFileSaveCallBack != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramISingleFileSaveCallBack))) {}
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramISingleFileSaveCallBack);
      return;
    }
    catch (Exception paramISingleFileSaveCallBack)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FileSaveReq", 2, "removeSaveCallBack exception = " + paramISingleFileSaveCallBack.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.FileSaveReq
 * JD-Core Version:    0.7.0.1
 */