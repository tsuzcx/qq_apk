package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class MsgEmoticonPreviewData
  extends EmoticonPreviewData
{
  public MessageRecord a;
  private boolean a;
  
  public MsgEmoticonPreviewData(MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  public int a(List<EmoticonPreviewData> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      EmoticonPreviewData localEmoticonPreviewData = (EmoticonPreviewData)localIterator.next();
      if ((localEmoticonPreviewData instanceof MsgEmoticonPreviewData))
      {
        MessageRecord localMessageRecord = ((MsgEmoticonPreviewData)localEmoticonPreviewData).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if (localMessageRecord.uniseq == this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq) {
          if (((localMessageRecord instanceof MessageForPic)) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) && (((MessageForPic)localMessageRecord).md5 != null))
          {
            if (((MessageForPic)localMessageRecord).md5.equals(((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).md5)) {
              return paramList.indexOf(localEmoticonPreviewData);
            }
          }
          else {
            return paramList.indexOf(localEmoticonPreviewData);
          }
        }
      }
    }
    return paramList.size() - 1;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
  }
  
  public Drawable a(Context paramContext)
  {
    EmotionPreviewData localEmotionPreviewData = new EmotionPreviewData(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    paramContext = EmotionDataManager.a(paramContext, localEmotionPreviewData);
    this.jdField_a_of_type_Boolean = localEmotionPreviewData.c;
    return paramContext;
  }
  
  public CustomEmotionData a()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) && (((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).md5 != null))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((FavroamingDBManager)((QQAppInterface)localObject).getManager(QQManagerFactory.FAVROAMING_DB_MANAGER)).a();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
            if (((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).md5.equalsIgnoreCase(localCustomEmotionData.md5)) {
              return localCustomEmotionData;
            }
          }
        }
      }
    }
    return null;
  }
  
  public EmoticonInfo a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForMarketFace)) {
      return EmotionDataManager.a((MessageForMarketFace)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
    return null;
  }
  
  public String a()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) && (((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).picExtraData != null)) {
      return ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).picExtraData.mTemplateId;
    }
    return null;
  }
  
  public void a(Bundle paramBundle, int paramInt)
  {
    super.a(paramBundle, paramInt);
    paramBundle.putString("cur_msg_uin", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
    paramBundle.putInt("cur_msg_uin_type", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop);
    paramBundle.putLong("cur_msg_uniseq", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForMarketFace;
  }
  
  public boolean a(EmoticonPreviewData paramEmoticonPreviewData)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramEmoticonPreviewData instanceof MsgEmoticonPreviewData))
    {
      paramEmoticonPreviewData = ((MsgEmoticonPreviewData)paramEmoticonPreviewData).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      bool1 = bool2;
      if (paramEmoticonPreviewData != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
        {
          bool1 = bool2;
          if (paramEmoticonPreviewData.shmsgseq == this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq)
          {
            bool1 = bool2;
            if (paramEmoticonPreviewData.msgUid == this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgUid) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public EmoticonPreviewData b(Bundle paramBundle)
  {
    if (paramBundle.containsKey("cur_msg_uniseq"))
    {
      QLog.d("MsgEmoticonPreviewData", 1, "doRestoreSaveInstanceState");
      String str = paramBundle.getString("cur_msg_uin");
      int i = paramBundle.getInt("cur_msg_uin_type");
      long l = paramBundle.getLong("cur_msg_uniseq");
      paramBundle = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramBundle instanceof QQAppInterface)) {
        return new MsgEmoticonPreviewData(((QQAppInterface)paramBundle).getMessageFacade().b(str, i, l));
      }
    }
    return null;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean c()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) && (((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).picExtraData != null))
    {
      int i = ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).picExtraData.from;
      if ((i == 1) || (i == 2)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean d()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) && (((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).picExtraData != null)) {
      return ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).picExtraData.isSelfieFace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.MsgEmoticonPreviewData
 * JD-Core Version:    0.7.0.1
 */