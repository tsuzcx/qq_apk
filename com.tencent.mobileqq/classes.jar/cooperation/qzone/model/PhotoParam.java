package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bnam;
import java.util.HashMap;
import java.util.Map;

public class PhotoParam
  implements Parcelable
{
  public static final Parcelable.Creator<PhotoParam> CREATOR = new bnam();
  public int a;
  public long a;
  public String a;
  public Map<Integer, String> a;
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
  public boolean e;
  public int f;
  public long f;
  public String f;
  public boolean f;
  public int g;
  public String g;
  public boolean g;
  public int h;
  public String h;
  public boolean h;
  public int i;
  public String i;
  public boolean i;
  public int j;
  public String j;
  public boolean j;
  public int k;
  public String k;
  
  public PhotoParam()
  {
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_i_of_type_Int = 4;
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_j_of_type_Int = -1;
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_k_of_type_Int = 0;
    this.jdField_k_of_type_JavaLangString = "";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("PhotoParam{");
    localStringBuffer.append("loginUin=").append(this.jdField_a_of_type_Long);
    localStringBuffer.append(", feedUin=").append(this.jdField_b_of_type_Long);
    localStringBuffer.append(", ownerUin=").append(this.jdField_c_of_type_Long);
    localStringBuffer.append(", realOwnerUin=").append(this.jdField_d_of_type_Long);
    localStringBuffer.append(", albumanswer='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", albumid='").append(this.jdField_b_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", sortType=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", albumPriv=").append(this.jdField_b_of_type_Int);
    localStringBuffer.append(", albumnum=").append(this.jdField_c_of_type_Int);
    localStringBuffer.append(", uploadnum=").append(this.jdField_d_of_type_Int);
    localStringBuffer.append(", albumType=").append(this.jdField_e_of_type_Int);
    localStringBuffer.append(", businessPhotoFeedIndex=").append(this.jdField_f_of_type_Int);
    localStringBuffer.append(", qunid='").append(this.jdField_c_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", isLike=").append(this.jdField_a_of_type_Boolean);
    localStringBuffer.append(", likeNum=").append(this.jdField_g_of_type_Int);
    localStringBuffer.append(", commentNum=").append(this.jdField_h_of_type_Int);
    localStringBuffer.append(", curKey='").append(this.jdField_d_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", orgKey='").append(this.jdField_e_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", feedId='").append(this.jdField_f_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", cell_id='").append(this.jdField_g_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", cell_subId='").append(this.jdField_h_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", appid=").append(this.jdField_i_of_type_Int);
    localStringBuffer.append(", ugcKey='").append(this.jdField_i_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", canAddFavor=").append(this.jdField_b_of_type_Boolean);
    localStringBuffer.append(", subid=").append(this.jdField_j_of_type_Int);
    localStringBuffer.append(", isOnePictureFeed=").append(this.jdField_c_of_type_Boolean);
    localStringBuffer.append(", oneFeedPictruePath='").append(this.jdField_j_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", mFromRecent=").append(this.jdField_d_of_type_Boolean);
    localStringBuffer.append(", busi_param=").append(this.jdField_a_of_type_JavaUtilMap);
    localStringBuffer.append(", isTihFeed=").append(this.jdField_e_of_type_Boolean);
    localStringBuffer.append(", isOnlyPreView=").append(this.jdField_f_of_type_Boolean);
    localStringBuffer.append(", isFriendPhotoBizFeed=").append(this.jdField_g_of_type_Boolean);
    localStringBuffer.append(", isShareAlbum=").append(this.jdField_h_of_type_Boolean);
    localStringBuffer.append(", isVideoPicMix=").append(this.jdField_i_of_type_Boolean);
    localStringBuffer.append(", getPhotoExType=").append(this.jdField_k_of_type_Int);
    localStringBuffer.append(", sharer=").append(this.jdField_e_of_type_Long);
    localStringBuffer.append(", loginNickName='").append(this.jdField_k_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", qzoneUserType=").append(this.jdField_f_of_type_Long);
    localStringBuffer.append(", isSharedFeeds=").append(this.jdField_j_of_type_Boolean);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = 1;
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.jdField_g_of_type_Int);
      paramParcel.writeInt(this.jdField_h_of_type_Int);
      paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_i_of_type_Int);
      paramParcel.writeMap(this.jdField_a_of_type_JavaUtilMap);
      paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
      if (!this.jdField_b_of_type_Boolean) {
        break label380;
      }
      paramInt = 1;
      label209:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.jdField_j_of_type_Int);
      if (!this.jdField_c_of_type_Boolean) {
        break label385;
      }
      paramInt = 1;
      label231:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
      if (!this.jdField_d_of_type_Boolean) {
        break label390;
      }
      paramInt = 1;
      label253:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_e_of_type_Boolean) {
        break label395;
      }
      paramInt = 1;
      label267:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_f_of_type_Boolean) {
        break label400;
      }
      paramInt = 1;
      label281:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_g_of_type_Boolean) {
        break label405;
      }
      paramInt = 1;
      label295:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_h_of_type_Boolean) {
        break label410;
      }
      paramInt = 1;
      label309:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_i_of_type_Boolean) {
        break label415;
      }
      paramInt = 1;
      label323:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.jdField_k_of_type_Int);
      paramParcel.writeLong(this.jdField_e_of_type_Long);
      paramParcel.writeString(this.jdField_k_of_type_JavaLangString);
      paramParcel.writeLong(this.jdField_f_of_type_Long);
      if (!this.jdField_j_of_type_Boolean) {
        break label420;
      }
    }
    label385:
    label390:
    label395:
    label400:
    label405:
    label410:
    label415:
    label420:
    for (paramInt = m;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
      label380:
      paramInt = 0;
      break label209;
      paramInt = 0;
      break label231;
      paramInt = 0;
      break label253;
      paramInt = 0;
      break label267;
      paramInt = 0;
      break label281;
      paramInt = 0;
      break label295;
      paramInt = 0;
      break label309;
      paramInt = 0;
      break label323;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.PhotoParam
 * JD-Core Version:    0.7.0.1
 */