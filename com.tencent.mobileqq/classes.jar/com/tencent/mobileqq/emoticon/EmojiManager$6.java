package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class EmojiManager$6
  extends EmojiManager.SyncFetchEmoticonKeyObserver
{
  EmojiManager$6(EmojiManager paramEmojiManager, EmoticonHandler paramEmoticonHandler, ReqInfo paramReqInfo, Object paramObject)
  {
    super(paramEmojiManager, paramEmoticonHandler);
  }
  
  public void a(boolean paramBoolean, int paramInt, EmoticonResp paramEmoticonResp)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    ??? = (EmoticonHandler)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    int i = paramEmoticonResp.epId;
    int j = paramEmoticonResp.timestamp;
    Object localObject1 = (ArrayList)paramEmoticonResp.data;
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonReqInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonReqInfo.jdField_a_of_type_JavaLangString.equals(paramEmoticonResp.keySeq)))
    {
      ((EmoticonHandler)???).b(this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonReqInfo.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonReqInfo.jdField_a_of_type_Int = paramEmoticonResp.resultcode;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonReqInfo.b = paramEmoticonResp.timeoutReason;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.notify();
        if (!QLog.isColorLevel()) {
          break;
        }
        ??? = EmojiManager.a();
        StringBuilder localStringBuilder = new StringBuilder().append("fetchEmoticonEncryptKeys|net get key backepId=").append(i).append(" tstamp=").append(j).append(" list.size=");
        if (localObject1 == null)
        {
          localObject1 = "null";
          QLog.d((String)???, 2, localObject1 + " encryptSuccess=" + paramBoolean + " type=" + paramInt + " er.resultCode=" + paramEmoticonResp.resultcode);
          return;
        }
      }
      localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiManager.6
 * JD-Core Version:    0.7.0.1
 */