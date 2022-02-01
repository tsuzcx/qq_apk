package com.tencent.mobileqq.data.trooptodo;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0xf8e.oidb_0xf8e.InfoValue;

public class TroopToDoBannerModel
{
  private int a = -1;
  private TroopToDoBannerModel.Person b = new TroopToDoBannerModel.Person("", "");
  private String c = "";
  private String d = "";
  @NonNull
  private TroopToDoBannerModel.RawInfo e = new TroopToDoBannerModel.RawInfo();
  
  public static TroopToDoBannerModel a(oidb_0xf8e.InfoValue paramInfoValue, int paramInt)
  {
    TroopToDoBannerModel localTroopToDoBannerModel = new TroopToDoBannerModel();
    localTroopToDoBannerModel.c = paramInfoValue.title.get();
    localTroopToDoBannerModel.b = new TroopToDoBannerModel.Person(String.valueOf(paramInfoValue.uin.get()), paramInfoValue.nickname.get());
    localTroopToDoBannerModel.d = paramInfoValue.icon_url.get();
    TroopToDoBannerModel.RawInfo localRawInfo = localTroopToDoBannerModel.e();
    localRawInfo.a = paramInfoValue.group_code.get();
    localRawInfo.b = paramInfoValue.seq.get();
    localRawInfo.c = paramInfoValue.random.get();
    localRawInfo.d = paramInt;
    localRawInfo.g = paramInfoValue.app_name.get();
    localRawInfo.f = paramInfoValue.msg_type.get();
    localRawInfo.h = paramInfoValue.appid.get();
    paramInfoValue = paramInfoValue.jump_url.get();
    if (TextUtils.isEmpty(paramInfoValue))
    {
      localTroopToDoBannerModel.a = 1;
      return localTroopToDoBannerModel;
    }
    localRawInfo.e = paramInfoValue;
    localTroopToDoBannerModel.a = 2;
    return localTroopToDoBannerModel;
  }
  
  public TroopToDoBannerModel.Person a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public int d()
  {
    return this.a;
  }
  
  @NotNull
  public TroopToDoBannerModel.RawInfo e()
  {
    return this.e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopToDoBannerModel{type=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", person=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", content='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", imageUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", rawInfo=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.trooptodo.TroopToDoBannerModel
 * JD-Core Version:    0.7.0.1
 */