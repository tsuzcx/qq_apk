package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyGetFileListRspBody.FileInfo;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;
import tencent.im.cs.group_file_common.group_file_common.FolderInfo;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileListRspBody.Item;

public final class TroopFileInfo
{
  public int a;
  public long a;
  public final String a;
  public Map<String, TroopFileInfo> a;
  public UUID a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  private int i;
  public String i;
  public transient String j;
  public transient String k;
  public transient String l;
  public String m;
  public String n;
  public String o;
  
  public TroopFileInfo()
  {
    this.jdField_a_of_type_JavaLangString = "TroopFileInfo";
    this.jdField_e_of_type_Int = 7;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_e_of_type_Long = 0L;
    this.jdField_e_of_type_Int = 7;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public TroopFileInfo(cmd0x383.ApplyGetFileListRspBody.FileInfo paramFileInfo)
  {
    this.jdField_a_of_type_JavaLangString = "TroopFileInfo";
    this.jdField_e_of_type_Int = 7;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_e_of_type_Long = 0L;
    this.jdField_e_of_type_Int = 7;
    a(paramFileInfo);
  }
  
  public TroopFileInfo(group_file_common.FolderInfo paramFolderInfo)
  {
    this.jdField_a_of_type_JavaLangString = "TroopFileInfo";
    this.jdField_e_of_type_Int = 7;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_e_of_type_Long = 0L;
    this.jdField_e_of_type_Int = 7;
    a(paramFolderInfo);
  }
  
  public TroopFileInfo(oidb_0x6d8.GetFileListRspBody.Item paramItem)
  {
    this.jdField_a_of_type_JavaLangString = "TroopFileInfo";
    this.jdField_e_of_type_Int = 7;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_e_of_type_Long = 0L;
    this.jdField_e_of_type_Int = 7;
    a(paramItem);
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    String str = TimeFormatterUtils.b(paramContext, paramLong);
    paramContext = str;
    if (str != null)
    {
      int i1 = TimeFormatterUtils.d(paramLong);
      int i2 = str.indexOf(" ");
      paramContext = str;
      if (i2 != -1)
      {
        paramContext = str;
        if (i2 < str.length() - 1)
        {
          if (i1 == 1) {
            return str.substring(i2 + 1);
          }
          str = str.substring(0, i2);
          paramContext = str;
          if (i1 == 5) {
            paramContext = str.substring(2);
          }
        }
      }
    }
    return paramContext;
  }
  
  private String a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, boolean paramBoolean)
  {
    int i4 = 1;
    int i1;
    int i3;
    int i2;
    if (!paramBoolean)
    {
      try
      {
        if ((this.o == null) || (SystemClock.uptimeMillis() - this.jdField_e_of_type_Long > 300000L)) {
          break label315;
        }
        if (this.o.length() > 10) {
          break label278;
        }
        i1 = 1;
      }
      finally
      {
        label93:
        label116:
        String str;
        StringBuilder localStringBuilder;
        break label268;
      }
      i3 = i1;
      if (i2 < this.o.length())
      {
        if (Character.isDigit(this.o.charAt(i2))) {
          break label296;
        }
        i3 = 0;
      }
      if ((i3 != 0) && (SystemClock.uptimeMillis() - this.jdField_e_of_type_Long > 3000L))
      {
        break label315;
        if (i1 != 0)
        {
          str = b();
          paramBaseQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramLong);
          localStringBuilder.append("");
          this.o = ContactUtils.a(paramBaseQQAppInterface, str, localStringBuilder.toString(), 1, 0);
          if (this.o.length() > 10) {
            break label321;
          }
          i1 = i4;
          break label324;
        }
      }
    }
    for (;;)
    {
      i3 = i1;
      if (i2 < this.o.length())
      {
        if (Character.isDigit(this.o.charAt(i2))) {
          break label339;
        }
        i3 = 0;
      }
      label268:
      label278:
      label296:
      label315:
      label321:
      label324:
      do
      {
        if ((TextUtils.isEmpty(this.o)) || (i3 != 0)) {
          this.o = this.jdField_f_of_type_JavaLangString;
        }
        this.jdField_e_of_type_Long = SystemClock.uptimeMillis();
        paramBaseQQAppInterface = this.o;
        return paramBaseQQAppInterface;
        for (;;)
        {
          throw paramBaseQQAppInterface;
        }
        i1 = 0;
        i3 = i1;
        if (i1 == 0) {
          break label93;
        }
        i2 = 0;
        break;
        i2 += 1;
        break;
        i1 = 0;
        break label116;
        i1 = 1;
        break label116;
        i1 = 0;
        i3 = i1;
      } while (i1 == 0);
      i2 = 0;
      continue;
      label339:
      i2 += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String a()
  {
    return TroopFileUtils.a(this.jdField_a_of_type_Long);
  }
  
  public String a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    return ContactUtils.a(paramQQAppInterface, str, localStringBuilder.toString(), 1, 0);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.m = a(BaseApplication.getContext(), this.jdField_b_of_type_Int * 1000L);
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_f_of_type_JavaLangString = a(paramQQAppInterface, paramLong, false);
  }
  
