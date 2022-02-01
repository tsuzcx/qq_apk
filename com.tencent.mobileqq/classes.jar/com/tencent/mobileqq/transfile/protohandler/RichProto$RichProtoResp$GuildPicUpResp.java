package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class RichProto$RichProtoResp$GuildPicUpResp
  extends RichProto.RichProtoResp.RespCommon
{
  public int blockSize;
  public long groupFileID;
  public boolean isExist;
  public boolean isUseBdh = false;
  public byte[] mDownLoadIndex;
  public ArrayList<ServerAddr> mIpList = new ArrayList();
  public String mUkey;
  public boolean networkChange = false;
  public long startOffset = 0L;
  public int transferedSize;
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("GuildPicUpResp{");
    localStringBuilder1.append(super.toString());
    localStringBuilder1.append("isExist");
    localStringBuilder1.append(this.isExist);
    localStringBuilder1.append(", mIpList=");
    localStringBuilder1.append(this.mIpList);
    localStringBuilder1.append(", groupFileID=");
    localStringBuilder1.append(this.groupFileID);
    localStringBuilder1.append(", mUkey='");
    localStringBuilder1.append(this.mUkey);
    localStringBuilder1.append(", blockSize=");
    localStringBuilder1.append(this.blockSize);
    localStringBuilder1.append(", transferedSize=");
    localStringBuilder1.append(this.transferedSize);
    localStringBuilder1.append(", networkChange=");
    localStringBuilder1.append(this.networkChange);
    localStringBuilder1.append(", isUseBdh=");
    localStringBuilder1.append(this.isUseBdh);
    localStringBuilder1.append(", startOffset=");
    localStringBuilder1.append(this.startOffset);
    localStringBuilder1.append(", mDownLoadIndex=");
    try
    {
      if (this.mDownLoadIndex == null)
      {
        localStringBuilder1.append("null");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("mDownLoadIndex");
          localStringBuilder2.append(null);
          QLog.i("GuildPicUpResp", 1, localStringBuilder2.toString());
        }
      }
      else
      {
        localStringBuilder1.append(new String(this.mDownLoadIndex, "utf8"));
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GuildPicUpResp
 * JD-Core Version:    0.7.0.1
 */