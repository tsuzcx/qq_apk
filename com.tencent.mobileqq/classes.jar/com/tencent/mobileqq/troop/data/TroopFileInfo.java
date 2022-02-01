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
  public boolean A;
  public boolean B;
  public int C;
  public Map<String, TroopFileInfo> D = new ConcurrentHashMap();
  public String E;
  public String F;
  public String G;
  public long H = 0L;
  private int I;
  public final String a = "TroopFileInfo";
  public UUID b;
  public String c;
  public String d;
  public long e;
  public int f;
  public long g;
  public long h;
  public int i;
  public int j;
  public int k;
  public String l;
  public String m;
  public String n;
  public String o;
  public int p = 7;
  public String q;
  public long r;
  public int s;
  public String t;
  public int u;
  public boolean v;
  public transient String w;
  public transient String x;
  public transient String y;
  public boolean z;
  
  public TroopFileInfo()
  {
    this.z = true;
  }
  
  public TroopFileInfo(cmd0x383.ApplyGetFileListRspBody.FileInfo paramFileInfo)
  {
    a(paramFileInfo);
  }
  
  public TroopFileInfo(group_file_common.FolderInfo paramFolderInfo)
  {
    a(paramFolderInfo);
  }
  
  public TroopFileInfo(oidb_0x6d8.GetFileListRspBody.Item paramItem)
  {
    a(paramItem);
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    String str = TimeFormatterUtils.c(paramContext, paramLong);
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
        if ((this.G == null) || (SystemClock.uptimeMillis() - this.H > 300000L)) {
          break label315;
        }
        if (this.G.length() > 10) {
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
      if (i2 < this.G.length())
      {
        if (Character.isDigit(this.G.charAt(i2))) {
          break label296;
        }
        i3 = 0;
      }
      if ((i3 != 0) && (SystemClock.uptimeMillis() - this.H > 3000L))
      {
        break label315;
        if (i1 != 0)
        {
          str = b();
          paramBaseQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramLong);
          localStringBuilder.append("");
          this.G = ContactUtils.a(paramBaseQQAppInterface, str, localStringBuilder.toString(), 1, 0);
          if (this.G.length() > 10) {
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
      if (i2 < this.G.length())
      {
        if (Character.isDigit(this.G.charAt(i2))) {
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
        if ((TextUtils.isEmpty(this.G)) || (i3 != 0)) {
          this.G = this.n;
        }
        this.H = SystemClock.uptimeMillis();
        paramBaseQQAppInterface = this.G;
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
  
  public String a()
  {
    return TroopFileUtils.a(this.e);
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
    this.E = a(BaseApplication.getContext(), this.i * 1000L);
  }
  
  public void a(TroopFileInfo paramTroopFileInfo)
  {
    if (paramTroopFileInfo != null)
    {
      int i1 = paramTroopFileInfo.p;
      if ((i1 != 8) && (i1 != 9))
      {
        if ((i1 == 11) || (i1 == 10) || (i1 == 12))
        {
          paramTroopFileInfo = paramTroopFileInfo.c;
          if (paramTroopFileInfo != null) {
            this.D.remove(paramTroopFileInfo);
          }
        }
      }
      else
      {
        String str = paramTroopFileInfo.c;
        if (str != null) {
          this.D.put(str, paramTroopFileInfo);
        }
      }
    }
  }
  
  public void a(TroopFileStatusInfo paramTroopFileStatusInfo, QQAppInterface paramQQAppInterface)
  {
    this.w = paramTroopFileStatusInfo.l;
    this.x = paramTroopFileStatusInfo.m;
    this.y = paramTroopFileStatusInfo.n;
    this.p = paramTroopFileStatusInfo.e;
    this.t = paramTroopFileStatusInfo.k;
    this.r = paramTroopFileStatusInfo.j;
    this.s = paramTroopFileStatusInfo.g;
    this.A = paramTroopFileStatusInfo.f;
    if (this.i == 0)
    {
      this.i = paramTroopFileStatusInfo.h;
      this.E = a(BaseApplication.getContext(), this.i * 1000L);
    }
    if (this.c == null) {
      this.c = paramTroopFileStatusInfo.r;
    }
    if (this.o == null) {
      this.o = paramTroopFileStatusInfo.x;
    }
    if (this.e == 0L) {
      this.e = paramTroopFileStatusInfo.i;
    }
    if (this.d == null) {
      this.d = paramTroopFileStatusInfo.t;
    }
    if ((this.f == 0) || (TroopFileInfo.FileStatus.a(paramTroopFileStatusInfo.e))) {
      this.f = paramTroopFileStatusInfo.u;
    }
    if ((this.g == 0L) && (TroopFileInfo.FileStatus.a(paramTroopFileStatusInfo.e))) {}
    try
    {
      this.g = Long.parseLong(paramQQAppInterface.getCurrentAccountUin());
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
    this.z = false;
    this.c = paramFileInfo.str_file_path.get();
    this.d = paramFileInfo.str_file_name.get();
    this.e = paramFileInfo.uint64_file_size.get();
    this.f = paramFileInfo.uint32_bus_id.get();
    this.g = paramFileInfo.uint32_upload_uin.get();
    this.h = paramFileInfo.uint64_uploaded_size.get();
    this.i = paramFileInfo.uint32_upload_time.get();
    this.j = paramFileInfo.uint32_dead_time.get();
    this.I = paramFileInfo.uint32_modify_time.get();
    this.k = paramFileInfo.uint32_download_times.get();
    this.n = paramFileInfo.str_uploader_name.get();
    this.l = new String(paramFileInfo.bytes_sha.get().toByteArray());
    this.m = HexUtil.bytes2HexStr(paramFileInfo.bytes_md5.get().toByteArray());
    this.F = a(BaseApplication.getContext(), this.I * 1000L);
    this.E = a(BaseApplication.getContext(), this.i * 1000L);
    this.B = false;
  }
  
  public void a(group_file_common.FolderInfo paramFolderInfo)
  {
    if (paramFolderInfo == null) {
      return;
    }
    this.B = true;
    this.c = paramFolderInfo.str_folder_id.get();
    this.d = paramFolderInfo.str_folder_name.get();
    this.i = paramFolderInfo.uint32_create_time.get();
    this.I = paramFolderInfo.uint32_modify_time.get();
    this.g = paramFolderInfo.uint64_create_uin.get();
    this.o = "/";
    this.C = paramFolderInfo.uint32_total_file_count.get();
    this.E = a(BaseApplication.getContext(), this.i * 1000L);
    this.F = a(BaseApplication.getContext(), this.I * 1000L);
  }
  
  public void a(oidb_0x6d8.GetFileListRspBody.Item paramItem)
  {
    if (paramItem == null) {
      return;
    }
    this.z = false;
    int i1 = paramItem.uint32_type.get();
    if (i1 != 1)
    {
      if (i1 != 2) {
        return;
      }
      this.B = true;
      paramItem = (group_file_common.FolderInfo)paramItem.folder_info.get();
      this.c = paramItem.str_folder_id.get();
      this.d = paramItem.str_folder_name.get();
      this.I = paramItem.uint32_modify_time.get();
      this.i = paramItem.uint32_create_time.get();
      this.g = paramItem.uint64_create_uin.get();
      this.o = paramItem.str_parent_folder_id.get();
      this.C = paramItem.uint32_total_file_count.get();
      this.E = a(BaseApplication.getContext(), this.i * 1000L);
      this.F = a(BaseApplication.getContext(), this.I * 1000L);
      return;
    }
    this.B = false;
    paramItem = (group_file_common.FileInfo)paramItem.file_info.get();
    this.c = paramItem.str_file_id.get();
    this.d = paramItem.str_file_name.get();
    this.e = paramItem.uint64_file_size.get();
    this.f = paramItem.uint32_bus_id.get();
    this.g = paramItem.uint64_uploader_uin.get();
    this.h = paramItem.uint64_uploaded_size.get();
    this.i = paramItem.uint32_upload_time.get();
    this.j = paramItem.uint32_dead_time.get();
    this.I = paramItem.uint32_modify_time.get();
    this.k = paramItem.uint32_download_times.get();
    this.n = paramItem.str_uploader_name.get();
    this.l = new String(paramItem.bytes_sha.get().toByteArray());
    this.o = paramItem.str_parent_folder_id.get();
    this.E = a(BaseApplication.getContext(), this.i * 1000L);
    this.F = a(BaseApplication.getContext(), this.I * 1000L);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return (TroopFileUtils.a(paramQQAppInterface, paramLong)) && (this.B);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    boolean bool1 = paramQQAppInterface.getCurrentAccountUin().equals(b());
    boolean bool2 = TroopFileUtils.a(paramQQAppInterface, paramLong);
    switch (this.p)
    {
    case 4: 
    case 5: 
    case 12: 
    default: 
      break;
    case 7: 
      if (this.B) {
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
      if ((goto 128) && (this.B)) {
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
    } while (!this.B);
    return bool2;
    label145:
    return false;
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.g);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  public String b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    return ContactUtils.a(paramQQAppInterface, str, localStringBuilder.toString(), 1, 0);
  }
  
  public void b(int paramInt)
  {
    this.I = paramInt;
    this.F = a(BaseApplication.getContext(), this.I * 1000L);
  }
  
  public void b(TroopFileInfo paramTroopFileInfo)
  {
    if (paramTroopFileInfo == null) {
      return;
    }
    this.z = false;
    this.c = paramTroopFileInfo.c;
    this.o = paramTroopFileInfo.o;
    this.d = paramTroopFileInfo.d;
    this.f = paramTroopFileInfo.f;
    this.g = paramTroopFileInfo.g;
    this.h = paramTroopFileInfo.h;
    this.e = paramTroopFileInfo.e;
    this.i = paramTroopFileInfo.i;
    this.j = paramTroopFileInfo.j;
    this.I = paramTroopFileInfo.I;
    this.k = paramTroopFileInfo.k;
    this.n = paramTroopFileInfo.n;
    this.C = paramTroopFileInfo.C;
    this.l = paramTroopFileInfo.l;
    this.B = paramTroopFileInfo.B;
    this.E = paramTroopFileInfo.E;
    this.F = paramTroopFileInfo.F;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    return (TroopFileUtils.a(paramQQAppInterface, paramLong)) && (!this.B) && (!paramBoolean) && (!TroopFileInfo.FileStatus.a(this.p)) && (!TroopFileInfo.FileStatus.b(this.p));
  }
  
  public String c()
  {
    return this.n;
  }
  
  public void c(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.n = a(paramQQAppInterface, paramLong, false);
  }
  
  public int d()
  {
    return this.i;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && ((paramObject instanceof TroopFileInfo)))
    {
      paramObject = (TroopFileInfo)paramObject;
      return this.b.equals(paramObject.b);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopFileInfo{TAG='TroopFileInfo', Id=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", str_file_path='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", str_file_name='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uint64_file_size=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", uint32_bus_id=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", uint32_upload_uin=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", uint64_uploaded_size=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", uint32_upload_time=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", uint32_dead_time=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", uint32_modify_time=");
    localStringBuilder.append(this.I);
    localStringBuilder.append(", uint32_download_times=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", str_uploader_name='");
    localStringBuilder.append(this.n);
    localStringBuilder.append('\'');
    localStringBuilder.append(", Status=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", _sStatus='");
    localStringBuilder.append(this.q);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ProgressValue=");
    localStringBuilder.append(this.r);
    localStringBuilder.append(", ErrorCode=");
    localStringBuilder.append(this.s);
    localStringBuilder.append(", LocalFile='");
    localStringBuilder.append(this.t);
    localStringBuilder.append('\'');
    localStringBuilder.append(", UploadCreateTime=");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", Unread=");
    localStringBuilder.append(this.v);
    localStringBuilder.append(", ThumbnailFile_Small='");
    localStringBuilder.append(this.w);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ThumbnailFile_Large='");
    localStringBuilder.append(this.x);
    localStringBuilder.append('\'');
    localStringBuilder.append(", IsGhost=");
    localStringBuilder.append(this.z);
    localStringBuilder.append(", IsNewStatus=");
    localStringBuilder.append(this.A);
    localStringBuilder.append(", NickName='");
    localStringBuilder.append(this.G);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lastNickNameUpdateMS=");
    localStringBuilder.append(this.H);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileInfo
 * JD-Core Version:    0.7.0.1
 */