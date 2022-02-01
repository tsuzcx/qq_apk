package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.List;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyFileSearchRspBody.Item;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyGetFileListRspBody.FileInfo;

public class TroopFileSearchByTypeItemData
{
  public long a;
  public TroopFileInfo a;
  public String a;
  public ArrayList<String> a;
  public long b;
  public String b;
  public long c;
  public String c;
  public String d = null;
  
  public TroopFileSearchByTypeItemData(QQAppInterface paramQQAppInterface, cmd0x383.ApplyFileSearchRspBody.Item paramItem)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo = null;
    if (paramItem == null) {
      return;
    }
    this.jdField_a_of_type_Long = paramItem.uint64_group_code.get();
    this.jdField_a_of_type_JavaLangString = paramItem.bytes_group_name.get().toStringUtf8();
    this.jdField_b_of_type_Long = paramItem.uint64_upload_uin.get();
    this.jdField_b_of_type_JavaLangString = paramItem.bytes_uploader_nick_name.get().toStringUtf8();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    List localList = paramItem.bytes_match_word.get();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(((ByteStringMicro)localList.get(i)).toStringUtf8());
        i += 1;
      }
    }
    this.jdField_c_of_type_Long = paramItem.uint64_match_uin.get();
    if (this.jdField_c_of_type_Long > 0L)
    {
      paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(String.valueOf(this.jdField_c_of_type_Long));
      if (paramQQAppInterface != null)
      {
        this.jdField_c_of_type_JavaLangString = paramQQAppInterface.name;
        this.d = paramQQAppInterface.remark;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo = new TroopFileInfo((cmd0x383.ApplyGetFileListRspBody.FileInfo)paramItem.file_info.get());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("groupCode = " + this.jdField_a_of_type_Long);
    localStringBuilder.append(", groupName = " + this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", uploaderUin = " + this.jdField_b_of_type_Long);
    localStringBuilder.append(", uploaderNickName = " + this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", matchUin = " + this.jdField_c_of_type_Long);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localStringBuilder.append(", matchWord: = ");
      int j = this.jdField_a_of_type_JavaUtilArrayList.size();
      int i = 0;
      if (i < j)
      {
        if (i == j - 1) {
          localStringBuilder.append((String)this.jdField_a_of_type_JavaUtilArrayList.get(i) + ", ");
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder.append((String)this.jdField_a_of_type_JavaUtilArrayList.get(i)).append("、 ");
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo != null) {
      localStringBuilder.append(", fileInfo = " + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileSearchByTypeItemData
 * JD-Core Version:    0.7.0.1
 */