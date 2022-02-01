package com.tencent.mobileqq.filemanager.data.search.troop;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchItemData;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyFileSearchRspBody;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyFileSearchRspBody.Item;
import tencent.im.cs.cmd0x383.cmd0x383.RspBody;

class TroopFileSearchEngine$4
  extends BizTroopObserver
{
  TroopFileSearchEngine$4(TroopFileSearchEngine paramTroopFileSearchEngine) {}
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    ArrayList localArrayList = new ArrayList();
    TroopFileSearchEngine.a(this.a, true);
    if ((paramObject != null) && (paramBoolean)) {}
    for (;;)
    {
      try
      {
        paramObject = (byte[])paramObject;
        localObject1 = new cmd0x383.RspBody();
        try
        {
          paramObject = (cmd0x383.RspBody)((cmd0x383.RspBody)localObject1).mergeFrom(paramObject);
          if (paramObject == null)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("TroopFileSearchEngine<QFile>", 4, "bigRsp is null !!!");
            }
          }
          else
          {
            i = paramObject.int32_ret_code.get();
            if (i < 0)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("TroopFileSearchEngine<QFile>", 4, String.format("onRspTroopFileSearch - retCode: %d", new Object[] { Integer.valueOf(i) }));
              }
            }
            else
            {
              paramObject = (cmd0x383.ApplyFileSearchRspBody)paramObject.msg_file_search_rsp_body.get();
              if (paramObject == null)
              {
                if (QLog.isDevelopLevel())
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("rsp = ");
                  ((StringBuilder)localObject1).append(paramObject);
                  QLog.d("TroopFileSearchEngine<QFile>", 4, ((StringBuilder)localObject1).toString());
                }
              }
              else
              {
                localObject1 = paramObject.bytes_key_word.get().toStringUtf8();
                if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(TroopFileSearchEngine.d(this.a))))
                {
                  QLog.i("TroopFileSearchEngine<QFile>", 1, "keyword is update, current result is old");
                  return;
                }
                TroopFileSearchEngine.c(this.a, paramObject.bytes_sync_cookie.get().toStringUtf8());
                localObject1 = this.a;
                if (paramObject.uint32_is_end.get() != 1) {
                  break label835;
                }
                paramBoolean = true;
                TroopFileSearchEngine.b((TroopFileSearchEngine)localObject1, paramBoolean);
                Object localObject2;
                if (QLog.isDevelopLevel())
                {
                  localObject1 = new StringBuilder();
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("onRspTroopFileSearch cookie = ");
                  ((StringBuilder)localObject2).append(TroopFileSearchEngine.k(this.a));
                  ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append(", isEnd = ");
                  ((StringBuilder)localObject2).append(TroopFileSearchEngine.l(this.a));
                  ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append(", keyWord = ");
                  ((StringBuilder)localObject2).append(paramObject.bytes_key_word.get().toStringUtf8());
                  ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append(", totalCount = ");
                  ((StringBuilder)localObject2).append(paramObject.uint32_total_match_count.get());
                  ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
                  QLog.d("TroopFileSearchEngine<QFile>", 4, ((StringBuilder)localObject1).toString());
                }
                paramObject = paramObject.item_list.get();
                if (paramObject != null)
                {
                  if (paramObject.size() != 0) {
                    break label840;
                  }
                  continue;
                  if (i < paramObject.size())
                  {
                    localObject1 = new TroopFileSearchItemData(TroopFileSearchEngine.f(this.a), (cmd0x383.ApplyFileSearchRspBody.Item)paramObject.get(i));
                    if (((TroopFileSearchItemData)localObject1).i != null)
                    {
                      localObject2 = TroopFileManager.a(TroopFileSearchEngine.f(this.a), ((TroopFileSearchItemData)localObject1).a);
                      TroopFileInfo localTroopFileInfo = ((TroopFileManager)localObject2).a(((TroopFileSearchItemData)localObject1).i.c);
                      if (localTroopFileInfo != null) {
                        ((TroopFileSearchItemData)localObject1).i.b = localTroopFileInfo.b;
                      } else {
                        ((TroopFileSearchItemData)localObject1).i.b = UUID.randomUUID();
                      }
                      ((TroopFileManager)localObject2).a(((TroopFileSearchItemData)localObject1).i.c, ((TroopFileSearchItemData)localObject1).i);
                    }
                    if (QLog.isColorLevel())
                    {
                      localObject2 = new StringBuilder();
                      ((StringBuilder)localObject2).append("fileList[");
                      ((StringBuilder)localObject2).append(i);
                      ((StringBuilder)localObject2).append("]: ");
                      ((StringBuilder)localObject2).append(((TroopFileSearchItemData)localObject1).toString());
                      QLog.d("TroopFileSearchEngine<QFile>", 4, ((StringBuilder)localObject2).toString());
                    }
                    localArrayList.add(localObject1);
                    i += 1;
                    continue;
                  }
                  TroopFileSearchEngine.a(this.a, true, localArrayList);
                  return;
                }
                if (QLog.isDevelopLevel()) {
                  QLog.d("TroopFileSearchEngine<QFile>", 4, "filelist is empty--------");
                }
              }
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          if (!QLog.isDevelopLevel()) {
            break label815;
          }
        }
        QLog.d("TroopFileSearchEngine<QFile>", 4, QLog.getStackTraceString(paramObject));
      }
      catch (Exception paramObject)
      {
        Object localObject1;
        if (!QLog.isDevelopLevel()) {
          break label815;
        }
        QLog.d("TroopFileSearchEngine<QFile>", 4, QLog.getStackTraceString(paramObject));
      }
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("data = ");
        ((StringBuilder)localObject1).append(paramObject);
        ((StringBuilder)localObject1).append(", isSuccess = ");
        ((StringBuilder)localObject1).append(paramBoolean);
        QLog.d("TroopFileSearchEngine<QFile>", 4, ((StringBuilder)localObject1).toString());
      }
      label815:
      QLog.i("TroopFileSearchEngine<QFile>", 1, "error, can not handle search response, return a empty list.");
      TroopFileSearchEngine.a(this.a, false, localArrayList);
      return;
      label835:
      paramBoolean = false;
      continue;
      label840:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.4
 * JD-Core Version:    0.7.0.1
 */