package com.tencent.mobileqq.troop.filemanager.data;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyFileSearchRspBody.Item;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyGetFileListRspBody.FileInfo;

public class TroopFileSearchItemData
{
  public long a = 0L;
  public String b = null;
  public long c = 0L;
  public String d = null;
  public ArrayList<String> e = null;
  public long f = 0L;
  public String g = null;
  public String h = null;
  public TroopFileInfo i = null;
  
  public TroopFileSearchItemData(QQAppInterface paramQQAppInterface, cmd0x383.ApplyFileSearchRspBody.Item paramItem)
  {
    if (paramItem == null) {
      return;
    }
    this.a = paramItem.uint64_group_code.get();
    this.b = paramItem.bytes_group_name.get().toStringUtf8();
    this.c = paramItem.uint64_upload_uin.get();
    this.d = paramItem.bytes_uploader_nick_name.get().toStringUtf8();
    this.e = new ArrayList();
    List localList = paramItem.bytes_match_word.get();
    if (localList != null)
    {
      int j = 0;
      while (j < localList.size())
      {
        this.e.add(((ByteStringMicro)localList.get(j)).toStringUtf8());
        j += 1;
      }
    }
    this.f = paramItem.uint64_match_uin.get();
    if (this.f > 0L)
    {
      paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(String.valueOf(this.f));
      if (paramQQAppInterface != null)
      {
        this.g = paramQQAppInterface.name;
        this.h = paramQQAppInterface.remark;
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("TroopFileSearchItemData matchUin:");
        paramQQAppInterface.append(this.f);
        paramQQAppInterface.append(", name:");
        paramQQAppInterface.append(this.g);
        paramQQAppInterface.append(", remark = ");
        paramQQAppInterface.append(this.h);
        QLog.d("TroopFileSearchItemData<QFile>", 2, paramQQAppInterface.toString());
      }
    }
    this.i = new TroopFileInfo((cmd0x383.ApplyGetFileListRspBody.FileInfo)paramItem.file_info.get());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("groupCode = ");
    localStringBuilder2.append(this.a);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", groupName = ");
    localStringBuilder2.append(this.b);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", uploaderUin = ");
    localStringBuilder2.append(this.c);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", uploaderNickName = ");
    localStringBuilder2.append(this.d);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", matchUin = ");
    localStringBuilder2.append(this.f);
    localStringBuilder1.append(localStringBuilder2.toString());
    if (this.e != null)
    {
      localStringBuilder1.append(", matchWord: = ");
      int k = this.e.size();
      int j = 0;
      while (j < k)
      {
        if (j == k - 1)
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append((String)this.e.get(j));
          localStringBuilder2.append(", ");
          localStringBuilder1.append(localStringBuilder2.toString());
        }
        else
        {
          localStringBuilder1.append((String)this.e.get(j));
          localStringBuilder1.append("、 ");
        }
        j += 1;
      }
    }
    if (this.i != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", fileInfo = ");
      localStringBuilder2.append(this.i.toString());
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchItemData
 * JD-Core Version:    0.7.0.1
 */