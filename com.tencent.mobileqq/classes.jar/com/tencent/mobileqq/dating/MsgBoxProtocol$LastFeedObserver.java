package com.tencent.mobileqq.dating;

import android.os.Bundle;
import android.text.TextUtils;
import appoint.define.appoint_define.RichText;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x877.oidb_0x877.FollowInfo;
import tencent.im.oidb.cmd0x877.oidb_0x877.InteractInfo;
import tencent.im.oidb.cmd0x877.oidb_0x877.MsgWord;
import tencent.im.oidb.cmd0x877.oidb_0x877.RspBody;

public abstract class MsgBoxProtocol$LastFeedObserver
  extends ProtoUtils.TroopProtocolObserver
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg_box.protocol", 2, "UnReadFeedObserver, errorCode=" + paramInt);
    }
    oidb_0x877.RspBody localRspBody;
    if (paramInt == 0) {
      localRspBody = new oidb_0x877.RspBody();
    }
    label723:
    label981:
    for (;;)
    {
      boolean bool2;
      int i;
      long l2;
      long l1;
      boolean bool1;
      try
      {
        localRspBody.mergeFrom(paramArrayOfByte);
        if (!localRspBody.interact_info.has()) {
          break label792;
        }
        bool2 = true;
        i = 0;
        l2 = 0L;
        paramArrayOfByte = new StringBuilder();
        if (!localRspBody.interact_info.uint32_interact_flag.has()) {
          break label753;
        }
        if (localRspBody.interact_info.uint32_interact_flag.get() != 0) {
          break label740;
        }
        if (!localRspBody.interact_info.interact_word.has()) {
          break label723;
        }
        if (localRspBody.interact_info.interact_word.bytes_from_user.has()) {
          paramArrayOfByte.append(localRspBody.interact_info.interact_word.bytes_from_user.get().toStringUtf8());
        }
        if (localRspBody.interact_info.interact_word.bytes_buluo_word.has())
        {
          paramArrayOfByte.append(MsgBoxUtil.b(MsgBoxUtil.a(localRspBody.interact_info.interact_word.bytes_buluo_word.get().toStringUtf8())));
          paramInt = localRspBody.interact_info.uint32_interact_count.get();
          l1 = localRspBody.interact_info.uint64_interact_info_time.get();
          bool1 = true;
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg_box.protocol", 2, "interact_info|needShow=" + bool1 + ",rawcontext=" + paramArrayOfByte.toString() + ",unReadCount=" + paramInt + ",timeStamp=" + l1);
          }
          if ((!TextUtils.isEmpty(paramArrayOfByte.toString())) && (l1 != 0L)) {
            break label981;
          }
          bool1 = false;
          a(true, paramArrayOfByte.toString(), paramInt, l1, bool1, paramBundle);
          if (!localRspBody.follow_info.has()) {
            break label946;
          }
          bool2 = true;
          i = 0;
          l2 = 0L;
          paramArrayOfByte = new StringBuilder();
          if (!localRspBody.follow_info.uint32_follow_flag.has()) {
            break label907;
          }
          if (localRspBody.follow_info.uint32_follow_flag.get() != 0) {
            break label894;
          }
          if (!localRspBody.follow_info.follow_word.has()) {
            break label877;
          }
          if (localRspBody.follow_info.follow_word.bytes_from_user.has()) {
            paramArrayOfByte.append(localRspBody.follow_info.follow_word.bytes_from_user.get().toStringUtf8());
          }
          if (!localRspBody.follow_info.follow_word.bytes_buluo_word.has()) {
            break label805;
          }
          paramArrayOfByte.append(MsgBoxUtil.b(MsgBoxUtil.a(localRspBody.interact_info.interact_word.bytes_buluo_word.get().toStringUtf8())));
          paramInt = localRspBody.follow_info.uint32_follow_count.get();
          l1 = localRspBody.follow_info.uint64_follow_info_time.get();
          bool1 = true;
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg_box.protocol", 2, "follow_info|needShow=" + bool1 + ",rawcontext=" + paramArrayOfByte.toString() + ",unReadCount=" + paramInt + ",timeStamp=" + l1);
          }
          if ((!TextUtils.isEmpty(paramArrayOfByte.toString())) && (l1 != 0L)) {
            break label978;
          }
          bool1 = false;
          b(true, paramArrayOfByte.toString(), paramInt, l1, bool1, paramBundle);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg_box.protocol", 2, paramArrayOfByte.toString(), paramArrayOfByte);
        }
        a(false, null, 0, 0L, false, paramBundle);
        b(false, null, 0, 0L, false, paramBundle);
        return;
      }
      if (localRspBody.interact_info.interact_word.rich_fresh_word.has())
      {
        paramArrayOfByte.append(MsgBoxUtil.a((appoint_define.RichText)localRspBody.interact_info.interact_word.rich_fresh_word.get(), 14));
      }
      else
      {
        paramArrayOfByte.append(localRspBody.interact_info.interact_word.bytes_plain_text.get().toStringUtf8());
        continue;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.msg_box.protocol", 2, "resp.interact_info.interact_word.has() == false");
          continue;
          label740:
          bool1 = false;
          paramInt = i;
          l1 = l2;
          continue;
          label753:
          bool1 = bool2;
          paramInt = i;
          l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.msg_box.protocol", 2, "uint32_interact_flag.has()= false");
            bool1 = bool2;
            paramInt = i;
            l1 = l2;
            continue;
            a(true, null, 0, 0L, false, paramBundle);
            continue;
            if (localRspBody.follow_info.follow_word.rich_fresh_word.has())
            {
              paramArrayOfByte.append(MsgBoxUtil.a((appoint_define.RichText)localRspBody.follow_info.follow_word.rich_fresh_word.get(), 14));
            }
            else
            {
              paramArrayOfByte.append(localRspBody.follow_info.follow_word.bytes_plain_text.get().toStringUtf8());
              continue;
              label877:
              if (QLog.isColorLevel())
              {
                QLog.i("Q.msg_box.protocol", 2, "resp.follow_info.follow_word.has() == false");
                continue;
                label894:
                bool1 = false;
                paramInt = i;
                l1 = l2;
                continue;
                bool1 = bool2;
                paramInt = i;
                l1 = l2;
                if (QLog.isColorLevel())
                {
                  QLog.i("Q.msg_box.protocol", 2, "uint32_follow_flag.has()= false");
                  bool1 = bool2;
                  paramInt = i;
                  l1 = l2;
                  continue;
                  b(true, null, 0, 0L, false, paramBundle);
                  return;
                  a(false, null, 0, 0L, false, paramBundle);
                  b(false, null, 0, 0L, false, paramBundle);
                  return;
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected abstract void a(boolean paramBoolean1, String paramString, int paramInt, long paramLong, boolean paramBoolean2, Bundle paramBundle);
  
  protected abstract void b(boolean paramBoolean1, String paramString, int paramInt, long paramLong, boolean paramBoolean2, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxProtocol.LastFeedObserver
 * JD-Core Version:    0.7.0.1
 */