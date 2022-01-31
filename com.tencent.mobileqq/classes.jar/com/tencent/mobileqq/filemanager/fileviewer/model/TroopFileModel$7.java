package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import apkt;
import apne;
import apnf;
import apnq;
import apug;
import azqv;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class TroopFileModel$7
  implements Runnable
{
  public TroopFileModel$7(apnq paramapnq, azqv paramazqv) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileModel<FileAssistant>", 4, String.format("update file info: status:%d fileName:%s errorCode:%d", new Object[] { Integer.valueOf(this.a.b), this.a.g, Integer.valueOf(this.a.jdField_c_of_type_Int) }));
    }
    Object localObject1 = this.this$0.jdField_a_of_type_Apkt.a();
    if ((((FileManagerEntity)localObject1).isFromProcessingForward2c2cOrDiscItem()) || (((FileManagerEntity)localObject1).isFromProcessingForward2DatalineItem())) {
      return;
    }
    if (this.this$0.jdField_a_of_type_Apne != null) {
      this.this$0.jdField_a_of_type_Apne.a(this.a.e, this.a.jdField_c_of_type_JavaLangString);
    }
    switch (this.a.b)
    {
    }
    for (;;)
    {
      apnq.a(this.this$0, this.a.b);
      return;
      if ((this.this$0.jdField_a_of_type_Apnf != null) && (apnq.a(this.this$0) != 8)) {
        this.this$0.jdField_a_of_type_Apnf.d();
      }
      if (this.this$0.jdField_a_of_type_Apnf != null)
      {
        this.this$0.jdField_a_of_type_Apnf.a((float)this.a.d * 1.0F / ((float)this.a.jdField_c_of_type_Long * 1.0F));
        continue;
        if (this.this$0.jdField_a_of_type_Apnf != null)
        {
          this.this$0.jdField_a_of_type_Apnf.e();
          continue;
          long l = ((FileManagerEntity)localObject1).lastTime;
          Object localObject2 = ((FileManagerEntity)localObject1).selfUin;
          boolean bool1 = ((FileManagerEntity)localObject1).bSend;
          boolean bool2 = ((FileManagerEntity)localObject1).isZipInnerFile;
          FileManagerEntity localFileManagerEntity = apug.a(this.a);
          ((FileManagerEntity)localObject1).copyFrom(localFileManagerEntity);
          ((FileManagerEntity)localObject1).lastTime = l;
          ((FileManagerEntity)localObject1).selfUin = ((String)localObject2);
          ((FileManagerEntity)localObject1).bSend = bool1;
          ((FileManagerEntity)localObject1).isZipInnerFile = bool2;
          if ((this.this$0.b == 3) && (this.this$0.e() == 2))
          {
            localObject2 = new SessionInfo();
            ((SessionInfo)localObject2).a = 1;
            l = this.this$0.jdField_a_of_type_AndroidOsBundle.getLong("troopfile_shmsgseq");
            MessageRecord localMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(((FileManagerEntity)localObject1).TroopUin), 1, l, -2017);
            Rect localRect = (Rect)this.this$0.jdField_a_of_type_AndroidOsBundle.getParcelable("file_browser_params_thumb_bound");
            if (this.this$0.jdField_a_of_type_Apkq != null)
            {
              ThreadManagerV2.getUIHandlerV2().postDelayed(new TroopFileModel.7.1(this, localMessageRecord, (SessionInfo)localObject2, (FileManagerEntity)localObject1, localFileManagerEntity, localRect), 100L);
              ThreadManagerV2.getUIHandlerV2().postDelayed(new TroopFileModel.7.2(this, localMessageRecord), 300L);
            }
          }
          if (this.this$0.d() == 3)
          {
            if (this.this$0.jdField_a_of_type_Apnf != null) {
              this.this$0.jdField_a_of_type_Apnf.f();
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.w("TroopFileModel<FileAssistant>", 2, "file download finished, but file not exist.");
            continue;
            if (this.this$0.jdField_a_of_type_Apnf != null)
            {
              this.this$0.jdField_a_of_type_Apnf.e();
              continue;
              if (this.this$0.jdField_a_of_type_Apnf != null)
              {
                this.this$0.jdField_a_of_type_Apnf.f();
                continue;
                if (this.this$0.jdField_a_of_type_Apnf != null) {
                  this.this$0.jdField_a_of_type_Apnf.d();
                }
                if (this.this$0.jdField_a_of_type_Apnf != null)
                {
                  this.this$0.jdField_a_of_type_Apnf.a((float)this.a.d * 1.0F / ((float)this.a.jdField_c_of_type_Long * 1.0F));
                  continue;
                  localObject1 = new Intent();
                  ((Intent)localObject1).putExtra("TroopFile_DeleteFile", true);
                  ((Intent)localObject1).putExtra("TroopFile_FileName", this.a.g);
                  this.this$0.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject1);
                  this.this$0.jdField_a_of_type_AndroidAppActivity.finish();
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.7
 * JD-Core Version:    0.7.0.1
 */