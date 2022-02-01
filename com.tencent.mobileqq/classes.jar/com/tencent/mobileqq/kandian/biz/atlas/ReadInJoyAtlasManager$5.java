package com.tencent.mobileqq.kandian.biz.atlas;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xb40.oidb_0xb40.CheckFavoriteRspBody;
import tencent.im.oidb.cmd0xb40.oidb_0xb40.CheckFavoriteRspItem;
import tencent.im.oidb.cmd0xb40.oidb_0xb40.RspBody;

class ReadInJoyAtlasManager$5
  extends ProtoUtils.AppProtocolObserver
{
  ReadInJoyAtlasManager$5(ReadInJoyAtlasManager paramReadInJoyAtlasManager, ReadInJoyAtlasManager.AtlasCallback paramAtlasCallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      paramBundle = ReadInJoyAtlasManager.TAG;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getAtlasFavoriteStatus onResult, errorCode=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d(paramBundle, 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramInt != -1) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      try
      {
        paramBundle = new oidb_0xb40.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((oidb_0xb40.CheckFavoriteRspBody)paramBundle.msg_check_favorite_rsp.get()).rpt_msg_rsp_items.get().iterator();
        if (paramArrayOfByte.hasNext())
        {
          Object localObject2 = (oidb_0xb40.CheckFavoriteRspItem)paramArrayOfByte.next();
          paramBundle = ((oidb_0xb40.CheckFavoriteRspItem)localObject2).bytes_rowkey.get().toStringUtf8();
          if (((oidb_0xb40.CheckFavoriteRspItem)localObject2).uint32_result.get() == 1)
          {
            bool = true;
            localObject1 = new ArrayList();
            if (bool)
            {
              localObject2 = ((oidb_0xb40.CheckFavoriteRspItem)localObject2).bytes_cid_list.get().iterator();
              if (((Iterator)localObject2).hasNext())
              {
                ((ArrayList)localObject1).add(((ByteStringMicro)((Iterator)localObject2).next()).toStringUtf8());
                continue;
              }
            }
            if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAtlasReadInJoyAtlasManager$AtlasCallback == null) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqKandianBizAtlasReadInJoyAtlasManager$AtlasCallback.a(true, paramBundle, bool, (ArrayList)localObject1);
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBizAtlasReadInJoyAtlasManager$AtlasCallback;
        if (paramBundle != null) {
          paramBundle.a(false, null, false, null);
        }
        paramBundle = ReadInJoyAtlasManager.TAG;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getAtlasFavoriteStatus onResult(), exception=");
        ((StringBuilder)localObject1).append(paramArrayOfByte.toString());
        QLog.e(paramBundle, 1, ((StringBuilder)localObject1).toString());
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager.5
 * JD-Core Version:    0.7.0.1
 */