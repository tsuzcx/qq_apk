package com.tencent.mobileqq.pushdialog;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x122.gray_tips_resv.ResvAttr;
import tencent.im.s2c.msgtype0x210.submsgtype0x122.submsgtype0x122.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x122.submsgtype0x122.TemplParam;

public class PushDialogTemplate
  extends Entity
{
  @notColumn
  private static final byte[] KV_SEPARATOR = { 64, 33 };
  @notColumn
  private static final byte[] PARAM_SEPARATOR = { 35, 33 };
  @notColumn
  private static final String TAG = "PushDialogTemplate";
  public long busi_id;
  public long busi_type;
  public int c2c_type;
  public int ctrl_flag;
  public int friend_banned_flag = -1;
  @notColumn
  private List<submsgtype0x122.TemplParam> mParamList;
  public long mUin;
  public byte[] reserv;
  public int service_type;
  public byte[] templ_content;
  public long templ_id;
  public byte[] templ_param;
  public long time;
  
  public PushDialogTemplate() {}
  
  public PushDialogTemplate(submsgtype0x122.MsgBody paramMsgBody, long paramLong1, long paramLong2)
  {
    this.busi_type = paramMsgBody.uint64_busi_type.get();
    this.busi_id = paramMsgBody.uint64_busi_id.get();
    this.ctrl_flag = paramMsgBody.uint32_ctrl_flag.get();
    this.c2c_type = paramMsgBody.uint32_c2c_type.get();
    this.service_type = paramMsgBody.uint32_service_type.get();
    this.templ_id = paramMsgBody.uint64_templ_id.get();
    this.templ_content = paramMsgBody.bytes_content.get().toByteArray();
    this.reserv = paramMsgBody.bytes_pb_reserv.get().toByteArray();
    this.templ_param = transParamListToByteArray(paramMsgBody.rpt_msg_templ_param.get());
    this.mUin = paramLong1;
    this.time = paramLong2;
  }
  
  private static byte[] byteMergerAll(byte[]... paramVarArgs)
  {
    int i = 0;
    int j = 0;
    while (i < paramVarArgs.length)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    byte[] arrayOfByte1 = new byte[j];
    i = 0;
    j = 0;
    while (i < paramVarArgs.length)
    {
      byte[] arrayOfByte2 = paramVarArgs[i];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, arrayOfByte2.length);
      j += arrayOfByte2.length;
      i += 1;
    }
    return arrayOfByte1;
  }
  
  private static boolean isBitChecked(int paramInt1, int paramInt2)
  {
    return (paramInt1 & 1 << paramInt2) == 0;
  }
  
  private static boolean isMatch(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    int i = 0;
    while (i < paramArrayOfByte1.length)
    {
      if (paramArrayOfByte1[i] != paramArrayOfByte2[(paramInt + i)]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static List<byte[]> split(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    int j;
    for (int k = 0; i < paramArrayOfByte2.length; k = j)
    {
      int m = i;
      j = k;
      if (isMatch(paramArrayOfByte1, paramArrayOfByte2, i))
      {
        localLinkedList.add(Arrays.copyOfRange(paramArrayOfByte2, k, i));
        m = i + paramArrayOfByte1.length;
        j = m;
      }
      i = m + 1;
    }
    localLinkedList.add(Arrays.copyOfRange(paramArrayOfByte2, k, paramArrayOfByte2.length));
    return localLinkedList;
  }
  
  private List<submsgtype0x122.TemplParam> transByteArrayToParamList(byte[] paramArrayOfByte)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayOfByte = split(PARAM_SEPARATOR, paramArrayOfByte);
    int i = 0;
    while (i < paramArrayOfByte.size())
    {
      submsgtype0x122.TemplParam localTemplParam = new submsgtype0x122.TemplParam();
      Object localObject = (byte[])paramArrayOfByte.get(i);
      int j = localObject.length;
      byte[] arrayOfByte = KV_SEPARATOR;
      if (j > arrayOfByte.length)
      {
        localObject = split(arrayOfByte, (byte[])localObject);
        localTemplParam.bytes_name.set(ByteStringMicro.copyFrom((byte[])((List)localObject).get(0)));
        localTemplParam.bytes_value.set(ByteStringMicro.copyFrom((byte[])((List)localObject).get(1)));
        localArrayList.add(localTemplParam);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private byte[] transParamListToByteArray(List<submsgtype0x122.TemplParam> paramList)
  {
    byte[] arrayOfByte = null;
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (submsgtype0x122.TemplParam)paramList.get(i);
      arrayOfByte = ((submsgtype0x122.TemplParam)localObject).bytes_name.get().toByteArray();
      localObject = ((submsgtype0x122.TemplParam)localObject).bytes_value.get().toByteArray();
      arrayOfByte = byteMergerAll(new byte[][] { arrayOfByte, KV_SEPARATOR, localObject, PARAM_SEPARATOR });
      i += 1;
    }
    return arrayOfByte;
  }
  
  public List<submsgtype0x122.TemplParam> getParamList()
  {
    List localList = this.mParamList;
    if (localList != null) {
      return localList;
    }
    return transByteArrayToParamList(this.templ_param);
  }
  
  public boolean isFriendBanned()
  {
    int i = this.friend_banned_flag;
    if (i >= 0) {
      return i == 1;
    }
    if (this.reserv != null)
    {
      gray_tips_resv.ResvAttr localResvAttr1;
      gray_tips_resv.ResvAttr localResvAttr2;
      try
      {
        localResvAttr1 = new gray_tips_resv.ResvAttr();
        try
        {
          localResvAttr1.mergeFrom(this.reserv);
          boolean bool = localResvAttr1.uint32_friend_banned_flag.has();
          localResvAttr2 = localResvAttr1;
          if (bool) {
            break label91;
          }
          return false;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1) {}
        localResvAttr2 = localResvAttr1;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        localResvAttr1 = null;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("PushDialogTemplate", 0, localInvalidProtocolBufferMicroException2.getMessage());
        localResvAttr2 = localResvAttr1;
      }
      label91:
      i = localResvAttr2.uint32_friend_banned_flag.get();
      this.friend_banned_flag = i;
      return i == 1;
    }
    return false;
  }
  
  public boolean isShowInMessageHistory()
  {
    return isBitChecked(this.ctrl_flag, 2);
  }
  
  public boolean isShowInMessageList()
  {
    return isBitChecked(this.ctrl_flag, 0);
  }
  
  public boolean isStoreInDb()
  {
    return isBitChecked(this.ctrl_flag, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.PushDialogTemplate
 * JD-Core Version:    0.7.0.1
 */