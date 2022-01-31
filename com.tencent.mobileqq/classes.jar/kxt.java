import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.av.business.manager.magicface.MagicfaceDataAudioJason;
import com.tencent.av.business.manager.magicface.MagicfaceDataPendantJason;
import com.tencent.av.business.manager.magicface.MagicfaceDataVideoJason;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class kxt
{
  protected MagicfaceDataAudioJason a;
  protected MagicfaceDataVideoJason a;
  protected String a;
  protected Map<String, MagicfaceDataPendantJason> a;
  protected Rect b;
  protected String b;
  protected int c;
  protected int d;
  
  public kxt(String paramString1, String paramString2, String paramString3)
  {
    krx.c("AVMagicfaceData", "init|config=" + paramString2 + "|" + paramString3 + "|" + paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString3;
    try
    {
      paramString1 = new JSONObject(paramString1);
      paramString2 = paramString1.getJSONObject("video");
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason = ((MagicfaceDataVideoJason)azxx.a(paramString2, MagicfaceDataVideoJason.class));
      int i;
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason != null)
      {
        if (!"voicesticker".equals(paramString3))
        {
          if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.location_x > 0)
          {
            paramString3 = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason;
            paramString3.location_x *= 2;
          }
          if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.location_y > 0)
          {
            paramString3 = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason;
            paramString3.location_y *= 2;
          }
          if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.width > 0)
          {
            paramString3 = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason;
            paramString3.width *= 2;
          }
          if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.height > 0)
          {
            paramString3 = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason;
            paramString3.height *= 2;
          }
        }
        paramString2 = paramString2.optJSONArray("locations");
        if (paramString2 != null)
        {
          i = 0;
          while (i < paramString2.length())
          {
            paramString3 = (JSONObject)paramString2.get(i);
            this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.pointArrayList.add(new Point(paramString3.optInt("x"), paramString3.optInt("y")));
            i += 1;
          }
        }
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.pointArrayList.add(new Point(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.location_x, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.location_y));
      }
      if (paramString1.has("audio")) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataAudioJason = ((MagicfaceDataAudioJason)azxx.a(paramString1.getJSONObject("audio"), MagicfaceDataAudioJason.class));
      }
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
      if (paramString1.has("pendant"))
      {
        paramString1 = paramString1.getJSONArray("pendant");
        i = j;
        while (i < paramString1.length())
        {
          paramString2 = (MagicfaceDataPendantJason)azxx.a((JSONObject)paramString1.get(i), MagicfaceDataPendantJason.class);
          if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2.name)))
          {
            krx.e("AVMagicfaceData", "Pendant: " + paramString2.toString());
            paramString2.duration *= 1000;
            this.jdField_a_of_type_JavaUtilMap.put(paramString2.name, paramString2);
          }
          i += 1;
        }
      }
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason == null)
      {
        krx.e("AVMagicfaceData", "MagicfaceData error!");
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason = new MagicfaceDataVideoJason();
      }
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataAudioJason == null) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataAudioJason = new MagicfaceDataAudioJason();
      }
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.persistent)
      {
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.repeat_count = 50000;
        if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.frame_count == 0) {
          this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.frame_count = 3;
        }
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataAudioJason.is_repeat = true;
      }
      krx.e("AVMagicfaceData", "MagicfaceData:: " + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.toString());
      this.c = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.frame_count;
      paramString1 = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.getLocation(-1);
      this.jdField_b_of_type_AndroidGraphicsRect = new Rect(paramString1.x, paramString1.y, paramString1.x + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.width, paramString1.y + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.height);
    }
  }
  
  protected abstract int a();
  
  int a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason == null) {
      return paramInt;
    }
    Point localPoint = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.getLocation(paramInt);
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect(localPoint.x, localPoint.y, localPoint.x + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.width, localPoint.y + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.height);
    return this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.lastLocationIndex;
  }
  
  protected abstract String a(int paramInt);
  
  protected abstract void a();
  
  protected abstract void a(int paramInt1, int paramInt2);
  
  public boolean a(kxt paramkxt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramkxt != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        if ((!TextUtils.isEmpty(paramkxt.jdField_b_of_type_JavaLangString)) && (!paramkxt.jdField_b_of_type_JavaLangString.equalsIgnoreCase("face")))
        {
          bool1 = bool2;
          if (!paramkxt.jdField_b_of_type_JavaLangString.equalsIgnoreCase("voicesticker")) {}
        }
        else
        {
          bool1 = bool2;
          if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("pendant")) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public abstract void b();
  
  public boolean b()
  {
    return (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("face")) || (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("voicesticker"));
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("pendant");
  }
  
  public String toString()
  {
    return "Id[" + this.jdField_a_of_type_JavaLangString + "], type[" + this.jdField_b_of_type_JavaLangString + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kxt
 * JD-Core Version:    0.7.0.1
 */