package com.tencent.mobileqq.kandian.repo.video.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.VideoColumnInfo;

public class VideoColumnInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VideoColumnInfo> CREATOR = new VideoColumnInfo.1();
  public static final String a = "VideoColumnInfo";
  public int a;
  public long a;
  public UrlJumpInfo a;
  public boolean a;
  public int b;
  public UrlJumpInfo b;
  public String b;
  public int c;
  public UrlJumpInfo c;
  public String c;
  public int d;
  public UrlJumpInfo d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  
  public VideoColumnInfo() {}
  
  protected VideoColumnInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
    this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
    this.jdField_c_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
    this.jdField_d_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_Int = paramParcel.readInt();
  }
  
  public static VideoColumnInfo a(articlesummary.VideoColumnInfo paramVideoColumnInfo)
  {
    if ((paramVideoColumnInfo != null) && (paramVideoColumnInfo.has()) && (paramVideoColumnInfo.get() != null))
    {
      VideoColumnInfo localVideoColumnInfo = new VideoColumnInfo();
      localVideoColumnInfo.jdField_a_of_type_Int = paramVideoColumnInfo.uint32_column_id.get();
      localVideoColumnInfo.jdField_b_of_type_JavaLangString = RIJPBFieldUtils.b(paramVideoColumnInfo.bytes_column_name);
      localVideoColumnInfo.jdField_c_of_type_JavaLangString = RIJPBFieldUtils.b(paramVideoColumnInfo.bytes_column_icon_url);
      localVideoColumnInfo.jdField_a_of_type_Long = paramVideoColumnInfo.uint64_last_update_time.get();
      localVideoColumnInfo.jdField_b_of_type_Int = paramVideoColumnInfo.uint32_video_count.get();
      localVideoColumnInfo.jdField_c_of_type_Int = paramVideoColumnInfo.uint32_subscribe_count.get();
      boolean bool;
      if (paramVideoColumnInfo.uint32_is_subscribed.get() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      localVideoColumnInfo.jdField_a_of_type_Boolean = bool;
      localVideoColumnInfo.jdField_d_of_type_JavaLangString = RIJPBFieldUtils.b(paramVideoColumnInfo.bytes_column_card_bg_url);
      localVideoColumnInfo.jdField_e_of_type_JavaLangString = RIJPBFieldUtils.b(paramVideoColumnInfo.bytes_column_card_bg_color);
      localVideoColumnInfo.jdField_f_of_type_JavaLangString = RIJPBFieldUtils.b(paramVideoColumnInfo.bytes_column_card_icon_url);
      localVideoColumnInfo.g = RIJPBFieldUtils.b(paramVideoColumnInfo.bytes_app_name);
      localVideoColumnInfo.h = RIJPBFieldUtils.b(paramVideoColumnInfo.bytes_app_icon_url);
      localVideoColumnInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = UrlJumpInfo.a(paramVideoColumnInfo.default_jump_info);
      localVideoColumnInfo.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = UrlJumpInfo.a(paramVideoColumnInfo.video_jump_info);
      localVideoColumnInfo.jdField_c_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = UrlJumpInfo.a(paramVideoColumnInfo.subscribe_jump_info);
      localVideoColumnInfo.jdField_d_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = UrlJumpInfo.a(paramVideoColumnInfo.app_jump_info);
      localVideoColumnInfo.jdField_d_of_type_Int = paramVideoColumnInfo.uin32_column_card_bg_style.get();
      localVideoColumnInfo.i = RIJPBFieldUtils.b(paramVideoColumnInfo.bytes_from_txt);
      localVideoColumnInfo.j = RIJPBFieldUtils.b(paramVideoColumnInfo.bytes_column_name_color);
      return localVideoColumnInfo;
    }
    return null;
  }
  
  public static List<VideoColumnInfo> a(@NonNull PBRepeatMessageField<articlesummary.VideoColumnInfo> paramPBRepeatMessageField)
  {
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    while (k < paramPBRepeatMessageField.size())
    {
      VideoColumnInfo localVideoColumnInfo = a((articlesummary.VideoColumnInfo)paramPBRepeatMessageField.get(k));
      if (localVideoColumnInfo != null) {
        localArrayList.add(localVideoColumnInfo);
      }
      if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("convertArticleInfo(): convertPBToInfo Muilt:");
        localStringBuilder.append(localVideoColumnInfo);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      k += 1;
    }
    return localArrayList;
  }
  
  public articlesummary.VideoColumnInfo a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public byte[] a()
  {
    return a().toByteArray();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoColumnInfo{columnId=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", columnName='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", columnIconUrl=");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lastUpdateTime=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoCount=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append(", subscribeCount='");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isSubscribed='");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cardBgUrl=");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cardBgColor=");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cardIconUrl=");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appName=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", appIconUrl='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", defaultJumpInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo);
    localStringBuilder.append(", videoJumpInfo=");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo);
    localStringBuilder.append(", subscribeJumpInfo=");
    localStringBuilder.append(this.jdField_c_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo);
    localStringBuilder.append(", appJumpInfo='");
    localStringBuilder.append(this.jdField_d_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cardBgStyle='");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fromText='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", columnNameColor='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", columnStyle='");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo, paramInt);
    paramParcel.writeParcelable(this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo, paramInt);
    paramParcel.writeParcelable(this.jdField_c_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo, paramInt);
    paramParcel.writeParcelable(this.jdField_d_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo, paramInt);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo
 * JD-Core Version:    0.7.0.1
 */