  public void a(TroopFileInfo paramTroopFileInfo)
  {
    if (paramTroopFileInfo != null)
    {
      int i1 = paramTroopFileInfo.jdField_e_of_type_Int;
      if ((i1 != 8) && (i1 != 9))
      {
        if ((i1 == 11) || (i1 == 10) || (i1 == 12))
        {
          paramTroopFileInfo = paramTroopFileInfo.jdField_b_of_type_JavaLangString;
          if (paramTroopFileInfo != null) {
            this.jdField_a_of_type_JavaUtilMap.remove(paramTroopFileInfo);
          }
        }
      }
      else
      {
        String str = paramTroopFileInfo.jdField_b_of_type_JavaLangString;
        if (str != null) {
          this.jdField_a_of_type_JavaUtilMap.put(str, paramTroopFileInfo);
        }
      }
    }
  }
  
  public void a(TroopFileStatusInfo paramTroopFileStatusInfo, QQAppInterface paramQQAppInterface)
  {
    this.j = paramTroopFileStatusInfo.jdField_b_of_type_JavaLangString;
    this.k = paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString;
    this.l = paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString;
    this.jdField_e_of_type_Int = paramTroopFileStatusInfo.jdField_b_of_type_Int;
    this.jdField_i_of_type_JavaLangString = paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString;
    this.jdField_d_of_type_Long = paramTroopFileStatusInfo.jdField_d_of_type_Long;
    this.jdField_f_of_type_Int = paramTroopFileStatusInfo.jdField_c_of_type_Int;
    this.jdField_c_of_type_Boolean = paramTroopFileStatusInfo.jdField_a_of_type_Boolean;
    if (this.jdField_b_of_type_Int == 0)
    {
      this.jdField_b_of_type_Int = paramTroopFileStatusInfo.jdField_d_of_type_Int;
      this.m = a(BaseApplication.getContext(), this.jdField_b_of_type_Int * 1000L);
    }
    if (this.jdField_b_of_type_JavaLangString == null) {
      this.jdField_b_of_type_JavaLangString = paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_g_of_type_JavaLangString == null) {
      this.jdField_g_of_type_JavaLangString = paramTroopFileStatusInfo.jdField_i_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = paramTroopFileStatusInfo.jdField_c_of_type_Long;
    }
    if (this.jdField_c_of_type_JavaLangString == null) {
      this.jdField_c_of_type_JavaLangString = paramTroopFileStatusInfo.jdField_g_of_type_JavaLangString;
    }
    if ((this.jdField_a_of_type_Int == 0) || (TroopFileInfo.FileStatus.a(paramTroopFileStatusInfo.jdField_b_of_type_Int))) {
      this.jdField_a_of_type_Int = paramTroopFileStatusInfo.jdField_h_of_type_Int;
    }
    if ((this.jdField_b_of_type_Long == 0L) && (TroopFileInfo.FileStatus.a(paramTroopFileStatusInfo.jdField_b_of_type_Int))) {}
    try
    {
      this.jdField_b_of_type_Long = Long.parseLong(paramQQAppInterface.getCurrentAccountUin());
      return;
    }
    catch (NumberFormatException paramTroopFileStatusInfo)
    {
      label216:
      break label216;
    }
    QLog.e("TroopFileInfo", 4, "updateItemStatus NumberFormatException");
  }
  
