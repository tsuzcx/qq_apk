package com.tencent.mobileqq.troop.filemanager.forward;

import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileReqCopyToObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileError.SimpleErrorInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import java.util.UUID;

public class TroopFileFromTroopForwarder
{
  protected int a;
  protected long a;
  TroopFileReqCopyToObserver a;
  protected TroopFileTransferManager.Item a;
  protected String a;
  
  protected TroopFileFromTroopForwarder(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqCopyToObserver = new TroopFileFromTroopForwarder.1(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null) {
      paramItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString();
    } else {
      paramItem = "";
    }
    this.jdField_a_of_type_JavaLangString = paramItem;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static TroopFileFromTroopForwarder a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getTroop2WeiyunForwarder. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getTroop2WeiyunForwarder. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getTroop2WeiyunForwarder. item.id=null");
      return null;
    }
    if (paramItem.ForwardTroopuin == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getTroop2WeiyunForwarder. ForwardTroopuin=0");
      return null;
    }
    if (paramItem.BusId != 25)
    {
      int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroop2WeiyunForwarder. BusId err:");
      localStringBuilder.append(paramItem.BusId);
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", i, localStringBuilder.toString());
      return null;
    }
    if (TextUtils.isEmpty(paramItem.ForwardPath))
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "get2WeiyunForwarder. ForwardPath=null");
      return null;
    }
    return new TroopFileFromTroopForwarder(paramLong, paramItem, 1);
  }
  
  private final void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    if (!paramBoolean)
    {
      ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(-1);
      paramInt1 = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      paramString1 = new StringBuilder();
      paramString1.append("[");
      paramString1.append(this.jdField_a_of_type_JavaLangString);
      paramString1.append("] onTroop2weiyunResult isSuccess:false ");
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", paramInt1, paramString1.toString());
      paramString1 = new TroopFileError.SimpleErrorInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.jdField_a_of_type_Long, 5, 601);
      TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 5, paramString1);
      return;
    }
    paramInt2 = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    paramString1 = new StringBuilder();
    paramString1.append("[");
    paramString1.append(this.jdField_a_of_type_JavaLangString);
    paramString1.append("] onTroop2weiyunResult retCode:");
    paramString1.append(paramInt1);
    paramString1.append(" sClientWording:");
    paramString1.append(paramString3);
    TroopFileTransferUtil.Log.c("TroopFileFromTroopForwarder", paramInt2, paramString1.toString());
    ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(paramInt1);
    if (paramInt1 != 0)
    {
      if ((paramInt1 != -20001) && (paramInt1 != -20000)) {
        if (paramInt1 != -6101)
        {
          if (paramInt1 != -403) {
            if (paramInt1 != -30)
            {
              if ((paramInt1 != -25) && (paramInt1 != -22))
              {
                if (paramInt1 != -3)
                {
                  if (paramInt1 != 1053)
                  {
                    if ((paramInt1 == 1054) && (!TextUtils.isEmpty(paramString3)))
                    {
                      paramInt1 = 704;
                      break label323;
                    }
                    paramInt1 = 601;
                    break label323;
                  }
                }
                else
                {
                  paramInt1 = 202;
                  break label323;
                }
              }
              else
              {
                paramInt1 = 701;
                break label323;
              }
            }
            else
            {
              paramInt1 = 705;
              break label323;
            }
          }
        }
        else
        {
          paramInt1 = 703;
          break label323;
        }
      }
      paramInt1 = 702;
      label323:
      paramString1 = new TroopFileError.SimpleErrorInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.jdField_a_of_type_Long, 5, paramInt1, paramString3);
      TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 5, paramString1);
      return;
    }
    paramString1 = new TroopFileError.SimpleErrorInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.jdField_a_of_type_Long, 5, 602);
    TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 5, paramString1);
  }
  
  private int b()
  {
    Object localObject = TroopFileTransferUtil.a();
    if (localObject == null)
    {
      i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("] troop2weiyun app=null");
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", i, ((StringBuilder)localObject).toString());
      return -1;
    }
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("] troop2weiyun. BusId:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId);
    localStringBuilder.append(" ForwardBusId:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ForwardBusId);
    localStringBuilder.append(" ForwardPath:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ForwardPath);
    TroopFileTransferUtil.Log.c("TroopFileFromTroopForwarder", i, localStringBuilder.toString());
    TroopFileProtocol.a((QQAppInterface)localObject, true, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, ((QQAppInterface)localObject).getLongAccountUin(), 0L, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqCopyToObserver);
    return 0;
  }
  
  public int a()
  {
    if (1 == this.jdField_a_of_type_Int) {
      return b();
    }
    return -1;
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.forward.TroopFileFromTroopForwarder
 * JD-Core Version:    0.7.0.1
 */