package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.app.Activity;
import android.content.Intent;
import atuz;
import atxf;
import atxg;
import atxr;
import bfjs;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class TroopFileModel$7
  implements Runnable
{
  public TroopFileModel$7(atxr paramatxr, bfjs parambfjs) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileModel<FileAssistant>", 4, String.format("update file info: status:%d fileName:%s errorCode:%d", new Object[] { Integer.valueOf(this.a.b), this.a.g, Integer.valueOf(this.a.jdField_c_of_type_Int) }));
    }
    Object localObject = this.this$0.jdField_a_of_type_Atuz.a();
    if ((((FileManagerEntity)localObject).isFromProcessingForward2c2cOrDiscItem()) || (((FileManagerEntity)localObject).isFromProcessingForward2DatalineItem())) {}
    do
    {
      return;
      if (this.this$0.jdField_a_of_type_Atxf != null) {
        this.this$0.jdField_a_of_type_Atxf.a(this.a.e, this.a.jdField_c_of_type_JavaLangString);
      }
      if (this.this$0.jdField_a_of_type_Atxg != null) {
        break;
      }
      QLog.d("TroopFileModel<FileAssistant>", 1, "updateTroopFileInfo: error, transListener is null!");
    } while (!QLog.isDevelopLevel());
    QQToast.a(this.this$0.jdField_a_of_type_AndroidAppActivity, 1, 2131692312, 0);
    return;
    switch (this.a.b)
    {
    }
    for (;;)
    {
      atxr.a(this.this$0, this.a.b);
      return;
      if (atxr.a(this.this$0) != 8) {
        this.this$0.jdField_a_of_type_Atxg.d();
      }
      this.this$0.jdField_a_of_type_Atxg.a((float)this.a.d * 1.0F / ((float)this.a.jdField_c_of_type_Long * 1.0F));
      continue;
      this.this$0.jdField_a_of_type_Atxg.e();
      continue;
      atxr.a(this.this$0, (FileManagerEntity)localObject, this.a);
      continue;
      this.this$0.jdField_a_of_type_Atxg.e();
      continue;
      this.this$0.jdField_a_of_type_Atxg.f();
      continue;
      this.this$0.jdField_a_of_type_Atxg.d();
      this.this$0.jdField_a_of_type_Atxg.a((float)this.a.d * 1.0F / ((float)this.a.jdField_c_of_type_Long * 1.0F));
      continue;
      localObject = new Intent();
      ((Intent)localObject).putExtra("TroopFile_DeleteFile", true);
      ((Intent)localObject).putExtra("TroopFile_FileName", this.a.g);
      this.this$0.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject);
      this.this$0.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.7
 * JD-Core Version:    0.7.0.1
 */