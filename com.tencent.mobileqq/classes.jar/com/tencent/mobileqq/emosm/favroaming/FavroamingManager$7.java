package com.tencent.mobileqq.emosm.favroaming;

import asfl;
import bhyo;
import bhyq;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class FavroamingManager$7
  implements Runnable
{
  public FavroamingManager$7(asfl paramasfl, String[] paramArrayOfString, TransferRequest paramTransferRequest) {}
  
  public void run()
  {
    if (!FileUtils.fileExists(this.jdField_a_of_type_ArrayOfJavaLangString[1]))
    {
      Object localObject = new File(this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      localObject = new bhyo(this.jdField_a_of_type_ArrayOfJavaLangString[0], (File)localObject);
      ((bhyo)localObject).n = true;
      if (bhyq.a((bhyo)localObject, asfl.o(this.this$0)) != 0) {
        QLog.e("FavroamingManager", 1, "collectEmoji fail to download thumbFile: " + this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      }
    }
    while (this.this$0.a == null) {
      return;
    }
    this.this$0.a.transferAsync(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager.7
 * JD-Core Version:    0.7.0.1
 */