  public void a(cmd0x383.ApplyGetFileListRspBody.FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramFileInfo.str_file_path.get();
    this.jdField_c_of_type_JavaLangString = paramFileInfo.str_file_name.get();
    this.jdField_a_of_type_Long = paramFileInfo.uint64_file_size.get();
    this.jdField_a_of_type_Int = paramFileInfo.uint32_bus_id.get();
    this.jdField_b_of_type_Long = paramFileInfo.uint32_upload_uin.get();
    this.jdField_c_of_type_Long = paramFileInfo.uint64_uploaded_size.get();
    this.jdField_b_of_type_Int = paramFileInfo.uint32_upload_time.get();
    this.jdField_c_of_type_Int = paramFileInfo.uint32_dead_time.get();
    this.jdField_i_of_type_Int = paramFileInfo.uint32_modify_time.get();
    this.jdField_d_of_type_Int = paramFileInfo.uint32_download_times.get();
    this.jdField_f_of_type_JavaLangString = paramFileInfo.str_uploader_name.get();
    this.jdField_d_of_type_JavaLangString = new String(paramFileInfo.bytes_sha.get().toByteArray());
    this.jdField_e_of_type_JavaLangString = HexUtil.bytes2HexStr(paramFileInfo.bytes_md5.get().toByteArray());
    this.n = a(BaseApplication.getContext(), this.jdField_i_of_type_Int * 1000L);
    this.m = a(BaseApplication.getContext(), this.jdField_b_of_type_Int * 1000L);
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void a(group_file_common.FolderInfo paramFolderInfo)
  {
    if (paramFolderInfo == null) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = paramFolderInfo.str_folder_id.get();
    this.jdField_c_of_type_JavaLangString = paramFolderInfo.str_folder_name.get();
    this.jdField_b_of_type_Int = paramFolderInfo.uint32_create_time.get();
    this.jdField_i_of_type_Int = paramFolderInfo.uint32_modify_time.get();
    this.jdField_b_of_type_Long = paramFolderInfo.uint64_create_uin.get();
    this.jdField_g_of_type_JavaLangString = "/";
    this.jdField_h_of_type_Int = paramFolderInfo.uint32_total_file_count.get();
    this.m = a(BaseApplication.getContext(), this.jdField_b_of_type_Int * 1000L);
    this.n = a(BaseApplication.getContext(), this.jdField_i_of_type_Int * 1000L);
  }
  
  public void a(oidb_0x6d8.GetFileListRspBody.Item paramItem)
  {
    if (paramItem == null) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    int i1 = paramItem.uint32_type.get();
    if (i1 != 1)
    {
      if (i1 != 2) {
        return;
      }
      this.jdField_d_of_type_Boolean = true;
      paramItem = (group_file_common.FolderInfo)paramItem.folder_info.get();
      this.jdField_b_of_type_JavaLangString = paramItem.str_folder_id.get();
      this.jdField_c_of_type_JavaLangString = paramItem.str_folder_name.get();
      this.jdField_i_of_type_Int = paramItem.uint32_modify_time.get();
      this.jdField_b_of_type_Int = paramItem.uint32_create_time.get();
      this.jdField_b_of_type_Long = paramItem.uint64_create_uin.get();
      this.jdField_g_of_type_JavaLangString = paramItem.str_parent_folder_id.get();
      this.jdField_h_of_type_Int = paramItem.uint32_total_file_count.get();
      this.m = a(BaseApplication.getContext(), this.jdField_b_of_type_Int * 1000L);
      this.n = a(BaseApplication.getContext(), this.jdField_i_of_type_Int * 1000L);
      return;
    }
    this.jdField_d_of_type_Boolean = false;
    paramItem = (group_file_common.FileInfo)paramItem.file_info.get();
    this.jdField_b_of_type_JavaLangString = paramItem.str_file_id.get();
    this.jdField_c_of_type_JavaLangString = paramItem.str_file_name.get();
    this.jdField_a_of_type_Long = paramItem.uint64_file_size.get();
    this.jdField_a_of_type_Int = paramItem.uint32_bus_id.get();
    this.jdField_b_of_type_Long = paramItem.uint64_uploader_uin.get();
    this.jdField_c_of_type_Long = paramItem.uint64_uploaded_size.get();
    this.jdField_b_of_type_Int = paramItem.uint32_upload_time.get();
    this.jdField_c_of_type_Int = paramItem.uint32_dead_time.get();
    this.jdField_i_of_type_Int = paramItem.uint32_modify_time.get();
    this.jdField_d_of_type_Int = paramItem.uint32_download_times.get();
    this.jdField_f_of_type_JavaLangString = paramItem.str_uploader_name.get();
    this.jdField_d_of_type_JavaLangString = new String(paramItem.bytes_sha.get().toByteArray());
    this.jdField_g_of_type_JavaLangString = paramItem.str_parent_folder_id.get();
    this.m = a(BaseApplication.getContext(), this.jdField_b_of_type_Int * 1000L);
    this.n = a(BaseApplication.getContext(), this.jdField_i_of_type_Int * 1000L);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return (TroopFileUtils.a(paramQQAppInterface, paramLong)) && (this.jdField_d_of_type_Boolean);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    boolean bool1 = paramQQAppInterface.getCurrentAccountUin().equals(b());
    boolean bool2 = TroopFileUtils.a(paramQQAppInterface, paramLong);
    switch (this.jdField_e_of_type_Int)
    {
    case 4: 
    case 5: 
    case 12: 
    default: 
      break;
    case 7: 
      if (this.jdField_d_of_type_Boolean) {
        return bool2;
      }
      if (!bool2) {
        if (!bool1) {
          break label145;
        }
      }
      break;
    case 2: 
    case 3: 
    case 6: 
    case 9: 
    case 10: 
    case 11: 
    case 13: 
      if ((goto 128) && (this.jdField_d_of_type_Boolean)) {
        return bool2;
      }
      break;
    }
    do
    {
      return true;
      if (!paramBoolean) {
        break;
      }
    } while (!this.jdField_d_of_type_Boolean);
    return bool2;
    label145:
    return false;
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  public void b(int paramInt)
  {
    this.jdField_i_of_type_Int = paramInt;
    this.n = a(BaseApplication.getContext(), this.jdField_i_of_type_Int * 1000L);
  }
  
  public void b(TroopFileInfo paramTroopFileInfo)
  {
    if (paramTroopFileInfo == null) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramTroopFileInfo.jdField_b_of_type_JavaLangString;
    this.jdField_g_of_type_JavaLangString = paramTroopFileInfo.jdField_g_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = paramTroopFileInfo.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_Int = paramTroopFileInfo.jdField_a_of_type_Int;
    this.jdField_b_of_type_Long = paramTroopFileInfo.jdField_b_of_type_Long;
    this.jdField_c_of_type_Long = paramTroopFileInfo.jdField_c_of_type_Long;
    this.jdField_a_of_type_Long = paramTroopFileInfo.jdField_a_of_type_Long;
    this.jdField_b_of_type_Int = paramTroopFileInfo.jdField_b_of_type_Int;
    this.jdField_c_of_type_Int = paramTroopFileInfo.jdField_c_of_type_Int;
    this.jdField_i_of_type_Int = paramTroopFileInfo.jdField_i_of_type_Int;
    this.jdField_d_of_type_Int = paramTroopFileInfo.jdField_d_of_type_Int;
    this.jdField_f_of_type_JavaLangString = paramTroopFileInfo.jdField_f_of_type_JavaLangString;
    this.jdField_h_of_type_Int = paramTroopFileInfo.jdField_h_of_type_Int;
    this.jdField_d_of_type_JavaLangString = paramTroopFileInfo.jdField_d_of_type_JavaLangString;
    this.jdField_d_of_type_Boolean = paramTroopFileInfo.jdField_d_of_type_Boolean;
    this.m = paramTroopFileInfo.m;
    this.n = paramTroopFileInfo.n;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    return (TroopFileUtils.a(paramQQAppInterface, paramLong)) && (!this.jdField_d_of_type_Boolean) && (!paramBoolean) && (!TroopFileInfo.FileStatus.a(this.jdField_e_of_type_Int)) && (!TroopFileInfo.FileStatus.b(this.jdField_e_of_type_Int));
  }
  
  public String c()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && ((paramObject instanceof TroopFileInfo)))
    {
      paramObject = (TroopFileInfo)paramObject;
      return this.jdField_a_of_type_JavaUtilUUID.equals(paramObject.jdField_a_of_type_JavaUtilUUID);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopFileInfo{TAG='TroopFileInfo', Id=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilUUID);
    localStringBuilder.append(", str_file_path='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", str_file_name='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uint64_file_size=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", uint32_bus_id=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", uint32_upload_uin=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", uint64_uploaded_size=");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", uint32_upload_time=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", uint32_dead_time=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", uint32_modify_time=");
    localStringBuilder.append(this.jdField_i_of_type_Int);
    localStringBuilder.append(", uint32_download_times=");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(", str_uploader_name='");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", Status=");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(", _sStatus='");
    localStringBuilder.append(this.jdField_h_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ProgressValue=");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append(", ErrorCode=");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append(", LocalFile='");
    localStringBuilder.append(this.jdField_i_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", UploadCreateTime=");
    localStringBuilder.append(this.jdField_g_of_type_Int);
    localStringBuilder.append(", Unread=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", ThumbnailFile_Small='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ThumbnailFile_Large='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", IsGhost=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", IsNewStatus=");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(", NickName='");
    localStringBuilder.append(this.o);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lastNickNameUpdateMS=");
    localStringBuilder.append(this.jdField_e_of_type_Long);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileInfo
 * JD-Core Version:    0.7.0.1
 */