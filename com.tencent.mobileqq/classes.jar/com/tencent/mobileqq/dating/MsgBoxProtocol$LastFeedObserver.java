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
  protected abstract void a(boolean paramBoolean1, String paramString, int paramInt, long paramLong, boolean paramBoolean2, Bundle paramBundle);
  
  protected abstract void b(boolean paramBoolean1, String paramString, int paramInt, long paramLong, boolean paramBoolean2, Bundle paramBundle);
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("UnReadFeedObserver, errorCode=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("Q.msg_box.protocol", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 0)
    {
      localObject = new oidb_0x877.RspBody();
      try
      {
        ((oidb_0x877.RspBody)localObject).mergeFrom(paramArrayOfByte);
        long l;
        boolean bool;
        if (((oidb_0x877.RspBody)localObject).interact_info.has())
        {
          paramArrayOfByte = new StringBuilder();
          if (((oidb_0x877.RspBody)localObject).interact_info.uint32_interact_flag.has())
          {
            if (((oidb_0x877.RspBody)localObject).interact_info.uint32_interact_flag.get() == 0)
            {
              if (((oidb_0x877.RspBody)localObject).interact_info.interact_word.has())
              {
                if (((oidb_0x877.RspBody)localObject).interact_info.interact_word.bytes_from_user.has()) {
                  paramArrayOfByte.append(((oidb_0x877.RspBody)localObject).interact_info.interact_word.bytes_from_user.get().toStringUtf8());
                }
                if (((oidb_0x877.RspBody)localObject).interact_info.interact_word.bytes_buluo_word.has()) {
                  paramArrayOfByte.append(MsgBoxUtil.b(MsgBoxUtil.a(((oidb_0x877.RspBody)localObject).interact_info.interact_word.bytes_buluo_word.get().toStringUtf8())));
                } else if (((oidb_0x877.RspBody)localObject).interact_info.interact_word.rich_fresh_word.has()) {
                  paramArrayOfByte.append(MsgBoxUtil.a((appoint_define.RichText)((oidb_0x877.RspBody)localObject).interact_info.interact_word.rich_fresh_word.get(), 14));
                } else {
                  paramArrayOfByte.append(((oidb_0x877.RspBody)localObject).interact_info.interact_word.bytes_plain_text.get().toStringUtf8());
                }
              }
              else if (QLog.isColorLevel())
              {
                QLog.i("Q.msg_box.protocol", 2, "resp.interact_info.interact_word.has() == false");
              }
              paramInt = ((oidb_0x877.RspBody)localObject).interact_info.uint32_interact_count.get();
              l = ((oidb_0x877.RspBody)localObject).interact_info.uint64_interact_info_time.get();
              bool = true;
              break label354;
            }
            bool = false;
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.msg_box.protocol", 2, "uint32_interact_flag.has()= false");
            }
            bool = true;
          }
          l = 0L;
          paramInt = 0;
          label354:
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("interact_info|needShow=");
            localStringBuilder.append(bool);
            localStringBuilder.append(",rawcontext=");
            localStringBuilder.append(paramArrayOfByte.toString());
            localStringBuilder.append(",unReadCount=");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(",timeStamp=");
            localStringBuilder.append(l);
            QLog.i("Q.msg_box.protocol", 2, localStringBuilder.toString());
          }
          if ((!TextUtils.isEmpty(paramArrayOfByte.toString())) && (l != 0L)) {
            break label471;
          }
          bool = false;
          label471:
          a(true, paramArrayOfByte.toString(), paramInt, l, bool, paramBundle);
        }
        else
        {
          a(true, null, 0, 0L, false, paramBundle);
        }
        if (((oidb_0x877.RspBody)localObject).follow_info.has())
        {
          paramArrayOfByte = new StringBuilder();
          if (((oidb_0x877.RspBody)localObject).follow_info.uint32_follow_flag.has())
          {
            if (((oidb_0x877.RspBody)localObject).follow_info.uint32_follow_flag.get() == 0)
            {
              if (((oidb_0x877.RspBody)localObject).follow_info.follow_word.has())
              {
                if (((oidb_0x877.RspBody)localObject).follow_info.follow_word.bytes_from_user.has()) {
                  paramArrayOfByte.append(((oidb_0x877.RspBody)localObject).follow_info.follow_word.bytes_from_user.get().toStringUtf8());
                }
                if (((oidb_0x877.RspBody)localObject).follow_info.follow_word.bytes_buluo_word.has()) {
                  paramArrayOfByte.append(MsgBoxUtil.b(MsgBoxUtil.a(((oidb_0x877.RspBody)localObject).interact_info.interact_word.bytes_buluo_word.get().toStringUtf8())));
                } else if (((oidb_0x877.RspBody)localObject).follow_info.follow_word.rich_fresh_word.has()) {
                  paramArrayOfByte.append(MsgBoxUtil.a((appoint_define.RichText)((oidb_0x877.RspBody)localObject).follow_info.follow_word.rich_fresh_word.get(), 14));
                } else {
                  paramArrayOfByte.append(((oidb_0x877.RspBody)localObject).follow_info.follow_word.bytes_plain_text.get().toStringUtf8());
                }
              }
              else if (QLog.isColorLevel())
              {
                QLog.i("Q.msg_box.protocol", 2, "resp.follow_info.follow_word.has() == false");
              }
              paramInt = ((oidb_0x877.RspBody)localObject).follow_info.uint32_follow_count.get();
              l = ((oidb_0x877.RspBody)localObject).follow_info.uint64_follow_info_time.get();
              bool = true;
              break label792;
            }
            bool = false;
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.msg_box.protocol", 2, "uint32_follow_flag.has()= false");
            }
            bool = true;
          }
          l = 0L;
          paramInt = 0;
          label792:
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("follow_info|needShow=");
            ((StringBuilder)localObject).append(bool);
            ((StringBuilder)localObject).append(",rawcontext=");
            ((StringBuilder)localObject).append(paramArrayOfByte.toString());
            ((StringBuilder)localObject).append(",unReadCount=");
            ((StringBuilder)localObject).append(paramInt);
            ((StringBuilder)localObject).append(",timeStamp=");
            ((StringBuilder)localObject).append(l);
            QLog.i("Q.msg_box.protocol", 2, ((StringBuilder)localObject).toString());
          }
          if ((!TextUtils.isEmpty(paramArrayOfByte.toString())) && (l != 0L)) {
            break label909;
          }
          bool = false;
          label909:
          b(true, paramArrayOfByte.toString(), paramInt, l, bool, paramBundle);
          return;
        }
        b(true, null, 0, 0L, false, paramBundle);
        return;
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
    }
    a(false, null, 0, 0L, false, paramBundle);
    b(false, null, 0, 0L, false, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxProtocol.LastFeedObserver
 * JD-Core Version:    0.7.0.1
 */