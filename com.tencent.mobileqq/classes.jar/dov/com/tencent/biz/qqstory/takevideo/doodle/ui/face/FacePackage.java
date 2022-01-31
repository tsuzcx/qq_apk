package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import org.json.JSONObject;

public abstract class FacePackage
{
  public double a;
  private float a;
  @Deprecated
  public int a;
  public Drawable a;
  public final String a;
  public boolean a;
  public int b;
  public String b;
  private int c = 5;
  public String c;
  public String d;
  public String e;
  private String f;
  
  public FacePackage(@NonNull String paramString)
  {
    this.jdField_a_of_type_Float = 0.05F;
    this.jdField_a_of_type_Double = 1.0D;
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalStateException("FacePackage'id can not be null.");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public abstract String a();
  
  public abstract String a(int paramInt);
  
  public void a(String paramString)
  {
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      SLog.e("FacePackage", "config json is empty.");
      i = 0;
      if (i == 0)
      {
        SLog.e("FacePackage", "config json is illegal, use default value, type : %s", new Object[] { a() });
        if (!"NormalFacePackage".equals(a())) {
          break label248;
        }
        if (!"1".equals(this.jdField_a_of_type_JavaLangString)) {
          break label234;
        }
        this.c = 5;
        this.jdField_a_of_type_Float = 0.05F;
      }
    }
    for (;;)
    {
      for (;;)
      {
        this.f = null;
        return;
        try
        {
          JSONObject localJSONObject = new JSONObject(paramString);
          this.c = localJSONObject.getInt("amount");
          this.jdField_a_of_type_Float = Float.valueOf(localJSONObject.getString("spacing")).floatValue();
          this.jdField_a_of_type_Double = localJSONObject.optDouble("scale", 1.0D);
          if ((this.c < 1) || (this.jdField_a_of_type_Float < 0.0F) || (this.jdField_a_of_type_Float >= 0.5D))
          {
            SLog.e("FacePackage", "config json is illegal : %s", new Object[] { paramString });
            i = 0;
            break;
          }
          this.f = paramString;
          SLog.a("FacePackage", "parse config json success : %s", paramString);
          i = 1;
        }
        catch (Exception localException)
        {
          SLog.e("FacePackage", "parse config json error : " + paramString + ", exception : " + localException.toString());
          i = 0;
        }
      }
      break;
      label234:
      this.c = 5;
      this.jdField_a_of_type_Float = 0.05F;
      continue;
      label248:
      if (!"LocationFacePackage".equals(a())) {
        break label274;
      }
      this.c = 4;
      this.jdField_a_of_type_Float = 0.1F;
    }
    label274:
    throw new IllegalStateException("unknown face package, type:" + a());
  }
  
  public abstract int b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage
 * JD-Core Version:    0.7.0.1
 */