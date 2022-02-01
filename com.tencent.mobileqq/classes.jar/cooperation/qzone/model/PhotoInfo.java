package cooperation.qzone.model;

import NS_FASHION_FEEDS_TAG_PROTO.TagInfo;
import abkf;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bnal;
import bnjz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;

public class PhotoInfo
  extends abkf
  implements Parcelable
{
  public static final Parcelable.Creator<PhotoInfo> CREATOR = new bnal();
  public static int l;
  public static int m;
  public static int n;
  public float a;
  public int a;
  public long a;
  public GpsInfo4LocalImage a;
  public VideoInfo a;
  public Boolean a;
  public String a;
  public ArrayList<String> a;
  public Map<Integer, String> a;
  private WeakReference<Drawable> a;
  public boolean a;
  public float b;
  public int b;
  public long b;
  public Boolean b;
  public String b;
  public ArrayList<TagInfo> b;
  public Map<Integer, String> b;
  private WeakReference<Drawable> b;
  public boolean b;
  public long c;
  public Boolean c;
  public String c;
  public ArrayList<ImageTagInfo> c;
  public int d;
  public long d;
  public String d;
  public ArrayList<FaceData> d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public boolean e;
  public int f;
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
  public boolean k;
  public String l;
  public boolean l;
  public String m;
  public boolean m;
  public String n;
  public int o;
  public String o;
  public int p;
  public String p;
  public int q;
  public String q;
  public int r;
  public String r;
  public int s;
  public String s;
  public int t;
  public String t;
  public int u;
  public String u;
  public int v;
  public String v;
  public int w;
  public String w;
  public int x;
  
  static
  {
    jdField_m_of_type_Int = 1;
    jdField_n_of_type_Int = 2;
  }
  
  public PhotoInfo()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_f_of_type_Int = 1;
    this.jdField_h_of_type_Int = -1;
    this.jdField_k_of_type_Int = jdField_l_of_type_Int;
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_m_of_type_JavaLangString = "";
    this.jdField_n_of_type_JavaLangString = "";
    this.jdField_o_of_type_JavaLangString = "";
    this.jdField_p_of_type_JavaLangString = "";
    this.jdField_q_of_type_JavaLangString = "";
    this.jdField_r_of_type_JavaLangString = "";
    this.jdField_s_of_type_JavaLangString = "";
    this.jdField_t_of_type_JavaLangString = "";
    this.jdField_u_of_type_JavaLangString = "";
    this.jdField_v_of_type_JavaLangString = "";
    this.jdField_w_of_type_JavaLangString = "";
  }
  
  public int a()
  {
    return 0;
  }
  
  public Drawable a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
      return (Drawable)this.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    return null;
  }
  
  public void a(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(paramDrawable);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_i_of_type_Int & 0x4) > 0;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return true;
  }
  
  public Rect b()
  {
    return null;
  }
  
  public Drawable b()
  {
    if (this.jdField_b_of_type_MqqUtilWeakReference != null) {
      return (Drawable)this.jdField_b_of_type_MqqUtilWeakReference.get();
    }
    return null;
  }
  
  public boolean b()
  {
    if (!bnjz.a().b()) {}
    while ((this.jdField_i_of_type_Int != 32) && (this.jdField_i_of_type_Int != 16)) {
      return false;
    }
    return true;
  }
  
  public int c()
  {
    return 0;
  }
  
  public Drawable c()
  {
    Drawable localDrawable2 = b();
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 == null) {
      localDrawable1 = a();
    }
    return localDrawable1;
  }
  
  public int d()
  {
    return 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i2 = 1;
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      i1 = 1;
      paramParcel.writeInt(i1);
      paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
      paramParcel.writeMap(this.jdField_a_of_type_JavaUtilMap);
      paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
      paramParcel.writeInt(this.jdField_e_of_type_Int);
      paramParcel.writeInt(this.jdField_f_of_type_Int);
      paramParcel.writeInt(this.jdField_g_of_type_Int);
      paramParcel.writeInt(this.jdField_h_of_type_Int);
      paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneModelGpsInfo4LocalImage, paramInt);
      if (!this.jdField_b_of_type_Boolean) {
        break label556;
      }
      i1 = 1;
      label179:
      paramParcel.writeInt(i1);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeLong(this.jdField_b_of_type_Long);
      paramParcel.writeTypedList(this.jdField_c_of_type_JavaUtilArrayList);
      if (!this.jdField_h_of_type_Boolean) {
        break label561;
      }
      i1 = 1;
      label217:
      paramParcel.writeInt(i1);
      paramParcel.writeInt(this.jdField_k_of_type_Int);
      paramParcel.writeInt(this.jdField_i_of_type_Int);
      paramParcel.writeInt(this.jdField_o_of_type_Int);
      paramParcel.writeInt(this.jdField_p_of_type_Int);
      paramParcel.writeInt(this.jdField_q_of_type_Int);
      paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneModelVideoInfo, paramInt);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_r_of_type_Int);
      paramParcel.writeInt(this.jdField_s_of_type_Int);
      paramParcel.writeString(this.jdField_k_of_type_JavaLangString);
      paramParcel.writeLong(this.jdField_c_of_type_Long);
      paramParcel.writeInt(this.jdField_t_of_type_Int);
      paramParcel.writeString(this.jdField_l_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_m_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_n_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_u_of_type_Int);
      paramParcel.writeString(this.jdField_o_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_p_of_type_JavaLangString);
      paramParcel.writeMap(this.jdField_b_of_type_JavaUtilMap);
      if (!this.jdField_i_of_type_Boolean) {
        break label566;
      }
      paramInt = 1;
      label384:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.jdField_q_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_r_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_s_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_t_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_u_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_v_of_type_Int);
      paramParcel.writeInt(this.jdField_w_of_type_Int);
      if (!this.jdField_j_of_type_Boolean) {
        break label571;
      }
      paramInt = 1;
      label454:
      paramParcel.writeInt(paramInt);
      paramParcel.writeSerializable(this.jdField_d_of_type_JavaUtilArrayList);
      if (!this.jdField_k_of_type_Boolean) {
        break label576;
      }
      paramInt = 1;
      label476:
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.jdField_d_of_type_Long);
      if (!this.jdField_l_of_type_Boolean) {
        break label581;
      }
      paramInt = 1;
      label498:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.jdField_v_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_w_of_type_JavaLangString);
      if (!this.jdField_m_of_type_Boolean) {
        break label586;
      }
    }
    label556:
    label561:
    label566:
    label571:
    label576:
    label581:
    label586:
    for (paramInt = i2;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeList(this.jdField_b_of_type_JavaUtilArrayList);
      paramParcel.writeFloat(this.jdField_b_of_type_Float);
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label179;
      i1 = 0;
      break label217;
      paramInt = 0;
      break label384;
      paramInt = 0;
      break label454;
      paramInt = 0;
      break label476;
      paramInt = 0;
      break label498;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.PhotoInfo
 * JD-Core Version:    0.7.0.1
 */