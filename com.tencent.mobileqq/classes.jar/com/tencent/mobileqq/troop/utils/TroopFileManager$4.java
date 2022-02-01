package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.biz.troop.file.protocol.TroopFileReqTransFileObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import java.util.Map;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.TransFileRspBody;

class TroopFileManager$4
  extends TroopFileReqTransFileObserver
{
  TroopFileManager$4(TroopFileManager paramTroopFileManager) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d9.TransFileRspBody paramTransFileRspBody, Bundle paramBundle)
  {
    Object localObject = this.a;
    ((TroopFileManager)localObject).jdField_a_of_type_Int -= 1;
    if ((paramBoolean) && (paramTransFileRspBody != null))
    {
      localObject = paramBundle.getString("fileId");
      paramBundle = (TroopFileInfo)this.a.c.get(localObject);
      if (paramBundle == null) {
        return;
      }
      int i = paramTransFileRspBody.int32_ret_code.get();
      int j = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTransFileResult: fileId:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" isSuccess:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" errCode:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" retCode:");
      localStringBuilder.append(i);
      TroopFileTransferUtil.Log.c("TroopFileManager", j, localStringBuilder.toString());
      if (i < 0)
      {
        paramInt = 501;
        if (i != -25086)
        {
          if (i != -6101)
          {
            if (i == -403) {
              break label296;
            }
            if ((i != -107) && (i != -22))
            {
              if ((i == -20001) || (i == -20000)) {
                break label296;
              }
              if ((i == -302) || (i == -301) || (i == -103)) {
                break label289;
              }
              if (i != -102)
              {
                if (i != -4)
                {
                  if (i != -3) {
                    break label300;
                  }
                  paramInt = 504;
                  break label300;
                }
                paramInt = 103;
                break label300;
              }
            }
            paramInt = 101;
            break label300;
          }
          label289:
          paramInt = 502;
          break label300;
        }
        label296:
        paramInt = 503;
        label300:
        this.a.a(paramBundle, paramInt);
        return;
      }
      paramTransFileRspBody = paramTransFileRspBody.str_save_file_path.get();
      this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(paramBundle.jdField_a_of_type_JavaUtilUUID, paramTransFileRspBody);
      paramBundle.b = paramTransFileRspBody;
      paramBundle.jdField_a_of_type_Int = 102;
      paramBundle.c = 0;
      this.a.c.remove(localObject);
      this.a.c.put(paramTransFileRspBody, paramBundle);
      this.a.d(paramBundle);
      paramTransFileRspBody = (TroopFileManager.FileManagerStatus)this.a.d.get(paramBundle.g);
      if (paramTransFileRspBody != null) {
        paramTransFileRspBody.a = null;
      }
      this.a.a(paramBundle, 505);
      return;
    }
    TroopFileTransferUtil.Log.a("TroopFileManager", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "onTransFileResult:  isSuccess:false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager.4
 * JD-Core Version:    0.7.0.1
 */