package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.Intent;
import askf;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.io.Serializable;
import java.util.List;

public final class PicEmoticonInfo$5
  implements Runnable
{
  public PicEmoticonInfo$5(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, H5MagicPlayerActivity.class);
      localIntent.putExtra("clickTime", System.currentTimeMillis());
      localIntent.putExtra("autoPlay", "1");
      localIntent.putExtra("senderUin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localIntent.putExtra("selfUin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localIntent.putExtra("sessionInfo", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      localIntent.putExtra("emoticon", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      Object localObject = (askf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      EmoticonPackage localEmoticonPackage = ((askf)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      if (localEmoticonPackage != null)
      {
        localObject = ((askf)localObject).a(localEmoticonPackage.childEpId);
        if ((localObject != null) && (((List)localObject).size() > 0)) {
          localIntent.putExtra("childEmoticon", (Serializable)((List)localObject).get(0));
        }
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PicEmoticonInfo.5
 * JD-Core Version:    0.7.0.1
 */