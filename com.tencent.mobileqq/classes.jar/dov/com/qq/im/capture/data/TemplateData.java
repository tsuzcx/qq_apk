package dov.com.qq.im.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.part.QIMTemplateItem;
import dov.com.qq.im.capture.paster.VotePasterQuestion;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class TemplateData
  implements Parcelable
{
  public static final Parcelable.Creator<TemplateData> CREATOR = new TemplateData.1();
  public int a;
  public String a;
  public List<QIMTemplateItem> a;
  public boolean a;
  public int b;
  public String b;
  public List<String> b;
  public boolean b;
  public String c;
  public List<VotePasterQuestion> c;
  
  protected TemplateData(Parcel paramParcel)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_JavaUtilList = paramParcel.createTypedArrayList(QIMTemplateItem.CREATOR);
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public TemplateData(JSONObject paramJSONObject)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name");
    this.jdField_a_of_type_Int = paramJSONObject.optInt("categoryId");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("default_combo_id");
    this.jdField_b_of_type_Boolean = "1".equals(paramJSONObject.optString("random_position", "0"));
    this.jdField_b_of_type_Int = paramJSONObject.optInt("hide_mask", 0);
    this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("introduction");
    if (paramJSONObject.has("content"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("content");
      ArrayList localArrayList = new ArrayList();
      int k = paramJSONObject.length();
      int i = 0;
      for (boolean bool = false; i < k; bool = true)
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        QIMTemplateItem localQIMTemplateItem = new QIMTemplateItem();
        localQIMTemplateItem.jdField_c_of_type_JavaLangString = localJSONObject.optString("iconUrl");
        localQIMTemplateItem.jdField_b_of_type_JavaLangString = localJSONObject.optString("name");
        localQIMTemplateItem.jdField_f_of_type_JavaLangString = localJSONObject.optString("camera");
        localQIMTemplateItem.jdField_a_of_type_JavaLangString = localJSONObject.optString("id");
        localQIMTemplateItem.jdField_e_of_type_JavaLangString = localJSONObject.optString("type_combo");
        localQIMTemplateItem.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localQIMTemplateItem.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        localQIMTemplateItem.g = localJSONObject.optString("cover_url");
        localQIMTemplateItem.h = localJSONObject.optString("video_url");
        localQIMTemplateItem.i = localJSONObject.optString("video_md5");
        localQIMTemplateItem.jdField_a_of_type_Boolean = localJSONObject.optBoolean("segments_twinkle");
        localQIMTemplateItem.j = (CaptureTemplateManager.jdField_b_of_type_JavaLangString + localQIMTemplateItem.jdField_b_of_type_JavaLangString + ".mp4");
        JSONArray localJSONArray = localJSONObject.optJSONArray("filters");
        if (localJSONArray != null)
        {
          int m = localJSONArray.length();
          int j = 0;
          if (j < m)
          {
            Object localObject = localJSONArray.getJSONObject(j);
            String str = ((JSONObject)localObject).optString("name");
            if (!TextUtils.isEmpty(str)) {
              localQIMTemplateItem.jdField_a_of_type_JavaUtilArrayList.add(str);
            }
            for (;;)
            {
              j += 1;
              break;
              localObject = ((JSONObject)localObject).optString("name_android");
              if (!TextUtils.isEmpty((CharSequence)localObject)) {
                localQIMTemplateItem.jdField_a_of_type_JavaUtilArrayList.add(localObject);
              }
            }
          }
        }
        localQIMTemplateItem.jdField_a_of_type_OrgJsonJSONArray = localJSONObject.optJSONArray("pasters");
        localQIMTemplateItem.jdField_b_of_type_OrgJsonJSONArray = localJSONObject.optJSONArray("musics");
        localQIMTemplateItem.jdField_c_of_type_OrgJsonJSONArray = localJSONObject.optJSONArray("ufaces");
        localQIMTemplateItem.jdField_d_of_type_OrgJsonJSONArray = localJSONObject.optJSONArray("texts");
        localQIMTemplateItem.jdField_e_of_type_OrgJsonJSONArray = localJSONObject.optJSONArray("transitions");
        localQIMTemplateItem.jdField_f_of_type_OrgJsonJSONArray = localJSONObject.optJSONArray("interactions");
        a(localQIMTemplateItem);
        localQIMTemplateItem.jdField_b_of_type_Boolean = true;
        localArrayList.add(localQIMTemplateItem);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilList = localArrayList;
      this.jdField_a_of_type_Boolean = bool;
    }
  }
  
  private void a(QIMTemplateItem paramQIMTemplateItem)
  {
    Object localObject1;
    if ((paramQIMTemplateItem != null) && (paramQIMTemplateItem.jdField_f_of_type_OrgJsonJSONArray != null))
    {
      if (paramQIMTemplateItem.jdField_a_of_type_Int != 1001) {
        break label104;
      }
      localObject1 = new ArrayList();
      j = paramQIMTemplateItem.jdField_f_of_type_OrgJsonJSONArray.length();
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          localJSONObject = paramQIMTemplateItem.jdField_f_of_type_OrgJsonJSONArray.optJSONObject(i);
          if (localJSONObject != null) {}
          try
          {
            ((List)localObject1).add(localJSONObject.optString("question"));
            i += 1;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              QLog.d("QTemplate", 1, "createTemplateSet exception", localException2);
            }
          }
        }
      }
      this.jdField_b_of_type_JavaUtilList = ((List)localObject1);
    }
    label104:
    while (paramQIMTemplateItem.jdField_a_of_type_Int != 1000)
    {
      JSONObject localJSONObject;
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramQIMTemplateItem.jdField_f_of_type_OrgJsonJSONArray.length();
    int i = 0;
    if (i < j)
    {
      localObject1 = paramQIMTemplateItem.jdField_f_of_type_OrgJsonJSONArray.optJSONObject(i);
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        String str2 = ((JSONObject)localObject1).optString("question");
        localObject1 = ((JSONObject)localObject1).optJSONArray("options");
        if ((localObject1 == null) || (((JSONArray)localObject1).length() != 2)) {
          break label282;
        }
        str1 = ((JSONArray)localObject1).get(0).toString();
        localObject1 = ((JSONArray)localObject1).get(1).toString();
        if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
          localArrayList.add(new VotePasterQuestion(str2, str1, (String)localObject1));
        }
      }
      catch (Exception localException1)
      {
        QLog.d("QTemplate", 1, "createTemplateSet exception", localException1);
        continue;
      }
      i += 1;
      break;
      this.jdField_c_of_type_JavaUtilList = localArrayList;
      return;
      label282:
      Object localObject2 = null;
      String str1 = null;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.data.TemplateData
 * JD-Core Version:    0.7.0.1
 */